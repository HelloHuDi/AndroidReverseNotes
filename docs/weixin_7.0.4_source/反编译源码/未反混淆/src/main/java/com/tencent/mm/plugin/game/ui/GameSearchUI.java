package com.tencent.mm.plugin.game.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.google.firebase.analytics.FirebaseAnalytics.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.model.ak;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.r.c;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.acz;
import com.tencent.mm.protocal.protobuf.ada;
import com.tencent.mm.protocal.protobuf.adb;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class GameSearchUI extends MMActivity implements f, b {
    private static final Pattern nmI = Pattern.compile("\\s+");
    private o elS;
    private View emz;
    private int fromScene;
    private TextView mIp;
    private ViewGroup nmJ;
    private ListView nmK;
    private ListView nmL;
    private r nmM;
    private s nmN;
    private String nmO;
    private String nmP;
    private LinkedList<String> nmQ;
    private String nmR;
    private LinkedList<m> nmS = new LinkedList();
    private boolean nmT = false;
    private OnItemClickListener nmU = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            c cVar;
            AppMethodBeat.i(112192);
            r b = GameSearchUI.this.nmM;
            if (i < 0 || i >= b.getCount()) {
                cVar = null;
            } else {
                cVar = ((r.b) b.getItem(i)).nmy;
            }
            int t;
            HashMap hashMap;
            if (cVar == null) {
                AppMethodBeat.o(112192);
            } else if (cVar.actionType != 1 || bo.isNullOrNil(cVar.appId)) {
                if (cVar.actionType == 2 && !bo.isNullOrNil(cVar.nmz)) {
                    t = com.tencent.mm.plugin.game.f.c.t(GameSearchUI.this, cVar.nmz, "game_center_detail");
                    hashMap = new HashMap();
                    hashMap.put("function_type", a.SEARCH);
                    hashMap.put("funtion_value", cVar.nmA);
                    hashMap.put("keyword", GameSearchUI.this.nmO);
                    com.tencent.mm.plugin.game.e.b.a(GameSearchUI.this, 14, cVar.cKG, cVar.position, t, 0, cVar.appId, GameSearchUI.this.fromScene, cVar.nmu, String.valueOf(cVar.nmv), null, com.tencent.mm.plugin.game.e.a.K(hashMap));
                }
                AppMethodBeat.o(112192);
            } else {
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", cVar.appId);
                bundle.putInt("game_report_from_scene", cVar.cKG);
                t = com.tencent.mm.plugin.game.f.c.b(GameSearchUI.this, cVar.appId, null, bundle);
                hashMap = new HashMap();
                hashMap.put("function_type", a.SEARCH);
                hashMap.put("funtion_value", cVar.nmA);
                hashMap.put("keyword", GameSearchUI.this.nmO);
                com.tencent.mm.plugin.game.e.b.a(GameSearchUI.this, 14, cVar.cKG, cVar.position, t, cVar.appId, GameSearchUI.this.fromScene, com.tencent.mm.plugin.game.e.a.K(hashMap));
                AppMethodBeat.o(112192);
            }
        }
    };
    private OnItemClickListener nmV = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(112193);
            s.a wO = ((s) adapterView.getAdapter()).wO(i);
            if (bo.isNullOrNil(wO.text)) {
                AppMethodBeat.o(112193);
            } else if (bo.isNullOrNil(wO.appId)) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(wO.text);
                GameSearchUI.b(GameSearchUI.this, linkedList);
                GameSearchUI.h(GameSearchUI.this);
                AppMethodBeat.o(112193);
            } else {
                int b;
                switch (wO.actionType) {
                    case 1:
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", wO.appId);
                        bundle.putInt("game_report_from_scene", 1402);
                        b = com.tencent.mm.plugin.game.f.c.b(GameSearchUI.this, wO.appId, null, bundle);
                        com.tencent.mm.plugin.game.e.b.a(GameSearchUI.this, 14, 1402, i, b, wO.appId, GameSearchUI.this.fromScene, null);
                        AppMethodBeat.o(112193);
                        return;
                    case 2:
                        b = com.tencent.mm.plugin.game.f.c.t(GameSearchUI.this.mController.ylL, wO.nmB, "game_center_detail");
                        com.tencent.mm.plugin.game.e.b.a(GameSearchUI.this, 14, 1402, i, b, wO.appId, GameSearchUI.this.fromScene, null);
                        AppMethodBeat.o(112193);
                        return;
                    default:
                        ab.e("MicroMsg.GameSearchUI", "unknowed actionType : " + wO.actionType);
                        AppMethodBeat.o(112193);
                        return;
                }
            }
        }
    };
    private ProgressBar progressBar;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameSearchUI() {
        AppMethodBeat.i(112194);
        AppMethodBeat.o(112194);
    }

    static /* synthetic */ void a(GameSearchUI gameSearchUI, LinkedList linkedList) {
        AppMethodBeat.i(112209);
        gameSearchUI.a(linkedList, 0, false);
        AppMethodBeat.o(112209);
    }

    static /* synthetic */ void h(GameSearchUI gameSearchUI) {
        AppMethodBeat.i(112211);
        gameSearchUI.ru(1);
        AppMethodBeat.o(112211);
    }

    static {
        AppMethodBeat.i(112212);
        AppMethodBeat.o(112212);
    }

    public final void apq() {
    }

    public final void apr() {
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(112195);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        if (g.RK()) {
            g.Rg().a(1328, (f) this);
            g.Rg().a(1329, (f) this);
            this.fromScene = getIntent().getIntExtra("game_report_from_scene", 0);
            initView();
            com.tencent.mm.plugin.game.e.b.a(this, 14, 1401, 0, 2, this.fromScene, null);
            ab.i("MicroMsg.GameSearchUI", "[onCreate] time:" + (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(112195);
            return;
        }
        ab.e("MicroMsg.GameSearchUI", "account not ready");
        finish();
        AppMethodBeat.o(112195);
    }

    public final void initView() {
        AppMethodBeat.i(112196);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(112188);
                GameSearchUI.this.onBackPressed();
                AppMethodBeat.o(112188);
                return true;
            }
        });
        this.elS = new o();
        this.elS.qQ(true);
        this.elS.zHa = this;
        this.nmJ = (ViewGroup) findViewById(R.id.al1);
        this.progressBar = (ProgressBar) findViewById(R.id.baj);
        this.mIp = (TextView) findViewById(R.id.a9r);
        this.nmK = (ListView) findViewById(R.id.bai);
        this.nmM = new r(this);
        this.nmK.setAdapter(this.nmM);
        this.nmK.setOnItemClickListener(this.nmU);
        this.nmK.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(112189);
                GameSearchUI.this.nmK.clearFocus();
                GameSearchUI.this.aqX();
                AppMethodBeat.o(112189);
                return false;
            }
        });
        this.nmK.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(112190);
                if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && GameSearchUI.this.nmM.nmc) {
                    if (GameSearchUI.this.emz != null) {
                        GameSearchUI.this.emz.setVisibility(0);
                    }
                    GameSearchUI.a(GameSearchUI.this, GameSearchUI.this.nmQ);
                }
                AppMethodBeat.o(112190);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        this.emz = getLayoutInflater().inflate(R.layout.a4o, this.nmK, false);
        this.emz.setVisibility(8);
        this.nmK.addFooterView(this.emz);
        this.nmL = (ListView) findViewById(R.id.c9_);
        this.nmN = new s(this);
        this.nmL.setAdapter(this.nmN);
        this.nmL.setOnItemClickListener(this.nmV);
        this.nmL.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(112191);
                GameSearchUI.this.nmL.clearFocus();
                GameSearchUI.this.aqX();
                AppMethodBeat.o(112191);
                return false;
            }
        });
        AppMethodBeat.o(112196);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(112197);
        this.elS.a((FragmentActivity) this, menu);
        this.elS.setHint(e.bEe());
        AppMethodBeat.o(112197);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        AppMethodBeat.i(112198);
        this.elS.a((Activity) this, menu);
        AppMethodBeat.o(112198);
        return true;
    }

    public final int getLayoutId() {
        return R.layout.a5l;
    }

    private void ru(int i) {
        AppMethodBeat.i(112199);
        switch (i) {
            case 0:
                this.nmJ.setVisibility(8);
                this.mIp.setVisibility(8);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.o(112199);
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
                AppMethodBeat.o(112199);
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
                AppMethodBeat.o(112199);
                return;
            case 3:
                this.nmJ.setVisibility(0);
                this.mIp.setVisibility(8);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.o(112199);
                return;
            case 4:
                this.nmJ.setVisibility(8);
                this.mIp.setVisibility(0);
                this.nmK.setVisibility(8);
                this.nmL.setVisibility(8);
                this.progressBar.setVisibility(8);
                AppMethodBeat.o(112199);
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
                AppMethodBeat.o(112199);
                return;
        }
        AppMethodBeat.o(112199);
    }

    private void aa(LinkedList<String> linkedList) {
        AppMethodBeat.i(112200);
        a(linkedList, 0, true);
        AppMethodBeat.o(112200);
    }

    private void a(LinkedList<String> linkedList, int i, boolean z) {
        AppMethodBeat.i(112201);
        while (!this.nmS.isEmpty()) {
            g.RQ();
            g.RO().eJo.c((m) this.nmS.pop());
        }
        if (z) {
            this.nmM.reset();
        }
        this.nmQ = linkedList;
        m akVar = new ak(aa.dor(), linkedList, e.bDR(), this.nmM.mXJ);
        g.Rg().a(akVar, 0);
        this.nmS.add(akVar);
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
        AppMethodBeat.o(112201);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(112203);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            onBackPressed();
            AppMethodBeat.o(112203);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(112203);
        return onKeyDown;
    }

    public void onBackPressed() {
        AppMethodBeat.i(112204);
        super.onBackPressed();
        AppMethodBeat.o(112204);
    }

    public void onDestroy() {
        AppMethodBeat.i(112205);
        ab.i("MicroMsg.GameSearchUI", "onDestroy");
        super.onDestroy();
        g.Rg().b(1328, (f) this);
        g.Rg().b(1329, (f) this);
        AppMethodBeat.o(112205);
    }

    public final void app() {
    }

    public final void apo() {
        AppMethodBeat.i(112206);
        aqX();
        onBackPressed();
        AppMethodBeat.o(112206);
    }

    public final void vO(String str) {
        AppMethodBeat.i(112207);
        if (this.nmT) {
            this.nmT = false;
            AppMethodBeat.o(112207);
        } else if (this.nmR == null || !this.nmR.equals(bo.nullAsNil(str))) {
            this.nmR = str;
            if (bo.isNullOrNil(str)) {
                while (!this.nmS.isEmpty()) {
                    g.RQ();
                    g.RO().eJo.c((m) this.nmS.pop());
                }
                m alVar = new al(aa.dor(), str, e.bDR());
                g.Rg().a(alVar, 0);
                this.nmS.add(alVar);
                AppMethodBeat.o(112207);
                return;
            }
            LinkedList linkedList = new LinkedList();
            String[] split = nmI.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            aa(linkedList);
            ru(6);
            AppMethodBeat.o(112207);
        } else {
            ab.d("MicroMsg.GameSearchUI", "repeat searchChange");
            AppMethodBeat.o(112207);
        }
    }

    public final boolean vN(String str) {
        AppMethodBeat.i(112208);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(112208);
        } else {
            LinkedList linkedList = new LinkedList();
            String[] split = nmI.split(str.replace('*', ' '));
            for (Object add : split) {
                linkedList.add(add);
            }
            aa(linkedList);
            ru(1);
            AppMethodBeat.o(112208);
        }
        return true;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(112202);
        if (mVar.bqV) {
            AppMethodBeat.o(112202);
            return;
        }
        if (this.nmS.contains(mVar)) {
            this.nmS.remove(mVar);
        }
        this.emz.setVisibility(8);
        switch (mVar.getType()) {
            case 1328:
                acz acz = (acz) ((ak) mVar).lty.fsG.fsP;
                ab.d("MicroMsg.GameSearchUI", "keywords = %s, offset = %d", acz.wkL, Integer.valueOf(acz.wkM));
                if (i == 0 && i2 == 0) {
                    List list;
                    ada ada = (ada) ((ak) mVar).lty.fsH.fsP;
                    if (ada != null) {
                        list = ada.wkN;
                    } else {
                        list = null;
                    }
                    if (!bo.ek(list)) {
                        this.nmP = this.nmO;
                        adb adb;
                        if (this.nmM.mXJ != 0) {
                            r rVar = this.nmM;
                            String str2 = this.nmP;
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                adb = (adb) it.next();
                                if (adb.type != 3 || bo.ek(adb.wkP)) {
                                    rVar.nmc = false;
                                } else {
                                    rVar.mXJ = adb.wkT;
                                    rVar.nmc = adb.wkU;
                                    Iterator it2 = adb.wkP.iterator();
                                    while (it2.hasNext()) {
                                        r.b a = r.b.a((add) it2.next());
                                        a.ctj = str2;
                                        a.nmy.appId = a.appId;
                                        a.nmy.nmu = a.nmu;
                                        a.nmy.nmv = a.nmv;
                                        a.nmy.nmA = "2";
                                        c cVar = a.nmy;
                                        int i3 = rVar.nlZ;
                                        rVar.nlZ = i3 + 1;
                                        cVar.position = i3 + 301;
                                        a.nmy.cKG = rVar.ctn ? 1403 : 1405;
                                        rVar.kwf.add(a);
                                    }
                                }
                            }
                        } else {
                            r rVar2 = this.nmM;
                            String str3 = this.nmP;
                            if (rVar2.kwf == null) {
                                rVar2.kwf = new ArrayList();
                            }
                            rVar2.njD = 0;
                            rVar2.nlX = 0;
                            rVar2.nlY = 0;
                            rVar2.nlZ = 0;
                            rVar2.nma = 0;
                            rVar2.ctn = false;
                            rVar2.nlW = false;
                            rVar2.nmc = false;
                            rVar2.mXJ = 0;
                            rVar2.kwf.clear();
                            rVar2.nmd = false;
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
                                    r.b bVar;
                                    c cVar2;
                                    int i4;
                                    rVar2.kwf.add(r.b.aM(0, adb.Title));
                                    if (!rVar2.nmd) {
                                        ((r.b) rVar2.kwf.get(rVar2.kwf.size() - 1)).nmw = true;
                                        rVar2.nmd = true;
                                    }
                                    if (adb.type == 4 && adb.wkS != null) {
                                        it4 = adb.wkS.iterator();
                                        while (it4.hasNext()) {
                                            adc adc = (adc) it4.next();
                                            bVar = new r.b();
                                            bVar.type = 3;
                                            bVar.appId = adc.wkV.fKh;
                                            bVar.name = adc.wkV.Name;
                                            bVar.hHV = adc.wkV.wbw;
                                            bVar.iconUrl = adc.wkV.IconUrl;
                                            bVar.nmq = adc.wkV.mZt;
                                            bVar.nmr = adc.wkV.wkA;
                                            bVar.actionType = adc.wkV.wkB;
                                            bVar.nms = adc.wkV.wkC;
                                            bVar.nmt = adc.wkW;
                                            bVar.nmy = new c(adc.wkV.wkB, 4, adc.wkV.fKh, adc.wkV.wkC);
                                            bVar.ctj = str3;
                                            bVar.nmy.nmA = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                                            cVar2 = bVar.nmy;
                                            i4 = rVar2.nlY;
                                            rVar2.nlY = i4 + 1;
                                            cVar2.position = i4 + 601;
                                            rVar2.kwf.add(bVar);
                                        }
                                    }
                                    if ((adb.type == 1 || adb.type == 2) && adb.wkO != null) {
                                        it4 = adb.wkO.iterator();
                                        while (it4.hasNext()) {
                                            acv acv = (acv) it4.next();
                                            bVar = new r.b();
                                            bVar.type = 1;
                                            bVar.appId = acv.fKh;
                                            bVar.name = acv.Name;
                                            bVar.hHV = acv.wbw;
                                            bVar.iconUrl = acv.IconUrl;
                                            bVar.nmq = acv.mZt;
                                            bVar.nmr = acv.wkA;
                                            bVar.actionType = acv.wkB;
                                            bVar.nms = acv.wkC;
                                            bVar.nmy = new c(acv.wkB, 1, acv.fKh, acv.wkC);
                                            bVar.ctj = str3;
                                            if (adb.type == 1) {
                                                rVar2.ctn = true;
                                                cVar2 = bVar.nmy;
                                                i4 = rVar2.njD;
                                                rVar2.njD = i4 + 1;
                                                cVar2.position = i4 + 1;
                                            } else if (adb.type == 2) {
                                                rVar2.nlW = true;
                                                cVar2 = bVar.nmy;
                                                i4 = rVar2.nlX;
                                                rVar2.nlX = i4 + 1;
                                                cVar2.position = i4 + 1;
                                            }
                                            bVar.nmy.nmA = "1";
                                            rVar2.kwf.add(bVar);
                                        }
                                    } else if (adb.type == 3 && adb.wkP != null) {
                                        rVar2.mXJ = adb.wkT;
                                        rVar2.nmc = adb.wkU;
                                        it4 = adb.wkP.iterator();
                                        while (it4.hasNext()) {
                                            r.b a2 = r.b.a((add) it4.next());
                                            a2.ctj = str3;
                                            a2.nmy.appId = a2.appId;
                                            a2.nmy.nmu = a2.nmu;
                                            a2.nmy.nmv = a2.nmv;
                                            a2.nmy.nmA = "2";
                                            c cVar3 = a2.nmy;
                                            i4 = rVar2.nlZ;
                                            rVar2.nlZ = i4 + 1;
                                            cVar3.position = i4 + 301;
                                            rVar2.kwf.add(a2);
                                        }
                                    }
                                    if (!(bo.isNullOrNil(adb.wkQ) || bo.isNullOrNil(adb.wkR) || adb.type != 1)) {
                                        String str5 = adb.wkQ;
                                        str4 = adb.wkR;
                                        r.b bVar2 = new r.b();
                                        bVar2.type = 5;
                                        bVar2.name = str5;
                                        bVar2.nmy = new c(str4);
                                        bVar2.nmy.appId = "wx62d9035fd4fd2059";
                                        bVar2.nmy.nmA = "1";
                                        bVar2.nmy.position = 300;
                                        rVar2.kwf.add(bVar2);
                                    }
                                } else if (adb.type == 1) {
                                    if (bo.isNullOrNil(str3)) {
                                        str4 = rVar2.context.getString(R.string.c7u);
                                    } else {
                                        str4 = rVar2.context.getString(R.string.c7v, new Object[]{str3});
                                    }
                                    rVar2.kwf.add(r.b.aM(6, str4));
                                    rVar2.nmd = true;
                                }
                            }
                            Iterator it5 = rVar2.kwf.iterator();
                            while (it5.hasNext()) {
                                r.b bVar3 = (r.b) it5.next();
                                if (rVar2.ctn) {
                                    bVar3.nmy.cKG = 1403;
                                } else if (rVar2.nlW) {
                                    bVar3.nmy.cKG = 1404;
                                } else {
                                    bVar3.nmy.cKG = 1405;
                                }
                            }
                            rVar2.notifyDataSetChanged();
                        }
                    }
                }
                ru(2);
                AppMethodBeat.o(112202);
                return;
            case 1329:
                if (i == 0 && i2 == 0) {
                    this.nmN.b(((al) mVar).ctj, ((acx) ((al) mVar).lty.fsH.fsP).Title, ((acx) ((al) mVar).lty.fsH.fsP).wkJ);
                    ru(5);
                    break;
                }
                AppMethodBeat.o(112202);
                return;
        }
        AppMethodBeat.o(112202);
    }

    static /* synthetic */ void b(GameSearchUI gameSearchUI, LinkedList linkedList) {
        AppMethodBeat.i(112210);
        gameSearchUI.a(linkedList, 2, true);
        AppMethodBeat.o(112210);
    }
}
