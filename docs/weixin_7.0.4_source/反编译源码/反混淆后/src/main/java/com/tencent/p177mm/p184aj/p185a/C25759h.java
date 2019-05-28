package com.tencent.p177mm.p184aj.p185a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.C25772n;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.protocal.protobuf.C15359lj;
import com.tencent.p177mm.protocal.protobuf.C15386uh;
import com.tencent.p177mm.protocal.protobuf.C23405ke;
import com.tencent.p177mm.protocal.protobuf.C23406kf;
import com.tencent.p177mm.protocal.protobuf.C23407kg;
import com.tencent.p177mm.protocal.protobuf.C30231uo;
import com.tencent.p177mm.protocal.protobuf.C40579un;
import com.tencent.p177mm.protocal.protobuf.C44133kd;
import com.tencent.p177mm.protocal.protobuf.C44135kk;
import com.tencent.p177mm.protocal.protobuf.acr;
import com.tencent.p177mm.protocal.protobuf.afm;
import com.tencent.p177mm.protocal.protobuf.afn;
import com.tencent.p177mm.protocal.protobuf.afo;
import com.tencent.p177mm.protocal.protobuf.afp;
import com.tencent.p177mm.protocal.protobuf.afq;
import com.tencent.p177mm.protocal.protobuf.afs;
import com.tencent.p177mm.protocal.protobuf.aiv;
import com.tencent.p177mm.protocal.protobuf.aiw;
import com.tencent.p177mm.protocal.protobuf.auq;
import com.tencent.p177mm.protocal.protobuf.cjl;
import com.tencent.p177mm.protocal.protobuf.cjm;
import com.tencent.p177mm.protocal.protobuf.cjn;
import com.tencent.p177mm.protocal.protobuf.cjo;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.aj.a.h */
public final class C25759h implements C1202f {
    private HashSet<C25760a> fxP = new HashSet();
    private HashSet<C25760a> fxQ = new HashSet();
    private final Object fxR = new Object();
    private C1177f<String, Long> fxS = new C6294h(64);
    private HashSet<C25760a> fxT = new HashSet();
    private HashSet<C25760a> fxU = new HashSet();
    private final Object fxV = new Object();
    private C1177f<String, Long> fxW = new C6294h(64);

    /* renamed from: com.tencent.mm.aj.a.h$a */
    public static class C25760a {
        private String cGT;
        /* renamed from: id */
        private String f13654id;

        public C25760a(String str, String str2) {
            this.cGT = str;
            this.f13654id = str2;
        }

        public boolean equals(Object obj) {
            AppMethodBeat.m2504i(11567);
            if (obj.getClass() != C25760a.class) {
                AppMethodBeat.m2505o(11567);
                return false;
            }
            C25760a c25760a = (C25760a) obj;
            if ((!(this.cGT == null && c25760a.cGT == null) && (this.cGT == null || !this.cGT.equals(c25760a.cGT))) || (!(this.f13654id == null && c25760a.f13654id == null) && (this.f13654id == null || !this.f13654id.equals(c25760a.f13654id)))) {
                AppMethodBeat.m2505o(11567);
                return false;
            }
            AppMethodBeat.m2505o(11567);
            return true;
        }

        public int hashCode() {
            AppMethodBeat.m2504i(11568);
            int hashCode = this.cGT.hashCode() + this.f13654id.hashCode();
            AppMethodBeat.m2505o(11568);
            return hashCode;
        }
    }

    public C25759h() {
        AppMethodBeat.m2504i(11569);
        C1720g.m3535RO().eJo.mo14539a(1352, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1365, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1353, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1354, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1357, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1356, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1355, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1358, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1367, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1361, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1389, (C1202f) this);
        C1720g.m3535RO().eJo.mo14539a(1315, (C1202f) this);
        AppMethodBeat.m2505o(11569);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(11570);
        C1720g.m3535RO().eJo.mo14546b(1352, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1365, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1353, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1354, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1357, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1356, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1355, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1358, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1367, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1361, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1389, (C1202f) this);
        C1720g.m3535RO().eJo.mo14546b(1315, (C1202f) this);
        super.finalize();
        AppMethodBeat.m2505o(11570);
    }

    /* JADX WARNING: Removed duplicated region for block: B:278:0x05c0  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0534  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(11571);
        if (!(i == 0 && i2 == 0)) {
            C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:Network not ok");
            if (!(c1207m.getType() == 1365 || c1207m.getType() == 1353)) {
                AppMethodBeat.m2505o(11571);
                return;
            }
        }
        int i3;
        boolean a;
        int i4;
        C25772n c25772n;
        String str2;
        String str3;
        switch (c1207m.getType()) {
            case 1315:
                c1207m = (C37451m) c1207m;
                C15386uh afl = c1207m.afl();
                i3 = 0;
                if (afl == null || afl.vNh == null || afl.vNh.ret != 0) {
                    if (afl == null || afl.vNh == null) {
                        C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afl.vNh.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && afl.wbT == null && afl.wbS == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (afl.wbT != null) {
                        a = C25759h.m40923a(afl.wbT, afl.vNb);
                        if (a) {
                            c1207m.fye = afl.wbT.vNc;
                        }
                    } else {
                        a = C25759h.m40922a(afl.wbS, afl.vNb, true);
                        if (a) {
                            c1207m.fye = afl.wbS.wku.vMV;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        c25772n = (C25772n) c1207m.data;
                        if (c25772n != null) {
                            c25772n.mo15832a(i4, c1207m);
                        }
                        AppMethodBeat.m2505o(11571);
                        return;
                    }
                }
                i4 = i3;
                c25772n = (C25772n) c1207m.data;
                if (c25772n != null) {
                }
                AppMethodBeat.m2505o(11571);
                return;
            case 1352:
                afo afo;
                afn afn;
                C25761o c25761o = (C25761o) c1207m;
                if (c25761o.ehh == null || c25761o.ehh.fsH.fsP == null) {
                    afo = null;
                } else {
                    afo = (afo) c25761o.ehh.fsH.fsP;
                }
                if (c25761o.ehh == null || c25761o.ehh.fsG.fsP == null) {
                    afn = null;
                } else {
                    afn = (afn) c25761o.ehh.fsG.fsP;
                }
                boolean z = c25761o.fyf;
                if (afo != null && afo.vNh != null && afo.vNh.ret == 0) {
                    C25759h.m40922a(afo.wcb, afn.vNb, z);
                    AppMethodBeat.m2505o(11571);
                    return;
                } else if (afo == null || afo.vNh == null) {
                    C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.m2505o(11571);
                    return;
                } else {
                    C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afo.vNh.ret));
                    AppMethodBeat.m2505o(11571);
                    return;
                }
            case 1353:
                c1207m = (C41740r) c1207m;
                c25772n = (C25772n) c1207m.data;
                if (c25772n == null) {
                    synchronized (this.fxV) {
                        try {
                            this.fxU.clear();
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.m2505o(11571);
                                break;
                            }
                        }
                    }
                    afk();
                }
                if (i == 0 && i2 == 0) {
                    afs afs;
                    int i5;
                    if (c1207m.ehh == null || c1207m.ehh.fsH.fsP == null) {
                        afs = null;
                    } else {
                        afs = (afs) c1207m.ehh.fsH.fsP;
                    }
                    i4 = 0;
                    if (afs == null || afs.vNh == null || afs.vNh.ret != 0) {
                        if (afs == null || afs.vNh == null) {
                            C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        } else {
                            C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afs.vNh.ret));
                        }
                        i4 = -1;
                    }
                    if (i4 < 0 || afs.vNi != null) {
                        i5 = i4;
                    } else {
                        C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "resp.user==null");
                        i5 = -1;
                    }
                    if (i5 >= 0) {
                        C4927e c4927e = C41747z.aeV().bSd;
                        long j = 0;
                        if (c4927e instanceof C7480h) {
                            j = ((C7480h) c4927e).mo15639iV(Thread.currentThread().getId());
                        }
                        i4 = 0;
                        while (true) {
                            int i6 = i4;
                            if (i6 < afs.vNi.size()) {
                                C4990ab.m7411d("MicroMsg.BizChatNetworkMgr", "GetBizChatUserInfoList %s", ((C44135kk) afs.vNi.get(i6)).kfT);
                                C45143j c45143j = new C45143j();
                                c45143j.field_userId = ((C44135kk) afs.vNi.get(i6)).vNc;
                                c45143j.field_userName = ((C44135kk) afs.vNi.get(i6)).kfT;
                                str2 = c45143j.field_userId;
                                if (str2 == null || c1207m.fyh == null) {
                                    str2 = null;
                                } else {
                                    str2 = (String) c1207m.fyh.get(str2);
                                }
                                c45143j.field_brandUserName = str2;
                                c45143j.field_UserVersion = ((C44135kk) afs.vNi.get(i6)).ver;
                                c45143j.field_headImageUrl = ((C44135kk) afs.vNi.get(i6)).vMW;
                                c45143j.field_profileUrl = ((C44135kk) afs.vNi.get(i6)).vNk;
                                c45143j.field_bitFlag = ((C44135kk) afs.vNi.get(i6)).vMX;
                                c45143j.field_addMemberUrl = ((C44135kk) afs.vNi.get(i6)).vNa;
                                c45143j.field_needToUpdate = false;
                                C45143j cH = C41747z.aeV().mo60356cH(((C44135kk) afs.vNi.get(i6)).vNc);
                                a = cH == null ? false : cH.mo73056lc(16);
                                boolean lc = c45143j.mo73056lc(16);
                                if (cH == null) {
                                    C41747z.aeV().mo60353a(c45143j);
                                } else {
                                    C41747z.aeV().mo60354b(c45143j);
                                }
                                if (a != lc) {
                                    C45142c rq = C41747z.aeT().mo60352rq(c45143j.field_userId);
                                    if (rq != null) {
                                        if (a && !lc) {
                                            C41747z.aeU().mo60338fA(rq.field_bizChatLocalId);
                                        } else if (!a && lc) {
                                            C41747z.aeU().mo60344fz(rq.field_bizChatLocalId);
                                        }
                                    }
                                }
                                i4 = i6 + 1;
                            } else if (c4927e instanceof C7480h) {
                                C1720g.m3536RP().eJN.mo15640mB(j);
                            }
                        }
                    }
                    if (c25772n != null) {
                        c25772n.mo15832a(i5, c1207m);
                    }
                    AppMethodBeat.m2505o(11571);
                    return;
                }
                AppMethodBeat.m2505o(11571);
                return;
            case 1354:
                afq afq;
                afp afp;
                int i7;
                c1207m = (C17901q) c1207m;
                if (c1207m.ehh == null || c1207m.ehh.fsH.fsP == null) {
                    afq = null;
                } else {
                    afq = (afq) c1207m.ehh.fsH.fsP;
                }
                if (c1207m.ehh == null) {
                    afp = null;
                } else {
                    afp = (afp) c1207m.ehh.fsG.fsP;
                }
                if (afq == null || afq.vNh == null || afq.vNh.ret != 0) {
                    if (afq == null || afq.vNh == null) {
                        C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afq.vNh.ret));
                    }
                    i7 = -1;
                } else {
                    i7 = 0;
                }
                if (i7 >= 0) {
                    C37449k aeV = C41747z.aeV();
                    String str4 = afp.vNb;
                    C44135kk c44135kk = afq.vNe;
                    if (c44135kk == null || C5046bo.isNullOrNil(str4)) {
                        C4990ab.m7420w("MicroMsg.BizChatUserInfoStorage", "setMyUserId: wrong argument");
                    } else {
                        C4990ab.m7417i("MicroMsg.BizChatUserInfoStorage", "setMyUserId:%s,%s,%s", str4, c44135kk.vNc, Boolean.valueOf(C5046bo.isNullOrNil(c44135kk.vNa)));
                        C8925f rA = C41747z.aeW().mo43711rA(str4);
                        if (rA == null) {
                            rA = new C8925f();
                            rA.field_brandUserName = str4;
                            rA.field_userId = c44135kk.vNc;
                            C41747z.aeW().mo43709a(rA);
                        } else {
                            rA.field_userId = c44135kk.vNc;
                            C41747z.aeW().mo43710b(rA);
                            C4990ab.m7416i("MicroMsg.BizChatUserInfoStorage", "setMyUserId: MyUserId seted");
                        }
                        C45143j c45143j2 = new C45143j();
                        c45143j2.field_userId = c44135kk.vNc;
                        c45143j2.field_userName = c44135kk.kfT;
                        c45143j2.field_brandUserName = str4;
                        c45143j2.field_UserVersion = c44135kk.ver;
                        c45143j2.field_headImageUrl = c44135kk.vMW;
                        c45143j2.field_profileUrl = c44135kk.vNk;
                        c45143j2.field_bitFlag = c44135kk.vMX;
                        c45143j2.field_needToUpdate = false;
                        c45143j2.field_addMemberUrl = c44135kk.vNa;
                        if (!aeV.mo60354b(c45143j2)) {
                            aeV.mo60353a(c45143j2);
                        }
                        aeV.fxs.put(str4, c45143j2.field_userId);
                    }
                }
                c25772n = (C25772n) c1207m.data;
                if (c25772n != null) {
                    c25772n.mo15832a(i7, c1207m);
                }
                AppMethodBeat.m2505o(11571);
                return;
            case 1355:
                c1207m = (C17900n) c1207m;
                C30231uo afm = c1207m.afm();
                C40579un afn2 = c1207m.afn();
                i3 = 0;
                if (afm == null || afm.vNh == null || afm.vNh.ret != 0) {
                    if (afm == null || afm.vNh == null) {
                        C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afm.vNh.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (C25759h.m40922a(afm.wcb, afn2.vNb, true)) {
                        i3 = 0;
                    } else {
                        i3 = -1;
                    }
                    i4 = i3;
                } else {
                    i4 = i3;
                }
                c25772n = (C25772n) c1207m.data;
                if (c25772n != null) {
                    c25772n.mo15832a(i4, c1207m);
                }
                AppMethodBeat.m2505o(11571);
                return;
            case 1356:
                cjo cjo;
                cjn cjn;
                c1207m = (C17902w) c1207m;
                if (c1207m.ehh == null || c1207m.ehh.fsH.fsP == null) {
                    cjo = null;
                } else {
                    cjo = (cjo) c1207m.ehh.fsH.fsP;
                }
                if (c1207m.ehh == null || c1207m.ehh.fsG.fsP == null) {
                    cjn = null;
                } else {
                    cjn = (cjn) c1207m.ehh.fsG.fsP;
                }
                i3 = 0;
                if (cjo == null || cjo.vNh == null || cjo.vNh.ret != 0 || cjo.wku == null) {
                    if (cjo == null || cjo.vNh == null) {
                        C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(cjo.vNh.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0) {
                    C45142c rq2 = C41747z.aeT().mo60352rq(cjo.wku.vMV);
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
                        C4990ab.m7421w(str3, str5, objArr);
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
                        C41747z.aeT().mo60350b(rq2);
                        i4 = i3;
                    }
                } else {
                    i4 = i3;
                }
                c25772n = (C25772n) c1207m.data;
                if (c25772n != null) {
                    c25772n.mo15832a(i4, c1207m);
                }
                AppMethodBeat.m2505o(11571);
                return;
            case 1357:
                cjm cjm;
                cjl cjl;
                C4990ab.m7410d("MicroMsg.BizChatNetworkMgr", "handleUpdateBizChatMemberListSceneEnd");
                c1207m = (C25763x) c1207m;
                if (c1207m.ehh == null || c1207m.ehh.fsH.fsP == null) {
                    cjm = null;
                } else {
                    cjm = (cjm) c1207m.ehh.fsH.fsP;
                }
                if (c1207m.ehh == null || c1207m.ehh.fsG.fsP == null) {
                    cjl = null;
                } else {
                    cjl = (cjl) c1207m.ehh.fsG.fsP;
                }
                if (cjm != null && cjm.vNh != null && cjm.vNh.ret == 0) {
                    if (C25759h.m40922a(cjm.wcb, cjl.vNb, false)) {
                        i4 = 0;
                    } else {
                        i4 = -1;
                    }
                    c25772n = (C25772n) c1207m.data;
                    if (c25772n != null) {
                        c25772n.mo15832a(i4, c1207m);
                    }
                    AppMethodBeat.m2505o(11571);
                    return;
                } else if (cjm == null || cjm.vNh == null) {
                    C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.m2505o(11571);
                    return;
                } else {
                    C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(cjm.vNh.ret));
                    AppMethodBeat.m2505o(11571);
                    return;
                }
            case 1358:
                AppMethodBeat.m2505o(11571);
                return;
            case 1365:
                synchronized (this.fxR) {
                    try {
                        this.fxQ.clear();
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(11571);
                            break;
                        }
                    }
                }
                afj();
                if (i == 0 && i2 == 0) {
                    afm afm2;
                    C25762p c25762p = (C25762p) c1207m;
                    if (c25762p.ehh == null || c25762p.ehh.fsH.fsP == null) {
                        afm2 = null;
                    } else {
                        afm2 = (afm) c25762p.ehh.fsH.fsP;
                    }
                    if (afm2 != null && afm2.vNh != null && afm2.vNh.ret == 0) {
                        LinkedList linkedList = afm2.wmT;
                        if (linkedList == null || linkedList.size() == 0) {
                            C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "fullBizChats is empty");
                            AppMethodBeat.m2505o(11571);
                            return;
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            acr acr = (acr) it.next();
                            str2 = acr.wku.vMV;
                            if (str2 == null || c25762p.fyg == null) {
                                str2 = null;
                            } else {
                                str2 = (String) c25762p.fyg.get(str2);
                            }
                            C25759h.m40922a(acr, str2, false);
                        }
                        AppMethodBeat.m2505o(11571);
                        return;
                    } else if (afm2 == null || afm2.vNh == null) {
                        C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                        AppMethodBeat.m2505o(11571);
                        return;
                    } else {
                        C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afm2.vNh.ret));
                        AppMethodBeat.m2505o(11571);
                        return;
                    }
                }
                AppMethodBeat.m2505o(11571);
                return;
            case 1367:
                aiw aiw;
                aiv aiv;
                C45145s c45145s = (C45145s) c1207m;
                if (c45145s.ehh == null || c45145s.ehh.fsH.fsP == null) {
                    aiw = null;
                } else {
                    aiw = (aiw) c45145s.ehh.fsH.fsP;
                }
                if (c45145s.ehh == null || c45145s.ehh.fsG.fsP == null) {
                    aiv = null;
                } else {
                    aiv = (aiv) c45145s.ehh.fsG.fsP;
                }
                if (aiw != null && aiw.vNh != null && aiw.vNh.ret == 0) {
                    LinkedList<String> linkedList2 = aiw.woQ;
                    C37448d aeT = C41747z.aeT();
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
                            C45142c rq3 = C41747z.aeT().mo60352rq(str6);
                            if (rq3 != null) {
                                rq3.field_bitFlag &= -9;
                                C41747z.aeT().mo60350b(rq3);
                            }
                        }
                    }
                    for (String str62 : linkedList2) {
                        if (!arrayList.contains(str62)) {
                            C45142c rq4 = C41747z.aeT().mo60352rq(str62);
                            if (rq4 == null) {
                                rq4 = new C45142c();
                                rq4.field_bizChatServId = str62;
                                rq4.field_brandUserName = aiv.vNb;
                                rq4.field_bitFlag |= 8;
                                C41747z.aeT().mo60348a(rq4);
                            } else {
                                rq4.field_bitFlag |= 8;
                                C41747z.aeT().mo60350b(rq4);
                            }
                        }
                    }
                    mo43713a(aiw.woQ, aiv.vNb);
                    break;
                } else if (aiw == null || aiw.vNh == null) {
                    C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    AppMethodBeat.m2505o(11571);
                    return;
                } else {
                    C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(aiw.vNh.ret));
                    AppMethodBeat.m2505o(11571);
                    return;
                }
                break;
            case 1389:
                c1207m = (C37452t) c1207m;
                auq afo2 = c1207m.afo();
                i3 = 0;
                if (afo2 == null || afo2.vNh == null || afo2.vNh.ret != 0) {
                    if (afo2 == null || afo2.vNh == null) {
                        C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:resp == null");
                    } else {
                        C4990ab.m7421w("MicroMsg.BizChatNetworkMgr", "willen onSceneEnd err:code:%s", Integer.valueOf(afo2.vNh.ret));
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && afo2.wbT == null && afo2.wbS == null) {
                    i3 = -1;
                }
                if (i3 >= 0) {
                    if (afo2.wbT != null) {
                        a = C25759h.m40923a(afo2.wbT, afo2.vNb);
                        if (a) {
                            c1207m.fye = afo2.wbT.vNc;
                        }
                    } else {
                        a = C25759h.m40922a(afo2.wbS, afo2.vNb, true);
                        if (a) {
                            c1207m.fye = afo2.wbS.wku.vMV;
                        }
                    }
                    if (!a) {
                        i4 = -1;
                        c25772n = (C25772n) c1207m.data;
                        if (c25772n != null) {
                            c25772n.mo15832a(i4, c1207m);
                        }
                        AppMethodBeat.m2505o(11571);
                        return;
                    }
                }
                i4 = i3;
                c25772n = (C25772n) c1207m.data;
                if (c25772n != null) {
                }
                AppMethodBeat.m2505o(11571);
                return;
        }
        AppMethodBeat.m2505o(11571);
    }

    /* renamed from: f */
    public static void m40927f(C1207m c1207m) {
        AppMethodBeat.m2504i(11572);
        C1720g.m3535RO().eJo.mo14547c(c1207m);
        AppMethodBeat.m2505o(11572);
    }

    /* renamed from: aD */
    public final void mo43714aD(String str, String str2) {
        AppMethodBeat.m2504i(11573);
        Long l = (Long) this.fxS.mo4404ai(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            m40924aE(str, str2);
        }
        AppMethodBeat.m2505o(11573);
    }

    /* renamed from: aE */
    private void m40924aE(String str, String str2) {
        AppMethodBeat.m2504i(11574);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.fxR) {
            try {
                C25760a c25760a = new C25760a(str2, str);
                if (this.fxQ.contains(c25760a)) {
                } else {
                    this.fxP.add(c25760a);
                    this.fxS.put(str, new Long(currentTimeMillis));
                    afj();
                    AppMethodBeat.m2505o(11574);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(11574);
            }
        }
    }

    /* renamed from: a */
    public final void mo43713a(LinkedList<String> linkedList, String str) {
        AppMethodBeat.m2504i(11575);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.fxR) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    C25760a c25760a = new C25760a(str, str2);
                    if (!this.fxQ.contains(c25760a)) {
                        this.fxP.add(c25760a);
                        this.fxS.put(str2, new Long(currentTimeMillis));
                    }
                }
                afj();
            } finally {
                AppMethodBeat.m2505o(11575);
            }
        }
    }

    private void afj() {
        AppMethodBeat.m2504i(11576);
        LinkedList linkedList = new LinkedList();
        synchronized (this.fxR) {
            try {
                if (!this.fxQ.isEmpty()) {
                } else if (this.fxP.isEmpty()) {
                    AppMethodBeat.m2505o(11576);
                } else {
                    Iterator it = this.fxP.iterator();
                    while (it.hasNext()) {
                        C25760a c25760a = (C25760a) it.next();
                        C23405ke c23405ke = new C23405ke();
                        c23405ke.vNb = c25760a.cGT;
                        c23405ke.vMV = c25760a.f13654id;
                        linkedList.add(c23405ke);
                    }
                    if (linkedList.isEmpty()) {
                        AppMethodBeat.m2505o(11576);
                        return;
                    }
                    this.fxQ.addAll(this.fxP);
                    this.fxP.clear();
                    C1720g.m3535RO().eJo.mo14541a(new C25762p(linkedList), 0);
                    AppMethodBeat.m2505o(11576);
                }
            } finally {
                AppMethodBeat.m2505o(11576);
            }
        }
    }

    /* renamed from: aF */
    public final void mo43715aF(String str, String str2) {
        AppMethodBeat.m2504i(11577);
        Long l = (Long) this.fxW.mo4404ai(str);
        if (l == null || l.longValue() + 5000 < System.currentTimeMillis()) {
            mo43716aG(str, str2);
        }
        AppMethodBeat.m2505o(11577);
    }

    /* renamed from: aG */
    public final void mo43716aG(String str, String str2) {
        AppMethodBeat.m2504i(11578);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.fxV) {
            try {
                C25760a c25760a = new C25760a(str2, str);
                if (this.fxU.contains(c25760a)) {
                } else {
                    this.fxT.add(c25760a);
                    this.fxW.put(str, new Long(currentTimeMillis));
                    afk();
                    AppMethodBeat.m2505o(11578);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(11578);
            }
        }
    }

    /* renamed from: b */
    public final void mo43717b(LinkedList<String> linkedList, String str) {
        AppMethodBeat.m2504i(11579);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.fxV) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str2 = (String) it.next();
                    C25760a c25760a = new C25760a(str, str2);
                    if (!this.fxU.contains(c25760a)) {
                        this.fxT.add(c25760a);
                        this.fxW.put(str2, new Long(currentTimeMillis));
                    }
                }
                afk();
                AppMethodBeat.m2505o(11579);
            } finally {
                AppMethodBeat.m2505o(11579);
            }
        }
    }

    private void afk() {
        AppMethodBeat.m2504i(11580);
        LinkedList linkedList = new LinkedList();
        synchronized (this.fxV) {
            try {
                if (!this.fxU.isEmpty()) {
                } else if (this.fxT.isEmpty()) {
                    AppMethodBeat.m2505o(11580);
                } else {
                    LinkedList linkedList2;
                    HashMap hashMap = new HashMap();
                    Iterator it = this.fxT.iterator();
                    while (it.hasNext()) {
                        C25760a c25760a = (C25760a) it.next();
                        linkedList2 = (LinkedList) hashMap.get(c25760a.cGT);
                        if (linkedList2 == null) {
                            linkedList2 = new LinkedList();
                            hashMap.put(c25760a.cGT, linkedList2);
                        }
                        linkedList2.add(c25760a.f13654id);
                    }
                    for (String str : hashMap.keySet()) {
                        linkedList2 = (LinkedList) hashMap.get(str);
                        if (!(linkedList2 == null || linkedList2.isEmpty())) {
                            C15359lj c15359lj = new C15359lj();
                            c15359lj.vNb = str;
                            c15359lj.vOW = linkedList2;
                            linkedList.add(c15359lj);
                        }
                    }
                    this.fxU.addAll(this.fxT);
                    this.fxT.clear();
                    C1720g.m3535RO().eJo.mo14541a(new C41740r(linkedList, null), 0);
                    AppMethodBeat.m2505o(11580);
                }
            } finally {
                AppMethodBeat.m2505o(11580);
            }
        }
    }

    /* renamed from: aH */
    public static void m40925aH(String str, String str2) {
        AppMethodBeat.m2504i(11581);
        C1720g.m3535RO().eJo.mo14541a(new C25761o(str, str2), 0);
        AppMethodBeat.m2505o(11581);
    }

    /* renamed from: a */
    public static void m40921a(String str, String str2, C25772n c25772n) {
        AppMethodBeat.m2504i(11582);
        if (c25772n == null) {
            AppMethodBeat.m2505o(11582);
            return;
        }
        C45143j rv = C25754e.m40908rv(str2);
        if (rv == null || rv.field_userId.equals(str)) {
            C25759h.m40920a(str2, c25772n);
            AppMethodBeat.m2505o(11582);
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        C15359lj c15359lj = new C15359lj();
        c15359lj.vNb = str2;
        c15359lj.vOW = linkedList;
        linkedList = new LinkedList();
        linkedList.add(c15359lj);
        C1720g.m3535RO().eJo.mo14541a(new C41740r(linkedList, c25772n), 0);
        AppMethodBeat.m2505o(11582);
    }

    /* renamed from: a */
    public static void m40920a(String str, C25772n c25772n) {
        AppMethodBeat.m2504i(11583);
        C1720g.m3535RO().eJo.mo14541a(new C17901q(str, c25772n), 0);
        AppMethodBeat.m2505o(11583);
    }

    /* renamed from: a */
    public static C17900n m40917a(String str, acr acr, C25772n c25772n) {
        AppMethodBeat.m2504i(11584);
        C1207m c17900n = new C17900n(str, acr, c25772n);
        C1720g.m3535RO().eJo.mo14541a(c17900n, 0);
        AppMethodBeat.m2505o(11584);
        return c17900n;
    }

    /* renamed from: a */
    public static C25763x m40919a(String str, String str2, C23407kg c23407kg, C23407kg c23407kg2, C25772n c25772n) {
        AppMethodBeat.m2504i(11585);
        C1207m c25763x = new C25763x(str, str2, c23407kg, c23407kg2, c25772n);
        C1720g.m3535RO().eJo.mo14541a(c25763x, 0);
        AppMethodBeat.m2505o(11585);
        return c25763x;
    }

    /* renamed from: a */
    public static C17902w m40918a(String str, C44133kd c44133kd, C25772n c25772n) {
        AppMethodBeat.m2504i(11586);
        C1207m c17902w = new C17902w(str, c44133kd, c25772n);
        C1720g.m3535RO().eJo.mo14541a(c17902w, 0);
        AppMethodBeat.m2505o(11586);
        return c17902w;
    }

    /* renamed from: e */
    public static void m40926e(String str, String str2, int i) {
        AppMethodBeat.m2504i(11587);
        C1720g.m3535RO().eJo.mo14541a(new C41742v(str, str2, i), 0);
        AppMethodBeat.m2505o(11587);
    }

    /* renamed from: a */
    private static boolean m40923a(C44135kk c44135kk, String str) {
        AppMethodBeat.m2504i(11588);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(c44135kk.vNc)) {
            AppMethodBeat.m2505o(11588);
            return false;
        }
        C45143j c45143j = new C45143j();
        c45143j.field_userId = c44135kk.vNc;
        c45143j.field_userName = c44135kk.kfT;
        c45143j.field_brandUserName = str;
        c45143j.field_headImageUrl = c44135kk.vMW;
        c45143j.field_profileUrl = c44135kk.vNk;
        c45143j.field_UserVersion = c44135kk.ver;
        c45143j.field_addMemberUrl = c44135kk.vNa;
        if (!C41747z.aeV().mo60354b(c45143j)) {
            C41747z.aeV().mo60353a(c45143j);
        }
        C45142c c45142c = new C45142c();
        c45142c.field_bizChatServId = c45143j.field_userId;
        c45142c.field_brandUserName = c45143j.field_brandUserName;
        c45142c.field_chatName = c45143j.field_userName;
        c45142c.field_chatType = 1;
        if (C25754e.m40896e(c45142c) == null) {
            AppMethodBeat.m2505o(11588);
            return false;
        }
        AppMethodBeat.m2505o(11588);
        return true;
    }

    /* renamed from: a */
    private static boolean m40922a(acr acr, String str, boolean z) {
        AppMethodBeat.m2504i(11589);
        C4990ab.m7410d("MicroMsg.BizChatNetworkMgr", "handleGetBizChatInfoSceneEnd");
        if (acr == null || acr.wku == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "fullBizChat or fullBizChat.chat or brandUserName == null");
            AppMethodBeat.m2505o(11589);
            return false;
        }
        boolean z2;
        C45142c c45142c;
        C45142c rq = C41747z.aeT().mo60352rq(acr.wku.vMV);
        if (rq == null) {
            C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "bizChatInfo == null");
            rq = new C45142c();
            rq.field_bizChatServId = acr.wku.vMV;
            rq.field_brandUserName = str;
            z2 = true;
            c45142c = rq;
            z = true;
        } else {
            z2 = false;
            c45142c = rq;
        }
        if (acr.vNd == null) {
            C4990ab.m7420w("MicroMsg.BizChatNetworkMgr", "members==null");
            AppMethodBeat.m2505o(11589);
            return false;
        }
        if (c45142c.afh() || acr.wku.ver > c45142c.field_chatVersion) {
            c45142c.field_chatType = acr.wku.type;
            c45142c.field_headImageUrl = acr.wku.vMW;
            c45142c.field_chatName = acr.wku.name;
            c45142c.field_chatVersion = acr.wku.ver;
            c45142c.field_needToUpdate = false;
            c45142c.field_bitFlag = acr.wku.vMX;
            c45142c.field_maxMemberCnt = acr.wku.vMY;
            c45142c.field_ownerUserId = acr.wku.vMZ;
            c45142c.field_addMemberUrl = acr.wku.vNa;
            c45142c.field_brandUserName = str;
            List linkedList = new LinkedList();
            Iterator it = acr.vNd.iterator();
            while (it.hasNext()) {
                linkedList.add(((C23406kf) it.next()).vNc);
            }
            c45142c.field_userList = C5046bo.m7536c(linkedList, ";");
            if (z2) {
                C41747z.aeT().mo60348a(c45142c);
            } else {
                C41747z.aeT().mo60350b(c45142c);
            }
        }
        C25754e.m40902h(c45142c);
        C23406kf c23406kf;
        if (z) {
            C15359lj c15359lj = new C15359lj();
            c15359lj.vNb = c45142c.field_brandUserName;
            LinkedList linkedList2 = new LinkedList();
            Iterator it2 = acr.vNd.iterator();
            while (it2.hasNext()) {
                c23406kf = (C23406kf) it2.next();
                if (((long) c23406kf.ver) > ((long) C41747z.aeV().mo60358rC(c23406kf.vNc))) {
                    linkedList2.add(c23406kf.vNc);
                }
            }
            if (linkedList2.size() > 0) {
                c15359lj.vOW = linkedList2;
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(c15359lj);
                C1720g.m3535RO().eJo.mo14541a(new C41740r(linkedList3, null), 0);
            }
        } else {
            C4927e c4927e = C41747z.aeV().bSd;
            long j = 0;
            if (c4927e instanceof C7480h) {
                j = ((C7480h) c4927e).mo15639iV(Thread.currentThread().getId());
            }
            Iterator it3 = acr.vNd.iterator();
            while (it3.hasNext()) {
                c23406kf = (C23406kf) it3.next();
                C45143j cH = C41747z.aeV().mo60356cH(c23406kf.vNc);
                if (cH == null) {
                    cH = new C45143j();
                    cH.field_userId = c23406kf.vNc;
                    cH.field_userName = c23406kf.kfT;
                    cH.field_brandUserName = c45142c.field_brandUserName;
                    cH.field_needToUpdate = true;
                    C41747z.aeV().mo60353a(cH);
                } else if (c23406kf.ver > cH.field_UserVersion) {
                    cH.field_needToUpdate = true;
                    C41747z.aeV().mo60354b(cH);
                }
            }
            if (c4927e instanceof C7480h) {
                C1720g.m3536RP().eJN.mo15640mB(j);
            }
        }
        AppMethodBeat.m2505o(11589);
        return true;
    }
}
