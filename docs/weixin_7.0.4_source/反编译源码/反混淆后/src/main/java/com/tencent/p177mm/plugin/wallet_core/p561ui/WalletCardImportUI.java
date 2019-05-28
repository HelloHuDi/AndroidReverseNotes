package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C15532i;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.MMScrollView;
import com.tencent.p177mm.wallet_core.p650ui.MMScrollView.C16094b;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a.C30895a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import com.tencent.p177mm.wallet_core.p650ui.formview.p1098a.C30889b;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI */
public class WalletCardImportUI extends WalletBaseUI implements OnEditorActionListener, C36397a {
    private static final String[] tGn = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT"};
    private Button gEZ;
    private Dialog mDialog = null;
    private C7306ak mHandler = new C7306ak();
    private String nQt;
    private String nQu;
    private PayInfo pVL = null;
    private Orders pWy = null;
    private WalletFormView tEq;
    private WalletFormView tFA;
    private WalletFormView tFD = null;
    private WalletFormView tFE;
    private CheckBox tFI;
    private String tFJ;
    private WalletFormView tFS;
    private WalletFormView tFj;
    private WalletFormView tFk;
    private WalletFormView tFm;
    private WalletFormView tFn;
    private WalletFormView tFu;
    private WalletFormView tFv;
    private WalletFormView tFw;
    private WalletFormView tFx;
    private WalletFormView tFy;
    private WalletFormView tFz;
    private TextView tGo;
    private MMScrollView tGp;
    private Bankcard tGq = null;
    private CheckBox tGr;
    private BaseAdapter tGs = new C142749();
    private Authen toh = new Authen();
    private WalletFormView trX;
    private int tsb = 1;
    private ElementQuery tvu = new ElementQuery();

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$6 */
    class C142726 implements OnClickListener {
        C142726() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47271);
            WalletCardImportUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
            AppMethodBeat.m2505o(47271);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$7 */
    class C142737 implements OnClickListener {
        C142737() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47272);
            WalletCardImportUI.m61312e(WalletCardImportUI.this);
            AppMethodBeat.m2505o(47272);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$9 */
    class C142749 extends BaseAdapter {
        C142749() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(47277);
            Integer Hu = m22459Hu(i);
            AppMethodBeat.m2505o(47277);
            return Hu;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(47274);
            if (WalletCardImportUI.this.tvu.cPs() != null) {
                int size = WalletCardImportUI.this.tvu.cPs().size();
                AppMethodBeat.m2505o(47274);
                return size;
            }
            AppMethodBeat.m2505o(47274);
            return 0;
        }

        /* renamed from: Hu */
        private Integer m22459Hu(int i) {
            AppMethodBeat.m2504i(47275);
            Integer num = (Integer) WalletCardImportUI.this.tvu.cPs().get(i);
            AppMethodBeat.m2505o(47275);
            return num;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(47276);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletCardImportUI.this, 2130971115, null);
            checkedTextView.setText(C14241r.cPQ().mo9419Z(WalletCardImportUI.this, m22459Hu(i).intValue()));
            if (WalletCardImportUI.this.tsb == m22459Hu(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            checkedTextView.setBackgroundResource(C25738R.drawable.f6623k5);
            AppMethodBeat.m2505o(47276);
            return checkedTextView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$5 */
    class C296455 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$5$1 */
        class C226031 implements C30382d {
            C226031() {
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(47269);
                Intent intent = new Intent();
                switch (i) {
                    case 0:
                        intent.putExtra("rawUrl", WalletCardImportUI.this.getString(C25738R.string.f84, new Object[]{C4988aa.dor()}));
                        break;
                    case 1:
                        if (WalletCardImportUI.this.tvu != null) {
                            intent.putExtra("rawUrl", WalletCardImportUI.this.getString(C25738R.string.f82, new Object[]{C4988aa.dor(), WalletCardImportUI.this.tvu.pbn}));
                            break;
                        }
                        break;
                }
                intent.putExtra("showShare", false);
                C25985d.m41467b(WalletCardImportUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(47269);
            }
        }

        C296455() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47270);
            List linkedList = new LinkedList();
            List linkedList2 = new LinkedList();
            linkedList.add(WalletCardImportUI.this.getString(C25738R.string.faa));
            linkedList2.add(Integer.valueOf(0));
            if (WalletCardImportUI.this.tvu != null && WalletCardImportUI.this.tvu.tyW) {
                linkedList.add(WalletCardImportUI.this.getString(C25738R.string.fa9));
                linkedList2.add(Integer.valueOf(1));
            }
            C30379h.m48419a(WalletCardImportUI.this, "", linkedList, linkedList2, "", new C226031());
            AppMethodBeat.m2505o(47270);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$8 */
    class C296468 implements OnItemClickListener {
        C296468() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(47273);
            WalletCardImportUI.this.dismissDialog(1);
            int intValue = ((Integer) WalletCardImportUI.this.tvu.cPs().get(i)).intValue();
            if (WalletCardImportUI.this.tsb != intValue) {
                WalletCardImportUI.this.tsb = intValue;
                WalletCardImportUI.this.tFm.setText(((CheckedTextView) view).getText().toString());
                WalletCardImportUI.m61309c(WalletCardImportUI.this.trX, WalletCardImportUI.this.tsb);
                WalletCardImportUI.this.trX.cey();
                WalletCardImportUI.m61316i(WalletCardImportUI.this);
            }
            AppMethodBeat.m2505o(47273);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$2 */
    class C368502 implements OnClickListener {
        C368502() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47266);
            Bundle bundle = new Bundle();
            bundle.putInt("key_support_bankcard", WalletCardImportUI.this.mBundle.getInt("key_support_bankcard", 3));
            bundle.putString("key_bank_type", WalletCardImportUI.this.tvu.pbn);
            bundle.putInt("key_bankcard_type", WalletCardImportUI.this.tvu.tyE);
            C24143a.m37112aE(WalletCardImportUI.this).mo64562a(WalletCardImportUI.this, WalletCardSelectUI.class, bundle, 1);
            AppMethodBeat.m2505o(47266);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$4 */
    class C368514 implements OnCheckedChangeListener {
        C368514() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(47268);
            WalletCardImportUI.m61311d(WalletCardImportUI.this);
            AppMethodBeat.m2505o(47268);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$1 */
    class C368521 implements C16094b {
        C368521() {
        }

        /* renamed from: ni */
        public final void mo28530ni(boolean z) {
            AppMethodBeat.m2504i(47265);
            final int i = z ? 8 : 0;
            C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "onSizeChanged : ".concat(String.valueOf(z)));
            WalletCardImportUI.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(47264);
                    if (i != WalletCardImportUI.this.tGo.getVisibility()) {
                        WalletCardImportUI.this.tGo.setVisibility(i);
                    }
                    AppMethodBeat.m2505o(47264);
                }
            });
            AppMethodBeat.m2505o(47265);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI$3 */
    class C368533 implements OnClickListener {
        C368533() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47267);
            WalletCardImportUI.this.showDialog(1);
            AppMethodBeat.m2505o(47267);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletCardImportUI() {
        AppMethodBeat.m2504i(47278);
        AppMethodBeat.m2505o(47278);
    }

    /* renamed from: d */
    static /* synthetic */ boolean m61311d(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.m2504i(47292);
        boolean arW = walletCardImportUI.arW();
        AppMethodBeat.m2505o(47292);
        return arW;
    }

    /* renamed from: e */
    static /* synthetic */ void m61312e(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.m2504i(47293);
        walletCardImportUI.cRs();
        AppMethodBeat.m2505o(47293);
    }

    /* renamed from: i */
    static /* synthetic */ void m61316i(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.m2504i(47295);
        walletCardImportUI.m61310cu();
        AppMethodBeat.m2505o(47295);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47279);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.fei);
        this.tvu = (ElementQuery) this.mBundle.getParcelable("elemt_query");
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.tGq = (Bankcard) this.mBundle.getParcelable("key_import_bankcard");
        if (this.pVL == null) {
            this.pVL = new PayInfo();
        }
        C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.pVL);
        initView();
        this.tGp.pageScroll(33);
        C40148d.m68847a(this, this.mBundle, 3);
        AppMethodBeat.m2505o(47279);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47280);
        this.tFE = (WalletFormView) findViewById(2131828712);
        C30890a.m49294b(this.tFE);
        this.tFn = (WalletFormView) findViewById(2131828579);
        C30890a.m49295c(this, this.tFn);
        this.tEq = (WalletFormView) findViewById(2131828681);
        C30890a.m49299e(this, this.tEq);
        this.tFm = (WalletFormView) findViewById(2131828719);
        this.trX = (WalletFormView) findViewById(2131828720);
        C30890a.m49298d(this.trX);
        this.tFS = (WalletFormView) findViewById(2131823369);
        this.tFk = (WalletFormView) findViewById(2131826502);
        C30890a.m49293b(this, this.tFk);
        this.tFj = (WalletFormView) findViewById(2131826504);
        C30890a.m49290a((MMActivity) this, this.tFj);
        this.tGo = (TextView) findViewById(2131826506);
        this.tFu = (WalletFormView) findViewById(2131828731);
        this.tFv = (WalletFormView) findViewById(2131828732);
        this.tFw = (WalletFormView) findViewById(2131828733);
        this.tFx = (WalletFormView) findViewById(2131828734);
        this.tFy = (WalletFormView) findViewById(2131828735);
        this.tFz = (WalletFormView) findViewById(2131828736);
        this.tFA = (WalletFormView) findViewById(2131828737);
        C30890a.m49300e(this.tFA);
        this.tGr = (CheckBox) findViewById(2131828739);
        this.tFI = (CheckBox) findViewById(2131828740);
        this.gEZ = (Button) findViewById(2131822846);
        this.tGp = (MMScrollView) findViewById(2131823366);
        MMScrollView mMScrollView = this.tGp;
        mMScrollView.mo28524a(mMScrollView, mMScrollView);
        this.tGp.setOnSizeChangeListener(new C368521());
        this.tEq.setOnInputValidChangeListener(this);
        this.tFE.setOnInputValidChangeListener(this);
        this.tFm.setOnInputValidChangeListener(this);
        this.trX.setOnInputValidChangeListener(this);
        this.tFn.setOnInputValidChangeListener(this);
        this.tFk.setOnInputValidChangeListener(this);
        this.tFj.setOnInputValidChangeListener(this);
        this.tFu.setOnInputValidChangeListener(this);
        this.tFv.setOnInputValidChangeListener(this);
        this.tFw.setOnInputValidChangeListener(this);
        this.tFx.setOnInputValidChangeListener(this);
        this.tFy.setOnInputValidChangeListener(this);
        this.tFz.setOnInputValidChangeListener(this);
        this.tFA.setOnInputValidChangeListener(this);
        this.tEq.setOnEditorActionListener(this);
        this.tFE.setOnEditorActionListener(this);
        this.tFm.setOnEditorActionListener(this);
        this.trX.setOnEditorActionListener(this);
        this.tFn.setOnEditorActionListener(this);
        this.tFk.setOnEditorActionListener(this);
        this.tFj.setOnEditorActionListener(this);
        this.tFu.setOnEditorActionListener(this);
        this.tFv.setOnEditorActionListener(this);
        this.tFw.setOnEditorActionListener(this);
        this.tFx.setOnEditorActionListener(this);
        this.tFy.setOnEditorActionListener(this);
        this.tFz.setOnEditorActionListener(this);
        this.tFA.setOnEditorActionListener(this);
        this.tFS.setOnClickListener(new C368502());
        this.tFm.setOnClickListener(new C368533());
        this.tGr.setChecked(true);
        this.tGr.setOnCheckedChangeListener(new C368514());
        this.tFI.setChecked(true);
        findViewById(2131826067).setOnClickListener(new C296455());
        this.tFw.setOnClickListener(new C142726());
        this.gEZ.setOnClickListener(new C142737());
        m61310cu();
        arW();
        AppMethodBeat.m2505o(47280);
    }

    /* renamed from: cu */
    private void m61310cu() {
        AppMethodBeat.m2504i(47281);
        if (this.tGq != null) {
            WalletFormView walletFormView;
            WalletFormView walletFormView2;
            findViewById(2131828709).setVisibility(0);
            if (C5046bo.isNullOrNil(this.mBundle.getString("key_bank_username"))) {
                this.tFI.setVisibility(8);
            } else {
                String string = this.mBundle.getString("key_recommand_desc");
                if (C5046bo.isNullOrNil(string)) {
                    this.tFI.setText(getString(C25738R.string.fbd, new Object[]{this.tGq.field_bankName}));
                } else {
                    this.tFI.setText(string);
                }
                this.tFI.setVisibility(0);
            }
            cRv();
            if (C5046bo.isNullOrNil(this.tGq.field_bankcardTail) || !WalletCardImportUI.m61307b(this.tFE, this.tGq.twO)) {
                this.tFE.setVisibility(8);
                walletFormView = null;
                walletFormView2 = null;
            } else {
                WalletFormView walletFormView3 = this.tFE;
                walletFormView = this.tFE;
                walletFormView2 = walletFormView3;
            }
            String string2;
            if (this.tGq.cPe()) {
                string2 = getString(C25738R.string.fdu);
            } else {
                string2 = getString(C25738R.string.fed);
            }
            if (C5046bo.isNullOrNil(this.tGq.field_bankName) || !WalletCardImportUI.m61307b(this.tFS, this.tGq.field_bankName + " " + string2)) {
                this.tFS.setVisibility(8);
            } else {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFS;
                }
                walletFormView = this.tFS;
            }
            if (WalletCardImportUI.m61307b(this.tEq, this.tGq.field_trueName)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tEq;
                }
                walletFormView = this.tEq;
            }
            if (WalletCardImportUI.m61307b(this.tFm, C14241r.cPQ().mo9419Z(this.mController.ylL, this.tGq.twf))) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFm;
                }
                walletFormView = this.tFm;
            }
            if (WalletCardImportUI.m61307b(this.trX, this.tGq.twN)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.trX;
                }
                walletFormView = this.trX;
            }
            if (WalletCardImportUI.m61307b(this.tFn, this.tGq.field_mobile)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFn;
                }
                walletFormView = this.tFn;
            }
            if (WalletCardImportUI.m61307b(this.tFk, this.tGq.twh)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFk;
                }
                walletFormView = this.tFk;
            }
            if (WalletCardImportUI.m61307b(this.tFj, this.tGq.twP)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFj;
                }
                walletFormView = this.tFj;
            }
            walletFormView2.setBackgroundResource(C25738R.drawable.f6623k5);
            walletFormView.setBackgroundResource(C25738R.drawable.f6623k5);
            if (C14241r.cPI().cQi()) {
                this.gEZ.setText(C25738R.string.fbp);
                AppMethodBeat.m2505o(47281);
                return;
            }
            this.gEZ.setText(C25738R.string.fbn);
            AppMethodBeat.m2505o(47281);
            return;
        }
        AppMethodBeat.m2505o(47281);
    }

    /* renamed from: b */
    private static boolean m61307b(WalletFormView walletFormView, String str) {
        AppMethodBeat.m2504i(47282);
        if (C5046bo.isNullOrNil(str)) {
            walletFormView.setVisibility(8);
            AppMethodBeat.m2505o(47282);
            return false;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        AppMethodBeat.m2505o(47282);
        return true;
    }

    private void cRv() {
        AppMethodBeat.m2504i(47283);
        this.tFu.setVisibility(8);
        this.tFv.setVisibility(8);
        this.tFw.setVisibility(8);
        this.tFx.setVisibility(8);
        this.tFy.setVisibility(8);
        this.tFz.setVisibility(8);
        this.tFA.setVisibility(8);
        AppMethodBeat.m2505o(47283);
    }

    private void cRs() {
        AppMethodBeat.m2504i(47284);
        if (arW()) {
            C40148d.cSP();
            this.toh = new Authen();
            this.mBundle.putBoolean("key_is_follow_bank_username", this.tFI.isChecked());
            if (this.tGq == null || C5046bo.isNullOrNil(this.tGq.txa)) {
                String text;
                boolean z;
                String string = this.mBundle.getString("key_card_id");
                if (this.tFE.getVisibility() == 0) {
                    text = this.tFE.getText();
                } else {
                    text = string;
                }
                this.toh.pGr = (PayInfo) this.mBundle.getParcelable("key_pay_info");
                this.toh.twg = text;
                this.toh.pbn = this.tvu.pbn;
                this.toh.twf = this.tsb;
                this.toh.twc = this.mBundle.getString("key_pwd1");
                if (!C5046bo.isNullOrNil(this.tFk.getText())) {
                    this.toh.twh = this.tFk.getText();
                }
                this.toh.tuk = this.tFn.getText();
                this.toh.twl = this.tFu.getText();
                this.toh.twm = this.tFv.getText();
                this.toh.country = this.tFJ;
                this.toh.duc = this.nQt;
                this.toh.dud = this.nQu;
                this.toh.fBg = this.tFx.getText();
                this.toh.nuN = this.tFy.getText();
                this.toh.gIO = this.tFz.getText();
                this.toh.dtV = this.tFA.getText();
                this.mBundle.putString("key_mobile", C36391e.atu(this.toh.tuk));
                Bundle bundle = this.mBundle;
                String str = "key_is_oversea";
                if (this.tvu.tuo == 2) {
                    z = true;
                } else {
                    z = false;
                }
                bundle.putBoolean(str, z);
                this.toh.twe = this.trX.getText();
                this.toh.twd = this.tEq.getText();
                this.toh.twi = this.tFj.getText();
                C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "payInfo " + this.toh.pGr + " elemt.bankcardTag : " + this.tvu.tuo);
            } else {
                this.toh.tlk = this.tGq.txa;
                this.toh.pbo = this.tGq.field_bindSerial;
                this.toh.pbn = this.tGq.field_bankcardType;
                this.toh.twf = this.tGq.twf;
                this.toh.twc = this.mBundle.getString("key_pwd1");
                this.toh.token = this.mBundle.getString("kreq_token");
            }
            C24143a.m37112aE(this);
            if (dOE().mo9366p(this.toh, this.pWy)) {
                C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
                AppMethodBeat.m2505o(47284);
                return;
            }
            C4990ab.m7412e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
        }
        AppMethodBeat.m2505o(47284);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47285);
        C4990ab.m7410d("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.mBundle;
            C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.pVL);
            if (c1207m instanceof C35475y) {
                bundle.putBoolean("intent_bind_end", true);
                C24143a.m37116j(this, bundle);
                C30379h.m48465bQ(this, getString(C25738R.string.f_2));
                AppMethodBeat.m2505o(47285);
                return true;
            }
            AppMethodBeat.m2505o(47285);
            return false;
        }
        AppMethodBeat.m2505o(47285);
        return false;
    }

    public final int getLayoutId() {
        return 2130971076;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(47286);
        C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.m2505o(47286);
            return;
        }
        switch (i) {
            case 1:
                this.tvu = (ElementQuery) intent.getParcelableExtra("elemt_query");
                m61310cu();
                break;
            case 2:
                String stringExtra = intent.getStringExtra("CountryName");
                String stringExtra2 = intent.getStringExtra("Country");
                this.tFJ = stringExtra + "|" + stringExtra2;
                String stringExtra3 = intent.getStringExtra("ProviceName");
                String stringExtra4 = intent.getStringExtra("CityName");
                if (!C5046bo.isNullOrNil(intent.getStringExtra("Contact_City"))) {
                    this.nQt = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                    this.nQu = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                    this.tFw.setText(stringExtra + " " + stringExtra4);
                } else if (C5046bo.isNullOrNil(intent.getStringExtra("Contact_Province"))) {
                    this.nQu = this.tFJ;
                    this.tFw.setText(stringExtra);
                } else {
                    this.nQu = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                    this.tFw.setText(stringExtra + " " + stringExtra3);
                }
                if (!"US".equals(stringExtra2) && !"CA".equals(stringExtra2) && !this.tvu.tyR) {
                    this.tFz.setVisibility(8);
                    break;
                } else {
                    this.tFz.setVisibility(0);
                    break;
                }
                break;
        }
        arW();
        AppMethodBeat.m2505o(47286);
    }

    private boolean arW() {
        boolean z;
        AppMethodBeat.m2504i(47287);
        if (this.tGr.isChecked()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
        } else {
            this.gEZ.setEnabled(false);
            this.gEZ.setClickable(false);
        }
        AppMethodBeat.m2505o(47287);
        return z;
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(47288);
        arW();
        AppMethodBeat.m2505o(47288);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(47289);
        C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(i)));
        switch (i) {
            case 5:
                if (this.tFD == null) {
                    cRs();
                } else if (this.tFD.isEnabled() && !this.tFD.isClickable() && this.tFD.dOQ()) {
                    this.tFD.dOS();
                } else {
                    this.tFD.performClick();
                }
                AppMethodBeat.m2505o(47289);
                return true;
            default:
                if (this.tFD == null) {
                    cRs();
                }
                AppMethodBeat.m2505o(47289);
                return false;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47290);
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(47290);
    }

    public Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(47291);
        switch (i) {
            case 1:
                Dialog c15532i = new C15532i(this, C25738R.style.f11166r8);
                c15532i.setContentView(2130971114);
                ListView listView = (ListView) c15532i.findViewById(2131821054);
                listView.setAdapter(this.tGs);
                listView.setOnItemClickListener(new C296468());
                AppMethodBeat.m2505o(47291);
                return c15532i;
            default:
                Dialog onCreateDialog = super.onCreateDialog(i);
                AppMethodBeat.m2505o(47291);
                return onCreateDialog;
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m61309c(WalletFormView walletFormView, int i) {
        AppMethodBeat.m2504i(47294);
        C30889b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof C30895a) {
            ((C30895a) logicDelegate).mo49420QT(i);
        }
        AppMethodBeat.m2505o(47294);
    }
}
