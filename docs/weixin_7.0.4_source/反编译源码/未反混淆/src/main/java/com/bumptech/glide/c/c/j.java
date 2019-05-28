package com.bumptech.glide.c.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class j implements h {
    private volatile Map<String, String> aEg;
    private final Map<String, List<i>> headers;

    static final class b implements i {
        private final String value;

        b(String str) {
            this.value = str;
        }

        public final String nh() {
            return this.value;
        }

        public final String toString() {
            AppMethodBeat.i(92077);
            String str = "StringHeaderFactory{value='" + this.value + '\'' + '}';
            AppMethodBeat.o(92077);
            return str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(92078);
            if (obj instanceof b) {
                boolean equals = this.value.equals(((b) obj).value);
                AppMethodBeat.o(92078);
                return equals;
            }
            AppMethodBeat.o(92078);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(92079);
            int hashCode = this.value.hashCode();
            AppMethodBeat.o(92079);
            return hashCode;
        }
    }

    public static final class a {
        private static final String aEh;
        private static final Map<String, List<i>> aEi;
        boolean aEj = true;
        private boolean aEk = true;
        Map<String, List<i>> headers = aEi;

        static {
            AppMethodBeat.i(92076);
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
                hashMap.put("User-Agent", Collections.singletonList(new b(aEh)));
            }
            aEi = Collections.unmodifiableMap(hashMap);
            AppMethodBeat.o(92076);
        }
    }

    j(Map<String, List<i>> map) {
        AppMethodBeat.i(92080);
        this.headers = Collections.unmodifiableMap(map);
        AppMethodBeat.o(92080);
    }

    public final Map<String, String> getHeaders() {
        AppMethodBeat.i(92081);
        if (this.aEg == null) {
            synchronized (this) {
                try {
                    if (this.aEg == null) {
                        HashMap hashMap = new HashMap();
                        for (Entry entry : this.headers.entrySet()) {
                            String r = r((List) entry.getValue());
                            if (!TextUtils.isEmpty(r)) {
                                hashMap.put(entry.getKey(), r);
                            }
                        }
                        this.aEg = Collections.unmodifiableMap(hashMap);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(92081);
                }
            }
        }
        Map map = this.aEg;
        AppMethodBeat.o(92081);
        return map;
    }

    private static String r(List<i> list) {
        String nh;
        AppMethodBeat.i(92082);
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            nh = ((i) list.get(i)).nh();
            if (!TextUtils.isEmpty(nh)) {
                stringBuilder.append(nh);
                if (i != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
        }
        nh = stringBuilder.toString();
        AppMethodBeat.o(92082);
        return nh;
    }

    public final String toString() {
        AppMethodBeat.i(92083);
        String str = "LazyHeaders{headers=" + this.headers + '}';
        AppMethodBeat.o(92083);
        return str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92084);
        if (obj instanceof j) {
            boolean equals = this.headers.equals(((j) obj).headers);
            AppMethodBeat.o(92084);
            return equals;
        }
        AppMethodBeat.o(92084);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(92085);
        int hashCode = this.headers.hashCode();
        AppMethodBeat.o(92085);
        return hashCode;
    }
}
