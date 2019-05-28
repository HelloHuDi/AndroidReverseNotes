package com.bumptech.glide.p086c;

import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.c.i */
public final class C17546i<T> {
    private static final C17545a<Object> azd = new C85541();
    final T aze;
    final C17545a<T> azf;
    volatile byte[] azg;
    final String key;

    /* renamed from: com.bumptech.glide.c.i$1 */
    class C85541 implements C17545a<Object> {
        C85541() {
        }

        /* renamed from: a */
        public final void mo18655a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* renamed from: com.bumptech.glide.c.i$a */
    public interface C17545a<T> {
        /* renamed from: a */
        void mo18655a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    static {
        AppMethodBeat.m2504i(91686);
        AppMethodBeat.m2505o(91686);
    }

    /* renamed from: Z */
    public static <T> C17546i<T> m27395Z(String str) {
        AppMethodBeat.m2504i(91679);
        C17546i c17546i = new C17546i(str, null, azd);
        AppMethodBeat.m2505o(91679);
        return c17546i;
    }

    /* renamed from: c */
    public static <T> C17546i<T> m27397c(String str, T t) {
        AppMethodBeat.m2504i(91680);
        C17546i c17546i = new C17546i(str, t, azd);
        AppMethodBeat.m2505o(91680);
        return c17546i;
    }

    /* renamed from: a */
    public static <T> C17546i<T> m27396a(String str, T t, C17545a<T> c17545a) {
        AppMethodBeat.m2504i(91681);
        C17546i c17546i = new C17546i(str, t, c17545a);
        AppMethodBeat.m2505o(91681);
        return c17546i;
    }

    private C17546i(String str, T t, C17545a<T> c17545a) {
        AppMethodBeat.m2504i(91682);
        this.key = C8561i.checkNotEmpty(str);
        this.aze = t;
        this.azf = (C17545a) C8561i.m15217d(c17545a, "Argument must not be null");
        AppMethodBeat.m2505o(91682);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(91683);
        if (obj instanceof C17546i) {
            boolean equals = this.key.equals(((C17546i) obj).key);
            AppMethodBeat.m2505o(91683);
            return equals;
        }
        AppMethodBeat.m2505o(91683);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(91684);
        int hashCode = this.key.hashCode();
        AppMethodBeat.m2505o(91684);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.m2504i(91685);
        String str = "Option{key='" + this.key + '\'' + '}';
        AppMethodBeat.m2505o(91685);
        return str;
    }
}
