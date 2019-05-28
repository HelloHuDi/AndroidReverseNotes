package com.tencent.p177mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.p177mm.plugin.appbrand.widget.input.numberpad.C42741a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView */
final class AppBrandNumberKeyboardView extends BaseNumberKeyboardView {
    private int jfD = 0;
    private final SparseArray<String> jfE = new C25561();
    InputConnection jfF;
    C42741a jfG;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView$1 */
    class C25561 extends SparseArray<String> {
        C25561() {
            AppMethodBeat.m2504i(123755);
            put(1, "tenpay_keyboard_1");
            put(2, "tenpay_keyboard_2");
            put(3, "tenpay_keyboard_3");
            put(4, "tenpay_keyboard_4");
            put(5, "tenpay_keyboard_5");
            put(6, "tenpay_keyboard_6");
            put(7, "tenpay_keyboard_7");
            put(8, "tenpay_keyboard_8");
            put(9, "tenpay_keyboard_9");
            put(0, "tenpay_keyboard_0");
            AppMethodBeat.m2505o(123755);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView$3 */
    class C25573 extends C2562an {
        C25573() {
        }

        /* Access modifiers changed, original: protected|final */
        public final void aFi() {
            AppMethodBeat.m2504i(123757);
            C4990ab.m7410d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onSingleTap");
            AppBrandNumberKeyboardView.m4803d(AppBrandNumberKeyboardView.this);
            AppMethodBeat.m2505o(123757);
        }

        /* Access modifiers changed, original: protected|final */
        public final void aQX() {
            AppMethodBeat.m2504i(123758);
            C4990ab.m7410d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onRepeat");
            AppBrandNumberKeyboardView.m4803d(AppBrandNumberKeyboardView.this);
            AppMethodBeat.m2505o(123758);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView$2 */
    class C25582 implements OnClickListener {
        C25582() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(123756);
            if (AppBrandNumberKeyboardView.this.jfF == null) {
                AppMethodBeat.m2505o(123756);
                return;
            }
            CharSequence charSequence = null;
            if (view.getId() == AppBrandNumberKeyboardView.m4798a(AppBrandNumberKeyboardView.this, "tenpay_keyboard_x")) {
                switch (AppBrandNumberKeyboardView.this.jfD) {
                    case 1:
                        charSequence = "X";
                        break;
                    case 2:
                        charSequence = ".";
                        break;
                    default:
                        AppMethodBeat.m2505o(123756);
                        return;
                }
            }
            int i = 0;
            while (i < AppBrandNumberKeyboardView.this.jfE.size()) {
                String valueOf;
                if (view.getId() == AppBrandNumberKeyboardView.m4801b(AppBrandNumberKeyboardView.this, (String) AppBrandNumberKeyboardView.this.jfE.valueAt(i))) {
                    valueOf = String.valueOf(AppBrandNumberKeyboardView.this.jfE.keyAt(i));
                } else {
                    CharSequence valueOf2 = charSequence;
                }
                i++;
                Object charSequence2 = valueOf2;
            }
            if (TextUtils.isEmpty(charSequence2)) {
                AppMethodBeat.m2505o(123756);
                return;
            }
            AppBrandNumberKeyboardView.this.jfF.commitText(charSequence2, charSequence2.length());
            AppMethodBeat.m2505o(123756);
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m4798a(AppBrandNumberKeyboardView appBrandNumberKeyboardView, String str) {
        AppMethodBeat.m2504i(123764);
        int id = appBrandNumberKeyboardView.getId(str);
        AppMethodBeat.m2505o(123764);
        return id;
    }

    /* renamed from: b */
    static /* synthetic */ int m4801b(AppBrandNumberKeyboardView appBrandNumberKeyboardView, String str) {
        AppMethodBeat.m2504i(123765);
        int id = appBrandNumberKeyboardView.getId(str);
        AppMethodBeat.m2505o(123765);
        return id;
    }

    AppBrandNumberKeyboardView(Context context) {
        super(context);
        AppMethodBeat.m2504i(123759);
        init();
        AppMethodBeat.m2505o(123759);
    }

    public AppBrandNumberKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(123760);
        init();
        AppMethodBeat.m2505o(123760);
    }

    private void init() {
        AppMethodBeat.m2504i(123761);
        C25582 c25582 = new C25582();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jfE.size()) {
                findViewById(getId((String) this.jfE.valueAt(i2))).setOnClickListener(c25582);
                i = i2 + 1;
            } else {
                findViewById(getId("tenpay_keyboard_x")).setOnClickListener(c25582);
                findViewById(getId("tenpay_keyboard_d")).setOnClickListener(null);
                findViewById(getId("tenpay_keyboard_d")).setOnTouchListener(new C25573());
                AppMethodBeat.m2505o(123761);
                return;
            }
        }
    }

    public final void setXMode(int i) {
        AppMethodBeat.m2504i(123762);
        super.setXMode(i);
        this.jfD = i;
        AppMethodBeat.m2505o(123762);
    }

    public final void onDetachedFromWindow() {
        AppMethodBeat.m2504i(123763);
        super.onDetachedFromWindow();
        setInputEditText(null);
        AppMethodBeat.m2505o(123763);
    }

    /* renamed from: d */
    static /* synthetic */ boolean m4803d(AppBrandNumberKeyboardView appBrandNumberKeyboardView) {
        AppMethodBeat.m2504i(123766);
        if (appBrandNumberKeyboardView.jfF != null) {
            if ((!TextUtils.isEmpty(appBrandNumberKeyboardView.jfF.getTextBeforeCursor(1, 0)) ? 1 : 0) != 0) {
                appBrandNumberKeyboardView.jfF.deleteSurroundingText(1, 0);
            } else {
                appBrandNumberKeyboardView.jfF.sendKeyEvent(new KeyEvent(0, 67));
                appBrandNumberKeyboardView.jfF.sendKeyEvent(new KeyEvent(1, 67));
            }
            AppMethodBeat.m2505o(123766);
            return true;
        }
        AppMethodBeat.m2505o(123766);
        return false;
    }
}
