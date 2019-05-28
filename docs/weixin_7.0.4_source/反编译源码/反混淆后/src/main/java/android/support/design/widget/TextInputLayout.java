package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.C37097a.C37096a;
import android.support.p057v4.content.C0380b;
import android.support.p057v4.p058a.p059a.C0280a;
import android.support.p057v4.view.AbsSavedState;
import android.support.p057v4.view.C0449a;
import android.support.p057v4.view.C0477s;
import android.support.p057v4.view.p067a.C0445b;
import android.support.p057v4.widget.C0540q;
import android.support.p057v4.widget.C31872u;
import android.support.p057v4.widget.Space;
import android.support.p069v7.p071c.p072a.C0589b;
import android.support.p069v7.widget.AppCompatTextView;
import android.support.p069v7.widget.C0679aa;
import android.support.p069v7.widget.C0699bc;
import android.support.p069v7.widget.C0710bl;
import android.support.p069v7.widget.C0716i;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AccelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;

public class TextInputLayout extends LinearLayout implements C0710bl {
    /* renamed from: oT */
    private final Rect f3743oT;
    /* renamed from: oU */
    final C44944f f3744oU;
    /* renamed from: rD */
    private ValueAnimator f3745rD;
    /* renamed from: tA */
    private boolean f3746tA;
    /* renamed from: tB */
    private Drawable f3747tB;
    /* renamed from: tC */
    private CharSequence f3748tC;
    /* renamed from: tD */
    private CheckableImageButton f3749tD;
    /* renamed from: tE */
    private boolean f3750tE;
    /* renamed from: tF */
    private Drawable f3751tF;
    /* renamed from: tG */
    private Drawable f3752tG;
    /* renamed from: tH */
    private ColorStateList f3753tH;
    /* renamed from: tI */
    private boolean f3754tI;
    /* renamed from: tJ */
    private Mode f3755tJ;
    /* renamed from: tK */
    private boolean f3756tK;
    /* renamed from: tL */
    private ColorStateList f3757tL;
    /* renamed from: tM */
    private ColorStateList f3758tM;
    /* renamed from: tN */
    private boolean f3759tN;
    /* renamed from: tO */
    private boolean f3760tO;
    /* renamed from: tP */
    private boolean f3761tP;
    /* renamed from: tQ */
    private boolean f3762tQ;
    /* renamed from: tR */
    private boolean f3763tR;
    /* renamed from: tb */
    private final FrameLayout f3764tb;
    /* renamed from: tc */
    EditText f3765tc;
    /* renamed from: td */
    private CharSequence f3766td;
    /* renamed from: te */
    private boolean f3767te;
    /* renamed from: tf */
    private CharSequence f3768tf;
    /* renamed from: tg */
    private Paint f3769tg;
    /* renamed from: th */
    private LinearLayout f3770th;
    /* renamed from: ti */
    private int f3771ti;
    /* renamed from: tj */
    private Typeface f3772tj;
    /* renamed from: tk */
    private boolean f3773tk;
    /* renamed from: tm */
    TextView f3774tm;
    /* renamed from: tn */
    private int f3775tn;
    /* renamed from: to */
    private boolean f3776to;
    /* renamed from: tp */
    private CharSequence f3777tp;
    /* renamed from: tq */
    boolean f3778tq;
    /* renamed from: tt */
    private TextView f3779tt;
    /* renamed from: tu */
    private int f3780tu;
    /* renamed from: tv */
    private int f3781tv;
    /* renamed from: tw */
    private int f3782tw;
    /* renamed from: tz */
    private boolean f3783tz;

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new C83421();
        /* renamed from: tU */
        CharSequence f2278tU;
        /* renamed from: tV */
        boolean f2279tV;

        /* renamed from: android.support.design.widget.TextInputLayout$SavedState$1 */
        static class C83421 implements ClassLoaderCreator<SavedState> {
            C83421() {
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2278tU = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2279tV = parcel.readInt() == 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f2278tU, parcel, i);
            parcel.writeInt(this.f2279tV ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f2278tU + "}";
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$4 */
    class C173854 implements OnClickListener {
        C173854() {
        }

        public final void onClick(View view) {
            TextInputLayout.this.m27002s(false);
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$5 */
    class C173875 implements AnimatorUpdateListener {
        C173875() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.f3744oU.mo72158i(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$a */
    class C17388a extends C0449a {
        C17388a() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence charSequence = TextInputLayout.this.f3744oU.mText;
            if (!TextUtils.isEmpty(charSequence)) {
                accessibilityEvent.getText().add(charSequence);
            }
        }

        public final void onInitializeAccessibilityNodeInfo(View view, C0445b c0445b) {
            super.onInitializeAccessibilityNodeInfo(view, c0445b);
            c0445b.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence charSequence = TextInputLayout.this.f3744oU.mText;
            if (!TextUtils.isEmpty(charSequence)) {
                c0445b.setText(charSequence);
            }
            if (TextInputLayout.this.f3765tc != null) {
                EditText editText = TextInputLayout.this.f3765tc;
                if (VERSION.SDK_INT >= 17) {
                    c0445b.f546NG.setLabelFor(editText);
                }
            }
            charSequence = TextInputLayout.this.f3774tm != null ? TextInputLayout.this.f3774tm.getText() : null;
            if (!TextUtils.isEmpty(charSequence)) {
                if (VERSION.SDK_INT >= 19) {
                    c0445b.f546NG.setContentInvalid(true);
                }
                if (VERSION.SDK_INT >= 21) {
                    c0445b.f546NG.setError(charSequence);
                }
            }
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$1 */
    class C173891 implements TextWatcher {
        C173891() {
        }

        public final void afterTextChanged(Editable editable) {
            boolean z;
            TextInputLayout textInputLayout = TextInputLayout.this;
            if (TextInputLayout.this.f3763tR) {
                z = false;
            } else {
                z = true;
            }
            textInputLayout.mo31561d(z, false);
            if (TextInputLayout.this.f3778tq) {
                TextInputLayout.this.mo31560ak(editable.length());
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: android.support.design.widget.TextInputLayout$2 */
    class C173902 extends AnimatorListenerAdapter {
        C173902() {
        }

        public final void onAnimationStart(Animator animator) {
            TextInputLayout.this.f3774tm.setVisibility(0);
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.f3743oT = new Rect();
        this.f3744oU = new C44944f(this);
        C41488o.m72457G(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f3764tb = new FrameLayout(context);
        this.f3764tb.setAddStatesFromChildren(true);
        addView(this.f3764tb);
        this.f3744oU.mo72151b(C31841a.f14580mg);
        C44944f c44944f = this.f3744oU;
        c44944f.f17624oA = new AccelerateInterpolator();
        c44944f.mo72153bT();
        this.f3744oU.mo72146Q(8388659);
        C0699bc a = C0699bc.m1555a(context, attributeSet, C37096a.TextInputLayout, i, C25738R.style.f11384yt);
        this.f3767te = a.getBoolean(3, true);
        setHint(a.getText(1));
        this.f3760tO = a.getBoolean(10, true);
        if (a.hasValue(0)) {
            ColorStateList colorStateList = a.getColorStateList(0);
            this.f3758tM = colorStateList;
            this.f3757tL = colorStateList;
        }
        if (a.getResourceId(2, -1) != -1) {
            setHintTextAppearance(a.getResourceId(2, 0));
        }
        this.f3775tn = a.getResourceId(5, 0);
        boolean z = a.getBoolean(4, false);
        boolean z2 = a.getBoolean(6, false);
        setCounterMaxLength(a.getInt(7, -1));
        this.f3781tv = a.getResourceId(8, 0);
        this.f3782tw = a.getResourceId(9, 0);
        this.f3746tA = a.getBoolean(11, false);
        this.f3747tB = a.getDrawable(12);
        this.f3748tC = a.getText(13);
        if (a.hasValue(14)) {
            this.f3754tI = true;
            this.f3753tH = a.getColorStateList(14);
        }
        if (a.hasValue(15)) {
            this.f3756tK = true;
            this.f3755tJ = C41490q.m72461al(a.getInt(15, -1));
        }
        a.atG.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        m26994cC();
        if (C0477s.m892S(this) == 0) {
            C0477s.m949o(this, 1);
        }
        C0477s.m905a((View) this, new C17388a());
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f3764tb.addView(view, layoutParams2);
            this.f3764tb.setLayoutParams(layoutParams);
            m26995cv();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        if ((this.f3772tj != null && !this.f3772tj.equals(typeface)) || (this.f3772tj == null && typeface != null)) {
            this.f3772tj = typeface;
            this.f3744oU.mo72149a(typeface);
            if (this.f3779tt != null) {
                this.f3779tt.setTypeface(typeface);
            }
            if (this.f3774tm != null) {
                this.f3774tm.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.f3772tj;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.f3766td == null || this.f3765tc == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        CharSequence hint = this.f3765tc.getHint();
        this.f3765tc.setHint(this.f3766td);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.f3765tc.setHint(hint);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f3765tc != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.f3765tc = editText;
        if (!m26992cA()) {
            this.f3744oU.mo72149a(this.f3765tc.getTypeface());
        }
        C44944f c44944f = this.f3744oU;
        float textSize = this.f3765tc.getTextSize();
        if (c44944f.f17635ob != textSize) {
            c44944f.f17635ob = textSize;
            c44944f.mo72153bT();
        }
        int gravity = this.f3765tc.getGravity();
        this.f3744oU.mo72146Q((gravity & -113) | 48);
        this.f3744oU.mo72145P(gravity);
        this.f3765tc.addTextChangedListener(new C173891());
        if (this.f3757tL == null) {
            this.f3757tL = this.f3765tc.getHintTextColors();
        }
        if (this.f3767te && TextUtils.isEmpty(this.f3768tf)) {
            this.f3766td = this.f3765tc.getHint();
            setHint(this.f3766td);
            this.f3765tc.setHint(null);
        }
        if (this.f3779tt != null) {
            mo31560ak(this.f3765tc.getText().length());
        }
        if (this.f3770th != null) {
            m26996cw();
        }
        m26999cz();
        mo31561d(false, true);
    }

    /* renamed from: cv */
    private void m26995cv() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3764tb.getLayoutParams();
        if (this.f3767te) {
            if (this.f3769tg == null) {
                this.f3769tg = new Paint();
            }
            this.f3769tg.setTypeface(this.f3744oU.mo72152bN());
            this.f3769tg.setTextSize(this.f3744oU.f17636oc);
            i = (int) (-this.f3769tg.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.f3764tb.requestLayout();
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo31561d(boolean z, boolean z2) {
        Object obj = 1;
        boolean isEnabled = isEnabled();
        Object obj2 = (this.f3765tc == null || TextUtils.isEmpty(this.f3765tc.getText())) ? null : 1;
        boolean d = m27000d(getDrawableState());
        if (TextUtils.isEmpty(getError())) {
            obj = null;
        }
        if (this.f3757tL != null) {
            this.f3744oU.mo72155c(this.f3757tL);
        }
        if (isEnabled && this.f3783tz && this.f3779tt != null) {
            this.f3744oU.mo72150b(this.f3779tt.getTextColors());
        } else if (isEnabled && d && this.f3758tM != null) {
            this.f3744oU.mo72150b(this.f3758tM);
        } else if (this.f3757tL != null) {
            this.f3744oU.mo72150b(this.f3757tL);
        }
        if (obj2 != null || (isEnabled() && (d || obj != null))) {
            if (z2 || this.f3759tN) {
                m27003t(z);
            }
        } else if (z2 || !this.f3759tN) {
            m27004u(z);
        }
    }

    public EditText getEditText() {
        return this.f3765tc;
    }

    public void setHint(CharSequence charSequence) {
        if (this.f3767te) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.f3768tf = charSequence;
        this.f3744oU.setText(charSequence);
    }

    public CharSequence getHint() {
        return this.f3767te ? this.f3768tf : null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f3767te) {
            this.f3767te = z;
            CharSequence hint = this.f3765tc.getHint();
            if (!this.f3767te) {
                if (!TextUtils.isEmpty(this.f3768tf) && TextUtils.isEmpty(hint)) {
                    this.f3765tc.setHint(this.f3768tf);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.f3768tf)) {
                    setHint(hint);
                }
                this.f3765tc.setHint(null);
            }
            if (this.f3765tc != null) {
                m26995cv();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.f3744oU.mo72147R(i);
        this.f3758tM = this.f3744oU.f17638oe;
        if (this.f3765tc != null) {
            mo31561d(false, false);
            m26995cv();
        }
    }

    /* renamed from: a */
    private void m26989a(TextView textView, int i) {
        if (this.f3770th == null) {
            this.f3770th = new LinearLayout(getContext());
            this.f3770th.setOrientation(0);
            addView(this.f3770th, -1, -2);
            this.f3770th.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f3765tc != null) {
                m26996cw();
            }
        }
        this.f3770th.setVisibility(0);
        this.f3770th.addView(textView, i);
        this.f3771ti++;
    }

    /* renamed from: cw */
    private void m26996cw() {
        C0477s.m939d(this.f3770th, C0477s.m896W(this.f3765tc), 0, C0477s.m897X(this.f3765tc), this.f3765tc.getPaddingBottom());
    }

    /* renamed from: a */
    private void m26988a(TextView textView) {
        if (this.f3770th != null) {
            this.f3770th.removeView(textView);
            int i = this.f3771ti - 1;
            this.f3771ti = i;
            if (i == 0) {
                this.f3770th.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        int i = 1;
        if (this.f3773tk != z) {
            if (this.f3774tm != null) {
                this.f3774tm.animate().cancel();
            }
            if (z) {
                this.f3774tm = new AppCompatTextView(getContext());
                this.f3774tm.setId(2131820677);
                if (this.f3772tj != null) {
                    this.f3774tm.setTypeface(this.f3772tj);
                }
                try {
                    C0540q.m1167b(this.f3774tm, this.f3775tn);
                    if (VERSION.SDK_INT < 23 || this.f3774tm.getTextColors().getDefaultColor() != -65281) {
                        i = 0;
                    }
                } catch (Exception e) {
                }
                if (i != 0) {
                    C0540q.m1167b(this.f3774tm, C25738R.style.f11198sg);
                    this.f3774tm.setTextColor(C0380b.m652i(getContext(), C25738R.color.f11960n7));
                }
                this.f3774tm.setVisibility(4);
                C0477s.m895V(this.f3774tm);
                m26989a(this.f3774tm, 0);
            } else {
                this.f3776to = false;
                m26997cx();
                m26988a(this.f3774tm);
                this.f3774tm = null;
            }
            this.f3773tk = z;
        }
    }

    public void setErrorTextAppearance(int i) {
        this.f3775tn = i;
        if (this.f3774tm != null) {
            C0540q.m1167b(this.f3774tm, i);
        }
    }

    public void setError(final CharSequence charSequence) {
        boolean z;
        boolean z2 = true;
        if (C0477s.m927as(this) && isEnabled() && (this.f3774tm == null || !TextUtils.equals(this.f3774tm.getText(), charSequence))) {
            z = true;
        } else {
            z = false;
        }
        this.f3777tp = charSequence;
        if (!this.f3773tk) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            z2 = false;
        }
        this.f3776to = z2;
        this.f3774tm.animate().cancel();
        if (this.f3776to) {
            this.f3774tm.setText(charSequence);
            this.f3774tm.setVisibility(0);
            if (z) {
                if (this.f3774tm.getAlpha() == 1.0f) {
                    this.f3774tm.setAlpha(0.0f);
                }
                this.f3774tm.animate().alpha(1.0f).setDuration(200).setInterpolator(C31841a.f14582mi).setListener(new C173902()).start();
            } else {
                this.f3774tm.setAlpha(1.0f);
            }
        } else if (this.f3774tm.getVisibility() == 0) {
            if (z) {
                this.f3774tm.animate().alpha(0.0f).setDuration(200).setInterpolator(C31841a.f14581mh).setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        TextInputLayout.this.f3774tm.setText(charSequence);
                        TextInputLayout.this.f3774tm.setVisibility(4);
                    }
                }).start();
            } else {
                this.f3774tm.setText(charSequence);
                this.f3774tm.setVisibility(4);
            }
        }
        m26997cx();
        mo31561d(z, false);
    }

    public void setCounterEnabled(boolean z) {
        if (this.f3778tq != z) {
            if (z) {
                this.f3779tt = new AppCompatTextView(getContext());
                this.f3779tt.setId(2131820676);
                if (this.f3772tj != null) {
                    this.f3779tt.setTypeface(this.f3772tj);
                }
                this.f3779tt.setMaxLines(1);
                try {
                    C0540q.m1167b(this.f3779tt, this.f3781tv);
                } catch (Exception e) {
                    C0540q.m1167b(this.f3779tt, C25738R.style.f11198sg);
                    this.f3779tt.setTextColor(C0380b.m652i(getContext(), C25738R.color.f11960n7));
                }
                m26989a(this.f3779tt, -1);
                if (this.f3765tc == null) {
                    mo31560ak(0);
                } else {
                    mo31560ak(this.f3765tc.getText().length());
                }
            } else {
                m26988a(this.f3779tt);
                this.f3779tt = null;
            }
            this.f3778tq = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f3780tu != i) {
            if (i > 0) {
                this.f3780tu = i;
            } else {
                this.f3780tu = -1;
            }
            if (this.f3778tq) {
                mo31560ak(this.f3765tc == null ? 0 : this.f3765tc.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        m26987a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    /* renamed from: a */
    private static void m26987a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m26987a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.f3780tu;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ak */
    public final void mo31560ak(int i) {
        boolean z = this.f3783tz;
        if (this.f3780tu == -1) {
            this.f3779tt.setText(String.valueOf(i));
            this.f3783tz = false;
        } else {
            this.f3783tz = i > this.f3780tu;
            if (z != this.f3783tz) {
                C0540q.m1167b(this.f3779tt, this.f3783tz ? this.f3782tw : this.f3781tv);
            }
            this.f3779tt.setText(getContext().getString(C25738R.string.g6d, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f3780tu)}));
        }
        if (this.f3765tc != null && z != this.f3783tz) {
            mo31561d(false, false);
            m26997cx();
        }
    }

    /* renamed from: cx */
    private void m26997cx() {
        if (this.f3765tc != null) {
            Drawable background = this.f3765tc.getBackground();
            if (background != null) {
                m26998cy();
                if (C0679aa.m1531o(background)) {
                    background = background.mutate();
                }
                if (this.f3776to && this.f3774tm != null) {
                    background.setColorFilter(C0716i.m1594a(this.f3774tm.getCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.f3783tz || this.f3779tt == null) {
                    C0280a.m466e(background);
                    this.f3765tc.refreshDrawableState();
                } else {
                    background.setColorFilter(C0716i.m1594a(this.f3779tt.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    /* renamed from: cy */
    private void m26998cy() {
        int i = VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.f3765tc.getBackground();
            if (background != null && !this.f3761tP) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.f3761tP = C37099g.m62061a((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.f3761tP) {
                    C0477s.m904a(this.f3765tc, newDrawable);
                    this.f3761tP = true;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f3776to) {
            savedState.f2278tU = getError();
        }
        savedState.f2279tV = this.f3750tE;
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.f507LC);
            setError(savedState.f2278tU);
            if (savedState.f2279tV) {
                m27002s(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f3763tR = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f3763tR = false;
    }

    public CharSequence getError() {
        return this.f3773tk ? this.f3777tp : null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f3760tO = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f3767te) {
            this.f3744oU.draw(canvas);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        m26999cz();
        super.onMeasure(i, i2);
    }

    /* renamed from: cz */
    private void m26999cz() {
        if (this.f3765tc != null) {
            Drawable[] c;
            if (m26993cB()) {
                if (this.f3749tD == null) {
                    this.f3749tD = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(2130969284, this.f3764tb, false);
                    this.f3749tD.setImageDrawable(this.f3747tB);
                    this.f3749tD.setContentDescription(this.f3748tC);
                    this.f3764tb.addView(this.f3749tD);
                    this.f3749tD.setOnClickListener(new C173854());
                }
                if (this.f3765tc != null && C0477s.m909aa(this.f3765tc) <= 0) {
                    this.f3765tc.setMinimumHeight(C0477s.m909aa(this.f3749tD));
                }
                this.f3749tD.setVisibility(0);
                this.f3749tD.setChecked(this.f3750tE);
                if (this.f3751tF == null) {
                    this.f3751tF = new ColorDrawable();
                }
                this.f3751tF.setBounds(0, 0, this.f3749tD.getMeasuredWidth(), 1);
                c = C0540q.m1168c(this.f3765tc);
                if (c[2] != this.f3751tF) {
                    this.f3752tG = c[2];
                }
                C0540q.m1165a(this.f3765tc, c[0], c[1], this.f3751tF, c[3]);
                this.f3749tD.setPadding(this.f3765tc.getPaddingLeft(), this.f3765tc.getPaddingTop(), this.f3765tc.getPaddingRight(), this.f3765tc.getPaddingBottom());
                return;
            }
            if (this.f3749tD != null && this.f3749tD.getVisibility() == 0) {
                this.f3749tD.setVisibility(8);
            }
            if (this.f3751tF != null) {
                c = C0540q.m1168c(this.f3765tc);
                if (c[2] == this.f3751tF) {
                    C0540q.m1165a(this.f3765tc, c[0], c[1], this.f3752tG, c[3]);
                    this.f3751tF = null;
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? C0589b.m1275g(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f3747tB = drawable;
        if (this.f3749tD != null) {
            this.f3749tD.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f3748tC = charSequence;
        if (this.f3749tD != null) {
            this.f3749tD.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f3747tB;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f3748tC;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.f3746tA != z) {
            this.f3746tA = z;
            if (!(z || !this.f3750tE || this.f3765tc == null)) {
                this.f3765tc.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.f3750tE = false;
            m26999cz();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f3753tH = colorStateList;
        this.f3754tI = true;
        m26994cC();
    }

    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.f3755tJ = mode;
        this.f3756tK = true;
        m26994cC();
    }

    /* renamed from: s */
    private void m27002s(boolean z) {
        if (this.f3746tA) {
            int selectionEnd = this.f3765tc.getSelectionEnd();
            if (m26992cA()) {
                this.f3765tc.setTransformationMethod(null);
                this.f3750tE = true;
            } else {
                this.f3765tc.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f3750tE = false;
            }
            this.f3749tD.setChecked(this.f3750tE);
            if (z) {
                this.f3749tD.jumpDrawablesToCurrentState();
            }
            this.f3765tc.setSelection(selectionEnd);
        }
    }

    /* renamed from: cA */
    private boolean m26992cA() {
        return this.f3765tc != null && (this.f3765tc.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    /* renamed from: cB */
    private boolean m26993cB() {
        return this.f3746tA && (m26992cA() || this.f3750tE);
    }

    /* renamed from: cC */
    private void m26994cC() {
        if (this.f3747tB == null) {
            return;
        }
        if (this.f3754tI || this.f3756tK) {
            this.f3747tB = C0280a.m467f(this.f3747tB).mutate();
            if (this.f3754tI) {
                C0280a.m457a(this.f3747tB, this.f3753tH);
            }
            if (this.f3756tK) {
                C0280a.m460a(this.f3747tB, this.f3755tJ);
            }
            if (this.f3749tD != null && this.f3749tD.getDrawable() != this.f3747tB) {
                this.f3749tD.setImageDrawable(this.f3747tB);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3767te && this.f3765tc != null) {
            Rect rect = this.f3743oT;
            C31872u.m51651a((ViewGroup) this, this.f3765tc, rect);
            int compoundPaddingLeft = rect.left + this.f3765tc.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.f3765tc.getCompoundPaddingRight();
            this.f3744oU.mo72154c(compoundPaddingLeft, rect.top + this.f3765tc.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f3765tc.getCompoundPaddingBottom());
            this.f3744oU.mo72156d(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
            this.f3744oU.mo72153bT();
        }
    }

    /* renamed from: t */
    private void m27003t(boolean z) {
        if (this.f3745rD != null && this.f3745rD.isRunning()) {
            this.f3745rD.cancel();
        }
        if (z && this.f3760tO) {
            m27001q(1.0f);
        } else {
            this.f3744oU.mo72158i(1.0f);
        }
        this.f3759tN = false;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        boolean z = true;
        if (!this.f3762tQ) {
            int state;
            this.f3762tQ = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!(C0477s.m927as(this) && isEnabled())) {
                z = false;
            }
            mo31561d(z, false);
            m26997cx();
            if (this.f3744oU != null) {
                state = this.f3744oU.setState(drawableState) | 0;
            } else {
                state = 0;
            }
            if (state != 0) {
                invalidate();
            }
            this.f3762tQ = false;
        }
    }

    /* renamed from: u */
    private void m27004u(boolean z) {
        if (this.f3745rD != null && this.f3745rD.isRunning()) {
            this.f3745rD.cancel();
        }
        if (z && this.f3760tO) {
            m27001q(0.0f);
        } else {
            this.f3744oU.mo72158i(0.0f);
        }
        this.f3759tN = true;
    }

    /* renamed from: q */
    private void m27001q(float f) {
        if (this.f3744oU.f17619nV != f) {
            if (this.f3745rD == null) {
                this.f3745rD = new ValueAnimator();
                this.f3745rD.setInterpolator(C31841a.f14579mf);
                this.f3745rD.setDuration(200);
                this.f3745rD.addUpdateListener(new C173875());
            }
            this.f3745rD.setFloatValues(new float[]{this.f3744oU.f17619nV, f});
            this.f3745rD.start();
        }
    }

    /* renamed from: d */
    private static boolean m27000d(int[] iArr) {
        for (int i : iArr) {
            if (i == 16842908) {
                return true;
            }
        }
        return false;
    }
}
