package com.tencent.c.a.a;

import android.content.Context;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o extends q {
    public o(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zO() {
        AppMethodBeat.i(125735);
        boolean q = s.q(this.context, "android.permission.WRITE_SETTINGS");
        AppMethodBeat.o(125735);
        return q;
    }

    /* Access modifiers changed, original: protected|final */
    public final String read() {
        String string;
        AppMethodBeat.i(125736);
        synchronized (this) {
            try {
                s.zX();
                string = System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125736);
            }
        }
        return string;
    }

    /* Access modifiers changed, original: protected|final */
    public final void write(String str) {
        AppMethodBeat.i(125737);
        synchronized (this) {
            try {
                s.zX();
                p.aH(this.context).u(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125737);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final a zP() {
        a aVar;
        AppMethodBeat.i(125738);
        synchronized (this) {
            try {
                aVar = new a(System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=")));
                new StringBuilder("read readCheckEntity from Settings.System:").append(aVar.toString());
                s.zX();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125738);
            }
        }
        return aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        AppMethodBeat.i(125739);
        synchronized (this) {
            try {
                new StringBuilder("write CheckEntity to Settings.System:").append(aVar.toString());
                s.zX();
                p.aH(this.context).u(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), aVar.toString());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125739);
            }
        }
    }
}
