package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.C32923a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C9878ao;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi.C5135a;

/* renamed from: com.tencent.mm.ui.contact.e */
public final class C36249e {
    /* renamed from: r */
    public static void m59678r(Intent intent, String str) {
        AppMethodBeat.m2504i(33607);
        intent.putExtra("Contact_User", str);
        AppMethodBeat.m2505o(33607);
    }

    /* renamed from: a */
    public static void m59677a(Intent intent, String str) {
        AppMethodBeat.m2504i(33608);
        if (intent == null || str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            AppMethodBeat.m2505o(33608);
            return;
        }
        C9878ao wj = C32923a.getQQListStg().mo73286wj(str);
        if (wj != null) {
            intent.putExtra("Contact_Uin", wj.gwC);
            intent.putExtra("Contact_QQNick", wj.getDisplayName());
        }
        C18817a vT = C32923a.getAddrUploadStg().mo34089vT(str);
        if (vT != null) {
            intent.putExtra("Contact_Mobile_MD5", vT.mo34067Aq());
        }
        AppMethodBeat.m2505o(33608);
    }

    /* renamed from: a */
    public static void m59675a(Context context, C5135a c5135a) {
        AppMethodBeat.m2504i(33609);
        C36249e.m59676a(context, c5135a, false, false, null);
        AppMethodBeat.m2505o(33609);
    }

    /* renamed from: a */
    public static void m59676a(Context context, C5135a c5135a, boolean z, boolean z2, Bundle bundle) {
        AppMethodBeat.m2504i(33610);
        if (context == null || c5135a == null) {
            AppMethodBeat.m2505o(33610);
            return;
        }
        C7616ad c7616ad = new C7616ad();
        c7616ad.setUsername(c5135a.svN);
        c7616ad.mo14703iB(c5135a.getDisplayName());
        c7616ad.mo14704iC(c5135a.gwF);
        c7616ad.mo14705iD(c5135a.gwG);
        C36249e.m59674a(context, c7616ad, c5135a, z, z2, bundle, c5135a.gta);
        AppMethodBeat.m2505o(33610);
    }

    /* renamed from: a */
    public static void m59673a(Context context, C7616ad c7616ad, C5135a c5135a) {
        AppMethodBeat.m2504i(33611);
        C36249e.m59674a(context, c7616ad, c5135a, false, false, null, c5135a.gta);
        AppMethodBeat.m2505o(33611);
    }

    /* renamed from: a */
    public static void m59674a(Context context, C7616ad c7616ad, C5135a c5135a, boolean z, boolean z2, Bundle bundle, String str) {
        AppMethodBeat.m2504i(33612);
        if (c7616ad == null || c5135a == null) {
            AppMethodBeat.m2505o(33612);
        } else if (c7616ad.field_username == null || c7616ad.field_username.length() <= 0) {
            AppMethodBeat.m2505o(33612);
        } else {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", c7616ad.field_username);
            intent.putExtra("Contact_Alias", c7616ad.mo14673Hq());
            intent.putExtra("Contact_Nick", c7616ad.mo16706Oi());
            intent.putExtra("Contact_QuanPin", c7616ad.mo14677Hu());
            intent.putExtra("Contact_PyInitial", c7616ad.mo14676Ht());
            intent.putExtra("Contact_Sex", c5135a.dtS);
            intent.putExtra("Contact_Province", c5135a.getProvince());
            intent.putExtra("Contact_City", c5135a.getCity());
            intent.putExtra("Contact_Signature", c5135a.signature);
            intent.putExtra("Contact_Uin", c5135a.pnz);
            intent.putExtra("Contact_Mobile_MD5", c5135a.xZi);
            intent.putExtra("Contact_full_Mobile_MD5", c5135a.xZj);
            intent.putExtra("Contact_QQNick", c5135a.dtZ());
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_Scene", c5135a.scene);
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
            C25985d.m41467b(context, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.m2505o(33612);
        }
    }
}
