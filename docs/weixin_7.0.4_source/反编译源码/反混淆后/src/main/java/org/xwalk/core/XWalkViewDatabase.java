package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkViewDatabase {
    private static ReflectMethod clearFormDataMethod = new ReflectMethod(null, "clearFormData", new Class[0]);
    private static XWalkCoreWrapper coreWrapper;
    private static ReflectMethod hasFormDataMethod = new ReflectMethod(null, "hasFormData", new Class[0]);

    public static boolean hasFormData() {
        AppMethodBeat.m2504i(86045);
        reflectionInit();
        try {
            boolean booleanValue = ((Boolean) hasFormDataMethod.invoke(new Object[0])).booleanValue();
            AppMethodBeat.m2505o(86045);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.m2505o(86045);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86045);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(86048);
        AppMethodBeat.m2505o(86048);
    }

    public static void clearFormData() {
        AppMethodBeat.m2504i(86046);
        reflectionInit();
        try {
            clearFormDataMethod.invoke(new Object[0]);
            AppMethodBeat.m2505o(86046);
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                clearFormDataMethod.setArguments(new Object[0]);
                XWalkCoreWrapper.reserveReflectMethod(clearFormDataMethod);
                AppMethodBeat.m2505o(86046);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.m2505o(86046);
        }
    }

    static void reflectionInit() {
        AppMethodBeat.m2504i(86047);
        if (coreWrapper != null) {
            AppMethodBeat.m2505o(86047);
            return;
        }
        XWalkCoreWrapper.initEmbeddedMode();
        XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
        coreWrapper = instance;
        if (instance == null) {
            XWalkCoreWrapper.reserveReflectClass(XWalkViewDatabase.class);
            AppMethodBeat.m2505o(86047);
            return;
        }
        Class bridgeClass = coreWrapper.getBridgeClass("XWalkViewDatabaseBridge");
        hasFormDataMethod.init(null, bridgeClass, "hasFormData", new Class[0]);
        clearFormDataMethod.init(null, bridgeClass, "clearFormData", new Class[0]);
        AppMethodBeat.m2505o(86047);
    }
}
