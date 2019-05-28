package com.tencent.p177mm.p612ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30392j.C30393a;
import com.tencent.p177mm.p612ui.base.MMFlipper.C5250a;
import com.tencent.p177mm.p612ui.base.MMFlipper.C5251b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ui.base.MMGridPaper */
public final class MMGridPaper extends LinearLayout {
    protected View abB;
    /* renamed from: fS */
    protected int f2982fS = -1;
    /* renamed from: fW */
    protected int f2983fW = 0;
    /* renamed from: fX */
    protected int f2984fX = -1;
    protected int hiG = 0;
    protected MMDotView jiG;
    protected int mNumColumns = 0;
    protected C7306ak mty = new C7306ak(Looper.getMainLooper());
    protected int ysw = 10;
    protected int ysx = 10;
    protected MMFlipper yuA;
    protected C30392j yuB;
    protected int yuC;
    protected int yuD;
    protected int yuE = 0;
    protected int yuF = 0;
    protected int yuG = 3;
    protected int yuH = 0;
    protected int yuI = (this.yuG - 1);
    protected int yuJ = 0;
    protected boolean yuK = false;
    protected int yuL = 9;
    protected int yuM = -1;
    protected int yuN = -1;
    protected int yuO = 96;
    protected int yuP = 96;
    protected boolean yuQ = false;
    protected boolean yuR = false;
    protected int yuS = -1;
    protected int yuT = -1;
    protected boolean yuU = false;
    protected int yuV = 0;
    protected int yuW = 0;
    protected C15510a yuX;
    final C5251b yuf = new C155125();
    final C5250a yug = new C155114();

    /* renamed from: com.tencent.mm.ui.base.MMGridPaper$3 */
    class C155093 implements Runnable {
        C155093() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106618);
            C4990ab.m7420w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.m23825a(MMGridPaper.this);
            AppMethodBeat.m2505o(106618);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMGridPaper$a */
    public interface C15510a {
    }

    /* renamed from: com.tencent.mm.ui.base.MMGridPaper$4 */
    class C155114 implements C5250a {
        C155114() {
        }

        /* renamed from: fe */
        public final void mo10769fe(int i, int i2) {
            AppMethodBeat.m2504i(106619);
            C4990ab.m7419v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", Integer.valueOf(i), Integer.valueOf(MMGridPaper.this.yuC), Integer.valueOf(i2), Integer.valueOf(MMGridPaper.this.yuD), Boolean.valueOf(MMGridPaper.this.yuR), Boolean.valueOf(MMGridPaper.this.yuQ));
            if ((Math.abs(MMGridPaper.this.yuD - i2) < 50 && Math.abs(MMGridPaper.this.yuC - i) < 50) || i2 == 0 || i == 0) {
                C4990ab.m7410d("MicroMsg.MMGridPaper", "match width height limit, return");
                AppMethodBeat.m2505o(106619);
            } else if (!MMGridPaper.this.yuR || MMGridPaper.this.yuC <= i || MMGridPaper.this.yuQ) {
                C4990ab.m7418v("MicroMsg.MMGridPaper", "onMeasure: match");
                C4990ab.m7419v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", Boolean.valueOf(MMGridPaper.this.yuU));
                MMGridPaper.this.yuQ = false;
                if (!MMGridPaper.this.yuU) {
                    MMGridPaper.this.yuD = i2;
                    MMGridPaper.this.yuC = i;
                }
                MMGridPaper.this.refresh();
                AppMethodBeat.m2505o(106619);
            } else {
                C4990ab.m7410d("MicroMsg.MMGridPaper", "match ori limit, return");
                AppMethodBeat.m2505o(106619);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMGridPaper$5 */
    class C155125 implements C5251b {
        C155125() {
        }

        /* renamed from: BZ */
        public final void mo10770BZ(final int i) {
            AppMethodBeat.m2504i(106622);
            C4990ab.m7411d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", Integer.valueOf(i), Integer.valueOf(MMGridPaper.this.yuH), Integer.valueOf(MMGridPaper.this.yuI), Integer.valueOf(MMGridPaper.this.yuJ));
            if (i <= MMGridPaper.this.yuH && MMGridPaper.this.yuH > 0) {
                MMGridPaper.this.mty.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(106620);
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.this.yuA.getChildAt(MMGridPaper.this.yuA.getChildCount() - 1);
                        C4990ab.m7417i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", Integer.valueOf(MMGridPaper.this.yuA.getChildCount() - 1), Integer.valueOf(i - (MMGridPaper.this.yuA.getChildCount() >> 1)));
                        MMGridPaper.this.yuA.removeViewAt(MMGridPaper.this.yuA.getChildCount() - 1);
                        mMGridPaperGridView.mo69945a(r1, MMGridPaper.this.f2983fW, MMGridPaper.this.mNumColumns, MMGridPaper.this.yuB);
                        MMGridPaper.this.yuA.addView(mMGridPaperGridView, 0);
                        MMGridPaper.this.yuA.mo48692NF(MMGridPaper.this.yuA.getChildCount() >> 1);
                        MMGridPaper.m23826a(MMGridPaper.this, -1);
                        AppMethodBeat.m2505o(106620);
                    }
                });
            } else if (i >= MMGridPaper.this.yuI && MMGridPaper.this.yuI < MMGridPaper.this.yuJ - 1) {
                MMGridPaper.this.mty.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(106621);
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.this.yuA.getChildAt(0);
                        C4990ab.m7417i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", Integer.valueOf(i + (MMGridPaper.this.yuA.getChildCount() >> 1)));
                        MMGridPaper.this.yuA.removeViewAt(0);
                        mMGridPaperGridView.mo69945a(r1, MMGridPaper.this.f2983fW, MMGridPaper.this.mNumColumns, MMGridPaper.this.yuB);
                        MMGridPaper.this.yuA.addView(mMGridPaperGridView);
                        MMGridPaper.this.yuA.mo48692NF(MMGridPaper.this.yuA.getChildCount() >> 1);
                        MMGridPaper.m23826a(MMGridPaper.this, 1);
                        AppMethodBeat.m2505o(106621);
                    }
                });
            }
            MMGridPaper.this.yuF = i;
            MMGridPaper.this.jiG.setSelectedDot(i);
            AppMethodBeat.m2505o(106622);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMGridPaper$1 */
    class C155141 implements C30393a {
        C155141() {
        }

        public final void aWv() {
            AppMethodBeat.m2504i(106616);
            MMGridPaper.this.refresh();
            AppMethodBeat.m2505o(106616);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.MMGridPaper$2 */
    class C155152 implements Runnable {
        C155152() {
        }

        public final void run() {
            AppMethodBeat.m2504i(106617);
            C4990ab.m7420w("MicroMsg.MMGridPaper", "post do setDotView");
            MMGridPaper.m23825a(MMGridPaper.this);
            AppMethodBeat.m2505o(106617);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23825a(MMGridPaper mMGridPaper) {
        AppMethodBeat.m2504i(106638);
        mMGridPaper.chL();
        AppMethodBeat.m2505o(106638);
    }

    public MMGridPaper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106623);
        View.inflate(getContext(), 2130970119, this);
        this.hiG = getScreenOrientation();
        AppMethodBeat.m2505o(106623);
    }

    public final void setOnPageSizeChangeListener(C15510a c15510a) {
        this.yuX = c15510a;
    }

    public final void setMaxDotCount(int i) {
        this.yuL = i;
    }

    public final void setItemWidthInDp(int i) {
        this.yuO = i;
    }

    public final void setItemHeightInDp(int i) {
        this.yuP = i;
    }

    public final void setMaxRow(int i) {
        this.f2984fX = i;
    }

    public final void setMaxCol(int i) {
        this.f2982fS = i;
    }

    public final void setDisplayHeightLandInDp(int i) {
        this.yuM = i;
    }

    public final void setDisplayHeightPortInDp(int i) {
        this.yuN = i;
    }

    public final void setDialogMode(boolean z) {
        this.yuR = z;
    }

    public final void dzI() {
        this.yuT = 3;
        this.yuS = 3;
    }

    public final void dzJ() {
        this.ysw = 8;
        this.ysx = 15;
    }

    public final void setHeaderView(View view) {
        AppMethodBeat.m2504i(106624);
        this.abB = view;
        ViewGroup viewGroup = (ViewGroup) findViewById(2131821042);
        viewGroup.removeAllViews();
        if (this.abB != null) {
            viewGroup.addView(this.abB);
        }
        AppMethodBeat.m2505o(106624);
    }

    public final void setGridPaperAdapter(C30392j c30392j) {
        boolean z = true;
        AppMethodBeat.m2504i(106625);
        this.yuB = c30392j;
        String str = "MicroMsg.MMGridPaper";
        String str2 = "setGridPaperAdapter:adapter is null[%B]";
        Object[] objArr = new Object[1];
        if (c30392j != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        C4990ab.m7411d(str, str2, objArr);
        if (this.yuB != null) {
            this.yuB.yvb = new C155141();
        }
        djR();
        AppMethodBeat.m2505o(106625);
    }

    public final void refresh() {
        AppMethodBeat.m2504i(106626);
        this.yuE = (this.yuF * this.mNumColumns) * this.f2983fW;
        C4990ab.m7419v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", Integer.valueOf(this.yuF), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.f2983fW), Integer.valueOf(this.yuE));
        djR();
        AppMethodBeat.m2505o(106626);
    }

    public final int getPageCount() {
        return this.yuJ;
    }

    public final int getItemsCountPerPage() {
        return this.f2983fW * this.mNumColumns;
    }

    private int getScreenOrientation() {
        int i;
        AppMethodBeat.m2504i(106627);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            i = 1;
        } else {
            i = 2;
        }
        AppMethodBeat.m2505o(106627);
        return i;
    }

    private void dzK() {
        AppMethodBeat.m2504i(106628);
        View findViewById;
        LayoutParams layoutParams;
        int fromDPToPix;
        if (-1 == this.yuM || getScreenOrientation() != 2) {
            if (-1 != this.yuN && getScreenOrientation() == 1) {
                findViewById = findViewById(2131826002);
                layoutParams = (LayoutParams) findViewById.getLayoutParams();
                fromDPToPix = C1338a.fromDPToPix(getContext(), this.yuN);
                if (fromDPToPix != layoutParams.height) {
                    C4990ab.m7417i("MicroMsg.MMGridPaper", "set port mode, special height is %d", Integer.valueOf(this.yuN));
                    layoutParams.height = fromDPToPix;
                    findViewById.setLayoutParams(layoutParams);
                    this.mty.post(new C155093());
                }
            }
            AppMethodBeat.m2505o(106628);
            return;
        }
        findViewById = findViewById(2131826002);
        layoutParams = (LayoutParams) findViewById.getLayoutParams();
        fromDPToPix = C1338a.fromDPToPix(getContext(), this.yuM);
        if (fromDPToPix != layoutParams.height) {
            C4990ab.m7417i("MicroMsg.MMGridPaper", "set land mode, special height is %d", Integer.valueOf(this.yuM));
            layoutParams.height = fromDPToPix;
            findViewById.setLayoutParams(layoutParams);
            this.mty.post(new C155152());
        }
        AppMethodBeat.m2505o(106628);
    }

    private void djR() {
        AppMethodBeat.m2504i(106629);
        C4990ab.m7418v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
        if (this.jiG == null) {
            this.jiG = (MMDotView) findViewById(2131826004);
            this.jiG.setMaxCount(this.yuL);
        }
        if (this.yuA == null) {
            this.yuA = (MMFlipper) findViewById(2131826003);
            this.yuA.setOnMeasureListener(this.yug);
            this.yuA.setOnScreenChangedListener(this.yuf);
        }
        dzK();
        dzL();
        AppMethodBeat.m2505o(106629);
    }

    /* renamed from: NH */
    private boolean m23824NH(int i) {
        AppMethodBeat.m2504i(106630);
        C4990ab.m7411d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", Integer.valueOf(i), Boolean.valueOf(this.yuR));
        Assert.assertTrue(i >= 0);
        if (this.yuR) {
            int hg = MMGridPaper.m23827hg(i, this.mNumColumns);
            int min;
            switch (getScreenOrientation()) {
                case 1:
                    min = ((this.yuP + 10) * Math.min(hg, this.yuS)) + 8;
                    C4990ab.m7411d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(getScreenOrientation()), Integer.valueOf(Math.min(hg, this.yuS)), Integer.valueOf(min), Integer.valueOf(this.yuN), Boolean.valueOf(this.yuQ));
                    if (this.yuN != min) {
                        this.yuN = min;
                        AppMethodBeat.m2505o(106630);
                        return false;
                    }
                    AppMethodBeat.m2505o(106630);
                    return true;
                case 2:
                    min = ((this.yuP + 10) * Math.min(hg, this.yuT)) + 8;
                    C4990ab.m7411d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(getScreenOrientation()), Integer.valueOf(Math.min(hg, this.yuT)), Integer.valueOf(min), Integer.valueOf(this.yuM), Boolean.valueOf(this.yuQ));
                    if (this.yuM != min) {
                        this.yuM = min;
                        AppMethodBeat.m2505o(106630);
                        return false;
                    }
                    AppMethodBeat.m2505o(106630);
                    return true;
                default:
                    AppMethodBeat.m2505o(106630);
                    return true;
            }
        }
        AppMethodBeat.m2505o(106630);
        return true;
    }

    public final void setGridWidth(int i) {
        this.yuC = i;
    }

    public final void setGridHeight(int i) {
        this.yuD = i;
    }

    public final void setManualMeasureMode(boolean z) {
        this.yuU = z;
    }

    private void dzL() {
        AppMethodBeat.m2504i(106631);
        C4990ab.m7419v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", Integer.valueOf(this.yuC), Integer.valueOf(this.yuD));
        if (this.yuC == 0 || this.yuD == 0) {
            C4990ab.m7420w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
            AppMethodBeat.m2505o(106631);
            return;
        }
        int fromDPToPix = C1338a.fromDPToPix(getContext(), this.yuO);
        int fromDPToPix2 = C1338a.fromDPToPix(getContext(), this.yuP);
        fromDPToPix = Math.max(this.yuC / fromDPToPix, 1);
        fromDPToPix2 = Math.max(this.yuD / fromDPToPix2, 1);
        if (!(fromDPToPix == this.mNumColumns && fromDPToPix2 == this.f2983fW)) {
            this.yuK = true;
        }
        this.mNumColumns = fromDPToPix;
        if (this.f2982fS != -1) {
            this.mNumColumns = Math.min(this.mNumColumns, this.f2982fS);
        }
        this.f2983fW = fromDPToPix2;
        if (this.f2984fX != -1) {
            this.f2983fW = Math.min(this.f2983fW, this.f2984fX);
        }
        fromDPToPix2 = this.f2983fW * this.mNumColumns;
        this.yuJ = 0;
        fromDPToPix = (this.yuB == null ? 0 : this.yuB.getCount()) + 0;
        if (m23824NH(fromDPToPix)) {
            this.yuJ = MMGridPaper.m23827hg(fromDPToPix, fromDPToPix2);
            this.yuF = Math.min(this.yuJ - 1, MMGridPaper.m23828hh(this.yuE, fromDPToPix2));
            this.yuG = Math.min(3, this.yuJ);
            this.yuH = Math.min(this.yuJ - this.yuG, Math.max(0, this.yuF - (this.yuG >> 1)));
            this.yuI = (this.yuH + this.yuG) - 1;
            C4990ab.m7411d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", Integer.valueOf(this.yuO), Integer.valueOf(this.yuP), Integer.valueOf(this.f2983fW), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.yuG), Integer.valueOf(this.yuJ), Integer.valueOf(this.yuF), Integer.valueOf(this.yuH), Integer.valueOf(this.yuI));
            MMGridPaperGridView mMGridPaperGridView;
            if (this.yuA.getChildCount() == this.yuG && !this.yuK) {
                fromDPToPix = this.yuH;
                while (true) {
                    fromDPToPix2 = fromDPToPix;
                    if (fromDPToPix2 > this.yuI) {
                        break;
                    }
                    mMGridPaperGridView = (MMGridPaperGridView) this.yuA.getChildAt(fromDPToPix2 - this.yuH);
                    if (mMGridPaperGridView.getIndex() != fromDPToPix2) {
                        C4990ab.m7421w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", Integer.valueOf(mMGridPaperGridView.getIndex()), Integer.valueOf(fromDPToPix2));
                        mMGridPaperGridView.mo69945a(fromDPToPix2, this.f2983fW, this.mNumColumns, this.yuB);
                        mMGridPaperGridView.notifyDataSetChanged();
                    } else {
                        C4990ab.m7418v("MicroMsg.MMGridPaper", "same grid index, continus");
                    }
                    fromDPToPix = fromDPToPix2 + 1;
                }
            } else {
                C4990ab.m7421w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", Boolean.valueOf(this.yuK));
                this.yuK = false;
                this.yuA.removeAllViews();
                fromDPToPix = this.yuH;
                while (true) {
                    int i = fromDPToPix;
                    if (i > this.yuI) {
                        break;
                    }
                    mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.inflate(getContext(), 2130970110, null);
                    mMGridPaperGridView.mo69945a(i, this.f2983fW, this.mNumColumns, this.yuB);
                    mMGridPaperGridView.setHorizontalSpacing(C1338a.fromDPToPix(getContext(), this.ysw));
                    mMGridPaperGridView.setVerticalSpacing(C1338a.fromDPToPix(getContext(), this.ysx));
                    this.yuA.addView(mMGridPaperGridView, new LayoutParams(-1, -1));
                    fromDPToPix = i + 1;
                }
            }
            chL();
            AppMethodBeat.m2505o(106631);
            return;
        }
        dzK();
        AppMethodBeat.m2505o(106631);
    }

    /* renamed from: hg */
    private static int m23827hg(int i, int i2) {
        AppMethodBeat.m2504i(106632);
        if (i2 <= 0) {
            C4990ab.m7421w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(106632);
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 > 0) {
            i3 -= i2;
            i4++;
        }
        C4990ab.m7417i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        AppMethodBeat.m2505o(106632);
        return i4;
    }

    /* renamed from: hh */
    private static int m23828hh(int i, int i2) {
        AppMethodBeat.m2504i(106633);
        if (i == 0 || i2 <= 0) {
            C4990ab.m7421w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.m2505o(106633);
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 >= i2) {
            i3 -= i2;
            i4++;
        }
        C4990ab.m7417i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        AppMethodBeat.m2505o(106633);
        return i4;
    }

    private void chL() {
        AppMethodBeat.m2504i(106634);
        C4990ab.m7418v("MicroMsg.MMGridPaper", "set DotView");
        Assert.assertTrue(this.yuJ >= 0);
        this.jiG.setDotCount(this.yuJ);
        if (this.yuB == null || this.yuJ <= 1) {
            this.jiG.setVisibility(8);
            C4990ab.m7418v("MicroMsg.MMGridPaper", "set DotView gone");
        } else {
            this.jiG.setVisibility(0);
            C4990ab.m7418v("MicroMsg.MMGridPaper", "set DotView visible");
        }
        if (this.yuF >= this.yuJ) {
            this.yuF = this.yuJ - 1;
        }
        this.yuA.mo48692NF(this.yuF - this.yuH);
        this.yuA.mo48693NG(this.yuF);
        this.jiG.setSelectedDot(this.yuF);
        AppMethodBeat.m2505o(106634);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(106635);
        C4990ab.m7411d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.hiG != getScreenOrientation()) {
            this.hiG = getScreenOrientation();
            C4990ab.m7410d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
            this.yuQ = true;
            clearAnimation();
            dzK();
            dzL();
        }
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(106635);
    }

    @TargetApi(8)
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(106636);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            C4990ab.m7410d("MicroMsg.MMGridPaper", "onConfigChanged:" + configuration.orientation);
            this.yuQ = true;
        }
        AppMethodBeat.m2505o(106636);
    }

    private MMGridPaperGridView getCurrentPage() {
        AppMethodBeat.m2504i(106637);
        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.yuA.getChildAt(this.yuA.getCurScreen());
        AppMethodBeat.m2505o(106637);
        return mMGridPaperGridView;
    }

    /* renamed from: a */
    static /* synthetic */ void m23826a(MMGridPaper mMGridPaper, int i) {
        mMGridPaper.yuH += i;
        if (mMGridPaper.yuH < 0) {
            mMGridPaper.yuH = 0;
        } else if (mMGridPaper.yuH > mMGridPaper.yuJ - mMGridPaper.yuG) {
            mMGridPaper.yuH = mMGridPaper.yuJ - mMGridPaper.yuG;
        }
        mMGridPaper.yuI = (mMGridPaper.yuH + mMGridPaper.yuG) - 1;
    }
}
