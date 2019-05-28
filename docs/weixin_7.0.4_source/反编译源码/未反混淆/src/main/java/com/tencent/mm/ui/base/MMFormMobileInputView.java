package com.tencent.mm.ui.base;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText.c;

public class MMFormMobileInputView extends LinearLayout {
    private Context mContext;
    private int yuj;
    private int[] yuk;
    private EditText yum;
    private EditText yun;
    private String yuo;
    private String yup;
    private final int yuq;
    private a yur;

    public interface a {
    }

    @TargetApi(11)
    public MMFormMobileInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(106574);
        this.mContext = null;
        this.yuj = -1;
        this.yuo = "";
        this.yup = "";
        this.yuq = 13;
        this.yur = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mm.ad.a.a.FormItemView, i, 0);
        this.yuj = obtainStyledAttributes.getResourceId(2, -1);
        obtainStyledAttributes.recycle();
        v.hu(context).inflate(R.layout.adv, this);
        this.mContext = context;
        AppMethodBeat.o(106574);
    }

    public MMFormMobileInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setOnCountryCodeChangedListener(a aVar) {
        this.yur = aVar;
    }

    public final void qb(boolean z) {
        AppMethodBeat.i(106576);
        eG(this.yum);
        if (z) {
            this.yum.setBackgroundResource(R.drawable.b77);
        } else {
            this.yum.setBackgroundResource(R.drawable.b78);
        }
        eH(this.yum);
        eG(this.yun);
        if (z) {
            this.yun.setBackgroundResource(R.drawable.b77);
        } else {
            this.yun.setBackgroundResource(R.drawable.b78);
        }
        eH(this.yun);
        AppMethodBeat.o(106576);
    }

    private void eG(View view) {
        AppMethodBeat.i(106577);
        this.yuk = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
        AppMethodBeat.o(106577);
    }

    private void eH(View view) {
        AppMethodBeat.i(106578);
        if (this.yuk != null) {
            view.setPadding(this.yuk[0], this.yuk[1], this.yuk[2], this.yuk[3]);
        }
        AppMethodBeat.o(106578);
    }

    public void setCountryCode(String str) {
        AppMethodBeat.i(106579);
        if (this.yum != null) {
            this.yum.setText(str);
            AppMethodBeat.o(106579);
            return;
        }
        ab.e("MicroMsg.MMFormMobileInputView", "countryCodeET is null!");
        AppMethodBeat.o(106579);
    }

    public void setHint(String str) {
        AppMethodBeat.i(106580);
        if (this.yun != null) {
            this.yun.setHint(str);
            AppMethodBeat.o(106580);
            return;
        }
        ab.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
        AppMethodBeat.o(106580);
    }

    public void setMobileNumber(String str) {
        AppMethodBeat.i(106581);
        if (this.yun != null) {
            this.yun.setText(str);
            AppMethodBeat.o(106581);
            return;
        }
        ab.e("MicroMsg.MMFormMobileInputView", "mobileNumberET is null!");
        AppMethodBeat.o(106581);
    }

    public String getMobileNumber() {
        AppMethodBeat.i(106582);
        String amN;
        if (this.yun != null) {
            amN = av.amN(this.yun.getText().toString());
            AppMethodBeat.o(106582);
            return amN;
        }
        amN = "";
        AppMethodBeat.o(106582);
        return amN;
    }

    public String getCountryCode() {
        AppMethodBeat.i(106583);
        String trim;
        if (this.yum != null) {
            trim = this.yum.getText().toString().trim();
            AppMethodBeat.o(106583);
            return trim;
        }
        trim = "";
        AppMethodBeat.o(106583);
        return trim;
    }

    public EditText getCountryCodeEditText() {
        return this.yum;
    }

    public EditText getMobileNumberEditText() {
        return this.yun;
    }

    public void onFinishInflate() {
        AppMethodBeat.i(106575);
        this.yum = (EditText) findViewById(R.id.a4y);
        this.yun = (EditText) findViewById(R.id.d9i);
        if (this.yum == null || this.yun == null) {
            ab.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", this.yum, this.yun);
        } else if (this.yuj != -1) {
            this.yun.setHint(this.yuj);
        }
        if (!(this.yum == null || this.yun == null)) {
            if (this.yum.hasFocus() || this.yun.hasFocus()) {
                qb(true);
            } else {
                qb(false);
            }
            AnonymousClass1 anonymousClass1 = new OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    AppMethodBeat.i(106570);
                    if (view == MMFormMobileInputView.this.yum || view == MMFormMobileInputView.this.yun) {
                        MMFormMobileInputView.this.qb(z);
                    }
                    AppMethodBeat.o(106570);
                }
            };
            this.yum.setOnFocusChangeListener(anonymousClass1);
            this.yun.setOnFocusChangeListener(anonymousClass1);
            this.yun.addTextChangedListener(new c(this.yun, null, 20));
            this.yun.addTextChangedListener(new TextWatcher() {
                private av gGg = new av();

                {
                    AppMethodBeat.i(106571);
                    AppMethodBeat.o(106571);
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(106572);
                    int selectionEnd = MMFormMobileInputView.this.yun.getSelectionEnd();
                    String obj = MMFormMobileInputView.this.yun.getText().toString();
                    String substring = MMFormMobileInputView.this.yun.getText().toString().substring(0, selectionEnd);
                    if (!(obj == null || obj.equals(MMFormMobileInputView.this.yuo))) {
                        String obj2 = MMFormMobileInputView.this.yum.getText().toString();
                        MMFormMobileInputView.this.yuo = av.formatNumber(obj2.replace("+", ""), obj);
                        MMFormMobileInputView.this.yup = av.formatNumber(obj2.replace("+", ""), substring);
                        if (obj.equals(MMFormMobileInputView.this.yuo)) {
                            AppMethodBeat.o(106572);
                            return;
                        }
                        MMFormMobileInputView.this.yun.setText(MMFormMobileInputView.this.yuo);
                        int length = MMFormMobileInputView.this.yun.getText().toString().length();
                        if (substring != null) {
                            try {
                                MMFormMobileInputView.this.yup = av.formatNumber(obj2.replace("+", ""), substring);
                                if (obj.length() > 13 && selectionEnd <= length) {
                                    MMFormMobileInputView.this.yun.setSelection(substring.toString().length());
                                    AppMethodBeat.o(106572);
                                    return;
                                } else if (selectionEnd > length || MMFormMobileInputView.this.yup.toString().length() > length) {
                                    MMFormMobileInputView.this.yun.setSelection(length - Math.abs(obj.length() - selectionEnd));
                                    AppMethodBeat.o(106572);
                                    return;
                                } else {
                                    MMFormMobileInputView.this.yun.setSelection(MMFormMobileInputView.this.yup.toString().length());
                                    AppMethodBeat.o(106572);
                                    return;
                                }
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.MMFormMobileInputView", e, "", new Object[0]);
                            }
                        } else {
                            MMFormMobileInputView.this.yun.setSelection(0);
                            AppMethodBeat.o(106572);
                            return;
                        }
                    }
                    AppMethodBeat.o(106572);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            this.yum.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(106573);
                    String obj = MMFormMobileInputView.this.yum.getText().toString();
                    if (bo.isNullOrNil(obj)) {
                        MMFormMobileInputView.this.yum.setText("+");
                        MMFormMobileInputView.this.yum.setSelection(MMFormMobileInputView.this.yum.getText().toString().length());
                    } else if (!obj.contains("+")) {
                        MMFormMobileInputView.this.yum.setText("+".concat(String.valueOf(obj)));
                        MMFormMobileInputView.this.yum.setSelection(MMFormMobileInputView.this.yum.getText().toString().length());
                    } else if (obj.length() > 1) {
                        obj = obj.substring(1);
                        if (obj.length() > 4) {
                            MMFormMobileInputView.this.yum.setText(obj.substring(0, 4));
                            AppMethodBeat.o(106573);
                            return;
                        }
                    }
                    if (MMFormMobileInputView.this.yur != null) {
                        MMFormMobileInputView.this.yur;
                    }
                    AppMethodBeat.o(106573);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
        AppMethodBeat.o(106575);
    }
}
