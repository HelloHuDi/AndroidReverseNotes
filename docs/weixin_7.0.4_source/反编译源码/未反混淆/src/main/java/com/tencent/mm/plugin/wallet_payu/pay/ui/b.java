package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.j;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.ui.c;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.List;

public class b extends q {
    private b tUf;
    private int tUg = 0;
    private boolean tUh = false;
    private a tUi;

    public interface b {
        void a(String str, String str2, FavorPayInfo favorPayInfo);
    }

    class a {
        public com.tencent.mm.plugin.wallet_core.ui.q.a tKm;
        public String tUk;
        public Bankcard tUl;
        public FavorPayInfo tUm;
        public boolean tUn;
        public b tUo;
        public OnCancelListener tUp;

        public a(String str, Bankcard bankcard, FavorPayInfo favorPayInfo, boolean z, OnCancelListener onCancelListener, com.tencent.mm.plugin.wallet_core.ui.q.a aVar, b bVar) {
            this.tUk = str;
            this.tUl = bankcard;
            this.tUm = favorPayInfo;
            this.tUn = z;
            this.tUp = onCancelListener;
            this.tKm = aVar;
            this.tUo = bVar;
        }
    }

    public b(Context context) {
        super(context);
    }

    public final void cA(Context context) {
        AppMethodBeat.i(138570);
        fl(context);
        super.fm(context);
        if (this.tJU != null) {
            this.tJU.setVisibility(8);
        }
        AppMethodBeat.o(138570);
    }

    public final void fm(Context context) {
        AppMethodBeat.i(138995);
        super.fm(context);
        AppMethodBeat.o(138995);
    }

    public static b a(Context context, Orders orders, FavorPayInfo favorPayInfo, Bankcard bankcard, b bVar, OnClickListener onClickListener, OnCancelListener onCancelListener, boolean z) {
        AppMethodBeat.i(48499);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(48499);
            return null;
        }
        List cRl;
        String str;
        boolean z2;
        CharSequence charSequence;
        com.tencent.mm.plugin.wallet_core.ui.b a = c.tDU.a(orders);
        if (a != null) {
            if (favorPayInfo != null) {
                if (!(bankcard == null || bankcard.field_bankcardType.equals(favorPayInfo.tzd))) {
                    String bC = a.bC(favorPayInfo.tzb, false);
                    com.tencent.mm.plugin.wallet_core.ui.b.a aVar = (com.tencent.mm.plugin.wallet_core.ui.b.a) a.bB(bC, true).get(bankcard.field_bankcardType);
                    if (aVar == null || aVar.tDR == null || bo.isNullOrNil(aVar.tDR.tnk)) {
                        favorPayInfo.tzb = bC;
                    } else {
                        favorPayInfo.tzb = aVar.tDR.tnk;
                    }
                }
            } else if (orders.tAr != null) {
                favorPayInfo = a.acX(a.acY(orders.tAr.tmU));
            }
            cRl = a.cRl();
        } else {
            ab.d("MicroMsg.WalletPayUPwdDialog", "getFavorLogicHelper null");
            cRl = null;
        }
        Commodity commodity = (Commodity) orders.tAq.get(0);
        StringBuilder stringBuilder = new StringBuilder();
        if (bo.isNullOrNil(commodity.pca)) {
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
            j acU = a.acU(favorPayInfo.tzb);
            if (acU != null && acU.tnl > 0.0d) {
                d = acU.tmT;
                str3 = e.e(orders.pTN, orders.pcl);
                str2 = e.e(acU.tmT, orders.pcl);
                Object[] objArr = new Object[]{e.F(acU.tnl)};
                z2 = true;
                charSequence2 = context.getString(R.string.foi, objArr);
            } else if (cRl == null || cRl.size() <= 0) {
                z2 = false;
                str2 = e.e(orders.pTN, orders.pcl);
            } else {
                z2 = true;
                Object charSequence22 = context.getString(R.string.fq0);
            }
        }
        if (bankcard == null) {
            charSequence = "";
        } else {
            charSequence = bankcard.field_desc;
        }
        b bVar2 = new b(context);
        bVar2.tJT = bankcard;
        bVar2.a(context, orders, favorPayInfo, bankcard);
        bVar2.b(onCancelListener);
        bVar2.setOnCancelListener(onCancelListener);
        bVar2.setCancelable(true);
        bVar2.adc(stringBuilder2);
        bVar2.f(str2, d);
        bVar2.ade(str3);
        bVar2.a(charSequence, onClickListener, z2);
        if (TextUtils.isEmpty(charSequence22)) {
            bVar2.tJE.setVisibility(8);
        } else {
            bVar2.tJE.setVisibility(0);
            bVar2.tJE.setText(charSequence22);
        }
        bVar2.tUh = z;
        bVar2.tJF.setEncrType(-10);
        bVar2.tUf = bVar;
        bVar2.show();
        h.a(context, bVar2);
        AppMethodBeat.o(48499);
        return bVar2;
    }

    public final void cRO() {
        AppMethodBeat.i(48500);
        if (this.tJQ != null) {
            this.tJQ.onClick(this, 0);
        }
        dismiss();
        if (this.tUf != null) {
            if (!this.tUh) {
                this.tUf.a(this.tJF.getText(), "", this.toH);
            } else if (this.tUg == 0) {
                Context context = getContext();
                final a aVar = new a(this.tJF.getText(), this.tJT, this.toH, this.tJR, this.Ue, this.tKm, this.tUf);
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    AppMethodBeat.o(48500);
                    return;
                }
                AnonymousClass1 anonymousClass1 = new b(context) {
                    public final int btU() {
                        AppMethodBeat.i(48496);
                        int i = 3;
                        if (aVar.tUl != null && aVar.tUl.field_bankcardClientType == 1) {
                            ab.d("MicroMsg.WalletPayUPwdDialog", "hy: the bankcard can be assembled to BankcardPayU");
                            i = new com.tencent.mm.plugin.wallet_core.model.a.b(aVar.tUl).tDL;
                        }
                        if (i == 4) {
                            ab.d("MicroMsg.WalletPayUPwdDialog", "hy: is 4 digits cvv");
                            AppMethodBeat.o(48496);
                            return R.layout.ak2;
                        }
                        AppMethodBeat.o(48496);
                        return R.layout.ak3;
                    }
                };
                anonymousClass1.tUg = 1;
                anonymousClass1.tUh = true;
                anonymousClass1.tUi = aVar;
                if (anonymousClass1.tUi != null) {
                    String str;
                    anonymousClass1.b(anonymousClass1.tUi.tUp);
                    anonymousClass1.setOnCancelListener(anonymousClass1.tUi.tUp);
                    anonymousClass1.setCancelable(true);
                    if (anonymousClass1.tUi.tUl == null) {
                        str = "";
                    } else {
                        str = anonymousClass1.tUi.tUl.field_desc;
                    }
                    anonymousClass1.f(str, 0.0d);
                    anonymousClass1.no(false);
                    anonymousClass1.a(anonymousClass1.tUi.tKm);
                    anonymousClass1.tUf = anonymousClass1.tUi.tUo;
                    anonymousClass1.tJF.setEncrType(30);
                    anonymousClass1.show();
                    h.a(context, anonymousClass1);
                }
                AppMethodBeat.o(48500);
                return;
            } else if (this.tUg == 1) {
                this.tUf.a(this.tUi.tUk, this.tJF.getText(), this.tUi.tUm);
                AppMethodBeat.o(48500);
                return;
            } else {
                ab.e("MicroMsg.WalletPayUPwdDialog", "hy: error dialog state");
                AppMethodBeat.o(48500);
                return;
            }
        }
        AppMethodBeat.o(48500);
    }
}
