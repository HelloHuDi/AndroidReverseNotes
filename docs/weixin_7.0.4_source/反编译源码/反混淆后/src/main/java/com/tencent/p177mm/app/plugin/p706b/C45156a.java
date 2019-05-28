package com.tencent.p177mm.app.plugin.p706b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.p194a.C32297a;
import com.tencent.p177mm.audio.p195b.C32307h;
import com.tencent.p177mm.modelmulti.C26451h;
import com.tencent.p177mm.modelvoice.C18719u;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.modelvoice.C9742k;
import com.tencent.p177mm.p230g.p231a.C26139fr;
import com.tencent.p177mm.p230g.p231a.C32555ff;
import com.tencent.p177mm.p230g.p231a.C32557fk;
import com.tencent.p177mm.p230g.p231a.C37711fb;
import com.tencent.p177mm.p230g.p231a.C37712fl;
import com.tencent.p177mm.p230g.p231a.C37713fn;
import com.tencent.p177mm.p230g.p231a.C41995fs;
import com.tencent.p177mm.p230g.p231a.C45323fm;
import com.tencent.p177mm.p230g.p231a.C9336fi;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;

/* renamed from: com.tencent.mm.app.plugin.b.a */
public final class C45156a {

    /* renamed from: com.tencent.mm.app.plugin.b.a$a */
    public static class C6318a extends C4884c<C37711fb> {
        C25810i cgT;
        C32263e cgU;
        C37468f cgV;
        C32262d cgW;
        C17923h cgX;
        C32265g cgY;
        C37467c cgZ;
        C6319b cha;

        public C6318a() {
            AppMethodBeat.m2504i(15731);
            this.xxI = C37711fb.class.getName().hashCode();
            AppMethodBeat.m2505o(15731);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15732);
            C37711fb c37711fb = (C37711fb) c4883b;
            if (c37711fb.cyt.f2859op == 1) {
                C4990ab.m7416i("MicroMsg.SubCoreExtAgent", "ExtAgentLifeEventListener init");
                this.cgT = new C25810i();
                this.cgU = new C32263e();
                this.cgV = new C37468f();
                this.cgW = new C32262d();
                this.cgX = new C17923h();
                this.cgY = new C32265g();
                this.cgZ = new C37467c();
                this.cha = new C6319b();
                C4879a.xxA.mo10052c(this.cgT);
                C4879a.xxA.mo10052c(this.cgU);
                C4879a.xxA.mo10052c(this.cgV);
                C4879a.xxA.mo10052c(this.cgW);
                C4879a.xxA.mo10052c(this.cgX);
                C4879a.xxA.mo10052c(this.cgY);
                C4879a.xxA.mo10052c(this.cgZ);
                C4879a.xxA.mo10052c(this.cha);
            } else if (c37711fb.cyt.f2859op == 2) {
                if (this.cgT != null) {
                    C4879a.xxA.mo10053d(this.cgT);
                }
                if (this.cgU != null) {
                    C4879a.xxA.mo10053d(this.cgU);
                }
                if (this.cgV != null) {
                    C4879a.xxA.mo10053d(this.cgV);
                }
                if (this.cgW != null) {
                    C4879a.xxA.mo10053d(this.cgW);
                }
                if (this.cgX != null) {
                    C4879a.xxA.mo10053d(this.cgX);
                }
                if (this.cgY != null) {
                    C4879a.xxA.mo10053d(this.cgY);
                }
                if (this.cgZ != null) {
                    C4879a.xxA.mo10053d(this.cgZ);
                }
                if (this.cha != null) {
                    C4879a.xxA.mo10053d(this.cha);
                }
            }
            AppMethodBeat.m2505o(15732);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$b */
    public static class C6319b extends C4884c<C32555ff> {
        public C6319b() {
            AppMethodBeat.m2504i(15733);
            this.xxI = C32555ff.class.getName().hashCode();
            AppMethodBeat.m2505o(15733);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15734);
            C32555ff c32555ff = (C32555ff) c4883b;
            if (C21877n.qFD != null) {
                c32555ff.cyH.cyz = C21877n.qFD.mo62916WY(c32555ff.cyG.cyI);
            }
            AppMethodBeat.m2505o(15734);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$h */
    public static class C17923h extends C4884c<C41995fs> {
        public C17923h() {
            AppMethodBeat.m2504i(15747);
            this.xxI = C41995fs.class.getName().hashCode();
            AppMethodBeat.m2505o(15747);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15748);
            C41995fs c41995fs = (C41995fs) c4883b;
            if (C26500m.ama() == null) {
                C4990ab.m7412e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg()" + C5046bo.dpG());
                c41995fs.czJ.fileName = "";
            }
            C32849p mv = C26500m.ama().mo33985mv((int) c41995fs.czI.cvx);
            if (mv == null) {
                c41995fs.czJ.fileName = "";
            } else {
                c41995fs.czJ.fileName = mv.fileName;
            }
            AppMethodBeat.m2505o(15748);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$i */
    public static class C25810i extends C4884c<C45323fm> {
        public C25810i() {
            AppMethodBeat.m2504i(15749);
            this.xxI = C45323fm.class.getName().hashCode();
            AppMethodBeat.m2505o(15749);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15750);
            C4990ab.m7416i("MicroMsg.SubCoreExtAgent", "requestAccountSync()");
            if (C4996ah.getContext() == null) {
                C4990ab.m7420w("MicroMsg.SubCoreExtAgent", "MMApplicationContext.getContext() == null");
                AppMethodBeat.m2505o(15750);
                return false;
            }
            C26529w.m42360cq(C4996ah.getContext());
            AppMethodBeat.m2505o(15750);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$d */
    public static class C32262d extends C4884c<C32557fk> {
        C32297a chb;
        String fileName;

        public C32262d() {
            AppMethodBeat.m2504i(15737);
            this.xxI = C32557fk.class.getName().hashCode();
            AppMethodBeat.m2505o(15737);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15738);
            C32557fk c32557fk = (C32557fk) c4883b;
            if (C5046bo.isNullOrNil(c32557fk.czf.fileName) && c32557fk.czf.f1230op == 1) {
                C4990ab.m7413e("MicroMsg.SubCoreExtAgent", "fileName(%s) is null or nil.", c32557fk.czf.fileName);
            } else if (c32557fk.czf.f1230op == 1) {
                if (this.chb == null) {
                    this.chb = new C32297a(C4996ah.getContext());
                } else if (!c32557fk.czf.fileName.equals(this.fileName)) {
                    if (this.chb.isPlaying()) {
                        this.chb.stop(false);
                    }
                    this.fileName = c32557fk.czf.fileName;
                } else if (this.chb.mo33395DA()) {
                    c32557fk.czg.cvi = this.chb.mo33396Ew();
                } else if (this.chb.isPlaying()) {
                    c32557fk.czg.cvi = false;
                }
                this.chb.coD = c32557fk.czf.czi;
                this.chb.coC = c32557fk.czf.czj;
                c32557fk.czg.cvi = this.chb.mo33404a(c32557fk.czf.fileName, c32557fk.czf.com, c32557fk.czf.czh, -1);
            } else if (c32557fk.czf.f1230op == 2) {
                if (this.chb != null) {
                    this.chb.stop(false);
                }
            } else if (c32557fk.czf.f1230op == 4 && this.chb != null && this.chb.isPlaying()) {
                c32557fk.czg.cvi = this.chb.mo53006bn(true);
            }
            AppMethodBeat.m2505o(15738);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$e */
    public static class C32263e extends C4884c<C37712fl> {
        C32307h chc;
        String fileName;

        public C32263e() {
            AppMethodBeat.m2504i(15739);
            this.fileName = "";
            this.xxI = C37712fl.class.getName().hashCode();
            AppMethodBeat.m2505o(15739);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15740);
            C37712fl c37712fl = (C37712fl) c4883b;
            if (c37712fl.czk.f2861op == 1) {
                if (this.chc == null) {
                    this.chc = new C32307h(C4996ah.getContext(), false);
                }
                c37712fl.czl.cvi = this.chc.mo47624em(c37712fl.czk.username);
                this.fileName = this.chc.getFileName();
                C4990ab.m7411d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(c37712fl.czk.f2861op), Boolean.valueOf(c37712fl.czl.cvi));
            } else if (c37712fl.czk.f2861op == 2 && this.chc != null) {
                c37712fl.czl.fileName = this.fileName;
                c37712fl.czl.cvi = this.chc.mo24432EH();
                C4990ab.m7411d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(c37712fl.czk.f2861op), this.fileName, Boolean.valueOf(c37712fl.czl.cvi));
                this.fileName = "";
            }
            AppMethodBeat.m2505o(15740);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$g */
    public static class C32265g extends C4884c<C26139fr> {
        public C32265g() {
            AppMethodBeat.m2504i(15745);
            this.xxI = C26139fr.class.getName().hashCode();
            AppMethodBeat.m2505o(15745);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C32849p c32849p = null;
            AppMethodBeat.m2504i(15746);
            C26139fr c26139fr = (C26139fr) c4883b;
            if (C26500m.ama() == null) {
                C4990ab.m7412e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg() == null" + C5046bo.dpG());
            }
            C18719u ama = C26500m.ama();
            String str = c26139fr.czG.fileName;
            if (str != null) {
                String str2 = "SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum" + " FROM voiceinfo WHERE FileName= ?";
                Cursor a = ama.fni.mo10104a(str2, new String[]{str}, 2);
                C4990ab.m7410d("MicroMsg.VoiceStorage", "getInfoByFilename fileName[" + str + "] ResCount:" + a.getCount());
                if (a.moveToFirst()) {
                    c32849p = new C32849p();
                    c32849p.mo53420d(a);
                }
                a.close();
            }
            if (c32849p != null) {
                c26139fr.czH.cvx = (long) c32849p.fXe;
            }
            AppMethodBeat.m2505o(15746);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$c */
    public static class C37467c extends C4884c<C9336fi> {
        public C37467c() {
            AppMethodBeat.m2504i(15735);
            this.xxI = C9336fi.class.getName().hashCode();
            AppMethodBeat.m2505o(15735);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(15736);
            C9336fi c9336fi = (C9336fi) c4883b;
            C26451h c26451h = new C26451h(c9336fi.cza.toUserName, c9336fi.cza.content, c9336fi.cza.type);
            c9336fi.czb.czc = c26451h;
            c9336fi.czb.cvx = c26451h.cvx;
            AppMethodBeat.m2505o(15736);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$f */
    public static class C37468f extends C4884c<C37713fn> {
        C9742k chd;
        C7564ap che;
        boolean chf;
        boolean chg;
        boolean chh;
        C37713fn chi;
        Runnable chj;
        String fileName;

        /* renamed from: com.tencent.mm.app.plugin.b.a$f$1 */
        class C322641 implements C5015a {
            C322641() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(15741);
                C4990ab.m7416i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
                C37468f.this.chh = true;
                C37468f.this.stopRecord();
                AppMethodBeat.m2505o(15741);
                return false;
            }
        }

        public C37468f() {
            AppMethodBeat.m2504i(15742);
            this.fileName = "";
            this.xxI = C37713fn.class.getName().hashCode();
            AppMethodBeat.m2505o(15742);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            int i = 600;
            AppMethodBeat.m2504i(15744);
            C37713fn c37713fn = (C37713fn) c4883b;
            if (c37713fn instanceof C37713fn) {
                if (c37713fn.czm.f16119op == 1) {
                    if (this.chd == null) {
                        this.chd = new C9742k();
                    }
                    this.chj = c37713fn.czm.chj;
                    if (this.chd.mStatus == 1) {
                        this.chd.mo5464EB();
                    }
                    c37713fn.czn.cvi = this.chd.mo5467el(c37713fn.czm.filePath);
                    int i2 = c37713fn.czm.duration;
                    if (i2 <= 0) {
                        C4990ab.m7412e("MicroMsg.SubCoreExtAgent", "duration is invalid, less than 0");
                        i2 = 60;
                    }
                    if (i2 > 600) {
                        C4990ab.m7413e("MicroMsg.SubCoreExtAgent", "duration is invalid, more than %d", Integer.valueOf(600));
                    } else {
                        i = i2;
                    }
                    C4990ab.m7417i("MicroMsg.SubCoreExtAgent", "MaxVoiceRecordTime (%d)s", Integer.valueOf(i));
                    long j = (long) (i * 1000);
                    if (this.che == null) {
                        this.che = new C7564ap(new C322641(), false);
                    }
                    if (this.che.doT()) {
                        this.che.stopTimer();
                    }
                    this.chh = false;
                    this.che.mo16770ae(j, j);
                    this.chf = false;
                    C4990ab.m7411d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(c37713fn.czm.f16119op), Boolean.valueOf(c37713fn.czn.cvi));
                } else if (c37713fn.czm.f16119op == 2 && this.chd != null) {
                    if (!this.chf) {
                        this.che.stopTimer();
                        C4990ab.m7416i("MicroMsg.SubCoreExtAgent", "Voice record stop.");
                        stopRecord();
                    }
                    c37713fn.czn.cvi = this.chg;
                    C4990ab.m7411d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(c37713fn.czm.f16119op), this.fileName, Boolean.valueOf(c37713fn.czn.cvi));
                    this.fileName = "";
                    this.chg = false;
                }
                AppMethodBeat.m2505o(15744);
                return true;
            }
            C4990ab.m7414f("MicroMsg.SubCoreExtAgent", "mismatched event");
            AppMethodBeat.m2505o(15744);
            return false;
        }

        /* Access modifiers changed, original: final */
        public final void stopRecord() {
            AppMethodBeat.m2504i(15743);
            if (this.chd != null) {
                this.chg = this.chd.mo5464EB();
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
            AppMethodBeat.m2505o(15743);
        }
    }
}
