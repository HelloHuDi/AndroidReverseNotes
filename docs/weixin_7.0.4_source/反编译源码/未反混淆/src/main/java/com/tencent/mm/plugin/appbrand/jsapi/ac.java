package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

public class ac<S extends q> extends a<S> {
    public static final int CTRL_INDEX = 250;
    public static final String NAME = "captureScreen";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(114322);
        q qVar = (q) cVar;
        ab.i("MicroMsg.JsApiCaptureScreen", "captureScreen, appId:%s", qVar.getAppId());
        com.tencent.mm.plugin.appbrand.page.q asV = qVar.getRuntime().asV();
        if (asV == null || asV.getPageView() == null) {
            ab.e("MicroMsg.JsApiCaptureScreen", "captureScreen, container or page is null");
            qVar.M(i, j("fail:container or page is null", null));
            AppMethodBeat.o(114322);
        } else if (asV.getPageView() == null) {
            ab.e("MicroMsg.JsApiCaptureScreen", "captureScreen, container or page is null");
            qVar.M(i, j("fail:container or page is null", null));
            AppMethodBeat.o(114322);
        } else {
            Bitmap b = b(qVar);
            if (b == null) {
                ab.e("MicroMsg.JsApiCaptureScreen", "bitmap is null, err return");
                qVar.M(i, j("fail:can't captureScreen", null));
                AppMethodBeat.o(114322);
                return;
            }
            j jVar = new j();
            if (qVar.asE().a(jVar) != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                qVar.M(i, j("fail:gen temp file failed", null));
                AppMethodBeat.o(114322);
                return;
            }
            String absolutePath = new File((String) jVar.value, "appbrand_capture_" + System.currentTimeMillis()).getAbsolutePath();
            ab.i("MicroMsg.JsApiCaptureScreen", "capture bitmap path:%s", absolutePath);
            try {
                d.a(b, 100, CompressFormat.PNG, absolutePath, true);
                j jVar2 = new j();
                if (qVar.asE().a(new File(absolutePath), "png", true, jVar2) != com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                    ab.w("MicroMsg.JsApiCaptureScreen", "create temp file failed, path:%s", absolutePath);
                    qVar.M(i, j("fail:gen temp file failed", null));
                    if (!(b == null || b.isRecycled())) {
                        ab.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                        b.recycle();
                    }
                    AppMethodBeat.o(114322);
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put("tempFilePath", jVar2.value);
                ab.i("MicroMsg.JsApiCaptureScreen", "capture bitmap tempFilePath:%s", jVar2.value);
                qVar.M(i, j("ok", hashMap));
                if (!(b == null || b.isRecycled())) {
                    ab.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                    b.recycle();
                }
                AppMethodBeat.o(114322);
            } catch (IOException e) {
                ab.w("MicroMsg.JsApiCaptureScreen", "save bitmap to file failed, . exception : %s", e);
                qVar.M(i, j("fail:IOException", null));
                if (!(b == null || b.isRecycled())) {
                    ab.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                    b.recycle();
                }
                AppMethodBeat.o(114322);
            } catch (Exception e2) {
                ab.w("MicroMsg.JsApiCaptureScreen", "save bitmap to file failed, . exception : %s", e2);
                qVar.M(i, j("fail:Exception", null));
                if (!(b == null || b.isRecycled())) {
                    ab.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                    b.recycle();
                }
                AppMethodBeat.o(114322);
            } catch (Throwable th) {
                if (!(b == null || b.isRecycled())) {
                    ab.i("MicroMsg.JsApiCaptureScreen", "bitmap recycle %s", b);
                    b.recycle();
                }
                AppMethodBeat.o(114322);
            }
        }
    }

    public Bitmap b(S s) {
        AppMethodBeat.i(114321);
        final u currentPageView = s.getCurrentPageView();
        if (currentPageView == null) {
            AppMethodBeat.o(114321);
            return null;
        }
        Bitmap bitmap = (Bitmap) new bj<Bitmap>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.i(114320);
                Bitmap aBo = currentPageView.aBo();
                AppMethodBeat.o(114320);
                return aBo;
            }
        }.b(new ak(Looper.getMainLooper()));
        AppMethodBeat.o(114321);
        return bitmap;
    }
}
