package com.tencent.p177mm.plugin.backup.p346f;

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

/* renamed from: com.tencent.mm.plugin.backup.f.k */
public final class C19973k extends C33660a {
    private static String END = "img";
    private static String jvG = "icon_";
    private static String jvH = "iphone";
    private static String jvI = "android";
    private static String jvJ = "s60v3";
    private static String jvK = "s60v5";
    private static C19973k jvL;
    private Map<String, C19974a> jvM = null;

    /* renamed from: com.tencent.mm.plugin.backup.f.k$a */
    public static class C19974a {
        public String jvN = "";
        public String jvO = "";
        public String jvP = "";
        public String jvQ = "";

        public C19974a(String str, String str2, String str3, String str4) {
            this.jvN = str;
            this.jvO = str2;
            this.jvP = str3;
            this.jvQ = str4;
        }

        public final String toString() {
            AppMethodBeat.m2504i(17472);
            String str = this.jvN + " " + this.jvO + " " + this.jvP + " " + this.jvQ;
            AppMethodBeat.m2505o(17472);
            return str;
        }
    }

    /* renamed from: Fk */
    public static C19974a m30871Fk(String str) {
        AppMethodBeat.m2504i(17473);
        if (jvL == null) {
            jvL = new C19973k();
        }
        C19973k c19973k = jvL;
        if (c19973k.jvM == null) {
            c19973k.aTB();
        }
        for (C19974a c19974a : c19973k.jvM.values()) {
            if (c19974a.jvO != null && c19974a.jvO.equals(str)) {
                AppMethodBeat.m2505o(17473);
                return c19974a;
            }
        }
        AppMethodBeat.m2505o(17473);
        return null;
    }

    /* renamed from: Fl */
    public static C19974a m30872Fl(String str) {
        C19973k c19973k;
        AppMethodBeat.m2504i(17474);
        if (jvL == null) {
            c19973k = new C19973k();
            jvL = c19973k;
            C33660a.m54968a(c19973k);
        }
        c19973k = jvL;
        if (c19973k.jvM == null) {
            c19973k.aTB();
        }
        C19974a c19974a = (C19974a) c19973k.jvM.get(str);
        AppMethodBeat.m2505o(17474);
        return c19974a;
    }

    public final void aSp() {
        jvL = null;
    }

    public C19973k() {
        AppMethodBeat.m2504i(17475);
        aTB();
        AppMethodBeat.m2505o(17475);
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
        AppMethodBeat.m2504i(17476);
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
                            C19974a c19974a = new C19974a();
                            while (true) {
                                String readLine2 = bufferedReader.readLine();
                                if (readLine2 != null && !readLine2.contains(END)) {
                                    int indexOf = readLine2.indexOf("=");
                                    if (indexOf + 1 >= readLine2.length()) {
                                        break;
                                    }
                                    String substring = readLine2.substring(indexOf + 1);
                                    if (readLine2.startsWith(jvH)) {
                                        c19974a.jvO = substring;
                                    } else if (readLine2.startsWith(jvI)) {
                                        c19974a.jvN = substring;
                                    } else if (readLine2.startsWith(jvJ)) {
                                        c19974a.jvP = substring;
                                    } else if (readLine2.startsWith(jvK)) {
                                        c19974a.jvQ = substring;
                                    }
                                    this.jvM.put(c19974a.jvN, c19974a);
                                } else {
                                    break;
                                }
                            }
                            C4990ab.m7411d("MicroMsg.EmojiCovertMap", "emojiValue:%s", c19974a.toString());
                            i++;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.EmojiCovertMap", e, "", new Object[0]);
                            if (bufferedReader != null) {
                            }
                            if (open != null) {
                            }
                            C4990ab.m7410d("MicroMsg.EmojiCovertMap", "id ".concat(String.valueOf(i)));
                            AppMethodBeat.m2505o(17476);
                        } catch (Throwable th2) {
                            th = th2;
                            if (bufferedReader != null) {
                            }
                            if (open != null) {
                            }
                            AppMethodBeat.m2505o(17476);
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
                C4990ab.printErrStackTrace("MicroMsg.EmojiCovertMap", e, "", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                    }
                }
                if (open != null) {
                    open.close();
                }
                C4990ab.m7410d("MicroMsg.EmojiCovertMap", "id ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(17476);
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e6) {
                        AppMethodBeat.m2505o(17476);
                        throw th;
                    }
                }
                if (open != null) {
                    open.close();
                }
                AppMethodBeat.m2505o(17476);
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
            AppMethodBeat.m2505o(17476);
            throw th;
        }
        C4990ab.m7410d("MicroMsg.EmojiCovertMap", "id ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(17476);
    }
}
