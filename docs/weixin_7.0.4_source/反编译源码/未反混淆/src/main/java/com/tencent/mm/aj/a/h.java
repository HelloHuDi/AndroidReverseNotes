package com.tencent.mm.aj.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.acr;
import com.tencent.mm.protocal.protobuf.afm;
import com.tencent.mm.protocal.protobuf.afn;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.aiv;
import com.tencent.mm.protocal.protobuf.aiw;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.protocal.protobuf.lj;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h implements f {
    private HashSet<a> fxP = new HashSet();
    private HashSet<a> fxQ = new HashSet();
    private final Object fxR = new Object();
    private com.tencent.mm.a.f<String, Long> fxS = new com.tencent.mm.a.h(64);
    private HashSet<a> fxT = new HashSet();
    private HashSet<a> fxU = new HashSet();
    private final Object fxV = new Object();
    private com.tencent.mm.a.f<String, Long> fxW = new com.tencent.mm.a.h(64);

    public static class a {
        private String cGT;
        private String id;

        public a(String str, String str2) {
            this.cGT = str;
            this.id = str2;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(11567);
            if (obj.getClass() != a.class) {
                AppMethodBeat.o(11567);
                return false;
            }
            a aVar = (a) obj;
            if ((!(this.cGT == null && aVar.cGT == null) && (this.cGT == null || !this.cGT.equals(aVar.cGT))) || (!(this.id == null && aVar.id == null) && (this.id == null || !this.id.equals(aVar.id)))) {
                AppMethodBeat.o(11567);
                return false;
            }
            AppMethodBeat.o(11567);
            return true;
        }

        public int hashCode() {
            AppMethodBeat.i(11568);
            int hashCode = this.cGT.hashCode() + this.id.hashCode();
            AppMethodBeat.o(11568);
            return hashCode;
        }
    }

    public h() {
        AppMethodBeat.i(11569);
        g.RO().eJo.a(1352, (f) this);
        g.RO().eJo.a(1365, (f) this);
        g.RO().eJo.a(1353, (f) this);
        g.RO().eJo.a(1354, (f) this);
        g.RO().eJo.a(1357, (f) this);
        g.RO().eJo.a(1356, (f) this);
        g.RO().eJo.a(1355, (f) this);
        g.RO().eJo.a(1358, (f) this);
        g.RO().eJo.a(1367, (f) this);
        g.RO().eJo.a(1361, (f) this);
        g.RO().eJo.a(1389, (f) this);
        g.RO().eJo.a(1315, (f) this);
        AppMethodBeat.o(11569);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(11570);
        g.RO().eJo.b(1352, (f) this);
        g.RO().eJo.b(1365, (f) this);
        g.RO().eJo.b(1353, (f) this);
        g.RO().eJo.b(1354, (f) this);
        g.RO().eJo.b(1357, (f) this);
        g.RO().eJo.b(1356, (f) this);
        g.RO().eJo.b(1355, (f) this);
        g.RO().eJo.b(1358, (f) this);
        g.RO().eJo.b(1367, (f) this);
        g.RO().eJo.b(1361, (f) this);
        g.RO().eJo.b(1389, (f) this);
        g.RO().eJo.b(1315, (f) this);
        super.finalize();
        AppMethodBeat.o(11570);
    }

    /* JADX WARNING: Removed duplicated region for block: B:278:0x05c0  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0534  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(11571);
        if (!(i == 0 && i2 == 0)) {
            ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
            if (!(mVar.getType() == 1365 || mVar.getType() == 1353)) {
                AppMethodBeat.o(11571);
                return;
            }
        }
        int i3;
        boolean a;
        int i4;
        n nVar;
        String str2;
        String str3;
        switch (mVar.getType()) {
            case 1315:
                mVar = (m) mVar;
                uh afl = mVar.afl();
                i3 = 0;
                if (afl == null || afl.vNh == null || afl.vNh.ret != 0) {
                    if (afl == null || afl.vNh == null) {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afl.vNh.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && afl.wbT == null && afl.wbS == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (afl.wbT != null) {
                        a = a(afl.wbT, afl.vNb);
                        if (a) {
                            mVar.fye = afl.wbT.vNc;
                        }
                    } else {
                        a = a(afl.wbS, afl.vNb, true);
                        if (a) {
                            mVar.fye = afl.wbS.wku.vMV;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        nVar = (n) mVar.data;
                        if (nVar != null) {
                            nVar.a(i4, mVar);
                        }
                        AppMethodBeat.o(11571);
                        return;
                    }
                }
                i4 = i3;
                nVar = (n) mVar.data;
                if (nVar != null) {
                }
                AppMethodBeat.o(11571);
                return;
            case 1352:
                afo afo;
                afn afn;
                o oVar = (o) mVar;
                if (oVar.ehh == null || oVar.ehh.fsH.fsP == null) {
                    afo = null;
                } else {
                    afo = (afo) oVar.ehh.fsH.fsP;
                }
                if (oVar.ehh == null || oVar.ehh.fsG.fsP == null) {
                    afn = null;
                } else {
                    afn = (afn) oVar.ehh.fsG.fsP;
                }
                boolean z = oVar.fyf;
                if (afo != null && afo.vNh != null && afo.vNh.ret == 0) {
                    a(afo.wcb, afn.vNb, z);
                    AppMethodBeat.o(11571);
                    return;
                } else if (afo == null || afo.vNh == null) {
                    ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(11571);
                    return;
                } else {
                    ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afo.vNh.ret));
                    AppMethodBeat.o(11571);
                    return;
                }
            case 1353:
                mVar = (r) mVar;
                nVar = (n) mVar.data;
                if (nVar == null) {
                    synchronized (this.fxV) {
                        try {
                            this.fxU.clear();
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(11571);
                                break;
                            }
                        }
                    }
                    afk();
                }
                if (i == 0 && i2 == 0) {
                    afs afs;
                    int i5;
                    if (mVar.ehh == null || mVar.ehh.fsH.fsP == null) {
                        afs = null;
                    } else {
                        afs = (afs) mVar.ehh.fsH.fsP;
                    }
                    i4 = 0;
                    if (afs == null || afs.vNh == null || afs.vNh.ret != 0) {
                        if (afs == null || afs.vNh == null) {
                            ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afs.vNh.ret));
                        }
                        i4 = -1;
                    }
                    if (i4 < 0 || afs.vNi != null) {
                        i5 = i4;
                    } else {
                        ab.w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
                        i5 = -1;
                    }
                    if (i5 >= 0) {
                        e eVar = z.aeV().bSd;
                        long j = 0;
                        if (eVar instanceof com.tencent.mm.cd.h) {
                            j = ((com.tencent.mm.cd.h) eVar).iV(Thread.currentThread().getId());
                        }
                        i4 = 0;
                        while (true) {
                            int i6 = i4;
                            if (i6 < afs.vNi.size()) {
                                ab.d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", ((kk) afs.vNi.get(i6)).kfT);
                                j jVar = new j();
                                jVar.field_userId = ((kk) afs.vNi.get(i6)).vNc;
                                jVar.field_userName = ((kk) afs.vNi.get(i6)).kfT;
                                str2 = jVar.field_userId;
                                if (str2 == null || mVar.fyh == null) {
                                    str2 = null;
                                } else {
                                    str2 = (String) mVar.fyh.get(str2);
                                }
                                jVar.field_brandUserName = str2;
                                jVar.field_UserVersion = ((kk) afs.vNi.get(i6)).ver;
                                jVar.field_headImageUrl = ((kk) afs.vNi.get(i6)).vMW;
                                jVar.field_profileUrl = ((kk) afs.vNi.get(i6)).vNk;
                                jVar.field_bitFlag = ((kk) afs.vNi.get(i6)).vMX;
                                jVar.field_addMemberUrl = ((kk) afs.vNi.get(i6)).vNa;
                                jVar.field_needToUpdate = false;
                                j cH = z.aeV().cH(((kk) afs.vNi.get(i6)).vNc);
                                a = cH == null ? false : cH.lc(16);
                                boolean lc = jVar.lc(16);
                                if (cH == null) {
                                    z.aeV().a(jVar);
                                } else {
                                    z.aeV().b(jVar);
                                }
                                if (a != lc) {
                                    c rq = z.aeT().rq(jVar.field_userId);
                                    if (rq != null) {
                                        if (a && !lc) {
                                            z.aeU().fA(rq.field_bizChatLocalId);
                                        } else if (!a && lc) {
                                            z.aeU().fz(rq.field_bizChatLocalId);
                                        }
                                    }
                                }
                                i4 = i6 + 1;
                            } else if (eVar instanceof com.tencent.mm.cd.h) {
                                g.RP().eJN.mB(j);
                            }
                        }
                    }
                    if (nVar != null) {
                        nVar.a(i5, mVar);
                    }
                    AppMethodBeat.o(11571);
                    return;
                }
                AppMethodBeat.o(11571);
                return;
            case 1354:
                afq afq;
                afp afp;
                int i7;
                mVar = (q) mVar;
                if (mVar.ehh == null || mVar.ehh.fsH.fsP == null) {
                    afq = null;
                } else {
                    afq = (afq) mVar.ehh.fsH.fsP;
                }
                if (mVar.ehh == null) {
                    afp = null;
                } else {
                    afp = (afp) mVar.ehh.fsG.fsP;
                }
                if (afq == null || afq.vNh == null || afq.vNh.ret != 0) {
                    if (afq == null || afq.vNh == null) {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afq.vNh.ret));
                    }
                    i7 = -1;
                } else {
                    i7 = 0;
                }
                if (i7 >= 0) {
                    k aeV = z.aeV();
                    String str4 = afp.vNb;
                    kk kkVar = afq.vNe;
                    if (kkVar == null || bo.isNullOrNil(str4)) {
                        ab.w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
                    } else {
                        ab.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", str4, kkVar.vNc, Boolean.valueOf(bo.isNullOrNil(kkVar.vNa)));
                        f rA = z.aeW().rA(str4);
                        if (rA == null) {
                            rA = new f();
                            rA.field_brandUserName = str4;
                            rA.field_userId = kkVar.vNc;
                            z.aeW().a(rA);
                        } else {
                            rA.field_userId = kkVar.vNc;
                            z.aeW().b(rA);
                            ab.i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
                        }
                        j jVar2 = new j();
                        jVar2.field_userId = kkVar.vNc;
                        jVar2.field_userName = kkVar.kfT;
                        jVar2.field_brandUserName = str4;
                        jVar2.field_UserVersion = kkVar.ver;
                        jVar2.field_headImageUrl = kkVar.vMW;
                        jVar2.field_profileUrl = kkVar.vNk;
                        jVar2.field_bitFlag = kkVar.vMX;
                        jVar2.field_needToUpdate = false;
                        jVar2.field_addMemberUrl = kkVar.vNa;
                        if (!aeV.b(jVar2)) {
                            aeV.a(jVar2);
                        }
                        aeV.fxs.put(str4, jVar2.field_userId);
                    }
                }
                nVar = (n) mVar.data;
                if (nVar != null) {
                    nVar.a(i7, mVar);
                }
                AppMethodBeat.o(11571);
                return;
            case 1355:
                mVar = (n) mVar;
                uo afm = mVar.afm();
                un afn2 = mVar.afn();
                i3 = 0;
                if (afm == null || afm.vNh == null || afm.vNh.ret != 0) {
                    if (afm == null || afm.vNh == null) {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afm.vNh.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (a(afm.wcb, afn2.vNb, true)) {
                        i3 = 0;
                    } else {
                        i3 = -1;
                    }
                    i4 = i3;
                } else {
                    i4 = i3;
                }
                nVar = (n) mVar.data;
                if (nVar != null) {
                    nVar.a(i4, mVar);
                }
                AppMethodBeat.o(11571);
                return;
            case 1356:
                cjo cjo;
                cjn cjn;
                mVar = (w) mVar;
                if (mVar.ehh == null || mVar.ehh.fsH.fsP == null) {
                    cjo = null;
                } else {
                    cjo = (cjo) mVar.ehh.fsH.fsP;
                }
                if (mVar.ehh == null || mVar.ehh.fsG.fsP == null) {
                    cjn = null;
                } else {
                    cjn = (cjn) mVar.ehh.fsG.fsP;
                }
                i3 = 0;
                if (cjo == null || cjo.vNh == null || cjo.vNh.ret != 0 || cjo.wku == null) {
                    if (cjo == null || cjo.vNh == null) {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(cjo.vNh.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    c rq2 = z.aeT().rq(cjo.wku.vMV);
                    if (rq2 == null) {
                        boolean z2;
                        str3 = "MicroMsg.BizChatNetworkMgr";
                        String str5 = "bizChatInfo == null:%s, resp.chat == null:%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(rq2 == null);
                        if (cjo.wku == null) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objArr[1] = Boolean.valueOf(z2);
                        ab.w(str3, str5, objArr);
                        i3 = -1;
                    }
                    if (i3 < 0 || ((rq2.field_bitFlag == cjo.wku.vMX || !rq2.afh()) && cjo.wku.ver <= rq2.field_chatVersion)) {
                        i4 = -1;
                    } else {
                        rq2.field_chatType = cjo.wku.type;
                        rq2.field_headImageUrl = cjo.wku.vMW;
                        rq2.field_chatName = cjo.wku.name;
                        rq2.field_chatVersion = cjo.wku.ver;
                        rq2.field_needToUpdate = false;
                        rq2.field_bitFlag = cjo.wku.vMX;
                        rq2.field_maxMemberCnt = cjo.wku.vMY;
                        rq2.field_ownerUserId = cjo.wku.vMZ;
                        rq2.field_addMemberUrl = cjo.wku.vNa;
                        rq2.field_brandUserName = cjn.vNb;
                        z.aeT().b(rq2);
                        i4 = i3;
                    }
                } else {
                    i4 = i3;
                }
                nVar = (n) mVar.data;
                if (nVar != null) {
                    nVar.a(i4, mVar);
                }
                AppMethodBeat.o(11571);
                return;
            case 1357:
                cjm cjm;
                cjl cjl;
                ab.d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
                mVar = (x) mVar;
                if (mVar.ehh == null || mVar.ehh.fsH.fsP == null) {
                    cjm = null;
                } else {
                    cjm = (cjm) mVar.ehh.fsH.fsP;
                }
                if (mVar.ehh == null || mVar.ehh.fsG.fsP == null) {
                    cjl = null;
                } else {
                    cjl = (cjl) mVar.ehh.fsG.fsP;
                }
                if (cjm != null && cjm.vNh != null && cjm.vNh.ret == 0) {
                    if (a(cjm.wcb, cjl.vNb, false)) {
                        i4 = 0;
                    } else {
                        i4 = -1;
                    }
                    nVar = (n) mVar.data;
                    if (nVar != null) {
                        nVar.a(i4, mVar);
                    }
                    AppMethodBeat.o(11571);
                    return;
                } else if (cjm == null || cjm.vNh == null) {
                    ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(11571);
                    return;
                } else {
                    ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(cjm.vNh.ret));
                    AppMethodBeat.o(11571);
                    return;
                }
            case 1358:
                AppMethodBeat.o(11571);
                return;
            case 1365:
                synchronized (this.fxR) {
                    try {
                        this.fxQ.clear();
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(11571);
                            break;
                        }
                    }
                }
                afj();
                if (i == 0 && i2 == 0) {
                    afm afm2;
                    p pVar = (p) mVar;
                    if (pVar.ehh == null || pVar.ehh.fsH.fsP == null) {
                        afm2 = null;
                    } else {
                        afm2 = (afm) pVar.ehh.fsH.fsP;
                    }
                    if (afm2 != null && afm2.vNh != null && afm2.vNh.ret == 0) {
                        LinkedList linkedList = afm2.wmT;
                        if (linkedList == null || linkedList.size() == 0) {
                            ab.w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
                            AppMethodBeat.o(11571);
                            return;
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            acr acr = (acr) it.next();
                            str2 = acr.wku.vMV;
                            if (str2 == null || pVar.fyg == null) {
                                str2 = null;
                            } else {
                                str2 = (String) pVar.fyg.get(str2);
                            }
                            a(acr, str2, false);
                        }
                        AppMethodBeat.o(11571);
                        return;
                    } else if (afm2 == null || afm2.vNh == null) {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        AppMethodBeat.o(11571);
                        return;
                    } else {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afm2.vNh.ret));
                        AppMethodBeat.o(11571);
                        return;
                    }
                }
                AppMethodBeat.o(11571);
                return;
            case 1367:
                aiw aiw;
                aiv aiv;
                s sVar = (s) mVar;
                if (sVar.ehh == null || sVar.ehh.fsH.fsP == null) {
                    aiw = null;
                } else {
                    aiw = (aiw) sVar.ehh.fsH.fsP;
                }
                if (sVar.ehh == null || sVar.ehh.fsG.fsP == null) {
                    aiv = null;
                } else {
                    aiv = (aiv) sVar.ehh.fsG.fsP;
                }
                if (aiw != null && aiw.vNh != null && aiw.vNh.ret == 0) {
                    LinkedList<String> linkedList2 = aiw.woQ;
                    d aeT = z.aeT();
                    str3 = aiv.vNb;
                    ArrayList<String> arrayList = new ArrayList();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select bizChatServId from BizChatInfo");
                    stringBuilder.append(" where brandUserName = '").append(str3).append("'");
                    stringBuilder.append(" and (bitFlag & 8) != 0 ");
                    Cursor rawQuery = aeT.rawQuery(stringBuilder.toString(), new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            do {
                                arrayList.add(rawQuery.getString(0));
                            } while (rawQuery.moveToNext());
                        }
                        rawQuery.close();
                    }
                    for (String str6 : arrayList) {
                        if (!linkedList2.contains(str6)) {
                            c rq3 = z.aeT().rq(str6);
                            if (rq3 != null) {
                                rq3.field_bitFlag &= -9;
                                z.aeT().b(rq3);
                            }
                        }
                    }
                    for (String str62 : linkedList2) {
                        if (!arrayList.contains(str62)) {
                            c rq4 = z.aeT().rq(str62);
                            if (rq4 == null) {
                                rq4 = new c();
                                rq4.field_bizChatServId = str62;
                                rq4.field_brandUserName = aiv.vNb;
                                rq4.field_bitFlag |= 8;
                                z.aeT().a(rq4);
                            } else {
                                rq4.field_bitFlag |= 8;
                                z.aeT().b(rq4);
                            }
                        }
                    }
                    a(aiw.woQ, aiv.vNb);
                    break;
                } else if (aiw == null || aiw.vNh == null) {
                    ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.o(11571);
                    return;
                } else {
                    ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(aiw.vNh.ret));
                    AppMethodBeat.o(11571);
                    return;
                }
                break;
            case 1389:
                mVar = (t) mVar;
                auq afo2 = mVar.afo();
                i3 = 0;
                if (afo2 == null || afo2.vNh == null || afo2.vNh.ret != 0) {
                    if (afo2 == null || afo2.vNh == null) {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        ab.w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afo2.vNh.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && afo2.wbT == null && afo2.wbS == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (afo2.wbT != null) {
                        a = a(afo2.wbT, afo2.vNb);
                        if (a) {
                            mVar.fye = afo2.wbT.vNc;
                        }
                    } else {
                        a = a(afo2.wbS, afo2.vNb, true);
                        if (a) {
                            mVar.fye = afo2.wbS.wku.vMV;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        nVar = (n) mVar.data;
                        if (nVar != null) {
                            nVar.a(i4, mVar);
                        }
                        AppMethodBeat.o(11571);
                        return;
                    }
                }
                i4 = i3;
                nVar = (n) mVar.data;
                if (nVar != null) {
                }
                AppMethodBeat.o(11571);
                return;
        }
        AppMethodBeat.o(11571);
    }

    public static void f(m mVar) {
        AppMethodBeat.i(11572);
        g.RO().eJo.c(mVar);
        AppMethodBeat.o(11572);
    }

    public final void aD(String str, String str2) {
        AppMethodBeat.i(11573);
        Long l = (Long) this.fxS.ai(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            aE(str, str2);
        }
        AppMethodBeat.o(11573);
    }

    private void aE(String str, String str2) {
        AppMethodBeat.i(11574);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.fxR) {
            try {
                a aVar = new a(str2, str);
                if (this.fxQ.contains(aVar)) {
                } else {
                    this.fxP.add(aVar);
                    this.fxS.put(str, new Long(currentTimeMillis));
                    afj();
                    AppMethodBeat.o(11574);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(11574);
            }
        }
    }

    public final void a(LinkedList<String> linkedList, String str) {
        AppMethodBeat.i(11575);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.fxR) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    a aVar = new a(str, str2);
                    if (!this.fxQ.contains(aVar)) {
                        this.fxP.add(aVar);
                        this.fxS.put(str2, new Long(currentTimeMillis));
                    }
                }
                afj();
            } finally {
                AppMethodBeat.o(11575);
            }
        }
    }

    private void afj() {
        AppMethodBeat.i(11576);
        LinkedList linkedList = new LinkedList();
        synchronized (this.fxR) {
            try {
                if (!this.fxQ.isEmpty()) {
                } else if (this.fxP.isEmpty()) {
                    AppMethodBeat.o(11576);
                } else {
                    Iterator it = this.fxP.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        ke keVar = new ke();
                        keVar.vNb = aVar.cGT;
                        keVar.vMV = aVar.id;
                        linkedList.add(keVar);
                    }
                    if (linkedList.isEmpty()) {
                        AppMethodBeat.o(11576);
                        return;
                    }
                    this.fxQ.addAll(this.fxP);
                    this.fxP.clear();
                    g.RO().eJo.a(new p(linkedList), 0);
                    AppMethodBeat.o(11576);
                }
            } finally {
                AppMethodBeat.o(11576);
            }
        }
    }

    public final void aF(String str, String str2) {
        AppMethodBeat.i(11577);
        Long l = (Long) this.fxW.ai(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            aG(str, str2);
        }
        AppMethodBeat.o(11577);
    }

    public final void aG(String str, String str2) {
        AppMethodBeat.i(11578);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.fxV) {
            try {
                a aVar = new a(str2, str);
                if (this.fxU.contains(aVar)) {
                } else {
                    this.fxT.add(aVar);
                    this.fxW.put(str, new Long(currentTimeMillis));
                    afk();
                    AppMethodBeat.o(11578);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(11578);
            }
        }
    }

    public final void b(LinkedList<String> linkedList, String str) {
        AppMethodBeat.i(11579);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.fxV) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    a aVar = new a(str, str2);
                    if (!this.fxU.contains(aVar)) {
                        this.fxT.add(aVar);
                        this.fxW.put(str2, new Long(currentTimeMillis));
                    }
                }
                afk();
                AppMethodBeat.o(11579);
            } finally {
                AppMethodBeat.o(11579);
            }
        }
    }

    private void afk() {
        AppMethodBeat.i(11580);
        LinkedList linkedList = new LinkedList();
        synchronized (this.fxV) {
            try {
                if (!this.fxU.isEmpty()) {
                } else if (this.fxT.isEmpty()) {
                    AppMethodBeat.o(11580);
                } else {
                    LinkedList linkedList2;
                    HashMap hashMap = new HashMap();
                    Iterator it = this.fxT.iterator();
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        linkedList2 = (LinkedList) hashMap.get(aVar.cGT);
                        if (linkedList2 == null) {
                            linkedList2 = new LinkedList();
                            hashMap.put(aVar.cGT, linkedList2);
                        }
                        linkedList2.add(aVar.id);
                    }
                    for (String str : hashMap.keySet()) {
                        linkedList2 = (LinkedList) hashMap.get(str);
                        if (!(linkedList2 == null || linkedList2.isEmpty())) {
                            lj ljVar = new lj();
                            ljVar.vNb = str;
                            ljVar.vOW = linkedList2;
                            linkedList.add(ljVar);
                        }
                    }
                    this.fxU.addAll(this.fxT);
                    this.fxT.clear();
                    g.RO().eJo.a(new r(linkedList, null), 0);
                    AppMethodBeat.o(11580);
                }
            } finally {
                AppMethodBeat.o(11580);
            }
        }
    }

    public static void aH(String str, String str2) {
        AppMethodBeat.i(11581);
        g.RO().eJo.a(new o(str, str2), 0);
        AppMethodBeat.o(11581);
    }

    public static void a(String str, String str2, n nVar) {
        AppMethodBeat.i(11582);
        if (nVar == null) {
            AppMethodBeat.o(11582);
            return;
        }
        j rv = e.rv(str2);
        if (rv == null || rv.field_userId.equals(str)) {
            a(str2, nVar);
            AppMethodBeat.o(11582);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        lj ljVar = new lj();
        ljVar.vNb = str2;
        ljVar.vOW = linkedList;
        linkedList = new LinkedList();
        linkedList.add(ljVar);
        g.RO().eJo.a(new r(linkedList, nVar), 0);
        AppMethodBeat.o(11582);
    }

    public static void a(String str, n nVar) {
        AppMethodBeat.i(11583);
        g.RO().eJo.a(new q(str, nVar), 0);
        AppMethodBeat.o(11583);
    }

    public static n a(String str, acr acr, n nVar) {
        AppMethodBeat.i(11584);
        m nVar2 = new n(str, acr, nVar);
        g.RO().eJo.a(nVar2, 0);
        AppMethodBeat.o(11584);
        return nVar2;
    }

    public static x a(String str, String str2, kg kgVar, kg kgVar2, n nVar) {
        AppMethodBeat.i(11585);
        m xVar = new x(str, str2, kgVar, kgVar2, nVar);
        g.RO().eJo.a(xVar, 0);
        AppMethodBeat.o(11585);
        return xVar;
    }

    public static w a(String str, kd kdVar, n nVar) {
        AppMethodBeat.i(11586);
        m wVar = new w(str, kdVar, nVar);
        g.RO().eJo.a(wVar, 0);
        AppMethodBeat.o(11586);
        return wVar;
    }

    public static void e(String str, String str2, int i) {
        AppMethodBeat.i(11587);
        g.RO().eJo.a(new v(str, str2, i), 0);
        AppMethodBeat.o(11587);
    }

    private static boolean a(kk kkVar, String str) {
        AppMethodBeat.i(11588);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(kkVar.vNc)) {
            AppMethodBeat.o(11588);
            return false;
        }
        j jVar = new j();
        jVar.field_userId = kkVar.vNc;
        jVar.field_userName = kkVar.kfT;
        jVar.field_brandUserName = str;
        jVar.field_headImageUrl = kkVar.vMW;
        jVar.field_profileUrl = kkVar.vNk;
        jVar.field_UserVersion = kkVar.ver;
        jVar.field_addMemberUrl = kkVar.vNa;
        if (!z.aeV().b(jVar)) {
            z.aeV().a(jVar);
        }
        c cVar = new c();
        cVar.field_bizChatServId = jVar.field_userId;
        cVar.field_brandUserName = jVar.field_brandUserName;
        cVar.field_chatName = jVar.field_userName;
        cVar.field_chatType = 1;
        if (e.e(cVar) == null) {
            AppMethodBeat.o(11588);
            return false;
        }
        AppMethodBeat.o(11588);
        return true;
    }

    private static boolean a(acr acr, String str, boolean z) {
        AppMethodBeat.i(11589);
        ab.d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
        if (acr == null || acr.wku == null || bo.isNullOrNil(str)) {
            ab.w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
            AppMethodBeat.o(11589);
            return false;
        }
        boolean z2;
        c cVar;
        c rq = z.aeT().rq(acr.wku.vMV);
        if (rq == null) {
            ab.w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
            rq = new c();
            rq.field_bizChatServId = acr.wku.vMV;
            rq.field_brandUserName = str;
            z2 = true;
            cVar = rq;
            z = true;
        } else {
            z2 = false;
            cVar = rq;
        }
        if (acr.vNd == null) {
            ab.w("MicroMsg.BizChatNetworkMgr", "members==null");
            AppMethodBeat.o(11589);
            return false;
        }
        if (cVar.afh() || acr.wku.ver > cVar.field_chatVersion) {
            cVar.field_chatType = acr.wku.type;
            cVar.field_headImageUrl = acr.wku.vMW;
            cVar.field_chatName = acr.wku.name;
            cVar.field_chatVersion = acr.wku.ver;
            cVar.field_needToUpdate = false;
            cVar.field_bitFlag = acr.wku.vMX;
            cVar.field_maxMemberCnt = acr.wku.vMY;
            cVar.field_ownerUserId = acr.wku.vMZ;
            cVar.field_addMemberUrl = acr.wku.vNa;
            cVar.field_brandUserName = str;
            List linkedList = new LinkedList();
            Iterator it = acr.vNd.iterator();
            while (it.hasNext()) {
                linkedList.add(((kf) it.next()).vNc);
            }
            cVar.field_userList = bo.c(linkedList, ";");
            if (z2) {
                z.aeT().a(cVar);
            } else {
                z.aeT().b(cVar);
            }
        }
        e.h(cVar);
        kf kfVar;
        if (z) {
            lj ljVar = new lj();
            ljVar.vNb = cVar.field_brandUserName;
            LinkedList linkedList2 = new LinkedList();
            Iterator it2 = acr.vNd.iterator();
            while (it2.hasNext()) {
                kfVar = (kf) it2.next();
                if (((long) kfVar.ver) > ((long) z.aeV().rC(kfVar.vNc))) {
                    linkedList2.add(kfVar.vNc);
                }
            }
            if (linkedList2.size() > 0) {
                ljVar.vOW = linkedList2;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(ljVar);
                g.RO().eJo.a(new r(linkedList3, null), 0);
            }
        } else {
            e eVar = z.aeV().bSd;
            long j = 0;
            if (eVar instanceof com.tencent.mm.cd.h) {
                j = ((com.tencent.mm.cd.h) eVar).iV(Thread.currentThread().getId());
            }
            Iterator it3 = acr.vNd.iterator();
            while (it3.hasNext()) {
                kfVar = (kf) it3.next();
                j cH = z.aeV().cH(kfVar.vNc);
                if (cH == null) {
                    cH = new j();
                    cH.field_userId = kfVar.vNc;
                    cH.field_userName = kfVar.kfT;
                    cH.field_brandUserName = cVar.field_brandUserName;
                    cH.field_needToUpdate = true;
                    z.aeV().a(cH);
                } else if (kfVar.ver > cH.field_UserVersion) {
                    cH.field_needToUpdate = true;
                    z.aeV().b(cH);
                }
            }
            if (eVar instanceof com.tencent.mm.cd.h) {
                g.RP().eJN.mB(j);
            }
        }
        AppMethodBeat.o(11589);
        return true;
    }
}
