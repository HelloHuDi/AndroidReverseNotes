package com.tencent.mm.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public final class au {
    public static void kB(int i) {
        AppMethodBeat.i(77810);
        boolean MC = a.MC();
        boolean ME = a.ME();
        boolean MF = a.MF();
        boolean MG = a.MG();
        boolean MI = a.MI();
        boolean MR = a.MR();
        int MS = a.MS();
        int MU = a.MU();
        int MT = a.MT();
        int MV = a.MV();
        g.RQ();
        boolean booleanValue = ((Boolean) g.RP().Ry().get(73217, Boolean.TRUE)).booleanValue();
        g.RQ();
        boolean z = booleanValue || ((Boolean) g.RP().Ry().get(73218, Boolean.TRUE)).booleanValue();
        ab.i("MicroMsg.KvNotificationStat", "doStatNotification, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, isNotificationShowDetail: %s, isNotificationSound: %s, isNotificationShake: %s, isActiveSilentTime: %s, activeBegin: %s, activeEnd: %s, scene: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", Boolean.valueOf(MC), Boolean.valueOf(ME), Boolean.valueOf(MF), Boolean.valueOf(MG), Boolean.valueOf(MI), Boolean.valueOf(MR), kC(MS) + kC(MU), kC(MT) + kC(MV), Integer.valueOf(i), Boolean.valueOf(booleanValue), Boolean.valueOf(r12), Boolean.valueOf(z));
        h hVar = h.pYm;
        Object[] objArr = new Object[10];
        objArr[0] = Integer.valueOf(MC ? 1 : 2);
        objArr[1] = Integer.valueOf(ME ? 1 : 2);
        objArr[2] = Integer.valueOf(MF ? 1 : 2);
        objArr[3] = Integer.valueOf(MG ? 1 : 2);
        objArr[4] = Integer.valueOf(MI ? 1 : 2);
        objArr[5] = Integer.valueOf(MR ? 2 : 1);
        objArr[6] = kC(MT) + kC(MV);
        objArr[7] = kC(MS) + kC(MU);
        objArr[8] = Integer.valueOf(i);
        objArr[9] = Integer.valueOf(z ? 1 : 2);
        hVar.e(15308, objArr);
        AppMethodBeat.o(77810);
    }

    private static String kC(int i) {
        AppMethodBeat.i(77811);
        String valueOf;
        if (i > 10) {
            valueOf = String.valueOf(i);
            AppMethodBeat.o(77811);
            return valueOf;
        }
        valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i));
        AppMethodBeat.o(77811);
        return valueOf;
    }

    public static void k(boolean z, boolean z2) {
        int i;
        int i2;
        int i3 = 2;
        AppMethodBeat.i(77812);
        boolean MC = a.MC();
        boolean ME = a.ME();
        g.RQ();
        boolean booleanValue = ((Boolean) g.RP().Ry().get(73217, Boolean.TRUE)).booleanValue();
        g.RQ();
        boolean z3 = booleanValue || ((Boolean) g.RP().Ry().get(73218, Boolean.TRUE)).booleanValue();
        ab.i("MicroMsg.KvNotificationStat", "doStatSysNotificationAfterModify, switchNewMsg: %s, switchVoipInvite: %s, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(MC), Boolean.valueOf(ME), Boolean.valueOf(booleanValue), Boolean.valueOf(r7), Boolean.valueOf(z3));
        h hVar = h.pYm;
        Object[] objArr = new Object[8];
        if (MC) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        if (ME) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        if (z3) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(0);
        i2 = z ? MC ? 2 : 1 : 0;
        objArr[4] = Integer.valueOf(i2);
        if (!z2) {
            i3 = 0;
        } else if (!ME) {
            i3 = 1;
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(0);
        objArr[7] = Integer.valueOf(0);
        hVar.e(14852, objArr);
        AppMethodBeat.o(77812);
    }
}
