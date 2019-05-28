package com.tencent.mm.plugin.wallet_core.id_verify;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import java.util.LinkedList;
import java.util.List;

public class WalletRealNameVerifyUI extends WalletBaseUI implements OnClickListener, a {
    private String countryCode;
    private String fno;
    private String fnp;
    private Button gHn;
    private TextView nFy;
    private Profession[] tur;
    private WalletFormView tvo;
    private WalletFormView tvp;
    private WalletFormView tvq;
    private WalletFormView tvr;
    private CheckBox tvs;
    private TextView tvt;
    private ElementQuery tvu;
    private Profession tvv;
    private boolean tvw = false;
    private boolean tvx = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46627);
        super.onCreate(bundle);
        this.Ahr.nf(1616);
        this.tvu = (ElementQuery) this.mBundle.getParcelable("elemt_query");
        initView();
        a(new g(), true, false);
        AppMethodBeat.o(46627);
    }

    public void onDestroy() {
        AppMethodBeat.i(46628);
        this.Ahr.ng(1616);
        super.onDestroy();
        AppMethodBeat.o(46628);
    }

    public final void initView() {
        AppMethodBeat.i(46629);
        setMMTitle((int) R.string.fqh);
        this.gHn = (Button) findViewById(R.id.ay8);
        this.tvo = (WalletFormView) findViewById(R.id.f7y);
        this.tvp = (WalletFormView) findViewById(R.id.dm0);
        this.tvq = (WalletFormView) findViewById(R.id.f94);
        this.tvr = (WalletFormView) findViewById(R.id.f95);
        this.tvt = (TextView) findViewById(R.id.f55);
        this.tvo.setOnInputValidChangeListener(this);
        this.tvp.setOnInputValidChangeListener(this);
        this.tvq.setOnInputValidChangeListener(this);
        this.tvr.setOnInputValidChangeListener(this);
        this.tvo.setFocusable(true);
        this.tvo.getInfoIv().setVisibility(8);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.tvp);
        b logicDelegate = this.tvp.getLogicDelegate();
        if (logicDelegate instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) logicDelegate).QT(1);
        }
        this.tvq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46620);
                Intent intent = new Intent(WalletRealNameVerifyUI.this.mController.ylL, WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", WalletRealNameVerifyUI.this.tur);
                WalletRealNameVerifyUI.this.startActivityForResult(intent, 1);
                AppMethodBeat.o(46620);
            }
        });
        this.tvr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46621);
                Intent intent = new Intent();
                intent.putExtra("GetAddress", true);
                intent.putExtra("ShowSelectedLocation", false);
                intent.putExtra("IsRealNameVerifyScene", true);
                intent.putExtra("IsNeedShowSearchBar", true);
                d.b(WalletRealNameVerifyUI.this.mController.ylL, ".ui.tools.MultiStageCitySelectUI", intent, 2);
                AppMethodBeat.o(46621);
            }
        });
        this.gHn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46622);
                WalletRealNameVerifyUI.a(WalletRealNameVerifyUI.this, WalletRealNameVerifyUI.this.tvo.getText(), WalletRealNameVerifyUI.this.tvp.getText());
                AppMethodBeat.o(46622);
            }
        });
        e(this.tvp, 1, false);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(46623);
                a aVar = (a) WalletRealNameVerifyUI.this.dOD();
                if (aVar != null) {
                    aVar.c(WalletRealNameVerifyUI.this, 0);
                }
                WalletRealNameVerifyUI.this.finish();
                AppMethodBeat.o(46623);
                return true;
            }
        });
        this.tvs = (CheckBox) findViewById(R.id.f9i);
        this.nFy = (TextView) findViewById(R.id.fgc);
        this.tvs.setChecked(true);
        this.tvs.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(46624);
                if (z) {
                    WalletRealNameVerifyUI.this.gHn.setEnabled(true);
                    WalletRealNameVerifyUI.this.gHn.setClickable(true);
                    AppMethodBeat.o(46624);
                    return;
                }
                WalletRealNameVerifyUI.this.gHn.setEnabled(false);
                WalletRealNameVerifyUI.this.gHn.setClickable(false);
                AppMethodBeat.o(46624);
            }
        });
        this.nFy.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46626);
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(WalletRealNameVerifyUI.this.getString(R.string.faa));
                linkedList2.add(Integer.valueOf(0));
                if (WalletRealNameVerifyUI.this.tvu != null && WalletRealNameVerifyUI.this.tvu.tyW) {
                    linkedList.add(WalletRealNameVerifyUI.this.getString(R.string.fa9));
                    linkedList2.add(Integer.valueOf(1));
                }
                h.a(WalletRealNameVerifyUI.this, "", linkedList, linkedList2, "", new h.d() {
                    public final void bV(int i, int i2) {
                        AppMethodBeat.i(46625);
                        Intent intent = new Intent();
                        switch (i) {
                            case 0:
                                intent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(R.string.f84, new Object[]{aa.dor()}));
                                break;
                            case 1:
                                if (WalletRealNameVerifyUI.this.tvu != null) {
                                    intent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(R.string.f82, new Object[]{aa.dor(), WalletRealNameVerifyUI.this.tvu.pbn}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        d.b(WalletRealNameVerifyUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(46625);
                    }
                });
                AppMethodBeat.o(46626);
            }
        });
        AppMethodBeat.o(46629);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        boolean z = false;
        AppMethodBeat.i(46630);
        if (i != 0 || i2 != 0) {
            ab.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
        } else if (mVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.d) {
            c dOD = dOD();
            Bundle bundle = null;
            if (dOD != null) {
                bundle = dOD.mqu;
            }
            String str2 = ((com.tencent.mm.plugin.wallet_core.id_verify.model.d) mVar).token;
            ab.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
            if (dOD != null) {
                bundle.putString("key_real_name_token", str2);
                bundle.putString("key_country_code", this.countryCode);
                bundle.putString("key_province_code", this.fnp);
                bundle.putString("key_city_code", this.fno);
                bundle.putParcelable("key_profession", this.tvv);
                dOD.a((Activity) this, 0, bundle);
            }
            AppMethodBeat.o(46630);
            return true;
        } else if (mVar instanceof g) {
            boolean z2;
            g gVar = (g) mVar;
            if (gVar.tup == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.tvw = z2;
            if (gVar.tuq == 1) {
                z = true;
            }
            this.tvx = z;
            if (!this.tvx) {
                this.tvq.setVisibility(8);
            }
            if (!this.tvw) {
                this.tvr.setVisibility(8);
            }
            if (this.tvw || this.tvx) {
                this.tvt.setText(R.string.fqc);
            }
            this.tur = gVar.tvM;
            AppMethodBeat.o(46630);
            return true;
        }
        AppMethodBeat.o(46630);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b5w;
    }

    public void onClick(View view) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46631);
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            if (i == 2) {
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("CountryName");
                    String stringExtra2 = intent.getStringExtra("ProviceName");
                    String stringExtra3 = intent.getStringExtra("CityName");
                    this.countryCode = intent.getStringExtra("Country");
                    this.fnp = intent.getStringExtra("Contact_Province");
                    this.fno = intent.getStringExtra("Contact_City");
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!bo.isNullOrNil(stringExtra)) {
                        stringBuilder.append(stringExtra);
                    }
                    if (!bo.isNullOrNil(stringExtra2)) {
                        stringBuilder.append(" ").append(stringExtra2);
                    }
                    if (!bo.isNullOrNil(stringExtra3)) {
                        stringBuilder.append(" ").append(stringExtra3);
                    }
                    this.tvr.setText(stringBuilder.toString());
                    AppMethodBeat.o(46631);
                    return;
                }
                ab.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
            }
            AppMethodBeat.o(46631);
        } else if (i2 == -1) {
            this.tvv = (Profession) intent.getParcelableExtra("key_select_profession");
            this.tvq.setText(this.tvv.tvN);
            AppMethodBeat.o(46631);
        } else {
            ab.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
            AppMethodBeat.o(46631);
        }
    }

    public final void hY(boolean z) {
        boolean z2;
        AppMethodBeat.i(46632);
        ab.d("MicroMsg.WalletRealNameVerifyUI", "check info");
        String text = this.tvo.getText();
        String text2 = this.tvp.getText();
        if (bo.isNullOrNil(text)) {
            z2 = false;
        } else if (bo.isNullOrNil(text2)) {
            z2 = false;
        } else {
            if (this.tvw) {
                if (bo.isNullOrNil(this.countryCode) && bo.isNullOrNil(this.fnp) && bo.isNullOrNil(this.fno)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    z2 = false;
                }
            }
            if (this.tvx && this.tvv == null) {
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (z2) {
            this.gHn.setEnabled(true);
            this.gHn.setClickable(true);
            AppMethodBeat.o(46632);
            return;
        }
        this.gHn.setEnabled(false);
        this.gHn.setClickable(false);
        AppMethodBeat.o(46632);
    }

    static /* synthetic */ void a(WalletRealNameVerifyUI walletRealNameVerifyUI, String str, String str2) {
        AppMethodBeat.i(46633);
        walletRealNameVerifyUI.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.d(str, str2, walletRealNameVerifyUI.mBundle.getInt("entry_scene", -1)), true, false);
        AppMethodBeat.o(46633);
    }
}
