package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.ui.MMActivity;

public final class u extends i {
    private View krf;

    public final void initView() {
    }

    public final void update() {
        AppMethodBeat.i(88780);
        if (this.krf == null) {
            this.krf = ((ViewStub) findViewById(R.id.ac4)).inflate();
        }
        b bcv = this.kqK.bcv();
        MMActivity bcy = this.kqK.bcy();
        tm tmVar = bcv.aZW().vSj;
        if (this.krf != null) {
            TextView textView = (TextView) this.krf.findViewById(R.id.ahz);
            textView.setText(tmVar.title);
            textView.setTextColor(l.Hn(bcv.aZV().color));
            TextView textView2 = (TextView) this.krf.findViewById(R.id.ai0);
            LinearLayout linearLayout = (LinearLayout) this.krf.findViewById(R.id.ahy);
            LayoutParams layoutParams = (LayoutParams) linearLayout.getLayoutParams();
            if (bcv.aZD()) {
                LayoutParams layoutParams2 = (LayoutParams) textView.getLayoutParams();
                if (TextUtils.isEmpty(tmVar.kbX)) {
                    textView2.setVisibility(8);
                    layoutParams.height = bcy.getResources().getDimensionPixelOffset(R.dimen.vz);
                } else {
                    textView2.setText(tmVar.kbX);
                    textView2.setVisibility(0);
                    layoutParams.height = bcy.getResources().getDimensionPixelOffset(R.dimen.vy);
                    layoutParams2.bottomMargin = bcy.getResources().getDimensionPixelSize(R.dimen.f15do);
                    LayoutParams layoutParams3 = (LayoutParams) textView2.getLayoutParams();
                    layoutParams3.topMargin = bcy.getResources().getDimensionPixelSize(R.dimen.f15do);
                    textView2.setLayoutParams(layoutParams3);
                    textView2.invalidate();
                }
                layoutParams2.height = bcy.getResources().getDimensionPixelSize(R.dimen.w0);
                textView.setLayoutParams(layoutParams2);
                textView.invalidate();
                textView.setBackgroundDrawable(l.g(bcy, bcv.aZV().color, bcy.getResources().getDimensionPixelSize(R.dimen.w2)));
                textView.setTextColor(l.ah(bcy, bcv.aZV().color));
                linearLayout.setBackgroundDrawable(null);
                textView.setOnClickListener(this.kqK.bcz());
            } else {
                if (TextUtils.isEmpty(tmVar.kbX)) {
                    textView2.setVisibility(8);
                    layoutParams.height = bcy.getResources().getDimensionPixelOffset(R.dimen.wc);
                } else {
                    textView2.setText(tmVar.kbX);
                    textView2.setVisibility(0);
                    layoutParams.height = bcy.getResources().getDimensionPixelOffset(R.dimen.wb);
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
        AppMethodBeat.o(88780);
    }

    public final void bes() {
        AppMethodBeat.i(88781);
        if (this.krf != null) {
            this.krf.setVisibility(8);
        }
        AppMethodBeat.o(88781);
    }
}
