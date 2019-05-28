package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.C45434n;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.sns.lucky.p1298a.C34943a;
import com.tencent.p177mm.plugin.sns.p520ui.C43590al;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C21939ac;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.C29086r;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C13437h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.C29064ad;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.C3934c;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.C21963b;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3952g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment */
public class ContentFragment extends Fragment {
    private int bgColor;
    public boolean caA;
    private boolean gnp;
    private int gsN;
    private int ieu;
    private int iev;
    public Map<String, Object> puc;
    private LinearLayoutManager qYM;
    private final Map<String, Bitmap> rao = new WeakHashMap();
    public C3952g rcX;
    private int rcZ;
    public C3934c rdb;
    private int rdc = 700;
    private C21939ac rdd;
    private boolean rde;
    private boolean rdf;
    private boolean rdg;
    public boolean rdh;
    public boolean rdi = false;
    private ValueAnimator rdj;
    private int rdk;
    public int rdl;
    private C5004al rdm;
    public C7521a rdn;
    public C7524b rdo;
    private C39771a rdp;
    private boolean rdq;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment$1 */
    class C75141 extends C41530m {
        C75141() {
        }

        /* renamed from: a */
        public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
            AppMethodBeat.m2504i(37613);
            super.mo6642a(recyclerView, i, i2);
            if (ContentFragment.this.rdo.rdw != null && ContentFragment.this.rdo.rdw.getVisibility() == 0) {
                ContentFragment.this.rdo.rdw.scrollBy(i, i2);
            }
            AppMethodBeat.m2505o(37613);
        }

        /* renamed from: c */
        public final void mo6643c(RecyclerView recyclerView, int i) {
            AppMethodBeat.m2504i(37614);
            super.mo6643c(recyclerView, i);
            ContentFragment.this.rdk = i;
            if (i == 0) {
                if (ContentFragment.m13064b(ContentFragment.this)) {
                    ContentFragment.this.cqd();
                    AppMethodBeat.m2505o(37614);
                    return;
                }
            } else if (i == 1) {
                ContentFragment.this.cqe();
                C29064ad.m46207eQ(ContentFragment.this.getContext());
            }
            AppMethodBeat.m2505o(37614);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment$4 */
    class C75184 implements AnimatorUpdateListener {
        C75184() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(37619);
            ContentFragment.this.rdo.rdx.setTranslationY((float) ((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) (-C1338a.fromDPToPix(ContentFragment.this.getContext(), 5))))));
            AppMethodBeat.m2505o(37619);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment$5 */
    class C75195 extends AnimatorListenerAdapter {
        C75195() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(37620);
            C4990ab.m7410d("ContentFragment", "onAnimationStart show nextBtn");
            ContentFragment.this.rdo.rdy = true;
            AppMethodBeat.m2505o(37620);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(37621);
            C4990ab.m7410d("ContentFragment", "onAnimationEnd show nextBtn");
            ContentFragment.this.rdo.rdy = false;
            AppMethodBeat.m2505o(37621);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment$6 */
    class C75206 implements C3951a {
        C75206() {
        }

        public final void cpu() {
        }

        public final void cmD() {
            AppMethodBeat.m2504i(37622);
            C4990ab.m7410d("ContentFragment", "onDownloadError nextBtn");
            AppMethodBeat.m2505o(37622);
        }

        /* renamed from: YJ */
        public final void mo8627YJ(String str) {
            AppMethodBeat.m2504i(37623);
            C4990ab.m7410d("ContentFragment", "onDownloaded nextBtn");
            ContentFragment.m13061a(ContentFragment.this, str, ContentFragment.this.rdo.rdx);
            ContentFragment.this.cqd();
            AppMethodBeat.m2505o(37623);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment$a */
    public interface C7521a extends Serializable {
        /* renamed from: n */
        void mo16744n(ContentFragment contentFragment);
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment$7 */
    class C75227 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment$7$1 */
        class C75231 implements OnPreDrawListener {
            C75231() {
            }

            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(37624);
                if (ContentFragment.this.rdo.rdz.getHeight() > 0) {
                    ContentFragment.this.rdo.rdz.getViewTreeObserver().removeOnPreDrawListener(this);
                    ContentFragment.this.gsN = ContentFragment.this.rdo.rdz.getHeight();
                    if (ContentFragment.this.gsN < ContentFragment.this.iev) {
                        ContentFragment.this.gsN = ContentFragment.this.iev;
                    }
                    LayoutParams layoutParams = (LayoutParams) ContentFragment.this.rdo.rdw.getLayoutParams();
                    layoutParams.height = ContentFragment.this.gsN;
                    ContentFragment.this.rdo.rdw.setLayoutParams(layoutParams);
                    C4990ab.m7416i("ContentFragment", "set bgIV height " + ContentFragment.this.rdo.rdz.getHeight() + ", count " + ContentFragment.this.rdo.rdz.getChildCount());
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= ContentFragment.this.rdo.rdz.getChildCount()) {
                            break;
                        }
                        Object tag = ContentFragment.this.rdo.rdz.getChildAt(i2).getTag();
                        if (tag instanceof C13437h) {
                            ((C13437h) tag).coZ();
                        }
                        i = i2 + 1;
                    }
                    ContentFragment.this.rdo.rdz.removeAllViews();
                    ContentFragment.this.rdo.rdz.setVisibility(8);
                }
                AppMethodBeat.m2505o(37624);
                return true;
            }
        }

        C75227() {
        }

        public final void run() {
            int i = 0;
            AppMethodBeat.m2504i(37625);
            if (ContentFragment.this.rdo == null) {
                AppMethodBeat.m2505o(37625);
                return;
            }
            if ((ContentFragment.this.rcX.rei || !TextUtils.isEmpty(ContentFragment.this.rcX.reh)) && !ContentFragment.this.rdq) {
                ContentFragment.this.rdq = true;
                ContentFragment.this.rdo.rdz.setVisibility(0);
                ContentFragment.this.rdo.rdw.setScaleType(ScaleType.CENTER_CROP);
                ContentFragment.this.rdo.rdz.getViewTreeObserver().addOnPreDrawListener(new C75231());
                C39771a m = ContentFragment.this.rdp;
                LinearLayout linearLayout = ContentFragment.this.rdo.rdz;
                while (true) {
                    int i2 = i;
                    if (i2 >= m.rcX.rej.size()) {
                        break;
                    }
                    C13437h a = C43590al.m77980a(linearLayout.getContext(), (C29086r) m.rcX.rej.get(i2), linearLayout, m.bgColor);
                    if (a != null) {
                        if (a.getView().getParent() != null && (a.getView().getParent() instanceof ViewGroup)) {
                            ((ViewGroup) a.getView().getParent()).removeView(a.getView());
                        }
                        a.getView().setTag(a);
                        linearLayout.addView(a.getView());
                    }
                    i = i2 + 1;
                }
            }
            AppMethodBeat.m2505o(37625);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter.ContentFragment$b */
    public static class C7524b {
        public RecyclerView iJP;
        public View jWH;
        public LinearLayout jbJ;
        public ImageView rdw;
        public ImageView rdx;
        public boolean rdy;
        LinearLayout rdz;

        private C7524b() {
            this.rdw = null;
            this.jbJ = null;
            this.rdx = null;
            this.rdy = false;
        }

        /* synthetic */ C7524b(byte b) {
            this();
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m13064b(ContentFragment contentFragment) {
        AppMethodBeat.m2504i(37643);
        boolean cqf = contentFragment.cqf();
        AppMethodBeat.m2505o(37643);
        return cqf;
    }

    /* renamed from: c */
    static /* synthetic */ void m13065c(ContentFragment contentFragment) {
        AppMethodBeat.m2504i(37644);
        contentFragment.cqc();
        AppMethodBeat.m2505o(37644);
    }

    public ContentFragment() {
        AppMethodBeat.m2504i(37626);
        AppMethodBeat.m2505o(37626);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(37627);
        super.onCreate(bundle);
        Map map = this.puc;
        int[] eP = C29064ad.m46206eP(getContext());
        this.ieu = eP[0];
        this.iev = eP[1];
        if (this.rcX == null) {
            this.rcX = (C3952g) map.get("pageInfo");
        }
        this.rdd = (C21939ac) map.get("pageDownIconInfo");
        this.rde = C5046bo.m7546e((Boolean) map.get("is_first_show_page"));
        this.gnp = C5046bo.m7546e((Boolean) map.get("is_last_shown_page"));
        this.rdf = C5046bo.m7546e((Boolean) map.get("needEnterAnimation"));
        this.rdg = C5046bo.m7546e((Boolean) map.get("needDirectionAnimation"));
        this.rcZ = C5046bo.m7550g(map.get("groupListCompShowIndex"), 0);
        AppMethodBeat.m2505o(37627);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.m2504i(37628);
        View inflate = layoutInflater.inflate(2130968631, viewGroup, false);
        this.rdo = new C7524b();
        this.rdo.jWH = inflate;
        this.rdo.rdw = (ImageView) inflate.findViewById(2131821023);
        this.rdo.jbJ = (LinearLayout) inflate.findViewById(2131821024);
        this.rdo.rdx = (ImageView) inflate.findViewById(2131821026);
        this.rdo.iJP = (RecyclerView) inflate.findViewById(2131821025);
        this.rdo.rdz = (LinearLayout) inflate.findViewById(2131821022);
        RecyclerView recyclerView = this.rdo.iJP;
        recyclerView.setOverScrollMode(2);
        recyclerView.setOnTouchListener(new C21963b((DummyViewPager) this.puc.get("viewPager")));
        getActivity();
        this.qYM = new LinearLayoutManager();
        recyclerView.setLayoutManager(this.qYM);
        this.rdp = new C39771a(this.rcX, this.bgColor, getActivity(), this.qYM);
        if (this.rde) {
            this.rdp.rcZ = this.rcZ;
        }
        recyclerView.setAdapter(this.rdp);
        recyclerView.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        this.rdb = new C3934c(recyclerView);
        recyclerView.mo66332a(new C75141());
        inflate.setTag(this.rdo);
        m13056Vd();
        this.rdj = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rdj.setDuration((long) this.rdc);
        this.rdj.addUpdateListener(new C75184());
        this.rdj.addListener(new C75195());
        this.rdj.setRepeatCount(-1);
        this.rdj.setRepeatMode(2);
        if (!(this.rdd == null || this.rdd.equals(this.rdo.rdx.getTag()))) {
            this.rdo.rdx.setTag(this.rdd);
            this.rdo.rdx.setVisibility(8);
            C13473h.m21619a(this.rdd.iconUrl, 1000000001, new C75206());
        }
        if (this.rdn != null) {
            this.rdn.mo16744n(this);
        }
        AppMethodBeat.m2505o(37628);
        return inflate;
    }

    public void onResume() {
        AppMethodBeat.m2504i(37629);
        super.onResume();
        C4990ab.m7416i("ContentFragment", this + " onResume " + getUserVisibleHint());
        this.caA = true;
        if (!(this.rdo == null || this.rdo.jWH == null)) {
            ViewGroup viewGroup = (ViewGroup) this.rdo.jWH.getParent();
            if (!(viewGroup == null || viewGroup.getParent() == null || viewGroup.getParent().getParent() == null)) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent().getParent();
                if (viewGroup2.indexOfChild((View) viewGroup.getParent()) < viewGroup2.getChildCount() - 2) {
                    this.caA = false;
                }
            }
        }
        this.rdb.caA = this.caA;
        if (this.rdb != null && getUserVisibleHint()) {
            this.rdb.cpl();
        }
        AppMethodBeat.m2505o(37629);
    }

    public void onPause() {
        AppMethodBeat.m2504i(37630);
        super.onPause();
        C4990ab.m7416i("ContentFragment", this + " onPause " + getUserVisibleHint());
        this.caA = false;
        this.rdb.caA = this.caA;
        if (this.rdb != null && getUserVisibleHint()) {
            this.rdb.cpY();
        }
        AppMethodBeat.m2505o(37630);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(37631);
        super.onDestroy();
        if (this.rdb != null) {
            this.rdb.rcF.onDestroy();
        }
        cqe();
        AppMethodBeat.m2505o(37631);
    }

    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.m2504i(37632);
        super.setUserVisibleHint(z);
        if (z) {
            if (this.rdb != null) {
                this.rdb.cpl();
                AppMethodBeat.m2505o(37632);
                return;
            }
        } else if (this.rdb != null) {
            this.rdb.cpY();
        }
        AppMethodBeat.m2505o(37632);
    }

    public final void cqb() {
        AppMethodBeat.m2504i(37633);
        if (this.caA && this.rdb != null) {
            this.rdb.cpX();
        }
        AppMethodBeat.m2505o(37633);
    }

    public final void cpn() {
        AppMethodBeat.m2504i(37634);
        if (this.rdb != null && getUserVisibleHint()) {
            this.rdb.cpY();
        }
        AppMethodBeat.m2505o(37634);
    }

    /* renamed from: a */
    public final void mo16732a(C3952g c3952g) {
        AppMethodBeat.m2504i(37635);
        if (this.rcX != c3952g) {
            this.rcX = c3952g;
            m13056Vd();
        }
        AppMethodBeat.m2505o(37635);
    }

    /* renamed from: Vd */
    private void m13056Vd() {
        AppMethodBeat.m2504i(37636);
        if (this.rdo == null) {
            AppMethodBeat.m2505o(37636);
            return;
        }
        cqc();
        if (this.rcX.reh == null || this.rcX.reh.length() <= 0) {
            cqc();
        } else {
            final String str = this.rcX.reh;
            C4990ab.m7417i("ContentFragment", "bg need blur %b, url %s", Boolean.valueOf(this.rcX.rei), str);
            if (this.rao.containsKey(str)) {
                C4990ab.m7416i("ContentFragment", "bg has cache bitmap");
                m13057Z((Bitmap) this.rao.get(str));
            } else {
                C13473h.m21623c("adId", str, false, 1000000001, new C3951a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                        AppMethodBeat.m2504i(37615);
                        C4990ab.m7417i("ContentFragment", "download img fail %s", str);
                        ContentFragment.m13065c(ContentFragment.this);
                        AppMethodBeat.m2505o(37615);
                    }

                    /* renamed from: YJ */
                    public final void mo8627YJ(String str) {
                        AppMethodBeat.m2504i(37616);
                        ContentFragment.m13062a(ContentFragment.this, str, "adId", str);
                        AppMethodBeat.m2505o(37616);
                    }
                });
            }
        }
        if (this.rdp != null) {
            if (this.rcX.reh == null || this.rcX.reh.length() <= 0) {
                this.rdp.bgColor = this.bgColor;
            } else {
                this.rdp.bgColor = 0;
            }
            this.rdp.mo62891a(this.rcX);
        }
        AppMethodBeat.m2505o(37636);
    }

    private void cqc() {
        AppMethodBeat.m2504i(37637);
        if (this.rcX.hfo != null && this.rcX.hfo.length() > 0) {
            C4990ab.m7417i("ContentFragment", "setting bg color %s", this.rcX.hfo);
            try {
                this.bgColor = Color.parseColor(this.rcX.hfo);
            } catch (Exception e) {
                C4990ab.m7412e("ContentFragment", "the color is error : " + this.rcX.hfo);
            }
            this.rdo.jWH.setBackgroundColor(this.bgColor);
            this.rdo.rdw.setBackgroundColor(this.bgColor);
            this.rdo.jbJ.setBackgroundColor(this.bgColor);
        }
        AppMethodBeat.m2505o(37637);
    }

    /* renamed from: Z */
    private void m13057Z(Bitmap bitmap) {
        AppMethodBeat.m2504i(37638);
        if (bitmap != null) {
            this.rdo.jWH.setBackgroundColor(0);
            this.rdo.rdw.setBackgroundColor(0);
            this.rdo.jbJ.setBackgroundColor(0);
            LayoutParams layoutParams = (LayoutParams) this.rdo.rdw.getLayoutParams();
            layoutParams.height = layoutParams.height >= this.iev ? layoutParams.height : this.iev;
            this.rdo.rdw.setLayoutParams(layoutParams);
            this.rdo.rdw.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(37638);
            return;
        }
        cqc();
        AppMethodBeat.m2505o(37638);
    }

    public final Collection<C13437h> cqa() {
        AppMethodBeat.m2504i(37639);
        if (this.rdp == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.m2505o(37639);
            return list;
        }
        Collection<C13437h> cqa = this.rdp.cqa();
        AppMethodBeat.m2505o(37639);
        return cqa;
    }

    public final void cqd() {
        AppMethodBeat.m2504i(37640);
        if (!cqf() || this.rdi || this.rdo.rdy) {
            AppMethodBeat.m2505o(37640);
            return;
        }
        this.rdo.rdx.setVisibility(0);
        this.rdo.rdx.setTranslationY((float) (-C1338a.fromDPToPix(getContext(), 5)));
        this.rdj.setRepeatMode(2);
        this.rdj.setRepeatCount(-1);
        this.rdj.start();
        AppMethodBeat.m2505o(37640);
    }

    public final void cqe() {
        AppMethodBeat.m2504i(37641);
        this.rdo.rdx.setVisibility(4);
        this.rdo.rdx.setTranslationY((float) (-C1338a.fromDPToPix(getContext(), 5)));
        this.rdj.setRepeatMode(2);
        this.rdj.setRepeatCount(0);
        this.rdj.end();
        AppMethodBeat.m2505o(37641);
    }

    public final boolean cqf() {
        boolean z = true;
        AppMethodBeat.m2504i(37642);
        if (!this.rdg) {
            AppMethodBeat.m2505o(37642);
            return false;
        } else if (this.rdk != 0) {
            AppMethodBeat.m2505o(37642);
            return false;
        } else if (this.rdl != 0) {
            AppMethodBeat.m2505o(37642);
            return false;
        } else {
            int iQ = this.qYM.mo1780iQ();
            if (iQ == this.qYM.mo1782iS() && iQ == -1) {
                AppMethodBeat.m2505o(37642);
                return false;
            }
            if (this.gnp && this.qYM.mo1782iS() == this.rdp.getItemCount() - 1) {
                z = false;
            }
            AppMethodBeat.m2505o(37642);
            return z;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m13062a(ContentFragment contentFragment, final String str, final String str2, final String str3) {
        AppMethodBeat.m2504i(37645);
        if (contentFragment.rdm == null) {
            contentFragment.rdm = new C5004al();
        }
        contentFragment.rdm.mo10302aa(new Runnable() {
            public final void run() {
                float f = 1.0f;
                Bitmap bitmap = null;
                AppMethodBeat.m2504i(37618);
                C4990ab.m7417i("ContentFragment", "download bg ok path %s ", str);
                try {
                    if (ContentFragment.this.rcX.rei) {
                        ContentFragment.m13067e(ContentFragment.this);
                        String gj = C13473h.m21625gj(str2, str3 + "_blurimg");
                        if (C5730e.m8628ct(gj)) {
                            bitmap = BitmapFactory.decodeFile(gj);
                        } else {
                            Bitmap decodeFile = C5056d.decodeFile(str, null);
                            if (decodeFile != null) {
                                C45434n a;
                                if (decodeFile.getHeight() < ContentFragment.this.iev || decodeFile.getWidth() < ContentFragment.this.ieu) {
                                    f = Math.max((((float) ContentFragment.this.ieu) * 1.0f) / ((float) decodeFile.getWidth()), (1.0f * ((float) ContentFragment.this.iev)) / ((float) decodeFile.getHeight()));
                                }
                                Bitmap a2 = C5056d.m7613a(decodeFile, f, f);
                                try {
                                    a2 = Bitmap.createBitmap(a2, (a2.getWidth() - ContentFragment.this.ieu) >>> 1, (a2.getHeight() - ContentFragment.this.iev) >>> 1, ContentFragment.this.ieu, ContentFragment.this.iev);
                                } catch (OutOfMemoryError e) {
                                    C4990ab.printErrStackTrace("ContentFragment", e, "", new Object[0]);
                                    a2 = null;
                                }
                                if (a2 != null) {
                                    a = C34943a.m57362a(a2, gj, Color.argb(140, 0, 0, 0), 180);
                                } else {
                                    a = null;
                                }
                                if (a != null) {
                                    bitmap = a.mo73230Xi();
                                }
                            }
                        }
                    } else {
                        bitmap = C5056d.decodeFile(str, null);
                    }
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(37617);
                            if (bitmap == null) {
                                C4990ab.m7417i("ContentFragment", "decode img fail, set bg color %s", str3);
                                ContentFragment.m13070h(ContentFragment.this);
                                AppMethodBeat.m2505o(37617);
                                return;
                            }
                            C4990ab.m7416i("ContentFragment", "set bg with bitmap");
                            ContentFragment.this.rao.put(str3, bitmap);
                            ContentFragment.m13060a(ContentFragment.this, bitmap);
                            AppMethodBeat.m2505o(37617);
                        }
                    });
                    AppMethodBeat.m2505o(37618);
                } catch (Exception e2) {
                    C4990ab.m7412e("ContentFragment", "the backgroundCoverUrl is set error ,because " + e2.toString());
                    AppMethodBeat.m2505o(37618);
                }
            }
        });
        AppMethodBeat.m2505o(37645);
    }

    /* renamed from: e */
    static /* synthetic */ void m13067e(ContentFragment contentFragment) {
        AppMethodBeat.m2504i(37646);
        C5004al.m7442n(new C75227(), 1000);
        AppMethodBeat.m2505o(37646);
    }

    /* renamed from: h */
    static /* synthetic */ void m13070h(ContentFragment contentFragment) {
        AppMethodBeat.m2504i(37647);
        contentFragment.cqc();
        AppMethodBeat.m2505o(37647);
    }

    /* renamed from: a */
    static /* synthetic */ void m13061a(ContentFragment contentFragment, String str, ImageView imageView) {
        AppMethodBeat.m2504i(37649);
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (Float.compare(contentFragment.rdd.width, 0.0f) > 0) {
            layoutParams.width = (int) contentFragment.rdd.width;
        } else {
            layoutParams.width = -1;
        }
        if (Float.compare(contentFragment.rdd.height, 0.0f) > 0) {
            layoutParams.height = (int) contentFragment.rdd.height;
        } else {
            layoutParams.height = -2;
        }
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = (int) contentFragment.rdd.qWR;
        }
        imageView.setImageBitmap(decodeFile);
        AppMethodBeat.m2505o(37649);
    }
}
