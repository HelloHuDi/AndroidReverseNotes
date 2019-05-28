package com.tencent.p177mm.plugin.translate.p1308a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.translate.p1308a.C36832c.C36833c;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cir;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.translate.a.d */
public final class C35330d implements C1202f {
    public int index;
    public SparseArray<C36833c> sKE = null;
    public boolean sKF = false;
    public C35329b sKG;
    C35328a sKH;
    public C7564ap sKI = new C7564ap(new C353311(), false);
    private long start;

    /* renamed from: com.tencent.mm.plugin.translate.a.d$1 */
    class C353311 implements C5015a {
        C353311() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26068);
            if (C35330d.this.sKF) {
                C4990ab.m7413e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", Integer.valueOf(C35330d.this.index));
                C35330d.this.cHJ();
                C35330d.this.sKH.mo56073a(-1, C35330d.this.sKE, null);
            }
            AppMethodBeat.m2505o(26068);
            return false;
        }
    }

    public C35330d(int i, C35328a c35328a) {
        AppMethodBeat.m2504i(26069);
        this.index = i;
        this.sKH = c35328a;
        AppMethodBeat.m2505o(26069);
    }

    /* renamed from: e */
    public final boolean mo56075e(Queue<C36833c> queue) {
        AppMethodBeat.m2504i(26070);
        if (this.sKF) {
            AppMethodBeat.m2505o(26070);
            return false;
        }
        this.sKE = new SparseArray();
        if (queue.size() == 0) {
            AppMethodBeat.m2505o(26070);
            return false;
        }
        this.sKF = true;
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (i < 512 && queue.size() > 0) {
            C36833c c36833c = (C36833c) queue.peek();
            int length = c36833c.cPz.getBytes().length;
            if (i == 0 || i + length <= 512) {
                queue.poll();
                cir cir = new cir();
                cir.xhA = c36833c.sKB;
                cir.xhB = c36833c.cPz;
                cir.wlw = new SKBuiltinBuffer_t().setBuffer(c36833c.dJG);
                if (c36833c.type == 1 || C1855t.m3896kH(c36833c.source)) {
                    cir.xhC = c36833c.source;
                }
                switch (c36833c.type) {
                    case 0:
                        cir.Scene = 1;
                        break;
                    case 1:
                        cir.Scene = 4;
                        break;
                    case 2:
                        cir.Scene = 2;
                        break;
                    case 3:
                        cir.Scene = 3;
                        break;
                }
                C4990ab.m7411d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", Integer.valueOf(c36833c.type), Integer.valueOf(cir.Scene), c36833c.f15476id);
                linkedList.add(cir);
                this.sKE.put(c36833c.sKB, c36833c);
            }
            i += length;
        }
        this.sKG = new C35329b(linkedList);
        C9638aw.m17182Rg().mo14541a(this.sKG, 0);
        this.start = System.currentTimeMillis();
        this.sKI.mo16770ae(60000, 60000);
        AppMethodBeat.m2505o(26070);
        return true;
    }

    public final void cHJ() {
        this.sKG = null;
        this.sKF = false;
    }

    public final void init() {
        AppMethodBeat.m2504i(26071);
        C9638aw.m17182Rg().mo14539a(631, (C1202f) this);
        AppMethodBeat.m2505o(26071);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(26072);
        if (this.sKG != c1207m) {
            C4990ab.m7412e("MicroMsg.WorkingTranslate", "not my translate work");
            AppMethodBeat.m2505o(26072);
            return;
        }
        int size;
        this.sKI.stopTimer();
        C4990ab.m7411d("MicroMsg.WorkingTranslate", "translate take time : %s", Long.valueOf(System.currentTimeMillis() - this.start));
        String str2 = "MicroMsg.WorkingTranslate";
        String str3 = "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (((C35329b) c1207m).sKv != null) {
            size = ((C35329b) c1207m).sKv.size();
        } else {
            size = 0;
        }
        objArr[3] = Integer.valueOf(size);
        C4990ab.m7411d(str2, str3, objArr);
        cHJ();
        this.sKH.mo56073a(i2, this.sKE, ((C35329b) c1207m).sKv);
        AppMethodBeat.m2505o(26072);
    }
}
