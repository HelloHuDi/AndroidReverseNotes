package com.tencent.p177mm.plugin.voip.p546ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24112c;
import com.tencent.p177mm.p612ui.widget.snackbar.C5670b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.voip.model.VoipScoreState;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.voip.ui.VoipScoreDialog */
public class VoipScoreDialog extends MMActivity {
    private VoipScoreState sPB;
    private ViewGroup sWL;
    private ImageView[] sWM = new ImageView[5];
    private C5653c sWN = null;
    private int sWO = 0;

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipScoreDialog$5 */
    class C43005 implements OnClickListener {
        C43005() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4861);
            VoipScoreDialog.m22261b(VoipScoreDialog.this, 2);
            VoipScoreDialog.this.finish();
            AppMethodBeat.m2505o(4861);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipScoreDialog$3 */
    class C140673 implements OnDismissListener {
        C140673() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(4858);
            VoipScoreDialog.this.finish();
            AppMethodBeat.m2505o(4858);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipScoreDialog$2 */
    class C140682 implements C5662c {
        C140682() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(4857);
            VoipScoreDialog.m22261b(VoipScoreDialog.this, 1);
            VoipScoreDialog.this.finish();
            AppMethodBeat.m2505o(4857);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.ui.VoipScoreDialog$4 */
    class C140694 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.voip.ui.VoipScoreDialog$4$1 */
        class C140701 implements C24112c {
            C140701() {
            }

            public final void onShow() {
            }

            public final void onHide() {
                AppMethodBeat.m2504i(4859);
                VoipScoreDialog.this.finish();
                AppMethodBeat.m2505o(4859);
            }

            public final void cLd() {
            }
        }

        C140694() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(4860);
            VoipScoreDialog.m22261b(VoipScoreDialog.this, 3);
            C5670b.m8519a(VoipScoreDialog.this, null, VoipScoreDialog.this.getString(C25738R.string.f6s), new C140701());
            if (VoipScoreDialog.this.sWN != null) {
                VoipScoreDialog.this.sWN.dismiss();
            }
            AppMethodBeat.m2505o(4860);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VoipScoreDialog() {
        AppMethodBeat.m2504i(4862);
        AppMethodBeat.m2505o(4862);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(4863);
        super.onCreate(bundle);
        this.sPB = (VoipScoreState) getIntent().getParcelableExtra("key_score_state");
        if (this.sPB == null) {
            C26340b.m41916e("MicroMsg.VoipScoreDialog", "onCreate error, scoreState is null", new Object[0]);
            finish();
            AppMethodBeat.m2505o(4863);
            return;
        }
        this.sWL = (ViewGroup) View.inflate(this, 2130971031, null);
        this.sWM[0] = (ImageView) this.sWL.findViewById(2131828505);
        this.sWM[1] = (ImageView) this.sWL.findViewById(2131828506);
        this.sWM[2] = (ImageView) this.sWL.findViewById(2131828507);
        this.sWM[3] = (ImageView) this.sWL.findViewById(2131828508);
        this.sWM[4] = (ImageView) this.sWL.findViewById(2131828509);
        for (int i = 0; i < this.sWM.length; i++) {
            this.sWM[i].setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(4856);
                    VoipScoreDialog.m22260a(VoipScoreDialog.this, i);
                    AppMethodBeat.m2505o(4856);
                }
            });
        }
        C5659a c5659a = new C5659a(this);
        c5659a.mo11514al(this.sPB.sSM);
        c5659a.mo11524fo(this.sWL);
        c5659a.zQJ = getString(C25738R.string.f6t);
        c5659a.mo11522b(new C140682());
        c5659a.mo11526re(false);
        c5659a.mo11521b(new C140673());
        this.sWN = c5659a.gud;
        if (this.sWN != null) {
            this.sWN.show();
            AppMethodBeat.m2505o(4863);
            return;
        }
        finish();
        AppMethodBeat.m2505o(4863);
    }

    public final int getLayoutId() {
        return 2130971032;
    }

    /* renamed from: a */
    static /* synthetic */ void m22260a(VoipScoreDialog voipScoreDialog, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(4864);
        C26340b.m41917i("MicroMsg.VoipScoreDialog", "onScoreViewClick %s", Integer.valueOf(i));
        if (i >= 0 && i < voipScoreDialog.sWM.length) {
            while (i2 <= i) {
                voipScoreDialog.sWM[i2].setImageResource(C25738R.drawable.bjy);
                i2++;
            }
            for (i2 = i + 1; i2 < voipScoreDialog.sWM.length; i2++) {
                voipScoreDialog.sWM[i2].setImageResource(C25738R.drawable.bjx);
            }
            voipScoreDialog.sWO = i + 1;
        }
        if (voipScoreDialog.sWN != null) {
            voipScoreDialog.sWN.mo11487a((int) C25738R.string.f6u, new C140694());
            voipScoreDialog.sWN.mo11490b(C25738R.string.f9076or, new C43005());
        }
        AppMethodBeat.m2505o(4864);
    }

    /* renamed from: b */
    static /* synthetic */ void m22261b(VoipScoreDialog voipScoreDialog, int i) {
        AppMethodBeat.m2504i(4865);
        C26340b.m41917i("MicroMsg.VoipScoreDialog", "doScoreStat %s %s %s", Integer.valueOf(voipScoreDialog.sWO), Integer.valueOf(i), voipScoreDialog.sPB);
        C7060h.pYm.mo8381e(15684, Integer.valueOf(voipScoreDialog.sPB.nwu), Long.valueOf(voipScoreDialog.sPB.nwv), Integer.valueOf(i), Integer.valueOf(voipScoreDialog.sWO), Integer.valueOf(voipScoreDialog.sPB.sSN), Long.valueOf(voipScoreDialog.sPB.sSO), Long.valueOf(voipScoreDialog.sPB.nxT));
        AppMethodBeat.m2505o(4865);
    }
}
