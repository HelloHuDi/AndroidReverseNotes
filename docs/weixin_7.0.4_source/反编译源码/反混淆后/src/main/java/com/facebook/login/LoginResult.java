package com.facebook.login;

import com.facebook.AccessToken;
import java.util.Set;

public class LoginResult {
    private final AccessToken accessToken;
    private final Set<String> recentlyDeniedPermissions;
    private final Set<String> recentlyGrantedPermissions;

    public LoginResult(AccessToken accessToken, Set<String> set, Set<String> set2) {
        this.accessToken = accessToken;
        this.recentlyGrantedPermissions = set;
        this.recentlyDeniedPermissions = set2;
    }

    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    public Set<String> getRecentlyGrantedPermissions() {
        return this.recentlyGrantedPermissions;
    }

    public Set<String> getRecentlyDeniedPermissions() {
        return this.recentlyDeniedPermissions;
    }
}
