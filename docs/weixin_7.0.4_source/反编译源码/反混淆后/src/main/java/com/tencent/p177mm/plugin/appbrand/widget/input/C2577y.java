package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.p057v4.p065f.C6197a;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Layout.Alignment;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan;
import android.text.style.AlignmentSpan.Standard;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.loader.C1438c;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.base.C38573c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C33627k.C33628a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab.C11008c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab.C27398a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab.C27399b;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C42736b;
import com.tencent.p177mm.plugin.appbrand.widget.input.autofill.C45722c;
import com.tencent.p177mm.plugin.appbrand.widget.input.p1237a.C19859b.C19860a;
import com.tencent.p177mm.plugin.appbrand.widget.input.p1237a.C42730a;
import com.tencent.p177mm.plugin.appbrand.widget.input.p762c.C45723b;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.y */
public abstract class C2577y extends EditText implements C38573c, C38595ab {
    private volatile int jdU = -1;
    InputConnection jfF;
    boolean jgd = false;
    private final C42736b jge;
    private final Map<C27398a, Object> jgf = new C6197a();
    private final Map<OnFocusChangeListener, Object> jgg = new C6197a();
    private final Map<C11008c, Object> jgh = new C6197a();
    private final C2581a jgi = new C2581a(this, (byte) 0);
    private final PasswordTransformationMethod jgj = new C42739m();
    private final C2583z jgk = new C2583z(this);
    private boolean jgl;
    private int jgm = 0;
    private boolean jgn = false;
    private final int[] jgo = new int[2];
    private boolean jgp = false;
    private C27399b jgq;
    char jgr = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.y$1 */
    class C25781 extends Factory {
        C25781() {
        }

        public final Editable newEditable(CharSequence charSequence) {
            AppMethodBeat.m2504i(123816);
            Editable c = C2577y.this.mo6582c(super.newEditable(charSequence));
            AppMethodBeat.m2505o(123816);
            return c;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.y$3 */
    static /* synthetic */ class C25803 {
        static final /* synthetic */ int[] boC = new int[Alignment.values().length];

        static {
            AppMethodBeat.m2504i(123821);
            try {
                boC[Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                boC[Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
                AppMethodBeat.m2505o(123821);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.m2505o(123821);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.y$a */
    final class C2581a implements TextWatcher {
        final Map<TextWatcher, Object> jgt;

        private C2581a() {
            AppMethodBeat.m2504i(123823);
            this.jgt = new C6197a();
            AppMethodBeat.m2505o(123823);
        }

        /* synthetic */ C2581a(C2577y c2577y, byte b) {
            this();
        }

        /* renamed from: a */
        private static <T> void m4837a(CharSequence charSequence, int i, int i2, Class<T> cls) {
            AppMethodBeat.m2504i(123824);
            try {
                if (charSequence instanceof SpannableStringBuilder) {
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
                    Object[] spans = spannableStringBuilder.getSpans(i, i + i2, cls);
                    if (spans != null && spans.length > 0) {
                        for (Object removeSpan : spans) {
                            spannableStringBuilder.removeSpan(removeSpan);
                        }
                    }
                }
                AppMethodBeat.m2505o(123824);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(123824);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(123825);
            if (!(C2577y.m4823c(C2577y.this) || this.jgt.isEmpty())) {
                for (TextWatcher beforeTextChanged : (TextWatcher[]) this.jgt.keySet().toArray(new TextWatcher[this.jgt.size()])) {
                    beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
                }
            }
            AppMethodBeat.m2505o(123825);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(123826);
            if (!C2577y.m4823c(C2577y.this)) {
                C2581a.m4837a(charSequence, i, i3, StyleSpan.class);
                C2581a.m4837a(charSequence, i, i3, RelativeSizeSpan.class);
                C2581a.m4837a(charSequence, i, i3, AlignmentSpan.class);
                if (!this.jgt.isEmpty()) {
                    for (TextWatcher onTextChanged : (TextWatcher[]) this.jgt.keySet().toArray(new TextWatcher[this.jgt.size()])) {
                        onTextChanged.onTextChanged(charSequence, i, i2, i3);
                    }
                }
            }
            AppMethodBeat.m2505o(123826);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(123827);
            C42738f.aQv();
            if (C42738f.aQw()) {
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                final String a = C2577y.m4821a(editable, pBool, pInt);
                final int i = pInt.value;
                if (pBool.value && !C5046bo.isNullOrNil(a)) {
                    final int selectionEnd = Selection.getSelectionEnd(editable);
                    final boolean c = C2577y.m4823c(C2577y.this);
                    C2577y.this.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(123822);
                            if (c) {
                                C2577y.this.mo6562B(a);
                            } else {
                                C2577y.this.setText(a);
                            }
                            try {
                                C2577y.this.setSelection(Math.min(selectionEnd + i, a.length()));
                                AppMethodBeat.m2505o(123822);
                            } catch (Exception e) {
                                C4990ab.m7413e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", e);
                                AppMethodBeat.m2505o(123822);
                            }
                        }
                    });
                    AppMethodBeat.m2505o(123827);
                    return;
                }
            }
            if (!C2577y.m4823c(C2577y.this)) {
                C2577y.this.jgm = 0;
                if (!this.jgt.isEmpty()) {
                    for (TextWatcher afterTextChanged : (TextWatcher[]) this.jgt.keySet().toArray(new TextWatcher[this.jgt.size()])) {
                        afterTextChanged.afterTextChanged(editable);
                    }
                }
            }
            AppMethodBeat.m2505o(123827);
        }
    }

    public abstract void aQR();

    /* renamed from: a */
    static /* synthetic */ String m4821a(Editable editable, PBool pBool, PInt pInt) {
        pInt.value = 0;
        pBool.value = false;
        if (editable == null || editable.length() <= 0) {
            return null;
        }
        String obj = editable.toString();
        int length = editable.length();
        int i = 0;
        while (i < length) {
            String str;
            int codePointAt = obj.codePointAt(i);
            C19860a pe = C42730a.aRx().mo35084pe(codePointAt);
            if (pe == null || pe.jik == 0) {
                str = obj;
            } else {
                str = obj.replace(new String(Character.toChars(codePointAt)), Character.toChars(pe.jik) + (pe.jil != 0 ? Character.toChars(pe.jil) : ""));
                pBool.value = true;
                pInt.value++;
            }
            i++;
            obj = str;
        }
        return obj;
    }

    public int getInputId() {
        return this.jdU;
    }

    public void setInputId(int i) {
        this.jdU = i;
    }

    public String toString() {
        return String.format(Locale.US, "[%s|%s]", new Object[]{getClass().getSimpleName(), Integer.valueOf(getInputId())});
    }

    public final View getView() {
        return this;
    }

    public boolean aQQ() {
        return true;
    }

    public C42736b getAutoFillController() {
        return this.jge;
    }

    /* renamed from: N */
    public void mo6563N(float f, float f2) {
        throw new IllegalStateException("Should implement performClick(float, float) in this class!");
    }

    /* renamed from: a */
    public final void mo6565a(C27398a c27398a) {
        this.jgf.put(c27398a, this);
    }

    /* renamed from: a */
    public final void mo6564a(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.jgg.put(onFocusChangeListener, this);
        }
    }

    /* renamed from: b */
    public final void mo6581b(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.jgg.remove(onFocusChangeListener);
        }
    }

    /* renamed from: a */
    public final void mo6566a(C11008c c11008c) {
        this.jgh.put(c11008c, this);
    }

    public void setOnComposingDismissedListener(C45723b c45723b) {
        this.jgk.jgz = c45723b;
    }

    public C2577y(Context context) {
        super(context);
        setBackgroundDrawable(null);
        setIncludeFontPadding(false);
        m4825qH(3);
        setSingleLine(true);
        setTextCursorDrawable(C25738R.drawable.f6391cm);
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            setLineSpacing(0.0f, 1.0f);
        }
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(this.jgi);
        super.setPadding(0, 0, 0, 0);
        super.setEditableFactory(new C25781());
        if (aQQ()) {
            this.jge = new C42736b(this);
        } else {
            this.jge = null;
        }
        this.jgl = true;
    }

    public boolean aOQ() {
        return false;
    }

    /* renamed from: qH */
    private void m4825qH(int i) {
        setGravity(((getGravity() & -8388612) & -8388614) | i);
        int gravity = getGravity();
        CharSequence hint = getHint();
        if (!TextUtils.isEmpty(hint)) {
            Alignment alignment;
            Spannable C = C45720aj.m84472C(hint);
            switch (gravity & 7) {
                case 1:
                    alignment = Alignment.ALIGN_CENTER;
                    break;
                case 5:
                    alignment = Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    alignment = Alignment.ALIGN_NORMAL;
                    break;
            }
            C.setSpan(new Standard(alignment), 0, getHint().length(), 18);
            super.setHint(C);
            if (VERSION.SDK_INT >= 17) {
                switch (C25803.boC[alignment.ordinal()]) {
                    case 1:
                        gravity = 4;
                        break;
                    case 2:
                        gravity = 6;
                        break;
                    default:
                        gravity = 5;
                        break;
                }
                super.setTextAlignment(gravity);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public Editable mo6582c(Editable editable) {
        return this.jgk.mo6631c(editable);
    }

    /* renamed from: qI */
    public final int mo6598qI(int i) {
        C4990ab.m7411d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", Integer.valueOf(i), Integer.valueOf(getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())))), getLayout());
        return getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())));
    }

    public final int aRh() {
        return mo6598qI(getLineCount()) + getPaddingBottom();
    }

    public final void aRi() {
        m4825qH(3);
    }

    public final void aRj() {
        m4825qH(5);
    }

    public final void aRk() {
        m4825qH(1);
    }

    public void setSelection(int i) {
        if (getEditableText() != null) {
            super.setSelection(Math.min(i, getEditableText().length()));
        }
    }

    public void setSelection(int i, int i2) {
        int length;
        if (i < 0) {
            i = 0;
        }
        if (i >= getEditableText().length()) {
            length = getEditableText().length();
        } else {
            length = i;
        }
        if (i2 < length) {
            i2 = length;
        }
        if (i2 >= getEditableText().length()) {
            i2 = getEditableText().length();
        }
        super.setSelection(length, i2);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection == null) {
            return null;
        }
        this.jfF = new InputConnectionWrapper(onCreateInputConnection) {
            public final boolean setComposingText(CharSequence charSequence, int i) {
                AppMethodBeat.m2504i(123817);
                if (!TextUtils.isEmpty(charSequence)) {
                    C2577y.this.jgr = charSequence.charAt(charSequence.length() - 1);
                }
                boolean composingText = super.setComposingText(charSequence, i);
                AppMethodBeat.m2505o(123817);
                return composingText;
            }

            public final boolean commitText(CharSequence charSequence, int i) {
                AppMethodBeat.m2504i(123818);
                if (!TextUtils.isEmpty(charSequence)) {
                    C2577y.this.jgr = charSequence.charAt(charSequence.length() - 1);
                }
                boolean commitText = super.commitText(charSequence, i);
                AppMethodBeat.m2505o(123818);
                return commitText;
            }

            public final boolean deleteSurroundingText(int i, int i2) {
                AppMethodBeat.m2504i(123819);
                C2577y.this.jgr = 8;
                boolean deleteSurroundingText = super.deleteSurroundingText(i, i2);
                AppMethodBeat.m2505o(123819);
                return deleteSurroundingText;
            }

            public final boolean finishComposingText() {
                AppMethodBeat.m2504i(123820);
                boolean finishComposingText = super.finishComposingText();
                C2583z b = C2577y.this.jgk;
                b.iGP.removeCallbacks(b.jgA);
                b.jgA.run();
                AppMethodBeat.m2505o(123820);
                return finishComposingText;
            }
        };
        editorInfo.imeOptions |= 268435456;
        return this.jfF;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setMinHeight(int i) {
        if (getMinHeight() != i) {
            super.setMinHeight(i);
        }
    }

    public void setMaxHeight(int i) {
        if (getMaxHeight() != i) {
            super.setMaxHeight(i);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onMeasure(int i, int i2) {
        C4990ab.m7418v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
        super.onMeasure(i, i2);
        if (!this.jgh.isEmpty()) {
            for (Object obj : this.jgh.keySet().toArray()) {
                C11008c c11008c = (C11008c) obj;
                getMeasuredWidth();
                getMeasuredHeight();
                c11008c.aQS();
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C4990ab.m7418v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
        super.onLayout(z, i, i2, i3, i4);
    }

    /* Access modifiers changed, original: final */
    public final void aRl() {
        aRm();
        setText(getEditableText());
        aRn();
    }

    /* Access modifiers changed, original: final */
    public final void aRm() {
        this.jgm++;
    }

    /* Access modifiers changed, original: final */
    public final void aRn() {
        this.jgm = Math.max(0, this.jgm - 1);
    }

    /* renamed from: A */
    private void m4820A(CharSequence charSequence) {
        Editable editableText = getEditableText();
        if (editableText == null) {
            setText(charSequence, BufferType.EDITABLE);
            return;
        }
        clearComposingText();
        if (TextUtils.isEmpty(charSequence)) {
            editableText.clear();
        } else {
            editableText.replace(0, editableText.length(), charSequence);
        }
    }

    /* renamed from: B */
    public final void mo6562B(CharSequence charSequence) {
        aRm();
        m4820A(charSequence);
        aRn();
    }

    /* renamed from: y */
    public final void mo6620y(C44709u c44709u) {
        if (this.jge != null) {
            C45722c c45722c = this.jge.jhE;
            c45722c.jhP = c44709u;
            C33627k u = C33627k.m54914u(c44709u);
            C33628a c33628a = c45722c.jhO;
            if (c33628a != null && !u.jes.containsKey(c33628a)) {
                u.jes.put(c33628a, u);
            }
        }
    }

    /* renamed from: z */
    public final void mo6621z(C44709u c44709u) {
        if (this.jge != null) {
            C33627k.m54914u(c44709u).mo54191a(this.jge.jhE.jhO);
        }
    }

    public void setFixed(boolean z) {
        this.jgn = z;
    }

    public boolean aQT() {
        return this.jgn;
    }

    public final void setTextCursorDrawable(int i) {
        try {
            new C1438c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(i));
        } catch (Exception e) {
            C4990ab.m7411d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", C5046bo.m7574l(e));
        }
    }

    public void setPasswordMode(boolean z) {
        aRm();
        this.jgd = z;
        setTransformationMethod(z ? this.jgj : null);
        aRn();
    }

    public void setInputType(int i) {
        if (getInputType() != i) {
            super.setInputType(i);
        }
    }

    public void setSingleLine(boolean z) {
    }

    public final void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
    }

    public void setTypeface(Typeface typeface, int i) {
        super.setTypeface(typeface, i);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public int getAutofillType() {
        return 0;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        C2581a c2581a = this.jgi;
        if (textWatcher != null) {
            c2581a.jgt.put(textWatcher, c2581a);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        C2581a c2581a = this.jgi;
        if (textWatcher != null) {
            c2581a.jgt.remove(textWatcher);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.jgf.isEmpty()) {
            for (C27398a gY : (C27398a[]) this.jgf.keySet().toArray(new C27398a[this.jgf.size()])) {
                gY.mo45133gY();
            }
        }
    }

    public void setOnKeyUpPostImeListener(C27399b c27399b) {
        this.jgq = c27399b;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.jgp || this.jgq == null || !this.jgq.mo35115qy(i)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 67) {
            this.jgr = 8;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        if (onKeyDown && i == 66) {
            this.jgr = 10;
        }
        this.jgp = onKeyDown;
        return onKeyDown;
    }

    public char getLastKeyPressed() {
        return this.jgr;
    }

    /* Access modifiers changed, original: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            clearComposingText();
        }
        if (z) {
            aQR();
        }
        if (!this.jgg.isEmpty()) {
            for (OnFocusChangeListener onFocusChange : (OnFocusChangeListener[]) this.jgg.keySet().toArray(new OnFocusChangeListener[this.jgg.size()])) {
                onFocusChange.onFocusChange(this, z);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aRo() {
        super.clearFocus();
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final boolean mo6567a(int i, Rect rect) {
        return super.requestFocus(i, rect);
    }

    public void clearFocus() {
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setFocusableInTouchMode(true);
            ((ViewGroup) getParent()).setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        super.clearFocus();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (130 == i && rect == null && (getParent() instanceof ViewGroup)) {
            ((ViewGroup) getParent()).setDescendantFocusability(262144);
            ((ViewGroup) getParent()).setFocusableInTouchMode(false);
        }
        return super.requestFocus(i, rect);
    }

    @Deprecated
    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
    }

    public final void destroy() {
        this.jgf.clear();
        this.jgh.clear();
        this.jgg.clear();
        this.jgi.jgt.clear();
        if (this.jge != null) {
            C42736b c42736b = this.jge;
            C45722c c45722c = c42736b.jhE;
            C33627k.m54914u(c45722c.jhP).mo54191a(c45722c.jhO);
            c42736b.jhH = null;
            c42736b.jhC.dismiss();
        }
        super.setOnFocusChangeListener(null);
    }
}
