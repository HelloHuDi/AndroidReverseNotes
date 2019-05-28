package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.se;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.card.ui.CardNewMsgUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

public final class b {
    public static void a(MMActivity mMActivity, boolean z) {
        AppMethodBeat.i(88809);
        Intent intent = new Intent(mMActivity, CardNewMsgUI.class);
        intent.putExtra("from_menu", z);
        mMActivity.startActivity(intent);
        ab.v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
        h.pYm.e(11324, "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
        AppMethodBeat.o(88809);
    }

    public static void ae(Context context, String str) {
        AppMethodBeat.i(88810);
        if (TextUtils.isEmpty(str)) {
            ab.v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.o(88810);
        } else if (context == null) {
            ab.e("MicroMsg.CardActivityHelper", "context is null, err");
            AppMethodBeat.o(88810);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("force_get_contact", true);
            d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(88810);
        }
    }

    public static void af(Context context, String str) {
        AppMethodBeat.i(88811);
        if (TextUtils.isEmpty(str)) {
            ab.v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.o(88811);
        } else if (t.mY(str)) {
            ag(context, str);
            AppMethodBeat.o(88811);
        } else {
            ae(context, str);
            AppMethodBeat.o(88811);
        }
    }

    private static void ag(Context context, String str) {
        AppMethodBeat.i(88812);
        if (TextUtils.isEmpty(str)) {
            ab.v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.o(88812);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        d.f(context, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.o(88812);
    }

    public static void a(MMActivity mMActivity, String str) {
        AppMethodBeat.i(139166);
        a(mMActivity, str, 0);
        AppMethodBeat.o(139166);
    }

    public static void a(MMActivity mMActivity, String str, String str2) {
        AppMethodBeat.i(88814);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", 0);
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        d.b((Context) mMActivity, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(88814);
    }

    public static void a(MMActivity mMActivity, String str, int i) {
        AppMethodBeat.i(88815);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", i);
        d.b((Context) mMActivity, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.o(88815);
    }

    public static void a(MMActivity mMActivity, float f, float f2, String str) {
        AppMethodBeat.i(88816);
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", (double) f);
        intent.putExtra("kwebmap_lng", (double) f2);
        intent.putExtra("Kwebmap_locaion", str);
        d.b((Context) mMActivity, com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.o(88816);
    }

    public static void a(MMActivity mMActivity, int i, a aVar) {
        AppMethodBeat.i(88817);
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", false);
        intent.putExtra("Select_Conv_Type", 3);
        d.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i, aVar);
        AppMethodBeat.o(88817);
    }

    public static void b(MMActivity mMActivity, String str) {
        AppMethodBeat.i(88818);
        Intent intent = new Intent();
        intent.putExtra("KEY_BRAND_NAME", str);
        d.b((Context) mMActivity, "card", ".ui.CardShowWaringTransparentUI", intent);
        AppMethodBeat.o(88818);
    }

    public static void a(MMActivity mMActivity, int i, String str, boolean z, com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(88819);
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 3);
        intent.putExtra("key_expire_time", i);
        intent.putExtra("key_begin_time", System.currentTimeMillis());
        intent.putExtra("key_card_tips", str);
        intent.putExtra("key_is_mark", z);
        intent.putExtra("key_card_id", bVar.baa());
        intent.putExtra("key_user_card_id", bVar.aZZ());
        intent.putExtra("key_card_code", bVar.aZW().code);
        d.b((Context) mMActivity, "offline", ".ui.WalletOfflineEntranceUI", intent);
        h.pYm.e(11850, Integer.valueOf(5), Integer.valueOf(0));
        AppMethodBeat.o(88819);
    }

    public static boolean a(String str, tm tmVar, int i, int i2) {
        AppMethodBeat.i(88820);
        if (tmVar == null) {
            ab.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
            AppMethodBeat.o(88820);
            return false;
        }
        boolean d = d(str, tmVar.vTL, tmVar.vTM, i, i2);
        AppMethodBeat.o(88820);
        return d;
    }

    public static boolean d(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(88821);
        if (bo.isNullOrNil(str2)) {
            ab.i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
            AppMethodBeat.o(88821);
            return false;
        }
        se seVar = new se();
        seVar.cOf.userName = str2;
        seVar.cOf.cOh = bo.bc(str3, "");
        seVar.cOf.cOi = i2;
        if (i == 26) {
            seVar.cOf.scene = 1029;
        } else {
            seVar.cOf.scene = 1028;
        }
        seVar.cOf.cst = str;
        seVar.cOf.cOl = true;
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        ab.i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", seVar.cOf.userName, seVar.cOf.cOh, Integer.valueOf(seVar.cOf.scene), Integer.valueOf(seVar.cOf.cOi));
        AppMethodBeat.o(88821);
        return true;
    }

    public static void t(String str, String str2, int i) {
        AppMethodBeat.i(88822);
        se seVar = new se();
        seVar.cOf.userName = str;
        seVar.cOf.cOh = bo.bc(str2, "");
        if (i > 0) {
            seVar.cOf.axy = i;
        }
        seVar.cOf.scene = 1028;
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        AppMethodBeat.o(88822);
    }
}
