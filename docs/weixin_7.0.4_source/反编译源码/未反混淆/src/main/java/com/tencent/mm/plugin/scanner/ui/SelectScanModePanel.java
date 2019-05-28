package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SelectScanModePanel extends LinearLayout {
    private static int qgy = 85;
    private static int qgz = 85;
    private Context context;
    private final int qgA = 0;
    private int qgB = 0;
    protected List<SelectScanModeGrid> qgC;
    private String[] qgD = new String[4];
    private int[] qgE = new int[]{R.drawable.bgm, R.drawable.bgi, R.drawable.bgo, R.raw.scan_translation};
    private int[] qgF = new int[]{R.drawable.bgn, R.drawable.bgj, R.drawable.bgp, R.raw.scan_translation_hl};
    private int[] qgG = new int[]{1, 2, 5, 3};
    private int[] qgH = new int[]{1, 2, 5, 3};
    private Set<Integer> qgI = new HashSet();
    private OnItemClickListener qgJ;
    private int qgK = 0;
    private boolean qgL = false;
    private int qgM;
    private int qgN;
    private MMFlipper qgO;
    private MMDotView qgP;
    private a qgQ;

    public interface a {
        void BX(int i);
    }

    static /* synthetic */ void c(SelectScanModePanel selectScanModePanel) {
        AppMethodBeat.i(81340);
        selectScanModePanel.chK();
        AppMethodBeat.o(81340);
    }

    public SelectScanModePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(81334);
        this.context = context;
        View.inflate(this.context, R.layout.aqz, this);
        this.qgP = (MMDotView) findViewById(R.id.e8k);
        this.qgD[0] = this.context.getString(R.string.dxn);
        this.qgD[1] = r.fT(r.qiS, this.context.getString(R.string.dxk));
        this.qgD[2] = this.context.getString(R.string.dxp);
        this.qgD[3] = this.context.getString(R.string.dxl);
        ab.v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
        this.qgO = (MMFlipper) findViewById(R.id.e8j);
        View findViewById = findViewById(R.id.e8i);
        LayoutParams layoutParams;
        if (this.context.getResources().getConfiguration().orientation == 2) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = b.b(this.context, (float) qgz);
            findViewById.setLayoutParams(layoutParams);
        } else {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = b.b(this.context, (float) qgy);
            findViewById.setLayoutParams(layoutParams);
        }
        this.qgO.removeAllViews();
        this.qgO.setOnMeasureListener(new com.tencent.mm.ui.base.MMFlipper.a() {
            public final void fe(int i, int i2) {
                AppMethodBeat.i(81331);
                ab.v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + SelectScanModePanel.this.qgL);
                if (SelectScanModePanel.this.qgL || i2 == 0 || i == 0) {
                    AppMethodBeat.o(81331);
                    return;
                }
                SelectScanModePanel.this.qgL = true;
                SelectScanModePanel.this.qgN = i2;
                SelectScanModePanel.this.qgM = i;
                SelectScanModePanel.c(SelectScanModePanel.this);
                AppMethodBeat.o(81331);
            }
        });
        this.qgO.setOnScreenChangedListener(new MMFlipper.b() {
            public final void BZ(int i) {
                AppMethodBeat.i(81332);
                SelectScanModePanel.this.qgP.setSelectedDot(i);
                AppMethodBeat.o(81332);
            }
        });
        AppMethodBeat.o(81334);
    }

    public void setOnGridItemClickCallback(a aVar) {
        this.qgQ = aVar;
    }

    public void setDisplayModes(int[] iArr) {
        AppMethodBeat.i(81335);
        this.qgH = iArr;
        chK();
        AppMethodBeat.o(81335);
    }

    public void setShowRedDotModes(Set<Integer> set) {
        AppMethodBeat.i(81336);
        if (set != null) {
            this.qgI.clear();
            this.qgI.addAll(set);
        }
        AppMethodBeat.o(81336);
    }

    public void setSelectedMode(int i) {
        AppMethodBeat.i(81337);
        this.qgB = BY(i);
        if (this.qgC != null) {
            for (int i2 = 0; i2 < this.qgC.size(); i2++) {
                com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a aVar = (com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a) ((SelectScanModeGrid) this.qgC.get(i2)).getAdapter();
                if (aVar != null) {
                    for (int i3 = 0; i3 < aVar.getCount(); i3++) {
                        SelectScanModeGrid.b bVar = (SelectScanModeGrid.b) aVar.getItem(i3);
                        if (!(bVar == null || bVar.qgw == null)) {
                            if (bVar.qgv == i) {
                                bVar.qgw.setBackgroundResource(bVar.qgu);
                                bVar.qgx = false;
                                if (i2 > 0) {
                                    this.qgO.setToScreen(i2);
                                    this.qgP.setSelectedDot(i2);
                                }
                            } else {
                                bVar.qgw.setBackgroundResource(bVar.qgt);
                            }
                        }
                    }
                    aVar.qgq = this.qgB;
                    aVar.notifyDataSetChanged();
                }
            }
        }
        AppMethodBeat.o(81337);
    }

    private int BY(int i) {
        for (int i2 = 0; i2 < this.qgG.length; i2++) {
            if (this.qgG[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    private void chK() {
        int i = 1;
        AppMethodBeat.i(81338);
        if (this.qgJ == null) {
            this.qgJ = new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    boolean z = true;
                    AppMethodBeat.i(81333);
                    if (adapterView == null || SelectScanModePanel.this.context == null) {
                        String str = "MicroMsg.scanner.SelectScanModePanel";
                        StringBuilder append = new StringBuilder("parent == null ? ").append(adapterView == null).append(", context == null ? ");
                        if (SelectScanModePanel.this.context != null) {
                            z = false;
                        }
                        ab.e(str, append.append(z).toString());
                        AppMethodBeat.o(81333);
                        return;
                    }
                    SelectScanModeGrid.b bVar = (SelectScanModeGrid.b) adapterView.getAdapter().getItem(i);
                    if (bVar == null) {
                        ab.e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
                        AppMethodBeat.o(81333);
                        return;
                    }
                    ((com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a) adapterView.getAdapter()).qgq = i;
                    ab.d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", Integer.valueOf(i), bVar.title);
                    if (!(SelectScanModePanel.this.qgQ == null || bVar == null)) {
                        SelectScanModePanel.this.qgQ.BX(bVar.qgv);
                    }
                    SelectScanModePanel.this.setSelectedMode(bVar.qgv);
                    AppMethodBeat.o(81333);
                }
            };
        }
        this.qgC = new ArrayList();
        if (this.qgM == 0 || this.qgN == 0) {
            AppMethodBeat.o(81338);
            return;
        }
        this.qgO.removeAllViews();
        int b = b.b(this.context, 64.0f);
        int i2 = this.qgM / b;
        b = this.qgN / b.b(this.context, 78.0f);
        if (i2 == 0) {
            i2 = 1;
        } else if (i2 > this.qgH.length) {
            i2 = this.qgH.length;
        }
        if (b != 0) {
            i = b;
        }
        int i3 = i2 * i;
        this.qgK = 0;
        i = 4;
        while (i > 0) {
            i -= i3;
            this.qgK++;
        }
        for (int i4 = 0; i4 < this.qgK; i4++) {
            ArrayList arrayList = new ArrayList();
            int i5 = i4 * i3;
            int i6 = i5;
            while (i6 < this.qgH.length && i6 < i5 + i3) {
                i2 = BY(this.qgH[i6]);
                arrayList.add(new SelectScanModeGrid.b(this.qgD[i2], this.qgE[i2], this.qgF[i2], this.qgH[i6], this.qgI.contains(Integer.valueOf(this.qgH[i6]))));
                i6++;
            }
            if (arrayList.size() > 0) {
                SelectScanModeGrid selectScanModeGrid = (SelectScanModeGrid) inflate(this.context, R.layout.aqx, null);
                selectScanModeGrid.setNumColumns(i3);
                com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a aVar = new com.tencent.mm.plugin.scanner.ui.SelectScanModeGrid.a(this.context, arrayList);
                aVar.qgq = this.qgB;
                selectScanModeGrid.setAdapter(aVar);
                this.qgO.addView(selectScanModeGrid, new LayoutParams(-1, -1));
                selectScanModeGrid.setOnItemClickListener(this.qgJ);
                this.qgC.add(selectScanModeGrid);
            }
        }
        chL();
        AppMethodBeat.o(81338);
    }

    private void chL() {
        AppMethodBeat.i(81339);
        if (this.qgC.size() <= 1) {
            this.qgP.setVisibility(4);
            AppMethodBeat.o(81339);
            return;
        }
        this.qgP.setVisibility(0);
        this.qgP.setDotCount(this.qgC.size());
        int curScreen = this.qgO.getCurScreen();
        this.qgO.setToScreen(curScreen);
        this.qgP.setSelectedDot(curScreen);
        AppMethodBeat.o(81339);
    }
}
