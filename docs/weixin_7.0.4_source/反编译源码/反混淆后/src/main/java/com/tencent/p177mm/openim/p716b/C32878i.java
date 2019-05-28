package com.tencent.p177mm.openim.p716b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.openim.PluginOpenIM;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.openim.p877e.C42246c;
import com.tencent.p177mm.openim.p877e.C42248e;
import com.tencent.p177mm.openim.p877e.C9775a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.protocal.protobuf.C30178dr;
import com.tencent.p177mm.protocal.protobuf.C46523as;
import com.tencent.p177mm.protocal.protobuf.alm;
import com.tencent.p177mm.protocal.protobuf.aln;
import com.tencent.p177mm.protocal.protobuf.bha;
import com.tencent.p177mm.protocal.protobuf.cvz;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.openim.b.i */
public final class C32878i extends C1207m implements C1918k {
    String aOt;
    public final C7472b ehh;
    private C1202f ehi;
    String gfc;
    private LinkedList<String> gfd = new LinkedList();

    public C32878i(String str, String str2, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(78858);
        if (C5046bo.isNullOrNil(str) || !str.equals("wework")) {
            C4990ab.m7421w("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource normal %s stack %s", str, C5046bo.dpG().toString());
        } else {
            C4990ab.m7413e("MicroMsg.Openim.NetSceneGetOpenIMResource", "NetSceneGetOpenIMResource error %s stack %s", str, C5046bo.dpG().toString());
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new alm();
        c1196a.fsK = new aln();
        c1196a.uri = "/cgi-bin/micromsg-bin/getopenimresource";
        c1196a.fsI = C38317l.CTRL_INDEX;
        this.ehh = c1196a.acD();
        this.gfc = str;
        this.aOt = str2;
        this.gfd.addAll(linkedList);
        int size = 10 - this.gfd.size();
        if (size > 0) {
            this.gfd.addAll(((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo34000B(size, str2));
        }
        alm alm = (alm) this.ehh.fsG.fsP;
        alm.app_id = str;
        alm.aOt = str2;
        alm.wqM = this.gfd;
        C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMResource", "init NetSceneGetOpenIMResource appid:%s, lang:%s, initWordingIDs:%s, wordidList:%s", str, str2, C32878i.m53814p(linkedList), C32878i.m53814p(this.gfd));
        AppMethodBeat.m2505o(78858);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78859);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78859);
        return a;
    }

    public final int getType() {
        return C38317l.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78860);
        C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, appid:%s, lang:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.gfc, this.aOt);
        if (i2 == 0 && i3 == 0) {
            aln aln = (aln) this.ehh.fsH.fsP;
            C46523as c46523as = aln.wqO;
            C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd acct_type_resource  url:%d, word:%d", Integer.valueOf(c46523as.ckO.size()), Integer.valueOf(c46523as.vCr.size()));
            C9775a c9775a = new C9775a();
            c9775a.field_acctTypeId = c46523as.vCq;
            c9775a.field_language = this.aOt;
            C1720g.m3537RQ();
            ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAccTypeInfoStg().mo10102b((C4925c) c9775a, "acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            c9775a.field_accTypeRec = c46523as;
            C1720g.m3537RQ();
            ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAccTypeInfoStg().mo73271a(c9775a);
            C30178dr c30178dr = aln.wqN;
            C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd appid_resource funcFlag:%d, url:%d, word:%d", Integer.valueOf(c30178dr.vFv), Integer.valueOf(c30178dr.ckO.size()), Integer.valueOf(c30178dr.vCr.size()));
            C42246c c42246c = new C42246c();
            c42246c.field_appid = this.gfc;
            c42246c.field_language = this.aOt;
            C1720g.m3537RQ();
            ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().mo10102b((C4925c) c42246c, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
            c42246c.field_appRec = c30178dr;
            c42246c.field_acctTypeId = c46523as.vCq;
            C1720g.m3537RQ();
            ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getAppIdInfoStg().mo67777a(c42246c);
            Iterator it = c30178dr.ckO.iterator();
            while (it.hasNext()) {
                bha bha = (bha) it.next();
                if ("openim_desc_icon".equals(bha.key)) {
                    ((C32873b) C1720g.m3528K(C32873b.class)).mo44310vh(bha.url);
                }
            }
            C4990ab.m7417i("MicroMsg.Openim.NetSceneGetOpenIMResource", "onGYNetEnd wording_id_resource   word:%d", Integer.valueOf(aln.wqP.size()));
            Iterator it2 = aln.wqP.iterator();
            while (it2.hasNext()) {
                cvz cvz = (cvz) it2.next();
                C42248e c42248e = new C42248e();
                c42248e.field_appid = this.gfc;
                c42248e.field_wordingId = cvz.xrS;
                c42248e.field_language = this.aOt;
                C1720g.m3537RQ();
                ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo10102b((C4925c) c42248e, "appid", "wordingId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
                c42248e.field_wording = cvz.cEh;
                c42248e.field_pinyin = cvz.puh;
                c42248e.field_quanpin = cvz.xrT;
                C1720g.m3537RQ();
                ((PluginOpenIM) C1720g.m3530M(PluginOpenIM.class)).getWordingInfoStg().mo34001a(c42248e);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(78860);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78860);
    }

    /* renamed from: p */
    private static String m53814p(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(78861);
        String str = "size:" + linkedList.size() + "[";
        Iterator it = linkedList.iterator();
        while (true) {
            String str2 = str;
            if (it.hasNext()) {
                str = str2 + ((String) it.next()) + ",";
            } else {
                str = str2 + "]";
                AppMethodBeat.m2505o(78861);
                return str;
            }
        }
    }
}
