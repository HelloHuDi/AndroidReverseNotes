package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.appbrand.a.h;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.b;
import com.tencent.mm.plugin.luckymoney.ui.g;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.view.d;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.ArrayList;

@a(19)
public class WxaLuckyMoneyPrepareUI extends WxaLuckyMoneyBaseUI implements c, g {
    private TextView kGm = null;
    private TextView kGq;
    protected MyKeyboardWindow mKeyboard;
    private h.a nSv = h.a.RANDOM_LUCK;
    private a nTc = null;
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
    private b nTn = new b();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WxaLuckyMoneyPrepareUI() {
        AppMethodBeat.i(42074);
        AppMethodBeat.o(42074);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42075);
        super.onCreate(bundle);
        initView();
        this.nTc = new d();
        this.nTc.a(this, getIntent());
        AppMethodBeat.o(42075);
    }

    public final MMActivity bKU() {
        return this;
    }

    public final void bKV() {
    }

    public final void initView() {
        AppMethodBeat.i(42077);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42065);
                WxaLuckyMoneyPrepareUI.this.setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
                WxaLuckyMoneyPrepareUI.this.finish();
                AppMethodBeat.o(42065);
                return true;
            }
        });
        this.nTf = (LuckyMoneyTextInputView) findViewById(R.id.cz9);
        this.nTf.setHintText(getString(R.string.cqe));
        final String stringExtra = getIntent().getStringExtra("defaultWishingWord");
        ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initView defaultWishingWord = %s", stringExtra);
        if (!bo.isNullOrNil(stringExtra)) {
            this.nTf.setHintText(stringExtra);
        }
        this.nTg = (Button) findViewById(R.id.czh);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        this.kGq = (TextView) findViewById(R.id.cz6);
        this.nTd = (LuckyMoneyNumInputView) findViewById(R.id.cz7);
        this.nTe = (WxaLuckyMoneyMoneyInputView) findViewById(R.id.cz5);
        this.kGm = (TextView) findViewById(R.id.czg);
        this.nTk = (MMScrollView) findViewById(R.id.cz3);
        this.nTl = (TextView) findViewById(R.id.cz4);
        this.nTh = (LinearLayout) findViewById(R.id.flx);
        this.nTj = (TextView) findViewById(R.id.flz);
        setMMTitle((int) R.string.ctl);
        if (this.nSv == h.a.RANDOM_LUCK) {
            this.nTe.setTitle(getString(R.string.cto));
            this.nTe.setShowGroupIcon(true);
        } else {
            this.nTe.setTitle(getString(R.string.ctp));
            this.nTe.setShowGroupIcon(false);
        }
        this.nTe.setOnInputValidChangerListener(this);
        this.nTe.setHint(getString(R.string.crl));
        this.nTd.setOnInputValidChangerListener(this);
        this.nTd.setHint(getString(R.string.cs1));
        this.nTd.setNum("");
        this.nTf.setOnInputValidChangerListener(this);
        bKZ();
        a(com.tencent.mm.plugin.luckymoney.appbrand.a.g.nRN);
        this.nTe.setMaxLen(12);
        bKX();
        this.nTg.setClickable(false);
        this.nTg.setEnabled(false);
        this.nTg.setOnClickListener(new s() {
            public final void bgW() {
                AppMethodBeat.i(42066);
                if (WxaLuckyMoneyPrepareUI.this.nTc == null) {
                    ab.e("MicroMsg.WxaLuckyMoneyPrepareUI", "Click PrepareBtn but, mLogic == null");
                    AppMethodBeat.o(42066);
                } else if (WxaLuckyMoneyPrepareUI.this.nTe.bKW() != 0) {
                    t.makeText(WxaLuckyMoneyPrepareUI.this.mController.ylL, R.string.f9y, 0).show();
                    AppMethodBeat.o(42066);
                } else {
                    int input = WxaLuckyMoneyPrepareUI.this.nTd.getInput();
                    double input2 = WxaLuckyMoneyPrepareUI.this.nTe.getInput();
                    String input3 = WxaLuckyMoneyPrepareUI.this.nTf.getInput();
                    if (bo.isNullOrNil(input3)) {
                        if (bo.isNullOrNil(stringExtra)) {
                            input3 = WxaLuckyMoneyPrepareUI.this.getString(R.string.cqe);
                        } else {
                            input3 = stringExtra;
                        }
                    }
                    if (WxaLuckyMoneyPrepareUI.this.nSv == h.a.RANDOM_LUCK) {
                        WxaLuckyMoneyPrepareUI.this.nTc.c((int) e.H(input2), input, input3, WxaLuckyMoneyPrepareUI.this.nTm);
                        AppMethodBeat.o(42066);
                        return;
                    }
                    if (WxaLuckyMoneyPrepareUI.this.nSv == h.a.FIX_NORMAL) {
                        WxaLuckyMoneyPrepareUI.this.nTc.d((int) e.H(input2), input, input3, WxaLuckyMoneyPrepareUI.this.nTm);
                    }
                    AppMethodBeat.o(42066);
                }
            }
        });
        this.nTn.a(this.nTd);
        this.nTn.a(this.nTe);
        this.nTn.a(this.nTf);
        this.nTn.i((TextView) findViewById(R.id.czq));
        if (this.nTk != null) {
            this.nTk.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(42067);
                    if (motionEvent.getAction() == 0) {
                        WxaLuckyMoneyPrepareUI.this.aoB();
                        WxaLuckyMoneyPrepareUI.this.aqX();
                    }
                    AppMethodBeat.o(42067);
                    return false;
                }
            });
        }
        this.nTe.setType(this.nSv);
        addIconOptionMenu(0, R.drawable.sc, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42068);
                e.n(WxaLuckyMoneyPrepareUI.this.mController.ylL, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
                AppMethodBeat.o(42068);
                return true;
            }
        });
        bKY();
        AppMethodBeat.o(42077);
    }

    private void a(com.tencent.mm.plugin.luckymoney.appbrand.a.g gVar) {
        AppMethodBeat.i(42078);
        if (this.nSv == h.a.RANDOM_LUCK) {
            this.nTe.setMaxAmount(gVar.nRR);
        } else {
            this.nTe.setMaxAmount(gVar.nRP);
        }
        this.nTe.setMinAmount(gVar.nRQ);
        this.nTd.setMaxNum(gVar.nRO);
        h.a aVar = h.a.RANDOM_LUCK;
        this.nTd.setMinNum(1);
        AppMethodBeat.o(42078);
    }

    private void bKX() {
        AppMethodBeat.i(42079);
        String string = getString(R.string.cqu);
        String string2 = getString(R.string.cr9);
        String string3 = getString(R.string.cqo);
        String string4 = getString(R.string.cr_);
        j jVar = new j(this);
        final SpannableString spannableString = new SpannableString(string + string2);
        spannableString.setSpan(jVar, string.length(), string.length() + string2.length(), 33);
        final SpannableString spannableString2 = new SpannableString(string3 + string4);
        j jVar2 = new j(this);
        spannableString2.setSpan(jVar2, string3.length(), string3.length() + string4.length(), 33);
        jVar.tHw = new j.a() {
            public final void onClick(View view) {
                AppMethodBeat.i(42069);
                int input = WxaLuckyMoneyPrepareUI.this.nTd.getInput();
                double input2 = WxaLuckyMoneyPrepareUI.this.nTe.getInput();
                WxaLuckyMoneyPrepareUI.this.nSv = h.a.FIX_NORMAL;
                WxaLuckyMoneyPrepareUI.this.nTe.setType(WxaLuckyMoneyPrepareUI.this.nSv);
                WxaLuckyMoneyPrepareUI.this.nTe.setShowGroupIcon(false);
                WxaLuckyMoneyPrepareUI.this.nTe.setTitle(WxaLuckyMoneyPrepareUI.this.getString(R.string.ctp));
                if (input2 > 0.0d && input > 0) {
                    WxaLuckyMoneyPrepareUI.this.nTe.setAmount(e.F(input2 / ((double) input)));
                }
                WxaLuckyMoneyPrepareUI.this.nTe.setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.nRN.nRP);
                WxaLuckyMoneyPrepareUI.this.kGq.setText(spannableString2);
                AppMethodBeat.o(42069);
            }
        };
        jVar2.tHw = new j.a() {
            public final void onClick(View view) {
                AppMethodBeat.i(42070);
                int input = WxaLuckyMoneyPrepareUI.this.nTd.getInput();
                double input2 = WxaLuckyMoneyPrepareUI.this.nTe.getInput();
                WxaLuckyMoneyPrepareUI.this.nSv = h.a.RANDOM_LUCK;
                WxaLuckyMoneyPrepareUI.this.nTe.setType(WxaLuckyMoneyPrepareUI.this.nSv);
                WxaLuckyMoneyPrepareUI.this.nTe.setMaxAmount(com.tencent.mm.plugin.luckymoney.appbrand.a.g.nRN.nRR);
                WxaLuckyMoneyPrepareUI.this.nTe.setTitle(WxaLuckyMoneyPrepareUI.this.getString(R.string.cto));
                WxaLuckyMoneyPrepareUI.this.nTe.setShowGroupIcon(true);
                if (input2 > 0.0d && input > 0) {
                    WxaLuckyMoneyPrepareUI.this.nTe.setAmount(e.F(input2 * ((double) input)));
                }
                WxaLuckyMoneyPrepareUI.this.kGq.setText(spannableString);
                AppMethodBeat.o(42070);
            }
        };
        this.kGq.setMovementMethod(LinkMovementMethod.getInstance());
        this.kGq.setText(spannableString);
        this.kGq.setVisibility(0);
        AppMethodBeat.o(42079);
    }

    private void bKY() {
        AppMethodBeat.i(42080);
        int intExtra = getIntent().getIntExtra("range", 0);
        ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "initRange range = %d", Integer.valueOf(intExtra));
        this.nTh.setVisibility(8);
        if (intExtra == 0) {
            this.nTm = 0;
            AppMethodBeat.o(42080);
        } else if (intExtra == 1) {
            this.nTm = 1;
            AppMethodBeat.o(42080);
        } else {
            final ArrayList arrayList = new ArrayList();
            arrayList.add(getString(R.string.g3a));
            arrayList.add(getString(R.string.g3b));
            this.nTh.setVisibility(0);
            this.nTj.setText((CharSequence) arrayList.get(this.nTm));
            this.nTh.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42072);
                    final com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(WxaLuckyMoneyPrepareUI.this.mController.ylL, arrayList);
                    bVar.Qq(WxaLuckyMoneyPrepareUI.this.nTm);
                    bVar.zSq = new com.tencent.mm.ui.widget.picker.b.a() {
                        public final void d(boolean z, Object obj) {
                            AppMethodBeat.i(42071);
                            bVar.hide();
                            if (z) {
                                WxaLuckyMoneyPrepareUI.this.nTj.setText((CharSequence) obj);
                            }
                            WxaLuckyMoneyPrepareUI.this.nTm = bVar.dLl();
                            AppMethodBeat.o(42071);
                        }
                    };
                    bVar.Qp(com.tencent.mm.bz.a.fromDPToPix(WxaLuckyMoneyPrepareUI.this.mController.ylL, d.MIC_PTU_YOUJIALI));
                    bVar.show();
                    AppMethodBeat.o(42072);
                }
            });
            AppMethodBeat.o(42080);
        }
    }

    public void onBackPressed() {
        AppMethodBeat.i(42081);
        setResult(0, new Intent().putExtra("result_error_code", -1).putExtra("result_error_msg", "fail:system error {{user cancel}}"));
        finish();
        AppMethodBeat.o(42081);
    }

    public void onDestroy() {
        AppMethodBeat.i(42082);
        super.onDestroy();
        this.nTn.clear();
        if (this.nTc != null) {
            this.nTc.onDestroy();
        }
        AppMethodBeat.o(42082);
    }

    private void bKZ() {
        AppMethodBeat.i(42083);
        final EditText editText = (EditText) this.nTe.findViewById(R.id.cwy);
        final EditText editText2 = (EditText) this.nTd.findViewById(R.id.cwy);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(42073);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                    AppMethodBeat.o(42073);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                    AppMethodBeat.o(42073);
                } else {
                    if (indexOf == -1 && length > 6) {
                        editable.delete(6, length);
                    }
                    AppMethodBeat.o(42073);
                }
            }
        });
        editText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42054);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.V(WxaLuckyMoneyPrepareUI.this.nTe, 2);
                WxaLuckyMoneyPrepareUI.this.V(WxaLuckyMoneyPrepareUI.this.nTd, 0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                AppMethodBeat.o(42054);
            }
        });
        editText.requestFocus();
        TextView textView = (TextView) this.nTe.findViewById(R.id.cwz);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(42055);
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    WxaLuckyMoneyPrepareUI.this.V(WxaLuckyMoneyPrepareUI.this.nTe, 2);
                    WxaLuckyMoneyPrepareUI.this.V(WxaLuckyMoneyPrepareUI.this.nTd, 0);
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(2);
                    WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                    WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                    AppMethodBeat.o(42055);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.ylL.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42056);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.V(WxaLuckyMoneyPrepareUI.this.nTe, 2);
                WxaLuckyMoneyPrepareUI.this.V(WxaLuckyMoneyPrepareUI.this.nTd, 0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setXMode(0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                AppMethodBeat.o(42056);
            }
        });
        ((MMEditText) this.nTf.findViewById(R.id.d0f)).setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                AppMethodBeat.i(42057);
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                WxaLuckyMoneyPrepareUI.this.V(WxaLuckyMoneyPrepareUI.this.nTe, 2);
                WxaLuckyMoneyPrepareUI.this.V(WxaLuckyMoneyPrepareUI.this.nTd, 0);
                AppMethodBeat.o(42057);
            }
        });
        AppMethodBeat.o(42083);
    }

    public final int getLayoutId() {
        return R.layout.b88;
    }

    /* Access modifiers changed, original: protected|final */
    public final void V(final View view, final int i) {
        AppMethodBeat.i(42084);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.id.akz);
        this.nTi = findViewById(R.id.aky);
        View findViewById = findViewById(R.id.al0);
        final EditText editText = (EditText) view.findViewById(R.id.cwy);
        if (this.mKeyboard == null || editText == null || this.nTi == null) {
            AppMethodBeat.o(42084);
            return;
        }
        e.setNoSystemInputOnEditText(editText);
        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            final /* synthetic */ boolean gnT = false;

            public final void onFocusChange(final View view, boolean z) {
                AppMethodBeat.i(42060);
                if (!view.isFocused() || this.gnT) {
                    new ak().postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(42059);
                            WxaLuckyMoneyPrepareUI.this.aoB();
                            ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                            AppMethodBeat.o(42059);
                        }
                    }, 200);
                    AppMethodBeat.o(42060);
                    return;
                }
                ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                new ak().postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(42058);
                        if (!WxaLuckyMoneyPrepareUI.this.nTi.isShown() && view.isShown()) {
                            WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                        }
                        WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, i);
                        WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                        ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                        AppMethodBeat.o(42058);
                    }
                }, 300);
                AppMethodBeat.o(42060);
            }
        });
        editText.setOnClickListener(new OnClickListener() {
            final /* synthetic */ boolean gnT = false;

            public final void onClick(View view) {
                AppMethodBeat.i(42061);
                if (WxaLuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                    if (this.gnT) {
                        WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(8);
                        ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                    }
                    AppMethodBeat.o(42061);
                    return;
                }
                WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText((EditText) view);
                WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, i);
                AppMethodBeat.o(42061);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.cwz);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener() {
                final /* synthetic */ boolean gnT = false;

                public final void onClick(View view) {
                    AppMethodBeat.i(42063);
                    if (!WxaLuckyMoneyPrepareUI.this.nTi.isShown() || this.gnT) {
                        if (!WxaLuckyMoneyPrepareUI.this.nTi.isShown() && !this.gnT) {
                            ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                            new ak().postDelayed(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(42062);
                                    WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(0);
                                    view.requestFocus();
                                    if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
                                        WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                                    }
                                    WxaLuckyMoneyPrepareUI.b(WxaLuckyMoneyPrepareUI.this, i);
                                    AppMethodBeat.o(42062);
                                }
                            }, 200);
                            AppMethodBeat.o(42063);
                            return;
                        } else if (this.gnT) {
                            WxaLuckyMoneyPrepareUI.this.nTi.setVisibility(8);
                            ((InputMethodManager) WxaLuckyMoneyPrepareUI.this.mController.ylL.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                    } else if (WxaLuckyMoneyPrepareUI.this.mKeyboard != null) {
                        WxaLuckyMoneyPrepareUI.this.mKeyboard.setInputEditText(editText);
                        AppMethodBeat.o(42063);
                        return;
                    }
                    AppMethodBeat.o(42063);
                }
            });
        }
        findViewById.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42064);
                WxaLuckyMoneyPrepareUI.this.aoB();
                AppMethodBeat.o(42064);
            }
        });
        AppMethodBeat.o(42084);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(42085);
        if (i == 4 && this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
            AppMethodBeat.o(42085);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(42085);
        return onKeyUp;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aoB() {
        AppMethodBeat.i(42086);
        if (this.nTi != null && this.nTi.isShown()) {
            this.nTi.setVisibility(8);
        }
        AppMethodBeat.o(42086);
    }

    public final void bLa() {
        AppMethodBeat.i(42087);
        double d = 0.0d;
        double d2 = 0.0d;
        if (!(this.nTe.bKW() == 3 || this.nTd.bKW() == 3)) {
            int input = this.nTd.getInput();
            d = this.nTe.getInput();
            if (this.nSv == h.a.FIX_NORMAL) {
                d *= (double) input;
                d2 = this.nTe.getInput();
            } else if (input > 0) {
                d2 = this.nTe.getInput() / ((double) input);
            }
        }
        boolean bMy = this.nTn.bMy();
        com.tencent.mm.plugin.luckymoney.appbrand.a.g gVar = com.tencent.mm.plugin.luckymoney.appbrand.a.g.nRN;
        if (bMy) {
            ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "has error");
            this.nTg.setClickable(false);
            this.nTg.setEnabled(false);
        } else {
            bMy = false;
            if (d == 0.0d || d2 == 0.0d) {
                bMy = true;
            } else if (d > gVar.nRR && gVar.nRR > 0.0d) {
                this.nTn.Dv(getString(R.string.ctn, new Object[]{Math.round(gVar.nRR), bo.bc(gVar.nRU, "")}));
                bMy = true;
            } else if (d2 > 0.0d) {
                ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "perAmount ".concat(String.valueOf(d2)));
                if (this.nSv == h.a.FIX_NORMAL) {
                    if (d2 > gVar.nRP && gVar.nRP > 0.0d) {
                        this.nTn.Dv(getString(R.string.csb, new Object[]{Math.round(gVar.nRP), bo.bc(gVar.nRU, "")}));
                        bMy = true;
                    }
                } else if (d2 > gVar.nRS && gVar.nRS > 0.0d) {
                    this.nTn.Dv(getString(R.string.csb, new Object[]{Math.round(gVar.nRS), bo.bc(gVar.nRU, "")}));
                    bMy = true;
                    this.nTd.onError();
                    this.nTe.onError();
                }
                ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bMy + " for max value");
                if (!bMy) {
                    if (this.nSv == h.a.FIX_NORMAL) {
                        if (d2 < gVar.nRQ) {
                            this.nTn.Dv(getString(R.string.csd, new Object[]{e.F(gVar.nRQ), bo.bc(gVar.nRU, "")}));
                            bMy = true;
                        }
                    } else if (d2 < 0.01d) {
                        this.nTn.Dv(getString(R.string.csd, new Object[]{"0.01", bo.bc(gVar.nRU, "")}));
                        bMy = true;
                        this.nTd.onError();
                        this.nTe.onError();
                    }
                }
                ab.i("MicroMsg.WxaLuckyMoneyPrepareUI", "furtherCheckHasErr:" + bMy + " for min value");
            }
            if (bMy) {
                this.nTg.setClickable(false);
                this.nTg.setEnabled(false);
            } else {
                this.nTg.setClickable(true);
                this.nTg.setEnabled(true);
            }
        }
        String str = gVar.nRT;
        if (bo.isNullOrNil(str)) {
            this.kGm.setText(e.G(d));
            AppMethodBeat.o(42087);
            return;
        }
        this.kGm.setText(str + e.F(d));
        AppMethodBeat.o(42087);
    }

    public final void Qf(String str) {
        AppMethodBeat.i(42076);
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.fu2);
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, null, false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(42053);
                dialogInterface.dismiss();
                AppMethodBeat.o(42053);
            }
        });
        AppMethodBeat.o(42076);
    }

    static /* synthetic */ void b(WxaLuckyMoneyPrepareUI wxaLuckyMoneyPrepareUI, int i) {
        AppMethodBeat.i(42088);
        wxaLuckyMoneyPrepareUI.mKeyboard.setXMode(i);
        AppMethodBeat.o(42088);
    }
}
