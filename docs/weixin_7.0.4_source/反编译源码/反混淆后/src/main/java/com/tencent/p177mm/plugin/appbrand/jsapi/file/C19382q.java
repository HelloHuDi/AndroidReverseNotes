package com.tencent.p177mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19092p.C19093a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.file.q */
public final class C19382q extends C10296a {
    private static final int CTRL_INDEX = 115;
    private static final String NAME = "getSavedFileList";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(102789);
        List<C19093a> awQ = c2241c.asE().awQ();
        JSONArray jSONArray = new JSONArray();
        if (awQ != null && awQ.size() > 0) {
            for (C19093a c19093a : awQ) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("filePath", c19093a.getFileName());
                    jSONObject2.put("size", c19093a.awL());
                    jSONObject2.put("createTime", TimeUnit.MILLISECONDS.toSeconds(c19093a.lastModified()));
                    jSONArray.put(jSONObject2);
                } catch (Exception e) {
                }
            }
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("fileList", jSONArray);
        c2241c.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(102789);
    }
}
