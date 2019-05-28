package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.x;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.i.g.b;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.n;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class f {
    private String cHr;
    long cvx;
    public String cwT;
    String egB;
    private b egz = new b() {
        public final void a(String str, d dVar) {
            AppMethodBeat.i(50683);
            if (dVar == null) {
                ab.w("MicroMsg.NetScenePreloadVideoFake", "%s onPreload completed but sceneResult is null", Integer.valueOf(f.this.hashCode()));
                if (f.this.fVC != null) {
                    f.this.fVC.a(f.this, false, 0, 0);
                }
                AppMethodBeat.o(50683);
                return;
            }
            int i = dVar.field_recvedBytes;
            int i2 = dVar.field_fileLength;
            ab.i("MicroMsg.NetScenePreloadVideoFake", "%d onPreload Completed [%s] videoInfoName[%s] [%d, %d] videoFormat[%d]", Integer.valueOf(f.this.hashCode()), str, f.this.fVw, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(dVar.field_videoFormat));
            if (i > 0 && i2 > 0) {
                f.this.fVz = (long) f.e(f.this.fVw, i, true);
            }
            if (f.this.fVC != null) {
                a aVar = f.this.fVC;
                f fVar = f.this;
                boolean z = i > 0 && i2 > 0;
                aVar.a(fVar, z, i, i2);
            }
            f.this.fVy = bo.anT();
            f.this.tV(dVar.Jn());
            if (f.this.fVv) {
                h.pYm.a(354, 142, 1, false);
                if (f.this.fVA == 1) {
                    h.pYm.a(354, 123, 1, false);
                } else {
                    h.pYm.a(354, 124, 1, false);
                }
                h.pYm.a(354, (long) (dVar.field_videoFormat + 240), 1, false);
                AppMethodBeat.o(50683);
                return;
            }
            h.pYm.a(354, 143, 1, false);
            AppMethodBeat.o(50683);
        }
    };
    private com.tencent.mm.i.g.a fFk = new com.tencent.mm.i.g.a() {
        public final int a(String str, int i, c cVar, d dVar, boolean z) {
            AppMethodBeat.i(50682);
            if (i != 0) {
                ab.w("MicroMsg.NetScenePreloadVideoFake", "%d preload video error startRet[%d]", Integer.valueOf(f.this.hashCode()), Integer.valueOf(i));
                if (f.this.fVC != null) {
                    f.this.fVC.a(f.this, false, 0, 0);
                }
            }
            if (cVar != null) {
                ab.d("MicroMsg.NetScenePreloadVideoFake", "%d preload video[%d %d] mediaId[%s]", Integer.valueOf(f.this.hashCode()), Integer.valueOf(cVar.field_finishedLength), Integer.valueOf(cVar.field_toltalLength), str);
            }
            if (dVar != null) {
                ab.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video error [%d]", Integer.valueOf(f.this.hashCode()), Integer.valueOf(dVar.field_retCode));
                if (dVar.field_retCode == 0) {
                    ab.i("MicroMsg.NetScenePreloadVideoFake", "%d preload video download all video file", Integer.valueOf(f.this.hashCode()));
                    f.this.f(f.this.fVw, dVar.field_fileLength, f.this.egB);
                } else if (f.this.fVC != null) {
                    f.this.fVC.a(f.this, false, 0, 0);
                }
            }
            AppMethodBeat.o(50682);
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] l(String str, byte[] bArr) {
            return new byte[0];
        }
    };
    int fVA;
    private String fVB;
    public a fVC;
    private com.tencent.mm.i.h fVk;
    boolean fVv = false;
    String fVw;
    private long fVx;
    long fVy;
    long fVz;

    public interface a {
        void a(f fVar, boolean z, int i, int i2);
    }

    public f(long j) {
        AppMethodBeat.i(50684);
        this.cvx = j;
        this.fVv = true;
        AppMethodBeat.o(50684);
    }

    public f(com.tencent.mm.i.h hVar, String str) {
        AppMethodBeat.i(50685);
        this.fVk = hVar;
        this.cwT = str;
        this.fVv = false;
        AppMethodBeat.o(50685);
    }

    public final String alc() {
        AppMethodBeat.i(50686);
        String str;
        if (this.fVv) {
            str = this.cvx;
            AppMethodBeat.o(50686);
            return str;
        }
        str = this.cwT;
        AppMethodBeat.o(50686);
        return str;
    }

    public final void stop() {
        AppMethodBeat.i(50687);
        ab.i("MicroMsg.NetScenePreloadVideoFake", "%d stop preload video[%s]", Integer.valueOf(hashCode()), this.cHr);
        if (!bo.isNullOrNil(this.cHr)) {
            d dVar = new d();
            com.tencent.mm.al.b afx = com.tencent.mm.al.f.afx();
            String str = this.cHr;
            int i = 0;
            if (((g) afx.fyM.remove(str)) != null) {
                com.tencent.mm.al.f.afy();
                i = com.tencent.mm.al.a.b(str, dVar);
                h.pYm.e(10769, Integer.valueOf(com.tencent.mm.al.c.fzg), Integer.valueOf(r0.field_fileType), Long.valueOf(bo.anU() - r0.field_startTime));
            }
            afx.fyL.remove(str);
            afx.fyN.remove(str);
            ab.i("MicroMsg.CdnTransportService", "summersafecdn cdntra cancelRecvTask mediaid:%s mapremove:%s engine ret:%d", str, r0, Integer.valueOf(i));
            this.fVy = bo.anT();
            this.fVz = (long) e(this.fVw, dVar.field_recvedBytes, false);
            tV(dVar.Jn());
        }
        this.fVC = null;
        AppMethodBeat.o(50687);
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0295 A:{Catch:{ Exception -> 0x01d4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0229 A:{Catch:{ Exception -> 0x01d4 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(a aVar) {
        AppMethodBeat.i(50688);
        this.fVC = aVar;
        try {
            String str;
            String str2;
            com.tencent.mm.i.h hVar;
            Object obj;
            ab.i("MicroMsg.NetScenePreloadVideoFake", "%d preload begin msgId[%d]", Integer.valueOf(hashCode()), Long.valueOf(this.cvx));
            com.tencent.mm.i.h hVar2;
            if (this.fVv) {
                bi jf = ((j) com.tencent.mm.kernel.g.K(j.class)).bOr().jf(this.cvx);
                bf.b oE = bf.oE(jf.dqJ);
                if (oE == null || oE.fmG <= 0) {
                    ab.w("MicroMsg.NetScenePreloadVideoFake", "%d msgsource is null", Integer.valueOf(hashCode()));
                    hVar2 = null;
                } else {
                    String str3 = jf.field_imgPath;
                    s ut = u.ut(str3);
                    if (ut == null) {
                        hVar2 = null;
                    } else {
                        Map z = br.z(ut.alw(), "msg");
                        if (z == null) {
                            ab.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                            hVar2 = null;
                        } else {
                            str = (String) z.get(".msg.videomsg.$cdnvideourl");
                            if (bo.isNullOrNil(str)) {
                                ab.w("MicroMsg.NetScenePreloadVideoFake", "cdntra parse video recv xml failed");
                                hVar2 = null;
                            } else {
                                int intValue = Integer.valueOf((String) z.get(".msg.videomsg.$length")).intValue();
                                String str4 = (String) z.get(".msg.videomsg.$md5");
                                str2 = (String) z.get(".msg.videomsg.$newmd5");
                                String str5 = (String) z.get(".msg.videomsg.$aeskey");
                                String str6 = (String) z.get(".msg.videomsg.$fileparam");
                                String a = com.tencent.mm.al.c.a("downvideo", ut.createTime, ut.getUser(), ut.getFileName());
                                if (bo.isNullOrNil(a)) {
                                    ab.w("MicroMsg.NetScenePreloadVideoFake", "cdntra genClientId failed not use cdn file:%s", ut.getFileName());
                                    hVar2 = null;
                                } else {
                                    o.all();
                                    String uh = t.uh(str3);
                                    com.tencent.mm.i.h hVar3 = new com.tencent.mm.i.h();
                                    hVar3.filename = str3;
                                    hVar3.egB = str4;
                                    hVar3.egC = intValue;
                                    hVar3.egD = 2;
                                    hVar3.cEV = ut.alt();
                                    hVar3.egE = ut.getUser();
                                    hVar3.cEX = t.kH(ut.getUser()) ? n.mA(ut.getUser()) : 0;
                                    hVar3.field_mediaId = a;
                                    hVar3.field_fullpath = uh;
                                    hVar3.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
                                    hVar3.field_totalLen = intValue;
                                    hVar3.field_aesKey = str5;
                                    hVar3.field_fileId = str;
                                    hVar3.field_priority = com.tencent.mm.i.a.efC;
                                    hVar3.field_wxmsgparam = str6;
                                    hVar3.field_chattype = t.kH(ut.getUser()) ? 1 : 0;
                                    hVar3.field_autostart = false;
                                    hVar3.field_requestVideoFormat = com.tencent.mm.modelcontrol.d.a(2, ut);
                                    hVar3.field_preloadRatio = oE.fmG;
                                    hVar3.cdx = str2;
                                    hVar2 = hVar3;
                                }
                            }
                        }
                    }
                }
                if (hVar2 != null) {
                    this.fVA = t.kH(hVar2.egE) ? 2 : 1;
                    h.pYm.a(354, 140, 1, false);
                    if (this.fVA == 1) {
                        h.pYm.a(354, 121, 1, false);
                    } else {
                        h.pYm.a(354, 122, 1, false);
                    }
                }
                if (this.fVk == null) {
                    this.fVk = hVar2;
                    hVar = hVar2;
                } else {
                    hVar = hVar2;
                }
            } else {
                this.fVA = 3;
                hVar2 = this.fVk;
                h.pYm.a(354, 141, 1, false);
                hVar = hVar2;
            }
            if (hVar == null) {
                ab.w("MicroMsg.NetScenePreloadVideoFake", "%d preload task is null", Integer.valueOf(hashCode()));
                obj = null;
            } else {
                if (((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(-1))).intValue() == 2) {
                    ab.i("MicroMsg.NetScenePreloadVideoFake", "command set do not check media duplication.");
                } else if (!hVar.Js()) {
                    str2 = hVar.egB;
                    int i = hVar.egC;
                    str = ((com.tencent.mm.plugin.m.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.m.a.a.class)).XT().es(str2, i);
                    int asZ = i - ((int) e.asZ(str));
                    if (!bo.isNullOrNil(str) && asZ >= 0 && asZ <= 16) {
                        ab.i("MicroMsg.NetScenePreloadVideoFake", "it had download this video[%d, %s, %s].", Integer.valueOf(i), str2, str);
                        e.y(str, hVar.field_fullpath);
                        f(hVar.filename, i, str2);
                        obj = 1;
                        if (obj == null) {
                            ab.i("MicroMsg.NetScenePreloadVideoFake", "%d it already had video file", Integer.valueOf(hashCode()));
                            obj = null;
                        } else {
                            hVar.egz = this.egz;
                            hVar.egl = this.fFk;
                            hVar.egx = 2;
                            this.egB = hVar.egB;
                            this.cHr = hVar.field_mediaId;
                            this.fVw = hVar.filename;
                            this.fVx = bo.anT();
                            this.fVB = hVar.cdx;
                            ab.i("MicroMsg.NetScenePreloadVideoFake", "%d send to cdn service task[%s]", Integer.valueOf(hashCode()), hVar);
                            com.tencent.mm.al.f.afx().b(hVar, -1);
                            obj = 1;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                }
            }
            if (obj != null) {
                AppMethodBeat.o(50688);
                return 0;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetScenePreloadVideoFake", e, "", new Object[0]);
        }
        this.fVC = null;
        AppMethodBeat.o(50688);
        return -1;
    }

    static int e(String str, int i, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(50689);
        s ut = u.ut(str);
        if (ut != null) {
            int i3 = ut.cFa;
            if (z) {
                ut.cFa = i;
            } else {
                ut.cFa = i3 + i;
            }
            ab.i("MicroMsg.NetScenePreloadVideoFake", "update video info[%s] preload[%d %d %d] isFinish[%b] ", str, Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(ut.cFa), Boolean.valueOf(z));
            ut.fXb = bo.anT();
            ut.bJt = 1025;
            u.f(ut);
            int i4 = z ? i - i3 : i;
            if (i4 >= 0) {
                i2 = i4;
            }
            AppMethodBeat.o(50689);
            return i2;
        }
        AppMethodBeat.o(50689);
        return i;
    }

    /* Access modifiers changed, original: final */
    public final void f(String str, int i, String str2) {
        AppMethodBeat.i(50690);
        ab.i("MicroMsg.NetScenePreloadVideoFake", "%d update finish video [%s] [%d] [%s]", Integer.valueOf(hashCode()), str, Integer.valueOf(i), str2);
        if (u.ut(str) != null) {
            u.ae(str, i);
            i(i, str2, str);
        }
        AppMethodBeat.o(50690);
    }

    private static boolean i(int i, String str, String str2) {
        AppMethodBeat.i(50691);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(50691);
            return false;
        }
        o.all();
        String uh = t.uh(str2);
        if (bo.isNullOrNil(str) || i <= 0 || bo.isNullOrNil(uh) || !e.ct(uh)) {
            ab.w("MicroMsg.NetScenePreloadVideoFake", "insert media duplication but args is error.[%d, %s, %s]", Integer.valueOf(i), str, uh);
            AppMethodBeat.o(50691);
            return false;
        }
        boolean y = ((com.tencent.mm.plugin.m.a.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.m.a.a.class)).XT().y(str, i, uh);
        AppMethodBeat.o(50691);
        return y;
    }

    /* Access modifiers changed, original: final */
    public final void tV(String str) {
        int i;
        AppMethodBeat.i(50692);
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
        stringBuffer.append(com.tencent.mm.plugin.video.c.abR(this.fVk.cFc));
        ab.d("MicroMsg.NetScenePreloadVideoFake", "%d rpt content[%s]", Integer.valueOf(hashCode()), stringBuffer.toString());
        new x(r0).ajK();
        AppMethodBeat.o(50692);
    }
}
