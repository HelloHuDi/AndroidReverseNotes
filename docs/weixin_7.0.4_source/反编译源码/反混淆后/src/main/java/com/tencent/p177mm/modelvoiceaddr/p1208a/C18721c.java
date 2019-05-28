package com.tencent.p177mm.modelvoiceaddr.p1208a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.p123qq.p803wx.voice.vad.C25592a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.plugin.appbrand.jsapi.contact.C16657e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5141c;
import com.tencent.ugc.TXRecordCommon;
import java.util.Locale;

/* renamed from: com.tencent.mm.modelvoiceaddr.a.c */
public class C18721c {
    private static final String TAG = C18721c.class.getSimpleName();
    public static SharedPreferences ehZ = C4996ah.doB();
    private boolean aAP;
    private boolean gbH;
    private int gbI;
    private boolean gbJ;
    private boolean gbK;
    private long gbL;
    private int gbM;
    private C42231a gbN;
    private C25592a gbO;
    public C18722a gbP;
    private short[] gbQ;
    private C7306ak handler;

    /* renamed from: com.tencent.mm.modelvoiceaddr.a.c$a */
    public interface C18722a {
        /* renamed from: CV */
        void mo21119CV();

        void amu();

        void amv();

        /* renamed from: c */
        void mo21122c(short[] sArr, int i);
    }

    static {
        AppMethodBeat.m2504i(116763);
        AppMethodBeat.m2505o(116763);
    }

    public static String amz() {
        AppMethodBeat.m2504i(116758);
        String format = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[]{"sil_time", Integer.valueOf(ehZ.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(ehZ.getFloat("s_n_ration", 2.5f)), "s_window", Integer.valueOf(ehZ.getInt("s_window", 500)), "s_length", Integer.valueOf(ehZ.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(ehZ.getInt("s_delay_time", C16657e.CTRL_INDEX))});
        AppMethodBeat.m2505o(116758);
        return format;
    }

    public C18721c() {
        this(3500, ehZ.getInt("sil_time", 1000), ehZ.getFloat("s_n_ration", 2.5f), ehZ.getInt("s_window", 500), ehZ.getInt("s_length", 350), ehZ.getInt("s_delay_time", C16657e.CTRL_INDEX), true, true);
        AppMethodBeat.m2504i(116759);
        AppMethodBeat.m2505o(116759);
    }

    public C18721c(int i, int i2, float f, int i3, int i4, int i5, boolean z, boolean z2) {
        AppMethodBeat.m2504i(116760);
        this.gbH = true;
        this.gbI = 3;
        this.gbJ = false;
        this.gbK = false;
        this.gbL = 0;
        this.gbM = 3500;
        this.aAP = false;
        this.handler = new C7306ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(116757);
                if (message.what != 0) {
                    AppMethodBeat.m2505o(116757);
                    return;
                }
                if (C18721c.this.gbP != null) {
                    C18721c.this.gbP.mo21119CV();
                }
                AppMethodBeat.m2505o(116757);
            }
        };
        this.gbN = null;
        this.gbO = null;
        this.gbM = i;
        this.gbO = new C25592a();
        int i6 = 0;
        if (C4996ah.bqo()) {
            C5141c ll = C18624c.abi().mo17131ll("100235");
            if (ll.isValid()) {
                i6 = C5046bo.getInt((String) ll.dru().get("MMVoipVadOn"), 0);
            }
        }
        C4990ab.m7417i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", Integer.valueOf(i6));
        if (i6 == 0) {
            C25592a.m40603aU(false);
        } else {
            C25592a.m40603aU(true);
        }
        C25592a c25592a = this.gbO;
        if (C25592a.bCE) {
            c25592a.handle = c25592a.bCD.Init(TXRecordCommon.AUDIO_SAMPLERATE_16000, i2, f, i3, i4);
        } else {
            c25592a.handle = c25592a.bCC.Init(TXRecordCommon.AUDIO_SAMPLERATE_16000, i2, f, i3, i4);
        }
        if (C25592a.DEBUG) {
            System.out.println("EVad Init handle = " + c25592a.handle);
        }
        if (c25592a.handle == 0) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (i6 != 1) {
            C25592a c25592a2 = this.gbO;
            if (c25592a2.handle == 0) {
                i6 = 1;
            } else {
                if (C25592a.DEBUG) {
                    System.out.println("EVad Reset handle = " + c25592a2.handle);
                }
                if (C25592a.bCE) {
                    i6 = c25592a2.bCD.Reset(c25592a2.handle);
                } else {
                    i6 = c25592a2.bCC.Reset(c25592a2.handle);
                }
            }
            if (i6 != 1) {
                this.gbN = new C42231a(i5 * 16);
                this.gbQ = new short[WearableStatusCodes.TARGET_NODE_NOT_CONNECTED];
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) i);
                this.gbJ = z;
                this.gbK = z2;
                AppMethodBeat.m2505o(116760);
                return;
            }
        }
        C42232b c42232b = new C42232b("Init ERROR");
        AppMethodBeat.m2505o(116760);
        throw c42232b;
    }

    /* renamed from: f */
    public final void mo33988f(short[] sArr, int i) {
        AppMethodBeat.m2504i(116761);
        C4990ab.m7411d(TAG, "input() called with: voice = [%s], length = [%s]", sArr, Integer.valueOf(i));
        if (sArr == null || sArr.length == 0 || i <= 0 || i > sArr.length) {
            AppMethodBeat.m2505o(116761);
        } else if (this.aAP) {
            C4990ab.m7416i(TAG, "VoiceSilentDetectAPI is released.");
            AppMethodBeat.m2505o(116761);
        } else if (this.gbN == null) {
            C4990ab.m7416i(TAG, "input, circleBuffer is null.");
            AppMethodBeat.m2505o(116761);
        } else {
            int b = this.gbO.mo43300b(sArr, i);
            C4990ab.m7411d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", Integer.valueOf(b), Integer.valueOf(this.gbI), Boolean.valueOf(this.gbJ), Boolean.valueOf(this.gbK));
            long currentTimeMillis;
            int i2;
            int length;
            int i3;
            if (this.gbJ) {
                if (this.gbK) {
                    currentTimeMillis = System.currentTimeMillis();
                    if (this.gbP != null) {
                        this.gbP.amv();
                    }
                    this.gbL = currentTimeMillis;
                    if (this.aAP) {
                        AppMethodBeat.m2505o(116761);
                        return;
                    }
                    i2 = this.gbN.gbF;
                    length = this.gbQ.length;
                    while (i2 > 0) {
                        if (length > i2) {
                            i3 = i2;
                        } else {
                            i3 = length;
                        }
                        this.gbN.mo67757d(this.gbQ, i3);
                        i2 -= i3;
                        if (this.gbP != null) {
                            this.gbP.mo21122c(this.gbQ, i3);
                        }
                    }
                    this.gbK = false;
                    this.handler.removeMessages(0);
                    this.handler.sendEmptyMessageDelayed(0, (long) this.gbM);
                } else {
                    if (this.gbI == 3 && b == 2) {
                        this.gbJ = false;
                    }
                    if (!(this.gbI == 3 && b == 3)) {
                        this.handler.removeMessages(0);
                        this.handler.sendEmptyMessageDelayed(0, (long) this.gbM);
                    }
                }
                this.gbH = false;
                this.gbI = b;
            } else if (this.gbI == 3 && b == 2) {
                this.gbI = b;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.gbM);
                currentTimeMillis = System.currentTimeMillis();
                if (this.gbP != null) {
                    this.gbP.amv();
                }
                this.gbL = currentTimeMillis;
                if (this.aAP) {
                    AppMethodBeat.m2505o(116761);
                    return;
                }
                i2 = this.gbN.gbF;
                length = this.gbQ.length;
                while (i2 > 0) {
                    if (length > i2) {
                        i3 = i2;
                    } else {
                        i3 = length;
                    }
                    this.gbN.mo67757d(this.gbQ, i3);
                    i2 -= i3;
                    if (this.gbP != null) {
                        this.gbP.mo21122c(this.gbQ, i3);
                    }
                }
                this.gbH = false;
            } else if (this.gbI == 2 && b == 3) {
                this.gbI = b;
                this.gbH = true;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.gbM);
                currentTimeMillis = System.currentTimeMillis();
                if (this.gbP != null) {
                    this.gbP.amu();
                }
                this.gbL = currentTimeMillis;
                if (this.aAP) {
                    AppMethodBeat.m2505o(116761);
                    return;
                }
            } else if (this.gbI == 3 && b == 3) {
                this.gbH = true;
            } else if (this.gbI == 2 && b == 2) {
                this.gbH = false;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.gbM);
            }
            if (this.aAP) {
                AppMethodBeat.m2505o(116761);
                return;
            }
            this.gbN.mo67758e(sArr, i);
            C4990ab.m7411d(TAG, "isSilent %s", Boolean.valueOf(this.gbH));
            if (this.gbH) {
                AppMethodBeat.m2505o(116761);
                return;
            }
            if (this.gbP != null) {
                this.gbP.mo21122c(sArr, i);
            }
            AppMethodBeat.m2505o(116761);
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(116762);
        C4990ab.m7410d(TAG, "released");
        this.aAP = true;
        this.gbJ = false;
        this.gbK = false;
        if (this.gbO != null) {
            if (this.gbO.mo43301vU() == 1) {
                C42232b c42232b = new C42232b();
                AppMethodBeat.m2505o(116762);
                throw c42232b;
            }
            this.gbO = null;
        }
        this.gbN = null;
        this.gbQ = null;
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        this.gbP = null;
        AppMethodBeat.m2505o(116762);
    }
}
