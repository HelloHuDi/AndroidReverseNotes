package com.tencent.mm.plugin.webview.e;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.webview.model.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class b {
    String appId;
    public String hWL;
    private a uKL = new a(this, (byte) 0);
    Map<String, String> uKM = new HashMap();
    public MutableLiveData<String> uKN = new MutableLiveData();
    public b uKO = b.NONE;

    class a implements com.tencent.mm.i.g.a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(10132);
            ab.d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i), cVar, dVar);
            synchronized (b.this) {
                if (dVar != null) {
                    try {
                        if (dVar.field_retCode == 0 && i == 0) {
                            String str2 = (String) b.this.uKM.get(str);
                            if (b.this.hWL.equals(str2)) {
                                ab.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", dVar.field_fileUrl);
                                g.Rg().a(new h(dVar.field_fileUrl, b.this.appId, str2), 0);
                                AppMethodBeat.o(10132);
                            } else {
                                ab.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", b.this.hWL, str2);
                            }
                        }
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(10132);
                    }
                }
                AppMethodBeat.o(10132);
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return null;
        }
    }

    public enum b {
        NONE,
        LOADING,
        SUCCESS,
        FAIL;

        static {
            AppMethodBeat.o(10135);
        }
    }

    public b() {
        AppMethodBeat.i(10136);
        AppMethodBeat.o(10136);
    }

    public final void ho(String str, String str2) {
        AppMethodBeat.i(10137);
        this.appId = str2;
        this.hWL = str;
        this.uKO = b.LOADING;
        long currentTimeMillis = System.currentTimeMillis();
        String a = com.tencent.mm.al.c.a("vestacountavatar", currentTimeMillis, r.Zd().field_username, String.valueOf(currentTimeMillis));
        this.uKM.put(bo.nullAsNil(a), str);
        hp(str, a);
        AppMethodBeat.o(10137);
    }

    private void hp(String str, String str2) {
        AppMethodBeat.i(10138);
        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
        gVar.egl = this.uKL;
        gVar.field_mediaId = str2;
        gVar.field_fullpath = str;
        gVar.field_fileType = com.tencent.mm.i.a.efN;
        gVar.field_priority = com.tencent.mm.i.a.efB;
        gVar.field_needStorage = true;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 200;
        gVar.field_bzScene = 2;
        if (!f.afx().e(gVar)) {
            ab.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", str2);
            this.uKO = b.FAIL;
        }
        AppMethodBeat.o(10138);
    }
}
