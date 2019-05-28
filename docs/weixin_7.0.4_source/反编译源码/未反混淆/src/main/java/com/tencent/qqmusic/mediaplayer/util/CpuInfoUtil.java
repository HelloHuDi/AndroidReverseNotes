package com.tencent.qqmusic.mediaplayer.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CpuInfoUtil {
    private static final String CUR_CPU_FREQ = "/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq";
    private static final String TAG = "CpuInfoUtil";
    private static OutputCpuThread mCurrThread = null;

    static class OutputCpuThread extends Thread {
        public boolean isStop = false;

        public OutputCpuThread(String str) {
            super(str);
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A:{SYNTHETIC, Splitter:B:32:0x0087} */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0 A:{SYNTHETIC, Splitter:B:41:0x00a0} */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00a5  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0 A:{SYNTHETIC, Splitter:B:41:0x00a0} */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00a5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            Throwable e;
            AppMethodBeat.i(128388);
            super.run();
            StringBuilder stringBuilder = new StringBuilder();
            Process exec;
            BufferedReader bufferedReader;
            try {
                exec = Runtime.getRuntime().exec("top -m 10 -s cpu -t");
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
                    int i = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null || this.isStop) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e2) {
                                    Logger.e(CpuInfoUtil.TAG, e2);
                                }
                                if (exec != null) {
                                    exec.destroy();
                                    AppMethodBeat.o(128388);
                                    return;
                                }
                            }
                            int i2 = i + 1;
                            stringBuilder.append(readLine).append(IOUtils.LINE_SEPARATOR_UNIX);
                            if (i2 > 15) {
                                try {
                                    Logger.d(CpuInfoUtil.TAG, stringBuilder.toString());
                                    stringBuilder.delete(0, stringBuilder.length() - 1);
                                    sleep(5000);
                                    i = 0;
                                } catch (Exception e22) {
                                    Logger.e(CpuInfoUtil.TAG, e22);
                                    i = i2;
                                }
                            } else {
                                i = i2;
                            }
                        } catch (Exception e3) {
                            e22 = e3;
                            try {
                                Logger.e(CpuInfoUtil.TAG, e22);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e222) {
                                        Logger.e(CpuInfoUtil.TAG, e222);
                                    }
                                }
                                if (exec != null) {
                                    exec.destroy();
                                    AppMethodBeat.o(128388);
                                    return;
                                }
                                AppMethodBeat.o(128388);
                            } catch (Throwable th) {
                                e222 = th;
                                if (bufferedReader != null) {
                                }
                                if (exec != null) {
                                }
                                AppMethodBeat.o(128388);
                                throw e222;
                            }
                        }
                    }
                } catch (Exception e4) {
                    e222 = e4;
                    bufferedReader = null;
                    Logger.e(CpuInfoUtil.TAG, e222);
                    if (bufferedReader != null) {
                    }
                    if (exec != null) {
                    }
                    AppMethodBeat.o(128388);
                } catch (Throwable th2) {
                    e222 = th2;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                            Logger.e(CpuInfoUtil.TAG, e5);
                        }
                    }
                    if (exec != null) {
                        exec.destroy();
                    }
                    AppMethodBeat.o(128388);
                    throw e222;
                }
            } catch (Exception e6) {
                e222 = e6;
                exec = null;
                bufferedReader = null;
            } catch (Throwable th3) {
                e222 = th3;
                exec = null;
                bufferedReader = null;
                if (bufferedReader != null) {
                }
                if (exec != null) {
                }
                AppMethodBeat.o(128388);
                throw e222;
            }
            AppMethodBeat.o(128388);
        }
    }

    public static synchronized void startProcessInfoOutput() {
        synchronized (CpuInfoUtil.class) {
        }
    }

    public static synchronized void stopProcessInfoOutput() {
        synchronized (CpuInfoUtil.class) {
            mCurrThread = null;
        }
    }

    public static void outputThreadInfoToLog() {
    }

    public static void outputCpuHZToLog() {
    }
}
