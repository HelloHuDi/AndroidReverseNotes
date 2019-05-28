package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.jni.utils.UtilsJni;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C1184r;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C23236j.C23237a;
import com.tencent.p177mm.protocal.MMProtocalJni;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.l */
final class C23238l {
    private final boolean cuA;
    private final int cut;
    private final int cuu;
    private final int cuv;
    private final boolean cuw;
    final String filePath;
    volatile int state = -1;
    private final String url;
    final String vdC;
    private final String vdF;
    private final int vdG;
    private final byte[] vdH;
    private final String vdI;
    private final long vdK;
    private final String vdL;
    private final int vdM;
    private final int vdN;
    volatile String veM = null;
    volatile String veN = null;
    final boolean vei;
    final boolean vej;

    C23238l(int i, int i2, String str, boolean z, boolean z2, String str2, int i3, boolean z3, boolean z4, byte[] bArr, String str3, String str4, long j, String str5, int i4, int i5, int i6) {
        AppMethodBeat.m2504i(79550);
        this.vdC = C30039i.m47549gN(i, i2);
        this.cut = i;
        this.cuu = i2;
        this.filePath = str;
        this.vej = z;
        this.vei = z2;
        this.vdF = str2;
        this.vdG = i3;
        this.vdH = bArr;
        this.vdI = str3;
        this.cuA = z3;
        this.cuw = z4;
        this.vdL = str4;
        this.vdK = j;
        this.url = str5;
        this.vdM = i4;
        this.vdN = i5;
        this.cuv = i6;
        AppMethodBeat.m2505o(79550);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final C23238l dil() {
        Throwable e;
        AppMethodBeat.m2504i(79551);
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", this.vdC, dip(), this.veM, this.veN, Boolean.valueOf(C5046bo.isNullOrNil(this.vdF)));
        if (1 != this.state) {
            AppMethodBeat.m2505o(79551);
        } else if (C5046bo.isNullOrNil(this.vdF)) {
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", this.vdC);
            this.veM = null;
            this.state = 8;
            C23236j.m35639z(this.vdK, 54);
            C23236j.m35639z(this.vdK, 45);
            AppMethodBeat.m2505o(79551);
        } else {
            boolean z;
            try {
                String str = this.veM;
                String str2 = this.veN;
                String str3 = this.vdF;
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    file = new File(str2);
                    file.getParentFile().mkdirs();
                    file.delete();
                    byte[] aji = C40433a.aji(str);
                    if (C5046bo.m7540cb(aji)) {
                        C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
                        C23236j.m35639z(this.vdK, 56);
                        C23236j.m35639z(this.vdK, 45);
                        C23236j.m35639z(this.vdK, 18);
                        z = false;
                    } else {
                        aji = MMProtocalJni.aesDecrypt(aji, str3.getBytes());
                        if (C5046bo.m7540cb(aji)) {
                            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
                            C23236j.m35639z(this.vdK, 55);
                            C23236j.m35639z(this.vdK, 45);
                            C23236j.m35639z(this.vdK, 18);
                            z = false;
                        } else {
                            z = C40433a.m69344D(str2, aji);
                            if (!z) {
                                C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
                                C23236j.m35639z(this.vdK, 57);
                                C23236j.m35639z(this.vdK, 45);
                                C23236j.m35639z(this.vdK, 18);
                            }
                        }
                    }
                } else {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                    z = false;
                }
                try {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", this.vdC, Boolean.valueOf(z));
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.vdC, e);
                    C23236j.m35639z(this.vdK, 45);
                    C23236j.m35639z(this.vdK, 18);
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
                    if (z) {
                    }
                    return this;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                C4990ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.vdC, e);
                C23236j.m35639z(this.vdK, 45);
                C23236j.m35639z(this.vdK, 18);
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
                if (z) {
                }
                return this;
            }
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
            if (z) {
                this.veM = null;
                this.state = 8;
                AppMethodBeat.m2505o(79551);
            } else {
                C23236j.m35639z(this.vdK, 17);
                this.veM = this.veN;
                if (this.vei) {
                    this.veN = this.filePath + ".decompressed";
                    this.state = 2;
                    AppMethodBeat.m2505o(79551);
                } else {
                    this.state = 4;
                    AppMethodBeat.m2505o(79551);
                }
            }
        }
        return this;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final C23238l dim() {
        Throwable e;
        AppMethodBeat.m2504i(79552);
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", this.vdC, dip(), this.veM, this.veN);
        if (2 != this.state) {
            if (8 == this.state && this.vej) {
                C23236j.m35635a(this.cut, this.cuu, this.vdG, this.cuA, false, false, false, this.vdL);
            }
            AppMethodBeat.m2505o(79552);
        } else {
            boolean z;
            try {
                String str = this.veM;
                String str2 = this.veN;
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    new File(str2).delete();
                    byte[] B = C1184r.m2612B(C40433a.aji(str));
                    if (C5046bo.m7540cb(B)) {
                        C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
                        z = false;
                    } else {
                        z = C40433a.m69344D(str2, B);
                    }
                } else {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                    z = false;
                }
                try {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", this.vdC, Boolean.valueOf(z));
                } catch (Exception e2) {
                    e = e2;
                    C4990ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.vdC, e);
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
                    if (z) {
                    }
                    return this;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                C4990ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.vdC, e);
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
                if (z) {
                }
                return this;
            }
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
            if (z) {
                this.veM = this.veN;
                this.state = 4;
                C23236j.m35639z(this.vdK, 19);
                AppMethodBeat.m2505o(79552);
            } else {
                this.veM = null;
                this.state = 8;
                C23236j.m35639z(this.vdK, 20);
                C23236j.m35639z(this.vdK, 46);
                if (this.vej) {
                    C23236j.m35635a(this.cut, this.cuu, this.vdG, this.cuA, true, false, false, this.vdL);
                } else if (this.vei && this.cuw) {
                    C23236j.m35637a(this.cut, this.cuu, this.url, this.cuv, this.vdM > this.vdN ? C23237a.RETRY_SUCC : C23237a.SUCC, false, this.cuA, false, this.vdL);
                }
                AppMethodBeat.m2505o(79552);
            }
        }
        return this;
    }

    /* Access modifiers changed, original: final */
    public final String din() {
        AppMethodBeat.m2504i(79553);
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + dip(), this.vdC);
        if (16 == this.state) {
            String str = this.veM;
            AppMethodBeat.m2505o(79553);
            return str;
        } else if (4 == this.state || 32 == this.state) {
            String dio = dio();
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.vdC, dio);
            if (this.state == 4) {
                if (C5046bo.isNullOrNil(dio) && !this.vei) {
                    C23236j.m35639z(this.vdK, 58);
                    C23236j.m35639z(this.vdK, 45);
                }
                if (C5046bo.isNullOrNil(dio)) {
                    if (this.vej) {
                        C23236j.m35635a(this.cut, this.cuu, this.vdG, this.cuA, true, true, false, this.vdL);
                    } else if (this.vei && this.cuw) {
                        C23236j.m35637a(this.cut, this.cuu, this.url, this.cuv, this.vdM > this.vdN ? C23237a.RETRY_SUCC : C23237a.SUCC, false, this.cuA, true, this.vdL);
                    }
                } else if (this.vej) {
                    C23236j.m35635a(this.cut, this.cuu, this.vdG, this.cuA, true, true, true, this.vdL);
                } else if (this.vei && this.cuw) {
                    C23236j.m35637a(this.cut, this.cuu, this.url, this.cuv, this.vdM > this.vdN ? C23237a.RETRY_SUCC : C23237a.SUCC, true, this.cuA, true, this.vdL);
                }
            }
            AppMethodBeat.m2505o(79553);
            return dio;
        } else {
            AppMethodBeat.m2505o(79553);
            return null;
        }
    }

    private String dio() {
        AppMethodBeat.m2504i(79554);
        if (C5046bo.isNullOrNil(this.veM)) {
            AppMethodBeat.m2505o(79554);
            return null;
        }
        String str;
        String str2 = "MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer";
        String str3 = "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.vdC;
        objArr[1] = dip();
        objArr[2] = this.vdI;
        if (this.vdH == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = String.valueOf(this.vdH.length);
        }
        objArr[3] = str;
        C4990ab.m7417i(str2, str3, objArr);
        if (C5046bo.isNullOrNil(this.vdI) || !C5046bo.nullAsNil(C1178g.m2587cz(this.veM)).equals(this.vdI)) {
            if (this.state == 4) {
                C23236j.m35639z(this.vdK, 24);
            }
            if (C5046bo.m7540cb(this.vdH) || UtilsJni.doEcdsaSHAVerify(C30039i.vem, C40433a.aji(this.veM), this.vdH) <= 0) {
                if (this.state == 4) {
                    C23236j.m35639z(this.vdK, 26);
                }
                AppMethodBeat.m2505o(79554);
                return null;
            }
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", this.vdC, dip());
            if (this.state == 4) {
                C23236j.m35639z(this.vdK, 25);
            }
            str = this.veM;
            AppMethodBeat.m2505o(79554);
            return str;
        }
        C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", this.vdC, dip());
        if (this.state == 4) {
            C23236j.m35639z(this.vdK, 23);
        }
        str = this.veM;
        AppMethodBeat.m2505o(79554);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final String dip() {
        AppMethodBeat.m2504i(79555);
        String str;
        switch (this.state) {
            case 1:
                str = "state_decrypt";
                AppMethodBeat.m2505o(79555);
                return str;
            case 2:
                str = "state_decompress";
                AppMethodBeat.m2505o(79555);
                return str;
            case 4:
                str = "state_check_sum";
                AppMethodBeat.m2505o(79555);
                return str;
            case 8:
                str = "state_file_invalid";
                AppMethodBeat.m2505o(79555);
                return str;
            case 16:
                str = "state_file_valid";
                AppMethodBeat.m2505o(79555);
                return str;
            case 32:
                str = "state_pre_verify_check_sum";
                AppMethodBeat.m2505o(79555);
                return str;
            default:
                str = this.state;
                AppMethodBeat.m2505o(79555);
                return str;
        }
    }
}
