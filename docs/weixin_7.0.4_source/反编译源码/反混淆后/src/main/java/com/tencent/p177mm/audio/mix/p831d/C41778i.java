package com.tencent.p177mm.audio.mix.p831d;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.audio.mix.d.i */
public class C41778i implements Comparable<C41778i>, Runnable {
    private static int cmm = 1000;
    protected long cmn;
    protected String name = "";
    protected final int priority;

    public /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(137082);
        C41778i c41778i = (C41778i) obj;
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.cmn) / ((long) cmm));
        int i = this.priority;
        if (abs > 0) {
            i += abs;
        }
        i = c41778i.priority - i;
        AppMethodBeat.m2505o(137082);
        return i;
    }

    public C41778i(String str) {
        AppMethodBeat.m2504i(137081);
        this.name = str;
        this.cmn = System.currentTimeMillis();
        this.priority = 5;
        AppMethodBeat.m2505o(137081);
    }

    public void run() {
    }

    public void reset() {
    }
}
