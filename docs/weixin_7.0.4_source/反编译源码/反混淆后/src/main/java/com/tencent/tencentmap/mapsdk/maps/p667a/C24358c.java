package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.c */
class C24358c {
    /* renamed from: a */
    protected HashMap<String, HashMap<String, byte[]>> f4646a = new HashMap();
    /* renamed from: b */
    protected HashMap<String, Object> f4647b = new HashMap();
    /* renamed from: c */
    protected String f4648c = "GBK";
    /* renamed from: d */
    C31070k f4649d = new C31070k();
    /* renamed from: e */
    private HashMap<String, Object> f4650e = new HashMap();

    C24358c() {
        AppMethodBeat.m2504i(98605);
        AppMethodBeat.m2505o(98605);
    }

    /* renamed from: a */
    public void mo40541a(String str) {
        this.f4648c = str;
    }

    /* renamed from: a */
    public <T> void mo40542a(String str, T t) {
        AppMethodBeat.m2504i(98606);
        IllegalArgumentException illegalArgumentException;
        if (str == null) {
            illegalArgumentException = new IllegalArgumentException("put key can not is null");
            AppMethodBeat.m2505o(98606);
            throw illegalArgumentException;
        } else if (t == null) {
            illegalArgumentException = new IllegalArgumentException("put value can not is null");
            AppMethodBeat.m2505o(98606);
            throw illegalArgumentException;
        } else if (t instanceof Set) {
            illegalArgumentException = new IllegalArgumentException("can not support Set");
            AppMethodBeat.m2505o(98606);
            throw illegalArgumentException;
        } else {
            C24398l c24398l = new C24398l();
            c24398l.mo40662a(this.f4648c);
            c24398l.mo40671a((Object) t, 0);
            byte[] a = C41080n.m71485a(c24398l.mo40663a());
            HashMap hashMap = new HashMap(1);
            ArrayList arrayList = new ArrayList(1);
            m37653a(arrayList, (Object) t);
            hashMap.put(C5852a.m9001a(arrayList), a);
            this.f4650e.remove(str);
            this.f4646a.put(str, hashMap);
            AppMethodBeat.m2505o(98606);
        }
    }

    /* renamed from: a */
    public <T> T mo40540a(String str, boolean z, ClassLoader classLoader) {
        String str2 = null;
        AppMethodBeat.m2504i(98607);
        T t;
        if (!this.f4646a.containsKey(str)) {
            AppMethodBeat.m2505o(98607);
            return null;
        } else if (this.f4650e.containsKey(str)) {
            t = this.f4650e.get(str);
            AppMethodBeat.m2505o(98607);
            return t;
        } else {
            byte[] bArr;
            byte[] bArr2 = new byte[0];
            Iterator it = ((HashMap) this.f4646a.get(str)).entrySet().iterator();
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                str2 = (String) entry.getKey();
                bArr = (byte[]) entry.getValue();
            } else {
                bArr = bArr2;
            }
            try {
                Object b = m37654b(str2, z, classLoader);
                this.f4649d.mo50514a(bArr);
                this.f4649d.mo50504a(this.f4648c);
                t = this.f4649d.mo50507a(b, 0, true);
                m37655b(str, t);
                AppMethodBeat.m2505o(98607);
                return t;
            } catch (Exception e) {
                C5857b c5857b = new C5857b(e);
                AppMethodBeat.m2505o(98607);
                throw c5857b;
            }
        }
    }

    /* renamed from: b */
    private Object m37654b(String str, boolean z, ClassLoader classLoader) {
        Object obj;
        AppMethodBeat.m2504i(98608);
        if (this.f4647b.containsKey(str)) {
            obj = this.f4647b.get(str);
        } else {
            obj = C5852a.m9000a(str, z, classLoader);
            this.f4647b.put(str, obj);
        }
        AppMethodBeat.m2505o(98608);
        return obj;
    }

    /* renamed from: b */
    private void m37655b(String str, Object obj) {
        AppMethodBeat.m2504i(98609);
        this.f4650e.put(str, obj);
        AppMethodBeat.m2505o(98609);
    }

    /* renamed from: a */
    private void m37653a(ArrayList<String> arrayList, Object obj) {
        AppMethodBeat.m2504i(98610);
        Object obj2 = obj;
        while (true) {
            IllegalArgumentException illegalArgumentException;
            if (obj2.getClass().isArray()) {
                if (!obj2.getClass().getComponentType().toString().equals("byte")) {
                    illegalArgumentException = new IllegalArgumentException("only byte[] is supported");
                    AppMethodBeat.m2505o(98610);
                    throw illegalArgumentException;
                } else if (Array.getLength(obj2) > 0) {
                    arrayList.add("java.util.List");
                    obj2 = Array.get(obj2, 0);
                } else {
                    arrayList.add("Array");
                    arrayList.add("?");
                    AppMethodBeat.m2505o(98610);
                    return;
                }
            } else if (obj2 instanceof Array) {
                illegalArgumentException = new IllegalArgumentException("can not support Array, please use List");
                AppMethodBeat.m2505o(98610);
                throw illegalArgumentException;
            } else if (obj2 instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj2;
                if (list.size() > 0) {
                    obj2 = list.get(0);
                } else {
                    arrayList.add("?");
                    AppMethodBeat.m2505o(98610);
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
                    AppMethodBeat.m2505o(98610);
                    return;
                }
            } else {
                arrayList.add(obj2.getClass().getName());
                AppMethodBeat.m2505o(98610);
                return;
            }
        }
    }

    /* renamed from: a */
    public byte[] mo40544a() {
        AppMethodBeat.m2504i(98611);
        C24398l c24398l = new C24398l(0);
        c24398l.mo40662a(this.f4648c);
        c24398l.mo40674a(this.f4646a, 0);
        byte[] a = C41080n.m71485a(c24398l.mo40663a());
        AppMethodBeat.m2505o(98611);
        return a;
    }

    /* renamed from: a */
    public void mo40543a(byte[] bArr) {
        AppMethodBeat.m2504i(98612);
        this.f4649d.mo50514a(bArr);
        this.f4649d.mo50504a(this.f4648c);
        Map hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f4646a = this.f4649d.mo50509a(hashMap, 0, false);
        AppMethodBeat.m2505o(98612);
    }
}
