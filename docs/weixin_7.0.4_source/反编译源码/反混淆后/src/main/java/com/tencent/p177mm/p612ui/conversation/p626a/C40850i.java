package com.tencent.p177mm.p612ui.conversation.p626a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C20772b;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.ui.conversation.a.i */
public final class C40850i extends C14933b implements C4931a {
    private View jyC = this.view.findViewById(2131824110);
    private View jyD = this.view.findViewById(2131821629);
    private View zwq = this.view.findViewById(2131824113);
    private TextView zwr = ((TextView) this.view.findViewById(2131824112));
    private TextView zws = ((TextView) this.view.findViewById(2131824114));

    /* renamed from: com.tencent.mm.ui.conversation.a.i$1 */
    class C239661 implements OnClickListener {
        C239661() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(34658);
            C4990ab.m7416i("MicroMsg.ForceNotifyBanner", "[onClick]");
            C20772b c20772b = (C20772b) C1720g.m3528K(C20772b.class);
            if (c20772b != null) {
                c20772b.mo36072dS((Context) C40850i.this.vlu.get());
            }
            AppMethodBeat.m2505o(34658);
        }
    }

    public C40850i(Context context) {
        super(context);
        AppMethodBeat.m2504i(34659);
        C4990ab.m7416i("MicroMsg.ForceNotifyBanner", "[initialize]");
        this.view.setOnClickListener(new C239661());
        C20772b c20772b = (C20772b) C1720g.m3528K(C20772b.class);
        if (c20772b != null) {
            c20772b.bxV().mo10116c(this);
        }
        dIY();
        AppMethodBeat.m2505o(34659);
    }

    public final int getLayoutId() {
        return 2130969585;
    }

    public final void destroy() {
        AppMethodBeat.m2504i(34660);
        if (((C20772b) C1720g.m3528K(C20772b.class)) != null) {
            C7563j bxV = ((C20772b) C1720g.m3528K(C20772b.class)).bxV();
            if (bxV != null) {
                bxV.mo10117d(this);
            }
        }
        AppMethodBeat.m2505o(34660);
    }

    private boolean dIY() {
        boolean bxU;
        View view;
        int i = 8;
        AppMethodBeat.m2504i(34661);
        C20772b c20772b = (C20772b) C1720g.m3528K(C20772b.class);
        if (c20772b != null) {
            bxU = c20772b.bxU();
        } else {
            bxU = false;
        }
        boolean hasError = ((C20772b) C1720g.m3528K(C20772b.class)).hasError();
        if (hasError) {
            this.zwq.setVisibility(bxU ? 0 : 8);
            view = this.jyC;
        } else {
            this.zwq.setVisibility(8);
            view = this.jyC;
            if (bxU) {
                i = 0;
            }
        }
        view.setVisibility(i);
        if (!bxU || hasError) {
            AppMethodBeat.m2505o(34661);
            return false;
        }
        AppMethodBeat.m2505o(34661);
        return true;
    }

    public final boolean aMN() {
        AppMethodBeat.m2504i(34662);
        boolean hasError = ((C20772b) C1720g.m3528K(C20772b.class)).hasError();
        if (this.nfA && this.eVH) {
            if (hasError) {
                this.zwq.setBackgroundResource(C25738R.drawable.a3g);
            } else {
                this.jyC.setBackgroundResource(C25738R.drawable.a3h);
            }
        } else if (this.nfA) {
            if (hasError) {
                this.jyD.setBackgroundResource(C25738R.drawable.f7011yh);
                this.zwq.setBackgroundResource(C25738R.drawable.b7t);
                this.zws.setBackgroundResource(C25738R.drawable.a_q);
            } else {
                this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
                this.jyC.setBackgroundResource(C25738R.drawable.b7t);
                this.zwr.setBackgroundResource(C25738R.drawable.a_q);
            }
        } else if (this.eVH) {
            if (hasError) {
                this.jyD.setBackgroundResource(C25738R.drawable.f7011yh);
                this.zwq.setBackgroundResource(C25738R.drawable.a_q);
                this.zws.setBackground(null);
            } else {
                this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
                this.jyC.setBackgroundResource(C25738R.drawable.a_q);
                this.zwr.setBackground(null);
            }
        }
        hasError = super.aMN();
        AppMethodBeat.m2505o(34662);
        return hasError;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(34663);
        dIY();
        AppMethodBeat.m2505o(34663);
    }
}
