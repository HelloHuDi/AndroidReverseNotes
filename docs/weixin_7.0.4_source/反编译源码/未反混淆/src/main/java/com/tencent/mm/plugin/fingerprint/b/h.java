package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.c.e;
import com.tencent.mm.plugin.fingerprint.c.f;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h implements j {
    private String cBV = null;
    private String gEk = null;
    ak mrD = new ak(new com.tencent.mm.sdk.platformtools.ak.a() {
        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(41481);
            if (1 == message.what) {
                String string = message.getData().getString("rsaKey");
                if (TextUtils.isEmpty(string)) {
                    ab.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + message.what + " rsaKey is null");
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(41480);
                            h.this.mrH.aC(-1, h.this.mrJ.getString(R.string.bv_));
                            AppMethodBeat.o(41480);
                        }
                    });
                }
                h.this.mrJ.a(new e(string), false, false);
                AppMethodBeat.o(41481);
                return true;
            }
            AppMethodBeat.o(41481);
            return false;
        }
    });
    com.tencent.mm.pluginsdk.wallet.a mrH = null;
    private com.tencent.mm.pluginsdk.wallet.a mrI = null;
    WalletBaseUI mrJ = null;
    private String mrK = null;

    class a implements com.tencent.mm.plugin.fingerprint.b.q.a {
        private a() {
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final void AR(final String str) {
            AppMethodBeat.i(41484);
            if (TextUtils.isEmpty(str)) {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(41482);
                        h.this.mrH.aC(-1, h.this.mrJ.getString(R.string.bv_));
                        AppMethodBeat.o(41482);
                    }
                });
                ab.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
                AppMethodBeat.o(41484);
                return;
            }
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(41483);
                    ab.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
                    Message obtainMessage = h.this.mrD.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("rsaKey", str);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                    AppMethodBeat.o(41483);
                }
            });
            AppMethodBeat.o(41484);
        }
    }

    public h() {
        AppMethodBeat.i(41485);
        AppMethodBeat.o(41485);
    }

    public final void a(Context context, com.tencent.mm.pluginsdk.wallet.a aVar, String str) {
        AppMethodBeat.i(41486);
        this.mrJ = (WalletBaseUI) context;
        this.mrH = aVar;
        this.gEk = str;
        String rsaKey = FingerPrintAuth.getRsaKey(e.dQ(ah.getContext()), e.getUserId(), q.LM());
        com.tencent.mm.plugin.soter.d.a.cvN();
        if (TextUtils.isEmpty(rsaKey)) {
            ab.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
            new q(new a(this, (byte) 0)).aBU();
            AppMethodBeat.o(41486);
            return;
        }
        ab.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
        this.mrJ.a(new e(rsaKey), false, false);
        AppMethodBeat.o(41486);
    }

    public final void clear() {
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(41487);
        if (mVar instanceof e) {
            com.tencent.mm.pluginsdk.wallet.a aVar;
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
                e eVar = (e) mVar;
                this.mrK = eVar.mrK;
                this.cBV = eVar.cBV;
                aVar = this.mrH;
                str = "";
            } else {
                ab.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
                aVar = this.mrH;
                i3 = -1;
                if (bo.isNullOrNil(str)) {
                    str = this.mrJ.getString(R.string.bv_);
                }
            }
            aVar.aC(i3, str);
            AppMethodBeat.o(41487);
            return true;
        } else if (mVar instanceof f) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.soter.d.a.cvO();
                com.tencent.mm.plugin.soter.d.a.d(0, 0, 0, "OK");
                this.mrI.aC(0, "");
            } else {
                this.mrI.aC(-2, "");
            }
            AppMethodBeat.o(41487);
            return true;
        } else {
            AppMethodBeat.o(41487);
            return false;
        }
    }

    public final void a(com.tencent.mm.pluginsdk.wallet.a aVar, String str, int i) {
        AppMethodBeat.i(41488);
        this.mrI = aVar;
        if (TextUtils.isEmpty(this.gEk)) {
            ab.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
            aVar.aC(-1, this.mrJ.getString(R.string.bv_));
            AppMethodBeat.o(41488);
            return;
        }
        String userId = e.getUserId();
        String LM = q.LM();
        String dNR = w.dNR();
        String str2 = "";
        String str3 = "";
        if (e.bxs()) {
            userId = FingerPrintAuth.genOpenFPEncrypt(e.dQ(ah.getContext()), userId, LM, str, dNR, "", this.mrK, this.cBV, Build.MODEL);
            str3 = FingerPrintAuth.genOpenFPSign(e.dQ(ah.getContext()), e.getUserId(), q.LM(), userId);
        } else {
            userId = str2;
        }
        if (TextUtils.isEmpty(this.mrK)) {
            ab.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
        } else if (TextUtils.isEmpty(str3)) {
            ab.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
        this.mrJ.a(new f(userId, str3, this.gEk, i), false, false);
        AppMethodBeat.o(41488);
    }
}
