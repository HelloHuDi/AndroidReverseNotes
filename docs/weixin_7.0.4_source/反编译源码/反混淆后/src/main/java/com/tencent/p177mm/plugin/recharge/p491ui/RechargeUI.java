package com.tencent.p177mm.plugin.recharge.p491ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19483d;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19486m;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C27084e;
import com.tencent.p177mm.plugin.recharge.model.C12955c;
import com.tencent.p177mm.plugin.recharge.model.C12956e;
import com.tencent.p177mm.plugin.recharge.model.C28809d;
import com.tencent.p177mm.plugin.recharge.model.C39571g;
import com.tencent.p177mm.plugin.recharge.model.C43420a;
import com.tencent.p177mm.plugin.recharge.model.C43421b;
import com.tencent.p177mm.plugin.recharge.model.MallRechargeProduct;
import com.tencent.p177mm.plugin.recharge.p1655a.C46158a;
import com.tencent.p177mm.plugin.recharge.p1656b.C46159a;
import com.tencent.p177mm.plugin.recharge.p491ui.MallEditText.C12970b;
import com.tencent.p177mm.plugin.wallet_core.model.mall.C40113c;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.acg;
import com.tencent.p177mm.protocal.protobuf.ake;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI */
public class RechargeUI extends MMActivity implements C1202f, C18765a, C12970b {
    private Button gHn = null;
    protected Dialog gII = null;
    private boolean hZP = true;
    private TextView pHA = null;
    private TextView pHB = null;
    private TextView pHC = null;
    private FrameLayout pHD = null;
    private ImageView pHE = null;
    private ImageView pHF = null;
    private LinearLayout pHG = null;
    private C3695a pHH = null;
    private C3695a pHI = null;
    private MallEditText pHJ;
    private TextView pHK;
    private int pHL;
    private MallRechargeProduct pHM = null;
    private String pHN = null;
    private MallNews pHO = null;
    private boolean pHP = false;
    private Map<String, Integer> pHQ = new HashMap();
    private String pHR;
    public String pHS;
    private String pHT;
    public String pHU;
    private MallFunction pHj = null;
    private TextView pHz = null;
    private boolean piJ = false;
    private C4884c piM = new C3478710();

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$5 */
    class C36905 implements OnItemClickListener {
        C36905() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44310);
            RechargeUI.this.dismissDialog(1);
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "onItemClick : ".concat(String.valueOf(i)));
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.pHM);
            RechargeUI.this.pHM = RechargeUI.this.pHH.mo8310BD(i);
            RechargeUI.this.pHH.mo8309BC(i);
            RechargeUI.this.pHH.notifyDataSetChanged();
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "checkProduct: " + RechargeUI.this.pHM);
            RechargeUI.m57143l(RechargeUI.this);
            AppMethodBeat.m2505o(44310);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$6 */
    class C36916 implements OnItemClickListener {
        C36916() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44311);
            RechargeUI.this.dismissDialog(1);
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "onItemClick : ".concat(String.valueOf(i)));
            RechargeUI.this.pHM = RechargeUI.this.pHI.mo8310BD(i);
            RechargeUI.this.pHI.mo8309BC(i);
            RechargeUI.this.pHI.notifyDataSetChanged();
            RechargeUI.this.pHQ.remove(RechargeUI.m57126B(RechargeUI.this.pHM.fmR, RechargeUI.this.pHM.cwg, RechargeUI.m57144m(RechargeUI.this)));
            RechargeUI.m57130b(RechargeUI.this);
            RechargeUI.m57143l(RechargeUI.this);
            AppMethodBeat.m2505o(44311);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$a */
    class C3695a extends BaseAdapter {
        private List<MallRechargeProduct> pFZ;

        private C3695a() {
            this.pFZ = null;
        }

        /* synthetic */ C3695a(RechargeUI rechargeUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(44331);
            MallRechargeProduct BD = mo8310BD(i);
            AppMethodBeat.m2505o(44331);
            return BD;
        }

        /* renamed from: cN */
        public final void mo8311cN(List<MallRechargeProduct> list) {
            AppMethodBeat.m2504i(44325);
            this.pFZ = list;
            notifyDataSetChanged();
            AppMethodBeat.m2505o(44325);
        }

        /* renamed from: BC */
        public final void mo8309BC(int i) {
            AppMethodBeat.m2504i(44326);
            for (int i2 = 0; i2 < this.pFZ.size(); i2++) {
                ((MallRechargeProduct) this.pFZ.get(i2)).isDefault = false;
            }
            ((MallRechargeProduct) this.pFZ.get(i)).isDefault = true;
            AppMethodBeat.m2505o(44326);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(44327);
            if (this.pFZ == null) {
                AppMethodBeat.m2505o(44327);
                return 0;
            }
            int size = this.pFZ.size();
            AppMethodBeat.m2505o(44327);
            return size;
        }

        /* renamed from: BD */
        public final MallRechargeProduct mo8310BD(int i) {
            AppMethodBeat.m2504i(44328);
            MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) this.pFZ.get(i);
            AppMethodBeat.m2505o(44328);
            return mallRechargeProduct;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(44329);
            if (mo8310BD(i).isValid()) {
                boolean isEnabled = super.isEnabled(i);
                AppMethodBeat.m2505o(44329);
                return isEnabled;
            }
            AppMethodBeat.m2505o(44329);
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(44330);
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(RechargeUI.this, 2130970475, null);
            MallRechargeProduct BD = mo8310BD(i);
            checkedTextView.setText(BD.lcC);
            checkedTextView.setEnabled(BD.isValid());
            if (BD.isDefault) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            AppMethodBeat.m2505o(44330);
            return checkedTextView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$11 */
    class C1297411 implements OnClickListener {
        C1297411() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44317);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", RechargeUI.this.pHT);
            C25985d.m41467b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(44317);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$14 */
    class C1297514 implements OnClickListener {
        C1297514() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44320);
            if ((RechargeUI.this.pHH != null && RechargeUI.this.pHH.getCount() > 0) || (RechargeUI.this.pHI != null && RechargeUI.this.pHI.getCount() > 0)) {
                RechargeUI.this.showDialog(1);
            }
            AppMethodBeat.m2505o(44320);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$12 */
    class C2881112 implements OnClickListener {
        C2881112() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44318);
            if (RechargeUI.m57130b(RechargeUI.this) && RechargeUI.m57131c(RechargeUI.this)) {
                RechargeUI.m57134d(RechargeUI.this);
            }
            AppMethodBeat.m2505o(44318);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$13 */
    class C2881213 implements OnClickListener {
        C2881213() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44319);
            if (RechargeUI.this.pHJ.pGu) {
                RechargeUI.this.pHJ.setInput(null);
                AppMethodBeat.m2505o(44319);
                return;
            }
            RechargeUI.this.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 1);
            AppMethodBeat.m2505o(44319);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$15 */
    class C2881315 implements OnClickListener {
        C2881315() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44321);
            C40113c cQT = C40113c.cQT();
            String str = RechargeUI.this.pHj.pFP;
            C4990ab.m7410d("MicroMsg.MallNewsManager", "removeNewsInIndexUI : ".concat(String.valueOf(str)));
            if (!C5046bo.isNullOrNil(str) && cQT.tDE.containsKey(str)) {
                MallNews mallNews = (MallNews) cQT.tDE.get(str);
                if ("1".equals(mallNews.tDt)) {
                    mallNews.tDt = "2";
                    cQT.bZX();
                }
            }
            RechargeUI.this.pHD.setVisibility(8);
            AppMethodBeat.m2505o(44321);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$2 */
    class C347812 implements DialogInterface.OnClickListener {
        C347812() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(44308);
            RechargeUI.m57134d(RechargeUI.this);
            AppMethodBeat.m2505o(44308);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$4 */
    class C347824 implements DialogInterface.OnClickListener {
        C347824() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$16 */
    class C3478316 implements OnClickListener {
        C3478316() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44322);
            if (!C5046bo.isNullOrNil(RechargeUI.this.pHj.tDn.tDw)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", RechargeUI.this.pHj.tDn.tDw);
                intent.putExtra("geta8key_username", C1853r.m3846Yz());
                C25985d.m41467b(RechargeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
            }
            AppMethodBeat.m2505o(44322);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$18 */
    class C3478418 implements OnMenuItemClickListener {
        C3478418() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44324);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", RechargeUI.this.pHR);
            C25985d.m41467b(RechargeUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(44324);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$1 */
    class C347851 implements OnMenuItemClickListener {
        C347851() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44307);
            RechargeUI.this.aqX();
            RechargeUI.this.finish();
            AppMethodBeat.m2505o(44307);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$10 */
    class C3478710 extends C4884c<C32652uv> {
        C3478710() {
            AppMethodBeat.m2504i(44315);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(44315);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44316);
            C32652uv c32652uv = (C32652uv) c4883b;
            if (c32652uv instanceof C32652uv) {
                if (c32652uv.cRF.result != -1) {
                    C4990ab.m7416i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                } else if (!RechargeUI.this.piJ) {
                    C4990ab.m7416i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                    C46158a.cea().mo74108a(RechargeUI.this.pHJ.getInputRecord());
                    RechargeUI.this.finish();
                    RechargeUI.this.piJ = true;
                }
                AppMethodBeat.m2505o(44316);
                return true;
            }
            C4990ab.m7414f("MicroMsg.MallRechargeUI", "mismatched event");
            AppMethodBeat.m2505o(44316);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.RechargeUI$17 */
    class C3478817 implements OnClickListener {
        C3478817() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44323);
            RechargeUI.this.pHJ.getFocus();
            if (RechargeUI.this.pHJ.getInputRecord().cvp == 2) {
                RechargeUI.this.pHJ.setInput(null);
            }
            if (C5046bo.isNullOrNil(RechargeUI.this.pHJ.getText().toString())) {
                RechargeUI.this.pHJ.pGt.showDropDown();
            }
            RechargeUI.this.showVKB();
            AppMethodBeat.m2505o(44323);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RechargeUI() {
        AppMethodBeat.m2504i(44332);
        AppMethodBeat.m2505o(44332);
    }

    /* renamed from: B */
    static /* synthetic */ String m57126B(int i, String str, String str2) {
        AppMethodBeat.m2504i(44363);
        String A = RechargeUI.m57125A(i, str, str2);
        AppMethodBeat.m2505o(44363);
        return A;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m57130b(RechargeUI rechargeUI) {
        AppMethodBeat.m2504i(44358);
        boolean arW = rechargeUI.arW();
        AppMethodBeat.m2505o(44358);
        return arW;
    }

    /* renamed from: l */
    static /* synthetic */ void m57143l(RechargeUI rechargeUI) {
        AppMethodBeat.m2504i(44361);
        rechargeUI.m57133cu();
        AppMethodBeat.m2505o(44361);
    }

    /* renamed from: m */
    static /* synthetic */ String m57144m(RechargeUI rechargeUI) {
        AppMethodBeat.m2504i(44362);
        String cer = rechargeUI.cer();
        AppMethodBeat.m2505o(44362);
        return cer;
    }

    public final int getLayoutId() {
        return 2130970478;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44333);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.pHj = (MallFunction) intent.getParcelableExtra("key_func_info");
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("key_product_list");
        this.hZP = !intent.getBooleanExtra("key_is_hide_progress", false);
        if (this.pHj == null) {
            C4990ab.m7412e("MicroMsg.MallRechargeUI", "function info is null");
            C23639t.makeText(this, "function info is null", 1).show();
            AppMethodBeat.m2505o(44333);
            return;
        }
        if (parcelableArrayListExtra == null) {
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "function info : " + this.pHj.cOI);
            m57147p(new C12956e(this.pHj.pFP));
        } else {
            this.pHM = C46160a.m86166cL(parcelableArrayListExtra);
        }
        C4990ab.m7416i("MicroMsg.MallRechargeUI", "onCreate()");
        this.pHO = C40113c.cQT().acI(this.pHj.pFP);
        initView();
        AppMethodBeat.m2505o(44333);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44334);
        setMMTitle(this.pHj.cOI);
        C4990ab.m7418v("MicroMsg.MallRechargeUI", "initView");
        setBackBtn(new C347851());
        this.pHz = (TextView) findViewById(2131826638);
        this.pHA = (TextView) findViewById(2131826903);
        this.pHB = (TextView) findViewById(2131826902);
        this.gHn = (Button) findViewById(2131822846);
        this.pHG = (LinearLayout) findViewById(2131826900);
        this.pHC = (TextView) findViewById(2131826904);
        this.pHC.setOnClickListener(new C1297411());
        this.gHn.setOnClickListener(new C2881112());
        this.pHJ = (MallEditText) findViewById(2131826899);
        this.pHJ.setInfoTvOnClickListener(new C2881213());
        this.pHK = (TextView) findViewById(2131826901);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("key_product_list");
        List f = RechargeUI.m57137f(0, parcelableArrayListExtra);
        List f2 = RechargeUI.m57137f(2, parcelableArrayListExtra);
        this.pHL = f.size() > f2.size() ? f.size() : f2.size();
        this.pHH = new C3695a(this, (byte) 0);
        this.pHH.mo8311cN(f);
        this.pHI = new C3695a(this, (byte) 0);
        this.pHI.mo8311cN(f2);
        this.pHG.setOnClickListener(new C1297514());
        this.pHD = (FrameLayout) findViewById(2131826896);
        this.pHE = (ImageView) findViewById(2131826897);
        this.pHF = (ImageView) findViewById(2131826898);
        this.pHF.setOnClickListener(new C2881315());
        this.pHD.setOnClickListener(new C3478316());
        this.pHJ.setOnInputValidChangeListener(this);
        this.pHJ.setOnClickListener(new C3478817());
        ceg();
        C18764x.m29326a((C18765a) this);
        m57133cu();
        AppMethodBeat.m2505o(44334);
    }

    /* renamed from: cu */
    private void m57133cu() {
        AppMethodBeat.m2504i(44335);
        C4990ab.m7410d("MicroMsg.MallRechargeUI", "mCheckedProduct " + this.pHM);
        if (this.pHM != null) {
            this.pHK.setText(this.pHM.lcC);
            this.pHB.setText(m57128a(this.pHM));
        }
        if (this.pHO != null && this.pHj.tDn != null && this.pHO.equals(this.pHj.tDn) && !"1".equals(this.pHO.tDt)) {
            this.pHD.setVisibility(8);
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "dismiss banner!, news->" + this.pHO.toString());
        } else if (this.pHj.tDn == null || C5046bo.isNullOrNil(this.pHj.tDn.tDx)) {
            this.pHD.setVisibility(8);
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "dismiss banner!");
        } else {
            this.pHN = this.pHj.tDn.tDx;
            this.pHE.setImageBitmap(C18764x.m29325a(new C46159a(this.pHN)));
            this.pHD.setVisibility(0);
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "Show banner!");
        }
        this.pHA.setVisibility(4);
        if (!arW()) {
            this.pHz.setText("");
        } else if (!(this.pHM == null || ces())) {
            this.pHz.setText(this.pHM.pFQ);
            this.pHz.setTextColor(getResources().getColor(C25738R.color.f12092s0));
        }
        ceo();
        cep();
        AppMethodBeat.m2505o(44335);
    }

    private void ceo() {
        AppMethodBeat.m2504i(44336);
        String string = getString(C25738R.string.cy_);
        if (!TextUtils.isEmpty(this.pHS)) {
            string = this.pHS;
        }
        if (!C5046bo.isNullOrNil(this.pHR)) {
            addTextOptionMenu(0, string, new C3478418());
        }
        AppMethodBeat.m2505o(44336);
    }

    private void cep() {
        AppMethodBeat.m2504i(44337);
        if (C5046bo.isNullOrNil(this.pHT)) {
            this.pHC.setVisibility(8);
        } else {
            this.pHC.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.pHU)) {
            this.pHC.setText(this.pHU);
        }
        AppMethodBeat.m2505o(44337);
    }

    /* renamed from: a */
    private String m57128a(MallRechargeProduct mallRechargeProduct) {
        AppMethodBeat.m2504i(44338);
        String string;
        if (!mallRechargeProduct.isValid()) {
            string = getString(C25738R.string.cyh);
            AppMethodBeat.m2505o(44338);
            return string;
        } else if (mallRechargeProduct.pFR != mallRechargeProduct.pFS || (ces() && this.pHM.pFW)) {
            string = "";
            AppMethodBeat.m2505o(44338);
            return string;
        } else {
            string = String.format(getString(C25738R.string.cyk), new Object[]{Float.valueOf(mallRechargeProduct.pFR)});
            AppMethodBeat.m2505o(44338);
            return string;
        }
    }

    /* renamed from: f */
    private static List<MallRechargeProduct> m57137f(int i, List<MallRechargeProduct> list) {
        AppMethodBeat.m2504i(44339);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            boolean z = false;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.fmR == i) {
                    arrayList.add(mallRechargeProduct);
                    if (mallRechargeProduct.isDefault) {
                        if (z) {
                            mallRechargeProduct.isDefault = false;
                        }
                        z = true;
                    }
                }
            }
            if (!z && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
        }
        AppMethodBeat.m2505o(44339);
        return arrayList;
    }

    /* renamed from: p */
    private void m57147p(final C1207m c1207m) {
        AppMethodBeat.m2504i(44340);
        if (c1207m.getType() == C19483d.CTRL_INDEX || c1207m.getType() == 1555) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c1207m, 0);
            AppMethodBeat.m2505o(44340);
        } else if (this.hZP) {
            if (this.gII == null || !(this.gII == null || this.gII.isShowing())) {
                this.gII = C30901g.m49317a(this.mController.ylL, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(44309);
                        C1720g.m3537RQ();
                        C1720g.m3535RO().eJo.mo14547c(c1207m);
                        AppMethodBeat.m2505o(44309);
                    }
                });
            }
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c1207m, 0);
            AppMethodBeat.m2505o(44340);
        } else {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c1207m, 0);
            AppMethodBeat.m2505o(44340);
        }
    }

    private boolean arW() {
        boolean z;
        AppMethodBeat.m2504i(44341);
        if (this.pHJ.cef()) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.pHM != null && this.pHM.isValid()) {
            if (ces() && this.pHM.pFW) {
                m57147p(new C28809d(this.pHM.fmR, this.pHj.pFP, this.pHM.cwg, this.pHM.appId, ceq(), cer()));
            }
            aqX();
            this.gHn.setEnabled(true);
            this.gHn.setClickable(true);
            C4990ab.m7410d("MicroMsg.MallRechargeUI", "checkInfo : true");
            AppMethodBeat.m2505o(44341);
            return true;
        }
        this.gHn.setEnabled(false);
        this.gHn.setClickable(false);
        C4990ab.m7410d("MicroMsg.MallRechargeUI", "checkInfo : false");
        AppMethodBeat.m2505o(44341);
        return false;
    }

    private String ceq() {
        AppMethodBeat.m2504i(44342);
        String str = "mobile=" + C43421b.m77507ws(this.pHJ.getText());
        AppMethodBeat.m2505o(44342);
        return str;
    }

    private String cer() {
        AppMethodBeat.m2504i(44343);
        String ws = C43421b.m77507ws(this.pHJ.getText());
        AppMethodBeat.m2505o(44343);
        return ws;
    }

    /* renamed from: A */
    private static String m57125A(int i, String str, String str2) {
        AppMethodBeat.m2504i(44344);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("-");
        stringBuilder.append(str);
        stringBuilder.append("-");
        stringBuilder.append(str2);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(44344);
        return stringBuilder2;
    }

    private boolean ces() {
        AppMethodBeat.m2504i(44345);
        if (this.pHQ.containsKey(RechargeUI.m57125A(this.pHM.fmR, this.pHM.cwg, cer()))) {
            AppMethodBeat.m2505o(44345);
            return false;
        }
        AppMethodBeat.m2505o(44345);
        return true;
    }

    /* renamed from: hY */
    public final void mo25027hY(boolean z) {
        AppMethodBeat.m2504i(44346);
        if (!z) {
            this.pHQ.clear();
            this.pHz.setText("");
            this.pHA.setVisibility(4);
        }
        arW();
        AppMethodBeat.m2505o(44346);
    }

    public final void ceg() {
        AppMethodBeat.m2504i(44347);
        if (C5046bo.isNullOrNil(this.pHJ.getText()) || this.pHJ.asa()) {
            this.pHJ.setInfoTvImageResource(C25738R.drawable.f7006yb);
            AppMethodBeat.m2505o(44347);
            return;
        }
        this.pHJ.setInfoTvImageResource(C25738R.drawable.f6801r8);
        AppMethodBeat.m2505o(44347);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44348);
        C4990ab.m7410d("MicroMsg.MallRechargeUI", "onSceneEnd errType = " + i + ", errCode = " + i2);
        if (!(this.gII == null || !this.gII.isShowing() || c1207m.getType() == C19483d.CTRL_INDEX)) {
            this.gII.dismiss();
            this.gII = null;
        }
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C12956e) {
                C12956e c12956e = (C12956e) c1207m;
                ArrayList arrayList = c12956e.pGb;
                if (arrayList != null) {
                    this.pHM = C46160a.m86166cL(arrayList);
                    C4990ab.m7410d("MicroMsg.MallRechargeUI", "mCheckedProduct again" + this.pHM);
                }
                this.pHR = c12956e.pGc;
                this.pHS = c12956e.pGd;
                this.pHT = c12956e.pGe;
                this.pHU = c12956e.pGf;
                C4990ab.m7410d("MicroMsg.MallRechargeUI", "mProductList ".concat(String.valueOf(arrayList)));
                m57133cu();
                List f = RechargeUI.m57137f(0, arrayList);
                List f2 = RechargeUI.m57137f(2, arrayList);
                this.pHL = f.size() > f2.size() ? f.size() : f2.size();
                this.pHH.mo8311cN(f);
                this.pHI.mo8311cN(f2);
                AppMethodBeat.m2505o(44348);
                return;
            } else if (c1207m instanceof C28809d) {
                C4990ab.m7410d("MicroMsg.MallRechargeUI", "checkProduct: " + this.pHM);
                C28809d c28809d = (C28809d) c1207m;
                if (!(this.pHM == null || this.pHM.cwg == null || c28809d.pFY == null || ((!this.pHM.cwg.equals(c28809d.pFY.cwg) || !cer().equals(c28809d.gyD)) && c28809d.fmR == 2))) {
                    MallRechargeProduct.m33031a(c28809d.pFY, this.pHM);
                    this.pHM.isDefault = true;
                    this.pHQ.put(RechargeUI.m57125A(c28809d.fmR, c28809d.pFY.cwg, c28809d.gyD), Integer.valueOf(1));
                    m57133cu();
                    this.pHA.setText(str);
                    this.pHA.setVisibility(0);
                    this.pHA.setTextColor(getResources().getColor(C25738R.color.f12072ra));
                }
                if (c28809d.fmR == 2) {
                    if (this.pHM == null || !this.pHM.cwg.equals(c28809d.pGa) || !cer().equals(c28809d.gyD)) {
                        this.gHn.setEnabled(true);
                        this.gHn.setClickable(true);
                        this.pHA.setText(null);
                    } else if (((ake) c28809d.ehh.fsH.fsP).wjY == 0 && this.pHM.cwg.equals(c28809d.pFY.cwg)) {
                        m57147p(new C12955c(this.pHM.pFP, cer(), this.pHM.lcC, this.pHM.appId, ceq()));
                    } else {
                        this.gHn.setEnabled(false);
                        this.gHn.setClickable(false);
                        this.pHA.setText(((ake) c28809d.ehh.fsH.fsP).wjZ);
                        this.pHA.setVisibility(0);
                        this.pHA.setTextColor(getResources().getColor(C25738R.color.f12266xy));
                    }
                }
                m57132cM(c28809d.pFZ);
                C4990ab.m7410d("MicroMsg.MallRechargeUI", "NetSceneGetLatestPayProductInfo  mCheckedProduct " + this.pHM);
                AppMethodBeat.m2505o(44348);
                return;
            } else if (c1207m instanceof C39571g) {
                PayInfo payInfo = ((C39571g) c1207m).pGr;
                payInfo.cIf = 6;
                payInfo.vwe = 100;
                C35899h.m58853a(this, payInfo, 2);
                C4879a.xxA.mo10052c(this.piM);
                AppMethodBeat.m2505o(44348);
                return;
            } else if (c1207m instanceof C12955c) {
                C12955c c12955c = (C12955c) c1207m;
                if (this.pHM == null || !this.pHM.lcC.equals(c12955c.lcC) || !cer().equals(c12955c.cFl)) {
                    this.gHn.setEnabled(true);
                    this.gHn.setClickable(true);
                    this.pHA.setText(null);
                } else if (((acg) c12955c.ehh.fsH.fsP).wjY != 0) {
                    this.gHn.setEnabled(false);
                    this.gHn.setClickable(false);
                    this.pHA.setText(((acg) c12955c.ehh.fsH.fsP).wjZ);
                    this.pHA.setVisibility(0);
                    this.pHA.setTextColor(getResources().getColor(C25738R.color.f12266xy));
                    AppMethodBeat.m2505o(44348);
                    return;
                }
                AppMethodBeat.m2505o(44348);
                return;
            }
        } else if (!(c1207m instanceof C12955c)) {
            if (c1207m instanceof C28809d) {
                if (i2 == 100) {
                    this.gHn.setEnabled(true);
                    this.gHn.setClickable(true);
                } else {
                    this.gHn.setEnabled(false);
                    this.gHn.setClickable(false);
                }
                m57132cM(((C28809d) c1207m).pFZ);
                this.pHA.setText(str);
                this.pHA.setVisibility(0);
                this.pHA.setTextColor(getResources().getColor(C25738R.color.f12266xy));
                this.pHz.setText(((C28809d) c1207m).pFQ);
                this.pHz.setTextColor(getResources().getColor(C25738R.color.f12266xy));
                AppMethodBeat.m2505o(44348);
                return;
            }
            if (C5046bo.isNullOrNil(str)) {
                str = getString(C25738R.string.fu2);
            }
            C30379h.m48448a((Context) this, str, null, false, new C347824());
        }
        AppMethodBeat.m2505o(44348);
    }

    public void onResume() {
        AppMethodBeat.m2504i(44349);
        super.onResume();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) C19486m.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) C19483d.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a((int) C27084e.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(1555, (C1202f) this);
        AppMethodBeat.m2505o(44349);
    }

    public void onPause() {
        AppMethodBeat.m2504i(44350);
        super.onPause();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) C19486m.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) C19483d.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b((int) C27084e.CTRL_INDEX, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(1555, (C1202f) this);
        AppMethodBeat.m2505o(44350);
    }

    /* renamed from: cM */
    private void m57132cM(List<MallRechargeProduct> list) {
        AppMethodBeat.m2504i(44351);
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (int i2 = 0; i2 < list.size(); i2++) {
                MallRechargeProduct mallRechargeProduct = (MallRechargeProduct) list.get(i2);
                if (mallRechargeProduct.fmR == 2) {
                    if (this.pHM != null && mallRechargeProduct.cwg.equals(this.pHM.cwg)) {
                        mallRechargeProduct.isDefault = true;
                        i = true;
                    }
                    arrayList.add(mallRechargeProduct);
                }
            }
            if (i == 0 && arrayList.size() > 0) {
                ((MallRechargeProduct) arrayList.get(0)).isDefault = true;
            }
            this.pHI.mo8311cN(arrayList);
            AppMethodBeat.m2505o(44351);
            return;
        }
        this.pHI.mo8311cN(new ArrayList());
        AppMethodBeat.m2505o(44351);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x011b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(44352);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data != null) {
                        if (C35805b.m58714o(this, "android.permission.READ_CONTACTS")) {
                            String str;
                            String str2;
                            Cursor query = getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = ".concat(String.valueOf(query.getString(query.getColumnIndex("_id")))), null, null);
                                    if (query2.moveToFirst()) {
                                        str = null;
                                        str2 = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string = query2.getString(columnIndex);
                                            String string2 = query2.getString(columnIndex2);
                                            C4990ab.m7410d("MicroMsg.MallRechargeUI", "username : ".concat(String.valueOf(string2)));
                                            if (string != null) {
                                                C4990ab.m7410d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(string)));
                                                string = C43421b.m77507ws(string);
                                                C4990ab.m7410d("MicroMsg.MallRechargeUI", "phoneNumber : ".concat(String.valueOf(string)));
                                                if (!PhoneNumberUtils.isGlobalPhoneNumber(string)) {
                                                    string = str2;
                                                }
                                                C4990ab.m7410d("MicroMsg.MallRechargeUI", "phoneResult : ".concat(String.valueOf(string)));
                                            } else {
                                                string = str2;
                                            }
                                            query2.moveToNext();
                                            str = string2;
                                            str2 = string;
                                        }
                                    } else {
                                        str = null;
                                        str2 = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (!PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                                        this.pHQ.clear();
                                        this.pHJ.setInput(new C43420a(str2, str, 1));
                                        this.pHz.setText("");
                                        this.pHA.setVisibility(4);
                                        arW();
                                        break;
                                    }
                                    showDialog(2);
                                    break;
                                }
                            }
                            str = null;
                            str2 = null;
                            query.close();
                            if (!PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                            }
                            break;
                        }
                        C4990ab.m7412e("MicroMsg.MallRechargeUI", "no contact permission");
                        AppMethodBeat.m2505o(44352);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.MallRechargeUI", "uri == null");
                    AppMethodBeat.m2505o(44352);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.piJ) {
                        C4990ab.m7416i("MicroMsg.MallRechargeUI", "MallRecharge pay result : ok");
                        C46158a.cea().mo74108a(this.pHJ.getInputRecord());
                        finish();
                        this.piJ = true;
                        break;
                    }
                }
                C4990ab.m7416i("MicroMsg.MallRechargeUI", "MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(44352);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44353);
        C4879a.xxA.mo10053d(this.piM);
        super.onDestroy();
        AppMethodBeat.m2505o(44353);
    }

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(44354);
        if (this.pHN == null) {
            AppMethodBeat.m2505o(44354);
            return;
        }
        if (str.equals(this.pHN)) {
            this.pHE.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(44314);
                    RechargeUI.this.pHE.setImageBitmap(bitmap);
                    AppMethodBeat.m2505o(44314);
                }
            });
        }
        AppMethodBeat.m2505o(44354);
    }

    public final void showVKB() {
        AppMethodBeat.m2504i(44355);
        C4990ab.m7410d("MicroMsg.MallRechargeUI", "showVKB");
        this.pHJ.setInfoTvImageResource(C25738R.drawable.f6801r8);
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.m2505o(44355);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.m2505o(44355);
        } else if (currentFocus.getWindowToken() == null) {
            AppMethodBeat.m2505o(44355);
        } else {
            inputMethodManager.showSoftInput(currentFocus, 2);
            AppMethodBeat.m2505o(44355);
        }
    }

    public final void aqX() {
        AppMethodBeat.m2504i(44356);
        C4990ab.m7410d("MicroMsg.MallRechargeUI", "hideVKB");
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.m2505o(44356);
            return;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            AppMethodBeat.m2505o(44356);
            return;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.m2505o(44356);
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        AppMethodBeat.m2505o(44356);
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(44357);
        switch (i) {
            case 1:
                final int color = getResources().getColor(C25738R.color.a54);
                final int color2 = getResources().getColor(C25738R.color.a61);
                View inflate = getLayoutInflater().inflate(2130970474, null);
                final TextView textView = (TextView) inflate.findViewById(2131826890);
                final ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(2131826891);
                final ListViewInScrollView listViewInScrollView2 = (ListViewInScrollView) inflate.findViewById(2131826892);
                final TextView textView2 = (TextView) inflate.findViewById(2131826884);
                final View findViewById = inflate.findViewById(2131826885);
                final TextView textView3 = (TextView) inflate.findViewById(2131826887);
                final View findViewById2 = inflate.findViewById(2131826888);
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(2131826889);
                LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
                layoutParams.height = (getResources().getDimensionPixelSize(C25738R.dimen.f9990mg) * this.pHL) + 4;
                relativeLayout.setLayoutParams(layoutParams);
                listViewInScrollView.setAdapter(this.pHH);
                listViewInScrollView.setOnItemClickListener(new C36905());
                listViewInScrollView2.setAdapter(this.pHI);
                listViewInScrollView2.setOnItemClickListener(new C36916());
                inflate.findViewById(2131826883).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(44312);
                        findViewById.setVisibility(0);
                        textView2.setTextColor(color2);
                        listViewInScrollView.setVisibility(0);
                        findViewById2.setVisibility(8);
                        textView3.setTextColor(color);
                        listViewInScrollView2.setVisibility(8);
                        if (RechargeUI.this.pHH.getCount() == 0) {
                            textView.setVisibility(0);
                            AppMethodBeat.m2505o(44312);
                            return;
                        }
                        textView.setVisibility(8);
                        AppMethodBeat.m2505o(44312);
                    }
                });
                final View view = findViewById2;
                final TextView textView4 = textView3;
                final int i2 = color2;
                final ListViewInScrollView listViewInScrollView3 = listViewInScrollView2;
                final View view2 = findViewById;
                final TextView textView5 = textView2;
                final int i3 = color;
                final ListViewInScrollView listViewInScrollView4 = listViewInScrollView;
                final TextView textView6 = textView;
                inflate.findViewById(2131826886).setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(44313);
                        view.setVisibility(0);
                        textView4.setTextColor(i2);
                        listViewInScrollView3.setVisibility(0);
                        view2.setVisibility(8);
                        textView5.setTextColor(i3);
                        listViewInScrollView4.setVisibility(8);
                        if (RechargeUI.this.pHI.getCount() == 0) {
                            textView6.setVisibility(0);
                            AppMethodBeat.m2505o(44313);
                            return;
                        }
                        textView6.setVisibility(8);
                        AppMethodBeat.m2505o(44313);
                    }
                });
                if (this.pHH.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
                C5652a c5652a = new C5652a(this);
                c5652a.asD(null);
                c5652a.mo11479fn(inflate);
                c5652a.mo11478f(null);
                Dialog aMb = c5652a.aMb();
                AppMethodBeat.m2505o(44357);
                return aMb;
            default:
                C5653c b = C30379h.m48461b((Context) this, getString(C25738R.string.cyj), "", true);
                AppMethodBeat.m2505o(44357);
                return b;
        }
    }

    /* renamed from: c */
    static /* synthetic */ boolean m57131c(RechargeUI rechargeUI) {
        AppMethodBeat.m2504i(44359);
        if (rechargeUI.pHJ.getInputRecord().cvp == 0) {
            Context context = rechargeUI;
            C30379h.m48466d(context, rechargeUI.getString(C25738R.string.cyc, new Object[]{rechargeUI.pHJ.getText().toString()}), "", rechargeUI.getString(C25738R.string.f9262up), rechargeUI.getString(C25738R.string.f9183s2), new C347812(), null);
            AppMethodBeat.m2505o(44359);
            return false;
        }
        AppMethodBeat.m2505o(44359);
        return true;
    }

    /* renamed from: d */
    static /* synthetic */ void m57134d(RechargeUI rechargeUI) {
        AppMethodBeat.m2504i(44360);
        rechargeUI.m57147p(new C39571g(rechargeUI.pHM, rechargeUI.ceq()));
        AppMethodBeat.m2505o(44360);
    }
}
