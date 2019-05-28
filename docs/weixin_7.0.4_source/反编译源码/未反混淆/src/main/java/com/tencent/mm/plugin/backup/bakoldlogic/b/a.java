package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.plugin.backup.b.a {
    private static String END = "img";
    private static String jvG = "icon_";
    private static String jvH = "iphone";
    private static String jvI = "android";
    private static String jvJ = "s60v3";
    private static String jvK = "s60v5";
    private static a jyT;
    private Map<String, a> jvM = null;

    public static class a {
        public String jvN = "";
        public String jvO = "";
        public String jvP = "";
        public String jvQ = "";

        public a(String str, String str2, String str3, String str4) {
            this.jvN = str;
            this.jvO = str2;
            this.jvP = str3;
            this.jvQ = str4;
        }

        public final String toString() {
            AppMethodBeat.i(17762);
            String str = this.jvN + " " + this.jvO + " " + this.jvP + " " + this.jvQ;
            AppMethodBeat.o(17762);
            return str;
        }
    }

    public static a Fq(String str) {
        AppMethodBeat.i(17763);
        if (jyT == null) {
            jyT = new a();
        }
        a aVar = jyT;
        if (aVar.jvM == null) {
            aVar.aTB();
        }
        for (a aVar2 : aVar.jvM.values()) {
            if (aVar2.jvO != null && aVar2.jvO.equals(str)) {
                AppMethodBeat.o(17763);
                return aVar2;
            }
        }
        AppMethodBeat.o(17763);
        return null;
    }

    public static a Fr(String str) {
        a aVar;
        AppMethodBeat.i(17764);
        if (jyT == null) {
            aVar = new a();
            jyT = aVar;
            com.tencent.mm.plugin.backup.b.a.a(aVar);
        }
        aVar = jyT;
        if (aVar.jvM == null) {
            aVar.aTB();
        }
        a aVar2 = (a) aVar.jvM.get(str);
        AppMethodBeat.o(17764);
        return aVar2;
    }

    public final void aSp() {
        jyT = null;
    }

    public a() {
        AppMethodBeat.i(17765);
        aTB();
        AppMethodBeat.o(17765);
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
        AppMethodBeat.i(17766);
        this.jvM = new HashMap();
        InputStream open;
        BufferedReader bufferedReader;
        try {
            open = ah.getContext().getAssets().open("emojiconf");
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
                            a aVar = new a();
                            while (true) {
                                String readLine2 = bufferedReader.readLine();
                                if (readLine2 != null && !readLine2.contains(END)) {
                                    int indexOf = readLine2.indexOf("=");
                                    if (indexOf + 1 >= readLine2.length()) {
                                        break;
                                    }
                                    String substring = readLine2.substring(indexOf + 1);
                                    if (readLine2.startsWith(jvH)) {
                                        aVar.jvO = substring;
                                    } else if (readLine2.startsWith(jvI)) {
                                        aVar.jvN = substring;
                                    } else if (readLine2.startsWith(jvJ)) {
                                        aVar.jvP = substring;
                                    } else if (readLine2.startsWith(jvK)) {
                                        aVar.jvQ = substring;
                                    }
                                    this.jvM.put(aVar.jvN, aVar);
                                } else {
                                    break;
                                }
                            }
                            ab.d("MicroMsg.BakOldEmojiCovertMap", "emojiValue:%s", aVar.toString());
                            i++;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            ab.printErrStackTrace("MicroMsg.BakOldEmojiCovertMap", e, "", new Object[0]);
                            if (bufferedReader != null) {
                            }
                            if (open != null) {
                            }
                            ab.d("MicroMsg.BakOldEmojiCovertMap", "id ".concat(String.valueOf(i)));
                            AppMethodBeat.o(17766);
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                            }
                            if (open != null) {
                            }
                            AppMethodBeat.o(17766);
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
                ab.printErrStackTrace("MicroMsg.BakOldEmojiCovertMap", e, "", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                    }
                }
                if (open != null) {
                    open.close();
                }
                ab.d("MicroMsg.BakOldEmojiCovertMap", "id ".concat(String.valueOf(i)));
                AppMethodBeat.o(17766);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e6) {
                        AppMethodBeat.o(17766);
                        throw th;
                    }
                }
                if (open != null) {
                    open.close();
                }
                AppMethodBeat.o(17766);
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
            AppMethodBeat.o(17766);
            throw th;
        }
        ab.d("MicroMsg.BakOldEmojiCovertMap", "id ".concat(String.valueOf(i)));
        AppMethodBeat.o(17766);
    }
}
