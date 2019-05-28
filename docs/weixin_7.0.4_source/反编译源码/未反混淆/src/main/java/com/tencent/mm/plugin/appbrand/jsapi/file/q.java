package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class q extends a {
    private static final int CTRL_INDEX = 115;
    private static final String NAME = "getSavedFileList";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(102789);
        List<p.a> awQ = cVar.asE().awQ();
        JSONArray jSONArray = new JSONArray();
        if (awQ != null && awQ.size() > 0) {
            for (p.a aVar : awQ) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("filePath", aVar.getFileName());
                    jSONObject2.put("size", aVar.awL());
                    jSONObject2.put("createTime", TimeUnit.MILLISECONDS.toSeconds(aVar.lastModified()));
                    jSONArray.put(jSONObject2);
                } catch (Exception e) {
                }
            }
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("fileList", jSONArray);
        cVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(102789);
    }
}
