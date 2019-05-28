package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

public class ProcessUtils {
    private static String zzaai = null;
    private static int zzaaj = 0;

    public static class SystemGroupsNotAvailableException extends Exception {
        SystemGroupsNotAvailableException(String str) {
            super(str);
        }

        SystemGroupsNotAvailableException(String str, Throwable th) {
            super(str, th);
        }
    }

    private ProcessUtils() {
    }

    @Nullable
    public static String getCallingProcessName() {
        AppMethodBeat.i(90256);
        int callingPid = Binder.getCallingPid();
        String myProcessName;
        if (callingPid == zzde()) {
            myProcessName = getMyProcessName();
            AppMethodBeat.o(90256);
            return myProcessName;
        }
        myProcessName = zzl(callingPid);
        AppMethodBeat.o(90256);
        return myProcessName;
    }

    @Nullable
    public static String getMyProcessName() {
        AppMethodBeat.i(90257);
        if (zzaai == null) {
            zzaai = zzl(zzde());
        }
        String str = zzaai;
        AppMethodBeat.o(90257);
        return str;
    }

    public static boolean hasSystemGroups() {
        AppMethodBeat.i(90258);
        Closeable closeable = null;
        try {
            closeable = zzm("/proc/" + zzde() + "/status");
            boolean zzk = zzk(closeable);
            IOUtils.closeQuietly(closeable);
            AppMethodBeat.o(90258);
            return zzk;
        } catch (IOException e) {
            SystemGroupsNotAvailableException systemGroupsNotAvailableException = new SystemGroupsNotAvailableException("Unable to access /proc/pid/status.", e);
            AppMethodBeat.o(90258);
            throw systemGroupsNotAvailableException;
        } catch (Throwable th) {
            IOUtils.closeQuietly(closeable);
            AppMethodBeat.o(90258);
        }
    }

    private static int zzde() {
        AppMethodBeat.i(90262);
        if (zzaaj == 0) {
            zzaaj = Process.myPid();
        }
        int i = zzaaj;
        AppMethodBeat.o(90262);
        return i;
    }

    private static boolean zzk(BufferedReader bufferedReader) {
        AppMethodBeat.i(90259);
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            readLine = readLine.trim();
            if (readLine.startsWith("Groups:")) {
                for (String parseLong : readLine.substring(7).trim().split("\\s", -1)) {
                    try {
                        long parseLong2 = Long.parseLong(parseLong);
                        if (parseLong2 >= 1000 && parseLong2 < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                            AppMethodBeat.o(90259);
                            return true;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
                AppMethodBeat.o(90259);
                return false;
            }
            readLine = bufferedReader.readLine();
        }
        SystemGroupsNotAvailableException systemGroupsNotAvailableException = new SystemGroupsNotAvailableException("Missing Groups entry from proc/pid/status.");
        AppMethodBeat.o(90259);
        throw systemGroupsNotAvailableException;
    }

    @Nullable
    private static String zzl(int i) {
        Throwable th;
        Closeable closeable;
        String str = null;
        AppMethodBeat.i(90260);
        if (i <= 0) {
            AppMethodBeat.o(90260);
        } else {
            Closeable zzm;
            try {
                zzm = zzm("/proc/" + i + "/cmdline");
                try {
                    str = zzm.readLine().trim();
                    IOUtils.closeQuietly(zzm);
                } catch (IOException e) {
                    IOUtils.closeQuietly(zzm);
                    AppMethodBeat.o(90260);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = zzm;
                    IOUtils.closeQuietly(closeable);
                    AppMethodBeat.o(90260);
                    throw th;
                }
            } catch (IOException e2) {
                zzm = str;
            } catch (Throwable th3) {
                th = th3;
                closeable = str;
                IOUtils.closeQuietly(closeable);
                AppMethodBeat.o(90260);
                throw th;
            }
            AppMethodBeat.o(90260);
        }
        return str;
    }

    private static BufferedReader zzm(String str) {
        AppMethodBeat.i(90261);
        ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
            return bufferedReader;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            AppMethodBeat.o(90261);
        }
    }
}
