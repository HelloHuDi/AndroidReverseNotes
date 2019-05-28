package com.tencent.mm.plugin.appbrand.ui.autofill;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.d;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.lang.reflect.Method;
import java.util.Iterator;

public class AppBrandIDCardVerifyPwdFrag extends MMFragment {
    private LinearLayout eol;
    private MMFormVerifyCodeInputView gCi;
    private TextView hrg;
    a iJN;
    private View iJO;
    private Button iJR;
    private gd iKf;
    private gc iKn;
    private TextView iKo;
    private TextView ixA;
    private com.tencent.mm.ui.a mActionBarHelper;
    private MyKeyboardWindow mKeyboard;

    public void dealContentView(View view) {
        AppMethodBeat.i(133258);
        if (this.iJN == null || this.iJN.aMI() == null) {
            ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            AppMethodBeat.o(133258);
        } else if (this.iJN.aMI().vIf == null || this.iJN.aMI().vIf.size() <= 0) {
            ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sms.get(0) is null, err, return");
            AppMethodBeat.o(133258);
        } else {
            this.eol = (LinearLayout) view.findViewById(R.id.ra);
            this.hrg = (TextView) view.findViewById(R.id.rb);
            this.ixA = (TextView) view.findViewById(R.id.rc);
            this.iKo = (TextView) view.findViewById(R.id.rd);
            this.iJR = (Button) view.findViewById(R.id.r7);
            this.gCi = (MMFormVerifyCodeInputView) view.findViewById(R.id.re);
            this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.rf);
            this.iJO = v.hu(getContext()).inflate(R.layout.a_, null);
            this.iJO.setBackgroundColor(getResources().getColor(R.color.vy));
            this.mActionBarHelper = new com.tencent.mm.ui.a(this.iJO);
            this.eol.addView(this.iJO, 0, new LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.de(getActivity())));
            this.iKf = this.iJN.aMI();
            this.mActionBarHelper.setTitle(this.iKf.title);
            this.mActionBarHelper.b(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(133249);
                    if (AppBrandIDCardVerifyPwdFrag.this.iJN != null) {
                        AppBrandIDCardVerifyPwdFrag.this.iJN.back();
                    }
                    AppMethodBeat.o(133249);
                }
            });
            this.hrg.setText(this.iKf.desc);
            this.iKn = (gc) this.iKf.vIf.get(0);
            this.ixA.setText(((gc) this.iKf.vIf.get(0)).vIe);
            if (this.iKf.vIf.size() > 1) {
                this.iKo.setVisibility(0);
                this.iKo.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(133252);
                        if (AppBrandIDCardVerifyPwdFrag.this.iJN != null) {
                            AppBrandIDCardVerifyPwdFrag.this.iJN.aMG();
                        }
                        d dVar = new d(AppBrandIDCardVerifyPwdFrag.this.getContext(), 1, false);
                        dVar.rBl = new c() {
                            public final void a(l lVar) {
                                AppMethodBeat.i(133250);
                                ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", Integer.valueOf(AppBrandIDCardVerifyPwdFrag.this.iKf.vIf.size()));
                                Iterator it = AppBrandIDCardVerifyPwdFrag.this.iKf.vIf.iterator();
                                while (it.hasNext()) {
                                    gc gcVar = (gc) it.next();
                                    if (bo.isNullOrNil(gcVar.vId) || bo.isNullOrNil(gcVar.vIe)) {
                                        ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
                                    } else {
                                        lVar.e(AppBrandIDCardVerifyPwdFrag.this.iKf.vIf.indexOf(gcVar), gcVar.vIe);
                                    }
                                }
                                AppMethodBeat.o(133250);
                            }
                        };
                        dVar.rBm = new n.d() {
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                AppMethodBeat.i(133251);
                                gc gcVar = (gc) AppBrandIDCardVerifyPwdFrag.this.iKf.vIf.get(menuItem.getItemId());
                                if (gcVar == null) {
                                    ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", Integer.valueOf(menuItem.getItemId()));
                                    AppMethodBeat.o(133251);
                                    return;
                                }
                                ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", Integer.valueOf(menuItem.getItemId()), gcVar.vId, gcVar.vIe, gcVar.pbn);
                                AppBrandIDCardVerifyPwdFrag.this.iKn = gcVar;
                                AppBrandIDCardVerifyPwdFrag.this.ixA.setText(gcVar.vIe);
                                AppMethodBeat.o(133251);
                            }
                        };
                        dVar.cpD();
                        AppMethodBeat.o(133252);
                    }
                });
            } else {
                this.iKo.setVisibility(8);
            }
            this.gCi.setVisibility(0);
            this.gCi.setSendSmsBtnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(133255);
                    h.a(AppBrandIDCardVerifyPwdFrag.this.getContext(), AppBrandIDCardVerifyPwdFrag.this.getString(R.string.jt) + AppBrandIDCardVerifyPwdFrag.this.iKn.vIe, AppBrandIDCardVerifyPwdFrag.this.getString(R.string.jo), AppBrandIDCardVerifyPwdFrag.this.getString(R.string.s6), AppBrandIDCardVerifyPwdFrag.this.getString(R.string.or), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(133253);
                            AppBrandIDCardVerifyPwdFrag.this.gCi.dzH();
                            ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "sendSms click");
                            if (AppBrandIDCardVerifyPwdFrag.this.iJN != null) {
                                AppBrandIDCardVerifyPwdFrag.this.iJN.a(AppBrandIDCardVerifyPwdFrag.this.iKn);
                            }
                            AppMethodBeat.o(133253);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(133254);
                            AppBrandIDCardVerifyPwdFrag.this.gCi.reset();
                            AppMethodBeat.o(133254);
                        }
                    });
                    AppMethodBeat.o(133255);
                }
            });
            this.gCi.addTextChangedListener(new TextWatcher() {
                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(133256);
                    if (AppBrandIDCardVerifyPwdFrag.this.gCi.getText().toString().length() > 0) {
                        AppBrandIDCardVerifyPwdFrag.this.iJR.setEnabled(true);
                        AppMethodBeat.o(133256);
                        return;
                    }
                    AppBrandIDCardVerifyPwdFrag.this.iJR.setEnabled(false);
                    AppMethodBeat.o(133256);
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
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
                        ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, setShowSoftInputOnFocus no such method, api level = %d", Integer.valueOf(VERSION.SDK_INT));
                        try {
                            Method method2 = cls.getMethod("setSoftInputShownOnFocus", new Class[]{Boolean.TYPE});
                            method2.setAccessible(true);
                            method2.invoke(contentEditText, new Object[]{Boolean.FALSE});
                            method2.setAccessible(false);
                        } catch (Exception e2) {
                            ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setSoftInputShownOnFocus], exp = %s", bo.l(e2));
                            if (contentEditText.getContext() != null && (contentEditText.getContext() instanceof MMActivity)) {
                                ((MMActivity) contentEditText.getContext()).hideVKB(contentEditText);
                            }
                        }
                    } catch (Exception e22) {
                        ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "setNoSystemInputOnEditText, reflect method [setShowSoftInputOnFocus], exp = %s", bo.l(e22));
                    }
                }
            }
            if (this.gCi.getText() == null || this.gCi.getText().toString().length() <= 0) {
                this.iJR.setEnabled(false);
            } else {
                this.iJR.setEnabled(true);
            }
            this.iJR.setVisibility(0);
            this.iJR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(133257);
                    ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "verify sms click");
                    if (AppBrandIDCardVerifyPwdFrag.this.iJN != null) {
                        AppBrandIDCardVerifyPwdFrag.this.iJN.a(AppBrandIDCardVerifyPwdFrag.this.gCi.getText().toString(), AppBrandIDCardVerifyPwdFrag.this.iKn);
                    }
                    AppMethodBeat.o(133257);
                }
            });
            this.mKeyboard.setXMode(0);
            this.mKeyboard.setInputEditText(this.gCi.getContentEditText());
            if (VERSION.SDK_INT >= 14) {
                this.mKeyboard.setAccessibilityDelegate(new com.tencent.mm.ui.a.c());
            }
            AppMethodBeat.o(133258);
        }
    }

    public int getLayoutId() {
        return R.layout.cb;
    }

    public void onResume() {
        AppMethodBeat.i(133259);
        super.onResume();
        if (isSupportNavigationSwipeBack()) {
            getContentView().setVisibility(0);
            getSwipeBackLayout().setEnableGesture(true);
        }
        AppMethodBeat.o(133259);
    }

    public boolean noActionBar() {
        return true;
    }

    public void onSwipeBack() {
        AppMethodBeat.i(133260);
        if (this.iJN != null) {
            this.iJN.onSwipeBack();
            getContentView().setVisibility(8);
            if (isSupportNavigationSwipeBack()) {
                getSwipeBackLayout().setEnableGesture(false);
            }
        }
        AppMethodBeat.o(133260);
    }
}
