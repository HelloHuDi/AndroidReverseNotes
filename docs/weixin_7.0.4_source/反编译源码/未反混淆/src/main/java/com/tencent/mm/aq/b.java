package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.j.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.notification.d;
import com.tencent.mm.protocal.protobuf.ahc;
import com.tencent.mm.protocal.protobuf.ahd;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b implements com.tencent.mm.ai.w.a {
    private static d fCn = new d(true);
    private static b fCp;
    public a fCk;
    private m fCl;
    private ap fCm = new ap(aw.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(16444);
            ab.i("MicroMsg.GetChatroomMsgFetcher", "timeoutHandler onTimerExpired");
            if (b.this.fCl != null) {
                w.c(b.this.fCl);
                b.this.fCl = null;
            }
            b.a(b.this, new LinkedList());
            AppMethodBeat.o(16444);
            return false;
        }
    }, false);
    private b fCo = new b() {
        public final void b(int i, List<bi> list) {
            AppMethodBeat.i(16445);
            ab.w("MicroMsg.GetChatroomMsgFetcher", "[onFinish] ret:" + i + " addSize:" + list.size());
            AppMethodBeat.o(16445);
        }
    };

    public interface a {
        void a(String str, boolean z, LinkedList<bi> linkedList, c cVar, boolean z2);
    }

    public interface b {
        void b(int i, List<bi> list);
    }

    static /* synthetic */ void a(b bVar, LinkedList linkedList) {
        AppMethodBeat.i(16454);
        bVar.a(null, -1, linkedList);
        AppMethodBeat.o(16454);
    }

    static {
        AppMethodBeat.i(16455);
        AppMethodBeat.o(16455);
    }

    private b() {
        AppMethodBeat.i(16446);
        AppMethodBeat.o(16446);
    }

    public static b agG() {
        AppMethodBeat.i(16447);
        if (fCp == null) {
            synchronized (b.class) {
                try {
                    if (fCp == null) {
                        fCp = new b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(16447);
                    }
                }
            }
        }
        b bVar = fCp;
        AppMethodBeat.o(16447);
        return bVar;
    }

    public final void a(String str, long j, long j2, int i, b bVar) {
        AppMethodBeat.i(16448);
        ab.i("MicroMsg.GetChatroomMsgFetcher", "[fetch] chatroomId:" + str + " msgSeq:" + j + " filterSeq:" + j2 + " upDownFlag:" + i);
        this.fCo = bVar;
        ahc ahc = new ahc();
        ahc.wnA = aa.vy(str);
        ahc.vEI = (int) j;
        ahc.wnE = (int) j2;
        ahc.wnB = 18;
        ahc.wnC = i;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = ahc;
        aVar.fsK = new ahd();
        aVar.uri = "/cgi-bin/micromsg-bin/getcrmsg";
        aVar.fsI = 805;
        aVar.fsL = 0;
        aVar.fsM = 0;
        if (this.fCl != null) {
            w.c(this.fCl);
        }
        this.fCl = w.a(aVar.acD(), this, true);
        this.fCm.stopTimer();
        this.fCm.ae(8000, 8000);
        AppMethodBeat.o(16448);
    }

    public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
        AppMethodBeat.i(16449);
        ab.i("MicroMsg.GetChatroomMsgFetcher", "[callback] errType:%d errCode:%d errMsg:%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
        LinkedList linkedList = new LinkedList();
        if (mVar.getType() != 805) {
            a(bVar, -1, linkedList);
            AppMethodBeat.o(16449);
            return 0;
        }
        this.fCm.stopTimer();
        if (i == 0 && i2 == 0 && bVar != null) {
            ahc ahc = (ahc) bVar.fsG.fsP;
            ahd ahd = (ahd) bVar.fsH.fsP;
            if (ahd == null || ahd.wnF == null) {
                a(bVar, -1, linkedList);
                String str2 = "MicroMsg.GetChatroomMsgFetcher";
                String str3 = "[callback] resp == null? %b resp.AddMsgList == null? %b";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(ahd == null);
                objArr[1] = Boolean.valueOf(ahd.wnF == null);
                ab.e(str2, str3, objArr);
                AppMethodBeat.o(16449);
                return 0;
            } else if (ahd.wnF.size() <= 0) {
                ab.w("MicroMsg.GetChatroomMsgFetcher", "[callback] fetch size is 0! [%s:%s] isUpFlag:%s ChatroomId:%s", Integer.valueOf(ahc.vEI), Integer.valueOf(ahc.wnE), Integer.valueOf(ahc.wnC), aa.a(ahc.wnA));
                a(bVar, 0, linkedList);
                AppMethodBeat.o(16449);
                return 0;
            } else {
                try {
                    i iVar = (i) g.K(i.class);
                    ((j) g.K(j.class)).bOr().QW("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                    Iterator it = a(ahd.wnF, ahc.wnC == 1, aa.a(ahc.wnA)).iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.ai.e.a aVar = (com.tencent.mm.ai.e.a) it.next();
                        com.tencent.mm.ai.e.b a = iVar.a(aVar, fCn);
                        if (a == null) {
                            int i3;
                            bi biVar;
                            cm cmVar = aVar.eAB;
                            bi biVar2 = new bi();
                            biVar2.eI(cmVar.ptF);
                            biVar2.eJ(aVar.fsX);
                            biVar2.eL((long) cmVar.vEI);
                            String a2 = aa.a(cmVar.vEB);
                            String a3 = aa.a(cmVar.vEC);
                            Object obj = (((j) g.K(j.class)).XU().has(a2) || ((String) g.RP().Ry().get(2, (Object) "")).equals(a2)) ? 1 : null;
                            if (obj != null) {
                                biVar2.hO(1);
                                biVar2.ju(a3);
                                i3 = cmVar.jBT;
                                biVar = biVar2;
                            } else {
                                biVar2.hO(0);
                                biVar2.ju(a2);
                                if (cmVar.jBT > 3) {
                                    i3 = cmVar.jBT;
                                    biVar = biVar2;
                                } else {
                                    i3 = 3;
                                    biVar = biVar2;
                                }
                            }
                            biVar.setStatus(i3);
                            if (cmVar.nao == Downloads.MIN_WAIT_FOR_NETWORK) {
                                biVar2.setStatus(4);
                            }
                            biVar2.hY(2);
                            linkedList.add(biVar2);
                            ab.i("MicroMsg.GetChatroomMsgFetcher", "addMsgReturn == null! addMsgInfo addMsg type:%s", Integer.valueOf(aVar.eAB.nao));
                        } else if (a.csG == null) {
                            ab.e("MicroMsg.GetChatroomMsgFetcher", "ddMsgReturn.msg == null！may be revoke msg");
                        } else {
                            linkedList.add(a.csG);
                        }
                    }
                    ((j) g.K(j.class)).bOr().QX("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                    ab.i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + aa.a(ahc.wnA) + " AddMsgList size:" + ahd.wnF.size());
                    a(bVar, 0, linkedList);
                    AppMethodBeat.o(16449);
                    return 0;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    ((j) g.K(j.class)).bOr().QX("MicroMsg.GetChatroomMsgFetcher" + hashCode());
                    ab.i("MicroMsg.GetChatroomMsgFetcher", "[callback] chatroomId:" + aa.a(ahc.wnA) + " AddMsgList size:" + ahd.wnF.size());
                    a(bVar, 0, linkedList);
                    AppMethodBeat.o(16449);
                }
            }
        } else {
            a(bVar, -1, linkedList);
            AppMethodBeat.o(16449);
            return 0;
        }
    }

    private void a(com.tencent.mm.ai.b bVar, int i, LinkedList<bi> linkedList) {
        AppMethodBeat.i(16450);
        ab.w("MicroMsg.GetChatroomMsgFetcher", "[requestCallback] ret:".concat(String.valueOf(i)));
        if (bVar == null) {
            com.tencent.mm.ui.chatting.j.b bVar2 = com.tencent.mm.ui.chatting.j.b.yZH;
            com.tencent.mm.ui.chatting.j.b.dGY();
            if (this.fCo != null) {
                this.fCo.b(i, linkedList);
            }
            AppMethodBeat.o(16450);
            return;
        }
        ahc ahc = (ahc) bVar.fsG.fsP;
        ahd ahd = (ahd) bVar.fsH.fsP;
        if (this.fCk != null && i >= 0) {
            this.fCk.a(aa.a(ahc.wnA), ahc.wnC == 1, linkedList, w((long) ahc.wnE, (long) ahc.vEI), ahd.vQe == 0);
        }
        if (this.fCo != null) {
            this.fCo.b(i, linkedList);
        }
        com.tencent.mm.ui.chatting.j.b.yZH.c(ahc.wnC == 0, i >= 0, aa.a(ahc.wnA));
        if (i >= 0) {
            com.tencent.mm.ui.chatting.j.b.yZH.Pi(linkedList.size());
        }
        AppMethodBeat.o(16450);
    }

    private static LinkedList<com.tencent.mm.ai.e.a> a(List<cm> list, boolean z, String str) {
        AppMethodBeat.i(16451);
        long QQ = ((j) g.K(j.class)).Yo().QQ(str);
        LinkedList linkedList = new LinkedList();
        long j = 0;
        Iterator it = list.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                Object aVar;
                cm cmVar = (cm) it.next();
                long j3 = ((long) cmVar.pcX) * 1000;
                if (j2 == 0) {
                    bi Y = ((j) g.K(j.class)).bOr().Y(aa.a(cmVar.vEB), (long) cmVar.vEI);
                    if (Y.field_createTime / 1000 == ((long) cmVar.pcX)) {
                        j3 = Y.field_createTime + 1;
                    }
                }
                if (j2 / 1000 == j3 / 1000) {
                    j3 = 1 + j2;
                    aVar = new com.tencent.mm.ai.e.a(cmVar, z, j3);
                    j = j3;
                } else {
                    aVar = new com.tencent.mm.ai.e.a(cmVar, z, j3);
                    j = j3;
                }
                if (QQ < j) {
                    linkedList.add(aVar);
                } else {
                    ab.w("MicroMsg.GetChatroomMsgFetcher", "this conversation[%s] has delete before! lastDeleteCreateTime:%s curTime:%s", str, Long.valueOf(QQ), Long.valueOf(j));
                }
            } else {
                AppMethodBeat.o(16451);
                return linkedList;
            }
        }
    }

    private static c w(long j, long j2) {
        long j3;
        long j4;
        AppMethodBeat.i(16452);
        if (j > j2) {
            j3 = j;
            j4 = j2;
        } else {
            j3 = j2;
            j4 = j;
        }
        c cVar = new c();
        cVar.eoC = j4;
        cVar.eoD = j3;
        AppMethodBeat.o(16452);
        return cVar;
    }

    public static void rX(String str) {
        AppMethodBeat.i(16453);
        if (((j) g.K(j.class)).bOm().QL(str)) {
            ab.i("MicroMsg.GetChatroomMsgFetcher", "[clearConversationDeliverCount] username:%s", str);
            ahc ahc = new ahc();
            ahc.wnA = aa.vy(str);
            ahc.vEI = 0;
            ahc.wnE = 0;
            ahc.wnB = 0;
            ahc.wnC = 0;
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = ahc;
            aVar.fsK = new ahd();
            aVar.uri = "/cgi-bin/micromsg-bin/getcrmsg";
            aVar.fsI = 805;
            aVar.fsL = 0;
            aVar.fsM = 0;
            w.b(aVar.acD());
        }
        AppMethodBeat.o(16453);
    }
}
