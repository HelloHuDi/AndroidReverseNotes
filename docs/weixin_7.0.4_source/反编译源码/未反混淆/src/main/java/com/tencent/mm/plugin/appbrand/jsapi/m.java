package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.q;
import com.tencent.mm.sdk.a.b;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class m extends b {

    public static class a {
        public final String aIm;
        public final Map<String, Object> values = new HashMap();

        public a(String str, Object... objArr) {
            AppMethodBeat.i(91033);
            if (objArr == null || objArr.length <= 0) {
                this.aIm = str;
                AppMethodBeat.o(91033);
                return;
            }
            this.aIm = String.format(str, objArr);
            AppMethodBeat.o(91033);
        }

        public a m(String str, Object obj) {
            AppMethodBeat.i(91034);
            this.values.put(str, obj);
            AppMethodBeat.o(91034);
            return this;
        }

        public a v(Map<String, Object> map) {
            AppMethodBeat.i(91035);
            if (map != null) {
                this.values.putAll(map);
            }
            AppMethodBeat.o(91035);
            return this;
        }
    }

    public final String AK(String str) {
        return j(str, null);
    }

    public final String j(String str, Map<String, ? extends Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", getName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
        if (map != null) {
            if (b.dnO() && map.containsKey("errMsg")) {
                Assert.assertTrue("api " + getName() + ": Cant put errMsg in res!!!", false);
            }
            hashMap.putAll(map);
        }
        i.d(hashMap);
        return new JSONObject(hashMap).toString();
    }

    public final String a(c cVar, String str, Map<String, ? extends Object> map) {
        return q.a(cVar.aBx(), (Map) map, (com.tencent.mm.plugin.appbrand.s.q.a) cVar.aa(com.tencent.mm.plugin.appbrand.s.q.a.class)) == q.b.FAIL_SIZE_EXCEED_LIMIT ? j("fail:convert native buffer parameter fail. native buffer exceed size limit.", null) : j(str, map);
    }

    /* Access modifiers changed, original: protected */
    public void g(c cVar) {
    }

    /* Access modifiers changed, original: protected */
    public void h(c cVar) {
    }
}
