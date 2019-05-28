package com.tencent.smtt.utils;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.smtt.utils.x */
public class C36449x {
    /* renamed from: a */
    private C36448b f15204a = null;
    /* renamed from: b */
    private C36448b f15205b = null;

    /* renamed from: com.tencent.smtt.utils.x$a */
    class C24289a {
        /* renamed from: b */
        private String f4582b;
        /* renamed from: c */
        private long f4583c;
        /* renamed from: d */
        private long f4584d;

        C24289a(String str, long j, long j2) {
            this.f4582b = str;
            this.f4583c = j;
            this.f4584d = j2;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public long mo40379a() {
            return this.f4583c;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: b */
        public long mo40380b() {
            return this.f4584d;
        }
    }

    /* renamed from: com.tencent.smtt.utils.x$b */
    class C36448b {
        /* renamed from: b */
        private Map<String, C24289a> f15203b = new HashMap();

        C36448b(File file) {
            AppMethodBeat.m2504i(65314);
            this.f15203b.clear();
            m60209a(file);
            AppMethodBeat.m2505o(65314);
        }

        /* renamed from: a */
        private void m60209a(File file) {
            AppMethodBeat.m2504i(65315);
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null || VERSION.SDK_INT < 26) {
                    for (File a : listFiles) {
                        m60209a(a);
                    }
                    AppMethodBeat.m2505o(65315);
                    return;
                }
                AppMethodBeat.m2505o(65315);
                return;
            }
            if (file.isFile()) {
                m60210a(file.getName(), file.length(), file.lastModified());
            }
            AppMethodBeat.m2505o(65315);
        }

        /* renamed from: a */
        private void m60210a(String str, long j, long j2) {
            AppMethodBeat.m2504i(65316);
            if (str != null && str.length() > 0 && j > 0 && j2 > 0) {
                C24289a c24289a = new C24289a(str, j, j2);
                if (!this.f15203b.containsKey(str)) {
                    this.f15203b.put(str, c24289a);
                }
            }
            AppMethodBeat.m2505o(65316);
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public Map<String, C24289a> mo57640a() {
            return this.f15203b;
        }
    }

    /* renamed from: a */
    private boolean m60212a(C36448b c36448b, C36448b c36448b2) {
        AppMethodBeat.m2504i(65320);
        if (c36448b == null || c36448b.mo57640a() == null || c36448b2 == null || c36448b2.mo57640a() == null) {
            AppMethodBeat.m2505o(65320);
            return false;
        }
        Map a = c36448b.mo57640a();
        Map a2 = c36448b2.mo57640a();
        for (Entry entry : a.entrySet()) {
            String str = (String) entry.getKey();
            C24289a c24289a = (C24289a) entry.getValue();
            if (a2.containsKey(str)) {
                C24289a c24289a2 = (C24289a) a2.get(str);
                if (c24289a.mo40379a() == c24289a2.mo40379a()) {
                    if (c24289a.mo40380b() != c24289a2.mo40380b()) {
                    }
                }
                AppMethodBeat.m2505o(65320);
                return false;
            }
            AppMethodBeat.m2505o(65320);
            return false;
        }
        AppMethodBeat.m2505o(65320);
        return true;
    }

    /* renamed from: a */
    public void mo57641a(File file) {
        AppMethodBeat.m2504i(65317);
        this.f15204a = new C36448b(file);
        AppMethodBeat.m2505o(65317);
    }

    /* renamed from: a */
    public boolean mo57642a() {
        AppMethodBeat.m2504i(65319);
        if (this.f15205b == null || this.f15204a == null) {
            AppMethodBeat.m2505o(65319);
            return false;
        } else if (this.f15205b.mo57640a().size() == this.f15204a.mo57640a().size() && m60212a(this.f15204a, this.f15205b)) {
            AppMethodBeat.m2505o(65319);
            return true;
        } else {
            AppMethodBeat.m2505o(65319);
            return false;
        }
    }

    /* renamed from: b */
    public void mo57643b(File file) {
        AppMethodBeat.m2504i(65318);
        this.f15205b = new C36448b(file);
        AppMethodBeat.m2505o(65318);
    }
}
