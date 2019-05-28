package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends a {
    protected TextView gnB;
    private LinearLayout kgv;
    private RelativeLayout ksA;
    private TextView ksB;
    private View ksC;
    private ImageView ksD;
    private ImageView ksE;
    private ImageView ksF;
    private ImageView ksG;
    private ImageView ksH;

    public e(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.i(88978);
        this.gnB = (TextView) beI().findViewById(R.id.abf);
        this.ksA = (RelativeLayout) beI().findViewById(R.id.ahf);
        this.kgv = (LinearLayout) beI().findViewById(R.id.ahj);
        this.ksB = (TextView) beI().findViewById(R.id.aa7);
        this.ksC = beI().findViewById(R.id.ahi);
        this.ksD = (ImageView) beI().findViewById(R.id.abe);
        this.ksE = (ImageView) this.ksf.findViewById(R.id.ahl);
        this.ksF = (ImageView) this.ksf.findViewById(R.id.ahk);
        this.ksG = (ImageView) this.ksf.findViewById(R.id.ahg);
        this.ksH = (ImageView) this.ksf.findViewById(R.id.ahh);
        AppMethodBeat.o(88978);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        AppMethodBeat.i(88979);
        if (this.iPD != null) {
            this.iPD.setText(this.kaS.aZV().kdg);
        }
        if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() > 0) {
            tm tmVar = (tm) this.kaS.aZV().vTW.get(0);
            if (TextUtils.isEmpty(tmVar.title)) {
                this.gnB.setText("");
            } else {
                this.gnB.setText(tmVar.title);
            }
        }
        if (this.kaS.isNormal()) {
            fL(true);
            this.ksG.setAlpha(255);
            if (this.ksG.getBackground() != null) {
                this.ksG.getBackground().setAlpha(255);
            }
            String str = this.kaS.aZW().code;
            if (!TextUtils.isEmpty(str)) {
                this.ksC.setOnClickListener(this.gKK);
                this.ksD.setOnClickListener(this.gKK);
                this.ksB.setOnClickListener(this.gKK);
                switch (this.kaS.aZW().vSb) {
                    case 0:
                        if (str.length() > 40) {
                            this.ksB.setText("");
                            break;
                        } else {
                            this.ksB.setText(m.Hu(str));
                            break;
                        }
                    case 1:
                    case 2:
                        if (str.length() <= 40) {
                            if (!this.kaS.aZL()) {
                                this.ksB.setText("");
                                break;
                            } else {
                                this.ksB.setText(m.Hu(str));
                                break;
                            }
                        }
                        this.ksB.setText("");
                        break;
                }
            }
            ab.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
            fL(false);
        } else {
            this.ksB.setText("");
            this.ksD.setVisibility(8);
            this.ksC.setVisibility(8);
            this.ksG.setAlpha(90);
            if (this.ksG.getBackground() != null) {
                this.ksG.getBackground().setAlpha(90);
            }
        }
        LayoutParams layoutParams = this.ksA.getLayoutParams();
        layoutParams.height = ((this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mContext.getResources().getDimensionPixelSize(R.dimen.l8) * 2)) * 3) / 5;
        ab.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3));
        this.ksA.setLayoutParams(layoutParams);
        AppMethodBeat.o(88979);
    }

    public final void x(boolean z, boolean z2) {
    }

    public final void fL(boolean z) {
        AppMethodBeat.i(88980);
        if (TextUtils.isEmpty(this.kaS.aZW().code) || !z || this.kaS.aZW().vSb == 0 || this.kaS.aZV().vUE) {
            this.ksD.setVisibility(8);
            this.ksC.setVisibility(8);
            AppMethodBeat.o(88980);
            return;
        }
        this.ksD.setVisibility(0);
        this.ksC.setVisibility(0);
        AppMethodBeat.o(88980);
    }

    public final void tq(int i) {
        AppMethodBeat.i(88981);
        if (TextUtils.isEmpty(this.kaS.aZW().vSm)) {
            if (this.ksf != null) {
                this.ksG.setBackgroundResource(i);
                this.ksH.setVisibility(8);
            }
            AppMethodBeat.o(88981);
            return;
        }
        this.ksG.setBackgroundDrawable(null);
        this.ksH.setVisibility(0);
        beO();
        AppMethodBeat.o(88981);
    }

    public final void a(ShapeDrawable shapeDrawable) {
        AppMethodBeat.i(88982);
        if (TextUtils.isEmpty(this.kaS.aZW().vSm)) {
            if (this.ksf != null) {
                this.ksG.setBackgroundDrawable(shapeDrawable);
                this.ksH.setVisibility(8);
            }
            AppMethodBeat.o(88982);
            return;
        }
        this.ksG.setBackgroundDrawable(null);
        this.ksH.setVisibility(0);
        beO();
        AppMethodBeat.o(88982);
    }

    private void beO() {
        AppMethodBeat.i(88984);
        a aVar = new a();
        aVar.ePK = com.tencent.mm.compatible.util.e.eSn;
        o.ahq();
        aVar.ePY = null;
        aVar.ePJ = com.tencent.mm.plugin.card.model.m.Gz(this.kaS.aZW().vSm);
        aVar.ePH = true;
        aVar.eQf = true;
        aVar.eQg = (float) this.mContext.getResources().getDimensionPixelSize(R.dimen.w1);
        aVar.eQa = true;
        aVar.ePF = true;
        aVar.ePT = R.drawable.ha;
        aVar.ePO = com.tencent.mm.bz.a.al(this.mContext, R.dimen.w5);
        aVar.ePN = com.tencent.mm.bz.a.gd(this.mContext);
        o.ahp().a(this.kaS.aZW().vSm, this.ksG, aVar.ahG());
        ab.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.kaS.aZW().vSm);
        AppMethodBeat.o(88984);
    }

    public final void fM(boolean z) {
        AppMethodBeat.i(88983);
        if (TextUtils.isEmpty(this.kaS.aZW().vSm)) {
            this.ksF.setVisibility(0);
            this.ksE.setVisibility(0);
            AppMethodBeat.o(88983);
            return;
        }
        this.ksF.setVisibility(8);
        this.ksE.setVisibility(8);
        AppMethodBeat.o(88983);
    }
}
