package com.tencent.p177mm.plugin.brandservice.p926b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.protocal.protobuf.C30168ah;
import com.tencent.p177mm.protocal.protobuf.adu;
import com.tencent.p177mm.protocal.protobuf.adv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.brandservice.b.e */
public final class C42794e extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    LinkedList<String> jKy;

    public C42794e() {
        String str;
        AppMethodBeat.m2504i(13836);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new adu();
        c1196a.fsK = new adv();
        c1196a.uri = "/cgi-bin/micromsg-bin/getapplist";
        this.ehh = c1196a.acD();
        this.jKy = new LinkedList();
        adu adu = (adu) this.ehh.fsG.fsP;
        C1720g.m3537RQ();
        Object obj = C1720g.m3536RP().mo5239Ry().get(196610, null);
        String str2 = "MicroMsg.BrandService.BrandServiceApplication";
        String str3 = "get config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(196610);
        if (obj == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = obj.toString();
        }
        objArr[1] = str;
        C4990ab.m7417i(str2, str3, objArr);
        adu.wlU = C5046bo.m7512a((Integer) obj, 0);
        C4990ab.m7417i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", Integer.valueOf(adu.wlU));
        AppMethodBeat.m2505o(13836);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13837);
        C4990ab.m7421w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            adv adv = (adv) this.ehh.fsH.fsP;
            C4990ab.m7417i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", Integer.valueOf(adv.wlU), Integer.valueOf(adv.jBv));
            C33720b.m55106h(196610, Integer.valueOf(adv.wlU));
            Iterator it = adv.jBw.iterator();
            while (it.hasNext()) {
                this.jKy.add(((C30168ah) it.next()).jBB);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(13837);
    }

    public final int getType() {
        return 387;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13838);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13838);
        return a;
    }
}
