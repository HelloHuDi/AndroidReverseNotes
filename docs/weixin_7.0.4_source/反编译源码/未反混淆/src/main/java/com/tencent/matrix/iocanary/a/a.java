package com.tencent.matrix.iocanary.a;

public final class a {
    public final com.tencent.mrs.b.a bUG;

    public static final class a {
        public com.tencent.mrs.b.a bUG;
    }

    public /* synthetic */ a(com.tencent.mrs.b.a aVar, byte b) {
        this(aVar);
    }

    private a(com.tencent.mrs.b.a aVar) {
        this.bUG = aVar;
    }

    public final boolean zb() {
        return this.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_io_file_io_main_thread_enable.name(), true);
    }

    public final boolean zc() {
        return this.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_io_repeated_read_enable.name(), true);
    }

    public final boolean zd() {
        return this.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_io_small_buffer_enable.name(), true);
    }

    public final boolean ze() {
        return this.bUG.get(com.tencent.mrs.b.a.a.clicfg_matrix_io_closeable_leak_enable.name(), true);
    }

    public final String toString() {
        return String.format("[IOCanary.IOConfig], main_thread:%b, small_buffer:%b, repeat_read:%b, closeable_leak:%b", new Object[]{Boolean.valueOf(zb()), Boolean.valueOf(zd()), Boolean.valueOf(zc()), Boolean.valueOf(ze())});
    }
}
