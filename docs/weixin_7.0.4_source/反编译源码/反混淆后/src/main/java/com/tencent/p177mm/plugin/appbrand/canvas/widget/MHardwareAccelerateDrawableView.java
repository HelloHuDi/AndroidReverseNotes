package com.tencent.p177mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.C38155b;
import com.tencent.p177mm.plugin.appbrand.canvas.p1601c.C42400a;
import com.tencent.p177mm.plugin.appbrand.canvas.widget.C10164a.C10165a;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MHardwareAccelerateDrawableView */
public class MHardwareAccelerateDrawableView extends View implements C10164a {
    private final C38155b hef = new C38155b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();

    public MHardwareAccelerateDrawableView(Context context) {
        super(context);
        AppMethodBeat.m2504i(103759);
        setLayerType(2, null);
        AppMethodBeat.m2505o(103759);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(103760);
        setLayerType(2, null);
        AppMethodBeat.m2505o(103760);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(103761);
        setLayerType(2, null);
        AppMethodBeat.m2505o(103761);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(103762);
        mo21540e(canvas);
        AppMethodBeat.m2505o(103762);
    }

    public void setTraceId(String str) {
        AppMethodBeat.m2504i(103763);
        this.hef.setTraceId(str);
        AppMethodBeat.m2505o(103763);
    }

    public String getTraceId() {
        AppMethodBeat.m2504i(103764);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.m2505o(103764);
        return traceId;
    }

    public final void ayc() {
        AppMethodBeat.m2504i(103765);
        postInvalidate();
        AppMethodBeat.m2505o(103765);
    }

    /* renamed from: C */
    public final void mo21533C(Runnable runnable) {
        AppMethodBeat.m2504i(103766);
        this.hef.mo21533C(runnable);
        AppMethodBeat.m2505o(103766);
    }

    public C2102d getDrawContext() {
        AppMethodBeat.m2504i(103767);
        C2102d drawContext = this.hef.getDrawContext();
        AppMethodBeat.m2505o(103767);
        return drawContext;
    }

    public void setDrawActionReportable(C42400a c42400a) {
        AppMethodBeat.m2504i(103768);
        this.hef.setDrawActionReportable(c42400a);
        AppMethodBeat.m2505o(103768);
    }

    /* renamed from: e */
    public final boolean mo21540e(Canvas canvas) {
        AppMethodBeat.m2504i(103769);
        boolean e = this.hef.mo21540e(canvas);
        AppMethodBeat.m2505o(103769);
        return e;
    }

    /* renamed from: a */
    public final void mo21535a(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103770);
        this.hef.mo21535a(jSONArray, c10165a);
        AppMethodBeat.m2505o(103770);
    }

    /* renamed from: b */
    public final void mo21539b(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103771);
        this.hef.mo21539b(jSONArray, c10165a);
        AppMethodBeat.m2505o(103771);
    }

    /* renamed from: a */
    public final void mo21534a(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103772);
        this.hef.mo21534a(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103772);
    }

    /* renamed from: b */
    public final void mo21538b(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103773);
        this.hef.mo21538b(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103773);
    }

    public final void ayd() {
        AppMethodBeat.m2504i(103774);
        this.hef.ayd();
        AppMethodBeat.m2505o(103774);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103775);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.m2505o(103775);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103775);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103776);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103776);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(103777);
        this.hef.onResume();
        AppMethodBeat.m2505o(103777);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.m2504i(103778);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.m2505o(103778);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.m2504i(103779);
        this.hef.setSessionId(str);
        AppMethodBeat.m2505o(103779);
    }

    public void setStartTime(long j) {
        AppMethodBeat.m2504i(103780);
        this.hef.setStartTime(j);
        AppMethodBeat.m2505o(103780);
    }

    public final void aye() {
        AppMethodBeat.m2504i(103781);
        this.hef.aye();
        AppMethodBeat.m2505o(103781);
    }
}
