package com.bumptech.glide.c.d.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.bumptech.glide.c.d.e.g.b;
import com.bumptech.glide.c.m;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import java.nio.ByteBuffer;

public class c extends Drawable implements Animatable, b {
    boolean aBU;
    final a aFU;
    private boolean aFV;
    private int aFW;
    private boolean aFX;
    private Paint aFY;
    private Rect aFZ;
    private int ayk;
    private boolean isRunning;
    private boolean isVisible;

    static final class a extends ConstantState {
        final g aGa;

        a(g gVar) {
            this.aGa = gVar;
        }

        public final Drawable newDrawable(Resources resources) {
            AppMethodBeat.i(92313);
            Drawable newDrawable = newDrawable();
            AppMethodBeat.o(92313);
            return newDrawable;
        }

        public final Drawable newDrawable() {
            AppMethodBeat.i(92314);
            c cVar = new c(this);
            AppMethodBeat.o(92314);
            return cVar;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public c(Context context, com.bumptech.glide.b.a aVar, m<Bitmap> mVar, int i, int i2, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.ae(context), aVar, i, i2, (m) mVar, bitmap)));
        AppMethodBeat.i(92315);
        AppMethodBeat.o(92315);
    }

    c(a aVar) {
        AppMethodBeat.i(92316);
        this.isVisible = true;
        this.aFW = -1;
        this.aFU = (a) i.d(aVar, "Argument must not be null");
        AppMethodBeat.o(92316);
    }

    public final Bitmap ny() {
        return this.aFU.aGa.aGi;
    }

    public final ByteBuffer getBuffer() {
        AppMethodBeat.i(92317);
        ByteBuffer asReadOnlyBuffer = this.aFU.aGa.aGb.getData().asReadOnlyBuffer();
        AppMethodBeat.o(92317);
        return asReadOnlyBuffer;
    }

    public void start() {
        AppMethodBeat.i(92318);
        this.aFV = true;
        this.ayk = 0;
        if (this.isVisible) {
            nz();
        }
        AppMethodBeat.o(92318);
    }

    public void stop() {
        AppMethodBeat.i(92319);
        this.aFV = false;
        nA();
        AppMethodBeat.o(92319);
    }

    private void nz() {
        AppMethodBeat.i(92320);
        i.b(!this.aBU, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.aFU.aGa.getFrameCount() == 1) {
            invalidateSelf();
            AppMethodBeat.o(92320);
            return;
        }
        if (!this.isRunning) {
            this.isRunning = true;
            this.aFU.aGa.a((b) this);
            invalidateSelf();
        }
        AppMethodBeat.o(92320);
    }

    private void nA() {
        AppMethodBeat.i(92321);
        this.isRunning = false;
        this.aFU.aGa.b(this);
        AppMethodBeat.o(92321);
    }

    public boolean setVisible(boolean z, boolean z2) {
        AppMethodBeat.i(92322);
        i.b(!this.aBU, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = z;
        if (!z) {
            nA();
        } else if (this.aFV) {
            nz();
        }
        boolean visible = super.setVisible(z, z2);
        AppMethodBeat.o(92322);
        return visible;
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.i(92323);
        int width = this.aFU.aGa.nD().getWidth();
        AppMethodBeat.o(92323);
        return width;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.i(92324);
        int height = this.aFU.aGa.nD().getHeight();
        AppMethodBeat.o(92324);
        return height;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        AppMethodBeat.i(92325);
        super.onBoundsChange(rect);
        this.aFX = true;
        AppMethodBeat.o(92325);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(92326);
        if (this.aBU) {
            AppMethodBeat.o(92326);
            return;
        }
        if (this.aFX) {
            Gravity.apply(d.MIC_AVROUND_BLUR, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), nB());
            this.aFX = false;
        }
        canvas.drawBitmap(this.aFU.aGa.nD(), null, nB(), getPaint());
        AppMethodBeat.o(92326);
    }

    public void setAlpha(int i) {
        AppMethodBeat.i(92327);
        getPaint().setAlpha(i);
        AppMethodBeat.o(92327);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.i(92328);
        getPaint().setColorFilter(colorFilter);
        AppMethodBeat.o(92328);
    }

    private Rect nB() {
        AppMethodBeat.i(92329);
        if (this.aFZ == null) {
            this.aFZ = new Rect();
        }
        Rect rect = this.aFZ;
        AppMethodBeat.o(92329);
        return rect;
    }

    private Paint getPaint() {
        AppMethodBeat.i(92330);
        if (this.aFY == null) {
            this.aFY = new Paint(2);
        }
        Paint paint = this.aFY;
        AppMethodBeat.o(92330);
        return paint;
    }

    public int getOpacity() {
        return -2;
    }

    public ConstantState getConstantState() {
        return this.aFU;
    }

    public final void nC() {
        AppMethodBeat.i(92331);
        Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            AppMethodBeat.o(92331);
            return;
        }
        int i;
        invalidateSelf();
        g gVar = this.aFU.aGa;
        if (gVar.aGf != null) {
            i = gVar.aGf.index;
        } else {
            i = -1;
        }
        if (i == this.aFU.aGa.getFrameCount() - 1) {
            this.ayk++;
        }
        if (this.aFW != -1 && this.ayk >= this.aFW) {
            stop();
        }
        AppMethodBeat.o(92331);
    }
}
