package com.tencent.p177mm.plugin.appbrand.report.quality;

import android.os.Handler;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p232b.p233a.C42093cd;
import com.tencent.p177mm.p230g.p232b.p233a.C42093cd.C42092a;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C38220e;
import com.tencent.p177mm.plugin.appbrand.game.p294d.C38220e.C19236a;
import com.tencent.p177mm.plugin.appbrand.performance.C27258f;
import com.tencent.p177mm.plugin.appbrand.report.quality.C19704i.C19705a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C33522k.C19706a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C45678j.C33521a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.report.quality.e */
public final class C38502e {
    Handler handler;
    final C38503a iCJ = new C38503a(this, (byte) 0);
    QualitySessionRuntime iCK;
    C27258f iCL;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.quality.e$a */
    class C38503a implements Runnable {
        long ciy;

        private C38503a() {
            this.ciy = 0;
        }

        /* synthetic */ C38503a(C38502e c38502e, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(132690);
            if (C38502e.this.iCK == null) {
                AppMethodBeat.m2505o(132690);
                return;
            }
            C38502e.this.mo61213IF();
            C38502e.this.handler.postDelayed(C38502e.this.iCJ, this.ciy);
            AppMethodBeat.m2505o(132690);
        }
    }

    public C38502e() {
        AppMethodBeat.m2504i(132691);
        AppMethodBeat.m2505o(132691);
    }

    public final synchronized boolean aLA() {
        return this.iCK != null;
    }

    public final synchronized void destroy() {
        AppMethodBeat.m2504i(132692);
        this.iCK = null;
        if (this.handler != null) {
            this.handler.removeCallbacks(this.iCJ);
            this.handler = null;
        }
        if (this.iCL != null) {
            this.iCL.stop();
            this.iCL = null;
        }
        AppMethodBeat.m2505o(132692);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: IF */
    public final synchronized void mo61213IF() {
        AppMethodBeat.m2504i(132693);
        if (this.iCK == null) {
            AppMethodBeat.m2505o(132693);
        } else {
            C33522k c33522k;
            int i;
            QualitySessionRuntime qualitySessionRuntime = this.iCK;
            if (qualitySessionRuntime == null) {
                c33522k = null;
            } else {
                C41243o c41243o = qualitySessionRuntime.htn;
                C19706a c19706a = new C19706a();
                C19704i c19704i = C19704i.iCT;
                C19705a aLB = C19704i.aLB();
                c19706a.iCV = aLB.iCV;
                c19706a.iDu = aLB.iCV - qualitySessionRuntime.iDf;
                c19706a.iCW = aLB.iCW;
                c19706a.iCX = aLB.iCX;
                c19706a.hrU = C38502e.m65165C(c41243o);
                c19706a.iDv = (int) (System.currentTimeMillis() - qualitySessionRuntime.iDc);
                c19706a.iDw = (int) Math.round(C2455h.iCR.ivH.aKs());
                if (qualitySessionRuntime.hrs) {
                    MBRuntime mBRuntime;
                    try {
                        mBRuntime = ((C42439b) qualitySessionRuntime.htn.atK()).getMBRuntime();
                    } catch (Exception e) {
                        C45124d.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", e, "get QualityEvent of WAGame but fail. [%s]", r7);
                        mBRuntime = null;
                    }
                    if (mBRuntime == null) {
                        C45124d.m82927e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
                    } else {
                        c19706a.fps = Math.round(mBRuntime.getInspector().getCurrentFps().bSi);
                        c19706a.iDq = mBRuntime.getInspector().mo3983ys();
                        c19706a.iDs = mBRuntime.getInspector().mo3985yu();
                        c19706a.iDt = mBRuntime.getInspector().mo3986yv();
                        c19706a.iDr = mBRuntime.getInspector().mo3987yw();
                        c19706a.iDl = qualitySessionRuntime.iDi.iDl;
                        if (mBRuntime.getParams().use_command_buffer) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        c19706a.iDx = i;
                    }
                } else {
                    C38502e c38502e = qualitySessionRuntime.iDh;
                    if (c38502e.iCL == null) {
                        i = 0;
                    } else {
                        i = (int) (c38502e.iCL.iwc + 0.5d);
                    }
                    c19706a.fps = i;
                }
                c33522k = new C33522k(c19706a, (byte) 0);
            }
            if (c33522k == null) {
                AppMethodBeat.m2505o(132693);
            } else {
                C27285a.aLz();
                QualitySessionRuntime DG = C27285a.m43319DG(this.iCK.appId);
                if (DG != null) {
                    C42093cd c42093cd = new C42093cd();
                    c42093cd.mo67650gV(DG.appId);
                    c42093cd.mo67649gU(DG.igT);
                    c42093cd.dfc = C42092a.m74182hd(DG.iCZ);
                    c42093cd.ddz = (long) DG.apptype;
                    c42093cd.ddd = (long) DG.iDa;
                    c42093cd.cVR = (long) DG.scene;
                    c42093cd.mo67647He();
                    c42093cd.mo67648Hf();
                    c42093cd.mo67646Hd();
                    c42093cd.dfd = (long) c33522k.fps;
                    c42093cd.dfe = (long) Math.round(c33522k.iDq);
                    if (c33522k.iDl == C33521a._2D) {
                        i = 1;
                    } else if (c33522k.iDl == C33521a.WEBGL) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                    c42093cd.dfm = (long) i;
                    c42093cd.dfn = (long) c33522k.iDr;
                    c42093cd.dfo = (long) c33522k.iDs;
                    c42093cd.dfp = (long) c33522k.iDt;
                    c42093cd.dfi = (long) c33522k.iCW;
                    c42093cd.dfj = (long) c33522k.iCX;
                    c42093cd.dfg = (long) c33522k.iCV;
                    c42093cd.dfh = (long) c33522k.iDu;
                    c42093cd.dfk = (long) (c33522k.iDv / 1000);
                    c42093cd.dfl = (long) c33522k.hrU;
                    c42093cd.dff = (long) c33522k.iDw;
                    c42093cd.dfq = (long) c33522k.iDx;
                    c42093cd.ajK();
                }
                if (this.iCK.hrs) {
                    C38220e c38220e = new C38220e(this.iCK, c33522k);
                    if (c38220e.hrV != null) {
                        int i2;
                        C33522k c33522k2 = c38220e.hrV;
                        if (c33522k2.iDl == C33521a._2D) {
                            i = 1;
                        } else if (c33522k2.iDl == C33521a.WEBGL) {
                            i = 2;
                        } else {
                            i = 0;
                        }
                        c38220e.hrT = i;
                        c38220e.hrU = c38220e.hrV.hrU;
                        if (c38220e.hrV != null) {
                            i = c38220e.hrV.iDv;
                            i2 = c38220e.hrV.iDw;
                            C7060h.pYm.mo8381e(14959, c38220e.appId, Integer.valueOf(c38220e.axy), Integer.valueOf(c38220e.css), Integer.valueOf(c38220e.hrT), Integer.valueOf(C19236a.CPU.hsh), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(c38220e.hrU));
                            C4990ab.m7417i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(c38220e.hrU), Integer.valueOf(c38220e.hrT));
                        }
                        if (c38220e.hrV != null) {
                            i = c38220e.hrV.iDv;
                            i2 = c38220e.hrV.iCV;
                            int i3 = c38220e.hrV.iCW;
                            int i4 = c38220e.hrV.iCX;
                            int i5 = c38220e.hrV.iDu;
                            C7060h.pYm.mo8381e(14959, c38220e.appId, Integer.valueOf(c38220e.axy), Integer.valueOf(c38220e.css), Integer.valueOf(c38220e.hrT), Integer.valueOf(C19236a.MEM.hsh), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(c38220e.hrU));
                            C7060h.pYm.mo8381e(14959, c38220e.appId, Integer.valueOf(c38220e.axy), Integer.valueOf(c38220e.css), Integer.valueOf(c38220e.hrT), Integer.valueOf(C19236a.NATIVE_MEM.hsh), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(c38220e.hrU));
                            C7060h.pYm.mo8381e(14959, c38220e.appId, Integer.valueOf(c38220e.axy), Integer.valueOf(c38220e.css), Integer.valueOf(c38220e.hrT), Integer.valueOf(C19236a.DALVIK_MEM.hsh), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(c38220e.hrU));
                            C7060h.pYm.mo8381e(14959, c38220e.appId, Integer.valueOf(c38220e.axy), Integer.valueOf(c38220e.css), Integer.valueOf(c38220e.hrT), Integer.valueOf(C19236a.MEM_DELTA.hsh), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(c38220e.hrU));
                            C4990ab.m7417i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(c38220e.hrU), Integer.valueOf(c38220e.hrT));
                        }
                        if (c38220e.hrV != null) {
                            i = c38220e.hrV.iDv;
                            i2 = c38220e.hrV.fps;
                            C7060h.pYm.mo8381e(14959, c38220e.appId, Integer.valueOf(c38220e.axy), Integer.valueOf(c38220e.css), Integer.valueOf(c38220e.hrT), Integer.valueOf(C19236a.FPS.hsh), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(c38220e.hrU));
                            C4990ab.m7417i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(c38220e.hrU), Integer.valueOf(c38220e.hrT));
                            if (((int) c38220e.hrV.iDq) != -1) {
                                C7060h.pYm.mo8381e(14959, c38220e.appId, Integer.valueOf(c38220e.axy), Integer.valueOf(c38220e.css), Integer.valueOf(c38220e.hrT), Integer.valueOf(C19236a.VARIANCE_FPS.hsh), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(c38220e.hrU));
                                C4990ab.m7417i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i2), Integer.valueOf(C19236a.VARIANCE_FPS.hsh), Integer.valueOf(i), Integer.valueOf(c38220e.hrU), Integer.valueOf(c38220e.hrT));
                                AppMethodBeat.m2505o(132693);
                            } else {
                                C4990ab.m7412e("MicroMsg.Kv_14959", "variance == -1!");
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(132693);
            }
        }
    }

    /* renamed from: C */
    private static int m65165C(C6750i c6750i) {
        AppMethodBeat.m2504i(132694);
        try {
            int atw = c6750i.gNz.atw();
            AppMethodBeat.m2505o(132694);
            return atw;
        } catch (Exception e) {
            AppMethodBeat.m2505o(132694);
            return 0;
        }
    }
}
