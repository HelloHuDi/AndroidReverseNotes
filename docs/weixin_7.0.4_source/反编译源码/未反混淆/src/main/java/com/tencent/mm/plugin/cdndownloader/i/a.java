package com.tencent.mm.plugin.cdndownloader.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.b.b;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements com.tencent.xweb.b.a {
    private static a ktG = null;
    private Map<String, a> ktC = new ConcurrentHashMap();
    private com.tencent.mm.i.g.a ktz = new com.tencent.mm.i.g.a() {
        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            String str2;
            AppMethodBeat.i(972);
            String str3 = "FileDownloaderXWEBProxy";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = cVar == null ? BuildConfig.COMMAND : cVar.toString();
            if (dVar == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = dVar.toString();
            }
            objArr[3] = str2;
            ab.d(str3, str4, objArr);
            if (i == -21006) {
                ab.i("FileDownloaderXWEBProxy", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(972);
            } else if (i != 0) {
                ab.e("FileDownloaderXWEBProxy", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                a.a(a.this, str, 4, i, false);
                AppMethodBeat.o(972);
            } else if (cVar != null) {
                a.a(a.this, str, (long) cVar.field_finishedLength, (long) cVar.field_toltalLength);
                AppMethodBeat.o(972);
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        ab.e("FileDownloaderXWEBProxy", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        a.a(a.this, str, 4, dVar.field_retCode, dVar.field_isResume);
                    } else {
                        ab.i("FileDownloaderXWEBProxy", "cdn trans suceess, media id : %s", str);
                        a.a(a.this, str, 3, 0, dVar.field_isResume);
                    }
                }
                AppMethodBeat.o(972);
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }
    };

    class a {
        public String ktF;
        public b ktI;

        private a() {
            this.ktI = null;
            this.ktF = null;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(973);
        AppMethodBeat.o(973);
    }

    public static synchronized a bfd() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(974);
            if (ktG == null) {
                ktG = new a();
            }
            com.tencent.mm.plugin.cdndownloader.c.a.beU();
            aVar = ktG;
            AppMethodBeat.o(974);
        }
        return aVar;
    }

    public final int a(String str, String str2, b bVar) {
        AppMethodBeat.i(975);
        ab.i("FileDownloaderXWEBProxy", "addDownloadTask: %s filepath:%s", str, str2);
        g gVar = new g();
        gVar.field_mediaId = str;
        gVar.field_fullpath = str2;
        gVar.egm = str;
        gVar.field_fileType = com.tencent.mm.i.a.efS;
        gVar.egl = this.ktz;
        gVar.egn = 60;
        gVar.ego = 600;
        gVar.egq = false;
        a aVar = new a(this, (byte) 0);
        aVar.ktI = bVar;
        aVar.ktF = str2;
        this.ktC.put(str, aVar);
        int f = com.tencent.mm.plugin.cdndownloader.c.a.beU().f(gVar);
        ab.i("FileDownloaderXWEBProxy", "addDownloadTask: ".concat(String.valueOf(f)));
        AppMethodBeat.o(975);
        return f;
    }

    static /* synthetic */ void a(a aVar, String str, int i, int i2, boolean z) {
        AppMethodBeat.i(976);
        ab.i("FileDownloaderXWEBProxy", "updateDownloadState, mediaId = %s, state = %d, errCode= %d, errMsg = %s, containCallback = %b", str, Integer.valueOf(i), Integer.valueOf(i2), null, Boolean.valueOf(aVar.ktC.containsKey(str)));
        if (aVar.ktC.containsKey(str)) {
            b bVar = ((a) aVar.ktC.get(str)).ktI;
            if (bVar == null) {
                ab.e("FileDownloaderXWEBProxy", "error proxy_callback null");
                AppMethodBeat.o(976);
                return;
            } else if (i == 3) {
                bVar.f(str, ((a) aVar.ktC.get(str)).ktF, z);
                AppMethodBeat.o(976);
                return;
            } else {
                bVar.d(str, i2, z);
            }
        }
        AppMethodBeat.o(976);
    }

    static /* synthetic */ void a(a aVar, String str, long j, long j2) {
        AppMethodBeat.i(977);
        ab.d("FileDownloaderXWEBProxy", "updateProgressChange, mediaId = %s, recvLen = %d, totalLen= %d, containCallback = %b", str, Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(aVar.ktC.containsKey(str)));
        if (aVar.ktC.containsKey(str)) {
            b bVar = ((a) aVar.ktC.get(str)).ktI;
            if (bVar == null) {
                ab.e("FileDownloaderXWEBProxy", "error proxy_callback null");
                AppMethodBeat.o(977);
                return;
            }
            bVar.e(str, j, j2);
        }
        AppMethodBeat.o(977);
    }
}
