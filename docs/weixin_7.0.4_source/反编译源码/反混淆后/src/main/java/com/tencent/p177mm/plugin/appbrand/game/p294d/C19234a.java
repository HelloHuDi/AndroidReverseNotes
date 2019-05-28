package com.tencent.p177mm.plugin.appbrand.game.p294d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.p069v7.widget.AppCompatButton;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.game.d.a */
final class C19234a extends AppCompatButton {
    private RectF hrv;
    private boolean hrw;
    private float hrx;
    private float hry;

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.a$a */
    class C19235a extends Drawable {
        Paint aFY;
        RectF rect;

        private C19235a() {
            AppMethodBeat.m2504i(130150);
            this.aFY = new Paint(1);
            this.rect = new RectF();
            this.aFY.setColor(-12748166);
            this.aFY.setStyle(Style.FILL);
            AppMethodBeat.m2505o(130150);
        }

        /* synthetic */ C19235a(C19234a c19234a, byte b) {
            this();
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.m2504i(130151);
            float height = ((float) canvas.getHeight()) / 2.0f;
            RectF rectF = this.rect;
            this.rect.top = 0.0f;
            rectF.left = 0.0f;
            rectF = this.rect;
            float f = height * 2.0f;
            this.rect.bottom = f;
            rectF.right = f;
            canvas.drawArc(this.rect, 90.0f, 180.0f, false, this.aFY);
            this.rect.left = ((float) canvas.getWidth()) - (height * 2.0f);
            this.rect.top = 0.0f;
            this.rect.right = (float) canvas.getWidth();
            this.rect.bottom = (float) canvas.getHeight();
            canvas.drawArc(this.rect, -90.0f, 180.0f, false, this.aFY);
            canvas.drawRect(height - 1.0f, 0.0f, (((float) C19234a.this.getWidth()) - height) + 1.0f, (float) C19234a.this.getHeight(), this.aFY);
            AppMethodBeat.m2505o(130151);
        }

        public final void setAlpha(int i) {
        }

        public final void setColorFilter(ColorFilter colorFilter) {
        }

        public final int getOpacity() {
            return -1;
        }
    }

    public C19234a(Context context) {
        super(context);
        AppMethodBeat.m2504i(130152);
        setGravity(17);
        setText("vConsole");
        setTextColor(-1);
        float f = getContext().getResources().getDisplayMetrics().density;
        setPadding((int) (13.0f * f), (int) (4.0f * f), (int) (13.0f * f), (int) (f * 6.0f));
        setBackgroundDrawable(new C19235a(this, (byte) 0));
        AppMethodBeat.m2505o(130152);
    }

    /* renamed from: H */
    private boolean m29891H(float f, float f2) {
        AppMethodBeat.m2504i(130153);
        if (this.hrv == null) {
            AppMethodBeat.m2505o(130153);
            return false;
        }
        boolean contains = this.hrv.contains(f, f2);
        AppMethodBeat.m2505o(130153);
        return contains;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(130154);
        switch (motionEvent.getAction()) {
            case 0:
                this.hrv = new RectF(getX(), getY(), getX() + ((float) getWidth()), getY() + ((float) getHeight()));
                this.hrw = false;
                break;
            case 1:
                if (!this.hrw && m29891H(motionEvent.getRawX(), motionEvent.getRawY())) {
                    performClick();
                    break;
                }
            case 2:
                if (this.hrw || !m29891H(motionEvent.getRawX(), motionEvent.getRawY())) {
                    setX(getX() + (motionEvent.getRawX() - this.hrx));
                    setY(getY() + (motionEvent.getRawY() - this.hry));
                    requestLayout();
                    this.hrw = true;
                    break;
                }
        }
        this.hrx = motionEvent.getRawX();
        this.hry = motionEvent.getRawY();
        AppMethodBeat.m2505o(130154);
        return true;
    }
}
