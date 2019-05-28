package com.bumptech.glide.p086c;

import android.support.p057v4.p065f.C6197a;
import com.bumptech.glide.p086c.C17546i.C17545a;
import com.bumptech.glide.p095h.C31974b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.c.j */
public final class C31967j implements C0779h {
    public final C6197a<C17546i<?>, Object> azh = new C31974b();

    public C31967j() {
        AppMethodBeat.m2504i(91687);
        AppMethodBeat.m2505o(91687);
    }

    /* renamed from: a */
    public final void mo52070a(C31967j c31967j) {
        AppMethodBeat.m2504i(91688);
        this.azh.mo828a(c31967j.azh);
        AppMethodBeat.m2505o(91688);
    }

    /* renamed from: a */
    public final <T> T mo52069a(C17546i<T> c17546i) {
        AppMethodBeat.m2504i(91689);
        if (this.azh.containsKey(c17546i)) {
            Object obj = this.azh.get(c17546i);
            AppMethodBeat.m2505o(91689);
            return obj;
        }
        T t = c17546i.aze;
        AppMethodBeat.m2505o(91689);
        return t;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(91690);
        if (obj instanceof C31967j) {
            boolean equals = this.azh.equals(((C31967j) obj).azh);
            AppMethodBeat.m2505o(91690);
            return equals;
        }
        AppMethodBeat.m2505o(91690);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(91691);
        int hashCode = this.azh.hashCode();
        AppMethodBeat.m2505o(91691);
        return hashCode;
    }

    /* renamed from: a */
    public final void mo2242a(MessageDigest messageDigest) {
        AppMethodBeat.m2504i(91692);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.azh.size()) {
                C17546i c17546i = (C17546i) this.azh.keyAt(i2);
                Object valueAt = this.azh.valueAt(i2);
                C17545a c17545a = c17546i.azf;
                if (c17546i.azg == null) {
                    c17546i.azg = c17546i.key.getBytes(C0779h.azc);
                }
                c17545a.mo18655a(c17546i.azg, valueAt, messageDigest);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(91692);
                return;
            }
        }
    }

    public final String toString() {
        AppMethodBeat.m2504i(91693);
        String str = "Options{values=" + this.azh + '}';
        AppMethodBeat.m2505o(91693);
        return str;
    }
}
