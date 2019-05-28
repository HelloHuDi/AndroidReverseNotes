package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.edittext.PasterEditText;

public class MMEditText extends PasterEditText {
    int uQn = 0;
    private InputConnection zMl;
    private a zMm;

    public interface a {
        void bMu();
    }

    public interface b {
        void aqH();
    }

    public static class c implements TextWatcher {
        private final int limit;
        private EditText pwu;
        private TextView zMn;
        public b zMo = null;
        private boolean zMp = false;

        public c(EditText editText, TextView textView, int i) {
            this.pwu = editText;
            this.zMn = textView;
            this.limit = i;
        }

        public final void afterTextChanged(Editable editable) {
            int i;
            int i2 = 0;
            AppMethodBeat.i(107874);
            String obj = editable.toString();
            String str = "";
            int i3 = 0;
            for (i = 0; i < obj.length(); i++) {
                if (bo.y(obj.charAt(i))) {
                    i3 += 2;
                } else {
                    i3++;
                }
                if (i3 > this.limit) {
                    break;
                }
                str = str + obj.charAt(i);
            }
            if (i3 > this.limit) {
                try {
                    this.pwu.setText(str);
                    if (this.zMp) {
                        this.pwu.setSelection(0);
                    } else {
                        this.pwu.setSelection(this.pwu.getText().toString().length());
                    }
                    this.zMp = false;
                } catch (Exception e) {
                    this.zMp = true;
                    ab.e("MicroMsg.MMEditText", "error ".concat(String.valueOf(e.getMessage())));
                    this.pwu.setText(str);
                    this.pwu.setSelection(0);
                }
            }
            i = this.limit - i3;
            if (i >= 0) {
                i2 = i;
            }
            if (this.zMn != null) {
                this.zMn.setText((i2 / 2));
            }
            AppMethodBeat.o(107874);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.i(107875);
            if (this.zMo != null) {
                this.zMo.aqH();
            }
            AppMethodBeat.o(107875);
        }
    }

    public MMEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        AppMethodBeat.i(107876);
        this.zMl = super.onCreateInputConnection(editorInfo);
        InputConnection inputConnection = this.zMl;
        AppMethodBeat.o(107876);
        return inputConnection;
    }

    public InputConnection getInputConnection() {
        return this.zMl;
    }

    public MMEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void asB(String str) {
        AppMethodBeat.i(107877);
        getContext();
        int bV = com.tencent.mm.ui.e.c.b.bV(getText().toString(), getSelectionStart());
        getContext();
        int bV2 = com.tencent.mm.ui.e.c.b.bV(getText().toString(), getSelectionEnd());
        StringBuffer stringBuffer = new StringBuffer(getText());
        String str2 = stringBuffer.substring(0, bV) + str + stringBuffer.substring(bV2, stringBuffer.length());
        int i = -1;
        if (d.iW(21)) {
            InputFilter[] filters = getFilters();
            if (filters != null) {
                int length = filters.length;
                int i2 = 0;
                while (i2 < length) {
                    InputFilter inputFilter = filters[i2];
                    if (inputFilter instanceof LengthFilter) {
                        bV2 = ((LengthFilter) inputFilter).getMax();
                    } else {
                        bV2 = i;
                    }
                    i2++;
                    i = bV2;
                }
            }
        }
        bV2 = str.length() + bV;
        if (i <= 0 || bV2 <= i) {
            setText(com.tencent.mm.ui.e.c.b.c(getContext(), str2, getTextSize()));
            setSelection(bV2);
            AppMethodBeat.o(107877);
            return;
        }
        ab.d("MicroMsg.MMEditText", "exceed :%s, %s", Integer.valueOf(i), Integer.valueOf(bV2));
        AppMethodBeat.o(107877);
    }

    public boolean requestFocus(int i, Rect rect) {
        boolean z = false;
        AppMethodBeat.i(107878);
        try {
            z = super.requestFocus(i, rect);
            AppMethodBeat.o(107878);
        } catch (IllegalStateException e) {
            ab.e("MicroMsg.MMEditText", "[requestFocus] error:%s", e);
            AppMethodBeat.o(107878);
        }
        return z;
    }

    public void setSelection(int i) {
        AppMethodBeat.i(107879);
        try {
            super.setSelection(i);
            AppMethodBeat.o(107879);
        } catch (IndexOutOfBoundsException e) {
            ab.printErrStackTrace("MicroMsg.MMEditText", e, "IndexOutOfBoundsExceptionindex = ".concat(String.valueOf(i)), new Object[0]);
            AppMethodBeat.o(107879);
        }
    }

    public void setSelection(int i, int i2) {
        AppMethodBeat.i(107880);
        super.setSelection(i, i2);
        AppMethodBeat.o(107880);
    }

    public boolean onTextContextMenuItem(int i) {
        boolean onTextContextMenuItem;
        AppMethodBeat.i(107881);
        try {
            onTextContextMenuItem = super.onTextContextMenuItem(i);
        } catch (IndexOutOfBoundsException e) {
            ab.e("MicroMsg.MMEditText", "!!MMEditText IndexOutOfBoundsException %s", e);
            onTextContextMenuItem = false;
        } catch (NullPointerException e2) {
            ab.e("MicroMsg.MMEditText", "!!MMEditText NullPointerException %s", e2);
            AppMethodBeat.o(107881);
            return false;
        }
        if (i == 16908322) {
            this.uQn = 0;
            String obj = getText().toString();
            try {
                ajp(obj);
            } catch (IndexOutOfBoundsException e3) {
                ab.e("MicroMsg.MMEditText", "!!MMEditText Exception %d", Integer.valueOf(this.uQn));
                if (this.uQn < 3) {
                    this.uQn++;
                    ajp(" ".concat(String.valueOf(obj)));
                } else {
                    AppMethodBeat.o(107881);
                    throw e3;
                }
            }
        }
        AppMethodBeat.o(107881);
        return onTextContextMenuItem;
    }

    private void ajp(String str) {
        AppMethodBeat.i(107882);
        int selectionStart = getSelectionStart();
        setText(com.tencent.mm.ui.e.c.b.c(getContext(), str, getTextSize()));
        int length = getText().length() - str.length();
        if (length > 0) {
            selectionStart += length;
            if (selectionStart <= getText().length()) {
                setSelection(selectionStart);
            }
            AppMethodBeat.o(107882);
            return;
        }
        setSelection(selectionStart);
        AppMethodBeat.o(107882);
    }

    public void setBackListener(a aVar) {
        this.zMm = aVar;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(107883);
        String str = "MicroMsg.MMEditText";
        String str2 = "on onKeyPreIme, listener null ? %B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.zMm == null);
        ab.v(str, str2, objArr);
        if (this.zMm != null && i == 4) {
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                ab.v("MicroMsg.MMEditText", "on onKeyPreIme action down");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                AppMethodBeat.o(107883);
                return true;
            } else if (keyEvent.getAction() == 1) {
                ab.v("MicroMsg.MMEditText", "on onKeyPreIme action up");
                keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    ab.v("MicroMsg.MMEditText", "on onKeyPreIme action up is tracking");
                    this.zMm.bMu();
                    InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
                    }
                    AppMethodBeat.o(107883);
                    return true;
                }
            }
        }
        boolean onKeyPreIme = super.onKeyPreIme(i, keyEvent);
        AppMethodBeat.o(107883);
        return onKeyPreIme;
    }
}
