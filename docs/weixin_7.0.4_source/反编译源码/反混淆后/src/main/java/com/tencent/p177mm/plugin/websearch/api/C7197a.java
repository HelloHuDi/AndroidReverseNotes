package com.tencent.p177mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.protocal.protobuf.cmg;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.websearch.api.a */
public abstract class C7197a extends C1207m {
    /* renamed from: Lp */
    protected int f1969Lp;
    protected String cIz;
    protected int gOW;
    protected int tZt;
    protected String tZu;
    protected Bundle tZv;

    public abstract String abH();

    public abstract int abI();

    public final int cUO() {
        return this.tZt;
    }

    /* renamed from: HN */
    public final void mo15501HN(int i) {
        this.tZt = i;
    }

    public final boolean cUP() {
        return this.f1969Lp == 0;
    }

    public final Bundle cUQ() {
        return this.tZv;
    }

    public final String bAk() {
        return this.tZu;
    }

    /* renamed from: ax */
    public void mo15504ax(LinkedList<cmg> linkedList) {
    }

    public final String cUR() {
        return this.cIz;
    }
}
