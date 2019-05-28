package com.tencent.mm.plugin.shake.d.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.he;
import com.tencent.mm.g.a.se;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.ui.TVInfoUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public final class k {
    public static void a(final d dVar, final Context context) {
        AppMethodBeat.i(24652);
        new ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(24651);
                k.a(dVar, context, false);
                AppMethodBeat.o(24651);
            }
        }, 100);
        AppMethodBeat.o(24652);
    }

    public static void a(d dVar, Context context, boolean z) {
        int i = 4;
        AppMethodBeat.i(24653);
        if (dVar == null) {
            AppMethodBeat.o(24653);
            return;
        }
        Intent intent;
        switch (dVar.field_type) {
            case 6:
                String str = dVar.field_username;
                aw.ZK();
                ad aoO = c.XM().aoO(str);
                if (aoO != null) {
                    Intent intent2 = new Intent();
                    if (a.jh(aoO.field_type) && aoO.dsf()) {
                        z.aeR().qP(str);
                        if (dVar.field_distance.equals("1")) {
                            intent2.putExtra("Chat_User", str);
                            intent2.putExtra("finish_direct", true);
                            com.tencent.mm.plugin.shake.a.gkE.d(intent2, context);
                            AppMethodBeat.o(24653);
                            return;
                        }
                    }
                    intent2.putExtra("Contact_User", str);
                    intent2.putExtra("force_get_contact", true);
                    com.tencent.mm.bp.d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    AppMethodBeat.o(24653);
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
                intent3.putExtra("rawUrl", dVar.field_username);
                intent3.putExtra("srcUsername", dVar.field_distance);
                com.tencent.mm.plugin.shake.a.gkE.i(intent3, context);
                AppMethodBeat.o(24653);
                return;
            case 8:
                intent = new Intent();
                intent.setClass(context, TVInfoUI.class);
                intent.putExtra("key_TV_xml_bytes", dVar.field_lvbuffer);
                intent.putExtra("key_TV_come_from_shake", true);
                context.startActivity(intent);
                AppMethodBeat.o(24653);
                return;
            case 9:
                b heVar = new he();
                heVar.cBW.actionCode = 11;
                heVar.cBW.result = dVar.field_username;
                heVar.cBW.context = context;
                heVar.callback = null;
                com.tencent.mm.sdk.b.a.xxA.a(heVar, Looper.myLooper());
                AppMethodBeat.o(24653);
                return;
            case 10:
                intent = new Intent();
                intent.putExtra("key_product_id", dVar.field_username);
                intent.putExtra("key_product_scene", 9);
                com.tencent.mm.bp.d.b(context, "product", ".ui.MallProductUI", intent);
                AppMethodBeat.o(24653);
                return;
            case 12:
                if (!z) {
                    i = 3;
                }
                a(dVar.field_distance, dVar.field_username, i, context);
                AppMethodBeat.o(24653);
                return;
            case 13:
                String str2 = dVar.field_username;
                String str3 = dVar.field_reserved3;
                int i2 = dVar.field_reserved2;
                if (!bo.isNullOrNil(str2)) {
                    se seVar = new se();
                    seVar.cOf.userName = str2;
                    seVar.cOf.cOh = bo.bc(str3, "");
                    seVar.cOf.cOi = 0;
                    seVar.cOf.scene = 1039;
                    seVar.cOf.axy = i2;
                    com.tencent.mm.sdk.b.a.xxA.m(seVar);
                    ab.i("Micromsg.ShakeTVLogic", "gotoAppBrand userName:%s, path:%s, scene:%d openType:%d version:%d", seVar.cOf.userName, seVar.cOf.cOh, Integer.valueOf(seVar.cOf.scene), Integer.valueOf(seVar.cOf.cOi), Integer.valueOf(seVar.cOf.axy));
                    break;
                }
                ab.i("Micromsg.ShakeTVLogic", "gotoAppBrand commField.app_brand_user_name is null");
                AppMethodBeat.o(24653);
                return;
        }
        AppMethodBeat.o(24653);
    }

    public static boolean Cz(int i) {
        return 7 == i || 6 == i || 8 == i || 9 == i || 10 == i || 12 == i || 13 == i;
    }

    public static boolean cjQ() {
        AppMethodBeat.i(24654);
        if (ae.giq) {
            AppMethodBeat.o(24654);
            return true;
        }
        String value = g.Nu().getValue("ShowShakeTV");
        ab.d("Micromsg.ShakeTVLogic", "DynamicConfig Get ShowShakeTV: %s", value);
        if (bo.isNullOrNil(value) || !value.equals("1")) {
            AppMethodBeat.o(24654);
            return false;
        }
        AppMethodBeat.o(24654);
        return true;
    }

    public static void a(String str, String str2, int i, Context context) {
        AppMethodBeat.i(24655);
        if (bo.isNullOrNil(str2)) {
            AppMethodBeat.o(24655);
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
        ab.i("Micromsg.ShakeTVLogic", "doShakeTvHistoryItemClick start tempsession open deeplink");
        h.pYm.e(12108, bo.nullAsNil(str), Integer.valueOf(i), Integer.valueOf(1));
        AppMethodBeat.o(24655);
    }
}
