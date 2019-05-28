package com.tencent.p177mm.plugin.appbrand.canvas.widget;

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

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView */
public class MTextureView extends TextureView implements SurfaceTextureListener, C10164a {
    private final C38155b hef = new C38155b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();
    private volatile C7306ak hej;
    private Runnable hek = new C268231();
    private volatile boolean hem;
    private volatile Object mLock = new Object();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MTextureView$1 */
    class C268231 implements Runnable {
        C268231() {
        }

        public final void run() {
            AppMethodBeat.m2504i(103811);
            if (MTextureView.this.isAvailable()) {
                Canvas lockCanvas = MTextureView.this.lockCanvas();
                if (lockCanvas == null) {
                    AppMethodBeat.m2505o(103811);
                    return;
                }
                synchronized (MTextureView.this.mLock) {
                    try {
                        MTextureView.this.hem = true;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(103811);
                    }
                }
                lockCanvas.drawColor(-1);
                MTextureView.this.mo21540e(lockCanvas);
                MTextureView.this.unlockCanvasAndPost(lockCanvas);
                synchronized (MTextureView.this.mLock) {
                    try {
                        MTextureView.this.hem = false;
                        MTextureView.this.mLock.notifyAll();
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(103811);
                        }
                    }
                }
                return;
            }
            AppMethodBeat.m2505o(103811);
        }
    }

    public MTextureView(Context context) {
        super(context);
        AppMethodBeat.m2504i(103812);
        init();
        AppMethodBeat.m2505o(103812);
    }

    public MTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(103813);
        init();
        AppMethodBeat.m2505o(103813);
    }

    public MTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(103814);
        init();
        AppMethodBeat.m2505o(103814);
    }

    private void init() {
        AppMethodBeat.m2504i(103815);
        setSurfaceTextureListener(this);
        ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.hef.getDrawContext().hcJ = paint;
        AppMethodBeat.m2505o(103815);
    }

    public void setTraceId(String str) {
        AppMethodBeat.m2504i(103816);
        this.hef.setTraceId(str);
        AppMethodBeat.m2505o(103816);
    }

    public String getTraceId() {
        AppMethodBeat.m2504i(103817);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.m2505o(103817);
        return traceId;
    }

    public final void ayc() {
        AppMethodBeat.m2504i(103818);
        if (this.hej == null) {
            AppMethodBeat.m2505o(103818);
            return;
        }
        this.hej.removeCallbacks(this.hek);
        this.hej.post(this.hek);
        AppMethodBeat.m2505o(103818);
    }

    /* renamed from: C */
    public final void mo21533C(Runnable runnable) {
        AppMethodBeat.m2504i(103819);
        if (this.hej == null) {
            AppMethodBeat.m2505o(103819);
            return;
        }
        this.hej.post(runnable);
        AppMethodBeat.m2505o(103819);
    }

    public C2102d getDrawContext() {
        AppMethodBeat.m2504i(103820);
        C2102d drawContext = this.hef.getDrawContext();
        AppMethodBeat.m2505o(103820);
        return drawContext;
    }

    public void setDrawActionReportable(C42400a c42400a) {
        AppMethodBeat.m2504i(103821);
        this.hef.setDrawActionReportable(c42400a);
        AppMethodBeat.m2505o(103821);
    }

    /* renamed from: e */
    public final boolean mo21540e(Canvas canvas) {
        AppMethodBeat.m2504i(103822);
        boolean e = this.hef.mo21540e(canvas);
        AppMethodBeat.m2505o(103822);
        return e;
    }

    /* renamed from: a */
    public final void mo21535a(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103823);
        this.hef.mo21535a(jSONArray, c10165a);
        AppMethodBeat.m2505o(103823);
    }

    /* renamed from: b */
    public final void mo21539b(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103824);
        this.hef.mo21539b(jSONArray, c10165a);
        AppMethodBeat.m2505o(103824);
    }

    /* renamed from: a */
    public final void mo21534a(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103825);
        this.hef.mo21534a(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103825);
    }

    /* renamed from: b */
    public final void mo21538b(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103826);
        this.hef.mo21538b(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103826);
    }

    public final void ayd() {
        AppMethodBeat.m2504i(103827);
        this.hef.ayd();
        AppMethodBeat.m2505o(103827);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103828);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.m2505o(103828);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103828);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103829);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103829);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(103830);
        this.hef.onResume();
        AppMethodBeat.m2505o(103830);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.m2504i(103831);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.m2505o(103831);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.m2504i(103832);
        this.hef.setSessionId(str);
        AppMethodBeat.m2505o(103832);
    }

    public void setStartTime(long j) {
        AppMethodBeat.m2504i(103833);
        this.hef.setStartTime(j);
        AppMethodBeat.m2505o(103833);
    }

    public final void aye() {
        AppMethodBeat.m2504i(103834);
        this.hef.aye();
        AppMethodBeat.m2505o(103834);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(103835);
        C45124d.m82931v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
        if (this.hej == null) {
            HandlerThread ek = C7305d.m12297ek("MTextureView#Rending-Thread", -19);
            ek.start();
            this.hej = new C7306ak(ek.getLooper());
        }
        Canvas lockCanvas = lockCanvas();
        if (lockCanvas == null) {
            AppMethodBeat.m2505o(103835);
            return;
        }
        lockCanvas.drawColor(-1);
        unlockCanvasAndPost(lockCanvas);
        AppMethodBeat.m2505o(103835);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        AppMethodBeat.m2504i(103836);
        C45124d.m82931v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
        AppMethodBeat.m2505o(103836);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(103837);
        C45124d.m82931v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
        this.hej.removeCallbacks(this.hek);
        this.hej.getLooper().quit();
        synchronized (this.mLock) {
            try {
                if (this.hem) {
                    this.mLock.wait(1000);
                }
            } catch (InterruptedException e) {
                C45124d.m82928e("MicroMsg.MTextureView", "await error : %s", Log.getStackTraceString(e));
            } catch (Throwable th) {
                AppMethodBeat.m2505o(103837);
            }
        }
        this.hej = null;
        AppMethodBeat.m2505o(103837);
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
