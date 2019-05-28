package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.m.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.LauncherUI;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI extends MMBaseSelectContactUI {
    private List<String> elZ;
    private String talker = "";
    private boolean zpw = false;
    private boolean zpx = false;
    private c zpy = new c<ui>() {
        {
            AppMethodBeat.i(33967);
            this.xxI = ui.class.getName().hashCode();
            AppMethodBeat.o(33967);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(33968);
            switch (((ui) bVar).cQx.cAd) {
                case 7:
                    VoipAddressUI.this.finish();
                    break;
                case 8:
                    VoipAddressUI.this.finish();
                    break;
            }
            AppMethodBeat.o(33968);
            return false;
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoipAddressUI() {
        AppMethodBeat.i(33972);
        AppMethodBeat.o(33972);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(33973);
        super.onCreate(bundle);
        a.xxA.c(this.zpy);
        AppMethodBeat.o(33973);
    }

    public final void mO(int i) {
        AppMethodBeat.i(33974);
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) getContentLV().getAdapter().getItem(i);
        if (aVar == null) {
            AppMethodBeat.o(33974);
        } else if (aVar.ehM == null) {
            AppMethodBeat.o(33974);
        } else {
            this.talker = aVar.ehM.field_username;
            if (this.zpx) {
                cbm();
                AppMethodBeat.o(33974);
                return;
            }
            cbl();
            AppMethodBeat.o(33974);
        }
    }

    private void cbl() {
        AppMethodBeat.i(33975);
        ab.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bo.dpG(), this);
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            ui uiVar = new ui();
            uiVar.cQx.cAd = 5;
            uiVar.cQx.talker = this.talker;
            uiVar.cQx.context = this;
            int i = this.zpw ? 2 : 1;
            uiVar.cQx.cQs = 3;
            h.pYm.e(11033, Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0));
            a.xxA.m(uiVar);
            aqX();
            AppMethodBeat.o(33975);
            return;
        }
        AppMethodBeat.o(33975);
    }

    private void cbm() {
        AppMethodBeat.i(33976);
        ab.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")), bo.dpG(), this);
        if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.CAMERA", 19, "", "")) {
            ab.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bo.dpG(), this);
            if (com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.RECORD_AUDIO", 19, "", "")) {
                ui uiVar = new ui();
                uiVar.cQx.cAd = 5;
                uiVar.cQx.talker = this.talker;
                uiVar.cQx.context = this;
                int i = this.zpw ? 2 : 1;
                uiVar.cQx.cQs = 2;
                h.pYm.e(11033, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0));
                a.xxA.m(uiVar);
                aqX();
                AppMethodBeat.o(33976);
                return;
            }
            AppMethodBeat.o(33976);
            return;
        }
        AppMethodBeat.o(33976);
    }

    /* Access modifiers changed, original: protected|final */
    public final void Kh() {
        AppMethodBeat.i(33977);
        super.Kh();
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
        this.elZ.addAll(s.dIf());
        this.elZ.addAll(s.dIg());
        AppMethodBeat.o(33977);
    }

    /* Access modifiers changed, original: protected|final */
    public final o aoz() {
        AppMethodBeat.i(33978);
        c.a aVar = new c.a();
        aVar.zkR = true;
        aVar.zkQ = true;
        c cVar = new c(this, this.elZ, false, aVar);
        AppMethodBeat.o(33978);
        return cVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final m aoA() {
        AppMethodBeat.i(33979);
        q qVar = new q(this, this.elZ, false, this.scene);
        AppMethodBeat.o(33979);
        return qVar;
    }

    public static void hX(Context context) {
        int i = 0;
        AppMethodBeat.i(33980);
        boolean z = 1 == bo.getInt(g.Nu().getValue("VOIPCallType"), 0);
        Intent intent = new Intent(context, VoipAddressUI.class);
        intent.putExtra("Add_address_titile", context.getString(R.string.eu));
        intent.putExtra("voip_video", z);
        context.startActivity(intent);
        h hVar = h.pYm;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(1);
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        hVar.e(11034, objArr);
        AppMethodBeat.o(33980);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aox() {
        return true;
    }

    public final int[] bMP() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public void onDestroy() {
        AppMethodBeat.i(33981);
        a.xxA.d(this.zpy);
        super.onDestroy();
        AppMethodBeat.o(33981);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bMQ() {
        AppMethodBeat.i(33982);
        if (this.zpw) {
            Intent intent = new Intent(this, LauncherUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
        }
        aqX();
        finish();
        AppMethodBeat.o(33982);
    }

    /* Access modifiers changed, original: protected|final */
    public final String aoy() {
        AppMethodBeat.i(33983);
        String stringExtra = getIntent().getStringExtra("Add_address_titile");
        if (!bo.isNullOrNil(stringExtra)) {
            stringExtra = getString(R.string.eu);
        }
        AppMethodBeat.o(33983);
        return stringExtra;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aow() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(33984);
        if (iArr == null || iArr.length <= 0) {
            ab.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", Integer.valueOf(i), Long.valueOf(Thread.currentThread().getId()));
            AppMethodBeat.o(33984);
            return;
        }
        ab.i("MicroMsg.VoipAddressUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    cbm();
                    AppMethodBeat.o(33984);
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.string.dbs : R.string.dc0;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(i2), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(33969);
                            dialogInterface.dismiss();
                            VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(33969);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(33970);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(33970);
                        }
                    });
                }
                AppMethodBeat.o(33984);
                return;
            case 82:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.abx), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(33971);
                            VoipAddressUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            AppMethodBeat.o(33971);
                        }
                    }, null);
                    break;
                }
                cbl();
                AppMethodBeat.o(33984);
                return;
        }
        AppMethodBeat.o(33984);
    }
}
