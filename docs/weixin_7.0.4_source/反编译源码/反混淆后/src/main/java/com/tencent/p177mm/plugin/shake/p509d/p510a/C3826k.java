package com.tencent.p177mm.plugin.shake.p509d.p510a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p230g.p231a.C26151he;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.shake.C46193a;
import com.tencent.p177mm.plugin.shake.p1019b.C34894d;
import com.tencent.p177mm.plugin.shake.p511ui.TVInfoUI;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.shake.d.a.k */
public final class C3826k {
    /* renamed from: a */
    public static void m6120a(final C34894d c34894d, final Context context) {
        AppMethodBeat.m2504i(24652);
        new C7306ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(24651);
                C3826k.m6121a(c34894d, context, false);
                AppMethodBeat.m2505o(24651);
            }
        }, 100);
        AppMethodBeat.m2505o(24652);
    }

    /* renamed from: a */
    public static void m6121a(C34894d c34894d, Context context, boolean z) {
        int i = 4;
        AppMethodBeat.m2504i(24653);
        if (c34894d == null) {
            AppMethodBeat.m2505o(24653);
            return;
        }
        Intent intent;
        switch (c34894d.field_type) {
            case 6:
                String str = c34894d.field_username;
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                if (aoO != null) {
                    Intent intent2 = new Intent();
                    if (C7486a.m12942jh(aoO.field_type) && aoO.dsf()) {
                        C41747z.aeR().mo43729qP(str);
                        if (c34894d.field_distance.equals("1")) {
                            intent2.putExtra("Chat_User", str);
                            intent2.putExtra("finish_direct", true);
                            C46193a.gkE.mo38915d(intent2, context);
                            AppMethodBeat.m2505o(24653);
                            return;
                        }
                    }
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("force_get_contact", true);
                    C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    AppMethodBeat.m2505o(24653);
                    return;
                }
                break;
            case 7:
                Intent intent3 = new Intent();
                i = 18;
                if (z) {
                    i = 26;
                }
                intent3.putExtra("geta8key_scene", i);
                intent3.putExtra("stastic_scene", 6);
                intent3.putExtra("KAppId", "wxaf060266bfa9a35c");
                Bundle bundle = new Bundle();
                bundle.putString("jsapi_args_appid", "wxaf060266bfa9a35c");
                intent3.putExtra("jsapiargs", bundle);
                intent3.putExtra("rawUrl", c34894d.field_username);
                intent3.putExtra("srcUsername", c34894d.field_distance);
                C46193a.gkE.mo38924i(intent3, context);
                AppMethodBeat.m2505o(24653);
                return;
            case 8:
                intent = new Intent();
                intent.setClass(context, TVInfoUI.class);
                intent.putExtra("key_TV_xml_bytes", c34894d.field_lvbuffer);
                intent.putExtra("key_TV_come_from_shake", true);
                context.startActivity(intent);
                AppMethodBeat.m2505o(24653);
                return;
            case 9:
                C4883b c26151he = new C26151he();
                c26151he.cBW.actionCode = 11;
                c26151he.cBW.result = c34894d.field_username;
                c26151he.cBW.context = context;
                c26151he.callback = null;
                C4879a.xxA.mo10048a(c26151he, Looper.myLooper());
                AppMethodBeat.m2505o(24653);
                return;
            case 10:
                intent = new Intent();
                intent.putExtra("key_product_id", c34894d.field_username);
                intent.putExtra("key_product_scene", 9);
                C25985d.m41467b(context, "product", ".ui.MallProductUI", intent);
                AppMethodBeat.m2505o(24653);
                return;
            case 12:
                if (!z) {
                    i = 3;
                }
                C3826k.m6122a(c34894d.field_distance, c34894d.field_username, i, context);
                AppMethodBeat.m2505o(24653);
                return;
            case 13:
                String str2 = c34894d.field_username;
                String str3 = c34894d.field_reserved3;
                int i2 = c34894d.field_reserved2;
                if (!C5046bo.isNullOrNil(str2)) {
                    C32628se c32628se = new C32628se();
                    c32628se.cOf.userName = str2;
                    c32628se.cOf.cOh = C5046bo.m7532bc(str3, "");
                    c32628se.cOf.cOi = 0;
                    c32628se.cOf.scene = 1039;
                    c32628se.cOf.axy = i2;
                    C4879a.xxA.mo10055m(c32628se);
                    C4990ab.m7417i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", c32628se.cOf.userName, c32628se.cOf.cOh, Integer.valueOf(c32628se.cOf.scene), Integer.valueOf(c32628se.cOf.cOi), Integer.valueOf(c32628se.cOf.axy));
                    break;
                }
                C4990ab.m7416i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
                AppMethodBeat.m2505o(24653);
                return;
        }
        AppMethodBeat.m2505o(24653);
    }

    /* renamed from: Cz */
    public static boolean m6119Cz(int i) {
        return 7 == i || 6 == i || 8 == i || 9 == i || 10 == i || 12 == i || 13 == i;
    }

    public static boolean cjQ() {
        AppMethodBeat.m2504i(24654);
        if (C1947ae.giq) {
            AppMethodBeat.m2505o(24654);
            return true;
        }
        String value = C26373g.m41964Nu().getValue("ShowShakeTV");
        C4990ab.m7411d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", value);
        if (C5046bo.isNullOrNil(value) || !value.equals("1")) {
            AppMethodBeat.m2505o(24654);
            return false;
        }
        AppMethodBeat.m2505o(24654);
        return true;
    }

    /* renamed from: a */
    public static void m6122a(String str, String str2, int i, Context context) {
        AppMethodBeat.m2504i(24655);
        if (C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(24655);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str2));
        int i2 = 16;
        if (i == 3 || i == 4) {
            i2 = 17;
        }
        intent.putExtra("translate_link_scene", i2);
        context.startActivity(intent);
        C4990ab.m7416i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
        C7060h.pYm.mo8381e(12108, C5046bo.nullAsNil(str), Integer.valueOf(i), Integer.valueOf(1));
        AppMethodBeat.m2505o(24655);
    }
}
