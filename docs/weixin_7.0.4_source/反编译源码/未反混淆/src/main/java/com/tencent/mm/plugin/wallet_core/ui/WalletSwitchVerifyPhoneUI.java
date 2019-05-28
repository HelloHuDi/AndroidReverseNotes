package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.e;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemGroupView;
import com.tencent.mm.plugin.wallet_core.ui.view.SwitchPhoneItemView;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@a(19)
public class WalletSwitchVerifyPhoneUI extends WalletBaseUI {
    private SwitchPhoneItemGroupView tKM;
    private List<gz> tKN;
    public boolean tKO = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47673);
        overridePendingTransition(R.anim.cg, R.anim.s);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.ftp));
        initView();
        this.tKO = this.mBundle.getBoolean("key_block_bind_new_card", false);
        if (!this.tKO) {
            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.ylL);
            switchPhoneItemView.setTag(Integer.valueOf(-1));
            switchPhoneItemView.a(getString(R.string.ftl), null);
            this.tKM.a(switchPhoneItemView, -1);
        }
        if (dOD() != null && dOD().bxP().equals("PayProcess") && this.mBundle.getInt("key_can_verify_tail", 0) == 1) {
            ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "show verify id card item");
            String string = getString(R.string.ffq);
            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.ylL, (int) R.layout.b69);
            switchPhoneItemView2.setTag(Integer.valueOf(-2));
            switchPhoneItemView2.a(string, null);
            this.tKM.a(switchPhoneItemView2, -1);
        }
        nf(1667);
        nf(461);
        nf(1505);
        a(new e(cNH()), true, true);
        AppMethodBeat.o(47673);
    }

    public final void initView() {
        AppMethodBeat.i(47674);
        this.tKM = (SwitchPhoneItemGroupView) findViewById(R.id.fhf);
        this.tKM.setOnItemSelectListener(new SwitchPhoneItemGroupView.a() {
            public final void eo(View view) {
                AppMethodBeat.i(47670);
                if (view.getTag() != null) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    ab.d("MicroMsg.WalletSwitchVerifyPhoneUI", "index: %d", Integer.valueOf(intValue));
                    if (intValue == -1) {
                        ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do bind new card");
                        WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this);
                        AppMethodBeat.o(47670);
                        return;
                    } else if (intValue == -2) {
                        ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "do verify idcard tail");
                        WalletSwitchVerifyPhoneUI.this.mBundle.putBoolean("key_forward_to_id_verify", true);
                        com.tencent.mm.wallet_core.a.j(WalletSwitchVerifyPhoneUI.this, WalletSwitchVerifyPhoneUI.this.mBundle);
                        AppMethodBeat.o(47670);
                        return;
                    } else {
                        gz gzVar = (gz) WalletSwitchVerifyPhoneUI.this.tKN.get(intValue);
                        WalletSwitchVerifyPhoneUI.this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                        WalletSwitchVerifyPhoneUI.this.mBundle.putBoolean("key_forward_to_id_verify", false);
                        ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "select wx phone: %s", Boolean.valueOf(gzVar.vJB.equals("wx")));
                        WalletSwitchVerifyPhoneUI.this.dOE().p(gzVar);
                    }
                }
                AppMethodBeat.o(47670);
            }
        });
        AppMethodBeat.o(47674);
    }

    public void onDestroy() {
        AppMethodBeat.i(47675);
        super.onDestroy();
        ng(1667);
        ng(461);
        ng(1505);
        AppMethodBeat.o(47675);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47676);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof e) {
                e eVar = (e) mVar;
                this.tKN = ((e) mVar).ttO.wmz;
                if (this.tKN != null) {
                    Collections.sort(this.tKN, new Comparator<gz>() {
                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            AppMethodBeat.i(47671);
                            gz gzVar = (gz) obj;
                            gz gzVar2 = (gz) obj2;
                            if (gzVar == null || gzVar2 == null) {
                                AppMethodBeat.o(47671);
                                return 0;
                            } else if (gzVar.vJB.equals("wx") && gzVar2.vJB.equals("cft")) {
                                AppMethodBeat.o(47671);
                                return -1;
                            } else if (gzVar.vJB.equals("cft") && gzVar2.vJB.equals("wx")) {
                                AppMethodBeat.o(47671);
                                return 1;
                            } else {
                                AppMethodBeat.o(47671);
                                return 0;
                            }
                        }
                    });
                }
                if (eVar.ttO.wmA != null) {
                    um umVar = eVar.ttO.wmA;
                    this.mBundle.putString("key_true_name", umVar.twd);
                    this.mBundle.putString("key_cre_name", umVar.wca);
                    this.mBundle.putString("key_cre_type", umVar.tCl);
                }
                if (this.tKN == null || this.tKN.isEmpty()) {
                    ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "empty mobile info");
                } else {
                    for (int size = this.tKN.size() - 1; size >= 0; size--) {
                        final gz gzVar = (gz) this.tKN.get(size);
                        if (gzVar.vJB.equals("cft")) {
                            String string;
                            CharSequence spannableString;
                            SwitchPhoneItemView switchPhoneItemView = new SwitchPhoneItemView(this.mController.ylL);
                            if (gzVar.vJC.equals("1")) {
                                string = getString(R.string.fto);
                            } else {
                                string = getString(R.string.ftn);
                            }
                            String string2 = getString(R.string.ftm, new Object[]{gzVar.nuL, string, gzVar.vJD});
                            if (this.tKO) {
                                spannableString = new SpannableString(string2);
                            } else {
                                String string3 = getString(R.string.ftr);
                                j jVar = new j(this);
                                string2 = string2 + "，";
                                jVar.mColor = getResources().getColor(R.color.hb);
                                spannableString = new SpannableString(string2 + string3);
                                spannableString.setSpan(jVar, string2.length(), string2.length() + string3.length(), 33);
                                jVar.tHw = new j.a() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(47672);
                                        ab.d("MicroMsg.WalletSwitchVerifyPhoneUI", "span click");
                                        WalletSwitchVerifyPhoneUI.a(WalletSwitchVerifyPhoneUI.this, gzVar);
                                        AppMethodBeat.o(47672);
                                    }
                                };
                            }
                            switchPhoneItemView.setTag(Integer.valueOf(size));
                            switchPhoneItemView.a(gzVar.tuk, spannableString);
                            this.tKM.a(switchPhoneItemView, 0);
                        } else {
                            SwitchPhoneItemView switchPhoneItemView2 = new SwitchPhoneItemView(this.mController.ylL);
                            switchPhoneItemView2.setTag(Integer.valueOf(size));
                            switchPhoneItemView2.a(gzVar.tuk, getString(R.string.fts));
                            this.tKM.a(switchPhoneItemView2, 0);
                        }
                    }
                }
                AppMethodBeat.o(47676);
                return true;
            } else if (mVar instanceof t) {
                cNI();
            }
        }
        AppMethodBeat.o(47676);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b6a;
    }

    public final boolean cNR() {
        return true;
    }

    private void cNI() {
        AppMethodBeat.i(47677);
        ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "directToNext()");
        Authen authen = (Authen) this.mBundle.getParcelable("key_authen");
        Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        if (authen == null || bankcard == null) {
            ab.w("MicroMsg.WalletSwitchVerifyPhoneUI", "authen or bankcard is null");
            AppMethodBeat.o(47677);
            return;
        }
        ElementQuery acy = r.cPQ().acy(bankcard.field_bankcardType);
        this.mBundle.putParcelable("elemt_query", acy);
        authen.pbn = bankcard.field_bankcardType;
        authen.pbo = bankcard.field_bindSerial;
        bankcard.field_bankPhone = acy.tyH;
        this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", true);
        this.mBundle.putBoolean("key_is_changing_balance_phone_num", true);
        this.mBundle.putInt("key_err_code", 418);
        com.tencent.mm.wallet_core.a.j(this, this.mBundle);
        AppMethodBeat.o(47677);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI) {
        AppMethodBeat.i(47678);
        walletSwitchVerifyPhoneUI.mBundle.putBoolean("key_is_changing_balance_phone_num", true);
        walletSwitchVerifyPhoneUI.mBundle.putInt("key_pay_flag", 2);
        com.tencent.mm.wallet_core.a.j(walletSwitchVerifyPhoneUI, walletSwitchVerifyPhoneUI.mBundle);
        AppMethodBeat.o(47678);
    }

    static /* synthetic */ void a(WalletSwitchVerifyPhoneUI walletSwitchVerifyPhoneUI, gz gzVar) {
        AppMethodBeat.i(47679);
        Bankcard bankcard = new Bankcard();
        bankcard.field_bindSerial = gzVar.pbo;
        bankcard.field_mobile = gzVar.tuk;
        bankcard.field_bankcardType = gzVar.pbn;
        bankcard.field_desc = gzVar.nuL;
        ab.d("MicroMsg.WalletSwitchVerifyPhoneUI", "serial: %s,mobile: %s, bankcardType: %s, desc: %s", bankcard.field_bindSerial, bankcard.field_mobile, bankcard.field_bankcardType, bankcard.field_bankName);
        walletSwitchVerifyPhoneUI.mBundle.putParcelable("key_bankcard", bankcard);
        if (r.cPQ().acy(bankcard.field_bankcardType) != null) {
            ab.i("MicroMsg.WalletSwitchVerifyPhoneUI", "go to reset directly");
            walletSwitchVerifyPhoneUI.cNI();
            AppMethodBeat.o(47679);
            return;
        }
        walletSwitchVerifyPhoneUI.a(new t("", "", null), true, false);
        AppMethodBeat.o(47679);
    }
}
