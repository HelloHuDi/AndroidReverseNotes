package com.tencent.p177mm.plugin.record.p492b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.record.p1016a.C16844j;
import com.tencent.p177mm.protocal.protobuf.C40531iw;
import com.tencent.p177mm.protocal.protobuf.C46554iv;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.cig;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.record.b.f */
public final class C21600f extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;
    private int mga = 0;
    private int mge = 0;
    String pJt = "";
    C16844j pJu = null;
    private SparseArray<aar> pJv = new SparseArray();
    private SparseBooleanArray pJw = new SparseBooleanArray();

    public C21600f(C16844j c16844j) {
        AppMethodBeat.m2504i(135662);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46554iv();
        c1196a.fsK = new C40531iw();
        c1196a.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
        c1196a.fsI = 632;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.pJu = c16844j;
        AppMethodBeat.m2505o(135662);
    }

    private void ceE() {
        AppMethodBeat.m2504i(135663);
        this.pJt = C8910b.m16061a(C43436n.m77551a(this.pJu.field_title, this.pJu.field_desc, this.pJu.field_dataProto), null, null);
        AppMethodBeat.m2505o(135663);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(135664);
        C4990ab.m7417i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mge), Integer.valueOf(this.mga), str);
        if (i2 == 3 && this.mge == -100) {
            ceE();
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.m2505o(135664);
        } else if (i2 == 0 && i3 == 0) {
            Object obj;
            Iterator it = ((C40531iw) ((C7472b) c1929q).fsH.fsP).jBw.iterator();
            while (it.hasNext()) {
                cig cig = (cig) it.next();
                aar aar = (aar) this.pJv.get(cig.xhn);
                if (aar != null) {
                    if (this.pJw.get(cig.xhn)) {
                        C4990ab.m7417i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", Integer.valueOf(cig.xhn), aar.mnd, aar.fgE, cig.vRA, Long.valueOf(aar.wgF), Long.valueOf(cig.xhp));
                        aar.akJ(cig.vRA);
                        aar.akK(cig.AesKey);
                        if (C5046bo.isNullOrNil(cig.vRA) || C5046bo.isNullOrNil(cig.AesKey) || cig.xhp <= 0) {
                            C4990ab.m7420w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            aar.mo27432mg(cig.xhp);
                        }
                    } else {
                        C4990ab.m7417i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", Integer.valueOf(cig.xhn), aar.mnd, aar.wfZ, cig.vRA, Long.valueOf(aar.wgu), Long.valueOf(cig.xhp));
                        aar.akL(cig.vRA);
                        aar.akM(cig.AesKey);
                        if (C5046bo.isNullOrNil(cig.vRA) || C5046bo.isNullOrNil(cig.AesKey) || cig.xhp <= 0) {
                            C4990ab.m7420w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            aar.mo27431mf(cig.xhp);
                        }
                    }
                }
            }
            C4990ab.m7417i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", Boolean.valueOf(this.mga < this.pJu.field_dataProto.wiv.size()));
            if (this.mga < this.pJu.field_dataProto.wiv.size()) {
                obj = mo4456a(this.ftf, this.ehi) == -100 ? 1 : null;
            } else {
                int obj2 = 1;
            }
            if (obj2 != null) {
                C4990ab.m7416i("MicroMsg.NetSceneTransCDN", "do callback");
                ceE();
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.m2505o(135664);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(135664);
        }
    }

    public final int getType() {
        return 632;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(135665);
        this.ehi = c1202f;
        C46554iv c46554iv = (C46554iv) this.ehh.fsG.fsP;
        this.pJv.clear();
        this.pJw.clear();
        if (this.pJu.field_dataProto.wiv.size() == 0) {
            C4990ab.m7412e("MicroMsg.NetSceneTransCDN", "doScene data list null");
            this.mge = -100;
            AppMethodBeat.m2505o(135665);
            return -100;
        }
        int i;
        LinkedList linkedList = new LinkedList();
        int i2 = this.mga;
        while (true) {
            i = i2;
            if (i >= this.pJu.field_dataProto.wiv.size()) {
                break;
            }
            aar aar = (aar) this.pJu.field_dataProto.wiv.get(i);
            if (!aar.wgr || !C5046bo.isNullOrNil(aar.wfZ)) {
                cig cig;
                if (!C5046bo.isNullOrNil(aar.wfZ)) {
                    cig = new cig();
                    cig.vRA = aar.wfZ;
                    cig.AesKey = aar.wgb;
                    cig.xho = aar.dataType;
                    cig.xhp = (long) ((int) aar.wgu);
                    cig.xhn = C5046bo.m7532bc(aar.mnd, "").hashCode();
                    C4990ab.m7411d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", Integer.valueOf(cig.xhn), aar.mnd, Integer.valueOf(cig.xho), aar.wfZ, Long.valueOf(aar.wgu));
                    linkedList.add(cig);
                    this.pJv.put(cig.xhn, aar);
                    this.pJw.put(cig.xhn, false);
                }
                if (!C5046bo.isNullOrNil(aar.fgE)) {
                    cig = new cig();
                    cig.vRA = aar.fgE;
                    cig.AesKey = aar.wfV;
                    cig.xho = 2;
                    cig.xhp = (long) ((int) aar.wgF);
                    cig.xhn = (C5046bo.m7532bc(aar.mnd, "") + "@thumb").hashCode();
                    C4990ab.m7411d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", Integer.valueOf(cig.xhn), aar.mnd, Integer.valueOf(cig.xho), aar.fgE, Long.valueOf(aar.wgF));
                    linkedList.add(cig);
                    this.pJv.put(cig.xhn, aar);
                    this.pJw.put(cig.xhn, true);
                }
                if (linkedList.size() >= 20) {
                    break;
                }
                i2 = i + 1;
            } else {
                Object obj = null;
                break;
            }
        }
        i2 = 1;
        this.mga = i + 1;
        c46554iv.jBv = linkedList.size();
        c46554iv.jBw.clear();
        c46554iv.jBw.addAll(linkedList);
        C4990ab.m7417i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", Integer.valueOf(this.pJu.field_dataProto.wiv.size()), Integer.valueOf(this.pJv.size()), Integer.valueOf(this.mga));
        if (c46554iv.jBv <= 0 || obj == null) {
            ceE();
            C4990ab.m7420w("MicroMsg.NetSceneTransCDN", "doScene no more data");
            this.mge = -100;
            AppMethodBeat.m2505o(135665);
            return -100;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(135665);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 10;
    }
}
