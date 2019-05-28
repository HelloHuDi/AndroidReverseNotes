package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class p {
    private com.tencent.mm.i.g.a fFk = new com.tencent.mm.i.g.a() {
        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            String str2;
            AppMethodBeat.i(81483);
            String str3 = "MicroMsg.ScannerCdnService";
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
            ab.i(str3, str4, objArr);
            b bVar = new b();
            if (i != 0) {
                ab.e("MicroMsg.ScannerCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                bVar.errCode = i;
                p.a(p.this, str, bVar);
                AppMethodBeat.o(81483);
            } else {
                if (dVar != null) {
                    bVar.errCode = dVar.field_retCode;
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.ScannerCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                    } else {
                        ab.i("MicroMsg.ScannerCdnService", "cdn trans suceess, media id : %s", str);
                        bVar.fileId = dVar.field_fileId;
                        bVar.aeskey = dVar.field_aesKey;
                    }
                    p.a(p.this, str, bVar);
                }
                AppMethodBeat.o(81483);
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(81484);
            ab.i("MicroMsg.ScannerCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.o(81484);
        }

        public final byte[] l(String str, byte[] bArr) {
            AppMethodBeat.i(81485);
            ab.i("MicroMsg.ScannerCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.o(81485);
            return null;
        }
    };
    private Map<String, a> jxd = new HashMap();

    public interface a {
        void a(String str, b bVar);
    }

    public class b {
        public String aeskey;
        public int errCode;
        public String fileId;
    }

    public p() {
        AppMethodBeat.i(81486);
        AppMethodBeat.o(81486);
    }

    public static String Wr(String str) {
        AppMethodBeat.i(81487);
        String str2 = r.Yz() + "_" + str + "_" + System.currentTimeMillis();
        AppMethodBeat.o(81487);
        return str2;
    }

    public final void a(String str, String str2, int i, a aVar) {
        AppMethodBeat.i(81488);
        g gVar = new g();
        gVar.egl = this.fFk;
        gVar.field_mediaId = str;
        gVar.field_fullpath = str2;
        gVar.field_fileType = i;
        gVar.field_priority = com.tencent.mm.i.a.efC;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        gVar.field_force_aeskeycdn = true;
        gVar.field_trysafecdn = false;
        this.jxd.put(str, aVar);
        f.afx().e(gVar);
        AppMethodBeat.o(81488);
    }

    static /* synthetic */ void a(p pVar, String str, b bVar) {
        AppMethodBeat.i(81489);
        if (pVar.jxd.containsKey(str)) {
            ((a) pVar.jxd.remove(str)).a(str, bVar);
        }
        AppMethodBeat.o(81489);
    }
}
