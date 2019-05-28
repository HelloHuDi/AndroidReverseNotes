package com.tencent.mm.wallet_core.c;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class p extends m implements k {
    private static final String AfB = ah.getResources().getString(R.string.fu2);
    protected int AfC = 0;
    protected String AfD;
    protected String aIm;
    private WeakReference<MMActivity> aIq;
    protected b ehh;
    protected f ehi;
    protected int errCode = 0;
    protected int errType = 0;
    protected boolean kDr = true;
    protected boolean kDs = false;

    public interface a<T extends m> {
        void e(int i, int i2, String str, T t);
    }

    public abstract void b(int i, int i2, String str, q qVar);

    public abstract void f(q qVar);

    public final void o(MMActivity mMActivity) {
        this.aIq = new WeakReference(mMActivity);
    }

    public boolean bgR() {
        return false;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            this.kDr = false;
        }
        if (!this.kDr) {
            f(qVar);
            if (this.AfC != 0) {
                this.kDs = true;
            }
        }
        this.errCode = i3;
        this.errType = i2;
        this.aIm = str;
        ab.i("MicroMsg.NetSceneNewPayBase", "errType: %s, errCode: %s, errMsg: %s, retCode: %s, retMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(this.AfC), this.AfD);
        b(i2, i3, str, qVar);
        if (this.aIq != null) {
            final Context context = (MMActivity) this.aIq.get();
            if (context == null) {
                return;
            }
            if (this.kDr) {
                ab.w("MicroMsg.NetSceneNewPayBase", "show net error alert");
                h.a(context, AfB, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(49072);
                        context.finish();
                        AppMethodBeat.o(49072);
                    }
                });
            } else if (this.kDs && !bo.isNullOrNil(this.AfD)) {
                if (bgR()) {
                    ab.w("MicroMsg.NetSceneNewPayBase", "show resp error toast");
                    Toast.makeText(context, this.AfD, 1).show();
                    return;
                }
                ab.w("MicroMsg.NetSceneNewPayBase", "show resp error alert");
                h.a(context, this.AfD, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(49073);
                        context.finish();
                        AppMethodBeat.o(49073);
                    }
                });
            }
        }
    }

    public int a(e eVar, f fVar) {
        this.ehi = fVar;
        Assert.assertNotNull("rr can't be null!", this.ehh);
        return a(eVar, this.ehh, this);
    }

    public final p a(a aVar) {
        if (!(this.kDr || this.kDs)) {
            aVar.e(this.errCode, this.errType, this.aIm, this);
        }
        return this;
    }

    public final p b(a aVar) {
        if (this.kDs) {
            aVar.e(this.errCode, this.errType, this.aIm, this);
        }
        return this;
    }

    public final p c(a aVar) {
        if (this.kDr) {
            aVar.e(this.errCode, this.errType, this.aIm, this);
        }
        return this;
    }
}
