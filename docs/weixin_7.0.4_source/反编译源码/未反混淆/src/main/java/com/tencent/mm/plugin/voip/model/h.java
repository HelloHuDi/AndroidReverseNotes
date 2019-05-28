package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.p;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.storage.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.protocal.protobuf.bbf;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.protocal.protobuf.bwm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class h extends m implements k {
    private static final List<Object> fIl = new ArrayList();
    private static final Set<Long> sOD = new HashSet();
    private long cvx;
    private b ehh;
    private f ehi;
    private final List<bi> fIm = new LinkedList();

    static {
        AppMethodBeat.i(4365);
        AppMethodBeat.o(4365);
    }

    public h(String str, String str2, int i) {
        AppMethodBeat.i(4358);
        ab.d("MicroMsg.NetSceneSendMsg", "dktext :" + bo.dpG());
        if (!bo.isNullOrNil(str)) {
            bi biVar = new bi();
            biVar.setStatus(1);
            biVar.ju(str);
            biVar.eJ(bf.oC(str));
            biVar.hO(1);
            biVar.setContent(str2);
            biVar.setType(i);
            this.cvx = ((j) g.K(j.class)).bOr().Z(biVar);
            Assert.assertTrue(this.cvx != -1);
            ab.i("MicroMsg.NetSceneSendMsg", "new msg inserted to db , local id = " + this.cvx);
        }
        AppMethodBeat.o(4358);
    }

    public h() {
        AppMethodBeat.i(4359);
        ab.d("MicroMsg.NetSceneSendMsg", "dktext :" + bo.dpG());
        ab.i("MicroMsg.NetSceneSendMsg", "empty msg sender created");
        AppMethodBeat.o(4359);
    }

    public final int acn() {
        return 10;
    }

    public final m.b b(q qVar) {
        AppMethodBeat.i(4360);
        m.b bVar;
        if (this.fIm.size() > 0) {
            bVar = m.b.EOk;
            AppMethodBeat.o(4360);
            return bVar;
        }
        bVar = m.b.EFailed;
        AppMethodBeat.o(4360);
        return bVar;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(4361);
        this.ehi = fVar;
        a aVar = new a();
        aVar.fsJ = new bwl();
        aVar.fsK = new bwm();
        aVar.uri = "/cgi-bin/micromsg-bin/newsendmsg";
        aVar.fsI = c.CTRL_INDEX;
        aVar.fsL = d.MIC_PTU_LENGMEIREN;
        aVar.fsM = 1000000237;
        this.ehh = aVar.acD();
        bwl bwl = (bwl) this.ehh.fsG.fsP;
        List bOD = ((j) g.K(j.class)).bOr().bOD();
        if (bOD.size() == 0) {
            ab.i("MicroMsg.NetSceneSendMsg", "no sending message");
            AppMethodBeat.o(4361);
            return -2;
        }
        this.fIm.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= bOD.size()) {
                break;
            }
            bi biVar = (bi) bOD.get(i2);
            if (biVar.field_isSend == 1) {
                bbe bbe = new bbe();
                bbe.vEC = new bts().alV(biVar.field_talker);
                bbe.pcX = (int) (biVar.field_createTime / 1000);
                bbe.jCt = biVar.getType();
                bbe.ncM = biVar.field_content;
                bbe.wFW = p.m(r.Yz(), biVar.field_createTime).hashCode();
                bbe.vEG = bh.aaf();
                bwl.jBw.add(bbe);
                bwl.jBv = bwl.jBw.size();
                this.fIm.add(biVar);
            }
            i = i2 + 1;
        }
        int a = a(eVar, this.ehh, this);
        if (a < 0) {
            ahQ();
        }
        AppMethodBeat.o(4361);
        return a;
    }

    public final int getType() {
        return c.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(4362);
        if (i2 == 0 && i3 == 0) {
            int i4;
            LinkedList linkedList = ((bwm) this.ehh.fsH.fsP).jBw;
            if (this.fIm.size() == linkedList.size()) {
                i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= linkedList.size()) {
                        ab.i("MicroMsg.NetSceneSendMsg", "total " + i5 + " msgs sent successfully");
                        break;
                    }
                    bbf bbf = (bbf) linkedList.get(i5);
                    if (bbf.Ret != 0) {
                        ab.e("MicroMsg.NetSceneSendMsg", "send msg failed: item ret code=" + bbf.Ret);
                        lM(i5);
                        this.ehi.onSceneEnd(4, bbf.Ret, str, this);
                        AppMethodBeat.o(4362);
                        return;
                    }
                    long j = ((bi) this.fIm.get(i5)).field_msgId;
                    ab.i("MicroMsg.NetSceneSendMsg", "msg local id = " + j + ", SvrId = " + bbf.ptF + " sent successfully!");
                    bi jf = ((j) g.K(j.class)).bOr().jf(j);
                    jf.eI(bbf.ptF);
                    jf.setStatus(2);
                    ((j) g.K(j.class)).bOr().a(j, jf);
                    i4 = i5 + 1;
                }
            }
            i4 = a(this.ftf, this.ehi);
            if (i4 == -2) {
                this.ehi.onSceneEnd(0, 0, str, this);
                AppMethodBeat.o(4362);
                return;
            }
            if (i4 < 0) {
                this.ehi.onSceneEnd(3, -1, str, this);
            }
            AppMethodBeat.o(4362);
            return;
        }
        ahQ();
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(4362);
    }

    private void ahQ() {
        AppMethodBeat.i(4363);
        for (int i = 0; i < this.fIm.size(); i++) {
            lM(i);
        }
        AppMethodBeat.o(4363);
    }

    private void lM(int i) {
        AppMethodBeat.i(4364);
        bi biVar = (bi) this.fIm.get(i);
        biVar.setStatus(5);
        ((j) g.K(j.class)).bOr().a(biVar.field_msgId, biVar);
        Iterator it = fIl.iterator();
        while (it.hasNext()) {
            it.next();
        }
        AppMethodBeat.o(4364);
    }
}
