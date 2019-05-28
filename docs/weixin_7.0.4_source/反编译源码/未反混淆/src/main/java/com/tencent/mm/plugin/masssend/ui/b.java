package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.audio.b.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.masssend.a.f;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.t;
import java.util.List;

public final class b implements com.tencent.mm.pluginsdk.ui.chat.b {
    final ap gci = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(22767);
            b.this.oor.Lf(b.this.oos.getMaxAmplitude());
            AppMethodBeat.o(22767);
            return true;
        }
    }, true);
    private Vibrator kgA;
    long miD = -1;
    Toast miE;
    final ap miP = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(22770);
            if (b.this.miD == -1) {
                b.this.miD = bo.yz();
            }
            long az = bo.az(b.this.miD);
            if (az >= 50000 && az <= 60000) {
                int i;
                if (b.this.miE == null) {
                    i = (int) ((60000 - az) / 1000);
                    b.this.miE = Toast.makeText(b.this.ooq, b.this.ooq.getResources().getQuantityString(R.plurals.c, i, new Object[]{Integer.valueOf(i)}), 0);
                } else {
                    i = (int) ((60000 - az) / 1000);
                    b.this.miE.setText(b.this.ooq.getResources().getQuantityString(R.plurals.c, i, new Object[]{Integer.valueOf(i)}));
                }
                b.this.miE.show();
            }
            if (az >= 60000) {
                ab.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
                if (b.this.oos.EH()) {
                    b.this.bNH();
                }
                b.this.oor.bvH();
                ay.au(b.this.ooq, R.string.ew8);
                AppMethodBeat.o(22770);
                return false;
            }
            AppMethodBeat.o(22770);
            return true;
        }
    }, true);
    MassSendMsgUI ooq;
    ChatFooter oor;
    a oos;
    ToneGenerator oot;
    private String oou;
    private List<String> oov;
    private boolean oow;
    private final com.tencent.mm.ai.j.a oox = new com.tencent.mm.ai.j.a() {
        public final void onError() {
            AppMethodBeat.i(22768);
            b.this.oos.reset();
            b.this.gci.stopTimer();
            b.this.miP.stopTimer();
            aj.amB("keep_app_silent");
            b.this.oor.bvH();
            ab.v("MicroMsg.MassSendFooterEventImpl", "record stop on error");
            Toast.makeText(b.this.ooq, b.this.ooq.getString(R.string.anm), 0).show();
            AppMethodBeat.o(22768);
        }
    };
    private final com.tencent.mm.ai.j.b ooy = new com.tencent.mm.ai.j.b() {
        public final void acE() {
            AppMethodBeat.i(22769);
            b.this.oor.dki();
            AppMethodBeat.o(22769);
        }
    };
    p tipDialog = null;

    class a extends h {
        String fileName;

        public a(Context context) {
            super(context, false);
        }

        public final String getFileName() {
            return this.fileName;
        }

        public final boolean EH() {
            AppMethodBeat.i(22774);
            this.fileName = super.getFileName();
            boolean EH = super.EH();
            super.reset();
            AppMethodBeat.o(22774);
            return EH;
        }
    }

    public b(MassSendMsgUI massSendMsgUI, ChatFooter chatFooter, String str, List<String> list, boolean z) {
        AppMethodBeat.i(22775);
        this.ooq = massSendMsgUI;
        this.oor = chatFooter;
        this.oou = str;
        this.oov = list;
        this.oow = z;
        this.oos = new a(massSendMsgUI);
        this.oos.a(this.oox);
        this.oos.a(this.ooy);
        this.oot = new ToneGenerator(1, 60);
        this.kgA = (Vibrator) massSendMsgUI.getSystemService("vibrator");
        AppMethodBeat.o(22775);
    }

    public final boolean bNG() {
        AppMethodBeat.i(22776);
        this.gci.stopTimer();
        this.miP.stopTimer();
        this.miD = -1;
        if (this.oos.EH()) {
            bNH();
            this.oor.bvH();
        } else {
            this.oor.ddN();
        }
        aw.Cc().Ic();
        AppMethodBeat.o(22776);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void bNH() {
        AppMethodBeat.i(22777);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.onZ = this.oou;
        aVar.ooa = this.oov.size();
        aVar.filename = this.oos.fileName;
        aVar.msgType = 34;
        aVar.oob = this.oos.cqD;
        final m fVar = new f(aVar, this.oow);
        aw.Rg().a(fVar, 0);
        Context context = this.ooq;
        this.ooq.getString(R.string.tz);
        this.tipDialog = com.tencent.mm.ui.base.h.b(context, this.ooq.getString(R.string.e3p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22771);
                aw.Rg().c(fVar);
                if (b.this.tipDialog != null) {
                    b.this.tipDialog.dismiss();
                    b.this.tipDialog = null;
                }
                AppMethodBeat.o(22771);
            }
        });
        AppMethodBeat.o(22777);
    }

    public final boolean bNI() {
        AppMethodBeat.i(22778);
        this.gci.stopTimer();
        this.miP.stopTimer();
        this.miD = -1;
        this.oor.bvH();
        a aVar = this.oos;
        aVar.EH();
        q.uT(aVar.fileName);
        aw.Cc().Ic();
        AppMethodBeat.o(22778);
        return false;
    }

    public final boolean bNJ() {
        AppMethodBeat.i(22779);
        aw.ZK();
        if (c.isSDCardAvailable()) {
            this.oot.startTone(24);
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(22772);
                    b.this.oot.stopTone();
                    AppMethodBeat.o(22772);
                }
            }, 200);
            this.kgA.vibrate(50);
            this.gci.ae(100, 100);
            this.miP.ae(200, 200);
            this.oor.Le(this.ooq.getResources().getDisplayMetrics().heightPixels - this.oor.getHeight());
            this.oos.em("_USER_FOR_THROWBOTTLE_");
            this.oos.a(this.ooy);
            this.oos.a(this.oox);
            aw.Cc().Id();
            AppMethodBeat.o(22779);
        } else {
            t.hO(this.ooq);
            AppMethodBeat.o(22779);
        }
        return false;
    }

    public final boolean Qu(String str) {
        AppMethodBeat.i(22780);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(22780);
            return false;
        }
        MassSendMsgUI.Qy(str);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.onZ = this.oou;
        aVar.ooa = this.oov.size();
        aVar.filename = str;
        aVar.msgType = 1;
        final m fVar = new f(aVar, this.oow);
        aw.Rg().a(fVar, 0);
        Context context = this.ooq;
        this.ooq.getString(R.string.tz);
        this.tipDialog = com.tencent.mm.ui.base.h.b(context, this.ooq.getString(R.string.e3p), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22773);
                aw.Rg().c(fVar);
                if (b.this.tipDialog != null) {
                    b.this.tipDialog.dismiss();
                    b.this.tipDialog = null;
                }
                AppMethodBeat.o(22773);
            }
        });
        AppMethodBeat.o(22780);
        return true;
    }

    public final void bNK() {
    }

    public final void bNL() {
    }

    public final void I(MotionEvent motionEvent) {
    }

    public final void release() {
        AppMethodBeat.i(22781);
        this.oot.release();
        AppMethodBeat.o(22781);
    }

    public final void onPause() {
        AppMethodBeat.i(22782);
        this.gci.stopTimer();
        this.miP.stopTimer();
        this.miD = -1;
        this.oos.EH();
        aw.Cc().Ic();
        AppMethodBeat.o(22782);
    }

    public final void iS(boolean z) {
    }
}
