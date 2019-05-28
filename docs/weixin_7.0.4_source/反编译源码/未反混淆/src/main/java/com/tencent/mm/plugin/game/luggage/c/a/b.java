package com.tencent.mm.plugin.game.luggage.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.a;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private String mAppId;
    List<bbb> mUj;
    Map<Integer, a> mUk = new HashMap();

    public b(String str) {
        AppMethodBeat.i(135891);
        this.mAppId = str;
        bDu();
        a(new h());
        a(new f());
        a(new j());
        a(new g());
        a(new i());
        a(new d());
        a(new e());
        AppMethodBeat.o(135891);
    }

    private void a(a aVar) {
        AppMethodBeat.i(135892);
        this.mUk.put(Integer.valueOf(aVar.id), aVar);
        AppMethodBeat.o(135892);
    }

    private void bDu() {
        AppMethodBeat.i(135893);
        this.mUj = a.uEt;
        try {
            MainProcessTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 9;
            commonLogicTask.mqu.putString("game_hv_menu_appid", this.mAppId);
            AppBrandMainProcessService.b(commonLogicTask);
            String string = commonLogicTask.mqu.getString("game_hv_menu_pbcache");
            if (!bo.isNullOrNil(string)) {
                byte[] bytes = string.getBytes("ISO-8859-1");
                asm asm = new asm();
                asm.parseFrom(bytes);
                if (!bo.ek(asm.wvX)) {
                    this.mUj = asm.wvX;
                    ab.i("MicroMsg.H5GameMenuHelp", "use net menu data");
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", e.getMessage());
        }
        Collections.sort(this.mUj, new Comparator<bbb>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((bbb) obj).wFR - ((bbb) obj2).wFR;
            }
        });
        int i = ((bbb) this.mUj.get(this.mUj.size() - 1)).wFR;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(null);
        }
        for (bbb bbb : this.mUj) {
            if (bbb.wFR > 0 && bbb.wFR <= arrayList.size()) {
                arrayList.set(bbb.wFR - 1, bbb);
            }
        }
        this.mUj = arrayList;
        AppMethodBeat.o(135893);
    }
}
