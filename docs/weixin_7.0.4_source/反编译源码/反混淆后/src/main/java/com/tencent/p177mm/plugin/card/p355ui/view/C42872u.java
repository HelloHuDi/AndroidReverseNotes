package com.tencent.p177mm.plugin.card.p355ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.protocal.protobuf.C23446tm;

/* renamed from: com.tencent.mm.plugin.card.ui.view.u */
public final class C42872u extends C45800i {
    private View krf;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.m2504i(88780);
        if (this.krf == null) {
            this.krf = ((ViewStub) findViewById(2131822029)).inflate();
        }
        C42837b bcv = this.kqK.bcv();
        MMActivity bcy = this.kqK.bcy();
        C23446tm c23446tm = bcv.aZW().vSj;
        if (this.krf != null) {
            TextView textView = (TextView) this.krf.findViewById(2131822246);
            textView.setText(c23446tm.title);
            textView.setTextColor(C38736l.m65701Hn(bcv.aZV().color));
            TextView textView2 = (TextView) this.krf.findViewById(2131822247);
            LinearLayout linearLayout = (LinearLayout) this.krf.findViewById(2131822245);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (bcv.aZD()) {
                LayoutParams layoutParams2 = (LayoutParams) textView.getLayoutParams();
                if (TextUtils.isEmpty(c23446tm.kbX)) {
                    textView2.setVisibility(8);
                    layoutParams.height = bcy.getResources().getDimensionPixelOffset(C25738R.dimen.f10257vz);
                } else {
                    textView2.setText(c23446tm.kbX);
                    textView2.setVisibility(0);
                    layoutParams.height = bcy.getResources().getDimensionPixelOffset(C25738R.dimen.f10256vy);
                    layoutParams2.bottomMargin = bcy.getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
                    LayoutParams layoutParams3 = (LayoutParams) textView2.getLayoutParams();
                    layoutParams3.topMargin = bcy.getResources().getDimensionPixelSize(C25738R.dimen.f9723do);
                    textView2.setLayoutParams(layoutParams3);
                    textView2.invalidate();
                }
                layoutParams2.height = bcy.getResources().getDimensionPixelSize(C25738R.dimen.f10258w0);
                textView.setLayoutParams(layoutParams2);
                textView.invalidate();
                textView.setBackgroundDrawable(C38736l.m65729g(bcy, bcv.aZV().color, bcy.getResources().getDimensionPixelSize(C25738R.dimen.f10260w2)));
                textView.setTextColor(C38736l.m65715ah(bcy, bcv.aZV().color));
                linearLayout.setBackgroundDrawable(null);
                textView.setOnClickListener(this.kqK.bcz());
            } else {
                if (TextUtils.isEmpty(c23446tm.kbX)) {
                    textView2.setVisibility(8);
                    layoutParams.height = bcy.getResources().getDimensionPixelOffset(C25738R.dimen.f10269wc);
                } else {
                    textView2.setText(c23446tm.kbX);
                    textView2.setVisibility(0);
                    layoutParams.height = bcy.getResources().getDimensionPixelOffset(C25738R.dimen.f10268wb);
                }
                linearLayout.setOnClickListener(this.kqK.bcz());
            }
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.invalidate();
            this.krf.invalidate();
            if (bcv.aZD()) {
                linearLayout.getLayoutParams();
            }
        }
        AppMethodBeat.m2505o(88780);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88781);
        if (this.krf != null) {
            this.krf.setVisibility(8);
        }
        AppMethodBeat.m2505o(88781);
    }
}
