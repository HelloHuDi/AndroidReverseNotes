package com.tencent.p177mm.opensdk.diffdev;

/* renamed from: com.tencent.mm.opensdk.diffdev.IDiffDevOAuth */
public interface IDiffDevOAuth {
    void addListener(OAuthListener oAuthListener);

    boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener);

    void detach();

    void removeAllListeners();

    void removeListener(OAuthListener oAuthListener);

    boolean stopAuth();
}
