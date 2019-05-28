package com.tencent.qqvideo.proxy.api;

import android.content.Context;

public interface IPlayManager {
    void appToBack();

    void appToFront();

    String buildPlayURLMp4(int i);

    int cleanStorage();

    void deinit();

    int getCurrentOffset(int i);

    int getLocalServerPort();

    String getProxyVersion();

    int getTotalOffset(int i);

    int init(Context context, String str);

    int preLoad(int i, int i2);

    void setCookie(String str);

    int setMaxStorageSize(long j);

    void setNetWorkState(int i);

    void setPlayerState(int i);

    void setRemainTime(int i, int i2);

    void setUtilsObject(IUtils iUtils);

    int startPlay(String str, int i, String str2, long j, int i2);

    void stopPlay(int i);
}
