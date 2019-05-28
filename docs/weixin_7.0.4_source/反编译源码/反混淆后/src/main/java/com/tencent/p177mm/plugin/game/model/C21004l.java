package com.tencent.p177mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C9497vv;
import com.tencent.p177mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.p177mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.model.l */
public final class C21004l {
    /* renamed from: a */
    public static void m32302a(Activity activity, String str, Intent intent) {
        AppMethodBeat.m2504i(111273);
        if (C5046bo.isNullOrNil(str) || intent == null) {
            AppMethodBeat.m2505o(111273);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
        ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
        C28229n bEo = C39215q.bEo();
        if (bEo == null) {
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            bEo = C39215q.bEs();
        }
        intent.putExtra("rawUrl", C21004l.m32301a(str, bEo));
        if (booleanExtra) {
            C21004l.m32303a(activity, intent, "game_center_entrance", true, bEo, intExtra);
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            C39215q.bEt();
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            C39215q.bEn();
            AppMethodBeat.m2505o(111273);
            return;
        }
        C21004l.m32303a(activity, intent, "game_center_entrance", false, bEo, intExtra);
        AppMethodBeat.m2505o(111273);
    }

    /* renamed from: b */
    public static void m32305b(Activity activity, String str, Intent intent) {
        AppMethodBeat.m2504i(111274);
        if (C5046bo.isNullOrNil(str) || intent == null) {
            AppMethodBeat.m2505o(111274);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
        ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
        C28229n bEo = C39215q.bEo();
        if (bEo == null) {
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            bEo = C39215q.bEs();
        }
        intent.putExtra("rawUrl", C21004l.m32301a(str, bEo));
        if (booleanExtra) {
            C21004l.m32306b(activity, intent, "game_center_entrance", true, bEo, intExtra);
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            C39215q.bEt();
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            C39215q.bEn();
            AppMethodBeat.m2505o(111274);
            return;
        }
        C21004l.m32306b(activity, intent, "game_center_entrance", false, bEo, intExtra);
        AppMethodBeat.m2505o(111274);
    }

    /* renamed from: a */
    public static void m32304a(C28229n c28229n, int i, int i2) {
        AppMethodBeat.m2504i(111275);
        if (c28229n == null) {
            ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
            c28229n = C39215q.bEo();
            if (c28229n == null) {
                AppMethodBeat.m2505o(111275);
                return;
            }
        }
        c28229n.bEl();
        C4990ab.m7416i("MicroMsg.GameEntranceChecker", "float layer report");
        if (!C5046bo.isNullOrNil(c28229n.mWG.url)) {
            int i3 = c28229n.field_msgType;
            if (c28229n.field_msgType == 100) {
                i3 = c28229n.mXb;
            }
            C34277b.m56210a(C4996ah.getContext(), 10, 1006, 1, 1, 0, c28229n.field_appId, i, i3, c28229n.field_gameMsgId, c28229n.mXc, null);
            if (i2 == 1) {
                C7060h.pYm.mo8378a(858, 16, 1, false);
            } else if (i2 == 2) {
                C7060h.pYm.mo8378a(858, 17, 1, false);
            }
            c28229n.field_isRead = true;
            ((C45983c) C1720g.m3528K(C45983c.class)).bCY().mo10103c(c28229n, new String[0]);
        }
        ((C43156b) C1720g.m3528K(C43156b.class)).bCX();
        C39215q.bEp();
        AppMethodBeat.m2505o(111275);
    }

    /* renamed from: a */
    private static void m32303a(Context context, Intent intent, String str, boolean z, C28229n c28229n, int i) {
        AppMethodBeat.m2504i(111276);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        intent.putExtra("game_check_float", z);
        if (z && c28229n != null) {
            c28229n.bEl();
            if (c28229n.mWG.mXg) {
                intent.putExtra("game_transparent_float_url", c28229n.mWG.url);
            }
            intent.putExtra("game_sourceScene", i);
            intent.putExtra("game_float_layer_url", c28229n.mWG.url);
        }
        C46001c.m85465w(intent, context);
        AppMethodBeat.m2505o(111276);
    }

    /* renamed from: b */
    private static void m32306b(Context context, Intent intent, String str, boolean z, C28229n c28229n, int i) {
        AppMethodBeat.m2504i(111277);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        intent.putExtra("game_check_float", z);
        if (z && c28229n != null) {
            c28229n.bEl();
            if (!(c28229n.mWG == null || C5046bo.isNullOrNil(c28229n.mWG.url))) {
                GameFloatLayerInfo gameFloatLayerInfo = new GameFloatLayerInfo();
                gameFloatLayerInfo.url = c28229n.mWG.url;
                gameFloatLayerInfo.mTC = c28229n.mWG.mTC;
                int i2 = -1;
                switch (c28229n.mWG.orientation) {
                    case 1:
                    case 3:
                        i2 = 0;
                        break;
                    case 2:
                    case 4:
                        i2 = 1;
                        break;
                }
                gameFloatLayerInfo.orientation = i2;
                GameWebViewLaunchParams gameWebViewLaunchParams = new GameWebViewLaunchParams();
                gameWebViewLaunchParams.mTF = gameFloatLayerInfo;
                intent.putExtra("launchParams", gameWebViewLaunchParams);
                intent.putExtra("game_float_layer_url", c28229n.mWG.url);
            }
        }
        C46001c.m85466x(intent, context);
        C21004l.m32304a(c28229n, i, 1);
        AppMethodBeat.m2505o(111277);
    }

    /* renamed from: a */
    public static String m32301a(String str, C28229n c28229n) {
        AppMethodBeat.m2504i(111278);
        if (c28229n != null) {
            c28229n.bEl();
            if (!C5046bo.isNullOrNil(c28229n.mWG.url)) {
                C21004l.m32307cb(c28229n.mWG.mXh);
                str = C21004l.m32308ey(str, "h5FloatLayer=1");
                C4990ab.m7417i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", str);
            }
            if (!C5046bo.isNullOrNil(c28229n.mWX.mXi)) {
                C21004l.m32307cb(c28229n.mWX.mXh);
                try {
                    str = C21004l.m32308ey(str, "h5BannerId=" + C18178q.encode(c28229n.mWX.mXi, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
                C4990ab.m7417i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", str);
            }
        }
        AppMethodBeat.m2505o(111278);
        return str;
    }

    /* renamed from: cb */
    private static void m32307cb(List list) {
        AppMethodBeat.m2504i(111279);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(111279);
            return;
        }
        C9497vv c9497vv = new C9497vv();
        c9497vv.cSX.cuy = 8;
        c9497vv.cSX.scene = 1;
        c9497vv.cSX.cTc = list;
        C4879a.xxA.mo10055m(c9497vv);
        AppMethodBeat.m2505o(111279);
    }

    /* renamed from: ey */
    private static String m32308ey(String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(111280);
        Uri parse = Uri.parse(str);
        String query = parse.getQuery();
        if (query != null) {
            str3 = query + "&" + str2;
        } else {
            str3 = str2;
        }
        try {
            str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str3, parse.getFragment()).toString();
        } catch (URISyntaxException e) {
            C4990ab.printErrStackTrace("MicroMsg.GameEntranceChecker", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(111280);
        return str;
    }
}
