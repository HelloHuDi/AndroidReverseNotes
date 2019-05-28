package com.tencent.mm.model;

import com.tencent.map.lib.gl.JNI;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

@Deprecated
public class bw {
    static {
        AppMethodBeat.i(16350);
        k.a(JNI.LIB_NAME, bw.class.getClassLoader());
        AppMethodBeat.o(16350);
    }

    public final synchronized boolean a(String str, at atVar) {
        AppMethodBeat.i(16348);
        q mF = q.mF(str);
        if (mF == null) {
            mF = q.a(str, new q(atVar.getClass()));
        }
        mF.a(atVar);
        AppMethodBeat.o(16348);
        return true;
    }

    public static at oJ(String str) {
        AppMethodBeat.i(16349);
        q mF = q.mF(str);
        if (mF == null) {
            AppMethodBeat.o(16349);
            return null;
        }
        at Yw = mF.Yw();
        AppMethodBeat.o(16349);
        return Yw;
    }
}
