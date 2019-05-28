package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.BaseNumberKeyboardView;
import com.tencent.mm.plugin.appbrand.widget.input.numberpad.a;
import com.tencent.mm.sdk.platformtools.ab;

final class AppBrandNumberKeyboardView extends BaseNumberKeyboardView {
    private int jfD = 0;
    private final SparseArray<String> jfE = new SparseArray<String>() {
        {
            AppMethodBeat.i(123755);
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
            AppMethodBeat.o(123755);
        }
    };
    InputConnection jfF;
    a jfG;

    static /* synthetic */ int a(AppBrandNumberKeyboardView appBrandNumberKeyboardView, String str) {
        AppMethodBeat.i(123764);
        int id = appBrandNumberKeyboardView.getId(str);
        AppMethodBeat.o(123764);
        return id;
    }

    static /* synthetic */ int b(AppBrandNumberKeyboardView appBrandNumberKeyboardView, String str) {
        AppMethodBeat.i(123765);
        int id = appBrandNumberKeyboardView.getId(str);
        AppMethodBeat.o(123765);
        return id;
    }

    AppBrandNumberKeyboardView(Context context) {
        super(context);
        AppMethodBeat.i(123759);
        init();
        AppMethodBeat.o(123759);
    }

    public AppBrandNumberKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(123760);
        init();
        AppMethodBeat.o(123760);
    }

    private void init() {
        AppMethodBeat.i(123761);
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(123756);
                if (AppBrandNumberKeyboardView.this.jfF == null) {
                    AppMethodBeat.o(123756);
                    return;
                }
                CharSequence charSequence = null;
                if (view.getId() == AppBrandNumberKeyboardView.a(AppBrandNumberKeyboardView.this, "tenpay_keyboard_x")) {
                    switch (AppBrandNumberKeyboardView.this.jfD) {
                        case 1:
                            charSequence = "X";
                            break;
                        case 2:
                            charSequence = ".";
                            break;
                        default:
                            AppMethodBeat.o(123756);
                            return;
                    }
                }
                int i = 0;
                while (i < AppBrandNumberKeyboardView.this.jfE.size()) {
                    String valueOf;
                    if (view.getId() == AppBrandNumberKeyboardView.b(AppBrandNumberKeyboardView.this, (String) AppBrandNumberKeyboardView.this.jfE.valueAt(i))) {
                        valueOf = String.valueOf(AppBrandNumberKeyboardView.this.jfE.keyAt(i));
                    } else {
                        CharSequence valueOf2 = charSequence;
                    }
                    i++;
                    Object charSequence2 = valueOf2;
                }
                if (TextUtils.isEmpty(charSequence2)) {
                    AppMethodBeat.o(123756);
                    return;
                }
                AppBrandNumberKeyboardView.this.jfF.commitText(charSequence2, charSequence2.length());
                AppMethodBeat.o(123756);
            }
        };
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.jfE.size()) {
                findViewById(getId((String) this.jfE.valueAt(i2))).setOnClickListener(anonymousClass2);
                i = i2 + 1;
            } else {
                findViewById(getId("tenpay_keyboard_x")).setOnClickListener(anonymousClass2);
                findViewById(getId("tenpay_keyboard_d")).setOnClickListener(null);
                findViewById(getId("tenpay_keyboard_d")).setOnTouchListener(new an() {
                    /* Access modifiers changed, original: protected|final */
                    public final void aFi() {
                        AppMethodBeat.i(123757);
                        ab.d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onSingleTap");
                        AppBrandNumberKeyboardView.d(AppBrandNumberKeyboardView.this);
                        AppMethodBeat.o(123757);
                    }

                    /* Access modifiers changed, original: protected|final */
                    public final void aQX() {
                        AppMethodBeat.i(123758);
                        ab.d("MicroMsg.AppBrand.AppBrandNumberKeyboardView", "backspace onRepeat");
                        AppBrandNumberKeyboardView.d(AppBrandNumberKeyboardView.this);
                        AppMethodBeat.o(123758);
                    }
                });
                AppMethodBeat.o(123761);
                return;
            }
        }
    }

    public final void setXMode(int i) {
        AppMethodBeat.i(123762);
        super.setXMode(i);
        this.jfD = i;
        AppMethodBeat.o(123762);
    }

    public final void onDetachedFromWindow() {
        AppMethodBeat.i(123763);
        super.onDetachedFromWindow();
        setInputEditText(null);
        AppMethodBeat.o(123763);
    }

    static /* synthetic */ boolean d(AppBrandNumberKeyboardView appBrandNumberKeyboardView) {
        AppMethodBeat.i(123766);
        if (appBrandNumberKeyboardView.jfF != null) {
            if ((!TextUtils.isEmpty(appBrandNumberKeyboardView.jfF.getTextBeforeCursor(1, 0)) ? 1 : 0) != 0) {
                appBrandNumberKeyboardView.jfF.deleteSurroundingText(1, 0);
            } else {
                appBrandNumberKeyboardView.jfF.sendKeyEvent(new KeyEvent(0, 67));
                appBrandNumberKeyboardView.jfF.sendKeyEvent(new KeyEvent(1, 67));
            }
            AppMethodBeat.o(123766);
            return true;
        }
        AppMethodBeat.o(123766);
        return false;
    }
}
