package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class p {
    private final k unY;
    public final SparseArray<Object> unZ;
    public final SparseArray<Boolean> uoa;

    public static final class a {
        private static final p uob = new p();

        static {
            AppMethodBeat.i(6864);
            AppMethodBeat.o(6864);
        }
    }

    /* synthetic */ p(byte b) {
        this();
    }

    private p() {
        AppMethodBeat.i(6865);
        this.unY = new k();
        this.unZ = new SparseArray();
        this.uoa = new SparseArray();
        AppMethodBeat.o(6865);
    }

    public static boolean aeI(String str) {
        AppMethodBeat.i(6866);
        a.uob;
        bo.isNullOrNil(str);
        AppMethodBeat.o(6866);
        return false;
    }
}
