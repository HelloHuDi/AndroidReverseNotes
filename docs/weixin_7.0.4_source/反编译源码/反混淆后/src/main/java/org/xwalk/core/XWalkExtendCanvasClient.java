package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkExtendCanvasClient {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkExtendCanvasClient.class.desiredAssertionStatus());
    private static final String TAG = "XWalkExtendCanvasClient";
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod postWrapperMethod;
    private ReflectMethod sendAsyncMethodsMethod = new ReflectMethod(null, "sendAsyncMethods", new Class[0]);

    static {
        AppMethodBeat.m2504i(85629);
        AppMethodBeat.m2505o(85629);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkExtendCanvasClient(XWalkView xWalkView) {
        AppMethodBeat.m2504i(85625);
        this.constructorTypes.add("XWalkViewBridge");
        this.constructorParams = new ArrayList();
        this.constructorParams.add(xWalkView);
        reflectionInit();
        AppMethodBeat.m2505o(85625);
    }

    public void onCanvasTouch(String str, int i, String str2) {
    }

    public void onAsycResultCallback(int i, int i2, String str) {
    }

    public void onSendJsonMessage(String str) {
    }

    public void sendAsyncMethods(String str) {
        AppMethodBeat.m2504i(85626);
        sendAsyncMethods(str, 0);
        AppMethodBeat.m2505o(85626);
    }

    public void sendAsyncMethods(String str, int i) {
        AppMethodBeat.m2504i(85627);
        Log.m81045d(TAG, "sendAsyncMethods called! methods:" + str + ",reply_id:" + i);
        try {
            this.sendAsyncMethodsMethod.invoke(str, Integer.valueOf(i));
            AppMethodBeat.m2505o(85627);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85627);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85627);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85628);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85628);
            return;
        }
        int size = this.constructorTypes.size();
        Class[] clsArr = new Class[(size + 1)];
        for (int i = 0; i < size; i++) {
            Object obj = this.constructorTypes.get(i);
            if (obj instanceof String) {
                clsArr[i] = this.coreWrapper.getBridgeClass((String) obj);
                this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
            } else if (obj instanceof Class) {
                clsArr[i] = (Class) obj;
            } else if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(85628);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtendCanvasClientBridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.sendAsyncMethodsMethod.init(this.bridge, null, "sendAsyncMethods", String.class, Integer.TYPE);
            AppMethodBeat.m2505o(85628);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.m2505o(85628);
        }
    }
}
