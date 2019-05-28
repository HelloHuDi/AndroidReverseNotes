package com.tencent.ttpic.particlesystem2d;

import com.facebook.appevents.AppEventsConstants;

public class ParticleTemplate2D {
    double mEmitRate;
    String mIdx = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mLife = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    int mMaxCount;
    String mP0 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mP1 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mP2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mPosX = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mPosY = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mRotate = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    String mScale = AppEventsConstants.EVENT_PARAM_VALUE_NO;

    ParticleTemplate2D(int i, double d, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.mMaxCount = i;
        this.mEmitRate = d;
        this.mLife = str;
        this.mPosX = str2;
        this.mPosY = str3;
        this.mScale = str4;
        this.mRotate = str5;
        this.mP0 = str6;
        this.mP1 = str7;
        this.mP2 = str8;
    }
}
