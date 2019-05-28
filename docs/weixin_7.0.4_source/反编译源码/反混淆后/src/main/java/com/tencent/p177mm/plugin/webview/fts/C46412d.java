package com.tencent.p177mm.plugin.webview.fts;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelgeo.C26443d;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.p328r.C10706p;
import com.tencent.p177mm.plugin.appbrand.p328r.C27278r;
import com.tencent.p177mm.plugin.appbrand.service.C27297a;
import com.tencent.p177mm.plugin.websearch.api.C14423an;
import com.tencent.p177mm.plugin.websearch.api.C22760s;
import com.tencent.p177mm.plugin.websearch.api.C29744z;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.plugin.websearch.api.C7197a;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.C35933li;
import com.tencent.p177mm.protocal.protobuf.bkr;
import com.tencent.p177mm.protocal.protobuf.caw;
import com.tencent.p177mm.protocal.protobuf.cmg;
import com.tencent.p177mm.protocal.protobuf.cvf;
import com.tencent.p177mm.protocal.protobuf.cvj;
import com.tencent.p177mm.protocal.protobuf.cvk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.d */
public final class C46412d extends C7197a implements C1918k {
    private C1202f ehi;
    private C7472b fAT;
    private C22760s fpL;
    private int scene;
    private int tZw;
    private cvk ufJ;
    private cvj ufK;

    public C46412d(C22760s c22760s) {
        boolean z = false;
        AppMethodBeat.m2504i(5714);
        this.fpL = c22760s;
        this.tZu = c22760s.ctj;
        this.cIz = c22760s.nQB;
        this.f1969Lp = c22760s.offset;
        this.gOW = c22760s.scene;
        this.tZt = c22760s.cIv;
        this.tZw = c22760s.tZw;
        this.fpL = c22760s;
        this.tZv = c22760s.tZN;
        if (C5046bo.isNullOrNil(c22760s.ctj)) {
            C4990ab.m7412e("MicroMsg.FTS.NetSceneWebSearch", "keyword is unavailable");
            AppMethodBeat.m2505o(5714);
            return;
        }
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSearch", "Constructors: keyword=%s", c22760s.ctj);
        this.scene = c22760s.scene;
        C1196a c1196a = new C1196a();
        boolean z2 = c22760s.scene == 201 || c22760s.tZI == 1;
        if (z2 && C27278r.aNV()) {
            c1196a.fsI = 2676;
            c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsearch";
        } else {
            c1196a.fsI = 719;
            c1196a.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
        }
        c1196a.fsJ = new cvj();
        c1196a.fsK = new cvk();
        this.fAT = c1196a.acD();
        this.ufK = (cvj) this.fAT.fsG.fsP;
        this.ufK.wkD = c22760s.ctj;
        this.ufK.wUr = c22760s.tZw;
        this.ufK.vQd = (long) c22760s.businessType;
        this.ufK.wDI = C46400aa.abJ();
        this.ufK.vOq = c22760s.offset;
        this.ufK.wCu = C46400aa.m87305HV(0);
        this.ufK.wWp = c22760s.tZx;
        this.ufK.Scene = c22760s.scene;
        this.ufK.vQg = c22760s.lcA;
        this.ufK.xrc = c22760s.cIC;
        this.ufK.xro = c22760s.tZy;
        this.ufK.xrq = c22760s.tZA;
        this.ufK.xrp = c22760s.tZz;
        this.ufK.xrr = c22760s.tZB;
        this.ufK.xqa = c22760s.tZG;
        LinkedList linkedList = this.ufK.xqa;
        if (!C5046bo.m7548ek(linkedList)) {
            String str;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                C23447tn c23447tn = (C23447tn) it.next();
                if (c23447tn != null && "parentSearchID".equals(c23447tn.key)) {
                    str = c23447tn.waE;
                    break;
                }
            }
            str = null;
            if (!C5046bo.isNullOrNil(str)) {
                C32800b nV = C37922v.m64076Zp().mo60674nV(str);
                if (nV != null) {
                    str = nV.getString("extQueryInfo", "");
                    if (!C5046bo.isNullOrNil(str)) {
                        C23447tn c23447tn2 = new C23447tn();
                        c23447tn2.key = "extQueryInfo";
                        c23447tn2.waE = str;
                        linkedList.add(c23447tn2);
                    }
                }
            }
        }
        this.ufK.tZF = c22760s.tZF;
        this.ufK.xrs = c22760s.tZH;
        this.ufK.luQ = c22760s.aOt;
        this.ufK.wCy = c22760s.cvF;
        if (c22760s.tZK == null) {
            c22760s.tZK = new cvf();
        }
        if (c22760s.tZK.xrk == null) {
            c22760s.tZK.xrk = new C35933li();
        }
        c22760s.tZK.xrk.qzj = C10706p.m18378qc(C4996ah.getContext().getResources().getDisplayMetrics().widthPixels);
        C4990ab.m7419v("MicroMsg.FTS.NetSceneWebSearch", "width px %d, dp %d, density %f", Integer.valueOf(C4996ah.getContext().getResources().getDisplayMetrics().widthPixels), Integer.valueOf(c22760s.tZK.xrk.qzj), Float.valueOf(C4996ah.getContext().getResources().getDisplayMetrics().density));
        float f = 0.0f;
        float f2 = 0.0f;
        if (this.ufK.wDI != null) {
            c22760s.tZK.xrk.vOU = C26443d.agz().agC() ? 0 : 1;
            f = this.ufK.wDI.vRp;
            f2 = this.ufK.wDI.vRq;
        } else {
            c22760s.tZK.xrk.vOU = 1;
        }
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSearch", "websearch location: longitude[%f], latitude[%f], isUsingCached[%d]", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(c22760s.tZK.xrk.vOU));
        if (!TextUtils.isEmpty(c22760s.tZL)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(c22760s.tZL));
                bkr bkr = new bkr();
                bkr.guP = jSONObject.optString("city");
                bkr.guW = jSONObject.optString(UserDataStore.COUNTRY);
                bkr.vRq = (float) jSONObject.optDouble("latitude");
                bkr.vRp = (float) jSONObject.optDouble("longitude");
                bkr.wNK = jSONObject.optString("poiId");
                bkr.wxQ = jSONObject.optString("poiName");
                bkr.wNM = C46400aa.m87316Xq(jSONObject.optString("snsId"));
                if (!TextUtils.isEmpty(bkr.wNK)) {
                    this.ufK.xrv = bkr;
                }
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.FTS.NetSceneWebSearch", e, "", new Object[0]);
            }
        }
        if (c22760s.tZK != null) {
            try {
                c22760s.tZK.xrl = ((C27297a) C1720g.m3528K(C27297a.class)).auH();
                this.ufK.wCz = new C1332b(c22760s.tZK.toByteArray());
                C4990ab.m7419v("MicroMsg.FTS.NetSceneWebSearch", "ctrl_type %d, appid %s, ext %s", Long.valueOf(c22760s.tZK.xrj), c22760s.tZK.xrk.csB, c22760s.tZK.xrk.kLN);
            } catch (Exception e2) {
            }
        }
        if (c22760s.tZJ != null) {
            try {
                this.ufK.wCA = new C1332b(c22760s.tZJ.toByteArray());
            } catch (Exception e3) {
            }
        }
        String str2 = "MicroMsg.FTS.NetSceneWebSearch";
        String str3 = "contains location = %b | matchUserSize=%d | scene=%d | businessType=%d | isHomePage=%b | sceneActionType=%d | webViewId=%d";
        Object[] objArr = new Object[7];
        objArr[0] = Boolean.valueOf(this.ufK.wDI != null);
        objArr[1] = Integer.valueOf(c22760s.tZx.size());
        objArr[2] = Integer.valueOf(c22760s.scene);
        objArr[3] = Integer.valueOf(c22760s.businessType);
        objArr[4] = Integer.valueOf(this.tZw);
        objArr[5] = Integer.valueOf(c22760s.cIC);
        objArr[6] = Integer.valueOf(c22760s.cIv);
        C4990ab.m7417i(str2, str3, objArr);
        if (this.ufK.wDI != null) {
            C18698o.m29222a(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, this.ufK.wDI.vRp, this.ufK.wDI.vRq, this.ufK.wDI.wfG);
        }
        int i = c22760s.scene;
        str2 = c22760s.cvF;
        str3 = c22760s.cIy;
        String str4 = c22760s.lcA;
        int i2 = c22760s.offset;
        if (c22760s.tZw == 1) {
            z = true;
        }
        C29744z.m47156a(i, str2, str3, str4, i2, z, c22760s.nQB, c22760s.ctj, c22760s.businessType);
        AppMethodBeat.m2505o(5714);
    }

    public final int getType() {
        return 719;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(5715);
        C14423an.m22655gp(this.scene, 2);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(5715);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(5716);
        C4990ab.m7417i("MicroMsg.FTS.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        boolean z = i2 == 0 && i3 == 0;
        if (i2 == 0 && i3 == 0) {
            this.ufJ = (cvk) this.fAT.fsH.fsP;
            if (this.ufJ != null) {
                C29744z.m47158a(this.fpL.scene, this.fpL.cvF, this.fpL.cIy, this.fpL.lcA, this.fpL.offset, this.fpL.tZw == 1, this.fpL.nQB, z, this.fpL.ctj, this.fpL.businessType);
                C4990ab.m7419v("MicroMsg.FTS.NetSceneWebSearch", "return data\n%s", this.ufJ.vOy);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            C14423an.m22647an(this.scene, i2, i3);
            AppMethodBeat.m2505o(5716);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        C29744z.m47158a(this.fpL.scene, this.fpL.cvF, this.fpL.cIy, this.fpL.lcA, this.fpL.offset, this.fpL.tZw == 1, this.fpL.nQB, z, this.fpL.ctj, this.fpL.businessType);
        C14423an.m22647an(this.scene, i2, i3);
        AppMethodBeat.m2505o(5716);
    }

    public final String abH() {
        return this.ufJ != null ? this.ufJ.vOy : "";
    }

    public final int abI() {
        return this.ufJ != null ? this.ufJ.wCB : 0;
    }

    /* renamed from: ax */
    public final void mo15504ax(LinkedList<cmg> linkedList) {
        AppMethodBeat.m2504i(5717);
        this.ufK.wWp = linkedList;
        caw caw = new caw();
        caw.xab = linkedList.size();
        this.ufK.xrt = caw;
        AppMethodBeat.m2505o(5717);
    }
}
