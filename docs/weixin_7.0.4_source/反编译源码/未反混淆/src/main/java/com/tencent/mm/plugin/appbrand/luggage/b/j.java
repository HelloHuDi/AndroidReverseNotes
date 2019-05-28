package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.bridge.impl.a.a;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.d.a.c;
import com.tencent.mm.plugin.appbrand.d.b;
import com.tencent.mm.plugin.appbrand.i;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;

public final class j extends a implements b {
    private final i gPI;

    public j(i iVar) {
        this.gPI = iVar;
    }

    public final String wP() {
        return "WxFileImageReader";
    }

    public final boolean match(String str) {
        AppMethodBeat.i(86988);
        if (str == null || !str.startsWith("wxfile://")) {
            AppMethodBeat.o(86988);
            return false;
        }
        AppMethodBeat.o(86988);
        return true;
    }

    public final Bitmap b(String str, Rect rect, c cVar) {
        e eVar = null;
        AppMethodBeat.i(86989);
        if (match(str)) {
            p asE = this.gPI.asE();
            if (asE == null) {
                AppMethodBeat.o(86989);
                return null;
            }
            File yg = asE.yg(str.substring(0, str.lastIndexOf("?appId=")));
            if (yg == null || !yg.exists()) {
                AppMethodBeat.o(86989);
                return null;
            }
            String absolutePath = yg.getAbsolutePath();
            if (!absolutePath.startsWith("file://")) {
                absolutePath = "file://".concat(String.valueOf(absolutePath));
            }
            if (rect != null) {
                eVar = new com.tencent.mm.plugin.appbrand.luggage.a.a(rect.left, rect.top, rect.width(), rect.height());
            }
            Bitmap a = com.tencent.mm.modelappbrand.a.b.abR().a(absolutePath, eVar);
            AppMethodBeat.o(86989);
            return a;
        }
        AppMethodBeat.o(86989);
        return null;
    }

    public final boolean a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str) {
        AppMethodBeat.i(86990);
        if (cVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(86990);
            return false;
        }
        boolean startsWith = str.startsWith("wxfile://");
        AppMethodBeat.o(86990);
        return startsWith;
    }

    public final String b(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str) {
        AppMethodBeat.i(86991);
        if (a(cVar, str)) {
            str = str + "?appId=" + cVar.getAppId();
            AppMethodBeat.o(86991);
            return str;
        }
        AppMethodBeat.o(86991);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(String str, com.tencent.mm.plugin.appbrand.d.a.a aVar) {
        byte[] bArr;
        Throwable th;
        Closeable closeable;
        AppMethodBeat.i(86992);
        byte[] bArr2 = new byte[0];
        if (match(str)) {
            p asE = this.gPI.asE();
            if (asE != null) {
                File yg = asE.yg(str.substring(0, str.lastIndexOf("?appId=")));
                if (yg != null && yg.exists()) {
                    String absolutePath = yg.getAbsolutePath();
                    if (!absolutePath.startsWith("file://")) {
                        absolutePath = "file://".concat(String.valueOf(absolutePath));
                    }
                    Closeable openRead;
                    try {
                        openRead = com.tencent.mm.vfs.e.openRead(absolutePath);
                        try {
                            byte[] k = com.tencent.luggage.g.i.k(openRead);
                            com.tencent.luggage.g.i.b(openRead);
                            bArr = k;
                        } catch (FileNotFoundException e) {
                            try {
                                d.c("Luggage.WxFileImageReader", "", new Object[0]);
                                com.tencent.luggage.g.i.b(openRead);
                                bArr = bArr2;
                                if (aVar != null) {
                                }
                                AppMethodBeat.o(86992);
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = openRead;
                                com.tencent.luggage.g.i.b(closeable);
                                AppMethodBeat.o(86992);
                                throw th;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        openRead = null;
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = null;
                        com.tencent.luggage.g.i.b(closeable);
                        AppMethodBeat.o(86992);
                        throw th;
                    }
                    if (aVar != null) {
                        aVar.Q(bArr);
                    }
                    AppMethodBeat.o(86992);
                }
            }
        }
        bArr = bArr2;
        if (aVar != null) {
        }
        AppMethodBeat.o(86992);
    }
}
