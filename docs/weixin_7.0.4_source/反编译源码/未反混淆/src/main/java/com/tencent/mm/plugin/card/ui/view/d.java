package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.ui.MMActivity;

public final class d extends i {
    private TextView kgG;
    private TextView kqA;
    private TextView kqB;
    private View kqz;

    public final void initView() {
        AppMethodBeat.i(88738);
        this.kqz = findViewById(R.id.acc);
        this.kqA = (TextView) findViewById(R.id.acd);
        this.kgG = (TextView) findViewById(R.id.ach);
        this.kqB = (TextView) findViewById(R.id.a_g);
        this.kqA.setOnClickListener(this.kqK.bcz());
        this.kqz.setVisibility(8);
        AppMethodBeat.o(88738);
    }

    public final void bes() {
        AppMethodBeat.i(88740);
        this.kqz.setVisibility(8);
        AppMethodBeat.o(88740);
    }

    public final void Hd(String str) {
        AppMethodBeat.i(88741);
        this.kqB.setText(str);
        AppMethodBeat.o(88741);
    }

    public final void update() {
        AppMethodBeat.i(88739);
        b bcv = this.kqK.bcv();
        MMActivity bcy = this.kqK.bcy();
        this.kqz.setVisibility(0);
        if (TextUtils.isEmpty(bcv.aZV().vUh)) {
            this.kqA.setVisibility(8);
        } else {
            this.kqA.setVisibility(0);
            this.kqA.setText(bcv.aZV().vUh);
            if (bcv.aZC() || (bcv.aZB() && bcv.aZE())) {
                this.kqA.setTextColor(bcy.getResources().getColor(R.color.a69));
            } else if (bcv.aZB() && bcv.aZD()) {
                this.kqA.setTextColor(bcy.getResources().getColor(R.color.ip));
                this.kqz.setBackgroundColor(bcy.getResources().getColor(R.color.ir));
            } else {
                this.kqA.setTextColor(bcy.getResources().getColor(R.color.a69));
            }
        }
        View findViewById = this.kqz.findViewById(R.id.ace);
        if (this.kqK.bcA().bec()) {
            findViewById.setVisibility(0);
            this.kqB.setText(bcy.getString(R.string.ah8));
            this.kqB.setTextColor(bcy.getResources().getColor(R.color.a69));
            int dimensionPixelOffset = bcy.getResources().getDimensionPixelOffset(R.dimen.m4);
            Button button = (Button) this.kqz.findViewById(R.id.a_h);
            ShapeDrawable b = l.b(bcy, bcy.getResources().getColor(R.color.a69), dimensionPixelOffset);
            ShapeDrawable dI = l.dI(bcy.getResources().getColor(R.color.a69), dimensionPixelOffset);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, dI);
            stateListDrawable.addState(new int[0], b);
            button.setBackgroundDrawable(stateListDrawable);
            int[] iArr = new int[]{l.Hn(bcv.aZV().color), bcy.getResources().getColor(R.color.a69)};
            button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
            button.setOnClickListener(this.kqK.bcz());
            findViewById = this.kqz.findViewById(R.id.acf);
            View findViewById2 = this.kqz.findViewById(R.id.acg);
            if (bcv.aZV().vUv == 1) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                AppMethodBeat.o(88739);
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            AppMethodBeat.o(88739);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.o(88739);
    }
}
