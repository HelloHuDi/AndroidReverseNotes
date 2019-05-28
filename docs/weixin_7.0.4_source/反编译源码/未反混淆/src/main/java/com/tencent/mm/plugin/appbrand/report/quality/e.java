package com.tencent.mm.plugin.appbrand.report.quality;

import android.os.Handler;
import com.tencent.luggage.g.d;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cd;
import com.tencent.mm.plugin.appbrand.game.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.performance.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class e {
    Handler handler;
    final a iCJ = new a(this, (byte) 0);
    QualitySessionRuntime iCK;
    f iCL;

    class a implements Runnable {
        long ciy;

        private a() {
            this.ciy = 0;
        }

        /* synthetic */ a(e eVar, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(132690);
            if (e.this.iCK == null) {
                AppMethodBeat.o(132690);
                return;
            }
            e.this.IF();
            e.this.handler.postDelayed(e.this.iCJ, this.ciy);
            AppMethodBeat.o(132690);
        }
    }

    public e() {
        AppMethodBeat.i(132691);
        AppMethodBeat.o(132691);
    }

    public final synchronized boolean aLA() {
        return this.iCK != null;
    }

    public final synchronized void destroy() {
        AppMethodBeat.i(132692);
        this.iCK = null;
        if (this.handler != null) {
            this.handler.removeCallbacks(this.iCJ);
            this.handler = null;
        }
        if (this.iCL != null) {
            this.iCL.stop();
            this.iCL = null;
        }
        AppMethodBeat.o(132692);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void IF() {
        AppMethodBeat.i(132693);
        if (this.iCK == null) {
            AppMethodBeat.o(132693);
        } else {
            k kVar;
            int i;
            QualitySessionRuntime qualitySessionRuntime = this.iCK;
            if (qualitySessionRuntime == null) {
                kVar = null;
            } else {
                o oVar = qualitySessionRuntime.htn;
                com.tencent.mm.plugin.appbrand.report.quality.k.a aVar = new com.tencent.mm.plugin.appbrand.report.quality.k.a();
                i iVar = i.iCT;
                com.tencent.mm.plugin.appbrand.report.quality.i.a aLB = i.aLB();
                aVar.iCV = aLB.iCV;
                aVar.iDu = aLB.iCV - qualitySessionRuntime.iDf;
                aVar.iCW = aLB.iCW;
                aVar.iCX = aLB.iCX;
                aVar.hrU = C(oVar);
                aVar.iDv = (int) (System.currentTimeMillis() - qualitySessionRuntime.iDc);
                aVar.iDw = (int) Math.round(h.iCR.ivH.aKs());
                if (qualitySessionRuntime.hrs) {
                    MBRuntime mBRuntime;
                    try {
                        mBRuntime = ((b) qualitySessionRuntime.htn.atK()).getMBRuntime();
                    } catch (Exception e) {
                        d.printErrStackTrace("MicroMsg.AppBrandRuntimeEventReporter", e, "get QualityEvent of WAGame but fail. [%s]", r7);
                        mBRuntime = null;
                    }
                    if (mBRuntime == null) {
                        d.e("MicroMsg.AppBrandRuntimeEventReporter", "buildWAGameQualityEvent find renderer.fps == null");
                    } else {
                        aVar.fps = Math.round(mBRuntime.getInspector().getCurrentFps().bSi);
                        aVar.iDq = mBRuntime.getInspector().ys();
                        aVar.iDs = mBRuntime.getInspector().yu();
                        aVar.iDt = mBRuntime.getInspector().yv();
                        aVar.iDr = mBRuntime.getInspector().yw();
                        aVar.iDl = qualitySessionRuntime.iDi.iDl;
                        if (mBRuntime.getParams().use_command_buffer) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        aVar.iDx = i;
                    }
                } else {
                    e eVar = qualitySessionRuntime.iDh;
                    if (eVar.iCL == null) {
                        i = 0;
                    } else {
                        i = (int) (eVar.iCL.iwc + 0.5d);
                    }
                    aVar.fps = i;
                }
                kVar = new k(aVar, (byte) 0);
            }
            if (kVar == null) {
                AppMethodBeat.o(132693);
            } else {
                a.aLz();
                QualitySessionRuntime DG = a.DG(this.iCK.appId);
                if (DG != null) {
                    cd cdVar = new cd();
                    cdVar.gV(DG.appId);
                    cdVar.gU(DG.igT);
                    cdVar.dfc = com.tencent.mm.g.b.a.cd.a.hd(DG.iCZ);
                    cdVar.ddz = (long) DG.apptype;
                    cdVar.ddd = (long) DG.iDa;
                    cdVar.cVR = (long) DG.scene;
                    cdVar.He();
                    cdVar.Hf();
                    cdVar.Hd();
                    cdVar.dfd = (long) kVar.fps;
                    cdVar.dfe = (long) Math.round(kVar.iDq);
                    if (kVar.iDl == com.tencent.mm.plugin.appbrand.report.quality.j.a._2D) {
                        i = 1;
                    } else if (kVar.iDl == com.tencent.mm.plugin.appbrand.report.quality.j.a.WEBGL) {
                        i = 2;
                    } else {
                        i = 0;
                    }
                    cdVar.dfm = (long) i;
                    cdVar.dfn = (long) kVar.iDr;
                    cdVar.dfo = (long) kVar.iDs;
                    cdVar.dfp = (long) kVar.iDt;
                    cdVar.dfi = (long) kVar.iCW;
                    cdVar.dfj = (long) kVar.iCX;
                    cdVar.dfg = (long) kVar.iCV;
                    cdVar.dfh = (long) kVar.iDu;
                    cdVar.dfk = (long) (kVar.iDv / 1000);
                    cdVar.dfl = (long) kVar.hrU;
                    cdVar.dff = (long) kVar.iDw;
                    cdVar.dfq = (long) kVar.iDx;
                    cdVar.ajK();
                }
                if (this.iCK.hrs) {
                    com.tencent.mm.plugin.appbrand.game.d.e eVar2 = new com.tencent.mm.plugin.appbrand.game.d.e(this.iCK, kVar);
                    if (eVar2.hrV != null) {
                        int i2;
                        k kVar2 = eVar2.hrV;
                        if (kVar2.iDl == com.tencent.mm.plugin.appbrand.report.quality.j.a._2D) {
                            i = 1;
                        } else if (kVar2.iDl == com.tencent.mm.plugin.appbrand.report.quality.j.a.WEBGL) {
                            i = 2;
                        } else {
                            i = 0;
                        }
                        eVar2.hrT = i;
                        eVar2.hrU = eVar2.hrV.hrU;
                        if (eVar2.hrV != null) {
                            i = eVar2.hrV.iDv;
                            i2 = eVar2.hrV.iDw;
                            h.pYm.e(14959, eVar2.appId, Integer.valueOf(eVar2.axy), Integer.valueOf(eVar2.css), Integer.valueOf(eVar2.hrT), Integer.valueOf(com.tencent.mm.plugin.appbrand.game.d.e.a.CPU.hsh), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(eVar2.hrU));
                            ab.i("MicroMsg.Kv_14959", "Kv_14959.reportCpu cpu = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(eVar2.hrU), Integer.valueOf(eVar2.hrT));
                        }
                        if (eVar2.hrV != null) {
                            i = eVar2.hrV.iDv;
                            i2 = eVar2.hrV.iCV;
                            int i3 = eVar2.hrV.iCW;
                            int i4 = eVar2.hrV.iCX;
                            int i5 = eVar2.hrV.iDu;
                            h.pYm.e(14959, eVar2.appId, Integer.valueOf(eVar2.axy), Integer.valueOf(eVar2.css), Integer.valueOf(eVar2.hrT), Integer.valueOf(com.tencent.mm.plugin.appbrand.game.d.e.a.MEM.hsh), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(eVar2.hrU));
                            h.pYm.e(14959, eVar2.appId, Integer.valueOf(eVar2.axy), Integer.valueOf(eVar2.css), Integer.valueOf(eVar2.hrT), Integer.valueOf(com.tencent.mm.plugin.appbrand.game.d.e.a.NATIVE_MEM.hsh), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(eVar2.hrU));
                            h.pYm.e(14959, eVar2.appId, Integer.valueOf(eVar2.axy), Integer.valueOf(eVar2.css), Integer.valueOf(eVar2.hrT), Integer.valueOf(com.tencent.mm.plugin.appbrand.game.d.e.a.DALVIK_MEM.hsh), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(eVar2.hrU));
                            h.pYm.e(14959, eVar2.appId, Integer.valueOf(eVar2.axy), Integer.valueOf(eVar2.css), Integer.valueOf(eVar2.hrT), Integer.valueOf(com.tencent.mm.plugin.appbrand.game.d.e.a.MEM_DELTA.hsh), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(eVar2.hrU));
                            ab.i("MicroMsg.Kv_14959", "Kv_14959.reportMemory pid = [%d] native = [%d] dalvik = [%d] delta = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(eVar2.hrU), Integer.valueOf(eVar2.hrT));
                        }
                        if (eVar2.hrV != null) {
                            i = eVar2.hrV.iDv;
                            i2 = eVar2.hrV.fps;
                            h.pYm.e(14959, eVar2.appId, Integer.valueOf(eVar2.axy), Integer.valueOf(eVar2.css), Integer.valueOf(eVar2.hrT), Integer.valueOf(com.tencent.mm.plugin.appbrand.game.d.e.a.FPS.hsh), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(eVar2.hrU));
                            ab.i("MicroMsg.Kv_14959", "Kv_14959.reportFps fps = [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(eVar2.hrU), Integer.valueOf(eVar2.hrT));
                            if (((int) eVar2.hrV.iDq) != -1) {
                                h.pYm.e(14959, eVar2.appId, Integer.valueOf(eVar2.axy), Integer.valueOf(eVar2.css), Integer.valueOf(eVar2.hrT), Integer.valueOf(com.tencent.mm.plugin.appbrand.game.d.e.a.VARIANCE_FPS.hsh), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(eVar2.hrU));
                                ab.i("MicroMsg.Kv_14959", "Kv_14959.reportFps variance fps = [%d] eventid: [%d] duration = [%d] runtimeCount = [%d] canvasType = [%d]", Integer.valueOf(i2), Integer.valueOf(com.tencent.mm.plugin.appbrand.game.d.e.a.VARIANCE_FPS.hsh), Integer.valueOf(i), Integer.valueOf(eVar2.hrU), Integer.valueOf(eVar2.hrT));
                                AppMethodBeat.o(132693);
                            } else {
                                ab.e("MicroMsg.Kv_14959", "variance == -1!");
                            }
                        }
                    }
                }
                AppMethodBeat.o(132693);
            }
        }
    }

    private static int C(i iVar) {
        AppMethodBeat.i(132694);
        try {
            int atw = iVar.gNz.atw();
            AppMethodBeat.o(132694);
            return atw;
        } catch (Exception e) {
            AppMethodBeat.o(132694);
            return 0;
        }
    }
}
