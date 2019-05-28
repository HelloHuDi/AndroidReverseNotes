package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import org.json.JSONArray;

public interface a {
    boolean a(Path path, BasePathActionArg basePathActionArg);

    boolean a(Path path, JSONArray jSONArray);

    BasePathActionArg ayr();

    String getMethod();
}
