package com.tencent.p177mm.wallet_core.p650ui.formview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.picker.C46701a;
import com.tencent.p177mm.p612ui.widget.picker.C46701a.C5669a;
import com.tencent.p177mm.p612ui.widget.picker.CustomDatePicker;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36387b;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Locale;

/* renamed from: com.tencent.mm.wallet_core.ui.formview.b */
public final class C40950b {
    private static int Ahe = 0;
    private static int Ahf = 0;
    private static final int Aid = 2131820689;

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.b$2 */
    static class C409512 implements OnClickListener {
        C409512() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(49403);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(49403);
        }
    }

    /* renamed from: a */
    static void m71012a(TenpaySecureEditText tenpaySecureEditText, int i) {
        AppMethodBeat.m2504i(49404);
        if (tenpaySecureEditText == null) {
            C4990ab.m7412e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
            AppMethodBeat.m2505o(49404);
        } else if (i == 1) {
            tenpaySecureEditText.setIsPasswordFormat(true);
            AppMethodBeat.m2505o(49404);
        } else if (i == 2) {
            tenpaySecureEditText.setIsSecurityAnswerFormat(true);
            AppMethodBeat.m2505o(49404);
        } else if (i == 3) {
            tenpaySecureEditText.setIsCvvPaymentFormat(true);
            AppMethodBeat.m2505o(49404);
        } else if (i == 4) {
            tenpaySecureEditText.setIsCvv4PaymentFormat(true);
            AppMethodBeat.m2505o(49404);
        } else if (i == 5) {
            tenpaySecureEditText.setIsValidThru(true);
            AppMethodBeat.m2505o(49404);
        } else if (i == 6) {
            tenpaySecureEditText.setIsBankcardFormat(true);
            AppMethodBeat.m2505o(49404);
        } else if (i == 7) {
            tenpaySecureEditText.setIsMoneyAmountFormat(true);
            AppMethodBeat.m2505o(49404);
        } else if (i == 8) {
            tenpaySecureEditText.setIsIdCardTailFormat(true);
            AppMethodBeat.m2505o(49404);
        } else {
            tenpaySecureEditText.setIsCvv4PaymentFormat(false);
            AppMethodBeat.m2505o(49404);
        }
    }

    /* renamed from: f */
    public static void m71013f(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49405);
        walletFormView.setOnClickListener(new View.OnClickListener() {
            int Aie = -1;
            int year = -1;

            public final void onClick(View view) {
                AppMethodBeat.m2504i(49402);
                mMActivity.aqX();
                if (mMActivity instanceof WalletBaseUI) {
                    ((WalletBaseUI) mMActivity).aoB();
                }
                final C46701a c46701a = new C46701a(mMActivity);
                c46701a.mo75047al(true, false);
                c46701a.zSj = new C5669a() {
                    /* renamed from: b */
                    public final void mo11538b(boolean z, int i, int i2, int i3) {
                        AppMethodBeat.m2504i(49401);
                        c46701a.hide();
                        if (z) {
                            String format;
                            C46701a c46701a = c46701a;
                            if (c46701a.zSi != null) {
                                CustomDatePicker customDatePicker = c46701a.zSi;
                                if (customDatePicker.jkv) {
                                    format = String.format(Locale.US, "%04d-%02d-%02d", new Object[]{Integer.valueOf(customDatePicker.getYear()), Integer.valueOf(customDatePicker.getMonth()), Integer.valueOf(customDatePicker.getDayOfMonth())});
                                } else if (customDatePicker.jku) {
                                    format = String.format(Locale.US, "%04d-%02d", new Object[]{Integer.valueOf(customDatePicker.getYear()), Integer.valueOf(customDatePicker.getMonth())});
                                } else {
                                    format = String.format(Locale.US, "%04d", new Object[]{Integer.valueOf(customDatePicker.getYear())});
                                }
                            } else {
                                format = null;
                            }
                            if (C5046bo.isNullOrNil(format)) {
                                AppMethodBeat.m2505o(49401);
                                return;
                            }
                            String[] split = format.split("-");
                            if (split.length < 2) {
                                AppMethodBeat.m2505o(49401);
                                return;
                            }
                            C4990ab.m7411d("MicroMsg.FormatViewUtil", "result: %s", format);
                            int ank = C5046bo.ank(split[0]);
                            C241831.this.Aie = C5046bo.ank(split[1]) - 1;
                            C4990ab.m7411d("MicroMsg.FormatViewUtil", "year: %s, month: %s", Integer.valueOf(ank), Integer.valueOf(C241831.this.Aie));
                            if (ank >= C40950b.Ahe || C241831.this.Aie >= C40950b.Ahf) {
                                DecimalFormat decimalFormat = new DecimalFormat("00");
                                if (C1853r.m3831YM()) {
                                    walletFormView.setTag(decimalFormat.format((long) (C241831.this.Aie + 1)) + ank);
                                } else {
                                    walletFormView.setTag(decimalFormat.format((long) ank).substring(2) + decimalFormat.format((long) (C241831.this.Aie + 1)));
                                }
                                walletFormView.setText(decimalFormat.format((long) (C241831.this.Aie + 1)) + decimalFormat.format((long) ank).substring(2));
                            } else {
                                C30379h.m48461b(mMActivity, mMActivity.getString(C25738R.string.fel), null, true);
                            }
                            if (walletFormView.getInputValidChangeListener() != null) {
                                walletFormView.getInputValidChangeListener().mo9407hY(walletFormView.asa());
                            }
                        }
                        AppMethodBeat.m2505o(49401);
                    }
                };
                if (this.year >= C40950b.Ahe && this.Aie >= C40950b.Ahf) {
                    c46701a.mo75044aB(this.year, this.Aie + 1, 1);
                }
                c46701a.show();
                AppMethodBeat.m2505o(49402);
            }
        });
        AppMethodBeat.m2505o(49405);
    }

    /* renamed from: a */
    public static void m71011a(MMActivity mMActivity, int i, int i2) {
        AppMethodBeat.m2504i(49406);
        if (i == -1) {
            AppMethodBeat.m2505o(49406);
            return;
        }
        mMActivity.addDialog(C36387b.m59970a(mMActivity, i, mMActivity.getResources().getString(i2), mMActivity.getResources().getString(C25738R.string.ffp), new C409512()));
        AppMethodBeat.m2505o(49406);
    }
}
