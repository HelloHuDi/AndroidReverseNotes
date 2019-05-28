package com.tencent.p177mm.plugin.choosemsgfile.p358b.p359b;

import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.m */
public final class C38787m extends C41531v {
    public final ProgressBar gtQ;
    public final View kuF;
    public final ImageView kuG;
    public final MMPinProgressBtn kuH;
    public final TextView kuI;
    public final TextView kuJ;
    public final View kuK;
    public final TextView kuL;
    public final ImageView kuM;
    public final CheckBox kuN;
    public final View kuO;
    public ImageView kuP;

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.m$1 */
    class C113781 implements OnClickListener {
        C113781() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54327);
            C11376a c11376a = (C11376a) view.getTag();
            if (c11376a == null) {
                AppMethodBeat.m2505o(54327);
                return;
            }
            c11376a.mo6913a(view, c11376a);
            AppMethodBeat.m2505o(54327);
        }
    }

    /* renamed from: com.tencent.mm.plugin.choosemsgfile.b.b.m$2 */
    class C276402 implements OnClickListener {
        C276402() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(54328);
            C11376a c11376a = (C11376a) view.getTag();
            if (c11376a == null) {
                AppMethodBeat.m2505o(54328);
                return;
            }
            boolean z = !C38787m.this.kuN.isChecked();
            if (c11376a.isEnable()) {
                C38787m.this.kuN.setChecked(z);
                c11376a.mo23109a(z, c11376a, C38787m.this);
                if (z) {
                    C38787m.this.kuM.setVisibility(8);
                } else {
                    C38787m.this.kuM.setVisibility(0);
                    AppMethodBeat.m2505o(54328);
                    return;
                }
            }
            AppMethodBeat.m2505o(54328);
        }
    }

    private C38787m(View view) {
        super(view);
        AppMethodBeat.m2504i(54329);
        this.kuF = view.findViewById(2131822738);
        this.kuG = (ImageView) view.findViewById(2131821842);
        this.kuH = (MMPinProgressBtn) view.findViewById(2131822617);
        this.gtQ = (ProgressBar) view.findViewById(2131821605);
        this.kuK = view.findViewById(2131822743);
        this.kuL = (TextView) view.findViewById(2131822745);
        this.kuI = (TextView) view.findViewById(2131822741);
        this.kuJ = (TextView) view.findViewById(2131822742);
        this.kuM = (ImageView) view.findViewById(2131822711);
        this.kuN = (CheckBox) view.findViewById(2131821593);
        this.kuO = view.findViewById(2131822746);
        this.kuP = (ImageView) view.findViewById(2131822427);
        this.kuG.setOnClickListener(new C113781());
        this.kuO.setOnClickListener(new C276402());
        AppMethodBeat.m2505o(54329);
    }

    /* renamed from: m */
    public static C41531v m65810m(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(54330);
        C38787m c38787m = new C38787m(LayoutInflater.from(viewGroup.getContext()).inflate(2130969132, viewGroup, false));
        AppMethodBeat.m2505o(54330);
        return c38787m;
    }
}
