package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.c;
import android.support.v4.widget.j;
import android.support.v4.widget.q;
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

@android.support.v4.view.ViewPager.a
public class PagerTitleStrip extends ViewGroup {
    private static final int[] MT = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] MU = new int[]{16843660};
    private int Hu;
    ViewPager MI;
    TextView MJ;
    TextView MK;
    TextView ML;
    private int MM = -1;
    float MN = -1.0f;
    private int MO;
    private boolean MP;
    private boolean MQ;
    private final a MR = new a();
    private WeakReference<p> MS;
    private int MV;
    int MW;

    class a extends DataSetObserver implements OnPageChangeListener, c {
        private int mScrollState;

        a() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.a(i, f, false);
        }

        public final void onPageSelected(int i) {
            float f = 0.0f;
            if (this.mScrollState == 0) {
                PagerTitleStrip.this.a(PagerTitleStrip.this.MI.getCurrentItem(), PagerTitleStrip.this.MI.getAdapter());
                if (PagerTitleStrip.this.MN >= 0.0f) {
                    f = PagerTitleStrip.this.MN;
                }
                PagerTitleStrip.this.a(PagerTitleStrip.this.MI.getCurrentItem(), f, true);
            }
        }

        public final void onPageScrollStateChanged(int i) {
            this.mScrollState = i;
        }

        public final void a(ViewPager viewPager, p pVar, p pVar2) {
            PagerTitleStrip.this.a(pVar, pVar2);
        }

        public final void onChanged() {
            float f = 0.0f;
            PagerTitleStrip.this.a(PagerTitleStrip.this.MI.getCurrentItem(), PagerTitleStrip.this.MI.getAdapter());
            if (PagerTitleStrip.this.MN >= 0.0f) {
                f = PagerTitleStrip.this.MN;
            }
            PagerTitleStrip.this.a(PagerTitleStrip.this.MI.getCurrentItem(), f, true);
        }
    }

    static class b extends SingleLineTransformationMethod {
        private Locale MY;

        b(Context context) {
            this.MY = context.getResources().getConfiguration().locale;
        }

        public final CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            return transformation != null ? transformation.toString().toUpperCase(this.MY) : null;
        }
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        int i = 0;
        super(context, attributeSet);
        TextView textView = new TextView(context);
        this.MJ = textView;
        addView(textView);
        textView = new TextView(context);
        this.MK = textView;
        addView(textView);
        textView = new TextView(context);
        this.ML = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MT);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            q.b(this.MJ, resourceId);
            q.b(this.MK, resourceId);
            q.b(this.ML, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f = (float) dimensionPixelSize;
            this.MJ.setTextSize(0, f);
            this.MK.setTextSize(0, f);
            this.ML.setTextSize(0, f);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.MJ.setTextColor(dimensionPixelSize);
            this.MK.setTextColor(dimensionPixelSize);
            this.ML.setTextColor(dimensionPixelSize);
        }
        this.Hu = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.MW = this.MK.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.MJ.setEllipsize(TruncateAt.END);
        this.MK.setEllipsize(TruncateAt.END);
        this.ML.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, MU);
            i = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            setSingleLineAllCaps(this.MJ);
            setSingleLineAllCaps(this.MK);
            setSingleLineAllCaps(this.ML);
        } else {
            this.MJ.setSingleLine();
            this.MK.setSingleLine();
            this.ML.setSingleLine();
        }
        this.MO = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    public void setTextSpacing(int i) {
        this.MO = i;
        requestLayout();
    }

    public int getTextSpacing() {
        return this.MO;
    }

    public void setNonPrimaryAlpha(float f) {
        this.MV = ((int) (255.0f * f)) & 255;
        int i = (this.MV << 24) | (this.MW & 16777215);
        this.MJ.setTextColor(i);
        this.ML.setTextColor(i);
    }

    public void setTextColor(int i) {
        this.MW = i;
        this.MK.setTextColor(i);
        int i2 = (this.MV << 24) | (this.MW & 16777215);
        this.MJ.setTextColor(i2);
        this.ML.setTextColor(i2);
    }

    public void setGravity(int i) {
        this.Hu = i;
        requestLayout();
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            p adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.MR);
            viewPager.addOnAdapterChangeListener(this.MR);
            this.MI = viewPager;
            a(this.MS != null ? (p) this.MS.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.MI != null) {
            a(this.MI.getAdapter(), null);
            this.MI.setInternalPageChangeListener(null);
            this.MI.removeOnAdapterChangeListener(this.MR);
            this.MI = null;
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, p pVar) {
        CharSequence charSequence;
        CharSequence charSequence2 = null;
        int count = pVar != null ? pVar.getCount() : 0;
        this.MP = true;
        if (i <= 0 || pVar == null) {
            charSequence = null;
        } else {
            charSequence = pVar.getPageTitle(i - 1);
        }
        this.MJ.setText(charSequence);
        TextView textView = this.MK;
        if (pVar == null || i >= count) {
            charSequence = null;
        } else {
            charSequence = pVar.getPageTitle(i);
        }
        textView.setText(charSequence);
        if (i + 1 < count && pVar != null) {
            charSequence2 = pVar.getPageTitle(i + 1);
        }
        this.ML.setText(charSequence2);
        count = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), j.INVALID_ID);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), j.INVALID_ID);
        this.MJ.measure(count, makeMeasureSpec);
        this.MK.measure(count, makeMeasureSpec);
        this.ML.measure(count, makeMeasureSpec);
        this.MM = i;
        if (!this.MQ) {
            a(i, this.MN, false);
        }
        this.MP = false;
    }

    public void requestLayout() {
        if (!this.MP) {
            super.requestLayout();
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(p pVar, p pVar2) {
        if (pVar != null) {
            pVar.unregisterDataSetObserver(this.MR);
            this.MS = null;
        }
        if (pVar2 != null) {
            pVar2.registerDataSetObserver(this.MR);
            this.MS = new WeakReference(pVar2);
        }
        if (this.MI != null) {
            this.MM = -1;
            this.MN = -1.0f;
            a(this.MI.getCurrentItem(), pVar2);
            requestLayout();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void a(int i, float f, boolean z) {
        if (i != this.MM) {
            a(i, this.MI.getAdapter());
        } else if (!z && f == this.MN) {
            return;
        }
        this.MQ = true;
        int measuredWidth = this.MJ.getMeasuredWidth();
        int measuredWidth2 = this.MK.getMeasuredWidth();
        int measuredWidth3 = this.ML.getMeasuredWidth();
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
        int baseline = this.MJ.getBaseline();
        measuredWidth2 = this.MK.getBaseline();
        i2 = this.ML.getBaseline();
        int max = Math.max(Math.max(baseline, measuredWidth2), i2);
        baseline = max - baseline;
        measuredWidth2 = max - measuredWidth2;
        max -= i2;
        int measuredHeight = this.ML.getMeasuredHeight() + max;
        i2 = Math.max(Math.max(this.MJ.getMeasuredHeight() + baseline, this.MK.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.Hu & 112) {
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
        this.MK.layout(i3, baseline, i4, this.MK.getMeasuredHeight() + baseline);
        baseline = Math.min(paddingLeft, (i3 - this.MO) - measuredWidth);
        this.MJ.layout(baseline, i2, measuredWidth + baseline, this.MJ.getMeasuredHeight() + i2);
        baseline = Math.max((width - paddingRight) - measuredWidth3, this.MO + i4);
        this.ML.layout(baseline, measuredWidth2, baseline + measuredWidth3, this.ML.getMeasuredHeight() + measuredWidth2);
        this.MN = f;
        this.MQ = false;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != ErrorDialogData.SUPPRESSED) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.MJ.measure(childMeasureSpec2, childMeasureSpec);
        this.MK.measure(childMeasureSpec2, childMeasureSpec);
        this.ML.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == ErrorDialogData.SUPPRESSED) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.MK.getMeasuredHeight());
        }
        setMeasuredDimension(size, View.resolveSizeAndState(paddingTop, i2, this.MK.getMeasuredState() << 16));
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.MI != null) {
            if (this.MN >= 0.0f) {
                f = this.MN;
            }
            a(this.MM, f, true);
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
