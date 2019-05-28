package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.contact.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ugc.TXRecordCommon;
import java.util.Locale;

public class c {
    private static final String TAG = c.class.getSimpleName();
    public static SharedPreferences ehZ = ah.doB();
    private boolean aAP;
    private boolean gbH;
    private int gbI;
    private boolean gbJ;
    private boolean gbK;
    private long gbL;
    private int gbM;
    private a gbN;
    private com.qq.wx.voice.vad.a gbO;
    public a gbP;
    private short[] gbQ;
    private ak handler;

    public interface a {
        void CV();

        void amu();

        void amv();

        void c(short[] sArr, int i);
    }

    static {
        AppMethodBeat.i(116763);
        AppMethodBeat.o(116763);
    }

    public static String amz() {
        AppMethodBeat.i(116758);
        String format = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", new Object[]{"sil_time", Integer.valueOf(ehZ.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(ehZ.getFloat("s_n_ration", 2.5f)), "s_window", Integer.valueOf(ehZ.getInt("s_window", 500)), "s_length", Integer.valueOf(ehZ.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(ehZ.getInt("s_delay_time", e.CTRL_INDEX))});
        AppMethodBeat.o(116758);
        return format;
    }

    public c() {
        this(3500, ehZ.getInt("sil_time", 1000), ehZ.getFloat("s_n_ration", 2.5f), ehZ.getInt("s_window", 500), ehZ.getInt("s_length", 350), ehZ.getInt("s_delay_time", e.CTRL_INDEX), true, true);
        AppMethodBeat.i(116759);
        AppMethodBeat.o(116759);
    }

    public c(int i, int i2, float f, int i3, int i4, int i5, boolean z, boolean z2) {
        AppMethodBeat.i(116760);
        this.gbH = true;
        this.gbI = 3;
        this.gbJ = false;
        this.gbK = false;
        this.gbL = 0;
        this.gbM = 3500;
        this.aAP = false;
        this.handler = new ak(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(116757);
                if (message.what != 0) {
                    AppMethodBeat.o(116757);
                    return;
                }
                if (c.this.gbP != null) {
                    c.this.gbP.CV();
                }
                AppMethodBeat.o(116757);
            }
        };
        this.gbN = null;
        this.gbO = null;
        this.gbM = i;
        this.gbO = new com.qq.wx.voice.vad.a();
        int i6 = 0;
        if (ah.bqo()) {
            com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100235");
            if (ll.isValid()) {
                i6 = bo.getInt((String) ll.dru().get("MMVoipVadOn"), 0);
            }
        }
        ab.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", Integer.valueOf(i6));
        if (i6 == 0) {
            com.qq.wx.voice.vad.a.aU(false);
        } else {
            com.qq.wx.voice.vad.a.aU(true);
        }
        com.qq.wx.voice.vad.a aVar = this.gbO;
        if (com.qq.wx.voice.vad.a.bCE) {
            aVar.handle = aVar.bCD.Init(TXRecordCommon.AUDIO_SAMPLERATE_16000, i2, f, i3, i4);
        } else {
            aVar.handle = aVar.bCC.Init(TXRecordCommon.AUDIO_SAMPLERATE_16000, i2, f, i3, i4);
        }
        if (com.qq.wx.voice.vad.a.DEBUG) {
            System.out.println("EVad Init handle = " + aVar.handle);
        }
        if (aVar.handle == 0) {
            i6 = 1;
        } else {
            i6 = 0;
        }
        if (i6 != 1) {
            com.qq.wx.voice.vad.a aVar2 = this.gbO;
            if (aVar2.handle == 0) {
                i6 = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Reset handle = " + aVar2.handle);
                }
                if (com.qq.wx.voice.vad.a.bCE) {
                    i6 = aVar2.bCD.Reset(aVar2.handle);
                } else {
                    i6 = aVar2.bCC.Reset(aVar2.handle);
                }
            }
            if (i6 != 1) {
                this.gbN = new a(i5 * 16);
                this.gbQ = new short[WearableStatusCodes.TARGET_NODE_NOT_CONNECTED];
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) i);
                this.gbJ = z;
                this.gbK = z2;
                AppMethodBeat.o(116760);
                return;
            }
        }
        b bVar = new b("Init ERROR");
        AppMethodBeat.o(116760);
        throw bVar;
    }

    public final void f(short[] sArr, int i) {
        AppMethodBeat.i(116761);
        ab.d(TAG, "input() called with: voice = [%s], length = [%s]", sArr, Integer.valueOf(i));
        if (sArr == null || sArr.length == 0 || i <= 0 || i > sArr.length) {
            AppMethodBeat.o(116761);
        } else if (this.aAP) {
            ab.i(TAG, "VoiceSilentDetectAPI is released.");
            AppMethodBeat.o(116761);
        } else if (this.gbN == null) {
            ab.i(TAG, "input, circleBuffer is null.");
            AppMethodBeat.o(116761);
        } else {
            int b = this.gbO.b(sArr, i);
            ab.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", Integer.valueOf(b), Integer.valueOf(this.gbI), Boolean.valueOf(this.gbJ), Boolean.valueOf(this.gbK));
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
                        AppMethodBeat.o(116761);
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
                        this.gbN.d(this.gbQ, i3);
                        i2 -= i3;
                        if (this.gbP != null) {
                            this.gbP.c(this.gbQ, i3);
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
                    AppMethodBeat.o(116761);
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
                    this.gbN.d(this.gbQ, i3);
                    i2 -= i3;
                    if (this.gbP != null) {
                        this.gbP.c(this.gbQ, i3);
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
                    AppMethodBeat.o(116761);
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
                AppMethodBeat.o(116761);
                return;
            }
            this.gbN.e(sArr, i);
            ab.d(TAG, "isSilent %s", Boolean.valueOf(this.gbH));
            if (this.gbH) {
                AppMethodBeat.o(116761);
                return;
            }
            if (this.gbP != null) {
                this.gbP.c(sArr, i);
            }
            AppMethodBeat.o(116761);
        }
    }

    public final void release() {
        AppMethodBeat.i(116762);
        ab.d(TAG, "released");
        this.aAP = true;
        this.gbJ = false;
        this.gbK = false;
        if (this.gbO != null) {
            if (this.gbO.vU() == 1) {
                b bVar = new b();
                AppMethodBeat.o(116762);
                throw bVar;
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
        AppMethodBeat.o(116762);
    }
}
