package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.translate.a.c.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import java.util.LinkedList;
import java.util.Queue;

public final class d implements f {
    public int index;
    public SparseArray<c> sKE = null;
    public boolean sKF = false;
    public b sKG;
    a sKH;
    public ap sKI = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(26068);
            if (d.this.sKF) {
                ab.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", Integer.valueOf(d.this.index));
                d.this.cHJ();
                d.this.sKH.a(-1, d.this.sKE, null);
            }
            AppMethodBeat.o(26068);
            return false;
        }
    }, false);
    private long start;

    public d(int i, a aVar) {
        AppMethodBeat.i(26069);
        this.index = i;
        this.sKH = aVar;
        AppMethodBeat.o(26069);
    }

    public final boolean e(Queue<c> queue) {
        AppMethodBeat.i(26070);
        if (this.sKF) {
            AppMethodBeat.o(26070);
            return false;
        }
        this.sKE = new SparseArray();
        if (queue.size() == 0) {
            AppMethodBeat.o(26070);
            return false;
        }
        this.sKF = true;
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (i < 512 && queue.size() > 0) {
            c cVar = (c) queue.peek();
            int length = cVar.cPz.getBytes().length;
            if (i == 0 || i + length <= 512) {
                queue.poll();
                cir cir = new cir();
                cir.xhA = cVar.sKB;
                cir.xhB = cVar.cPz;
                cir.wlw = new SKBuiltinBuffer_t().setBuffer(cVar.dJG);
                if (cVar.type == 1 || t.kH(cVar.source)) {
                    cir.xhC = cVar.source;
                }
                switch (cVar.type) {
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
                ab.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", Integer.valueOf(cVar.type), Integer.valueOf(cir.Scene), cVar.id);
                linkedList.add(cir);
                this.sKE.put(cVar.sKB, cVar);
            }
            i += length;
        }
        this.sKG = new b(linkedList);
        aw.Rg().a(this.sKG, 0);
        this.start = System.currentTimeMillis();
        this.sKI.ae(60000, 60000);
        AppMethodBeat.o(26070);
        return true;
    }

    public final void cHJ() {
        this.sKG = null;
        this.sKF = false;
    }

    public final void init() {
        AppMethodBeat.i(26071);
        aw.Rg().a(631, (f) this);
        AppMethodBeat.o(26071);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(26072);
        if (this.sKG != mVar) {
            ab.e("MicroMsg.WorkingTranslate", "not my translate work");
            AppMethodBeat.o(26072);
            return;
        }
        int size;
        this.sKI.stopTimer();
        ab.d("MicroMsg.WorkingTranslate", "translate take time : %s", Long.valueOf(System.currentTimeMillis() - this.start));
        String str2 = "MicroMsg.WorkingTranslate";
        String str3 = "errType : %s, errCode : %s, errMsg : %s, translatedMsg.size() : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        if (((b) mVar).sKv != null) {
            size = ((b) mVar).sKv.size();
        } else {
            size = 0;
        }
        objArr[3] = Integer.valueOf(size);
        ab.d(str2, str3, objArr);
        cHJ();
        this.sKH.a(i2, this.sKE, ((b) mVar).sKv);
        AppMethodBeat.o(26072);
    }
}
