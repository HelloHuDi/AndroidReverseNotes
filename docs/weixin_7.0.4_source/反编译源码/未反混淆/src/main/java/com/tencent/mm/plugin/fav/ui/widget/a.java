package com.tencent.mm.plugin.fav.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.sdk.platformtools.aa;

public final class a {
    public Button gzI;
    public TextView kxJ;
    public View mpA;
    public a mpB;
    public long mpx = b.buh();
    public boolean mpz = false;

    public interface a {
        void bvB();
    }

    public a() {
        AppMethodBeat.i(74666);
        AppMethodBeat.o(74666);
    }

    public final void show() {
        AppMethodBeat.i(74667);
        if (!this.mpz) {
            if (this.mpA == null) {
                AppMethodBeat.o(74667);
                return;
            }
            if (this.mpA instanceof ViewStub) {
                this.mpA = ((ViewStub) this.mpA).inflate();
            }
            this.kxJ = (TextView) this.mpA.findViewById(R.id.bp6);
            if (!aa.don()) {
                this.kxJ.setTextSize(1, 14.0f);
            }
            this.gzI = (Button) this.mpA.findViewById(R.id.bp7);
            bwz();
            this.gzI.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(74665);
                    if (a.this.mpB == null) {
                        AppMethodBeat.o(74665);
                        return;
                    }
                    a.this.mpB.bvB();
                    AppMethodBeat.o(74665);
                }
            });
            this.mpz = true;
        }
        if (this.mpA.getVisibility() != 0) {
            this.mpA.setVisibility(0);
            this.mpA.startAnimation(AnimationUtils.loadAnimation(this.mpA.getContext(), R.anim.b5));
        }
        AppMethodBeat.o(74667);
    }

    public final void hide() {
        AppMethodBeat.i(74668);
        if (this.mpz) {
            if (this.mpA.getVisibility() != 8) {
                this.mpA.setVisibility(8);
                this.mpA.startAnimation(AnimationUtils.loadAnimation(this.mpA.getContext(), R.anim.b6));
            }
            AppMethodBeat.o(74668);
            return;
        }
        AppMethodBeat.o(74668);
    }

    public final void bwz() {
        AppMethodBeat.i(74669);
        this.kxJ.setText(this.kxJ.getContext().getString(R.string.bn4, new Object[]{b.iv(this.mpx)}));
        this.gzI.setEnabled(false);
        AppMethodBeat.o(74669);
    }
}
