package com.tencent.mm.sdk.platformtools;

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

public final class bd {
    static String[] xBo = new String[]{"sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs"};
    static String[] xBp = new String[]{"vfat", "exfat", "fuse", "sdcardfs"};
    static String[] xBq = new String[]{"/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/"};
    static String[] xBr = new String[]{"/dev/block/vold"};

    public static class a {
        public boolean cbI;
        public String xBs;
        public String xBt;
        public String xBu;
        public long xBv;
        public long xBw;
        public long xBx;
        public long xBy;
        a xBz;

        public final String toString() {
            AppMethodBeat.i(52251);
            String str = "{DevName=" + this.xBs + ", MountDir=" + this.xBt + ", FileSystem=" + this.xBu + ", TotalBlocks=" + this.xBv + ", FreeBlocks=" + this.xBw + ", AvailableBlocks=" + this.xBx + ", BlockSize=" + this.xBy + ", Shared=" + (this.xBz != null) + "}";
            AppMethodBeat.o(52251);
            return str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(52252);
            a aVar = (a) obj;
            if (this.xBy != aVar.xBy) {
                AppMethodBeat.o(52252);
                return false;
            }
            long j = this.xBv - aVar.xBv;
            long j2 = this.xBw - aVar.xBw;
            long j3 = this.xBx - aVar.xBx;
            if (Math.abs(j - j2) > 4 || Math.abs(j - j3) > 4 || Math.abs(j2 - j3) > 4) {
                AppMethodBeat.o(52252);
                return false;
            }
            AppMethodBeat.o(52252);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051 A:{SYNTHETIC, Splitter:B:16:0x0051} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0073 A:{SYNTHETIC, Splitter:B:25:0x0073} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static ArrayList<a> dpl() {
        Exception e;
        Throwable th;
        AppMethodBeat.i(52253);
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
                            ab.e("MicroMsg.SdcardUtil", "splite failed for line: ".concat(String.valueOf(readLine)));
                        } else {
                            a aVar = new a();
                            aVar.xBs = split[0];
                            aVar.xBt = split[1];
                            aVar.xBu = split[2];
                            arrayList.add(aVar);
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            ab.printErrStackTrace("MicroMsg.SdcardUtil", e2, "", new Object[0]);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        ab.e("MicroMsg.SdcardUtil", "parseProcMounts", e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e22) {
                                ab.printErrStackTrace("MicroMsg.SdcardUtil", e22, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(52253);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                ab.printErrStackTrace("MicroMsg.SdcardUtil", e4, "", new Object[0]);
                            }
                        }
                        AppMethodBeat.o(52253);
                        throw th;
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            ab.e("MicroMsg.SdcardUtil", "parseProcMounts", e);
            if (bufferedReader != null) {
            }
            AppMethodBeat.o(52253);
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
            }
            AppMethodBeat.o(52253);
            throw th;
        }
        AppMethodBeat.o(52253);
        return arrayList;
    }

    private static void a(a aVar) {
        AppMethodBeat.i(52254);
        try {
            StatFs statFs = new StatFs(aVar.xBt);
            aVar.xBy = (long) statFs.getBlockSize();
            aVar.xBx = (long) statFs.getAvailableBlocks();
            aVar.xBv = (long) statFs.getBlockCount();
            aVar.xBw = (long) statFs.getFreeBlocks();
            AppMethodBeat.o(52254);
        } catch (IllegalArgumentException e) {
            ab.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", e);
            AppMethodBeat.o(52254);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086 A:{SYNTHETIC, Splitter:B:24:0x0086} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(a aVar) {
        boolean delete;
        IOException e;
        Throwable th;
        AppMethodBeat.i(52255);
        File file = new File(aVar.xBt, "test_writable");
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
                    ab.printErrStackTrace("MicroMsg.SdcardUtil", e2, "", new Object[0]);
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException e4) {
            e = e4;
            fileOutputStream = null;
            try {
                ab.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.xBt);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        delete = false;
                    } catch (IOException e5) {
                        ab.printErrStackTrace("MicroMsg.SdcardUtil", e5, "", new Object[0]);
                        delete = false;
                    }
                } else {
                    delete = false;
                }
                aVar.cbI = delete;
                AppMethodBeat.o(52255);
                return delete;
            } catch (Throwable th2) {
                th = th2;
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(52255);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e22) {
                    ab.printErrStackTrace("MicroMsg.SdcardUtil", e22, "", new Object[0]);
                }
            }
            AppMethodBeat.o(52255);
            throw th;
        }
        aVar.cbI = delete;
        AppMethodBeat.o(52255);
        return delete;
    }

    private static a dpm() {
        a aVar;
        AppMethodBeat.i(52256);
        ArrayList dpl = dpl();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Iterator it = dpl.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.xBt.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.xBt = absolutePath;
            aVar.xBs = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            aVar.xBu = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        a(aVar);
        AppMethodBeat.o(52256);
        return aVar;
    }

    private static a dpn() {
        a aVar;
        AppMethodBeat.i(52257);
        ArrayList dpl = dpl();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = dpl.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.xBt.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.xBt = absolutePath;
            aVar.xBs = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
            aVar.xBu = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
        }
        a(aVar);
        AppMethodBeat.o(52257);
        return aVar;
    }

    public static ArrayList<a> dpo() {
        a aVar;
        int i;
        int size;
        a aVar2;
        AppMethodBeat.i(52258);
        ArrayList dpl = dpl();
        int size2 = dpl.size();
        List asList = Arrays.asList(xBp);
        List<String> asList2 = Arrays.asList(xBq);
        List<String> asList3 = Arrays.asList(xBr);
        for (int i2 = size2 - 1; i2 >= 0; i2--) {
            aVar = (a) dpl.get(i2);
            if (asList.contains(aVar.xBu)) {
                i = 0;
                for (String startsWith : asList2) {
                    i = aVar.xBt.startsWith(startsWith) | i;
                }
                if (i != 0) {
                    dpl.remove(i2);
                    ab.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + aVar.xBt);
                } else if (aVar.xBu.equals("fuse") || aVar.xBu.equals("sdcardfs")) {
                    if (aVar.xBs.startsWith("/data/")) {
                        dpl.remove(i2);
                        ab.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + aVar.xBs);
                    }
                } else if (!(aVar.xBu.equals("fuse") || aVar.xBu.equals("sdcardfs"))) {
                    i = 0;
                    for (String startsWith2 : asList3) {
                        i = aVar.xBs.startsWith(startsWith2) | i;
                    }
                    if (i == 0) {
                        dpl.remove(i2);
                        ab.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + aVar.xBs);
                    }
                }
            } else {
                dpl.remove(i2);
                ab.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + aVar.xBu);
            }
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        for (size = dpl.size() - 1; size >= 0; size--) {
            aVar = (a) dpl.get(size);
            if (aVar.xBt.equals(path)) {
                dpl.remove(size);
                dpl.add(0, aVar);
                size2 = 1;
                break;
            }
        }
        size2 = 0;
        if (size2 == 0) {
            aVar = new a();
            aVar.xBt = path;
            aVar.xBu = "unknown";
            aVar.xBs = "unknown";
            dpl.add(0, aVar);
        }
        for (size = dpl.size() - 1; size >= 0; size--) {
            aVar = (a) dpl.get(size);
            File file = new File(aVar.xBt);
            if (!file.exists() || !file.isDirectory()) {
                ab.d("MicroMsg.SdcardUtil", "Directory verify failed: ".concat(String.valueOf(aVar)));
                dpl.remove(size);
            }
        }
        for (size = dpl.size() - 1; size >= 0; size--) {
            aVar = (a) dpl.get(size);
            if (!b(aVar)) {
                ab.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: ".concat(String.valueOf(aVar)));
                dpl.remove(size);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!dpl.isEmpty()) {
            i = dpl.size() - 1;
            aVar2 = (a) dpl.remove(0);
            while (i >= 0) {
                aVar = (a) dpl.get(i);
                if (aVar2.xBs.equals(aVar.xBs)) {
                    dpl.remove(i);
                    ab.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + aVar2.xBs);
                    if (!aVar2.cbI && aVar.cbI) {
                        ab.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
                        i--;
                        aVar2 = aVar;
                    }
                }
                aVar = aVar2;
                i--;
                aVar2 = aVar;
            }
            arrayList.add(aVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((a) it.next());
        }
        dpl.clear();
        while (!arrayList.isEmpty()) {
            aVar2 = (a) arrayList.remove(0);
            dpl.add(aVar2);
            for (i = arrayList.size() - 1; i >= 0; i--) {
                aVar = (a) arrayList.get(i);
                if (aVar2.equals(aVar)) {
                    ab.d("MicroMsg.SdcardUtil", "Duplicate:" + aVar2.toString() + "---" + aVar.toString());
                    arrayList.remove(i);
                }
            }
        }
        AppMethodBeat.o(52258);
        return dpl;
    }

    public static long dpp() {
        AppMethodBeat.i(52259);
        a dpm = dpm();
        long j = dpm.xBy * dpm.xBx;
        AppMethodBeat.o(52259);
        return j;
    }

    public static long dpq() {
        AppMethodBeat.i(52260);
        a dpn = dpn();
        long j = dpn.xBy * dpn.xBx;
        AppMethodBeat.o(52260);
        return j;
    }

    public static boolean dpr() {
        a aVar;
        boolean z;
        AppMethodBeat.i(52261);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList dpl = dpl();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        a aVar2 = null;
        Iterator it = dpl.iterator();
        a aVar3 = null;
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar3 == null && aVar.xBt.equals(absolutePath)) {
                if (aVar2 != null) {
                    aVar3 = aVar;
                    break;
                }
                aVar3 = aVar;
            } else {
                if (aVar2 == null && aVar.xBt.equals(absolutePath2)) {
                    if (aVar3 != null) {
                        aVar2 = aVar;
                        break;
                    }
                }
                aVar = aVar2;
                aVar2 = aVar;
            }
        }
        if (aVar3 != null && aVar2 == null && !bo.isNullOrNil(absolutePath2) && absolutePath2.contains("emulated")) {
            String substring = absolutePath2.substring(absolutePath2.lastIndexOf(47) + 1);
            ab.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", substring, Integer.valueOf(bo.getInt(substring, -1)));
            if (bo.getInt(substring, -1) != -1) {
                absolutePath = absolutePath2.substring(0, (absolutePath2.length() - substring.length()) - 1);
                if (!bo.isNullOrNil(absolutePath)) {
                    Iterator it2 = dpl.iterator();
                    while (it2.hasNext()) {
                        aVar = (a) it2.next();
                        if (aVar.xBt.equals(absolutePath)) {
                            break;
                        }
                    }
                }
            }
        }
        aVar = aVar2;
        if (!(aVar3 == null || aVar == null)) {
            a(aVar3);
            a(aVar);
            ab.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", aVar3, aVar);
            if ((aVar.xBu.equals("fuse") || aVar.xBu.equals("sdcardfs") || aVar.xBu.equals("esdfs")) && aVar3.xBv >= aVar.xBv && aVar.xBv > 0 && aVar3.xBy >= aVar.xBy && aVar.xBy > 0 && aVar3.xBx >= aVar.xBx) {
                z = true;
                ab.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(52261);
                return z;
            }
        }
        z = false;
        ab.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(52261);
        return z;
    }

    public static String amQ(String str) {
        AppMethodBeat.i(52262);
        String str2 = "";
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(52262);
        } else {
            a aVar;
            ArrayList dpl = dpl();
            Iterator it = dpl.iterator();
            while (it.hasNext()) {
                aVar = (a) it.next();
                if (str.equals(aVar.xBt)) {
                    str2 = aVar.xBu;
                    break;
                }
            }
            ab.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", str, str2);
            if (bo.isNullOrNil(str2) && str.contains("emulated")) {
                String substring = str.substring(str.lastIndexOf(47) + 1);
                ab.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", substring, Integer.valueOf(bo.getInt(substring, -1)));
                if (bo.getInt(substring, -1) != -1) {
                    String substring2 = str.substring(0, (str.length() - substring.length()) - 1);
                    if (!bo.isNullOrNil(substring2)) {
                        Iterator it2 = dpl.iterator();
                        while (it2.hasNext()) {
                            aVar = (a) it2.next();
                            if (substring2.equals(aVar.xBt)) {
                                str2 = aVar.xBu;
                                ab.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", str, substring2, str2);
                                break;
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(52262);
        }
        return str2;
    }
}
