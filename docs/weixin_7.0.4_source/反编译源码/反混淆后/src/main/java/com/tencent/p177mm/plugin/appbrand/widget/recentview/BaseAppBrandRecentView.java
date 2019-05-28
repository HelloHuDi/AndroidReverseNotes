package com.tencent.p177mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.p069v7.p075h.C0595c;
import android.support.p069v7.p075h.C0595c.C0597a;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C26767ag;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C19907f;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38617c;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38618d;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38620b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e.C110512;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e.C274301;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e.C33648a;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView */
public abstract class BaseAppBrandRecentView extends AppBrandRecentView implements C4931a {
    protected int aKu = 0;
    private float ati;
    private float atj;
    List<C42748a> iJL = new ArrayList();
    protected C19907f jax;
    private C19908a jnA;
    public C33646e jnB = null;
    boolean jnC = false;
    private C38618d jnD = null;
    private final Object jnE = new Object();
    private boolean jnF = false;
    private C5004al jnG = null;
    private ConcurrentLinkedQueue<C27428d> jnH = new ConcurrentLinkedQueue();
    private C38617c jnI = new C427461();
    private float jnJ = 1.0f;
    private boolean jnK = false;
    protected float jnw;
    private C38620b jnx;
    public List<C42748a> jny = new ArrayList();
    private C27428d jnz;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView$a */
    protected class C19908a extends C41523a<C19910c> {
        C17927a jnM;

        /* synthetic */ C19908a(BaseAppBrandRecentView baseAppBrandRecentView, byte b) {
            this();
        }

        private C19908a() {
            AppMethodBeat.m2504i(134342);
            this.jnM = new C17927a();
            this.jnM.ePT = C1318a.default_avatar;
            AppMethodBeat.m2505o(134342);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(134343);
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
                AppMethodBeat.m2505o(134343);
                return size;
            }
            if (size % completelyCountPerPage != 0) {
                size += completelyCountPerPage - (size % completelyCountPerPage);
            }
            AppMethodBeat.m2505o(134343);
            return size;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView$b */
    class C19909b extends C0597a {
        private List<C42748a> iPo;
        private List<C42748a> iPp;

        public C19909b(List list, List list2) {
            this.iPp = list;
            this.iPo = list2;
        }

        /* renamed from: fV */
        public final int mo1477fV() {
            AppMethodBeat.m2504i(134346);
            if (this.iPo != null) {
                int size = this.iPo.size();
                AppMethodBeat.m2505o(134346);
                return size;
            }
            AppMethodBeat.m2505o(134346);
            return 0;
        }

        /* renamed from: fW */
        public final int mo1478fW() {
            AppMethodBeat.m2504i(134347);
            if (this.iPp != null) {
                int size = this.iPp.size();
                AppMethodBeat.m2505o(134347);
                return size;
            }
            AppMethodBeat.m2505o(134347);
            return 0;
        }

        /* renamed from: J */
        public final boolean mo1474J(int i, int i2) {
            AppMethodBeat.m2504i(134348);
            C42748a c42748a = (C42748a) this.iPp.get(i2);
            C42748a c42748a2 = (C42748a) this.iPo.get(i);
            if (c42748a == null || c42748a2 == null || c42748a.iXW == null || c42748a2.iXW == null) {
                if (c42748a == null || c42748a2 == null) {
                    AppMethodBeat.m2505o(134348);
                    return false;
                } else if (c42748a.type == 3 && c42748a2.type == 3) {
                    AppMethodBeat.m2505o(134348);
                    return true;
                } else {
                    AppMethodBeat.m2505o(134348);
                    return false;
                }
            } else if (C5046bo.nullAsNil(c42748a2.iXW.username).equals(c42748a.iXW.username) && c42748a2.iXW.har == c42748a.iXW.har) {
                AppMethodBeat.m2505o(134348);
                return true;
            } else {
                AppMethodBeat.m2505o(134348);
                return false;
            }
        }

        /* renamed from: K */
        public final boolean mo1475K(int i, int i2) {
            AppMethodBeat.m2504i(134349);
            C42748a c42748a = (C42748a) this.iPp.get(i2);
            C42748a c42748a2 = (C42748a) this.iPo.get(i);
            if (c42748a != null && c42748a2 != null && c42748a.iXW != null && c42748a2.iXW != null) {
                boolean equals = C5046bo.nullAsNil(c42748a2.iXW.haO).equals(c42748a.iXW.haO);
                AppMethodBeat.m2505o(134349);
                return equals;
            } else if (c42748a == null || c42748a2 == null) {
                AppMethodBeat.m2505o(134349);
                return false;
            } else if (c42748a.type == 3 && c42748a2.type == 3) {
                AppMethodBeat.m2505o(134349);
                return true;
            } else {
                AppMethodBeat.m2505o(134349);
                return false;
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView$c */
    public class C19910c extends C41531v {
        public View apJ;
        public TextView gne;
        public ImageView iYd;
        public FrameLayout iYe;
        public TextView iYf;
        public ImageView iqT;

        public C19910c(View view) {
            super(view);
            AppMethodBeat.m2504i(134352);
            this.apJ = view;
            view.setOnClickListener(new OnClickListener(BaseAppBrandRecentView.this) {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(134350);
                    C42748a c42748a = (C42748a) view.getTag();
                    c42748a.position = C19910c.this.mo66454kj();
                    if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
                        BaseAppBrandRecentView.this.getOnItemClickListener().mo35067a(view, c42748a, BaseAppBrandRecentView.this.ati, BaseAppBrandRecentView.this.atj);
                    }
                    AppMethodBeat.m2505o(134350);
                }
            });
            view.setOnLongClickListener(new OnLongClickListener(BaseAppBrandRecentView.this) {
                public final boolean onLongClick(View view) {
                    AppMethodBeat.m2504i(134351);
                    C42748a c42748a = (C42748a) view.getTag();
                    c42748a.position = C19910c.this.mo66454kj();
                    if (BaseAppBrandRecentView.this.getOnItemClickListener() != null) {
                        BaseAppBrandRecentView.this.getOnItemClickListener().mo35068b(view, c42748a, BaseAppBrandRecentView.this.ati, BaseAppBrandRecentView.this.atj);
                    }
                    BaseAppBrandRecentView.this.jnK = true;
                    AppMethodBeat.m2505o(134351);
                    return true;
                }
            });
            view.getLayoutParams().width = BaseAppBrandRecentView.this.getResources().getDisplayMetrics().widthPixels / 4;
            this.iqT = (ImageView) view.findViewById(2131820915);
            this.iYd = (ImageView) view.findViewById(2131821484);
            this.iYe = (FrameLayout) view.findViewById(2131821502);
            this.gne = (TextView) view.findViewById(2131820678);
            this.iYf = (TextView) view.findViewById(2131821485);
            AppMethodBeat.m2505o(134352);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView$d */
    class C27428d implements Runnable {
        List<C42748a> iKa;
        List<C42748a> jnP;
        boolean jnQ;

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView$d$1 */
        class C274291 implements Runnable {
            C274291() {
            }

            public final void run() {
                AppMethodBeat.m2504i(134353);
                C0595c.m1288a(new C19909b(C27428d.this.iKa, BaseAppBrandRecentView.this.jny));
                BaseAppBrandRecentView.this.jny.clear();
                BaseAppBrandRecentView.this.iJL.clear();
                BaseAppBrandRecentView.this.jny.addAll(C27428d.this.iKa);
                BaseAppBrandRecentView.this.iJL.addAll(C27428d.this.jnP);
                C27428d.this.iKa.clear();
                C27428d.this.jnP.clear();
                if (BaseAppBrandRecentView.this.getRefreshListener() != null && C27428d.this.jnQ) {
                    BaseAppBrandRecentView.this.getRefreshListener().mo6518qs(BaseAppBrandRecentView.this.jny.size());
                }
                if (C27428d.this.jnQ) {
                    C4990ab.m7417i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh done dispatch diffResult, mType: %s", BaseAppBrandRecentView.this.jax);
                    C19907f c19907f = C19907f.RECENT_APP_BRAND;
                    BaseAppBrandRecentView.this.getAdapter().aop.notifyChanged();
                }
                synchronized (BaseAppBrandRecentView.this.jnE) {
                    try {
                        BaseAppBrandRecentView.this.jnF = false;
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(134353);
                    }
                }
                BaseAppBrandRecentView.m75778j(BaseAppBrandRecentView.this);
            }
        }

        public C27428d() {
            AppMethodBeat.m2504i(134354);
            this.jnQ = true;
            this.jnQ = true;
            this.iKa = new ArrayList();
            this.jnP = new ArrayList();
            AppMethodBeat.m2505o(134354);
        }

        public final void run() {
            AppMethodBeat.m2504i(134355);
            synchronized (BaseAppBrandRecentView.this.jnE) {
                try {
                    BaseAppBrandRecentView.this.jnF = true;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(134355);
                    }
                }
            }
            List list = null;
            if (BaseAppBrandRecentView.this.jnI != null) {
                list = BaseAppBrandRecentView.this.jnI.mo45126qr(BaseAppBrandRecentView.this.getLoadCount());
            }
            this.iKa.clear();
            this.jnP.clear();
            if (list != null) {
                LocalUsageInfo aJZ = BaseAppBrandRecentView.this.getSceneFactory() != null ? BaseAppBrandRecentView.this.getSceneFactory().aJZ() : null;
                for (LocalUsageInfo localUsageInfo : list) {
                    if (aJZ == null || !localUsageInfo.username.equals(aJZ.username) || localUsageInfo.har != aJZ.har) {
                        if (this.iKa.size() < BaseAppBrandRecentView.this.getShowCount()) {
                            this.iKa.add(new C42748a(localUsageInfo));
                        }
                        if (BaseAppBrandRecentView.this.jnC) {
                            this.jnP.add(new C42748a(localUsageInfo));
                        }
                        C4990ab.m7411d("MicroMsg.BaseAppBrandRecentView", "alvinluo info %s, %s, %s, %s, %s, %d, mType: %s", localUsageInfo.username, localUsageInfo.nickname, localUsageInfo.bQo, localUsageInfo.haO, localUsageInfo.appId, Integer.valueOf(localUsageInfo.har), BaseAppBrandRecentView.this.jax);
                    }
                }
            }
            BaseAppBrandRecentView.this.mo61442aR(this.iKa);
            C4990ab.m7417i("MicroMsg.BaseAppBrandRecentView", "[UpdateAppBrandRecentDataTask] type:%s preview size:%s, data size: %d, mType: %s", BaseAppBrandRecentView.this.getType(), Integer.valueOf(BaseAppBrandRecentView.this.jny.size()), Integer.valueOf(BaseAppBrandRecentView.this.iJL.size()), BaseAppBrandRecentView.this.jax);
            C5004al.m7441d(new C274291());
            AppMethodBeat.m2505o(134355);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView$1 */
    class C427461 implements C38617c<LocalUsageInfo> {
        C427461() {
        }

        /* renamed from: qr */
        public final List<LocalUsageInfo> mo45126qr(int i) {
            AppMethodBeat.m2504i(134341);
            List nA = ((C26767ag) C1720g.m3528K(C26767ag.class)).mo44540nA(i);
            AppMethodBeat.m2505o(134341);
            return nA;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView$2 */
    class C427472 extends LinearLayoutManager {
        C427472() {
        }

        /* renamed from: iE */
        public final boolean mo1774iE() {
            return false;
        }
    }

    public abstract int getLayoutId();

    public abstract int getLoadCount();

    public abstract int getShowCount();

    public abstract String getType();

    public void setEnableDataCache(boolean z) {
        this.jnC = z;
    }

    public void setOnDataChangedListener(C38618d c38618d) {
        this.jnD = c38618d;
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
        this.jnw = context.getResources().getDimension(C25738R.dimen.f9784fj);
        C427472 c427472 = new C427472();
        c427472.setOrientation(0);
        setLayoutManager(c427472);
        setHasFixedSize(true);
        C19908a c19908a = new C19908a(this, (byte) 0);
        this.jnA = c19908a;
        setAdapter(c19908a);
        this.jnB = new C33646e(getCustomItemCount());
        C33646e c33646e = this.jnB;
        Context context2 = getContext();
        int completelyCountPerPage = getCompletelyCountPerPage();
        c33646e.mContext = context2;
        c33646e.joi = this;
        c33646e.jom = completelyCountPerPage;
        c33646e.joi.mo66348b((C41530m) c33646e);
        c33646e.joi.mo66332a((C41530m) c33646e);
        c33646e.jop = (LinearLayoutManager) c33646e.joi.getLayoutManager();
        c33646e.aoC = new C274301(c33646e.joi.getContext());
        c33646e.jol = new C110512(c33646e.joi.getContext());
    }

    /* renamed from: ak */
    public final boolean mo45329ak(int i, int i2) {
        C33646e c33646e = this.jnB;
        c33646e.mo54213N(c33646e.mo54216qY(c33646e.mOffsetX + i), false);
        return super.mo45329ak(i, i2);
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
        C4990ab.m7411d("MicroMsg.BaseAppBrandRecentView", "alvinluo onMeasure mViewWidth %d", Integer.valueOf(this.aKu));
    }

    public void setOnItemClickListener(C38620b c38620b) {
        this.jnx = c38620b;
    }

    public final void refresh() {
        if (this.jnG == null) {
            this.jnG = new C5004al("UpdateAppBrandList_" + this.jax);
        }
        synchronized (this.jnE) {
            if (this.jnF) {
                C4990ab.m7417i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh is running and delay mType: %s", this.jax);
                if (this.jnH.size() <= 0) {
                    C4990ab.m7416i("MicroMsg.BaseAppBrandRecentView", "alvinluo refresh add updateTask");
                    this.jnH.add(new C27428d());
                }
            } else {
                this.jnF = true;
                this.jnG.mo10302aa(new C27428d());
            }
        }
    }

    public void setType(C19907f c19907f) {
        this.jax = c19907f;
        if (this.jax == C19907f.MY_APP_BRAND) {
            if (C1720g.m3528K(C10118af.class) != null) {
                ((C10118af) C1720g.m3528K(C10118af.class)).mo10116c(this);
            }
        } else if (this.jax == C19907f.RECENT_APP_BRAND && C1720g.m3528K(C26767ag.class) != null) {
            ((C26767ag) C1720g.m3528K(C26767ag.class)).mo10116c(this);
        }
    }

    public void setDataQuery(C38617c c38617c) {
        this.jnI = c38617c;
    }

    public final void release() {
        if (this.jax == C19907f.MY_APP_BRAND) {
            if (C1720g.m3528K(C10118af.class) != null) {
                ((C10118af) C1720g.m3528K(C10118af.class)).mo10117d(this);
            }
        } else if (this.jax == C19907f.RECENT_APP_BRAND && C1720g.m3528K(C26767ag.class) != null) {
            ((C26767ag) C1720g.m3528K(C26767ag.class)).mo10117d(this);
        }
        if (this.jnz != null) {
            C7305d.xDG.remove(this.jnz);
        }
        this.jny.clear();
        if (this.jnG != null) {
            this.jnG.oAl.quit();
        }
    }

    public C38620b getOnItemClickListener() {
        return this.jnx;
    }

    /* renamed from: aR */
    public void mo61442aR(List<C42748a> list) {
    }

    public int getCustomItemCount() {
        return 0;
    }

    /* renamed from: a */
    public void mo5248a(String str, C4935m c4935m) {
        C4990ab.m7417i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] process:%s eventId:%s, mType: %s", ((C6624h) C1720g.m3533RM().mo5224Rn()).toString(), Integer.valueOf(c4935m.hsh), this.jax);
        if (c4935m.hsh == 5 && aRZ()) {
            C4990ab.m7416i("MicroMsg.BaseAppBrandRecentView", "[onNotifyChange] Ignore!!!");
        } else {
            refresh();
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean aRZ() {
        return false;
    }

    public C41523a getAdapter() {
        return this.jnA;
    }

    public int getItemWidth() {
        return 0;
    }

    /* renamed from: a */
    public void mo61441a(C19910c c19910c, C42748a c42748a, int i) {
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
            C4990ab.m7417i("MicroMsg.BaseAppBrandRecentView", "alvinluo lastPosition %d set width %d", Integer.valueOf(i), Integer.valueOf(itemWidth));
        }
        c19910c.apJ.getLayoutParams().width = itemWidth;
        c19910c.apJ.setScaleX(1.0f);
        c19910c.apJ.setScaleY(1.0f);
        C4990ab.m7411d("MicroMsg.BaseAppBrandRecentView", "alvinluo onBindCustomViewHolder postion: %d, width: %d", Integer.valueOf(i), Integer.valueOf(itemWidth));
        if (c42748a != null && c42748a.type == 1 && c42748a.iXW != null) {
            if (!C5046bo.isNullOrNil(c42748a.iXW.bQo)) {
                c19910c.gne.setText(BaseAppBrandRecentView.m75767EU(c42748a.iXW.bQo));
                c19910c.gne.setVisibility(0);
            } else if (!C5046bo.isNullOrNil(c42748a.iXW.nickname)) {
                c19910c.gne.setText(BaseAppBrandRecentView.m75767EU(c42748a.iXW.nickname));
                c19910c.gne.setVisibility(0);
            } else if (C5046bo.isNullOrNil(c42748a.iXW.username)) {
                C4990ab.m7421w("MicroMsg.BaseAppBrandRecentView", "[onBindCustomViewHolder] nickname is null! username:%s appId:%s", c42748a.iXW.username, c42748a.iXW.appId);
                c19910c.gne.setText("");
                c19910c.gne.setVisibility(4);
            } else {
                c19910c.gne.setText(c42748a.iXW.username);
                c19910c.gne.setVisibility(0);
            }
            c19910c.iYd.setVisibility(0);
            if (C5046bo.isNullOrNil(c42748a.iXW.haO)) {
                c19910c.iqT.setImageDrawable(C32804a.abQ());
            } else {
                C37926b.abR().mo60683a(c19910c.iqT, c42748a.iXW.haO, C32804a.abQ(), C42201f.fqH);
            }
        }
    }

    /* renamed from: EU */
    private static String m75767EU(String str) {
        if (str == null) {
            return str;
        }
        try {
            if (C5584f.asg(str) <= 11) {
                return str;
            }
            char[] toCharArray = str.toCharArray();
            int length = toCharArray.length;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (i < length) {
                i3 += C5584f.asg(String.valueOf(toCharArray[i]));
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
    /* renamed from: qW */
    public void mo61454qW(int i) {
        if (this.jnC && i - 1 < this.iJL.size()) {
            this.iJL.remove(i - 1);
        }
    }

    /* Access modifiers changed, original: protected */
    public C38618d getOnDataChangedListener() {
        return this.jnD;
    }

    public List<C42748a> getPreviewItemList() {
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

    public void setOnScrollPageListener(C33648a c33648a) {
        if (this.jnB != null) {
            this.jnB.jor = c33648a;
        }
    }

    /* renamed from: j */
    static /* synthetic */ void m75778j(BaseAppBrandRecentView baseAppBrandRecentView) {
        synchronized (baseAppBrandRecentView.jnE) {
            if (baseAppBrandRecentView.jnH.size() > 0) {
                C27428d c27428d = (C27428d) baseAppBrandRecentView.jnH.poll();
                if (c27428d != null) {
                    baseAppBrandRecentView.jnG.mo10302aa(c27428d);
                }
            }
        }
    }
}
