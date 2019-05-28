package com.tencent.mm.e;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    DEFAULT(0),
    DOODLE(2),
    MOSAIC(1),
    EMOJI_AND_TEXT(3),
    CROP_PHOTO(BaseClientBuilder.API_PRIORITY_OTHER),
    CROP_VIDEO(BaseClientBuilder.API_PRIORITY_OTHER);
    
    public int value;

    static {
        AppMethodBeat.o(116147);
    }

    private a(int i) {
        this.value = i;
    }
}
