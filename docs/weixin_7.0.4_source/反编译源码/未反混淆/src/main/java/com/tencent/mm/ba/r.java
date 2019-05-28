package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.h;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class r implements at {
    private static HashMap<Integer, d> eaA;
    c fMA = new c<bf>() {
        {
            AppMethodBeat.i(78508);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(78508);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(78509);
            bf bfVar = (bf) bVar;
            if (bfVar.cus.cut == 47 && bfVar.cus.cuu == 1) {
                ab.i("MicroMsg.SubCorePacakge", "going to update region code.");
                r.a(r.this, bfVar.cus.filePath);
            }
            AppMethodBeat.o(78509);
            return false;
        }
    };
    private n fMu;
    private b fMv;
    private o fMw = new o();
    private p fMx = new p();
    private q fMy = new q();
    private l fMz = null;

    static /* synthetic */ boolean a(r rVar, String str) {
        AppMethodBeat.i(78518);
        boolean sV = rVar.sV(str);
        AppMethodBeat.o(78518);
        return sV;
    }

    public r() {
        AppMethodBeat.i(78511);
        AppMethodBeat.o(78511);
    }

    private static r aiw() {
        AppMethodBeat.i(78512);
        r rVar = (r) q.Y(r.class);
        AppMethodBeat.o(78512);
        return rVar;
    }

    public static n aix() {
        AppMethodBeat.i(78513);
        g.RN().QU();
        if (aiw().fMu == null) {
            aiw().fMu = new n(g.RP().eJN);
        }
        n nVar = aiw().fMu;
        AppMethodBeat.o(78513);
        return nVar;
    }

    public static b aiy() {
        AppMethodBeat.i(78514);
        g.RN().QU();
        if (aiw().fMv == null) {
            aiw().fMv = new b(g.RP().eJN);
        }
        b bVar = aiw().fMv;
        AppMethodBeat.o(78514);
        return bVar;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(78515);
        a.xxA.d(this.fMw);
        a.xxA.d(this.fMx);
        a.xxA.d(this.fMy);
        a.xxA.d(this.fMz.fMq);
        a.xxA.d(this.fMz.fMr);
        a.xxA.d(this.fMA);
        AppMethodBeat.o(78515);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(78516);
        a.xxA.c(this.fMw);
        a.xxA.c(this.fMx);
        a.xxA.c(this.fMy);
        a.xxA.c(this.fMA);
        if (this.fMz != null) {
            this.fMz.fMp.clear();
        } else {
            this.fMz = new l();
        }
        a.xxA.c(this.fMz.fMq);
        a.xxA.c(this.fMz.fMr);
        AppMethodBeat.o(78516);
    }

    static {
        AppMethodBeat.i(78519);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("PACKAGE_INFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return n.fnj;
            }
        });
        eaA.put(Integer.valueOf("CHATTINGBGINFO_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return b.fnj;
            }
        });
        AppMethodBeat.o(78519);
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0119 A:{SYNTHETIC, Splitter:B:50:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a A:{Catch:{ IOException -> 0x0136 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0119 A:{SYNTHETIC, Splitter:B:50:0x0119} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012a A:{Catch:{ IOException -> 0x0136 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean sV(String str) {
        Throwable e;
        InputStream inputStream;
        Throwable th;
        String str2 = null;
        AppMethodBeat.i(78517);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (bVar.exists()) {
            HashMap hashMap = new HashMap();
            InputStream p;
            try {
                p = e.p(bVar);
                BufferedWriter bufferedWriter;
                try {
                    com.tencent.mm.vfs.b bVar2;
                    InputStreamReader inputStreamReader = new InputStreamReader(p, ProtocolPackage.ServerEncoding);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.trim().split("\\|");
                        if (split.length < 2 || bo.isNullOrNil(split[0]) || bo.isNullOrNil(split[1])) {
                            ab.e("MicroMsg.SubCorePacakge", "dispatch regioncode, error line = ".concat(String.valueOf(readLine)));
                        } else {
                            bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                            if (bufferedWriter == null) {
                                RegionCodeDecoder.duj();
                                str2 = RegionCodeDecoder.apP(split[0]);
                                if (!bo.isNullOrNil(str2)) {
                                    bVar2 = new com.tencent.mm.vfs.b(str2);
                                    if (!bVar2.exists()) {
                                        bVar2.createNewFile();
                                    }
                                    bufferedWriter = new BufferedWriter(new h(bVar2));
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
                    if (!bo.isNullOrNil(str2)) {
                        for (com.tencent.mm.vfs.b bVar22 : new com.tencent.mm.vfs.b(str2).dMC().a(new com.tencent.mm.vfs.c() {
                            public final boolean f(com.tencent.mm.vfs.b bVar) {
                                AppMethodBeat.i(78510);
                                boolean endsWith = bVar.getName().endsWith("txt");
                                AppMethodBeat.o(78510);
                                return endsWith;
                            }
                        })) {
                            RegionCodeDecoder.duj();
                            RegionCodeDecoder.a(bVar22, bVar22.dMC());
                        }
                        RegionCodeDecoder.duj().drS();
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    bVar.delete();
                    if (p != null) {
                        try {
                            p.close();
                        } catch (IOException e2) {
                            ab.printErrStackTrace("MicroMsg.SubCorePacakge", e2, "", new Object[0]);
                        }
                    }
                    for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                        if (bufferedWriter22 != null) {
                            bufferedWriter22.close();
                        }
                    }
                    AppMethodBeat.o(78517);
                    return true;
                } catch (Exception e3) {
                    e = e3;
                    inputStream = p;
                    try {
                        ab.printErrStackTrace("MicroMsg.SubCorePacakge", e, "", new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e22) {
                                ab.printErrStackTrace("MicroMsg.SubCorePacakge", e22, "", new Object[0]);
                                AppMethodBeat.o(78517);
                                return false;
                            }
                        }
                        for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                            if (bufferedWriter222 != null) {
                                bufferedWriter222.close();
                            }
                        }
                        AppMethodBeat.o(78517);
                        return false;
                    } catch (Throwable e4) {
                        th = e4;
                        p = inputStream;
                        if (p != null) {
                            try {
                                p.close();
                            } catch (IOException e222) {
                                ab.printErrStackTrace("MicroMsg.SubCorePacakge", e222, "", new Object[0]);
                                AppMethodBeat.o(78517);
                                throw th;
                            }
                        }
                        for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                            if (bufferedWriter2222 != null) {
                                bufferedWriter2222.close();
                            }
                        }
                        AppMethodBeat.o(78517);
                        throw th;
                    }
                } catch (Throwable e42) {
                    th = e42;
                    if (p != null) {
                    }
                    for (BufferedWriter bufferedWriter22222 : hashMap.values()) {
                    }
                    AppMethodBeat.o(78517);
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
                AppMethodBeat.o(78517);
                throw th;
            }
        }
        ab.e("MicroMsg.SubCorePacakge", "update regioncode failed, file not exist, packagePath:".concat(String.valueOf(str)));
        AppMethodBeat.o(78517);
        return false;
    }
}
