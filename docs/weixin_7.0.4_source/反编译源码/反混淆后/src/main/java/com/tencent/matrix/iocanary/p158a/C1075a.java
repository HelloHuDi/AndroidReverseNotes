package com.tencent.matrix.iocanary.p158a;

import com.tencent.mrs.p656b.C5774a;
import com.tencent.mrs.p656b.C5774a.C5773a;

/* renamed from: com.tencent.matrix.iocanary.a.a */
public final class C1075a {
    public final C5774a bUG;

    /* renamed from: com.tencent.matrix.iocanary.a.a$a */
    public static final class C1074a {
        public C5774a bUG;
    }

    public /* synthetic */ C1075a(C5774a c5774a, byte b) {
        this(c5774a);
    }

    private C1075a(C5774a c5774a) {
        this.bUG = c5774a;
    }

    /* renamed from: zb */
    public final boolean mo4212zb() {
        return this.bUG.get(C5773a.clicfg_matrix_io_file_io_main_thread_enable.name(), true);
    }

    /* renamed from: zc */
    public final boolean mo4213zc() {
        return this.bUG.get(C5773a.clicfg_matrix_io_repeated_read_enable.name(), true);
    }

    /* renamed from: zd */
    public final boolean mo4214zd() {
        return this.bUG.get(C5773a.clicfg_matrix_io_small_buffer_enable.name(), true);
    }

    /* renamed from: ze */
    public final boolean mo4215ze() {
        return this.bUG.get(C5773a.clicfg_matrix_io_closeable_leak_enable.name(), true);
    }

    public final String toString() {
        return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[]{Boolean.valueOf(mo4212zb()), Boolean.valueOf(mo4214zd()), Boolean.valueOf(mo4213zc()), Boolean.valueOf(mo4215ze())});
    }
}
