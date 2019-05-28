package com.tencent.mm.plugin.card.ui.view;

import android.content.res.ColorStateList;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class b extends i {
    private MMActivity jiE;
    private com.tencent.mm.plugin.card.base.b kaS;
    private View kqs;
    private TextView kqt;
    private g kqu;

    public final void initView() {
        AppMethodBeat.i(88732);
        this.jiE = this.kqK.bcy();
        this.kqu = this.kqK.bcA();
        AppMethodBeat.o(88732);
    }

    public final void destroy() {
        AppMethodBeat.i(88733);
        super.destroy();
        this.jiE = null;
        this.kqu = null;
        AppMethodBeat.o(88733);
    }

    public final void update() {
        AppMethodBeat.i(88734);
        if (this.kqs == null) {
            this.kqs = ((ViewStub) findViewById(R.id.ac0)).inflate();
            this.kqs.findViewById(R.id.a_e).setOnClickListener(this.kqK.bcz());
        }
        this.kaS = this.kqK.bcv();
        this.kqu = this.kqK.bcA();
        boolean bdE = this.kqu.bdE();
        boolean bdF = this.kqu.bdF();
        if (bdE) {
            this.kqs.setVisibility(0);
            ab.i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bdE + " acceptViewEnabled:" + bdF);
            Button button = (Button) this.kqs.findViewById(R.id.a_e);
            View findViewById = this.kqs.findViewById(R.id.a_d);
            findViewById.setBackgroundDrawable(null);
            findViewById.setOnClickListener(null);
            int dimensionPixelSize = this.jiE.getResources().getDimensionPixelSize(R.dimen.w2);
            LayoutParams layoutParams;
            LayoutParams layoutParams2;
            if (bdF) {
                if (!TextUtils.isEmpty(this.kaS.aZV().vUf)) {
                    button.setText(this.kaS.aZV().vUf);
                }
                ShapeDrawable b;
                ShapeDrawable dI;
                StateListDrawable stateListDrawable;
                if (this.kaS.aZD()) {
                    button.setTextColor(l.Hn(this.kaS.aZV().color));
                    b = l.b(this.jiE, l.Hn(this.kaS.aZV().color), dimensionPixelSize);
                    dI = l.dI(l.Hn(this.kaS.aZV().color), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, dI);
                    stateListDrawable.addState(new int[0], b);
                    int[] iArr = new int[]{this.jiE.getResources().getColor(R.color.a69), l.Hn(this.kaS.aZV().color)};
                    int[][] iArr2 = new int[][]{new int[]{16842919, 16842910}, new int[0]};
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(new ColorStateList(iArr2, iArr));
                    layoutParams = (LayoutParams) this.kqs.getLayoutParams();
                    layoutParams.topMargin = this.jiE.getResources().getDimensionPixelSize(R.dimen.vb);
                    this.kqs.setLayoutParams(layoutParams);
                    this.kqs.findViewById(R.id.a_n).setVisibility(8);
                    final f bcD = this.kqK.bcD();
                    CheckBox checkBox = (CheckBox) this.kqs.findViewById(R.id.a_o);
                    if (bcD.baz() == null || !bcD.baz().kci) {
                        ab.i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
                        checkBox.setVisibility(8);
                    } else {
                        ab.i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
                        checkBox.setVisibility(0);
                        aci aci = this.kaS.aZV().vUq;
                        if (aci == null || TextUtils.isEmpty(aci.text)) {
                            checkBox.setText(bcD.baz().title);
                        } else {
                            checkBox.setText(aci.text);
                        }
                        checkBox.setChecked(bcD.baz().kcj);
                        checkBox.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(88731);
                                if (((CheckBox) view).isChecked()) {
                                    bcD.baz().kcj = true;
                                    AppMethodBeat.o(88731);
                                    return;
                                }
                                bcD.baz().kcj = false;
                                AppMethodBeat.o(88731);
                            }
                        });
                    }
                } else if (this.kaS.aZE() || this.kaS.aZC() || this.kaS.aZF()) {
                    b = l.dI(l.Hn(this.kaS.aZV().color), dimensionPixelSize);
                    dI = l.dI(l.bS(this.kaS.aZV().color, ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, dI);
                    stateListDrawable.addState(new int[0], b);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.jiE.getResources().getColor(R.color.a8m));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    b = l.dI(l.Hn(this.kaS.aZV().color), dimensionPixelSize);
                    dI = l.dI(l.bS(this.kaS.aZV().color, ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, dI);
                    stateListDrawable.addState(new int[0], b);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.jiE.getResources().getColor(R.color.a8m));
                }
            } else {
                CharSequence charSequence;
                this.kqs.setEnabled(false);
                findViewById.setEnabled(false);
                button.setEnabled(false);
                if (this.kaS.aZD()) {
                    charSequence = this.kaS.aZV().vUf;
                } else {
                    charSequence = this.kqu.bdx();
                }
                button.setText(charSequence);
                if (this.kaS.aZD()) {
                    button.setTextColor(l.bS(this.kaS.aZV().color, 125));
                    button.setBackgroundDrawable(l.b(this.jiE, l.bS(this.kaS.aZV().color, 125), dimensionPixelSize));
                    layoutParams = (LayoutParams) this.kqs.getLayoutParams();
                    layoutParams.topMargin = this.jiE.getResources().getDimensionPixelSize(R.dimen.vc);
                    this.kqs.setLayoutParams(layoutParams);
                    this.kqs.findViewById(R.id.a_n).setVisibility(8);
                } else if (this.kaS.aZE() || this.kaS.aZC() || this.kaS.aZF()) {
                    button.setTextColor(this.jiE.getResources().getColor(R.color.rb));
                    button.setBackgroundDrawable(l.H(this.jiE, this.jiE.getResources().getColor(R.color.io)));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    button.setTextColor(this.jiE.getResources().getColor(R.color.rb));
                    button.setBackgroundDrawable(l.H(this.jiE, this.jiE.getResources().getColor(R.color.io)));
                }
            }
            if (!(this.kaS.aZE() || this.kaS.aZC())) {
                if (this.kaS.aZV().vUr != null && !bo.isNullOrNil(this.kaS.aZV().vUr.text)) {
                    if (this.kqt == null) {
                        this.kqt = (TextView) this.kqs.findViewById(R.id.a_m);
                    }
                    this.kqt.setText(this.kaS.aZV().vUr.text);
                    if (!bo.isNullOrNil(this.kaS.aZV().vUr.url)) {
                        this.kqt.setOnClickListener(this.kqK.bcz());
                        this.kqt.setTextColor(l.Hn(this.kaS.aZV().color));
                    }
                    this.kqt.setVisibility(0);
                    AppMethodBeat.o(88734);
                    return;
                } else if (this.kqt != null) {
                    this.kqt.setVisibility(8);
                }
            }
            AppMethodBeat.o(88734);
            return;
        }
        ab.i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
        this.kqs.setVisibility(8);
        AppMethodBeat.o(88734);
    }

    public final void bes() {
        AppMethodBeat.i(88735);
        this.kqs.setVisibility(8);
        AppMethodBeat.o(88735);
    }
}
