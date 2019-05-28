package com.tencent.p177mm.plugin.sns.model;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.modelsns.C32831d;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.C37953e;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.modelvideo.C45459n;
import com.tencent.p177mm.modelvideo.C45459n.C42227a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C18346nr;
import com.tencent.p177mm.p230g.p231a.C18386rp;
import com.tencent.p177mm.p230g.p231a.C18388rq;
import com.tencent.p177mm.p230g.p231a.C18433vt;
import com.tencent.p177mm.p230g.p231a.C26235rr;
import com.tencent.p177mm.p230g.p231a.C26265vu;
import com.tencent.p177mm.p230g.p231a.C37774nq;
import com.tencent.p177mm.p230g.p231a.C45347np;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.normsg.p473a.C6998b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.plugin.sight.base.C43528a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21904b;
import com.tencent.p177mm.plugin.sns.p517i.C24827g;
import com.tencent.p177mm.plugin.sns.p517i.C24828h;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C29098r;
import com.tencent.p177mm.plugin.sns.storage.C35002v;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.C40550nl;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.ayq;
import com.tencent.p177mm.protocal.protobuf.bas;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.protocal.protobuf.bax;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.cba;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbp;
import com.tencent.p177mm.protocal.protobuf.cbq;
import com.tencent.p177mm.protocal.protobuf.cbr;
import com.tencent.p177mm.protocal.protobuf.cbu;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.protocal.protobuf.civ;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.sns.model.s */
public final class C34959s extends C1207m implements C1918k {
    int cNE;
    int eFs = 0;
    private C4884c eFv = new C349612();
    private C4884c eFw = new C349603();
    private C7472b ehh;
    public C1202f ehi;
    boolean ekq = false;
    private TimeLineObject qJm;
    private TimeLineObject qJn;
    long qJo = 0;
    private int qJp = 0;
    private C18433vt qJq;
    private C26265vu qJr;
    int qJs;
    private HashMap<Integer, Integer> qJt = new HashMap();
    String qJu = "";
    HashMap<String, bau> qJv = new HashMap();
    HashMap<String, Integer> qJw = new HashMap();
    String qJx = "";

    /* renamed from: com.tencent.mm.plugin.sns.model.s$3 */
    class C349603 extends C4884c<C37774nq> {
        C349603() {
            AppMethodBeat.m2504i(36286);
            this.xxI = C37774nq.class.getName().hashCode();
            AppMethodBeat.m2505o(36286);
        }

        /* renamed from: a */
        private boolean m57427a(C37774nq c37774nq) {
            AppMethodBeat.m2504i(36287);
            if (C34959s.this.qJw.containsKey(c37774nq.cJW.filePath)) {
                int intValue = ((Integer) C34959s.this.qJw.remove(c37774nq.cJW.filePath)).intValue();
                if (C34959s.this.qJs == 12) {
                    String str = "2,3,,";
                    if (intValue == 0) {
                        try {
                            str = str + "," + URLEncoder.encode(C34959s.this.qJx, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            C4990ab.m7413e("MicroMsg.NetSceneSnsPost", "", e.getMessage());
                        }
                    }
                    C4990ab.m7417i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", Integer.valueOf(intValue), str);
                    C7060h.pYm.mo8374X(13717, str);
                }
                C34959s.m57423a(C34959s.this);
                AppMethodBeat.m2505o(36287);
            } else {
                AppMethodBeat.m2505o(36287);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.s$2 */
    class C349612 extends C4884c<C18346nr> {
        C349612() {
            AppMethodBeat.m2504i(36283);
            this.xxI = C18346nr.class.getName().hashCode();
            AppMethodBeat.m2505o(36283);
        }

        /* renamed from: a */
        private boolean m57429a(C18346nr c18346nr) {
            AppMethodBeat.m2504i(36284);
            if (C34959s.this.qJw.containsKey(c18346nr.cJX.filePath)) {
                Object encode;
                int intValue = ((Integer) C34959s.this.qJw.remove(c18346nr.cJX.filePath)).intValue();
                Object obj = "";
                try {
                    encode = URLEncoder.encode(c18346nr.cJX.result, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsPost", e, "", new Object[0]);
                    encode = obj;
                }
                if (C34959s.this.eFs != 0) {
                    bau bau = (bau) C34959s.this.qJv.get(c18346nr.cJX.filePath);
                    C34959s.this.qJu += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[]{Integer.valueOf(intValue), encode, bau.wEV, bau.Url, Integer.valueOf(c18346nr.cJX.cvn)});
                }
                if (C34959s.this.qJs == 12) {
                    String concat = "2,3,,".concat(String.valueOf(encode));
                    if (intValue == 0) {
                        try {
                            concat = concat + "," + URLEncoder.encode(C34959s.this.qJx, "UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                            C4990ab.m7413e("MicroMsg.NetSceneSnsPost", "", e2.getMessage());
                        }
                    }
                    C4990ab.m7417i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", Integer.valueOf(intValue), concat);
                    C7060h.pYm.mo8374X(13717, concat);
                }
                C34959s.m57423a(C34959s.this);
                AppMethodBeat.m2505o(36284);
            } else {
                AppMethodBeat.m2505o(36284);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.model.s$1 */
    class C349621 implements Runnable {
        C349621() {
        }

        public final void run() {
            AppMethodBeat.m2504i(36282);
            C7101u.cna();
            AppMethodBeat.m2505o(36282);
        }
    }

    public C34959s(String str, int i, int i2, List<String> list, TimeLineObject timeLineObject, int i3, String str2, int i4, LinkedList<Long> linkedList, int i5, bav bav, boolean z, LinkedList<bts> linkedList2, cbp cbp, C1332b c1332b, String str3) {
        String str4;
        int i6;
        String str5;
        AppMethodBeat.m2504i(36289);
        this.qJm = timeLineObject;
        this.cNE = i3;
        this.qJs = i5;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cbq();
        c1196a.fsK = new cbr();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnspost";
        c1196a.fsI = 209;
        c1196a.fsL = 97;
        c1196a.fsM = 1000000097;
        this.ehh = c1196a.acD();
        cbq cbq = (cbq) this.ehh.fsG.fsP;
        if (!TextUtils.isEmpty(timeLineObject.qNO.vCy.vCt)) {
            C40550nl c40550nl = new C40550nl();
            c40550nl.vRQ = timeLineObject.qNO.vCy.vCt;
            cbq.xba = c40550nl;
        }
        C32800b nV = C37922v.m64076Zp().mo60674nV(bav.cvF);
        if (nV != null) {
            this.qJq = new C18433vt();
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
                this.qJr = new C26265vu();
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
            if (C5046bo.isNullOrNil(str4) && timeLineObject.xfH != null) {
                str4 = timeLineObject.xfH.f17242Id;
            }
            cbq.xaZ = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[]{this.qJq.cSG.cSH, this.qJq.cSG.cSJ, this.qJq.cSG.cSK, Integer.valueOf(C32798u.m53583ad(this.qJq.cSG.cSJ, this.qJq.cSG.cSK)), Integer.valueOf(this.qJq.cSG.cSQ), str4});
        }
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        sKBuiltinBuffer_t.setBuffer(str.getBytes());
        String str6 = "MicroMsg.NetSceneSnsPost";
        String str7 = "len:%d   skb:%d ctx.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(str.length());
        objArr[1] = Integer.valueOf(sKBuiltinBuffer_t.getILen());
        if (c1332b == null) {
            i6 = 0;
        } else {
            i6 = c1332b.f1226wR.length;
        }
        objArr[2] = Integer.valueOf(i6);
        C4990ab.m7417i(str6, str7, objArr);
        cbq.xam = sKBuiltinBuffer_t;
        cbq.xaU = i;
        cbq.wFe = i2;
        cbq.ptv = str2;
        this.qJp = i;
        if (C1947ae.gib) {
            cbq.xam = new SKBuiltinBuffer_t();
            C4990ab.m7412e("MicroMsg.NetSceneSnsPost", "post error setObjectDesc is null!");
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
            C4990ab.m7410d("MicroMsg.NetSceneSnsPost", "post with list : ".concat(String.valueOf(str5)));
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
        C4990ab.m7417i(str5, str6, objArr2);
        if (linkedList2 != null && linkedList2.size() > 0) {
            if (z) {
                cbq.xaB = linkedList2;
                cbq.xaA = linkedList2.size();
            } else {
                cbq.wFp = linkedList2;
                cbq.xaC = linkedList2.size();
            }
        }
        C4990ab.m7410d("MicroMsg.NetSceneSnsPost", "setObjectSource ".concat(String.valueOf(i5)));
        cbq.xaW = i5;
        civ civ = new civ();
        if (!C5046bo.isNullOrNil(bav.token)) {
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
            C4990ab.m7410d("MicroMsg.NetSceneSnsPost", "tagid " + linkedList.size() + " " + cbq.wFk.toString());
        }
        cbq.wFq = cbp;
        if (!C5046bo.isNullOrNil(bav.wFs)) {
            cbq.xaE = new cbu();
        }
        if (cbp != null) {
            C4990ab.m7411d("MicroMsg.NetSceneSnsPost", "SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", cbp.vFJ, cbp.vFK, cbp.vFL);
        }
        if (c1332b != null) {
            cbq.xaY = new SKBuiltinBuffer_t().setBuffer(c1332b);
        }
        cbq.xbd = bav.wFw;
        C46236n DK = C13373af.cnF().mo62914DK(this.cNE);
        if (DK != null && ((DK.field_type == 1 || DK.field_type == 15) && timeLineObject.xfI != null && timeLineObject.xfI.wbK != null && timeLineObject.xfI.wbK.size() > 0 && bav.wFf != null && bav.wFf.size() == timeLineObject.xfI.wbK.size())) {
            str7 = C13373af.getAccSnsPath();
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
                        C43528a WR = C21846d.m33388WR(C3892an.m6198fZ(str7, bau.f17915Id) + C29036i.m46126p(bau));
                        if (WR != null) {
                            bas.wED = (int) Math.round(((double) WR.eWK) / 1000.0d);
                        }
                    }
                    C29098r kE = C13373af.cnu().mo25635kE((long) ((ayq) bav.wFf.get(i7)).wCt);
                    try {
                        bax bax = (bax) new bax().parseFrom(kE.rfI);
                        bas.vFH = bax.wFI;
                        this.qJt.put(Integer.valueOf(kE.reX), Integer.valueOf(bax.wFI));
                    } catch (Exception e2) {
                    }
                    C4990ab.m7417i("MicroMsg.NetSceneSnsPost", "post add mediaInfo, Source: %s, videoPlayLength: %s, MediaType: %s", Integer.valueOf(bas.vFH), Integer.valueOf(bas.wED), Integer.valueOf(bas.nda));
                    cbq.xbc.add(bas);
                }
                i6 = i7 + 1;
            }
            cbq.xbb = cbq.xbc.size();
            C4990ab.m7417i("MicroMsg.NetSceneSnsPost", "post mediaCount: %s", Integer.valueOf(cbq.xbb));
        }
        cbq.vIl = new SKBuiltinBuffer_t().setBuffer(C6998b.oTO.bVS());
        AppMethodBeat.m2505o(36289);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36290);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36290);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:97:0x03d1  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0483  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x03ef  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x03fc A:{Catch:{ Exception -> 0x04cf }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36291);
        C4990ab.m7416i("MicroMsg.NetSceneSnsPost", "post netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        cbr cbr = (cbr) ((C7472b) c1929q).fsH.fsP;
        C26235rr c26235rr;
        if (i2 == 4) {
            C46236n DK = C13373af.cnF().mo62914DK(this.cNE);
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
                C13373af.cnF().mo62928b(this.cNE, DK);
                C13373af.cnE().mo37394CT(this.cNE);
                C4990ab.m7410d("MicroMsg.NetSceneSnsPost", "onErrorServer, publish SnsPostFailEvent, snsInfoLocalId: " + DK.cqU());
                C18386rp c18386rp = new C18386rp();
                c18386rp.cNA.cNB = (long) this.cNE;
                C4879a.xxA.mo10055m(c18386rp);
            }
            if (!(this.qJm == null || this.qJm.xfI == null || this.qJm.xfI.wbJ != 21)) {
                C21904b.m33474kT(8);
                switch (i3) {
                    case -1:
                        C21904b.m33474kT(19);
                        break;
                    case 201:
                        C21904b.m33474kT(17);
                        break;
                    case 211:
                        C21904b.m33474kT(18);
                        break;
                    default:
                        C21904b.m33474kT(20);
                        break;
                }
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36291);
        } else if (i3 != 0) {
            C13373af.cnE().mo37394CT(this.cNE);
            if (!(this.qJm == null || this.qJm.xfI == null || this.qJm.xfI.wbJ != 21)) {
                C21904b.m33474kT(8);
                C21904b.m33474kT(16);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36291);
        } else if (cbr.wZu == null || cbr.wZu.xam == null || cbr.wZu.xam.getBuffer() == null) {
            C4990ab.m7412e("MicroMsg.NetSceneSnsPost", "err respone buffer is null ignore");
            C13373af.cnE().mo37394CT(this.cNE);
            C46236n DK2 = C13373af.cnF().mo62914DK(this.cNE);
            if (DK2 != null) {
                DK2.cqX();
                C13373af.cnF().mo62928b(this.cNE, DK2);
                c26235rr = new C26235rr();
                c26235rr.cNG.cNB = (long) this.cNE;
                C4879a.xxA.mo10055m(c26235rr);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36291);
        } else {
            String str2;
            String str3 = new String(cbr.wZu.xam.getBuffer().toByteArray());
            if (this.qJp == 0) {
                C4990ab.m7410d("MicroMsg.NetSceneSnsPost", "resp " + str3 + "  ");
            }
            this.qJn = C37953e.m64188tC(str3);
            if (this.qJn.xfN != null) {
                str2 = this.qJn.f15074Id;
                String str4 = this.qJn.xfN.fiN;
                String str5 = this.qJn.xfN.fiM;
                C32831d c32831d = new C32831d();
                c32831d.mo53400l("20CurrPublishId", str2 + ",");
                c32831d.mo53400l("20SourcePublishId", str4 + ",");
                c32831d.mo53400l("20SourceAdUxInfo", str5 + ",");
                C4990ab.m7416i("MicroMsg.SnsVideoStatistic", "report snsad_shareReport: " + c32831d.mo53398Fk());
                C7060h.pYm.mo8381e(13004, c32831d);
            }
            C46236n DK3 = C13373af.cnF().mo62914DK(this.cNE);
            if (DK3 == null) {
                C4990ab.m7412e("MicroMsg.NetSceneSnsPost", "the item has delete");
                DK3 = new C46236n();
            }
            DK3.mo74294ls(cbr.wZu.pcX);
            DK3.mo74255YR(str3);
            DK3.field_localFlag &= -17;
            DK3.mo74293kz(cbr.wZu.vQE);
            DK3.mo74292kB(cbr.wZu.vQE);
            if ((cbr.wZu.wGz & 1) > 0) {
                DK3.cqR();
            }
            this.qJo = cbr.wZu.vQE;
            if (this.qJq != null) {
                this.qJq.cSG.cSI = "sns_" + C29036i.m46117jV(this.qJo);
                C4879a.xxA.mo10055m(this.qJq);
            }
            if (!(this.qJr == null || this.qJr.cSV.cSW == -1)) {
                C4879a.xxA.mo10055m(this.qJr);
            }
            cbf cbf = cbr.wZu;
            cbf.xam.setBuffer(new byte[0]);
            try {
                C37952b co;
                String str6;
                long j;
                C18388rq c18388rq;
                if (cbf.xas == 0 && cbf.xap == 0 && cbf.xav == 0 && cbf.wHG == 0) {
                    C4990ab.m7410d("MicroMsg.NetSceneSnsPost", "no use! this buf");
                    DK3.cqX();
                    C13373af.cnF().mo62928b(this.cNE, DK3);
                    C13373af.cnE().mo37394CT(this.cNE);
                    new C7306ak(Looper.getMainLooper()).post(new C349621());
                    co = C24827g.qTp.mo37380co(Integer.valueOf(this.cNE));
                    co.ajH();
                    co.ajI();
                    co.mo60724tz(this.qJn.f15074Id);
                    co.mo60720mb(this.qJn.xfI.wbJ);
                    co.ajK();
                    co = C24828h.qTp.mo37380co(Integer.valueOf(this.cNE));
                    co.ajH();
                    co.ajI();
                    co.mo60724tz(this.qJn.f15074Id);
                    co.mo60720mb(this.qJn.xfI.wbJ);
                    co.ajK();
                    c26235rr = new C26235rr();
                    c26235rr.cNG.cNB = (long) this.cNE;
                    C4879a.xxA.mo10055m(c26235rr);
                    if (DK3.field_type == 21) {
                    }
                    C34959s.m57424a(this.qJm, this.qJn);
                    if (this.qJn != null) {
                    }
                    m57422XQ(str6);
                    if (C13373af.cnB() != null) {
                    }
                    if (DK3.field_type == 15) {
                    }
                    j = cbf.vQE;
                    c18388rq = new C18388rq();
                    c18388rq.cNC.cND = j;
                    c18388rq.cNC.cNE = this.cNE;
                    c18388rq.cNC.cNF = this.qJt;
                    C4879a.xxA.mo10055m(c18388rq);
                    this.ehi.onSceneEnd(i2, i3, str, this);
                    AppMethodBeat.m2505o(36291);
                }
                DK3.mo74256bi(cbf.toByteArray());
                DK3.cqX();
                C13373af.cnF().mo62928b(this.cNE, DK3);
                C13373af.cnE().mo37394CT(this.cNE);
                if (((this.qJm.xfI.wbJ == 1 && this.qJm.dtW == 0 && this.qJn.dtW == 1) || (this.qJm.xfI.wbJ == 15 && this.qJm.xfP == 0 && this.qJn.xfP == 1)) && C21991i.m33619kw(C35002v.m57483Zm(DK3.cqA()))) {
                    new C7306ak(Looper.getMainLooper()).post(new C349621());
                }
                co = C24827g.qTp.mo37380co(Integer.valueOf(this.cNE));
                if (!(co == null || this.qJn == null)) {
                    co.ajH();
                    co.ajI();
                    co.mo60724tz(this.qJn.f15074Id);
                    co.mo60720mb(this.qJn.xfI.wbJ);
                    co.ajK();
                }
                co = C24828h.qTp.mo37380co(Integer.valueOf(this.cNE));
                if (!(co == null || this.qJn == null)) {
                    co.ajH();
                    co.ajI();
                    co.mo60724tz(this.qJn.f15074Id);
                    co.mo60720mb(this.qJn.xfI.wbJ);
                    co.ajK();
                }
                c26235rr = new C26235rr();
                c26235rr.cNG.cNB = (long) this.cNE;
                C4879a.xxA.mo10055m(c26235rr);
                if (DK3.field_type == 21) {
                    C21904b.m33474kT(7);
                    System.currentTimeMillis();
                }
                C34959s.m57424a(this.qJm, this.qJn);
                if (this.qJn != null) {
                    str6 = "";
                } else {
                    str6 = this.qJn.xfF;
                }
                m57422XQ(str6);
                if (C13373af.cnB() != null) {
                    C13373af.cnB().cmp();
                }
                try {
                    if (DK3.field_type == 15) {
                        bau bau = (bau) this.qJn.xfI.wbK.get(0);
                        if (bau != null) {
                            str2 = C3892an.m6198fZ(C13373af.getAccSnsPath(), bau.f17915Id) + C29036i.m46116j(bau);
                            C45459n alj = C45459n.alj();
                            str6 = bau.Url;
                            long j2 = cbf.vQE;
                            if (!(C5046bo.isNullOrNil(str6) || C5046bo.isNullOrNil(str2))) {
                                String str7 = str6.hashCode();
                                C4990ab.m7411d("MicroMsg.SubCoreMediaRpt", "rpt sns video upload info snsKey[%s] url[%s] snsId[%d] path[%s]", str7, str6, Long.valueOf(j2), str2);
                                C42227a c42227a = (C42227a) alj.fWm.get(str7);
                                if (c42227a != null) {
                                    c42227a.fWB = String.valueOf(j2);
                                    c42227a.fWA = str2;
                                    alj.mo73266a(c42227a.fVQ, str7);
                                }
                            }
                        }
                    }
                } catch (Exception e2) {
                }
                j = cbf.vQE;
                c18388rq = new C18388rq();
                c18388rq.cNC.cND = j;
                c18388rq.cNC.cNE = this.cNE;
                c18388rq.cNC.cNF = this.qJt;
                C4879a.xxA.mo10055m(c18388rq);
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(36291);
            } catch (IOException e3) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsPost", e3, "", new Object[0]);
            }
        }
    }

    /* renamed from: XQ */
    private void m57422XQ(String str) {
        AppMethodBeat.m2504i(36292);
        this.qJx = str;
        C5141c ll = C18624c.abi().mo17131ll("100132");
        if (ll.isValid()) {
            this.eFs = C5046bo.getInt((String) ll.dru().get("needUploadData"), 1);
        }
        if (this.qJs == 12 || this.eFs != 0) {
            if (!(this.qJn == null || this.qJn.xfI == null || this.qJn.xfI.wbK == null || this.qJn.xfI.wbK.size() <= 0)) {
                LinkedList linkedList = this.qJn.xfI.wbK;
                C4879a.xxA.mo10052c(this.eFv);
                C4879a.xxA.mo10052c(this.eFw);
                Iterator it = linkedList.iterator();
                int i = 0;
                while (it.hasNext()) {
                    bau bau = (bau) it.next();
                    if (bau.jCt == 2) {
                        String C = C21925g.m33507C(bau);
                        if (!C5046bo.isNullOrNil(C)) {
                            this.qJw.put(C, Integer.valueOf(i));
                            this.qJv.put(C, bau);
                            int i2 = i + 1;
                            C45347np c45347np = new C45347np();
                            c45347np.cJU.filePath = C;
                            C4879a.xxA.mo10055m(c45347np);
                            i = i2;
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(36292);
            return;
        }
        AppMethodBeat.m2505o(36292);
    }

    /* renamed from: a */
    private static boolean m57424a(TimeLineObject timeLineObject, TimeLineObject timeLineObject2) {
        AppMethodBeat.m2504i(36293);
        if (timeLineObject == null || timeLineObject2 == null || timeLineObject.xfI == null || timeLineObject2.xfI == null) {
            AppMethodBeat.m2505o(36293);
            return false;
        }
        String accSnsPath = C13373af.getAccSnsPath();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= timeLineObject.xfI.wbK.size() || i2 >= timeLineObject2.xfI.wbK.size()) {
                AppMethodBeat.m2505o(36293);
            } else {
                bau bau = (bau) timeLineObject.xfI.wbK.get(i2);
                bau bau2 = (bau) timeLineObject2.xfI.wbK.get(i2);
                String m = C29036i.m46122m(bau);
                String n = C29036i.m46123n(bau);
                String o = C29036i.m46124o(bau);
                String p = C29036i.m46126p(bau);
                String l = C29036i.m46121l(bau2);
                String e = C29036i.m46108e(bau2);
                String f = C29036i.m46110f(bau2);
                String j = C29036i.m46116j(bau2);
                C4990ab.m7410d("MicroMsg.NetSceneSnsPost", "updateMediaFileName " + m + "  - " + l);
                String fZ = C3892an.m6198fZ(accSnsPath, bau.f17915Id);
                String fZ2 = C3892an.m6198fZ(accSnsPath, bau2.f17915Id);
                C5730e.m8643tf(fZ2);
                C5730e.m8623aQ(fZ + m, fZ2 + l);
                C5730e.m8623aQ(fZ + n, fZ2 + e);
                C5730e.m8623aQ(fZ + o, fZ2 + f);
                if (C5730e.m8628ct(fZ + p)) {
                    C4990ab.m7417i("MicroMsg.NetSceneSnsPost", "post done copy file %s", fZ2 + j);
                    C5730e.m8623aQ(fZ + p, fZ2 + j);
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(36293);
        return true;
    }

    public final int getType() {
        return 209;
    }

    /* renamed from: a */
    static /* synthetic */ void m57423a(C34959s c34959s) {
        AppMethodBeat.m2504i(36294);
        if (c34959s.qJw.isEmpty()) {
            C4879a.xxA.mo10053d(c34959s.eFv);
            C4879a.xxA.mo10053d(c34959s.eFw);
            if (!(c34959s.eFs == 0 || C5046bo.isNullOrNil(c34959s.qJu))) {
                String str = c34959s.qJn.xfH == null ? "" : c34959s.qJn.xfH.f17242Id;
                int size = c34959s.qJn.xfI.wbK.size();
                C4990ab.m7417i("MicroMsg.NetSceneSnsPost", "report qrCodeImgSns(13627), snsId:%s, size:%d, info:%s, appId:%s", c34959s.qJn.f15074Id, Integer.valueOf(size), c34959s.qJu, str);
                C18698o.m29233y(13627, String.format(Locale.US, "%s,%d,%s,%s", new Object[]{c34959s.qJn.f15074Id, Integer.valueOf(size), c34959s.qJu, str}));
            }
        }
        AppMethodBeat.m2505o(36294);
    }
}
