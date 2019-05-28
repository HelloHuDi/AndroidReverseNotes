package com.tencent.p177mm.plugin.recharge.p491ui.form;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.recharge.model.C43420a;
import com.tencent.p177mm.plugin.recharge.model.C43421b;
import com.tencent.p177mm.plugin.recharge.p1655a.C46158a;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C43426d.C43425d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.recharge.ui.form.c */
public final class C39575c {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$a */
    static class C28816a implements C46162b {
        private C28816a() {
        }

        /* synthetic */ C28816a(byte b) {
            this();
        }

        /* renamed from: a */
        public boolean mo46965a(MallFormView mallFormView) {
            return true;
        }

        public boolean cev() {
            return false;
        }

        /* renamed from: VG */
        public String mo46964VG(String str) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b */
    public static class C28818b {
        public List<String[]> pGw;
        public C43420a pGx = null;
        public MallFormView pIg = null;
        public C43426d pIh;
        boolean pIi = false;

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$5 */
        public class C215915 implements OnClickListener {
            final /* synthetic */ InstantAutoCompleteTextView pIk;

            public C215915(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pIk = instantAutoCompleteTextView;
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(44371);
                this.pIk.requestFocus();
                AppMethodBeat.m2505o(44371);
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$4 */
        public class C288174 implements OnFocusChangeListener {
            final /* synthetic */ InstantAutoCompleteTextView pIk;

            public C288174(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pIk = instantAutoCompleteTextView;
            }

            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.m2504i(44370);
                if (z) {
                    this.pIk.setHintTextColor(view.getContext().getResources().getColor(C25738R.color.f11903l5));
                    if (C28818b.this.pGx != null && C28818b.this.pGx.cvp == 2 && !C28818b.this.pIi) {
                        C4990ab.m7410d(C39575c.TAG, "clear input");
                        C28818b.this.pIg.cey();
                        C28818b.this.pGx = null;
                    } else if (C28818b.this.pIi) {
                        C28818b.this.pIi = false;
                    }
                    if (C5046bo.isNullOrNil(this.pIk.getText().toString())) {
                        this.pIk.showDropDown();
                    }
                }
                AppMethodBeat.m2505o(44370);
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$1 */
        public class C288191 implements TextWatcher {
            private int pGA = 0;

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.m2504i(44368);
                String charSequence2 = charSequence.toString();
                int selectionStart = C28818b.this.pIg.getContentEditText().getSelectionStart();
                Object obj = "";
                if (charSequence2 != null) {
                    StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = stringBuilder.length();
                    if (length >= 4) {
                        stringBuilder.insert(3, ' ');
                    }
                    if (length >= 8) {
                        stringBuilder.insert(8, ' ');
                    }
                    obj = stringBuilder.toString();
                    length = obj.length();
                    if (length > this.pGA) {
                        if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                            selectionStart += i3;
                        }
                    } else if (length < this.pGA && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    this.pGA = length;
                }
                if (!charSequence2.equals(obj)) {
                    C28818b.this.pIg.getContentEditText().setText(obj);
                    if (selectionStart < this.pGA) {
                        C28818b.this.pIg.getContentEditText().setSelection(selectionStart);
                        AppMethodBeat.m2505o(44368);
                        return;
                    }
                    C28818b.this.pIg.getContentEditText().setSelection(this.pGA);
                }
                AppMethodBeat.m2505o(44368);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$3 */
        public class C288203 implements OnItemClickListener {
            final /* synthetic */ InstantAutoCompleteTextView pIk;

            public C288203(InstantAutoCompleteTextView instantAutoCompleteTextView) {
                this.pIk = instantAutoCompleteTextView;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(44369);
                C28818b.this.pGx = C28818b.this.pIh.mo68976BA(i);
                if (C28818b.this.pGx != null) {
                    C4990ab.m7416i(C39575c.TAG, "onItemClick record.record " + C28818b.this.pGx.pFM + ", record.name " + C28818b.this.pGx.name);
                    C28818b.this.pIi = true;
                    C28818b.this.setInput(C28818b.this.pGx);
                } else {
                    C4990ab.m7420w(C39575c.TAG, "record is null");
                }
                this.pIk.dismissDropDown();
                AppMethodBeat.m2505o(44369);
            }
        }

        /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$b$2 */
        public class C288212 implements C43425d {
        }

        public C28818b(MallFormView mallFormView) {
            this.pIg = mallFormView;
        }

        public final void setInput(C43420a c43420a) {
            AppMethodBeat.m2504i(44372);
            this.pGx = c43420a;
            if (c43420a != null) {
                if (C5046bo.isNullOrNil(this.pIg.getText()) || !this.pIg.getText().equals(c43420a.pFM)) {
                    this.pIg.getContentEditText().setText(C43421b.m77503VB(c43420a.pFM));
                }
                this.pIg.getContentEditText().setSelection(this.pIg.getContentEditText().getText().length());
                C4990ab.m7411d(C39575c.TAG, "editTv.setText %s, name: %s, location: %s, type: %s", c43420a.pFM, c43420a.name, c43420a.pFN, Integer.valueOf(c43420a.cvp));
                Context context = this.pIg.getContext();
                if (this.pGx.cvp == 3) {
                    this.pIg.getTipsTv().setText(this.pGx.name);
                    this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12257xp));
                    AppMethodBeat.m2505o(44372);
                    return;
                } else if (this.pGx.cvp == 1) {
                    CharSequence string;
                    if (C5046bo.isNullOrNil(this.pGx.name)) {
                        string = context.getString(C25738R.string.fr7);
                        if (!C5046bo.isNullOrNil(this.pGx.pFN)) {
                            string = string + context.getString(C25738R.string.fqx, new Object[]{this.pGx.pFN});
                        }
                        this.pIg.getTipsTv().setText(string);
                        this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12250xh));
                        AppMethodBeat.m2505o(44372);
                        return;
                    }
                    string = this.pGx.name;
                    if (!C5046bo.isNullOrNil(this.pGx.pFN)) {
                        string = string + context.getString(C25738R.string.fqx, new Object[]{this.pGx.pFN});
                    }
                    this.pIg.getTipsTv().setText(string);
                    this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12212w4));
                    AppMethodBeat.m2505o(44372);
                    return;
                } else if (this.pGx.cvp != 2) {
                    if (this.pGx.cvp == 0) {
                        if (C5046bo.isNullOrNil(this.pGx.pFN)) {
                            if (C5046bo.isNullOrNil(this.pGx.name)) {
                                this.pIg.getTipsTv().setText("");
                                this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12212w4));
                            } else {
                                this.pIg.getTipsTv().setText(this.pGx.name);
                                this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12250xh));
                                AppMethodBeat.m2505o(44372);
                                return;
                            }
                        } else if (C5046bo.isNullOrNil(this.pGx.name)) {
                            this.pIg.getTipsTv().setText(this.pGx.pFN);
                            this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12212w4));
                            AppMethodBeat.m2505o(44372);
                            return;
                        } else {
                            this.pIg.getTipsTv().setText(this.pGx.name + context.getString(C25738R.string.fqx, new Object[]{this.pGx.pFN}));
                            this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12250xh));
                            AppMethodBeat.m2505o(44372);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(44372);
                    return;
                } else if (C5046bo.isNullOrNil(this.pGx.pFN)) {
                    this.pIg.getTipsTv().setText("");
                    this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12250xh));
                    AppMethodBeat.m2505o(44372);
                    return;
                } else {
                    this.pIg.getTipsTv().setText(this.pGx.pFN);
                    this.pIg.getTipsTv().setTextColor(context.getResources().getColor(C25738R.color.f12212w4));
                    AppMethodBeat.m2505o(44372);
                    return;
                }
            }
            this.pIg.getContentEditText().setText("");
            C4990ab.m7410d(C39575c.TAG, "editTv.setText null");
            this.pIg.getTipsTv().setText("");
            AppMethodBeat.m2505o(44372);
        }

        /* renamed from: kd */
        public final void mo46968kd(boolean z) {
            List arrayList;
            AppMethodBeat.m2504i(44373);
            C4990ab.m7411d(C39575c.TAG, "needSetInput: %s", Boolean.valueOf(z));
            List ceb = C46158a.cea().ceb();
            C43420a cec;
            if (ceb == null) {
                arrayList = new ArrayList();
                cec = C46158a.cec();
                if (cec != null) {
                    arrayList.add(cec);
                    C46158a.cea().mo74108a(cec);
                }
            } else {
                String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
                for (int i = 0; i < ceb.size(); i++) {
                    cec = (C43420a) ceb.get(i);
                    if (C5046bo.isNullOrNil(cec.pFM) || !cec.pFM.equals(str)) {
                        if (!(C5046bo.isNullOrNil(cec.pFM) || !C5046bo.isNullOrNil(cec.name) || this.pGw == null)) {
                            for (String[] strArr : this.pGw) {
                                if (cec.pFM.equals(C43421b.m77507ws(strArr[2]))) {
                                    cec.name = strArr[1];
                                    C4990ab.m7417i(C39575c.TAG, "add name: %s", strArr[1]);
                                    break;
                                }
                            }
                        }
                    } else if (C5046bo.isNullOrNil(cec.name) || !cec.name.equals(this.pIg.getContext().getString(C25738R.string.fr5))) {
                        cec.name = this.pIg.getContext().getString(C25738R.string.fr5);
                    } else {
                    }
                    C46158a.cea().mo74109cK(ceb);
                }
                arrayList = ceb;
            }
            this.pIh.mo68977cK(arrayList);
            if (arrayList != null && arrayList.size() > 0 && z) {
                this.pGx = (C43420a) arrayList.get(0);
                setInput(this.pGx);
            }
            AppMethodBeat.m2505o(44373);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.form.c$1 */
    static class C395761 extends C28816a {
        C395761() {
            super();
        }

        /* renamed from: a */
        public final boolean mo46965a(MallFormView mallFormView) {
            AppMethodBeat.m2504i(44366);
            boolean isGlobalPhoneNumber = PhoneNumberUtils.isGlobalPhoneNumber(C43421b.m77507ws(mallFormView.getText().toString()));
            AppMethodBeat.m2505o(44366);
            return isGlobalPhoneNumber;
        }

        public final boolean cev() {
            return true;
        }

        /* renamed from: VG */
        public final String mo46964VG(String str) {
            AppMethodBeat.m2504i(44367);
            String str2;
            if (str == null) {
                str2 = "";
                AppMethodBeat.m2505o(44367);
                return str2;
            }
            str2 = str.replaceAll(" ", "");
            AppMethodBeat.m2505o(44367);
            return str2;
        }
    }

    /* renamed from: b */
    public static void m67643b(MallFormView mallFormView) {
        AppMethodBeat.m2504i(44374);
        if (mallFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(44374);
            return;
        }
        mallFormView.setLogicDelegate(new C395761());
        AppMethodBeat.m2505o(44374);
    }
}
