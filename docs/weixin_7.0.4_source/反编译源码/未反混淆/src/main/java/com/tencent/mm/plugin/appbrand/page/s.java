package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.j;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.io.InputStream;

public final class s {
    private static final j isz = new c();

    static {
        AppMethodBeat.i(87156);
        AppMethodBeat.o(87156);
    }

    public static Bitmap j(i iVar, String str) {
        AppMethodBeat.i(87155);
        if (iVar == null) {
            AppMethodBeat.o(87155);
            return null;
        }
        String yj = l.yj(str);
        if (bo.isNullOrNil(yj)) {
            AppMethodBeat.o(87155);
            return null;
        }
        String str2 = (iVar.hashCode() + 35) + yj;
        Bitmap kR = isz.kR(str2);
        if (kR == null || kR.isRecycled()) {
            InputStream d = aw.d(iVar, yj);
            if (d != null) {
                try {
                    if (d.available() > 0) {
                        kR = d.decodeStream(d);
                        if (kR == null || kR.isRecycled()) {
                            if (d != null) {
                                bo.b(d);
                            }
                            AppMethodBeat.o(87155);
                            return null;
                        }
                        isz.c(str2, kR);
                        if (d != null) {
                            bo.b(d);
                        }
                        AppMethodBeat.o(87155);
                        return kR;
                    }
                } catch (IOException e) {
                    ab.e("MicroMsg.AppBrandPageIconCache", "try decode icon e = %s", e);
                    if (d != null) {
                        bo.b(d);
                    }
                } catch (Throwable th) {
                    if (d != null) {
                        bo.b(d);
                    }
                    AppMethodBeat.o(87155);
                }
            }
            if (d != null) {
                bo.b(d);
            }
            AppMethodBeat.o(87155);
            return null;
        }
        AppMethodBeat.o(87155);
        return kR;
    }
}
