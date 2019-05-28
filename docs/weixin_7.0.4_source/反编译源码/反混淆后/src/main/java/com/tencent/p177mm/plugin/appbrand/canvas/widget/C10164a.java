package com.tencent.p177mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.p1601c.C42400a;
import com.tencent.p177mm.plugin.appbrand.collector.C2108d;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.a */
public interface C10164a extends C26824b, C2108d {

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.widget.a$a */
    public interface C10165a {
        /* renamed from: a */
        void mo6094a(DrawCanvasArg drawCanvasArg);
    }

    /* renamed from: C */
    void mo21533C(Runnable runnable);

    /* renamed from: a */
    void mo21534a(DrawCanvasArg drawCanvasArg, C10165a c10165a);

    /* renamed from: a */
    void mo21535a(JSONArray jSONArray, C10165a c10165a);

    void ayc();

    void ayd();

    /* renamed from: b */
    void mo21538b(DrawCanvasArg drawCanvasArg, C10165a c10165a);

    /* renamed from: b */
    void mo21539b(JSONArray jSONArray, C10165a c10165a);

    /* renamed from: e */
    boolean mo21540e(Canvas canvas);

    C2102d getDrawContext();

    String getTraceId();

    void setDrawActionReportable(C42400a c42400a);

    void setTraceId(String str);
}
