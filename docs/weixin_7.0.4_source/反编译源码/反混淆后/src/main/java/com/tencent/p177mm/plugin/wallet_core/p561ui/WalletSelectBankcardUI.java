package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MaxListView;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.List;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI */
public class WalletSelectBankcardUI extends WalletBaseUI {
    private int gOW = 0;
    private TextView kEs;
    private C43812a tKA = null;
    private String tKB = null;
    private boolean tKC = true;
    private String tKD = null;
    private List<Bankcard> tKE = null;
    private TextView tKy;
    private MaxListView tKz;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI$1 */
    class C44181 implements C29672a {
        C44181() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47652);
            C4990ab.m7416i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
            C36391e.m59999bU(WalletSelectBankcardUI.this, WalletSelectBankcardUI.this.getString(C25738R.string.f_4));
            AppMethodBeat.m2505o(47652);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI$2 */
    class C44202 implements OnItemClickListener {
        C44202() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(47655);
            final Bankcard bankcard = (Bankcard) adapterView.getItemAtPosition(i);
            if (bankcard != null) {
                C30379h.m48453a(WalletSelectBankcardUI.this, true, WalletSelectBankcardUI.this.getString(C25738R.string.fsp, new Object[]{bankcard.field_desc, bankcard.field_mobile}), WalletSelectBankcardUI.this.getString(C25738R.string.fsr), WalletSelectBankcardUI.this.getString(C25738R.string.fso), WalletSelectBankcardUI.this.getString(C25738R.string.fsq), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(47653);
                        WalletSelectBankcardUI.this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                        WalletSelectBankcardUI.m78535a(WalletSelectBankcardUI.this, bankcard);
                        C7060h.pYm.mo8381e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                        AppMethodBeat.m2505o(47653);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(47654);
                        WalletSelectBankcardUI.this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", true);
                        WalletSelectBankcardUI.m78535a(WalletSelectBankcardUI.this, bankcard);
                        AppMethodBeat.m2505o(47654);
                    }
                });
                AppMethodBeat.m2505o(47655);
                return;
            }
            WalletSelectBankcardUI.this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", false);
            WalletSelectBankcardUI.m78535a(WalletSelectBankcardUI.this, null);
            AppMethodBeat.m2505o(47655);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI$a */
    class C43812a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletSelectBankcardUI$a$a */
        class C29662a {
            TextView tKI;

            C29662a() {
            }
        }

        private C43812a() {
        }

        /* synthetic */ C43812a(WalletSelectBankcardUI walletSelectBankcardUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(47656);
            int size;
            if (WalletSelectBankcardUI.this.tKC) {
                if (WalletSelectBankcardUI.this.tKE == null) {
                    AppMethodBeat.m2505o(47656);
                    return 1;
                }
                size = WalletSelectBankcardUI.this.tKE.size() + 1;
                AppMethodBeat.m2505o(47656);
                return size;
            } else if (WalletSelectBankcardUI.this.tKE == null) {
                AppMethodBeat.m2505o(47656);
                return 0;
            } else {
                size = WalletSelectBankcardUI.this.tKE.size();
                AppMethodBeat.m2505o(47656);
                return size;
            }
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(47657);
            if (WalletSelectBankcardUI.this.tKE == null || WalletSelectBankcardUI.this.tKE.size() <= i) {
                AppMethodBeat.m2505o(47657);
                return null;
            }
            Object obj = WalletSelectBankcardUI.this.tKE.get(i);
            AppMethodBeat.m2505o(47657);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C29662a c29662a;
            AppMethodBeat.m2504i(47658);
            Bankcard bankcard = (Bankcard) getItem(i);
            if (view == null) {
                view = LayoutInflater.from(WalletSelectBankcardUI.this).inflate(2130971166, viewGroup, false);
                C29662a c29662a2 = new C29662a();
                c29662a2.tKI = (TextView) view.findViewById(2131829055);
                view.setTag(c29662a2);
                c29662a = c29662a2;
            } else {
                c29662a = (C29662a) view.getTag();
            }
            if (bankcard != null) {
                c29662a.tKI.setText(bankcard.field_desc);
            } else {
                c29662a.tKI.setText(C25738R.string.fst);
            }
            AppMethodBeat.m2505o(47658);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47659);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.f_0);
        this.gOW = this.mBundle.getInt("key_scene", 0);
        this.tKB = this.mBundle.getString("key_top_tips");
        this.tKC = this.mBundle.getBoolean("key_is_show_new_bankcard", true);
        this.tKD = this.mBundle.getString("bottom_tips");
        this.tKE = this.mBundle.getParcelableArrayList("key_showing_bankcards");
        if (this.tKE == null) {
            this.tKE = C14241r.cPI().cQB();
        }
        this.tKy = (TextView) findViewById(2131829056);
        this.tKz = (MaxListView) findViewById(2131829057);
        this.kEs = (TextView) findViewById(2131829058);
        if (C5046bo.isNullOrNil(this.tKB)) {
            this.tKy.setVisibility(8);
        } else {
            this.tKy.setVisibility(0);
            this.tKy.setText(this.tKB);
        }
        if (C5046bo.isNullOrNil(this.tKD)) {
            this.kEs.setVisibility(8);
        } else {
            this.kEs.setVisibility(0);
            this.kEs.setText(this.tKD);
        }
        if (this.gOW == 0) {
            this.kEs.setVisibility(0);
            C46373j c46373j = new C46373j(this);
            c46373j.tHw = new C44181();
            String string = getString(C25738R.string.fsn);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(c46373j, string.length() - 14, string.length(), 33);
            this.kEs.setText(spannableString);
            this.kEs.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.tKA = new C43812a(this, (byte) 0);
        this.tKz.setAdapter(this.tKA);
        this.tKz.setOnItemClickListener(new C44202());
        AppMethodBeat.m2505o(47659);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130971167;
    }

    public final boolean cNR() {
        return true;
    }

    /* renamed from: a */
    static /* synthetic */ void m78535a(WalletSelectBankcardUI walletSelectBankcardUI, Bankcard bankcard) {
        AppMethodBeat.m2504i(47660);
        walletSelectBankcardUI.mBundle.putParcelable("key_bankcard", bankcard);
        walletSelectBankcardUI.dOE().mo9366p(new Object[0]);
        AppMethodBeat.m2505o(47660);
    }
}
