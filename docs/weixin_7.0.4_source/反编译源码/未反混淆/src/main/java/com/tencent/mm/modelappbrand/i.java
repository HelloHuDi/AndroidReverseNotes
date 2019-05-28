package com.tencent.mm.modelappbrand;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;

public interface i extends com.tencent.mm.kernel.c.a {

    public enum a {
        DECODE_TYPE_DEFAULT,
        DECODE_TYPE_ORIGIN;

        static {
            AppMethodBeat.o(51133);
        }
    }

    public interface b {
        void kQ(int i);
    }

    e a(int i, int i2, a aVar);

    void a(String str, View view);

    boolean a(String str, View view, Bundle bundle);

    boolean a(String str, View view, Bundle bundle, b bVar);

    f abB();

    e cq(int i, int i2);

    View d(Context context, Bundle bundle);

    void d(int i, Bundle bundle);
}
