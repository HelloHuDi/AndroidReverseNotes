package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.appcache.aw;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 528;
    private static final String NAME = "compressImage";

    static class a {
        String result;
        boolean success;

        public a(boolean z, String str) {
            this.success = z;
            this.result = str;
        }
    }

    interface c {
        a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, int i);
    }

    static class b implements c {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x0125 A:{Splitter:B:7:0x0049, ExcHandler: OutOfMemoryError (r0_35 'e' java.lang.OutOfMemoryError)} */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0146 A:{Splitter:B:7:0x0049, ExcHandler: NullPointerException (r0_37 'e' java.lang.NullPointerException)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:35:0x0125, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:36:0x0126, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", r0);
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.d.a(false, "fail:compress image OOM");
            com.tencent.matrix.trace.core.AppMethodBeat.o(114354);
     */
        /* JADX WARNING: Missing block: B:37:0x0146, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:38:0x0147, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", r0);
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.d.a(false, "fail:compress image NPE");
            com.tencent.matrix.trace.core.AppMethodBeat.o(114354);
     */
        /* JADX WARNING: Missing block: B:41:0x018b, code skipped:
            r0 = e;
     */
        /* JADX WARNING: Missing block: B:42:0x018c, code skipped:
            r1 = r2;
     */
        /* JADX WARNING: Missing block: B:48:?, code skipped:
            return r0;
     */
        /* JADX WARNING: Missing block: B:49:?, code skipped:
            return r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, int i) {
            AppMethodBeat.i(114354);
            p asE = cVar.asE();
            a aVar;
            if (asE == null) {
                ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:fileSystem is null");
                aVar = new a(false, "fail:runtime fileSystem is null");
                AppMethodBeat.o(114354);
                return aVar;
            }
            File yg = cVar.asE().yg(str);
            if (yg == null) {
                ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
                aVar = new a(false, "fail:file doesn't exist");
                AppMethodBeat.o(114354);
                return aVar;
            }
            String str2 = null;
            try {
                Options options = new Options();
                Bitmap decodeFile = com.tencent.mm.plugin.appbrand.jsapi.media.b.a.a((b) cVar.B(b.class)).decodeFile(yg.getAbsolutePath(), options);
                if (decodeFile == null) {
                    ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
                    aVar = new a(false, "fail:decode image fail");
                    AppMethodBeat.o(114354);
                    return aVar;
                }
                String str3 = com.tencent.luggage.e.a.a.e(options) ? "jpg" : "png";
                String str4 = e.euR + "microMsg.tmp." + System.currentTimeMillis() + "." + str3;
                com.tencent.mm.sdk.platformtools.d.a(decodeFile, i, com.tencent.luggage.e.a.a.e(options) ? CompressFormat.JPEG : CompressFormat.PNG, str4, true);
                if (com.tencent.luggage.e.a.a.e(options)) {
                    com.tencent.mm.plugin.appbrand.g.b.bY(yg.getAbsolutePath(), str4);
                }
                j jVar = new j();
                if (asE.a(new File(str4), str3, false, jVar) != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                    ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
                    aVar = new a(false, "fail:create tmp file fail");
                    AppMethodBeat.o(114354);
                    return aVar;
                }
                ab.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", str4, jVar.value);
                a aVar2 = new a(true, (String) jVar.value);
                AppMethodBeat.o(114354);
                return aVar2;
            } catch (OutOfMemoryError e) {
            } catch (NullPointerException e2) {
            } catch (Exception e3) {
                Exception e4 = e3;
                ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", e4);
                com.tencent.mm.a.e.deleteFile(str2);
                aVar = new a(false, "fail:compress image exception");
                AppMethodBeat.o(114354);
                return aVar;
            }
        }
    }

    static class d implements c {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x013f A:{Splitter:B:12:0x006b, ExcHandler: OutOfMemoryError (r0_37 'e' java.lang.OutOfMemoryError)} */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0160 A:{Splitter:B:12:0x006b, ExcHandler: NullPointerException (r0_39 'e' java.lang.NullPointerException)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:40:0x013f, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:41:0x0140, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", r0);
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.d.a(false, "fail:compress image OOM");
            com.tencent.matrix.trace.core.AppMethodBeat.o(114355);
     */
        /* JADX WARNING: Missing block: B:42:0x0160, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:43:0x0161, code skipped:
            com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", r0);
            r0 = new com.tencent.mm.plugin.appbrand.jsapi.media.d.a(false, "fail:compress image NPE");
            com.tencent.matrix.trace.core.AppMethodBeat.o(114355);
     */
        /* JADX WARNING: Missing block: B:46:0x01a5, code skipped:
            r0 = e;
     */
        /* JADX WARNING: Missing block: B:47:0x01a6, code skipped:
            r1 = r2;
     */
        /* JADX WARNING: Missing block: B:54:?, code skipped:
            return r0;
     */
        /* JADX WARNING: Missing block: B:55:?, code skipped:
            return r0;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final a a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str, int i) {
            AppMethodBeat.i(114355);
            a aVar;
            if (cVar == null || !(cVar instanceof q)) {
                ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
                aVar = new a(false, "fail:internal error invalid js component");
                AppMethodBeat.o(114355);
                return aVar;
            }
            p asE = cVar.asE();
            if (asE == null) {
                ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
                aVar = new a(false, "fail:runtime fileSystem is null");
                AppMethodBeat.o(114355);
                return aVar;
            }
            InputStream d = aw.d(((q) cVar).getRuntime(), str);
            if (d == null) {
                ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
                aVar = new a(false, "fail:file doesn't exist");
                AppMethodBeat.o(114355);
                return aVar;
            }
            String str2 = null;
            try {
                Options options = new Options();
                Bitmap b = com.tencent.mm.plugin.appbrand.jsapi.media.b.a.a((b) cVar.B(b.class)).b(d, options);
                if (b == null) {
                    ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
                    aVar = new a(false, "fail:decode image fail");
                    AppMethodBeat.o(114355);
                    return aVar;
                }
                String str3 = com.tencent.luggage.e.a.a.e(options) ? "jpg" : "png";
                String str4 = e.euR + "microMsg.tmp." + System.currentTimeMillis() + "." + str3;
                com.tencent.mm.sdk.platformtools.d.a(b, i, com.tencent.luggage.e.a.a.e(options) ? CompressFormat.JPEG : CompressFormat.PNG, str4, true);
                if (com.tencent.luggage.e.a.a.e(options)) {
                    com.tencent.mm.plugin.appbrand.g.b.a(d, str4);
                }
                j jVar = new j();
                if (asE.a(new File(str4), str3, false, jVar) != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                    ab.w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
                    aVar = new a(false, "fail:create tmp file fail");
                    AppMethodBeat.o(114355);
                    return aVar;
                }
                ab.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", str4, jVar.value);
                a aVar2 = new a(true, (String) jVar.value);
                AppMethodBeat.o(114355);
                return aVar2;
            } catch (OutOfMemoryError e) {
            } catch (NullPointerException e2) {
            } catch (Exception e3) {
                Exception e4 = e3;
                ab.e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", e4);
                com.tencent.mm.a.e.deleteFile(str2);
                aVar = new a(false, "fail:compress image exception");
                AppMethodBeat.o(114355);
                return aVar;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(114356);
        if (cVar == null) {
            ab.e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
            AppMethodBeat.o(114356);
        } else if (jSONObject == null) {
            ab.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
            cVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(114356);
        } else {
            final String optString = jSONObject.optString("src");
            if (bo.isNullOrNil(optString)) {
                ab.w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
                cVar.M(i, j("fail:data src is null", null));
                AppMethodBeat.o(114356);
            } else if (cVar.asE() == null) {
                ab.w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
                cVar.M(i, j("fail:runtime fileSystem is null", null));
                AppMethodBeat.o(114356);
            } else {
                int optInt = jSONObject.optInt("quality", 80);
                if (optInt <= 0 || optInt > 100) {
                    ab.w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
                    optInt = 80;
                }
                ab.i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", Integer.valueOf(optInt), optString);
                final WeakReference weakReference = new WeakReference(cVar);
                final com.tencent.mm.plugin.appbrand.jsapi.c cVar2 = cVar;
                final int i2 = i;
                com.tencent.mm.sdk.g.d.f(new Runnable() {
                    public final void run() {
                        c dVar;
                        AppMethodBeat.i(114353);
                        if (bo.isNullOrNil(optString) || !optString.startsWith("wxfile://")) {
                            dVar = new d();
                        } else {
                            dVar = new b();
                        }
                        a a = dVar.a(cVar2, optString, optInt);
                        if (weakReference.get() == null || !((com.tencent.mm.plugin.appbrand.jsapi.c) weakReference.get()).isRunning()) {
                            ab.w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
                            AppMethodBeat.o(114353);
                            return;
                        }
                        com.tencent.mm.plugin.appbrand.jsapi.c cVar = (com.tencent.mm.plugin.appbrand.jsapi.c) weakReference.get();
                        if (!a.success && bo.isNullOrNil(a.result)) {
                            ab.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
                            cVar.M(i2, d.this.j("fail:compress image fail", null));
                            AppMethodBeat.o(114353);
                        } else if (a.success) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempFilePath", a.result);
                            cVar.M(i2, d.this.j("ok", hashMap));
                            AppMethodBeat.o(114353);
                        } else {
                            ab.w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", a.result);
                            cVar.M(i2, d.this.j(a.result, null));
                            AppMethodBeat.o(114353);
                        }
                    }
                }, String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", new Object[]{optString, Integer.valueOf(optInt)}));
                AppMethodBeat.o(114356);
            }
        }
    }
}
