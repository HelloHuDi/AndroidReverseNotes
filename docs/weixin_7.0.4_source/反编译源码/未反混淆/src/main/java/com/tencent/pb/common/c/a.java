package com.tencent.pb.common.c;

import android.content.Context;
import java.io.File;

public final class a {
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0173 A:{SYNTHETIC, Splitter:B:32:0x0173} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x013c A:{SYNTHETIC, Splitter:B:28:0x013c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0173 A:{SYNTHETIC, Splitter:B:32:0x0173} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean p(String str, Context context) {
        String file;
        int lastIndexOf;
        try {
            file = context.getCacheDir().toString();
            if (file.endsWith("/")) {
                file = file.substring(0, file.length() - 2);
            }
            lastIndexOf = file.lastIndexOf(47);
            if (lastIndexOf != -1) {
                file = file.substring(0, lastIndexOf) + "/lib/";
            } else {
                file = "";
            }
        } catch (Exception e) {
            file = "/data/data/" + context.getPackageName() + "/lib/";
        }
        if (file.length() != 0) {
            String str2;
            int i;
            if (new File(file + str).exists()) {
                try {
                    c.d("loadLibrary", "try to load library: " + file + str);
                    System.load(file + str);
                    lastIndexOf = 1;
                } catch (UnsatisfiedLinkError e2) {
                    f.C(146, 3, "case1:" + file + str);
                    c.w("loadLibrary", "cannot load library " + file + str);
                }
                if (lastIndexOf == 0 || str.endsWith(".so")) {
                    str2 = str;
                } else {
                    str2 = str + ".so";
                    if (new File(file + str2).exists()) {
                        try {
                            c.d("loadLibrary", "try to load library: " + file + str2);
                            System.load(file + str2);
                            lastIndexOf = 1;
                        } catch (UnsatisfiedLinkError e3) {
                            c.w("loadLibrary", "cannot load library " + file + str2);
                            f.C(146, 3, "case2:" + file + str2);
                        }
                    }
                }
                if (lastIndexOf == 0 && !str2.startsWith("lib")) {
                    str2 = "lib".concat(String.valueOf(str2));
                    if (new File(file + str2).exists()) {
                        try {
                            c.d("loadLibrary", "try to load library: " + file + str2);
                            System.load(file + str2);
                            i = 1;
                        } catch (UnsatisfiedLinkError e4) {
                            c.w("loadLibrary", "cannot load library " + file + str2);
                            f.C(146, 3, "case3:" + file + str2);
                        }
                        if (i == 0) {
                            try {
                                c.d("loadLibrary", "try to load library: " + str + " with default path");
                                System.loadLibrary(str);
                            } catch (UnsatisfiedLinkError e5) {
                                c.w("loadLibrary", "cannot load library ".concat(String.valueOf(str)));
                                f.C(146, 3, "case4:".concat(String.valueOf(str)));
                                return false;
                            }
                        }
                    }
                }
                i = lastIndexOf;
                if (i == 0) {
                }
            }
            lastIndexOf = 0;
            if (lastIndexOf == 0) {
            }
            str2 = str;
            str2 = "lib".concat(String.valueOf(str2));
            if (new File(file + str2).exists()) {
            }
            i = lastIndexOf;
            if (i == 0) {
            }
        } else {
            try {
                c.d("loadLibrary", "try to load library: " + str + " with default path");
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e6) {
                c.w("loadLibrary", "cannot load library ".concat(String.valueOf(str)));
                f.C(146, 3, "case5:".concat(String.valueOf(str)));
                return false;
            }
        }
        return true;
    }
}
