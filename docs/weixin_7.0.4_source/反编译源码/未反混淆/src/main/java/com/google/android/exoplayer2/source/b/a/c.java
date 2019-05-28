package com.google.android.exoplayer2.source.b.a;

import java.util.Collections;
import java.util.List;

public abstract class c {
    public final String bjZ;
    public final List<String> bka;

    protected c(String str, List<String> list) {
        this.bjZ = str;
        this.bka = Collections.unmodifiableList(list);
    }
}
