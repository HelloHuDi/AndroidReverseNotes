package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ao;
import com.tencent.mm.plugin.appbrand.appcache.ao.a;
import com.tencent.mm.plugin.appbrand.appcache.w;
import com.tencent.mm.plugin.appbrand.r.d;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public final class y extends g {
    public final ao gTI;

    public y(ao aoVar) {
        this.gTI = aoVar;
    }

    public final boolean ca(String str) {
        return true;
    }

    public final j yd(String str) {
        AppMethodBeat.i(86868);
        InputStream xy = this.gTI.xy(str);
        j jVar;
        if (xy == null) {
            jVar = j.RET_NOT_EXISTS;
            AppMethodBeat.o(86868);
            return jVar;
        }
        bo.b(xy);
        jVar = j.OK;
        AppMethodBeat.o(86868);
        return jVar;
    }

    public final j a(String str, j<List<h>> jVar) {
        AppMethodBeat.i(86869);
        j jVar2;
        if (yd(str) == j.OK) {
            jVar2 = j.ERR_IS_FILE;
            AppMethodBeat.o(86869);
            return jVar2;
        }
        String yk = l.yk(str);
        ao aoVar = this.gTI;
        LinkedList<a> linkedList = new LinkedList();
        for (a add : aoVar.gUi.values()) {
            linkedList.add(add);
        }
        String quote = Pattern.quote(yk);
        for (a add2 : linkedList) {
            if (add2.fileName.startsWith(yk)) {
                String replaceFirst = add2.fileName.replaceFirst(quote, "");
                if (replaceFirst.split("/").length <= 1) {
                    Object linkedList2;
                    h hVar = new h();
                    hVar.fileName = replaceFirst;
                    if (jVar.value == null) {
                        linkedList2 = new LinkedList();
                    } else {
                        List linkedList22 = (List) jVar.value;
                    }
                    jVar.value = linkedList22;
                    ((List) jVar.value).add(hVar);
                }
            }
        }
        if (jVar.value == null) {
            jVar2 = j.RET_NOT_EXISTS;
            AppMethodBeat.o(86869);
            return jVar2;
        }
        jVar2 = j.OK;
        AppMethodBeat.o(86869);
        return jVar2;
    }

    public final j ye(String str) {
        AppMethodBeat.i(86870);
        j a = a(str, new j());
        AppMethodBeat.o(86870);
        return a;
    }

    public final j b(String str, j<ByteBuffer> jVar) {
        AppMethodBeat.i(86871);
        InputStream xy = this.gTI.xy(str);
        j jVar2;
        if (xy == null) {
            jVar2 = j.RET_NOT_EXISTS;
            AppMethodBeat.o(86871);
            return jVar2;
        }
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(xy.available());
            if (xy instanceof com.tencent.luggage.g.a) {
                allocateDirect.put(((com.tencent.luggage.g.a) xy).bRy);
            } else {
                allocateDirect.put(ByteBuffer.wrap(d.k(xy)));
            }
            allocateDirect.rewind();
            jVar.value = allocateDirect;
            jVar2 = j.OK;
            bo.b(xy);
            AppMethodBeat.o(86871);
            return jVar2;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WxaPkgFileSystem", e, "readFile", new Object[0]);
            bo.b(xy);
            jVar2 = j.ERR_OP_FAIL;
            AppMethodBeat.o(86871);
            return jVar2;
        } catch (Throwable th) {
            bo.b(xy);
            AppMethodBeat.o(86871);
        }
    }

    public final j a(String str, k kVar) {
        AppMethodBeat.i(86872);
        InputStream xy = this.gTI.xy(str);
        j jVar;
        if (xy == null) {
            jVar = j.RET_NOT_EXISTS;
            AppMethodBeat.o(86872);
            return jVar;
        }
        ao aoVar = this.gTI;
        k kVar2 = aoVar.gUj;
        if (kVar2 == null) {
            kVar2 = new k();
            FileStat.stat(aoVar.gUc.getAbsolutePath(), kVar2);
            aoVar.gUj = kVar2;
        }
        if (kVar != null) {
            kVar.st_mode = kVar2.st_mode;
            kVar.st_size = kVar2.st_size;
            kVar.st_atime = kVar2.st_atime;
            kVar.st_mtime = kVar2.st_mtime;
            kVar.st_ctime = kVar2.st_ctime;
        }
        try {
            kVar.st_size = (long) xy.available();
            bo.b(xy);
        } catch (Exception e) {
            ab.e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", str);
        }
        jVar = j.OK;
        AppMethodBeat.o(86872);
        return jVar;
    }

    public final File Z(String str, boolean z) {
        AppMethodBeat.i(86873);
        if (!z) {
            if ((ye(str) == j.OK ? 1 : null) != null) {
                AppMethodBeat.o(86873);
                return null;
            }
        }
        String a = w.a(this.gTI, str);
        if (TextUtils.isEmpty(a)) {
            AppMethodBeat.o(86873);
            return null;
        }
        File file = new File(a);
        AppMethodBeat.o(86873);
        return file;
    }

    public final void initialize() {
        AppMethodBeat.i(86874);
        this.gTI.avW();
        AppMethodBeat.o(86874);
    }

    public final void release() {
        AppMethodBeat.i(86875);
        this.gTI.close();
        AppMethodBeat.o(86875);
    }
}
