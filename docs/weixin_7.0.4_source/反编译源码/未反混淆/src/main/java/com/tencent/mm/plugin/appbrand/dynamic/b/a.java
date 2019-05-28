package com.tencent.mm.plugin.appbrand.dynamic.b;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.c;
import com.tencent.mm.modelappbrand.a.b.j;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.xweb.o;
import java.io.IOException;

public final class a {
    private static final j hmo = new c();

    static {
        AppMethodBeat.i(10768);
        AppMethodBeat.o(10768);
    }

    public static Bitmap bM(String str, String str2) {
        AppMethodBeat.i(10767);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(10767);
            return null;
        }
        String Cm = LaunchParcel.Cm(str2);
        if (bo.isNullOrNil(Cm)) {
            AppMethodBeat.o(10767);
            return null;
        }
        String str3 = str + '#' + Cm;
        Bitmap kR = hmo.kR(str3);
        if (kR == null || kR.isRecycled()) {
            o bS = com.tencent.mm.plugin.appbrand.dynamic.j.c.bS(str, Cm);
            if (bS != null) {
                try {
                    if (bS.mInputStream != null && bS.mInputStream.available() > 0) {
                        kR = d.decodeStream(bS.mInputStream);
                        if (kR == null || kR.isRecycled()) {
                            if (bS != null) {
                                bo.b(bS.mInputStream);
                            }
                            AppMethodBeat.o(10767);
                            return null;
                        }
                        hmo.c(str3, kR);
                        if (bS != null) {
                            bo.b(bS.mInputStream);
                        }
                        AppMethodBeat.o(10767);
                        return kR;
                    }
                } catch (IOException e) {
                    ab.e("MicroMsg.CanvasImageCache", "try decode icon e = %s", e);
                    if (bS != null) {
                        bo.b(bS.mInputStream);
                    }
                } catch (Throwable th) {
                    if (bS != null) {
                        bo.b(bS.mInputStream);
                    }
                    AppMethodBeat.o(10767);
                }
            }
            if (bS != null) {
                bo.b(bS.mInputStream);
            }
            AppMethodBeat.o(10767);
            return null;
        }
        AppMethodBeat.o(10767);
        return kR;
    }
}
