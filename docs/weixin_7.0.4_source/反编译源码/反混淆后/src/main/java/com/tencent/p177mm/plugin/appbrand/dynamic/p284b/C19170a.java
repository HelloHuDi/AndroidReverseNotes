package com.tencent.p177mm.plugin.appbrand.dynamic.p284b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C18647c;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9677j;
import com.tencent.p177mm.plugin.appbrand.dynamic.p289j.C2151c;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.xweb.C31147o;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.b.a */
public final class C19170a {
    private static final C9677j hmo = new C18647c();

    static {
        AppMethodBeat.m2504i(10768);
        AppMethodBeat.m2505o(10768);
    }

    /* renamed from: bM */
    public static Bitmap m29828bM(String str, String str2) {
        AppMethodBeat.m2504i(10767);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(10767);
            return null;
        }
        String Cm = LaunchParcel.m30355Cm(str2);
        if (C5046bo.isNullOrNil(Cm)) {
            AppMethodBeat.m2505o(10767);
            return null;
        }
        String str3 = str + '#' + Cm;
        Bitmap kR = hmo.mo20997kR(str3);
        if (kR == null || kR.isRecycled()) {
            C31147o bS = C2151c.m4364bS(str, Cm);
            if (bS != null) {
                try {
                    if (bS.mInputStream != null && bS.mInputStream.available() > 0) {
                        kR = C5056d.decodeStream(bS.mInputStream);
                        if (kR == null || kR.isRecycled()) {
                            if (bS != null) {
                                C5046bo.m7527b(bS.mInputStream);
                            }
                            AppMethodBeat.m2505o(10767);
                            return null;
                        }
                        hmo.mo20995c(str3, kR);
                        if (bS != null) {
                            C5046bo.m7527b(bS.mInputStream);
                        }
                        AppMethodBeat.m2505o(10767);
                        return kR;
                    }
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.CanvasImageCache", "try decode icon e = %s", e);
                    if (bS != null) {
                        C5046bo.m7527b(bS.mInputStream);
                    }
                } catch (Throwable th) {
                    if (bS != null) {
                        C5046bo.m7527b(bS.mInputStream);
                    }
                    AppMethodBeat.m2505o(10767);
                }
            }
            if (bS != null) {
                C5046bo.m7527b(bS.mInputStream);
            }
            AppMethodBeat.m2505o(10767);
            return null;
        }
        AppMethodBeat.m2505o(10767);
        return kR;
    }
}
