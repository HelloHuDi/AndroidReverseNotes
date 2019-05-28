package com.tencent.p177mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.protocal.protobuf.cma;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.card.widget.b */
public final class C6821b extends C2788a {
    private final String TAG = "MicroMsg.CardWidgetCommon";
    protected TextView gsf;
    private boolean kok = false;
    protected TextView ksh;
    protected TextView ksi;
    protected Button ksj;
    protected LinearLayout ksk;
    protected TextView ksl;
    protected ImageView ksm;
    protected View ksn;
    protected ImageView kso;

    public C6821b(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.m2504i(88965);
        this.gsf = (TextView) this.ksf.findViewById(2131822004);
        this.ksh = (TextView) this.ksf.findViewById(2131822005);
        this.ksi = (TextView) this.ksf.findViewById(2131822333);
        this.ksj = (Button) this.ksf.findViewById(2131822332);
        this.ksk = (LinearLayout) this.ksf.findViewById(2131822001);
        this.ksm = (ImageView) this.ksk.findViewById(2131822331);
        this.ksn = this.ksf.findViewById(2131822002);
        this.kso = (ImageView) this.ksf.findViewById(2131822003);
        this.ksl = (TextView) this.ksf.findViewById(2131822247);
        AppMethodBeat.m2505o(88965);
    }

    private void beM() {
        AppMethodBeat.m2504i(88967);
        LayoutParams layoutParams = (LayoutParams) this.ksk.getLayoutParams();
        if (this.kaS.aZB()) {
            this.ksg.setVisibility(0);
            this.ksm.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10238vf);
        } else if (this.kaS.aZC() && this.kok) {
            this.ksg.setVisibility(8);
            this.ksm.setVisibility(8);
            layoutParams.topMargin = 0;
        } else if (this.kaS.aZC()) {
            this.ksg.setVisibility(0);
            this.ksm.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10238vf);
        }
        this.ksk.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(88967);
    }

    /* renamed from: tq */
    public final void mo6896tq(int i) {
        LayoutParams layoutParams;
        AppMethodBeat.m2504i(88968);
        this.ksk.setBackgroundResource(i);
        this.ksm.setVisibility(8);
        if (i == 0) {
            layoutParams = (LayoutParams) this.ksk.getLayoutParams();
            if (this.kaS.aZB()) {
                this.ksg.setVisibility(8);
                layoutParams.topMargin = 0;
                this.ksm.setVisibility(0);
                C45778m.m84644a(this.ksm, this.kaS.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10234v_), (int) C25738R.drawable.bcm, false);
            } else if (this.kaS.aZC() && this.kok) {
                this.ksg.setVisibility(8);
                layoutParams.topMargin = 0;
            }
            this.ksk.setLayoutParams(layoutParams);
            this.ksk.invalidate();
        } else {
            beM();
        }
        beN();
        layoutParams = (LayoutParams) this.ksn.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        } else {
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9732dy);
            layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9732dy);
        }
        this.ksn.setLayoutParams(layoutParams);
        this.ksn.invalidate();
        this.ksf.invalidate();
        AppMethodBeat.m2505o(88968);
    }

    private void beN() {
        AppMethodBeat.m2504i(88969);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ksj.getLayoutParams();
        if (this.kaS.aZW().vSj != null && !TextUtils.isEmpty(this.kaS.aZW().vSj.kbX)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9979m4);
        } else if (this.kaS.aZW().vSk != null && !TextUtils.isEmpty(this.kaS.aZW().vSk.kbW)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9979m4);
        } else if (this.kaS.aZV().vTW == null || this.kaS.aZV().vTW.size() <= 0) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9951l8);
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(C25738R.dimen.f9979m4);
        }
        this.ksj.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(88969);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(88970);
        super.setOnClickListener(onClickListener);
        if (this.ksj != null) {
            this.ksj.setOnClickListener(onClickListener);
        }
        if (this.kso != null) {
            this.kso.setOnClickListener(onClickListener);
        }
        AppMethodBeat.m2505o(88970);
    }

    /* renamed from: x */
    public final void mo6897x(boolean z, boolean z2) {
        AppMethodBeat.m2504i(88971);
        if (this.ksj != null) {
            C23446tm c23446tm = this.kaS.aZW().vSk;
            if (c23446tm != null && !TextUtils.isEmpty(c23446tm.title) && c23446tm.vUW != 0 && this.kaS.isNormal()) {
                this.ksj.setClickable(false);
                this.ksj.setVisibility(0);
                this.kso.setVisibility(8);
                AppMethodBeat.m2505o(88971);
                return;
            } else if (this.kaS.aZW().vSj != null && !TextUtils.isEmpty(this.kaS.aZW().vSj.title) && !TextUtils.isEmpty(this.kaS.aZW().vSj.url) && this.kaS.isNormal()) {
                this.ksj.setVisibility(0);
                this.ksj.setEnabled(true);
                if (TextUtils.isEmpty(this.kaS.aZW().code) || this.kaS.aZW().vSb == 0) {
                    this.kso.setVisibility(8);
                    AppMethodBeat.m2505o(88971);
                    return;
                }
                this.kso.setVisibility(0);
                AppMethodBeat.m2505o(88971);
                return;
            } else if (z && !TextUtils.isEmpty(this.kaS.aZW().code) && this.kaS.isNormal()) {
                this.ksj.setVisibility(0);
                this.ksj.setEnabled(z2);
                this.kso.setVisibility(8);
                AppMethodBeat.m2505o(88971);
                return;
            } else if (!z || this.kaS.isNormal()) {
                this.ksj.setVisibility(8);
                this.kso.setVisibility(8);
            } else {
                this.ksj.setVisibility(0);
                this.ksj.setEnabled(false);
                this.kso.setVisibility(8);
                AppMethodBeat.m2505o(88971);
                return;
            }
        }
        AppMethodBeat.m2505o(88971);
    }

    public final void bcN() {
        AppMethodBeat.m2504i(88972);
        LayoutParams layoutParams = (LayoutParams) this.ksk.getLayoutParams();
        if (this.kaS.aZC()) {
            this.ksg.setVisibility(0);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10238vf);
        }
        this.ksk.setLayoutParams(layoutParams);
        this.ksk.invalidate();
        AppMethodBeat.m2505o(88972);
    }

    /* renamed from: fM */
    public final void mo6891fM(boolean z) {
        AppMethodBeat.m2504i(88973);
        this.kok = z;
        if (z) {
            this.ksn.setVisibility(0);
            AppMethodBeat.m2505o(88973);
            return;
        }
        this.ksn.setVisibility(8);
        AppMethodBeat.m2505o(88973);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        AppMethodBeat.m2504i(88966);
        if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() > 0) {
            C23446tm c23446tm = (C23446tm) this.kaS.aZV().vTW.get(0);
            if (!C5046bo.isNullOrNil(c23446tm.title)) {
                this.gsf.setText(c23446tm.title);
            }
            if (C5046bo.isNullOrNil(c23446tm.kbW)) {
                this.ksh.setVisibility(8);
            } else {
                this.ksh.setText(c23446tm.kbW);
                this.ksh.setVisibility(0);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ksh.getLayoutParams();
            if (C5046bo.isNullOrNil(c23446tm.kbX)) {
                this.ksi.setVisibility(8);
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8);
            } else {
                this.ksi.setText(c23446tm.kbX);
                this.ksi.setVisibility(0);
                layoutParams.bottomMargin = 0;
            }
            this.ksh.setLayoutParams(layoutParams);
            this.ksh.invalidate();
        }
        if (this.ksj == null || this.kso == null) {
            C4990ab.m7412e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
        } else if (this.kaS.aZW() == null) {
            C4990ab.m7412e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
            this.ksj.setVisibility(8);
            this.kso.setVisibility(8);
        } else {
            if (this.kaS.aZW().vSj != null) {
                C4990ab.m7416i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.kaS.aZW().vSj.title);
                C4990ab.m7410d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.kaS.aZW().vSj.url);
                C4990ab.m7416i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.kaS.aZW().vSj.kbX);
            }
            C23446tm c23446tm2 = this.kaS.aZW().vSk;
            if (c23446tm2 != null) {
                C4990ab.m7416i("MicroMsg.CardWidgetCommon", "limit_field.title is " + c23446tm2.title);
                C4990ab.m7416i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + c23446tm2.vUW);
                C4990ab.m7416i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + c23446tm2.kbX);
            }
            cma cma = this.kaS.aZV().vUp;
            LinearLayout linearLayout = (LinearLayout) this.ksk.findViewById(2131822334);
            if (cma == null || C5046bo.m7548ek(cma.xjM)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                Iterator it = cma.xjM.iterator();
                while (it.hasNext()) {
                    C23446tm c23446tm3 = (C23446tm) it.next();
                    View inflate = LayoutInflater.from(this.mContext).inflate(2130968912, null);
                    TextView textView = (TextView) inflate.findViewById(2131822008);
                    ((TextView) inflate.findViewById(2131822007)).setText(c23446tm3.title);
                    textView.setText(c23446tm3.kbW);
                    linearLayout.addView(inflate);
                }
            }
            if (c23446tm2 != null && !TextUtils.isEmpty(c23446tm2.title) && c23446tm2.vUW != 0 && this.kaS.isNormal()) {
                this.ksj.setClickable(false);
                this.ksj.setVisibility(0);
                this.ksj.setTextColor(this.mContext.getResources().getColor(C25738R.color.a8m));
                this.ksj.setText(c23446tm2.title);
                if (c23446tm2 == null || TextUtils.isEmpty(c23446tm2.kbW)) {
                    this.ksl.setVisibility(8);
                } else {
                    this.ksl.setText(c23446tm2.kbW);
                    this.ksl.setVisibility(0);
                }
                this.kso.setVisibility(8);
                if ((c23446tm2.vUW & 2) > 0) {
                    this.ksj.setBackgroundDrawable(C38736l.m65700H(this.mContext, C38736l.m65720bS(this.kaS.aZV().color, 150)));
                    this.ksl.setTextColor(C38736l.m65701Hn(this.kaS.aZV().color));
                } else if ((c23446tm2.vUW & 4) > 0) {
                    this.ksj.setBackgroundDrawable(C38736l.m65700H(this.mContext, this.mContext.getResources().getColor(C25738R.color.f12118t0)));
                    this.ksl.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12208w0));
                } else {
                    this.ksj.setBackgroundDrawable(C38736l.m65700H(this.mContext, C38736l.m65701Hn(this.kaS.aZV().color)));
                    this.ksl.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12208w0));
                }
            } else if (this.kaS.aZW().vSj != null && !TextUtils.isEmpty(this.kaS.aZW().vSj.title) && !TextUtils.isEmpty(this.kaS.aZW().vSj.url) && this.kaS.isNormal()) {
                this.ksj.setClickable(true);
                this.ksj.setVisibility(0);
                this.ksj.setBackgroundDrawable(C38736l.m65700H(this.mContext, C38736l.m65701Hn(this.kaS.aZV().color)));
                this.ksj.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a8m));
                this.ksj.setText(this.kaS.aZW().vSj.title);
                if (this.kaS.aZW().vSj == null || TextUtils.isEmpty(this.kaS.aZW().vSj.kbX)) {
                    this.ksl.setVisibility(8);
                } else {
                    this.ksl.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12208w0));
                    this.ksl.setText(this.kaS.aZW().vSj.kbX);
                    this.ksl.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.kaS.aZW().code)) {
                    this.kso.setVisibility(8);
                } else {
                    this.kso.setVisibility(0);
                }
            } else if (!TextUtils.isEmpty(this.kaS.aZW().code) && this.kaS.isNormal()) {
                C4990ab.m7416i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
                this.kso.setVisibility(8);
                this.ksl.setVisibility(8);
                this.ksj.setClickable(true);
                this.ksj.setVisibility(0);
                this.ksj.setBackgroundDrawable(C38736l.m65700H(this.mContext, C38736l.m65701Hn(this.kaS.aZV().color)));
                this.ksj.setTextColor(this.mContext.getResources().getColorStateList(C25738R.color.a8m));
                this.ksj.setText(C25738R.string.ahx);
            } else if (this.kaS.isNormal()) {
                C4990ab.m7416i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
                this.ksj.setVisibility(8);
                this.ksl.setVisibility(8);
                this.kso.setVisibility(8);
            } else {
                C4990ab.m7416i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.kaS.aZW().status);
                this.kso.setVisibility(8);
                this.ksl.setVisibility(8);
                this.ksj.setClickable(true);
                this.ksj.setVisibility(0);
                this.ksj.setTextColor(this.mContext.getResources().getColor(C25738R.color.f12073rb));
                this.ksj.setBackgroundDrawable(C38736l.m65700H(this.mContext, this.mContext.getResources().getColor(C25738R.color.f11831io)));
                if (TextUtils.isEmpty(this.kaS.aZV().vUu)) {
                    C45778m.m84646c(this.ksj, this.kaS.aZW().status);
                } else {
                    this.ksj.setText(this.kaS.aZV().vUu);
                }
            }
        }
        beM();
        this.ksk.setBackgroundDrawable(this.mContext.getResources().getDrawable(C25738R.drawable.azx));
        beN();
        this.ksf.invalidate();
        AppMethodBeat.m2505o(88966);
    }
}
