package com.tencent.p177mm.plugin.card.p355ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;

/* renamed from: com.tencent.mm.plugin.card.ui.view.d */
public final class C33805d extends C45800i {
    private TextView kgG;
    private TextView kqA;
    private TextView kqB;
    private View kqz;

    public final void initView() {
        AppMethodBeat.m2504i(88738);
        this.kqz = findViewById(2131822038);
        this.kqA = (TextView) findViewById(2131822039);
        this.kgG = (TextView) findViewById(2131822043);
        this.kqB = (TextView) findViewById(2131821931);
        this.kqA.setOnClickListener(this.kqK.bcz());
        this.kqz.setVisibility(8);
        AppMethodBeat.m2505o(88738);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88740);
        this.kqz.setVisibility(8);
        AppMethodBeat.m2505o(88740);
    }

    /* renamed from: Hd */
    public final void mo54354Hd(String str) {
        AppMethodBeat.m2504i(88741);
        this.kqB.setText(str);
        AppMethodBeat.m2505o(88741);
    }

    public final void update() {
        AppMethodBeat.m2504i(88739);
        C42837b bcv = this.kqK.bcv();
        MMActivity bcy = this.kqK.bcy();
        this.kqz.setVisibility(0);
        if (TextUtils.isEmpty(bcv.aZV().vUh)) {
            this.kqA.setVisibility(8);
        } else {
            this.kqA.setVisibility(0);
            this.kqA.setText(bcv.aZV().vUh);
            if (bcv.aZC() || (bcv.aZB() && bcv.aZE())) {
                this.kqA.setTextColor(bcy.getResources().getColor(C25738R.color.a69));
            } else if (bcv.aZB() && bcv.aZD()) {
                this.kqA.setTextColor(bcy.getResources().getColor(C25738R.color.f11832ip));
                this.kqz.setBackgroundColor(bcy.getResources().getColor(C25738R.color.f11834ir));
            } else {
                this.kqA.setTextColor(bcy.getResources().getColor(C25738R.color.a69));
            }
        }
        View findViewById = this.kqz.findViewById(2131822040);
        if (this.kqK.bcA().bec()) {
            findViewById.setVisibility(0);
            this.kqB.setText(bcy.getString(C25738R.string.ah8));
            this.kqB.setTextColor(bcy.getResources().getColor(C25738R.color.a69));
            int dimensionPixelOffset = bcy.getResources().getDimensionPixelOffset(C25738R.dimen.f9979m4);
            Button button = (Button) this.kqz.findViewById(2131821932);
            ShapeDrawable b = C38736l.m65718b(bcy, bcy.getResources().getColor(C25738R.color.a69), dimensionPixelOffset);
            ShapeDrawable dI = C38736l.m65725dI(bcy.getResources().getColor(C25738R.color.a69), dimensionPixelOffset);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, dI);
            stateListDrawable.addState(new int[0], b);
            button.setBackgroundDrawable(stateListDrawable);
            int[] iArr = new int[]{C38736l.m65701Hn(bcv.aZV().color), bcy.getResources().getColor(C25738R.color.a69)};
            button.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr));
            button.setOnClickListener(this.kqK.bcz());
            findViewById = this.kqz.findViewById(2131822041);
            View findViewById2 = this.kqz.findViewById(2131822042);
            if (bcv.aZV().vUv == 1) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(0);
                AppMethodBeat.m2505o(88739);
                return;
            }
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
            AppMethodBeat.m2505o(88739);
            return;
        }
        findViewById.setVisibility(8);
        AppMethodBeat.m2505o(88739);
    }
}
