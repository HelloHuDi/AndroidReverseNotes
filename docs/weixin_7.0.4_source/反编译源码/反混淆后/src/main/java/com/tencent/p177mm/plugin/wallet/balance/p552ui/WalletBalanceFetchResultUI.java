package com.tencent.p177mm.plugin.wallet.balance.p552ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.plugin.wallet_core.model.C29631j.C29632a;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI */
public class WalletBalanceFetchResultUI extends WalletBaseUI {
    private LinearLayout nsy;
    private ImageView pNb;
    private ImageView pNc;
    private ImageView pNd;
    private TextView pNe;
    private TextView pNf;
    private TextView pNg;
    private TextView pNh;
    private TextView pNi;
    private TextView pNj;
    private Orders pWy;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI$1 */
    class C225031 implements OnMenuItemClickListener {
        C225031() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(45347);
            WalletBalanceFetchResultUI.m46896a(WalletBalanceFetchResultUI.this);
            AppMethodBeat.m2505o(45347);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI$2 */
    class C225042 implements OnClickListener {
        C225042() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45348);
            WalletBalanceFetchResultUI.m46896a(WalletBalanceFetchResultUI.this);
            AppMethodBeat.m2505o(45348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI$3 */
    class C295443 implements DialogInterface.OnClickListener {
        C295443() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45349);
            WalletBalanceFetchResultUI.this.dOD().mo8124a(WalletBalanceFetchResultUI.this, 0, WalletBalanceFetchResultUI.this.mBundle);
            AppMethodBeat.m2505o(45349);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45350);
        super.onCreate(bundle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(C25738R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131821128);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(C25738R.color.f12085rt));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(C25738R.color.f11782h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(C8415j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(C25738R.color.a69));
            if (VERSION.SDK_INT >= 23) {
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        if (this.pWy == null) {
            C4990ab.m7420w("MicroMsg.WalletBalanceFetchResultUI", "order is null!");
            finish();
            AppMethodBeat.m2505o(45350);
            return;
        }
        initView();
        setMMTitle((String) dOE().mo9364Au(0));
        setBackBtn(new C225031());
        AppMethodBeat.m2505o(45350);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45351);
        this.pNb = (ImageView) findViewById(2131821647);
        this.pNc = (ImageView) findViewById(2131821651);
        this.pNd = (ImageView) findViewById(2131821655);
        this.pNb.setImageResource(C25738R.drawable.f6404d3);
        this.pNc.setScaleType(ScaleType.CENTER_CROP);
        this.pNc.setImageResource(C1318a.remittance_wait);
        this.pNd.setImageResource(C25738R.drawable.f6405d4);
        this.pNe = (TextView) findViewById(2131821648);
        this.pNf = (TextView) findViewById(2131821652);
        this.pNg = (TextView) findViewById(2131821656);
        this.pNe.setText(C25738R.string.f93);
        this.pNf.setText(C25738R.string.f91);
        this.pNf.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        this.pNg.setText(C25738R.string.f8y);
        this.pNh = (TextView) findViewById(2131821649);
        this.pNi = (TextView) findViewById(2131821653);
        this.pNj = (TextView) findViewById(2131821657);
        this.pNh.setVisibility(8);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm);
        this.pNi.setText(getString(C25738R.string.f8p, new Object[]{simpleDateFormat.format(new Date(this.pWy.tAk))}));
        this.pNi.setVisibility(0);
        this.pNj.setVisibility(8);
        this.nsy = (LinearLayout) findViewById(2131821660);
        this.nsy.setBackgroundResource(C25738R.drawable.f6403d2);
        String string = this.mBundle.getString("key_fetch_result_show_info");
        ArrayList<C29632a> arrayList = new ArrayList();
        if (!C5046bo.isNullOrNil(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    C29632a az = C29632a.m47000az(jSONArray.optJSONObject(i));
                    if (az != null) {
                        arrayList.add(az);
                    }
                }
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletBalanceFetchResultUI", e, "", new Object[0]);
            }
        }
        C4990ab.m7411d("MicroMsg.WalletBalanceFetchResultUI", "show info: %s", Integer.valueOf(arrayList.size()));
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView;
        String str;
        if (arrayList.isEmpty()) {
            walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
            walletBalanceFetchResultItemView.mo69468b(C25738R.string.f9o, C36391e.m60006e(this.pWy.pTN, this.pWy.pcl));
            this.nsy.addView(walletBalanceFetchResultItemView);
            if (this.pWy.pPp > 0.0d) {
                walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
                walletBalanceFetchResultItemView.mo69468b(C25738R.string.f9g, C36391e.m60006e(this.pWy.pPp, this.pWy.pcl));
                this.nsy.addView(walletBalanceFetchResultItemView);
            }
            if (this.pWy.tAq != null && this.pWy.tAq.size() > 0) {
                CharSequence charSequence;
                Commodity commodity = (Commodity) this.pWy.tAq.get(0);
                str = commodity.pcj;
                if (C5046bo.isNullOrNil(commodity.tAT)) {
                    Object charSequence2 = str;
                } else {
                    charSequence2 = str + " " + getString(C25738R.string.foc) + commodity.tAT;
                }
                WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
                walletBalanceFetchResultItemView2.mo69468b(C25738R.string.f8l, charSequence2);
                this.nsy.addView(walletBalanceFetchResultItemView2);
            }
        } else {
            for (C29632a c29632a : arrayList) {
                if (c29632a.tzj != null) {
                    boolean z;
                    boolean z2;
                    if (c29632a.f13717id != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, z);
                    str = c29632a.tzj.name;
                    String str2 = c29632a.tzj.value;
                    String str3 = c29632a.tzj.mVA;
                    String str4 = c29632a.tzj.tBF;
                    if (c29632a.f13717id == 3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    walletBalanceFetchResultItemView.mo69467a(str, str2, str3, str4, z2);
                    this.nsy.addView(walletBalanceFetchResultItemView);
                }
            }
        }
        ((Button) findViewById(2131821663)).setOnClickListener(new C225042());
        findViewById(2131821658).setVisibility(8);
        findViewById(2131821661).setVisibility(8);
        AppMethodBeat.m2505o(45351);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        return false;
    }

    public final int getLayoutId() {
        return 2130968816;
    }

    /* renamed from: a */
    static /* synthetic */ void m46896a(WalletBalanceFetchResultUI walletBalanceFetchResultUI) {
        AppMethodBeat.m2504i(45352);
        if (walletBalanceFetchResultUI.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceFetchResultUI.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.mo74574b(walletBalanceFetchResultUI, bundle, new C295443());
                walletBalanceFetchResultUI.mBundle.remove("key_realname_guide_helper");
            }
            AppMethodBeat.m2505o(45352);
            return;
        }
        walletBalanceFetchResultUI.dOD().mo8124a((Activity) walletBalanceFetchResultUI, 0, walletBalanceFetchResultUI.mBundle);
        AppMethodBeat.m2505o(45352);
    }
}
