package com.tencent.xweb.xwalk;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class JsClassUtils {
    @Keep
    public static Method[] getJavascriptInterfaceMethod(Object obj) {
        AppMethodBeat.m2504i(4159);
        ArrayList arrayList = new ArrayList();
        try {
            for (Method method : obj.getClass().getMethods()) {
                if (method.isAnnotationPresent(JavascriptInterface.class)) {
                    arrayList.add(method);
                }
            }
        } catch (Exception e) {
        }
        Method[] methodArr = (Method[]) arrayList.toArray(new Method[arrayList.size()]);
        AppMethodBeat.m2505o(4159);
        return methodArr;
    }

    @Keep
    public static String getMethodSignature(Method method) {
        AppMethodBeat.m2504i(4160);
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        for (Class descriptor : parameterTypes) {
            getDescriptor(stringBuilder, descriptor);
        }
        stringBuilder.append(')');
        getDescriptor(stringBuilder, method.getReturnType());
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(4160);
        return stringBuilder2;
    }

    @Keep
    public static String getMethodName(Method method) {
        AppMethodBeat.m2504i(4161);
        String name = method.getName();
        AppMethodBeat.m2505o(4161);
        return name;
    }

    private static void getDescriptor(StringBuilder stringBuilder, Class<?> cls) {
        Class cls2;
        char charAt;
        AppMethodBeat.m2504i(4162);
        while (!cls2.isPrimitive()) {
            if (cls2.isArray()) {
                stringBuilder.append('[');
                cls2 = cls2.getComponentType();
            } else {
                stringBuilder.append('L');
                String name = cls2.getName();
                int length = name.length();
                for (int i = 0; i < length; i++) {
                    charAt = name.charAt(i);
                    if (charAt == '.') {
                        charAt = IOUtils.DIR_SEPARATOR_UNIX;
                    }
                    stringBuilder.append(charAt);
                }
                stringBuilder.append(';');
                AppMethodBeat.m2505o(4162);
                return;
            }
        }
        if (cls2 == Integer.TYPE) {
            charAt = 'I';
        } else if (cls2 == Void.TYPE) {
            charAt = 'V';
        } else if (cls2 == Boolean.TYPE) {
            charAt = 'Z';
        } else if (cls2 == Byte.TYPE) {
            charAt = 'B';
        } else if (cls2 == Character.TYPE) {
            charAt = 'C';
        } else if (cls2 == Short.TYPE) {
            charAt = 'S';
        } else if (cls2 == Double.TYPE) {
            charAt = 'D';
        } else if (cls2 == Float.TYPE) {
            charAt = 'F';
        } else {
            charAt = 'J';
        }
        stringBuilder.append(charAt);
        AppMethodBeat.m2505o(4162);
    }

    private static int getJavaType(Class<?> cls) {
        AppMethodBeat.m2504i(4163);
        if (cls == Integer.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 5;
        } else if (cls == Void.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 0;
        } else if (cls == Boolean.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 1;
        } else if (cls == Byte.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 3;
        } else if (cls == Character.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 2;
        } else if (cls == Short.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 4;
        } else if (cls == Double.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 8;
        } else if (cls == Float.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 6;
        } else if (cls == Long.TYPE) {
            AppMethodBeat.m2505o(4163);
            return 7;
        } else if (cls.getCanonicalName().equals("java.lang.String")) {
            AppMethodBeat.m2505o(4163);
            return 9;
        } else {
            AppMethodBeat.m2505o(4163);
            return 10;
        }
    }

    @Keep
    public static int[] getMethodType(Method method) {
        int i = 0;
        AppMethodBeat.m2504i(4164);
        Class[] parameterTypes = method.getParameterTypes();
        int[] iArr = new int[(parameterTypes.length + 2)];
        iArr[0] = parameterTypes.length;
        iArr[1] = getJavaType(method.getReturnType());
        while (i < parameterTypes.length) {
            iArr[i + 2] = getJavaType(parameterTypes[i]);
            i++;
        }
        AppMethodBeat.m2505o(4164);
        return iArr;
    }
}
