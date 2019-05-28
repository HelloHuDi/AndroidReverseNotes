package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.offenread;

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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f */
public final class C27534f extends C41530m {
    C37139r aoC;
    private int ape = -1;
    private int iXP = 0;
    private float ibD = ((float) ViewConfiguration.get(C4996ah.getContext()).getScaledTouchSlop());
    BizTimeLineHotListView jQE;
    private C27536b jQF = null;
    C27535a jQG = null;
    private int jis = 0;
    int jiy = 0;
    private int joj;
    private int jok = 0;
    C37139r jol;
    int jom;
    private boolean joo = false;
    LinearLayoutManager jop;
    private boolean joq = false;
    private boolean jos = false;
    private boolean jot = false;
    private boolean jou = false;
    Context mContext;
    int mOffsetX;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f$1 */
    class C275321 extends C41189ah {
        C275321(Context context) {
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
            AppMethodBeat.m2504i(14346);
            int cb = super.mo30874cb(i);
            AppMethodBeat.m2505o(14346);
            return cb;
        }

        /* renamed from: bX */
        public final PointF mo22752bX(int i) {
            AppMethodBeat.m2504i(14347);
            PointF bX = ((LinearLayoutManager) C27534f.this.jQE.getLayoutManager()).mo1761bX(i);
            AppMethodBeat.m2505o(14347);
            return bX;
        }

        public final void onStop() {
            AppMethodBeat.m2504i(14348);
            super.onStop();
            AppMethodBeat.m2505o(14348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f$2 */
    class C275332 extends C41189ah {
        C275332(Context context) {
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
            AppMethodBeat.m2504i(14349);
            PointF bX = ((LinearLayoutManager) C27534f.this.jQE.getLayoutManager()).mo1761bX(i);
            AppMethodBeat.m2505o(14349);
            return bX;
        }

        public final void onStop() {
            AppMethodBeat.m2504i(14350);
            super.onStop();
            C4990ab.m7417i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", Integer.valueOf(C27534f.this.jQE.getScrollState()));
            if (C27534f.this.jQE.getScrollState() == 0) {
                C27534f.this.aSb();
            }
            AppMethodBeat.m2505o(14350);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f$a */
    public interface C27535a {
        /* renamed from: fy */
        void mo45323fy(boolean z);

        /* renamed from: sj */
        void mo45324sj(int i);
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f$b */
    public interface C27536b {
    }

    public C27534f(int i) {
        AppMethodBeat.m2504i(14351);
        this.jis = i;
        AppMethodBeat.m2505o(14351);
    }

    private void aSa() {
        this.joo = false;
        this.joq = false;
        this.jQF = null;
        this.ape = -1;
    }

    /* renamed from: a */
    public final void mo6642a(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(14352);
        super.mo6642a(recyclerView, i, i2);
        this.jok += i;
        if (!(this.jQG == null || (i == 0 && i2 == 0))) {
            this.jQG.mo45324sj(this.jok);
        }
        this.mOffsetX += i;
        AppMethodBeat.m2505o(14352);
    }

    /* renamed from: c */
    public final void mo6643c(RecyclerView recyclerView, int i) {
        AppMethodBeat.m2504i(14353);
        super.mo6643c(recyclerView, i);
        C4990ab.m7417i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", Integer.valueOf(i));
        int qY;
        if (i == 0 && this.iXP != 2) {
            qY = mo45341qY(this.mOffsetX);
            if (this.jQE != null && this.jot) {
                this.aoC.ape = qY;
                this.jou = true;
                this.jQE.getLayoutManager().mo31829a(this.aoC);
            }
            this.jos = true;
        } else if (!this.jos && i == 2) {
            this.jos = true;
        } else if (i == 0) {
            this.joj = this.mOffsetX;
            this.jos = false;
            qY = this.jiy;
            int iQ = this.jop.mo1780iQ();
            C4990ab.m7417i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", Integer.valueOf(iQ));
            if (iQ != -1) {
                this.jiy = iQ / this.jom;
                C4990ab.m7417i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", Integer.valueOf(this.jiy), Integer.valueOf(iQ));
                if (!(qY == this.jiy || this.jQG == null)) {
                    this.jQG.mo45323fy(!this.jot);
                }
            } else {
                C4990ab.m7413e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", Integer.valueOf(this.jiy));
            }
            this.jot = false;
            this.jok = 0;
            if (this.joq) {
                C4990ab.m7410d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
                this.jQE.getAdapter().mo66308ar(this.jQE.getDataCount(), 5);
                C27536b c27536b = this.jQF;
                this.joq = false;
                int dataCount = this.jQE.getDataCount();
                qY = dataCount / this.jom;
                if (dataCount % this.jom == 0) {
                    qY++;
                }
                qY = this.jom * (qY + 1);
                if (qY <= 0) {
                    qY = 0;
                }
                C4990ab.m7417i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", Integer.valueOf(dataCount), Integer.valueOf(r5), Integer.valueOf(qY));
                this.jQF = c27536b;
                this.joo = true;
                iQ = m43685ra(qY);
                this.ape = C27534f.m43686rb(iQ);
                this.jiy = m43685ra(this.jop.mo1781iR());
                C4990ab.m7417i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", Integer.valueOf(this.jiy), Integer.valueOf(qY), Integer.valueOf(iQ), Integer.valueOf(this.ape));
                if (iQ == this.jiy) {
                    aSb();
                } else {
                    mo45339N(this.ape, true);
                }
            } else {
                aSb();
            }
            if (this.jou) {
                C4990ab.m7416i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
                this.jou = false;
                this.jQE.scrollBy(-1, 0);
            }
        } else if (i == 1) {
            C4990ab.m7416i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
            this.jot = true;
        }
        this.iXP = i;
        AppMethodBeat.m2505o(14353);
    }

    /* Access modifiers changed, original: final */
    public final void aSb() {
        AppMethodBeat.m2504i(14354);
        if (this.joo) {
            C4990ab.m7416i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
            aSa();
        }
        AppMethodBeat.m2505o(14354);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qY */
    public final int mo45341qY(int i) {
        AppMethodBeat.m2504i(14355);
        int i2 = this.jiy;
        float width = (float) this.jQE.getWidth();
        int i3 = this.jiy;
        C4990ab.m7411d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", Integer.valueOf(i), Integer.valueOf(this.joj), Integer.valueOf(i - this.joj), Float.valueOf(width), Float.valueOf(this.ibD), Integer.valueOf(this.jiy));
        if (((float) (i - this.joj)) >= width / 2.0f) {
            i2 = m43685ra(this.jop.mo1782iS());
        } else if (i - this.joj >= 0 && ((float) (i - this.joj)) < this.ibD) {
            C4990ab.m7417i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", Integer.valueOf(i2), Integer.valueOf(m43684qZ(i2)));
            i2 = m43684qZ(i2);
            AppMethodBeat.m2505o(14355);
            return i2;
        } else if (((float) (i - this.joj)) <= (-width) / 2.0f) {
            i2 = m43685ra(this.jop.mo1780iQ());
        }
        int itemCount = this.jQE.getAdapter().getItemCount();
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
        C4990ab.m7417i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(C27534f.m43686rb(i2)));
        i2 = m43684qZ(i2);
        AppMethodBeat.m2505o(14355);
        return i2;
    }

    /* renamed from: qZ */
    private int m43684qZ(int i) {
        if (i == 0) {
            return 0;
        }
        return (this.jom * i) + this.jis;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: N */
    public final void mo45339N(int i, boolean z) {
        AppMethodBeat.m2504i(14356);
        if (this.jQE != null && (this.jot || z)) {
            this.jol.ape = i;
            this.jou = true;
            this.jQE.getLayoutManager().mo31829a(this.jol);
        }
        AppMethodBeat.m2505o(14356);
    }

    /* renamed from: ra */
    private int m43685ra(int i) {
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
    public static int m43686rb(int i) {
        AppMethodBeat.m2504i(14357);
        if (i == 0) {
            AppMethodBeat.m2505o(14357);
            return 0;
        }
        int completelyCountPerPage = (C42819a.getCompletelyCountPerPage() * i) + 1;
        AppMethodBeat.m2505o(14357);
        return completelyCountPerPage;
    }

    /* renamed from: rc */
    public static int m43687rc(int i) {
        AppMethodBeat.m2504i(14358);
        int completelyCountPerPage = ((i + 1) * C42819a.getCompletelyCountPerPage()) + 1;
        AppMethodBeat.m2505o(14358);
        return completelyCountPerPage;
    }
}
