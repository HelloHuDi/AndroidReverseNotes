package com.tencent.p177mm.plugin.webview.luggage;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.p146d.C41707f;
import com.tencent.luggage.p147g.C8870e;
import com.tencent.luggage.p147g.C8870e.C6275b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C40240be;
import com.tencent.p177mm.plugin.webview.modeltools.C35618a;

/* renamed from: com.tencent.mm.plugin.webview.luggage.p */
public class C40248p extends C41707f {
    private C35618a uju;

    public C40248p(final Activity activity) {
        super(activity);
        AppMethodBeat.m2504i(6225);
        this.bPl.mo43471B(C40240be.biH());
        this.uju = new C35618a();
        C8870e xk = this.bPq.mo43479xk();
        xk.bRE.add(new C6275b() {
            /* renamed from: b */
            public final boolean mo14504b(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(6224);
                boolean d = C35618a.m58462d(activity, i, i2, intent);
                AppMethodBeat.m2505o(6224);
                return d;
            }
        });
        AppMethodBeat.m2505o(6225);
    }

    public final void onResume() {
        AppMethodBeat.m2504i(6226);
        super.onResume();
        cXh();
        AppMethodBeat.m2505o(6226);
    }

    /* renamed from: xf */
    public final void mo63593xf() {
        AppMethodBeat.m2504i(6228);
        ((C24905d) mo67383xa()).cWD();
        cXh();
        AppMethodBeat.m2505o(6228);
    }

    /* renamed from: xg */
    public final void mo63594xg() {
        AppMethodBeat.m2504i(6229);
        cXh();
        AppMethodBeat.m2505o(6229);
    }

    private void cXh() {
        AppMethodBeat.m2504i(6227);
        if (this.mContext instanceof MMActivity) {
            SwipeBackLayout swipeBackLayout = ((MMActivity) this.mContext).getSwipeBackLayout();
            if (swipeBackLayout != null) {
                if (this.bPq.mo43476xh().size() <= 1) {
                    swipeBackLayout.setEnableGesture(true);
                    AppMethodBeat.m2505o(6227);
                    return;
                }
                swipeBackLayout.setEnableGesture(false);
            }
        }
        AppMethodBeat.m2505o(6227);
    }
}
