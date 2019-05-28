package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class JsContextInfo {
    private int extInstanceId;
    private XWalkExternalExtension extensionClient;
    private String objectId;
    private Class<?> targetClass;

    JsContextInfo(int i, XWalkExternalExtension xWalkExternalExtension, Class<?> cls, String str) {
        this.extensionClient = xWalkExternalExtension;
        this.extInstanceId = i;
        this.objectId = str;
        this.targetClass = cls;
    }

    public String getTag() {
        AppMethodBeat.i(86107);
        String str = "Extension-" + this.extensionClient.getExtensionName();
        AppMethodBeat.o(86107);
        return str;
    }

    public ReflectionHelper getTargetReflect() {
        AppMethodBeat.i(86108);
        ReflectionHelper targetReflect = this.extensionClient.getTargetReflect(this.targetClass.getSimpleName());
        AppMethodBeat.o(86108);
        return targetReflect;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public XWalkExternalExtension getExtensionClient() {
        return this.extensionClient;
    }

    public String getConstructorName() {
        AppMethodBeat.i(86109);
        String simpleName = this.targetClass.getSimpleName();
        AppMethodBeat.o(86109);
        return simpleName;
    }

    public void postMessage(JSONObject jSONObject) {
        AppMethodBeat.i(86110);
        this.extensionClient.postMessage(this.extInstanceId, jSONObject.toString());
        AppMethodBeat.o(86110);
    }

    public void postMessage(byte[] bArr) {
        AppMethodBeat.i(86111);
        this.extensionClient.postBinaryMessage(this.extInstanceId, bArr);
        AppMethodBeat.o(86111);
    }
}
