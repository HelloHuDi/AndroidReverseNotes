package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.a */
public class C5852a {
    /* renamed from: a */
    private static ClassLoader f1507a = null;
    /* renamed from: b */
    private static boolean f1508b = true;

    /* renamed from: a */
    private static void m9003a(ArrayList<String> arrayList, String str) {
        AppMethodBeat.m2504i(98397);
        int length = str.length();
        while (str.charAt(length - 1) == '>') {
            length--;
            if (length == 0) {
                break;
            }
        }
        arrayList.add(0, C5852a.m9006c(str.substring(0, length)));
        AppMethodBeat.m2505o(98397);
    }

    /* renamed from: a */
    public static ArrayList<String> m9002a(String str) {
        AppMethodBeat.m2504i(98398);
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf("<");
        int i = 0;
        while (i < indexOf) {
            C5852a.m9003a(arrayList, str.substring(i, indexOf));
            i = indexOf + 1;
            indexOf = str.indexOf("<", i);
            int indexOf2 = str.indexOf(",", i);
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            if (indexOf2 != -1 && indexOf2 < indexOf) {
                indexOf = indexOf2;
            }
        }
        C5852a.m9003a(arrayList, str.substring(i, str.length()));
        AppMethodBeat.m2505o(98398);
        return arrayList;
    }

    /* renamed from: a */
    public static String m9001a(ArrayList<String> arrayList) {
        int i;
        String str;
        AppMethodBeat.m2504i(98399);
        StringBuffer stringBuffer = new StringBuffer();
        for (i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, C5852a.m9005b((String) arrayList.get(i)));
        }
        Collections.reverse(arrayList);
        for (i = 0; i < arrayList.size(); i++) {
            str = (String) arrayList.get(i);
            if (str.equals("list")) {
                arrayList.set(i - 1, "<" + ((String) arrayList.get(i - 1)));
                arrayList.set(0, ((String) arrayList.get(0)) + ">");
            } else if (str.equals("map")) {
                arrayList.set(i - 1, "<" + ((String) arrayList.get(i - 1)) + ",");
                arrayList.set(0, ((String) arrayList.get(0)) + ">");
            } else if (str.equals("Array")) {
                arrayList.set(i - 1, "<" + ((String) arrayList.get(i - 1)));
                arrayList.set(0, ((String) arrayList.get(0)) + ">");
            }
        }
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
        }
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(98399);
        return str;
    }

    /* renamed from: a */
    public static Object m9000a(String str, boolean z, ClassLoader classLoader) {
        AppMethodBeat.m2504i(98400);
        Iterator it = C5852a.m9002a(str).iterator();
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        while (it.hasNext()) {
            Object obj4;
            Object b = C5852a.m9004b((String) it.next(), z, classLoader);
            if (b instanceof String) {
                if ("Array".equals((String) b)) {
                    if (obj3 == null) {
                        obj = Array.newInstance(Byte.class, 0);
                    }
                } else if (!"?".equals((String) b)) {
                    if (obj3 == null) {
                        obj = b;
                        obj3 = b;
                    } else {
                        obj = b;
                        obj2 = obj3;
                        obj3 = b;
                    }
                }
                obj4 = obj3;
            } else if (b instanceof List) {
                if (obj3 == null || !(obj3 instanceof Byte)) {
                    if (obj3 != null) {
                        ((List) b).add(obj3);
                    }
                    obj = b;
                    obj3 = null;
                } else {
                    b = Array.newInstance(Byte.class, 1);
                    Array.set(b, 0, obj3);
                    obj = b;
                }
            } else if (b instanceof Map) {
                if (((obj2 != null ? 1 : 0) & (obj3 != null ? 1 : 0)) != 0) {
                    ((Map) b).put(obj3, obj2);
                }
                obj = b;
                obj2 = null;
                obj3 = null;
            } else if (obj3 == null) {
                obj = b;
                obj3 = b;
            } else {
                obj2 = obj3;
                obj4 = b;
            }
            obj = b;
            obj3 = obj4;
        }
        AppMethodBeat.m2505o(98400);
        return obj;
    }

    /* renamed from: b */
    public static Object m9004b(String str, boolean z, ClassLoader classLoader) {
        AppMethodBeat.m2504i(98401);
        Object obj;
        if (str.equals("java.lang.Integer")) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(98401);
            return valueOf;
        } else if (str.equals("java.lang.Boolean")) {
            obj = Boolean.FALSE;
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("java.lang.Byte")) {
            obj = Byte.valueOf((byte) 0);
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("java.lang.Double")) {
            obj = Double.valueOf(0.0d);
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("java.lang.Float")) {
            obj = Float.valueOf(0.0f);
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("java.lang.Long")) {
            obj = Long.valueOf(0);
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("java.lang.Short")) {
            obj = Short.valueOf((short) 0);
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("java.lang.Character")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("can not support java.lang.Character");
            AppMethodBeat.m2505o(98401);
            throw illegalArgumentException;
        } else if (str.equals("java.lang.String")) {
            obj = "";
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("java.util.List")) {
            obj = new ArrayList();
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("java.util.Map")) {
            obj = new HashMap();
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("Array")) {
            obj = "Array";
            AppMethodBeat.m2505o(98401);
            return obj;
        } else if (str.equals("?")) {
            AppMethodBeat.m2505o(98401);
            return str;
        } else {
            Class cls;
            if (classLoader != null) {
                try {
                    cls = Class.forName(str, z, classLoader);
                } catch (Exception e) {
                    C5857b c5857b = new C5857b(e);
                    AppMethodBeat.m2505o(98401);
                    throw c5857b;
                }
            } else if (f1507a != null) {
                cls = Class.forName(str, f1508b, f1507a);
            } else {
                cls = Class.forName(str);
            }
            obj = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.m2505o(98401);
            return obj;
        }
    }

    /* renamed from: b */
    public static String m9005b(String str) {
        AppMethodBeat.m2504i(98402);
        if (str.equals("java.lang.Integer") || str.equals("int")) {
            str = "int32";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.lang.Boolean") || str.equals(DownloadSetting.TYPE_BOOLEAN)) {
            str = "bool";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.lang.Byte") || str.equals("byte")) {
            str = "char";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.lang.Double") || str.equals("double")) {
            str = "double";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.lang.Float") || str.equals("float")) {
            str = "float";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.lang.Long") || str.equals("long")) {
            str = "int64";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.lang.Short") || str.equals("short")) {
            str = "short";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.lang.Character")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("can not support java.lang.Character");
            AppMethodBeat.m2505o(98402);
            throw illegalArgumentException;
        } else if (str.equals("java.lang.String")) {
            str = "string";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.util.List")) {
            str = "list";
            AppMethodBeat.m2505o(98402);
            return str;
        } else if (str.equals("java.util.Map")) {
            str = "map";
            AppMethodBeat.m2505o(98402);
            return str;
        } else {
            AppMethodBeat.m2505o(98402);
            return str;
        }
    }

    /* renamed from: c */
    public static String m9006c(String str) {
        AppMethodBeat.m2504i(98403);
        if (str.equals("int32")) {
            str = "java.lang.Integer";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("bool")) {
            str = "java.lang.Boolean";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("char")) {
            str = "java.lang.Byte";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("double")) {
            str = "java.lang.Double";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("float")) {
            str = "java.lang.Float";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("int64")) {
            str = "java.lang.Long";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("short")) {
            str = "java.lang.Short";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("string")) {
            str = "java.lang.String";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("list")) {
            str = "java.util.List";
            AppMethodBeat.m2505o(98403);
            return str;
        } else if (str.equals("map")) {
            str = "java.util.Map";
            AppMethodBeat.m2505o(98403);
            return str;
        } else {
            AppMethodBeat.m2505o(98403);
            return str;
        }
    }
}
