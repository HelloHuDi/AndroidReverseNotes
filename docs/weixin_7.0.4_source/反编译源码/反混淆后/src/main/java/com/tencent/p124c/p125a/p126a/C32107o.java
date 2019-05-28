package com.tencent.p124c.p125a.p126a;

import android.content.Context;
import android.provider.Settings.System;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.c.a.a.o */
public final class C32107o extends C25595q {
    public C32107o(Context context) {
        super(context);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: zO */
    public final boolean mo19819zO() {
        AppMethodBeat.m2504i(125735);
        boolean q = C0916s.m2087q(this.context, "android.permission.WRITE_SETTINGS");
        AppMethodBeat.m2505o(125735);
        return q;
    }

    /* Access modifiers changed, original: protected|final */
    public final String read() {
        String string;
        AppMethodBeat.m2504i(125736);
        synchronized (this) {
            try {
                C0916s.m2088zX();
                string = System.getString(this.context.getContentResolver(), C0916s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="));
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125736);
            }
        }
        return string;
    }

    /* Access modifiers changed, original: protected|final */
    public final void write(String str) {
        AppMethodBeat.m2504i(125737);
        synchronized (this) {
            try {
                C0916s.m2088zX();
                C41658p.m73052aH(this.context).mo67142u(C0916s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125737);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: zP */
    public final C25593a mo19820zP() {
        C25593a c25593a;
        AppMethodBeat.m2504i(125738);
        synchronized (this) {
            try {
                c25593a = new C25593a(System.getString(this.context.getContentResolver(), C0916s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=")));
                new StringBuilder("read readCheckEntity from Settings.System:").append(c25593a.toString());
                C0916s.m2088zX();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125738);
            }
        }
        return c25593a;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo19816a(C25593a c25593a) {
        AppMethodBeat.m2504i(125739);
        synchronized (this) {
            try {
                new StringBuilder("write CheckEntity to Settings.System:").append(c25593a.toString());
                C0916s.m2088zX();
                C41658p.m73052aH(this.context).mo67142u(C0916s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), c25593a.toString());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(125739);
            }
        }
    }
}
