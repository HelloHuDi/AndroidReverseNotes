package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class XWalkHttpAuthHandler implements XWalkHttpAuth {
    private Object bridge;
    private ReflectMethod cancelMethod = new ReflectMethod(null, "cancel", new Class[0]);
    private ArrayList<Object> constructorParams;
    private ArrayList<Object> constructorTypes;
    private XWalkCoreWrapper coreWrapper;
    private ReflectMethod isFirstAttemptMethod = new ReflectMethod(null, "isFirstAttempt", new Class[0]);
    private ReflectMethod postWrapperMethod;
    private ReflectMethod proceedStringStringMethod = new ReflectMethod(null, "proceed", new Class[0]);

    /* Access modifiers changed, original: protected */
    public Object getBridge() {
        return this.bridge;
    }

    public XWalkHttpAuthHandler(Object obj) {
        AppMethodBeat.m2504i(85650);
        this.bridge = obj;
        reflectionInit();
        AppMethodBeat.m2505o(85650);
    }

    public void proceed(String str, String str2) {
        AppMethodBeat.m2504i(85651);
        try {
            this.proceedStringStringMethod.invoke(str, str2);
            AppMethodBeat.m2505o(85651);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85651);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85651);
        }
    }

    public void cancel() {
        AppMethodBeat.m2504i(85652);
        try {
            this.cancelMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(85652);
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85652);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85652);
        }
    }

    public boolean isFirstAttempt() {
        AppMethodBeat.m2504i(85653);
        try {
            boolean booleanValue = ((Boolean) this.isFirstAttemptMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(85653);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (this.coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(85653);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(85653);
            return false;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void reflectionInit() {
        AppMethodBeat.m2504i(85654);
        XWalkCoreWrapper.initEmbeddedMode();
        this.coreWrapper = XWalkCoreWrapper.getInstance();
        if (this.coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectObject(this);
            AppMethodBeat.m2505o(85654);
            return;
        }
        this.proceedStringStringMethod.init(this.bridge, null, "proceedSuper", String.class, String.class);
        this.cancelMethod.init(this.bridge, null, "cancelSuper", new Class[0]);
        this.isFirstAttemptMethod.init(this.bridge, null, "isFirstAttemptSuper", new Class[0]);
        AppMethodBeat.m2505o(85654);
    }
}
