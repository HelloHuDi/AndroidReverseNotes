package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1851p;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C18433vt;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C40507ch;
import com.tencent.p177mm.protocal.protobuf.C44107ci;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.fav.a.af */
public final class C11849af extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;
    public C27966g mfY;

    public C11849af(C27966g c27966g) {
        AppMethodBeat.m2504i(102716);
        C4990ab.m7417i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", Long.valueOf(c27966g.field_localId));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40507ch();
        c1196a.fsK = new C44107ci();
        c1196a.uri = "/cgi-bin/micromsg-bin/addfavitem";
        c1196a.fsI = 401;
        c1196a.fsL = JsApiChooseMedia.CTRL_INDEX;
        c1196a.fsM = 1000000193;
        this.ehh = c1196a.acD();
        this.mfY = c27966g;
        AppMethodBeat.m2505o(102716);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102717);
        C40507ch c40507ch = (C40507ch) this.ehh.fsG.fsP;
        c40507ch.ptv = C1851p.m3818m(this.mfY.field_xml, System.currentTimeMillis());
        c40507ch.jCt = this.mfY.field_type;
        c40507ch.vEt = this.mfY.field_sourceType;
        this.mfY.field_xml = C27966g.m44521s(this.mfY);
        ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(this.mfY, "localId");
        c40507ch.vEv = this.mfY.field_xml;
        c40507ch.vEu = this.mfY.field_sourceId;
        this.mfY.mo45882LI("MicroMsg.Fav.NetSceneAddFav");
        this.ehi = c1202f;
        C4990ab.m7417i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", this.mfY.field_sourceId, Long.valueOf(this.mfY.field_localId), Integer.valueOf(this.mfY.field_id));
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102717);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102718);
        C4990ab.m7416i("MicroMsg.Fav.NetSceneAddFav", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if ((i2 == 0 && i3 == 0) || i3 == -400) {
            C44107ci c44107ci = (C44107ci) ((C7472b) c1929q).fsH.fsP;
            C4990ab.m7417i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", Integer.valueOf(c44107ci.vEp), Long.valueOf(this.mfY.field_localId), Integer.valueOf(this.mfY.field_itemStatus), Integer.valueOf(c44107ci.vEs));
            this.mfY.field_id = c44107ci.vEp;
            this.mfY.field_localSeq = c44107ci.vEs;
            if (this.mfY.field_itemStatus == 12) {
                C4990ab.m7418v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
                this.mfY.field_itemStatus = 13;
            }
            if (this.mfY.field_itemStatus == 9) {
                C4990ab.m7418v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
                this.mfY.field_itemStatus = 10;
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavCdnStorage().mo15167iB(this.mfY.field_localId);
                C7060h.pYm.mo8381e(10659, Integer.valueOf(0), Integer.valueOf(this.mfY.field_type), Integer.valueOf(0), Long.valueOf(C39037b.m66369b(this.mfY)), Long.valueOf(C27968h.m44529ix(this.mfY.field_localId)));
            }
            C27966g iF = ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23694iF((long) c44107ci.vEp);
            if (iF != null) {
                this.mfY.field_updateSeq = iF.field_updateSeq;
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23701z(iF);
                C4990ab.m7417i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", Integer.valueOf(iF.field_id));
            }
            C32800b nV = C37922v.m64076Zp().mo60674nV(this.mfY.field_sessionId);
            if (!(C5046bo.isNullOrNil(this.mfY.field_sessionId) || this.mfY.field_type != 5 || nV == null)) {
                C18433vt c18433vt = new C18433vt();
                c18433vt.cSG.cSH = nV.getString("prePublishId", "");
                if (!(this.mfY.field_favProto == null || this.mfY.field_favProto.wit == null)) {
                    c18433vt.cSG.url = this.mfY.field_favProto.wit.link;
                }
                if (!(!C5046bo.isNullOrNil(c18433vt.cSG.url) || this.mfY.field_favProto == null || this.mfY.field_favProto.whA == null || this.mfY.field_favProto.whA.wiY == null)) {
                    c18433vt.cSG.url = this.mfY.field_favProto.whA.wiY;
                }
                if (C5046bo.isNullOrNil(c18433vt.cSG.url)) {
                    c18433vt.cSG.url = nV.getString("url", "");
                }
                c18433vt.cSG.cSJ = nV.getString("preUsername", "");
                c18433vt.cSG.cSK = nV.getString("preChatName", "");
                c18433vt.cSG.cSL = nV.getInt("preMsgIndex", 0);
                c18433vt.cSG.cSP = nV.getInt("sendAppMsgScene", 0);
                c18433vt.cSG.cSQ = nV.getInt("getA8KeyScene", 0);
                c18433vt.cSG.cSR = nV.getString("referUrl", null);
                c18433vt.cSG.cSS = nV.getString("adExtStr", null);
                c18433vt.cSG.cSM = "";
                c18433vt.cSG.cSN = "";
                c18433vt.cSG.cSO = 0;
                c18433vt.cSG.cSI = "fav_" + C1853r.m3846Yz() + "_" + this.mfY.field_id;
                C4879a.xxA.mo10055m(c18433vt);
            }
            this.mfY.field_sessionId = null;
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23678a(this.mfY, "localId");
            C39037b.m66399in(c44107ci.vEw);
        }
        if (i2 == 4 && i3 == -401) {
            C4990ab.m7416i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
            if (this.mfY.buz()) {
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(16, this.mfY.field_localId);
            } else {
                ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().mo23674J(6, this.mfY.field_localId);
            }
        }
        C39037b.m66383d(this.mfY);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(102718);
    }

    public final int getType() {
        return 401;
    }
}
