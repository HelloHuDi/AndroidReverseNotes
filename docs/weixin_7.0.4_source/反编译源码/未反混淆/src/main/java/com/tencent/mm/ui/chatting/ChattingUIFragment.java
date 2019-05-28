package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.a.a;
import com.tencent.mm.ui.chatting.c.b.af;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.c.b.t;
import com.tencent.mm.ui.chatting.c.b.v;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.f.b;
import com.tencent.mm.ui.chatting.f.e;
import com.tencent.mm.ui.chatting.view.MMChattingListView;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.tools.n;
import com.tencent.mm.ui.widget.SwipeBackLayout;

@SuppressLint({"ValidFragment"})
public class ChattingUIFragment extends BaseChattingUIFragment {
    public static String xIj;
    private int mScrollState = 0;
    private p tipDialog = null;
    public a yLk;
    ListView yLl;
    private Runnable yLm;
    private MMChattingListView yLn;
    private boolean yLo = true;
    protected boolean yLp = true;
    private boolean yLq = false;
    private boolean yLr = false;
    private int yLs = 0;
    private final int yLt = 10;
    private com.tencent.mm.ui.chatting.l.a.a yLu;

    static /* synthetic */ void f(ChattingUIFragment chattingUIFragment) {
        AppMethodBeat.i(30903);
        super.finish();
        AppMethodBeat.o(30903);
    }

    @SuppressLint({"ValidFragment"})
    public ChattingUIFragment(byte b) {
        super((byte) 0);
    }

    public void dealContentView(View view) {
        AppMethodBeat.i(30845);
        super.dealContentView(view);
        ((r) this.cgL.aF(r.class)).eM(view);
        AppMethodBeat.o(30845);
    }

    public void setMMTitle(int i) {
        AppMethodBeat.i(30846);
        setMMTitle(getMMString(i));
        AppMethodBeat.o(30846);
    }

    public void setMMSubTitle(int i) {
        AppMethodBeat.i(30849);
        setMMSubTitle(getMMString(i));
        AppMethodBeat.o(30849);
    }

    public final void aWv() {
        AppMethodBeat.i(30851);
        if (this.yLk == null) {
            AppMethodBeat.o(30851);
            return;
        }
        this.yLk.notifyDataSetChanged();
        AppMethodBeat.o(30851);
    }

    public final void dCx() {
        boolean z;
        AppMethodBeat.i(30852);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        } else {
            z = false;
        }
        aj(false, z);
        AppMethodBeat.o(30852);
    }

    public final void qp(boolean z) {
        AppMethodBeat.i(30853);
        aj(z, Looper.myLooper() != Looper.getMainLooper());
        AppMethodBeat.o(30853);
    }

    @Deprecated
    public final void aj(final boolean z, boolean z2) {
        AppMethodBeat.i(30854);
        if (z2) {
            com.tencent.mm.ui.chatting.d.a.dFz().removeCallbacks(this.yLm);
            ak dFz = com.tencent.mm.ui.chatting.d.a.dFz();
            AnonymousClass1 anonymousClass1 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30829);
                    ChattingUIFragment.a(ChattingUIFragment.this, z);
                    AppMethodBeat.o(30829);
                }
            };
            this.yLm = anonymousClass1;
            dFz.postDelayed(anonymousClass1, 10);
            AppMethodBeat.o(30854);
            return;
        }
        qq(z);
        AppMethodBeat.o(30854);
    }

    private void qq(boolean z) {
        int i = 0;
        AppMethodBeat.i(30855);
        int lastVisiblePosition = this.yLl.getLastVisiblePosition();
        int firstVisiblePosition = this.yLl.getFirstVisiblePosition();
        final int count = this.yLl.getCount();
        ab.i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", Boolean.valueOf(this.yLo), Integer.valueOf(lastVisiblePosition), Integer.valueOf(firstVisiblePosition), Integer.valueOf(count), Boolean.valueOf(z));
        this.yLo = false;
        if (z && lastVisiblePosition == firstVisiblePosition && lastVisiblePosition >= count - 1 && this.yLl.getChildCount() > 0) {
            i = this.yLl.getChildAt(this.yLl.getChildCount() - 1).getHeight();
        }
        k.a(this.yLl, count - 1, -i, true);
        this.yLl.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30836);
                k.a(ChattingUIFragment.this.yLl, count - 1, -i, true);
                AppMethodBeat.o(30836);
            }
        });
        AppMethodBeat.o(30855);
    }

    public final void bY(final int i) {
        AppMethodBeat.i(30856);
        com.tencent.mm.ui.chatting.d.a.dFz().removeCallbacks(this.yLm);
        this.yLl.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30837);
                ab.i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", Integer.valueOf(i));
                n nVar = new n(ChattingUIFragment.this.yLl);
                int headerViewsCount = ChattingUIFragment.this.yLl.getHeaderViewsCount() + i;
                nVar.Ej.removeCallbacks(nVar);
                nVar.zGO = System.currentTimeMillis();
                nVar.zGT = 0;
                int firstVisiblePosition = nVar.Ej.getFirstVisiblePosition();
                int childCount = (nVar.Ej.getChildCount() + firstVisiblePosition) - 1;
                if (headerViewsCount <= firstVisiblePosition) {
                    firstVisiblePosition = (firstVisiblePosition - headerViewsCount) + 1;
                    nVar.mMode = 2;
                } else if (headerViewsCount >= childCount) {
                    firstVisiblePosition = (headerViewsCount - childCount) + 1;
                    nVar.mMode = 1;
                } else {
                    AppMethodBeat.o(30837);
                    return;
                }
                if (firstVisiblePosition > 0) {
                    nVar.zGR = 1000 / firstVisiblePosition;
                } else {
                    nVar.zGR = 1000;
                }
                nVar.zGP = headerViewsCount;
                nVar.zGQ = -1;
                nVar.Ej.post(nVar);
                AppMethodBeat.o(30837);
            }
        });
        AppMethodBeat.o(30856);
    }

    public final void dCy() {
        AppMethodBeat.i(30857);
        ab.i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", Integer.valueOf(0), Integer.valueOf(0));
        this.yLl.smoothScrollBy(0, 0);
        AppMethodBeat.o(30857);
    }

    public final void Oq(int i) {
        AppMethodBeat.i(30858);
        com.tencent.mm.ui.chatting.d.a.dFz().removeCallbacks(this.yLm);
        ab.i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", Integer.valueOf(i), Boolean.FALSE);
        ListView listView = this.yLl;
        if (listView != null) {
            ab.i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", Integer.valueOf(i), Boolean.FALSE);
            listView.setItemChecked(i, true);
            listView.setSelection(i);
        }
        AppMethodBeat.o(30858);
    }

    public final void ho(int i, int i2) {
        AppMethodBeat.i(30859);
        com.tencent.mm.ui.chatting.d.a.dFz().removeCallbacks(this.yLm);
        ab.i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.FALSE);
        k.a(this.yLl, i, i2, false);
        AppMethodBeat.o(30859);
    }

    public final void c(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.i(30861);
        dismissDialog();
        this.tipDialog = h.b(context, str, true, onCancelListener);
        AppMethodBeat.o(30861);
    }

    public final void dismissDialog() {
        AppMethodBeat.i(30862);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.o(30862);
    }

    public final int getFirstVisiblePosition() {
        AppMethodBeat.i(30876);
        int firstVisiblePosition = this.yLl.getFirstVisiblePosition();
        AppMethodBeat.o(30876);
        return firstVisiblePosition;
    }

    public int getLayoutId() {
        return R.layout.l2;
    }

    public boolean isSupportCustomActionBar() {
        AppMethodBeat.i(30878);
        boolean isSupportNavigationSwipeBack = isSupportNavigationSwipeBack();
        AppMethodBeat.o(30878);
        return isSupportNavigationSwipeBack;
    }

    /* Access modifiers changed, original: protected|final */
    public final void ac(ad adVar) {
        AppMethodBeat.i(30879);
        super.ac(adVar);
        xIj = adVar.field_username;
        AppMethodBeat.o(30879);
    }

    public final void hR(Context context) {
        AppMethodBeat.i(30880);
        super.hR(context);
        ab.i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), bo.gU(thisActivity()), Integer.valueOf(hashCode()));
        if (this.mController != null) {
            this.mController.aC(3, true);
        }
        AppMethodBeat.o(30880);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dBq() {
        int i;
        String str;
        ad aoO;
        AppMethodBeat.i(30881);
        this.yLr = false;
        this.yLo = true;
        this.yLp = true;
        ab.d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
        boolean z = this.cgL.sRl == null;
        ab.i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", this.cgL.getTalkerUserName(), getStringExtra("Chat_User"));
        String stringExtra = getStringExtra("Chat_User");
        aw.ZK();
        ad aoO2 = c.XM().aoO(stringExtra);
        String str2 = "MicroMsg.ChattingUIFragment";
        String str3 = "protectContactNotExist raw:%s contact:%d username:%s";
        Object[] objArr = new Object[3];
        objArr[0] = stringExtra;
        if (aoO2 == null) {
            i = -1;
        } else {
            i = (int) aoO2.ewQ;
        }
        objArr[1] = Integer.valueOf(i);
        if (aoO2 == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = aoO2.field_username;
        }
        objArr[2] = str;
        ab.w(str2, str3, objArr);
        if (aoO2 == null || ((int) aoO2.ewQ) == 0 || bo.isNullOrNil(aoO2.field_username)) {
            aoO2 = new ad();
            aoO2.setUsername(stringExtra);
            aoO2.xXc = stringExtra;
            aoO2.NC();
            aoO2.hz(3);
            aw.ZK();
            c.XM().Y(aoO2);
            aw.ZK();
            aoO = c.XM().aoO(stringExtra);
            if (aoO == null) {
                ab.e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
                aoO = aoO2;
            }
            if (ad.mR(stringExtra)) {
                ab.i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(stringExtra)));
                aoO.xXc = stringExtra;
                aoO.setUsername(stringExtra);
            }
        } else {
            aoO = aoO2;
            if (ad.mR(stringExtra)) {
            }
        }
        ac(aoO);
        super.dBq();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(true);
            getSwipeBackLayout().init();
        }
        if (z) {
            com.tencent.mm.ui.chatting.d.a.dFz().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30838);
                    ((r) ChattingUIFragment.this.cgL.aF(r.class)).dEn();
                    ((r) ChattingUIFragment.this.cgL.aF(r.class)).dEm();
                    AppMethodBeat.o(30838);
                }
            });
        }
        dBs();
        AppMethodBeat.o(30881);
    }

    public void dBr() {
        boolean isShown;
        boolean z;
        AppMethodBeat.i(30882);
        super.dBr();
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(R.color.y9);
        }
        boolean isShown2 = getContentView() != null ? getContentView().isShown() : false;
        if (getView() != null) {
            isShown = getView().isShown();
        } else {
            isShown = false;
        }
        if (this.yLl.getVisibility() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!this.cgL.caA) {
            ab.i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", Boolean.valueOf(isShown2), Boolean.valueOf(isShown), Boolean.valueOf(z));
            AppMethodBeat.o(30882);
        } else if (aw.RK()) {
            this.yLk.resume();
            AppMethodBeat.o(30882);
        } else {
            ab.w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
            finish();
            AppMethodBeat.o(30882);
        }
    }

    public void dBt() {
        AppMethodBeat.i(30883);
        super.dBt();
        q.dismiss();
        ab.i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", this.cgL.getTalkerUserName());
        if (this.cgL.getTalkerUserName() == null) {
            AppMethodBeat.o(30883);
            return;
        }
        this.yLk.pause();
        hideVKB();
        ab.d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
        AppMethodBeat.o(30883);
    }

    public final void dBL() {
        AppMethodBeat.i(30884);
        super.dBL();
        if (this.cgL.getTalkerUserName() == null) {
            AppMethodBeat.o(30884);
        } else {
            AppMethodBeat.o(30884);
        }
    }

    public void onEnterBegin() {
        AppMethodBeat.i(30885);
        super.onEnterBegin();
        cch();
        AppMethodBeat.o(30885);
    }

    public final void onExitBegin() {
        AppMethodBeat.i(30886);
        super.onExitBegin();
        a aVar = this.yLk;
        aVar.yNm = -1;
        aVar.yNl.clear();
        this.yLu.zae.cancel();
        cch();
        AppMethodBeat.o(30886);
    }

    public final void onExitEnd() {
        AppMethodBeat.i(30887);
        super.onExitEnd();
        dismissDialog();
        AppMethodBeat.o(30887);
    }

    public void onKeyboardStateChanged() {
        AppMethodBeat.i(30889);
        if (keyboardState() == 1) {
            this.yLl.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30840);
                    ChattingUIFragment.this.aj(true, false);
                    AppMethodBeat.o(30840);
                }
            });
        }
        AppMethodBeat.o(30889);
    }

    public final boolean dBP() {
        AppMethodBeat.i(30890);
        if (isScreenEnable()) {
            hideVKB();
            if (getActivity() != null) {
                View findViewById = getActivity().findViewById(R.id.bp);
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                    findViewById.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(30841);
                            ChattingUIFragment.this.dCE();
                            AppMethodBeat.o(30841);
                        }
                    });
                } else {
                    dCE();
                }
            }
            AppMethodBeat.o(30890);
        } else {
            ab.w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
            AppMethodBeat.o(30890);
        }
        return true;
    }

    public void onSwipeBack() {
        AppMethodBeat.i(30892);
        ab.w("MicroMsg.ChattingUIFragment", "onSwipeBack");
        dCF();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.o(30892);
    }

    public void onDragBegin() {
        AppMethodBeat.i(30893);
        if (isSupportNavigationSwipeBack() && this.yLk != null) {
            this.yLp = false;
        }
        AppMethodBeat.o(30893);
    }

    public void onCancelDrag() {
        AppMethodBeat.i(30894);
        if (isSupportNavigationSwipeBack() && this.yLk != null) {
            this.yLp = true;
        }
        AppMethodBeat.o(30894);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dCF() {
        AppMethodBeat.i(30895);
        dCG();
        d dVar = (d) this.cgL.aF(d.class);
        Intent intent;
        if (ad.aou(this.cgL.getTalkerUserName())) {
            intent = new Intent();
            intent.addFlags(67108864);
            com.tencent.mm.bp.d.b(getContext(), "tmessage", ".ui.TConversationUI", intent);
        } else if (getIntExtra("chat_from_scene", 0) == 4) {
            finish();
            AppMethodBeat.o(30895);
            return;
        } else if ((getIntExtra("chat_from_scene", 0) == 1 || getIntExtra("chat_from_scene", 0) == 3) && this.cgL.sRl != null && this.cgL.sRl.dsf() && dVar.dDj() != null && dVar.dDj().adQ() && dVar.dDj().cJ(false) != null && dVar.dDj().cJ(false).aer() != null && !bo.isNullOrNil(dVar.dDj().adX())) {
            finish();
            AppMethodBeat.o(30895);
            return;
        } else if (((t) this.cgL.aF(t.class)).dEF()) {
            finish();
        } else if (!getBooleanExtra("finish_direct", false).booleanValue()) {
            if (this.isCurrentActivity) {
                intent = new Intent(getContext(), LauncherUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                overridePendingTransition(MMFragmentActivity.a.yne, MMFragmentActivity.a.ynf);
                finish();
                AppMethodBeat.o(30895);
                return;
            }
            finish();
            AppMethodBeat.o(30895);
            return;
        }
        finish();
        AppMethodBeat.o(30895);
    }

    public void finish() {
        AppMethodBeat.i(30897);
        Object obj = 100;
        if (!hideVKB()) {
            obj = null;
        }
        AnonymousClass13 anonymousClass13 = new Runnable() {
            public final void run() {
                boolean z = true;
                AppMethodBeat.i(30843);
                ab.i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity));
                if (ChattingUIFragment.this.isCurrentActivity) {
                    ChattingUIFragment.f(ChattingUIFragment.this);
                    AppMethodBeat.o(30843);
                } else if (ChattingUIFragment.this.thisActivity() instanceof LauncherUI) {
                    LauncherUI launcherUI = (LauncherUI) ChattingUIFragment.this.thisActivity();
                    if (launcherUI != null) {
                        if (ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                            z = false;
                        }
                        launcherUI.closeChatting(z);
                        AppMethodBeat.o(30843);
                        return;
                    }
                    ab.e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
                    AppMethodBeat.o(30843);
                } else {
                    if (ChattingUIFragment.this.thisActivity() instanceof BaseConversationUI) {
                        BaseConversationUI baseConversationUI = (BaseConversationUI) ChattingUIFragment.this.thisActivity();
                        if (baseConversationUI != null) {
                            if (ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                                z = false;
                            }
                            baseConversationUI.closeChatting(z);
                        }
                    }
                    AppMethodBeat.o(30843);
                }
            }
        };
        if (obj == null) {
            anonymousClass13.run();
            AppMethodBeat.o(30897);
            return;
        }
        al.n(anonymousClass13, 100);
        AppMethodBeat.o(30897);
    }

    public final ListView getListView() {
        return this.yLl;
    }

    public final com.tencent.mm.ui.chatting.l.a.a dBQ() {
        return this.yLu;
    }

    public final void dBR() {
        AppMethodBeat.i(30898);
        if (this.yLn == null || this.yLk == null) {
            AppMethodBeat.o(30898);
            return;
        }
        b.a bVar;
        com.tencent.mm.ui.chatting.d.a aVar = this.cgL;
        com.tencent.mm.ui.chatting.f.a aVar2 = new com.tencent.mm.ui.chatting.f.a(this.yLk.yNj);
        b bVar2 = new b(this.cgL, this.yLn);
        e eVar = new e(bVar2, aVar2);
        if (((d) aVar.aF(d.class)).dDm()) {
            bVar = new com.tencent.mm.ui.chatting.l.a.b(aVar, eVar);
        } else if (((com.tencent.mm.ui.chatting.c.b.p) aVar.aF(com.tencent.mm.ui.chatting.c.b.p.class)).dEi()) {
            bVar = new com.tencent.mm.ui.chatting.l.a.c(aVar, eVar);
        } else if (((z) aVar.aF(z.class)).dEU() || ((z) aVar.aF(z.class)).dEV() || ((z) aVar.aF(z.class)).dES()) {
            bVar = new com.tencent.mm.ui.chatting.l.a.e(aVar, eVar);
        } else {
            bVar = new com.tencent.mm.ui.chatting.l.a.d(aVar, eVar);
        }
        bVar2.yYr = bVar;
        ab.i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", bVar.toString());
        this.yLu = bVar;
        this.yLk.yNt = this.yLu;
        this.yLn.setLoadExecutor(this.yLu);
        AppMethodBeat.o(30898);
    }

    /* Access modifiers changed, original: protected */
    public void dBs() {
        AppMethodBeat.i(30899);
        this.mScrollState = 0;
        this.yLn = (MMChattingListView) findViewById(R.id.alj);
        this.yLl = this.yLn.getListView();
        this.yLl.setVisibility(0);
        ((r) this.cgL.aF(r.class)).dEk();
        if (this.yLn.getBaseAdapter() == null) {
            this.yLk = new a(this.cgL, this.yLl);
            this.yLn.setAdapter(this.yLk);
        }
        MMChattingListView mMChattingListView = this.yLn;
        mMChattingListView.qd(false);
        mMChattingListView.qd(false);
        dBR();
        this.yLu.a(com.tencent.mm.ui.chatting.f.d.a.ACTION_ENTER, true, null);
        this.yLl.setOverScrollMode(2);
        if (((z) this.cgL.aF(z.class)).dES()) {
            this.yLl.setTranscriptMode(0);
        } else {
            this.yLl.setTranscriptMode(1);
        }
        this.yLl.setOnTouchListener(new OnTouchListener() {
            boolean jXS = false;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(30830);
                ChattingUIFragment.this.yLq = true;
                if (motionEvent.getAction() == 0) {
                    this.jXS = true;
                } else if (motionEvent.getAction() == 1) {
                    this.jXS = false;
                }
                if (this.jXS && ChattingUIFragment.this.yLp) {
                    o oVar = (o) ChattingUIFragment.this.cgL.aF(o.class);
                    if (oVar == null || oVar.dDX() == null) {
                        AppMethodBeat.o(30830);
                    } else {
                        oVar.dDX().u(0, -1, false);
                        AppMethodBeat.o(30830);
                    }
                } else {
                    AppMethodBeat.o(30830);
                }
                return false;
            }
        });
        this.yLl.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(30831);
                ChattingUIFragment.this.yHi.onScrollStateChanged(absListView, i);
                ChattingUIFragment.this.mScrollState = i;
                if (i == 0) {
                    ab.d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", Integer.valueOf(ChattingUIFragment.this.yLl.getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.this.yLl.getLastVisiblePosition()));
                    View childAt;
                    if (ChattingUIFragment.this.yLl.getFirstVisiblePosition() == 0) {
                        childAt = ChattingUIFragment.this.yLl.getChildAt(0);
                        if (childAt != null) {
                            if (childAt.getTop() == 0) {
                                ab.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
                                ChattingUIFragment.this.yLn.qc(true);
                            } else if (childAt.getTop() < 0) {
                                ab.w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
                                ChattingUIFragment.this.yLn.setAdapter(ChattingUIFragment.this.yLk);
                            }
                        }
                    } else if (ChattingUIFragment.this.yLl.getLastVisiblePosition() == ChattingUIFragment.this.yLl.getCount() - 1) {
                        childAt = ChattingUIFragment.this.yLl.getChildAt(ChattingUIFragment.this.yLl.getChildCount() - 1);
                        if (childAt != null && ChattingUIFragment.this.yLl.getBottom() - ChattingUIFragment.this.yLn.getBottomHeight() >= childAt.getBottom()) {
                            ab.i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
                            ChattingUIFragment.this.yLn.qd(true);
                        }
                    }
                    ChattingUIFragment.this.yLk.dD(ChattingUIFragment.this.yLl.getFirstVisiblePosition(), ChattingUIFragment.this.yLl.getLastVisiblePosition());
                }
                AppMethodBeat.o(30831);
            }

            public final synchronized void onScroll(AbsListView absListView, int i, int i2, int i3) {
                AppMethodBeat.i(30832);
                ChattingUIFragment.this.yHi.onScroll(absListView, i, i2, i3);
                if (ChattingUIFragment.this.yLr) {
                    if (ChattingUIFragment.this.yLl.getLastVisiblePosition() != i3 - 1) {
                        AppMethodBeat.o(30832);
                    } else {
                        ChattingUIFragment.this.yLr = false;
                    }
                }
                AppMethodBeat.o(30832);
            }
        });
        this.yLl.addOnLayoutChangeListener(new OnLayoutChangeListener() {
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AppMethodBeat.i(30833);
                ChattingUIFragment.this.yLk.dD(ChattingUIFragment.this.yLl.getFirstVisiblePosition(), ChattingUIFragment.this.yLl.getLastVisiblePosition());
                ChattingUIFragment.this.yLl.removeOnLayoutChangeListener(this);
                AppMethodBeat.o(30833);
            }
        });
        if (((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rW(2)) {
            com.tencent.mm.ui.chatting.d.a aVar = this.cgL;
            if (aVar != null) {
                ad adVar = aVar.sRl;
                if (adVar != null && adVar.dsf()) {
                    ((com.tencent.mm.plugin.brandservice.a.b) g.K(com.tencent.mm.plugin.brandservice.a.b.class)).rX(0);
                }
            }
        }
        registerForContextMenu(this.yLl);
        aj(false, true);
        AppMethodBeat.o(30899);
    }

    public void cch() {
        AppMethodBeat.i(30900);
        aw.RS().aa(new Runnable() {
            String username = ChattingUIFragment.this.cgL.getTalkerUserName();
            v yLw = ((v) ChattingUIFragment.this.cgL.aF(v.class));

            {
                AppMethodBeat.i(30834);
                AppMethodBeat.o(30834);
            }

            public final void run() {
                AppMethodBeat.i(30835);
                long currentTimeMillis = System.currentTimeMillis();
                if (this.yLw == null) {
                    ab.e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
                    AppMethodBeat.o(30835);
                    return;
                }
                this.yLw.arp(this.username);
                ab.i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(30835);
            }
        });
        AppMethodBeat.o(30900);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(30901);
        super.onActivityResult(i, i2, intent);
        if (i == 30763 || i == 30762) {
            switch (i) {
                case 30762:
                case 30763:
                    if (intent != null) {
                        Bundle bundleExtra = intent.getBundleExtra("result_data");
                        if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                            g.RP().Ry().set(ac.a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                            if (i != 30763) {
                                com.tencent.mm.pluginsdk.permission.b.b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 68);
                                break;
                            }
                            com.tencent.mm.pluginsdk.permission.b.b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 67);
                            AppMethodBeat.o(30901);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(30901);
            return;
        }
        AppMethodBeat.o(30901);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        AppMethodBeat.i(30844);
        if (this.cgL.caA) {
            super.onCreateOptionsMenu(menu, menuInflater);
            AppMethodBeat.o(30844);
            return;
        }
        AppMethodBeat.o(30844);
    }

    public void setMMTitle(String str) {
        AppMethodBeat.i(30847);
        ((r) this.cgL.aF(r.class)).M(str);
        AppMethodBeat.o(30847);
    }

    public void setMMSubTitle(String str) {
        AppMethodBeat.i(30848);
        ((r) this.cgL.aF(r.class)).setMMSubTitle(str);
        AppMethodBeat.o(30848);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.i(30850);
        ((r) this.cgL.aF(r.class)).setBackBtn(onMenuItemClickListener);
        AppMethodBeat.o(30850);
    }

    public boolean hideVKB() {
        AppMethodBeat.i(30860);
        ChatFooter dDX = ((o) this.cgL.aF(o.class)).dDX();
        boolean hideVKB;
        if (dDX != null) {
            hideVKB = dDX.hideVKB();
            AppMethodBeat.o(30860);
            return hideVKB;
        }
        hideVKB = super.hideVKB();
        AppMethodBeat.o(30860);
        return hideVKB;
    }

    public final void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(30863);
        this.yLl.setKeepScreenOn(z);
        AppMethodBeat.o(30863);
    }

    public final void setBottomViewVisible(boolean z) {
        AppMethodBeat.i(30864);
        this.yLn.setBottomViewVisible(z);
        AppMethodBeat.o(30864);
    }

    public final void dCz() {
        AppMethodBeat.i(30865);
        this.yLn.setTopViewVisible(true);
        AppMethodBeat.o(30865);
    }

    public final void dCA() {
        AppMethodBeat.i(30866);
        this.yLn.setIsTopShowAll(false);
        AppMethodBeat.o(30866);
    }

    public final void setIsBottomShowAll(boolean z) {
        AppMethodBeat.i(30867);
        this.yLn.setIsBottomShowAll(z);
        AppMethodBeat.o(30867);
    }

    public final void qd(boolean z) {
        AppMethodBeat.i(30868);
        this.yLn.qd(z);
        AppMethodBeat.o(30868);
    }

    public final void aw(Bundle bundle) {
        AppMethodBeat.i(30869);
        this.yLn.aw(bundle);
        AppMethodBeat.o(30869);
    }

    public final void dCB() {
        AppMethodBeat.i(30870);
        this.yLn.qc(false);
        AppMethodBeat.o(30870);
    }

    public final void ax(Bundle bundle) {
        AppMethodBeat.i(30871);
        this.yLn.a(true, bundle);
        AppMethodBeat.o(30871);
    }

    public final int getBottomHeight() {
        AppMethodBeat.i(30872);
        if (this.yLn == null) {
            AppMethodBeat.o(30872);
            return 0;
        }
        int bottomHeight = this.yLn.getBottomHeight();
        AppMethodBeat.o(30872);
        return bottomHeight;
    }

    public final int getTopHeight() {
        AppMethodBeat.i(30873);
        int topHeight = this.yLn.getTopHeight();
        AppMethodBeat.o(30873);
        return topHeight;
    }

    public final void Or(int i) {
        AppMethodBeat.i(30874);
        this.yLl.setVisibility(i);
        if (ab.getLogLevel() == 2) {
            ab.i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + i + " stack:" + bo.dpG().toString());
        }
        AppMethodBeat.o(30874);
    }

    public final void dCC() {
        AppMethodBeat.i(30875);
        this.yLl.setTranscriptMode(0);
        AppMethodBeat.o(30875);
    }

    public boolean getUserVisibleHint() {
        return this.cgL.caA;
    }

    public final com.tencent.mm.ui.r dBO() {
        AppMethodBeat.i(30877);
        if (this.cgL.aF(r.class) == null) {
            AppMethodBeat.o(30877);
            return null;
        }
        com.tencent.mm.ui.r dBO = ((r) this.cgL.aF(r.class)).dBO();
        AppMethodBeat.o(30877);
        return dBO;
    }

    public final void dCD() {
        AppMethodBeat.i(30888);
        z zVar = (z) this.cgL.aF(z.class);
        if (!(zVar.dES() || zVar.dEU() || zVar.dEV())) {
            int i = this.yLs;
            this.yLs = i + 1;
            if (i < 10 && ((thisActivity() instanceof ChattingUI) || (thisActivity() instanceof AppBrandServiceChattingUI))) {
                int i2;
                ListView listView = this.yLl;
                AnonymousClass9 anonymousClass9 = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(30839);
                        if (ChattingUIFragment.this.yLq || ChattingUIFragment.this.mScrollState != 0) {
                            ChattingUIFragment.this.yLs = 10;
                            ab.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", Boolean.valueOf(ChattingUIFragment.this.yLq), Integer.valueOf(ChattingUIFragment.this.mScrollState));
                            AppMethodBeat.o(30839);
                            return;
                        }
                        ab.i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", Integer.valueOf(ChattingUIFragment.this.yLs), Integer.valueOf(ChattingUIFragment.this.yLl.getLastVisiblePosition()), Integer.valueOf(ChattingUIFragment.this.yLl.getCount() - 1));
                        if (ChattingUIFragment.this.yLl.getLastVisiblePosition() < ChattingUIFragment.this.yLl.getCount() - 1) {
                            ChattingUIFragment.a(ChattingUIFragment.this, true);
                            ChattingUIFragment.this.dCD();
                            AppMethodBeat.o(30839);
                            return;
                        }
                        ChattingUIFragment.this.yLs = 10;
                        AppMethodBeat.o(30839);
                    }
                };
                if (this.yLs == 1) {
                    i2 = 10;
                } else {
                    i2 = 100;
                }
                listView.postDelayed(anonymousClass9, (long) i2);
                AppMethodBeat.o(30888);
                return;
            }
        }
        ab.d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", Boolean.valueOf(zVar.dES()), Boolean.valueOf(zVar.dEU()), Integer.valueOf(this.yLs));
        AppMethodBeat.o(30888);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dCE() {
        AppMethodBeat.i(30891);
        ((af) this.cgL.aF(af.class)).ax(new Runnable() {
            public final void run() {
                AppMethodBeat.i(30842);
                ChattingUIFragment.this.onExitBegin();
                if (ChattingUIFragment.this.isCurrentActivity || !ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                    ChattingUIFragment.this.dCF();
                    AppMethodBeat.o(30842);
                    return;
                }
                SwipeBackLayout swipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
                ab.i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", Boolean.valueOf(swipeBackLayout.zOp), Boolean.valueOf(swipeBackLayout.zOn), Boolean.valueOf(swipeBackLayout.zOo));
                if (!swipeBackLayout.dKR()) {
                    com.tencent.mm.ui.widget.h.bq(0.0f);
                    swipeBackLayout.zOp = true;
                    swipeBackLayout.zOo = false;
                    int width = (swipeBackLayout.WL.getWidth() + swipeBackLayout.zOk.getIntrinsicWidth()) + 10;
                    com.tencent.mm.ui.mogic.a aVar = swipeBackLayout.zOi;
                    aVar.SU = swipeBackLayout.WL;
                    aVar.mActivePointerId = -1;
                    aVar.b(width, 0, 0, 0, 320);
                    swipeBackLayout.invalidate();
                    if (swipeBackLayout.zOv != null) {
                        swipeBackLayout.zOv.onDrag();
                    }
                    com.tencent.mm.ui.widget.h.J(true, 0);
                }
                AppMethodBeat.o(30842);
            }
        });
        AppMethodBeat.o(30891);
    }

    private boolean dCG() {
        AppMethodBeat.i(30896);
        i iVar = (i) this.cgL.aF(i.class);
        z zVar = (z) this.cgL.aF(z.class);
        if (iVar.dDN()) {
            if (zVar.dEQ()) {
                zVar.dEP();
                iVar.dDO();
            } else {
                iVar.dDL();
            }
            AppMethodBeat.o(30896);
            return true;
        }
        AppMethodBeat.o(30896);
        return false;
    }
}
