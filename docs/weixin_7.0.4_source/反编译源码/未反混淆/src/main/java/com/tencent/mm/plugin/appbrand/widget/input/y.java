package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.widget.base.c;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.b;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Locale;
import java.util.Map;

@SuppressLint({"AppCompatCustomView"})
public abstract class y extends EditText implements c, ab {
    private volatile int jdU = -1;
    InputConnection jfF;
    boolean jgd = false;
    private final b jge;
    private final Map<com.tencent.mm.plugin.appbrand.widget.input.ab.a, Object> jgf = new android.support.v4.f.a();
    private final Map<OnFocusChangeListener, Object> jgg = new android.support.v4.f.a();
    private final Map<ab.c, Object> jgh = new android.support.v4.f.a();
    private final a jgi = new a(this, (byte) 0);
    private final PasswordTransformationMethod jgj = new m();
    private final z jgk = new z(this);
    private boolean jgl;
    private int jgm = 0;
    private boolean jgn = false;
    private final int[] jgo = new int[2];
    private boolean jgp = false;
    private ab.b jgq;
    char jgr = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.y$3 */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] boC = new int[Alignment.values().length];

        static {
            AppMethodBeat.i(123821);
            try {
                boC[Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                boC[Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
                AppMethodBeat.o(123821);
            } catch (NoSuchFieldError e2) {
                AppMethodBeat.o(123821);
            }
        }
    }

    final class a implements TextWatcher {
        final Map<TextWatcher, Object> jgt;

        private a() {
            AppMethodBeat.i(123823);
            this.jgt = new android.support.v4.f.a();
            AppMethodBeat.o(123823);
        }

        /* synthetic */ a(y yVar, byte b) {
            this();
        }

        private static <T> void a(CharSequence charSequence, int i, int i2, Class<T> cls) {
            AppMethodBeat.i(123824);
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
                AppMethodBeat.o(123824);
            } catch (Throwable th) {
                AppMethodBeat.o(123824);
            }
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(123825);
            if (!(y.c(y.this) || this.jgt.isEmpty())) {
                for (TextWatcher beforeTextChanged : (TextWatcher[]) this.jgt.keySet().toArray(new TextWatcher[this.jgt.size()])) {
                    beforeTextChanged.beforeTextChanged(charSequence, i, i2, i3);
                }
            }
            AppMethodBeat.o(123825);
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(123826);
            if (!y.c(y.this)) {
                a(charSequence, i, i3, StyleSpan.class);
                a(charSequence, i, i3, RelativeSizeSpan.class);
                a(charSequence, i, i3, AlignmentSpan.class);
                if (!this.jgt.isEmpty()) {
                    for (TextWatcher onTextChanged : (TextWatcher[]) this.jgt.keySet().toArray(new TextWatcher[this.jgt.size()])) {
                        onTextChanged.onTextChanged(charSequence, i, i2, i3);
                    }
                }
            }
            AppMethodBeat.o(123826);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(123827);
            f.aQv();
            if (f.aQw()) {
                PBool pBool = new PBool();
                PInt pInt = new PInt();
                final String a = y.a(editable, pBool, pInt);
                final int i = pInt.value;
                if (pBool.value && !bo.isNullOrNil(a)) {
                    final int selectionEnd = Selection.getSelectionEnd(editable);
                    final boolean c = y.c(y.this);
                    y.this.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(123822);
                            if (c) {
                                y.this.B(a);
                            } else {
                                y.this.setText(a);
                            }
                            try {
                                y.this.setSelection(Math.min(selectionEnd + i, a.length()));
                                AppMethodBeat.o(123822);
                            } catch (Exception e) {
                                ab.e("MicroMsg.AppBrand.WebEditText", "replace softBank to unicode, setSelection ", e);
                                AppMethodBeat.o(123822);
                            }
                        }
                    });
                    AppMethodBeat.o(123827);
                    return;
                }
            }
            if (!y.c(y.this)) {
                y.this.jgm = 0;
                if (!this.jgt.isEmpty()) {
                    for (TextWatcher afterTextChanged : (TextWatcher[]) this.jgt.keySet().toArray(new TextWatcher[this.jgt.size()])) {
                        afterTextChanged.afterTextChanged(editable);
                    }
                }
            }
            AppMethodBeat.o(123827);
        }
    }

    public abstract void aQR();

    static /* synthetic */ String a(Editable editable, PBool pBool, PInt pInt) {
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
            com.tencent.mm.plugin.appbrand.widget.input.a.b.a pe = com.tencent.mm.plugin.appbrand.widget.input.a.a.aRx().pe(codePointAt);
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

    public b getAutoFillController() {
        return this.jge;
    }

    public void N(float f, float f2) {
        throw new IllegalStateException("Should implement performClick(float, float) in this class!");
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.input.ab.a aVar) {
        this.jgf.put(aVar, this);
    }

    public final void a(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.jgg.put(onFocusChangeListener, this);
        }
    }

    public final void b(OnFocusChangeListener onFocusChangeListener) {
        if (onFocusChangeListener != null) {
            this.jgg.remove(onFocusChangeListener);
        }
    }

    public final void a(ab.c cVar) {
        this.jgh.put(cVar, this);
    }

    public void setOnComposingDismissedListener(com.tencent.mm.plugin.appbrand.widget.input.c.b bVar) {
        this.jgk.jgz = bVar;
    }

    public y(Context context) {
        super(context);
        setBackgroundDrawable(null);
        setIncludeFontPadding(false);
        qH(3);
        setSingleLine(true);
        setTextCursorDrawable(R.drawable.cm);
        setTextIsSelectable(true);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (VERSION.SDK_INT >= 16) {
            setLineSpacing(0.0f, 1.0f);
        }
        setTypeface(Typeface.SANS_SERIF);
        super.addTextChangedListener(this.jgi);
        super.setPadding(0, 0, 0, 0);
        super.setEditableFactory(new Factory() {
            public final Editable newEditable(CharSequence charSequence) {
                AppMethodBeat.i(123816);
                Editable c = y.this.c(super.newEditable(charSequence));
                AppMethodBeat.o(123816);
                return c;
            }
        });
        if (aQQ()) {
            this.jge = new b(this);
        } else {
            this.jge = null;
        }
        this.jgl = true;
    }

    public boolean aOQ() {
        return false;
    }

    private void qH(int i) {
        setGravity(((getGravity() & -8388612) & -8388614) | i);
        int gravity = getGravity();
        CharSequence hint = getHint();
        if (!TextUtils.isEmpty(hint)) {
            Alignment alignment;
            Spannable C = aj.C(hint);
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
                switch (AnonymousClass3.boC[alignment.ordinal()]) {
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
    public Editable c(Editable editable) {
        return this.jgk.c(editable);
    }

    public final int qI(int i) {
        ab.d("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", Integer.valueOf(i), Integer.valueOf(getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())))), getLayout());
        return getPaddingTop() + ((int) (((float) i) * (((float) getLineHeight()) + getLineSpacingExtra())));
    }

    public final int aRh() {
        return qI(getLineCount()) + getPaddingBottom();
    }

    public final void aRi() {
        qH(3);
    }

    public final void aRj() {
        qH(5);
    }

    public final void aRk() {
        qH(1);
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
                AppMethodBeat.i(123817);
                if (!TextUtils.isEmpty(charSequence)) {
                    y.this.jgr = charSequence.charAt(charSequence.length() - 1);
                }
                boolean composingText = super.setComposingText(charSequence, i);
                AppMethodBeat.o(123817);
                return composingText;
            }

            public final boolean commitText(CharSequence charSequence, int i) {
                AppMethodBeat.i(123818);
                if (!TextUtils.isEmpty(charSequence)) {
                    y.this.jgr = charSequence.charAt(charSequence.length() - 1);
                }
                boolean commitText = super.commitText(charSequence, i);
                AppMethodBeat.o(123818);
                return commitText;
            }

            public final boolean deleteSurroundingText(int i, int i2) {
                AppMethodBeat.i(123819);
                y.this.jgr = 8;
                boolean deleteSurroundingText = super.deleteSurroundingText(i, i2);
                AppMethodBeat.o(123819);
                return deleteSurroundingText;
            }

            public final boolean finishComposingText() {
                AppMethodBeat.i(123820);
                boolean finishComposingText = super.finishComposingText();
                z b = y.this.jgk;
                b.iGP.removeCallbacks(b.jgA);
                b.jgA.run();
                AppMethodBeat.o(123820);
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
        ab.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
        super.onMeasure(i, i2);
        if (!this.jgh.isEmpty()) {
            for (Object obj : this.jgh.keySet().toArray()) {
                ab.c cVar = (ab.c) obj;
                getMeasuredWidth();
                getMeasuredHeight();
                cVar.aQS();
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ab.v("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
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

    private void A(CharSequence charSequence) {
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

    public final void B(CharSequence charSequence) {
        aRm();
        A(charSequence);
        aRn();
    }

    public final void y(u uVar) {
        if (this.jge != null) {
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = this.jge.jhE;
            cVar.jhP = uVar;
            k u = k.u(uVar);
            com.tencent.mm.plugin.appbrand.widget.input.k.a aVar = cVar.jhO;
            if (aVar != null && !u.jes.containsKey(aVar)) {
                u.jes.put(aVar, u);
            }
        }
    }

    public final void z(u uVar) {
        if (this.jge != null) {
            k.u(uVar).a(this.jge.jhE.jhO);
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
            new com.tencent.mm.compatible.loader.c(this, "mCursorDrawableRes", TextView.class.getName()).set(Integer.valueOf(i));
        } catch (Exception e) {
            ab.d("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", bo.l(e));
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
        a aVar = this.jgi;
        if (textWatcher != null) {
            aVar.jgt.put(textWatcher, aVar);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        a aVar = this.jgi;
        if (textWatcher != null) {
            aVar.jgt.remove(textWatcher);
        }
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.jgf.isEmpty()) {
            for (com.tencent.mm.plugin.appbrand.widget.input.ab.a gY : (com.tencent.mm.plugin.appbrand.widget.input.ab.a[]) this.jgf.keySet().toArray(new com.tencent.mm.plugin.appbrand.widget.input.ab.a[this.jgf.size()])) {
                gY.gY();
            }
        }
    }

    public void setOnKeyUpPostImeListener(ab.b bVar) {
        this.jgq = bVar;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.jgp || this.jgq == null || !this.jgq.qy(i)) {
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
    public final boolean a(int i, Rect rect) {
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
            b bVar = this.jge;
            com.tencent.mm.plugin.appbrand.widget.input.autofill.c cVar = bVar.jhE;
            k.u(cVar.jhP).a(cVar.jhO);
            bVar.jhH = null;
            bVar.jhC.dismiss();
        }
        super.setOnFocusChangeListener(null);
    }
}
