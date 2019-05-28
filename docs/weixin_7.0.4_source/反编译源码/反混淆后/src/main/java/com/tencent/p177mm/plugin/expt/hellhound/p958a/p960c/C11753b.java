package com.tencent.p177mm.plugin.expt.hellhound.p958a.p960c;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p230g.p232b.p233a.C1597n;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.caz;
import com.tencent.p177mm.protocal.protobuf.cci;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p644j.C5710a;
import com.tencent.p177mm.vending.p644j.C7583c;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.a.c.b */
final class C11753b {
    private static int lMW = 0;

    /* renamed from: a */
    static void m19563a(cci cci) {
        AppMethodBeat.m2504i(73462);
        C4990ab.m7416i("HellTimelineReport", "habbyge-mali, reportTimelineV2");
        C7583c T = C11753b.m19561T(cci.xbM);
        if (T == null) {
            AppMethodBeat.m2505o(73462);
            return;
        }
        C4990ab.m7416i("HellTimelineReport", "habbyge-mali, reportTimelineV2 YES");
        String str = (String) T.get(0);
        C1597n c1597n = new C1597n();
        c1597n.cWc = Process.myPid();
        C1597n eG = c1597n.mo5036eF(((C6624h) C1720g.m3533RM().mo5224Rn()).eHT).mo5037eG(cci.cvF);
        eG.cWf = cci.xbJ;
        eG.cWg = cci.xbK;
        eG.cWh = cci.xbL;
        eG.cWi = str;
        eG.cWj = ((Integer) T.get(1)).intValue();
        int i = lMW;
        lMW = i + 1;
        eG.cWk = i;
        List<C1597n> a = C11753b.m19562a(c1597n);
        if (a == null) {
            AppMethodBeat.m2505o(73462);
            return;
        }
        double d;
        for (C1597n c1597n2 : a) {
            c1597n2.cWi = c1597n2.cWi.replace(",", "#");
            c1597n2.ajK();
        }
        if (cci != null) {
            if (Math.abs(cci.xbJ - (cci.xbK + cci.xbL)) <= 50) {
                C7060h.pYm.mo8378a(932, 87, 1, false);
                C4990ab.m7416i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-timeline前台时长(停留+滚动)-准确");
            } else {
                C7060h.pYm.mo8378a(932, 88, 1, false);
                C4990ab.m7416i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-timeline前台时长(停留+滚动)-不准确");
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
            C7060h.pYm.mo8378a(932, 89, 1, false);
            C4990ab.m7416i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-feed停留分时时长-准确: ".concat(String.valueOf(abs)));
            AppMethodBeat.m2505o(73462);
            return;
        }
        C7060h.pYm.mo8378a(932, 90, 1, false);
        C4990ab.m7416i("TimelineMonitorCheck", "habbyge-mali, Timeline分时监控数据准确率上报-feed停留分时时长-不准确: ".concat(String.valueOf(abs)));
        AppMethodBeat.m2505o(73462);
    }

    /* renamed from: T */
    private static C7583c<String, Integer> m19561T(LinkedList<caz> linkedList) {
        AppMethodBeat.m2504i(73463);
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
                C7583c<String, Integer> F = C5710a.m8574F(jSONArray.toString(), Integer.valueOf(length));
                AppMethodBeat.m2505o(73463);
                return F;
            }
            C4990ab.m7412e("HellTimelineReport", "habbyge-mali, _feedList2JsonV2 jsonArray Empty !!!!");
            AppMethodBeat.m2505o(73463);
            return null;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellTimelineReport", e, "habbyge-mali, reportTimeline-_feedList2JsonV2-crash", new Object[0]);
        }
    }

    /* renamed from: a */
    private static List<C1597n> m19562a(C1597n c1597n) {
        AppMethodBeat.m2504i(73464);
        ArrayList arrayList = new ArrayList();
        byte[] bytes = c1597n.mo4982Fj().getBytes();
        if (bytes.length <= 5120) {
            c1597n.cWl = 0;
            c1597n.cWm = 1;
            arrayList.add(c1597n);
            AppMethodBeat.m2505o(73464);
            return arrayList;
        }
        JSONArray jSONArray;
        try {
            jSONArray = new JSONArray(c1597n.cWi);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("HellTimelineReport", e, "habbyge-mali, reportTimeline-_spliteLogIfBigger7K-Exception", new Object[0]);
            jSONArray = null;
        }
        if (jSONArray == null) {
            AppMethodBeat.m2505o(73464);
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
            C1597n c1597n2 = new C1597n();
            c1597n2.cWc = c1597n.cWc;
            c1597n2.mo5036eF(c1597n.cWd);
            c1597n2.mo5037eG(c1597n.cWe);
            c1597n2.cWf = c1597n.cWf;
            c1597n2.cWg = c1597n.cWg;
            c1597n2.cWh = c1597n.cWh;
            c1597n2.cWk = c1597n.cWk;
            jSONArray2 = new JSONArray();
            i5 = i6 * i;
            while (i5 < (i6 + 1) * i && i5 < length - i2) {
                jSONArray2.put(jSONArray.opt(i5));
                i5++;
            }
            c1597n2.cWi = jSONArray2.toString();
            c1597n2.cWj = jSONArray2.length();
            int i7 = i4 + 1;
            c1597n2.cWl = i4;
            c1597n2.cWm = i3;
            arrayList.add(c1597n2);
            i6++;
            i4 = i7;
        }
        if (i2 > 0) {
            C1597n c1597n3 = new C1597n();
            c1597n3.cWc = c1597n.cWc;
            c1597n3.mo5036eF(c1597n.cWd);
            c1597n3.mo5037eG(c1597n.cWe);
            c1597n3.cWf = c1597n.cWf;
            c1597n3.cWg = c1597n.cWg;
            c1597n3.cWh = c1597n.cWh;
            c1597n3.cWk = c1597n.cWk;
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
