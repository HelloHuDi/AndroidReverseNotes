package com.tencent.p177mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C18647c;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9677j;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.tencent.mm.plugin.appbrand.page.s */
public final class C38475s {
    private static final C9677j isz = new C18647c();

    static {
        AppMethodBeat.m2504i(87156);
        AppMethodBeat.m2505o(87156);
    }

    /* renamed from: j */
    public static Bitmap m65114j(C6750i c6750i, String str) {
        AppMethodBeat.m2504i(87155);
        if (c6750i == null) {
            AppMethodBeat.m2505o(87155);
            return null;
        }
        String yj = C42367l.m74945yj(str);
        if (C5046bo.isNullOrNil(yj)) {
            AppMethodBeat.m2505o(87155);
            return null;
        }
        String str2 = (c6750i.hashCode() + 35) + yj;
        Bitmap kR = isz.mo20997kR(str2);
        if (kR == null || kR.isRecycled()) {
            InputStream d = C33082aw.m54073d(c6750i, yj);
            if (d != null) {
                try {
                    if (d.available() > 0) {
                        kR = C5056d.decodeStream(d);
                        if (kR == null || kR.isRecycled()) {
                            if (d != null) {
                                C5046bo.m7527b(d);
                            }
                            AppMethodBeat.m2505o(87155);
                            return null;
                        }
                        isz.mo20995c(str2, kR);
                        if (d != null) {
                            C5046bo.m7527b(d);
                        }
                        AppMethodBeat.m2505o(87155);
                        return kR;
                    }
                } catch (IOException e) {
                    C4990ab.m7413e("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", e);
                    if (d != null) {
                        C5046bo.m7527b(d);
                    }
                } catch (Throwable th) {
                    if (d != null) {
                        C5046bo.m7527b(d);
                    }
                    AppMethodBeat.m2505o(87155);
                }
            }
            if (d != null) {
                C5046bo.m7527b(d);
            }
            AppMethodBeat.m2505o(87155);
            return null;
        }
        AppMethodBeat.m2505o(87155);
        return kR;
    }
}
