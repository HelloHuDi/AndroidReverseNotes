package com.tencent.mm.plugin.wxcredit.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wxcredit.a.d;
import com.tencent.mm.plugin.wxcredit.a.i;
import com.tencent.mm.plugin.wxcredit.a.k;
import com.tencent.mm.plugin.wxcredit.b;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;

@a(3)
public class WalletWXCreditDetailUI extends WalletPreferenceUI {
    private f ehK;
    private boolean hasInit = false;
    private OnClickListener qqV = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(48722);
            if (view.getId() == R.id.fi0) {
                if (WalletWXCreditDetailUI.this.uZw != null) {
                    e.af(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.uZw.uYO.username);
                    AppMethodBeat.o(48722);
                    return;
                }
            } else if (view.getId() == R.id.fi1 && WalletWXCreditDetailUI.this.uZw != null) {
                e.n(WalletWXCreditDetailUI.this, WalletWXCreditDetailUI.this.uZw.uYN, false);
            }
            AppMethodBeat.o(48722);
        }
    };
    private Bankcard tmw;
    private c uZv;
    private k uZw;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletWXCreditDetailUI() {
        AppMethodBeat.i(48725);
        AppMethodBeat.o(48725);
    }

    static /* synthetic */ void dgJ() {
    }

    public final int JC() {
        return R.xml.cw;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48726);
        super.onCreate(bundle);
        dOM().nf(com.tencent.mm.plugin.appbrand.weishi.f.CTRL_INDEX);
        dOM().nf(600);
        AM(4);
        this.uZv = com.tencent.mm.wallet_core.a.aE(this);
        if (this.tmw == null) {
            this.tmw = (Bankcard) this.uZv.mqu.getParcelable("key_bankcard");
        }
        if (dgI()) {
            if (this.Ahs == null) {
                if (this.Ahq == null) {
                    this.Ahq = com.tencent.mm.wallet_core.a.aE(this);
                }
                this.Ahs = this.Ahq.a((MMActivity) this, this.Ahr);
            }
            if (!this.Ahs.w(this.tmw)) {
                AM(0);
                initView();
            }
        }
        AppMethodBeat.o(48726);
    }

    private boolean dgI() {
        AppMethodBeat.i(48727);
        if (this.tmw == null) {
            AppMethodBeat.o(48727);
            return false;
        } else if (this.tmw.field_bankcardState == 0) {
            AppMethodBeat.o(48727);
            return true;
        } else {
            int i = this.tmw.field_wxcreditState;
            if (this.uZw != null) {
                i = this.uZw.uYA;
            }
            switch (i) {
                case 1:
                    if (r.cPI().cQM()) {
                        AppMethodBeat.o(48727);
                        return true;
                    }
                    AppMethodBeat.o(48727);
                    return false;
                case 3:
                    h.a((Context) this, (int) R.string.fws, -1, false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48720);
                            WalletWXCreditDetailUI.this.dOM().a(new i(WalletWXCreditDetailUI.this.tmw.field_bankcardType, WalletWXCreditDetailUI.this.tmw.twO), true, 1);
                            AppMethodBeat.o(48720);
                        }
                    });
                    AppMethodBeat.o(48727);
                    return false;
                case 4:
                    break;
                case 5:
                    this.uZv.mqu.putBoolean("key_can_unbind", false);
                    break;
                default:
                    AppMethodBeat.o(48727);
                    return true;
            }
            if (this.uZw != null) {
                this.uZv.mqu.putString("key_repayment_url", this.uZw.uYI);
                this.uZv.a((Activity) this, 1, this.uZv.mqu);
                AppMethodBeat.o(48727);
                return false;
            }
            AppMethodBeat.o(48727);
            return true;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(48728);
        dOM().ng(com.tencent.mm.plugin.appbrand.weishi.f.CTRL_INDEX);
        dOM().ng(600);
        super.onDestroy();
        AppMethodBeat.o(48728);
    }

    public final void initView() {
        AppMethodBeat.i(48729);
        this.hasInit = true;
        setMMTitle((int) R.string.fwt);
        this.ehK = this.yCw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48721);
                WalletWXCreditDetailUI.this.aqX();
                WalletWXCreditDetailUI.this.finish();
                AppMethodBeat.o(48721);
                return true;
            }
        });
        ceo();
        AppMethodBeat.o(48729);
    }

    private void cu() {
        AppMethodBeat.i(48730);
        if (!this.hasInit) {
            initView();
        }
        if (this.uZw != null) {
            WalletWXCreditDetailHeaderPreference walletWXCreditDetailHeaderPreference = (WalletWXCreditDetailHeaderPreference) this.ehK.aqO("wallet_wxcredit_header");
            walletWXCreditDetailHeaderPreference.gng.setText(e.G(this.uZw.uYB));
            String str = this.tmw.field_bankName;
            String str2 = this.uZw.uYM;
            walletWXCreditDetailHeaderPreference.uZu.setText(walletWXCreditDetailHeaderPreference.mContext.getString(R.string.fxj, new Object[]{str2, str}));
        }
        if (this.uZw != null) {
            this.ehK.aqO("wallet_wxcredit_total_amount").setTitle(getString(R.string.fwu, new Object[]{e.G(this.uZw.uYv)}));
            this.ehK.ce("wallet_wxcredit_change_amount", !this.uZw.uYG);
            Preference aqO = this.ehK.aqO("wallet_wxcredit_bill");
            if (this.uZw.uYC != 0.0d) {
                aqO.setSummary(e.G(this.uZw.uYC));
            }
            aqO = this.ehK.aqO("wallet_wxcredit_repayment");
            Preference aqO2 = this.ehK.aqO("wallet_wxcredit_repayment_tips");
            if (this.uZw.uYE > 0.0d) {
                aqO.setSummary(e.G(this.uZw.uYE));
                aqO2.setTitle(getString(R.string.fxh, new Object[]{this.uZw.uYJ}));
                this.ehK.ce("wallet_wxcredit_repayment_tips", false);
            } else {
                this.ehK.ce("wallet_wxcredit_repayment_tips", true);
            }
        }
        if (this.tmw != null) {
            this.ehK.aqO("wallet_wxcredit_bank_name").setTitle(this.tmw.field_bankName);
        }
        ((WalletWXCreditDetailFooterPreference) this.ehK.aqO("wallet_wxcredit_footer")).qqV = this.qqV;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(48730);
    }

    public final boolean f(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48732);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof d) {
                r.cPI().tDc = System.currentTimeMillis() / 1000;
                this.uZw = ((d) mVar).uYw;
                if (this.uZw != null && this.uZw.uYA == 2) {
                    g.RQ();
                    if (((Boolean) g.RP().Ry().get(196658, Boolean.FALSE)).booleanValue()) {
                        c aE = com.tencent.mm.wallet_core.a.aE(this);
                        Bundle bundle = aE.mqu;
                        bundle.putDouble("key_total_amount", this.uZw.uYv);
                        bundle.putBoolean("key_can_upgrade_amount", this.uZw.uYG);
                        aE.a((Activity) this, WalletWXCreditOpenNotifyUI.class, bundle, 1);
                        AppMethodBeat.o(48732);
                        return true;
                    }
                }
                if (dgI()) {
                    AM(0);
                    cu();
                }
                AppMethodBeat.o(48732);
                return true;
            } else if (mVar instanceof i) {
                dOM().a(new y(), true, 1);
            } else if (mVar instanceof y) {
                finish();
            }
        }
        AppMethodBeat.o(48732);
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(48733);
        AM(0);
        cu();
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(48733);
    }

    private void ceo() {
        AppMethodBeat.i(48734);
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(48724);
                ArrayList arrayList = new ArrayList();
                r.cPI();
                WalletWXCreditDetailUI.this.tmw;
                h.a(WalletWXCreditDetailUI.this, null, (String[]) arrayList.toArray(new String[arrayList.size()]), WalletWXCreditDetailUI.this.getString(R.string.fgf), false, new h.c() {
                    public final void iE(int i) {
                        AppMethodBeat.i(48723);
                        switch (i) {
                            case 0:
                                r.cPI();
                                WalletWXCreditDetailUI.this.tmw;
                                WalletWXCreditDetailUI.dgJ();
                                AppMethodBeat.o(48723);
                                return;
                            case 1:
                                WalletWXCreditDetailUI.c(WalletWXCreditDetailUI.this);
                                break;
                        }
                        AppMethodBeat.o(48723);
                    }
                });
                AppMethodBeat.o(48724);
                return true;
            }
        });
        AppMethodBeat.o(48734);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(48731);
        String str = preference.mKey;
        if ("wallet_wxcredit_change_amount".equals(str)) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_bankcard", this.tmw);
            com.tencent.mm.wallet_core.a.a(this, b.class, bundle);
            AppMethodBeat.o(48731);
            return true;
        }
        Bundle bundle2;
        if ("wallet_wxcredit_bill".equals(str)) {
            if (this.uZw != null) {
                bundle2 = new Bundle();
                bundle2.putString("key_url", this.uZw.pPO);
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, bundle2);
            }
        } else if ("wallet_wxcredit_card_info".equals(str)) {
            if (this.uZw != null) {
                bundle2 = new Bundle();
                bundle2.putString("key_url", this.uZw.uYK);
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wxcredit.c.class, bundle2);
            }
        } else if ("wallet_wxcredit_right".equals(str)) {
            if (this.uZw != null) {
                e.n(this, this.uZw.uYL, false);
            }
        } else if ("wallet_wxcredit_repayment".equals(str)) {
            if (this.uZw != null) {
                e.n(this, this.uZw.uYI, false);
            }
        } else if ("wallet_wxcredit_bank_name".equals(str) && this.uZw != null) {
            e.ae(this, this.uZw.uYO.username);
        }
        AppMethodBeat.o(48731);
        return false;
    }

    static /* synthetic */ void c(WalletWXCreditDetailUI walletWXCreditDetailUI) {
        AppMethodBeat.i(48735);
        Bundle bundle = walletWXCreditDetailUI.uZv.mqu;
        bundle.putBoolean("offline_pay", false);
        bundle.putBoolean("key_is_show_detail", false);
        com.tencent.mm.wallet_core.a.a(walletWXCreditDetailUI, com.tencent.mm.plugin.wxcredit.f.class, bundle);
        AppMethodBeat.o(48735);
    }
}
