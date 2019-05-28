package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.protocal.protobuf.iw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class f extends m implements k {
    private final b ehh;
    private com.tencent.mm.ai.f ehi = null;
    private int mga = 0;
    private int mge = 0;
    String pJt = "";
    j pJu = null;
    private SparseArray<aar> pJv = new SparseArray();
    private SparseBooleanArray pJw = new SparseBooleanArray();

    public f(j jVar) {
        AppMethodBeat.i(135662);
        a aVar = new a();
        aVar.fsJ = new iv();
        aVar.fsK = new iw();
        aVar.uri = "/cgi-bin/micromsg-bin/batchtranscdnitem";
        aVar.fsI = 632;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        this.pJu = jVar;
        AppMethodBeat.o(135662);
    }

    private void ceE() {
        AppMethodBeat.i(135663);
        this.pJt = com.tencent.mm.af.j.b.a(n.a(this.pJu.field_title, this.pJu.field_desc, this.pJu.field_dataProto), null, null);
        AppMethodBeat.o(135663);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(135664);
        ab.i("MicroMsg.NetSceneTransCDN", "netId %d errType %d errCode %d localErrCode %d begIndex %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mge), Integer.valueOf(this.mga), str);
        if (i2 == 3 && this.mge == -100) {
            ceE();
            this.ehi.onSceneEnd(0, 0, str, this);
            AppMethodBeat.o(135664);
        } else if (i2 == 0 && i3 == 0) {
            Object obj;
            Iterator it = ((iw) ((b) qVar).fsH.fsP).jBw.iterator();
            while (it.hasNext()) {
                cig cig = (cig) it.next();
                aar aar = (aar) this.pJv.get(cig.xhn);
                if (aar != null) {
                    if (this.pJw.get(cig.xhn)) {
                        ab.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[true], old thumb url[%s], new thumb url[%s], old size[%d], new size[%d]", Integer.valueOf(cig.xhn), aar.mnd, aar.fgE, cig.vRA, Long.valueOf(aar.wgF), Long.valueOf(cig.xhp));
                        aar.akJ(cig.vRA);
                        aar.akK(cig.AesKey);
                        if (bo.isNullOrNil(cig.vRA) || bo.isNullOrNil(cig.AesKey) || cig.xhp <= 0) {
                            ab.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            aar.mg(cig.xhp);
                        }
                    } else {
                        ab.i("MicroMsg.NetSceneTransCDN", "trans end, client id[%d], dataId[%s], isThumb[false], old url[%s], new url[%s], old size[%d], new size[%d]", Integer.valueOf(cig.xhn), aar.mnd, aar.wfZ, cig.vRA, Long.valueOf(aar.wgu), Long.valueOf(cig.xhp));
                        aar.akL(cig.vRA);
                        aar.akM(cig.AesKey);
                        if (bo.isNullOrNil(cig.vRA) || bo.isNullOrNil(cig.AesKey) || cig.xhp <= 0) {
                            ab.w("MicroMsg.NetSceneTransCDN", "match error server return");
                            i2 = 3;
                        } else {
                            aar.mf(cig.xhp);
                        }
                    }
                }
            }
            ab.i("MicroMsg.NetSceneTransCDN", "check need continue, indexOK %B", Boolean.valueOf(this.mga < this.pJu.field_dataProto.wiv.size()));
            if (this.mga < this.pJu.field_dataProto.wiv.size()) {
                obj = a(this.ftf, this.ehi) == -100 ? 1 : null;
            } else {
                int obj2 = 1;
            }
            if (obj2 != null) {
                ab.i("MicroMsg.NetSceneTransCDN", "do callback");
                ceE();
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.o(135664);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(135664);
        }
    }

    public final int getType() {
        return 632;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(135665);
        this.ehi = fVar;
        iv ivVar = (iv) this.ehh.fsG.fsP;
        this.pJv.clear();
        this.pJw.clear();
        if (this.pJu.field_dataProto.wiv.size() == 0) {
            ab.e("MicroMsg.NetSceneTransCDN", "doScene data list null");
            this.mge = -100;
            AppMethodBeat.o(135665);
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
            if (!aar.wgr || !bo.isNullOrNil(aar.wfZ)) {
                cig cig;
                if (!bo.isNullOrNil(aar.wfZ)) {
                    cig = new cig();
                    cig.vRA = aar.wfZ;
                    cig.AesKey = aar.wgb;
                    cig.xho = aar.dataType;
                    cig.xhp = (long) ((int) aar.wgu);
                    cig.xhn = bo.bc(aar.mnd, "").hashCode();
                    ab.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] dataID[%s] datatype[%d] dataurl[%s] size[%d]", Integer.valueOf(cig.xhn), aar.mnd, Integer.valueOf(cig.xho), aar.wfZ, Long.valueOf(aar.wgu));
                    linkedList.add(cig);
                    this.pJv.put(cig.xhn, aar);
                    this.pJw.put(cig.xhn, false);
                }
                if (!bo.isNullOrNil(aar.fgE)) {
                    cig = new cig();
                    cig.vRA = aar.fgE;
                    cig.AesKey = aar.wfV;
                    cig.xho = 2;
                    cig.xhp = (long) ((int) aar.wgF);
                    cig.xhn = (bo.bc(aar.mnd, "") + "@thumb").hashCode();
                    ab.d("MicroMsg.NetSceneTransCDN", "add cdnitem, clientID[%d] thumbID[%s_t] datatype[%d] thumburl[%s] size[%d]", Integer.valueOf(cig.xhn), aar.mnd, Integer.valueOf(cig.xho), aar.fgE, Long.valueOf(aar.wgF));
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
        ivVar.jBv = linkedList.size();
        ivVar.jBw.clear();
        ivVar.jBw.addAll(linkedList);
        ab.i("MicroMsg.NetSceneTransCDN", "ashutest::data list size %d, need check size %d, nextIndex %d", Integer.valueOf(this.pJu.field_dataProto.wiv.size()), Integer.valueOf(this.pJv.size()), Integer.valueOf(this.mga));
        if (ivVar.jBv <= 0 || obj == null) {
            ceE();
            ab.w("MicroMsg.NetSceneTransCDN", "doScene no more data");
            this.mge = -100;
            AppMethodBeat.o(135665);
            return -100;
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(135665);
        return a;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 10;
    }
}
