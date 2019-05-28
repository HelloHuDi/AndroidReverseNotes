package org.xwalk.core;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkPreferences {
    public static final String ALLOW_UNIVERSAL_ACCESS_FROM_FILE = "allow-universal-access-from-file";
    public static final String ANIMATABLE_XWALK_VIEW = "animatable-xwalk-view";
    public static final String ENABLE_EXTENSIONS = "enable-extensions";
    public static final String ENABLE_JAVASCRIPT = "enable-javascript";
    public static final String ENABLE_THEME_COLOR = "enable-theme-color";
    public static final String JAVASCRIPT_CAN_OPEN_WINDOW = "javascript-can-open-window";
    public static final String PROFILE_NAME = "profile-name";
    public static final String REMOTE_DEBUGGING = "remote-debugging";
    public static final String SPATIAL_NAVIGATION = "enable-spatial-navigation";
    public static final String SUPPORT_MULTIPLE_WINDOWS = "support-multiple-windows";
    public static final String XWEBSDK_VERSION = "xwebsdk-version";
    public static final String XWEB_VERSION = "xweb-version";
    private static XWalkCoreWrapper coreWrapper;
    private static ReflectMethod getBooleanValueStringMethod = new ReflectMethod(null, "getBooleanValue", new Class[0]);
    private static ReflectMethod getIntegerValueStringMethod = new ReflectMethod(null, "getIntegerValue", new Class[0]);
    private static ReflectMethod getStringValueStringMethod = new ReflectMethod(null, "getStringValue", new Class[0]);
    private static ReflectMethod getValueStringMethod = new ReflectMethod(null, "getValue", new Class[0]);
    private static ReflectMethod setValueStringStringMethod = new ReflectMethod(null, "setValue", new Class[0]);
    private static ReflectMethod setValueStringbooleanMethod = new ReflectMethod(null, "setValue", new Class[0]);
    private static ReflectMethod setValueStringintMethod = new ReflectMethod(null, "setValue", new Class[0]);

    public static void setValue(String str, boolean z) {
        AppMethodBeat.i(85734);
        reflectionInit();
        try {
            setValueStringbooleanMethod.invoke(str, Boolean.valueOf(z));
            AppMethodBeat.o(85734);
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                setValueStringbooleanMethod.setArguments(str, Boolean.valueOf(z));
                XWalkCoreWrapper.reserveReflectMethod(setValueStringbooleanMethod);
                AppMethodBeat.o(85734);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85734);
        }
    }

    static {
        AppMethodBeat.i(85742);
        AppMethodBeat.o(85742);
    }

    public static void setValue(String str, int i) {
        AppMethodBeat.i(85735);
        reflectionInit();
        try {
            setValueStringintMethod.invoke(str, Integer.valueOf(i));
            AppMethodBeat.o(85735);
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                setValueStringintMethod.setArguments(str, Integer.valueOf(i));
                XWalkCoreWrapper.reserveReflectMethod(setValueStringintMethod);
                AppMethodBeat.o(85735);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85735);
        }
    }

    public static void setValue(String str, String str2) {
        AppMethodBeat.i(85736);
        reflectionInit();
        try {
            setValueStringStringMethod.invoke(str, str2);
            AppMethodBeat.o(85736);
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                setValueStringStringMethod.setArguments(str, str2);
                XWalkCoreWrapper.reserveReflectMethod(setValueStringStringMethod);
                AppMethodBeat.o(85736);
                return;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85736);
        }
    }

    public static boolean getValue(String str) {
        AppMethodBeat.i(85737);
        reflectionInit();
        try {
            boolean booleanValue = ((Boolean) getValueStringMethod.invoke(str)).booleanValue();
            AppMethodBeat.o(85737);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85737);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85737);
            return false;
        }
    }

    public static boolean getBooleanValue(String str) {
        AppMethodBeat.i(85738);
        reflectionInit();
        try {
            boolean booleanValue = ((Boolean) getBooleanValueStringMethod.invoke(str)).booleanValue();
            AppMethodBeat.o(85738);
            return booleanValue;
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85738);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85738);
            return false;
        }
    }

    public static int getIntegerValue(String str) {
        AppMethodBeat.i(85739);
        reflectionInit();
        try {
            int intValue = ((Integer) getIntegerValueStringMethod.invoke(str)).intValue();
            AppMethodBeat.o(85739);
            return intValue;
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85739);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85739);
            return 0;
        }
    }

    public static String getStringValue(String str) {
        AppMethodBeat.i(85740);
        reflectionInit();
        try {
            String str2 = (String) getStringValueStringMethod.invoke(str);
            AppMethodBeat.o(85740);
            return str2;
        } catch (UnsupportedOperationException e) {
            if (coreWrapper == null) {
                RuntimeException runtimeException = new RuntimeException("Crosswalk's APIs are not ready yet");
                AppMethodBeat.o(85740);
                throw runtimeException;
            }
            XWalkCoreWrapper.handleRuntimeError(e);
            AppMethodBeat.o(85740);
            return null;
        }
    }

    static void reflectionInit() {
        AppMethodBeat.i(85741);
        if (coreWrapper != null) {
            AppMethodBeat.o(85741);
            return;
        }
        XWalkCoreWrapper.initEmbeddedMode();
        XWalkCoreWrapper instance = XWalkCoreWrapper.getInstance();
        coreWrapper = instance;
        if (instance == null) {
            XWalkCoreWrapper.reserveReflectClass(XWalkPreferences.class);
            AppMethodBeat.o(85741);
            return;
        }
        Class bridgeClass = coreWrapper.getBridgeClass("XWalkPreferencesBridge");
        setValueStringbooleanMethod.init(null, bridgeClass, "setValue", String.class, Boolean.TYPE);
        setValueStringintMethod.init(null, bridgeClass, "setValue", String.class, Integer.TYPE);
        setValueStringStringMethod.init(null, bridgeClass, "setValue", String.class, String.class);
        getValueStringMethod.init(null, bridgeClass, "getValue", String.class);
        getBooleanValueStringMethod.init(null, bridgeClass, "getBooleanValue", String.class);
        getIntegerValueStringMethod.init(null, bridgeClass, "getIntegerValue", String.class);
        getStringValueStringMethod.init(null, bridgeClass, "getStringValue", String.class);
        AppMethodBeat.o(85741);
    }
}
