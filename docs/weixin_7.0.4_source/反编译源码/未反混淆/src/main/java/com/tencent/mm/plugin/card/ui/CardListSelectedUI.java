package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.aj;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public class CardListSelectedUI extends MMActivity implements f, com.tencent.mm.plugin.card.b.j.a {
    private View Ek;
    private String app_id;
    LinkedList<com.tencent.mm.plugin.card.model.a> eAF = new LinkedList();
    boolean eTf = true;
    private p ejZ = null;
    private int emC = 0;
    private String kbU;
    com.tencent.mm.bt.b keu = null;
    private BaseAdapter khG;
    private boolean khr = false;
    private String kiA = "";
    private String kiB;
    private TextView kmh;
    private RelativeLayout kmi;
    private TextView kmj;
    private TextView kmk;
    boolean kml = false;
    HashMap<Integer, Boolean> kmm = new HashMap();
    private boolean kmn;
    private boolean kmo;
    private boolean kmp;
    private int kmq;
    private String kmr;
    private String kms;
    private String kmt;
    private String kmu;
    private int kmv;
    public String kmw;
    private boolean kmx = false;
    private com.tencent.mm.plugin.card.model.a kmy;
    private ListView mListView;
    private int time_stamp;

    class c {
        public TextView gsf;
        public ImageView kmA;
        public TextView kmB;
        public TextView kmC;
        public View kmD;
        public TextView kmE;
        public TextView kmF;

        c() {
        }
    }

    class d {
        public TextView gsf;
        public TextView jKK;
        public TextView kmC;
        public ImageView kmG;
        public TextView kmH;
        public View kmI;
        public ImageView kmJ;

        d() {
        }
    }

    class a extends BaseAdapter {
        a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(88564);
            com.tencent.mm.plugin.card.model.a te = te(i);
            AppMethodBeat.o(88564);
            return te;
        }

        public final int getCount() {
            AppMethodBeat.i(88561);
            int size = CardListSelectedUI.this.eAF.size();
            AppMethodBeat.o(88561);
            return size;
        }

        private com.tencent.mm.plugin.card.model.a te(int i) {
            AppMethodBeat.i(88562);
            com.tencent.mm.plugin.card.model.a aVar = (com.tencent.mm.plugin.card.model.a) CardListSelectedUI.this.eAF.get(i);
            AppMethodBeat.o(88562);
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            AppMethodBeat.i(88563);
            com.tencent.mm.plugin.card.model.a te = te(i);
            if (view == null) {
                view = View.inflate(CardListSelectedUI.this, R.layout.k1, null);
                dVar = new d();
                dVar.kmG = (ImageView) view.findViewById(R.id.ahm);
                dVar.gsf = (TextView) view.findViewById(R.id.cx);
                dVar.kmC = (TextView) view.findViewById(R.id.s9);
                dVar.kmH = (TextView) view.findViewById(R.id.aj8);
                dVar.jKK = (TextView) view.findViewById(R.id.a42);
                dVar.kmI = view.findViewById(R.id.rk);
                dVar.kmJ = (ImageView) view.findViewById(R.id.aj4);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            if (l.sP(te.iAd)) {
                int i2;
                dVar.gsf.setText(te.kbW);
                if (TextUtils.isEmpty(te.title)) {
                    dVar.kmC.setVisibility(8);
                } else {
                    dVar.kmC.setVisibility(0);
                    dVar.kmC.setText(te.title);
                }
                if (TextUtils.isEmpty(te.kbX)) {
                    dVar.kmH.setVisibility(8);
                } else {
                    dVar.kmH.setVisibility(0);
                    dVar.kmH.setText(te.kbX);
                }
                TextView textView = dVar.jKK;
                if (bo.isNullOrNil(te.jKR)) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                dVar.jKK.setText(te.jKR);
                CardListSelectedUI.a(dVar.kmG, te.kbV, CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(R.dimen.wd));
                Boolean bool = (Boolean) CardListSelectedUI.this.kmm.get(Integer.valueOf(i));
                if (bool == null || !bool.booleanValue()) {
                    dVar.kmJ.setImageResource(R.drawable.g_);
                } else {
                    dVar.kmJ.setImageResource(R.drawable.g9);
                }
            } else {
                ab.i("MicroMsg.CardListSelectedUI", "not support type");
            }
            AppMethodBeat.o(88563);
            return view;
        }
    }

    class b extends BaseAdapter {
        b() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(88568);
            com.tencent.mm.plugin.card.model.a te = te(i);
            AppMethodBeat.o(88568);
            return te;
        }

        public final int getCount() {
            AppMethodBeat.i(88565);
            int size = CardListSelectedUI.this.eAF.size();
            AppMethodBeat.o(88565);
            return size;
        }

        private com.tencent.mm.plugin.card.model.a te(int i) {
            AppMethodBeat.i(88566);
            com.tencent.mm.plugin.card.model.a aVar = (com.tencent.mm.plugin.card.model.a) CardListSelectedUI.this.eAF.get(i);
            AppMethodBeat.o(88566);
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(88567);
            com.tencent.mm.plugin.card.model.a te = te(i);
            if (view == null) {
                view = View.inflate(CardListSelectedUI.this, R.layout.k0, null);
                cVar = new c();
                cVar.kmA = (ImageView) view.findViewById(R.id.aj4);
                cVar.kmB = (TextView) view.findViewById(R.id.aj5);
                cVar.gsf = (TextView) view.findViewById(R.id.cx);
                cVar.kmC = (TextView) view.findViewById(R.id.s9);
                cVar.kmD = view.findViewById(R.id.ae2);
                cVar.kmE = (TextView) view.findViewById(R.id.aj6);
                cVar.kmF = (TextView) view.findViewById(R.id.aj7);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (l.sP(te.iAd)) {
                if (TextUtils.isEmpty(te.title)) {
                    cVar.gsf.setVisibility(8);
                } else {
                    cVar.gsf.setVisibility(0);
                    cVar.gsf.setText(te.title);
                }
                if (TextUtils.isEmpty(te.kbW)) {
                    cVar.kmC.setVisibility(8);
                } else {
                    cVar.kmC.setVisibility(0);
                    cVar.kmC.setText(te.kbW);
                }
                if (te.kcb == 0) {
                    view.setAlpha(1.0f);
                    cVar.kmA.setVisibility(0);
                    cVar.kmB.setVisibility(8);
                    Boolean bool = (Boolean) CardListSelectedUI.this.kmm.get(Integer.valueOf(i));
                    if (bool == null || !bool.booleanValue()) {
                        cVar.kmA.setImageResource(R.drawable.g_);
                    } else {
                        cVar.kmA.setImageResource(R.drawable.g9);
                    }
                } else if (te.kcb == 1) {
                    view.setAlpha(0.2f);
                    cVar.kmA.setVisibility(8);
                    if (bo.isNullOrNil(te.kce)) {
                        cVar.kmB.setVisibility(8);
                    } else {
                        cVar.kmB.setVisibility(0);
                        cVar.kmB.setText(te.kce);
                    }
                } else {
                    cVar.kmA.setVisibility(8);
                    cVar.kmB.setVisibility(8);
                }
                if (bo.isNullOrNil(te.kcc)) {
                    cVar.kmE.setVisibility(8);
                } else {
                    cVar.kmE.setVisibility(0);
                    cVar.kmE.setText(te.kcc);
                }
                if (bo.isNullOrNil(te.kcd)) {
                    cVar.kmF.setVisibility(8);
                } else {
                    cVar.kmF.setVisibility(0);
                    cVar.kmF.setText(te.kcd);
                }
                if (bo.isNullOrNil(te.kcc) && bo.isNullOrNil(te.kcd)) {
                    cVar.kmD.setVisibility(8);
                } else {
                    cVar.kmD.setVisibility(0);
                }
            } else {
                ab.i("MicroMsg.CardListSelectedUI", "not support type");
            }
            AppMethodBeat.o(88567);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardListSelectedUI() {
        AppMethodBeat.i(88569);
        AppMethodBeat.o(88569);
    }

    static /* synthetic */ void a(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.i(88584);
        cardListSelectedUI.bcs();
        AppMethodBeat.o(88584);
    }

    static /* synthetic */ void e(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.i(88586);
        cardListSelectedUI.bdk();
        AppMethodBeat.o(88586);
    }

    public final int getLayoutId() {
        return R.layout.jh;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(88570);
        super.onCreate(bundle);
        am.bbi().a(this);
        Intent intent = getIntent();
        ab.i("MicroMsg.CardListSelectedUI", "initData()");
        if (intent == null) {
            ab.e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
            setResult(1);
            aq(1, "");
            finish();
        } else {
            this.emC = intent.getIntExtra("key_from_scene", 0);
            ab.i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.emC);
            this.app_id = intent.getStringExtra("app_id");
            this.kmq = intent.getIntExtra("shop_id", 0);
            this.kmr = intent.getStringExtra("sign_type");
            this.kms = intent.getStringExtra("card_sign");
            this.time_stamp = intent.getIntExtra("time_stamp", 0);
            this.kmt = intent.getStringExtra("nonce_str");
            this.kbU = intent.getStringExtra("card_tp_id");
            this.kmu = intent.getStringExtra("card_type");
            this.kmv = intent.getIntExtra("can_multi_select", 0);
            this.kiA = intent.getStringExtra("key_package_name");
            this.kiB = intent.getStringExtra("key_transaction");
            ab.i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.kmq + " sign_type:" + this.kmr + " time_stamp:" + this.time_stamp);
            ab.i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.kmt + " card_tp_id:" + this.kbU + " card_type:" + this.kmu + " canMultiSelect:" + this.kmv + " packateName:" + this.kiA);
            if ("INVOICE".equalsIgnoreCase(this.kmu)) {
                this.kmx = true;
            }
            if (TextUtils.isEmpty(this.app_id)) {
                ab.e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
                setResult(1);
                aq(1, "app_id  or card_sign is empty!");
                finish();
            }
        }
        bdk();
        initView();
        AppMethodBeat.o(88570);
    }

    private void bdk() {
        AppMethodBeat.i(88571);
        if (this.khr) {
            ab.e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
            AppMethodBeat.o(88571);
            return;
        }
        if (this.keu == null) {
            this.kmn = false;
            this.kmo = false;
            this.kmp = false;
        }
        g.RO().eJo.a(664, (f) this);
        g.RO().eJo.a(new aj(this.app_id, this.kmq, this.kmr, this.kms, this.time_stamp, this.kmt, this.kbU, this.kmu, this.keu), 0);
        fE(true);
        this.khr = true;
        if (this.kmv == 1) {
            this.kml = true;
        }
        AppMethodBeat.o(88571);
    }

    public final void initView() {
        AppMethodBeat.i(88572);
        if (this.kmx) {
            setMMTitle((int) R.string.afm);
        } else {
            setMMTitle((int) R.string.afl);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(88555);
                CardListSelectedUI.this.setResult(0);
                CardListSelectedUI.a(CardListSelectedUI.this, "");
                CardListSelectedUI.this.finish();
                AppMethodBeat.o(88555);
                return true;
            }
        });
        if (!this.kmx) {
            addTextOptionMenu(0, getString(R.string.qt), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(88556);
                    if (CardListSelectedUI.this.kml || !CardListSelectedUI.this.kmy.kcf) {
                        CardListSelectedUI.a(CardListSelectedUI.this);
                    } else {
                        CardListSelectedUI.this.fE(true);
                        am.bbi().M(CardListSelectedUI.this.kmy.kca, l.Ht(CardListSelectedUI.this.kmy.userName), 3);
                    }
                    AppMethodBeat.o(88556);
                    return true;
                }
            });
            enableOptionMenu(false);
        }
        this.mListView = (ListView) findViewById(R.id.ahe);
        if (this.kmx) {
            this.khG = new b();
        } else {
            this.khG = new a();
        }
        this.mListView.setAdapter(this.khG);
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 0;
                AppMethodBeat.i(88557);
                if (view.getAlpha() != 1.0f) {
                    ab.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
                    AppMethodBeat.o(88557);
                    return;
                }
                if (CardListSelectedUI.this.kml) {
                    CardListSelectedUI.this.kmm.put(Integer.valueOf(i), Boolean.valueOf(!((Boolean) CardListSelectedUI.this.kmm.get(Integer.valueOf(i))).booleanValue()));
                } else {
                    while (i2 < CardListSelectedUI.this.eAF.size()) {
                        CardListSelectedUI.this.kmm.put(Integer.valueOf(i2), Boolean.FALSE);
                        i2++;
                    }
                    CardListSelectedUI.this.kmm.put(Integer.valueOf(i), Boolean.TRUE);
                    CardListSelectedUI.this.kmy = (com.tencent.mm.plugin.card.model.a) CardListSelectedUI.this.eAF.get(i);
                }
                CardListSelectedUI.this.khG.notifyDataSetChanged();
                CardListSelectedUI.d(CardListSelectedUI.this);
                AppMethodBeat.o(88557);
            }
        });
        this.mListView.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(88558);
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !CardListSelectedUI.this.eTf) {
                    ab.d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
                    CardListSelectedUI.e(CardListSelectedUI.this);
                }
                AppMethodBeat.o(88558);
            }
        });
        this.Ek = findViewById(R.id.a_b);
        this.kmh = (TextView) findViewById(R.id.a_c);
        if (this.kmx) {
            this.kmh.setText(getString(R.string.agq));
        }
        this.kmi = (RelativeLayout) findViewById(R.id.ah_);
        this.kmj = (TextView) findViewById(R.id.ahc);
        this.kmk = (TextView) findViewById(R.id.ahd);
        if (this.kmx) {
            this.kmi.setVisibility(0);
            this.kmj.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88559);
                    if (!bo.isNullOrNil(CardListSelectedUI.this.kmw)) {
                        com.tencent.mm.plugin.card.d.b.a(CardListSelectedUI.this, CardListSelectedUI.this.kmw, CardListSelectedUI.this.getString(R.string.afa));
                    }
                    AppMethodBeat.o(88559);
                }
            });
            this.kmk.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(88560);
                    CardListSelectedUI.a(CardListSelectedUI.this);
                    AppMethodBeat.o(88560);
                }
            });
            AppMethodBeat.o(88572);
            return;
        }
        this.kmi.setVisibility(8);
        AppMethodBeat.o(88572);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(88573);
        if (mVar instanceof aj) {
            g.RO().eJo.b(664, (f) this);
            fE(false);
            if (i == 0 && i2 == 0) {
                int size;
                String str2 = ((aj) mVar).kdS;
                ab.d("MicroMsg.CardListSelectedUI", str2);
                LinkedList Gs = com.tencent.mm.plugin.card.model.a.Gs(str2);
                LinkedList Gt = com.tencent.mm.plugin.card.model.a.Gt(str2);
                this.kmw = GU(str2);
                if (this.keu == null && !(Gs == null && Gt == null)) {
                    this.kmm.clear();
                    this.eAF.clear();
                }
                if (Gs != null) {
                    if (Gs.size() > 0 && !this.kmn) {
                        this.kmn = true;
                        if (this.kmx) {
                            ((com.tencent.mm.plugin.card.model.a) Gs.get(0)).jKR = getString(R.string.ah1);
                        } else {
                            ((com.tencent.mm.plugin.card.model.a) Gs.get(0)).jKR = getString(R.string.ah0);
                        }
                    }
                    this.eAF.addAll(Gs);
                    for (size = this.eAF.size(); size < this.eAF.size(); size++) {
                        this.kmm.put(Integer.valueOf(size), Boolean.FALSE);
                    }
                }
                if (Gt != null) {
                    if (Gt.size() > 0 && !this.kmo) {
                        this.kmo = true;
                        ((com.tencent.mm.plugin.card.model.a) Gt.get(0)).jKR = getString(R.string.ade);
                    }
                    this.eAF.addAll(Gt);
                    for (size = this.eAF.size(); size < this.eAF.size(); size++) {
                        this.kmm.put(Integer.valueOf(size), Boolean.FALSE);
                    }
                }
                this.eTf = ((aj) mVar).eTf;
                this.keu = ((aj) mVar).keu;
                this.khG.notifyDataSetChanged();
            } else {
                com.tencent.mm.plugin.card.d.d.b(this, str, i2);
            }
            if (this.eAF.size() != 0) {
                this.Ek.setVisibility(8);
                this.mListView.setVisibility(0);
            } else {
                this.Ek.setVisibility(0);
                this.mListView.setVisibility(8);
            }
            this.khr = false;
        }
        AppMethodBeat.o(88573);
    }

    private static String GU(String str) {
        String str2 = null;
        AppMethodBeat.i(88574);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(88574);
        } else {
            try {
                str2 = new JSONObject(str).optString("rule_url");
                AppMethodBeat.o(88574);
            } catch (JSONException e) {
                ab.printErrStackTrace("MicroMsg.CardListSelectedUI", e, "", new Object[0]);
                AppMethodBeat.o(88574);
            }
        }
        return str2;
    }

    public final void b(String str, com.tencent.mm.plugin.card.b.j.b bVar) {
        int i = 0;
        AppMethodBeat.i(88575);
        fE(false);
        if (TextUtils.isEmpty(str) || str.equals(this.kmy.kca)) {
            ab.i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
            ab.i("MicroMsg.CardListSelectedUI", "markSucc:" + bVar.kbI + " markCardId: " + bVar.kbJ);
            if (bVar.kbI == 1) {
                if (TextUtils.isEmpty(bVar.kbJ) || str.equals(bVar.kbJ)) {
                    ab.i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
                } else {
                    ab.i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
                    int i2 = 0;
                    while (i2 < this.eAF.size()) {
                        if (((com.tencent.mm.plugin.card.model.a) this.eAF.get(i2)).kca == bVar.kbJ) {
                            while (i < this.eAF.size()) {
                                this.kmm.put(Integer.valueOf(i), Boolean.FALSE);
                                i++;
                            }
                            this.kmm.put(Integer.valueOf(i2), Boolean.TRUE);
                        } else {
                            i2++;
                        }
                    }
                }
                bcs();
                AppMethodBeat.o(88575);
                return;
            }
            com.tencent.mm.plugin.card.d.d.c(this, getString(R.string.afs));
            AppMethodBeat.o(88575);
            return;
        }
        ab.e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.o(88575);
    }

    public final void dl(String str, String str2) {
        AppMethodBeat.i(88576);
        fE(false);
        if (TextUtils.isEmpty(str) || str.equals(this.kmy.kca)) {
            ab.i("MicroMsg.CardListSelectedUI", "onMarkFail()");
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.string.afr);
            }
            com.tencent.mm.plugin.card.d.d.c(this, str2);
            AppMethodBeat.o(88576);
            return;
        }
        ab.e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
        AppMethodBeat.o(88576);
    }

    public final void Gp(String str) {
    }

    /* Access modifiers changed, original: protected|final */
    public final void fE(boolean z) {
        AppMethodBeat.i(88578);
        if (z) {
            this.ejZ = p.b(this, getString(R.string.cn5), false, null);
            AppMethodBeat.o(88578);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.o(88578);
    }

    private void bcs() {
        AppMethodBeat.i(88579);
        Intent intent = new Intent();
        String bdl = bdl();
        if (this.kmx) {
            intent.putExtra("choose_invoice_info", bdl);
        } else {
            intent.putExtra("choose_card_info", bdl);
        }
        setResult(-1, intent);
        aq(-1, bdl);
        finish();
        AppMethodBeat.o(88579);
    }

    private String bdl() {
        int i = 0;
        AppMethodBeat.i(88580);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.eAF.size(); i2++) {
            Boolean bool = (Boolean) this.kmm.get(Integer.valueOf(i2));
            if (bool != null && bool.booleanValue()) {
                arrayList.add(this.eAF.get(i2));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (i < arrayList.size()) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            com.tencent.mm.plugin.card.model.a aVar = (com.tencent.mm.plugin.card.model.a) arrayList.get(i);
            stringBuilder.append("{");
            stringBuilder.append("\"card_id\":");
            stringBuilder.append("\"" + aVar.kbU + "\"");
            stringBuilder.append(",");
            stringBuilder.append("\"encrypt_code\":");
            stringBuilder.append("\"" + aVar.kbY + "\"");
            if (this.kmx) {
                stringBuilder.append(",");
                stringBuilder.append("\"app_id\":");
                stringBuilder.append("\"" + aVar.app_id + "\"");
            }
            stringBuilder.append("}");
            i++;
        }
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(88580);
        return stringBuilder2;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(88581);
        if (i == 4) {
            setResult(0);
            aq(0, "");
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(88581);
        return onKeyDown;
    }

    private void aq(int i, String str) {
        AppMethodBeat.i(88582);
        if (this.emC != 8) {
            ab.e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.emC);
            AppMethodBeat.o(88582);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_choose_card_from_wx_card_list", str);
        com.tencent.mm.pluginsdk.model.app.f bT = com.tencent.mm.pluginsdk.model.app.g.bT(this.app_id, true);
        Resp resp = new Resp(bundle);
        if (bT != null) {
            resp.openId = bT.field_openId;
        }
        resp.transaction = this.kiB;
        String str2 = "MicroMsg.CardListSelectedUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.app_id;
        objArr[1] = bT == null ? "null appinfo" : bT.field_appName;
        objArr[2] = bT == null ? "null appinfo" : bT.field_openId;
        objArr[3] = this.kiB;
        ab.i(str2, str3, objArr);
        resp.toBundle(bundle);
        ab.i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(i)));
        ab.d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(str)));
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.kiA;
        args.bundle = bundle;
        com.tencent.mm.pluginsdk.model.app.p.at(bundle);
        com.tencent.mm.pluginsdk.model.app.p.au(bundle);
        MMessageActV2.send(ah.getContext(), args);
        AppMethodBeat.o(88582);
    }

    public void onDestroy() {
        AppMethodBeat.i(88577);
        am.bbi().b(this);
        super.onDestroy();
        AppMethodBeat.o(88577);
    }

    static /* synthetic */ void d(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.i(88585);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < cardListSelectedUI.eAF.size()) {
                Boolean bool = (Boolean) cardListSelectedUI.kmm.get(Integer.valueOf(i2));
                if (bool != null && bool.booleanValue()) {
                    cardListSelectedUI.enableOptionMenu(true);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(88585);
                return;
            }
        }
    }

    static /* synthetic */ void a(ImageView imageView, String str, int i) {
        AppMethodBeat.i(88587);
        com.tencent.mm.plugin.card.d.m.a(imageView, str, i, (int) R.drawable.bcm, true);
        AppMethodBeat.o(88587);
    }
}
