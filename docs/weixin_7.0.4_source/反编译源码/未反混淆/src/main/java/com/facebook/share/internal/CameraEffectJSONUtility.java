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

    public interface Setter {
        void setOnArgumentsBuilder(Builder builder, String str, Object obj);

        void setOnJSON(JSONObject jSONObject, String str, Object obj);
    }

    static {
        AppMethodBeat.i(96952);
        HashMap hashMap = new HashMap();
        SETTERS = hashMap;
        hashMap.put(String.class, new Setter() {
            public final void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
                AppMethodBeat.i(96944);
                builder.putArgument(str, (String) obj);
                AppMethodBeat.o(96944);
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(96945);
                jSONObject.put(str, obj);
                AppMethodBeat.o(96945);
            }
        });
        SETTERS.put(String[].class, new Setter() {
            public final void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
                AppMethodBeat.i(96946);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unexpected type from JSON");
                AppMethodBeat.o(96946);
                throw illegalArgumentException;
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(96947);
                JSONArray jSONArray = new JSONArray();
                for (Object put : (String[]) obj) {
                    jSONArray.put(put);
                }
                jSONObject.put(str, jSONArray);
                AppMethodBeat.o(96947);
            }
        });
        SETTERS.put(JSONArray.class, new Setter() {
            public final void setOnArgumentsBuilder(Builder builder, String str, Object obj) {
                AppMethodBeat.i(96948);
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
                            AppMethodBeat.o(96948);
                            throw illegalArgumentException;
                        }
                    }
                    builder.putArgument(str, strArr);
                    AppMethodBeat.o(96948);
                    return;
                }
            }

            public final void setOnJSON(JSONObject jSONObject, String str, Object obj) {
                AppMethodBeat.i(96949);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("JSONArray's are not supported in bundles.");
                AppMethodBeat.o(96949);
                throw illegalArgumentException;
            }
        });
        AppMethodBeat.o(96952);
    }

    public static JSONObject convertToJSON(CameraEffectArguments cameraEffectArguments) {
        AppMethodBeat.i(96950);
        if (cameraEffectArguments == null) {
            AppMethodBeat.o(96950);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : cameraEffectArguments.keySet()) {
            Object obj = cameraEffectArguments.get(str);
            if (obj != null) {
                Setter setter = (Setter) SETTERS.get(obj.getClass());
                if (setter == null) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported type: " + obj.getClass());
                    AppMethodBeat.o(96950);
                    throw illegalArgumentException;
                }
                setter.setOnJSON(jSONObject, str, obj);
            }
        }
        AppMethodBeat.o(96950);
        return jSONObject;
    }

    public static CameraEffectArguments convertToCameraEffectArguments(JSONObject jSONObject) {
        AppMethodBeat.i(96951);
        if (jSONObject == null) {
            AppMethodBeat.o(96951);
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
                    AppMethodBeat.o(96951);
                    throw illegalArgumentException;
                }
                setter.setOnArgumentsBuilder(builder, str, obj);
            }
        }
        CameraEffectArguments build = builder.build();
        AppMethodBeat.o(96951);
        return build;
    }
}
