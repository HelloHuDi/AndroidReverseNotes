package com.tencent.mm.plugin.appbrand.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public final class b {
    public a fFk = new a() {
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.i(129811);
            ab.i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.o(129811);
        }

        public final byte[] l(String str, byte[] bArr) {
            AppMethodBeat.i(129812);
            ab.i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.o(129812);
            return null;
        }

        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            String str2;
            a aVar;
            AppMethodBeat.i(129813);
            String str3 = "MicroMsg.AppbrandCdnService";
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
            c auX = f.auX();
            if (!bo.isNullOrNil(str)) {
                for (a aVar2 : auX.hez.values()) {
                    if (bo.nullAsNil(aVar2.cHr).equals(str)) {
                        aVar = aVar2;
                        break;
                    }
                }
            }
            ab.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByMediaID error, media id is null or nil");
            aVar = null;
            if (aVar == null) {
                ab.e("MicroMsg.AppbrandCdnService", "get item by media id failed, media is : %s", str);
                AppMethodBeat.o(129813);
                return 0;
            } else if (i == -21005) {
                ab.i("MicroMsg.AppbrandCdnService", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.o(129813);
                return 0;
            } else if (i != 0) {
                ab.e("MicroMsg.AppbrandCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                b.a(b.this, false, aVar.czD, aVar.cHr, null);
                AppMethodBeat.o(129813);
                return 0;
            } else if (cVar != null) {
                int i2;
                ab.i("MicroMsg.AppbrandCdnService", "progressInfo : %s", cVar.toString());
                int i3 = 0;
                if (cVar.field_toltalLength > 0) {
                    i3 = (cVar.field_finishedLength * 100) / cVar.field_toltalLength;
                }
                if (i3 < 0) {
                    i2 = 0;
                } else if (i3 > 100) {
                    i2 = 100;
                } else {
                    i2 = i3;
                }
                b bVar = b.this;
                boolean z2 = aVar.her;
                int i4 = aVar.cyQ;
                String str5 = aVar.czD;
                str4 = aVar.cHr;
                ab.i("MicroMsg.AppbrandCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i2), str5, str4);
                if (bVar.hev != null && bVar.hev.size() > 0) {
                    Iterator it = bVar.hev.iterator();
                    while (it.hasNext()) {
                        ((d.a) it.next()).J(i2, str5);
                    }
                }
                AppMethodBeat.o(129813);
                return 0;
            } else {
                if (dVar != null) {
                    if (dVar.field_retCode != 0) {
                        ab.e("MicroMsg.AppbrandCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                        b.a(b.this, false, aVar.czD, aVar.cHr, null);
                    } else {
                        ab.i("MicroMsg.AppbrandCdnService", "cdn trans suceess, media id : %s", str);
                        if (aVar != null) {
                            if (aVar.heq == null) {
                                aVar.heq = new a.a();
                            }
                            if (dVar == null) {
                                ab.e("MicroMsg.AppBrandMediaCdnItem", "sceneResult info is null");
                            } else {
                                aVar.heq.field_aesKey = dVar.field_aesKey;
                                aVar.heq.field_fileId = dVar.field_fileId;
                                aVar.heq.field_fileUrl = dVar.field_fileUrl;
                                aVar.heq.field_fileLength = dVar.field_fileLength;
                                aVar.hep = aVar.heq.field_fileId;
                            }
                            f.auX().a(aVar);
                            b.a(b.this, true, aVar.czD, aVar.hep, aVar.heq.field_fileUrl);
                        }
                    }
                }
                AppMethodBeat.o(129813);
                return 0;
            }
        }
    };
    public Vector<com.tencent.mm.plugin.appbrand.c.d.b> heu = new Vector();
    public Vector<d.a> hev = new Vector();
    public HashMap<String, d.c> hew = new HashMap();
    public h.a hex = new h.a() {
        public final void onMoovReady(String str, int i, int i2) {
            AppMethodBeat.i(129814);
            ab.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", str, Integer.valueOf(i), Integer.valueOf(i2));
            d.c cVar = (d.c) b.this.hew.get(str);
            if (cVar != null) {
                cVar.cR(i, i2);
            }
            AppMethodBeat.o(129814);
        }

        public final void onDataAvailable(String str, int i, int i2) {
            AppMethodBeat.i(129815);
            ab.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", str, Integer.valueOf(i), Integer.valueOf(i2));
            d.c cVar = (d.c) b.this.hew.get(str);
            if (cVar != null) {
                cVar.cS(i, i2);
            }
            AppMethodBeat.o(129815);
        }

        public final void h(String str, int i, int i2) {
            AppMethodBeat.i(129816);
            ab.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", str, Integer.valueOf(i), Integer.valueOf(i2));
            d.c cVar = (d.c) b.this.hew.get(str);
            if (cVar != null) {
                cVar.cT(i, i2);
            }
            AppMethodBeat.o(129816);
        }

        public final void a(String str, int i, d dVar) {
            AppMethodBeat.i(129817);
            ab.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", str, Integer.valueOf(i));
            d.c cVar = (d.c) b.this.hew.get(str);
            if (cVar != null) {
                cVar.ad(str, i);
            }
            AppMethodBeat.o(129817);
        }
    };

    public b() {
        AppMethodBeat.i(129818);
        AppMethodBeat.o(129818);
    }

    public final void a(com.tencent.mm.plugin.appbrand.c.d.b bVar) {
        AppMethodBeat.i(129819);
        if (!(this.heu == null || bVar == null)) {
            this.heu.remove(bVar);
        }
        AppMethodBeat.o(129819);
    }

    public final void a(d.a aVar) {
        AppMethodBeat.i(129820);
        if (!(this.hev == null || aVar == null)) {
            this.hev.remove(aVar);
        }
        AppMethodBeat.o(129820);
    }

    public static boolean yC(String str) {
        AppMethodBeat.i(129821);
        a yE = f.auX().yE(str);
        if (yE == null) {
            ab.e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", str);
            AppMethodBeat.o(129821);
            return false;
        }
        boolean rN = com.tencent.mm.al.f.afx().rN(yE.cHr);
        AppMethodBeat.o(129821);
        return rN;
    }

    public final void yD(String str) {
        AppMethodBeat.i(129822);
        this.hew.remove(str);
        AppMethodBeat.o(129822);
    }

    static /* synthetic */ void a(b bVar, boolean z, String str, String str2, String str3) {
        AppMethodBeat.i(129823);
        if (bVar.heu != null && bVar.heu.size() > 0) {
            Iterator it = bVar.heu.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.appbrand.c.d.b) it.next()).b(z, str, str2, str3);
            }
        }
        AppMethodBeat.o(129823);
    }
}
