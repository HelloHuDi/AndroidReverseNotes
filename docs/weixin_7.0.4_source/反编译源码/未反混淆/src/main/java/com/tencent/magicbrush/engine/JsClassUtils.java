package com.tencent.magicbrush.engine;

import android.support.annotation.Keep;
import android.webkit.JavascriptInterface;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;

@Keep
public class JsClassUtils {
    private static final int BOOLEAN = 1;
    private static final int BYTE = 3;
    private static final int CHAR = 2;
    private static final int DOUBLE = 8;
    private static final int FLOAT = 6;
    private static final int INT = 5;
    private static final int LONG = 7;
    private static final int SHORT = 4;
    private static final String TAG = "MicroMsg.JsClassUtils";
    private static final int VOID = 0;
    public static final int log_type_d = 0;
    public static final int log_type_e = 2;
    public static final int log_type_i = 1;
    private static final int string = 9;
    private static final int unknown = 10;

    public static boolean hasJavascriptInterface(Object obj) {
        AppMethodBeat.i(115872);
        try {
            for (Method isAnnotationPresent : obj.getClass().getMethods()) {
                if (isAnnotationPresent.isAnnotationPresent(JavascriptInterface.class)) {
                    AppMethodBeat.o(115872);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(115872);
        return false;
    }

    @Keep
    public static Method[] getJavascriptInterfaceMethod(Object obj) {
        AppMethodBeat.i(115873);
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
        AppMethodBeat.o(115873);
        return methodArr;
    }

    @Keep
    public static String getMethodSignature(Method method) {
        AppMethodBeat.i(115874);
        Class[] parameterTypes = method.getParameterTypes();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('(');
        for (Class descriptor : parameterTypes) {
            getDescriptor(stringBuilder, descriptor);
        }
        stringBuilder.append(')');
        getDescriptor(stringBuilder, method.getReturnType());
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(115874);
        return stringBuilder2;
    }

    @Keep
    public static String getMethodName(Method method) {
        AppMethodBeat.i(115875);
        String name = method.getName();
        AppMethodBeat.o(115875);
        return name;
    }

    private static void getDescriptor(StringBuilder stringBuilder, Class<?> cls) {
        Class cls2;
        char charAt;
        AppMethodBeat.i(115876);
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
                AppMethodBeat.o(115876);
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
        AppMethodBeat.o(115876);
    }

    private static int getJavaType(Class<?> cls) {
        AppMethodBeat.i(115877);
        if (cls == Integer.TYPE) {
            AppMethodBeat.o(115877);
            return 5;
        } else if (cls == Void.TYPE) {
            AppMethodBeat.o(115877);
            return 0;
        } else if (cls == Boolean.TYPE) {
            AppMethodBeat.o(115877);
            return 1;
        } else if (cls == Byte.TYPE) {
            AppMethodBeat.o(115877);
            return 3;
        } else if (cls == Character.TYPE) {
            AppMethodBeat.o(115877);
            return 2;
        } else if (cls == Short.TYPE) {
            AppMethodBeat.o(115877);
            return 4;
        } else if (cls == Double.TYPE) {
            AppMethodBeat.o(115877);
            return 8;
        } else if (cls == Float.TYPE) {
            AppMethodBeat.o(115877);
            return 6;
        } else if (cls.getCanonicalName().equals("java.lang.String")) {
            AppMethodBeat.o(115877);
            return 9;
        } else {
            AppMethodBeat.o(115877);
            return 10;
        }
    }

    @Keep
    public static int[] getMethodType(Method method) {
        int i = 0;
        AppMethodBeat.i(115878);
        Class[] parameterTypes = method.getParameterTypes();
        int[] iArr = new int[(parameterTypes.length + 2)];
        iArr[0] = parameterTypes.length;
        iArr[1] = getJavaType(method.getReturnType());
        while (i < parameterTypes.length) {
            iArr[i + 2] = getJavaType(parameterTypes[i]);
            i++;
        }
        AppMethodBeat.o(115878);
        return iArr;
    }

    @Keep
    public static void jsLog(int i, String str) {
        AppMethodBeat.i(115879);
        switch (i) {
            case 1:
                c.i(TAG, str, new Object[0]);
                AppMethodBeat.o(115879);
                return;
            case 2:
                c.e(TAG, str, new Object[0]);
                AppMethodBeat.o(115879);
                return;
            default:
                c.d(TAG, str, new Object[0]);
                AppMethodBeat.o(115879);
                return;
        }
    }

    @Keep
    public static byte[] getStringUtf8(String str) {
        AppMethodBeat.i(115880);
        try {
            byte[] bytes = str.getBytes("UTF-8");
            AppMethodBeat.o(115880);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.o(115880);
            return null;
        }
    }
}
