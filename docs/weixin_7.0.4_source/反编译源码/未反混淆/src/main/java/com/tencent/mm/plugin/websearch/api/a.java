package com.tencent.mm.plugin.websearch.api;

import android.os.Bundle;
import com.tencent.mm.ai.m;
import com.tencent.mm.protocal.protobuf.cmg;
import java.util.LinkedList;

public abstract class a extends m {
    protected int Lp;
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

    public final void HN(int i) {
        this.tZt = i;
    }

    public final boolean cUP() {
        return this.Lp == 0;
    }

    public final Bundle cUQ() {
        return this.tZv;
    }

    public final String bAk() {
        return this.tZu;
    }

    public void ax(LinkedList<cmg> linkedList) {
    }

    public final String cUR() {
        return this.cIz;
    }
}
