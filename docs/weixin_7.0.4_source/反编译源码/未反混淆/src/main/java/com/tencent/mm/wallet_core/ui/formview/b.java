package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.picker.CustomDatePicker;
import com.tencent.mm.ui.widget.picker.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Locale;

public final class b {
    private static int Ahe = 0;
    private static int Ahf = 0;
    private static final int Aid = R.id.d8;

    static void a(TenpaySecureEditText tenpaySecureEditText, int i) {
        AppMethodBeat.i(49404);
        if (tenpaySecureEditText == null) {
            ab.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
            AppMethodBeat.o(49404);
        } else if (i == 1) {
            tenpaySecureEditText.setIsPasswordFormat(true);
            AppMethodBeat.o(49404);
        } else if (i == 2) {
            tenpaySecureEditText.setIsSecurityAnswerFormat(true);
            AppMethodBeat.o(49404);
        } else if (i == 3) {
            tenpaySecureEditText.setIsCvvPaymentFormat(true);
            AppMethodBeat.o(49404);
        } else if (i == 4) {
            tenpaySecureEditText.setIsCvv4PaymentFormat(true);
            AppMethodBeat.o(49404);
        } else if (i == 5) {
            tenpaySecureEditText.setIsValidThru(true);
            AppMethodBeat.o(49404);
        } else if (i == 6) {
            tenpaySecureEditText.setIsBankcardFormat(true);
            AppMethodBeat.o(49404);
        } else if (i == 7) {
            tenpaySecureEditText.setIsMoneyAmountFormat(true);
            AppMethodBeat.o(49404);
        } else if (i == 8) {
            tenpaySecureEditText.setIsIdCardTailFormat(true);
            AppMethodBeat.o(49404);
        } else {
            tenpaySecureEditText.setIsCvv4PaymentFormat(false);
            AppMethodBeat.o(49404);
        }
    }

    public static void f(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.i(49405);
        walletFormView.setOnClickListener(new OnClickListener() {
            int Aie = -1;
            int year = -1;

            public final void onClick(View view) {
                AppMethodBeat.i(49402);
                mMActivity.aqX();
                if (mMActivity instanceof WalletBaseUI) {
                    ((WalletBaseUI) mMActivity).aoB();
                }
                final a aVar = new a(mMActivity);
                aVar.al(true, false);
                aVar.zSj = new a.a() {
                    public final void b(boolean z, int i, int i2, int i3) {
                        AppMethodBeat.i(49401);
                        aVar.hide();
                        if (z) {
                            String format;
                            a aVar = aVar;
                            if (aVar.zSi != null) {
                                CustomDatePicker customDatePicker = aVar.zSi;
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
                            if (bo.isNullOrNil(format)) {
                                AppMethodBeat.o(49401);
                                return;
                            }
                            String[] split = format.split("-");
                            if (split.length < 2) {
                                AppMethodBeat.o(49401);
                                return;
                            }
                            ab.d("MicroMsg.FormatViewUtil", "result: %s", format);
                            int ank = bo.ank(split[0]);
                            AnonymousClass1.this.Aie = bo.ank(split[1]) - 1;
                            ab.d("MicroMsg.FormatViewUtil", "year: %s, month: %s", Integer.valueOf(ank), Integer.valueOf(AnonymousClass1.this.Aie));
                            if (ank >= b.Ahe || AnonymousClass1.this.Aie >= b.Ahf) {
                                DecimalFormat decimalFormat = new DecimalFormat("00");
                                if (r.YM()) {
                                    walletFormView.setTag(decimalFormat.format((long) (AnonymousClass1.this.Aie + 1)) + ank);
                                } else {
                                    walletFormView.setTag(decimalFormat.format((long) ank).substring(2) + decimalFormat.format((long) (AnonymousClass1.this.Aie + 1)));
                                }
                                walletFormView.setText(decimalFormat.format((long) (AnonymousClass1.this.Aie + 1)) + decimalFormat.format((long) ank).substring(2));
                            } else {
                                h.b(mMActivity, mMActivity.getString(R.string.fel), null, true);
                            }
                            if (walletFormView.getInputValidChangeListener() != null) {
                                walletFormView.getInputValidChangeListener().hY(walletFormView.asa());
                            }
                        }
                        AppMethodBeat.o(49401);
                    }
                };
                if (this.year >= b.Ahe && this.Aie >= b.Ahf) {
                    aVar.aB(this.year, this.Aie + 1, 1);
                }
                aVar.show();
                AppMethodBeat.o(49402);
            }
        });
        AppMethodBeat.o(49405);
    }

    public static void a(MMActivity mMActivity, int i, int i2) {
        AppMethodBeat.i(49406);
        if (i == -1) {
            AppMethodBeat.o(49406);
            return;
        }
        mMActivity.addDialog(com.tencent.mm.wallet_core.ui.b.a(mMActivity, i, mMActivity.getResources().getString(i2), mMActivity.getResources().getString(R.string.ffp), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(49403);
                dialogInterface.dismiss();
                AppMethodBeat.o(49403);
            }
        }));
        AppMethodBeat.o(49406);
    }
}
