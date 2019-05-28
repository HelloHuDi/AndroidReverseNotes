package com.tencent.p177mm.plugin.traceroute.p1043b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/* renamed from: com.tencent.mm.plugin.traceroute.b.b */
public final class C40007b {

    /* renamed from: com.tencent.mm.plugin.traceroute.b.b$a */
    static class C14005a implements Runnable {
        private List<Object> mFf;
        private String[] sIM;

        public C14005a(String[] strArr, List<Object> list) {
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
            AppMethodBeat.m2504i(25985);
            StringBuilder stringBuilder = new StringBuilder();
            ProcessBuilder processBuilder = new ProcessBuilder(this.sIM);
            processBuilder.redirectErrorStream(true);
            long anU = C5046bo.anU();
            long anU2 = C5046bo.anU();
            Process start;
            BufferedReader bufferedReader;
            try {
                start = processBuilder.start();
                try {
                    C5046bo.m7527b(start.getOutputStream());
                    anU2 = C5046bo.anU();
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
                                C4990ab.m7412e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                                C40007b.m68510a(start, bufferedReader);
                                this.mFf.add(stringBuilder.toString());
                                this.mFf.add(Long.valueOf(anU2 - anU));
                                C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                                AppMethodBeat.m2505o(25985);
                            } catch (Throwable th2) {
                                th = th2;
                                C40007b.m68510a(start, bufferedReader);
                                AppMethodBeat.m2505o(25985);
                                throw th;
                            }
                        } catch (InterruptedException e5) {
                            e2 = e5;
                            C4990ab.m7412e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
                            C40007b.m68510a(start, bufferedReader);
                            this.mFf.add(stringBuilder.toString());
                            this.mFf.add(Long.valueOf(anU2 - anU));
                            C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                            AppMethodBeat.m2505o(25985);
                        } catch (Exception e6) {
                            e3 = e6;
                            C4990ab.m7412e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
                            C40007b.m68510a(start, bufferedReader);
                            this.mFf.add(stringBuilder.toString());
                            this.mFf.add(Long.valueOf(anU2 - anU));
                            C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                            AppMethodBeat.m2505o(25985);
                        }
                    }
                    start.waitFor();
                    C40007b.m68510a(start, bufferedReader);
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader = null;
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "run cmd err, io exception: " + e.getMessage());
                    C40007b.m68510a(start, bufferedReader);
                    this.mFf.add(stringBuilder.toString());
                    this.mFf.add(Long.valueOf(anU2 - anU));
                    C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    AppMethodBeat.m2505o(25985);
                } catch (InterruptedException e8) {
                    e2 = e8;
                    bufferedReader = null;
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
                    C40007b.m68510a(start, bufferedReader);
                    this.mFf.add(stringBuilder.toString());
                    this.mFf.add(Long.valueOf(anU2 - anU));
                    C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    AppMethodBeat.m2505o(25985);
                } catch (Exception e9) {
                    e3 = e9;
                    bufferedReader = null;
                    C4990ab.m7412e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
                    C40007b.m68510a(start, bufferedReader);
                    this.mFf.add(stringBuilder.toString());
                    this.mFf.add(Long.valueOf(anU2 - anU));
                    C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                    AppMethodBeat.m2505o(25985);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    C40007b.m68510a(start, bufferedReader);
                    AppMethodBeat.m2505o(25985);
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
                C4990ab.m7412e("MicroMsg.MMTraceRoute", "run cmd err, interruptedexception: " + e2.getMessage());
                C40007b.m68510a(start, bufferedReader);
                this.mFf.add(stringBuilder.toString());
                this.mFf.add(Long.valueOf(anU2 - anU));
                C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                AppMethodBeat.m2505o(25985);
            } catch (Exception e12) {
                e3 = e12;
                bufferedReader = null;
                start = null;
                C4990ab.m7412e("MicroMsg.MMTraceRoute", "run cmd err: " + e3.getMessage());
                C40007b.m68510a(start, bufferedReader);
                this.mFf.add(stringBuilder.toString());
                this.mFf.add(Long.valueOf(anU2 - anU));
                C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
                AppMethodBeat.m2505o(25985);
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                start = null;
                C40007b.m68510a(start, bufferedReader);
                AppMethodBeat.m2505o(25985);
                throw th;
            }
            this.mFf.add(stringBuilder.toString());
            this.mFf.add(Long.valueOf(anU2 - anU));
            C4990ab.m7416i("MicroMsg.MMTraceRoute", "stringbuilder: " + stringBuilder.toString());
            AppMethodBeat.m2505o(25985);
        }
    }

    public static String abO(String str) {
        AppMethodBeat.m2504i(25986);
        C4990ab.m7416i("MicroMsg.MMTraceRoute", "output string: ".concat(String.valueOf(str)));
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(25986);
            return null;
        }
        int indexOf = str.indexOf("time=");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(25986);
            return null;
        }
        indexOf += 5;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 < 0) {
            AppMethodBeat.m2505o(25986);
            return null;
        }
        String substring = str.substring(indexOf, indexOf2);
        AppMethodBeat.m2505o(25986);
        return substring;
    }

    public static int abP(String str) {
        AppMethodBeat.m2504i(25987);
        int indexOf = str.indexOf("ttl=");
        if (indexOf < 0) {
            AppMethodBeat.m2505o(25987);
            return -1;
        }
        indexOf += 4;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 < 0) {
            AppMethodBeat.m2505o(25987);
            return -1;
        }
        int i = C5046bo.getInt(str.substring(indexOf, indexOf2), 0);
        AppMethodBeat.m2505o(25987);
        return i;
    }

    /* renamed from: J */
    public static List<Object> m68509J(String[] strArr) {
        AppMethodBeat.m2504i(25988);
        String str = " ";
        for (int i = 0; i < 4; i++) {
            str = str + strArr[i] + " ";
        }
        C4990ab.m7416i("MicroMsg.MMTraceRoute", str);
        ArrayList arrayList = new ArrayList();
        C14005a c14005a = new C14005a(strArr, arrayList);
        C7305d.m12299g(c14005a, "MMTraceRouteCMDExecutor_watcher");
        try {
            C7305d.xDG.mo10148am(c14005a);
            C4990ab.m7416i("MicroMsg.MMTraceRoute", "watcher thread stopped".concat(String.valueOf(str)));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
        }
        AppMethodBeat.m2505o(25988);
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ void m68510a(Process process, BufferedReader bufferedReader) {
        AppMethodBeat.m2504i(25989);
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", th, "close reader failed", new Object[0]);
            }
        }
        if (process != null) {
            try {
                process.destroy();
                AppMethodBeat.m2505o(25989);
                return;
            } catch (Throwable th2) {
                C4990ab.printErrStackTrace("MicroMsg.MMTraceRoute", th2, "destroy process failed", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(25989);
    }
}
