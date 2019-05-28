package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.c.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView extends TextureView implements SurfaceTextureListener, a {
    private final b hef = new b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();
    private volatile ak hej;
    private Runnable hek = new Runnable() {
        public final void run() {
            AppMethodBeat.i(103811);
            if (MTextureView.this.isAvailable()) {
                Canvas lockCanvas = MTextureView.this.lockCanvas();
                if (lockCanvas == null) {
                    AppMethodBeat.o(103811);
                    return;
                }
                synchronized (MTextureView.this.mLock) {
                    try {
                        MTextureView.this.hem = true;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(103811);
                    }
                }
                lockCanvas.drawColor(-1);
                MTextureView.this.e(lockCanvas);
                MTextureView.this.unlockCanvasAndPost(lockCanvas);
                synchronized (MTextureView.this.mLock) {
                    try {
                        MTextureView.this.hem = false;
                        MTextureView.this.mLock.notifyAll();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(103811);
                        }
                    }
                }
                return;
            }
            AppMethodBeat.o(103811);
        }
    };
    private volatile boolean hem;
    private volatile Object mLock = new Object();

    public MTextureView(Context context) {
        super(context);
        AppMethodBeat.i(103812);
        init();
        AppMethodBeat.o(103812);
    }

    public MTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(103813);
        init();
        AppMethodBeat.o(103813);
    }

    public MTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(103814);
        init();
        AppMethodBeat.o(103814);
    }

    private void init() {
        AppMethodBeat.i(103815);
        setSurfaceTextureListener(this);
        ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.hef.getDrawContext().hcJ = paint;
        AppMethodBeat.o(103815);
    }

    public void setTraceId(String str) {
        AppMethodBeat.i(103816);
        this.hef.setTraceId(str);
        AppMethodBeat.o(103816);
    }

    public String getTraceId() {
        AppMethodBeat.i(103817);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.o(103817);
        return traceId;
    }

    public final void ayc() {
        AppMethodBeat.i(103818);
        if (this.hej == null) {
            AppMethodBeat.o(103818);
            return;
        }
        this.hej.removeCallbacks(this.hek);
        this.hej.post(this.hek);
        AppMethodBeat.o(103818);
    }

    public final void C(Runnable runnable) {
        AppMethodBeat.i(103819);
        if (this.hej == null) {
            AppMethodBeat.o(103819);
            return;
        }
        this.hej.post(runnable);
        AppMethodBeat.o(103819);
    }

    public d getDrawContext() {
        AppMethodBeat.i(103820);
        d drawContext = this.hef.getDrawContext();
        AppMethodBeat.o(103820);
        return drawContext;
    }

    public void setDrawActionReportable(a aVar) {
        AppMethodBeat.i(103821);
        this.hef.setDrawActionReportable(aVar);
        AppMethodBeat.o(103821);
    }

    public final boolean e(Canvas canvas) {
        AppMethodBeat.i(103822);
        boolean e = this.hef.e(canvas);
        AppMethodBeat.o(103822);
        return e;
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(103823);
        this.hef.a(jSONArray, aVar);
        AppMethodBeat.o(103823);
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(103824);
        this.hef.b(jSONArray, aVar);
        AppMethodBeat.o(103824);
    }

    public final void a(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(103825);
        this.hef.a(drawCanvasArg, aVar);
        AppMethodBeat.o(103825);
    }

    public final void b(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(103826);
        this.hef.b(drawCanvasArg, aVar);
        AppMethodBeat.o(103826);
    }

    public final void ayd() {
        AppMethodBeat.i(103827);
        this.hef.ayd();
        AppMethodBeat.o(103827);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103828);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(103828);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103828);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103829);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103829);
    }

    public final void onResume() {
        AppMethodBeat.i(103830);
        this.hef.onResume();
        AppMethodBeat.o(103830);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.i(103831);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.o(103831);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.i(103832);
        this.hef.setSessionId(str);
        AppMethodBeat.o(103832);
    }

    public void setStartTime(long j) {
        AppMethodBeat.i(103833);
        this.hef.setStartTime(j);
        AppMethodBeat.o(103833);
    }

    public final void aye() {
        AppMethodBeat.i(103834);
        this.hef.aye();
        AppMethodBeat.o(103834);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(103835);
        com.tencent.luggage.g.d.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
        if (this.hej == null) {
            HandlerThread ek = com.tencent.mm.sdk.g.d.ek("MTextureView#Rending-Thread", -19);
            ek.start();
            this.hej = new ak(ek.getLooper());
        }
        Canvas lockCanvas = lockCanvas();
        if (lockCanvas == null) {
            AppMethodBeat.o(103835);
            return;
        }
        lockCanvas.drawColor(-1);
        unlockCanvasAndPost(lockCanvas);
        AppMethodBeat.o(103835);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.i(103836);
        com.tencent.luggage.g.d.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
        AppMethodBeat.o(103836);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(103837);
        com.tencent.luggage.g.d.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
        this.hej.removeCallbacks(this.hek);
        this.hej.getLooper().quit();
        synchronized (this.mLock) {
            try {
                if (this.hem) {
                    this.mLock.wait(1000);
                }
            } catch (InterruptedException e) {
                com.tencent.luggage.g.d.e("MicroMsg.MTextureView", "await error : %s", Log.getStackTraceString(e));
            } catch (Throwable th) {
                AppMethodBeat.o(103837);
            }
        }
        this.hej = null;
        AppMethodBeat.o(103837);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
