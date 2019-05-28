package com.tencent.mm.plugin.forcenotify.a;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.e.j;

public interface b extends a, o, s<cm> {
    void Mn(String str);

    long Mo(String str);

    boolean Mp(String str);

    void am(String str, int i);

    boolean bxU();

    j bxV();

    void dS(Context context);

    boolean hasError();

    void hx(boolean z);
}
