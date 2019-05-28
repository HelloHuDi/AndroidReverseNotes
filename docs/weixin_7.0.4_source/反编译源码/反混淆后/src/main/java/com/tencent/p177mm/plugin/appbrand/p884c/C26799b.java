package com.tencent.p177mm.plugin.appbrand.p884c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C44686h.C26326a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.p884c.C19127a.C10147a;
import com.tencent.p177mm.plugin.appbrand.p884c.C19129d.C19130b;
import com.tencent.p177mm.plugin.appbrand.p884c.C19129d.C19131c;
import com.tencent.p177mm.plugin.appbrand.p884c.C19129d.C19132a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.appbrand.c.b */
public final class C26799b {
    public C1628a fFk = new C268011();
    public Vector<C19130b> heu = new Vector();
    public Vector<C19132a> hev = new Vector();
    public HashMap<String, C19131c> hew = new HashMap();
    public C26326a hex = new C268002();

    /* renamed from: com.tencent.mm.plugin.appbrand.c.b$2 */
    class C268002 implements C26326a {
        C268002() {
        }

        public final void onMoovReady(String str, int i, int i2) {
            AppMethodBeat.m2504i(129814);
            C4990ab.m7417i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", str, Integer.valueOf(i), Integer.valueOf(i2));
            C19131c c19131c = (C19131c) C26799b.this.hew.get(str);
            if (c19131c != null) {
                c19131c.mo34343cR(i, i2);
            }
            AppMethodBeat.m2505o(129814);
        }

        public final void onDataAvailable(String str, int i, int i2) {
            AppMethodBeat.m2504i(129815);
            C4990ab.m7417i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", str, Integer.valueOf(i), Integer.valueOf(i2));
            C19131c c19131c = (C19131c) C26799b.this.hew.get(str);
            if (c19131c != null) {
                c19131c.mo34344cS(i, i2);
            }
            AppMethodBeat.m2505o(129815);
        }

        /* renamed from: h */
        public final void mo8706h(String str, int i, int i2) {
            AppMethodBeat.m2504i(129816);
            C4990ab.m7417i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", str, Integer.valueOf(i), Integer.valueOf(i2));
            C19131c c19131c = (C19131c) C26799b.this.hew.get(str);
            if (c19131c != null) {
                c19131c.mo34345cT(i, i2);
            }
            AppMethodBeat.m2505o(129816);
        }

        /* renamed from: a */
        public final void mo8705a(String str, int i, C9545d c9545d) {
            AppMethodBeat.m2504i(129817);
            C4990ab.m7417i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", str, Integer.valueOf(i));
            C19131c c19131c = (C19131c) C26799b.this.hew.get(str);
            if (c19131c != null) {
                c19131c.mo34342ad(str, i);
            }
            AppMethodBeat.m2505o(129817);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.c.b$1 */
    class C268011 implements C1628a {
        C268011() {
        }

        /* renamed from: a */
        public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            AppMethodBeat.m2504i(129811);
            C4990ab.m7417i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", str);
            AppMethodBeat.m2505o(129811);
        }

        /* renamed from: l */
        public final byte[] mo5084l(String str, byte[] bArr) {
            AppMethodBeat.m2504i(129812);
            C4990ab.m7417i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", str);
            AppMethodBeat.m2505o(129812);
            return null;
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            String str2;
            C19127a c19127a;
            AppMethodBeat.m2504i(129813);
            String str3 = "MicroMsg.AppbrandCdnService";
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
            C19128c auX = C42340f.auX();
            if (!C5046bo.isNullOrNil(str)) {
                for (C19127a c19127a2 : auX.hez.values()) {
                    if (C5046bo.nullAsNil(c19127a2.cHr).equals(str)) {
                        c19127a = c19127a2;
                        break;
                    }
                }
            }
            C4990ab.m7412e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByMediaID error, media id is null or nil");
            c19127a = null;
            if (c19127a == null) {
                C4990ab.m7413e("MicroMsg.AppbrandCdnService", "get item by media id failed, media is : %s", str);
                AppMethodBeat.m2505o(129813);
                return 0;
            } else if (i == -21005) {
                C4990ab.m7417i("MicroMsg.AppbrandCdnService", "duplicate request, ignore this request, media id is %s", str);
                AppMethodBeat.m2505o(129813);
                return 0;
            } else if (i != 0) {
                C4990ab.m7413e("MicroMsg.AppbrandCdnService", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                C26799b.m42654a(C26799b.this, false, c19127a.czD, c19127a.cHr, null);
                AppMethodBeat.m2505o(129813);
                return 0;
            } else if (c18496c != null) {
                int i2;
                C4990ab.m7417i("MicroMsg.AppbrandCdnService", "progressInfo : %s", c18496c.toString());
                int i3 = 0;
                if (c18496c.field_toltalLength > 0) {
                    i3 = (c18496c.field_finishedLength * 100) / c18496c.field_toltalLength;
                }
                if (i3 < 0) {
                    i2 = 0;
                } else if (i3 > 100) {
                    i2 = 100;
                } else {
                    i2 = i3;
                }
                C26799b c26799b = C26799b.this;
                boolean z2 = c19127a.her;
                int i4 = c19127a.cyQ;
                String str5 = c19127a.czD;
                str4 = c19127a.cHr;
                C4990ab.m7417i("MicroMsg.AppbrandCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i2), str5, str4);
                if (c26799b.hev != null && c26799b.hev.size() > 0) {
                    Iterator it = c26799b.hev.iterator();
                    while (it.hasNext()) {
                        ((C19132a) it.next()).mo34346J(i2, str5);
                    }
                }
                AppMethodBeat.m2505o(129813);
                return 0;
            } else {
                if (c9545d != null) {
                    if (c9545d.field_retCode != 0) {
                        C4990ab.m7413e("MicroMsg.AppbrandCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(c9545d.field_retCode), c9545d);
                        C26799b.m42654a(C26799b.this, false, c19127a.czD, c19127a.cHr, null);
                    } else {
                        C4990ab.m7417i("MicroMsg.AppbrandCdnService", "cdn trans suceess, media id : %s", str);
                        if (c19127a != null) {
                            if (c19127a.heq == null) {
                                c19127a.heq = new C10147a();
                            }
                            if (c9545d == null) {
                                C4990ab.m7412e("MicroMsg.AppBrandMediaCdnItem", "sceneResult info is null");
                            } else {
                                c19127a.heq.field_aesKey = c9545d.field_aesKey;
                                c19127a.heq.field_fileId = c9545d.field_fileId;
                                c19127a.heq.field_fileUrl = c9545d.field_fileUrl;
                                c19127a.heq.field_fileLength = c9545d.field_fileLength;
                                c19127a.hep = c19127a.heq.field_fileId;
                            }
                            C42340f.auX().mo34339a(c19127a);
                            C26799b.m42654a(C26799b.this, true, c19127a.czD, c19127a.hep, c19127a.heq.field_fileUrl);
                        }
                    }
                }
                AppMethodBeat.m2505o(129813);
                return 0;
            }
        }
    }

    public C26799b() {
        AppMethodBeat.m2504i(129818);
        AppMethodBeat.m2505o(129818);
    }

    /* renamed from: a */
    public final void mo44565a(C19130b c19130b) {
        AppMethodBeat.m2504i(129819);
        if (!(this.heu == null || c19130b == null)) {
            this.heu.remove(c19130b);
        }
        AppMethodBeat.m2505o(129819);
    }

    /* renamed from: a */
    public final void mo44564a(C19132a c19132a) {
        AppMethodBeat.m2504i(129820);
        if (!(this.hev == null || c19132a == null)) {
            this.hev.remove(c19132a);
        }
        AppMethodBeat.m2505o(129820);
    }

    /* renamed from: yC */
    public static boolean m42655yC(String str) {
        AppMethodBeat.m2504i(129821);
        C19127a yE = C42340f.auX().mo34340yE(str);
        if (yE == null) {
            C4990ab.m7413e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", str);
            AppMethodBeat.m2505o(129821);
            return false;
        }
        boolean rN = C37461f.afx().mo51227rN(yE.cHr);
        AppMethodBeat.m2505o(129821);
        return rN;
    }

    /* renamed from: yD */
    public final void mo44566yD(String str) {
        AppMethodBeat.m2504i(129822);
        this.hew.remove(str);
        AppMethodBeat.m2505o(129822);
    }

    /* renamed from: a */
    static /* synthetic */ void m42654a(C26799b c26799b, boolean z, String str, String str2, String str3) {
        AppMethodBeat.m2504i(129823);
        if (c26799b.heu != null && c26799b.heu.size() > 0) {
            Iterator it = c26799b.heu.iterator();
            while (it.hasNext()) {
                ((C19130b) it.next()).mo34341b(z, str, str2, str3);
            }
        }
        AppMethodBeat.m2505o(129823);
    }
}
