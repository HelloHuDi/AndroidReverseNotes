package com.tencent.mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.d.f;
import com.tencent.luggage.g.e;
import com.tencent.luggage.g.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.be;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public class p extends f {
    private a uju;

    public p(final Activity activity) {
        super(activity);
        AppMethodBeat.i(6225);
        this.bPl.B(be.biH());
        this.uju = new a();
        e xk = this.bPq.xk();
        xk.bRE.add(new b() {
            public final boolean b(int i, int i2, Intent intent) {
                AppMethodBeat.i(6224);
                boolean d = a.d(activity, i, i2, intent);
                AppMethodBeat.o(6224);
                return d;
            }
        });
        AppMethodBeat.o(6225);
    }

    public final void onResume() {
        AppMethodBeat.i(6226);
        super.onResume();
        cXh();
        AppMethodBeat.o(6226);
    }

    public final void xf() {
        AppMethodBeat.i(6228);
        ((d) xa()).cWD();
        cXh();
        AppMethodBeat.o(6228);
    }

    public final void xg() {
        AppMethodBeat.i(6229);
        cXh();
        AppMethodBeat.o(6229);
    }

    private void cXh() {
        AppMethodBeat.i(6227);
        if (this.mContext instanceof MMActivity) {
            SwipeBackLayout swipeBackLayout = ((MMActivity) this.mContext).getSwipeBackLayout();
            if (swipeBackLayout != null) {
                if (this.bPq.xh().size() <= 1) {
                    swipeBackLayout.setEnableGesture(true);
                    AppMethodBeat.o(6227);
                    return;
                }
                swipeBackLayout.setEnableGesture(false);
            }
        }
        AppMethodBeat.o(6227);
    }
}
