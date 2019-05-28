package com.tencent.p177mm.plugin.card.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.protocal.protobuf.C23446tm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.widget.e */
public final class C45802e extends C2788a {
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

    public C45802e(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beJ() {
        AppMethodBeat.m2504i(88978);
        this.gnB = (TextView) beI().findViewById(2131822004);
        this.ksA = (RelativeLayout) beI().findViewById(2131822226);
        this.kgv = (LinearLayout) beI().findViewById(2131822230);
        this.ksB = (TextView) beI().findViewById(2131821958);
        this.ksC = beI().findViewById(2131822229);
        this.ksD = (ImageView) beI().findViewById(2131822003);
        this.ksE = (ImageView) this.ksf.findViewById(2131822232);
        this.ksF = (ImageView) this.ksf.findViewById(2131822231);
        this.ksG = (ImageView) this.ksf.findViewById(2131822227);
        this.ksH = (ImageView) this.ksf.findViewById(2131822228);
        AppMethodBeat.m2505o(88978);
    }

    /* Access modifiers changed, original: protected|final */
    public final void beK() {
        AppMethodBeat.m2504i(88979);
        if (this.iPD != null) {
            this.iPD.setText(this.kaS.aZV().kdg);
        }
        if (this.kaS.aZV().vTW != null && this.kaS.aZV().vTW.size() > 0) {
            C23446tm c23446tm = (C23446tm) this.kaS.aZV().vTW.get(0);
            if (TextUtils.isEmpty(c23446tm.title)) {
                this.gnB.setText("");
            } else {
                this.gnB.setText(c23446tm.title);
            }
        }
        if (this.kaS.isNormal()) {
            mo6890fL(true);
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
                            this.ksB.setText(C45778m.m84640Hu(str));
                            break;
                        }
                    case 1:
                    case 2:
                        if (str.length() <= 40) {
                            if (!this.kaS.aZL()) {
                                this.ksB.setText("");
                                break;
                            } else {
                                this.ksB.setText(C45778m.m84640Hu(str));
                                break;
                            }
                        }
                        this.ksB.setText("");
                        break;
                }
            }
            C4990ab.m7412e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
            mo6890fL(false);
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
        layoutParams.height = ((this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9951l8) * 2)) * 3) / 5;
        C4990ab.m7411d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", Integer.valueOf(r1), Integer.valueOf(r2), Integer.valueOf(r3));
        this.ksA.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(88979);
    }

    /* renamed from: x */
    public final void mo6897x(boolean z, boolean z2) {
    }

    /* renamed from: fL */
    public final void mo6890fL(boolean z) {
        AppMethodBeat.m2504i(88980);
        if (TextUtils.isEmpty(this.kaS.aZW().code) || !z || this.kaS.aZW().vSb == 0 || this.kaS.aZV().vUE) {
            this.ksD.setVisibility(8);
            this.ksC.setVisibility(8);
            AppMethodBeat.m2505o(88980);
            return;
        }
        this.ksD.setVisibility(0);
        this.ksC.setVisibility(0);
        AppMethodBeat.m2505o(88980);
    }

    /* renamed from: tq */
    public final void mo6896tq(int i) {
        AppMethodBeat.m2504i(88981);
        if (TextUtils.isEmpty(this.kaS.aZW().vSm)) {
            if (this.ksf != null) {
                this.ksG.setBackgroundResource(i);
                this.ksH.setVisibility(8);
            }
            AppMethodBeat.m2505o(88981);
            return;
        }
        this.ksG.setBackgroundDrawable(null);
        this.ksH.setVisibility(0);
        beO();
        AppMethodBeat.m2505o(88981);
    }

    /* renamed from: a */
    public final void mo6885a(ShapeDrawable shapeDrawable) {
        AppMethodBeat.m2504i(88982);
        if (TextUtils.isEmpty(this.kaS.aZW().vSm)) {
            if (this.ksf != null) {
                this.ksG.setBackgroundDrawable(shapeDrawable);
                this.ksH.setVisibility(8);
            }
            AppMethodBeat.m2505o(88982);
            return;
        }
        this.ksG.setBackgroundDrawable(null);
        this.ksH.setVisibility(0);
        beO();
        AppMethodBeat.m2505o(88982);
    }

    private void beO() {
        AppMethodBeat.m2504i(88984);
        C17927a c17927a = new C17927a();
        c17927a.ePK = C6457e.eSn;
        C32291o.ahq();
        c17927a.ePY = null;
        c17927a.ePJ = C33770m.m55183Gz(this.kaS.aZW().vSm);
        c17927a.ePH = true;
        c17927a.eQf = true;
        c17927a.eQg = (float) this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10259w1);
        c17927a.eQa = true;
        c17927a.ePF = true;
        c17927a.ePT = C25738R.drawable.f6532ha;
        c17927a.ePO = C1338a.m2856al(this.mContext, C25738R.dimen.f10262w5);
        c17927a.ePN = C1338a.m2868gd(this.mContext);
        C32291o.ahp().mo43766a(this.kaS.aZW().vSm, this.ksG, c17927a.ahG());
        C4990ab.m7416i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.kaS.aZW().vSm);
        AppMethodBeat.m2505o(88984);
    }

    /* renamed from: fM */
    public final void mo6891fM(boolean z) {
        AppMethodBeat.m2504i(88983);
        if (TextUtils.isEmpty(this.kaS.aZW().vSm)) {
            this.ksF.setVisibility(0);
            this.ksE.setVisibility(0);
            AppMethodBeat.m2505o(88983);
            return;
        }
        this.ksF.setVisibility(8);
        this.ksE.setVisibility(8);
        AppMethodBeat.m2505o(88983);
    }
}
