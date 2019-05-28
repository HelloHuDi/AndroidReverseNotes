package com.tencent.mm.plugin.card.widget;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.cma;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class b extends a {
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

    public b(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.i(88965);
        this.gsf = (TextView) this.ksf.findViewById(R.id.abf);
        this.ksh = (TextView) this.ksf.findViewById(R.id.abg);
        this.ksi = (TextView) this.ksf.findViewById(R.id.akb);
        this.ksj = (Button) this.ksf.findViewById(R.id.aka);
        this.ksk = (LinearLayout) this.ksf.findViewById(R.id.abc);
        this.ksm = (ImageView) this.ksk.findViewById(R.id.ak_);
        this.ksn = this.ksf.findViewById(R.id.abd);
        this.kso = (ImageView) this.ksf.findViewById(R.id.abe);
        this.ksl = (TextView) this.ksf.findViewById(R.id.ai0);
        AppMethodBeat.o(88965);
    }

    private void beM() {
        AppMethodBeat.i(88967);
        LayoutParams layoutParams = (LayoutParams) this.ksk.getLayoutParams();
        if (this.kaS.aZB()) {
            this.ksg.setVisibility(0);
            this.ksm.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.vf);
        } else if (this.kaS.aZC() && this.kok) {
            this.ksg.setVisibility(8);
            this.ksm.setVisibility(8);
            layoutParams.topMargin = 0;
        } else if (this.kaS.aZC()) {
            this.ksg.setVisibility(0);
            this.ksm.setVisibility(8);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.vf);
        }
        this.ksk.setLayoutParams(layoutParams);
        AppMethodBeat.o(88967);
    }

    public final void tq(int i) {
        LayoutParams layoutParams;
        AppMethodBeat.i(88968);
        this.ksk.setBackgroundResource(i);
        this.ksm.setVisibility(8);
        if (i == 0) {
            layoutParams = (LayoutParams) this.ksk.getLayoutParams();
            if (this.kaS.aZB()) {
                this.ksg.setVisibility(8);
                layoutParams.topMargin = 0;
                this.ksm.setVisibility(0);
                m.a(this.ksm, this.kaS.aZV().kbV, this.mContext.getResources().getDimensionPixelSize(R.dimen.v_), (int) R.drawable.bcm, false);
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
            layoutParams.leftMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.dy);
            layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.dy);
        }
        this.ksn.setLayoutParams(layoutParams);
        this.ksn.invalidate();
        this.ksf.invalidate();
        AppMethodBeat.o(88968);
    }

    private void beN() {
        AppMethodBeat.i(88969);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ksj.getLayoutParams();
        if (this.kaS.aZW().vSj != null && !TextUtils.isEmpty(this.kaS.aZW().vSj.kbX)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.m4);
        } else if (this.kaS.aZW().vSk != null && !TextUtils.isEmpty(this.kaS.aZW().vSk.kbW)) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.m4);
        } else if (this.kaS.aZV().vTW == null || this.kaS.aZV().vTW.size() <= 0) {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.l8);
        } else {
            layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelOffset(R.dimen.m4);
        }
        this.ksj.setLayoutParams(layoutParams);
        AppMethodBeat.o(88969);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(88970);
        super.setOnClickListener(onClickListener);
        if (this.ksj != null) {
            this.ksj.setOnClickListener(onClickListener);
        }
        if (this.kso != null) {
            this.kso.setOnClickListener(onClickListener);
        }
        AppMethodBeat.o(88970);
    }

    public final void x(boolean z, boolean z2) {
        AppMethodBeat.i(88971);
        if (this.ksj != null) {
            tm tmVar = this.kaS.aZW().vSk;
            if (tmVar != null && !TextUtils.isEmpty(tmVar.title) && tmVar.vUW != 0 && this.kaS.isNormal()) {
                this.ksj.setClickable(false);
                this.ksj.setVisibility(0);
                this.kso.setVisibility(8);
                AppMethodBeat.o(88971);
                return;
            } else if (this.kaS.aZW().vSj != null && !TextUtils.isEmpty(this.kaS.aZW().vSj.title) && !TextUtils.isEmpty(this.kaS.aZW().vSj.url) && this.kaS.isNormal()) {
                this.ksj.setVisibility(0);
                this.ksj.setEnabled(true);
                if (TextUtils.isEmpty(this.kaS.aZW().code) || this.kaS.aZW().vSb == 0) {
                    this.kso.setVisibility(8);
                    AppMethodBeat.o(88971);
                    return;
                }
                this.kso.setVisibility(0);
                AppMethodBeat.o(88971);
                return;
            } else if (z && !TextUtils.isEmpty(this.kaS.aZW().code) && this.kaS.isNormal()) {
                this.ksj.setVisibility(0);
                this.ksj.setEnabled(z2);
                this.kso.setVisibility(8);
                AppMethodBeat.o(88971);
                return;
            } else if (!z || this.kaS.isNormal()) {
                this.ksj.setVisibility(8);
                this.kso.setVisibility(8);
            } else {
                this.ksj.setVisibility(0);
                this.ksj.setEnabled(false);
                this.kso.setVisibility(8);
                AppMethodBeat.o(88971);
                return;
            }
        }
        AppMethodBeat.o(88971);
    }

    public final void bcN() {
        AppMethodBeat.i(88972);
        LayoutParams layoutParams = (LayoutParams) this.ksk.getLayoutParams();
        if (this.kaS.aZC()) {
            this.ksg.setVisibility(0);
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.vf);
        }
        this.ksk.setLayoutParams(layoutParams);
        this.ksk.invalidate();
        AppMethodBeat.o(88972);
    }

    public final void fM(boolean z) {
        AppMethodBeat.i(88973);
        this.kok = z;
        if (z) {
            this.ksn.setVisibility(0);
            AppMethodBeat.o(88973);
            return;
        }
        this.ksn.setVisibility(8);
        AppMethodBeat.o(88973);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        AppMethodBeat.i(88966);
        if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() > 0) {
            tm tmVar = (tm) this.kaS.aZV().vTW.get(0);
            if (!bo.isNullOrNil(tmVar.title)) {
                this.gsf.setText(tmVar.title);
            }
            if (bo.isNullOrNil(tmVar.kbW)) {
                this.ksh.setVisibility(8);
            } else {
                this.ksh.setText(tmVar.kbW);
                this.ksh.setVisibility(0);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ksh.getLayoutParams();
            if (bo.isNullOrNil(tmVar.kbX)) {
                this.ksi.setVisibility(8);
                layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.l8);
            } else {
                this.ksi.setText(tmVar.kbX);
                this.ksi.setVisibility(0);
                layoutParams.bottomMargin = 0;
            }
            this.ksh.setLayoutParams(layoutParams);
            this.ksh.invalidate();
        }
        if (this.ksj == null || this.kso == null) {
            ab.e("MicroMsg.CardWidgetCommon", "consumeBtn == null || mCardCodeImg == null");
        } else if (this.kaS.aZW() == null) {
            ab.e("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo() == null");
            this.ksj.setVisibility(8);
            this.kso.setVisibility(8);
        } else {
            if (this.kaS.aZW().vSj != null) {
                ab.i("MicroMsg.CardWidgetCommon", "operate_field.title is " + this.kaS.aZW().vSj.title);
                ab.d("MicroMsg.CardWidgetCommon", "operate_field.url is " + this.kaS.aZW().vSj.url);
                ab.i("MicroMsg.CardWidgetCommon", "operate_field.aux_title is " + this.kaS.aZW().vSj.kbX);
            }
            tm tmVar2 = this.kaS.aZW().vSk;
            if (tmVar2 != null) {
                ab.i("MicroMsg.CardWidgetCommon", "limit_field.title is " + tmVar2.title);
                ab.i("MicroMsg.CardWidgetCommon", "limit_field.show_flag is " + tmVar2.vUW);
                ab.i("MicroMsg.CardWidgetCommon", "limit_field.aux_title is " + tmVar2.kbX);
            }
            cma cma = this.kaS.aZV().vUp;
            LinearLayout linearLayout = (LinearLayout) this.ksk.findViewById(R.id.akc);
            if (cma == null || bo.ek(cma.xjM)) {
                linearLayout.setVisibility(8);
            } else {
                linearLayout.setVisibility(0);
                linearLayout.removeAllViews();
                Iterator it = cma.xjM.iterator();
                while (it.hasNext()) {
                    tm tmVar3 = (tm) it.next();
                    View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.id, null);
                    TextView textView = (TextView) inflate.findViewById(R.id.abj);
                    ((TextView) inflate.findViewById(R.id.abi)).setText(tmVar3.title);
                    textView.setText(tmVar3.kbW);
                    linearLayout.addView(inflate);
                }
            }
            if (tmVar2 != null && !TextUtils.isEmpty(tmVar2.title) && tmVar2.vUW != 0 && this.kaS.isNormal()) {
                this.ksj.setClickable(false);
                this.ksj.setVisibility(0);
                this.ksj.setTextColor(this.mContext.getResources().getColor(R.color.a8m));
                this.ksj.setText(tmVar2.title);
                if (tmVar2 == null || TextUtils.isEmpty(tmVar2.kbW)) {
                    this.ksl.setVisibility(8);
                } else {
                    this.ksl.setText(tmVar2.kbW);
                    this.ksl.setVisibility(0);
                }
                this.kso.setVisibility(8);
                if ((tmVar2.vUW & 2) > 0) {
                    this.ksj.setBackgroundDrawable(l.H(this.mContext, l.bS(this.kaS.aZV().color, 150)));
                    this.ksl.setTextColor(l.Hn(this.kaS.aZV().color));
                } else if ((tmVar2.vUW & 4) > 0) {
                    this.ksj.setBackgroundDrawable(l.H(this.mContext, this.mContext.getResources().getColor(R.color.t0)));
                    this.ksl.setTextColor(this.mContext.getResources().getColor(R.color.w0));
                } else {
                    this.ksj.setBackgroundDrawable(l.H(this.mContext, l.Hn(this.kaS.aZV().color)));
                    this.ksl.setTextColor(this.mContext.getResources().getColor(R.color.w0));
                }
            } else if (this.kaS.aZW().vSj != null && !TextUtils.isEmpty(this.kaS.aZW().vSj.title) && !TextUtils.isEmpty(this.kaS.aZW().vSj.url) && this.kaS.isNormal()) {
                this.ksj.setClickable(true);
                this.ksj.setVisibility(0);
                this.ksj.setBackgroundDrawable(l.H(this.mContext, l.Hn(this.kaS.aZV().color)));
                this.ksj.setTextColor(this.mContext.getResources().getColorStateList(R.color.a8m));
                this.ksj.setText(this.kaS.aZW().vSj.title);
                if (this.kaS.aZW().vSj == null || TextUtils.isEmpty(this.kaS.aZW().vSj.kbX)) {
                    this.ksl.setVisibility(8);
                } else {
                    this.ksl.setTextColor(this.mContext.getResources().getColor(R.color.w0));
                    this.ksl.setText(this.kaS.aZW().vSj.kbX);
                    this.ksl.setVisibility(0);
                }
                if (TextUtils.isEmpty(this.kaS.aZW().code)) {
                    this.kso.setVisibility(8);
                } else {
                    this.kso.setVisibility(0);
                }
            } else if (!TextUtils.isEmpty(this.kaS.aZW().code) && this.kaS.isNormal()) {
                ab.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().code is valid");
                this.kso.setVisibility(8);
                this.ksl.setVisibility(8);
                this.ksj.setClickable(true);
                this.ksj.setVisibility(0);
                this.ksj.setBackgroundDrawable(l.H(this.mContext, l.Hn(this.kaS.aZV().color)));
                this.ksj.setTextColor(this.mContext.getResources().getColorStateList(R.color.a8m));
                this.ksj.setText(R.string.ahx);
            } else if (this.kaS.isNormal()) {
                ab.i("MicroMsg.CardWidgetCommon", "operate_field and code is empty!");
                this.ksj.setVisibility(8);
                this.ksl.setVisibility(8);
                this.kso.setVisibility(8);
            } else {
                ab.i("MicroMsg.CardWidgetCommon", "mCardInfo.getDataInfo().status is " + this.kaS.aZW().status);
                this.kso.setVisibility(8);
                this.ksl.setVisibility(8);
                this.ksj.setClickable(true);
                this.ksj.setVisibility(0);
                this.ksj.setTextColor(this.mContext.getResources().getColor(R.color.rb));
                this.ksj.setBackgroundDrawable(l.H(this.mContext, this.mContext.getResources().getColor(R.color.io)));
                if (TextUtils.isEmpty(this.kaS.aZV().vUu)) {
                    m.c(this.ksj, this.kaS.aZW().status);
                } else {
                    this.ksj.setText(this.kaS.aZV().vUu);
                }
            }
        }
        beM();
        this.ksk.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.azx));
        beN();
        this.ksf.invalidate();
        AppMethodBeat.o(88966);
    }
}
