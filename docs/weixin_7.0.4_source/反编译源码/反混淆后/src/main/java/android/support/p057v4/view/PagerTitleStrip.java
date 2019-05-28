package android.support.p057v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.ViewPager.C0434c;
import android.support.p057v4.view.ViewPager.C31865a;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.support.p057v4.widget.C0540q;
import android.support.p057v4.widget.C8415j;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import java.lang.ref.WeakReference;
import java.util.Locale;

@C31865a
/* renamed from: android.support.v4.view.PagerTitleStrip */
public class PagerTitleStrip extends ViewGroup {
    /* renamed from: MT */
    private static final int[] f3931MT = new int[]{16842804, 16842901, 16842904, 16842927};
    /* renamed from: MU */
    private static final int[] f3932MU = new int[]{16843660};
    /* renamed from: Hu */
    private int f3933Hu;
    /* renamed from: MI */
    ViewPager f3934MI;
    /* renamed from: MJ */
    TextView f3935MJ;
    /* renamed from: MK */
    TextView f3936MK;
    /* renamed from: ML */
    TextView f3937ML;
    /* renamed from: MM */
    private int f3938MM = -1;
    /* renamed from: MN */
    float f3939MN = -1.0f;
    /* renamed from: MO */
    private int f3940MO;
    /* renamed from: MP */
    private boolean f3941MP;
    /* renamed from: MQ */
    private boolean f3942MQ;
    /* renamed from: MR */
    private final C17452a f3943MR = new C17452a();
    /* renamed from: MS */
    private WeakReference<C25365p> f3944MS;
    /* renamed from: MV */
    private int f3945MV;
    /* renamed from: MW */
    int f3946MW;

    /* renamed from: android.support.v4.view.PagerTitleStrip$a */
    class C17452a extends DataSetObserver implements OnPageChangeListener, C0434c {
        private int mScrollState;

        C17452a() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.mo31735a(i, f, false);
        }

        public final void onPageSelected(int i) {
            float f = 0.0f;
            if (this.mScrollState == 0) {
                PagerTitleStrip.this.mo31736a(PagerTitleStrip.this.f3934MI.getCurrentItem(), PagerTitleStrip.this.f3934MI.getAdapter());
                if (PagerTitleStrip.this.f3939MN >= 0.0f) {
                    f = PagerTitleStrip.this.f3939MN;
                }
                PagerTitleStrip.this.mo31735a(PagerTitleStrip.this.f3934MI.getCurrentItem(), f, true);
            }
        }

        public final void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
        }

        /* renamed from: a */
        public final void mo958a(ViewPager viewPager, C25365p c25365p, C25365p c25365p2) {
            PagerTitleStrip.this.mo31737a(c25365p, c25365p2);
        }

        public final void onChanged() {
            float f = 0.0f;
            PagerTitleStrip.this.mo31736a(PagerTitleStrip.this.f3934MI.getCurrentItem(), PagerTitleStrip.this.f3934MI.getAdapter());
            if (PagerTitleStrip.this.f3939MN >= 0.0f) {
                f = PagerTitleStrip.this.f3939MN;
            }
            PagerTitleStrip.this.mo31735a(PagerTitleStrip.this.f3934MI.getCurrentItem(), f, true);
        }
    }

    /* renamed from: android.support.v4.view.PagerTitleStrip$b */
    static class C17453b extends SingleLineTransformationMethod {
        /* renamed from: MY */
        private Locale f3947MY;

        C17453b(Context context) {
            this.f3947MY = context.getResources().getConfiguration().locale;
        }

        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            return transformation != null ? transformation.toString().toUpperCase(this.f3947MY) : null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new C17453b(textView.getContext()));
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        int i = 0;
        super(context, attributeSet);
        TextView textView = new TextView(context);
        this.f3935MJ = textView;
        addView(textView);
        textView = new TextView(context);
        this.f3936MK = textView;
        addView(textView);
        textView = new TextView(context);
        this.f3937ML = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3931MT);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            C0540q.m1167b(this.f3935MJ, resourceId);
            C0540q.m1167b(this.f3936MK, resourceId);
            C0540q.m1167b(this.f3937ML, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.f3935MJ.setTextSize(0, f);
            this.f3936MK.setTextSize(0, f);
            this.f3937ML.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.f3935MJ.setTextColor(dimensionPixelSize);
            this.f3936MK.setTextColor(dimensionPixelSize);
            this.f3937ML.setTextColor(dimensionPixelSize);
        }
        this.f3933Hu = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f3946MW = this.f3936MK.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f3935MJ.setEllipsize(TruncateAt.END);
        this.f3936MK.setEllipsize(TruncateAt.END);
        this.f3937ML.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, f3932MU);
            i = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            PagerTitleStrip.setSingleLineAllCaps(this.f3935MJ);
            PagerTitleStrip.setSingleLineAllCaps(this.f3936MK);
            PagerTitleStrip.setSingleLineAllCaps(this.f3937ML);
        } else {
            this.f3935MJ.setSingleLine();
            this.f3936MK.setSingleLine();
            this.f3937ML.setSingleLine();
        }
        this.f3940MO = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.f3940MO = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.f3940MO;
    }

    public void setNonPrimaryAlpha(float f) {
        this.f3945MV = ((int) (255.0f * f)) & 255;
        int i = (this.f3945MV << 24) | (this.f3946MW & 16777215);
        this.f3935MJ.setTextColor(i);
        this.f3937ML.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.f3946MW = i;
        this.f3936MK.setTextColor(i);
        int i2 = (this.f3945MV << 24) | (this.f3946MW & 16777215);
        this.f3935MJ.setTextColor(i2);
        this.f3937ML.setTextColor(i2);
    }

    public void setGravity(int i) {
        this.f3933Hu = i;
        requestLayout();
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            C25365p adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.f3943MR);
            viewPager.addOnAdapterChangeListener(this.f3943MR);
            this.f3934MI = viewPager;
            mo31737a(this.f3944MS != null ? (C25365p) this.f3944MS.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3934MI != null) {
            mo31737a(this.f3934MI.getAdapter(), null);
            this.f3934MI.setInternalPageChangeListener(null);
            this.f3934MI.removeOnAdapterChangeListener(this.f3943MR);
            this.f3934MI = null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo31736a(int i, C25365p c25365p) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int count = c25365p != null ? c25365p.getCount() : 0;
        this.f3941MP = true;
        if (i <= 0 || c25365p == null) {
            charSequence = null;
        } else {
            charSequence = c25365p.getPageTitle(i - 1);
        }
        this.f3935MJ.setText(charSequence);
        TextView textView = this.f3936MK;
        if (c25365p == null || i >= count) {
            charSequence = null;
        } else {
            charSequence = c25365p.getPageTitle(i);
        }
        textView.setText(charSequence);
        if (i + 1 < count && c25365p != null) {
            charSequence2 = c25365p.getPageTitle(i + 1);
        }
        this.f3937ML.setText(charSequence2);
        count = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), C8415j.INVALID_ID);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), C8415j.INVALID_ID);
        this.f3935MJ.measure(count, makeMeasureSpec);
        this.f3936MK.measure(count, makeMeasureSpec);
        this.f3937ML.measure(count, makeMeasureSpec);
        this.f3938MM = i;
        if (!this.f3942MQ) {
            mo31735a(i, this.f3939MN, false);
        }
        this.f3941MP = false;
    }

    public void requestLayout() {
        if (!this.f3941MP) {
            super.requestLayout();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo31737a(C25365p c25365p, C25365p c25365p2) {
        if (c25365p != null) {
            c25365p.unregisterDataSetObserver(this.f3943MR);
            this.f3944MS = null;
        }
        if (c25365p2 != null) {
            c25365p2.registerDataSetObserver(this.f3943MR);
            this.f3944MS = new WeakReference(c25365p2);
        }
        if (this.f3934MI != null) {
            this.f3938MM = -1;
            this.f3939MN = -1.0f;
            mo31736a(this.f3934MI.getCurrentItem(), c25365p2);
            requestLayout();
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo31735a(int i, float f, boolean z) {
        if (i != this.f3938MM) {
            mo31736a(i, this.f3934MI.getAdapter());
        } else if (!z && f == this.f3939MN) {
            return;
        }
        this.f3942MQ = true;
        int measuredWidth = this.f3935MJ.getMeasuredWidth();
        int measuredWidth2 = this.f3936MK.getMeasuredWidth();
        int measuredWidth3 = this.f3937ML.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i3 = ((width - i3) - ((int) (f2 * ((float) i4)))) - i2;
        i4 = i3 + measuredWidth2;
        int baseline = this.f3935MJ.getBaseline();
        measuredWidth2 = this.f3936MK.getBaseline();
        i2 = this.f3937ML.getBaseline();
        int max = Math.max(Math.max(baseline, measuredWidth2), i2);
        baseline = max - baseline;
        measuredWidth2 = max - measuredWidth2;
        max -= i2;
        int measuredHeight = this.f3937ML.getMeasuredHeight() + max;
        i2 = Math.max(Math.max(this.f3935MJ.getMeasuredHeight() + baseline, this.f3936MK.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.f3933Hu & 112) {
            case 16:
                height = (((height - paddingTop) - paddingBottom) - i2) / 2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            case 80:
                height = (height - paddingBottom) - i2;
                i2 = height + baseline;
                baseline = height + measuredWidth2;
                measuredWidth2 = height + max;
                break;
            default:
                i2 = paddingTop + baseline;
                baseline = paddingTop + measuredWidth2;
                measuredWidth2 = paddingTop + max;
                break;
        }
        this.f3936MK.layout(i3, baseline, i4, this.f3936MK.getMeasuredHeight() + baseline);
        baseline = Math.min(paddingLeft, (i3 - this.f3940MO) - measuredWidth);
        this.f3935MJ.layout(baseline, i2, measuredWidth + baseline, this.f3935MJ.getMeasuredHeight() + i2);
        baseline = Math.max((width - paddingRight) - measuredWidth3, this.f3940MO + i4);
        this.f3937ML.layout(baseline, measuredWidth2, baseline + measuredWidth3, this.f3937ML.getMeasuredHeight() + measuredWidth2);
        this.f3939MN = f;
        this.f3942MQ = false;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != ErrorDialogData.SUPPRESSED) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = PagerTitleStrip.getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = PagerTitleStrip.getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.f3935MJ.measure(childMeasureSpec2, childMeasureSpec);
        this.f3936MK.measure(childMeasureSpec2, childMeasureSpec);
        this.f3937ML.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == ErrorDialogData.SUPPRESSED) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.f3936MK.getMeasuredHeight());
        }
        setMeasuredDimension(size, View.resolveSizeAndState(paddingTop, i2, this.f3936MK.getMeasuredState() << 16));
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.f3934MI != null) {
            if (this.f3939MN >= 0.0f) {
                f = this.f3939MN;
            }
            mo31735a(this.f3938MM, f, true);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }
}
