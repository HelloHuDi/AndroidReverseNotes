package com.tencent.mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.g.c;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

public class m extends g {
    public final String gXQ;
    private final String gXR;
    private final String gXS;
    public final LuggageLocalFileObjectManager gXT;
    public volatile long gXU = -1;

    public m(String str, String str2, String str3) {
        AppMethodBeat.i(105374);
        this.gXQ = new File(str).getAbsolutePath();
        this.gXR = str2;
        this.gXS = str3;
        this.gXT = new LuggageLocalFileObjectManager(this.gXQ, this.gXR, this.gXS);
        AppMethodBeat.o(105374);
    }

    public final boolean ca(String str) {
        AppMethodBeat.i(105375);
        boolean startsWith = bo.nullAsNil(str).startsWith(this.gXS);
        AppMethodBeat.o(105375);
        return startsWith;
    }

    public final j yd(String str) {
        AppMethodBeat.i(105376);
        v yo = this.gXT.yo(str);
        j jVar;
        if (yo == null || !e.ct(yo.fnQ)) {
            jVar = j.RET_NOT_EXISTS;
            AppMethodBeat.o(105376);
            return jVar;
        }
        jVar = j.OK;
        AppMethodBeat.o(105376);
        return jVar;
    }

    public final j b(String str, j<ByteBuffer> jVar) {
        AppMethodBeat.i(105377);
        v yo = this.gXT.yo(str);
        j jVar2;
        if (yo == null || !e.ct(yo.fnQ)) {
            jVar2 = j.RET_NOT_EXISTS;
            AppMethodBeat.o(105377);
            return jVar2;
        }
        jVar.value = l.D(new File(yo.fnQ));
        jVar2 = j.OK;
        AppMethodBeat.o(105377);
        return jVar2;
    }

    public final j a(String str, k kVar) {
        AppMethodBeat.i(105378);
        v yo = this.gXT.yo(str);
        j jVar;
        if (yo == null || !e.ct(yo.fnQ)) {
            jVar = j.RET_NOT_EXISTS;
            AppMethodBeat.o(105378);
            return jVar;
        } else if (kVar == null) {
            jVar = j.ERR_OP_FAIL;
            AppMethodBeat.o(105378);
            return jVar;
        } else if (FileStat.stat(yo.fnQ, kVar) == 0) {
            jVar = j.OK;
            AppMethodBeat.o(105378);
            return jVar;
        } else {
            jVar = j.ERR_OP_FAIL;
            AppMethodBeat.o(105378);
            return jVar;
        }
    }

    public final j a(String str, j<List<h>> jVar) {
        AppMethodBeat.i(105379);
        LinkedList<v> linkedList = new LinkedList();
        c.c(linkedList, this.gXT.awR());
        c.c(linkedList, this.gXT.awT());
        LinkedList linkedList2 = new LinkedList();
        for (v vVar : linkedList) {
            h hVar = new h();
            hVar.fileName = vVar.czD;
            linkedList2.add(hVar);
        }
        jVar.value = linkedList2;
        j jVar2 = j.OK;
        AppMethodBeat.o(105379);
        return jVar2;
    }

    public final File Z(String str, boolean z) {
        AppMethodBeat.i(105380);
        File yg = yg(str);
        AppMethodBeat.o(105380);
        return yg;
    }

    public final File yg(String str) {
        AppMethodBeat.i(105381);
        v yo = this.gXT.yo(str);
        if (yo == null) {
            AppMethodBeat.o(105381);
            return null;
        }
        File file = new File(yo.fnQ);
        AppMethodBeat.o(105381);
        return file;
    }

    public final String yl(String str) {
        AppMethodBeat.i(105382);
        v yo = this.gXT.yo(str);
        if (yo == null) {
            AppMethodBeat.o(105382);
            return null;
        }
        String str2 = yo.fnQ;
        AppMethodBeat.o(105382);
        return str2;
    }

    public final void initialize() {
        AppMethodBeat.i(105383);
        if (!com.tencent.mm.vfs.e.tf(this.gXQ)) {
            d.e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
        }
        AppMethodBeat.o(105383);
    }

    public final b yh(String str) {
        AppMethodBeat.i(105384);
        com.tencent.mm.vfs.e.tf(this.gXQ);
        b bVar = new b(this.gXQ + "/" + str);
        AppMethodBeat.o(105384);
        return bVar;
    }

    public final j a(j<String> jVar) {
        jVar.value = this.gXQ;
        return j.OK;
    }

    public final j a(File file, String str, boolean z, j<String> jVar) {
        AppMethodBeat.i(105385);
        v k = this.gXT.k(file.getAbsolutePath(), str, z);
        j jVar2;
        if (k == null) {
            jVar2 = j.ERR_OP_FAIL;
            AppMethodBeat.o(105385);
            return jVar2;
        }
        jVar.value = k.czD;
        jVar2 = j.OK;
        AppMethodBeat.o(105385);
        return jVar2;
    }

    public final j a(File file, String str, j<String> jVar) {
        long j = 0;
        AppMethodBeat.i(105386);
        j jVar2;
        if (file == null || !file.exists()) {
            jVar2 = j.ERR_OP_FAIL;
            AppMethodBeat.o(105386);
            return jVar2;
        } else if (!TextUtils.isEmpty(str) || jVar == null) {
            jVar2 = j.ERR_NOT_SUPPORTED;
            AppMethodBeat.o(105386);
            return jVar2;
        } else {
            if (this.gXU > 0) {
                File[] awS = this.gXT.awS();
                if (awS != null && awS.length > 0) {
                    for (File length : awS) {
                        j += length.length();
                    }
                }
                if (j + file.length() > this.gXU) {
                    jVar2 = j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    AppMethodBeat.o(105386);
                    return jVar2;
                }
            }
            v yn = this.gXT.yn(file.getName());
            if (yn == null) {
                jVar.value = this.gXT.a(this.gXT.k(file.getAbsolutePath(), null, false)).czD;
                jVar2 = j.OK;
                AppMethodBeat.o(105386);
                return jVar2;
            } else if (yn.gXl) {
                jVar.value = yn.czD;
                jVar2 = j.OK;
                AppMethodBeat.o(105386);
                return jVar2;
            } else {
                jVar.value = this.gXT.a(yn).czD;
                jVar2 = j.OK;
                AppMethodBeat.o(105386);
                return jVar2;
            }
        }
    }

    public final List<v> awQ() {
        AppMethodBeat.i(105387);
        List awR = this.gXT.awR();
        AppMethodBeat.o(105387);
        return awR;
    }

    public final boolean yi(String str) {
        AppMethodBeat.i(105388);
        v yo = this.gXT.yo(str);
        if (yo == null || !yo.gXl) {
            AppMethodBeat.o(105388);
            return false;
        }
        AppMethodBeat.o(105388);
        return true;
    }

    public final j yf(String str) {
        j jVar;
        AppMethodBeat.i(105389);
        v yo = this.gXT.yo(str);
        if (yo != null) {
            com.tencent.mm.vfs.e.deleteFile(yo.fnQ);
            if (com.tencent.mm.vfs.e.ct(yo.fnQ)) {
                d.e("MicroMsg.Luggage.FlattenFileSystem", "delete file failed, id %s, path %s", str, yo.fnQ);
                jVar = j.ERR_OP_FAIL;
                AppMethodBeat.o(105389);
                return jVar;
            }
        }
        jVar = j.OK;
        AppMethodBeat.o(105389);
        return jVar;
    }
}
