package com.tencent.p177mm.pluginsdk.p597ui.p1083b;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.pluginsdk.ui.b.b */
public abstract class C14933b implements C35853a {
    public boolean eVH = false;
    public boolean nfA = false;
    public View view = null;
    public WeakReference<Context> vlu = null;

    public abstract void destroy();

    public abstract int getLayoutId();

    public C14933b(Context context) {
        this.vlu = new WeakReference(context);
        if (getLayoutId() > 0) {
            this.view = View.inflate((Context) this.vlu.get(), getLayoutId(), null);
        }
    }

    public void setVisibility(int i) {
        if (getView() != null) {
            getView().setVisibility(i);
        }
    }

    public View getView() {
        return this.view;
    }

    public boolean aMN() {
        return this.view != null && this.view.getVisibility() == 0;
    }

    public void release() {
    }

    public int getOrder() {
        return 0;
    }
}
