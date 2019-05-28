package com.tencent.mm.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;

public final class ab {
    private c flr;

    public ab(c cVar) {
        this.flr = cVar;
    }

    static int a(boolean z, String str, boolean z2) {
        int i = 3;
        AppMethodBeat.i(16272);
        ad aoO = c.XM().aoO(str);
        if (aoO == null) {
            aoO = new ad();
        }
        if (((int) aoO.ewQ) == 0) {
            aoO.setUsername(str);
            aoO.NB();
            y(aoO);
            if (z2) {
                i = 4;
            }
            aoO.hz(i);
            aoO.NK();
            c.XM().Z(aoO);
            AppMethodBeat.o(16272);
            return 1;
        } else if (z) {
            aoO.NK();
            c.XM().b(str, aoO);
            AppMethodBeat.o(16272);
            return 2;
        } else {
            AppMethodBeat.o(16272);
            return 3;
        }
    }

    public static void x(ad adVar) {
        a adVar2;
        AppMethodBeat.i(16273);
        if (adVar2 == null) {
            adVar2 = new ad();
        }
        if (((int) adVar2.ewQ) == 0) {
            adVar2.setUsername("filehelper");
            aw.ZK();
            if (c.XR().aoZ(adVar2.field_username) == null) {
                adVar2.NC();
            } else {
                adVar2.NB();
            }
            adVar2.hz(3);
            aw.ZK();
            c.XM().Y(adVar2);
        }
        AppMethodBeat.o(16273);
    }

    static void y(ad adVar) {
        AppMethodBeat.i(16274);
        String str = adVar.field_username;
        Context context = ah.getContext();
        if (str.equals("qqsync")) {
            adVar.iB(context.getString(R.string.cay));
            adVar.iC(context.getString(R.string.caz));
            adVar.iD(context.getString(R.string.cb0));
        }
        if (str.equals("floatbottle")) {
            adVar.iB(context.getString(R.string.c_k));
            adVar.iC(context.getString(R.string.c_l));
            adVar.iD(context.getString(R.string.c_m));
        }
        if (str.equals("shakeapp")) {
            adVar.iB(context.getString(R.string.cb5));
            adVar.iC(context.getString(R.string.cb6));
            adVar.iD(context.getString(R.string.cb7));
        }
        if (str.equals("lbsapp")) {
            adVar.iB(context.getString(R.string.ca7));
            adVar.iC(context.getString(R.string.ca8));
            adVar.iD(context.getString(R.string.ca9));
        }
        if (str.equals("medianote")) {
            adVar.iB(context.getString(R.string.caf));
            adVar.iC(context.getString(R.string.cag));
            adVar.iD(context.getString(R.string.cah));
        }
        if (str.equals("newsapp")) {
            adVar.iB(context.getString(R.string.cb1));
            adVar.iC(context.getString(R.string.cb2));
            adVar.iD(context.getString(R.string.cb3));
        }
        if (str.equals("facebookapp")) {
            adVar.iB(context.getString(R.string.c_t));
            adVar.iC(context.getString(R.string.c_u));
            adVar.iD(context.getString(R.string.c_v));
        }
        if (str.equals("qqfriend")) {
            adVar.iB(context.getString(R.string.caq));
            adVar.iC(context.getString(R.string.car));
            adVar.iD(context.getString(R.string.cas));
        }
        if (str.equals("masssendapp")) {
            adVar.iB(context.getString(R.string.cac));
            adVar.iC(context.getString(R.string.cad));
            adVar.iD(context.getString(R.string.cae));
        }
        if (str.equals("feedsapp")) {
            adVar.iB(context.getString(R.string.c_w));
            adVar.iC(context.getString(R.string.c_x));
            adVar.iD(context.getString(R.string.c_y));
        }
        if (str.equals("fmessage")) {
            adVar.iB(context.getString(R.string.c_z));
            adVar.iC(context.getString(R.string.ca0));
            adVar.iD(context.getString(R.string.ca1));
        }
        if (str.equals("voipapp")) {
            adVar.iB(context.getString(R.string.cbe));
            adVar.iC(context.getString(R.string.cbf));
            adVar.iD(context.getString(R.string.cbg));
        }
        if (str.equals("officialaccounts")) {
            adVar.iB(context.getString(R.string.cam));
            adVar.iC(context.getString(R.string.can));
            adVar.iD(context.getString(R.string.cao));
        }
        if (str.equals("helper_entry")) {
            adVar.iB(context.getString(R.string.ca4));
            adVar.iC(context.getString(R.string.ca5));
            adVar.iD(context.getString(R.string.ca6));
        }
        if (str.equals("cardpackage")) {
            adVar.iB(context.getString(R.string.c_n));
            adVar.iC(context.getString(R.string.c_o));
            adVar.iD(context.getString(R.string.c_p));
        }
        if (str.equals("voicevoipapp")) {
            adVar.iB(context.getString(R.string.cbh));
            adVar.iC(context.getString(R.string.cbi));
            adVar.iD(context.getString(R.string.cbj));
        }
        if (str.equals("voiceinputapp")) {
            adVar.iB(context.getString(R.string.cbb));
            adVar.iC(context.getString(R.string.cbc));
            adVar.iD(context.getString(R.string.cbd));
        }
        if (str.equals("qqmail")) {
            adVar.iB(context.getString(R.string.cat));
            adVar.iC(context.getString(R.string.cau));
            adVar.iD(context.getString(R.string.cav));
        }
        if (str.equals("linkedinplugin")) {
            adVar.iB(context.getString(R.string.ca_));
            adVar.iC(context.getString(R.string.caa));
            adVar.iD(context.getString(R.string.cab));
        }
        if (str.equals("notifymessage")) {
            adVar.iB(context.getString(R.string.caj));
            adVar.iC(context.getString(R.string.cak));
            adVar.iD(context.getString(R.string.cal));
        }
        if (str.equals("appbrandcustomerservicemsg")) {
            adVar.iB(context.getString(R.string.c_h));
            adVar.iC(context.getString(R.string.c_i));
            adVar.iD(context.getString(R.string.c_j));
        }
        if (str.equals("downloaderapp")) {
            adVar.iB(context.getString(R.string.c_q));
            adVar.iC(context.getString(R.string.c_r));
            adVar.iD(context.getString(R.string.c_s));
        }
        AppMethodBeat.o(16274);
    }
}
