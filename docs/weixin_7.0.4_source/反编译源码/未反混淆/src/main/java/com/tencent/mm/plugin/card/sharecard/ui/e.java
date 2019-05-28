package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class e {
    private ImageView cDh;
    private MMActivity jiE;
    View kgZ;
    b kha;
    protected LinearLayout khb;
    protected LinearLayout khc;
    private TextView khd;

    public e(MMActivity mMActivity) {
        this.jiE = mMActivity;
    }

    public final void bbH() {
        AppMethodBeat.i(88150);
        if (this.kgZ == null) {
            this.kgZ = View.inflate(this.jiE, R.layout.jo, null);
            this.cDh = (ImageView) this.kgZ.findViewById(R.id.ai4);
            this.khd = (TextView) this.kgZ.findViewById(R.id.ai2);
            this.khb = (LinearLayout) this.kgZ.findViewById(R.id.ai3);
            this.khc = (LinearLayout) this.kgZ.findViewById(R.id.ai5);
            this.khb.setVisibility(8);
            this.khc.setVisibility(8);
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(1000);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.cDh.startAnimation(rotateAnimation);
        }
        cu();
        AppMethodBeat.o(88150);
    }

    private void bbI() {
        AppMethodBeat.i(88151);
        this.khb.setVisibility(8);
        this.khc.setVisibility(8);
        AppMethodBeat.o(88151);
    }

    public final void bbJ() {
        AppMethodBeat.i(88152);
        this.khb.setVisibility(0);
        this.khc.setVisibility(8);
        AppMethodBeat.o(88152);
    }

    public final void bbK() {
        AppMethodBeat.i(88153);
        this.khb.setVisibility(8);
        AppMethodBeat.o(88153);
    }

    private void bbL() {
        AppMethodBeat.i(88154);
        this.khb.setVisibility(8);
        this.khc.setVisibility(8);
        AppMethodBeat.o(88154);
    }

    public final void bbM() {
        AppMethodBeat.i(88155);
        bbL();
        this.khd.setVisibility(8);
        AppMethodBeat.o(88155);
    }

    public final void cu() {
        AppMethodBeat.i(88156);
        Integer num = (Integer) am.bbb().getValue("key_share_card_show_type");
        if (num == null) {
            num = Integer.valueOf(0);
        }
        if (this.kha != null && b.bby() && ((num.intValue() == 1 || num.intValue() == 4) && b.bbv())) {
            this.khd.setVisibility(0);
        } else {
            this.khd.setVisibility(8);
            if (this.kha != null) {
                ab.d("MicroMsg.ShareCardFooterController", "updateView isLocalEnd %s isOtherEnd %s ", Boolean.valueOf(b.bby()), Boolean.valueOf(b.bbz()));
                if (b.bby() && b.bbz()) {
                    if (b.bby() && b.bbz()) {
                        bbI();
                        AppMethodBeat.o(88156);
                        return;
                    }
                    AppMethodBeat.o(88156);
                }
                bbJ();
                AppMethodBeat.o(88156);
                return;
            }
        }
        bbL();
        AppMethodBeat.o(88156);
    }
}
