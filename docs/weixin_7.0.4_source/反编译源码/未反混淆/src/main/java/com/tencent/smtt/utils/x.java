package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class x {
    private b a = null;
    private b b = null;

    class a {
        private String b;
        private long c;
        private long d;

        a(String str, long j, long j2) {
            this.b = str;
            this.c = j;
            this.d = j2;
        }

        /* Access modifiers changed, original: 0000 */
        public long a() {
            return this.c;
        }

        /* Access modifiers changed, original: 0000 */
        public long b() {
            return this.d;
        }
    }

    class b {
        private Map<String, a> b = new HashMap();

        b(File file) {
            AppMethodBeat.i(65314);
            this.b.clear();
            a(file);
            AppMethodBeat.o(65314);
        }

        private void a(File file) {
            AppMethodBeat.i(65315);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null || VERSION.SDK_INT < 26) {
                    for (File a : listFiles) {
                        a(a);
                    }
                    AppMethodBeat.o(65315);
                    return;
                }
                AppMethodBeat.o(65315);
                return;
            }
            if (file.isFile()) {
                a(file.getName(), file.length(), file.lastModified());
            }
            AppMethodBeat.o(65315);
        }

        private void a(String str, long j, long j2) {
            AppMethodBeat.i(65316);
            if (str != null && str.length() > 0 && j > 0 && j2 > 0) {
                a aVar = new a(str, j, j2);
                if (!this.b.containsKey(str)) {
                    this.b.put(str, aVar);
                }
            }
            AppMethodBeat.o(65316);
        }

        /* Access modifiers changed, original: 0000 */
        public Map<String, a> a() {
            return this.b;
        }
    }

    private boolean a(b bVar, b bVar2) {
        AppMethodBeat.i(65320);
        if (bVar == null || bVar.a() == null || bVar2 == null || bVar2.a() == null) {
            AppMethodBeat.o(65320);
            return false;
        }
        Map a = bVar.a();
        Map a2 = bVar2.a();
        for (Entry entry : a.entrySet()) {
            String str = (String) entry.getKey();
            a aVar = (a) entry.getValue();
            if (a2.containsKey(str)) {
                a aVar2 = (a) a2.get(str);
                if (aVar.a() == aVar2.a()) {
                    if (aVar.b() != aVar2.b()) {
                    }
                }
                AppMethodBeat.o(65320);
                return false;
            }
            AppMethodBeat.o(65320);
            return false;
        }
        AppMethodBeat.o(65320);
        return true;
    }

    public void a(File file) {
        AppMethodBeat.i(65317);
        this.a = new b(file);
        AppMethodBeat.o(65317);
    }

    public boolean a() {
        AppMethodBeat.i(65319);
        if (this.b == null || this.a == null) {
            AppMethodBeat.o(65319);
            return false;
        } else if (this.b.a().size() == this.a.a().size() && a(this.a, this.b)) {
            AppMethodBeat.o(65319);
            return true;
        } else {
            AppMethodBeat.o(65319);
            return false;
        }
    }

    public void b(File file) {
        AppMethodBeat.i(65318);
        this.b = new b(file);
        AppMethodBeat.o(65318);
    }
}
