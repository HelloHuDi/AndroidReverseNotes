package com.tencent.p177mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.p1574f.C40612a;
import com.tencent.p177mm.sdk.p1574f.C44216b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.p1431a.C36638b;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.a */
abstract class C19443a extends C10296a<C38492q> {
    /* renamed from: Bk */
    public abstract boolean mo34579Bk(String str);

    /* renamed from: Bl */
    public abstract String mo34580Bl(String str);

    /* renamed from: Bm */
    public abstract void mo34581Bm(String str);

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        final C38492q c38492q = (C38492q) c2241c;
        final String optString = jSONObject.optString("filePath", "");
        if (C5046bo.isNullOrNil(optString)) {
            c38492q.mo6107M(i, mo73394j("fail filePath invalid", null));
        } else {
            C45673m.aNS().mo10302aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(114350);
                    if (c38492q.isRunning()) {
                        InputStream xt = c38492q.getRuntime().asE().mo34313xt(optString);
                        if (xt == null) {
                            try {
                                c38492q.mo6107M(i, C19443a.this.mo73394j("fail file not exists", null));
                            } catch (Throwable th) {
                                C5046bo.m7527b(xt);
                                AppMethodBeat.m2505o(114350);
                            }
                        } else {
                            String awJ = C36638b.awJ(optString);
                            if (C19443a.this.mo34579Bk(C44216b.anI(awJ))) {
                                awJ = C19443a.this.mo34580Bl(awJ);
                                boolean d = C19443a.m30119d(awJ, xt);
                                if (d) {
                                    C19443a.this.mo34581Bm(awJ);
                                    C40612a.m70043a(awJ, c38492q.getContext());
                                }
                                C38492q c38492q = c38492q;
                                int i = i;
                                C19443a c19443a = C19443a.this;
                                if (d) {
                                    awJ = "ok";
                                } else {
                                    awJ = "fail";
                                }
                                c38492q.mo6107M(i, c19443a.mo73394j(awJ, null));
                            } else {
                                c38492q.mo6107M(i, C19443a.this.mo73394j("fail invalid file type", null));
                                C5046bo.m7527b(xt);
                                AppMethodBeat.m2505o(114350);
                                return;
                            }
                        }
                        C5046bo.m7527b(xt);
                        AppMethodBeat.m2505o(114350);
                        return;
                    }
                    AppMethodBeat.m2505o(114350);
                }
            });
        }
    }

    C19443a() {
    }

    /* renamed from: d */
    static boolean m30119d(String str, InputStream inputStream) {
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
                        C5046bo.m7527b(fileOutputStream);
                        C5046bo.m7527b(inputStream);
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    C4990ab.m7413e("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "writeFile exp %s", e);
                    C5046bo.m7527b(fileOutputStream);
                    C5046bo.m7527b(inputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    C5046bo.m7527b(fileOutputStream);
                    C5046bo.m7527b(inputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
            C4990ab.m7413e("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "writeFile exp %s", e);
            C5046bo.m7527b(fileOutputStream);
            C5046bo.m7527b(inputStream);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            C5046bo.m7527b(fileOutputStream);
            C5046bo.m7527b(inputStream);
            throw th;
        }
    }
}
