package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.a.r;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

final class l {
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

    l(int i, int i2, String str, boolean z, boolean z2, String str2, int i3, boolean z3, boolean z4, byte[] bArr, String str3, String str4, long j, String str5, int i4, int i5, int i6) {
        AppMethodBeat.i(79550);
        this.vdC = i.gN(i, i2);
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
        AppMethodBeat.o(79550);
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0189  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final l dil() {
        Throwable e;
        AppMethodBeat.i(79551);
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", this.vdC, dip(), this.veM, this.veN, Boolean.valueOf(bo.isNullOrNil(this.vdF)));
        if (1 != this.state) {
            AppMethodBeat.o(79551);
        } else if (bo.isNullOrNil(this.vdF)) {
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", this.vdC);
            this.veM = null;
            this.state = 8;
            j.z(this.vdK, 54);
            j.z(this.vdK, 45);
            AppMethodBeat.o(79551);
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
                    byte[] aji = a.aji(str);
                    if (bo.cb(aji)) {
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
                        j.z(this.vdK, 56);
                        j.z(this.vdK, 45);
                        j.z(this.vdK, 18);
                        z = false;
                    } else {
                        aji = MMProtocalJni.aesDecrypt(aji, str3.getBytes());
                        if (bo.cb(aji)) {
                            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
                            j.z(this.vdK, 55);
                            j.z(this.vdK, 45);
                            j.z(this.vdK, 18);
                            z = false;
                        } else {
                            z = a.D(str2, aji);
                            if (!z) {
                                ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
                                j.z(this.vdK, 57);
                                j.z(this.vdK, 45);
                                j.z(this.vdK, 18);
                            }
                        }
                    }
                } else {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                    z = false;
                }
                try {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", this.vdC, Boolean.valueOf(z));
                } catch (Exception e2) {
                    e = e2;
                    ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.vdC, e);
                    j.z(this.vdK, 45);
                    j.z(this.vdK, 18);
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
                    if (z) {
                    }
                    return this;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", this.vdC, e);
                j.z(this.vdK, 45);
                j.z(this.vdK, 18);
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
                if (z) {
                }
                return this;
            }
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
            if (z) {
                this.veM = null;
                this.state = 8;
                AppMethodBeat.o(79551);
            } else {
                j.z(this.vdK, 17);
                this.veM = this.veN;
                if (this.vei) {
                    this.veN = this.filePath + ".decompressed";
                    this.state = 2;
                    AppMethodBeat.o(79551);
                } else {
                    this.state = 4;
                    AppMethodBeat.o(79551);
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
    public final l dim() {
        Throwable e;
        AppMethodBeat.i(79552);
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", this.vdC, dip(), this.veM, this.veN);
        if (2 != this.state) {
            if (8 == this.state && this.vej) {
                j.a(this.cut, this.cuu, this.vdG, this.cuA, false, false, false, this.vdL);
            }
            AppMethodBeat.o(79552);
        } else {
            boolean z;
            try {
                String str = this.veM;
                String str2 = this.veN;
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    new File(str2).delete();
                    byte[] B = r.B(a.aji(str));
                    if (bo.cb(B)) {
                        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
                        z = false;
                    } else {
                        z = a.D(str2, B);
                    }
                } else {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", str);
                    z = false;
                }
                try {
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", this.vdC, Boolean.valueOf(z));
                } catch (Exception e2) {
                    e = e2;
                    ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.vdC, e);
                    ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
                    if (z) {
                    }
                    return this;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                ab.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", this.vdC, e);
                ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
                if (z) {
                }
                return this;
            }
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", this.vdC, Boolean.valueOf(z));
            if (z) {
                this.veM = this.veN;
                this.state = 4;
                j.z(this.vdK, 19);
                AppMethodBeat.o(79552);
            } else {
                this.veM = null;
                this.state = 8;
                j.z(this.vdK, 20);
                j.z(this.vdK, 46);
                if (this.vej) {
                    j.a(this.cut, this.cuu, this.vdG, this.cuA, true, false, false, this.vdL);
                } else if (this.vei && this.cuw) {
                    j.a(this.cut, this.cuu, this.url, this.cuv, this.vdM > this.vdN ? j.a.RETRY_SUCC : j.a.SUCC, false, this.cuA, false, this.vdL);
                }
                AppMethodBeat.o(79552);
            }
        }
        return this;
    }

    /* Access modifiers changed, original: final */
    public final String din() {
        AppMethodBeat.i(79553);
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + dip(), this.vdC);
        if (16 == this.state) {
            String str = this.veM;
            AppMethodBeat.o(79553);
            return str;
        } else if (4 == this.state || 32 == this.state) {
            String dio = dio();
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", this.vdC, dio);
            if (this.state == 4) {
                if (bo.isNullOrNil(dio) && !this.vei) {
                    j.z(this.vdK, 58);
                    j.z(this.vdK, 45);
                }
                if (bo.isNullOrNil(dio)) {
                    if (this.vej) {
                        j.a(this.cut, this.cuu, this.vdG, this.cuA, true, true, false, this.vdL);
                    } else if (this.vei && this.cuw) {
                        j.a(this.cut, this.cuu, this.url, this.cuv, this.vdM > this.vdN ? j.a.RETRY_SUCC : j.a.SUCC, false, this.cuA, true, this.vdL);
                    }
                } else if (this.vej) {
                    j.a(this.cut, this.cuu, this.vdG, this.cuA, true, true, true, this.vdL);
                } else if (this.vei && this.cuw) {
                    j.a(this.cut, this.cuu, this.url, this.cuv, this.vdM > this.vdN ? j.a.RETRY_SUCC : j.a.SUCC, true, this.cuA, true, this.vdL);
                }
            }
            AppMethodBeat.o(79553);
            return dio;
        } else {
            AppMethodBeat.o(79553);
            return null;
        }
    }

    private String dio() {
        AppMethodBeat.i(79554);
        if (bo.isNullOrNil(this.veM)) {
            AppMethodBeat.o(79554);
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
        ab.i(str2, str3, objArr);
        if (bo.isNullOrNil(this.vdI) || !bo.nullAsNil(g.cz(this.veM)).equals(this.vdI)) {
            if (this.state == 4) {
                j.z(this.vdK, 24);
            }
            if (bo.cb(this.vdH) || UtilsJni.doEcdsaSHAVerify(i.vem, a.aji(this.veM), this.vdH) <= 0) {
                if (this.state == 4) {
                    j.z(this.vdK, 26);
                }
                AppMethodBeat.o(79554);
                return null;
            }
            ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", this.vdC, dip());
            if (this.state == 4) {
                j.z(this.vdK, 25);
            }
            str = this.veM;
            AppMethodBeat.o(79554);
            return str;
        }
        ab.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", this.vdC, dip());
        if (this.state == 4) {
            j.z(this.vdK, 23);
        }
        str = this.veM;
        AppMethodBeat.o(79554);
        return str;
    }

    /* Access modifiers changed, original: final */
    public final String dip() {
        AppMethodBeat.i(79555);
        String str;
        switch (this.state) {
            case 1:
                str = "state_decrypt";
                AppMethodBeat.o(79555);
                return str;
            case 2:
                str = "state_decompress";
                AppMethodBeat.o(79555);
                return str;
            case 4:
                str = "state_check_sum";
                AppMethodBeat.o(79555);
                return str;
            case 8:
                str = "state_file_invalid";
                AppMethodBeat.o(79555);
                return str;
            case 16:
                str = "state_file_valid";
                AppMethodBeat.o(79555);
                return str;
            case 32:
                str = "state_pre_verify_check_sum";
                AppMethodBeat.o(79555);
                return str;
            default:
                str = this.state;
                AppMethodBeat.o(79555);
                return str;
        }
    }
}
