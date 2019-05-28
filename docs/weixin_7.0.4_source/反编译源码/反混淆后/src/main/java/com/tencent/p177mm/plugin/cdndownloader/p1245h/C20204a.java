package com.tencent.p177mm.plugin.cdndownloader.p1245h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p1087t.C15446a;
import com.tencent.p177mm.p1087t.C30310b;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.cdndownloader.p934c.C11365a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.cdndownloader.h.a */
public final class C20204a implements C15446a {
    private static C20204a ktB = null;
    private Map<String, C20203a> ktC = new ConcurrentHashMap();
    private C1628a ktz = new C202051();

    /* renamed from: com.tencent.mm.plugin.cdndownloader.h.a$a */
    class C20203a {
        public C30310b ktE;
        public String ktF;

        private C20203a() {
            this.ktE = null;
            this.ktF = null;
        }

        /* synthetic */ C20203a(C20204a c20204a, byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.cdndownloader.h.a$1 */
    class C202051 implements C1628a {
        C202051() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            String str2;
            AppMethodBeat.m2504i(966);
            String str3 = "FileDownloaderWAGameProxy";
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
            C4990ab.m7411d(str3, str4, objArr);
            if (i == -21006) {
                C4990ab.m7417i("FileDownloaderWAGameProxy", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.m2505o(966);
            } else if (i != 0) {
                C4990ab.m7413e("FileDownloaderWAGameProxy", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                C20204a.m31241a(C20204a.this, str, 4, i, false);
                AppMethodBeat.m2505o(966);
            } else if (c18496c != null) {
                C20204a.m31242a(C20204a.this, str, (long) c18496c.field_finishedLength, (long) c18496c.field_toltalLength);
                AppMethodBeat.m2505o(966);
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("FileDownloaderWAGameProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(c9545d.field_retCode), c9545d);
                        C20204a.m31241a(C20204a.this, str, 4, c9545d.field_retCode, c9545d.field_isResume);
                    } else {
                        C4990ab.m7417i("FileDownloaderWAGameProxy", "cdn trans suceess, media id : %s", str);
                        C20204a.m31241a(C20204a.this, str, 3, 0, c9545d.field_isResume);
                    }
                }
                AppMethodBeat.m2505o(966);
            }
            return 0;
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public C20204a() {
        AppMethodBeat.m2504i(967);
        AppMethodBeat.m2505o(967);
    }

    public static synchronized C20204a bfc() {
        C20204a c20204a;
        synchronized (C20204a.class) {
            AppMethodBeat.m2504i(968);
            if (ktB == null) {
                ktB = new C20204a();
            }
            C11365a.beU();
            c20204a = ktB;
            AppMethodBeat.m2505o(968);
        }
        return c20204a;
    }

    /* renamed from: a */
    public final int mo27489a(String str, String str2, C30310b c30310b) {
        AppMethodBeat.m2504i(969);
        C4990ab.m7417i("FileDownloaderWAGameProxy", "addDownloadTask: %s filepath:%s", str, str2);
        C42130g c42130g = new C42130g();
        c42130g.field_mediaId = str;
        c42130g.field_fullpath = str2;
        c42130g.egm = str;
        c42130g.field_fileType = C42129a.efV;
        c42130g.egl = this.ktz;
        c42130g.egn = 60;
        c42130g.ego = 600;
        c42130g.egq = false;
        C20203a c20203a = new C20203a(this, (byte) 0);
        c20203a.ktE = c30310b;
        c20203a.ktF = str2;
        this.ktC.put(str, c20203a);
        int f = C11365a.beU().mo23097f(c42130g);
        C4990ab.m7416i("FileDownloaderWAGameProxy", "addDownloadTask: ".concat(String.valueOf(f)));
        AppMethodBeat.m2505o(969);
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ void m31241a(C20204a c20204a, String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(970);
        C4990ab.m7417i("FileDownloaderWAGameProxy", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s, containCallback = %b", str, Integer.valueOf(i), Integer.valueOf(i2), null, Boolean.valueOf(c20204a.ktC.containsKey(str)));
        if (c20204a.ktC.containsKey(str)) {
            C30310b c30310b = ((C20203a) c20204a.ktC.get(str)).ktE;
            if (c30310b == null) {
                C4990ab.m7412e("FileDownloaderWAGameProxy", "error proxy_callback null");
                AppMethodBeat.m2505o(970);
                return;
            } else if (i == 3) {
                c30310b.mo48603f(str, ((C20203a) c20204a.ktC.get(str)).ktF, z);
                AppMethodBeat.m2505o(970);
                return;
            } else {
                c30310b.mo48601d(str, i2, z);
            }
        }
        AppMethodBeat.m2505o(970);
    }

    /* renamed from: a */
    static /* synthetic */ void m31242a(C20204a c20204a, String str, long j, long j2) {
        AppMethodBeat.m2504i(971);
        C4990ab.m7411d("FileDownloaderWAGameProxy", "updateProgressChange, mediaId = %s, recvLen = %d, totalLen= %d, containCallback = %b", str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(c20204a.ktC.containsKey(str)));
        if (c20204a.ktC.containsKey(str)) {
            C30310b c30310b = ((C20203a) c20204a.ktC.get(str)).ktE;
            if (c30310b == null) {
                C4990ab.m7412e("FileDownloaderWAGameProxy", "error proxy_callback null");
                AppMethodBeat.m2505o(971);
                return;
            }
            c30310b.mo48602e(str, j, j2);
        }
        AppMethodBeat.m2505o(971);
    }
}
