package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static List<WeakReference<a>> kaD = new ArrayList();

    public interface a {
        void GS(String str);

        void bN(String str, int i);

        void dr(String str, String str2);
    }

    static {
        AppMethodBeat.i(88808);
        AppMethodBeat.o(88808);
    }

    public static void a(a aVar) {
        AppMethodBeat.i(88805);
        if (kaD == null) {
            kaD = new ArrayList();
        }
        if (aVar == null) {
            ab.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
            AppMethodBeat.o(88805);
            return;
        }
        ab.i("MicroMsg.CDNDownloadHelpper", "register:%d", Integer.valueOf(aVar.hashCode()));
        kaD.add(new WeakReference(aVar));
        AppMethodBeat.o(88805);
    }

    public static void b(a aVar) {
        int i = 0;
        AppMethodBeat.i(88806);
        if (kaD == null || aVar == null) {
            AppMethodBeat.o(88806);
            return;
        }
        ab.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", Integer.valueOf(aVar.hashCode()));
        while (true) {
            int i2 = i;
            if (i2 < kaD.size()) {
                WeakReference weakReference = (WeakReference) kaD.get(i2);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        kaD.remove(weakReference);
                        AppMethodBeat.o(88806);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(88806);
                return;
            }
        }
    }

    public static void g(final String str, String str2, int i, int i2) {
        int i3 = 0;
        AppMethodBeat.i(88807);
        if (str == null || str2 == null || i == 0) {
            ab.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
            AppMethodBeat.o(88807);
            return;
        }
        String str3;
        String str4;
        String ck = ag.ck(str);
        b bVar = new b(m.kdI);
        if (!bVar.mkdirs()) {
            ab.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + bVar.exists());
        }
        if (i2 == 2) {
            str3 = ".jpeg";
        } else {
            str3 = VideoMaterialUtil.MP4_SUFFIX;
        }
        if (j.w(bVar.dMD()).endsWith("/")) {
            str4 = j.w(bVar.dMD()) + ck + str3;
        } else {
            str4 = j.w(bVar.dMD()) + "/" + ck + str3;
        }
        ab.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", ck, str4);
        ab.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str4);
        ab.i("MicroMsg.CDNDownloadHelpper", "read file length = " + e.asZ(str4));
        WeakReference weakReference;
        a aVar;
        if (e.ct(str4) && e.asZ(str4) == ((long) i)) {
            while (i3 < kaD.size()) {
                weakReference = (WeakReference) kaD.get(i3);
                if (weakReference != null) {
                    aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.dr(str, str4);
                    }
                }
                i3++;
            }
            AppMethodBeat.o(88807);
            return;
        }
        ab.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", str4);
        g gVar = new g();
        gVar.egl = new com.tencent.mm.i.g.a() {
            public final int a(String str, int i, c cVar, d dVar, boolean z) {
                AppMethodBeat.i(88802);
                int i2;
                WeakReference weakReference;
                a aVar;
                if (i == -21005) {
                    ab.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", str);
                    AppMethodBeat.o(88802);
                } else if (i != 0) {
                    ab.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                    for (i2 = 0; i2 < a.kaD.size(); i2++) {
                        weakReference = (WeakReference) a.kaD.get(i2);
                        if (weakReference != null) {
                            aVar = (a) weakReference.get();
                            if (aVar != null) {
                                aVar.GS(str);
                            }
                        }
                    }
                    AppMethodBeat.o(88802);
                } else if (cVar != null) {
                    ab.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", cVar.toString());
                    if (cVar.field_toltalLength > 0) {
                        i2 = (cVar.field_finishedLength * 100) / cVar.field_toltalLength;
                    } else {
                        i2 = 0;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > 100) {
                        i2 = 100;
                    }
                    for (int i3 = 0; i3 < a.kaD.size(); i3++) {
                        weakReference = (WeakReference) a.kaD.get(i3);
                        if (weakReference != null) {
                            aVar = (a) weakReference.get();
                            if (aVar != null) {
                                aVar.bN(str, i2);
                            }
                        }
                    }
                    AppMethodBeat.o(88802);
                } else {
                    if (dVar != null) {
                        if (dVar.field_retCode != 0) {
                            ab.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", str, Integer.valueOf(dVar.field_retCode), dVar);
                            for (i2 = 0; i2 < a.kaD.size(); i2++) {
                                weakReference = (WeakReference) a.kaD.get(i2);
                                if (weakReference != null) {
                                    aVar = (a) weakReference.get();
                                    if (aVar != null) {
                                        aVar.GS(str);
                                    }
                                }
                            }
                        } else {
                            ab.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", dVar);
                            for (i2 = 0; i2 < a.kaD.size(); i2++) {
                                weakReference = (WeakReference) a.kaD.get(i2);
                                if (weakReference != null) {
                                    aVar = (a) weakReference.get();
                                    if (aVar != null) {
                                        aVar.dr(str, str4);
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(88802);
                }
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.i(88803);
                ab.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", str);
                AppMethodBeat.o(88803);
            }

            public final byte[] l(String str, byte[] bArr) {
                AppMethodBeat.i(88804);
                ab.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", str);
                AppMethodBeat.o(88804);
                return null;
            }
        };
        gVar.cRY = false;
        gVar.field_mediaId = com.tencent.mm.al.c.a("cardgiftfile", bo.anU(), str, str);
        gVar.field_fullpath = str4;
        gVar.field_totalLen = i;
        gVar.field_fileType = com.tencent.mm.i.a.efH;
        gVar.field_fileId = str;
        gVar.field_aesKey = str2;
        gVar.field_priority = com.tencent.mm.i.a.efC;
        gVar.field_needStorage = true;
        ab.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", Boolean.valueOf(f.afx().b(gVar, -1)), gVar.field_fileId);
        if (!f.afx().b(gVar, -1)) {
            while (i3 < kaD.size()) {
                weakReference = (WeakReference) kaD.get(i3);
                if (weakReference != null) {
                    aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.GS(str);
                    }
                }
                i3++;
            }
            ab.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
        }
        AppMethodBeat.o(88807);
    }
}
