package com.tencent.p177mm.wallet_core.p650ui.formview;

import android.content.DialogInterface;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.method.NumberKeyListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p230g.p231a.C45375um;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.formview.p1098a.C30889b;

/* renamed from: com.tencent.mm.wallet_core.ui.formview.a */
public final class C30890a {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$1 */
    static class C241801 extends C30892b {
        C241801() {
            super();
        }

        /* renamed from: c */
        public final boolean mo26605c(WalletFormView walletFormView, String str) {
            AppMethodBeat.m2504i(49353);
            if (C5046bo.isNullOrNil(str) || str.length() > 5) {
                AppMethodBeat.m2505o(49353);
                return false;
            }
            walletFormView.setSelection(0);
            walletFormView.setBankcardTail(str);
            walletFormView.setMaxInputLength(24 - str.length());
            walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.getMaxInputLength())});
            AppMethodBeat.m2505o(49353);
            return true;
        }

        /* renamed from: d */
        public final boolean mo26607d(WalletFormView walletFormView, String str) {
            AppMethodBeat.m2504i(49354);
            if (C5046bo.isNullOrNil(str) || str.length() > 5) {
                AppMethodBeat.m2505o(49354);
                return false;
            }
            walletFormView.setSelection(0);
            walletFormView.set3DesToView(str);
            walletFormView.setMaxInputLength(24 - str.length());
            walletFormView.setFilters(new InputFilter[]{new LengthFilter(walletFormView.getMaxInputLength())});
            AppMethodBeat.m2505o(49354);
            return true;
        }

        public final boolean cev() {
            return true;
        }

        /* renamed from: e */
        public final String mo26608e(WalletFormView walletFormView, String str) {
            AppMethodBeat.m2504i(49356);
            String replaceAll = C5046bo.m7532bc(str, "").replaceAll(" ", "");
            AppMethodBeat.m2505o(49356);
            return replaceAll;
        }

        /* renamed from: a */
        public final boolean mo26604a(WalletFormView walletFormView) {
            AppMethodBeat.m2504i(49355);
            if (walletFormView.Aih == null) {
                AppMethodBeat.m2505o(49355);
                return false;
            }
            boolean isBankcardNum = walletFormView.Aih.isBankcardNum();
            AppMethodBeat.m2505o(49355);
            return isBankcardNum;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$2 */
    static class C241812 extends C30892b {
        C241812() {
            super();
        }

        /* renamed from: a */
        public final boolean mo26604a(WalletFormView walletFormView) {
            AppMethodBeat.m2504i(49357);
            if (walletFormView.Aih == null) {
                AppMethodBeat.m2505o(49357);
                return false;
            }
            boolean isMoneyAmount = walletFormView.Aih.isMoneyAmount();
            AppMethodBeat.m2505o(49357);
            return isMoneyAmount;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$3 */
    static class C241823 extends C30892b {
        C241823() {
            super();
        }

        public final boolean cev() {
            return true;
        }

        /* renamed from: e */
        public final String mo26608e(WalletFormView walletFormView, String str) {
            AppMethodBeat.m2504i(49358);
            String replace = C5046bo.m7532bc((String) walletFormView.getTag(), "").replace("/", "");
            AppMethodBeat.m2505o(49358);
            return replace;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$b */
    static class C30892b implements C30889b {
        private C30892b() {
        }

        /* synthetic */ C30892b(byte b) {
            this();
        }

        /* renamed from: a */
        public boolean mo26604a(WalletFormView walletFormView) {
            return true;
        }

        /* renamed from: c */
        public boolean mo26605c(WalletFormView walletFormView, String str) {
            return false;
        }

        /* renamed from: d */
        public boolean mo26607d(WalletFormView walletFormView, String str) {
            return false;
        }

        public boolean cev() {
            return false;
        }

        /* renamed from: e */
        public String mo26608e(WalletFormView walletFormView, String str) {
            return null;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$6 */
    static class C308936 extends C30892b {
        C308936() {
            super();
        }

        /* renamed from: a */
        public final boolean mo26604a(WalletFormView walletFormView) {
            AppMethodBeat.m2504i(49361);
            boolean amW = C5046bo.amW(walletFormView.getText());
            AppMethodBeat.m2505o(49361);
            return amW;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$8 */
    static class C308948 extends C30892b {
        C308948() {
            super();
        }

        /* renamed from: a */
        public final boolean mo26604a(WalletFormView walletFormView) {
            AppMethodBeat.m2504i(49363);
            boolean isPhoneNum = walletFormView.isPhoneNum();
            AppMethodBeat.m2505o(49363);
            return isPhoneNum;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$a */
    public static class C30895a extends C30892b {
        private int AhT;
        private WalletFormView AhU;

        /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$a$1 */
        class C308961 extends NumberKeyListener {
            C308961() {
            }

            public final int getInputType() {
                return 1;
            }

            /* Access modifiers changed, original: protected|final */
            public final char[] getAcceptedChars() {
                return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
            }
        }

        /* renamed from: c */
        public final /* bridge */ /* synthetic */ boolean mo26605c(WalletFormView walletFormView, String str) {
            AppMethodBeat.m2504i(49375);
            boolean c = super.mo26605c(walletFormView, str);
            AppMethodBeat.m2505o(49375);
            return c;
        }

        public final /* bridge */ /* synthetic */ boolean cev() {
            AppMethodBeat.m2504i(49373);
            boolean cev = super.cev();
            AppMethodBeat.m2505o(49373);
            return cev;
        }

        /* renamed from: d */
        public final /* bridge */ /* synthetic */ boolean mo26607d(WalletFormView walletFormView, String str) {
            AppMethodBeat.m2504i(49374);
            boolean d = super.mo26607d(walletFormView, str);
            AppMethodBeat.m2505o(49374);
            return d;
        }

        /* renamed from: e */
        public final /* bridge */ /* synthetic */ String mo26608e(WalletFormView walletFormView, String str) {
            AppMethodBeat.m2504i(49372);
            String e = super.mo26608e(walletFormView, str);
            AppMethodBeat.m2505o(49372);
            return e;
        }

        public C30895a(WalletFormView walletFormView) {
            this(walletFormView, (byte) 0);
        }

        public C30895a(WalletFormView walletFormView, byte b) {
            super();
            AppMethodBeat.m2504i(49368);
            this.AhT = 1;
            this.AhU = walletFormView;
            this.AhT = 1;
            dOO();
            AppMethodBeat.m2505o(49368);
        }

        /* renamed from: QT */
        public final void mo49420QT(int i) {
            AppMethodBeat.m2504i(49369);
            this.AhT = i;
            dOO();
            AppMethodBeat.m2505o(49369);
        }

        private void dOO() {
            AppMethodBeat.m2504i(49370);
            if (this.AhT == 1) {
                if (this.AhU != null) {
                    this.AhU.setKeyListener(new C308961());
                    AppMethodBeat.m2505o(49370);
                    return;
                }
            } else if (this.AhU != null) {
                this.AhU.setInputType(1);
            }
            AppMethodBeat.m2505o(49370);
        }

        /* renamed from: a */
        public final boolean mo26604a(WalletFormView walletFormView) {
            AppMethodBeat.m2504i(49371);
            int i = this.AhT;
            if (walletFormView.Aih == null) {
                AppMethodBeat.m2505o(49371);
                return false;
            }
            boolean isAreaIDCardNum = walletFormView.Aih.isAreaIDCardNum(i);
            AppMethodBeat.m2505o(49371);
            return isAreaIDCardNum;
        }
    }

    /* renamed from: a */
    public static void m49291a(EditHintPasswdView editHintPasswdView) {
        AppMethodBeat.m2504i(49376);
        if (editHintPasswdView != null) {
            editHintPasswdView.setEncrType(1);
        }
        AppMethodBeat.m2505o(49376);
    }

    /* renamed from: a */
    public static void m49292a(EditHintPasswdView editHintPasswdView, boolean z) {
        AppMethodBeat.m2504i(49377);
        if (editHintPasswdView != null) {
            editHintPasswdView.setEncrType(z ? -10 : 20);
        }
        AppMethodBeat.m2505o(49377);
    }

    /* renamed from: b */
    public static void m49294b(WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49378);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49378);
            return;
        }
        walletFormView.setLogicDelegate(new C241801());
        AppMethodBeat.m2505o(49378);
    }

    /* renamed from: a */
    public static void m49290a(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49379);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49379);
            return;
        }
        walletFormView.setLogicDelegate(new C241823());
        C40950b.m71013f(mMActivity, walletFormView);
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(49359);
                walletFormView.getContext();
                int dOe = C44423ae.dOe();
                walletFormView.getContext();
                C40950b.m71011a(mMActivity, dOe, C44423ae.dOf());
                AppMethodBeat.m2505o(49359);
            }
        });
        AppMethodBeat.m2505o(49379);
    }

    /* renamed from: b */
    public static void m49293b(final MMActivity mMActivity, final WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49380);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49380);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(49360);
                walletFormView.getContext();
                C40950b.m71011a(mMActivity, C44423ae.dOg(), C25738R.string.b45);
                AppMethodBeat.m2505o(49360);
            }
        });
        AppMethodBeat.m2505o(49380);
    }

    /* renamed from: c */
    public static void m49296c(WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49381);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49381);
            return;
        }
        walletFormView.setLogicDelegate(new C30895a(walletFormView, (byte) 0));
        AppMethodBeat.m2505o(49381);
    }

    /* renamed from: d */
    public static void m49298d(WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49382);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49382);
            return;
        }
        walletFormView.setLogicDelegate(new C30895a(walletFormView));
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.m2505o(49382);
    }

    /* renamed from: e */
    public static void m49300e(WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49383);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49383);
            return;
        }
        walletFormView.setLogicDelegate(new C308936());
        AppMethodBeat.m2505o(49383);
    }

    /* renamed from: c */
    public static void m49295c(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49384);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49384);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(49362);
                C40950b.m71011a(mMActivity, 2130971152, C25738R.string.fc3);
                AppMethodBeat.m2505o(49362);
            }
        });
        walletFormView.setLogicDelegate(new C308948());
        AppMethodBeat.m2505o(49384);
    }

    /* renamed from: d */
    public static void m49297d(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49385);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49385);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {

            /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$9$1 */
            class C161041 implements DialogInterface.OnClickListener {
                C161041() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(49364);
                    C36391e.m60016n(mMActivity, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
                    C4879a.xxA.mo10055m(new C45375um());
                    AppMethodBeat.m2505o(49364);
                }
            }

            /* renamed from: com.tencent.mm.wallet_core.ui.formview.a$9$2 */
            class C161052 implements DialogInterface.OnClickListener {
                C161052() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(49365);
                    dialogInterface.dismiss();
                    AppMethodBeat.m2505o(49365);
                }
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(49366);
                C30379h.m48466d(mMActivity, mMActivity.getString(C25738R.string.fbx), mMActivity.getString(C25738R.string.fbu), mMActivity.getString(C25738R.string.fbw), mMActivity.getString(C25738R.string.fby), new C161041(), new C161052());
                AppMethodBeat.m2505o(49366);
            }
        });
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.m2505o(49385);
    }

    /* renamed from: e */
    public static void m49299e(final MMActivity mMActivity, WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49386);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49386);
            return;
        }
        walletFormView.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(49367);
                C40950b.m71011a(mMActivity, 2130971125, C25738R.string.fbu);
                AppMethodBeat.m2505o(49367);
            }
        });
        walletFormView.setFilterChar("\\x20\\t\\r\\n".toCharArray());
        AppMethodBeat.m2505o(49386);
    }

    /* renamed from: f */
    public static void m49301f(WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49387);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49387);
            return;
        }
        walletFormView.setLogicDelegate(new C241812());
        AppMethodBeat.m2505o(49387);
    }

    /* renamed from: g */
    public static void m49302g(WalletFormView walletFormView) {
        AppMethodBeat.m2504i(49388);
        if (walletFormView == null) {
            C4990ab.m7412e(TAG, "hy: param error");
            AppMethodBeat.m2505o(49388);
            return;
        }
        walletFormView.setIsSecretAnswer(true);
        AppMethodBeat.m2505o(49388);
    }
}
