package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.support.v4.view.q;
import android.support.v4.view.s;
import android.support.v4.widget.j;
import android.support.v7.widget.be;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@android.support.v4.view.ViewPager.a
public class TabLayout extends HorizontalScrollView {
    private static final android.support.v4.f.k.a<e> rR = new android.support.v4.f.k.c(16);
    int mMode;
    private final ArrayList<e> rS;
    private e rT;
    private final d rU;
    int rV;
    int rW;
    int rX;
    int rY;
    int rZ;
    ColorStateList sa;
    float sc;
    float sd;
    final int se;
    int sf;
    private final int sg;
    private final int si;
    private final int sj;
    private int sk;
    int sl;
    private b sm;
    private final ArrayList<b> sn;
    private b so;
    private ValueAnimator sp;
    ViewPager sq;
    private p sr;
    private DataSetObserver ss;
    private f st;
    private a su;
    private boolean sv;
    private final android.support.v4.f.k.a<g> sx;

    class a implements android.support.v4.view.ViewPager.c {
        boolean sz;

        a() {
        }

        public final void a(ViewPager viewPager, p pVar, p pVar2) {
            if (TabLayout.this.sq == viewPager) {
                TabLayout.this.a(pVar2, this.sz);
            }
        }
    }

    public static class h implements b {
        private final ViewPager sq;

        public h(ViewPager viewPager) {
            this.sq = viewPager;
        }

        public final void f(e eVar) {
            this.sq.setCurrentItem(eVar.mPosition);
        }

        public final void g(e eVar) {
        }

        public final void h(e eVar) {
        }
    }

    class g extends LinearLayout {
        private View sQ;
        private e sV;
        private TextView sW;
        private ImageView sX;
        private TextView sY;
        private ImageView sZ;
        private int ta = 2;

        public g(Context context) {
            super(context);
            if (TabLayout.this.se != 0) {
                s.a((View) this, android.support.v7.c.a.b.g(context, TabLayout.this.se));
            }
            s.d(this, TabLayout.this.rV, TabLayout.this.rW, TabLayout.this.rX, TabLayout.this.rY);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            s.a((View) this, q.U(getContext()));
        }

        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.sV == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.sV.select();
            return true;
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z && VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.sW != null) {
                this.sW.setSelected(z);
            }
            if (this.sX != null) {
                this.sX.setSelected(z);
            }
            if (this.sQ != null) {
                this.sQ.setSelected(z);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(android.support.v7.app.ActionBar.a.class.getName());
        }

        /* JADX WARNING: Missing block: B:24:0x008b, code skipped:
            if (((r2 / r4.getPaint().getTextSize()) * r4.getLineWidth(0)) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()))) goto L_0x008d;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onMeasure(int i, int i2) {
            int i3 = 1;
            int size = MeasureSpec.getSize(i);
            int mode = MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = MeasureSpec.makeMeasureSpec(TabLayout.this.sf, j.INVALID_ID);
            }
            super.onMeasure(i, i2);
            if (this.sW != null) {
                getResources();
                float f = TabLayout.this.sc;
                size = this.ta;
                if (this.sX != null && this.sX.getVisibility() == 0) {
                    size = 1;
                } else if (this.sW != null && this.sW.getLineCount() > 1) {
                    f = TabLayout.this.sd;
                }
                float textSize = this.sW.getTextSize();
                int lineCount = this.sW.getLineCount();
                int b = android.support.v4.widget.q.b(this.sW);
                if (f != textSize || (b >= 0 && size != b)) {
                    if (TabLayout.this.mMode == 1 && f > textSize && lineCount == 1) {
                        Layout layout = this.sW.getLayout();
                        if (layout != null) {
                        }
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        this.sW.setTextSize(0, f);
                        this.sW.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        /* Access modifiers changed, original: final */
        public final void i(e eVar) {
            if (eVar != this.sV) {
                this.sV = eVar;
                update();
            }
        }

        /* Access modifiers changed, original: final */
        public final void update() {
            View view;
            boolean z;
            e eVar = this.sV;
            if (eVar != null) {
                view = eVar.sQ;
            } else {
                view = null;
            }
            if (view != null) {
                g parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(view);
                    }
                    addView(view);
                }
                this.sQ = view;
                if (this.sW != null) {
                    this.sW.setVisibility(8);
                }
                if (this.sX != null) {
                    this.sX.setVisibility(8);
                    this.sX.setImageDrawable(null);
                }
                this.sY = (TextView) view.findViewById(16908308);
                if (this.sY != null) {
                    this.ta = android.support.v4.widget.q.b(this.sY);
                }
                this.sZ = (ImageView) view.findViewById(16908294);
            } else {
                if (this.sQ != null) {
                    removeView(this.sQ);
                    this.sQ = null;
                }
                this.sY = null;
                this.sZ = null;
            }
            if (this.sQ == null) {
                if (this.sX == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.s5, this, false);
                    addView(imageView, 0);
                    this.sX = imageView;
                }
                if (this.sW == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.s6, this, false);
                    addView(textView);
                    this.sW = textView;
                    this.ta = android.support.v4.widget.q.b(this.sW);
                }
                android.support.v4.widget.q.b(this.sW, TabLayout.this.rZ);
                if (TabLayout.this.sa != null) {
                    this.sW.setTextColor(TabLayout.this.sa);
                }
                a(this.sW, this.sX);
            } else if (!(this.sY == null && this.sZ == null)) {
                a(this.sY, this.sZ);
            }
            if (eVar == null || !eVar.isSelected()) {
                z = false;
            } else {
                z = true;
            }
            setSelected(z);
        }

        private void a(TextView textView, ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            CharSequence charSequence2;
            int i;
            CharSequence charSequence3 = null;
            if (this.sV != null) {
                drawable = this.sV.rP;
            } else {
                drawable = null;
            }
            if (this.sV != null) {
                charSequence = this.sV.mText;
            } else {
                charSequence = null;
            }
            if (this.sV != null) {
                charSequence2 = this.sV.sP;
            } else {
                charSequence2 = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(charSequence2);
            }
            if (TextUtils.isEmpty(charSequence)) {
                i = 0;
            } else {
                i = 1;
            }
            if (textView != null) {
                if (i != 0) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText(null);
                }
                textView.setContentDescription(charSequence2);
            }
            if (imageView != null) {
                int i2;
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
                if (i == 0 || imageView.getVisibility() != 0) {
                    i2 = 0;
                } else {
                    i2 = TabLayout.this.ad(8);
                }
                if (i2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i2;
                    imageView.requestLayout();
                }
            }
            if (i == 0) {
                charSequence3 = charSequence2;
            }
            be.a(this, charSequence3);
        }
    }

    public interface b {
        void f(e eVar);

        void g(e eVar);

        void h(e eVar);
    }

    class d extends LinearLayout {
        private int sA;
        private final Paint sB;
        int sC = -1;
        float sD;
        private int sE = -1;
        private int sF = -1;
        private int sG = -1;
        private ValueAnimator sH;

        d(Context context) {
            super(context);
            setWillNotDraw(false);
            this.sB = new Paint();
        }

        /* Access modifiers changed, original: final */
        public final void ah(int i) {
            if (this.sB.getColor() != i) {
                this.sB.setColor(i);
                s.R(this);
            }
        }

        /* Access modifiers changed, original: final */
        public final void ai(int i) {
            if (this.sA != i) {
                this.sA = i;
                s.R(this);
            }
        }

        /* Access modifiers changed, original: final */
        public final void c(int i, float f) {
            if (this.sH != null && this.sH.isRunning()) {
                this.sH.cancel();
            }
            this.sC = i;
            this.sD = f;
            ct();
        }

        public final void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (VERSION.SDK_INT < 23 && this.sE != i) {
                requestLayout();
                this.sE = i;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == ErrorDialogData.SUPPRESSED && TabLayout.this.mMode == 1 && TabLayout.this.sl == 1) {
                int max;
                int childCount = getChildCount();
                int i3 = 0;
                int i4 = 0;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() == 0) {
                        max = Math.max(i4, childAt.getMeasuredWidth());
                    } else {
                        max = i4;
                    }
                    i3++;
                    i4 = max;
                }
                if (i4 > 0) {
                    if (i4 * childCount <= getMeasuredWidth() - (TabLayout.this.ad(16) * 2)) {
                        i3 = 0;
                        for (int i5 = 0; i5 < childCount; i5++) {
                            LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                            if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                                max = i3;
                            } else {
                                layoutParams.width = i4;
                                layoutParams.weight = 0.0f;
                                max = 1;
                            }
                            i3 = max;
                        }
                    } else {
                        TabLayout.this.sl = 0;
                        TabLayout.this.r(false);
                        i3 = 1;
                    }
                    if (i3 != 0) {
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.sH == null || !this.sH.isRunning()) {
                ct();
                return;
            }
            this.sH.cancel();
            o(this.sC, Math.round(((float) this.sH.getDuration()) * (1.0f - this.sH.getAnimatedFraction())));
        }

        private void ct() {
            int i;
            int i2;
            View childAt = getChildAt(this.sC);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                int right = childAt.getRight();
                if (this.sD <= 0.0f || this.sC >= getChildCount() - 1) {
                    i2 = right;
                } else {
                    View childAt2 = getChildAt(this.sC + 1);
                    i = (int) ((((float) i) * (1.0f - this.sD)) + (this.sD * ((float) childAt2.getLeft())));
                    i2 = (int) ((((float) right) * (1.0f - this.sD)) + (((float) childAt2.getRight()) * this.sD));
                }
            }
            n(i, i2);
        }

        /* Access modifiers changed, original: final */
        public final void n(int i, int i2) {
            if (i != this.sF || i2 != this.sG) {
                this.sF = i;
                this.sG = i2;
                s.R(this);
            }
        }

        /* Access modifiers changed, original: final */
        public final void o(final int i, int i2) {
            if (this.sH != null && this.sH.isRunning()) {
                this.sH.cancel();
            }
            Object obj = s.T(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                ct();
                return;
            }
            int i3;
            int i4;
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            int i5;
            if (Math.abs(i - this.sC) <= 1) {
                i5 = this.sF;
                i3 = this.sG;
                i4 = i5;
            } else {
                int ad = TabLayout.this.ad(24);
                if (i < this.sC) {
                    if (obj == null) {
                        i5 = right + ad;
                        i3 = i5;
                        i4 = i5;
                    }
                } else if (obj != null) {
                    i5 = right + ad;
                    i3 = i5;
                    i4 = i5;
                }
                i5 = left - ad;
                i3 = i5;
                i4 = i5;
            }
            if (i4 != left || i3 != right) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.sH = valueAnimator;
                valueAnimator.setInterpolator(a.mg);
                valueAnimator.setDuration((long) i2);
                valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        d.this.n(a.b(i4, left, animatedFraction), a.b(i3, right, animatedFraction));
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        d.this.sC = i;
                        d.this.sD = 0.0f;
                    }
                });
                valueAnimator.start();
            }
        }

        public final void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.sF >= 0 && this.sG > this.sF) {
                canvas.drawRect((float) this.sF, (float) (getHeight() - this.sA), (float) this.sG, (float) getHeight(), this.sB);
            }
        }
    }

    public static final class e {
        int mPosition = -1;
        CharSequence mText;
        Drawable rP;
        Object sO;
        CharSequence sP;
        public View sQ;
        TabLayout sR;
        g sS;

        e() {
        }

        private e u(View view) {
            this.sQ = view;
            cu();
            return this;
        }

        public final e aj(int i) {
            return u(LayoutInflater.from(this.sS.getContext()).inflate(i, this.sS, false));
        }

        public final e b(CharSequence charSequence) {
            this.mText = charSequence;
            cu();
            return this;
        }

        public final void select() {
            if (this.sR == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.sR.b(this);
        }

        public final boolean isSelected() {
            if (this.sR != null) {
                return this.sR.getSelectedTabPosition() == this.mPosition;
            } else {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
        }

        /* Access modifiers changed, original: final */
        public final void cu() {
            if (this.sS != null) {
                this.sS.update();
            }
        }
    }

    public static class f implements OnPageChangeListener {
        private int mScrollState;
        private final WeakReference<TabLayout> sT;
        private int sU;

        public f(TabLayout tabLayout) {
            this.sT = new WeakReference(tabLayout);
        }

        public final void onPageScrollStateChanged(int i) {
            this.sU = this.mScrollState;
            this.mScrollState = i;
        }

        public final void onPageScrolled(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = (TabLayout) this.sT.get();
            if (tabLayout != null) {
                boolean z2 = this.mScrollState != 2 || this.sU == 1;
                if (!(this.mScrollState == 2 && this.sU == 0)) {
                    z = true;
                }
                tabLayout.a(i, f, z2, z);
            }
        }

        public final void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.sT.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                boolean z = this.mScrollState == 0 || (this.mScrollState == 2 && this.sU == 0);
                tabLayout.b(tabLayout.ac(i), z);
            }
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.mScrollState = 0;
            this.sU = 0;
        }
    }

    class c extends DataSetObserver {
        c() {
        }

        public final void onChanged() {
            TabLayout.this.cq();
        }

        public final void onInvalidated() {
            TabLayout.this.cq();
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.rS = new ArrayList();
        this.sf = BaseClientBuilder.API_PRIORITY_OTHER;
        this.sn = new ArrayList();
        this.sx = new android.support.v4.f.k.b(12);
        o.G(context);
        setHorizontalScrollBarEnabled(false);
        this.rU = new d(context);
        super.addView(this.rU, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, android.support.design.a.a.TabLayout, i, R.style.f);
        this.rU.ai(obtainStyledAttributes.getDimensionPixelSize(1, 0));
        this.rU.ah(obtainStyledAttributes.getColor(0, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.rY = dimensionPixelSize;
        this.rX = dimensionPixelSize;
        this.rW = dimensionPixelSize;
        this.rV = dimensionPixelSize;
        this.rV = obtainStyledAttributes.getDimensionPixelSize(11, this.rV);
        this.rW = obtainStyledAttributes.getDimensionPixelSize(12, this.rW);
        this.rX = obtainStyledAttributes.getDimensionPixelSize(13, this.rX);
        this.rY = obtainStyledAttributes.getDimensionPixelSize(14, this.rY);
        this.rZ = obtainStyledAttributes.getResourceId(8, R.style.tu);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.rZ, android.support.v7.a.a.a.TextAppearance);
        try {
            this.sc = (float) obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            this.sa = obtainStyledAttributes2.getColorStateList(3);
            if (obtainStyledAttributes.hasValue(9)) {
                this.sa = obtainStyledAttributes.getColorStateList(9);
            }
            if (obtainStyledAttributes.hasValue(10)) {
                dimensionPixelSize = obtainStyledAttributes.getColor(10, 0);
                int defaultColor = this.sa.getDefaultColor();
                r3 = new int[2][];
                int[] iArr = new int[]{SELECTED_STATE_SET, dimensionPixelSize};
                r3[1] = EMPTY_STATE_SET;
                iArr[1] = defaultColor;
                this.sa = new ColorStateList(r3, iArr);
            }
            this.sg = obtainStyledAttributes.getDimensionPixelSize(6, -1);
            this.si = obtainStyledAttributes.getDimensionPixelSize(7, -1);
            this.se = obtainStyledAttributes.getResourceId(3, 0);
            this.sk = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.mMode = obtainStyledAttributes.getInt(4, 1);
            this.sl = obtainStyledAttributes.getInt(5, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.sd = (float) resources.getDimensionPixelSize(R.dimen.z_);
            this.sj = resources.getDimensionPixelSize(R.dimen.ax);
            cs();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.rU.ah(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.rU.ai(i);
    }

    private void setScrollPosition$4867b5c2(int i) {
        a(i, 0.0f, true, true);
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.rU.getChildCount()) {
            if (z2) {
                this.rU.c(i, f);
            }
            if (this.sp != null && this.sp.isRunning()) {
                this.sp.cancel();
            }
            scrollTo(b(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        d dVar = this.rU;
        return dVar.sD + ((float) dVar.sC);
    }

    public final void a(e eVar, boolean z) {
        int size = this.rS.size();
        if (eVar.sR != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        a(eVar, size);
        g gVar = eVar.sS;
        d dVar = this.rU;
        int i = eVar.mPosition;
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        a(layoutParams);
        dVar.addView(gVar, i, layoutParams);
        if (z) {
            eVar.select();
        }
    }

    private void a(TabItem tabItem) {
        e cp = cp();
        if (tabItem.mText != null) {
            cp.b(tabItem.mText);
        }
        if (tabItem.rP != null) {
            cp.rP = tabItem.rP;
            cp.cu();
        }
        if (tabItem.rQ != 0) {
            cp.aj(tabItem.rQ);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            cp.sP = tabItem.getContentDescription();
            cp.cu();
        }
        a(cp, this.rS.isEmpty());
    }

    @Deprecated
    public void setOnTabSelectedListener(b bVar) {
        if (this.sm != null) {
            b(this.sm);
        }
        this.sm = bVar;
        if (bVar != null) {
            a(bVar);
        }
    }

    public final void a(b bVar) {
        if (!this.sn.contains(bVar)) {
            this.sn.add(bVar);
        }
    }

    private void b(b bVar) {
        this.sn.remove(bVar);
    }

    public final e cp() {
        e eVar = (e) rR.aA();
        if (eVar == null) {
            eVar = new e();
        }
        eVar.sR = this;
        eVar.sS = a(eVar);
        return eVar;
    }

    public int getTabCount() {
        return this.rS.size();
    }

    public final e ac(int i) {
        return (i < 0 || i >= getTabCount()) ? null : (e) this.rS.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.rT != null) {
            return this.rT.mPosition;
        }
        return -1;
    }

    private void removeAllTabs() {
        for (int childCount = this.rU.getChildCount() - 1; childCount >= 0; childCount--) {
            g gVar = (g) this.rU.getChildAt(childCount);
            this.rU.removeViewAt(childCount);
            if (gVar != null) {
                gVar.i(null);
                gVar.setSelected(false);
                this.sx.release(gVar);
            }
            requestLayout();
        }
        Iterator it = this.rS.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            it.remove();
            eVar.sR = null;
            eVar.sS = null;
            eVar.sO = null;
            eVar.rP = null;
            eVar.mText = null;
            eVar.sP = null;
            eVar.mPosition = -1;
            eVar.sQ = null;
            rR.release(eVar);
        }
        this.rT = null;
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            cs();
        }
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabGravity(int i) {
        if (this.sl != i) {
            this.sl = i;
            cs();
        }
    }

    public int getTabGravity() {
        return this.sl;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.sa != colorStateList) {
            this.sa = colorStateList;
            int size = this.rS.size();
            for (int i = 0; i < size; i++) {
                ((e) this.rS.get(i)).cu();
            }
        }
    }

    public ColorStateList getTabTextColors() {
        return this.sa;
    }

    private void a(ViewPager viewPager, boolean z) {
        if (this.sq != null) {
            if (this.st != null) {
                this.sq.removeOnPageChangeListener(this.st);
            }
            if (this.su != null) {
                this.sq.removeOnAdapterChangeListener(this.su);
            }
        }
        if (this.so != null) {
            b(this.so);
            this.so = null;
        }
        if (viewPager != null) {
            this.sq = viewPager;
            if (this.st == null) {
                this.st = new f(this);
            }
            this.st.reset();
            viewPager.addOnPageChangeListener(this.st);
            this.so = new h(viewPager);
            a(this.so);
            p adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, true);
            }
            if (this.su == null) {
                this.su = new a();
            }
            this.su.sz = true;
            viewPager.addOnAdapterChangeListener(this.su);
            setScrollPosition$4867b5c2(viewPager.getCurrentItem());
        } else {
            this.sq = null;
            a(null, false);
        }
        this.sv = z;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(p pVar) {
        a(pVar, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.sq == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.sv) {
            setupWithViewPager(null);
            this.sv = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.rU.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* Access modifiers changed, original: final */
    public final void a(p pVar, boolean z) {
        if (!(this.sr == null || this.ss == null)) {
            this.sr.unregisterDataSetObserver(this.ss);
        }
        this.sr = pVar;
        if (z && pVar != null) {
            if (this.ss == null) {
                this.ss = new c();
            }
            pVar.registerDataSetObserver(this.ss);
        }
        cq();
    }

    /* Access modifiers changed, original: final */
    public final void cq() {
        removeAllTabs();
        if (this.sr != null) {
            int i;
            int count = this.sr.getCount();
            for (i = 0; i < count; i++) {
                a(cp().b(this.sr.getPageTitle(i)), false);
            }
            if (this.sq != null && count > 0) {
                i = this.sq.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    b(ac(i), true);
                }
            }
        }
    }

    private g a(e eVar) {
        g gVar = this.sx != null ? (g) this.sx.aA() : null;
        if (gVar == null) {
            gVar = new g(getContext());
        }
        gVar.i(eVar);
        gVar.setFocusable(true);
        gVar.setMinimumWidth(getTabMinWidth());
        return gVar;
    }

    public void addView(View view) {
        t(view);
    }

    public void addView(View view, int i) {
        t(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        t(view);
    }

    private void t(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LayoutParams layoutParams) {
        if (this.mMode == 1 && this.sl == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    /* Access modifiers changed, original: final */
    public final int ad(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int ad = (ad(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case j.INVALID_ID /*-2147483648*/:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(ad, MeasureSpec.getSize(i2)), ErrorDialogData.SUPPRESSED);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(ad, ErrorDialogData.SUPPRESSED);
                break;
        }
        ad = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.si > 0) {
                ad = this.si;
            } else {
                ad -= ad(56);
            }
            this.sf = ad;
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.mMode) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        ad = 0;
                        break;
                    } else {
                        ad = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    ad = i3;
                    break;
                default:
                    ad = 0;
                    break;
            }
            if (ad != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), ErrorDialogData.SUPPRESSED), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    private void ae(int i) {
        if (i != -1) {
            if (getWindowToken() != null && s.as(this)) {
                int i2;
                d dVar = this.rU;
                int childCount = dVar.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (dVar.getChildAt(i2).getWidth() <= 0) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    if (getScrollX() != b(i, 0.0f)) {
                        cr();
                        this.sp.setIntValues(new int[]{i2, r3});
                        this.sp.start();
                    }
                    this.rU.o(i, 300);
                    return;
                }
            }
            setScrollPosition$4867b5c2(i);
        }
    }

    private void cr() {
        if (this.sp == null) {
            this.sp = new ValueAnimator();
            this.sp.setInterpolator(a.mg);
            this.sp.setDuration(300);
            this.sp.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setScrollAnimatorListener(AnimatorListener animatorListener) {
        cr();
        this.sp.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.rU.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.rU.getChildAt(i2);
                if (i2 == i) {
                    z = true;
                } else {
                    z = false;
                }
                childAt.setSelected(z);
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(e eVar) {
        b(eVar, true);
    }

    /* Access modifiers changed, original: final */
    public final void b(e eVar, boolean z) {
        e eVar2 = this.rT;
        if (eVar2 != eVar) {
            int i;
            if (eVar != null) {
                i = eVar.mPosition;
            } else {
                i = -1;
            }
            if (z) {
                if ((eVar2 == null || eVar2.mPosition == -1) && i != -1) {
                    setScrollPosition$4867b5c2(i);
                } else {
                    ae(i);
                }
                if (i != -1) {
                    setSelectedTabView(i);
                }
            }
            if (eVar2 != null) {
                d(eVar2);
            }
            this.rT = eVar;
            if (eVar != null) {
                c(eVar);
            }
        } else if (eVar2 != null) {
            e(eVar);
            ae(eVar.mPosition);
        }
    }

    private void c(e eVar) {
        for (int size = this.sn.size() - 1; size >= 0; size--) {
            ((b) this.sn.get(size)).f(eVar);
        }
    }

    private void d(e eVar) {
        for (int size = this.sn.size() - 1; size >= 0; size--) {
            ((b) this.sn.get(size)).g(eVar);
        }
    }

    private void e(e eVar) {
        for (int size = this.sn.size() - 1; size >= 0; size--) {
            ((b) this.sn.get(size)).h(eVar);
        }
    }

    private int b(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        int width;
        View childAt = this.rU.getChildAt(i);
        View childAt2 = i + 1 < this.rU.getChildCount() ? this.rU.getChildAt(i + 1) : null;
        if (childAt != null) {
            width = childAt.getWidth();
        } else {
            width = 0;
        }
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        i2 = (int) ((((float) (i2 + width)) * 0.5f) * f);
        return s.T(this) == 0 ? i2 + left : left - i2;
    }

    private void cs() {
        int max;
        if (this.mMode == 0) {
            max = Math.max(0, this.sk - this.rV);
        } else {
            max = 0;
        }
        s.d(this.rU, max, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.rU.setGravity(8388611);
                break;
            case 1:
                this.rU.setGravity(1);
                break;
        }
        r(true);
    }

    /* Access modifiers changed, original: final */
    public final void r(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.rU.getChildCount()) {
                View childAt = this.rU.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                a((LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.rS.size();
        for (int i = 0; i < size; i++) {
            e eVar = (e) this.rS.get(i);
            if (eVar != null && eVar.rP != null && !TextUtils.isEmpty(eVar.mText)) {
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj != null) {
            return 72;
        }
        return 48;
    }

    private int getTabMinWidth() {
        if (this.sg != -1) {
            return this.sg;
        }
        return this.mMode == 0 ? this.sj : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* Access modifiers changed, original: 0000 */
    public int getTabMaxWidth() {
        return this.sf;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        a(viewPager, false);
    }

    private void a(e eVar, int i) {
        eVar.mPosition = i;
        this.rS.add(i, eVar);
        int size = this.rS.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((e) this.rS.get(i2)).mPosition = i2;
        }
    }
}
