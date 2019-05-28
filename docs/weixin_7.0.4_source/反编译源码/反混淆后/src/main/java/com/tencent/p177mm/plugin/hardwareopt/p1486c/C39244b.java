package com.tencent.p177mm.plugin.hardwareopt.p1486c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.asz;
import com.tencent.p177mm.protocal.protobuf.bbg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.hardwareopt.c.b */
public final class C39244b implements C5681a<Boolean, asz> {
    private boolean nqs = false;

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.m2504i(59282);
        Boolean a = m66865a((asz) obj);
        AppMethodBeat.m2505o(59282);
        return a;
    }

    public C39244b(boolean z) {
        this.nqs = z;
    }

    /* renamed from: a */
    private Boolean m66865a(asz asz) {
        AppMethodBeat.m2504i(59280);
        Boolean bool;
        if (C1720g.m3534RN().mo5161QY()) {
            long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC, Long.valueOf(-1))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - longValue));
            if (!this.nqs && currentTimeMillis - longValue < 86400000) {
                C4990ab.m7410d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(59280);
                return bool;
            } else if (!this.nqs && (asz == null || asz.wwG == null)) {
                C4990ab.m7420w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
                C7060h.pYm.mo8378a(661, 1, 1, false);
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(59280);
                return bool;
            } else if (this.nqs || !C5046bo.isNullOrNil(asz.wwG.imei)) {
                C4990ab.m7416i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[41];
                objArr[0] = asz.wwG.imei;
                objArr[1] = asz.wwG.vJX;
                objArr[2] = asz.wwG.vJY;
                objArr[3] = asz.wwG.vJZ;
                objArr[4] = asz.wwH.vRD;
                objArr[5] = asz.wwH.vRB;
                objArr[6] = asz.wwH.vJY;
                objArr[7] = asz.wwH.vRE;
                objArr[8] = Integer.valueOf(asz.wwH.vRC);
                objArr[9] = Integer.valueOf(asz.wwI.wFN);
                objArr[10] = Integer.valueOf(asz.wwI.wFO);
                objArr[11] = Integer.valueOf(asz.wwJ.xdo);
                objArr[12] = Integer.valueOf(asz.wwJ.xdp ? 1 : 0);
                objArr[13] = Integer.valueOf(asz.wwN.wkx ? 1 : 0);
                objArr[14] = Integer.valueOf(asz.wwN.wky ? 1 : 0);
                objArr[15] = asz.wwK.wWb;
                objArr[16] = Integer.valueOf(asz.wwK.density);
                objArr[17] = asz.wwL.wav;
                objArr[18] = Integer.valueOf(asz.wwM.wjw ? 1 : 0);
                objArr[19] = Integer.valueOf(asz.wwM.wjx ? 1 : 0);
                objArr[20] = Integer.valueOf(asz.wwM.wjy ? 1 : 0);
                objArr[21] = Integer.valueOf(asz.wwM.wjz ? 1 : 0);
                objArr[22] = Integer.valueOf(asz.wwM.wjA ? 1 : 0);
                objArr[23] = Integer.valueOf(asz.wwM.wjB ? 1 : 0);
                objArr[24] = Integer.valueOf(asz.wwM.wjC ? 1 : 0);
                objArr[25] = Integer.valueOf(asz.wwM.wjN ? 1 : 0);
                objArr[26] = Integer.valueOf(asz.wwM.wjD ? 1 : 0);
                objArr[27] = Integer.valueOf(asz.wwM.wjE ? 1 : 0);
                objArr[28] = Integer.valueOf(asz.wwM.wjF ? 1 : 0);
                objArr[29] = Integer.valueOf(asz.wwM.wjG ? 1 : 0);
                objArr[30] = Integer.valueOf(asz.wwM.wjH ? 1 : 0);
                objArr[31] = Integer.valueOf(asz.wwM.wjI ? 1 : 0);
                objArr[32] = Integer.valueOf(asz.wwM.wjJ ? 1 : 0);
                objArr[33] = Integer.valueOf(asz.wwM.wjK ? 1 : 0);
                objArr[34] = Integer.valueOf(asz.wwM.wjL ? 1 : 0);
                objArr[35] = Integer.valueOf(asz.wwM.wjM ? 1 : 0);
                objArr[36] = Integer.valueOf(asz.wwI.ggb);
                objArr[37] = Integer.valueOf(asz.wwI.wFP);
                objArr[38] = asz.wwL.waw;
                objArr[39] = C39244b.m66866ad(asz.wwL.wax);
                objArr[40] = Integer.valueOf(asz.wwN.wkz ? 1 : 0);
                c7060h.mo8381e(14552, objArr);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC, Long.valueOf(currentTimeMillis));
                C7060h.pYm.mo8378a(661, 0, 1, false);
                bool = Boolean.TRUE;
                AppMethodBeat.m2505o(59280);
                return bool;
            } else {
                C4990ab.m7420w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
                C7060h.pYm.mo8378a(661, 2, 1, false);
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(59280);
                return bool;
            }
        }
        C4990ab.m7412e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
        bool = Boolean.FALSE;
        AppMethodBeat.m2505o(59280);
        return bool;
    }

    /* renamed from: ad */
    private static String m66866ad(LinkedList<bbg> linkedList) {
        AppMethodBeat.m2504i(59281);
        JSONArray jSONArray = new JSONArray();
        String jSONArray2;
        if (linkedList != null) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    bbg bbg = (bbg) it.next();
                    if (!(bbg == null || C5046bo.isNullOrNil(bbg.clY))) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("mimeName", bbg.clY);
                        JSONArray jSONArray3 = new JSONArray();
                        if (bbg.wFX != null) {
                            Iterator it2 = bbg.wFX.iterator();
                            while (it2.hasNext()) {
                                jSONArray3.put((String) it2.next());
                            }
                        }
                        jSONObject.put("codecName", jSONArray3);
                        jSONArray.put(jSONObject);
                    }
                }
                jSONArray2 = jSONArray.toString();
                AppMethodBeat.m2505o(59281);
                return jSONArray2;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", e, "hy: error when build up json", new Object[0]);
                jSONArray2 = "";
                AppMethodBeat.m2505o(59281);
                return jSONArray2;
            }
        }
        C4990ab.m7420w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
        jSONArray2 = "";
        AppMethodBeat.m2505o(59281);
        return jSONArray2;
    }
}
