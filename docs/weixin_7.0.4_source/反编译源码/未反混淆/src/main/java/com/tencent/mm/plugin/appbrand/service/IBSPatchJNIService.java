package com.tencent.mm.plugin.appbrand.service;

import com.tencent.mm.kernel.c.a;

public interface IBSPatchJNIService extends a {

    public interface ConstantsIncrementalMergeResult {
        public static final int FAIL_ALLOC = -3;
        public static final int FAIL_DECOMPRESS = -4;
        public static final int FAIL_OVERFLOW = -5;
        public static final int FAIL_READ_DIFF_FILE = -7;
        public static final int FAIL_READ_OLD_FILE = -6;
        public static final int FATAL = 1;
        public static final int OK = 0;
    }

    int bspatch(String str, String str2, String str3);
}
