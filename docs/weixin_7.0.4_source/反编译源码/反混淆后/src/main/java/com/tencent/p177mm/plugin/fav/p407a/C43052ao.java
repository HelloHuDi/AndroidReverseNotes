package com.tencent.p177mm.plugin.fav.p407a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26189le;
import com.tencent.p177mm.plugin.fav.p407a.C36764n.C27973a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C35992bf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.SensorController;

/* renamed from: com.tencent.mm.plugin.fav.a.ao */
public final class C43052ao implements C27973a {
    private static C36764n mgA = null;
    private static C43052ao mgB = null;
    public int cAO;
    public int duration;
    public String path;

    public static C43052ao bvo() {
        AppMethodBeat.m2504i(102749);
        if (mgB == null) {
            mgB = new C43052ao();
        }
        C43052ao c43052ao = mgB;
        AppMethodBeat.m2505o(102749);
        return c43052ao;
    }

    public static C36764n bvq() {
        return mgA;
    }

    /* renamed from: bI */
    public final void mo6771bI(String str, int i) {
        AppMethodBeat.m2504i(102751);
        C4990ab.m7411d("MicroMsg.WNNoteVoicePlayLogic", "on play, my path %s, my duration %d, play path %s", this.path, Integer.valueOf(this.duration), str);
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 1);
        if (C5046bo.m7532bc(str, "").equals(this.path)) {
            bundle.putBoolean("result", false);
        } else {
            bundle.putBoolean("result", true);
        }
        bundle.putInt("position", i);
        C26189le c26189le = new C26189le();
        c26189le.cHe.cGZ = bundle;
        c26189le.cHe.type = 4;
        C4879a.xxA.mo10055m(c26189le);
        AppMethodBeat.m2505o(102751);
    }

    public final void onFinish() {
        AppMethodBeat.m2504i(102752);
        mgA.stopPlay();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 2);
        C26189le c26189le = new C26189le();
        c26189le.cHe.cGZ = bundle;
        c26189le.cHe.type = 4;
        C4879a.xxA.mo10055m(c26189le);
        AppMethodBeat.m2505o(102752);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(102753);
        mgA.buJ();
        Bundle bundle = new Bundle();
        bundle.putInt("actionCode", 3);
        C26189le c26189le = new C26189le();
        c26189le.cHe.cGZ = bundle;
        c26189le.cHe.type = 4;
        C4879a.xxA.mo10055m(c26189le);
        AppMethodBeat.m2505o(102753);
    }

    public final void bvp() {
        AppMethodBeat.m2504i(102750);
        if (mgA == null) {
            mgA = new C36764n();
        }
        mgA.mo58605a(this);
        mgA.mfU = true;
        C36764n c36764n = mgA;
        if (C36764n.mfW == null) {
            C36764n.mfW = new SensorController(C4996ah.getContext());
        }
        if (c36764n.mfS == null) {
            c36764n.mfS = new C35992bf(C4996ah.getContext());
        }
        AppMethodBeat.m2505o(102750);
    }
}
