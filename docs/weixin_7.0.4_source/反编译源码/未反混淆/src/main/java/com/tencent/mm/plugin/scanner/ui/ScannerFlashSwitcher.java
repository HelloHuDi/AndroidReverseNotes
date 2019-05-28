package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.v;

public class ScannerFlashSwitcher extends LinearLayout {
    ImageView qgm;
    TextView qgn;
    boolean qgo = false;

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(81322);
        init();
        AppMethodBeat.o(81322);
    }

    public ScannerFlashSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(81323);
        init();
        AppMethodBeat.o(81323);
    }

    private void init() {
        AppMethodBeat.i(81324);
        v.hu(getContext()).inflate(R.layout.apl, this, true);
        this.qgm = (ImageView) findViewById(R.id.e5n);
        this.qgn = (TextView) findViewById(R.id.e5o);
        this.qgo = true;
        AppMethodBeat.o(81324);
    }

    public final void hide() {
        AppMethodBeat.i(81325);
        ab.i("MicroMsg.ScannerFlashSwitcher", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
        setEnabled(false);
        this.qgm.animate().alpha(0.0f).setDuration(500);
        this.qgn.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(81321);
                ScannerFlashSwitcher.this.setVisibility(8);
                AppMethodBeat.o(81321);
            }
        });
        AppMethodBeat.o(81325);
    }

    public final void chJ() {
        AppMethodBeat.i(81326);
        ab.i("MicroMsg.ScannerFlashSwitcher", "closeFlashStatus");
        this.qgm.setImageResource(R.raw.scanner_flash_open_normal);
        AppMethodBeat.o(81326);
    }
}
