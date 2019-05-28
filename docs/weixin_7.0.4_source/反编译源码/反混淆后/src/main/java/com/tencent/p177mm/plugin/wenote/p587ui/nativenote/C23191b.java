package com.tencent.p177mm.plugin.wenote.p587ui.nativenote;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wenote.model.C14719f;
import com.tencent.p177mm.plugin.wenote.model.C14720g;
import com.tencent.p177mm.plugin.wenote.model.C29981j;
import com.tencent.p177mm.plugin.wenote.model.C46453c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C14738h;
import com.tencent.p177mm.plugin.wenote.model.p585a.C29979q;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.protocal.protobuf.abh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b */
public final class C23191b extends C14933b {
    private TextView gne = null;
    private View jyC;
    private View jyD;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b$1 */
    class C231861 implements OnClickListener {
        C231861() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27112);
            C4990ab.m7416i("WNNoteBanner", "click WNNoteBanner");
            C29979q deI = C14738h.deH().deI();
            if (deI == null) {
                C4990ab.m7416i("WNNoteBanner", "keepTopItem is null");
                C23191b.this.setVisibility(8);
                AppMethodBeat.m2505o(27112);
            } else if (deI.uOr) {
                if (deI.mgQ) {
                    C7060h.pYm.mo8381e(14789, Integer.valueOf(3));
                } else {
                    C7060h.pYm.mo8381e(14789, Integer.valueOf(2));
                }
                C4990ab.m7416i("WNNoteBanner", "isOpenFromSession: true");
                C29981j c29981j = new C29981j();
                C46453c.ddG().uMN = c29981j;
                abh abh = new abh();
                abh.scene = 8;
                c29981j.mo48223a(deI.uOv, Long.valueOf(deI.uOt), true, (Context) C23191b.this.vlu.get(), deI.uOw, deI.uOx, abh);
                AppMethodBeat.m2505o(27112);
            } else {
                C7060h.pYm.mo8381e(14789, Integer.valueOf(1));
                C4990ab.m7416i("WNNoteBanner", "isOpenFromSession: false");
                C14720g c14720g = new C14720g();
                C46453c.ddG().uMN = c14720g;
                abh abh2 = new abh();
                abh2.scene = 8;
                c14720g.mo26986a(deI.uOs, (Context) C23191b.this.vlu.get(), Boolean.TRUE, deI.uOw, deI.uOx, abh2, null);
                AppMethodBeat.m2505o(27112);
            }
        }
    }

    public C23191b(Context context) {
        super(context);
        AppMethodBeat.m2504i(27113);
        if (this.view != null) {
            this.gne = (TextView) this.view.findViewById(2131829219);
            this.jyC = this.view.findViewById(2131829218);
            this.jyD = this.view.findViewById(2131821629);
            this.gne.setTextSize(0, (float) C1338a.m2856al(this.gne.getContext(), C25738R.dimen.f9936kr));
            this.view.setOnClickListener(new C231861());
        }
        AppMethodBeat.m2505o(27113);
    }

    public final int getLayoutId() {
        return 2130971230;
    }

    public final int getOrder() {
        return 0;
    }

    public final void destroy() {
    }

    public final void setVisibility(int i) {
        AppMethodBeat.m2504i(27114);
        if (this.view != null) {
            this.view.findViewById(2131829218).setVisibility(i);
        }
        AppMethodBeat.m2505o(27114);
    }

    public final boolean aMN() {
        boolean z;
        AppMethodBeat.m2504i(27115);
        C29979q deI = C14738h.deH().deI();
        if (this.nfA && this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.a3h);
            this.jyC.setBackground(null);
            this.gne.setBackground(null);
        } else if (this.nfA) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.b7t);
            this.gne.setBackgroundResource(C25738R.drawable.a_q);
        } else if (this.eVH) {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackgroundResource(C25738R.drawable.a_q);
            this.gne.setBackground(null);
        } else {
            this.jyD.setBackgroundResource(C25738R.drawable.f6802r9);
            this.jyC.setBackground(null);
            this.gne.setBackgroundResource(C25738R.drawable.a_q);
        }
        if (deI != null && deI.uOr && deI.uOt > 0 && !C5046bo.isNullOrNil(deI.uOv)) {
            z = true;
        } else if (deI == null || deI.uOr || C14719f.m22909jD(deI.uOs) == null) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            String str = deI.uOu;
            if (this.gne != null) {
                this.gne.setText(str);
            }
            setVisibility(0);
            AppMethodBeat.m2505o(27115);
            return true;
        }
        if (deI != null) {
            C14738h.deH().mo27009a(null);
        }
        setVisibility(8);
        AppMethodBeat.m2505o(27115);
        return false;
    }
}
