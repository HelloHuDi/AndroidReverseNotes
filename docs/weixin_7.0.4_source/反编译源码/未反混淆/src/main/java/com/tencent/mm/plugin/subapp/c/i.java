package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.j;
import com.tencent.mm.ai.j.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class i implements j, com.tencent.mm.compatible.b.g.a {
    private static int cri = 100;
    private k chd = null;
    private String fileName = "";
    private int jJI = 0;
    private long ljM = 0;
    protected b stf;
    protected com.tencent.mm.ai.j.a stg = null;
    private boolean sth = false;
    private a sti;
    private long stj = 0;
    private int stk = 0;
    private ap stl = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(25292);
            String a = i.this.fileName;
            if (a != null) {
                g abp = d.cDE().abp(a);
                if (abp == null) {
                    ab.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(a)));
                } else if (abp.field_status == 1) {
                    abp.field_status = 2;
                    abp.bJt = 64;
                    h.a(abp);
                }
            }
            d.cDF().run();
            ab.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.this.fileName);
            AppMethodBeat.o(25292);
            return false;
        }
    }, true);

    final class a implements Runnable {
        ak handler;

        public a() {
            AppMethodBeat.i(25296);
            this.handler = new ak(i.this) {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(25295);
                    if (i.this.stk <= 0) {
                        AppMethodBeat.o(25295);
                        return;
                    }
                    ab.d("MicroMsg.VoiceRemindRecorder", "On Part :" + (i.this.stf == null));
                    i.this.stk = 2;
                    if (i.this.stf != null) {
                        i.this.stf.acE();
                    }
                    AppMethodBeat.o(25295);
                }
            };
            AppMethodBeat.o(25296);
        }

        public final void run() {
            AppMethodBeat.i(25297);
            if (i.this.chd == null) {
                ab.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
                AppMethodBeat.o(25297);
                return;
            }
            synchronized (i.this) {
                try {
                    if (!i.this.chd.el(h.by(i.this.fileName, true))) {
                        i.abn(i.this.fileName);
                        i.this.fileName = null;
                        ab.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.this.fileName + "]");
                        i.this.chd = null;
                    }
                    i.this.ljM = bo.yz();
                    ab.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.this.fileName + "] time:" + bo.az(i.this.stj));
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(25297);
                }
            }
            this.handler.sendEmptyMessageDelayed(0, 1);
        }
    }

    public i() {
        AppMethodBeat.i(25298);
        AppMethodBeat.o(25298);
    }

    public final void gE(int i) {
        AppMethodBeat.i(25299);
        ab.d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :".concat(String.valueOf(i)));
        if (this.sth) {
            AppMethodBeat.o(25299);
            return;
        }
        this.sth = true;
        aw.ZL().b((com.tencent.mm.compatible.b.g.a) this);
        this.chd = new k();
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.ai.j.a() {
            public final void onError() {
                AppMethodBeat.i(25293);
                ab.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + i.this.fileName);
                i.abn(i.this.fileName);
                if (i.this.stg != null) {
                    i.this.stg.onError();
                }
                AppMethodBeat.o(25293);
            }
        };
        this.sti = new a();
        d.post(this.sti, "VoiceRemindRecorder_record");
        this.stk = 1;
        this.stl.ae(3000, 3000);
        ab.d("MicroMsg.VoiceRemindRecorder", "start end time:" + bo.az(this.stj));
        AppMethodBeat.o(25299);
    }

    public final int getMaxAmplitude() {
        AppMethodBeat.i(25300);
        if (this.chd != null) {
            int maxAmplitude = this.chd.getMaxAmplitude();
            if (maxAmplitude > cri) {
                cri = maxAmplitude;
            }
            ab.d("getMaxAmplitude", " map: " + maxAmplitude + " max:" + cri + " per:" + ((maxAmplitude * 100) / cri));
            maxAmplitude = (maxAmplitude * 100) / cri;
            AppMethodBeat.o(25300);
            return maxAmplitude;
        }
        AppMethodBeat.o(25300);
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
        AppMethodBeat.i(25302);
        ab.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
        synchronized (this) {
            try {
                ab.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
                if (this.chd != null) {
                    this.chd.EB();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(25302);
                }
            }
        }
        String str = this.fileName;
        if (str != null) {
            ab.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
            g abp = d.cDE().abp(str);
            if (abp != null) {
                abp.field_status = 8;
                abp.field_totallen = c.uj(h.by(str, false));
                abp.bJt = 64;
                h.a(abp);
            }
        }
        d.cDF().run();
        this.fileName = "";
        AppMethodBeat.o(25302);
        return true;
    }

    public final boolean EH() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(25303);
        aw.ZL().KN();
        ab.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
        synchronized (this) {
            try {
                ab.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
                if (this.chd != null) {
                    this.chd.EB();
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(25303);
                }
            }
        }
        if (this.stk != 2) {
            h.uS(this.fileName);
            this.fileName = null;
            ab.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bo.az(this.stj));
        } else {
            this.jJI = (int) EV();
            if (((long) this.jJI) < 800 || ((long) this.jJI) < 1000) {
                ab.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.jJI);
                h.uS(this.fileName);
                this.fileName = "";
                z = false;
            } else {
                String str = this.fileName;
                int i = this.jJI;
                if (str != null) {
                    ab.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
                    g abp = d.cDE().abp(str);
                    if (abp != null) {
                        if (!(abp.field_status == 97 || abp.field_status == 98)) {
                            abp.field_status = 3;
                        }
                        abp.field_totallen = c.uj(h.by(str, false));
                        if (abp.field_totallen <= 0) {
                            h.um(str);
                        } else {
                            abp.field_lastmodifytime = System.currentTimeMillis() / 1000;
                            abp.field_voicelenght = i;
                            abp.bJt = 3424;
                            bi biVar = new bi();
                            biVar.ju(abp.field_user);
                            biVar.setType(34);
                            biVar.hO(1);
                            biVar.jv(str);
                            if (abp.field_status == 97) {
                                biVar.setStatus(2);
                                biVar.setContent(f.d(abp.field_human, (long) abp.field_voicelenght, false));
                            } else if (abp.field_status == 98) {
                                biVar.setStatus(5);
                                biVar.setContent(f.d(abp.field_human, -1, true));
                            } else {
                                biVar.setStatus(1);
                            }
                            biVar.eJ(bf.oC(abp.field_user));
                            abp.field_msglocalid = (int) bf.l(biVar);
                            h.a(abp);
                        }
                    }
                }
                d.cDF().run();
                ab.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
            z2 = z;
        }
        this.stk = -1;
        AppMethodBeat.o(25303);
        return z2;
    }

    public final long EV() {
        AppMethodBeat.i(25304);
        if (this.ljM <= 0) {
            AppMethodBeat.o(25304);
            return 0;
        }
        long az = bo.az(this.ljM);
        AppMethodBeat.o(25304);
        return az;
    }

    public final void reset() {
        AppMethodBeat.i(25305);
        if (this.chd != null) {
            this.chd.EB();
            ab.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
        }
        this.fileName = "";
        this.stj = 0;
        this.sti = null;
        this.stk = 0;
        this.ljM = 0;
        AppMethodBeat.o(25305);
    }

    public final int ET() {
        return this.jJI;
    }

    public final void a(com.tencent.mm.ai.j.a aVar) {
        this.stg = aVar;
    }

    public final void a(b bVar) {
        this.stf = bVar;
    }

    public final int EY() {
        return 0;
    }

    public final boolean em(String str) {
        AppMethodBeat.i(25301);
        String ug = k.ug(r.Yz());
        g gVar = new g();
        gVar.field_filename = ug;
        gVar.field_user = str;
        gVar.field_createtime = System.currentTimeMillis() / 1000;
        gVar.field_clientid = ug;
        gVar.field_lastmodifytime = System.currentTimeMillis() / 1000;
        gVar.field_status = 1;
        gVar.field_human = r.Yz();
        gVar.bJt = -1;
        k cDE = d.cDE();
        ab.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
        int insert = (int) cDE.bSd.insert("VoiceRemindInfo", "", gVar.Hl());
        ab.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(insert)));
        if (insert == -1) {
            ug = null;
        }
        this.fileName = ug;
        aw.ZL().a((com.tencent.mm.compatible.b.g.a) this);
        int KM = aw.ZL().KM();
        this.sth = false;
        if (KM != 0) {
            gE(100);
        } else {
            new ak() {
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(25294);
                    ab.d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
                    if (i.this.sth) {
                        AppMethodBeat.o(25294);
                        return;
                    }
                    aw.ZL().b(i.this);
                    aw.ZL().KN();
                    i.this.gE(200);
                    AppMethodBeat.o(25294);
                }
            }.sendEmptyMessageDelayed(0, 50);
        }
        AppMethodBeat.o(25301);
        return false;
    }

    static /* synthetic */ boolean abn(String str) {
        AppMethodBeat.i(25306);
        boolean uS = h.uS(str);
        AppMethodBeat.o(25306);
        return uS;
    }
}
