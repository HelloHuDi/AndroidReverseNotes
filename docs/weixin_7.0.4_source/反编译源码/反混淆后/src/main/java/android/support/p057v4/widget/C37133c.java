package android.support.p057v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0477s;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/* renamed from: android.support.v4.widget.c */
final class C37133c extends ImageView {
    /* renamed from: OW */
    AnimationListener f15805OW;
    /* renamed from: OX */
    int f15806OX;

    /* renamed from: android.support.v4.widget.c$a */
    class C17464a extends OvalShape {
        /* renamed from: OY */
        private RadialGradient f3990OY;
        /* renamed from: OZ */
        private Paint f3991OZ = new Paint();

        C17464a(int i) {
            C37133c.this.f15806OX = i;
            m27106aP((int) rect().width());
        }

        /* Access modifiers changed, original: protected|final */
        public final void onResize(float f, float f2) {
            super.onResize(f, f2);
            m27106aP((int) f);
        }

        public final void draw(Canvas canvas, Paint paint) {
            int width = C37133c.this.getWidth();
            int height = C37133c.this.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (width / 2), this.f3991OZ);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((width / 2) - C37133c.this.f15806OX), paint);
        }

        /* renamed from: aP */
        private void m27106aP(int i) {
            this.f3990OY = new RadialGradient((float) (i / 2), (float) (i / 2), (float) C37133c.this.f15806OX, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f3991OZ.setShader(this.f3990OY);
        }
    }

    C37133c(Context context) {
        Drawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i = (int) (1.75f * f);
        int i2 = (int) (0.0f * f);
        this.f15806OX = (int) (3.5f * f);
        if (C37133c.m62145ey()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            C0477s.m945h(this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C17464a(this.f15806OX));
            setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f15806OX, (float) i2, (float) i, 503316480);
            int i3 = this.f15806OX;
            setPadding(i3, i3, i3, i3);
        }
        shapeDrawable.getPaint().setColor(-328966);
        C0477s.m904a((View) this, shapeDrawable);
    }

    /* renamed from: ey */
    private static boolean m62145ey() {
        return VERSION.SDK_INT >= 21;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!C37133c.m62145ey()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f15806OX * 2), getMeasuredHeight() + (this.f15806OX * 2));
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        if (this.f15805OW != null) {
            this.f15805OW.onAnimationStart(getAnimation());
        }
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f15805OW != null) {
            this.f15805OW.onAnimationEnd(getAnimation());
        }
    }

    public final void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
