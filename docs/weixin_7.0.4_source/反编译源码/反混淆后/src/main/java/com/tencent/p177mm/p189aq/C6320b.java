package com.tencent.p177mm.p189aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.chatting.p1345j.C23797b;
import com.tencent.p177mm.p712j.p713a.p714a.C6594c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C28493i;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.notification.C3559d;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.protocal.protobuf.ahc;
import com.tencent.p177mm.protocal.protobuf.ahd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.aq.b */
public class C6320b implements C1224a {
    private static C3559d fCn = new C3559d(true);
    private static C6320b fCp;
    public C6322a fCk;
    private C1207m fCl;
    private C7564ap fCm = new C7564ap(C9638aw.m17180RS().oAl.getLooper(), new C63211(), false);
    private C6323b fCo = new C12792();

    /* renamed from: com.tencent.mm.aq.b$2 */
    class C12792 implements C6323b {
        C12792() {
        }

        /* renamed from: b */
        public final void mo4575b(int i, List<C7620bi> list) {
            AppMethodBeat.m2504i(16445);
            C4990ab.m7420w("MicroMsg.GetChatroomMsgFetcher", "[onFinish] ret:" + i + " addSize:" + list.size());
            AppMethodBeat.m2505o(16445);
        }
    }

    /* renamed from: com.tencent.mm.aq.b$1 */
    class C63211 implements C5015a {
        C63211() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(16444);
            C4990ab.m7416i("MicroMsg.GetChatroomMsgFetcher", "timeoutHandler onTimerExpired");
            if (C6320b.this.fCl != null) {
                C1226w.m2659c(C6320b.this.fCl);
                C6320b.this.fCl = null;
            }
            C6320b.m10396a(C6320b.this, new LinkedList());
            AppMethodBeat.m2505o(16444);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.aq.b$a */
    public interface C6322a {
        /* renamed from: a */
        void mo14567a(String str, boolean z, LinkedList<C7620bi> linkedList, C6594c c6594c, boolean z2);
    }

    /* renamed from: com.tencent.mm.aq.b$b */
    public interface C6323b {
        /* renamed from: b */
        void mo4575b(int i, List<C7620bi> list);
    }

    /* renamed from: a */
    static /* synthetic */ void m10396a(C6320b c6320b, LinkedList linkedList) {
        AppMethodBeat.m2504i(16454);
        c6320b.m10395a(null, -1, linkedList);
        AppMethodBeat.m2505o(16454);
    }

    static {
        AppMethodBeat.m2504i(16455);
        AppMethodBeat.m2505o(16455);
    }

    private C6320b() {
        AppMethodBeat.m2504i(16446);
        AppMethodBeat.m2505o(16446);
    }

    public static C6320b agG() {
        AppMethodBeat.m2504i(16447);
        if (fCp == null) {
            synchronized (C6320b.class) {
                try {
                    if (fCp == null) {
                        fCp = new C6320b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(16447);
                    }
                }
            }
        }
        C6320b c6320b = fCp;
        AppMethodBeat.m2505o(16447);
        return c6320b;
    }

    /* renamed from: a */
    public final void mo14566a(String str, long j, long j2, int i, C6323b c6323b) {
        AppMethodBeat.m2504i(16448);
        C4990ab.m7416i("MicroMsg.GetChatroomMsgFetcher", "[fetch] chatroomId:" + str + " msgSeq:" + j + " filterSeq:" + j2 + " upDownFlag:" + i);
        this.fCo = c6323b;
        ahc ahc = new ahc();
        ahc.wnA = C1946aa.m4154vy(str);
        ahc.vEI = (int) j;
        ahc.wnE = (int) j2;
        ahc.wnB = 18;
        ahc.wnC = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = ahc;
        c1196a.fsK = new ahd();
        c1196a.uri = "/cgi-bin/micromsg-bin/getcrmsg";
        c1196a.fsI = 805;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        if (this.fCl != null) {
            C1226w.m2659c(this.fCl);
        }
        this.fCl = C1226w.m2655a(c1196a.acD(), this, true);
        this.fCm.stopTimer();
        this.fCm.mo16770ae(8000, 8000);
        AppMethodBeat.m2505o(16448);
    }

    /* renamed from: a */
    public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
        AppMethodBeat.m2504i(16449);
        C4990ab.m7417i("MicroMsg.GetChatroomMsgFetcher", "[callback] errType:%d errCode:%d errMsg:%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        LinkedList linkedList = new LinkedList();
        if (c1207m.getType() != 805) {
            m10395a(c7472b, -1, linkedList);
            AppMethodBeat.m2505o(16449);
            return 0;
        }
        this.fCm.stopTimer();
        if (i == 0 && i2 == 0 && c7472b != null) {
            ahc ahc = (ahc) c7472b.fsG.fsP;
            ahd ahd = (ahd) c7472b.fsH.fsP;
            if (ahd == null || ahd.wnF == null) {
                m10395a(c7472b, -1, linkedList);
                String str2 = "MicroMsg.GetChatroomMsgFetcher";
                String str3 = "[callback] resp == null? %b resp.AddMsgList == null? %b";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(ahd == null);
                objArr[1] = Boolean.valueOf(ahd.wnF == null);
                C4990ab.m7413e(str2, str3, objArr);
                AppMethodBeat.m2505o(16449);
                return 0;
            } else if (ahd.wnF.size() <= 0) {
                C4990ab.m7421w("MicroMsg.GetChatroomMsgFetcher", "[callback] fetch size is 0! [%s:%s] isUpFlag:%s ChatroomId:%s", Integer.valueOf(ahc.vEI), Integer.valueOf(ahc.wnE), Integer.valueOf(ahc.wnC), C1946aa.m4148a(ahc.wnA));
                m10395a(c7472b, 0, linkedList);
                AppMethodBeat.m2505o(16449);
                return 0;
            } else {
                try {
                    C28493i c28493i = (C28493i) C1720g.m3528K(C28493i.class);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15242QW("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                    Iterator it = C6320b.m10394a(ahd.wnF, ahc.wnC == 1, C1946aa.m4148a(ahc.wnA)).iterator();
                    while (it.hasNext()) {
                        C1197a c1197a = (C1197a) it.next();
                        C1198b a = c28493i.mo46464a(c1197a, fCn);
                        if (a == null) {
                            int i3;
                            C7620bi c7620bi;
                            C7254cm c7254cm = c1197a.eAB;
                            C7620bi c7620bi2 = new C7620bi();
                            c7620bi2.mo14774eI(c7254cm.ptF);
                            c7620bi2.mo14775eJ(c1197a.fsX);
                            c7620bi2.mo14777eL((long) c7254cm.vEI);
                            String a2 = C1946aa.m4148a(c7254cm.vEB);
                            String a3 = C1946aa.m4148a(c7254cm.vEC);
                            Object obj = (((C6982j) C1720g.m3528K(C6982j.class)).mo15372XU().has(a2) || ((String) C1720g.m3536RP().mo5239Ry().get(2, (Object) "")).equals(a2)) ? 1 : null;
                            if (obj != null) {
                                c7620bi2.mo14781hO(1);
                                c7620bi2.mo14794ju(a3);
                                i3 = c7254cm.jBT;
                                c7620bi = c7620bi2;
                            } else {
                                c7620bi2.mo14781hO(0);
                                c7620bi2.mo14794ju(a2);
                                if (c7254cm.jBT > 3) {
                                    i3 = c7254cm.jBT;
                                    c7620bi = c7620bi2;
                                } else {
                                    i3 = 3;
                                    c7620bi = c7620bi2;
                                }
                            }
                            c7620bi.setStatus(i3);
                            if (c7254cm.nao == Downloads.MIN_WAIT_FOR_NETWORK) {
                                c7620bi2.setStatus(4);
                            }
                            c7620bi2.mo14783hY(2);
                            linkedList.add(c7620bi2);
                            C4990ab.m7417i("MicroMsg.GetChatroomMsgFetcher", "addMsgReturn == null! addMsgInfo addMsg type:%s", Integer.valueOf(c1197a.eAB.nao));
                        } else if (a.csG == null) {
                            C4990ab.m7412e("MicroMsg.GetChatroomMsgFetcher", "ddMsgReturn.msg == null！may be revoke msg");
                        } else {
                            linkedList.add(a.csG);
                        }
                    }
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15243QX("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                    C4990ab.m7416i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + C1946aa.m4148a(ahc.wnA) + " AddMsgList size:" + ahd.wnF.size());
                    m10395a(c7472b, 0, linkedList);
                    AppMethodBeat.m2505o(16449);
                    return 0;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15243QX("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                    C4990ab.m7416i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + C1946aa.m4148a(ahc.wnA) + " AddMsgList size:" + ahd.wnF.size());
                    m10395a(c7472b, 0, linkedList);
                    AppMethodBeat.m2505o(16449);
                }
            }
        } else {
            m10395a(c7472b, -1, linkedList);
            AppMethodBeat.m2505o(16449);
            return 0;
        }
    }

    /* renamed from: a */
    private void m10395a(C7472b c7472b, int i, LinkedList<C7620bi> linkedList) {
        AppMethodBeat.m2504i(16450);
        C4990ab.m7420w("MicroMsg.GetChatroomMsgFetcher", "[requestCallback] ret:".concat(String.valueOf(i)));
        if (c7472b == null) {
            C23797b c23797b = C23797b.yZH;
            C23797b.dGY();
            if (this.fCo != null) {
                this.fCo.mo4575b(i, linkedList);
            }
            AppMethodBeat.m2505o(16450);
            return;
        }
        ahc ahc = (ahc) c7472b.fsG.fsP;
        ahd ahd = (ahd) c7472b.fsH.fsP;
        if (this.fCk != null && i >= 0) {
            this.fCk.mo14567a(C1946aa.m4148a(ahc.wnA), ahc.wnC == 1, linkedList, C6320b.m10399w((long) ahc.wnE, (long) ahc.vEI), ahd.vQe == 0);
        }
        if (this.fCo != null) {
            this.fCo.mo4575b(i, linkedList);
        }
        C23797b.yZH.mo39621c(ahc.wnC == 0, i >= 0, C1946aa.m4148a(ahc.wnA));
        if (i >= 0) {
            C23797b.yZH.mo39620Pi(linkedList.size());
        }
        AppMethodBeat.m2505o(16450);
    }

    /* renamed from: a */
    private static LinkedList<C1197a> m10394a(List<C7254cm> list, boolean z, String str) {
        AppMethodBeat.m2504i(16451);
        long QQ = ((C6982j) C1720g.m3528K(C6982j.class)).mo15373Yo().mo7908QQ(str);
        LinkedList linkedList = new LinkedList();
        long j = 0;
        Iterator it = list.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                Object c1197a;
                C7254cm c7254cm = (C7254cm) it.next();
                long j3 = ((long) c7254cm.pcX) * 1000;
                if (j2 == 0) {
                    C7620bi Y = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15280Y(C1946aa.m4148a(c7254cm.vEB), (long) c7254cm.vEI);
                    if (Y.field_createTime / 1000 == ((long) c7254cm.pcX)) {
                        j3 = Y.field_createTime + 1;
                    }
                }
                if (j2 / 1000 == j3 / 1000) {
                    j3 = 1 + j2;
                    c1197a = new C1197a(c7254cm, z, j3);
                    j = j3;
                } else {
                    c1197a = new C1197a(c7254cm, z, j3);
                    j = j3;
                }
                if (QQ < j) {
                    linkedList.add(c1197a);
                } else {
                    C4990ab.m7421w("MicroMsg.GetChatroomMsgFetcher", "this conversation[%s] has delete before! lastDeleteCreateTime:%s curTime:%s", str, Long.valueOf(QQ), Long.valueOf(j));
                }
            } else {
                AppMethodBeat.m2505o(16451);
                return linkedList;
            }
        }
    }

    /* renamed from: w */
    private static C6594c m10399w(long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.m2504i(16452);
        if (j > j2) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        C6594c c6594c = new C6594c();
        c6594c.eoC = j4;
        c6594c.eoD = j3;
        AppMethodBeat.m2505o(16452);
        return c6594c;
    }

    /* renamed from: rX */
    public static void m10398rX(String str) {
        AppMethodBeat.m2504i(16453);
        if (((C6982j) C1720g.m3528K(C6982j.class)).bOm().mo15216QL(str)) {
            C4990ab.m7417i("MicroMsg.GetChatroomMsgFetcher", "[clearConversationDeliverCount] username:%s", str);
            ahc ahc = new ahc();
            ahc.wnA = C1946aa.m4154vy(str);
            ahc.vEI = 0;
            ahc.wnE = 0;
            ahc.wnB = 0;
            ahc.wnC = 0;
            C1196a c1196a = new C1196a();
            c1196a.fsJ = ahc;
            c1196a.fsK = new ahd();
            c1196a.uri = "/cgi-bin/micromsg-bin/getcrmsg";
            c1196a.fsI = 805;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C1226w.m2657b(c1196a.acD());
        }
        AppMethodBeat.m2505o(16453);
    }
}
