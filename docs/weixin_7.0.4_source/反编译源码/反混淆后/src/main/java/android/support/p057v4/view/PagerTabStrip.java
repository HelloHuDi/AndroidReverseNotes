package android.support.p057v4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p057v4.content.C0380b;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.smtt.sdk.WebView;

/* renamed from: android.support.v4.view.PagerTabStrip */
public class PagerTabStrip extends PagerTitleStrip {
    /* renamed from: MA */
    private int f14631MA = 255;
    /* renamed from: MC */
    private boolean f14632MC = false;
    /* renamed from: MD */
    private boolean f14633MD = false;
    /* renamed from: MF */
    private int f14634MF;
    /* renamed from: MG */
    private boolean f14635MG;
    /* renamed from: Mt */
    private int f14636Mt = this.f3946MW;
    /* renamed from: Mu */
    private int f14637Mu;
    /* renamed from: Mv */
    private int f14638Mv;
    /* renamed from: Mw */
    private int f14639Mw;
    /* renamed from: Mx */
    private int f14640Mx;
    /* renamed from: My */
    private int f14641My;
    /* renamed from: Mz */
    private final Paint f14642Mz = new Paint();
    private float mInitialMotionX;
    private float mInitialMotionY;
    private final Rect mTempRect = new Rect();
    private int mTouchSlop;

    /* renamed from: android.support.v4.view.PagerTabStrip$2 */
    class C318632 implements OnClickListener {
        C318632() {
        }

        public final void onClick(View view) {
            PagerTabStrip.this.f3934MI.setCurrentItem(PagerTabStrip.this.f3934MI.getCurrentItem() + 1);
        }
    }

    /* renamed from: android.support.v4.view.PagerTabStrip$1 */
    class C318641 implements OnClickListener {
        C318641() {
        }

        public final void onClick(View view) {
            PagerTabStrip.this.f3934MI.setCurrentItem(PagerTabStrip.this.f3934MI.getCurrentItem() - 1);
        }
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14642Mz.setColor(this.f14636Mt);
        float f = context.getResources().getDisplayMetrics().density;
        this.f14637Mu = (int) ((3.0f * f) + 0.5f);
        this.f14638Mv = (int) ((6.0f * f) + 0.5f);
        this.f14639Mw = (int) (64.0f * f);
        this.f14641My = (int) ((16.0f * f) + 0.5f);
        this.f14634MF = (int) ((1.0f * f) + 0.5f);
        this.f14640Mx = (int) ((f * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f3935MJ.setFocusable(true);
        this.f3935MJ.setOnClickListener(new C318641());
        this.f3937ML.setFocusable(true);
        this.f3937ML.setOnClickListener(new C318632());
        if (getBackground() == null) {
            this.f14632MC = true;
        }
    }

    public void setTabIndicatorColor(int i) {
        this.f14636Mt = i;
        this.f14642Mz.setColor(this.f14636Mt);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(C0380b.m652i(getContext(), i));
    }

    public int getTabIndicatorColor() {
        return this.f14636Mt;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (i4 < this.f14638Mv) {
            i4 = this.f14638Mv;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTextSpacing(int i) {
        if (i < this.f14639Mw) {
            i = this.f14639Mw;
        }
        super.setTextSpacing(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (!this.f14633MD) {
            this.f14632MC = drawable == null;
        }
    }

    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (!this.f14633MD) {
            this.f14632MC = (WebView.NIGHT_MODE_COLOR & i) == 0;
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (!this.f14633MD) {
            this.f14632MC = i == 0;
        }
    }

    public void setDrawFullUnderline(boolean z) {
        this.f14632MC = z;
        this.f14633MD = true;
        invalidate();
    }

    public boolean getDrawFullUnderline() {
        return this.f14632MC;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f14640Mx);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.f14635MG) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        switch (action) {
            case 0:
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                this.f14635MG = false;
                break;
            case 1:
                if (x >= ((float) (this.f3936MK.getLeft() - this.f14641My))) {
                    if (x > ((float) (this.f3936MK.getRight() + this.f14641My))) {
                        this.f3934MI.setCurrentItem(this.f3934MI.getCurrentItem() + 1);
                        break;
                    }
                }
                this.f3934MI.setCurrentItem(this.f3934MI.getCurrentItem() - 1);
                break;
                break;
            case 2:
                if (Math.abs(x - this.mInitialMotionX) > ((float) this.mTouchSlop) || Math.abs(y - this.mInitialMotionY) > ((float) this.mTouchSlop)) {
                    this.f14635MG = true;
                    break;
                }
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f3936MK.getLeft() - this.f14641My;
        int right = this.f3936MK.getRight() + this.f14641My;
        int i = height - this.f14637Mu;
        this.f14642Mz.setColor((this.f14631MA << 24) | (this.f14636Mt & 16777215));
        canvas.drawRect((float) left, (float) i, (float) right, (float) height, this.f14642Mz);
        if (this.f14632MC) {
            this.f14642Mz.setColor(WebView.NIGHT_MODE_COLOR | (this.f14636Mt & 16777215));
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.f14634MF), (float) (getWidth() - getPaddingRight()), (float) height, this.f14642Mz);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo31735a(int i, float f, boolean z) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int i2 = height - this.f14637Mu;
        rect.set(this.f3936MK.getLeft() - this.f14641My, i2, this.f3936MK.getRight() + this.f14641My, height);
        super.mo31735a(i, f, z);
        this.f14631MA = (int) ((Math.abs(f - 0.5f) * 2.0f) * 255.0f);
        rect.union(this.f3936MK.getLeft() - this.f14641My, i2, this.f3936MK.getRight() + this.f14641My, height);
        invalidate(rect);
    }
}
