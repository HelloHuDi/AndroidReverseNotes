package com.tencent.p177mm.plugin.sns.model;

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
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.protocal.protobuf.C46531cy;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.brf;
import com.tencent.p177mm.protocal.protobuf.cai;
import com.tencent.p177mm.protocal.protobuf.caj;
import com.tencent.p177mm.protocal.protobuf.cak;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sns.model.m */
public final class C13428m extends C1207m implements C1918k {
    public static List<Long> qIU = Collections.synchronizedList(new LinkedList());
    public static List<Long> qIV = Collections.synchronizedList(new LinkedList());
    private long cND;
    private C7472b ehh;
    public C1202f ehi;
    private String fUM;

    static {
        AppMethodBeat.m2504i(36253);
        AppMethodBeat.m2505o(36253);
    }

    /* renamed from: kb */
    public static boolean m21566kb(long j) {
        AppMethodBeat.m2504i(36245);
        if (qIU.contains(Long.valueOf(j))) {
            AppMethodBeat.m2505o(36245);
            return false;
        }
        qIU.add(Long.valueOf(j));
        AppMethodBeat.m2505o(36245);
        return true;
    }

    /* renamed from: kc */
    public static boolean m21567kc(long j) {
        AppMethodBeat.m2504i(36246);
        if (qIV.contains(Long.valueOf(j))) {
            AppMethodBeat.m2505o(36246);
            return false;
        }
        qIV.add(Long.valueOf(j));
        AppMethodBeat.m2505o(36246);
        return true;
    }

    /* renamed from: kd */
    private static boolean m21568kd(long j) {
        AppMethodBeat.m2504i(36247);
        qIV.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(36247);
        return true;
    }

    /* renamed from: ke */
    private static boolean m21569ke(long j) {
        AppMethodBeat.m2504i(36248);
        qIU.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(36248);
        return true;
    }

    public C13428m(long j, int i, String str) {
        int i2;
        AppMethodBeat.m2504i(36249);
        this.cND = j;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new caj();
        c1196a.fsK = new cak();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
        c1196a.fsI = 683;
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3537RQ();
        this.fUM = stringBuilder.append(C1720g.m3536RP().cachePath).append("ad_detail_session").toString();
        if (C5023at.isWifi(C4996ah.getContext())) {
            i2 = 1;
        } else if (C5023at.is3G(C4996ah.getContext())) {
            i2 = 3;
        } else if (C5023at.is4G(C4996ah.getContext())) {
            i2 = 4;
        } else if (C5023at.is2G(C4996ah.getContext())) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        byte[] e = C5730e.m8632e(this.fUM, 0, -1);
        this.ehh = c1196a.acD();
        ((caj) this.ehh.fsG.fsP).vQE = j;
        ((caj) this.ehh.fsG.fsP).wZw = C1946aa.m4152ad(e);
        ((caj) this.ehh.fsG.fsP).Scene = i;
        ((caj) this.ehh.fsG.fsP).wZy = i2;
        if (str != null && str.length() > 0) {
            ((caj) this.ehh.fsG.fsP).wZx = C1946aa.m4155vz(str);
        }
        C4990ab.m7410d("MicroMsg.NetSceneSnsAdObjectDetial", "req snsId " + j + " " + C29036i.m46117jV(j) + " scene " + i + " buf is null? " + (e == null));
        C4990ab.m7417i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", Long.valueOf(j), Integer.valueOf(i), str);
        AppMethodBeat.m2505o(36249);
    }

    public C13428m(long j, brf brf) {
        this(j, 2, "");
        AppMethodBeat.m2504i(36250);
        ((caj) this.ehh.fsG.fsP).vFa = brf;
        AppMethodBeat.m2505o(36250);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36251);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36251);
        return a;
    }

    public final int getType() {
        return 683;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        byte[] a;
        AppMethodBeat.m2504i(36252);
        C4990ab.m7416i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + i2 + " errCode " + i3);
        Object obj = null;
        if (i2 == 0 && i3 == 0) {
            obj = 1;
        } else if (i2 == 4 && i3 == 1) {
            a = C1946aa.m4150a(((cak) this.ehh.fsH.fsP).wZw);
            if (a != null) {
                C5730e.deleteFile(this.fUM);
                C5730e.m8624b(this.fUM, a, a.length);
            }
            obj = null;
        }
        if (obj == null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            if (((caj) this.ehh.fsG.fsP).Scene == 2) {
                C7060h.pYm.mo15419k(955, 1, 1);
            } else {
                C7060h.pYm.mo15419k(955, 0, 1);
            }
            C13428m.m21569ke(this.cND);
            C13428m.m21568kd(this.cND);
            AppMethodBeat.m2505o(36252);
            return;
        }
        a = C1946aa.m4150a(((cak) this.ehh.fsH.fsP).wZw);
        if (a != null) {
            C5730e.deleteFile(this.fUM);
            C5730e.m8624b(this.fUM, a, a.length);
        }
        cai cai = ((cak) this.ehh.fsH.fsP).wZz;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = ((cak) this.ehh.fsH.fsP).wZA;
        int i4 = ((caj) this.ehh.fsG.fsP).Scene;
        if (cai != null) {
            C4990ab.m7416i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + C1946aa.m4153b(cai.wZu.xam));
            C4990ab.m7416i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + cai.wZv);
        }
        if (cai == null || cai.wZu == null || cai.wZu.wGu <= 0) {
            if (!(cai == null || cai.wZu == null)) {
                C4990ab.m7416i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + cai.wZu.xat.size() + " like: " + cai.wZu.xaq.size());
            }
            if (i4 == 2) {
                C4990ab.m7417i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", Long.valueOf(this.cND));
                C46531cy c46531cy = ((cak) this.ehh.fsH.fsP).wZB;
                if (c46531cy != null) {
                    C43555a.m77869a(c46531cy);
                }
            } else {
                C43555a.m77867a(cai, sKBuiltinBuffer_t);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            C13428m.m21569ke(this.cND);
            C13428m.m21568kd(this.cND);
            AppMethodBeat.m2505o(36252);
            return;
        }
        C4990ab.m7416i("MicroMsg.NetSceneSnsAdObjectDetial", cai.wZu.vQE + " will remove by get detail ");
        C13428m.m21569ke(this.cND);
        C13428m.m21568kd(this.cND);
        C13373af.cnI().delete(cai.wZu.vQE);
        C13373af.cnK().mo47208ky(cai.wZu.vQE);
        C21991i.m33620kx(cai.wZu.vQE);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36252);
    }
}
