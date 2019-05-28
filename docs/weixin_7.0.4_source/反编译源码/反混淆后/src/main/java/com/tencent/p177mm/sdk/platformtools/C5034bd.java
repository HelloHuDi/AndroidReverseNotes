package com.tencent.p177mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.sdk.platformtools.bd */
public final class C5034bd {
    static String[] xBo = new String[]{"sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs"};
    static String[] xBp = new String[]{"vfat", "exfat", "fuse", "sdcardfs"};
    static String[] xBq = new String[]{"/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/"};
    static String[] xBr = new String[]{"/dev/block/vold"};

    /* renamed from: com.tencent.mm.sdk.platformtools.bd$a */
    public static class C5033a {
        public boolean cbI;
        public String xBs;
        public String xBt;
        public String xBu;
        public long xBv;
        public long xBw;
        public long xBx;
        public long xBy;
        C5033a xBz;

        public final String toString() {
            AppMethodBeat.m2504i(52251);
            String str = "{DevName=" + this.xBs + ", MountDir=" + this.xBt + ", FileSystem=" + this.xBu + ", TotalBlocks=" + this.xBv + ", FreeBlocks=" + this.xBw + ", AvailableBlocks=" + this.xBx + ", BlockSize=" + this.xBy + ", Shared=" + (this.xBz != null) + "}";
            AppMethodBeat.m2505o(52251);
            return str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(52252);
            C5033a c5033a = (C5033a) obj;
            if (this.xBy != c5033a.xBy) {
                AppMethodBeat.m2505o(52252);
                return false;
            }
            long j = this.xBv - c5033a.xBv;
            long j2 = this.xBw - c5033a.xBw;
            long j3 = this.xBx - c5033a.xBx;
            if (Math.abs(j - j2) > 4 || Math.abs(j - j3) > 4 || Math.abs(j2 - j3) > 4) {
                AppMethodBeat.m2505o(52252);
                return false;
            }
            AppMethodBeat.m2505o(52252);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A:{SYNTHETIC, Splitter:B:16:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073 A:{SYNTHETIC, Splitter:B:25:0x0073} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static ArrayList<C5033a> dpl() {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(52253);
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split == null || split.length < 3) {
                            C4990ab.m7412e("MicroMsg.SdcardUtil", "splite failed for line: ".concat(String.valueOf(readLine)));
                        } else {
                            C5033a c5033a = new C5033a();
                            c5033a.xBs = split[0];
                            c5033a.xBt = split[1];
                            c5033a.xBu = split[2];
                            arrayList.add(c5033a);
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.SdcardUtil", e2, "", new Object[0]);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        C4990ab.m7413e("MicroMsg.SdcardUtil", "parseProcMounts", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e22) {
                                C4990ab.printErrStackTrace("MicroMsg.SdcardUtil", e22, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.m2505o(52253);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                C4990ab.printErrStackTrace("MicroMsg.SdcardUtil", e4, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.m2505o(52253);
                        throw th;
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            C4990ab.m7413e("MicroMsg.SdcardUtil", "parseProcMounts", e);
            if (bufferedReader != null) {
            }
            AppMethodBeat.m2505o(52253);
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.m2505o(52253);
            throw th;
        }
        AppMethodBeat.m2505o(52253);
        return arrayList;
    }

    /* renamed from: a */
    private static void m7490a(C5033a c5033a) {
        AppMethodBeat.m2504i(52254);
        try {
            StatFs statFs = new StatFs(c5033a.xBt);
            c5033a.xBy = (long) statFs.getBlockSize();
            c5033a.xBx = (long) statFs.getAvailableBlocks();
            c5033a.xBv = (long) statFs.getBlockCount();
            c5033a.xBw = (long) statFs.getFreeBlocks();
            AppMethodBeat.m2505o(52254);
        } catch (IllegalArgumentException e) {
            C4990ab.m7413e("MicroMsg.SdcardUtil", "statFsForStatMountParse", e);
            AppMethodBeat.m2505o(52254);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086 A:{SYNTHETIC, Splitter:B:24:0x0086} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static boolean m7491b(C5033a c5033a) {
        boolean delete;
        IOException e;
        Throwable th;
        AppMethodBeat.m2504i(52255);
        File file = new File(c5033a.xBt, "test_writable");
        FileOutputStream fileOutputStream;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                delete = file.delete();
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.SdcardUtil", e2, "", new Object[0]);
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
            try {
                C4990ab.m7412e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + c5033a.xBt);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        delete = false;
                    } catch (IOException e5) {
                        C4990ab.printErrStackTrace("MicroMsg.SdcardUtil", e5, "", new Object[0]);
                        delete = false;
                    }
                } else {
                    delete = false;
                }
                c5033a.cbI = delete;
                AppMethodBeat.m2505o(52255);
                return delete;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(52255);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.SdcardUtil", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(52255);
            throw th;
        }
        c5033a.cbI = delete;
        AppMethodBeat.m2505o(52255);
        return delete;
    }

    private static C5033a dpm() {
        C5033a c5033a;
        AppMethodBeat.m2504i(52256);
        ArrayList dpl = C5034bd.dpl();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Iterator it = dpl.iterator();
        while (it.hasNext()) {
            c5033a = (C5033a) it.next();
            if (c5033a.xBt.equals(absolutePath)) {
                break;
            }
        }
        c5033a = null;
        if (c5033a == null) {
            c5033a = new C5033a();
            c5033a.xBt = absolutePath;
            c5033a.xBs = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            c5033a.xBu = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        C5034bd.m7490a(c5033a);
        AppMethodBeat.m2505o(52256);
        return c5033a;
    }

    private static C5033a dpn() {
        C5033a c5033a;
        AppMethodBeat.m2504i(52257);
        ArrayList dpl = C5034bd.dpl();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = dpl.iterator();
        while (it.hasNext()) {
            c5033a = (C5033a) it.next();
            if (c5033a.xBt.equals(absolutePath)) {
                break;
            }
        }
        c5033a = null;
        if (c5033a == null) {
            c5033a = new C5033a();
            c5033a.xBt = absolutePath;
            c5033a.xBs = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            c5033a.xBu = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        C5034bd.m7490a(c5033a);
        AppMethodBeat.m2505o(52257);
        return c5033a;
    }

    public static ArrayList<C5033a> dpo() {
        C5033a c5033a;
        int i;
        int size;
        C5033a c5033a2;
        AppMethodBeat.m2504i(52258);
        ArrayList dpl = C5034bd.dpl();
        int size2 = dpl.size();
        List asList = Arrays.asList(xBp);
        List<String> asList2 = Arrays.asList(xBq);
        List<String> asList3 = Arrays.asList(xBr);
        for (int i2 = size2 - 1; i2 >= 0; i2--) {
            c5033a = (C5033a) dpl.get(i2);
            if (asList.contains(c5033a.xBu)) {
                i = 0;
                for (String startsWith : asList2) {
                    i = c5033a.xBt.startsWith(startsWith) | i;
                }
                if (i != 0) {
                    dpl.remove(i2);
                    C4990ab.m7410d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + c5033a.xBt);
                } else if (c5033a.xBu.equals("fuse") || c5033a.xBu.equals("sdcardfs")) {
                    if (c5033a.xBs.startsWith("/data/")) {
                        dpl.remove(i2);
                        C4990ab.m7410d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + c5033a.xBs);
                    }
                } else if (!(c5033a.xBu.equals("fuse") || c5033a.xBu.equals("sdcardfs"))) {
                    i = 0;
                    for (String startsWith2 : asList3) {
                        i = c5033a.xBs.startsWith(startsWith2) | i;
                    }
                    if (i == 0) {
                        dpl.remove(i2);
                        C4990ab.m7410d("MicroMsg.SdcardUtil", "Remove with bad device name: " + c5033a.xBs);
                    }
                }
            } else {
                dpl.remove(i2);
                C4990ab.m7410d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + c5033a.xBu);
            }
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        for (size = dpl.size() - 1; size >= 0; size--) {
            c5033a = (C5033a) dpl.get(size);
            if (c5033a.xBt.equals(path)) {
                dpl.remove(size);
                dpl.add(0, c5033a);
                size2 = 1;
                break;
            }
        }
        size2 = 0;
        if (size2 == 0) {
            c5033a = new C5033a();
            c5033a.xBt = path;
            c5033a.xBu = "unknown";
            c5033a.xBs = "unknown";
            dpl.add(0, c5033a);
        }
        for (size = dpl.size() - 1; size >= 0; size--) {
            c5033a = (C5033a) dpl.get(size);
            File file = new File(c5033a.xBt);
            if (!file.exists() || !file.isDirectory()) {
                C4990ab.m7410d("MicroMsg.SdcardUtil", "Directory verify failed: ".concat(String.valueOf(c5033a)));
                dpl.remove(size);
            }
        }
        for (size = dpl.size() - 1; size >= 0; size--) {
            c5033a = (C5033a) dpl.get(size);
            if (!C5034bd.m7491b(c5033a)) {
                C4990ab.m7410d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: ".concat(String.valueOf(c5033a)));
                dpl.remove(size);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!dpl.isEmpty()) {
            i = dpl.size() - 1;
            c5033a2 = (C5033a) dpl.remove(0);
            while (i >= 0) {
                c5033a = (C5033a) dpl.get(i);
                if (c5033a2.xBs.equals(c5033a.xBs)) {
                    dpl.remove(i);
                    C4990ab.m7410d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + c5033a2.xBs);
                    if (!c5033a2.cbI && c5033a.cbI) {
                        C4990ab.m7410d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
                        i--;
                        c5033a2 = c5033a;
                    }
                }
                c5033a = c5033a2;
                i--;
                c5033a2 = c5033a;
            }
            arrayList.add(c5033a2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C5034bd.m7490a((C5033a) it.next());
        }
        dpl.clear();
        while (!arrayList.isEmpty()) {
            c5033a2 = (C5033a) arrayList.remove(0);
            dpl.add(c5033a2);
            for (i = arrayList.size() - 1; i >= 0; i--) {
                c5033a = (C5033a) arrayList.get(i);
                if (c5033a2.equals(c5033a)) {
                    C4990ab.m7410d("MicroMsg.SdcardUtil", "Duplicate:" + c5033a2.toString() + "---" + c5033a.toString());
                    arrayList.remove(i);
                }
            }
        }
        AppMethodBeat.m2505o(52258);
        return dpl;
    }

    public static long dpp() {
        AppMethodBeat.m2504i(52259);
        C5033a dpm = C5034bd.dpm();
        long j = dpm.xBy * dpm.xBx;
        AppMethodBeat.m2505o(52259);
        return j;
    }

    public static long dpq() {
        AppMethodBeat.m2504i(52260);
        C5033a dpn = C5034bd.dpn();
        long j = dpn.xBy * dpn.xBx;
        AppMethodBeat.m2505o(52260);
        return j;
    }

    public static boolean dpr() {
        C5033a c5033a;
        boolean z;
        AppMethodBeat.m2504i(52261);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList dpl = C5034bd.dpl();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        C5033a c5033a2 = null;
        Iterator it = dpl.iterator();
        C5033a c5033a3 = null;
        while (it.hasNext()) {
            c5033a = (C5033a) it.next();
            if (c5033a3 == null && c5033a.xBt.equals(absolutePath)) {
                if (c5033a2 != null) {
                    c5033a3 = c5033a;
                    break;
                }
                c5033a3 = c5033a;
            } else {
                if (c5033a2 == null && c5033a.xBt.equals(absolutePath2)) {
                    if (c5033a3 != null) {
                        c5033a2 = c5033a;
                        break;
                    }
                }
                c5033a = c5033a2;
                c5033a2 = c5033a;
            }
        }
        if (c5033a3 != null && c5033a2 == null && !C5046bo.isNullOrNil(absolutePath2) && absolutePath2.contains("emulated")) {
            String substring = absolutePath2.substring(absolutePath2.lastIndexOf(47) + 1);
            C4990ab.m7417i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", substring, Integer.valueOf(C5046bo.getInt(substring, -1)));
            if (C5046bo.getInt(substring, -1) != -1) {
                absolutePath = absolutePath2.substring(0, (absolutePath2.length() - substring.length()) - 1);
                if (!C5046bo.isNullOrNil(absolutePath)) {
                    Iterator it2 = dpl.iterator();
                    while (it2.hasNext()) {
                        c5033a = (C5033a) it2.next();
                        if (c5033a.xBt.equals(absolutePath)) {
                            break;
                        }
                    }
                }
            }
        }
        c5033a = c5033a2;
        if (!(c5033a3 == null || c5033a == null)) {
            C5034bd.m7490a(c5033a3);
            C5034bd.m7490a(c5033a);
            C4990ab.m7411d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", c5033a3, c5033a);
            if ((c5033a.xBu.equals("fuse") || c5033a.xBu.equals("sdcardfs") || c5033a.xBu.equals("esdfs")) && c5033a3.xBv >= c5033a.xBv && c5033a.xBv > 0 && c5033a3.xBy >= c5033a.xBy && c5033a.xBy > 0 && c5033a3.xBx >= c5033a.xBx) {
                z = true;
                C4990ab.m7417i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(52261);
                return z;
            }
        }
        z = false;
        C4990ab.m7417i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(52261);
        return z;
    }

    public static String amQ(String str) {
        AppMethodBeat.m2504i(52262);
        String str2 = "";
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52262);
        } else {
            C5033a c5033a;
            ArrayList dpl = C5034bd.dpl();
            Iterator it = dpl.iterator();
            while (it.hasNext()) {
                c5033a = (C5033a) it.next();
                if (str.equals(c5033a.xBt)) {
                    str2 = c5033a.xBu;
                    break;
                }
            }
            C4990ab.m7417i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", str, str2);
            if (C5046bo.isNullOrNil(str2) && str.contains("emulated")) {
                String substring = str.substring(str.lastIndexOf(47) + 1);
                C4990ab.m7417i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", substring, Integer.valueOf(C5046bo.getInt(substring, -1)));
                if (C5046bo.getInt(substring, -1) != -1) {
                    String substring2 = str.substring(0, (str.length() - substring.length()) - 1);
                    if (!C5046bo.isNullOrNil(substring2)) {
                        Iterator it2 = dpl.iterator();
                        while (it2.hasNext()) {
                            c5033a = (C5033a) it2.next();
                            if (substring2.equals(c5033a.xBt)) {
                                str2 = c5033a.xBu;
                                C4990ab.m7417i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", str, substring2, str2);
                                break;
                            }
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(52262);
        }
        return str2;
    }
}
