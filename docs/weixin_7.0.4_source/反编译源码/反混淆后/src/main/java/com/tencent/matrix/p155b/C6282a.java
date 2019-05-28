package com.tencent.matrix.p155b;

import android.content.Context;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p157d.C1070c;

/* renamed from: com.tencent.matrix.b.a */
public class C6282a implements C1061c {
    private final Context context;

    public C6282a(Context context) {
        this.context = context;
    }

    /* renamed from: b */
    public final void mo4194b(C6283b c6283b) {
        C1070c.m2368i("Matrix.DefaultPluginListener", "%s plugin is inited", c6283b.getTag());
    }

    /* renamed from: c */
    public final void mo4195c(C6283b c6283b) {
        C1070c.m2368i("Matrix.DefaultPluginListener", "%s plugin is started", c6283b.getTag());
    }

    /* renamed from: d */
    public final void mo4196d(C6283b c6283b) {
        C1070c.m2368i("Matrix.DefaultPluginListener", "%s plugin is stopped", c6283b.getTag());
    }

    /* renamed from: e */
    public final void mo4197e(C6283b c6283b) {
        C1070c.m2368i("Matrix.DefaultPluginListener", "%s plugin is destroyed", c6283b.getTag());
    }

    /* renamed from: a */
    public void mo4193a(C1062b c1062b) {
        C1070c.m2368i("Matrix.DefaultPluginListener", "report issue content: %s", c1062b);
    }
}
