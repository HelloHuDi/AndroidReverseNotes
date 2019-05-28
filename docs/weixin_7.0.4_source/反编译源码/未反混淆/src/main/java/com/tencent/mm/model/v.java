package com.tencent.mm.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class v {
    private static volatile v fla;
    private Map<String, c> flb = new a();

    static class a<K, V> extends ConcurrentHashMap<K, V> {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final V get(Object obj) {
            AppMethodBeat.i(115072);
            if (obj == null) {
                AppMethodBeat.o(115072);
                return null;
            }
            V v = super.get(obj);
            AppMethodBeat.o(115072);
            return v;
        }

        public final V put(K k, V v) {
            AppMethodBeat.i(115073);
            V remove;
            if (k == null) {
                AppMethodBeat.o(115073);
                return null;
            } else if (v == null) {
                remove = super.remove(k);
                AppMethodBeat.o(115073);
                return remove;
            } else {
                remove = super.put(k, v);
                AppMethodBeat.o(115073);
                return remove;
            }
        }

        public final V remove(Object obj) {
            AppMethodBeat.i(115074);
            if (obj == null) {
                AppMethodBeat.o(115074);
                return null;
            }
            V remove = super.remove(obj);
            AppMethodBeat.o(115074);
            return remove;
        }

        public final boolean containsValue(Object obj) {
            AppMethodBeat.i(115075);
            if (obj == null) {
                AppMethodBeat.o(115075);
                return false;
            }
            boolean containsValue = super.containsValue(obj);
            AppMethodBeat.o(115075);
            return containsValue;
        }
    }

    public static class b {
        private Map<String, Object> flc = new a();

        public b() {
            AppMethodBeat.i(115076);
            AppMethodBeat.o(115076);
        }

        public final Set<String> getKeySet() {
            AppMethodBeat.i(115077);
            Set keySet = this.flc.keySet();
            AppMethodBeat.o(115077);
            return keySet;
        }

        public final boolean containsKey(String str) {
            AppMethodBeat.i(115078);
            boolean containsKey = this.flc.containsKey(str);
            AppMethodBeat.o(115078);
            return containsKey;
        }

        public final b j(String str, Object obj) {
            AppMethodBeat.i(115079);
            if (!TextUtils.isEmpty(str)) {
                this.flc.put(str, obj);
            }
            AppMethodBeat.o(115079);
            return this;
        }

        public final b z(String str, boolean z) {
            AppMethodBeat.i(115080);
            if (!TextUtils.isEmpty(str)) {
                this.flc.put(str, Boolean.valueOf(z));
            }
            AppMethodBeat.o(115080);
            return this;
        }

        public final b ae(String str, String str2) {
            AppMethodBeat.i(115081);
            if (!TextUtils.isEmpty(str)) {
                this.flc.put(str, str2);
            }
            AppMethodBeat.o(115081);
            return this;
        }

        public final boolean nX(String str) {
            boolean booleanValue;
            AppMethodBeat.i(115082);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.flc.get(str);
                if (obj instanceof Boolean) {
                    booleanValue = ((Boolean) obj).booleanValue();
                    AppMethodBeat.o(115082);
                    return booleanValue;
                }
            }
            booleanValue = false;
            AppMethodBeat.o(115082);
            return booleanValue;
        }

        public final Object get(String str) {
            AppMethodBeat.i(115083);
            Object obj = this.flc.get(str);
            AppMethodBeat.o(115083);
            return obj;
        }

        public final int getInt(String str, int i) {
            AppMethodBeat.i(115084);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.flc.get(str);
                if (obj instanceof Integer) {
                    i = ((Integer) obj).intValue();
                }
            }
            AppMethodBeat.o(115084);
            return i;
        }

        public final boolean getBoolean(String str, boolean z) {
            AppMethodBeat.i(115085);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.flc.get(str);
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
            }
            AppMethodBeat.o(115085);
            return z;
        }

        public final String getString(String str, String str2) {
            AppMethodBeat.i(115086);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.flc.get(str);
                if (obj instanceof String) {
                    str2 = (String) obj;
                }
            }
            AppMethodBeat.o(115086);
            return str2;
        }

        public final <T> T get(String str, T t) {
            AppMethodBeat.i(115087);
            T t2 = get(str);
            if (t2 != null) {
                AppMethodBeat.o(115087);
                return t2;
            }
            AppMethodBeat.o(115087);
            return t;
        }

        public final void recycle() {
            AppMethodBeat.i(115088);
            this.flc.clear();
            AppMethodBeat.o(115088);
        }
    }

    static final class c {
        b fld = new b();
        long fle = System.currentTimeMillis();

        c() {
            AppMethodBeat.i(115089);
            AppMethodBeat.o(115089);
        }
    }

    public static v Zp() {
        AppMethodBeat.i(115090);
        if (fla == null) {
            synchronized (v.class) {
                try {
                    if (fla == null) {
                        fla = new v();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(115090);
                    }
                }
            }
        }
        v vVar = fla;
        AppMethodBeat.o(115090);
        return vVar;
    }

    private v() {
        AppMethodBeat.i(115091);
        AppMethodBeat.o(115091);
    }

    private c nT(String str) {
        AppMethodBeat.i(115092);
        c cVar = new c();
        this.flb.put(str, cVar);
        AppMethodBeat.o(115092);
        return cVar;
    }

    public final b nU(String str) {
        AppMethodBeat.i(115093);
        c cVar = (c) this.flb.get(str);
        if (cVar != null) {
            b bVar = cVar.fld;
            AppMethodBeat.o(115093);
            return bVar;
        }
        AppMethodBeat.o(115093);
        return null;
    }

    public final b y(String str, boolean z) {
        AppMethodBeat.i(115094);
        c cVar = (c) this.flb.get(str);
        if (cVar == null) {
            if (z) {
                cVar = nT(str);
            } else {
                AppMethodBeat.o(115094);
                return null;
            }
        }
        b bVar = cVar.fld;
        AppMethodBeat.o(115094);
        return bVar;
    }

    public final b nV(String str) {
        AppMethodBeat.i(115095);
        c cVar = (c) this.flb.remove(str);
        if (cVar != null) {
            b bVar = cVar.fld;
            AppMethodBeat.o(115095);
            return bVar;
        }
        AppMethodBeat.o(115095);
        return null;
    }

    public static String nW(String str) {
        AppMethodBeat.i(115096);
        String str2 = "SessionId@" + str + "#" + System.nanoTime();
        AppMethodBeat.o(115096);
        return str2;
    }

    public String toString() {
        AppMethodBeat.i(115097);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataCenter \nDataStore size : ").append(this.flb.size());
        LinkedHashSet<Entry> linkedHashSet = new LinkedHashSet(this.flb.entrySet());
        for (Entry entry : linkedHashSet) {
            if (entry != null) {
                c cVar = (c) entry.getValue();
                if (cVar != null) {
                    stringBuilder.append("\nDataStore id : ").append((String) entry.getKey());
                    stringBuilder.append(", CT : ").append(cVar.fle).append("ms");
                    stringBuilder.append(", TTL : ").append((currentTimeMillis - cVar.fle) / 1000).append("s");
                }
            }
        }
        linkedHashSet.clear();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(115097);
        return stringBuilder2;
    }
}
