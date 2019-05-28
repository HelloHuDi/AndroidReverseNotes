package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C10730b;
import com.tencent.p177mm.plugin.appbrand.p329s.C27295q.C27296a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m */
public abstract class C45608m extends C10332b {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m$a */
    public static class C38338a {
        public final String aIm;
        public final Map<String, Object> values = new HashMap();

        public C38338a(String str, Object... objArr) {
            AppMethodBeat.m2504i(91033);
            if (objArr == null || objArr.length <= 0) {
                this.aIm = str;
                AppMethodBeat.m2505o(91033);
                return;
            }
            this.aIm = String.format(str, objArr);
            AppMethodBeat.m2505o(91033);
        }

        /* renamed from: m */
        public C38338a mo21866m(String str, Object obj) {
            AppMethodBeat.m2504i(91034);
            this.values.put(str, obj);
            AppMethodBeat.m2505o(91034);
            return this;
        }

        /* renamed from: v */
        public C38338a mo21868v(Map<String, Object> map) {
            AppMethodBeat.m2504i(91035);
            if (map != null) {
                this.values.putAll(map);
            }
            AppMethodBeat.m2505o(91035);
            return this;
        }
    }

    /* renamed from: AK */
    public final String mo73392AK(String str) {
        return mo73394j(str, null);
    }

    /* renamed from: j */
    public final String mo73394j(String str, Map<String, ? extends Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", getName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
        if (map != null) {
            if (C4872b.dnO() && map.containsKey("errMsg")) {
                Assert.assertTrue("api " + getName() + ": Cant put errMsg in res!!!", false);
            }
            hashMap.putAll(map);
        }
        C32192i.m52509d(hashMap);
        return new JSONObject(hashMap).toString();
    }

    /* renamed from: a */
    public final String mo73393a(C2241c c2241c, String str, Map<String, ? extends Object> map) {
        return C27295q.m43333a(c2241c.aBx(), (Map) map, (C27296a) c2241c.mo5937aa(C27296a.class)) == C10730b.FAIL_SIZE_EXCEED_LIMIT ? mo73394j("fail:convert native buffer parameter fail. native buffer exceed size limit.", null) : mo73394j(str, map);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: g */
    public void mo31168g(C2241c c2241c) {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: h */
    public void mo31169h(C2241c c2241c) {
    }
}
