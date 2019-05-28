package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.view.d;

public class Id3Util {
    public static int synchsafe(int i) {
        for (int i2 = d.MIC_SketchMark; (BaseClientBuilder.API_PRIORITY_OTHER ^ i2) > 0; i2 = ((i2 + 1) << 8) - 1) {
            i = (((i2 ^ -1) & i) << 1) | (i & i2);
        }
        return i;
    }

    public static int unsynchsafe(int i) {
        int i2 = 0;
        for (int i3 = 2130706432; i3 > 0; i3 >>= 8) {
            i2 = (i2 >> 1) | (i & i3);
        }
        return i2;
    }
}
