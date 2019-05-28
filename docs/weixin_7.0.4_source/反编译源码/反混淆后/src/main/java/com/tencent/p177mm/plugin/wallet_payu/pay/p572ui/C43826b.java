package com.tencent.p177mm.plugin.wallet_payu.pay.p572ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.wallet.p748a.C46330j;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.model.p1314a.C22581b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22621b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22621b.C22622a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C29666c;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40131q.C40134a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.b */
public class C43826b extends C40131q {
    private C14368b tUf;
    private int tUg = 0;
    private boolean tUh = false;
    private C43827a tUi;

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.b$b */
    public interface C14368b {
        /* renamed from: a */
        void mo9564a(String str, String str2, FavorPayInfo favorPayInfo);
    }

    /* renamed from: com.tencent.mm.plugin.wallet_payu.pay.ui.b$a */
    class C43827a {
        public C40134a tKm;
        public String tUk;
        public Bankcard tUl;
        public FavorPayInfo tUm;
        public boolean tUn;
        public C14368b tUo;
        public OnCancelListener tUp;

        public C43827a(String str, Bankcard bankcard, FavorPayInfo favorPayInfo, boolean z, OnCancelListener onCancelListener, C40134a c40134a, C14368b c14368b) {
            this.tUk = str;
            this.tUl = bankcard;
            this.tUm = favorPayInfo;
            this.tUn = z;
            this.tUp = onCancelListener;
            this.tKm = c40134a;
            this.tUo = c14368b;
        }
    }

    public C43826b(Context context) {
        super(context);
    }

    /* renamed from: cA */
    public final void mo63474cA(Context context) {
        AppMethodBeat.m2504i(138570);
        mo63477fl(context);
        super.mo63478fm(context);
        if (this.tJU != null) {
            this.tJU.setVisibility(8);
        }
        AppMethodBeat.m2505o(138570);
    }

    /* renamed from: fm */
    public final void mo63478fm(Context context) {
        AppMethodBeat.m2504i(138995);
        super.mo63478fm(context);
        AppMethodBeat.m2505o(138995);
    }

    /* renamed from: a */
    public static C43826b m78582a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, C14368b c14368b, OnClickListener onClickListener, OnCancelListener onCancelListener, boolean z) {
        AppMethodBeat.m2504i(48499);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.m2505o(48499);
            return null;
        }
        List cRl;
        String str;
        boolean z2;
        CharSequence charSequence;
        C22621b a = C29666c.tDU.mo47919a(orders);
        if (a != null) {
            if (favorPayInfo != null) {
                if (!(bankcard == null || bankcard.field_bankcardType.equals(favorPayInfo.tzd))) {
                    String bC = a.mo38205bC(favorPayInfo.tzb, false);
                    C22622a c22622a = (C22622a) a.mo38204bB(bC, true).get(bankcard.field_bankcardType);
                    if (c22622a == null || c22622a.tDR == null || C5046bo.isNullOrNil(c22622a.tDR.tnk)) {
                        favorPayInfo.tzb = bC;
                    } else {
                        favorPayInfo.tzb = c22622a.tDR.tnk;
                    }
                }
            } else if (orders.tAr != null) {
                favorPayInfo = a.acX(a.acY(orders.tAr.tmU));
            }
            cRl = a.cRl();
        } else {
            C4990ab.m7410d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
            cRl = null;
        }
        Commodity commodity = (Commodity) orders.tAq.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (C5046bo.isNullOrNil(commodity.pca)) {
            str = "";
        } else {
            str = commodity.pca + IOUtils.LINE_SEPARATOR_UNIX;
        }
        String stringBuilder2 = stringBuilder.append(str).append(((Commodity) orders.tAq.get(0)).desc).toString();
        String str2 = null;
        String str3 = null;
        CharSequence charSequence2 = null;
        double d = orders.pTN;
        if (a == null || favorPayInfo == null) {
            z2 = false;
        } else {
            C46330j acU = a.acU(favorPayInfo.tzb);
            if (acU != null && acU.tnl > 0.0d) {
                d = acU.tmT;
                str3 = C36391e.m60006e(orders.pTN, orders.pcl);
                str2 = C36391e.m60006e(acU.tmT, orders.pcl);
                Object[] objArr = new Object[]{C36391e.m59971F(acU.tnl)};
                z2 = true;
                charSequence2 = context.getString(C25738R.string.foi, objArr);
            } else if (cRl == null || cRl.size() <= 0) {
                z2 = false;
                str2 = C36391e.m60006e(orders.pTN, orders.pcl);
            } else {
                z2 = true;
                Object charSequence22 = context.getString(C25738R.string.fq0);
            }
        }
        if (bankcard == null) {
            charSequence = "";
        } else {
            charSequence = bankcard.field_desc;
        }
        C43826b c43826b = new C43826b(context);
        c43826b.tJT = bankcard;
        c43826b.mo63467a(context, orders, favorPayInfo, bankcard);
        c43826b.mo63473b(onCancelListener);
        c43826b.setOnCancelListener(onCancelListener);
        c43826b.setCancelable(true);
        c43826b.adc(stringBuilder2);
        c43826b.mo63476f(str2, d);
        c43826b.ade(str3);
        c43826b.mo63469a(charSequence, onClickListener, z2);
        if (TextUtils.isEmpty(charSequence22)) {
            c43826b.tJE.setVisibility(8);
        } else {
            c43826b.tJE.setVisibility(0);
            c43826b.tJE.setText(charSequence22);
        }
        c43826b.tUh = z;
        c43826b.tJF.setEncrType(-10);
        c43826b.tUf = c14368b;
        c43826b.show();
        C30379h.m48455a(context, c43826b);
        AppMethodBeat.m2505o(48499);
        return c43826b;
    }

    public final void cRO() {
        AppMethodBeat.m2504i(48500);
        if (this.tJQ != null) {
            this.tJQ.onClick(this, 0);
        }
        dismiss();
        if (this.tUf != null) {
            if (!this.tUh) {
                this.tUf.mo9564a(this.tJF.getText(), "", this.toH);
            } else if (this.tUg == 0) {
                Context context = getContext();
                final C43827a c43827a = new C43827a(this.tJF.getText(), this.tJT, this.toH, this.tJR, this.f16192Ue, this.tKm, this.tUf);
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    AppMethodBeat.m2505o(48500);
                    return;
                }
                C227061 c227061 = new C43826b(context) {
                    public final int btU() {
                        AppMethodBeat.m2504i(48496);
                        int i = 3;
                        if (c43827a.tUl != null && c43827a.tUl.field_bankcardClientType == 1) {
                            C4990ab.m7410d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                            i = new C22581b(c43827a.tUl).tDL;
                        }
                        if (i == 4) {
                            C4990ab.m7410d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                            AppMethodBeat.m2505o(48496);
                            return 2130970348;
                        }
                        AppMethodBeat.m2505o(48496);
                        return 2130970349;
                    }
                };
                c227061.tUg = 1;
                c227061.tUh = true;
                c227061.tUi = c43827a;
                if (c227061.tUi != null) {
                    String str;
                    c227061.mo63473b(c227061.tUi.tUp);
                    c227061.setOnCancelListener(c227061.tUi.tUp);
                    c227061.setCancelable(true);
                    if (c227061.tUi.tUl == null) {
                        str = "";
                    } else {
                        str = c227061.tUi.tUl.field_desc;
                    }
                    c227061.mo63476f(str, 0.0d);
                    c227061.mo63480no(false);
                    c227061.mo63468a(c227061.tUi.tKm);
                    c227061.tUf = c227061.tUi.tUo;
                    c227061.tJF.setEncrType(30);
                    c227061.show();
                    C30379h.m48455a(context, c227061);
                }
                AppMethodBeat.m2505o(48500);
                return;
            } else if (this.tUg == 1) {
                this.tUf.mo9564a(this.tUi.tUk, this.tJF.getText(), this.tUi.tUm);
                AppMethodBeat.m2505o(48500);
                return;
            } else {
                C4990ab.m7412e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
                AppMethodBeat.m2505o(48500);
                return;
            }
        }
        AppMethodBeat.m2505o(48500);
    }
}
