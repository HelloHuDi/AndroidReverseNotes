package com.tencent.p177mm.plugin.music.p467ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.music.ui.MusicSeekBar */
public class MusicSeekBar extends FrameLayout {
    private Context context;
    boolean isLoading;
    private TextView oPd;
    private TextView oPe;
    private SeekBar oPf;
    ValueAnimator oPg;
    boolean oPh;
    C34600c oPi;
    Drawable oPj;
    private C12687a oPk;

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicSeekBar$1 */
    class C126851 implements AnimatorUpdateListener {
        C126851() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(105125);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C34600c c34600c = MusicSeekBar.this.oPi;
            c34600c.oPn = floatValue;
            c34600c.invalidateSelf();
            MusicSeekBar.this.oPf.setThumb(MusicSeekBar.this.oPi);
            AppMethodBeat.m2505o(105125);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicSeekBar$2 */
    class C126862 implements OnSeekBarChangeListener {
        C126862() {
        }

        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            MusicSeekBar.this.oPh = true;
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            AppMethodBeat.m2504i(105126);
            MusicSeekBar.this.oPh = false;
            if (MusicSeekBar.this.oPk != null) {
                MusicSeekBar.this.oPk.mo24659zV(seekBar.getProgress());
            }
            AppMethodBeat.m2505o(105126);
        }
    }

    /* renamed from: com.tencent.mm.plugin.music.ui.MusicSeekBar$a */
    interface C12687a {
        /* renamed from: zV */
        void mo24659zV(int i);
    }

    public MusicSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(105127);
        this.oPh = false;
        this.isLoading = false;
        this.context = context;
        View inflate = LayoutInflater.from(this.context).inflate(2130970275, this);
        this.oPd = (TextView) inflate.findViewById(2131826269);
        this.oPe = (TextView) inflate.findViewById(2131824710);
        this.oPf = (SeekBar) inflate.findViewById(2131826270);
        this.oPd.setText("00:00");
        this.oPe.setText("--:--");
        this.oPi = new C34600c(getResources().getDrawable(C25738R.drawable.bcl));
        this.oPj = getResources().getDrawable(C25738R.drawable.f6934vv);
        AppMethodBeat.m2505o(105127);
    }

    public void setOnSeekBarChange(C12687a c12687a) {
        this.oPk = c12687a;
    }

    /* renamed from: jA */
    public final void mo24660jA(boolean z) {
        AppMethodBeat.m2504i(105128);
        if (this.oPg == null) {
            this.oPg = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
            this.oPg.setTarget(this.oPf);
            this.oPg.setRepeatCount(100);
            this.oPg.setDuration(5000);
            this.oPg.setInterpolator(new LinearInterpolator());
            this.oPg.addUpdateListener(new C126851());
        }
        this.isLoading = z;
        if (z) {
            this.oPg.start();
            AppMethodBeat.m2505o(105128);
            return;
        }
        this.oPg.cancel();
        this.oPf.setThumb(this.oPj);
        AppMethodBeat.m2505o(105128);
    }

    public void setColor(int i) {
        AppMethodBeat.m2504i(105129);
        this.oPd.setTextColor(i);
        this.oPe.setTextColor(i);
        this.oPf.getProgressDrawable().setColorFilter(i, Mode.MULTIPLY);
        this.oPf.getThumb().setColorFilter(i, Mode.MULTIPLY);
        this.oPj.setColorFilter(i, Mode.MULTIPLY);
        this.oPi.setColorFilter(i, Mode.MULTIPLY);
        this.oPf.setOnSeekBarChangeListener(new C126862());
        AppMethodBeat.m2505o(105129);
    }

    public void setProgress(int i) {
        AppMethodBeat.m2504i(105130);
        if (this.isLoading || this.oPh) {
            AppMethodBeat.m2505o(105130);
            return;
        }
        this.oPd.setText(MusicSeekBar.m20698zW(i));
        this.oPf.setProgress(i);
        AppMethodBeat.m2505o(105130);
    }

    public void setMaxProgress(int i) {
        AppMethodBeat.m2504i(105131);
        this.oPe.setText(MusicSeekBar.m20698zW(i));
        this.oPf.setMax(i);
        AppMethodBeat.m2505o(105131);
    }

    /* renamed from: zW */
    private static String m20698zW(int i) {
        AppMethodBeat.m2504i(105132);
        StringBuilder stringBuilder = new StringBuilder();
        long j = (long) (i / 60000);
        long floor = (long) Math.floor((double) (((long) (i % 60000)) / 1000));
        if (j < 10) {
            stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        stringBuilder.append(j + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        if (floor < 10) {
            stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        stringBuilder.append(floor);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(105132);
        return stringBuilder2;
    }
}
