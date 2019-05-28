package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.n */
public final class C42884n extends C41531v {
    public final ImageView eks;
    public final TextView gne;
    public final ProgressBar gtQ;
    public final TextView gtb;
    public final TextView hrg;
    public final ImageView iyo;
    public final LinearLayout kuD;
    public final MMPinProgressBtn kuH;
    public final CheckBox kuN;
    public final ImageView kuP;
    public final View kuR;
    public final TextView timeTv;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.n$1 */
    class C428831 implements OnClickListener {
        C428831() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54331);
            C11376a c11376a = (C11376a) view.getTag();
            if (c11376a == null) {
                AppMethodBeat.m2505o(54331);
                return;
            }
            c11376a.mo6913a(view, c11376a);
            AppMethodBeat.m2505o(54331);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.n$2 */
    class C428852 implements OnClickListener {
        C428852() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54332);
            C11376a c11376a = (C11376a) view.getTag();
            if (c11376a == null) {
                AppMethodBeat.m2505o(54332);
                return;
            }
            boolean z = !C42884n.this.kuN.isChecked();
            if (c11376a.isEnable()) {
                C42884n.this.kuN.setChecked(z);
                c11376a.mo23109a(z, c11376a, C42884n.this);
            }
            AppMethodBeat.m2505o(54332);
        }
    }

    private C42884n(View view) {
        super(view);
        AppMethodBeat.m2504i(54333);
        this.kuD = (LinearLayout) view.findViewById(2131822738);
        this.eks = (ImageView) view.findViewById(2131821183);
        this.gtb = (TextView) view.findViewById(2131821227);
        this.timeTv = (TextView) view.findViewById(2131820988);
        this.kuN = (CheckBox) view.findViewById(2131821593);
        this.kuR = view.findViewById(2131822747);
        this.kuP = (ImageView) view.findViewById(2131822427);
        this.iyo = (ImageView) view.findViewById(2131821226);
        this.gne = (TextView) view.findViewById(2131821185);
        this.hrg = (TextView) view.findViewById(2131820993);
        this.kuH = (MMPinProgressBtn) view.findViewById(2131822617);
        this.gtQ = (ProgressBar) view.findViewById(2131821605);
        this.kuD.setOnClickListener(new C428831());
        this.kuR.setOnClickListener(new C428852());
        AppMethodBeat.m2505o(54333);
    }

    /* renamed from: m */
    public static C41531v m76142m(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(54334);
        C42884n c42884n = new C42884n(LayoutInflater.from(viewGroup.getContext()).inflate(2130969133, viewGroup, false));
        AppMethodBeat.m2505o(54334);
        return c42884n;
    }
}
