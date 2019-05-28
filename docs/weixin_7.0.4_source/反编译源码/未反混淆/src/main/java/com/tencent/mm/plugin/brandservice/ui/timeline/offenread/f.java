package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class f extends m {
    r aoC;
    private int ape = -1;
    private int iXP = 0;
    private float ibD = ((float) ViewConfiguration.get(ah.getContext()).getScaledTouchSlop());
    BizTimeLineHotListView jQE;
    private b jQF = null;
    a jQG = null;
    private int jis = 0;
    int jiy = 0;
    private int joj;
    private int jok = 0;
    r jol;
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
    class AnonymousClass1 extends android.support.v7.widget.ah {
        AnonymousClass1(Context context) {
            super(context);
        }

        public final int iX() {
            return -1;
        }

        public final float c(DisplayMetrics displayMetrics) {
            return 80.0f / ((float) displayMetrics.densityDpi);
        }

        public final int cb(int i) {
            AppMethodBeat.i(14346);
            int cb = super.cb(i);
            AppMethodBeat.o(14346);
            return cb;
        }

        public final PointF bX(int i) {
            AppMethodBeat.i(14347);
            PointF bX = ((LinearLayoutManager) f.this.jQE.getLayoutManager()).bX(i);
            AppMethodBeat.o(14347);
            return bX;
        }

        public final void onStop() {
            AppMethodBeat.i(14348);
            super.onStop();
            AppMethodBeat.o(14348);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f$2 */
    class AnonymousClass2 extends android.support.v7.widget.ah {
        AnonymousClass2(Context context) {
            super(context);
        }

        public final int iX() {
            return -1;
        }

        public final float c(DisplayMetrics displayMetrics) {
            return 40.0f / ((float) displayMetrics.densityDpi);
        }

        public final PointF bX(int i) {
            AppMethodBeat.i(14349);
            PointF bX = ((LinearLayoutManager) f.this.jQE.getLayoutManager()).bX(i);
            AppMethodBeat.o(14349);
            return bX;
        }

        public final void onStop() {
            AppMethodBeat.i(14350);
            super.onStop();
            ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", Integer.valueOf(f.this.jQE.getScrollState()));
            if (f.this.jQE.getScrollState() == 0) {
                f.this.aSb();
            }
            AppMethodBeat.o(14350);
        }
    }

    public interface a {
        void fy(boolean z);

        void sj(int i);
    }

    public interface b {
    }

    public f(int i) {
        AppMethodBeat.i(14351);
        this.jis = i;
        AppMethodBeat.o(14351);
    }

    private void aSa() {
        this.joo = false;
        this.joq = false;
        this.jQF = null;
        this.ape = -1;
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(14352);
        super.a(recyclerView, i, i2);
        this.jok += i;
        if (!(this.jQG == null || (i == 0 && i2 == 0))) {
            this.jQG.sj(this.jok);
        }
        this.mOffsetX += i;
        AppMethodBeat.o(14352);
    }

    public final void c(RecyclerView recyclerView, int i) {
        AppMethodBeat.i(14353);
        super.c(recyclerView, i);
        ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", Integer.valueOf(i));
        int qY;
        if (i == 0 && this.iXP != 2) {
            qY = qY(this.mOffsetX);
            if (this.jQE != null && this.jot) {
                this.aoC.ape = qY;
                this.jou = true;
                this.jQE.getLayoutManager().a(this.aoC);
            }
            this.jos = true;
        } else if (!this.jos && i == 2) {
            this.jos = true;
        } else if (i == 0) {
            this.joj = this.mOffsetX;
            this.jos = false;
            qY = this.jiy;
            int iQ = this.jop.iQ();
            ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", Integer.valueOf(iQ));
            if (iQ != -1) {
                this.jiy = iQ / this.jom;
                ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", Integer.valueOf(this.jiy), Integer.valueOf(iQ));
                if (!(qY == this.jiy || this.jQG == null)) {
                    this.jQG.fy(!this.jot);
                }
            } else {
                ab.e("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", Integer.valueOf(this.jiy));
            }
            this.jot = false;
            this.jok = 0;
            if (this.joq) {
                ab.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollMore");
                this.jQE.getAdapter().ar(this.jQE.getDataCount(), 5);
                b bVar = this.jQF;
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
                ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo smoothScrollToLastPage allCount: %d, lastPage: %d, targetPos: %d", Integer.valueOf(dataCount), Integer.valueOf(r5), Integer.valueOf(qY));
                this.jQF = bVar;
                this.joo = true;
                iQ = ra(qY);
                this.ape = rb(iQ);
                this.jiy = ra(this.jop.iR());
                ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", Integer.valueOf(this.jiy), Integer.valueOf(qY), Integer.valueOf(iQ), Integer.valueOf(this.ape));
                if (iQ == this.jiy) {
                    aSb();
                } else {
                    N(this.ape, true);
                }
            } else {
                aSb();
            }
            if (this.jou) {
                ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
                this.jou = false;
                this.jQE.scrollBy(-1, 0);
            }
        } else if (i == 1) {
            ab.i("MicroMsg.BizTimeLineViewPagerHelper", "SCROLL_STATE_DRAGGING");
            this.jot = true;
        }
        this.iXP = i;
        AppMethodBeat.o(14353);
    }

    /* Access modifiers changed, original: final */
    public final void aSb() {
        AppMethodBeat.i(14354);
        if (this.joo) {
            ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo onScrollAnimationEnd");
            aSa();
        }
        AppMethodBeat.o(14354);
    }

    /* Access modifiers changed, original: final */
    public final int qY(int i) {
        AppMethodBeat.i(14355);
        int i2 = this.jiy;
        float width = (float) this.jQE.getWidth();
        int i3 = this.jiy;
        ab.d("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", Integer.valueOf(i), Integer.valueOf(this.joj), Integer.valueOf(i - this.joj), Float.valueOf(width), Float.valueOf(this.ibD), Integer.valueOf(this.jiy));
        if (((float) (i - this.joj)) >= width / 2.0f) {
            i2 = ra(this.jop.iS());
        } else if (i - this.joj >= 0 && ((float) (i - this.joj)) < this.ibD) {
            ab.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", Integer.valueOf(i2), Integer.valueOf(qZ(i2)));
            i2 = qZ(i2);
            AppMethodBeat.o(14355);
            return i2;
        } else if (((float) (i - this.joj)) <= (-width) / 2.0f) {
            i2 = ra(this.jop.iQ());
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
        ab.i("MicroMsg.BizTimeLineViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(rb(i2)));
        i2 = qZ(i2);
        AppMethodBeat.o(14355);
        return i2;
    }

    private int qZ(int i) {
        if (i == 0) {
            return 0;
        }
        return (this.jom * i) + this.jis;
    }

    /* Access modifiers changed, original: final */
    public final void N(int i, boolean z) {
        AppMethodBeat.i(14356);
        if (this.jQE != null && (this.jot || z)) {
            this.jol.ape = i;
            this.jou = true;
            this.jQE.getLayoutManager().a(this.jol);
        }
        AppMethodBeat.o(14356);
    }

    private int ra(int i) {
        if (this.jis == 0) {
            return i / this.jom;
        }
        int i2 = i / this.jom;
        if (i % this.jom != 0 || i == 0) {
            return i2;
        }
        return i2 - 1;
    }

    public static int rb(int i) {
        AppMethodBeat.i(14357);
        if (i == 0) {
            AppMethodBeat.o(14357);
            return 0;
        }
        int completelyCountPerPage = (a.getCompletelyCountPerPage() * i) + 1;
        AppMethodBeat.o(14357);
        return completelyCountPerPage;
    }

    public static int rc(int i) {
        AppMethodBeat.i(14358);
        int completelyCountPerPage = ((i + 1) * a.getCompletelyCountPerPage()) + 1;
        AppMethodBeat.o(14358);
        return completelyCountPerPage;
    }
}
