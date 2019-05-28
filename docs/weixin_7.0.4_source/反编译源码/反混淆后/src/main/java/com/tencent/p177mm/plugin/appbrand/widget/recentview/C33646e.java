package com.tencent.p177mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.p069v7.widget.C41189ah;
import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C37139r;
import android.support.p069v7.widget.RecyclerView.C41530m;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.C2545b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.e */
public final class C33646e extends C41530m {
    C37139r aoC;
    private int ape = -1;
    private int iXP = 0;
    private float ibD = ((float) ViewConfiguration.get(C4996ah.getContext()).getScaledTouchSlop());
    private int jis = 0;
    public int jiy = 0;
    public BaseAppBrandRecentView joi;
    public int joj;
    public int jok = 0;
    C37139r jol;
    public int jom;
    private C33647b jon = null;
    private boolean joo = false;
    LinearLayoutManager jop;
    public boolean joq = false;
    C33648a jor = null;
    private boolean jos = false;
    private boolean jot = false;
    private boolean jou = false;
    Context mContext;
    public int mOffsetX;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.e$2 */
    class C110512 extends C41189ah {
        C110512(Context context) {
            super(context);
        }

        /* renamed from: iX */
        public final int mo22753iX() {
            return -1;
        }

        /* renamed from: c */
        public final float mo9235c(DisplayMetrics displayMetrics) {
            return 40.0f / ((float) displayMetrics.densityDpi);
        }

        /* renamed from: bX */
        public final PointF mo22752bX(int i) {
            AppMethodBeat.m2504i(134390);
            PointF bX = ((LinearLayoutManager) C33646e.this.joi.getLayoutManager()).mo1761bX(i);
            AppMethodBeat.m2505o(134390);
            return bX;
        }

        public final void onStop() {
            AppMethodBeat.m2504i(134391);
            super.onStop();
            C4990ab.m7417i("ViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", Integer.valueOf(C33646e.this.joi.getScrollState()));
            if (C33646e.this.joi.getScrollState() == 0) {
                C33646e.this.aSb();
            }
            AppMethodBeat.m2505o(134391);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.e$1 */
    class C274301 extends C41189ah {
        C274301(Context context) {
            super(context);
        }

        /* renamed from: iX */
        public final int mo22753iX() {
            return -1;
        }

        /* renamed from: c */
        public final float mo9235c(DisplayMetrics displayMetrics) {
            return 80.0f / ((float) displayMetrics.densityDpi);
        }

        /* renamed from: cb */
        public final int mo30874cb(int i) {
            AppMethodBeat.m2504i(134387);
            int cb = super.mo30874cb(i);
            AppMethodBeat.m2505o(134387);
            return cb;
        }

        /* renamed from: bX */
        public final PointF mo22752bX(int i) {
            AppMethodBeat.m2504i(134388);
            PointF bX = ((LinearLayoutManager) C33646e.this.joi.getLayoutManager()).mo1761bX(i);
            AppMethodBeat.m2505o(134388);
            return bX;
        }

        public final void onStop() {
            AppMethodBeat.m2504i(134389);
            super.onStop();
            AppMethodBeat.m2505o(134389);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.e$b */
    public interface C33647b {
        void aQe();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.e$a */
    public interface C33648a {
        /* renamed from: L */
        void mo35167L(int i, boolean z);

        /* renamed from: e */
        void mo35168e(RecyclerView recyclerView, int i);

        /* renamed from: h */
        void mo35169h(RecyclerView recyclerView, int i, int i2);
    }

    public C33646e(int i) {
        AppMethodBeat.m2504i(134392);
        this.jis = i;
        AppMethodBeat.m2505o(134392);
    }

    private void aSa() {
        this.joo = false;
        this.joq = false;
        this.jon = null;
        this.ape = -1;
    }

    /* renamed from: a */
    public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(134393);
        super.mo6642a(recyclerView, i, i2);
        this.jok += i;
        if (this.jor != null) {
            this.jor.mo35168e(recyclerView, this.jok);
        }
        this.mOffsetX += i;
        AppMethodBeat.m2505o(134393);
    }

    /* renamed from: c */
    public final void mo6643c(RecyclerView recyclerView, int i) {
        AppMethodBeat.m2504i(134394);
        super.mo6643c(recyclerView, i);
        C4990ab.m7417i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", Integer.valueOf(i));
        if (this.jor != null) {
            this.jor.mo35169h(recyclerView, i, this.jok);
        }
        int qY;
        if (i == 0 && this.iXP != 2) {
            qY = mo54216qY(this.mOffsetX);
            if (this.joi != null && this.jot) {
                this.aoC.ape = qY;
                this.jou = true;
                this.joi.getLayoutManager().mo31829a(this.aoC);
            }
            this.jos = true;
        } else if (!this.jos && i == 2) {
            this.jos = true;
        } else if (i == 0) {
            this.joj = this.mOffsetX;
            this.jos = false;
            qY = this.jiy;
            int iQ = this.jop.mo1780iQ();
            C4990ab.m7417i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", Integer.valueOf(iQ));
            if (iQ != -1) {
                this.jiy = iQ / this.jom;
                C4990ab.m7417i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", Integer.valueOf(this.jiy), Integer.valueOf(iQ));
                if (!(qY == this.jiy || this.jor == null)) {
                    this.jor.mo35167L(this.jiy, !this.jot);
                }
            } else {
                C4990ab.m7413e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", Integer.valueOf(this.jiy));
            }
            this.jot = false;
            this.jok = 0;
            if (this.joq) {
                C4990ab.m7410d("ViewPagerHelper", "alvinluo scrollMore");
                C2545b.aPf();
                this.joq = false;
                mo54214a(0, this.jon, true);
                aSb();
            } else {
                aSb();
            }
            if (this.jou) {
                C4990ab.m7416i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
                this.jou = false;
                this.joi.scrollBy(-1, 0);
            }
        } else if (i == 1) {
            C4990ab.m7416i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
            this.jot = true;
        }
        this.iXP = i;
        AppMethodBeat.m2505o(134394);
    }

    /* Access modifiers changed, original: final */
    public final void aSb() {
        AppMethodBeat.m2504i(134395);
        if (this.joo) {
            C4990ab.m7416i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
            if (this.jon != null) {
                this.jon.aQe();
            }
            aSa();
        }
        AppMethodBeat.m2505o(134395);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qY */
    public final int mo54216qY(int i) {
        AppMethodBeat.m2504i(134396);
        int i2 = this.jiy;
        float width = (float) this.joi.getWidth();
        int i3 = this.jiy;
        C4990ab.m7411d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", Integer.valueOf(i), Integer.valueOf(this.joj), Integer.valueOf(i - this.joj), Float.valueOf(width), Float.valueOf(this.ibD), Integer.valueOf(this.jiy));
        if (((float) (i - this.joj)) >= width / 2.0f) {
            i2 = m54941ra(this.jop.mo1782iS());
        } else if (i - this.joj >= 0 && ((float) (i - this.joj)) < this.ibD) {
            C4990ab.m7417i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", Integer.valueOf(i2), Integer.valueOf(m54940qZ(i2)));
            i2 = m54940qZ(i2);
            AppMethodBeat.m2505o(134396);
            return i2;
        } else if (((float) (i - this.joj)) <= (-width) / 2.0f) {
            i2 = m54941ra(this.jop.mo1780iQ());
        }
        int itemCount = this.joi.getAdapter().getItemCount();
        int i4 = itemCount / this.jom;
        if (itemCount % this.jom != 0) {
            i4++;
        }
        i2 = Math.max(Math.min(i2, i4 - 1), -1);
        if (i2 - i3 > 1) {
            i2 = i3 + 1;
        } else if (i3 - i2 > 1) {
            i2 = i3 - 1;
        }
        C4990ab.m7417i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(C33646e.m54942rb(i2)));
        i2 = m54940qZ(i2);
        AppMethodBeat.m2505o(134396);
        return i2;
    }

    /* renamed from: qZ */
    private int m54940qZ(int i) {
        if (i == 0) {
            return 0;
        }
        return (this.jom * i) + this.jis;
    }

    /* renamed from: a */
    public final void mo54214a(int i, C33647b c33647b, boolean z) {
        AppMethodBeat.m2504i(134397);
        this.jon = c33647b;
        this.joo = true;
        int ra = m54941ra(i);
        this.ape = C33646e.m54942rb(ra);
        this.jiy = m54941ra(this.jop.mo1781iR());
        C4990ab.m7417i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", Integer.valueOf(this.jiy), Integer.valueOf(i), Integer.valueOf(ra), Integer.valueOf(this.ape));
        if (ra != this.jiy || z) {
            mo54213N(this.ape, true);
            AppMethodBeat.m2505o(134397);
            return;
        }
        aSb();
        AppMethodBeat.m2505o(134397);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: N */
    public final void mo54213N(int i, boolean z) {
        AppMethodBeat.m2504i(134398);
        if (this.joi != null && (this.jot || z)) {
            this.jol.ape = i;
            this.jou = true;
            this.joi.getLayoutManager().mo31829a(this.jol);
        }
        AppMethodBeat.m2505o(134398);
    }

    /* renamed from: ra */
    private int m54941ra(int i) {
        if (this.jis == 0) {
            return i / this.jom;
        }
        int i2 = i / this.jom;
        if (i % this.jom != 0 || i == 0) {
            return i2;
        }
        return i2 - 1;
    }

    /* renamed from: rb */
    public static int m54942rb(int i) {
        AppMethodBeat.m2504i(134399);
        if (i == 0) {
            AppMethodBeat.m2505o(134399);
            return 0;
        }
        int completelyCountPerPage = C2545b.getCompletelyCountPerPage() * i;
        C2545b.aPf();
        completelyCountPerPage++;
        AppMethodBeat.m2505o(134399);
        return completelyCountPerPage;
    }

    /* renamed from: rc */
    public static int m54943rc(int i) {
        AppMethodBeat.m2504i(134400);
        int completelyCountPerPage = (i + 1) * C2545b.getCompletelyCountPerPage();
        C2545b.aPf();
        completelyCountPerPage++;
        AppMethodBeat.m2505o(134400);
        return completelyCountPerPage;
    }

    /* renamed from: rd */
    public static int m54944rd(int i) {
        AppMethodBeat.m2504i(134401);
        int completelyCountPerPage = i / C2545b.getCompletelyCountPerPage();
        if (i % C2545b.getCompletelyCountPerPage() == 0 && i != 0) {
            completelyCountPerPage--;
        }
        AppMethodBeat.m2505o(134401);
        return completelyCountPerPage;
    }
}
