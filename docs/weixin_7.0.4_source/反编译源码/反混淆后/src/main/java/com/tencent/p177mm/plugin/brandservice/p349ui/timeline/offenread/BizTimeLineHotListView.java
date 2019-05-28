package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C2594a;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.C27534f.C275321;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.C27534f.C275332;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread.C27534f.C27535a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.protocal.protobuf.bfb;
import com.tencent.p177mm.protocal.protobuf.bfe;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C30309s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView */
public class BizTimeLineHotListView extends MRecyclerView {
    private List<C42820b> iKa = new ArrayList();
    private C27534f jQe;
    private C27528a jQf;
    private C20062e jQg;
    private float jnU = 0.0f;
    private int jnV = 0;
    private Context mContext;
    private int mScreenWidth = 0;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView$3 */
    class C200603 implements C2594a {
        C200603() {
        }

        /* renamed from: I */
        public final void mo6645I(View view, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(14281);
            C42820b c42820b = (C42820b) BizTimeLineHotListView.this.iKa.get(i);
            if (c42820b == null) {
                AppMethodBeat.m2505o(14281);
                return;
            }
            C20062e a = BizTimeLineHotListView.this.jQg;
            if (c42820b != null) {
                bfb bfb;
                Iterator it = a.jQC.iterator();
                while (it.hasNext()) {
                    bfb = (bfb) it.next();
                    if (C5046bo.isEqual(bfb.vNN, c42820b.vGE)) {
                        bfb.wIW = (int) (System.currentTimeMillis() / 1000);
                        if (c42820b.jQz) {
                            i2 = 1;
                        }
                        bfb.wIV = i2;
                    }
                }
                bfb = new bfb();
                bfb.vNN = c42820b.vGE;
                bfb.mXP = c42820b.position - 1;
                bfb.wIW = (int) (System.currentTimeMillis() / 1000);
                if (c42820b.jQz) {
                    i2 = 1;
                }
                bfb.wIV = i2;
                a.jQC.add(bfb);
            }
            Intent intent = new Intent();
            intent.putExtra("Chat_User", c42820b.vGE);
            intent.putExtra("finish_direct", true);
            intent.putExtra("KOpenArticleSceneFromScene", 91);
            intent.putExtra("specific_chat_from_scene", 8);
            intent.putExtra("preChatTYPE", 12);
            C25985d.m41473f(BizTimeLineHotListView.this.mContext, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.m2505o(14281);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView$4 */
    class C275274 implements C27535a {
        C275274() {
        }

        /* renamed from: sj */
        public final void mo45324sj(int i) {
            AppMethodBeat.m2504i(14282);
            int currentPage = BizTimeLineHotListView.this.getCurrentPage();
            C4990ab.m7411d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", Integer.valueOf(i), Integer.valueOf(currentPage));
            BizTimeLineHotListView.m43670d(BizTimeLineHotListView.this);
            AppMethodBeat.m2505o(14282);
        }

        /* renamed from: fy */
        public final void mo45323fy(boolean z) {
            AppMethodBeat.m2504i(14283);
            if (!z) {
                int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                C7060h.pYm.mo8381e(15721, "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(currentTimeMillis), Integer.valueOf(C30309s.getSessionId()));
            }
            BizTimeLineHotListView.this.aWJ();
            AppMethodBeat.m2505o(14283);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView$a */
    public class C27528a extends C41523a<C27529b> {
        private Context mContext;

        public C27528a(Context context) {
            this.mContext = context;
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(14284);
            if (C5046bo.m7548ek(BizTimeLineHotListView.this.iKa)) {
                AppMethodBeat.m2505o(14284);
                return 0;
            }
            int size = BizTimeLineHotListView.this.iKa.size();
            int completelyCountPerPage = C42819a.getCompletelyCountPerPage();
            if (BizTimeLineHotListView.this.getCustomItemCount() == 1) {
                size--;
            }
            if (size > BizTimeLineHotListView.this.getShowCount()) {
                size = BizTimeLineHotListView.this.getShowCount();
            }
            if (BizTimeLineHotListView.this.getCustomItemCount() == 1) {
                if (size % completelyCountPerPage == 0) {
                    size++;
                } else {
                    size += (completelyCountPerPage + 1) - (size % completelyCountPerPage);
                }
                size += BizTimeLineHotListView.this.getCustomItemCount();
                AppMethodBeat.m2505o(14284);
                return size;
            }
            if (size % completelyCountPerPage != 0) {
                size += completelyCountPerPage - (size % completelyCountPerPage);
            }
            AppMethodBeat.m2505o(14284);
            return size;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(14285);
            int itemViewType = super.getItemViewType(i);
            AppMethodBeat.m2505o(14285);
            return itemViewType;
        }

        /* renamed from: a */
        private void m43662a(C27529b c27529b, C42820b c42820b, int i) {
            AppMethodBeat.m2504i(14286);
            int itemWidth = BizTimeLineHotListView.this.getItemWidth();
            float showCountPerPage = BizTimeLineHotListView.this.getShowCountPerPage();
            if (itemWidth <= 0) {
                itemWidth = (int) (((float) BizTimeLineHotListView.this.getWidth()) / showCountPerPage);
            }
            if (itemWidth <= 0) {
                itemWidth = (int) (((float) BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels) / showCountPerPage);
            }
            if (i == BizTimeLineHotListView.this.jQf.getItemCount() - 1) {
                itemWidth = (int) ((1.0d - (Math.ceil((double) showCountPerPage) - ((double) showCountPerPage))) * ((double) itemWidth));
                C4990ab.m7417i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", Integer.valueOf(i), Integer.valueOf(itemWidth));
            }
            c27529b.apJ.getLayoutParams().width = itemWidth;
            c27529b.apJ.setScaleX(1.0f);
            c27529b.apJ.setScaleY(1.0f);
            c27529b.gne.setText("pos:".concat(String.valueOf(i)));
            C4990ab.m7411d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", Integer.valueOf(i), Integer.valueOf(itemWidth));
            if (!(c42820b == null || c42820b.type == 2)) {
                C40460b.m69437r(c27529b.iqT, c42820b.vGE);
                c27529b.gne.setText(C1854s.m3866mJ(c42820b.vGE));
                if (c42820b.jQz) {
                    c27529b.jQj.setVisibility(0);
                } else {
                    c27529b.jQj.setVisibility(8);
                }
            }
            BizTimeLineHotListView.m43666a(BizTimeLineHotListView.this, c27529b, c42820b, i);
            AppMethodBeat.m2505o(14286);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView$b */
    public class C27529b extends C41531v {
        public View apJ;
        public TextView gne;
        public ImageView iYd;
        public FrameLayout iYe;
        public ImageView iqT;
        public ImageView jQj;

        public C27529b(View view) {
            super(view);
            AppMethodBeat.m2504i(14289);
            this.apJ = view;
            view.getLayoutParams().width = BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / 4;
            this.iqT = (ImageView) view.findViewById(2131821821);
            this.iYd = (ImageView) view.findViewById(2131821822);
            this.iYe = (FrameLayout) view.findViewById(2131821820);
            this.gne = (TextView) view.findViewById(2131821824);
            this.jQj = (ImageView) view.findViewById(2131821823);
            AppMethodBeat.m2505o(14289);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotListView$2 */
    class C275312 extends LinearLayoutManager {
        C275312() {
        }

        /* renamed from: iE */
        public final boolean mo1774iE() {
            return false;
        }
    }

    public BizTimeLineHotListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(14290);
        this.mContext = context;
        AppMethodBeat.m2505o(14290);
    }

    public BizTimeLineHotListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(14291);
        this.mContext = context;
        AppMethodBeat.m2505o(14291);
    }

    /* renamed from: aZ */
    public final void mo45328aZ(List<C42820b> list) {
        AppMethodBeat.m2504i(14292);
        this.iKa.clear();
        this.iKa.addAll(list);
        m43667aR(this.iKa);
        this.jQf.aop.notifyChanged();
        AppMethodBeat.m2505o(14292);
    }

    public C27528a getAdapter() {
        return this.jQf;
    }

    public final boolean aSd() {
        return false;
    }

    public final void aWJ() {
        AppMethodBeat.m2504i(14293);
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.iKa);
        C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(14280);
                int currentPage = BizTimeLineHotListView.this.getCurrentPage();
                int rb = C27534f.m43686rb(currentPage);
                int rc = C27534f.m43687rc(currentPage);
                if (currentPage == 0) {
                    rb++;
                }
                int i = rb;
                while (i <= rc && i < arrayList.size()) {
                    C42820b c42820b = (C42820b) arrayList.get(i);
                    if (c42820b != null) {
                        C20062e a = BizTimeLineHotListView.this.jQg;
                        if (c42820b != null) {
                            bfe bfe = (bfe) a.jQB.get(c42820b.vGE);
                            if (bfe == null) {
                                bfe bfe2 = new bfe();
                                bfe2.vNN = c42820b.vGE;
                                bfe2.wIV = c42820b.jQz ? 1 : 0;
                                bfe2.wIW = (int) (System.currentTimeMillis() / 1000);
                                bfe2.mXP = c42820b.position - 1;
                                bfe2.kaG = 1;
                                a.jQB.put(c42820b.vGE, bfe2);
                            } else {
                                int i2;
                                if (c42820b.jQz) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                bfe.wIV = i2;
                                bfe.wIW = (int) (System.currentTimeMillis() / 1000);
                                bfe.mXP = c42820b.position - 1;
                                bfe.kaG++;
                            }
                        }
                    }
                    i++;
                }
                AppMethodBeat.m2505o(14280);
            }
        }, 0);
        AppMethodBeat.m2505o(14293);
    }

    /* renamed from: a */
    public final void mo45325a(Context context, List<C42820b> list, C20062e c20062e) {
        AppMethodBeat.m2504i(14294);
        this.jQg = c20062e;
        this.iKa.addAll(list);
        m43667aR(this.iKa);
        this.jQf = new C27528a(context);
        C275312 c275312 = new C275312();
        c275312.setOrientation(0);
        setLayoutManager(c275312);
        setAdapter(this.jQf);
        this.jQe = new C27534f(getCustomItemCount());
        C27534f c27534f = this.jQe;
        int completelyCountPerPage = C42819a.getCompletelyCountPerPage();
        c27534f.mContext = context;
        c27534f.jQE = this;
        c27534f.jom = completelyCountPerPage;
        c27534f.jQE.mo66348b((C41530m) c27534f);
        c27534f.jQE.mo66332a((C41530m) c27534f);
        c27534f.jop = (LinearLayoutManager) c27534f.jQE.getLayoutManager();
        c27534f.aoC = new C275321(c27534f.jQE.getContext());
        c27534f.jol = new C275332(c27534f.jQE.getContext());
        setOnScrollPageListener(new C275274());
        setOnItemClickListener(new C200603());
        AppMethodBeat.m2505o(14294);
    }

    /* renamed from: g */
    private void m43672g(C41531v c41531v, int i) {
        AppMethodBeat.m2504i(14295);
        C4990ab.m7411d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", Integer.valueOf(i));
        if (c41531v != null) {
            float x = c41531v.apJ.getX();
            if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2)))) {
                c41531v.apJ.setAlpha(0.3f);
                AppMethodBeat.m2505o(14295);
                return;
            } else if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2))) || x < this.jnU) {
                c41531v.apJ.setAlpha(1.0f);
            } else {
                C4990ab.m7411d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", Float.valueOf(1.0f - (((x - this.jnU) / ((float) this.jnV)) * 0.7f)));
                c41531v.apJ.setAlpha(x);
                AppMethodBeat.m2505o(14295);
                return;
            }
        }
        AppMethodBeat.m2505o(14295);
    }

    /* renamed from: ak */
    public final boolean mo45329ak(int i, int i2) {
        AppMethodBeat.m2504i(14296);
        C27534f c27534f = this.jQe;
        c27534f.mo45339N(c27534f.mo45341qY(c27534f.mOffsetX + i), false);
        boolean ak = super.mo45329ak(i, i2);
        AppMethodBeat.m2505o(14296);
        return ak;
    }

    public int getCurrentPage() {
        if (this.jQe != null) {
            return this.jQe.jiy;
        }
        return 0;
    }

    private int getItemPadding() {
        AppMethodBeat.m2504i(14297);
        int dj = C42819a.m75964dj(getContext());
        AppMethodBeat.m2505o(14297);
        return dj;
    }

    public void setOnScrollPageListener(C27535a c27535a) {
        if (this.jQe != null) {
            this.jQe.jQG = c27535a;
        }
    }

    public int getDataCount() {
        AppMethodBeat.m2504i(14298);
        int size = this.iKa.size();
        AppMethodBeat.m2505o(14298);
        return size;
    }

    public int getCustomItemCount() {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public float getShowCountPerPage() {
        AppMethodBeat.m2504i(14299);
        float showCountPerPage = C42819a.getShowCountPerPage();
        AppMethodBeat.m2505o(14299);
        return showCountPerPage;
    }

    public int getItemWidth() {
        AppMethodBeat.m2504i(14300);
        int di = C42819a.m75963di(this.mContext);
        AppMethodBeat.m2505o(14300);
        return di;
    }

    public int getShowCount() {
        return 12;
    }

    /* renamed from: aR */
    private void m43667aR(List<C42820b> list) {
        AppMethodBeat.m2504i(14301);
        if (this.iKa == null) {
            AppMethodBeat.m2505o(14301);
            return;
        }
        C42820b c42820b = new C42820b((byte) 0);
        c42820b.vGE = "__BizTimeLine.CustomItem__";
        list.add(0, c42820b);
        AppMethodBeat.m2505o(14301);
    }

    /* renamed from: d */
    static /* synthetic */ void m43670d(BizTimeLineHotListView bizTimeLineHotListView) {
        AppMethodBeat.m2504i(14303);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bizTimeLineHotListView.getLayoutManager();
        if (linearLayoutManager != null) {
            bizTimeLineHotListView.mScreenWidth = bizTimeLineHotListView.getResources().getDisplayMetrics().widthPixels;
            bizTimeLineHotListView.jnV = bizTimeLineHotListView.getItemPadding() + C1338a.fromDPToPix(bizTimeLineHotListView.getContext(), 50);
            bizTimeLineHotListView.jnU = (float) ((bizTimeLineHotListView.mScreenWidth - (bizTimeLineHotListView.getItemWidth() / 2)) - bizTimeLineHotListView.jnV);
            int iS = linearLayoutManager.mo1782iS();
            int iT = linearLayoutManager.mo1783iT();
            C4990ab.m7411d("MicroMsg.BizTimeLineHotListView", "alvinluo onScroll mAlphaChangeOffset: %s, ALPHA_DISTANCE: %d", Float.valueOf(bizTimeLineHotListView.jnU), Integer.valueOf(bizTimeLineHotListView.jnV));
            C41531v cf = bizTimeLineHotListView.mo66357cf(iS);
            C41531v cf2 = bizTimeLineHotListView.mo66357cf(iT);
            bizTimeLineHotListView.m43672g(cf, iS);
            bizTimeLineHotListView.m43672g(cf2, iT);
        }
        AppMethodBeat.m2505o(14303);
    }

    /* renamed from: a */
    static /* synthetic */ void m43666a(BizTimeLineHotListView bizTimeLineHotListView, C27529b c27529b, C42820b c42820b, int i) {
        AppMethodBeat.m2504i(14304);
        if (c42820b == null || c27529b == null || c27529b.apJ == null) {
            AppMethodBeat.m2505o(14304);
            return;
        }
        if (c42820b.type == 2) {
            c27529b.apJ.setVisibility(4);
            c27529b.apJ.getLayoutParams().width = 0;
        }
        int dx = C42819a.m75967dx(bizTimeLineHotListView.getContext());
        c27529b.iYe.getLayoutParams().width = (C1338a.m2857am(bizTimeLineHotListView.getContext(), C25738R.dimen.f10011nc) * 2) + dx;
        c27529b.iYe.getLayoutParams().height = (C1338a.m2857am(bizTimeLineHotListView.getContext(), C25738R.dimen.f10011nc) * 2) + dx;
        c27529b.iqT.getLayoutParams().width = dx;
        c27529b.iqT.getLayoutParams().height = dx;
        c27529b.iYd.getLayoutParams().width = dx;
        c27529b.iYd.getLayoutParams().height = dx;
        dx = bizTimeLineHotListView.getCurrentPage();
        int rb = C27534f.m43686rb(dx);
        C4990ab.m7417i("MicroMsg.BizTimeLineHotListView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", Integer.valueOf(dx), Integer.valueOf(rb), Integer.valueOf(C27534f.m43687rc(dx)), Integer.valueOf(i));
        if (i == C27534f.m43687rc(dx)) {
            c27529b.apJ.setAlpha(0.3f);
            AppMethodBeat.m2505o(14304);
            return;
        }
        c27529b.apJ.setVisibility(0);
        c27529b.apJ.setAlpha(1.0f);
        AppMethodBeat.m2505o(14304);
    }
}
