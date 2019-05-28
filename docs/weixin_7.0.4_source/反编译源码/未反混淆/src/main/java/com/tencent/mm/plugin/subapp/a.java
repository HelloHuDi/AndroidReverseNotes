package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.api.h;
import com.tencent.mm.ar.d;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.subapp.d.c;
import com.tencent.mm.plugin.subapp.ui.voicetranstext.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a implements at {
    static cc srD;
    private Map<String, at> srE = new HashMap();
    private a srF;
    private com.tencent.mm.plugin.subapp.d.a srG;
    private c srH;

    public static class a extends com.tencent.mm.sdk.b.c<fq> implements f {
        private String cEV;
        private int czO;
        private int czP;
        private boolean eDk;
        private boolean hjA;
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.a srJ;
        private com.tencent.mm.plugin.subapp.ui.voicetranstext.c srK;
        private b srL;
        private com.tencent.mm.modelvoice.b srM;
        private p srN;
        private volatile boolean srO;
        boolean srP;
        private ap srQ;
        private fq srR;
        private int srS;
        private Map<String, String> srT;
        private int srU;
        private boolean srV;
        private long srW;
        private long srX;
        private String toUser;

        enum a {
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
                AppMethodBeat.o(25161);
            }
        }

        public a() {
            AppMethodBeat.i(25162);
            this.srO = false;
            this.srP = false;
            this.srV = true;
            this.srW = 0;
            this.eDk = false;
            this.srT = new HashMap();
            this.xxI = fq.class.getName().hashCode();
            AppMethodBeat.o(25162);
        }

        private boolean a(fq fqVar) {
            AppMethodBeat.i(25163);
            if (!(fqVar instanceof fq)) {
                ab.f("MicroMsg.SubCoreSubapp", "mismatched event");
                AppMethodBeat.o(25163);
                return false;
            } else if (fqVar.czB.czE == 2) {
                a(a.CANCEL);
                this.srT.clear();
                ab.i("MicroMsg.SubCoreSubapp", "Have clear the cache of the translate voice results.");
                AppMethodBeat.o(25163);
                return true;
            } else if (fqVar.czB.czE == 1) {
                a(a.CANCEL);
                ab.i("MicroMsg.SubCoreSubapp", "Have cancel translate voice action.");
                AppMethodBeat.o(25163);
                return true;
            } else if (fqVar.czB.czE == 3) {
                a(a.CANCEL_BY_USER);
                ab.i("MicroMsg.SubCoreSubapp", "alvinluo Have cancel translate voice action by user.");
                AppMethodBeat.o(25163);
                return true;
            } else if (fqVar.czB.czE != 0) {
                ab.i("MicroMsg.SubCoreSubapp", "The opCode(%d) is out of range.", Integer.valueOf(this.srR.czB.czE));
                AppMethodBeat.o(25163);
                return false;
            } else if (this.hjA) {
                ab.w("MicroMsg.SubCoreSubapp", "The Event handler is busy.");
                AppMethodBeat.o(25163);
                return false;
            } else if (m.ama() == null) {
                ab.e("MicroMsg.SubCoreSubapp", "SubCoreVoice.getVoiceStg() == null" + bo.dpG());
                AppMethodBeat.o(25163);
                return false;
            } else {
                this.srR = fqVar;
                String str = this.srR.czB.czD;
                String str2 = this.srR.czB.fileName;
                if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
                    ab.e("MicroMsg.SubCoreSubapp", "The localId(%s) is null or fileName(%s) is null.", str, str2);
                    a(a.LOCAL_ERROR);
                    AppMethodBeat.o(25163);
                    return false;
                }
                cDh();
                String str3 = (String) this.srT.get(str2);
                if (bo.isNullOrNil(str3)) {
                    cc aqb = m.amb().aqb(str2);
                    a.srD = aqb;
                    if (aqb == null || bo.isNullOrNil(a.srD.field_content)) {
                        ab.i("MicroMsg.SubCoreSubapp", "alvinluo transform test voice scene: %d", Integer.valueOf(fqVar.czB.scene));
                        this.srN = m.ama().uZ(str2);
                        try {
                            if (this.srN == null) {
                                ab.i("MicroMsg.SubCoreSubapp", "alvinluo the VoiceInfo do not exist. (localId : %s, fileName : %s)", str, str2);
                                this.srN = new p();
                                this.srN.fileName = str2;
                                this.srN.createTime = System.currentTimeMillis() / 1000;
                                this.srN.clientId = str2;
                                this.srN.fXb = System.currentTimeMillis() / 1000;
                                this.srN.status = 1;
                                if (fqVar.czB.scene == 8) {
                                    this.srN.fXe = -1;
                                } else {
                                    this.srN.fXe = Integer.valueOf(str).intValue();
                                }
                                ab.i("MicroMsg.SubCoreSubapp", "size : %d", Integer.valueOf(o.uj(str2)));
                                this.srN.frO = r0;
                            }
                            if (this.srN.fXe < 0) {
                                ab.i("MicroMsg.SubCoreSubapp", "alvinluo voiceInfo msgLocalId < 0");
                            } else {
                                bi jf = ((j) g.K(j.class)).bOr().jf((long) this.srN.fXe);
                                com.tencent.mm.aj.a.c aK;
                                if (jf.field_isSend == 1) {
                                    this.cEV = r.Yz();
                                    if (this.srR.czB.scene == 4 || this.srR.czB.scene == 5) {
                                        aK = ((h) g.K(h.class)).aK(jf.field_bizChatId);
                                        if (aK != null) {
                                            this.toUser = aK.field_bizChatServId;
                                        } else {
                                            this.toUser = "";
                                        }
                                    } else {
                                        this.toUser = jf.field_talker;
                                    }
                                } else if (jf.field_isSend == 0) {
                                    this.toUser = r.Yz();
                                    if (this.srR.czB.scene == 4 || this.srR.czB.scene == 5) {
                                        aK = ((h) g.K(h.class)).aK(jf.field_bizChatId);
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
                            ab.d("MicroMsg.SubCoreSubapp", "alvinluo VoiceTransformText fromUser: %s, toUser: %s, scene: %d", this.cEV, this.toUser, Integer.valueOf(this.srU));
                            this.srM = q.uN(this.srN.fileName);
                            this.hjA = true;
                            this.srS = 20;
                            a(a.CHECK);
                            AppMethodBeat.o(25163);
                            return true;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.SubCoreSubapp", e, "alvinluo set voiceInfo exception", new Object[0]);
                            a(a.LOCAL_ERROR);
                            AppMethodBeat.o(25163);
                            return true;
                        }
                    }
                    ab.i("MicroMsg.SubCoreSubapp", "finish With DB localId:%s,fileName:%s", str, str2);
                    a(a.srD.field_content, a.FINISH);
                    AppMethodBeat.o(25163);
                    return true;
                }
                ab.i("MicroMsg.SubCoreSubapp", "finish With Cache localId:%s,fileName:%s", str, str2);
                a(str3, a.FINISH);
                AppMethodBeat.o(25163);
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
        public final void a(a aVar) {
            AppMethodBeat.i(25164);
            switch (AnonymousClass1.srI[aVar.ordinal()]) {
                case 1:
                    ab.i("MicroMsg.SubCoreSubapp", "net check");
                    if (this.srN.cKK > 0) {
                        ab.i("MicroMsg.SubCoreSubapp", "has msg svr id: %d", Long.valueOf(this.srN.cKK));
                        this.srJ = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.srN.clientId, this.srN.frO, this.srM.getFormat(), this.srN.cKK, this.srN.fileName, this.srU, this.cEV, this.toUser);
                    } else {
                        ab.i("MicroMsg.SubCoreSubapp", "not existex msg svr id: %d", Long.valueOf(this.srN.cKK));
                        this.srJ = new com.tencent.mm.plugin.subapp.ui.voicetranstext.a(this.srN.clientId, this.srN.frO, this.srN.fileName, this.srU, this.cEV, this.toUser);
                    }
                    aw.Rg().a(this.srJ, 0);
                    aw.Rg().a(this.srJ.getType(), (f) this);
                    this.srX = System.currentTimeMillis();
                    AppMethodBeat.o(25164);
                    return;
                case 2:
                    ab.i("MicroMsg.SubCoreSubapp", "net upload");
                    if (this.srJ == null) {
                        ab.w("MicroMsg.SubCoreSubapp", "request upload must after check!");
                        AppMethodBeat.o(25164);
                        return;
                    }
                    this.srK = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.srN.clientId, this.srJ.svS, this.srM.getFormat(), this.srN.fileName, this.srU, this.cEV, this.toUser);
                    aw.Rg().a(this.srK, 0);
                    aw.Rg().a(this.srK.getType(), (f) this);
                    AppMethodBeat.o(25164);
                    return;
                case 3:
                    ab.i("MicroMsg.SubCoreSubapp", "net upload more");
                    if (this.srK == null) {
                        ab.w("MicroMsg.SubCoreSubapp", "upload more need has upload netScene!");
                        AppMethodBeat.o(25164);
                        return;
                    }
                    this.srK = new com.tencent.mm.plugin.subapp.ui.voicetranstext.c(this.srK);
                    aw.Rg().a(this.srK, 0);
                    aw.Rg().a(this.srK.getType(), (f) this);
                    AppMethodBeat.o(25164);
                    return;
                case 4:
                    if (this.srO) {
                        ab.i("MicroMsg.SubCoreSubapp", "pulling so pass");
                        AppMethodBeat.o(25164);
                        return;
                    }
                    ab.i("MicroMsg.SubCoreSubapp", "net get");
                    if (this.srJ == null) {
                        ab.w("MicroMsg.SubCoreSubapp", "request get must after check!");
                        AppMethodBeat.o(25164);
                        return;
                    }
                    this.srO = true;
                    this.srL = new b(this.srN.clientId);
                    aw.Rg().a(this.srL, 0);
                    aw.Rg().a(this.srL.getType(), (f) this);
                    AppMethodBeat.o(25164);
                    return;
                case 5:
                    this.srP = true;
                    AppMethodBeat.o(25164);
                    return;
                case 6:
                    aw.Rg().c(this.srJ);
                    aw.Rg().c(this.srK);
                    aw.Rg().c(this.srL);
                    this.eDk = true;
                    a(null, a.CANCEL);
                    AppMethodBeat.o(25164);
                    return;
                case 7:
                case 8:
                    this.eDk = true;
                    a(null, aVar);
                    AppMethodBeat.o(25164);
                    return;
                case 9:
                    this.eDk = true;
                    a(null, aVar);
                    break;
            }
            AppMethodBeat.o(25164);
        }

        private void cDi() {
            AppMethodBeat.i(25165);
            if (this.srV) {
                this.srV = false;
                this.srW = System.currentTimeMillis();
                this.czO = (int) (this.srW - this.srX);
            }
            AppMethodBeat.o(25165);
        }

        private void a(String str, a aVar) {
            AppMethodBeat.i(25166);
            ab.i("MicroMsg.SubCoreSubapp", "finishWithResult mstate:%s", aVar);
            if (this.srQ != null) {
                this.srQ.stopTimer();
            }
            aw.Rg().b(546, (f) this);
            aw.Rg().b(547, (f) this);
            aw.Rg().b(548, (f) this);
            if (this.srR != null) {
                if (!bo.isNullOrNil(str)) {
                    this.srT.put(this.srR.czB.fileName, str);
                    if ((a.srD == null || bo.isNullOrNil(a.srD.field_content)) && this.srR.czB.from == 1) {
                        m.amb().a(abi(str));
                    }
                } else if (aVar == a.FINISH) {
                    ab.i("MicroMsg.SubCoreSubapp", "finishWithResult State.FINISH id:%s", this.srR.czB.czD);
                    this.srR.czC.state = 2;
                }
                this.srR.czC.bcU = true;
                this.srR.czC.content = str;
                if (aVar == a.CANCEL) {
                    this.srR.czC.state = 1;
                } else if (aVar == a.LOCAL_ERROR || aVar == a.SERVER_ERROR) {
                    this.srR.czC.state = 2;
                }
                ab.d("MicroMsg.SubCoreSubapp", "finishWithResult result : %s", str);
                if (this.srR.czB.czF != null) {
                    this.srR.czB.czF.run();
                }
            }
            b(str, aVar);
            this.srJ = null;
            this.srK = null;
            this.srL = null;
            this.srR = null;
            this.hjA = false;
            this.srP = false;
            this.srO = false;
            this.srS = 20;
            a.srD = null;
            cDh();
            AppMethodBeat.o(25166);
        }

        private void b(String str, a aVar) {
            AppMethodBeat.i(25167);
            if (!this.eDk) {
                AppMethodBeat.o(25167);
            } else if (this.srN == null) {
                AppMethodBeat.o(25167);
            } else {
                int i;
                int length = str != null ? str.length() : 0;
                if (aVar != a.FINISH) {
                    this.czO = 0;
                    this.czP = 0;
                    if (aVar == a.CANCEL) {
                        i = 5;
                        length = 0;
                    } else if (aVar == a.SERVER_ERROR) {
                        length = 0;
                        i = 3;
                    } else if (aVar == a.LOCAL_ERROR) {
                        i = 4;
                        length = 0;
                    } else if (aVar == a.NETWORK_OVERTIME) {
                        length = 0;
                        i = 2;
                    } else {
                        length = 0;
                        i = 0;
                    }
                } else if (bo.isNullOrNil(str)) {
                    this.czO = 0;
                    this.czP = 0;
                    length = 0;
                    i = 3;
                } else {
                    i = 1;
                }
                ab.i("MicroMsg.SubCoreSubapp", "alvinluo transformTextResult voiceId: %s, wordCount: %d, waitTime: %d, animationTime: %d, transformResult: %d", this.srN.clientId, Integer.valueOf(length), Integer.valueOf(this.czO), Integer.valueOf(this.czP), Integer.valueOf(i));
                if (i != 0) {
                    com.tencent.mm.plugin.subapp.d.b.b(this.srN.clientId, length, this.czO, this.czP, i);
                }
                AppMethodBeat.o(25167);
            }
        }

        private cc abi(String str) {
            AppMethodBeat.i(25168);
            ab.i("MicroMsg.SubCoreSubapp", "createVoiceTT localId(%s) , fileName(%s).", this.srR.czB.czD, this.srR.czB.fileName);
            cc ccVar = new cc();
            ccVar.field_msgId = Long.valueOf(this.srR.czB.czD).longValue();
            ccVar.aqa(this.srR.czB.fileName);
            ccVar.field_content = str;
            AppMethodBeat.o(25168);
            return ccVar;
        }

        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
            String str2 = null;
            AppMethodBeat.i(25169);
            ab.i("MicroMsg.SubCoreSubapp", "onSceneEnd errType(%d) , errCode(%d).", Integer.valueOf(i), Integer.valueOf(i2));
            if (i == 0 && i2 == 0) {
                switch (mVar.getType()) {
                    case 546:
                        if (this.srJ.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.svQ) {
                            ab.i("MicroMsg.SubCoreSubapp", "check result: done");
                            a(a.FINISH);
                            cDi();
                            this.czP = 0;
                            this.eDk = true;
                            if (this.srJ.cDR()) {
                                str2 = this.srJ.svR.xlH;
                            }
                            a(str2, a.FINISH);
                            AppMethodBeat.o(25169);
                            return;
                        } else if (this.srJ.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.svP) {
                            if (this.srJ.svR != null) {
                                bo.isNullOrNil(this.srJ.svR.xlH);
                            }
                            ab.i("MicroMsg.SubCoreSubapp", "check result: processing");
                            a(a.GET);
                            AppMethodBeat.o(25169);
                            return;
                        } else if (this.srJ.mState == com.tencent.mm.plugin.subapp.ui.voicetranstext.a.svO) {
                            ab.i("MicroMsg.SubCoreSubapp", "check result: not exist");
                            a(a.UPLOAD);
                            AppMethodBeat.o(25169);
                            return;
                        } else if (this.srJ.svT != null) {
                            AppMethodBeat.o(25169);
                            return;
                        }
                        break;
                    case 547:
                        if (this.srK.cDT()) {
                            ab.i("MicroMsg.SubCoreSubapp", "succeed upload");
                            a(a.GET);
                            AppMethodBeat.o(25169);
                            return;
                        }
                        ab.d("MicroMsg.SubCoreSubapp", "start upload more: start:%d, len:%d", Integer.valueOf(this.srK.svS.ptx), Integer.valueOf(this.srK.svS.pty));
                        a(a.UPLOAD_MORE);
                        AppMethodBeat.o(25169);
                        return;
                    case 548:
                        final int i3 = this.srL.svV;
                        ab.i("MicroMsg.SubCoreSubapp", "get mIntervalSec:%ds", Integer.valueOf(i3));
                        this.srO = false;
                        cDi();
                        if (!this.srL.isComplete() && this.srL.cDR()) {
                            ab.i("MicroMsg.SubCoreSubapp", "refreshResult result");
                            String str3 = this.srL.svR.xlH;
                            if (this.srR != null) {
                                this.srR.czC.bcU = false;
                                this.srR.czC.content = str3;
                                ab.i("MicroMsg.SubCoreSubapp", "refreshResult result is null ? : %s", Boolean.valueOf(bo.isNullOrNil(str3)));
                                if (this.srR.czB.czF != null) {
                                    this.srR.czB.czF.run();
                                }
                            }
                        } else if (!this.srL.cDR()) {
                            ab.d("MicroMsg.SubCoreSubapp", "result not valid");
                        }
                        if (this.srL.isComplete()) {
                            ab.i("MicroMsg.SubCoreSubapp", "succeed get");
                            if (this.srL.cDR()) {
                                str2 = this.srL.svR.xlH;
                            }
                            a(a.FINISH);
                            this.czP = (int) (System.currentTimeMillis() - this.srW);
                            this.eDk = true;
                            a(str2, a.FINISH);
                            AppMethodBeat.o(25169);
                            return;
                        }
                        ab.i("MicroMsg.SubCoreSubapp", "do get again after:%ds", Integer.valueOf(i3));
                        if (!this.srP) {
                            int i4 = this.srS - 1;
                            this.srS = i4;
                            if (i4 < 0) {
                                ab.e("MicroMsg.SubCoreSubapp", "Has try to translate delay for %d times.", Integer.valueOf(20));
                                a(a.SERVER_ERROR);
                                AppMethodBeat.o(25169);
                                return;
                            }
                            if (this.srQ == null) {
                                this.srQ = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                                    public final boolean BI() {
                                        AppMethodBeat.i(25158);
                                        if (a.this.srP) {
                                            AppMethodBeat.o(25158);
                                        } else {
                                            ab.d("MicroMsg.SubCoreSubapp", "timmer get, delay:%d", Integer.valueOf(i3));
                                            a.this.a(a.GET);
                                            AppMethodBeat.o(25158);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            long j = (long) (i3 * 1000);
                            this.srQ.ae(j, j);
                        }
                        AppMethodBeat.o(25169);
                        return;
                    default:
                        AppMethodBeat.o(25169);
                        return;
                }
            } else if (i == 2) {
                a(a.NETWORK_OVERTIME);
                AppMethodBeat.o(25169);
                return;
            } else {
                a(a.SERVER_ERROR);
            }
            AppMethodBeat.o(25169);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.a$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] srI = new int[a.values().length];

        static {
            AppMethodBeat.i(25157);
            try {
                srI[a.CHECK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                srI[a.UPLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                srI[a.UPLOAD_MORE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                srI[a.GET.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                srI[a.FINISH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                srI[a.CANCEL.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                srI[a.LOCAL_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                srI[a.SERVER_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                srI[a.NETWORK_OVERTIME.ordinal()] = 9;
                AppMethodBeat.o(25157);
            } catch (NoSuchFieldError e9) {
                AppMethodBeat.o(25157);
            }
        }
    }

    public a() {
        AppMethodBeat.i(25171);
        ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
        ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        hashMap.put(d.class.getName(), new d());
        hashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
        hashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
        com.tencent.mm.plugin.subapp.c.d dVar = new com.tencent.mm.plugin.subapp.c.d();
        com.tencent.mm.model.ao.a.flx = dVar;
        hashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), dVar);
        com.tencent.mm.plugin.subapp.jdbiz.c cVar = new com.tencent.mm.plugin.subapp.jdbiz.c();
        hashMap.put(com.tencent.mm.plugin.subapp.jdbiz.c.class.getName(), cVar);
        com.tencent.mm.pluginsdk.f.f.vdy = cVar;
        this.srE = hashMap;
        AppMethodBeat.o(25171);
    }

    @SuppressLint({"UseSparseArrays"})
    public final HashMap<Integer, com.tencent.mm.cd.h.d> Jx() {
        AppMethodBeat.i(25172);
        ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
        HashMap hashMap = new HashMap();
        for (Entry entry : this.srE.entrySet()) {
            if (((at) entry.getValue()).Jx() != null) {
                hashMap.putAll(((at) entry.getValue()).Jx());
            }
        }
        AppMethodBeat.o(25172);
        return hashMap;
    }

    public final void iy(int i) {
        AppMethodBeat.i(25173);
        ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
        for (Entry value : this.srE.entrySet()) {
            ((at) value.getValue()).iy(i);
        }
        AppMethodBeat.o(25173);
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(25174);
        ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
        for (Entry value : this.srE.entrySet()) {
            ((at) value.getValue()).bz(z);
        }
        if (this.srF == null) {
            this.srF = new a();
        }
        if (this.srG == null) {
            this.srG = new com.tencent.mm.plugin.subapp.d.a();
        }
        if (this.srH == null) {
            this.srH = new c();
        }
        com.tencent.mm.sdk.b.a.xxA.c(this.srF);
        com.tencent.mm.sdk.b.a.xxA.c(this.srH);
        com.tencent.mm.sdk.b.a.xxA.c(this.srG);
        AppMethodBeat.o(25174);
    }

    public final void bA(boolean z) {
        AppMethodBeat.i(25175);
        ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
        for (Entry value : this.srE.entrySet()) {
            ((at) value.getValue()).bA(z);
        }
        AppMethodBeat.o(25175);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(25176);
        ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
        for (Entry value : this.srE.entrySet()) {
            ((at) value.getValue()).onAccountRelease();
        }
        if (this.srF != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.srF);
        }
        if (this.srG != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.srG);
        }
        if (this.srH != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.srH);
        }
        AppMethodBeat.o(25176);
    }

    public final at abh(String str) {
        AppMethodBeat.i(25177);
        at atVar = (at) this.srE.get(str);
        AppMethodBeat.o(25177);
        return atVar;
    }

    public final void b(String str, at atVar) {
        AppMethodBeat.i(25178);
        this.srE.put(str, atVar);
        AppMethodBeat.o(25178);
    }
}
