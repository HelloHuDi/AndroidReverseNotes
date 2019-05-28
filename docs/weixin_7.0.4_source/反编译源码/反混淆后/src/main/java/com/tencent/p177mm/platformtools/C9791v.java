package com.tencent.p177mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.platformtools.v */
public interface C9791v {

    /* renamed from: com.tencent.mm.platformtools.v$b */
    public interface C9792b {
        /* renamed from: vt */
        Bitmap mo9528vt(String str);
    }

    /* renamed from: com.tencent.mm.platformtools.v$a */
    public enum C9793a {
        NET,
        DISK;

        static {
            AppMethodBeat.m2505o(79008);
        }
    }

    /* renamed from: V */
    void mo9516V(String str, boolean z);

    /* renamed from: a */
    Bitmap mo9517a(Bitmap bitmap, C9793a c9793a, String str);

    /* renamed from: a */
    void mo9518a(C9793a c9793a, String str);

    C9792b anI();

    String anJ();

    String anK();

    String anL();

    boolean anM();

    boolean anN();

    Bitmap anO();

    void anP();

    String getCacheKey();
}
