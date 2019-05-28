package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends b {
    LinearLayout zwx = null;

    public k(final Context context) {
        super(context);
        AppMethodBeat.i(34673);
        this.zwx = new LinearLayout(context);
        this.zwx.setVisibility(8);
        be.ZV().fmc = new be.b() {
            public final void ZZ() {
                AppMethodBeat.i(34672);
                k.this.zwx.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34671);
                        if (k.this.zwx != null) {
                            k.this.zwx.setVisibility(8);
                            k.this.zwx.removeAllViews();
                        }
                        a a = e.a(context, e.a.ABTEST_BANNER, null);
                        if (a == null) {
                            a = e.a(context, e.a.MAIN_FRAME_BANNER, null);
                        }
                        if (!(a == null || a.getView() == null)) {
                            ab.i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", a, a.getView());
                            k.this.zwx.setVisibility(0);
                            k.this.zwx.addView(a.getView(), new LayoutParams(-1, -2));
                        }
                        AppMethodBeat.o(34671);
                    }
                });
                AppMethodBeat.o(34672);
            }
        };
        be.ZV().fmc.ZZ();
        AppMethodBeat.o(34673);
    }

    public final boolean aMN() {
        AppMethodBeat.i(34674);
        if (this.zwx == null || this.zwx.getVisibility() != 0) {
            AppMethodBeat.o(34674);
            return false;
        }
        AppMethodBeat.o(34674);
        return true;
    }

    public final View getView() {
        return this.zwx;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void destroy() {
        AppMethodBeat.i(34675);
        be.ZV().fmc = null;
        AppMethodBeat.o(34675);
    }
}
