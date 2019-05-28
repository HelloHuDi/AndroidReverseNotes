package com.tencent.mm.plugin.wallet_index.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.a.a.ab;
import com.tencent.mm.plugin.wallet.balance.a.a.ad;
import com.tencent.mm.plugin.wallet.balance.a.a.l;
import com.tencent.mm.plugin.wallet.balance.a.a.r;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanAddUI;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@a(7)
public class WalletOpenViewProxyUI extends WalletBaseUI {
    private Map<String, String> tSm = new HashMap();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletOpenViewProxyUI() {
        AppMethodBeat.i(48301);
        AppMethodBeat.o(48301);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48302);
        super.onCreate(bundle);
        AM(8);
        String stringExtra = getIntent().getStringExtra("packageExt");
        this.tSm = new HashMap();
        if (!bo.isNullOrNil(stringExtra)) {
            String[] split = stringExtra.split("&");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    if (!bo.isNullOrNil(split[i])) {
                        String[] split2 = split[i].split("=");
                        if (split2.length == 2 && !bo.isNullOrNil(split2[0])) {
                            this.tSm.put(split2[0], split2[1]);
                        }
                    }
                }
            }
        }
        stringExtra = (String) this.tSm.get("trace_info");
        if (!bo.isNullOrNil(stringExtra)) {
            ab.ach(stringExtra);
        }
        nf(2996);
        nf(580);
        nf(385);
        if (getIntent() == null) {
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.o(48302);
            return;
        }
        stringExtra = (String) this.tSm.get("openview");
        String stringExtra2 = getIntent().getStringExtra("appId");
        String stringExtra3 = getIntent().getStringExtra("timeStamp");
        String stringExtra4 = getIntent().getStringExtra("nonceStr");
        String stringExtra5 = getIntent().getStringExtra("packageExt");
        String stringExtra6 = getIntent().getStringExtra("paySignature");
        if ("open_wcpay_f2f_receive_detail".equals(stringExtra)) {
            a(new u(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6), true, false);
            AppMethodBeat.o(48302);
        } else if ("open_wcpay_grouppay_detail".equals(stringExtra)) {
            adj(stringExtra5);
            AppMethodBeat.o(48302);
        } else if ("open_wcpay_lqt_detail".equals(stringExtra)) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
            if (this.tSm != null) {
                new Intent().putExtra("key_account_type", 1);
                stringExtra = (String) this.tSm.get("ecardtype");
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", stringExtra, (String) this.tSm.get("extradata"), (String) this.tSm.get("need_open_lqb"));
                if (bo.getInt((String) this.tSm.get("need_open_lqb"), 0) == 1) {
                    if (bo.isNullOrNil(stringExtra)) {
                        stringExtra = "WEB_DEBIT";
                    }
                    a(new ad(stringExtra, stringExtra2), true, false);
                } else {
                    d.H(this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    setResult(-1);
                    finish();
                }
            } else {
                d.H(this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                setResult(-1);
                finish();
            }
            h.pYm.a(663, 18, 1, false);
            AppMethodBeat.o(48302);
        } else if ("redenvelopes_getshowresouces_and_move_to_root".equals(stringExtra)) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "receive envelope");
            ((com.tencent.mm.plugin.luckymoney.a.a) g.K(com.tencent.mm.plugin.luckymoney.a.a.class)).bKL();
            setResult(-1);
            finish();
            AppMethodBeat.o(48302);
        } else {
            String str = stringExtra2;
            String str2 = stringExtra3;
            String str3 = stringExtra4;
            String str4 = stringExtra5;
            String str5 = stringExtra6;
            a(new com.tencent.mm.plugin.wallet_core.c.a(str, str2, str3, str4, getIntent().getStringExtra("signtype"), str5, getIntent().getStringExtra("url"), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)), true, false);
            AppMethodBeat.o(48302);
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48303);
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, mVar);
        if (i != 0 || i2 != 0) {
            setResult(0);
            finish();
            AppMethodBeat.o(48303);
            return true;
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            f.akr(((com.tencent.mm.plugin.wallet_core.c.a) mVar).cOS());
            adj(getIntent().getStringExtra("packageExt"));
            AppMethodBeat.o(48303);
            return true;
        } else if (mVar instanceof u) {
            adj(getIntent().getStringExtra("packageExt"));
            AppMethodBeat.o(48303);
            return true;
        } else if (mVar instanceof ad) {
            bhd bhd = ((ad) mVar).tgw;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", Integer.valueOf(bhd.kdT), bhd.kdU);
            if (bhd.kdT == 0) {
                Intent intent = new Intent();
                intent.putExtra("key_account_type", 2);
                d.b(this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                setResult(-1);
            } else {
                Toast.makeText(this, bhd.kdU, 1).show();
                setResult(0);
            }
            finish();
            AppMethodBeat.o(48303);
            return true;
        } else {
            AppMethodBeat.o(48303);
            return false;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(48304);
        super.onDestroy();
        ng(580);
        ng(385);
        ng(2996);
        AppMethodBeat.o(48304);
    }

    public final int getLayoutId() {
        return -1;
    }

    private void adj(String str) {
        int i;
        Intent intent;
        AppMethodBeat.i(48305);
        if (bo.isNullOrNil(str)) {
            com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
            i = 1;
        } else {
            String str2 = (String) this.tSm.get("openview");
            Intent intent2;
            if ("open_wcpay_biz_view".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
                com.tencent.mm.pluginsdk.wallet.h.fV(this.mController.ylL);
                i = 1;
            } else if ("open_wcpay_balance_view".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
                com.tencent.mm.pluginsdk.wallet.h.ak(this.mController.ylL, 0);
                i = 1;
            } else if ("open_wcpay_order_detail_view".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
                intent2 = new Intent();
                intent2.putExtra("trans_id", (String) this.tSm.get("trans_id"));
                intent2.putExtra("scene", 1);
                if (this.tSm.containsKey("bill_id")) {
                    intent2.putExtra("bill_id", (String) this.tSm.get("bill_id"));
                }
                d.b(this.mController.ylL, "order", ".ui.MallOrderTransactionInfoUI", intent2);
                i = 1;
            } else if ("open_wcpay_f2f_receive_detail".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
                intent2 = new Intent();
                intent2.putExtra("key_timestamp", bo.getLong((String) this.tSm.get("fromtimestamp"), 0));
                intent2.putExtra("key_from_scene", 1);
                d.b(this.mController.ylL, "collect", ".ui.CollectBillUI", intent2);
                h.pYm.e(13944, Integer.valueOf(2));
                i = 1;
            } else if ("open_wcpay_grouppay_detail".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
                intent2 = new Intent();
                intent2.putExtra("bill_no", (String) this.tSm.get("billno"));
                intent2.putExtra("chatroom", (String) this.tSm.get("groupid"));
                intent2.putExtra("key_sign", (String) this.tSm.get("sign"));
                intent2.putExtra("key_ver", (String) this.tSm.get("ver"));
                intent2.putExtra("enter_scene", 5);
                d.b(this.mController.ylL, "aa", ".ui.PaylistAAUI", intent2);
                i = 1;
            } else if ("open_wcpay_t2bc_detail".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
                intent2 = new Intent();
                intent2.putExtra("key_transfer_bill_id", (String) this.tSm.get("transfer_bill_id"));
                intent2.putExtra("key_enter_scene", 1);
                d.b(this.mController.ylL, "remittance", ".bankcard.ui.BankRemitDetailUI", intent2);
                i = 1;
            } else if ("open_honey_pay_home".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "do open honey pay view");
                d.b(this.mController.ylL, "honey_pay", ".ui.HoneyPayMainUI", new Intent());
                i = 1;
            } else if ("open_wcpay_t2bc_view".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_T2BC_UI");
                d.b(this.mController.ylL, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", new Intent());
                i = 1;
            } else if ("open_wcpay_fetch_balance_view".equals(str2)) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_FETCH_BALANCE_UI");
                uj ujVar = new uj();
                ujVar.cQB.context = this.mController.ylL;
                com.tencent.mm.sdk.b.a.xxA.m(ujVar);
                i = 1;
            } else if ("open_wcpay_wallet_lock_view".equals(str2)) {
                intent2 = new Intent();
                intent2.putExtra("wallet_lock_jsapi_scene", (String) this.tSm.get("entry_scene"));
                ((b) g.K(b.class)).b(this, intent2);
                i = 1;
            } else if ("open_wcpay_security_setting_view".equals(str2)) {
                intent2 = new Intent();
                intent2.putExtra("wallet_lock_jsapi_scene", (String) this.tSm.get("entry_scene"));
                d.b((Context) this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent2);
                i = 1;
            } else {
                String str3;
                if ("open_wcpay_c2c_message_view".equals(str2)) {
                    if (this.tSm != null) {
                        if (bo.getInt((String) this.tSm.get("bizType"), -1) == 1) {
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "view open c2c message view, bizType: %s, bizId: %s, username: %s, createTime: %s", Integer.valueOf(r5), (String) this.tSm.get("bizId"), (String) this.tSm.get("username"), Long.valueOf(bo.getLong((String) this.tSm.get("createTime"), -1)));
                            ix ixVar = new ix();
                            ixVar.cDZ.cEa = str2;
                            ixVar.cDZ.username = str3;
                            ixVar.cDZ.cEb = Long.valueOf(r6);
                            com.tencent.mm.sdk.b.a.xxA.m(ixVar);
                        }
                        i = 1;
                    }
                } else if ("open_lqt_auto_planindex_view".equals(str2)) {
                    d.b(this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtPlanHomeUI", new Intent());
                    i = 1;
                } else if ("open_lqt_auto_planadd_view".equals(str2)) {
                    Intent intent3 = new Intent(this, WalletLqtPlanAddUI.class);
                    intent3.putExtra("key_mode", 1);
                    startActivity(intent3);
                    i = 1;
                } else if ("open_wcpay_lqt_save".equals(str2)) {
                    ab.ach((String) this.tSm.get("trace_info"));
                    str2 = (String) this.tSm.get("operate_id");
                    final Dialog b = com.tencent.mm.wallet_core.ui.g.b(this.mController.ylL, false, null);
                    new l().acy().b(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bnr>>() {
                        public final /* synthetic */ Object call(Object obj) {
                            boolean z = true;
                            AppMethodBeat.i(48300);
                            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                            b.dismiss();
                            if (aVar.errType == 0 && aVar.errCode == 0) {
                                bnr bnr = (bnr) aVar.fsy;
                                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(bnr.kdT), bnr.kdU);
                                if (bnr.kdT == 0) {
                                    boolean z2;
                                    ab.ach(bnr.tgu);
                                    ArrayList arrayList = new ArrayList();
                                    if (bnr.wQx != null && bnr.wQx.size() > 0) {
                                        Iterator it = bnr.wQx.iterator();
                                        while (it.hasNext()) {
                                            xg xgVar = (xg) it.next();
                                            if (!(bo.isNullOrNil(xgVar.title) || bo.isNullOrNil(xgVar.wdd))) {
                                                arrayList.add(String.format("%s||%s", new Object[]{xgVar.title, xgVar.wdd}));
                                            }
                                        }
                                    }
                                    ((r) new c().a(WalletOpenViewProxyUI.this.mController.ylL, r.class)).tfF.ge(bnr.wao, bo.ank((String) WalletOpenViewProxyUI.this.tSm.get("entry_scene")));
                                    Intent intent = new Intent(WalletOpenViewProxyUI.this.mController.ylL, WalletLqtSaveFetchUI.class);
                                    intent.putExtra("lqt_save_fund_code", bnr != null ? bnr.wPv : null);
                                    intent.putExtra("lqt_save_fetch_mode", 1);
                                    String str = "lqt_is_show_protocol";
                                    if (bnr.cRh == 1) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    intent.putExtra(str, z2);
                                    String str2 = "lqt_is_agree_protocol";
                                    if (bnr.wQw != 1) {
                                        z = false;
                                    }
                                    intent.putExtra(str2, z);
                                    intent.putStringArrayListExtra("lqt_protocol_list", arrayList);
                                    intent.putExtra("lqt_profile_wording", bnr.wQp);
                                    intent.putExtra("lqt_account_type", bnr.wao);
                                    intent.putExtra("lqt_fund_spid", bnr.wPx);
                                    intent.putExtra("operate_id", str2);
                                    WalletOpenViewProxyUI.this.startActivity(intent);
                                }
                            }
                            WalletOpenViewProxyUI.this.finish();
                            Void voidR = zXH;
                            AppMethodBeat.o(48300);
                            return voidR;
                        }
                    });
                    i = 0;
                } else if ("open_wcpay_grouppay_introview".equals(str2)) {
                    str2 = (String) this.tSm.get("amount");
                    str3 = (String) this.tSm.get("title");
                    intent = new Intent();
                    intent.putExtra("amount", str2);
                    if (!bo.isNullOrNil(str3)) {
                        str3 = URLDecoder.decode(str3);
                        intent.putExtra("title", str3);
                    }
                    intent.putExtra("enter_scene", 5);
                    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", str2, str3);
                    d.b((Context) this, "aa", ".ui.AAEntranceUI", intent);
                    i = 1;
                } else {
                    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : ".concat(String.valueOf(str2)));
                }
                i = 1;
            }
        }
        intent = new Intent();
        intent.putExtra("closeWebView", (String) this.tSm.get("closeWebView"));
        setResult(-1, intent);
        if (i != 0) {
            finish();
        }
        AppMethodBeat.o(48305);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48306);
        if (i == 563) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "select chatroom：%s", stringExtra);
                String str = (String) this.tSm.get("amount");
                String str2 = (String) this.tSm.get("title");
                Intent intent2 = new Intent();
                intent2.putExtra("amount", str);
                if (!bo.isNullOrNil(str2)) {
                    str2 = URLDecoder.decode(str2);
                    intent2.putExtra("title", str2);
                }
                if (!bo.isNullOrNil(stringExtra)) {
                    intent2.putExtra("chatroom_name", stringExtra);
                }
                intent2.putExtra("enter_scene", 5);
                d.b(this.mController.ylL, "aa", ".ui.LaunchAAUI", intent2);
                com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", str, str2);
            }
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(48306);
    }
}
