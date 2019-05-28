package com.tencent.p177mm.plugin.game.p433ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.p057v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics.C8740a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.tools.C5601o;
import com.tencent.p177mm.p612ui.tools.C5601o.C5600b;
import com.tencent.p177mm.plugin.game.model.C20993e;
import com.tencent.p177mm.plugin.game.model.C34294al;
import com.tencent.p177mm.plugin.game.model.C6942ak;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.C28267r.C12207c;
import com.tencent.p177mm.plugin.game.p433ui.C28267r.C28266b;
import com.tencent.p177mm.plugin.game.p433ui.C28270s.C12208a;
import com.tencent.p177mm.protocal.protobuf.acv;
import com.tencent.p177mm.protocal.protobuf.acx;
import com.tencent.p177mm.protocal.protobuf.acz;
import com.tencent.p177mm.protocal.protobuf.ada;
import com.tencent.p177mm.protocal.protobuf.adb;
import com.tencent.p177mm.protocal.protobuf.adc;
import com.tencent.p177mm.protocal.protobuf.add;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.game.ui.GameSearchUI */
public class GameSearchUI extends MMActivity implements C1202f, C5600b {
    private static final Pattern nmI = Pattern.compile("\\s+");
    private C5601o elS;
    private View emz;
    private int fromScene;
    private TextView mIp;
    private ViewGroup nmJ;
    private ListView nmK;
    private ListView nmL;
    private C28267r nmM;
    private C28270s nmN;
    private String nmO;
    private String nmP;
    private LinkedList<String> nmQ;
    private String nmR;
    private LinkedList<C1207m> nmS = new LinkedList();
    private boolean nmT = false;
    private OnItemClickListener nmU = new C282615();
    private OnItemClickListener nmV = new C121896();
    private ProgressBar progressBar;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameSearchUI$4 */
    class C121884 implements OnTouchListener {
        C121884() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(112191);
            GameSearchUI.this.nmL.clearFocus();
            GameSearchUI.this.aqX();
            AppMethodBeat.m2505o(112191);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameSearchUI$6 */
    class C121896 implements OnItemClickListener {
        C121896() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(112193);
            C12208a wO = ((C28270s) adapterView.getAdapter()).mo46163wO(i);
            if (C5046bo.isNullOrNil(wO.text)) {
                AppMethodBeat.m2505o(112193);
            } else if (C5046bo.isNullOrNil(wO.appId)) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(wO.text);
                GameSearchUI.m85553b(GameSearchUI.this, linkedList);
                GameSearchUI.m85559h(GameSearchUI.this);
                AppMethodBeat.m2505o(112193);
            } else {
                int b;
                switch (wO.actionType) {
                    case 1:
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", wO.appId);
                        bundle.putInt("game_report_from_scene", 1402);
                        b = C46001c.m85457b(GameSearchUI.this, wO.appId, null, bundle);
                        C34277b.m56211a(GameSearchUI.this, 14, 1402, i, b, wO.appId, GameSearchUI.this.fromScene, null);
                        AppMethodBeat.m2505o(112193);
                        return;
                    case 2:
                        b = C46001c.m85464t(GameSearchUI.this.mController.ylL, wO.nmB, "game_center_detail");
                        C34277b.m56211a(GameSearchUI.this, 14, 1402, i, b, wO.appId, GameSearchUI.this.fromScene, null);
                        AppMethodBeat.m2505o(112193);
                        return;
                    default:
                        C4990ab.m7412e("MicroMsg.GameSearchUI", "unknowed actionType : " + wO.actionType);
                        AppMethodBeat.m2505o(112193);
                        return;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameSearchUI$3 */
    class C282603 implements OnScrollListener {
        C282603() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(112190);
            if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && GameSearchUI.this.nmM.nmc) {
                if (GameSearchUI.this.emz != null) {
                    GameSearchUI.this.emz.setVisibility(0);
                }
                GameSearchUI.m85549a(GameSearchUI.this, GameSearchUI.this.nmQ);
            }
            AppMethodBeat.m2505o(112190);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameSearchUI$5 */
    class C282615 implements OnItemClickListener {
        C282615() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            C12207c c12207c;
            AppMethodBeat.m2504i(112192);
            C28267r b = GameSearchUI.this.nmM;
            if (i < 0 || i >= b.getCount()) {
                c12207c = null;
            } else {
                c12207c = ((C28266b) b.getItem(i)).nmy;
            }
            int t;
            HashMap hashMap;
            if (c12207c == null) {
                AppMethodBeat.m2505o(112192);
            } else if (c12207c.actionType != 1 || C5046bo.isNullOrNil(c12207c.appId)) {
                if (c12207c.actionType == 2 && !C5046bo.isNullOrNil(c12207c.nmz)) {
                    t = C46001c.m85464t(GameSearchUI.this, c12207c.nmz, "game_center_detail");
                    hashMap = new HashMap();
                    hashMap.put("function_type", C8740a.SEARCH);
                    hashMap.put("funtion_value", c12207c.nmA);
                    hashMap.put("keyword", GameSearchUI.this.nmO);
                    C34277b.m56210a(GameSearchUI.this, 14, c12207c.cKG, c12207c.position, t, 0, c12207c.appId, GameSearchUI.this.fromScene, c12207c.nmu, String.valueOf(c12207c.nmv), null, C34276a.m56201K(hashMap));
                }
                AppMethodBeat.m2505o(112192);
            } else {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", c12207c.appId);
                bundle.putInt("game_report_from_scene", c12207c.cKG);
                t = C46001c.m85457b(GameSearchUI.this, c12207c.appId, null, bundle);
                hashMap = new HashMap();
                hashMap.put("function_type", C8740a.SEARCH);
                hashMap.put("funtion_value", c12207c.nmA);
                hashMap.put("keyword", GameSearchUI.this.nmO);
                C34277b.m56211a(GameSearchUI.this, 14, c12207c.cKG, c12207c.position, t, c12207c.appId, GameSearchUI.this.fromScene, C34276a.m56201K(hashMap));
                AppMethodBeat.m2505o(112192);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameSearchUI$2 */
    class C392332 implements OnTouchListener {
        C392332() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(112189);
            GameSearchUI.this.nmK.clearFocus();
            GameSearchUI.this.aqX();
            AppMethodBeat.m2505o(112189);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameSearchUI$1 */
    class C460151 implements OnMenuItemClickListener {
        C460151() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(112188);
            GameSearchUI.this.onBackPressed();
            AppMethodBeat.m2505o(112188);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameSearchUI() {
        AppMethodBeat.m2504i(112194);
        AppMethodBeat.m2505o(112194);
    }

    /* renamed from: a */
    static /* synthetic */ void m85549a(GameSearchUI gameSearchUI, LinkedList linkedList) {
        AppMethodBeat.m2504i(112209);
        gameSearchUI.m85550a(linkedList, 0, false);
        AppMethodBeat.m2505o(112209);
    }

    /* renamed from: h */
    static /* synthetic */ void m85559h(GameSearchUI gameSearchUI) {
        AppMethodBeat.m2504i(112211);
        gameSearchUI.m85560ru(1);
        AppMethodBeat.m2505o(112211);
    }

    static {
        AppMethodBeat.m2504i(112212);
        AppMethodBeat.m2505o(112212);
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112195);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (C1720g.m3531RK()) {
            C1720g.m3540Rg().mo14539a(1328, (C1202f) this);
            C1720g.m3540Rg().mo14539a(1329, (C1202f) this);
            this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
            initView();
            C34277b.m56209a(this, 14, 1401, 0, 2, this.fromScene, null);
            C4990ab.m7416i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(112195);
            return;
        }
        C4990ab.m7412e("MicroMsg.GameSearchUI", "account not ready");
        finish();
        AppMethodBeat.m2505o(112195);
    }

    public final void initView() {
        AppMethodBeat.m2504i(112196);
        setBackBtn(new C460151());
        this.elS = new C5601o();
        this.elS.mo11371qQ(true);
        this.elS.zHa = this;
        this.nmJ = (ViewGroup) findViewById(2131822359);
        this.progressBar = (ProgressBar) findViewById(2131823339);
        this.mIp = (TextView) findViewById(2131821905);
        this.nmK = (ListView) findViewById(2131823338);
        this.nmM = new C28267r(this);
        this.nmK.setAdapter(this.nmM);
        this.nmK.setOnItemClickListener(this.nmU);
        this.nmK.setOnTouchListener(new C392332());
        this.nmK.setOnScrollListener(new C282603());
        this.emz = getLayoutInflater().inflate(2130969741, this.nmK, false);
        this.emz.setVisibility(8);
        this.nmK.addFooterView(this.emz);
        this.nmL = (ListView) findViewById(2131824624);
        this.nmN = new C28270s(this);
        this.nmL.setAdapter(this.nmN);
        this.nmL.setOnItemClickListener(this.nmV);
        this.nmL.setOnTouchListener(new C121884());
        AppMethodBeat.m2505o(112196);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(112197);
        this.elS.mo11359a((FragmentActivity) this, menu);
        this.elS.setHint(C20993e.bEe());
        AppMethodBeat.m2505o(112197);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.m2504i(112198);
        this.elS.mo11358a((Activity) this, menu);
        AppMethodBeat.m2505o(112198);
        return true;
    }

    public final int getLayoutId() {
        return 2130969775;
    }

    /* renamed from: ru */
    private void m85560ru(int i) {
        AppMethodBeat.m2504i(112199);
        switch (i) {
            case 0:
                this.nmJ.setVisibility(8);
                this.mIp.setVisibility(8);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.m2505o(112199);
                return;
            case 1:
                aqX();
                this.nmK.smoothScrollToPosition(0);
                this.elS.clearFocus();
                this.nmJ.setVisibility(8);
                this.mIp.setVisibility(8);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(0);
                AppMethodBeat.m2505o(112199);
                return;
            case 2:
                this.nmJ.setVisibility(8);
                if (this.nmM.getCount() > 0) {
                    this.mIp.setVisibility(8);
                    this.nmK.setVisibility(0);
                } else {
                    this.mIp.setVisibility(0);
                    this.nmK.setVisibility(8);
                }
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.m2505o(112199);
                return;
            case 3:
                this.nmJ.setVisibility(0);
                this.mIp.setVisibility(8);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.m2505o(112199);
                return;
            case 4:
                this.nmJ.setVisibility(8);
                this.mIp.setVisibility(0);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.m2505o(112199);
                return;
            case 5:
                this.nmJ.setVisibility(8);
                this.mIp.setVisibility(8);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(0);
                this.progressBar.setVisibility(8);
                break;
            case 6:
                this.nmK.smoothScrollToPosition(0);
                this.nmJ.setVisibility(8);
                this.mIp.setVisibility(8);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(0);
                AppMethodBeat.m2505o(112199);
                return;
        }
        AppMethodBeat.m2505o(112199);
    }

    /* renamed from: aa */
    private void m85551aa(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(112200);
        m85550a(linkedList, 0, true);
        AppMethodBeat.m2505o(112200);
    }

    /* renamed from: a */
    private void m85550a(LinkedList<String> linkedList, int i, boolean z) {
        AppMethodBeat.m2504i(112201);
        while (!this.nmS.isEmpty()) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14547c((C1207m) this.nmS.pop());
        }
        if (z) {
            this.nmM.reset();
        }
        this.nmQ = linkedList;
        C1207m c6942ak = new C6942ak(C4988aa.dor(), linkedList, C20993e.bDR(), this.nmM.mXJ);
        C1720g.m3540Rg().mo14541a(c6942ak, 0);
        this.nmS.add(c6942ak);
        Iterator it = linkedList.iterator();
        this.nmO = "";
        while (it.hasNext()) {
            this.nmO += " " + ((String) it.next());
        }
        this.nmO = this.nmO.trim();
        if (i == 1 || i == 2) {
            this.nmT = true;
            this.elS.setSearchContent(this.nmO);
        }
        AppMethodBeat.m2505o(112201);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(112203);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            onBackPressed();
            AppMethodBeat.m2505o(112203);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(112203);
        return onKeyDown;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(112204);
        super.onBackPressed();
        AppMethodBeat.m2505o(112204);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112205);
        C4990ab.m7416i("MicroMsg.GameSearchUI", "onDestroy");
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(1328, (C1202f) this);
        C1720g.m3540Rg().mo14546b(1329, (C1202f) this);
        AppMethodBeat.m2505o(112205);
    }

    public final void app() {
    }

    public final void apo() {
        AppMethodBeat.m2504i(112206);
        aqX();
        onBackPressed();
        AppMethodBeat.m2505o(112206);
    }

    /* renamed from: vO */
    public final void mo7460vO(String str) {
        AppMethodBeat.m2504i(112207);
        if (this.nmT) {
            this.nmT = false;
            AppMethodBeat.m2505o(112207);
        } else if (this.nmR == null || !this.nmR.equals(C5046bo.nullAsNil(str))) {
            this.nmR = str;
            if (C5046bo.isNullOrNil(str)) {
                while (!this.nmS.isEmpty()) {
                    C1720g.m3537RQ();
                    C1720g.m3535RO().eJo.mo14547c((C1207m) this.nmS.pop());
                }
                C1207m c34294al = new C34294al(C4988aa.dor(), str, C20993e.bDR());
                C1720g.m3540Rg().mo14541a(c34294al, 0);
                this.nmS.add(c34294al);
                AppMethodBeat.m2505o(112207);
                return;
            }
            LinkedList linkedList = new LinkedList();
            String[] split = nmI.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            m85551aa(linkedList);
            m85560ru(6);
            AppMethodBeat.m2505o(112207);
        } else {
            C4990ab.m7410d("MicroMsg.GameSearchUI", "repeat searchChange");
            AppMethodBeat.m2505o(112207);
        }
    }

    /* renamed from: vN */
    public final boolean mo7459vN(String str) {
        AppMethodBeat.m2504i(112208);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(112208);
        } else {
            LinkedList linkedList = new LinkedList();
            String[] split = nmI.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            m85551aa(linkedList);
            m85560ru(1);
            AppMethodBeat.m2505o(112208);
        }
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(112202);
        if (c1207m.bqV) {
            AppMethodBeat.m2505o(112202);
            return;
        }
        if (this.nmS.contains(c1207m)) {
            this.nmS.remove(c1207m);
        }
        this.emz.setVisibility(8);
        switch (c1207m.getType()) {
            case 1328:
                acz acz = (acz) ((C6942ak) c1207m).lty.fsG.fsP;
                C4990ab.m7411d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", acz.wkL, Integer.valueOf(acz.wkM));
                if (i == 0 && i2 == 0) {
                    List list;
                    ada ada = (ada) ((C6942ak) c1207m).lty.fsH.fsP;
                    if (ada != null) {
                        list = ada.wkN;
                    } else {
                        list = null;
                    }
                    if (!C5046bo.m7548ek(list)) {
                        this.nmP = this.nmO;
                        adb adb;
                        if (this.nmM.mXJ != 0) {
                            C28267r c28267r = this.nmM;
                            String str2 = this.nmP;
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                adb = (adb) it.next();
                                if (adb.type != 3 || C5046bo.m7548ek(adb.wkP)) {
                                    c28267r.nmc = false;
                                } else {
                                    c28267r.mXJ = adb.wkT;
                                    c28267r.nmc = adb.wkU;
                                    Iterator it2 = adb.wkP.iterator();
                                    while (it2.hasNext()) {
                                        C28266b a = C28266b.m44836a((add) it2.next());
                                        a.ctj = str2;
                                        a.nmy.appId = a.appId;
                                        a.nmy.nmu = a.nmu;
                                        a.nmy.nmv = a.nmv;
                                        a.nmy.nmA = "2";
                                        C12207c c12207c = a.nmy;
                                        int i3 = c28267r.nlZ;
                                        c28267r.nlZ = i3 + 1;
                                        c12207c.position = i3 + 301;
                                        a.nmy.cKG = c28267r.ctn ? 1403 : 1405;
                                        c28267r.kwf.add(a);
                                    }
                                }
                            }
                        } else {
                            C28267r c28267r2 = this.nmM;
                            String str3 = this.nmP;
                            if (c28267r2.kwf == null) {
                                c28267r2.kwf = new ArrayList();
                            }
                            c28267r2.njD = 0;
                            c28267r2.nlX = 0;
                            c28267r2.nlY = 0;
                            c28267r2.nlZ = 0;
                            c28267r2.nma = 0;
                            c28267r2.ctn = false;
                            c28267r2.nlW = false;
                            c28267r2.nmc = false;
                            c28267r2.mXJ = 0;
                            c28267r2.kwf.clear();
                            c28267r2.nmd = false;
                            Iterator it3 = list.iterator();
                            while (it3.hasNext()) {
                                adb = (adb) it3.next();
                                Object obj = (adb.wkO == null || adb.wkO.size() == 0) ? 1 : null;
                                Object obj2 = (adb.wkP == null || adb.wkP.size() == 0) ? 1 : null;
                                Object obj3 = (adb.wkS == null || adb.wkS.size() == 0) ? 1 : null;
                                if (obj == null || obj2 == null || obj3 == null) {
                                    obj2 = null;
                                } else {
                                    obj2 = 1;
                                }
                                String str4;
                                if (obj2 == null) {
                                    Iterator it4;
                                    C28266b c28266b;
                                    C12207c c12207c2;
                                    int i4;
                                    c28267r2.kwf.add(C28266b.m44837aM(0, adb.Title));
                                    if (!c28267r2.nmd) {
                                        ((C28266b) c28267r2.kwf.get(c28267r2.kwf.size() - 1)).nmw = true;
                                        c28267r2.nmd = true;
                                    }
                                    if (adb.type == 4 && adb.wkS != null) {
                                        it4 = adb.wkS.iterator();
                                        while (it4.hasNext()) {
                                            adc adc = (adc) it4.next();
                                            c28266b = new C28266b();
                                            c28266b.type = 3;
                                            c28266b.appId = adc.wkV.fKh;
                                            c28266b.name = adc.wkV.Name;
                                            c28266b.hHV = adc.wkV.wbw;
                                            c28266b.iconUrl = adc.wkV.IconUrl;
                                            c28266b.nmq = adc.wkV.mZt;
                                            c28266b.nmr = adc.wkV.wkA;
                                            c28266b.actionType = adc.wkV.wkB;
                                            c28266b.nms = adc.wkV.wkC;
                                            c28266b.nmt = adc.wkW;
                                            c28266b.nmy = new C12207c(adc.wkV.wkB, 4, adc.wkV.fKh, adc.wkV.wkC);
                                            c28266b.ctj = str3;
                                            c28266b.nmy.nmA = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                            c12207c2 = c28266b.nmy;
                                            i4 = c28267r2.nlY;
                                            c28267r2.nlY = i4 + 1;
                                            c12207c2.position = i4 + 601;
                                            c28267r2.kwf.add(c28266b);
                                        }
                                    }
                                    if ((adb.type == 1 || adb.type == 2) && adb.wkO != null) {
                                        it4 = adb.wkO.iterator();
                                        while (it4.hasNext()) {
                                            acv acv = (acv) it4.next();
                                            c28266b = new C28266b();
                                            c28266b.type = 1;
                                            c28266b.appId = acv.fKh;
                                            c28266b.name = acv.Name;
                                            c28266b.hHV = acv.wbw;
                                            c28266b.iconUrl = acv.IconUrl;
                                            c28266b.nmq = acv.mZt;
                                            c28266b.nmr = acv.wkA;
                                            c28266b.actionType = acv.wkB;
                                            c28266b.nms = acv.wkC;
                                            c28266b.nmy = new C12207c(acv.wkB, 1, acv.fKh, acv.wkC);
                                            c28266b.ctj = str3;
                                            if (adb.type == 1) {
                                                c28267r2.ctn = true;
                                                c12207c2 = c28266b.nmy;
                                                i4 = c28267r2.njD;
                                                c28267r2.njD = i4 + 1;
                                                c12207c2.position = i4 + 1;
                                            } else if (adb.type == 2) {
                                                c28267r2.nlW = true;
                                                c12207c2 = c28266b.nmy;
                                                i4 = c28267r2.nlX;
                                                c28267r2.nlX = i4 + 1;
                                                c12207c2.position = i4 + 1;
                                            }
                                            c28266b.nmy.nmA = "1";
                                            c28267r2.kwf.add(c28266b);
                                        }
                                    } else if (adb.type == 3 && adb.wkP != null) {
                                        c28267r2.mXJ = adb.wkT;
                                        c28267r2.nmc = adb.wkU;
                                        it4 = adb.wkP.iterator();
                                        while (it4.hasNext()) {
                                            C28266b a2 = C28266b.m44836a((add) it4.next());
                                            a2.ctj = str3;
                                            a2.nmy.appId = a2.appId;
                                            a2.nmy.nmu = a2.nmu;
                                            a2.nmy.nmv = a2.nmv;
                                            a2.nmy.nmA = "2";
                                            C12207c c12207c3 = a2.nmy;
                                            i4 = c28267r2.nlZ;
                                            c28267r2.nlZ = i4 + 1;
                                            c12207c3.position = i4 + 301;
                                            c28267r2.kwf.add(a2);
                                        }
                                    }
                                    if (!(C5046bo.isNullOrNil(adb.wkQ) || C5046bo.isNullOrNil(adb.wkR) || adb.type != 1)) {
                                        String str5 = adb.wkQ;
                                        str4 = adb.wkR;
                                        C28266b c28266b2 = new C28266b();
                                        c28266b2.type = 5;
                                        c28266b2.name = str5;
                                        c28266b2.nmy = new C12207c(str4);
                                        c28266b2.nmy.appId = "wx62d9035fd4fd2059";
                                        c28266b2.nmy.nmA = "1";
                                        c28266b2.nmy.position = 300;
                                        c28267r2.kwf.add(c28266b2);
                                    }
                                } else if (adb.type == 1) {
                                    if (C5046bo.isNullOrNil(str3)) {
                                        str4 = c28267r2.context.getString(C25738R.string.c7u);
                                    } else {
                                        str4 = c28267r2.context.getString(C25738R.string.c7v, new Object[]{str3});
                                    }
                                    c28267r2.kwf.add(C28266b.m44837aM(6, str4));
                                    c28267r2.nmd = true;
                                }
                            }
                            Iterator it5 = c28267r2.kwf.iterator();
                            while (it5.hasNext()) {
                                C28266b c28266b3 = (C28266b) it5.next();
                                if (c28267r2.ctn) {
                                    c28266b3.nmy.cKG = 1403;
                                } else if (c28267r2.nlW) {
                                    c28266b3.nmy.cKG = 1404;
                                } else {
                                    c28266b3.nmy.cKG = 1405;
                                }
                            }
                            c28267r2.notifyDataSetChanged();
                        }
                    }
                }
                m85560ru(2);
                AppMethodBeat.m2505o(112202);
                return;
            case 1329:
                if (i == 0 && i2 == 0) {
                    this.nmN.mo46158b(((C34294al) c1207m).ctj, ((acx) ((C34294al) c1207m).lty.fsH.fsP).Title, ((acx) ((C34294al) c1207m).lty.fsH.fsP).wkJ);
                    m85560ru(5);
                    break;
                }
                AppMethodBeat.m2505o(112202);
                return;
        }
        AppMethodBeat.m2505o(112202);
    }

    /* renamed from: b */
    static /* synthetic */ void m85553b(GameSearchUI gameSearchUI, LinkedList linkedList) {
        AppMethodBeat.m2504i(112210);
        gameSearchUI.m85550a(linkedList, 2, true);
        AppMethodBeat.m2505o(112210);
    }
}
