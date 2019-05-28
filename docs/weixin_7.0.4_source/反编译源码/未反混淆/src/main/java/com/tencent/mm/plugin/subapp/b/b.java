package com.tencent.mm.plugin.subapp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public final class b implements e, f {
    private Queue<a> ssL = null;
    private boolean ssM = false;

    static class a {
        public String gpA;
        public Queue<String> ssN = new LinkedList();

        a(String str) {
            AppMethodBeat.i(25240);
            this.gpA = str;
            ab.d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(str)));
            ArrayList bA = com.tencent.mm.pluginsdk.h.a.a.bA(ah.getContext(), str);
            if (bA == null || bA.size() <= 0) {
                ab.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
                AppMethodBeat.o(25240);
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bA.size()) {
                    Map map = ((com.tencent.mm.pluginsdk.h.a.a) bA.get(i2)).vfN;
                    if (map != null) {
                        for (Entry value : map.entrySet()) {
                            this.ssN.offer(value.getValue());
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.o(25240);
                    return;
                }
            }
        }
    }

    public final com.tencent.mm.ai.e.b b(com.tencent.mm.ai.e.a aVar) {
        AppMethodBeat.i(25241);
        String a = aa.a(aVar.eAB.vED);
        if (this.ssL == null) {
            this.ssL = new LinkedList();
        }
        a aVar2 = new a(a);
        if (aVar2.gpA != null) {
            this.ssL.offer(aVar2);
            cDC();
        }
        AppMethodBeat.o(25241);
        return null;
    }

    private void cDC() {
        AppMethodBeat.i(25242);
        if (this.ssM) {
            AppMethodBeat.o(25242);
        } else if (this.ssL.size() == 0) {
            AppMethodBeat.o(25242);
        } else {
            a aVar = (a) this.ssL.peek();
            if (aVar.ssN.size() == 0) {
                this.ssL.poll();
                aw.ZK();
                c.Ry().set(8193, aVar.gpA);
                aw.ZK();
                c.Ry().set(8449, Long.valueOf(bo.anT()));
                AppMethodBeat.o(25242);
                return;
            }
            String str = (String) aVar.ssN.peek();
            if (str == null || str.length() <= 0) {
                AppMethodBeat.o(25242);
                return;
            }
            this.ssM = true;
            m aVar2 = new a(str);
            aw.Rg().a(141, (f) this);
            aw.Rg().a(aVar2, 0);
            AppMethodBeat.o(25242);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(25243);
        if (mVar.getType() != 141) {
            this.ssM = false;
            AppMethodBeat.o(25243);
            return;
        }
        aw.Rg().b(141, (f) this);
        String str2 = ((a) mVar).url;
        a aVar = (a) this.ssL.peek();
        if (aVar == null || aVar.ssN.size() == 0) {
            ab.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
            this.ssL = new LinkedList();
            this.ssM = false;
            AppMethodBeat.o(25243);
        } else if (aVar.ssN.size() == 0) {
            ab.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
            this.ssL.poll();
            this.ssM = false;
            AppMethodBeat.o(25243);
        } else if (!((String) aVar.ssN.peek()).equals(str2)) {
            ab.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
            this.ssL.poll();
            this.ssM = false;
            AppMethodBeat.o(25243);
        } else if (i == 0 && i2 == 0) {
            aVar.ssN.poll();
            this.ssM = false;
            cDC();
            AppMethodBeat.o(25243);
        } else {
            ab.e("MicroMsg.PushMessageExtension", "down failed [" + i + "," + i2 + "] ignore this message : img:[" + str2 + "] ");
            this.ssL.poll();
            this.ssM = false;
            AppMethodBeat.o(25243);
        }
    }

    public final void a(e.c cVar) {
    }
}
