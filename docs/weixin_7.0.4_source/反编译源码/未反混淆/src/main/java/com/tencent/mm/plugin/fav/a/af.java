package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.p;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ch;
import com.tencent.mm.protocal.protobuf.ci;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class af extends m implements k {
    private final b ehh;
    private f ehi = null;
    public g mfY;

    public af(g gVar) {
        AppMethodBeat.i(102716);
        ab.i("MicroMsg.Fav.NetSceneAddFav", "NetSceneAddFavItem %s", Long.valueOf(gVar.field_localId));
        a aVar = new a();
        aVar.fsJ = new ch();
        aVar.fsK = new ci();
        aVar.uri = "/cgi-bin/micromsg-bin/addfavitem";
        aVar.fsI = 401;
        aVar.fsL = JsApiChooseMedia.CTRL_INDEX;
        aVar.fsM = 1000000193;
        this.ehh = aVar.acD();
        this.mfY = gVar;
        AppMethodBeat.o(102716);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102717);
        ch chVar = (ch) this.ehh.fsG.fsP;
        chVar.ptv = p.m(this.mfY.field_xml, System.currentTimeMillis());
        chVar.jCt = this.mfY.field_type;
        chVar.vEt = this.mfY.field_sourceType;
        this.mfY.field_xml = g.s(this.mfY);
        ((ae) g.M(ae.class)).getFavItemInfoStorage().a(this.mfY, "localId");
        chVar.vEv = this.mfY.field_xml;
        chVar.vEu = this.mfY.field_sourceId;
        this.mfY.LI("MicroMsg.Fav.NetSceneAddFav");
        this.ehi = fVar;
        ab.i("MicroMsg.Fav.NetSceneAddFav", "ADD FavItem, sourceId:%s localId:%d favId:%d", this.mfY.field_sourceId, Long.valueOf(this.mfY.field_localId), Integer.valueOf(this.mfY.field_id));
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102717);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102718);
        ab.i("MicroMsg.Fav.NetSceneAddFav", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if ((i2 == 0 && i3 == 0) || i3 == -400) {
            ci ciVar = (ci) ((b) qVar).fsH.fsP;
            ab.i("MicroMsg.Fav.NetSceneAddFav", "fav id %d, local id %d, itemStatus %d, update seq %d", Integer.valueOf(ciVar.vEp), Long.valueOf(this.mfY.field_localId), Integer.valueOf(this.mfY.field_itemStatus), Integer.valueOf(ciVar.vEs));
            this.mfY.field_id = ciVar.vEp;
            this.mfY.field_localSeq = ciVar.vEs;
            if (this.mfY.field_itemStatus == 12) {
                ab.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd wait server upload sent");
                this.mfY.field_itemStatus = 13;
            }
            if (this.mfY.field_itemStatus == 9) {
                ab.v("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd item done");
                this.mfY.field_itemStatus = 10;
                ((ae) g.M(ae.class)).getFavCdnStorage().iB(this.mfY.field_localId);
                h.pYm.e(10659, Integer.valueOf(0), Integer.valueOf(this.mfY.field_type), Integer.valueOf(0), Long.valueOf(b.b(this.mfY)), Long.valueOf(h.ix(this.mfY.field_localId)));
            }
            g iF = ((ae) g.M(ae.class)).getFavItemInfoStorage().iF((long) ciVar.vEp);
            if (iF != null) {
                this.mfY.field_updateSeq = iF.field_updateSeq;
                ((ae) g.M(ae.class)).getFavItemInfoStorage().z(iF);
                ab.i("MicroMsg.Fav.NetSceneAddFav", "onGYNetEnd aleady exist, delete old info, favId:%d", Integer.valueOf(iF.field_id));
            }
            v.b nV = v.Zp().nV(this.mfY.field_sessionId);
            if (!(bo.isNullOrNil(this.mfY.field_sessionId) || this.mfY.field_type != 5 || nV == null)) {
                vt vtVar = new vt();
                vtVar.cSG.cSH = nV.getString("prePublishId", "");
                if (!(this.mfY.field_favProto == null || this.mfY.field_favProto.wit == null)) {
                    vtVar.cSG.url = this.mfY.field_favProto.wit.link;
                }
                if (!(!bo.isNullOrNil(vtVar.cSG.url) || this.mfY.field_favProto == null || this.mfY.field_favProto.whA == null || this.mfY.field_favProto.whA.wiY == null)) {
                    vtVar.cSG.url = this.mfY.field_favProto.whA.wiY;
                }
                if (bo.isNullOrNil(vtVar.cSG.url)) {
                    vtVar.cSG.url = nV.getString("url", "");
                }
                vtVar.cSG.cSJ = nV.getString("preUsername", "");
                vtVar.cSG.cSK = nV.getString("preChatName", "");
                vtVar.cSG.cSL = nV.getInt("preMsgIndex", 0);
                vtVar.cSG.cSP = nV.getInt("sendAppMsgScene", 0);
                vtVar.cSG.cSQ = nV.getInt("getA8KeyScene", 0);
                vtVar.cSG.cSR = nV.getString("referUrl", null);
                vtVar.cSG.cSS = nV.getString("adExtStr", null);
                vtVar.cSG.cSM = "";
                vtVar.cSG.cSN = "";
                vtVar.cSG.cSO = 0;
                vtVar.cSG.cSI = "fav_" + r.Yz() + "_" + this.mfY.field_id;
                com.tencent.mm.sdk.b.a.xxA.m(vtVar);
            }
            this.mfY.field_sessionId = null;
            ((ae) g.M(ae.class)).getFavItemInfoStorage().a(this.mfY, "localId");
            b.in(ciVar.vEw);
        }
        if (i2 == 4 && i3 == -401) {
            ab.i("MicroMsg.Fav.NetSceneAddFav", "fav fail, full size");
            if (this.mfY.buz()) {
                ((ae) g.M(ae.class)).getFavItemInfoStorage().J(16, this.mfY.field_localId);
            } else {
                ((ae) g.M(ae.class)).getFavItemInfoStorage().J(6, this.mfY.field_localId);
            }
        }
        b.d(this.mfY);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(102718);
    }

    public final int getType() {
        return 401;
    }
}
