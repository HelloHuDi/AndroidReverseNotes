package com.tencent.mm.plugin.collect.reward.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class a extends m implements k {
    protected String aIm;
    protected int errCode = 0;
    protected int errType = 0;
    protected WeakReference<Activity> hxY;
    protected boolean kDr = false;
    protected boolean kDs = false;

    public interface a {
        void j(m mVar);
    }

    public abstract void b(int i, int i2, String str, q qVar);

    /* Access modifiers changed, original: protected */
    public boolean bgQ() {
        return true;
    }

    public final void z(Activity activity) {
        this.hxY = new WeakReference(activity);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            this.kDr = true;
            if (bgQ() && this.hxY != null) {
                Context context = (Activity) this.hxY.get();
                if (context != null) {
                    h.a(context, context.getString(R.string.fu2), null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.aIm = str;
        b(i2, i3, str, qVar);
    }

    public final a a(a aVar) {
        if (!(this.kDr || this.kDs)) {
            aVar.j(this);
        }
        return this;
    }

    public final a b(a aVar) {
        if (this.kDs) {
            aVar.j(this);
        }
        return this;
    }

    public final a c(a aVar) {
        if (this.kDr) {
            aVar.j(this);
        }
        return this;
    }
}
