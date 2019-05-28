package com.tencent.mm.plugin.appbrand.canvas.widget;

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
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.c.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MSurfaceView extends SurfaceView implements Callback, a {
    private final b hef = new b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();
    private SurfaceHolder hei;
    private ak hej;
    private Runnable hek = new Runnable() {
        public final void run() {
            AppMethodBeat.i(103782);
            if (MSurfaceView.this.mDestroyed) {
                AppMethodBeat.o(103782);
                return;
            }
            Canvas lockCanvas = MSurfaceView.this.hei.lockCanvas();
            if (lockCanvas == null) {
                AppMethodBeat.o(103782);
                return;
            }
            lockCanvas.drawColor(-1);
            MSurfaceView.this.e(lockCanvas);
            MSurfaceView.this.hei.unlockCanvasAndPost(lockCanvas);
            AppMethodBeat.o(103782);
        }
    };
    private volatile boolean mDestroyed;

    public MSurfaceView(Context context) {
        super(context);
        AppMethodBeat.i(103784);
        init();
        AppMethodBeat.o(103784);
    }

    public MSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(103785);
        init();
        AppMethodBeat.o(103785);
    }

    public MSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(103786);
        init();
        AppMethodBeat.o(103786);
    }

    private void init() {
        AppMethodBeat.i(103787);
        this.hei = getHolder();
        this.hei.addCallback(this);
        this.hei.setFormat(-3);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.hef.getDrawContext().hcJ = paint;
        AppMethodBeat.o(103787);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(103788);
        d.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", Integer.valueOf(hashCode()));
        this.mDestroyed = false;
        if (this.hej == null) {
            HandlerThread ek = com.tencent.mm.sdk.g.d.ek("MSurfaceView#Rending-Thread", -19);
            ek.start();
            this.hej = new ak(ek.getLooper());
        }
        AppMethodBeat.o(103788);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        AppMethodBeat.i(103789);
        d.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", Integer.valueOf(hashCode()));
        AppMethodBeat.o(103789);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(103790);
        d.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", Integer.valueOf(hashCode()));
        this.mDestroyed = true;
        this.hej.getLooper().quit();
        this.hej = null;
        AppMethodBeat.o(103790);
    }

    public void setTraceId(String str) {
        AppMethodBeat.i(103791);
        this.hef.setTraceId(str);
        AppMethodBeat.o(103791);
    }

    public String getTraceId() {
        AppMethodBeat.i(103792);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.o(103792);
        return traceId;
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(103793);
        d.i("MicroMsg.MSurfaceView", "draw(%s)", Integer.valueOf(hashCode()));
        canvas.drawColor(0, Mode.CLEAR);
        super.draw(canvas);
        AppMethodBeat.o(103793);
    }

    public final void ayc() {
        AppMethodBeat.i(103794);
        C(new Runnable() {
            public final void run() {
                AppMethodBeat.i(103783);
                if (MSurfaceView.this.mDestroyed) {
                    AppMethodBeat.o(103783);
                    return;
                }
                Canvas lockCanvas = MSurfaceView.this.hei.lockCanvas();
                if (lockCanvas == null) {
                    AppMethodBeat.o(103783);
                    return;
                }
                lockCanvas.drawColor(-1);
                MSurfaceView.this.e(lockCanvas);
                MSurfaceView.this.hei.unlockCanvasAndPost(lockCanvas);
                AppMethodBeat.o(103783);
            }
        });
        AppMethodBeat.o(103794);
    }

    public final void C(Runnable runnable) {
        AppMethodBeat.i(103795);
        if (this.hej == null) {
            AppMethodBeat.o(103795);
            return;
        }
        this.hej.post(runnable);
        AppMethodBeat.o(103795);
    }

    public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext() {
        AppMethodBeat.i(103796);
        com.tencent.mm.plugin.appbrand.canvas.d drawContext = this.hef.getDrawContext();
        AppMethodBeat.o(103796);
        return drawContext;
    }

    public void setDrawActionReportable(a aVar) {
        AppMethodBeat.i(103797);
        this.hef.setDrawActionReportable(aVar);
        AppMethodBeat.o(103797);
    }

    public final boolean e(Canvas canvas) {
        AppMethodBeat.i(103798);
        boolean e = this.hef.e(canvas);
        AppMethodBeat.o(103798);
        return e;
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(103799);
        this.hef.a(jSONArray, aVar);
        AppMethodBeat.o(103799);
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(103800);
        this.hef.b(jSONArray, aVar);
        AppMethodBeat.o(103800);
    }

    public final void a(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(103801);
        this.hef.a(drawCanvasArg, aVar);
        AppMethodBeat.o(103801);
    }

    public final void b(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(103802);
        this.hef.b(drawCanvasArg, aVar);
        AppMethodBeat.o(103802);
    }

    public final void ayd() {
        AppMethodBeat.i(103803);
        this.hef.ayd();
        AppMethodBeat.o(103803);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103804);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(103804);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103804);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103805);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103805);
    }

    public final void onResume() {
        AppMethodBeat.i(103806);
        this.hef.onResume();
        AppMethodBeat.o(103806);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.i(103807);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.o(103807);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.i(103808);
        this.hef.setSessionId(str);
        AppMethodBeat.o(103808);
    }

    public void setStartTime(long j) {
        AppMethodBeat.i(103809);
        this.hef.setStartTime(j);
        AppMethodBeat.o(103809);
    }

    public final void aye() {
        AppMethodBeat.i(103810);
        this.hef.aye();
        AppMethodBeat.o(103810);
    }
}
