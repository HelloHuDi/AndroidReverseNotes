package com.tencent.mm.ui.widget.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class VoiceSeekBar extends RelativeLayout {
    protected View contentView = null;
    protected ImageView qyl;
    protected ImageView qym = null;
    protected ImageView zTE = null;
    protected float zTF = 0.0f;
    protected int zTG = 0;

    public VoiceSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(112965);
        init();
        AppMethodBeat.o(112965);
    }

    public VoiceSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(112966);
        init();
        AppMethodBeat.o(112966);
    }

    private void init() {
        AppMethodBeat.i(112967);
        this.contentView = View.inflate(getContext(), R.layout.b2_, this);
        this.qyl = (ImageView) this.contentView.findViewById(R.id.f2d);
        this.qym = (ImageView) this.contentView.findViewById(R.id.f2c);
        this.zTE = (ImageView) this.contentView.findViewById(R.id.f2e);
        this.qym.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(112964);
                VoiceSeekBar.this.qym.getViewTreeObserver().removeOnPreDrawListener(this);
                VoiceSeekBar.this.zTG = VoiceSeekBar.this.qym.getHeight();
                LayoutParams layoutParams = (LayoutParams) VoiceSeekBar.this.qyl.getLayoutParams();
                layoutParams.topMargin = (int) ((1.0f - VoiceSeekBar.this.zTF) * ((float) VoiceSeekBar.this.zTG));
                VoiceSeekBar.this.qyl.setLayoutParams(layoutParams);
                VoiceSeekBar.this.requestLayout();
                AppMethodBeat.o(112964);
                return false;
            }
        });
        AppMethodBeat.o(112967);
    }
}
