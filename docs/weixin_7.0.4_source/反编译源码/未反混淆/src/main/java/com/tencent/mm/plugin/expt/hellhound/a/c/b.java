package com.tencent.mm.plugin.expt.hellhound.a.c;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.n;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.caz;
import com.tencent.mm.protocal.protobuf.cci;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class b {
    private static int lMW = 0;

    static void a(cci cci) {
        AppMethodBeat.i(73462);
        ab.i("HellTimelineReport", "habbyge-mali, reportTimelineV2");
        c T = T(cci.xbM);
        if (T == null) {
            AppMethodBeat.o(73462);
            return;
        }
        ab.i("HellTimelineReport", "habbyge-mali, reportTimelineV2 YES");
        String str = (String) T.get(0);
        n nVar = new n();
        nVar.cWc = Process.myPid();
        n eG = nVar.eF(((h) g.RM().Rn()).eHT).eG(cci.cvF);
        eG.cWf = cci.xbJ;
        eG.cWg = cci.xbK;
        eG.cWh = cci.xbL;
        eG.cWi = str;
        eG.cWj = ((Integer) T.get(1)).intValue();
        int i = lMW;
        lMW = i + 1;
        eG.cWk = i;
        List<n> a = a(nVar);
        if (a == null) {
            AppMethodBeat.o(73462);
            return;
        }
        double d;
        for (n nVar2 : a) {
            nVar2.cWi = nVar2.cWi.replace(",", "#");
            nVar2.ajK();
        }
        if (cci != null) {
            if (Math.abs(cci.xbJ - (cci.xbK + cci.xbL)) <= 50) {
                com.tencent.mm.plugin.report.service.h.pYm.a(932, 87, 1, false);
                ab.i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-timeline前台时长(停留+滚动)-准确");
            } else {
                com.tencent.mm.plugin.report.service.h.pYm.a(932, 88, 1, false);
                ab.i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-timeline前台时长(停留+滚动)-不准确");
            }
        }
        double d2 = 0.0d;
        Iterator it = cci.xbM.iterator();
        while (true) {
            d = d2;
            if (!it.hasNext()) {
                break;
            }
            d2 = ((caz) it.next()).xai + d;
        }
        double abs = Math.abs(((double) cci.xbK) - d);
        if (abs <= 50.0d) {
            com.tencent.mm.plugin.report.service.h.pYm.a(932, 89, 1, false);
            ab.i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-feed停留分时时长-准确: ".concat(String.valueOf(abs)));
            AppMethodBeat.o(73462);
            return;
        }
        com.tencent.mm.plugin.report.service.h.pYm.a(932, 90, 1, false);
        ab.i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-feed停留分时时长-不准确: ".concat(String.valueOf(abs)));
        AppMethodBeat.o(73462);
    }

    private static c<String, Integer> T(LinkedList<caz> linkedList) {
        AppMethodBeat.i(73463);
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                caz caz = (caz) it.next();
                if (caz != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("feedId", caz.feedId);
                    jSONObject.put("feedheight", caz.height);
                    caz.xaj = new BigDecimal(caz.xaj).setScale(2, 4).doubleValue();
                    jSONObject.put("realShowTime", caz.xaj);
                    caz.xai = new BigDecimal(caz.xai).setScale(2, 4).doubleValue();
                    jSONObject.put("stayTimeRelative", caz.xai);
                    jSONObject.put("realScreenHeight", ((caz.iev - caz.qDY) - caz.xaf) - caz.xae);
                    jSONArray.put(jSONObject);
                }
            }
            int length = jSONArray.length();
            if (length > 0) {
                c<String, Integer> F = a.F(jSONArray.toString(), Integer.valueOf(length));
                AppMethodBeat.o(73463);
                return F;
            }
            ab.e("HellTimelineReport", "habbyge-mali, _feedList2JsonV2 jsonArray Empty !!!!");
            AppMethodBeat.o(73463);
            return null;
        } catch (Exception e) {
            ab.printErrStackTrace("HellTimelineReport", e, "habbyge-mali, reportTimeline-_feedList2JsonV2-crash", new Object[0]);
        }
    }

    private static List<n> a(n nVar) {
        AppMethodBeat.i(73464);
        ArrayList arrayList = new ArrayList();
        byte[] bytes = nVar.Fj().getBytes();
        if (bytes.length <= 5120) {
            nVar.cWl = 0;
            nVar.cWm = 1;
            arrayList.add(nVar);
            AppMethodBeat.o(73464);
            return arrayList;
        }
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(nVar.cWi);
        } catch (Exception e) {
            ab.printErrStackTrace("HellTimelineReport", e, "habbyge-mali, reportTimeline-_spliteLogIfBigger7K-Exception", new Object[0]);
            jSONArray = null;
        }
        if (jSONArray == null) {
            AppMethodBeat.o(73464);
            return null;
        }
        JSONArray jSONArray2;
        int length = jSONArray.length();
        double ceil = Math.ceil(((double) bytes.length) / 5120.0d);
        int i = length / ((int) ceil);
        int i2 = length % ((int) ceil);
        int i3 = (int) ceil;
        if (i2 > 0) {
            i3++;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (((double) i6) < ceil) {
            n nVar2 = new n();
            nVar2.cWc = nVar.cWc;
            nVar2.eF(nVar.cWd);
            nVar2.eG(nVar.cWe);
            nVar2.cWf = nVar.cWf;
            nVar2.cWg = nVar.cWg;
            nVar2.cWh = nVar.cWh;
            nVar2.cWk = nVar.cWk;
            jSONArray2 = new JSONArray();
            i5 = i6 * i;
            while (i5 < (i6 + 1) * i && i5 < length - i2) {
                jSONArray2.put(jSONArray.opt(i5));
                i5++;
            }
            nVar2.cWi = jSONArray2.toString();
            nVar2.cWj = jSONArray2.length();
            int i7 = i4 + 1;
            nVar2.cWl = i4;
            nVar2.cWm = i3;
            arrayList.add(nVar2);
            i6++;
            i4 = i7;
        }
        if (i2 > 0) {
            n nVar3 = new n();
            nVar3.cWc = nVar.cWc;
            nVar3.eF(nVar.cWd);
            nVar3.eG(nVar.cWe);
            nVar3.cWf = nVar.cWf;
            nVar3.cWg = nVar.cWg;
            nVar3.cWh = nVar.cWh;
            nVar3.cWk = nVar.cWk;
            jSONArray2 = new JSONArray();
            for (i5 = 
/*
Method generation error in method: com.tencent.mm.plugin.expt.hellhound.a.c.b.a(com.tencent.mm.g.b.a.n):java.util.List<com.tencent.mm.g.b.a.n>, dex: classes2.dex
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r4_5 'i5' int) = (r4_4 'i5' int), (r4_11 'i5' int) binds: {(r4_4 'i5' int)=B:14:0x006b, (r4_11 'i5' int)=B:23:0x00ca} in method: com.tencent.mm.plugin.expt.hellhound.a.c.b.a(com.tencent.mm.g.b.a.n):java.util.List<com.tencent.mm.g.b.a.n>, dex: classes2.dex
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:228)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:185)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:95)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:120)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:89)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:321)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:259)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:221)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:111)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:77)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:539)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:511)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:222)
	... 27 more

*/
}
