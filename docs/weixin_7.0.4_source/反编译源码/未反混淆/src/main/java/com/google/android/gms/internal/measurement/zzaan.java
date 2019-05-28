package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzq.zza;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

final class zzaan {
    static String zza(zzaal zzaal, String str) {
        AppMethodBeat.i(3340);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("# ").append(str);
        zza(zzaal, stringBuilder, 0);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(3340);
        return stringBuilder2;
    }

    private static void zza(zzaal zzaal, StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(3341);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzaal.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String valueOf;
            String valueOf2;
            Method method2;
            Method method3;
            String replaceFirst = str.replaceFirst("get", "");
            if (!(!replaceFirst.endsWith("List") || replaceFirst.endsWith("OrBuilderList") || replaceFirst.equals("List"))) {
                valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 4));
                valueOf = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(stringBuilder, i, zzfk(valueOf), zzzq.zza(method2, (Object) zzaal, new Object[0]));
                }
            }
            if (replaceFirst.endsWith("Map") && !replaceFirst.equals("Map")) {
                valueOf = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                valueOf2 = String.valueOf(replaceFirst.substring(1, replaceFirst.length() - 3));
                valueOf2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(stringBuilder, i, zzfk(valueOf2), zzzq.zza(method3, (Object) zzaal, new Object[0]));
                }
            }
            valueOf2 = "set";
            String str2 = String.valueOf(replaceFirst);
            if (((Method) hashMap2.get(str2.length() != 0 ? valueOf2.concat(str2) : new String(valueOf2))) != null) {
                if (replaceFirst.endsWith("Bytes")) {
                    valueOf2 = "get";
                    str2 = String.valueOf(replaceFirst.substring(0, replaceFirst.length() - 5));
                    if (hashMap.containsKey(str2.length() != 0 ? valueOf2.concat(str2) : new String(valueOf2))) {
                    }
                }
                valueOf2 = String.valueOf(replaceFirst.substring(0, 1).toLowerCase());
                str2 = String.valueOf(replaceFirst.substring(1));
                String concat = str2.length() != 0 ? valueOf2.concat(str2) : new String(valueOf2);
                valueOf2 = "get";
                str2 = String.valueOf(replaceFirst);
                method3 = (Method) hashMap.get(str2.length() != 0 ? valueOf2.concat(str2) : new String(valueOf2));
                valueOf = "has";
                valueOf2 = String.valueOf(replaceFirst);
                method2 = (Method) hashMap.get(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                if (method3 != null) {
                    boolean equals;
                    zzaal zza = zzzq.zza(method3, (Object) zzaal, new Object[0]);
                    if (method2 == null) {
                        equals = zza instanceof Boolean ? !((Boolean) zza).booleanValue() : zza instanceof Integer ? ((Integer) zza).intValue() == 0 : zza instanceof Float ? ((Float) zza).floatValue() == 0.0f : zza instanceof Double ? ((Double) zza).doubleValue() == 0.0d : zza instanceof String ? zza.equals("") : zza instanceof zzyw ? zza.equals(zzyw.zzbqx) : zza instanceof zzaal ? zza == ((zzaal) zza).zztz() : zza instanceof Enum ? ((Enum) zza).ordinal() == 0 : false;
                        equals = !equals;
                    } else {
                        equals = ((Boolean) zzzq.zza(method2, (Object) zzaal, new Object[0])).booleanValue();
                    }
                    if (equals) {
                        zzb(stringBuilder, i, zzfk(concat), zza);
                    }
                }
            }
        }
        if (zzaal instanceof zza) {
            Iterator it = ((zza) zzaal).zzbsb.iterator();
            if (it.hasNext()) {
                ((Entry) it.next()).getKey();
                NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
                AppMethodBeat.o(3341);
                throw noSuchMethodError;
            }
        }
        AppMethodBeat.o(3341);
    }

    static final void zzb(StringBuilder stringBuilder, int i, String str, Object obj) {
        int i2 = 0;
        AppMethodBeat.i(3342);
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(stringBuilder, i, str, zzb);
            }
            AppMethodBeat.o(3342);
        } else if (obj instanceof Map) {
            for (Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(stringBuilder, i, str, zzb2);
            }
            AppMethodBeat.o(3342);
        } else {
            stringBuilder.append(10);
            for (int i3 = 0; i3 < i; i3++) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(str);
            if (obj instanceof String) {
                stringBuilder.append(": \"").append(zzabg.zza(zzyw.zzfi((String) obj))).append('\"');
                AppMethodBeat.o(3342);
            } else if (obj instanceof zzyw) {
                stringBuilder.append(": \"").append(zzabg.zza((zzyw) obj)).append('\"');
                AppMethodBeat.o(3342);
            } else if (obj instanceof zzzq) {
                stringBuilder.append(" {");
                zza((zzzq) obj, stringBuilder, i + 2);
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                while (i2 < i) {
                    stringBuilder.append(' ');
                    i2++;
                }
                stringBuilder.append("}");
                AppMethodBeat.o(3342);
            } else if (obj instanceof Entry) {
                stringBuilder.append(" {");
                Entry entry = (Entry) obj;
                zzb(stringBuilder, i + 2, "key", entry.getKey());
                zzb(stringBuilder, i + 2, "value", entry.getValue());
                stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                while (i2 < i) {
                    stringBuilder.append(' ');
                    i2++;
                }
                stringBuilder.append("}");
                AppMethodBeat.o(3342);
            } else {
                stringBuilder.append(": ").append(obj.toString());
                AppMethodBeat.o(3342);
            }
        }
    }

    private static final String zzfk(String str) {
        AppMethodBeat.i(3343);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                stringBuilder.append("_");
            }
            stringBuilder.append(Character.toLowerCase(charAt));
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(3343);
        return stringBuilder2;
    }
}
