package org.xwalk.core.extension;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class BindingObjectAutoJS extends BindingObject {
    public Object handleMessage(MessageInfo messageInfo) {
        AppMethodBeat.i(86071);
        Object obj = null;
        try {
            obj = this.mInstanceHelper.getExtension().getReflection().getReflectionByBindingClass(getClass().getName()).handleMessage(messageInfo, this);
        } catch (Exception e) {
            Log.e("BindingObjectAutoJs", e.toString());
        }
        AppMethodBeat.o(86071);
        return obj;
    }

    public JsContextInfo getJsContextInfo() {
        AppMethodBeat.i(86072);
        JsContextInfo jsContextInfo = new JsContextInfo(this.mInstanceHelper.getId(), this.mInstanceHelper.getExtension(), getClass(), this.mObjectId);
        AppMethodBeat.o(86072);
        return jsContextInfo;
    }

    public static void invokeJsCallback(JsContextInfo jsContextInfo, String str, Object... objArr) {
        Object obj;
        AppMethodBeat.i(86073);
        Object[] objArr2 = objArr;
        if (objArr2.length == 1 && (objArr2[0] instanceof JSONArray)) {
            obj = (JSONArray) objArr2[0];
        } else {
            JSONArray obj2 = (JSONArray) ReflectionHelper.toSerializableObject(objArr);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "invokeCallback");
            jSONObject.put("callbackId", str);
            jSONObject.put("args", obj2);
            jsContextInfo.postMessage(jSONObject);
            AppMethodBeat.o(86073);
        } catch (Exception e) {
            AppMethodBeat.o(86073);
        }
    }

    public void invokeJsCallback(String str, Object... objArr) {
        AppMethodBeat.i(86074);
        invokeJsCallback(getJsContextInfo(), str, objArr);
        AppMethodBeat.o(86074);
    }

    public static void invokeJsCallback(JsContextInfo jsContextInfo, byte[] bArr) {
        AppMethodBeat.i(86075);
        jsContextInfo.postMessage(bArr);
        AppMethodBeat.o(86075);
    }

    public void invokeJsCallback(byte[] bArr) {
        AppMethodBeat.i(86076);
        getJsContextInfo().postMessage(bArr);
        AppMethodBeat.o(86076);
    }

    public static void dispatchEvent(JsContextInfo jsContextInfo, String str, Object obj) {
        AppMethodBeat.i(86077);
        if (jsContextInfo.getTargetReflect().isEventSupported(str)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cmd", "dispatchEvent");
                jSONObject.put("constructorName", jsContextInfo.getConstructorName());
                jSONObject.put("objectId", jsContextInfo.getObjectId());
                jSONObject.put("type", str);
                jSONObject.put("event", ReflectionHelper.toSerializableObject(obj));
                jsContextInfo.postMessage(jSONObject);
                AppMethodBeat.o(86077);
                return;
            } catch (Exception e) {
                AppMethodBeat.o(86077);
                return;
            }
        }
        Log.w(jsContextInfo.getTag(), "Unsupport event in extension: ".concat(String.valueOf(str)));
        AppMethodBeat.o(86077);
    }

    public void dispatchEvent(String str, Object obj) {
        AppMethodBeat.i(86078);
        dispatchEvent(getJsContextInfo(), str, obj);
        AppMethodBeat.o(86078);
    }

    public static void sendEvent(JsContextInfo jsContextInfo, String str, Object obj) {
        AppMethodBeat.i(86079);
        jsContextInfo.getExtensionClient().sendEvent(str, obj);
        AppMethodBeat.o(86079);
    }

    public void sendEvent(String str, Object obj) {
        AppMethodBeat.i(86080);
        sendEvent(getJsContextInfo(), str, obj);
        AppMethodBeat.o(86080);
    }

    public static void updateProperty(JsContextInfo jsContextInfo, String str) {
        AppMethodBeat.i(86081);
        ReflectionHelper targetReflect = jsContextInfo.getTargetReflect();
        if (targetReflect.hasProperty(str).booleanValue()) {
            boolean z = targetReflect.getMemberInfo(str).isStatic;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cmd", "updateProperty");
                jSONObject.put("objectId", z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : jsContextInfo.getObjectId());
                jSONObject.put("constructorName", jsContextInfo.getConstructorName());
                jSONObject.put("name", str);
                jsContextInfo.postMessage(jSONObject);
                AppMethodBeat.o(86081);
                return;
            } catch (Exception e) {
                AppMethodBeat.o(86081);
                return;
            }
        }
        Log.w(jsContextInfo.getTag(), "Unexposed property in extension: ".concat(String.valueOf(str)));
        AppMethodBeat.o(86081);
    }

    public void updateProperty(String str) {
        AppMethodBeat.i(86082);
        updateProperty(getJsContextInfo(), str);
        AppMethodBeat.o(86082);
    }
}
