package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.i.u;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.LinkedList;

public final class h {

    public static class a {
        public String cvZ;
        public String jvA;
        public u jvy;
        public long jvz;
    }

    private static boolean rr(int i) {
        if (i == 1 || i == 3 || i == 34 || i == 42 || i == 66 || i == 43 || i == 43 || i == 44 || i == 47 || i == 48 || i == 49 || i == 50 || i == 62 || i == Downloads.MIN_WAIT_FOR_NETWORK) {
            return true;
        }
        return false;
    }

    public static gu a(bi biVar, boolean z, String str, PLong pLong, LinkedList<u> linkedList, HashMap<Long, a> hashMap, boolean z2, boolean z3, long j) {
        AppMethodBeat.i(17467);
        if (biVar.field_msgSvrId == 0) {
            ab.e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", biVar.field_talker, Integer.valueOf(biVar.getType()));
            AppMethodBeat.o(17467);
            return null;
        }
        int Kx = l.Kx(biVar.getType());
        if (rr(Kx)) {
            int i;
            gu guVar;
            gu guVar2 = new gu();
            guVar2.ptF = biVar.field_msgSvrId;
            if (biVar.field_isSend == 1) {
                guVar2.vEB = new bts().alV(str);
                guVar2.vEC = new bts().alV(biVar.field_talker);
                i = 2;
                guVar = guVar2;
            } else {
                guVar2.vEB = new bts().alV(biVar.field_talker);
                guVar2.vEC = new bts().alV(str);
                if (z2) {
                    i = 3;
                    guVar = guVar2;
                } else {
                    i = 4;
                    guVar = guVar2;
                }
            }
            guVar.vIY = i;
            guVar2.vJd = new SKBuiltinBuffer_t();
            guVar2.vJe = 0;
            guVar2.vJf = 0;
            guVar2.vEG = "";
            guVar2.jCt = Kx;
            guVar2.vIZ = (int) (biVar.field_createTime / 1000);
            guVar2.vJh = biVar.field_createTime;
            guVar2.vJg = (int) biVar.field_msgSeq;
            guVar2.vJi = biVar.field_flag;
            bts bts = new bts();
            bts.alV(bo.bc(biVar.field_content, ""));
            guVar2.vED = bts;
            l rq = c.aTz().rq(l.Kx(biVar.getType()));
            if (rq == null) {
                ab.d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", Integer.valueOf(biVar.getType()));
                AppMethodBeat.o(17467);
                return null;
            }
            i = rq.a(guVar2, z, biVar, str, linkedList, hashMap, z3, j);
            if (i < 0) {
                AppMethodBeat.o(17467);
                return null;
            }
            pLong.value += (long) i;
            pLong.value += 60;
            AppMethodBeat.o(17467);
            return guVar2;
        }
        ab.e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", biVar.field_talker, Integer.valueOf(biVar.getType()));
        AppMethodBeat.o(17467);
        return null;
    }
}
