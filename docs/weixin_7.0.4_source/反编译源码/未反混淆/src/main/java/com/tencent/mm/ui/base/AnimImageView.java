package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bz.a;

public class AnimImageView extends TextView {
    private Context context;
    private boolean isRunning = false;
    private AlphaAnimation mhK;
    private AnimationDrawable mhL;
    private int type = 1;
    private boolean ysk = false;
    private AnimationDrawable ysl;

    public void setType(int i) {
        AppMethodBeat.i(29996);
        this.type = i;
        if (this.ysk) {
            if (i == 2) {
                setBackgroundResource(R.color.ig);
                AppMethodBeat.o(29996);
                return;
            }
            setBackgroundDrawable(a.g(this.context, R.drawable.hz));
            AppMethodBeat.o(29996);
        } else if (i == 2) {
            setBackgroundResource(R.color.ih);
            AppMethodBeat.o(29996);
        } else {
            setBackgroundDrawable(a.g(this.context, R.drawable.j4));
            AppMethodBeat.o(29996);
        }
    }

    public final void dzr() {
        AppMethodBeat.i(29997);
        switch (this.type) {
            case 0:
                if (this.ysk) {
                    setBackgroundDrawable(a.g(this.context, R.drawable.hz));
                } else {
                    setBackgroundDrawable(a.g(this.context, R.drawable.j4));
                }
                setAnimation(this.mhK);
                this.mhK.startNow();
                break;
            case 1:
                break;
            case 2:
                if (!this.ysk) {
                    setBackgroundResource(R.color.ih);
                    break;
                } else {
                    setBackgroundResource(R.color.ig);
                    break;
                }
        }
        if (!this.isRunning) {
            this.isRunning = true;
            if (this.ysk) {
                setCompoundDrawablesWithIntrinsicBounds(this.mhL, null, null, null);
                this.mhL.stop();
                this.mhL.start();
                AppMethodBeat.o(29997);
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds(null, null, this.ysl, null);
            this.ysl.stop();
            this.ysl.start();
            AppMethodBeat.o(29997);
            return;
        }
        AppMethodBeat.o(29997);
    }

    public void setFromVoice(boolean z) {
        this.ysk = z;
    }

    public void setFromGroup(boolean z) {
    }

    public final void ceT() {
        AppMethodBeat.i(29998);
        if (this.mhK != null && this.mhK.isInitialized()) {
            setAnimation(null);
        }
        if (this.type == 1 || this.type == 2) {
            this.isRunning = false;
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            this.mhL.stop();
            this.ysl.stop();
        }
        AppMethodBeat.o(29998);
    }

    public AnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29999);
        this.context = context;
        bvA();
        AppMethodBeat.o(29999);
    }

    public AnimImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(30000);
        this.context = context;
        bvA();
        AppMethodBeat.o(30000);
    }

    private void bvA() {
        AppMethodBeat.i(CdnLogic.kMediaLittleAppPacket);
        this.mhK = new AlphaAnimation(0.1f, 1.0f);
        this.mhK.setDuration(1000);
        this.mhK.setRepeatCount(-1);
        this.mhK.setRepeatMode(2);
        this.mhL = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(R.raw.chatfrom_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.raw.chatfrom_voice_playing_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.raw.chatfrom_voice_playing_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        this.mhL.setOneShot(false);
        this.mhL.setVisible(true, true);
        this.ysl = new AnimationDrawable();
        drawable = getResources().getDrawable(R.raw.chatto_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.ysl.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.raw.chatto_voice_playing_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.ysl.addFrame(drawable, 300);
        drawable = getResources().getDrawable(R.raw.chatto_voice_playing_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.ysl.addFrame(drawable, 300);
        this.ysl.setOneShot(false);
        this.ysl.setVisible(true, true);
        AppMethodBeat.o(CdnLogic.kMediaLittleAppPacket);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(CdnLogic.kMediaGamePacket);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.o(CdnLogic.kMediaGamePacket);
        } catch (Throwable th) {
            AppMethodBeat.o(CdnLogic.kMediaGamePacket);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(30003);
        try {
            super.onDraw(canvas);
            AppMethodBeat.o(30003);
        } catch (Throwable th) {
            AppMethodBeat.o(30003);
        }
    }

    public int getBaseline() {
        AppMethodBeat.i(30004);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.o(30004);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.o(30004);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.i(30005);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.o(30005);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.o(30005);
            return true;
        }
    }
}
