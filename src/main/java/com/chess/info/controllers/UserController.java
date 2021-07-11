package com.chess.info.controllers;

import com.chess.info.constants.Constants;
import com.chess.info.constants.RequestConstants;
import com.chess.info.model.Country;
import com.chess.info.model.User;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/user")
    public String showUserInfo(@RequestParam("username") String username, Model model) throws UnirestException {
        //get user request
        HttpResponse<JsonNode> responseUser = Unirest.get(RequestConstants.GET_USER_INFO_REQUEST + username).asJson();
        JsonNode jsonUser = responseUser.getBody();
        final String GET_COUNTRY_INFO_REQUEST = jsonUser.getObject().getString(Constants.COUNTRY);
        HttpResponse<JsonNode> responseCountry = Unirest.get(GET_COUNTRY_INFO_REQUEST).asJson();
        JsonNode jsonCountry = responseCountry.getBody();
        User user = new User(
                new Country(jsonCountry.getObject().getString(Constants.CODE), jsonCountry.getObject().getString(Constants.NAME)),
                jsonUser.getObject().getLong(Constants.PLAYER_ID), jsonUser.getObject().getInt(Constants.FOLLOWERS),
                jsonUser.getObject().getLong(Constants.JOINED), jsonUser.getObject().getLong(Constants.LAST_ONLINE),
                jsonUser.getObject().getBoolean(Constants.IS_STREAMER), jsonUser.getObject().getString(Constants.URL),
                jsonUser.getObject().getString(Constants.USERNAME), jsonUser.getObject().getString(Constants.STATUS)
        );
        try {
            user.setAvatar(jsonUser.getObject().getString(Constants.AVATAR));
        } catch (JSONException e) {
            //logger will be here someday
            e.printStackTrace();
        }
        try {
            user.setFide(jsonUser.getObject().getInt(Constants.FIDE));
        } catch (JSONException e) {
            //logger will be here someday
            e.printStackTrace();
        }
        try {
            user.setTitle(jsonUser.getObject().getString(Constants.TITLE));
        } catch (JSONException e) {
            //logger will be here someday
            e.printStackTrace();
        }
        try {
            user.setTwitch_url(jsonUser.getObject().getString(Constants.TWITCH_URL));
        } catch (JSONException e) {
            //logger will be here someday
            e.printStackTrace();
        }
        model.addAttribute("user", user);
        return "user_info";
    }

}
