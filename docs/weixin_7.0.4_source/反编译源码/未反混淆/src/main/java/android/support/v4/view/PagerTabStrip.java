package android.support.v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.smtt.sdk.WebView;

public class PagerTabStrip extends PagerTitleStrip {
    private int MA = 255;
    private boolean MC = false;
    private boolean MD = false;
    private int MF;
    private boolean MG;
    private int Mt = this.MW;
    private int Mu;
    private int Mv;
    private int Mw;
    private int Mx;
    private int My;
    private final Paint Mz = new Paint();
    private float mInitialMotionX;
    private float mInitialMotionY;
    private final Rect mTempRect = new Rect();
    private int mTouchSlop;

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Mz.setColor(this.Mt);
        float f = context.getResources().getDisplayMetrics().density;
        this.Mu = (int) ((3.0f * f) + 0.5f);
        this.Mv = (int) ((6.0f * f) + 0.5f);
        this.Mw = (int) (64.0f * f);
        this.My = (int) ((16.0f * f) + 0.5f);
        this.MF = (int) ((1.0f * f) + 0.5f);
        this.Mx = (int) ((f * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.MJ.setFocusable(true);
        this.MJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                PagerTabStrip.this.MI.setCurrentItem(PagerTabStrip.this.MI.getCurrentItem() - 1);
            }
        });
        this.ML.setFocusable(true);
        this.ML.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                PagerTabStrip.this.MI.setCurrentItem(PagerTabStrip.this.MI.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.MC = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.Mt = i;
        this.Mz.setColor(this.Mt);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(b.i(getContext(), i));
    }

    public int getTabIndicatorColor() {
        return this.Mt;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.Mv) {
            i4 = this.Mv;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.Mw) {
            i = this.Mw;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.MD) {
            this.MC = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.MD) {
            this.MC = (WebView.NIGHT_MODE_COLOR & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.MD) {
            this.MC = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.MC = z;
        this.MD = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.MC;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.Mx);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.MG) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.MG = false;
                break;
            case 1:
                if (x >= ((float) (this.MK.getLeft() - this.My))) {
                    if (x > ((float) (this.MK.getRight() + this.My))) {
                        this.MI.setCurrentItem(this.MI.getCurrentItem() + 1);
                        break;
                    }
                }
                this.MI.setCurrentItem(this.MI.getCurrentItem() - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.mInitialMotionX) > ((float) this.mTouchSlop) || Math.abs(y - this.mInitialMotionY) > ((float) this.mTouchSlop)) {
                    this.MG = true;
                    break;
                }
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.MK.getLeft() - this.My;
        int right = this.MK.getRight() + this.My;
        int i = height - this.Mu;
        this.Mz.setColor((this.MA << 24) | (this.Mt & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.Mz);
        if (this.MC) {
            this.Mz.setColor(WebView.NIGHT_MODE_COLOR | (this.Mt & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.MF), (float) (getWidth() - getPaddingRight()), (float) height, this.Mz);
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, float f, boolean z) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int i2 = height - this.Mu;
        rect.set(this.MK.getLeft() - this.My, i2, this.MK.getRight() + this.My, height);
        super.a(i, f, z);
        this.MA = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.MK.getLeft() - this.My, i2, this.MK.getRight() + this.My, height);
        invalidate(rect);
    }
}
