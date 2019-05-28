package com.tencent.mm.plugin.voip.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.model.VoipScoreState;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.e;

@a(3)
public class VoipScoreDialog extends MMActivity {
    private VoipScoreState sPB;
    private ViewGroup sWL;
    private ImageView[] sWM = new ImageView[5];
    private c sWN = null;
    private int sWO = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoipScoreDialog() {
        AppMethodBeat.i(4862);
        AppMethodBeat.o(4862);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(4863);
        super.onCreate(bundle);
        this.sPB = (VoipScoreState) getIntent().getParcelableExtra("key_score_state");
        if (this.sPB == null) {
            b.e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
            finish();
            AppMethodBeat.o(4863);
            return;
        }
        this.sWL = (ViewGroup) View.inflate(this, R.layout.b2f, null);
        this.sWM[0] = (ImageView) this.sWL.findViewById(R.id.f37);
        this.sWM[1] = (ImageView) this.sWL.findViewById(R.id.f38);
        this.sWM[2] = (ImageView) this.sWL.findViewById(R.id.f39);
        this.sWM[3] = (ImageView) this.sWL.findViewById(R.id.f3_);
        this.sWM[4] = (ImageView) this.sWL.findViewById(R.id.f3a);
        for (int i = 0; i < this.sWM.length; i++) {
            this.sWM[i].setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(4856);
                    VoipScoreDialog.a(VoipScoreDialog.this, i);
                    AppMethodBeat.o(4856);
                }
            });
        }
        e.a aVar = new e.a(this);
        aVar.al(this.sPB.sSM);
        aVar.fo(this.sWL);
        aVar.zQJ = getString(R.string.f6t);
        aVar.b(new e.c() {
            public final void d(boolean z, String str) {
                AppMethodBeat.i(4857);
                VoipScoreDialog.b(VoipScoreDialog.this, 1);
                VoipScoreDialog.this.finish();
                AppMethodBeat.o(4857);
            }
        });
        aVar.re(false);
        aVar.b(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(4858);
                VoipScoreDialog.this.finish();
                AppMethodBeat.o(4858);
            }
        });
        this.sWN = aVar.gud;
        if (this.sWN != null) {
            this.sWN.show();
            AppMethodBeat.o(4863);
            return;
        }
        finish();
        AppMethodBeat.o(4863);
    }

    public final int getLayoutId() {
        return R.layout.b2g;
    }

    static /* synthetic */ void a(VoipScoreDialog voipScoreDialog, int i) {
        int i2 = 0;
        AppMethodBeat.i(4864);
        b.i("MicroMsg.VoipScoreDialog", "onScoreViewClick %s", Integer.valueOf(i));
        if (i >= 0 && i < voipScoreDialog.sWM.length) {
            while (i2 <= i) {
                voipScoreDialog.sWM[i2].setImageResource(R.drawable.bjy);
                i2++;
            }
            for (i2 = i + 1; i2 < voipScoreDialog.sWM.length; i2++) {
                voipScoreDialog.sWM[i2].setImageResource(R.drawable.bjx);
            }
            voipScoreDialog.sWO = i + 1;
        }
        if (voipScoreDialog.sWN != null) {
            voipScoreDialog.sWN.a((int) R.string.f6u, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4860);
                    VoipScoreDialog.b(VoipScoreDialog.this, 3);
                    com.tencent.mm.ui.widget.snackbar.b.a(VoipScoreDialog.this, null, VoipScoreDialog.this.getString(R.string.f6s), new com.tencent.mm.ui.widget.snackbar.a.c() {
                        public final void onShow() {
                        }

                        public final void onHide() {
                            AppMethodBeat.i(4859);
                            VoipScoreDialog.this.finish();
                            AppMethodBeat.o(4859);
                        }

                        public final void cLd() {
                        }
                    });
                    if (VoipScoreDialog.this.sWN != null) {
                        VoipScoreDialog.this.sWN.dismiss();
                    }
                    AppMethodBeat.o(4860);
                }
            });
            voipScoreDialog.sWN.b(R.string.or, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(4861);
                    VoipScoreDialog.b(VoipScoreDialog.this, 2);
                    VoipScoreDialog.this.finish();
                    AppMethodBeat.o(4861);
                }
            });
        }
        AppMethodBeat.o(4864);
    }

    static /* synthetic */ void b(VoipScoreDialog voipScoreDialog, int i) {
        AppMethodBeat.i(4865);
        b.i("MicroMsg.VoipScoreDialog", "doScoreStat %s %s %s", Integer.valueOf(voipScoreDialog.sWO), Integer.valueOf(i), voipScoreDialog.sPB);
        h.pYm.e(15684, Integer.valueOf(voipScoreDialog.sPB.nwu), Long.valueOf(voipScoreDialog.sPB.nwv), Integer.valueOf(i), Integer.valueOf(voipScoreDialog.sWO), Integer.valueOf(voipScoreDialog.sPB.sSN), Long.valueOf(voipScoreDialog.sPB.sSO), Long.valueOf(voipScoreDialog.sPB.nxT));
        AppMethodBeat.o(4865);
    }
}
