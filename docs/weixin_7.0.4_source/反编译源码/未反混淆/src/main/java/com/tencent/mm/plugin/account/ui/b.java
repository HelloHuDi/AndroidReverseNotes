package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

public abstract class b extends com.tencent.mm.ui.applet.SecurityImage.b {
    m gAi = null;
    SecurityImage gue = null;

    /* renamed from: com.tencent.mm.plugin.account.ui.b$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ Context gAj;

        AnonymousClass1(Context context) {
            this.gAj = context;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(124716);
            final m a = b.this.a(b.this.gAi, b.this.gue.getSecImgCode());
            g.Rg().a(a, 0);
            Context context = this.gAj;
            this.gAj.getString(R.string.tz);
            h.b(context, this.gAj.getString(R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(124715);
                    g.Rg().c(a);
                    AppMethodBeat.o(124715);
                }
            });
            AppMethodBeat.o(124716);
        }
    }

    public abstract m a(m mVar, String str);

    public final void apw() {
        g.Rg().a(a(this.gAi, ""), 0);
    }
}
