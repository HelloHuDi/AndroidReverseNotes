package com.tencent.recovery.config;

import java.util.ArrayList;
import java.util.List;

public class Express {
    public List<List<ExpressItem>> Ara = new ArrayList();

    public String toString() {
        return this.Ara.toString();
    }

    public final void fA(List<ExpressItem> list) {
        this.Ara.add(list);
    }
}
