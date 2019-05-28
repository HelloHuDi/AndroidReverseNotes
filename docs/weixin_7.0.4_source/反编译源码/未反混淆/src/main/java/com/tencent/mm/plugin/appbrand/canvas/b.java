package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.mm.plugin.appbrand.canvas.action.d;
import com.tencent.mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements com.tencent.mm.plugin.appbrand.canvas.widget.a {
    volatile boolean hcf;
    JSONArray hcg;
    volatile DrawCanvasArg hch;
    private d hci;
    private c hcj;
    com.tencent.mm.plugin.appbrand.canvas.widget.a hck;
    private volatile String hcl;
    private Runnable hcm = new Runnable() {
        public final void run() {
            b.this.hcu = 0;
            b.this.mPause = true;
        }
    };
    private Runnable hcn = new Runnable() {
        public final void run() {
            AppMethodBeat.i(103141);
            boolean z = b.this.mPause;
            b.this.mPause = false;
            ab.i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", Boolean.valueOf(z), Boolean.valueOf(b.this.hcf));
            if (z && b.this.hcf) {
                b.this.hck.ayc();
            }
            AppMethodBeat.o(103141);
        }
    };
    private volatile long hco;
    private volatile long hcp;
    protected volatile int hcq = 0;
    protected volatile long hcr;
    protected volatile long hcs;
    protected volatile long hct;
    protected volatile long hcu;
    private com.tencent.mm.plugin.appbrand.canvas.c.a hcv;
    boolean hcw = true;
    private String hcx;
    protected volatile int mCount;
    public volatile boolean mPause;

    static class a implements a {
        private WeakReference<com.tencent.mm.plugin.appbrand.canvas.widget.a> hcC;

        a(com.tencent.mm.plugin.appbrand.canvas.widget.a aVar) {
            AppMethodBeat.i(103147);
            this.hcC = new WeakReference(aVar);
            AppMethodBeat.o(103147);
        }

        public final void invalidate() {
            AppMethodBeat.i(103148);
            com.tencent.mm.plugin.appbrand.canvas.widget.a aVar = (com.tencent.mm.plugin.appbrand.canvas.widget.a) this.hcC.get();
            if (aVar == null) {
                AppMethodBeat.o(103148);
                return;
            }
            aVar.ayc();
            AppMethodBeat.o(103148);
        }
    }

    public b(com.tencent.mm.plugin.appbrand.canvas.widget.a aVar) {
        AppMethodBeat.i(103149);
        this.hck = aVar;
        this.hci = new d(new a(aVar));
        this.hcj = new c();
        AppMethodBeat.o(103149);
    }

    public final boolean e(Canvas canvas) {
        AppMethodBeat.i(103150);
        boolean a;
        if (this.hcw) {
            this.hci.hcN = false;
            a = a(canvas, this.hcg);
            AppMethodBeat.o(103150);
            return a;
        }
        a = f(canvas);
        AppMethodBeat.o(103150);
        return a;
    }

    private boolean f(Canvas canvas) {
        AppMethodBeat.i(103151);
        this.hci.hcN = true;
        if (this.hch == null) {
            this.hcf = false;
            AppMethodBeat.o(103151);
            return false;
        } else if (!this.hch.hdX || this.hch.heb) {
            this.hcf = false;
            List list;
            if (this.hch == null) {
                list = null;
            } else {
                list = this.hch.hdv;
            }
            if (list == null || list.size() == 0) {
                AppMethodBeat.o(103151);
                return false;
            }
            long j = this.hco;
            long nanoTime = System.nanoTime();
            this.hci.reset();
            for (DrawActionWrapper drawActionWrapper : list) {
                try {
                    if (drawActionWrapper != null) {
                        try {
                            switch (drawActionWrapper.type) {
                                case 1:
                                    this.hcj.a(this.hci, canvas, drawActionWrapper.hcQ);
                                    IllegalStateException illegalStateException = new IllegalStateException("please use draw obj " + drawActionWrapper.hcQ.toString());
                                    AppMethodBeat.o(103151);
                                    throw illegalStateException;
                                case 2:
                                    c cVar = this.hcj;
                                    d dVar = this.hci;
                                    DrawActionArg drawActionArg = drawActionWrapper.hcP;
                                    d dVar2 = (d) cVar.hcD.get(drawActionArg.method);
                                    if (dVar2 == null) {
                                        break;
                                    }
                                    dVar2.a(dVar, canvas, drawActionArg);
                                    break;
                                default:
                                    ab.w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", Integer.valueOf(drawActionWrapper.type));
                                    break;
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", e);
                        }
                    }
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", e2, "", new Object[0]);
                }
            }
            e(j, nanoTime, System.nanoTime());
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mPause) {
                this.hcu = currentTimeMillis;
            }
            AppMethodBeat.o(103151);
            return true;
        } else {
            boolean a = a(canvas, this.hch.hdY);
            AppMethodBeat.o(103151);
            return a;
        }
    }

    private void e(long j, long j2, long j3) {
        long j4 = j3 - j2;
        if (j != 0) {
            this.hct = j4 + this.hct;
            this.hcs += j3 - j;
            this.mCount++;
        }
    }

    private boolean a(Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.i(103152);
        this.hcf = false;
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(103152);
            return false;
        }
        long j = this.hco;
        long nanoTime = System.nanoTime();
        this.hci.reset();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                try {
                    this.hcj.a(this.hci, canvas, optJSONObject);
                } catch (Exception e) {
                    ab.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", e);
                }
            }
        }
        e(j, nanoTime, System.nanoTime());
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.mPause) {
            this.hcu = currentTimeMillis;
        }
        AppMethodBeat.o(103152);
        return true;
    }

    public final void ayc() {
    }

    public final void a(final JSONArray jSONArray, final com.tencent.mm.plugin.appbrand.canvas.widget.a.a aVar) {
        AppMethodBeat.i(103153);
        this.hck.C(new Runnable() {
            public final void run() {
                AppMethodBeat.i(103142);
                DrawCanvasArg drawCanvasArg = b.this.hch;
                b.this.hch = null;
                b.this.hcg = jSONArray;
                b.this.hcw = true;
                b.this.hcf = true;
                if (aVar != null) {
                    aVar.a(drawCanvasArg);
                }
                b.a(b.this);
                AppMethodBeat.o(103142);
            }
        });
        AppMethodBeat.o(103153);
    }

    public final void b(final JSONArray jSONArray, final com.tencent.mm.plugin.appbrand.canvas.widget.a.a aVar) {
        AppMethodBeat.i(103154);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(103154);
            return;
        }
        this.hck.C(new Runnable() {
            public final void run() {
                AppMethodBeat.i(103143);
                b.this.hcw = true;
                if (b.this.hcg == null) {
                    b.this.hcg = jSONArray;
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        b.this.hcg.put(jSONArray.opt(i));
                    }
                }
                b.this.hcf = true;
                if (aVar != null) {
                    aVar.a(null);
                }
                AppMethodBeat.o(103143);
            }
        });
        AppMethodBeat.o(103154);
    }

    public final void a(final DrawCanvasArg drawCanvasArg, final com.tencent.mm.plugin.appbrand.canvas.widget.a.a aVar) {
        AppMethodBeat.i(103155);
        this.hck.C(new Runnable() {
            public final void run() {
                AppMethodBeat.i(103144);
                DrawCanvasArg drawCanvasArg = b.this.hch;
                b.this.hch = drawCanvasArg;
                b.this.hcf = true;
                b.this.hcw = false;
                if (aVar != null) {
                    aVar.a(drawCanvasArg);
                }
                b.a(b.this);
                AppMethodBeat.o(103144);
            }
        });
        AppMethodBeat.o(103155);
    }

    public final void b(final DrawCanvasArg drawCanvasArg, final com.tencent.mm.plugin.appbrand.canvas.widget.a.a aVar) {
        AppMethodBeat.i(103156);
        if (drawCanvasArg == null) {
            AppMethodBeat.o(103156);
            return;
        }
        this.hck.C(new Runnable() {
            public final void run() {
                AppMethodBeat.i(103145);
                if (b.this.hch == null) {
                    AppMethodBeat.o(103145);
                    return;
                }
                b.this.hch.hdv.addAll(drawCanvasArg.hdv);
                b.this.hcf = true;
                b.this.hcw = false;
                if (aVar != null) {
                    aVar.a(null);
                }
                AppMethodBeat.o(103145);
            }
        });
        AppMethodBeat.o(103156);
    }

    public final void ayd() {
        AppMethodBeat.i(103157);
        this.hck.C(new Runnable() {
            public final void run() {
                AppMethodBeat.i(103146);
                ab.i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
                b.this.hch = null;
                b.this.hcg = null;
                b.this.hcf = true;
                AppMethodBeat.o(103146);
            }
        });
        AppMethodBeat.o(103157);
    }

    public final void onResume() {
        AppMethodBeat.i(103158);
        this.hck.C(this.hcn);
        AppMethodBeat.o(103158);
    }

    public final void C(Runnable runnable) {
        AppMethodBeat.i(103159);
        if (equals(this.hck)) {
            AppMethodBeat.o(103159);
            return;
        }
        al.d(runnable);
        AppMethodBeat.o(103159);
    }

    public final boolean isPaused() {
        return this.mPause;
    }

    public final String getSessionId() {
        return this.hcl;
    }

    public final void setSessionId(String str) {
        this.hcl = str;
    }

    public final void setStartTime(long j) {
        this.hco = j;
        this.hcp = j;
    }

    public final void aye() {
        AppMethodBeat.i(103160);
        int i = this.mCount;
        long j = this.hct;
        long j2 = this.hcs;
        if (i <= 0 || j <= 0 || j2 <= 0) {
            AppMethodBeat.o(103160);
            return;
        }
        ab.i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", Float.valueOf(((((float) this.hcr) * 1.0f) / ((float) this.hcq)) / 1000000.0f), Float.valueOf(((((float) j) * 1.0f) / ((float) i)) / 1000000.0f), Integer.valueOf(this.hcq), Integer.valueOf(i));
        if (this.hcv != null) {
            this.hcv.gk(j / ((long) i));
            this.hcv.gl(j2 / ((long) i));
            this.hcv.b(j, j2, i);
            this.hcv.aj(r0);
            this.hcv.ak(r7);
        }
        AppMethodBeat.o(103160);
    }

    public final d getDrawContext() {
        return this.hci;
    }

    public final void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a aVar) {
        this.hcv = aVar;
    }

    public final void setTraceId(String str) {
        this.hcx = str;
    }

    public final String getTraceId() {
        return this.hcx;
    }

    static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(103161);
        if (bVar.hcp != 0) {
            bVar.hcr += System.nanoTime() - bVar.hcp;
            bVar.hcp = 0;
            bVar.hcq++;
            if (bVar.hcv != null) {
                bVar.hcv.ays();
            }
        }
        AppMethodBeat.o(103161);
    }
}
