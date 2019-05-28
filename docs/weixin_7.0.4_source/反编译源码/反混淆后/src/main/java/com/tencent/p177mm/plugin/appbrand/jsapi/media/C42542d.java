package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.luggage.p1589e.p1590a.C41710a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.C31304b.C31305a;
import com.tencent.p177mm.plugin.appbrand.p290g.C2154b;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.d */
public final class C42542d extends C10296a {
    private static final int CTRL_INDEX = 528;
    private static final String NAME = "compressImage";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.d$a */
    static class C10481a {
        String result;
        boolean success;

        public C10481a(boolean z, String str) {
            this.success = z;
            this.result = str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.d$c */
    interface C10482c {
        /* renamed from: a */
        C10481a mo21989a(C2241c c2241c, String str, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.d$b */
    static class C27035b implements C10482c {
        private C27035b() {
        }

        /* synthetic */ C27035b(byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x0125 A:{Splitter:B:7:0x0049, ExcHandler: OutOfMemoryError (r0_35 'e' java.lang.OutOfMemoryError)} */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0146 A:{Splitter:B:7:0x0049, ExcHandler: NullPointerException (r0_37 'e' java.lang.NullPointerException)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:35:0x0125, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:36:0x0126, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", r0);
            r0 = new com.tencent.p177mm.plugin.appbrand.jsapi.media.C42542d.C10481a(false, "fail:compress image OOM");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114354);
     */
        /* JADX WARNING: Missing block: B:37:0x0146, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:38:0x0147, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", r0);
            r0 = new com.tencent.p177mm.plugin.appbrand.jsapi.media.C42542d.C10481a(false, "fail:compress image NPE");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114354);
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
        /* renamed from: a */
        public final C10481a mo21989a(C2241c c2241c, String str, int i) {
            AppMethodBeat.m2504i(114354);
            C19092p asE = c2241c.asE();
            C10481a c10481a;
            if (asE == null) {
                C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:fileSystem is null");
                c10481a = new C10481a(false, "fail:runtime fileSystem is null");
                AppMethodBeat.m2505o(114354);
                return c10481a;
            }
            File yg = c2241c.asE().mo34314yg(str);
            if (yg == null) {
                C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
                c10481a = new C10481a(false, "fail:file doesn't exist");
                AppMethodBeat.m2505o(114354);
                return c10481a;
            }
            String str2 = null;
            try {
                Options options = new Options();
                Bitmap decodeFile = C31305a.m50560a((C31304b) c2241c.mo5936B(C31304b.class)).decodeFile(yg.getAbsolutePath(), options);
                if (decodeFile == null) {
                    C4990ab.m7412e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
                    c10481a = new C10481a(false, "fail:decode image fail");
                    AppMethodBeat.m2505o(114354);
                    return c10481a;
                }
                String str3 = C41710a.m73389e(options) ? "jpg" : "png";
                String str4 = C6457e.euR + "microMsg.tmp." + System.currentTimeMillis() + "." + str3;
                C5056d.m7625a(decodeFile, i, C41710a.m73389e(options) ? CompressFormat.JPEG : CompressFormat.PNG, str4, true);
                if (C41710a.m73389e(options)) {
                    C2154b.m4366bY(yg.getAbsolutePath(), str4);
                }
                C19681j c19681j = new C19681j();
                if (asE.mo5835a(new File(str4), str3, false, c19681j) != C45518j.OK) {
                    C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
                    c10481a = new C10481a(false, "fail:create tmp file fail");
                    AppMethodBeat.m2505o(114354);
                    return c10481a;
                }
                C4990ab.m7417i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", str4, c19681j.value);
                C10481a c10481a2 = new C10481a(true, (String) c19681j.value);
                AppMethodBeat.m2505o(114354);
                return c10481a2;
            } catch (OutOfMemoryError e) {
            } catch (NullPointerException e2) {
            } catch (Exception e3) {
                Exception e4 = e3;
                C4990ab.m7413e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", e4);
                C1173e.deleteFile(str2);
                c10481a = new C10481a(false, "fail:compress image exception");
                AppMethodBeat.m2505o(114354);
                return c10481a;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.d$d */
    static class C42543d implements C10482c {
        private C42543d() {
        }

        /* synthetic */ C42543d(byte b) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x013f A:{Splitter:B:12:0x006b, ExcHandler: OutOfMemoryError (r0_37 'e' java.lang.OutOfMemoryError)} */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0160 A:{Splitter:B:12:0x006b, ExcHandler: NullPointerException (r0_39 'e' java.lang.NullPointerException)} */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing block: B:40:0x013f, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:41:0x0140, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image OOM", r0);
            r0 = new com.tencent.p177mm.plugin.appbrand.jsapi.media.C42542d.C10481a(false, "fail:compress image OOM");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114355);
     */
        /* JADX WARNING: Missing block: B:42:0x0160, code skipped:
            r0 = move-exception;
     */
        /* JADX WARNING: Missing block: B:43:0x0161, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7413e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image NPE", r0);
            r0 = new com.tencent.p177mm.plugin.appbrand.jsapi.media.C42542d.C10481a(false, "fail:compress image NPE");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114355);
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
        /* renamed from: a */
        public final C10481a mo21989a(C2241c c2241c, String str, int i) {
            AppMethodBeat.m2504i(114355);
            C10481a c10481a;
            if (c2241c == null || !(c2241c instanceof C38492q)) {
                C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:not in service context");
                c10481a = new C10481a(false, "fail:internal error invalid js component");
                AppMethodBeat.m2505o(114355);
                return c10481a;
            }
            C19092p asE = c2241c.asE();
            if (asE == null) {
                C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:runtime fileSystem is null");
                c10481a = new C10481a(false, "fail:runtime fileSystem is null");
                AppMethodBeat.m2505o(114355);
                return c10481a;
            }
            InputStream d = C33082aw.m54073d(((C38492q) c2241c).getRuntime(), str);
            if (d == null) {
                C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:file doesn't exist");
                c10481a = new C10481a(false, "fail:file doesn't exist");
                AppMethodBeat.m2505o(114355);
                return c10481a;
            }
            String str2 = null;
            try {
                Options options = new Options();
                Bitmap b = C31305a.m50560a((C31304b) c2241c.mo5936B(C31304b.class)).mo21986b(d, options);
                if (b == null) {
                    C4990ab.m7412e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:decode image fail");
                    c10481a = new C10481a(false, "fail:decode image fail");
                    AppMethodBeat.m2505o(114355);
                    return c10481a;
                }
                String str3 = C41710a.m73389e(options) ? "jpg" : "png";
                String str4 = C6457e.euR + "microMsg.tmp." + System.currentTimeMillis() + "." + str3;
                C5056d.m7625a(b, i, C41710a.m73389e(options) ? CompressFormat.JPEG : CompressFormat.PNG, str4, true);
                if (C41710a.m73389e(options)) {
                    C2154b.m4365a(d, str4);
                }
                C19681j c19681j = new C19681j();
                if (asE.mo5835a(new File(str4), str3, false, c19681j) != C45518j.OK) {
                    C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:create tmp file fail");
                    c10481a = new C10481a(false, "fail:create tmp file fail");
                    AppMethodBeat.m2505o(114355);
                    return c10481a;
                }
                C4990ab.m7417i("MicroMsg.JsApiCompressImage.javayhu", "compressImage ok, dstPath:%s, tmpPath:%s", str4, c19681j.value);
                C10481a c10481a2 = new C10481a(true, (String) c19681j.value);
                AppMethodBeat.m2505o(114355);
                return c10481a2;
            } catch (OutOfMemoryError e) {
            } catch (NullPointerException e2) {
            } catch (Exception e3) {
                Exception e4 = e3;
                C4990ab.m7413e("MicroMsg.JsApiCompressImage.javayhu", "compressImage fail:compress image exception", e4);
                C1173e.deleteFile(str2);
                c10481a = new C10481a(false, "fail:compress image exception");
                AppMethodBeat.m2505o(114355);
                return c10481a;
            }
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(114356);
        if (c2241c == null) {
            C4990ab.m7412e("MicroMsg.JsApiCompressImage.javayhu", "fail:component is null");
            AppMethodBeat.m2505o(114356);
        } else if (jSONObject == null) {
            C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "fail:data is null");
            c2241c.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(114356);
        } else {
            final String optString = jSONObject.optString("src");
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "fail:data src is null");
                c2241c.mo6107M(i, mo73394j("fail:data src is null", null));
                AppMethodBeat.m2505o(114356);
            } else if (c2241c.asE() == null) {
                C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "fail:runtime fileSystem is null");
                c2241c.mo6107M(i, mo73394j("fail:runtime fileSystem is null", null));
                AppMethodBeat.m2505o(114356);
            } else {
                int optInt = jSONObject.optInt("quality", 80);
                if (optInt <= 0 || optInt > 100) {
                    C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "invalid quality, set to default");
                    optInt = 80;
                }
                C4990ab.m7417i("MicroMsg.JsApiCompressImage.javayhu", "compressImage, quality:%d, src:%s", Integer.valueOf(optInt), optString);
                final WeakReference weakReference = new WeakReference(c2241c);
                final C2241c c2241c2 = c2241c;
                final int i2 = i;
                C7305d.m12298f(new Runnable() {
                    public final void run() {
                        C10482c c42543d;
                        AppMethodBeat.m2504i(114353);
                        if (C5046bo.isNullOrNil(optString) || !optString.startsWith("wxfile://")) {
                            c42543d = new C42543d();
                        } else {
                            c42543d = new C27035b();
                        }
                        C10481a a = c42543d.mo21989a(c2241c2, optString, optInt);
                        if (weakReference.get() == null || !((C2241c) weakReference.get()).isRunning()) {
                            C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "worker:component is null");
                            AppMethodBeat.m2505o(114353);
                            return;
                        }
                        C2241c c2241c = (C2241c) weakReference.get();
                        if (!a.success && C5046bo.isNullOrNil(a.result)) {
                            C4990ab.m7420w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail");
                            c2241c.mo6107M(i2, C42542d.this.mo73394j("fail:compress image fail", null));
                            AppMethodBeat.m2505o(114353);
                        } else if (a.success) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempFilePath", a.result);
                            c2241c.mo6107M(i2, C42542d.this.mo73394j("ok", hashMap));
                            AppMethodBeat.m2505o(114353);
                        } else {
                            C4990ab.m7421w("MicroMsg.JsApiCompressImage.javayhu", "worker:compress image fail, message:%s", a.result);
                            c2241c.mo6107M(i2, C42542d.this.mo73394j(a.result, null));
                            AppMethodBeat.m2505o(114353);
                        }
                    }
                }, String.format(Locale.US, "AppBrandJsApiCompressImage[%s#%d]", new Object[]{optString, Integer.valueOf(optInt)}));
                AppMethodBeat.m2505o(114356);
            }
        }
    }
}
