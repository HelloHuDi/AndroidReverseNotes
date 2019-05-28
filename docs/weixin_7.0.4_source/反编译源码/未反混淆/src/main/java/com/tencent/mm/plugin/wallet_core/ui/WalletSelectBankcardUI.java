package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletSelectBankcardUI extends WalletBaseUI {
    private int gOW = 0;
    private TextView kEs;
    private a tKA = null;
    private String tKB = null;
    private boolean tKC = true;
    private String tKD = null;
    private List<Bankcard> tKE = null;
    private TextView tKy;
    private MaxListView tKz;

    class a extends BaseAdapter {

        class a {
            TextView tKI;

            a() {
            }
        }

        private a() {
        }

        /* synthetic */ a(WalletSelectBankcardUI walletSelectBankcardUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.i(47656);
            int size;
            if (WalletSelectBankcardUI.this.tKC) {
                if (WalletSelectBankcardUI.this.tKE == null) {
                    AppMethodBeat.o(47656);
                    return 1;
                }
                size = WalletSelectBankcardUI.this.tKE.size() + 1;
                AppMethodBeat.o(47656);
                return size;
            } else if (WalletSelectBankcardUI.this.tKE == null) {
                AppMethodBeat.o(47656);
                return 0;
            } else {
                size = WalletSelectBankcardUI.this.tKE.size();
                AppMethodBeat.o(47656);
                return size;
            }
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(47657);
            if (WalletSelectBankcardUI.this.tKE == null || WalletSelectBankcardUI.this.tKE.size() <= i) {
                AppMethodBeat.o(47657);
                return null;
            }
            Object obj = WalletSelectBankcardUI.this.tKE.get(i);
            AppMethodBeat.o(47657);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(47658);
            Bankcard bankcard = (Bankcard) getItem(i);
            if (view == null) {
                view = LayoutInflater.from(WalletSelectBankcardUI.this).inflate(R.layout.b63, viewGroup, false);
                a aVar2 = new a();
                aVar2.tKI = (TextView) view.findViewById(R.id.fh2);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (bankcard != null) {
                aVar.tKI.setText(bankcard.field_desc);
            } else {
                aVar.tKI.setText(R.string.fst);
            }
            AppMethodBeat.o(47658);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47659);
        super.onCreate(bundle);
        setMMTitle((int) R.string.f_0);
        this.gOW = this.mBundle.getInt("key_scene", 0);
        this.tKB = this.mBundle.getString("key_top_tips");
        this.tKC = this.mBundle.getBoolean("key_is_show_new_bankcard", true);
        this.tKD = this.mBundle.getString("bottom_tips");
        this.tKE = this.mBundle.getParcelableArrayList("key_showing_bankcards");
        if (this.tKE == null) {
            this.tKE = r.cPI().cQB();
        }
        this.tKy = (TextView) findViewById(R.id.fh3);
        this.tKz = (MaxListView) findViewById(R.id.fh4);
        this.kEs = (TextView) findViewById(R.id.fh5);
        if (bo.isNullOrNil(this.tKB)) {
            this.tKy.setVisibility(8);
        } else {
            this.tKy.setVisibility(0);
            this.tKy.setText(this.tKB);
        }
        if (bo.isNullOrNil(this.tKD)) {
            this.kEs.setVisibility(8);
        } else {
            this.kEs.setVisibility(0);
            this.kEs.setText(this.tKD);
        }
        if (this.gOW == 0) {
            this.kEs.setVisibility(0);
            j jVar = new j(this);
            jVar.tHw = new com.tencent.mm.plugin.wallet_core.ui.j.a() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47652);
                    ab.i("MicroMsg.WalletSelectBankcardUI", "hy: user clicked the phone.go to dial");
                    e.bU(WalletSelectBankcardUI.this, WalletSelectBankcardUI.this.getString(R.string.f_4));
                    AppMethodBeat.o(47652);
                }
            };
            String string = getString(R.string.fsn);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(jVar, string.length() - 14, string.length(), 33);
            this.kEs.setText(spannableString);
            this.kEs.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.tKA = new a(this, (byte) 0);
        this.tKz.setAdapter(this.tKA);
        this.tKz.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(47655);
                final Bankcard bankcard = (Bankcard) adapterView.getItemAtPosition(i);
                if (bankcard != null) {
                    h.a(WalletSelectBankcardUI.this, true, WalletSelectBankcardUI.this.getString(R.string.fsp, new Object[]{bankcard.field_desc, bankcard.field_mobile}), WalletSelectBankcardUI.this.getString(R.string.fsr), WalletSelectBankcardUI.this.getString(R.string.fso), WalletSelectBankcardUI.this.getString(R.string.fsq), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(47653);
                            WalletSelectBankcardUI.this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                            WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, bankcard);
                            com.tencent.mm.plugin.report.service.h.pYm.e(11977, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                            AppMethodBeat.o(47653);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(47654);
                            WalletSelectBankcardUI.this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", true);
                            WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, bankcard);
                            AppMethodBeat.o(47654);
                        }
                    });
                    AppMethodBeat.o(47655);
                    return;
                }
                WalletSelectBankcardUI.this.mBundle.putBoolean("key_balance_change_phone_need_confirm_phone", false);
                WalletSelectBankcardUI.a(WalletSelectBankcardUI.this, null);
                AppMethodBeat.o(47655);
            }
        });
        AppMethodBeat.o(47659);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b64;
    }

    public final boolean cNR() {
        return true;
    }

    static /* synthetic */ void a(WalletSelectBankcardUI walletSelectBankcardUI, Bankcard bankcard) {
        AppMethodBeat.i(47660);
        walletSelectBankcardUI.mBundle.putParcelable("key_bankcard", bankcard);
        walletSelectBankcardUI.dOE().p(new Object[0]);
        AppMethodBeat.o(47660);
    }
}
