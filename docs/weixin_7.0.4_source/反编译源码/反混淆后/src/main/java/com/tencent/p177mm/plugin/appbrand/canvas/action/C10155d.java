package com.tencent.p177mm.plugin.appbrand.canvas.action;

import android.graphics.Canvas;
import com.tencent.p177mm.plugin.appbrand.canvas.C2102d;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.BaseDrawActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.DrawActionArg;
import org.json.JSONArray;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.action.d */
public interface C10155d {
    /* renamed from: a */
    boolean mo5872a(C2102d c2102d, Canvas canvas, DrawActionArg drawActionArg);

    /* renamed from: a */
    boolean mo5873a(C2102d c2102d, Canvas canvas, JSONArray jSONArray);

    BaseDrawActionArg ayf();

    String getMethod();
}
