package com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.p890a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C18652u;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.p282a.C38144d;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p889b.C45542b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a */
public abstract class C10202a implements C42421e<DrawCanvasArg> {
    protected DrawCanvasArg hnN;
    protected String hnO;
    protected BlockingQueue<C45542b> hnP = new LinkedBlockingQueue(100);
    protected BlockingQueue<Runnable> hnQ = new LinkedBlockingQueue(100);
    protected volatile long hnR;
    protected volatile long hnS;
    protected int hnT;
    protected int hnU;
    protected boolean hnV;
    protected Thread workerThread = new Thread(new C102031(), "DrawCanvasMgr-worker");

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.b.a.a$1 */
    class C102031 implements Runnable {
        C102031() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10891);
            while (!C10202a.this.workerThread.isInterrupted()) {
                try {
                    C45542b c45542b = (C45542b) C10202a.this.hnP.take();
                    if (C10202a.this.hnP.size() >= 2 && C10202a.this.hnR > 0) {
                        while (c45542b.hnC < C10202a.this.hnS) {
                            C10202a c10202a = C10202a.this;
                            c10202a.hnT++;
                            c45542b = (C45542b) C10202a.this.hnP.poll();
                            if (C10202a.this.hnP.size() <= 0) {
                                break;
                            }
                        }
                    }
                    if (c45542b != null) {
                        c45542b.run();
                        C10202a.this.hnR = c45542b.hnC;
                        if (C10202a.this.hnV) {
                            try {
                                C18652u.m29151i("BaseDrawCanvasWithObj", "wait for release task", new Object[0]);
                                Runnable runnable = (Runnable) C10202a.this.hnQ.take();
                                if (runnable != null) {
                                    runnable.run();
                                }
                                C10202a.this.hnV = false;
                                C18652u.m29151i("BaseDrawCanvasWithObj", "get release task", new Object[0]);
                            } catch (InterruptedException e) {
                                C4990ab.printErrStackTrace("BaseDrawCanvasWithObj", e, "", new Object[0]);
                                AppMethodBeat.m2505o(10891);
                                return;
                            }
                        }
                    }
                    if (C10202a.this.workerThread.isInterrupted()) {
                        AppMethodBeat.m2505o(10891);
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e2) {
                        C4990ab.printErrStackTrace("BaseDrawCanvasWithObj", e2, "", new Object[0]);
                        AppMethodBeat.m2505o(10891);
                        return;
                    }
                } catch (InterruptedException e22) {
                    C4990ab.printErrStackTrace("BaseDrawCanvasWithObj", e22, "", new Object[0]);
                    AppMethodBeat.m2505o(10891);
                    return;
                }
            }
            AppMethodBeat.m2505o(10891);
        }
    }

    /* renamed from: bs */
    public final /* bridge */ /* synthetic */ void mo21616bs(Object obj) {
        String str;
        this.hnN = (DrawCanvasArg) obj;
        if (this.hnN != null) {
            str = this.hnN.hdV;
        } else {
            str = null;
        }
        this.hnO = str;
    }

    public C10202a() {
        this.workerThread.start();
    }

    /* renamed from: a */
    public final void mo21614a(C45542b c45542b) {
        try {
            this.hnP.put(c45542b);
            this.hnS = c45542b.hnC;
            this.hnU++;
        } catch (InterruptedException e) {
            C4990ab.printErrStackTrace("BaseDrawCanvasWithObj", e, "", new Object[0]);
        }
    }

    /* renamed from: Ai */
    public final boolean mo21612Ai(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (this.hnO == null || this.hnO.hashCode() != str.hashCode()) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public DrawCanvasArg mo21618d(JSONObject jSONObject, String str) {
        DrawCanvasArg drawCanvasArg = (DrawCanvasArg) C38144d.ayk().hdz.mo56734aA();
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
        C18652u.m29151i("BaseDrawCanvasWithObj", "drop frame %d times, allFrame %d ", Integer.valueOf(this.hnT), Integer.valueOf(this.hnU));
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

    /* renamed from: F */
    public final void mo21613F(Runnable runnable) {
        try {
            this.hnQ.put(runnable);
        } catch (InterruptedException e) {
            C4990ab.printErrStackTrace("BaseDrawCanvasWithObj", e, "", new Object[0]);
        }
    }

    public final void azU() {
        this.hnV = true;
    }
}
