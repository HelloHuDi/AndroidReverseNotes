package com.tencent.mm.plugin.welab.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.welab.a.a.a;
import com.tencent.mm.plugin.welab.d;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.HashMap;
import java.util.Map;

public final class b implements a {
    private String tag = "";
    private Map<String, Integer> uLV = new HashMap();

    public b() {
        AppMethodBeat.i(80562);
        ddm();
        AppMethodBeat.o(80562);
    }

    private void ddm() {
        AppMethodBeat.i(80563);
        this.tag = (String) g.RP().Ry().get(ac.a.USERINFO_WELAB_APP_REDPOINT_STRING, null);
        ab.i("LabAppLifeService", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (CharSequence charSequence : this.tag.split("&")) {
                if (!TextUtils.isEmpty(charSequence)) {
                    String[] split = charSequence.split("=");
                    if (split != null && split.length == 2) {
                        this.uLV.put(split[0], Integer.valueOf(bo.ank(split[1])));
                    }
                }
            }
        }
        AppMethodBeat.o(80563);
    }

    public final boolean xj(String str) {
        AppMethodBeat.i(80564);
        if (com.tencent.mm.plugin.welab.a.ddj().agI(str).field_Switch == 2) {
            ab.i("LabAppLifeService", "appid %s is open ", str);
            AppMethodBeat.o(80564);
            return true;
        }
        ab.i("LabAppLifeService", "appid %s is close", str);
        AppMethodBeat.o(80564);
        return false;
    }

    public final boolean agM(String str) {
        boolean z;
        AppMethodBeat.i(80565);
        com.tencent.mm.plugin.welab.d.a.a agI = com.tencent.mm.plugin.welab.a.ddj().agI(str);
        String str2 = "LabAppLifeService";
        StringBuilder append = new StringBuilder("isOnline ").append(str).append(", ");
        if (agI.ddu()) {
            z = true;
        } else {
            z = false;
        }
        ab.i(str2, append.append(z).toString());
        if (agI.ddu()) {
            AppMethodBeat.o(80565);
            return true;
        }
        AppMethodBeat.o(80565);
        return false;
    }

    public final boolean agN(String str) {
        AppMethodBeat.i(80566);
        if (this.uLV.get(str) == null || ((Integer) this.uLV.get(str)).intValue() == 0) {
            AppMethodBeat.o(80566);
            return true;
        }
        AppMethodBeat.o(80566);
        return false;
    }

    public final void open(String str) {
        AppMethodBeat.i(80567);
        this.uLV.put(str, Integer.valueOf(1));
        this.tag += "&" + str + "=1";
        g.RP().Ry().set(ac.a.USERINFO_WELAB_APP_REDPOINT_STRING, this.tag);
        com.tencent.mm.plugin.welab.d.a.a agI = com.tencent.mm.plugin.welab.a.ddj().agI(str);
        d.a aVar = new d.a();
        aVar.csB = str;
        aVar.uLT = agI.field_expId;
        aVar.timeStamp = System.currentTimeMillis();
        aVar.action = 3;
        d.a(aVar);
        AppMethodBeat.o(80567);
    }

    public final boolean agO(String str) {
        boolean z;
        AppMethodBeat.i(80568);
        com.tencent.mm.plugin.welab.d.a.a agI = com.tencent.mm.plugin.welab.a.ddj().agI(str);
        String str2 = "LabAppLifeService";
        StringBuilder append = new StringBuilder("hitExp ").append(str).append(", ");
        if (agI.isRunning()) {
            z = true;
        } else {
            z = false;
        }
        ab.i(str2, append.append(z).toString());
        if (agI.isRunning()) {
            AppMethodBeat.o(80568);
            return true;
        }
        AppMethodBeat.o(80568);
        return false;
    }

    public final void bK(String str, boolean z) {
        int i = 1;
        AppMethodBeat.i(80569);
        ab.i("LabAppLifeService", "switchEntry " + str + "," + z);
        com.tencent.mm.plugin.welab.d.a.a agI = com.tencent.mm.plugin.welab.a.ddj().agI(str);
        int i2 = z ? 2 : 1;
        if (agI.field_Switch != i2) {
            agI.field_Switch = i2;
            com.tencent.mm.plugin.welab.a.ddj().uLQ.c(agI, new String[0]);
            axl axl = new axl();
            axk axk = new axk();
            axk.wBs = agI.ddw() ? 0 : bo.ank(agI.field_expId);
            axk.wBt = agI.field_LabsAppId;
            if (agI.field_Switch != 2) {
                i = 2;
            }
            axk.wkB = i;
            axl.eow.add(axk);
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(207, axl));
            d.t(str, agI.field_Switch == 2 ? 4 : 5, false);
        }
        AppMethodBeat.o(80569);
    }

    public final String agP(String str) {
        AppMethodBeat.i(80570);
        String str2 = com.tencent.mm.plugin.welab.a.ddj().agI(str).field_WeAppUser;
        AppMethodBeat.o(80570);
        return str2;
    }

    public final int agQ(String str) {
        AppMethodBeat.i(80571);
        int i = com.tencent.mm.plugin.welab.a.ddj().agI(str).field_WeAppDebugMode;
        AppMethodBeat.o(80571);
        return i;
    }
}
