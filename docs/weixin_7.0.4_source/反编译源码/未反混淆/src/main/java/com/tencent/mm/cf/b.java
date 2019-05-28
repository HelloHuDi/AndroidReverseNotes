package com.tencent.mm.cf;

import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.q;
import com.tencent.mm.performance.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b {
    public static final String ydz = (Environment.getExternalStorageDirectory() + "/tencent/MicroMsg/memory/");

    static {
        AppMethodBeat.i(76898);
        AppMethodBeat.o(76898);
    }

    private static boolean dvR() {
        AppMethodBeat.i(76890);
        if (c.Mn()) {
            File file = new File(ydz);
            if (!file.exists()) {
                file.mkdirs();
            }
            AppMethodBeat.o(76890);
            return true;
        }
        ab.i("MicroMsg.MemoryDumpManager", "Hprof sdcard is invalid");
        AppMethodBeat.o(76890);
        return false;
    }

    private static boolean af(boolean z, boolean z2) {
        AppMethodBeat.i(76891);
        if (dvR()) {
            File file = new File(ydz);
            File[] listFiles = file.listFiles();
            if (listFiles.length == 0) {
                AppMethodBeat.o(76891);
                return true;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            long time = new Date().getTime();
            boolean z3 = true;
            for (File file2 : listFiles) {
                String name = file2.getName();
                int indexOf = name.indexOf(".hprof");
                if (indexOf > 0) {
                    Object substring = name.substring(0, indexOf);
                    try {
                        Date parse = simpleDateFormat.parse(substring);
                        if (parse == null) {
                            file2.delete();
                        } else {
                            long time2 = parse.getTime();
                            if (time2 >= time) {
                                file2.delete();
                            } else {
                                time2 = (time - time2) / 86400000;
                                if (time2 >= 3) {
                                    file2.delete();
                                } else if (z && time2 < 1) {
                                    z3 = false;
                                }
                            }
                        }
                    } catch (ParseException e) {
                        ab.e("MicroMsg.MemoryDumpManager", "hprofFileCheck parse date fail %s", substring);
                        file2.delete();
                    }
                } else {
                    file2.delete();
                }
            }
            File[] listFiles2 = file.listFiles();
            if (listFiles2.length > 5) {
                if (z2) {
                    Toast.makeText(ah.getContext(), "dump fail, hprof file size exceed", 0).show();
                }
                ab.w("MicroMsg.MemoryDumpManager", "hprofFileCheck hprofFileDir.length() too large " + listFiles2.length);
                AppMethodBeat.o(76891);
                return false;
            }
            AppMethodBeat.o(76891);
            return z3;
        }
        AppMethodBeat.o(76891);
        return false;
    }

    public static String ag(boolean z, boolean z2) {
        AppMethodBeat.i(76892);
        if (af(z, z2)) {
            long currentTimeMillis = System.currentTimeMillis();
            String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(ydz).append(format).append(".hprof");
            String stringBuffer2 = stringBuffer.toString();
            if (Z(new File(stringBuffer2).getParentFile())) {
                try {
                    dvS();
                    Debug.dumpHprofData(stringBuffer2);
                    if (z2) {
                        Toast.makeText(ah.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
                    }
                    ab.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", format, Long.valueOf(bo.gb(currentTimeMillis)));
                    AppMethodBeat.o(76892);
                    return stringBuffer2;
                } catch (Exception e) {
                    ab.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
                    AppMethodBeat.o(76892);
                    return null;
                }
            }
            ab.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", stringBuffer2);
            AppMethodBeat.o(76892);
            return null;
        }
        AppMethodBeat.o(76892);
        return null;
    }

    public static String aqz(String str) {
        AppMethodBeat.i(76893);
        if (dvR()) {
            long currentTimeMillis = System.currentTimeMillis();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(ydz).append(str).append(".hprof");
            String stringBuffer2 = stringBuffer.toString();
            if (Z(new File(stringBuffer2).getParentFile())) {
                try {
                    dvS();
                    Debug.dumpHprofData(stringBuffer2);
                    Toast.makeText(ah.getContext(), stringBuffer2 + " hprof file has saved ", 0).show();
                    ab.i("MicroMsg.MemoryDumpManager", "dump file %s, use time %d", str, Long.valueOf(bo.gb(currentTimeMillis)));
                    File file = new File(stringBuffer2);
                    if (file.exists()) {
                        stringBuffer2 = q.b(file, true, null);
                        if (stringBuffer2 == null) {
                            ab.e("MicroMsg.MemoryDumpManager", "zip hprof file fail");
                            AppMethodBeat.o(76893);
                            return null;
                        }
                        AppMethodBeat.o(76893);
                        return stringBuffer2;
                    }
                    ab.e("MicroMsg.MemoryDumpManager", "Hprof dump file is not exist");
                    AppMethodBeat.o(76893);
                    return null;
                } catch (Exception e) {
                    ab.e("MicroMsg.MemoryDumpManager", " dumpHprofFile Exception");
                    AppMethodBeat.o(76893);
                    return null;
                }
            }
            ab.i("MicroMsg.MemoryDumpManager", "failed to create dir for hprof file: %s", stringBuffer2);
            AppMethodBeat.o(76893);
            return null;
        }
        AppMethodBeat.o(76893);
        return null;
    }

    private static boolean Z(File file) {
        AppMethodBeat.i(76894);
        if (file.exists()) {
            AppMethodBeat.o(76894);
            return true;
        } else if (file.mkdirs()) {
            AppMethodBeat.o(76894);
            return true;
        } else {
            boolean exists = file.exists();
            AppMethodBeat.o(76894);
            return exists;
        }
    }

    public static void dvS() {
        AppMethodBeat.i(76895);
        Runtime.getRuntime().gc();
        System.runFinalization();
        AppMethodBeat.o(76895);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:14:0x0051=Splitter:B:14:0x0051, B:33:0x0085=Splitter:B:33:0x0085} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A:{SYNTHETIC, Splitter:B:17:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A:{Catch:{ IOException -> 0x007d }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090 A:{SYNTHETIC, Splitter:B:36:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095 A:{Catch:{ IOException -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A:{SYNTHETIC, Splitter:B:17:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A:{Catch:{ IOException -> 0x007d }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090 A:{SYNTHETIC, Splitter:B:36:0x0090} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0095 A:{Catch:{ IOException -> 0x009d }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9 A:{SYNTHETIC, Splitter:B:46:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ae A:{Catch:{ IOException -> 0x00b5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9 A:{SYNTHETIC, Splitter:B:46:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ae A:{Catch:{ IOException -> 0x00b5 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void dvT() {
        Throwable th;
        LineNumberReader lineNumberReader;
        AppMethodBeat.i(76896);
        if (VERSION.SDK_INT >= 14) {
            a.any().df(true);
            AppMethodBeat.o(76896);
            return;
        }
        InputStreamReader inputStreamReader;
        LineNumberReader lineNumberReader2;
        try {
            Process exec = Runtime.getRuntime().exec("dumpsys meminfo " + Process.myPid());
            inputStreamReader = new InputStreamReader(exec.getInputStream());
            try {
                lineNumberReader2 = new LineNumberReader(inputStreamReader);
                while (true) {
                    try {
                        String readLine = lineNumberReader2.readLine();
                        if (readLine != null) {
                            ab.i("MicroMsg.MemoryDumpManager", readLine);
                        } else {
                            exec.waitFor();
                            exec.destroy();
                            try {
                                lineNumberReader2.close();
                                inputStreamReader.close();
                                AppMethodBeat.o(76896);
                                return;
                            } catch (IOException e) {
                                AppMethodBeat.o(76896);
                                return;
                            }
                        }
                    } catch (IOException e2) {
                        try {
                            ab.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
                            if (lineNumberReader2 != null) {
                                try {
                                    lineNumberReader2.close();
                                } catch (IOException e3) {
                                    AppMethodBeat.o(76896);
                                    return;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            AppMethodBeat.o(76896);
                        } catch (Throwable th2) {
                            th = th2;
                            lineNumberReader = lineNumberReader2;
                            if (lineNumberReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            AppMethodBeat.o(76896);
                            throw th;
                        }
                    } catch (InterruptedException e4) {
                        ab.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
                        if (lineNumberReader2 != null) {
                            try {
                                lineNumberReader2.close();
                            } catch (IOException e5) {
                                AppMethodBeat.o(76896);
                                return;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        AppMethodBeat.o(76896);
                    }
                }
            } catch (IOException e6) {
                lineNumberReader2 = null;
                ab.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
                if (lineNumberReader2 != null) {
                }
                if (inputStreamReader != null) {
                }
                AppMethodBeat.o(76896);
            } catch (InterruptedException e7) {
                lineNumberReader2 = null;
                ab.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
                if (lineNumberReader2 != null) {
                }
                if (inputStreamReader != null) {
                }
                AppMethodBeat.o(76896);
            } catch (Throwable th3) {
                th = th3;
                lineNumberReader = null;
                if (lineNumberReader != null) {
                    try {
                        lineNumberReader.close();
                    } catch (IOException e8) {
                        AppMethodBeat.o(76896);
                        throw th;
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                AppMethodBeat.o(76896);
                throw th;
            }
        } catch (IOException e9) {
            lineNumberReader2 = null;
            inputStreamReader = null;
            ab.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo IOException");
            if (lineNumberReader2 != null) {
            }
            if (inputStreamReader != null) {
            }
            AppMethodBeat.o(76896);
        } catch (InterruptedException e10) {
            lineNumberReader2 = null;
            inputStreamReader = null;
            ab.e("MicroMsg.MemoryDumpManager", " dumpSysMeminfo InterruptedException");
            if (lineNumberReader2 != null) {
            }
            if (inputStreamReader != null) {
            }
            AppMethodBeat.o(76896);
        } catch (Throwable th32) {
            th = th32;
            lineNumberReader = null;
            inputStreamReader = null;
            if (lineNumberReader != null) {
            }
            if (inputStreamReader != null) {
            }
            AppMethodBeat.o(76896);
            throw th;
        }
    }

    public static void dvU() {
        AppMethodBeat.i(139046);
        a.any().df(true);
        AppMethodBeat.o(139046);
    }
}
