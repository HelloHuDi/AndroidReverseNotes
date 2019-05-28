package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.widget.j;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;

@a(19)
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45350);
        super.onCreate(bundle);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.a69)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.id.p3);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.rt));
            }
            customView = customView.findViewById(16908308);
            if (customView != null && (customView instanceof TextView)) {
                ((TextView) customView).setTextColor(getResources().getColor(R.color.h4));
            }
        }
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(j.INVALID_ID);
            window.setStatusBarColor(getResources().getColor(R.color.a69));
            if (VERSION.SDK_INT >= 23) {
                getWindow().getDecorView().setSystemUiVisibility(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }
        this.mController.contentView.setFitsSystemWindows(true);
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        if (this.pWy == null) {
            ab.w("MicroMsg.WalletBalanceFetchResultUI", "order is null!");
            finish();
            AppMethodBeat.o(45350);
            return;
        }
        initView();
        setMMTitle((String) dOE().Au(0));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(45347);
                WalletBalanceFetchResultUI.a(WalletBalanceFetchResultUI.this);
                AppMethodBeat.o(45347);
                return false;
            }
        });
        AppMethodBeat.o(45350);
    }

    public final void initView() {
        AppMethodBeat.i(45351);
        this.pNb = (ImageView) findViewById(R.id.a2s);
        this.pNc = (ImageView) findViewById(R.id.a2w);
        this.pNd = (ImageView) findViewById(R.id.a30);
        this.pNb.setImageResource(R.drawable.d3);
        this.pNc.setScaleType(ScaleType.CENTER_CROP);
        this.pNc.setImageResource(R.raw.remittance_wait);
        this.pNd.setImageResource(R.drawable.d4);
        this.pNe = (TextView) findViewById(R.id.a2t);
        this.pNf = (TextView) findViewById(R.id.a2x);
        this.pNg = (TextView) findViewById(R.id.a31);
        this.pNe.setText(R.string.f93);
        this.pNf.setText(R.string.f91);
        this.pNf.setTextColor(getResources().getColor(R.color.w4));
        this.pNg.setText(R.string.f8y);
        this.pNh = (TextView) findViewById(R.id.a2u);
        this.pNi = (TextView) findViewById(R.id.a2y);
        this.pNj = (TextView) findViewById(R.id.a32);
        this.pNh.setVisibility(8);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm);
        this.pNi.setText(getString(R.string.f8p, new Object[]{simpleDateFormat.format(new Date(this.pWy.tAk))}));
        this.pNi.setVisibility(0);
        this.pNj.setVisibility(8);
        this.nsy = (LinearLayout) findViewById(R.id.a35);
        this.nsy.setBackgroundResource(R.drawable.d2);
        String string = this.mBundle.getString("key_fetch_result_show_info");
        ArrayList<com.tencent.mm.plugin.wallet_core.model.j.a> arrayList = new ArrayList();
        if (!bo.isNullOrNil(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.tencent.mm.plugin.wallet_core.model.j.a az = com.tencent.mm.plugin.wallet_core.model.j.a.az(jSONArray.optJSONObject(i));
                    if (az != null) {
                        arrayList.add(az);
                    }
                }
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.WalletBalanceFetchResultUI", e, "", new Object[0]);
            }
        }
        ab.d("MicroMsg.WalletBalanceFetchResultUI", "show info: %s", Integer.valueOf(arrayList.size()));
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView;
        String str;
        if (arrayList.isEmpty()) {
            walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
            walletBalanceFetchResultItemView.b(R.string.f9o, e.e(this.pWy.pTN, this.pWy.pcl));
            this.nsy.addView(walletBalanceFetchResultItemView);
            if (this.pWy.pPp > 0.0d) {
                walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
                walletBalanceFetchResultItemView.b(R.string.f9g, e.e(this.pWy.pPp, this.pWy.pcl));
                this.nsy.addView(walletBalanceFetchResultItemView);
            }
            if (this.pWy.tAq != null && this.pWy.tAq.size() > 0) {
                CharSequence charSequence;
                Commodity commodity = (Commodity) this.pWy.tAq.get(0);
                str = commodity.pcj;
                if (bo.isNullOrNil(commodity.tAT)) {
                    Object charSequence2 = str;
                } else {
                    charSequence2 = str + " " + getString(R.string.foc) + commodity.tAT;
                }
                WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
                walletBalanceFetchResultItemView2.b(R.string.f8l, charSequence2);
                this.nsy.addView(walletBalanceFetchResultItemView2);
            }
        } else {
            for (com.tencent.mm.plugin.wallet_core.model.j.a aVar : arrayList) {
                if (aVar.tzj != null) {
                    boolean z;
                    boolean z2;
                    if (aVar.id != 3) {
                        z = true;
                    } else {
                        z = false;
                    }
                    walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, z);
                    str = aVar.tzj.name;
                    String str2 = aVar.tzj.value;
                    String str3 = aVar.tzj.mVA;
                    String str4 = aVar.tzj.tBF;
                    if (aVar.id == 3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    walletBalanceFetchResultItemView.a(str, str2, str3, str4, z2);
                    this.nsy.addView(walletBalanceFetchResultItemView);
                }
            }
        }
        ((Button) findViewById(R.id.a38)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(45348);
                WalletBalanceFetchResultUI.a(WalletBalanceFetchResultUI.this);
                AppMethodBeat.o(45348);
            }
        });
        findViewById(R.id.a33).setVisibility(8);
        findViewById(R.id.a36).setVisibility(8);
        AppMethodBeat.o(45351);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.fs;
    }

    static /* synthetic */ void a(WalletBalanceFetchResultUI walletBalanceFetchResultUI) {
        AppMethodBeat.i(45352);
        if (walletBalanceFetchResultUI.mBundle.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceFetchResultUI.mBundle.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.b(walletBalanceFetchResultUI, bundle, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(45349);
                        WalletBalanceFetchResultUI.this.dOD().a(WalletBalanceFetchResultUI.this, 0, WalletBalanceFetchResultUI.this.mBundle);
                        AppMethodBeat.o(45349);
                    }
                });
                walletBalanceFetchResultUI.mBundle.remove("key_realname_guide_helper");
            }
            AppMethodBeat.o(45352);
            return;
        }
        walletBalanceFetchResultUI.dOD().a((Activity) walletBalanceFetchResultUI, 0, walletBalanceFetchResultUI.mBundle);
        AppMethodBeat.o(45352);
    }
}
