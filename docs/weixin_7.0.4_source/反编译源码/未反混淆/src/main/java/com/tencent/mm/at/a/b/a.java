package com.tencent.mm.at.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.c.f;
import com.tencent.mm.at.a.g.b;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.d;
import com.tencent.mm.vfs.e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class a implements com.tencent.mm.at.a.c.a {
    private f fHl;

    public final void ahH() {
        AppMethodBeat.i(116080);
        b.ahJ();
        AppMethodBeat.o(116080);
    }

    public final void a(f fVar) {
        this.fHl = fVar;
    }

    private String a(String str, c cVar) {
        AppMethodBeat.i(116076);
        String str2 = cVar.ePJ;
        if (str2 == null || str2.length() == 0) {
            str2 = cVar.ePK;
            if (!(str2 == null || str2.length() == 0)) {
                str2 = str2 + "/" + this.fHl.sF(str);
            }
        }
        if (cVar.ePG && bo.isNullOrNil(r0)) {
            str2 = b.Ur() + "/" + this.fHl.sF(str);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(116076);
            return null;
        }
        AppMethodBeat.o(116076);
        return str2;
    }

    private String b(String str, c cVar) {
        AppMethodBeat.i(116077);
        String str2 = cVar.ePL;
        if (str2 == null || str2.length() == 0) {
            String str3 = cVar.ePJ;
            if (str3 != null && str3.length() > 0) {
                str2 = cVar.ePK;
                if (str2 == null || str2.length() == 0 || !str3.startsWith(str2)) {
                    ab.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", str3);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(str3)));
                    AppMethodBeat.o(116077);
                    throw illegalArgumentException;
                }
                str2 = str3.substring(str2.length());
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
            }
        }
        if (str2 == null || str2.length() == 0) {
            str2 = this.fHl.sF(str);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(116077);
            return null;
        }
        AppMethodBeat.o(116077);
        return str2;
    }

    public final boolean a(String str, byte[] bArr, c cVar) {
        AppMethodBeat.i(116078);
        SFSContext sFSContext = cVar.ePY;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                AppMethodBeat.o(116078);
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = sFSContext.pH(b);
                outputStream.write(bArr);
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (IOException e2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.o(116078);
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(116078);
            }
        } else {
            String a = a(str, cVar);
            if (a == null) {
                AppMethodBeat.o(116078);
                return false;
            }
            com.tencent.mm.vfs.b dMC = new com.tencent.mm.vfs.b(a).dMC();
            if (!(dMC == null || dMC.exists())) {
                dMC.mkdirs();
            }
            dMC = new com.tencent.mm.vfs.b(a);
            if (!dMC.exists()) {
                try {
                    dMC.createNewFile();
                } catch (Exception e5) {
                    ab.i("MicroMsg.imageloader.DefaultImageDiskCache", bo.l(e5));
                }
            }
            if (bArr != null && e.b(a, bArr, bArr.length) < 0) {
                AppMethodBeat.o(116078);
                return false;
            }
        }
        AppMethodBeat.o(116078);
        return true;
    }

    public final boolean c(String str, c cVar) {
        AppMethodBeat.i(116079);
        SFSContext sFSContext = cVar.ePY;
        boolean pI;
        if (sFSContext != null) {
            String b = b(str, cVar);
            if (b == null) {
                AppMethodBeat.o(116079);
                return false;
            }
            pI = sFSContext.pI(b);
            AppMethodBeat.o(116079);
            return pI;
        }
        String a = a(str, cVar);
        if (a == null) {
            AppMethodBeat.o(116079);
            return false;
        }
        pI = new com.tencent.mm.vfs.b(a).delete();
        AppMethodBeat.o(116079);
        return pI;
    }

    public final InputStream d(String str, c cVar) {
        InputStream inputStream = null;
        AppMethodBeat.i(116081);
        try {
            SFSContext sFSContext = cVar.ePY;
            String b;
            if (sFSContext != null) {
                b = b(str, cVar);
                if (b == null) {
                    AppMethodBeat.o(116081);
                    return inputStream;
                }
                inputStream = sFSContext.openRead(b);
                AppMethodBeat.o(116081);
                return inputStream;
            }
            b = a(str, cVar);
            if (b == null) {
                AppMethodBeat.o(116081);
                return inputStream;
            }
            InputStream dVar = new d(b);
            AppMethodBeat.o(116081);
            return dVar;
        } catch (FileNotFoundException e) {
            AppMethodBeat.o(116081);
            return inputStream;
        }
    }
}
