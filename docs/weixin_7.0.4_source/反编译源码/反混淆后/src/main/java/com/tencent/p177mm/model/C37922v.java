package com.tencent.p177mm.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.model.v */
public class C37922v {
    private static volatile C37922v fla;
    private Map<String, C32801c> flb = new C32799a();

    /* renamed from: com.tencent.mm.model.v$a */
    static class C32799a<K, V> extends ConcurrentHashMap<K, V> {
        private C32799a() {
        }

        /* synthetic */ C32799a(byte b) {
            this();
        }

        public final V get(Object obj) {
            AppMethodBeat.m2504i(115072);
            if (obj == null) {
                AppMethodBeat.m2505o(115072);
                return null;
            }
            V v = super.get(obj);
            AppMethodBeat.m2505o(115072);
            return v;
        }

        public final V put(K k, V v) {
            AppMethodBeat.m2504i(115073);
            V remove;
            if (k == null) {
                AppMethodBeat.m2505o(115073);
                return null;
            } else if (v == null) {
                remove = super.remove(k);
                AppMethodBeat.m2505o(115073);
                return remove;
            } else {
                remove = super.put(k, v);
                AppMethodBeat.m2505o(115073);
                return remove;
            }
        }

        public final V remove(Object obj) {
            AppMethodBeat.m2504i(115074);
            if (obj == null) {
                AppMethodBeat.m2505o(115074);
                return null;
            }
            V remove = super.remove(obj);
            AppMethodBeat.m2505o(115074);
            return remove;
        }

        public final boolean containsValue(Object obj) {
            AppMethodBeat.m2504i(115075);
            if (obj == null) {
                AppMethodBeat.m2505o(115075);
                return false;
            }
            boolean containsValue = super.containsValue(obj);
            AppMethodBeat.m2505o(115075);
            return containsValue;
        }
    }

    /* renamed from: com.tencent.mm.model.v$b */
    public static class C32800b {
        private Map<String, Object> flc = new C32799a();

        public C32800b() {
            AppMethodBeat.m2504i(115076);
            AppMethodBeat.m2505o(115076);
        }

        public final Set<String> getKeySet() {
            AppMethodBeat.m2504i(115077);
            Set keySet = this.flc.keySet();
            AppMethodBeat.m2505o(115077);
            return keySet;
        }

        public final boolean containsKey(String str) {
            AppMethodBeat.m2504i(115078);
            boolean containsKey = this.flc.containsKey(str);
            AppMethodBeat.m2505o(115078);
            return containsKey;
        }

        /* renamed from: j */
        public final C32800b mo53356j(String str, Object obj) {
            AppMethodBeat.m2504i(115079);
            if (!TextUtils.isEmpty(str)) {
                this.flc.put(str, obj);
            }
            AppMethodBeat.m2505o(115079);
            return this;
        }

        /* renamed from: z */
        public final C32800b mo53359z(String str, boolean z) {
            AppMethodBeat.m2504i(115080);
            if (!TextUtils.isEmpty(str)) {
                this.flc.put(str, Boolean.valueOf(z));
            }
            AppMethodBeat.m2505o(115080);
            return this;
        }

        /* renamed from: ae */
        public final C32800b mo53348ae(String str, String str2) {
            AppMethodBeat.m2504i(115081);
            if (!TextUtils.isEmpty(str)) {
                this.flc.put(str, str2);
            }
            AppMethodBeat.m2505o(115081);
            return this;
        }

        /* renamed from: nX */
        public final boolean mo53357nX(String str) {
            boolean booleanValue;
            AppMethodBeat.m2504i(115082);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.flc.get(str);
                if (obj instanceof Boolean) {
                    booleanValue = ((Boolean) obj).booleanValue();
                    AppMethodBeat.m2505o(115082);
                    return booleanValue;
                }
            }
            booleanValue = false;
            AppMethodBeat.m2505o(115082);
            return booleanValue;
        }

        public final Object get(String str) {
            AppMethodBeat.m2504i(115083);
            Object obj = this.flc.get(str);
            AppMethodBeat.m2505o(115083);
            return obj;
        }

        public final int getInt(String str, int i) {
            AppMethodBeat.m2504i(115084);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.flc.get(str);
                if (obj instanceof Integer) {
                    i = ((Integer) obj).intValue();
                }
            }
            AppMethodBeat.m2505o(115084);
            return i;
        }

        public final boolean getBoolean(String str, boolean z) {
            AppMethodBeat.m2504i(115085);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.flc.get(str);
                if (obj instanceof Boolean) {
                    z = ((Boolean) obj).booleanValue();
                }
            }
            AppMethodBeat.m2505o(115085);
            return z;
        }

        public final String getString(String str, String str2) {
            AppMethodBeat.m2504i(115086);
            if (!TextUtils.isEmpty(str)) {
                Object obj = this.flc.get(str);
                if (obj instanceof String) {
                    str2 = (String) obj;
                }
            }
            AppMethodBeat.m2505o(115086);
            return str2;
        }

        public final <T> T get(String str, T t) {
            AppMethodBeat.m2504i(115087);
            T t2 = get(str);
            if (t2 != null) {
                AppMethodBeat.m2505o(115087);
                return t2;
            }
            AppMethodBeat.m2505o(115087);
            return t;
        }

        public final void recycle() {
            AppMethodBeat.m2504i(115088);
            this.flc.clear();
            AppMethodBeat.m2505o(115088);
        }
    }

    /* renamed from: com.tencent.mm.model.v$c */
    static final class C32801c {
        C32800b fld = new C32800b();
        long fle = System.currentTimeMillis();

        C32801c() {
            AppMethodBeat.m2504i(115089);
            AppMethodBeat.m2505o(115089);
        }
    }

    /* renamed from: Zp */
    public static C37922v m64076Zp() {
        AppMethodBeat.m2504i(115090);
        if (fla == null) {
            synchronized (C37922v.class) {
                try {
                    if (fla == null) {
                        fla = new C37922v();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(115090);
                    }
                }
            }
        }
        C37922v c37922v = fla;
        AppMethodBeat.m2505o(115090);
        return c37922v;
    }

    private C37922v() {
        AppMethodBeat.m2504i(115091);
        AppMethodBeat.m2505o(115091);
    }

    /* renamed from: nT */
    private C32801c m64077nT(String str) {
        AppMethodBeat.m2504i(115092);
        C32801c c32801c = new C32801c();
        this.flb.put(str, c32801c);
        AppMethodBeat.m2505o(115092);
        return c32801c;
    }

    /* renamed from: nU */
    public final C32800b mo60673nU(String str) {
        AppMethodBeat.m2504i(115093);
        C32801c c32801c = (C32801c) this.flb.get(str);
        if (c32801c != null) {
            C32800b c32800b = c32801c.fld;
            AppMethodBeat.m2505o(115093);
            return c32800b;
        }
        AppMethodBeat.m2505o(115093);
        return null;
    }

    /* renamed from: y */
    public final C32800b mo60676y(String str, boolean z) {
        AppMethodBeat.m2504i(115094);
        C32801c c32801c = (C32801c) this.flb.get(str);
        if (c32801c == null) {
            if (z) {
                c32801c = m64077nT(str);
            } else {
                AppMethodBeat.m2505o(115094);
                return null;
            }
        }
        C32800b c32800b = c32801c.fld;
        AppMethodBeat.m2505o(115094);
        return c32800b;
    }

    /* renamed from: nV */
    public final C32800b mo60674nV(String str) {
        AppMethodBeat.m2504i(115095);
        C32801c c32801c = (C32801c) this.flb.remove(str);
        if (c32801c != null) {
            C32800b c32800b = c32801c.fld;
            AppMethodBeat.m2505o(115095);
            return c32800b;
        }
        AppMethodBeat.m2505o(115095);
        return null;
    }

    /* renamed from: nW */
    public static String m64078nW(String str) {
        AppMethodBeat.m2504i(115096);
        String str2 = "SessionId@" + str + "#" + System.nanoTime();
        AppMethodBeat.m2505o(115096);
        return str2;
    }

    public String toString() {
        AppMethodBeat.m2504i(115097);
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataCenter \nDataStore size : ").append(this.flb.size());
        LinkedHashSet<Entry> linkedHashSet = new LinkedHashSet(this.flb.entrySet());
        for (Entry entry : linkedHashSet) {
            if (entry != null) {
                C32801c c32801c = (C32801c) entry.getValue();
                if (c32801c != null) {
                    stringBuilder.append("\nDataStore id : ").append((String) entry.getKey());
                    stringBuilder.append(", CT : ").append(c32801c.fle).append("ms");
                    stringBuilder.append(", TTL : ").append((currentTimeMillis - c32801c.fle) / 1000).append("s");
                }
            }
        }
        linkedHashSet.clear();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(115097);
        return stringBuilder2;
    }
}
