package org.xwalk.core;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceRequestHandler implements XWalkWebResourceRequest {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod getMethodMethod = new ReflectMethod(null, "getMethod", new Class[0]);
    private ReflectMethod getRequestHeadersMethod = new ReflectMethod(null, "getRequestHeaders", new Class[0]);
    private ReflectMethod getUrlMethod = new ReflectMethod(null, "getUrl", new Class[0]);
    private ReflectMethod hasGestureMethod = new ReflectMethod(null, "hasGesture", new Class[0]);
    private ReflectMethod isForMainFrameMethod = new ReflectMethod(null, "isForMainFrame", new Class[0]);
    private ReflectMethod postWrapperMethod;

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkWebResourceRequestHandler(Object obj) {
        AppMethodBeat.m2504i(86049);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.m2505o(86049);
    }

    public Uri getUrl() {
        AppMethodBeat.m2504i(86050);
        try {
            Uri uri = (Uri) this.getUrlMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86050);
            return uri;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86050);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86050);
            return null;
        }
    }

    public boolean isForMainFrame() {
        AppMethodBeat.m2504i(86051);
        try {
            boolean booleanValue = ((Boolean) this.isForMainFrameMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(86051);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86051);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86051);
            return false;
        }
    }

    public boolean hasGesture() {
        AppMethodBeat.m2504i(86052);
        try {
            boolean booleanValue = ((Boolean) this.hasGestureMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(86052);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86052);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86052);
            return false;
        }
    }

    public String getMethod() {
        AppMethodBeat.m2504i(86053);
        try {
            String str = (String) this.getMethodMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86053);
            return str;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86053);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86053);
            return null;
        }
    }

    public Map<String, String> getRequestHeaders() {
        AppMethodBeat.m2504i(86054);
        try {
            Map map = (Map) this.getRequestHeadersMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86054);
            return map;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86054);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86054);
            return null;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(86055);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(86055);
            return;
        }
        this.getUrlMethod.init(this.bridge, null, "getUrlSuper", new Class[0]);
        this.isForMainFrameMethod.init(this.bridge, null, "isForMainFrameSuper", new Class[0]);
        this.hasGestureMethod.init(this.bridge, null, "hasGestureSuper", new Class[0]);
        this.getMethodMethod.init(this.bridge, null, "getMethodSuper", new Class[0]);
        this.getRequestHeadersMethod.init(this.bridge, null, "getRequestHeadersSuper", new Class[0]);
        AppMethodBeat.m2505o(86055);
    }
}
