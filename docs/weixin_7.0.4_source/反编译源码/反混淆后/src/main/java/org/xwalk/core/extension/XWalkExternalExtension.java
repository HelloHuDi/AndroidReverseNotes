package org.xwalk.core.extension;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class XWalkExternalExtension {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExternalExtension.class.desiredAssertionStatus());
    private Map<Integer, ExtensionInstanceHelper> instanceHelpers;
    protected String[] mEntryPoints;
    protected XWalkExtensionContextClient mExtensionContext;
    protected MessageHandler mHandler;
    protected String mJsApi;
    protected String mName;
    protected ReflectionHelper mReflection;
    protected boolean useJsStubGeneration;

    static {
        AppMethodBeat.m2504i(86189);
        AppMethodBeat.m2505o(86189);
    }

    public XWalkExternalExtension(String str, String str2, XWalkExtensionContextClient xWalkExtensionContextClient) {
        this(str, str2, null, xWalkExtensionContextClient);
    }

    public XWalkExternalExtension(String str, String str2, String[] strArr, XWalkExtensionContextClient xWalkExtensionContextClient) {
        AppMethodBeat.m2504i(86176);
        if ($assertionsDisabled || xWalkExtensionContextClient != null) {
            this.mName = str;
            this.mJsApi = str2;
            this.mEntryPoints = strArr;
            this.mExtensionContext = xWalkExtensionContextClient;
            this.instanceHelpers = new HashMap();
            this.mHandler = new MessageHandler();
            if (this.mJsApi == null || this.mJsApi.length() == 0) {
                this.useJsStubGeneration = true;
                this.mReflection = new ReflectionHelper(getClass());
                this.mJsApi = new JsStubGenerator(this.mReflection).generate();
                if (this.mJsApi == null || this.mJsApi.length() == 0) {
                    Log.m81046e("Extension-" + this.mName, "Can't generate JavaScript stub for this extension.");
                    AppMethodBeat.m2505o(86176);
                    return;
                }
            }
            this.mReflection = null;
            this.useJsStubGeneration = false;
            this.mExtensionContext.registerExtension(this);
            AppMethodBeat.m2505o(86176);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(86176);
        throw assertionError;
    }

    public final String getExtensionName() {
        return this.mName;
    }

    public final String getJsApi() {
        return this.mJsApi;
    }

    public final String[] getEntryPoints() {
        return this.mEntryPoints;
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    public void onNewIntent(Intent intent) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onInstanceCreated(int i) {
        AppMethodBeat.m2504i(86177);
        this.instanceHelpers.put(Integer.valueOf(i), new ExtensionInstanceHelper(this, i));
        AppMethodBeat.m2505o(86177);
    }

    public void onInstanceDestroyed(int i) {
        AppMethodBeat.m2504i(86178);
        this.instanceHelpers.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(86178);
    }

    public boolean isAutoJS() {
        return this.useJsStubGeneration;
    }

    public void onMessage(int i, String str) {
        AppMethodBeat.m2504i(86179);
        if (this.useJsStubGeneration) {
            getInstanceHelper(i).handleMessage(str);
        }
        AppMethodBeat.m2505o(86179);
    }

    public void onBinaryMessage(int i, byte[] bArr) {
        AppMethodBeat.m2504i(86180);
        if (this.useJsStubGeneration) {
            getInstanceHelper(i).handleMessage(bArr);
        }
        AppMethodBeat.m2505o(86180);
    }

    public String onSyncMessage(int i, String str) {
        AppMethodBeat.m2504i(86181);
        Object obj = null;
        if (this.useJsStubGeneration) {
            obj = getInstanceHelper(i).handleMessage(str);
        }
        String objToJSON;
        if (obj != null) {
            objToJSON = ReflectionHelper.objToJSON(obj);
            AppMethodBeat.m2505o(86181);
            return objToJSON;
        }
        objToJSON = "";
        AppMethodBeat.m2505o(86181);
        return objToJSON;
    }

    public ReflectionHelper getReflection() {
        return this.mReflection;
    }

    public MessageHandler getMessageHandler() {
        return this.mHandler;
    }

    public ReflectionHelper getTargetReflect(String str) {
        AppMethodBeat.m2504i(86182);
        ReflectionHelper constructorReflection = this.mReflection.getConstructorReflection(str);
        if (constructorReflection != null) {
            AppMethodBeat.m2505o(86182);
            return constructorReflection;
        }
        constructorReflection = this.mReflection;
        AppMethodBeat.m2505o(86182);
        return constructorReflection;
    }

    /* Access modifiers changed, original: protected */
    public ExtensionInstanceHelper getInstanceHelper(int i) {
        AppMethodBeat.m2504i(86183);
        ExtensionInstanceHelper extensionInstanceHelper = (ExtensionInstanceHelper) this.instanceHelpers.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(86183);
        return extensionInstanceHelper;
    }

    public void sendEvent(String str, Object obj) {
        AppMethodBeat.m2504i(86184);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cmd", "onEvent");
            jSONObject.put("type", str);
            jSONObject.put("event", ReflectionHelper.objToJSON(obj));
            broadcastMessage(jSONObject.toString());
            AppMethodBeat.m2505o(86184);
        } catch (Exception e) {
            AppMethodBeat.m2505o(86184);
        }
    }

    public final void postMessage(int i, String str) {
        AppMethodBeat.m2504i(86185);
        this.mExtensionContext.postMessage(this, i, str);
        AppMethodBeat.m2505o(86185);
    }

    public final void postBinaryMessage(int i, byte[] bArr) {
        AppMethodBeat.m2504i(86186);
        this.mExtensionContext.postBinaryMessage(this, i, bArr);
        AppMethodBeat.m2505o(86186);
    }

    public final void broadcastMessage(String str) {
        AppMethodBeat.m2504i(86187);
        this.mExtensionContext.broadcastMessage(this, str);
        AppMethodBeat.m2505o(86187);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        AppMethodBeat.m2504i(86188);
        ActivityNotFoundException activityNotFoundException = new ActivityNotFoundException("This method is no longer supported");
        AppMethodBeat.m2505o(86188);
        throw activityNotFoundException;
    }
}
