package com.tencent.p177mm.p612ui;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C46630aa.C23573b;
import com.tencent.p177mm.p612ui.C46630aa.C30356c;
import com.tencent.p177mm.p612ui.C46630aa.C40658d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.tencent.mm.ui.z */
public final class C44408z {
    private static C44408z ypB = null;
    private long timestamp = 0;
    int ypC = 0;
    private SparseIntArray ypD = new SparseIntArray();
    private SparseArray<C23573b> ypE = new SparseArray();
    private ArrayList<Integer> ypF = new ArrayList();
    public SparseArray<C30356c> ypG = new SparseArray();
    private boolean ypH = false;

    public C44408z() {
        AppMethodBeat.m2504i(29833);
        AppMethodBeat.m2505o(29833);
    }

    public static C44408z dyZ() {
        AppMethodBeat.m2504i(29834);
        if (ypB == null) {
            ypB = new C44408z();
        }
        C44408z c44408z = ypB;
        AppMethodBeat.m2505o(29834);
        return c44408z;
    }

    /* renamed from: Nt */
    public final void mo70295Nt(int i) {
        AppMethodBeat.m2504i(29835);
        if (this.ypE.size() != 0) {
            C23573b c23573b = (C23573b) this.ypE.get(i);
            if (c23573b != null && c23573b.ypM == 1) {
                this.ypD.put(c23573b.f4422id, c23573b.fQi);
                this.ypC--;
                if (this.ypH) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (int i2 = 0; i2 < this.ypD.size(); i2++) {
                        int keyAt = this.ypD.keyAt(i2);
                        Integer valueOf = Integer.valueOf(this.ypD.get(keyAt));
                        stringBuffer.append(keyAt);
                        stringBuffer.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        stringBuffer.append(valueOf);
                        stringBuffer.append("|");
                    }
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(299010, stringBuffer.toString());
                }
            }
        }
        AppMethodBeat.m2505o(29835);
    }

    /* renamed from: pX */
    private void m80272pX(boolean z) {
        AppMethodBeat.m2504i(29836);
        if (!z) {
            int i;
            if (this.ypE.size() == 0 || System.currentTimeMillis() - this.timestamp > 3600000) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                AppMethodBeat.m2505o(29836);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.PlusMenaDataManager", "dynaConfigs size %d", Integer.valueOf(C26373g.m41964Nu().mo5309kC("TopRightMenu\\d*").size()));
        synchronized (this) {
            try {
                String value;
                int ank;
                this.ypE.clear();
                this.ypF.clear();
                for (String value2 : r0) {
                    Map z2 = C5049br.m7595z(value2, "Menu");
                    if (!(z2 == null || z2.size() == 0)) {
                        ank = C5046bo.ank((String) z2.get(".Menu.$id"));
                        int ank2 = C5046bo.ank((String) z2.get(".Menu.$shownew"));
                        int ank3 = C5046bo.ank((String) z2.get(".Menu.$seq"));
                        int ank4 = C5046bo.ank((String) z2.get(".Menu.$order"));
                        this.ypE.put(ank, new C23573b(ank, ank2, ank3, ank4));
                        int i2 = 0;
                        while (i2 < this.ypF.size() && ((C23573b) this.ypE.get(((Integer) this.ypF.get(i2)).intValue())).order <= ank4) {
                            i2++;
                        }
                        this.ypF.add(i2, Integer.valueOf(ank));
                    }
                }
                C4990ab.m7417i("MicroMsg.PlusMenaDataManager", "dynaMenuOrder size %d", Integer.valueOf(this.ypF.size()));
                if (this.ypF.size() == 0) {
                    this.ypE.clear();
                    this.ypF.clear();
                    value2 = C26373g.m41964Nu().getValue("TopRightMenus");
                    if (!C5046bo.isNullOrNil(value2)) {
                        Map z3 = C5049br.m7595z(value2, "TopRightMenus");
                        if (z3 != null) {
                            ank = 0;
                            while (ank < 100) {
                                String str = ".TopRightMenus.Menu" + (ank == 0 ? "" : Integer.valueOf(ank));
                                value2 = (String) z3.get(str + ".$id");
                                if (value2 == null || C5046bo.isNullOrNil(value2)) {
                                    break;
                                }
                                C4990ab.m7411d("MicroMsg.PlusMenaDataManager", "got plus panel configs : %s %s %s", value2, (String) z3.get(str + ".$shownew"), (String) z3.get(str + ".$seq"));
                                this.ypE.put(C5046bo.ank(value2), new C23573b(C5046bo.ank(value2), C5046bo.ank(r1), C5046bo.ank(str)));
                                this.ypF.add(Integer.valueOf(C5046bo.ank(value2)));
                                ank++;
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.PlusMenaDataManager", "TopRightMenus is not right");
                        }
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(29836);
            }
        }
        if (this.ypE.size() != 0) {
            dza();
        }
        this.timestamp = System.currentTimeMillis();
        C4990ab.m7411d("MicroMsg.PlusMenaDataManager", " plus menu load data spent time : %s", Long.valueOf(this.timestamp - currentTimeMillis));
        AppMethodBeat.m2505o(29836);
    }

    /* renamed from: pY */
    public final void mo70296pY(boolean z) {
        AppMethodBeat.m2504i(29837);
        try {
            m80272pX(z);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.PlusMenaDataManager", e, "", new Object[0]);
        }
        this.ypG.clear();
        this.ypC = 0;
        int i = 0;
        for (int i2 = 0; i2 < this.ypF.size(); i2++) {
            int intValue = ((Integer) this.ypF.get(i2)).intValue();
            C23573b c23573b = (C23573b) this.ypE.get(intValue);
            C40658d Nu = C46630aa.m88223Nu(intValue);
            if (Nu != null) {
                C30356c c30356c = new C30356c(Nu);
                this.ypG.put(i, c30356c);
                int i3 = this.ypD.get(intValue);
                if ((c23573b.ypM == 1 && i3 != c23573b.fQi) || (intValue == 20 && C16112c.m24429PK().mo28552bY(262159, 266248))) {
                    c30356c.ypO = true;
                    this.ypC++;
                }
                i++;
            }
        }
        C4990ab.m7417i("MicroMsg.PlusMenaDataManager", "dynaMenuOrder.size() %s menuDataMap.size() %s", Integer.valueOf(this.ypF.size()), Integer.valueOf(this.ypG.size()));
        if (C5059g.dnZ()) {
            this.ypG.put(i, new C30356c(C46630aa.m88223Nu(2147483645)));
            AppMethodBeat.m2505o(29837);
            return;
        }
        this.ypG.put(i, new C30356c(C46630aa.m88223Nu(BaseClientBuilder.API_PRIORITY_OTHER)));
        AppMethodBeat.m2505o(29837);
    }

    private void dza() {
        AppMethodBeat.m2504i(29838);
        this.ypD.clear();
        C9638aw.m17190ZK();
        String str = (String) C18628c.m29072Ry().get(299010, null);
        if (!C5046bo.isNullOrNil(str)) {
            String[] split = str.split("\\|");
            for (String split2 : split) {
                String[] split3 = split2.split("\\:");
                if (split3.length == 2) {
                    this.ypD.put(C5046bo.ank(split3[0]), C5046bo.ank(split3[1]));
                }
            }
        }
        this.ypH = true;
        AppMethodBeat.m2505o(29838);
    }
}
