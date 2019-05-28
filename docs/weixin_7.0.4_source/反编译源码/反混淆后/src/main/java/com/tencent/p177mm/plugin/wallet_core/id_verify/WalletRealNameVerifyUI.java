package com.tencent.p177mm.plugin.wallet_core.id_verify;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C14226g;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.C44779d;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletSelectProfessionUI;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a.C30895a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import com.tencent.p177mm.wallet_core.p650ui.formview.p1098a.C30889b;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI */
public class WalletRealNameVerifyUI extends WalletBaseUI implements OnClickListener, C36397a {
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

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI$4 */
    class C43834 implements OnMenuItemClickListener {
        C43834() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(46623);
            C40105a c40105a = (C40105a) WalletRealNameVerifyUI.this.dOD();
            if (c40105a != null) {
                c40105a.mo8127c(WalletRealNameVerifyUI.this, 0);
            }
            WalletRealNameVerifyUI.this.finish();
            AppMethodBeat.m2505o(46623);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI$5 */
    class C43845 implements OnCheckedChangeListener {
        C43845() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(46624);
            if (z) {
                WalletRealNameVerifyUI.this.gHn.setEnabled(true);
                WalletRealNameVerifyUI.this.gHn.setClickable(true);
                AppMethodBeat.m2505o(46624);
                return;
            }
            WalletRealNameVerifyUI.this.gHn.setEnabled(false);
            WalletRealNameVerifyUI.this.gHn.setClickable(false);
            AppMethodBeat.m2505o(46624);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI$6 */
    class C43856 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI$6$1 */
        class C43861 implements C30382d {
            C43861() {
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(46625);
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        intent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(C25738R.string.f84, new Object[]{C4988aa.dor()}));
                        break;
                    case 1:
                        if (WalletRealNameVerifyUI.this.tvu != null) {
                            intent.putExtra("rawUrl", WalletRealNameVerifyUI.this.getString(C25738R.string.f82, new Object[]{C4988aa.dor(), WalletRealNameVerifyUI.this.tvu.pbn}));
                            break;
                        }
                        break;
                }
                intent.putExtra("showShare", false);
                C25985d.m41467b(WalletRealNameVerifyUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(46625);
            }
        }

        C43856() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46626);
            List linkedList = new LinkedList();
            List linkedList2 = new LinkedList();
            linkedList.add(WalletRealNameVerifyUI.this.getString(C25738R.string.faa));
            linkedList2.add(Integer.valueOf(0));
            if (WalletRealNameVerifyUI.this.tvu != null && WalletRealNameVerifyUI.this.tvu.tyW) {
                linkedList.add(WalletRealNameVerifyUI.this.getString(C25738R.string.fa9));
                linkedList2.add(Integer.valueOf(1));
            }
            C30379h.m48419a(WalletRealNameVerifyUI.this, "", linkedList, linkedList2, "", new C43861());
            AppMethodBeat.m2505o(46626);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI$2 */
    class C43872 implements OnClickListener {
        C43872() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46621);
            Intent intent = new Intent();
            intent.putExtra("GetAddress", true);
            intent.putExtra("ShowSelectedLocation", false);
            intent.putExtra("IsRealNameVerifyScene", true);
            intent.putExtra("IsNeedShowSearchBar", true);
            C25985d.m41466b(WalletRealNameVerifyUI.this.mController.ylL, ".ui.tools.MultiStageCitySelectUI", intent, 2);
            AppMethodBeat.m2505o(46621);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI$1 */
    class C43881 implements OnClickListener {
        C43881() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46620);
            Intent intent = new Intent(WalletRealNameVerifyUI.this.mController.ylL, WalletSelectProfessionUI.class);
            intent.putExtra("key_profession_list", WalletRealNameVerifyUI.this.tur);
            WalletRealNameVerifyUI.this.startActivityForResult(intent, 1);
            AppMethodBeat.m2505o(46620);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI$3 */
    class C43893 implements OnClickListener {
        C43893() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46622);
            WalletRealNameVerifyUI.m6733a(WalletRealNameVerifyUI.this, WalletRealNameVerifyUI.this.tvo.getText(), WalletRealNameVerifyUI.this.tvp.getText());
            AppMethodBeat.m2505o(46622);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46627);
        super.onCreate(bundle);
        this.Ahr.mo49372nf(1616);
        this.tvu = (ElementQuery) this.mBundle.getParcelable("elemt_query");
        initView();
        mo39970a(new C14226g(), true, false);
        AppMethodBeat.m2505o(46627);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46628);
        this.Ahr.mo49373ng(1616);
        super.onDestroy();
        AppMethodBeat.m2505o(46628);
    }

    public final void initView() {
        AppMethodBeat.m2504i(46629);
        setMMTitle((int) C25738R.string.fqh);
        this.gHn = (Button) findViewById(2131822846);
        this.tvo = (WalletFormView) findViewById(2131828681);
        this.tvp = (WalletFormView) findViewById(2131826500);
        this.tvq = (WalletFormView) findViewById(2131828724);
        this.tvr = (WalletFormView) findViewById(2131828725);
        this.tvt = (TextView) findViewById(2131828577);
        this.tvo.setOnInputValidChangeListener(this);
        this.tvp.setOnInputValidChangeListener(this);
        this.tvq.setOnInputValidChangeListener(this);
        this.tvr.setOnInputValidChangeListener(this);
        this.tvo.setFocusable(true);
        this.tvo.getInfoIv().setVisibility(8);
        C30890a.m49298d(this.tvp);
        C30889b logicDelegate = this.tvp.getLogicDelegate();
        if (logicDelegate instanceof C30895a) {
            ((C30895a) logicDelegate).mo49420QT(1);
        }
        this.tvq.setOnClickListener(new C43881());
        this.tvr.setOnClickListener(new C43872());
        this.gHn.setOnClickListener(new C43893());
        mo39989e(this.tvp, 1, false);
        setBackBtn(new C43834());
        this.tvs = (CheckBox) findViewById(2131828739);
        this.nFy = (TextView) findViewById(2131829029);
        this.tvs.setChecked(true);
        this.tvs.setOnCheckedChangeListener(new C43845());
        this.nFy.setOnClickListener(new C43856());
        AppMethodBeat.m2505o(46629);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        boolean z = false;
        AppMethodBeat.m2504i(46630);
        if (i != 0 || i2 != 0) {
            C4990ab.m7412e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
        } else if (c1207m instanceof C44779d) {
            C40931c dOD = dOD();
            Bundle bundle = null;
            if (dOD != null) {
                bundle = dOD.mqu;
            }
            String str2 = ((C44779d) c1207m).token;
            C4990ab.m7416i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
            if (dOD != null) {
                bundle.putString("key_real_name_token", str2);
                bundle.putString("key_country_code", this.countryCode);
                bundle.putString("key_province_code", this.fnp);
                bundle.putString("key_city_code", this.fno);
                bundle.putParcelable("key_profession", this.tvv);
                dOD.mo8124a((Activity) this, 0, bundle);
            }
            AppMethodBeat.m2505o(46630);
            return true;
        } else if (c1207m instanceof C14226g) {
            boolean z2;
            C14226g c14226g = (C14226g) c1207m;
            if (c14226g.tup == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.tvw = z2;
            if (c14226g.tuq == 1) {
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
                this.tvt.setText(C25738R.string.fqc);
            }
            this.tur = c14226g.tvM;
            AppMethodBeat.m2505o(46630);
            return true;
        }
        AppMethodBeat.m2505o(46630);
        return false;
    }

    public final int getLayoutId() {
        return 2130971159;
    }

    public void onClick(View view) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46631);
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
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        stringBuilder.append(stringExtra);
                    }
                    if (!C5046bo.isNullOrNil(stringExtra2)) {
                        stringBuilder.append(" ").append(stringExtra2);
                    }
                    if (!C5046bo.isNullOrNil(stringExtra3)) {
                        stringBuilder.append(" ").append(stringExtra3);
                    }
                    this.tvr.setText(stringBuilder.toString());
                    AppMethodBeat.m2505o(46631);
                    return;
                }
                C4990ab.m7416i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
            }
            AppMethodBeat.m2505o(46631);
        } else if (i2 == -1) {
            this.tvv = (Profession) intent.getParcelableExtra("key_select_profession");
            this.tvq.setText(this.tvv.tvN);
            AppMethodBeat.m2505o(46631);
        } else {
            C4990ab.m7416i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
            AppMethodBeat.m2505o(46631);
        }
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(46632);
        C4990ab.m7410d("MicroMsg.WalletRealNameVerifyUI", "check info");
        String text = this.tvo.getText();
        String text2 = this.tvp.getText();
        if (C5046bo.isNullOrNil(text)) {
            z2 = false;
        } else if (C5046bo.isNullOrNil(text2)) {
            z2 = false;
        } else {
            if (this.tvw) {
                if (C5046bo.isNullOrNil(this.countryCode) && C5046bo.isNullOrNil(this.fnp) && C5046bo.isNullOrNil(this.fno)) {
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
            AppMethodBeat.m2505o(46632);
            return;
        }
        this.gHn.setEnabled(false);
        this.gHn.setClickable(false);
        AppMethodBeat.m2505o(46632);
    }

    /* renamed from: a */
    static /* synthetic */ void m6733a(WalletRealNameVerifyUI walletRealNameVerifyUI, String str, String str2) {
        AppMethodBeat.m2504i(46633);
        walletRealNameVerifyUI.mo39970a(new C44779d(str, str2, walletRealNameVerifyUI.mBundle.getInt("entry_scene", -1)), true, false);
        AppMethodBeat.m2505o(46633);
    }
}
