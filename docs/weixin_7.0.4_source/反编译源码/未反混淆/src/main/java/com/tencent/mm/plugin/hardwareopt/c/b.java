package com.tencent.mm.plugin.hardwareopt.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.asz;
import com.tencent.mm.protocal.protobuf.bbg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vending.c.a;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b implements a<Boolean, asz> {
    private boolean nqs = false;

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(59282);
        Boolean a = a((asz) obj);
        AppMethodBeat.o(59282);
        return a;
    }

    public b(boolean z) {
        this.nqs = z;
    }

    private Boolean a(asz asz) {
        AppMethodBeat.i(59280);
        Boolean bool;
        if (g.RN().QY()) {
            long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC, Long.valueOf(-1))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.TaskReportHardwareInfo", "hy: last ticks: %d, current ticks: %d, interval: %d", Long.valueOf(longValue), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - longValue));
            if (!this.nqs && currentTimeMillis - longValue < 86400000) {
                ab.d("MicroMsg.TaskReportHardwareInfo", "hy: should not upload. too small interval");
                bool = Boolean.FALSE;
                AppMethodBeat.o(59280);
                return bool;
            } else if (!this.nqs && (asz == null || asz.wwG == null)) {
                ab.w("MicroMsg.TaskReportHardwareInfo", "hy: error when finding hardware");
                h.pYm.a(661, 1, 1, false);
                bool = Boolean.FALSE;
                AppMethodBeat.o(59280);
                return bool;
            } else if (this.nqs || !bo.isNullOrNil(asz.wwG.imei)) {
                ab.i("MicroMsg.TaskReportHardwareInfo", "hy: found hardware infos. start report");
                h hVar = h.pYm;
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
                objArr[39] = ad(asz.wwL.wax);
                objArr[40] = Integer.valueOf(asz.wwN.wkz ? 1 : 0);
                hVar.e(14552, objArr);
                g.RP().Ry().set(ac.a.USERINFO_HARDWARE_LAST_UPLOAD_TICKS_LONG_SYNC, Long.valueOf(currentTimeMillis));
                h.pYm.a(661, 0, 1, false);
                bool = Boolean.TRUE;
                AppMethodBeat.o(59280);
                return bool;
            } else {
                ab.w("MicroMsg.TaskReportHardwareInfo", "hy: no imei detected. maybe not grant permission. ignore");
                h.pYm.a(661, 2, 1, false);
                bool = Boolean.FALSE;
                AppMethodBeat.o(59280);
                return bool;
            }
        }
        ab.e("MicroMsg.TaskReportHardwareInfo", "Account not init, just return");
        bool = Boolean.FALSE;
        AppMethodBeat.o(59280);
        return bool;
    }

    private static String ad(LinkedList<bbg> linkedList) {
        AppMethodBeat.i(59281);
        JSONArray jSONArray = new JSONArray();
        String jSONArray2;
        if (linkedList != null) {
            try {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    bbg bbg = (bbg) it.next();
                    if (!(bbg == null || bo.isNullOrNil(bbg.clY))) {
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
                AppMethodBeat.o(59281);
                return jSONArray2;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.TaskReportHardwareInfo", e, "hy: error when build up json", new Object[0]);
                jSONArray2 = "";
                AppMethodBeat.o(59281);
                return jSONArray2;
            }
        }
        ab.w("MicroMsg.TaskReportHardwareInfo", "hy: no mime info retrieved!");
        jSONArray2 = "";
        AppMethodBeat.o(59281);
        return jSONArray2;
    }
}
