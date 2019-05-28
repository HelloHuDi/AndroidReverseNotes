package com.tencent.p177mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.b */
public final class C35619b {

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.b$2 */
    public static class C45582 implements ValueCallback<String> {
        public final /* synthetic */ void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(6915);
            C4990ab.m7417i("MicroMsg.CityServiceHelper", "injectJs, evaluateJavascript cb, ret = %s", (String) obj);
            AppMethodBeat.m2505o(6915);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.modeltools.b$1 */
    static class C72021 extends C4884c<C32519bf> {
        C72021() {
            AppMethodBeat.m2504i(6913);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(6913);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(6914);
            C32519bf c32519bf = (C32519bf) c4883b;
            if (c32519bf.cus.cut == 54 && c32519bf.cus.cuu == 1) {
                File file = new File(c32519bf.cus.filePath);
                if (file.exists()) {
                    String cYv = C35619b.cYv();
                    C4990ab.m7417i("MicroMsg.CityServiceHelper", "checkResUpdateListener callback to update %s,savePath %s", file.getAbsoluteFile(), cYv);
                    C1173e.deleteFile(cYv);
                    C1173e.m2577y(file.getAbsolutePath(), cYv);
                } else {
                    C4990ab.m7412e("MicroMsg.CityServiceHelper", "checkResUpdateListener file not exist");
                }
            }
            AppMethodBeat.m2505o(6914);
            return false;
        }
    }

    public static String cYv() {
        AppMethodBeat.m2504i(6916);
        File file = new File(C6457e.eSk.replace("/data/user/0", "/data/data"), "cityService/js");
        if (!file.exists()) {
            file.mkdirs();
        }
        String absolutePath = new File(file.getAbsoluteFile(), "analytics.js").getAbsolutePath();
        AppMethodBeat.m2505o(6916);
        return absolutePath;
    }

    /* renamed from: n */
    public static void m58464n(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(6917);
        String str3 = null;
        try {
            str3 = URLEncoder.encode(C5046bo.nullAsNil(str2), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.CityServiceHelper", e, "", new Object[0]);
        }
        C7060h.pYm.mo8381e(15650, str, str3, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(6917);
    }

    /* renamed from: up */
    public static void m58465up(int i) {
        AppMethodBeat.m2504i(6918);
        C7060h.pYm.mo8378a(894, (long) i, 1, false);
        AppMethodBeat.m2505o(6918);
    }
}
