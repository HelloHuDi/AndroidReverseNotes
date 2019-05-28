package com.tencent.p177mm.p612ui.contact;

import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.o */
public abstract class C40845o extends C36252n {
    protected List<String> elZ;
    protected boolean znm;

    public C40845o(C36251l c36251l, List<String> list, boolean z, boolean z2, boolean z3) {
        this(c36251l, list, z, z2, 0, z3);
    }

    public C40845o(C36251l c36251l, List<String> list, boolean z, boolean z2) {
        this(c36251l, (List) list, z, z2, 0);
    }

    public C40845o(C36251l c36251l, List<String> list, boolean z, boolean z2, int i) {
        this(c36251l, list, z, z2, i, false);
    }

    private C40845o(C36251l c36251l, List<String> list, boolean z, boolean z2, int i, boolean z3) {
        super(c36251l, z2, i, z3);
        this.elZ = list;
        this.znm = z;
    }

    public int arM(String str) {
        return -1;
    }
}
