package com.tencent.mm.plugin.appbrand.dynamic.d.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.a.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.plugin.appbrand.dynamic.d.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

public abstract class a implements e<DrawCanvasArg> {
    protected DrawCanvasArg hnN;
    protected String hnO;
    protected BlockingQueue<b> hnP = new LinkedBlockingQueue(100);
    protected BlockingQueue<Runnable> hnQ = new LinkedBlockingQueue(100);
    protected volatile long hnR;
    protected volatile long hnS;
    protected int hnT;
    protected int hnU;
    protected boolean hnV;
    protected Thread workerThread = new Thread(new Runnable() {
        public final void run() {
            AppMethodBeat.i(10891);
            while (!a.this.workerThread.isInterrupted()) {
                try {
                    b bVar = (b) a.this.hnP.take();
                    if (a.this.hnP.size() >= 2 && a.this.hnR > 0) {
                        while (bVar.hnC < a.this.hnS) {
                            a aVar = a.this;
                            aVar.hnT++;
                            bVar = (b) a.this.hnP.poll();
                            if (a.this.hnP.size() <= 0) {
                                break;
                            }
                        }
                    }
                    if (bVar != null) {
                        bVar.run();
                        a.this.hnR = bVar.hnC;
                        if (a.this.hnV) {
                            try {
                                u.i("BaseDrawCanvasWithObj", "wait for release task", new Object[0]);
                                Runnable runnable = (Runnable) a.this.hnQ.take();
                                if (runnable != null) {
                                    runnable.run();
                                }
                                a.this.hnV = false;
                                u.i("BaseDrawCanvasWithObj", "get release task", new Object[0]);
                            } catch (InterruptedException e) {
                                ab.printErrStackTrace("BaseDrawCanvasWithObj", e, "", new Object[0]);
                                AppMethodBeat.o(10891);
                                return;
                            }
                        }
                    }
                    if (a.this.workerThread.isInterrupted()) {
                        AppMethodBeat.o(10891);
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e2) {
                        ab.printErrStackTrace("BaseDrawCanvasWithObj", e2, "", new Object[0]);
                        AppMethodBeat.o(10891);
                        return;
                    }
                } catch (InterruptedException e22) {
                    ab.printErrStackTrace("BaseDrawCanvasWithObj", e22, "", new Object[0]);
                    AppMethodBeat.o(10891);
                    return;
                }
            }
            AppMethodBeat.o(10891);
        }
    }, "DrawCanvasMgr-worker");

    public final /* bridge */ /* synthetic */ void bs(Object obj) {
        String str;
        this.hnN = (DrawCanvasArg) obj;
        if (this.hnN != null) {
            str = this.hnN.hdV;
        } else {
            str = null;
        }
        this.hnO = str;
    }

    public a() {
        this.workerThread.start();
    }

    public final void a(b bVar) {
        try {
            this.hnP.put(bVar);
            this.hnS = bVar.hnC;
            this.hnU++;
        } catch (InterruptedException e) {
            ab.printErrStackTrace("BaseDrawCanvasWithObj", e, "", new Object[0]);
        }
    }

    public final boolean Ai(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.hnO == null || this.hnO.hashCode() != str.hashCode()) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public DrawCanvasArg d(JSONObject jSONObject, String str) {
        DrawCanvasArg drawCanvasArg = (DrawCanvasArg) d.ayk().hdz.aA();
        if (drawCanvasArg == null) {
            drawCanvasArg = new DrawCanvasArg();
        }
        drawCanvasArg.hdU = jSONObject.optBoolean("reserve");
        drawCanvasArg.hdV = str;
        drawCanvasArg.hdW = jSONObject.optLong("__invoke_jsapi_timestamp");
        return drawCanvasArg;
    }

    public final void reset() {
        this.hnO = null;
        u.i("BaseDrawCanvasWithObj", "drop frame %d times, allFrame %d ", Integer.valueOf(this.hnT), Integer.valueOf(this.hnU));
        this.hnU = 0;
        this.hnT = 0;
        this.hnR = 0;
        this.workerThread.interrupt();
        Runnable runnable = (Runnable) this.hnQ.poll();
        while (runnable != null) {
            if (runnable != null) {
                runnable.run();
            }
            runnable = (Runnable) this.hnQ.poll();
        }
        this.hnQ.clear();
        this.hnP.clear();
        if (this.hnN != null) {
            this.hnN.reset();
            this.hnN = null;
        }
    }

    public final void F(Runnable runnable) {
        try {
            this.hnQ.put(runnable);
        } catch (InterruptedException e) {
            ab.printErrStackTrace("BaseDrawCanvasWithObj", e, "", new Object[0]);
        }
    }

    public final void azU() {
        this.hnV = true;
    }
}
