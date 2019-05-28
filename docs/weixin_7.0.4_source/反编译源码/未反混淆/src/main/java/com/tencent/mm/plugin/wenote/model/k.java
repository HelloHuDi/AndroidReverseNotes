package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class k {
    private static k uNN = null;
    public long duration;
    public b gar = new b(ah.getContext());
    public long ljM;
    public boolean miB;
    public boolean miC;
    public long miD = -1;
    private Toast miE;
    public j miM;
    private final ak miO = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(26666);
            super.handleMessage(message);
            k.this.miB = false;
            AppMethodBeat.o(26666);
        }
    };
    public final ap miP = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(26668);
            if (k.this.miD == -1) {
                k.this.miD = bo.yz();
            }
            long az = bo.az(k.this.miD);
            if (az >= 3590000 && az <= 3600000) {
                if (k.this.miE == null) {
                    k.this.miE = Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.bni, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}), 0);
                } else {
                    k.this.miE.setText(ah.getContext().getString(R.string.bni, new Object[]{Integer.valueOf((int) ((3600000 - az) / 1000))}));
                }
                k.this.miE.show();
            }
            if (az >= 3600000) {
                ab.v("MicroMsg.WNNoteVoiceLogic", "record stop on countdown");
                k.this.miC = true;
                k.i(k.this);
                if (k.this.uNP != null) {
                    k.this.uNP.ddS();
                }
                AppMethodBeat.o(26668);
                return false;
            }
            AppMethodBeat.o(26668);
            return true;
        }
    }, true);
    public TextView mkf;
    public String path = "";
    public com.tencent.mm.modelvoice.k uNL;
    public String uNM = "";
    public int uNO = 0;
    public com.tencent.mm.plugin.wenote.model.b.a uNP;
    public l uNQ = null;
    public final ak uNR = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(26667);
            if (k.this.uNQ.uOi.booleanValue()) {
                k.this.uNP.ddT();
                k.this.uNQ.uOi = Boolean.FALSE;
            }
            k.this.uNQ.uOB = (int) com.tencent.mm.bk.a.fY(k.e(k.this));
            sendEmptyMessageDelayed(4096, 250);
            AppMethodBeat.o(26667);
        }
    };

    static /* synthetic */ long e(k kVar) {
        AppMethodBeat.i(26678);
        long duration = kVar.getDuration();
        AppMethodBeat.o(26678);
        return duration;
    }

    static /* synthetic */ void i(k kVar) {
        AppMethodBeat.i(26679);
        kVar.bvG();
        AppMethodBeat.o(26679);
    }

    private k() {
        AppMethodBeat.i(26669);
        AppMethodBeat.o(26669);
    }

    public static k ddK() {
        AppMethodBeat.i(26670);
        if (uNN == null) {
            uNN = new k();
        }
        k kVar = uNN;
        AppMethodBeat.o(26670);
        return kVar;
    }

    public final void ddL() {
        AppMethodBeat.i(26671);
        if (this.miB) {
            if (!this.miC) {
                bvG();
            }
            AppMethodBeat.o(26671);
            return;
        }
        AppMethodBeat.o(26671);
    }

    public final String ddM() {
        AppMethodBeat.i(26672);
        String str;
        if (e.ct(this.path)) {
            str = this.path;
            AppMethodBeat.o(26672);
            return str;
        }
        str = "";
        AppMethodBeat.o(26672);
        return str;
    }

    private void stopRecord() {
        AppMethodBeat.i(26673);
        if (this.uNM.equals("speex")) {
            this.uNL.EB();
        } else {
            this.miM.EB();
        }
        if (this.gar != null) {
            this.gar.Mm();
        }
        AppMethodBeat.o(26673);
    }

    private void bvG() {
        AppMethodBeat.i(26674);
        if (this.miB) {
            this.uNR.removeMessages(4096);
            stopRecord();
            this.duration = getDuration();
            boolean z = this.duration < 800;
            this.miP.stopTimer();
            if (z) {
                bvI();
                ddN();
            }
            this.miB = false;
            AppMethodBeat.o(26674);
            return;
        }
        AppMethodBeat.o(26674);
    }

    private void ddN() {
        AppMethodBeat.i(26675);
        this.miO.sendEmptyMessageDelayed(0, 500);
        AppMethodBeat.o(26675);
    }

    private long getDuration() {
        AppMethodBeat.i(26676);
        if (this.ljM == 0) {
            AppMethodBeat.o(26676);
            return 0;
        }
        long az = bo.az(this.ljM);
        AppMethodBeat.o(26676);
        return az;
    }

    private void bvI() {
        AppMethodBeat.i(26677);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(this.path);
        if (bVar.exists()) {
            bVar.delete();
        }
        AppMethodBeat.o(26677);
    }

    public static void destroy() {
        uNN = null;
    }

    public static k ddO() {
        return uNN;
    }
}
