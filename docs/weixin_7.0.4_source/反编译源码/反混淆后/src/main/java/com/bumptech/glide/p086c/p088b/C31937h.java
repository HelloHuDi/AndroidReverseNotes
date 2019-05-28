package com.bumptech.glide.p086c.p088b;

import android.support.p057v4.p065f.C37122k.C8387a;
import android.util.Log;
import com.bumptech.glide.p086c.C31967j;
import com.bumptech.glide.p086c.C31968k;
import com.bumptech.glide.p086c.p087a.C8511e;
import com.bumptech.glide.p086c.p092d.p094f.C8553e;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.c.b.h */
public final class C31937h<DataType, ResourceType, Transcode> {
    private final Class<DataType> aBd;
    private final List<? extends C31968k<DataType, ResourceType>> aBe;
    final C8553e<ResourceType, Transcode> aBf;
    private final C8387a<List<Throwable>> aBg;
    private final String aBh;

    /* renamed from: com.bumptech.glide.c.b.h$a */
    interface C8525a<ResourceType> {
        /* renamed from: a */
        C17526u<ResourceType> mo18627a(C17526u<ResourceType> c17526u);
    }

    public C31937h(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends C31968k<DataType, ResourceType>> list, C8553e<ResourceType, Transcode> c8553e, C8387a<List<Throwable>> c8387a) {
        AppMethodBeat.m2504i(91804);
        this.aBd = cls;
        this.aBe = list;
        this.aBf = c8553e;
        this.aBg = c8387a;
        this.aBh = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
        AppMethodBeat.m2505o(91804);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C17526u<ResourceType> mo52052a(C8511e<DataType> c8511e, int i, int i2, C31967j c31967j) {
        AppMethodBeat.m2504i(91805);
        List list = (List) C8561i.m15217d(this.aBg.mo6364aA(), "Argument must not be null");
        try {
            C17526u<ResourceType> a = m51881a(c8511e, i, i2, c31967j, list);
            return a;
        } finally {
            this.aBg.release(list);
            AppMethodBeat.m2505o(91805);
        }
    }

    /* renamed from: a */
    private C17526u<ResourceType> m51881a(C8511e<DataType> c8511e, int i, int i2, C31967j c31967j, List<Throwable> list) {
        AppMethodBeat.m2504i(91806);
        C17526u<ResourceType> c17526u = null;
        int size = this.aBe.size();
        for (int i3 = 0; i3 < size; i3++) {
            C31968k c31968k = (C31968k) this.aBe.get(i3);
            try {
                C17526u<ResourceType> a;
                if (c31968k.mo2235a(c8511e.mo2194mj(), c31967j)) {
                    a = c31968k.mo2234a(c8511e.mo2194mj(), i, i2, c31967j);
                } else {
                    a = c17526u;
                }
                c17526u = a;
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    new StringBuilder("Failed to decode data for ").append(c31968k);
                }
                list.add(e);
            }
            if (c17526u != null) {
                break;
            }
        }
        if (c17526u == null) {
            C37169p c37169p = new C37169p(this.aBh, new ArrayList(list));
            AppMethodBeat.m2505o(91806);
            throw c37169p;
        }
        AppMethodBeat.m2505o(91806);
        return c17526u;
    }

    public final String toString() {
        AppMethodBeat.m2504i(91807);
        String str = "DecodePath{ dataClass=" + this.aBd + ", decoders=" + this.aBe + ", transcoder=" + this.aBf + '}';
        AppMethodBeat.m2505o(91807);
        return str;
    }
}
