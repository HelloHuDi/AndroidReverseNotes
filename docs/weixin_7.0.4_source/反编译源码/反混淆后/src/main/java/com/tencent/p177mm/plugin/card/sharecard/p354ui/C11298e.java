package com.tencent.p177mm.plugin.card.sharecard.p354ui;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.sharecard.p932a.C42856b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.sharecard.ui.e */
public final class C11298e {
    private ImageView cDh;
    private MMActivity jiE;
    View kgZ;
    C42856b kha;
    protected LinearLayout khb;
    protected LinearLayout khc;
    private TextView khd;

    public C11298e(MMActivity mMActivity) {
        this.jiE = mMActivity;
    }

    public final void bbH() {
        AppMethodBeat.m2504i(88150);
        if (this.kgZ == null) {
            this.kgZ = View.inflate(this.jiE, 2130968960, null);
            this.cDh = (ImageView) this.kgZ.findViewById(2131822251);
            this.khd = (TextView) this.kgZ.findViewById(2131822249);
            this.khb = (LinearLayout) this.kgZ.findViewById(2131822250);
            this.khc = (LinearLayout) this.kgZ.findViewById(2131822252);
            this.khb.setVisibility(8);
            this.khc.setVisibility(8);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.cDh.startAnimation(rotateAnimation);
        }
        mo22994cu();
        AppMethodBeat.m2505o(88150);
    }

    private void bbI() {
        AppMethodBeat.m2504i(88151);
        this.khb.setVisibility(8);
        this.khc.setVisibility(8);
        AppMethodBeat.m2505o(88151);
    }

    public final void bbJ() {
        AppMethodBeat.m2504i(88152);
        this.khb.setVisibility(0);
        this.khc.setVisibility(8);
        AppMethodBeat.m2505o(88152);
    }

    public final void bbK() {
        AppMethodBeat.m2504i(88153);
        this.khb.setVisibility(8);
        AppMethodBeat.m2505o(88153);
    }

    private void bbL() {
        AppMethodBeat.m2504i(88154);
        this.khb.setVisibility(8);
        this.khc.setVisibility(8);
        AppMethodBeat.m2505o(88154);
    }

    public final void bbM() {
        AppMethodBeat.m2504i(88155);
        bbL();
        this.khd.setVisibility(8);
        AppMethodBeat.m2505o(88155);
    }

    /* renamed from: cu */
    public final void mo22994cu() {
        AppMethodBeat.m2504i(88156);
        Integer num = (Integer) C42852am.bbb().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (this.kha != null && C42856b.bby() && ((num.intValue() == 1 || num.intValue() == 4) && C42856b.bbv())) {
            this.khd.setVisibility(0);
        } else {
            this.khd.setVisibility(8);
            if (this.kha != null) {
                C4990ab.m7411d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", Boolean.valueOf(C42856b.bby()), Boolean.valueOf(C42856b.bbz()));
                if (C42856b.bby() && C42856b.bbz()) {
                    if (C42856b.bby() && C42856b.bbz()) {
                        bbI();
                        AppMethodBeat.m2505o(88156);
                        return;
                    }
                    AppMethodBeat.m2505o(88156);
                }
                bbJ();
                AppMethodBeat.m2505o(88156);
                return;
            }
        }
        bbL();
        AppMethodBeat.m2505o(88156);
    }
}
