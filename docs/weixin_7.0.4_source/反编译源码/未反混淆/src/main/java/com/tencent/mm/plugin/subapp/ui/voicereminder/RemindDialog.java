package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.ao.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.a.c;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemindDialog extends Activity {
    private static boolean cui = false;
    private static List<String> svG = new ArrayList();
    private c gud;
    private ak handler = new ak();
    private List<String> svF = new ArrayList();
    private d svH = new d() {
        public final void p(String str, long j) {
            AppMethodBeat.i(25559);
            ab.d("MicroMsg.RemindDialog", "onVoiceRemind ".concat(String.valueOf(str)));
            RemindDialog.this.svF.add(str);
            RemindDialog.b(RemindDialog.this);
            AppMethodBeat.o(25559);
        }
    };
    private String talker = "";

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public RemindDialog() {
        AppMethodBeat.i(25564);
        AppMethodBeat.o(25564);
    }

    static /* synthetic */ void b(RemindDialog remindDialog) {
        AppMethodBeat.i(25570);
        remindDialog.cDQ();
        AppMethodBeat.o(25570);
    }

    static {
        AppMethodBeat.i(25571);
        AppMethodBeat.o(25571);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25565);
        super.onCreate(bundle);
        requestWindowFeature(1);
        c.a aVar = new c.a(this);
        aVar.PV(R.string.f34);
        aVar.asE(" ");
        aVar.Qc(R.string.f31).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(25560);
                com.tencent.mm.plugin.subapp.c.d cDD = com.tencent.mm.plugin.subapp.c.d.cDD();
                if (cDD != null) {
                    cDD.ot(RemindDialog.this.talker);
                }
                if (t.nw(aw.getNotification().IG())) {
                    RemindDialog.this.finish();
                    AppMethodBeat.o(25560);
                    return;
                }
                b.gkE.d(new Intent().putExtra("Chat_User", RemindDialog.this.talker), RemindDialog.this);
                RemindDialog.this.finish();
                AppMethodBeat.o(25560);
            }
        });
        aVar.Qd(R.string.f33).b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(25561);
                com.tencent.mm.plugin.subapp.c.d cDD = com.tencent.mm.plugin.subapp.c.d.cDD();
                if (cDD != null) {
                    cDD.ot(RemindDialog.this.talker);
                }
                RemindDialog.this.finish();
                AppMethodBeat.o(25561);
            }
        });
        aVar.a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(25562);
                RemindDialog.this.finish();
                AppMethodBeat.o(25562);
            }
        });
        this.talker = getIntent().getStringExtra("_RemindDialog_User");
        String stringExtra = getIntent().getStringExtra("_RemindDialog_Remind");
        this.svF.clear();
        this.svF.add(stringExtra);
        for (String stringExtra2 : svG) {
            this.svF.add(stringExtra2);
        }
        this.gud = aVar.aMb();
        this.gud.setCanceledOnTouchOutside(false);
        this.gud.show();
        cDQ();
        AppMethodBeat.o(25565);
    }

    private void cDQ() {
        AppMethodBeat.i(25566);
        this.handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(25563);
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : RemindDialog.this.svF) {
                    if (bo.isNullOrNil(str)) {
                        stringBuffer.append("\n\n");
                    } else {
                        stringBuffer.append(str + "\n\n");
                    }
                }
                if (RemindDialog.this.gud != null) {
                    RemindDialog.this.gud.setMessage(stringBuffer);
                }
                AppMethodBeat.o(25563);
            }
        });
        AppMethodBeat.o(25566);
    }

    public void onResume() {
        AppMethodBeat.i(25567);
        cui = true;
        com.tencent.mm.plugin.subapp.c.d cDD = com.tencent.mm.plugin.subapp.c.d.cDD();
        if (cDD != null) {
            cDD.a(this.svH);
        }
        super.onResume();
        AppMethodBeat.o(25567);
    }

    public void onPause() {
        AppMethodBeat.i(25568);
        cui = false;
        com.tencent.mm.plugin.subapp.c.d cDD = com.tencent.mm.plugin.subapp.c.d.cDD();
        if (cDD != null) {
            cDD.b(this.svH);
        }
        super.onPause();
        AppMethodBeat.o(25568);
    }

    public static void y(Context context, String str, String str2) {
        AppMethodBeat.i(25569);
        ab.d("MicroMsg.RemindDialog", "show " + cui + " remind " + str2);
        if (cui) {
            svG.add(str2);
            AppMethodBeat.o(25569);
            return;
        }
        svG.clear();
        cui = true;
        Intent intent;
        if (aw.Rg().foreground) {
            intent = new Intent(context, RemindDialog.class);
            intent.putExtra("_RemindDialog_User", str);
            intent.putExtra("_RemindDialog_Remind", str2);
            intent.setFlags(603979776);
            intent.addFlags(268435456);
            context.startActivity(intent);
            AppMethodBeat.o(25569);
            return;
        }
        intent = new Intent(context, RemindDialog.class);
        intent.putExtra("_RemindDialog_User", str);
        intent.putExtra("_RemindDialog_Remind", str2);
        intent.setFlags(604012544);
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.o(25569);
    }
}
