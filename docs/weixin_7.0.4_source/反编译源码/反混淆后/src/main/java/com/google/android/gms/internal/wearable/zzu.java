package com.google.android.gms.internal.wearable;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.view.C31128d;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class zzu {
    private static void zza(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        AppMethodBeat.m2504i(70780);
        if (obj != null) {
            int modifiers;
            int length;
            if (obj instanceof zzt) {
                String name;
                int length2 = stringBuffer.length();
                if (str != null) {
                    stringBuffer2.append(stringBuffer).append(zzh(str)).append(" <\n");
                    stringBuffer.append("  ");
                }
                Class cls = obj.getClass();
                for (Field field : cls.getFields()) {
                    modifiers = field.getModifiers();
                    name = field.getName();
                    if (!("cachedSize".equals(name) || (modifiers & 1) != 1 || (modifiers & 8) == 8 || name.startsWith("_") || name.endsWith("_"))) {
                        Class type = field.getType();
                        Object obj2 = field.get(obj);
                        if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                            zza(name, obj2, stringBuffer, stringBuffer2);
                        } else {
                            length = obj2 == null ? 0 : Array.getLength(obj2);
                            for (modifiers = 0; modifiers < length; modifiers++) {
                                zza(name, Array.get(obj2, modifiers), stringBuffer, stringBuffer2);
                            }
                        }
                    }
                }
                for (Method name2 : cls.getMethods()) {
                    String name3 = name2.getName();
                    if (name3.startsWith("set")) {
                        String substring = name3.substring(3);
                        try {
                            name = "has";
                            name3 = String.valueOf(substring);
                            if (((Boolean) cls.getMethod(name3.length() != 0 ? name.concat(name3) : new String(name), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                                try {
                                    name = "get";
                                    name3 = String.valueOf(substring);
                                    zza(substring, cls.getMethod(name3.length() != 0 ? name.concat(name3) : new String(name), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                                } catch (NoSuchMethodException e) {
                                }
                            }
                        } catch (NoSuchMethodException e2) {
                        }
                    }
                }
                if (str != null) {
                    stringBuffer.setLength(length2);
                    stringBuffer2.append(stringBuffer).append(">\n");
                }
                AppMethodBeat.m2505o(70780);
                return;
            }
            stringBuffer2.append(stringBuffer).append(zzh(str)).append(": ");
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (!str2.startsWith("http") && str2.length() > 200) {
                    str2 = String.valueOf(str2.substring(0, 200)).concat("[...]");
                }
                modifiers = str2.length();
                StringBuilder stringBuilder = new StringBuilder(modifiers);
                for (length = 0; length < modifiers; length++) {
                    char charAt = str2.charAt(length);
                    if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                        stringBuilder.append(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    } else {
                        stringBuilder.append(charAt);
                    }
                }
                stringBuffer2.append("\"").append(stringBuilder.toString()).append("\"");
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                if (bArr == null) {
                    stringBuffer2.append("\"\"");
                } else {
                    stringBuffer2.append('\"');
                    for (byte b : bArr) {
                        modifiers = b & 255;
                        if (modifiers == 92 || modifiers == 34) {
                            stringBuffer2.append(IOUtils.DIR_SEPARATOR_WINDOWS).append((char) modifiers);
                        } else if (modifiers < 32 || modifiers >= C31128d.MIC_SketchMark) {
                            stringBuffer2.append(String.format("\\%03o", new Object[]{Integer.valueOf(modifiers)}));
                        } else {
                            stringBuffer2.append((char) modifiers);
                        }
                    }
                    stringBuffer2.append('\"');
                }
            } else {
                stringBuffer2.append(obj);
            }
            stringBuffer2.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        AppMethodBeat.m2505o(70780);
    }

    public static <T extends zzt> String zzc(T t) {
        String str;
        AppMethodBeat.m2504i(70779);
        String str2;
        if (t == null) {
            str2 = "";
            AppMethodBeat.m2505o(70779);
            return str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            zza(null, t, new StringBuffer(), stringBuffer);
            str2 = stringBuffer.toString();
            AppMethodBeat.m2505o(70779);
            return str2;
        } catch (IllegalAccessException e) {
            str = "Error printing proto: ";
            str2 = String.valueOf(e.getMessage());
            if (str2.length() != 0) {
                str2 = str.concat(str2);
                AppMethodBeat.m2505o(70779);
                return str2;
            }
            str2 = new String(str);
            AppMethodBeat.m2505o(70779);
            return str2;
        } catch (InvocationTargetException e2) {
            str = "Error printing proto: ";
            str2 = String.valueOf(e2.getMessage());
            if (str2.length() != 0) {
                str2 = str.concat(str2);
                AppMethodBeat.m2505o(70779);
                return str2;
            }
            str2 = new String(str);
            AppMethodBeat.m2505o(70779);
            return str2;
        }
    }

    private static String zzh(String str) {
        AppMethodBeat.m2504i(70781);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i == 0) {
                stringBuffer.append(Character.toLowerCase(charAt));
            } else if (Character.isUpperCase(charAt)) {
                stringBuffer.append('_').append(Character.toLowerCase(charAt));
            } else {
                stringBuffer.append(charAt);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(70781);
        return stringBuffer2;
    }
}
