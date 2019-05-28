package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C45483c;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C45483c.C18773a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.app.C16025a.C16028b;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI */
public class LaunchAAByPersonAmountSelectUI extends BaseAAPresenterActivity {
    private String cuP;
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private C45483c goe = ((C45483c) mo21156Z(C45483c.class));
    private ListView gof;
    private TextView gog;
    private TextView goh;
    private View goi;
    private TextView goj;
    private boolean gok = false;
    private Map<String, String> gol = new HashMap();
    private C32909a gom = null;
    private double gon;
    private long goo = -1;
    private int goq = -1;
    private boolean gor;
    private boolean gos = false;
    private Runnable got = new C98061();

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$1 */
    class C98061 implements Runnable {
        C98061() {
        }

        public final void run() {
            AppMethodBeat.m2504i(40786);
            LaunchAAByPersonAmountSelectUI.m64296a(LaunchAAByPersonAmountSelectUI.this);
            LaunchAAByPersonAmountSelectUI.m64297b(LaunchAAByPersonAmountSelectUI.this);
            AppMethodBeat.m2505o(40786);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$2 */
    class C98082 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$2$2 */
        class C98072 implements OnClickListener {
            C98072() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(40788);
                LaunchAAByPersonAmountSelectUI.this.finish();
                AppMethodBeat.m2505o(40788);
            }
        }

        /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$2$1 */
        class C98091 implements OnClickListener {
            C98091() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(40787);
                LaunchAAByPersonAmountSelectUI.m64299d(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.m2505o(40787);
            }
        }

        C98082() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40789);
            if (LaunchAAByPersonAmountSelectUI.this.gol == null || LaunchAAByPersonAmountSelectUI.this.gol.size() <= 0) {
                LaunchAAByPersonAmountSelectUI.this.finish();
            } else {
                C30379h.m48445a(LaunchAAByPersonAmountSelectUI.this, LaunchAAByPersonAmountSelectUI.this.getString(C25738R.string.f8679bu), null, LaunchAAByPersonAmountSelectUI.this.getString(C25738R.string.f8683by), LaunchAAByPersonAmountSelectUI.this.getString(C25738R.string.f8682bx), false, new C98091(), new C98072());
            }
            AppMethodBeat.m2505o(40789);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$3 */
    class C98103 implements OnMenuItemClickListener {
        C98103() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40790);
            if (LaunchAAByPersonAmountSelectUI.this.goq <= 0 || LaunchAAByPersonAmountSelectUI.this.gol == null || LaunchAAByPersonAmountSelectUI.this.gol.size() <= LaunchAAByPersonAmountSelectUI.this.goq) {
                LaunchAAByPersonAmountSelectUI.m64299d(LaunchAAByPersonAmountSelectUI.this);
                C7060h.pYm.mo8381e(13721, Integer.valueOf(3), Integer.valueOf(4));
                AppMethodBeat.m2505o(40790);
            } else {
                C30379h.m48461b(LaunchAAByPersonAmountSelectUI.this.mController.ylL, LaunchAAByPersonAmountSelectUI.this.getString(C25738R.string.clt, new Object[]{Integer.valueOf(LaunchAAByPersonAmountSelectUI.this.goq)}), "", true);
                C7060h.pYm.mo8381e(13722, Integer.valueOf(8));
                AppMethodBeat.m2505o(40790);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$7 */
    class C329087 implements OnScrollListener {
        C329087() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(40796);
            if (i == 1) {
                LaunchAAByPersonAmountSelectUI.this.aoB();
            }
            AppMethodBeat.m2505o(40796);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$a */
    class C32909a extends BaseAdapter {
        List<C32911b> dataList;

        /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$a$a */
        class C32910a {
            ImageView eks;
            C32912c goA;
            TextView goa;
            WalletFormView gob;

            private C32910a() {
            }

            /* synthetic */ C32910a(C32909a c32909a, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(40803);
            C32911b mQ = m53851mQ(i);
            AppMethodBeat.m2505o(40803);
            return mQ;
        }

        public C32909a(List<String> list, Map<String, Double> map) {
            AppMethodBeat.m2504i(40799);
            this.dataList = null;
            this.dataList = new ArrayList();
            for (String str : list) {
                C32911b c32911b = new C32911b(LaunchAAByPersonAmountSelectUI.this, (byte) 0);
                c32911b.username = str;
                if (map == null || !map.containsKey(str)) {
                    c32911b.goB = "";
                } else {
                    c32911b.goB = LaunchAAByPersonAmountSelectUI.this.getString(C25738R.string.f8641ao, new Object[]{map.get(str)});
                }
                this.dataList.add(c32911b);
            }
            AppMethodBeat.m2505o(40799);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(40800);
            int size = this.dataList.size();
            AppMethodBeat.m2505o(40800);
            return size;
        }

        /* renamed from: mQ */
        private C32911b m53851mQ(int i) {
            AppMethodBeat.m2504i(40801);
            C32911b c32911b = (C32911b) this.dataList.get(i);
            AppMethodBeat.m2505o(40801);
            return c32911b;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(40802);
            C32911b mQ = m53851mQ(i);
            if (!(mQ == null || C5046bo.isNullOrNil(mQ.username))) {
                if (view == null) {
                    view = C5616v.m8409hu(LaunchAAByPersonAmountSelectUI.this).inflate(2130969917, viewGroup, false);
                    final C32910a c32910a = new C32910a(this, (byte) 0);
                    c32910a.eks = (ImageView) view.findViewById(2131823704);
                    c32910a.goa = (TextView) view.findViewById(2131821556);
                    c32910a.gob = (WalletFormView) view.findViewById(2131825206);
                    c32910a.goA = new C32912c(mQ.username);
                    c32910a.gob.mo64594a(c32910a.goA);
                    c32910a.eks.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.m2504i(40797);
                            c32910a.gob.mo64601f(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.m2505o(40797);
                            return false;
                        }
                    });
                    c32910a.goa.setOnTouchListener(new OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            AppMethodBeat.m2504i(40798);
                            c32910a.gob.mo64601f(LaunchAAByPersonAmountSelectUI.this);
                            AppMethodBeat.m2505o(40798);
                            return false;
                        }
                    });
                    view.setTag(c32910a);
                    LaunchAAByPersonAmountSelectUI.this.mo21157a(c32910a.gob, 2, false, true);
                }
                C32910a c32910a2 = (C32910a) view.getTag();
                if (!C5046bo.isNullOrNil(mQ.username)) {
                    c32910a2.goA.username = mQ.username;
                    C40460b.m69434b(c32910a2.eks, mQ.username);
                    c32910a2.goa.setText(C44089j.m79293b(LaunchAAByPersonAmountSelectUI.this.mController.ylL, ((C34530b) C1720g.m3528K(C34530b.class)).getDisplayName(mQ.username, LaunchAAByPersonAmountSelectUI.this.cuP), c32910a2.goa.getTextSize()));
                }
                if (!(mQ.goB == null || c32910a2.gob.getText() == null || mQ.goB.equals(c32910a2.gob.getText().toLowerCase()))) {
                    WalletFormView walletFormView = c32910a2.gob;
                    C32912c c32912c = c32910a2.goA;
                    if (walletFormView.Aih != null) {
                        walletFormView.Aih.removeTextChangedListener(c32912c);
                    }
                    c32910a2.gob.setText(mQ.goB);
                    c32910a2.gob.mo64594a(c32910a2.goA);
                }
            }
            AppMethodBeat.m2505o(40802);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$b */
    class C32911b {
        String goB;
        String username;

        private C32911b() {
            this.username = null;
            this.goB = null;
        }

        /* synthetic */ C32911b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$c */
    protected class C32912c implements TextWatcher {
        String username;

        public C32912c(String str) {
            this.username = str;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(40804);
            try {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                int lastIndexOf = obj.lastIndexOf(".");
                if (lastIndexOf != indexOf && lastIndexOf > 0 && length > lastIndexOf) {
                    editable.delete(lastIndexOf, length);
                }
            } catch (Exception e) {
            }
            if (C5046bo.m7519ac(editable) || C5046bo.getDouble(editable.toString(), 0.0d) <= 0.0d) {
                LaunchAAByPersonAmountSelectUI.this.gol.remove(this.username);
            } else {
                LaunchAAByPersonAmountSelectUI.this.gol.put(this.username, editable.toString());
            }
            LaunchAAByPersonAmountSelectUI.this.fbD.removeCallbacks(LaunchAAByPersonAmountSelectUI.this.got);
            LaunchAAByPersonAmountSelectUI.this.fbD.postDelayed(LaunchAAByPersonAmountSelectUI.this.got, 50);
            AppMethodBeat.m2505o(40804);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$5 */
    class C380125 implements OnTouchListener {
        C380125() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(40792);
            if (LaunchAAByPersonAmountSelectUI.this.gok) {
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                    LaunchAAByPersonAmountSelectUI.this.gog.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(C25738R.color.f11810hz));
                } else if (LaunchAAByPersonAmountSelectUI.this.gok) {
                    LaunchAAByPersonAmountSelectUI.this.gog.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(C25738R.color.f11809hy));
                } else {
                    LaunchAAByPersonAmountSelectUI.this.gog.setTextColor(LaunchAAByPersonAmountSelectUI.this.getResources().getColor(C25738R.color.f11808hx));
                }
                AppMethodBeat.m2505o(40792);
                return false;
            }
            AppMethodBeat.m2505o(40792);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$6 */
    class C380136 implements View.OnClickListener {

        /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$6$2 */
        class C98112 implements OnClickListener {
            C98112() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(40794);
                C7060h.pYm.mo8381e(13721, Integer.valueOf(3), Integer.valueOf(10));
                AppMethodBeat.m2505o(40794);
            }
        }

        /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAByPersonAmountSelectUI$6$1 */
        class C380141 implements OnClickListener {
            C380141() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(40793);
                LaunchAAByPersonAmountSelectUI.m64308m(LaunchAAByPersonAmountSelectUI.this);
                AppMethodBeat.m2505o(40793);
            }
        }

        C380136() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40795);
            if (LaunchAAByPersonAmountSelectUI.this.gol != null && LaunchAAByPersonAmountSelectUI.this.gol.size() > 0) {
                try {
                    C5652a c5652a = new C5652a(LaunchAAByPersonAmountSelectUI.this);
                    c5652a.mo11450PZ(C25738R.string.f8642ap);
                    c5652a.mo11453Qc(C25738R.string.f9187s6).mo11457a(new C380141());
                    c5652a.mo11454Qd(C25738R.string.f9076or).mo11476b(new C98112());
                    c5652a.aMb().show();
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
                }
            }
            C7060h.pYm.mo8381e(13721, Integer.valueOf(3), Integer.valueOf(8));
            AppMethodBeat.m2505o(40795);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LaunchAAByPersonAmountSelectUI() {
        AppMethodBeat.m2504i(40805);
        AppMethodBeat.m2505o(40805);
    }

    /* renamed from: a */
    static /* synthetic */ void m64296a(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.m2504i(40810);
        launchAAByPersonAmountSelectUI.aoC();
        AppMethodBeat.m2505o(40810);
    }

    /* renamed from: b */
    static /* synthetic */ void m64297b(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.m2504i(40811);
        launchAAByPersonAmountSelectUI.aoD();
        AppMethodBeat.m2505o(40811);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(40806);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.clp);
        setBackBtn(new C98082());
        mo17379a((int) C31128d.MIC_PTU_MEISHI, getString(C25738R.string.f9187s6), (OnMenuItemClickListener) new C98103(), C5535b.GREEN);
        this.gof = (ListView) findViewById(2131825208);
        this.gog = (TextView) findViewById(2131825210);
        this.goh = (TextView) findViewById(2131825211);
        this.goh.setText(getString(C25738R.string.clo, new Object[]{Float.valueOf(0.0f)}));
        this.goi = findViewById(2131825209);
        this.goj = (TextView) findViewById(2131825212);
        this.gnR = this.gof;
        this.goi.setVisibility(8);
        this.gog.setOnTouchListener(new C380125());
        this.gog.setOnClickListener(new C380136());
        this.gok = true;
        this.gof.setOnScrollListener(new C329087());
        this.cuP = getIntent().getStringExtra("chatroom");
        this.goo = getIntent().getLongExtra("maxPerAmount", -1);
        this.goq = getIntent().getIntExtra("maxUserNumber", -1);
        ArrayList stringArrayListExtra = getIntent().getStringArrayListExtra("oldAmountData");
        C4990ab.m7417i("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate, chatroom: %s, maxPerAmount: %s, oldDataList: %s", this.cuP, Long.valueOf(this.goo), stringArrayListExtra);
        this.gol = new HashMap();
        final HashMap hashMap = new HashMap();
        if (stringArrayListExtra != null) {
            try {
                if (stringArrayListExtra.size() > 0) {
                    Iterator it = stringArrayListExtra.iterator();
                    while (it.hasNext()) {
                        String[] split = ((String) it.next()).split(",");
                        if (split != null && split.length == 2) {
                            hashMap.put(split[0], Double.valueOf(C5046bo.getDouble(split[1], 0.0d)));
                            this.gol.put(split[0], getString(C25738R.string.f8641ao, new Object[]{Double.valueOf(r4)}));
                        }
                    }
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.LaunchAAByPersonAmountSelectUI", "onCreate parse old data error: %s", e.getMessage());
            }
        }
        this.goe.mo28389aG(C18773a.class);
        this.goe.mo28388a(C18773a.class, (C16028b) new C16028b<C18773a>() {
            /* renamed from: bj */
            public final /* synthetic */ void mo28394bj(Object obj) {
                AppMethodBeat.m2504i(40791);
                C18773a c18773a = (C18773a) obj;
                String str = "MicroMsg.LaunchAAByPersonAmountSelectUI";
                String str2 = "get selectMembers: %s, list.size: %s";
                Object[] objArr = new Object[2];
                objArr[0] = c18773a;
                objArr[1] = c18773a != null ? Integer.valueOf(c18773a.ewK.size()) : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                C4990ab.m7417i(str, str2, objArr);
                LaunchAAByPersonAmountSelectUI.this.gof.addFooterView(C5616v.m8409hu(LaunchAAByPersonAmountSelectUI.this).inflate(2130968577, null), null, false);
                LaunchAAByPersonAmountSelectUI.this.gof.addHeaderView(C5616v.m8409hu(LaunchAAByPersonAmountSelectUI.this).inflate(2130968583, null), null, false);
                if (!(c18773a == null || c18773a.ewK == null || c18773a.ewK.size() <= 0)) {
                    LaunchAAByPersonAmountSelectUI.this.gom = new C32909a(c18773a.ewK, hashMap);
                    LaunchAAByPersonAmountSelectUI.this.gof.setAdapter(LaunchAAByPersonAmountSelectUI.this.gom);
                }
                LaunchAAByPersonAmountSelectUI.this.goi.setVisibility(0);
                LaunchAAByPersonAmountSelectUI.this.fbD.post(LaunchAAByPersonAmountSelectUI.this.got);
                AppMethodBeat.m2505o(40791);
            }
        });
        AppMethodBeat.m2505o(40806);
    }

    public final int getForceOrientation() {
        return 1;
    }

    private void aoC() {
        AppMethodBeat.m2504i(40807);
        try {
            String string;
            this.gon = 0.0d;
            this.gor = false;
            if (this.gol != null) {
                for (String string2 : this.gol.values()) {
                    double d = C5046bo.getDouble(string2, 0.0d);
                    this.gon += d;
                    if (this.goo > 0 && d * 100.0d > ((double) this.goo)) {
                        this.gor = true;
                    }
                }
                if (this.gom != null) {
                    C32909a c32909a = this.gom;
                    Map map = this.gol;
                    for (C32911b c32911b : c32909a.dataList) {
                        c32911b.goB = "";
                    }
                    if (map != null && map.size() > 0) {
                        for (C32911b c32911b2 : c32909a.dataList) {
                            if (map.containsKey(c32911b2.username)) {
                                c32911b2.goB = (String) map.get(c32911b2.username);
                            }
                        }
                    }
                }
            }
            this.goh.setText(getString(C25738R.string.clo, new Object[]{Double.valueOf(this.gon)}));
            if (this.gol == null || this.gol.size() <= 0) {
                updateOptionMenuText(C31128d.MIC_PTU_MEISHI, getString(C25738R.string.f9187s6));
            } else {
                updateOptionMenuText(C31128d.MIC_PTU_MEISHI, getString(C25738R.string.f8648ax, new Object[]{Integer.valueOf(this.gol.size())}));
            }
            if (this.gor) {
                C7060h.pYm.mo8381e(13722, Integer.valueOf(7));
                enableOptionMenu(C31128d.MIC_PTU_MEISHI, false);
                string2 = getString(C25738R.string.cm1, new Object[]{Float.valueOf(((float) this.goo) / 100.0f)});
                if (!C5046bo.isNullOrNil(string2)) {
                    this.goj.setText(string2);
                    if (!this.goj.isShown()) {
                        this.goj.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8343bh));
                        this.goj.setVisibility(0);
                    }
                }
                AppMethodBeat.m2505o(40807);
                return;
            }
            enableOptionMenu(C31128d.MIC_PTU_MEISHI, true);
            if (this.goj.isShown()) {
                this.goj.setText("");
                this.goj.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8359c1));
                this.goj.setVisibility(8);
            }
            AppMethodBeat.m2505o(40807);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.LaunchAAByPersonAmountSelectUI", "updateTotalAmount error: %s", e.getMessage());
            AppMethodBeat.m2505o(40807);
        }
    }

    private void aoD() {
        AppMethodBeat.m2504i(40808);
        if (this.gon > 0.0d) {
            this.gok = true;
            this.gog.setTextColor(getResources().getColor(C25738R.color.f11809hy));
            AppMethodBeat.m2505o(40808);
            return;
        }
        this.gok = false;
        this.gog.setTextColor(getResources().getColor(C25738R.color.f11808hx));
        AppMethodBeat.m2505o(40808);
    }

    public final int getLayoutId() {
        return 2130969918;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(40809);
        super.onDestroy();
        if (this.gol != null) {
            this.gol.clear();
        }
        AppMethodBeat.m2505o(40809);
    }

    /* renamed from: d */
    static /* synthetic */ void m64299d(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.m2504i(40812);
        launchAAByPersonAmountSelectUI.aoC();
        launchAAByPersonAmountSelectUI.aoD();
        if (!launchAAByPersonAmountSelectUI.gor) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAByPersonAmountSelectUI.gol.keySet()) {
                arrayList.add(str + "," + ((String) launchAAByPersonAmountSelectUI.gol.get(str)));
            }
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selectUI", arrayList);
            launchAAByPersonAmountSelectUI.setResult(-1, intent);
            launchAAByPersonAmountSelectUI.finish();
        }
        AppMethodBeat.m2505o(40812);
    }

    /* renamed from: m */
    static /* synthetic */ void m64308m(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        AppMethodBeat.m2504i(40813);
        try {
            launchAAByPersonAmountSelectUI.gog.setTextColor(launchAAByPersonAmountSelectUI.getResources().getColor(C25738R.color.f11808hx));
            launchAAByPersonAmountSelectUI.gok = false;
            launchAAByPersonAmountSelectUI.gon = 0.0d;
            launchAAByPersonAmountSelectUI.goh.setText(launchAAByPersonAmountSelectUI.getString(C25738R.string.clo, new Object[]{Double.valueOf(launchAAByPersonAmountSelectUI.gon)}));
            launchAAByPersonAmountSelectUI.gol.clear();
            launchAAByPersonAmountSelectUI.aoC();
            launchAAByPersonAmountSelectUI.aoD();
            if (launchAAByPersonAmountSelectUI.gom != null) {
                C32909a c32909a = launchAAByPersonAmountSelectUI.gom;
                for (C32911b c32911b : c32909a.dataList) {
                    c32911b.goB = "";
                }
                c32909a.notifyDataSetChanged();
            }
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.LaunchAAByPersonAmountSelectUI", "clearAmount error: %s", e.getMessage());
        }
        C7060h.pYm.mo8381e(13721, Integer.valueOf(3), Integer.valueOf(9));
        AppMethodBeat.m2505o(40813);
    }
}
