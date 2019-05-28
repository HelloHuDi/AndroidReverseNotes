package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c;
import com.tencent.mm.al.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class a implements com.tencent.mm.i.g.a {
    private static final String kDC = (b.eSj + "wallet/img/");
    private static a kDD;
    private String filename;
    public Map<String, a> jxd;

    public interface a {
        void P(String str, int i, int i2);
    }

    static {
        AppMethodBeat.i(41061);
        AppMethodBeat.o(41061);
    }

    public static a bgS() {
        AppMethodBeat.i(41055);
        if (kDD == null) {
            kDD = new a();
        }
        a aVar = kDD;
        AppMethodBeat.o(41055);
        return aVar;
    }

    public final boolean a(String str, String str2, a aVar) {
        AppMethodBeat.i(41056);
        ab.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", str);
        File file = new File(kDC);
        if (!file.exists()) {
            file.mkdirs();
        }
        g gVar = new g();
        gVar.cRY = false;
        gVar.egl = this;
        gVar.field_fullpath = kDC + bgU();
        gVar.field_mediaId = bo.nullAsNil(c.a("QrRewardImg", bo.anU(), r.Zd().field_username, ""));
        gVar.field_fileId = str;
        gVar.field_aesKey = str2;
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
        gVar.field_priority = com.tencent.mm.i.a.efC;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 0;
        gVar.field_bzScene = 0;
        if (this.jxd == null) {
            this.jxd = new HashMap();
        }
        this.jxd.put(gVar.field_mediaId, aVar);
        if (f.afx().b(gVar, -1)) {
            AppMethodBeat.o(41056);
            return true;
        }
        ab.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", str);
        AppMethodBeat.o(41056);
        return false;
    }

    public final boolean bgT() {
        AppMethodBeat.i(41057);
        boolean exists = new File(kDC + bgU()).exists();
        AppMethodBeat.o(41057);
        return exists;
    }

    private String bgU() {
        AppMethodBeat.i(41058);
        if (bo.isNullOrNil(this.filename)) {
            this.filename = ag.ck(r.Yz() + "_reward_img");
        }
        String str = this.filename;
        AppMethodBeat.o(41058);
        return str;
    }

    public final String bgV() {
        AppMethodBeat.i(41059);
        String str = kDC + bgU();
        AppMethodBeat.o(41059);
        return str;
    }

    public final int a(final String str, final int i, com.tencent.mm.i.c cVar, final d dVar, boolean z) {
        AppMethodBeat.i(41060);
        ab.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", str, Integer.valueOf(i), dVar);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(41054);
                a aVar = (a) a.this.jxd.get(str);
                if (aVar == null) {
                    ab.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
                    AppMethodBeat.o(41054);
                } else if (dVar != null) {
                    aVar.P(str, i, dVar.field_retCode);
                    a.this.jxd.remove(str);
                    if (dVar.field_retCode == 0) {
                        h.pYm.a(724, 8, 1, false);
                        AppMethodBeat.o(41054);
                        return;
                    }
                    h.pYm.a(724, 9, 1, false);
                    AppMethodBeat.o(41054);
                } else {
                    ab.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
                    AppMethodBeat.o(41054);
                }
            }
        });
        AppMethodBeat.o(41060);
        return 0;
    }

    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    public final byte[] l(String str, byte[] bArr) {
        return new byte[0];
    }
}
