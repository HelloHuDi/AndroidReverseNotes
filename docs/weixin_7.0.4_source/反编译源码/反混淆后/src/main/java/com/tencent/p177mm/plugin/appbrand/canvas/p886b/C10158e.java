package com.tencent.p177mm.plugin.appbrand.canvas.p886b;

import android.graphics.Path;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.BasePathActionArg;
import com.tencent.p177mm.plugin.appbrand.canvas.action.arg.path.PathActionArgWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.e */
public final class C10158e {
    public Map<String, C42399a> hdS = new HashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.canvas.b.e$a */
    public static class C10159a {
        public static C10158e hdT = new C10158e();

        static {
            AppMethodBeat.m2504i(103676);
            AppMethodBeat.m2505o(103676);
        }
    }

    public C10158e() {
        AppMethodBeat.m2504i(103677);
        m17771a(new C10161h());
        m17771a(new C26820f());
        m17771a(new C10160g());
        m17771a(new C26821i());
        m17771a(new C45533d());
        m17771a(new C45532b());
        m17771a(new C38153c());
        m17771a(new C38154j());
        AppMethodBeat.m2505o(103677);
    }

    /* renamed from: a */
    public final Path mo21525a(PathActionArgWrapper pathActionArgWrapper) {
        AppMethodBeat.m2504i(103678);
        Path path = new Path();
        List<BasePathActionArg> list = pathActionArgWrapper.hdv;
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(103678);
            return path;
        }
        for (BasePathActionArg basePathActionArg : list) {
            if (basePathActionArg != null) {
                m17773b(path, basePathActionArg);
            }
        }
        AppMethodBeat.m2505o(103678);
        return path;
    }

    /* renamed from: b */
    private boolean m17773b(Path path, BasePathActionArg basePathActionArg) {
        AppMethodBeat.m2504i(103679);
        C42399a c42399a = (C42399a) this.hdS.get(basePathActionArg.method);
        if (c42399a == null) {
            AppMethodBeat.m2505o(103679);
            return false;
        }
        boolean a = c42399a.mo21527a(path, basePathActionArg);
        AppMethodBeat.m2505o(103679);
        return a;
    }

    /* renamed from: g */
    public final Path mo21526g(JSONArray jSONArray) {
        AppMethodBeat.m2504i(103680);
        Path path = new Path();
        if (jSONArray == null || jSONArray.length() == 0) {
            AppMethodBeat.m2505o(103680);
            return path;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                m17772a(path, optJSONObject);
            }
        }
        AppMethodBeat.m2505o(103680);
        return path;
    }

    /* renamed from: a */
    private boolean m17772a(Path path, JSONObject jSONObject) {
        AppMethodBeat.m2504i(103681);
        String optString = jSONObject.optString(C8741b.METHOD);
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        C42399a c42399a = (C42399a) this.hdS.get(optString);
        if (c42399a == null) {
            AppMethodBeat.m2505o(103681);
            return false;
        }
        boolean a = c42399a.mo21528a(path, optJSONArray);
        AppMethodBeat.m2505o(103681);
        return a;
    }

    /* renamed from: a */
    private void m17771a(C42399a c42399a) {
        AppMethodBeat.m2504i(103682);
        this.hdS.put(c42399a.getMethod(), c42399a);
        AppMethodBeat.m2505o(103682);
    }
}
