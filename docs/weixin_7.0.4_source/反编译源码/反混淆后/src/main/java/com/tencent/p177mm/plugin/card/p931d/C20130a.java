package com.tencent.p177mm.plugin.card.p931d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.card.model.C33770m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.card.d.a */
public final class C20130a {
    private static List<WeakReference<C20132a>> kaD = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.card.d.a$a */
    public interface C20132a {
        /* renamed from: GS */
        void mo23012GS(String str);

        /* renamed from: bN */
        void mo23013bN(String str, int i);

        /* renamed from: dr */
        void mo23014dr(String str, String str2);
    }

    static {
        AppMethodBeat.m2504i(88808);
        AppMethodBeat.m2505o(88808);
    }

    /* renamed from: a */
    public static void m31138a(C20132a c20132a) {
        AppMethodBeat.m2504i(88805);
        if (kaD == null) {
            kaD = new ArrayList();
        }
        if (c20132a == null) {
            C4990ab.m7412e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
            AppMethodBeat.m2505o(88805);
            return;
        }
        C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "register:%d", Integer.valueOf(c20132a.hashCode()));
        kaD.add(new WeakReference(c20132a));
        AppMethodBeat.m2505o(88805);
    }

    /* renamed from: b */
    public static void m31139b(C20132a c20132a) {
        int i = 0;
        AppMethodBeat.m2504i(88806);
        if (kaD == null || c20132a == null) {
            AppMethodBeat.m2505o(88806);
            return;
        }
        C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "unregister:%d", Integer.valueOf(c20132a.hashCode()));
        while (true) {
            int i2 = i;
            if (i2 < kaD.size()) {
                WeakReference weakReference = (WeakReference) kaD.get(i2);
                if (weakReference != null) {
                    C20132a c20132a2 = (C20132a) weakReference.get();
                    if (c20132a2 != null && c20132a2.equals(c20132a)) {
                        kaD.remove(weakReference);
                        AppMethodBeat.m2505o(88806);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(88806);
                return;
            }
        }
    }

    /* renamed from: g */
    public static void m31140g(final String str, String str2, int i, int i2) {
        int i3 = 0;
        AppMethodBeat.m2504i(88807);
        if (str == null || str2 == null || i == 0) {
            C4990ab.m7412e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
            AppMethodBeat.m2505o(88807);
            return;
        }
        String str3;
        String str4;
        String ck = C4995ag.m7428ck(str);
        C5728b c5728b = new C5728b(C33770m.kdI);
        if (!c5728b.mkdirs()) {
            C4990ab.m7416i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + c5728b.exists());
        }
        if (i2 == 2) {
            str3 = ".jpeg";
        } else {
            str3 = VideoMaterialUtil.MP4_SUFFIX;
        }
        if (C5736j.m8649w(c5728b.dMD()).endsWith("/")) {
            str4 = C5736j.m8649w(c5728b.dMD()) + ck + str3;
        } else {
            str4 = C5736j.m8649w(c5728b.dMD()) + "/" + ck + str3;
        }
        C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", ck, str4);
        C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str4);
        C4990ab.m7416i("MicroMsg.CDNDownloadHelpper", "read file length = " + C5730e.asZ(str4));
        WeakReference weakReference;
        C20132a c20132a;
        if (C5730e.m8628ct(str4) && C5730e.asZ(str4) == ((long) i)) {
            while (i3 < kaD.size()) {
                weakReference = (WeakReference) kaD.get(i3);
                if (weakReference != null) {
                    c20132a = (C20132a) weakReference.get();
                    if (c20132a != null) {
                        c20132a.mo23014dr(str, str4);
                    }
                }
                i3++;
            }
            AppMethodBeat.m2505o(88807);
            return;
        }
        C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", str4);
        C42130g c42130g = new C42130g();
        c42130g.egl = new C1628a() {
            /* renamed from: a */
            public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                AppMethodBeat.m2504i(88802);
                int i2;
                WeakReference weakReference;
                C20132a c20132a;
                if (i == -21005) {
                    C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", str);
                    AppMethodBeat.m2505o(88802);
                } else if (i != 0) {
                    C4990ab.m7413e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                    for (i2 = 0; i2 < C20130a.kaD.size(); i2++) {
                        weakReference = (WeakReference) C20130a.kaD.get(i2);
                        if (weakReference != null) {
                            c20132a = (C20132a) weakReference.get();
                            if (c20132a != null) {
                                c20132a.mo23012GS(str);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(88802);
                } else if (c18496c != null) {
                    C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", c18496c.toString());
                    if (c18496c.field_toltalLength > 0) {
                        i2 = (c18496c.field_finishedLength * 100) / c18496c.field_toltalLength;
                    } else {
                        i2 = 0;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > 100) {
                        i2 = 100;
                    }
                    for (int i3 = 0; i3 < C20130a.kaD.size(); i3++) {
                        weakReference = (WeakReference) C20130a.kaD.get(i3);
                        if (weakReference != null) {
                            c20132a = (C20132a) weakReference.get();
                            if (c20132a != null) {
                                c20132a.mo23013bN(str, i2);
                            }
                        }
                    }
                    AppMethodBeat.m2505o(88802);
                } else {
                    if (c9545d != null) {
                        if (c9545d.field_retCode != 0) {
                            C4990ab.m7413e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", str, Integer.valueOf(c9545d.field_retCode), c9545d);
                            for (i2 = 0; i2 < C20130a.kaD.size(); i2++) {
                                weakReference = (WeakReference) C20130a.kaD.get(i2);
                                if (weakReference != null) {
                                    c20132a = (C20132a) weakReference.get();
                                    if (c20132a != null) {
                                        c20132a.mo23012GS(str);
                                    }
                                }
                            }
                        } else {
                            C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", c9545d);
                            for (i2 = 0; i2 < C20130a.kaD.size(); i2++) {
                                weakReference = (WeakReference) C20130a.kaD.get(i2);
                                if (weakReference != null) {
                                    c20132a = (C20132a) weakReference.get();
                                    if (c20132a != null) {
                                        c20132a.mo23014dr(str, str4);
                                    }
                                }
                            }
                        }
                    }
                    AppMethodBeat.m2505o(88802);
                }
                return 0;
            }

            /* renamed from: a */
            public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                AppMethodBeat.m2504i(88803);
                C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", str);
                AppMethodBeat.m2505o(88803);
            }

            /* renamed from: l */
            public final byte[] mo5084l(String str, byte[] bArr) {
                AppMethodBeat.m2504i(88804);
                C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", str);
                AppMethodBeat.m2505o(88804);
                return null;
            }
        };
        c42130g.cRY = false;
        c42130g.field_mediaId = C37458c.m63162a("cardgiftfile", C5046bo.anU(), str, str);
        c42130g.field_fullpath = str4;
        c42130g.field_totalLen = i;
        c42130g.field_fileType = C42129a.efH;
        c42130g.field_fileId = str;
        c42130g.field_aesKey = str2;
        c42130g.field_priority = C42129a.efC;
        c42130g.field_needStorage = true;
        C4990ab.m7417i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", Boolean.valueOf(C37461f.afx().mo51222b(c42130g, -1)), c42130g.field_fileId);
        if (!C37461f.afx().mo51222b(c42130g, -1)) {
            while (i3 < kaD.size()) {
                weakReference = (WeakReference) kaD.get(i3);
                if (weakReference != null) {
                    c20132a = (C20132a) weakReference.get();
                    if (c20132a != null) {
                        c20132a.mo23012GS(str);
                    }
                }
                i3++;
            }
            C4990ab.m7412e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
        }
        AppMethodBeat.m2505o(88807);
    }
}
