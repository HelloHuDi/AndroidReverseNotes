package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.az.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import junit.framework.Assert;

public final class a implements f, com.tencent.mm.pluginsdk.b.a, b {
    private static boolean pxC = false;
    private Context context;
    private ProgressDialog ehJ;
    private com.tencent.mm.ui.base.preference.f ehK;
    private ad ehM;
    private boolean enable;
    private ProgressDialog fsh;
    private boolean pli;
    private boolean pxB;

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(68276);
        aVar.jX(false);
        AppMethodBeat.o(68276);
    }

    public a(Context context) {
        AppMethodBeat.i(68267);
        Assert.assertTrue(context != null);
        this.context = context;
        AppMethodBeat.o(68267);
    }

    public final boolean IO(String str) {
        boolean z = false;
        AppMethodBeat.i(68268);
        ab.d("MicroMsg.ContactWidgetQQMail", "handleEvent : key = ".concat(String.valueOf(str)));
        Intent intent;
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(68268);
            return false;
        } else if (str.equals("contact_info_qqmailhelper_view")) {
            intent = new Intent();
            if (this.pli) {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                com.tencent.mm.plugin.qqmail.a.a.gkE.d(intent, this.context);
            }
            ((Activity) this.context).finish();
            AppMethodBeat.o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_compose")) {
            intent = new Intent(this.context, ComposeUI.class);
            if (this.pli) {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
            } else {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.addFlags(67108864);
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            AppMethodBeat.o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_set_files_view")) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(bo.nullAsNil((String) g.RP().Ry().get(29, null))));
            intent2.putExtra("title", this.context.getString(R.string.ayx));
            intent2.putExtra("zoom", false);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            intent2.putExtra("vertical_scroll", false);
            com.tencent.mm.plugin.qqmail.a.a.gkE.i(intent2, this.context);
            AppMethodBeat.o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_recv_remind")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO(str);
            boolean isChecked = checkBoxPreference.isChecked();
            jY(isChecked);
            if (!isChecked) {
                z = true;
            }
            checkBoxPreference.uOT = z;
            AppMethodBeat.o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_clear_data")) {
            h.a(this.context, this.context.getString(R.string.ava), "", new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(68261);
                    ac.ccE();
                    AppMethodBeat.o(68261);
                }
            }, null);
            AppMethodBeat.o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_install")) {
            if (bo.h((Integer) g.RP().Ry().get(9, null)) == 0) {
                h.b(this.context, (int) R.string.ed5, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(68262);
                        com.tencent.mm.plugin.qqmail.a.a.gkE.g(null, a.this.context);
                        AppMethodBeat.o(68262);
                    }
                }, null);
                AppMethodBeat.o(68268);
                return true;
            }
            jX(true);
            AppMethodBeat.o(68268);
            return true;
        } else if (str.equals("contact_info_qqmailhelper_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(68263);
                    a.b(a.this);
                    AppMethodBeat.o(68263);
                }
            }, null);
            AppMethodBeat.o(68268);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetQQMail", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(68268);
            return false;
        }
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(68269);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.nc(adVar.field_username));
        g.RP().Ry().a(this);
        g.RO().eJo.a(24, (f) this);
        this.pli = z;
        this.ehM = adVar;
        this.ehK = fVar;
        fVar.addPreferencesFromResource(R.xml.a8);
        biW();
        AppMethodBeat.o(68269);
        return true;
    }

    private void biW() {
        boolean z;
        int i;
        boolean z2 = true;
        AppMethodBeat.i(68270);
        this.enable = (r.YK() & 1) == 0;
        if (bo.h((Integer) g.RP().Ry().get(17, null)) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.pxB = z;
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.ayy));
        if (this.enable) {
            i = 1;
        } else {
            i = 0;
        }
        helperHeaderPreference.sd(i);
        this.ehK.ce("contact_info_qqmailhelper_install", this.enable);
        com.tencent.mm.ui.base.preference.f fVar = this.ehK;
        String str = "contact_info_qqmailhelper_view";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_qqmailhelper_compose";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_qqmailhelper_recv_remind");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = this.pxB;
        }
        fVar = this.ehK;
        str = "contact_info_qqmailhelper_recv_remind";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_qqmailhelper_set_files_view";
        if ((this.enable & this.pxB) == 0) {
            z = true;
        } else {
            z = false;
        }
        fVar.ce(str, z);
        this.ehK.ce("contact_info_qqmailhelper_download_mgr_view", true);
        fVar = this.ehK;
        str = "contact_info_qqmailhelper_clear_data";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        com.tencent.mm.ui.base.preference.f fVar2 = this.ehK;
        String str2 = "contact_info_qqmailhelper_uninstall";
        if (this.enable) {
            z2 = false;
        }
        fVar2.ce(str2, z2);
        AppMethodBeat.o(68270);
    }

    private void jX(boolean z) {
        AppMethodBeat.i(68271);
        String string = z ? this.context.getString(R.string.e_c) : this.context.getString(R.string.e_k);
        Context context = this.context;
        this.context.getString(R.string.tz);
        this.fsh = h.b(context, string, true, null);
        pxC = true;
        jY(z);
        AppMethodBeat.o(68271);
    }

    public final boolean biV() {
        AppMethodBeat.i(68272);
        g.RP().Ry().b(this);
        g.RO().eJo.b(24, (f) this);
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        AppMethodBeat.o(68272);
        return true;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(68273);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetQQMail", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        if (nVar != g.RP().Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetQQMail", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(68273);
        } else if (g == 17 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.o(68273);
        } else {
            AppMethodBeat.o(68273);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private boolean jY(boolean z) {
        AppMethodBeat.i(68274);
        final m tVar = new com.tencent.mm.plugin.qqmail.b.t(z, "");
        if (!pxC) {
            this.ehJ = h.b(this.context, this.context.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(68264);
                    g.RO().eJo.c(tVar);
                    AppMethodBeat.o(68264);
                }
            });
        }
        g.RO().eJo.a(tVar, 0);
        AppMethodBeat.o(68274);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(68275);
        if (mVar.getType() != 24) {
            ab.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd : unExpected type = " + mVar.getType());
            AppMethodBeat.o(68275);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (this.fsh != null) {
            this.fsh.dismiss();
            this.fsh = null;
        }
        if (i == 0 && i2 == 0) {
            boolean z = ((com.tencent.mm.plugin.qqmail.b.t) mVar).cPT;
            g.RP().Ry().set(17, Integer.valueOf(z ? 1 : 2));
            if (pxC && bo.cv(this.context)) {
                int i3;
                if (z) {
                    g.RP().Ry().set(17, Integer.valueOf(1));
                }
                int YK = r.YK();
                if (z) {
                    i3 = YK & -2;
                } else {
                    i3 = YK | 1;
                }
                g.RP().Ry().set(34, Integer.valueOf(i3));
                ((j) g.K(j.class)).XL().c(new k("", "", "", "", "", "", "", "", i3, "", ""));
                com.tencent.mm.plugin.qqmail.a.a.gkF.BS();
                if (!z) {
                    ac.ccE();
                }
            }
            pxC = false;
            AppMethodBeat.o(68275);
            return;
        }
        CharSequence string;
        final boolean z2 = ((com.tencent.mm.plugin.qqmail.b.t) mVar).cPT;
        ab.e("MicroMsg.ContactWidgetQQMail", "NetSceneSwitchPushMail fail : errType = " + i + ", errCode = " + i2);
        if (i == 4) {
            switch (i2) {
                case -31:
                    ab.i("MicroMsg.ContactWidgetQQMail", "need second pass");
                    View inflate = View.inflate(this.context, R.layout.aq7, null);
                    final EditText editText = (EditText) inflate.findViewById(R.id.e79);
                    h.a(this.context, this.context.getString(R.string.ayw), inflate, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(68266);
                            final m tVar = new com.tencent.mm.plugin.qqmail.b.t(z2, com.tencent.mm.a.g.x(editText.getText().toString().trim().getBytes()));
                            g.RO().eJo.a(tVar, 0);
                            a aVar = a.this;
                            Context a = a.this.context;
                            a.this.context.getString(R.string.ayu);
                            aVar.ehJ = h.b(a, a.this.context.getString(R.string.un), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(68265);
                                    g.RO().eJo.c(tVar);
                                    AppMethodBeat.o(68265);
                                }
                            });
                            AppMethodBeat.o(68266);
                        }
                    });
                    AppMethodBeat.o(68275);
                    return;
                case -1:
                    ab.w("MicroMsg.ContactWidgetQQMail", "onSceneEnd, sys err");
                    break;
                default:
                    AppMethodBeat.o(68275);
                    return;
            }
        }
        if (pxC) {
            string = this.context.getString(z2 ? R.string.e__ : R.string.e_f);
        } else {
            string = this.context.getString(R.string.pr);
        }
        Toast.makeText(this.context, string, 1).show();
        pxC = false;
        AppMethodBeat.o(68275);
    }
}
