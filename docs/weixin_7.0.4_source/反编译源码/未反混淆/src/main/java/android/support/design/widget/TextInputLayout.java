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
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.a.b;
import android.support.v4.view.s;
import android.support.v4.widget.Space;
import android.support.v4.widget.q;
import android.support.v4.widget.u;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.aa;
import android.support.v7.widget.bc;
import android.support.v7.widget.bl;
import android.support.v7.widget.i;
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
import com.tencent.mm.R;

public class TextInputLayout extends LinearLayout implements bl {
    private final Rect oT;
    final f oU;
    private ValueAnimator rD;
    private boolean tA;
    private Drawable tB;
    private CharSequence tC;
    private CheckableImageButton tD;
    private boolean tE;
    private Drawable tF;
    private Drawable tG;
    private ColorStateList tH;
    private boolean tI;
    private Mode tJ;
    private boolean tK;
    private ColorStateList tL;
    private ColorStateList tM;
    private boolean tN;
    private boolean tO;
    private boolean tP;
    private boolean tQ;
    private boolean tR;
    private final FrameLayout tb;
    EditText tc;
    private CharSequence td;
    private boolean te;
    private CharSequence tf;
    private Paint tg;
    private LinearLayout th;
    private int ti;
    private Typeface tj;
    private boolean tk;
    TextView tm;
    private int tn;
    private boolean to;
    private CharSequence tp;
    boolean tq;
    private TextView tt;
    private int tu;
    private int tv;
    private int tw;
    private boolean tz;

    static class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        CharSequence tU;
        boolean tV;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.tU = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.tV = parcel.readInt() == 1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.tU, parcel, i);
            parcel.writeInt(this.tV ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.tU + "}";
        }
    }

    class a extends android.support.v4.view.a {
        a() {
        }

        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(TextInputLayout.class.getSimpleName());
        }

        public final void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            CharSequence charSequence = TextInputLayout.this.oU.mText;
            if (!TextUtils.isEmpty(charSequence)) {
                accessibilityEvent.getText().add(charSequence);
            }
        }

        public final void onInitializeAccessibilityNodeInfo(View view, b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.setClassName(TextInputLayout.class.getSimpleName());
            CharSequence charSequence = TextInputLayout.this.oU.mText;
            if (!TextUtils.isEmpty(charSequence)) {
                bVar.setText(charSequence);
            }
            if (TextInputLayout.this.tc != null) {
                EditText editText = TextInputLayout.this.tc;
                if (VERSION.SDK_INT >= 17) {
                    bVar.NG.setLabelFor(editText);
                }
            }
            charSequence = TextInputLayout.this.tm != null ? TextInputLayout.this.tm.getText() : null;
            if (!TextUtils.isEmpty(charSequence)) {
                if (VERSION.SDK_INT >= 19) {
                    bVar.NG.setContentInvalid(true);
                }
                if (VERSION.SDK_INT >= 21) {
                    bVar.NG.setError(charSequence);
                }
            }
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.oT = new Rect();
        this.oU = new f(this);
        o.G(context);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.tb = new FrameLayout(context);
        this.tb.setAddStatesFromChildren(true);
        addView(this.tb);
        this.oU.b(a.mg);
        f fVar = this.oU;
        fVar.oA = new AccelerateInterpolator();
        fVar.bT();
        this.oU.Q(8388659);
        bc a = bc.a(context, attributeSet, android.support.design.a.a.TextInputLayout, i, R.style.yt);
        this.te = a.getBoolean(3, true);
        setHint(a.getText(1));
        this.tO = a.getBoolean(10, true);
        if (a.hasValue(0)) {
            ColorStateList colorStateList = a.getColorStateList(0);
            this.tM = colorStateList;
            this.tL = colorStateList;
        }
        if (a.getResourceId(2, -1) != -1) {
            setHintTextAppearance(a.getResourceId(2, 0));
        }
        this.tn = a.getResourceId(5, 0);
        boolean z = a.getBoolean(4, false);
        boolean z2 = a.getBoolean(6, false);
        setCounterMaxLength(a.getInt(7, -1));
        this.tv = a.getResourceId(8, 0);
        this.tw = a.getResourceId(9, 0);
        this.tA = a.getBoolean(11, false);
        this.tB = a.getDrawable(12);
        this.tC = a.getText(13);
        if (a.hasValue(14)) {
            this.tI = true;
            this.tH = a.getColorStateList(14);
        }
        if (a.hasValue(15)) {
            this.tK = true;
            this.tJ = q.al(a.getInt(15, -1));
        }
        a.atG.recycle();
        setErrorEnabled(z);
        setCounterEnabled(z2);
        cC();
        if (s.S(this) == 0) {
            s.o(this, 1);
        }
        s.a((View) this, new a());
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.tb.addView(view, layoutParams2);
            this.tb.setLayoutParams(layoutParams);
            cv();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setTypeface(Typeface typeface) {
        if ((this.tj != null && !this.tj.equals(typeface)) || (this.tj == null && typeface != null)) {
            this.tj = typeface;
            this.oU.a(typeface);
            if (this.tt != null) {
                this.tt.setTypeface(typeface);
            }
            if (this.tm != null) {
                this.tm.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.tj;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.td == null || this.tc == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        CharSequence hint = this.tc.getHint();
        this.tc.setHint(this.td);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.tc.setHint(hint);
        }
    }

    private void setEditText(EditText editText) {
        if (this.tc != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        this.tc = editText;
        if (!cA()) {
            this.oU.a(this.tc.getTypeface());
        }
        f fVar = this.oU;
        float textSize = this.tc.getTextSize();
        if (fVar.ob != textSize) {
            fVar.ob = textSize;
            fVar.bT();
        }
        int gravity = this.tc.getGravity();
        this.oU.Q((gravity & -113) | 48);
        this.oU.P(gravity);
        this.tc.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
                boolean z;
                TextInputLayout textInputLayout = TextInputLayout.this;
                if (TextInputLayout.this.tR) {
                    z = false;
                } else {
                    z = true;
                }
                textInputLayout.d(z, false);
                if (TextInputLayout.this.tq) {
                    TextInputLayout.this.ak(editable.length());
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (this.tL == null) {
            this.tL = this.tc.getHintTextColors();
        }
        if (this.te && TextUtils.isEmpty(this.tf)) {
            this.td = this.tc.getHint();
            setHint(this.td);
            this.tc.setHint(null);
        }
        if (this.tt != null) {
            ak(this.tc.getText().length());
        }
        if (this.th != null) {
            cw();
        }
        cz();
        d(false, true);
    }

    private void cv() {
        int i;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.tb.getLayoutParams();
        if (this.te) {
            if (this.tg == null) {
                this.tg = new Paint();
            }
            this.tg.setTypeface(this.oU.bN());
            this.tg.setTextSize(this.oU.oc);
            i = (int) (-this.tg.ascent());
        } else {
            i = 0;
        }
        if (i != layoutParams.topMargin) {
            layoutParams.topMargin = i;
            this.tb.requestLayout();
        }
    }

    /* Access modifiers changed, original: final */
    public final void d(boolean z, boolean z2) {
        Object obj = 1;
        boolean isEnabled = isEnabled();
        Object obj2 = (this.tc == null || TextUtils.isEmpty(this.tc.getText())) ? null : 1;
        boolean d = d(getDrawableState());
        if (TextUtils.isEmpty(getError())) {
            obj = null;
        }
        if (this.tL != null) {
            this.oU.c(this.tL);
        }
        if (isEnabled && this.tz && this.tt != null) {
            this.oU.b(this.tt.getTextColors());
        } else if (isEnabled && d && this.tM != null) {
            this.oU.b(this.tM);
        } else if (this.tL != null) {
            this.oU.b(this.tL);
        }
        if (obj2 != null || (isEnabled() && (d || obj != null))) {
            if (z2 || this.tN) {
                t(z);
            }
        } else if (z2 || !this.tN) {
            u(z);
        }
    }

    public EditText getEditText() {
        return this.tc;
    }

    public void setHint(CharSequence charSequence) {
        if (this.te) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        this.tf = charSequence;
        this.oU.setText(charSequence);
    }

    public CharSequence getHint() {
        return this.te ? this.tf : null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.te) {
            this.te = z;
            CharSequence hint = this.tc.getHint();
            if (!this.te) {
                if (!TextUtils.isEmpty(this.tf) && TextUtils.isEmpty(hint)) {
                    this.tc.setHint(this.tf);
                }
                setHintInternal(null);
            } else if (!TextUtils.isEmpty(hint)) {
                if (TextUtils.isEmpty(this.tf)) {
                    setHint(hint);
                }
                this.tc.setHint(null);
            }
            if (this.tc != null) {
                cv();
            }
        }
    }

    public void setHintTextAppearance(int i) {
        this.oU.R(i);
        this.tM = this.oU.oe;
        if (this.tc != null) {
            d(false, false);
            cv();
        }
    }

    private void a(TextView textView, int i) {
        if (this.th == null) {
            this.th = new LinearLayout(getContext());
            this.th.setOrientation(0);
            addView(this.th, -1, -2);
            this.th.addView(new Space(getContext()), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.tc != null) {
                cw();
            }
        }
        this.th.setVisibility(0);
        this.th.addView(textView, i);
        this.ti++;
    }

    private void cw() {
        s.d(this.th, s.W(this.tc), 0, s.X(this.tc), this.tc.getPaddingBottom());
    }

    private void a(TextView textView) {
        if (this.th != null) {
            this.th.removeView(textView);
            int i = this.ti - 1;
            this.ti = i;
            if (i == 0) {
                this.th.setVisibility(8);
            }
        }
    }

    public void setErrorEnabled(boolean z) {
        int i = 1;
        if (this.tk != z) {
            if (this.tm != null) {
                this.tm.animate().cancel();
            }
            if (z) {
                this.tm = new AppCompatTextView(getContext());
                this.tm.setId(R.id.cw);
                if (this.tj != null) {
                    this.tm.setTypeface(this.tj);
                }
                try {
                    q.b(this.tm, this.tn);
                    if (VERSION.SDK_INT < 23 || this.tm.getTextColors().getDefaultColor() != -65281) {
                        i = 0;
                    }
                } catch (Exception e) {
                }
                if (i != 0) {
                    q.b(this.tm, R.style.sg);
                    this.tm.setTextColor(android.support.v4.content.b.i(getContext(), R.color.n7));
                }
                this.tm.setVisibility(4);
                s.V(this.tm);
                a(this.tm, 0);
            } else {
                this.to = false;
                cx();
                a(this.tm);
                this.tm = null;
            }
            this.tk = z;
        }
    }

    public void setErrorTextAppearance(int i) {
        this.tn = i;
        if (this.tm != null) {
            q.b(this.tm, i);
        }
    }

    public void setError(final CharSequence charSequence) {
        boolean z;
        boolean z2 = true;
        if (s.as(this) && isEnabled() && (this.tm == null || !TextUtils.equals(this.tm.getText(), charSequence))) {
            z = true;
        } else {
            z = false;
        }
        this.tp = charSequence;
        if (!this.tk) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            z2 = false;
        }
        this.to = z2;
        this.tm.animate().cancel();
        if (this.to) {
            this.tm.setText(charSequence);
            this.tm.setVisibility(0);
            if (z) {
                if (this.tm.getAlpha() == 1.0f) {
                    this.tm.setAlpha(0.0f);
                }
                this.tm.animate().alpha(1.0f).setDuration(200).setInterpolator(a.mi).setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationStart(Animator animator) {
                        TextInputLayout.this.tm.setVisibility(0);
                    }
                }).start();
            } else {
                this.tm.setAlpha(1.0f);
            }
        } else if (this.tm.getVisibility() == 0) {
            if (z) {
                this.tm.animate().alpha(0.0f).setDuration(200).setInterpolator(a.mh).setListener(new AnimatorListenerAdapter() {
                    public final void onAnimationEnd(Animator animator) {
                        TextInputLayout.this.tm.setText(charSequence);
                        TextInputLayout.this.tm.setVisibility(4);
                    }
                }).start();
            } else {
                this.tm.setText(charSequence);
                this.tm.setVisibility(4);
            }
        }
        cx();
        d(z, false);
    }

    public void setCounterEnabled(boolean z) {
        if (this.tq != z) {
            if (z) {
                this.tt = new AppCompatTextView(getContext());
                this.tt.setId(R.id.cv);
                if (this.tj != null) {
                    this.tt.setTypeface(this.tj);
                }
                this.tt.setMaxLines(1);
                try {
                    q.b(this.tt, this.tv);
                } catch (Exception e) {
                    q.b(this.tt, R.style.sg);
                    this.tt.setTextColor(android.support.v4.content.b.i(getContext(), R.color.n7));
                }
                a(this.tt, -1);
                if (this.tc == null) {
                    ak(0);
                } else {
                    ak(this.tc.getText().length());
                }
            } else {
                a(this.tt);
                this.tt = null;
            }
            this.tq = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.tu != i) {
            if (i > 0) {
                this.tu = i;
            } else {
                this.tu = -1;
            }
            if (this.tq) {
                ak(this.tc == null ? 0 : this.tc.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    private static void a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.tu;
    }

    /* Access modifiers changed, original: final */
    public final void ak(int i) {
        boolean z = this.tz;
        if (this.tu == -1) {
            this.tt.setText(String.valueOf(i));
            this.tz = false;
        } else {
            this.tz = i > this.tu;
            if (z != this.tz) {
                q.b(this.tt, this.tz ? this.tw : this.tv);
            }
            this.tt.setText(getContext().getString(R.string.g6d, new Object[]{Integer.valueOf(i), Integer.valueOf(this.tu)}));
        }
        if (this.tc != null && z != this.tz) {
            d(false, false);
            cx();
        }
    }

    private void cx() {
        if (this.tc != null) {
            Drawable background = this.tc.getBackground();
            if (background != null) {
                cy();
                if (aa.o(background)) {
                    background = background.mutate();
                }
                if (this.to && this.tm != null) {
                    background.setColorFilter(i.a(this.tm.getCurrentTextColor(), Mode.SRC_IN));
                } else if (!this.tz || this.tt == null) {
                    android.support.v4.a.a.a.e(background);
                    this.tc.refreshDrawableState();
                } else {
                    background.setColorFilter(i.a(this.tt.getCurrentTextColor(), Mode.SRC_IN));
                }
            }
        }
    }

    private void cy() {
        int i = VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.tc.getBackground();
            if (background != null && !this.tP) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.tP = g.a((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.tP) {
                    s.a(this.tc, newDrawable);
                    this.tP = true;
                }
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.to) {
            savedState.tU = getError();
        }
        savedState.tV = this.tE;
        return savedState;
    }

    /* Access modifiers changed, original: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.LC);
            setError(savedState.tU);
            if (savedState.tV) {
                s(true);
            }
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.tR = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.tR = false;
    }

    public CharSequence getError() {
        return this.tk ? this.tp : null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.tO = z;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.te) {
            this.oU.draw(canvas);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        cz();
        super.onMeasure(i, i2);
    }

    private void cz() {
        if (this.tc != null) {
            Drawable[] c;
            if (cB()) {
                if (this.tD == null) {
                    this.tD = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.sd, this.tb, false);
                    this.tD.setImageDrawable(this.tB);
                    this.tD.setContentDescription(this.tC);
                    this.tb.addView(this.tD);
                    this.tD.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            TextInputLayout.this.s(false);
                        }
                    });
                }
                if (this.tc != null && s.aa(this.tc) <= 0) {
                    this.tc.setMinimumHeight(s.aa(this.tD));
                }
                this.tD.setVisibility(0);
                this.tD.setChecked(this.tE);
                if (this.tF == null) {
                    this.tF = new ColorDrawable();
                }
                this.tF.setBounds(0, 0, this.tD.getMeasuredWidth(), 1);
                c = q.c(this.tc);
                if (c[2] != this.tF) {
                    this.tG = c[2];
                }
                q.a(this.tc, c[0], c[1], this.tF, c[3]);
                this.tD.setPadding(this.tc.getPaddingLeft(), this.tc.getPaddingTop(), this.tc.getPaddingRight(), this.tc.getPaddingBottom());
                return;
            }
            if (this.tD != null && this.tD.getVisibility() == 0) {
                this.tD.setVisibility(8);
            }
            if (this.tF != null) {
                c = q.c(this.tc);
                if (c[2] == this.tF) {
                    q.a(this.tc, c[0], c[1], this.tG, c[3]);
                    this.tF = null;
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? android.support.v7.c.a.b.g(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.tB = drawable;
        if (this.tD != null) {
            this.tD.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.tC = charSequence;
        if (this.tD != null) {
            this.tD.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.tB;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.tC;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.tA != z) {
            this.tA = z;
            if (!(z || !this.tE || this.tc == null)) {
                this.tc.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.tE = false;
            cz();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.tH = colorStateList;
        this.tI = true;
        cC();
    }

    public void setPasswordVisibilityToggleTintMode(Mode mode) {
        this.tJ = mode;
        this.tK = true;
        cC();
    }

    private void s(boolean z) {
        if (this.tA) {
            int selectionEnd = this.tc.getSelectionEnd();
            if (cA()) {
                this.tc.setTransformationMethod(null);
                this.tE = true;
            } else {
                this.tc.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.tE = false;
            }
            this.tD.setChecked(this.tE);
            if (z) {
                this.tD.jumpDrawablesToCurrentState();
            }
            this.tc.setSelection(selectionEnd);
        }
    }

    private boolean cA() {
        return this.tc != null && (this.tc.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean cB() {
        return this.tA && (cA() || this.tE);
    }

    private void cC() {
        if (this.tB == null) {
            return;
        }
        if (this.tI || this.tK) {
            this.tB = android.support.v4.a.a.a.f(this.tB).mutate();
            if (this.tI) {
                android.support.v4.a.a.a.a(this.tB, this.tH);
            }
            if (this.tK) {
                android.support.v4.a.a.a.a(this.tB, this.tJ);
            }
            if (this.tD != null && this.tD.getDrawable() != this.tB) {
                this.tD.setImageDrawable(this.tB);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.te && this.tc != null) {
            Rect rect = this.oT;
            u.a((ViewGroup) this, this.tc, rect);
            int compoundPaddingLeft = rect.left + this.tc.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.tc.getCompoundPaddingRight();
            this.oU.c(compoundPaddingLeft, rect.top + this.tc.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.tc.getCompoundPaddingBottom());
            this.oU.d(compoundPaddingLeft, getPaddingTop(), compoundPaddingRight, (i4 - i2) - getPaddingBottom());
            this.oU.bT();
        }
    }

    private void t(boolean z) {
        if (this.rD != null && this.rD.isRunning()) {
            this.rD.cancel();
        }
        if (z && this.tO) {
            q(1.0f);
        } else {
            this.oU.i(1.0f);
        }
        this.tN = false;
    }

    /* Access modifiers changed, original: protected */
    public void drawableStateChanged() {
        boolean z = true;
        if (!this.tQ) {
            int state;
            this.tQ = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!(s.as(this) && isEnabled())) {
                z = false;
            }
            d(z, false);
            cx();
            if (this.oU != null) {
                state = this.oU.setState(drawableState) | 0;
            } else {
                state = 0;
            }
            if (state != 0) {
                invalidate();
            }
            this.tQ = false;
        }
    }

    private void u(boolean z) {
        if (this.rD != null && this.rD.isRunning()) {
            this.rD.cancel();
        }
        if (z && this.tO) {
            q(0.0f);
        } else {
            this.oU.i(0.0f);
        }
        this.tN = true;
    }

    private void q(float f) {
        if (this.oU.nV != f) {
            if (this.rD == null) {
                this.rD = new ValueAnimator();
                this.rD.setInterpolator(a.mf);
                this.rD.setDuration(200);
                this.rD.addUpdateListener(new AnimatorUpdateListener() {
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.oU.i(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.rD.setFloatValues(new float[]{this.oU.nV, f});
            this.rD.start();
        }
    }

    private static boolean d(int[] iArr) {
        for (int i : iArr) {
            if (i == 16842908) {
                return true;
            }
        }
        return false;
    }
}
