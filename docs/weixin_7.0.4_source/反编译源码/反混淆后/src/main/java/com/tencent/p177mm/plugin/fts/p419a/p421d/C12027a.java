package com.tencent.p177mm.plugin.fts.p419a.p421d;

/* renamed from: com.tencent.mm.plugin.fts.a.d.a */
public abstract class C12027a implements C20847d {
    public /* synthetic */ int compareTo(Object obj) {
        C20847d c20847d = (C20847d) obj;
        if (getPriority() < c20847d.getPriority()) {
            return -1;
        }
        if (getPriority() > c20847d.getPriority()) {
            return 1;
        }
        return 0;
    }
}
