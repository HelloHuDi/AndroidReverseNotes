package com.tencent.p177mm.modelvideo;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.modelvideo.C9720t.C9721a;
import com.tencent.p177mm.modelvideo.C9720t.C9721a.C9718a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.tencent.mm.modelvideo.y */
public final class C42229y {
    public static String fXG = null;

    /* renamed from: com.tencent.mm.modelvideo.y$a */
    public static class C26495a implements C1202f, C9721a {
        private static int cqX = 0;
        Queue<String> cqQ = new LinkedList();
        Queue<String> cqR = new LinkedList();
        Map<String, C1446a> cqS = new HashMap();
        boolean cqT = false;
        private boolean cqU = false;
        int cqV = 0;
        private long cqW = 0;
        C1446a cqZ = new C1446a();
        private C7564ap cra = null;
        private VideoTransPara fWR = null;
        private VideoTransPara fWS = null;
        HandlerThread fXH = C7305d.m12297ek("VideoService_runThread", 0);
        C7306ak fXI;
        boolean fXJ = false;
        private List<C45460w> fXK = new ArrayList();
        Queue<String> fXL = new LinkedList();
        Queue<String> fXM = new LinkedList();
        C6689d fXN = null;
        C32842g fXO = null;
        private HashMap<String, C9721a> fXP = new HashMap();
        private boolean running = false;

        /* renamed from: com.tencent.mm.modelvideo.y$a$1 */
        class C97271 implements C5015a {
            C97271() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(50866);
                C26495a.m42277a(C26495a.this);
                AppMethodBeat.m2505o(50866);
                return false;
            }

            public final String toString() {
                AppMethodBeat.m2504i(50867);
                String str = super.toString() + "|scenePusher";
                AppMethodBeat.m2505o(50867);
                return str;
            }
        }

        /* renamed from: com.tencent.mm.modelvideo.y$a$3 */
        class C97293 implements Runnable {
            C97293() {
            }

            public final void run() {
                AppMethodBeat.m2504i(50870);
                long currentTimeMillis = System.currentTimeMillis() - C26495a.this.cqW;
                C4990ab.m7410d("MicroMsg.VideoService", "Try Run service runningFlag:" + C26495a.this.running + " timeWait:" + currentTimeMillis + " sending:" + C26495a.this.cqU + " recving:" + C26495a.this.cqT);
                if (C26495a.this.running) {
                    if (currentTimeMillis < 60000) {
                        AppMethodBeat.m2505o(50870);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.VideoService", "ERR: Try Run service runningFlag:" + C26495a.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C26495a.this.cqU + " recving:" + C26495a.this.cqT);
                }
                C26495a.this.cqV = 3;
                C26495a.this.running = true;
                C26495a.this.cqU = false;
                C26495a.this.cqT = false;
                C26495a.this.fXO = null;
                C26495a.this.fXN = null;
                C26495a.this.cqZ.evE = SystemClock.elapsedRealtime();
                C26495a.this.cra.mo16770ae(10, 10);
                AppMethodBeat.m2505o(50870);
            }

            public final String toString() {
                AppMethodBeat.m2504i(50871);
                String str = super.toString() + "|run";
                AppMethodBeat.m2505o(50871);
                return str;
            }
        }

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

        /* renamed from: k */
        static /* synthetic */ void m42287k(C26495a c26495a) {
            AppMethodBeat.m2504i(50885);
            c26495a.m42275Fb();
            AppMethodBeat.m2505o(50885);
        }

        public C26495a() {
            AppMethodBeat.m2504i(50873);
            C1720g.m3540Rg().mo14539a(149, (C1202f) this);
            C1720g.m3540Rg().mo14539a(150, (C1202f) this);
            C37961o.all().mo21053a(this, Looper.getMainLooper());
            this.fXH.start();
            this.fXJ = true;
            this.fXI = new C7306ak(this.fXH.getLooper());
            this.cra = new C7564ap(this.fXH.getLooper(), new C97271(), false);
            C4990ab.m7416i("MicroMsg.VideoService", "create VideoService, start video send thread");
            AppMethodBeat.m2505o(50873);
        }

        /* renamed from: a */
        public final void mo44277a(C45460w c45460w) {
            AppMethodBeat.m2504i(50874);
            C4990ab.m7409c("MicroMsg.VideoService", "addVideoMsgSendCallback %s", c45460w);
            if (!(c45460w == null || this.fXK == null || this.fXK.contains(c45460w))) {
                this.fXK.add(c45460w);
            }
            AppMethodBeat.m2505o(50874);
        }

        /* renamed from: b */
        public final void mo44281b(C45460w c45460w) {
            AppMethodBeat.m2504i(50875);
            if (!(c45460w == null || this.fXK == null)) {
                this.fXK.remove(c45460w);
            }
            AppMethodBeat.m2505o(50875);
        }

        public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
            AppMethodBeat.m2504i(50876);
            if (this.fXH == null || !this.fXJ || this.fXI == null) {
                C4990ab.m7412e("MicroMsg.VideoService", "onSceneEnd error!, handler or thread is null!");
                AppMethodBeat.m2505o(50876);
                return;
            }
            this.fXI.post(new Runnable() {
                public final void run() {
                    int i;
                    Object obj;
                    AppMethodBeat.m2504i(50868);
                    C26495a.acr();
                    String str;
                    if (c1207m.getType() == 150) {
                        C26495a.this.cqT = false;
                        str = ((C6689d) c1207m).fileName;
                        C42229y.fXG = str;
                        int i2 = ((C6689d) c1207m).retCode;
                        C26495a.this.fXN = null;
                        i = i2;
                        obj = str;
                    } else if (c1207m.getType() == 149) {
                        C26495a.this.cqU = false;
                        C26495a.this.fXO = null;
                        String obj2;
                        if (c1207m instanceof C32842g) {
                            str = ((C32842g) c1207m).fileName;
                            i = ((C32842g) c1207m).retCode;
                            obj2 = str;
                        } else if (c1207m instanceof C32845h) {
                            i = 0;
                            obj2 = ((C32845h) c1207m).fileName;
                        } else {
                            i = 0;
                            obj2 = null;
                        }
                    } else {
                        C4990ab.m7412e("MicroMsg.VideoService", "onSceneEnd Error SceneType:" + c1207m.getType());
                        C26495a.alI();
                        AppMethodBeat.m2505o(50868);
                        return;
                    }
                    long j = 0;
                    if (!(obj2 == null || C26495a.this.cqS.get(obj2) == null)) {
                        j = ((C1446a) C26495a.this.cqS.get(obj2)).mo4908Mr();
                        C26495a.this.cqS.remove(obj2);
                    }
                    C4990ab.m7410d("MicroMsg.VideoService", "onSceneEnd SceneType:" + c1207m.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + obj2 + " time:" + j);
                    if (i == 3 && i != 0) {
                        C26495a.this.cqV = C26495a.this.cqV - 1;
                    } else if (i != 0) {
                        C26495a.this.cqV = 0;
                    }
                    C4990ab.m7410d("MicroMsg.VideoService", "onSceneEnd  inCnt:" + C26495a.cqX + " stop:" + C26495a.this.cqV + " running:" + C26495a.this.running + " recving:" + C26495a.this.cqT + " sending:" + C26495a.this.cqU);
                    if (C26495a.this.cqV > 0) {
                        C26495a.m42277a(C26495a.this);
                    } else if (!(C26495a.this.cqU || C26495a.this.cqT)) {
                        C26495a.m42287k(C26495a.this);
                    }
                    C26495a.alI();
                    AppMethodBeat.m2505o(50868);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(50869);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.m2505o(50869);
                    return str;
                }
            });
            AppMethodBeat.m2505o(50876);
        }

        /* renamed from: Fb */
        private void m42275Fb() {
            AppMethodBeat.m2504i(50877);
            this.cqS.clear();
            this.cqQ.clear();
            this.cqR.clear();
            this.fXL.clear();
            this.fXM.clear();
            this.cqU = false;
            this.cqT = false;
            this.running = false;
            C4990ab.m7416i("MicroMsg.VideoService", "Finish service use time(ms):" + this.cqZ.mo4908Mr());
            AppMethodBeat.m2505o(50877);
        }

        public final void run() {
            AppMethodBeat.m2504i(50878);
            if (this.fXH == null || !this.fXJ || this.fXI == null) {
                C4990ab.m7412e("MicroMsg.VideoService", "run error!, handler or thread is null!");
                AppMethodBeat.m2505o(50878);
                return;
            }
            this.fXI.post(new C97293());
            AppMethodBeat.m2505o(50878);
        }

        public final boolean alG() {
            boolean z;
            AppMethodBeat.m2504i(50879);
            if (this.fXN != null) {
                C1720g.m3540Rg().mo14547c(this.fXN);
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
            AppMethodBeat.m2505o(50879);
            return z;
        }

        public final void alH() {
            AppMethodBeat.m2504i(50880);
            C1720g.m3540Rg().mo14547c(this.fXN);
            m42275Fb();
            AppMethodBeat.m2505o(50880);
        }

        /* renamed from: uC */
        public final void mo44283uC(String str) {
            AppMethodBeat.m2504i(50881);
            this.cqS.remove(str);
            AppMethodBeat.m2505o(50881);
        }

        /* renamed from: a */
        public final void mo44278a(final String str, C9721a c9721a) {
            AppMethodBeat.m2504i(50882);
            this.fXP.put(str, c9721a);
            C1720g.m3539RS().mo10302aa(new Runnable() {
                final /* synthetic */ int fXR = 3;

                public final void run() {
                    AppMethodBeat.m2504i(50872);
                    C26494u.m42244ag(str, this.fXR);
                    C26493s ut = C26494u.m42268ut(str);
                    if (!(ut == null || ut.status == 199)) {
                        if (ut.aly()) {
                            C4990ab.m7416i("MicroMsg.VideoService", "start complete online video");
                            C26494u.m42259uA(str);
                            AppMethodBeat.m2505o(50872);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.VideoService", "start complete offline video");
                        C26494u.m42264up(str);
                    }
                    AppMethodBeat.m2505o(50872);
                }
            });
            AppMethodBeat.m2505o(50882);
        }

        /* renamed from: a */
        public final void mo11381a(C9718a c9718a) {
            AppMethodBeat.m2504i(50883);
            C9721a c9721a = (C9721a) this.fXP.get(c9718a.fileName);
            if (c9721a != null) {
                c9721a.mo11381a(c9718a);
            }
            C26493s ut = C26494u.m42268ut(c9718a.fileName);
            if (ut != null && ut.status == 199) {
                this.fXP.remove(c9718a.fileName);
            }
            AppMethodBeat.m2505o(50883);
        }
    }
}
