package com.tencent.youtu.ytcommon.tools.wejson;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeJson {
    private static final String EMPTY_ARR = "[]";
    private static final String EMPTY_MAP = "{}";

    public <T> String toJson(T t) {
        AppMethodBeat.i(118119);
        String toJson = toJson(t, 0);
        AppMethodBeat.o(118119);
        return toJson;
    }

    public <T> String toJson(T t, int i) {
        AppMethodBeat.i(118120);
        if (t == null) {
            AppMethodBeat.o(118120);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        process(stringBuilder, t);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(118120);
        return stringBuilder2;
    }

    private <T> void process(StringBuilder stringBuilder, T t) {
        AppMethodBeat.i(118121);
        if (t.getClass().isPrimitive()) {
            stringBuilder.append(t);
            AppMethodBeat.o(118121);
        } else if (t instanceof String) {
            stringBuilder.append('\"').append(getValidStr((String) t)).append('\"');
            AppMethodBeat.o(118121);
        } else if (isPrimitivePackageType(t)) {
            stringBuilder.append(t);
            AppMethodBeat.o(118121);
        } else if (t.getClass().isArray()) {
            processArr(stringBuilder, (Object[]) t);
            AppMethodBeat.o(118121);
        } else if (t instanceof Iterable) {
            processIterable(stringBuilder, (Iterable) t);
            AppMethodBeat.o(118121);
        } else if (t instanceof Map) {
            processMap(stringBuilder, (Map) t);
            AppMethodBeat.o(118121);
        } else {
            processObj(stringBuilder, t);
            AppMethodBeat.o(118121);
        }
    }

    private String getValidStr(String str) {
        AppMethodBeat.i(118122);
        String replace = str.replace("\"", "\\\"").replace("\\", "\\\\").replace("\b", "\\b").replace(IOUtils.LINE_SEPARATOR_UNIX, "\\n").replace("\r", "\\r").replace("\f", "\\f").replace("\t", "\\t");
        AppMethodBeat.o(118122);
        return replace;
    }

    private <T> boolean isPrimitivePackageType(T t) {
        return (t instanceof Integer) || (t instanceof Short) || (t instanceof Long) || (t instanceof Byte) || (t instanceof Boolean) || (t instanceof Float) || (t instanceof Double) || (t instanceof Character);
    }

    private void processMap(StringBuilder stringBuilder, Map<String, Object> map) {
        AppMethodBeat.i(118123);
        if (map.size() == 0) {
            stringBuilder.append(EMPTY_MAP);
            AppMethodBeat.o(118123);
            return;
        }
        stringBuilder.append('{');
        int size = map.size();
        int i = 0;
        for (Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            String str = (String) entry.getKey();
            if (!(str == null || str.equals("") || value == null)) {
                if (!(value instanceof String) || !entry.equals("")) {
                    stringBuilder.append('\"').append(str).append('\"');
                    stringBuilder.append(':');
                    process(stringBuilder, value);
                    if (i < size - 1) {
                        stringBuilder.append(',');
                    }
                    i++;
                }
            }
        }
        stringBuilder.append('}');
        AppMethodBeat.o(118123);
    }

    private <T> void processObj(StringBuilder stringBuilder, T t) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(118124);
        Field[] declaredFields = t.getClass().getDeclaredFields();
        Field[] declaredFields2 = t.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldArr = new Field[(declaredFields.length + declaredFields2.length)];
        for (i = 0; i < declaredFields.length; i++) {
            fieldArr[i] = declaredFields[i];
        }
        for (i = declaredFields.length; i < fieldArr.length; i++) {
            fieldArr[i] = declaredFields2[i - declaredFields.length];
        }
        if (fieldArr.length == 0) {
            stringBuilder.append(EMPTY_MAP);
            AppMethodBeat.o(118124);
            return;
        }
        HashMap hashMap = new HashMap();
        i = 0;
        while (i < fieldArr.length) {
            try {
                Field field = fieldArr[i];
                int modifiers = field.getModifiers();
                if ((modifiers & 8) == 0) {
                    String name = field.getName();
                    if (!name.contains("$")) {
                        Object obj;
                        if ((modifiers & 1) != 0) {
                            obj = field.get(t);
                            if (obj != null) {
                                hashMap.put(name, obj);
                            }
                        } else {
                            String str;
                            Class cls = t.getClass();
                            StringBuilder append = new StringBuilder("get").append(name.substring(0, 1).toUpperCase());
                            if (name.length() == 1) {
                                str = "";
                            } else {
                                str = name.substring(1);
                            }
                            Method method = cls.getMethod(append.append(str).toString(), new Class[0]);
                            if (method != null) {
                                obj = method.invoke(t, new Object[0]);
                                if (obj != null) {
                                    hashMap.put(name, obj);
                                }
                            }
                        }
                    }
                }
                i++;
            } catch (Exception e) {
            }
        }
        stringBuilder.append('{');
        int size = hashMap.size();
        for (Entry entry : hashMap.entrySet()) {
            int i3 = i2 + 1;
            String str2 = (String) entry.getKey();
            Object value = entry.getValue();
            if ((value instanceof String) && value.equals("")) {
                i2 = i3;
            } else {
                stringBuilder.append('\"').append(str2).append('\"').append(':');
                process(stringBuilder, value);
                if (i3 < size) {
                    stringBuilder.append(',');
                }
                i2 = i3;
            }
        }
        stringBuilder.append('}');
        AppMethodBeat.o(118124);
    }

    private void processIterable(StringBuilder stringBuilder, Iterable iterable) {
        AppMethodBeat.i(118125);
        stringBuilder.append('[');
        int i = 0;
        for (Object process : iterable) {
            i++;
            process(stringBuilder, process);
            stringBuilder.append(',');
        }
        if (i > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        stringBuilder.append(']');
        AppMethodBeat.o(118125);
    }

    private <T> void processArr(StringBuilder stringBuilder, Object[] objArr) {
        AppMethodBeat.i(118126);
        if (objArr.length == 0) {
            stringBuilder.append(EMPTY_ARR);
            AppMethodBeat.o(118126);
            return;
        }
        stringBuilder.append('[');
        for (int i = 0; i < objArr.length; i++) {
            process(stringBuilder, objArr[i]);
            if (i < objArr.length - 1) {
                stringBuilder.append(',');
            }
        }
        stringBuilder.append(']');
        AppMethodBeat.o(118126);
    }

    public <T> T fromJson(String str, Class<T> cls) {
        WeJsonException weJsonException;
        T t = null;
        AppMethodBeat.i(118127);
        WeJsonException weJsonException2;
        if (str == null) {
            AppMethodBeat.o(118127);
        } else if (cls == null) {
            weJsonException2 = new WeJsonException("必须指定classOfT");
            AppMethodBeat.o(118127);
            throw weJsonException2;
        } else {
            String trim = str.trim();
            if (trim.startsWith("[")) {
                try {
                    t = fromJsonArr(new JSONArray(trim), cls, null);
                    if (t != null) {
                        AppMethodBeat.o(118127);
                    }
                } catch (Exception e) {
                    weJsonException = new WeJsonException("json 解析错误" + e.getMessage(), e);
                    AppMethodBeat.o(118127);
                    throw weJsonException;
                }
            } else if (trim.startsWith("{")) {
                try {
                    t = fromJsonObj(new JSONObject(trim), cls, null);
                    AppMethodBeat.o(118127);
                } catch (Exception e2) {
                    weJsonException = new WeJsonException("json 解析错误:" + e2.getMessage(), e2);
                    AppMethodBeat.o(118127);
                    throw weJsonException;
                }
            }
            weJsonException2 = new WeJsonException("classOfT 指定错误");
            AppMethodBeat.o(118127);
            throw weJsonException2;
        }
        return t;
    }

    private <T> T fromJsonArr(JSONArray jSONArray, Class<T> cls, Class<?> cls2) {
        AppMethodBeat.i(118128);
        if (cls.equals(List.class)) {
            List fromList = fromList(jSONArray, cls, cls2);
            AppMethodBeat.o(118128);
            return fromList;
        } else if (cls.isArray()) {
            T fromArr = fromArr(jSONArray, cls);
            AppMethodBeat.o(118128);
            return fromArr;
        } else {
            WeJsonException weJsonException = new WeJsonException("json 解析错误:不支持的类型:" + cls.getName());
            AppMethodBeat.o(118128);
            throw weJsonException;
        }
    }

    private <T> T fromJsonObj(JSONObject jSONObject, Class<T> cls, Class<?> cls2) {
        AppMethodBeat.i(118129);
        if (cls.equals(Map.class)) {
            Map fromMap = fromMap(jSONObject, cls, cls2);
            AppMethodBeat.o(118129);
            return fromMap;
        }
        T fromPojo = fromPojo(jSONObject, cls);
        AppMethodBeat.o(118129);
        return fromPojo;
    }

    private List fromList(JSONArray jSONArray, Class<List> cls, Class<?> cls2) {
        AppMethodBeat.i(118130);
        if (cls2 == null) {
            WeJsonException weJsonException = new WeJsonException("无法确定列表项的类型");
            AppMethodBeat.o(118130);
            throw weJsonException;
        }
        List arrayList;
        if (cls.getName().equals("java.util.List")) {
            arrayList = new ArrayList();
        } else {
            try {
                arrayList = (List) cls.newInstance();
            } catch (Exception e) {
                WeJsonException weJsonException2 = new WeJsonException("创建List类型失败,该列表不支持无参实例化", e);
                AppMethodBeat.o(118130);
                throw weJsonException2;
            }
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < jSONArray.length()) {
                Object object = getObject(jSONArray, i2);
                if (object instanceof JSONArray) {
                    arrayList.add(fromJsonArr((JSONArray) object, cls, cls2));
                } else if (object instanceof JSONObject) {
                    arrayList.add(fromJsonObj((JSONObject) object, cls, cls2));
                } else {
                    arrayList.add(object);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(118130);
                return arrayList;
            }
        }
    }

    private Map fromMap(JSONObject jSONObject, Class<Map> cls, Class<?> cls2) {
        AppMethodBeat.i(118131);
        if (cls2 == null) {
            WeJsonException weJsonException = new WeJsonException("无法确定列表项的类型");
            AppMethodBeat.o(118131);
            throw weJsonException;
        }
        Map hashMap;
        if (cls.getName().equals("java.util.Map")) {
            hashMap = new HashMap();
        } else {
            try {
                hashMap = (Map) cls.newInstance();
            } catch (Exception e) {
                WeJsonException weJsonException2 = new WeJsonException("创建Map类型失败,该Map不支持无参实例化", e);
                AppMethodBeat.o(118131);
                throw weJsonException2;
            }
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object object = getObject(jSONObject, str);
            if (object != null) {
                hashMap.put(str, fromJsonData(object, cls, cls2));
            } else {
                hashMap.put(str, null);
            }
        }
        AppMethodBeat.o(118131);
        return hashMap;
    }

    private Object getObject(JSONArray jSONArray, int i) {
        AppMethodBeat.i(118132);
        try {
            Object obj = jSONArray.get(i);
            AppMethodBeat.o(118132);
            return obj;
        } catch (JSONException e) {
            WeJsonException weJsonException = new WeJsonException("JSONArray.get() cause JSONException", e);
            AppMethodBeat.o(118132);
            throw weJsonException;
        }
    }

    private Object getObject(JSONObject jSONObject, String str) {
        AppMethodBeat.i(118133);
        try {
            Object obj = jSONObject.get(str);
            AppMethodBeat.o(118133);
            return obj;
        } catch (JSONException e) {
            WeJsonException weJsonException = new WeJsonException("JSONObject.get() cause JSONException", e);
            AppMethodBeat.o(118133);
            throw weJsonException;
        }
    }

    private Object fromJsonData(Object obj, Class<?> cls, Class<?> cls2) {
        AppMethodBeat.i(118134);
        if (obj instanceof JSONArray) {
            obj = fromJsonArr((JSONArray) obj, cls, cls2);
            AppMethodBeat.o(118134);
            return obj;
        } else if (obj instanceof JSONObject) {
            obj = fromJsonObj((JSONObject) obj, cls, cls2);
            AppMethodBeat.o(118134);
            return obj;
        } else {
            AppMethodBeat.o(118134);
            return obj;
        }
    }

    private <T> T fromArr(JSONArray jSONArray, Class<T> cls) {
        AppMethodBeat.i(118135);
        Class componentType = cls.getComponentType();
        Object newInstance = Array.newInstance(componentType, jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            Array.set(newInstance, i, fromJsonData(getObject(jSONArray, i), componentType, componentType));
        }
        AppMethodBeat.o(118135);
        return newInstance;
    }

    private <T> T fromPojo(JSONObject jSONObject, Class<T> cls) {
        int i;
        WeJsonException weJsonException;
        AppMethodBeat.i(118136);
        Field[] declaredFields = cls.getDeclaredFields();
        Class superclass = cls.getSuperclass();
        Field[] fieldArr = new Field[0];
        if (superclass != null) {
            fieldArr = superclass.getDeclaredFields();
        }
        Field[] fieldArr2 = new Field[(declaredFields.length + fieldArr.length)];
        for (i = 0; i < declaredFields.length; i++) {
            fieldArr2[i] = declaredFields[i];
        }
        for (i = declaredFields.length; i < fieldArr2.length; i++) {
            fieldArr2[i] = fieldArr[i - declaredFields.length];
        }
        if (fieldArr2.length == 0) {
            AppMethodBeat.o(118136);
            return null;
        }
        try {
            T newInstance = cls.newInstance();
            for (Field field : fieldArr2) {
                String name = field.getName();
                if (!name.contains("$")) {
                    int modifiers = field.getModifiers();
                    Object opt = jSONObject.opt(name);
                    if (opt != null) {
                        Object obj;
                        opt = fromJsonData(opt, getMemberType(cls, field), getSubType(cls, field, opt));
                        if (JSONObject.NULL.equals(opt)) {
                            obj = null;
                        } else {
                            obj = opt;
                        }
                        if ((modifiers & 1) != 0) {
                            try {
                                field.set(newInstance, obj);
                            } catch (IllegalAccessException e) {
                                weJsonException = new WeJsonException("设置成员变量值失败.", e);
                                AppMethodBeat.o(118136);
                                throw weJsonException;
                            }
                        }
                        try {
                            try {
                                cls.getMethod("set" + name.substring(0, 1).toUpperCase() + (name.length() == 1 ? "" : name.substring(1)), new Class[]{field.getType()}).invoke(newInstance, new Object[]{obj});
                            } catch (Exception e2) {
                                weJsonException = new WeJsonException("调用set方法失败.", e2);
                                AppMethodBeat.o(118136);
                                throw weJsonException;
                            }
                        } catch (NoSuchMethodException e3) {
                        }
                    }
                }
            }
            AppMethodBeat.o(118136);
            return newInstance;
        } catch (Exception e22) {
            weJsonException = new WeJsonException("必须为该类型提供一个无参构造方法:" + cls.getName(), e22);
            AppMethodBeat.o(118136);
            throw weJsonException;
        }
    }

    private <T> Class<?> getMemberType(Class<T> cls, Field field) {
        AppMethodBeat.i(118137);
        if (field.getGenericType() instanceof TypeVariable) {
            cls.getTypeParameters();
            Type genericSuperclass = cls.getGenericSuperclass();
            WeJsonException weJsonException;
            if (genericSuperclass instanceof ParameterizedType) {
                genericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                if (genericSuperclass instanceof Class) {
                    Class cls2 = (Class) genericSuperclass;
                    AppMethodBeat.o(118137);
                    return cls2;
                }
                weJsonException = new WeJsonException("不支持嵌套泛型");
                AppMethodBeat.o(118137);
                throw weJsonException;
            }
            weJsonException = new WeJsonException("缺少泛型信息:".concat(String.valueOf(cls)));
            AppMethodBeat.o(118137);
            throw weJsonException;
        }
        Class<?> type = field.getType();
        AppMethodBeat.o(118137);
        return type;
    }

    private <T> Class<?> getSubType(Class<T> cls, Field field, Object obj) {
        AppMethodBeat.i(118138);
        Type genericSuperclass;
        WeJsonException weJsonException;
        Class<?> cls2;
        if (field.getGenericType() instanceof TypeVariable) {
            cls.getTypeParameters();
            genericSuperclass = cls.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                genericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                if (genericSuperclass instanceof Class) {
                    Class cls3 = (Class) genericSuperclass;
                    AppMethodBeat.o(118138);
                    return cls3;
                }
                weJsonException = new WeJsonException("不支持嵌套泛型");
                AppMethodBeat.o(118138);
                throw weJsonException;
            }
            weJsonException = new WeJsonException("缺少泛型信息:".concat(String.valueOf(cls)));
            AppMethodBeat.o(118138);
            throw weJsonException;
        } else if (field.getType().equals(List.class)) {
            genericSuperclass = field.getGenericType();
            if (genericSuperclass instanceof ParameterizedType) {
                genericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                if (genericSuperclass instanceof Class) {
                    cls2 = (Class) genericSuperclass;
                    AppMethodBeat.o(118138);
                    return cls2;
                }
                weJsonException = new WeJsonException("不支持嵌套泛型:" + field.getName());
                AppMethodBeat.o(118138);
                throw weJsonException;
            }
            weJsonException = new WeJsonException("缺少泛型类型声明:" + field.getName());
            AppMethodBeat.o(118138);
            throw weJsonException;
        } else if (field.getType().equals(Map.class)) {
            genericSuperclass = field.getGenericType();
            if (genericSuperclass instanceof ParameterizedType) {
                genericSuperclass = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
                if (genericSuperclass instanceof Class) {
                    cls2 = (Class) genericSuperclass;
                    AppMethodBeat.o(118138);
                    return cls2;
                }
                weJsonException = new WeJsonException("不支持嵌套泛型:" + field.getName());
                AppMethodBeat.o(118138);
                throw weJsonException;
            }
            weJsonException = new WeJsonException("缺少泛型类型声明:" + field.getName());
            AppMethodBeat.o(118138);
            throw weJsonException;
        } else {
            cls2 = field.getType();
            AppMethodBeat.o(118138);
            return cls2;
        }
    }
}
