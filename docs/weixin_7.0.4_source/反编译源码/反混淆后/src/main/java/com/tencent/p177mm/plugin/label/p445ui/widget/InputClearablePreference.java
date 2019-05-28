package com.tencent.p177mm.plugin.label.p445ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.label.ui.widget.InputClearablePreference */
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
    public C24785a nJn;

    /* renamed from: com.tencent.mm.plugin.label.ui.widget.InputClearablePreference$2 */
    class C123732 implements OnClickListener {
        C123732() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(22704);
            if (InputClearablePreference.this.nJj != null) {
                InputClearablePreference.this.nJj.setText("");
                InputClearablePreference.this.mText = "";
            }
            AppMethodBeat.m2505o(22704);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.widget.InputClearablePreference$4 */
    class C123744 implements Runnable {
        C123744() {
        }

        public final void run() {
            AppMethodBeat.m2504i(22706);
            if (InputClearablePreference.this.nJj != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) InputClearablePreference.this.nJj.getContext().getSystemService("input_method");
                InputClearablePreference.this.nJj.requestFocus();
                inputMethodManager.showSoftInput(InputClearablePreference.this.nJj, 0);
                InputClearablePreference.this.nJj.setCursorVisible(false);
                InputClearablePreference.this.nJj.setCursorVisible(true);
            }
            AppMethodBeat.m2505o(22706);
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.widget.InputClearablePreference$3 */
    class C247843 implements OnTouchListener {
        C247843() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(22705);
            if (InputClearablePreference.this.nJj != null) {
                InputClearablePreference.this.nJj.clearFocus();
            }
            AppMethodBeat.m2505o(22705);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.widget.InputClearablePreference$a */
    public interface C24785a {
        /* renamed from: PL */
        void mo36487PL(String str);

        /* renamed from: iy */
        void mo36488iy(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.widget.InputClearablePreference$b */
    class C24786b implements InputFilter {
        public final char[] nJp = new char[]{10, ',', ';', 12289, 65292, 65307};

        C24786b() {
            AppMethodBeat.m2504i(22707);
            AppMethodBeat.m2505o(22707);
        }

        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            AppMethodBeat.m2504i(22708);
            C4990ab.m7411d("MicroMsg.Label.InputClearablePreference", "on create tag filter, %s [%d, %d) %s [%d, %d),", charSequence, Integer.valueOf(i), Integer.valueOf(i2), spanned, Integer.valueOf(i3), Integer.valueOf(i4));
            int i5 = i;
            while (i5 < i2) {
                char[] cArr = new char[(i2 - i)];
                TextUtils.getChars(charSequence, i, i2, cArr, 0);
                int length = this.nJp.length;
                int i6 = 0;
                while (i6 < length) {
                    if (cArr[i5] == ' ' && i3 == 0 && i5 == 0) {
                        String str = "";
                        AppMethodBeat.m2505o(22708);
                        return str;
                    } else if (cArr[i5] == this.nJp[i6]) {
                        InputClearablePreference.this.mo41643iA(true);
                        CharSequence charSequence2 = "";
                        AppMethodBeat.m2505o(22708);
                        return charSequence2;
                    } else {
                        i6++;
                    }
                }
                i5++;
            }
            AppMethodBeat.m2505o(22708);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.widget.InputClearablePreference$1 */
    class C247871 implements TextWatcher {
        C247871() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(22702);
            if (charSequence != null) {
                C4990ab.m7411d("MicroMsg.Label.InputClearablePreference", "cpan[onTextChanged] :%s", charSequence.toString());
                if (InputClearablePreference.this.nJn != null) {
                    InputClearablePreference.this.nJn.mo36487PL(charSequence.toString());
                }
            }
            AppMethodBeat.m2505o(22702);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = false;
            AppMethodBeat.m2504i(22703);
            if (editable != null) {
                String obj = editable.toString();
                InputClearablePreference.m38706a(InputClearablePreference.this, obj);
                InputClearablePreference inputClearablePreference = InputClearablePreference.this;
                if (!C5046bo.isNullOrNil(obj)) {
                    z = true;
                }
                InputClearablePreference.m38707a(inputClearablePreference, z);
                InputClearablePreference.this.mText = obj;
                AppMethodBeat.m2505o(22703);
                return;
            }
            InputClearablePreference.m38707a(InputClearablePreference.this, false);
            AppMethodBeat.m2505o(22703);
        }
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InputClearablePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void setText(String str) {
        AppMethodBeat.m2504i(22709);
        this.mText = str;
        if (!(this.nJj == null || C5046bo.isNullOrNil(str))) {
            this.nJj.setText(C44089j.m79294b(this.mContext, this.mText, this.nJm));
            m38704PN(this.mText);
        }
        AppMethodBeat.m2505o(22709);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(22710);
        super.onBindView(view);
        this.nJm = C1338a.m2856al(this.mContext, C25738R.dimen.f9936kr);
        this.nJj = (MMEditText) view.findViewById(2131820980);
        this.nJk = (ImageView) view.findViewById(2131823259);
        this.nJl = (TextView) view.findViewById(2131826065);
        if (this.nJj != null) {
            if (this.nJh > 0) {
                this.nJj.setFilters(new InputFilter[]{new LengthFilter(this.nJh), new C24786b()});
            } else {
                this.nJj.setFilters(new InputFilter[]{new C24786b()});
            }
        }
        this.nJj.addTextChangedListener(new C247871());
        C4990ab.m7411d("MicroMsg.Label.InputClearablePreference", "mText %s", this.mText);
        setText(this.mText);
        if (!C5046bo.isNullOrNil(this.mText)) {
            this.nJj.setSelection(this.mText.length());
        }
        if (this.nJi) {
            new C7306ak().postDelayed(new C123744(), 0);
        }
        this.nJj.setHint(this.nJe);
        this.nJk.setOnClickListener(new C123732());
        if (this.nJl != null) {
            this.nJl.setOnTouchListener(new C247843());
        }
        AppMethodBeat.m2505o(22710);
    }

    /* renamed from: PN */
    private void m38704PN(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(22711);
        if (!C5046bo.isNullOrNil(str)) {
            int asg = C5584f.asg(str);
            m38710d(asg > this.nJg, C5584f.m8385bP(this.nJg, ""), C5584f.m8386bQ(this.nJg, str));
            if (this.nJn != null) {
                C24785a c24785a = this.nJn;
                if (asg > this.nJg) {
                    z = false;
                }
                c24785a.mo36488iy(z);
            }
        }
        AppMethodBeat.m2505o(22711);
    }

    /* renamed from: d */
    private void m38710d(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(22712);
        if (this.nJl != null) {
            if (z) {
                this.nJl.setText(String.format(this.hAa, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                this.nJl.setVisibility(0);
                AppMethodBeat.m2505o(22712);
                return;
            }
            this.nJl.setVisibility(8);
        }
        AppMethodBeat.m2505o(22712);
    }

    /* renamed from: iA */
    public final void mo41643iA(boolean z) {
        AppMethodBeat.m2504i(22713);
        if (this.nJl != null) {
            if (z) {
                this.nJl.setText(this.nJf);
                this.nJl.setVisibility(0);
                AppMethodBeat.m2505o(22713);
                return;
            }
            this.nJl.setVisibility(8);
        }
        AppMethodBeat.m2505o(22713);
    }
}
