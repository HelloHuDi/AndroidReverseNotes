package com.tencent.mm.plugin.webview.fts;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.r.p;
import com.tencent.mm.plugin.appbrand.r.r;
import com.tencent.mm.plugin.websearch.api.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.cvf;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.li;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a implements k {
    private f ehi;
    private b fAT;
    private s fpL;
    private int scene;
    private int tZw;
    private cvk ufJ;
    private cvj ufK;

    public d(s sVar) {
        boolean z = false;
        AppMethodBeat.i(5714);
        this.fpL = sVar;
        this.tZu = sVar.ctj;
        this.cIz = sVar.nQB;
        this.Lp = sVar.offset;
        this.gOW = sVar.scene;
        this.tZt = sVar.cIv;
        this.tZw = sVar.tZw;
        this.fpL = sVar;
        this.tZv = sVar.tZN;
        if (bo.isNullOrNil(sVar.ctj)) {
            ab.e("MicroMsg.FTS.NetSceneWebSearch", "keyword is unavailable");
            AppMethodBeat.o(5714);
            return;
        }
        ab.i("MicroMsg.FTS.NetSceneWebSearch", "Constructors: keyword=%s", sVar.ctj);
        this.scene = sVar.scene;
        b.a aVar = new b.a();
        boolean z2 = sVar.scene == 201 || sVar.tZI == 1;
        if (z2 && r.aNV()) {
            aVar.fsI = 2676;
            aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_weappsearch";
        } else {
            aVar.fsI = 719;
            aVar.uri = "/cgi-bin/micromsg-bin/mmwebsearch";
        }
        aVar.fsJ = new cvj();
        aVar.fsK = new cvk();
        this.fAT = aVar.acD();
        this.ufK = (cvj) this.fAT.fsG.fsP;
        this.ufK.wkD = sVar.ctj;
        this.ufK.wUr = sVar.tZw;
        this.ufK.vQd = (long) sVar.businessType;
        this.ufK.wDI = aa.abJ();
        this.ufK.vOq = sVar.offset;
        this.ufK.wCu = aa.HV(0);
        this.ufK.wWp = sVar.tZx;
        this.ufK.Scene = sVar.scene;
        this.ufK.vQg = sVar.lcA;
        this.ufK.xrc = sVar.cIC;
        this.ufK.xro = sVar.tZy;
        this.ufK.xrq = sVar.tZA;
        this.ufK.xrp = sVar.tZz;
        this.ufK.xrr = sVar.tZB;
        this.ufK.xqa = sVar.tZG;
        LinkedList linkedList = this.ufK.xqa;
        if (!bo.ek(linkedList)) {
            String str;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                tn tnVar = (tn) it.next();
                if (tnVar != null && "parentSearchID".equals(tnVar.key)) {
                    str = tnVar.waE;
                    break;
                }
            }
            str = null;
            if (!bo.isNullOrNil(str)) {
                v.b nV = v.Zp().nV(str);
                if (nV != null) {
                    str = nV.getString("extQueryInfo", "");
                    if (!bo.isNullOrNil(str)) {
                        tn tnVar2 = new tn();
                        tnVar2.key = "extQueryInfo";
                        tnVar2.waE = str;
                        linkedList.add(tnVar2);
                    }
                }
            }
        }
        this.ufK.tZF = sVar.tZF;
        this.ufK.xrs = sVar.tZH;
        this.ufK.luQ = sVar.aOt;
        this.ufK.wCy = sVar.cvF;
        if (sVar.tZK == null) {
            sVar.tZK = new cvf();
        }
        if (sVar.tZK.xrk == null) {
            sVar.tZK.xrk = new li();
        }
        sVar.tZK.xrk.qzj = p.qc(ah.getContext().getResources().getDisplayMetrics().widthPixels);
        ab.v("MicroMsg.FTS.NetSceneWebSearch", "width px %d, dp %d, density %f", Integer.valueOf(ah.getContext().getResources().getDisplayMetrics().widthPixels), Integer.valueOf(sVar.tZK.xrk.qzj), Float.valueOf(ah.getContext().getResources().getDisplayMetrics().density));
        float f = 0.0f;
        float f2 = 0.0f;
        if (this.ufK.wDI != null) {
            sVar.tZK.xrk.vOU = com.tencent.mm.modelgeo.d.agz().agC() ? 0 : 1;
            f = this.ufK.wDI.vRp;
            f2 = this.ufK.wDI.vRq;
        } else {
            sVar.tZK.xrk.vOU = 1;
        }
        ab.i("MicroMsg.FTS.NetSceneWebSearch", "websearch location: longitude[%f], latitude[%f], isUsingCached[%d]", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(sVar.tZK.xrk.vOU));
        if (!TextUtils.isEmpty(sVar.tZL)) {
            try {
                JSONObject jSONObject = new JSONObject(URLDecoder.decode(sVar.tZL));
                bkr bkr = new bkr();
                bkr.guP = jSONObject.optString("city");
                bkr.guW = jSONObject.optString(UserDataStore.COUNTRY);
                bkr.vRq = (float) jSONObject.optDouble("latitude");
                bkr.vRp = (float) jSONObject.optDouble("longitude");
                bkr.wNK = jSONObject.optString("poiId");
                bkr.wxQ = jSONObject.optString("poiName");
                bkr.wNM = aa.Xq(jSONObject.optString("snsId"));
                if (!TextUtils.isEmpty(bkr.wNK)) {
                    this.ufK.xrv = bkr;
                }
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.FTS.NetSceneWebSearch", e, "", new Object[0]);
            }
        }
        if (sVar.tZK != null) {
            try {
                sVar.tZK.xrl = ((com.tencent.mm.plugin.appbrand.service.a) g.K(com.tencent.mm.plugin.appbrand.service.a.class)).auH();
                this.ufK.wCz = new com.tencent.mm.bt.b(sVar.tZK.toByteArray());
                ab.v("MicroMsg.FTS.NetSceneWebSearch", "ctrl_type %d, appid %s, ext %s", Long.valueOf(sVar.tZK.xrj), sVar.tZK.xrk.csB, sVar.tZK.xrk.kLN);
            } catch (Exception e2) {
            }
        }
        if (sVar.tZJ != null) {
            try {
                this.ufK.wCA = new com.tencent.mm.bt.b(sVar.tZJ.toByteArray());
            } catch (Exception e3) {
            }
        }
        String str2 = "MicroMsg.FTS.NetSceneWebSearch";
        String str3 = "contains location = %b | matchUserSize=%d | scene=%d | businessType=%d | isHomePage=%b | sceneActionType=%d | webViewId=%d";
        Object[] objArr = new Object[7];
        objArr[0] = Boolean.valueOf(this.ufK.wDI != null);
        objArr[1] = Integer.valueOf(sVar.tZx.size());
        objArr[2] = Integer.valueOf(sVar.scene);
        objArr[3] = Integer.valueOf(sVar.businessType);
        objArr[4] = Integer.valueOf(this.tZw);
        objArr[5] = Integer.valueOf(sVar.cIC);
        objArr[6] = Integer.valueOf(sVar.cIv);
        ab.i(str2, str3, objArr);
        if (this.ufK.wDI != null) {
            o.a(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, this.ufK.wDI.vRp, this.ufK.wDI.vRq, this.ufK.wDI.wfG);
        }
        int i = sVar.scene;
        str2 = sVar.cvF;
        str3 = sVar.cIy;
        String str4 = sVar.lcA;
        int i2 = sVar.offset;
        if (sVar.tZw == 1) {
            z = true;
        }
        z.a(i, str2, str3, str4, i2, z, sVar.nQB, sVar.ctj, sVar.businessType);
        AppMethodBeat.o(5714);
    }

    public final int getType() {
        return 719;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(5715);
        an.gp(this.scene, 2);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(5715);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(5716);
        ab.i("MicroMsg.FTS.NetSceneWebSearch", "netId %d | errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        boolean z = i2 == 0 && i3 == 0;
        if (i2 == 0 && i3 == 0) {
            this.ufJ = (cvk) this.fAT.fsH.fsP;
            if (this.ufJ != null) {
                z.a(this.fpL.scene, this.fpL.cvF, this.fpL.cIy, this.fpL.lcA, this.fpL.offset, this.fpL.tZw == 1, this.fpL.nQB, z, this.fpL.ctj, this.fpL.businessType);
                ab.v("MicroMsg.FTS.NetSceneWebSearch", "return data\n%s", this.ufJ.vOy);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            an.an(this.scene, i2, i3);
            AppMethodBeat.o(5716);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        z.a(this.fpL.scene, this.fpL.cvF, this.fpL.cIy, this.fpL.lcA, this.fpL.offset, this.fpL.tZw == 1, this.fpL.nQB, z, this.fpL.ctj, this.fpL.businessType);
        an.an(this.scene, i2, i3);
        AppMethodBeat.o(5716);
    }

    public final String abH() {
        return this.ufJ != null ? this.ufJ.vOy : "";
    }

    public final int abI() {
        return this.ufJ != null ? this.ufJ.wCB : 0;
    }

    public final void ax(LinkedList<cmg> linkedList) {
        AppMethodBeat.i(5717);
        this.ufK.wWp = linkedList;
        caw caw = new caw();
        caw.xab = linkedList.size();
        this.ufK.xrt = caw;
        AppMethodBeat.o(5717);
    }
}
