package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.SwitchPhoneItemGroupView;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.SwitchPhoneItemGroupView.C4455a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.SwitchPhoneItemView;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.plugin.wallet_core.p749c.C43787e;
import com.tencent.p177mm.protocal.protobuf.C23395gz;
import com.tencent.p177mm.protocal.protobuf.C46591um;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI */
public class WalletSwitchVerifyPhoneUI extends WalletBaseUI {
    private SwitchPhoneItemGroupView tKM;
    private List<C23395gz> tKN;
    public boolean tKO = false;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI$2 */
    class C143012 implements Comparator<C23395gz> {
        C143012() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            AppMethodBeat.m2504i(47671);
            C23395gz c23395gz = (C23395gz) obj;
            C23395gz c23395gz2 = (C23395gz) obj2;
            if (c23395gz == null || c23395gz2 == null) {
                AppMethodBeat.m2505o(47671);
                return 0;
            } else if (c23395gz.vJB.equals("wx") && c23395gz2.vJB.equals("cft")) {
                AppMethodBeat.m2505o(47671);
                return -1;
            } else if (c23395gz.vJB.equals("cft") && c23395gz2.vJB.equals("wx")) {
                AppMethodBeat.m2505o(47671);
                return 1;
            } else {
                AppMethodBeat.m2505o(47671);
                return 0;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSwitchVerifyPhoneUI$1 */
    class C249021 implements C4455a {
        C249021() {
        }

        /* renamed from: eo */
        public final void mo9499eo(View view) {
            AppMethodBeat.m2504i(47670);
            if (view.getTag() != null) {
                int intValue = ((Integer) view.getTag()).intValue();
                C4990ab.m7411d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", Integer.valueOf(intValue));
                if (intValue == -1) {
                    C4990ab.m7416i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
                    WalletSwitchVerifyPhoneUI.m38917a(WalletSwitchVerifyPhoneUI.this);
                    AppMethodBeat.m2505o(47670);
                    return;
                } else if (intValue == -2) {
                    C4990ab.m7416i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
                    WalletSwitchVerifyPhoneUI.this.mBundle.putBoolean("key_forward_to_id_verify", true);
                    C24143a.m37116j(WalletSwitchVerifyPhoneUI.this, WalletSwitchVerifyPhoneUI.this.mBundle);
                    AppMethodBeat.m2505o(47670);
                    return;
                } else {
                    C23395gz c23395gz = (C23395gz) WalletSwitchVerifyPhoneUI.this.tKN.get(intValue);
                    WalletSwitchVerifyPhoneUI.this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                    WalletSwitchVerifyPhoneUI.this.mBundle.putBoolean("key_forward_to_id_verify", false);
                    C4990ab.m7417i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", Boolean.valueOf(c23395gz.vJB.equals("wx")));
                    WalletSwitchVerifyPhoneUI.this.dOE().mo9366p(c23395gz);
                }
            }
            AppMethodBeat.m2505o(47670);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47673);
        overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8293s);
        super.onCreate(bundle);
        setMMTitle(getString(C25738R.string.ftp));
        initView();
        this.tKO = this.mBundle.getBoolean("key_block_bind_new_card", false);
        if (!this.tKO) {
            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.ylL);
            switchPhoneItemView.setTag(Integer.valueOf(-1));
            switchPhoneItemView.mo63487a(getString(C25738R.string.ftl), null);
            this.tKM.mo69499a(switchPhoneItemView, -1);
        }
        if (dOD() != null && dOD().bxP().equals("PayProcess") && this.mBundle.getInt("key_can_verify_tail", 0) == 1) {
            C4990ab.m7416i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
            String string = getString(C25738R.string.ffq);
            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.ylL, 2130971172);
            switchPhoneItemView2.setTag(Integer.valueOf(-2));
            switchPhoneItemView2.mo63487a(string, null);
            this.tKM.mo69499a(switchPhoneItemView2, -1);
        }
        mo39992nf(1667);
        mo39992nf(461);
        mo39992nf(1505);
        mo39970a(new C43787e(cNH()), true, true);
        AppMethodBeat.m2505o(47673);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47674);
        this.tKM = (SwitchPhoneItemGroupView) findViewById(2131829069);
        this.tKM.setOnItemSelectListener(new C249021());
        AppMethodBeat.m2505o(47674);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47675);
        super.onDestroy();
        mo39993ng(1667);
        mo39993ng(461);
        mo39993ng(1505);
        AppMethodBeat.m2505o(47675);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47676);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C43787e) {
                C43787e c43787e = (C43787e) c1207m;
                this.tKN = ((C43787e) c1207m).ttO.wmz;
                if (this.tKN != null) {
                    Collections.sort(this.tKN, new C143012());
                }
                if (c43787e.ttO.wmA != null) {
                    C46591um c46591um = c43787e.ttO.wmA;
                    this.mBundle.putString("key_true_name", c46591um.twd);
                    this.mBundle.putString("key_cre_name", c46591um.wca);
                    this.mBundle.putString("key_cre_type", c46591um.tCl);
                }
                if (this.tKN == null || this.tKN.isEmpty()) {
                    C4990ab.m7416i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
                } else {
                    for (int size = this.tKN.size() - 1; size >= 0; size--) {
                        final C23395gz c23395gz = (C23395gz) this.tKN.get(size);
                        if (c23395gz.vJB.equals("cft")) {
                            String string;
                            CharSequence spannableString;
                            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.ylL);
                            if (c23395gz.vJC.equals("1")) {
                                string = getString(C25738R.string.fto);
                            } else {
                                string = getString(C25738R.string.ftn);
                            }
                            String string2 = getString(C25738R.string.ftm, new Object[]{c23395gz.nuL, string, c23395gz.vJD});
                            if (this.tKO) {
                                spannableString = new SpannableString(string2);
                            } else {
                                String string3 = getString(C25738R.string.ftr);
                                C46373j c46373j = new C46373j(this);
                                string2 = string2 + "，";
                                c46373j.mColor = getResources().getColor(C25738R.color.f11788hb);
                                spannableString = new SpannableString(string2 + string3);
                                spannableString.setSpan(c46373j, string2.length(), string2.length() + string3.length(), 33);
                                c46373j.tHw = new C29672a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.m2504i(47672);
                                        C4990ab.m7410d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
                                        WalletSwitchVerifyPhoneUI.m38918a(WalletSwitchVerifyPhoneUI.this, c23395gz);
                                        AppMethodBeat.m2505o(47672);
                                    }
                                };
                            }
                            switchPhoneItemView.setTag(Integer.valueOf(size));
                            switchPhoneItemView.mo63487a(c23395gz.tuk, spannableString);
                            this.tKM.mo69499a(switchPhoneItemView, 0);
                        } else {
                            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.ylL);
                            switchPhoneItemView2.setTag(Integer.valueOf(size));
                            switchPhoneItemView2.mo63487a(c23395gz.tuk, getString(C25738R.string.fts));
                            this.tKM.mo69499a(switchPhoneItemView2, 0);
                        }
                    }
                }
                AppMethodBeat.m2505o(47676);
                return true;
            } else if (c1207m instanceof C14225t) {
                cNI();
            }
        }
        AppMethodBeat.m2505o(47676);
        return false;
    }

    public final int getLayoutId() {
        return 2130971174;
    }

    public final boolean cNR() {
        return true;
    }

    private void cNI() {
        AppMethodBeat.m2504i(47677);
        C4990ab.m7416i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
        Authen authen = (Authen) this.mBundle.getParcelable("key_authen");
        Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        if (authen == null || bankcard == null) {
            C4990ab.m7420w("MicroMsg.WalletSwitchVerifyPhoneUI", "authen or bankcard is null");
            AppMethodBeat.m2505o(47677);
            return;
        }
        ElementQuery acy = C14241r.cPQ().acy(bankcard.field_bankcardType);
        this.mBundle.putParcelable("elemt_query", acy);
        authen.pbn = bankcard.field_bankcardType;
        authen.pbo = bankcard.field_bindSerial;
        bankcard.field_bankPhone = acy.tyH;
        this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", true);
        this.mBundle.putBoolean("key_is_changing_balance_phone_num", true);
        this.mBundle.putInt("key_err_code", 418);
        C24143a.m37116j(this, this.mBundle);
        AppMethodBeat.m2505o(47677);
    }

    /* renamed from: a */
    static /* synthetic */ void m38917a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        AppMethodBeat.m2504i(47678);
        walletSwitchVerifyPhoneUI.mBundle.putBoolean("key_is_changing_balance_phone_num", true);
        walletSwitchVerifyPhoneUI.mBundle.putInt("key_pay_flag", 2);
        C24143a.m37116j(walletSwitchVerifyPhoneUI, walletSwitchVerifyPhoneUI.mBundle);
        AppMethodBeat.m2505o(47678);
    }

    /* renamed from: a */
    static /* synthetic */ void m38918a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, C23395gz c23395gz) {
        AppMethodBeat.m2504i(47679);
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = c23395gz.pbo;
        bankcard.field_mobile = c23395gz.tuk;
        bankcard.field_bankcardType = c23395gz.pbn;
        bankcard.field_desc = c23395gz.nuL;
        C4990ab.m7411d("MicroMsg.WalletSwitchVerifyPhoneUI", "serial: %s,mobile: %s, bankcardType: %s, desc: %s", bankcard.field_bindSerial, bankcard.field_mobile, bankcard.field_bankcardType, bankcard.field_bankName);
        walletSwitchVerifyPhoneUI.mBundle.putParcelable("key_bankcard", bankcard);
        if (C14241r.cPQ().acy(bankcard.field_bankcardType) != null) {
            C4990ab.m7416i("MicroMsg.WalletSwitchVerifyPhoneUI", "go to reset directly");
            walletSwitchVerifyPhoneUI.cNI();
            AppMethodBeat.m2505o(47679);
            return;
        }
        walletSwitchVerifyPhoneUI.mo39970a(new C14225t("", "", null), true, false);
        AppMethodBeat.m2505o(47679);
    }
}
