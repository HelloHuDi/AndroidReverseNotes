package com.tencent.p177mm.modelappbrand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p242c.C1694a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37924e;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;

/* renamed from: com.tencent.mm.modelappbrand.i */
public interface C32809i extends C1694a {

    /* renamed from: com.tencent.mm.modelappbrand.i$a */
    public enum C32807a {
        DECODE_TYPE_DEFAULT,
        DECODE_TYPE_ORIGIN;

        static {
            AppMethodBeat.m2505o(51133);
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.i$b */
    public interface C32808b {
        /* renamed from: kQ */
        void mo6398kQ(int i);
    }

    /* renamed from: a */
    C37924e mo22287a(int i, int i2, C32807a c32807a);

    /* renamed from: a */
    void mo22288a(String str, View view);

    /* renamed from: a */
    boolean mo22289a(String str, View view, Bundle bundle);

    /* renamed from: a */
    boolean mo22290a(String str, View view, Bundle bundle, C32808b c32808b);

    C37932f abB();

    /* renamed from: cq */
    C37924e mo22292cq(int i, int i2);

    /* renamed from: d */
    View mo22293d(Context context, Bundle bundle);

    /* renamed from: d */
    void mo22294d(int i, Bundle bundle);
}
