package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface v {

    public interface b {
        Bitmap vt(String str);
    }

    public enum a {
        NET,
        DISK;

        static {
            AppMethodBeat.o(79008);
        }
    }

    void V(String str, boolean z);

    Bitmap a(Bitmap bitmap, a aVar, String str);

    void a(a aVar, String str);

    b anI();

    String anJ();

    String anK();

    String anL();

    boolean anM();

    boolean anN();

    Bitmap anO();

    void anP();

    String getCacheKey();
}
