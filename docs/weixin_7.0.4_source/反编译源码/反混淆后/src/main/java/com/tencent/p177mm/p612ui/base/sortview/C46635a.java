package com.tencent.p177mm.p612ui.base.sortview;

import android.content.Context;
import android.view.View;

/* renamed from: com.tencent.mm.ui.base.sortview.a */
public abstract class C46635a {
    protected Object data;
    public int type;
    protected boolean yDq;

    /* renamed from: com.tencent.mm.ui.base.sortview.a$b */
    public static abstract class C36082b {
        /* renamed from: a */
        public abstract void mo22879a(Context context, C40676a c40676a, C46635a c46635a);

        /* renamed from: a */
        public abstract void mo22880a(View view, C40676a c40676a);

        /* renamed from: a */
        public abstract boolean mo22881a(Context context, C46635a c46635a, Object... objArr);

        /* renamed from: c */
        public abstract View mo22882c(Context context, View view);
    }

    /* renamed from: com.tencent.mm.ui.base.sortview.a$a */
    public interface C40676a {
    }

    /* renamed from: a */
    public abstract void mo35282a(Context context, C40676a c40676a, Object... objArr);

    public abstract C36082b aVY();

    public abstract C40676a aVZ();

    public C46635a(int i, Object obj) {
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
