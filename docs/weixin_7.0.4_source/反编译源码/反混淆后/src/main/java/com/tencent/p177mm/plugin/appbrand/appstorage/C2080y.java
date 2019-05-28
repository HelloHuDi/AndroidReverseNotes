package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.text.TextUtils;
import com.tencent.luggage.p147g.C37399a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appcache.C19073w;
import com.tencent.p177mm.plugin.appbrand.appcache.C45512ao;
import com.tencent.p177mm.plugin.appbrand.appcache.C45512ao.C26739a;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.y */
public final class C2080y extends C24685g {
    public final C45512ao gTI;

    public C2080y(C45512ao c45512ao) {
        this.gTI = c45512ao;
    }

    /* renamed from: ca */
    public final boolean mo5845ca(String str) {
        return true;
    }

    /* renamed from: yd */
    public final C45518j mo5849yd(String str) {
        AppMethodBeat.m2504i(86868);
        InputStream xy = this.gTI.mo73324xy(str);
        C45518j c45518j;
        if (xy == null) {
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(86868);
            return c45518j;
        }
        C5046bo.m7527b(xy);
        c45518j = C45518j.OK;
        AppMethodBeat.m2505o(86868);
        return c45518j;
    }

    /* renamed from: a */
    public final C45518j mo5837a(String str, C19681j<List<C26753h>> c19681j) {
        AppMethodBeat.m2504i(86869);
        C45518j c45518j;
        if (mo5849yd(str) == C45518j.OK) {
            c45518j = C45518j.ERR_IS_FILE;
            AppMethodBeat.m2505o(86869);
            return c45518j;
        }
        String yk = C42367l.m74946yk(str);
        C45512ao c45512ao = this.gTI;
        LinkedList<C26739a> linkedList = new LinkedList();
        for (C26739a add : c45512ao.gUi.values()) {
            linkedList.add(add);
        }
        String quote = Pattern.quote(yk);
        for (C26739a add2 : linkedList) {
            if (add2.fileName.startsWith(yk)) {
                String replaceFirst = add2.fileName.replaceFirst(quote, "");
                if (replaceFirst.split("/").length <= 1) {
                    Object linkedList2;
                    C26753h c26753h = new C26753h();
                    c26753h.fileName = replaceFirst;
                    if (c19681j.value == null) {
                        linkedList2 = new LinkedList();
                    } else {
                        List linkedList22 = (List) c19681j.value;
                    }
                    c19681j.value = linkedList22;
                    ((List) c19681j.value).add(c26753h);
                }
            }
        }
        if (c19681j.value == null) {
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(86869);
            return c45518j;
        }
        c45518j = C45518j.OK;
        AppMethodBeat.m2505o(86869);
        return c45518j;
    }

    /* renamed from: ye */
    public final C45518j mo5850ye(String str) {
        AppMethodBeat.m2504i(86870);
        C45518j a = mo5837a(str, new C19681j());
        AppMethodBeat.m2505o(86870);
        return a;
    }

    /* renamed from: b */
    public final C45518j mo5843b(String str, C19681j<ByteBuffer> c19681j) {
        AppMethodBeat.m2504i(86871);
        InputStream xy = this.gTI.mo73324xy(str);
        C45518j c45518j;
        if (xy == null) {
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(86871);
            return c45518j;
        }
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(xy.available());
            if (xy instanceof C37399a) {
                allocateDirect.put(((C37399a) xy).bRy);
            } else {
                allocateDirect.put(ByteBuffer.wrap(C45672d.m84373k(xy)));
            }
            allocateDirect.rewind();
            c19681j.value = allocateDirect;
            c45518j = C45518j.OK;
            C5046bo.m7527b(xy);
            AppMethodBeat.m2505o(86871);
            return c45518j;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WxaPkgFileSystem", e, "readFile", new Object[0]);
            C5046bo.m7527b(xy);
            c45518j = C45518j.ERR_OP_FAIL;
            AppMethodBeat.m2505o(86871);
            return c45518j;
        } catch (Throwable th) {
            C5046bo.m7527b(xy);
            AppMethodBeat.m2505o(86871);
        }
    }

    /* renamed from: a */
    public final C45518j mo5836a(String str, C42366k c42366k) {
        AppMethodBeat.m2504i(86872);
        InputStream xy = this.gTI.mo73324xy(str);
        C45518j c45518j;
        if (xy == null) {
            c45518j = C45518j.RET_NOT_EXISTS;
            AppMethodBeat.m2505o(86872);
            return c45518j;
        }
        C45512ao c45512ao = this.gTI;
        C42366k c42366k2 = c45512ao.gUj;
        if (c42366k2 == null) {
            c42366k2 = new C42366k();
            FileStat.stat(c45512ao.gUc.getAbsolutePath(), c42366k2);
            c45512ao.gUj = c42366k2;
        }
        if (c42366k != null) {
            c42366k.st_mode = c42366k2.st_mode;
            c42366k.st_size = c42366k2.st_size;
            c42366k.st_atime = c42366k2.st_atime;
            c42366k.st_mtime = c42366k2.st_mtime;
            c42366k.st_ctime = c42366k2.st_ctime;
        }
        try {
            c42366k.st_size = (long) xy.available();
            C5046bo.m7527b(xy);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.WxaPkgFileSystem", "stat(), %s stream.available fail", str);
        }
        c45518j = C45518j.OK;
        AppMethodBeat.m2505o(86872);
        return c45518j;
    }

    /* renamed from: Z */
    public final File mo5832Z(String str, boolean z) {
        AppMethodBeat.m2504i(86873);
        if (!z) {
            if ((mo5850ye(str) == C45518j.OK ? 1 : null) != null) {
                AppMethodBeat.m2505o(86873);
                return null;
            }
        }
        String a = C19073w.m29638a(this.gTI, str);
        if (TextUtils.isEmpty(a)) {
            AppMethodBeat.m2505o(86873);
            return null;
        }
        File file = new File(a);
        AppMethodBeat.m2505o(86873);
        return file;
    }

    public final void initialize() {
        AppMethodBeat.m2504i(86874);
        this.gTI.avW();
        AppMethodBeat.m2505o(86874);
    }

    public final void release() {
        AppMethodBeat.m2504i(86875);
        this.gTI.close();
        AppMethodBeat.m2505o(86875);
    }
}
