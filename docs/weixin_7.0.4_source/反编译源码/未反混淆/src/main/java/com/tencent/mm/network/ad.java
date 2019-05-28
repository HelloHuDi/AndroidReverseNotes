package com.tencent.mm.network;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public final class ad {
    public static final String gen = (e.eSl + "/tencent/noop.dat");
    private static long geo;
    private static long lastUpdateTime;

    static {
        long j;
        AppMethodBeat.i(58692);
        lastUpdateTime = 0;
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("noop_prefs", 0);
        int i = sharedPreferences.getInt("noop_strategy", 1);
        if (1 == i) {
            geo = 270;
            new StringBuilder("getNoopIntervalInMs use hard code noop:").append(geo);
            j = geo * 1000;
        } else if (3 == i) {
            j = sharedPreferences.getLong("noop_min_interval", 270);
            if (j < 180 || j > 3600) {
                geo = 270;
                new StringBuilder("getNoopIntervalInMs use wx noop:").append(geo);
                j = geo * 1000;
            } else {
                geo = j;
                j *= 1000;
            }
        } else {
            j = System.currentTimeMillis() / 1000;
            if (j - lastUpdateTime > 3600) {
                long[] ant = ant();
                if (ant[0] < 180 || ant[0] > 3600) {
                    geo = 270;
                } else {
                    geo = ant[0];
                }
                lastUpdateTime = j;
            }
            new StringBuilder("getNoopIntervalInMs use sync noop:").append(geo);
            j = geo * 1000;
        }
        geo = j / 1000;
        AppMethodBeat.o(58692);
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x017c A:{SYNTHETIC, Splitter:B:68:0x017c} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0165 A:{SYNTHETIC, Splitter:B:59:0x0165} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void y(long j, long j2) {
        Exception e;
        Throwable th;
        AppMethodBeat.i(58690);
        new StringBuilder("setNoopInterval interval:").append(j).append(", svr:").append(j2);
        if (j2 > 0) {
            ah.getContext().getSharedPreferences("noop_prefs", 0).edit().putInt("noop_strategy", 2).commit();
            if (j < 180 || j > 3600) {
                AppMethodBeat.o(58690);
            } else if (System.currentTimeMillis() / 1000 < j2) {
                AppMethodBeat.o(58690);
            } else {
                try {
                    File file = new File(gen);
                    if (file.exists()) {
                        long[] ant = ant();
                        if (ant[1] > 0 && ant[1] >= j2) {
                            AppMethodBeat.o(58690);
                            return;
                        }
                    } else if (!file.createNewFile()) {
                        AppMethodBeat.o(58690);
                        return;
                    }
                    DataOutputStream dataOutputStream = null;
                    try {
                        file = new File(gen);
                        if (file.exists() || file.createNewFile()) {
                            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
                            try {
                                dataOutputStream2.writeInt((int) j);
                                dataOutputStream2.writeInt((int) j2);
                                dataOutputStream2.flush();
                                dataOutputStream2.close();
                                try {
                                    dataOutputStream2.close();
                                    AppMethodBeat.o(58690);
                                    return;
                                } catch (Exception e2) {
                                    AppMethodBeat.o(58690);
                                    return;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                dataOutputStream = dataOutputStream2;
                                try {
                                    new StringBuilder("writeFile Exception:").append(e.getStackTrace());
                                    if (dataOutputStream != null) {
                                        try {
                                            dataOutputStream.close();
                                        } catch (Exception e4) {
                                            AppMethodBeat.o(58690);
                                            return;
                                        }
                                    }
                                    AppMethodBeat.o(58690);
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (dataOutputStream != null) {
                                    }
                                    AppMethodBeat.o(58690);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                dataOutputStream = dataOutputStream2;
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                AppMethodBeat.o(58690);
                                throw th;
                            }
                        }
                        AppMethodBeat.o(58690);
                    } catch (Exception e6) {
                        e = e6;
                        new StringBuilder("writeFile Exception:").append(e.getStackTrace());
                        if (dataOutputStream != null) {
                        }
                        AppMethodBeat.o(58690);
                    }
                } catch (Exception e7) {
                    new StringBuilder("setNoopInterval Exception:").append(e7.getStackTrace());
                    AppMethodBeat.o(58690);
                }
            }
        } else if (j <= 0) {
            ah.getContext().getSharedPreferences("noop_prefs", 0).edit().putInt("noop_strategy", 1).commit();
            AppMethodBeat.o(58690);
        } else if (j < 180 || j > 3600) {
            new StringBuilder("setNoopInterval value invalid interval:").append(j).append(", _svrTime:").append(j2);
            AppMethodBeat.o(58690);
        } else {
            ah.getContext().getSharedPreferences("noop_prefs", 0).edit().putInt("noop_strategy", 3).putLong("noop_min_interval", j).commit();
            AppMethodBeat.o(58690);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083 A:{SYNTHETIC, Splitter:B:35:0x0083} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008e A:{SYNTHETIC, Splitter:B:41:0x008e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long[] ant() {
        Exception e;
        Throwable th;
        AppMethodBeat.i(58691);
        long[] jArr = new long[]{0, 0};
        File file = new File(gen);
        if (file.exists()) {
            DataInputStream dataInputStream;
            try {
                dataInputStream = new DataInputStream(new FileInputStream(file));
                try {
                    int readInt = dataInputStream.readInt();
                    if (((long) readInt) < 180 || ((long) readInt) > 3600) {
                        dataInputStream.close();
                        try {
                            dataInputStream.close();
                        } catch (Exception e2) {
                        }
                        AppMethodBeat.o(58691);
                    } else {
                        jArr[0] = (long) readInt;
                        readInt = dataInputStream.readInt();
                        if (((long) readInt) > System.currentTimeMillis() / 1000) {
                            dataInputStream.close();
                            try {
                                dataInputStream.close();
                            } catch (Exception e3) {
                            }
                            AppMethodBeat.o(58691);
                        } else {
                            jArr[1] = (long) readInt;
                            dataInputStream.close();
                            try {
                                dataInputStream.close();
                            } catch (Exception e4) {
                            }
                            AppMethodBeat.o(58691);
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    try {
                        new StringBuilder("getFromFile Exception:").append(e.getStackTrace());
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        AppMethodBeat.o(58691);
                        return jArr;
                    } catch (Throwable th2) {
                        th = th2;
                        if (dataInputStream != null) {
                        }
                        AppMethodBeat.o(58691);
                        throw th;
                    }
                }
            } catch (Exception e7) {
                e = e7;
                dataInputStream = null;
                new StringBuilder("getFromFile Exception:").append(e.getStackTrace());
                if (dataInputStream != null) {
                }
                AppMethodBeat.o(58691);
                return jArr;
            } catch (Throwable th3) {
                th = th3;
                dataInputStream = null;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (Exception e8) {
                    }
                }
                AppMethodBeat.o(58691);
                throw th;
            }
        }
        AppMethodBeat.o(58691);
        return jArr;
    }
}
