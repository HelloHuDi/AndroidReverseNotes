package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class LoginVoiceUI extends LoginHistoryUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125075);
        super.onCreate(bundle);
        if (this.gCl) {
            AppMethodBeat.o(125075);
            return;
        }
        this.gwX = 1;
        this.gCe.setVisibility(0);
        this.gBM.setVisibility(0);
        LayoutParams layoutParams = (LayoutParams) this.gBL.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.leftMargin = 0;
        this.gBL.setLayoutParams(layoutParams);
        findViewById(R.id.cqo).setEnabled(false);
        ((TextView) findViewById(R.id.cqp)).setTextColor(getResources().getColorStateList(R.color.a8m));
        ((TextView) findViewById(R.id.cqp)).setBackgroundResource(getResources().getColor(R.color.a3p));
        this.gBM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(125073);
                h.pYm.e(11557, Integer.valueOf(2));
                Intent intent = new Intent();
                intent.putExtra("Kusername", LoginVoiceUI.this.gCb);
                intent.putExtra("kscene_type", 1);
                d.b(LoginVoiceUI.this.mController.ylL, "voiceprint", ".ui.VoiceLoginUI", intent, (int) WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                AppMethodBeat.o(125073);
            }
        });
        AppMethodBeat.o(125075);
    }

    public final boolean aqY() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final void aqU() {
        int i = -1;
        AppMethodBeat.i(125076);
        super.aqU();
        aqV();
        final m qVar = new q(this.gCb, this.gCk, "", 0);
        qVar.tr(this.gCk);
        String str = "MicroMsg.LoginVoiceUI";
        String str2 = "summerauth mAuthPwd len:%d content[%s] logindata.rawPsw len:%d content[%s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.gCk == null ? -1 : this.gCk.length());
        objArr[1] = bo.anv(this.gCk);
        if (this.gBT.guf != null) {
            i = this.gBT.guf.length();
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = bo.anv(this.gBT.guf);
        ab.d(str, str2, objArr);
        getString(R.string.tz);
        this.ehJ = com.tencent.mm.ui.base.h.b((Context) this, getString(R.string.cou), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(125074);
                g.Rg().c(qVar);
                LoginVoiceUI.this.aqW();
                AppMethodBeat.o(125074);
            }
        });
        g.Rg().a(qVar, 0);
        AppMethodBeat.o(125076);
    }
}
