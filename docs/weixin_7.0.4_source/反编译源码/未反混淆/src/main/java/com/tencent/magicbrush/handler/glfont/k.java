package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import com.tencent.magicbrush.handler.glfont.c.a;
import com.tencent.magicbrush.handler.glfont.c.b;
import com.tencent.magicbrush.handler.glfont.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class k implements c {
    private a bTH = new a();
    private int bTI;
    private c bTJ = new c();
    private ArrayList<b> hd = new ArrayList();
    private int mHeight;
    private int mWidth;

    k() {
        AppMethodBeat.i(115956);
        AppMethodBeat.o(115956);
    }

    public final void init(int i, int i2) {
        AppMethodBeat.i(115957);
        this.mWidth = i;
        this.mHeight = i2;
        reset();
        AppMethodBeat.o(115957);
    }

    public final void a(int i, int i2, Rect rect) {
        AppMethodBeat.i(115958);
        if (rect == null) {
            AppMethodBeat.o(115958);
        } else if (i <= 0 || i2 <= 0) {
            rect.setEmpty();
            AppMethodBeat.o(115958);
        } else {
            b bVar;
            int i3;
            int i4;
            c cVar;
            c cVar2 = this.bTJ;
            cVar2.x = 0;
            cVar2.y = 0;
            cVar2.width = i;
            cVar2.height = i2;
            int i5 = -1;
            int i6 = 0;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MAX_VALUE;
            while (i6 < this.hd.size()) {
                int i9;
                bVar = (b) this.hd.get(i6);
                if (bVar.x + i > this.mWidth - 1) {
                    i9 = -1;
                } else {
                    i3 = bVar.y;
                    i9 = i6;
                    int i10 = i;
                    while (i10 > 0) {
                        bVar = (b) this.hd.get(i9);
                        if (bVar.y > i3) {
                            i3 = bVar.y;
                        }
                        if (i3 + i2 > this.mHeight - 1) {
                            i9 = -1;
                            break;
                        } else {
                            i10 -= bVar.z;
                            i9++;
                        }
                    }
                    i9 = i3;
                }
                if (i9 >= 0) {
                    bVar = (b) this.hd.get(i6);
                    if (i9 + i2 < i8 || (i9 + i2 == i8 && bVar.z > 0 && bVar.z < i7)) {
                        i5 = i9 + i2;
                        i3 = bVar.z;
                        cVar2.x = bVar.x;
                        cVar2.y = i9;
                        i4 = i6;
                        i8 = i5;
                        i6++;
                        i5 = i4;
                        i7 = i3;
                    }
                }
                i4 = i5;
                i3 = i7;
                i6++;
                i5 = i4;
                i7 = i3;
            }
            if (i5 == -1) {
                cVar2.x = -1;
                cVar2.y = -1;
                cVar2.width = 0;
                cVar2.height = 0;
                cVar = cVar2;
            } else {
                b bVar2;
                bVar = this.bTH.yG();
                bVar.x = cVar2.x;
                bVar.y = cVar2.y + i2;
                bVar.z = i;
                this.hd.add(i5, bVar);
                i4 = i5 + 1;
                while (true) {
                    i5 = i4;
                    if (i5 >= this.hd.size()) {
                        break;
                    }
                    bVar = (b) this.hd.get(i5);
                    bVar2 = (b) this.hd.get(i5 - 1);
                    if (bVar.x >= bVar2.x + bVar2.z) {
                        break;
                    }
                    i3 = (bVar2.z + bVar2.x) - bVar.x;
                    bVar.x += i3;
                    bVar.z -= i3;
                    if (bVar.z > 0) {
                        break;
                    }
                    this.bTH.a((b) this.hd.remove(i5));
                    i4 = (i5 - 1) + 1;
                }
                i4 = 0;
                while (true) {
                    i5 = i4;
                    if (i5 >= this.hd.size() - 1) {
                        break;
                    }
                    bVar = (b) this.hd.get(i5);
                    bVar2 = (b) this.hd.get(i5 + 1);
                    if (bVar.y == bVar2.y) {
                        bVar.z = bVar2.z + bVar.z;
                        this.bTH.a((b) this.hd.remove(i5 + 1));
                        i5--;
                    }
                    i4 = i5 + 1;
                }
                this.bTI += i * i2;
                cVar = cVar2;
            }
            if (cVar.x < 0 || cVar.y < 0) {
                rect.setEmpty();
                AppMethodBeat.o(115958);
                return;
            }
            rect.set(cVar.x, cVar.y, (cVar.x + i) - 1, (cVar.y + i2) - 1);
            AppMethodBeat.o(115958);
        }
    }

    public final void reset() {
        AppMethodBeat.i(115959);
        this.bTI = 0;
        this.bTH.d(this.hd);
        b yG = this.bTH.yG();
        yG.fT(this.mWidth - 2);
        this.hd.add(yG);
        AppMethodBeat.o(115959);
    }
}
