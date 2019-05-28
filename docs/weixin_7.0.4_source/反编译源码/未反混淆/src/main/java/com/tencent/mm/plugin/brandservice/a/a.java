package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.af.o;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;

public interface a extends com.tencent.mm.kernel.c.a {
    void a(int i, Context context, String str, String str2, long j, long j2);

    void a(long j, int i, Context context, Activity activity, bi biVar);

    void a(View view, long j, String str, String str2, int i);

    void a(p pVar, q qVar, int i, o oVar, View view, boolean z, int i2, i iVar);

    void a(bi biVar, Activity activity);

    void a(bi biVar, Context context);

    void b(d dVar, Activity activity, ad adVar);

    long cY(View view);
}
