package com.tencent.matrix.p156c;

import java.util.HashSet;

/* renamed from: com.tencent.matrix.c.c */
public class C1064c {
    private final C1063a bWx;
    private final HashSet<String> bWy = new HashSet();

    /* renamed from: com.tencent.matrix.c.c$a */
    public interface C1063a {
        void onDetectIssue(C1062b c1062b);
    }

    public C1064c(C1063a c1063a) {
        this.bWx = c1063a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo4200b(C1062b c1062b) {
        if (this.bWx == null) {
            throw new RuntimeException("publish issue, but issue listener is null");
        }
        this.bWx.onDetectIssue(c1062b);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cg */
    public boolean mo4202cg(String str) {
        if (str == null) {
            return false;
        }
        return this.bWy.contains(str);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cf */
    public void mo4201cf(String str) {
        if (str != null) {
            this.bWy.add(str);
        }
    }
}
