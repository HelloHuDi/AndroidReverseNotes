package com.tencent.p177mm.plugin.subapp.p537ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C26415ao.C18609d;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.subapp.C24837b;
import com.tencent.p177mm.plugin.subapp.p1039c.C41315d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog */
public class RemindDialog extends Activity {
    private static boolean cui = false;
    private static List<String> svG = new ArrayList();
    private C5653c gud;
    private C7306ak handler = new C7306ak();
    private List<String> svF = new ArrayList();
    private C18609d svH = new C223581();
    private String talker = "";

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog$2 */
    class C139202 implements OnClickListener {
        C139202() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25560);
            C41315d cDD = C41315d.cDD();
            if (cDD != null) {
                cDD.mo44189ot(RemindDialog.this.talker);
            }
            if (C1855t.m3954nw(C9638aw.getNotification().mo41567IG())) {
                RemindDialog.this.finish();
                AppMethodBeat.m2505o(25560);
                return;
            }
            C24837b.gkE.mo38915d(new Intent().putExtra("Chat_User", RemindDialog.this.talker), RemindDialog.this);
            RemindDialog.this.finish();
            AppMethodBeat.m2505o(25560);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog$4 */
    class C223574 implements OnDismissListener {
        C223574() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(25562);
            RemindDialog.this.finish();
            AppMethodBeat.m2505o(25562);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog$1 */
    class C223581 implements C18609d {
        C223581() {
        }

        /* renamed from: p */
        public final void mo33872p(String str, long j) {
            AppMethodBeat.m2504i(25559);
            C4990ab.m7410d("MicroMsg.RemindDialog", "onVoiceRemind ".concat(String.valueOf(str)));
            RemindDialog.this.svF.add(str);
            RemindDialog.m34058b(RemindDialog.this);
            AppMethodBeat.m2505o(25559);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog$3 */
    class C223593 implements OnClickListener {
        C223593() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(25561);
            C41315d cDD = C41315d.cDD();
            if (cDD != null) {
                cDD.mo44189ot(RemindDialog.this.talker);
            }
            RemindDialog.this.finish();
            AppMethodBeat.m2505o(25561);
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog$5 */
    class C223605 implements Runnable {
        C223605() {
        }

        public final void run() {
            AppMethodBeat.m2504i(25563);
            StringBuffer stringBuffer = new StringBuffer();
            for (String str : RemindDialog.this.svF) {
                if (C5046bo.isNullOrNil(str)) {
                    stringBuffer.append("\n\n");
                } else {
                    stringBuffer.append(str + "\n\n");
                }
            }
            if (RemindDialog.this.gud != null) {
                RemindDialog.this.gud.setMessage(stringBuffer);
            }
            AppMethodBeat.m2505o(25563);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public RemindDialog() {
        AppMethodBeat.m2504i(25564);
        AppMethodBeat.m2505o(25564);
    }

    /* renamed from: b */
    static /* synthetic */ void m34058b(RemindDialog remindDialog) {
        AppMethodBeat.m2504i(25570);
        remindDialog.cDQ();
        AppMethodBeat.m2505o(25570);
    }

    static {
        AppMethodBeat.m2504i(25571);
        AppMethodBeat.m2505o(25571);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25565);
        super.onCreate(bundle);
        requestWindowFeature(1);
        C5652a c5652a = new C5652a(this);
        c5652a.mo11446PV(C25738R.string.f34);
        c5652a.asE(" ");
        c5652a.mo11453Qc(C25738R.string.f31).mo11457a(new C139202());
        c5652a.mo11454Qd(C25738R.string.f33).mo11476b(new C223593());
        c5652a.mo11458a(new C223574());
        this.talker = getIntent().getStringExtra("_RemindDialog_User");
        String stringExtra = getIntent().getStringExtra("_RemindDialog_Remind");
        this.svF.clear();
        this.svF.add(stringExtra);
        for (String stringExtra2 : svG) {
            this.svF.add(stringExtra2);
        }
        this.gud = c5652a.aMb();
        this.gud.setCanceledOnTouchOutside(false);
        this.gud.show();
        cDQ();
        AppMethodBeat.m2505o(25565);
    }

    private void cDQ() {
        AppMethodBeat.m2504i(25566);
        this.handler.post(new C223605());
        AppMethodBeat.m2505o(25566);
    }

    public void onResume() {
        AppMethodBeat.m2504i(25567);
        cui = true;
        C41315d cDD = C41315d.cDD();
        if (cDD != null) {
            cDD.mo44186a(this.svH);
        }
        super.onResume();
        AppMethodBeat.m2505o(25567);
    }

    public void onPause() {
        AppMethodBeat.m2504i(25568);
        cui = false;
        C41315d cDD = C41315d.cDD();
        if (cDD != null) {
            cDD.mo44187b(this.svH);
        }
        super.onPause();
        AppMethodBeat.m2505o(25568);
    }

    /* renamed from: y */
    public static void m34061y(Context context, String str, String str2) {
        AppMethodBeat.m2504i(25569);
        C4990ab.m7410d("MicroMsg.RemindDialog", "show " + cui + " remind " + str2);
        if (cui) {
            svG.add(str2);
            AppMethodBeat.m2505o(25569);
            return;
        }
        svG.clear();
        cui = true;
        Intent intent;
        if (C9638aw.m17182Rg().foreground) {
            intent = new Intent(context, RemindDialog.class);
            intent.putExtra("_RemindDialog_User", str);
            intent.putExtra("_RemindDialog_Remind", str2);
            intent.setFlags(603979776);
            intent.addFlags(268435456);
            context.startActivity(intent);
            AppMethodBeat.m2505o(25569);
            return;
        }
        intent = new Intent(context, RemindDialog.class);
        intent.putExtra("_RemindDialog_User", str);
        intent.putExtra("_RemindDialog_Remind", str2);
        intent.setFlags(604012544);
        intent.addFlags(268435456);
        context.startActivity(intent);
        AppMethodBeat.m2505o(25569);
    }
}
