package com.tencent.mm.ui;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.aa.b;
import com.tencent.mm.ui.aa.c;
import com.tencent.mm.ui.aa.d;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.Map;

public final class z {
    private static z ypB = null;
    private long timestamp = 0;
    int ypC = 0;
    private SparseIntArray ypD = new SparseIntArray();
    private SparseArray<b> ypE = new SparseArray();
    private ArrayList<Integer> ypF = new ArrayList();
    public SparseArray<c> ypG = new SparseArray();
    private boolean ypH = false;

    public z() {
        AppMethodBeat.i(29833);
        AppMethodBeat.o(29833);
    }

    public static z dyZ() {
        AppMethodBeat.i(29834);
        if (ypB == null) {
            ypB = new z();
        }
        z zVar = ypB;
        AppMethodBeat.o(29834);
        return zVar;
    }

    public final void Nt(int i) {
        AppMethodBeat.i(29835);
        if (this.ypE.size() != 0) {
            b bVar = (b) this.ypE.get(i);
            if (bVar != null && bVar.ypM == 1) {
                this.ypD.put(bVar.id, bVar.fQi);
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
                    aw.ZK();
                    com.tencent.mm.model.c.Ry().set(299010, stringBuffer.toString());
                }
            }
        }
        AppMethodBeat.o(29835);
    }

    private void pX(boolean z) {
        AppMethodBeat.i(29836);
        if (!z) {
            int i;
            if (this.ypE.size() == 0 || System.currentTimeMillis() - this.timestamp > 3600000) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                AppMethodBeat.o(29836);
                return;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        ab.i("MicroMsg.PlusMenaDataManager", "dynaConfigs size %d", Integer.valueOf(g.Nu().kC("TopRightMenu\\d*").size()));
        synchronized (this) {
            try {
                String value;
                int ank;
                this.ypE.clear();
                this.ypF.clear();
                for (String value2 : r0) {
                    Map z2 = br.z(value2, "Menu");
                    if (!(z2 == null || z2.size() == 0)) {
                        ank = bo.ank((String) z2.get(".Menu.$id"));
                        int ank2 = bo.ank((String) z2.get(".Menu.$shownew"));
                        int ank3 = bo.ank((String) z2.get(".Menu.$seq"));
                        int ank4 = bo.ank((String) z2.get(".Menu.$order"));
                        this.ypE.put(ank, new b(ank, ank2, ank3, ank4));
                        int i2 = 0;
                        while (i2 < this.ypF.size() && ((b) this.ypE.get(((Integer) this.ypF.get(i2)).intValue())).order <= ank4) {
                            i2++;
                        }
                        this.ypF.add(i2, Integer.valueOf(ank));
                    }
                }
                ab.i("MicroMsg.PlusMenaDataManager", "dynaMenuOrder size %d", Integer.valueOf(this.ypF.size()));
                if (this.ypF.size() == 0) {
                    this.ypE.clear();
                    this.ypF.clear();
                    value2 = g.Nu().getValue("TopRightMenus");
                    if (!bo.isNullOrNil(value2)) {
                        Map z3 = br.z(value2, "TopRightMenus");
                        if (z3 != null) {
                            ank = 0;
                            while (ank < 100) {
                                String str = ".TopRightMenus.Menu" + (ank == 0 ? "" : Integer.valueOf(ank));
                                value2 = (String) z3.get(str + ".$id");
                                if (value2 == null || bo.isNullOrNil(value2)) {
                                    break;
                                }
                                ab.d("MicroMsg.PlusMenaDataManager", "got plus panel configs : %s %s %s", value2, (String) z3.get(str + ".$shownew"), (String) z3.get(str + ".$seq"));
                                this.ypE.put(bo.ank(value2), new b(bo.ank(value2), bo.ank(r1), bo.ank(str)));
                                this.ypF.add(Integer.valueOf(bo.ank(value2)));
                                ank++;
                            }
                        } else {
                            ab.e("MicroMsg.PlusMenaDataManager", "TopRightMenus is not right");
                        }
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(29836);
            }
        }
        if (this.ypE.size() != 0) {
            dza();
        }
        this.timestamp = System.currentTimeMillis();
        ab.d("MicroMsg.PlusMenaDataManager", " plus menu load data spent time : %s", Long.valueOf(this.timestamp - currentTimeMillis));
        AppMethodBeat.o(29836);
    }

    public final void pY(boolean z) {
        AppMethodBeat.i(29837);
        try {
            pX(z);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.PlusMenaDataManager", e, "", new Object[0]);
        }
        this.ypG.clear();
        this.ypC = 0;
        int i = 0;
        for (int i2 = 0; i2 < this.ypF.size(); i2++) {
            int intValue = ((Integer) this.ypF.get(i2)).intValue();
            b bVar = (b) this.ypE.get(intValue);
            d Nu = aa.Nu(intValue);
            if (Nu != null) {
                c cVar = new c(Nu);
                this.ypG.put(i, cVar);
                int i3 = this.ypD.get(intValue);
                if ((bVar.ypM == 1 && i3 != bVar.fQi) || (intValue == 20 && com.tencent.mm.x.c.PK().bY(262159, 266248))) {
                    cVar.ypO = true;
                    this.ypC++;
                }
                i++;
            }
        }
        ab.i("MicroMsg.PlusMenaDataManager", "dynaMenuOrder.size() %s menuDataMap.size() %s", Integer.valueOf(this.ypF.size()), Integer.valueOf(this.ypG.size()));
        if (com.tencent.mm.sdk.platformtools.g.dnZ()) {
            this.ypG.put(i, new c(aa.Nu(2147483645)));
            AppMethodBeat.o(29837);
            return;
        }
        this.ypG.put(i, new c(aa.Nu(BaseClientBuilder.API_PRIORITY_OTHER)));
        AppMethodBeat.o(29837);
    }

    private void dza() {
        AppMethodBeat.i(29838);
        this.ypD.clear();
        aw.ZK();
        String str = (String) com.tencent.mm.model.c.Ry().get(299010, null);
        if (!bo.isNullOrNil(str)) {
            String[] split = str.split("\\|");
            for (String split2 : split) {
                String[] split3 = split2.split("\\:");
                if (split3.length == 2) {
                    this.ypD.put(bo.ank(split3[0]), bo.ank(split3[1]));
                }
            }
        }
        this.ypH = true;
        AppMethodBeat.o(29838);
    }
}
