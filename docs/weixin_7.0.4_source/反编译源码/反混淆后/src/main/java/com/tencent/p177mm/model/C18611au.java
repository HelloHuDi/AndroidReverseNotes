package com.tencent.p177mm.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.model.au */
public final class C18611au {
    /* renamed from: kB */
    public static void m29048kB(int i) {
        AppMethodBeat.m2504i(77810);
        boolean MC = C37885a.m63950MC();
        boolean ME = C37885a.m63952ME();
        boolean MF = C37885a.m63953MF();
        boolean MG = C37885a.m63954MG();
        boolean MI = C37885a.m63956MI();
        boolean MR = C37885a.m63965MR();
        int MS = C37885a.m63966MS();
        int MU = C37885a.m63968MU();
        int MT = C37885a.m63967MT();
        int MV = C37885a.m63969MV();
        C1720g.m3537RQ();
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73217, Boolean.TRUE)).booleanValue();
        C1720g.m3537RQ();
        boolean z = booleanValue || ((Boolean) C1720g.m3536RP().mo5239Ry().get(73218, Boolean.TRUE)).booleanValue();
        C4990ab.m7417i("MicroMsg.KvNotificationStat", "doStatNotification, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, isNotificationShowDetail: %s, isNotificationSound: %s, isNotificationShake: %s, isActiveSilentTime: %s, activeBegin: %s, activeEnd: %s, scene: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", Boolean.valueOf(MC), Boolean.valueOf(ME), Boolean.valueOf(MF), Boolean.valueOf(MG), Boolean.valueOf(MI), Boolean.valueOf(MR), C18611au.m29049kC(MS) + C18611au.m29049kC(MU), C18611au.m29049kC(MT) + C18611au.m29049kC(MV), Integer.valueOf(i), Boolean.valueOf(booleanValue), Boolean.valueOf(r12), Boolean.valueOf(z));
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[10];
        objArr[0] = Integer.valueOf(MC ? 1 : 2);
        objArr[1] = Integer.valueOf(ME ? 1 : 2);
        objArr[2] = Integer.valueOf(MF ? 1 : 2);
        objArr[3] = Integer.valueOf(MG ? 1 : 2);
        objArr[4] = Integer.valueOf(MI ? 1 : 2);
        objArr[5] = Integer.valueOf(MR ? 2 : 1);
        objArr[6] = C18611au.m29049kC(MT) + C18611au.m29049kC(MV);
        objArr[7] = C18611au.m29049kC(MS) + C18611au.m29049kC(MU);
        objArr[8] = Integer.valueOf(i);
        objArr[9] = Integer.valueOf(z ? 1 : 2);
        c7060h.mo8381e(15308, objArr);
        AppMethodBeat.m2505o(77810);
    }

    /* renamed from: kC */
    private static String m29049kC(int i) {
        AppMethodBeat.m2504i(77811);
        String valueOf;
        if (i > 10) {
            valueOf = String.valueOf(i);
            AppMethodBeat.m2505o(77811);
            return valueOf;
        }
        valueOf = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i));
        AppMethodBeat.m2505o(77811);
        return valueOf;
    }

    /* renamed from: k */
    public static void m29047k(boolean z, boolean z2) {
        int i;
        int i2;
        int i3 = 2;
        AppMethodBeat.m2504i(77812);
        boolean MC = C37885a.m63950MC();
        boolean ME = C37885a.m63952ME();
        C1720g.m3537RQ();
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(73217, Boolean.TRUE)).booleanValue();
        C1720g.m3537RQ();
        boolean z3 = booleanValue || ((Boolean) C1720g.m3536RP().mo5239Ry().get(73218, Boolean.TRUE)).booleanValue();
        C4990ab.m7417i("MicroMsg.KvNotificationStat", "doStatSysNotificationAfterModify, switchNewMsg: %s, switchVoipInvite: %s, isNewMsgNotification: %s, isNewVoipMsgNotification: %s, voipSound: %s, voipAudioSound: %s, voipHasSound: %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(MC), Boolean.valueOf(ME), Boolean.valueOf(booleanValue), Boolean.valueOf(r7), Boolean.valueOf(z3));
        C7060h c7060h = C7060h.pYm;
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
        c7060h.mo8381e(14852, objArr);
        AppMethodBeat.m2505o(77812);
    }
}
