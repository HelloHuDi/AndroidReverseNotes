package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class b {
    public View mpA;
    public ImageButton mpE;
    public ImageButton mpF;
    public ImageButton mpG;
    public a mpH;
    public boolean mpz = false;

    public interface a {
        void bvB();

        void bvS();

        void bvT();
    }

    public final void hide() {
        AppMethodBeat.i(74675);
        if (this.mpz) {
            if (this.mpA.getVisibility() != 8) {
                this.mpA.setVisibility(8);
                this.mpA.startAnimation(AnimationUtils.loadAnimation(this.mpA.getContext(), R.anim.b6));
            }
            AppMethodBeat.o(74675);
            return;
        }
        AppMethodBeat.o(74675);
    }
}
