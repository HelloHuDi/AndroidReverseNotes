package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;

public final class e {
    public static void r(Intent intent, String str) {
        AppMethodBeat.i(33607);
        intent.putExtra("Contact_User", str);
        AppMethodBeat.o(33607);
    }

    public static void a(Intent intent, String str) {
        AppMethodBeat.i(33608);
        if (intent == null || str == null || str.length() == 0) {
            ab.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            AppMethodBeat.o(33608);
            return;
        }
        ao wj = a.getQQListStg().wj(str);
        if (wj != null) {
            intent.putExtra("Contact_Uin", wj.gwC);
            intent.putExtra("Contact_QQNick", wj.getDisplayName());
        }
        com.tencent.mm.plugin.account.friend.a.a vT = a.getAddrUploadStg().vT(str);
        if (vT != null) {
            intent.putExtra("Contact_Mobile_MD5", vT.Aq());
        }
        AppMethodBeat.o(33608);
    }

    public static void a(Context context, bi.a aVar) {
        AppMethodBeat.i(33609);
        a(context, aVar, false, false, null);
        AppMethodBeat.o(33609);
    }

    public static void a(Context context, bi.a aVar, boolean z, boolean z2, Bundle bundle) {
        AppMethodBeat.i(33610);
        if (context == null || aVar == null) {
            AppMethodBeat.o(33610);
            return;
        }
        ad adVar = new ad();
        adVar.setUsername(aVar.svN);
        adVar.iB(aVar.getDisplayName());
        adVar.iC(aVar.gwF);
        adVar.iD(aVar.gwG);
        a(context, adVar, aVar, z, z2, bundle, aVar.gta);
        AppMethodBeat.o(33610);
    }

    public static void a(Context context, ad adVar, bi.a aVar) {
        AppMethodBeat.i(33611);
        a(context, adVar, aVar, false, false, null, aVar.gta);
        AppMethodBeat.o(33611);
    }

    public static void a(Context context, ad adVar, bi.a aVar, boolean z, boolean z2, Bundle bundle, String str) {
        AppMethodBeat.i(33612);
        if (adVar == null || aVar == null) {
            AppMethodBeat.o(33612);
        } else if (adVar.field_username == null || adVar.field_username.length() <= 0) {
            AppMethodBeat.o(33612);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", adVar.field_username);
            intent.putExtra("Contact_Alias", adVar.Hq());
            intent.putExtra("Contact_Nick", adVar.Oi());
            intent.putExtra("Contact_QuanPin", adVar.Hu());
            intent.putExtra("Contact_PyInitial", adVar.Ht());
            intent.putExtra("Contact_Sex", aVar.dtS);
            intent.putExtra("Contact_Province", aVar.getProvince());
            intent.putExtra("Contact_City", aVar.getCity());
            intent.putExtra("Contact_Signature", aVar.signature);
            intent.putExtra("Contact_Uin", aVar.pnz);
            intent.putExtra("Contact_Mobile_MD5", aVar.xZi);
            intent.putExtra("Contact_full_Mobile_MD5", aVar.xZj);
            intent.putExtra("Contact_QQNick", aVar.dtZ());
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_Scene", aVar.scene);
            intent.putExtra("Contact_from_msgType", 40);
            if (z) {
                intent.putExtra("Contact_ShowUserName", false);
            }
            if (z2) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("verify_gmail", str);
            }
            d.b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(33612);
        }
    }
}
