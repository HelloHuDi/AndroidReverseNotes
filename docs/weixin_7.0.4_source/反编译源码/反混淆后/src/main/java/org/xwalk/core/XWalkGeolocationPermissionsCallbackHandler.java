package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkGeolocationPermissionsCallbackHandler implements XWalkGeolocationPermissionsCallback {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod invokeStringbooleanbooleanMethod = new ReflectMethod(null, "invoke", new Class[0]);
    private ReflectMethod postWrapperMethod;

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkGeolocationPermissionsCallbackHandler(Object obj) {
        AppMethodBeat.m2504i(85639);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.m2505o(85639);
    }

    public void invoke(String str, boolean z, boolean z2) {
        AppMethodBeat.m2504i(85640);
        try {
            this.invokeStringbooleanbooleanMethod.invoke(str, Boolean.valueOf(z), Boolean.valueOf(z2));
            AppMethodBeat.m2505o(85640);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85640);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85640);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85641);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85641);
            return;
        }
        this.invokeStringbooleanbooleanMethod.init(this.bridge, null, "invokeSuper", String.class, Boolean.TYPE, Boolean.TYPE);
        AppMethodBeat.m2505o(85641);
    }
}
