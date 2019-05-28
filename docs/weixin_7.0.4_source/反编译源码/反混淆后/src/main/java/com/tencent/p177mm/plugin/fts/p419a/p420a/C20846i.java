package com.tencent.p177mm.plugin.fts.p419a.p420a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.fts.a.a.i */
public class C20846i {
    private static final AtomicInteger mEo = new AtomicInteger(0);
    public C7306ak handler = null;
    public int hbo = 0;
    /* renamed from: id */
    public final int f4378id = mEo.incrementAndGet();
    public String mEp = null;
    public String mEq = null;
    public int[] mEr = null;
    public int[] mEs = null;
    public int mEt = BaseClientBuilder.API_PRIORITY_OTHER;
    public HashSet<String> mEu = new HashSet();
    public Comparator<C45966l> mEv = null;
    public C28114l mEw = null;
    public String query = null;
    public int scene = -1;
    public String talker = null;

    static {
        AppMethodBeat.m2504i(114271);
        AppMethodBeat.m2505o(114271);
    }

    public C20846i() {
        AppMethodBeat.m2504i(114267);
        AppMethodBeat.m2505o(114267);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(114269);
        if (this == obj) {
            AppMethodBeat.m2505o(114269);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(114269);
            return false;
        } else {
            if (this.f4378id != ((C20846i) obj).f4378id) {
                AppMethodBeat.m2505o(114269);
                return false;
            }
            AppMethodBeat.m2505o(114269);
            return true;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(114270);
        String format = String.format("{id: %d, query: %s}", new Object[]{Integer.valueOf(this.f4378id), this.query});
        AppMethodBeat.m2505o(114270);
        return format;
    }

    /* renamed from: a */
    public static C20846i m32057a(String str, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<C45966l> comparator, C28114l c28114l, C7306ak c7306ak) {
        AppMethodBeat.m2504i(114268);
        C20846i c20846i = new C20846i();
        c20846i.query = str;
        c20846i.mEp = null;
        c20846i.mEr = iArr;
        c20846i.mEs = iArr2;
        c20846i.mEt = i;
        c20846i.mEu = hashSet;
        c20846i.mEv = comparator;
        c20846i.mEw = c28114l;
        c20846i.handler = c7306ak;
        AppMethodBeat.m2505o(114268);
        return c20846i;
    }
}
