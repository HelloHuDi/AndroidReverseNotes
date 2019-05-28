package com.tencent.p177mm.plugin.welab.p1072a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.welab.C29974a;
import com.tencent.p177mm.plugin.welab.C40361d;
import com.tencent.p177mm.plugin.welab.C40361d.C29976a;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.plugin.welab.p1331d.p1332a.C23169a;
import com.tencent.p177mm.protocal.protobuf.axk;
import com.tencent.p177mm.protocal.protobuf.axl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.welab.a.b */
public final class C35733b implements C23167a {
    private String tag = "";
    private Map<String, Integer> uLV = new HashMap();

    public C35733b() {
        AppMethodBeat.m2504i(80562);
        ddm();
        AppMethodBeat.m2505o(80562);
    }

    private void ddm() {
        AppMethodBeat.m2504i(80563);
        this.tag = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WELAB_APP_REDPOINT_STRING, null);
        C4990ab.m7416i("LabAppLifeService", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (CharSequence charSequence : this.tag.split("&")) {
                if (!TextUtils.isEmpty(charSequence)) {
                    String[] split = charSequence.split("=");
                    if (split != null && split.length == 2) {
                        this.uLV.put(split[0], Integer.valueOf(C5046bo.ank(split[1])));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(80563);
    }

    /* renamed from: xj */
    public final boolean mo38786xj(String str) {
        AppMethodBeat.m2504i(80564);
        if (C29974a.ddj().agI(str).field_Switch == 2) {
            C4990ab.m7417i("LabAppLifeService", "appid %s is open ", str);
            AppMethodBeat.m2505o(80564);
            return true;
        }
        C4990ab.m7417i("LabAppLifeService", "appid %s is close", str);
        AppMethodBeat.m2505o(80564);
        return false;
    }

    public final boolean agM(String str) {
        boolean z;
        AppMethodBeat.m2504i(80565);
        C23169a agI = C29974a.ddj().agI(str);
        String str2 = "LabAppLifeService";
        StringBuilder append = new StringBuilder("isOnline ").append(str).append(", ");
        if (agI.ddu()) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7416i(str2, append.append(z).toString());
        if (agI.ddu()) {
            AppMethodBeat.m2505o(80565);
            return true;
        }
        AppMethodBeat.m2505o(80565);
        return false;
    }

    public final boolean agN(String str) {
        AppMethodBeat.m2504i(80566);
        if (this.uLV.get(str) == null || ((Integer) this.uLV.get(str)).intValue() == 0) {
            AppMethodBeat.m2505o(80566);
            return true;
        }
        AppMethodBeat.m2505o(80566);
        return false;
    }

    public final void open(String str) {
        AppMethodBeat.m2504i(80567);
        this.uLV.put(str, Integer.valueOf(1));
        this.tag += "&" + str + "=1";
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WELAB_APP_REDPOINT_STRING, this.tag);
        C23169a agI = C29974a.ddj().agI(str);
        C29976a c29976a = new C29976a();
        c29976a.csB = str;
        c29976a.uLT = agI.field_expId;
        c29976a.timeStamp = System.currentTimeMillis();
        c29976a.action = 3;
        C40361d.m69200a(c29976a);
        AppMethodBeat.m2505o(80567);
    }

    public final boolean agO(String str) {
        boolean z;
        AppMethodBeat.m2504i(80568);
        C23169a agI = C29974a.ddj().agI(str);
        String str2 = "LabAppLifeService";
        StringBuilder append = new StringBuilder("hitExp ").append(str).append(", ");
        if (agI.isRunning()) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7416i(str2, append.append(z).toString());
        if (agI.isRunning()) {
            AppMethodBeat.m2505o(80568);
            return true;
        }
        AppMethodBeat.m2505o(80568);
        return false;
    }

    /* renamed from: bK */
    public final void mo38784bK(String str, boolean z) {
        int i = 1;
        AppMethodBeat.m2504i(80569);
        C4990ab.m7416i("LabAppLifeService", "switchEntry " + str + "," + z);
        C23169a agI = C29974a.ddj().agI(str);
        int i2 = z ? 2 : 1;
        if (agI.field_Switch != i2) {
            agI.field_Switch = i2;
            C29974a.ddj().uLQ.mo10103c(agI, new String[0]);
            axl axl = new axl();
            axk axk = new axk();
            axk.wBs = agI.ddw() ? 0 : C5046bo.ank(agI.field_expId);
            axk.wBt = agI.field_LabsAppId;
            if (agI.field_Switch != 2) {
                i = 2;
            }
            axk.wkB = i;
            axl.eow.add(axk);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(207, axl));
            C40361d.m69201t(str, agI.field_Switch == 2 ? 4 : 5, false);
        }
        AppMethodBeat.m2505o(80569);
    }

    public final String agP(String str) {
        AppMethodBeat.m2504i(80570);
        String str2 = C29974a.ddj().agI(str).field_WeAppUser;
        AppMethodBeat.m2505o(80570);
        return str2;
    }

    public final int agQ(String str) {
        AppMethodBeat.m2504i(80571);
        int i = C29974a.ddj().agI(str).field_WeAppDebugMode;
        AppMethodBeat.m2505o(80571);
        return i;
    }
}
