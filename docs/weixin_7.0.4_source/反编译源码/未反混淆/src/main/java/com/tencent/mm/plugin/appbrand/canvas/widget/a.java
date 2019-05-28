package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.collector.d;
import org.json.JSONArray;

public interface a extends b, d {

    public interface a {
        void a(DrawCanvasArg drawCanvasArg);
    }

    void C(Runnable runnable);

    void a(DrawCanvasArg drawCanvasArg, a aVar);

    void a(JSONArray jSONArray, a aVar);

    void ayc();

    void ayd();

    void b(DrawCanvasArg drawCanvasArg, a aVar);

    void b(JSONArray jSONArray, a aVar);

    boolean e(Canvas canvas);

    com.tencent.mm.plugin.appbrand.canvas.d getDrawContext();

    String getTraceId();

    void setDrawActionReportable(com.tencent.mm.plugin.appbrand.canvas.c.a aVar);

    void setTraceId(String str);
}
