package com.tencent.mm.pluginsdk.ui.tools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class i {
    private static void a(Bundle bundle, BaseResp baseResp, f fVar) {
        AppMethodBeat.i(79949);
        baseResp.toBundle(bundle);
        Args args = new Args();
        args.targetPkgName = fVar.field_packageName;
        args.bundle = bundle;
        p.at(bundle);
        p.au(bundle);
        MMessageActV2.send(ah.getContext(), args);
        AppMethodBeat.o(79949);
    }

    public static boolean c(String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.i(79948);
        f bT = g.bT(str3, true);
        if (bT == null) {
            ab.e("MicroMsg.OpenBusinessViewUtil", "launchBackApp info is null");
            AppMethodBeat.o(79948);
            return false;
        }
        Bundle bundle = new Bundle();
        Resp resp = new Resp(bundle);
        resp.extMsg = str2;
        resp.errStr = str4;
        resp.openId = bT.field_openId;
        resp.errCode = i;
        resp.businessType = str;
        a(bundle, resp, bT);
        AppMethodBeat.o(79948);
        return true;
    }
}
