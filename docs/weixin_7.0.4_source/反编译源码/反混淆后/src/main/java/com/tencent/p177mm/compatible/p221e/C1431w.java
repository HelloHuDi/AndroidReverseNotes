package com.tencent.p177mm.compatible.p221e;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.MultiProcessSharedPreferences;
import java.util.Map;

/* renamed from: com.tencent.mm.compatible.e.w */
public final class C1431w {
    public static boolean etQ = false;
    public String etR = "";
    Map<String, String> etS = null;
    private int etT = 0;

    /* renamed from: iT */
    public final void mo4882iT(int i) {
        AppMethodBeat.m2504i(93016);
        this.etT = i;
        etQ = true;
        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(C4996ah.getContext(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i);
        edit.commit();
        C4990ab.m7419v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.etT));
        AppMethodBeat.m2505o(93016);
    }

    /* renamed from: Md */
    public static boolean m3054Md() {
        if (!etQ) {
            return false;
        }
        etQ = false;
        return true;
    }

    /* renamed from: kv */
    public final void mo4883kv(String str) {
        this.etR = str;
    }

    /* renamed from: f */
    public final void mo4881f(Map<String, String> map) {
        this.etS = map;
    }
}
