package com.tencent.mm.plugin.game.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.luggage.GameFloatLayerInfo;
import com.tencent.mm.plugin.game.luggage.GameWebViewLaunchParams;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public final class l {
    public static void a(Activity activity, String str, Intent intent) {
        AppMethodBeat.i(111273);
        if (bo.isNullOrNil(str) || intent == null) {
            AppMethodBeat.o(111273);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
        ((b) g.K(b.class)).bCX();
        n bEo = q.bEo();
        if (bEo == null) {
            ((b) g.K(b.class)).bCX();
            bEo = q.bEs();
        }
        intent.putExtra("rawUrl", a(str, bEo));
        if (booleanExtra) {
            a(activity, intent, "game_center_entrance", true, bEo, intExtra);
            ((b) g.K(b.class)).bCX();
            q.bEt();
            ((b) g.K(b.class)).bCX();
            q.bEn();
            AppMethodBeat.o(111273);
            return;
        }
        a(activity, intent, "game_center_entrance", false, bEo, intExtra);
        AppMethodBeat.o(111273);
    }

    public static void b(Activity activity, String str, Intent intent) {
        AppMethodBeat.i(111274);
        if (bo.isNullOrNil(str) || intent == null) {
            AppMethodBeat.o(111274);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
        int intExtra = intent.getIntExtra("game_report_from_scene", 0);
        ((b) g.K(b.class)).bCX();
        n bEo = q.bEo();
        if (bEo == null) {
            ((b) g.K(b.class)).bCX();
            bEo = q.bEs();
        }
        intent.putExtra("rawUrl", a(str, bEo));
        if (booleanExtra) {
            b(activity, intent, "game_center_entrance", true, bEo, intExtra);
            ((b) g.K(b.class)).bCX();
            q.bEt();
            ((b) g.K(b.class)).bCX();
            q.bEn();
            AppMethodBeat.o(111274);
            return;
        }
        b(activity, intent, "game_center_entrance", false, bEo, intExtra);
        AppMethodBeat.o(111274);
    }

    public static void a(n nVar, int i, int i2) {
        AppMethodBeat.i(111275);
        if (nVar == null) {
            ((b) g.K(b.class)).bCX();
            nVar = q.bEo();
            if (nVar == null) {
                AppMethodBeat.o(111275);
                return;
            }
        }
        nVar.bEl();
        ab.i("MicroMsg.GameEntranceChecker", "float layer report");
        if (!bo.isNullOrNil(nVar.mWG.url)) {
            int i3 = nVar.field_msgType;
            if (nVar.field_msgType == 100) {
                i3 = nVar.mXb;
            }
            com.tencent.mm.plugin.game.e.b.a(ah.getContext(), 10, 1006, 1, 1, 0, nVar.field_appId, i, i3, nVar.field_gameMsgId, nVar.mXc, null);
            if (i2 == 1) {
                h.pYm.a(858, 16, 1, false);
            } else if (i2 == 2) {
                h.pYm.a(858, 17, 1, false);
            }
            nVar.field_isRead = true;
            ((c) g.K(c.class)).bCY().c(nVar, new String[0]);
        }
        ((b) g.K(b.class)).bCX();
        q.bEp();
        AppMethodBeat.o(111275);
    }

    private static void a(Context context, Intent intent, String str, boolean z, n nVar, int i) {
        AppMethodBeat.i(111276);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        intent.putExtra("game_check_float", z);
        if (z && nVar != null) {
            nVar.bEl();
            if (nVar.mWG.mXg) {
                intent.putExtra("game_transparent_float_url", nVar.mWG.url);
            }
            intent.putExtra("game_sourceScene", i);
            intent.putExtra("game_float_layer_url", nVar.mWG.url);
        }
        com.tencent.mm.plugin.game.f.c.w(intent, context);
        AppMethodBeat.o(111276);
    }

    private static void b(Context context, Intent intent, String str, boolean z, n nVar, int i) {
        AppMethodBeat.i(111277);
        intent.putExtra("geta8key_scene", 32);
        intent.putExtra("KPublisherId", str);
        intent.putExtra("game_check_float", z);
        if (z && nVar != null) {
            nVar.bEl();
            if (!(nVar.mWG == null || bo.isNullOrNil(nVar.mWG.url))) {
                GameFloatLayerInfo gameFloatLayerInfo = new GameFloatLayerInfo();
                gameFloatLayerInfo.url = nVar.mWG.url;
                gameFloatLayerInfo.mTC = nVar.mWG.mTC;
                int i2 = -1;
                switch (nVar.mWG.orientation) {
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
                intent.putExtra("game_float_layer_url", nVar.mWG.url);
            }
        }
        com.tencent.mm.plugin.game.f.c.x(intent, context);
        a(nVar, i, 1);
        AppMethodBeat.o(111277);
    }

    public static String a(String str, n nVar) {
        AppMethodBeat.i(111278);
        if (nVar != null) {
            nVar.bEl();
            if (!bo.isNullOrNil(nVar.mWG.url)) {
                cb(nVar.mWG.mXh);
                str = ey(str, "h5FloatLayer=1");
                ab.i("MicroMsg.GameEntranceChecker", "after checking float, url = %s", str);
            }
            if (!bo.isNullOrNil(nVar.mWX.mXi)) {
                cb(nVar.mWX.mXh);
                try {
                    str = ey(str, "h5BannerId=" + q.encode(nVar.mWX.mXi, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
                ab.i("MicroMsg.GameEntranceChecker", "after checking banner, url = %s", str);
            }
        }
        AppMethodBeat.o(111278);
        return str;
    }

    private static void cb(List list) {
        AppMethodBeat.i(111279);
        if (bo.ek(list)) {
            AppMethodBeat.o(111279);
            return;
        }
        vv vvVar = new vv();
        vvVar.cSX.cuy = 8;
        vvVar.cSX.scene = 1;
        vvVar.cSX.cTc = list;
        a.xxA.m(vvVar);
        AppMethodBeat.o(111279);
    }

    private static String ey(String str, String str2) {
        String str3;
        AppMethodBeat.i(111280);
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
            ab.printErrStackTrace("MicroMsg.GameEntranceChecker", e, "", new Object[0]);
        }
        AppMethodBeat.o(111280);
        return str;
    }
}
