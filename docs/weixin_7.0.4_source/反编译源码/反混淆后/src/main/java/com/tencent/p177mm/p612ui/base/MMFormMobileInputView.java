package com.tencent.p177mm.p612ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p180ad.C37433a.C1190a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.widget.MMEditText.C5622c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.ui.base.MMFormMobileInputView */
public class MMFormMobileInputView extends LinearLayout {
    private Context mContext;
    private int yuj;
    private int[] yuk;
    private EditText yum;
    private EditText yun;
    private String yuo;
    private String yup;
    private final int yuq;
    private C44261a yur;

    /* renamed from: com.tencent.mm.ui.base.MMFormMobileInputView$2 */
    class C52532 implements TextWatcher {
        private C5025av gGg = new C5025av();

        C52532() {
            AppMethodBeat.m2504i(106571);
            AppMethodBeat.m2505o(106571);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(106572);
            int selectionEnd = MMFormMobileInputView.this.yun.getSelectionEnd();
            String obj = MMFormMobileInputView.this.yun.getText().toString();
            String substring = MMFormMobileInputView.this.yun.getText().toString().substring(0, selectionEnd);
            if (!(obj == null || obj.equals(MMFormMobileInputView.this.yuo))) {
                String obj2 = MMFormMobileInputView.this.yum.getText().toString();
                MMFormMobileInputView.this.yuo = C5025av.formatNumber(obj2.replace("+", ""), obj);
                MMFormMobileInputView.this.yup = C5025av.formatNumber(obj2.replace("+", ""), substring);
                if (obj.equals(MMFormMobileInputView.this.yuo)) {
                    AppMethodBeat.m2505o(106572);
                    return;
                }
                MMFormMobileInputView.this.yun.setText(MMFormMobileInputView.this.yuo);
                int length = MMFormMobileInputView.this.yun.getText().toString().length();
                if (substring != null) {
                    try {
                        MMFormMobileInputView.this.yup = C5025av.formatNumber(obj2.replace("+", ""), substring);
                        if (obj.length() > 13 && selectionEnd <= length) {
                            MMFormMobileInputView.this.yun.setSelection(substring.toString().length());
                            AppMethodBeat.m2505o(106572);
                            return;
                        } else if (selectionEnd > length || MMFormMobileInputView.this.yup.toString().length() > length) {
                            MMFormMobileInputView.this.yun.setSelection(length - Math.abs(obj.length() - selectionEnd));
                            AppMethodBeat.m2505o(106572);
                            return;
                        } else {
                            MMFormMobileInputView.this.yun.setSelection(MMFormMobileInputView.this.yup.toString().length());
                            AppMethodBeat.m2505o(106572);
                            return;
                        }
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.MMFormMobileInputView", e, "", new Object[0]);
                    }
                } else {
                    MMFormMobileInputView.this.yun.setSelection(0);
                    AppMethodBeat.m2505o(106572);
                    return;
                }
            }
            AppMethodBeat.m2505o(106572);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMFormMobileInputView$3 */
    class C52543 implements TextWatcher {
        C52543() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(106573);
            String obj = MMFormMobileInputView.this.yum.getText().toString();
            if (C5046bo.isNullOrNil(obj)) {
                MMFormMobileInputView.this.yum.setText("+");
                MMFormMobileInputView.this.yum.setSelection(MMFormMobileInputView.this.yum.getText().toString().length());
            } else if (!obj.contains("+")) {
                MMFormMobileInputView.this.yum.setText("+".concat(String.valueOf(obj)));
                MMFormMobileInputView.this.yum.setSelection(MMFormMobileInputView.this.yum.getText().toString().length());
            } else if (obj.length() > 1) {
                obj = obj.substring(1);
                if (obj.length() > 4) {
                    MMFormMobileInputView.this.yum.setText(obj.substring(0, 4));
                    AppMethodBeat.m2505o(106573);
                    return;
                }
            }
            if (MMFormMobileInputView.this.yur != null) {
                MMFormMobileInputView.this.yur;
            }
            AppMethodBeat.m2505o(106573);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMFormMobileInputView$1 */
    class C442601 implements OnFocusChangeListener {
        C442601() {
        }

        public final void onFocusChange(View view, boolean z) {
            AppMethodBeat.m2504i(106570);
            if (view == MMFormMobileInputView.this.yum || view == MMFormMobileInputView.this.yun) {
                MMFormMobileInputView.this.mo69938qb(z);
            }
            AppMethodBeat.m2505o(106570);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMFormMobileInputView$a */
    public interface C44261a {
    }

    @TargetApi(11)
    public MMFormMobileInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106574);
        this.mContext = null;
        this.yuj = -1;
        this.yuo = "";
        this.yup = "";
        this.yuq = 13;
        this.yur = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1190a.FormItemView, i, 0);
        this.yuj = obtainStyledAttributes.getResourceId(2, -1);
        obtainStyledAttributes.recycle();
        C5616v.m8409hu(context).inflate(2130970118, this);
        this.mContext = context;
        AppMethodBeat.m2505o(106574);
    }

    public MMFormMobileInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setOnCountryCodeChangedListener(C44261a c44261a) {
        this.yur = c44261a;
    }

    /* renamed from: qb */
    public final void mo69938qb(boolean z) {
        AppMethodBeat.m2504i(106576);
        m79932eG(this.yum);
        if (z) {
            this.yum.setBackgroundResource(C25738R.drawable.b77);
        } else {
            this.yum.setBackgroundResource(C25738R.drawable.b78);
        }
        m79933eH(this.yum);
        m79932eG(this.yun);
        if (z) {
            this.yun.setBackgroundResource(C25738R.drawable.b77);
        } else {
            this.yun.setBackgroundResource(C25738R.drawable.b78);
        }
        m79933eH(this.yun);
        AppMethodBeat.m2505o(106576);
    }

    /* renamed from: eG */
    private void m79932eG(View view) {
        AppMethodBeat.m2504i(106577);
        this.yuk = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        AppMethodBeat.m2505o(106577);
    }

    /* renamed from: eH */
    private void m79933eH(View view) {
        AppMethodBeat.m2504i(106578);
        if (this.yuk != null) {
            view.setPadding(this.yuk[0], this.yuk[1], this.yuk[2], this.yuk[3]);
        }
        AppMethodBeat.m2505o(106578);
    }

    public void setCountryCode(String str) {
        AppMethodBeat.m2504i(106579);
        if (this.yum != null) {
            this.yum.setText(str);
            AppMethodBeat.m2505o(106579);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
        AppMethodBeat.m2505o(106579);
    }

    public void setHint(String str) {
        AppMethodBeat.m2504i(106580);
        if (this.yun != null) {
            this.yun.setHint(str);
            AppMethodBeat.m2505o(106580);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
        AppMethodBeat.m2505o(106580);
    }

    public void setMobileNumber(String str) {
        AppMethodBeat.m2504i(106581);
        if (this.yun != null) {
            this.yun.setText(str);
            AppMethodBeat.m2505o(106581);
            return;
        }
        C4990ab.m7412e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
        AppMethodBeat.m2505o(106581);
    }

    public String getMobileNumber() {
        AppMethodBeat.m2504i(106582);
        String amN;
        if (this.yun != null) {
            amN = C5025av.amN(this.yun.getText().toString());
            AppMethodBeat.m2505o(106582);
            return amN;
        }
        amN = "";
        AppMethodBeat.m2505o(106582);
        return amN;
    }

    public String getCountryCode() {
        AppMethodBeat.m2504i(106583);
        String trim;
        if (this.yum != null) {
            trim = this.yum.getText().toString().trim();
            AppMethodBeat.m2505o(106583);
            return trim;
        }
        trim = "";
        AppMethodBeat.m2505o(106583);
        return trim;
    }

    public EditText getCountryCodeEditText() {
        return this.yum;
    }

    public EditText getMobileNumberEditText() {
        return this.yun;
    }

    public void onFinishInflate() {
        AppMethodBeat.m2504i(106575);
        this.yum = (EditText) findViewById(2131821727);
        this.yun = (EditText) findViewById(2131826001);
        if (this.yum == null || this.yun == null) {
            C4990ab.m7421w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", this.yum, this.yun);
        } else if (this.yuj != -1) {
            this.yun.setHint(this.yuj);
        }
        if (!(this.yum == null || this.yun == null)) {
            if (this.yum.hasFocus() || this.yun.hasFocus()) {
                mo69938qb(true);
            } else {
                mo69938qb(false);
            }
            C442601 c442601 = new C442601();
            this.yum.setOnFocusChangeListener(c442601);
            this.yun.setOnFocusChangeListener(c442601);
            this.yun.addTextChangedListener(new C5622c(this.yun, null, 20));
            this.yun.addTextChangedListener(new C52532());
            this.yum.addTextChangedListener(new C52543());
        }
        AppMethodBeat.m2505o(106575);
    }
}
