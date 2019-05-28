package com.tencent.mm.ui.conversation;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue.IdleHandler;
import android.os.PowerManager;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.sd;
import com.tencent.mm.g.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kiss.a.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public class MainUI extends AbStractTabFragment implements com.tencent.mm.ui.conversation.k.a {
    private View iVx;
    public MMFragmentActivity iWA;
    private View jcl = null;
    private int[] mkD = new int[2];
    private h zrd;
    private a zuL = new a();
    public ConversationListView zuW;
    private View zuX;
    private View zuY;
    private TextView zuZ;
    private k zva = new k();
    private d zvb = new d();
    private n zvc = new n();
    private l zvd = new l();
    public com.tencent.mm.plugin.appbrand.widget.header.a zve;
    private a zvf;

    class a {
        boolean cui;
        boolean zvi;
        boolean zvj;

        public a(boolean z, boolean z2, boolean z3) {
            this.cui = z;
            this.zvi = z2;
            this.zvj = z3;
        }
    }

    public MainUI() {
        AppMethodBeat.i(34505);
        AppMethodBeat.o(34505);
    }

    static /* synthetic */ void b(MainUI mainUI, int i) {
        AppMethodBeat.i(34530);
        mainUI.Px(i);
        AppMethodBeat.o(34530);
    }

    public int getLayoutId() {
        return R.layout.ab6;
    }

    public View getLayoutView() {
        AppMethodBeat.i(34506);
        this.jcl = b.SM().a(getContext(), "R.layout.main", (int) R.layout.ab6);
        View view = this.jcl;
        AppMethodBeat.o(34506);
        return view;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onResume() {
        AppMethodBeat.i(34507);
        ab.i("MicroMsg.MainUI", "onResume");
        super.onResume();
        if (this.zuW != null) {
            ConversationListView conversationListView = this.zuW;
            if (conversationListView.iVo != null) {
                conversationListView.iVo.onResume();
            }
            if (conversationListView.zrY != null && conversationListView.zrY.aOV() && conversationListView.iVo.getBottom() < com.tencent.mm.bz.a.fromDPToPix(conversationListView.getContext(), 100)) {
                conversationListView.e(1.0f, conversationListView.getResources().getColor(R.color.e4));
            }
            if (conversationListView.zrY != null) {
                conversationListView.zrY.onResume();
            }
        }
        AppMethodBeat.o(34507);
    }

    public void onPause() {
        AppMethodBeat.i(34508);
        ab.i("MicroMsg.MainUI", "onPause");
        super.onPause();
        if (this.zuW != null) {
            ConversationListView conversationListView = this.zuW;
            if (conversationListView.iVo != null) {
                conversationListView.iVo.onPause();
            }
        }
        AppMethodBeat.o(34508);
    }

    private void Px(int i) {
        AppMethodBeat.i(34509);
        LayoutParams layoutParams = this.zuW.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ab.i("MicroMsg.MainUI", "alvinluo setListMargin topMargin: %d", Integer.valueOf(i));
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = i;
            this.zuW.setLayoutParams(layoutParams);
        }
        if (this.iVx != null) {
            this.iVx.getLayoutParams().height = i;
        }
        AppMethodBeat.o(34509);
    }

    public final void i(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(34510);
        if (this.zuW instanceof ConversationListView) {
            this.zuW.i(z, z2, z3);
            AppMethodBeat.o(34510);
            return;
        }
        this.zvf = new a(z, z2, z3);
        AppMethodBeat.o(34510);
    }

    public final void dHz() {
        AppMethodBeat.i(34511);
        if (this.zrd != null) {
            this.zrd.dHz();
        }
        AppMethodBeat.o(34511);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(34512);
        super.onConfigurationChanged(configuration);
        this.zuL.dIn();
        AppMethodBeat.o(34512);
    }

    public final void dvY() {
        a aVar;
        AppMethodBeat.i(34513);
        ab.i("MicroMsg.MainUI", "onTabCreate, %d", Integer.valueOf(hashCode()));
        if (this.mController != null) {
            this.mController.aC(4, false);
        }
        ab.i("MicroMsg.MainUI", "mainUIOnCreate");
        long currentTimeMillis = System.currentTimeMillis();
        setMenuVisibility(true);
        aw.RS().doM();
        ab.i("MicroMsg.MainUI", "main ui init view");
        if (this.zuW != null) {
            aVar = this.zuL;
            if (aVar.zqz != null) {
                aVar.ft(aVar.zqr);
                aVar.ft(aVar.zqs);
                aVar.ft(aVar.zqt);
                aVar.ft(aVar.zqu);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : aVar.zqv) {
                    if (!(bVar == null || bVar.getView() == null)) {
                        aVar.zqz.removeFooterView(bVar.getView());
                    }
                }
            }
        }
        this.zuZ = (TextView) findViewById(R.id.d1w);
        this.zuW = (ConversationListView) findViewById(R.id.d1v);
        this.iVx = findViewById(R.id.d1u);
        this.zuW.setStatusBarMaskView(this.iVx);
        if (this.zuW != null) {
            int J = ak.J(getContext(), -1);
            ab.i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d", Integer.valueOf(f.de(this.zuW.getContext())), Integer.valueOf(J));
            AnonymousClass9 anonymousClass9 = new Runnable() {
                int eRu = 0;

                public final void run() {
                    AppMethodBeat.i(34502);
                    if (MainUI.this.zuW == null) {
                        AppMethodBeat.o(34502);
                        return;
                    }
                    int J = ak.J(MainUI.this.getContext(), -1);
                    int de = f.de(MainUI.this.zuW.getContext());
                    if (J <= 0 || de <= 0) {
                        if (this.eRu < 2) {
                            ab.i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
                            MainUI.this.zuW.post(this);
                        } else {
                            ab.e("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight finally!");
                        }
                        this.eRu++;
                    } else if (J + de != MainUI.this.zuW.getPaddingTop()) {
                        ab.i("MicroMsg.MainUI", "[initListViewPadding] now:%s old:%s", Integer.valueOf(J + de), Integer.valueOf(MainUI.this.zuW.getPaddingTop()));
                        MainUI.b(MainUI.this, de + J);
                    } else {
                        ab.i("MicroMsg.MainUI", "[trySetListViewMargin] has try more once! it's right! statusHeight:%s", Integer.valueOf(J));
                    }
                    ab.i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", Integer.valueOf(this.eRu), Integer.valueOf(J));
                    AppMethodBeat.o(34502);
                }
            };
            if (J <= 0) {
                this.zuW.post(anonymousClass9);
            } else {
                Px(J + r1);
                ab.i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", Integer.valueOf(J), Integer.valueOf(r1));
                this.zuW.postDelayed(anonymousClass9, 100);
            }
        }
        d dVar = (d) g.K(d.class);
        if (dVar == null) {
            ab.e("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView service is null");
        } else {
            dVar.aOE();
            if (dVar.aOF()) {
                this.zuX = dVar.dg(getContext());
                if (this.zuX != null && (this.jcl instanceof ViewGroup)) {
                    ab.i("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView");
                    LayoutParams layoutParams = new LayoutParams(-1, -1);
                    this.zuX.setVisibility(8);
                    ((ViewGroup) this.jcl).addView(this.zuX, 0, layoutParams);
                }
            }
        }
        this.zuW.setDrawingCacheEnabled(false);
        this.zuW.setScrollingCacheEnabled(false);
        this.zuY = findViewById(R.id.d1t);
        ConversationListView conversationListView = this.zuW;
        View view = this.zuX;
        View view2 = this.zuY;
        conversationListView.zsr = view;
        if (conversationListView.iVo != null) {
            conversationListView.iVo.e(view, view2);
        }
        this.zrd = new h(getContext(), this.zuW, new com.tencent.mm.ui.f.a() {
            public final void dwH() {
                AppMethodBeat.i(34496);
                com.tencent.mm.plugin.report.service.g.BN(12);
                d b = MainUI.this.zvb;
                b.zrb = -1;
                b.zra.clear();
                if (b.zrd == null || b.zrc < 0 || !b.zrd.dvr()) {
                    b.zrb = 0;
                    AppMethodBeat.o(34496);
                } else if (b.zrd.ztG) {
                    b.zrb = 0;
                    AppMethodBeat.o(34496);
                } else if (b.zrd.ztE) {
                    ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
                    b.zrb = 0;
                    b.zrd.ztE = false;
                    AppMethodBeat.o(34496);
                } else {
                    HashSet hashSet = (HashSet) b.zrd.ztF.clone();
                    ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", Integer.valueOf(hashSet.size()));
                    if (hashSet.contains("floatbottle")) {
                        b.zrb = 0;
                        AppMethodBeat.o(34496);
                        return;
                    }
                    hashSet.remove("officialaccounts");
                    if (hashSet.isEmpty()) {
                        b.zrb = 1;
                        AppMethodBeat.o(34496);
                        return;
                    }
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        boolean z;
                        String str = (String) it.next();
                        h hVar = b.zrd;
                        if (hVar.arV(str)) {
                            z = false;
                        } else {
                            d dVar = (d) hVar.yDY.get(str);
                            if (dVar == null) {
                                z = false;
                            } else if (t.kH(str)) {
                                z = dVar.zrR;
                            } else {
                                z = dVar.zrN;
                            }
                        }
                        if (!z) {
                            com.tencent.mm.storage.ak arU = b.arU(str);
                            if (arU == null) {
                                b.zra.put(str, Integer.valueOf(0));
                                ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", str, Integer.valueOf(0));
                            } else {
                                b.zra.put(str, Integer.valueOf(arU.field_unReadCount));
                                ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", str, Integer.valueOf(arU.field_unReadCount));
                            }
                        }
                    }
                    ab.i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", Integer.valueOf(b.zra.size()));
                    if (b.zra.isEmpty()) {
                        b.zrb = 1;
                        AppMethodBeat.o(34496);
                    } else if (b.zra.size() > 20) {
                        b.zrb = 0;
                        AppMethodBeat.o(34496);
                    } else {
                        b.zrb = 2;
                        AppMethodBeat.o(34496);
                    }
                }
            }

            public final void apt() {
                AppMethodBeat.i(34497);
                MainUI.this.zvb.dIp();
                if (MainUI.this.zrd != null) {
                    h a = MainUI.this.zrd;
                    if (!(a.yDY == null || a.ztF == null || a.ztF.isEmpty())) {
                        if (a.ztG) {
                            a.yDY.clear();
                            a.ztG = false;
                        } else {
                            ab.d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", Integer.valueOf(a.ztF.size()));
                            Iterator it = a.ztF.iterator();
                            while (it.hasNext()) {
                                a.yDY.remove(it.next());
                            }
                        }
                        a.ztF.clear();
                    }
                }
                MainUI.this.zuW.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34495);
                        MainUI.a(MainUI.this, MainUI.this.zrd.getCount());
                        if (MainUI.this.zrd.getCount() <= 0 && MainUI.this.zuW != null) {
                            ConversationListView c = MainUI.this.zuW;
                            ab.i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", Boolean.valueOf(c.iVR));
                            if (!c.iVR) {
                                c.qH(false);
                                if (c.zst != null) {
                                    c.zst.setBackgroundColor(c.getContext().getResources().getColor(R.color.a69));
                                }
                                c.e(1.0f, c.getResources().getColor(R.color.e4));
                            }
                        }
                        MainUI.this.zuL.dIn();
                        com.tencent.mm.plugin.report.service.g.BO(12);
                        AppMethodBeat.o(34495);
                    }
                });
                AppMethodBeat.o(34497);
            }
        });
        this.zrd.setGetViewPositionCallback(new c() {
            public final int cZ(View view) {
                AppMethodBeat.i(34498);
                int positionForView = MainUI.this.zuW.getPositionForView(view);
                AppMethodBeat.o(34498);
                return positionForView;
            }
        });
        this.zrd.setPerformItemClickListener(new MMSlideDelView.g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(34499);
                MainUI.this.zuW.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(34499);
            }
        });
        if (com.tencent.mm.compatible.util.d.iX(18)) {
            com.tencent.mm.blink.b.HQ().o(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34500);
                    MainUI.this.zuL.a(MainUI.this.getContext(), MainUI.this.zuW, MainUI.this.zuZ);
                    AppMethodBeat.o(34500);
                }
            });
        } else {
            this.zuL.a(getContext(), this.zuW, this.zuZ);
        }
        l lVar = this.zvd;
        ConversationListView conversationListView2 = this.zuW;
        h hVar = this.zrd;
        lVar.zqz = conversationListView2;
        lVar.zrd = hVar;
        conversationListView2.setOnScrollListener(lVar.ein);
        hVar.zro = lVar.ein;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34574);
                l.a(l.this, 0);
                AppMethodBeat.o(34574);
            }
        });
        this.zvb.ax(getActivity());
        this.zuW.setAdapter(this.zrd);
        this.zuW.setOnItemClickListener(new f(this.zrd, this.zuW, getActivity()));
        this.zuW.setOnItemLongClickListener(new g(this.zrd, this.zuW, getActivity(), this.mkD));
        this.zuW.setonDispatchTouchEventListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(34501);
                switch (motionEvent.getAction()) {
                    case 0:
                        MainUI.this.hideVKB();
                        MainUI.this.mkD[0] = (int) motionEvent.getRawX();
                        MainUI.this.mkD[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(34501);
                return false;
            }
        });
        if (this.zve != null) {
            this.zuW.setActionBarUpdateCallback(this.zve);
        }
        if (this.iWA != null) {
            this.zuW.setActivity(this.iWA);
        }
        if (this.zvf != null) {
            i(this.zvf.cui, this.zvf.zvi, this.zvf.zvj);
        }
        this.zuW.setSelection(0);
        com.tencent.mm.ai.f fVar = this.zva;
        FragmentActivity activity = getActivity();
        aVar = this.zuL;
        fVar.czX = activity;
        fVar.zuL = aVar;
        fVar.zuM = this;
        fVar.gWO = new WeakReference(activity);
        fVar.wakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
        aw.Rg().a(-1, fVar);
        fVar.zuI = false;
        com.tencent.mm.sdk.b.a.xxA.c(fVar.zuN);
        com.tencent.mm.sdk.b.a.xxA.c(fVar.zuO);
        File file = new File(ah.getContext().getFilesDir(), "DBRecoverStarted");
        if (file.exists()) {
            e.pXa.g("DBRepair", "Last recovery interrupted.", null);
            file.delete();
        }
        fVar.zuP = new FLock(new File(ah.getContext().getFilesDir(), "MMStarted"));
        if (fVar.zuP.dob()) {
            fVar.zuP.unlock();
            ab.i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
        } else {
            ab.w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
            e.pXa.a(579, 0, 1, true);
        }
        fVar.zuP.lockRead();
        d dVar2 = this.zvb;
        h hVar2 = this.zrd;
        ConversationListView conversationListView3 = this.zuW;
        FragmentActivity activity2 = getActivity();
        dVar2.zrd = hVar2;
        dVar2.zqz = conversationListView3;
        dVar2.activity = activity2;
        com.tencent.mm.sdk.b.a.xxA.c(dVar2.zrg);
        com.tencent.mm.sdk.b.a.xxA.c(dVar2.zre);
        com.tencent.mm.sdk.b.a.xxA.c(dVar2.zrf);
        n nVar = this.zvc;
        hVar2 = this.zrd;
        conversationListView3 = this.zuW;
        activity2 = getActivity();
        nVar.zrd = hVar2;
        nVar.czX = activity2;
        nVar.zuW = conversationListView3;
        if (nVar.kTz == null) {
            nVar.kTz = new com.tencent.mm.ui.conversation.n.AnonymousClass3(new com.tencent.mm.sdk.platformtools.ak() {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(34591);
                    if (n.this.zrd != null) {
                        n.this.zrd.clearCache();
                        n.this.zrd.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(34591);
                }
            });
        }
        if (nVar.zvz == null) {
            nVar.zvz = new com.tencent.mm.sdk.b.c<nw>() {
                {
                    AppMethodBeat.i(34596);
                    this.xxI = nw.class.getName().hashCode();
                    AppMethodBeat.o(34596);
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    AppMethodBeat.i(34597);
                    if (n.this.zrd != null) {
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(34595);
                                ab.d("MicroMsg.RefreshHelper", "refresh main ui multitalk icon.");
                                if (n.this.zrd != null) {
                                    n.this.zrd.notifyDataSetChanged();
                                }
                                AppMethodBeat.o(34595);
                            }
                        });
                    }
                    AppMethodBeat.o(34597);
                    return true;
                }
            };
        }
        if (nVar.zvA == null) {
            nVar.zvA = new com.tencent.mm.ui.conversation.n.AnonymousClass5(conversationListView3);
        }
        com.tencent.mm.sdk.b.a.xxA.c(nVar.kTz);
        com.tencent.mm.sdk.b.a.xxA.c(nVar.zvz);
        com.tencent.mm.sdk.b.a.xxA.c(nVar.zvA);
        nVar.jQs = new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.i(34600);
                ab.d("MicroMsg.RefreshHelper", "dkuploadAddrBook idleHandler");
                if (aw.RK() && l.apS() == a.SUCC && !l.apR()) {
                    aw.Rg().a(new com.tencent.mm.plugin.account.friend.a.al(l.aqb(), l.aqa()), 0);
                }
                Looper.myQueue().removeIdleHandler(n.this.jQs);
                AppMethodBeat.o(34600);
                return false;
            }
        };
        Looper.myQueue().addIdleHandler(nVar.jQs);
        conversationListView3.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34602);
                if (!ah.dox()) {
                    ah.ph(true);
                    al.n(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(34601);
                            ab.i("MicroMsg.RefreshHelper", "APPHasInitEvent begin");
                            com.tencent.mm.sdk.b.a.xxA.m(new com.tencent.mm.g.a.a());
                            AppMethodBeat.o(34601);
                        }
                    }, 100);
                }
                com.tencent.mm.plugin.report.service.g.BO(8);
                AppMethodBeat.o(34602);
            }
        });
        com.tencent.mm.at.b ahn = o.ahn();
        ab.i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ahn.fCX + " to 2130838182");
        ahn.fCX = R.drawable.b0p;
        aw.ZG();
        aw.ZK();
        com.tencent.mm.model.c.XR().a(this.zrd);
        aw.ZK();
        com.tencent.mm.model.c.XM().a(this.zrd);
        h hVar3 = this.zrd;
        if (hVar3.zrt == null) {
            hVar3.zrt = new com.tencent.mm.sdk.b.c<aa>() {
                {
                    AppMethodBeat.i(34354);
                    this.xxI = aa.class.getName().hashCode();
                    AppMethodBeat.o(34354);
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    AppMethodBeat.i(34355);
                    h.this.zrq = true;
                    AppMethodBeat.o(34355);
                    return false;
                }
            };
        }
        com.tencent.mm.sdk.b.a.xxA.c(hVar3.zrt);
        this.zrd.ztz = new h.b() {
            public final void dIJ() {
                AppMethodBeat.i(34492);
                MainUI.this.zrd.clearCache();
                aw.ZK();
                com.tencent.mm.model.c.XR().a(MainUI.this.zrd);
                aw.ZK();
                com.tencent.mm.model.c.XM().a(MainUI.this.zrd);
                AppMethodBeat.o(34492);
            }
        };
        hVar2 = this.zrd;
        com.tencent.mm.plugin.forcenotify.a.b bVar2 = (com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class);
        if (!(bVar2 == null || bVar2.bxV() == null)) {
            bVar2.bxV().c(hVar2.yql);
        }
        r2 = new Object[3];
        aw.ZK();
        r2[1] = Integer.valueOf(com.tencent.mm.model.c.QF());
        r2[2] = Integer.valueOf(com.tencent.mm.protocal.d.vxo);
        ab.i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", r2);
        this.zuW.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34503);
                if (MainUI.this.thisActivity() != null) {
                    MainUI.this.thisActivity().supportInvalidateOptionsMenu();
                }
                AppMethodBeat.o(34503);
            }
        }, 200);
        AppMethodBeat.o(34513);
    }

    public final void dIT() {
        AppMethodBeat.i(34514);
        if (this.zrd != null) {
            this.zrd.onResume();
        }
        AppMethodBeat.o(34514);
    }

    public final void dIU() {
        AppMethodBeat.i(34515);
        if (this.zrd != null) {
            this.zrd.onPause();
        }
        AppMethodBeat.o(34515);
    }

    public final void Nj(int i) {
        AppMethodBeat.i(34516);
        if (this.zrd != null) {
            this.zrd.Pv(i);
        }
        AppMethodBeat.o(34516);
    }

    public final void dvZ() {
        AppMethodBeat.i(34517);
        ab.i("MicroMsg.MainUI", "onTabResume");
        long anU = com.tencent.mm.platformtools.ah.anU();
        d dVar = this.zvb;
        if (dVar.zrc < 0) {
            ab.d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", Integer.valueOf(dVar.zrc));
            if (dVar.zrd != null) {
                dVar.zrd.dIH();
            }
        }
        dIT();
        com.tencent.mm.blink.b.HQ().o(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34504);
                a d = MainUI.this.zuL;
                com.tencent.mm.ah.o.acd().d(d);
                aw.ZK();
                com.tencent.mm.model.c.Ry().a(d);
                d.dIn();
                AppMethodBeat.o(34504);
            }
        });
        ab.d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", Long.valueOf(com.tencent.mm.platformtools.ah.gb(anU)));
        n nVar = this.zvc;
        if (com.tencent.mm.bg.g.fUs != null) {
            com.tencent.mm.bg.g.fUs.a(nVar);
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34603);
                go goVar = new go();
                goVar.cBl.data = "MAIN_UI_EVENT_UPDATE_VIEW";
                com.tencent.mm.sdk.b.a.xxA.m(goVar);
                AppMethodBeat.o(34603);
            }
        });
        m.hY(nVar.czX);
        if (!(nVar.czX == null || nVar.czX.getIntent() == null || !nVar.czX.getIntent().getBooleanExtra("resend_fail_messages", false))) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34606);
                    h.d(n.this.czX, n.this.czX.getString(R.string.d9p), "", n.this.czX.getString(R.string.d9q), n.this.czX.getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(34604);
                            com.tencent.mm.sdk.b.a.xxA.m(new ot());
                            AppMethodBeat.o(34604);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(34605);
                            com.tencent.mm.sdk.b.a.xxA.m(new lh());
                            AppMethodBeat.o(34605);
                        }
                    });
                    AppMethodBeat.o(34606);
                }
            }, 500);
            nVar.czX.getIntent().putExtra("resend_fail_messages", false);
        }
        LauncherUI launcherUI = (LauncherUI) nVar.czX;
        if (launcherUI != null) {
            launcherUI.getHomeUI().setTitleBarDoubleClickListener(nVar.zky);
        }
        if (w.a(nVar.czX.getIntent(), "Main_ListToTop", false) && nVar.zuW != null) {
            nVar.zuW.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34592);
                    if (!n.this.czX.isFinishing()) {
                        n.this.zuW.setSelection(0);
                    }
                    AppMethodBeat.o(34592);
                }
            });
        }
        w.b(nVar.czX.getIntent(), "Main_ListToTop", false);
        k kVar = this.zva;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabResume tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = kVar.ehJ == null ? -1 : kVar.ehJ.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(kVar.dIP());
        ab.i(str, str2, objArr);
        kVar.dIN();
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34473);
                k.d(k.this);
                AppMethodBeat.o(34473);
            }
        }, 100);
        if (aw.RK() && !this.zva.dIQ()) {
            com.tencent.mm.sdk.b.a.xxA.a(new st(), Looper.getMainLooper());
            com.tencent.mm.sdk.b.b sdVar = new sd();
            sdVar.cOe.action = 4;
            com.tencent.mm.sdk.b.a.xxA.a(sdVar, com.tencent.mm.sdk.g.d.xDG.cin());
        }
        AppMethodBeat.o(34517);
    }

    public final void dwa() {
        AppMethodBeat.i(34518);
        ab.i("MicroMsg.MainUI", "onTabStart");
        AppMethodBeat.o(34518);
    }

    public final void dwb() {
        AppMethodBeat.i(34519);
        ab.i("MicroMsg.MainUI", "onTabPause");
        com.tencent.mm.blink.b.HQ().o(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34493);
                a d = MainUI.this.zuL;
                ab.i("MicroMsg.BannerHelper", "releaseBanner");
                a.fv(d.zqr);
                a.fv(d.zqs);
                a.fv(d.zqt);
                a.fv(d.zqu);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : d.zqv) {
                    if (bVar != null) {
                        bVar.release();
                    }
                }
                if (aw.RK()) {
                    com.tencent.mm.ah.o.acd().e(d);
                }
                if (aw.RK()) {
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().b(d);
                }
                AppMethodBeat.o(34493);
            }
        });
        k kVar = this.zva;
        if (kVar.wakeLock.isHeld()) {
            ab.w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
            kVar.wakeLock.release();
        }
        hideVKB();
        n nVar = this.zvc;
        if (com.tencent.mm.bg.g.fUs != null) {
            com.tencent.mm.bg.g.fUs.b(nVar);
        }
        m.dIW();
        LauncherUI launcherUI = (LauncherUI) nVar.czX;
        if (launcherUI != null) {
            launcherUI.getHomeUI().aw(nVar.zky);
        }
        dIU();
        AppMethodBeat.o(34519);
    }

    public final void dwc() {
        AppMethodBeat.i(34520);
        ab.i("MicroMsg.MainUI", "onTabStop");
        AppMethodBeat.o(34520);
    }

    public final void dwd() {
        AppMethodBeat.i(34521);
        ab.i("MicroMsg.MainUI", "onTabDestroy  acc:%b", Boolean.valueOf(aw.RK()));
        com.tencent.mm.blink.b.HQ().o(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34494);
                a d = MainUI.this.zuL;
                ab.i("MicroMsg.BannerHelper", "destroyBanner");
                a.fw(d.zqr);
                a.fw(d.zqs);
                a.fw(d.zqt);
                a.fw(d.zqu);
                for (com.tencent.mm.pluginsdk.ui.b.b bVar : d.zqv) {
                    if (bVar != null) {
                        bVar.destroy();
                    }
                }
                aw.b(d.qbK);
                com.tencent.mm.sdk.b.a.xxA.d(d.zqx);
                com.tencent.mm.sdk.b.a.xxA.d(d.zqy);
                if (aw.RK()) {
                    aw.ZK();
                    com.tencent.mm.model.c.b(d);
                }
                d.context = null;
                AppMethodBeat.o(34494);
            }
        });
        com.tencent.mm.ai.f fVar = this.zva;
        fVar.zuP.unlock();
        aw.Rg().b(-1, fVar);
        if (fVar.ehJ != null) {
            fVar.ehJ.dismiss();
            fVar.ehJ = null;
        }
        com.tencent.mm.sdk.b.a.xxA.d(fVar.zuN);
        com.tencent.mm.sdk.b.a.xxA.d(fVar.zuO);
        n nVar = this.zvc;
        if (nVar.kTz != null) {
            com.tencent.mm.sdk.b.a.xxA.d(nVar.kTz);
            nVar.kTz = null;
        }
        com.tencent.mm.sdk.b.a.xxA.d(nVar.zvz);
        com.tencent.mm.sdk.b.a.xxA.d(nVar.zvA);
        if (com.tencent.mm.bg.g.fUs != null) {
            com.tencent.mm.bg.g.fUs.b(nVar);
        }
        if (aw.RK()) {
            com.tencent.mm.platformtools.ah.anV();
        }
        d dVar = this.zvb;
        com.tencent.mm.sdk.b.a.xxA.d(dVar.zrg);
        com.tencent.mm.sdk.b.a.xxA.d(dVar.zre);
        com.tencent.mm.sdk.b.a.xxA.d(dVar.zrf);
        dVar.activity = null;
        if (aw.RK() && this.zrd != null) {
            aw.ZK();
            com.tencent.mm.model.c.XR().b(this.zrd);
            aw.ZK();
            com.tencent.mm.model.c.XM().b(this.zrd);
        }
        if (this.zrd != null) {
            h hVar = this.zrd;
            if (hVar.zrt != null) {
                com.tencent.mm.sdk.b.a.xxA.d(hVar.zrt);
                hVar.zrt = null;
            }
            this.zrd.ztz = null;
            h hVar2 = this.zrd;
            hVar2.ztz = null;
            if (hVar2.yDY != null) {
                hVar2.yDY.clear();
                hVar2.yDY = null;
            }
            hVar2.pB(true);
            hVar2.dww();
            hVar2.ztC.clear();
            com.tencent.mm.plugin.forcenotify.a.b bVar = (com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class);
            if (!(bVar == null || bVar.bxV() == null)) {
                bVar.bxV().d(hVar2.yql);
            }
            ab.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        }
        AppMethodBeat.o(34521);
    }

    public final void dwf() {
        AppMethodBeat.i(34522);
        ab.i("MicroMsg.MainUI", "turn to bg");
        AppMethodBeat.o(34522);
    }

    public final void dwg() {
        AppMethodBeat.i(34523);
        ab.i("MicroMsg.MainUI", "turn to fg");
        AppMethodBeat.o(34523);
    }

    public final void dwe() {
    }

    public final void dxc() {
        AppMethodBeat.i(34524);
        ab.i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
        k kVar = this.zva;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabSwitchIn tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = kVar.ehJ == null ? -1 : kVar.ehJ.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(kVar.dIP());
        ab.i(str, str2, objArr);
        if (kVar.wakeLock != null) {
            kVar.dIN();
        }
        if (this.mController != null) {
            this.mController.onResume();
        }
        AppMethodBeat.o(34524);
    }

    public final void dxd() {
        AppMethodBeat.i(34525);
        ab.i("MicroMsg.MainUI", "onTabSwitchOut");
        AppMethodBeat.o(34525);
    }

    public void onDestroy() {
        AppMethodBeat.i(34526);
        ab.i("MicroMsg.MainUI", "onDestroy");
        this.zvd.dIV();
        if (this.zuW != null) {
            ConversationListView conversationListView = this.zuW;
            if (conversationListView.iVo != null) {
                conversationListView.iVo.onDestroy();
            }
            if (conversationListView.zrY != null) {
                conversationListView.zrY.onDestroy();
            }
            if (conversationListView.zsq != null) {
                conversationListView.removeCallbacks(conversationListView.zsq);
            }
            if (conversationListView.zsp != null) {
                conversationListView.removeCallbacks(conversationListView.zsp);
            }
            if (conversationListView.zso != null) {
                conversationListView.removeCallbacks(conversationListView.zso);
            }
        }
        super.onDestroy();
        AppMethodBeat.o(34526);
    }

    public final void dIR() {
        if (this.zrd != null) {
            this.zrd.nNp = true;
        }
    }

    public final void dIS() {
        AppMethodBeat.i(34527);
        if (this.zrd != null) {
            this.zrd.nNp = false;
            this.zrd.dIH();
            if (thisActivity() != null) {
                this.zvb.ax(getActivity());
            }
        }
        AppMethodBeat.o(34527);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(34528);
        boolean onKeyDown;
        if (i != 4 || keyEvent.getAction() != 0) {
            onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(34528);
            return onKeyDown;
        } else if (this.zuW == null || !this.zuW.dIv()) {
            onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(34528);
            return onKeyDown;
        } else {
            ConversationListView conversationListView = this.zuW;
            ab.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d", Long.valueOf(10), Integer.valueOf(11));
            if (conversationListView.getFirstVisiblePosition() == 0) {
                if (10 > 0) {
                    if (conversationListView.zsp != null) {
                        conversationListView.removeCallbacks(conversationListView.zsp);
                    }
                    conversationListView.zsp = new Runnable() {
                        final /* synthetic */ int bVv = 11;

                        public final void run() {
                            AppMethodBeat.i(34215);
                            ConversationListView conversationListView = ConversationListView.this;
                            int i = this.bVv;
                            if (conversationListView.zrY != null) {
                                conversationListView.zrY.qh(i);
                            }
                            AppMethodBeat.o(34215);
                        }
                    };
                    conversationListView.postDelayed(conversationListView.zsp, 10);
                } else {
                    conversationListView.setSelection(0);
                }
            }
            AppMethodBeat.o(34528);
            return true;
        }
    }

    /* JADX WARNING: Missing block: B:11:0x0045, code skipped:
            if (r2.m(r2.zqu, false) == false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(MainUI mainUI, int i) {
        int i2 = 1;
        AppMethodBeat.i(34529);
        if (i <= 0) {
            a aVar = mainUI.zuL;
            if (aVar.context != null) {
                ab.i("MicroMsg.BannerHelper", "checkBannerEmpyt %d", Integer.valueOf(aVar.hashCode()));
                if (!aVar.m(aVar.zqr, false)) {
                    if (!aVar.m(aVar.zqs, false)) {
                        if (!aVar.m(aVar.zqt, false)) {
                        }
                    }
                }
            }
            i2 = 0;
            if (i2 != 0) {
                mainUI.zuZ.setVisibility(0);
                mainUI.zuW.setVisibility(8);
            }
        }
        mainUI.zuW.setVisibility(0);
        mainUI.zuZ.setVisibility(8);
        AppMethodBeat.o(34529);
    }
}
