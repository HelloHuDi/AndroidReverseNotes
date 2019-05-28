package com.bumptech.glide.p086c.p090c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.c.c.j */
public final class C25431j implements C0762h {
    private volatile Map<String, String> aEg;
    private final Map<String, List<C17536i>> headers;

    /* renamed from: com.bumptech.glide.c.c.j$b */
    static final class C24646b implements C17536i {
        private final String value;

        C24646b(String str) {
            this.value = str;
        }

        /* renamed from: nh */
        public final String mo31962nh() {
            return this.value;
        }

        public final String toString() {
            AppMethodBeat.m2504i(92077);
            String str = "StringHeaderFactory{value='" + this.value + '\'' + '}';
            AppMethodBeat.m2505o(92077);
            return str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(92078);
            if (obj instanceof C24646b) {
                boolean equals = this.value.equals(((C24646b) obj).value);
                AppMethodBeat.m2505o(92078);
                return equals;
            }
            AppMethodBeat.m2505o(92078);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(92079);
            int hashCode = this.value.hashCode();
            AppMethodBeat.m2505o(92079);
            return hashCode;
        }
    }

    /* renamed from: com.bumptech.glide.c.c.j$a */
    public static final class C25432a {
        private static final String aEh;
        private static final Map<String, List<C17536i>> aEi;
        boolean aEj = true;
        private boolean aEk = true;
        Map<String, List<C17536i>> headers = aEi;

        static {
            AppMethodBeat.m2504i(92076);
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder stringBuilder = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt > 31 || charAt == 9) && charAt < 127) {
                        stringBuilder.append(charAt);
                    } else {
                        stringBuilder.append('?');
                    }
                }
                property = stringBuilder.toString();
            }
            aEh = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(aEh)) {
                hashMap.put("User-Agent", Collections.singletonList(new C24646b(aEh)));
            }
            aEi = Collections.unmodifiableMap(hashMap);
            AppMethodBeat.m2505o(92076);
        }
    }

    C25431j(Map<String, List<C17536i>> map) {
        AppMethodBeat.m2504i(92080);
        this.headers = Collections.unmodifiableMap(map);
        AppMethodBeat.m2505o(92080);
    }

    public final Map<String, String> getHeaders() {
        AppMethodBeat.m2504i(92081);
        if (this.aEg == null) {
            synchronized (this) {
                try {
                    if (this.aEg == null) {
                        HashMap hashMap = new HashMap();
                        for (Entry entry : this.headers.entrySet()) {
                            String r = C25431j.m40192r((List) entry.getValue());
                            if (!TextUtils.isEmpty(r)) {
                                hashMap.put(entry.getKey(), r);
                            }
                        }
                        this.aEg = Collections.unmodifiableMap(hashMap);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(92081);
                }
            }
        }
        Map map = this.aEg;
        AppMethodBeat.m2505o(92081);
        return map;
    }

    /* renamed from: r */
    private static String m40192r(List<C17536i> list) {
        String nh;
        AppMethodBeat.m2504i(92082);
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            nh = ((C17536i) list.get(i)).mo31962nh();
            if (!TextUtils.isEmpty(nh)) {
                stringBuilder.append(nh);
                if (i != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
        }
        nh = stringBuilder.toString();
        AppMethodBeat.m2505o(92082);
        return nh;
    }

    public final String toString() {
        AppMethodBeat.m2504i(92083);
        String str = "LazyHeaders{headers=" + this.headers + '}';
        AppMethodBeat.m2505o(92083);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(92084);
        if (obj instanceof C25431j) {
            boolean equals = this.headers.equals(((C25431j) obj).headers);
            AppMethodBeat.m2505o(92084);
            return equals;
        }
        AppMethodBeat.m2505o(92084);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(92085);
        int hashCode = this.headers.hashCode();
        AppMethodBeat.m2505o(92085);
        return hashCode;
    }
}
