package com.tencent.mm.plugin.account.friend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ac extends m implements k {
    public final b ehh;
    private f ehi = null;

    public ac(int i) {
        AppMethodBeat.i(108450);
        a aVar = new a();
        aVar.fsJ = new amw();
        aVar.fsK = new amx();
        aVar.uri = "/cgi-bin/micromsg-bin/getqqgroup";
        aVar.fsI = ErrorCode.NEEDDOWNLOAD_4;
        aVar.fsL = 38;
        aVar.fsM = 1000000038;
        this.ehh = aVar.acD();
        amw amw = (amw) this.ehh.fsG.fsP;
        amw.nbk = 1;
        amw.wrw = i;
        AppMethodBeat.o(108450);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108451);
        this.ehi = fVar;
        amw amw = (amw) this.ehh.fsG.fsP;
        if (amw.nbk == 1 && ((an) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).mY(amw.wrw) == null) {
            ab.e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
            AppMethodBeat.o(108451);
            return -1;
        }
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108451);
        return a;
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_4;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108452);
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            amw amw = (amw) this.ehh.fsG.fsP;
            amx amx = (amx) this.ehh.fsH.fsP;
            if (amw.nbk == 0) {
                a(amx.wrx);
            } else {
                ao aoVar;
                ArrayList<ao> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= amx.wry.jBv) {
                        break;
                    }
                    Object obj;
                    j jVar;
                    h hVar;
                    bmu bmu = (bmu) amx.wry.wPM.get(i5);
                    int i6 = amw.wrw;
                    ab.v("MicroMsg.NetSceneGetQQGroup", "friend");
                    ao aoVar2 = new ao();
                    aoVar2.gwC = new p(bmu.wPI).longValue();
                    com.tencent.mm.ah.b.d(aoVar2.gwC, 3);
                    aoVar2.gwE = i6;
                    aoVar2.gwD = bmu.wPK;
                    if (bmu.wPK != 0) {
                        if (bmu.jBB == null || bmu.jBB.equals("")) {
                            obj = null;
                            arrayList.add(obj);
                            jVar = new j();
                            jVar.dtS = bmu.guN;
                            jVar.dub = bmu.guR;
                            jVar.duc = bmu.guO;
                            jVar.dud = bmu.guP;
                            jVar.signature = bmu.guQ;
                            jVar.username = bmu.jBB;
                            arrayList2.add(jVar);
                            hVar = new h();
                            hVar.dtR = 3;
                            hVar.cB(true);
                            hVar.username = bmu.jBB;
                            hVar.frW = bmu.vXm;
                            hVar.frV = bmu.vXn;
                            arrayList3.add(hVar);
                            i4 = i5 + 1;
                        } else {
                            ad aoO = ((j) g.K(j.class)).XM().aoO(bmu.jBB);
                            if (aoO != null && aoO.field_username.equals(bmu.jBB) && com.tencent.mm.n.a.jh(aoO.field_type)) {
                                aoVar2.gwD = 2;
                            } else {
                                aoVar2.gwD = 1;
                            }
                        }
                    }
                    aoVar2.username = bmu.jBB;
                    aoVar2.nickname = bmu.jCH;
                    aoVar2.gwK = bmu.wPL;
                    aoVar2.gwL = com.tencent.mm.platformtools.g.vp(bmu.wPL);
                    aoVar2.gwM = com.tencent.mm.platformtools.g.vo(bmu.wPL);
                    aoVar2.gwF = com.tencent.mm.platformtools.g.vp(bmu.jCH);
                    aoVar2.gwG = com.tencent.mm.platformtools.g.vo(bmu.jCH);
                    aoVar2.gwH = bmu.wPJ;
                    aoVar2.gwI = com.tencent.mm.platformtools.g.vp(bmu.wPJ);
                    aoVar2.gwJ = com.tencent.mm.platformtools.g.vo(bmu.wPJ);
                    i6 = 32;
                    if (!bo.isNullOrNil(aoVar2.aqs())) {
                        i6 = aoVar2.aqs().charAt(0);
                    } else if (!bo.isNullOrNil(aoVar2.aqt())) {
                        i6 = aoVar2.aqt().charAt(0);
                    } else if (!bo.isNullOrNil(aoVar2.aqp())) {
                        i6 = aoVar2.aqp().charAt(0);
                    } else if (!bo.isNullOrNil(aoVar2.aqq())) {
                        i6 = aoVar2.aqq().charAt(0);
                    }
                    if (i6 >= 97 && i6 <= 122) {
                        i6 = (char) (i6 - 32);
                    } else if (i6 < 65 || i6 > 90) {
                        i6 = 123;
                    }
                    aoVar2.frS = i6;
                    com.tencent.mm.plugin.c.a.ask().Yn().ia(bmu.jBB, bmu.wlF);
                    ab.v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + aoVar2.aqo() + "  remark: " + aoVar2.aqr());
                    ao obj2 = aoVar2;
                    arrayList.add(obj2);
                    jVar = new j();
                    jVar.dtS = bmu.guN;
                    jVar.dub = bmu.guR;
                    jVar.duc = bmu.guO;
                    jVar.dud = bmu.guP;
                    jVar.signature = bmu.guQ;
                    jVar.username = bmu.jBB;
                    arrayList2.add(jVar);
                    hVar = new h();
                    hVar.dtR = 3;
                    hVar.cB(true);
                    hVar.username = bmu.jBB;
                    hVar.frW = bmu.vXm;
                    hVar.frV = bmu.vXn;
                    arrayList3.add(hVar);
                    i4 = i5 + 1;
                }
                HashMap hashMap = new HashMap();
                ap apVar = (ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
                i4 = amw.wrw;
                ab.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(i4)));
                Cursor a = apVar.fni.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i4 + "\"", null, 0);
                while (a.moveToNext()) {
                    aoVar = new ao();
                    aoVar.d(a);
                    hashMap.put(Long.valueOf(aoVar.gwC), aoVar);
                }
                a.close();
                for (ao aoVar3 : arrayList) {
                    if (hashMap.containsKey(Long.valueOf(aoVar3.gwC))) {
                        Object obj3;
                        ao aoVar4 = (ao) hashMap.get(Long.valueOf(aoVar3.gwC));
                        if (!bo.B(Long.valueOf(aoVar4.gwC), Long.valueOf(aoVar3.gwC))) {
                            obj3 = null;
                        } else if (!bo.B(Integer.valueOf(aoVar4.gwD), Integer.valueOf(aoVar3.gwD))) {
                            obj3 = null;
                        } else if (!bo.B(Integer.valueOf(aoVar4.gwE), Integer.valueOf(aoVar3.gwE))) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.username, aoVar3.username)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.nickname, aoVar3.nickname)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.gwF, aoVar3.gwF)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.gwG, aoVar3.gwG)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.gwH, aoVar3.gwH)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.gwI, aoVar3.gwI)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.gwJ, aoVar3.gwJ)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.gwK, aoVar3.gwK)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.gwL, aoVar3.gwL)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.gwM, aoVar3.gwM)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.frQ, aoVar3.frQ)) {
                            obj3 = null;
                        } else if (!bo.B(aoVar4.frR, aoVar3.frR)) {
                            obj3 = null;
                        } else if (!bo.B(Integer.valueOf(aoVar4.frS), Integer.valueOf(aoVar3.frS))) {
                            obj3 = null;
                        } else if (bo.B(Integer.valueOf(aoVar4.frT), Integer.valueOf(aoVar3.frT))) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (obj3 == null) {
                            ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar3.gwC, aoVar3);
                            hashMap.remove(Long.valueOf(aoVar3.gwC));
                        }
                    } else {
                        ((ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg()).a(aoVar3);
                    }
                }
                for (Long longValue : hashMap.keySet()) {
                    long longValue2 = longValue.longValue();
                    apVar = (ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
                    ab.d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(longValue2)));
                    if (apVar.fni.delete("qqlist", "qq= ?", new String[]{String.valueOf(longValue2)}) > 0) {
                        apVar.b(5, apVar, String.valueOf(longValue2));
                    }
                }
                ((k) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).aa(arrayList2);
                o.act().aa(arrayList3);
                am amVar = new am();
                amVar.gwu = amw.wrw;
                amVar.gwz = 0;
                amVar.gwy = (int) bo.anT();
                amVar.bJt = 48;
                ((an) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(amVar);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(108452);
            return;
        }
        ab.e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108452);
    }

    private static void a(bmx bmx) {
        Map map;
        am amVar;
        an anVar;
        boolean z;
        AppMethodBeat.i(108453);
        Cursor a = ((an) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).fni.a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
        if (a == null) {
            map = null;
        } else if (a.getCount() <= 0) {
            a.close();
            map = null;
        } else {
            map = new HashMap();
            for (int i = 0; i < a.getCount(); i++) {
                a.moveToPosition(i);
                amVar = new am();
                amVar.d(a);
                map.put(Integer.valueOf(amVar.gwu), amVar);
            }
            a.close();
        }
        for (int i2 = 0; i2 < bmx.jBv; i2++) {
            bmw bmw = (bmw) bmx.wPO.get(i2);
            ab.d("MicroMsg.NetSceneGetQQGroup", "id:" + bmw.wrw + " name:" + bmw.wkk + " mem:" + bmw.wep + " wei:" + bmw.wPN + " md5:" + bmw.wdO);
            if (bmw.wrw < 0) {
                amVar = null;
            } else {
                amVar = new am();
                amVar.gwu = bmw.wrw;
                amVar.gwB = bmw.wkk;
                amVar.gwv = bmw.wep;
                amVar.gww = bmw.wPN;
                amVar.gwA = bmw.wdO;
            }
            if (amVar == null) {
                ab.e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:".concat(String.valueOf(i2)));
            } else if (amVar.gwv != 0) {
                am amVar2;
                if (map != null) {
                    amVar2 = (am) map.get(Integer.valueOf(amVar.gwu));
                } else {
                    amVar2 = null;
                }
                if (amVar2 == null) {
                    amVar.gwx = (int) bo.anT();
                    amVar.gwy = (int) bo.anT();
                    amVar.gwz = 1;
                    anVar = (an) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
                    if (amVar != null) {
                        ab.d("MicroMsg.QQGroupStorage", "insert: name:" + amVar.aqm());
                        amVar.bJt = -1;
                        if (((int) anVar.fni.insert("qqgroup", "grouopid", amVar.aqk())) >= 0) {
                            anVar.doNotify();
                            z = true;
                            ab.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + amVar.aqm() + " ret:" + z);
                        }
                    }
                    z = false;
                    ab.d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + amVar.aqm() + " ret:" + z);
                } else {
                    amVar2.gwz = -1;
                    ab.d("MicroMsg.NetSceneGetQQGroup", amVar.aql() + " " + amVar2.aql() + " " + amVar.gwu);
                    if (!amVar2.aql().equals(amVar.aql())) {
                        amVar.gwy = (int) bo.anT();
                        amVar.gwz = 1;
                        amVar.bJt = -1;
                        ab.d("MicroMsg.NetSceneGetQQGroup", "Update name:" + amVar.aqm() + " ret:" + ((an) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg()).a(amVar));
                    }
                }
            }
        }
        if (map != null) {
            for (Object obj : map.keySet()) {
                am amVar3 = (am) map.get(obj);
                if (amVar3.gwz == 0) {
                    anVar = (an) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
                    ab.d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(amVar3.gwu)));
                    if (anVar.fni.delete("qqgroup", "grouopid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        anVar.doNotify();
                        z = true;
                    } else {
                        z = false;
                    }
                    ab.d("MicroMsg.NetSceneGetQQGroup", "delete name:" + amVar3.aqm() + " ret:" + z);
                    ap apVar = (ap) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getQQListStg();
                    ab.d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(amVar3.gwu)));
                    if (apVar.fni.delete("qqlist", "groupid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ab.d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + amVar3.aqm() + " ret:" + z);
                }
            }
        }
        AppMethodBeat.o(108453);
    }
}
