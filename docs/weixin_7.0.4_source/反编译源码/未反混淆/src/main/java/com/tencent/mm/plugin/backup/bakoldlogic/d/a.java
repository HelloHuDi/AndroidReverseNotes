package com.tencent.mm.plugin.backup.bakoldlogic.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.LinkedList;

public final class a {
    ak handler = new ak(Looper.getMainLooper());
    public LinkedList<a> jyk = new LinkedList();

    public class a {
        public Object obj;
        public int type;

        public a(int i, Object obj) {
            this.type = i;
            this.obj = obj;
        }
    }

    public a() {
        AppMethodBeat.i(18000);
        AppMethodBeat.o(18000);
    }

    public final boolean g(final int i, final Object obj) {
        AppMethodBeat.i(18001);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(17998);
                a.this.jyk.add(new a(i, obj));
                AppMethodBeat.o(17998);
            }
        });
        AppMethodBeat.o(18001);
        return true;
    }
}
