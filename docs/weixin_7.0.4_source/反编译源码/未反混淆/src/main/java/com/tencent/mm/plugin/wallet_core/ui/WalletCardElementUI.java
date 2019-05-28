package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
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
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.CreTypeRuleInfo;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import com.tenpay.ndk.Encrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI extends WalletBaseUI implements OnEditorActionListener, a {
    private String countryCode;
    private String fHC;
    private String fno;
    private String fnp;
    private Button gEZ;
    private String kGE;
    private String nQt;
    private String nQu;
    private PayInfo pVL = null;
    private Orders pWy = null;
    private TextView rvM;
    private TextView tEZ;
    private WalletFormView tEq;
    private Bankcard tEr = null;
    private WalletFormView tFA;
    private WalletPhoneInputView tFB;
    private ScrollView tFC;
    private WalletFormView tFD = null;
    private WalletFormView tFE;
    private Map<String, b.a> tFF = null;
    private boolean tFG = false;
    private CheckBox tFH;
    private CheckBox tFI;
    private String tFJ;
    private boolean tFK;
    private boolean tFL;
    private boolean tFM = false;
    private boolean tFN = false;
    private boolean tFO = false;
    private boolean tFP = false;
    private String[] tFQ = null;
    private String tFR;
    private WalletFormView tFS;
    private List<ElementQuery> tFT = new ArrayList();
    private int tFU;
    private int tFV;
    private int tFW;
    private int tFX;
    private int tFY;
    private int tFZ;
    private TextView tFa;
    private TextView tFb;
    private TextView tFc;
    private TextView tFd;
    private TextView tFe;
    private TextView tFf;
    private TextView tFg;
    private TextView tFh;
    private WalletFormView tFi;
    private WalletFormView tFj;
    private WalletFormView tFk;
    private WalletFormView tFl;
    private WalletFormView tFm;
    private WalletFormView tFn;
    private WalletFormView tFo;
    private WalletFormView tFp;
    private WalletFormView tFq;
    private WalletFormView tFr;
    private WalletFormView tFs;
    private WalletFormView tFt;
    private WalletFormView tFu;
    private WalletFormView tFv;
    private WalletFormView tFw;
    private WalletFormView tFx;
    private WalletFormView tFy;
    private WalletFormView tFz;
    private int tGa;
    private int tGb;
    private String tGc;
    private BaseAdapter tGd = new BaseAdapter() {
        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(47221);
            Integer Hu = Hu(i);
            AppMethodBeat.o(47221);
            return Hu;
        }

        public final int getCount() {
            AppMethodBeat.i(47218);
            if (WalletCardElementUI.this.tvu.cPs() != null) {
                int size = WalletCardElementUI.this.tvu.cPs().size();
                AppMethodBeat.o(47218);
                return size;
            }
            AppMethodBeat.o(47218);
            return 0;
        }

        private Integer Hu(int i) {
            AppMethodBeat.i(47219);
            Integer num = (Integer) WalletCardElementUI.this.tvu.cPs().get(i);
            AppMethodBeat.o(47219);
            return num;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(47220);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletCardElementUI.this, R.layout.b4p, null);
            checkedTextView.setText(r.cPQ().Z(WalletCardElementUI.this, Hu(i).intValue()));
            if (WalletCardElementUI.this.tsb == Hu(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            AppMethodBeat.o(47220);
            return checkedTextView;
        }
    };
    private OnClickListener tGe = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(47222);
            h.pYm.e(11353, Integer.valueOf(2), Integer.valueOf(0));
            e.d(WalletCardElementUI.this, r.cPI().bhp());
            AppMethodBeat.o(47222);
        }
    };
    private Authen toh = new Authen();
    b tpu = null;
    private c trF = new c<pn>() {
        {
            AppMethodBeat.i(47223);
            this.xxI = pn.class.getName().hashCode();
            AppMethodBeat.o(47223);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(47224);
            pn pnVar = (pn) bVar;
            if (pnVar instanceof pn) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletCardElementUI.a(WalletCardElementUI.this, encrypt.desedeEncode(pnVar.cLJ.cardId, randomKey), randomKey, pnVar.cLJ.cLK);
                AppMethodBeat.o(47224);
                return true;
            }
            ab.f("MicroMsg.WalletCardElmentUI", "mismatched scanBandkCardResultEvent event");
            AppMethodBeat.o(47224);
            return false;
        }
    };
    private WalletFormView trX;
    private TextView trY;
    private TextView trZ;
    private int tsb = 1;
    private Profession[] tur;
    private ElementQuery tvu = new ElementQuery();
    private Profession tvv;
    private boolean tyN = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletCardElementUI() {
        AppMethodBeat.i(47237);
        AppMethodBeat.o(47237);
    }

    static /* synthetic */ boolean b(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.i(47258);
        boolean arW = walletCardElementUI.arW();
        AppMethodBeat.o(47258);
        return arW;
    }

    static /* synthetic */ void g(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.i(47259);
        walletCardElementUI.cu();
        AppMethodBeat.o(47259);
    }

    static /* synthetic */ void j(WalletCardElementUI walletCardElementUI, int i) {
        AppMethodBeat.i(47262);
        walletCardElementUI.Hj(i);
        AppMethodBeat.o(47262);
    }

    static /* synthetic */ void u(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.i(47260);
        walletCardElementUI.cRs();
        AppMethodBeat.o(47260);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(47238);
        super.onCreate(bundle);
        this.tvu = (ElementQuery) this.mBundle.getParcelable("elemt_query");
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.tsb = r.cPI().cQq();
        this.tEr = (Bankcard) this.mBundle.getParcelable("key_history_bankcard");
        this.tFK = this.mBundle.getBoolean("key_need_area", false);
        this.tFL = this.mBundle.getBoolean("key_need_profession", false);
        this.tyN = this.mBundle.getBoolean("key_need_country", false);
        this.tFQ = this.mBundle.getStringArray("key_country_excludes");
        ab.d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", Boolean.valueOf(this.tyN));
        if (this.tFK || this.tFL) {
            setMMTitle((int) R.string.fej);
        } else {
            setMMTitle((int) R.string.fei);
        }
        Parcelable[] parcelableArray = this.mBundle.getParcelableArray("key_profession_list");
        if (parcelableArray != null) {
            this.tur = new Profession[parcelableArray.length];
            while (i < parcelableArray.length) {
                this.tur[i] = (Profession) parcelableArray[i];
                i++;
            }
        }
        if (this.pVL == null) {
            this.pVL = new PayInfo();
        }
        ab.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.pVL);
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.mBundle.getParcelable("key_favor_pay_info");
        if (!(this.pWy == null || favorPayInfo == null)) {
            this.tpu = c.tDU.a(this.pWy);
            if (this.tpu != null) {
                this.tFF = this.tpu.acR(this.tpu.acW(favorPayInfo.tzb));
            } else {
                ab.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
            }
        }
        initView();
        this.tFC.pageScroll(33);
        d.a(this, this.mBundle, 3);
        com.tencent.mm.sdk.b.a.xxA.c(this.trF);
        AppMethodBeat.o(47238);
    }

    public final void initView() {
        AppMethodBeat.i(47239);
        this.tEZ = (TextView) findViewById(R.id.f8q);
        this.tFE = (WalletFormView) findViewById(R.id.f8s);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.tFE);
        this.tFa = (TextView) findViewById(R.id.f8t);
        this.trY = (TextView) findViewById(R.id.f8y);
        this.tEq = (WalletFormView) findViewById(R.id.f7y);
        this.tFl = (WalletFormView) findViewById(R.id.f8r);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.tEq);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.tFl);
        this.tFm = (WalletFormView) findViewById(R.id.f8z);
        this.trX = (WalletFormView) findViewById(R.id.f90);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.trX);
        this.trZ = (TextView) findViewById(R.id.f99);
        this.tFb = (TextView) findViewById(R.id.bbb);
        this.tFi = (WalletFormView) findViewById(R.id.f8u);
        this.tFS = (WalletFormView) findViewById(R.id.bbc);
        this.tFc = (TextView) findViewById(R.id.f8w);
        this.tFg = (TextView) findViewById(R.id.f8v);
        this.tFd = (TextView) findViewById(R.id.f8x);
        this.tFk = (WalletFormView) findViewById(R.id.dm2);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.tFk);
        this.tFj = (WalletFormView) findViewById(R.id.dm4);
        com.tencent.mm.wallet_core.ui.formview.a.a((MMActivity) this, this.tFj);
        this.tFe = (TextView) findViewById(R.id.dm3);
        this.rvM = (TextView) findViewById(R.id.f9_);
        this.tFu = (WalletFormView) findViewById(R.id.f9a);
        this.tFv = (WalletFormView) findViewById(R.id.f9b);
        this.tFw = (WalletFormView) findViewById(R.id.f9c);
        this.tFx = (WalletFormView) findViewById(R.id.f9d);
        this.tFy = (WalletFormView) findViewById(R.id.f9e);
        this.tFz = (WalletFormView) findViewById(R.id.f9f);
        this.tFA = (WalletFormView) findViewById(R.id.f9g);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.tFA);
        this.tFf = (TextView) findViewById(R.id.f9h);
        this.tFH = (CheckBox) findViewById(R.id.f9i);
        this.tFI = (CheckBox) findViewById(R.id.f9j);
        this.gEZ = (Button) findViewById(R.id.ay8);
        this.tFC = (ScrollView) findViewById(R.id.bb_);
        this.tFo = (WalletFormView) findViewById(R.id.f94);
        this.tFp = (WalletFormView) findViewById(R.id.f95);
        this.tFq = (WalletFormView) findViewById(R.id.f92);
        this.tFr = (WalletFormView) findViewById(R.id.f91);
        this.tFs = (WalletFormView) findViewById(R.id.f96);
        this.tFt = (WalletFormView) findViewById(R.id.f97);
        this.tFh = (TextView) findViewById(R.id.f93);
        this.tFB = (WalletPhoneInputView) findViewById(R.id.f98);
        this.tFn = this.tFB.getPhoneNumberEt();
        this.tEq.setOnInputValidChangeListener(this);
        this.tFl.setOnInputValidChangeListener(this);
        this.tFE.setOnInputValidChangeListener(this);
        this.tFm.setOnInputValidChangeListener(this);
        this.trX.setOnInputValidChangeListener(this);
        this.tFn.setOnInputValidChangeListener(new a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(47211);
                if (!z) {
                    WalletCardElementUI.this.tEr = null;
                    WalletCardElementUI.this.mBundle.putParcelable("key_history_bankcard", null);
                }
                WalletCardElementUI.b(WalletCardElementUI.this);
                AppMethodBeat.o(47211);
            }
        });
        this.tFk.setOnInputValidChangeListener(this);
        this.tFj.setOnInputValidChangeListener(this);
        this.tFu.setOnInputValidChangeListener(this);
        this.tFv.setOnInputValidChangeListener(this);
        this.tFw.setOnInputValidChangeListener(this);
        this.tFx.setOnInputValidChangeListener(this);
        this.tFy.setOnInputValidChangeListener(this);
        this.tFz.setOnInputValidChangeListener(this);
        this.tFA.setOnInputValidChangeListener(this);
        this.tFo.setOnInputValidChangeListener(this);
        this.tFp.setOnInputValidChangeListener(this);
        this.tEq.setOnEditorActionListener(this);
        this.tFl.setOnEditorActionListener(this);
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
        this.tFp.setOnEditorActionListener(this);
        this.tFo.setOnEditorActionListener(this);
        this.tFi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47225);
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletCardElementUI.this.mBundle.getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", WalletCardElementUI.this.mBundle.getInt("key_bind_scene", -1));
                bo.isNullOrNil(WalletCardElementUI.this.tFi.getText());
                WalletCardElementUI.this.aoB();
                com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(WalletCardElementUI.this);
                if (aE != null) {
                    aE.a(WalletCardElementUI.this, WalletBankCardSelectUI.class, bundle, 1);
                }
                AppMethodBeat.o(47225);
            }
        });
        this.tFS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47227);
                ArrayList arrayList = new ArrayList();
                arrayList.add(WalletCardElementUI.this.getString(R.string.fed));
                arrayList.add(WalletCardElementUI.this.getString(R.string.fdu));
                if (WalletCardElementUI.this.tFT.size() == 1) {
                    ElementQuery elementQuery = (ElementQuery) WalletCardElementUI.this.tFT.get(0);
                    if (elementQuery.cPr()) {
                        arrayList.remove(1);
                    } else if (elementQuery.cPe()) {
                        arrayList.remove(0);
                    }
                }
                final com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.mController.ylL, arrayList);
                bVar.Qq(WalletCardElementUI.this.tFU);
                bVar.zSq = new com.tencent.mm.ui.widget.picker.b.a() {
                    public final void d(boolean z, Object obj) {
                        AppMethodBeat.i(47226);
                        bVar.hide();
                        if (z) {
                            Object obj2;
                            String str = (String) obj;
                            WalletCardElementUI.this.tFS.setText(str);
                            if (str.equals(WalletCardElementUI.this.getString(R.string.fdu))) {
                                obj2 = null;
                            } else {
                                int obj22 = 1;
                            }
                            for (ElementQuery elementQuery : WalletCardElementUI.this.tFT) {
                                if ((obj22 != null && elementQuery.cPr()) || (obj22 == null && elementQuery.cPe())) {
                                    WalletCardElementUI.this.tvu = elementQuery;
                                    WalletCardElementUI.g(WalletCardElementUI.this);
                                    break;
                                }
                            }
                        }
                        WalletCardElementUI.this.tFU = bVar.dLl();
                        AppMethodBeat.o(47226);
                    }
                };
                bVar.Qp(com.tencent.mm.bz.a.fromDPToPix(WalletCardElementUI.this.mController.ylL, com.tencent.view.d.MIC_PTU_YOUJIALI));
                bVar.show();
                AppMethodBeat.o(47227);
            }
        });
        this.tFm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47228);
                WalletCardElementUI.this.showDialog(1);
                AppMethodBeat.o(47228);
            }
        });
        final String[] strArr = new String[100];
        for (int i = 0; i < 100; i++) {
            strArr[i] = getString(R.string.fdt, new Object[]{Integer.valueOf(i)});
        }
        this.tFq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47230);
                final com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(WalletCardElementUI.this.mController.ylL, strArr);
                bVar.zSq = new com.tencent.mm.ui.widget.picker.b.a() {
                    public final void d(boolean z, Object obj) {
                        AppMethodBeat.i(47229);
                        if (z) {
                            WalletCardElementUI.this.tFq.setText((String) obj);
                            WalletCardElementUI.this.tFV = bVar.dLl();
                            WalletCardElementUI.b(WalletCardElementUI.this);
                        }
                        bVar.hide();
                        AppMethodBeat.o(47229);
                    }
                };
                bVar.Qq(WalletCardElementUI.this.tFV);
                bVar.show();
                AppMethodBeat.o(47230);
            }
        });
        this.tFr.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47232);
                final com.tencent.mm.ui.widget.picker.a aVar = new com.tencent.mm.ui.widget.picker.a(WalletCardElementUI.this.mController.ylL);
                aVar.zSj = new com.tencent.mm.ui.widget.picker.a.a() {
                    public final void b(boolean z, int i, int i2, int i3) {
                        AppMethodBeat.i(47231);
                        if (z) {
                            WalletCardElementUI.this.tFr.setText(String.format("%04d%02d%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
                            WalletCardElementUI.this.tFW = i;
                            WalletCardElementUI.this.tFX = i2;
                            WalletCardElementUI.this.tFY = i3;
                            WalletCardElementUI.b(WalletCardElementUI.this);
                        }
                        aVar.hide();
                        AppMethodBeat.o(47231);
                    }
                };
                if (WalletCardElementUI.this.tFW > 0 && WalletCardElementUI.this.tFX > 0 && WalletCardElementUI.this.tFY > 0) {
                    aVar.aB(WalletCardElementUI.this.tFW, WalletCardElementUI.this.tFX, WalletCardElementUI.this.tFY);
                }
                aVar.show();
                AppMethodBeat.o(47232);
            }
        });
        this.tFp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47233);
                Intent intent = new Intent();
                intent.putExtra("GetAddress", true);
                intent.putExtra("ShowSelectedLocation", false);
                if (!Bankcard.Ho(WalletCardElementUI.this.tvu.tuo)) {
                    intent.putExtra("IsRealNameVerifyScene", true);
                    intent.putExtra("IsNeedShowSearchBar", true);
                }
                com.tencent.mm.bp.d.b(WalletCardElementUI.this.mController.ylL, ".ui.tools.MultiStageCitySelectUI", intent, 4);
                AppMethodBeat.o(47233);
            }
        });
        this.tFo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47234);
                Intent intent = new Intent(WalletCardElementUI.this.mController.ylL, WalletSelectProfessionUI.class);
                intent.putExtra("key_profession_list", WalletCardElementUI.this.tur);
                WalletCardElementUI.this.startActivityForResult(intent, 5);
                AppMethodBeat.o(47234);
            }
        });
        this.tFs.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47236);
                final com.tencent.mm.ui.widget.picker.a aVar = new com.tencent.mm.ui.widget.picker.a(WalletCardElementUI.this.mController.ylL);
                aVar.zSj = new com.tencent.mm.ui.widget.picker.a.a() {
                    public final void b(boolean z, int i, int i2, int i3) {
                        AppMethodBeat.i(47235);
                        if (z) {
                            WalletCardElementUI.this.tFs.setText(String.format("%04d%02d%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
                            WalletCardElementUI.this.tFZ = i;
                            WalletCardElementUI.this.tGa = i2;
                            WalletCardElementUI.this.tGb = i3;
                            WalletCardElementUI.b(WalletCardElementUI.this);
                        }
                        aVar.hide();
                        AppMethodBeat.o(47235);
                    }
                };
                if (WalletCardElementUI.this.tFZ > 0 && WalletCardElementUI.this.tGa > 0 && WalletCardElementUI.this.tGb > 0) {
                    aVar.aB(WalletCardElementUI.this.tFZ, WalletCardElementUI.this.tGa, WalletCardElementUI.this.tGb);
                }
                aVar.show();
                AppMethodBeat.o(47236);
            }
        });
        this.tFt.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47212);
                Intent intent = new Intent();
                intent.setClassName(WalletCardElementUI.this.mController.ylL, "com.tencent.mm.ui.tools.CountryCodeUI");
                intent.putExtra("exclude_countries_iso", WalletCardElementUI.this.tFQ);
                intent.putExtra("CountryCodeUI_isShowCountryCode", false);
                intent.putExtra("ui_title", WalletCardElementUI.this.getString(R.string.fsy));
                WalletCardElementUI.this.startActivityForResult(intent, 6);
                AppMethodBeat.o(47212);
            }
        });
        this.tFH.setChecked(true);
        this.tFH.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(47213);
                WalletCardElementUI.b(WalletCardElementUI.this);
                AppMethodBeat.o(47213);
            }
        });
        findViewById(R.id.daa).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47214);
                e.a(WalletCardElementUI.this, WalletCardElementUI.this.tvu.pbn, WalletCardElementUI.this.tvu.nuL, false, WalletCardElementUI.this.tvu.tyW);
                AppMethodBeat.o(47214);
            }
        });
        this.tFw.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47215);
                Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
                if (Bankcard.Ho(WalletCardElementUI.this.tvu.tuo)) {
                    putExtra.putExtra("IsAutoPosition", false);
                } else {
                    putExtra.putExtra("IsRealNameVerifyScene", true);
                    putExtra.putExtra("IsNeedShowSearchBar", true);
                }
                WalletCardElementUI.this.startActivityForResult(putExtra, 2);
                AppMethodBeat.o(47215);
            }
        });
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47216);
                WalletCardElementUI.u(WalletCardElementUI.this);
                AppMethodBeat.o(47216);
            }
        });
        e(this.tFE, 0, false);
        e(this.trX, 1, false);
        a(this.tFn, 0, false, true, true);
        if (this.tvu != null && !bo.isNullOrNil(this.tvu.tyK)) {
            com.tencent.mm.ui.base.h.a((Context) this, this.tvu.tyK, null, true, null);
            this.tvu = null;
        } else if (this.mBundle.getInt("key_bind_scene", -1) == 5 && !this.tvu.tza) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.fvw), null, true, null);
            this.tvu.nuL = null;
        }
        cu();
        arW();
        com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
        if (aE != null && aE.dNG()) {
            Orders orders = (Orders) this.mBundle.getParcelable("key_orders");
            if (orders == null || orders.tAb != 1) {
                this.tFG = false;
            } else {
                this.tFG = true;
                this.tEq.setText(e.att(orders.twd));
                this.tEq.setEnabled(false);
                this.tEq.setFocusable(false);
                this.tsb = orders.tAc;
                this.tFm.setText(r.cPQ().Z(this, this.tsb));
                this.tFm.setEnabled(false);
                this.trX.setText(orders.tyA);
                this.trX.setInputEnable(false);
                this.trX.setFocusable(false);
                this.trY.setText(R.string.faf);
                AppMethodBeat.o(47239);
                return;
            }
        }
        AppMethodBeat.o(47239);
    }

    private void cRr() {
        AppMethodBeat.i(47240);
        if (this.tvu.tyY == 0) {
            this.tFB.cSB();
            AppMethodBeat.o(47240);
            return;
        }
        this.tFB.cSC();
        EditText editText = (EditText) this.tFB.findViewById(R.id.ffx);
        a(this.tFB.getPhoneNumberEt(), editText, 0, false, false, true);
        AppMethodBeat.o(47240);
    }

    private void cu() {
        AppMethodBeat.i(47241);
        if (this.tvu == null) {
            this.tvu = new ElementQuery();
        }
        ab.i("MicroMsg.WalletCardElmentUI", "element: %s, %s", this.tvu.nuL, this.tvu.pbn);
        cRr();
        cRt();
        com.tencent.mm.wallet_core.a.aE(this);
        Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        if (!cRu() || bankcard == null) {
            if (!bo.isNullOrNil(this.tvu.nuL)) {
                this.tFi.setText(this.tvu.nuL);
                if (this.tvu.cPe()) {
                    this.tFS.setVisibility(0);
                    this.tFS.setText(getString(R.string.fdu));
                } else if (this.tvu.cPr()) {
                    this.tFS.setVisibility(0);
                    this.tFS.setText(getString(R.string.fed));
                }
            }
            a(new boolean[]{false}, new WalletFormView[]{this.tFE}, this.tEZ, this.tFa, true);
            a(new boolean[]{true}, new WalletFormView[]{this.tFi}, this.tFb, this.tFc, true);
            this.tFE.setOnInfoIvClickListener(this.tGe);
            if (r.cPI().cQo().cPX()) {
                this.tFE.getInfoIv().setImageResource(R.raw.wallet_scan_camera);
                this.tFE.getInfoIv().setVisibility(0);
            } else {
                this.tFE.getInfoIv().setVisibility(4);
            }
        } else {
            this.tFE.setHint(getString(R.string.fbe, new Object[]{bankcard.field_bankcardTail}));
            a(new boolean[]{true}, new WalletFormView[]{this.tFE}, this.tEZ, this.tFa);
            a(new boolean[]{false}, new WalletFormView[]{this.tFi}, this.tFb, this.tFc);
        }
        this.tFM = false;
        this.tFN = false;
        this.tFO = false;
        this.tFP = false;
        if (!(this.tvu.tyZ == null || this.tvu.tyZ.isEmpty())) {
            ab.i("MicroMsg.WalletCardElmentUI", "identity type： %s", Integer.valueOf(this.tsb));
            Iterator it = this.tvu.tyZ.iterator();
            while (it.hasNext()) {
                CreTypeRuleInfo creTypeRuleInfo = (CreTypeRuleInfo) it.next();
                if (creTypeRuleInfo.txX == this.tsb) {
                    if (creTypeRuleInfo.txY.txT == 1) {
                        ab.i("MicroMsg.WalletCardElmentUI", "need show cre count");
                        this.tFM = true;
                    }
                    if (creTypeRuleInfo.txY.txV == 1) {
                        ab.i("MicroMsg.WalletCardElmentUI", "need show cre expire");
                        this.tFN = true;
                    }
                    if (creTypeRuleInfo.txY.txU == 1) {
                        ab.i("MicroMsg.WalletCardElmentUI", "need show birthday");
                        this.tFO = true;
                    }
                    if (creTypeRuleInfo.txY.txW == 1) {
                        ab.i("MicroMsg.WalletCardElmentUI", "need show cre type");
                        if (r.cPI().cQq() > 0) {
                            ab.i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
                            this.tFP = true;
                        }
                    }
                }
            }
        }
        if (!this.tFN) {
            this.tFW = 0;
            this.tFX = 0;
            this.tFY = 0;
        }
        if (!this.tFO) {
            this.tFZ = 0;
            this.tGa = 0;
            this.tGb = 0;
        }
        if (!this.tFM) {
            this.tFV = 0;
        }
        this.tFl.setVisibility(8);
        boolean[] zArr;
        boolean z;
        if (Bankcard.Ho(this.tvu.tuo)) {
            a(new boolean[]{false, false, false, false, false}, new WalletFormView[]{this.tEq, this.tFm, this.trX, this.tFq, this.tFr}, this.trY, this.trZ);
            this.tFn.setVisibility(8);
            nh(true);
            zArr = new boolean[4];
            zArr[0] = false;
            zArr[1] = false;
            zArr[2] = this.tFO;
            if (this.tsb == 2 && this.tyN) {
                z = true;
            } else {
                z = false;
            }
            zArr[3] = z;
            a(zArr, new WalletFormView[]{this.tFp, this.tFo, this.tFs, this.tFt}, this.tFh, null);
        } else {
            int i = (this.tvu.cPs() == null || this.tvu.cPs().size() <= 0) ? 0 : 1;
            if (cRu() || r.cPI().cQi()) {
                String bhp = r.cPI().bhp();
                if (bo.isNullOrNil(bhp) && dOD() != null) {
                    bhp = dOD().mqu.getString("key_true_name");
                }
                if (bo.isNullOrNil(bhp)) {
                    bhp = getString(R.string.fcq);
                    this.tEq.setHint(bhp);
                    this.tFl.setHint(bhp);
                } else {
                    bhp = getString(R.string.fcr, new Object[]{e.att(bhp)});
                    this.tEq.setHint(bhp);
                    this.tFl.setHint(bhp);
                }
                if (!cRu() || bo.isNullOrNil(this.mBundle.getString("key_identity")) || this.mBundle.getInt("key_id_type", -1) == -1 || bo.isNullOrNil(this.mBundle.getString("key_true_name"))) {
                    zArr = new boolean[5];
                    zArr[0] = true;
                    z = this.tFP || i != 0;
                    zArr[1] = z;
                    zArr[2] = true;
                    zArr[3] = this.tFM;
                    zArr[4] = this.tFN;
                    a(zArr, new WalletFormView[]{this.tEq, this.tFm, this.trX, this.tFq, this.tFr}, this.trY, this.trZ);
                } else {
                    ab.i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
                    a(new boolean[]{false, false, false, this.tFM, this.tFN}, new WalletFormView[]{this.tEq, this.tFm, this.trX, this.tFq, this.tFr}, this.trY, this.trZ);
                    this.kGE = this.mBundle.getString("key_true_name");
                    ab.i("MicroMsg.WalletCardElmentUI", "name is " + this.kGE);
                }
                this.tFn.setVisibility(0);
            } else {
                zArr = new boolean[5];
                zArr[0] = this.tvu.tyw;
                if (this.tFP || (i != 0 && this.tvu.tyx)) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[1] = z;
                zArr[2] = this.tvu.tyx;
                zArr[3] = this.tFM;
                zArr[4] = this.tFN;
                a(zArr, new WalletFormView[]{this.tEq, this.tFm, this.trX, this.tFq, this.tFr}, this.trY, this.trZ);
                this.tFn.setVisibility(0);
                ab.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.tvu.tyw + " canModifyIdentity:" + this.tvu.tyx);
            }
            if (this.tEr != null) {
                if (!bo.isNullOrNil(this.tEr.field_mobile)) {
                    a(this.tFn, this.tEr.field_mobile);
                }
                if (!bo.isNullOrNil(this.tEr.twh)) {
                    a(this.tFk, this.tEr.twh);
                }
                if (!bo.isNullOrNil(this.tEr.twP)) {
                    a(this.tFj, this.tEr.twP);
                }
            }
            if (this.tvu.tyw) {
                this.trZ.setText("");
            } else {
                this.trZ.setText(getString(R.string.fbk));
            }
            this.trX.setText(this.tvu.tyA);
            if (r.cPI().cQq() > 0) {
                ab.i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", Integer.valueOf(r.cPI().cQq()));
                this.tFm.setClickable(false);
                this.tFm.setText(r.cPQ().fk(this));
                this.tFm.setInputEnable(false);
                a(this.trX, this.tsb);
            } else {
                ab.i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", Integer.valueOf(this.tGd.getCount()));
                if (this.tGd.getCount() <= 1) {
                    this.tFm.setClickable(false);
                    this.tFm.setInputEnable(false);
                    this.trX.setInputEnable(true);
                } else {
                    this.tFm.setClickable(true);
                    this.tFm.setInputEnable(true);
                    this.trX.setInputEnable(true);
                }
                List cPs = this.tvu.cPs();
                if (cPs == null || !cPs.contains(Integer.valueOf(this.tsb))) {
                    this.tsb = 1;
                }
                if (!r.cPQ().Z(this, this.tsb).equals(this.tGc)) {
                    h.pYm.e(16816, Integer.valueOf(this.tsb));
                }
                this.tFm.setText(r.cPQ().Z(this, this.tsb));
            }
            Hj(this.tsb);
            nh(false);
            zArr = new boolean[4];
            zArr[0] = this.tFK;
            zArr[1] = this.tFL;
            zArr[2] = this.tFO;
            if (this.tsb == 2 && this.tyN) {
                z = true;
            } else {
                z = false;
            }
            zArr[3] = z;
            a(zArr, new WalletFormView[]{this.tFp, this.tFo, this.tFs, this.tFt}, this.tFh, null);
        }
        a(new boolean[]{this.tvu.tyy, this.tvu.tyz}, new WalletFormView[]{this.tFk, this.tFj}, this.tFd, this.tFe);
        if (this.tFi.getVisibility() == 0) {
            switch (this.tvu.tyD) {
                case 1:
                    this.tFc.setVisibility(8);
                    break;
                case 2:
                    this.tFc.setVisibility(8);
                    break;
                case 3:
                    this.tFc.setText(R.string.fam);
                    this.tFc.setVisibility(0);
                    break;
                case 4:
                    this.tFc.setVisibility(8);
                    break;
                default:
                    this.tFc.setVisibility(8);
                    break;
            }
            this.tFc.setTextColor(getResources().getColor(R.color.w0));
        } else {
            this.tFc.setVisibility(8);
        }
        if (!(bo.isNullOrNil(this.tvu.tyX) || this.tFc.getVisibility() == 0)) {
            ab.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
            this.tFc.setText(this.tvu.tyX);
            this.tFc.setVisibility(0);
        }
        if (bo.isNullOrNil(this.tvu.tyI) || !t.mY(this.tvu.tyI) || cRu()) {
            this.tFI.setVisibility(8);
            AppMethodBeat.o(47241);
            return;
        }
        this.tFI.setText(this.tvu.tyJ);
        this.tFI.setVisibility(0);
        AppMethodBeat.o(47241);
    }

    private static void a(WalletFormView walletFormView, String str) {
        AppMethodBeat.i(47242);
        if (bo.isNullOrNil(str)) {
            walletFormView.setVisibility(8);
            AppMethodBeat.o(47242);
            return;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        AppMethodBeat.o(47242);
    }

    private void nh(boolean z) {
        int i = 0;
        AppMethodBeat.i(47243);
        if (z) {
            int i2;
            this.rvM.setVisibility(this.tvu.tyL ? 0 : 8);
            WalletFormView walletFormView = this.tFu;
            if (this.tvu.tyL) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.tFv;
            if (this.tvu.tyM) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.tFw;
            if (this.tvu.tyN) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.tFx;
            if (this.tvu.tyQ) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.tFy;
            if (this.tvu.tyS) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.tFz;
            if (this.tvu.tyR) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            WalletFormView walletFormView2 = this.tFA;
            if (!this.tvu.tyT) {
                i = 8;
            }
            walletFormView2.setVisibility(i);
            this.tFf.setVisibility(4);
            AppMethodBeat.o(47243);
            return;
        }
        this.rvM.setVisibility(8);
        this.tFu.setVisibility(8);
        this.tFv.setVisibility(8);
        this.tFw.setVisibility(8);
        this.tFx.setVisibility(8);
        this.tFy.setVisibility(8);
        this.tFz.setVisibility(8);
        this.tFA.setVisibility(8);
        this.tFf.setVisibility(8);
        AppMethodBeat.o(47243);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2, boolean z) {
        AppMethodBeat.i(47244);
        int length = zArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                i = 1;
                walletFormViewArr[i2].setVisibility(0);
            } else {
                walletFormViewArr[i2].setVisibility(8);
                walletFormViewArr[i2].cey();
            }
        }
        if (i != 0) {
            textView.setVisibility(0);
            if (textView2 != null) {
                if (z) {
                    textView2.setVisibility(8);
                    AppMethodBeat.o(47244);
                    return;
                }
                textView2.setVisibility(4);
                AppMethodBeat.o(47244);
                return;
            }
        }
        textView.setVisibility(8);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        AppMethodBeat.o(47244);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2) {
        AppMethodBeat.i(47245);
        a(zArr, walletFormViewArr, textView, textView2, false);
        AppMethodBeat.o(47245);
    }

    private void cRs() {
        AppMethodBeat.i(47246);
        if (arW()) {
            String text;
            d.cSP();
            if (!bo.isNullOrNil(this.tvu.tyI)) {
                boolean z;
                Bundle bundle = this.mBundle;
                String str = "key_is_follow_bank_username";
                if (this.tFI.getVisibility() == 0 && this.tFI.isChecked()) {
                    z = true;
                } else {
                    z = false;
                }
                bundle.putBoolean(str, z);
                this.mBundle.putString("key_bank_username", this.tvu.tyI);
            }
            FavorPayInfo favorPayInfo = (FavorPayInfo) this.mBundle.getParcelable("key_favor_pay_info");
            if (!(this.tvu == null || favorPayInfo == null || this.tpu == null || this.tFF == null)) {
                if (this.tFF.containsKey(this.tvu.pbn)) {
                    favorPayInfo.tzb = ((b.a) this.tFF.get(this.tvu.pbn)).tDR.tnk;
                } else {
                    favorPayInfo.tzb = this.tpu.bC(favorPayInfo.tzb, false);
                }
                this.mBundle.putParcelable("key_favor_pay_info", favorPayInfo);
            }
            this.toh = new Authen();
            if (this.tEr != null) {
                this.toh.pbo = this.tEr.twQ;
                this.toh.twj = this.tEr.field_bankcardTail;
            }
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
            text = e.atu(this.toh.tuk);
            this.mBundle.putString("key_mobile", text);
            this.mBundle.putBoolean("key_is_oversea", this.tvu.tuo == 2);
            this.toh.twe = this.trX.getText();
            this.toh.twd = this.tEq.getText();
            this.toh.twi = this.tFj.getText();
            favorPayInfo = (FavorPayInfo) this.mBundle.getParcelable("key_favor_pay_info");
            if (favorPayInfo != null) {
                this.toh.twn = favorPayInfo.tze;
                this.toh.two = favorPayInfo.tzb;
            }
            this.toh.twt = "+" + this.tFB.getCountryCode();
            this.toh.twu = this.tFV;
            this.toh.tww = this.tFr.getText();
            this.toh.twv = this.tFs.getText();
            ab.d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", Integer.valueOf(this.toh.twu), this.toh.tww, this.toh.twv);
            if (!(!cRu() || bo.isNullOrNil(this.mBundle.getString("key_identity")) || this.mBundle.getInt("key_id_type", -1) == -1 || bo.isNullOrNil(this.mBundle.getString("key_true_name")))) {
                ab.i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
                this.toh.twe = this.mBundle.getString("key_identity");
                this.toh.twf = this.mBundle.getInt("key_id_type", -1);
                this.toh.twd = this.kGE;
                ab.i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.toh.twd);
            }
            ab.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.toh.pGr + " elemt.bankcardTag : " + this.tvu.tuo);
            ab.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.tvu.tuo);
            Bundle bundle2 = this.mBundle;
            bundle2.putString("key_mobile", text);
            bundle2.putParcelable("key_authen", this.toh);
            bundle2.putString("key_bank_phone", this.tvu.tyH);
            bundle2.putString("key_country_code", this.countryCode);
            bundle2.putString("key_province_code", this.fnp);
            bundle2.putString("key_city_code", this.fno);
            bundle2.putParcelable("key_profession", this.tvv);
            bundle2.putString("key_country_iso", this.fHC);
            bundle2.putString("key_bind_card_type", this.toh.pbn);
            bundle2.putString("key_bind_card_show1", this.tvu.nuL);
            bundle2.putString("key_bind_card_show2", 2 == this.tvu.tyE ? getString(R.string.fdu) : getString(R.string.fed));
            if (dOE().p(this.toh, this.pWy)) {
                ab.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
                AppMethodBeat.o(47246);
                return;
            }
            ab.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
        }
        AppMethodBeat.o(47246);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47247);
        ab.i("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.mBundle;
            ab.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.pVL);
            if (mVar instanceof y) {
                ab.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
                com.tencent.mm.wallet_core.a.j(this, bundle);
                AppMethodBeat.o(47247);
                return true;
            }
            AppMethodBeat.o(47247);
            return false;
        }
        AppMethodBeat.o(47247);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b3m;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(47248);
        ab.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (this.tFB.e(i, i2, intent)) {
            AppMethodBeat.o(47248);
        } else if (i == 6 && i2 == 100) {
            if (!bo.isNullOrNil(intent.getStringExtra("country_name"))) {
                this.fHC = intent.getStringExtra("iso_code");
                this.tFt.setText(intent.getStringExtra("country_name"));
            }
            AppMethodBeat.o(47248);
        } else if (i2 != -1) {
            AppMethodBeat.o(47248);
        } else {
            String stringExtra;
            String stringExtra2;
            String stringExtra3;
            switch (i) {
                case 1:
                    this.tvu = null;
                    this.tFU = 0;
                    this.tFR = intent.getStringExtra("bank_name");
                    this.tFi.setText(this.tFR);
                    this.tFS.setVisibility(0);
                    this.tFS.setText("");
                    List<ElementQuery> list = r.cPQ().tum;
                    this.tFT.clear();
                    if (list != null) {
                        for (ElementQuery elementQuery : list) {
                            if (elementQuery.nuL.equals(this.tFR)) {
                                this.tFT.add(elementQuery);
                                if (this.mBundle.getInt("key_bind_scene", -1) == 5 && !elementQuery.tza) {
                                    elementQuery.tyK = getString(R.string.fvu);
                                }
                                if (this.tFT.size() >= 2) {
                                }
                            }
                        }
                    }
                    if (this.tFT.size() == 1) {
                        this.tvu = (ElementQuery) this.tFT.get(0);
                    }
                    ab.i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", this.tFR, Integer.valueOf(this.tFT.size()));
                    this.tEr = null;
                    cu();
                    break;
                case 2:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("Country");
                    this.tFJ = stringExtra + "|" + stringExtra2;
                    stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!bo.isNullOrNil(intent.getStringExtra("Contact_City"))) {
                        this.nQt = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.nQu = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        if (bo.isNullOrNil(stringExtra)) {
                            this.tFw.setText(stringExtra3 + " " + stringExtra4);
                        } else {
                            this.tFw.setText(stringExtra + " " + stringExtra4);
                        }
                    } else if (bo.isNullOrNil(intent.getStringExtra("Contact_Province"))) {
                        this.nQu = this.tFJ;
                        this.tFw.setText(stringExtra);
                    } else {
                        this.nQu = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.tFw.setText(stringExtra + " " + stringExtra3);
                    }
                    if ("US".equals(stringExtra2) || "CA".equals(stringExtra2) || this.tvu.tyR) {
                        this.tFz.setVisibility(0);
                    } else {
                        this.tFz.setVisibility(8);
                    }
                    ab.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", stringExtra, stringExtra2, stringExtra3, stringExtra4, this.nQu);
                    break;
                case 3:
                    this.tFE.set3DesValStr(intent.getStringExtra("key_bankcard_id"));
                    break;
                case 4:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("ProviceName");
                    stringExtra3 = intent.getStringExtra("CityName");
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
                    this.tFp.setText(stringBuilder.toString());
                    break;
                case 5:
                    this.tvv = (Profession) intent.getParcelableExtra("key_select_profession");
                    this.tFo.setText(this.tvv.tvN);
                    break;
            }
            arW();
            AppMethodBeat.o(47248);
        }
    }

    private boolean arW() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(47249);
        WalletFormView walletFormView = this.tFD;
        this.tFD = null;
        if (this.tFi.fx(null)) {
            z = true;
        } else {
            if (this.tFD == null && walletFormView != this.tFi) {
                this.tFD = this.tFi;
            }
            this.tFc.setText(R.string.fah);
            this.tFc.setTextColor(getResources().getColor(R.color.xy));
            z = false;
        }
        if (!this.tEq.fx(null)) {
            if (this.tFD == null && walletFormView != this.tEq) {
                this.tFD = this.tEq;
            }
            z = false;
        }
        if (!this.tFE.fx(this.tFa)) {
            if (this.tFD == null && walletFormView != this.tFE) {
                this.tFD = this.tFE;
            }
            z = false;
        }
        if (this.trX.fx(this.trZ) || this.tFG) {
            z2 = false;
        } else {
            if (this.tFD == null && walletFormView != this.trX) {
                this.tFD = this.trX;
            }
            this.trZ.setText(R.string.fbg);
            this.trZ.setTextColor(getResources().getColor(R.color.xy));
            z2 = true;
            z = false;
        }
        if (this.tFM && !this.tFq.fx(null)) {
            if (this.tFD == null && walletFormView != this.tFq) {
                this.tFD = this.tFq;
            }
            z = false;
        }
        if (this.tFN && !this.tFr.fx(null)) {
            if (this.tFD == null && walletFormView != this.tFr) {
                this.tFD = this.tFr;
            }
            z = false;
        }
        if (!this.tFn.fx(this.trZ)) {
            if (z2) {
                this.trZ.setText(R.string.fb_);
                this.trZ.setTextColor(getResources().getColor(R.color.xy));
            } else {
                this.trZ.setText(R.string.fba);
                this.trZ.setTextColor(getResources().getColor(R.color.xy));
            }
            if (this.tFD == null && walletFormView != this.tFn) {
                this.tFD = this.tFn;
            }
            z = false;
        } else if (z2) {
            this.trZ.setVisibility(0);
        }
        if (this.trZ.getVisibility() == 4) {
            if (this.tvu.tyw) {
                this.trZ.setText(getString(R.string.fbh));
            } else {
                this.trZ.setText(getString(R.string.fbk));
            }
            this.trZ.setTextColor(getResources().getColor(R.color.s0));
            this.trZ.setVisibility(0);
        }
        if (this.tFk.fx(this.tFe)) {
            z2 = false;
        } else {
            if (this.tFD == null && walletFormView != this.tFk) {
                this.tFD = this.tFk;
            }
            z2 = true;
            z = false;
        }
        if (!this.tFj.fx(this.tFe)) {
            if (this.tFD == null && walletFormView != this.tFj) {
                this.tFD = this.tFj;
            }
            z = false;
        } else if (z2) {
            this.tFe.setVisibility(4);
        }
        if (!this.tFH.isChecked()) {
            z = false;
        }
        if (!this.tFu.fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFu) {
                this.tFD = this.tFu;
            }
            z = false;
        }
        if (!this.tFv.fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFv) {
                this.tFD = this.tFv;
            }
            z = false;
        }
        if (!this.tFw.fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFw) {
                this.tFD = this.tFw;
            }
            z = false;
        }
        if (!this.tFx.fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFx) {
                this.tFD = this.tFx;
            }
            z = false;
        }
        if (!this.tFy.fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFy) {
                this.tFD = this.tFy;
            }
            z = false;
        }
        if (!this.tFz.fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFz) {
                this.tFD = this.tFz;
            }
            z = false;
        }
        if (!this.tFA.fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFA) {
                this.tFD = this.tFA;
            }
            z = false;
        }
        if (this.tFL && !this.tFo.fx(null)) {
            if (this.tFD == null && walletFormView != this.tFo) {
                this.tFD = this.tFo;
            }
            z = false;
        }
        if (this.tFK && !this.tFp.fx(null)) {
            if (this.tFD == null && walletFormView != this.tFp) {
                this.tFD = this.tFp;
            }
            z = false;
        }
        if (this.tFO && !this.tFs.fx(null)) {
            if (this.tFD == null && walletFormView != this.tFs) {
                this.tFD = this.tFs;
            }
            z = false;
        }
        if (z) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
            if (walletFormView != null) {
                walletFormView.setImeOptions(ErrorDialogData.SUPPRESSED);
            }
        } else {
            this.gEZ.setEnabled(false);
            this.gEZ.setClickable(false);
        }
        AppMethodBeat.o(47249);
        return z;
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(47250);
        arW();
        AppMethodBeat.o(47250);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        AppMethodBeat.i(47251);
        ab.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(i)));
        switch (i) {
            case 5:
                if (this.tFD != null) {
                    boolean isFocusable;
                    WalletFormView walletFormView = this.tFD;
                    if (walletFormView.Aih != null) {
                        isFocusable = walletFormView.Aih.isFocusable();
                    } else {
                        isFocusable = false;
                    }
                    if (isFocusable) {
                        walletFormView = this.tFD;
                        if (walletFormView.Aih != null) {
                            z = walletFormView.Aih.isClickable();
                        }
                        if (z && this.tFD.dOQ()) {
                            this.tFD.dOS();
                        }
                    }
                    this.tFD.performClick();
                } else {
                    cRs();
                }
                AppMethodBeat.o(47251);
                return true;
            default:
                if (this.tFD == null) {
                    cRs();
                }
                AppMethodBeat.o(47251);
                return false;
        }
    }

    public void onDestroy() {
        AppMethodBeat.i(47252);
        com.tencent.mm.sdk.b.a.xxA.d(this.trF);
        super.onDestroy();
        AppMethodBeat.o(47252);
    }

    private static void a(WalletFormView walletFormView, int i) {
        AppMethodBeat.i(47253);
        com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) logicDelegate).QT(i);
        }
        AppMethodBeat.o(47253);
    }

    private void Hj(int i) {
        AppMethodBeat.i(47254);
        if (i == 1) {
            a((View) this.trX, 1, false, false);
            AppMethodBeat.o(47254);
            return;
        }
        a((View) this.trX, 1, true, false);
        AppMethodBeat.o(47254);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void cRt() {
        AppMethodBeat.i(47255);
        if (this.tvu == null || this.tFF == null || !this.tFF.containsKey(this.tvu.pbn)) {
            this.tFg.setVisibility(8);
            AppMethodBeat.o(47255);
            return;
        }
        double d;
        b.a aVar = (b.a) this.tFF.get(this.tvu.pbn);
        if (aVar == null || aVar.tDR == null) {
            d = 0.0d;
        } else {
            d = aVar.tDS;
        }
        this.tFg.setText(getString(R.string.fag, new Object[]{e.G(d)}));
        this.tFg.setVisibility(0);
        AppMethodBeat.o(47255);
    }

    private boolean cRu() {
        AppMethodBeat.i(47256);
        boolean z = this.mBundle.getBoolean("key_is_forgot_process", false);
        AppMethodBeat.o(47256);
        return z;
    }

    public /* synthetic */ Dialog onCreateDialog(int i) {
        AppMethodBeat.i(47257);
        switch (i) {
            case 1:
                View inflate = getLayoutInflater().inflate(R.layout.b4o, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.n3);
                listViewInScrollView.setAdapter(this.tGd);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(47217);
                        WalletCardElementUI.this.dismissDialog(1);
                        int intValue = ((Integer) WalletCardElementUI.this.tvu.cPs().get(i)).intValue();
                        if (WalletCardElementUI.this.tsb != intValue) {
                            WalletCardElementUI.this.tsb = intValue;
                            WalletCardElementUI.this.tGc = WalletCardElementUI.this.tFm.getText();
                            WalletCardElementUI.this.tFm.setText(((CheckedTextView) view).getText().toString());
                            WalletCardElementUI.b(WalletCardElementUI.this.trX, WalletCardElementUI.this.tsb);
                            WalletCardElementUI.this.trX.cey();
                            WalletCardElementUI.g(WalletCardElementUI.this);
                            WalletCardElementUI.j(WalletCardElementUI.this, WalletCardElementUI.this.tsb);
                        }
                        AppMethodBeat.o(47217);
                    }
                });
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar.PV(R.string.fas);
                aVar.fn(inflate);
                aVar.f(null);
                Dialog aMb = aVar.aMb();
                AppMethodBeat.o(47257);
                return aMb;
            default:
                com.tencent.mm.ui.widget.a.c b = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.fas), "", true);
                AppMethodBeat.o(47257);
                return b;
        }
    }
}
