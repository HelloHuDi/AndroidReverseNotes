package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

class bd {
    private DexLoader a = null;
    private Object b = null;

    public bd(DexLoader dexLoader) {
        this.a = dexLoader;
    }

    public Object a(Context context, Object obj, Bundle bundle) {
        AppMethodBeat.i(64614);
        if (this.a != null) {
            this.b = this.a.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[]{Context.class, Object.class, Bundle.class}, context, obj, bundle);
        }
        Object obj2 = this.b;
        AppMethodBeat.o(64614);
        return obj2;
    }

    public void a() {
        AppMethodBeat.i(64615);
        if (this.a != null) {
            this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.o(64615);
    }

    public void a(boolean z) {
        AppMethodBeat.i(64618);
        if (this.a != null) {
            this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
        AppMethodBeat.o(64618);
    }

    public void b() {
        AppMethodBeat.i(64616);
        if (this.a != null) {
            this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.o(64616);
    }

    public void c() {
        AppMethodBeat.i(64617);
        if (this.a != null) {
            this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.o(64617);
    }

    public long d() {
        AppMethodBeat.i(64619);
        if (this.a != null) {
            Object invokeMethod = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
            if (invokeMethod instanceof Long) {
                long longValue = ((Long) invokeMethod).longValue();
                AppMethodBeat.o(64619);
                return longValue;
            }
        }
        AppMethodBeat.o(64619);
        return 0;
    }

    public int e() {
        AppMethodBeat.i(64620);
        if (this.a != null) {
            Object invokeMethod = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                int intValue = ((Integer) invokeMethod).intValue();
                AppMethodBeat.o(64620);
                return intValue;
            }
        }
        AppMethodBeat.o(64620);
        return 0;
    }

    public int f() {
        AppMethodBeat.i(64621);
        if (this.a != null) {
            Object invokeMethod = this.a.invokeMethod(this.b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                int intValue = ((Integer) invokeMethod).intValue();
                AppMethodBeat.o(64621);
                return intValue;
            }
        }
        AppMethodBeat.o(64621);
        return 0;
    }
}
