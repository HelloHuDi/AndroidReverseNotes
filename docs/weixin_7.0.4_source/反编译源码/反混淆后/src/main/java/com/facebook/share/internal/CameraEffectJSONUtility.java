package com.facebook.share.internal;

import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectArguments.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CameraEffectJSONUtility {
    private static final Map<Class<?>, Setter> SETTERS;

    /* renamed from: com.facebook.share.internal.CameraEffectJSONUtility$1 */
    static class C254951 implements Setter {
        C254951() {
        }

        public final void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
            AppMethodBeat.m2504i(96944);
            builder.putArgument(str, (String) obj);
            AppMethodBeat.m2505o(96944);
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(96945);
            jSONObject.put(str, obj);
            AppMethodBeat.m2505o(96945);
        }
    }

    /* renamed from: com.facebook.share.internal.CameraEffectJSONUtility$2 */
    static class C254962 implements Setter {
        C254962() {
        }

        public final void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
            AppMethodBeat.m2504i(96946);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type from JSON");
            AppMethodBeat.m2505o(96946);
            throw illegalArgumentException;
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(96947);
            JSONArray jSONArray = new JSONArray();
            for (Object put : (String[]) obj) {
                jSONArray.put(put);
            }
            jSONObject.put(str, jSONArray);
            AppMethodBeat.m2505o(96947);
        }
    }

    public interface Setter {
        void setOnArgumentsBuilder(Builder builder, String str, Object obj);

        void setOnJSON(JSONObject jSONObject, String str, Object obj);
    }

    /* renamed from: com.facebook.share.internal.CameraEffectJSONUtility$3 */
    static class C320103 implements Setter {
        C320103() {
        }

        public final void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
            AppMethodBeat.m2504i(96948);
            JSONArray jSONArray = (JSONArray) obj;
            String[] strArr = new String[jSONArray.length()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < jSONArray.length()) {
                    Object obj2 = jSONArray.get(i2);
                    if (obj2 instanceof String) {
                        strArr[i2] = (String) obj2;
                        i = i2 + 1;
                    } else {
                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type in an array: " + obj2.getClass());
                        AppMethodBeat.m2505o(96948);
                        throw illegalArgumentException;
                    }
                }
                builder.putArgument(str, strArr);
                AppMethodBeat.m2505o(96948);
                return;
            }
        }

        public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
            AppMethodBeat.m2504i(96949);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("JSONArray's are not supported in bundles.");
            AppMethodBeat.m2505o(96949);
            throw illegalArgumentException;
        }
    }

    static {
        AppMethodBeat.m2504i(96952);
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(String.class, new C254951());
        SETTERS.put(String[].class, new C254962());
        SETTERS.put(JSONArray.class, new C320103());
        AppMethodBeat.m2505o(96952);
    }

    public static JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) {
        AppMethodBeat.m2504i(96950);
        if (cameraEffectArguments == null) {
            AppMethodBeat.m2505o(96950);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(str);
            if (obj != null) {
                Setter setter = (Setter) SETTERS.get(obj.getClass());
                if (setter == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    AppMethodBeat.m2505o(96950);
                    throw illegalArgumentException;
                }
                setter.setOnJSON(jSONObject, str, obj);
            }
        }
        AppMethodBeat.m2505o(96950);
        return jSONObject;
    }

    public static CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) {
        AppMethodBeat.m2504i(96951);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(96951);
            return null;
        }
        Builder builder = new Builder();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object obj = jSONObject.get(str);
            if (!(obj == null || obj == JSONObject.NULL)) {
                Setter setter = (Setter) SETTERS.get(obj.getClass());
                if (setter == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    AppMethodBeat.m2505o(96951);
                    throw illegalArgumentException;
                }
                setter.setOnArgumentsBuilder(builder, str, obj);
            }
        }
        CameraEffectArguments build = builder.build();
        AppMethodBeat.m2505o(96951);
        return build;
    }
}
