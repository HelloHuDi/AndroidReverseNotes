package com.tencent.p177mm.plugin.backup.bakoldlogic.p917b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.a */
public final class C36746a extends C33660a {
    private static String END = "img";
    private static String jvG = "icon_";
    private static String jvH = "iphone";
    private static String jvI = "android";
    private static String jvJ = "s60v3";
    private static String jvK = "s60v5";
    private static C36746a jyT;
    private Map<String, C11105a> jvM = null;

    /* renamed from: com.tencent.mm.plugin.backup.bakoldlogic.b.a$a */
    public static class C11105a {
        public String jvN = "";
        public String jvO = "";
        public String jvP = "";
        public String jvQ = "";

        public C11105a(String str, String str2, String str3, String str4) {
            this.jvN = str;
            this.jvO = str2;
            this.jvP = str3;
            this.jvQ = str4;
        }

        public final String toString() {
            AppMethodBeat.m2504i(17762);
            String str = this.jvN + " " + this.jvO + " " + this.jvP + " " + this.jvQ;
            AppMethodBeat.m2505o(17762);
            return str;
        }
    }

    /* renamed from: Fq */
    public static C11105a m60965Fq(String str) {
        AppMethodBeat.m2504i(17763);
        if (jyT == null) {
            jyT = new C36746a();
        }
        C36746a c36746a = jyT;
        if (c36746a.jvM == null) {
            c36746a.aTB();
        }
        for (C11105a c11105a : c36746a.jvM.values()) {
            if (c11105a.jvO != null && c11105a.jvO.equals(str)) {
                AppMethodBeat.m2505o(17763);
                return c11105a;
            }
        }
        AppMethodBeat.m2505o(17763);
        return null;
    }

    /* renamed from: Fr */
    public static C11105a m60966Fr(String str) {
        C36746a c36746a;
        AppMethodBeat.m2504i(17764);
        if (jyT == null) {
            c36746a = new C36746a();
            jyT = c36746a;
            C33660a.m54968a(c36746a);
        }
        c36746a = jyT;
        if (c36746a.jvM == null) {
            c36746a.aTB();
        }
        C11105a c11105a = (C11105a) c36746a.jvM.get(str);
        AppMethodBeat.m2505o(17764);
        return c11105a;
    }

    public final void aSp() {
        jyT = null;
    }

    public C36746a() {
        AppMethodBeat.m2504i(17765);
        aTB();
        AppMethodBeat.m2505o(17765);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac A:{SYNTHETIC, Splitter:B:38:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1 A:{Catch:{ Exception -> 0x00f0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac A:{SYNTHETIC, Splitter:B:38:0x00ac} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1 A:{Catch:{ Exception -> 0x00f0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081 A:{SYNTHETIC, Splitter:B:26:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086 A:{Catch:{ Exception -> 0x00f9 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aTB() {
        Throwable e;
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(17766);
        this.jvM = new HashMap();
        InputStream open;
        BufferedReader bufferedReader;
        try {
            open = C4996ah.getContext().getAssets().open("emojiconf");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (Exception e2) {
                            }
                        } else if (readLine.contains(jvG)) {
                            C11105a c11105a = new C11105a();
                            while (true) {
                                String readLine2 = bufferedReader.readLine();
                                if (readLine2 != null && !readLine2.contains(END)) {
                                    int indexOf = readLine2.indexOf("=");
                                    if (indexOf + 1 >= readLine2.length()) {
                                        break;
                                    }
                                    String substring = readLine2.substring(indexOf + 1);
                                    if (readLine2.startsWith(jvH)) {
                                        c11105a.jvO = substring;
                                    } else if (readLine2.startsWith(jvI)) {
                                        c11105a.jvN = substring;
                                    } else if (readLine2.startsWith(jvJ)) {
                                        c11105a.jvP = substring;
                                    } else if (readLine2.startsWith(jvK)) {
                                        c11105a.jvQ = substring;
                                    }
                                    this.jvM.put(c11105a.jvN, c11105a);
                                } else {
                                    break;
                                }
                            }
                            C4990ab.m7411d("MicroMsg.BakOldEmojiCovertMap", "emojiValue:%s", c11105a.toString());
                            i++;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.BakOldEmojiCovertMap", e, "", new Object[0]);
                            if (bufferedReader != null) {
                            }
                            if (open != null) {
                            }
                            C4990ab.m7410d("MicroMsg.BakOldEmojiCovertMap", "id ".concat(String.valueOf(i)));
                            AppMethodBeat.m2505o(17766);
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                            }
                            if (open != null) {
                            }
                            AppMethodBeat.m2505o(17766);
                            throw th;
                        }
                    }
                }
                bufferedReader.close();
                if (open != null) {
                    open.close();
                }
            } catch (IOException e4) {
                e = e4;
                bufferedReader = null;
                C4990ab.printErrStackTrace("MicroMsg.BakOldEmojiCovertMap", e, "", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                    }
                }
                if (open != null) {
                    open.close();
                }
                C4990ab.m7410d("MicroMsg.BakOldEmojiCovertMap", "id ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(17766);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e6) {
                        AppMethodBeat.m2505o(17766);
                        throw th;
                    }
                }
                if (open != null) {
                    open.close();
                }
                AppMethodBeat.m2505o(17766);
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            bufferedReader = null;
            open = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            open = null;
            if (bufferedReader != null) {
            }
            if (open != null) {
            }
            AppMethodBeat.m2505o(17766);
            throw th;
        }
        C4990ab.m7410d("MicroMsg.BakOldEmojiCovertMap", "id ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(17766);
    }
}
