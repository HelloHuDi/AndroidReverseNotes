package com.tencent.mm.plugin.appbrand.widget.recentview;

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

public final class e extends m {
    r aoC;
    private int ape = -1;
    private int iXP = 0;
    private float ibD = ((float) ViewConfiguration.get(ah.getContext()).getScaledTouchSlop());
    private int jis = 0;
    public int jiy = 0;
    public BaseAppBrandRecentView joi;
    public int joj;
    public int jok = 0;
    r jol;
    public int jom;
    private b jon = null;
    private boolean joo = false;
    LinearLayoutManager jop;
    public boolean joq = false;
    a jor = null;
    private boolean jos = false;
    private boolean jot = false;
    private boolean jou = false;
    Context mContext;
    public int mOffsetX;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.e$2 */
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
            AppMethodBeat.i(134390);
            PointF bX = ((LinearLayoutManager) e.this.joi.getLayoutManager()).bX(i);
            AppMethodBeat.o(134390);
            return bX;
        }

        public final void onStop() {
            AppMethodBeat.i(134391);
            super.onStop();
            ab.i("ViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", Integer.valueOf(e.this.joi.getScrollState()));
            if (e.this.joi.getScrollState() == 0) {
                e.this.aSb();
            }
            AppMethodBeat.o(134391);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.e$1 */
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
            AppMethodBeat.i(134387);
            int cb = super.cb(i);
            AppMethodBeat.o(134387);
            return cb;
        }

        public final PointF bX(int i) {
            AppMethodBeat.i(134388);
            PointF bX = ((LinearLayoutManager) e.this.joi.getLayoutManager()).bX(i);
            AppMethodBeat.o(134388);
            return bX;
        }

        public final void onStop() {
            AppMethodBeat.i(134389);
            super.onStop();
            AppMethodBeat.o(134389);
        }
    }

    public interface b {
        void aQe();
    }

    public interface a {
        void L(int i, boolean z);

        void e(RecyclerView recyclerView, int i);

        void h(RecyclerView recyclerView, int i, int i2);
    }

    public e(int i) {
        AppMethodBeat.i(134392);
        this.jis = i;
        AppMethodBeat.o(134392);
    }

    private void aSa() {
        this.joo = false;
        this.joq = false;
        this.jon = null;
        this.ape = -1;
    }

    public final void a(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.i(134393);
        super.a(recyclerView, i, i2);
        this.jok += i;
        if (this.jor != null) {
            this.jor.e(recyclerView, this.jok);
        }
        this.mOffsetX += i;
        AppMethodBeat.o(134393);
    }

    public final void c(RecyclerView recyclerView, int i) {
        AppMethodBeat.i(134394);
        super.c(recyclerView, i);
        ab.i("ViewPagerHelper", "alvinluo onScrollStateChanged newState: %d", Integer.valueOf(i));
        if (this.jor != null) {
            this.jor.h(recyclerView, i, this.jok);
        }
        int qY;
        if (i == 0 && this.iXP != 2) {
            qY = qY(this.mOffsetX);
            if (this.joi != null && this.jot) {
                this.aoC.ape = qY;
                this.jou = true;
                this.joi.getLayoutManager().a(this.aoC);
            }
            this.jos = true;
        } else if (!this.jos && i == 2) {
            this.jos = true;
        } else if (i == 0) {
            this.joj = this.mOffsetX;
            this.jos = false;
            qY = this.jiy;
            int iQ = this.jop.iQ();
            ab.i("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos: %d", Integer.valueOf(iQ));
            if (iQ != -1) {
                this.jiy = iQ / this.jom;
                ab.i("ViewPagerHelper", "alvinluo onScrollStateChanged mCurPage: %d, firstVisible: %d", Integer.valueOf(this.jiy), Integer.valueOf(iQ));
                if (!(qY == this.jiy || this.jor == null)) {
                    this.jor.L(this.jiy, !this.jot);
                }
            } else {
                ab.e("ViewPagerHelper", "alvinluo onScrollStateChanged firstPos is -1, invalid, mCurPage: %d", Integer.valueOf(this.jiy));
            }
            this.jot = false;
            this.jok = 0;
            if (this.joq) {
                ab.d("ViewPagerHelper", "alvinluo scrollMore");
                com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
                this.joq = false;
                a(0, this.jon, true);
                aSb();
            } else {
                aSb();
            }
            if (this.jou) {
                ab.i("ViewPagerHelper", "alvinluo scrollBy x: -1, y: 0");
                this.jou = false;
                this.joi.scrollBy(-1, 0);
            }
        } else if (i == 1) {
            ab.i("ViewPagerHelper", "SCROLL_STATE_DRAGGING");
            this.jot = true;
        }
        this.iXP = i;
        AppMethodBeat.o(134394);
    }

    /* Access modifiers changed, original: final */
    public final void aSb() {
        AppMethodBeat.i(134395);
        if (this.joo) {
            ab.i("ViewPagerHelper", "alvinluo onScrollAnimationEnd");
            if (this.jon != null) {
                this.jon.aQe();
            }
            aSa();
        }
        AppMethodBeat.o(134395);
    }

    /* Access modifiers changed, original: final */
    public final int qY(int i) {
        AppMethodBeat.i(134396);
        int i2 = this.jiy;
        float width = (float) this.joi.getWidth();
        int i3 = this.jiy;
        ab.d("ViewPagerHelper", "alvinluo getOffsetToPosition offset: %d, mTmpOffset: %d, diff: %d, width: %s, mTouchSlop: %s, curPage: %d", Integer.valueOf(i), Integer.valueOf(this.joj), Integer.valueOf(i - this.joj), Float.valueOf(width), Float.valueOf(this.ibD), Integer.valueOf(this.jiy));
        if (((float) (i - this.joj)) >= width / 2.0f) {
            i2 = ra(this.jop.iS());
        } else if (i - this.joj >= 0 && ((float) (i - this.joj)) < this.ibD) {
            ab.i("ViewPagerHelper", "alvinluo [getOffsetToPosition] targetPage: %s targetPos: %s", Integer.valueOf(i2), Integer.valueOf(qZ(i2)));
            i2 = qZ(i2);
            AppMethodBeat.o(134396);
            return i2;
        } else if (((float) (i - this.joj)) <= (-width) / 2.0f) {
            i2 = ra(this.jop.iQ());
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
        ab.i("ViewPagerHelper", "[getOffsetToPosition] lastPage: %d, targetPage: %d targetPos: %d", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(rb(i2)));
        i2 = qZ(i2);
        AppMethodBeat.o(134396);
        return i2;
    }

    private int qZ(int i) {
        if (i == 0) {
            return 0;
        }
        return (this.jom * i) + this.jis;
    }

    public final void a(int i, b bVar, boolean z) {
        AppMethodBeat.i(134397);
        this.jon = bVar;
        this.joo = true;
        int ra = ra(i);
        this.ape = rb(ra);
        this.jiy = ra(this.jop.iR());
        ab.i("ViewPagerHelper", "alvinluo fastScroll curPage: %d, pos: %d, targetPage: %d, targetPos: %d", Integer.valueOf(this.jiy), Integer.valueOf(i), Integer.valueOf(ra), Integer.valueOf(this.ape));
        if (ra != this.jiy || z) {
            N(this.ape, true);
            AppMethodBeat.o(134397);
            return;
        }
        aSb();
        AppMethodBeat.o(134397);
    }

    /* Access modifiers changed, original: final */
    public final void N(int i, boolean z) {
        AppMethodBeat.i(134398);
        if (this.joi != null && (this.jot || z)) {
            this.jol.ape = i;
            this.jou = true;
            this.joi.getLayoutManager().a(this.jol);
        }
        AppMethodBeat.o(134398);
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
        AppMethodBeat.i(134399);
        if (i == 0) {
            AppMethodBeat.o(134399);
            return 0;
        }
        int completelyCountPerPage = com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage() * i;
        com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
        completelyCountPerPage++;
        AppMethodBeat.o(134399);
        return completelyCountPerPage;
    }

    public static int rc(int i) {
        AppMethodBeat.i(134400);
        int completelyCountPerPage = (i + 1) * com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
        com.tencent.mm.plugin.appbrand.widget.desktop.b.aPf();
        completelyCountPerPage++;
        AppMethodBeat.o(134400);
        return completelyCountPerPage;
    }

    public static int rd(int i) {
        AppMethodBeat.i(134401);
        int completelyCountPerPage = i / com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage();
        if (i % com.tencent.mm.plugin.appbrand.widget.desktop.b.getCompletelyCountPerPage() == 0 && i != 0) {
            completelyCountPerPage--;
        }
        AppMethodBeat.o(134401);
        return completelyCountPerPage;
    }
}
