package com.tencent.p177mm.p612ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p208bz.C1338a;

/* renamed from: com.tencent.mm.ui.base.AnimImageView */
public class AnimImageView extends TextView {
    private Context context;
    private boolean isRunning = false;
    private AlphaAnimation mhK;
    private AnimationDrawable mhL;
    private int type = 1;
    private boolean ysk = false;
    private AnimationDrawable ysl;

    public void setType(int i) {
        AppMethodBeat.m2504i(29996);
        this.type = i;
        if (this.ysk) {
            if (i == 2) {
                setBackgroundResource(C25738R.color.f11823ig);
                AppMethodBeat.m2505o(29996);
                return;
            }
            setBackgroundDrawable(C1338a.m2864g(this.context, C25738R.drawable.f6554hz));
            AppMethodBeat.m2505o(29996);
        } else if (i == 2) {
            setBackgroundResource(C25738R.color.f11824ih);
            AppMethodBeat.m2505o(29996);
        } else {
            setBackgroundDrawable(C1338a.m2864g(this.context, C25738R.drawable.f6589j4));
            AppMethodBeat.m2505o(29996);
        }
    }

    public final void dzr() {
        AppMethodBeat.m2504i(29997);
        switch (this.type) {
            case 0:
                if (this.ysk) {
                    setBackgroundDrawable(C1338a.m2864g(this.context, C25738R.drawable.f6554hz));
                } else {
                    setBackgroundDrawable(C1338a.m2864g(this.context, C25738R.drawable.f6589j4));
                }
                setAnimation(this.mhK);
                this.mhK.startNow();
                break;
            case 1:
                break;
            case 2:
                if (!this.ysk) {
                    setBackgroundResource(C25738R.color.f11824ih);
                    break;
                } else {
                    setBackgroundResource(C25738R.color.f11823ig);
                    break;
                }
        }
        if (!this.isRunning) {
            this.isRunning = true;
            if (this.ysk) {
                setCompoundDrawablesWithIntrinsicBounds(this.mhL, null, null, null);
                this.mhL.stop();
                this.mhL.start();
                AppMethodBeat.m2505o(29997);
                return;
            }
            setCompoundDrawablesWithIntrinsicBounds(null, null, this.ysl, null);
            this.ysl.stop();
            this.ysl.start();
            AppMethodBeat.m2505o(29997);
            return;
        }
        AppMethodBeat.m2505o(29997);
    }

    public void setFromVoice(boolean z) {
        this.ysk = z;
    }

    public void setFromGroup(boolean z) {
    }

    public final void ceT() {
        AppMethodBeat.m2504i(29998);
        if (this.mhK != null && this.mhK.isInitialized()) {
            setAnimation(null);
        }
        if (this.type == 1 || this.type == 2) {
            this.isRunning = false;
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            this.mhL.stop();
            this.ysl.stop();
        }
        AppMethodBeat.m2505o(29998);
    }

    public AnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(29999);
        this.context = context;
        bvA();
        AppMethodBeat.m2505o(29999);
    }

    public AnimImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(30000);
        this.context = context;
        bvA();
        AppMethodBeat.m2505o(30000);
    }

    private void bvA() {
        AppMethodBeat.m2504i(CdnLogic.kMediaLittleAppPacket);
        this.mhK = new AlphaAnimation(0.1f, 1.0f);
        this.mhK.setDuration(1000);
        this.mhK.setRepeatCount(-1);
        this.mhK.setRepeatMode(2);
        this.mhL = new AnimationDrawable();
        Drawable drawable = getResources().getDrawable(C1318a.chatfrom_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        drawable = getResources().getDrawable(C1318a.chatfrom_voice_playing_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        drawable = getResources().getDrawable(C1318a.chatfrom_voice_playing_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.mhL.addFrame(drawable, 300);
        this.mhL.setOneShot(false);
        this.mhL.setVisible(true, true);
        this.ysl = new AnimationDrawable();
        drawable = getResources().getDrawable(C1318a.chatto_voice_playing_f1);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.ysl.addFrame(drawable, 300);
        drawable = getResources().getDrawable(C1318a.chatto_voice_playing_f2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.ysl.addFrame(drawable, 300);
        drawable = getResources().getDrawable(C1318a.chatto_voice_playing_f3);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.ysl.addFrame(drawable, 300);
        this.ysl.setOneShot(false);
        this.ysl.setVisible(true, true);
        AppMethodBeat.m2505o(CdnLogic.kMediaLittleAppPacket);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(CdnLogic.kMediaGamePacket);
        try {
            super.onMeasure(i, i2);
            AppMethodBeat.m2505o(CdnLogic.kMediaGamePacket);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(CdnLogic.kMediaGamePacket);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(30003);
        try {
            super.onDraw(canvas);
            AppMethodBeat.m2505o(30003);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(30003);
        }
    }

    public int getBaseline() {
        AppMethodBeat.m2504i(30004);
        try {
            int baseline = super.getBaseline();
            AppMethodBeat.m2505o(30004);
            return baseline;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(30004);
            return -1;
        }
    }

    public boolean onPreDraw() {
        AppMethodBeat.m2504i(30005);
        try {
            boolean onPreDraw = super.onPreDraw();
            AppMethodBeat.m2505o(30005);
            return onPreDraw;
        } catch (Throwable th) {
            AppMethodBeat.m2505o(30005);
            return true;
        }
    }
}
