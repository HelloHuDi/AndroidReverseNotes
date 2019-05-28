package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

public final class l {
    private c hkR = null;
    public Context mContext;
    public Resources mResources;
    a nNK;

    public interface a {
        void bKd();

        void bKe();

        void xD(int i);
    }

    /* renamed from: com.tencent.mm.plugin.location.ui.l$5 */
    public class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ int bVv;

        public AnonymousClass5(int i) {
            this.bVv = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(113557);
            if (l.this.nNK != null) {
                l.this.nNK.xD(this.bVv);
            }
            AppMethodBeat.o(113557);
        }
    }

    public l(Context context, a aVar) {
        AppMethodBeat.i(113558);
        this.mContext = context;
        this.nNK = aVar;
        this.mResources = this.mContext.getResources();
        AppMethodBeat.o(113558);
    }

    public final void bKc() {
        boolean z;
        AppMethodBeat.i(113559);
        Object obj = g.RP().Ry().get(67590, null);
        if (obj == null) {
            z = false;
        } else {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            if (this.nNK != null) {
                this.nNK.bKd();
            }
            AppMethodBeat.o(113559);
            return;
        }
        h.a(this.mContext, this.mResources.getString(R.string.cnu), "", false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(113554);
                if (l.this.nNK != null) {
                    l.this.nNK.bKd();
                }
                AppMethodBeat.o(113554);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        g.RP().Ry().set(67590, Boolean.TRUE);
        AppMethodBeat.o(113559);
    }
}
