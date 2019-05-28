package com.bumptech.glide.p086c.p088b;

import android.support.p057v4.p065f.C37122k.C8387a;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.p087a.C8511e;
import com.bumptech.glide.p086c.p088b.C31937h.C8525a;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.bumptech.glide.c.b.s */
public final class C25424s<Data, ResourceType, Transcode> {
    private final Class<Data> aBd;
    private final C8387a<List<Throwable>> aBg;
    private final String aBh;
    private final List<? extends C31937h<Data, ResourceType, Transcode>> aCc;

    public C25424s(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<C31937h<Data, ResourceType, Transcode>> list, C8387a<List<Throwable>> c8387a) {
        AppMethodBeat.m2504i(91864);
        this.aBd = cls;
        this.aBg = c8387a;
        this.aCc = (List) C8561i.m15216c(list);
        this.aBh = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
        AppMethodBeat.m2505o(91864);
    }

    /* renamed from: a */
    public final C17526u<Transcode> mo42467a(C8511e<Data> c8511e, C31967j c31967j, int i, int i2, C8525a<ResourceType> c8525a) {
        AppMethodBeat.m2504i(91865);
        List list = (List) C8561i.m15217d(this.aBg.mo6364aA(), "Argument must not be null");
        try {
            C17526u<Transcode> a = m40179a(c8511e, c31967j, i, i2, c8525a, list);
            return a;
        } finally {
            this.aBg.release(list);
            AppMethodBeat.m2505o(91865);
        }
    }

    /* renamed from: a */
    private C17526u<Transcode> m40179a(C8511e<Data> c8511e, C31967j c31967j, int i, int i2, C8525a<ResourceType> c8525a, List<Throwable> list) {
        C17526u<Transcode> a;
        C37169p e;
        AppMethodBeat.m2504i(91866);
        C17526u<Transcode> c17526u = null;
        int size = this.aCc.size();
        int i3 = 0;
        while (i3 < size) {
            C31937h c31937h = (C31937h) this.aCc.get(i3);
            try {
                a = c31937h.aBf.mo18654a(c8525a.mo18627a(c31937h.mo52052a(c8511e, i, i2, c31967j)), c31967j);
            } catch (C37169p e2) {
                list.add(e2);
                a = c17526u;
            }
            if (a != null) {
                break;
            }
            i3++;
            c17526u = a;
        }
        a = c17526u;
        if (a == null) {
            e2 = new C37169p(this.aBh, new ArrayList(list));
            AppMethodBeat.m2505o(91866);
            throw e2;
        }
        AppMethodBeat.m2505o(91866);
        return a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(91867);
        String str = "LoadPath{decodePaths=" + Arrays.toString(this.aCc.toArray()) + '}';
        AppMethodBeat.m2505o(91867);
        return str;
    }
}
