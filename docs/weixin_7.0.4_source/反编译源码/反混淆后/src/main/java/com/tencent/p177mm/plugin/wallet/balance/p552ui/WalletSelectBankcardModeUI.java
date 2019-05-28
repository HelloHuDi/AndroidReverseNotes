package com.tencent.p177mm.plugin.wallet.balance.p552ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI */
public class WalletSelectBankcardModeUI extends WalletBaseUI {
    /* renamed from: Ej */
    private ListView f16191Ej;
    private int emC = 0;
    private ArrayList<C29554a> mData = new ArrayList();
    private ArrayList<Bankcard> tgB;
    private Bankcard tgC;
    private String tgD;
    private int tgO = 0;
    private int tgS = -1;
    private TextView thQ;
    private C14140b thR;

    @SuppressLint({"ViewHolder"})
    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI$b */
    class C14140b extends BaseAdapter {
        C14140b() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(45491);
            int size = WalletSelectBankcardModeUI.this.mData.size();
            AppMethodBeat.m2505o(45491);
            return size;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(45492);
            View inflate = View.inflate(WalletSelectBankcardModeUI.this, 2130971165, null);
            C29554a c29554a = (C29554a) WalletSelectBankcardModeUI.this.mData.get(i);
            TextView textView = (TextView) inflate.findViewById(2131829053);
            ImageView imageView = (ImageView) inflate.findViewById(2131829054);
            ((TextView) inflate.findViewById(2131829052)).setText(c29554a.title);
            if (TextUtils.isEmpty(c29554a.kfM)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(c29554a.kfM);
            }
            if (WalletSelectBankcardModeUI.this.tgS == i) {
                imageView.setImageResource(C1318a.radio_on);
            } else {
                imageView.setImageResource(C1318a.radio_off);
            }
            AppMethodBeat.m2505o(45492);
            return inflate;
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(45493);
            C29554a c29554a = (C29554a) WalletSelectBankcardModeUI.this.mData.get(i);
            AppMethodBeat.m2505o(45493);
            return c29554a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI$a */
    static class C29554a {
        public String kfM;
        public String title;

        private C29554a() {
            this.title = "";
            this.kfM = "";
        }

        /* synthetic */ C29554a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI$1 */
    class C354101 implements OnMenuItemClickListener {
        C354101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45489);
            WalletSelectBankcardModeUI.this.setResult(0);
            WalletSelectBankcardModeUI.this.finish();
            AppMethodBeat.m2505o(45489);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI$2 */
    class C400642 implements OnItemClickListener {
        C400642() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(45490);
            WalletSelectBankcardModeUI.this.tgS = i;
            WalletSelectBankcardModeUI.this.thR.notifyDataSetChanged();
            Intent intent = new Intent();
            intent.putExtra("key_select_index", i);
            WalletSelectBankcardModeUI.this.setResult(-1, intent);
            C4990ab.m7416i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is ".concat(String.valueOf(i)));
            WalletSelectBankcardModeUI.this.finish();
            AppMethodBeat.m2505o(45490);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletSelectBankcardModeUI() {
        AppMethodBeat.m2504i(45494);
        AppMethodBeat.m2505o(45494);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45495);
        super.onCreate(bundle);
        setResult(0);
        this.emC = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
        this.tgS = getIntent().getIntExtra("key_select_index", -1);
        C4990ab.m7416i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.emC);
        initView();
        AppMethodBeat.m2505o(45495);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45496);
        setMMTitle((int) C25738R.string.f_0);
        setBackBtn(new C354101());
        this.thQ = (TextView) findViewById(2131829050);
        if (this.emC == 0) {
            this.thQ.setText(C25738R.string.ft2);
        } else if (this.emC == 1) {
            this.thQ.setText(C25738R.string.ft3);
        }
        this.f16191Ej = (ListView) findViewById(2131829051);
        this.thR = new C14140b();
        this.f16191Ej.setAdapter(this.thR);
        this.f16191Ej.setOnItemClickListener(new C400642());
        this.mData.clear();
        this.tgD = getString(C25738R.string.f9s);
        if (this.emC == 0) {
            C46332s.cNC();
            C22587ak cND = C46332s.cND();
            this.tgB = cND.cQD();
            this.tgC = cND.mo38130a(this.tgB, null, false, true);
            if (cND.tCX != null) {
                this.tgO = cND.tCX.tgO;
                C4990ab.m7412e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.tgO);
            } else {
                this.tgO = 0;
                C4990ab.m7412e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
            }
            if (this.tgB == null || this.tgB.size() <= 0) {
                C4990ab.m7416i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
            } else {
                C4990ab.m7416i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.tgB.size());
                Iterator it = this.tgB.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Bankcard bankcard = (Bankcard) it.next();
                    C29554a c29554a = new C29554a();
                    c29554a.title = bankcard.field_desc;
                    if (bankcard.field_fetch_charge_rate <= 0.0d || this.tgO != 1) {
                        C4990ab.m7416i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + bankcard.field_desc + " field_fetch_charge_rate is " + bankcard.field_fetch_charge_rate + " is_show_charge is " + this.tgO);
                    } else if (TextUtils.isEmpty(bankcard.field_fetch_charge_info)) {
                        c29554a.kfM = getString(C25738R.string.f8n) + (bankcard.field_fetch_charge_rate * 100.0d) + "%";
                    } else {
                        c29554a.kfM = bankcard.field_fetch_charge_info;
                    }
                    this.mData.add(c29554a);
                    if (this.tgS == -1 && this.tgC != null && this.tgC.equals(bankcard)) {
                        this.tgS = i;
                    }
                    i++;
                }
                if (this.tgS == -1 && this.tgC == null) {
                    this.tgS = i;
                }
            }
            C29554a c29554a2 = new C29554a();
            c29554a2.title = this.tgD;
            c29554a2.kfM = "";
            this.mData.add(c29554a2);
        }
        this.thR.notifyDataSetChanged();
        AppMethodBeat.m2505o(45496);
    }

    public final int getLayoutId() {
        return 2130971164;
    }

    public final boolean bNf() {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(45497);
        if (i == 4) {
            setResult(0);
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(45497);
        return onKeyUp;
    }

    public final int getForceOrientation() {
        return 1;
    }
}
