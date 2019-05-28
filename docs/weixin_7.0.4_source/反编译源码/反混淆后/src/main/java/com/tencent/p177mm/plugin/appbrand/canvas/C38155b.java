package com.tencent.p177mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.C10155d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionWrapper;
import com.tencent.p177mm.plugin.appbrand.canvas.p1601c.C42400a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a.C10165a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.DrawCanvasArg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b */
public final class C38155b implements C10164a {
    volatile boolean hcf;
    JSONArray hcg;
    volatile DrawCanvasArg hch;
    private C2102d hci;
    private C10162c hcj;
    C10164a hck;
    private volatile String hcl;
    private Runnable hcm = new C331241();
    private Runnable hcn = new C331252();
    private volatile long hco;
    private volatile long hcp;
    protected volatile int hcq = 0;
    protected volatile long hcr;
    protected volatile long hcs;
    protected volatile long hct;
    protected volatile long hcu;
    private C42400a hcv;
    boolean hcw = true;
    private String hcx;
    protected volatile int mCount;
    public volatile boolean mPause;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.b$7 */
    class C101567 implements Runnable {
        C101567() {
        }

        public final void run() {
            AppMethodBeat.m2504i(103146);
            C4990ab.m7416i("MicroMsg.DrawActionDelegateImpl", "clear draw actions");
            C38155b.this.hch = null;
            C38155b.this.hcg = null;
            C38155b.this.hcf = true;
            AppMethodBeat.m2505o(103146);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.b$a */
    static class C10157a implements C33116a {
        private WeakReference<C10164a> hcC;

        C10157a(C10164a c10164a) {
            AppMethodBeat.m2504i(103147);
            this.hcC = new WeakReference(c10164a);
            AppMethodBeat.m2505o(103147);
        }

        public final void invalidate() {
            AppMethodBeat.m2504i(103148);
            C10164a c10164a = (C10164a) this.hcC.get();
            if (c10164a == null) {
                AppMethodBeat.m2505o(103148);
                return;
            }
            c10164a.ayc();
            AppMethodBeat.m2505o(103148);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.b$1 */
    class C331241 implements Runnable {
        C331241() {
        }

        public final void run() {
            C38155b.this.hcu = 0;
            C38155b.this.mPause = true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.b$2 */
    class C331252 implements Runnable {
        C331252() {
        }

        public final void run() {
            AppMethodBeat.m2504i(103141);
            boolean z = C38155b.this.mPause;
            C38155b.this.mPause = false;
            C4990ab.m7417i("MicroMsg.DrawActionDelegateImpl", "preStae %b, hasChanged %b", Boolean.valueOf(z), Boolean.valueOf(C38155b.this.hcf));
            if (z && C38155b.this.hcf) {
                C38155b.this.hck.ayc();
            }
            AppMethodBeat.m2505o(103141);
        }
    }

    public C38155b(C10164a c10164a) {
        AppMethodBeat.m2504i(103149);
        this.hck = c10164a;
        this.hci = new C2102d(new C10157a(c10164a));
        this.hcj = new C10162c();
        AppMethodBeat.m2505o(103149);
    }

    /* renamed from: e */
    public final boolean mo21540e(Canvas canvas) {
        AppMethodBeat.m2504i(103150);
        boolean a;
        if (this.hcw) {
            this.hci.hcN = false;
            a = m64570a(canvas, this.hcg);
            AppMethodBeat.m2505o(103150);
            return a;
        }
        a = m64572f(canvas);
        AppMethodBeat.m2505o(103150);
        return a;
    }

    /* renamed from: f */
    private boolean m64572f(Canvas canvas) {
        AppMethodBeat.m2504i(103151);
        this.hci.hcN = true;
        if (this.hch == null) {
            this.hcf = false;
            AppMethodBeat.m2505o(103151);
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
                AppMethodBeat.m2505o(103151);
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
                                    this.hcj.mo21531a(this.hci, canvas, drawActionWrapper.hcQ);
                                    IllegalStateException illegalStateException = new IllegalStateException("please use draw obj " + drawActionWrapper.hcQ.toString());
                                    AppMethodBeat.m2505o(103151);
                                    throw illegalStateException;
                                case 2:
                                    C10162c c10162c = this.hcj;
                                    C2102d c2102d = this.hci;
                                    DrawActionArg drawActionArg = drawActionWrapper.hcP;
                                    C10155d c10155d = (C10155d) c10162c.hcD.get(drawActionArg.method);
                                    if (c10155d == null) {
                                        break;
                                    }
                                    c10155d.mo5872a(c2102d, canvas, drawActionArg);
                                    break;
                                default:
                                    C4990ab.m7421w("MicroMsg.DrawActionDelegateImpl", "unknown arg type %d", Integer.valueOf(drawActionWrapper.type));
                                    break;
                            }
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", e);
                        }
                    }
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.DrawActionDelegateImpl", e2, "", new Object[0]);
                }
            }
            m64571e(j, nanoTime, System.nanoTime());
            long currentTimeMillis = System.currentTimeMillis();
            if (!this.mPause) {
                this.hcu = currentTimeMillis;
            }
            AppMethodBeat.m2505o(103151);
            return true;
        } else {
            boolean a = m64570a(canvas, this.hch.hdY);
            AppMethodBeat.m2505o(103151);
            return a;
        }
    }

    /* renamed from: e */
    private void m64571e(long j, long j2, long j3) {
        long j4 = j3 - j2;
        if (j != 0) {
            this.hct = j4 + this.hct;
            this.hcs += j3 - j;
            this.mCount++;
        }
    }

    /* renamed from: a */
    private boolean m64570a(Canvas canvas, JSONArray jSONArray) {
        AppMethodBeat.m2504i(103152);
        this.hcf = false;
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(103152);
            return false;
        }
        long j = this.hco;
        long nanoTime = System.nanoTime();
        this.hci.reset();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                try {
                    this.hcj.mo21531a(this.hci, canvas, optJSONObject);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", e);
                }
            }
        }
        m64571e(j, nanoTime, System.nanoTime());
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.mPause) {
            this.hcu = currentTimeMillis;
        }
        AppMethodBeat.m2505o(103152);
        return true;
    }

    public final void ayc() {
    }

    /* renamed from: a */
    public final void mo21535a(final JSONArray jSONArray, final C10165a c10165a) {
        AppMethodBeat.m2504i(103153);
        this.hck.mo21533C(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(103142);
                DrawCanvasArg drawCanvasArg = C38155b.this.hch;
                C38155b.this.hch = null;
                C38155b.this.hcg = jSONArray;
                C38155b.this.hcw = true;
                C38155b.this.hcf = true;
                if (c10165a != null) {
                    c10165a.mo6094a(drawCanvasArg);
                }
                C38155b.m64569a(C38155b.this);
                AppMethodBeat.m2505o(103142);
            }
        });
        AppMethodBeat.m2505o(103153);
    }

    /* renamed from: b */
    public final void mo21539b(final JSONArray jSONArray, final C10165a c10165a) {
        AppMethodBeat.m2504i(103154);
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(103154);
            return;
        }
        this.hck.mo21533C(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(103143);
                C38155b.this.hcw = true;
                if (C38155b.this.hcg == null) {
                    C38155b.this.hcg = jSONArray;
                } else {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        C38155b.this.hcg.put(jSONArray.opt(i));
                    }
                }
                C38155b.this.hcf = true;
                if (c10165a != null) {
                    c10165a.mo6094a(null);
                }
                AppMethodBeat.m2505o(103143);
            }
        });
        AppMethodBeat.m2505o(103154);
    }

    /* renamed from: a */
    public final void mo21534a(final DrawCanvasArg drawCanvasArg, final C10165a c10165a) {
        AppMethodBeat.m2504i(103155);
        this.hck.mo21533C(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(103144);
                DrawCanvasArg drawCanvasArg = C38155b.this.hch;
                C38155b.this.hch = drawCanvasArg;
                C38155b.this.hcf = true;
                C38155b.this.hcw = false;
                if (c10165a != null) {
                    c10165a.mo6094a(drawCanvasArg);
                }
                C38155b.m64569a(C38155b.this);
                AppMethodBeat.m2505o(103144);
            }
        });
        AppMethodBeat.m2505o(103155);
    }

    /* renamed from: b */
    public final void mo21538b(final DrawCanvasArg drawCanvasArg, final C10165a c10165a) {
        AppMethodBeat.m2504i(103156);
        if (drawCanvasArg == null) {
            AppMethodBeat.m2505o(103156);
            return;
        }
        this.hck.mo21533C(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(103145);
                if (C38155b.this.hch == null) {
                    AppMethodBeat.m2505o(103145);
                    return;
                }
                C38155b.this.hch.hdv.addAll(drawCanvasArg.hdv);
                C38155b.this.hcf = true;
                C38155b.this.hcw = false;
                if (c10165a != null) {
                    c10165a.mo6094a(null);
                }
                AppMethodBeat.m2505o(103145);
            }
        });
        AppMethodBeat.m2505o(103156);
    }

    public final void ayd() {
        AppMethodBeat.m2504i(103157);
        this.hck.mo21533C(new C101567());
        AppMethodBeat.m2505o(103157);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(103158);
        this.hck.mo21533C(this.hcn);
        AppMethodBeat.m2505o(103158);
    }

    /* renamed from: C */
    public final void mo21533C(Runnable runnable) {
        AppMethodBeat.m2504i(103159);
        if (equals(this.hck)) {
            AppMethodBeat.m2505o(103159);
            return;
        }
        C5004al.m7441d(runnable);
        AppMethodBeat.m2505o(103159);
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
        AppMethodBeat.m2504i(103160);
        int i = this.mCount;
        long j = this.hct;
        long j2 = this.hcs;
        if (i <= 0 || j <= 0 || j2 <= 0) {
            AppMethodBeat.m2505o(103160);
            return;
        }
        C4990ab.m7417i("MicroMsg.DrawActionDelegateImpl", "firstDraw timecost %f, onDraw timecost %f, firstDraw count %d, drawCount %d", Float.valueOf(((((float) this.hcr) * 1.0f) / ((float) this.hcq)) / 1000000.0f), Float.valueOf(((((float) j) * 1.0f) / ((float) i)) / 1000000.0f), Integer.valueOf(this.hcq), Integer.valueOf(i));
        if (this.hcv != null) {
            this.hcv.mo34435gk(j / ((long) i));
            this.hcv.mo34436gl(j2 / ((long) i));
            this.hcv.mo34434b(j, j2, i);
            this.hcv.mo34431aj(r0);
            this.hcv.mo34432ak(r7);
        }
        AppMethodBeat.m2505o(103160);
    }

    public final C2102d getDrawContext() {
        return this.hci;
    }

    public final void setDrawActionReportable(C42400a c42400a) {
        this.hcv = c42400a;
    }

    public final void setTraceId(String str) {
        this.hcx = str;
    }

    public final String getTraceId() {
        return this.hcx;
    }

    /* renamed from: a */
    static /* synthetic */ void m64569a(C38155b c38155b) {
        AppMethodBeat.m2504i(103161);
        if (c38155b.hcp != 0) {
            c38155b.hcr += System.nanoTime() - c38155b.hcp;
            c38155b.hcp = 0;
            c38155b.hcq++;
            if (c38155b.hcv != null) {
                c38155b.hcv.ays();
            }
        }
        AppMethodBeat.m2505o(103161);
    }
}
