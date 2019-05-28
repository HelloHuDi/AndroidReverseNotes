package com.tencent.p177mm.pluginsdk.p1077c;

import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C9403kp;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.pluginsdk.c.c */
public abstract class C40419c<T extends C4883b> extends C4884c<T> implements C1202f {
    private static HashMap<C4883b, C40419c<? extends C4883b>> fBy = new HashMap();
    private static HashMap<C1207m, C4883b> vaL = new HashMap();
    private int vaK = 0;

    /* renamed from: Jy */
    public abstract int mo24699Jy();

    /* renamed from: a */
    public abstract C4883b mo24700a(int i, C1207m c1207m, T t);

    /* renamed from: b */
    public abstract C1207m mo24701b(T t);

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        if (mo24699Jy() == c1207m.getType()) {
            C4883b c4883b = (C4883b) vaL.remove(c1207m);
            if (c4883b != null) {
                C9403kp c9403kp = new C9403kp();
                c9403kp.cGw.cGx = mo24700a(i2, c1207m, c4883b);
                c9403kp.cGw.errType = i;
                c9403kp.cGw.errCode = i2;
                c9403kp.cGw.aIm = str;
                C4879a.xxA.mo10055m(c9403kp);
            }
        }
    }

    /* renamed from: k */
    public static void m69325k(C4883b c4883b) {
        C1207m c1207m;
        for (Entry entry : vaL.entrySet()) {
            if (entry.getValue() == c4883b) {
                c1207m = (C1207m) entry.getKey();
                break;
            }
        }
        c1207m = null;
        if (c1207m != null) {
            C1720g.m3540Rg().mo14547c(c1207m);
            vaL.remove(c1207m);
        }
    }

    public final void dgW() {
        if (this.vaK == 0) {
            C1720g.m3540Rg().mo14539a(mo24699Jy(), (C1202f) this);
        }
        this.vaK++;
    }

    public final void bIW() {
        if (this.vaK != 0) {
            this.vaK--;
            if (this.vaK == 0) {
                C1720g.m3540Rg().mo14546b(mo24699Jy(), (C1202f) this);
            }
        }
    }

    /* renamed from: l */
    public final void mo63831l(T t) {
        C1207m b = mo24701b(t);
        C1720g.m3540Rg().mo14541a(b, 0);
        vaL.put(b, t);
    }
}
