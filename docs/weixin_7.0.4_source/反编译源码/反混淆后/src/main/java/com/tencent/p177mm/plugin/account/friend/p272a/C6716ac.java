package com.tencent.p177mm.plugin.account.friend.p272a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.protocal.protobuf.amw;
import com.tencent.p177mm.protocal.protobuf.amx;
import com.tencent.p177mm.protocal.protobuf.bmu;
import com.tencent.p177mm.protocal.protobuf.bmw;
import com.tencent.p177mm.protocal.protobuf.bmx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ac */
public final class C6716ac extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi = null;

    public C6716ac(int i) {
        AppMethodBeat.m2504i(108450);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new amw();
        c1196a.fsK = new amx();
        c1196a.uri = "/cgi-bin/micromsg-bin/getqqgroup";
        c1196a.fsI = ErrorCode.NEEDDOWNLOAD_4;
        c1196a.fsL = 38;
        c1196a.fsM = 1000000038;
        this.ehh = c1196a.acD();
        amw amw = (amw) this.ehh.fsG.fsP;
        amw.nbk = 1;
        amw.wrw = i;
        AppMethodBeat.m2505o(108450);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108451);
        this.ehi = c1202f;
        amw amw = (amw) this.ehh.fsG.fsP;
        if (amw.nbk == 1 && ((C26585an) ((C7599a) C1720g.m3530M(C7599a.class)).getQQGroupStg()).mo44366mY(amw.wrw) == null) {
            C4990ab.m7412e("MicroMsg.NetSceneGetQQGroup", "Err group not exist");
            AppMethodBeat.m2505o(108451);
            return -1;
        }
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108451);
        return a;
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_4;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108452);
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7410d("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
            amw amw = (amw) this.ehh.fsG.fsP;
            amx amx = (amx) this.ehh.fsH.fsP;
            if (amw.nbk == 0) {
                C6716ac.m11144a(amx.wrx);
            } else {
                C9878ao c9878ao;
                ArrayList<C9878ao> arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= amx.wry.jBv) {
                        break;
                    }
                    Object obj;
                    C9879j c9879j;
                    C17880h c17880h;
                    bmu bmu = (bmu) amx.wry.wPM.get(i5);
                    int i6 = amw.wrw;
                    C4990ab.m7418v("MicroMsg.NetSceneGetQQGroup", "friend");
                    C9878ao c9878ao2 = new C9878ao();
                    c9878ao2.gwC = new C1183p(bmu.wPI).longValue();
                    C41730b.m73494d(c9878ao2.gwC, 3);
                    c9878ao2.gwE = i6;
                    c9878ao2.gwD = bmu.wPK;
                    if (bmu.wPK != 0) {
                        if (bmu.jBB == null || bmu.jBB.equals("")) {
                            obj = null;
                            arrayList.add(obj);
                            c9879j = new C9879j();
                            c9879j.dtS = bmu.guN;
                            c9879j.dub = bmu.guR;
                            c9879j.duc = bmu.guO;
                            c9879j.dud = bmu.guP;
                            c9879j.signature = bmu.guQ;
                            c9879j.username = bmu.jBB;
                            arrayList2.add(c9879j);
                            c17880h = new C17880h();
                            c17880h.dtR = 3;
                            c17880h.mo33385cB(true);
                            c17880h.username = bmu.jBB;
                            c17880h.frW = bmu.vXm;
                            c17880h.frV = bmu.vXn;
                            arrayList3.add(c17880h);
                            i4 = i5 + 1;
                        } else {
                            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(bmu.jBB);
                            if (aoO != null && aoO.field_username.equals(bmu.jBB) && C7486a.m12942jh(aoO.field_type)) {
                                c9878ao2.gwD = 2;
                            } else {
                                c9878ao2.gwD = 1;
                            }
                        }
                    }
                    c9878ao2.username = bmu.jBB;
                    c9878ao2.nickname = bmu.jCH;
                    c9878ao2.gwK = bmu.wPL;
                    c9878ao2.gwL = C9790g.m17433vp(bmu.wPL);
                    c9878ao2.gwM = C9790g.m17432vo(bmu.wPL);
                    c9878ao2.gwF = C9790g.m17433vp(bmu.jCH);
                    c9878ao2.gwG = C9790g.m17432vo(bmu.jCH);
                    c9878ao2.gwH = bmu.wPJ;
                    c9878ao2.gwI = C9790g.m17433vp(bmu.wPJ);
                    c9878ao2.gwJ = C9790g.m17432vo(bmu.wPJ);
                    i6 = 32;
                    if (!C5046bo.isNullOrNil(c9878ao2.aqs())) {
                        i6 = c9878ao2.aqs().charAt(0);
                    } else if (!C5046bo.isNullOrNil(c9878ao2.aqt())) {
                        i6 = c9878ao2.aqt().charAt(0);
                    } else if (!C5046bo.isNullOrNil(c9878ao2.aqp())) {
                        i6 = c9878ao2.aqp().charAt(0);
                    } else if (!C5046bo.isNullOrNil(c9878ao2.aqq())) {
                        i6 = c9878ao2.aqq().charAt(0);
                    }
                    if (i6 >= 97 && i6 <= 122) {
                        i6 = (char) (i6 - 32);
                    } else if (i6 < 65 || i6 > 90) {
                        i6 = 123;
                    }
                    c9878ao2.frS = i6;
                    C20118a.ask().mo35364Yn().mo56747ia(bmu.jBB, bmu.wlF);
                    C4990ab.m7418v("MicroMsg.NetSceneGetQQGroup", "QQ Friend nickname: " + c9878ao2.aqo() + "  remark: " + c9878ao2.aqr());
                    C9878ao obj2 = c9878ao2;
                    arrayList.add(obj2);
                    c9879j = new C9879j();
                    c9879j.dtS = bmu.guN;
                    c9879j.dub = bmu.guR;
                    c9879j.duc = bmu.guO;
                    c9879j.dud = bmu.guP;
                    c9879j.signature = bmu.guQ;
                    c9879j.username = bmu.jBB;
                    arrayList2.add(c9879j);
                    c17880h = new C17880h();
                    c17880h.dtR = 3;
                    c17880h.mo33385cB(true);
                    c17880h.username = bmu.jBB;
                    c17880h.frW = bmu.vXm;
                    c17880h.frV = bmu.vXn;
                    arrayList3.add(c17880h);
                    i4 = i5 + 1;
                }
                HashMap hashMap = new HashMap();
                C45496ap c45496ap = (C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg();
                i4 = amw.wrw;
                C4990ab.m7410d("MicroMsg.QQListStorage", "getByGroupID: GroupID:".concat(String.valueOf(i4)));
                Cursor a = c45496ap.fni.mo10104a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i4 + "\"", null, 0);
                while (a.moveToNext()) {
                    c9878ao = new C9878ao();
                    c9878ao.mo21233d(a);
                    hashMap.put(Long.valueOf(c9878ao.gwC), c9878ao);
                }
                a.close();
                for (C9878ao c9878ao3 : arrayList) {
                    if (hashMap.containsKey(Long.valueOf(c9878ao3.gwC))) {
                        Object obj3;
                        C9878ao c9878ao4 = (C9878ao) hashMap.get(Long.valueOf(c9878ao3.gwC));
                        if (!C5046bo.m7499B(Long.valueOf(c9878ao4.gwC), Long.valueOf(c9878ao3.gwC))) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(Integer.valueOf(c9878ao4.gwD), Integer.valueOf(c9878ao3.gwD))) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(Integer.valueOf(c9878ao4.gwE), Integer.valueOf(c9878ao3.gwE))) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.username, c9878ao3.username)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.nickname, c9878ao3.nickname)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.gwF, c9878ao3.gwF)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.gwG, c9878ao3.gwG)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.gwH, c9878ao3.gwH)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.gwI, c9878ao3.gwI)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.gwJ, c9878ao3.gwJ)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.gwK, c9878ao3.gwK)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.gwL, c9878ao3.gwL)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.gwM, c9878ao3.gwM)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.frQ, c9878ao3.frQ)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(c9878ao4.frR, c9878ao3.frR)) {
                            obj3 = null;
                        } else if (!C5046bo.m7499B(Integer.valueOf(c9878ao4.frS), Integer.valueOf(c9878ao3.frS))) {
                            obj3 = null;
                        } else if (C5046bo.m7499B(Integer.valueOf(c9878ao4.frT), Integer.valueOf(c9878ao3.frT))) {
                            obj3 = 1;
                        } else {
                            obj3 = null;
                        }
                        if (obj3 == null) {
                            ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73281a(c9878ao3.gwC, c9878ao3);
                            hashMap.remove(Long.valueOf(c9878ao3.gwC));
                        }
                    } else {
                        ((C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg()).mo73282a(c9878ao3);
                    }
                }
                for (Long longValue : hashMap.keySet()) {
                    long longValue2 = longValue.longValue();
                    c45496ap = (C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg();
                    C4990ab.m7410d("MicroMsg.QQListStorage", "delete: QQ:".concat(String.valueOf(longValue2)));
                    if (c45496ap.fni.delete("qqlist", "qq= ?", new String[]{String.valueOf(longValue2)}) > 0) {
                        c45496ap.mo10120b(5, c45496ap, String.valueOf(longValue2));
                    }
                }
                ((C26586k) ((C7599a) C1720g.m3530M(C7599a.class)).getFrdExtStg()).mo44368aa(arrayList2);
                C17884o.act().mo33390aa(arrayList3);
                C26584am c26584am = new C26584am();
                c26584am.gwu = amw.wrw;
                c26584am.gwz = 0;
                c26584am.gwy = (int) C5046bo.anT();
                c26584am.bJt = 48;
                ((C26585an) ((C7599a) C1720g.m3530M(C7599a.class)).getQQGroupStg()).mo44365a(c26584am);
            }
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(108452);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneGetQQGroup", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108452);
    }

    /* renamed from: a */
    private static void m11144a(bmx bmx) {
        Map map;
        C26584am c26584am;
        C26585an c26585an;
        boolean z;
        AppMethodBeat.m2504i(108453);
        Cursor a = ((C26585an) ((C7599a) C1720g.m3530M(C7599a.class)).getQQGroupStg()).fni.mo10104a("select qqgroup.grouopid,qqgroup.membernum,qqgroup.weixinnum,qqgroup.insert_time,qqgroup.lastupdate_time,qqgroup.needupdate,qqgroup.updatekey,qqgroup.groupname from qqgroup ", null, 0);
        if (a == null) {
            map = null;
        } else if (a.getCount() <= 0) {
            a.close();
            map = null;
        } else {
            map = new HashMap();
            for (int i = 0; i < a.getCount(); i++) {
                a.moveToPosition(i);
                c26584am = new C26584am();
                c26584am.mo44364d(a);
                map.put(Integer.valueOf(c26584am.gwu), c26584am);
            }
            a.close();
        }
        for (int i2 = 0; i2 < bmx.jBv; i2++) {
            bmw bmw = (bmw) bmx.wPO.get(i2);
            C4990ab.m7410d("MicroMsg.NetSceneGetQQGroup", "id:" + bmw.wrw + " name:" + bmw.wkk + " mem:" + bmw.wep + " wei:" + bmw.wPN + " md5:" + bmw.wdO);
            if (bmw.wrw < 0) {
                c26584am = null;
            } else {
                c26584am = new C26584am();
                c26584am.gwu = bmw.wrw;
                c26584am.gwB = bmw.wkk;
                c26584am.gwv = bmw.wep;
                c26584am.gww = bmw.wPN;
                c26584am.gwA = bmw.wdO;
            }
            if (c26584am == null) {
                C4990ab.m7412e("MicroMsg.NetSceneGetQQGroup", "Error Resp Group Info index:".concat(String.valueOf(i2)));
            } else if (c26584am.gwv != 0) {
                C26584am c26584am2;
                if (map != null) {
                    c26584am2 = (C26584am) map.get(Integer.valueOf(c26584am.gwu));
                } else {
                    c26584am2 = null;
                }
                if (c26584am2 == null) {
                    c26584am.gwx = (int) C5046bo.anT();
                    c26584am.gwy = (int) C5046bo.anT();
                    c26584am.gwz = 1;
                    c26585an = (C26585an) ((C7599a) C1720g.m3530M(C7599a.class)).getQQGroupStg();
                    if (c26584am != null) {
                        C4990ab.m7410d("MicroMsg.QQGroupStorage", "insert: name:" + c26584am.aqm());
                        c26584am.bJt = -1;
                        if (((int) c26585an.fni.insert("qqgroup", "grouopid", c26584am.aqk())) >= 0) {
                            c26585an.doNotify();
                            z = true;
                            C4990ab.m7410d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + c26584am.aqm() + " ret:" + z);
                        }
                    }
                    z = false;
                    C4990ab.m7410d("MicroMsg.NetSceneGetQQGroup", "Insert name:" + c26584am.aqm() + " ret:" + z);
                } else {
                    c26584am2.gwz = -1;
                    C4990ab.m7410d("MicroMsg.NetSceneGetQQGroup", c26584am.aql() + " " + c26584am2.aql() + " " + c26584am.gwu);
                    if (!c26584am2.aql().equals(c26584am.aql())) {
                        c26584am.gwy = (int) C5046bo.anT();
                        c26584am.gwz = 1;
                        c26584am.bJt = -1;
                        C4990ab.m7410d("MicroMsg.NetSceneGetQQGroup", "Update name:" + c26584am.aqm() + " ret:" + ((C26585an) ((C7599a) C1720g.m3530M(C7599a.class)).getQQGroupStg()).mo44365a(c26584am));
                    }
                }
            }
        }
        if (map != null) {
            for (Object obj : map.keySet()) {
                C26584am c26584am3 = (C26584am) map.get(obj);
                if (c26584am3.gwz == 0) {
                    c26585an = (C26585an) ((C7599a) C1720g.m3530M(C7599a.class)).getQQGroupStg();
                    C4990ab.m7410d("MicroMsg.QQGroupStorage", "delete: id:".concat(String.valueOf(c26584am3.gwu)));
                    if (c26585an.fni.delete("qqgroup", "grouopid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        c26585an.doNotify();
                        z = true;
                    } else {
                        z = false;
                    }
                    C4990ab.m7410d("MicroMsg.NetSceneGetQQGroup", "delete name:" + c26584am3.aqm() + " ret:" + z);
                    C45496ap c45496ap = (C45496ap) ((C7599a) C1720g.m3530M(C7599a.class)).getQQListStg();
                    C4990ab.m7410d("MicroMsg.QQListStorage", "delete: GroupID:".concat(String.valueOf(c26584am3.gwu)));
                    if (c45496ap.fni.delete("qqlist", "groupid= ?", new String[]{String.valueOf(r6)}) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    C4990ab.m7410d("MicroMsg.NetSceneGetQQGroup", "delete QQList name:" + c26584am3.aqm() + " ret:" + z);
                }
            }
        }
        AppMethodBeat.m2505o(108453);
    }
}
