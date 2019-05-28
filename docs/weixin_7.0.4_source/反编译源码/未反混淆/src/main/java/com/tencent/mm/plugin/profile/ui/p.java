package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.d;
import com.tencent.mm.model.bf;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.preference.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.bt;

public final class p {
    public static b[] a(Context context, ad adVar, int i) {
        AppMethodBeat.i(23613);
        String nullAsNil = bo.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        if (a.jh(adVar.field_type)) {
            AppMethodBeat.o(23613);
            return null;
        } else if (bo.isNullOrNil(nullAsNil)) {
            AppMethodBeat.o(23613);
            return null;
        } else {
            b[] a;
            ab.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(i)));
            if (i == 18) {
                ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
                a = b.a(context, d.akQ().apz(adVar.field_username));
            } else if (bf.kE(i)) {
                ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
                a = b.a(context, d.akR().apY(adVar.field_username));
            } else {
                ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
                a = b.a(context, d.akO().apv(adVar.field_username));
            }
            if (a == null || a.length == 0) {
                AppMethodBeat.o(23613);
                return null;
            }
            AppMethodBeat.o(23613);
            return a;
        }
    }

    public static String b(Context context, ad adVar, int i) {
        String str = null;
        AppMethodBeat.i(23614);
        String nullAsNil = bo.nullAsNil(((Activity) context).getIntent().getStringExtra("Verify_ticket"));
        if (a.jh(adVar.field_type)) {
            AppMethodBeat.o(23614);
        } else if (bo.isNullOrNil(nullAsNil)) {
            AppMethodBeat.o(23614);
        } else {
            str = "";
            ab.d("MicroMsg.FMessageUtil", "initAddContent, scene = ".concat(String.valueOf(i)));
            if (i == 18) {
                ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is lbs");
                com.tencent.mm.storage.bf[] apz = d.akQ().apz(adVar.field_username);
                if (apz.length > 0) {
                    str = apz[0].field_svrid;
                }
            } else if (bf.kE(i)) {
                ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is shake");
                bt[] apY = d.akR().apY(adVar.field_username);
                if (apY.length > 0) {
                    str = apY[0].field_svrid;
                }
            } else {
                ab.d("MicroMsg.FMessageUtil", "initAddContent, scene is other");
                ax[] apv = d.akO().apv(adVar.field_username);
                if (apv.length > 0) {
                    str = apv[0].field_svrId;
                }
            }
            AppMethodBeat.o(23614);
        }
        return str;
    }
}
