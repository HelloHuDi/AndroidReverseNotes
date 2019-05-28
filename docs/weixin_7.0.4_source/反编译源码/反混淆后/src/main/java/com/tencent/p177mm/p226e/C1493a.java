package com.tencent.p177mm.p226e;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.e.a */
public enum C1493a {
    DEFAULT(0),
    DOODLE(2),
    MOSAIC(1),
    EMOJI_AND_TEXT(3),
    CROP_PHOTO(BaseClientBuilder.API_PRIORITY_OTHER),
    CROP_VIDEO(BaseClientBuilder.API_PRIORITY_OTHER);
    
    public int value;

    static {
        AppMethodBeat.m2505o(116147);
    }

    private C1493a(int i) {
        this.value = i;
    }
}
