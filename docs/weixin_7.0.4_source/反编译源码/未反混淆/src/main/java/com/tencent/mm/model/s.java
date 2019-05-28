package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class s {
    private static Set<String> fkN = new HashSet();

    public static String mH(String str) {
        AppMethodBeat.i(136845);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        if (aoO == null) {
            AppMethodBeat.o(136845);
            return str;
        } else if (bo.isNullOrNil(aoO.field_nickname)) {
            AppMethodBeat.o(136845);
            return str;
        } else {
            str = aoO.field_nickname;
            AppMethodBeat.o(136845);
            return str;
        }
    }

    public static String getDisplayName(String str, String str2) {
        AppMethodBeat.i(136846);
        String mJ;
        if (bo.isNullOrNil(str2)) {
            mJ = mJ(str);
            AppMethodBeat.o(136846);
            return mJ;
        }
        mJ = mK(str);
        if (bo.isNullOrNil(mJ)) {
            mJ = n.ab(str, str2);
            if (bo.isNullOrNil(mJ)) {
                mJ = mJ(str);
                AppMethodBeat.o(136846);
                return mJ;
            }
            AppMethodBeat.o(136846);
            return mJ;
        }
        AppMethodBeat.o(136846);
        return mJ;
    }

    public static String mI(String str) {
        AppMethodBeat.i(136847);
        if (str == null || str.length() <= 0) {
            str = "";
            AppMethodBeat.o(136847);
            return str;
        }
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        ab.d("MicroMsg.ContactCommDisplay", "username: %s", str);
        if (aoO == null) {
            AppMethodBeat.o(136847);
            return str;
        }
        if (t.kH(str) && bo.isNullOrNil(aoO.field_nickname)) {
            String mJ = ((c) g.K(c.class)).XV().mJ(str);
            if (!bo.isNullOrNil(mJ)) {
                AppMethodBeat.o(136847);
                return mJ;
            }
        }
        if (aoO.Oi() == null || aoO.Oi().length() <= 0) {
            AppMethodBeat.o(136847);
            return str;
        }
        str = aoO.Oi();
        AppMethodBeat.o(136847);
        return str;
    }

    public static String mJ(String str) {
        AppMethodBeat.i(136848);
        String str2;
        if (str == null || str.length() <= 0) {
            str2 = "";
            AppMethodBeat.o(136848);
            return str2;
        }
        str2 = t.a(((j) g.K(j.class)).XM().aoO(str), str);
        AppMethodBeat.o(136848);
        return str2;
    }

    public static String a(ad adVar, String str) {
        AppMethodBeat.i(139164);
        String a = t.a(adVar, str);
        AppMethodBeat.o(139164);
        return a;
    }

    public static String a(ad adVar, String str, boolean z) {
        AppMethodBeat.i(136850);
        if (adVar == null) {
            AppMethodBeat.o(136850);
            return str;
        } else if (z && bo.isNullOrNil(adVar.field_nickname)) {
            str = ((c) g.K(c.class)).XV().mJ(str);
            AppMethodBeat.o(136850);
            return str;
        } else if (adVar.Oj() != null && adVar.Oj().length() > 0) {
            str = adVar.Oj();
            AppMethodBeat.o(136850);
            return str;
        } else if (bo.isNullOrNil(adVar.field_nickname) && t.nH(str)) {
            str = a.kN(str);
            AppMethodBeat.o(136850);
            return str;
        } else {
            AppMethodBeat.o(136850);
            return str;
        }
    }

    public static String mK(String str) {
        AppMethodBeat.i(136852);
        ad aoO = ((j) g.K(j.class)).XM().aoO(str);
        String str2;
        if (aoO == null) {
            str2 = "";
            AppMethodBeat.o(136852);
            return str2;
        } else if (bo.isNullOrNil(aoO.field_conRemark)) {
            str2 = "";
            AppMethodBeat.o(136852);
            return str2;
        } else {
            str2 = aoO.field_conRemark;
            AppMethodBeat.o(136852);
            return str2;
        }
    }

    static {
        AppMethodBeat.i(136854);
        AppMethodBeat.o(136854);
    }

    public static void c(Set<String> set) {
        fkN = set;
    }

    public static String mL(String str) {
        AppMethodBeat.i(136853);
        if (fkN.contains(str)) {
            str = "";
            AppMethodBeat.o(136853);
            return str;
        }
        AppMethodBeat.o(136853);
        return str;
    }

    public static String c(ad adVar) {
        AppMethodBeat.i(136851);
        String mJ = mJ(adVar.field_username);
        if (!t.kH(adVar.field_username)) {
            AppMethodBeat.o(136851);
            return mJ;
        } else if (mJ.equals(adVar.field_username)) {
            List<String> oe = ((c) g.K(c.class)).XV().oe(adVar.field_username);
            if (oe == null || oe.size() <= 0) {
                mJ = ah.getResources().getString(R.string.dl);
                AppMethodBeat.o(136851);
                return mJ;
            }
            List arrayList = new ArrayList();
            for (String mJ2 : oe) {
                arrayList.add(mJ(mJ2));
            }
            mJ2 = "(" + bo.c(arrayList, ", ") + ")";
            AppMethodBeat.o(136851);
            return mJ2;
        } else {
            AppMethodBeat.o(136851);
            return mJ2;
        }
    }
}
