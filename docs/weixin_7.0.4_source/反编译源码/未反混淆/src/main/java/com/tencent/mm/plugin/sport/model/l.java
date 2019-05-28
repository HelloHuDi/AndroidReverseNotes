package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.e;
import com.tencent.mm.protocal.protobuf.aon;
import com.tencent.mm.protocal.protobuf.cdo;
import com.tencent.mm.sdk.platformtools.ab;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public final class l {
    public f fur = new f() {
        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(93699);
            if (mVar instanceof d) {
                g.Rg().b(1734, l.this.fur);
                d dVar = (d) mVar;
                if (i == 0 && i2 == 0) {
                    aon aon = dVar.rPs;
                    Collections.sort(aon.wsF, new Comparator<cdo>() {
                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            return ((cdo) obj).timestamp - ((cdo) obj2).timestamp;
                        }
                    });
                    Calendar instance = Calendar.getInstance();
                    instance.setTimeInMillis(((long) ((cdo) aon.wsF.get(0)).timestamp) * 1000);
                    instance.set(10, 0);
                    instance.set(12, 0);
                    instance.set(13, 0);
                    long timeInMillis = instance.getTimeInMillis();
                    ((PluginSport) g.M(PluginSport.class)).getSportStepStorage();
                    m.X((long) dVar.rPr.wdb, (long) dVar.rPr.wdc);
                    ab.i("MicroMsg.Sport.SportStepManager", "delete step item after %s", l.this.rPL.format(new Date(timeInMillis)));
                    ArrayList arrayList = new ArrayList();
                    Iterator it = aon.wsF.iterator();
                    while (it.hasNext()) {
                        cdo cdo = (cdo) it.next();
                        e eVar = new e();
                        eVar.field_step = cdo.hzv;
                        eVar.field_timestamp = ((long) cdo.timestamp) * 1000;
                        eVar.field_date = l.this.rPL.format(new Date(eVar.field_timestamp));
                        arrayList.add(eVar);
                    }
                    ((PluginSport) g.M(PluginSport.class)).getSportStepStorage();
                    m.dC(arrayList);
                    if (dVar.cwm() != null) {
                        dVar.cwm().wL();
                    }
                    AppMethodBeat.o(93699);
                    return;
                } else if (dVar.cwm() != null) {
                    dVar.cwm();
                }
            }
            AppMethodBeat.o(93699);
        }
    };
    public SimpleDateFormat rPL = new SimpleDateFormat("yyyy-MM-dd");

    public l() {
        AppMethodBeat.i(93700);
        AppMethodBeat.o(93700);
    }
}
