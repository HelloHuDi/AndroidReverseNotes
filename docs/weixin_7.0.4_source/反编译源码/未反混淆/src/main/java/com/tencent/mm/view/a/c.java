package com.tencent.mm.view.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo.a;

@l(dWo = {1, 1, 13})
public final /* synthetic */ class c {
    public static final /* synthetic */ int[] eQZ;

    static {
        AppMethodBeat.i(63328);
        int[] iArr = new int[a.values().length];
        eQZ = iArr;
        iArr[a.STATUS_SUCCESS.ordinal()] = 1;
        eQZ[a.STATUS_MIXING.ordinal()] = 2;
        eQZ[a.STATUS_UPLOADING.ordinal()] = 3;
        eQZ[a.STATUS_MIX_FAIL.ordinal()] = 4;
        eQZ[a.STATUS_UPLOAD_FAIL.ordinal()] = 5;
        AppMethodBeat.o(63328);
    }
}
