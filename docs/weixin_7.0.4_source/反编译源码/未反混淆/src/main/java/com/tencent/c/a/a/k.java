package com.tencent.c.a.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k extends q {
    public k(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final String read() {
        String string;
        AppMethodBeat.i(125747);
        synchronized (this) {
            try {
                s.zX();
                string = PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125747);
            }
        }
        return string;
    }

    /* Access modifiers changed, original: protected|final */
    public final void write(String str) {
        AppMethodBeat.i(125748);
        synchronized (this) {
            try {
                s.zX();
                Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                edit.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
                edit.commit();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125748);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean zO() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final a zP() {
        a aVar;
        AppMethodBeat.i(125749);
        synchronized (this) {
            try {
                aVar = new a(PreferenceManager.getDefaultSharedPreferences(this.context).getString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), null));
                new StringBuilder("read CheckEntity from sharedPreferences:").append(aVar.toString());
                s.zX();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125749);
            }
        }
        return aVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(a aVar) {
        AppMethodBeat.i(125750);
        synchronized (this) {
            try {
                new StringBuilder("write CheckEntity to sharedPreferences:").append(aVar.toString());
                s.zX();
                Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                edit.putString(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), aVar.toString());
                edit.commit();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(125750);
            }
        }
    }
}
