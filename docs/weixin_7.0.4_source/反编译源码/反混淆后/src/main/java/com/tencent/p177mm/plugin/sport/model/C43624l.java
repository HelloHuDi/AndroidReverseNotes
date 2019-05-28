package com.tencent.p177mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.sport.PluginSport;
import com.tencent.p177mm.plugin.sport.p1302a.C29259e;
import com.tencent.p177mm.protocal.protobuf.aon;
import com.tencent.p177mm.protocal.protobuf.cdo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.sport.model.l */
public final class C43624l {
    public C1202f fur = new C351621();
    public SimpleDateFormat rPL = new SimpleDateFormat("yyyy-MM-dd");

    /* renamed from: com.tencent.mm.plugin.sport.model.l$1 */
    class C351621 implements C1202f {

        /* renamed from: com.tencent.mm.plugin.sport.model.l$1$1 */
        class C221711 implements Comparator<cdo> {
            C221711() {
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((cdo) obj).timestamp - ((cdo) obj2).timestamp;
            }
        }

        C351621() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(93699);
            if (c1207m instanceof C43621d) {
                C1720g.m3540Rg().mo14546b(1734, C43624l.this.fur);
                C43621d c43621d = (C43621d) c1207m;
                if (i == 0 && i2 == 0) {
                    aon aon = c43621d.rPs;
                    Collections.sort(aon.wsF, new C221711());
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(((long) ((cdo) aon.wsF.get(0)).timestamp) * 1000);
                    instance.set(10, 0);
                    instance.set(12, 0);
                    instance.set(13, 0);
                    long timeInMillis = instance.getTimeInMillis();
                    ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepStorage();
                    C46268m.m86666X((long) c43621d.rPr.wdb, (long) c43621d.rPr.wdc);
                    C4990ab.m7417i("MicroMsg.Sport.SportStepManager", "delete step item after %s", C43624l.this.rPL.format(new Date(timeInMillis)));
                    ArrayList arrayList = new ArrayList();
                    Iterator it = aon.wsF.iterator();
                    while (it.hasNext()) {
                        cdo cdo = (cdo) it.next();
                        C29259e c29259e = new C29259e();
                        c29259e.field_step = cdo.hzv;
                        c29259e.field_timestamp = ((long) cdo.timestamp) * 1000;
                        c29259e.field_date = C43624l.this.rPL.format(new Date(c29259e.field_timestamp));
                        arrayList.add(c29259e);
                    }
                    ((PluginSport) C1720g.m3530M(PluginSport.class)).getSportStepStorage();
                    C46268m.m86667dC(arrayList);
                    if (c43621d.cwm() != null) {
                        c43621d.cwm().mo35855wL();
                    }
                    AppMethodBeat.m2505o(93699);
                    return;
                } else if (c43621d.cwm() != null) {
                    c43621d.cwm();
                }
            }
            AppMethodBeat.m2505o(93699);
        }
    }

    public C43624l() {
        AppMethodBeat.m2504i(93700);
        AppMethodBeat.m2505o(93700);
    }
}
