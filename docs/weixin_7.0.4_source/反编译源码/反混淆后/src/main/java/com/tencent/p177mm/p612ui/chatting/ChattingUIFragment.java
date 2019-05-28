package com.tencent.p177mm.p612ui.chatting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.C7354r;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.chatting.p1089a.C30443a;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15613i;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15614o;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C23733z;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C30469p;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36135d;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40723af;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40725t;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C40726v;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C44299r;
import com.tencent.p177mm.p612ui.chatting.p617f.C36163e;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p617f.C5336b;
import com.tencent.p177mm.p612ui.chatting.p617f.C5336b.C5337a;
import com.tencent.p177mm.p612ui.chatting.p617f.C7338a;
import com.tencent.p177mm.p612ui.chatting.p622l.p623a.C17017a;
import com.tencent.p177mm.p612ui.chatting.p622l.p623a.C36198b;
import com.tencent.p177mm.p612ui.chatting.p622l.p623a.C40793c;
import com.tencent.p177mm.p612ui.chatting.p622l.p623a.C44311e;
import com.tencent.p177mm.p612ui.chatting.p622l.p623a.C46662d;
import com.tencent.p177mm.p612ui.chatting.view.MMChattingListView;
import com.tencent.p177mm.p612ui.conversation.BaseConversationUI;
import com.tencent.p177mm.p612ui.mogic.C5516a;
import com.tencent.p177mm.p612ui.tools.C24053n;
import com.tencent.p177mm.p612ui.widget.C5666h;
import com.tencent.p177mm.p612ui.widget.SwipeBackLayout;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.pluginsdk.p597ui.chat.ChatFooter;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C35897k;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;

@SuppressLint({"ValidFragment"})
/* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment */
public class ChattingUIFragment extends BaseChattingUIFragment {
    public static String xIj;
    private int mScrollState = 0;
    private C44275p tipDialog = null;
    public C30443a yLk;
    ListView yLl;
    private Runnable yLm;
    private MMChattingListView yLn;
    private boolean yLo = true;
    protected boolean yLp = true;
    private boolean yLq = false;
    private boolean yLr = false;
    private int yLs = 0;
    private final int yLt = 10;
    private C17017a yLu;

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$11 */
    class C530311 implements Runnable {
        C530311() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30841);
            ChattingUIFragment.this.dCE();
            AppMethodBeat.m2505o(30841);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$10 */
    class C1555610 implements Runnable {
        C1555610() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30840);
            ChattingUIFragment.this.mo56963aj(true, false);
            AppMethodBeat.m2505o(30840);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$13 */
    class C2368413 implements Runnable {
        C2368413() {
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.m2504i(30843);
            C4990ab.m7417i("MicroMsg.ChattingUIFragment", "[finish] isCurrentActivity:%s", Boolean.valueOf(ChattingUIFragment.this.isCurrentActivity));
            if (ChattingUIFragment.this.isCurrentActivity) {
                ChattingUIFragment.m59452f(ChattingUIFragment.this);
                AppMethodBeat.m2505o(30843);
            } else if (ChattingUIFragment.this.thisActivity() instanceof LauncherUI) {
                LauncherUI launcherUI = (LauncherUI) ChattingUIFragment.this.thisActivity();
                if (launcherUI != null) {
                    if (ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                        z = false;
                    }
                    launcherUI.closeChatting(z);
                    AppMethodBeat.m2505o(30843);
                    return;
                }
                C4990ab.m7412e("MicroMsg.ChattingUIFragment", "LauncherUI is null!???");
                AppMethodBeat.m2505o(30843);
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
                AppMethodBeat.m2505o(30843);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$4 */
    class C236854 implements OnLayoutChangeListener {
        C236854() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AppMethodBeat.m2504i(30833);
            ChattingUIFragment.this.yLk.mo48842dD(ChattingUIFragment.this.yLl.getFirstVisiblePosition(), ChattingUIFragment.this.yLl.getLastVisiblePosition());
            ChattingUIFragment.this.yLl.removeOnLayoutChangeListener(this);
            AppMethodBeat.m2505o(30833);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$12 */
    class C3043712 implements Runnable {
        C3043712() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30842);
            ChattingUIFragment.this.onExitBegin();
            if (ChattingUIFragment.this.isCurrentActivity || !ChattingUIFragment.this.isSupportNavigationSwipeBack()) {
                ChattingUIFragment.this.dCF();
                AppMethodBeat.m2505o(30842);
                return;
            }
            SwipeBackLayout swipeBackLayout = ChattingUIFragment.this.getSwipeBackLayout();
            C4990ab.m7417i("MicroMsg.SwipeBackLayout", "scrollToFinishActivity, Scrolling %B, hasTranslucent %B, hasCallPopOut %B", Boolean.valueOf(swipeBackLayout.zOp), Boolean.valueOf(swipeBackLayout.zOn), Boolean.valueOf(swipeBackLayout.zOo));
            if (!swipeBackLayout.dKR()) {
                C5666h.m8514bq(0.0f);
                swipeBackLayout.zOp = true;
                swipeBackLayout.zOo = false;
                int width = (swipeBackLayout.f1332WL.getWidth() + swipeBackLayout.zOk.getIntrinsicWidth()) + 10;
                C5516a c5516a = swipeBackLayout.zOi;
                c5516a.f1320SU = swipeBackLayout.f1332WL;
                c5516a.mActivePointerId = -1;
                c5516a.mo11138b(width, 0, 0, 0, 320);
                swipeBackLayout.invalidate();
                if (swipeBackLayout.zOv != null) {
                    swipeBackLayout.zOv.onDrag();
                }
                C5666h.m8511J(true, 0);
            }
            AppMethodBeat.m2505o(30842);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$5 */
    class C304385 implements Runnable {
        String username = ChattingUIFragment.this.cgL.getTalkerUserName();
        C40726v yLw = ((C40726v) ChattingUIFragment.this.cgL.mo74857aF(C40726v.class));

        C304385() {
            AppMethodBeat.m2504i(30834);
            AppMethodBeat.m2505o(30834);
        }

        public final void run() {
            AppMethodBeat.m2504i(30835);
            long currentTimeMillis = System.currentTimeMillis();
            if (this.yLw == null) {
                C4990ab.m7412e("MicroMsg.ChattingUIFragment", "messBoxComponent == null! without writeOpLogAndMarkRead!");
                AppMethodBeat.m2505o(30835);
                return;
            }
            this.yLw.arp(this.username);
            C4990ab.m7417i("MicroMsg.ChattingUIFragment", "ChattingUI writeOpLogAndMarkRead last : %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(30835);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$3 */
    class C361113 implements OnScrollListener {
        C361113() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            AppMethodBeat.m2504i(30831);
            ChattingUIFragment.this.yHi.onScrollStateChanged(absListView, i);
            ChattingUIFragment.this.mScrollState = i;
            if (i == 0) {
                C4990ab.m7411d("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] [%s:%s]", Integer.valueOf(ChattingUIFragment.this.yLl.getFirstVisiblePosition()), Integer.valueOf(ChattingUIFragment.this.yLl.getLastVisiblePosition()));
                View childAt;
                if (ChattingUIFragment.this.yLl.getFirstVisiblePosition() == 0) {
                    childAt = ChattingUIFragment.this.yLl.getChildAt(0);
                    if (childAt != null) {
                        if (childAt.getTop() == 0) {
                            C4990ab.m7416i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load top more!");
                            ChattingUIFragment.this.yLn.mo10809qc(true);
                        } else if (childAt.getTop() < 0) {
                            C4990ab.m7420w("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] exception auto load top more wit reset adapter!");
                            ChattingUIFragment.this.yLn.setAdapter(ChattingUIFragment.this.yLk);
                        }
                    }
                } else if (ChattingUIFragment.this.yLl.getLastVisiblePosition() == ChattingUIFragment.this.yLl.getCount() - 1) {
                    childAt = ChattingUIFragment.this.yLl.getChildAt(ChattingUIFragment.this.yLl.getChildCount() - 1);
                    if (childAt != null && ChattingUIFragment.this.yLl.getBottom() - ChattingUIFragment.this.yLn.getBottomHeight() >= childAt.getBottom()) {
                        C4990ab.m7416i("MicroMsg.ChattingUIFragment", "[onScrollStateChanged] auto load bottom more!");
                        ChattingUIFragment.this.yLn.mo10810qd(true);
                    }
                }
                ChattingUIFragment.this.yLk.mo48842dD(ChattingUIFragment.this.yLl.getFirstVisiblePosition(), ChattingUIFragment.this.yLl.getLastVisiblePosition());
            }
            AppMethodBeat.m2505o(30831);
        }

        public final synchronized void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(30832);
            ChattingUIFragment.this.yHi.onScroll(absListView, i, i2, i3);
            if (ChattingUIFragment.this.yLr) {
                if (ChattingUIFragment.this.yLl.getLastVisiblePosition() != i3 - 1) {
                    AppMethodBeat.m2505o(30832);
                } else {
                    ChattingUIFragment.this.yLr = false;
                }
            }
            AppMethodBeat.m2505o(30832);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$2 */
    class C361122 implements OnTouchListener {
        boolean jXS = false;

        C361122() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(30830);
            ChattingUIFragment.this.yLq = true;
            if (motionEvent.getAction() == 0) {
                this.jXS = true;
            } else if (motionEvent.getAction() == 1) {
                this.jXS = false;
            }
            if (this.jXS && ChattingUIFragment.this.yLp) {
                C15614o c15614o = (C15614o) ChattingUIFragment.this.cgL.mo74857aF(C15614o.class);
                if (c15614o == null || c15614o.dDX() == null) {
                    AppMethodBeat.m2505o(30830);
                } else {
                    c15614o.dDX().mo63995u(0, -1, false);
                    AppMethodBeat.m2505o(30830);
                }
            } else {
                AppMethodBeat.m2505o(30830);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$9 */
    class C361139 implements Runnable {
        C361139() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30839);
            if (ChattingUIFragment.this.yLq || ChattingUIFragment.this.mScrollState != 0) {
                ChattingUIFragment.this.yLs = 10;
                C4990ab.m7417i("MicroMsg.ChattingUIFragment", "scrollToLastProtect userTouched: %s state: %s", Boolean.valueOf(ChattingUIFragment.this.yLq), Integer.valueOf(ChattingUIFragment.this.mScrollState));
                AppMethodBeat.m2505o(30839);
                return;
            }
            C4990ab.m7417i("MicroMsg.ChattingUIFragment", "scrollToLastProtect tryScrollTimes : %s, lastvisible/total=%s/%s", Integer.valueOf(ChattingUIFragment.this.yLs), Integer.valueOf(ChattingUIFragment.this.yLl.getLastVisiblePosition()), Integer.valueOf(ChattingUIFragment.this.yLl.getCount() - 1));
            if (ChattingUIFragment.this.yLl.getLastVisiblePosition() < ChattingUIFragment.this.yLl.getCount() - 1) {
                ChattingUIFragment.m59447a(ChattingUIFragment.this, true);
                ChattingUIFragment.this.dCD();
                AppMethodBeat.m2505o(30839);
                return;
            }
            ChattingUIFragment.this.yLs = 10;
            AppMethodBeat.m2505o(30839);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.ChattingUIFragment$8 */
    class C361148 implements Runnable {
        C361148() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30838);
            ((C44299r) ChattingUIFragment.this.cgL.mo74857aF(C44299r.class)).dEn();
            ((C44299r) ChattingUIFragment.this.cgL.mo74857aF(C44299r.class)).dEm();
            AppMethodBeat.m2505o(30838);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m59452f(ChattingUIFragment chattingUIFragment) {
        AppMethodBeat.m2504i(30903);
        super.finish();
        AppMethodBeat.m2505o(30903);
    }

    @SuppressLint({"ValidFragment"})
    public ChattingUIFragment(byte b) {
        super((byte) 0);
    }

    public void dealContentView(View view) {
        AppMethodBeat.m2504i(30845);
        super.dealContentView(view);
        ((C44299r) this.cgL.mo74857aF(C44299r.class)).mo64265eM(view);
        AppMethodBeat.m2505o(30845);
    }

    public void setMMTitle(int i) {
        AppMethodBeat.m2504i(30846);
        setMMTitle(getMMString(i));
        AppMethodBeat.m2505o(30846);
    }

    public void setMMSubTitle(int i) {
        AppMethodBeat.m2504i(30849);
        setMMSubTitle(getMMString(i));
        AppMethodBeat.m2505o(30849);
    }

    public final void aWv() {
        AppMethodBeat.m2504i(30851);
        if (this.yLk == null) {
            AppMethodBeat.m2505o(30851);
            return;
        }
        this.yLk.notifyDataSetChanged();
        AppMethodBeat.m2505o(30851);
    }

    public final void dCx() {
        boolean z;
        AppMethodBeat.m2504i(30852);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        } else {
            z = false;
        }
        mo56963aj(false, z);
        AppMethodBeat.m2505o(30852);
    }

    /* renamed from: qp */
    public final void mo56982qp(boolean z) {
        AppMethodBeat.m2504i(30853);
        mo56963aj(z, Looper.myLooper() != Looper.getMainLooper());
        AppMethodBeat.m2505o(30853);
    }

    @Deprecated
    /* renamed from: aj */
    public final void mo56963aj(final boolean z, boolean z2) {
        AppMethodBeat.m2504i(30854);
        if (z2) {
            C46650a.dFz().removeCallbacks(this.yLm);
            C7306ak dFz = C46650a.dFz();
            C361101 c361101 = new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(30829);
                    ChattingUIFragment.m59447a(ChattingUIFragment.this, z);
                    AppMethodBeat.m2505o(30829);
                }
            };
            this.yLm = c361101;
            dFz.postDelayed(c361101, 10);
            AppMethodBeat.m2505o(30854);
            return;
        }
        m59457qq(z);
        AppMethodBeat.m2505o(30854);
    }

    /* renamed from: qq */
    private void m59457qq(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(30855);
        int lastVisiblePosition = this.yLl.getLastVisiblePosition();
        int firstVisiblePosition = this.yLl.getFirstVisiblePosition();
        final int count = this.yLl.getCount();
        C4990ab.m7417i("MicroMsg.ChattingUIFragment", "[scrollToLastImpl] isFirstScroll:%s [%s:%s] count:%s force:%s", Boolean.valueOf(this.yLo), Integer.valueOf(lastVisiblePosition), Integer.valueOf(firstVisiblePosition), Integer.valueOf(count), Boolean.valueOf(z));
        this.yLo = false;
        if (z && lastVisiblePosition == firstVisiblePosition && lastVisiblePosition >= count - 1 && this.yLl.getChildCount() > 0) {
            i = this.yLl.getChildAt(this.yLl.getChildCount() - 1).getHeight();
        }
        C35897k.m58842a(this.yLl, count - 1, -i, true);
        this.yLl.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(30836);
                C35897k.m58842a(ChattingUIFragment.this.yLl, count - 1, -i, true);
                AppMethodBeat.m2505o(30836);
            }
        });
        AppMethodBeat.m2505o(30855);
    }

    /* renamed from: bY */
    public final void mo56966bY(final int i) {
        AppMethodBeat.m2504i(30856);
        C46650a.dFz().removeCallbacks(this.yLm);
        this.yLl.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(30837);
                C4990ab.m7417i("MicroMsg.ChattingUIFragment", "[scrollToPosition] scroll to pos:%d", Integer.valueOf(i));
                C24053n c24053n = new C24053n(ChattingUIFragment.this.yLl);
                int headerViewsCount = ChattingUIFragment.this.yLl.getHeaderViewsCount() + i;
                c24053n.f4440Ej.removeCallbacks(c24053n);
                c24053n.zGO = System.currentTimeMillis();
                c24053n.zGT = 0;
                int firstVisiblePosition = c24053n.f4440Ej.getFirstVisiblePosition();
                int childCount = (c24053n.f4440Ej.getChildCount() + firstVisiblePosition) - 1;
                if (headerViewsCount <= firstVisiblePosition) {
                    firstVisiblePosition = (firstVisiblePosition - headerViewsCount) + 1;
                    c24053n.mMode = 2;
                } else if (headerViewsCount >= childCount) {
                    firstVisiblePosition = (headerViewsCount - childCount) + 1;
                    c24053n.mMode = 1;
                } else {
                    AppMethodBeat.m2505o(30837);
                    return;
                }
                if (firstVisiblePosition > 0) {
                    c24053n.zGR = 1000 / firstVisiblePosition;
                } else {
                    c24053n.zGR = 1000;
                }
                c24053n.zGP = headerViewsCount;
                c24053n.zGQ = -1;
                c24053n.f4440Ej.post(c24053n);
                AppMethodBeat.m2505o(30837);
            }
        });
        AppMethodBeat.m2505o(30856);
    }

    public final void dCy() {
        AppMethodBeat.m2504i(30857);
        C4990ab.m7417i("MicroMsg.ChattingUIFragment", "[smoothScrollBy] dis:%d duration:%d", Integer.valueOf(0), Integer.valueOf(0));
        this.yLl.smoothScrollBy(0, 0);
        AppMethodBeat.m2505o(30857);
    }

    /* renamed from: Oq */
    public final void mo56960Oq(int i) {
        AppMethodBeat.m2504i(30858);
        C46650a.dFz().removeCallbacks(this.yLm);
        C4990ab.m7417i("MicroMsg.ChattingUIFragment", "[setSelection] pos:%d isSmooth:%s", Integer.valueOf(i), Boolean.FALSE);
        ListView listView = this.yLl;
        if (listView != null) {
            C4990ab.m7417i("MicroMsg.ChattingUI.ScrollController", "setSelection position %s smooth %s", Integer.valueOf(i), Boolean.FALSE);
            listView.setItemChecked(i, true);
            listView.setSelection(i);
        }
        AppMethodBeat.m2505o(30858);
    }

    /* renamed from: ho */
    public final void mo56980ho(int i, int i2) {
        AppMethodBeat.m2504i(30859);
        C46650a.dFz().removeCallbacks(this.yLm);
        C4990ab.m7417i("MicroMsg.ChattingUIFragment", "[setSelectionFromTop] pos:%d offset:%s isSmooth:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.FALSE);
        C35897k.m58842a(this.yLl, i, i2, false);
        AppMethodBeat.m2505o(30859);
    }

    /* renamed from: c */
    public final void mo56967c(Context context, String str, OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(30861);
        dismissDialog();
        this.tipDialog = C30379h.m48458b(context, str, true, onCancelListener);
        AppMethodBeat.m2505o(30861);
    }

    public final void dismissDialog() {
        AppMethodBeat.m2504i(30862);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        AppMethodBeat.m2505o(30862);
    }

    public final int getFirstVisiblePosition() {
        AppMethodBeat.m2504i(30876);
        int firstVisiblePosition = this.yLl.getFirstVisiblePosition();
        AppMethodBeat.m2505o(30876);
        return firstVisiblePosition;
    }

    public int getLayoutId() {
        return 2130969011;
    }

    public boolean isSupportCustomActionBar() {
        AppMethodBeat.m2504i(30878);
        boolean isSupportNavigationSwipeBack = isSupportNavigationSwipeBack();
        AppMethodBeat.m2505o(30878);
        return isSupportNavigationSwipeBack;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: ac */
    public final void mo39462ac(C7616ad c7616ad) {
        AppMethodBeat.m2504i(30879);
        super.mo39462ac(c7616ad);
        xIj = c7616ad.field_username;
        AppMethodBeat.m2505o(30879);
    }

    /* renamed from: hR */
    public final void mo39485hR(Context context) {
        AppMethodBeat.m2504i(30880);
        super.mo39485hR(context);
        C4990ab.m7417i("MicroMsg.ChattingUIFragment", "[doAttach]:%s#0x%x task:%s hc:%d", thisActivity().getClass().getSimpleName(), Integer.valueOf(thisActivity().hashCode()), C5046bo.m7559gU(thisActivity()), Integer.valueOf(hashCode()));
        if (this.mController != null) {
            this.mController.mo11176aC(3, true);
        }
        AppMethodBeat.m2505o(30880);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dBq() {
        int i;
        String str;
        C7616ad aoO;
        AppMethodBeat.m2504i(30881);
        this.yLr = false;
        this.yLo = true;
        this.yLp = true;
        C4990ab.m7410d("MicroMsg.ChattingUIFragment", "isFromSearch  " + getBooleanExtra("finish_direct", false));
        boolean z = this.cgL.sRl == null;
        C4990ab.m7417i("MicroMsg.ChattingUIFragment", "[doCreate] rawUserName from :%s to :%s ", this.cgL.getTalkerUserName(), getStringExtra("Chat_User"));
        String stringExtra = getStringExtra("Chat_User");
        C9638aw.m17190ZK();
        C7616ad aoO2 = C18628c.m29078XM().aoO(stringExtra);
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
        C4990ab.m7421w(str2, str3, objArr);
        if (aoO2 == null || ((int) aoO2.ewQ) == 0 || C5046bo.isNullOrNil(aoO2.field_username)) {
            aoO2 = new C7616ad();
            aoO2.setUsername(stringExtra);
            aoO2.xXc = stringExtra;
            aoO2.mo16677NC();
            aoO2.mo14701hz(3);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo15701Y(aoO2);
            C9638aw.m17190ZK();
            aoO = C18628c.m29078XM().aoO(stringExtra);
            if (aoO == null) {
                C4990ab.m7412e("MicroMsg.ChattingUIFragment", "protectContactNotExist contact get from db is null!");
                aoO = aoO2;
            }
            if (C7616ad.m13548mR(stringExtra)) {
                C4990ab.m7416i("MicroMsg.ChattingUIFragment", "[protectContactNotExist] isBottleContact userName:".concat(String.valueOf(stringExtra)));
                aoO.xXc = stringExtra;
                aoO.setUsername(stringExtra);
            }
        } else {
            aoO = aoO2;
            if (C7616ad.m13548mR(stringExtra)) {
            }
        }
        mo39462ac(aoO);
        super.dBq();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(true);
            getSwipeBackLayout().init();
        }
        if (z) {
            C46650a.dFz().post(new C361148());
        }
        dBs();
        AppMethodBeat.m2505o(30881);
    }

    public void dBr() {
        boolean isShown;
        boolean z;
        AppMethodBeat.m2504i(30882);
        super.dBr();
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(C25738R.color.f12273y9);
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
            C4990ab.m7417i("MicroMsg.ChattingUIFragment", "onResume fragment not foreground, return,  chatting contentview is show %b, viewShow %b listviewShow:%b", Boolean.valueOf(isShown2), Boolean.valueOf(isShown), Boolean.valueOf(z));
            AppMethodBeat.m2505o(30882);
        } else if (C9638aw.m17179RK()) {
            this.yLk.resume();
            AppMethodBeat.m2505o(30882);
        } else {
            C4990ab.m7420w("MicroMsg.ChattingUIFragment", "account not ready, mabey not call onDestroy!!!");
            finish();
            AppMethodBeat.m2505o(30882);
        }
    }

    public void dBt() {
        AppMethodBeat.m2504i(30883);
        super.dBt();
        C23811q.dismiss();
        C4990ab.m7417i("MicroMsg.ChattingUIFragment", "on chatting ui pause  rawuser:%s", this.cgL.getTalkerUserName());
        if (this.cgL.getTalkerUserName() == null) {
            AppMethodBeat.m2505o(30883);
            return;
        }
        this.yLk.pause();
        hideVKB();
        C4990ab.m7410d("MicroMsg.ChattingUIFragment", "chattingui cancel pause auto download logic");
        AppMethodBeat.m2505o(30883);
    }

    public final void dBL() {
        AppMethodBeat.m2504i(30884);
        super.dBL();
        if (this.cgL.getTalkerUserName() == null) {
            AppMethodBeat.m2505o(30884);
        } else {
            AppMethodBeat.m2505o(30884);
        }
    }

    public void onEnterBegin() {
        AppMethodBeat.m2504i(30885);
        super.onEnterBegin();
        cch();
        AppMethodBeat.m2505o(30885);
    }

    public final void onExitBegin() {
        AppMethodBeat.m2504i(30886);
        super.onExitBegin();
        C30443a c30443a = this.yLk;
        c30443a.yNm = -1;
        c30443a.yNl.clear();
        this.yLu.zae.cancel();
        cch();
        AppMethodBeat.m2505o(30886);
    }

    public final void onExitEnd() {
        AppMethodBeat.m2504i(30887);
        super.onExitEnd();
        dismissDialog();
        AppMethodBeat.m2505o(30887);
    }

    public void onKeyboardStateChanged() {
        AppMethodBeat.m2504i(30889);
        if (keyboardState() == 1) {
            this.yLl.post(new C1555610());
        }
        AppMethodBeat.m2505o(30889);
    }

    public final boolean dBP() {
        AppMethodBeat.m2504i(30890);
        if (isScreenEnable()) {
            hideVKB();
            if (getActivity() != null) {
                View findViewById = getActivity().findViewById(2131820633);
                if (findViewById != null) {
                    findViewById.setVisibility(0);
                    findViewById.post(new C530311());
                } else {
                    dCE();
                }
            }
            AppMethodBeat.m2505o(30890);
        } else {
            C4990ab.m7420w("MicroMsg.ChattingUIFragment", "Actionbar customView onclick screen not enable");
            AppMethodBeat.m2505o(30890);
        }
        return true;
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(30892);
        C4990ab.m7420w("MicroMsg.ChattingUIFragment", "onSwipeBack");
        dCF();
        if (isSupportNavigationSwipeBack()) {
            getSwipeBackLayout().setEnableGesture(false);
        }
        AppMethodBeat.m2505o(30892);
    }

    public void onDragBegin() {
        AppMethodBeat.m2504i(30893);
        if (isSupportNavigationSwipeBack() && this.yLk != null) {
            this.yLp = false;
        }
        AppMethodBeat.m2505o(30893);
    }

    public void onCancelDrag() {
        AppMethodBeat.m2504i(30894);
        if (isSupportNavigationSwipeBack() && this.yLk != null) {
            this.yLp = true;
        }
        AppMethodBeat.m2505o(30894);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dCF() {
        AppMethodBeat.m2504i(30895);
        dCG();
        C36135d c36135d = (C36135d) this.cgL.mo74857aF(C36135d.class);
        Intent intent;
        if (C7616ad.aou(this.cgL.getTalkerUserName())) {
            intent = new Intent();
            intent.addFlags(67108864);
            C25985d.m41467b(getContext(), "tmessage", ".ui.TConversationUI", intent);
        } else if (getIntExtra("chat_from_scene", 0) == 4) {
            finish();
            AppMethodBeat.m2505o(30895);
            return;
        } else if ((getIntExtra("chat_from_scene", 0) == 1 || getIntExtra("chat_from_scene", 0) == 3) && this.cgL.sRl != null && this.cgL.sRl.dsf() && c36135d.dDj() != null && c36135d.dDj().adQ() && c36135d.dDj().mo30481cJ(false) != null && c36135d.dDj().mo30481cJ(false).aer() != null && !C5046bo.isNullOrNil(c36135d.dDj().adX())) {
            finish();
            AppMethodBeat.m2505o(30895);
            return;
        } else if (((C40725t) this.cgL.mo74857aF(C40725t.class)).dEF()) {
            finish();
        } else if (!getBooleanExtra("finish_direct", false).booleanValue()) {
            if (this.isCurrentActivity) {
                intent = new Intent(getContext(), LauncherUI.class);
                intent.addFlags(67108864);
                startActivity(intent);
                overridePendingTransition(C5206a.yne, C5206a.ynf);
                finish();
                AppMethodBeat.m2505o(30895);
                return;
            }
            finish();
            AppMethodBeat.m2505o(30895);
            return;
        }
        finish();
        AppMethodBeat.m2505o(30895);
    }

    public void finish() {
        AppMethodBeat.m2504i(30897);
        Object obj = 100;
        if (!hideVKB()) {
            obj = null;
        }
        C2368413 c2368413 = new C2368413();
        if (obj == null) {
            c2368413.run();
            AppMethodBeat.m2505o(30897);
            return;
        }
        C5004al.m7442n(c2368413, 100);
        AppMethodBeat.m2505o(30897);
    }

    public final ListView getListView() {
        return this.yLl;
    }

    public final C17017a dBQ() {
        return this.yLu;
    }

    public final void dBR() {
        AppMethodBeat.m2504i(30898);
        if (this.yLn == null || this.yLk == null) {
            AppMethodBeat.m2505o(30898);
            return;
        }
        C5337a c36198b;
        C46650a c46650a = this.cgL;
        C7338a c7338a = new C7338a(this.yLk.yNj);
        C5336b c5336b = new C5336b(this.cgL, this.yLn);
        C36163e c36163e = new C36163e(c5336b, c7338a);
        if (((C36135d) c46650a.mo74857aF(C36135d.class)).dDm()) {
            c36198b = new C36198b(c46650a, c36163e);
        } else if (((C30469p) c46650a.mo74857aF(C30469p.class)).dEi()) {
            c36198b = new C40793c(c46650a, c36163e);
        } else if (((C23733z) c46650a.mo74857aF(C23733z.class)).dEU() || ((C23733z) c46650a.mo74857aF(C23733z.class)).dEV() || ((C23733z) c46650a.mo74857aF(C23733z.class)).dES()) {
            c36198b = new C44311e(c46650a, c36163e);
        } else {
            c36198b = new C46662d(c46650a, c36163e);
        }
        c5336b.yYr = c36198b;
        C4990ab.m7417i("MicroMsg.ChattingLoader.ChattingDataPresenterFactory", "[ChattingDataPresenterFactory] executor:%s", c36198b.toString());
        this.yLu = c36198b;
        this.yLk.yNt = this.yLu;
        this.yLn.setLoadExecutor(this.yLu);
        AppMethodBeat.m2505o(30898);
    }

    /* Access modifiers changed, original: protected */
    public void dBs() {
        AppMethodBeat.m2504i(30899);
        this.mScrollState = 0;
        this.yLn = (MMChattingListView) findViewById(2131822378);
        this.yLl = this.yLn.getListView();
        this.yLl.setVisibility(0);
        ((C44299r) this.cgL.mo74857aF(C44299r.class)).dEk();
        if (this.yLn.getBaseAdapter() == null) {
            this.yLk = new C30443a(this.cgL, this.yLl);
            this.yLn.setAdapter(this.yLk);
        }
        MMChattingListView mMChattingListView = this.yLn;
        mMChattingListView.mo10810qd(false);
        mMChattingListView.mo10810qd(false);
        dBR();
        this.yLu.mo31088a(C40749a.ACTION_ENTER, true, null);
        this.yLl.setOverScrollMode(2);
        if (((C23733z) this.cgL.mo74857aF(C23733z.class)).dES()) {
            this.yLl.setTranscriptMode(0);
        } else {
            this.yLl.setTranscriptMode(1);
        }
        this.yLl.setOnTouchListener(new C361122());
        this.yLl.setOnScrollListener(new C361113());
        this.yLl.addOnLayoutChangeListener(new C236854());
        if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(2)) {
            C46650a c46650a = this.cgL;
            if (c46650a != null) {
                C7616ad c7616ad = c46650a.sRl;
                if (c7616ad != null && c7616ad.dsf()) {
                    ((C20023b) C1720g.m3528K(C20023b.class)).mo6759rX(0);
                }
            }
        }
        registerForContextMenu(this.yLl);
        mo56963aj(false, true);
        AppMethodBeat.m2505o(30899);
    }

    public void cch() {
        AppMethodBeat.m2504i(30900);
        C9638aw.m17180RS().mo10302aa(new C304385());
        AppMethodBeat.m2505o(30900);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(30901);
        super.onActivityResult(i, i2, intent);
        if (i == 30763 || i == 30762) {
            switch (i) {
                case 30762:
                case 30763:
                    if (intent != null) {
                        Bundle bundleExtra = intent.getBundleExtra("result_data");
                        if (bundleExtra != null && bundleExtra.getString("go_next", "").equals("gdpr_auth_location")) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_GDPR_LOCATION_PERMISSION_DESCRIBE_CONFIRM_BOOLEAN_SYNC, Boolean.TRUE);
                            if (i != 30763) {
                                C35805b.m58709b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 68);
                                break;
                            }
                            C35805b.m58709b(getActivity(), "android.permission.ACCESS_COARSE_LOCATION", 67);
                            AppMethodBeat.m2505o(30901);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(30901);
            return;
        }
        AppMethodBeat.m2505o(30901);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        AppMethodBeat.m2504i(30844);
        if (this.cgL.caA) {
            super.onCreateOptionsMenu(menu, menuInflater);
            AppMethodBeat.m2505o(30844);
            return;
        }
        AppMethodBeat.m2505o(30844);
    }

    public void setMMTitle(String str) {
        AppMethodBeat.m2504i(30847);
        ((C44299r) this.cgL.mo74857aF(C44299r.class)).mo64255M(str);
        AppMethodBeat.m2505o(30847);
    }

    public void setMMSubTitle(String str) {
        AppMethodBeat.m2504i(30848);
        ((C44299r) this.cgL.mo74857aF(C44299r.class)).setMMSubTitle(str);
        AppMethodBeat.m2505o(30848);
    }

    public void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.m2504i(30850);
        ((C44299r) this.cgL.mo74857aF(C44299r.class)).setBackBtn(onMenuItemClickListener);
        AppMethodBeat.m2505o(30850);
    }

    public boolean hideVKB() {
        AppMethodBeat.m2504i(30860);
        ChatFooter dDX = ((C15614o) this.cgL.mo74857aF(C15614o.class)).dDX();
        boolean hideVKB;
        if (dDX != null) {
            hideVKB = dDX.hideVKB();
            AppMethodBeat.m2505o(30860);
            return hideVKB;
        }
        hideVKB = super.hideVKB();
        AppMethodBeat.m2505o(30860);
        return hideVKB;
    }

    public final void setKeepScreenOn(boolean z) {
        AppMethodBeat.m2504i(30863);
        this.yLl.setKeepScreenOn(z);
        AppMethodBeat.m2505o(30863);
    }

    public final void setBottomViewVisible(boolean z) {
        AppMethodBeat.m2504i(30864);
        this.yLn.setBottomViewVisible(z);
        AppMethodBeat.m2505o(30864);
    }

    public final void dCz() {
        AppMethodBeat.m2504i(30865);
        this.yLn.setTopViewVisible(true);
        AppMethodBeat.m2505o(30865);
    }

    public final void dCA() {
        AppMethodBeat.m2504i(30866);
        this.yLn.setIsTopShowAll(false);
        AppMethodBeat.m2505o(30866);
    }

    public final void setIsBottomShowAll(boolean z) {
        AppMethodBeat.m2504i(30867);
        this.yLn.setIsBottomShowAll(z);
        AppMethodBeat.m2505o(30867);
    }

    /* renamed from: qd */
    public final void mo56981qd(boolean z) {
        AppMethodBeat.m2504i(30868);
        this.yLn.mo10810qd(z);
        AppMethodBeat.m2505o(30868);
    }

    /* renamed from: aw */
    public final void mo56964aw(Bundle bundle) {
        AppMethodBeat.m2504i(30869);
        this.yLn.mo64352aw(bundle);
        AppMethodBeat.m2505o(30869);
    }

    public final void dCB() {
        AppMethodBeat.m2504i(30870);
        this.yLn.mo10809qc(false);
        AppMethodBeat.m2505o(30870);
    }

    /* renamed from: ax */
    public final void mo56965ax(Bundle bundle) {
        AppMethodBeat.m2504i(30871);
        this.yLn.mo64351a(true, bundle);
        AppMethodBeat.m2505o(30871);
    }

    public final int getBottomHeight() {
        AppMethodBeat.m2504i(30872);
        if (this.yLn == null) {
            AppMethodBeat.m2505o(30872);
            return 0;
        }
        int bottomHeight = this.yLn.getBottomHeight();
        AppMethodBeat.m2505o(30872);
        return bottomHeight;
    }

    public final int getTopHeight() {
        AppMethodBeat.m2504i(30873);
        int topHeight = this.yLn.getTopHeight();
        AppMethodBeat.m2505o(30873);
        return topHeight;
    }

    /* renamed from: Or */
    public final void mo56961Or(int i) {
        AppMethodBeat.m2504i(30874);
        this.yLl.setVisibility(i);
        if (C4990ab.getLogLevel() == 2) {
            C4990ab.m7416i("MicroMsg.ChattingUIFragment", "[setListViewVisibility] visibility:" + i + " stack:" + C5046bo.dpG().toString());
        }
        AppMethodBeat.m2505o(30874);
    }

    public final void dCC() {
        AppMethodBeat.m2504i(30875);
        this.yLl.setTranscriptMode(0);
        AppMethodBeat.m2505o(30875);
    }

    public boolean getUserVisibleHint() {
        return this.cgL.caA;
    }

    public final C7354r dBO() {
        AppMethodBeat.m2504i(30877);
        if (this.cgL.mo74857aF(C44299r.class) == null) {
            AppMethodBeat.m2505o(30877);
            return null;
        }
        C7354r dBO = ((C44299r) this.cgL.mo74857aF(C44299r.class)).dBO();
        AppMethodBeat.m2505o(30877);
        return dBO;
    }

    public final void dCD() {
        AppMethodBeat.m2504i(30888);
        C23733z c23733z = (C23733z) this.cgL.mo74857aF(C23733z.class);
        if (!(c23733z.dES() || c23733z.dEU() || c23733z.dEV())) {
            int i = this.yLs;
            this.yLs = i + 1;
            if (i < 10 && ((thisActivity() instanceof ChattingUI) || (thisActivity() instanceof AppBrandServiceChattingUI))) {
                int i2;
                ListView listView = this.yLl;
                C361139 c361139 = new C361139();
                if (this.yLs == 1) {
                    i2 = 10;
                } else {
                    i2 = 100;
                }
                listView.postDelayed(c361139, (long) i2);
                AppMethodBeat.m2505o(30888);
                return;
            }
        }
        C4990ab.m7411d("MicroMsg.ChattingUIFragment", "scrollToLastProtect:%s, %s ,%s", Boolean.valueOf(c23733z.dES()), Boolean.valueOf(c23733z.dEU()), Integer.valueOf(this.yLs));
        AppMethodBeat.m2505o(30888);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dCE() {
        AppMethodBeat.m2504i(30891);
        ((C40723af) this.cgL.mo74857aF(C40723af.class)).mo41851ax(new C3043712());
        AppMethodBeat.m2505o(30891);
    }

    private boolean dCG() {
        AppMethodBeat.m2504i(30896);
        C15613i c15613i = (C15613i) this.cgL.mo74857aF(C15613i.class);
        C23733z c23733z = (C23733z) this.cgL.mo74857aF(C23733z.class);
        if (c15613i.dDN()) {
            if (c23733z.dEQ()) {
                c23733z.dEP();
                c15613i.dDO();
            } else {
                c15613i.dDL();
            }
            AppMethodBeat.m2505o(30896);
            return true;
        }
        AppMethodBeat.m2505o(30896);
        return false;
    }
}
