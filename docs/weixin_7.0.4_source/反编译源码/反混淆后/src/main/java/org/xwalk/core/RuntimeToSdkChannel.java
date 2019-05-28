package org.xwalk.core;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.util.C6038e;

public class RuntimeToSdkChannel {
    public static final String KEY_GET_CONFIG_CMD = "GET_CONFIG_CMD";
    public static final String KEY_INVOKE_METHOD = "INVOKE_INSTANCE_METHOD";
    public static final String KEY_STATIC_METHOD = "INVOKE_STATIC_METHOD";

    /* renamed from: org.xwalk.core.RuntimeToSdkChannel$1 */
    static class C246011 implements ValueCallback {
        C246011() {
        }

        public final void onReceiveValue(Object obj) {
            AppMethodBeat.m2504i(85522);
            if (obj == null || !(obj instanceof Object[])) {
                AppMethodBeat.m2505o(85522);
                return;
            }
            Object[] objArr = (Object[]) obj;
            if (objArr.length < 3) {
                AppMethodBeat.m2505o(85522);
            } else if (objArr[0] instanceof String) {
                objArr[2] = RuntimeToSdkChannel.onRuntimeCalled((String) objArr[0], objArr[1]);
                AppMethodBeat.m2505o(85522);
            } else {
                AppMethodBeat.m2505o(85522);
            }
        }
    }

    public static synchronized void initRuntimeToSdkChannel() {
        synchronized (RuntimeToSdkChannel.class) {
            AppMethodBeat.m2504i(85523);
            if (XWalkCoreWrapper.getInstance() == null) {
                AppMethodBeat.m2505o(85523);
            } else {
                XWalkCoreWrapper.getInstance();
                XWalkCoreWrapper.invokeRuntimeChannel(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL, new Object[]{new C246011()});
                AppMethodBeat.m2505o(85523);
            }
        }
    }

    public static Object onRuntimeCalled(String str, Object obj) {
        AppMethodBeat.m2504i(85524);
        int i = -1;
        switch (str.hashCode()) {
            case 51739140:
                if (str.equals(KEY_INVOKE_METHOD)) {
                    i = 1;
                    break;
                }
                break;
            case 59342662:
                if (str.equals(KEY_GET_CONFIG_CMD)) {
                    i = 0;
                    break;
                }
                break;
            case 886431819:
                if (str.equals(KEY_STATIC_METHOD)) {
                    i = 2;
                    break;
                }
                break;
        }
        Object obj2;
        Object[] objArr;
        String str2;
        switch (i) {
            case 0:
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length < 2) {
                        obj2 = "";
                        AppMethodBeat.m2505o(85524);
                        return obj2;
                    } else if (TextUtils.isEmpty(strArr[1])) {
                        obj2 = C44572a.ava(strArr[0]);
                        AppMethodBeat.m2505o(85524);
                        return obj2;
                    } else {
                        obj2 = C44572a.m80959iG(strArr[0], strArr[1]);
                        AppMethodBeat.m2505o(85524);
                        return obj2;
                    }
                }
                obj2 = "";
                AppMethodBeat.m2505o(85524);
                return obj2;
            case 1:
                if (obj instanceof Object[]) {
                    objArr = (Object[]) obj;
                    if (objArr == null || objArr.length < 2) {
                        AppMethodBeat.m2505o(85524);
                        return null;
                    } else if (!(objArr[0] instanceof Object)) {
                        AppMethodBeat.m2505o(85524);
                        return null;
                    } else if (objArr[1] instanceof String) {
                        Object avm;
                        obj2 = objArr[0];
                        if (objArr[0] instanceof String) {
                            avm = C6038e.avm((String) objArr[0]);
                        } else {
                            avm = obj2;
                        }
                        if (avm == null) {
                            AppMethodBeat.m2505o(85524);
                            return null;
                        }
                        str2 = (String) objArr[1];
                        if (2 == objArr.length) {
                            obj2 = C6038e.m9510n(avm, str2);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        } else if (4 != objArr.length) {
                            obj2 = C6038e.m9510n(avm, str2);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        } else if (!(objArr[2] instanceof Class[])) {
                            obj2 = C6038e.m9510n(avm, str2);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        } else if (objArr[3] instanceof Object[]) {
                            obj2 = C6038e.m9508c(avm, str2, (Class[]) objArr[2], (Object[]) objArr[3]);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        } else {
                            obj2 = C6038e.m9510n(avm, str2);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        }
                    } else {
                        AppMethodBeat.m2505o(85524);
                        return null;
                    }
                }
                AppMethodBeat.m2505o(85524);
                return null;
            case 2:
                if (obj instanceof Object[]) {
                    objArr = (Object[]) obj;
                    if (objArr == null || objArr.length < 2) {
                        AppMethodBeat.m2505o(85524);
                        return null;
                    } else if (!(objArr[0] instanceof String)) {
                        AppMethodBeat.m2505o(85524);
                        return null;
                    } else if (objArr[1] instanceof String) {
                        str2 = (String) objArr[0];
                        String str3 = (String) objArr[1];
                        if (2 == objArr.length) {
                            obj2 = C6038e.m9509iJ(str2, str3);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        } else if (4 != objArr.length) {
                            obj2 = C6038e.m9510n(str2, str3);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        } else if (!(objArr[2] instanceof Class[])) {
                            obj2 = C6038e.m9509iJ(str2, str3);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        } else if (objArr[3] instanceof Object[]) {
                            obj2 = C6038e.m9507b(str2, str3, (Class[]) objArr[2], (Object[]) objArr[3]);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        } else {
                            obj2 = C6038e.m9509iJ(str2, str3);
                            AppMethodBeat.m2505o(85524);
                            return obj2;
                        }
                    } else {
                        AppMethodBeat.m2505o(85524);
                        return null;
                    }
                }
                AppMethodBeat.m2505o(85524);
                return null;
            default:
                AppMethodBeat.m2505o(85524);
                return null;
        }
    }
}
