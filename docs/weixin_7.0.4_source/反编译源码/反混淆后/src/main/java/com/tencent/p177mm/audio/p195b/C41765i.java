package com.tencent.p177mm.audio.p195b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.modelvoice.C37964e;
import com.tencent.p177mm.modelvoice.C45461f;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.view.C31128d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.tencent.mm.audio.b.i */
public final class C41765i implements C1202f {
    private static int cqX = 0;
    public static boolean cqY = true;
    Queue<String> cqQ = new LinkedList();
    Queue<C32849p> cqR = new LinkedList();
    Map<String, C1446a> cqS = new HashMap();
    private boolean cqT = false;
    private boolean cqU = false;
    public int cqV = 0;
    private long cqW = 0;
    C1446a cqZ = new C1446a();
    private C7564ap cra = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C417663(), false);
    private boolean running = false;

    /* renamed from: com.tencent.mm.audio.b.i$2 */
    class C323122 implements Runnable {
        C323122() {
        }

        public final void run() {
            AppMethodBeat.m2504i(116519);
            long currentTimeMillis = System.currentTimeMillis() - C41765i.this.cqW;
            C4990ab.m7416i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + C41765i.this.running + " timeWait:" + currentTimeMillis + " sending:" + C41765i.this.cqU + " recving:" + C41765i.this.cqT);
            if (C41765i.this.running) {
                if (currentTimeMillis < 60000) {
                    AppMethodBeat.m2505o(116519);
                    return;
                }
                C4990ab.m7412e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + C41765i.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + C41765i.this.cqU + " recving:" + C41765i.this.cqT);
            }
            C41765i.this.running = true;
            C41765i.this.cqU = false;
            C41765i.this.cqV = 3;
            C41765i.this.cqT = false;
            C41765i.this.cqZ.evE = SystemClock.elapsedRealtime();
            C41765i.this.cra.mo16770ae(10, 10);
            AppMethodBeat.m2505o(116519);
        }

        public final String toString() {
            AppMethodBeat.m2504i(116520);
            String str = super.toString() + "|run";
            AppMethodBeat.m2505o(116520);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.audio.b.i$3 */
    class C417663 implements C5015a {
        C417663() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(116521);
            C4990ab.m7410d("MicroMsg.SceneVoiceService", "onTimerExpired");
            C41765i.m73716h(C41765i.this);
            AppMethodBeat.m2505o(116521);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(116522);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.m2505o(116522);
            return str;
        }
    }

    /* renamed from: Fc */
    static /* synthetic */ int m73706Fc() {
        int i = cqX;
        cqX = i + 1;
        return i;
    }

    /* renamed from: Fd */
    static /* synthetic */ int m73707Fd() {
        int i = cqX;
        cqX = i - 1;
        return i;
    }

    /* renamed from: i */
    static /* synthetic */ void m73717i(C41765i c41765i) {
        AppMethodBeat.m2504i(116528);
        c41765i.m73705Fb();
        AppMethodBeat.m2505o(116528);
    }

    public C41765i() {
        AppMethodBeat.m2504i(116523);
        C1720g.m3540Rg().mo14539a((int) C31128d.MIC_SketchMark, (C1202f) this);
        C1720g.m3540Rg().mo14539a(128, (C1202f) this);
        AppMethodBeat.m2505o(116523);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
        AppMethodBeat.m2504i(116524);
        C1720g.m3539RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.audio.b.i$1$1 */
            class C90481 implements Runnable {
                C90481() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(116516);
                    C4990ab.m7416i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                    C41765i.this.run();
                    AppMethodBeat.m2505o(116516);
                }
            }

            public final void run() {
                int i;
                Object obj;
                AppMethodBeat.m2504i(116517);
                C41765i.m73706Fc();
                String str;
                if (c1207m.getType() == 128) {
                    C41765i.this.cqT = false;
                    str = ((C37964e) c1207m).fileName;
                    i = ((C37964e) c1207m).retCode;
                    obj = str;
                } else if (c1207m.getType() == C31128d.MIC_SketchMark) {
                    C41765i.this.cqU = false;
                    str = ((C45461f) c1207m).fileName;
                    i = ((C45461f) c1207m).retCode;
                    String obj2 = str;
                } else {
                    C4990ab.m7412e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + c1207m.getType());
                    C41765i.m73707Fd();
                    AppMethodBeat.m2505o(116517);
                    return;
                }
                long j = 0;
                if (!(obj2 == null || C41765i.this.cqS.get(obj2) == null)) {
                    j = ((C1446a) C41765i.this.cqS.get(obj2)).mo4908Mr();
                    C41765i.this.cqS.remove(obj2);
                }
                C4990ab.m7416i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + c1207m.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + obj2 + " time:" + j);
                if (i == 3 && i != 0) {
                    C41765i.this.cqV = C41765i.this.cqV - 1;
                } else if (i != 0) {
                    C41765i.this.cqV = 0;
                }
                C4990ab.m7416i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + C41765i.cqX + " stop:" + C41765i.this.cqV + " running:" + C41765i.this.running + " recving:" + C41765i.this.cqT + " sending:" + C41765i.this.cqU);
                if (C41765i.this.cqV > 0) {
                    C41765i.m73716h(C41765i.this);
                } else if (!(C41765i.this.cqU || C41765i.this.cqT)) {
                    C41765i.m73717i(C41765i.this);
                    C4990ab.m7417i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", Integer.valueOf(i), Integer.valueOf(i), Boolean.valueOf(C41765i.cqY));
                    if (C41765i.cqY && i == 4) {
                        C1720g.m3539RS().mo10310m(new C90481(), 10000);
                    }
                }
                C41765i.m73707Fd();
                AppMethodBeat.m2505o(116517);
            }

            public final String toString() {
                AppMethodBeat.m2504i(116518);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.m2505o(116518);
                return str;
            }
        });
        AppMethodBeat.m2505o(116524);
    }

    /* renamed from: Fb */
    private void m73705Fb() {
        AppMethodBeat.m2504i(116525);
        this.cqS.clear();
        this.cqQ.clear();
        this.cqR.clear();
        this.cqU = false;
        this.cqT = false;
        this.running = false;
        C4990ab.m7416i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.cqZ.mo4908Mr());
        AppMethodBeat.m2505o(116525);
    }

    public final void run() {
        AppMethodBeat.m2504i(116526);
        C1720g.m3539RS().mo10302aa(new C323122());
        AppMethodBeat.m2505o(116526);
    }

    /* renamed from: h */
    static /* synthetic */ void m73716h(C41765i c41765i) {
        C32849p c32849p;
        AppMethodBeat.m2504i(116527);
        c41765i.cqW = System.currentTimeMillis();
        if ((!c41765i.cqT && c41765i.cqR.size() == 0) || (!c41765i.cqU && c41765i.cqQ.size() == 0)) {
            List<C32849p> amf = C32850q.amf();
            if (!(amf == null || amf.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String mx = C5046bo.m7579mx(currentTimeMillis);
                for (C32849p c32849p2 : amf) {
                    if (c41765i.cqS.containsKey(c32849p2.fileName)) {
                        C4990ab.m7410d("MicroMsg.SceneVoiceService", "File is Already running:" + c32849p2.fileName);
                    } else {
                        C4990ab.m7416i("MicroMsg.SceneVoiceService", "Get file:" + c32849p2.fileName + " status:" + c32849p2.status + " user" + c32849p2.cIS + " human:" + c32849p2.fWW + " create:" + C5046bo.m7579mx(c32849p2.createTime) + " last:" + C5046bo.m7579mx(c32849p2.fXb) + " now:" + C5046bo.m7579mx(currentTimeMillis) + " " + (currentTimeMillis - c32849p2.fXb));
                        if (c32849p2.amd()) {
                            if (currentTimeMillis - c32849p2.fXb > 80 && c32849p2.status == 5) {
                                C4990ab.m7412e("MicroMsg.SceneVoiceService", "time out file: " + c32849p2.fileName + " last:" + C5046bo.m7579mx(c32849p2.fXb) + " now:" + mx + " msgLocalId:" + c32849p2.fXe + " status:" + c32849p2.status);
                                if (c32849p2.fXe == 0) {
                                    c32849p2.fXb = System.currentTimeMillis() / 1000;
                                    c32849p2.bJt = 320;
                                    C26500m.ama().mo33982a(c32849p2.fileName, c32849p2);
                                } else {
                                    C32850q.m53738um(c32849p2.fileName);
                                }
                            }
                            if (currentTimeMillis - c32849p2.fXb > 300 && c32849p2.status == 6) {
                                C4990ab.m7412e("MicroMsg.SceneVoiceService", "time out file: " + c32849p2.fileName + " last:" + C5046bo.m7579mx(c32849p2.fXb) + " now:" + mx + " msgLocalId:" + c32849p2.fXe + " status:" + c32849p2.status);
                                if (c32849p2.fXe == 0) {
                                    c32849p2.fXb = System.currentTimeMillis() / 1000;
                                    c32849p2.bJt = 320;
                                    C26500m.ama().mo33982a(c32849p2.fileName, c32849p2);
                                } else {
                                    C32850q.m53738um(c32849p2.fileName);
                                }
                            }
                            if (c32849p2.fWY >= c32849p2.fVG) {
                                C4990ab.m7416i("MicroMsg.SceneVoiceService", "file: " + c32849p2.fileName + " stat:" + c32849p2.status + " now:" + c32849p2.fWY + " net:" + c32849p2.fVG);
                            } else {
                                c41765i.cqR.offer(c32849p2);
                                c41765i.cqS.put(c32849p2.fileName, null);
                            }
                        }
                        if (c32849p2.ame()) {
                            C4990ab.m7416i("MicroMsg.SceneVoiceService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + c32849p2.fXb + "  info.getStatus() " + c32849p2.status + "  info.getCreateTime() " + c32849p2.createTime);
                            if (currentTimeMillis - c32849p2.fXb > 10 && (c32849p2.status == 2 || c32849p2.status == 1)) {
                                C4990ab.m7412e("MicroMsg.SceneVoiceService", "time out file: " + c32849p2.fileName + " last:" + C5046bo.m7579mx(c32849p2.fXb) + " now:" + mx);
                                C32850q.m53738um(c32849p2.fileName);
                            } else if (currentTimeMillis - c32849p2.createTime > 600 && c32849p2.status == 3) {
                                C4990ab.m7412e("MicroMsg.SceneVoiceService", "time out file: " + c32849p2.fileName + " last:" + C5046bo.m7579mx(c32849p2.fXb) + " now:" + mx);
                                C32850q.m53738um(c32849p2.fileName);
                            } else if (c32849p2.cIS.length() <= 0) {
                                C4990ab.m7412e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + c32849p2.fileName);
                            } else {
                                c41765i.cqQ.offer(c32849p2.fileName);
                                c41765i.cqS.put(c32849p2.fileName, null);
                            }
                        }
                    }
                }
                C4990ab.m7416i("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + c41765i.cqS.size() + " [recv:" + c41765i.cqR.size() + ",send:" + c41765i.cqQ.size() + "]");
                c41765i.cqR.size();
                c41765i.cqQ.size();
            }
        }
        if (c41765i.cqT || c41765i.cqR.size() != 0 || c41765i.cqU || c41765i.cqQ.size() != 0) {
            if (!c41765i.cqT && c41765i.cqR.size() > 0) {
                Object obj;
                c32849p2 = (C32849p) c41765i.cqR.poll();
                String str = c32849p2.fileName;
                if (((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15342jh(c32849p2.cKK)) {
                    C4990ab.m7417i("MicroMsg.SceneVoiceService", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(c32849p2.cKK));
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    C4990ab.m7416i("MicroMsg.SceneVoiceService", "Start Recv :".concat(String.valueOf(str)));
                    if (str != null) {
                        c41765i.cqS.put(str, new C1446a());
                        c41765i.cqT = true;
                        C1720g.m3540Rg().mo14541a(new C37964e(c32849p2), 0);
                    }
                } else if (C5046bo.nullAsNil(c32849p2.fileName).length() > 0) {
                    C26500m.ama().mo33986pI(c32849p2.fileName);
                    AppMethodBeat.m2505o(116527);
                    return;
                } else {
                    C4990ab.m7416i("MicroMsg.SceneVoiceService", "[oneliang] the length of voice info file name is zero");
                    AppMethodBeat.m2505o(116527);
                    return;
                }
            }
            if (!c41765i.cqU && c41765i.cqQ.size() > 0) {
                String str2 = (String) c41765i.cqQ.poll();
                C4990ab.m7416i("MicroMsg.SceneVoiceService", "Start Send :".concat(String.valueOf(str2)));
                if (str2 != null) {
                    c41765i.cqS.put(str2, new C1446a());
                    c41765i.cqU = true;
                    C1720g.m3540Rg().mo14541a(new C45461f(str2), 0);
                }
            }
            AppMethodBeat.m2505o(116527);
            return;
        }
        c41765i.m73705Fb();
        C4990ab.m7416i("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
        AppMethodBeat.m2505o(116527);
    }
}
