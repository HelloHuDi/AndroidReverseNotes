package com.tencent.mm.audio.mix.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.b;
import java.util.ArrayList;
import java.util.Arrays;

public class a {
    private static a ckI;
    private ArrayList<b> ckJ = new ArrayList();

    private a() {
        AppMethodBeat.i(136979);
        AppMethodBeat.o(136979);
    }

    public static a Dg() {
        AppMethodBeat.i(136980);
        if (ckI == null) {
            synchronized (a.class) {
                try {
                    if (ckI == null) {
                        ckI = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(136980);
                    }
                }
            }
        }
        a aVar = ckI;
        AppMethodBeat.o(136980);
        return aVar;
    }

    public final synchronized b Dh() {
        b bVar;
        AppMethodBeat.i(136981);
        if (this.ckJ.size() > 0) {
            bVar = (b) this.ckJ.remove(this.ckJ.size() - 1);
            AppMethodBeat.o(136981);
        } else {
            bVar = new b();
            AppMethodBeat.o(136981);
        }
        return bVar;
    }

    public final synchronized void a(b bVar) {
        AppMethodBeat.i(136982);
        if (bVar == null || bVar.ckv == null) {
            AppMethodBeat.o(136982);
        } else {
            bVar.channels = 0;
            bVar.sampleRate = 0;
            bVar.ckw.clear();
            Arrays.fill(bVar.ckv, 0, bVar.ckv.length, (byte) 0);
            this.ckJ.add(0, bVar);
            AppMethodBeat.o(136982);
        }
    }
}
