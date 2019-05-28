package com.tencent.recovery.config;

import java.util.ArrayList;
import java.util.List;

public class Express {
    public List<List<ExpressItem>> Ara = new ArrayList();

    public String toString() {
        return this.Ara.toString();
    }

    /* renamed from: fA */
    public final void mo11990fA(List<ExpressItem> list) {
        this.Ara.add(list);
    }
}
