package android.support.v7.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.support.v7.a.a.a;
import android.support.v7.c.a.b;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.tencent.mm.R;

public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> asP = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf(((SwitchCompat) obj).atk);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
        }
    };
    private static final int[] kO = new int[]{16842912};
    private int anQ;
    private Drawable asQ;
    private ColorStateList asR;
    private Mode asS;
    private boolean asT;
    private boolean asU;
    private Drawable asV;
    private ColorStateList asW;
    private Mode asX;
    private boolean asY;
    private boolean asZ;
    private int ata;
    private int atb;
    private int atc;
    private boolean atd;
    private CharSequence ate;
    private CharSequence atf;
    private boolean atg;
    private int ath;
    private float ati;
    private float atj;
    private float atk;
    private int atl;
    private int atm;
    private int atn;
    private int ato;
    private int atp;
    private int atq;
    private int atr;
    private ColorStateList ats;
    private Layout att;
    private Layout atu;
    private TransformationMethod atv;
    ObjectAnimator atw;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private final TextPaint oz;

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ge);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.asR = null;
        this.asS = null;
        this.asT = false;
        this.asU = false;
        this.asW = null;
        this.asX = null;
        this.asY = false;
        this.asZ = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.oz = new TextPaint(1);
        Resources resources = getResources();
        this.oz.density = resources.getDisplayMetrics().density;
        bc a = bc.a(context, attributeSet, a.SwitchCompat, i, 0);
        this.asQ = a.getDrawable(2);
        if (this.asQ != null) {
            this.asQ.setCallback(this);
        }
        this.asV = a.getDrawable(5);
        if (this.asV != null) {
            this.asV.setCallback(this);
        }
        this.ate = a.getText(0);
        this.atf = a.getText(1);
        this.atg = a.getBoolean(13, true);
        this.ata = a.getDimensionPixelSize(8, 0);
        this.atb = a.getDimensionPixelSize(10, 0);
        this.atc = a.getDimensionPixelSize(11, 0);
        this.atd = a.getBoolean(12, false);
        ColorStateList colorStateList = a.getColorStateList(3);
        if (colorStateList != null) {
            this.asR = colorStateList;
            this.asT = true;
        }
        Mode d = aa.d(a.getInt(4, -1), null);
        if (this.asS != d) {
            this.asS = d;
            this.asU = true;
        }
        if (this.asT || this.asU) {
            lj();
        }
        colorStateList = a.getColorStateList(6);
        if (colorStateList != null) {
            this.asW = colorStateList;
            this.asY = true;
        }
        d = aa.d(a.getInt(7, -1), null);
        if (this.asX != d) {
            this.asX = d;
            this.asZ = true;
        }
        if (this.asY || this.asZ) {
            li();
        }
        int resourceId = a.getResourceId(9, 0);
        if (resourceId != 0) {
            Typeface typeface;
            bc a2 = bc.a(context, resourceId, a.TextAppearance);
            colorStateList = a2.getColorStateList(3);
            if (colorStateList != null) {
                this.ats = colorStateList;
            } else {
                this.ats = getTextColors();
            }
            resourceId = a2.getDimensionPixelSize(0, 0);
            if (!(resourceId == 0 || ((float) resourceId) == this.oz.getTextSize())) {
                this.oz.setTextSize((float) resourceId);
                requestLayout();
            }
            resourceId = a2.getInt(1, -1);
            int i2 = a2.getInt(2, -1);
            switch (resourceId) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    typeface = null;
                    break;
            }
            if (i2 > 0) {
                boolean z;
                float f;
                if (typeface == null) {
                    typeface = Typeface.defaultFromStyle(i2);
                } else {
                    typeface = Typeface.create(typeface, i2);
                }
                setSwitchTypeface(typeface);
                if (typeface != null) {
                    resourceId = typeface.getStyle();
                } else {
                    resourceId = 0;
                }
                i2 &= resourceId ^ -1;
                TextPaint textPaint = this.oz;
                if ((i2 & 1) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                textPaint.setFakeBoldText(z);
                TextPaint textPaint2 = this.oz;
                if ((i2 & 2) != 0) {
                    f = -0.25f;
                } else {
                    f = 0.0f;
                }
                textPaint2.setTextSkewX(f);
            } else {
                this.oz.setFakeBoldText(false);
                this.oz.setTextSkewX(0.0f);
                setSwitchTypeface(typeface);
            }
            if (a2.getBoolean(11, false)) {
                this.atv = new android.support.v7.g.a(getContext());
            } else {
                this.atv = null;
            }
            a2.atG.recycle();
        }
        a.atG.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.anQ = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.oz.getTypeface() != null && !this.oz.getTypeface().equals(typeface)) || (this.oz.getTypeface() == null && typeface != null)) {
            this.oz.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.atc = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.atc;
    }

    public void setSwitchMinWidth(int i) {
        this.atb = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.atb;
    }

    public void setThumbTextPadding(int i) {
        this.ata = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.ata;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.asV != null) {
            this.asV.setCallback(null);
        }
        this.asV = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(b.g(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.asV;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.asW = colorStateList;
        this.asY = true;
        li();
    }

    public ColorStateList getTrackTintList() {
        return this.asW;
    }

    public void setTrackTintMode(Mode mode) {
        this.asX = mode;
        this.asZ = true;
        li();
    }

    public Mode getTrackTintMode() {
        return this.asX;
    }

    private void li() {
        if (this.asV == null) {
            return;
        }
        if (this.asY || this.asZ) {
            this.asV = this.asV.mutate();
            if (this.asY) {
                android.support.v4.a.a.a.a(this.asV, this.asW);
            }
            if (this.asZ) {
                android.support.v4.a.a.a.a(this.asV, this.asX);
            }
            if (this.asV.isStateful()) {
                this.asV.setState(getDrawableState());
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.asQ != null) {
            this.asQ.setCallback(null);
        }
        this.asQ = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(b.g(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.asQ;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.asR = colorStateList;
        this.asT = true;
        lj();
    }

    public ColorStateList getThumbTintList() {
        return this.asR;
    }

    public void setThumbTintMode(Mode mode) {
        this.asS = mode;
        this.asU = true;
        lj();
    }

    public Mode getThumbTintMode() {
        return this.asS;
    }

    private void lj() {
        if (this.asQ == null) {
            return;
        }
        if (this.asT || this.asU) {
            this.asQ = this.asQ.mutate();
            if (this.asT) {
                android.support.v4.a.a.a.a(this.asQ, this.asR);
            }
            if (this.asU) {
                android.support.v4.a.a.a.a(this.asQ, this.asS);
            }
            if (this.asQ.isStateful()) {
                this.asQ.setState(getDrawableState());
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.atd = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.atd;
    }

    public CharSequence getTextOn() {
        return this.ate;
    }

    public void setTextOn(CharSequence charSequence) {
        this.ate = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.atf;
    }

    public void setTextOff(CharSequence charSequence) {
        this.atf = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.atg != z) {
            this.atg = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.atg;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int max;
        int i3 = 0;
        if (this.atg) {
            if (this.att == null) {
                this.att = n(this.ate);
            }
            if (this.atu == null) {
                this.atu = n(this.atf);
            }
        }
        Rect rect = this.mTempRect;
        if (this.asQ != null) {
            this.asQ.getPadding(rect);
            intrinsicWidth = (this.asQ.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.asQ.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        if (this.atg) {
            max = Math.max(this.att.getWidth(), this.atu.getWidth()) + (this.ata * 2);
        } else {
            max = 0;
        }
        this.atn = Math.max(max, intrinsicWidth);
        if (this.asV != null) {
            this.asV.getPadding(rect);
            i3 = this.asV.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        intrinsicWidth = rect.left;
        max = rect.right;
        if (this.asQ != null) {
            rect = aa.m(this.asQ);
            intrinsicWidth = Math.max(intrinsicWidth, rect.left);
            max = Math.max(max, rect.right);
        }
        intrinsicWidth = Math.max(this.atb, (intrinsicWidth + (this.atn * 2)) + max);
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.atl = intrinsicWidth;
        this.atm = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(getMeasuredWidthAndState(), intrinsicHeight);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.ate : this.atf;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    private Layout n(CharSequence charSequence) {
        int ceil;
        CharSequence transformation = this.atv != null ? this.atv.getTransformation(charSequence, this) : charSequence;
        TextPaint textPaint = this.oz;
        if (transformation != null) {
            ceil = (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.oz));
        } else {
            ceil = 0;
        }
        return new StaticLayout(transformation, textPaint, ceil, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 1.0f;
        int i = 0;
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        switch (motionEvent.getActionMasked()) {
            case 0:
                x = motionEvent.getX();
                f = motionEvent.getY();
                if (isEnabled()) {
                    if (this.asQ != null) {
                        int thumbOffset = getThumbOffset();
                        this.asQ.getPadding(this.mTempRect);
                        int i2 = this.atp - this.mTouchSlop;
                        thumbOffset = (thumbOffset + this.ato) - this.mTouchSlop;
                        int i3 = (((this.atn + thumbOffset) + this.mTempRect.left) + this.mTempRect.right) + this.mTouchSlop;
                        int i4 = this.atr + this.mTouchSlop;
                        if (x > ((float) thumbOffset) && x < ((float) i3) && f > ((float) i2) && f < ((float) i4)) {
                            i = 1;
                        }
                    }
                    if (i != 0) {
                        this.ath = 1;
                        this.ati = x;
                        this.atj = f;
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                if (this.ath != 2) {
                    this.ath = 0;
                    this.mVelocityTracker.clear();
                    break;
                }
                this.ath = 0;
                boolean z = motionEvent.getAction() == 1 && isEnabled();
                boolean isChecked = isChecked();
                if (z) {
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    x = this.mVelocityTracker.getXVelocity();
                    z = Math.abs(x) > ((float) this.anQ) ? bk.bW(this) ? x < 0.0f : x > 0.0f : getTargetCheckedState();
                } else {
                    z = isChecked;
                }
                if (z != isChecked) {
                    playSoundEffect(0);
                }
                setChecked(z);
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
                obtain.recycle();
                super.onTouchEvent(motionEvent);
                return true;
            case 2:
                switch (this.ath) {
                    case 1:
                        x = motionEvent.getX();
                        f = motionEvent.getY();
                        if (Math.abs(x - this.ati) > ((float) this.mTouchSlop) || Math.abs(f - this.atj) > ((float) this.mTouchSlop)) {
                            this.ath = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.ati = x;
                            this.atj = f;
                            return true;
                        }
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x2 - this.ati;
                        x = thumbScrollRange != 0 ? f2 / ((float) thumbScrollRange) : f2 > 0.0f ? 1.0f : -1.0f;
                        if (bk.bW(this)) {
                            x = -x;
                        }
                        x += this.atk;
                        if (x < 0.0f) {
                            f = 0.0f;
                        } else if (x <= 1.0f) {
                            f = x;
                        }
                        if (f == this.atk) {
                            return true;
                        }
                        this.ati = x2;
                        setThumbPosition(f);
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    private boolean getTargetCheckedState() {
        return this.atk > 0.5f;
    }

    /* Access modifiers changed, original: 0000 */
    public void setThumbPosition(float f) {
        this.atk = f;
        invalidate();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    public void setChecked(boolean z) {
        float f = 1.0f;
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !s.as(this)) {
            if (this.atw != null) {
                this.atw.cancel();
            }
            if (!isChecked) {
                f = 0.0f;
            }
            setThumbPosition(f);
            return;
        }
        if (!isChecked) {
            f = 0.0f;
        }
        this.atw = ObjectAnimator.ofFloat(this, asP, new float[]{f});
        this.atw.setDuration(250);
        if (VERSION.SDK_INT >= 18) {
            this.atw.setAutoCancel(true);
        }
        this.atw.start();
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int max2;
        int paddingLeft;
        int paddingTop;
        super.onLayout(z, i, i2, i3, i4);
        if (this.asQ != null) {
            Rect rect = this.mTempRect;
            if (this.asV != null) {
                this.asV.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect m = aa.m(this.asQ);
            max = Math.max(0, m.left - rect.left);
            max2 = Math.max(0, m.right - rect.right);
        } else {
            max2 = 0;
            max = 0;
        }
        if (bk.bW(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.atl + paddingLeft) - max) - max2;
            max2 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - max2;
            max2 += max + (paddingLeft - this.atl);
            max = paddingLeft;
        }
        switch (getGravity() & 112) {
            case 16:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.atm / 2);
                paddingLeft = this.atm + paddingTop;
                break;
            case 80:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.atm;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.atm + paddingTop;
                break;
        }
        this.ato = max2;
        this.atp = paddingTop;
        this.atr = paddingLeft;
        this.atq = max;
    }

    public void draw(Canvas canvas) {
        Rect m;
        int i;
        Rect rect = this.mTempRect;
        int i2 = this.ato;
        int i3 = this.atp;
        int i4 = this.atq;
        int i5 = this.atr;
        int thumbOffset = i2 + getThumbOffset();
        if (this.asQ != null) {
            m = aa.m(this.asQ);
        } else {
            m = aa.ahT;
        }
        if (this.asV != null) {
            this.asV.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (m != null) {
                if (m.left > rect.left) {
                    i2 += m.left - rect.left;
                }
                if (m.top > rect.top) {
                    thumbOffset = (m.top - rect.top) + i3;
                } else {
                    thumbOffset = i3;
                }
                if (m.right > rect.right) {
                    i4 -= m.right - rect.right;
                }
                i = m.bottom > rect.bottom ? i5 - (m.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.asV.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.asQ != null) {
            this.asQ.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.atn) + rect.right;
            this.asQ.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                android.support.v4.a.a.a.a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.asV;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.atp + rect.top;
        int i2 = this.atr - rect.bottom;
        Drawable drawable2 = this.asQ;
        if (drawable != null) {
            if (!this.atd || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect m = aa.m(drawable2);
                drawable2.copyBounds(rect);
                rect.left += m.left;
                rect.right -= m.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.att : this.atu;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.ats != null) {
                this.oz.setColor(this.ats.getColorForState(drawableState, 0));
            }
            this.oz.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public int getCompoundPaddingLeft() {
        if (!bk.bW(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.atl;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft;
        }
        return compoundPaddingLeft + this.atc;
    }

    public int getCompoundPaddingRight() {
        if (bk.bW(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.atl;
        if (TextUtils.isEmpty(getText())) {
            return compoundPaddingRight;
        }
        return compoundPaddingRight + this.atc;
    }

    private int getThumbOffset() {
        float f;
        if (bk.bW(this)) {
            f = 1.0f - this.atk;
        } else {
            f = this.atk;
        }
        return (int) ((f * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.asV == null) {
            return 0;
        }
        Rect m;
        Rect rect = this.mTempRect;
        this.asV.getPadding(rect);
        if (this.asQ != null) {
            m = aa.m(this.asQ);
        } else {
            m = aa.ahT;
        }
        return ((((this.atl - this.atn) - rect.left) - rect.right) - m.left) - m.right;
    }

    /* Access modifiers changed, original: protected */
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, kO);
        }
        return onCreateDrawableState;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.asQ;
        if (drawable != null && drawable.isStateful()) {
            i = drawable.setState(drawableState) | 0;
        }
        drawable = this.asV;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.asQ != null) {
            android.support.v4.a.a.a.a(this.asQ, f, f2);
        }
        if (this.asV != null) {
            android.support.v4.a.a.a.a(this.asV, f, f2);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.asQ || drawable == this.asV;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.asQ != null) {
            this.asQ.jumpToCurrentState();
        }
        if (this.asV != null) {
            this.asV.jumpToCurrentState();
        }
        if (this.atw != null && this.atw.isStarted()) {
            this.atw.end();
            this.atw = null;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.ate : this.atf;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(text).append(' ').append(charSequence);
            accessibilityNodeInfo.setText(stringBuilder);
        }
    }
}
