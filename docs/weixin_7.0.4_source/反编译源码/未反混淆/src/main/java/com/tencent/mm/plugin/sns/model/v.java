package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class v extends m implements k {
    private String cvZ;
    private int czE;
    private b ehh;
    public f ehi;
    public LinkedList<cbz> qJN = null;
    public int qJO;

    public v(int i) {
        String str;
        AppMethodBeat.i(36323);
        this.czE = i;
        a aVar = new a();
        aVar.fsJ = new cca();
        aVar.fsK = new ccb();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnstaglist";
        aVar.fsI = 292;
        aVar.fsL = 116;
        aVar.fsM = 1000000116;
        this.ehh = aVar.acD();
        String str2 = af.cnJ().YX("@__weixintsnstag").field_md5;
        if (str2 == null) {
            str = "";
        } else {
            str = str2;
        }
        this.cvZ = str;
        cca cca = (cca) this.ehh.fsG.fsP;
        cca.OpCode = i;
        cca.xbu = str;
        AppMethodBeat.o(36323);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(36324);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36324);
        return a;
    }

    public final int getType() {
        return 292;
    }

    public static t a(t tVar, cbz cbz) {
        AppMethodBeat.i(36325);
        tVar.field_tagId = cbz.xbt;
        tVar.field_tagName = bo.bc(cbz.ncF, "");
        tVar.field_count = cbz.jBv;
        tVar.m8do(cbz.jBw);
        ab.d("MicroMsg.NetSceneSnsTagList", "tagInfo getList: " + cbz.toString());
        AppMethodBeat.o(36325);
        return tVar;
    }

    private static boolean a(List<Long> list, Long l) {
        AppMethodBeat.i(36326);
        for (Long longValue : list) {
            if (longValue.longValue() == l.longValue()) {
                AppMethodBeat.o(36326);
                return true;
            }
        }
        AppMethodBeat.o(36326);
        return false;
    }

    public final List<String> kk(long j) {
        AppMethodBeat.i(36327);
        LinkedList linkedList = new LinkedList();
        if (this.qJN == null) {
            AppMethodBeat.o(36327);
            return linkedList;
        }
        Iterator it = this.qJN.iterator();
        while (it.hasNext()) {
            cbz cbz = (cbz) it.next();
            if (cbz.xbt == j) {
                it = cbz.jBw.iterator();
                while (it.hasNext()) {
                    linkedList.add(((bts) it.next()).wVI);
                }
                AppMethodBeat.o(36327);
                return linkedList;
            }
        }
        AppMethodBeat.o(36327);
        return linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36328);
        ab.d("MicroMsg.NetSceneSnsTagList", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            ccb ccb = (ccb) ((b) qVar).fsH.fsP;
            ab.d("MicroMsg.NetSceneSnsTagList", "[onGYNetEnd]State：%s", Integer.valueOf(this.qJO));
            this.qJO = ccb.qJO;
            this.qJN = ccb.jBw;
            String str2 = ccb.xbu;
            if (this.cvZ.equals(str2)) {
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(36328);
                return;
            }
            List cru = af.cnL().cru();
            if (this.czE != 3) {
                Iterator it = cru.iterator();
                while (it.hasNext()) {
                    Object obj;
                    Long l = (Long) it.next();
                    Iterator it2 = ccb.jBw.iterator();
                    while (it2.hasNext()) {
                        if (l.longValue() == ((cbz) it2.next()).xbt) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        it.remove();
                        af.cnL().kG(l.longValue());
                    }
                }
            }
            Iterator it3 = ccb.jBw.iterator();
            while (it3.hasNext()) {
                cbz cbz = (cbz) it3.next();
                t kF;
                if (a(cru, Long.valueOf(cbz.xbt))) {
                    kF = af.cnL().kF(cbz.xbt);
                    if ((kF.field_tagName != null && !kF.field_tagName.equals(cbz.ncF)) || kF.field_count != cbz.jBv || b(kF, cbz)) {
                        a(kF, cbz);
                        af.cnL().a(kF);
                    }
                } else {
                    kF = new t();
                    a(kF, cbz);
                    af.cnL().a(kF);
                }
            }
            l YX = af.cnJ().YX("@__weixintsnstag");
            YX.field_md5 = str2;
            af.cnJ().a(YX);
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36328);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36328);
    }

    private static boolean b(t tVar, cbz cbz) {
        boolean z = false;
        AppMethodBeat.i(36329);
        String[] split = tVar.field_memberList.split(",");
        Iterator it = cbz.jBw.iterator();
        while (it.hasNext()) {
            boolean z2;
            bts bts = (bts) it.next();
            for (String equals : split) {
                if (equals.equals(bts)) {
                    z2 = true;
                    continue;
                    break;
                }
            }
            z2 = false;
            continue;
            if (!z2) {
                z = true;
                break;
            }
        }
        AppMethodBeat.o(36329);
        return z;
    }
}
