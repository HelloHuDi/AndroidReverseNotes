package com.tencent.mm.modelvideo;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class y {
    public static String fXG = null;

    public static class a implements f, com.tencent.mm.modelvideo.t.a {
        private static int cqX = 0;
        Queue<String> cqQ = new LinkedList();
        Queue<String> cqR = new LinkedList();
        Map<String, com.tencent.mm.compatible.util.g.a> cqS = new HashMap();
        boolean cqT = false;
        private boolean cqU = false;
        int cqV = 0;
        private long cqW = 0;
        com.tencent.mm.compatible.util.g.a cqZ = new com.tencent.mm.compatible.util.g.a();
        private ap cra = null;
        private VideoTransPara fWR = null;
        private VideoTransPara fWS = null;
        HandlerThread fXH = d.ek("VideoService_runThread", 0);
        ak fXI;
        boolean fXJ = false;
        private List<w> fXK = new ArrayList();
        Queue<String> fXL = new LinkedList();
        Queue<String> fXM = new LinkedList();
        d fXN = null;
        g fXO = null;
        private HashMap<String, com.tencent.mm.modelvideo.t.a> fXP = new HashMap();
        private boolean running = false;

        static /* synthetic */ int acr() {
            int i = cqX;
            cqX = i + 1;
            return i;
        }

        static /* synthetic */ int alI() {
            int i = cqX;
            cqX = i - 1;
            return i;
        }

        static /* synthetic */ void k(a aVar) {
            AppMethodBeat.i(50885);
            aVar.Fb();
            AppMethodBeat.o(50885);
        }

        public a() {
            AppMethodBeat.i(50873);
            g.Rg().a(149, (f) this);
            g.Rg().a(150, (f) this);
            o.all().a(this, Looper.getMainLooper());
            this.fXH.start();
            this.fXJ = true;
            this.fXI = new ak(this.fXH.getLooper());
            this.cra = new ap(this.fXH.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(50866);
                    a.a(a.this);
                    AppMethodBeat.o(50866);
                    return false;
                }

                public final String toString() {
                    AppMethodBeat.i(50867);
                    String str = super.toString() + "|scenePusher";
                    AppMethodBeat.o(50867);
                    return str;
                }
            }, false);
            ab.i("MicroMsg.VideoService", "create VideoService, start video send thread");
            AppMethodBeat.o(50873);
        }

        public final void a(w wVar) {
            AppMethodBeat.i(50874);
            ab.c("MicroMsg.VideoService", "addVideoMsgSendCallback %s", wVar);
            if (!(wVar == null || this.fXK == null || this.fXK.contains(wVar))) {
                this.fXK.add(wVar);
            }
            AppMethodBeat.o(50874);
        }

        public final void b(w wVar) {
            AppMethodBeat.i(50875);
            if (!(wVar == null || this.fXK == null)) {
                this.fXK.remove(wVar);
            }
            AppMethodBeat.o(50875);
        }

        public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
            AppMethodBeat.i(50876);
            if (this.fXH == null || !this.fXJ || this.fXI == null) {
                ab.e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
                AppMethodBeat.o(50876);
                return;
            }
            this.fXI.post(new Runnable() {
                public final void run() {
                    int i;
                    Object obj;
                    AppMethodBeat.i(50868);
                    a.acr();
                    String str;
                    if (mVar.getType() == 150) {
                        a.this.cqT = false;
                        str = ((d) mVar).fileName;
                        y.fXG = str;
                        int i2 = ((d) mVar).retCode;
                        a.this.fXN = null;
                        i = i2;
                        obj = str;
                    } else if (mVar.getType() == 149) {
                        a.this.cqU = false;
                        a.this.fXO = null;
                        String obj2;
                        if (mVar instanceof g) {
                            str = ((g) mVar).fileName;
                            i = ((g) mVar).retCode;
                            obj2 = str;
                        } else if (mVar instanceof h) {
                            i = 0;
                            obj2 = ((h) mVar).fileName;
                        } else {
                            i = 0;
                            obj2 = null;
                        }
                    } else {
                        ab.e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + mVar.getType());
                        a.alI();
                        AppMethodBeat.o(50868);
                        return;
                    }
                    long j = 0;
                    if (!(obj2 == null || a.this.cqS.get(obj2) == null)) {
                        j = ((com.tencent.mm.compatible.util.g.a) a.this.cqS.get(obj2)).Mr();
                        a.this.cqS.remove(obj2);
                    }
                    ab.d("MicroMsg.VideoService", "onSceneEnd SceneType:" + mVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + obj2 + " time:" + j);
                    if (i == 3 && i != 0) {
                        a.this.cqV = a.this.cqV - 1;
                    } else if (i != 0) {
                        a.this.cqV = 0;
                    }
                    ab.d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + a.cqX + " stop:" + a.this.cqV + " running:" + a.this.running + " recving:" + a.this.cqT + " sending:" + a.this.cqU);
                    if (a.this.cqV > 0) {
                        a.a(a.this);
                    } else if (!(a.this.cqU || a.this.cqT)) {
                        a.k(a.this);
                    }
                    a.alI();
                    AppMethodBeat.o(50868);
                }

                public final String toString() {
                    AppMethodBeat.i(50869);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.o(50869);
                    return str;
                }
            });
            AppMethodBeat.o(50876);
        }

        private void Fb() {
            AppMethodBeat.i(50877);
            this.cqS.clear();
            this.cqQ.clear();
            this.cqR.clear();
            this.fXL.clear();
            this.fXM.clear();
            this.cqU = false;
            this.cqT = false;
            this.running = false;
            ab.i("MicroMsg.VideoService", "Finish service use time(ms):" + this.cqZ.Mr());
            AppMethodBeat.o(50877);
        }

        public final void run() {
            AppMethodBeat.i(50878);
            if (this.fXH == null || !this.fXJ || this.fXI == null) {
                ab.e("MicroMsg.VideoService", "run error!, handler or thread is null!");
                AppMethodBeat.o(50878);
                return;
            }
            this.fXI.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(50870);
                    long currentTimeMillis = System.currentTimeMillis() - a.this.cqW;
                    ab.d("MicroMsg.VideoService", "Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + " sending:" + a.this.cqU + " recving:" + a.this.cqT);
                    if (a.this.running) {
                        if (currentTimeMillis < 60000) {
                            AppMethodBeat.o(50870);
                            return;
                        }
                        ab.e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + a.this.cqU + " recving:" + a.this.cqT);
                    }
                    a.this.cqV = 3;
                    a.this.running = true;
                    a.this.cqU = false;
                    a.this.cqT = false;
                    a.this.fXO = null;
                    a.this.fXN = null;
                    a.this.cqZ.evE = SystemClock.elapsedRealtime();
                    a.this.cra.ae(10, 10);
                    AppMethodBeat.o(50870);
                }

                public final String toString() {
                    AppMethodBeat.i(50871);
                    String str = super.toString() + "|run";
                    AppMethodBeat.o(50871);
                    return str;
                }
            });
            AppMethodBeat.o(50878);
        }

        public final boolean alG() {
            boolean z;
            AppMethodBeat.i(50879);
            if (this.fXN != null) {
                g.Rg().c(this.fXN);
                z = true;
                this.running = false;
            } else {
                z = false;
            }
            this.cqS.clear();
            this.cqQ.clear();
            this.cqR.clear();
            this.fXL.clear();
            this.fXM.clear();
            AppMethodBeat.o(50879);
            return z;
        }

        public final void alH() {
            AppMethodBeat.i(50880);
            g.Rg().c(this.fXN);
            Fb();
            AppMethodBeat.o(50880);
        }

        public final void uC(String str) {
            AppMethodBeat.i(50881);
            this.cqS.remove(str);
            AppMethodBeat.o(50881);
        }

        public final void a(final String str, com.tencent.mm.modelvideo.t.a aVar) {
            AppMethodBeat.i(50882);
            this.fXP.put(str, aVar);
            g.RS().aa(new Runnable() {
                final /* synthetic */ int fXR = 3;

                public final void run() {
                    AppMethodBeat.i(50872);
                    u.ag(str, this.fXR);
                    s ut = u.ut(str);
                    if (!(ut == null || ut.status == 199)) {
                        if (ut.aly()) {
                            ab.i("MicroMsg.VideoService", "start complete online video");
                            u.uA(str);
                            AppMethodBeat.o(50872);
                            return;
                        }
                        ab.i("MicroMsg.VideoService", "start complete offline video");
                        u.up(str);
                    }
                    AppMethodBeat.o(50872);
                }
            });
            AppMethodBeat.o(50882);
        }

        public final void a(com.tencent.mm.modelvideo.t.a.a aVar) {
            AppMethodBeat.i(50883);
            com.tencent.mm.modelvideo.t.a aVar2 = (com.tencent.mm.modelvideo.t.a) this.fXP.get(aVar.fileName);
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
            s ut = u.ut(aVar.fileName);
            if (ut != null && ut.status == 199) {
                this.fXP.remove(aVar.fileName);
            }
            AppMethodBeat.o(50883);
        }
    }
}
