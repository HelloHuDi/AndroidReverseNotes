package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.p147g.C37400c;
import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.m */
public class C42368m extends C24685g {
    public final String gXQ;
    private final String gXR;
    private final String gXS;
    public final LuggageLocalFileObjectManager gXT;
    public volatile long gXU = -1;

    public C42368m(String str, String str2, String str3) {
        AppMethodBeat.m2504i(105374);
        this.gXQ = new File(str).getAbsolutePath();
        this.gXR = str2;
        this.gXS = str3;
        this.gXT = new LuggageLocalFileObjectManager(this.gXQ, this.gXR, this.gXS);
        AppMethodBeat.m2505o(105374);
    }

    /* renamed from: ca */
    public final boolean mo5845ca(String str) {
        AppMethodBeat.m2504i(105375);
        boolean startsWith = C5046bo.nullAsNil(str).startsWith(this.gXS);
        AppMethodBeat.m2505o(105375);
        return startsWith;
    }

    /* renamed from: yd */
    public final C45518j mo5849yd(String str) {
        AppMethodBeat.m2504i(105376);
        C2061v yo = this.gXT.mo21457yo(str);
        C45518j c45518j;
        if (yo == null || !C1173e.m2561ct(yo.fnQ)) {
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(105376);
            return c45518j;
        }
        c45518j = C45518j.OK;
        AppMethodBeat.m2505o(105376);
        return c45518j;
    }

    /* renamed from: b */
    public final C45518j mo5843b(String str, C19681j<ByteBuffer> c19681j) {
        AppMethodBeat.m2504i(105377);
        C2061v yo = this.gXT.mo21457yo(str);
        C45518j c45518j;
        if (yo == null || !C1173e.m2561ct(yo.fnQ)) {
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(105377);
            return c45518j;
        }
        c19681j.value = C42367l.m74940D(new File(yo.fnQ));
        c45518j = C45518j.OK;
        AppMethodBeat.m2505o(105377);
        return c45518j;
    }

    /* renamed from: a */
    public final C45518j mo5836a(String str, C42366k c42366k) {
        AppMethodBeat.m2504i(105378);
        C2061v yo = this.gXT.mo21457yo(str);
        C45518j c45518j;
        if (yo == null || !C1173e.m2561ct(yo.fnQ)) {
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(105378);
            return c45518j;
        } else if (c42366k == null) {
            c45518j = C45518j.ERR_OP_FAIL;
            AppMethodBeat.m2505o(105378);
            return c45518j;
        } else if (FileStat.stat(yo.fnQ, c42366k) == 0) {
            c45518j = C45518j.OK;
            AppMethodBeat.m2505o(105378);
            return c45518j;
        } else {
            c45518j = C45518j.ERR_OP_FAIL;
            AppMethodBeat.m2505o(105378);
            return c45518j;
        }
    }

    /* renamed from: a */
    public final C45518j mo5837a(String str, C19681j<List<C26753h>> c19681j) {
        AppMethodBeat.m2504i(105379);
        LinkedList<C2061v> linkedList = new LinkedList();
        C37400c.m63005c(linkedList, this.gXT.awR());
        C37400c.m63005c(linkedList, this.gXT.awT());
        LinkedList linkedList2 = new LinkedList();
        for (C2061v c2061v : linkedList) {
            C26753h c26753h = new C26753h();
            c26753h.fileName = c2061v.czD;
            linkedList2.add(c26753h);
        }
        c19681j.value = linkedList2;
        C45518j c45518j = C45518j.OK;
        AppMethodBeat.m2505o(105379);
        return c45518j;
    }

    /* renamed from: Z */
    public final File mo5832Z(String str, boolean z) {
        AppMethodBeat.m2504i(105380);
        File yg = mo34314yg(str);
        AppMethodBeat.m2505o(105380);
        return yg;
    }

    /* renamed from: yg */
    public final File mo34314yg(String str) {
        AppMethodBeat.m2504i(105381);
        C2061v yo = this.gXT.mo21457yo(str);
        if (yo == null) {
            AppMethodBeat.m2505o(105381);
            return null;
        }
        File file = new File(yo.fnQ);
        AppMethodBeat.m2505o(105381);
        return file;
    }

    /* renamed from: yl */
    public final String mo67883yl(String str) {
        AppMethodBeat.m2504i(105382);
        C2061v yo = this.gXT.mo21457yo(str);
        if (yo == null) {
            AppMethodBeat.m2505o(105382);
            return null;
        }
        String str2 = yo.fnQ;
        AppMethodBeat.m2505o(105382);
        return str2;
    }

    public final void initialize() {
        AppMethodBeat.m2504i(105383);
        if (!C5730e.m8643tf(this.gXQ)) {
            C45124d.m82927e("MicroMsg.Luggage.FlattenFileSystem", "Initialization Failed");
        }
        AppMethodBeat.m2505o(105383);
    }

    /* renamed from: yh */
    public final C5728b mo34315yh(String str) {
        AppMethodBeat.m2504i(105384);
        C5730e.m8643tf(this.gXQ);
        C5728b c5728b = new C5728b(this.gXQ + "/" + str);
        AppMethodBeat.m2505o(105384);
        return c5728b;
    }

    /* renamed from: a */
    public final C45518j mo5833a(C19681j<String> c19681j) {
        c19681j.value = this.gXQ;
        return C45518j.OK;
    }

    /* renamed from: a */
    public final C45518j mo5835a(File file, String str, boolean z, C19681j<String> c19681j) {
        AppMethodBeat.m2504i(105385);
        C2061v k = this.gXT.mo21455k(file.getAbsolutePath(), str, z);
        C45518j c45518j;
        if (k == null) {
            c45518j = C45518j.ERR_OP_FAIL;
            AppMethodBeat.m2505o(105385);
            return c45518j;
        }
        c19681j.value = k.czD;
        c45518j = C45518j.OK;
        AppMethodBeat.m2505o(105385);
        return c45518j;
    }

    /* renamed from: a */
    public final C45518j mo5834a(File file, String str, C19681j<String> c19681j) {
        long j = 0;
        AppMethodBeat.m2504i(105386);
        C45518j c45518j;
        if (file == null || !file.exists()) {
            c45518j = C45518j.ERR_OP_FAIL;
            AppMethodBeat.m2505o(105386);
            return c45518j;
        } else if (!TextUtils.isEmpty(str) || c19681j == null) {
            c45518j = C45518j.ERR_NOT_SUPPORTED;
            AppMethodBeat.m2505o(105386);
            return c45518j;
        } else {
            if (this.gXU > 0) {
                File[] awS = this.gXT.awS();
                if (awS != null && awS.length > 0) {
                    for (File length : awS) {
                        j += length.length();
                    }
                }
                if (j + file.length() > this.gXU) {
                    c45518j = C45518j.ERR_EXCEED_DIRECTORY_MAX_SIZE;
                    AppMethodBeat.m2505o(105386);
                    return c45518j;
                }
            }
            C2061v yn = this.gXT.mo21456yn(file.getName());
            if (yn == null) {
                c19681j.value = this.gXT.mo21450a(this.gXT.mo21455k(file.getAbsolutePath(), null, false)).czD;
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105386);
                return c45518j;
            } else if (yn.gXl) {
                c19681j.value = yn.czD;
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105386);
                return c45518j;
            } else {
                c19681j.value = this.gXT.mo21450a(yn).czD;
                c45518j = C45518j.OK;
                AppMethodBeat.m2505o(105386);
                return c45518j;
            }
        }
    }

    public final List<C2061v> awQ() {
        AppMethodBeat.m2504i(105387);
        List awR = this.gXT.awR();
        AppMethodBeat.m2505o(105387);
        return awR;
    }

    /* renamed from: yi */
    public final boolean mo34316yi(String str) {
        AppMethodBeat.m2504i(105388);
        C2061v yo = this.gXT.mo21457yo(str);
        if (yo == null || !yo.gXl) {
            AppMethodBeat.m2505o(105388);
            return false;
        }
        AppMethodBeat.m2505o(105388);
        return true;
    }

    /* renamed from: yf */
    public final C45518j mo5851yf(String str) {
        C45518j c45518j;
        AppMethodBeat.m2504i(105389);
        C2061v yo = this.gXT.mo21457yo(str);
        if (yo != null) {
            C5730e.deleteFile(yo.fnQ);
            if (C5730e.m8628ct(yo.fnQ)) {
                C45124d.m82928e("MicroMsg.Luggage.FlattenFileSystem", "delete file failed, id %s, path %s", str, yo.fnQ);
                c45518j = C45518j.ERR_OP_FAIL;
                AppMethodBeat.m2505o(105389);
                return c45518j;
            }
        }
        c45518j = C45518j.OK;
        AppMethodBeat.m2505o(105389);
        return c45518j;
    }
}
