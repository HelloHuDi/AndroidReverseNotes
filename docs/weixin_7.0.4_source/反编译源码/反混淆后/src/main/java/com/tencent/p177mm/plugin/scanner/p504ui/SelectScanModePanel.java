package com.tencent.p177mm.plugin.scanner.p504ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.p612ui.base.MMDotView;
import com.tencent.p177mm.p612ui.base.MMFlipper;
import com.tencent.p177mm.p612ui.base.MMFlipper.C5250a;
import com.tencent.p177mm.p612ui.base.MMFlipper.C5251b;
import com.tencent.p177mm.plugin.scanner.p504ui.SelectScanModeGrid.C13147a;
import com.tencent.p177mm.plugin.scanner.p504ui.SelectScanModeGrid.C13149b;
import com.tencent.p177mm.plugin.scanner.util.C28923r;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModePanel */
public class SelectScanModePanel extends LinearLayout {
    private static int qgy = 85;
    private static int qgz = 85;
    private Context context;
    private final int qgA = 0;
    private int qgB = 0;
    protected List<SelectScanModeGrid> qgC;
    private String[] qgD = new String[4];
    private int[] qgE = new int[]{C25738R.drawable.bgm, C25738R.drawable.bgi, C25738R.drawable.bgo, C1318a.scan_translation};
    private int[] qgF = new int[]{C25738R.drawable.bgn, C25738R.drawable.bgj, C25738R.drawable.bgp, C1318a.scan_translation_hl};
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
    private C28912a qgQ;

    /* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModePanel$3 */
    class C289113 implements OnItemClickListener {
        C289113() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            boolean z = true;
            AppMethodBeat.m2504i(81333);
            if (adapterView == null || SelectScanModePanel.this.context == null) {
                String str = "MicroMsg.scanner.SelectScanModePanel";
                StringBuilder append = new StringBuilder("parent == null ? ").append(adapterView == null).append(", context == null ? ");
                if (SelectScanModePanel.this.context != null) {
                    z = false;
                }
                C4990ab.m7412e(str, append.append(z).toString());
                AppMethodBeat.m2505o(81333);
                return;
            }
            C13149b c13149b = (C13149b) adapterView.getAdapter().getItem(i);
            if (c13149b == null) {
                C4990ab.m7412e("MicroMsg.scanner.SelectScanModePanel", "clickItem == null");
                AppMethodBeat.m2505o(81333);
                return;
            }
            ((C13147a) adapterView.getAdapter()).qgq = i;
            C4990ab.m7411d("MicroMsg.scanner.SelectScanModePanel", "position=[%s], clickItem=[%s]", Integer.valueOf(i), c13149b.title);
            if (!(SelectScanModePanel.this.qgQ == null || c13149b == null)) {
                SelectScanModePanel.this.qgQ.mo47027BX(c13149b.qgv);
            }
            SelectScanModePanel.this.setSelectedMode(c13149b.qgv);
            AppMethodBeat.m2505o(81333);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModePanel$a */
    public interface C28912a {
        /* renamed from: BX */
        void mo47027BX(int i);
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModePanel$2 */
    class C396312 implements C5251b {
        C396312() {
        }

        /* renamed from: BZ */
        public final void mo10770BZ(int i) {
            AppMethodBeat.m2504i(81332);
            SelectScanModePanel.this.qgP.setSelectedDot(i);
            AppMethodBeat.m2505o(81332);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.ui.SelectScanModePanel$1 */
    class C461851 implements C5250a {
        C461851() {
        }

        /* renamed from: fe */
        public final void mo10769fe(int i, int i2) {
            AppMethodBeat.m2504i(81331);
            C4990ab.m7418v("MicroMsg.scanner.SelectScanModePanel", "onMeasure width:" + i + " height:" + i2 + " isMeasured:" + SelectScanModePanel.this.qgL);
            if (SelectScanModePanel.this.qgL || i2 == 0 || i == 0) {
                AppMethodBeat.m2505o(81331);
                return;
            }
            SelectScanModePanel.this.qgL = true;
            SelectScanModePanel.this.qgN = i2;
            SelectScanModePanel.this.qgM = i;
            SelectScanModePanel.m86333c(SelectScanModePanel.this);
            AppMethodBeat.m2505o(81331);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m86333c(SelectScanModePanel selectScanModePanel) {
        AppMethodBeat.m2504i(81340);
        selectScanModePanel.chK();
        AppMethodBeat.m2505o(81340);
    }

    public SelectScanModePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(81334);
        this.context = context;
        View.inflate(this.context, 2130970604, this);
        this.qgP = (MMDotView) findViewById(2131827335);
        this.qgD[0] = this.context.getString(C25738R.string.dxn);
        this.qgD[1] = C28923r.m45946fT(C28923r.qiS, this.context.getString(C25738R.string.dxk));
        this.qgD[2] = this.context.getString(C25738R.string.dxp);
        this.qgD[3] = this.context.getString(C25738R.string.dxl);
        C4990ab.m7418v("MicroMsg.scanner.SelectScanModePanel", "AppPanel initFlipper");
        this.qgO = (MMFlipper) findViewById(2131827334);
        View findViewById = findViewById(2131827333);
        LayoutParams layoutParams;
        if (this.context.getResources().getConfiguration().orientation == 2) {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = C4977b.m7371b(this.context, (float) qgz);
            findViewById.setLayoutParams(layoutParams);
        } else {
            layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.height = C4977b.m7371b(this.context, (float) qgy);
            findViewById.setLayoutParams(layoutParams);
        }
        this.qgO.removeAllViews();
        this.qgO.setOnMeasureListener(new C461851());
        this.qgO.setOnScreenChangedListener(new C396312());
        AppMethodBeat.m2505o(81334);
    }

    public void setOnGridItemClickCallback(C28912a c28912a) {
        this.qgQ = c28912a;
    }

    public void setDisplayModes(int[] iArr) {
        AppMethodBeat.m2504i(81335);
        this.qgH = iArr;
        chK();
        AppMethodBeat.m2505o(81335);
    }

    public void setShowRedDotModes(Set<Integer> set) {
        AppMethodBeat.m2504i(81336);
        if (set != null) {
            this.qgI.clear();
            this.qgI.addAll(set);
        }
        AppMethodBeat.m2505o(81336);
    }

    public void setSelectedMode(int i) {
        AppMethodBeat.m2504i(81337);
        this.qgB = m86328BY(i);
        if (this.qgC != null) {
            for (int i2 = 0; i2 < this.qgC.size(); i2++) {
                C13147a c13147a = (C13147a) ((SelectScanModeGrid) this.qgC.get(i2)).getAdapter();
                if (c13147a != null) {
                    for (int i3 = 0; i3 < c13147a.getCount(); i3++) {
                        C13149b c13149b = (C13149b) c13147a.getItem(i3);
                        if (!(c13149b == null || c13149b.qgw == null)) {
                            if (c13149b.qgv == i) {
                                c13149b.qgw.setBackgroundResource(c13149b.qgu);
                                c13149b.qgx = false;
                                if (i2 > 0) {
                                    this.qgO.setToScreen(i2);
                                    this.qgP.setSelectedDot(i2);
                                }
                            } else {
                                c13149b.qgw.setBackgroundResource(c13149b.qgt);
                            }
                        }
                    }
                    c13147a.qgq = this.qgB;
                    c13147a.notifyDataSetChanged();
                }
            }
        }
        AppMethodBeat.m2505o(81337);
    }

    /* renamed from: BY */
    private int m86328BY(int i) {
        for (int i2 = 0; i2 < this.qgG.length; i2++) {
            if (this.qgG[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    private void chK() {
        int i = 1;
        AppMethodBeat.m2504i(81338);
        if (this.qgJ == null) {
            this.qgJ = new C289113();
        }
        this.qgC = new ArrayList();
        if (this.qgM == 0 || this.qgN == 0) {
            AppMethodBeat.m2505o(81338);
            return;
        }
        this.qgO.removeAllViews();
        int b = C4977b.m7371b(this.context, 64.0f);
        int i2 = this.qgM / b;
        b = this.qgN / C4977b.m7371b(this.context, 78.0f);
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
                i2 = m86328BY(this.qgH[i6]);
                arrayList.add(new C13149b(this.qgD[i2], this.qgE[i2], this.qgF[i2], this.qgH[i6], this.qgI.contains(Integer.valueOf(this.qgH[i6]))));
                i6++;
            }
            if (arrayList.size() > 0) {
                SelectScanModeGrid selectScanModeGrid = (SelectScanModeGrid) SelectScanModePanel.inflate(this.context, 2130970602, null);
                selectScanModeGrid.setNumColumns(i3);
                C13147a c13147a = new C13147a(this.context, arrayList);
                c13147a.qgq = this.qgB;
                selectScanModeGrid.setAdapter(c13147a);
                this.qgO.addView(selectScanModeGrid, new LayoutParams(-1, -1));
                selectScanModeGrid.setOnItemClickListener(this.qgJ);
                this.qgC.add(selectScanModeGrid);
            }
        }
        chL();
        AppMethodBeat.m2505o(81338);
    }

    private void chL() {
        AppMethodBeat.m2504i(81339);
        if (this.qgC.size() <= 1) {
            this.qgP.setVisibility(4);
            AppMethodBeat.m2505o(81339);
            return;
        }
        this.qgP.setVisibility(0);
        this.qgP.setDotCount(this.qgC.size());
        int curScreen = this.qgO.getCurScreen();
        this.qgO.setToScreen(curScreen);
        this.qgP.setSelectedDot(curScreen);
        AppMethodBeat.m2505o(81339);
    }
}
