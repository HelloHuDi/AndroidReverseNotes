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

public class MDrawableView extends View implements a {
    private final b hef = new b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();

    public MDrawableView(Context context) {
        super(context);
        AppMethodBeat.i(103736);
        setLayerType(1, null);
        AppMethodBeat.o(103736);
    }

    public MDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(103737);
        setLayerType(1, null);
        AppMethodBeat.o(103737);
    }

    public MDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(103738);
        setLayerType(1, null);
        AppMethodBeat.o(103738);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(103739);
        e(canvas);
        AppMethodBeat.o(103739);
    }

    public final void ayc() {
        AppMethodBeat.i(103740);
        postInvalidate();
        AppMethodBeat.o(103740);
    }

    public final void C(Runnable runnable) {
        AppMethodBeat.i(103741);
        post(runnable);
        AppMethodBeat.o(103741);
    }

    public d getDrawContext() {
        AppMethodBeat.i(103742);
        d drawContext = this.hef.getDrawContext();
        AppMethodBeat.o(103742);
        return drawContext;
    }

    public void setDrawActionReportable(a aVar) {
        AppMethodBeat.i(103743);
        this.hef.setDrawActionReportable(aVar);
        AppMethodBeat.o(103743);
    }

    public void setTraceId(String str) {
        AppMethodBeat.i(103744);
        this.hef.setTraceId(str);
        AppMethodBeat.o(103744);
    }

    public String getTraceId() {
        AppMethodBeat.i(103745);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.o(103745);
        return traceId;
    }

    public final boolean e(Canvas canvas) {
        AppMethodBeat.i(103746);
        boolean e = this.hef.e(canvas);
        AppMethodBeat.o(103746);
        return e;
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(103747);
        this.hef.a(jSONArray, aVar);
        AppMethodBeat.o(103747);
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        AppMethodBeat.i(103748);
        this.hef.b(jSONArray, aVar);
        AppMethodBeat.o(103748);
    }

    public final void a(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(103749);
        this.hef.a(drawCanvasArg, aVar);
        AppMethodBeat.o(103749);
    }

    public final void b(DrawCanvasArg drawCanvasArg, a.a aVar) {
        AppMethodBeat.i(103750);
        this.hef.b(drawCanvasArg, aVar);
        AppMethodBeat.o(103750);
    }

    public final void ayd() {
        AppMethodBeat.i(103751);
        this.hef.ayd();
        AppMethodBeat.o(103751);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103752);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.o(103752);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103752);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.i(103753);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.o(103753);
    }

    public final void onResume() {
        AppMethodBeat.i(103754);
        this.hef.onResume();
        AppMethodBeat.o(103754);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.i(103755);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.o(103755);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.i(103756);
        this.hef.setSessionId(str);
        AppMethodBeat.o(103756);
    }

    public void setStartTime(long j) {
        AppMethodBeat.i(103757);
        this.hef.setStartTime(j);
        AppMethodBeat.o(103757);
    }

    public final void aye() {
        AppMethodBeat.i(103758);
        this.hef.aye();
        AppMethodBeat.o(103758);
    }
}
