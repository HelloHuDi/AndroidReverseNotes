package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.plugin.chatroom.p721a.C6822c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.model.s */
public final class C1854s {
    private static Set<String> fkN = new HashSet();

    /* renamed from: mH */
    public static String m3864mH(String str) {
        AppMethodBeat.m2504i(136845);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.m2505o(136845);
            return str;
        } else if (C5046bo.isNullOrNil(aoO.field_nickname)) {
            AppMethodBeat.m2505o(136845);
            return str;
        } else {
            str = aoO.field_nickname;
            AppMethodBeat.m2505o(136845);
            return str;
        }
    }

    public static String getDisplayName(String str, String str2) {
        AppMethodBeat.m2504i(136846);
        String mJ;
        if (C5046bo.isNullOrNil(str2)) {
            mJ = C1854s.m3866mJ(str);
            AppMethodBeat.m2505o(136846);
            return mJ;
        }
        mJ = C1854s.m3867mK(str);
        if (C5046bo.isNullOrNil(mJ)) {
            mJ = C37921n.m64057ab(str, str2);
            if (C5046bo.isNullOrNil(mJ)) {
                mJ = C1854s.m3866mJ(str);
                AppMethodBeat.m2505o(136846);
                return mJ;
            }
            AppMethodBeat.m2505o(136846);
            return mJ;
        }
        AppMethodBeat.m2505o(136846);
        return mJ;
    }

    /* renamed from: mI */
    public static String m3865mI(String str) {
        AppMethodBeat.m2504i(136847);
        if (str == null || str.length() <= 0) {
            str = "";
            AppMethodBeat.m2505o(136847);
            return str;
        }
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        C4990ab.m7411d("MicroMsg.ContactCommDisplay", "username: %s", str);
        if (aoO == null) {
            AppMethodBeat.m2505o(136847);
            return str;
        }
        if (C1855t.m3896kH(str) && C5046bo.isNullOrNil(aoO.field_nickname)) {
            String mJ = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14883mJ(str);
            if (!C5046bo.isNullOrNil(mJ)) {
                AppMethodBeat.m2505o(136847);
                return mJ;
            }
        }
        if (aoO.mo16706Oi() == null || aoO.mo16706Oi().length() <= 0) {
            AppMethodBeat.m2505o(136847);
            return str;
        }
        str = aoO.mo16706Oi();
        AppMethodBeat.m2505o(136847);
        return str;
    }

    /* renamed from: mJ */
    public static String m3866mJ(String str) {
        AppMethodBeat.m2504i(136848);
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
            AppMethodBeat.m2505o(136848);
            return str2;
        }
        str2 = C1855t.m3879a(((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str), str);
        AppMethodBeat.m2505o(136848);
        return str2;
    }

    /* renamed from: a */
    public static String m3860a(C7616ad c7616ad, String str) {
        AppMethodBeat.m2504i(139164);
        String a = C1855t.m3879a(c7616ad, str);
        AppMethodBeat.m2505o(139164);
        return a;
    }

    /* renamed from: a */
    public static String m3861a(C7616ad c7616ad, String str, boolean z) {
        AppMethodBeat.m2504i(136850);
        if (c7616ad == null) {
            AppMethodBeat.m2505o(136850);
            return str;
        } else if (z && C5046bo.isNullOrNil(c7616ad.field_nickname)) {
            str = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14883mJ(str);
            AppMethodBeat.m2505o(136850);
            return str;
        } else if (c7616ad.mo16707Oj() != null && c7616ad.mo16707Oj().length() > 0) {
            str = c7616ad.mo16707Oj();
            AppMethodBeat.m2505o(136850);
            return str;
        } else if (C5046bo.isNullOrNil(c7616ad.field_nickname) && C1855t.m3922nH(str)) {
            str = C7486a.m12943kN(str);
            AppMethodBeat.m2505o(136850);
            return str;
        } else {
            AppMethodBeat.m2505o(136850);
            return str;
        }
    }

    /* renamed from: mK */
    public static String m3867mK(String str) {
        AppMethodBeat.m2504i(136852);
        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
        String str2;
        if (aoO == null) {
            str2 = "";
            AppMethodBeat.m2505o(136852);
            return str2;
        } else if (C5046bo.isNullOrNil(aoO.field_conRemark)) {
            str2 = "";
            AppMethodBeat.m2505o(136852);
            return str2;
        } else {
            str2 = aoO.field_conRemark;
            AppMethodBeat.m2505o(136852);
            return str2;
        }
    }

    static {
        AppMethodBeat.m2504i(136854);
        AppMethodBeat.m2505o(136854);
    }

    /* renamed from: c */
    public static void m3863c(Set<String> set) {
        fkN = set;
    }

    /* renamed from: mL */
    public static String m3868mL(String str) {
        AppMethodBeat.m2504i(136853);
        if (fkN.contains(str)) {
            str = "";
            AppMethodBeat.m2505o(136853);
            return str;
        }
        AppMethodBeat.m2505o(136853);
        return str;
    }

    /* renamed from: c */
    public static String m3862c(C7616ad c7616ad) {
        AppMethodBeat.m2504i(136851);
        String mJ = C1854s.m3866mJ(c7616ad.field_username);
        if (!C1855t.m3896kH(c7616ad.field_username)) {
            AppMethodBeat.m2505o(136851);
            return mJ;
        } else if (mJ.equals(c7616ad.field_username)) {
            List<String> oe = ((C6822c) C1720g.m3528K(C6822c.class)).mo15090XV().mo14889oe(c7616ad.field_username);
            if (oe == null || oe.size() <= 0) {
                mJ = C4996ah.getResources().getString(C25738R.string.f8738dl);
                AppMethodBeat.m2505o(136851);
                return mJ;
            }
            List arrayList = new ArrayList();
            for (String mJ2 : oe) {
                arrayList.add(C1854s.m3866mJ(mJ2));
            }
            mJ2 = "(" + C5046bo.m7536c(arrayList, ", ") + ")";
            AppMethodBeat.m2505o(136851);
            return mJ2;
        } else {
            AppMethodBeat.m2505o(136851);
            return mJ2;
        }
    }
}
