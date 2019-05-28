package com.tencent.p177mm.plugin.card.p355ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.channel.MMessageActV2;
import com.tencent.p177mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.p177mm.opensdk.modelbiz.ChooseCardFromWXCardPackage.Resp;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.plugin.card.model.C20139aj;
import com.tencent.p177mm.plugin.card.model.C27584a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.p352b.C20123j.C20124a;
import com.tencent.p177mm.plugin.card.p352b.C20123j.C20125b;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C42840d;
import com.tencent.p177mm.plugin.card.p931d.C45774b;
import com.tencent.p177mm.plugin.card.p931d.C45778m;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI */
public class CardListSelectedUI extends MMActivity implements C1202f, C20124a {
    /* renamed from: Ek */
    private View f17891Ek;
    private String app_id;
    LinkedList<C27584a> eAF = new LinkedList();
    boolean eTf = true;
    private C44275p ejZ = null;
    private int emC = 0;
    private String kbU;
    C1332b keu = null;
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
    private C27584a kmy;
    private ListView mListView;
    private int time_stamp;

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$1 */
    class C113181 implements OnMenuItemClickListener {
        C113181() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88555);
            CardListSelectedUI.this.setResult(0);
            CardListSelectedUI.m84687a(CardListSelectedUI.this, "");
            CardListSelectedUI.this.finish();
            AppMethodBeat.m2505o(88555);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$3 */
    class C201673 implements OnItemClickListener {
        C201673() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = 0;
            AppMethodBeat.m2504i(88557);
            if (view.getAlpha() != 1.0f) {
                C4990ab.m7410d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
                AppMethodBeat.m2505o(88557);
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
                CardListSelectedUI.this.kmy = (C27584a) CardListSelectedUI.this.eAF.get(i);
            }
            CardListSelectedUI.this.khG.notifyDataSetChanged();
            CardListSelectedUI.m84691d(CardListSelectedUI.this);
            AppMethodBeat.m2505o(88557);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$c */
    class C20168c {
        public TextView gsf;
        public ImageView kmA;
        public TextView kmB;
        public TextView kmC;
        public View kmD;
        public TextView kmE;
        public TextView kmF;

        C20168c() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$2 */
    class C276152 implements OnMenuItemClickListener {
        C276152() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(88556);
            if (CardListSelectedUI.this.kml || !CardListSelectedUI.this.kmy.kcf) {
                CardListSelectedUI.m84686a(CardListSelectedUI.this);
            } else {
                CardListSelectedUI.this.mo73592fE(true);
                C42852am.bbi().mo35370M(CardListSelectedUI.this.kmy.kca, C38736l.m65707Ht(CardListSelectedUI.this.kmy.userName), 3);
            }
            AppMethodBeat.m2505o(88556);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$d */
    class C27616d {
        public TextView gsf;
        public TextView jKK;
        public TextView kmC;
        public ImageView kmG;
        public TextView kmH;
        public View kmI;
        public ImageView kmJ;

        C27616d() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$5 */
    class C387605 implements OnClickListener {
        C387605() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88559);
            if (!C5046bo.isNullOrNil(CardListSelectedUI.this.kmw)) {
                C45774b.m84627a(CardListSelectedUI.this, CardListSelectedUI.this.kmw, CardListSelectedUI.this.getString(C25738R.string.afa));
            }
            AppMethodBeat.m2505o(88559);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$6 */
    class C428646 implements OnClickListener {
        C428646() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(88560);
            CardListSelectedUI.m84686a(CardListSelectedUI.this);
            AppMethodBeat.m2505o(88560);
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$a */
    class C42865a extends BaseAdapter {
        C42865a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(88564);
            C27584a te = m76107te(i);
            AppMethodBeat.m2505o(88564);
            return te;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(88561);
            int size = CardListSelectedUI.this.eAF.size();
            AppMethodBeat.m2505o(88561);
            return size;
        }

        /* renamed from: te */
        private C27584a m76107te(int i) {
            AppMethodBeat.m2504i(88562);
            C27584a c27584a = (C27584a) CardListSelectedUI.this.eAF.get(i);
            AppMethodBeat.m2505o(88562);
            return c27584a;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C27616d c27616d;
            AppMethodBeat.m2504i(88563);
            C27584a te = m76107te(i);
            if (view == null) {
                view = View.inflate(CardListSelectedUI.this, 2130968973, null);
                c27616d = new C27616d();
                c27616d.kmG = (ImageView) view.findViewById(2131822233);
                c27616d.gsf = (TextView) view.findViewById(2131820678);
                c27616d.kmC = (TextView) view.findViewById(2131821245);
                c27616d.kmH = (TextView) view.findViewById(2131822292);
                c27616d.jKK = (TextView) view.findViewById(2131821694);
                c27616d.kmI = view.findViewById(2131821220);
                c27616d.kmJ = (ImageView) view.findViewById(2131822288);
                view.setTag(c27616d);
            } else {
                c27616d = (C27616d) view.getTag();
            }
            if (C38736l.m65733sP(te.iAd)) {
                int i2;
                c27616d.gsf.setText(te.kbW);
                if (TextUtils.isEmpty(te.title)) {
                    c27616d.kmC.setVisibility(8);
                } else {
                    c27616d.kmC.setVisibility(0);
                    c27616d.kmC.setText(te.title);
                }
                if (TextUtils.isEmpty(te.kbX)) {
                    c27616d.kmH.setVisibility(8);
                } else {
                    c27616d.kmH.setVisibility(0);
                    c27616d.kmH.setText(te.kbX);
                }
                TextView textView = c27616d.jKK;
                if (C5046bo.isNullOrNil(te.jKR)) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                c27616d.jKK.setText(te.jKR);
                CardListSelectedUI.m84685a(c27616d.kmG, te.kbV, CardListSelectedUI.this.getBaseContext().getResources().getDimensionPixelSize(C25738R.dimen.f10270wd));
                Boolean bool = (Boolean) CardListSelectedUI.this.kmm.get(Integer.valueOf(i));
                if (bool == null || !bool.booleanValue()) {
                    c27616d.kmJ.setImageResource(C25738R.drawable.f6502g_);
                } else {
                    c27616d.kmJ.setImageResource(C25738R.drawable.f6501g9);
                }
            } else {
                C4990ab.m7416i("MicroMsg.CardListSelectedUI", "not support type");
            }
            AppMethodBeat.m2505o(88563);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$b */
    class C42866b extends BaseAdapter {
        C42866b() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(88568);
            C27584a te = m76108te(i);
            AppMethodBeat.m2505o(88568);
            return te;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(88565);
            int size = CardListSelectedUI.this.eAF.size();
            AppMethodBeat.m2505o(88565);
            return size;
        }

        /* renamed from: te */
        private C27584a m76108te(int i) {
            AppMethodBeat.m2504i(88566);
            C27584a c27584a = (C27584a) CardListSelectedUI.this.eAF.get(i);
            AppMethodBeat.m2505o(88566);
            return c27584a;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C20168c c20168c;
            AppMethodBeat.m2504i(88567);
            C27584a te = m76108te(i);
            if (view == null) {
                view = View.inflate(CardListSelectedUI.this, 2130968972, null);
                c20168c = new C20168c();
                c20168c.kmA = (ImageView) view.findViewById(2131822288);
                c20168c.kmB = (TextView) view.findViewById(2131822289);
                c20168c.gsf = (TextView) view.findViewById(2131820678);
                c20168c.kmC = (TextView) view.findViewById(2131821245);
                c20168c.kmD = view.findViewById(2131822101);
                c20168c.kmE = (TextView) view.findViewById(2131822290);
                c20168c.kmF = (TextView) view.findViewById(2131822291);
                view.setTag(c20168c);
            } else {
                c20168c = (C20168c) view.getTag();
            }
            if (C38736l.m65733sP(te.iAd)) {
                if (TextUtils.isEmpty(te.title)) {
                    c20168c.gsf.setVisibility(8);
                } else {
                    c20168c.gsf.setVisibility(0);
                    c20168c.gsf.setText(te.title);
                }
                if (TextUtils.isEmpty(te.kbW)) {
                    c20168c.kmC.setVisibility(8);
                } else {
                    c20168c.kmC.setVisibility(0);
                    c20168c.kmC.setText(te.kbW);
                }
                if (te.kcb == 0) {
                    view.setAlpha(1.0f);
                    c20168c.kmA.setVisibility(0);
                    c20168c.kmB.setVisibility(8);
                    Boolean bool = (Boolean) CardListSelectedUI.this.kmm.get(Integer.valueOf(i));
                    if (bool == null || !bool.booleanValue()) {
                        c20168c.kmA.setImageResource(C25738R.drawable.f6502g_);
                    } else {
                        c20168c.kmA.setImageResource(C25738R.drawable.f6501g9);
                    }
                } else if (te.kcb == 1) {
                    view.setAlpha(0.2f);
                    c20168c.kmA.setVisibility(8);
                    if (C5046bo.isNullOrNil(te.kce)) {
                        c20168c.kmB.setVisibility(8);
                    } else {
                        c20168c.kmB.setVisibility(0);
                        c20168c.kmB.setText(te.kce);
                    }
                } else {
                    c20168c.kmA.setVisibility(8);
                    c20168c.kmB.setVisibility(8);
                }
                if (C5046bo.isNullOrNil(te.kcc)) {
                    c20168c.kmE.setVisibility(8);
                } else {
                    c20168c.kmE.setVisibility(0);
                    c20168c.kmE.setText(te.kcc);
                }
                if (C5046bo.isNullOrNil(te.kcd)) {
                    c20168c.kmF.setVisibility(8);
                } else {
                    c20168c.kmF.setVisibility(0);
                    c20168c.kmF.setText(te.kcd);
                }
                if (C5046bo.isNullOrNil(te.kcc) && C5046bo.isNullOrNil(te.kcd)) {
                    c20168c.kmD.setVisibility(8);
                } else {
                    c20168c.kmD.setVisibility(0);
                }
            } else {
                C4990ab.m7416i("MicroMsg.CardListSelectedUI", "not support type");
            }
            AppMethodBeat.m2505o(88567);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.ui.CardListSelectedUI$4 */
    class C457944 implements OnScrollListener {
        C457944() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(88558);
            if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && !CardListSelectedUI.this.eTf) {
                C4990ab.m7410d("MicroMsg.CardListSelectedUI", "onScroll() >> doGetCardList()");
                CardListSelectedUI.m84692e(CardListSelectedUI.this);
            }
            AppMethodBeat.m2505o(88558);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public CardListSelectedUI() {
        AppMethodBeat.m2504i(88569);
        AppMethodBeat.m2505o(88569);
    }

    /* renamed from: a */
    static /* synthetic */ void m84686a(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.m2504i(88584);
        cardListSelectedUI.bcs();
        AppMethodBeat.m2505o(88584);
    }

    /* renamed from: e */
    static /* synthetic */ void m84692e(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.m2504i(88586);
        cardListSelectedUI.bdk();
        AppMethodBeat.m2505o(88586);
    }

    public final int getLayoutId() {
        return 2130968953;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88570);
        super.onCreate(bundle);
        C42852am.bbi().mo35371a(this);
        Intent intent = getIntent();
        C4990ab.m7416i("MicroMsg.CardListSelectedUI", "initData()");
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.CardListSelectedUI", "doGetCardList()  intent == null");
            setResult(1);
            m84688aq(1, "");
            finish();
        } else {
            this.emC = intent.getIntExtra("key_from_scene", 0);
            C4990ab.m7416i("MicroMsg.CardListSelectedUI", "mFromScene:" + this.emC);
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
            C4990ab.m7416i("MicroMsg.CardListSelectedUI", "app_id:" + this.app_id + " shop_id:" + this.kmq + " sign_type:" + this.kmr + " time_stamp:" + this.time_stamp);
            C4990ab.m7416i("MicroMsg.CardListSelectedUI", "nonce_str:" + this.kmt + " card_tp_id:" + this.kbU + " card_type:" + this.kmu + " canMultiSelect:" + this.kmv + " packateName:" + this.kiA);
            if ("INVOICE".equalsIgnoreCase(this.kmu)) {
                this.kmx = true;
            }
            if (TextUtils.isEmpty(this.app_id)) {
                C4990ab.m7412e("MicroMsg.CardListSelectedUI", "doGetCardList()  app_id is nulls");
                setResult(1);
                m84688aq(1, "app_id  or card_sign is empty!");
                finish();
            }
        }
        bdk();
        initView();
        AppMethodBeat.m2505o(88570);
    }

    private void bdk() {
        AppMethodBeat.m2504i(88571);
        if (this.khr) {
            C4990ab.m7412e("MicroMsg.CardListSelectedUI", "doNetSceneGetShareCardsLayout, isDoingGetData is true");
            AppMethodBeat.m2505o(88571);
            return;
        }
        if (this.keu == null) {
            this.kmn = false;
            this.kmo = false;
            this.kmp = false;
        }
        C1720g.m3535RO().eJo.mo14539a(664, (C1202f) this);
        C1720g.m3535RO().eJo.mo14541a(new C20139aj(this.app_id, this.kmq, this.kmr, this.kms, this.time_stamp, this.kmt, this.kbU, this.kmu, this.keu), 0);
        mo73592fE(true);
        this.khr = true;
        if (this.kmv == 1) {
            this.kml = true;
        }
        AppMethodBeat.m2505o(88571);
    }

    public final void initView() {
        AppMethodBeat.m2504i(88572);
        if (this.kmx) {
            setMMTitle((int) C25738R.string.afm);
        } else {
            setMMTitle((int) C25738R.string.afl);
        }
        setBackBtn(new C113181());
        if (!this.kmx) {
            addTextOptionMenu(0, getString(C25738R.string.f9142qt), new C276152());
            enableOptionMenu(false);
        }
        this.mListView = (ListView) findViewById(2131822225);
        if (this.kmx) {
            this.khG = new C42866b();
        } else {
            this.khG = new C42865a();
        }
        this.mListView.setAdapter(this.khG);
        this.mListView.setOnItemClickListener(new C201673());
        this.mListView.setOnScrollListener(new C457944());
        this.f17891Ek = findViewById(2131821926);
        this.kmh = (TextView) findViewById(2131821927);
        if (this.kmx) {
            this.kmh.setText(getString(C25738R.string.agq));
        }
        this.kmi = (RelativeLayout) findViewById(2131822220);
        this.kmj = (TextView) findViewById(2131822223);
        this.kmk = (TextView) findViewById(2131822224);
        if (this.kmx) {
            this.kmi.setVisibility(0);
            this.kmj.setOnClickListener(new C387605());
            this.kmk.setOnClickListener(new C428646());
            AppMethodBeat.m2505o(88572);
            return;
        }
        this.kmi.setVisibility(8);
        AppMethodBeat.m2505o(88572);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(88573);
        if (c1207m instanceof C20139aj) {
            C1720g.m3535RO().eJo.mo14546b(664, (C1202f) this);
            mo73592fE(false);
            if (i == 0 && i2 == 0) {
                int size;
                String str2 = ((C20139aj) c1207m).kdS;
                C4990ab.m7410d("MicroMsg.CardListSelectedUI", str2);
                LinkedList Gs = C27584a.m43812Gs(str2);
                LinkedList Gt = C27584a.m43813Gt(str2);
                this.kmw = CardListSelectedUI.m84683GU(str2);
                if (this.keu == null && !(Gs == null && Gt == null)) {
                    this.kmm.clear();
                    this.eAF.clear();
                }
                if (Gs != null) {
                    if (Gs.size() > 0 && !this.kmn) {
                        this.kmn = true;
                        if (this.kmx) {
                            ((C27584a) Gs.get(0)).jKR = getString(C25738R.string.ah1);
                        } else {
                            ((C27584a) Gs.get(0)).jKR = getString(C25738R.string.ah0);
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
                        ((C27584a) Gt.get(0)).jKR = getString(C25738R.string.ade);
                    }
                    this.eAF.addAll(Gt);
                    for (size = this.eAF.size(); size < this.eAF.size(); size++) {
                        this.kmm.put(Integer.valueOf(size), Boolean.FALSE);
                    }
                }
                this.eTf = ((C20139aj) c1207m).eTf;
                this.keu = ((C20139aj) c1207m).keu;
                this.khG.notifyDataSetChanged();
            } else {
                C42840d.m76037b(this, str, i2);
            }
            if (this.eAF.size() != 0) {
                this.f17891Ek.setVisibility(8);
                this.mListView.setVisibility(0);
            } else {
                this.f17891Ek.setVisibility(0);
                this.mListView.setVisibility(8);
            }
            this.khr = false;
        }
        AppMethodBeat.m2505o(88573);
    }

    /* renamed from: GU */
    private static String m84683GU(String str) {
        String str2 = null;
        AppMethodBeat.m2504i(88574);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(88574);
        } else {
            try {
                str2 = new JSONObject(str).optString("rule_url");
                AppMethodBeat.m2505o(88574);
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.CardListSelectedUI", e, "", new Object[0]);
                AppMethodBeat.m2505o(88574);
            }
        }
        return str2;
    }

    /* renamed from: b */
    public final void mo35375b(String str, C20125b c20125b) {
        int i = 0;
        AppMethodBeat.m2504i(88575);
        mo73592fE(false);
        if (TextUtils.isEmpty(str) || str.equals(this.kmy.kca)) {
            C4990ab.m7416i("MicroMsg.CardListSelectedUI", "onMarkSuccess()");
            C4990ab.m7416i("MicroMsg.CardListSelectedUI", "markSucc:" + c20125b.kbI + " markCardId: " + c20125b.kbJ);
            if (c20125b.kbI == 1) {
                if (TextUtils.isEmpty(c20125b.kbJ) || str.equals(c20125b.kbJ)) {
                    C4990ab.m7416i("MicroMsg.CardListSelectedUI", "markCardId is same as now id!");
                } else {
                    C4990ab.m7416i("MicroMsg.CardListSelectedUI", "markCardId is diff as now id!");
                    int i2 = 0;
                    while (i2 < this.eAF.size()) {
                        if (((C27584a) this.eAF.get(i2)).kca == c20125b.kbJ) {
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
                AppMethodBeat.m2505o(88575);
                return;
            }
            C42840d.m76040c(this, getString(C25738R.string.afs));
            AppMethodBeat.m2505o(88575);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardListSelectedUI", "onMarkSuccess(), the mark card id is diff from current id!");
        AppMethodBeat.m2505o(88575);
    }

    /* renamed from: dl */
    public final void mo35376dl(String str, String str2) {
        AppMethodBeat.m2504i(88576);
        mo73592fE(false);
        if (TextUtils.isEmpty(str) || str.equals(this.kmy.kca)) {
            C4990ab.m7416i("MicroMsg.CardListSelectedUI", "onMarkFail()");
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(C25738R.string.afr);
            }
            C42840d.m76040c(this, str2);
            AppMethodBeat.m2505o(88576);
            return;
        }
        C4990ab.m7412e("MicroMsg.CardListSelectedUI", "onMarkFail(), the mark card id is diff from current id!");
        AppMethodBeat.m2505o(88576);
    }

    /* renamed from: Gp */
    public final void mo35374Gp(String str) {
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: fE */
    public final void mo73592fE(boolean z) {
        AppMethodBeat.m2504i(88578);
        if (z) {
            this.ejZ = C44275p.m79966b(this, getString(C25738R.string.cn5), false, null);
            AppMethodBeat.m2505o(88578);
            return;
        }
        if (this.ejZ != null && this.ejZ.isShowing()) {
            this.ejZ.dismiss();
            this.ejZ = null;
        }
        AppMethodBeat.m2505o(88578);
    }

    private void bcs() {
        AppMethodBeat.m2504i(88579);
        Intent intent = new Intent();
        String bdl = bdl();
        if (this.kmx) {
            intent.putExtra("choose_invoice_info", bdl);
        } else {
            intent.putExtra("choose_card_info", bdl);
        }
        setResult(-1, intent);
        m84688aq(-1, bdl);
        finish();
        AppMethodBeat.m2505o(88579);
    }

    private String bdl() {
        int i = 0;
        AppMethodBeat.m2504i(88580);
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
            C27584a c27584a = (C27584a) arrayList.get(i);
            stringBuilder.append("{");
            stringBuilder.append("\"card_id\":");
            stringBuilder.append("\"" + c27584a.kbU + "\"");
            stringBuilder.append(",");
            stringBuilder.append("\"encrypt_code\":");
            stringBuilder.append("\"" + c27584a.kbY + "\"");
            if (this.kmx) {
                stringBuilder.append(",");
                stringBuilder.append("\"app_id\":");
                stringBuilder.append("\"" + c27584a.app_id + "\"");
            }
            stringBuilder.append("}");
            i++;
        }
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(88580);
        return stringBuilder2;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88581);
        if (i == 4) {
            setResult(0);
            m84688aq(0, "");
            finish();
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(88581);
        return onKeyDown;
    }

    /* renamed from: aq */
    private void m84688aq(int i, String str) {
        AppMethodBeat.m2504i(88582);
        if (this.emC != 8) {
            C4990ab.m7412e("MicroMsg.CardListSelectedUI", "setResultToSDK need MM_CARD_ITEM_FROM_SCENE_OPENAPI scene, the fromscene is " + this.emC);
            AppMethodBeat.m2505o(88582);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_choose_card_from_wx_card_list", str);
        C40439f bT = C46494g.m87739bT(this.app_id, true);
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
        C4990ab.m7417i(str2, str3, objArr);
        resp.toBundle(bundle);
        C4990ab.m7416i("MicroMsg.CardListSelectedUI", "setResultToSDK result:".concat(String.valueOf(i)));
        C4990ab.m7410d("MicroMsg.CardListSelectedUI", "setResultToSDK card_list:".concat(String.valueOf(str)));
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.kiA;
        args.bundle = bundle;
        C35799p.m58687at(bundle);
        C35799p.m58688au(bundle);
        MMessageActV2.send(C4996ah.getContext(), args);
        AppMethodBeat.m2505o(88582);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(88577);
        C42852am.bbi().mo35372b(this);
        super.onDestroy();
        AppMethodBeat.m2505o(88577);
    }

    /* renamed from: d */
    static /* synthetic */ void m84691d(CardListSelectedUI cardListSelectedUI) {
        AppMethodBeat.m2504i(88585);
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
                AppMethodBeat.m2505o(88585);
                return;
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m84685a(ImageView imageView, String str, int i) {
        AppMethodBeat.m2504i(88587);
        C45778m.m84644a(imageView, str, i, (int) C25738R.drawable.bcm, true);
        AppMethodBeat.m2505o(88587);
    }
}
