package com.tencent.mm.plugin.fav.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.protocal.protobuf.vp;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ag extends m implements k {
    private final b ehh;
    private f ehi = null;
    private LinkedList<Integer> mfZ;
    private int mga = 0;

    public ag(LinkedList<Integer> linkedList) {
        AppMethodBeat.i(102719);
        a aVar = new a();
        aVar.fsJ = new ho();
        aVar.fsK = new hp();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
        aVar.fsI = 403;
        aVar.fsL = JsApiUploadEncryptedFileToCDN.CTRL_INDEX;
        aVar.fsM = 1000000194;
        this.ehh = aVar.acD();
        this.mfZ = linkedList;
        AppMethodBeat.o(102719);
    }

    private boolean bvc() {
        boolean z;
        AppMethodBeat.i(102720);
        if (this.mfZ == null || this.mga >= this.mfZ.size()) {
            z = false;
        } else {
            z = true;
        }
        ab.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", Boolean.valueOf(z));
        AppMethodBeat.o(102720);
        return z;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(102721);
        if (this.mfZ == null || this.mfZ.isEmpty() || this.mga >= this.mfZ.size()) {
            ab.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", Integer.valueOf(this.mga));
            AppMethodBeat.o(102721);
            return -1;
        }
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", Integer.valueOf(this.mfZ.size()), Integer.valueOf(this.mga), this.mfZ);
        ho hoVar = (ho) this.ehh.fsG.fsP;
        hoVar.vKh.clear();
        int i = 0;
        int i2 = this.mga;
        while (i2 < this.mfZ.size()) {
            int intValue = ((Integer) this.mfZ.get(i2)).intValue();
            if (intValue > 0) {
                hoVar.vKh.add(Integer.valueOf(intValue));
                intValue = i + 1;
            } else {
                intValue = i;
            }
            if (intValue >= 20) {
                break;
            }
            i2++;
            i = intValue;
        }
        this.mga = i2 + 1;
        hoVar.jBv = hoVar.vKh.size();
        ab.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", Integer.valueOf(hoVar.jBv), hoVar.vKh);
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(102721);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(102722);
        ab.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mga), Integer.valueOf(this.mfZ.size()), str);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((hp) ((b) qVar).fsH.fsP).jBw;
            if (linkedList == null || linkedList.size() == 0) {
                ab.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
                if (bvc()) {
                    a(this.ftf, this.ehi);
                    AppMethodBeat.o(102722);
                    return;
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(102722);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ab.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", Integer.valueOf(linkedList.size()));
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= linkedList.size()) {
                    break;
                }
                vp vpVar = (vp) linkedList.get(i5);
                if (vpVar.Ret < 0) {
                    ab.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", Integer.valueOf(vpVar.vEp));
                } else {
                    arrayList.add(Integer.valueOf(vpVar.vEp));
                    ab.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", Integer.valueOf(vpVar.vEp));
                }
                i4 = i5 + 1;
            }
            b.bI(arrayList);
            if (bvc()) {
                a(this.ftf, this.ehi);
                AppMethodBeat.o(102722);
                return;
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102722);
        } else if (bvc()) {
            a(this.ftf, this.ehi);
            AppMethodBeat.o(102722);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(102722);
        }
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final int acn() {
        return 10;
    }

    public final int getType() {
        return 403;
    }
}
