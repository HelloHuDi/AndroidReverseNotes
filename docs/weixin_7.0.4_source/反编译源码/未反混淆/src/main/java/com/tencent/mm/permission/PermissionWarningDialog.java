package com.tencent.mm.permission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.e;

public class PermissionWarningDialog extends MMBaseActivity {
    private OnCancelListener Ue = new OnCancelListener() {
        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(16646);
            PermissionWarningDialog.this.finish();
            AppMethodBeat.o(16646);
        }
    };
    private c ggF = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PermissionWarningDialog() {
        AppMethodBeat.i(16650);
        AppMethodBeat.o(16650);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(16651);
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (!anB()) {
            finish();
        }
        AppMethodBeat.o(16651);
    }

    public void onResume() {
        AppMethodBeat.i(16652);
        super.onResume();
        y.activateBroadcast(true);
        AppMethodBeat.o(16652);
    }

    /* Access modifiers changed, original: protected */
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(16653);
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ggF != null) {
            this.ggF.dismiss();
            this.ggF = null;
        }
        if (!anB()) {
            finish();
        }
        AppMethodBeat.o(16653);
    }

    public void onPause() {
        AppMethodBeat.i(16654);
        super.onPause();
        y.activateBroadcast(false);
        AppMethodBeat.o(16654);
    }

    private boolean anB() {
        AppMethodBeat.i(16655);
        if (getIntent() == null) {
            ab.e("MicroMsg.PermissionWarningDialog", "Intent is null");
            AppMethodBeat.o(16655);
            return false;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            ab.e("MicroMsg.PermissionWarningDialog", "invalid params");
            AppMethodBeat.o(16655);
            return false;
        }
        int i = extras.getInt("warning_type", 0);
        a aVar;
        if (1 == i) {
            aVar = new a(this);
            aVar.asD(extras.getString("warning_title"));
            aVar.asE(extras.getString("warning_content"));
            aVar.Qc(R.string.r4).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(16647);
                    PermissionWarningDialog.this.finish();
                    AppMethodBeat.o(16647);
                }
            });
            aVar.f(this.Ue);
            this.ggF = aVar.aMb();
            this.ggF.setCanceledOnTouchOutside(false);
            this.ggF.show();
        } else if (2 == i) {
            aVar = new a(this);
            extras.getBoolean("warning_filter", false);
            extras.getBoolean("warning_due2Exception", false);
            aVar.PV(R.string.sm);
            aVar.asE(getString(R.string.sh));
            aVar.Qc(R.string.sb).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(16648);
                    PermissionWarningDialog.this.finish();
                    AppMethodBeat.o(16648);
                }
            });
            aVar.f(this.Ue);
            this.ggF = aVar.aMb();
            this.ggF.setCanceledOnTouchOutside(false);
            this.ggF.show();
        } else if (3 == i) {
            e.a aVar2 = new e.a(this);
            aVar2.re(false);
            e.a asL = aVar2.asL(getString(R.string.rl));
            asL.zQK = getString(R.string.r6);
            asL.zQJ = getString(R.string.rm);
            asL.c(new e.c() {
                public final void d(boolean z, String str) {
                    AppMethodBeat.i(16649);
                    if (z) {
                        ab.i("MicroMsg.PermissionWarningDialog", "set MicroPhone unmute.");
                        ((AudioManager) ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).setMicrophoneMute(false);
                    }
                    PermissionWarningDialog.this.finish();
                    AppMethodBeat.o(16649);
                }
            }).show();
        } else {
            AppMethodBeat.o(16655);
            return false;
        }
        AppMethodBeat.o(16655);
        return true;
    }

    public static void b(Context context, boolean z, boolean z2) {
        AppMethodBeat.i(16656);
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 2);
        intent.putExtra("warning_filter", z);
        intent.putExtra("warning_due2Exception", z2);
        intent.addFlags(805306368);
        context.startActivity(intent);
        AppMethodBeat.o(16656);
    }

    public static void ci(Context context) {
        AppMethodBeat.i(16657);
        Intent intent = new Intent(context, PermissionWarningDialog.class);
        intent.putExtra("warning_type", 3);
        intent.addFlags(805306368);
        context.startActivity(intent);
        AppMethodBeat.o(16657);
    }
}
