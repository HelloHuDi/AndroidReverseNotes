package com.tencent.p177mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C31147o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wepkg.model.f */
public final class C40398f {
    private String charset = "UTF-8";
    public WepkgVersion uWY;
    private C46475e uXi;
    private Map<String, WepkgPreloadFile> uXj;

    public C40398f(WepkgVersion wepkgVersion, C46475e c46475e, Map<String, WepkgPreloadFile> map) {
        AppMethodBeat.m2504i(63547);
        this.uWY = wepkgVersion;
        this.uXi = c46475e;
        this.uXj = map;
        if (!(wepkgVersion == null || C5046bo.isNullOrNil(wepkgVersion.charset))) {
            this.charset = wepkgVersion.charset;
        }
        AppMethodBeat.m2505o(63547);
    }

    public final boolean ahT(String str) {
        AppMethodBeat.m2504i(63548);
        if (ahS(C30022d.aif(str)) != null) {
            AppMethodBeat.m2505o(63548);
            return true;
        }
        AppMethodBeat.m2505o(63548);
        return false;
    }

    public final C31147o ahS(String str) {
        AppMethodBeat.m2504i(63549);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63549);
            return null;
        }
        if (!(this.uXj == null || this.uXj.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.uXj.get(str);
            if (!C5046bo.isNullOrNil(wepkgPreloadFile.filePath)) {
                File file = new File(wepkgPreloadFile.filePath);
                if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                    try {
                        C4990ab.m7417i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s, localPath:%s", str, wepkgPreloadFile.filePath);
                        C31147o c31147o = new C31147o(wepkgPreloadFile.mimeType, this.charset, new FileInputStream(file));
                        AppMethodBeat.m2505o(63549);
                        return c31147o;
                    } catch (FileNotFoundException e) {
                    }
                }
            }
        }
        if (this.uXi != null) {
            C31147o hy = this.uXi.mo74704hy(str, this.charset);
            AppMethodBeat.m2505o(63549);
            return hy;
        }
        AppMethodBeat.m2505o(63549);
        return null;
    }

    /* renamed from: Kl */
    public final String mo63814Kl(String str) {
        AppMethodBeat.m2504i(63550);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(63550);
            return null;
        }
        if (!(this.uXj == null || this.uXj.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.uXj.get(str);
            if (!C5046bo.isNullOrNil(wepkgPreloadFile.filePath)) {
                File file = new File(wepkgPreloadFile.filePath);
                if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                    String str2 = wepkgPreloadFile.filePath;
                    AppMethodBeat.m2505o(63550);
                    return str2;
                }
            }
        }
        AppMethodBeat.m2505o(63550);
        return null;
    }
}
