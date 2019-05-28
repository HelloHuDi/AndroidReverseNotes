package com.tencent.p177mm.p707ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5729c;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5733h;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ba.r */
public class C41787r implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    C4884c fMA = new C323303();
    private C9067n fMu;
    private C45179b fMv;
    private C9068o fMw = new C9068o();
    private C25855p fMx = new C25855p();
    private C9069q fMy = new C9069q();
    private C37506l fMz = null;

    /* renamed from: com.tencent.mm.ba.r$4 */
    class C90704 implements C5729c {
        C90704() {
        }

        /* renamed from: f */
        public final boolean mo11676f(C5728b c5728b) {
            AppMethodBeat.m2504i(78510);
            boolean endsWith = c5728b.getName().endsWith("txt");
            AppMethodBeat.m2505o(78510);
            return endsWith;
        }
    }

    /* renamed from: com.tencent.mm.ba.r$2 */
    static class C179712 implements C1366d {
        C179712() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C45179b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.ba.r$3 */
    class C323303 extends C4884c<C32519bf> {
        C323303() {
            AppMethodBeat.m2504i(78508);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(78508);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(78509);
            C32519bf c32519bf = (C32519bf) c4883b;
            if (c32519bf.cus.cut == 47 && c32519bf.cus.cuu == 1) {
                C4990ab.m7416i("MicroMsg.SubCorePacakge", "going to update region code.");
                C41787r.m73758a(C41787r.this, c32519bf.cus.filePath);
            }
            AppMethodBeat.m2505o(78509);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ba.r$1 */
    static class C417861 implements C1366d {
        C417861() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C9067n.fnj;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m73758a(C41787r c41787r, String str) {
        AppMethodBeat.m2504i(78518);
        boolean sV = c41787r.m73759sV(str);
        AppMethodBeat.m2505o(78518);
        return sV;
    }

    public C41787r() {
        AppMethodBeat.m2504i(78511);
        AppMethodBeat.m2505o(78511);
    }

    private static C41787r aiw() {
        AppMethodBeat.m2504i(78512);
        C41787r c41787r = (C41787r) C7485q.m12925Y(C41787r.class);
        AppMethodBeat.m2505o(78512);
        return c41787r;
    }

    public static C9067n aix() {
        AppMethodBeat.m2504i(78513);
        C1720g.m3534RN().mo5159QU();
        if (C41787r.aiw().fMu == null) {
            C41787r.aiw().fMu = new C9067n(C1720g.m3536RP().eJN);
        }
        C9067n c9067n = C41787r.aiw().fMu;
        AppMethodBeat.m2505o(78513);
        return c9067n;
    }

    public static C45179b aiy() {
        AppMethodBeat.m2504i(78514);
        C1720g.m3534RN().mo5159QU();
        if (C41787r.aiw().fMv == null) {
            C41787r.aiw().fMv = new C45179b(C1720g.m3536RP().eJN);
        }
        C45179b c45179b = C41787r.aiw().fMv;
        AppMethodBeat.m2505o(78514);
        return c45179b;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(78515);
        C4879a.xxA.mo10053d(this.fMw);
        C4879a.xxA.mo10053d(this.fMx);
        C4879a.xxA.mo10053d(this.fMy);
        C4879a.xxA.mo10053d(this.fMz.fMq);
        C4879a.xxA.mo10053d(this.fMz.fMr);
        C4879a.xxA.mo10053d(this.fMA);
        AppMethodBeat.m2505o(78515);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(78516);
        C4879a.xxA.mo10052c(this.fMw);
        C4879a.xxA.mo10052c(this.fMx);
        C4879a.xxA.mo10052c(this.fMy);
        C4879a.xxA.mo10052c(this.fMA);
        if (this.fMz != null) {
            this.fMz.fMp.clear();
        } else {
            this.fMz = new C37506l();
        }
        C4879a.xxA.mo10052c(this.fMz.fMq);
        C4879a.xxA.mo10052c(this.fMz.fMr);
        AppMethodBeat.m2505o(78516);
    }

    static {
        AppMethodBeat.m2504i(78519);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new C417861());
        eaA.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new C179712());
        AppMethodBeat.m2505o(78519);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0119 A:{SYNTHETIC, Splitter:B:50:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a A:{Catch:{ IOException -> 0x0136 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0119 A:{SYNTHETIC, Splitter:B:50:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a A:{Catch:{ IOException -> 0x0136 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: sV */
    private boolean m73759sV(String str) {
        Throwable e;
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        AppMethodBeat.m2504i(78517);
        C5728b c5728b = new C5728b(str);
        if (c5728b.exists()) {
            HashMap hashMap = new HashMap();
            InputStream p;
            try {
                p = C5730e.m8638p(c5728b);
                BufferedWriter bufferedWriter;
                try {
                    C5728b c5728b2;
                    InputStreamReader inputStreamReader = new InputStreamReader(p, ProtocolPackage.ServerEncoding);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.trim().split("\\|");
                        if (split.length < 2 || C5046bo.isNullOrNil(split[0]) || C5046bo.isNullOrNil(split[1])) {
                            C4990ab.m7412e("MicroMsg.SubCorePacakge", "dispatch regioncode, error line = ".concat(String.valueOf(readLine)));
                        } else {
                            bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                            if (bufferedWriter == null) {
                                RegionCodeDecoder.duj();
                                str2 = RegionCodeDecoder.apP(split[0]);
                                if (!C5046bo.isNullOrNil(str2)) {
                                    c5728b2 = new C5728b(str2);
                                    if (!c5728b2.exists()) {
                                        c5728b2.createNewFile();
                                    }
                                    bufferedWriter = new BufferedWriter(new C5733h(c5728b2));
                                    hashMap.put(split[0], bufferedWriter);
                                }
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(split[1]);
                            stringBuffer.append('|');
                            stringBuffer.append(split[2]);
                            stringBuffer.append(10);
                            bufferedWriter.write(stringBuffer.toString());
                        }
                    }
                    for (BufferedWriter bufferedWriter2 : hashMap.values()) {
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.flush();
                        }
                    }
                    if (!C5046bo.isNullOrNil(str2)) {
                        for (C5728b c5728b22 : new C5728b(str2).dMC().mo11651a(new C90704())) {
                            RegionCodeDecoder.duj();
                            RegionCodeDecoder.m7795a(c5728b22, c5728b22.dMC());
                        }
                        RegionCodeDecoder.duj().drS();
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    c5728b.delete();
                    if (p != null) {
                        try {
                            p.close();
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.SubCorePacakge", e2, "", new Object[0]);
                        }
                    }
                    for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                        if (bufferedWriter22 != null) {
                            bufferedWriter22.close();
                        }
                    }
                    AppMethodBeat.m2505o(78517);
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    inputStream = p;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.SubCorePacakge", e, "", new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e22) {
                                C4990ab.printErrStackTrace("MicroMsg.SubCorePacakge", e22, "", new Object[0]);
                                AppMethodBeat.m2505o(78517);
                                return false;
                            }
                        }
                        for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                            if (bufferedWriter222 != null) {
                                bufferedWriter222.close();
                            }
                        }
                        AppMethodBeat.m2505o(78517);
                        return false;
                    } catch (Throwable e4) {
                        th = e4;
                        p = inputStream;
                        if (p != null) {
                            try {
                                p.close();
                            } catch (IOException e222) {
                                C4990ab.printErrStackTrace("MicroMsg.SubCorePacakge", e222, "", new Object[0]);
                                AppMethodBeat.m2505o(78517);
                                throw th;
                            }
                        }
                        for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                            if (bufferedWriter2222 != null) {
                                bufferedWriter2222.close();
                            }
                        }
                        AppMethodBeat.m2505o(78517);
                        throw th;
                    }
                } catch (Throwable e42) {
                    th = e42;
                    if (p != null) {
                    }
                    for (BufferedWriter bufferedWriter22222 : hashMap.values()) {
                    }
                    AppMethodBeat.m2505o(78517);
                    throw th;
                }
            } catch (Exception e5) {
                e42 = e5;
                inputStream = null;
            } catch (Throwable e422) {
                th = e422;
                p = null;
                if (p != null) {
                }
                for (BufferedWriter bufferedWriter222222 : hashMap.values()) {
                }
                AppMethodBeat.m2505o(78517);
                throw th;
            }
        }
        C4990ab.m7412e("MicroMsg.SubCorePacakge", "update regioncode failed, file not exist, packagePath:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(78517);
        return false;
    }
}
