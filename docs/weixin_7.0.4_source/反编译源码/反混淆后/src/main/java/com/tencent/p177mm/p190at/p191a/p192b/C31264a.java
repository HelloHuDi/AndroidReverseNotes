package com.tencent.p177mm.p190at.p191a.p192b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsfs.SFSContext;
import com.tencent.p177mm.p190at.p191a.p193c.C25816a;
import com.tencent.p177mm.p190at.p191a.p193c.C9013f;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p829g.C9016b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C40922d;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.tencent.mm.at.a.b.a */
public final class C31264a implements C25816a {
    private C9013f fHl;

    public final void ahH() {
        AppMethodBeat.m2504i(116080);
        C9016b.ahJ();
        AppMethodBeat.m2505o(116080);
    }

    /* renamed from: a */
    public final void mo43777a(C9013f c9013f) {
        this.fHl = c9013f;
    }

    /* renamed from: a */
    private String m50454a(String str, C25814c c25814c) {
        AppMethodBeat.m2504i(116076);
        String str2 = c25814c.ePJ;
        if (str2 == null || str2.length() == 0) {
            str2 = c25814c.ePK;
            if (!(str2 == null || str2.length() == 0)) {
                str2 = str2 + "/" + this.fHl.mo20445sF(str);
            }
        }
        if (c25814c.ePG && C5046bo.isNullOrNil(r0)) {
            str2 = C9016b.m16284Ur() + "/" + this.fHl.mo20445sF(str);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.m2505o(116076);
            return null;
        }
        AppMethodBeat.m2505o(116076);
        return str2;
    }

    /* renamed from: b */
    private String m50455b(String str, C25814c c25814c) {
        AppMethodBeat.m2504i(116077);
        String str2 = c25814c.ePL;
        if (str2 == null || str2.length() == 0) {
            String str3 = c25814c.ePJ;
            if (str3 != null && str3.length() > 0) {
                str2 = c25814c.ePK;
                if (str2 == null || str2.length() == 0 || !str3.startsWith(str2)) {
                    C4990ab.m7413e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", str3);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(str3)));
                    AppMethodBeat.m2505o(116077);
                    throw illegalArgumentException;
                }
                str2 = str3.substring(str2.length());
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
            }
        }
        if (str2 == null || str2.length() == 0) {
            str2 = this.fHl.mo20445sF(str);
        }
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.m2505o(116077);
            return null;
        }
        AppMethodBeat.m2505o(116077);
        return str2;
    }

    /* renamed from: a */
    public final boolean mo43778a(String str, byte[] bArr, C25814c c25814c) {
        AppMethodBeat.m2504i(116078);
        SFSContext sFSContext = c25814c.ePY;
        if (sFSContext != null) {
            String b = m50455b(str, c25814c);
            if (b == null) {
                AppMethodBeat.m2505o(116078);
                return false;
            }
            OutputStream outputStream = null;
            try {
                outputStream = sFSContext.mo44222pH(b);
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
                AppMethodBeat.m2505o(116078);
                return false;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(116078);
            }
        } else {
            String a = m50454a(str, c25814c);
            if (a == null) {
                AppMethodBeat.m2505o(116078);
                return false;
            }
            C5728b dMC = new C5728b(a).dMC();
            if (!(dMC == null || dMC.exists())) {
                dMC.mkdirs();
            }
            dMC = new C5728b(a);
            if (!dMC.exists()) {
                try {
                    dMC.createNewFile();
                } catch (Exception e5) {
                    C4990ab.m7416i("MicroMsg.imageloader.DefaultImageDiskCache", C5046bo.m7574l(e5));
                }
            }
            if (bArr != null && C5730e.m8624b(a, bArr, bArr.length) < 0) {
                AppMethodBeat.m2505o(116078);
                return false;
            }
        }
        AppMethodBeat.m2505o(116078);
        return true;
    }

    /* renamed from: c */
    public final boolean mo43780c(String str, C25814c c25814c) {
        AppMethodBeat.m2504i(116079);
        SFSContext sFSContext = c25814c.ePY;
        boolean pI;
        if (sFSContext != null) {
            String b = m50455b(str, c25814c);
            if (b == null) {
                AppMethodBeat.m2505o(116079);
                return false;
            }
            pI = sFSContext.mo44223pI(b);
            AppMethodBeat.m2505o(116079);
            return pI;
        }
        String a = m50454a(str, c25814c);
        if (a == null) {
            AppMethodBeat.m2505o(116079);
            return false;
        }
        pI = new C5728b(a).delete();
        AppMethodBeat.m2505o(116079);
        return pI;
    }

    /* renamed from: d */
    public final InputStream mo43781d(String str, C25814c c25814c) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(116081);
        try {
            SFSContext sFSContext = c25814c.ePY;
            String b;
            if (sFSContext != null) {
                b = m50455b(str, c25814c);
                if (b == null) {
                    AppMethodBeat.m2505o(116081);
                    return inputStream;
                }
                inputStream = sFSContext.openRead(b);
                AppMethodBeat.m2505o(116081);
                return inputStream;
            }
            b = m50454a(str, c25814c);
            if (b == null) {
                AppMethodBeat.m2505o(116081);
                return inputStream;
            }
            InputStream c40922d = new C40922d(b);
            AppMethodBeat.m2505o(116081);
            return c40922d;
        } catch (FileNotFoundException e) {
            AppMethodBeat.m2505o(116081);
            return inputStream;
        }
    }
}
