package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.nq;
import com.tencent.mm.g.a.nr;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vu;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.ayq;
import com.tencent.mm.protocal.protobuf.bas;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cba;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbp;
import com.tencent.mm.protocal.protobuf.cbq;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.nl;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class s extends m implements k {
    int cNE;
    int eFs = 0;
    private c eFv = new c<nr>() {
        {
            AppMethodBeat.i(36283);
            this.xxI = nr.class.getName().hashCode();
            AppMethodBeat.o(36283);
        }

        private boolean a(nr nrVar) {
            AppMethodBeat.i(36284);
            if (s.this.qJw.containsKey(nrVar.cJX.filePath)) {
                Object encode;
                int intValue = ((Integer) s.this.qJw.remove(nrVar.cJX.filePath)).intValue();
                Object obj = "";
                try {
                    encode = URLEncoder.encode(nrVar.cJX.result, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    ab.printErrStackTrace("MicroMsg.NetSceneSnsPost", e, "", new Object[0]);
                    encode = obj;
                }
                if (s.this.eFs != 0) {
                    bau bau = (bau) s.this.qJv.get(nrVar.cJX.filePath);
                    s.this.qJu += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[]{Integer.valueOf(intValue), encode, bau.wEV, bau.Url, Integer.valueOf(nrVar.cJX.cvn)});
                }
                if (s.this.qJs == 12) {
                    String concat = "2,3,,".concat(String.valueOf(encode));
                    if (intValue == 0) {
                        try {
                            concat = concat + "," + URLEncoder.encode(s.this.qJx, "UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                            ab.e("MicroMsg.NetSceneSnsPost", "", e2.getMessage());
                        }
                    }
                    ab.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", Integer.valueOf(intValue), concat);
                    h.pYm.X(13717, concat);
                }
                s.a(s.this);
                AppMethodBeat.o(36284);
            } else {
                AppMethodBeat.o(36284);
            }
            return false;
        }
    };
    private c eFw = new c<nq>() {
        {
            AppMethodBeat.i(36286);
            this.xxI = nq.class.getName().hashCode();
            AppMethodBeat.o(36286);
        }

        private boolean a(nq nqVar) {
            AppMethodBeat.i(36287);
            if (s.this.qJw.containsKey(nqVar.cJW.filePath)) {
                int intValue = ((Integer) s.this.qJw.remove(nqVar.cJW.filePath)).intValue();
                if (s.this.qJs == 12) {
                    String str = "2,3,,";
                    if (intValue == 0) {
                        try {
                            str = str + "," + URLEncoder.encode(s.this.qJx, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            ab.e("MicroMsg.NetSceneSnsPost", "", e.getMessage());
                        }
                    }
                    ab.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", Integer.valueOf(intValue), str);
                    h.pYm.X(13717, str);
                }
                s.a(s.this);
                AppMethodBeat.o(36287);
            } else {
                AppMethodBeat.o(36287);
            }
            return false;
        }
    };
    private b ehh;
    public f ehi;
    boolean ekq = false;
    private TimeLineObject qJm;
    private TimeLineObject qJn;
    long qJo = 0;
    private int qJp = 0;
    private vt qJq;
    private vu qJr;
    int qJs;
    private HashMap<Integer, Integer> qJt = new HashMap();
    String qJu = "";
    HashMap<String, bau> qJv = new HashMap();
    HashMap<String, Integer> qJw = new HashMap();
    String qJx = "";

    public s(String str, int i, int i2, List<String> list, TimeLineObject timeLineObject, int i3, String str2, int i4, LinkedList<Long> linkedList, int i5, bav bav, boolean z, LinkedList<bts> linkedList2, cbp cbp, com.tencent.mm.bt.b bVar, String str3) {
        String str4;
        int i6;
        String str5;
        AppMethodBeat.i(36289);
        this.qJm = timeLineObject;
        this.cNE = i3;
        this.qJs = i5;
        a aVar = new a();
        aVar.fsJ = new cbq();
        aVar.fsK = new cbr();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnspost";
        aVar.fsI = 209;
        aVar.fsL = 97;
        aVar.fsM = 1000000097;
        this.ehh = aVar.acD();
        cbq cbq = (cbq) this.ehh.fsG.fsP;
        if (!TextUtils.isEmpty(timeLineObject.qNO.vCy.vCt)) {
            nl nlVar = new nl();
            nlVar.vRQ = timeLineObject.qNO.vCy.vCt;
            cbq.xba = nlVar;
        }
        v.b nV = v.Zp().nV(bav.cvF);
        if (nV != null) {
            this.qJq = new vt();
            this.qJq.cSG.cSH = nV.getString("prePublishId", "");
            this.qJq.cSG.url = nV.getString("url", "");
            this.qJq.cSG.cSJ = nV.getString("preUsername", "");
            this.qJq.cSG.cSK = nV.getString("preChatName", "");
            this.qJq.cSG.cSL = nV.getInt("preMsgIndex", 0);
            this.qJq.cSG.cSP = nV.getInt("sendAppMsgScene", 0);
            this.qJq.cSG.cSQ = nV.getInt("getA8KeyScene", 0);
            this.qJq.cSG.cSR = nV.getString("referUrl", null);
            this.qJq.cSG.cSS = nV.getString("adExtStr", null);
            this.qJq.cSG.cST = str3;
            if (nV.containsKey("_tmpl_webview_transfer_scene")) {
                this.qJr = new vu();
                this.qJr.cSV.cSW = nV.getInt("_tmpl_webview_transfer_scene", -1);
            }
            str4 = "";
            if (timeLineObject.rjC != null) {
                cdg cdg = new cdg();
                try {
                    cdg.parseFrom(Base64.decode(timeLineObject.rjC, 0));
                    if (cdg.xcU != null) {
                        str4 = cdg.xcU.mVX;
                    }
                } catch (Exception e) {
                }
            }
            if (bo.isNullOrNil(str4) && timeLineObject.xfH != null) {
                str4 = timeLineObject.xfH.Id;
            }
            cbq.xaZ = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qJq.cSG.cSH, this.qJq.cSG.cSJ, this.qJq.cSG.cSK, Integer.valueOf(u.ad(this.qJq.cSG.cSJ, this.qJq.cSG.cSK)), Integer.valueOf(this.qJq.cSG.cSQ), str4});
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(str.getBytes());
        String str6 = "MicroMsg.NetSceneSnsPost";
        String str7 = "len:%d   skb:%d ctx.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(str.length());
        objArr[1] = Integer.valueOf(sKBuiltinBuffer_t.getILen());
        if (bVar == null) {
            i6 = 0;
        } else {
            i6 = bVar.wR.length;
        }
        objArr[2] = Integer.valueOf(i6);
        ab.i(str6, str7, objArr);
        cbq.xam = sKBuiltinBuffer_t;
        cbq.xaU = i;
        cbq.wFe = i2;
        cbq.ptv = str2;
        this.qJp = i;
        if (ae.gib) {
            cbq.xam = new SKBuiltinBuffer_t();
            ab.e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
        }
        LinkedList linkedList3 = new LinkedList();
        if (list != null && list.size() > 0) {
            str4 = "";
            Iterator it = list.iterator();
            while (true) {
                str5 = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = (String) it.next();
                bts bts = new bts();
                bts.alV(str4);
                linkedList3.add(bts);
                str4 = str5 + "; + " + str4;
            }
            ab.d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(str5)));
        }
        cbq.xaw = linkedList3;
        cbq.xav = linkedList3.size();
        cbq.xaV = i4;
        str5 = "MicroMsg.NetSceneSnsPost";
        str6 = "setObjectSource: %d, clientid:%s fromScene:%s, score:%d";
        Object[] objArr2 = new Object[4];
        objArr2[0] = Integer.valueOf(i5);
        objArr2[1] = str2;
        objArr2[2] = cbq.xaZ;
        objArr2[3] = Integer.valueOf(bav.wFw != null ? bav.wFw.wZS : 0);
        ab.i(str5, str6, objArr2);
        if (linkedList2 != null && linkedList2.size() > 0) {
            if (z) {
                cbq.xaB = linkedList2;
                cbq.xaA = linkedList2.size();
            } else {
                cbq.wFp = linkedList2;
                cbq.xaC = linkedList2.size();
            }
        }
        ab.d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(i5)));
        cbq.xaW = i5;
        civ civ = new civ();
        if (!bo.isNullOrNil(bav.token)) {
            civ.xhJ = bav.token;
            civ.xhK = bav.wFn;
            cbq.wNQ = civ;
        }
        if (!(linkedList == null || linkedList.isEmpty())) {
            cbq.wHG = linkedList.size();
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                Long l = (Long) it2.next();
                cba cba = new cba();
                cba.xak = l.longValue();
                cbq.wFk.add(cba);
            }
            ab.d("MicroMsg.NetSceneSnsPost", "tagid " + linkedList.size() + " " + cbq.wFk.toString());
        }
        cbq.wFq = cbp;
        if (!bo.isNullOrNil(bav.wFs)) {
            cbq.xaE = new cbu();
        }
        if (cbp != null) {
            ab.d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", cbp.vFJ, cbp.vFK, cbp.vFL);
        }
        if (bVar != null) {
            cbq.xaY = new SKBuiltinBuffer_t().setBuffer(bVar);
        }
        cbq.xbd = bav.wFw;
        n DK = af.cnF().DK(this.cNE);
        if (DK != null && ((DK.field_type == 1 || DK.field_type == 15) && timeLineObject.xfI != null && timeLineObject.xfI.wbK != null && timeLineObject.xfI.wbK.size() > 0 && bav.wFf != null && bav.wFf.size() == timeLineObject.xfI.wbK.size())) {
            str7 = af.getAccSnsPath();
            i6 = 0;
            Iterator it3 = timeLineObject.xfI.wbK.iterator();
            while (true) {
                int i7 = i6;
                if (!it3.hasNext()) {
                    break;
                }
                bau bau = (bau) it3.next();
                if (bau.jCt == 2 || bau.jCt == 6) {
                    bas bas = new bas();
                    bas.nda = bau.jCt == 2 ? 2 : 1;
                    if (bau.jCt == 6) {
                        com.tencent.mm.plugin.sight.base.a WR = d.WR(an.fZ(str7, bau.Id) + i.p(bau));
                        if (WR != null) {
                            bas.wED = (int) Math.round(((double) WR.eWK) / 1000.0d);
                        }
                    }
                    r kE = af.cnu().kE((long) ((ayq) bav.wFf.get(i7)).wCt);
                    try {
                        bax bax = (bax) new bax().parseFrom(kE.rfI);
                        bas.vFH = bax.wFI;
                        this.qJt.put(Integer.valueOf(kE.reX), Integer.valueOf(bax.wFI));
                    } catch (Exception e2) {
                    }
                    ab.i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s", Integer.valueOf(bas.vFH), Integer.valueOf(bas.wED), Integer.valueOf(bas.nda));
                    cbq.xbc.add(bas);
                }
                i6 = i7 + 1;
            }
            cbq.xbb = cbq.xbc.size();
            ab.i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", Integer.valueOf(cbq.xbb));
        }
        cbq.vIl = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.b.oTO.bVS());
        AppMethodBeat.o(36289);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36290);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36290);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x03fc A:{Catch:{ Exception -> 0x04cf }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36291);
        ab.i("MicroMsg.NetSceneSnsPost", "post netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cbr cbr = (cbr) ((b) qVar).fsH.fsP;
        rr rrVar;
        if (i2 == 4) {
            n DK = af.cnF().DK(this.cNE);
            try {
                bav bav = (bav) new bav().parseFrom(DK.field_postBuf);
                bav.wFm = i3;
                bav.wFu = cbr.wFu;
                bav.wFv = false;
                DK.field_postBuf = bav.toByteArray();
            } catch (Exception e) {
            }
            if (DK != null) {
                DK.cqY();
                af.cnF().b(this.cNE, DK);
                af.cnE().CT(this.cNE);
                ab.d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + DK.cqU());
                rp rpVar = new rp();
                rpVar.cNA.cNB = (long) this.cNE;
                com.tencent.mm.sdk.b.a.xxA.m(rpVar);
            }
            if (!(this.qJm == null || this.qJm.xfI == null || this.qJm.xfI.wbJ != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.kT(8);
                switch (i3) {
                    case -1:
                        com.tencent.mm.plugin.sns.lucky.a.b.kT(19);
                        break;
                    case 201:
                        com.tencent.mm.plugin.sns.lucky.a.b.kT(17);
                        break;
                    case 211:
                        com.tencent.mm.plugin.sns.lucky.a.b.kT(18);
                        break;
                    default:
                        com.tencent.mm.plugin.sns.lucky.a.b.kT(20);
                        break;
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36291);
        } else if (i3 != 0) {
            af.cnE().CT(this.cNE);
            if (!(this.qJm == null || this.qJm.xfI == null || this.qJm.xfI.wbJ != 21)) {
                com.tencent.mm.plugin.sns.lucky.a.b.kT(8);
                com.tencent.mm.plugin.sns.lucky.a.b.kT(16);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36291);
        } else if (cbr.wZu == null || cbr.wZu.xam == null || cbr.wZu.xam.getBuffer() == null) {
            ab.e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
            af.cnE().CT(this.cNE);
            n DK2 = af.cnF().DK(this.cNE);
            if (DK2 != null) {
                DK2.cqX();
                af.cnF().b(this.cNE, DK2);
                rrVar = new rr();
                rrVar.cNG.cNB = (long) this.cNE;
                com.tencent.mm.sdk.b.a.xxA.m(rrVar);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36291);
        } else {
            String str2;
            String str3 = new String(cbr.wZu.xam.getBuffer().toByteArray());
            if (this.qJp == 0) {
                ab.d("MicroMsg.NetSceneSnsPost", "resp " + str3 + "  ");
            }
            this.qJn = com.tencent.mm.modelsns.e.tC(str3);
            if (this.qJn.xfN != null) {
                str2 = this.qJn.Id;
                String str4 = this.qJn.xfN.fiN;
                String str5 = this.qJn.xfN.fiM;
                com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                dVar.l("20CurrPublishId", str2 + ",");
                dVar.l("20SourcePublishId", str4 + ",");
                dVar.l("20SourceAdUxInfo", str5 + ",");
                ab.i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + dVar.Fk());
                h.pYm.e(13004, dVar);
            }
            n DK3 = af.cnF().DK(this.cNE);
            if (DK3 == null) {
                ab.e("MicroMsg.NetSceneSnsPost", "the item has delete");
                DK3 = new n();
            }
            DK3.ls(cbr.wZu.pcX);
            DK3.YR(str3);
            DK3.field_localFlag &= -17;
            DK3.kz(cbr.wZu.vQE);
            DK3.kB(cbr.wZu.vQE);
            if ((cbr.wZu.wGz & 1) > 0) {
                DK3.cqR();
            }
            this.qJo = cbr.wZu.vQE;
            if (this.qJq != null) {
                this.qJq.cSG.cSI = "sns_" + i.jV(this.qJo);
                com.tencent.mm.sdk.b.a.xxA.m(this.qJq);
            }
            if (!(this.qJr == null || this.qJr.cSV.cSW == -1)) {
                com.tencent.mm.sdk.b.a.xxA.m(this.qJr);
            }
            cbf cbf = cbr.wZu;
            cbf.xam.setBuffer(new byte[0]);
            try {
                com.tencent.mm.modelsns.b co;
                String str6;
                long j;
                rq rqVar;
                if (cbf.xas == 0 && cbf.xap == 0 && cbf.xav == 0 && cbf.wHG == 0) {
                    ab.d("MicroMsg.NetSceneSnsPost", "no use! this buf");
                    DK3.cqX();
                    af.cnF().b(this.cNE, DK3);
                    af.cnE().CT(this.cNE);
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(36282);
                            u.cna();
                            AppMethodBeat.o(36282);
                        }
                    });
                    co = g.qTp.co(Integer.valueOf(this.cNE));
                    co.ajH();
                    co.ajI();
                    co.tz(this.qJn.Id);
                    co.mb(this.qJn.xfI.wbJ);
                    co.ajK();
                    co = com.tencent.mm.plugin.sns.i.h.qTp.co(Integer.valueOf(this.cNE));
                    co.ajH();
                    co.ajI();
                    co.tz(this.qJn.Id);
                    co.mb(this.qJn.xfI.wbJ);
                    co.ajK();
                    rrVar = new rr();
                    rrVar.cNG.cNB = (long) this.cNE;
                    com.tencent.mm.sdk.b.a.xxA.m(rrVar);
                    if (DK3.field_type == 21) {
                    }
                    a(this.qJm, this.qJn);
                    if (this.qJn != null) {
                    }
                    XQ(str6);
                    if (af.cnB() != null) {
                    }
                    if (DK3.field_type == 15) {
                    }
                    j = cbf.vQE;
                    rqVar = new rq();
                    rqVar.cNC.cND = j;
                    rqVar.cNC.cNE = this.cNE;
                    rqVar.cNC.cNF = this.qJt;
                    com.tencent.mm.sdk.b.a.xxA.m(rqVar);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.o(36291);
                }
                DK3.bi(cbf.toByteArray());
                DK3.cqX();
                af.cnF().b(this.cNE, DK3);
                af.cnE().CT(this.cNE);
                if (((this.qJm.xfI.wbJ == 1 && this.qJm.dtW == 0 && this.qJn.dtW == 1) || (this.qJm.xfI.wbJ == 15 && this.qJm.xfP == 0 && this.qJn.xfP == 1)) && com.tencent.mm.plugin.sns.storage.i.kw(com.tencent.mm.plugin.sns.storage.v.Zm(DK3.cqA()))) {
                    new ak(Looper.getMainLooper()).post(/* anonymous class already generated */);
                }
                co = g.qTp.co(Integer.valueOf(this.cNE));
                if (!(co == null || this.qJn == null)) {
                    co.ajH();
                    co.ajI();
                    co.tz(this.qJn.Id);
                    co.mb(this.qJn.xfI.wbJ);
                    co.ajK();
                }
                co = com.tencent.mm.plugin.sns.i.h.qTp.co(Integer.valueOf(this.cNE));
                if (!(co == null || this.qJn == null)) {
                    co.ajH();
                    co.ajI();
                    co.tz(this.qJn.Id);
                    co.mb(this.qJn.xfI.wbJ);
                    co.ajK();
                }
                rrVar = new rr();
                rrVar.cNG.cNB = (long) this.cNE;
                com.tencent.mm.sdk.b.a.xxA.m(rrVar);
                if (DK3.field_type == 21) {
                    com.tencent.mm.plugin.sns.lucky.a.b.kT(7);
                    System.currentTimeMillis();
                }
                a(this.qJm, this.qJn);
                if (this.qJn != null) {
                    str6 = "";
                } else {
                    str6 = this.qJn.xfF;
                }
                XQ(str6);
                if (af.cnB() != null) {
                    af.cnB().cmp();
                }
                try {
                    if (DK3.field_type == 15) {
                        bau bau = (bau) this.qJn.xfI.wbK.get(0);
                        if (bau != null) {
                            str2 = an.fZ(af.getAccSnsPath(), bau.Id) + i.j(bau);
                            com.tencent.mm.modelvideo.n alj = com.tencent.mm.modelvideo.n.alj();
                            str6 = bau.Url;
                            long j2 = cbf.vQE;
                            if (!(bo.isNullOrNil(str6) || bo.isNullOrNil(str2))) {
                                String str7 = str6.hashCode();
                                ab.d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", str7, str6, Long.valueOf(j2), str2);
                                com.tencent.mm.modelvideo.n.a aVar = (com.tencent.mm.modelvideo.n.a) alj.fWm.get(str7);
                                if (aVar != null) {
                                    aVar.fWB = String.valueOf(j2);
                                    aVar.fWA = str2;
                                    alj.a(aVar.fVQ, str7);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                }
                j = cbf.vQE;
                rqVar = new rq();
                rqVar.cNC.cND = j;
                rqVar.cNC.cNE = this.cNE;
                rqVar.cNC.cNF = this.qJt;
                com.tencent.mm.sdk.b.a.xxA.m(rqVar);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36291);
            } catch (IOException e3) {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsPost", e3, "", new Object[0]);
            }
        }
    }

    private void XQ(String str) {
        AppMethodBeat.i(36292);
        this.qJx = str;
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100132");
        if (ll.isValid()) {
            this.eFs = bo.getInt((String) ll.dru().get("needUploadData"), 1);
        }
        if (this.qJs == 12 || this.eFs != 0) {
            if (!(this.qJn == null || this.qJn.xfI == null || this.qJn.xfI.wbK == null || this.qJn.xfI.wbK.size() <= 0)) {
                LinkedList linkedList = this.qJn.xfI.wbK;
                com.tencent.mm.sdk.b.a.xxA.c(this.eFv);
                com.tencent.mm.sdk.b.a.xxA.c(this.eFw);
                Iterator it = linkedList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    bau bau = (bau) it.next();
                    if (bau.jCt == 2) {
                        String C = g.C(bau);
                        if (!bo.isNullOrNil(C)) {
                            this.qJw.put(C, Integer.valueOf(i));
                            this.qJv.put(C, bau);
                            int i2 = i + 1;
                            np npVar = new np();
                            npVar.cJU.filePath = C;
                            com.tencent.mm.sdk.b.a.xxA.m(npVar);
                            i = i2;
                        }
                    }
                }
            }
            AppMethodBeat.o(36292);
            return;
        }
        AppMethodBeat.o(36292);
    }

    private static boolean a(TimeLineObject timeLineObject, TimeLineObject timeLineObject2) {
        AppMethodBeat.i(36293);
        if (timeLineObject == null || timeLineObject2 == null || timeLineObject.xfI == null || timeLineObject2.xfI == null) {
            AppMethodBeat.o(36293);
            return false;
        }
        String accSnsPath = af.getAccSnsPath();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= timeLineObject.xfI.wbK.size() || i2 >= timeLineObject2.xfI.wbK.size()) {
                AppMethodBeat.o(36293);
            } else {
                bau bau = (bau) timeLineObject.xfI.wbK.get(i2);
                bau bau2 = (bau) timeLineObject2.xfI.wbK.get(i2);
                String m = i.m(bau);
                String n = i.n(bau);
                String o = i.o(bau);
                String p = i.p(bau);
                String l = i.l(bau2);
                String e = i.e(bau2);
                String f = i.f(bau2);
                String j = i.j(bau2);
                ab.d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + m + "  - " + l);
                String fZ = an.fZ(accSnsPath, bau.Id);
                String fZ2 = an.fZ(accSnsPath, bau2.Id);
                com.tencent.mm.vfs.e.tf(fZ2);
                com.tencent.mm.vfs.e.aQ(fZ + m, fZ2 + l);
                com.tencent.mm.vfs.e.aQ(fZ + n, fZ2 + e);
                com.tencent.mm.vfs.e.aQ(fZ + o, fZ2 + f);
                if (com.tencent.mm.vfs.e.ct(fZ + p)) {
                    ab.i("MicroMsg.NetSceneSnsPost", "post done copy file %s", fZ2 + j);
                    com.tencent.mm.vfs.e.aQ(fZ + p, fZ2 + j);
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(36293);
        return true;
    }

    public final int getType() {
        return 209;
    }

    static /* synthetic */ void a(s sVar) {
        AppMethodBeat.i(36294);
        if (sVar.qJw.isEmpty()) {
            com.tencent.mm.sdk.b.a.xxA.d(sVar.eFv);
            com.tencent.mm.sdk.b.a.xxA.d(sVar.eFw);
            if (!(sVar.eFs == 0 || bo.isNullOrNil(sVar.qJu))) {
                String str = sVar.qJn.xfH == null ? "" : sVar.qJn.xfH.Id;
                int size = sVar.qJn.xfI.wbK.size();
                ab.i("MicroMsg.NetSceneSnsPost", "report qrCodeImgSns(13627), snsId:%s, size:%d, info:%s, appId:%s", sVar.qJn.Id, Integer.valueOf(size), sVar.qJu, str);
                o.y(13627, String.format(Locale.US, "%s,%d,%s,%s", new Object[]{sVar.qJn.Id, Integer.valueOf(size), sVar.qJu, str}));
            }
        }
        AppMethodBeat.o(36294);
    }
}
