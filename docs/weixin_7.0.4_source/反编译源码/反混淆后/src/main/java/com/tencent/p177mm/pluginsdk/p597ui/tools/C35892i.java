package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelbase.BaseResp;
import com.tencent.p177mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.i */
public final class C35892i {
    /* renamed from: a */
    private static void m58840a(Bundle bundle, BaseResp baseResp, C40439f c40439f) {
        AppMethodBeat.m2504i(79949);
        baseResp.toBundle(bundle);
        Args args = new Args();
        args.targetPkgName = c40439f.field_packageName;
        args.bundle = bundle;
        C35799p.m58687at(bundle);
        C35799p.m58688au(bundle);
        MMessageActV2.send(C4996ah.getContext(), args);
        AppMethodBeat.m2505o(79949);
    }

    /* renamed from: c */
    public static boolean m58841c(String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.m2504i(79948);
        C40439f bT = C46494g.m87739bT(str3, true);
        if (bT == null) {
            C4990ab.m7412e("MicroMsg.OpenBusinessViewUtil", "launchBackApp info is null");
            AppMethodBeat.m2505o(79948);
            return false;
        }
        Bundle bundle = new Bundle();
        Resp resp = new Resp(bundle);
        resp.extMsg = str2;
        resp.errStr = str4;
        resp.openId = bT.field_openId;
        resp.errCode = i;
        resp.businessType = str;
        C35892i.m58840a(bundle, resp, bT);
        AppMethodBeat.m2505o(79948);
        return true;
    }
}
