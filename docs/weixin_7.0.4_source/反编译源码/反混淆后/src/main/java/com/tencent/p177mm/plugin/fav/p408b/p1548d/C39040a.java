package com.tencent.p177mm.plugin.fav.p408b.p1548d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44161qx;
import com.tencent.p177mm.protocal.protobuf.C44162qy;
import com.tencent.p177mm.protocal.protobuf.C44163qz;
import com.tencent.p177mm.protocal.protobuf.aax;
import com.tencent.p177mm.protocal.protobuf.abi;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.b.d.a */
public final class C39040a extends C1207m implements C1918k {
    private C1202f ehi = null;
    private C7472b fAT;

    public C39040a(List<aax> list) {
        AppMethodBeat.m2504i(5321);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44161qx();
        c1196a.fsK = new C44162qy();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        c1196a.fsI = 405;
        c1196a.fsL = 196;
        c1196a.fsM = 1000000196;
        this.fAT = c1196a.acD();
        C44161qx c44161qx = (C44161qx) this.fAT.fsG.fsP;
        c44161qx.vYb = new LinkedList();
        c44161qx.vYb.addAll(list);
        c44161qx.Scene = 1;
        C4990ab.m7417i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_OBJECT %s", Integer.valueOf(list.size()));
        AppMethodBeat.m2505o(5321);
    }

    public C39040a(abi abi) {
        AppMethodBeat.m2504i(5322);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44161qx();
        c1196a.fsK = new C44162qy();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkfavitem";
        c1196a.fsI = 405;
        c1196a.fsL = 196;
        c1196a.fsM = 1000000196;
        this.fAT = c1196a.acD();
        C44161qx c44161qx = (C44161qx) this.fAT.fsG.fsP;
        c44161qx.vYc = abi;
        c44161qx.Scene = 2;
        C4990ab.m7417i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem CHECK_FAV_ITEM_SCENE_FIX_DATA %s", Integer.valueOf(abi.vEp));
        AppMethodBeat.m2505o(5322);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(5323);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(5323);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(5324);
        C4990ab.m7417i("MicroMsg.Fav.NetSceneCheckFavItem", "netId %d errType %d errCode %d errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        C44162qy c44162qy = (C44162qy) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            Iterator it = c44162qy.vYd.iterator();
            while (it.hasNext()) {
                C44163qz c44163qz = (C44163qz) it.next();
                C4990ab.m7417i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem, onGYNetEnd,favid: %d, ret: %d", Integer.valueOf(c44163qz.vEp), Integer.valueOf(c44163qz.Ret));
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(5324);
            return;
        }
        C4990ab.m7417i("MicroMsg.Fav.NetSceneCheckFavItem", "NetSceneCheckFavItem,cgi return error,errcode:%d,errType:%d", Integer.valueOf(i3), Integer.valueOf(i2));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(5324);
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final int acn() {
        return 10;
    }

    public final int getType() {
        return 405;
    }
}
