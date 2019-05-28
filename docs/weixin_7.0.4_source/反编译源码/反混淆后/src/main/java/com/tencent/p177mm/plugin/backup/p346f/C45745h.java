package com.tencent.p177mm.plugin.backup.p346f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.f.h */
public final class C45745h {

    /* renamed from: com.tencent.mm.plugin.backup.f.h$a */
    public static class C19972a {
        public String cvZ;
        public String jvA;
        public C19993u jvy;
        public long jvz;
    }

    /* renamed from: rr */
    private static boolean m84543rr(int i) {
        if (i == 1 || i == 3 || i == 34 || i == 42 || i == 66 || i == 43 || i == 43 || i == 44 || i == 47 || i == 48 || i == 49 || i == 50 || i == 62 || i == Downloads.MIN_WAIT_FOR_NETWORK) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static C40522gu m84542a(C7620bi c7620bi, boolean z, String str, PLong pLong, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap, boolean z2, boolean z3, long j) {
        AppMethodBeat.m2504i(17467);
        if (c7620bi.field_msgSvrId == 0) {
            C4990ab.m7413e("MicroMsg.BackupMsgLogic", "packedMsg msgSvrId is 0, talker[%s], type[%d]", c7620bi.field_talker, Integer.valueOf(c7620bi.getType()));
            AppMethodBeat.m2505o(17467);
            return null;
        }
        int Kx = C4733l.m7082Kx(c7620bi.getType());
        if (C45745h.m84543rr(Kx)) {
            int i;
            C40522gu c40522gu;
            C40522gu c40522gu2 = new C40522gu();
            c40522gu2.ptF = c7620bi.field_msgSvrId;
            if (c7620bi.field_isSend == 1) {
                c40522gu2.vEB = new bts().alV(str);
                c40522gu2.vEC = new bts().alV(c7620bi.field_talker);
                i = 2;
                c40522gu = c40522gu2;
            } else {
                c40522gu2.vEB = new bts().alV(c7620bi.field_talker);
                c40522gu2.vEC = new bts().alV(str);
                if (z2) {
                    i = 3;
                    c40522gu = c40522gu2;
                } else {
                    i = 4;
                    c40522gu = c40522gu2;
                }
            }
            c40522gu.vIY = i;
            c40522gu2.vJd = new SKBuiltinBuffer_t();
            c40522gu2.vJe = 0;
            c40522gu2.vJf = 0;
            c40522gu2.vEG = "";
            c40522gu2.jCt = Kx;
            c40522gu2.vIZ = (int) (c7620bi.field_createTime / 1000);
            c40522gu2.vJh = c7620bi.field_createTime;
            c40522gu2.vJg = (int) c7620bi.field_msgSeq;
            c40522gu2.vJi = c7620bi.field_flag;
            bts bts = new bts();
            bts.alV(C5046bo.m7532bc(c7620bi.field_content, ""));
            c40522gu2.vED = bts;
            C27487l rq = C27486c.aTz().mo45286rq(C4733l.m7082Kx(c7620bi.getType()));
            if (rq == null) {
                C4990ab.m7411d("MicroMsg.BackupMsgLogic", "packedMsg unknow type[%d]", Integer.valueOf(c7620bi.getType()));
                AppMethodBeat.m2505o(17467);
                return null;
            }
            i = rq.mo35219a(c40522gu2, z, c7620bi, str, linkedList, hashMap, z3, j);
            if (i < 0) {
                AppMethodBeat.m2505o(17467);
                return null;
            }
            pLong.value += (long) i;
            pLong.value += 60;
            AppMethodBeat.m2505o(17467);
            return c40522gu2;
        }
        C4990ab.m7413e("MicroMsg.BackupMsgLogic", "packedMsg type is not allowed, talker[%s], type[%d]", c7620bi.field_talker, Integer.valueOf(c7620bi.getType()));
        AppMethodBeat.m2505o(17467);
        return null;
    }
}
