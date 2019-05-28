package com.tencent.p177mm.plugin.topstory.p541ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.topstory.p539a.p1042c.C13944f;

/* renamed from: com.tencent.mm.plugin.topstory.ui.widget.c */
public final class C40003c {
    public View contentView;
    public String fgd;
    private View sHR;
    private View sHS;
    public C13944f sIa;
    C40004a sIb;
    private int sIc = 16;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.c$1 */
    class C224251 implements OnClickListener {
        C224251() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(2232);
            C40003c.this.sIb.mo9227a(C40003c.this.sIa);
            AppMethodBeat.m2505o(2232);
        }
    }

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.c$a */
    public interface C40004a {
        /* renamed from: a */
        void mo9227a(C13944f c13944f);
    }

    public C40003c(View view, C40004a c40004a, C13944f c13944f, String str) {
        AppMethodBeat.m2504i(2233);
        this.contentView = view;
        this.sIa = c13944f;
        this.sHR = view.findViewById(2131828307);
        this.sHS = view.findViewById(2131828311);
        this.sIb = c40004a;
        this.fgd = str;
        view.setOnClickListener(new C224251());
        AppMethodBeat.m2505o(2233);
    }

    /* renamed from: a */
    public final void mo63238a(View view, boolean z, int i) {
        AppMethodBeat.m2504i(2234);
        int[] a = C4251f.m6602a(view.getContext(), view, this.contentView, z);
        a[0] = a[0] + 0;
        a[1] = a[1] + i;
        if (!(this.sHS == null || this.sHR == null)) {
            int em = C4251f.m6603em(view) - C4251f.dip2px(view.getContext(), (float) this.sIc);
            LayoutParams layoutParams;
            if (z) {
                this.sHS.setVisibility(0);
                this.sHR.setVisibility(8);
                layoutParams = (LayoutParams) this.sHS.getLayoutParams();
                layoutParams.leftMargin = em;
                this.sHS.setLayoutParams(layoutParams);
            } else {
                this.sHS.setVisibility(8);
                this.sHR.setVisibility(0);
                layoutParams = (LayoutParams) this.sHR.getLayoutParams();
                layoutParams.leftMargin = em;
                this.sHR.setLayoutParams(layoutParams);
            }
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.contentView.getLayoutParams();
        layoutParams2.topMargin = a[1];
        this.contentView.setLayoutParams(layoutParams2);
        AppMethodBeat.m2505o(2234);
    }
}
