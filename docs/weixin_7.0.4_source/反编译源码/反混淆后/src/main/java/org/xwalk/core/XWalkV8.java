package org.xwalk.core;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkV8 {
    static final /* synthetic */ boolean $assertionsDisabled = (!XWalkV8.class.desiredAssertionStatus());
    private ReflectMethod addJavascriptInterfaceObjectStringMethod = new ReflectMethod(null, "addJavascriptInterface", new Class[0]);
    private Object bridge;
    private ReflectMethod cleanupMethod = new ReflectMethod(null, "cleanup", new Class[0]);
    private ArrayList<Object> constructorParams = new ArrayList();
    private ArrayList<Object> constructorTypes = new ArrayList();
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod evaluateJavascriptStringValueCallbackMethod = new ReflectMethod(null, "evaluateJavascript", new Class[0]);
    private ReflectMethod initintMethod = new ReflectMethod(null, "init", new Class[0]);
    private ReflectMethod postWrapperMethod;

    static {
        AppMethodBeat.m2504i(85938);
        AppMethodBeat.m2505o(85938);
    }

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkV8() {
        AppMethodBeat.m2504i(85932);
        reflectionInit();
        AppMethodBeat.m2505o(85932);
    }

    public void init(int i) {
        AppMethodBeat.m2504i(85933);
        try {
            this.initintMethod.invoke(Integer.valueOf(i));
            AppMethodBeat.m2505o(85933);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85933);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85933);
        }
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(85934);
        try {
            this.evaluateJavascriptStringValueCallbackMethod.invoke(str, valueCallback);
            AppMethodBeat.m2505o(85934);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85934);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85934);
        }
    }

    public void cleanup() {
        AppMethodBeat.m2504i(85935);
        try {
            this.cleanupMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85935);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85935);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85935);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.m2504i(85936);
        try {
            this.addJavascriptInterfaceObjectStringMethod.invoke(obj, str);
            AppMethodBeat.m2505o(85936);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85936);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85936);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85937);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85937);
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
                AppMethodBeat.m2505o(85937);
                throw assertionError;
            }
        }
        clsArr[size] = Object.class;
        this.constructorParams.add(this);
        try {
            this.bridge = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkV8Bridge"), clsArr).newInstance(this.constructorParams.toArray());
            if (this.postWrapperMethod != null) {
                this.postWrapperMethod.invoke(new Object[0]);
            }
            this.initintMethod.init(this.bridge, null, "initSuper", Integer.TYPE);
            this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, null, "evaluateJavascriptSuper", String.class, ValueCallback.class);
            this.cleanupMethod.init(this.bridge, null, "cleanupSuper", new Class[0]);
            this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, null, "addJavascriptInterfaceSuper", Object.class, String.class);
            AppMethodBeat.m2505o(85937);
        } catch (UnsupportedOperationException e) {
            AppMethodBeat.m2505o(85937);
        }
    }
}
