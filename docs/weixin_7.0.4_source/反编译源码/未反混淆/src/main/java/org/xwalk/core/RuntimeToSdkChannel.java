package org.xwalk.core;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.a;
import com.tencent.xweb.util.e;

public class RuntimeToSdkChannel {
    public static final String KEY_GET_CONFIG_CMD = "GET_CONFIG_CMD";
    public static final String KEY_INVOKE_METHOD = "INVOKE_INSTANCE_METHOD";
    public static final String KEY_STATIC_METHOD = "INVOKE_STATIC_METHOD";

    public static synchronized void initRuntimeToSdkChannel() {
        synchronized (RuntimeToSdkChannel.class) {
            AppMethodBeat.i(85523);
            if (XWalkCoreWrapper.getInstance() == null) {
                AppMethodBeat.o(85523);
            } else {
                XWalkCoreWrapper.getInstance();
                XWalkCoreWrapper.invokeRuntimeChannel(XWalkCoreWrapper.INVOKE_RUNTIME_ID_SET_RUNTIME_TO_SDK_CHANNEL, new Object[]{new ValueCallback() {
                    public final void onReceiveValue(Object obj) {
                        AppMethodBeat.i(85522);
                        if (obj == null || !(obj instanceof Object[])) {
                            AppMethodBeat.o(85522);
                            return;
                        }
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length < 3) {
                            AppMethodBeat.o(85522);
                        } else if (objArr[0] instanceof String) {
                            objArr[2] = RuntimeToSdkChannel.onRuntimeCalled((String) objArr[0], objArr[1]);
                            AppMethodBeat.o(85522);
                        } else {
                            AppMethodBeat.o(85522);
                        }
                    }
                }});
                AppMethodBeat.o(85523);
            }
        }
    }

    public static Object onRuntimeCalled(String str, Object obj) {
        AppMethodBeat.i(85524);
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
                        AppMethodBeat.o(85524);
                        return obj2;
                    } else if (TextUtils.isEmpty(strArr[1])) {
                        obj2 = a.ava(strArr[0]);
                        AppMethodBeat.o(85524);
                        return obj2;
                    } else {
                        obj2 = a.iG(strArr[0], strArr[1]);
                        AppMethodBeat.o(85524);
                        return obj2;
                    }
                }
                obj2 = "";
                AppMethodBeat.o(85524);
                return obj2;
            case 1:
                if (obj instanceof Object[]) {
                    objArr = (Object[]) obj;
                    if (objArr == null || objArr.length < 2) {
                        AppMethodBeat.o(85524);
                        return null;
                    } else if (!(objArr[0] instanceof Object)) {
                        AppMethodBeat.o(85524);
                        return null;
                    } else if (objArr[1] instanceof String) {
                        Object avm;
                        obj2 = objArr[0];
                        if (objArr[0] instanceof String) {
                            avm = e.avm((String) objArr[0]);
                        } else {
                            avm = obj2;
                        }
                        if (avm == null) {
                            AppMethodBeat.o(85524);
                            return null;
                        }
                        str2 = (String) objArr[1];
                        if (2 == objArr.length) {
                            obj2 = e.n(avm, str2);
                            AppMethodBeat.o(85524);
                            return obj2;
                        } else if (4 != objArr.length) {
                            obj2 = e.n(avm, str2);
                            AppMethodBeat.o(85524);
                            return obj2;
                        } else if (!(objArr[2] instanceof Class[])) {
                            obj2 = e.n(avm, str2);
                            AppMethodBeat.o(85524);
                            return obj2;
                        } else if (objArr[3] instanceof Object[]) {
                            obj2 = e.c(avm, str2, (Class[]) objArr[2], (Object[]) objArr[3]);
                            AppMethodBeat.o(85524);
                            return obj2;
                        } else {
                            obj2 = e.n(avm, str2);
                            AppMethodBeat.o(85524);
                            return obj2;
                        }
                    } else {
                        AppMethodBeat.o(85524);
                        return null;
                    }
                }
                AppMethodBeat.o(85524);
                return null;
            case 2:
                if (obj instanceof Object[]) {
                    objArr = (Object[]) obj;
                    if (objArr == null || objArr.length < 2) {
                        AppMethodBeat.o(85524);
                        return null;
                    } else if (!(objArr[0] instanceof String)) {
                        AppMethodBeat.o(85524);
                        return null;
                    } else if (objArr[1] instanceof String) {
                        str2 = (String) objArr[0];
                        String str3 = (String) objArr[1];
                        if (2 == objArr.length) {
                            obj2 = e.iJ(str2, str3);
                            AppMethodBeat.o(85524);
                            return obj2;
                        } else if (4 != objArr.length) {
                            obj2 = e.n(str2, str3);
                            AppMethodBeat.o(85524);
                            return obj2;
                        } else if (!(objArr[2] instanceof Class[])) {
                            obj2 = e.iJ(str2, str3);
                            AppMethodBeat.o(85524);
                            return obj2;
                        } else if (objArr[3] instanceof Object[]) {
                            obj2 = e.b(str2, str3, (Class[]) objArr[2], (Object[]) objArr[3]);
                            AppMethodBeat.o(85524);
                            return obj2;
                        } else {
                            obj2 = e.iJ(str2, str3);
                            AppMethodBeat.o(85524);
                            return obj2;
                        }
                    } else {
                        AppMethodBeat.o(85524);
                        return null;
                    }
                }
                AppMethodBeat.o(85524);
                return null;
            default:
                AppMethodBeat.o(85524);
                return null;
        }
    }
}
