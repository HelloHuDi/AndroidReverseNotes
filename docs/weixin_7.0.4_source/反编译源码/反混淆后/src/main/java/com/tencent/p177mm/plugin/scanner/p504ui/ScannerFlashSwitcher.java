package com.tencent.p177mm.plugin.scanner.p504ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher */
public class ScannerFlashSwitcher extends LinearLayout {
    ImageView qgm;
    TextView qgn;
    boolean qgo = false;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher$3 */
    class C131443 extends AnimatorListenerAdapter {
        C131443() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(81321);
            ScannerFlashSwitcher.this.setVisibility(8);
            AppMethodBeat.m2505o(81321);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher$2 */
    class C131452 extends AnimatorListenerAdapter {
        C131452() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(81320);
            ScannerFlashSwitcher.this.qgm.setAlpha(1.0f);
            AppMethodBeat.m2505o(81320);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher$1 */
    class C131461 implements AnimatorUpdateListener {
        C131461() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(81319);
            ScannerFlashSwitcher.this.qgm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            AppMethodBeat.m2505o(81319);
        }
    }

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(81322);
        init();
        AppMethodBeat.m2505o(81322);
    }

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(81323);
        init();
        AppMethodBeat.m2505o(81323);
    }

    private void init() {
        AppMethodBeat.m2504i(81324);
        C5616v.m8409hu(getContext()).inflate(2130970553, this, true);
        this.qgm = (ImageView) findViewById(2131827227);
        this.qgn = (TextView) findViewById(2131827228);
        this.qgo = true;
        AppMethodBeat.m2505o(81324);
    }

    public final void hide() {
        AppMethodBeat.m2504i(81325);
        C4990ab.m7416i("MicroMsg.ScannerFlashSwitcher", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
        setEnabled(false);
        this.qgm.animate().alpha(0.0f).setDuration(500);
        this.qgn.animate().alpha(0.0f).setDuration(500).setListener(new C131443());
        AppMethodBeat.m2505o(81325);
    }

    public final void chJ() {
        AppMethodBeat.m2504i(81326);
        C4990ab.m7416i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
        this.qgm.setImageResource(C1318a.scanner_flash_open_normal);
        AppMethodBeat.m2505o(81326);
    }
}
