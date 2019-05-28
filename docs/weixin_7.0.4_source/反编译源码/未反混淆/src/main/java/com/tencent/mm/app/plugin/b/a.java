package com.tencent.mm.app.plugin.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.g.a.fi;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.fm;
import com.tencent.mm.g.a.fn;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fs;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {

    public static class a extends com.tencent.mm.sdk.b.c<fb> {
        i cgT;
        e cgU;
        f cgV;
        d cgW;
        h cgX;
        g cgY;
        c cgZ;
        b cha;

        public a() {
            AppMethodBeat.i(15731);
            this.xxI = fb.class.getName().hashCode();
            AppMethodBeat.o(15731);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15732);
            fb fbVar = (fb) bVar;
            if (fbVar.cyt.op == 1) {
                ab.i("MicroMsg.SubCoreExtAgent", "ExtAgentLifeEventListener init");
                this.cgT = new i();
                this.cgU = new e();
                this.cgV = new f();
                this.cgW = new d();
                this.cgX = new h();
                this.cgY = new g();
                this.cgZ = new c();
                this.cha = new b();
                com.tencent.mm.sdk.b.a.xxA.c(this.cgT);
                com.tencent.mm.sdk.b.a.xxA.c(this.cgU);
                com.tencent.mm.sdk.b.a.xxA.c(this.cgV);
                com.tencent.mm.sdk.b.a.xxA.c(this.cgW);
                com.tencent.mm.sdk.b.a.xxA.c(this.cgX);
                com.tencent.mm.sdk.b.a.xxA.c(this.cgY);
                com.tencent.mm.sdk.b.a.xxA.c(this.cgZ);
                com.tencent.mm.sdk.b.a.xxA.c(this.cha);
            } else if (fbVar.cyt.op == 2) {
                if (this.cgT != null) {
                    com.tencent.mm.sdk.b.a.xxA.d(this.cgT);
                }
                if (this.cgU != null) {
                    com.tencent.mm.sdk.b.a.xxA.d(this.cgU);
                }
                if (this.cgV != null) {
                    com.tencent.mm.sdk.b.a.xxA.d(this.cgV);
                }
                if (this.cgW != null) {
                    com.tencent.mm.sdk.b.a.xxA.d(this.cgW);
                }
                if (this.cgX != null) {
                    com.tencent.mm.sdk.b.a.xxA.d(this.cgX);
                }
                if (this.cgY != null) {
                    com.tencent.mm.sdk.b.a.xxA.d(this.cgY);
                }
                if (this.cgZ != null) {
                    com.tencent.mm.sdk.b.a.xxA.d(this.cgZ);
                }
                if (this.cha != null) {
                    com.tencent.mm.sdk.b.a.xxA.d(this.cha);
                }
            }
            AppMethodBeat.o(15732);
            return true;
        }
    }

    public static class b extends com.tencent.mm.sdk.b.c<ff> {
        public b() {
            AppMethodBeat.i(15733);
            this.xxI = ff.class.getName().hashCode();
            AppMethodBeat.o(15733);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15734);
            ff ffVar = (ff) bVar;
            if (n.qFD != null) {
                ffVar.cyH.cyz = n.qFD.WY(ffVar.cyG.cyI);
            }
            AppMethodBeat.o(15734);
            return true;
        }
    }

    public static class h extends com.tencent.mm.sdk.b.c<fs> {
        public h() {
            AppMethodBeat.i(15747);
            this.xxI = fs.class.getName().hashCode();
            AppMethodBeat.o(15747);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15748);
            fs fsVar = (fs) bVar;
            if (m.ama() == null) {
                ab.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg()" + bo.dpG());
                fsVar.czJ.fileName = "";
            }
            p mv = m.ama().mv((int) fsVar.czI.cvx);
            if (mv == null) {
                fsVar.czJ.fileName = "";
            } else {
                fsVar.czJ.fileName = mv.fileName;
            }
            AppMethodBeat.o(15748);
            return true;
        }
    }

    public static class i extends com.tencent.mm.sdk.b.c<fm> {
        public i() {
            AppMethodBeat.i(15749);
            this.xxI = fm.class.getName().hashCode();
            AppMethodBeat.o(15749);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15750);
            ab.i("MicroMsg.SubCoreExtAgent", "requestAccountSync()");
            if (ah.getContext() == null) {
                ab.w("MicroMsg.SubCoreExtAgent", "MMApplicationContext.getContext() == null");
                AppMethodBeat.o(15750);
                return false;
            }
            w.cq(ah.getContext());
            AppMethodBeat.o(15750);
            return true;
        }
    }

    public static class d extends com.tencent.mm.sdk.b.c<fk> {
        com.tencent.mm.audio.a.a chb;
        String fileName;

        public d() {
            AppMethodBeat.i(15737);
            this.xxI = fk.class.getName().hashCode();
            AppMethodBeat.o(15737);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15738);
            fk fkVar = (fk) bVar;
            if (bo.isNullOrNil(fkVar.czf.fileName) && fkVar.czf.op == 1) {
                ab.e("MicroMsg.SubCoreExtAgent", "fileName(%s) is null or nil.", fkVar.czf.fileName);
            } else if (fkVar.czf.op == 1) {
                if (this.chb == null) {
                    this.chb = new com.tencent.mm.audio.a.a(ah.getContext());
                } else if (!fkVar.czf.fileName.equals(this.fileName)) {
                    if (this.chb.isPlaying()) {
                        this.chb.stop(false);
                    }
                    this.fileName = fkVar.czf.fileName;
                } else if (this.chb.DA()) {
                    fkVar.czg.cvi = this.chb.Ew();
                } else if (this.chb.isPlaying()) {
                    fkVar.czg.cvi = false;
                }
                this.chb.coD = fkVar.czf.czi;
                this.chb.coC = fkVar.czf.czj;
                fkVar.czg.cvi = this.chb.a(fkVar.czf.fileName, fkVar.czf.com, fkVar.czf.czh, -1);
            } else if (fkVar.czf.op == 2) {
                if (this.chb != null) {
                    this.chb.stop(false);
                }
            } else if (fkVar.czf.op == 4 && this.chb != null && this.chb.isPlaying()) {
                fkVar.czg.cvi = this.chb.bn(true);
            }
            AppMethodBeat.o(15738);
            return true;
        }
    }

    public static class e extends com.tencent.mm.sdk.b.c<fl> {
        com.tencent.mm.audio.b.h chc;
        String fileName;

        public e() {
            AppMethodBeat.i(15739);
            this.fileName = "";
            this.xxI = fl.class.getName().hashCode();
            AppMethodBeat.o(15739);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15740);
            fl flVar = (fl) bVar;
            if (flVar.czk.op == 1) {
                if (this.chc == null) {
                    this.chc = new com.tencent.mm.audio.b.h(ah.getContext(), false);
                }
                flVar.czl.cvi = this.chc.em(flVar.czk.username);
                this.fileName = this.chc.getFileName();
                ab.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(flVar.czk.op), Boolean.valueOf(flVar.czl.cvi));
            } else if (flVar.czk.op == 2 && this.chc != null) {
                flVar.czl.fileName = this.fileName;
                flVar.czl.cvi = this.chc.EH();
                ab.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(flVar.czk.op), this.fileName, Boolean.valueOf(flVar.czl.cvi));
                this.fileName = "";
            }
            AppMethodBeat.o(15740);
            return true;
        }
    }

    public static class g extends com.tencent.mm.sdk.b.c<fr> {
        public g() {
            AppMethodBeat.i(15745);
            this.xxI = fr.class.getName().hashCode();
            AppMethodBeat.o(15745);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            p pVar = null;
            AppMethodBeat.i(15746);
            fr frVar = (fr) bVar;
            if (m.ama() == null) {
                ab.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg() == null" + bo.dpG());
            }
            u ama = m.ama();
            String str = frVar.czG.fileName;
            if (str != null) {
                String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
                Cursor a = ama.fni.a(str2, new String[]{str}, 2);
                ab.d("MicroMsg.VoiceStorage", "getInfoByFilename fileName[" + str + "] ResCount:" + a.getCount());
                if (a.moveToFirst()) {
                    pVar = new p();
                    pVar.d(a);
                }
                a.close();
            }
            if (pVar != null) {
                frVar.czH.cvx = (long) pVar.fXe;
            }
            AppMethodBeat.o(15746);
            return true;
        }
    }

    public static class c extends com.tencent.mm.sdk.b.c<fi> {
        public c() {
            AppMethodBeat.i(15735);
            this.xxI = fi.class.getName().hashCode();
            AppMethodBeat.o(15735);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(15736);
            fi fiVar = (fi) bVar;
            com.tencent.mm.modelmulti.h hVar = new com.tencent.mm.modelmulti.h(fiVar.cza.toUserName, fiVar.cza.content, fiVar.cza.type);
            fiVar.czb.czc = hVar;
            fiVar.czb.cvx = hVar.cvx;
            AppMethodBeat.o(15736);
            return true;
        }
    }

    public static class f extends com.tencent.mm.sdk.b.c<fn> {
        k chd;
        ap che;
        boolean chf;
        boolean chg;
        boolean chh;
        fn chi;
        Runnable chj;
        String fileName;

        public f() {
            AppMethodBeat.i(15742);
            this.fileName = "";
            this.xxI = fn.class.getName().hashCode();
            AppMethodBeat.o(15742);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            int i = 600;
            AppMethodBeat.i(15744);
            fn fnVar = (fn) bVar;
            if (fnVar instanceof fn) {
                if (fnVar.czm.op == 1) {
                    if (this.chd == null) {
                        this.chd = new k();
                    }
                    this.chj = fnVar.czm.chj;
                    if (this.chd.mStatus == 1) {
                        this.chd.EB();
                    }
                    fnVar.czn.cvi = this.chd.el(fnVar.czm.filePath);
                    int i2 = fnVar.czm.duration;
                    if (i2 <= 0) {
                        ab.e("MicroMsg.SubCoreExtAgent", "duration is invalid, less than 0");
                        i2 = 60;
                    }
                    if (i2 > 600) {
                        ab.e("MicroMsg.SubCoreExtAgent", "duration is invalid, more than %d", Integer.valueOf(600));
                    } else {
                        i = i2;
                    }
                    ab.i("MicroMsg.SubCoreExtAgent", "MaxVoiceRecordTime (%d)s", Integer.valueOf(i));
                    long j = (long) (i * 1000);
                    if (this.che == null) {
                        this.che = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                            public final boolean BI() {
                                AppMethodBeat.i(15741);
                                ab.i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
                                f.this.chh = true;
                                f.this.stopRecord();
                                AppMethodBeat.o(15741);
                                return false;
                            }
                        }, false);
                    }
                    if (this.che.doT()) {
                        this.che.stopTimer();
                    }
                    this.chh = false;
                    this.che.ae(j, j);
                    this.chf = false;
                    ab.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(fnVar.czm.op), Boolean.valueOf(fnVar.czn.cvi));
                } else if (fnVar.czm.op == 2 && this.chd != null) {
                    if (!this.chf) {
                        this.che.stopTimer();
                        ab.i("MicroMsg.SubCoreExtAgent", "Voice record stop.");
                        stopRecord();
                    }
                    fnVar.czn.cvi = this.chg;
                    ab.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(fnVar.czm.op), this.fileName, Boolean.valueOf(fnVar.czn.cvi));
                    this.fileName = "";
                    this.chg = false;
                }
                AppMethodBeat.o(15744);
                return true;
            }
            ab.f("MicroMsg.SubCoreExtAgent", "mismatched event");
            AppMethodBeat.o(15744);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final void stopRecord() {
            AppMethodBeat.i(15743);
            if (this.chd != null) {
                this.chg = this.chd.EB();
                if (this.chj != null) {
                    if (this.chi != null) {
                        this.chi.czn.czo = this.chd.coZ.cpR;
                        this.chi = null;
                    }
                    if (this.chh) {
                        this.chj.run();
                    }
                    this.chj = null;
                }
                this.chf = true;
            }
            AppMethodBeat.o(15743);
        }
    }
}
