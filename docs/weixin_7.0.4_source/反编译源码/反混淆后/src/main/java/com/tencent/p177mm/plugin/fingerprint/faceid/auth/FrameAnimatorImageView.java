package com.tencent.p177mm.plugin.fingerprint.faceid.auth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView */
public class FrameAnimatorImageView extends ImageView {
    private Runnable mqP = null;
    private DrawFilter mqQ = new PaintFlagsDrawFilter(0, 3);

    /* renamed from: com.tencent.mm.plugin.fingerprint.faceid.auth.FrameAnimatorImageView$a */
    public interface C28050a {
        void onStop();
    }

    public FrameAnimatorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(41355);
        AppMethodBeat.m2505o(41355);
    }

    public FrameAnimatorImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(41356);
        AppMethodBeat.m2505o(41356);
    }

    /* renamed from: a */
    public final void mo45970a(int i, final C28050a c28050a) {
        int i2 = 0;
        AppMethodBeat.m2504i(41357);
        Drawable drawable = C4996ah.getContext().getResources().getDrawable(i);
        setImageDrawable(drawable);
        if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            animationDrawable.start();
            if (animationDrawable.isOneShot()) {
                int i3;
                int i4 = 0;
                while (true) {
                    i3 = i2;
                    if (i4 >= animationDrawable.getNumberOfFrames()) {
                        break;
                    }
                    i2 = animationDrawable.getDuration(i4) + i3;
                    i4++;
                }
                if (c28050a != null) {
                    this.mqP = new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(41354);
                            c28050a.onStop();
                            AppMethodBeat.m2505o(41354);
                        }
                    };
                    C5004al.m7442n(this.mqP, (long) i3);
                }
            }
        }
        AppMethodBeat.m2505o(41357);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.m2504i(41358);
        C5004al.m7439af(this.mqP);
        super.setImageDrawable(drawable);
        AppMethodBeat.m2505o(41358);
    }

    public void setImageResource(int i) {
        AppMethodBeat.m2504i(41359);
        C5004al.m7439af(this.mqP);
        super.setImageResource(i);
        AppMethodBeat.m2505o(41359);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(41360);
        C5004al.m7439af(this.mqP);
        super.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(41360);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(41361);
        canvas.setDrawFilter(this.mqQ);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(41361);
    }
}
