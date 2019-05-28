package com.tencent.mm.pluginsdk.ui.e;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.t;
import java.io.File;

public final class q {
    public static boolean BX() {
        boolean z = true;
        AppMethodBeat.i(28155);
        if (g.RN().QY()) {
            boolean z2 = (bo.gT(ah.getContext()) || com.tencent.mm.sdk.platformtools.g.cdf == 1 || bo.getInt(com.tencent.mm.m.g.Nu().getValue("ShowWeixinPBIntro"), 0) != 0 || p.u(ah.getContext(), "com.tencent.pb")) ? false : true;
            if (z2) {
                int a = bo.a((Integer) g.RP().Ry().get(a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3);
                ab.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", Integer.valueOf(a));
                if (a <= 0) {
                    AppMethodBeat.o(28155);
                    return false;
                }
                g.RP().Ry().set(352257, Integer.valueOf(a - 1));
                AppMethodBeat.o(28155);
                return true;
            }
            String str = "MicroMsg.WxPhoneBookHelper";
            String str2 = "%b, %b, %b, %b";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(bo.gT(ah.getContext()));
            if (com.tencent.mm.sdk.platformtools.g.cdf != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("ShowWeixinPBIntro"), 0) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            if (p.u(ah.getContext(), "com.tencent.pb")) {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            ab.d(str, str2, objArr);
            AppMethodBeat.o(28155);
            return false;
        }
        ab.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
        AppMethodBeat.o(28155);
        return false;
    }

    public static void dli() {
        AppMethodBeat.i(28156);
        ab.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", Integer.valueOf(bo.a((Integer) g.RP().Ry().get(a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3)));
        g.RP().Ry().set(a.USERINFO_WXPHONE_PB_COUNT_INT, Integer.valueOf(r0 - 1));
        AppMethodBeat.o(28156);
    }

    public static void h(Context context, Bundle bundle) {
        AppMethodBeat.i(28157);
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        h.pYm.e(11621, Integer.valueOf(i), Integer.valueOf(0));
        FileDownloadTaskInfo Is = d.bij().Is("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
        if (Is == null || Is.status != 3) {
            t.makeText(context, context.getString(R.string.and), 2000).show();
            e.a aVar = new e.a();
            aVar.It("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
            aVar.Iv(context.getString(R.string.anj));
            aVar.tN(1);
            aVar.ga(true);
            d.bij().a(aVar.kNl);
            AppMethodBeat.o(28157);
            return;
        }
        ab.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
        if (com.tencent.mm.a.e.ct(Is.path)) {
            com.tencent.mm.pluginsdk.model.app.q.a(context, Uri.fromFile(new File(Is.path)), null);
        }
        AppMethodBeat.o(28157);
    }
}
