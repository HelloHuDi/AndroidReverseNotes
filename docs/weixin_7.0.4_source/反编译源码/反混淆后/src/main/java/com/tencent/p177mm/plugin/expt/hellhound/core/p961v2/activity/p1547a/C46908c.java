package com.tencent.p177mm.plugin.expt.hellhound.core.p961v2.activity.p1547a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.p1258a.C20599b;
import com.tencent.p177mm.protocal.protobuf.C23371bb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.c */
final class C46908c extends C45903a {
    C46908c() {
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        AppMethodBeat.m2504i(73429);
        C4990ab.m7416i("ActivityDao_MMKV", "habbyge-mali, ActivityDao_MMKV reset");
        C20599b.m31826v("hell_aty_action_mmkv_key", new byte[0]);
        AppMethodBeat.m2505o(73429);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: KQ */
    public final void mo73732KQ(String str) {
        AppMethodBeat.m2504i(73430);
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            bqD = new C23371bb();
        }
        bqD.vCS = true;
        if (str == null) {
            str = "";
        }
        bqD.vCW = str;
        C46908c.m89280a(bqD);
        AppMethodBeat.m2505o(73430);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: KR */
    public final boolean mo73733KR(String str) {
        AppMethodBeat.m2504i(73431);
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            AppMethodBeat.m2505o(73431);
            return false;
        }
        boolean z = bqD.vCS;
        String str2 = bqD.vCW;
        if (z) {
            if (!(TextUtils.isEmpty(str2) || str2.equals(str))) {
                z = false;
            }
            bqD.vCS = false;
            bqD.vCW = "";
            C46908c.m89280a(bqD);
        }
        AppMethodBeat.m2505o(73431);
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: KO */
    public final void mo73730KO(String str) {
        AppMethodBeat.m2504i(73432);
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            bqD = new C23371bb();
        }
        bqD.vCT = true;
        if (str == null) {
            str = "";
        }
        bqD.vCX = str;
        C46908c.m89280a(bqD);
        AppMethodBeat.m2505o(73432);
    }

    /* Access modifiers changed, original: final */
    public final boolean bqB() {
        AppMethodBeat.m2504i(73433);
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            AppMethodBeat.m2505o(73433);
            return false;
        }
        boolean z = bqD.vCT;
        if (z) {
            bqD.vCT = false;
            bqD.vCX = "";
            C46908c.m89280a(bqD);
        }
        AppMethodBeat.m2505o(73433);
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: KS */
    public final void mo73734KS(String str) {
        AppMethodBeat.m2504i(73434);
        C4990ab.m7416i("ActivityDao_MMKV", "habbyge-mali, ActivityDao, setStartActivityAction_pause: ".concat(String.valueOf(str)));
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            bqD = new C23371bb();
        }
        bqD.vCU = true;
        if (str == null) {
            str = "";
        }
        bqD.vCY = str;
        C46908c.m89280a(bqD);
        AppMethodBeat.m2505o(73434);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: KT */
    public final boolean mo73735KT(String str) {
        AppMethodBeat.m2504i(73435);
        C4990ab.m7416i("ActivityDao_MMKV", "habbyge-mali, isStartActivityAction_pause: ".concat(String.valueOf(str)));
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            AppMethodBeat.m2505o(73435);
            return false;
        }
        boolean z = bqD.vCU;
        if (z) {
            bqD.vCU = false;
            bqD.vCY = "";
            C46908c.m89280a(bqD);
        }
        AppMethodBeat.m2505o(73435);
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: KP */
    public final void mo73731KP(String str) {
        AppMethodBeat.m2504i(73436);
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            bqD = new C23371bb();
        }
        bqD.vCV = true;
        if (str == null) {
            str = "";
        }
        bqD.vCZ = str;
        C46908c.m89280a(bqD);
        AppMethodBeat.m2505o(73436);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: KU */
    public final boolean mo73736KU(String str) {
        AppMethodBeat.m2504i(73437);
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            AppMethodBeat.m2505o(73437);
            return false;
        }
        boolean z = bqD.vCV;
        String str2 = bqD.vCZ;
        if (z) {
            if (!(TextUtils.isEmpty(str2) || str2.equals(str))) {
                z = false;
            }
            bqD.vCV = false;
            bqD.vCZ = "";
            C46908c.m89280a(bqD);
        }
        AppMethodBeat.m2505o(73437);
        return z;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: uX */
    public final void mo73740uX(int i) {
        AppMethodBeat.m2504i(73438);
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            bqD = new C23371bb();
        }
        bqD.vDa = i;
        C46908c.m89280a(bqD);
        AppMethodBeat.m2505o(73438);
    }

    /* Access modifiers changed, original: final */
    public final int bqA() {
        AppMethodBeat.m2504i(73439);
        C23371bb bqD = C46908c.bqD();
        if (bqD == null) {
            AppMethodBeat.m2505o(73439);
            return -1;
        }
        int i = bqD.vDa;
        AppMethodBeat.m2505o(73439);
        return i;
    }

    /* renamed from: a */
    private static void m89280a(C23371bb c23371bb) {
        AppMethodBeat.m2504i(73440);
        try {
            C20599b.m31826v("hell_aty_action_mmkv_key", c23371bb.toByteArray());
            AppMethodBeat.m2505o(73440);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("ActivityDao_MMKV", e, "habbyge-mali, HellhoundDao writeBack", new Object[0]);
            AppMethodBeat.m2505o(73440);
        }
    }

    private static C23371bb bqD() {
        AppMethodBeat.m2504i(73441);
        byte[] bytes = C20599b.getBytes("hell_aty_action_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.m2505o(73441);
            return null;
        }
        C23371bb c23371bb = new C23371bb();
        try {
            c23371bb.parseFrom(bytes);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("ActivityDao_MMKV", e, "habbyge-mali, HellhoundDao _doRead parse", new Object[0]);
            c23371bb = null;
        }
        AppMethodBeat.m2505o(73441);
        return c23371bb;
    }
}
