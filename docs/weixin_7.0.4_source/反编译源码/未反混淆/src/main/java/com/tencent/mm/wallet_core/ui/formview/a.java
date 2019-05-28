package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.um;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.e;

public final class a {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    static class b implements com.tencent.mm.wallet_core.ui.formview.a.b {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public boolean a(WalletFormView walletFormView) {
            return true;
        }

        public boolean c(WalletFormView walletFormView, String str) {
            return false;
        }

        public boolean d(WalletFormView walletFormView, String str) {
            return false;
        }

        public boolean cev() {
            return false;
        }

        public String e(WalletFormView walletFormView, String str) {
            return null;
        }
    }

    public static class a extends b {
        private int AhT;
        private WalletFormView AhU;

        public final /* bridge */ /* synthetic */ boolean c(WalletFormView walletFormView, String str) {
            AppMethodBeat.i(49375);
            boolean c = super.c(walletFormView, str);
            AppMethodBeat.o(49375);
            return c;
        }

        public final /* bridge */ /* synthetic */ boolean cev() {
            AppMethodBeat.i(49373);
            boolean cev = super.cev();
            AppMethodBeat.o(49373);
            return cev;
        }

        public final /* bridge */ /* synthetic */ boolean d(WalletFormView walletFormView, String str) {
            AppMethodBeat.i(49374);
            boolean d = super.d(walletFormView, str);
            AppMethodBeat.o(49374);
            return d;
        }

        public final /* bridge */ /* synthetic */ String e(WalletFormView walletFormView, String str) {
            AppMethodBeat.i(49372);
            String e = super.e(walletFormView, str);
            AppMethodBeat.o(49372);
            return e;
        }

        public a(WalletFormView walletFormView) {
            this(walletFormView, (byte) 0);
        }

        public a(WalletFormView walletFormView, byte b) {
            super();
            AppMethodBeat.i(49368);
            this.AhT = 1;
            this.AhU = walletFormView;
            this.AhT = 1;
            dOO();
            AppMethodBeat.o(49368);
        }

        public final void QT(int i) {
            AppMethodBeat.i(49369);
            this.AhT = i;
            dOO();
            AppMethodBeat.o(49369);
        }

        private void dOO() {
            AppMethodBeat.i(49370);
            if (this.AhT == 1) {
                if (this.AhU != null) {
                    this.AhU.setKeyListener(new NumberKeyListener() {
                        public final int getInputType() {
                            return 1;
                        }

                        /* Access modifiers changed, original: protected|final */
                        public final char[] getAcceptedChars() {
                            return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                        }
                    });
                    AppMethodBeat.o(49370);
                    return;
                }
            } else if (this.AhU != null) {
                this.AhU.setInputType(1);
            }
            AppMethodBeat.o(49370);
        }

        public final boolean a(WalletFormView walletFormView) {
            AppMethodBeat.i(49371);
            int i = this.AhT;
            if (walletFormView.Aih == null) {
                AppMethodBeat.o(49371);
                return false;
            }
            boolean isAreaIDCardNum = walletFormView.Aih.isAreaIDCardNum(i);
            AppMethodBeat.o(49371);
            return isAreaIDCardNum;
        }
    }

    public static void a(EditHintPasswdView editHintPasswdView) {
        AppMethodBeat.i(49376);
        if (editHintPasswdView != null) {
            editHintPasswdView.setEncrType(1);
        }
        AppMethodBeat.o(49376);
    }

    public static void a(EditHintPasswdView editHintPasswdView, boolean z) {
        AppMethodBeat.i(49377);
        if (editHintPasswdView != null) {
            editHintPasswdView.setEncrType(z ? -10 : 20);
        }
        AppMethodBeat.o(49377);
    }

    public static void b(WalletFormView walletFormView) {
        AppMethodBeat.i(49378);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49378);
            return;
        }
        walletFormView.setLogicDelegate(new b() {
            public final boolean c(WalletFormView walletFormView, String str) {
                AppMethodBeat.i(49353);
                if (bo.isNullOrNil(str) || str.length() > 5) {
                    AppMethodBeat.o(49353);
                    return false;
                }
                walletFormView.setSelection(0);
                walletFormView.setBankcardTail(str);
                walletFormView.setMaxInputLength(24 - str.length());
                walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.getMaxInputLength())});
                AppMethodBeat.o(49353);
                return true;
            }

            public final boolean d(WalletFormView walletFormView, String str) {
                AppMethodBeat.i(49354);
                if (bo.isNullOrNil(str) || str.length() > 5) {
                    AppMethodBeat.o(49354);
                    return false;
                }
                walletFormView.setSelection(0);
                walletFormView.set3DesToView(str);
                walletFormView.setMaxInputLength(24 - str.length());
                walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.getMaxInputLength())});
                AppMethodBeat.o(49354);
                return true;
            }

            public final boolean cev() {
                return true;
            }

            public final String e(WalletFormView walletFormView, String str) {
                AppMethodBeat.i(49356);
                String replaceAll = bo.bc(str, "").replaceAll(" ", "");
                AppMethodBeat.o(49356);
                return replaceAll;
            }

            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(49355);
                if (walletFormView.Aih == null) {
                    AppMethodBeat.o(49355);
                    return false;
                }
                boolean isBankcardNum = walletFormView.Aih.isBankcardNum();
                AppMethodBeat.o(49355);
                return isBankcardNum;
            }
        });
        AppMethodBeat.o(49378);
    }

    public static void a(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.i(49379);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49379);
            return;
        }
        walletFormView.setLogicDelegate(new b() {
            public final boolean cev() {
                return true;
            }

            public final String e(WalletFormView walletFormView, String str) {
                AppMethodBeat.i(49358);
                String replace = bo.bc((String) walletFormView.getTag(), "").replace("/", "");
                AppMethodBeat.o(49358);
                return replace;
            }
        });
        b.f(mMActivity, walletFormView);
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(49359);
                walletFormView.getContext();
                int dOe = ae.dOe();
                walletFormView.getContext();
                b.a(mMActivity, dOe, ae.dOf());
                AppMethodBeat.o(49359);
            }
        });
        AppMethodBeat.o(49379);
    }

    public static void b(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.i(49380);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49380);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(49360);
                walletFormView.getContext();
                b.a(mMActivity, ae.dOg(), R.string.b45);
                AppMethodBeat.o(49360);
            }
        });
        AppMethodBeat.o(49380);
    }

    public static void c(WalletFormView walletFormView) {
        AppMethodBeat.i(49381);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49381);
            return;
        }
        walletFormView.setLogicDelegate(new a(walletFormView, (byte) 0));
        AppMethodBeat.o(49381);
    }

    public static void d(WalletFormView walletFormView) {
        AppMethodBeat.i(49382);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49382);
            return;
        }
        walletFormView.setLogicDelegate(new a(walletFormView));
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.o(49382);
    }

    public static void e(WalletFormView walletFormView) {
        AppMethodBeat.i(49383);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49383);
            return;
        }
        walletFormView.setLogicDelegate(new b() {
            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(49361);
                boolean amW = bo.amW(walletFormView.getText());
                AppMethodBeat.o(49361);
                return amW;
            }
        });
        AppMethodBeat.o(49383);
    }

    public static void c(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.i(49384);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49384);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(49362);
                b.a(mMActivity, R.layout.b5p, R.string.fc3);
                AppMethodBeat.o(49362);
            }
        });
        walletFormView.setLogicDelegate(new b() {
            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(49363);
                boolean isPhoneNum = walletFormView.isPhoneNum();
                AppMethodBeat.o(49363);
                return isPhoneNum;
            }
        });
        AppMethodBeat.o(49384);
    }

    public static void d(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.i(49385);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49385);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(49366);
                h.d(mMActivity, mMActivity.getString(R.string.fbx), mMActivity.getString(R.string.fbu), mMActivity.getString(R.string.fbw), mMActivity.getString(R.string.fby), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(49364);
                        e.n(mMActivity, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
                        com.tencent.mm.sdk.b.a.xxA.m(new um());
                        AppMethodBeat.o(49364);
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(49365);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(49365);
                    }
                });
                AppMethodBeat.o(49366);
            }
        });
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.o(49385);
    }

    public static void e(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.i(49386);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49386);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(49367);
                b.a(mMActivity, R.layout.b4z, R.string.fbu);
                AppMethodBeat.o(49367);
            }
        });
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.o(49386);
    }

    public static void f(WalletFormView walletFormView) {
        AppMethodBeat.i(49387);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49387);
            return;
        }
        walletFormView.setLogicDelegate(new b() {
            public final boolean a(WalletFormView walletFormView) {
                AppMethodBeat.i(49357);
                if (walletFormView.Aih == null) {
                    AppMethodBeat.o(49357);
                    return false;
                }
                boolean isMoneyAmount = walletFormView.Aih.isMoneyAmount();
                AppMethodBeat.o(49357);
                return isMoneyAmount;
            }
        });
        AppMethodBeat.o(49387);
    }

    public static void g(WalletFormView walletFormView) {
        AppMethodBeat.i(49388);
        if (walletFormView == null) {
            ab.e(TAG, "hy: param error");
            AppMethodBeat.o(49388);
            return;
        }
        walletFormView.setIsSecretAnswer(true);
        AppMethodBeat.o(49388);
    }
}
