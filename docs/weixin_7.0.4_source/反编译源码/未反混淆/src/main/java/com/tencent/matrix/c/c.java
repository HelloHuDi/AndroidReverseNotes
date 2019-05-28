package com.tencent.matrix.c;

import java.util.HashSet;

public class c {
    private final a bWx;
    private final HashSet<String> bWy = new HashSet();

    public interface a {
        void onDetectIssue(b bVar);
    }

    public c(a aVar) {
        this.bWx = aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(b bVar) {
        if (this.bWx == null) {
            throw new RuntimeException("publish issue, but issue listener is null");
        }
        this.bWx.onDetectIssue(bVar);
    }

    /* Access modifiers changed, original: protected */
    public boolean cg(String str) {
        if (str == null) {
            return false;
        }
        return this.bWy.contains(str);
    }

    /* Access modifiers changed, original: protected */
    public void cf(String str) {
        if (str != null) {
            this.bWy.add(str);
        }
    }
}
