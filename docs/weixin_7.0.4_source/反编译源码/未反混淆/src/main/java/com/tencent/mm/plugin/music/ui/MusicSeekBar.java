package com.tencent.mm.plugin.music.ui;

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
import com.tencent.mm.R;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class MusicSeekBar extends FrameLayout {
    private Context context;
    boolean isLoading;
    private TextView oPd;
    private TextView oPe;
    private SeekBar oPf;
    ValueAnimator oPg;
    boolean oPh;
    c oPi;
    Drawable oPj;
    private a oPk;

    interface a {
        void zV(int i);
    }

    public MusicSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(105127);
        this.oPh = false;
        this.isLoading = false;
        this.context = context;
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.ai4, this);
        this.oPd = (TextView) inflate.findViewById(R.id.dfr);
        this.oPe = (TextView) inflate.findViewById(R.id.cal);
        this.oPf = (SeekBar) inflate.findViewById(R.id.dfs);
        this.oPd.setText("00:00");
        this.oPe.setText("--:--");
        this.oPi = new c(getResources().getDrawable(R.drawable.bcl));
        this.oPj = getResources().getDrawable(R.drawable.vv);
        AppMethodBeat.o(105127);
    }

    public void setOnSeekBarChange(a aVar) {
        this.oPk = aVar;
    }

    public final void jA(boolean z) {
        AppMethodBeat.i(105128);
        if (this.oPg == null) {
            this.oPg = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
            this.oPg.setTarget(this.oPf);
            this.oPg.setRepeatCount(100);
            this.oPg.setDuration(5000);
            this.oPg.setInterpolator(new LinearInterpolator());
            this.oPg.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(105125);
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    c cVar = MusicSeekBar.this.oPi;
                    cVar.oPn = floatValue;
                    cVar.invalidateSelf();
                    MusicSeekBar.this.oPf.setThumb(MusicSeekBar.this.oPi);
                    AppMethodBeat.o(105125);
                }
            });
        }
        this.isLoading = z;
        if (z) {
            this.oPg.start();
            AppMethodBeat.o(105128);
            return;
        }
        this.oPg.cancel();
        this.oPf.setThumb(this.oPj);
        AppMethodBeat.o(105128);
    }

    public void setColor(int i) {
        AppMethodBeat.i(105129);
        this.oPd.setTextColor(i);
        this.oPe.setTextColor(i);
        this.oPf.getProgressDrawable().setColorFilter(i, Mode.MULTIPLY);
        this.oPf.getThumb().setColorFilter(i, Mode.MULTIPLY);
        this.oPj.setColorFilter(i, Mode.MULTIPLY);
        this.oPi.setColorFilter(i, Mode.MULTIPLY);
        this.oPf.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            }

            public final void onStartTrackingTouch(SeekBar seekBar) {
                MusicSeekBar.this.oPh = true;
            }

            public final void onStopTrackingTouch(SeekBar seekBar) {
                AppMethodBeat.i(105126);
                MusicSeekBar.this.oPh = false;
                if (MusicSeekBar.this.oPk != null) {
                    MusicSeekBar.this.oPk.zV(seekBar.getProgress());
                }
                AppMethodBeat.o(105126);
            }
        });
        AppMethodBeat.o(105129);
    }

    public void setProgress(int i) {
        AppMethodBeat.i(105130);
        if (this.isLoading || this.oPh) {
            AppMethodBeat.o(105130);
            return;
        }
        this.oPd.setText(zW(i));
        this.oPf.setProgress(i);
        AppMethodBeat.o(105130);
    }

    public void setMaxProgress(int i) {
        AppMethodBeat.i(105131);
        this.oPe.setText(zW(i));
        this.oPf.setMax(i);
        AppMethodBeat.o(105131);
    }

    private static String zW(int i) {
        AppMethodBeat.i(105132);
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
        AppMethodBeat.o(105132);
        return stringBuilder2;
    }
}
