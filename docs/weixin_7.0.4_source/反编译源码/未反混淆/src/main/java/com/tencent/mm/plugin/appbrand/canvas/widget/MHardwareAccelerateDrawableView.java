package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.b;
import com.tencent.mm.plugin.appbrand.canvas.c.a;
import com.tencent.mm.plugin.appbrand.canvas.d;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MHardwareAccelerateDrawableView extends View implements a {
    private final b hef = new b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();

    public MHardwareAccelerateDrawableView(Context context) {
        super(context);
        AppMethodBeat.i(103759);
        setLayerType(2, null);
        AppMethodBeat.o(103759);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(103760);
        setLayerType(2, null);
        AppMethodBeat.o(103760);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(103761);
        setLayerType(2, null);
        AppMethodBeat.o(103761);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(103762);
        e(canvas);
        AppMethodBeat.o(103762);
    }

    public void setTraceId(String str) {
        AppMethodBeat.i(103763);
        this.hef.setTraceId(str);
        AppMethodBeat.o(103763);
    }

    public String getTraceId() {
        AppMethodBeat.i(103764);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.o(103764);
        return traceId;
    }

    public final void ayc() {
        AppMethodBeat.i(103765);
        postInvalidate();
        AppMethodBeat.o(103765);
    }

    public final void C(Runnable runnable) {
        AppMethodBeat.i(103766);
        this.hef.C(runnable);
        AppMethodBeat.o(103766);
    }

    public d getDrawContext() {
        AppMethodBeat.i(103767);
        d drawContext = this.hef.getDrawContext();
        AppMethodBeat.o(103767);
        return drawContext;
    }

    public void setDrawActionReportable(a aVar) {
        AppMethodBeat.i(103768);
        this.hef.setDrawActionReportable(aVar);
        AppMethodBeat.o(103768);
    }

    public final boolean e(Canvas canvas) {
        AppMethodBeat.i(103769);
        boolean e = this.hef.e(canvas);
        AppMethodBeat.o(103769);
        return e;
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(103770);
        this.hef.a(jSONArray, aVar);
        AppMethodBeat.o(103770);
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(103771);
        this.hef.b(jSONArray, aVar);
        AppMethodBeat.o(103771);
    }

    public final void a(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(103772);
        this.hef.a(drawCanvasArg, aVar);
        AppMethodBeat.o(103772);
    }

    public final void b(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(103773);
        this.hef.b(drawCanvasArg, aVar);
        AppMethodBeat.o(103773);
    }

    public final void ayd() {
        AppMethodBeat.i(103774);
        this.hef.ayd();
        AppMethodBeat.o(103774);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103775);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(103775);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103775);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103776);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103776);
    }

    public final void onResume() {
        AppMethodBeat.i(103777);
        this.hef.onResume();
        AppMethodBeat.o(103777);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.i(103778);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.o(103778);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.i(103779);
        this.hef.setSessionId(str);
        AppMethodBeat.o(103779);
    }

    public void setStartTime(long j) {
        AppMethodBeat.i(103780);
        this.hef.setStartTime(j);
        AppMethodBeat.o(103780);
    }

    public final void aye() {
        AppMethodBeat.i(103781);
        this.hef.aye();
        AppMethodBeat.o(103781);
    }
}
