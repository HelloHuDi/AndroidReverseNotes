package com.tencent.p177mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C21904b;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C13341f;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21980a.C21982b.C21983a;
import com.tencent.p177mm.plugin.sns.storage.C21991i;
import com.tencent.p177mm.plugin.sns.storage.C43570e;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cae;
import com.tencent.p177mm.protocal.protobuf.cah;
import com.tencent.p177mm.protocal.protobuf.cam;
import com.tencent.p177mm.protocal.protobuf.cat;
import com.tencent.p177mm.protocal.protobuf.cbe;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbi;
import com.tencent.p177mm.protocal.protobuf.cbj;
import com.tencent.p177mm.protocal.protobuf.cbk;
import com.tencent.p177mm.protocal.protobuf.cbl;
import com.tencent.p177mm.protocal.protobuf.cbm;
import com.tencent.p177mm.protocal.protobuf.cbs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.model.r */
public final class C46224r extends C1207m implements C1918k {
    public int cNE;
    private C7472b ehh;
    public C1202f ehi;
    private C7306ak handler;
    private long qJi;
    private cat qJj;
    private Object qJk;
    private int qJl;
    public int type;

    public C46224r(long j, int i) {
        this(j, i, null, null);
    }

    public C46224r(long j, int i, Object obj) {
        this(j, i, null, obj);
    }

    public C46224r(long j, int i, cat cat) {
        this(j, i, cat, null);
    }

    private C46224r(long j, int i, cat cat, Object obj) {
        AppMethodBeat.m2504i(36276);
        this.type = -1;
        this.qJi = 0;
        this.cNE = -1;
        this.qJl = 0;
        this.handler = new C7306ak(Looper.getMainLooper());
        this.qJj = cat;
        this.type = i;
        this.qJi = j;
        this.qJk = obj;
        C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + i);
        if (cat != null) {
            C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", cat.wZG + " " + cat.wZJ);
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cbl();
        c1196a.fsK = new cbm();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        c1196a.fsI = 218;
        c1196a.fsL = 104;
        c1196a.fsM = 1000000104;
        this.ehh = c1196a.acD();
        cbl cbl = (cbl) this.ehh.fsG.fsP;
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD != null) {
            this.cNE = kD.reX;
        }
        cbi a = C46224r.m86447a(j, i, this.qJj, obj);
        LinkedList linkedList = new LinkedList();
        linkedList.add(a);
        cbl.xaM = linkedList;
        cbl.xaL = linkedList.size();
        AppMethodBeat.m2505o(36276);
    }

    public C46224r(long j, int i, int i2, String str) {
        AppMethodBeat.m2504i(36277);
        this.type = -1;
        this.qJi = 0;
        this.cNE = -1;
        this.qJl = 0;
        this.handler = new C7306ak(Looper.getMainLooper());
        this.qJj = null;
        this.type = 9;
        this.qJi = j;
        C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + this.type);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cbl();
        c1196a.fsK = new cbm();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        c1196a.fsI = 218;
        c1196a.fsL = 104;
        c1196a.fsM = 1000000104;
        this.ehh = c1196a.acD();
        cbl cbl = (cbl) this.ehh.fsG.fsP;
        C46236n kD = C13373af.cnF().mo62941kD(j);
        if (kD != null) {
            this.cNE = kD.reX;
        }
        cbi A = C46224r.m86446A(j, this.type);
        cbk cbk = new cbk();
        cbk.Scene = i;
        cbk.xaJ = i2;
        cbk.xaK = C1946aa.m4154vy(str);
        try {
            A.wLt = new SKBuiltinBuffer_t().setBuffer(cbk.toByteArray());
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(A);
        cbl.xaM = linkedList;
        cbl.xaL = linkedList.size();
        AppMethodBeat.m2505o(36277);
    }

    /* renamed from: a */
    private static cbi m86447a(long j, int i, cat cat, Object obj) {
        C46236n c46236n;
        String str;
        AppMethodBeat.m2504i(36278);
        cbi A = C46224r.m86446A(j, i);
        C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp " + i + " " + (obj == null ? "" : obj.toString()));
        String str2 = "";
        if (i == 8 || i == 10 || i == 7 || i == 8 || i == 6) {
            C46236n cqB;
            C43570e ku = C13373af.cnI().mo69174ku(j);
            if (ku != null) {
                cqB = ku.cqB();
            } else {
                cqB = null;
            }
            if (cqB == null || !cqB.mo74253DI(32)) {
                c46236n = cqB;
            } else {
                C21980a cqq = cqB.cqq();
                str = cqq == null ? "" : cqq.qPj;
                C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo ".concat(String.valueOf(str)));
                str2 = str;
                c46236n = cqB;
            }
        } else {
            c46236n = null;
        }
        if (i == 6) {
            if (cat == null || (cat.wZG == 0 && cat.wZJ == 0)) {
                AppMethodBeat.m2505o(36278);
                return A;
            }
            cam cam = new cam();
            cam.wZC = cat.wZJ;
            cam.wZq = C1946aa.m4154vy(C5046bo.m7532bc(str2, ""));
            try {
                A.wLt = new SKBuiltinBuffer_t().setBuffer(cam.toByteArray());
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
            }
        } else if (i == 7) {
            cae cae = new cae();
            cae.wZq = C1946aa.m4154vy(C5046bo.m7532bc(str2, ""));
            try {
                A.wLt = new SKBuiltinBuffer_t().setBuffer(cae.toByteArray());
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
            }
        } else if (i == 8) {
            int i2 = (obj == null || !(obj instanceof C21983a)) ? 0 : 1;
            if (i2 != 0) {
                C21983a c21983a = (C21983a) obj;
                str = C5046bo.m7532bc(str2, "") + ("&" + c21983a.qFI + "|" + c21983a.qUd);
            } else {
                str = str2;
            }
            cah cah = new cah();
            cah.wZq = C1946aa.m4154vy(C5046bo.m7532bc(str, ""));
            if (c46236n != null) {
                cah.vFH = c46236n.cre();
                c46236n = C13373af.cnF().mo62917YS(c46236n.cqA());
                if (c46236n != null) {
                    str = C13341f.m21439a(c46236n.cqu());
                } else {
                    C4990ab.m7419v("SnsAdExtUtil", "getSnsStatExtBySnsId snsInfo null, snsId %s", str);
                    str = "";
                }
                cah.wZs = C1946aa.m4154vy(C5046bo.m7532bc(str, ""));
            }
            if (i2 == 0 || ((C21983a) obj).qUc != C21983a.qTY) {
                C13373af.cnI().delete(j);
                C13373af.cnK().mo47208ky(j);
                C21991i.m33620kx(j);
                if (i2 != 0) {
                    cah.wZt = ((C21983a) obj).qUc;
                }
            } else {
                cah.wZt = C21983a.qTY;
            }
            try {
                A.wLt = new SKBuiltinBuffer_t().setBuffer(cah.toByteArray());
            } catch (Exception e22) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e22, "", new Object[0]);
            }
        } else if (i == 4) {
            if (cat == null || (cat.wZG == 0 && cat.wZJ == 0)) {
                AppMethodBeat.m2505o(36278);
                return A;
            }
            cbj cbj = new cbj();
            cbj.wZG = cat.wZG;
            try {
                A.wLt = new SKBuiltinBuffer_t().setBuffer(cbj.toByteArray());
            } catch (Exception e222) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e222, "", new Object[0]);
            }
        } else if (i == 10) {
            cbs cbs = new cbs();
            if (obj instanceof C1332b) {
                C1332b c1332b = (C1332b) obj;
                cbs.xbe = C1946aa.m4152ad(c1332b.f1226wR);
                C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + c1332b.f1226wR.length);
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
            try {
                byte[] toByteArray = cbs.toByteArray();
                A.wLt = new SKBuiltinBuffer_t().setBuffer(toByteArray);
                C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "opFree " + toByteArray.length);
            } catch (Exception e2222) {
                C4990ab.m7412e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + e2222.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2222, "", new Object[0]);
            }
        } else if (i == 12) {
            if (obj instanceof cbe) {
                cbe cbe = (cbe) obj;
                try {
                    A.wLt = C1946aa.m4152ad(cbe.toByteArray());
                    C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "snsMetionBlockOp, switch:%d " + cbe.xal);
                } catch (Exception e22222) {
                    C4990ab.m7412e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp " + e22222.getMessage());
                }
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneSnsObjectOp", "error snsMetionBlockOp");
            }
        }
        AppMethodBeat.m2505o(36278);
        return A;
    }

    /* renamed from: A */
    private static cbi m86446A(long j, int i) {
        AppMethodBeat.m2504i(36279);
        cbi cbi = new cbi();
        cbi.wLt = new SKBuiltinBuffer_t();
        cbi.vQE = j;
        cbi.nbk = i;
        AppMethodBeat.m2505o(36279);
        return cbi;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36280);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36280);
        return a;
    }

    public final int getType() {
        return 218;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0118 A:{Catch:{ Exception -> 0x013f }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x018a A:{Catch:{ Exception -> 0x01b0 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36281);
        C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            C46236n kD;
            cbf cbf;
            Iterator it;
            Object obj;
            switch (this.type) {
                case 1:
                    C13373af.cnE().mo37411kn(this.qJi);
                    C13373af.cnF().delete(this.qJi);
                    break;
                case 2:
                    kD = C13373af.cnF().mo62941kD(this.qJi);
                    if (kD != null) {
                        kD.field_pravited = 1;
                        kD.cqO();
                        C13373af.cnF().mo62930b(this.qJi, kD);
                        break;
                    }
                    break;
                case 3:
                    kD = C13373af.cnF().mo62941kD(this.qJi);
                    if (kD != null) {
                        kD.field_pravited = 0;
                        kD.field_localPrivate = 0;
                        kD.cqR();
                        C13373af.cnF().mo62930b(this.qJi, kD);
                        break;
                    }
                    break;
                case 4:
                    C46236n kD2 = C13373af.cnF().mo62941kD(this.qJi);
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
                                    kD2.mo74256bi(cbf.toByteArray());
                                    C13373af.cnF().mo62912B(kD2);
                                    C13373af.cnK().mo47207g(kD2.field_snsId, (long) this.qJj.wZG, this.qJj.jCt);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                            }
                            kD2.mo74256bi(cbf.toByteArray());
                            C13373af.cnF().mo62912B(kD2);
                            C13373af.cnK().mo47207g(kD2.field_snsId, (long) this.qJj.wZG, this.qJj.jCt);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    C13373af.cnE().mo37413kp(this.qJi);
                    break;
                case 6:
                    C43570e ku = C13373af.cnI().mo69174ku(this.qJi);
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
                                    ku.mo69152bi(cbf.toByteArray());
                                    C13373af.cnI().mo10099a(ku);
                                    C13373af.cnK().mo47207g(ku.field_snsId, this.qJj.wZJ, this.qJj.jCt);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                            }
                            ku.mo69152bi(cbf.toByteArray());
                            C13373af.cnI().mo10099a(ku);
                            C13373af.cnK().mo47207g(ku.field_snsId, this.qJj.wZJ, this.qJj.jCt);
                        } catch (Exception e2) {
                            C4990ab.printErrStackTrace("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 7:
                    C13373af.cnE().mo37413kp(this.qJi);
                    break;
                case 8:
                    if (!(this.qJk != null && (this.qJk instanceof C21983a) && ((C21983a) this.qJk).qUc == C21983a.qTY)) {
                        C13373af.cnI().delete(this.qJi);
                        C13373af.cnK().mo47208ky(this.qJi);
                        C21991i.m33620kx(this.qJi);
                        break;
                    }
                case 9:
                    kD = C13373af.cnF().mo62941kD(this.qJi);
                    if (kD != null) {
                        kD.mo74254DJ(2);
                        C13373af.cnF().mo62930b(this.qJi, kD);
                        break;
                    }
                    break;
                case 11:
                    C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.qJl);
                    if (this.qJl == 0) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.TRUE);
                    } else if (this.qJl == 1) {
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYOPEN_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                    C1720g.m3537RQ();
                    int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0))).intValue();
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(intValue + 1));
                    C1720g.m3537RQ();
                    intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0))).intValue();
                    int i4;
                    if (this.qJl == 0) {
                        intValue++;
                        i4 = (intValue * 2) + C27011o.CTRL_INDEX;
                        if (i4 >= 216) {
                            i4 = 216;
                        }
                        if (i4 >= 200) {
                            C21904b.m33474kT(i4);
                        }
                        C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + i4 + " " + intValue);
                    } else if (this.qJl == 1) {
                        intValue++;
                        i4 = ((intValue * 2) + C27011o.CTRL_INDEX) + 1;
                        if (i4 >= 217) {
                            i4 = 217;
                        }
                        if (i4 >= 201) {
                            C21904b.m33474kT(i4);
                        }
                        C4990ab.m7416i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + i4 + " " + intValue);
                    }
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(intValue));
                    break;
                case 12:
                    if (this.qJk != null && (this.qJk instanceof cbe)) {
                        C13373af.cnK().mo47209y(this.qJi, ((cbe) this.qJk).xal == 1);
                        C4990ab.m7417i("MicroMsg.NetSceneSnsObjectOp", "remind  update [snsId:%d] ->isSilence: %b", Long.valueOf(this.qJi), Boolean.valueOf(r0));
                        break;
                    }
            }
            C13373af.cnE().cnf();
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(36281);
            return;
        }
        if (i2 == 4 && this.type == 1) {
            switch (this.type) {
                case 1:
                    C13373af.cnE().mo37411kn(this.qJi);
                    break;
                case 5:
                case 7:
                    C13373af.cnE().mo37413kp(this.qJi);
                    break;
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(36281);
    }
}
