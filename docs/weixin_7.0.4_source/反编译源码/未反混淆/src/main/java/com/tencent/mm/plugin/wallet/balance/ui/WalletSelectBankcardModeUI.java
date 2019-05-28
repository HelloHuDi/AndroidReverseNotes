package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI extends WalletBaseUI {
    private ListView Ej;
    private int emC = 0;
    private ArrayList<a> mData = new ArrayList();
    private ArrayList<Bankcard> tgB;
    private Bankcard tgC;
    private String tgD;
    private int tgO = 0;
    private int tgS = -1;
    private TextView thQ;
    private b thR;

    @SuppressLint({"ViewHolder"})
    class b extends BaseAdapter {
        b() {
        }

        public final int getCount() {
            AppMethodBeat.i(45491);
            int size = WalletSelectBankcardModeUI.this.mData.size();
            AppMethodBeat.o(45491);
            return size;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(45492);
            View inflate = View.inflate(WalletSelectBankcardModeUI.this, R.layout.b62, null);
            a aVar = (a) WalletSelectBankcardModeUI.this.mData.get(i);
            TextView textView = (TextView) inflate.findViewById(R.id.fh0);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.fh1);
            ((TextView) inflate.findViewById(R.id.fgz)).setText(aVar.title);
            if (TextUtils.isEmpty(aVar.kfM)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(aVar.kfM);
            }
            if (WalletSelectBankcardModeUI.this.tgS == i) {
                imageView.setImageResource(R.raw.radio_on);
            } else {
                imageView.setImageResource(R.raw.radio_off);
            }
            AppMethodBeat.o(45492);
            return inflate;
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(45493);
            a aVar = (a) WalletSelectBankcardModeUI.this.mData.get(i);
            AppMethodBeat.o(45493);
            return aVar;
        }
    }

    static class a {
        public String kfM;
        public String title;

        private a() {
            this.title = "";
            this.kfM = "";
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletSelectBankcardModeUI() {
        AppMethodBeat.i(45494);
        AppMethodBeat.o(45494);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45495);
        super.onCreate(bundle);
        setResult(0);
        this.emC = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
        this.tgS = getIntent().getIntExtra("key_select_index", -1);
        ab.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.emC);
        initView();
        AppMethodBeat.o(45495);
    }

    public final void initView() {
        AppMethodBeat.i(45496);
        setMMTitle((int) R.string.f_0);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45489);
                WalletSelectBankcardModeUI.this.setResult(0);
                WalletSelectBankcardModeUI.this.finish();
                AppMethodBeat.o(45489);
                return true;
            }
        });
        this.thQ = (TextView) findViewById(R.id.fgx);
        if (this.emC == 0) {
            this.thQ.setText(R.string.ft2);
        } else if (this.emC == 1) {
            this.thQ.setText(R.string.ft3);
        }
        this.Ej = (ListView) findViewById(R.id.fgy);
        this.thR = new b();
        this.Ej.setAdapter(this.thR);
        this.Ej.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(45490);
                WalletSelectBankcardModeUI.this.tgS = i;
                WalletSelectBankcardModeUI.this.thR.notifyDataSetChanged();
                Intent intent = new Intent();
                intent.putExtra("key_select_index", i);
                WalletSelectBankcardModeUI.this.setResult(-1, intent);
                ab.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is ".concat(String.valueOf(i)));
                WalletSelectBankcardModeUI.this.finish();
                AppMethodBeat.o(45490);
            }
        });
        this.mData.clear();
        this.tgD = getString(R.string.f9s);
        if (this.emC == 0) {
            s.cNC();
            ak cND = s.cND();
            this.tgB = cND.cQD();
            this.tgC = cND.a(this.tgB, null, false, true);
            if (cND.tCX != null) {
                this.tgO = cND.tCX.tgO;
                ab.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.tgO);
            } else {
                this.tgO = 0;
                ab.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
            }
            if (this.tgB == null || this.tgB.size() <= 0) {
                ab.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
            } else {
                ab.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.tgB.size());
                Iterator it = this.tgB.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    a aVar = new a();
                    aVar.title = bankcard.field_desc;
                    if (bankcard.field_fetch_charge_rate <= 0.0d || this.tgO != 1) {
                        ab.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + bankcard.field_desc + " field_fetch_charge_rate is " + bankcard.field_fetch_charge_rate + " is_show_charge is " + this.tgO);
                    } else if (TextUtils.isEmpty(bankcard.field_fetch_charge_info)) {
                        aVar.kfM = getString(R.string.f8n) + (bankcard.field_fetch_charge_rate * 100.0d) + "%";
                    } else {
                        aVar.kfM = bankcard.field_fetch_charge_info;
                    }
                    this.mData.add(aVar);
                    if (this.tgS == -1 && this.tgC != null && this.tgC.equals(bankcard)) {
                        this.tgS = i;
                    }
                    i++;
                }
                if (this.tgS == -1 && this.tgC == null) {
                    this.tgS = i;
                }
            }
            a aVar2 = new a();
            aVar2.title = this.tgD;
            aVar2.kfM = "";
            this.mData.add(aVar2);
        }
        this.thR.notifyDataSetChanged();
        AppMethodBeat.o(45496);
    }

    public final int getLayoutId() {
        return R.layout.b61;
    }

    public final boolean bNf() {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(45497);
        if (i == 4) {
            setResult(0);
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(45497);
        return onKeyUp;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
