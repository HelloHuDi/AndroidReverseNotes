package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.bridge.impl.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.AnonymousClass3;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.i;
import com.tencent.mm.plugin.appbrand.d.a;

public final class g extends c {
    public final boolean match(String str) {
        AppMethodBeat.i(86985);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(86985);
            return false;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://")) {
            AppMethodBeat.o(86985);
            return true;
        }
        AppMethodBeat.o(86985);
        return false;
    }

    public final Bitmap b(String str, Rect rect, final a.c cVar) {
        AppMethodBeat.i(86986);
        if (match(str)) {
            e aVar;
            if (rect != null) {
                aVar = new com.tencent.mm.plugin.appbrand.luggage.a.a(rect.left, rect.top, rect.width(), rect.height());
            } else {
                aVar = null;
            }
            Bitmap a = b.abR().a(str, aVar);
            if (a == null) {
                b.abR().a(new i() {
                    public final void abU() {
                    }

                    public final void x(Bitmap bitmap) {
                        AppMethodBeat.i(86982);
                        if (cVar == null) {
                            AppMethodBeat.o(86982);
                        } else if (bitmap == null || bitmap.isRecycled()) {
                            cVar.E(null);
                            AppMethodBeat.o(86982);
                        } else {
                            cVar.E(bitmap);
                            AppMethodBeat.o(86982);
                        }
                    }

                    public final void mr() {
                        AppMethodBeat.i(86983);
                        if (cVar == null) {
                            AppMethodBeat.o(86983);
                            return;
                        }
                        cVar.E(null);
                        AppMethodBeat.o(86983);
                    }

                    public final String wP() {
                        return "WxaIcon";
                    }
                }, str, null, aVar);
            }
            AppMethodBeat.o(86986);
            return a;
        }
        AppMethodBeat.o(86986);
        return null;
    }

    public final void a(String str, final a.a aVar) {
        AppMethodBeat.i(86987);
        if (match(str)) {
            b abR = b.abR();
            AnonymousClass2 anonymousClass2 = new h() {
                public final void Q(byte[] bArr) {
                    AppMethodBeat.i(86984);
                    if (aVar != null) {
                        aVar.Q(bArr);
                    }
                    AppMethodBeat.o(86984);
                }
            };
            byte[] pD = abR.pD(str);
            if (pD == null || pD.length == 0) {
                abR.a(new AnonymousClass3(str, anonymousClass2), str, null);
                AppMethodBeat.o(86987);
                return;
            }
            anonymousClass2.Q(pD);
            AppMethodBeat.o(86987);
            return;
        }
        AppMethodBeat.o(86987);
    }
}
