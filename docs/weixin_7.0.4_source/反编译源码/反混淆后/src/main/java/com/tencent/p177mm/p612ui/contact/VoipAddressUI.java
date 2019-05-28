package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.contact.C36246c.C30666a;
import com.tencent.p177mm.p612ui.contact.p625a.C5445a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.permission.C35805b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.contact.VoipAddressUI */
public class VoipAddressUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private String talker = "";
    private boolean zpw = false;
    private boolean zpx = false;
    private C4884c zpy = new C158121();

    /* renamed from: com.tencent.mm.ui.contact.VoipAddressUI$4 */
    class C158104 implements OnClickListener {
        C158104() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(33971);
            VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(33971);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.VoipAddressUI$3 */
    class C158113 implements OnClickListener {
        C158113() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(33970);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(33970);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.VoipAddressUI$1 */
    class C158121 extends C4884c<C26250ui> {
        C158121() {
            AppMethodBeat.m2504i(33967);
            this.xxI = C26250ui.class.getName().hashCode();
            AppMethodBeat.m2505o(33967);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(33968);
            switch (((C26250ui) c4883b).cQx.cAd) {
                case 7:
                    VoipAddressUI.this.finish();
                    break;
                case 8:
                    VoipAddressUI.this.finish();
                    break;
            }
            AppMethodBeat.m2505o(33968);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.VoipAddressUI$2 */
    class C158132 implements OnClickListener {
        C158132() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(33969);
            dialogInterface.dismiss();
            VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(33969);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public VoipAddressUI() {
        AppMethodBeat.m2504i(33972);
        AppMethodBeat.m2505o(33972);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(33973);
        super.onCreate(bundle);
        C4879a.xxA.mo10052c(this.zpy);
        AppMethodBeat.m2505o(33973);
    }

    /* renamed from: mO */
    public final void mo7859mO(int i) {
        AppMethodBeat.m2504i(33974);
        C5445a c5445a = (C5445a) getContentLV().getAdapter().getItem(i);
        if (c5445a == null) {
            AppMethodBeat.m2505o(33974);
        } else if (c5445a.ehM == null) {
            AppMethodBeat.m2505o(33974);
        } else {
            this.talker = c5445a.ehM.field_username;
            if (this.zpx) {
                cbm();
                AppMethodBeat.m2505o(33974);
                return;
            }
            cbl();
            AppMethodBeat.m2505o(33974);
        }
    }

    private void cbl() {
        AppMethodBeat.m2504i(33975);
        C4990ab.m7417i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 82, "", "")), C5046bo.dpG(), this);
        if (C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            C26250ui c26250ui = new C26250ui();
            c26250ui.cQx.cAd = 5;
            c26250ui.cQx.talker = this.talker;
            c26250ui.cQx.context = this;
            int i = this.zpw ? 2 : 1;
            c26250ui.cQx.cQs = 3;
            C7060h.pYm.mo8381e(11033, Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0));
            C4879a.xxA.mo10055m(c26250ui);
            aqX();
            AppMethodBeat.m2505o(33975);
            return;
        }
        AppMethodBeat.m2505o(33975);
    }

    private void cbm() {
        AppMethodBeat.m2504i(33976);
        C4990ab.m7417i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.CAMERA", 19, "", "")), C5046bo.dpG(), this);
        if (C35805b.m58707a(this, "android.permission.CAMERA", 19, "", "")) {
            C4990ab.m7417i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 19, "", "")), C5046bo.dpG(), this);
            if (C35805b.m58707a(this, "android.permission.RECORD_AUDIO", 19, "", "")) {
                C26250ui c26250ui = new C26250ui();
                c26250ui.cQx.cAd = 5;
                c26250ui.cQx.talker = this.talker;
                c26250ui.cQx.context = this;
                int i = this.zpw ? 2 : 1;
                c26250ui.cQx.cQs = 2;
                C7060h.pYm.mo8381e(11033, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0));
                C4879a.xxA.mo10055m(c26250ui);
                aqX();
                AppMethodBeat.m2505o(33976);
                return;
            }
            AppMethodBeat.m2505o(33976);
            return;
        }
        AppMethodBeat.m2505o(33976);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Kh */
    public final void mo7850Kh() {
        AppMethodBeat.m2504i(33977);
        super.mo7850Kh();
        String stringExtra = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
        this.zpx = getIntent().getBooleanExtra("voip_video", true);
        if (stringExtra != null) {
            this.zpw = true;
            if (stringExtra.equals("launch_type_voip")) {
                this.zpx = true;
            } else if (stringExtra.equals("launch_type_voip_audio")) {
                this.zpx = false;
            }
        }
        this.elZ = new ArrayList();
        this.elZ.addAll(C15830s.dIf());
        this.elZ.addAll(C15830s.dIg());
        AppMethodBeat.m2505o(33977);
    }

    /* Access modifiers changed, original: protected|final */
    public final C40845o aoz() {
        AppMethodBeat.m2504i(33978);
        C30666a c30666a = new C30666a();
        c30666a.zkR = true;
        c30666a.zkQ = true;
        C36246c c36246c = new C36246c(this, this.elZ, false, c30666a);
        AppMethodBeat.m2505o(33978);
        return c36246c;
    }

    /* Access modifiers changed, original: protected|final */
    public final C36877m aoA() {
        AppMethodBeat.m2504i(33979);
        C23923q c23923q = new C23923q(this, this.elZ, false, this.scene);
        AppMethodBeat.m2505o(33979);
        return c23923q;
    }

    /* renamed from: hX */
    public static void m24164hX(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(33980);
        boolean z = 1 == C5046bo.getInt(C26373g.m41964Nu().getValue("VOIPCallType"), 0);
        Intent intent = new Intent(context, VoipAddressUI.class);
        intent.putExtra("Add_address_titile", context.getString(C25738R.string.f8782eu));
        intent.putExtra("voip_video", z);
        context.startActivity(intent);
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(1);
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        c7060h.mo8381e(11034, objArr);
        AppMethodBeat.m2505o(33980);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return true;
    }

    public final int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(33981);
        C4879a.xxA.mo10053d(this.zpy);
        super.onDestroy();
        AppMethodBeat.m2505o(33981);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bMQ() {
        AppMethodBeat.m2504i(33982);
        if (this.zpw) {
            Intent intent = new Intent(this, LauncherUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
        }
        aqX();
        finish();
        AppMethodBeat.m2505o(33982);
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        AppMethodBeat.m2504i(33983);
        String stringExtra = getIntent().getStringExtra("Add_address_titile");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            stringExtra = getString(C25738R.string.f8782eu);
        }
        AppMethodBeat.m2505o(33983);
        return stringExtra;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(33984);
        if (iArr == null || iArr.length <= 0) {
            C4990ab.m7417i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.m2505o(33984);
            return;
        }
        C4990ab.m7417i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    cbm();
                    AppMethodBeat.m2505o(33984);
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? C25738R.string.dbs : C25738R.string.dc0;
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(i2), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C158132(), new C158113());
                }
                AppMethodBeat.m2505o(33984);
                return;
            case 82:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.abx), false, new C158104(), null);
                    break;
                }
                cbl();
                AppMethodBeat.m2505o(33984);
                return;
        }
        AppMethodBeat.m2505o(33984);
    }
}
