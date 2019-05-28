package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.protocal.protobuf.bfe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BizTimeLineHotListView extends MRecyclerView {
    private List<b> iKa = new ArrayList();
    private f jQe;
    private a jQf;
    private e jQg;
    private float jnU = 0.0f;
    private int jnV = 0;
    private Context mContext;
    private int mScreenWidth = 0;

    public class a extends android.support.v7.widget.RecyclerView.a<b> {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        public final int getItemCount() {
            AppMethodBeat.i(14284);
            if (bo.ek(BizTimeLineHotListView.this.iKa)) {
                AppMethodBeat.o(14284);
                return 0;
            }
            int size = BizTimeLineHotListView.this.iKa.size();
            int completelyCountPerPage = a.getCompletelyCountPerPage();
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
                AppMethodBeat.o(14284);
                return size;
            }
            if (size % completelyCountPerPage != 0) {
                size += completelyCountPerPage - (size % completelyCountPerPage);
            }
            AppMethodBeat.o(14284);
            return size;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(14285);
            int itemViewType = super.getItemViewType(i);
            AppMethodBeat.o(14285);
            return itemViewType;
        }

        private void a(b bVar, b bVar2, int i) {
            AppMethodBeat.i(14286);
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
                ab.i("MicroMsg.BizTimeLineHotListView", "alvinluo lastPosition %d set width %d", Integer.valueOf(i), Integer.valueOf(itemWidth));
            }
            bVar.apJ.getLayoutParams().width = itemWidth;
            bVar.apJ.setScaleX(1.0f);
            bVar.apJ.setScaleY(1.0f);
            bVar.gne.setText("pos:".concat(String.valueOf(i)));
            ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", Integer.valueOf(i), Integer.valueOf(itemWidth));
            if (!(bVar2 == null || bVar2.type == 2)) {
                com.tencent.mm.pluginsdk.ui.a.b.r(bVar.iqT, bVar2.vGE);
                bVar.gne.setText(s.mJ(bVar2.vGE));
                if (bVar2.jQz) {
                    bVar.jQj.setVisibility(0);
                } else {
                    bVar.jQj.setVisibility(8);
                }
            }
            BizTimeLineHotListView.a(BizTimeLineHotListView.this, bVar, bVar2, i);
            AppMethodBeat.o(14286);
        }
    }

    public class b extends v {
        public View apJ;
        public TextView gne;
        public ImageView iYd;
        public FrameLayout iYe;
        public ImageView iqT;
        public ImageView jQj;

        public b(View view) {
            super(view);
            AppMethodBeat.i(14289);
            this.apJ = view;
            view.getLayoutParams().width = BizTimeLineHotListView.this.getResources().getDisplayMetrics().widthPixels / 4;
            this.iqT = (ImageView) view.findViewById(R.id.a7h);
            this.iYd = (ImageView) view.findViewById(R.id.a7i);
            this.iYe = (FrameLayout) view.findViewById(R.id.a7g);
            this.gne = (TextView) view.findViewById(R.id.a7k);
            this.jQj = (ImageView) view.findViewById(R.id.a7j);
            AppMethodBeat.o(14289);
        }
    }

    public BizTimeLineHotListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(14290);
        this.mContext = context;
        AppMethodBeat.o(14290);
    }

    public BizTimeLineHotListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(14291);
        this.mContext = context;
        AppMethodBeat.o(14291);
    }

    public final void aZ(List<b> list) {
        AppMethodBeat.i(14292);
        this.iKa.clear();
        this.iKa.addAll(list);
        aR(this.iKa);
        this.jQf.aop.notifyChanged();
        AppMethodBeat.o(14292);
    }

    public a getAdapter() {
        return this.jQf;
    }

    public final boolean aSd() {
        return false;
    }

    public final void aWJ() {
        AppMethodBeat.i(14293);
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.iKa);
        com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
            public final void run() {
                AppMethodBeat.i(14280);
                int currentPage = BizTimeLineHotListView.this.getCurrentPage();
                int rb = f.rb(currentPage);
                int rc = f.rc(currentPage);
                if (currentPage == 0) {
                    rb++;
                }
                int i = rb;
                while (i <= rc && i < arrayList.size()) {
                    b bVar = (b) arrayList.get(i);
                    if (bVar != null) {
                        e a = BizTimeLineHotListView.this.jQg;
                        if (bVar != null) {
                            bfe bfe = (bfe) a.jQB.get(bVar.vGE);
                            if (bfe == null) {
                                bfe bfe2 = new bfe();
                                bfe2.vNN = bVar.vGE;
                                bfe2.wIV = bVar.jQz ? 1 : 0;
                                bfe2.wIW = (int) (System.currentTimeMillis() / 1000);
                                bfe2.mXP = bVar.position - 1;
                                bfe2.kaG = 1;
                                a.jQB.put(bVar.vGE, bfe2);
                            } else {
                                int i2;
                                if (bVar.jQz) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                bfe.wIV = i2;
                                bfe.wIW = (int) (System.currentTimeMillis() / 1000);
                                bfe.mXP = bVar.position - 1;
                                bfe.kaG++;
                            }
                        }
                    }
                    i++;
                }
                AppMethodBeat.o(14280);
            }
        }, 0);
        AppMethodBeat.o(14293);
    }

    public final void a(Context context, List<b> list, e eVar) {
        AppMethodBeat.i(14294);
        this.jQg = eVar;
        this.iKa.addAll(list);
        aR(this.iKa);
        this.jQf = new a(context);
        AnonymousClass2 anonymousClass2 = new LinearLayoutManager() {
            public final boolean iE() {
                return false;
            }
        };
        anonymousClass2.setOrientation(0);
        setLayoutManager(anonymousClass2);
        setAdapter(this.jQf);
        this.jQe = new f(getCustomItemCount());
        f fVar = this.jQe;
        int completelyCountPerPage = a.getCompletelyCountPerPage();
        fVar.mContext = context;
        fVar.jQE = this;
        fVar.jom = completelyCountPerPage;
        fVar.jQE.b((m) fVar);
        fVar.jQE.a((m) fVar);
        fVar.jop = (LinearLayoutManager) fVar.jQE.getLayoutManager();
        fVar.aoC = new com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.AnonymousClass1(fVar.jQE.getContext());
        fVar.jol = new com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.AnonymousClass2(fVar.jQE.getContext());
        setOnScrollPageListener(new com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.a() {
            public final void sj(int i) {
                AppMethodBeat.i(14282);
                int currentPage = BizTimeLineHotListView.this.getCurrentPage();
                ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo ScrollPageListener onScrolled offsetOfCurPage: %d, , currentPage: %d", Integer.valueOf(i), Integer.valueOf(currentPage));
                BizTimeLineHotListView.d(BizTimeLineHotListView.this);
                AppMethodBeat.o(14282);
            }

            public final void fy(boolean z) {
                AppMethodBeat.i(14283);
                if (!z) {
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    h.pYm.e(15721, "", Integer.valueOf(0), Integer.valueOf(10), Integer.valueOf(currentTimeMillis), Integer.valueOf(com.tencent.mm.storage.s.getSessionId()));
                }
                BizTimeLineHotListView.this.aWJ();
                AppMethodBeat.o(14283);
            }
        });
        setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a() {
            public final void I(View view, int i) {
                int i2 = 0;
                AppMethodBeat.i(14281);
                b bVar = (b) BizTimeLineHotListView.this.iKa.get(i);
                if (bVar == null) {
                    AppMethodBeat.o(14281);
                    return;
                }
                e a = BizTimeLineHotListView.this.jQg;
                if (bVar != null) {
                    bfb bfb;
                    Iterator it = a.jQC.iterator();
                    while (it.hasNext()) {
                        bfb = (bfb) it.next();
                        if (bo.isEqual(bfb.vNN, bVar.vGE)) {
                            bfb.wIW = (int) (System.currentTimeMillis() / 1000);
                            if (bVar.jQz) {
                                i2 = 1;
                            }
                            bfb.wIV = i2;
                        }
                    }
                    bfb = new bfb();
                    bfb.vNN = bVar.vGE;
                    bfb.mXP = bVar.position - 1;
                    bfb.wIW = (int) (System.currentTimeMillis() / 1000);
                    if (bVar.jQz) {
                        i2 = 1;
                    }
                    bfb.wIV = i2;
                    a.jQC.add(bfb);
                }
                Intent intent = new Intent();
                intent.putExtra("Chat_User", bVar.vGE);
                intent.putExtra("finish_direct", true);
                intent.putExtra("KOpenArticleSceneFromScene", 91);
                intent.putExtra("specific_chat_from_scene", 8);
                intent.putExtra("preChatTYPE", 12);
                d.f(BizTimeLineHotListView.this.mContext, ".ui.chatting.ChattingUI", intent);
                AppMethodBeat.o(14281);
            }
        });
        AppMethodBeat.o(14294);
    }

    private void g(v vVar, int i) {
        AppMethodBeat.i(14295);
        ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha pos: %d", Integer.valueOf(i));
        if (vVar != null) {
            float x = vVar.apJ.getX();
            if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2)))) {
                vVar.apJ.setAlpha(0.3f);
                AppMethodBeat.o(14295);
                return;
            } else if (x >= ((float) (this.mScreenWidth - (getItemWidth() / 2))) || x < this.jnU) {
                vVar.apJ.setAlpha(1.0f);
            } else {
                ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo updateAlpha %f", Float.valueOf(1.0f - (((x - this.jnU) / ((float) this.jnV)) * 0.7f)));
                vVar.apJ.setAlpha(x);
                AppMethodBeat.o(14295);
                return;
            }
        }
        AppMethodBeat.o(14295);
    }

    public final boolean ak(int i, int i2) {
        AppMethodBeat.i(14296);
        f fVar = this.jQe;
        fVar.N(fVar.qY(fVar.mOffsetX + i), false);
        boolean ak = super.ak(i, i2);
        AppMethodBeat.o(14296);
        return ak;
    }

    public int getCurrentPage() {
        if (this.jQe != null) {
            return this.jQe.jiy;
        }
        return 0;
    }

    private int getItemPadding() {
        AppMethodBeat.i(14297);
        int dj = a.dj(getContext());
        AppMethodBeat.o(14297);
        return dj;
    }

    public void setOnScrollPageListener(com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.a aVar) {
        if (this.jQe != null) {
            this.jQe.jQG = aVar;
        }
    }

    public int getDataCount() {
        AppMethodBeat.i(14298);
        int size = this.iKa.size();
        AppMethodBeat.o(14298);
        return size;
    }

    public int getCustomItemCount() {
        return 1;
    }

    /* Access modifiers changed, original: protected */
    public float getShowCountPerPage() {
        AppMethodBeat.i(14299);
        float showCountPerPage = a.getShowCountPerPage();
        AppMethodBeat.o(14299);
        return showCountPerPage;
    }

    public int getItemWidth() {
        AppMethodBeat.i(14300);
        int di = a.di(this.mContext);
        AppMethodBeat.o(14300);
        return di;
    }

    public int getShowCount() {
        return 12;
    }

    private void aR(List<b> list) {
        AppMethodBeat.i(14301);
        if (this.iKa == null) {
            AppMethodBeat.o(14301);
            return;
        }
        b bVar = new b((byte) 0);
        bVar.vGE = "__BizTimeLine.CustomItem__";
        list.add(0, bVar);
        AppMethodBeat.o(14301);
    }

    static /* synthetic */ void d(BizTimeLineHotListView bizTimeLineHotListView) {
        AppMethodBeat.i(14303);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bizTimeLineHotListView.getLayoutManager();
        if (linearLayoutManager != null) {
            bizTimeLineHotListView.mScreenWidth = bizTimeLineHotListView.getResources().getDisplayMetrics().widthPixels;
            bizTimeLineHotListView.jnV = bizTimeLineHotListView.getItemPadding() + com.tencent.mm.bz.a.fromDPToPix(bizTimeLineHotListView.getContext(), 50);
            bizTimeLineHotListView.jnU = (float) ((bizTimeLineHotListView.mScreenWidth - (bizTimeLineHotListView.getItemWidth() / 2)) - bizTimeLineHotListView.jnV);
            int iS = linearLayoutManager.iS();
            int iT = linearLayoutManager.iT();
            ab.d("MicroMsg.BizTimeLineHotListView", "alvinluo onScroll mAlphaChangeOffset: %s, ALPHA_DISTANCE: %d", Float.valueOf(bizTimeLineHotListView.jnU), Integer.valueOf(bizTimeLineHotListView.jnV));
            v cf = bizTimeLineHotListView.cf(iS);
            v cf2 = bizTimeLineHotListView.cf(iT);
            bizTimeLineHotListView.g(cf, iS);
            bizTimeLineHotListView.g(cf2, iT);
        }
        AppMethodBeat.o(14303);
    }

    static /* synthetic */ void a(BizTimeLineHotListView bizTimeLineHotListView, b bVar, b bVar2, int i) {
        AppMethodBeat.i(14304);
        if (bVar2 == null || bVar == null || bVar.apJ == null) {
            AppMethodBeat.o(14304);
            return;
        }
        if (bVar2.type == 2) {
            bVar.apJ.setVisibility(4);
            bVar.apJ.getLayoutParams().width = 0;
        }
        int dx = a.dx(bizTimeLineHotListView.getContext());
        bVar.iYe.getLayoutParams().width = (com.tencent.mm.bz.a.am(bizTimeLineHotListView.getContext(), R.dimen.nc) * 2) + dx;
        bVar.iYe.getLayoutParams().height = (com.tencent.mm.bz.a.am(bizTimeLineHotListView.getContext(), R.dimen.nc) * 2) + dx;
        bVar.iqT.getLayoutParams().width = dx;
        bVar.iqT.getLayoutParams().height = dx;
        bVar.iYd.getLayoutParams().width = dx;
        bVar.iYd.getLayoutParams().height = dx;
        dx = bizTimeLineHotListView.getCurrentPage();
        int rb = f.rb(dx);
        ab.i("MicroMsg.BizTimeLineHotListView", "alvinluo configView curPage: %d, firstPositionOfCurPage: %d, lastPositionOfCurPage: %d, position: %d", Integer.valueOf(dx), Integer.valueOf(rb), Integer.valueOf(f.rc(dx)), Integer.valueOf(i));
        if (i == f.rc(dx)) {
            bVar.apJ.setAlpha(0.3f);
            AppMethodBeat.o(14304);
            return;
        }
        bVar.apJ.setVisibility(0);
        bVar.apJ.setAlpha(1.0f);
        AppMethodBeat.o(14304);
    }
}
