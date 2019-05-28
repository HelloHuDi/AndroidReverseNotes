package com.tencent.p177mm.plugin.game.luggage.p430c.p431a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.game.luggage.ipc.CommonLogicTask;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C40316a;
import com.tencent.p177mm.protocal.protobuf.asm;
import com.tencent.p177mm.protocal.protobuf.bbb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.game.luggage.c.a.b */
public final class C34290b {
    private String mAppId;
    List<bbb> mUj;
    Map<Integer, C34289a> mUk = new HashMap();

    /* renamed from: com.tencent.mm.plugin.game.luggage.c.a.b$1 */
    class C121331 implements Comparator<bbb> {
        C121331() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((bbb) obj).wFR - ((bbb) obj2).wFR;
        }
    }

    public C34290b(String str) {
        AppMethodBeat.m2504i(135891);
        this.mAppId = str;
        bDu();
        m56226a(new C20979h());
        m56226a(new C3225f());
        m56226a(new C39208j());
        m56226a(new C28213g());
        m56226a(new C46004i());
        m56226a(new C39207d());
        m56226a(new C3223e());
        AppMethodBeat.m2505o(135891);
    }

    /* renamed from: a */
    private void m56226a(C34289a c34289a) {
        AppMethodBeat.m2504i(135892);
        this.mUk.put(Integer.valueOf(c34289a.f15049id), c34289a);
        AppMethodBeat.m2505o(135892);
    }

    private void bDu() {
        AppMethodBeat.m2504i(135893);
        this.mUj = C40316a.uEt;
        try {
            MainProcessTask commonLogicTask = new CommonLogicTask();
            commonLogicTask.type = 9;
            commonLogicTask.mqu.putString("game_hv_menu_appid", this.mAppId);
            AppBrandMainProcessService.m54355b(commonLogicTask);
            String string = commonLogicTask.mqu.getString("game_hv_menu_pbcache");
            if (!C5046bo.isNullOrNil(string)) {
                byte[] bytes = string.getBytes("ISO-8859-1");
                asm asm = new asm();
                asm.parseFrom(bytes);
                if (!C5046bo.m7548ek(asm.wvX)) {
                    this.mUj = asm.wvX;
                    C4990ab.m7416i("MicroMsg.H5GameMenuHelp", "use net menu data");
                }
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.H5GameMenuHelp", "get cache hv game menu fail! exception:%s", e.getMessage());
        }
        Collections.sort(this.mUj, new C121331());
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
        AppMethodBeat.m2505o(135893);
    }
}
