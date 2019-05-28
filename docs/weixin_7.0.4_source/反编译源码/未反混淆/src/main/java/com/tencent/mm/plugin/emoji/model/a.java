package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;

public final class a {
    public EmotionBannerSet kUY;
    public EmotionBanner kUZ;
    public boolean kVa = false;

    public a(EmotionBanner emotionBanner, EmotionBannerSet emotionBannerSet, boolean z) {
        this.kUZ = emotionBanner;
        this.kUY = emotionBannerSet;
        this.kVa = z;
    }
}
