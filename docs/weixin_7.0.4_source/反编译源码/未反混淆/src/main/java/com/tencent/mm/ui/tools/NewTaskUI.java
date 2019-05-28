package com.tencent.mm.ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.u;

public class NewTaskUI extends MMBaseActivity implements f {
    static NewTaskUI zGD;
    private ProgressDialog ehJ = null;
    private c gAY = new c<jk>() {
        {
            AppMethodBeat.i(34915);
            this.xxI = jk.class.getName().hashCode();
            AppMethodBeat.o(34915);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(34916);
            jk jkVar = (jk) bVar;
            if (jkVar == null || jkVar.cEJ == null) {
                AppMethodBeat.o(34916);
                return false;
            }
            ab.i("MicroMsg.NewTaskUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", jkVar.cEJ.content, jkVar.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", jkVar.cEJ.content);
            intent.putExtra("key_disaster_url", jkVar.cEJ.url);
            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
            ah.getContext().startActivity(intent);
            AppMethodBeat.o(34916);
            return true;
        }
    };
    private SecurityImage gue = null;
    private g zGE = new g();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NewTaskUI() {
        AppMethodBeat.i(34922);
        AppMethodBeat.o(34922);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34923);
        super.onCreate(bundle);
        ab.i("MicroMsg.NewTaskUI", "onCreate :%d", Integer.valueOf(hashCode()));
        setContentView(R.layout.f7);
        aw.Rg().a(701, (f) this);
        aw.Rg().a(252, (f) this);
        zGD = this;
        final m qVar = new q(0, "", "", "");
        aw.Rg().a(qVar, 0);
        getString(R.string.tz);
        this.ehJ = h.b((Context) this, getString(R.string.cou), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(34917);
                aw.Rg().c(qVar);
                AppMethodBeat.o(34917);
            }
        });
        AppMethodBeat.o(34923);
    }

    public void onResume() {
        AppMethodBeat.i(34924);
        a.xxA.c(this.gAY);
        super.onResume();
        AppMethodBeat.o(34924);
    }

    public void onPause() {
        AppMethodBeat.i(34925);
        super.onPause();
        a.xxA.d(this.gAY);
        AppMethodBeat.o(34925);
    }

    public void onDestroy() {
        AppMethodBeat.i(34926);
        ab.i("MicroMsg.NewTaskUI", "onDestroy :%d", Integer.valueOf(hashCode()));
        if (equals(zGD)) {
            zGD = null;
        }
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (this.gue != null) {
            this.gue.dismiss();
        }
        aw.Rg().b(701, (f) this);
        aw.Rg().b(252, (f) this);
        super.onDestroy();
        AppMethodBeat.o(34926);
    }

    public static NewTaskUI dJR() {
        return zGD;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(34927);
        ab.i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (i == 4 && i2 == -3) {
            ab.i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", Boolean.valueOf(aw.RK()));
            if (u.a(zGD, i, i2, new Intent().setClass(zGD, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                AppMethodBeat.o(34927);
                return;
            }
        }
        if (i == 4 && (i2 == -6 || i2 == -311 || i2 == -310)) {
            if (mVar instanceof q) {
                q qVar = (q) mVar;
                this.zGE.gCL = qVar.getSecCodeType();
                this.zGE.gug = qVar.ajo();
                this.zGE.guh = qVar.ajn();
                this.zGE.gui = qVar.ajp();
                ab.i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.zGE.guh + " img len" + this.zGE.gug.length + " " + g.Mq());
            }
            if (this.gue == null) {
                this.gue = SecurityImage.a.a(this, this.zGE.gCL, this.zGE.gug, this.zGE.guh, this.zGE.gui, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34919);
                        ab.i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.this.zGE.guh + " img len" + NewTaskUI.this.zGE.gug.length + " " + g.Mq());
                        if (NewTaskUI.this.gue == null) {
                            ab.d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
                            AppMethodBeat.o(34919);
                            return;
                        }
                        final m qVar = new q(NewTaskUI.this.zGE.gCL, NewTaskUI.this.gue.getSecImgCode(), NewTaskUI.this.gue.getSecImgSid(), NewTaskUI.this.gue.getSecImgEncryptKey());
                        aw.Rg().a(qVar, 0);
                        NewTaskUI newTaskUI = NewTaskUI.this;
                        Context context = NewTaskUI.this;
                        NewTaskUI.this.getString(R.string.tz);
                        newTaskUI.ehJ = h.b(context, NewTaskUI.this.getString(R.string.cou), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(34918);
                                aw.Rg().c(qVar);
                                AppMethodBeat.o(34918);
                            }
                        });
                        AppMethodBeat.o(34919);
                    }
                }, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(34920);
                        if (NewTaskUI.zGD != null) {
                            NewTaskUI.zGD = null;
                            NewTaskUI.this.finish();
                        }
                        AppMethodBeat.o(34920);
                    }
                }, new OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        AppMethodBeat.i(34921);
                        NewTaskUI.this.gue = null;
                        AppMethodBeat.o(34921);
                    }
                }, this.zGE);
                AppMethodBeat.o(34927);
                return;
            }
            ab.d("MicroMsg.NewTaskUI", "imgSid:" + this.zGE.guh + " img len" + this.zGE.gug.length + " " + g.Mq());
            this.gue.b(this.zGE.gCL, this.zGE.gug, this.zGE.guh, this.zGE.gui);
            AppMethodBeat.o(34927);
            return;
        }
        zGD = null;
        finish();
        AppMethodBeat.o(34927);
    }
}
