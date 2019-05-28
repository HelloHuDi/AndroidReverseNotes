package com.tencent.p177mm.pluginsdk.p597ui.p598e;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;

/* renamed from: com.tencent.mm.pluginsdk.ui.e.q */
public final class C46506q {
    /* renamed from: BX */
    public static boolean m87789BX() {
        boolean z = true;
        AppMethodBeat.m2504i(28155);
        if (C1720g.m3534RN().mo5161QY()) {
            boolean z2 = (C5046bo.m7558gT(C4996ah.getContext()) || C5059g.cdf == 1 || C5046bo.getInt(C26373g.m41964Nu().getValue("ShowWeixinPBIntro"), 0) != 0 || C35799p.m58695u(C4996ah.getContext(), "com.tencent.pb")) ? false : true;
            if (z2) {
                int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3);
                C4990ab.m7419v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", Integer.valueOf(a));
                if (a <= 0) {
                    AppMethodBeat.m2505o(28155);
                    return false;
                }
                C1720g.m3536RP().mo5239Ry().set(352257, Integer.valueOf(a - 1));
                AppMethodBeat.m2505o(28155);
                return true;
            }
            String str = "MicroMsg.WxPhoneBookHelper";
            String str2 = "%b, %b, %b, %b";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(C5046bo.m7558gT(C4996ah.getContext()));
            if (C5059g.cdf != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (C5046bo.getInt(C26373g.m41964Nu().getValue("ShowWeixinPBIntro"), 0) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            if (C35799p.m58695u(C4996ah.getContext(), "com.tencent.pb")) {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            C4990ab.m7411d(str, str2, objArr);
            AppMethodBeat.m2505o(28155);
            return false;
        }
        C4990ab.m7412e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
        AppMethodBeat.m2505o(28155);
        return false;
    }

    public static void dli() {
        AppMethodBeat.m2504i(28156);
        C4990ab.m7419v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", Integer.valueOf(C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3)));
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WXPHONE_PB_COUNT_INT, Integer.valueOf(r0 - 1));
        AppMethodBeat.m2505o(28156);
    }

    /* renamed from: h */
    public static void m87790h(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(28157);
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        C7060h.pYm.mo8381e(11621, Integer.valueOf(i), Integer.valueOf(0));
        FileDownloadTaskInfo Is = C2896d.bij().mo7041Is("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
        if (Is == null || Is.status != 3) {
            C23639t.makeText(context, context.getString(C25738R.string.and), 2000).show();
            C2901a c2901a = new C2901a();
            c2901a.mo7055It("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
            c2901a.mo7057Iv(context.getString(C25738R.string.anj));
            c2901a.mo7069tN(1);
            c2901a.mo7063ga(true);
            C2896d.bij().mo7042a(c2901a.kNl);
            AppMethodBeat.m2505o(28157);
            return;
        }
        C4990ab.m7416i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
        if (C1173e.m2561ct(Is.path)) {
            C35800q.m58697a(context, Uri.fromFile(new File(Is.path)), null);
        }
        AppMethodBeat.m2505o(28157);
    }
}
