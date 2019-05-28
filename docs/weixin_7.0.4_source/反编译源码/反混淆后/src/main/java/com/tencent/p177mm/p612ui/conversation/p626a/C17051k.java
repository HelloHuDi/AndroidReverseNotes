package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C32776be;
import com.tencent.p177mm.model.C32776be.C32778b;
import com.tencent.p177mm.p612ui.conversation.p626a.C5477e.C5479a;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C35853a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.conversation.a.k */
public final class C17051k extends C14933b {
    LinearLayout zwx = null;

    public C17051k(final Context context) {
        super(context);
        AppMethodBeat.m2504i(34673);
        this.zwx = new LinearLayout(context);
        this.zwx.setVisibility(8);
        C32776be.m53537ZV().fmc = new C32778b() {

            /* renamed from: com.tencent.mm.ui.conversation.a.k$1$1 */
            class C170531 implements Runnable {
                C170531() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(34671);
                    if (C17051k.this.zwx != null) {
                        C17051k.this.zwx.setVisibility(8);
                        C17051k.this.zwx.removeAllViews();
                    }
                    C35853a a = C5477e.m8281a(context, C5479a.ABTEST_BANNER, null);
                    if (a == null) {
                        a = C5477e.m8281a(context, C5479a.MAIN_FRAME_BANNER, null);
                    }
                    if (!(a == null || a.getView() == null)) {
                        C4990ab.m7417i("MicroMsg.MainFrameAndAbtestBanner", "summerinit MainFrameBannerStorage onNotify banner[%s], view[%s]", a, a.getView());
                        C17051k.this.zwx.setVisibility(0);
                        C17051k.this.zwx.addView(a.getView(), new LayoutParams(-1, -2));
                    }
                    AppMethodBeat.m2505o(34671);
                }
            }

            /* renamed from: ZZ */
            public final void mo31111ZZ() {
                AppMethodBeat.m2504i(34672);
                C17051k.this.zwx.post(new C170531());
                AppMethodBeat.m2505o(34672);
            }
        };
        C32776be.m53537ZV().fmc.mo31111ZZ();
        AppMethodBeat.m2505o(34673);
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(34674);
        if (this.zwx == null || this.zwx.getVisibility() != 0) {
            AppMethodBeat.m2505o(34674);
            return false;
        }
        AppMethodBeat.m2505o(34674);
        return true;
    }

    public final View getView() {
        return this.zwx;
    }

    public final int getLayoutId() {
        return -1;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(34675);
        C32776be.m53537ZV().fmc = null;
        AppMethodBeat.m2505o(34675);
    }
}
