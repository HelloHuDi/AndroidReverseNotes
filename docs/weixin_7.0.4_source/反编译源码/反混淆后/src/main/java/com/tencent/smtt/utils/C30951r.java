package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

/* renamed from: com.tencent.smtt.utils.r */
public class C30951r {
    /* renamed from: a */
    public static Object m49576a(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        Object obj = null;
        AppMethodBeat.m2504i(65287);
        try {
            Method method = cls.getMethod(str, clsArr);
            method.setAccessible(true);
            obj = method.invoke(null, objArr);
            AppMethodBeat.m2505o(65287);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            AppMethodBeat.m2505o(65287);
        }
        return obj;
    }

    /* renamed from: a */
    public static Object m49577a(Object obj, String str) {
        AppMethodBeat.m2504i(65288);
        Object a = C30951r.m49578a(obj, str, null, new Object[0]);
        AppMethodBeat.m2505o(65288);
        return a;
    }

    /* renamed from: a */
    public static Object m49578a(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        AppMethodBeat.m2504i(65289);
        if (obj == null) {
            AppMethodBeat.m2505o(65289);
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
            AppMethodBeat.m2505o(65289);
            return invoke;
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            if (th.getCause() != null && th.getCause().toString().contains("AuthenticationFail")) {
                String str2 = new String("AuthenticationFail");
                AppMethodBeat.m2505o(65289);
                return str2;
            } else if (str == null || !(str.equalsIgnoreCase("canLoadX5Core") || str.equalsIgnoreCase("initTesRuntimeEnvironment"))) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                new StringBuilder("invokeInstance -- exceptions:").append(stringWriter.toString());
                AppMethodBeat.m2505o(65289);
                return null;
            } else {
                AppMethodBeat.m2505o(65289);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Object m49579a(String str, String str2) {
        Object obj = null;
        AppMethodBeat.m2504i(65286);
        try {
            obj = Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            AppMethodBeat.m2505o(65286);
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_INVOKE_ERROR, String.valueOf(th), new Object[0]);
            AppMethodBeat.m2505o(65286);
        }
        return obj;
    }

    /* renamed from: a */
    public static Method m49580a(Object obj, String str, Class<?>... clsArr) {
        AppMethodBeat.m2504i(65290);
        Class cls = obj.getClass();
        while (cls != Object.class) {
            if (cls == null) {
                AppMethodBeat.m2505o(65290);
                return null;
            }
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                AppMethodBeat.m2505o(65290);
                return declaredMethod;
            } catch (Exception e) {
                cls = cls.getSuperclass();
            }
        }
        AppMethodBeat.m2505o(65290);
        return null;
    }
}
