package com.tencent.p177mm.plugin.qmessage.p739a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C45368sw;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C44130ie;
import com.tencent.p177mm.protocal.protobuf.C46551if;
import com.tencent.p177mm.protocal.protobuf.C46589ud;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.qmessage.a.b */
public final class C7025b extends C1207m implements C1918k {
    private C1202f ehi;
    private Set<String> psI;

    public C7025b(Set<String> set) {
        AppMethodBeat.m2504i(24072);
        Assert.assertTrue(true);
        this.psI = set;
        AppMethodBeat.m2505o(24072);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24073);
        this.ehi = c1202f;
        LinkedList<String> linkedList = new LinkedList();
        for (String add : this.psI) {
            linkedList.add(add);
        }
        if (linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", C1447g.m3075Mq() + "doScene reqSize ==0");
            AppMethodBeat.m2505o(24073);
            return -1;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44130ie();
        c1196a.fsK = new C46551if();
        c1196a.uri = "/cgi-bin/micromsg-bin/batchgetcontactprofile";
        c1196a.fsI = 140;
        c1196a.fsL = 28;
        c1196a.fsM = 1000000028;
        C7472b acD = c1196a.acD();
        LinkedList linkedList2 = new LinkedList();
        for (String add2 : linkedList) {
            linkedList2.add(C1946aa.m4154vy(add2));
        }
        ((C44130ie) acD.fsG.fsP).vEg = linkedList2;
        ((C44130ie) acD.fsG.fsP).vKz = 1;
        ((C44130ie) acD.fsG.fsP).jBv = linkedList2.size();
        int a = mo4457a(c1902e, acD, this);
        AppMethodBeat.m2505o(24073);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int getType() {
        return 140;
    }

    public final int acn() {
        return 50;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24074);
        if (i2 == 0 && i3 == 0) {
            if (m11731h(c1929q) && this.psI.size() > 0) {
                mo4456a(this.ftf, this.ehi);
            }
            C4990ab.m7410d("MicroMsg.NetSceneBatchGetContactProfile", "left cnt = " + this.psI.size());
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(24074);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24074);
    }

    /* renamed from: h */
    private boolean m11731h(C1929q c1929q) {
        AppMethodBeat.m2504i(24075);
        C46551if c46551if = (C46551if) ((C7472b) c1929q).fsH.fsP;
        if (c46551if == null) {
            C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp: resp is null");
            AppMethodBeat.m2505o(24075);
            return false;
        } else if (c1929q.mo5618ZS().vyl == 1) {
            C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : endless loop, should stop");
            AppMethodBeat.m2505o(24075);
            return false;
        } else if (c1929q.mo5618ZS().vyl == -1) {
            C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "dealResp : server err, can try again");
            AppMethodBeat.m2505o(24075);
            return true;
        } else {
            LinkedList linkedList = c46551if.vKA;
            if (linkedList == null) {
                AppMethodBeat.m2505o(24075);
                return false;
            }
            int i = 0;
            while (i < linkedList.size()) {
                C46589ud c46589ud;
                boolean z;
                try {
                    c46589ud = (C46589ud) new C46589ud().parseFrom(C1946aa.m4150a((SKBuiltinBuffer_t) linkedList.get(i)));
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetSceneBatchGetContactProfile", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "ContactProfile.parseFrom fail");
                    c46589ud = null;
                }
                if (c46589ud == null || c46589ud.jBB == null) {
                    C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: profile name is null");
                    z = false;
                } else if (this.psI.contains(c46589ud.jBB)) {
                    this.psI.remove(c46589ud.jBB);
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(c46589ud.jBB);
                    if (aoO == null || ((int) aoO.ewQ) == 0) {
                        C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find this contact");
                        z = false;
                    } else {
                        aoO.setUsername(c46589ud.jBB);
                        aoO.mo14728iy(c46589ud.guS);
                        aoO.setType(c46589ud.wbu & c46589ud.wbv);
                        aoO.mo14703iB(c46589ud.jCH);
                        aoO.mo14704iC(c46589ud.wbs);
                        aoO.mo14705iD(c46589ud.wbt);
                        aoO.mo14685hA(c46589ud.guN);
                        aoO.mo14729iz(c46589ud.wbw);
                        aoO.mo14707iF(c46589ud.wbz);
                        aoO.mo14708iG(c46589ud.wby);
                        aoO.mo14688hD(c46589ud.wbA);
                        aoO.mo14702iA(c46589ud.wbD);
                        aoO.mo14689hE(c46589ud.wbE);
                        C9638aw.m17190ZK();
                        if (C18628c.m29078XM().mo15724b(aoO.field_username, aoO) == -1) {
                            C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update contact failed");
                        }
                        if (C7616ad.aow(c46589ud.jBB)) {
                            C12873d Vb = C46142g.cca().mo55344Vb(c46589ud.jBB);
                            if (Vb == null || C5046bo.nullAsNil(Vb.getUsername()).length() <= 0) {
                                C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: did not find qcontact");
                                z = false;
                            } else {
                                Vb.extInfo = c46589ud.ndT;
                                Vb.psL = (long) c46589ud.wbG;
                                Vb.psM = (long) c46589ud.wbH;
                                Vb.bJt = 52;
                                if (!C46142g.cca().mo55346a(c46589ud.jBB, Vb)) {
                                    C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile:update qcontact failed");
                                }
                            }
                        }
                        if (C7616ad.aou(c46589ud.jBB)) {
                            C45368sw c45368sw = new C45368sw();
                            c45368sw.cOY.opType = 0;
                            c45368sw.cOY.cIS = c46589ud.jBB;
                            c45368sw.cOY.cIT = c46589ud.wbG;
                            c45368sw.cOY.cIU = c46589ud.wbx;
                            C4879a.xxA.mo10055m(c45368sw);
                        }
                        z = true;
                    }
                } else {
                    C4990ab.m7412e("MicroMsg.NetSceneBatchGetContactProfile", "processContactProfile: resp data not in req");
                    z = false;
                }
                if (z) {
                    i++;
                } else {
                    AppMethodBeat.m2505o(24075);
                    return false;
                }
            }
            AppMethodBeat.m2505o(24075);
            return true;
        }
    }
}
