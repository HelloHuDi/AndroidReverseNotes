package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ac */
public class C33229ac<S extends C38492q> extends C10296a<S> {
    public static final int CTRL_INDEX = 250;
    public static final String NAME = "captureScreen";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(114322);
        C38492q c38492q = (C38492q) c2241c;
        C4990ab.m7417i("MicroMsg.JsApiCaptureScreen", "captureScreen, appId:%s", c38492q.getAppId());
        C38470q asV = c38492q.getRuntime().asV();
        if (asV == null || asV.getPageView() == null) {
            C4990ab.m7412e("MicroMsg.JsApiCaptureScreen", "captureScreen, container or page is null");
            c38492q.mo6107M(i, mo73394j("fail:container or page is null", null));
            AppMethodBeat.m2505o(114322);
        } else if (asV.getPageView() == null) {
            C4990ab.m7412e("MicroMsg.JsApiCaptureScreen", "captureScreen, container or page is null");
            c38492q.mo6107M(i, mo73394j("fail:container or page is null", null));
            AppMethodBeat.m2505o(114322);
        } else {
            Bitmap b = mo34478b(c38492q);
            if (b == null) {
                C4990ab.m7412e("MicroMsg.JsApiCaptureScreen", "bitmap is null, err return");
                c38492q.mo6107M(i, mo73394j("fail:can't captureScreen", null));
                AppMethodBeat.m2505o(114322);
                return;
            }
            C19681j c19681j = new C19681j();
            if (c38492q.asE().mo5833a(c19681j) != C45518j.OK) {
                c38492q.mo6107M(i, mo73394j("fail:gen temp file failed", null));
                AppMethodBeat.m2505o(114322);
                return;
            }
            String absolutePath = new File((String) c19681j.value, "appbrand_capture_" + System.currentTimeMillis()).getAbsolutePath();
            C4990ab.m7417i("MicroMsg.JsApiCaptureScreen", "capture bitmap path:%s", absolutePath);
            try {
                C5056d.m7625a(b, 100, CompressFormat.PNG, absolutePath, true);
                C19681j c19681j2 = new C19681j();
                if (c38492q.asE().mo5835a(new File(absolutePath), "png", true, c19681j2) != C45518j.OK) {
                    C4990ab.m7421w("MicroMsg.JsApiCaptureScreen", "create temp file failed, path:%s", absolutePath);
                    c38492q.mo6107M(i, mo73394j("fail:gen temp file failed", null));
                    if (!(b == null || b.isRecycled())) {
                        C4990ab.m7417i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                        b.recycle();
                    }
                    AppMethodBeat.m2505o(114322);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", c19681j2.value);
                C4990ab.m7417i("MicroMsg.JsApiCaptureScreen", "capture bitmap tempFilePath:%s", c19681j2.value);
                c38492q.mo6107M(i, mo73394j("ok", hashMap));
                if (!(b == null || b.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                    b.recycle();
                }
                AppMethodBeat.m2505o(114322);
            } catch (IOException e) {
                C4990ab.m7421w("MicroMsg.JsApiCaptureScreen", "save bitmap to file failed, . exception : %s", e);
                c38492q.mo6107M(i, mo73394j("fail:IOException", null));
                if (!(b == null || b.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                    b.recycle();
                }
                AppMethodBeat.m2505o(114322);
            } catch (Exception e2) {
                C4990ab.m7421w("MicroMsg.JsApiCaptureScreen", "save bitmap to file failed, . exception : %s", e2);
                c38492q.mo6107M(i, mo73394j("fail:Exception", null));
                if (!(b == null || b.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                    b.recycle();
                }
                AppMethodBeat.m2505o(114322);
            } catch (Throwable th) {
                if (!(b == null || b.isRecycled())) {
                    C4990ab.m7417i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                    b.recycle();
                }
                AppMethodBeat.m2505o(114322);
            }
        }
    }

    /* renamed from: b */
    public Bitmap mo34478b(S s) {
        AppMethodBeat.m2504i(114321);
        final C44709u currentPageView = s.getCurrentPageView();
        if (currentPageView == null) {
            AppMethodBeat.m2505o(114321);
            return null;
        }
        Bitmap bitmap = (Bitmap) new C5039bj<Bitmap>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(114320);
                Bitmap aBo = currentPageView.aBo();
                AppMethodBeat.m2505o(114320);
                return aBo;
            }
        }.mo10372b(new C7306ak(Looper.getMainLooper()));
        AppMethodBeat.m2505o(114321);
        return bitmap;
    }
}
