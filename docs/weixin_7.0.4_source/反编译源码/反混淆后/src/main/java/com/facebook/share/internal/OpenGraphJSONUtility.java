package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class OpenGraphJSONUtility {

    public interface PhotoJSONProcessor {
        JSONObject toJSONObject(SharePhoto sharePhoto);
    }

    public static JSONObject toJSONObject(ShareOpenGraphAction shareOpenGraphAction, PhotoJSONProcessor photoJSONProcessor) {
        AppMethodBeat.m2504i(97162);
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphAction.keySet()) {
            jSONObject.put(str, toJSONValue(shareOpenGraphAction.get(str), photoJSONProcessor));
        }
        AppMethodBeat.m2505o(97162);
        return jSONObject;
    }

    private static JSONObject toJSONObject(ShareOpenGraphObject shareOpenGraphObject, PhotoJSONProcessor photoJSONProcessor) {
        AppMethodBeat.m2504i(97163);
        JSONObject jSONObject = new JSONObject();
        for (String str : shareOpenGraphObject.keySet()) {
            jSONObject.put(str, toJSONValue(shareOpenGraphObject.get(str), photoJSONProcessor));
        }
        AppMethodBeat.m2505o(97163);
        return jSONObject;
    }

    private static JSONArray toJSONArray(List list, PhotoJSONProcessor photoJSONProcessor) {
        AppMethodBeat.m2504i(97164);
        JSONArray jSONArray = new JSONArray();
        for (Object toJSONValue : list) {
            jSONArray.put(toJSONValue(toJSONValue, photoJSONProcessor));
        }
        AppMethodBeat.m2505o(97164);
        return jSONArray;
    }

    public static Object toJSONValue(Object obj, PhotoJSONProcessor photoJSONProcessor) {
        AppMethodBeat.m2504i(97165);
        if (obj == null) {
            obj = JSONObject.NULL;
            AppMethodBeat.m2505o(97165);
            return obj;
        } else if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            AppMethodBeat.m2505o(97165);
            return obj;
        } else if (obj instanceof SharePhoto) {
            if (photoJSONProcessor != null) {
                obj = photoJSONProcessor.toJSONObject((SharePhoto) obj);
                AppMethodBeat.m2505o(97165);
                return obj;
            }
            AppMethodBeat.m2505o(97165);
            return null;
        } else if (obj instanceof ShareOpenGraphObject) {
            obj = toJSONObject((ShareOpenGraphObject) obj, photoJSONProcessor);
            AppMethodBeat.m2505o(97165);
            return obj;
        } else if (obj instanceof List) {
            obj = toJSONArray((List) obj, photoJSONProcessor);
            AppMethodBeat.m2505o(97165);
            return obj;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid object found for JSON serialization: " + obj.toString());
            AppMethodBeat.m2505o(97165);
            throw illegalArgumentException;
        }
    }

    private OpenGraphJSONUtility() {
    }
}
