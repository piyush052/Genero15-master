package com.dexterous.genero15.coreteam.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yalantis
 */
public class Friend {
    private String avatar;
    private String nickname;
    private int background;
    private List<String> interests = new ArrayList<>();

    public Friend(String avatar, String nickname, int background, String... interest) {
        this.avatar = avatar;
        this.nickname = nickname;
        this.background = background;
        interests.addAll(Arrays.asList(interest));
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public int getBackground() {
        return background;
    }

    public List<String> getInterests() {
        return interests;
    }
}
