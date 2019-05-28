package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.c.a.a.k */
final class C8758k extends C25595q {
    public C8758k(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    public final String read() {
        String string;
        AppMethodBeat.m2504i(125747);
        synchronized (this) {
            try {
                C0916s.m2088zX();
                string = PreferenceManager.getDefaultSharedPreferences(this.context).getString(C0916s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125747);
            }
        }
        return string;
    }

    /* Access modifiers changed, original: protected|final */
    public final void write(String str) {
        AppMethodBeat.m2504i(125748);
        synchronized (this) {
            try {
                C0916s.m2088zX();
                Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                edit.putString(C0916s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
                edit.commit();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125748);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: zO */
    public final boolean mo19819zO() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: zP */
    public final C25593a mo19820zP() {
        C25593a c25593a;
        AppMethodBeat.m2504i(125749);
        synchronized (this) {
            try {
                c25593a = new C25593a(PreferenceManager.getDefaultSharedPreferences(this.context).getString(C0916s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), null));
                new StringBuilder("read CheckEntity from sharedPreferences:").append(c25593a.toString());
                C0916s.m2088zX();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125749);
            }
        }
        return c25593a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo19816a(C25593a c25593a) {
        AppMethodBeat.m2504i(125750);
        synchronized (this) {
            try {
                new StringBuilder("write CheckEntity to sharedPreferences:").append(c25593a.toString());
                C0916s.m2088zX();
                Editor edit = PreferenceManager.getDefaultSharedPreferences(this.context).edit();
                edit.putString(C0916s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), c25593a.toString());
                edit.commit();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125750);
            }
        }
    }
}
