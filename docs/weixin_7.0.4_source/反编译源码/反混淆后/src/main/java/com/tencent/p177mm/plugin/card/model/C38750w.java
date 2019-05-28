package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.lab.JsApiSetLabInfo;
import com.tencent.p177mm.plugin.card.p352b.C27567b;
import com.tencent.p177mm.protocal.protobuf.C15370ok;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.C44149og;
import com.tencent.p177mm.protocal.protobuf.C44150oh;
import com.tencent.p177mm.protocal.protobuf.axu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.model.w */
public final class C38750w extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private byte[] fIi;
    private int kec = 0;

    public C38750w(int i) {
        AppMethodBeat.m2504i(87882);
        C4990ab.m7411d("MicroMsg.NetSceneCardSync", "<init>, selector = %d", Integer.valueOf(1));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44149og();
        c1196a.fsK = new C44150oh();
        c1196a.uri = "/cgi-bin/micromsg-bin/cardsync";
        c1196a.fsI = JsApiSetLabInfo.CTRL_INDEX;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        axu axu = new axu();
        axu.kfA = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_LAYOUT_BUF_DATA_STRING_SYNC, null);
        axu.latitude = (double) C42852am.bbc().ecs;
        axu.longitude = (double) C42852am.bbc().ect;
        C44149og c44149og = (C44149og) this.ehh.fsG.fsP;
        c44149og.vTN = 1;
        c44149og.vTP = axu;
        c44149og.vTQ = i;
        this.kec = i;
        AppMethodBeat.m2505o(87882);
    }

    public final int getType() {
        return JsApiSetLabInfo.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87883);
        this.ehi = c1202f;
        C44149og c44149og = (C44149og) this.ehh.fsG.fsP;
        this.fIi = C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(282880, null)));
        if (this.fIi == null || this.fIi.length == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneCardSync", "doScene, keyBuf is null, init card sync~~~");
        }
        c44149og.vTO = C1946aa.m4152ad(this.fIi);
        String str = "MicroMsg.NetSceneCardSync";
        String str2 = "doScene, keyBuf.length = %d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.fIi == null ? 0 : this.fIi.length);
        C4990ab.m7417i(str, str2, objArr);
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87883);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87884);
        C4990ab.m7411d("MicroMsg.NetSceneCardSync", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            C44150oh c44150oh = (C44150oh) this.ehh.fsH.fsP;
            if (c44150oh.vTS == 1) {
                C4990ab.m7416i("MicroMsg.NetSceneCardSync", "need do getCardsLayoutScene");
            }
            this.fIi = C1946aa.m4151a(c44150oh.vTO, new byte[0]);
            List<C40573tb> list = c44150oh.vTR == null ? null : c44150oh.vTR.jBw;
            String str2 = "MicroMsg.NetSceneCardSync";
            String str3 = "onGYNetEnd, cmd list size = %d, synckey length = %d, continueFlag = %d";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(list == null ? 0 : list.size());
            objArr[1] = Integer.valueOf(this.fIi == null ? 0 : this.fIi.length);
            objArr[2] = Integer.valueOf(c44150oh.vQe);
            C4990ab.m7417i(str2, str3, objArr);
            if (list == null || list.size() <= 0) {
                C4990ab.m7416i("MicroMsg.NetSceneCardSync", "cmdList == null or size is 0");
                C27567b baV = C42852am.baV();
                C4990ab.m7417i("MicroMsg.BatchGetCardMgr", "retryAll, getNow = %b", Boolean.TRUE);
                synchronized (baV.eMl) {
                    try {
                        baV.kaA.addAll(baV.kaB);
                        baV.kaB.clear();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(87884);
                        }
                    }
                }
                baV.bai();
            } else {
                int i4 = 0;
                for (C40573tb a : list) {
                    int i5;
                    if (C38750w.m65746a(a)) {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i4 = i5;
                }
                C4990ab.m7417i("MicroMsg.NetSceneCardSync", "onGYNetEnd, %d fail cmds", Integer.valueOf(i4));
                C42852am.baV().bai();
            }
            C1720g.m3536RP().mo5239Ry().set(282880, C5046bo.m7543cd(this.fIi));
            if (c44150oh.vQe > 0) {
                C4990ab.m7411d("MicroMsg.NetSceneCardSync", "onGYNetEnd, should continue, continueFlag = %d", Integer.valueOf(c44150oh.vQe));
                if (mo4456a(this.ftf, this.ehi) <= 0) {
                    C4990ab.m7413e("MicroMsg.NetSceneCardSync", "onGYNetEnd, doScene again fail, ret = %d", Integer.valueOf(mo4456a(this.ftf, this.ehi)));
                    this.ehi.onSceneEnd(3, -1, str, this);
                }
                AppMethodBeat.m2505o(87884);
                return;
            }
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.m2505o(87884);
            return;
        }
        C4990ab.m7413e("MicroMsg.NetSceneCardSync", "onGYNetEnd, card sync fail, errType = %d, errCode = %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87884);
    }

    /* renamed from: a */
    private static boolean m65746a(C40573tb c40573tb) {
        AppMethodBeat.m2504i(87885);
        if (c40573tb == null) {
            C4990ab.m7412e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null cmd");
            AppMethodBeat.m2505o(87885);
            return false;
        }
        byte[] a = C1946aa.m4150a(c40573tb.wau);
        if (a == null || a.length == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneCardSync", "processCmdItem fail, null buf");
            AppMethodBeat.m2505o(87885);
            return false;
        }
        C4990ab.m7411d("MicroMsg.NetSceneCardSync", "processCmdItem, buf length = %d, cmdId = %d", Integer.valueOf(a.length), Integer.valueOf(c40573tb.wat));
        try {
            switch (c40573tb.wat) {
                case 1:
                    C15370ok c15370ok = (C15370ok) new C15370ok().parseFrom(a);
                    C4990ab.m7417i("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, Status = %d", Integer.valueOf(c15370ok.jBT));
                    switch (c15370ok.jBT) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            C42852am.baV().mo45369a(c15370ok);
                            break;
                        case 6:
                            break;
                        default:
                            C4990ab.m7413e("MicroMsg.NetSceneCardSync", "processCmdIem, card user item, unknown StateFlag = %d", Integer.valueOf(c15370ok.vUM));
                            AppMethodBeat.m2505o(87885);
                            return false;
                    }
                    AppMethodBeat.m2505o(87885);
                    return true;
                default:
                    C4990ab.m7421w("MicroMsg.NetSceneCardSync", "processCmdItem, unknown cmdId = %d", Integer.valueOf(c40573tb.wat));
                    AppMethodBeat.m2505o(87885);
                    return false;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", e.getMessage());
            AppMethodBeat.m2505o(87885);
            return false;
        }
        C4990ab.m7413e("MicroMsg.NetSceneCardSync", "processCmdItem fail, ex = %s", e.getMessage());
        AppMethodBeat.m2505o(87885);
        return false;
    }
}
