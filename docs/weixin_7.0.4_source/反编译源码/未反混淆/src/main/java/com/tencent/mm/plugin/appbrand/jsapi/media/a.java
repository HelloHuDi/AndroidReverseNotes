package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.a.b;
import org.json.JSONObject;

abstract class a extends com.tencent.mm.plugin.appbrand.jsapi.a<q> {
    public abstract boolean Bk(String str);

    public abstract String Bl(String str);

    public abstract void Bm(String str);

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        final q qVar = (q) cVar;
        final String optString = jSONObject.optString("filePath", "");
        if (bo.isNullOrNil(optString)) {
            qVar.M(i, j("fail filePath invalid", null));
        } else {
            m.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(114350);
                    if (qVar.isRunning()) {
                        InputStream xt = qVar.getRuntime().asE().xt(optString);
                        if (xt == null) {
                            try {
                                qVar.M(i, a.this.j("fail file not exists", null));
                            } catch (Throwable th) {
                                bo.b(xt);
                                AppMethodBeat.o(114350);
                            }
                        } else {
                            String awJ = b.awJ(optString);
                            if (a.this.Bk(com.tencent.mm.sdk.f.b.anI(awJ))) {
                                awJ = a.this.Bl(awJ);
                                boolean d = a.d(awJ, xt);
                                if (d) {
                                    a.this.Bm(awJ);
                                    com.tencent.mm.sdk.f.a.a(awJ, qVar.getContext());
                                }
                                q qVar = qVar;
                                int i = i;
                                a aVar = a.this;
                                if (d) {
                                    awJ = "ok";
                                } else {
                                    awJ = "fail";
                                }
                                qVar.M(i, aVar.j(awJ, null));
                            } else {
                                qVar.M(i, a.this.j("fail invalid file type", null));
                                bo.b(xt);
                                AppMethodBeat.o(114350);
                                return;
                            }
                        }
                        bo.b(xt);
                        AppMethodBeat.o(114350);
                        return;
                    }
                    AppMethodBeat.o(114350);
                }
            });
        }
    }

    a() {
    }

    static boolean d(String str, InputStream inputStream) {
        Exception e;
        Throwable th;
        Closeable fileOutputStream;
        try {
            File file = new File(str);
            file.getParentFile().mkdirs();
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr, 0, 4096);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        bo.b(fileOutputStream);
                        bo.b(inputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    ab.e("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "writeFile exp %s", e);
                    bo.b(fileOutputStream);
                    bo.b(inputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    bo.b(fileOutputStream);
                    bo.b(inputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            ab.e("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "writeFile exp %s", e);
            bo.b(fileOutputStream);
            bo.b(inputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bo.b(fileOutputStream);
            bo.b(inputStream);
            throw th;
        }
    }
}
