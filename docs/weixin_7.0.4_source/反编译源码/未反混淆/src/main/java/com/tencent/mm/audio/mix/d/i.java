package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class i implements Comparable<i>, Runnable {
    private static int cmm = 1000;
    protected long cmn;
    protected String name = "";
    protected final int priority;

    public /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(137082);
        i iVar = (i) obj;
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.cmn) / ((long) cmm));
        int i = this.priority;
        if (abs > 0) {
            i += abs;
        }
        i = iVar.priority - i;
        AppMethodBeat.o(137082);
        return i;
    }

    public i(String str) {
        AppMethodBeat.i(137081);
        this.name = str;
        this.cmn = System.currentTimeMillis();
        this.priority = 5;
        AppMethodBeat.o(137081);
    }

    public void run() {
    }

    public void reset() {
    }
}
