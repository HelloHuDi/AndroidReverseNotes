package com.tencent.p177mm.plugin.appbrand.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.game.page.WAGamePageViewContainerLayout */
public class WAGamePageViewContainerLayout extends FrameLayout {
    private C10240b hsY;
    private C10239a hsZ;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.WAGamePageViewContainerLayout$a */
    interface C10239a {
        /* renamed from: a */
        void mo21648a(C10240b c10240b, C10240b c10240b2);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.page.WAGamePageViewContainerLayout$b */
    public enum C10240b {
        UNDEFINED,
        PORTRAIT,
        LANDSCAPE,
        PORTRAIT_REVERSE,
        LANDSCAPE_REVERSE;

        static {
            AppMethodBeat.m2505o(130277);
        }
    }

    public WAGamePageViewContainerLayout(Context context) {
        this(context, null);
    }

    public WAGamePageViewContainerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setOnConfigurationChangedListener(C10239a c10239a) {
        this.hsZ = c10239a;
    }

    public WAGamePageViewContainerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hsY = null;
        this.hsZ = null;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(130278);
        super.onLayout(z, i, i2, i3, i4);
        if (getContext() instanceof Activity) {
            C10240b c10240b;
            switch (((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation()) {
                case 0:
                    c10240b = C10240b.PORTRAIT;
                    break;
                case 1:
                    c10240b = C10240b.LANDSCAPE;
                    break;
                case 2:
                    c10240b = C10240b.PORTRAIT_REVERSE;
                    break;
                case 3:
                    c10240b = C10240b.LANDSCAPE_REVERSE;
                    break;
                default:
                    C4990ab.m7413e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", Integer.valueOf(((Activity) getContext()).getWindowManager().getDefaultDisplay().getRotation()));
                    c10240b = C10240b.UNDEFINED;
                    break;
            }
            if (this.hsZ != null) {
                this.hsZ.mo21648a(this.hsY, c10240b);
            }
            this.hsY = c10240b;
        }
        AppMethodBeat.m2505o(130278);
    }
}
