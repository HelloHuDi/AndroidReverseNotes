package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class BaseAppBrandRecentView extends AppBrandRecentView implements com.tencent.mm.sdk.e.k.a {
    protected int aKu = 0;
    private float ati;
    private float atj;
    List<a> iJL = new ArrayList();
    protected f jax;
    private a jnA;
    public e jnB = null;
    boolean jnC = false;
    private com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.d jnD = null;
    private final Object jnE = new Object();
    private boolean jnF = false;
    private al jnG = null;
    private ConcurrentLinkedQueue<d> jnH = new ConcurrentLinkedQueue();
    private com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.c jnI = new com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.c<LocalUsageInfo>() {
        public final List<LocalUsageInfo> qr(int i) {
            AppMethodBeat.i(134341);
            List nA = ((ag) g.K(ag.class)).nA(i);
            AppMethodBeat.o(134341);
            return nA;
        }
    };
    private float jnJ = 1.0f;
    private boolean jnK = false;
    protected float jnw;
    private com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b jnx;
    public List<a> jny = new ArrayList();
    private d jnz;
    private Context mContext;

    protected class a extends android.support.v7.widget.RecyclerView.a<c> {
        com.tencent.mm.at.a.a.c.a jnM;

        /* synthetic */ a(BaseAppBrandRecentView baseAppBrandRecentView, byte b) {
            this();
        }

        private a() {
            AppMethodBeat.i(134342);
            this.jnM = new com.tencent.mm.at.a.a.c.a();
            this.jnM.ePT = R.raw.default_avatar;
            AppMethodBeat.o(134342);
        }

        public final int getItemCount() {
            AppMethodBeat.i(134343);
            int size = BaseAppBrandRecentView.this.jny.size();
            int completelyCountPerPage = BaseAppBrandRecentView.this.getCompletelyCountPerPage();
            if (BaseAppBrandRecentView.this.getCustomItemCount() == 1) {
                size--;
            }
            if (size > BaseAppBrandRecentView.this.getShowCount()) {
                size = BaseAppBrandRecentView.this.getShowCount();
            }
            if (BaseAppBrandRecentView.this.getCustomItemCount() == 1) {
                if (size % completelyCountPerPage == 0) {
                    size++;
                } else {
                    size += (completelyCountPerPage + 1) - (size % completelyCountPerPage);
                }
                size += BaseAppBrandRecentView.this.getCustomItemCount();
                AppMethodBeat.o(134343);
                return size;
            }
            if (size % completelyCountPerPage != 0) {
                size += completelyCountPerPage - (size % completelyCountPerPage);
            }
            AppMethodBeat.o(134343);
            return size;
        }
    }

    class b extends android.support.v7.h.c.a {
        private List<a> iPo;
        private List<a> iPp;

        public b(List list, List list2) {
            this.iPp = list;
            this.iPo = list2;
        }

        public final int fV() {
            AppMethodBeat.i(134346);
            if (this.iPo != null) {
                int size = this.iPo.size();
                AppMethodBeat.o(134346);
                return size;
            }
            AppMethodBeat.o(134346);
            return 0;
        }

        public final int fW() {
            AppMethodBeat.i(134347);
            if (this.iPp != null) {
                int size = this.iPp.size();
                AppMethodBeat.o(134347);
                return size;
            }
            AppMethodBeat.o(134347);
            return 0;
        }

        public final boolean J(int i, int i2) {
            AppMethodBeat.i(134348);
            a aVar = (a) this.iPp.get(i2);
            a aVar2 = (a) this.iPo.get(i);
            if (aVar == null || aVar2 == null || aVar.iXW == null || aVar2.iXW == null) {
                if (aVar == null || aVar2 == null) {
                    AppMethodBeat.o(134348);
                    return false;
                } else if (aVar.type == 3 && aVar2.type == 3) {
                    AppMethodBeat.o(134348);
                    return true;
                } else {
                    AppMethodBeat.o(134348);
                    return false;
                }
            } else if (bo.nullAsNil(aVar2.iXW.username).equals(aVar.iXW.username) && aVar2.iXW.har == aVar.iXW.har) {
                AppMethodBeat.o(134348);
                return true;
            } else {
                AppMethodBeat.o(134348);
                return false;
            }
        }

        public final boolean K(int i, int i2) {
            AppMethodBeat.i(134349);
            a aVar = (a) this.iPp.get(i2);
            a aVar2 = (a) this.iPo.get(i);
            if (aVar != null && aVar2 != null && aVar.iXW != null && aVar2.iXW != null) {
                boolean equals = bo.nullAsNil(aVar2.iXW.haO).equals(aVar.iXW.haO);
                AppMethodBeat.o(134349);
                return equals;
            } else if (aVar == null || aVar2 == null) {
                AppMethodBeat.o(134349);
                return false;
            } else if (aVar.type == 3 && aVar2.type == 3) {
                AppMethodBeat.o(134349);
                return true;
            } else {
                AppMethodBeat.o(134349);
                return false;
            }
        }
    }

    public class c extends v {
        public View apJ;
        public TextView gne;
        public ImageView iYd;
        public FrameLayout iYe;
        public TextView iYf;
        public ImageView iqT;

        public c(View view) {
            super(view);
            AppMethodBeat.i(134352);
            this.apJ = view;
            view.setOnClickListener(new OnClickListener(BaseAppBrandRecentView.this) {
                public final void onClick(View view) {
                    AppMethodBeat.i(134350);
                    a aVar = (a) view.getTag();
                    aVar.position = c.this.kj();
                    if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
                        BaseAppBrandRecentView.this.getOnItemClickListener().a(view, aVar, BaseAppBrandRecentView.this.ati, BaseAppBrandRecentView.this.atj);
                    }
                    AppMethodBeat.o(134350);
                }
            });
            view.setOnLongClickListener(new OnLongClickListener(BaseAppBrandRecentView.this) {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(134351);
                    a aVar = (a) view.getTag();
                    aVar.position = c.this.kj();
                    if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
                        BaseAppBrandRecentView.this.getOnItemClickListener().b(view, aVar, BaseAppBrandRecentView.this.ati, BaseAppBrandRecentView.this.atj);
                    }
                    BaseAppBrandRecentView.this.jnK = true;
                    AppMethodBeat.o(134351);
                    return true;
                }
            });
            view.getLayoutParams().width = BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4;
            this.iqT = (ImageView) view.findViewById(R.id.jb);
            this.iYd = (ImageView) view.findViewById(R.id.yp);
            this.iYe = (FrameLayout) view.findViewById(R.id.yv);
            this.gne = (TextView) view.findViewById(R.id.cx);
            this.iYf = (TextView) view.findViewById(R.id.yq);
            AppMethodBeat.o(134352);
        }
    }

    class d implements Runnable {
        List<a> iKa;
        List<a> jnP;
        boolean jnQ;

        public d() {
            AppMethodBeat.i(134354);
            this.jnQ = true;
            this.jnQ = true;
            this.iKa = new ArrayList();
            this.jnP = new ArrayList();
            AppMethodBeat.o(134354);
        }

        public final void run() {
            AppMethodBeat.i(134355);
            synchronized (BaseAppBrandRecentView.this.jnE) {
                try {
                    BaseAppBrandRecentView.this.jnF = true;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(134355);
                    }
                }
            }
            List list = null;
            if (BaseAppBrandRecentView.this.jnI != null) {
                list = BaseAppBrandRecentView.this.jnI.qr(BaseAppBrandRecentView.this.getLoadCount());
            }
            this.iKa.clear();
            this.jnP.clear();
            if (list != null) {
                LocalUsageInfo aJZ = BaseAppBrandRecentView.this.getSceneFactory() != null ? BaseAppBrandRecentView.this.getSceneFactory().aJZ() : null;
                for (LocalUsageInfo localUsageInfo : list) {
                    if (aJZ == null || !localUsageInfo.username.equals(aJZ.username) || localUsageInfo.har != aJZ.har) {
                        if (this.iKa.size() < BaseAppBrandRecentView.this.getShowCount()) {
                            this.iKa.add(new a(localUsageInfo));
                        }
                        if (BaseAppBrandRecentView.this.jnC) {
                            this.jnP.add(new a(localUsageInfo));
                        }
                        ab.d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", localUsageInfo.username, localUsageInfo.nickname, localUsageInfo.bQo, localUsageInfo.haO, localUsageInfo.appId, Integer.valueOf(localUsageInfo.har), BaseAppBrandRecentView.this.jax);
                    }
                }
            }
            BaseAppBrandRecentView.this.aR(this.iKa);
            ab.i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.this.jny.size()), Integer.valueOf(BaseAppBrandRecentView.this.iJL.size()), BaseAppBrandRecentView.this.jax);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(134353);
                    android.support.v7.h.c.a(new b(d.this.iKa, BaseAppBrandRecentView.this.jny));
                    BaseAppBrandRecentView.this.jny.clear();
                    BaseAppBrandRecentView.this.iJL.clear();
                    BaseAppBrandRecentView.this.jny.addAll(d.this.iKa);
                    BaseAppBrandRecentView.this.iJL.addAll(d.this.jnP);
                    d.this.iKa.clear();
                    d.this.jnP.clear();
                    if (BaseAppBrandRecentView.this.getRefreshListener() != null && d.this.jnQ) {
                        BaseAppBrandRecentView.this.getRefreshListener().qs(BaseAppBrandRecentView.this.jny.size());
                    }
                    if (d.this.jnQ) {
                        ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", BaseAppBrandRecentView.this.jax);
                        f fVar = f.RECENT_APP_BRAND;
                        BaseAppBrandRecentView.this.getAdapter().aop.notifyChanged();
                    }
                    synchronized (BaseAppBrandRecentView.this.jnE) {
                        try {
                            BaseAppBrandRecentView.this.jnF = false;
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(134353);
                        }
                    }
                    BaseAppBrandRecentView.j(BaseAppBrandRecentView.this);
                }
            });
            AppMethodBeat.o(134355);
        }
    }

    public abstract int getLayoutId();

    public abstract int getLoadCount();

    public abstract int getShowCount();

    public abstract String getType();

    public void setEnableDataCache(boolean z) {
        this.jnC = z;
    }

    public void setOnDataChangedListener(com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.d dVar) {
        this.jnD = dVar;
    }

    public BaseAppBrandRecentView(Context context) {
        super(context);
        init(context);
    }

    public BaseAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    /* Access modifiers changed, original: protected */
    public int getCompletelyCountPerPage() {
        return 4;
    }

    /* Access modifiers changed, original: protected */
    public float getShowCountPerPage() {
        return 4.0f;
    }

    /* Access modifiers changed, original: protected */
    public void init(Context context) {
        this.mContext = context;
        this.jnw = context.getResources().getDimension(R.dimen.fj);
        AnonymousClass2 anonymousClass2 = new LinearLayoutManager() {
            public final boolean iE() {
                return false;
            }
        };
        anonymousClass2.setOrientation(0);
        setLayoutManager(anonymousClass2);
        setHasFixedSize(true);
        a aVar = new a(this, (byte) 0);
        this.jnA = aVar;
        setAdapter(aVar);
        this.jnB = new e(getCustomItemCount());
        e eVar = this.jnB;
        Context context2 = getContext();
        int completelyCountPerPage = getCompletelyCountPerPage();
        eVar.mContext = context2;
        eVar.joi = this;
        eVar.jom = completelyCountPerPage;
        eVar.joi.b((m) eVar);
        eVar.joi.a((m) eVar);
        eVar.jop = (LinearLayoutManager) eVar.joi.getLayoutManager();
        eVar.aoC = new com.tencent.mm.plugin.appbrand.widget.recentview.e.AnonymousClass1(eVar.joi.getContext());
        eVar.jol = new com.tencent.mm.plugin.appbrand.widget.recentview.e.AnonymousClass2(eVar.joi.getContext());
    }

    public final boolean ak(int i, int i2) {
        e eVar = this.jnB;
        eVar.N(eVar.qY(eVar.mOffsetX + i), false);
        return super.ak(i, i2);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.ati = motionEvent.getRawX();
            this.atj = motionEvent.getRawY();
        } else if (motionEvent.getAction() == 2 && this.jnK) {
            return true;
        }
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            this.jnK = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean canScrollHorizontally(int i) {
        return true;
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.aKu = getMeasuredWidth();
        ab.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", Integer.valueOf(this.aKu));
    }

    public void setOnItemClickListener(com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b bVar) {
        this.jnx = bVar;
    }

    public final void refresh() {
        if (this.jnG == null) {
            this.jnG = new al("UpdateAppBrandList_" + this.jax);
        }
        synchronized (this.jnE) {
            if (this.jnF) {
                ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", this.jax);
                if (this.jnH.size() <= 0) {
                    ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
                    this.jnH.add(new d());
                }
            } else {
                this.jnF = true;
                this.jnG.aa(new d());
            }
        }
    }

    public void setType(f fVar) {
        this.jax = fVar;
        if (this.jax == f.MY_APP_BRAND) {
            if (g.K(af.class) != null) {
                ((af) g.K(af.class)).c(this);
            }
        } else if (this.jax == f.RECENT_APP_BRAND && g.K(ag.class) != null) {
            ((ag) g.K(ag.class)).c(this);
        }
    }

    public void setDataQuery(com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.c cVar) {
        this.jnI = cVar;
    }

    public final void release() {
        if (this.jax == f.MY_APP_BRAND) {
            if (g.K(af.class) != null) {
                ((af) g.K(af.class)).d(this);
            }
        } else if (this.jax == f.RECENT_APP_BRAND && g.K(ag.class) != null) {
            ((ag) g.K(ag.class)).d(this);
        }
        if (this.jnz != null) {
            com.tencent.mm.sdk.g.d.xDG.remove(this.jnz);
        }
        this.jny.clear();
        if (this.jnG != null) {
            this.jnG.oAl.quit();
        }
    }

    public com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b getOnItemClickListener() {
        return this.jnx;
    }

    public void aR(List<a> list) {
    }

    public int getCustomItemCount() {
        return 0;
    }

    public void a(String str, com.tencent.mm.sdk.e.m mVar) {
        ab.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", ((h) g.RM().Rn()).toString(), Integer.valueOf(mVar.hsh), this.jax);
        if (mVar.hsh == 5 && aRZ()) {
            ab.i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
        } else {
            refresh();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean aRZ() {
        return false;
    }

    public android.support.v7.widget.RecyclerView.a getAdapter() {
        return this.jnA;
    }

    public int getItemWidth() {
        return 0;
    }

    public void a(c cVar, a aVar, int i) {
        int itemWidth = getItemWidth();
        float showCountPerPage = getShowCountPerPage();
        if (itemWidth <= 0) {
            itemWidth = (int) (((float) getWidth()) / showCountPerPage);
        }
        if (itemWidth <= 0) {
            itemWidth = (int) (((float) getResources().getDisplayMetrics().widthPixels) / showCountPerPage);
        }
        if (i == this.jnA.getItemCount() - 1) {
            itemWidth = (int) ((1.0d - (Math.ceil((double) showCountPerPage) - ((double) showCountPerPage))) * ((double) itemWidth));
            ab.i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", Integer.valueOf(i), Integer.valueOf(itemWidth));
        }
        cVar.apJ.getLayoutParams().width = itemWidth;
        cVar.apJ.setScaleX(1.0f);
        cVar.apJ.setScaleY(1.0f);
        ab.d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", Integer.valueOf(i), Integer.valueOf(itemWidth));
        if (aVar != null && aVar.type == 1 && aVar.iXW != null) {
            if (!bo.isNullOrNil(aVar.iXW.bQo)) {
                cVar.gne.setText(EU(aVar.iXW.bQo));
                cVar.gne.setVisibility(0);
            } else if (!bo.isNullOrNil(aVar.iXW.nickname)) {
                cVar.gne.setText(EU(aVar.iXW.nickname));
                cVar.gne.setVisibility(0);
            } else if (bo.isNullOrNil(aVar.iXW.username)) {
                ab.w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", aVar.iXW.username, aVar.iXW.appId);
                cVar.gne.setText("");
                cVar.gne.setVisibility(4);
            } else {
                cVar.gne.setText(aVar.iXW.username);
                cVar.gne.setVisibility(0);
            }
            cVar.iYd.setVisibility(0);
            if (bo.isNullOrNil(aVar.iXW.haO)) {
                cVar.iqT.setImageDrawable(com.tencent.mm.modelappbrand.a.a.abQ());
            } else {
                com.tencent.mm.modelappbrand.a.b.abR().a(cVar.iqT, aVar.iXW.haO, com.tencent.mm.modelappbrand.a.a.abQ(), com.tencent.mm.modelappbrand.a.f.fqH);
            }
        }
    }

    private static String EU(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (com.tencent.mm.ui.tools.f.asg(str) <= 11) {
                return str;
            }
            char[] toCharArray = str.toCharArray();
            int length = toCharArray.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                i3 += com.tencent.mm.ui.tools.f.asg(String.valueOf(toCharArray[i]));
                if (i3 >= 11) {
                    return str.substring(0, i2) + 8230;
                }
                i++;
                i2++;
            }
            return str;
        } catch (Exception e) {
            return str;
        }
    }

    public int getCount() {
        return this.jny.size();
    }

    /* Access modifiers changed, original: protected */
    public void qW(int i) {
        if (this.jnC && i - 1 < this.iJL.size()) {
            this.iJL.remove(i - 1);
        }
    }

    /* Access modifiers changed, original: protected */
    public com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.d getOnDataChangedListener() {
        return this.jnD;
    }

    public List<a> getPreviewItemList() {
        if (this.jny == null) {
            this.jny = new ArrayList();
        }
        return this.jny;
    }

    public int getDataCount() {
        if (this.jny != null) {
            return this.jny.size();
        }
        return 0;
    }

    public int getCurrentPage() {
        if (this.jnB != null) {
            return this.jnB.jiy;
        }
        return 0;
    }

    public void setOnScrollPageListener(com.tencent.mm.plugin.appbrand.widget.recentview.e.a aVar) {
        if (this.jnB != null) {
            this.jnB.jor = aVar;
        }
    }

    static /* synthetic */ void j(BaseAppBrandRecentView baseAppBrandRecentView) {
        synchronized (baseAppBrandRecentView.jnE) {
            if (baseAppBrandRecentView.jnH.size() > 0) {
                d dVar = (d) baseAppBrandRecentView.jnH.poll();
                if (dVar != null) {
                    baseAppBrandRecentView.jnG.aa(dVar);
                }
            }
        }
    }
}
