package com.tencent.p177mm.plugin.appbrand.widget.desktop.half;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.support.p069v7.widget.RecyclerView.C25373h;
import android.support.p069v7.widget.RecyclerView.C41525c;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af;
import com.tencent.p177mm.plugin.appbrand.appusage.C10118af.C10117a;
import com.tencent.p177mm.plugin.appbrand.appusage.C26767ag;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C10958c;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C10969d;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a.C42729b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C19906a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C19907f;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38617c;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38618d;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38619e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38620b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.C19910c;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19916b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19920c;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C33646e.C33647b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C42748a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.C11047a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView */
public class AppBrandDesktopHalfItemView extends LinearLayout {
    private C41530m anZ = null;
    private int iWJ = 0;
    ConversationAppBrandRecentView iWW;
    private int iYI = 0;
    private int ivr = 1;
    boolean jaA = false;
    private C42729b jaB = null;
    private boolean jaC = true;
    private AnimatorListener jaD = new C273852();
    private TextView jao;
    private ImageView jap;
    private C38619e jaq = null;
    C41525c jar = null;
    private C38620b jas = null;
    private C19916b jat = null;
    private LinearLayout jau = null;
    private FrameLayout jav = null;
    private View jaw = null;
    private C19907f jax;
    private float jay = 0.0f;
    C19849a jaz = null;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$7 */
    class C198457 implements C38619e {
        C198457() {
        }

        /* renamed from: qs */
        public final void mo6518qs(int i) {
            AppMethodBeat.m2504i(134131);
            if (AppBrandDesktopHalfItemView.this.jaq != null) {
                AppBrandDesktopHalfItemView.this.jaq.mo6518qs(i);
            }
            AppMethodBeat.m2505o(134131);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$8 */
    class C198468 extends C41525c {
        C198468() {
        }

        /* renamed from: ax */
        public final void mo6644ax(int i, int i2) {
            AppMethodBeat.m2504i(134132);
            super.mo6644ax(i, i2);
            if (AppBrandDesktopHalfItemView.this.jar != null) {
                AppBrandDesktopHalfItemView.this.jar.mo6644ax(i, i2);
            }
            AppMethodBeat.m2505o(134132);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$9 */
    class C198479 implements C38620b {
        C198479() {
        }

        /* renamed from: a */
        public final boolean mo35067a(View view, C42748a c42748a, float f, float f2) {
            AppMethodBeat.m2504i(134133);
            if (AppBrandDesktopHalfItemView.this.jas != null) {
                boolean a = AppBrandDesktopHalfItemView.this.jas.mo35067a(view, c42748a, f, f2);
                AppMethodBeat.m2505o(134133);
                return a;
            }
            AppMethodBeat.m2505o(134133);
            return false;
        }

        /* renamed from: b */
        public final boolean mo35068b(View view, C42748a c42748a, float f, float f2) {
            AppMethodBeat.m2504i(134134);
            if (AppBrandDesktopHalfItemView.this.jas != null) {
                boolean b = AppBrandDesktopHalfItemView.this.jas.mo35068b(view, c42748a, f, f2);
                AppMethodBeat.m2505o(134134);
                return b;
            }
            AppMethodBeat.m2505o(134134);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$a */
    class C19849a {
        int ape;
        int jaF;
        C41531v jaG;

        /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$a$1 */
        class C198481 implements Runnable {
            C198481() {
            }

            public final void run() {
                AppMethodBeat.m2504i(134137);
                if (!(C19849a.this.jaG == null || ((C19910c) C19849a.this.jaG).iYe == null)) {
                    ((C19910c) C19849a.this.jaG).iYe.animate().scaleX(1.0f).scaleY(1.0f).setListener(AppBrandDesktopHalfItemView.this.jaD).setDuration(150).start();
                }
                AppMethodBeat.m2505o(134137);
            }
        }

        private C19849a() {
            this.ape = -1;
            this.jaF = -1;
            this.jaG = null;
        }

        /* synthetic */ C19849a(AppBrandDesktopHalfItemView appBrandDesktopHalfItemView, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$6 */
    class C273806 implements OnClickListener {
        C273806() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134130);
            if (AppBrandDesktopHalfItemView.this.jax == C19907f.MY_APP_BRAND) {
                ((C19731g) C1720g.m3528K(C19731g.class)).mo34965cB(AppBrandDesktopHalfItemView.this.getContext());
                if (AppBrandDesktopHalfItemView.this.jaB != null) {
                    AppBrandDesktopHalfItemView.this.jaB.aQg();
                    AppMethodBeat.m2505o(134130);
                    return;
                }
            } else if (AppBrandDesktopHalfItemView.this.jax == C19907f.RECENT_APP_BRAND) {
                ((C19731g) C1720g.m3528K(C19731g.class)).mo34962C(AppBrandDesktopHalfItemView.this.getContext(), 3);
                if (AppBrandDesktopHalfItemView.this.jaB != null) {
                    AppBrandDesktopHalfItemView.this.jaB.aQh();
                }
            }
            AppMethodBeat.m2505o(134130);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$3 */
    class C273813 implements Runnable {
        C273813() {
        }

        public final void run() {
            AppMethodBeat.m2504i(134127);
            if (AppBrandDesktopHalfItemView.this.jaz != null) {
                C19849a g = AppBrandDesktopHalfItemView.this.jaz;
                if (!(g.jaG == null || g.jaG.apJ == null || !(g.jaG instanceof C19910c) || ((C19910c) g.jaG).iYe == null)) {
                    ((C19910c) g.jaG).iYe.animate().alpha(1.0f).scaleX(1.2f).scaleY(1.2f).setListener(null).setDuration(150).withEndAction(new C198481()).start();
                }
            }
            AppMethodBeat.m2505o(134127);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$5 */
    class C273825 implements OnClickListener {
        C273825() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(134129);
            if (AppBrandDesktopHalfItemView.this.jax == C19907f.MY_APP_BRAND) {
                ((C19731g) C1720g.m3528K(C19731g.class)).mo34965cB(AppBrandDesktopHalfItemView.this.getContext());
                if (AppBrandDesktopHalfItemView.this.jaB != null) {
                    AppBrandDesktopHalfItemView.this.jaB.aQg();
                    AppMethodBeat.m2505o(134129);
                    return;
                }
            } else if (AppBrandDesktopHalfItemView.this.jax == C19907f.RECENT_APP_BRAND) {
                ((C19731g) C1720g.m3528K(C19731g.class)).mo34962C(AppBrandDesktopHalfItemView.this.getContext(), 3);
                if (AppBrandDesktopHalfItemView.this.jaB != null) {
                    AppBrandDesktopHalfItemView.this.jaB.aQh();
                }
            }
            AppMethodBeat.m2505o(134129);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$10 */
    class C2738310 extends C19920c {
        C2738310() {
        }

        /* renamed from: L */
        public final void mo35167L(int i, boolean z) {
            AppMethodBeat.m2504i(134135);
            C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo onScrollPageChanged currentPage: %d, isAuto: %b", Integer.valueOf(i), Boolean.valueOf(z));
            if (!(AppBrandDesktopHalfItemView.this.jat == null || z)) {
                C19916b f;
                if (AppBrandDesktopHalfItemView.this.jax == C19907f.RECENT_APP_BRAND) {
                    f = AppBrandDesktopHalfItemView.this.jat;
                    C4990ab.m7418v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollRecentList");
                    f.jmP++;
                    AppMethodBeat.m2505o(134135);
                    return;
                } else if (AppBrandDesktopHalfItemView.this.jax == C19907f.MY_APP_BRAND) {
                    f = AppBrandDesktopHalfItemView.this.jat;
                    C4990ab.m7418v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollStarList");
                    f.jmY++;
                }
            }
            AppMethodBeat.m2505o(134135);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$11 */
    class C2738411 implements C11047a {
        C2738411() {
        }

        /* renamed from: a */
        public final void mo22742a(C19910c c19910c, int i) {
            AppMethodBeat.m2504i(134136);
            if (!(AppBrandDesktopHalfItemView.this.jaz == null || AppBrandDesktopHalfItemView.this.jaz.ape != i || !AppBrandDesktopHalfItemView.this.jaA || c19910c == null || c19910c.apJ == null)) {
                C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo ScaleAndAlphaAnimation set to default position: %d", Integer.valueOf(i));
                AppBrandDesktopHalfItemView.this.jaz.jaG = c19910c;
                AppBrandDesktopHalfItemView.this.jaA = false;
            }
            AppMethodBeat.m2505o(134136);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$2 */
    class C273852 implements AnimatorListener {
        C273852() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(134126);
            if (!(AppBrandDesktopHalfItemView.this.jaz == null || AppBrandDesktopHalfItemView.this.jaz.jaG == null || AppBrandDesktopHalfItemView.this.jaz.jaG.apJ == null || !(AppBrandDesktopHalfItemView.this.jaz.jaG instanceof C19910c))) {
                ((C19910c) AppBrandDesktopHalfItemView.this.jaz.jaG).gne.setVisibility(0);
            }
            AppBrandDesktopHalfItemView.m43465j(AppBrandDesktopHalfItemView.this);
            AppMethodBeat.m2505o(134126);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$1 */
    class C273861 implements C38617c {
        C273861() {
        }

        /* renamed from: qr */
        public final List mo45126qr(int i) {
            AppMethodBeat.m2504i(134125);
            List nA = ((C26767ag) C1720g.m3528K(C26767ag.class)).mo44540nA(i);
            AppMethodBeat.m2505o(134125);
            return nA;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView$4 */
    class C273874 implements C38617c {
        C273874() {
        }

        /* renamed from: qr */
        public final List mo45126qr(int i) {
            AppMethodBeat.m2504i(134128);
            List a = ((C10118af) C1720g.m3528K(C10118af.class)).mo21470a(i, C10117a.DESC);
            AppMethodBeat.m2505o(134128);
            return a;
        }
    }

    /* renamed from: a */
    public final void mo45099a(C19907f c19907f) {
        AppMethodBeat.m2504i(134138);
        this.jax = c19907f;
        if (this.jax == C19907f.RECENT_APP_BRAND) {
            this.jao.setText(getResources().getString(C25738R.string.div));
            this.iWW.setType(this.jax);
            this.iWW.setItemAnimator(new C10958c(this.iWW, true));
            this.iWW.setDataQuery(new C273861());
            AppMethodBeat.m2505o(134138);
            return;
        }
        if (this.jax == C19907f.MY_APP_BRAND) {
            setTitle(getResources().getString(C25738R.string.d48));
            this.iWW.setType(this.jax);
            this.iWW.setItemAnimator(new C10958c(this.iWW, false));
            this.iWW.setDataQuery(new C273874());
        }
        AppMethodBeat.m2505o(134138);
    }

    public AppBrandDesktopHalfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(134139);
        init(context);
        AppMethodBeat.m2505o(134139);
    }

    public AppBrandDesktopHalfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(134140);
        init(context);
        AppMethodBeat.m2505o(134140);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(134141);
        this.mContext = context;
        View inflate = C5616v.m8409hu(this.mContext).inflate(2130968672, this);
        this.jao = (TextView) inflate.findViewById(2131821158);
        this.jao.setOnClickListener(new C273825());
        this.jap = (ImageView) inflate.findViewById(2131821159);
        this.jap.setOnClickListener(new C273806());
        this.jav = (FrameLayout) inflate.findViewById(2131821160);
        this.jau = (LinearLayout) inflate.findViewById(2131821161);
        aQa();
        this.iWW = (ConversationAppBrandRecentView) inflate.findViewById(2131821162);
        this.iWW.setRefreshListener(new C198457());
        this.iWW.getAdapter().mo66307a(new C198468());
        this.iWW.setOnItemClickListener(new C198479());
        this.iWW.setOnScrollPageListener(new C2738310());
        this.iWW.setOnBindCustomViewHolderListener(new C2738411());
        AppMethodBeat.m2505o(134141);
    }

    public void setOnLaunchUIListener(C42729b c42729b) {
        this.jaB = c42729b;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(134142);
        super.onMeasure(i, i2);
        if (!(!this.jaC || this.jap.getMeasuredWidth() == 0 || this.jap.getMeasuredHeight() == 0)) {
            this.jap.getLayoutParams().width = (int) (((float) this.jap.getMeasuredWidth()) * C10969d.m18710dm(getContext()));
            this.jap.getLayoutParams().height = (int) (((float) this.jap.getMeasuredHeight()) * C10969d.m18710dm(getContext()));
            this.jaC = false;
        }
        AppMethodBeat.m2505o(134142);
    }

    /* renamed from: a */
    public final void mo45098a(Configuration configuration) {
        AppMethodBeat.m2504i(134143);
        C4990ab.m7417i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo HalfItemView onConfigurationChanged orientation: %d", Integer.valueOf(configuration.orientation));
        if (this.ivr != configuration.orientation) {
            ConversationAppBrandRecentView conversationAppBrandRecentView = this.iWW;
            int itemDecorationCount = conversationAppBrandRecentView.getItemDecorationCount();
            if (itemDecorationCount <= 0) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(itemDecorationCount)));
                AppMethodBeat.m2505o(134143);
                throw indexOutOfBoundsException;
            }
            C25373h c25373h = (C25373h) conversationAppBrandRecentView.anm.get(0);
            if (c25373h != null && (c25373h instanceof C42722a)) {
                ((C42722a) c25373h).padding = C10969d.m18707dj(this.mContext);
            }
            this.iWW.getAdapter().aop.notifyChanged();
        }
        this.ivr = configuration.orientation;
        AppMethodBeat.m2505o(134143);
    }

    private void aQa() {
        AppMethodBeat.m2504i(134144);
        this.jau.setLayoutParams(new LayoutParams(getContext().getResources().getDisplayMetrics().widthPixels * 2, -2));
        AppMethodBeat.m2505o(134144);
    }

    public void setItemPadding(int i) {
        this.iWJ = i;
    }

    private void setToDefaultStatus(C41531v c41531v) {
        AppMethodBeat.m2504i(134145);
        if (c41531v instanceof C19910c) {
            c41531v.apJ.setAlpha(0.0f);
            c41531v.apJ.setScaleX(0.95f);
            c41531v.apJ.setScaleY(0.95f);
        }
        AppMethodBeat.m2505o(134145);
    }

    public void setRefreshListener(C38619e c38619e) {
        AppMethodBeat.m2504i(134146);
        this.iWW.setRefreshListener(c38619e);
        AppMethodBeat.m2505o(134146);
    }

    public void setEnableDataCache(boolean z) {
        AppMethodBeat.m2504i(134147);
        this.iWW.setEnableDataCache(z);
        AppMethodBeat.m2505o(134147);
    }

    public void setOnItemClickListener(C38620b c38620b) {
        this.jas = c38620b;
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(134148);
        this.jao.setText(str);
        AppMethodBeat.m2505o(134148);
    }

    public void setTitlePaddingLeft(int i) {
        AppMethodBeat.m2504i(134149);
        if (this.jao != null) {
            TextView textView = this.jao;
            textView.setPadding(i, textView.getPaddingTop(), this.jao.getPaddingRight(), this.jao.getPaddingBottom());
        }
        AppMethodBeat.m2505o(134149);
    }

    public void setTitlePadding(Rect rect) {
        AppMethodBeat.m2504i(134150);
        if (rect != null) {
            this.jao.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
        AppMethodBeat.m2505o(134150);
    }

    public void setDataQuery(C38617c c38617c) {
        AppMethodBeat.m2504i(134151);
        this.iWW.setDataQuery(c38617c);
        AppMethodBeat.m2505o(134151);
    }

    public ConversationAppBrandRecentView getRecentView() {
        return this.iWW;
    }

    public List<C42748a> getPreviewList() {
        AppMethodBeat.m2504i(134152);
        List previewItemList = this.iWW.getPreviewItemList();
        AppMethodBeat.m2505o(134152);
        return previewItemList;
    }

    public int getDataCount() {
        AppMethodBeat.m2504i(134153);
        int dataCount = this.iWW.getDataCount();
        AppMethodBeat.m2505o(134153);
        return dataCount;
    }

    public int getCustomCount() {
        AppMethodBeat.m2504i(134154);
        int customItemCount = this.iWW.getCustomItemCount();
        AppMethodBeat.m2505o(134154);
        return customItemCount;
    }

    public void setCreateContextMenuListener(OnCreateContextMenuListener onCreateContextMenuListener) {
        AppMethodBeat.m2504i(134155);
        this.iWW.setCreateContextMenuListener(onCreateContextMenuListener);
        AppMethodBeat.m2505o(134155);
    }

    public void setMenuItemSelectedListener(C19906a c19906a) {
        AppMethodBeat.m2504i(134156);
        this.iWW.setMenuItemSelectedListener(c19906a);
        AppMethodBeat.m2505o(134156);
    }

    public void setOnDataChangedListener(C38618d c38618d) {
        AppMethodBeat.m2504i(134157);
        this.iWW.setOnDataChangedListener(c38618d);
        AppMethodBeat.m2505o(134157);
    }

    public void setReporter(C19916b c19916b) {
        this.jat = c19916b;
    }

    /* renamed from: a */
    public final void mo45100a(C33647b c33647b) {
        AppMethodBeat.m2504i(134158);
        ConversationAppBrandRecentView conversationAppBrandRecentView = this.iWW;
        if (conversationAppBrandRecentView.jnB != null) {
            C33646e c33646e = conversationAppBrandRecentView.jnB;
            c33646e.joq = true;
            c33646e.mo54214a(0, c33647b, true);
        }
        AppMethodBeat.m2505o(134158);
    }

    public final void aQb() {
        AppMethodBeat.m2504i(134159);
        ConversationAppBrandRecentView conversationAppBrandRecentView = this.iWW;
        if (conversationAppBrandRecentView.jnB != null) {
            C33646e c33646e = conversationAppBrandRecentView.jnB;
            c33646e.joi.getLayoutManager().mo1762bY(0);
            c33646e.mOffsetX = 0;
            c33646e.joj = 0;
            c33646e.jok = 0;
            c33646e.jiy = 0;
        }
        AppMethodBeat.m2505o(134159);
    }

    /* renamed from: j */
    static /* synthetic */ void m43465j(AppBrandDesktopHalfItemView appBrandDesktopHalfItemView) {
        appBrandDesktopHalfItemView.jaz = null;
        appBrandDesktopHalfItemView.jaA = false;
    }
}
