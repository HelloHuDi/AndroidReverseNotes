package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN;
import com.tencent.p177mm.protocal.protobuf.C23397ho;
import com.tencent.p177mm.protocal.protobuf.C44125hp;
import com.tencent.p177mm.protocal.protobuf.C46594vp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.fav.a.ag */
public final class C34124ag extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;
    private LinkedList<Integer> mfZ;
    private int mga = 0;

    public C34124ag(LinkedList<Integer> linkedList) {
        AppMethodBeat.m2504i(102719);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23397ho();
        c1196a.fsK = new C44125hp();
        c1196a.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
        c1196a.fsI = 403;
        c1196a.fsL = JsApiUploadEncryptedFileToCDN.CTRL_INDEX;
        c1196a.fsM = 1000000194;
        this.ehh = c1196a.acD();
        this.mfZ = linkedList;
        AppMethodBeat.m2505o(102719);
    }

    private boolean bvc() {
        boolean z;
        AppMethodBeat.m2504i(102720);
        if (this.mfZ == null || this.mga >= this.mfZ.size()) {
            z = false;
        } else {
            z = true;
        }
        C4990ab.m7417i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", Boolean.valueOf(z));
        AppMethodBeat.m2505o(102720);
        return z;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102721);
        if (this.mfZ == null || this.mfZ.isEmpty() || this.mga >= this.mfZ.size()) {
            C4990ab.m7413e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", Integer.valueOf(this.mga));
            AppMethodBeat.m2505o(102721);
            return -1;
        }
        this.ehi = c1202f;
        C4990ab.m7417i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", Integer.valueOf(this.mfZ.size()), Integer.valueOf(this.mga), this.mfZ);
        C23397ho c23397ho = (C23397ho) this.ehh.fsG.fsP;
        c23397ho.vKh.clear();
        int i = 0;
        int i2 = this.mga;
        while (i2 < this.mfZ.size()) {
            int intValue = ((Integer) this.mfZ.get(i2)).intValue();
            if (intValue > 0) {
                c23397ho.vKh.add(Integer.valueOf(intValue));
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
        c23397ho.jBv = c23397ho.vKh.size();
        C4990ab.m7417i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", Integer.valueOf(c23397ho.jBv), c23397ho.vKh);
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102721);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102722);
        C4990ab.m7417i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.mga), Integer.valueOf(this.mfZ.size()), str);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((C44125hp) ((C7472b) c1929q).fsH.fsP).jBw;
            if (linkedList == null || linkedList.size() == 0) {
                C4990ab.m7412e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
                if (bvc()) {
                    mo4456a(this.ftf, this.ehi);
                    AppMethodBeat.m2505o(102722);
                    return;
                }
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(102722);
                return;
            }
            ArrayList arrayList = new ArrayList();
            C4990ab.m7417i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", Integer.valueOf(linkedList.size()));
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= linkedList.size()) {
                    break;
                }
                C46594vp c46594vp = (C46594vp) linkedList.get(i5);
                if (c46594vp.Ret < 0) {
                    C4990ab.m7421w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", Integer.valueOf(c46594vp.vEp));
                } else {
                    arrayList.add(Integer.valueOf(c46594vp.vEp));
                    C4990ab.m7417i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", Integer.valueOf(c46594vp.vEp));
                }
                i4 = i5 + 1;
            }
            C39037b.m66376bI(arrayList);
            if (bvc()) {
                mo4456a(this.ftf, this.ehi);
                AppMethodBeat.m2505o(102722);
                return;
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102722);
        } else if (bvc()) {
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(102722);
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(102722);
        }
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 10;
    }

    public final int getType() {
        return 403;
    }
}
