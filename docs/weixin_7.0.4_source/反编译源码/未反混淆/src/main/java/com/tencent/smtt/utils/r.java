package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class r {
    public static Object a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        Object obj = null;
        AppMethodBeat.i(65287);
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            obj = method.invoke(null, objArr);
            AppMethodBeat.o(65287);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            AppMethodBeat.o(65287);
        }
        return obj;
    }

    public static Object a(Object obj, String str) {
        AppMethodBeat.i(65288);
        Object a = a(obj, str, null, new Object[0]);
        AppMethodBeat.o(65288);
        return a;
    }

    public static Object a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.i(65289);
        if (obj == null) {
            AppMethodBeat.o(65289);
            return null;
        }
        try {
            Class cls = obj.getClass();
            Method method = VERSION.SDK_INT > 10 ? cls.getMethod(str, clsArr) : cls.getDeclaredMethod(str, clsArr);
            method.setAccessible(true);
            if (objArr.length == 0) {
                objArr = null;
            }
            Object invoke = method.invoke(obj, objArr);
            AppMethodBeat.o(65289);
            return invoke;
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                String str2 = new String("AuthenticationFail");
                AppMethodBeat.o(65289);
                return str2;
            } else if (str == null || !(str.equalsIgnoreCase("canLoadX5Core") || str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                new StringBuilder("invokeInstance -- exceptions:").append(stringWriter.toString());
                AppMethodBeat.o(65289);
                return null;
            } else {
                AppMethodBeat.o(65289);
                return null;
            }
        }
    }

    public static Object a(String str, String str2) {
        Object obj = null;
        AppMethodBeat.i(65286);
        try {
            obj = Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            AppMethodBeat.o(65286);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            AppMethodBeat.o(65286);
        }
        return obj;
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.i(65290);
        Class cls = obj.getClass();
        while (cls != Object.class) {
            if (cls == null) {
                AppMethodBeat.o(65290);
                return null;
            }
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                AppMethodBeat.o(65290);
                return declaredMethod;
            } catch (Exception e) {
                cls = cls.getSuperclass();
            }
        }
        AppMethodBeat.o(65290);
        return null;
    }
}
