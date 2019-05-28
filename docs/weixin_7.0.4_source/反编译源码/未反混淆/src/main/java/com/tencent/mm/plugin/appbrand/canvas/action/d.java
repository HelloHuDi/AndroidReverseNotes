package com.tencent.mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import org.json.JSONArray;

public interface d {
    boolean a(com.tencent.mm.plugin.appbrand.canvas.d dVar, Canvas canvas, DrawActionArg drawActionArg);

    boolean a(com.tencent.mm.plugin.appbrand.canvas.d dVar, Canvas canvas, JSONArray jSONArray);

    BaseDrawActionArg ayf();

    String getMethod();
}
