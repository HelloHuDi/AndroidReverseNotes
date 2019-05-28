package com.tencent.p177mm.plugin.card.p931d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p355ui.CardNewMsgUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.card.d.b */
public final class C45774b {
    /* renamed from: a */
    public static void m84628a(MMActivity mMActivity, boolean z) {
        AppMethodBeat.m2504i(88809);
        Intent intent = new Intent(mMActivity, CardNewMsgUI.class);
        intent.putExtra("from_menu", z);
        mMActivity.startActivity(intent);
        C4990ab.m7418v("MicroMsg.CardActivityHelper", "start CardNewMsgUI");
        C7060h.pYm.mo8381e(11324, "CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "");
        AppMethodBeat.m2505o(88809);
    }

    /* renamed from: ae */
    public static void m84630ae(Context context, String str) {
        AppMethodBeat.m2504i(88810);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7418v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.m2505o(88810);
        } else if (context == null) {
            C4990ab.m7412e("MicroMsg.CardActivityHelper", "context is null, err");
            AppMethodBeat.m2505o(88810);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("force_get_contact", true);
            C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.m2505o(88810);
        }
    }

    /* renamed from: af */
    public static void m84631af(Context context, String str) {
        AppMethodBeat.m2504i(88811);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7418v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.m2505o(88811);
        } else if (C1855t.m3912mY(str)) {
            C45774b.m84632ag(context, str);
            AppMethodBeat.m2505o(88811);
        } else {
            C45774b.m84630ae(context, str);
            AppMethodBeat.m2505o(88811);
        }
    }

    /* renamed from: ag */
    private static void m84632ag(Context context, String str) {
        AppMethodBeat.m2504i(88812);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7418v("MicroMsg.CardActivityHelper", "username is null");
            AppMethodBeat.m2505o(88812);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        C25985d.m41473f(context, ".ui.chatting.ChattingUI", intent);
        AppMethodBeat.m2505o(88812);
    }

    /* renamed from: a */
    public static void m84625a(MMActivity mMActivity, String str) {
        AppMethodBeat.m2504i(139166);
        C45774b.m84626a(mMActivity, str, 0);
        AppMethodBeat.m2505o(139166);
    }

    /* renamed from: a */
    public static void m84627a(MMActivity mMActivity, String str, String str2) {
        AppMethodBeat.m2504i(88814);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", 0);
        intent.putExtra("rawUrl", str);
        intent.putExtra("title", str2);
        C25985d.m41467b((Context) mMActivity, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(88814);
    }

    /* renamed from: a */
    public static void m84626a(MMActivity mMActivity, String str, int i) {
        AppMethodBeat.m2504i(88815);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("stastic_scene", i);
        C25985d.m41467b((Context) mMActivity, "webview", ".ui.tools.WebViewUI", intent);
        AppMethodBeat.m2505o(88815);
    }

    /* renamed from: a */
    public static void m84622a(MMActivity mMActivity, float f, float f2, String str) {
        AppMethodBeat.m2504i(88816);
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", (double) f);
        intent.putExtra("kwebmap_lng", (double) f2);
        intent.putExtra("Kwebmap_locaion", str);
        C25985d.m41467b((Context) mMActivity, C8741b.LOCATION, ".ui.RedirectUI", intent);
        AppMethodBeat.m2505o(88816);
    }

    /* renamed from: a */
    public static void m84623a(MMActivity mMActivity, int i, C5186a c5186a) {
        AppMethodBeat.m2504i(88817);
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", false);
        intent.putExtra("Select_Conv_Type", 3);
        C25985d.m41460a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i, c5186a);
        AppMethodBeat.m2505o(88817);
    }

    /* renamed from: b */
    public static void m84633b(MMActivity mMActivity, String str) {
        AppMethodBeat.m2504i(88818);
        Intent intent = new Intent();
        intent.putExtra("KEY_BRAND_NAME", str);
        C25985d.m41467b((Context) mMActivity, "card", ".ui.CardShowWaringTransparentUI", intent);
        AppMethodBeat.m2505o(88818);
    }

    /* renamed from: a */
    public static void m84624a(MMActivity mMActivity, int i, String str, boolean z, C42837b c42837b) {
        AppMethodBeat.m2504i(88819);
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 3);
        intent.putExtra("key_expire_time", i);
        intent.putExtra("key_begin_time", System.currentTimeMillis());
        intent.putExtra("key_card_tips", str);
        intent.putExtra("key_is_mark", z);
        intent.putExtra("key_card_id", c42837b.baa());
        intent.putExtra("key_user_card_id", c42837b.aZZ());
        intent.putExtra("key_card_code", c42837b.aZW().code);
        C25985d.m41467b((Context) mMActivity, "offline", ".ui.WalletOfflineEntranceUI", intent);
        C7060h.pYm.mo8381e(11850, Integer.valueOf(5), Integer.valueOf(0));
        AppMethodBeat.m2505o(88819);
    }

    /* renamed from: a */
    public static boolean m84629a(String str, C23446tm c23446tm, int i, int i2) {
        AppMethodBeat.m2504i(88820);
        if (c23446tm == null) {
            C4990ab.m7416i("MicroMsg.CardActivityHelper", "gotoAppBrand commField is null");
            AppMethodBeat.m2505o(88820);
            return false;
        }
        boolean d = C45774b.m84634d(str, c23446tm.vTL, c23446tm.vTM, i, i2);
        AppMethodBeat.m2505o(88820);
        return d;
    }

    /* renamed from: d */
    public static boolean m84634d(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(88821);
        if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7416i("MicroMsg.CardActivityHelper", "gotoAppBrand commField.app_brand_user_name is null");
            AppMethodBeat.m2505o(88821);
            return false;
        }
        C32628se c32628se = new C32628se();
        c32628se.cOf.userName = str2;
        c32628se.cOf.cOh = C5046bo.m7532bc(str3, "");
        c32628se.cOf.cOi = i2;
        if (i == 26) {
            c32628se.cOf.scene = 1029;
        } else {
            c32628se.cOf.scene = 1028;
        }
        c32628se.cOf.cst = str;
        c32628se.cOf.cOl = true;
        C4879a.xxA.mo10055m(c32628se);
        C4990ab.m7417i("MicroMsg.CardActivityHelper", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d", c32628se.cOf.userName, c32628se.cOf.cOh, Integer.valueOf(c32628se.cOf.scene), Integer.valueOf(c32628se.cOf.cOi));
        AppMethodBeat.m2505o(88821);
        return true;
    }

    /* renamed from: t */
    public static void m84635t(String str, String str2, int i) {
        AppMethodBeat.m2504i(88822);
        C32628se c32628se = new C32628se();
        c32628se.cOf.userName = str;
        c32628se.cOf.cOh = C5046bo.m7532bc(str2, "");
        if (i > 0) {
            c32628se.cOf.axy = i;
        }
        c32628se.cOf.scene = 1028;
        C4879a.xxA.mo10055m(c32628se);
        AppMethodBeat.m2505o(88822);
    }
}
