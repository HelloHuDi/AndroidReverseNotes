package com.tencent.p177mm.wallet_core.p649c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.wallet_core.c.p */
public abstract class C44428p extends C1207m implements C1918k {
    private static final String AfB = C4996ah.getResources().getString(C25738R.string.fu2);
    protected int AfC = 0;
    protected String AfD;
    protected String aIm;
    private WeakReference<MMActivity> aIq;
    protected C7472b ehh;
    protected C1202f ehi;
    protected int errCode = 0;
    protected int errType = 0;
    protected boolean kDr = true;
    protected boolean kDs = false;

    /* renamed from: com.tencent.mm.wallet_core.c.p$a */
    public interface C40929a<T extends C1207m> {
        /* renamed from: e */
        void mo7656e(int i, int i2, String str, T t);
    }

    /* renamed from: b */
    public abstract void mo6948b(int i, int i2, String str, C1929q c1929q);

    /* renamed from: f */
    public abstract void mo6949f(C1929q c1929q);

    /* renamed from: o */
    public final void mo70321o(MMActivity mMActivity) {
        this.aIq = new WeakReference(mMActivity);
    }

    public boolean bgR() {
        return false;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            this.kDr = false;
        }
        if (!this.kDr) {
            mo6949f(c1929q);
            if (this.AfC != 0) {
                this.kDs = true;
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.aIm = str;
        C4990ab.m7417i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.AfC), this.AfD);
        mo6948b(i2, i3, str, c1929q);
        if (this.aIq != null) {
            final Context context = (MMActivity) this.aIq.get();
            if (context == null) {
                return;
            }
            if (this.kDr) {
                C4990ab.m7420w("MicroMsg.NetSceneNewPayBase", "show net error alert");
                C30379h.m48448a(context, AfB, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(49072);
                        context.finish();
                        AppMethodBeat.m2505o(49072);
                    }
                });
            } else if (this.kDs && !C5046bo.isNullOrNil(this.AfD)) {
                if (bgR()) {
                    C4990ab.m7420w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
                    Toast.makeText(context, this.AfD, 1).show();
                    return;
                }
                C4990ab.m7420w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
                C30379h.m48448a(context, this.AfD, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(49073);
                        context.finish();
                        AppMethodBeat.m2505o(49073);
                    }
                });
            }
        }
    }

    /* renamed from: a */
    public int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.ehi = c1202f;
        Assert.assertNotNull("rr can't be null!", this.ehh);
        return mo4457a(c1902e, this.ehh, this);
    }

    /* renamed from: a */
    public final C44428p mo70318a(C40929a c40929a) {
        if (!(this.kDr || this.kDs)) {
            c40929a.mo7656e(this.errCode, this.errType, this.aIm, this);
        }
        return this;
    }

    /* renamed from: b */
    public final C44428p mo70319b(C40929a c40929a) {
        if (this.kDs) {
            c40929a.mo7656e(this.errCode, this.errType, this.aIm, this);
        }
        return this;
    }

    /* renamed from: c */
    public final C44428p mo70320c(C40929a c40929a) {
        if (this.kDr) {
            c40929a.mo7656e(this.errCode, this.errType, this.aIm, this);
        }
        return this;
    }
}
