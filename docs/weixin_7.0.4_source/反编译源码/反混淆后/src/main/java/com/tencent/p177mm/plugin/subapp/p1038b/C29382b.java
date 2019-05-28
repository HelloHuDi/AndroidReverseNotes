package com.tencent.p177mm.plugin.subapp.p1038b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.pluginsdk.p1080h.p1081a.C14859a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.subapp.b.b */
public final class C29382b implements C1201e, C1202f {
    private Queue<C29383a> ssL = null;
    private boolean ssM = false;

    /* renamed from: com.tencent.mm.plugin.subapp.b.b$a */
    static class C29383a {
        public String gpA;
        public Queue<String> ssN = new LinkedList();

        C29383a(String str) {
            AppMethodBeat.m2504i(25240);
            this.gpA = str;
            C4990ab.m7410d("MicroMsg.PushMessageExtension", "DoSceneStruct:".concat(String.valueOf(str)));
            ArrayList bA = C14859a.m23123bA(C4996ah.getContext(), str);
            if (bA == null || bA.size() <= 0) {
                C4990ab.m7412e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
                AppMethodBeat.m2505o(25240);
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < bA.size()) {
                    Map map = ((C14859a) bA.get(i2)).vfN;
                    if (map != null) {
                        for (Entry value : map.entrySet()) {
                            this.ssN.offer(value.getValue());
                        }
                    }
                    i = i2 + 1;
                } else {
                    AppMethodBeat.m2505o(25240);
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        AppMethodBeat.m2504i(25241);
        String a = C1946aa.m4148a(c1197a.eAB.vED);
        if (this.ssL == null) {
            this.ssL = new LinkedList();
        }
        C29383a c29383a = new C29383a(a);
        if (c29383a.gpA != null) {
            this.ssL.offer(c29383a);
            cDC();
        }
        AppMethodBeat.m2505o(25241);
        return null;
    }

    private void cDC() {
        AppMethodBeat.m2504i(25242);
        if (this.ssM) {
            AppMethodBeat.m2505o(25242);
        } else if (this.ssL.size() == 0) {
            AppMethodBeat.m2505o(25242);
        } else {
            C29383a c29383a = (C29383a) this.ssL.peek();
            if (c29383a.ssN.size() == 0) {
                this.ssL.poll();
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(8193, c29383a.gpA);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(8449, Long.valueOf(C5046bo.anT()));
                AppMethodBeat.m2505o(25242);
                return;
            }
            String str = (String) c29383a.ssN.peek();
            if (str == null || str.length() <= 0) {
                AppMethodBeat.m2505o(25242);
                return;
            }
            this.ssM = true;
            C1207m c13896a = new C13896a(str);
            C9638aw.m17182Rg().mo14539a(141, (C1202f) this);
            C9638aw.m17182Rg().mo14541a(c13896a, 0);
            AppMethodBeat.m2505o(25242);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(25243);
        if (c1207m.getType() != 141) {
            this.ssM = false;
            AppMethodBeat.m2505o(25243);
            return;
        }
        C9638aw.m17182Rg().mo14546b(141, (C1202f) this);
        String str2 = ((C13896a) c1207m).url;
        C29383a c29383a = (C29383a) this.ssL.peek();
        if (c29383a == null || c29383a.ssN.size() == 0) {
            C4990ab.m7412e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
            this.ssL = new LinkedList();
            this.ssM = false;
            AppMethodBeat.m2505o(25243);
        } else if (c29383a.ssN.size() == 0) {
            C4990ab.m7412e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
            this.ssL.poll();
            this.ssM = false;
            AppMethodBeat.m2505o(25243);
        } else if (!((String) c29383a.ssN.peek()).equals(str2)) {
            C4990ab.m7412e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
            this.ssL.poll();
            this.ssM = false;
            AppMethodBeat.m2505o(25243);
        } else if (i == 0 && i2 == 0) {
            c29383a.ssN.poll();
            this.ssM = false;
            cDC();
            AppMethodBeat.m2505o(25243);
        } else {
            C4990ab.m7412e("MicroMsg.PushMessageExtension", "down failed [" + i + "," + i2 + "] ignore this message : img:[" + str2 + "] ");
            this.ssL.poll();
            this.ssM = false;
            AppMethodBeat.m2505o(25243);
        }
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
