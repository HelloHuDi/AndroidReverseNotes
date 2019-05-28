package com.tencent.p177mm.plugin.collect.reward.p366a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.collect.reward.a.a */
public abstract class C33863a extends C1207m implements C1918k {
    protected String aIm;
    protected int errCode = 0;
    protected int errType = 0;
    protected WeakReference<Activity> hxY;
    protected boolean kDr = false;
    protected boolean kDs = false;

    /* renamed from: com.tencent.mm.plugin.collect.reward.a.a$1 */
    class C202681 implements OnClickListener {
        C202681() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.collect.reward.a.a$a */
    public interface C33864a {
        /* renamed from: j */
        void mo6956j(C1207m c1207m);
    }

    /* renamed from: b */
    public abstract void mo6954b(int i, int i2, String str, C1929q c1929q);

    /* Access modifiers changed, original: protected */
    public boolean bgQ() {
        return true;
    }

    /* renamed from: z */
    public final void mo54411z(Activity activity) {
        this.hxY = new WeakReference(activity);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            this.kDr = true;
            if (bgQ() && this.hxY != null) {
                Context context = (Activity) this.hxY.get();
                if (context != null) {
                    C30379h.m48448a(context, context.getString(C25738R.string.fu2), null, false, new C202681());
                }
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.aIm = str;
        mo6954b(i2, i3, str, c1929q);
    }

    /* renamed from: a */
    public final C33863a mo54407a(C33864a c33864a) {
        if (!(this.kDr || this.kDs)) {
            c33864a.mo6956j(this);
        }
        return this;
    }

    /* renamed from: b */
    public final C33863a mo54408b(C33864a c33864a) {
        if (this.kDs) {
            c33864a.mo6956j(this);
        }
        return this;
    }

    /* renamed from: c */
    public final C33863a mo54410c(C33864a c33864a) {
        if (this.kDr) {
            c33864a.mo6956j(this);
        }
        return this;
    }
}
