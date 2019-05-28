package com.tencent.p177mm.plugin.wallet_index.p566ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p230g.p231a.C18414uj;
import com.tencent.p177mm.p230g.p231a.C37741ix;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.luckymoney.p987a.C12405a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14103ab;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14105ad;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C35397l;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C4314r;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtPlanAddUI;
import com.tencent.p177mm.plugin.wallet.balance.p552ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C22558a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C40096u;
import com.tencent.p177mm.plugin.walletlock.p1418a.C40167b;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.protocal.protobuf.C44191xg;
import com.tencent.p177mm.protocal.protobuf.bhd;
import com.tencent.p177mm.protocal.protobuf.bnr;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.app.C40919c;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.wallet_index.ui.WalletOpenViewProxyUI */
public class WalletOpenViewProxyUI extends WalletBaseUI {
    private Map<String, String> tSm = new HashMap();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletOpenViewProxyUI() {
        AppMethodBeat.m2504i(48301);
        AppMethodBeat.m2505o(48301);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48302);
        super.onCreate(bundle);
        mo9439AM(8);
        String stringExtra = getIntent().getStringExtra("packageExt");
        this.tSm = new HashMap();
        if (!C5046bo.isNullOrNil(stringExtra)) {
            String[] split = stringExtra.split("&");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    if (!C5046bo.isNullOrNil(split[i])) {
                        String[] split2 = split[i].split("=");
                        if (split2.length == 2 && !C5046bo.isNullOrNil(split2[0])) {
                            this.tSm.put(split2[0], split2[1]);
                        }
                    }
                }
            }
        }
        stringExtra = (String) this.tSm.get("trace_info");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            C14103ab.ach(stringExtra);
        }
        mo39992nf(2996);
        mo39992nf(580);
        mo39992nf(385);
        if (getIntent() == null) {
            C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            AppMethodBeat.m2505o(48302);
            return;
        }
        stringExtra = (String) this.tSm.get("openview");
        String stringExtra2 = getIntent().getStringExtra("appId");
        String stringExtra3 = getIntent().getStringExtra("timeStamp");
        String stringExtra4 = getIntent().getStringExtra("nonceStr");
        String stringExtra5 = getIntent().getStringExtra("packageExt");
        String stringExtra6 = getIntent().getStringExtra("paySignature");
        if ("open_wcpay_f2f_receive_detail".equals(stringExtra)) {
            mo39970a(new C40096u(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6), true, false);
            AppMethodBeat.m2505o(48302);
        } else if ("open_wcpay_grouppay_detail".equals(stringExtra)) {
            adj(stringExtra5);
            AppMethodBeat.m2505o(48302);
        } else if ("open_wcpay_lqt_detail".equals(stringExtra)) {
            C4990ab.m7416i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
            if (this.tSm != null) {
                new Intent().putExtra("key_account_type", 1);
                stringExtra = (String) this.tSm.get("ecardtype");
                C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", stringExtra, (String) this.tSm.get("extradata"), (String) this.tSm.get("need_open_lqb"));
                if (C5046bo.getInt((String) this.tSm.get("need_open_lqb"), 0) == 1) {
                    if (C5046bo.isNullOrNil(stringExtra)) {
                        stringExtra = "WEB_DEBIT";
                    }
                    mo39970a(new C14105ad(stringExtra, stringExtra2), true, false);
                } else {
                    C25985d.m41448H(this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    setResult(-1);
                    finish();
                }
            } else {
                C25985d.m41448H(this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                setResult(-1);
                finish();
            }
            C7060h.pYm.mo8378a(663, 18, 1, false);
            AppMethodBeat.m2505o(48302);
        } else if ("redenvelopes_getshowresouces_and_move_to_root".equals(stringExtra)) {
            C4990ab.m7416i("MicroMsg.WalletOpenViewProxyUI", "receive envelope");
            ((C12405a) C1720g.m3528K(C12405a.class)).bKL();
            setResult(-1);
            finish();
            AppMethodBeat.m2505o(48302);
        } else {
            String str = stringExtra2;
            String str2 = stringExtra3;
            String str3 = stringExtra4;
            String str4 = stringExtra5;
            String str5 = stringExtra6;
            mo39970a(new C22558a(str, str2, str3, str4, getIntent().getStringExtra("signtype"), str5, getIntent().getStringExtra("url"), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)), true, false);
            AppMethodBeat.m2505o(48302);
        }
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48303);
        C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i), Integer.valueOf(i2), str, c1207m);
        if (i != 0 || i2 != 0) {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(48303);
            return true;
        } else if (c1207m instanceof C22558a) {
            C46512f.akr(((C22558a) c1207m).cOS());
            adj(getIntent().getStringExtra("packageExt"));
            AppMethodBeat.m2505o(48303);
            return true;
        } else if (c1207m instanceof C40096u) {
            adj(getIntent().getStringExtra("packageExt"));
            AppMethodBeat.m2505o(48303);
            return true;
        } else if (c1207m instanceof C14105ad) {
            bhd bhd = ((C14105ad) c1207m).tgw;
            C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", Integer.valueOf(bhd.kdT), bhd.kdU);
            if (bhd.kdT == 0) {
                Intent intent = new Intent();
                intent.putExtra("key_account_type", 2);
                C25985d.m41467b(this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                setResult(-1);
            } else {
                Toast.makeText(this, bhd.kdU, 1).show();
                setResult(0);
            }
            finish();
            AppMethodBeat.m2505o(48303);
            return true;
        } else {
            AppMethodBeat.m2505o(48303);
            return false;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48304);
        super.onDestroy();
        mo39993ng(580);
        mo39993ng(385);
        mo39993ng(2996);
        AppMethodBeat.m2505o(48304);
    }

    public final int getLayoutId() {
        return -1;
    }

    private void adj(String str) {
        int i;
        Intent intent;
        AppMethodBeat.m2504i(48305);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
            i = 1;
        } else {
            String str2 = (String) this.tSm.get("openview");
            Intent intent2;
            if ("open_wcpay_biz_view".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
                C35899h.m58866fV(this.mController.ylL);
                i = 1;
            } else if ("open_wcpay_balance_view".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
                C35899h.m58862ak(this.mController.ylL, 0);
                i = 1;
            } else if ("open_wcpay_order_detail_view".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
                intent2 = new Intent();
                intent2.putExtra("trans_id", (String) this.tSm.get("trans_id"));
                intent2.putExtra("scene", 1);
                if (this.tSm.containsKey("bill_id")) {
                    intent2.putExtra("bill_id", (String) this.tSm.get("bill_id"));
                }
                C25985d.m41467b(this.mController.ylL, "order", ".ui.MallOrderTransactionInfoUI", intent2);
                i = 1;
            } else if ("open_wcpay_f2f_receive_detail".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
                intent2 = new Intent();
                intent2.putExtra("key_timestamp", C5046bo.getLong((String) this.tSm.get("fromtimestamp"), 0));
                intent2.putExtra("key_from_scene", 1);
                C25985d.m41467b(this.mController.ylL, "collect", ".ui.CollectBillUI", intent2);
                C7060h.pYm.mo8381e(13944, Integer.valueOf(2));
                i = 1;
            } else if ("open_wcpay_grouppay_detail".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
                intent2 = new Intent();
                intent2.putExtra("bill_no", (String) this.tSm.get("billno"));
                intent2.putExtra("chatroom", (String) this.tSm.get("groupid"));
                intent2.putExtra("key_sign", (String) this.tSm.get("sign"));
                intent2.putExtra("key_ver", (String) this.tSm.get("ver"));
                intent2.putExtra("enter_scene", 5);
                C25985d.m41467b(this.mController.ylL, "aa", ".ui.PaylistAAUI", intent2);
                i = 1;
            } else if ("open_wcpay_t2bc_detail".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
                intent2 = new Intent();
                intent2.putExtra("key_transfer_bill_id", (String) this.tSm.get("transfer_bill_id"));
                intent2.putExtra("key_enter_scene", 1);
                C25985d.m41467b(this.mController.ylL, "remittance", ".bankcard.ui.BankRemitDetailUI", intent2);
                i = 1;
            } else if ("open_honey_pay_home".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "do open honey pay view");
                C25985d.m41467b(this.mController.ylL, "honey_pay", ".ui.HoneyPayMainUI", new Intent());
                i = 1;
            } else if ("open_wcpay_t2bc_view".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_T2BC_UI");
                C25985d.m41467b(this.mController.ylL, "remittance", ".bankcard.ui.BankRemitBankcardInputUI", new Intent());
                i = 1;
            } else if ("open_wcpay_fetch_balance_view".equals(str2)) {
                C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "do open VIEW_OPEN_FETCH_BALANCE_UI");
                C18414uj c18414uj = new C18414uj();
                c18414uj.cQB.context = this.mController.ylL;
                C4879a.xxA.mo10055m(c18414uj);
                i = 1;
            } else if ("open_wcpay_wallet_lock_view".equals(str2)) {
                intent2 = new Intent();
                intent2.putExtra("wallet_lock_jsapi_scene", (String) this.tSm.get("entry_scene"));
                ((C40167b) C1720g.m3528K(C40167b.class)).mo38290b(this, intent2);
                i = 1;
            } else if ("open_wcpay_security_setting_view".equals(str2)) {
                intent2 = new Intent();
                intent2.putExtra("wallet_lock_jsapi_scene", (String) this.tSm.get("entry_scene"));
                C25985d.m41467b((Context) this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent2);
                i = 1;
            } else {
                String str3;
                if ("open_wcpay_c2c_message_view".equals(str2)) {
                    if (this.tSm != null) {
                        if (C5046bo.getInt((String) this.tSm.get("bizType"), -1) == 1) {
                            C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "view open c2c message view, bizType: %s, bizId: %s, username: %s, createTime: %s", Integer.valueOf(r5), (String) this.tSm.get("bizId"), (String) this.tSm.get("username"), Long.valueOf(C5046bo.getLong((String) this.tSm.get("createTime"), -1)));
                            C37741ix c37741ix = new C37741ix();
                            c37741ix.cDZ.cEa = str2;
                            c37741ix.cDZ.username = str3;
                            c37741ix.cDZ.cEb = Long.valueOf(r6);
                            C4879a.xxA.mo10055m(c37741ix);
                        }
                        i = 1;
                    }
                } else if ("open_lqt_auto_planindex_view".equals(str2)) {
                    C25985d.m41467b(this.mController.ylL, "wallet", ".balance.ui.lqt.WalletLqtPlanHomeUI", new Intent());
                    i = 1;
                } else if ("open_lqt_auto_planadd_view".equals(str2)) {
                    Intent intent3 = new Intent(this, WalletLqtPlanAddUI.class);
                    intent3.putExtra("key_mode", 1);
                    startActivity(intent3);
                    i = 1;
                } else if ("open_wcpay_lqt_save".equals(str2)) {
                    C14103ab.ach((String) this.tSm.get("trace_info"));
                    str2 = (String) this.tSm.get("operate_id");
                    final Dialog b = C30901g.m49318b(this.mController.ylL, false, null);
                    new C35397l().acy().mo60487b(new C5681a<Void, C37441a<bnr>>() {
                        public final /* synthetic */ Object call(Object obj) {
                            boolean z = true;
                            AppMethodBeat.m2504i(48300);
                            C37441a c37441a = (C37441a) obj;
                            C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
                            b.dismiss();
                            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                                bnr bnr = (bnr) c37441a.fsy;
                                C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(bnr.kdT), bnr.kdU);
                                if (bnr.kdT == 0) {
                                    boolean z2;
                                    C14103ab.ach(bnr.tgu);
                                    ArrayList arrayList = new ArrayList();
                                    if (bnr.wQx != null && bnr.wQx.size() > 0) {
                                        Iterator it = bnr.wQx.iterator();
                                        while (it.hasNext()) {
                                            C44191xg c44191xg = (C44191xg) it.next();
                                            if (!(C5046bo.isNullOrNil(c44191xg.title) || C5046bo.isNullOrNil(c44191xg.wdd))) {
                                                arrayList.add(String.format("%s||%s", new Object[]{c44191xg.title, c44191xg.wdd}));
                                            }
                                        }
                                    }
                                    ((C4314r) new C40919c().mo64541a(WalletOpenViewProxyUI.this.mController.ylL, C4314r.class)).tfF.mo9336ge(bnr.wao, C5046bo.ank((String) WalletOpenViewProxyUI.this.tSm.get("entry_scene")));
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
                            AppMethodBeat.m2505o(48300);
                            return voidR;
                        }
                    });
                    i = 0;
                } else if ("open_wcpay_grouppay_introview".equals(str2)) {
                    str2 = (String) this.tSm.get("amount");
                    str3 = (String) this.tSm.get("title");
                    intent = new Intent();
                    intent.putExtra("amount", str2);
                    if (!C5046bo.isNullOrNil(str3)) {
                        str3 = URLDecoder.decode(str3);
                        intent.putExtra("title", str3);
                    }
                    intent.putExtra("enter_scene", 5);
                    C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", str2, str3);
                    C25985d.m41467b((Context) this, "aa", ".ui.AAEntranceUI", intent);
                    i = 1;
                } else {
                    C4990ab.m7410d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : ".concat(String.valueOf(str2)));
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
        AppMethodBeat.m2505o(48305);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(48306);
        if (i == 563) {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "select chatroom：%s", stringExtra);
                String str = (String) this.tSm.get("amount");
                String str2 = (String) this.tSm.get("title");
                Intent intent2 = new Intent();
                intent2.putExtra("amount", str);
                if (!C5046bo.isNullOrNil(str2)) {
                    str2 = URLDecoder.decode(str2);
                    intent2.putExtra("title", str2);
                }
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    intent2.putExtra("chatroom_name", stringExtra);
                }
                intent2.putExtra("enter_scene", 5);
                C25985d.m41467b(this.mController.ylL, "aa", ".ui.LaunchAAUI", intent2);
                C4990ab.m7417i("MicroMsg.WalletOpenViewProxyUI", "view open grouppay, amount: %s, title: %s", str, str2);
            }
            finish();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(48306);
    }
}
