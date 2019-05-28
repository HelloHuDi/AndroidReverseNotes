package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewParent;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MCanvasView extends View implements a {
    private final b hef = new b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();
    private Bitmap mBitmap;

    public MCanvasView(Context context) {
        super(context);
        AppMethodBeat.i(103712);
        AppMethodBeat.o(103712);
    }

    public MCanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(103713);
        AppMethodBeat.o(103713);
    }

    public MCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(103714);
        AppMethodBeat.o(103714);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(103715);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth <= 0 || measuredHeight <= 0) {
            AppMethodBeat.o(103715);
            return;
        }
        if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mBitmap.getWidth() != measuredWidth || this.mBitmap.getHeight() != measuredHeight) {
            if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                d.i("MicroMsg.MCanvasView", "bitmap recycle %s", this.mBitmap);
                this.mBitmap.recycle();
            }
            this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            d.v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
        }
        if (this.mBitmap == null) {
            d.d("MicroMsg.MCanvasView", "bitmap is null.");
            AppMethodBeat.o(103715);
            return;
        }
        this.mBitmap.eraseColor(0);
        f fVar = new f(this.mBitmap);
        e(fVar);
        try {
            canvas.drawBitmap(fVar.mBitmap, 0.0f, 0.0f, null);
            AppMethodBeat.o(103715);
        } catch (Exception e) {
            d.printErrStackTrace("MicroMsg.MCanvasView", e, "", new Object[0]);
            e(canvas);
            AppMethodBeat.o(103715);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(103716);
        super.onSizeChanged(i, i2, i3, i4);
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            d.i("MicroMsg.MCanvasView", "bitmap recycle %s", this.mBitmap);
            this.mBitmap.recycle();
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            d.v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
        }
        AppMethodBeat.o(103716);
    }

    public final boolean e(Canvas canvas) {
        AppMethodBeat.i(103717);
        boolean e = this.hef.e(canvas);
        AppMethodBeat.o(103717);
        return e;
    }

    public final void ayc() {
        AppMethodBeat.i(103718);
        if (s.as(this)) {
            postInvalidate();
            AppMethodBeat.o(103718);
            return;
        }
        post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(103711);
                ViewParent parent = MCanvasView.this.getParent();
                do {
                    ((View) parent).forceLayout();
                    parent = parent.getParent();
                } while (parent instanceof View);
                if (parent != null) {
                    parent.requestLayout();
                    MCanvasView.this.invalidate();
                }
                AppMethodBeat.o(103711);
            }
        });
        AppMethodBeat.o(103718);
    }

    public final void a(JSONArray jSONArray, a aVar) {
        AppMethodBeat.i(103719);
        this.hef.a(jSONArray, aVar);
        AppMethodBeat.o(103719);
    }

    public final void b(JSONArray jSONArray, a aVar) {
        AppMethodBeat.i(103720);
        this.hef.b(jSONArray, aVar);
        AppMethodBeat.o(103720);
    }

    public final void a(DrawCanvasArg drawCanvasArg, a aVar) {
        AppMethodBeat.i(103721);
        this.hef.a(drawCanvasArg, aVar);
        AppMethodBeat.o(103721);
    }

    public final void b(DrawCanvasArg drawCanvasArg, a aVar) {
        AppMethodBeat.i(103722);
        this.hef.b(drawCanvasArg, aVar);
        AppMethodBeat.o(103722);
    }

    public final void ayd() {
        AppMethodBeat.i(103723);
        this.hef.ayd();
        AppMethodBeat.o(103723);
    }

    public final void C(Runnable runnable) {
        AppMethodBeat.i(103724);
        post(runnable);
        AppMethodBeat.o(103724);
    }

    public com.tencent.mm.plugin.appbrand.canvas.d getDrawContext() {
        AppMethodBeat.i(103725);
        com.tencent.mm.plugin.appbrand.canvas.d drawContext = this.hef.getDrawContext();
        AppMethodBeat.o(103725);
        return drawContext;
    }

    public void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a aVar) {
        AppMethodBeat.i(103726);
        this.hef.setDrawActionReportable(aVar);
        AppMethodBeat.o(103726);
    }

    public void setTraceId(String str) {
        AppMethodBeat.i(103727);
        this.hef.setTraceId(str);
        AppMethodBeat.o(103727);
    }

    public String getTraceId() {
        AppMethodBeat.i(103728);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.o(103728);
        return traceId;
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103729);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(103729);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103729);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103730);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103730);
    }

    public final void onResume() {
        AppMethodBeat.i(103731);
        this.hef.onResume();
        AppMethodBeat.o(103731);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.i(103732);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.o(103732);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.i(103733);
        this.hef.setSessionId(str);
        AppMethodBeat.o(103733);
    }

    public void setStartTime(long j) {
        AppMethodBeat.i(103734);
        this.hef.setStartTime(j);
        AppMethodBeat.o(103734);
    }

    public final void aye() {
        AppMethodBeat.i(103735);
        this.hef.aye();
        AppMethodBeat.o(103735);
    }
}
