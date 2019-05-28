package com.tencent.p177mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.C38155b;
import com.tencent.p177mm.plugin.appbrand.canvas.p1601c.C42400a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a.C10165a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView */
public class MSurfaceView extends SurfaceView implements Callback, C10164a {
    private final C38155b hef = new C38155b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();
    private SurfaceHolder hei;
    private C7306ak hej;
    private Runnable hek = new C165951();
    private volatile boolean mDestroyed;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView$1 */
    class C165951 implements Runnable {
        C165951() {
        }

        public final void run() {
            AppMethodBeat.m2504i(103782);
            if (MSurfaceView.this.mDestroyed) {
                AppMethodBeat.m2505o(103782);
                return;
            }
            Canvas lockCanvas = MSurfaceView.this.hei.lockCanvas();
            if (lockCanvas == null) {
                AppMethodBeat.m2505o(103782);
                return;
            }
            lockCanvas.drawColor(-1);
            MSurfaceView.this.mo21540e(lockCanvas);
            MSurfaceView.this.hei.unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.m2505o(103782);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MSurfaceView$2 */
    class C165962 implements Runnable {
        C165962() {
        }

        public final void run() {
            AppMethodBeat.m2504i(103783);
            if (MSurfaceView.this.mDestroyed) {
                AppMethodBeat.m2505o(103783);
                return;
            }
            Canvas lockCanvas = MSurfaceView.this.hei.lockCanvas();
            if (lockCanvas == null) {
                AppMethodBeat.m2505o(103783);
                return;
            }
            lockCanvas.drawColor(-1);
            MSurfaceView.this.mo21540e(lockCanvas);
            MSurfaceView.this.hei.unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.m2505o(103783);
        }
    }

    public MSurfaceView(Context context) {
        super(context);
        AppMethodBeat.m2504i(103784);
        init();
        AppMethodBeat.m2505o(103784);
    }

    public MSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(103785);
        init();
        AppMethodBeat.m2505o(103785);
    }

    public MSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(103786);
        init();
        AppMethodBeat.m2505o(103786);
    }

    private void init() {
        AppMethodBeat.m2504i(103787);
        this.hei = getHolder();
        this.hei.addCallback(this);
        this.hei.setFormat(-3);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.hef.getDrawContext().hcJ = paint;
        AppMethodBeat.m2505o(103787);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(103788);
        C45124d.m82930i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", Integer.valueOf(hashCode()));
        this.mDestroyed = false;
        if (this.hej == null) {
            HandlerThread ek = C7305d.m12297ek("MSurfaceView#Rending-Thread", -19);
            ek.start();
            this.hej = new C7306ak(ek.getLooper());
        }
        AppMethodBeat.m2505o(103788);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.m2504i(103789);
        C45124d.m82930i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(103789);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.m2504i(103790);
        C45124d.m82930i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", Integer.valueOf(hashCode()));
        this.mDestroyed = true;
        this.hej.getLooper().quit();
        this.hej = null;
        AppMethodBeat.m2505o(103790);
    }

    public void setTraceId(String str) {
        AppMethodBeat.m2504i(103791);
        this.hef.setTraceId(str);
        AppMethodBeat.m2505o(103791);
    }

    public String getTraceId() {
        AppMethodBeat.m2504i(103792);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.m2505o(103792);
        return traceId;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.m2504i(103793);
        C45124d.m82930i("MicroMsg.MSurfaceView", "draw(%s)", Integer.valueOf(hashCode()));
        canvas.drawColor(0, Mode.CLEAR);
        super.draw(canvas);
        AppMethodBeat.m2505o(103793);
    }

    public final void ayc() {
        AppMethodBeat.m2504i(103794);
        mo21533C(new C165962());
        AppMethodBeat.m2505o(103794);
    }

    /* renamed from: C */
    public final void mo21533C(Runnable runnable) {
        AppMethodBeat.m2504i(103795);
        if (this.hej == null) {
            AppMethodBeat.m2505o(103795);
            return;
        }
        this.hej.post(runnable);
        AppMethodBeat.m2505o(103795);
    }

    public C2102d getDrawContext() {
        AppMethodBeat.m2504i(103796);
        C2102d drawContext = this.hef.getDrawContext();
        AppMethodBeat.m2505o(103796);
        return drawContext;
    }

    public void setDrawActionReportable(C42400a c42400a) {
        AppMethodBeat.m2504i(103797);
        this.hef.setDrawActionReportable(c42400a);
        AppMethodBeat.m2505o(103797);
    }

    /* renamed from: e */
    public final boolean mo21540e(Canvas canvas) {
        AppMethodBeat.m2504i(103798);
        boolean e = this.hef.mo21540e(canvas);
        AppMethodBeat.m2505o(103798);
        return e;
    }

    /* renamed from: a */
    public final void mo21535a(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103799);
        this.hef.mo21535a(jSONArray, c10165a);
        AppMethodBeat.m2505o(103799);
    }

    /* renamed from: b */
    public final void mo21539b(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103800);
        this.hef.mo21539b(jSONArray, c10165a);
        AppMethodBeat.m2505o(103800);
    }

    /* renamed from: a */
    public final void mo21534a(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103801);
        this.hef.mo21534a(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103801);
    }

    /* renamed from: b */
    public final void mo21538b(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103802);
        this.hef.mo21538b(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103802);
    }

    public final void ayd() {
        AppMethodBeat.m2504i(103803);
        this.hef.ayd();
        AppMethodBeat.m2505o(103803);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103804);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.m2505o(103804);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103804);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103805);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103805);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(103806);
        this.hef.onResume();
        AppMethodBeat.m2505o(103806);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.m2504i(103807);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.m2505o(103807);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.m2504i(103808);
        this.hef.setSessionId(str);
        AppMethodBeat.m2505o(103808);
    }

    public void setStartTime(long j) {
        AppMethodBeat.m2504i(103809);
        this.hef.setStartTime(j);
        AppMethodBeat.m2505o(103809);
    }

    public final void aye() {
        AppMethodBeat.m2504i(103810);
        this.hef.aye();
        AppMethodBeat.m2505o(103810);
    }
}
