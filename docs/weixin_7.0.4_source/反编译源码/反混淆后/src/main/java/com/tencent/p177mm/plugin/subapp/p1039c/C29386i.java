package com.tencent.p177mm.plugin.subapp.p1039c;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p219b.C1407g.C1406a;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelvoice.C9742k;
import com.tencent.p177mm.p183ai.C41737j;
import com.tencent.p177mm.p183ai.C41737j.C37445a;
import com.tencent.p177mm.p183ai.C41737j.C41738b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.subapp.c.i */
public final class C29386i implements C41737j, C1406a {
    private static int cri = 100;
    private C9742k chd = null;
    private String fileName = "";
    private int jJI = 0;
    private long ljM = 0;
    protected C41738b stf;
    protected C37445a stg = null;
    private boolean sth = false;
    private C13902a sti;
    private long stj = 0;
    private int stk = 0;
    private C7564ap stl = new C7564ap(new C293871(), true);

    /* renamed from: com.tencent.mm.plugin.subapp.c.i$3 */
    class C139003 extends C7306ak {
        C139003() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(25294);
            C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
            if (C29386i.this.sth) {
                AppMethodBeat.m2505o(25294);
                return;
            }
            C9638aw.m17191ZL().mo4829b(C29386i.this);
            C9638aw.m17191ZL().mo4818KN();
            C29386i.this.mo4815gE(200);
            AppMethodBeat.m2505o(25294);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.c.i$a */
    final class C13902a implements Runnable {
        C7306ak handler;

        public C13902a() {
            AppMethodBeat.m2504i(25296);
            this.handler = new C7306ak(C29386i.this) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.m2504i(25295);
                    if (C29386i.this.stk <= 0) {
                        AppMethodBeat.m2505o(25295);
                        return;
                    }
                    C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "On Part :" + (C29386i.this.stf == null));
                    C29386i.this.stk = 2;
                    if (C29386i.this.stf != null) {
                        C29386i.this.stf.acE();
                    }
                    AppMethodBeat.m2505o(25295);
                }
            };
            AppMethodBeat.m2505o(25296);
        }

        public final void run() {
            AppMethodBeat.m2504i(25297);
            if (C29386i.this.chd == null) {
                C4990ab.m7412e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
                AppMethodBeat.m2505o(25297);
                return;
            }
            synchronized (C29386i.this) {
                try {
                    if (!C29386i.this.chd.mo5467el(C22335h.m34031by(C29386i.this.fileName, true))) {
                        C29386i.abn(C29386i.this.fileName);
                        C29386i.this.fileName = null;
                        C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + C29386i.this.fileName + "]");
                        C29386i.this.chd = null;
                    }
                    C29386i.this.ljM = C5046bo.m7588yz();
                    C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + C29386i.this.fileName + "] time:" + C5046bo.m7525az(C29386i.this.stj));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(25297);
                }
            }
            this.handler.sendEmptyMessageDelayed(0, 1);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.c.i$1 */
    class C293871 implements C5015a {
        C293871() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(25292);
            String a = C29386i.this.fileName;
            if (a != null) {
                C29385g abp = C41315d.cDE().abp(a);
                if (abp == null) {
                    C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(a)));
                } else if (abp.field_status == 1) {
                    abp.field_status = 2;
                    abp.bJt = 64;
                    C22335h.m34030a(abp);
                }
            }
            C41315d.cDF().run();
            C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + C29386i.this.fileName);
            AppMethodBeat.m2505o(25292);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.c.i$2 */
    class C293882 implements C37445a {
        C293882() {
        }

        public final void onError() {
            AppMethodBeat.m2504i(25293);
            C4990ab.m7412e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + C29386i.this.fileName);
            C29386i.abn(C29386i.this.fileName);
            if (C29386i.this.stg != null) {
                C29386i.this.stg.onError();
            }
            AppMethodBeat.m2505o(25293);
        }
    }

    public C29386i() {
        AppMethodBeat.m2504i(25298);
        AppMethodBeat.m2505o(25298);
    }

    /* renamed from: gE */
    public final void mo4815gE(int i) {
        AppMethodBeat.m2504i(25299);
        C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(i)));
        if (this.sth) {
            AppMethodBeat.m2505o(25299);
            return;
        }
        this.sth = true;
        C9638aw.m17191ZL().mo4829b((C1406a) this);
        this.chd = new C9742k();
        C293882 c293882 = new C293882();
        this.sti = new C13902a();
        C7305d.post(this.sti, "VoiceRemindRecorder_record");
        this.stk = 1;
        this.stl.mo16770ae(3000, 3000);
        C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "start end time:" + C5046bo.m7525az(this.stj));
        AppMethodBeat.m2505o(25299);
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.m2504i(25300);
        if (this.chd != null) {
            int maxAmplitude = this.chd.getMaxAmplitude();
            if (maxAmplitude > cri) {
                cri = maxAmplitude;
            }
            C4990ab.m7410d("getMaxAmplitude", " map: " + maxAmplitude + " max:" + cri + " per:" + ((maxAmplitude * 100) / cri));
            maxAmplitude = (maxAmplitude * 100) / cri;
            AppMethodBeat.m2505o(25300);
            return maxAmplitude;
        }
        AppMethodBeat.m2505o(25300);
        return 0;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean isRecording() {
        if (this.chd != null && this.chd.mStatus == 1) {
            return true;
        }
        return false;
    }

    public final boolean cancel() {
        AppMethodBeat.m2504i(25302);
        C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
        synchronized (this) {
            try {
                C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
                if (this.chd != null) {
                    this.chd.mo5464EB();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(25302);
                }
            }
        }
        String str = this.fileName;
        if (str != null) {
            C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
            C29385g abp = C41315d.cDE().abp(str);
            if (abp != null) {
                abp.field_status = 8;
                abp.field_totallen = C35265c.m57937uj(C22335h.m34031by(str, false));
                abp.bJt = 64;
                C22335h.m34030a(abp);
            }
        }
        C41315d.cDF().run();
        this.fileName = "";
        AppMethodBeat.m2505o(25302);
        return true;
    }

    /* renamed from: EH */
    public final boolean mo24432EH() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(25303);
        C9638aw.m17191ZL().mo4818KN();
        C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
        synchronized (this) {
            try {
                C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
                if (this.chd != null) {
                    this.chd.mo5464EB();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(25303);
                }
            }
        }
        if (this.stk != 2) {
            C22335h.m34033uS(this.fileName);
            this.fileName = null;
            C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + C5046bo.m7525az(this.stj));
        } else {
            this.jJI = (int) mo47619EV();
            if (((long) this.jJI) < 800 || ((long) this.jJI) < 1000) {
                C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.jJI);
                C22335h.m34033uS(this.fileName);
                this.fileName = "";
                z = false;
            } else {
                String str = this.fileName;
                int i = this.jJI;
                if (str != null) {
                    C4990ab.m7410d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
                    C29385g abp = C41315d.cDE().abp(str);
                    if (abp != null) {
                        if (!(abp.field_status == 97 || abp.field_status == 98)) {
                            abp.field_status = 3;
                        }
                        abp.field_totallen = C35265c.m57937uj(C22335h.m34031by(str, false));
                        if (abp.field_totallen <= 0) {
                            C22335h.m34034um(str);
                        } else {
                            abp.field_lastmodifytime = System.currentTimeMillis() / 1000;
                            abp.field_voicelenght = i;
                            abp.bJt = 3424;
                            C7620bi c7620bi = new C7620bi();
                            c7620bi.mo14794ju(abp.field_user);
                            c7620bi.setType(34);
                            c7620bi.mo14781hO(1);
                            c7620bi.mo14795jv(str);
                            if (abp.field_status == 97) {
                                c7620bi.setStatus(2);
                                c7620bi.setContent(C39938f.m68400d(abp.field_human, (long) abp.field_voicelenght, false));
                            } else if (abp.field_status == 98) {
                                c7620bi.setStatus(5);
                                c7620bi.setContent(C39938f.m68400d(abp.field_human, -1, true));
                            } else {
                                c7620bi.setStatus(1);
                            }
                            c7620bi.mo14775eJ(C1829bf.m3756oC(abp.field_user));
                            abp.field_msglocalid = (int) C1829bf.m3752l(c7620bi);
                            C22335h.m34030a(abp);
                        }
                    }
                }
                C41315d.cDF().run();
                C4990ab.m7410d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
            z2 = z;
        }
        this.stk = -1;
        AppMethodBeat.m2505o(25303);
        return z2;
    }

    /* renamed from: EV */
    public final long mo47619EV() {
        AppMethodBeat.m2504i(25304);
        if (this.ljM <= 0) {
            AppMethodBeat.m2505o(25304);
            return 0;
        }
        long az = C5046bo.m7525az(this.ljM);
        AppMethodBeat.m2505o(25304);
        return az;
    }

    public final void reset() {
        AppMethodBeat.m2504i(25305);
        if (this.chd != null) {
            this.chd.mo5464EB();
            C4990ab.m7412e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
        }
        this.fileName = "";
        this.stj = 0;
        this.sti = null;
        this.stk = 0;
        this.ljM = 0;
        AppMethodBeat.m2505o(25305);
    }

    /* renamed from: ET */
    public final int mo47618ET() {
        return this.jJI;
    }

    /* renamed from: a */
    public final void mo47621a(C37445a c37445a) {
        this.stg = c37445a;
    }

    /* renamed from: a */
    public final void mo47622a(C41738b c41738b) {
        this.stf = c41738b;
    }

    /* renamed from: EY */
    public final int mo47620EY() {
        return 0;
    }

    /* renamed from: em */
    public final boolean mo47624em(String str) {
        AppMethodBeat.m2504i(25301);
        String ug = C43667k.m78198ug(C1853r.m3846Yz());
        C29385g c29385g = new C29385g();
        c29385g.field_filename = ug;
        c29385g.field_user = str;
        c29385g.field_createtime = System.currentTimeMillis() / 1000;
        c29385g.field_clientid = ug;
        c29385g.field_lastmodifytime = System.currentTimeMillis() / 1000;
        c29385g.field_status = 1;
        c29385g.field_human = C1853r.m3846Yz();
        c29385g.bJt = -1;
        C43667k cDE = C41315d.cDE();
        C4990ab.m7410d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
        int insert = (int) cDE.bSd.insert("VoiceRemindInfo", "", c29385g.mo10098Hl());
        C4990ab.m7410d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(insert)));
        if (insert == -1) {
            ug = null;
        }
        this.fileName = ug;
        C9638aw.m17191ZL().mo4828a((C1406a) this);
        int KM = C9638aw.m17191ZL().mo4817KM();
        this.sth = false;
        if (KM != 0) {
            mo4815gE(100);
        } else {
            new C139003().sendEmptyMessageDelayed(0, 50);
        }
        AppMethodBeat.m2505o(25301);
        return false;
    }

    static /* synthetic */ boolean abn(String str) {
        AppMethodBeat.m2504i(25306);
        boolean uS = C22335h.m34033uS(str);
        AppMethodBeat.m2505o(25306);
        return uS;
    }
}
