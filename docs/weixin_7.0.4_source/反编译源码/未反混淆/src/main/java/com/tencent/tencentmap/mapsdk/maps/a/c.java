package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class c {
    protected HashMap<String, HashMap<String, byte[]>> a = new HashMap();
    protected HashMap<String, Object> b = new HashMap();
    protected String c = "GBK";
    k d = new k();
    private HashMap<String, Object> e = new HashMap();

    c() {
        AppMethodBeat.i(98605);
        AppMethodBeat.o(98605);
    }

    public void a(String str) {
        this.c = str;
    }

    public <T> void a(String str, T t) {
        AppMethodBeat.i(98606);
        IllegalArgumentException illegalArgumentException;
        if (str == null) {
            illegalArgumentException = new IllegalArgumentException("put key can not is null");
            AppMethodBeat.o(98606);
            throw illegalArgumentException;
        } else if (t == null) {
            illegalArgumentException = new IllegalArgumentException("put value can not is null");
            AppMethodBeat.o(98606);
            throw illegalArgumentException;
        } else if (t instanceof Set) {
            illegalArgumentException = new IllegalArgumentException("can not support Set");
            AppMethodBeat.o(98606);
            throw illegalArgumentException;
        } else {
            l lVar = new l();
            lVar.a(this.c);
            lVar.a((Object) t, 0);
            byte[] a = n.a(lVar.a());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            a(arrayList, (Object) t);
            hashMap.put(a.a(arrayList), a);
            this.e.remove(str);
            this.a.put(str, hashMap);
            AppMethodBeat.o(98606);
        }
    }

    public <T> T a(String str, boolean z, ClassLoader classLoader) {
        String str2 = null;
        AppMethodBeat.i(98607);
        T t;
        if (!this.a.containsKey(str)) {
            AppMethodBeat.o(98607);
            return null;
        } else if (this.e.containsKey(str)) {
            t = this.e.get(str);
            AppMethodBeat.o(98607);
            return t;
        } else {
            byte[] bArr;
            byte[] bArr2 = new byte[0];
            Iterator it = ((HashMap) this.a.get(str)).entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                str2 = (String) entry.getKey();
                bArr = (byte[]) entry.getValue();
            } else {
                bArr = bArr2;
            }
            try {
                Object b = b(str2, z, classLoader);
                this.d.a(bArr);
                this.d.a(this.c);
                t = this.d.a(b, 0, true);
                b(str, t);
                AppMethodBeat.o(98607);
                return t;
            } catch (Exception e) {
                b bVar = new b(e);
                AppMethodBeat.o(98607);
                throw bVar;
            }
        }
    }

    private Object b(String str, boolean z, ClassLoader classLoader) {
        Object obj;
        AppMethodBeat.i(98608);
        if (this.b.containsKey(str)) {
            obj = this.b.get(str);
        } else {
            obj = a.a(str, z, classLoader);
            this.b.put(str, obj);
        }
        AppMethodBeat.o(98608);
        return obj;
    }

    private void b(String str, Object obj) {
        AppMethodBeat.i(98609);
        this.e.put(str, obj);
        AppMethodBeat.o(98609);
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        AppMethodBeat.i(98610);
        Object obj2 = obj;
        while (true) {
            IllegalArgumentException illegalArgumentException;
            if (obj2.getClass().isArray()) {
                if (!obj2.getClass().getComponentType().toString().equals("byte")) {
                    illegalArgumentException = new IllegalArgumentException("only byte[] is supported");
                    AppMethodBeat.o(98610);
                    throw illegalArgumentException;
                } else if (Array.getLength(obj2) > 0) {
                    arrayList.add("java.util.List");
                    obj2 = Array.get(obj2, 0);
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    AppMethodBeat.o(98610);
                    return;
                }
            } else if (obj2 instanceof Array) {
                illegalArgumentException = new IllegalArgumentException("can not support Array, please use List");
                AppMethodBeat.o(98610);
                throw illegalArgumentException;
            } else if (obj2 instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj2;
                if (list.size() > 0) {
                    obj2 = list.get(0);
                } else {
                    arrayList.add("?");
                    AppMethodBeat.o(98610);
                    return;
                }
            } else if (obj2 instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj2;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                } else {
                    arrayList.add("?");
                    arrayList.add("?");
                    AppMethodBeat.o(98610);
                    return;
                }
            } else {
                arrayList.add(obj2.getClass().getName());
                AppMethodBeat.o(98610);
                return;
            }
        }
    }

    public byte[] a() {
        AppMethodBeat.i(98611);
        l lVar = new l(0);
        lVar.a(this.c);
        lVar.a(this.a, 0);
        byte[] a = n.a(lVar.a());
        AppMethodBeat.o(98611);
        return a;
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(98612);
        this.d.a(bArr);
        this.d.a(this.c);
        Map hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.a = this.d.a(hashMap, 0, false);
        AppMethodBeat.o(98612);
    }
}
