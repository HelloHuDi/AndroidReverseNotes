package com.tencent.mm.bx;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.api.o;
import com.tencent.mm.at.e;
import com.tencent.mm.at.g;
import com.tencent.mm.at.l;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.protocal.protobuf.brw;
import com.tencent.mm.protocal.protobuf.bsb;
import com.tencent.mm.protocal.protobuf.bsl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements f, o {
    public static final a xuc = new a();
    public ConcurrentHashMap<String, bsb> xud = new ConcurrentHashMap();

    public a() {
        AppMethodBeat.i(116347);
        AppMethodBeat.o(116347);
    }

    static {
        AppMethodBeat.i(116352);
        AppMethodBeat.o(116352);
    }

    public final void recordVideo(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(116348);
        s ut = u.ut(str);
        if (ut == null || ut.fXe <= 0) {
            ab.w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", str);
            AppMethodBeat.o(116348);
            return;
        }
        Map z = br.z(ut.alw(), "msg");
        if (z == null) {
            ab.w("MicroMsg.MediaSecurityReport", "attrs == null! %s", str);
            AppMethodBeat.o(116348);
            return;
        }
        bsb bsb = new bsb();
        bsb.jCt = 2;
        bsb.wdK = str4;
        bsb.EmotionList = new LinkedList(bo.P(str3.split(",")));
        bsl bsl = new bsl();
        bsl.wTY = ut.cMW;
        bsl.wUA = "";
        bsl.wUE = (float) ut.fXd;
        com.tencent.mm.modelvideo.o.all();
        bsl.wUD = com.tencent.mm.at.f.sh(t.ui(str));
        bsl.wUB = (String) z.get(".msg.videomsg.$cdnvideourl");
        bsl.wUC = (String) z.get(".msg.videomsg.$aeskey");
        bsb.wUf = bsl;
        this.xud.put(str2, bsb);
        AppMethodBeat.o(116348);
    }

    public final void recordImage(String str, String str2, long j, String str3, String str4) {
        e eVar;
        AppMethodBeat.i(116349);
        if (j <= 0) {
            g ahl = com.tencent.mm.at.o.ahl();
            String sh = com.tencent.mm.at.f.sh(str);
            eVar = new e();
            Cursor a = ahl.a("ImgInfo2", null, "origImgMD5=?", new String[]{String.valueOf(sh)});
            if (a.moveToFirst()) {
                eVar.d(a);
            }
            a.close();
        } else {
            eVar = com.tencent.mm.at.o.ahl().b(Long.valueOf(j));
        }
        if (eVar.fDy > 0) {
            Map z = br.z(eVar.fDK, "msg");
            if (z == null) {
                ab.w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", str, Long.valueOf(j));
                AppMethodBeat.o(116349);
                return;
            }
            bsb bsb = new bsb();
            bsb.jCt = 1;
            bsb.wdK = str4;
            bsb.EmotionList = new LinkedList(bo.P(str3.split(",")));
            brw brw = new brw();
            brw.wTW = (String) z.get(".msg.img.$cdnmidimgurl");
            brw.wTX = (String) z.get(".msg.img.$aeskey");
            brw.wTY = "";
            bsb.wUe = brw;
            this.xud.put(str2, bsb);
            AppMethodBeat.o(116349);
            return;
        }
        ab.w("MicroMsg.MediaSecurityReport", "[recordImage] imgInfo is null! %s %s", str, Long.valueOf(j));
        AppMethodBeat.o(116349);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(116350);
        if (mVar.getType() == 110 || mVar.getType() == 149) {
            if (i == 0 && i2 == 0) {
                String str2;
                final bsb bsb;
                Map z;
                if (mVar instanceof l) {
                    l lVar = (l) mVar;
                    if (lVar != null && lVar.fFy) {
                        str2 = lVar.fFx;
                        bsb = (bsb) this.xud.remove(lVar.fFC);
                        if (!(str2 == null || bsb == null)) {
                            z = br.z(str2, "msg");
                            if (z == null) {
                                ab.w("MicroMsg.MediaSecurityReport", "attrs == null!");
                                AppMethodBeat.o(116350);
                                return;
                            }
                            brw brw = bsb.wUe;
                            brw.wip = (String) z.get(".msg.img.$cdnmidimgurl");
                            brw.AesKey = (String) z.get(".msg.img.$aeskey");
                            brw.wdO = "";
                            ab.i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", lVar.fFC);
                            new b(bsb).a(com.tencent.mm.kernel.g.Rg().ftA, new f() {
                                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                    AppMethodBeat.i(116345);
                                    mVar.ftk = true;
                                    if (i == 0 && i2 == 0) {
                                        ab.i("MicroMsg.MediaSecurityReport", "report successfully! %s", a.a(bsb));
                                        AppMethodBeat.o(116345);
                                        return;
                                    }
                                    ab.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", Integer.valueOf(i), Integer.valueOf(i2), a.a(bsb));
                                    AppMethodBeat.o(116345);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(116350);
                    return;
                } else if (mVar instanceof com.tencent.mm.modelvideo.g) {
                    com.tencent.mm.modelvideo.g gVar = (com.tencent.mm.modelvideo.g) mVar;
                    if (gVar != null) {
                        bsb = (bsb) this.xud.remove(gVar.fileName);
                        if (gVar.fVj == null) {
                            str2 = "";
                        } else {
                            str2 = gVar.fVj.alw();
                        }
                        if (!(str2 == null || bsb == null)) {
                            z = br.z(str2, "msg");
                            if (z == null) {
                                ab.w("MicroMsg.MediaSecurityReport", "attrs == null!");
                                AppMethodBeat.o(116350);
                                return;
                            }
                            bsl bsl = bsb.wUf;
                            bsl.AesKey = (String) z.get(".msg.videomsg.$aeskey");
                            bsl.wip = (String) z.get(".msg.videomsg.$cdnvideourll");
                            s sVar = gVar.fVj;
                            bsl.wdO = sVar.cMW;
                            bsl.wUv = "";
                            bsl.wUw = (float) sVar.fXd;
                            bsl.wUx = bsl.wip;
                            bsl.wUy = bsl.AesKey;
                            com.tencent.mm.modelvideo.o.all();
                            bsl.wUz = com.tencent.mm.at.f.sh(t.ui(sVar.getFileName()));
                            ab.i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", gVar.fileName);
                            new b(bsb).a(com.tencent.mm.kernel.g.Rg().ftA, new f() {
                                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                    AppMethodBeat.i(116346);
                                    mVar.ftk = true;
                                    if (i == 0 && i2 == 0) {
                                        ab.i("MicroMsg.MediaSecurityReport", "report successfully! %s", a.a(bsb));
                                        AppMethodBeat.o(116346);
                                        return;
                                    }
                                    ab.e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", Integer.valueOf(i), Integer.valueOf(i2), a.a(bsb));
                                    AppMethodBeat.o(116346);
                                }
                            });
                        }
                    }
                }
            }
            AppMethodBeat.o(116350);
            return;
        }
        AppMethodBeat.o(116350);
    }

    static /* synthetic */ String a(bsb bsb) {
        AppMethodBeat.i(116351);
        brw brw = bsb.wUe;
        String format = String.format("[image] %s,%s | %s,%s | %s %s", new Object[]{brw.wip, brw.AesKey, brw.wTW, brw.wTX, bsb.EmotionList, bsb.wdK});
        AppMethodBeat.o(116351);
        return format;
    }
}
