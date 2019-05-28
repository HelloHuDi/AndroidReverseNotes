package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p183ai.C7472b.C6295b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.p500s.p501a.C13114a.C3753a;
import com.tencent.p177mm.protocal.protobuf.C44103bg;
import com.tencent.p177mm.protocal.protobuf.aos;
import com.tencent.p177mm.protocal.protobuf.aot;
import com.tencent.p177mm.protocal.protobuf.bpe;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cyf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ae */
public final class C35794ae extends C40442x {
    private int egi;
    LinkedList<C40439f> vct;
    private LinkedList<C40439f> vcu;
    private LinkedList<String> vcv;

    public C35794ae(String str, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(79384);
        C4990ab.m7416i("MicroMsg.NetSceneGetSuggestionAppList", "offset: 0, limit = 20, lang = " + str + "installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C4990ab.m7417i("MicroMsg.NetSceneGetSuggestionAppList", "install id:[%s]", (String) it.next());
        }
        this.egi = 3;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aos();
        c1196a.fsK = new aot();
        c1196a.uri = "/cgi-bin/micromsg-bin/getsuggestionapplist";
        c1196a.fsI = 409;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.lty = c1196a.acD();
        aos aos = (aos) this.lty.fsG.fsP;
        aos.mZF = 3;
        aos.ncn = 0;
        aos.nco = 20;
        aos.nbs = str;
        LinkedList aD = C35794ae.m58664aD(linkedList);
        aos.wsQ = aD.size();
        aos.nbX = aD;
        this.vct = new LinkedList();
        this.vcu = new LinkedList();
        this.vcv = new LinkedList();
        this.vcv.addAll(linkedList);
        AppMethodBeat.m2505o(79384);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(79385);
        C4990ab.m7416i("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            aot aot = (aot) this.lty.fsH.fsP;
            if (aot == null) {
                C4990ab.m7412e("MicroMsg.NetSceneGetSuggestionAppList", "resp == null");
                AppMethodBeat.m2505o(79385);
                return;
            }
            C4990ab.m7419v("MicroMsg.NetSceneGetSuggestionAppList", "suggestion app count = %s, appType = %s, ", Integer.valueOf(aot.wsR), Integer.valueOf(this.egi));
            C35796i bYO = C3753a.bYQ().bYO();
            m58665b(bYO, aot.wsS);
            m58663a(bYO, aot.ncU);
            AppMethodBeat.m2505o(79385);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneGetSuggestionAppList", "errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.m2505o(79385);
    }

    /* renamed from: a */
    private void m58663a(C35796i c35796i, LinkedList<C44103bg> linkedList) {
        AppMethodBeat.m2504i(79386);
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C44103bg c44103bg = (C44103bg) it.next();
                C40439f bT = C46494g.m87739bT(c44103bg.mZr, true);
                if (bT != null) {
                    C35794ae.m58660a(bT, c44103bg);
                    c35796i.mo56566a(bT, new String[0]);
                } else {
                    bT = new C40439f();
                    bT.field_appId = c44103bg.mZr;
                    C35794ae.m58660a(bT, c44103bg);
                    c35796i.mo56573n(bT);
                }
                this.vcu.add(bT);
            }
        }
        AppMethodBeat.m2505o(79386);
    }

    /* renamed from: b */
    private void m58665b(C35796i c35796i, LinkedList<bpe> linkedList) {
        AppMethodBeat.m2504i(79387);
        if (linkedList != null && linkedList.size() > 0) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                bpe bpe = (bpe) it.next();
                if (C5046bo.isNullOrNil(bpe.mZr)) {
                    C4990ab.m7412e("MicroMsg.NetSceneGetSuggestionAppList", "error appinfo, the appid is null");
                } else {
                    Object obj;
                    boolean z = true;
                    boolean z2 = false;
                    C40439f bT = C46494g.m87739bT(bpe.mZr, true);
                    String str;
                    String str2;
                    Object[] objArr;
                    boolean z3;
                    if (bT != null) {
                        C35794ae.m58661a(bT, bpe);
                        if (this.egi == 3) {
                            bT.field_status = 5;
                            if (C5046bo.isNullOrNil(bT.dni) || C5046bo.isNullOrNil(bT.dnh)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params1, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                if (bT.dni != null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                objArr[0] = Boolean.valueOf(z3);
                                objArr[1] = Boolean.valueOf(bT.dnh != null);
                                C4990ab.m7413e(str, str2, objArr);
                                z = false;
                                z3 = false;
                                C4990ab.m7417i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", bpe.mZr, Boolean.valueOf(z3), Boolean.valueOf(z));
                                obj = bT;
                            }
                        }
                        z3 = c35796i.mo56566a(bT, new String[0]);
                        C4990ab.m7417i("MicroMsg.NetSceneGetSuggestionAppList", "update appinfo: AppID = %s, ret = %s, needAddToList = %s", bpe.mZr, Boolean.valueOf(z3), Boolean.valueOf(z));
                        obj = bT;
                    } else {
                        C40439f obj2;
                        bT = new C40439f();
                        bT.field_appId = bpe.mZr;
                        C35794ae.m58661a(bT, bpe);
                        if (this.egi == 3) {
                            bT.field_status = 5;
                            if (C5046bo.isNullOrNil(bT.dni) || C5046bo.isNullOrNil(bT.dnh)) {
                                str = "MicroMsg.NetSceneGetSuggestionAppList";
                                str2 = "wrong suggestion params2, has IntroUrl %s, has IconUrl %s";
                                objArr = new Object[2];
                                if (bT.dni != null) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                objArr[0] = Boolean.valueOf(z3);
                                objArr[1] = Boolean.valueOf(bT.dnh != null);
                                C4990ab.m7413e(str, str2, objArr);
                                z = false;
                                C4990ab.m7417i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", bpe.mZr, Boolean.valueOf(z2), Boolean.valueOf(z));
                                obj2 = bT;
                            }
                        }
                        z2 = c35796i.mo56573n(bT);
                        C4990ab.m7417i("MicroMsg.NetSceneGetSuggestionAppList", "insert appinfo: AppID = %s, ret = %s, needAddToList = %s", bpe.mZr, Boolean.valueOf(z2), Boolean.valueOf(z));
                        obj2 = bT;
                    }
                    if (!(!z || this.vcv.contains(bpe.mZr) || this.vct.contains(obj2))) {
                        this.vct.add(obj2);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(79387);
    }

    /* renamed from: aD */
    private static LinkedList<bts> m58664aD(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(79388);
        LinkedList<bts> linkedList2 = new LinkedList();
        if (linkedList == null) {
            AppMethodBeat.m2505o(79388);
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!C5046bo.isNullOrNil(str)) {
                linkedList2.add(C1946aa.m4154vy(str));
            }
        }
        AppMethodBeat.m2505o(79388);
        return linkedList2;
    }

    /* renamed from: a */
    private static void m58661a(C40439f c40439f, bpe bpe) {
        AppMethodBeat.m2504i(79389);
        c40439f.mo44076ih(bpe.vDl);
        c40439f.field_appIconUrl = bpe.vDm;
        c40439f.mo44075ig(bpe.wRy);
        c40439f.field_appName = bpe.ncH;
        c40439f.mo44077ii(bpe.vDn);
        c40439f.field_appType = bpe.vME;
        c40439f.mo44079ik(bpe.nad);
        c40439f.field_packageName = bpe.vDo;
        c40439f.mo44080il(bpe.vDp);
        if (!C5046bo.isNullOrNil(bpe.vDp)) {
            C4990ab.m7417i("MicroMsg.NetSceneGetSuggestionAppList", "google play download url is : %s, download flag is %d", bpe.vDp, Integer.valueOf(bpe.wRI));
            c40439f.mo44071hq(bpe.wRI);
        }
        c40439f.mo44081im(bpe.wRF);
        c40439f.mo44082in(bpe.wRG);
        C35794ae.m58662a(c40439f, bpe.vDq);
        C35794ae.m58666o(c40439f);
        AppMethodBeat.m2505o(79389);
    }

    /* renamed from: o */
    private static void m58666o(C40439f c40439f) {
        AppMethodBeat.m2504i(79390);
        if (!C5046bo.isNullOrNil(c40439f.field_appType) && (c40439f.field_appType.startsWith("1") || c40439f.field_appType.startsWith("6"))) {
            if (!c40439f.field_appType.endsWith(",")) {
                c40439f.field_appType += ",";
            }
            c40439f.field_appType = "," + c40439f.field_appType;
        }
        AppMethodBeat.m2505o(79390);
    }

    /* renamed from: a */
    private static void m58662a(C40439f c40439f, cyf cyf) {
        AppMethodBeat.m2504i(79391);
        C4990ab.m7419v("MicroMsg.NetSceneGetSuggestionAppList", "dealYYBDownloadInfos, appId = %s", c40439f.field_appId);
        if (cyf != null) {
            c40439f.mo44071hq(cyf.xtB);
            c40439f.mo44085iq(cyf.vMJ);
            c40439f.mo44086ir(cyf.ndR);
            c40439f.mo44083io(cyf.xtC);
            c40439f.mo44084ip(cyf.ndT);
            c40439f.mo44087is(cyf.ndU);
            c40439f.mo44072hr(cyf.ndV);
            C4990ab.m7417i("MicroMsg.NetSceneGetSuggestionAppList", "get yyb download infos:[%d],[%s],[%s],[%s],[%s],[%s],[%d]", Integer.valueOf(cyf.xtB), cyf.vMJ, cyf.ndR, cyf.xtC, cyf.ndT, cyf.ndU, Integer.valueOf(cyf.ndV));
        }
        AppMethodBeat.m2505o(79391);
    }

    /* renamed from: a */
    private static void m58660a(C40439f c40439f, C44103bg c44103bg) {
        AppMethodBeat.m2504i(79392);
        c40439f.mo44076ih(c44103bg.vDl);
        c40439f.mo44079ik(c44103bg.nad);
        c40439f.mo44077ii(c44103bg.vDn);
        c40439f.field_appName = c44103bg.ncH;
        c40439f.field_appIconUrl = c44103bg.vDm;
        c40439f.mo44080il(c44103bg.vDp);
        c40439f.mo44088it(c44103bg.vDr);
        C35794ae.m58662a(c40439f, c44103bg.vDq);
        AppMethodBeat.m2505o(79392);
    }

    public final int dhJ() {
        return ((aot) this.lty.fsH.fsP).wsR;
    }

    public final byte[] dhj() {
        AppMethodBeat.m2504i(79393);
        try {
            byte[] ZT = ((C6295b) this.lty.acF()).mo5742ZT();
            AppMethodBeat.m2505o(79393);
            return ZT;
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
            AppMethodBeat.m2505o(79393);
            return null;
        }
    }

    /* renamed from: bG */
    public final void mo9871bG(byte[] bArr) {
        AppMethodBeat.m2504i(79394);
        if (bArr == null) {
            C4990ab.m7412e("MicroMsg.NetSceneGetSuggestionAppList", "buf is null");
            AppMethodBeat.m2505o(79394);
            return;
        }
        try {
            this.lty.fsH.mo5744P(bArr);
            AppMethodBeat.m2505o(79394);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetSceneGetSuggestionAppList", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetSuggestionAppList", e, "", new Object[0]);
            AppMethodBeat.m2505o(79394);
        }
    }

    public final int getType() {
        return 4;
    }
}
