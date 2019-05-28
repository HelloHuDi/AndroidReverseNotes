package com.tencent.p177mm.plugin.cdndownloader.p1544i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.cdndownloader.p934c.C11365a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.xweb.p1634b.C44573a;
import com.tencent.xweb.p1634b.C44574b;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.cdndownloader.i.a */
public final class C44726a implements C44573a {
    private static C44726a ktG = null;
    private Map<String, C42878a> ktC = new ConcurrentHashMap();
    private C1628a ktz = new C387841();

    /* renamed from: com.tencent.mm.plugin.cdndownloader.i.a$1 */
    class C387841 implements C1628a {
        C387841() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            String str2;
            AppMethodBeat.m2504i(972);
            String str3 = "FileDownloaderXWEBProxy";
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
                C4990ab.m7417i("FileDownloaderXWEBProxy", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.m2505o(972);
            } else if (i != 0) {
                C4990ab.m7413e("FileDownloaderXWEBProxy", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                C44726a.m81462a(C44726a.this, str, 4, i, false);
                AppMethodBeat.m2505o(972);
            } else if (c18496c != null) {
                C44726a.m81463a(C44726a.this, str, (long) c18496c.field_finishedLength, (long) c18496c.field_toltalLength);
                AppMethodBeat.m2505o(972);
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("FileDownloaderXWEBProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(c9545d.field_retCode), c9545d);
                        C44726a.m81462a(C44726a.this, str, 4, c9545d.field_retCode, c9545d.field_isResume);
                    } else {
                        C4990ab.m7417i("FileDownloaderXWEBProxy", "cdn trans suceess, media id : %s", str);
                        C44726a.m81462a(C44726a.this, str, 3, 0, c9545d.field_isResume);
                    }
                }
                AppMethodBeat.m2505o(972);
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

    /* renamed from: com.tencent.mm.plugin.cdndownloader.i.a$a */
    class C42878a {
        public String ktF;
        public C44574b ktI;

        private C42878a() {
            this.ktI = null;
            this.ktF = null;
        }

        /* synthetic */ C42878a(C44726a c44726a, byte b) {
            this();
        }
    }

    public C44726a() {
        AppMethodBeat.m2504i(973);
        AppMethodBeat.m2505o(973);
    }

    public static synchronized C44726a bfd() {
        C44726a c44726a;
        synchronized (C44726a.class) {
            AppMethodBeat.m2504i(974);
            if (ktG == null) {
                ktG = new C44726a();
            }
            C11365a.beU();
            c44726a = ktG;
            AppMethodBeat.m2505o(974);
        }
        return c44726a;
    }

    /* renamed from: a */
    public final int mo71373a(String str, String str2, C44574b c44574b) {
        AppMethodBeat.m2504i(975);
        C4990ab.m7417i("FileDownloaderXWEBProxy", "addDownloadTask: %s filepath:%s", str, str2);
        C42130g c42130g = new C42130g();
        c42130g.field_mediaId = str;
        c42130g.field_fullpath = str2;
        c42130g.egm = str;
        c42130g.field_fileType = C42129a.efS;
        c42130g.egl = this.ktz;
        c42130g.egn = 60;
        c42130g.ego = 600;
        c42130g.egq = false;
        C42878a c42878a = new C42878a(this, (byte) 0);
        c42878a.ktI = c44574b;
        c42878a.ktF = str2;
        this.ktC.put(str, c42878a);
        int f = C11365a.beU().mo23097f(c42130g);
        C4990ab.m7416i("FileDownloaderXWEBProxy", "addDownloadTask: ".concat(String.valueOf(f)));
        AppMethodBeat.m2505o(975);
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ void m81462a(C44726a c44726a, String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(976);
        C4990ab.m7417i("FileDownloaderXWEBProxy", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s, containCallback = %b", str, Integer.valueOf(i), Integer.valueOf(i2), null, Boolean.valueOf(c44726a.ktC.containsKey(str)));
        if (c44726a.ktC.containsKey(str)) {
            C44574b c44574b = ((C42878a) c44726a.ktC.get(str)).ktI;
            if (c44574b == null) {
                C4990ab.m7412e("FileDownloaderXWEBProxy", "error proxy_callback null");
                AppMethodBeat.m2505o(976);
                return;
            } else if (i == 3) {
                c44574b.mo71376f(str, ((C42878a) c44726a.ktC.get(str)).ktF, z);
                AppMethodBeat.m2505o(976);
                return;
            } else {
                c44574b.mo71374d(str, i2, z);
            }
        }
        AppMethodBeat.m2505o(976);
    }

    /* renamed from: a */
    static /* synthetic */ void m81463a(C44726a c44726a, String str, long j, long j2) {
        AppMethodBeat.m2504i(977);
        C4990ab.m7411d("FileDownloaderXWEBProxy", "updateProgressChange, mediaId = %s, recvLen = %d, totalLen= %d, containCallback = %b", str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(c44726a.ktC.containsKey(str)));
        if (c44726a.ktC.containsKey(str)) {
            C44574b c44574b = ((C42878a) c44726a.ktC.get(str)).ktI;
            if (c44574b == null) {
                C4990ab.m7412e("FileDownloaderXWEBProxy", "error proxy_callback null");
                AppMethodBeat.m2505o(977);
                return;
            }
            c44574b.mo71375e(str, j, j2);
        }
        AppMethodBeat.m2505o(977);
    }
}
