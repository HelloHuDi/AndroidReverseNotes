package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.g.a.rx;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.e;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.h;
import com.tencent.mm.plugin.sns.ui.item.i;
import com.tencent.mm.plugin.sns.ui.widget.SnsCommentCollapseLayout;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.j;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public final class au implements x {
    public j contextMenuHelper;
    public MMActivity crP;
    private ListView gKd;
    com.tencent.mm.sdk.b.c hAA;
    protected ak handler = new ak();
    public com.tencent.mm.ui.widget.b.a jMO;
    public com.tencent.mm.plugin.sns.ui.d.b qOL;
    protected int requestType = 0;
    protected HashMap<String, Integer> rhW = new HashMap();
    public OnTouchListener riQ;
    protected ScaleAnimation rpR;
    protected ScaleAnimation rpS;
    public aq rpY;
    public boolean rps = false;
    com.tencent.mm.sdk.b.c rqA = new com.tencent.mm.sdk.b.c<rz>() {
        {
            AppMethodBeat.i(39405);
            this.xxI = rz.class.getName().hashCode();
            AppMethodBeat.o(39405);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(39406);
            rz rzVar = (rz) bVar;
            if (rzVar instanceof rz) {
                String str = rzVar.cNU.id;
                if (rzVar.cNU.type == 1) {
                    au.e(au.this, str);
                } else if (rzVar.cNU.type == 2) {
                    au.f(au.this, str);
                }
            }
            AppMethodBeat.o(39406);
            return false;
        }
    };
    private int rqb = 0;
    public j rqd;
    public bc rqg;
    com.tencent.mm.sdk.b.c rqy = new com.tencent.mm.sdk.b.c<rx>() {
        {
            AppMethodBeat.i(39403);
            this.xxI = rx.class.getName().hashCode();
            AppMethodBeat.o(39403);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(39404);
            rx rxVar = (rx) bVar;
            if (rxVar instanceof rx) {
                String str = rxVar.cNR.id;
                if (rxVar.cNR.type == 1) {
                    au.c(au.this, str);
                } else if (rxVar.cNR.type == 2) {
                    au.d(au.this, rxVar.cNR.id);
                }
            }
            AppMethodBeat.o(39404);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c rqz = new com.tencent.mm.sdk.b.c<ry>() {
        {
            AppMethodBeat.i(39399);
            this.xxI = ry.class.getName().hashCode();
            AppMethodBeat.o(39399);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(39400);
            ry ryVar = (ry) bVar;
            if (ryVar instanceof ry) {
                if (ryVar.cNT.type == 1) {
                    au.a(au.this, ryVar.cNT.id);
                } else if (ryVar.cNT.type == 2) {
                    au.b(au.this, ryVar.cNT.id);
                }
            }
            AppMethodBeat.o(39400);
            return false;
        }
    };
    protected w rxO;
    public i rxP;
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
    private c ryc;

    public interface a {
        boolean cud();
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.au$9 */
    class AnonymousClass9 implements AnimationListener {
        boolean rrc = false;
        final /* synthetic */ LinearLayout rrd;
        final /* synthetic */ Runnable ryf;

        AnonymousClass9(LinearLayout linearLayout, Runnable runnable) {
            this.rrd = linearLayout;
            this.ryf = runnable;
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.i(39411);
            if (this.rrd != null) {
                this.rrd.setPressed(false);
            }
            if (!this.rrc) {
                this.rrc = true;
                if ((au.this.crP instanceof t) && ((t) au.this.crP).crO()) {
                    au.this.rxO.notifyDataSetChanged();
                }
            }
            if (this.ryf != null) {
                this.ryf.run();
            }
            AppMethodBeat.o(39411);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
        }
    }

    public static class b implements com.tencent.mm.model.ao.b.a {
        int mPosition;
        w ryg = null;

        public b(w wVar, int i) {
            this.ryg = wVar;
            this.mPosition = i;
        }

        public final void o(String str, boolean z) {
            AppMethodBeat.i(39414);
            if (z) {
                g.RQ();
                if (g.RN().QY()) {
                    af.bCo().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(39413);
                            if (b.this.ryg.crQ() != null) {
                                b.this.ryg.crQ().request(Integer.valueOf(b.this.mPosition));
                            }
                            b.this.ryg.notifyDataSetChanged();
                            AppMethodBeat.o(39413);
                        }
                    });
                }
            }
            AppMethodBeat.o(39414);
        }
    }

    static class c implements OnCreateContextMenuListener {
        private String czD;
        private bau qJh;
        private TimeLineObject rin;
        private n ros;
        private View targetView;
        private String url;

        c() {
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AppMethodBeat.i(39415);
            Object tag = view.getTag();
            if (tag instanceof q) {
                q qVar = (q) tag;
                TimeLineObject timeLineObject = qVar.rin;
                view.getContext();
                String ZJ = au.ZJ(timeLineObject.xfI.Url);
                if (ZJ == null || ZJ.length() == 0) {
                    AppMethodBeat.o(39415);
                    return;
                }
                this.url = ZJ;
                this.czD = qVar.cwT;
                this.targetView = view;
                this.qJh = timeLineObject.xfI.wbK.size() > 0 ? (bau) timeLineObject.xfI.wbK.get(0) : null;
                this.ros = af.cnF().YT(this.czD);
                this.rin = timeLineObject;
                if (timeLineObject.xfI.wbJ == 10 || timeLineObject.xfI.wbJ == 13) {
                    AppMethodBeat.o(39415);
                    return;
                }
                if (d.afj("favorite")) {
                    switch (timeLineObject.xfI.wbJ) {
                        case 4:
                            contextMenu.add(0, 4, 0, view.getContext().getString(R.string.dcq));
                            break;
                        case 9:
                            contextMenu.add(0, 5, 0, view.getContext().getString(R.string.dcq));
                            break;
                        case 14:
                            contextMenu.add(0, 9, 0, view.getContext().getString(R.string.dcq));
                            break;
                        default:
                            contextMenu.add(0, 3, 0, view.getContext().getString(R.string.dcq));
                            break;
                    }
                }
                if (!(this.ros == null || this.ros.field_userName.equals(af.cnk()))) {
                    contextMenu.add(0, 8, 0, view.getContext().getString(R.string.aya));
                }
            }
            AppMethodBeat.o(39415);
        }
    }

    public final void ctW() {
        AppMethodBeat.i(39416);
        this.rhW.clear();
        AppMethodBeat.o(39416);
    }

    public final t ctX() {
        if (this.crP instanceof t) {
            return (t) this.crP;
        }
        return null;
    }

    public final SnsCommentCollapseLayout ctY() {
        AppMethodBeat.i(39417);
        SnsCommentCollapseLayout snsCommentCollapseLayout;
        if (this.rxQ.size() == 0) {
            snsCommentCollapseLayout = new SnsCommentCollapseLayout(this.crP);
            AppMethodBeat.o(39417);
            return snsCommentCollapseLayout;
        }
        snsCommentCollapseLayout = (SnsCommentCollapseLayout) this.rxQ.removeFirst();
        AppMethodBeat.o(39417);
        return snsCommentCollapseLayout;
    }

    public final void a(SnsCommentCollapseLayout snsCommentCollapseLayout) {
        AppMethodBeat.i(39418);
        this.rxQ.add(snsCommentCollapseLayout);
        AppMethodBeat.o(39418);
    }

    public final boolean ctZ() {
        AppMethodBeat.i(39419);
        if (this.rxQ != null) {
            this.rxQ.clear();
        }
        if (this.rxX != null) {
            this.rxX.clear();
        }
        com.tencent.mm.pluginsdk.ui.e.j.clearCache();
        com.tencent.mm.kiss.widget.textview.c.eNj.SN();
        AppMethodBeat.o(39419);
        return true;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(39420);
        this.rxO.notifyDataSetChanged();
        AppMethodBeat.o(39420);
    }

    public final void cua() {
        AppMethodBeat.i(39421);
        this.rxO.crP();
        AppMethodBeat.o(39421);
    }

    public au(MMActivity mMActivity, ListView listView, com.tencent.mm.plugin.sns.ui.d.b bVar, i iVar, final w wVar) {
        AppMethodBeat.i(39422);
        this.rxX.put(Integer.valueOf(6), com.tencent.mm.plugin.sns.ui.item.h.a.class);
        this.rxX.put(Integer.valueOf(2), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(3), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(4), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(5), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(0), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(1), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(7), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(8), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(9), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(11), com.tencent.mm.plugin.sns.ui.item.i.b.class);
        this.rxX.put(Integer.valueOf(13), com.tencent.mm.plugin.sns.ui.item.a.a.class);
        this.rxX.put(Integer.valueOf(14), com.tencent.mm.plugin.sns.ui.item.c.a.class);
        this.rxX.put(Integer.valueOf(10), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxX.put(Integer.valueOf(12), com.tencent.mm.plugin.sns.ui.item.g.a.class);
        this.rxY = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39407);
                ab.i("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn");
                au.this.rxP.rhp = false;
                com.tencent.mm.plugin.sns.abtest.a.clW();
                if (view.getTag() instanceof BaseViewHolder) {
                    BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                    if (baseViewHolder.timeLineObject != null && baseViewHolder.timeLineObject.xfI.wbJ == 21) {
                        bav bav = baseViewHolder.rfi;
                        if (!r.Yz().equals(baseViewHolder.timeLineObject.jBB) && (bav == null || bav.cRU == 0)) {
                            com.tencent.mm.plugin.sns.lucky.ui.a.f(au.this.crP, baseViewHolder.rHT.DT(0));
                            AppMethodBeat.o(39407);
                            return;
                        }
                    }
                    if (au.this.crP instanceof t) {
                        ((t) au.this.crP).dM(view);
                    }
                    AppMethodBeat.o(39407);
                    return;
                }
                ab.e("MicroMsg.SnsTimeLineBaseAdapter", "showCommentBtn err1");
                AppMethodBeat.o(39407);
            }
        };
        this.rxZ = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39408);
                if (view.getTag() instanceof BaseViewHolder) {
                    BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                    if (baseViewHolder == null) {
                        AppMethodBeat.o(39408);
                        return;
                    } else if (au.this.rhW.containsKey(baseViewHolder.cwT) && ((Integer) au.this.rhW.get(baseViewHolder.cwT)).equals(Integer.valueOf(1))) {
                        au.this.rhW.put(baseViewHolder.cwT, Integer.valueOf(2));
                        au.this.rxO.notifyDataSetChanged();
                        AppMethodBeat.o(39408);
                        return;
                    } else {
                        au.this.rhW.put(baseViewHolder.cwT, Integer.valueOf(1));
                        if (baseViewHolder.mRR.getTop() < 0) {
                            au.this.qOL.b(baseViewHolder.mRR, baseViewHolder.position, baseViewHolder.mRR.getTop(), baseViewHolder.rHz.getSpreadHeight());
                            AppMethodBeat.o(39408);
                            return;
                        }
                        au.this.rxO.notifyDataSetChanged();
                        AppMethodBeat.o(39408);
                        return;
                    }
                }
                AppMethodBeat.o(39408);
            }
        };
        this.rya = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39409);
                if (view.getParent() == null || !(view.getParent() instanceof SnsCommentCollapseLayout)) {
                    AppMethodBeat.o(39409);
                } else if (((SnsCommentCollapseLayout) view.getParent()).getTag() == null || !(((SnsCommentCollapseLayout) view.getParent()).getTag() instanceof l)) {
                    AppMethodBeat.o(39409);
                } else {
                    l lVar = (l) ((SnsCommentCollapseLayout) view.getParent()).getTag();
                    if (lVar == null) {
                        AppMethodBeat.o(39409);
                        return;
                    }
                    try {
                        Intent intent = new Intent();
                        intent.putExtra("sns_text_show", lVar.ncM);
                        intent.putExtra("sns_local_id", lVar.ria);
                        intent.putExtra("sns_comment_buf", lVar.qJj.toByteArray());
                        intent.setClass(au.this.crP, SnsSingleTextViewUI.class);
                        au.this.crP.startActivity(intent);
                        AppMethodBeat.o(39409);
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", e, "commentCollapse click exception.", new Object[0]);
                        AppMethodBeat.o(39409);
                    }
                }
            }
        };
        this.riQ = bo.dpE();
        this.ryb = new HashMap();
        this.ryc = new c();
        this.hAA = new com.tencent.mm.sdk.b.c<ke>() {
            {
                AppMethodBeat.i(39401);
                this.xxI = ke.class.getName().hashCode();
                AppMethodBeat.o(39401);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(39402);
                ke keVar = (ke) bVar;
                if (keVar instanceof ke) {
                    switch (keVar.cFH.action) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 7:
                            au.this.rxO.notifyDataSetChanged();
                            break;
                    }
                }
                AppMethodBeat.o(39402);
                return false;
            }
        };
        this.rxO = wVar;
        this.rxP = iVar;
        ab.d("MicroMsg.SnsTimeLineBaseAdapter", "SnsTimeLineAdapter 2");
        this.gKd = listView;
        af.cnC();
        this.crP = mMActivity;
        this.qOL = bVar;
        this.contextMenuHelper = new j(mMActivity);
        this.jMO = new com.tencent.mm.ui.widget.b.a(mMActivity);
        this.rpY = new aq(mMActivity);
        this.rpR = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rpR.setDuration(150);
        this.rpS = new ScaleAnimation(1.0f, 0.0f, 1.0f, 1.0f, 1, 1.0f, 1, 0.0f);
        this.rpS.setDuration(150);
        this.rqd = new j(mMActivity, 0, iVar.rhn);
        this.requestType = 10;
        this.rqg = new bc(mMActivity, new com.tencent.mm.plugin.sns.ui.bc.a() {
            public final void ctb() {
                AppMethodBeat.i(39410);
                wVar.notifyDataSetChanged();
                AppMethodBeat.o(39410);
            }
        }, 0, iVar.rhn);
        com.tencent.mm.sdk.b.a.xxA.c(this.hAA);
        AppMethodBeat.o(39422);
    }

    public final void cub() {
        AppMethodBeat.i(39423);
        int firstVisiblePosition = this.gKd.getFirstVisiblePosition() - this.gKd.getHeaderViewsCount();
        int lastVisiblePosition = this.gKd.getLastVisiblePosition() - this.gKd.getHeaderViewsCount();
        ab.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem start ~ end" + firstVisiblePosition + " " + lastVisiblePosition);
        int count = this.rxO.getCount();
        int i = firstVisiblePosition;
        while (i <= lastVisiblePosition && i < count) {
            n DP = DP(i);
            View view = (View) this.rxV.get(Integer.valueOf(i));
            if (view == null || DP == null || view.getTag() == null) {
                ab.e("MicroMsg.SnsTimeLineBaseAdapter", " passe ".concat(String.valueOf(i)));
            } else {
                BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
                ab.i("MicroMsg.SnsTimeLineBaseAdapter", "reConverItem " + i + " " + baseViewHolder.position);
                baseViewHolder.rIu.a(baseViewHolder, i, DP);
            }
            i++;
        }
        AppMethodBeat.o(39423);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0156  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View h(int i, View view) {
        Object view2;
        Throwable e;
        String cqA;
        ArrayList arrayList;
        com.tencent.mm.plugin.sns.model.ap.b bVar;
        AppMethodBeat.i(39424);
        n DP = this.rxO.DP(i);
        TimeLineObject cqu = DP.cqu();
        int b = b(DP, true);
        BaseTimeLineItem baseTimeLineItem = null;
        BaseViewHolder baseViewHolder = null;
        if (view2 != null) {
            Object tag = view2.getTag(R.id.emw);
            if ((tag instanceof Integer ? ((Integer) tag).intValue() : -1) == b) {
                BaseViewHolder baseViewHolder2 = (BaseViewHolder) view2.getTag();
                baseTimeLineItem = baseViewHolder2.rIu;
                baseViewHolder = baseViewHolder2;
            }
        }
        if (baseViewHolder == null) {
            BaseTimeLineItem eVar;
            switch (b) {
                case 0:
                    eVar = new e();
                    break;
                case 1:
                    eVar = new f();
                    break;
                case 2:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.g();
                    break;
                case 3:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.g();
                    break;
                case 4:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.g();
                    break;
                case 5:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.g();
                    break;
                case 6:
                    eVar = new h();
                    break;
                case 7:
                    eVar = new f();
                    break;
                case 8:
                    eVar = new f();
                    break;
                case 9:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.j();
                    break;
                case 10:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.d();
                    break;
                case 11:
                    eVar = new i();
                    break;
                case 12:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.b();
                    break;
                case 13:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.a();
                    break;
                case 14:
                    eVar = new com.tencent.mm.plugin.sns.ui.item.c();
                    break;
                default:
                    eVar = new f();
                    break;
            }
            try {
                BaseViewHolder baseViewHolder3;
                if (this.rxX.get(Integer.valueOf(b)) != null) {
                    baseViewHolder3 = (BaseViewHolder) ((Class) this.rxX.get(Integer.valueOf(b))).newInstance();
                } else {
                    baseViewHolder3 = new com.tencent.mm.plugin.sns.ui.item.g.a();
                }
                try {
                    baseViewHolder3.rIu = eVar;
                    baseViewHolder3.timeLineObject = cqu;
                    view2 = eVar.a(this.crP, baseViewHolder3, b, this, DP);
                    view2.setTag(R.id.emw, Integer.valueOf(b));
                    baseViewHolder = baseViewHolder3;
                    baseTimeLineItem = eVar;
                } catch (Exception e2) {
                    e = e2;
                    baseViewHolder = baseViewHolder3;
                    ab.printErrStackTrace("MicroMsg.SnsTimeLineBaseAdapter", e, "create holder error", new Object[0]);
                    baseTimeLineItem = eVar;
                    baseTimeLineItem.setIsFromMainTimeline(this.rps);
                    cqA = DP.cqA();
                    arrayList = new ArrayList();
                    if (ap.coh().size() > 0) {
                    }
                    baseTimeLineItem.rHq = arrayList;
                    baseTimeLineItem.a(baseViewHolder, i, DP, cqu, b, this);
                    if (ap.db(DP.cqA(), 2)) {
                    }
                    this.rxV.put(Integer.valueOf(i), view2);
                    AppMethodBeat.o(39424);
                    return view2;
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        baseTimeLineItem.setIsFromMainTimeline(this.rps);
        cqA = DP.cqA();
        arrayList = new ArrayList();
        if (ap.coh().size() > 0) {
            for (String str : ap.coh().keySet()) {
                if (str.startsWith(cqA)) {
                    bVar = (com.tencent.mm.plugin.sns.model.ap.b) ap.coh().get(str);
                    if (ap.c(bVar)) {
                        arrayList.add(bVar);
                    }
                }
            }
        }
        baseTimeLineItem.rHq = arrayList;
        baseTimeLineItem.a(baseViewHolder, i, DP, cqu, b, this);
        if (ap.db(DP.cqA(), 2)) {
            bVar = ap.Ye(DP.cqA());
            if (DP.field_snsId == 0) {
                bVar = new com.tencent.mm.plugin.sns.model.ap.b();
            }
            if (!bVar.foa) {
                BaseTimeLineItem.e(baseViewHolder);
            } else if (bVar.aAR) {
                BaseTimeLineItem.f(baseViewHolder);
                ap.da(bVar.id, 2);
            } else {
                BaseTimeLineItem.a(bVar, baseViewHolder, bVar.result, bVar.fwM);
            }
        } else {
            BaseTimeLineItem.f(baseViewHolder);
        }
        this.rxV.put(Integer.valueOf(i), view2);
        AppMethodBeat.o(39424);
        return view2;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(39425);
        int b = b(this.rxO.DP(i), true);
        AppMethodBeat.o(39425);
        return b;
    }

    public final w cuc() {
        return this.rxO;
    }

    protected static int b(n nVar, boolean z) {
        AppMethodBeat.i(39426);
        TimeLineObject cqu = nVar.cqu();
        if (cqu.xfI.wbJ != 1) {
            switch (cqu.xfI.wbJ) {
                case 2:
                    AppMethodBeat.o(39426);
                    return 6;
                case 4:
                    AppMethodBeat.o(39426);
                    return 0;
                case 5:
                    if (nVar.DI(32) && nVar.cqo() != null) {
                        if (nVar.cqo().coP()) {
                            AppMethodBeat.o(39426);
                            return 13;
                        } else if (nVar.coQ()) {
                            AppMethodBeat.o(39426);
                            return 14;
                        }
                    }
                    AppMethodBeat.o(39426);
                    return 1;
                case 7:
                    AppMethodBeat.o(39426);
                    return 2;
                case 8:
                    AppMethodBeat.o(39426);
                    return 3;
                case 14:
                    AppMethodBeat.o(39426);
                    return 7;
                case 15:
                    if (z && cqu.xfP == 1) {
                        AppMethodBeat.o(39426);
                        return 12;
                    }
                    if (nVar.DI(32) && nVar.cqo() != null) {
                        if (nVar.cqo().coP()) {
                            AppMethodBeat.o(39426);
                            return 13;
                        } else if (nVar.coQ()) {
                            AppMethodBeat.o(39426);
                            return 14;
                        }
                    }
                    AppMethodBeat.o(39426);
                    return 9;
                case 21:
                    AppMethodBeat.o(39426);
                    return 10;
                case 27:
                    AppMethodBeat.o(39426);
                    return 11;
                default:
                    AppMethodBeat.o(39426);
                    return 1;
            }
        } else if (z && cqu.dtW == 1) {
            AppMethodBeat.o(39426);
            return 12;
        } else {
            if (nVar.DI(32) && nVar.cqo() != null) {
                if (nVar.cqo().coP()) {
                    AppMethodBeat.o(39426);
                    return 13;
                } else if (nVar.coQ()) {
                    AppMethodBeat.o(39426);
                    return 14;
                }
            }
            int size = cqu.xfI.wbK.size();
            if (size <= 1) {
                AppMethodBeat.o(39426);
                return 2;
            } else if (size <= 3) {
                AppMethodBeat.o(39426);
                return 3;
            } else if (size <= 6) {
                AppMethodBeat.o(39426);
                return 4;
            } else {
                AppMethodBeat.o(39426);
                return 5;
            }
        }
    }

    public static int E(n nVar) {
        AppMethodBeat.i(139043);
        int b = b(nVar, true);
        AppMethodBeat.o(139043);
        return b;
    }

    public static String ZI(String str) {
        AppMethodBeat.i(39428);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(39428);
        } else {
            int indexOf = str.indexOf("://");
            if (indexOf != -1) {
                str = str.substring(indexOf + 3);
            }
            indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            AppMethodBeat.o(39428);
        }
        return str;
    }

    public static String a(TimeLineObject timeLineObject, Context context) {
        AppMethodBeat.i(39429);
        String f = com.tencent.mm.plugin.sns.c.a.gkF.f(context, timeLineObject.xfH.Id, "timeline");
        AppMethodBeat.o(39429);
        return f;
    }

    public static String ZJ(String str) {
        AppMethodBeat.i(39430);
        ab.d("MicroMsg.SnsTimeLineBaseAdapter", "url:".concat(String.valueOf(str)));
        String B = com.tencent.mm.plugin.sns.c.a.gkF.B(str, "timeline");
        AppMethodBeat.o(39430);
        return B;
    }

    public final void Z(Runnable runnable) {
        AppMethodBeat.i(39431);
        this.rxO.crP();
        runnable.run();
        AppMethodBeat.o(39431);
    }

    public final void dO(View view) {
        AppMethodBeat.i(39432);
        if (view.getTag() instanceof BaseViewHolder) {
            ab.d("MicroMsg.SnsTimeLineBaseAdapter", "close comment v");
            if (this.rxS != null && this.rxS.getVisibility() == 0) {
                this.rxS.startAnimation(this.rpS);
                this.rpS.setAnimationListener(new AnimationListener() {
                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(39412);
                        if (au.this.rxS != null) {
                            au.this.rxS.clearAnimation();
                            au.this.rxS.setVisibility(8);
                        }
                        au.this.rxS = null;
                        AppMethodBeat.o(39412);
                    }
                });
            }
            AppMethodBeat.o(39432);
            return;
        }
        AppMethodBeat.o(39432);
    }

    public final n DP(int i) {
        AppMethodBeat.i(39433);
        n DP = this.rxO.DP(i);
        AppMethodBeat.o(39433);
        return DP;
    }

    public final int getCount() {
        AppMethodBeat.i(39434);
        int count = this.rxO.getCount();
        AppMethodBeat.o(39434);
        return count;
    }

    public final boolean DQ(int i) {
        AppMethodBeat.i(39435);
        if (i < this.gKd.getFirstVisiblePosition() - 1 || i > this.gKd.getLastVisiblePosition() - 1) {
            AppMethodBeat.o(39435);
            return false;
        }
        AppMethodBeat.o(39435);
        return true;
    }

    static /* synthetic */ void c(au auVar, String str) {
        AppMethodBeat.i(39438);
        ab.d("MicroMsg.SnsTimeLineBaseAdapter", "postDescTranslateFinish, id: %s", str);
        ap.cZ(str, 2);
        auVar.notifyDataSetChanged();
        AppMethodBeat.o(39438);
    }

    static /* synthetic */ void d(au auVar, String str) {
        AppMethodBeat.i(39439);
        ab.d("MicroMsg.SnsTimeLineBaseAdapter", "commentTranslateFinish, id: %s", str);
        ap.cZ(str, 2);
        auVar.notifyDataSetChanged();
        AppMethodBeat.o(39439);
    }

    static /* synthetic */ void e(au auVar, String str) {
        AppMethodBeat.i(39440);
        ab.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslatePostDesc, id: %s", str);
        ap.da(str, 2);
        auVar.notifyDataSetChanged();
        AppMethodBeat.o(39440);
    }

    static /* synthetic */ void f(au auVar, String str) {
        AppMethodBeat.i(39441);
        ab.d("MicroMsg.SnsTimeLineBaseAdapter", "unTranslateComment, id: %s", str);
        ap.da(str, 2);
        auVar.notifyDataSetChanged();
        AppMethodBeat.o(39441);
    }
}
