package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.vfs.e;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class m extends com.tencent.mm.ai.m implements k {
    public static List<Long> qIU = Collections.synchronizedList(new LinkedList());
    public static List<Long> qIV = Collections.synchronizedList(new LinkedList());
    private long cND;
    private b ehh;
    public f ehi;
    private String fUM;

    static {
        AppMethodBeat.i(36253);
        AppMethodBeat.o(36253);
    }

    public static boolean kb(long j) {
        AppMethodBeat.i(36245);
        if (qIU.contains(Long.valueOf(j))) {
            AppMethodBeat.o(36245);
            return false;
        }
        qIU.add(Long.valueOf(j));
        AppMethodBeat.o(36245);
        return true;
    }

    public static boolean kc(long j) {
        AppMethodBeat.i(36246);
        if (qIV.contains(Long.valueOf(j))) {
            AppMethodBeat.o(36246);
            return false;
        }
        qIV.add(Long.valueOf(j));
        AppMethodBeat.o(36246);
        return true;
    }

    private static boolean kd(long j) {
        AppMethodBeat.i(36247);
        qIV.remove(Long.valueOf(j));
        AppMethodBeat.o(36247);
        return true;
    }

    private static boolean ke(long j) {
        AppMethodBeat.i(36248);
        qIU.remove(Long.valueOf(j));
        AppMethodBeat.o(36248);
        return true;
    }

    public m(long j, int i, String str) {
        int i2;
        AppMethodBeat.i(36249);
        this.cND = j;
        a aVar = new a();
        aVar.fsJ = new caj();
        aVar.fsK = new cak();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsadobjectdetail";
        aVar.fsI = 683;
        StringBuilder stringBuilder = new StringBuilder();
        g.RQ();
        this.fUM = stringBuilder.append(g.RP().cachePath).append("ad_detail_session").toString();
        if (at.isWifi(ah.getContext())) {
            i2 = 1;
        } else if (at.is3G(ah.getContext())) {
            i2 = 3;
        } else if (at.is4G(ah.getContext())) {
            i2 = 4;
        } else if (at.is2G(ah.getContext())) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        byte[] e = e.e(this.fUM, 0, -1);
        this.ehh = aVar.acD();
        ((caj) this.ehh.fsG.fsP).vQE = j;
        ((caj) this.ehh.fsG.fsP).wZw = aa.ad(e);
        ((caj) this.ehh.fsG.fsP).Scene = i;
        ((caj) this.ehh.fsG.fsP).wZy = i2;
        if (str != null && str.length() > 0) {
            ((caj) this.ehh.fsG.fsP).wZx = aa.vz(str);
        }
        ab.d("MicroMsg.NetSceneSnsAdObjectDetial", "req snsId " + j + " " + i.jV(j) + " scene " + i + " buf is null? " + (e == null));
        ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "do adObjectDetail snsId[%d] scene[%d] syncBuffer[%s]", Long.valueOf(j), Integer.valueOf(i), str);
        AppMethodBeat.o(36249);
    }

    public m(long j, brf brf) {
        this(j, 2, "");
        AppMethodBeat.i(36250);
        ((caj) this.ehh.fsG.fsP).vFa = brf;
        AppMethodBeat.o(36250);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(36251);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36251);
        return a;
    }

    public final int getType() {
        return 683;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        byte[] a;
        AppMethodBeat.i(36252);
        ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "errType " + i2 + " errCode " + i3);
        Object obj = null;
        if (i2 == 0 && i3 == 0) {
            obj = 1;
        } else if (i2 == 4 && i3 == 1) {
            a = aa.a(((cak) this.ehh.fsH.fsP).wZw);
            if (a != null) {
                e.deleteFile(this.fUM);
                e.b(this.fUM, a, a.length);
            }
            obj = null;
        }
        if (obj == null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            if (((caj) this.ehh.fsG.fsP).Scene == 2) {
                h.pYm.k(955, 1, 1);
            } else {
                h.pYm.k(955, 0, 1);
            }
            ke(this.cND);
            kd(this.cND);
            AppMethodBeat.o(36252);
            return;
        }
        a = aa.a(((cak) this.ehh.fsH.fsP).wZw);
        if (a != null) {
            e.deleteFile(this.fUM);
            e.b(this.fUM, a, a.length);
        }
        cai cai = ((cak) this.ehh.fsH.fsP).wZz;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = ((cak) this.ehh.fsH.fsP).wZA;
        int i4 = ((caj) this.ehh.fsG.fsP).Scene;
        if (cai != null) {
            ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "snsdetail xml " + aa.b(cai.wZu.xam));
            ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "adxml " + cai.wZv);
        }
        if (cai == null || cai.wZu == null || cai.wZu.wGu <= 0) {
            if (!(cai == null || cai.wZu == null)) {
                ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "detail comment:" + cai.wZu.xat.size() + " like: " + cai.wZu.xaq.size());
            }
            if (i4 == 2) {
                ab.i("MicroMsg.NetSceneSnsAdObjectDetial", "get atDetail %s", Long.valueOf(this.cND));
                cy cyVar = ((cak) this.ehh.fsH.fsP).wZB;
                if (cyVar != null) {
                    a.a(cyVar);
                }
            } else {
                a.a(cai, sKBuiltinBuffer_t);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            ke(this.cND);
            kd(this.cND);
            AppMethodBeat.o(36252);
            return;
        }
        ab.i("MicroMsg.NetSceneSnsAdObjectDetial", cai.wZu.vQE + " will remove by get detail ");
        ke(this.cND);
        kd(this.cND);
        af.cnI().delete(cai.wZu.vQE);
        af.cnK().ky(cai.wZu.vQE);
        com.tencent.mm.plugin.sns.storage.i.kx(cai.wZu.vQE);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36252);
    }
}
