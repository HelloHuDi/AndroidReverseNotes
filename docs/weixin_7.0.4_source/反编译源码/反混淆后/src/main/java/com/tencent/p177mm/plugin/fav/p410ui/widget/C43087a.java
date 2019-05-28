package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.a */
public final class C43087a {
    public Button gzI;
    public TextView kxJ;
    public View mpA;
    public C3110a mpB;
    public long mpx = C39037b.buh();
    public boolean mpz = false;

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.a$a */
    public interface C3110a {
        void bvB();
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.a$1 */
    class C390821 implements OnClickListener {
        C390821() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(74665);
            if (C43087a.this.mpB == null) {
                AppMethodBeat.m2505o(74665);
                return;
            }
            C43087a.this.mpB.bvB();
            AppMethodBeat.m2505o(74665);
        }
    }

    public C43087a() {
        AppMethodBeat.m2504i(74666);
        AppMethodBeat.m2505o(74666);
    }

    public final void show() {
        AppMethodBeat.m2504i(74667);
        if (!this.mpz) {
            if (this.mpA == null) {
                AppMethodBeat.m2505o(74667);
                return;
            }
            if (this.mpA instanceof ViewStub) {
                this.mpA = ((ViewStub) this.mpA).inflate();
            }
            this.kxJ = (TextView) this.mpA.findViewById(2131823880);
            if (!C4988aa.don()) {
                this.kxJ.setTextSize(1, 14.0f);
            }
            this.gzI = (Button) this.mpA.findViewById(2131823881);
            bwz();
            this.gzI.setOnClickListener(new C390821());
            this.mpz = true;
        }
        if (this.mpA.getVisibility() != 0) {
            this.mpA.setVisibility(0);
            this.mpA.startAnimation(AnimationUtils.loadAnimation(this.mpA.getContext(), C25738R.anim.f8332b5));
        }
        AppMethodBeat.m2505o(74667);
    }

    public final void hide() {
        AppMethodBeat.m2504i(74668);
        if (this.mpz) {
            if (this.mpA.getVisibility() != 8) {
                this.mpA.setVisibility(8);
                this.mpA.startAnimation(AnimationUtils.loadAnimation(this.mpA.getContext(), C25738R.anim.f8333b6));
            }
            AppMethodBeat.m2505o(74668);
            return;
        }
        AppMethodBeat.m2505o(74668);
    }

    public final void bwz() {
        AppMethodBeat.m2504i(74669);
        this.kxJ.setText(this.kxJ.getContext().getString(C25738R.string.bn4, new Object[]{C39037b.m66407iv(this.mpx)}));
        this.gzI.setEnabled(false);
        AppMethodBeat.m2505o(74669);
    }
}
