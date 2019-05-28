package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.widget.MMEditText;

public class InputClearablePreference extends Preference {
    public String hAa;
    private String mText;
    public String nJe;
    public String nJf;
    public int nJg;
    private int nJh;
    public boolean nJi;
    public MMEditText nJj;
    private ImageView nJk;
    public TextView nJl;
    private int nJm;
    public a nJn;

    public interface a {
        void PL(String str);

        void iy(boolean z);
    }

    class b implements InputFilter {
        public final char[] nJp = new char[]{10, ',', ';', 12289, 65292, 65307};

        b() {
            AppMethodBeat.i(22707);
            AppMethodBeat.o(22707);
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.i(22708);
            ab.d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4));
            int i5 = i;
            while (i5 < i2) {
                char[] cArr = new char[(i2 - i)];
                TextUtils.getChars(charSequence, i, i2, cArr, 0);
                int length = this.nJp.length;
                int i6 = 0;
                while (i6 < length) {
                    if (cArr[i5] == ' ' && i3 == 0 && i5 == 0) {
                        String str = "";
                        AppMethodBeat.o(22708);
                        return str;
                    } else if (cArr[i5] == this.nJp[i6]) {
                        InputClearablePreference.this.iA(true);
                        CharSequence charSequence2 = "";
                        AppMethodBeat.o(22708);
                        return charSequence2;
                    } else {
                        i6++;
                    }
                }
                i5++;
            }
            AppMethodBeat.o(22708);
            return null;
        }
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(String str) {
        AppMethodBeat.i(22709);
        this.mText = str;
        if (!(this.nJj == null || bo.isNullOrNil(str))) {
            this.nJj.setText(j.b(this.mContext, this.mText, this.nJm));
            PN(this.mText);
        }
        AppMethodBeat.o(22709);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(22710);
        super.onBindView(view);
        this.nJm = com.tencent.mm.bz.a.al(this.mContext, R.dimen.kr);
        this.nJj = (MMEditText) view.findViewById(R.id.l3);
        this.nJk = (ImageView) view.findViewById(R.id.b9d);
        this.nJl = (TextView) view.findViewById(R.id.da9);
        if (this.nJj != null) {
            if (this.nJh > 0) {
                this.nJj.setFilters(new InputFilter[]{new LengthFilter(this.nJh), new b()});
            } else {
                this.nJj.setFilters(new InputFilter[]{new b()});
            }
        }
        this.nJj.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(22702);
                if (charSequence != null) {
                    ab.d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", charSequence.toString());
                    if (InputClearablePreference.this.nJn != null) {
                        InputClearablePreference.this.nJn.PL(charSequence.toString());
                    }
                }
                AppMethodBeat.o(22702);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = false;
                AppMethodBeat.i(22703);
                if (editable != null) {
                    String obj = editable.toString();
                    InputClearablePreference.a(InputClearablePreference.this, obj);
                    InputClearablePreference inputClearablePreference = InputClearablePreference.this;
                    if (!bo.isNullOrNil(obj)) {
                        z = true;
                    }
                    InputClearablePreference.a(inputClearablePreference, z);
                    InputClearablePreference.this.mText = obj;
                    AppMethodBeat.o(22703);
                    return;
                }
                InputClearablePreference.a(InputClearablePreference.this, false);
                AppMethodBeat.o(22703);
            }
        });
        ab.d("MicroMsg.Label.InputClearablePreference", "mText %s", this.mText);
        setText(this.mText);
        if (!bo.isNullOrNil(this.mText)) {
            this.nJj.setSelection(this.mText.length());
        }
        if (this.nJi) {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22706);
                    if (InputClearablePreference.this.nJj != null) {
                        InputMethodManager inputMethodManager = (InputMethodManager) InputClearablePreference.this.nJj.getContext().getSystemService("input_method");
                        InputClearablePreference.this.nJj.requestFocus();
                        inputMethodManager.showSoftInput(InputClearablePreference.this.nJj, 0);
                        InputClearablePreference.this.nJj.setCursorVisible(false);
                        InputClearablePreference.this.nJj.setCursorVisible(true);
                    }
                    AppMethodBeat.o(22706);
                }
            }, 0);
        }
        this.nJj.setHint(this.nJe);
        this.nJk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(22704);
                if (InputClearablePreference.this.nJj != null) {
                    InputClearablePreference.this.nJj.setText("");
                    InputClearablePreference.this.mText = "";
                }
                AppMethodBeat.o(22704);
            }
        });
        if (this.nJl != null) {
            this.nJl.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(22705);
                    if (InputClearablePreference.this.nJj != null) {
                        InputClearablePreference.this.nJj.clearFocus();
                    }
                    AppMethodBeat.o(22705);
                    return false;
                }
            });
        }
        AppMethodBeat.o(22710);
    }

    private void PN(String str) {
        boolean z = true;
        AppMethodBeat.i(22711);
        if (!bo.isNullOrNil(str)) {
            int asg = f.asg(str);
            d(asg > this.nJg, f.bP(this.nJg, ""), f.bQ(this.nJg, str));
            if (this.nJn != null) {
                a aVar = this.nJn;
                if (asg > this.nJg) {
                    z = false;
                }
                aVar.iy(z);
            }
        }
        AppMethodBeat.o(22711);
    }

    private void d(boolean z, int i, int i2) {
        AppMethodBeat.i(22712);
        if (this.nJl != null) {
            if (z) {
                this.nJl.setText(String.format(this.hAa, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                this.nJl.setVisibility(0);
                AppMethodBeat.o(22712);
                return;
            }
            this.nJl.setVisibility(8);
        }
        AppMethodBeat.o(22712);
    }

    public final void iA(boolean z) {
        AppMethodBeat.i(22713);
        if (this.nJl != null) {
            if (z) {
                this.nJl.setText(this.nJf);
                this.nJl.setVisibility(0);
                AppMethodBeat.o(22713);
                return;
            }
            this.nJl.setVisibility(8);
        }
        AppMethodBeat.o(22713);
    }
}
