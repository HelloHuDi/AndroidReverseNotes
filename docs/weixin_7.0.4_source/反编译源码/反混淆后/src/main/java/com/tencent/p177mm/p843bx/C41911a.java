package com.tencent.p177mm.p843bx;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C45153o;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelvideo.C26493s;
import com.tencent.p177mm.modelvideo.C26494u;
import com.tencent.p177mm.modelvideo.C32842g;
import com.tencent.p177mm.modelvideo.C37961o;
import com.tencent.p177mm.modelvideo.C9720t;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C37478f;
import com.tencent.p177mm.p190at.C45160g;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.protocal.protobuf.brw;
import com.tencent.p177mm.protocal.protobuf.bsb;
import com.tencent.p177mm.protocal.protobuf.bsl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.bx.a */
public final class C41911a implements C1202f, C45153o {
    public static final C41911a xuc = new C41911a();
    public ConcurrentHashMap<String, bsb> xud = new ConcurrentHashMap();

    public C41911a() {
        AppMethodBeat.m2504i(116347);
        AppMethodBeat.m2505o(116347);
    }

    static {
        AppMethodBeat.m2504i(116352);
        AppMethodBeat.m2505o(116352);
    }

    public final void recordVideo(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(116348);
        C26493s ut = C26494u.m42268ut(str);
        if (ut == null || ut.fXe <= 0) {
            C4990ab.m7421w("MicroMsg.MediaSecurityReport", "[recordVideo] imgInfo is null! %s", str);
            AppMethodBeat.m2505o(116348);
            return;
        }
        Map z = C5049br.m7595z(ut.alw(), "msg");
        if (z == null) {
            C4990ab.m7421w("MicroMsg.MediaSecurityReport", "attrs == null! %s", str);
            AppMethodBeat.m2505o(116348);
            return;
        }
        bsb bsb = new bsb();
        bsb.jCt = 2;
        bsb.wdK = str4;
        bsb.EmotionList = new LinkedList(C5046bo.m7508P(str3.split(",")));
        bsl bsl = new bsl();
        bsl.wTY = ut.cMW;
        bsl.wUA = "";
        bsl.wUE = (float) ut.fXd;
        C37961o.all();
        bsl.wUD = C37478f.m63230sh(C9720t.m17304ui(str));
        bsl.wUB = (String) z.get(".msg.videomsg.$cdnvideourl");
        bsl.wUC = (String) z.get(".msg.videomsg.$aeskey");
        bsb.wUf = bsl;
        this.xud.put(str2, bsb);
        AppMethodBeat.m2505o(116348);
    }

    public final void recordImage(String str, String str2, long j, String str3, String str4) {
        C25822e c25822e;
        AppMethodBeat.m2504i(116349);
        if (j <= 0) {
            C45160g ahl = C32291o.ahl();
            String sh = C37478f.m63230sh(str);
            c25822e = new C25822e();
            Cursor a = ahl.mo73083a("ImgInfo2", null, "origImgMD5=?", new String[]{String.valueOf(sh)});
            if (a.moveToFirst()) {
                c25822e.mo43791d(a);
            }
            a.close();
        } else {
            c25822e = C32291o.ahl().mo73105b(Long.valueOf(j));
        }
        if (c25822e.fDy > 0) {
            Map z = C5049br.m7595z(c25822e.fDK, "msg");
            if (z == null) {
                C4990ab.m7421w("MicroMsg.MediaSecurityReport", "attrs == null! %s %s", str, Long.valueOf(j));
                AppMethodBeat.m2505o(116349);
                return;
            }
            bsb bsb = new bsb();
            bsb.jCt = 1;
            bsb.wdK = str4;
            bsb.EmotionList = new LinkedList(C5046bo.m7508P(str3.split(",")));
            brw brw = new brw();
            brw.wTW = (String) z.get(".msg.img.$cdnmidimgurl");
            brw.wTX = (String) z.get(".msg.img.$aeskey");
            brw.wTY = "";
            bsb.wUe = brw;
            this.xud.put(str2, bsb);
            AppMethodBeat.m2505o(116349);
            return;
        }
        C4990ab.m7421w("MicroMsg.MediaSecurityReport", "[recordImage] imgInfo is null! %s %s", str, Long.valueOf(j));
        AppMethodBeat.m2505o(116349);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(116350);
        if (c1207m.getType() == 110 || c1207m.getType() == 149) {
            if (i == 0 && i2 == 0) {
                String str2;
                final bsb bsb;
                Map z;
                if (c1207m instanceof C9022l) {
                    C9022l c9022l = (C9022l) c1207m;
                    if (c9022l != null && c9022l.fFy) {
                        str2 = c9022l.fFx;
                        bsb = (bsb) this.xud.remove(c9022l.fFC);
                        if (!(str2 == null || bsb == null)) {
                            z = C5049br.m7595z(str2, "msg");
                            if (z == null) {
                                C4990ab.m7420w("MicroMsg.MediaSecurityReport", "attrs == null!");
                                AppMethodBeat.m2505o(116350);
                                return;
                            }
                            brw brw = bsb.wUe;
                            brw.wip = (String) z.get(".msg.img.$cdnmidimgurl");
                            brw.AesKey = (String) z.get(".msg.img.$aeskey");
                            brw.wdO = "";
                            C4990ab.m7417i("MicroMsg.MediaSecurityReport", "report! OrigImgPath:%s", c9022l.fFC);
                            new C41912b(bsb).mo4456a(C1720g.m3540Rg().ftA, new C1202f() {
                                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                    AppMethodBeat.m2504i(116345);
                                    c1207m.ftk = true;
                                    if (i == 0 && i2 == 0) {
                                        C4990ab.m7417i("MicroMsg.MediaSecurityReport", "report successfully! %s", C41911a.m74010a(bsb));
                                        AppMethodBeat.m2505o(116345);
                                        return;
                                    }
                                    C4990ab.m7413e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", Integer.valueOf(i), Integer.valueOf(i2), C41911a.m74010a(bsb));
                                    AppMethodBeat.m2505o(116345);
                                }
                            });
                        }
                    }
                    AppMethodBeat.m2505o(116350);
                    return;
                } else if (c1207m instanceof C32842g) {
                    C32842g c32842g = (C32842g) c1207m;
                    if (c32842g != null) {
                        bsb = (bsb) this.xud.remove(c32842g.fileName);
                        if (c32842g.fVj == null) {
                            str2 = "";
                        } else {
                            str2 = c32842g.fVj.alw();
                        }
                        if (!(str2 == null || bsb == null)) {
                            z = C5049br.m7595z(str2, "msg");
                            if (z == null) {
                                C4990ab.m7420w("MicroMsg.MediaSecurityReport", "attrs == null!");
                                AppMethodBeat.m2505o(116350);
                                return;
                            }
                            bsl bsl = bsb.wUf;
                            bsl.AesKey = (String) z.get(".msg.videomsg.$aeskey");
                            bsl.wip = (String) z.get(".msg.videomsg.$cdnvideourll");
                            C26493s c26493s = c32842g.fVj;
                            bsl.wdO = c26493s.cMW;
                            bsl.wUv = "";
                            bsl.wUw = (float) c26493s.fXd;
                            bsl.wUx = bsl.wip;
                            bsl.wUy = bsl.AesKey;
                            C37961o.all();
                            bsl.wUz = C37478f.m63230sh(C9720t.m17304ui(c26493s.getFileName()));
                            C4990ab.m7417i("MicroMsg.MediaSecurityReport", "report! OrigVideoPath:%s", c32842g.fileName);
                            new C41912b(bsb).mo4456a(C1720g.m3540Rg().ftA, new C1202f() {
                                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                    AppMethodBeat.m2504i(116346);
                                    c1207m.ftk = true;
                                    if (i == 0 && i2 == 0) {
                                        C4990ab.m7417i("MicroMsg.MediaSecurityReport", "report successfully! %s", C41911a.m74010a(bsb));
                                        AppMethodBeat.m2505o(116346);
                                        return;
                                    }
                                    C4990ab.m7413e("MicroMsg.MediaSecurityReport", "report error![%s:%s] %s", Integer.valueOf(i), Integer.valueOf(i2), C41911a.m74010a(bsb));
                                    AppMethodBeat.m2505o(116346);
                                }
                            });
                        }
                    }
                }
            }
            AppMethodBeat.m2505o(116350);
            return;
        }
        AppMethodBeat.m2505o(116350);
    }

    /* renamed from: a */
    static /* synthetic */ String m74010a(bsb bsb) {
        AppMethodBeat.m2504i(116351);
        brw brw = bsb.wUe;
        String format = String.format("[image] %s,%s | %s,%s | %s %s", new Object[]{brw.wip, brw.AesKey, brw.wTW, brw.wTX, bsb.EmotionList, bsb.wdK});
        AppMethodBeat.m2505o(116351);
        return format;
    }
}
