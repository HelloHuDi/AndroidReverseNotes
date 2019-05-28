package com.tencent.mm.plugin.gif;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f {
    public final int[] noD = new int[6];

    public f(String str) {
        AppMethodBeat.i(62420);
        try {
            MMGIFJNI.recycle(MMGIFJNI.openByFilePath(str, this.noD));
            ab.i("MMGIFInfo", "width:%d height:%d", Integer.valueOf(this.noD[0]), Integer.valueOf(this.noD[1]));
            AppMethodBeat.o(62420);
        } catch (MMGIFException e) {
            ab.e("MMGIFInfo", bo.l(e));
            AppMethodBeat.o(62420);
        }
    }
}
