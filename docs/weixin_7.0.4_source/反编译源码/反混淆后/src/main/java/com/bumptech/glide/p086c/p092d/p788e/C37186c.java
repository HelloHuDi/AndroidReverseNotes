package com.bumptech.glide.p086c.p092d.p788e;

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
import com.bumptech.glide.C8555c;
import com.bumptech.glide.p085b.C25400a;
import com.bumptech.glide.p086c.C31970m;
import com.bumptech.glide.p086c.p092d.p788e.C25452g.C8552b;
import com.bumptech.glide.p095h.C8561i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import java.nio.ByteBuffer;

/* renamed from: com.bumptech.glide.c.d.e.c */
public class C37186c extends Drawable implements Animatable, C8552b {
    boolean aBU;
    final C25450a aFU;
    private boolean aFV;
    private int aFW;
    private boolean aFX;
    private Paint aFY;
    private Rect aFZ;
    private int ayk;
    private boolean isRunning;
    private boolean isVisible;

    /* renamed from: com.bumptech.glide.c.d.e.c$a */
    static final class C25450a extends ConstantState {
        final C25452g aGa;

        C25450a(C25452g c25452g) {
            this.aGa = c25452g;
        }

        public final Drawable newDrawable(Resources resources) {
            AppMethodBeat.m2504i(92313);
            Drawable newDrawable = newDrawable();
            AppMethodBeat.m2505o(92313);
            return newDrawable;
        }

        public final Drawable newDrawable() {
            AppMethodBeat.m2504i(92314);
            C37186c c37186c = new C37186c(this);
            AppMethodBeat.m2505o(92314);
            return c37186c;
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    public C37186c(Context context, C25400a c25400a, C31970m<Bitmap> c31970m, int i, int i2, Bitmap bitmap) {
        this(new C25450a(new C25452g(C8555c.m15204ae(context), c25400a, i, i2, (C31970m) c31970m, bitmap)));
        AppMethodBeat.m2504i(92315);
        AppMethodBeat.m2505o(92315);
    }

    C37186c(C25450a c25450a) {
        AppMethodBeat.m2504i(92316);
        this.isVisible = true;
        this.aFW = -1;
        this.aFU = (C25450a) C8561i.m15217d(c25450a, "Argument must not be null");
        AppMethodBeat.m2505o(92316);
    }

    /* renamed from: ny */
    public final Bitmap mo59276ny() {
        return this.aFU.aGa.aGi;
    }

    public final ByteBuffer getBuffer() {
        AppMethodBeat.m2504i(92317);
        ByteBuffer asReadOnlyBuffer = this.aFU.aGa.aGb.getData().asReadOnlyBuffer();
        AppMethodBeat.m2505o(92317);
        return asReadOnlyBuffer;
    }

    public void start() {
        AppMethodBeat.m2504i(92318);
        this.aFV = true;
        this.ayk = 0;
        if (this.isVisible) {
            m62331nz();
        }
        AppMethodBeat.m2505o(92318);
    }

    public void stop() {
        AppMethodBeat.m2504i(92319);
        this.aFV = false;
        m62329nA();
        AppMethodBeat.m2505o(92319);
    }

    /* renamed from: nz */
    private void m62331nz() {
        AppMethodBeat.m2504i(92320);
        C8561i.m15215b(!this.aBU, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.aFU.aGa.getFrameCount() == 1) {
            invalidateSelf();
            AppMethodBeat.m2505o(92320);
            return;
        }
        if (!this.isRunning) {
            this.isRunning = true;
            this.aFU.aGa.mo42488a((C8552b) this);
            invalidateSelf();
        }
        AppMethodBeat.m2505o(92320);
    }

    /* renamed from: nA */
    private void m62329nA() {
        AppMethodBeat.m2504i(92321);
        this.isRunning = false;
        this.aFU.aGa.mo42490b(this);
        AppMethodBeat.m2505o(92321);
    }

    public boolean setVisible(boolean z, boolean z2) {
        AppMethodBeat.m2504i(92322);
        C8561i.m15215b(!this.aBU, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.isVisible = z;
        if (!z) {
            m62329nA();
        } else if (this.aFV) {
            m62331nz();
        }
        boolean visible = super.setVisible(z, z2);
        AppMethodBeat.m2505o(92322);
        return visible;
    }

    public int getIntrinsicWidth() {
        AppMethodBeat.m2504i(92323);
        int width = this.aFU.aGa.mo42492nD().getWidth();
        AppMethodBeat.m2505o(92323);
        return width;
    }

    public int getIntrinsicHeight() {
        AppMethodBeat.m2504i(92324);
        int height = this.aFU.aGa.mo42492nD().getHeight();
        AppMethodBeat.m2505o(92324);
        return height;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    /* Access modifiers changed, original: protected */
    public void onBoundsChange(Rect rect) {
        AppMethodBeat.m2504i(92325);
        super.onBoundsChange(rect);
        this.aFX = true;
        AppMethodBeat.m2505o(92325);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.m2504i(92326);
        if (this.aBU) {
            AppMethodBeat.m2505o(92326);
            return;
        }
        if (this.aFX) {
            Gravity.apply(C31128d.MIC_AVROUND_BLUR, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m62330nB());
            this.aFX = false;
        }
        canvas.drawBitmap(this.aFU.aGa.mo42492nD(), null, m62330nB(), getPaint());
        AppMethodBeat.m2505o(92326);
    }

    public void setAlpha(int i) {
        AppMethodBeat.m2504i(92327);
        getPaint().setAlpha(i);
        AppMethodBeat.m2505o(92327);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        AppMethodBeat.m2504i(92328);
        getPaint().setColorFilter(colorFilter);
        AppMethodBeat.m2505o(92328);
    }

    /* renamed from: nB */
    private Rect m62330nB() {
        AppMethodBeat.m2504i(92329);
        if (this.aFZ == null) {
            this.aFZ = new Rect();
        }
        Rect rect = this.aFZ;
        AppMethodBeat.m2505o(92329);
        return rect;
    }

    private Paint getPaint() {
        AppMethodBeat.m2504i(92330);
        if (this.aFY == null) {
            this.aFY = new Paint(2);
        }
        Paint paint = this.aFY;
        AppMethodBeat.m2505o(92330);
        return paint;
    }

    public int getOpacity() {
        return -2;
    }

    public ConstantState getConstantState() {
        return this.aFU;
    }

    /* renamed from: nC */
    public final void mo18653nC() {
        AppMethodBeat.m2504i(92331);
        Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        if (callback == null) {
            stop();
            invalidateSelf();
            AppMethodBeat.m2505o(92331);
            return;
        }
        int i;
        invalidateSelf();
        C25452g c25452g = this.aFU.aGa;
        if (c25452g.aGf != null) {
            i = c25452g.aGf.index;
        } else {
            i = -1;
        }
        if (i == this.aFU.aGa.getFrameCount() - 1) {
            this.ayk++;
        }
        if (this.aFW != -1 && this.ayk >= this.aFW) {
            stop();
        }
        AppMethodBeat.m2505o(92331);
    }
}
