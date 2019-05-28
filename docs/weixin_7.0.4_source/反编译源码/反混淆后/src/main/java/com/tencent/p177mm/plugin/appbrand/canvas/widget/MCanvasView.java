package com.tencent.p177mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C19151f;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.C38155b;
import com.tencent.p177mm.plugin.appbrand.canvas.p1601c.C42400a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a.C10165a;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView */
public class MCanvasView extends View implements C10164a {
    private final C38155b hef = new C38155b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();
    private Bitmap mBitmap;

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MCanvasView$1 */
    class C101631 implements Runnable {
        C101631() {
        }

        public final void run() {
            AppMethodBeat.m2504i(103711);
            ViewParent parent = MCanvasView.this.getParent();
            do {
                ((View) parent).forceLayout();
                parent = parent.getParent();
            } while (parent instanceof View);
            if (parent != null) {
                parent.requestLayout();
                MCanvasView.this.invalidate();
            }
            AppMethodBeat.m2505o(103711);
        }
    }

    public MCanvasView(Context context) {
        super(context);
        AppMethodBeat.m2504i(103712);
        AppMethodBeat.m2505o(103712);
    }

    public MCanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(103713);
        AppMethodBeat.m2505o(103713);
    }

    public MCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(103714);
        AppMethodBeat.m2505o(103714);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(103715);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            AppMethodBeat.m2505o(103715);
            return;
        }
        if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mBitmap.getWidth() != measuredWidth || this.mBitmap.getHeight() != measuredHeight) {
            if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                C45124d.m82930i("MicroMsg.MCanvasView", "bitmap recycle %s", this.mBitmap);
                this.mBitmap.recycle();
            }
            this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            C45124d.m82932v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
        }
        if (this.mBitmap == null) {
            C45124d.m82925d("MicroMsg.MCanvasView", "bitmap is null.");
            AppMethodBeat.m2505o(103715);
            return;
        }
        this.mBitmap.eraseColor(0);
        C19151f c19151f = new C19151f(this.mBitmap);
        mo21540e(c19151f);
        try {
            canvas.drawBitmap(c19151f.mBitmap, 0.0f, 0.0f, null);
            AppMethodBeat.m2505o(103715);
        } catch (Exception e) {
            C45124d.printErrStackTrace("MicroMsg.MCanvasView", e, "", new Object[0]);
            mo21540e(canvas);
            AppMethodBeat.m2505o(103715);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(103716);
        super.onSizeChanged(i, i2, i3, i4);
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            C45124d.m82930i("MicroMsg.MCanvasView", "bitmap recycle %s", this.mBitmap);
            this.mBitmap.recycle();
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            C45124d.m82932v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
        }
        AppMethodBeat.m2505o(103716);
    }

    /* renamed from: e */
    public final boolean mo21540e(Canvas canvas) {
        AppMethodBeat.m2504i(103717);
        boolean e = this.hef.mo21540e(canvas);
        AppMethodBeat.m2505o(103717);
        return e;
    }

    public final void ayc() {
        AppMethodBeat.m2504i(103718);
        if (C0477s.m927as(this)) {
            postInvalidate();
            AppMethodBeat.m2505o(103718);
            return;
        }
        post(new C101631());
        AppMethodBeat.m2505o(103718);
    }

    /* renamed from: a */
    public final void mo21535a(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103719);
        this.hef.mo21535a(jSONArray, c10165a);
        AppMethodBeat.m2505o(103719);
    }

    /* renamed from: b */
    public final void mo21539b(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103720);
        this.hef.mo21539b(jSONArray, c10165a);
        AppMethodBeat.m2505o(103720);
    }

    /* renamed from: a */
    public final void mo21534a(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103721);
        this.hef.mo21534a(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103721);
    }

    /* renamed from: b */
    public final void mo21538b(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103722);
        this.hef.mo21538b(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103722);
    }

    public final void ayd() {
        AppMethodBeat.m2504i(103723);
        this.hef.ayd();
        AppMethodBeat.m2505o(103723);
    }

    /* renamed from: C */
    public final void mo21533C(Runnable runnable) {
        AppMethodBeat.m2504i(103724);
        post(runnable);
        AppMethodBeat.m2505o(103724);
    }

    public C2102d getDrawContext() {
        AppMethodBeat.m2504i(103725);
        C2102d drawContext = this.hef.getDrawContext();
        AppMethodBeat.m2505o(103725);
        return drawContext;
    }

    public void setDrawActionReportable(C42400a c42400a) {
        AppMethodBeat.m2504i(103726);
        this.hef.setDrawActionReportable(c42400a);
        AppMethodBeat.m2505o(103726);
    }

    public void setTraceId(String str) {
        AppMethodBeat.m2504i(103727);
        this.hef.setTraceId(str);
        AppMethodBeat.m2505o(103727);
    }

    public String getTraceId() {
        AppMethodBeat.m2504i(103728);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.m2505o(103728);
        return traceId;
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103729);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.m2505o(103729);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103729);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103730);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103730);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(103731);
        this.hef.onResume();
        AppMethodBeat.m2505o(103731);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.m2504i(103732);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.m2505o(103732);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.m2504i(103733);
        this.hef.setSessionId(str);
        AppMethodBeat.m2505o(103733);
    }

    public void setStartTime(long j) {
        AppMethodBeat.m2504i(103734);
        this.hef.setStartTime(j);
        AppMethodBeat.m2505o(103734);
    }

    public final void aye() {
        AppMethodBeat.m2504i(103735);
        this.hef.aye();
        AppMethodBeat.m2505o(103735);
    }
}
