package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;

/* renamed from: com.tencent.smtt.sdk.bd */
class C40975bd {
    /* renamed from: a */
    private DexLoader f16292a = null;
    /* renamed from: b */
    private Object f16293b = null;

    public C40975bd(DexLoader dexLoader) {
        this.f16292a = dexLoader;
    }

    /* renamed from: a */
    public Object mo64909a(Context context, Object obj, Bundle bundle) {
        AppMethodBeat.m2504i(64614);
        if (this.f16292a != null) {
            this.f16293b = this.f16292a.newInstance("com.tencent.tbs.cache.TbsVideoCacheTaskProxy", new Class[]{Context.class, Object.class, Bundle.class}, context, obj, bundle);
        }
        Object obj2 = this.f16293b;
        AppMethodBeat.m2505o(64614);
        return obj2;
    }

    /* renamed from: a */
    public void mo64910a() {
        AppMethodBeat.m2504i(64615);
        if (this.f16292a != null) {
            this.f16292a.invokeMethod(this.f16293b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "pauseTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.m2505o(64615);
    }

    /* renamed from: a */
    public void mo64911a(boolean z) {
        AppMethodBeat.m2504i(64618);
        if (this.f16292a != null) {
            this.f16292a.invokeMethod(this.f16293b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "removeTask", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(64618);
    }

    /* renamed from: b */
    public void mo64912b() {
        AppMethodBeat.m2504i(64616);
        if (this.f16292a != null) {
            this.f16292a.invokeMethod(this.f16293b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "resumeTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.m2505o(64616);
    }

    /* renamed from: c */
    public void mo64913c() {
        AppMethodBeat.m2504i(64617);
        if (this.f16292a != null) {
            this.f16292a.invokeMethod(this.f16293b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "stopTask", new Class[0], new Object[0]);
        }
        AppMethodBeat.m2505o(64617);
    }

    /* renamed from: d */
    public long mo64914d() {
        AppMethodBeat.m2504i(64619);
        if (this.f16292a != null) {
            Object invokeMethod = this.f16292a.invokeMethod(this.f16293b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getContentLength", new Class[0], new Object[0]);
            if (invokeMethod instanceof Long) {
                long longValue = ((Long) invokeMethod).longValue();
                AppMethodBeat.m2505o(64619);
                return longValue;
            }
        }
        AppMethodBeat.m2505o(64619);
        return 0;
    }

    /* renamed from: e */
    public int mo64915e() {
        AppMethodBeat.m2504i(64620);
        if (this.f16292a != null) {
            Object invokeMethod = this.f16292a.invokeMethod(this.f16293b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getDownloadedSize", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                int intValue = ((Integer) invokeMethod).intValue();
                AppMethodBeat.m2505o(64620);
                return intValue;
            }
        }
        AppMethodBeat.m2505o(64620);
        return 0;
    }

    /* renamed from: f */
    public int mo64916f() {
        AppMethodBeat.m2504i(64621);
        if (this.f16292a != null) {
            Object invokeMethod = this.f16292a.invokeMethod(this.f16293b, "com.tencent.tbs.cache.TbsVideoCacheTaskProxy", "getProgress", new Class[0], new Object[0]);
            if (invokeMethod instanceof Integer) {
                int intValue = ((Integer) invokeMethod).intValue();
                AppMethodBeat.m2505o(64621);
                return intValue;
            }
        }
        AppMethodBeat.m2505o(64621);
        return 0;
    }
}
