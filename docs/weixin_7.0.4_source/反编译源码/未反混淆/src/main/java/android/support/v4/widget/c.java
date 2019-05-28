package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

final class c extends ImageView {
    AnimationListener OW;
    int OX;

    class a extends OvalShape {
        private RadialGradient OY;
        private Paint OZ = new Paint();

        a(int i) {
            c.this.OX = i;
            aP((int) rect().width());
        }

        /* Access modifiers changed, original: protected|final */
        public final void onResize(float f, float f2) {
            super.onResize(f, f2);
            aP((int) f);
        }

        public final void draw(Canvas canvas, Paint paint) {
            int width = c.this.getWidth();
            int height = c.this.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (width / 2), this.OZ);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((width / 2) - c.this.OX), paint);
        }

        private void aP(int i) {
            this.OY = new RadialGradient((float) (i / 2), (float) (i / 2), (float) c.this.OX, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.OZ.setShader(this.OY);
        }
    }

    c(Context context) {
        Drawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i = (int) (1.75f * f);
        int i2 = (int) (0.0f * f);
        this.OX = (int) (3.5f * f);
        if (ey()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            s.h(this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new a(this.OX));
            setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.OX, (float) i2, (float) i, 503316480);
            int i3 = this.OX;
            setPadding(i3, i3, i3, i3);
        }
        shapeDrawable.getPaint().setColor(-328966);
        s.a((View) this, shapeDrawable);
    }

    private static boolean ey() {
        return VERSION.SDK_INT >= 21;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!ey()) {
            setMeasuredDimension(getMeasuredWidth() + (this.OX * 2), getMeasuredHeight() + (this.OX * 2));
        }
    }

    public final void onAnimationStart() {
        super.onAnimationStart();
        if (this.OW != null) {
            this.OW.onAnimationStart(getAnimation());
        }
    }

    public final void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.OW != null) {
            this.OW.onAnimationEnd(getAnimation());
        }
    }

    public final void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
