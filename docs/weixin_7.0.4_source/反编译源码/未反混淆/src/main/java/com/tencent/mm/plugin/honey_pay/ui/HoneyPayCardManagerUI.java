package com.tencent.mm.plugin.honey_pay.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.honey_pay.a.i;
import com.tencent.mm.plugin.honey_pay.a.j;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ac;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.protocal.protobuf.atj;
import com.tencent.mm.protocal.protobuf.bdh;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.protocal.protobuf.bnl;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import com.tencent.mm.wallet_core.ui.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    private a nrJ;
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

    class b {
        TextView kvI;
        WalletTextView nrY;

        private b() {
        }

        /* synthetic */ b(HoneyPayCardManagerUI honeyPayCardManagerUI, byte b) {
            this();
        }
    }

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(HoneyPayCardManagerUI honeyPayCardManagerUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(41810);
            bir wT = wT(i);
            AppMethodBeat.o(41810);
            return wT;
        }

        public final int getCount() {
            AppMethodBeat.i(41806);
            int size = HoneyPayCardManagerUI.this.nrK.size();
            AppMethodBeat.o(41806);
            return size;
        }

        private bir wT(int i) {
            AppMethodBeat.i(41807);
            bir bir = (bir) HoneyPayCardManagerUI.this.nrK.get(i);
            AppMethodBeat.o(41807);
            return bir;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(41808);
            if (bo.isNullOrNil(wT(i).url)) {
                AppMethodBeat.o(41808);
                return false;
            }
            AppMethodBeat.o(41808);
            return true;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(41809);
            if (view == null) {
                view = LayoutInflater.from(HoneyPayCardManagerUI.this.mController.ylL).inflate(R.layout.a70, viewGroup, false);
                b bVar = new b(HoneyPayCardManagerUI.this, (byte) 0);
                bVar.kvI = (TextView) view.findViewById(R.id.cfk);
                bVar.nrY = (WalletTextView) view.findViewById(R.id.cfl);
                bVar.nrY.setPrefix(ae.dOd());
                view.setTag(bVar);
            }
            bir wT = wT(i);
            b bVar2 = (b) view.getTag();
            bVar2.kvI.setText(wT.qkq);
            bVar2.nrY.setText(c.iR(wT.wMc));
            AppMethodBeat.o(41809);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public HoneyPayCardManagerUI() {
        AppMethodBeat.i(41811);
        AppMethodBeat.o(41811);
    }

    static /* synthetic */ Bankcard OE(String str) {
        AppMethodBeat.i(41826);
        Bankcard OD = OD(str);
        AppMethodBeat.o(41826);
        return OD;
    }

    static /* synthetic */ void d(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(41827);
        honeyPayCardManagerUI.bGd();
        AppMethodBeat.o(41827);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41812);
        super.onCreate(bundle);
        nf(2876);
        nf(2742);
        nf(2941);
        this.nra = getIntent().getStringExtra("key_card_no");
        this.gOW = getIntent().getIntExtra("key_scene", 0);
        this.nrQ = getIntent().getBooleanExtra("key_is_create", false);
        this.nrR = getIntent().getStringExtra("key_card_type");
        initView();
        ab.d(this.TAG, "cardtype: %s", this.nrR);
        setMMTitle((int) R.string.ccl);
        if (this.gOW == 1) {
            bnl bnl = new bnl();
            try {
                bnl.parseFrom(getIntent().getByteArrayExtra("key_qry_response"));
                a(bnl);
                AppMethodBeat.o(41812);
                return;
            } catch (IOException e) {
                ab.printErrStackTrace(this.TAG, e, "", new Object[0]);
                bGc();
                AppMethodBeat.o(41812);
                return;
            }
        }
        bGc();
        AppMethodBeat.o(41812);
    }

    public final void initView() {
        AppMethodBeat.i(41813);
        initHeaderView();
        bGb();
        this.nrH = findViewById(R.id.cfo);
        this.nrx = (ListView) findViewById(R.id.cfn);
        this.nrx.addHeaderView(this.laj);
        this.nrx.addFooterView(this.kox, null, false);
        this.nrJ = new a(this, (byte) 0);
        this.nrx.setAdapter(this.nrJ);
        this.nrx.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(41793);
                bir bir = (bir) adapterView.getAdapter().getItem(i);
                if (!(bir == null || bo.isNullOrNil(bir.url))) {
                    ab.i(HoneyPayCardManagerUI.this.TAG, "click item: %s, %s", Integer.valueOf(i), Long.valueOf(bir.wMc));
                    e.n(HoneyPayCardManagerUI.this.mController.ylL, bir.url, false);
                    h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
                }
                AppMethodBeat.o(41793);
            }
        });
        AppMethodBeat.o(41813);
    }

    public void onDestroy() {
        AppMethodBeat.i(41814);
        super.onDestroy();
        ng(2876);
        ng(2742);
        ng(2941);
        AppMethodBeat.o(41814);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(41815);
        if (mVar instanceof l) {
            final l lVar = (l) mVar;
            lVar.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41801);
                    HoneyPayCardManagerUI.a(HoneyPayCardManagerUI.this, lVar.nqJ);
                    AppMethodBeat.o(41801);
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            });
        } else if (mVar instanceof i) {
            final i iVar = (i) mVar;
            iVar.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    boolean z = true;
                    AppMethodBeat.i(41803);
                    MMSwitchBtn a = HoneyPayCardManagerUI.this.nrB;
                    if (iVar.bJt == 1) {
                        z = false;
                    }
                    a.setCheck(z);
                    AppMethodBeat.o(41803);
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    boolean z = true;
                    AppMethodBeat.i(41802);
                    MMSwitchBtn a = HoneyPayCardManagerUI.this.nrB;
                    if (iVar.bJt == 1) {
                        z = false;
                    }
                    a.setCheck(z);
                    AppMethodBeat.o(41802);
                }
            });
        } else if (mVar instanceof j) {
            final j jVar = (j) mVar;
            jVar.a(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41794);
                    HoneyPayCardManagerUI.this.nrM = jVar.nqH.wHj;
                    if (HoneyPayCardManagerUI.this.nrM != null) {
                        HoneyPayCardManagerUI.this.nrL = HoneyPayCardManagerUI.OE(HoneyPayCardManagerUI.this.nrM.wNk);
                    }
                    HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
                    AppMethodBeat.o(41794);
                }
            }).b(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41805);
                    HoneyPayCardManagerUI.this.nrM = HoneyPayCardManagerUI.this.nrN;
                    if (HoneyPayCardManagerUI.this.nrM != null) {
                        HoneyPayCardManagerUI.this.nrL = HoneyPayCardManagerUI.OE(HoneyPayCardManagerUI.this.nrM.wNk);
                    }
                    HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
                    AppMethodBeat.o(41805);
                }
            }).c(new com.tencent.mm.wallet_core.c.p.a() {
                public final void e(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(41804);
                    HoneyPayCardManagerUI.this.nrM = HoneyPayCardManagerUI.this.nrN;
                    if (HoneyPayCardManagerUI.this.nrM != null) {
                        HoneyPayCardManagerUI.this.nrL = HoneyPayCardManagerUI.OE(HoneyPayCardManagerUI.this.nrM.wNk);
                    }
                    HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
                    AppMethodBeat.o(41804);
                }
            });
        }
        AppMethodBeat.o(41815);
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(41816);
        if (i == 1) {
            if (i2 == -1 && intent.getBooleanExtra("key_modify_create_line_succ", false)) {
                this.nru.setText(c.iR(intent.getLongExtra("key_credit_line", 0)));
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
        AppMethodBeat.o(41816);
    }

    public final int getLayoutId() {
        return R.layout.a71;
    }

    private void initHeaderView() {
        AppMethodBeat.i(41817);
        this.laj = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.a6z, null);
        this.nrB = (MMSwitchBtn) this.laj.findViewById(R.id.cff);
        this.nrC = (LinearLayout) this.laj.findViewById(R.id.cfg);
        this.nrE = (TextView) this.laj.findViewById(R.id.cfh);
        this.kEn = (ImageView) this.laj.findViewById(R.id.cf2);
        this.nru = (WalletTextView) this.laj.findViewById(R.id.cf4);
        this.nrD = (TextView) this.laj.findViewById(R.id.cf3);
        this.nrA = (TextView) this.laj.findViewById(R.id.cf7);
        this.nre = (TextView) this.laj.findViewById(R.id.cf5);
        this.nrF = (TextView) this.laj.findViewById(R.id.cf6);
        this.nrg = (TextView) this.laj.findViewById(R.id.cf_);
        this.nri = (TextView) this.laj.findViewById(R.id.cfa);
        this.nrh = (TextView) this.laj.findViewById(R.id.cfc);
        this.nrj = (TextView) this.laj.findViewById(R.id.cfd);
        this.nrG = this.laj.findViewById(R.id.cfj);
        this.nrI = (TextView) this.laj.findViewById(R.id.cfi);
        this.nru.setPrefix(ae.dOd());
        this.nrB.setSwitchListener(new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void di(boolean z) {
                int i = 1;
                AppMethodBeat.i(41795);
                ab.d(HoneyPayCardManagerUI.this.TAG, "check %s", Boolean.valueOf(z));
                HoneyPayCardManagerUI honeyPayCardManagerUI = HoneyPayCardManagerUI.this;
                if (!z) {
                    i = 0;
                }
                HoneyPayCardManagerUI.a(honeyPayCardManagerUI, i);
                AppMethodBeat.o(41795);
            }
        });
        this.nrC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41796);
                if (HoneyPayCardManagerUI.this.nrM != null) {
                    ab.d(HoneyPayCardManagerUI.this.TAG, "click pay way: %s", Boolean.valueOf(HoneyPayCardManagerUI.this.nrM.wNm));
                    if (HoneyPayCardManagerUI.this.nrM.wNm) {
                        HoneyPayCardManagerUI.e(HoneyPayCardManagerUI.this);
                        AppMethodBeat.o(41796);
                        return;
                    }
                    HoneyPayCardManagerUI.f(HoneyPayCardManagerUI.this);
                }
                AppMethodBeat.o(41796);
            }
        });
        String string = getString(R.string.ccq);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.append(getString(R.string.ccs));
        spannableStringBuilder.setSpan(new o(new com.tencent.mm.plugin.wallet_core.ui.o.a() {
            public final void df(View view) {
                AppMethodBeat.i(41797);
                HoneyPayCardManagerUI.g(HoneyPayCardManagerUI.this);
                AppMethodBeat.o(41797);
            }
        }), string.length(), spannableStringBuilder.length(), 18);
        this.nrA.setClickable(true);
        this.nrA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this));
        this.nrA.setText(spannableStringBuilder);
        AppMethodBeat.o(41817);
    }

    private void bGb() {
        AppMethodBeat.i(41818);
        this.kox = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.a6x, null);
        AppMethodBeat.o(41818);
    }

    private void bGc() {
        AppMethodBeat.i(41819);
        ab.i(this.TAG, "do qry detail");
        m lVar = new l(this.nra);
        lVar.o(this);
        a(lVar, true, false);
        AppMethodBeat.o(41819);
    }

    private void a(bnl bnl) {
        AppMethodBeat.i(41820);
        this.nrb = bnl.woi;
        this.nrK.clear();
        this.nrJ.notifyDataSetChanged();
        if (bnl.wci != null) {
            setMMTitle(bnl.wci.kdf);
            this.nrO = bnl.vYj;
            this.nrP = bnl.vYi;
            if (bnl.wci.wxt != null) {
                this.nrL = OD(bnl.wci.wxt.wNk);
                this.nrM = bnl.wci.wxt;
            }
            a(bnl.wci);
            int i = bnl.wci.state;
            ab.i(this.TAG, "detail state: %s", Integer.valueOf(i));
            ab.d(this.TAG, "state title: %s", bnl.wci.wxw);
            if (bo.isNullOrNil(bnl.wci.wxw)) {
                this.nre.setVisibility(8);
            } else {
                this.nre.setText(bnl.wci.wxw);
                this.nre.setVisibility(0);
            }
            if (bo.isNullOrNil(bnl.wci.wxs)) {
                this.nrF.setVisibility(8);
            } else {
                this.nrF.setText(bnl.wci.wxs);
                this.nrF.setVisibility(0);
            }
            if (i == 1) {
                this.nre.setTextColor(Color.parseColor("#FA9D3B"));
                this.nru.setTextColor(Color.parseColor("#B2B2B2"));
                findViewById(R.id.cf8).setVisibility(8);
                this.nrx.removeFooterView(this.kox);
                this.kox.setVisibility(8);
                this.nrG.setVisibility(8);
                if (this.nrQ) {
                    this.nrz = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.a6w, null);
                    ((Button) this.nrz.findViewById(R.id.cf0)).setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(41799);
                            HoneyPayCardManagerUI.this.finish();
                            AppMethodBeat.o(41799);
                        }
                    });
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
                        a(bnl.wQl);
                        this.nrx.addFooterView(this.nry);
                    }
                    findViewById(R.id.cfm).setBackgroundResource(R.color.s2);
                }
                this.nrA.setVisibility(0);
                this.nru.setVisibility(0);
                this.nrG.setVisibility(0);
                findViewById(R.id.cf8).setVisibility(8);
            } else if (i == 3) {
                findViewById(R.id.cf8).setVisibility(0);
                this.nrg.setText(R.string.cc_);
                this.nrh.setText(R.string.cd4);
                this.nri.setText(c.iS((long) bnl.wci.vNm));
                this.nrj.setText(c.iS((long) bnl.wci.kbK));
                this.nrx.removeFooterView(this.kox);
                this.kox.setVisibility(8);
                this.nrG.setVisibility(8);
                findViewById(R.id.cfe).setVisibility(8);
            } else if (i == 4) {
                this.nrA.setVisibility(8);
                findViewById(R.id.cf8).setVisibility(0);
                this.nrg.setText(R.string.cd3);
                this.nri.setText(c.iS((long) bnl.wci.wxu));
                findViewById(R.id.cfb).setVisibility(8);
                this.nrx.removeFooterView(this.kox);
                this.kox.setVisibility(8);
                this.nrG.setVisibility(8);
                findViewById(R.id.cfe).setVisibility(8);
                findViewById(R.id.cfm).setBackgroundResource(R.color.a69);
            } else {
                ab.d(this.TAG, "unknown state: %s", Integer.valueOf(i));
            }
        }
        this.nrH.setVisibility(8);
        c.b(this, bnl.wxm, this.nra, 2, this.nrb);
        AppMethodBeat.o(41820);
    }

    private void a(final bdh bdh) {
        AppMethodBeat.i(41821);
        this.nry = (ViewGroup) View.inflate(this, R.layout.a6y, null);
        ((TextView) this.nry.findViewById(R.id.cf1)).setText(bdh.title);
        this.nry.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41800);
                e.n(HoneyPayCardManagerUI.this.mController.ylL, bdh.url, false);
                AppMethodBeat.o(41800);
            }
        });
        AppMethodBeat.o(41821);
    }

    private static Bankcard OD(String str) {
        AppMethodBeat.i(41822);
        Bankcard h = r.cPI().h(str, false, false);
        if (h == null) {
            Bankcard bankcard = r.cPI().tCZ;
            if (bankcard != null && bankcard.field_bindSerial.equals(str)) {
                AppMethodBeat.o(41822);
                return bankcard;
            }
        }
        AppMethodBeat.o(41822);
        return h;
    }

    private void a(atj atj) {
        boolean z = false;
        AppMethodBeat.i(41823);
        this.nrD.setText(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, e.eL(atj.vYh, 6) + getString(R.string.ccq), this.nrD.getTextSize()));
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kEn, atj.vYh, 0.06f, false);
        this.nru.setText(c.iR(atj.wch));
        MMSwitchBtn mMSwitchBtn = this.nrB;
        if (atj.tob != 0) {
            z = true;
        }
        mMSwitchBtn.setCheck(z);
        bGd();
        AppMethodBeat.o(41823);
    }

    private void bGd() {
        AppMethodBeat.i(41824);
        if (this.nrM != null) {
            this.nrE.setText(this.nrM.wNi);
            if (bo.isNullOrNil(this.nrM.wNj)) {
                this.nrE.setTextColor(getResources().getColor(R.color.w4));
            } else {
                this.nrE.setTextColor(Color.parseColor(this.nrM.wNj));
            }
            if (bo.isNullOrNil(this.nrM.wNn)) {
                this.nrI.setVisibility(8);
                AppMethodBeat.o(41824);
                return;
            }
            this.nrI.setText(this.nrM.wNn);
            this.nrI.setVisibility(0);
            AppMethodBeat.o(41824);
            return;
        }
        ab.i(this.TAG, "reset payway view for null");
        this.nrE.setText("");
        this.nrE.setTextColor(getResources().getColor(R.color.w4));
        this.nrI.setVisibility(8);
        AppMethodBeat.o(41824);
    }

    static /* synthetic */ void e(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(41829);
        ab.i(honeyPayCardManagerUI.TAG, "go to uni pay ui");
        d.b((Context) honeyPayCardManagerUI, "wallet", ".pwd.ui.WalletUniversalPayOrderUI", new Intent(), 3);
        AppMethodBeat.o(41829);
    }

    static /* synthetic */ void f(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(41830);
        ab.i(honeyPayCardManagerUI.TAG, "show select payway dialog");
        ArrayList<Bankcard> ne = ac.ne(false);
        final ArrayList arrayList = new ArrayList();
        for (Bankcard bankcard : ne) {
            if (bankcard.cPg()) {
                ab.i(honeyPayCardManagerUI.TAG, "remove honey card %s", bankcard.field_bindSerial);
            } else {
                arrayList.add(bankcard);
            }
        }
        Context context = honeyPayCardManagerUI;
        com.tencent.mm.plugin.wallet_core.ui.h.a(context, arrayList, honeyPayCardManagerUI.nrL, honeyPayCardManagerUI.getString(R.string.cco), honeyPayCardManagerUI.getString(R.string.ccn), false, "", new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(41798);
                HoneyPayCardManagerUI.this.nrL = (Bankcard) arrayList.get(i);
                ab.i(HoneyPayCardManagerUI.this.TAG, "select bankcard: %s, %s", HoneyPayCardManagerUI.this.nrL.field_bindSerial, HoneyPayCardManagerUI.this.nrL.field_bankcardTypeName);
                HoneyPayCardManagerUI.this.nrN = HoneyPayCardManagerUI.this.nrM;
                bkc bkc = new bkc();
                bkc.wNi = HoneyPayCardManagerUI.this.nrL.field_desc;
                bkc.pbn = HoneyPayCardManagerUI.this.nrL.field_bankcardType;
                bkc.wNk = HoneyPayCardManagerUI.this.nrL.field_bindSerial;
                bkc.wNl = HoneyPayCardManagerUI.this.nrL.field_bankcardTail;
                HoneyPayCardManagerUI.this.nrM = bkc;
                HoneyPayCardManagerUI.d(HoneyPayCardManagerUI.this);
                HoneyPayCardManagerUI.i(HoneyPayCardManagerUI.this);
                AppMethodBeat.o(41798);
            }
        });
        h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.o(41830);
    }

    static /* synthetic */ void g(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(41831);
        ab.i(honeyPayCardManagerUI.TAG, "go to quata ui");
        Intent intent = new Intent(honeyPayCardManagerUI, HoneyPayModifyQuotaUI.class);
        intent.putExtra("key_max_credit_line", honeyPayCardManagerUI.nrO);
        intent.putExtra("key_min_credit_line", honeyPayCardManagerUI.nrP);
        intent.putExtra("key_card_no", honeyPayCardManagerUI.nra);
        honeyPayCardManagerUI.startActivityForResult(intent, 1);
        h.pYm.e(15191, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
        AppMethodBeat.o(41831);
    }

    static /* synthetic */ void i(HoneyPayCardManagerUI honeyPayCardManagerUI) {
        AppMethodBeat.i(41832);
        ab.i(honeyPayCardManagerUI.TAG, "do modify pay way");
        m jVar = new j(honeyPayCardManagerUI.nrM, honeyPayCardManagerUI.nra);
        jVar.o(honeyPayCardManagerUI);
        honeyPayCardManagerUI.a(jVar, false, false);
        AppMethodBeat.o(41832);
    }
}
