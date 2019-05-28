package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.plugin.appbrand.jsapi.k.l;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.alm;
import com.tencent.mm.protocal.protobuf.aln;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.protocal.protobuf.bha;
import com.tencent.mm.protocal.protobuf.cvz;
import com.tencent.mm.protocal.protobuf.dr;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class i extends m implements k {
    String aOt;
    public final b ehh;
    private f ehi;
    String gfc;
    private LinkedList<String> gfd = new LinkedList();

    public i(String str, String str2, LinkedList<String> linkedList) {
        AppMethodBeat.i(78858);
        if (bo.isNullOrNil(str) || !str.equals("wework")) {
            ab.w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", str, bo.dpG().toString());
        } else {
            ab.e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", str, bo.dpG().toString());
        }
        a aVar = new a();
        aVar.fsJ = new alm();
        aVar.fsK = new aln();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimresource";
        aVar.fsI = l.CTRL_INDEX;
        this.ehh = aVar.acD();
        this.gfc = str;
        this.aOt = str2;
        this.gfd.addAll(linkedList);
        int size = 10 - this.gfd.size();
        if (size > 0) {
            this.gfd.addAll(((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().B(size, str2));
        }
        alm alm = (alm) this.ehh.fsG.fsP;
        alm.app_id = str;
        alm.aOt = str2;
        alm.wqM = this.gfd;
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", str, str2, p(linkedList), p(this.gfd));
        AppMethodBeat.o(78858);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78859);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78859);
        return a;
    }

    public final int getType() {
        return l.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78860);
        ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.gfc, this.aOt);
        if (i2 == 0 && i3 == 0) {
            aln aln = (aln) this.ehh.fsH.fsP;
            as asVar = aln.wqO;
            ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", Integer.valueOf(asVar.ckO.size()), Integer.valueOf(asVar.vCr.size()));
            com.tencent.mm.openim.e.a aVar = new com.tencent.mm.openim.e.a();
            aVar.field_acctTypeId = asVar.vCq;
            aVar.field_language = this.aOt;
            g.RQ();
            ((PluginOpenIM) g.M(PluginOpenIM.class)).getAccTypeInfoStg().b((c) aVar, "acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            aVar.field_accTypeRec = asVar;
            g.RQ();
            ((PluginOpenIM) g.M(PluginOpenIM.class)).getAccTypeInfoStg().a(aVar);
            dr drVar = aln.wqN;
            ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", Integer.valueOf(drVar.vFv), Integer.valueOf(drVar.ckO.size()), Integer.valueOf(drVar.vCr.size()));
            com.tencent.mm.openim.e.c cVar = new com.tencent.mm.openim.e.c();
            cVar.field_appid = this.gfc;
            cVar.field_language = this.aOt;
            g.RQ();
            ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().b((c) cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            cVar.field_appRec = drVar;
            cVar.field_acctTypeId = asVar.vCq;
            g.RQ();
            ((PluginOpenIM) g.M(PluginOpenIM.class)).getAppIdInfoStg().a(cVar);
            Iterator it = drVar.ckO.iterator();
            while (it.hasNext()) {
                bha bha = (bha) it.next();
                if ("openim_desc_icon".equals(bha.key)) {
                    ((com.tencent.mm.openim.a.b) g.K(com.tencent.mm.openim.a.b.class)).vh(bha.url);
                }
            }
            ab.i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", Integer.valueOf(aln.wqP.size()));
            Iterator it2 = aln.wqP.iterator();
            while (it2.hasNext()) {
                cvz cvz = (cvz) it2.next();
                com.tencent.mm.openim.e.e eVar = new com.tencent.mm.openim.e.e();
                eVar.field_appid = this.gfc;
                eVar.field_wordingId = cvz.xrS;
                eVar.field_language = this.aOt;
                g.RQ();
                ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().b((c) eVar, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                eVar.field_wording = cvz.cEh;
                eVar.field_pinyin = cvz.puh;
                eVar.field_quanpin = cvz.xrT;
                g.RQ();
                ((PluginOpenIM) g.M(PluginOpenIM.class)).getWordingInfoStg().a(eVar);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(78860);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78860);
    }

    private static String p(LinkedList<String> linkedList) {
        AppMethodBeat.i(78861);
        String str = "size:" + linkedList.size() + "[";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + ((String) it.next()) + ",";
            } else {
                str = str2 + "]";
                AppMethodBeat.o(78861);
                return str;
            }
        }
    }
}
