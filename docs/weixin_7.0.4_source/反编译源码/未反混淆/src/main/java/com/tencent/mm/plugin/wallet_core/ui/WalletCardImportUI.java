package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.MMScrollView.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.LinkedList;
import java.util.List;

public class WalletCardImportUI extends WalletBaseUI implements OnEditorActionListener, a {
    private static final String[] tGn = new String[]{"ABC_DEBIT", "ABC_CREDIT", "CITIC_CREDIT", "CMBC_DEBIT", "HSBC_DEBIT"};
    private Button gEZ;
    private Dialog mDialog = null;
    private ak mHandler = new ak();
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
    private BaseAdapter tGs = new BaseAdapter() {
        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(47277);
            Integer Hu = Hu(i);
            AppMethodBeat.o(47277);
            return Hu;
        }

        public final int getCount() {
            AppMethodBeat.i(47274);
            if (WalletCardImportUI.this.tvu.cPs() != null) {
                int size = WalletCardImportUI.this.tvu.cPs().size();
                AppMethodBeat.o(47274);
                return size;
            }
            AppMethodBeat.o(47274);
            return 0;
        }

        private Integer Hu(int i) {
            AppMethodBeat.i(47275);
            Integer num = (Integer) WalletCardImportUI.this.tvu.cPs().get(i);
            AppMethodBeat.o(47275);
            return num;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(47276);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletCardImportUI.this, R.layout.b4p, null);
            checkedTextView.setText(r.cPQ().Z(WalletCardImportUI.this, Hu(i).intValue()));
            if (WalletCardImportUI.this.tsb == Hu(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            checkedTextView.setBackgroundResource(R.drawable.k5);
            AppMethodBeat.o(47276);
            return checkedTextView;
        }
    };
    private Authen toh = new Authen();
    private WalletFormView trX;
    private int tsb = 1;
    private ElementQuery tvu = new ElementQuery();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletCardImportUI() {
        AppMethodBeat.i(47278);
        AppMethodBeat.o(47278);
    }

    static /* synthetic */ boolean d(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.i(47292);
        boolean arW = walletCardImportUI.arW();
        AppMethodBeat.o(47292);
        return arW;
    }

    static /* synthetic */ void e(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.i(47293);
        walletCardImportUI.cRs();
        AppMethodBeat.o(47293);
    }

    static /* synthetic */ void i(WalletCardImportUI walletCardImportUI) {
        AppMethodBeat.i(47295);
        walletCardImportUI.cu();
        AppMethodBeat.o(47295);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47279);
        super.onCreate(bundle);
        setMMTitle((int) R.string.fei);
        this.tvu = (ElementQuery) this.mBundle.getParcelable("elemt_query");
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.tGq = (Bankcard) this.mBundle.getParcelable("key_import_bankcard");
        if (this.pVL == null) {
            this.pVL = new PayInfo();
        }
        ab.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.pVL);
        initView();
        this.tGp.pageScroll(33);
        d.a(this, this.mBundle, 3);
        AppMethodBeat.o(47279);
    }

    public final void initView() {
        AppMethodBeat.i(47280);
        this.tFE = (WalletFormView) findViewById(R.id.f8s);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.tFE);
        this.tFn = (WalletFormView) findViewById(R.id.f57);
        com.tencent.mm.wallet_core.ui.formview.a.c(this, this.tFn);
        this.tEq = (WalletFormView) findViewById(R.id.f7y);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.tEq);
        this.tFm = (WalletFormView) findViewById(R.id.f8z);
        this.trX = (WalletFormView) findViewById(R.id.f90);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.trX);
        this.tFS = (WalletFormView) findViewById(R.id.bbc);
        this.tFk = (WalletFormView) findViewById(R.id.dm2);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.tFk);
        this.tFj = (WalletFormView) findViewById(R.id.dm4);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.tFj);
        this.tGo = (TextView) findViewById(R.id.dm6);
        this.tFu = (WalletFormView) findViewById(R.id.f9a);
        this.tFv = (WalletFormView) findViewById(R.id.f9b);
        this.tFw = (WalletFormView) findViewById(R.id.f9c);
        this.tFx = (WalletFormView) findViewById(R.id.f9d);
        this.tFy = (WalletFormView) findViewById(R.id.f9e);
        this.tFz = (WalletFormView) findViewById(R.id.f9f);
        this.tFA = (WalletFormView) findViewById(R.id.f9g);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.tFA);
        this.tGr = (CheckBox) findViewById(R.id.f9i);
        this.tFI = (CheckBox) findViewById(R.id.f9j);
        this.gEZ = (Button) findViewById(R.id.ay8);
        this.tGp = (MMScrollView) findViewById(R.id.bb_);
        MMScrollView mMScrollView = this.tGp;
        mMScrollView.a(mMScrollView, mMScrollView);
        this.tGp.setOnSizeChangeListener(new b() {
            public final void ni(boolean z) {
                AppMethodBeat.i(47265);
                final int i = z ? 8 : 0;
                ab.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : ".concat(String.valueOf(z)));
                WalletCardImportUI.this.mHandler.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(47264);
                        if (i != WalletCardImportUI.this.tGo.getVisibility()) {
                            WalletCardImportUI.this.tGo.setVisibility(i);
                        }
                        AppMethodBeat.o(47264);
                    }
                });
                AppMethodBeat.o(47265);
            }
        });
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
        this.tFS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47266);
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletCardImportUI.this.mBundle.getInt("key_support_bankcard", 3));
                bundle.putString("key_bank_type", WalletCardImportUI.this.tvu.pbn);
                bundle.putInt("key_bankcard_type", WalletCardImportUI.this.tvu.tyE);
                com.tencent.mm.wallet_core.a.aE(WalletCardImportUI.this).a(WalletCardImportUI.this, WalletCardSelectUI.class, bundle, 1);
                AppMethodBeat.o(47266);
            }
        });
        this.tFm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47267);
                WalletCardImportUI.this.showDialog(1);
                AppMethodBeat.o(47267);
            }
        });
        this.tGr.setChecked(true);
        this.tGr.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(47268);
                WalletCardImportUI.d(WalletCardImportUI.this);
                AppMethodBeat.o(47268);
            }
        });
        this.tFI.setChecked(true);
        findViewById(R.id.daa).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47270);
                List linkedList = new LinkedList();
                List linkedList2 = new LinkedList();
                linkedList.add(WalletCardImportUI.this.getString(R.string.faa));
                linkedList2.add(Integer.valueOf(0));
                if (WalletCardImportUI.this.tvu != null && WalletCardImportUI.this.tvu.tyW) {
                    linkedList.add(WalletCardImportUI.this.getString(R.string.fa9));
                    linkedList2.add(Integer.valueOf(1));
                }
                h.a(WalletCardImportUI.this, "", linkedList, linkedList2, "", new h.d() {
                    public final void bV(int i, int i2) {
                        AppMethodBeat.i(47269);
                        Intent intent = new Intent();
                        switch (i) {
                            case 0:
                                intent.putExtra("rawUrl", WalletCardImportUI.this.getString(R.string.f84, new Object[]{aa.dor()}));
                                break;
                            case 1:
                                if (WalletCardImportUI.this.tvu != null) {
                                    intent.putExtra("rawUrl", WalletCardImportUI.this.getString(R.string.f82, new Object[]{aa.dor(), WalletCardImportUI.this.tvu.pbn}));
                                    break;
                                }
                                break;
                        }
                        intent.putExtra("showShare", false);
                        com.tencent.mm.bp.d.b(WalletCardImportUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(47269);
                    }
                });
                AppMethodBeat.o(47270);
            }
        });
        this.tFw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47271);
                WalletCardImportUI.this.startActivityForResult(new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true), 2);
                AppMethodBeat.o(47271);
            }
        });
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47272);
                WalletCardImportUI.e(WalletCardImportUI.this);
                AppMethodBeat.o(47272);
            }
        });
        cu();
        arW();
        AppMethodBeat.o(47280);
    }

    private void cu() {
        AppMethodBeat.i(47281);
        if (this.tGq != null) {
            WalletFormView walletFormView;
            WalletFormView walletFormView2;
            findViewById(R.id.f8p).setVisibility(0);
            if (bo.isNullOrNil(this.mBundle.getString("key_bank_username"))) {
                this.tFI.setVisibility(8);
            } else {
                String string = this.mBundle.getString("key_recommand_desc");
                if (bo.isNullOrNil(string)) {
                    this.tFI.setText(getString(R.string.fbd, new Object[]{this.tGq.field_bankName}));
                } else {
                    this.tFI.setText(string);
                }
                this.tFI.setVisibility(0);
            }
            cRv();
            if (bo.isNullOrNil(this.tGq.field_bankcardTail) || !b(this.tFE, this.tGq.twO)) {
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
                string2 = getString(R.string.fdu);
            } else {
                string2 = getString(R.string.fed);
            }
            if (bo.isNullOrNil(this.tGq.field_bankName) || !b(this.tFS, this.tGq.field_bankName + " " + string2)) {
                this.tFS.setVisibility(8);
            } else {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFS;
                }
                walletFormView = this.tFS;
            }
            if (b(this.tEq, this.tGq.field_trueName)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tEq;
                }
                walletFormView = this.tEq;
            }
            if (b(this.tFm, r.cPQ().Z(this.mController.ylL, this.tGq.twf))) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFm;
                }
                walletFormView = this.tFm;
            }
            if (b(this.trX, this.tGq.twN)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.trX;
                }
                walletFormView = this.trX;
            }
            if (b(this.tFn, this.tGq.field_mobile)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFn;
                }
                walletFormView = this.tFn;
            }
            if (b(this.tFk, this.tGq.twh)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFk;
                }
                walletFormView = this.tFk;
            }
            if (b(this.tFj, this.tGq.twP)) {
                if (walletFormView2 == null) {
                    walletFormView2 = this.tFj;
                }
                walletFormView = this.tFj;
            }
            walletFormView2.setBackgroundResource(R.drawable.k5);
            walletFormView.setBackgroundResource(R.drawable.k5);
            if (r.cPI().cQi()) {
                this.gEZ.setText(R.string.fbp);
                AppMethodBeat.o(47281);
                return;
            }
            this.gEZ.setText(R.string.fbn);
            AppMethodBeat.o(47281);
            return;
        }
        AppMethodBeat.o(47281);
    }

    private static boolean b(WalletFormView walletFormView, String str) {
        AppMethodBeat.i(47282);
        if (bo.isNullOrNil(str)) {
            walletFormView.setVisibility(8);
            AppMethodBeat.o(47282);
            return false;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        AppMethodBeat.o(47282);
        return true;
    }

    private void cRv() {
        AppMethodBeat.i(47283);
        this.tFu.setVisibility(8);
        this.tFv.setVisibility(8);
        this.tFw.setVisibility(8);
        this.tFx.setVisibility(8);
        this.tFy.setVisibility(8);
        this.tFz.setVisibility(8);
        this.tFA.setVisibility(8);
        AppMethodBeat.o(47283);
    }

    private void cRs() {
        AppMethodBeat.i(47284);
        if (arW()) {
            d.cSP();
            this.toh = new Authen();
            this.mBundle.putBoolean("key_is_follow_bank_username", this.tFI.isChecked());
            if (this.tGq == null || bo.isNullOrNil(this.tGq.txa)) {
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
                if (!bo.isNullOrNil(this.tFk.getText())) {
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
                this.mBundle.putString("key_mobile", e.atu(this.toh.tuk));
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
                ab.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.toh.pGr + " elemt.bankcardTag : " + this.tvu.tuo);
            } else {
                this.toh.tlk = this.tGq.txa;
                this.toh.pbo = this.tGq.field_bindSerial;
                this.toh.pbn = this.tGq.field_bankcardType;
                this.toh.twf = this.tGq.twf;
                this.toh.twc = this.mBundle.getString("key_pwd1");
                this.toh.token = this.mBundle.getString("kreq_token");
            }
            com.tencent.mm.wallet_core.a.aE(this);
            if (dOE().p(this.toh, this.pWy)) {
                ab.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
                AppMethodBeat.o(47284);
                return;
            }
            ab.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
        }
        AppMethodBeat.o(47284);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47285);
        ab.d("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.mBundle;
            ab.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.pVL);
            if (mVar instanceof y) {
                bundle.putBoolean("intent_bind_end", true);
                com.tencent.mm.wallet_core.a.j(this, bundle);
                h.bQ(this, getString(R.string.f_2));
                AppMethodBeat.o(47285);
                return true;
            }
            AppMethodBeat.o(47285);
            return false;
        }
        AppMethodBeat.o(47285);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b3n;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(47286);
        ab.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(47286);
            return;
        }
        switch (i) {
            case 1:
                this.tvu = (ElementQuery) intent.getParcelableExtra("elemt_query");
                cu();
                break;
            case 2:
                String stringExtra = intent.getStringExtra("CountryName");
                String stringExtra2 = intent.getStringExtra("Country");
                this.tFJ = stringExtra + "|" + stringExtra2;
                String stringExtra3 = intent.getStringExtra("ProviceName");
                String stringExtra4 = intent.getStringExtra("CityName");
                if (!bo.isNullOrNil(intent.getStringExtra("Contact_City"))) {
                    this.nQt = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                    this.nQu = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                    this.tFw.setText(stringExtra + " " + stringExtra4);
                } else if (bo.isNullOrNil(intent.getStringExtra("Contact_Province"))) {
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
        AppMethodBeat.o(47286);
    }

    private boolean arW() {
        boolean z;
        AppMethodBeat.i(47287);
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
        AppMethodBeat.o(47287);
        return z;
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(47288);
        arW();
        AppMethodBeat.o(47288);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        AppMethodBeat.i(47289);
        ab.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(i)));
        switch (i) {
            case 5:
                if (this.tFD == null) {
                    cRs();
                } else if (this.tFD.isEnabled() && !this.tFD.isClickable() && this.tFD.dOQ()) {
                    this.tFD.dOS();
                } else {
                    this.tFD.performClick();
                }
                AppMethodBeat.o(47289);
                return true;
            default:
                if (this.tFD == null) {
                    cRs();
                }
                AppMethodBeat.o(47289);
                return false;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(47290);
        if (this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
            this.mDialog = null;
        }
        super.onDestroy();
        AppMethodBeat.o(47290);
    }

    public Dialog onCreateDialog(int i) {
        AppMethodBeat.i(47291);
        switch (i) {
            case 1:
                Dialog iVar = new i(this, R.style.r8);
                iVar.setContentView(R.layout.b4o);
                ListView listView = (ListView) iVar.findViewById(R.id.n3);
                listView.setAdapter(this.tGs);
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(47273);
                        WalletCardImportUI.this.dismissDialog(1);
                        int intValue = ((Integer) WalletCardImportUI.this.tvu.cPs().get(i)).intValue();
                        if (WalletCardImportUI.this.tsb != intValue) {
                            WalletCardImportUI.this.tsb = intValue;
                            WalletCardImportUI.this.tFm.setText(((CheckedTextView) view).getText().toString());
                            WalletCardImportUI.c(WalletCardImportUI.this.trX, WalletCardImportUI.this.tsb);
                            WalletCardImportUI.this.trX.cey();
                            WalletCardImportUI.i(WalletCardImportUI.this);
                        }
                        AppMethodBeat.o(47273);
                    }
                });
                AppMethodBeat.o(47291);
                return iVar;
            default:
                Dialog onCreateDialog = super.onCreateDialog(i);
                AppMethodBeat.o(47291);
                return onCreateDialog;
        }
    }

    static /* synthetic */ void c(WalletFormView walletFormView, int i) {
        AppMethodBeat.i(47294);
        com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) logicDelegate).QT(i);
        }
        AppMethodBeat.o(47294);
    }
}
