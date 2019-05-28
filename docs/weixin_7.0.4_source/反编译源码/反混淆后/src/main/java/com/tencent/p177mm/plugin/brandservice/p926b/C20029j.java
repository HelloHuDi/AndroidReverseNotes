package com.tencent.p177mm.plugin.brandservice.p926b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.protocal.protobuf.C30168ah;
import com.tencent.p177mm.protocal.protobuf.C30201lk;
import com.tencent.p177mm.protocal.protobuf.bxl;
import com.tencent.p177mm.protocal.protobuf.bxm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.b.j */
public final class C20029j extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C20029j(List<C30201lk> list) {
        AppMethodBeat.m2504i(13852);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bxl();
        c1196a.fsK = new bxm();
        c1196a.uri = "/cgi-bin/micromsg-bin/setapplist";
        this.ehh = c1196a.acD();
        bxl bxl = (bxl) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        for (C30201lk c30201lk : list) {
            C30168ah c30168ah = new C30168ah();
            c30168ah.jBB = c30201lk.userName;
            linkedList.add(c30168ah);
        }
        bxl.jBv = linkedList.size();
        bxl.jBw = linkedList;
        C4990ab.m7417i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", Integer.valueOf(linkedList.size()), linkedList.toString());
        AppMethodBeat.m2505o(13852);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13853);
        C4990ab.m7417i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7417i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", Integer.valueOf(((bxm) this.ehh.fsH.fsP).wlU));
            C33720b.m55106h(196610, Integer.valueOf(r0.wlU));
            C33720b.m55106h(196611, Boolean.FALSE);
        } else {
            C33720b.m55106h(196611, Boolean.TRUE);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(13853);
    }

    public final int getType() {
        return 386;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13854);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13854);
        return a;
    }
}
