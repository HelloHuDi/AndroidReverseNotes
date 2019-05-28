package com.tencent.p177mm.plugin.wallet_core.p561ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32615pn;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.picker.C40908b;
import com.tencent.p177mm.p612ui.widget.picker.C40908b.C40907a;
import com.tencent.p177mm.p612ui.widget.picker.C46701a;
import com.tencent.p177mm.p612ui.widget.picker.C46701a.C5669a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.CreTypeRuleInfo;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C22621b.C22622a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.WalletPhoneInputView;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a.C30895a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import com.tencent.p177mm.wallet_core.p650ui.formview.p1098a.C30889b;
import com.tencent.view.C31128d;
import com.tenpay.ndk.Encrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI */
public class WalletCardElementUI extends WalletBaseUI implements OnEditorActionListener, C36397a {
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
    private Map<String, C22622a> tFF = null;
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
    private BaseAdapter tGd = new C44078();
    private OnClickListener tGe = new C354919();
    private Authen toh = new Authen();
    C22621b tpu = null;
    private C4884c trF = new C1426910();
    private WalletFormView trX;
    private TextView trY;
    private TextView trZ;
    private int tsb = 1;
    private Profession[] tur;
    private ElementQuery tvu = new ElementQuery();
    private Profession tvv;
    private boolean tyN = false;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$4 */
    class C44044 implements OnClickListener {
        C44044() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47214);
            C36391e.m59983a(WalletCardElementUI.this, WalletCardElementUI.this.tvu.pbn, WalletCardElementUI.this.tvu.nuL, false, WalletCardElementUI.this.tvu.tyW);
            AppMethodBeat.m2505o(47214);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$5 */
    class C44055 implements OnClickListener {
        C44055() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47215);
            Intent putExtra = new Intent("com.tencent.mm.action.GET_ADRESS").putExtra("GetAddress", true).putExtra("ShowSelectedLocation", false);
            if (Bankcard.m78501Ho(WalletCardElementUI.this.tvu.tuo)) {
                putExtra.putExtra("IsAutoPosition", false);
            } else {
                putExtra.putExtra("IsRealNameVerifyScene", true);
                putExtra.putExtra("IsNeedShowSearchBar", true);
            }
            WalletCardElementUI.this.startActivityForResult(putExtra, 2);
            AppMethodBeat.m2505o(47215);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$7 */
    class C44067 implements OnItemClickListener {
        C44067() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(47217);
            WalletCardElementUI.this.dismissDialog(1);
            int intValue = ((Integer) WalletCardElementUI.this.tvu.cPs().get(i)).intValue();
            if (WalletCardElementUI.this.tsb != intValue) {
                WalletCardElementUI.this.tsb = intValue;
                WalletCardElementUI.this.tGc = WalletCardElementUI.this.tFm.getText();
                WalletCardElementUI.this.tFm.setText(((CheckedTextView) view).getText().toString());
                WalletCardElementUI.m61267b(WalletCardElementUI.this.trX, WalletCardElementUI.this.tsb);
                WalletCardElementUI.this.trX.cey();
                WalletCardElementUI.m61279g(WalletCardElementUI.this);
                WalletCardElementUI.m61285j(WalletCardElementUI.this, WalletCardElementUI.this.tsb);
            }
            AppMethodBeat.m2505o(47217);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$8 */
    class C44078 extends BaseAdapter {
        C44078() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(47221);
            Integer Hu = m6744Hu(i);
            AppMethodBeat.m2505o(47221);
            return Hu;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(47218);
            if (WalletCardElementUI.this.tvu.cPs() != null) {
                int size = WalletCardElementUI.this.tvu.cPs().size();
                AppMethodBeat.m2505o(47218);
                return size;
            }
            AppMethodBeat.m2505o(47218);
            return 0;
        }

        /* renamed from: Hu */
        private Integer m6744Hu(int i) {
            AppMethodBeat.m2504i(47219);
            Integer num = (Integer) WalletCardElementUI.this.tvu.cPs().get(i);
            AppMethodBeat.m2505o(47219);
            return num;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(47220);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletCardElementUI.this, 2130971115, null);
            checkedTextView.setText(C14241r.cPQ().mo9419Z(WalletCardElementUI.this, m6744Hu(i).intValue()));
            if (WalletCardElementUI.this.tsb == m6744Hu(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            AppMethodBeat.m2505o(47220);
            return checkedTextView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$10 */
    class C1426910 extends C4884c<C32615pn> {
        C1426910() {
            AppMethodBeat.m2504i(47223);
            this.xxI = C32615pn.class.getName().hashCode();
            AppMethodBeat.m2505o(47223);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47224);
            C32615pn c32615pn = (C32615pn) c4883b;
            if (c32615pn instanceof C32615pn) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletCardElementUI.m61261a(WalletCardElementUI.this, encrypt.desedeEncode(c32615pn.cLJ.cardId, randomKey), randomKey, c32615pn.cLJ.cLK);
                AppMethodBeat.m2505o(47224);
                return true;
            }
            C4990ab.m7414f("MicroMsg.WalletCardElmentUI", "mismatched scanBandkCardResultEvent event");
            AppMethodBeat.m2505o(47224);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$16 */
    class C1427016 implements OnClickListener {
        C1427016() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47233);
            Intent intent = new Intent();
            intent.putExtra("GetAddress", true);
            intent.putExtra("ShowSelectedLocation", false);
            if (!Bankcard.m78501Ho(WalletCardElementUI.this.tvu.tuo)) {
                intent.putExtra("IsRealNameVerifyScene", true);
                intent.putExtra("IsNeedShowSearchBar", true);
            }
            C25985d.m41466b(WalletCardElementUI.this.mController.ylL, ".ui.tools.MultiStageCitySelectUI", intent, 4);
            AppMethodBeat.m2505o(47233);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$18 */
    class C2260118 implements OnClickListener {
        C2260118() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47236);
            final C46701a c46701a = new C46701a(WalletCardElementUI.this.mController.ylL);
            c46701a.zSj = new C5669a() {
                /* renamed from: b */
                public final void mo11538b(boolean z, int i, int i2, int i3) {
                    AppMethodBeat.m2504i(47235);
                    if (z) {
                        WalletCardElementUI.this.tFs.setText(String.format("%04d%02d%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
                        WalletCardElementUI.this.tFZ = i;
                        WalletCardElementUI.this.tGa = i2;
                        WalletCardElementUI.this.tGb = i3;
                        WalletCardElementUI.m61268b(WalletCardElementUI.this);
                    }
                    c46701a.hide();
                    AppMethodBeat.m2505o(47235);
                }
            };
            if (WalletCardElementUI.this.tFZ > 0 && WalletCardElementUI.this.tGa > 0 && WalletCardElementUI.this.tGb > 0) {
                c46701a.mo75044aB(WalletCardElementUI.this.tFZ, WalletCardElementUI.this.tGa, WalletCardElementUI.this.tGb);
            }
            c46701a.show();
            AppMethodBeat.m2505o(47236);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$15 */
    class C2964215 implements OnClickListener {
        C2964215() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47232);
            final C46701a c46701a = new C46701a(WalletCardElementUI.this.mController.ylL);
            c46701a.zSj = new C5669a() {
                /* renamed from: b */
                public final void mo11538b(boolean z, int i, int i2, int i3) {
                    AppMethodBeat.m2504i(47231);
                    if (z) {
                        WalletCardElementUI.this.tFr.setText(String.format("%04d%02d%02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}));
                        WalletCardElementUI.this.tFW = i;
                        WalletCardElementUI.this.tFX = i2;
                        WalletCardElementUI.this.tFY = i3;
                        WalletCardElementUI.m61268b(WalletCardElementUI.this);
                    }
                    c46701a.hide();
                    AppMethodBeat.m2505o(47231);
                }
            };
            if (WalletCardElementUI.this.tFW > 0 && WalletCardElementUI.this.tFX > 0 && WalletCardElementUI.this.tFY > 0) {
                c46701a.mo75044aB(WalletCardElementUI.this.tFW, WalletCardElementUI.this.tFX, WalletCardElementUI.this.tFY);
            }
            c46701a.show();
            AppMethodBeat.m2505o(47232);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$17 */
    class C2964417 implements OnClickListener {
        C2964417() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47234);
            Intent intent = new Intent(WalletCardElementUI.this.mController.ylL, WalletSelectProfessionUI.class);
            intent.putExtra("key_profession_list", WalletCardElementUI.this.tur);
            WalletCardElementUI.this.startActivityForResult(intent, 5);
            AppMethodBeat.m2505o(47234);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$3 */
    class C354893 implements OnCheckedChangeListener {
        C354893() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(47213);
            WalletCardElementUI.m61268b(WalletCardElementUI.this);
            AppMethodBeat.m2505o(47213);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$6 */
    class C354906 implements OnClickListener {
        C354906() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47216);
            WalletCardElementUI.m61297u(WalletCardElementUI.this);
            AppMethodBeat.m2505o(47216);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$9 */
    class C354919 implements OnClickListener {
        C354919() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47222);
            C7060h.pYm.mo8381e(11353, Integer.valueOf(2), Integer.valueOf(0));
            C36391e.m60005d(WalletCardElementUI.this, C14241r.cPI().bhp());
            AppMethodBeat.m2505o(47222);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$1 */
    class C368431 implements C36397a {
        C368431() {
        }

        /* renamed from: hY */
        public final void mo9407hY(boolean z) {
            AppMethodBeat.m2504i(47211);
            if (!z) {
                WalletCardElementUI.this.tEr = null;
                WalletCardElementUI.this.mBundle.putParcelable("key_history_bankcard", null);
            }
            WalletCardElementUI.m61268b(WalletCardElementUI.this);
            AppMethodBeat.m2505o(47211);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$12 */
    class C3684412 implements OnClickListener {
        C3684412() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47227);
            ArrayList arrayList = new ArrayList();
            arrayList.add(WalletCardElementUI.this.getString(C25738R.string.fed));
            arrayList.add(WalletCardElementUI.this.getString(C25738R.string.fdu));
            if (WalletCardElementUI.this.tFT.size() == 1) {
                ElementQuery elementQuery = (ElementQuery) WalletCardElementUI.this.tFT.get(0);
                if (elementQuery.cPr()) {
                    arrayList.remove(1);
                } else if (elementQuery.cPe()) {
                    arrayList.remove(0);
                }
            }
            final C40908b c40908b = new C40908b(WalletCardElementUI.this.mController.ylL, arrayList);
            c40908b.mo64522Qq(WalletCardElementUI.this.tFU);
            c40908b.zSq = new C40907a() {
                /* renamed from: d */
                public final void mo7219d(boolean z, Object obj) {
                    AppMethodBeat.m2504i(47226);
                    c40908b.hide();
                    if (z) {
                        Object obj2;
                        String str = (String) obj;
                        WalletCardElementUI.this.tFS.setText(str);
                        if (str.equals(WalletCardElementUI.this.getString(C25738R.string.fdu))) {
                            obj2 = null;
                        } else {
                            int obj22 = 1;
                        }
                        for (ElementQuery elementQuery : WalletCardElementUI.this.tFT) {
                            if ((obj22 != null && elementQuery.cPr()) || (obj22 == null && elementQuery.cPe())) {
                                WalletCardElementUI.this.tvu = elementQuery;
                                WalletCardElementUI.m61279g(WalletCardElementUI.this);
                                break;
                            }
                        }
                    }
                    WalletCardElementUI.this.tFU = c40908b.dLl();
                    AppMethodBeat.m2505o(47226);
                }
            };
            c40908b.mo64521Qp(C1338a.fromDPToPix(WalletCardElementUI.this.mController.ylL, C31128d.MIC_PTU_YOUJIALI));
            c40908b.show();
            AppMethodBeat.m2505o(47227);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$2 */
    class C368472 implements OnClickListener {
        C368472() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47212);
            Intent intent = new Intent();
            intent.setClassName(WalletCardElementUI.this.mController.ylL, "com.tencent.mm.ui.tools.CountryCodeUI");
            intent.putExtra("exclude_countries_iso", WalletCardElementUI.this.tFQ);
            intent.putExtra("CountryCodeUI_isShowCountryCode", false);
            intent.putExtra("ui_title", WalletCardElementUI.this.getString(C25738R.string.fsy));
            WalletCardElementUI.this.startActivityForResult(intent, 6);
            AppMethodBeat.m2505o(47212);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$11 */
    class C3684811 implements OnClickListener {
        C3684811() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47225);
            Bundle bundle = new Bundle();
            bundle.putInt("key_support_bankcard", WalletCardElementUI.this.mBundle.getInt("key_support_bankcard", 3));
            bundle.putInt("key_bind_scene", WalletCardElementUI.this.mBundle.getInt("key_bind_scene", -1));
            C5046bo.isNullOrNil(WalletCardElementUI.this.tFi.getText());
            WalletCardElementUI.this.aoB();
            C40931c aE = C24143a.m37112aE(WalletCardElementUI.this);
            if (aE != null) {
                aE.mo64562a(WalletCardElementUI.this, WalletBankCardSelectUI.class, bundle, 1);
            }
            AppMethodBeat.m2505o(47225);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI$13 */
    class C3684913 implements OnClickListener {
        C3684913() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47228);
            WalletCardElementUI.this.showDialog(1);
            AppMethodBeat.m2505o(47228);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletCardElementUI() {
        AppMethodBeat.m2504i(47237);
        AppMethodBeat.m2505o(47237);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m61268b(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.m2504i(47258);
        boolean arW = walletCardElementUI.arW();
        AppMethodBeat.m2505o(47258);
        return arW;
    }

    /* renamed from: g */
    static /* synthetic */ void m61279g(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.m2504i(47259);
        walletCardElementUI.m61271cu();
        AppMethodBeat.m2505o(47259);
    }

    /* renamed from: j */
    static /* synthetic */ void m61285j(WalletCardElementUI walletCardElementUI, int i) {
        AppMethodBeat.m2504i(47262);
        walletCardElementUI.m61256Hj(i);
        AppMethodBeat.m2505o(47262);
    }

    /* renamed from: u */
    static /* synthetic */ void m61297u(WalletCardElementUI walletCardElementUI) {
        AppMethodBeat.m2504i(47260);
        walletCardElementUI.cRs();
        AppMethodBeat.m2505o(47260);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(47238);
        super.onCreate(bundle);
        this.tvu = (ElementQuery) this.mBundle.getParcelable("elemt_query");
        this.pWy = (Orders) this.mBundle.getParcelable("key_orders");
        this.pVL = (PayInfo) this.mBundle.getParcelable("key_pay_info");
        this.tsb = C14241r.cPI().cQq();
        this.tEr = (Bankcard) this.mBundle.getParcelable("key_history_bankcard");
        this.tFK = this.mBundle.getBoolean("key_need_area", false);
        this.tFL = this.mBundle.getBoolean("key_need_profession", false);
        this.tyN = this.mBundle.getBoolean("key_need_country", false);
        this.tFQ = this.mBundle.getStringArray("key_country_excludes");
        C4990ab.m7411d("MicroMsg.WalletCardElmentUI", "neeCountry: %s", Boolean.valueOf(this.tyN));
        if (this.tFK || this.tFL) {
            setMMTitle((int) C25738R.string.fej);
        } else {
            setMMTitle((int) C25738R.string.fei);
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
        C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.pVL);
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.mBundle.getParcelable("key_favor_pay_info");
        if (!(this.pWy == null || favorPayInfo == null)) {
            this.tpu = C29666c.tDU.mo47919a(this.pWy);
            if (this.tpu != null) {
                this.tFF = this.tpu.acR(this.tpu.acW(favorPayInfo.tzb));
            } else {
                C4990ab.m7420w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
            }
        }
        initView();
        this.tFC.pageScroll(33);
        C40148d.m68847a(this, this.mBundle, 3);
        C4879a.xxA.mo10052c(this.trF);
        AppMethodBeat.m2505o(47238);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47239);
        this.tEZ = (TextView) findViewById(2131828710);
        this.tFE = (WalletFormView) findViewById(2131828712);
        C30890a.m49294b(this.tFE);
        this.tFa = (TextView) findViewById(2131828713);
        this.trY = (TextView) findViewById(2131828718);
        this.tEq = (WalletFormView) findViewById(2131828681);
        this.tFl = (WalletFormView) findViewById(2131828711);
        C30890a.m49299e(this, this.tEq);
        C30890a.m49299e(this, this.tFl);
        this.tFm = (WalletFormView) findViewById(2131828719);
        this.trX = (WalletFormView) findViewById(2131828720);
        C30890a.m49298d(this.trX);
        this.trZ = (TextView) findViewById(2131828729);
        this.tFb = (TextView) findViewById(2131823368);
        this.tFi = (WalletFormView) findViewById(2131828714);
        this.tFS = (WalletFormView) findViewById(2131823369);
        this.tFc = (TextView) findViewById(2131828716);
        this.tFg = (TextView) findViewById(2131828715);
        this.tFd = (TextView) findViewById(2131828717);
        this.tFk = (WalletFormView) findViewById(2131826502);
        C30890a.m49293b(this, this.tFk);
        this.tFj = (WalletFormView) findViewById(2131826504);
        C30890a.m49290a((MMActivity) this, this.tFj);
        this.tFe = (TextView) findViewById(2131826503);
        this.rvM = (TextView) findViewById(2131828730);
        this.tFu = (WalletFormView) findViewById(2131828731);
        this.tFv = (WalletFormView) findViewById(2131828732);
        this.tFw = (WalletFormView) findViewById(2131828733);
        this.tFx = (WalletFormView) findViewById(2131828734);
        this.tFy = (WalletFormView) findViewById(2131828735);
        this.tFz = (WalletFormView) findViewById(2131828736);
        this.tFA = (WalletFormView) findViewById(2131828737);
        C30890a.m49300e(this.tFA);
        this.tFf = (TextView) findViewById(2131828738);
        this.tFH = (CheckBox) findViewById(2131828739);
        this.tFI = (CheckBox) findViewById(2131828740);
        this.gEZ = (Button) findViewById(2131822846);
        this.tFC = (ScrollView) findViewById(2131823366);
        this.tFo = (WalletFormView) findViewById(2131828724);
        this.tFp = (WalletFormView) findViewById(2131828725);
        this.tFq = (WalletFormView) findViewById(2131828722);
        this.tFr = (WalletFormView) findViewById(2131828721);
        this.tFs = (WalletFormView) findViewById(2131828726);
        this.tFt = (WalletFormView) findViewById(2131828727);
        this.tFh = (TextView) findViewById(2131828723);
        this.tFB = (WalletPhoneInputView) findViewById(2131828728);
        this.tFn = this.tFB.getPhoneNumberEt();
        this.tEq.setOnInputValidChangeListener(this);
        this.tFl.setOnInputValidChangeListener(this);
        this.tFE.setOnInputValidChangeListener(this);
        this.tFm.setOnInputValidChangeListener(this);
        this.trX.setOnInputValidChangeListener(this);
        this.tFn.setOnInputValidChangeListener(new C368431());
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
        this.tFi.setOnClickListener(new C3684811());
        this.tFS.setOnClickListener(new C3684412());
        this.tFm.setOnClickListener(new C3684913());
        final String[] strArr = new String[100];
        for (int i = 0; i < 100; i++) {
            strArr[i] = getString(C25738R.string.fdt, new Object[]{Integer.valueOf(i)});
        }
        this.tFq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(47230);
                final C40908b c40908b = new C40908b(WalletCardElementUI.this.mController.ylL, strArr);
                c40908b.zSq = new C40907a() {
                    /* renamed from: d */
                    public final void mo7219d(boolean z, Object obj) {
                        AppMethodBeat.m2504i(47229);
                        if (z) {
                            WalletCardElementUI.this.tFq.setText((String) obj);
                            WalletCardElementUI.this.tFV = c40908b.dLl();
                            WalletCardElementUI.m61268b(WalletCardElementUI.this);
                        }
                        c40908b.hide();
                        AppMethodBeat.m2505o(47229);
                    }
                };
                c40908b.mo64522Qq(WalletCardElementUI.this.tFV);
                c40908b.show();
                AppMethodBeat.m2505o(47230);
            }
        });
        this.tFr.setOnClickListener(new C2964215());
        this.tFp.setOnClickListener(new C1427016());
        this.tFo.setOnClickListener(new C2964417());
        this.tFs.setOnClickListener(new C2260118());
        this.tFt.setOnClickListener(new C368472());
        this.tFH.setChecked(true);
        this.tFH.setOnCheckedChangeListener(new C354893());
        findViewById(2131826067).setOnClickListener(new C44044());
        this.tFw.setOnClickListener(new C44055());
        this.gEZ.setOnClickListener(new C354906());
        mo39989e(this.tFE, 0, false);
        mo39989e(this.trX, 1, false);
        mo39968a(this.tFn, 0, false, true, true);
        if (this.tvu != null && !C5046bo.isNullOrNil(this.tvu.tyK)) {
            C30379h.m48448a((Context) this, this.tvu.tyK, null, true, null);
            this.tvu = null;
        } else if (this.mBundle.getInt("key_bind_scene", -1) == 5 && !this.tvu.tza) {
            C30379h.m48448a((Context) this, getString(C25738R.string.fvw), null, true, null);
            this.tvu.nuL = null;
        }
        m61271cu();
        arW();
        C40931c aE = C24143a.m37112aE(this);
        if (aE != null && aE.dNG()) {
            Orders orders = (Orders) this.mBundle.getParcelable("key_orders");
            if (orders == null || orders.tAb != 1) {
                this.tFG = false;
            } else {
                this.tFG = true;
                this.tEq.setText(C36391e.att(orders.twd));
                this.tEq.setEnabled(false);
                this.tEq.setFocusable(false);
                this.tsb = orders.tAc;
                this.tFm.setText(C14241r.cPQ().mo9419Z(this, this.tsb));
                this.tFm.setEnabled(false);
                this.trX.setText(orders.tyA);
                this.trX.setInputEnable(false);
                this.trX.setFocusable(false);
                this.trY.setText(C25738R.string.faf);
                AppMethodBeat.m2505o(47239);
                return;
            }
        }
        AppMethodBeat.m2505o(47239);
    }

    private void cRr() {
        AppMethodBeat.m2504i(47240);
        if (this.tvu.tyY == 0) {
            this.tFB.cSB();
            AppMethodBeat.m2505o(47240);
            return;
        }
        this.tFB.cSC();
        EditText editText = (EditText) this.tFB.findViewById(2131829013);
        mo39969a(this.tFB.getPhoneNumberEt(), editText, 0, false, false, true);
        AppMethodBeat.m2505o(47240);
    }

    /* renamed from: cu */
    private void m61271cu() {
        AppMethodBeat.m2504i(47241);
        if (this.tvu == null) {
            this.tvu = new ElementQuery();
        }
        C4990ab.m7417i("MicroMsg.WalletCardElmentUI", "element: %s, %s", this.tvu.nuL, this.tvu.pbn);
        cRr();
        cRt();
        C24143a.m37112aE(this);
        Bankcard bankcard = (Bankcard) this.mBundle.getParcelable("key_bankcard");
        if (!cRu() || bankcard == null) {
            if (!C5046bo.isNullOrNil(this.tvu.nuL)) {
                this.tFi.setText(this.tvu.nuL);
                if (this.tvu.cPe()) {
                    this.tFS.setVisibility(0);
                    this.tFS.setText(getString(C25738R.string.fdu));
                } else if (this.tvu.cPr()) {
                    this.tFS.setVisibility(0);
                    this.tFS.setText(getString(C25738R.string.fed));
                }
            }
            WalletCardElementUI.m61265a(new boolean[]{false}, new WalletFormView[]{this.tFE}, this.tEZ, this.tFa, true);
            WalletCardElementUI.m61265a(new boolean[]{true}, new WalletFormView[]{this.tFi}, this.tFb, this.tFc, true);
            this.tFE.setOnInfoIvClickListener(this.tGe);
            if (C14241r.cPI().cQo().cPX()) {
                this.tFE.getInfoIv().setImageResource(C1318a.wallet_scan_camera);
                this.tFE.getInfoIv().setVisibility(0);
            } else {
                this.tFE.getInfoIv().setVisibility(4);
            }
        } else {
            this.tFE.setHint(getString(C25738R.string.fbe, new Object[]{bankcard.field_bankcardTail}));
            WalletCardElementUI.m61264a(new boolean[]{true}, new WalletFormView[]{this.tFE}, this.tEZ, this.tFa);
            WalletCardElementUI.m61264a(new boolean[]{false}, new WalletFormView[]{this.tFi}, this.tFb, this.tFc);
        }
        this.tFM = false;
        this.tFN = false;
        this.tFO = false;
        this.tFP = false;
        if (!(this.tvu.tyZ == null || this.tvu.tyZ.isEmpty())) {
            C4990ab.m7417i("MicroMsg.WalletCardElmentUI", "identity type： %s", Integer.valueOf(this.tsb));
            Iterator it = this.tvu.tyZ.iterator();
            while (it.hasNext()) {
                CreTypeRuleInfo creTypeRuleInfo = (CreTypeRuleInfo) it.next();
                if (creTypeRuleInfo.txX == this.tsb) {
                    if (creTypeRuleInfo.txY.txT == 1) {
                        C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "need show cre count");
                        this.tFM = true;
                    }
                    if (creTypeRuleInfo.txY.txV == 1) {
                        C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "need show cre expire");
                        this.tFN = true;
                    }
                    if (creTypeRuleInfo.txY.txU == 1) {
                        C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "need show birthday");
                        this.tFO = true;
                    }
                    if (creTypeRuleInfo.txY.txW == 1) {
                        C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "need show cre type");
                        if (C14241r.cPI().cQq() > 0) {
                            C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "realnamed, show cre type");
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
        if (Bankcard.m78501Ho(this.tvu.tuo)) {
            WalletCardElementUI.m61264a(new boolean[]{false, false, false, false, false}, new WalletFormView[]{this.tEq, this.tFm, this.trX, this.tFq, this.tFr}, this.trY, this.trZ);
            this.tFn.setVisibility(8);
            m61290nh(true);
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
            WalletCardElementUI.m61264a(zArr, new WalletFormView[]{this.tFp, this.tFo, this.tFs, this.tFt}, this.tFh, null);
        } else {
            int i = (this.tvu.cPs() == null || this.tvu.cPs().size() <= 0) ? 0 : 1;
            if (cRu() || C14241r.cPI().cQi()) {
                String bhp = C14241r.cPI().bhp();
                if (C5046bo.isNullOrNil(bhp) && dOD() != null) {
                    bhp = dOD().mqu.getString("key_true_name");
                }
                if (C5046bo.isNullOrNil(bhp)) {
                    bhp = getString(C25738R.string.fcq);
                    this.tEq.setHint(bhp);
                    this.tFl.setHint(bhp);
                } else {
                    bhp = getString(C25738R.string.fcr, new Object[]{C36391e.att(bhp)});
                    this.tEq.setHint(bhp);
                    this.tFl.setHint(bhp);
                }
                if (!cRu() || C5046bo.isNullOrNil(this.mBundle.getString("key_identity")) || this.mBundle.getInt("key_id_type", -1) == -1 || C5046bo.isNullOrNil(this.mBundle.getString("key_true_name"))) {
                    zArr = new boolean[5];
                    zArr[0] = true;
                    z = this.tFP || i != 0;
                    zArr[1] = z;
                    zArr[2] = true;
                    zArr[3] = this.tFM;
                    zArr[4] = this.tFN;
                    WalletCardElementUI.m61264a(zArr, new WalletFormView[]{this.tEq, this.tFm, this.trX, this.tFq, this.tFr}, this.trY, this.trZ);
                } else {
                    C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "is forgot process, hide id info form");
                    WalletCardElementUI.m61264a(new boolean[]{false, false, false, this.tFM, this.tFN}, new WalletFormView[]{this.tEq, this.tFm, this.trX, this.tFq, this.tFr}, this.trY, this.trZ);
                    this.kGE = this.mBundle.getString("key_true_name");
                    C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "name is " + this.kGE);
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
                WalletCardElementUI.m61264a(zArr, new WalletFormView[]{this.tEq, this.tFm, this.trX, this.tFq, this.tFr}, this.trY, this.trZ);
                this.tFn.setVisibility(0);
                C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.tvu.tyw + " canModifyIdentity:" + this.tvu.tyx);
            }
            if (this.tEr != null) {
                if (!C5046bo.isNullOrNil(this.tEr.field_mobile)) {
                    WalletCardElementUI.m61263a(this.tFn, this.tEr.field_mobile);
                }
                if (!C5046bo.isNullOrNil(this.tEr.twh)) {
                    WalletCardElementUI.m61263a(this.tFk, this.tEr.twh);
                }
                if (!C5046bo.isNullOrNil(this.tEr.twP)) {
                    WalletCardElementUI.m61263a(this.tFj, this.tEr.twP);
                }
            }
            if (this.tvu.tyw) {
                this.trZ.setText("");
            } else {
                this.trZ.setText(getString(C25738R.string.fbk));
            }
            this.trX.setText(this.tvu.tyA);
            if (C14241r.cPI().cQq() > 0) {
                C4990ab.m7417i("MicroMsg.WalletCardElmentUI", "has cre_type: %s", Integer.valueOf(C14241r.cPI().cQq()));
                this.tFm.setClickable(false);
                this.tFm.setText(C14241r.cPQ().mo9422fk(this));
                this.tFm.setInputEnable(false);
                WalletCardElementUI.m61262a(this.trX, this.tsb);
            } else {
                C4990ab.m7417i("MicroMsg.WalletCardElmentUI", "cre_type count: %s", Integer.valueOf(this.tGd.getCount()));
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
                if (!C14241r.cPQ().mo9419Z(this, this.tsb).equals(this.tGc)) {
                    C7060h.pYm.mo8381e(16816, Integer.valueOf(this.tsb));
                }
                this.tFm.setText(C14241r.cPQ().mo9419Z(this, this.tsb));
            }
            m61256Hj(this.tsb);
            m61290nh(false);
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
            WalletCardElementUI.m61264a(zArr, new WalletFormView[]{this.tFp, this.tFo, this.tFs, this.tFt}, this.tFh, null);
        }
        WalletCardElementUI.m61264a(new boolean[]{this.tvu.tyy, this.tvu.tyz}, new WalletFormView[]{this.tFk, this.tFj}, this.tFd, this.tFe);
        if (this.tFi.getVisibility() == 0) {
            switch (this.tvu.tyD) {
                case 1:
                    this.tFc.setVisibility(8);
                    break;
                case 2:
                    this.tFc.setVisibility(8);
                    break;
                case 3:
                    this.tFc.setText(C25738R.string.fam);
                    this.tFc.setVisibility(0);
                    break;
                case 4:
                    this.tFc.setVisibility(8);
                    break;
                default:
                    this.tFc.setVisibility(8);
                    break;
            }
            this.tFc.setTextColor(getResources().getColor(C25738R.color.f12208w0));
        } else {
            this.tFc.setVisibility(8);
        }
        if (!(C5046bo.isNullOrNil(this.tvu.tyX) || this.tFc.getVisibility() == 0)) {
            C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "show pre auth word");
            this.tFc.setText(this.tvu.tyX);
            this.tFc.setVisibility(0);
        }
        if (C5046bo.isNullOrNil(this.tvu.tyI) || !C1855t.m3912mY(this.tvu.tyI) || cRu()) {
            this.tFI.setVisibility(8);
            AppMethodBeat.m2505o(47241);
            return;
        }
        this.tFI.setText(this.tvu.tyJ);
        this.tFI.setVisibility(0);
        AppMethodBeat.m2505o(47241);
    }

    /* renamed from: a */
    private static void m61263a(WalletFormView walletFormView, String str) {
        AppMethodBeat.m2504i(47242);
        if (C5046bo.isNullOrNil(str)) {
            walletFormView.setVisibility(8);
            AppMethodBeat.m2505o(47242);
            return;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
        AppMethodBeat.m2505o(47242);
    }

    /* renamed from: nh */
    private void m61290nh(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(47243);
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
            AppMethodBeat.m2505o(47243);
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
        AppMethodBeat.m2505o(47243);
    }

    /* renamed from: a */
    private static void m61265a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2, boolean z) {
        AppMethodBeat.m2504i(47244);
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
                    AppMethodBeat.m2505o(47244);
                    return;
                }
                textView2.setVisibility(4);
                AppMethodBeat.m2505o(47244);
                return;
            }
        }
        textView.setVisibility(8);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        AppMethodBeat.m2505o(47244);
    }

    /* renamed from: a */
    private static void m61264a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2) {
        AppMethodBeat.m2504i(47245);
        WalletCardElementUI.m61265a(zArr, walletFormViewArr, textView, textView2, false);
        AppMethodBeat.m2505o(47245);
    }

    private void cRs() {
        AppMethodBeat.m2504i(47246);
        if (arW()) {
            String text;
            C40148d.cSP();
            if (!C5046bo.isNullOrNil(this.tvu.tyI)) {
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
                    favorPayInfo.tzb = ((C22622a) this.tFF.get(this.tvu.pbn)).tDR.tnk;
                } else {
                    favorPayInfo.tzb = this.tpu.mo38205bC(favorPayInfo.tzb, false);
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
            text = C36391e.atu(this.toh.tuk);
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
            C4990ab.m7411d("MicroMsg.WalletCardElmentUI", "renewal: %s, expire: %s, birth: %s", Integer.valueOf(this.toh.twu), this.toh.tww, this.toh.twv);
            if (!(!cRu() || C5046bo.isNullOrNil(this.mBundle.getString("key_identity")) || this.mBundle.getInt("key_id_type", -1) == -1 || C5046bo.isNullOrNil(this.mBundle.getString("key_true_name")))) {
                C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "isForgot process, get identity info from input");
                this.toh.twe = this.mBundle.getString("key_identity");
                this.toh.twf = this.mBundle.getInt("key_id_type", -1);
                this.toh.twd = this.kGE;
                C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "authen.true_name：" + this.toh.twd);
            }
            C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "payInfo " + this.toh.pGr + " elemt.bankcardTag : " + this.tvu.tuo);
            C4990ab.m7416i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.tvu.tuo);
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
            bundle2.putString("key_bind_card_show2", 2 == this.tvu.tyE ? getString(C25738R.string.fdu) : getString(C25738R.string.fed));
            if (dOE().mo9366p(this.toh, this.pWy)) {
                C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
                AppMethodBeat.m2505o(47246);
                return;
            }
            C4990ab.m7412e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
        }
        AppMethodBeat.m2505o(47246);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47247);
        C4990ab.m7416i("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i == 0 && i2 == 0) {
            Bundle bundle = this.mBundle;
            C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.pVL);
            if (c1207m instanceof C35475y) {
                C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
                C24143a.m37116j(this, bundle);
                AppMethodBeat.m2505o(47247);
                return true;
            }
            AppMethodBeat.m2505o(47247);
            return false;
        }
        AppMethodBeat.m2505o(47247);
        return false;
    }

    public final int getLayoutId() {
        return 2130971075;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(47248);
        C4990ab.m7416i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (this.tFB.mo26600e(i, i2, intent)) {
            AppMethodBeat.m2505o(47248);
        } else if (i == 6 && i2 == 100) {
            if (!C5046bo.isNullOrNil(intent.getStringExtra("country_name"))) {
                this.fHC = intent.getStringExtra("iso_code");
                this.tFt.setText(intent.getStringExtra("country_name"));
            }
            AppMethodBeat.m2505o(47248);
        } else if (i2 != -1) {
            AppMethodBeat.m2505o(47248);
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
                    List<ElementQuery> list = C14241r.cPQ().tum;
                    this.tFT.clear();
                    if (list != null) {
                        for (ElementQuery elementQuery : list) {
                            if (elementQuery.nuL.equals(this.tFR)) {
                                this.tFT.add(elementQuery);
                                if (this.mBundle.getInt("key_bind_scene", -1) == 5 && !elementQuery.tza) {
                                    elementQuery.tyK = getString(C25738R.string.fvu);
                                }
                                if (this.tFT.size() >= 2) {
                                }
                            }
                        }
                    }
                    if (this.tFT.size() == 1) {
                        this.tvu = (ElementQuery) this.tFT.get(0);
                    }
                    C4990ab.m7417i("MicroMsg.WalletCardElmentUI", "select bank: %s, %s", this.tFR, Integer.valueOf(this.tFT.size()));
                    this.tEr = null;
                    m61271cu();
                    break;
                case 2:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("Country");
                    this.tFJ = stringExtra + "|" + stringExtra2;
                    stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!C5046bo.isNullOrNil(intent.getStringExtra("Contact_City"))) {
                        this.nQt = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.nQu = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        if (C5046bo.isNullOrNil(stringExtra)) {
                            this.tFw.setText(stringExtra3 + " " + stringExtra4);
                        } else {
                            this.tFw.setText(stringExtra + " " + stringExtra4);
                        }
                    } else if (C5046bo.isNullOrNil(intent.getStringExtra("Contact_Province"))) {
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
                    C4990ab.m7417i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", stringExtra, stringExtra2, stringExtra3, stringExtra4, this.nQu);
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
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        stringBuilder.append(stringExtra);
                    }
                    if (!C5046bo.isNullOrNil(stringExtra2)) {
                        stringBuilder.append(" ").append(stringExtra2);
                    }
                    if (!C5046bo.isNullOrNil(stringExtra3)) {
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
            AppMethodBeat.m2505o(47248);
        }
    }

    private boolean arW() {
        boolean z;
        boolean z2;
        AppMethodBeat.m2504i(47249);
        WalletFormView walletFormView = this.tFD;
        this.tFD = null;
        if (this.tFi.mo64602fx(null)) {
            z = true;
        } else {
            if (this.tFD == null && walletFormView != this.tFi) {
                this.tFD = this.tFi;
            }
            this.tFc.setText(C25738R.string.fah);
            this.tFc.setTextColor(getResources().getColor(C25738R.color.f12266xy));
            z = false;
        }
        if (!this.tEq.mo64602fx(null)) {
            if (this.tFD == null && walletFormView != this.tEq) {
                this.tFD = this.tEq;
            }
            z = false;
        }
        if (!this.tFE.mo64602fx(this.tFa)) {
            if (this.tFD == null && walletFormView != this.tFE) {
                this.tFD = this.tFE;
            }
            z = false;
        }
        if (this.trX.mo64602fx(this.trZ) || this.tFG) {
            z2 = false;
        } else {
            if (this.tFD == null && walletFormView != this.trX) {
                this.tFD = this.trX;
            }
            this.trZ.setText(C25738R.string.fbg);
            this.trZ.setTextColor(getResources().getColor(C25738R.color.f12266xy));
            z2 = true;
            z = false;
        }
        if (this.tFM && !this.tFq.mo64602fx(null)) {
            if (this.tFD == null && walletFormView != this.tFq) {
                this.tFD = this.tFq;
            }
            z = false;
        }
        if (this.tFN && !this.tFr.mo64602fx(null)) {
            if (this.tFD == null && walletFormView != this.tFr) {
                this.tFD = this.tFr;
            }
            z = false;
        }
        if (!this.tFn.mo64602fx(this.trZ)) {
            if (z2) {
                this.trZ.setText(C25738R.string.fb_);
                this.trZ.setTextColor(getResources().getColor(C25738R.color.f12266xy));
            } else {
                this.trZ.setText(C25738R.string.fba);
                this.trZ.setTextColor(getResources().getColor(C25738R.color.f12266xy));
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
                this.trZ.setText(getString(C25738R.string.fbh));
            } else {
                this.trZ.setText(getString(C25738R.string.fbk));
            }
            this.trZ.setTextColor(getResources().getColor(C25738R.color.f12092s0));
            this.trZ.setVisibility(0);
        }
        if (this.tFk.mo64602fx(this.tFe)) {
            z2 = false;
        } else {
            if (this.tFD == null && walletFormView != this.tFk) {
                this.tFD = this.tFk;
            }
            z2 = true;
            z = false;
        }
        if (!this.tFj.mo64602fx(this.tFe)) {
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
        if (!this.tFu.mo64602fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFu) {
                this.tFD = this.tFu;
            }
            z = false;
        }
        if (!this.tFv.mo64602fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFv) {
                this.tFD = this.tFv;
            }
            z = false;
        }
        if (!this.tFw.mo64602fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFw) {
                this.tFD = this.tFw;
            }
            z = false;
        }
        if (!this.tFx.mo64602fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFx) {
                this.tFD = this.tFx;
            }
            z = false;
        }
        if (!this.tFy.mo64602fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFy) {
                this.tFD = this.tFy;
            }
            z = false;
        }
        if (!this.tFz.mo64602fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFz) {
                this.tFD = this.tFz;
            }
            z = false;
        }
        if (!this.tFA.mo64602fx(this.tFf)) {
            if (this.tFD == null && walletFormView != this.tFA) {
                this.tFD = this.tFA;
            }
            z = false;
        }
        if (this.tFL && !this.tFo.mo64602fx(null)) {
            if (this.tFD == null && walletFormView != this.tFo) {
                this.tFD = this.tFo;
            }
            z = false;
        }
        if (this.tFK && !this.tFp.mo64602fx(null)) {
            if (this.tFD == null && walletFormView != this.tFp) {
                this.tFD = this.tFp;
            }
            z = false;
        }
        if (this.tFO && !this.tFs.mo64602fx(null)) {
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
        AppMethodBeat.m2505o(47249);
        return z;
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(47250);
        arW();
        AppMethodBeat.m2505o(47250);
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        AppMethodBeat.m2504i(47251);
        C4990ab.m7410d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : ".concat(String.valueOf(i)));
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
                AppMethodBeat.m2505o(47251);
                return true;
            default:
                if (this.tFD == null) {
                    cRs();
                }
                AppMethodBeat.m2505o(47251);
                return false;
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47252);
        C4879a.xxA.mo10053d(this.trF);
        super.onDestroy();
        AppMethodBeat.m2505o(47252);
    }

    /* renamed from: a */
    private static void m61262a(WalletFormView walletFormView, int i) {
        AppMethodBeat.m2504i(47253);
        C30889b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof C30895a) {
            ((C30895a) logicDelegate).mo49420QT(i);
        }
        AppMethodBeat.m2505o(47253);
    }

    /* renamed from: Hj */
    private void m61256Hj(int i) {
        AppMethodBeat.m2504i(47254);
        if (i == 1) {
            mo21157a((View) this.trX, 1, false, false);
            AppMethodBeat.m2505o(47254);
            return;
        }
        mo21157a((View) this.trX, 1, true, false);
        AppMethodBeat.m2505o(47254);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void cRt() {
        AppMethodBeat.m2504i(47255);
        if (this.tvu == null || this.tFF == null || !this.tFF.containsKey(this.tvu.pbn)) {
            this.tFg.setVisibility(8);
            AppMethodBeat.m2505o(47255);
            return;
        }
        double d;
        C22622a c22622a = (C22622a) this.tFF.get(this.tvu.pbn);
        if (c22622a == null || c22622a.tDR == null) {
            d = 0.0d;
        } else {
            d = c22622a.tDS;
        }
        this.tFg.setText(getString(C25738R.string.fag, new Object[]{C36391e.m59972G(d)}));
        this.tFg.setVisibility(0);
        AppMethodBeat.m2505o(47255);
    }

    private boolean cRu() {
        AppMethodBeat.m2504i(47256);
        boolean z = this.mBundle.getBoolean("key_is_forgot_process", false);
        AppMethodBeat.m2505o(47256);
        return z;
    }

    public /* synthetic */ Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(47257);
        switch (i) {
            case 1:
                View inflate = getLayoutInflater().inflate(2130971114, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(2131821054);
                listViewInScrollView.setAdapter(this.tGd);
                listViewInScrollView.setOnItemClickListener(new C44067());
                C5652a c5652a = new C5652a(this);
                c5652a.mo11446PV(C25738R.string.fas);
                c5652a.mo11479fn(inflate);
                c5652a.mo11478f(null);
                Dialog aMb = c5652a.aMb();
                AppMethodBeat.m2505o(47257);
                return aMb;
            default:
                C5653c b = C30379h.m48461b((Context) this, getString(C25738R.string.fas), "", true);
                AppMethodBeat.m2505o(47257);
                return b;
        }
    }
}
