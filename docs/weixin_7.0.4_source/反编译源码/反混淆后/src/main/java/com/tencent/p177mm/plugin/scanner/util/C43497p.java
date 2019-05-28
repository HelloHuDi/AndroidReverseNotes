package com.tencent.p177mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.util.p */
public final class C43497p {
    private C1628a fFk = new C70721();
    private Map<String, C39642a> jxd = new HashMap();

    /* renamed from: com.tencent.mm.plugin.scanner.util.p$1 */
    class C70721 implements C1628a {
        C70721() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            String str2;
            AppMethodBeat.m2504i(81483);
            String str3 = "MicroMsg.ScannerCdnService";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = c18496c == null ? BuildConfig.COMMAND : c18496c.toString();
            if (c9545d == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = c9545d.toString();
            }
            objArr[3] = str2;
            C4990ab.m7417i(str3, str4, objArr);
            C43496b c43496b = new C43496b();
            if (i != 0) {
                C4990ab.m7413e("MicroMsg.ScannerCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                c43496b.errCode = i;
                C43497p.m77718a(C43497p.this, str, c43496b);
                AppMethodBeat.m2505o(81483);
            } else {
                if (c9545d != null) {
                    c43496b.errCode = c9545d.field_retCode;
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.ScannerCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(c9545d.field_retCode), c9545d);
                    } else {
                        C4990ab.m7417i("MicroMsg.ScannerCdnService", "cdn trans suceess, media id : %s", str);
                        c43496b.fileId = c9545d.field_fileId;
                        c43496b.aeskey = c9545d.field_aesKey;
                    }
                    C43497p.m77718a(C43497p.this, str, c43496b);
                }
                AppMethodBeat.m2505o(81483);
            }
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.m2504i(81484);
            C4990ab.m7417i("MicroMsg.ScannerCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.m2505o(81484);
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            AppMethodBeat.m2504i(81485);
            C4990ab.m7417i("MicroMsg.ScannerCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.m2505o(81485);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.p$a */
    public interface C39642a {
        /* renamed from: a */
        void mo25164a(String str, C43496b c43496b);
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.p$b */
    public class C43496b {
        public String aeskey;
        public int errCode;
        public String fileId;
    }

    public C43497p() {
        AppMethodBeat.m2504i(81486);
        AppMethodBeat.m2505o(81486);
    }

    /* renamed from: Wr */
    public static String m77717Wr(String str) {
        AppMethodBeat.m2504i(81487);
        String str2 = C1853r.m3846Yz() + "_" + str + "_" + System.currentTimeMillis();
        AppMethodBeat.m2505o(81487);
        return str2;
    }

    /* renamed from: a */
    public final void mo69045a(String str, String str2, int i, C39642a c39642a) {
        AppMethodBeat.m2504i(81488);
        C42130g c42130g = new C42130g();
        c42130g.egl = this.fFk;
        c42130g.field_mediaId = str;
        c42130g.field_fullpath = str2;
        c42130g.field_fileType = i;
        c42130g.field_priority = C42129a.efC;
        c42130g.field_needStorage = false;
        c42130g.field_isStreamMedia = false;
        c42130g.field_force_aeskeycdn = true;
        c42130g.field_trysafecdn = false;
        this.jxd.put(str, c39642a);
        C37461f.afx().mo51225e(c42130g);
        AppMethodBeat.m2505o(81488);
    }

    /* renamed from: a */
    static /* synthetic */ void m77718a(C43497p c43497p, String str, C43496b c43496b) {
        AppMethodBeat.m2504i(81489);
        if (c43497p.jxd.containsKey(str)) {
            ((C39642a) c43497p.jxd.remove(str)).mo25164a(str, c43496b);
        }
        AppMethodBeat.m2505o(81489);
    }
}
