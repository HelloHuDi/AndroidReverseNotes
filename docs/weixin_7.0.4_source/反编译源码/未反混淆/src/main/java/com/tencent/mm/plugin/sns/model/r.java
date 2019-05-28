package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cae;
import com.tencent.mm.protocal.protobuf.cah;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.cbf;
import com.tencent.mm.protocal.protobuf.cbi;
import com.tencent.mm.protocal.protobuf.cbj;
import com.tencent.mm.protocal.protobuf.cbk;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cbs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends m implements k {
    public int cNE;
    private b ehh;
    public f ehi;
    private ak handler;
    private long qJi;
    private cat qJj;
    private Object qJk;
    private int qJl;
    public int type;

    public r(long j, int i) {
        this(j, i, null, null);
    }

    public r(long j, int i, Object obj) {
        this(j, i, null, obj);
    }

    public r(long j, int i, cat cat) {
        this(j, i, cat, null);
    }

    private r(long j, int i, cat cat, Object obj) {
        AppMethodBeat.i(36276);
        this.type = -1;
        this.qJi = 0;
        this.cNE = -1;
        this.qJl = 0;
        this.handler = new ak(Looper.getMainLooper());
        this.qJj = cat;
        this.type = i;
        this.qJi = j;
        this.qJk = obj;
        ab.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + i);
        if (cat != null) {
            ab.i("MicroMsg.NetSceneSnsObjectOp", cat.wZG + " " + cat.wZJ);
        }
        a aVar = new a();
        aVar.fsJ = new cbl();
        aVar.fsK = new cbm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.fsI = 218;
        aVar.fsL = 104;
        aVar.fsM = 1000000104;
        this.ehh = aVar.acD();
        cbl cbl = (cbl) this.ehh.fsG.fsP;
        n kD = af.cnF().kD(j);
        if (kD != null) {
            this.cNE = kD.reX;
        }
        cbi a = a(j, i, this.qJj, obj);
        LinkedList linkedList = new LinkedList();
        linkedList.add(a);
        cbl.xaM = linkedList;
        cbl.xaL = linkedList.size();
        AppMethodBeat.o(36276);
    }

    public r(long j, int i, int i2, String str) {
        AppMethodBeat.i(36277);
        this.type = -1;
        this.qJi = 0;
        this.cNE = -1;
        this.qJl = 0;
        this.handler = new ak(Looper.getMainLooper());
        this.qJj = null;
        this.type = 9;
        this.qJi = j;
        ab.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + this.type);
        a aVar = new a();
        aVar.fsJ = new cbl();
        aVar.fsK = new cbm();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.fsI = 218;
        aVar.fsL = 104;
        aVar.fsM = 1000000104;
        this.ehh = aVar.acD();
        cbl cbl = (cbl) this.ehh.fsG.fsP;
        n kD = af.cnF().kD(j);
        if (kD != null) {
            this.cNE = kD.reX;
        }
        cbi A = A(j, this.type);
        cbk cbk = new cbk();
        cbk.Scene = i;
        cbk.xaJ = i2;
        cbk.xaK = aa.vy(str);
        try {
            A.wLt = new SKBuiltinBuffer_t().setBuffer(cbk.toByteArray());
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(A);
        cbl.xaM = linkedList;
        cbl.xaL = linkedList.size();
        AppMethodBeat.o(36277);
    }

    private static cbi a(long j, int i, cat cat, Object obj) {
        n nVar;
        String str;
        AppMethodBeat.i(36278);
        cbi A = A(j, i);
        ab.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp " + i + " " + (obj == null ? "" : obj.toString()));
        String str2 = "";
        if (i == 8 || i == 10 || i == 7 || i == 8 || i == 6) {
            n cqB;
            e ku = af.cnI().ku(j);
            if (ku != null) {
                cqB = ku.cqB();
            } else {
                cqB = null;
            }
            if (cqB == null || !cqB.DI(32)) {
                nVar = cqB;
            } else {
                com.tencent.mm.plugin.sns.storage.a cqq = cqB.cqq();
                str = cqq == null ? "" : cqq.qPj;
                ab.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(str)));
                str2 = str;
                nVar = cqB;
            }
        } else {
            nVar = null;
        }
        if (i == 6) {
            if (cat == null || (cat.wZG == 0 && cat.wZJ == 0)) {
                AppMethodBeat.o(36278);
                return A;
            }
            cam cam = new cam();
            cam.wZC = cat.wZJ;
            cam.wZq = aa.vy(bo.bc(str2, ""));
            try {
                A.wLt = new SKBuiltinBuffer_t().setBuffer(cam.toByteArray());
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
            }
        } else if (i == 7) {
            cae cae = new cae();
            cae.wZq = aa.vy(bo.bc(str2, ""));
            try {
                A.wLt = new SKBuiltinBuffer_t().setBuffer(cae.toByteArray());
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
            }
        } else if (i == 8) {
            int i2 = (obj == null || !(obj instanceof com.tencent.mm.plugin.sns.storage.a.b.a)) ? 0 : 1;
            if (i2 != 0) {
                com.tencent.mm.plugin.sns.storage.a.b.a aVar = (com.tencent.mm.plugin.sns.storage.a.b.a) obj;
                str = bo.bc(str2, "") + ("&" + aVar.qFI + "|" + aVar.qUd);
            } else {
                str = str2;
            }
            cah cah = new cah();
            cah.wZq = aa.vy(bo.bc(str, ""));
            if (nVar != null) {
                cah.vFH = nVar.cre();
                nVar = af.cnF().YS(nVar.cqA());
                if (nVar != null) {
                    str = com.tencent.mm.plugin.sns.a.b.f.a(nVar.cqu());
                } else {
                    ab.v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", str);
                    str = "";
                }
                cah.wZs = aa.vy(bo.bc(str, ""));
            }
            if (i2 == 0 || ((com.tencent.mm.plugin.sns.storage.a.b.a) obj).qUc != com.tencent.mm.plugin.sns.storage.a.b.a.qTY) {
                af.cnI().delete(j);
                af.cnK().ky(j);
                i.kx(j);
                if (i2 != 0) {
                    cah.wZt = ((com.tencent.mm.plugin.sns.storage.a.b.a) obj).qUc;
                }
            } else {
                cah.wZt = com.tencent.mm.plugin.sns.storage.a.b.a.qTY;
            }
            try {
                A.wLt = new SKBuiltinBuffer_t().setBuffer(cah.toByteArray());
            } catch (Exception e22) {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e22, "", new Object[0]);
            }
        } else if (i == 4) {
            if (cat == null || (cat.wZG == 0 && cat.wZJ == 0)) {
                AppMethodBeat.o(36278);
                return A;
            }
            cbj cbj = new cbj();
            cbj.wZG = cat.wZG;
            try {
                A.wLt = new SKBuiltinBuffer_t().setBuffer(cbj.toByteArray());
            } catch (Exception e222) {
                ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e222, "", new Object[0]);
            }
        } else if (i == 10) {
            cbs cbs = new cbs();
            if (obj instanceof com.tencent.mm.bt.b) {
                com.tencent.mm.bt.b bVar = (com.tencent.mm.bt.b) obj;
                cbs.xbe = aa.ad(bVar.wR);
                ab.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + bVar.wR.length);
            } else {
                ab.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
            try {
                byte[] toByteArray = cbs.toByteArray();
                A.wLt = new SKBuiltinBuffer_t().setBuffer(toByteArray);
                ab.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + toByteArray.length);
            } catch (Exception e2222) {
                ab.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + e2222.getMessage());
                ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2222, "", new Object[0]);
            }
        } else if (i == 12) {
            if (obj instanceof cbe) {
                cbe cbe = (cbe) obj;
                try {
                    A.wLt = aa.ad(cbe.toByteArray());
                    ab.i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + cbe.xal);
                } catch (Exception e22222) {
                    ab.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + e22222.getMessage());
                }
            } else {
                ab.e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
            }
        }
        AppMethodBeat.o(36278);
        return A;
    }

    private static cbi A(long j, int i) {
        AppMethodBeat.i(36279);
        cbi cbi = new cbi();
        cbi.wLt = new SKBuiltinBuffer_t();
        cbi.vQE = j;
        cbi.nbk = i;
        AppMethodBeat.o(36279);
        return cbi;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(36280);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(36280);
        return a;
    }

    public final int getType() {
        return 218;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0118 A:{Catch:{ Exception -> 0x013f }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x018a A:{Catch:{ Exception -> 0x01b0 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(36281);
        ab.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            n kD;
            cbf cbf;
            Iterator it;
            Object obj;
            switch (this.type) {
                case 1:
                    af.cnE().kn(this.qJi);
                    af.cnF().delete(this.qJi);
                    break;
                case 2:
                    kD = af.cnF().kD(this.qJi);
                    if (kD != null) {
                        kD.field_pravited = 1;
                        kD.cqO();
                        af.cnF().b(this.qJi, kD);
                        break;
                    }
                    break;
                case 3:
                    kD = af.cnF().kD(this.qJi);
                    if (kD != null) {
                        kD.field_pravited = 0;
                        kD.field_localPrivate = 0;
                        kD.cqR();
                        af.cnF().b(this.qJi, kD);
                        break;
                    }
                    break;
                case 4:
                    n kD2 = af.cnF().kD(this.qJi);
                    if (kD2 != null) {
                        try {
                            cbf = (cbf) new cbf().parseFrom(kD2.field_attrBuf);
                            it = cbf.xat.iterator();
                            while (it.hasNext()) {
                                obj = (cat) it.next();
                                if (this.qJj != null && obj.wZG == this.qJj.wZG) {
                                    if (obj != null) {
                                        cbf.xat.remove(obj);
                                    }
                                    kD2.bi(cbf.toByteArray());
                                    af.cnF().B(kD2);
                                    af.cnK().g(kD2.field_snsId, (long) this.qJj.wZG, this.qJj.jCt);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                            }
                            kD2.bi(cbf.toByteArray());
                            af.cnF().B(kD2);
                            af.cnK().g(kD2.field_snsId, (long) this.qJj.wZG, this.qJj.jCt);
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    af.cnE().kp(this.qJi);
                    break;
                case 6:
                    e ku = af.cnI().ku(this.qJi);
                    if (ku != null) {
                        try {
                            cbf = (cbf) new cbf().parseFrom(ku.field_attrBuf);
                            it = cbf.xat.iterator();
                            while (it.hasNext()) {
                                obj = (cat) it.next();
                                if (this.qJj != null && obj.wZJ == this.qJj.wZJ) {
                                    if (obj != null) {
                                        cbf.xat.remove(obj);
                                    }
                                    ku.bi(cbf.toByteArray());
                                    af.cnI().a(ku);
                                    af.cnK().g(ku.field_snsId, this.qJj.wZJ, this.qJj.jCt);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                            }
                            ku.bi(cbf.toByteArray());
                            af.cnI().a(ku);
                            af.cnK().g(ku.field_snsId, this.qJj.wZJ, this.qJj.jCt);
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 7:
                    af.cnE().kp(this.qJi);
                    break;
                case 8:
                    if (!(this.qJk != null && (this.qJk instanceof com.tencent.mm.plugin.sns.storage.a.b.a) && ((com.tencent.mm.plugin.sns.storage.a.b.a) this.qJk).qUc == com.tencent.mm.plugin.sns.storage.a.b.a.qTY)) {
                        af.cnI().delete(this.qJi);
                        af.cnK().ky(this.qJi);
                        i.kx(this.qJi);
                        break;
                    }
                case 9:
                    kD = af.cnF().kD(this.qJi);
                    if (kD != null) {
                        kD.DJ(2);
                        af.cnF().b(this.qJi, kD);
                        break;
                    }
                    break;
                case 11:
                    ab.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.qJl);
                    if (this.qJl == 0) {
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.TRUE);
                    } else if (this.qJl == 1) {
                        g.RQ();
                        g.RP().Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                    g.RQ();
                    int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0))).intValue();
                    g.RQ();
                    g.RP().Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(intValue + 1));
                    g.RQ();
                    intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0))).intValue();
                    int i4;
                    if (this.qJl == 0) {
                        intValue++;
                        i4 = (intValue * 2) + o.CTRL_INDEX;
                        if (i4 >= 216) {
                            i4 = 216;
                        }
                        if (i4 >= 200) {
                            com.tencent.mm.plugin.sns.lucky.a.b.kT(i4);
                        }
                        ab.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + i4 + " " + intValue);
                    } else if (this.qJl == 1) {
                        intValue++;
                        i4 = ((intValue * 2) + o.CTRL_INDEX) + 1;
                        if (i4 >= 217) {
                            i4 = 217;
                        }
                        if (i4 >= 201) {
                            com.tencent.mm.plugin.sns.lucky.a.b.kT(i4);
                        }
                        ab.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + i4 + " " + intValue);
                    }
                    g.RQ();
                    g.RP().Ry().set(ac.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(intValue));
                    break;
                case 12:
                    if (this.qJk != null && (this.qJk instanceof cbe)) {
                        af.cnK().y(this.qJi, ((cbe) this.qJk).xal == 1);
                        ab.i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", Long.valueOf(this.qJi), Boolean.valueOf(r0));
                        break;
                    }
            }
            af.cnE().cnf();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(36281);
            return;
        }
        if (i2 == 4 && this.type == 1) {
            switch (this.type) {
                case 1:
                    af.cnE().kn(this.qJi);
                    break;
                case 5:
                case 7:
                    af.cnE().kp(this.qJi);
                    break;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(36281);
    }
}
