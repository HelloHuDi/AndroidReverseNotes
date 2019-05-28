package com.tencent.tencentmap.mapsdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class bf {
    private List<String> a = new ArrayList();
    private List<String> b = new ArrayList();
    private final int c = 300;

    public bf() {
        AppMethodBeat.i(100782);
        AppMethodBeat.o(100782);
    }

    public synchronized boolean a(String str) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(100783);
            if (str == null || str.trim().length() == 0) {
                AppMethodBeat.o(100783);
            } else if (this.b.contains(str)) {
                AppMethodBeat.o(100783);
            } else {
                z = true;
                AppMethodBeat.o(100783);
            }
        }
        return z;
    }

    private void a(List<String> list) {
        AppMethodBeat.i(100784);
        if (list == null) {
            AppMethodBeat.o(100784);
        } else if (list.size() <= 300) {
            AppMethodBeat.o(100784);
        } else {
            list.remove(0);
            AppMethodBeat.o(100784);
        }
    }

    public synchronized void b(String str) {
        AppMethodBeat.i(100785);
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.o(100785);
        } else if (this.b.contains(str)) {
            this.b.remove(str);
            this.b.add(str);
            AppMethodBeat.o(100785);
        } else if (this.a.contains(str)) {
            a(this.b);
            this.b.add(str);
            this.a.remove(str);
            AppMethodBeat.o(100785);
        } else {
            a(this.a);
            this.a.add(str);
            AppMethodBeat.o(100785);
        }
    }
}
