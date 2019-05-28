package com.tencent.p177mm.plugin.fav.p407a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.bzg;
import com.tencent.p177mm.protocal.protobuf.bzh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.a.am */
public final class C27962am extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;
    private List<Integer> mgv;
    private C3068a mgw = null;
    private SparseArray<String> mgx = new SparseArray();
    private int scene;
    private String toUser;

    /* renamed from: com.tencent.mm.plugin.fav.a.am$a */
    public interface C3068a {
        /* renamed from: d */
        void mo7313d(SparseArray<String> sparseArray);
    }

    public C27962am(String str, List<Integer> list, C3068a c3068a) {
        AppMethodBeat.m2504i(102746);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bzg();
        c1196a.fsK = new bzh();
        c1196a.uri = "/cgi-bin/micromsg-bin/sharefav";
        c1196a.fsI = 608;
        c1196a.fsL = C31128d.MIC_PTU_ZIPAI_FAIRYTALE;
        c1196a.fsM = 1000000246;
        this.ehh = c1196a.acD();
        this.toUser = str;
        this.scene = 2;
        this.mgv = list;
        this.mgw = c3068a;
        AppMethodBeat.m2505o(102746);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(102747);
        C4990ab.m7410d("MicroMsg.NetSceneShareFavItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.mgx.clear();
        if (i2 == 0 && i3 == 0) {
            bzh bzh = (bzh) ((C7472b) c1929q).fsH.fsP;
            if (bzh.wtm != this.mgv.size()) {
                C4990ab.m7421w("MicroMsg.NetSceneShareFavItem", "get url error, request count %d, response count %d", Integer.valueOf(this.mgv.size()), Integer.valueOf(bzh.wtm));
            }
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= bzh.vKr.size() || i5 >= this.mgv.size()) {
                    break;
                }
                C4990ab.m7411d("MicroMsg.NetSceneShareFavItem", "id[%d] url=%s", this.mgv.get(i5), bzh.vKr.get(i5));
                this.mgx.put(((Integer) this.mgv.get(i5)).intValue(), ((bts) bzh.vKr.get(i5)).wVI);
                i4 = i5 + 1;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (this.mgw != null) {
            this.mgw.mo7313d(this.mgx);
        }
        AppMethodBeat.m2505o(102747);
    }

    public final int getType() {
        return 608;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(102748);
        bzg bzg = (bzg) this.ehh.fsG.fsP;
        bzg.wYk = this.toUser;
        bzg.Scene = this.scene;
        bzg.vKh = new LinkedList(this.mgv);
        bzg.jBv = bzg.vKh.size();
        C4990ab.m7411d("MicroMsg.NetSceneShareFavItem", "do scene %s %d %s %d", bzg.wYk, Integer.valueOf(bzg.Scene), bzg.vKh, Integer.valueOf(bzg.jBv));
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(102748);
        return a;
    }
}
