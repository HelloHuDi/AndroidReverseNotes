package com.tencent.mm.audio.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class i implements f {
    private static int cqX = 0;
    public static boolean cqY = true;
    Queue<String> cqQ = new LinkedList();
    Queue<p> cqR = new LinkedList();
    Map<String, a> cqS = new HashMap();
    private boolean cqT = false;
    private boolean cqU = false;
    public int cqV = 0;
    private long cqW = 0;
    a cqZ = new a();
    private ap cra = new ap(g.RS().oAl.getLooper(), new ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(116521);
            ab.d("MicroMsg.SceneVoiceService", "onTimerExpired");
            i.h(i.this);
            AppMethodBeat.o(116521);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(116522);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(116522);
            return str;
        }
    }, false);
    private boolean running = false;

    static /* synthetic */ int Fc() {
        int i = cqX;
        cqX = i + 1;
        return i;
    }

    static /* synthetic */ int Fd() {
        int i = cqX;
        cqX = i - 1;
        return i;
    }

    static /* synthetic */ void i(i iVar) {
        AppMethodBeat.i(116528);
        iVar.Fb();
        AppMethodBeat.o(116528);
    }

    public i() {
        AppMethodBeat.i(116523);
        g.Rg().a((int) d.MIC_SketchMark, (f) this);
        g.Rg().a(128, (f) this);
        AppMethodBeat.o(116523);
    }

    public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
        AppMethodBeat.i(116524);
        g.RS().aa(new Runnable() {
            public final void run() {
                int i;
                Object obj;
                AppMethodBeat.i(116517);
                i.Fc();
                String str;
                if (mVar.getType() == 128) {
                    i.this.cqT = false;
                    str = ((e) mVar).fileName;
                    i = ((e) mVar).retCode;
                    obj = str;
                } else if (mVar.getType() == d.MIC_SketchMark) {
                    i.this.cqU = false;
                    str = ((com.tencent.mm.modelvoice.f) mVar).fileName;
                    i = ((com.tencent.mm.modelvoice.f) mVar).retCode;
                    String obj2 = str;
                } else {
                    ab.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + mVar.getType());
                    i.Fd();
                    AppMethodBeat.o(116517);
                    return;
                }
                long j = 0;
                if (!(obj2 == null || i.this.cqS.get(obj2) == null)) {
                    j = ((a) i.this.cqS.get(obj2)).Mr();
                    i.this.cqS.remove(obj2);
                }
                ab.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + mVar.getType() + " errtype:" + i + " errCode:" + i2 + " retCode:" + i + " file:" + obj2 + " time:" + j);
                if (i == 3 && i != 0) {
                    i.this.cqV = i.this.cqV - 1;
                } else if (i != 0) {
                    i.this.cqV = 0;
                }
                ab.i("MicroMsg.SceneVoiceService", "onSceneEnd  inCnt:" + i.cqX + " stop:" + i.this.cqV + " running:" + i.this.running + " recving:" + i.this.cqT + " sending:" + i.this.cqU);
                if (i.this.cqV > 0) {
                    i.h(i.this);
                } else if (!(i.this.cqU || i.this.cqT)) {
                    i.i(i.this);
                    ab.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", Integer.valueOf(i), Integer.valueOf(i), Boolean.valueOf(i.cqY));
                    if (i.cqY && i == 4) {
                        g.RS().m(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(116516);
                                ab.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                                i.this.run();
                                AppMethodBeat.o(116516);
                            }
                        }, 10000);
                    }
                }
                i.Fd();
                AppMethodBeat.o(116517);
            }

            public final String toString() {
                AppMethodBeat.i(116518);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(116518);
                return str;
            }
        });
        AppMethodBeat.o(116524);
    }

    private void Fb() {
        AppMethodBeat.i(116525);
        this.cqS.clear();
        this.cqQ.clear();
        this.cqR.clear();
        this.cqU = false;
        this.cqT = false;
        this.running = false;
        ab.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.cqZ.Mr());
        AppMethodBeat.o(116525);
    }

    public final void run() {
        AppMethodBeat.i(116526);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(116519);
                long currentTimeMillis = System.currentTimeMillis() - i.this.cqW;
                ab.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.this.running + " timeWait:" + currentTimeMillis + " sending:" + i.this.cqU + " recving:" + i.this.cqT);
                if (i.this.running) {
                    if (currentTimeMillis < 60000) {
                        AppMethodBeat.o(116519);
                        return;
                    }
                    ab.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + i.this.cqU + " recving:" + i.this.cqT);
                }
                i.this.running = true;
                i.this.cqU = false;
                i.this.cqV = 3;
                i.this.cqT = false;
                i.this.cqZ.evE = SystemClock.elapsedRealtime();
                i.this.cra.ae(10, 10);
                AppMethodBeat.o(116519);
            }

            public final String toString() {
                AppMethodBeat.i(116520);
                String str = super.toString() + "|run";
                AppMethodBeat.o(116520);
                return str;
            }
        });
        AppMethodBeat.o(116526);
    }

    static /* synthetic */ void h(i iVar) {
        p pVar;
        AppMethodBeat.i(116527);
        iVar.cqW = System.currentTimeMillis();
        if ((!iVar.cqT && iVar.cqR.size() == 0) || (!iVar.cqU && iVar.cqQ.size() == 0)) {
            List<p> amf = q.amf();
            if (!(amf == null || amf.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String mx = bo.mx(currentTimeMillis);
                for (p pVar2 : amf) {
                    if (iVar.cqS.containsKey(pVar2.fileName)) {
                        ab.d("MicroMsg.SceneVoiceService", "File is Already running:" + pVar2.fileName);
                    } else {
                        ab.i("MicroMsg.SceneVoiceService", "Get file:" + pVar2.fileName + " status:" + pVar2.status + " user" + pVar2.cIS + " human:" + pVar2.fWW + " create:" + bo.mx(pVar2.createTime) + " last:" + bo.mx(pVar2.fXb) + " now:" + bo.mx(currentTimeMillis) + " " + (currentTimeMillis - pVar2.fXb));
                        if (pVar2.amd()) {
                            if (currentTimeMillis - pVar2.fXb > 80 && pVar2.status == 5) {
                                ab.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bo.mx(pVar2.fXb) + " now:" + mx + " msgLocalId:" + pVar2.fXe + " status:" + pVar2.status);
                                if (pVar2.fXe == 0) {
                                    pVar2.fXb = System.currentTimeMillis() / 1000;
                                    pVar2.bJt = 320;
                                    com.tencent.mm.modelvoice.m.ama().a(pVar2.fileName, pVar2);
                                } else {
                                    q.um(pVar2.fileName);
                                }
                            }
                            if (currentTimeMillis - pVar2.fXb > 300 && pVar2.status == 6) {
                                ab.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bo.mx(pVar2.fXb) + " now:" + mx + " msgLocalId:" + pVar2.fXe + " status:" + pVar2.status);
                                if (pVar2.fXe == 0) {
                                    pVar2.fXb = System.currentTimeMillis() / 1000;
                                    pVar2.bJt = 320;
                                    com.tencent.mm.modelvoice.m.ama().a(pVar2.fileName, pVar2);
                                } else {
                                    q.um(pVar2.fileName);
                                }
                            }
                            if (pVar2.fWY >= pVar2.fVG) {
                                ab.i("MicroMsg.SceneVoiceService", "file: " + pVar2.fileName + " stat:" + pVar2.status + " now:" + pVar2.fWY + " net:" + pVar2.fVG);
                            } else {
                                iVar.cqR.offer(pVar2);
                                iVar.cqS.put(pVar2.fileName, null);
                            }
                        }
                        if (pVar2.ame()) {
                            ab.i("MicroMsg.SceneVoiceService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + pVar2.fXb + "  info.getStatus() " + pVar2.status + "  info.getCreateTime() " + pVar2.createTime);
                            if (currentTimeMillis - pVar2.fXb > 10 && (pVar2.status == 2 || pVar2.status == 1)) {
                                ab.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bo.mx(pVar2.fXb) + " now:" + mx);
                                q.um(pVar2.fileName);
                            } else if (currentTimeMillis - pVar2.createTime > 600 && pVar2.status == 3) {
                                ab.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bo.mx(pVar2.fXb) + " now:" + mx);
                                q.um(pVar2.fileName);
                            } else if (pVar2.cIS.length() <= 0) {
                                ab.e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + pVar2.fileName);
                            } else {
                                iVar.cqQ.offer(pVar2.fileName);
                                iVar.cqS.put(pVar2.fileName, null);
                            }
                        }
                    }
                }
                ab.i("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + iVar.cqS.size() + " [recv:" + iVar.cqR.size() + ",send:" + iVar.cqQ.size() + "]");
                iVar.cqR.size();
                iVar.cqQ.size();
            }
        }
        if (iVar.cqT || iVar.cqR.size() != 0 || iVar.cqU || iVar.cqQ.size() != 0) {
            if (!iVar.cqT && iVar.cqR.size() > 0) {
                Object obj;
                pVar2 = (p) iVar.cqR.poll();
                String str = pVar2.fileName;
                if (((j) g.K(j.class)).bOr().jh(pVar2.cKK)) {
                    ab.i("MicroMsg.SceneVoiceService", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(pVar2.cKK));
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    ab.i("MicroMsg.SceneVoiceService", "Start Recv :".concat(String.valueOf(str)));
                    if (str != null) {
                        iVar.cqS.put(str, new a());
                        iVar.cqT = true;
                        g.Rg().a(new e(pVar2), 0);
                    }
                } else if (bo.nullAsNil(pVar2.fileName).length() > 0) {
                    com.tencent.mm.modelvoice.m.ama().pI(pVar2.fileName);
                    AppMethodBeat.o(116527);
                    return;
                } else {
                    ab.i("MicroMsg.SceneVoiceService", "[oneliang] the length of voice info file name is zero");
                    AppMethodBeat.o(116527);
                    return;
                }
            }
            if (!iVar.cqU && iVar.cqQ.size() > 0) {
                String str2 = (String) iVar.cqQ.poll();
                ab.i("MicroMsg.SceneVoiceService", "Start Send :".concat(String.valueOf(str2)));
                if (str2 != null) {
                    iVar.cqS.put(str2, new a());
                    iVar.cqU = true;
                    g.Rg().a(new com.tencent.mm.modelvoice.f(str2), 0);
                }
            }
            AppMethodBeat.o(116527);
            return;
        }
        iVar.Fb();
        ab.i("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
        AppMethodBeat.o(116527);
    }
}
