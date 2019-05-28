package com.tencent.p177mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C25782h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C26497b;
import com.tencent.p177mm.modelvoice.C26500m;
import com.tencent.p177mm.modelvoice.C32848o;
import com.tencent.p177mm.modelvoice.C32849p;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p184aj.p185a.C45142c;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C26138fq;
import com.tencent.p177mm.p826ar.C32275d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.subapp.jdbiz.C22337c;
import com.tencent.p177mm.plugin.subapp.p1038b.C29384c;
import com.tencent.p177mm.plugin.subapp.p1039c.C41315d;
import com.tencent.p177mm.plugin.subapp.p1306a.C22329c;
import com.tencent.p177mm.plugin.subapp.p1505d.C35267a;
import com.tencent.p177mm.plugin.subapp.p1505d.C35268b;
import com.tencent.p177mm.plugin.subapp.p1505d.C35269c;
import com.tencent.p177mm.plugin.subapp.p537ui.voicetranstext.C35277a;
import com.tencent.p177mm.plugin.subapp.p537ui.voicetranstext.C35278c;
import com.tencent.p177mm.plugin.subapp.p537ui.voicetranstext.C39943b;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C23514cc;
import com.tencent.p177mm.storage.C7620bi;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.subapp.a */
public final class C22330a implements C1816at {
    static C23514cc srD;
    private Map<String, C1816at> srE = new HashMap();
    private C22331a srF;
    private C35267a srG;
    private C35269c srH;

    /* renamed from: com.tencent.mm.plugin.subapp.a$a */
    public static class C22331a extends C4884c<C26138fq> implements C1202f {
        private String cEV;
        private int czO;
        private int czP;
        private boolean eDk;
        private boolean hjA;
        private C35277a srJ;
        private C35278c srK;
        private C39943b srL;
        private C26497b srM;
        private C32849p srN;
        private volatile boolean srO;
        boolean srP;
        private C7564ap srQ;
        private C26138fq srR;
        private int srS;
        private Map<String, String> srT;
        private int srU;
        private boolean srV;
        private long srW;
        private long srX;
        private String toUser;

        /* renamed from: com.tencent.mm.plugin.subapp.a$a$a */
        enum C22332a {
            CHECK,
            UPLOAD,
            UPLOAD_MORE,
            GET,
            FINISH,
            ERROR,
            CANCEL,
            CANCEL_BY_USER,
            LOCAL_ERROR,
            SERVER_ERROR,
            NETWORK_OVERTIME;

            static {
                AppMethodBeat.m2505o(25161);
            }
        }

        public C22331a() {
            AppMethodBeat.m2504i(25162);
            this.srO = false;
            this.srP = false;
            this.srV = true;
            this.srW = 0;
            this.eDk = false;
            this.srT = new HashMap();
            this.xxI = C26138fq.class.getName().hashCode();
            AppMethodBeat.m2505o(25162);
        }

        /* renamed from: a */
        private boolean m34025a(C26138fq c26138fq) {
            AppMethodBeat.m2504i(25163);
            if (!(c26138fq instanceof C26138fq)) {
                C4990ab.m7414f("MicroMsg.SubCoreSubapp", "mismatched event");
                AppMethodBeat.m2505o(25163);
                return false;
            } else if (c26138fq.czB.czE == 2) {
                mo37876a(C22332a.CANCEL);
                this.srT.clear();
                C4990ab.m7416i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
                AppMethodBeat.m2505o(25163);
                return true;
            } else if (c26138fq.czB.czE == 1) {
                mo37876a(C22332a.CANCEL);
                C4990ab.m7416i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
                AppMethodBeat.m2505o(25163);
                return true;
            } else if (c26138fq.czB.czE == 3) {
                mo37876a(C22332a.CANCEL_BY_USER);
                C4990ab.m7416i("MicroMsg.SubCoreSubapp", "alvinluo Have cancel translate voice action by user.");
                AppMethodBeat.m2505o(25163);
                return true;
            } else if (c26138fq.czB.czE != 0) {
                C4990ab.m7417i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", Integer.valueOf(this.srR.czB.czE));
                AppMethodBeat.m2505o(25163);
                return false;
            } else if (this.hjA) {
                C4990ab.m7420w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
                AppMethodBeat.m2505o(25163);
                return false;
            } else if (C26500m.ama() == null) {
                C4990ab.m7412e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + C5046bo.dpG());
                AppMethodBeat.m2505o(25163);
                return false;
            } else {
                this.srR = c26138fq;
                String str = this.srR.czB.czD;
                String str2 = this.srR.czB.fileName;
                if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
                    C4990ab.m7413e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", str, str2);
                    mo37876a(C22332a.LOCAL_ERROR);
                    AppMethodBeat.m2505o(25163);
                    return false;
                }
                cDh();
                String str3 = (String) this.srT.get(str2);
                if (C5046bo.isNullOrNil(str3)) {
                    C23514cc aqb = C26500m.amb().aqb(str2);
                    C22330a.srD = aqb;
                    if (aqb == null || C5046bo.isNullOrNil(C22330a.srD.field_content)) {
                        C4990ab.m7417i("MicroMsg.SubCoreSubapp", "alvinluo transform test voice scene: %d", Integer.valueOf(c26138fq.czB.scene));
                        this.srN = C26500m.ama().mo33987uZ(str2);
                        try {
                            if (this.srN == null) {
                                C4990ab.m7417i("MicroMsg.SubCoreSubapp", "alvinluo the VoiceInfo do not exist. (localId : %s, fileName : %s)", str, str2);
                                this.srN = new C32849p();
                                this.srN.fileName = str2;
                                this.srN.createTime = System.currentTimeMillis() / 1000;
                                this.srN.clientId = str2;
                                this.srN.fXb = System.currentTimeMillis() / 1000;
                                this.srN.status = 1;
                                if (c26138fq.czB.scene == 8) {
                                    this.srN.fXe = -1;
                                } else {
                                    this.srN.fXe = Integer.valueOf(str).intValue();
                                }
                                C4990ab.m7417i("MicroMsg.SubCoreSubapp", "size : %d", Integer.valueOf(C32848o.m53701uj(str2)));
                                this.srN.frO = r0;
                            }
                            if (this.srN.fXe < 0) {
                                C4990ab.m7416i("MicroMsg.SubCoreSubapp", "alvinluo voiceInfo msgLocalId < 0");
                            } else {
                                C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf((long) this.srN.fXe);
                                C45142c aK;
                                if (jf.field_isSend == 1) {
                                    this.cEV = C1853r.m3846Yz();
                                    if (this.srR.czB.scene == 4 || this.srR.czB.scene == 5) {
                                        aK = ((C25782h) C1720g.m3528K(C25782h.class)).mo43744aK(jf.field_bizChatId);
                                        if (aK != null) {
                                            this.toUser = aK.field_bizChatServId;
                                        } else {
                                            this.toUser = "";
                                        }
                                    } else {
                                        this.toUser = jf.field_talker;
                                    }
                                } else if (jf.field_isSend == 0) {
                                    this.toUser = C1853r.m3846Yz();
                                    if (this.srR.czB.scene == 4 || this.srR.czB.scene == 5) {
                                        aK = ((C25782h) C1720g.m3528K(C25782h.class)).mo43744aK(jf.field_bizChatId);
                                        if (aK != null) {
                                            this.cEV = aK.field_bizChatServId;
                                        } else {
                                            this.cEV = "";
                                        }
                                    } else {
                                        this.cEV = jf.field_talker;
                                    }
                                }
                            }
                            this.srU = this.srR.czB.scene;
                            C4990ab.m7411d("MicroMsg.SubCoreSubapp", "alvinluo VoiceTransformText fromUser: %s, toUser: %s, scene: %d", this.cEV, this.toUser, Integer.valueOf(this.srU));
                            this.srM = C32850q.m53727uN(this.srN.fileName);
                            this.hjA = true;
                            this.srS = 20;
                            mo37876a(C22332a.CHECK);
                            AppMethodBeat.m2505o(25163);
                            return true;
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.SubCoreSubapp", e, "alvinluo set voiceInfo exception", new Object[0]);
                            mo37876a(C22332a.LOCAL_ERROR);
                            AppMethodBeat.m2505o(25163);
                            return true;
                        }
                    }
                    C4990ab.m7417i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", str, str2);
                    m34024a(C22330a.srD.field_content, C22332a.FINISH);
                    AppMethodBeat.m2505o(25163);
                    return true;
                }
                C4990ab.m7417i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", str, str2);
                m34024a(str3, C22332a.FINISH);
                AppMethodBeat.m2505o(25163);
                return true;
            }
        }

        private void cDh() {
            this.srV = true;
            this.srW = 0;
            this.srX = 0;
            this.czO = 0;
            this.czP = 0;
            this.eDk = false;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo37876a(C22332a c22332a) {
            AppMethodBeat.m2504i(25164);
            switch (C223331.srI[c22332a.ordinal()]) {
                case 1:
                    C4990ab.m7416i("MicroMsg.SubCoreSubapp", "net check");
                    if (this.srN.cKK > 0) {
                        C4990ab.m7417i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", Long.valueOf(this.srN.cKK));
                        this.srJ = new C35277a(this.srN.clientId, this.srN.frO, this.srM.getFormat(), this.srN.cKK, this.srN.fileName, this.srU, this.cEV, this.toUser);
                    } else {
                        C4990ab.m7417i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", Long.valueOf(this.srN.cKK));
                        this.srJ = new C35277a(this.srN.clientId, this.srN.frO, this.srN.fileName, this.srU, this.cEV, this.toUser);
                    }
                    C9638aw.m17182Rg().mo14541a(this.srJ, 0);
                    C9638aw.m17182Rg().mo14539a(this.srJ.getType(), (C1202f) this);
                    this.srX = System.currentTimeMillis();
                    AppMethodBeat.m2505o(25164);
                    return;
                case 2:
                    C4990ab.m7416i("MicroMsg.SubCoreSubapp", "net upload");
                    if (this.srJ == null) {
                        C4990ab.m7420w("MicroMsg.SubCoreSubapp", "request upload must after check!");
                        AppMethodBeat.m2505o(25164);
                        return;
                    }
                    this.srK = new C35278c(this.srN.clientId, this.srJ.svS, this.srM.getFormat(), this.srN.fileName, this.srU, this.cEV, this.toUser);
                    C9638aw.m17182Rg().mo14541a(this.srK, 0);
                    C9638aw.m17182Rg().mo14539a(this.srK.getType(), (C1202f) this);
                    AppMethodBeat.m2505o(25164);
                    return;
                case 3:
                    C4990ab.m7416i("MicroMsg.SubCoreSubapp", "net upload more");
                    if (this.srK == null) {
                        C4990ab.m7420w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
                        AppMethodBeat.m2505o(25164);
                        return;
                    }
                    this.srK = new C35278c(this.srK);
                    C9638aw.m17182Rg().mo14541a(this.srK, 0);
                    C9638aw.m17182Rg().mo14539a(this.srK.getType(), (C1202f) this);
                    AppMethodBeat.m2505o(25164);
                    return;
                case 4:
                    if (this.srO) {
                        C4990ab.m7416i("MicroMsg.SubCoreSubapp", "pulling so pass");
                        AppMethodBeat.m2505o(25164);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.SubCoreSubapp", "net get");
                    if (this.srJ == null) {
                        C4990ab.m7420w("MicroMsg.SubCoreSubapp", "request get must after check!");
                        AppMethodBeat.m2505o(25164);
                        return;
                    }
                    this.srO = true;
                    this.srL = new C39943b(this.srN.clientId);
                    C9638aw.m17182Rg().mo14541a(this.srL, 0);
                    C9638aw.m17182Rg().mo14539a(this.srL.getType(), (C1202f) this);
                    AppMethodBeat.m2505o(25164);
                    return;
                case 5:
                    this.srP = true;
                    AppMethodBeat.m2505o(25164);
                    return;
                case 6:
                    C9638aw.m17182Rg().mo14547c(this.srJ);
                    C9638aw.m17182Rg().mo14547c(this.srK);
                    C9638aw.m17182Rg().mo14547c(this.srL);
                    this.eDk = true;
                    m34024a(null, C22332a.CANCEL);
                    AppMethodBeat.m2505o(25164);
                    return;
                case 7:
                case 8:
                    this.eDk = true;
                    m34024a(null, c22332a);
                    AppMethodBeat.m2505o(25164);
                    return;
                case 9:
                    this.eDk = true;
                    m34024a(null, c22332a);
                    break;
            }
            AppMethodBeat.m2505o(25164);
        }

        private void cDi() {
            AppMethodBeat.m2504i(25165);
            if (this.srV) {
                this.srV = false;
                this.srW = System.currentTimeMillis();
                this.czO = (int) (this.srW - this.srX);
            }
            AppMethodBeat.m2505o(25165);
        }

        /* renamed from: a */
        private void m34024a(String str, C22332a c22332a) {
            AppMethodBeat.m2504i(25166);
            C4990ab.m7417i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", c22332a);
            if (this.srQ != null) {
                this.srQ.stopTimer();
            }
            C9638aw.m17182Rg().mo14546b(546, (C1202f) this);
            C9638aw.m17182Rg().mo14546b(547, (C1202f) this);
            C9638aw.m17182Rg().mo14546b(548, (C1202f) this);
            if (this.srR != null) {
                if (!C5046bo.isNullOrNil(str)) {
                    this.srT.put(this.srR.czB.fileName, str);
                    if ((C22330a.srD == null || C5046bo.isNullOrNil(C22330a.srD.field_content)) && this.srR.czB.from == 1) {
                        C26500m.amb().mo48507a(abi(str));
                    }
                } else if (c22332a == C22332a.FINISH) {
                    C4990ab.m7417i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", this.srR.czB.czD);
                    this.srR.czC.state = 2;
                }
                this.srR.czC.bcU = true;
                this.srR.czC.content = str;
                if (c22332a == C22332a.CANCEL) {
                    this.srR.czC.state = 1;
                } else if (c22332a == C22332a.LOCAL_ERROR || c22332a == C22332a.SERVER_ERROR) {
                    this.srR.czC.state = 2;
                }
                C4990ab.m7411d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", str);
                if (this.srR.czB.czF != null) {
                    this.srR.czB.czF.run();
                }
            }
            m34026b(str, c22332a);
            this.srJ = null;
            this.srK = null;
            this.srL = null;
            this.srR = null;
            this.hjA = false;
            this.srP = false;
            this.srO = false;
            this.srS = 20;
            C22330a.srD = null;
            cDh();
            AppMethodBeat.m2505o(25166);
        }

        /* renamed from: b */
        private void m34026b(String str, C22332a c22332a) {
            AppMethodBeat.m2504i(25167);
            if (!this.eDk) {
                AppMethodBeat.m2505o(25167);
            } else if (this.srN == null) {
                AppMethodBeat.m2505o(25167);
            } else {
                int i;
                int length = str != null ? str.length() : 0;
                if (c22332a != C22332a.FINISH) {
                    this.czO = 0;
                    this.czP = 0;
                    if (c22332a == C22332a.CANCEL) {
                        i = 5;
                        length = 0;
                    } else if (c22332a == C22332a.SERVER_ERROR) {
                        length = 0;
                        i = 3;
                    } else if (c22332a == C22332a.LOCAL_ERROR) {
                        i = 4;
                        length = 0;
                    } else if (c22332a == C22332a.NETWORK_OVERTIME) {
                        length = 0;
                        i = 2;
                    } else {
                        length = 0;
                        i = 0;
                    }
                } else if (C5046bo.isNullOrNil(str)) {
                    this.czO = 0;
                    this.czP = 0;
                    length = 0;
                    i = 3;
                } else {
                    i = 1;
                }
                C4990ab.m7417i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", this.srN.clientId, Integer.valueOf(length), Integer.valueOf(this.czO), Integer.valueOf(this.czP), Integer.valueOf(i));
                if (i != 0) {
                    C35268b.m57941b(this.srN.clientId, length, this.czO, this.czP, i);
                }
                AppMethodBeat.m2505o(25167);
            }
        }

        private C23514cc abi(String str) {
            AppMethodBeat.m2504i(25168);
            C4990ab.m7417i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", this.srR.czB.czD, this.srR.czB.fileName);
            C23514cc c23514cc = new C23514cc();
            c23514cc.field_msgId = Long.valueOf(this.srR.czB.czD).longValue();
            c23514cc.aqa(this.srR.czB.fileName);
            c23514cc.field_content = str;
            AppMethodBeat.m2505o(25168);
            return c23514cc;
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            String str2 = null;
            AppMethodBeat.m2504i(25169);
            C4990ab.m7417i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                switch (c1207m.getType()) {
                    case 546:
                        if (this.srJ.mState == C35277a.svQ) {
                            C4990ab.m7416i("MicroMsg.SubCoreSubapp", "check result: done");
                            mo37876a(C22332a.FINISH);
                            cDi();
                            this.czP = 0;
                            this.eDk = true;
                            if (this.srJ.cDR()) {
                                str2 = this.srJ.svR.xlH;
                            }
                            m34024a(str2, C22332a.FINISH);
                            AppMethodBeat.m2505o(25169);
                            return;
                        } else if (this.srJ.mState == C35277a.svP) {
                            if (this.srJ.svR != null) {
                                C5046bo.isNullOrNil(this.srJ.svR.xlH);
                            }
                            C4990ab.m7416i("MicroMsg.SubCoreSubapp", "check result: processing");
                            mo37876a(C22332a.GET);
                            AppMethodBeat.m2505o(25169);
                            return;
                        } else if (this.srJ.mState == C35277a.svO) {
                            C4990ab.m7416i("MicroMsg.SubCoreSubapp", "check result: not exist");
                            mo37876a(C22332a.UPLOAD);
                            AppMethodBeat.m2505o(25169);
                            return;
                        } else if (this.srJ.svT != null) {
                            AppMethodBeat.m2505o(25169);
                            return;
                        }
                        break;
                    case 547:
                        if (this.srK.cDT()) {
                            C4990ab.m7416i("MicroMsg.SubCoreSubapp", "succeed upload");
                            mo37876a(C22332a.GET);
                            AppMethodBeat.m2505o(25169);
                            return;
                        }
                        C4990ab.m7411d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", Integer.valueOf(this.srK.svS.ptx), Integer.valueOf(this.srK.svS.pty));
                        mo37876a(C22332a.UPLOAD_MORE);
                        AppMethodBeat.m2505o(25169);
                        return;
                    case 548:
                        final int i3 = this.srL.svV;
                        C4990ab.m7417i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", Integer.valueOf(i3));
                        this.srO = false;
                        cDi();
                        if (!this.srL.isComplete() && this.srL.cDR()) {
                            C4990ab.m7416i("MicroMsg.SubCoreSubapp", "refreshResult result");
                            String str3 = this.srL.svR.xlH;
                            if (this.srR != null) {
                                this.srR.czC.bcU = false;
                                this.srR.czC.content = str3;
                                C4990ab.m7417i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", Boolean.valueOf(C5046bo.isNullOrNil(str3)));
                                if (this.srR.czB.czF != null) {
                                    this.srR.czB.czF.run();
                                }
                            }
                        } else if (!this.srL.cDR()) {
                            C4990ab.m7410d("MicroMsg.SubCoreSubapp", "result not valid");
                        }
                        if (this.srL.isComplete()) {
                            C4990ab.m7416i("MicroMsg.SubCoreSubapp", "succeed get");
                            if (this.srL.cDR()) {
                                str2 = this.srL.svR.xlH;
                            }
                            mo37876a(C22332a.FINISH);
                            this.czP = (int) (System.currentTimeMillis() - this.srW);
                            this.eDk = true;
                            m34024a(str2, C22332a.FINISH);
                            AppMethodBeat.m2505o(25169);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.SubCoreSubapp", "do get again after:%ds", Integer.valueOf(i3));
                        if (!this.srP) {
                            int i4 = this.srS - 1;
                            this.srS = i4;
                            if (i4 < 0) {
                                C4990ab.m7413e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", Integer.valueOf(20));
                                mo37876a(C22332a.SERVER_ERROR);
                                AppMethodBeat.m2505o(25169);
                                return;
                            }
                            if (this.srQ == null) {
                                this.srQ = new C7564ap(new C5015a() {
                                    /* renamed from: BI */
                                    public final boolean mo4499BI() {
                                        AppMethodBeat.m2504i(25158);
                                        if (C22331a.this.srP) {
                                            AppMethodBeat.m2505o(25158);
                                        } else {
                                            C4990ab.m7411d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", Integer.valueOf(i3));
                                            C22331a.this.mo37876a(C22332a.GET);
                                            AppMethodBeat.m2505o(25158);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            long j = (long) (i3 * 1000);
                            this.srQ.mo16770ae(j, j);
                        }
                        AppMethodBeat.m2505o(25169);
                        return;
                    default:
                        AppMethodBeat.m2505o(25169);
                        return;
                }
            } else if (i == 2) {
                mo37876a(C22332a.NETWORK_OVERTIME);
                AppMethodBeat.m2505o(25169);
                return;
            } else {
                mo37876a(C22332a.SERVER_ERROR);
            }
            AppMethodBeat.m2505o(25169);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.a$1 */
    static /* synthetic */ class C223331 {
        static final /* synthetic */ int[] srI = new int[C22332a.values().length];

        static {
            AppMethodBeat.m2504i(25157);
            try {
                srI[C22332a.CHECK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                srI[C22332a.UPLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                srI[C22332a.UPLOAD_MORE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                srI[C22332a.GET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                srI[C22332a.FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                srI[C22332a.CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                srI[C22332a.LOCAL_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                srI[C22332a.SERVER_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                srI[C22332a.NETWORK_OVERTIME.ordinal()] = 9;
                AppMethodBeat.m2505o(25157);
            } catch (NoSuchFieldError e9) {
                AppMethodBeat.m2505o(25157);
            }
        }
    }

    public C22330a() {
        AppMethodBeat.m2504i(25171);
        C4990ab.m7416i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
        C4990ab.m7416i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        hashMap.put(C32275d.class.getName(), new C32275d());
        hashMap.put(C29384c.class.getName(), new C29384c());
        hashMap.put(C22329c.class.getName(), new C22329c());
        C41315d c41315d = new C41315d();
        C26417a.flx = c41315d;
        hashMap.put(C41315d.class.getName(), c41315d);
        C22337c c22337c = new C22337c();
        hashMap.put(C22337c.class.getName(), c22337c);
        C44044f.vdy = c22337c;
        this.srE = hashMap;
        AppMethodBeat.m2505o(25171);
    }

    @SuppressLint({"UseSparseArrays"})
    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        AppMethodBeat.m2504i(25172);
        C4990ab.m7416i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        for (Entry entry : this.srE.entrySet()) {
            if (((C1816at) entry.getValue()).mo5391Jx() != null) {
                hashMap.putAll(((C1816at) entry.getValue()).mo5391Jx());
            }
        }
        AppMethodBeat.m2505o(25172);
        return hashMap;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
        AppMethodBeat.m2504i(25173);
        C4990ab.m7416i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
        for (Entry value : this.srE.entrySet()) {
            ((C1816at) value.getValue()).mo5394iy(i);
        }
        AppMethodBeat.m2505o(25173);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(25174);
        C4990ab.m7416i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
        for (Entry value : this.srE.entrySet()) {
            ((C1816at) value.getValue()).mo5393bz(z);
        }
        if (this.srF == null) {
            this.srF = new C22331a();
        }
        if (this.srG == null) {
            this.srG = new C35267a();
        }
        if (this.srH == null) {
            this.srH = new C35269c();
        }
        C4879a.xxA.mo10052c(this.srF);
        C4879a.xxA.mo10052c(this.srH);
        C4879a.xxA.mo10052c(this.srG);
        AppMethodBeat.m2505o(25174);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(25175);
        C4990ab.m7416i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
        for (Entry value : this.srE.entrySet()) {
            ((C1816at) value.getValue()).mo5392bA(z);
        }
        AppMethodBeat.m2505o(25175);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(25176);
        C4990ab.m7416i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
        for (Entry value : this.srE.entrySet()) {
            ((C1816at) value.getValue()).onAccountRelease();
        }
        if (this.srF != null) {
            C4879a.xxA.mo10053d(this.srF);
        }
        if (this.srG != null) {
            C4879a.xxA.mo10053d(this.srG);
        }
        if (this.srH != null) {
            C4879a.xxA.mo10053d(this.srH);
        }
        AppMethodBeat.m2505o(25176);
    }

    public final C1816at abh(String str) {
        AppMethodBeat.m2504i(25177);
        C1816at c1816at = (C1816at) this.srE.get(str);
        AppMethodBeat.m2505o(25177);
        return c1816at;
    }

    /* renamed from: b */
    public final void mo37875b(String str, C1816at c1816at) {
        AppMethodBeat.m2504i(25178);
        this.srE.put(str, c1816at);
        AppMethodBeat.m2505o(25178);
    }
}
