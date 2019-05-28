package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public final class f {
    private String charset = "UTF-8";
    public WepkgVersion uWY;
    private e uXi;
    private Map<String, WepkgPreloadFile> uXj;

    public f(WepkgVersion wepkgVersion, e eVar, Map<String, WepkgPreloadFile> map) {
        AppMethodBeat.i(63547);
        this.uWY = wepkgVersion;
        this.uXi = eVar;
        this.uXj = map;
        if (!(wepkgVersion == null || bo.isNullOrNil(wepkgVersion.charset))) {
            this.charset = wepkgVersion.charset;
        }
        AppMethodBeat.o(63547);
    }

    public final boolean ahT(String str) {
        AppMethodBeat.i(63548);
        if (ahS(d.aif(str)) != null) {
            AppMethodBeat.o(63548);
            return true;
        }
        AppMethodBeat.o(63548);
        return false;
    }

    public final o ahS(String str) {
        AppMethodBeat.i(63549);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(63549);
            return null;
        }
        if (!(this.uXj == null || this.uXj.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.uXj.get(str);
            if (!bo.isNullOrNil(wepkgPreloadFile.filePath)) {
                File file = new File(wepkgPreloadFile.filePath);
                if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                    try {
                        ab.i("MicroMsg.Wepkg.WepkgInterceptor", "rid hit preload file. rid:%s, localPath:%s", str, wepkgPreloadFile.filePath);
                        o oVar = new o(wepkgPreloadFile.mimeType, this.charset, new FileInputStream(file));
                        AppMethodBeat.o(63549);
                        return oVar;
                    } catch (FileNotFoundException e) {
                    }
                }
            }
        }
        if (this.uXi != null) {
            o hy = this.uXi.hy(str, this.charset);
            AppMethodBeat.o(63549);
            return hy;
        }
        AppMethodBeat.o(63549);
        return null;
    }

    public final String Kl(String str) {
        AppMethodBeat.i(63550);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(63550);
            return null;
        }
        if (!(this.uXj == null || this.uXj.get(str) == null)) {
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.uXj.get(str);
            if (!bo.isNullOrNil(wepkgPreloadFile.filePath)) {
                File file = new File(wepkgPreloadFile.filePath);
                if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                    String str2 = wepkgPreloadFile.filePath;
                    AppMethodBeat.o(63550);
                    return str2;
                }
            }
        }
        AppMethodBeat.o(63550);
        return null;
    }
}
