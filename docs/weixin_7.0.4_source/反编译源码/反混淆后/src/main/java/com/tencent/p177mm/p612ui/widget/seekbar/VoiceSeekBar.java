package com.tencent.p177mm.p612ui.widget.seekbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.widget.seekbar.VoiceSeekBar */
public class VoiceSeekBar extends RelativeLayout {
    protected View contentView = null;
    protected ImageView qyl;
    protected ImageView qym = null;
    protected ImageView zTE = null;
    protected float zTF = 0.0f;
    protected int zTG = 0;

    /* renamed from: com.tencent.mm.ui.widget.seekbar.VoiceSeekBar$1 */
    class C444041 implements OnPreDrawListener {
        C444041() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(112964);
            VoiceSeekBar.this.qym.getViewTreeObserver().removeOnPreDrawListener(this);
            VoiceSeekBar.this.zTG = VoiceSeekBar.this.qym.getHeight();
            LayoutParams layoutParams = (LayoutParams) VoiceSeekBar.this.qyl.getLayoutParams();
            layoutParams.topMargin = (int) ((1.0f - VoiceSeekBar.this.zTF) * ((float) VoiceSeekBar.this.zTG));
            VoiceSeekBar.this.qyl.setLayoutParams(layoutParams);
            VoiceSeekBar.this.requestLayout();
            AppMethodBeat.m2505o(112964);
            return false;
        }
    }

    public VoiceSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112965);
        init();
        AppMethodBeat.m2505o(112965);
    }

    public VoiceSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(112966);
        init();
        AppMethodBeat.m2505o(112966);
    }

    private void init() {
        AppMethodBeat.m2504i(112967);
        this.contentView = View.inflate(getContext(), 2130971024, this);
        this.qyl = (ImageView) this.contentView.findViewById(2131828475);
        this.qym = (ImageView) this.contentView.findViewById(2131828474);
        this.zTE = (ImageView) this.contentView.findViewById(2131828476);
        this.qym.getViewTreeObserver().addOnPreDrawListener(new C444041());
        AppMethodBeat.m2505o(112967);
    }
}
