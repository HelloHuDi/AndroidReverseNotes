package com.tencent.p177mm.plugin.fav.p410ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.fav.ui.widget.b */
public final class C43088b {
    public View mpA;
    public ImageButton mpE;
    public ImageButton mpF;
    public ImageButton mpG;
    public C39083a mpH;
    public boolean mpz = false;

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.b$1 */
    public class C119181 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(74672);
            if (C43088b.this.mpH == null) {
                AppMethodBeat.m2505o(74672);
                return;
            }
            C43088b.this.mpH.bvS();
            AppMethodBeat.m2505o(74672);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.b$2 */
    public class C280352 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(74673);
            if (C43088b.this.mpH == null) {
                AppMethodBeat.m2505o(74673);
                return;
            }
            C43088b.this.mpH.bvT();
            AppMethodBeat.m2505o(74673);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.b$3 */
    public class C280363 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(74674);
            if (C43088b.this.mpH == null) {
                AppMethodBeat.m2505o(74674);
                return;
            }
            C43088b.this.mpH.bvB();
            AppMethodBeat.m2505o(74674);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.widget.b$a */
    public interface C39083a {
        void bvB();

        void bvS();

        void bvT();
    }

    public final void hide() {
        AppMethodBeat.m2504i(74675);
        if (this.mpz) {
            if (this.mpA.getVisibility() != 8) {
                this.mpA.setVisibility(8);
                this.mpA.startAnimation(AnimationUtils.loadAnimation(this.mpA.getContext(), C25738R.anim.f8333b6));
            }
            AppMethodBeat.m2505o(74675);
            return;
        }
        AppMethodBeat.m2505o(74675);
    }
}
