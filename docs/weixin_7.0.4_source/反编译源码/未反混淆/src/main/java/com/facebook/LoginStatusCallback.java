package com.facebook;

public interface LoginStatusCallback {
    void onCompleted(AccessToken accessToken);

    void onError(Exception exception);

    void onFailure();
}
