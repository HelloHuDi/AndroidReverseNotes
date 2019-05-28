package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

public final class a {
    public ak handler = new ak(Looper.getMainLooper());
    LinkedList<a> jyk = new LinkedList();

    class a {
        public Object obj;
        public int type;

        public a(int i, Object obj) {
            this.type = i;
            this.obj = obj;
        }
    }

    public a() {
        AppMethodBeat.i(17685);
        AppMethodBeat.o(17685);
    }

    public final boolean g(final int i, final Object obj) {
        AppMethodBeat.i(17686);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17683);
                a.this.jyk.add(new a(i, obj));
                AppMethodBeat.o(17683);
            }
        });
        AppMethodBeat.o(17686);
        return true;
    }
}
