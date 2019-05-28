package com.tencent.magicbrush.handler.glfont;

import android.graphics.Rect;
import com.tencent.magicbrush.handler.glfont.C37418c.C25715c;
import com.tencent.magicbrush.handler.glfont.C37418c.C37419a;
import com.tencent.magicbrush.handler.glfont.C37418c.C37420b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.magicbrush.handler.glfont.k */
final class C45131k implements C37418c {
    private C37419a bTH = new C37419a();
    private int bTI;
    private C25715c bTJ = new C25715c();
    /* renamed from: hd */
    private ArrayList<C37420b> f17850hd = new ArrayList();
    private int mHeight;
    private int mWidth;

    C45131k() {
        AppMethodBeat.m2504i(115956);
        AppMethodBeat.m2505o(115956);
    }

    public final void init(int i, int i2) {
        AppMethodBeat.m2504i(115957);
        this.mWidth = i;
        this.mHeight = i2;
        reset();
        AppMethodBeat.m2505o(115957);
    }

    /* renamed from: a */
    public final void mo60253a(int i, int i2, Rect rect) {
        AppMethodBeat.m2504i(115958);
        if (rect == null) {
            AppMethodBeat.m2505o(115958);
        } else if (i <= 0 || i2 <= 0) {
            rect.setEmpty();
            AppMethodBeat.m2505o(115958);
        } else {
            C37420b c37420b;
            int i3;
            int i4;
            C25715c c25715c;
            C25715c c25715c2 = this.bTJ;
            c25715c2.f5424x = 0;
            c25715c2.f5425y = 0;
            c25715c2.width = i;
            c25715c2.height = i2;
            int i5 = -1;
            int i6 = 0;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MAX_VALUE;
            while (i6 < this.f17850hd.size()) {
                int i9;
                c37420b = (C37420b) this.f17850hd.get(i6);
                if (c37420b.f16069x + i > this.mWidth - 1) {
                    i9 = -1;
                } else {
                    i3 = c37420b.f16070y;
                    i9 = i6;
                    int i10 = i;
                    while (i10 > 0) {
                        c37420b = (C37420b) this.f17850hd.get(i9);
                        if (c37420b.f16070y > i3) {
                            i3 = c37420b.f16070y;
                        }
                        if (i3 + i2 > this.mHeight - 1) {
                            i9 = -1;
                            break;
                        } else {
                            i10 -= c37420b.f16071z;
                            i9++;
                        }
                    }
                    i9 = i3;
                }
                if (i9 >= 0) {
                    c37420b = (C37420b) this.f17850hd.get(i6);
                    if (i9 + i2 < i8 || (i9 + i2 == i8 && c37420b.f16071z > 0 && c37420b.f16071z < i7)) {
                        i5 = i9 + i2;
                        i3 = c37420b.f16071z;
                        c25715c2.f5424x = c37420b.f16069x;
                        c25715c2.f5425y = i9;
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
                c25715c2.f5424x = -1;
                c25715c2.f5425y = -1;
                c25715c2.width = 0;
                c25715c2.height = 0;
                c25715c = c25715c2;
            } else {
                C37420b c37420b2;
                c37420b = this.bTH.mo60258yG();
                c37420b.f16069x = c25715c2.f5424x;
                c37420b.f16070y = c25715c2.f5425y + i2;
                c37420b.f16071z = i;
                this.f17850hd.add(i5, c37420b);
                i4 = i5 + 1;
                while (true) {
                    i5 = i4;
                    if (i5 >= this.f17850hd.size()) {
                        break;
                    }
                    c37420b = (C37420b) this.f17850hd.get(i5);
                    c37420b2 = (C37420b) this.f17850hd.get(i5 - 1);
                    if (c37420b.f16069x >= c37420b2.f16069x + c37420b2.f16071z) {
                        break;
                    }
                    i3 = (c37420b2.f16071z + c37420b2.f16069x) - c37420b.f16069x;
                    c37420b.f16069x += i3;
                    c37420b.f16071z -= i3;
                    if (c37420b.f16071z > 0) {
                        break;
                    }
                    this.bTH.mo60256a((C37420b) this.f17850hd.remove(i5));
                    i4 = (i5 - 1) + 1;
                }
                i4 = 0;
                while (true) {
                    i5 = i4;
                    if (i5 >= this.f17850hd.size() - 1) {
                        break;
                    }
                    c37420b = (C37420b) this.f17850hd.get(i5);
                    c37420b2 = (C37420b) this.f17850hd.get(i5 + 1);
                    if (c37420b.f16070y == c37420b2.f16070y) {
                        c37420b.f16071z = c37420b2.f16071z + c37420b.f16071z;
                        this.bTH.mo60256a((C37420b) this.f17850hd.remove(i5 + 1));
                        i5--;
                    }
                    i4 = i5 + 1;
                }
                this.bTI += i * i2;
                c25715c = c25715c2;
            }
            if (c25715c.f5424x < 0 || c25715c.f5425y < 0) {
                rect.setEmpty();
                AppMethodBeat.m2505o(115958);
                return;
            }
            rect.set(c25715c.f5424x, c25715c.f5425y, (c25715c.f5424x + i) - 1, (c25715c.f5425y + i2) - 1);
            AppMethodBeat.m2505o(115958);
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(115959);
        this.bTI = 0;
        this.bTH.mo60257d(this.f17850hd);
        C37420b yG = this.bTH.mo60258yG();
        yG.mo60259fT(this.mWidth - 2);
        this.f17850hd.add(yG);
        AppMethodBeat.m2505o(115959);
    }
}
