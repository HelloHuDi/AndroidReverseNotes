package com.tencent.mm.compatible.e;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Map;

public final class w {
    public static boolean etQ = false;
    public String etR = "";
    Map<String, String> etS = null;
    private int etT = 0;

    public final void iT(int i) {
        AppMethodBeat.i(93016);
        this.etT = i;
        etQ = true;
        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ah.getContext(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i);
        edit.commit();
        ab.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.etT));
        AppMethodBeat.o(93016);
    }

    public static boolean Md() {
        if (!etQ) {
            return false;
        }
        etQ = false;
        return true;
    }

    public final void kv(String str) {
        this.etR = str;
    }

    public final void f(Map<String, String> map) {
        this.etS = map;
    }
}
