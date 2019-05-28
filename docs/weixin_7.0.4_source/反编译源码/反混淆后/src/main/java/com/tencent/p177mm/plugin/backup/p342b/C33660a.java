package com.tencent.p177mm.plugin.backup.p342b;

import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.backup.b.a */
public abstract class C33660a {
    private static String TAG = "MicroMsg.BackupBaseModel";
    private static LinkedList<C33660a> jqD = new LinkedList();

    public abstract void aSp();

    /* renamed from: a */
    public static void m54968a(C33660a c33660a) {
        jqD.add(c33660a);
    }

    public static void aSo() {
        Iterator it = jqD.iterator();
        while (it.hasNext()) {
            ((C33660a) it.next()).aSp();
        }
        jqD.clear();
    }
}
