package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C8920x;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.p500s.C34832a;
import com.tencent.p177mm.protocal.protobuf.C40512dl;
import com.tencent.p177mm.protocal.protobuf.C46533dm;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/* renamed from: com.tencent.mm.pluginsdk.model.app.m */
public final class C4735m implements C14887t {
    private List<String> vbN = new ArrayList();
    public Vector<String> vcj = new Vector();
    private volatile boolean vck = false;

    public C4735m() {
        AppMethodBeat.m2504i(79329);
        C34832a.bYM().mo27202a(1, (C14887t) this);
        AppMethodBeat.m2505o(79329);
    }

    /* renamed from: wy */
    public final void mo9878wy(String str) {
        AppMethodBeat.m2504i(79330);
        C4990ab.m7410d("MicroMsg.AppSettingService", "appId = ".concat(String.valueOf(str)));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.AppSettingService", "add appId is null");
            AppMethodBeat.m2505o(79330);
            return;
        }
        if (!this.vcj.contains(str)) {
            this.vcj.add(str);
        }
        m7107Pt();
        AppMethodBeat.m2505o(79330);
    }

    public final void addAll(List<String> list) {
        AppMethodBeat.m2504i(79331);
        if (list == null || list.size() == 0) {
            C4990ab.m7412e("MicroMsg.AppSettingService", "addAll list is null");
            AppMethodBeat.m2505o(79331);
            return;
        }
        for (String str : list) {
            if (!(C5046bo.isNullOrNil(str) || this.vcj.contains(str))) {
                this.vcj.add(str);
            }
        }
        m7107Pt();
        AppMethodBeat.m2505o(79331);
    }

    public static String aiN(String str) {
        AppMethodBeat.m2504i(79332);
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.AppSettingService", "getOpenIdSync, appId is null");
            AppMethodBeat.m2505o(79332);
            return null;
        }
        C40439f bS = C46494g.m87738bS(str, false);
        String str2;
        if (bS == null) {
            AppMethodBeat.m2505o(79332);
            return null;
        } else if (bS.field_openId == null || bS.field_openId.length() == 0) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(str);
            C14871ac c14871ac = new C14871ac(linkedList);
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new C40512dl();
            c1196a.fsK = new C46533dm();
            c1196a.uri = "/cgi-bin/micromsg-bin/appcenter";
            c1196a.fsI = 452;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C7472b acD = c1196a.acD();
            C40512dl c40512dl = (C40512dl) acD.fsG.fsP;
            byte[] dhj = c14871ac.dhj();
            if (dhj != null) {
                c40512dl.ReqBuf = new SKBuiltinBuffer_t().setBuffer(dhj);
            }
            c40512dl.jCt = 1;
            C37441a c = C8920x.m16082c(acD);
            C4990ab.m7417i("MicroMsg.AppSettingService", "call getOpenIdSync cgi result, errType = %d, errCode = %d", Integer.valueOf(c.errType), Integer.valueOf(c.errCode));
            if (c.errType == 0 && c.errCode == 0) {
                c14871ac.mo9871bG(C1946aa.m4150a(((C46533dm) c.fsy).vFq));
                c14871ac.mo4498a(0, c.errType, c.errCode, c.aIm, acD, new byte[0]);
                bS = C46494g.m87739bT(str, false);
                if (bS != null) {
                    str2 = bS.field_openId;
                    AppMethodBeat.m2505o(79332);
                    return str2;
                }
                AppMethodBeat.m2505o(79332);
                return null;
            }
            AppMethodBeat.m2505o(79332);
            return null;
        } else {
            str2 = bS.field_openId;
            AppMethodBeat.m2505o(79332);
            return str2;
        }
    }

    /* renamed from: Pt */
    private void m7107Pt() {
        int i = 20;
        AppMethodBeat.m2504i(79333);
        if (this.vck) {
            C4990ab.m7410d("MicroMsg.AppSettingService", "tryDoScene fail, doing Scene");
            AppMethodBeat.m2505o(79333);
        } else if (this.vcj.size() <= 0) {
            C4990ab.m7410d("MicroMsg.AppSettingService", "tryDoScene fail, appIdList is empty");
            AppMethodBeat.m2505o(79333);
        } else {
            C4990ab.m7410d("MicroMsg.AppSettingService", "tryDoScene, appid list size = " + this.vcj.size());
            int size = this.vcj.size();
            if (size <= 20) {
                i = size;
            }
            this.vck = true;
            this.vbN.addAll(this.vcj.subList(0, i));
            C1720g.m3535RO().eJo.mo14541a(new C44061y(1, new C14871ac(this.vbN)), 0);
            AppMethodBeat.m2505o(79333);
        }
    }

    /* renamed from: a */
    public final void mo9876a(int i, int i2, String str, C40442x c40442x) {
        AppMethodBeat.m2504i(79334);
        if (c40442x.getType() != 1) {
            AppMethodBeat.m2505o(79334);
            return;
        }
        this.vck = false;
        C4990ab.m7410d("MicroMsg.AppSettingService", "onSceneEnd, list size = " + ((C14871ac) c40442x).vcs.size());
        this.vcj.removeAll(this.vbN);
        this.vbN.clear();
        m7107Pt();
        AppMethodBeat.m2505o(79334);
    }
}
