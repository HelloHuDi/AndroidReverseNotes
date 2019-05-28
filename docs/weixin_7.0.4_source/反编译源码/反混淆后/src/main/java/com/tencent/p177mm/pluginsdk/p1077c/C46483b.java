package com.tencent.p177mm.pluginsdk.p1077c;

import com.tencent.p177mm.p230g.p231a.C9403kp;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.pluginsdk.c.b */
public abstract class C46483b extends C4884c<C9403kp> {
    protected ArrayList<String> vaJ;

    /* renamed from: a */
    public abstract void mo14634a(int i, int i2, String str, C4883b c4883b);

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        C9403kp c9403kp = (C9403kp) c4883b;
        if ((c9403kp instanceof C9403kp) && c9403kp.cGw.cGx != null && this.vaJ.contains(c9403kp.cGw.cGx.getClass().getName())) {
            mo14634a(c9403kp.cGw.errType, c9403kp.cGw.errCode, c9403kp.cGw.aIm, c9403kp.cGw.cGx);
        }
        return false;
    }

    public C46483b() {
        super(0);
        this.vaJ = new ArrayList(3);
        this.xxI = C9403kp.class.getName().hashCode();
    }

    /* renamed from: a */
    public static void m87699a(String str, C46483b c46483b) {
        if (!c46483b.vaJ.contains(str)) {
            c46483b.vaJ.add(str);
        }
        C4879a.xxA.mo10052c(c46483b);
        C14825e.ait(str);
    }

    /* renamed from: b */
    public static void m87700b(String str, C46483b c46483b) {
        C14825e.aiu(str);
        C4879a.xxA.mo10053d(c46483b);
        if (c46483b.vaJ.contains(str)) {
            c46483b.vaJ.remove(str);
        }
    }
}
