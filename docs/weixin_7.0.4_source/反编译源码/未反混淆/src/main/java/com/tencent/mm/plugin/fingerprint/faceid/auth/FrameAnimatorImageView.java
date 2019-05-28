package com.tencent.mm.plugin.fingerprint.faceid.auth;

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
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;

public class FrameAnimatorImageView extends ImageView {
    private Runnable mqP = null;
    private DrawFilter mqQ = new PaintFlagsDrawFilter(0, 3);

    public interface a {
        void onStop();
    }

    public FrameAnimatorImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41355);
        AppMethodBeat.o(41355);
    }

    public FrameAnimatorImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(41356);
        AppMethodBeat.o(41356);
    }

    public final void a(int i, final a aVar) {
        int i2 = 0;
        AppMethodBeat.i(41357);
        Drawable drawable = ah.getContext().getResources().getDrawable(i);
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
                if (aVar != null) {
                    this.mqP = new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(41354);
                            aVar.onStop();
                            AppMethodBeat.o(41354);
                        }
                    };
                    al.n(this.mqP, (long) i3);
                }
            }
        }
        AppMethodBeat.o(41357);
    }

    public void setImageDrawable(Drawable drawable) {
        AppMethodBeat.i(41358);
        al.af(this.mqP);
        super.setImageDrawable(drawable);
        AppMethodBeat.o(41358);
    }

    public void setImageResource(int i) {
        AppMethodBeat.i(41359);
        al.af(this.mqP);
        super.setImageResource(i);
        AppMethodBeat.o(41359);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(41360);
        al.af(this.mqP);
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(41360);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(41361);
        canvas.setDrawFilter(this.mqQ);
        super.onDraw(canvas);
        AppMethodBeat.o(41361);
    }
}
