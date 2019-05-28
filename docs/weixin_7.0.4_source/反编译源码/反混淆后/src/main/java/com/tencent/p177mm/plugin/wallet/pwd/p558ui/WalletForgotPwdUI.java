package com.tencent.p177mm.plugin.wallet.pwd.p558ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32615pn;
import com.tencent.p177mm.p230g.p231a.C45375um;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22586aj;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j.C29672a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletConfirmCardIDUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import com.tenpay.ndk.Encrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI */
public class WalletForgotPwdUI extends WalletBaseUI implements C36397a {
    private LinearLayout eol;
    private Button gEZ;
    private ListView gKd;
    private ArrayList<Bankcard> tlM = new ArrayList();
    C4884c tmk = new C142078();
    private WalletFormView trA;
    private WalletFormView trB;
    private int trC = 1;
    private boolean trD = false;
    private boolean trE = false;
    C4884c trF = new C142117();
    private List<ElementQuery> trx = new LinkedList();
    /* renamed from: try */
    private Bankcard f2952try;
    private C14208a trz;

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$1 */
    class C43761 implements OnClickListener {
        C43761() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46272);
            C7060h.pYm.mo8381e(11353, Integer.valueOf(1), Integer.valueOf(0));
            WalletForgotPwdUI.m22404a(WalletForgotPwdUI.this);
            AppMethodBeat.m2505o(46272);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$2 */
    class C43772 implements OnClickListener {
        C43772() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46273);
            C36391e.m60016n(WalletForgotPwdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
            AppMethodBeat.m2505o(46273);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$3 */
    class C43783 implements OnClickListener {
        C43783() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46274);
            C7060h.pYm.mo8381e(11353, Integer.valueOf(2), Integer.valueOf(0));
            MMActivity mMActivity = WalletForgotPwdUI.this;
            C46332s.cNC();
            C36391e.m60005d(mMActivity, C46332s.cND().bhp());
            AppMethodBeat.m2505o(46274);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$4 */
    class C142044 implements Runnable {
        C142044() {
        }

        public final void run() {
            AppMethodBeat.m2504i(46275);
            WalletForgotPwdUI.this.trz.notifyDataSetChanged();
            WalletForgotPwdUI.m22408c(WalletForgotPwdUI.this);
            AppMethodBeat.m2505o(46275);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$5 */
    class C142055 implements C29672a {
        C142055() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46276);
            WalletForgotPwdUI.this.trD = true;
            WalletForgotPwdUI.m22404a(WalletForgotPwdUI.this);
            AppMethodBeat.m2505o(46276);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$6 */
    class C142066 implements OnClickListener {
        C142066() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(46277);
            WalletForgotPwdUI.this.trD = true;
            WalletForgotPwdUI.m22404a(WalletForgotPwdUI.this);
            AppMethodBeat.m2505o(46277);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$8 */
    class C142078 extends C4884c<C45375um> {
        C142078() {
            AppMethodBeat.m2504i(46280);
            this.xxI = C45375um.class.getName().hashCode();
            AppMethodBeat.m2505o(46280);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(46281);
            WalletForgotPwdUI.this.finish();
            AppMethodBeat.m2505o(46281);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$a */
    public class C14208a extends BaseAdapter {
        private Context context;
        List<Bankcard> items = new ArrayList();

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(46288);
            Bankcard Hd = m22412Hd(i);
            AppMethodBeat.m2505o(46288);
            return Hd;
        }

        public C14208a(Context context) {
            AppMethodBeat.m2504i(46284);
            this.context = context;
            AppMethodBeat.m2505o(46284);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            WalletFormView walletFormView;
            AppMethodBeat.m2504i(46285);
            if (view == null) {
                walletFormView = (WalletFormView) View.inflate(this.context, 2130971054, null);
            } else {
                walletFormView = (WalletFormView) view;
            }
            final Bankcard Hd = m22412Hd(i);
            if (Hd != null) {
                String str = Hd.field_desc;
                if (Hd.field_bankcardState == 1) {
                    str = str + this.context.getString(C25738R.string.ffc);
                }
                walletFormView.setText(str);
            }
            walletFormView.setOnClickListener(new OnClickListener() {

                /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$a$1$1 */
                class C142101 implements DialogInterface.OnClickListener {
                    C142101() {
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(46282);
                        C36391e.m60016n(C14208a.this.context, "https://kf.qq.com/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                        AppMethodBeat.m2505o(46282);
                    }
                }

                public final void onClick(View view) {
                    AppMethodBeat.m2504i(46283);
                    if (Hd == null || Hd.field_bankcardState != 1) {
                        WalletForgotPwdUI.this.f2952try = Hd;
                        WalletForgotPwdUI.this.trD = false;
                        WalletForgotPwdUI.m22404a(WalletForgotPwdUI.this);
                        AppMethodBeat.m2505o(46283);
                        return;
                    }
                    C5652a c5652a = new C5652a(C14208a.this.context);
                    c5652a.mo11450PZ(C25738R.string.ffa);
                    c5652a.mo11453Qc(C25738R.string.ffb).mo11457a(new C142101());
                    c5652a.mo11454Qd(C25738R.string.f9151r4);
                    c5652a.mo11482rc(false);
                    c5652a.aMb().show();
                    AppMethodBeat.m2505o(46283);
                }
            });
            AppMethodBeat.m2505o(46285);
            return walletFormView;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(46286);
            int size = this.items.size();
            AppMethodBeat.m2505o(46286);
            return size;
        }

        /* renamed from: Hd */
        private Bankcard m22412Hd(int i) {
            AppMethodBeat.m2504i(46287);
            if (i < 0 || i > this.items.size() - 1) {
                AppMethodBeat.m2505o(46287);
                return null;
            }
            Bankcard bankcard = (Bankcard) this.items.get(i);
            AppMethodBeat.m2505o(46287);
            return bankcard;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.pwd.ui.WalletForgotPwdUI$7 */
    class C142117 extends C4884c<C32615pn> {
        C142117() {
            AppMethodBeat.m2504i(46278);
            this.xxI = C32615pn.class.getName().hashCode();
            AppMethodBeat.m2505o(46278);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(46279);
            C32615pn c32615pn = (C32615pn) c4883b;
            if (c32615pn instanceof C32615pn) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletForgotPwdUI.m22405a(WalletForgotPwdUI.this, encrypt.desedeEncode(c32615pn.cLJ.cardId, randomKey), randomKey, c32615pn.cLJ.cLK);
                AppMethodBeat.m2505o(46279);
                return true;
            }
            C4990ab.m7414f("MicroMsg.WalletForgotPwdUI", "mismatched scanBandkCardResultEvent event");
            AppMethodBeat.m2505o(46279);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletForgotPwdUI() {
        AppMethodBeat.m2504i(46289);
        AppMethodBeat.m2505o(46289);
    }

    /* renamed from: a */
    static /* synthetic */ void m22404a(WalletForgotPwdUI walletForgotPwdUI) {
        AppMethodBeat.m2504i(46303);
        walletForgotPwdUI.ari();
        AppMethodBeat.m2505o(46303);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(46290);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.fna);
        this.trE = this.mBundle.getBoolean("key_is_force_bind", false);
        if (!this.trE) {
            mo39970a(new C35475y(null, 6), true, true);
            mo9439AM(4);
        }
        initView();
        C4879a.xxA.mo10052c(this.trF);
        C4879a.xxA.mo10052c(this.tmk);
        AppMethodBeat.m2505o(46290);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(46291);
        C4879a.xxA.mo10053d(this.trF);
        C4879a.xxA.mo10053d(this.tmk);
        super.onDestroy();
        AppMethodBeat.m2505o(46291);
    }

    public void onResume() {
        AppMethodBeat.m2504i(46292);
        super.onResume();
        update();
        AppMethodBeat.m2505o(46292);
    }

    private void update() {
        AppMethodBeat.m2504i(46293);
        C46332s.cNC();
        this.tlM = C46332s.cND().cQB();
        if (this.tlM == null || this.tlM.size() == 0 || this.trE) {
            C4990ab.m7417i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", Boolean.valueOf(this.trE));
            this.tlM = new ArrayList();
            this.eol.setVisibility(0);
            this.gKd.setVisibility(8);
            setMMTitle((int) C25738R.string.fei);
            ((TextView) findViewById(2131828798)).setText(getString(C25738R.string.fm8));
            WalletFormView walletFormView = this.trB;
            C46332s.cNC();
            walletFormView.setText(C36391e.atv(C46332s.cND().bhp()));
            AppMethodBeat.m2505o(46293);
            return;
        }
        C4990ab.m7416i("MicroMsg.WalletForgotPwdUI", "domestic process!");
        if (C24143a.m37112aE(this) != null) {
            mo39970a(new C14225t(), true, false);
        }
        this.eol.setVisibility(8);
        this.gEZ.setVisibility(8);
        findViewById(2131828804).setVisibility(0);
        this.trz = new C14208a(this);
        this.gKd.setAdapter(this.trz);
        this.trz.items = this.tlM;
        this.trz.notifyDataSetChanged();
        AppMethodBeat.m2505o(46293);
    }

    public void initView() {
        AppMethodBeat.m2504i(46294);
        this.gKd = (ListView) findViewById(2131828799);
        this.eol = (LinearLayout) findViewById(2131828800);
        this.trB = (WalletFormView) findViewById(2131828681);
        this.trA = (WalletFormView) findViewById(2131828801);
        C30890a.m49294b(this.trA);
        if (this.mBundle.getBoolean("key_is_paymanager", false)) {
            C30890a.m49297d(this, this.trB);
        } else {
            C30890a.m49299e(this, this.trB);
        }
        this.trB.setOnInputValidChangeListener(this);
        this.trA.setOnInputValidChangeListener(this);
        this.gEZ = (Button) findViewById(2131822846);
        this.gEZ.setOnClickListener(new C43761());
        this.trD = false;
        C46332s.cNC();
        this.tlM = C46332s.cND().cQB();
        update();
        findViewById(2131828804).setOnClickListener(new C43772());
        arW();
        mo21157a((View) this.trA, 0, false, false);
        this.trA.setOnInfoIvClickListener(new C43783());
        this.trA.getInfoIv().setImageResource(C1318a.wallet_scan_camera);
        this.trA.getInfoIv().setVisibility(0);
        AppMethodBeat.m2505o(46294);
    }

    private void ari() {
        AppMethodBeat.m2504i(46296);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_reset_with_new_card", this.mBundle.getBoolean("key_is_reset_with_new_card", false));
        cOC();
        if (this.f2952try == null && !this.trD) {
            mo39970a(new C14225t(null, this.trA.getText(), null), true, true);
            AppMethodBeat.m2505o(46296);
        } else if (this.trD) {
            C22586aj cRh = C14241r.cPE().cRh();
            if (C5046bo.isNullOrNil(cRh.field_find_passwd_url)) {
                bundle.putBoolean("key_is_force_bind", true);
                bundle.putBoolean("key_is_reset_with_new_card", true);
                if (dOD() != null) {
                    dOD().mo8124a((Activity) this, 0, bundle);
                }
                AppMethodBeat.m2505o(46296);
                return;
            }
            C4990ab.m7416i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
            C36391e.m60016n(this, cRh.field_find_passwd_url, false);
            AppMethodBeat.m2505o(46296);
        } else {
            C40931c aE = C24143a.m37112aE(this);
            bundle.putParcelable("key_bankcard", this.f2952try);
            ElementQuery elementQuery = new ElementQuery();
            for (Parcelable parcelable : this.trx) {
                C4990ab.m7416i("MicroMsg.WalletForgotPwdUI", "helios:::" + parcelable.pbn);
                if (!C5046bo.isNullOrNil(parcelable.pbn) && !C5046bo.isNullOrNil(this.f2952try.field_bankcardType) && parcelable.pbn.trim().equals(this.f2952try.field_bankcardType.trim())) {
                    break;
                }
            }
            Object parcelable2 = elementQuery;
            bundle.putParcelable("elemt_query", parcelable2);
            if (aE != null) {
                aE.mo8124a((Activity) this, 0, bundle);
            }
            AppMethodBeat.m2505o(46296);
        }
    }

    public final int getLayoutId() {
        return 2130971099;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(46297);
        C4990ab.m7417i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", Integer.valueOf(i2), str, c1207m);
        if (i == 0 && i2 == 0) {
            String str2;
            if (c1207m instanceof C14225t) {
                C14225t c14225t = (C14225t) c1207m;
                Bundle bundle = new Bundle();
                if (C5046bo.isNullOrNil(c14225t.kaE)) {
                    this.trx = c14225t.tum;
                    C4990ab.m7416i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
                    AppMethodBeat.m2505o(46297);
                    return true;
                } else if (c14225t.tun == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.trA.getText());
                    bundle.putBoolean("key_is_reset_with_new_card", true);
                    C24143a.m37116j(this, bundle);
                } else if (c14225t.tun.isError()) {
                    C4990ab.m7416i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
                    C30379h.m48467g(this, C25738R.string.f_1, C25738R.string.f9238tz);
                    AppMethodBeat.m2505o(46297);
                    return true;
                } else {
                    int i3;
                    str2 = "MicroMsg.WalletForgotPwdUI";
                    String str3 = "scene case 3 bankcards size %d";
                    Object[] objArr = new Object[1];
                    if (this.tlM == null) {
                        i3 = 0;
                    } else {
                        i3 = this.tlM.size();
                    }
                    objArr[0] = Integer.valueOf(i3);
                    C4990ab.m7417i(str2, str3, objArr);
                    if (this.tlM == null || this.tlM.size() == 0) {
                        cOC();
                        bundle.putString("bank_name", c14225t.tun.nuL);
                        bundle.putParcelable("elemt_query", c14225t.tun);
                        bundle.putString("key_card_id", this.trA.getText());
                        bundle.putBoolean("key_is_reset_with_new_card", true);
                        C24143a.m37116j(this, bundle);
                        AppMethodBeat.m2505o(46297);
                        return true;
                    }
                }
            } else if (c1207m instanceof C35475y) {
                String str4 = "MicroMsg.WalletForgotPwdUI";
                str2 = "scene case queryBound adapter is null ? %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(this.trz == null);
                C4990ab.m7417i(str4, str2, objArr2);
                if (this.trz != null) {
                    ArrayList arrayList = null;
                    if (C14241r.cPI() != null) {
                        arrayList = C14241r.cPI().cQB();
                    }
                    C40931c aE = C24143a.m37112aE(this);
                    if (aE != null) {
                        aE.dNE();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Bankcard bankcard = (Bankcard) it.next();
                            if (bankcard.field_bankcardTag == 1) {
                                arrayList2.add(bankcard);
                            } else if (bankcard.field_bankcardTag == 2) {
                                arrayList3.add(bankcard);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            this.tlM = arrayList2;
                        } else {
                            this.tlM = arrayList3;
                        }
                    }
                    str4 = "MicroMsg.WalletForgotPwdUI";
                    str2 = "scene case queryBound adapter update bankcardsize:  %d";
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf(this.tlM == null ? 0 : this.tlM.size());
                    C4990ab.m7417i(str4, str2, objArr3);
                    this.trz.items = this.tlM;
                    new C7306ak(Looper.getMainLooper()).post(new C142044());
                }
            }
        }
        AppMethodBeat.m2505o(46297);
        return false;
    }

    public final boolean bNf() {
        return true;
    }

    private boolean arW() {
        AppMethodBeat.m2504i(46298);
        if (this.gKd.getVisibility() == 0 || (this.trB.asa() && this.trA.asa())) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
            AppMethodBeat.m2505o(46298);
            return true;
        }
        this.gEZ.setEnabled(false);
        this.gEZ.setClickable(false);
        AppMethodBeat.m2505o(46298);
        return false;
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(46299);
        arW();
        AppMethodBeat.m2505o(46299);
    }

    public boolean cNR() {
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final boolean bwP() {
        AppMethodBeat.m2504i(46300);
        if (this.tlM == null || this.tlM.size() == 0) {
            C22586aj cRh = C14241r.cPE().cRh();
            if (C5046bo.isNullOrNil(cRh.field_find_passwd_url) && C5046bo.isNullOrNil(cRh.field_forget_passwd_url)) {
                AppMethodBeat.m2505o(46300);
                return false;
            }
            AppMethodBeat.m2505o(46300);
            return true;
        }
        AppMethodBeat.m2505o(46300);
        return false;
    }

    public final boolean bwQ() {
        AppMethodBeat.m2504i(46301);
        mo9439AM(bwP() ? 4 : 0);
        AppMethodBeat.m2505o(46301);
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(46302);
        super.onActivityResult(i, i, intent);
        if (i2 == -1 && 1 == i) {
            this.trA.set3DesValStr(intent.getStringExtra("key_bankcard_id"));
            ari();
        }
        AppMethodBeat.m2505o(46302);
    }

    private void cOC() {
        AppMethodBeat.m2504i(46295);
        this.mBundle.remove("elemt_query");
        this.mBundle.remove("key_bankcard");
        this.mBundle.remove("bank_name");
        this.mBundle.remove("key_card_id");
        AppMethodBeat.m2505o(46295);
    }

    /* renamed from: c */
    static /* synthetic */ void m22408c(WalletForgotPwdUI walletForgotPwdUI) {
        AppMethodBeat.m2504i(46304);
        if (!"1".equals(C14241r.cPE().cRh().field_reset_passwd_flag)) {
            C4990ab.m7416i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new");
            AppMethodBeat.m2505o(46304);
        } else if (C5046bo.isNullOrNil(C14241r.cPE().cRh().field_find_passwd_url)) {
            C4990ab.m7416i("MicroMsg.WalletForgotPwdUI", "hy: support bind new directly");
            ((ViewStub) walletForgotPwdUI.findViewById(2131828802)).inflate();
            ((WalletFormView) walletForgotPwdUI.findViewById(2131828796)).setOnClickListener(new C142066());
            AppMethodBeat.m2505o(46304);
        } else {
            CharSequence spannableString;
            C4990ab.m7416i("MicroMsg.WalletForgotPwdUI", "hy: support bind new h5");
            ((ViewStub) walletForgotPwdUI.findViewById(2131828803)).inflate();
            TextView textView = (TextView) walletForgotPwdUI.findViewById(2131828797);
            C46373j c46373j = new C46373j(walletForgotPwdUI);
            c46373j.tHw = new C142055();
            String string;
            if (C14241r.cPI().cQp()) {
                string = walletForgotPwdUI.getString(C25738R.string.fm3);
                spannableString = new SpannableString(string);
                spannableString.setSpan(c46373j, string.length() - 12, string.length(), 33);
            } else {
                string = walletForgotPwdUI.getString(C25738R.string.fm4);
                spannableString = new SpannableString(string);
                spannableString.setSpan(c46373j, 0, string.length(), 18);
            }
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            AppMethodBeat.m2505o(46304);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m22405a(WalletForgotPwdUI walletForgotPwdUI, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.m2504i(46305);
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putBoolean("key_is_reset_with_new_card", true);
        C40931c aE = C24143a.m37112aE(walletForgotPwdUI);
        if (aE != null) {
            aE.mo64562a((Activity) walletForgotPwdUI, WalletConfirmCardIDUI.class, bundle, 1);
        }
        AppMethodBeat.m2505o(46305);
    }
}
