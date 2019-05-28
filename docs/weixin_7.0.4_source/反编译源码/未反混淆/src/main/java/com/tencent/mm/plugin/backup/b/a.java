package com.tencent.mm.plugin.backup.b;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a {
    private static String TAG = "MicroMsg.BackupBaseModel";
    private static LinkedList<a> jqD = new LinkedList();

    public abstract void aSp();

    public static void a(a aVar) {
        jqD.add(aVar);
    }

    public static void aSo() {
        Iterator it = jqD.iterator();
        while (it.hasNext()) {
            ((a) it.next()).aSp();
        }
        jqD.clear();
    }
}
