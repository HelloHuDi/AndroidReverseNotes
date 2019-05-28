package com.tencent.p177mm.plugin.appbrand.service;

import com.tencent.p177mm.kernel.p242c.C1694a;

/* renamed from: com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService */
public interface IBSPatchJNIService extends C1694a {

    /* renamed from: com.tencent.mm.plugin.appbrand.service.IBSPatchJNIService$ConstantsIncrementalMergeResult */
    public interface ConstantsIncrementalMergeResult {
        public static final int FAIL_ALLOC = -3;
        public static final int FAIL_DECOMPRESS = -4;
        public static final int FAIL_OVERFLOW = -5;
        public static final int FAIL_READ_DIFF_FILE = -7;
        public static final int FAIL_READ_OLD_FILE = -6;
        public static final int FATAL = 1;
        /* renamed from: OK */
        public static final int f17186OK = 0;
    }

    int bspatch(String str, String str2, String str3);
}
