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

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.MDrawableView */
public class MDrawableView extends View implements C10164a {
    private final C38155b hef = new C38155b(this);
    private final Set<OnAttachStateChangeListener> heg = new LinkedHashSet();

    public MDrawableView(Context context) {
        super(context);
        AppMethodBeat.m2504i(103736);
        setLayerType(1, null);
        AppMethodBeat.m2505o(103736);
    }

    public MDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(103737);
        setLayerType(1, null);
        AppMethodBeat.m2505o(103737);
    }

    public MDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(103738);
        setLayerType(1, null);
        AppMethodBeat.m2505o(103738);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(103739);
        mo21540e(canvas);
        AppMethodBeat.m2505o(103739);
    }

    public final void ayc() {
        AppMethodBeat.m2504i(103740);
        postInvalidate();
        AppMethodBeat.m2505o(103740);
    }

    /* renamed from: C */
    public final void mo21533C(Runnable runnable) {
        AppMethodBeat.m2504i(103741);
        post(runnable);
        AppMethodBeat.m2505o(103741);
    }

    public C2102d getDrawContext() {
        AppMethodBeat.m2504i(103742);
        C2102d drawContext = this.hef.getDrawContext();
        AppMethodBeat.m2505o(103742);
        return drawContext;
    }

    public void setDrawActionReportable(C42400a c42400a) {
        AppMethodBeat.m2504i(103743);
        this.hef.setDrawActionReportable(c42400a);
        AppMethodBeat.m2505o(103743);
    }

    public void setTraceId(String str) {
        AppMethodBeat.m2504i(103744);
        this.hef.setTraceId(str);
        AppMethodBeat.m2505o(103744);
    }

    public String getTraceId() {
        AppMethodBeat.m2504i(103745);
        String traceId = this.hef.getTraceId();
        AppMethodBeat.m2505o(103745);
        return traceId;
    }

    /* renamed from: e */
    public final boolean mo21540e(Canvas canvas) {
        AppMethodBeat.m2504i(103746);
        boolean e = this.hef.mo21540e(canvas);
        AppMethodBeat.m2505o(103746);
        return e;
    }

    /* renamed from: a */
    public final void mo21535a(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103747);
        this.hef.mo21535a(jSONArray, c10165a);
        AppMethodBeat.m2505o(103747);
    }

    /* renamed from: b */
    public final void mo21539b(JSONArray jSONArray, C10165a c10165a) {
        AppMethodBeat.m2504i(103748);
        this.hef.mo21539b(jSONArray, c10165a);
        AppMethodBeat.m2505o(103748);
    }

    /* renamed from: a */
    public final void mo21534a(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103749);
        this.hef.mo21534a(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103749);
    }

    /* renamed from: b */
    public final void mo21538b(DrawCanvasArg drawCanvasArg, C10165a c10165a) {
        AppMethodBeat.m2504i(103750);
        this.hef.mo21538b(drawCanvasArg, c10165a);
        AppMethodBeat.m2505o(103750);
    }

    public final void ayd() {
        AppMethodBeat.m2504i(103751);
        this.hef.ayd();
        AppMethodBeat.m2505o(103751);
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103752);
        if (this.heg.contains(onAttachStateChangeListener)) {
            AppMethodBeat.m2505o(103752);
            return;
        }
        this.heg.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103752);
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        AppMethodBeat.m2504i(103753);
        this.heg.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        AppMethodBeat.m2505o(103753);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(103754);
        this.hef.onResume();
        AppMethodBeat.m2505o(103754);
    }

    public final boolean isPaused() {
        return this.hef.mPause;
    }

    public String getSessionId() {
        AppMethodBeat.m2504i(103755);
        String sessionId = this.hef.getSessionId();
        AppMethodBeat.m2505o(103755);
        return sessionId;
    }

    public void setSessionId(String str) {
        AppMethodBeat.m2504i(103756);
        this.hef.setSessionId(str);
        AppMethodBeat.m2505o(103756);
    }

    public void setStartTime(long j) {
        AppMethodBeat.m2504i(103757);
        this.hef.setStartTime(j);
        AppMethodBeat.m2505o(103757);
    }

    public final void aye() {
        AppMethodBeat.m2504i(103758);
        this.hef.aye();
        AppMethodBeat.m2505o(103758);
    }
}
