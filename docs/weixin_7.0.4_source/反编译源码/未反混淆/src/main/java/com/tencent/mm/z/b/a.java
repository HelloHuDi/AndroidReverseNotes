package com.tencent.mm.z.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class a extends b<JSONObject, Bundle, JSONObject> implements e {
    public a(String str, int i) {
        super(str, i);
    }

    public final JSONObject a(boolean z, String str, Map<String, ? extends Object> map) {
        AppMethodBeat.i(115299);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        stringBuilder.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            stringBuilder.append(bo.nullAsNil(str));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", stringBuilder.toString());
        if (map != null) {
            hashMap.putAll(map);
        }
        d(hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.o(115299);
        return jSONObject;
    }

    public final JSONObject a(boolean z, String str, Bundle bundle) {
        AppMethodBeat.i(115300);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        stringBuilder.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            stringBuilder.append(bo.nullAsNil(str));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", stringBuilder.toString());
        if (bundle != null) {
            Set<String> keySet = bundle.keySet();
            if (!(keySet == null || keySet.isEmpty())) {
                for (String str2 : keySet) {
                    hashMap.put(str2, bundle.get(str2));
                }
            }
        }
        d(hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.o(115300);
        return jSONObject;
    }

    private static void d(Map map) {
        AppMethodBeat.i(115301);
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                d((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.o(115301);
    }
}
