package com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.prepare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p612ui.widget.picker.C40908b;
import com.tencent.p177mm.p612ui.widget.picker.C40908b.C40907a;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.WxaLuckyMoneyBaseUI;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p447ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C43248g;
import com.tencent.p177mm.plugin.luckymoney.appbrand.p988a.C43249h.C12408a;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C12472g;
import com.tencent.p177mm.plugin.luckymoney.p449ui.C43281b;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyNumInputView;
import com.tencent.p177mm.plugin.luckymoney.p449ui.LuckyMoneyTextInputView;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.MMScrollView;
import com.tencent.view.C31128d;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI */
public class WxaLuckyMoneyPrepareUI extends WxaLuckyMoneyBaseUI implements C39309c, C12472g {
    private TextView kGm = null;
    private TextView kGq;
    protected MyKeyboardWindow mKeyboard;
    private C12408a nSv = C12408a.RANDOM_LUCK;
    private C21193a nTc = null;
    private LuckyMoneyNumInputView nTd = null;
    private WxaLuckyMoneyMoneyInputView nTe = null;
    private LuckyMoneyTextInputView nTf = null;
    private Button nTg = null;
    private LinearLayout nTh;
    protected View nTi;
    private TextView nTj;
    private MMScrollView nTk;
    private TextView nTl;
    private int nTm = 0;
    private C43281b nTn = new C43281b();

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI$13 */
    class C336413 implements OnMenuItemClickListener {
        C336413() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42068);
            C36391e.m60016n(WxaLuckyMoneyPrepareUI.this.mController.ylL, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
            AppMethodBeat.m2505o(42068);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI$9 */
    class C33689 implements OnClickListener {
        C33689() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42064);
            WxaLuckyMoneyPrepareUI.this.aoB();
            AppMethodBeat.m2505o(42064);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI$12 */
    class C1241112 implements OnTouchListener {
        C1241112() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(42067);
            if (motionEvent.getAction() == 0) {
                WxaLuckyMoneyPrepareUI.this.aoB();
                WxaLuckyMoneyPrepareUI.this.aqX();
            }
            AppMethodBeat.m2505o(42067);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI$1 */
    class C284011 implements DialogInterface.OnClickListener {
        C284011() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(42053);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(42053);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI$17 */
    class C3442717 implements TextWatcher {
        C3442717() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(42073);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 3) {
                editable.delete(indexOf + 3, length);
                AppMethodBeat.m2505o(42073);
            } else if (indexOf > 6) {
                editable.delete(6, indexOf);
                AppMethodBeat.m2505o(42073);
            } else {
                if (indexOf == -1 && length > 6) {
                    editable.delete(6, length);
                }
                AppMethodBeat.m2505o(42073);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI$10 */
    class C3930610 implements OnMenuItemClickListener {
        C3930610() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42065);
            WxaLuckyMoneyPrepareUI.this.setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
            WxaLuckyMoneyPrepareUI.this.finish();
            AppMethodBeat.m2505o(42065);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WxaLuckyMoneyPrepareUI() {
        AppMethodBeat.m2504i(42074);
        AppMethodBeat.m2505o(42074);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42075);
        super.onCreate(bundle);
        initView();
        this.nTc = new C34430d();
        this.nTc.mo24262a(this, getIntent());
        AppMethodBeat.m2505o(42075);
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void bKV() {
    }

    public final void initView() {
        AppMethodBeat.m2504i(42077);
        setBackBtn(new C3930610());
        this.nTf = (LuckyMoneyTextInputView) findViewById(2131825621);
        this.nTf.setHintText(getString(C25738R.string.cqe));
        final String stringExtra = getIntent().getStringExtra("defaultWishingWord");
        C4990ab.m7417i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", stringExtra);
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.nTf.setHintText(stringExtra);
        }
        this.nTg = (Button) findViewById(2131825630);
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        this.kGq = (TextView) findViewById(2131825618);
        this.nTd = (LuckyMoneyNumInputView) findViewById(2131825619);
        this.nTe = (WxaLuckyMoneyMoneyInputView) findViewById(2131825617);
        this.kGm = (TextView) findViewById(2131825629);
        this.nTk = (MMScrollView) findViewById(2131825615);
        this.nTl = (TextView) findViewById(2131825616);
        this.nTh = (LinearLayout) findViewById(2131829235);
        this.nTj = (TextView) findViewById(2131829237);
        setMMTitle((int) C25738R.string.ctl);
        if (this.nSv == C12408a.RANDOM_LUCK) {
            this.nTe.setTitle(getString(C25738R.string.cto));
            this.nTe.setShowGroupIcon(true);
        } else {
            this.nTe.setTitle(getString(C25738R.string.ctp));
            this.nTe.setShowGroupIcon(false);
        }
        this.nTe.setOnInputValidChangerListener(this);
        this.nTe.setHint(getString(C25738R.string.crl));
        this.nTd.setOnInputValidChangerListener(this);
        this.nTd.setHint(getString(C25738R.string.cs1));
        this.nTd.setNum("");
        this.nTf.setOnInputValidChangerListener(this);
        bKZ();
        m76920a(C43248g.nRN);
        this.nTe.setMaxLen(12);
        bKX();
        this.nTg.setClickable(false);
        this.nTg.setEnabled(false);
        this.nTg.setOnClickListener(new C24019s() {
            public final void bgW() {
                AppMethodBeat.m2504i(42066);
                if (WxaLuckyMoneyPrepareUI.this.nTc == null) {
                    C4990ab.m7412e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
                    AppMethodBeat.m2505o(42066);
                } else if (WxaLuckyMoneyPrepareUI.this.nTe.bKW() != 0) {
                    C23639t.makeText(WxaLuckyMoneyPrepareUI.this.mController.ylL, C25738R.string.f9y, 0).show();
                    AppMethodBeat.m2505o(42066);
                } else {
                    int input = WxaLuckyMoneyPrepareUI.this.nTd.getInput();
                    double input2 = WxaLuckyMoneyPrepareUI.this.nTe.getInput();
                    String input3 = WxaLuckyMoneyPrepareUI.this.nTf.getInput();
                    if (C5046bo.isNullOrNil(input3)) {
                        if (C5046bo.isNullOrNil(stringExtra)) {
                            input3 = WxaLuckyMoneyPrepareUI.this.getString(C25738R.string.cqe);
                        } else {
                            input3 = stringExtra;
                        }
                    }
                    if (WxaLuckyMoneyPrepareUI.this.nSv == C12408a.RANDOM_LUCK) {
                        WxaLuckyMoneyPrepareUI.this.nTc.mo36568c((int) C36391e.m59973H(input2), input, input3, WxaLuckyMoneyPrepareUI.this.nTm);
                        AppMethodBeat.m2505o(42066);
                        return;
                    }
                    if (WxaLuckyMoneyPrepareUI.this.nSv == C12408a.FIX_NORMAL) {
                        WxaLuckyMoneyPrepareUI.this.nTc.mo36569d((int) C36391e.m59973H(input2), input, input3, WxaLuckyMoneyPrepareUI.this.nTm);
                    }
                    AppMethodBeat.m2505o(42066);
                }
            }
        });
        this.nTn.mo68830a(this.nTd);
        this.nTn.mo68830a(this.nTe);
        this.nTn.mo68830a(this.nTf);
        this.nTn.mo68834i((TextView) findViewById(2131825639));
        if (this.nTk != null) {
            this.nTk.setOnTouchListener(new C1241112());
        }
        this.nTe.setType(this.nSv);
        addIconOptionMenu(0, C25738R.drawable.f6835sc, new C336413());
        bKY();
        AppMethodBeat.m2505o(42077);
    }

    /* renamed from: a */
    private void m76920a(C43248g c43248g) {
        AppMethodBeat.m2504i(42078);
        if (this.nSv == C12408a.RANDOM_LUCK) {
            this.nTe.setMaxAmount(c43248g.nRR);
        } else {
            this.nTe.setMaxAmount(c43248g.nRP);
        }
        this.nTe.setMinAmount(c43248g.nRQ);
        this.nTd.setMaxNum(c43248g.nRO);
        C12408a c12408a = C12408a.RANDOM_LUCK;
        this.nTd.setMinNum(1);
        AppMethodBeat.m2505o(42078);
    }

    private void bKX() {
        AppMethodBeat.m2504i(42079);
        String string = getString(C25738R.string.cqu);
        String string2 = getString(C25738R.string.cr9);
        String string3 = getString(C25738R.string.cqo);
        String string4 = getString(C25738R.string.cr_);
        C46373j c46373j = new C46373j(this);
        final SpannableString spannableString = new SpannableString(string + string2);
        spannableString.setSpan(c46373j, string.length(), string.length() + string2.length(), 33);
        final SpannableString spannableString2 = new SpannableString(string3 + string4);
        C46373j c46373j2 = new C46373j(this);
        spannableString2.setSpan(c46373j2, string3.length(), string3.length() + string4.length(), 33);
        c46373j.tHw = new C29672a() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(42069);
                int input = WxaLuckyMoneyPrepareUI.this.nTd.getInput();
                double input2 = WxaLuckyMoneyPrepareUI.this.nTe.getInput();
                WxaLuckyMoneyPrepareUI.this.nSv = C12408a.FIX_NORMAL;
                WxaLuckyMoneyPrepareUI.this.nTe.setType(WxaLuckyMoneyPrepareUI.this.nSv);
                WxaLuckyMoneyPrepareUI.this.nTe.setShowGroupIcon(false);
                WxaLuckyMoneyPrepareUI.this.nTe.setTitle(WxaLuckyMoneyPrepareUI.this.getString(C25738R.string.ctp));
                if (input2 > 0.0d && input > 0) {
                    WxaLuckyMoneyPrepareUI.this.nTe.setAmount(C36391e.m59971F(input2 / ((double) input)));
                }
                WxaLuckyMoneyPrepareUI.this.nTe.setMaxAmount(C43248g.nRN.nRP);
                WxaLuckyMoneyPrepareUI.this.kGq.setText(spannableString2);
                AppMethodBeat.m2505o(42069);
            }
        };
        c46373j2.tHw = new C29672a() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(42070);
                int input = WxaLuckyMoneyPrepareUI.this.nTd.getInput();
                double input2 = WxaLuckyMoneyPrepareUI.this.nTe.getInput();
                WxaLuckyMoneyPrepareUI.this.nSv = C12408a.RANDOM_LUCK;
                WxaLuckyMoneyPrepareUI.this.nTe.setType(WxaLuckyMoneyPrepareUI.this.nSv);
                WxaLuckyMoneyPrepareUI.this.nTe.setMaxAmount(C43248g.nRN.nRR);
                WxaLuckyMoneyPrepareUI.this.nTe.setTitle(WxaLuckyMoneyPrepareUI.this.getString(C25738R.string.cto));
                WxaLuckyMoneyPrepareUI.this.nTe.setShowGroupIcon(true);
                if (input2 > 0.0d && input > 0) {
                    WxaLuckyMoneyPrepareUI.this.nTe.setAmount(C36391e.m59971F(input2 * ((double) input)));
                }
                WxaLuckyMoneyPrepareUI.this.kGq.setText(spannableString);
                AppMethodBeat.m2505o(42070);
            }
        };
        this.kGq.setMovementMethod(LinkMovementMethod.getInstance());
        this.kGq.setText(spannableString);
        this.kGq.setVisibility(0);
        AppMethodBeat.m2505o(42079);
    }

    private void bKY() {
        AppMethodBeat.m2504i(42080);
        int intExtra = getIntent().getIntExtra("range", 0);
        C4990ab.m7417i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", Integer.valueOf(intExtra));
        this.nTh.setVisibility(8);
        if (intExtra == 0) {
            this.nTm = 0;
            AppMethodBeat.m2505o(42080);
        } else if (intExtra == 1) {
            this.nTm = 1;
            AppMethodBeat.m2505o(42080);
        } else {
            final ArrayList arrayList = new ArrayList();
            arrayList.add(getString(C25738R.string.g3a));
            arrayList.add(getString(C25738R.string.g3b));
            this.nTh.setVisibility(0);
            this.nTj.setText((CharSequence) arrayList.get(this.nTm));
            this.nTh.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42072);
                    final C40908b c40908b = new C40908b(WxaLuckyMoneyPrepareUI.this.mController.ylL, arrayList);
                    c40908b.mo64522Qq(WxaLuckyMoneyPrepareUI.this.nTm);
                    c40908b.zSq = new C40907a() {
                        /* renamed from: d */
                        public final void mo7219d(boolean z, Object obj) {
                            AppMethodBeat.m2504i(42071);
                            c40908b.hide();
                            if (z) {
                                WxaLuckyMoneyPrepareUI.this.nTj.setText((CharSequence) obj);
                            }
                            WxaLuckyMoneyPrepareUI.this.nTm = c40908b.dLl();
                            AppMethodBeat.m2505o(42071);
                        }
                    };
                    c40908b.mo64521Qp(C1338a.fromDPToPix(WxaLuckyMoneyPrepareUI.this.mController.ylL, C31128d.MIC_PTU_YOUJIALI));
                    c40908b.show();
                    AppMethodBeat.m2505o(42072);
                }
            });
            AppMethodBeat.m2505o(42080);
        }
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(42081);
        setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        finish();
        AppMethodBeat.m2505o(42081);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(42082);
        super.onDestroy();
        this.nTn.clear();
        if (this.nTc != null) {
            this.nTc.onDestroy();
        }
        AppMethodBeat.m2505o(42082);
    }

    private void bKZ() {
        AppMethodBeat.m2504i(42083);
        final EditText editText = (EditText) this.nTe.findViewById(2131825536);
        final EditText editText2 = (EditText) this.nTd.findViewById(2131825536);
        C36391e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new C3442717());
        editText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(42054);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.mo68771V(WxaLuckyMoneyPrepareUI.this.nTe, 2);
                WxaLuckyMoneyPrepareUI.this.mo68771V(WxaLuckyMoneyPrepareUI.this.nTd, 0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                AppMethodBeat.m2505o(42054);
            }
        });
        editText.requestFocus();
        TextView textView = (TextView) this.nTe.findViewById(2131825537);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42055);
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    WxaLuckyMoneyPrepareUI.this.mo68771V(WxaLuckyMoneyPrepareUI.this.nTe, 2);
                    WxaLuckyMoneyPrepareUI.this.mo68771V(WxaLuckyMoneyPrepareUI.this.nTd, 0);
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                    AppMethodBeat.m2505o(42055);
                }
            });
        }
        C36391e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(42056);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.mo68771V(WxaLuckyMoneyPrepareUI.this.nTe, 2);
                WxaLuckyMoneyPrepareUI.this.mo68771V(WxaLuckyMoneyPrepareUI.this.nTd, 0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                AppMethodBeat.m2505o(42056);
            }
        });
        ((MMEditText) this.nTf.findViewById(2131825665)).setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.m2504i(42057);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.mo68771V(WxaLuckyMoneyPrepareUI.this.nTe, 2);
                WxaLuckyMoneyPrepareUI.this.mo68771V(WxaLuckyMoneyPrepareUI.this.nTd, 0);
                AppMethodBeat.m2505o(42057);
            }
        });
        AppMethodBeat.m2505o(42083);
    }

    public final int getLayoutId() {
        return 2130971245;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: V */
    public final void mo68771V(final View view, final int i) {
        AppMethodBeat.m2504i(42084);
        this.mKeyboard = (MyKeyboardWindow) findViewById(2131822357);
        this.nTi = findViewById(2131822356);
        View findViewById = findViewById(2131822358);
        final EditText editText = (EditText) view.findViewById(2131825536);
        if (this.mKeyboard == null || editText == null || this.nTi == null) {
            AppMethodBeat.m2505o(42084);
            return;
        }
        C36391e.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            final /* synthetic */ boolean gnT = false;

            /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI$6$2 */
            class C33672 implements Runnable {
                C33672() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(42059);
                    WxaLuckyMoneyPrepareUI.this.aoB();
                    ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    AppMethodBeat.m2505o(42059);
                }
            }

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.m2504i(42060);
                if (!view.isFocused() || this.gnT) {
                    new C7306ak().postDelayed(new C33672(), 200);
                    AppMethodBeat.m2505o(42060);
                    return;
                }
                ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new C7306ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(42058);
                        if (!WxaLuckyMoneyPrepareUI.this.nTi.isShown() && view.isShown()) {
                            WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                        }
                        WxaLuckyMoneyPrepareUI.m76922b(WxaLuckyMoneyPrepareUI.this, i);
                        WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.m2505o(42058);
                    }
                }, 300);
                AppMethodBeat.m2505o(42060);
            }
        });
        editText.setOnClickListener(new OnClickListener() {
            final /* synthetic */ boolean gnT = false;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(42061);
                if (WxaLuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                    if (this.gnT) {
                        WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(8);
                        ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    AppMethodBeat.m2505o(42061);
                    return;
                }
                WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                WxaLuckyMoneyPrepareUI.m76922b(WxaLuckyMoneyPrepareUI.this, i);
                AppMethodBeat.m2505o(42061);
            }
        });
        TextView textView = (TextView) view.findViewById(2131825537);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                final /* synthetic */ boolean gnT = false;

                /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI$8$1 */
                class C211921 implements Runnable {
                    C211921() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(42062);
                        WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                        view.requestFocus();
                        if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
                            WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                        }
                        WxaLuckyMoneyPrepareUI.m76922b(WxaLuckyMoneyPrepareUI.this, i);
                        AppMethodBeat.m2505o(42062);
                    }
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(42063);
                    if (!WxaLuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                        if (!WxaLuckyMoneyPrepareUI.this.nTi.isShown() && !this.gnT) {
                            ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            new C7306ak().postDelayed(new C211921(), 200);
                            AppMethodBeat.m2505o(42063);
                            return;
                        } else if (this.gnT) {
                            WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(8);
                            ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                    } else if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
                        WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                        AppMethodBeat.m2505o(42063);
                        return;
                    }
                    AppMethodBeat.m2505o(42063);
                }
            });
        }
        findViewById.setOnClickListener(new C33689());
        AppMethodBeat.m2505o(42084);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(42085);
        if (i == 4 && this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
            AppMethodBeat.m2505o(42085);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(42085);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aoB() {
        AppMethodBeat.m2504i(42086);
        if (this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
        }
        AppMethodBeat.m2505o(42086);
    }

    public final void bLa() {
        AppMethodBeat.m2504i(42087);
        double d = 0.0d;
        double d2 = 0.0d;
        if (!(this.nTe.bKW() == 3 || this.nTd.bKW() == 3)) {
            int input = this.nTd.getInput();
            d = this.nTe.getInput();
            if (this.nSv == C12408a.FIX_NORMAL) {
                d *= (double) input;
                d2 = this.nTe.getInput();
            } else if (input > 0) {
                d2 = this.nTe.getInput() / ((double) input);
            }
        }
        boolean bMy = this.nTn.bMy();
        C43248g c43248g = C43248g.nRN;
        if (bMy) {
            C4990ab.m7416i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
            this.nTg.setClickable(false);
            this.nTg.setEnabled(false);
        } else {
            bMy = false;
            if (d == 0.0d || d2 == 0.0d) {
                bMy = true;
            } else if (d > c43248g.nRR && c43248g.nRR > 0.0d) {
                this.nTn.mo68829Dv(getString(C25738R.string.ctn, new Object[]{Math.round(c43248g.nRR), C5046bo.m7532bc(c43248g.nRU, "")}));
                bMy = true;
            } else if (d2 > 0.0d) {
                C4990ab.m7416i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
                if (this.nSv == C12408a.FIX_NORMAL) {
                    if (d2 > c43248g.nRP && c43248g.nRP > 0.0d) {
                        this.nTn.mo68829Dv(getString(C25738R.string.csb, new Object[]{Math.round(c43248g.nRP), C5046bo.m7532bc(c43248g.nRU, "")}));
                        bMy = true;
                    }
                } else if (d2 > c43248g.nRS && c43248g.nRS > 0.0d) {
                    this.nTn.mo68829Dv(getString(C25738R.string.csb, new Object[]{Math.round(c43248g.nRS), C5046bo.m7532bc(c43248g.nRU, "")}));
                    bMy = true;
                    this.nTd.onError();
                    this.nTe.onError();
                }
                C4990ab.m7416i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bMy + " for max value");
                if (!bMy) {
                    if (this.nSv == C12408a.FIX_NORMAL) {
                        if (d2 < c43248g.nRQ) {
                            this.nTn.mo68829Dv(getString(C25738R.string.csd, new Object[]{C36391e.m59971F(c43248g.nRQ), C5046bo.m7532bc(c43248g.nRU, "")}));
                            bMy = true;
                        }
                    } else if (d2 < 0.01d) {
                        this.nTn.mo68829Dv(getString(C25738R.string.csd, new Object[]{"0.01", C5046bo.m7532bc(c43248g.nRU, "")}));
                        bMy = true;
                        this.nTd.onError();
                        this.nTe.onError();
                    }
                }
                C4990ab.m7416i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bMy + " for min value");
            }
            if (bMy) {
                this.nTg.setClickable(false);
                this.nTg.setEnabled(false);
            } else {
                this.nTg.setClickable(true);
                this.nTg.setEnabled(true);
            }
        }
        String str = c43248g.nRT;
        if (C5046bo.isNullOrNil(str)) {
            this.kGm.setText(C36391e.m59972G(d));
            AppMethodBeat.m2505o(42087);
            return;
        }
        this.kGm.setText(str + C36391e.m59971F(d));
        AppMethodBeat.m2505o(42087);
    }

    /* renamed from: Qf */
    public final void mo24264Qf(String str) {
        AppMethodBeat.m2504i(42076);
        if (TextUtils.isEmpty(str)) {
            str = getString(C25738R.string.fu2);
        }
        C30379h.m48448a((Context) this, str, null, false, new C284011());
        AppMethodBeat.m2505o(42076);
    }

    /* renamed from: b */
    static /* synthetic */ void m76922b(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, int i) {
        AppMethodBeat.m2504i(42088);
        wxaLuckyMoneyPrepareUI.mKeyboard.setXMode(i);
        AppMethodBeat.m2505o(42088);
    }
}
