package com.tencent.mm.plugin.wallet.balance.a.a;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.plugin.wallet.balance.a.a.z.AnonymousClass3;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtCheckPwdInputDialogUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;

public final class aa implements com.tencent.mm.vending.c.b<z> {
    protected z tgo;
    public final c tgp;
    public final a tgq;
    public final b tgr;
    public final d tgs;

    public class a implements e<bqq, com.tencent.mm.vending.j.e<Integer, Integer, Integer, ha>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45321);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            z zVar = aa.this.tgo;
            int intValue = ((Integer) eVar.get(0)).intValue();
            int intValue2 = ((Integer) eVar.get(1)).intValue();
            ha haVar = (ha) eVar.get(3);
            ab.i("MicroMsg.LqtSaveFetchLogic", "fetchLqt, accountType: %s, %s", Integer.valueOf(intValue2), Integer.valueOf(((Integer) eVar.get(2)).intValue()));
            ab.d("MicroMsg.LqtSaveFetchLogic", "fetchLqt, amount: %s, accountType: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            zVar.tgi = intValue;
            String stringExtra = zVar.tgf.getIntent().getStringExtra("operate_id");
            zVar.accountType = intValue2;
            zVar.tgf.mS(true);
            f.a(f.a(Integer.valueOf(intValue), haVar, Integer.valueOf(intValue2), Integer.valueOf(r4), stringExtra).c(zVar.tge.tfZ).c(new com.tencent.mm.vending.c.a<Void, blh>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(45311);
                    ab.i("MicroMsg.LqtSaveFetchLogic", "%s pre redeem finish: %s", Integer.valueOf(z.this.hashCode()), (blh) obj);
                    z.this.tgf.aDw();
                    z.this.glt = f.dMj();
                    z.this.glt.dMi();
                    z.this.tgj = r10.wOn;
                    ab.i("MicroMsg.LqtSaveFetchLogic", "%s pre redeem finish get redeemListId: %s", Integer.valueOf(z.this.hashCode()), z.this.tgj);
                    Intent intent = new Intent(z.this.tgf, WalletLqtCheckPwdInputDialogUI.class);
                    intent.putExtra("lqt_fetch_pwd_title", z.this.tgf.getString(R.string.fij));
                    intent.putExtra("lqt_fetch_pwd_money", (((double) z.this.tgi) / 100.0d));
                    intent.putExtra("lqt_redeem_listid", z.this.tgj);
                    z.this.tgf.startActivityForResult(intent, z.tgc);
                    Void voidR = zXH;
                    AppMethodBeat.o(45311);
                    return voidR;
                }
            }));
            AppMethodBeat.o(45321);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class b implements e<y, Integer> {
        public final /* synthetic */ Object call(Object obj) {
            int i;
            AppMethodBeat.i(45322);
            Integer num = (Integer) obj;
            z zVar = aa.this.tgo;
            int intValue = num.intValue();
            zVar.glt = f.dMj();
            zVar.glt.dMi();
            WalletLqtSaveFetchUI walletLqtSaveFetchUI = zVar.tgf;
            if (intValue == 1) {
                i = 24;
            } else {
                i = 25;
            }
            walletLqtSaveFetchUI.a(new y(null, i), true, false);
            AppMethodBeat.o(45322);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class c implements e<bnp, com.tencent.mm.vending.j.d<Integer, Integer, Bankcard>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45323);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            z zVar = aa.this.tgo;
            int intValue = ((Integer) dVar.get(0)).intValue();
            int intValue2 = ((Integer) dVar.get(1)).intValue();
            Bankcard bankcard = (Bankcard) dVar.get(2);
            String str = "MicroMsg.LqtSaveFetchLogic";
            String str2 = "saveLqt, accountType: %s, bankcard: %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(intValue2);
            objArr[1] = bankcard != null ? bankcard.field_bindSerial : "";
            ab.i(str, str2, objArr);
            ab.d("MicroMsg.LqtSaveFetchLogic", "saveLqt, amount: %s", Integer.valueOf(intValue));
            String stringExtra = zVar.tgf.getIntent().getStringExtra("lqt_save_fund_code");
            str = zVar.tgf.getIntent().getStringExtra("lqt_fund_spid");
            str2 = zVar.tgf.getIntent().getStringExtra("operate_id");
            zVar.tgh = intValue;
            zVar.accountType = intValue2;
            zVar.tgf.mS(true);
            f.a(f.a(stringExtra, str, Integer.valueOf(intValue), Integer.valueOf(intValue2), str2).c(zVar.tge.tfW).c(new com.tencent.mm.vending.c.a<bmo, bmo>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(45310);
                    bmo bmo = (bmo) obj;
                    z.this.tgg = bmo.vAg;
                    z.this.tgf.aDw();
                    ab.i("MicroMsg.LqtSaveFetchLogic", "get tradeNo: %s", z.this.tgg);
                    AppMethodBeat.o(45310);
                    return bmo;
                }
            }).c(new AnonymousClass3(bankcard)).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                public final void bi(Object obj) {
                    AppMethodBeat.i(45306);
                    ab.i("MicroMsg.LqtSaveFetchLogic", "onInterrupt %s", obj);
                    z.this.tgf.aDw();
                    f.dMj().cR(obj);
                    AppMethodBeat.o(45306);
                }
            }));
            AppMethodBeat.o(45323);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class d implements e<Void, com.tencent.mm.vending.j.d<Integer, Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45325);
            com.tencent.mm.vending.j.d dVar = (com.tencent.mm.vending.j.d) obj;
            z zVar = aa.this.tgo;
            int intValue = ((Integer) dVar.get(0)).intValue();
            int intValue2 = ((Integer) dVar.get(1)).intValue();
            int intValue3 = ((Integer) dVar.get(2)).intValue();
            ab.i("MicroMsg.LqtSaveFetchLogic", "updateBindBankcard, mode: %s, accountType: %s", Integer.valueOf(intValue), Integer.valueOf(intValue2));
            zVar.glt = f.dMj();
            zVar.glt.dMi();
            if (intValue == 1) {
                new e(intValue2, intValue3).acy().b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bfg>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(45317);
                        Void d = d((a) obj);
                        AppMethodBeat.o(45317);
                        return d;
                    }

                    private Void d(a<bfg> aVar) {
                        AppMethodBeat.i(45316);
                        ab.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            ab.ach(((bfg) aVar.fsy).tgu);
                            p.tfu.a(((bfg) aVar.fsy).wJa, true);
                            p.tfu.a((bfg) aVar.fsy);
                        }
                        if (z.this.glt != null) {
                            z.this.glt.resume();
                        }
                        Void voidR = zXH;
                        AppMethodBeat.o(45316);
                        return voidR;
                    }
                });
            } else {
                new f(intValue2).acy().b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bfi>>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(45308);
                        Void d = d((a) obj);
                        AppMethodBeat.o(45308);
                        return d;
                    }

                    private Void d(a<bfi> aVar) {
                        AppMethodBeat.i(45307);
                        ab.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                        if (aVar.errType == 0 && aVar.errCode == 0) {
                            ab.ach(((bfi) aVar.fsy).tgu);
                            s.cMK().a((bfi) aVar.fsy);
                            p.tfu.a(((bfi) aVar.fsy).wJa, false);
                        }
                        if (z.this.glt != null) {
                            z.this.glt.resume();
                        }
                        Void voidR = zXH;
                        AppMethodBeat.o(45307);
                        return voidR;
                    }
                });
            }
            Void voidR = zXH;
            AppMethodBeat.o(45325);
            return voidR;
        }

        public final String HZ() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<Void> gf(int i, int i2) {
            AppMethodBeat.i(45324);
            com.tencent.mm.vending.g.c c = f.h(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(1)).c(this);
            AppMethodBeat.o(45324);
            return c;
        }
    }

    public aa() {
        this(new z());
        AppMethodBeat.i(45326);
        AppMethodBeat.o(45326);
    }

    public aa(z zVar) {
        AppMethodBeat.i(45327);
        this.tgp = new c();
        this.tgq = new a();
        this.tgr = new b();
        this.tgs = new d();
        this.tgo = zVar;
        AppMethodBeat.o(45327);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tgo;
    }
}
