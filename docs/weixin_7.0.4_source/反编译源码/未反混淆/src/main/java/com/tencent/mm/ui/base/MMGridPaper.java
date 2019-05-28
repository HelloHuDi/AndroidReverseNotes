package com.tencent.mm.ui.base;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MMFlipper.b;
import junit.framework.Assert;

public final class MMGridPaper extends LinearLayout {
    protected View abB;
    protected int fS = -1;
    protected int fW = 0;
    protected int fX = -1;
    protected int hiG = 0;
    protected MMDotView jiG;
    protected int mNumColumns = 0;
    protected ak mty = new ak(Looper.getMainLooper());
    protected int ysw = 10;
    protected int ysx = 10;
    protected MMFlipper yuA;
    protected j yuB;
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
    protected a yuX;
    final b yuf = new b() {
        public final void BZ(final int i) {
            AppMethodBeat.i(106622);
            ab.d("MicroMsg.MMGridPaper", "onScreenChanged:curScreen[%d], topEdge[%d], bottomEdge[%d], virtualPage[%d]", Integer.valueOf(i), Integer.valueOf(MMGridPaper.this.yuH), Integer.valueOf(MMGridPaper.this.yuI), Integer.valueOf(MMGridPaper.this.yuJ));
            if (i <= MMGridPaper.this.yuH && MMGridPaper.this.yuH > 0) {
                MMGridPaper.this.mty.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(106620);
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.this.yuA.getChildAt(MMGridPaper.this.yuA.getChildCount() - 1);
                        ab.i("MicroMsg.MMGridPaper", "move up, old index[%d], new index[%d]", Integer.valueOf(MMGridPaper.this.yuA.getChildCount() - 1), Integer.valueOf(i - (MMGridPaper.this.yuA.getChildCount() >> 1)));
                        MMGridPaper.this.yuA.removeViewAt(MMGridPaper.this.yuA.getChildCount() - 1);
                        mMGridPaperGridView.a(r1, MMGridPaper.this.fW, MMGridPaper.this.mNumColumns, MMGridPaper.this.yuB);
                        MMGridPaper.this.yuA.addView(mMGridPaperGridView, 0);
                        MMGridPaper.this.yuA.NF(MMGridPaper.this.yuA.getChildCount() >> 1);
                        MMGridPaper.a(MMGridPaper.this, -1);
                        AppMethodBeat.o(106620);
                    }
                });
            } else if (i >= MMGridPaper.this.yuI && MMGridPaper.this.yuI < MMGridPaper.this.yuJ - 1) {
                MMGridPaper.this.mty.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(106621);
                        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) MMGridPaper.this.yuA.getChildAt(0);
                        ab.i("MicroMsg.MMGridPaper", "move down, old index[0], new index[%d]", Integer.valueOf(i + (MMGridPaper.this.yuA.getChildCount() >> 1)));
                        MMGridPaper.this.yuA.removeViewAt(0);
                        mMGridPaperGridView.a(r1, MMGridPaper.this.fW, MMGridPaper.this.mNumColumns, MMGridPaper.this.yuB);
                        MMGridPaper.this.yuA.addView(mMGridPaperGridView);
                        MMGridPaper.this.yuA.NF(MMGridPaper.this.yuA.getChildCount() >> 1);
                        MMGridPaper.a(MMGridPaper.this, 1);
                        AppMethodBeat.o(106621);
                    }
                });
            }
            MMGridPaper.this.yuF = i;
            MMGridPaper.this.jiG.setSelectedDot(i);
            AppMethodBeat.o(106622);
        }
    };
    final com.tencent.mm.ui.base.MMFlipper.a yug = new com.tencent.mm.ui.base.MMFlipper.a() {
        public final void fe(int i, int i2) {
            AppMethodBeat.i(106619);
            ab.v("MicroMsg.MMGridPaper", "onMeasure width:[new %d, old %d] height:[new %d, old %d], dialogMode[%B], orientationChange[%B]", Integer.valueOf(i), Integer.valueOf(MMGridPaper.this.yuC), Integer.valueOf(i2), Integer.valueOf(MMGridPaper.this.yuD), Boolean.valueOf(MMGridPaper.this.yuR), Boolean.valueOf(MMGridPaper.this.yuQ));
            if ((Math.abs(MMGridPaper.this.yuD - i2) < 50 && Math.abs(MMGridPaper.this.yuC - i) < 50) || i2 == 0 || i == 0) {
                ab.d("MicroMsg.MMGridPaper", "match width height limit, return");
                AppMethodBeat.o(106619);
            } else if (!MMGridPaper.this.yuR || MMGridPaper.this.yuC <= i || MMGridPaper.this.yuQ) {
                ab.v("MicroMsg.MMGridPaper", "onMeasure: match");
                ab.v("MicroMsg.MMGridPaper", "onMeasure: mIsManualMeasureMode[%b]", Boolean.valueOf(MMGridPaper.this.yuU));
                MMGridPaper.this.yuQ = false;
                if (!MMGridPaper.this.yuU) {
                    MMGridPaper.this.yuD = i2;
                    MMGridPaper.this.yuC = i;
                }
                MMGridPaper.this.refresh();
                AppMethodBeat.o(106619);
            } else {
                ab.d("MicroMsg.MMGridPaper", "match ori limit, return");
                AppMethodBeat.o(106619);
            }
        }
    };

    public interface a {
    }

    static /* synthetic */ void a(MMGridPaper mMGridPaper) {
        AppMethodBeat.i(106638);
        mMGridPaper.chL();
        AppMethodBeat.o(106638);
    }

    public MMGridPaper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106623);
        View.inflate(getContext(), R.layout.adw, this);
        this.hiG = getScreenOrientation();
        AppMethodBeat.o(106623);
    }

    public final void setOnPageSizeChangeListener(a aVar) {
        this.yuX = aVar;
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
        this.fX = i;
    }

    public final void setMaxCol(int i) {
        this.fS = i;
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
        AppMethodBeat.i(106624);
        this.abB = view;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.mr);
        viewGroup.removeAllViews();
        if (this.abB != null) {
            viewGroup.addView(this.abB);
        }
        AppMethodBeat.o(106624);
    }

    public final void setGridPaperAdapter(j jVar) {
        boolean z = true;
        AppMethodBeat.i(106625);
        this.yuB = jVar;
        String str = "MicroMsg.MMGridPaper";
        String str2 = "setGridPaperAdapter:adapter is null[%B]";
        Object[] objArr = new Object[1];
        if (jVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        ab.d(str, str2, objArr);
        if (this.yuB != null) {
            this.yuB.yvb = new com.tencent.mm.ui.base.j.a() {
                public final void aWv() {
                    AppMethodBeat.i(106616);
                    MMGridPaper.this.refresh();
                    AppMethodBeat.o(106616);
                }
            };
        }
        djR();
        AppMethodBeat.o(106625);
    }

    public final void refresh() {
        AppMethodBeat.i(106626);
        this.yuE = (this.yuF * this.mNumColumns) * this.fW;
        ab.v("MicroMsg.MMGridPaper", "refreshed:virtualPage[%d], col[%d], row[%d], scrollCount[%d]", Integer.valueOf(this.yuF), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.fW), Integer.valueOf(this.yuE));
        djR();
        AppMethodBeat.o(106626);
    }

    public final int getPageCount() {
        return this.yuJ;
    }

    public final int getItemsCountPerPage() {
        return this.fW * this.mNumColumns;
    }

    private int getScreenOrientation() {
        int i;
        AppMethodBeat.i(106627);
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay.getWidth() < defaultDisplay.getHeight()) {
            i = 1;
        } else {
            i = 2;
        }
        AppMethodBeat.o(106627);
        return i;
    }

    private void dzK() {
        AppMethodBeat.i(106628);
        View findViewById;
        LayoutParams layoutParams;
        int fromDPToPix;
        if (-1 == this.yuM || getScreenOrientation() != 2) {
            if (-1 != this.yuN && getScreenOrientation() == 1) {
                findViewById = findViewById(R.id.d9j);
                layoutParams = (LayoutParams) findViewById.getLayoutParams();
                fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), this.yuN);
                if (fromDPToPix != layoutParams.height) {
                    ab.i("MicroMsg.MMGridPaper", "set port mode, special height is %d", Integer.valueOf(this.yuN));
                    layoutParams.height = fromDPToPix;
                    findViewById.setLayoutParams(layoutParams);
                    this.mty.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(106618);
                            ab.w("MicroMsg.MMGridPaper", "post do setDotView");
                            MMGridPaper.a(MMGridPaper.this);
                            AppMethodBeat.o(106618);
                        }
                    });
                }
            }
            AppMethodBeat.o(106628);
            return;
        }
        findViewById = findViewById(R.id.d9j);
        layoutParams = (LayoutParams) findViewById.getLayoutParams();
        fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), this.yuM);
        if (fromDPToPix != layoutParams.height) {
            ab.i("MicroMsg.MMGridPaper", "set land mode, special height is %d", Integer.valueOf(this.yuM));
            layoutParams.height = fromDPToPix;
            findViewById.setLayoutParams(layoutParams);
            this.mty.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(106617);
                    ab.w("MicroMsg.MMGridPaper", "post do setDotView");
                    MMGridPaper.a(MMGridPaper.this);
                    AppMethodBeat.o(106617);
                }
            });
        }
        AppMethodBeat.o(106628);
    }

    private void djR() {
        AppMethodBeat.i(106629);
        ab.v("MicroMsg.MMGridPaper", "MMGridPaper initFlipper");
        if (this.jiG == null) {
            this.jiG = (MMDotView) findViewById(R.id.d9l);
            this.jiG.setMaxCount(this.yuL);
        }
        if (this.yuA == null) {
            this.yuA = (MMFlipper) findViewById(R.id.d9k);
            this.yuA.setOnMeasureListener(this.yug);
            this.yuA.setOnScreenChangedListener(this.yuf);
        }
        dzK();
        dzL();
        AppMethodBeat.o(106629);
    }

    private boolean NH(int i) {
        AppMethodBeat.i(106630);
        ab.d("MicroMsg.MMGridPaper", "totalCount is %d, dialogMode is %B", Integer.valueOf(i), Boolean.valueOf(this.yuR));
        Assert.assertTrue(i >= 0);
        if (this.yuR) {
            int hg = hg(i, this.mNumColumns);
            int min;
            switch (getScreenOrientation()) {
                case 1:
                    min = ((this.yuP + 10) * Math.min(hg, this.yuS)) + 8;
                    ab.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(getScreenOrientation()), Integer.valueOf(Math.min(hg, this.yuS)), Integer.valueOf(min), Integer.valueOf(this.yuN), Boolean.valueOf(this.yuQ));
                    if (this.yuN != min) {
                        this.yuN = min;
                        AppMethodBeat.o(106630);
                        return false;
                    }
                    AppMethodBeat.o(106630);
                    return true;
                case 2:
                    min = ((this.yuP + 10) * Math.min(hg, this.yuT)) + 8;
                    ab.d("MicroMsg.MMGridPaper", "orientation[%d], minRows[%d], targetHeight[%d], displayHeight[%d], orientationChange[%B]", Integer.valueOf(getScreenOrientation()), Integer.valueOf(Math.min(hg, this.yuT)), Integer.valueOf(min), Integer.valueOf(this.yuM), Boolean.valueOf(this.yuQ));
                    if (this.yuM != min) {
                        this.yuM = min;
                        AppMethodBeat.o(106630);
                        return false;
                    }
                    AppMethodBeat.o(106630);
                    return true;
                default:
                    AppMethodBeat.o(106630);
                    return true;
            }
        }
        AppMethodBeat.o(106630);
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
        AppMethodBeat.i(106631);
        ab.v("MicroMsg.MMGridPaper", "initSubGrid, grid width %d, grid height %d", Integer.valueOf(this.yuC), Integer.valueOf(this.yuD));
        if (this.yuC == 0 || this.yuD == 0) {
            ab.w("MicroMsg.MMGridPaper", "initSubGrid:gridWithd or gridHeight is 0");
            AppMethodBeat.o(106631);
            return;
        }
        int fromDPToPix = com.tencent.mm.bz.a.fromDPToPix(getContext(), this.yuO);
        int fromDPToPix2 = com.tencent.mm.bz.a.fromDPToPix(getContext(), this.yuP);
        fromDPToPix = Math.max(this.yuC / fromDPToPix, 1);
        fromDPToPix2 = Math.max(this.yuD / fromDPToPix2, 1);
        if (!(fromDPToPix == this.mNumColumns && fromDPToPix2 == this.fW)) {
            this.yuK = true;
        }
        this.mNumColumns = fromDPToPix;
        if (this.fS != -1) {
            this.mNumColumns = Math.min(this.mNumColumns, this.fS);
        }
        this.fW = fromDPToPix2;
        if (this.fX != -1) {
            this.fW = Math.min(this.fW, this.fX);
        }
        fromDPToPix2 = this.fW * this.mNumColumns;
        this.yuJ = 0;
        fromDPToPix = (this.yuB == null ? 0 : this.yuB.getCount()) + 0;
        if (NH(fromDPToPix)) {
            this.yuJ = hg(fromDPToPix, fromDPToPix2);
            this.yuF = Math.min(this.yuJ - 1, hh(this.yuE, fromDPToPix2));
            this.yuG = Math.min(3, this.yuJ);
            this.yuH = Math.min(this.yuJ - this.yuG, Math.max(0, this.yuF - (this.yuG >> 1)));
            this.yuI = (this.yuH + this.yuG) - 1;
            ab.d("MicroMsg.MMGridPaper", "initSubGrid:item[%ddp,%ddp], row[%d], column[%d], activePage[%d], virtualPage[%d], curVirtualPage[%d], edge[%d, %d]", Integer.valueOf(this.yuO), Integer.valueOf(this.yuP), Integer.valueOf(this.fW), Integer.valueOf(this.mNumColumns), Integer.valueOf(this.yuG), Integer.valueOf(this.yuJ), Integer.valueOf(this.yuF), Integer.valueOf(this.yuH), Integer.valueOf(this.yuI));
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
                        ab.w("MicroMsg.MMGridPaper", "old index %d, new index %d, reset it", Integer.valueOf(mMGridPaperGridView.getIndex()), Integer.valueOf(fromDPToPix2));
                        mMGridPaperGridView.a(fromDPToPix2, this.fW, this.mNumColumns, this.yuB);
                        mMGridPaperGridView.notifyDataSetChanged();
                    } else {
                        ab.v("MicroMsg.MMGridPaper", "same grid index, continus");
                    }
                    fromDPToPix = fromDPToPix2 + 1;
                }
            } else {
                ab.w("MicroMsg.MMGridPaper", "error child count or RowOrColChanged(%B), reset child view", Boolean.valueOf(this.yuK));
                this.yuK = false;
                this.yuA.removeAllViews();
                fromDPToPix = this.yuH;
                while (true) {
                    int i = fromDPToPix;
                    if (i > this.yuI) {
                        break;
                    }
                    mMGridPaperGridView = (MMGridPaperGridView) inflate(getContext(), R.layout.adn, null);
                    mMGridPaperGridView.a(i, this.fW, this.mNumColumns, this.yuB);
                    mMGridPaperGridView.setHorizontalSpacing(com.tencent.mm.bz.a.fromDPToPix(getContext(), this.ysw));
                    mMGridPaperGridView.setVerticalSpacing(com.tencent.mm.bz.a.fromDPToPix(getContext(), this.ysx));
                    this.yuA.addView(mMGridPaperGridView, new LayoutParams(-1, -1));
                    fromDPToPix = i + 1;
                }
            }
            chL();
            AppMethodBeat.o(106631);
            return;
        }
        dzK();
        AppMethodBeat.o(106631);
    }

    private static int hg(int i, int i2) {
        AppMethodBeat.i(106632);
        if (i2 <= 0) {
            ab.w("MicroMsg.MMGridPaper", "ceil:total[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(106632);
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 > 0) {
            i3 -= i2;
            i4++;
        }
        ab.i("MicroMsg.MMGridPaper", "ceil:num[%d], length[%d], result[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        AppMethodBeat.o(106632);
        return i4;
    }

    private static int hh(int i, int i2) {
        AppMethodBeat.i(106633);
        if (i == 0 || i2 <= 0) {
            ab.w("MicroMsg.MMGridPaper", "floor:total[%d], length[%d]", Integer.valueOf(i), Integer.valueOf(i2));
            AppMethodBeat.o(106633);
            return 0;
        }
        int i3 = i;
        int i4 = 0;
        while (i3 >= i2) {
            i3 -= i2;
            i4++;
        }
        ab.i("MicroMsg.MMGridPaper", "floor:num[%d], length[%d], result[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
        AppMethodBeat.o(106633);
        return i4;
    }

    private void chL() {
        AppMethodBeat.i(106634);
        ab.v("MicroMsg.MMGridPaper", "set DotView");
        Assert.assertTrue(this.yuJ >= 0);
        this.jiG.setDotCount(this.yuJ);
        if (this.yuB == null || this.yuJ <= 1) {
            this.jiG.setVisibility(8);
            ab.v("MicroMsg.MMGridPaper", "set DotView gone");
        } else {
            this.jiG.setVisibility(0);
            ab.v("MicroMsg.MMGridPaper", "set DotView visible");
        }
        if (this.yuF >= this.yuJ) {
            this.yuF = this.yuJ - 1;
        }
        this.yuA.NF(this.yuF - this.yuH);
        this.yuA.NG(this.yuF);
        this.jiG.setSelectedDot(this.yuF);
        AppMethodBeat.o(106634);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106635);
        ab.d("MicroMsg.MMGridPaper", "onLayout left=%s top=%s right=%s bottom=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (this.hiG != getScreenOrientation()) {
            this.hiG = getScreenOrientation();
            ab.d("MicroMsg.MMGridPaper", "onLayout, currentOrientation changed, reAdjustDisplayArea");
            this.yuQ = true;
            clearAnimation();
            dzK();
            dzL();
        }
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(106635);
    }

    @TargetApi(8)
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(106636);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            ab.d("MicroMsg.MMGridPaper", "onConfigChanged:" + configuration.orientation);
            this.yuQ = true;
        }
        AppMethodBeat.o(106636);
    }

    private MMGridPaperGridView getCurrentPage() {
        AppMethodBeat.i(106637);
        MMGridPaperGridView mMGridPaperGridView = (MMGridPaperGridView) this.yuA.getChildAt(this.yuA.getCurScreen());
        AppMethodBeat.o(106637);
        return mMGridPaperGridView;
    }

    static /* synthetic */ void a(MMGridPaper mMGridPaper, int i) {
        mMGridPaper.yuH += i;
        if (mMGridPaper.yuH < 0) {
            mMGridPaper.yuH = 0;
        } else if (mMGridPaper.yuH > mMGridPaper.yuJ - mMGridPaper.yuG) {
            mMGridPaper.yuH = mMGridPaper.yuJ - mMGridPaper.yuG;
        }
        mMGridPaper.yuI = (mMGridPaper.yuH + mMGridPaper.yuG) - 1;
    }
}
