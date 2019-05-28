package com.tencent.mm.plugin.appbrand.canvas.b;

import android.graphics.Path;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public Map<String, a> hdS = new HashMap();

    public static class a {
        public static e hdT = new e();

        static {
            AppMethodBeat.i(103676);
            AppMethodBeat.o(103676);
        }
    }

    public e() {
        AppMethodBeat.i(103677);
        a(new h());
        a(new f());
        a(new g());
        a(new i());
        a(new d());
        a(new b());
        a(new c());
        a(new j());
        AppMethodBeat.o(103677);
    }

    public final Path a(PathActionArgWrapper pathActionArgWrapper) {
        AppMethodBeat.i(103678);
        Path path = new Path();
        List<BasePathActionArg> list = pathActionArgWrapper.hdv;
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(103678);
            return path;
        }
        for (BasePathActionArg basePathActionArg : list) {
            if (basePathActionArg != null) {
                b(path, basePathActionArg);
            }
        }
        AppMethodBeat.o(103678);
        return path;
    }

    private boolean b(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.i(103679);
        a aVar = (a) this.hdS.get(basePathActionArg.method);
        if (aVar == null) {
            AppMethodBeat.o(103679);
            return false;
        }
        boolean a = aVar.a(path, basePathActionArg);
        AppMethodBeat.o(103679);
        return a;
    }

    public final Path g(JSONArray jSONArray) {
        AppMethodBeat.i(103680);
        Path path = new Path();
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.o(103680);
            return path;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                a(path, optJSONObject);
            }
        }
        AppMethodBeat.o(103680);
        return path;
    }

    private boolean a(Path path, JSONObject jSONObject) {
        AppMethodBeat.i(103681);
        String optString = jSONObject.optString(b.METHOD);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        a aVar = (a) this.hdS.get(optString);
        if (aVar == null) {
            AppMethodBeat.o(103681);
            return false;
        }
        boolean a = aVar.a(path, optJSONArray);
        AppMethodBeat.o(103681);
        return a;
    }

    private void a(a aVar) {
        AppMethodBeat.i(103682);
        this.hdS.put(aVar.getMethod(), aVar);
        AppMethodBeat.o(103682);
    }
}
