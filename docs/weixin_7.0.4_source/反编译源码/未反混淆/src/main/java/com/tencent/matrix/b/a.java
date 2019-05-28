package com.tencent.matrix.b;

import android.content.Context;
import com.tencent.matrix.c.b;
import com.tencent.matrix.d.c;

public class a implements c {
    private final Context context;

    public a(Context context) {
        this.context = context;
    }

    public final void b(b bVar) {
        c.i("Matrix.DefaultPluginListener", "%s plugin is inited", bVar.getTag());
    }

    public final void c(b bVar) {
        c.i("Matrix.DefaultPluginListener", "%s plugin is started", bVar.getTag());
    }

    public final void d(b bVar) {
        c.i("Matrix.DefaultPluginListener", "%s plugin is stopped", bVar.getTag());
    }

    public final void e(b bVar) {
        c.i("Matrix.DefaultPluginListener", "%s plugin is destroyed", bVar.getTag());
    }

    public void a(b bVar) {
        c.i("Matrix.DefaultPluginListener", "report issue content: %s", bVar);
    }
}
