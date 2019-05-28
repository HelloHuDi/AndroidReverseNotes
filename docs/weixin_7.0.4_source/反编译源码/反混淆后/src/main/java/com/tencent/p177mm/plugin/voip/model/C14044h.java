package com.tencent.p177mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1851p;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.bbe;
import com.tencent.p177mm.protocal.protobuf.bbf;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.bwl;
import com.tencent.p177mm.protocal.protobuf.bwm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.voip.model.h */
public final class C14044h extends C1207m implements C1918k {
    private static final List<Object> fIl = new ArrayList();
    private static final Set<Long> sOD = new HashSet();
    private long cvx;
    private C7472b ehh;
    private C1202f ehi;
    private final List<C7620bi> fIm = new LinkedList();

    static {
        AppMethodBeat.m2504i(4365);
        AppMethodBeat.m2505o(4365);
    }

    public C14044h(String str, String str2, int i) {
        AppMethodBeat.m2504i(4358);
        C4990ab.m7410d("MicroMsg.NetSceneSendMsg", "dktext :" + C5046bo.dpG());
        if (!C5046bo.isNullOrNil(str)) {
            C7620bi c7620bi = new C7620bi();
            c7620bi.setStatus(1);
            c7620bi.mo14794ju(str);
            c7620bi.mo14775eJ(C1829bf.m3756oC(str));
            c7620bi.mo14781hO(1);
            c7620bi.setContent(str2);
            c7620bi.setType(i);
            this.cvx = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15281Z(c7620bi);
            Assert.assertTrue(this.cvx != -1);
            C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cvx);
        }
        AppMethodBeat.m2505o(4358);
    }

    public C14044h() {
        AppMethodBeat.m2504i(4359);
        C4990ab.m7410d("MicroMsg.NetSceneSendMsg", "dktext :" + C5046bo.dpG());
        C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
        AppMethodBeat.m2505o(4359);
    }

    public final int acn() {
        return 10;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(4360);
        C1206b c1206b;
        if (this.fIm.size() > 0) {
            c1206b = C1206b.EOk;
            AppMethodBeat.m2505o(4360);
            return c1206b;
        }
        c1206b = C1206b.EFailed;
        AppMethodBeat.m2505o(4360);
        return c1206b;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(4361);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwl();
        c1196a.fsK = new bwm();
        c1196a.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        c1196a.fsI = C19482c.CTRL_INDEX;
        c1196a.fsL = C31128d.MIC_PTU_LENGMEIREN;
        c1196a.fsM = 1000000237;
        this.ehh = c1196a.acD();
        bwl bwl = (bwl) this.ehh.fsG.fsP;
        List bOD = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().bOD();
        if (bOD.size() == 0) {
            C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "no sending message");
            AppMethodBeat.m2505o(4361);
            return -2;
        }
        this.fIm.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bOD.size()) {
                break;
            }
            C7620bi c7620bi = (C7620bi) bOD.get(i2);
            if (c7620bi.field_isSend == 1) {
                bbe bbe = new bbe();
                bbe.vEC = new bts().alV(c7620bi.field_talker);
                bbe.pcX = (int) (c7620bi.field_createTime / 1000);
                bbe.jCt = c7620bi.getType();
                bbe.ncM = c7620bi.field_content;
                bbe.wFW = C1851p.m3818m(C1853r.m3846Yz(), c7620bi.field_createTime).hashCode();
                bbe.vEG = C1831bh.aaf();
                bwl.jBw.add(bbe);
                bwl.jBv = bwl.jBw.size();
                this.fIm.add(c7620bi);
            }
            i = i2 + 1;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        if (a < 0) {
            ahQ();
        }
        AppMethodBeat.m2505o(4361);
        return a;
    }

    public final int getType() {
        return C19482c.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(4362);
        if (i2 == 0 && i3 == 0) {
            int i4;
            LinkedList linkedList = ((bwm) this.ehh.fsH.fsP).jBw;
            if (this.fIm.size() == linkedList.size()) {
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= linkedList.size()) {
                        C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "total " + i5 + " msgs sent successfully");
                        break;
                    }
                    bbf bbf = (bbf) linkedList.get(i5);
                    if (bbf.Ret != 0) {
                        C4990ab.m7412e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + bbf.Ret);
                        m22174lM(i5);
                        this.ehi.onSceneEnd(4, bbf.Ret, str, this);
                        AppMethodBeat.m2505o(4362);
                        return;
                    }
                    long j = ((C7620bi) this.fIm.get(i5)).field_msgId;
                    C4990ab.m7416i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + bbf.ptF + " sent successfully!");
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(j);
                    jf.mo14774eI(bbf.ptF);
                    jf.setStatus(2);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(j, jf);
                    i4 = i5 + 1;
                }
            }
            i4 = mo4456a(this.ftf, this.ehi);
            if (i4 == -2) {
                this.ehi.onSceneEnd(0, 0, str, this);
                AppMethodBeat.m2505o(4362);
                return;
            }
            if (i4 < 0) {
                this.ehi.onSceneEnd(3, -1, str, this);
            }
            AppMethodBeat.m2505o(4362);
            return;
        }
        ahQ();
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(4362);
    }

    private void ahQ() {
        AppMethodBeat.m2504i(4363);
        for (int i = 0; i < this.fIm.size(); i++) {
            m22174lM(i);
        }
        AppMethodBeat.m2505o(4363);
    }

    /* renamed from: lM */
    private void m22174lM(int i) {
        AppMethodBeat.m2504i(4364);
        C7620bi c7620bi = (C7620bi) this.fIm.get(i);
        c7620bi.setStatus(5);
        ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(c7620bi.field_msgId, c7620bi);
        Iterator it = fIl.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.m2505o(4364);
    }
}
