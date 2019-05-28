package com.eclipsesource.v8.utils;

import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8ArrayBuffer;
import com.eclipsesource.v8.V8Context;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8TypedArray;
import com.eclipsesource.v8.V8Value;
import com.eclipsesource.v8.utils.typedarrays.ArrayBuffer;
import com.eclipsesource.v8.utils.typedarrays.Float32Array;
import com.eclipsesource.v8.utils.typedarrays.Float64Array;
import com.eclipsesource.v8.utils.typedarrays.Int16Array;
import com.eclipsesource.v8.utils.typedarrays.Int32Array;
import com.eclipsesource.v8.utils.typedarrays.Int8Array;
import com.eclipsesource.v8.utils.typedarrays.TypedArray;
import com.eclipsesource.v8.utils.typedarrays.UInt16Array;
import com.eclipsesource.v8.utils.typedarrays.UInt32Array;
import com.eclipsesource.v8.utils.typedarrays.UInt8Array;
import com.eclipsesource.v8.utils.typedarrays.UInt8ClampedArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class V8ObjectUtils {
    private static final TypeAdapter DEFAULT_TYPE_ADAPTER = new DefaultTypeAdapter();
    private static final Object IGNORE = new Object();

    static class ListWrapper {
        private List<? extends Object> list;

        public ListWrapper(List<? extends Object> list) {
            this.list = list;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof ListWrapper) && ((ListWrapper) obj).list == this.list) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            AppMethodBeat.i(75105);
            int identityHashCode = System.identityHashCode(this.list);
            AppMethodBeat.o(75105);
            return identityHashCode;
        }
    }

    static class DefaultTypeAdapter implements TypeAdapter {
        DefaultTypeAdapter() {
        }

        public Object adapt(int i, Object obj) {
            return TypeAdapter.DEFAULT;
        }
    }

    static {
        AppMethodBeat.i(75144);
        AppMethodBeat.o(75144);
    }

    public static Object getValue(Object obj) {
        AppMethodBeat.i(75106);
        Object value = getValue(obj, DEFAULT_TYPE_ADAPTER);
        AppMethodBeat.o(75106);
        return value;
    }

    public static Object getValue(Object obj, TypeAdapter typeAdapter) {
        AppMethodBeat.i(75107);
        V8Map v8Map = new V8Map();
        try {
            if (obj instanceof V8Value) {
                obj = getValue(obj, ((V8Value) obj).getV8Type(), v8Map, typeAdapter);
            } else {
                v8Map.release();
                AppMethodBeat.o(75107);
            }
            return obj;
        } finally {
            v8Map.release();
            AppMethodBeat.o(75107);
        }
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object) {
        AppMethodBeat.i(75108);
        Map toMap = toMap(v8Object, DEFAULT_TYPE_ADAPTER);
        AppMethodBeat.o(75108);
        return toMap;
    }

    public static Map<String, ? super Object> toMap(V8Object v8Object, TypeAdapter typeAdapter) {
        AppMethodBeat.i(75109);
        V8Map v8Map = new V8Map();
        try {
            Map<String, ? super Object> toMap = toMap(v8Object, v8Map, typeAdapter);
            return toMap;
        } finally {
            v8Map.release();
            AppMethodBeat.o(75109);
        }
    }

    public static List<? super Object> toList(V8Array v8Array) {
        AppMethodBeat.i(75110);
        List toList = toList(v8Array, DEFAULT_TYPE_ADAPTER);
        AppMethodBeat.o(75110);
        return toList;
    }

    public static List<? super Object> toList(V8Array v8Array, TypeAdapter typeAdapter) {
        AppMethodBeat.i(75111);
        V8Map v8Map = new V8Map();
        try {
            List<? super Object> toList = toList(v8Array, v8Map, typeAdapter);
            return toList;
        } finally {
            v8Map.release();
            AppMethodBeat.o(75111);
        }
    }

    public static Object getTypedArray(V8Array v8Array, int i, Object obj) {
        AppMethodBeat.i(75112);
        int length = v8Array.length();
        if (i == 1) {
            obj = (int[]) obj;
            if (obj == null || obj.length < length) {
                obj = new int[length];
            }
            v8Array.getIntegers(0, length, obj);
            AppMethodBeat.o(75112);
        } else if (i == 2) {
            obj = (double[]) obj;
            if (obj == null || obj.length < length) {
                obj = new double[length];
            }
            v8Array.getDoubles(0, length, obj);
            AppMethodBeat.o(75112);
        } else if (i == 3) {
            obj = (boolean[]) obj;
            if (obj == null || obj.length < length) {
                obj = new boolean[length];
            }
            v8Array.getBooleans(0, length, obj);
            AppMethodBeat.o(75112);
        } else if (i == 4) {
            obj = (String[]) obj;
            if (obj == null || obj.length < length) {
                obj = new String[length];
            }
            v8Array.getStrings(0, length, obj);
            AppMethodBeat.o(75112);
        } else if (i == 9) {
            obj = (byte[]) obj;
            if (obj == null || obj.length < length) {
                obj = new byte[length];
            }
            v8Array.getBytes(0, length, obj);
            AppMethodBeat.o(75112);
        } else {
            RuntimeException runtimeException = new RuntimeException("Unsupported bulk load type: ".concat(String.valueOf(i)));
            AppMethodBeat.o(75112);
            throw runtimeException;
        }
        return obj;
    }

    public static Object getTypedArray(V8Array v8Array, int i) {
        AppMethodBeat.i(75113);
        int length = v8Array.length();
        Object doubles;
        if (i == 1) {
            int[] integers = v8Array.getIntegers(0, length);
            AppMethodBeat.o(75113);
            return integers;
        } else if (i == 2) {
            doubles = v8Array.getDoubles(0, length);
            AppMethodBeat.o(75113);
            return doubles;
        } else if (i == 3) {
            doubles = v8Array.getBooleans(0, length);
            AppMethodBeat.o(75113);
            return doubles;
        } else if (i == 4) {
            doubles = v8Array.getStrings(0, length);
            AppMethodBeat.o(75113);
            return doubles;
        } else {
            RuntimeException runtimeException = new RuntimeException("Unsupported bulk load type: ".concat(String.valueOf(i)));
            AppMethodBeat.o(75113);
            throw runtimeException;
        }
    }

    public static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map) {
        AppMethodBeat.i(75114);
        Map hashtable = new Hashtable();
        try {
            V8Object twin = toV8Object(v8, (Map) map, hashtable).twin();
            for (V8Value release : hashtable.values()) {
                release.release();
            }
            AppMethodBeat.o(75114);
            return twin;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
            AppMethodBeat.o(75114);
        }
    }

    public static V8Object toV8Object(V8Context v8Context, Map<String, ? extends Object> map) {
        AppMethodBeat.i(75115);
        Map hashtable = new Hashtable();
        try {
            V8Object twin = toV8Object(v8Context, (Map) map, hashtable).twin();
            for (V8Value release : hashtable.values()) {
                release.release();
            }
            AppMethodBeat.o(75115);
            return twin;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
            AppMethodBeat.o(75115);
        }
    }

    public static V8Array toV8Array(V8 v8, List<? extends Object> list) {
        AppMethodBeat.i(75116);
        Map hashtable = new Hashtable();
        try {
            V8Array twin = toV8Array(v8, (List) list, hashtable).twin();
            for (V8Value release : hashtable.values()) {
                release.release();
            }
            AppMethodBeat.o(75116);
            return twin;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
            AppMethodBeat.o(75116);
        }
    }

    public static V8Array toV8Array(V8Context v8Context, List<? extends Object> list) {
        AppMethodBeat.i(75117);
        Map hashtable = new Hashtable();
        try {
            V8Array twin = toV8Array(v8Context, (List) list, hashtable).twin();
            for (V8Value release : hashtable.values()) {
                release.release();
            }
            AppMethodBeat.o(75117);
            return twin;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
            AppMethodBeat.o(75117);
        }
    }

    public static Object getV8Result(V8 v8, Object obj) {
        AppMethodBeat.i(75118);
        if (obj == null) {
            AppMethodBeat.o(75118);
            return null;
        }
        Map hashtable = new Hashtable();
        try {
            Object v8Result = getV8Result(v8, obj, hashtable);
            if (v8Result instanceof V8Object) {
                V8Object twin = ((V8Object) v8Result).twin();
                for (V8Value release : hashtable.values()) {
                    release.release();
                }
                AppMethodBeat.o(75118);
                return twin;
            }
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
            AppMethodBeat.o(75118);
            return v8Result;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release3 : hashtable.values()) {
                release3.release();
            }
            AppMethodBeat.o(75118);
        }
    }

    public static Object getV8Result(V8Context v8Context, Object obj) {
        AppMethodBeat.i(75119);
        if (obj == null) {
            AppMethodBeat.o(75119);
            return null;
        }
        Map hashtable = new Hashtable();
        try {
            Object v8Result = getV8Result(v8Context, obj, hashtable);
            if (v8Result instanceof V8Object) {
                V8Object twin = ((V8Object) v8Result).twin();
                for (V8Value release : hashtable.values()) {
                    release.release();
                }
                AppMethodBeat.o(75119);
                return twin;
            }
            for (V8Value release2 : hashtable.values()) {
                release2.release();
            }
            AppMethodBeat.o(75119);
            return v8Result;
        } catch (Throwable th) {
            Throwable th2 = th;
            for (V8Value release3 : hashtable.values()) {
                release3.release();
            }
            AppMethodBeat.o(75119);
        }
    }

    public static void pushValue(V8 v8, V8Array v8Array, Object obj) {
        AppMethodBeat.i(75120);
        Map hashtable = new Hashtable();
        try {
            pushValue(v8, v8Array, obj, hashtable);
            AppMethodBeat.o(75120);
        } finally {
            for (V8Value release : hashtable.values()) {
                release.release();
            }
            AppMethodBeat.o(75120);
        }
    }

    public static void pushValue(V8Context v8Context, V8Array v8Array, Object obj) {
        AppMethodBeat.i(75121);
        Map hashtable = new Hashtable();
        try {
            pushValue(v8Context, v8Array, obj, hashtable);
            AppMethodBeat.o(75121);
        } finally {
            for (V8Value release : hashtable.values()) {
                release.release();
            }
            AppMethodBeat.o(75121);
        }
    }

    public static Object getValue(V8Array v8Array, int i) {
        AppMethodBeat.i(75122);
        V8Map v8Map = new V8Map();
        Object obj = null;
        try {
            obj = v8Array.get(i);
            Object value = getValue(obj, v8Array.getType(i), v8Map, DEFAULT_TYPE_ADAPTER);
            return value;
        } finally {
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            AppMethodBeat.o(75122);
        }
    }

    public static Object getValue(V8Array v8Array, int i, TypeAdapter typeAdapter) {
        AppMethodBeat.i(75123);
        V8Map v8Map = new V8Map();
        Object obj = null;
        try {
            obj = v8Array.get(i);
            Object value = getValue(obj, v8Array.getType(i), v8Map, typeAdapter);
            return value;
        } finally {
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            AppMethodBeat.o(75123);
        }
    }

    public static Object getValue(V8Object v8Object, String str) {
        AppMethodBeat.i(75124);
        Object value = getValue(v8Object, str, DEFAULT_TYPE_ADAPTER);
        AppMethodBeat.o(75124);
        return value;
    }

    public static Object getValue(V8Object v8Object, String str, TypeAdapter typeAdapter) {
        AppMethodBeat.i(75125);
        V8Map v8Map = new V8Map();
        Object obj = null;
        try {
            obj = v8Object.get(str);
            Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
            return value;
        } finally {
            if (obj instanceof Releasable) {
                ((Releasable) obj).release();
            }
            v8Map.release();
            AppMethodBeat.o(75125);
        }
    }

    private static Map<String, ? super Object> toMap(V8Object v8Object, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        AppMethodBeat.i(75126);
        if (v8Object == null) {
            Map emptyMap = Collections.emptyMap();
            AppMethodBeat.o(75126);
            return emptyMap;
        } else if (v8Map.containsKey(v8Object)) {
            Map<String, ? super Object> map = (Map) v8Map.get(v8Object);
            AppMethodBeat.o(75126);
            return map;
        } else {
            Map<String, ? super Object> v8PropertyMap = new V8PropertyMap();
            v8Map.put((V8Value) v8Object, (Object) v8PropertyMap);
            String[] keys = v8Object.getKeys();
            int length = keys.length;
            int i = 0;
            while (i < length) {
                String str = keys[i];
                try {
                    Object obj = v8Object.get(str);
                    Object value = getValue(obj, v8Object.getType(str), v8Map, typeAdapter);
                    if (value != IGNORE) {
                        v8PropertyMap.put(str, value);
                    }
                    if (obj instanceof Releasable) {
                        ((Releasable) obj).release();
                    }
                    i++;
                } catch (Throwable th) {
                    if (null instanceof Releasable) {
                        ((Releasable) null).release();
                    }
                    AppMethodBeat.o(75126);
                }
            }
            AppMethodBeat.o(75126);
            return v8PropertyMap;
        }
    }

    private static List<? super Object> toList(V8Array v8Array, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        AppMethodBeat.i(75127);
        if (v8Array == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(75127);
            return emptyList;
        } else if (v8Map.containsKey(v8Array)) {
            List<? super Object> list = (List) v8Map.get(v8Array);
            AppMethodBeat.o(75127);
            return list;
        } else {
            List<? super Object> arrayList = new ArrayList();
            v8Map.put((V8Value) v8Array, (Object) arrayList);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < v8Array.length()) {
                    try {
                        Object obj = v8Array.get(i2);
                        Object value = getValue(obj, v8Array.getType(i2), v8Map, typeAdapter);
                        if (value != IGNORE) {
                            arrayList.add(value);
                        }
                        if (obj instanceof Releasable) {
                            ((Releasable) obj).release();
                        }
                        i = i2 + 1;
                    } catch (Throwable th) {
                        if (null instanceof Releasable) {
                            ((Releasable) null).release();
                        }
                        AppMethodBeat.o(75127);
                    }
                } else {
                    AppMethodBeat.o(75127);
                    return arrayList;
                }
            }
        }
    }

    private static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        AppMethodBeat.i(75128);
        if (map2.containsKey(map)) {
            V8Object v8Object = (V8Object) map2.get(map);
            AppMethodBeat.o(75128);
            return v8Object;
        }
        V8Object v8Object2 = new V8Object(v8);
        map2.put(map, v8Object2);
        try {
            for (Entry entry : map.entrySet()) {
                setValue(v8, v8Object2, (String) entry.getKey(), entry.getValue(), (Map) map2);
            }
            AppMethodBeat.o(75128);
            return v8Object2;
        } catch (IllegalStateException e) {
            v8Object2.release();
            AppMethodBeat.o(75128);
            throw e;
        }
    }

    private static V8Object toV8Object(V8Context v8Context, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        AppMethodBeat.i(75129);
        if (map2.containsKey(map)) {
            V8Object v8Object = (V8Object) map2.get(map);
            AppMethodBeat.o(75129);
            return v8Object;
        }
        V8Object newV8Object = v8Context.newV8Object();
        map2.put(map, newV8Object);
        try {
            for (Entry entry : map.entrySet()) {
                setValue(v8Context, newV8Object, (String) entry.getKey(), entry.getValue(), (Map) map2);
            }
            AppMethodBeat.o(75129);
            return newV8Object;
        } catch (IllegalStateException e) {
            newV8Object.release();
            AppMethodBeat.o(75129);
            throw e;
        }
    }

    private static V8Array toV8Array(V8 v8, List<? extends Object> list, Map<Object, V8Value> map) {
        AppMethodBeat.i(75130);
        V8Array v8Array;
        if (map.containsKey(new ListWrapper(list))) {
            v8Array = (V8Array) map.get(new ListWrapper(list));
            AppMethodBeat.o(75130);
            return v8Array;
        }
        v8Array = new V8Array(v8);
        map.put(new ListWrapper(list), v8Array);
        int i = 0;
        while (i < list.size()) {
            try {
                pushValue(v8, v8Array, list.get(i), (Map) map);
                i++;
            } catch (IllegalStateException e) {
                v8Array.release();
                AppMethodBeat.o(75130);
                throw e;
            }
        }
        AppMethodBeat.o(75130);
        return v8Array;
    }

    private static V8Array toV8Array(V8Context v8Context, List<? extends Object> list, Map<Object, V8Value> map) {
        AppMethodBeat.i(75131);
        V8Array v8Array;
        if (map.containsKey(new ListWrapper(list))) {
            v8Array = (V8Array) map.get(new ListWrapper(list));
            AppMethodBeat.o(75131);
            return v8Array;
        }
        v8Array = v8Context.newV8Array();
        map.put(new ListWrapper(list), v8Array);
        int i = 0;
        while (i < list.size()) {
            try {
                pushValue(v8Context, v8Array, list.get(i), (Map) map);
                i++;
            } catch (IllegalStateException e) {
                v8Array.release();
                AppMethodBeat.o(75131);
                throw e;
            }
        }
        AppMethodBeat.o(75131);
        return v8Array;
    }

    private static V8ArrayBuffer toV8ArrayBuffer(V8 v8, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        AppMethodBeat.i(75132);
        V8ArrayBuffer v8ArrayBuffer;
        if (map.containsKey(arrayBuffer)) {
            v8ArrayBuffer = (V8ArrayBuffer) map.get(arrayBuffer);
            AppMethodBeat.o(75132);
            return v8ArrayBuffer;
        }
        v8ArrayBuffer = new V8ArrayBuffer(v8, arrayBuffer.getByteBuffer());
        map.put(arrayBuffer, v8ArrayBuffer);
        AppMethodBeat.o(75132);
        return v8ArrayBuffer;
    }

    private static V8ArrayBuffer toV8ArrayBuffer(V8Context v8Context, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        AppMethodBeat.i(75133);
        V8ArrayBuffer v8ArrayBuffer;
        if (map.containsKey(arrayBuffer)) {
            v8ArrayBuffer = (V8ArrayBuffer) map.get(arrayBuffer);
            AppMethodBeat.o(75133);
            return v8ArrayBuffer;
        }
        v8ArrayBuffer = v8Context.newV8ArrayBuffer(arrayBuffer.getByteBuffer());
        map.put(arrayBuffer, v8ArrayBuffer);
        AppMethodBeat.o(75133);
        return v8ArrayBuffer;
    }

    private static V8TypedArray toV8TypedArray(V8 v8, TypedArray typedArray, Map<Object, V8Value> map) {
        AppMethodBeat.i(75134);
        V8TypedArray v8TypedArray;
        if (map.containsKey(typedArray)) {
            v8TypedArray = (V8TypedArray) map.get(typedArray);
            AppMethodBeat.o(75134);
            return v8TypedArray;
        }
        V8ArrayBuffer v8ArrayBuffer = new V8ArrayBuffer(v8, typedArray.getByteBuffer());
        try {
            v8TypedArray = new V8TypedArray(v8, v8ArrayBuffer, typedArray.getType(), 0, typedArray.length());
            map.put(typedArray, v8TypedArray);
            return v8TypedArray;
        } finally {
            v8ArrayBuffer.release();
            AppMethodBeat.o(75134);
        }
    }

    private static V8TypedArray toV8TypedArray(V8Context v8Context, TypedArray typedArray, Map<Object, V8Value> map) {
        AppMethodBeat.i(75135);
        V8TypedArray v8TypedArray;
        if (map.containsKey(typedArray)) {
            v8TypedArray = (V8TypedArray) map.get(typedArray);
            AppMethodBeat.o(75135);
            return v8TypedArray;
        }
        V8ArrayBuffer newV8ArrayBuffer = v8Context.newV8ArrayBuffer(typedArray.getByteBuffer());
        try {
            v8TypedArray = v8Context.newV8TypedArray(newV8ArrayBuffer, typedArray.getType(), 0, typedArray.length());
            map.put(typedArray, v8TypedArray);
            return v8TypedArray;
        } finally {
            newV8ArrayBuffer.release();
            AppMethodBeat.o(75135);
        }
    }

    private static Object getV8Result(V8 v8, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(75136);
        if (map.containsKey(obj)) {
            obj = map.get(obj);
            AppMethodBeat.o(75136);
            return obj;
        } else if (obj instanceof Map) {
            obj = toV8Object(v8, (Map) obj, (Map) map);
            AppMethodBeat.o(75136);
            return obj;
        } else if (obj instanceof List) {
            obj = toV8Array(v8, (List) obj, (Map) map);
            AppMethodBeat.o(75136);
            return obj;
        } else if (obj instanceof TypedArray) {
            obj = toV8TypedArray(v8, (TypedArray) obj, (Map) map);
            AppMethodBeat.o(75136);
            return obj;
        } else if (obj instanceof ArrayBuffer) {
            obj = toV8ArrayBuffer(v8, (ArrayBuffer) obj, (Map) map);
            AppMethodBeat.o(75136);
            return obj;
        } else {
            AppMethodBeat.o(75136);
            return obj;
        }
    }

    private static Object getV8Result(V8Context v8Context, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(75137);
        if (map.containsKey(obj)) {
            obj = map.get(obj);
            AppMethodBeat.o(75137);
            return obj;
        } else if (obj instanceof Map) {
            obj = toV8Object(v8Context, (Map) obj, (Map) map);
            AppMethodBeat.o(75137);
            return obj;
        } else if (obj instanceof List) {
            obj = toV8Array(v8Context, (List) obj, (Map) map);
            AppMethodBeat.o(75137);
            return obj;
        } else if (obj instanceof TypedArray) {
            obj = toV8TypedArray(v8Context, (TypedArray) obj, (Map) map);
            AppMethodBeat.o(75137);
            return obj;
        } else if (obj instanceof ArrayBuffer) {
            obj = toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, (Map) map);
            AppMethodBeat.o(75137);
            return obj;
        } else {
            AppMethodBeat.o(75137);
            return obj;
        }
    }

    private static void pushValue(V8 v8, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(75138);
        if (obj == null) {
            v8Array.pushUndefined();
            AppMethodBeat.o(75138);
        } else if (obj instanceof Integer) {
            v8Array.push(obj);
            AppMethodBeat.o(75138);
        } else if (obj instanceof Long) {
            v8Array.push(new Double((double) ((Long) obj).longValue()));
            AppMethodBeat.o(75138);
        } else if (obj instanceof Double) {
            v8Array.push(obj);
            AppMethodBeat.o(75138);
        } else if (obj instanceof Float) {
            v8Array.push(obj);
            AppMethodBeat.o(75138);
        } else if (obj instanceof String) {
            v8Array.push((String) obj);
            AppMethodBeat.o(75138);
        } else if (obj instanceof Boolean) {
            v8Array.push(obj);
            AppMethodBeat.o(75138);
        } else if (obj instanceof V8Object) {
            v8Array.push((V8Object) obj);
            AppMethodBeat.o(75138);
        } else if (obj instanceof TypedArray) {
            v8Array.push(toV8TypedArray(v8, (TypedArray) obj, (Map) map));
            AppMethodBeat.o(75138);
        } else if (obj instanceof ArrayBuffer) {
            v8Array.push(toV8ArrayBuffer(v8, (ArrayBuffer) obj, (Map) map));
            AppMethodBeat.o(75138);
        } else if (obj instanceof Map) {
            v8Array.push(toV8Object(v8, (Map) obj, (Map) map));
            AppMethodBeat.o(75138);
        } else if (obj instanceof List) {
            v8Array.push(toV8Array(v8, (List) obj, (Map) map));
            AppMethodBeat.o(75138);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported Object of type: " + obj.getClass());
            AppMethodBeat.o(75138);
            throw illegalStateException;
        }
    }

    private static void pushValue(V8Context v8Context, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(75139);
        if (obj == null) {
            v8Array.pushUndefined();
            AppMethodBeat.o(75139);
        } else if (obj instanceof Integer) {
            v8Array.push(obj);
            AppMethodBeat.o(75139);
        } else if (obj instanceof Long) {
            v8Array.push(new Double((double) ((Long) obj).longValue()));
            AppMethodBeat.o(75139);
        } else if (obj instanceof Double) {
            v8Array.push(obj);
            AppMethodBeat.o(75139);
        } else if (obj instanceof Float) {
            v8Array.push(obj);
            AppMethodBeat.o(75139);
        } else if (obj instanceof String) {
            v8Array.push((String) obj);
            AppMethodBeat.o(75139);
        } else if (obj instanceof Boolean) {
            v8Array.push(obj);
            AppMethodBeat.o(75139);
        } else if (obj instanceof V8Object) {
            v8Array.push((V8Object) obj);
            AppMethodBeat.o(75139);
        } else if (obj instanceof TypedArray) {
            v8Array.push(toV8TypedArray(v8Context, (TypedArray) obj, (Map) map));
            AppMethodBeat.o(75139);
        } else if (obj instanceof ArrayBuffer) {
            v8Array.push(toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, (Map) map));
            AppMethodBeat.o(75139);
        } else if (obj instanceof Map) {
            v8Array.push(toV8Object(v8Context, (Map) obj, (Map) map));
            AppMethodBeat.o(75139);
        } else if (obj instanceof List) {
            v8Array.push(toV8Array(v8Context, (List) obj, (Map) map));
            AppMethodBeat.o(75139);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported Object of type: " + obj.getClass());
            AppMethodBeat.o(75139);
            throw illegalStateException;
        }
    }

    private static void setValue(V8 v8, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(75140);
        if (obj == null) {
            v8Object.addUndefined(str);
            AppMethodBeat.o(75140);
        } else if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
            AppMethodBeat.o(75140);
        } else if (obj instanceof Long) {
            v8Object.add(str, (double) ((Long) obj).longValue());
            AppMethodBeat.o(75140);
        } else if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
            AppMethodBeat.o(75140);
        } else if (obj instanceof Float) {
            v8Object.add(str, (double) ((Float) obj).floatValue());
            AppMethodBeat.o(75140);
        } else if (obj instanceof String) {
            v8Object.add(str, (String) obj);
            AppMethodBeat.o(75140);
        } else if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.o(75140);
        } else if (obj instanceof V8Object) {
            v8Object.add(str, (V8Object) obj);
            AppMethodBeat.o(75140);
        } else if (obj instanceof TypedArray) {
            v8Object.add(str, toV8TypedArray(v8, (TypedArray) obj, (Map) map));
            AppMethodBeat.o(75140);
        } else if (obj instanceof ArrayBuffer) {
            v8Object.add(str, toV8ArrayBuffer(v8, (ArrayBuffer) obj, (Map) map));
            AppMethodBeat.o(75140);
        } else if (obj instanceof Map) {
            v8Object.add(str, toV8Object(v8, (Map) obj, (Map) map));
            AppMethodBeat.o(75140);
        } else if (obj instanceof List) {
            v8Object.add(str, toV8Array(v8, (List) obj, (Map) map));
            AppMethodBeat.o(75140);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported Object of type: " + obj.getClass());
            AppMethodBeat.o(75140);
            throw illegalStateException;
        }
    }

    private static void setValue(V8Context v8Context, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        AppMethodBeat.i(75141);
        if (obj == null) {
            v8Object.addUndefined(str);
            AppMethodBeat.o(75141);
        } else if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
            AppMethodBeat.o(75141);
        } else if (obj instanceof Long) {
            v8Object.add(str, (double) ((Long) obj).longValue());
            AppMethodBeat.o(75141);
        } else if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
            AppMethodBeat.o(75141);
        } else if (obj instanceof Float) {
            v8Object.add(str, (double) ((Float) obj).floatValue());
            AppMethodBeat.o(75141);
        } else if (obj instanceof String) {
            v8Object.add(str, (String) obj);
            AppMethodBeat.o(75141);
        } else if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
            AppMethodBeat.o(75141);
        } else if (obj instanceof V8Object) {
            v8Object.add(str, (V8Object) obj);
            AppMethodBeat.o(75141);
        } else if (obj instanceof TypedArray) {
            v8Object.add(str, toV8TypedArray(v8Context, (TypedArray) obj, (Map) map));
            AppMethodBeat.o(75141);
        } else if (obj instanceof ArrayBuffer) {
            v8Object.add(str, toV8ArrayBuffer(v8Context, (ArrayBuffer) obj, (Map) map));
            AppMethodBeat.o(75141);
        } else if (obj instanceof Map) {
            v8Object.add(str, toV8Object(v8Context, (Map) obj, (Map) map));
            AppMethodBeat.o(75141);
        } else if (obj instanceof List) {
            v8Object.add(str, toV8Array(v8Context, (List) obj, (Map) map));
            AppMethodBeat.o(75141);
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Unsupported Object of type: " + obj.getClass());
            AppMethodBeat.o(75141);
            throw illegalStateException;
        }
    }

    private static Object getValue(Object obj, int i, V8Map<Object> v8Map, TypeAdapter typeAdapter) {
        AppMethodBeat.i(75142);
        Object adapt = typeAdapter.adapt(i, obj);
        if (TypeAdapter.DEFAULT != adapt) {
            AppMethodBeat.o(75142);
            return adapt;
        }
        switch (i) {
            case 0:
                AppMethodBeat.o(75142);
                return null;
            case 1:
            case 2:
            case 3:
            case 4:
                AppMethodBeat.o(75142);
                return obj;
            case 5:
                obj = toList((V8Array) obj, v8Map, typeAdapter);
                AppMethodBeat.o(75142);
                return obj;
            case 6:
                obj = toMap((V8Object) obj, v8Map, typeAdapter);
                AppMethodBeat.o(75142);
                return obj;
            case 7:
                obj = IGNORE;
                AppMethodBeat.o(75142);
                return obj;
            case 8:
                obj = toTypedArray((V8Array) obj);
                AppMethodBeat.o(75142);
                return obj;
            case 10:
                ArrayBuffer arrayBuffer = new ArrayBuffer(((V8ArrayBuffer) obj).getBackingStore());
                AppMethodBeat.o(75142);
                return arrayBuffer;
            case 99:
                obj = V8.getUndefined();
                AppMethodBeat.o(75142);
                return obj;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Cannot convert type " + V8Value.getStringRepresentation(i));
                AppMethodBeat.o(75142);
                throw illegalStateException;
        }
    }

    private static Object toTypedArray(V8Array v8Array) {
        AppMethodBeat.i(75143);
        int type = v8Array.getType();
        ByteBuffer byteBuffer = ((V8TypedArray) v8Array).getByteBuffer();
        Object int32Array;
        switch (type) {
            case 1:
                int32Array = new Int32Array(byteBuffer);
                AppMethodBeat.o(75143);
                return int32Array;
            case 2:
                int32Array = new Float64Array(byteBuffer);
                AppMethodBeat.o(75143);
                return int32Array;
            case 9:
                Int8Array int8Array = new Int8Array(byteBuffer);
                AppMethodBeat.o(75143);
                return int8Array;
            case 11:
                int32Array = new UInt8Array(byteBuffer);
                AppMethodBeat.o(75143);
                return int32Array;
            case 12:
                int32Array = new UInt8ClampedArray(byteBuffer);
                AppMethodBeat.o(75143);
                return int32Array;
            case 13:
                int32Array = new Int16Array(byteBuffer);
                AppMethodBeat.o(75143);
                return int32Array;
            case 14:
                int32Array = new UInt16Array(byteBuffer);
                AppMethodBeat.o(75143);
                return int32Array;
            case 15:
                int32Array = new UInt32Array(byteBuffer);
                AppMethodBeat.o(75143);
                return int32Array;
            case 16:
                int32Array = new Float32Array(byteBuffer);
                AppMethodBeat.o(75143);
                return int32Array;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Known Typed Array type: " + V8Value.getStringRepresentation(type));
                AppMethodBeat.o(75143);
                throw illegalStateException;
        }
    }

    private V8ObjectUtils() {
    }
}
