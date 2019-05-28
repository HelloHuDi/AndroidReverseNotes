package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
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
import com.tencent.mm.R;
import com.tencent.mm.memory.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ac;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

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
    public g rcX;
    private int rcZ;
    public c rdb;
    private int rdc = 700;
    private ac rdd;
    private boolean rde;
    private boolean rdf;
    private boolean rdg;
    public boolean rdh;
    public boolean rdi = false;
    private ValueAnimator rdj;
    private int rdk;
    public int rdl;
    private al rdm;
    public a rdn;
    public b rdo;
    private a rdp;
    private boolean rdq;

    public interface a extends Serializable {
        void n(ContentFragment contentFragment);
    }

    public static class b {
        public RecyclerView iJP;
        public View jWH;
        public LinearLayout jbJ;
        public ImageView rdw;
        public ImageView rdx;
        public boolean rdy;
        LinearLayout rdz;

        private b() {
            this.rdw = null;
            this.jbJ = null;
            this.rdx = null;
            this.rdy = false;
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static /* synthetic */ boolean b(ContentFragment contentFragment) {
        AppMethodBeat.i(37643);
        boolean cqf = contentFragment.cqf();
        AppMethodBeat.o(37643);
        return cqf;
    }

    static /* synthetic */ void c(ContentFragment contentFragment) {
        AppMethodBeat.i(37644);
        contentFragment.cqc();
        AppMethodBeat.o(37644);
    }

    public ContentFragment() {
        AppMethodBeat.i(37626);
        AppMethodBeat.o(37626);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(37627);
        super.onCreate(bundle);
        Map map = this.puc;
        int[] eP = ad.eP(getContext());
        this.ieu = eP[0];
        this.iev = eP[1];
        if (this.rcX == null) {
            this.rcX = (g) map.get("pageInfo");
        }
        this.rdd = (ac) map.get("pageDownIconInfo");
        this.rde = bo.e((Boolean) map.get("is_first_show_page"));
        this.gnp = bo.e((Boolean) map.get("is_last_shown_page"));
        this.rdf = bo.e((Boolean) map.get("needEnterAnimation"));
        this.rdg = bo.e((Boolean) map.get("needDirectionAnimation"));
        this.rcZ = bo.g(map.get("groupListCompShowIndex"), 0);
        AppMethodBeat.o(37627);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        AppMethodBeat.i(37628);
        View inflate = layoutInflater.inflate(R.layout.as, viewGroup, false);
        this.rdo = new b();
        this.rdo.jWH = inflate;
        this.rdo.rdw = (ImageView) inflate.findViewById(R.id.m9);
        this.rdo.jbJ = (LinearLayout) inflate.findViewById(R.id.m_);
        this.rdo.rdx = (ImageView) inflate.findViewById(R.id.mb);
        this.rdo.iJP = (RecyclerView) inflate.findViewById(R.id.ma);
        this.rdo.rdz = (LinearLayout) inflate.findViewById(R.id.m8);
        RecyclerView recyclerView = this.rdo.iJP;
        recyclerView.setOverScrollMode(2);
        recyclerView.setOnTouchListener(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.b((DummyViewPager) this.puc.get("viewPager")));
        getActivity();
        this.qYM = new LinearLayoutManager();
        recyclerView.setLayoutManager(this.qYM);
        this.rdp = new a(this.rcX, this.bgColor, getActivity(), this.qYM);
        if (this.rde) {
            this.rdp.rcZ = this.rcZ;
        }
        recyclerView.setAdapter(this.rdp);
        recyclerView.setDescendantFocusability(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        this.rdb = new c(recyclerView);
        recyclerView.a(new m() {
            public final void a(RecyclerView recyclerView, int i, int i2) {
                AppMethodBeat.i(37613);
                super.a(recyclerView, i, i2);
                if (ContentFragment.this.rdo.rdw != null && ContentFragment.this.rdo.rdw.getVisibility() == 0) {
                    ContentFragment.this.rdo.rdw.scrollBy(i, i2);
                }
                AppMethodBeat.o(37613);
            }

            public final void c(RecyclerView recyclerView, int i) {
                AppMethodBeat.i(37614);
                super.c(recyclerView, i);
                ContentFragment.this.rdk = i;
                if (i == 0) {
                    if (ContentFragment.b(ContentFragment.this)) {
                        ContentFragment.this.cqd();
                        AppMethodBeat.o(37614);
                        return;
                    }
                } else if (i == 1) {
                    ContentFragment.this.cqe();
                    ad.eQ(ContentFragment.this.getContext());
                }
                AppMethodBeat.o(37614);
            }
        });
        inflate.setTag(this.rdo);
        Vd();
        this.rdj = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rdj.setDuration((long) this.rdc);
        this.rdj.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(37619);
                ContentFragment.this.rdo.rdx.setTranslationY((float) ((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) (-com.tencent.mm.bz.a.fromDPToPix(ContentFragment.this.getContext(), 5))))));
                AppMethodBeat.o(37619);
            }
        });
        this.rdj.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(37620);
                ab.d("ContentFragment", "onAnimationStart show nextBtn");
                ContentFragment.this.rdo.rdy = true;
                AppMethodBeat.o(37620);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(37621);
                ab.d("ContentFragment", "onAnimationEnd show nextBtn");
                ContentFragment.this.rdo.rdy = false;
                AppMethodBeat.o(37621);
            }
        });
        this.rdj.setRepeatCount(-1);
        this.rdj.setRepeatMode(2);
        if (!(this.rdd == null || this.rdd.equals(this.rdo.rdx.getTag()))) {
            this.rdo.rdx.setTag(this.rdd);
            this.rdo.rdx.setVisibility(8);
            h.a(this.rdd.iconUrl, 1000000001, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a() {
                public final void cpu() {
                }

                public final void cmD() {
                    AppMethodBeat.i(37622);
                    ab.d("ContentFragment", "onDownloadError nextBtn");
                    AppMethodBeat.o(37622);
                }

                public final void YJ(String str) {
                    AppMethodBeat.i(37623);
                    ab.d("ContentFragment", "onDownloaded nextBtn");
                    ContentFragment.a(ContentFragment.this, str, ContentFragment.this.rdo.rdx);
                    ContentFragment.this.cqd();
                    AppMethodBeat.o(37623);
                }
            });
        }
        if (this.rdn != null) {
            this.rdn.n(this);
        }
        AppMethodBeat.o(37628);
        return inflate;
    }

    public void onResume() {
        AppMethodBeat.i(37629);
        super.onResume();
        ab.i("ContentFragment", this + " onResume " + getUserVisibleHint());
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
        AppMethodBeat.o(37629);
    }

    public void onPause() {
        AppMethodBeat.i(37630);
        super.onPause();
        ab.i("ContentFragment", this + " onPause " + getUserVisibleHint());
        this.caA = false;
        this.rdb.caA = this.caA;
        if (this.rdb != null && getUserVisibleHint()) {
            this.rdb.cpY();
        }
        AppMethodBeat.o(37630);
    }

    public void onDestroy() {
        AppMethodBeat.i(37631);
        super.onDestroy();
        if (this.rdb != null) {
            this.rdb.rcF.onDestroy();
        }
        cqe();
        AppMethodBeat.o(37631);
    }

    public void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(37632);
        super.setUserVisibleHint(z);
        if (z) {
            if (this.rdb != null) {
                this.rdb.cpl();
                AppMethodBeat.o(37632);
                return;
            }
        } else if (this.rdb != null) {
            this.rdb.cpY();
        }
        AppMethodBeat.o(37632);
    }

    public final void cqb() {
        AppMethodBeat.i(37633);
        if (this.caA && this.rdb != null) {
            this.rdb.cpX();
        }
        AppMethodBeat.o(37633);
    }

    public final void cpn() {
        AppMethodBeat.i(37634);
        if (this.rdb != null && getUserVisibleHint()) {
            this.rdb.cpY();
        }
        AppMethodBeat.o(37634);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(37635);
        if (this.rcX != gVar) {
            this.rcX = gVar;
            Vd();
        }
        AppMethodBeat.o(37635);
    }

    private void Vd() {
        AppMethodBeat.i(37636);
        if (this.rdo == null) {
            AppMethodBeat.o(37636);
            return;
        }
        cqc();
        if (this.rcX.reh == null || this.rcX.reh.length() <= 0) {
            cqc();
        } else {
            final String str = this.rcX.reh;
            ab.i("ContentFragment", "bg need blur %b, url %s", Boolean.valueOf(this.rcX.rei), str);
            if (this.rao.containsKey(str)) {
                ab.i("ContentFragment", "bg has cache bitmap");
                Z((Bitmap) this.rao.get(str));
            } else {
                h.c("adId", str, false, 1000000001, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                        AppMethodBeat.i(37615);
                        ab.i("ContentFragment", "download img fail %s", str);
                        ContentFragment.c(ContentFragment.this);
                        AppMethodBeat.o(37615);
                    }

                    public final void YJ(String str) {
                        AppMethodBeat.i(37616);
                        ContentFragment.a(ContentFragment.this, str, "adId", str);
                        AppMethodBeat.o(37616);
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
            this.rdp.a(this.rcX);
        }
        AppMethodBeat.o(37636);
    }

    private void cqc() {
        AppMethodBeat.i(37637);
        if (this.rcX.hfo != null && this.rcX.hfo.length() > 0) {
            ab.i("ContentFragment", "setting bg color %s", this.rcX.hfo);
            try {
                this.bgColor = Color.parseColor(this.rcX.hfo);
            } catch (Exception e) {
                ab.e("ContentFragment", "the color is error : " + this.rcX.hfo);
            }
            this.rdo.jWH.setBackgroundColor(this.bgColor);
            this.rdo.rdw.setBackgroundColor(this.bgColor);
            this.rdo.jbJ.setBackgroundColor(this.bgColor);
        }
        AppMethodBeat.o(37637);
    }

    private void Z(Bitmap bitmap) {
        AppMethodBeat.i(37638);
        if (bitmap != null) {
            this.rdo.jWH.setBackgroundColor(0);
            this.rdo.rdw.setBackgroundColor(0);
            this.rdo.jbJ.setBackgroundColor(0);
            LayoutParams layoutParams = (LayoutParams) this.rdo.rdw.getLayoutParams();
            layoutParams.height = layoutParams.height >= this.iev ? layoutParams.height : this.iev;
            this.rdo.rdw.setLayoutParams(layoutParams);
            this.rdo.rdw.setImageBitmap(bitmap);
            AppMethodBeat.o(37638);
            return;
        }
        cqc();
        AppMethodBeat.o(37638);
    }

    public final Collection<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h> cqa() {
        AppMethodBeat.i(37639);
        if (this.rdp == null) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.o(37639);
            return list;
        }
        Collection<com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h> cqa = this.rdp.cqa();
        AppMethodBeat.o(37639);
        return cqa;
    }

    public final void cqd() {
        AppMethodBeat.i(37640);
        if (!cqf() || this.rdi || this.rdo.rdy) {
            AppMethodBeat.o(37640);
            return;
        }
        this.rdo.rdx.setVisibility(0);
        this.rdo.rdx.setTranslationY((float) (-com.tencent.mm.bz.a.fromDPToPix(getContext(), 5)));
        this.rdj.setRepeatMode(2);
        this.rdj.setRepeatCount(-1);
        this.rdj.start();
        AppMethodBeat.o(37640);
    }

    public final void cqe() {
        AppMethodBeat.i(37641);
        this.rdo.rdx.setVisibility(4);
        this.rdo.rdx.setTranslationY((float) (-com.tencent.mm.bz.a.fromDPToPix(getContext(), 5)));
        this.rdj.setRepeatMode(2);
        this.rdj.setRepeatCount(0);
        this.rdj.end();
        AppMethodBeat.o(37641);
    }

    public final boolean cqf() {
        boolean z = true;
        AppMethodBeat.i(37642);
        if (!this.rdg) {
            AppMethodBeat.o(37642);
            return false;
        } else if (this.rdk != 0) {
            AppMethodBeat.o(37642);
            return false;
        } else if (this.rdl != 0) {
            AppMethodBeat.o(37642);
            return false;
        } else {
            int iQ = this.qYM.iQ();
            if (iQ == this.qYM.iS() && iQ == -1) {
                AppMethodBeat.o(37642);
                return false;
            }
            if (this.gnp && this.qYM.iS() == this.rdp.getItemCount() - 1) {
                z = false;
            }
            AppMethodBeat.o(37642);
            return z;
        }
    }

    static /* synthetic */ void a(ContentFragment contentFragment, final String str, final String str2, final String str3) {
        AppMethodBeat.i(37645);
        if (contentFragment.rdm == null) {
            contentFragment.rdm = new al();
        }
        contentFragment.rdm.aa(new Runnable() {
            public final void run() {
                float f = 1.0f;
                Bitmap bitmap = null;
                AppMethodBeat.i(37618);
                ab.i("ContentFragment", "download bg ok path %s ", str);
                try {
                    if (ContentFragment.this.rcX.rei) {
                        ContentFragment.e(ContentFragment.this);
                        String gj = h.gj(str2, str3 + "_blurimg");
                        if (e.ct(gj)) {
                            bitmap = BitmapFactory.decodeFile(gj);
                        } else {
                            Bitmap decodeFile = d.decodeFile(str, null);
                            if (decodeFile != null) {
                                n a;
                                if (decodeFile.getHeight() < ContentFragment.this.iev || decodeFile.getWidth() < ContentFragment.this.ieu) {
                                    f = Math.max((((float) ContentFragment.this.ieu) * 1.0f) / ((float) decodeFile.getWidth()), (1.0f * ((float) ContentFragment.this.iev)) / ((float) decodeFile.getHeight()));
                                }
                                Bitmap a2 = d.a(decodeFile, f, f);
                                try {
                                    a2 = Bitmap.createBitmap(a2, (a2.getWidth() - ContentFragment.this.ieu) >>> 1, (a2.getHeight() - ContentFragment.this.iev) >>> 1, ContentFragment.this.ieu, ContentFragment.this.iev);
                                } catch (OutOfMemoryError e) {
                                    ab.printErrStackTrace("ContentFragment", e, "", new Object[0]);
                                    a2 = null;
                                }
                                if (a2 != null) {
                                    a = com.tencent.mm.plugin.sns.lucky.a.a.a(a2, gj, Color.argb(140, 0, 0, 0), 180);
                                } else {
                                    a = null;
                                }
                                if (a != null) {
                                    bitmap = a.Xi();
                                }
                            }
                        }
                    } else {
                        bitmap = d.decodeFile(str, null);
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(37617);
                            if (bitmap == null) {
                                ab.i("ContentFragment", "decode img fail, set bg color %s", str3);
                                ContentFragment.h(ContentFragment.this);
                                AppMethodBeat.o(37617);
                                return;
                            }
                            ab.i("ContentFragment", "set bg with bitmap");
                            ContentFragment.this.rao.put(str3, bitmap);
                            ContentFragment.a(ContentFragment.this, bitmap);
                            AppMethodBeat.o(37617);
                        }
                    });
                    AppMethodBeat.o(37618);
                } catch (Exception e2) {
                    ab.e("ContentFragment", "the backgroundCoverUrl is set error ,because " + e2.toString());
                    AppMethodBeat.o(37618);
                }
            }
        });
        AppMethodBeat.o(37645);
    }

    static /* synthetic */ void e(ContentFragment contentFragment) {
        AppMethodBeat.i(37646);
        al.n(new Runnable() {
            public final void run() {
                int i = 0;
                AppMethodBeat.i(37625);
                if (ContentFragment.this.rdo == null) {
                    AppMethodBeat.o(37625);
                    return;
                }
                if ((ContentFragment.this.rcX.rei || !TextUtils.isEmpty(ContentFragment.this.rcX.reh)) && !ContentFragment.this.rdq) {
                    ContentFragment.this.rdq = true;
                    ContentFragment.this.rdo.rdz.setVisibility(0);
                    ContentFragment.this.rdo.rdw.setScaleType(ScaleType.CENTER_CROP);
                    ContentFragment.this.rdo.rdz.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            AppMethodBeat.i(37624);
                            if (ContentFragment.this.rdo.rdz.getHeight() > 0) {
                                ContentFragment.this.rdo.rdz.getViewTreeObserver().removeOnPreDrawListener(this);
                                ContentFragment.this.gsN = ContentFragment.this.rdo.rdz.getHeight();
                                if (ContentFragment.this.gsN < ContentFragment.this.iev) {
                                    ContentFragment.this.gsN = ContentFragment.this.iev;
                                }
                                LayoutParams layoutParams = (LayoutParams) ContentFragment.this.rdo.rdw.getLayoutParams();
                                layoutParams.height = ContentFragment.this.gsN;
                                ContentFragment.this.rdo.rdw.setLayoutParams(layoutParams);
                                ab.i("ContentFragment", "set bgIV height " + ContentFragment.this.rdo.rdz.getHeight() + ", count " + ContentFragment.this.rdo.rdz.getChildCount());
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= ContentFragment.this.rdo.rdz.getChildCount()) {
                                        break;
                                    }
                                    Object tag = ContentFragment.this.rdo.rdz.getChildAt(i2).getTag();
                                    if (tag instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h) {
                                        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h) tag).coZ();
                                    }
                                    i = i2 + 1;
                                }
                                ContentFragment.this.rdo.rdz.removeAllViews();
                                ContentFragment.this.rdo.rdz.setVisibility(8);
                            }
                            AppMethodBeat.o(37624);
                            return true;
                        }
                    });
                    a m = ContentFragment.this.rdp;
                    LinearLayout linearLayout = ContentFragment.this.rdo.rdz;
                    while (true) {
                        int i2 = i;
                        if (i2 >= m.rcX.rej.size()) {
                            break;
                        }
                        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.h a = com.tencent.mm.plugin.sns.ui.al.a(linearLayout.getContext(), (r) m.rcX.rej.get(i2), linearLayout, m.bgColor);
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
                AppMethodBeat.o(37625);
            }
        }, 1000);
        AppMethodBeat.o(37646);
    }

    static /* synthetic */ void h(ContentFragment contentFragment) {
        AppMethodBeat.i(37647);
        contentFragment.cqc();
        AppMethodBeat.o(37647);
    }

    static /* synthetic */ void a(ContentFragment contentFragment, String str, ImageView imageView) {
        AppMethodBeat.i(37649);
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
        AppMethodBeat.o(37649);
    }
}
