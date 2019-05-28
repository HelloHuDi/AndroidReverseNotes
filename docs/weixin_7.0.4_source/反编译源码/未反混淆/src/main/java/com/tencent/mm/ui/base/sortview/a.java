package com.tencent.mm.ui.base.sortview;

import android.content.Context;
import android.view.View;

public abstract class a {
    protected Object data;
    public int type;
    protected boolean yDq;

    public static abstract class b {
        public abstract void a(Context context, a aVar, a aVar2);

        public abstract void a(View view, a aVar);

        public abstract boolean a(Context context, a aVar, Object... objArr);

        public abstract View c(Context context, View view);
    }

    public interface a {
    }

    public abstract void a(Context context, a aVar, Object... objArr);

    public abstract b aVY();

    public abstract a aVZ();

    public a(int i, Object obj) {
        this.type = i;
        this.data = obj;
    }

    public final Object getData() {
        return this.data;
    }

    public final boolean dAG() {
        return this.yDq;
    }
}
