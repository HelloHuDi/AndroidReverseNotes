package com.tencent.p177mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.model.ab */
public final class C37901ab {
    private C18628c flr;

    public C37901ab(C18628c c18628c) {
        this.flr = c18628c;
    }

    /* renamed from: a */
    static int m64006a(boolean z, String str, boolean z2) {
        int i = 3;
        AppMethodBeat.m2504i(16272);
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        if (aoO == null) {
            aoO = new C7616ad();
        }
        if (((int) aoO.ewQ) == 0) {
            aoO.setUsername(str);
            aoO.mo16676NB();
            C37901ab.m64008y(aoO);
            if (z2) {
                i = 4;
            }
            aoO.mo14701hz(i);
            aoO.mo16685NK();
            C18628c.m29078XM().mo15702Z(aoO);
            AppMethodBeat.m2505o(16272);
            return 1;
        } else if (z) {
            aoO.mo16685NK();
            C18628c.m29078XM().mo15724b(str, aoO);
            AppMethodBeat.m2505o(16272);
            return 2;
        } else {
            AppMethodBeat.m2505o(16272);
            return 3;
        }
    }

    /* renamed from: x */
    public static void m64007x(C7616ad c7616ad) {
        C7486a c7616ad2;
        AppMethodBeat.m2504i(16273);
        if (c7616ad2 == null) {
            c7616ad2 = new C7616ad();
        }
        if (((int) c7616ad2.ewQ) == 0) {
            c7616ad2.setUsername("filehelper");
            C9638aw.m17190ZK();
            if (C18628c.m29083XR().aoZ(c7616ad2.field_username) == null) {
                c7616ad2.mo16677NC();
            } else {
                c7616ad2.mo16676NB();
            }
            c7616ad2.mo14701hz(3);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo15701Y(c7616ad2);
        }
        AppMethodBeat.m2505o(16273);
    }

    /* renamed from: y */
    static void m64008y(C7616ad c7616ad) {
        AppMethodBeat.m2504i(16274);
        String str = c7616ad.field_username;
        Context context = C4996ah.getContext();
        if (str.equals("qqsync")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cay));
            c7616ad.mo14704iC(context.getString(C25738R.string.caz));
            c7616ad.mo14705iD(context.getString(C25738R.string.cb0));
        }
        if (str.equals("floatbottle")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.c_k));
            c7616ad.mo14704iC(context.getString(C25738R.string.c_l));
            c7616ad.mo14705iD(context.getString(C25738R.string.c_m));
        }
        if (str.equals("shakeapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cb5));
            c7616ad.mo14704iC(context.getString(C25738R.string.cb6));
            c7616ad.mo14705iD(context.getString(C25738R.string.cb7));
        }
        if (str.equals("lbsapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.ca7));
            c7616ad.mo14704iC(context.getString(C25738R.string.ca8));
            c7616ad.mo14705iD(context.getString(C25738R.string.ca9));
        }
        if (str.equals("medianote")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.caf));
            c7616ad.mo14704iC(context.getString(C25738R.string.cag));
            c7616ad.mo14705iD(context.getString(C25738R.string.cah));
        }
        if (str.equals("newsapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cb1));
            c7616ad.mo14704iC(context.getString(C25738R.string.cb2));
            c7616ad.mo14705iD(context.getString(C25738R.string.cb3));
        }
        if (str.equals("facebookapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.c_t));
            c7616ad.mo14704iC(context.getString(C25738R.string.c_u));
            c7616ad.mo14705iD(context.getString(C25738R.string.c_v));
        }
        if (str.equals("qqfriend")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.caq));
            c7616ad.mo14704iC(context.getString(C25738R.string.car));
            c7616ad.mo14705iD(context.getString(C25738R.string.cas));
        }
        if (str.equals("masssendapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cac));
            c7616ad.mo14704iC(context.getString(C25738R.string.cad));
            c7616ad.mo14705iD(context.getString(C25738R.string.cae));
        }
        if (str.equals("feedsapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.c_w));
            c7616ad.mo14704iC(context.getString(C25738R.string.c_x));
            c7616ad.mo14705iD(context.getString(C25738R.string.c_y));
        }
        if (str.equals("fmessage")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.c_z));
            c7616ad.mo14704iC(context.getString(C25738R.string.ca0));
            c7616ad.mo14705iD(context.getString(C25738R.string.ca1));
        }
        if (str.equals("voipapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cbe));
            c7616ad.mo14704iC(context.getString(C25738R.string.cbf));
            c7616ad.mo14705iD(context.getString(C25738R.string.cbg));
        }
        if (str.equals("officialaccounts")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cam));
            c7616ad.mo14704iC(context.getString(C25738R.string.can));
            c7616ad.mo14705iD(context.getString(C25738R.string.cao));
        }
        if (str.equals("helper_entry")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.ca4));
            c7616ad.mo14704iC(context.getString(C25738R.string.ca5));
            c7616ad.mo14705iD(context.getString(C25738R.string.ca6));
        }
        if (str.equals("cardpackage")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.c_n));
            c7616ad.mo14704iC(context.getString(C25738R.string.c_o));
            c7616ad.mo14705iD(context.getString(C25738R.string.c_p));
        }
        if (str.equals("voicevoipapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cbh));
            c7616ad.mo14704iC(context.getString(C25738R.string.cbi));
            c7616ad.mo14705iD(context.getString(C25738R.string.cbj));
        }
        if (str.equals("voiceinputapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cbb));
            c7616ad.mo14704iC(context.getString(C25738R.string.cbc));
            c7616ad.mo14705iD(context.getString(C25738R.string.cbd));
        }
        if (str.equals("qqmail")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.cat));
            c7616ad.mo14704iC(context.getString(C25738R.string.cau));
            c7616ad.mo14705iD(context.getString(C25738R.string.cav));
        }
        if (str.equals("linkedinplugin")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.ca_));
            c7616ad.mo14704iC(context.getString(C25738R.string.caa));
            c7616ad.mo14705iD(context.getString(C25738R.string.cab));
        }
        if (str.equals("notifymessage")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.caj));
            c7616ad.mo14704iC(context.getString(C25738R.string.cak));
            c7616ad.mo14705iD(context.getString(C25738R.string.cal));
        }
        if (str.equals("appbrandcustomerservicemsg")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.c_h));
            c7616ad.mo14704iC(context.getString(C25738R.string.c_i));
            c7616ad.mo14705iD(context.getString(C25738R.string.c_j));
        }
        if (str.equals("downloaderapp")) {
            c7616ad.mo14703iB(context.getString(C25738R.string.c_q));
            c7616ad.mo14704iC(context.getString(C25738R.string.c_r));
            c7616ad.mo14705iD(context.getString(C25738R.string.c_s));
        }
        AppMethodBeat.m2505o(16274);
    }
}
