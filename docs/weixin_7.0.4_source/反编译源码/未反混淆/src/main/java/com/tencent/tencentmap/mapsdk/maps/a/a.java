package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadSetting;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {
    private static ClassLoader a = null;
    private static boolean b = true;

    private static void a(ArrayList<String> arrayList, String str) {
        AppMethodBeat.i(98397);
        int length = str.length();
        while (str.charAt(length - 1) == '>') {
            length--;
            if (length == 0) {
                break;
            }
        }
        arrayList.add(0, c(str.substring(0, length)));
        AppMethodBeat.o(98397);
    }

    public static ArrayList<String> a(String str) {
        AppMethodBeat.i(98398);
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf("<");
        int i = 0;
        while (i < indexOf) {
            a(arrayList, str.substring(i, indexOf));
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
        a(arrayList, str.substring(i, str.length()));
        AppMethodBeat.o(98398);
        return arrayList;
    }

    public static String a(ArrayList<String> arrayList) {
        int i;
        String str;
        AppMethodBeat.i(98399);
        StringBuffer stringBuffer = new StringBuffer();
        for (i = 0; i < arrayList.size(); i++) {
            arrayList.set(i, b((String) arrayList.get(i)));
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
        AppMethodBeat.o(98399);
        return str;
    }

    public static Object a(String str, boolean z, ClassLoader classLoader) {
        AppMethodBeat.i(98400);
        Iterator it = a(str).iterator();
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        while (it.hasNext()) {
            Object obj4;
            Object b = b((String) it.next(), z, classLoader);
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
        AppMethodBeat.o(98400);
        return obj;
    }

    public static Object b(String str, boolean z, ClassLoader classLoader) {
        AppMethodBeat.i(98401);
        Object obj;
        if (str.equals("java.lang.Integer")) {
            Integer valueOf = Integer.valueOf(0);
            AppMethodBeat.o(98401);
            return valueOf;
        } else if (str.equals("java.lang.Boolean")) {
            obj = Boolean.FALSE;
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("java.lang.Byte")) {
            obj = Byte.valueOf((byte) 0);
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("java.lang.Double")) {
            obj = Double.valueOf(0.0d);
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("java.lang.Float")) {
            obj = Float.valueOf(0.0f);
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("java.lang.Long")) {
            obj = Long.valueOf(0);
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("java.lang.Short")) {
            obj = Short.valueOf((short) 0);
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("java.lang.Character")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("can not support java.lang.Character");
            AppMethodBeat.o(98401);
            throw illegalArgumentException;
        } else if (str.equals("java.lang.String")) {
            obj = "";
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("java.util.List")) {
            obj = new ArrayList();
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("java.util.Map")) {
            obj = new HashMap();
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("Array")) {
            obj = "Array";
            AppMethodBeat.o(98401);
            return obj;
        } else if (str.equals("?")) {
            AppMethodBeat.o(98401);
            return str;
        } else {
            Class cls;
            if (classLoader != null) {
                try {
                    cls = Class.forName(str, z, classLoader);
                } catch (Exception e) {
                    b bVar = new b(e);
                    AppMethodBeat.o(98401);
                    throw bVar;
                }
            } else if (a != null) {
                cls = Class.forName(str, b, a);
            } else {
                cls = Class.forName(str);
            }
            obj = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            AppMethodBeat.o(98401);
            return obj;
        }
    }

    public static String b(String str) {
        AppMethodBeat.i(98402);
        if (str.equals("java.lang.Integer") || str.equals("int")) {
            str = "int32";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.lang.Boolean") || str.equals(DownloadSetting.TYPE_BOOLEAN)) {
            str = "bool";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.lang.Byte") || str.equals("byte")) {
            str = "char";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.lang.Double") || str.equals("double")) {
            str = "double";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.lang.Float") || str.equals("float")) {
            str = "float";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.lang.Long") || str.equals("long")) {
            str = "int64";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.lang.Short") || str.equals("short")) {
            str = "short";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.lang.Character")) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("can not support java.lang.Character");
            AppMethodBeat.o(98402);
            throw illegalArgumentException;
        } else if (str.equals("java.lang.String")) {
            str = "string";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.util.List")) {
            str = "list";
            AppMethodBeat.o(98402);
            return str;
        } else if (str.equals("java.util.Map")) {
            str = "map";
            AppMethodBeat.o(98402);
            return str;
        } else {
            AppMethodBeat.o(98402);
            return str;
        }
    }

    public static String c(String str) {
        AppMethodBeat.i(98403);
        if (str.equals("int32")) {
            str = "java.lang.Integer";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("bool")) {
            str = "java.lang.Boolean";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("char")) {
            str = "java.lang.Byte";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("double")) {
            str = "java.lang.Double";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("float")) {
            str = "java.lang.Float";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("int64")) {
            str = "java.lang.Long";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("short")) {
            str = "java.lang.Short";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("string")) {
            str = "java.lang.String";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("list")) {
            str = "java.util.List";
            AppMethodBeat.o(98403);
            return str;
        } else if (str.equals("map")) {
            str = "java.util.Map";
            AppMethodBeat.o(98403);
            return str;
        } else {
            AppMethodBeat.o(98403);
            return str;
        }
    }
}
