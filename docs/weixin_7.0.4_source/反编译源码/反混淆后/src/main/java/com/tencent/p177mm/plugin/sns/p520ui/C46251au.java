package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.widget.textview.C37873c;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.p230g.p231a.C26237rx;
import com.tencent.p177mm.p230g.p231a.C37752ke;
import com.tencent.p177mm.p230g.p231a.C9459ry;
import com.tencent.p177mm.p230g.p231a.C9461rz;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.p612ui.widget.p1095b.C24088a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.sns.abtest.C21865a;
import com.tencent.p177mm.plugin.sns.lucky.p1299ui.C29040a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C13413ap;
import com.tencent.p177mm.plugin.sns.model.C13413ap.C13414b;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p520ui.C4054bc.C4063a;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.item.C13690i;
import com.tencent.p177mm.plugin.sns.p520ui.item.C13690i.C13697b;
import com.tencent.p177mm.plugin.sns.p520ui.item.C22125g;
import com.tencent.p177mm.plugin.sns.p520ui.item.C22125g.C13688a;
import com.tencent.p177mm.plugin.sns.p520ui.item.C29226f;
import com.tencent.p177mm.plugin.sns.p520ui.item.C29227h;
import com.tencent.p177mm.plugin.sns.p520ui.item.C29227h.C29228a;
import com.tencent.p177mm.plugin.sns.p520ui.item.C35126b;
import com.tencent.p177mm.plugin.sns.p520ui.item.C35129d;
import com.tencent.p177mm.plugin.sns.p520ui.item.C4078a;
import com.tencent.p177mm.plugin.sns.p520ui.item.C4078a.C4081a;
import com.tencent.p177mm.plugin.sns.p520ui.item.C41313c;
import com.tencent.p177mm.plugin.sns.p520ui.item.C41313c.C13687a;
import com.tencent.p177mm.plugin.sns.p520ui.item.C41314e;
import com.tencent.p177mm.plugin.sns.p520ui.item.C46258j;
import com.tencent.p177mm.plugin.sns.p520ui.p526d.C22089b;
import com.tencent.p177mm.plugin.sns.p520ui.widget.SnsCommentCollapseLayout;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.bav;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.ui.au */
public final class C46251au implements C43613x {
    public C46696j contextMenuHelper;
    public MMActivity crP;
    private ListView gKd;
    C4884c hAA;
    protected C7306ak handler = new C7306ak();
    public C24088a jMO;
    public C22089b qOL;
    protected int requestType = 0;
    protected HashMap<String, Integer> rhW = new HashMap();
    public OnTouchListener riQ;
    protected ScaleAnimation rpR;
    protected ScaleAnimation rpS;
    public C22067aq rpY;
    public boolean rps = false;
    C4884c rqA = new C435944();
    private int rqb = 0;
    public C13698j rqd;
    public C4054bc rqg;
    C4884c rqy = new C435933();
    C4884c rqz = new C220691();
    protected C43612w rxO;
    public C29220i rxP;
    protected LinkedList<SnsCommentCollapseLayout> rxQ = new LinkedList();
    public HashMap<Integer, WeakReference<View>> rxR = new HashMap();
    View rxS;
    public int rxT = -1;
    int rxU = 0;
    protected HashMap<Integer, View> rxV = new HashMap();
    public HashMap<String, String> rxW = new HashMap();
    private HashMap<Integer, Class<? extends BaseViewHolder>> rxX = new HashMap();
    public OnClickListener rxY;
    public OnClickListener rxZ;
    public OnClickListener rya;
    private HashMap<String, Boolean> ryb;
    private C29197c ryc;

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$a */
    public interface C13632a {
        boolean cud();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$1 */
    class C220691 extends C4884c<C9459ry> {
        C220691() {
            AppMethodBeat.m2504i(39399);
            this.xxI = C9459ry.class.getName().hashCode();
            AppMethodBeat.m2505o(39399);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39400);
            C9459ry c9459ry = (C9459ry) c4883b;
            if (c9459ry instanceof C9459ry) {
                if (c9459ry.cNT.type == 1) {
                    C46251au.m86606a(C46251au.this, c9459ry.cNT.f2863id);
                } else if (c9459ry.cNT.type == 2) {
                    C46251au.m86608b(C46251au.this, c9459ry.cNT.f2863id);
                }
            }
            AppMethodBeat.m2505o(39400);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$6 */
    class C220706 implements OnClickListener {
        C220706() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39408);
            if (view.getTag() instanceof BaseViewHolder) {
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                if (baseViewHolder == null) {
                    AppMethodBeat.m2505o(39408);
                    return;
                } else if (C46251au.this.rhW.containsKey(baseViewHolder.cwT) && ((Integer) C46251au.this.rhW.get(baseViewHolder.cwT)).equals(Integer.valueOf(1))) {
                    C46251au.this.rhW.put(baseViewHolder.cwT, Integer.valueOf(2));
                    C46251au.this.rxO.notifyDataSetChanged();
                    AppMethodBeat.m2505o(39408);
                    return;
                } else {
                    C46251au.this.rhW.put(baseViewHolder.cwT, Integer.valueOf(1));
                    if (baseViewHolder.mRR.getTop() < 0) {
                        C46251au.this.qOL.mo17688b(baseViewHolder.mRR, baseViewHolder.position, baseViewHolder.mRR.getTop(), baseViewHolder.rHz.getSpreadHeight());
                        AppMethodBeat.m2505o(39408);
                        return;
                    }
                    C46251au.this.rxO.notifyDataSetChanged();
                    AppMethodBeat.m2505o(39408);
                    return;
                }
            }
            AppMethodBeat.m2505o(39408);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$10 */
    class C2919310 implements AnimationListener {
        C2919310() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(39412);
            if (C46251au.this.rxS != null) {
                C46251au.this.rxS.clearAnimation();
                C46251au.this.rxS.setVisibility(8);
            }
            C46251au.this.rxS = null;
            AppMethodBeat.m2505o(39412);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$9 */
    class C291949 implements AnimationListener {
        boolean rrc = false;
        final /* synthetic */ LinearLayout rrd;
        final /* synthetic */ Runnable ryf;

        C291949(LinearLayout linearLayout, Runnable runnable) {
            this.rrd = linearLayout;
            this.ryf = runnable;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(39411);
            if (this.rrd != null) {
                this.rrd.setPressed(false);
            }
            if (!this.rrc) {
                this.rrc = true;
                if ((C46251au.this.crP instanceof C43609t) && ((C43609t) C46251au.this.crP).crO()) {
                    C46251au.this.rxO.notifyDataSetChanged();
                }
            }
            if (this.ryf != null) {
                this.ryf.run();
            }
            AppMethodBeat.m2505o(39411);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$b */
    public static class C29195b implements C9636a {
        int mPosition;
        C43612w ryg = null;

        /* renamed from: com.tencent.mm.plugin.sns.ui.au$b$1 */
        class C291961 implements Runnable {
            C291961() {
            }

            public final void run() {
                AppMethodBeat.m2504i(39413);
                if (C29195b.this.ryg.crQ() != null) {
                    C29195b.this.ryg.crQ().request(Integer.valueOf(C29195b.this.mPosition));
                }
                C29195b.this.ryg.notifyDataSetChanged();
                AppMethodBeat.m2505o(39413);
            }
        }

        public C29195b(C43612w c43612w, int i) {
            this.ryg = c43612w;
            this.mPosition = i;
        }

        /* renamed from: o */
        public final void mo6218o(String str, boolean z) {
            AppMethodBeat.m2504i(39414);
            if (z) {
                C1720g.m3537RQ();
                if (C1720g.m3534RN().mo5161QY()) {
                    C13373af.bCo().post(new C291961());
                }
            }
            AppMethodBeat.m2505o(39414);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$c */
    static class C29197c implements OnCreateContextMenuListener {
        private String czD;
        private bau qJh;
        private TimeLineObject rin;
        private C46236n ros;
        private View targetView;
        private String url;

        C29197c() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.m2504i(39415);
            Object tag = view.getTag();
            if (tag instanceof C13707q) {
                C13707q c13707q = (C13707q) tag;
                TimeLineObject timeLineObject = c13707q.rin;
                view.getContext();
                String ZJ = C46251au.m86604ZJ(timeLineObject.xfI.Url);
                if (ZJ == null || ZJ.length() == 0) {
                    AppMethodBeat.m2505o(39415);
                    return;
                }
                this.url = ZJ;
                this.czD = c13707q.cwT;
                this.targetView = view;
                this.qJh = timeLineObject.xfI.wbK.size() > 0 ? (bau) timeLineObject.xfI.wbK.get(0) : null;
                this.ros = C13373af.cnF().mo62918YT(this.czD);
                this.rin = timeLineObject;
                if (timeLineObject.xfI.wbJ == 10 || timeLineObject.xfI.wbJ == 13) {
                    AppMethodBeat.m2505o(39415);
                    return;
                }
                if (C25985d.afj("favorite")) {
                    switch (timeLineObject.xfI.wbJ) {
                        case 4:
                            contextMenu.add(0, 4, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        case 9:
                            contextMenu.add(0, 5, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        case 14:
                            contextMenu.add(0, 9, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                        default:
                            contextMenu.add(0, 3, 0, view.getContext().getString(C25738R.string.dcq));
                            break;
                    }
                }
                if (!(this.ros == null || this.ros.field_userName.equals(C13373af.cnk()))) {
                    contextMenu.add(0, 8, 0, view.getContext().getString(C25738R.string.aya));
                }
            }
            AppMethodBeat.m2505o(39415);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$7 */
    class C351077 implements OnClickListener {
        C351077() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39409);
            if (view.getParent() == null || !(view.getParent() instanceof SnsCommentCollapseLayout)) {
                AppMethodBeat.m2505o(39409);
            } else if (((SnsCommentCollapseLayout) view.getParent()).getTag() == null || !(((SnsCommentCollapseLayout) view.getParent()).getTag() instanceof C46922l)) {
                AppMethodBeat.m2505o(39409);
            } else {
                C46922l c46922l = (C46922l) ((SnsCommentCollapseLayout) view.getParent()).getTag();
                if (c46922l == null) {
                    AppMethodBeat.m2505o(39409);
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.putExtra("sns_text_show", c46922l.ncM);
                    intent.putExtra("sns_local_id", c46922l.ria);
                    intent.putExtra("sns_comment_buf", c46922l.qJj.toByteArray());
                    intent.setClass(C46251au.this.crP, SnsSingleTextViewUI.class);
                    C46251au.this.crP.startActivity(intent);
                    AppMethodBeat.m2505o(39409);
                } catch (IOException e) {
                    C4990ab.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", e, "commentCollapse click exception.", new Object[0]);
                    AppMethodBeat.m2505o(39409);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$2 */
    class C435922 extends C4884c<C37752ke> {
        C435922() {
            AppMethodBeat.m2504i(39401);
            this.xxI = C37752ke.class.getName().hashCode();
            AppMethodBeat.m2505o(39401);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39402);
            C37752ke c37752ke = (C37752ke) c4883b;
            if (c37752ke instanceof C37752ke) {
                switch (c37752ke.cFH.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        C46251au.this.rxO.notifyDataSetChanged();
                        break;
                }
            }
            AppMethodBeat.m2505o(39402);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$3 */
    class C435933 extends C4884c<C26237rx> {
        C435933() {
            AppMethodBeat.m2504i(39403);
            this.xxI = C26237rx.class.getName().hashCode();
            AppMethodBeat.m2505o(39403);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39404);
            C26237rx c26237rx = (C26237rx) c4883b;
            if (c26237rx instanceof C26237rx) {
                String str = c26237rx.cNR.f13666id;
                if (c26237rx.cNR.type == 1) {
                    C46251au.m86609c(C46251au.this, str);
                } else if (c26237rx.cNR.type == 2) {
                    C46251au.m86610d(C46251au.this, c26237rx.cNR.f13666id);
                }
            }
            AppMethodBeat.m2505o(39404);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$4 */
    class C435944 extends C4884c<C9461rz> {
        C435944() {
            AppMethodBeat.m2504i(39405);
            this.xxI = C9461rz.class.getName().hashCode();
            AppMethodBeat.m2505o(39405);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(39406);
            C9461rz c9461rz = (C9461rz) c4883b;
            if (c9461rz instanceof C9461rz) {
                String str = c9461rz.cNU.f2864id;
                if (c9461rz.cNU.type == 1) {
                    C46251au.m86611e(C46251au.this, str);
                } else if (c9461rz.cNU.type == 2) {
                    C46251au.m86612f(C46251au.this, str);
                }
            }
            AppMethodBeat.m2505o(39406);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$5 */
    class C435955 implements OnClickListener {
        C435955() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(39407);
            C4990ab.m7416i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
            C46251au.this.rxP.rhp = false;
            C21865a.clW();
            if (view.getTag() instanceof BaseViewHolder) {
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                if (baseViewHolder.timeLineObject != null && baseViewHolder.timeLineObject.xfI.wbJ == 21) {
                    bav bav = baseViewHolder.rfi;
                    if (!C1853r.m3846Yz().equals(baseViewHolder.timeLineObject.jBB) && (bav == null || bav.cRU == 0)) {
                        C29040a.m46131f(C46251au.this.crP, baseViewHolder.rHT.mo8755DT(0));
                        AppMethodBeat.m2505o(39407);
                        return;
                    }
                }
                if (C46251au.this.crP instanceof C43609t) {
                    ((C43609t) C46251au.this.crP).mo55688dM(view);
                }
                AppMethodBeat.m2505o(39407);
                return;
            }
            C4990ab.m7412e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
            AppMethodBeat.m2505o(39407);
        }
    }

    public final void ctW() {
        AppMethodBeat.m2504i(39416);
        this.rhW.clear();
        AppMethodBeat.m2505o(39416);
    }

    public final C43609t ctX() {
        if (this.crP instanceof C43609t) {
            return (C43609t) this.crP;
        }
        return null;
    }

    public final SnsCommentCollapseLayout ctY() {
        AppMethodBeat.m2504i(39417);
        SnsCommentCollapseLayout snsCommentCollapseLayout;
        if (this.rxQ.size() == 0) {
            snsCommentCollapseLayout = new SnsCommentCollapseLayout(this.crP);
            AppMethodBeat.m2505o(39417);
            return snsCommentCollapseLayout;
        }
        snsCommentCollapseLayout = (SnsCommentCollapseLayout) this.rxQ.removeFirst();
        AppMethodBeat.m2505o(39417);
        return snsCommentCollapseLayout;
    }

    /* renamed from: a */
    public final void mo74342a(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.m2504i(39418);
        this.rxQ.add(snsCommentCollapseLayout);
        AppMethodBeat.m2505o(39418);
    }

    public final boolean ctZ() {
        AppMethodBeat.m2504i(39419);
        if (this.rxQ != null) {
            this.rxQ.clear();
        }
        if (this.rxX != null) {
            this.rxX.clear();
        }
        C44089j.clearCache();
        C37873c.eNj.mo60602SN();
        AppMethodBeat.m2505o(39419);
        return true;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(39420);
        this.rxO.notifyDataSetChanged();
        AppMethodBeat.m2505o(39420);
    }

    public final void cua() {
        AppMethodBeat.m2504i(39421);
        this.rxO.crP();
        AppMethodBeat.m2505o(39421);
    }

    public C46251au(MMActivity mMActivity, ListView listView, C22089b c22089b, C29220i c29220i, final C43612w c43612w) {
        AppMethodBeat.m2504i(39422);
        this.rxX.put(Integer.valueOf(6), C29228a.class);
        this.rxX.put(Integer.valueOf(2), C13688a.class);
        this.rxX.put(Integer.valueOf(3), C13688a.class);
        this.rxX.put(Integer.valueOf(4), C13688a.class);
        this.rxX.put(Integer.valueOf(5), C13688a.class);
        this.rxX.put(Integer.valueOf(0), C13688a.class);
        this.rxX.put(Integer.valueOf(1), C13688a.class);
        this.rxX.put(Integer.valueOf(7), C13688a.class);
        this.rxX.put(Integer.valueOf(8), C13688a.class);
        this.rxX.put(Integer.valueOf(9), C13688a.class);
        this.rxX.put(Integer.valueOf(11), C13697b.class);
        this.rxX.put(Integer.valueOf(13), C4081a.class);
        this.rxX.put(Integer.valueOf(14), C13687a.class);
        this.rxX.put(Integer.valueOf(10), C13688a.class);
        this.rxX.put(Integer.valueOf(12), C13688a.class);
        this.rxY = new C435955();
        this.rxZ = new C220706();
        this.rya = new C351077();
        this.riQ = C5046bo.dpE();
        this.ryb = new HashMap();
        this.ryc = new C29197c();
        this.hAA = new C435922();
        this.rxO = c43612w;
        this.rxP = c29220i;
        C4990ab.m7410d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
        this.gKd = listView;
        C13373af.cnC();
        this.crP = mMActivity;
        this.qOL = c22089b;
        this.contextMenuHelper = new C46696j(mMActivity);
        this.jMO = new C24088a(mMActivity);
        this.rpY = new C22067aq(mMActivity);
        this.rpR = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rpR.setDuration(150);
        this.rpS = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rpS.setDuration(150);
        this.rqd = new C13698j(mMActivity, 0, c29220i.rhn);
        this.requestType = 10;
        this.rqg = new C4054bc(mMActivity, new C4063a() {
            public final void ctb() {
                AppMethodBeat.m2504i(39410);
                c43612w.notifyDataSetChanged();
                AppMethodBeat.m2505o(39410);
            }
        }, 0, c29220i.rhn);
        C4879a.xxA.mo10052c(this.hAA);
        AppMethodBeat.m2505o(39422);
    }

    public final void cub() {
        AppMethodBeat.m2504i(39423);
        int firstVisiblePosition = this.gKd.getFirstVisiblePosition() - this.gKd.getHeaderViewsCount();
        int lastVisiblePosition = this.gKd.getLastVisiblePosition() - this.gKd.getHeaderViewsCount();
        C4990ab.m7416i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + firstVisiblePosition + " " + lastVisiblePosition);
        int count = this.rxO.getCount();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition && i < count) {
            C46236n DP = mo74340DP(i);
            View view = (View) this.rxV.get(Integer.valueOf(i));
            if (view == null || DP == null || view.getTag() == null) {
                C4990ab.m7412e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
            } else {
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                C4990ab.m7416i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + baseViewHolder.position);
                baseViewHolder.rIu.mo63038a(baseViewHolder, i, DP);
            }
            i++;
        }
        AppMethodBeat.m2505o(39423);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public final View mo74353h(int i, View view) {
        Object view2;
        Throwable e;
        String cqA;
        ArrayList arrayList;
        C13414b c13414b;
        AppMethodBeat.m2504i(39424);
        C46236n DP = this.rxO.mo47320DP(i);
        TimeLineObject cqu = DP.cqu();
        int b = C46251au.m86607b(DP, true);
        BaseTimeLineItem baseTimeLineItem = null;
        BaseViewHolder baseViewHolder = null;
        if (view2 != null) {
            Object tag = view2.getTag(2131827902);
            if ((tag instanceof Integer ? ((Integer) tag).intValue() : -1) == b) {
                BaseViewHolder baseViewHolder2 = (BaseViewHolder) view2.getTag();
                baseTimeLineItem = baseViewHolder2.rIu;
                baseViewHolder = baseViewHolder2;
            }
        }
        if (baseViewHolder == null) {
            BaseTimeLineItem c41314e;
            switch (b) {
                case 0:
                    c41314e = new C41314e();
                    break;
                case 1:
                    c41314e = new C29226f();
                    break;
                case 2:
                    c41314e = new C22125g();
                    break;
                case 3:
                    c41314e = new C22125g();
                    break;
                case 4:
                    c41314e = new C22125g();
                    break;
                case 5:
                    c41314e = new C22125g();
                    break;
                case 6:
                    c41314e = new C29227h();
                    break;
                case 7:
                    c41314e = new C29226f();
                    break;
                case 8:
                    c41314e = new C29226f();
                    break;
                case 9:
                    c41314e = new C46258j();
                    break;
                case 10:
                    c41314e = new C35129d();
                    break;
                case 11:
                    c41314e = new C13690i();
                    break;
                case 12:
                    c41314e = new C35126b();
                    break;
                case 13:
                    c41314e = new C4078a();
                    break;
                case 14:
                    c41314e = new C41313c();
                    break;
                default:
                    c41314e = new C29226f();
                    break;
            }
            try {
                BaseViewHolder baseViewHolder3;
                if (this.rxX.get(Integer.valueOf(b)) != null) {
                    baseViewHolder3 = (BaseViewHolder) ((Class) this.rxX.get(Integer.valueOf(b))).newInstance();
                } else {
                    baseViewHolder3 = new C13688a();
                }
                try {
                    baseViewHolder3.rIu = c41314e;
                    baseViewHolder3.timeLineObject = cqu;
                    view2 = c41314e.mo63037a(this.crP, baseViewHolder3, b, this, DP);
                    view2.setTag(2131827902, Integer.valueOf(b));
                    baseViewHolder = baseViewHolder3;
                    baseTimeLineItem = c41314e;
                } catch (Exception e2) {
                    e = e2;
                    baseViewHolder = baseViewHolder3;
                    C4990ab.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", e, "create holder error", new Object[0]);
                    baseTimeLineItem = c41314e;
                    baseTimeLineItem.setIsFromMainTimeline(this.rps);
                    cqA = DP.cqA();
                    arrayList = new ArrayList();
                    if (C13413ap.coh().size() > 0) {
                    }
                    baseTimeLineItem.rHq = arrayList;
                    baseTimeLineItem.mo63039a(baseViewHolder, i, DP, cqu, b, this);
                    if (C13413ap.m21551db(DP.cqA(), 2)) {
                    }
                    this.rxV.put(Integer.valueOf(i), view2);
                    AppMethodBeat.m2505o(39424);
                    return view2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        baseTimeLineItem.setIsFromMainTimeline(this.rps);
        cqA = DP.cqA();
        arrayList = new ArrayList();
        if (C13413ap.coh().size() > 0) {
            for (String str : C13413ap.coh().keySet()) {
                if (str.startsWith(cqA)) {
                    c13414b = (C13414b) C13413ap.coh().get(str);
                    if (C13413ap.m21547c(c13414b)) {
                        arrayList.add(c13414b);
                    }
                }
            }
        }
        baseTimeLineItem.rHq = arrayList;
        baseTimeLineItem.mo63039a(baseViewHolder, i, DP, cqu, b, this);
        if (C13413ap.m21551db(DP.cqA(), 2)) {
            c13414b = C13413ap.m21540Ye(DP.cqA());
            if (DP.field_snsId == 0) {
                c13414b = new C13414b();
            }
            if (!c13414b.foa) {
                BaseTimeLineItem.m68246e(baseViewHolder);
            } else if (c13414b.aAR) {
                BaseTimeLineItem.m68247f(baseViewHolder);
                C13413ap.m21550da(c13414b.f2919id, 2);
            } else {
                BaseTimeLineItem.m68240a(c13414b, baseViewHolder, c13414b.result, c13414b.fwM);
            }
        } else {
            BaseTimeLineItem.m68247f(baseViewHolder);
        }
        this.rxV.put(Integer.valueOf(i), view2);
        AppMethodBeat.m2505o(39424);
        return view2;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.m2504i(39425);
        int b = C46251au.m86607b(this.rxO.mo47320DP(i), true);
        AppMethodBeat.m2505o(39425);
        return b;
    }

    public final C43612w cuc() {
        return this.rxO;
    }

    /* renamed from: b */
    protected static int m86607b(C46236n c46236n, boolean z) {
        AppMethodBeat.m2504i(39426);
        TimeLineObject cqu = c46236n.cqu();
        if (cqu.xfI.wbJ != 1) {
            switch (cqu.xfI.wbJ) {
                case 2:
                    AppMethodBeat.m2505o(39426);
                    return 6;
                case 4:
                    AppMethodBeat.m2505o(39426);
                    return 0;
                case 5:
                    if (c46236n.mo74253DI(32) && c46236n.cqo() != null) {
                        if (c46236n.cqo().coP()) {
                            AppMethodBeat.m2505o(39426);
                            return 13;
                        } else if (c46236n.coQ()) {
                            AppMethodBeat.m2505o(39426);
                            return 14;
                        }
                    }
                    AppMethodBeat.m2505o(39426);
                    return 1;
                case 7:
                    AppMethodBeat.m2505o(39426);
                    return 2;
                case 8:
                    AppMethodBeat.m2505o(39426);
                    return 3;
                case 14:
                    AppMethodBeat.m2505o(39426);
                    return 7;
                case 15:
                    if (z && cqu.xfP == 1) {
                        AppMethodBeat.m2505o(39426);
                        return 12;
                    }
                    if (c46236n.mo74253DI(32) && c46236n.cqo() != null) {
                        if (c46236n.cqo().coP()) {
                            AppMethodBeat.m2505o(39426);
                            return 13;
                        } else if (c46236n.coQ()) {
                            AppMethodBeat.m2505o(39426);
                            return 14;
                        }
                    }
                    AppMethodBeat.m2505o(39426);
                    return 9;
                case 21:
                    AppMethodBeat.m2505o(39426);
                    return 10;
                case 27:
                    AppMethodBeat.m2505o(39426);
                    return 11;
                default:
                    AppMethodBeat.m2505o(39426);
                    return 1;
            }
        } else if (z && cqu.dtW == 1) {
            AppMethodBeat.m2505o(39426);
            return 12;
        } else {
            if (c46236n.mo74253DI(32) && c46236n.cqo() != null) {
                if (c46236n.cqo().coP()) {
                    AppMethodBeat.m2505o(39426);
                    return 13;
                } else if (c46236n.coQ()) {
                    AppMethodBeat.m2505o(39426);
                    return 14;
                }
            }
            int size = cqu.xfI.wbK.size();
            if (size <= 1) {
                AppMethodBeat.m2505o(39426);
                return 2;
            } else if (size <= 3) {
                AppMethodBeat.m2505o(39426);
                return 3;
            } else if (size <= 6) {
                AppMethodBeat.m2505o(39426);
                return 4;
            } else {
                AppMethodBeat.m2505o(39426);
                return 5;
            }
        }
    }

    /* renamed from: E */
    public static int m86602E(C46236n c46236n) {
        AppMethodBeat.m2504i(139043);
        int b = C46251au.m86607b(c46236n, true);
        AppMethodBeat.m2505o(139043);
        return b;
    }

    /* renamed from: ZI */
    public static String m86603ZI(String str) {
        AppMethodBeat.m2504i(39428);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(39428);
        } else {
            int indexOf = str.indexOf("://");
            if (indexOf != -1) {
                str = str.substring(indexOf + 3);
            }
            indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            AppMethodBeat.m2505o(39428);
        }
        return str;
    }

    /* renamed from: a */
    public static String m86605a(TimeLineObject timeLineObject, Context context) {
        AppMethodBeat.m2504i(39429);
        String f = C24826a.gkF.mo38868f(context, timeLineObject.xfH.f17242Id, "timeline");
        AppMethodBeat.m2505o(39429);
        return f;
    }

    /* renamed from: ZJ */
    public static String m86604ZJ(String str) {
        AppMethodBeat.m2504i(39430);
        C4990ab.m7410d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(str)));
        String B = C24826a.gkF.mo38843B(str, "timeline");
        AppMethodBeat.m2505o(39430);
        return B;
    }

    /* renamed from: Z */
    public final void mo74341Z(Runnable runnable) {
        AppMethodBeat.m2504i(39431);
        this.rxO.crP();
        runnable.run();
        AppMethodBeat.m2505o(39431);
    }

    /* renamed from: dO */
    public final void mo74350dO(View view) {
        AppMethodBeat.m2504i(39432);
        if (view.getTag() instanceof BaseViewHolder) {
            C4990ab.m7410d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
            if (this.rxS != null && this.rxS.getVisibility() == 0) {
                this.rxS.startAnimation(this.rpS);
                this.rpS.setAnimationListener(new C2919310());
            }
            AppMethodBeat.m2505o(39432);
            return;
        }
        AppMethodBeat.m2505o(39432);
    }

    /* renamed from: DP */
    public final C46236n mo74340DP(int i) {
        AppMethodBeat.m2504i(39433);
        C46236n DP = this.rxO.mo47320DP(i);
        AppMethodBeat.m2505o(39433);
        return DP;
    }

    public final int getCount() {
        AppMethodBeat.m2504i(39434);
        int count = this.rxO.getCount();
        AppMethodBeat.m2505o(39434);
        return count;
    }

    /* renamed from: DQ */
    public final boolean mo69232DQ(int i) {
        AppMethodBeat.m2504i(39435);
        if (i < this.gKd.getFirstVisiblePosition() - 1 || i > this.gKd.getLastVisiblePosition() - 1) {
            AppMethodBeat.m2505o(39435);
            return false;
        }
        AppMethodBeat.m2505o(39435);
        return true;
    }

    /* renamed from: c */
    static /* synthetic */ void m86609c(C46251au c46251au, String str) {
        AppMethodBeat.m2504i(39438);
        C4990ab.m7411d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateFinish, id: %s", str);
        C13413ap.m21549cZ(str, 2);
        c46251au.notifyDataSetChanged();
        AppMethodBeat.m2505o(39438);
    }

    /* renamed from: d */
    static /* synthetic */ void m86610d(C46251au c46251au, String str) {
        AppMethodBeat.m2504i(39439);
        C4990ab.m7411d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateFinish, id: %s", str);
        C13413ap.m21549cZ(str, 2);
        c46251au.notifyDataSetChanged();
        AppMethodBeat.m2505o(39439);
    }

    /* renamed from: e */
    static /* synthetic */ void m86611e(C46251au c46251au, String str) {
        AppMethodBeat.m2504i(39440);
        C4990ab.m7411d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslatePostDesc, id: %s", str);
        C13413ap.m21550da(str, 2);
        c46251au.notifyDataSetChanged();
        AppMethodBeat.m2505o(39440);
    }

    /* renamed from: f */
    static /* synthetic */ void m86612f(C46251au c46251au, String str) {
        AppMethodBeat.m2504i(39441);
        C4990ab.m7411d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslateComment, id: %s", str);
        C13413ap.m21550da(str, 2);
        c46251au.notifyDataSetChanged();
        AppMethodBeat.m2505o(39441);
    }
}
