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
import android.support.design.C37097a.C37096a;
import android.support.p057v4.p065f.C37122k.C16505b;
import android.support.p057v4.p065f.C37122k.C25335c;
import android.support.p057v4.p065f.C37122k.C8387a;
import android.support.p057v4.view.C0473q;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.C0434c;
import android.support.p057v4.view.ViewPager.C31865a;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.support.p057v4.widget.C0540q;
import android.support.p057v4.widget.C8415j;
import android.support.p069v7.app.ActionBar.C0556a;
import android.support.p069v7.p070a.C0555a.C0554a;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.widget.C0701be;
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
import com.tencent.p177mm.C25738R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@C31865a
public class TabLayout extends HorizontalScrollView {
    /* renamed from: rR */
    private static final C8387a<C8338e> f2211rR = new C25335c(16);
    int mMode;
    /* renamed from: rS */
    private final ArrayList<C8338e> f2212rS;
    /* renamed from: rT */
    private C8338e f2213rT;
    /* renamed from: rU */
    private final C8335d f2214rU;
    /* renamed from: rV */
    int f2215rV;
    /* renamed from: rW */
    int f2216rW;
    /* renamed from: rX */
    int f2217rX;
    /* renamed from: rY */
    int f2218rY;
    /* renamed from: rZ */
    int f2219rZ;
    /* renamed from: sa */
    ColorStateList f2220sa;
    /* renamed from: sc */
    float f2221sc;
    /* renamed from: sd */
    float f2222sd;
    /* renamed from: se */
    final int f2223se;
    /* renamed from: sf */
    int f2224sf;
    /* renamed from: sg */
    private final int f2225sg;
    /* renamed from: si */
    private final int f2226si;
    /* renamed from: sj */
    private final int f2227sj;
    /* renamed from: sk */
    private int f2228sk;
    /* renamed from: sl */
    int f2229sl;
    /* renamed from: sm */
    private C8334b f2230sm;
    /* renamed from: sn */
    private final ArrayList<C8334b> f2231sn;
    /* renamed from: so */
    private C8334b f2232so;
    /* renamed from: sp */
    private ValueAnimator f2233sp;
    /* renamed from: sq */
    ViewPager f2234sq;
    /* renamed from: sr */
    private C25365p f2235sr;
    /* renamed from: ss */
    private DataSetObserver f2236ss;
    /* renamed from: st */
    private C8339f f2237st;
    /* renamed from: su */
    private C8331a f2238su;
    /* renamed from: sv */
    private boolean f2239sv;
    /* renamed from: sx */
    private final C8387a<C8333g> f2240sx;

    /* renamed from: android.support.design.widget.TabLayout$a */
    class C8331a implements C0434c {
        /* renamed from: sz */
        boolean f2242sz;

        C8331a() {
        }

        /* renamed from: a */
        public final void mo958a(ViewPager viewPager, C25365p c25365p, C25365p c25365p2) {
            if (TabLayout.this.f2234sq == viewPager) {
                TabLayout.this.mo18202a(c25365p2, this.f2242sz);
            }
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$h */
    public static class C8332h implements C8334b {
        /* renamed from: sq */
        private final ViewPager f2243sq;

        public C8332h(ViewPager viewPager) {
            this.f2243sq = viewPager;
        }

        /* renamed from: f */
        public final void mo9140f(C8338e c8338e) {
            this.f2243sq.setCurrentItem(c8338e.mPosition);
        }

        /* renamed from: g */
        public final void mo9141g(C8338e c8338e) {
        }

        /* renamed from: h */
        public final void mo9142h(C8338e c8338e) {
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$g */
    class C8333g extends LinearLayout {
        /* renamed from: sQ */
        private View f2244sQ;
        /* renamed from: sV */
        private C8338e f2245sV;
        /* renamed from: sW */
        private TextView f2246sW;
        /* renamed from: sX */
        private ImageView f2247sX;
        /* renamed from: sY */
        private TextView f2248sY;
        /* renamed from: sZ */
        private ImageView f2249sZ;
        /* renamed from: ta */
        private int f2251ta = 2;

        public C8333g(Context context) {
            super(context);
            if (TabLayout.this.f2223se != 0) {
                C0477s.m904a((View) this, C0589b.m1275g(context, TabLayout.this.f2223se));
            }
            C0477s.m939d(this, TabLayout.this.f2215rV, TabLayout.this.f2216rW, TabLayout.this.f2217rX, TabLayout.this.f2218rY);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            C0477s.m907a((View) this, C0473q.m835U(getContext()));
        }

        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f2245sV == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f2245sV.select();
            return true;
        }

        public final void setSelected(boolean z) {
            Object obj = isSelected() != z ? 1 : null;
            super.setSelected(z);
            if (obj != null && z && VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            if (this.f2246sW != null) {
                this.f2246sW.setSelected(z);
            }
            if (this.f2247sX != null) {
                this.f2247sX.setSelected(z);
            }
            if (this.f2244sQ != null) {
                this.f2244sQ.setSelected(z);
            }
        }

        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(C0556a.class.getName());
        }

        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(C0556a.class.getName());
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
                i = MeasureSpec.makeMeasureSpec(TabLayout.this.f2224sf, C8415j.INVALID_ID);
            }
            super.onMeasure(i, i2);
            if (this.f2246sW != null) {
                getResources();
                float f = TabLayout.this.f2221sc;
                size = this.f2251ta;
                if (this.f2247sX != null && this.f2247sX.getVisibility() == 0) {
                    size = 1;
                } else if (this.f2246sW != null && this.f2246sW.getLineCount() > 1) {
                    f = TabLayout.this.f2222sd;
                }
                float textSize = this.f2246sW.getTextSize();
                int lineCount = this.f2246sW.getLineCount();
                int b = C0540q.m1166b(this.f2246sW);
                if (f != textSize || (b >= 0 && size != b)) {
                    if (TabLayout.this.mMode == 1 && f > textSize && lineCount == 1) {
                        Layout layout = this.f2246sW.getLayout();
                        if (layout != null) {
                        }
                        i3 = 0;
                    }
                    if (i3 != 0) {
                        this.f2246sW.setTextSize(0, f);
                        this.f2246sW.setMaxLines(size);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: i */
        public final void mo18234i(C8338e c8338e) {
            if (c8338e != this.f2245sV) {
                this.f2245sV = c8338e;
                update();
            }
        }

        /* Access modifiers changed, original: final */
        public final void update() {
            View view;
            boolean z;
            C8338e c8338e = this.f2245sV;
            if (c8338e != null) {
                view = c8338e.f2271sQ;
            } else {
                view = null;
            }
            if (view != null) {
                C8333g parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        parent.removeView(view);
                    }
                    addView(view);
                }
                this.f2244sQ = view;
                if (this.f2246sW != null) {
                    this.f2246sW.setVisibility(8);
                }
                if (this.f2247sX != null) {
                    this.f2247sX.setVisibility(8);
                    this.f2247sX.setImageDrawable(null);
                }
                this.f2248sY = (TextView) view.findViewById(16908308);
                if (this.f2248sY != null) {
                    this.f2251ta = C0540q.m1166b(this.f2248sY);
                }
                this.f2249sZ = (ImageView) view.findViewById(16908294);
            } else {
                if (this.f2244sQ != null) {
                    removeView(this.f2244sQ);
                    this.f2244sQ = null;
                }
                this.f2248sY = null;
                this.f2249sZ = null;
            }
            if (this.f2244sQ == null) {
                if (this.f2247sX == null) {
                    ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(2130969275, this, false);
                    addView(imageView, 0);
                    this.f2247sX = imageView;
                }
                if (this.f2246sW == null) {
                    TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(2130969276, this, false);
                    addView(textView);
                    this.f2246sW = textView;
                    this.f2251ta = C0540q.m1166b(this.f2246sW);
                }
                C0540q.m1167b(this.f2246sW, TabLayout.this.f2219rZ);
                if (TabLayout.this.f2220sa != null) {
                    this.f2246sW.setTextColor(TabLayout.this.f2220sa);
                }
                m14726a(this.f2246sW, this.f2247sX);
            } else if (!(this.f2248sY == null && this.f2249sZ == null)) {
                m14726a(this.f2248sY, this.f2249sZ);
            }
            if (c8338e == null || !c8338e.isSelected()) {
                z = false;
            } else {
                z = true;
            }
            setSelected(z);
        }

        /* renamed from: a */
        private void m14726a(TextView textView, ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            CharSequence charSequence2;
            int i;
            CharSequence charSequence3 = null;
            if (this.f2245sV != null) {
                drawable = this.f2245sV.f2268rP;
            } else {
                drawable = null;
            }
            if (this.f2245sV != null) {
                charSequence = this.f2245sV.mText;
            } else {
                charSequence = null;
            }
            if (this.f2245sV != null) {
                charSequence2 = this.f2245sV.f2270sP;
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
                    i2 = TabLayout.this.mo18204ad(8);
                }
                if (i2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i2;
                    imageView.requestLayout();
                }
            }
            if (i == 0) {
                charSequence3 = charSequence2;
            }
            C0701be.m1558a(this, charSequence3);
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$b */
    public interface C8334b {
        /* renamed from: f */
        void mo9140f(C8338e c8338e);

        /* renamed from: g */
        void mo9141g(C8338e c8338e);

        /* renamed from: h */
        void mo9142h(C8338e c8338e);
    }

    /* renamed from: android.support.design.widget.TabLayout$d */
    class C8335d extends LinearLayout {
        /* renamed from: sA */
        private int f2252sA;
        /* renamed from: sB */
        private final Paint f2253sB;
        /* renamed from: sC */
        int f2254sC = -1;
        /* renamed from: sD */
        float f2255sD;
        /* renamed from: sE */
        private int f2256sE = -1;
        /* renamed from: sF */
        private int f2257sF = -1;
        /* renamed from: sG */
        private int f2258sG = -1;
        /* renamed from: sH */
        private ValueAnimator f2259sH;

        C8335d(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f2253sB = new Paint();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ah */
        public final void mo18241ah(int i) {
            if (this.f2253sB.getColor() != i) {
                this.f2253sB.setColor(i);
                C0477s.m891R(this);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ai */
        public final void mo18242ai(int i) {
            if (this.f2252sA != i) {
                this.f2252sA = i;
                C0477s.m891R(this);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: c */
        public final void mo18243c(int i, float f) {
            if (this.f2259sH != null && this.f2259sH.isRunning()) {
                this.f2259sH.cancel();
            }
            this.f2254sC = i;
            this.f2255sD = f;
            m14731ct();
        }

        public final void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (VERSION.SDK_INT < 23 && this.f2256sE != i) {
                requestLayout();
                this.f2256sE = i;
            }
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (MeasureSpec.getMode(i) == ErrorDialogData.SUPPRESSED && TabLayout.this.mMode == 1 && TabLayout.this.f2229sl == 1) {
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
                    if (i4 * childCount <= getMeasuredWidth() - (TabLayout.this.mo18204ad(16) * 2)) {
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
                        TabLayout.this.f2229sl = 0;
                        TabLayout.this.mo18223r(false);
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
            if (this.f2259sH == null || !this.f2259sH.isRunning()) {
                m14731ct();
                return;
            }
            this.f2259sH.cancel();
            mo18246o(this.f2254sC, Math.round(((float) this.f2259sH.getDuration()) * (1.0f - this.f2259sH.getAnimatedFraction())));
        }

        /* renamed from: ct */
        private void m14731ct() {
            int i;
            int i2;
            View childAt = getChildAt(this.f2254sC);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                int right = childAt.getRight();
                if (this.f2255sD <= 0.0f || this.f2254sC >= getChildCount() - 1) {
                    i2 = right;
                } else {
                    View childAt2 = getChildAt(this.f2254sC + 1);
                    i = (int) ((((float) i) * (1.0f - this.f2255sD)) + (this.f2255sD * ((float) childAt2.getLeft())));
                    i2 = (int) ((((float) right) * (1.0f - this.f2255sD)) + (((float) childAt2.getRight()) * this.f2255sD));
                }
            }
            mo18245n(i, i2);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: n */
        public final void mo18245n(int i, int i2) {
            if (i != this.f2257sF || i2 != this.f2258sG) {
                this.f2257sF = i;
                this.f2258sG = i2;
                C0477s.m891R(this);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: o */
        public final void mo18246o(final int i, int i2) {
            if (this.f2259sH != null && this.f2259sH.isRunning()) {
                this.f2259sH.cancel();
            }
            Object obj = C0477s.m893T(this) == 1 ? 1 : null;
            View childAt = getChildAt(i);
            if (childAt == null) {
                m14731ct();
                return;
            }
            int i3;
            int i4;
            final int left = childAt.getLeft();
            final int right = childAt.getRight();
            int i5;
            if (Math.abs(i - this.f2254sC) <= 1) {
                i5 = this.f2257sF;
                i3 = this.f2258sG;
                i4 = i5;
            } else {
                int ad = TabLayout.this.mo18204ad(24);
                if (i < this.f2254sC) {
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
                this.f2259sH = valueAnimator;
                valueAnimator.setInterpolator(C31841a.f14580mg);
                valueAnimator.setDuration((long) i2);
                valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        C8335d.this.mo18245n(C31841a.m51587b(i4, left, animatedFraction), C31841a.m51587b(i3, right, animatedFraction));
                    }
                });
                valueAnimator.addListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        C8335d.this.f2254sC = i;
                        C8335d.this.f2255sD = 0.0f;
                    }
                });
                valueAnimator.start();
            }
        }

        public final void draw(Canvas canvas) {
            super.draw(canvas);
            if (this.f2257sF >= 0 && this.f2258sG > this.f2257sF) {
                canvas.drawRect((float) this.f2257sF, (float) (getHeight() - this.f2252sA), (float) this.f2258sG, (float) getHeight(), this.f2253sB);
            }
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$e */
    public static final class C8338e {
        int mPosition = -1;
        CharSequence mText;
        /* renamed from: rP */
        Drawable f2268rP;
        /* renamed from: sO */
        Object f2269sO;
        /* renamed from: sP */
        CharSequence f2270sP;
        /* renamed from: sQ */
        public View f2271sQ;
        /* renamed from: sR */
        TabLayout f2272sR;
        /* renamed from: sS */
        C8333g f2273sS;

        C8338e() {
        }

        /* renamed from: u */
        private C8338e m14737u(View view) {
            this.f2271sQ = view;
            mo18254cu();
            return this;
        }

        /* renamed from: aj */
        public final C8338e mo18252aj(int i) {
            return m14737u(LayoutInflater.from(this.f2273sS.getContext()).inflate(i, this.f2273sS, false));
        }

        /* renamed from: b */
        public final C8338e mo18253b(CharSequence charSequence) {
            this.mText = charSequence;
            mo18254cu();
            return this;
        }

        public final void select() {
            if (this.f2272sR == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            this.f2272sR.mo18209b(this);
        }

        public final boolean isSelected() {
            if (this.f2272sR != null) {
                return this.f2272sR.getSelectedTabPosition() == this.mPosition;
            } else {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: cu */
        public final void mo18254cu() {
            if (this.f2273sS != null) {
                this.f2273sS.update();
            }
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$f */
    public static class C8339f implements OnPageChangeListener {
        private int mScrollState;
        /* renamed from: sT */
        private final WeakReference<TabLayout> f2274sT;
        /* renamed from: sU */
        private int f2275sU;

        public C8339f(TabLayout tabLayout) {
            this.f2274sT = new WeakReference(tabLayout);
        }

        public final void onPageScrollStateChanged(int i) {
            this.f2275sU = this.mScrollState;
            this.mScrollState = i;
        }

        public final void onPageScrolled(int i, float f, int i2) {
            boolean z = false;
            TabLayout tabLayout = (TabLayout) this.f2274sT.get();
            if (tabLayout != null) {
                boolean z2 = this.mScrollState != 2 || this.f2275sU == 1;
                if (!(this.mScrollState == 2 && this.f2275sU == 0)) {
                    z = true;
                }
                tabLayout.mo18199a(i, f, z2, z);
            }
        }

        public final void onPageSelected(int i) {
            TabLayout tabLayout = (TabLayout) this.f2274sT.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                boolean z = this.mScrollState == 0 || (this.mScrollState == 2 && this.f2275sU == 0);
                tabLayout.mo18210b(tabLayout.mo18203ac(i), z);
            }
        }

        /* Access modifiers changed, original: final */
        public final void reset() {
            this.mScrollState = 0;
            this.f2275sU = 0;
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$1 */
    class C83401 implements AnimatorUpdateListener {
        C83401() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* renamed from: android.support.design.widget.TabLayout$c */
    class C8341c extends DataSetObserver {
        C8341c() {
        }

        public final void onChanged() {
            TabLayout.this.mo18212cq();
        }

        public final void onInvalidated() {
            TabLayout.this.mo18212cq();
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2212rS = new ArrayList();
        this.f2224sf = BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2231sn = new ArrayList();
        this.f2240sx = new C16505b(12);
        C41488o.m72457G(context);
        setHorizontalScrollBarEnabled(false);
        this.f2214rU = new C8335d(context);
        super.addView(this.f2214rU, 0, new FrameLayout.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37096a.TabLayout, i, C25738R.style.f10617f);
        this.f2214rU.mo18242ai(obtainStyledAttributes.getDimensionPixelSize(1, 0));
        this.f2214rU.mo18241ah(obtainStyledAttributes.getColor(0, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(15, 0);
        this.f2218rY = dimensionPixelSize;
        this.f2217rX = dimensionPixelSize;
        this.f2216rW = dimensionPixelSize;
        this.f2215rV = dimensionPixelSize;
        this.f2215rV = obtainStyledAttributes.getDimensionPixelSize(11, this.f2215rV);
        this.f2216rW = obtainStyledAttributes.getDimensionPixelSize(12, this.f2216rW);
        this.f2217rX = obtainStyledAttributes.getDimensionPixelSize(13, this.f2217rX);
        this.f2218rY = obtainStyledAttributes.getDimensionPixelSize(14, this.f2218rY);
        this.f2219rZ = obtainStyledAttributes.getResourceId(8, C25738R.style.f11235tu);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.f2219rZ, C0554a.TextAppearance);
        try {
            this.f2221sc = (float) obtainStyledAttributes2.getDimensionPixelSize(0, 0);
            this.f2220sa = obtainStyledAttributes2.getColorStateList(3);
            if (obtainStyledAttributes.hasValue(9)) {
                this.f2220sa = obtainStyledAttributes.getColorStateList(9);
            }
            if (obtainStyledAttributes.hasValue(10)) {
                dimensionPixelSize = obtainStyledAttributes.getColor(10, 0);
                int defaultColor = this.f2220sa.getDefaultColor();
                r3 = new int[2][];
                int[] iArr = new int[]{SELECTED_STATE_SET, dimensionPixelSize};
                r3[1] = EMPTY_STATE_SET;
                iArr[1] = defaultColor;
                this.f2220sa = new ColorStateList(r3, iArr);
            }
            this.f2225sg = obtainStyledAttributes.getDimensionPixelSize(6, -1);
            this.f2226si = obtainStyledAttributes.getDimensionPixelSize(7, -1);
            this.f2223se = obtainStyledAttributes.getResourceId(3, 0);
            this.f2228sk = obtainStyledAttributes.getDimensionPixelSize(2, 0);
            this.mMode = obtainStyledAttributes.getInt(4, 1);
            this.f2229sl = obtainStyledAttributes.getInt(5, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.f2222sd = (float) resources.getDimensionPixelSize(C25738R.dimen.f10367z_);
            this.f2227sj = resources.getDimensionPixelSize(C25738R.dimen.f9673ax);
            m14707cs();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    public void setSelectedTabIndicatorColor(int i) {
        this.f2214rU.mo18241ah(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.f2214rU.mo18242ai(i);
    }

    private void setScrollPosition$4867b5c2(int i) {
        mo18199a(i, 0.0f, true, true);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo18199a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.f2214rU.getChildCount()) {
            if (z2) {
                this.f2214rU.mo18243c(i, f);
            }
            if (this.f2233sp != null && this.f2233sp.isRunning()) {
                this.f2233sp.cancel();
            }
            scrollTo(m14703b(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    private float getScrollPosition() {
        C8335d c8335d = this.f2214rU;
        return c8335d.f2255sD + ((float) c8335d.f2254sC);
    }

    /* renamed from: a */
    public final void mo18201a(C8338e c8338e, boolean z) {
        int size = this.f2212rS.size();
        if (c8338e.f2272sR != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        m14699a(c8338e, size);
        C8333g c8333g = c8338e.f2273sS;
        C8335d c8335d = this.f2214rU;
        int i = c8338e.mPosition;
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        m14701a(layoutParams);
        c8335d.addView(c8333g, i, layoutParams);
        if (z) {
            c8338e.select();
        }
    }

    /* renamed from: a */
    private void m14698a(TabItem tabItem) {
        C8338e cp = mo18211cp();
        if (tabItem.mText != null) {
            cp.mo18253b(tabItem.mText);
        }
        if (tabItem.f2209rP != null) {
            cp.f2268rP = tabItem.f2209rP;
            cp.mo18254cu();
        }
        if (tabItem.f2210rQ != 0) {
            cp.mo18252aj(tabItem.f2210rQ);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            cp.f2270sP = tabItem.getContentDescription();
            cp.mo18254cu();
        }
        mo18201a(cp, this.f2212rS.isEmpty());
    }

    @Deprecated
    public void setOnTabSelectedListener(C8334b c8334b) {
        if (this.f2230sm != null) {
            m14704b(this.f2230sm);
        }
        this.f2230sm = c8334b;
        if (c8334b != null) {
            mo18200a(c8334b);
        }
    }

    /* renamed from: a */
    public final void mo18200a(C8334b c8334b) {
        if (!this.f2231sn.contains(c8334b)) {
            this.f2231sn.add(c8334b);
        }
    }

    /* renamed from: b */
    private void m14704b(C8334b c8334b) {
        this.f2231sn.remove(c8334b);
    }

    /* renamed from: cp */
    public final C8338e mo18211cp() {
        C8338e c8338e = (C8338e) f2211rR.mo6364aA();
        if (c8338e == null) {
            c8338e = new C8338e();
        }
        c8338e.f2272sR = this;
        c8338e.f2273sS = m14697a(c8338e);
        return c8338e;
    }

    public int getTabCount() {
        return this.f2212rS.size();
    }

    /* renamed from: ac */
    public final C8338e mo18203ac(int i) {
        return (i < 0 || i >= getTabCount()) ? null : (C8338e) this.f2212rS.get(i);
    }

    public int getSelectedTabPosition() {
        if (this.f2213rT != null) {
            return this.f2213rT.mPosition;
        }
        return -1;
    }

    private void removeAllTabs() {
        for (int childCount = this.f2214rU.getChildCount() - 1; childCount >= 0; childCount--) {
            C8333g c8333g = (C8333g) this.f2214rU.getChildAt(childCount);
            this.f2214rU.removeViewAt(childCount);
            if (c8333g != null) {
                c8333g.mo18234i(null);
                c8333g.setSelected(false);
                this.f2240sx.release(c8333g);
            }
            requestLayout();
        }
        Iterator it = this.f2212rS.iterator();
        while (it.hasNext()) {
            C8338e c8338e = (C8338e) it.next();
            it.remove();
            c8338e.f2272sR = null;
            c8338e.f2273sS = null;
            c8338e.f2269sO = null;
            c8338e.f2268rP = null;
            c8338e.mText = null;
            c8338e.f2270sP = null;
            c8338e.mPosition = -1;
            c8338e.f2271sQ = null;
            f2211rR.release(c8338e);
        }
        this.f2213rT = null;
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            m14707cs();
        }
    }

    public int getTabMode() {
        return this.mMode;
    }

    public void setTabGravity(int i) {
        if (this.f2229sl != i) {
            this.f2229sl = i;
            m14707cs();
        }
    }

    public int getTabGravity() {
        return this.f2229sl;
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f2220sa != colorStateList) {
            this.f2220sa = colorStateList;
            int size = this.f2212rS.size();
            for (int i = 0; i < size; i++) {
                ((C8338e) this.f2212rS.get(i)).mo18254cu();
            }
        }
    }

    public ColorStateList getTabTextColors() {
        return this.f2220sa;
    }

    /* renamed from: a */
    private void m14700a(ViewPager viewPager, boolean z) {
        if (this.f2234sq != null) {
            if (this.f2237st != null) {
                this.f2234sq.removeOnPageChangeListener(this.f2237st);
            }
            if (this.f2238su != null) {
                this.f2234sq.removeOnAdapterChangeListener(this.f2238su);
            }
        }
        if (this.f2232so != null) {
            m14704b(this.f2232so);
            this.f2232so = null;
        }
        if (viewPager != null) {
            this.f2234sq = viewPager;
            if (this.f2237st == null) {
                this.f2237st = new C8339f(this);
            }
            this.f2237st.reset();
            viewPager.addOnPageChangeListener(this.f2237st);
            this.f2232so = new C8332h(viewPager);
            mo18200a(this.f2232so);
            C25365p adapter = viewPager.getAdapter();
            if (adapter != null) {
                mo18202a(adapter, true);
            }
            if (this.f2238su == null) {
                this.f2238su = new C8331a();
            }
            this.f2238su.f2242sz = true;
            viewPager.addOnAdapterChangeListener(this.f2238su);
            setScrollPosition$4867b5c2(viewPager.getCurrentItem());
        } else {
            this.f2234sq = null;
            mo18202a(null, false);
        }
        this.f2239sv = z;
    }

    @Deprecated
    public void setTabsFromPagerAdapter(C25365p c25365p) {
        mo18202a(c25365p, false);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* Access modifiers changed, original: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2234sq == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m14700a((ViewPager) parent, true);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2239sv) {
            setupWithViewPager(null);
            this.f2239sv = false;
        }
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f2214rU.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo18202a(C25365p c25365p, boolean z) {
        if (!(this.f2235sr == null || this.f2236ss == null)) {
            this.f2235sr.unregisterDataSetObserver(this.f2236ss);
        }
        this.f2235sr = c25365p;
        if (z && c25365p != null) {
            if (this.f2236ss == null) {
                this.f2236ss = new C8341c();
            }
            c25365p.registerDataSetObserver(this.f2236ss);
        }
        mo18212cq();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cq */
    public final void mo18212cq() {
        removeAllTabs();
        if (this.f2235sr != null) {
            int i;
            int count = this.f2235sr.getCount();
            for (i = 0; i < count; i++) {
                mo18201a(mo18211cp().mo18253b(this.f2235sr.getPageTitle(i)), false);
            }
            if (this.f2234sq != null && count > 0) {
                i = this.f2234sq.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    mo18210b(mo18203ac(i), true);
                }
            }
        }
    }

    /* renamed from: a */
    private C8333g m14697a(C8338e c8338e) {
        C8333g c8333g = this.f2240sx != null ? (C8333g) this.f2240sx.mo6364aA() : null;
        if (c8333g == null) {
            c8333g = new C8333g(getContext());
        }
        c8333g.mo18234i(c8338e);
        c8333g.setFocusable(true);
        c8333g.setMinimumWidth(getTabMinWidth());
        return c8333g;
    }

    public void addView(View view) {
        m14710t(view);
    }

    public void addView(View view, int i) {
        m14710t(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        m14710t(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        m14710t(view);
    }

    /* renamed from: t */
    private void m14710t(View view) {
        if (view instanceof TabItem) {
            m14698a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    /* renamed from: a */
    private void m14701a(LayoutParams layoutParams) {
        if (this.mMode == 1 && this.f2229sl == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ad */
    public final int mo18204ad(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        int i3 = 1;
        int ad = (mo18204ad(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case C8415j.INVALID_ID /*-2147483648*/:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(ad, MeasureSpec.getSize(i2)), ErrorDialogData.SUPPRESSED);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(ad, ErrorDialogData.SUPPRESSED);
                break;
        }
        ad = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            if (this.f2226si > 0) {
                ad = this.f2226si;
            } else {
                ad -= mo18204ad(56);
            }
            this.f2224sf = ad;
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

    /* renamed from: ae */
    private void m14702ae(int i) {
        if (i != -1) {
            if (getWindowToken() != null && C0477s.m927as(this)) {
                int i2;
                C8335d c8335d = this.f2214rU;
                int childCount = c8335d.getChildCount();
                for (i2 = 0; i2 < childCount; i2++) {
                    if (c8335d.getChildAt(i2).getWidth() <= 0) {
                        i2 = 1;
                        break;
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    if (getScrollX() != m14703b(i, 0.0f)) {
                        m14706cr();
                        this.f2233sp.setIntValues(new int[]{i2, r3});
                        this.f2233sp.start();
                    }
                    this.f2214rU.mo18246o(i, 300);
                    return;
                }
            }
            setScrollPosition$4867b5c2(i);
        }
    }

    /* renamed from: cr */
    private void m14706cr() {
        if (this.f2233sp == null) {
            this.f2233sp = new ValueAnimator();
            this.f2233sp.setInterpolator(C31841a.f14580mg);
            this.f2233sp.setDuration(300);
            this.f2233sp.addUpdateListener(new C83401());
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void setScrollAnimatorListener(AnimatorListener animatorListener) {
        m14706cr();
        this.f2233sp.addListener(animatorListener);
    }

    private void setSelectedTabView(int i) {
        int childCount = this.f2214rU.getChildCount();
        if (i < childCount) {
            for (int i2 = 0; i2 < childCount; i2++) {
                boolean z;
                View childAt = this.f2214rU.getChildAt(i2);
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
    /* renamed from: b */
    public final void mo18209b(C8338e c8338e) {
        mo18210b(c8338e, true);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo18210b(C8338e c8338e, boolean z) {
        C8338e c8338e2 = this.f2213rT;
        if (c8338e2 != c8338e) {
            int i;
            if (c8338e != null) {
                i = c8338e.mPosition;
            } else {
                i = -1;
            }
            if (z) {
                if ((c8338e2 == null || c8338e2.mPosition == -1) && i != -1) {
                    setScrollPosition$4867b5c2(i);
                } else {
                    m14702ae(i);
                }
                if (i != -1) {
                    setSelectedTabView(i);
                }
            }
            if (c8338e2 != null) {
                m14708d(c8338e2);
            }
            this.f2213rT = c8338e;
            if (c8338e != null) {
                m14705c(c8338e);
            }
        } else if (c8338e2 != null) {
            m14709e(c8338e);
            m14702ae(c8338e.mPosition);
        }
    }

    /* renamed from: c */
    private void m14705c(C8338e c8338e) {
        for (int size = this.f2231sn.size() - 1; size >= 0; size--) {
            ((C8334b) this.f2231sn.get(size)).mo9140f(c8338e);
        }
    }

    /* renamed from: d */
    private void m14708d(C8338e c8338e) {
        for (int size = this.f2231sn.size() - 1; size >= 0; size--) {
            ((C8334b) this.f2231sn.get(size)).mo9141g(c8338e);
        }
    }

    /* renamed from: e */
    private void m14709e(C8338e c8338e) {
        for (int size = this.f2231sn.size() - 1; size >= 0; size--) {
            ((C8334b) this.f2231sn.get(size)).mo9142h(c8338e);
        }
    }

    /* renamed from: b */
    private int m14703b(int i, float f) {
        int i2 = 0;
        if (this.mMode != 0) {
            return 0;
        }
        int width;
        View childAt = this.f2214rU.getChildAt(i);
        View childAt2 = i + 1 < this.f2214rU.getChildCount() ? this.f2214rU.getChildAt(i + 1) : null;
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
        return C0477s.m893T(this) == 0 ? i2 + left : left - i2;
    }

    /* renamed from: cs */
    private void m14707cs() {
        int max;
        if (this.mMode == 0) {
            max = Math.max(0, this.f2228sk - this.f2215rV);
        } else {
            max = 0;
        }
        C0477s.m939d(this.f2214rU, max, 0, 0, 0);
        switch (this.mMode) {
            case 0:
                this.f2214rU.setGravity(8388611);
                break;
            case 1:
                this.f2214rU.setGravity(1);
                break;
        }
        mo18223r(true);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: r */
    public final void mo18223r(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2214rU.getChildCount()) {
                View childAt = this.f2214rU.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                m14701a((LayoutParams) childAt.getLayoutParams());
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
        int size = this.f2212rS.size();
        for (int i = 0; i < size; i++) {
            C8338e c8338e = (C8338e) this.f2212rS.get(i);
            if (c8338e != null && c8338e.f2268rP != null && !TextUtils.isEmpty(c8338e.mText)) {
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
        if (this.f2225sg != -1) {
            return this.f2225sg;
        }
        return this.mMode == 0 ? this.f2227sj : 0;
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    /* Access modifiers changed, original: 0000 */
    public int getTabMaxWidth() {
        return this.f2224sf;
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m14700a(viewPager, false);
    }

    /* renamed from: a */
    private void m14699a(C8338e c8338e, int i) {
        c8338e.mPosition = i;
        this.f2212rS.add(i, c8338e);
        int size = this.f2212rS.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((C8338e) this.f2212rS.get(i2)).mPosition = i2;
        }
    }
}
