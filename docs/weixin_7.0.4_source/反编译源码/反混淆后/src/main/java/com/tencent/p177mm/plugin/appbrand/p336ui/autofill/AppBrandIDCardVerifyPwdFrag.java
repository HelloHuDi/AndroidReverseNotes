package com.tencent.p177mm.plugin.appbrand.p336ui.autofill;

import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C15481a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.MMFormVerifyCodeInputView;
import com.tencent.p177mm.p612ui.p613a.C5218c;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.plugin.appbrand.p336ui.autofill.AppBrandIDCardUI.C10825a;
import com.tencent.p177mm.plugin.appbrand.widget.C33575a;
import com.tencent.p177mm.protocal.protobuf.C15343gc;
import com.tencent.p177mm.protocal.protobuf.C46544gd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag */
public class AppBrandIDCardVerifyPwdFrag extends MMFragment {
    private LinearLayout eol;
    private MMFormVerifyCodeInputView gCi;
    private TextView hrg;
    C10825a iJN;
    private View iJO;
    private Button iJR;
    private C46544gd iKf;
    private C15343gc iKn;
    private TextView iKo;
    private TextView ixA;
    private C15481a mActionBarHelper;
    private MyKeyboardWindow mKeyboard;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$4 */
    class C108314 implements TextWatcher {
        C108314() {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(133256);
            if (AppBrandIDCardVerifyPwdFrag.this.gCi.getText().toString().length() > 0) {
                AppBrandIDCardVerifyPwdFrag.this.iJR.setEnabled(true);
                AppMethodBeat.m2505o(133256);
                return;
            }
            AppBrandIDCardVerifyPwdFrag.this.iJR.setEnabled(false);
            AppMethodBeat.m2505o(133256);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$5 */
    class C108325 implements OnClickListener {
        C108325() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133257);
            C4990ab.m7416i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
            if (AppBrandIDCardVerifyPwdFrag.this.iJN != null) {
                AppBrandIDCardVerifyPwdFrag.this.iJN.mo22368a(AppBrandIDCardVerifyPwdFrag.this.gCi.getText().toString(), AppBrandIDCardVerifyPwdFrag.this.iKn);
            }
            AppMethodBeat.m2505o(133257);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$2 */
    class C197672 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$2$1 */
        class C108271 implements C36073c {
            C108271() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(133250);
                C4990ab.m7417i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", Integer.valueOf(AppBrandIDCardVerifyPwdFrag.this.iKf.vIf.size()));
                Iterator it = AppBrandIDCardVerifyPwdFrag.this.iKf.vIf.iterator();
                while (it.hasNext()) {
                    C15343gc c15343gc = (C15343gc) it.next();
                    if (C5046bo.isNullOrNil(c15343gc.vId) || C5046bo.isNullOrNil(c15343gc.vIe)) {
                        C4990ab.m7412e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                    } else {
                        c44273l.mo70068e(AppBrandIDCardVerifyPwdFrag.this.iKf.vIf.indexOf(c15343gc), c15343gc.vIe);
                    }
                }
                AppMethodBeat.m2505o(133250);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$2$2 */
        class C108282 implements C5279d {
            C108282() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(133251);
                C15343gc c15343gc = (C15343gc) AppBrandIDCardVerifyPwdFrag.this.iKf.vIf.get(menuItem.getItemId());
                if (c15343gc == null) {
                    C4990ab.m7413e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", Integer.valueOf(menuItem.getItemId()));
                    AppMethodBeat.m2505o(133251);
                    return;
                }
                C4990ab.m7417i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", Integer.valueOf(menuItem.getItemId()), c15343gc.vId, c15343gc.vIe, c15343gc.pbn);
                AppBrandIDCardVerifyPwdFrag.this.iKn = c15343gc;
                AppBrandIDCardVerifyPwdFrag.this.ixA.setText(c15343gc.vIe);
                AppMethodBeat.m2505o(133251);
            }
        }

        C197672() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133252);
            if (AppBrandIDCardVerifyPwdFrag.this.iJN != null) {
                AppBrandIDCardVerifyPwdFrag.this.iJN.aMG();
            }
            C36356d c36356d = new C36356d(AppBrandIDCardVerifyPwdFrag.this.getContext(), 1, false);
            c36356d.rBl = new C108271();
            c36356d.rBm = new C108282();
            c36356d.cpD();
            AppMethodBeat.m2505o(133252);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$1 */
    class C197681 implements OnClickListener {
        C197681() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133249);
            if (AppBrandIDCardVerifyPwdFrag.this.iJN != null) {
                AppBrandIDCardVerifyPwdFrag.this.iJN.back();
            }
            AppMethodBeat.m2505o(133249);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$3 */
    class C197693 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$3$1 */
        class C108291 implements DialogInterface.OnClickListener {
            C108291() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(133253);
                AppBrandIDCardVerifyPwdFrag.this.gCi.dzH();
                C4990ab.m7416i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
                if (AppBrandIDCardVerifyPwdFrag.this.iJN != null) {
                    AppBrandIDCardVerifyPwdFrag.this.iJN.mo22367a(AppBrandIDCardVerifyPwdFrag.this.iKn);
                }
                AppMethodBeat.m2505o(133253);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag$3$2 */
        class C108302 implements DialogInterface.OnClickListener {
            C108302() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(133254);
                AppBrandIDCardVerifyPwdFrag.this.gCi.reset();
                AppMethodBeat.m2505o(133254);
            }
        }

        C197693() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133255);
            C30379h.m48445a(AppBrandIDCardVerifyPwdFrag.this.getContext(), AppBrandIDCardVerifyPwdFrag.this.getString(C25738R.string.f8932jt) + AppBrandIDCardVerifyPwdFrag.this.iKn.vIe, AppBrandIDCardVerifyPwdFrag.this.getString(C25738R.string.f8929jo), AppBrandIDCardVerifyPwdFrag.this.getString(C25738R.string.f9187s6), AppBrandIDCardVerifyPwdFrag.this.getString(C25738R.string.f9076or), false, new C108291(), new C108302());
            AppMethodBeat.m2505o(133255);
        }
    }

    public void dealContentView(View view) {
        AppMethodBeat.m2504i(133258);
        if (this.iJN == null || this.iJN.aMI() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            AppMethodBeat.m2505o(133258);
        } else if (this.iJN.aMI().vIf == null || this.iJN.aMI().vIf.size() <= 0) {
            C4990ab.m7412e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
            AppMethodBeat.m2505o(133258);
        } else {
            this.eol = (LinearLayout) view.findViewById(2131821210);
            this.hrg = (TextView) view.findViewById(2131821211);
            this.ixA = (TextView) view.findViewById(2131821212);
            this.iKo = (TextView) view.findViewById(2131821213);
            this.iJR = (Button) view.findViewById(2131821206);
            this.gCi = (MMFormVerifyCodeInputView) view.findViewById(2131821214);
            this.mKeyboard = (MyKeyboardWindow) view.findViewById(2131821215);
            this.iJO = C5616v.m8409hu(getContext()).inflate(2130968612, null);
            this.iJO.setBackgroundColor(getResources().getColor(C25738R.color.f12206vy));
            this.mActionBarHelper = new C15481a(this.iJO);
            this.eol.addView(this.iJO, 0, new LayoutParams(-1, C33575a.m54827de(getActivity())));
            this.iKf = this.iJN.aMI();
            this.mActionBarHelper.setTitle(this.iKf.title);
            this.mActionBarHelper.mo27555b(new C197681());
            this.hrg.setText(this.iKf.desc);
            this.iKn = (C15343gc) this.iKf.vIf.get(0);
            this.ixA.setText(((C15343gc) this.iKf.vIf.get(0)).vIe);
            if (this.iKf.vIf.size() > 1) {
                this.iKo.setVisibility(0);
                this.iKo.setOnClickListener(new C197672());
            } else {
                this.iKo.setVisibility(8);
            }
            this.gCi.setVisibility(0);
            this.gCi.setSendSmsBtnClickListener(new C197693());
            this.gCi.addTextChangedListener(new C108314());
            EditText contentEditText = this.gCi.getContentEditText();
            if (contentEditText != null) {
                if (VERSION.SDK_INT >= 21) {
                    contentEditText.setShowSoftInputOnFocus(false);
                } else {
                    Class cls = EditText.class;
                    try {
                        Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                        method.setAccessible(true);
                        method.invoke(contentEditText, new Object[]{Boolean.FALSE});
                        method.setAccessible(false);
                    } catch (NoSuchMethodException e) {
                        C4990ab.m7417i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(VERSION.SDK_INT));
                        try {
                            Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                            method2.setAccessible(true);
                            method2.invoke(contentEditText, new Object[]{Boolean.FALSE});
                            method2.setAccessible(false);
                        } catch (Exception e2) {
                            C4990ab.m7413e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", C5046bo.m7574l(e2));
                            if (contentEditText.getContext() != null && (contentEditText.getContext() instanceof MMActivity)) {
                                ((MMActivity) contentEditText.getContext()).hideVKB(contentEditText);
                            }
                        }
                    } catch (Exception e22) {
                        C4990ab.m7413e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", C5046bo.m7574l(e22));
                    }
                }
            }
            if (this.gCi.getText() == null || this.gCi.getText().toString().length() <= 0) {
                this.iJR.setEnabled(false);
            } else {
                this.iJR.setEnabled(true);
            }
            this.iJR.setVisibility(0);
            this.iJR.setOnClickListener(new C108325());
            this.mKeyboard.setXMode(0);
            this.mKeyboard.setInputEditText(this.gCi.getContentEditText());
            if (VERSION.SDK_INT >= 14) {
                this.mKeyboard.setAccessibilityDelegate(new C5218c());
            }
            AppMethodBeat.m2505o(133258);
        }
    }

    public int getLayoutId() {
        return 2130968688;
    }

    public void onResume() {
        AppMethodBeat.m2504i(133259);
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            getContentView().setVisibility(0);
            getSwipeBackLayout().setEnableGesture(true);
        }
        AppMethodBeat.m2505o(133259);
    }

    public boolean noActionBar() {
        return true;
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(133260);
        if (this.iJN != null) {
            this.iJN.onSwipeBack();
            getContentView().setVisibility(8);
            if (isSupportNavigationSwipeBack()) {
                getSwipeBackLayout().setEnableGesture(false);
            }
        }
        AppMethodBeat.m2505o(133260);
    }
}
