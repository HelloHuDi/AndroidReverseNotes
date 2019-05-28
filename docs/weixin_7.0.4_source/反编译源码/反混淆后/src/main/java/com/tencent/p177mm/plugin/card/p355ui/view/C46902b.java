package com.tencent.p177mm.plugin.card.p355ui.view;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.p352b.C38728f;
import com.tencent.p177mm.plugin.card.p355ui.p1244a.C42867g;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.protocal.protobuf.aci;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.card.ui.view.b */
public final class C46902b extends C45800i {
    private MMActivity jiE;
    private C42837b kaS;
    private View kqs;
    private TextView kqt;
    private C42867g kqu;

    public final void initView() {
        AppMethodBeat.m2504i(88732);
        this.jiE = this.kqK.bcy();
        this.kqu = this.kqK.bcA();
        AppMethodBeat.m2505o(88732);
    }

    public final void destroy() {
        AppMethodBeat.m2504i(88733);
        super.destroy();
        this.jiE = null;
        this.kqu = null;
        AppMethodBeat.m2505o(88733);
    }

    public final void update() {
        AppMethodBeat.m2504i(88734);
        if (this.kqs == null) {
            this.kqs = ((ViewStub) findViewById(2131822025)).inflate();
            this.kqs.findViewById(2131821929).setOnClickListener(this.kqK.bcz());
        }
        this.kaS = this.kqK.bcv();
        this.kqu = this.kqK.bcA();
        boolean bdE = this.kqu.bdE();
        boolean bdF = this.kqu.bdF();
        if (bdE) {
            this.kqs.setVisibility(0);
            C4990ab.m7416i("MicroMsg.CardAcceptView", "updateAcceptView() acceptViewVisible:" + bdE + " acceptViewEnabled:" + bdF);
            Button button = (Button) this.kqs.findViewById(2131821929);
            View findViewById = this.kqs.findViewById(2131821928);
            findViewById.setBackgroundDrawable(null);
            findViewById.setOnClickListener(null);
            int dimensionPixelSize = this.jiE.getResources().getDimensionPixelSize(C25738R.dimen.f10260w2);
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
                    button.setTextColor(C38736l.m65701Hn(this.kaS.aZV().color));
                    b = C38736l.m65718b(this.jiE, C38736l.m65701Hn(this.kaS.aZV().color), dimensionPixelSize);
                    dI = C38736l.m65725dI(C38736l.m65701Hn(this.kaS.aZV().color), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, dI);
                    stateListDrawable.addState(new int[0], b);
                    int[] iArr = new int[]{this.jiE.getResources().getColor(C25738R.color.a69), C38736l.m65701Hn(this.kaS.aZV().color)};
                    int[][] iArr2 = new int[][]{new int[]{16842919, 16842910}, new int[0]};
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(new ColorStateList(iArr2, iArr));
                    layoutParams = (LayoutParams) this.kqs.getLayoutParams();
                    layoutParams.topMargin = this.jiE.getResources().getDimensionPixelSize(C25738R.dimen.f10236vb);
                    this.kqs.setLayoutParams(layoutParams);
                    this.kqs.findViewById(2131821938).setVisibility(8);
                    final C38728f bcD = this.kqK.bcD();
                    CheckBox checkBox = (CheckBox) this.kqs.findViewById(2131821939);
                    if (bcD.baz() == null || !bcD.baz().kci) {
                        C4990ab.m7416i("MicroMsg.CardAcceptView", "updateFollowBox() not show followbox");
                        checkBox.setVisibility(8);
                    } else {
                        C4990ab.m7416i("MicroMsg.CardAcceptView", "updateFollowBox() show followbox");
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
                                AppMethodBeat.m2504i(88731);
                                if (((CheckBox) view).isChecked()) {
                                    bcD.baz().kcj = true;
                                    AppMethodBeat.m2505o(88731);
                                    return;
                                }
                                bcD.baz().kcj = false;
                                AppMethodBeat.m2505o(88731);
                            }
                        });
                    }
                } else if (this.kaS.aZE() || this.kaS.aZC() || this.kaS.aZF()) {
                    b = C38736l.m65725dI(C38736l.m65701Hn(this.kaS.aZV().color), dimensionPixelSize);
                    dI = C38736l.m65725dI(C38736l.m65720bS(this.kaS.aZV().color, ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, dI);
                    stateListDrawable.addState(new int[0], b);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.jiE.getResources().getColor(C25738R.color.a8m));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    b = C38736l.m65725dI(C38736l.m65701Hn(this.kaS.aZV().color), dimensionPixelSize);
                    dI = C38736l.m65725dI(C38736l.m65720bS(this.kaS.aZV().color, ErrorCode.NEEDDOWNLOAD_FALSE_5), dimensionPixelSize);
                    stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{16842919}, dI);
                    stateListDrawable.addState(new int[0], b);
                    button.setBackgroundDrawable(stateListDrawable);
                    button.setTextColor(this.jiE.getResources().getColor(C25738R.color.a8m));
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
                    button.setTextColor(C38736l.m65720bS(this.kaS.aZV().color, 125));
                    button.setBackgroundDrawable(C38736l.m65718b(this.jiE, C38736l.m65720bS(this.kaS.aZV().color, 125), dimensionPixelSize));
                    layoutParams = (LayoutParams) this.kqs.getLayoutParams();
                    layoutParams.topMargin = this.jiE.getResources().getDimensionPixelSize(C25738R.dimen.f10237vc);
                    this.kqs.setLayoutParams(layoutParams);
                    this.kqs.findViewById(2131821938).setVisibility(8);
                } else if (this.kaS.aZE() || this.kaS.aZC() || this.kaS.aZF()) {
                    button.setTextColor(this.jiE.getResources().getColor(C25738R.color.f12073rb));
                    button.setBackgroundDrawable(C38736l.m65700H(this.jiE, this.jiE.getResources().getColor(C25738R.color.f11831io)));
                    layoutParams2 = (LayoutParams) button.getLayoutParams();
                    layoutParams2.width = -1;
                    button.setLayoutParams(layoutParams2);
                } else {
                    button.setTextColor(this.jiE.getResources().getColor(C25738R.color.f12073rb));
                    button.setBackgroundDrawable(C38736l.m65700H(this.jiE, this.jiE.getResources().getColor(C25738R.color.f11831io)));
                }
            }
            if (!(this.kaS.aZE() || this.kaS.aZC())) {
                if (this.kaS.aZV().vUr != null && !C5046bo.isNullOrNil(this.kaS.aZV().vUr.text)) {
                    if (this.kqt == null) {
                        this.kqt = (TextView) this.kqs.findViewById(2131821937);
                    }
                    this.kqt.setText(this.kaS.aZV().vUr.text);
                    if (!C5046bo.isNullOrNil(this.kaS.aZV().vUr.url)) {
                        this.kqt.setOnClickListener(this.kqK.bcz());
                        this.kqt.setTextColor(C38736l.m65701Hn(this.kaS.aZV().color));
                    }
                    this.kqt.setVisibility(0);
                    AppMethodBeat.m2505o(88734);
                    return;
                } else if (this.kqt != null) {
                    this.kqt.setVisibility(8);
                }
            }
            AppMethodBeat.m2505o(88734);
            return;
        }
        C4990ab.m7416i("MicroMsg.CardAcceptView", "updateAcceptView(), mAcceptCardView is Gone");
        this.kqs.setVisibility(8);
        AppMethodBeat.m2505o(88734);
    }

    public final void bes() {
        AppMethodBeat.m2504i(88735);
        this.kqs.setVisibility(8);
        AppMethodBeat.m2505o(88735);
    }
}
