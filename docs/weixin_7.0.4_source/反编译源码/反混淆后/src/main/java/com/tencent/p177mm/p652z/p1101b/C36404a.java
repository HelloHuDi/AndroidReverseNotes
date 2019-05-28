package com.tencent.p177mm.p652z.p1101b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.z.b.a */
public class C36404a extends C40953b<JSONObject, Bundle, JSONObject> implements C30908e {
    public C36404a(String str, int i) {
        super(str, i);
    }

    /* renamed from: a */
    public final JSONObject mo57327a(boolean z, String str, Map<String, ? extends Object> map) {
        AppMethodBeat.m2504i(115299);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        stringBuilder.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            stringBuilder.append(C5046bo.nullAsNil(str));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", stringBuilder.toString());
        if (map != null) {
            hashMap.putAll(map);
        }
        C36404a.m60037d(hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.m2505o(115299);
        return jSONObject;
    }

    /* renamed from: a */
    public final JSONObject mo57326a(boolean z, String str, Bundle bundle) {
        AppMethodBeat.m2504i(115300);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name);
        stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        stringBuilder.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            stringBuilder.append(C5046bo.nullAsNil(str));
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
        C36404a.m60037d(hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.m2505o(115300);
        return jSONObject;
    }

    /* renamed from: d */
    private static void m60037d(Map map) {
        AppMethodBeat.m2504i(115301);
        for (Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                C36404a.m60037d((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.m2505o(115301);
    }
}
