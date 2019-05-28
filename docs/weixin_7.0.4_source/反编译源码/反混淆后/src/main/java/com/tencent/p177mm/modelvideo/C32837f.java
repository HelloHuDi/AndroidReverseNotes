package com.tencent.p177mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1828b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37921n;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.p187al.C31259b;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p187al.C8941a;
import com.tencent.p177mm.p230g.p232b.p233a.C18456x;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C42130g.C1629b;
import com.tencent.p177mm.p235i.C44686h;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.video.C14013c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import java.io.ByteArrayOutputStream;
import java.util.Map;

/* renamed from: com.tencent.mm.modelvideo.f */
public final class C32837f {
    private String cHr;
    long cvx;
    public String cwT;
    String egB;
    private C1629b egz = new C328392();
    private C1628a fFk = new C328381();
    int fVA;
    private String fVB;
    public C18706a fVC;
    private C44686h fVk;
    boolean fVv = false;
    String fVw;
    private long fVx;
    long fVy;
    long fVz;

    /* renamed from: com.tencent.mm.modelvideo.f$a */
    public interface C18706a {
        /* renamed from: a */
        void mo33970a(C32837f c32837f, boolean z, int i, int i2);
    }

    /* renamed from: com.tencent.mm.modelvideo.f$1 */
    class C328381 implements C1628a {
        C328381() {
        }

        /* renamed from: a */
        public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
            AppMethodBeat.m2504i(50682);
            if (i != 0) {
                C4990ab.m7421w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", Integer.valueOf(C32837f.this.hashCode()), Integer.valueOf(i));
                if (C32837f.this.fVC != null) {
                    C32837f.this.fVC.mo33970a(C32837f.this, false, 0, 0);
                }
            }
            if (c18496c != null) {
                C4990ab.m7411d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", Integer.valueOf(C32837f.this.hashCode()), Integer.valueOf(c18496c.field_finishedLength), Integer.valueOf(c18496c.field_toltalLength), str);
            }
            if (c9545d != null) {
                C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", Integer.valueOf(C32837f.this.hashCode()), Integer.valueOf(c9545d.field_retCode));
                if (c9545d.field_retCode == 0) {
                    C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", Integer.valueOf(C32837f.this.hashCode()));
                    C32837f.this.mo53408f(C32837f.this.fVw, c9545d.field_fileLength, C32837f.this.egB);
                } else if (C32837f.this.fVC != null) {
                    C32837f.this.fVC.mo33970a(C32837f.this, false, 0, 0);
                }
            }
            AppMethodBeat.m2505o(50682);
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

    /* renamed from: com.tencent.mm.modelvideo.f$2 */
    class C328392 implements C1629b {
        C328392() {
        }

        /* renamed from: a */
        public final void mo5085a(String str, C9545d c9545d) {
            AppMethodBeat.m2504i(50683);
            if (c9545d == null) {
                C4990ab.m7421w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", Integer.valueOf(C32837f.this.hashCode()));
                if (C32837f.this.fVC != null) {
                    C32837f.this.fVC.mo33970a(C32837f.this, false, 0, 0);
                }
                AppMethodBeat.m2505o(50683);
                return;
            }
            int i = c9545d.field_recvedBytes;
            int i2 = c9545d.field_fileLength;
            C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", Integer.valueOf(C32837f.this.hashCode()), str, C32837f.this.fVw, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(c9545d.field_videoFormat));
            if (i > 0 && i2 > 0) {
                C32837f.this.fVz = (long) C32837f.m53649e(C32837f.this.fVw, i, true);
            }
            if (C32837f.this.fVC != null) {
                C18706a c18706a = C32837f.this.fVC;
                C32837f c32837f = C32837f.this;
                boolean z = i > 0 && i2 > 0;
                c18706a.mo33970a(c32837f, z, i, i2);
            }
            C32837f.this.fVy = C5046bo.anT();
            C32837f.this.mo53410tV(c9545d.mo20810Jn());
            if (C32837f.this.fVv) {
                C7060h.pYm.mo8378a(354, 142, 1, false);
                if (C32837f.this.fVA == 1) {
                    C7060h.pYm.mo8378a(354, 123, 1, false);
                } else {
                    C7060h.pYm.mo8378a(354, 124, 1, false);
                }
                C7060h.pYm.mo8378a(354, (long) (c9545d.field_videoFormat + 240), 1, false);
                AppMethodBeat.m2505o(50683);
                return;
            }
            C7060h.pYm.mo8378a(354, 143, 1, false);
            AppMethodBeat.m2505o(50683);
        }
    }

    public C32837f(long j) {
        AppMethodBeat.m2504i(50684);
        this.cvx = j;
        this.fVv = true;
        AppMethodBeat.m2505o(50684);
    }

    public C32837f(C44686h c44686h, String str) {
        AppMethodBeat.m2504i(50685);
        this.fVk = c44686h;
        this.cwT = str;
        this.fVv = false;
        AppMethodBeat.m2505o(50685);
    }

    public final String alc() {
        AppMethodBeat.m2504i(50686);
        String str;
        if (this.fVv) {
            str = this.cvx;
            AppMethodBeat.m2505o(50686);
            return str;
        }
        str = this.cwT;
        AppMethodBeat.m2505o(50686);
        return str;
    }

    public final void stop() {
        AppMethodBeat.m2504i(50687);
        C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", Integer.valueOf(hashCode()), this.cHr);
        if (!C5046bo.isNullOrNil(this.cHr)) {
            C9545d c9545d = new C9545d();
            C31259b afx = C37461f.afx();
            String str = this.cHr;
            int i = 0;
            if (((C42130g) afx.fyM.remove(str)) != null) {
                C37461f.afy();
                i = C8941a.m16121b(str, c9545d);
                C7060h.pYm.mo8381e(10769, Integer.valueOf(C37458c.fzg), Integer.valueOf(r0.field_fileType), Long.valueOf(C5046bo.anU() - r0.field_startTime));
            }
            afx.fyL.remove(str);
            afx.fyN.remove(str);
            C4990ab.m7417i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(i));
            this.fVy = C5046bo.anT();
            this.fVz = (long) C32837f.m53649e(this.fVw, c9545d.field_recvedBytes, false);
            mo53410tV(c9545d.mo20810Jn());
        }
        this.fVC = null;
        AppMethodBeat.m2505o(50687);
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0295 A:{Catch:{ Exception -> 0x01d4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0229 A:{Catch:{ Exception -> 0x01d4 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final int mo53406a(C18706a c18706a) {
        AppMethodBeat.m2504i(50688);
        this.fVC = c18706a;
        try {
            String str;
            String str2;
            C44686h c44686h;
            Object obj;
            C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.cvx));
            C44686h c44686h2;
            if (this.fVv) {
                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.cvx);
                C1828b oE = C1829bf.m3758oE(jf.dqJ);
                if (oE == null || oE.fmG <= 0) {
                    C4990ab.m7421w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", Integer.valueOf(hashCode()));
                    c44686h2 = null;
                } else {
                    String str3 = jf.field_imgPath;
                    C26493s ut = C26494u.m42268ut(str3);
                    if (ut == null) {
                        c44686h2 = null;
                    } else {
                        Map z = C5049br.m7595z(ut.alw(), "msg");
                        if (z == null) {
                            C4990ab.m7420w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                            c44686h2 = null;
                        } else {
                            str = (String) z.get(".msg.videomsg.$cdnvideourl");
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7420w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                                c44686h2 = null;
                            } else {
                                int intValue = Integer.valueOf((String) z.get(".msg.videomsg.$length")).intValue();
                                String str4 = (String) z.get(".msg.videomsg.$md5");
                                str2 = (String) z.get(".msg.videomsg.$newmd5");
                                String str5 = (String) z.get(".msg.videomsg.$aeskey");
                                String str6 = (String) z.get(".msg.videomsg.$fileparam");
                                String a = C37458c.m63162a("downvideo", ut.createTime, ut.getUser(), ut.getFileName());
                                if (C5046bo.isNullOrNil(a)) {
                                    C4990ab.m7421w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", ut.getFileName());
                                    c44686h2 = null;
                                } else {
                                    C37961o.all();
                                    String uh = C9720t.m17303uh(str3);
                                    C44686h c44686h3 = new C44686h();
                                    c44686h3.filename = str3;
                                    c44686h3.egB = str4;
                                    c44686h3.egC = intValue;
                                    c44686h3.egD = 2;
                                    c44686h3.cEV = ut.alt();
                                    c44686h3.egE = ut.getUser();
                                    c44686h3.cEX = C1855t.m3896kH(ut.getUser()) ? C37921n.m64060mA(ut.getUser()) : 0;
                                    c44686h3.field_mediaId = a;
                                    c44686h3.field_fullpath = uh;
                                    c44686h3.field_fileType = C42129a.MediaType_VIDEO;
                                    c44686h3.field_totalLen = intValue;
                                    c44686h3.field_aesKey = str5;
                                    c44686h3.field_fileId = str;
                                    c44686h3.field_priority = C42129a.efC;
                                    c44686h3.field_wxmsgparam = str6;
                                    c44686h3.field_chattype = C1855t.m3896kH(ut.getUser()) ? 1 : 0;
                                    c44686h3.field_autostart = false;
                                    c44686h3.field_requestVideoFormat = C42204d.m74447a(2, ut);
                                    c44686h3.field_preloadRatio = oE.fmG;
                                    c44686h3.cdx = str2;
                                    c44686h2 = c44686h3;
                                }
                            }
                        }
                    }
                }
                if (c44686h2 != null) {
                    this.fVA = C1855t.m3896kH(c44686h2.egE) ? 2 : 1;
                    C7060h.pYm.mo8378a(354, 140, 1, false);
                    if (this.fVA == 1) {
                        C7060h.pYm.mo8378a(354, 121, 1, false);
                    } else {
                        C7060h.pYm.mo8378a(354, 122, 1, false);
                    }
                }
                if (this.fVk == null) {
                    this.fVk = c44686h2;
                    c44686h = c44686h2;
                } else {
                    c44686h = c44686h2;
                }
            } else {
                this.fVA = 3;
                c44686h2 = this.fVk;
                C7060h.pYm.mo8378a(354, 141, 1, false);
                c44686h = c44686h2;
            }
            if (c44686h == null) {
                C4990ab.m7421w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", Integer.valueOf(hashCode()));
                obj = null;
            } else {
                if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                    C4990ab.m7416i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
                } else if (!c44686h.mo67678Js()) {
                    str2 = c44686h.egB;
                    int i = c44686h.egC;
                    str = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT().mo16778es(str2, i);
                    int asZ = i - ((int) C5730e.asZ(str));
                    if (!C5046bo.isNullOrNil(str) && asZ >= 0 && asZ <= 16) {
                        C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", Integer.valueOf(i), str2, str);
                        C5730e.m8644y(str, c44686h.field_fullpath);
                        mo53408f(c44686h.filename, i, str2);
                        obj = 1;
                        if (obj == null) {
                            C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                            obj = null;
                        } else {
                            c44686h.egz = this.egz;
                            c44686h.egl = this.fFk;
                            c44686h.egx = 2;
                            this.egB = c44686h.egB;
                            this.cHr = c44686h.field_mediaId;
                            this.fVw = c44686h.filename;
                            this.fVx = C5046bo.anT();
                            this.fVB = c44686h.cdx;
                            C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), c44686h);
                            C37461f.afx().mo51222b(c44686h, -1);
                            obj = 1;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            if (obj != null) {
                AppMethodBeat.m2505o(50688);
                return 0;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", e, "", new Object[0]);
        }
        this.fVC = null;
        AppMethodBeat.m2505o(50688);
        return -1;
    }

    /* renamed from: e */
    static int m53649e(String str, int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.m2504i(50689);
        C26493s ut = C26494u.m42268ut(str);
        if (ut != null) {
            int i3 = ut.cFa;
            if (z) {
                ut.cFa = i;
            } else {
                ut.cFa = i3 + i;
            }
            C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(ut.cFa), Boolean.valueOf(z));
            ut.fXb = C5046bo.anT();
            ut.bJt = 1025;
            C26494u.m42253f(ut);
            int i4 = z ? i - i3 : i;
            if (i4 >= 0) {
                i2 = i4;
            }
            AppMethodBeat.m2505o(50689);
            return i2;
        }
        AppMethodBeat.m2505o(50689);
        return i;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final void mo53408f(String str, int i, String str2) {
        AppMethodBeat.m2504i(50690);
        C4990ab.m7417i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), str2);
        if (C26494u.m42268ut(str) != null) {
            C26494u.m42242ae(str, i);
            C32837f.m53650i(i, str2, str);
        }
        AppMethodBeat.m2505o(50690);
    }

    /* renamed from: i */
    private static boolean m53650i(int i, String str, String str2) {
        AppMethodBeat.m2504i(50691);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(50691);
            return false;
        }
        C37961o.all();
        String uh = C9720t.m17303uh(str2);
        if (C5046bo.isNullOrNil(str) || i <= 0 || C5046bo.isNullOrNil(uh) || !C5730e.m8628ct(uh)) {
            C4990ab.m7421w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str, uh);
            AppMethodBeat.m2505o(50691);
            return false;
        }
        boolean y = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT().mo16779y(str, i, uh);
        AppMethodBeat.m2505o(50691);
        return y;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: tV */
    public final void mo53410tV(String str) {
        int i;
        AppMethodBeat.m2504i(50692);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.fVx).append(",");
        stringBuffer.append(this.fVy).append(",");
        stringBuffer.append(this.fVz).append(",");
        stringBuffer.append(this.fVB).append(",");
        stringBuffer.append(this.fVA).append(",");
        try {
            i = (int) ((this.fVz / 1024) / (this.fVy - this.fVx));
        } catch (Exception e) {
            i = 0;
        }
        stringBuffer.append(i).append(",");
        stringBuffer.append(0).append(",");
        stringBuffer.append(str).append(",");
        stringBuffer.append(this.fVk.cEV).append(",");
        stringBuffer.append(this.fVk.egE).append(",");
        stringBuffer.append(this.fVk.cEX).append(",");
        stringBuffer.append(this.fVk.field_fileId).append(",");
        stringBuffer.append(this.fVk.url).append(",");
        stringBuffer.append(C14013c.abR(this.fVk.cFc));
        C4990ab.m7411d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        new C18456x(r0).ajK();
        AppMethodBeat.m2505o(50692);
    }
}
