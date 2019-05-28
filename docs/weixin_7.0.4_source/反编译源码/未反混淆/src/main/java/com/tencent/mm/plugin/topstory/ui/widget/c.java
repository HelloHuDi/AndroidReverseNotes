package com.tencent.mm.plugin.topstory.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.topstory.a.c.f;

public final class c {
    public View contentView;
    public String fgd;
    private View sHR;
    private View sHS;
    public f sIa;
    a sIb;
    private int sIc = 16;

    public interface a {
        void a(f fVar);
    }

    public c(View view, a aVar, f fVar, String str) {
        AppMethodBeat.i(2233);
        this.contentView = view;
        this.sIa = fVar;
        this.sHR = view.findViewById(R.id.exu);
        this.sHS = view.findViewById(R.id.exy);
        this.sIb = aVar;
        this.fgd = str;
        view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(2232);
                c.this.sIb.a(c.this.sIa);
                AppMethodBeat.o(2232);
            }
        });
        AppMethodBeat.o(2233);
    }

    public final void a(View view, boolean z, int i) {
        AppMethodBeat.i(2234);
        int[] a = f.a(view.getContext(), view, this.contentView, z);
        a[0] = a[0] + 0;
        a[1] = a[1] + i;
        if (!(this.sHS == null || this.sHR == null)) {
            int em = f.em(view) - f.dip2px(view.getContext(), (float) this.sIc);
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
        AppMethodBeat.o(2234);
    }
}
