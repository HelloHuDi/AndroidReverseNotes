package com.tencent.mm.plugin.traceroute.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public final class b {

    static class a implements Runnable {
        private List<Object> mFf;
        private String[] sIM;

        public a(String[] strArr, List<Object> list) {
            this.sIM = strArr;
            this.mFf = list;
        }

        /* JADX WARNING: Unknown top exception splitter block from list: {B:21:0x00a0=Splitter:B:21:0x00a0, B:26:0x00c1=Splitter:B:26:0x00c1, B:11:0x0048=Splitter:B:11:0x0048} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            IOException e;
            Throwable th;
            InterruptedException e2;
            Exception e3;
            AppMethodBeat.i(25985);
            StringBuilder stringBuilder = new StringBuilder();
            ProcessBuilder processBuilder = new ProcessBuilder(this.sIM);
            processBuilder.redirectErrorStream(true);
            long anU = bo.anU();
            long anU2 = bo.anU();
            Process start;
            BufferedReader bufferedReader;
            try {
                start = processBuilder.start();
                try {
                    bo.b(start.getOutputStream());
                    anU2 = bo.anU();
                    bufferedReader = new BufferedReader(new InputStreamReader(start.getInputStream()), 8096);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuilder.append(readLine);
                        } catch (IOException e4) {
                            e = e4;
                            try {
                                ab.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                                b.a(start, bufferedReader);
                                this.mFf.add(stringBuilder.toString());
                                this.mFf.add(Long.valueOf(anU2 - anU));
                                ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                                AppMethodBeat.o(25985);
                            } catch (Throwable th2) {
                                th = th2;
                                b.a(start, bufferedReader);
                                AppMethodBeat.o(25985);
                                throw th;
                            }
                        } catch (InterruptedException e5) {
                            e2 = e5;
                            ab.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
                            b.a(start, bufferedReader);
                            this.mFf.add(stringBuilder.toString());
                            this.mFf.add(Long.valueOf(anU2 - anU));
                            ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                            AppMethodBeat.o(25985);
                        } catch (Exception e6) {
                            e3 = e6;
                            ab.e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
                            b.a(start, bufferedReader);
                            this.mFf.add(stringBuilder.toString());
                            this.mFf.add(Long.valueOf(anU2 - anU));
                            ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                            AppMethodBeat.o(25985);
                        }
                    }
                    start.waitFor();
                    b.a(start, bufferedReader);
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader = null;
                    ab.e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                    b.a(start, bufferedReader);
                    this.mFf.add(stringBuilder.toString());
                    this.mFf.add(Long.valueOf(anU2 - anU));
                    ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    AppMethodBeat.o(25985);
                } catch (InterruptedException e8) {
                    e2 = e8;
                    bufferedReader = null;
                    ab.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
                    b.a(start, bufferedReader);
                    this.mFf.add(stringBuilder.toString());
                    this.mFf.add(Long.valueOf(anU2 - anU));
                    ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    AppMethodBeat.o(25985);
                } catch (Exception e9) {
                    e3 = e9;
                    bufferedReader = null;
                    ab.e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
                    b.a(start, bufferedReader);
                    this.mFf.add(stringBuilder.toString());
                    this.mFf.add(Long.valueOf(anU2 - anU));
                    ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    AppMethodBeat.o(25985);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    b.a(start, bufferedReader);
                    AppMethodBeat.o(25985);
                    throw th;
                }
            } catch (IOException e10) {
                e = e10;
                bufferedReader = null;
                start = null;
            } catch (InterruptedException e11) {
                e2 = e11;
                bufferedReader = null;
                start = null;
                ab.e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
                b.a(start, bufferedReader);
                this.mFf.add(stringBuilder.toString());
                this.mFf.add(Long.valueOf(anU2 - anU));
                ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                AppMethodBeat.o(25985);
            } catch (Exception e12) {
                e3 = e12;
                bufferedReader = null;
                start = null;
                ab.e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
                b.a(start, bufferedReader);
                this.mFf.add(stringBuilder.toString());
                this.mFf.add(Long.valueOf(anU2 - anU));
                ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                AppMethodBeat.o(25985);
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                start = null;
                b.a(start, bufferedReader);
                AppMethodBeat.o(25985);
                throw th;
            }
            this.mFf.add(stringBuilder.toString());
            this.mFf.add(Long.valueOf(anU2 - anU));
            ab.i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            AppMethodBeat.o(25985);
        }
    }

    public static String abO(String str) {
        AppMethodBeat.i(25986);
        ab.i("MicroMsg.MMTraceRoute", "output string: ".concat(String.valueOf(str)));
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(25986);
            return null;
        }
        int indexOf = str.indexOf("time=");
        if (indexOf < 0) {
            AppMethodBeat.o(25986);
            return null;
        }
        indexOf += 5;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 < 0) {
            AppMethodBeat.o(25986);
            return null;
        }
        String substring = str.substring(indexOf, indexOf2);
        AppMethodBeat.o(25986);
        return substring;
    }

    public static int abP(String str) {
        AppMethodBeat.i(25987);
        int indexOf = str.indexOf("ttl=");
        if (indexOf < 0) {
            AppMethodBeat.o(25987);
            return -1;
        }
        indexOf += 4;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 < 0) {
            AppMethodBeat.o(25987);
            return -1;
        }
        int i = bo.getInt(str.substring(indexOf, indexOf2), 0);
        AppMethodBeat.o(25987);
        return i;
    }

    public static List<Object> J(String[] strArr) {
        AppMethodBeat.i(25988);
        String str = " ";
        for (int i = 0; i < 4; i++) {
            str = str + strArr[i] + " ";
        }
        ab.i("MicroMsg.MMTraceRoute", str);
        ArrayList arrayList = new ArrayList();
        a aVar = new a(strArr, arrayList);
        d.g(aVar, "MMTraceRouteCMDExecutor_watcher");
        try {
            d.xDG.am(aVar);
            ab.i("MicroMsg.MMTraceRoute", "watcher thread stopped".concat(String.valueOf(str)));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
        }
        AppMethodBeat.o(25988);
        return arrayList;
    }

    static /* synthetic */ void a(Process process, BufferedReader bufferedReader) {
        AppMethodBeat.i(25989);
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.MMTraceRoute", th, "close reader failed", new Object[0]);
            }
        }
        if (process != null) {
            try {
                process.destroy();
                AppMethodBeat.o(25989);
                return;
            } catch (Throwable th2) {
                ab.printErrStackTrace("MicroMsg.MMTraceRoute", th2, "destroy process failed", new Object[0]);
            }
        }
        AppMethodBeat.o(25989);
    }
}
