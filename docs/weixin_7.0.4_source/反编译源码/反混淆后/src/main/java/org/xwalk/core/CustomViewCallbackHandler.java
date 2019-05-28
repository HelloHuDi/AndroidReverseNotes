package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class CustomViewCallbackHandler implements CustomViewCallback {
    private Object bridge;
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod onCustomViewHiddenMethod = new ReflectMethod(null, "onCustomViewHidden", new Class[0]);
    private ReflectMethod postWrapperMethod;

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public CustomViewCallbackHandler(Object obj) {
        AppMethodBeat.m2504i(85509);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.m2505o(85509);
    }

    public void onCustomViewHidden() {
        AppMethodBeat.m2504i(85510);
        try {
            this.onCustomViewHiddenMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85510);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85510);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85510);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85511);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85511);
            return;
        }
        this.onCustomViewHiddenMethod.init(this.bridge, null, "onCustomViewHiddenSuper", new Class[0]);
        AppMethodBeat.m2505o(85511);
    }
}
