package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p901s.C38377d.C38376f;
import com.tencent.p177mm.plugin.appbrand.widget.base.C19810a;
import com.tencent.p177mm.plugin.appbrand.widget.base.C33590d;
import com.tencent.p177mm.plugin.appbrand.widget.input.C33618ai.C33619a;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38595ab.C11008c;
import com.tencent.p177mm.plugin.appbrand.widget.input.C45720aj.C42731a;
import com.tencent.p177mm.plugin.appbrand.widget.p916h.C10981a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.q */
public final class C11034q extends C2577y {
    private C10981a iTW;
    private float ibD;
    private final InputFilter jfd = new C110384();
    private float jfe = 0.0f;
    private float jff = 1.2f;
    private float jfg = getTextSize();
    private boolean jfh = false;
    private MotionEvent jfi;
    private boolean jfj = false;
    final C11011ag<C11034q> jfk = new C11011ag(this);

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.q$1 */
    class C110351 extends Factory {
        C110351() {
        }

        public final Spannable newSpannable(CharSequence charSequence) {
            AppMethodBeat.m2504i(123698);
            Spannable newSpannable = super.newSpannable(charSequence);
            if (!(C11034q.this.iTW == null || TextUtils.isEmpty(newSpannable))) {
                newSpannable.setSpan(C11034q.this.iTW, 0, newSpannable.length(), 18);
            }
            AppMethodBeat.m2505o(123698);
            return newSpannable;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.q$2 */
    class C110362 implements C11008c {
        C110362() {
        }

        public final void aQS() {
            AppMethodBeat.m2504i(123699);
            C11034q.this.aQO();
            AppMethodBeat.m2505o(123699);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.q$3 */
    class C110373 implements OnLongClickListener {
        C110373() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(123700);
            boolean aOQ = C11034q.this.aOQ();
            AppMethodBeat.m2505o(123700);
            return aOQ;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.q$4 */
    class C110384 implements InputFilter {
        C110384() {
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(123701);
            if (TextUtils.isEmpty(charSequence) || C11034q.this.iTW == null) {
                AppMethodBeat.m2505o(123701);
                return null;
            }
            Spannable spannable;
            if (charSequence instanceof Spannable) {
                spannable = (Spannable) charSequence;
            } else {
                Object spannable2 = new SpannableStringBuilder(charSequence);
            }
            spannable2.setSpan(C11034q.this.iTW, 0, spannable2.length(), 18);
            AppMethodBeat.m2505o(123701);
            return spannable2;
        }
    }

    public C11034q(Context context) {
        super(context);
        AppMethodBeat.m2504i(123702);
        super.setSingleLine(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setVerticalScrollbarPosition(2);
        super.setSpannableFactory(new C110351());
        super.mo6566a(new C110362());
        super.setOnLongClickListener(new C110373());
        this.ibD = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        setAutoHeight(false);
        m18761b(0.0f, false);
        AppMethodBeat.m2505o(123702);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final Editable mo6582c(Editable editable) {
        AppMethodBeat.m2504i(123703);
        Editable c = super.mo6582c(editable);
        if (!(this.iTW == null || TextUtils.isEmpty(c))) {
            c.setSpan(this.iTW, 0, c.length(), 18);
        }
        AppMethodBeat.m2505o(123703);
        return c;
    }

    public final void setAutoHeight(boolean z) {
        AppMethodBeat.m2504i(123704);
        this.jfh = z;
        setVerticalScrollBarEnabled(!this.jfh);
        AppMethodBeat.m2505o(123704);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aQO() {
        AppMethodBeat.m2504i(123705);
        if (this.jfh) {
            if (getMeasuredHeight() > getMaxHeight()) {
                setMeasuredDimension(getMeasuredWidth(), getMaxHeight());
                AppMethodBeat.m2505o(123705);
                return;
            } else if (getMeasuredHeight() < getMinHeight() && getMinHeight() > 0) {
                setMeasuredDimension(getMeasuredWidth(), getMinHeight());
            }
        }
        AppMethodBeat.m2505o(123705);
    }

    public final void setGravity(int i) {
        AppMethodBeat.m2504i(123706);
        super.setGravity(((i & -81) & -17) | 48);
        AppMethodBeat.m2505o(123706);
    }

    public final void setSingleLine(boolean z) {
    }

    public final void setInputType(int i) {
        AppMethodBeat.m2504i(123707);
        super.setInputType(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT | i);
        AppMethodBeat.m2505o(123707);
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        int i = 0;
        AppMethodBeat.m2504i(123708);
        if (this.jfd != null) {
            if (inputFilterArr == null) {
                inputFilterArr = new InputFilter[0];
            }
            InputFilter[] inputFilterArr2 = new InputFilter[(inputFilterArr.length + 1)];
            while (i < inputFilterArr.length) {
                inputFilterArr2[i] = inputFilterArr[i];
                i++;
            }
            inputFilterArr2[i] = this.jfd;
            inputFilterArr = inputFilterArr2;
        }
        super.setFilters(inputFilterArr);
        AppMethodBeat.m2505o(123708);
    }

    /* renamed from: b */
    private void m18761b(float f, boolean z) {
        AppMethodBeat.m2504i(123709);
        if (f <= 0.0f) {
            f = (this.jff * this.jfg) + this.jfe;
        }
        if (this.iTW == null || this.iTW.mo22605ax(f)) {
            this.iTW = new C10981a(f);
            if (!z) {
                AppMethodBeat.m2505o(123709);
                return;
            } else if (hasFocus()) {
                invalidate();
                AppMethodBeat.m2505o(123709);
                return;
            } else {
                aRl();
                AppMethodBeat.m2505o(123709);
                return;
            }
        }
        AppMethodBeat.m2505o(123709);
    }

    @Deprecated
    public final float getLineSpacingMultiplier() {
        AppMethodBeat.m2504i(123710);
        float lineSpacingMultiplier = super.getLineSpacingMultiplier();
        AppMethodBeat.m2505o(123710);
        return lineSpacingMultiplier;
    }

    @Deprecated
    public final float getLineSpacingExtra() {
        AppMethodBeat.m2504i(123711);
        float lineSpacingExtra = super.getLineSpacingExtra();
        AppMethodBeat.m2505o(123711);
        return lineSpacingExtra;
    }

    public final void setTextSize(int i, float f) {
        AppMethodBeat.m2504i(123712);
        super.setTextSize(i, f);
        this.jfg = TypedValue.applyDimension(i, f, getResources().getDisplayMetrics());
        m18761b(0.0f, true);
        AppMethodBeat.m2505o(123712);
    }

    public final int getLineHeight() {
        AppMethodBeat.m2504i(123713);
        int i;
        if (this.iTW != null) {
            i = this.iTW.height;
            AppMethodBeat.m2505o(123713);
            return i;
        }
        i = super.getLineHeight();
        AppMethodBeat.m2505o(123713);
        return i;
    }

    public final void setLineSpacing(float f, float f2) {
        AppMethodBeat.m2504i(123714);
        this.jfe = f;
        this.jff = f2;
        m18761b(0.0f, true);
        AppMethodBeat.m2505o(123714);
    }

    public final void setLineSpace(float f) {
        AppMethodBeat.m2504i(123715);
        setLineSpacing(f, this.jff);
        AppMethodBeat.m2505o(123715);
    }

    public final void setLineHeight(float f) {
        AppMethodBeat.m2504i(123716);
        if (f <= 0.0f) {
            AppMethodBeat.m2505o(123716);
            return;
        }
        m18761b(f, true);
        AppMethodBeat.m2505o(123716);
    }

    public final View getInputPanel() {
        AppMethodBeat.m2504i(123717);
        C38609w cN = C38609w.m65441cN(this);
        AppMethodBeat.m2505o(123717);
        return cN;
    }

    public final boolean aQP() {
        return true;
    }

    public final boolean aQQ() {
        return false;
    }

    public final void aQR() {
        AppMethodBeat.m2504i(123718);
        C45720aj.m84475cS(this).restartInput(this);
        AppMethodBeat.m2505o(123718);
    }

    public final boolean aOQ() {
        AppMethodBeat.m2504i(123719);
        if (!this.jfh) {
            aRh();
            getMeasuredHeight();
        }
        if (isFocusable() || aQT()) {
            AppMethodBeat.m2505o(123719);
            return false;
        }
        AppMethodBeat.m2505o(123719);
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(123720);
        super.onScrollChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(123720);
    }

    public final void scrollTo(int i, int i2) {
        AppMethodBeat.m2504i(123721);
        super.scrollTo(i, i2);
        AppMethodBeat.m2505o(123721);
    }

    public final void scrollBy(int i, int i2) {
        AppMethodBeat.m2504i(123722);
        super.scrollBy(i, i2);
        AppMethodBeat.m2505o(123722);
    }

    public final boolean canScrollVertically(int i) {
        AppMethodBeat.m2504i(123723);
        if (aRh() <= getHeight()) {
            AppMethodBeat.m2505o(123723);
            return false;
        }
        boolean canScrollVertically = super.canScrollVertically(i);
        AppMethodBeat.m2505o(123723);
        return canScrollVertically;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(123724);
        int a;
        float x;
        float y;
        boolean onTouchEvent;
        if (!aOQ() || !(getParent() instanceof C33590d)) {
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.jfi = MotionEvent.obtain(motionEvent);
                    this.jfj = true;
                    break;
                case 1:
                case 3:
                    this.jfj = false;
                    if (this.jfi != null) {
                        this.jfi.recycle();
                        this.jfi = null;
                    }
                    if (this.jfj) {
                        a = C42731a.m75726a(this, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()));
                        if (a >= 0) {
                            setSelection(a);
                        }
                    }
                    if (getParent() == null) {
                        AppMethodBeat.m2505o(123724);
                        return true;
                    }
                    break;
                case 2:
                    if (this.jfj) {
                        float x2 = this.jfi.getX(this.jfi.getActionIndex());
                        float y2 = this.jfi.getY(this.jfi.getActionIndex());
                        x = motionEvent.getX(motionEvent.getActionIndex());
                        y = motionEvent.getY(motionEvent.getActionIndex());
                        if (Math.abs(x2 - x) > this.ibD || Math.abs(y2 - y) > this.ibD) {
                            cancelLongPress();
                            setPressed(false);
                            this.jfj = false;
                            break;
                        }
                    }
                    break;
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(123724);
            return onTouchEvent;
        } else if (motionEvent.getActionMasked() != 0 || ((C33590d) getParent()).mo54104E(motionEvent)) {
            C11011ag c11011ag = this.jfk;
            C19810a.m30644a(c11011ag.TAG, "processTouchEvent", motionEvent);
            EditText editText = c11011ag.jgG;
            int actionIndex = motionEvent.getActionIndex();
            x = motionEvent.getX(actionIndex);
            y = motionEvent.getY(actionIndex);
            if (motionEvent.getActionMasked() == 0 || c11011ag.jgJ != null) {
                Object obj;
                actionIndex = 0;
                switch (motionEvent.getActionMasked()) {
                    case 0:
                        Object obj2;
                        c11011ag.jgJ = MotionEvent.obtain(motionEvent);
                        c11011ag.jgI = C38377d.m64950co(editText);
                        if (editText != null) {
                            ViewParent parent = editText.getParent();
                            while (parent != null && (parent instanceof ViewGroup)) {
                                if (((ViewGroup) parent).shouldDelayChildPressedState()) {
                                    obj2 = 1;
                                    editText.removeCallbacks(c11011ag.jgL);
                                    if (obj2 == null) {
                                        editText.postDelayed(c11011ag.jgL, (long) ViewConfiguration.getTapTimeout());
                                    } else {
                                        c11011ag.jgL.run();
                                    }
                                    actionIndex = 1;
                                    break;
                                }
                                parent = parent.getParent();
                            }
                        }
                        obj2 = null;
                        editText.removeCallbacks(c11011ag.jgL);
                        if (obj2 == null) {
                        }
                        actionIndex = 1;
                        break;
                    case 1:
                        C4990ab.m7419v(c11011ag.TAG, "[apptouch] ACTION_UP, pointerDown %B", Boolean.valueOf(c11011ag.jgK));
                        if (c11011ag.jgK && c11011ag.jgJ != null) {
                            C38376f co = C38377d.m64950co(c11011ag.jgG);
                            if (c11011ag.jgI == null || Math.abs(c11011ag.jgI.f16152x - co.f16152x) > 1.0f || Math.abs(c11011ag.jgI.f16153y - co.f16153y) > 1.0f) {
                                C4990ab.m7418v(c11011ag.TAG, "[apptouch] check tap on ACTION_UP, but view has moved.");
                            } else if (c11011ag.mo22668a(c11011ag.jgJ, motionEvent)) {
                                ((C38595ab) editText).mo6563N(x, y);
                            } else {
                                C4990ab.m7418v(c11011ag.TAG, "[apptouch] check tap on ACTION_UP exceed tap scope");
                            }
                        }
                        c11011ag.aRq();
                        break;
                    case 2:
                        float f = c11011ag.jgH;
                        if (x < (-f) || y < (-f) || x >= ((float) editText.getWidth()) + f || y >= ((float) editText.getHeight()) + f) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        if (obj != null && c11011ag.mo22668a(c11011ag.jgJ, motionEvent)) {
                            actionIndex = 1;
                            break;
                        }
                        c11011ag.jgK = false;
                        editText.removeCallbacks(c11011ag.jgL);
                        editText.removeCallbacks(c11011ag.jgM);
                        break;
                        break;
                    case 3:
                        c11011ag.aRq();
                        break;
                }
                EditText editText2 = c11011ag.jgG;
                Editable text = c11011ag.jgG.getText();
                if (editText2.canScrollVertically(-1) || editText2.canScrollVertically(1)) {
                    C33619a[] c33619aArr;
                    int scaledTouchSlop;
                    switch (motionEvent.getActionMasked()) {
                        case 0:
                            c33619aArr = (C33619a[]) text.getSpans(0, text.length(), C33619a.class);
                            for (Object removeSpan : c33619aArr) {
                                text.removeSpan(removeSpan);
                            }
                            text.setSpan(new C33619a(motionEvent.getX(), motionEvent.getY(), editText2.getScrollX(), editText2.getScrollY()), 0, 0, 17);
                            a = 1;
                            break;
                        case 1:
                        case 3:
                            c33619aArr = C33618ai.m54893g(editText2);
                            if (c33619aArr != null && c33619aArr.length > 0 && c33619aArr[0].jgY) {
                                a = 1;
                                break;
                            }
                            a = 0;
                            break;
                        case 2:
                            c33619aArr = (C33619a[]) text.getSpans(0, text.length(), C33619a.class);
                            if (c33619aArr.length > 0) {
                                if (!c33619aArr[0].jgX) {
                                    scaledTouchSlop = ViewConfiguration.get(editText2.getContext()).getScaledTouchSlop();
                                    if (Math.abs(motionEvent.getX() - c33619aArr[0].avX) >= ((float) scaledTouchSlop) || Math.abs(motionEvent.getY() - c33619aArr[0].avY) >= ((float) scaledTouchSlop)) {
                                        c33619aArr[0].jgX = true;
                                    }
                                }
                                if (c33619aArr[0].jgX) {
                                    c33619aArr[0].jgY = true;
                                    obj = ((motionEvent.getMetaState() & 1) == 0 && MetaKeyKeyListener.getMetaState(text, 1) != 1 && MetaKeyKeyListener.getMetaState(text, 2048) == 0) ? null : 1;
                                    if (obj != null) {
                                        y = motionEvent.getX() - c33619aArr[0].avX;
                                        x = motionEvent.getY() - c33619aArr[0].avY;
                                    } else {
                                        y = c33619aArr[0].avX - motionEvent.getX();
                                        x = c33619aArr[0].avY - motionEvent.getY();
                                    }
                                    c33619aArr[0].avX = motionEvent.getX();
                                    c33619aArr[0].avY = motionEvent.getY();
                                    if (c33619aArr[0].jgZ) {
                                        c33619aArr[0].jgZ = false;
                                        c33619aArr[0].jgX = false;
                                    } else {
                                        int scrollX = ((int) y) + editText2.getScrollX();
                                        scaledTouchSlop = ((int) x) + editText2.getScrollY();
                                        int totalPaddingTop = editText2.getTotalPaddingTop() + editText2.getTotalPaddingBottom();
                                        Layout layout = editText2.getLayout();
                                        totalPaddingTop = Math.max(Math.min(scaledTouchSlop, layout.getHeight() - (editText2.getHeight() - totalPaddingTop)), 0);
                                        int scrollX2 = editText2.getScrollX();
                                        int scrollY = editText2.getScrollY();
                                        int width = editText2.getWidth() - (editText2.getTotalPaddingLeft() + editText2.getTotalPaddingRight());
                                        scaledTouchSlop = layout.getLineForVertical(totalPaddingTop);
                                        Alignment paragraphAlignment = layout.getParagraphAlignment(scaledTouchSlop);
                                        if (layout.getParagraphDirection(scaledTouchSlop) > 0) {
                                            obj = 1;
                                        } else {
                                            obj = null;
                                        }
                                        int i = width + 0;
                                        if (i >= width) {
                                            scaledTouchSlop = Math.max(Math.min(scrollX, 0), 0);
                                        } else if (paragraphAlignment == Alignment.ALIGN_CENTER) {
                                            scaledTouchSlop = 0 - ((width - i) / 2);
                                        } else if ((obj == null || paragraphAlignment != Alignment.ALIGN_OPPOSITE) && !(obj == null && paragraphAlignment == Alignment.ALIGN_NORMAL)) {
                                            scaledTouchSlop = 0;
                                        } else {
                                            scaledTouchSlop = 0 - (width - i);
                                        }
                                        editText2.scrollTo(scaledTouchSlop, totalPaddingTop);
                                        if (scrollX2 != editText2.getScrollX() || scrollY != editText2.getScrollY()) {
                                            editText2.cancelLongPress();
                                            c33619aArr[0].arP = true;
                                            a = 1;
                                            break;
                                        } else if (c33619aArr[0].arP) {
                                            a = 1;
                                            break;
                                        } else {
                                            C33618ai.m54893g(editText2);
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }
                a = 0;
                onTouchEvent = a | actionIndex;
                C19810a.m30644a(c11011ag.TAG, "[textscroll] handled | ".concat(String.valueOf(onTouchEvent)), motionEvent);
                AppMethodBeat.m2505o(123724);
                return onTouchEvent;
            }
            C4990ab.m7418v(c11011ag.TAG, "[textscroll] no pointer down before, just return");
            c11011ag.aRq();
            AppMethodBeat.m2505o(123724);
            return false;
        } else {
            AppMethodBeat.m2505o(123724);
            return false;
        }
    }

    /* renamed from: N */
    public final void mo6563N(float f, float f2) {
        AppMethodBeat.m2504i(123725);
        if (isEnabled()) {
            if (aOQ()) {
                int a = C42731a.m75726a(this, f, f2);
                if (a >= 0) {
                    setSelection(a);
                }
            }
            super.performClick();
            AppMethodBeat.m2505o(123725);
            return;
        }
        AppMethodBeat.m2505o(123725);
    }

    public final boolean performHapticFeedback(int i, int i2) {
        AppMethodBeat.m2504i(123726);
        boolean performHapticFeedback = super.performHapticFeedback(i, i2);
        AppMethodBeat.m2505o(123726);
        return performHapticFeedback;
    }
}
