package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn;
import com.tencent.p177mm.p612ui.widget.MMSwitchBtn.C30795a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.honey_pay.model.C28289c;
import com.tencent.p177mm.plugin.honey_pay.p434a.C12221l;
import com.tencent.p177mm.plugin.honey_pay.p434a.C44746i;
import com.tencent.p177mm.plugin.honey_pay.p434a.C46022j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C14241r;
import com.tencent.p177mm.plugin.wallet_core.model.C22584ac;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C40127h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.atj;
import com.tencent.p177mm.protocal.protobuf.bdh;
import com.tencent.p177mm.protocal.protobuf.bir;
import com.tencent.p177mm.protocal.protobuf.bkc;
import com.tencent.p177mm.protocal.protobuf.bnl;
import com.tencent.p177mm.protocal.protobuf.chl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletTextView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI */
public class HoneyPayCardManagerUI extends HoneyPayBaseUI {
    private int gOW;
    private ImageView kEn;
    private ViewGroup kox;
    private ViewGroup laj;
    private TextView nrA;
    private MMSwitchBtn nrB;
    private LinearLayout nrC;
    private TextView nrD;
    private TextView nrE;
    private TextView nrF;
    private View nrG;
    private View nrH;
    private TextView nrI;
    private C28298a nrJ;
    private List<bir> nrK = new ArrayList();
    private Bankcard nrL;
    private bkc nrM;
    private bkc nrN;
    private long nrO;
    private long nrP;
    private boolean nrQ;
    private String nrR;
    private String nra;
    private chl nrb;
    private TextView nre;
    private TextView nrg;
    private TextView nrh;
    private TextView nri;
    private TextView nrj;
    private WalletTextView nru;
    private ListView nrx;
    private ViewGroup nry;
    private ViewGroup nrz;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$1 */
    class C32891 implements OnItemClickListener {
        C32891() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(41793);
            bir bir = (bir) adapterView.getAdapter().getItem(i);
            if (!(bir == null || C5046bo.isNullOrNil(bir.url))) {
                C4990ab.m7417i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", Integer.valueOf(i), Long.valueOf(bir.wMc));
                C36391e.m60016n(HoneyPayCardManagerUI.this.mController.ylL, bir.url, false);
                C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
            }
            AppMethodBeat.m2505o(41793);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$7 */
    class C122297 implements OnClickListener {
        C122297() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41799);
            HoneyPayCardManagerUI.this.finish();
            AppMethodBeat.m2505o(41799);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$14 */
    class C2105614 implements C40929a {
        C2105614() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$15 */
    class C2105715 implements C40929a {
        C2105715() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41804);
            HoneyPayCardManagerUI.this.nrM = HoneyPayCardManagerUI.this.nrN;
            if (HoneyPayCardManagerUI.this.nrM != null) {
                HoneyPayCardManagerUI.this.nrL = HoneyPayCardManagerUI.m56284OE(HoneyPayCardManagerUI.this.nrM.wNk);
            }
            HoneyPayCardManagerUI.m56296d(HoneyPayCardManagerUI.this);
            AppMethodBeat.m2505o(41804);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$9 */
    class C210589 implements C40929a {
        C210589() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$b */
    class C21059b {
        TextView kvI;
        WalletTextView nrY;

        private C21059b() {
        }

        /* synthetic */ C21059b(HoneyPayCardManagerUI honeyPayCardManagerUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$a */
    class C28298a extends BaseAdapter {
        private C28298a() {
        }

        /* synthetic */ C28298a(HoneyPayCardManagerUI honeyPayCardManagerUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(41810);
            bir wT = m44896wT(i);
            AppMethodBeat.m2505o(41810);
            return wT;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(41806);
            int size = HoneyPayCardManagerUI.this.nrK.size();
            AppMethodBeat.m2505o(41806);
            return size;
        }

        /* renamed from: wT */
        private bir m44896wT(int i) {
            AppMethodBeat.m2504i(41807);
            bir bir = (bir) HoneyPayCardManagerUI.this.nrK.get(i);
            AppMethodBeat.m2505o(41807);
            return bir;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(41808);
            if (C5046bo.isNullOrNil(m44896wT(i).url)) {
                AppMethodBeat.m2505o(41808);
                return false;
            }
            AppMethodBeat.m2505o(41808);
            return true;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(41809);
            if (view == null) {
                view = LayoutInflater.from(HoneyPayCardManagerUI.this.mController.ylL).inflate(2130969827, viewGroup, false);
                C21059b c21059b = new C21059b(HoneyPayCardManagerUI.this, (byte) 0);
                c21059b.kvI = (TextView) view.findViewById(2131824894);
                c21059b.nrY = (WalletTextView) view.findViewById(2131824895);
                c21059b.nrY.setPrefix(C44423ae.dOd());
                view.setTag(c21059b);
            }
            bir wT = m44896wT(i);
            C21059b c21059b2 = (C21059b) view.getTag();
            c21059b2.kvI.setText(wT.qkq);
            c21059b2.nrY.setText(C28289c.m44887iR(wT.wMc));
            AppMethodBeat.m2505o(41809);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$3 */
    class C343353 implements C30795a {
        C343353() {
        }

        /* renamed from: di */
        public final void mo6646di(boolean z) {
            int i = 1;
            AppMethodBeat.m2504i(41795);
            C4990ab.m7411d(HoneyPayCardManagerUI.this.TAG, "check %s", Boolean.valueOf(z));
            HoneyPayCardManagerUI honeyPayCardManagerUI = HoneyPayCardManagerUI.this;
            if (!z) {
                i = 0;
            }
            HoneyPayCardManagerUI.m56288a(honeyPayCardManagerUI, i);
            AppMethodBeat.m2505o(41795);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$5 */
    class C343365 implements C35502a {
        C343365() {
        }

        /* renamed from: df */
        public final void mo9537df(View view) {
            AppMethodBeat.m2504i(41797);
            HoneyPayCardManagerUI.m56299g(HoneyPayCardManagerUI.this);
            AppMethodBeat.m2505o(41797);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$16 */
    class C3433716 implements C40929a {
        C3433716() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(41805);
            HoneyPayCardManagerUI.this.nrM = HoneyPayCardManagerUI.this.nrN;
            if (HoneyPayCardManagerUI.this.nrM != null) {
                HoneyPayCardManagerUI.this.nrL = HoneyPayCardManagerUI.m56284OE(HoneyPayCardManagerUI.this.nrM.wNk);
            }
            HoneyPayCardManagerUI.m56296d(HoneyPayCardManagerUI.this);
            AppMethodBeat.m2505o(41805);
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$10 */
    class C3433910 implements C40929a {
        C3433910() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayCardManagerUI$4 */
    class C343414 implements OnClickListener {
        C343414() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(41796);
            if (HoneyPayCardManagerUI.this.nrM != null) {
                C4990ab.m7411d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", Boolean.valueOf(HoneyPayCardManagerUI.this.nrM.wNm));
                if (HoneyPayCardManagerUI.this.nrM.wNm) {
                    HoneyPayCardManagerUI.m56297e(HoneyPayCardManagerUI.this);
                    AppMethodBeat.m2505o(41796);
                    return;
                }
                HoneyPayCardManagerUI.m56298f(HoneyPayCardManagerUI.this);
            }
            AppMethodBeat.m2505o(41796);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public HoneyPayCardManagerUI() {
        AppMethodBeat.m2504i(41811);
        AppMethodBeat.m2505o(41811);
    }

    /* renamed from: OE */
    static /* synthetic */ Bankcard m56284OE(String str) {
        AppMethodBeat.m2504i(41826);
        Bankcard OD = HoneyPayCardManagerUI.m56283OD(str);
        AppMethodBeat.m2505o(41826);
        return OD;
    }

    /* renamed from: d */
    static /* synthetic */ void m56296d(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.m2504i(41827);
        honeyPayCardManagerUI.bGd();
        AppMethodBeat.m2505o(41827);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(41812);
        super.onCreate(bundle);
        mo39992nf(2876);
        mo39992nf(2742);
        mo39992nf(2941);
        this.nra = getIntent().getStringExtra("key_card_no");
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        this.nrQ = getIntent().getBooleanExtra("key_is_create", false);
        this.nrR = getIntent().getStringExtra("key_card_type");
        initView();
        C4990ab.m7411d(this.TAG, "cardtype: %s", this.nrR);
        setMMTitle((int) C25738R.string.ccl);
        if (this.gOW == 1) {
            bnl bnl = new bnl();
            try {
                bnl.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
                m56292a(bnl);
                AppMethodBeat.m2505o(41812);
                return;
            } catch (IOException e) {
                C4990ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                bGc();
                AppMethodBeat.m2505o(41812);
                return;
            }
        }
        bGc();
        AppMethodBeat.m2505o(41812);
    }

    public final void initView() {
        AppMethodBeat.m2504i(41813);
        initHeaderView();
        bGb();
        this.nrH = findViewById(2131824898);
        this.nrx = (ListView) findViewById(2131824897);
        this.nrx.addHeaderView(this.laj);
        this.nrx.addFooterView(this.kox, null, false);
        this.nrJ = new C28298a(this, (byte) 0);
        this.nrx.setAdapter(this.nrJ);
        this.nrx.setOnItemClickListener(new C32891());
        AppMethodBeat.m2505o(41813);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(41814);
        super.onDestroy();
        mo39993ng(2876);
        mo39993ng(2742);
        mo39993ng(2941);
        AppMethodBeat.m2505o(41814);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(41815);
        if (c1207m instanceof C12221l) {
            final C12221l c12221l = (C12221l) c1207m;
            c12221l.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41801);
                    HoneyPayCardManagerUI.m56289a(HoneyPayCardManagerUI.this, c12221l.nqJ);
                    AppMethodBeat.m2505o(41801);
                }
            }).mo70319b(new C3433910()).mo70320c(new C210589());
        } else if (c1207m instanceof C44746i) {
            final C44746i c44746i = (C44746i) c1207m;
            c44746i.mo70318a(new C2105614()).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    boolean z = true;
                    AppMethodBeat.m2504i(41803);
                    MMSwitchBtn a = HoneyPayCardManagerUI.this.nrB;
                    if (c44746i.bJt == 1) {
                        z = false;
                    }
                    a.setCheck(z);
                    AppMethodBeat.m2505o(41803);
                }
            }).mo70320c(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    boolean z = true;
                    AppMethodBeat.m2504i(41802);
                    MMSwitchBtn a = HoneyPayCardManagerUI.this.nrB;
                    if (c44746i.bJt == 1) {
                        z = false;
                    }
                    a.setCheck(z);
                    AppMethodBeat.m2505o(41802);
                }
            });
        } else if (c1207m instanceof C46022j) {
            final C46022j c46022j = (C46022j) c1207m;
            c46022j.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(41794);
                    HoneyPayCardManagerUI.this.nrM = c46022j.nqH.wHj;
                    if (HoneyPayCardManagerUI.this.nrM != null) {
                        HoneyPayCardManagerUI.this.nrL = HoneyPayCardManagerUI.m56284OE(HoneyPayCardManagerUI.this.nrM.wNk);
                    }
                    HoneyPayCardManagerUI.m56296d(HoneyPayCardManagerUI.this);
                    AppMethodBeat.m2505o(41794);
                }
            }).mo70319b(new C3433716()).mo70320c(new C2105715());
        }
        AppMethodBeat.m2505o(41815);
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(41816);
        if (i == 1) {
            if (i2 == -1 && intent.getBooleanExtra("key_modify_create_line_succ", false)) {
                this.nru.setText(C28289c.m44887iR(intent.getLongExtra("key_credit_line", 0)));
                setResult(-1);
            }
        } else if (i == 2) {
            if (i2 == -1) {
                this.mController.removeAllOptionMenu();
                setResult(-1);
                finish();
            }
        } else if (i == 3 && i2 == -1) {
            bGc();
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(41816);
    }

    public final int getLayoutId() {
        return 2130969828;
    }

    private void initHeaderView() {
        AppMethodBeat.m2504i(41817);
        this.laj = (ViewGroup) LayoutInflater.from(this).inflate(2130969826, null);
        this.nrB = (MMSwitchBtn) this.laj.findViewById(2131824889);
        this.nrC = (LinearLayout) this.laj.findViewById(2131824890);
        this.nrE = (TextView) this.laj.findViewById(2131824891);
        this.kEn = (ImageView) this.laj.findViewById(2131824875);
        this.nru = (WalletTextView) this.laj.findViewById(2131824877);
        this.nrD = (TextView) this.laj.findViewById(2131824876);
        this.nrA = (TextView) this.laj.findViewById(2131824880);
        this.nre = (TextView) this.laj.findViewById(2131824878);
        this.nrF = (TextView) this.laj.findViewById(2131824879);
        this.nrg = (TextView) this.laj.findViewById(2131824883);
        this.nri = (TextView) this.laj.findViewById(2131824884);
        this.nrh = (TextView) this.laj.findViewById(2131824886);
        this.nrj = (TextView) this.laj.findViewById(2131824887);
        this.nrG = this.laj.findViewById(2131824893);
        this.nrI = (TextView) this.laj.findViewById(2131824892);
        this.nru.setPrefix(C44423ae.dOd());
        this.nrB.setSwitchListener(new C343353());
        this.nrC.setOnClickListener(new C343414());
        String string = getString(C25738R.string.ccq);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.append(getString(C25738R.string.ccs));
        spannableStringBuilder.setSpan(new C35503o(new C343365()), string.length(), spannableStringBuilder.length(), 18);
        this.nrA.setClickable(true);
        this.nrA.setOnTouchListener(new C30132m(this));
        this.nrA.setText(spannableStringBuilder);
        AppMethodBeat.m2505o(41817);
    }

    private void bGb() {
        AppMethodBeat.m2504i(41818);
        this.kox = (ViewGroup) LayoutInflater.from(this).inflate(2130969824, null);
        AppMethodBeat.m2505o(41818);
    }

    private void bGc() {
        AppMethodBeat.m2504i(41819);
        C4990ab.m7416i(this.TAG, "do qry detail");
        C1207m c12221l = new C12221l(this.nra);
        c12221l.mo70321o(this);
        mo39970a(c12221l, true, false);
        AppMethodBeat.m2505o(41819);
    }

    /* renamed from: a */
    private void m56292a(bnl bnl) {
        AppMethodBeat.m2504i(41820);
        this.nrb = bnl.woi;
        this.nrK.clear();
        this.nrJ.notifyDataSetChanged();
        if (bnl.wci != null) {
            setMMTitle(bnl.wci.kdf);
            this.nrO = bnl.vYj;
            this.nrP = bnl.vYi;
            if (bnl.wci.wxt != null) {
                this.nrL = HoneyPayCardManagerUI.m56283OD(bnl.wci.wxt.wNk);
                this.nrM = bnl.wci.wxt;
            }
            m56290a(bnl.wci);
            int i = bnl.wci.state;
            C4990ab.m7417i(this.TAG, "detail state: %s", Integer.valueOf(i));
            C4990ab.m7411d(this.TAG, "state title: %s", bnl.wci.wxw);
            if (C5046bo.isNullOrNil(bnl.wci.wxw)) {
                this.nre.setVisibility(8);
            } else {
                this.nre.setText(bnl.wci.wxw);
                this.nre.setVisibility(0);
            }
            if (C5046bo.isNullOrNil(bnl.wci.wxs)) {
                this.nrF.setVisibility(8);
            } else {
                this.nrF.setText(bnl.wci.wxs);
                this.nrF.setVisibility(0);
            }
            if (i == 1) {
                this.nre.setTextColor(Color.parseColor("#FA9D3B"));
                this.nru.setTextColor(Color.parseColor("#B2B2B2"));
                findViewById(2131824881).setVisibility(8);
                this.nrx.removeFooterView(this.kox);
                this.kox.setVisibility(8);
                this.nrG.setVisibility(8);
                if (this.nrQ) {
                    this.nrz = (ViewGroup) LayoutInflater.from(this).inflate(2130969823, null);
                    ((Button) this.nrz.findViewById(2131824873)).setOnClickListener(new C122297());
                    this.nrx.addFooterView(this.nrz);
                    showHomeBtn(false);
                    enableBackMenu(false);
                    setMMTitle("");
                }
            } else if (i == 2) {
                if (!(bnl.vAD == null || bnl.vAD.isEmpty())) {
                    this.nrK = bnl.vAD;
                    this.nrJ.notifyDataSetChanged();
                    this.nrx.removeFooterView(this.kox);
                    this.kox.setVisibility(8);
                    if (bnl.wQl != null) {
                        m56291a(bnl.wQl);
                        this.nrx.addFooterView(this.nry);
                    }
                    findViewById(2131824896).setBackgroundResource(C25738R.color.f12094s2);
                }
                this.nrA.setVisibility(0);
                this.nru.setVisibility(0);
                this.nrG.setVisibility(0);
                findViewById(2131824881).setVisibility(8);
            } else if (i == 3) {
                findViewById(2131824881).setVisibility(0);
                this.nrg.setText(C25738R.string.cc_);
                this.nrh.setText(C25738R.string.cd4);
                this.nri.setText(C28289c.m44888iS((long) bnl.wci.vNm));
                this.nrj.setText(C28289c.m44888iS((long) bnl.wci.kbK));
                this.nrx.removeFooterView(this.kox);
                this.kox.setVisibility(8);
                this.nrG.setVisibility(8);
                findViewById(2131824888).setVisibility(8);
            } else if (i == 4) {
                this.nrA.setVisibility(8);
                findViewById(2131824881).setVisibility(0);
                this.nrg.setText(C25738R.string.cd3);
                this.nri.setText(C28289c.m44888iS((long) bnl.wci.wxu));
                findViewById(2131824885).setVisibility(8);
                this.nrx.removeFooterView(this.kox);
                this.kox.setVisibility(8);
                this.nrG.setVisibility(8);
                findViewById(2131824888).setVisibility(8);
                findViewById(2131824896).setBackgroundResource(C25738R.color.a69);
            } else {
                C4990ab.m7411d(this.TAG, "unknown state: %s", Integer.valueOf(i));
            }
        }
        this.nrH.setVisibility(8);
        C28289c.m44885b(this, bnl.wxm, this.nra, 2, this.nrb);
        AppMethodBeat.m2505o(41820);
    }

    /* renamed from: a */
    private void m56291a(final bdh bdh) {
        AppMethodBeat.m2504i(41821);
        this.nry = (ViewGroup) View.inflate(this, 2130969825, null);
        ((TextView) this.nry.findViewById(2131824874)).setText(bdh.title);
        this.nry.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(41800);
                C36391e.m60016n(HoneyPayCardManagerUI.this.mController.ylL, bdh.url, false);
                AppMethodBeat.m2505o(41800);
            }
        });
        AppMethodBeat.m2505o(41821);
    }

    /* renamed from: OD */
    private static Bankcard m56283OD(String str) {
        AppMethodBeat.m2504i(41822);
        Bankcard h = C14241r.cPI().mo38170h(str, false, false);
        if (h == null) {
            Bankcard bankcard = C14241r.cPI().tCZ;
            if (bankcard != null && bankcard.field_bindSerial.equals(str)) {
                AppMethodBeat.m2505o(41822);
                return bankcard;
            }
        }
        AppMethodBeat.m2505o(41822);
        return h;
    }

    /* renamed from: a */
    private void m56290a(atj atj) {
        boolean z = false;
        AppMethodBeat.m2504i(41823);
        this.nrD.setText(C44089j.m79293b((Context) this, C36391e.m60008eL(atj.vYh, 6) + getString(C25738R.string.ccq), this.nrD.getTextSize()));
        C40460b.m69433a(this.kEn, atj.vYh, 0.06f, false);
        this.nru.setText(C28289c.m44887iR(atj.wch));
        MMSwitchBtn mMSwitchBtn = this.nrB;
        if (atj.tob != 0) {
            z = true;
        }
        mMSwitchBtn.setCheck(z);
        bGd();
        AppMethodBeat.m2505o(41823);
    }

    private void bGd() {
        AppMethodBeat.m2504i(41824);
        if (this.nrM != null) {
            this.nrE.setText(this.nrM.wNi);
            if (C5046bo.isNullOrNil(this.nrM.wNj)) {
                this.nrE.setTextColor(getResources().getColor(C25738R.color.f12212w4));
            } else {
                this.nrE.setTextColor(Color.parseColor(this.nrM.wNj));
            }
            if (C5046bo.isNullOrNil(this.nrM.wNn)) {
                this.nrI.setVisibility(8);
                AppMethodBeat.m2505o(41824);
                return;
            }
            this.nrI.setText(this.nrM.wNn);
            this.nrI.setVisibility(0);
            AppMethodBeat.m2505o(41824);
            return;
        }
        C4990ab.m7416i(this.TAG, "reset payway view for null");
        this.nrE.setText("");
        this.nrE.setTextColor(getResources().getColor(C25738R.color.f12212w4));
        this.nrI.setVisibility(8);
        AppMethodBeat.m2505o(41824);
    }

    /* renamed from: e */
    static /* synthetic */ void m56297e(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.m2504i(41829);
        C4990ab.m7416i(honeyPayCardManagerUI.TAG, "go to uni pay ui");
        C25985d.m41468b((Context) honeyPayCardManagerUI, "wallet", ".pwd.ui.WalletUniversalPayOrderUI", new Intent(), 3);
        AppMethodBeat.m2505o(41829);
    }

    /* renamed from: f */
    static /* synthetic */ void m56298f(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.m2504i(41830);
        C4990ab.m7416i(honeyPayCardManagerUI.TAG, "show select payway dialog");
        ArrayList<Bankcard> ne = C22584ac.m34277ne(false);
        final ArrayList arrayList = new ArrayList();
        for (Bankcard bankcard : ne) {
            if (bankcard.cPg()) {
                C4990ab.m7417i(honeyPayCardManagerUI.TAG, "remove honey card %s", bankcard.field_bindSerial);
            } else {
                arrayList.add(bankcard);
            }
        }
        Context context = honeyPayCardManagerUI;
        C40127h.m68793a(context, arrayList, honeyPayCardManagerUI.nrL, honeyPayCardManagerUI.getString(C25738R.string.cco), honeyPayCardManagerUI.getString(C25738R.string.ccn), false, "", new C5279d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(41798);
                HoneyPayCardManagerUI.this.nrL = (Bankcard) arrayList.get(i);
                C4990ab.m7417i(HoneyPayCardManagerUI.this.TAG, "select bankcard: %s, %s", HoneyPayCardManagerUI.this.nrL.field_bindSerial, HoneyPayCardManagerUI.this.nrL.field_bankcardTypeName);
                HoneyPayCardManagerUI.this.nrN = HoneyPayCardManagerUI.this.nrM;
                bkc bkc = new bkc();
                bkc.wNi = HoneyPayCardManagerUI.this.nrL.field_desc;
                bkc.pbn = HoneyPayCardManagerUI.this.nrL.field_bankcardType;
                bkc.wNk = HoneyPayCardManagerUI.this.nrL.field_bindSerial;
                bkc.wNl = HoneyPayCardManagerUI.this.nrL.field_bankcardTail;
                HoneyPayCardManagerUI.this.nrM = bkc;
                HoneyPayCardManagerUI.m56296d(HoneyPayCardManagerUI.this);
                HoneyPayCardManagerUI.m56301i(HoneyPayCardManagerUI.this);
                AppMethodBeat.m2505o(41798);
            }
        });
        C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.m2505o(41830);
    }

    /* renamed from: g */
    static /* synthetic */ void m56299g(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.m2504i(41831);
        C4990ab.m7416i(honeyPayCardManagerUI.TAG, "go to quata ui");
        Intent intent = new Intent(honeyPayCardManagerUI, HoneyPayModifyQuotaUI.class);
        intent.putExtra("key_max_credit_line", honeyPayCardManagerUI.nrO);
        intent.putExtra("key_min_credit_line", honeyPayCardManagerUI.nrP);
        intent.putExtra("key_card_no", honeyPayCardManagerUI.nra);
        honeyPayCardManagerUI.startActivityForResult(intent, 1);
        C7060h.pYm.mo8381e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.m2505o(41831);
    }

    /* renamed from: i */
    static /* synthetic */ void m56301i(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.m2504i(41832);
        C4990ab.m7416i(honeyPayCardManagerUI.TAG, "do modify pay way");
        C1207m c46022j = new C46022j(honeyPayCardManagerUI.nrM, honeyPayCardManagerUI.nra);
        c46022j.mo70321o(honeyPayCardManagerUI);
        honeyPayCardManagerUI.mo39970a(c46022j, false, false);
        AppMethodBeat.m2505o(41832);
    }
}
