package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p230g.p231a.C32615pn;
import com.tencent.p177mm.p230g.p231a.C45375um;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p748a.C43758t;
import com.tencent.p177mm.plugin.wallet_core.id_verify.C40105a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.plugin.wallet_core.utils.C40148d;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import com.tenpay.ndk.Encrypt;
import java.util.LinkedList;
import java.util.List;

@C5271a(19)
/* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI */
public class WalletBankcardIdUI extends WalletBaseUI implements C36397a {
    private Button gEZ;
    private int gOW = -1;
    protected WalletFormView tEp;
    protected WalletFormView tEq;
    private Bankcard tEr;
    private C36841a tEs;
    private boolean tEt = false;
    private boolean tEu;
    C4884c tmk = new C354861();
    C4884c trF = new C142662();

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$10 */
    class C440010 implements OnClickListener {
        C440010() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$3 */
    class C44013 implements View.OnClickListener {
        C44013() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47163);
            C7060h.pYm.mo8381e(11353, Integer.valueOf(1), Integer.valueOf(0));
            WalletBankcardIdUI.this.ari();
            AppMethodBeat.m2505o(47163);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$2 */
    class C142662 extends C4884c<C32615pn> {
        C142662() {
            AppMethodBeat.m2504i(47161);
            this.xxI = C32615pn.class.getName().hashCode();
            AppMethodBeat.m2505o(47161);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47162);
            C32615pn c32615pn = (C32615pn) c4883b;
            if (c32615pn instanceof C32615pn) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletBankcardIdUI.m61248a(WalletBankcardIdUI.this, encrypt.desedeEncode(c32615pn.cLJ.cardId, randomKey), randomKey, c32615pn.cLJ.cLK);
                WalletBankcardIdUI.this.finish();
                AppMethodBeat.m2505o(47162);
                return true;
            }
            C4990ab.m7414f("Micromsg.WalletInputCardIDUI", "mismatched scanBandkCardResultEvent event");
            AppMethodBeat.m2505o(47162);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$4 */
    class C142674 implements C29672a {
        C142674() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47164);
            C4990ab.m7416i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
            WalletBankcardIdUI.m61247a(WalletBankcardIdUI.this);
            AppMethodBeat.m2505o(47164);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$5 */
    class C142685 implements View.OnClickListener {
        C142685() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47165);
            WalletBankcardIdUI.this.showDialog(1);
            AppMethodBeat.m2505o(47165);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$1 */
    class C354861 extends C4884c<C45375um> {
        C354861() {
            AppMethodBeat.m2504i(47159);
            this.xxI = C45375um.class.getName().hashCode();
            AppMethodBeat.m2505o(47159);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(47160);
            WalletBankcardIdUI.this.finish();
            AppMethodBeat.m2505o(47160);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$9 */
    class C368379 implements OnClickListener {
        C368379() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47169);
            View findFocus = WalletBankcardIdUI.this.mController.contentView == null ? null : WalletBankcardIdUI.this.mController.contentView.findFocus();
            if (findFocus != null && (findFocus instanceof EditText)) {
                WalletBankcardIdUI.this.showVKB();
            }
            AppMethodBeat.m2505o(47169);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$7 */
    class C368387 implements View.OnClickListener {
        C368387() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(47167);
            C7060h.pYm.mo8381e(11353, Integer.valueOf(2), Integer.valueOf(0));
            C36391e.m60005d(WalletBankcardIdUI.this, C14241r.cPI().bhp());
            AppMethodBeat.m2505o(47167);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$8 */
    class C368398 implements OnClickListener {
        C368398() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(47168);
            ((C40105a) WalletBankcardIdUI.this.dOD()).mo8127c(WalletBankcardIdUI.this, 0);
            WalletBankcardIdUI.this.finish();
            AppMethodBeat.m2505o(47168);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$6 */
    class C368406 implements TextWatcher {
        C368406() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AppMethodBeat.m2504i(47166);
            if (WalletBankcardIdUI.this.tEp.asa() && !WalletBankcardIdUI.this.tEt) {
                WalletBankcardIdUI.this.tEt = true;
                WalletBankcardIdUI.this.tEp.cey();
            }
            AppMethodBeat.m2505o(47166);
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$a */
    static class C36841a extends BaseAdapter {
        private Context mContext = null;
        private LayoutInflater mInflater = null;
        List<C43758t> tEw = new LinkedList();

        /* renamed from: com.tencent.mm.plugin.wallet_core.ui.WalletBankcardIdUI$a$a */
        class C36842a {
            TextView pMc;
            ImageView tEx;
            TextView tEy;
            TextView tEz;

            C36842a() {
            }
        }

        public C36841a(Context context, List<C43758t> list) {
            AppMethodBeat.m2504i(47170);
            this.mInflater = LayoutInflater.from(context);
            this.tEw = list;
            this.mContext = context;
            AppMethodBeat.m2505o(47170);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(47171);
            if (this.tEw == null) {
                AppMethodBeat.m2505o(47171);
                return 0;
            }
            int size = this.tEw.size();
            AppMethodBeat.m2505o(47171);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(47172);
            Object obj = this.tEw.get(i);
            AppMethodBeat.m2505o(47172);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C36842a c36842a;
            AppMethodBeat.m2504i(47173);
            if (view == null) {
                view = this.mInflater.inflate(2130971072, viewGroup, false);
                c36842a = new C36842a();
                c36842a.tEx = (ImageView) view.findViewById(2131828699);
                c36842a.pMc = (TextView) view.findViewById(2131828700);
                c36842a.tEy = (TextView) view.findViewById(2131828701);
                c36842a.tEz = (TextView) view.findViewById(2131828702);
                view.setTag(c36842a);
            } else {
                c36842a = (C36842a) view.getTag();
            }
            C43758t c43758t = (C43758t) getItem(i);
            if (C5046bo.isNullOrNil(c43758t.pcj)) {
                c36842a.pMc.setVisibility(8);
            } else {
                c36842a.pMc.setText(c43758t.pcj);
                c36842a.pMc.setVisibility(0);
            }
            if (C5046bo.isNullOrNil(c43758t.tnN)) {
                c36842a.tEy.setVisibility(8);
            } else {
                c36842a.tEy.setText(c43758t.tnN);
                c36842a.tEy.setVisibility(0);
            }
            if (C5046bo.isNullOrNil(c43758t.tmP)) {
                c36842a.tEz.setVisibility(8);
            } else {
                c36842a.tEz.setText(c43758t.tmP);
                c36842a.tEz.setVisibility(0);
            }
            String str = c43758t.tnT;
            C4990ab.m7418v("Micromsg.WalletInputCardIDUI", "bankType:" + c43758t.tnS + ", logurl:" + str);
            c36842a.tEx.setImageBitmap(null);
            if (!C5046bo.isNullOrNil(str)) {
                C17927a c17927a = new C17927a();
                C32291o.ahq();
                c17927a.ePY = null;
                c17927a.ePK = C6457e.eSn;
                c17927a.ePJ = C46362b.m87140UK(str);
                c17927a.ePH = true;
                c17927a.ePZ = true;
                C32291o.ahp().mo43766a(str, c36842a.tEx, c17927a.ahG());
            }
            AppMethodBeat.m2505o(47173);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletBankcardIdUI() {
        AppMethodBeat.m2504i(47174);
        AppMethodBeat.m2505o(47174);
    }

    public final int getLayoutId() {
        return 2130971063;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(47175);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.fgs);
        initView();
        C4879a.xxA.mo10052c(this.tmk);
        C4879a.xxA.mo10052c(this.trF);
        this.gOW = this.mBundle.getInt("key_bind_scene");
        AppMethodBeat.m2505o(47175);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(47176);
        C4879a.xxA.mo10053d(this.tmk);
        C4879a.xxA.mo10053d(this.trF);
        super.onDestroy();
        AppMethodBeat.m2505o(47176);
    }

    public final void initView() {
        AppMethodBeat.m2504i(47177);
        this.gEZ = (Button) findViewById(2131822846);
        this.tEp = (WalletFormView) findViewById(2131826500);
        C30890a.m49294b(this.tEp);
        this.tEq = (WalletFormView) findViewById(2131828681);
        if (this.mBundle.getBoolean("key_bind_show_change_card", false)) {
            C30890a.m49297d(this, this.tEq);
        } else {
            C30890a.m49299e(this, this.tEq);
        }
        this.tEp.setOnInputValidChangeListener(this);
        this.gEZ.setOnClickListener(new C44013());
        C40931c dOD = dOD();
        if (dOD != null) {
            this.tEu = dOD.mqu.getBoolean("key_is_realname_verify_process", false);
        } else {
            this.tEu = false;
        }
        if (this.tEu) {
            setMMTitle((int) C25738R.string.fqh);
        } else {
            setMMTitle((int) C25738R.string.fgs);
        }
        TextView textView = (TextView) findViewById(2131828577);
        if (C14241r.cPI().cQi() || C14241r.cPI().cQh()) {
            C46373j c46373j = new C46373j(this);
            c46373j.tHw = new C142674();
            String string = getString(C25738R.string.fgm);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(c46373j, string.length() - 6, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setVisibility(0);
            String string2 = this.mBundle.getString("key_custom_bind_tips");
            if (!C5046bo.isNullOrNil(string2)) {
                textView.setText(string2);
            }
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.mBundle.getParcelable("key_favor_pay_info");
        Orders orders = (Orders) this.mBundle.getParcelable("key_orders");
        if (!(favorPayInfo == null || orders == null)) {
            C22621b a = C29666c.tDU.mo47919a(orders);
            TextView textView2 = (TextView) findViewById(2131828682);
            if (a != null) {
                List acT = a.acT(a.acW(favorPayInfo.tzb));
                if (acT.size() > 0) {
                    this.tEs = new C36841a(this.mController.ylL, acT);
                    textView2.setText(C25738R.string.fgk);
                    textView2.setOnClickListener(new C142685());
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            } else {
                C4990ab.m7420w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
                textView2.setVisibility(8);
            }
        }
        C22587ak cPI = C14241r.cPI();
        if (!cPI.cQg() || cPI.bhp() == null || C5046bo.isNullOrNil(cPI.bhp().trim()) || !cPI.cQp()) {
            this.tEq.setVisibility(8);
            this.tEp.setHint(getString(C25738R.string.fgo));
        } else {
            this.tEq.setVisibility(0);
            this.tEq.setText(cPI.bhp());
            this.tEp.setHint(getString(C25738R.string.fbz));
            this.tEq.setClickable(false);
            this.tEq.setEnabled(false);
        }
        if (this.mBundle.getInt("key_bind_scene") == 18 || this.mBundle.getInt("key_bind_scene") == 19) {
            this.tEp.setHint(getString(C25738R.string.fgq));
        }
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, null);
        if (!C5046bo.isNullOrNil(str)) {
            this.tEp.setHint(str);
        }
        this.tEr = (Bankcard) this.mBundle.getParcelable("key_history_bankcard");
        if (this.tEr != null) {
            this.tEp.setText(this.tEr.twO);
            this.tEp.mo64594a(new C368406());
        }
        arW();
        C40148d.m68847a(this, this.mBundle, 2);
        mo39989e(this.tEp, 0, false);
        this.tEp.setOnInfoIvClickListener(new C368387());
        if (C14241r.cPI().cQo().cPX()) {
            this.tEp.getInfoIv().setVisibility(0);
            this.tEp.getInfoIv().setImageResource(C1318a.wallet_scan_camera);
        }
        AppMethodBeat.m2505o(47177);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ari() {
        AppMethodBeat.m2504i(47178);
        if (dOD() == null) {
            C4990ab.m7412e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
            AppMethodBeat.m2505o(47178);
            return;
        }
        String string = dOD().mqu.getString("kreq_token");
        int i = this.mBundle.getInt("entry_scene", -1);
        if (this.tEr != null) {
            C1207m c14225t = new C14225t(cNH(), null, (PayInfo) this.mBundle.getParcelable("key_pay_info"), string, this.gOW, i);
            c14225t.pNL = this.tEr.field_bankcardType;
            this.mBundle.putParcelable("key_history_bankcard", this.tEr);
            mo39970a(c14225t, true, true);
            AppMethodBeat.m2505o(47178);
        } else if (arW()) {
            mo39970a(new C14225t(cNH(), this.tEp.getText(), (PayInfo) this.mBundle.getParcelable("key_pay_info"), string, this.gOW, i), true, true);
            AppMethodBeat.m2505o(47178);
        } else {
            C30379h.m48467g(this, C25738R.string.fk4, C25738R.string.f9238tz);
            AppMethodBeat.m2505o(47178);
        }
    }

    public Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(47179);
        Dialog a;
        if (i == 1) {
            View inflate = getLayoutInflater().inflate(2130971114, null);
            ((ListViewInScrollView) inflate.findViewById(2131821054)).setAdapter(this.tEs);
            C5652a c5652a = new C5652a(this);
            c5652a.mo11446PV(C25738R.string.fgj);
            c5652a.mo11479fn(inflate);
            c5652a.mo11478f(null);
            c5652a.mo11453Qc(C25738R.string.ffp);
            C5653c aMb = c5652a.aMb();
            AppMethodBeat.m2505o(47179);
            return aMb;
        } else if (this.tEu && i == 1000) {
            int a2;
            String string = getString(C25738R.string.fgl);
            C40931c aE = C24143a.m37112aE(this);
            if (aE != null) {
                a2 = aE.mo26468a((MMActivity) this, 1);
            } else {
                a2 = -1;
            }
            if (a2 != -1) {
                string = getString(a2);
            }
            a = C30379h.m48453a((Context) this, true, string, "", getString(C25738R.string.f9262up), getString(C25738R.string.f9183s2), new C368398(), new C368379());
            AppMethodBeat.m2505o(47179);
            return a;
        } else {
            a = super.onCreateDialog(i);
            AppMethodBeat.m2505o(47179);
            return a;
        }
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47180);
        C4990ab.m7410d("Micromsg.WalletInputCardIDUI", " errCode: " + i2 + " errMsg :" + str);
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C14225t) {
                C14225t c14225t = (C14225t) c1207m;
                bundle.putBoolean("key_need_area", c14225t.cOU());
                bundle.putBoolean("key_need_profession", c14225t.cOV());
                bundle.putParcelableArray("key_profession_list", c14225t.tur);
                bundle.putBoolean("key_need_country", c14225t.tus == 1);
                bundle.putStringArray("key_country_excludes", c14225t.tut);
                if (c14225t.tun == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.tEp.getText());
                    C24143a.m37116j(this, bundle);
                } else if (c14225t.tun.tyC && c14225t.tun.isError()) {
                    C30379h.m48467g(this, C25738R.string.f_1, C25738R.string.f9238tz);
                    AppMethodBeat.m2505o(47180);
                    return true;
                } else {
                    bundle.putString("bank_name", c14225t.tun.nuL);
                    bundle.putParcelable("elemt_query", c14225t.tun);
                    bundle.putString("key_card_id", this.tEp.getText());
                    C24143a.m37116j(this, bundle);
                    AppMethodBeat.m2505o(47180);
                    return true;
                }
            }
        } else if (i2 == 1 && (c1207m instanceof C14225t)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.tEp.getText());
            C24143a.m37116j(this, bundle);
            AppMethodBeat.m2505o(47180);
            return true;
        }
        AppMethodBeat.m2505o(47180);
        return false;
    }

    private boolean arW() {
        AppMethodBeat.m2504i(47181);
        if (this.tEp.mo64602fx(null)) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
            AppMethodBeat.m2505o(47181);
            return true;
        }
        this.gEZ.setEnabled(false);
        this.gEZ.setClickable(false);
        AppMethodBeat.m2505o(47181);
        return false;
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(47182);
        if (!z) {
            this.tEr = null;
            this.mBundle.putParcelable("key_history_bankcard", null);
        }
        arW();
        AppMethodBeat.m2505o(47182);
    }

    public final boolean cNR() {
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: a */
    static /* synthetic */ void m61247a(WalletBankcardIdUI walletBankcardIdUI) {
        AppMethodBeat.m2504i(47183);
        LayoutInflater layoutInflater = (LayoutInflater) walletBankcardIdUI.mController.ylL.getSystemService("layout_inflater");
        View view = (TextView) layoutInflater.inflate(2130969840, null);
        view.setText(walletBankcardIdUI.getString(C25738R.string.fck));
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        C30379h.m48441a(walletBankcardIdUI.mController.ylL, walletBankcardIdUI.getString(C25738R.string.fcj), walletBankcardIdUI.getString(C25738R.string.ffp), view, new C440010());
        AppMethodBeat.m2505o(47183);
    }

    /* renamed from: a */
    static /* synthetic */ void m61248a(WalletBankcardIdUI walletBankcardIdUI, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.m2504i(47184);
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        C40931c aE = C24143a.m37112aE(walletBankcardIdUI);
        if (aE != null) {
            aE.mo64571b(walletBankcardIdUI, WalletConfirmCardIDUI.class, bundle);
        }
        AppMethodBeat.m2505o(47184);
    }
}
