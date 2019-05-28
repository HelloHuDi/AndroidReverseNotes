package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class AppBrandDesktopHalfItemView extends LinearLayout {
    private m anZ = null;
    private int iWJ = 0;
    ConversationAppBrandRecentView iWW;
    private int iYI = 0;
    private int ivr = 1;
    boolean jaA = false;
    private b jaB = null;
    private boolean jaC = true;
    private AnimatorListener jaD = new AnimatorListener() {
        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(134126);
            if (!(AppBrandDesktopHalfItemView.this.jaz == null || AppBrandDesktopHalfItemView.this.jaz.jaG == null || AppBrandDesktopHalfItemView.this.jaz.jaG.apJ == null || !(AppBrandDesktopHalfItemView.this.jaz.jaG instanceof c))) {
                ((c) AppBrandDesktopHalfItemView.this.jaz.jaG).gne.setVisibility(0);
            }
            AppBrandDesktopHalfItemView.j(AppBrandDesktopHalfItemView.this);
            AppMethodBeat.o(134126);
        }
    };
    private TextView jao;
    private ImageView jap;
    private e jaq = null;
    RecyclerView.c jar = null;
    private AppBrandRecentView.b jas = null;
    private com.tencent.mm.plugin.appbrand.widget.recentview.b jat = null;
    private LinearLayout jau = null;
    private FrameLayout jav = null;
    private View jaw = null;
    private f jax;
    private float jay = 0.0f;
    a jaz = null;
    private Context mContext;

    class a {
        int ape;
        int jaF;
        v jaG;

        private a() {
            this.ape = -1;
            this.jaF = -1;
            this.jaG = null;
        }

        /* synthetic */ a(AppBrandDesktopHalfItemView appBrandDesktopHalfItemView, byte b) {
            this();
        }
    }

    public final void a(f fVar) {
        AppMethodBeat.i(134138);
        this.jax = fVar;
        if (this.jax == f.RECENT_APP_BRAND) {
            this.jao.setText(getResources().getString(R.string.div));
            this.iWW.setType(this.jax);
            this.iWW.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.iWW, true));
            this.iWW.setDataQuery(new AppBrandRecentView.c() {
                public final List qr(int i) {
                    AppMethodBeat.i(134125);
                    List nA = ((ag) g.K(ag.class)).nA(i);
                    AppMethodBeat.o(134125);
                    return nA;
                }
            });
            AppMethodBeat.o(134138);
            return;
        }
        if (this.jax == f.MY_APP_BRAND) {
            setTitle(getResources().getString(R.string.d48));
            this.iWW.setType(this.jax);
            this.iWW.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.iWW, false));
            this.iWW.setDataQuery(new AppBrandRecentView.c() {
                public final List qr(int i) {
                    AppMethodBeat.i(134128);
                    List a = ((af) g.K(af.class)).a(i, com.tencent.mm.plugin.appbrand.appusage.af.a.DESC);
                    AppMethodBeat.o(134128);
                    return a;
                }
            });
        }
        AppMethodBeat.o(134138);
    }

    public AppBrandDesktopHalfItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(134139);
        init(context);
        AppMethodBeat.o(134139);
    }

    public AppBrandDesktopHalfItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(134140);
        init(context);
        AppMethodBeat.o(134140);
    }

    private void init(Context context) {
        AppMethodBeat.i(134141);
        this.mContext = context;
        View inflate = com.tencent.mm.ui.v.hu(this.mContext).inflate(R.layout.bw, this);
        this.jao = (TextView) inflate.findViewById(R.id.pw);
        this.jao.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(134129);
                if (AppBrandDesktopHalfItemView.this.jax == f.MY_APP_BRAND) {
                    ((com.tencent.mm.plugin.appbrand.service.g) g.K(com.tencent.mm.plugin.appbrand.service.g.class)).cB(AppBrandDesktopHalfItemView.this.getContext());
                    if (AppBrandDesktopHalfItemView.this.jaB != null) {
                        AppBrandDesktopHalfItemView.this.jaB.aQg();
                        AppMethodBeat.o(134129);
                        return;
                    }
                } else if (AppBrandDesktopHalfItemView.this.jax == f.RECENT_APP_BRAND) {
                    ((com.tencent.mm.plugin.appbrand.service.g) g.K(com.tencent.mm.plugin.appbrand.service.g.class)).C(AppBrandDesktopHalfItemView.this.getContext(), 3);
                    if (AppBrandDesktopHalfItemView.this.jaB != null) {
                        AppBrandDesktopHalfItemView.this.jaB.aQh();
                    }
                }
                AppMethodBeat.o(134129);
            }
        });
        this.jap = (ImageView) inflate.findViewById(R.id.px);
        this.jap.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(134130);
                if (AppBrandDesktopHalfItemView.this.jax == f.MY_APP_BRAND) {
                    ((com.tencent.mm.plugin.appbrand.service.g) g.K(com.tencent.mm.plugin.appbrand.service.g.class)).cB(AppBrandDesktopHalfItemView.this.getContext());
                    if (AppBrandDesktopHalfItemView.this.jaB != null) {
                        AppBrandDesktopHalfItemView.this.jaB.aQg();
                        AppMethodBeat.o(134130);
                        return;
                    }
                } else if (AppBrandDesktopHalfItemView.this.jax == f.RECENT_APP_BRAND) {
                    ((com.tencent.mm.plugin.appbrand.service.g) g.K(com.tencent.mm.plugin.appbrand.service.g.class)).C(AppBrandDesktopHalfItemView.this.getContext(), 3);
                    if (AppBrandDesktopHalfItemView.this.jaB != null) {
                        AppBrandDesktopHalfItemView.this.jaB.aQh();
                    }
                }
                AppMethodBeat.o(134130);
            }
        });
        this.jav = (FrameLayout) inflate.findViewById(R.id.py);
        this.jau = (LinearLayout) inflate.findViewById(R.id.pz);
        aQa();
        this.iWW = (ConversationAppBrandRecentView) inflate.findViewById(R.id.q0);
        this.iWW.setRefreshListener(new e() {
            public final void qs(int i) {
                AppMethodBeat.i(134131);
                if (AppBrandDesktopHalfItemView.this.jaq != null) {
                    AppBrandDesktopHalfItemView.this.jaq.qs(i);
                }
                AppMethodBeat.o(134131);
            }
        });
        this.iWW.getAdapter().a(new RecyclerView.c() {
            public final void ax(int i, int i2) {
                AppMethodBeat.i(134132);
                super.ax(i, i2);
                if (AppBrandDesktopHalfItemView.this.jar != null) {
                    AppBrandDesktopHalfItemView.this.jar.ax(i, i2);
                }
                AppMethodBeat.o(134132);
            }
        });
        this.iWW.setOnItemClickListener(new AppBrandRecentView.b() {
            public final boolean a(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                AppMethodBeat.i(134133);
                if (AppBrandDesktopHalfItemView.this.jas != null) {
                    boolean a = AppBrandDesktopHalfItemView.this.jas.a(view, aVar, f, f2);
                    AppMethodBeat.o(134133);
                    return a;
                }
                AppMethodBeat.o(134133);
                return false;
            }

            public final boolean b(View view, com.tencent.mm.plugin.appbrand.widget.recentview.a aVar, float f, float f2) {
                AppMethodBeat.i(134134);
                if (AppBrandDesktopHalfItemView.this.jas != null) {
                    boolean b = AppBrandDesktopHalfItemView.this.jas.b(view, aVar, f, f2);
                    AppMethodBeat.o(134134);
                    return b;
                }
                AppMethodBeat.o(134134);
                return false;
            }
        });
        this.iWW.setOnScrollPageListener(new com.tencent.mm.plugin.appbrand.widget.recentview.c() {
            public final void L(int i, boolean z) {
                AppMethodBeat.i(134135);
                ab.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo onScrollPageChanged currentPage: %d, isAuto: %b", Integer.valueOf(i), Boolean.valueOf(z));
                if (!(AppBrandDesktopHalfItemView.this.jat == null || z)) {
                    com.tencent.mm.plugin.appbrand.widget.recentview.b f;
                    if (AppBrandDesktopHalfItemView.this.jax == f.RECENT_APP_BRAND) {
                        f = AppBrandDesktopHalfItemView.this.jat;
                        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollRecentList");
                        f.jmP++;
                        AppMethodBeat.o(134135);
                        return;
                    } else if (AppBrandDesktopHalfItemView.this.jax == f.MY_APP_BRAND) {
                        f = AppBrandDesktopHalfItemView.this.jat;
                        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollStarList");
                        f.jmY++;
                    }
                }
                AppMethodBeat.o(134135);
            }
        });
        this.iWW.setOnBindCustomViewHolderListener(new com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.a() {
            public final void a(c cVar, int i) {
                AppMethodBeat.i(134136);
                if (!(AppBrandDesktopHalfItemView.this.jaz == null || AppBrandDesktopHalfItemView.this.jaz.ape != i || !AppBrandDesktopHalfItemView.this.jaA || cVar == null || cVar.apJ == null)) {
                    ab.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo ScaleAndAlphaAnimation set to default position: %d", Integer.valueOf(i));
                    AppBrandDesktopHalfItemView.this.jaz.jaG = cVar;
                    AppBrandDesktopHalfItemView.this.jaA = false;
                }
                AppMethodBeat.o(134136);
            }
        });
        AppMethodBeat.o(134141);
    }

    public void setOnLaunchUIListener(b bVar) {
        this.jaB = bVar;
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(134142);
        super.onMeasure(i, i2);
        if (!(!this.jaC || this.jap.getMeasuredWidth() == 0 || this.jap.getMeasuredHeight() == 0)) {
            this.jap.getLayoutParams().width = (int) (((float) this.jap.getMeasuredWidth()) * d.dm(getContext()));
            this.jap.getLayoutParams().height = (int) (((float) this.jap.getMeasuredHeight()) * d.dm(getContext()));
            this.jaC = false;
        }
        AppMethodBeat.o(134142);
    }

    public final void a(Configuration configuration) {
        AppMethodBeat.i(134143);
        ab.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo HalfItemView onConfigurationChanged orientation: %d", Integer.valueOf(configuration.orientation));
        if (this.ivr != configuration.orientation) {
            ConversationAppBrandRecentView conversationAppBrandRecentView = this.iWW;
            int itemDecorationCount = conversationAppBrandRecentView.getItemDecorationCount();
            if (itemDecorationCount <= 0) {
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(itemDecorationCount)));
                AppMethodBeat.o(134143);
                throw indexOutOfBoundsException;
            }
            h hVar = (h) conversationAppBrandRecentView.anm.get(0);
            if (hVar != null && (hVar instanceof a)) {
                ((a) hVar).padding = d.dj(this.mContext);
            }
            this.iWW.getAdapter().aop.notifyChanged();
        }
        this.ivr = configuration.orientation;
        AppMethodBeat.o(134143);
    }

    private void aQa() {
        AppMethodBeat.i(134144);
        this.jau.setLayoutParams(new LayoutParams(getContext().getResources().getDisplayMetrics().widthPixels * 2, -2));
        AppMethodBeat.o(134144);
    }

    public void setItemPadding(int i) {
        this.iWJ = i;
    }

    private void setToDefaultStatus(v vVar) {
        AppMethodBeat.i(134145);
        if (vVar instanceof c) {
            vVar.apJ.setAlpha(0.0f);
            vVar.apJ.setScaleX(0.95f);
            vVar.apJ.setScaleY(0.95f);
        }
        AppMethodBeat.o(134145);
    }

    public void setRefreshListener(e eVar) {
        AppMethodBeat.i(134146);
        this.iWW.setRefreshListener(eVar);
        AppMethodBeat.o(134146);
    }

    public void setEnableDataCache(boolean z) {
        AppMethodBeat.i(134147);
        this.iWW.setEnableDataCache(z);
        AppMethodBeat.o(134147);
    }

    public void setOnItemClickListener(AppBrandRecentView.b bVar) {
        this.jas = bVar;
    }

    public void setTitle(String str) {
        AppMethodBeat.i(134148);
        this.jao.setText(str);
        AppMethodBeat.o(134148);
    }

    public void setTitlePaddingLeft(int i) {
        AppMethodBeat.i(134149);
        if (this.jao != null) {
            TextView textView = this.jao;
            textView.setPadding(i, textView.getPaddingTop(), this.jao.getPaddingRight(), this.jao.getPaddingBottom());
        }
        AppMethodBeat.o(134149);
    }

    public void setTitlePadding(Rect rect) {
        AppMethodBeat.i(134150);
        if (rect != null) {
            this.jao.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
        AppMethodBeat.o(134150);
    }

    public void setDataQuery(AppBrandRecentView.c cVar) {
        AppMethodBeat.i(134151);
        this.iWW.setDataQuery(cVar);
        AppMethodBeat.o(134151);
    }

    public ConversationAppBrandRecentView getRecentView() {
        return this.iWW;
    }

    public List<com.tencent.mm.plugin.appbrand.widget.recentview.a> getPreviewList() {
        AppMethodBeat.i(134152);
        List previewItemList = this.iWW.getPreviewItemList();
        AppMethodBeat.o(134152);
        return previewItemList;
    }

    public int getDataCount() {
        AppMethodBeat.i(134153);
        int dataCount = this.iWW.getDataCount();
        AppMethodBeat.o(134153);
        return dataCount;
    }

    public int getCustomCount() {
        AppMethodBeat.i(134154);
        int customItemCount = this.iWW.getCustomItemCount();
        AppMethodBeat.o(134154);
        return customItemCount;
    }

    public void setCreateContextMenuListener(OnCreateContextMenuListener onCreateContextMenuListener) {
        AppMethodBeat.i(134155);
        this.iWW.setCreateContextMenuListener(onCreateContextMenuListener);
        AppMethodBeat.o(134155);
    }

    public void setMenuItemSelectedListener(com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a aVar) {
        AppMethodBeat.i(134156);
        this.iWW.setMenuItemSelectedListener(aVar);
        AppMethodBeat.o(134156);
    }

    public void setOnDataChangedListener(AppBrandRecentView.d dVar) {
        AppMethodBeat.i(134157);
        this.iWW.setOnDataChangedListener(dVar);
        AppMethodBeat.o(134157);
    }

    public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b bVar) {
        this.jat = bVar;
    }

    public final void a(com.tencent.mm.plugin.appbrand.widget.recentview.e.b bVar) {
        AppMethodBeat.i(134158);
        ConversationAppBrandRecentView conversationAppBrandRecentView = this.iWW;
        if (conversationAppBrandRecentView.jnB != null) {
            com.tencent.mm.plugin.appbrand.widget.recentview.e eVar = conversationAppBrandRecentView.jnB;
            eVar.joq = true;
            eVar.a(0, bVar, true);
        }
        AppMethodBeat.o(134158);
    }

    public final void aQb() {
        AppMethodBeat.i(134159);
        ConversationAppBrandRecentView conversationAppBrandRecentView = this.iWW;
        if (conversationAppBrandRecentView.jnB != null) {
            com.tencent.mm.plugin.appbrand.widget.recentview.e eVar = conversationAppBrandRecentView.jnB;
            eVar.joi.getLayoutManager().bY(0);
            eVar.mOffsetX = 0;
            eVar.joj = 0;
            eVar.jok = 0;
            eVar.jiy = 0;
        }
        AppMethodBeat.o(134159);
    }

    static /* synthetic */ void j(AppBrandDesktopHalfItemView appBrandDesktopHalfItemView) {
        appBrandDesktopHalfItemView.jaz = null;
        appBrandDesktopHalfItemView.jaA = false;
    }
}
