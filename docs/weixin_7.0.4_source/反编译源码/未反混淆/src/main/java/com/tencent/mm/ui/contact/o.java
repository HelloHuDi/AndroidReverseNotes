package com.tencent.mm.ui.contact;

import java.util.List;

public abstract class o extends n {
    protected List<String> elZ;
    protected boolean znm;

    public o(l lVar, List<String> list, boolean z, boolean z2, boolean z3) {
        this(lVar, list, z, z2, 0, z3);
    }

    public o(l lVar, List<String> list, boolean z, boolean z2) {
        this(lVar, (List) list, z, z2, 0);
    }

    public o(l lVar, List<String> list, boolean z, boolean z2, int i) {
        this(lVar, list, z, z2, i, false);
    }

    private o(l lVar, List<String> list, boolean z, boolean z2, int i, boolean z3) {
        super(lVar, z2, i, z3);
        this.elZ = list;
        this.znm = z;
    }

    public int arM(String str) {
        return -1;
    }
}
