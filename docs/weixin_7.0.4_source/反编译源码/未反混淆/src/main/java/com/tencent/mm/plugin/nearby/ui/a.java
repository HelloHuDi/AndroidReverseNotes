package com.tencent.mm.plugin.nearby.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.az.k;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements f, com.tencent.mm.pluginsdk.b.a, b {
    private static boolean oPT = true;
    private Context context;
    private com.tencent.mm.ui.base.preference.f ehK;
    private ad ehM;
    private c oPQ;
    private View oPR;
    private CheckBox oPS;
    private com.tencent.mm.ui.widget.a.c oPU = null;
    private p tipDialog;

    public a(Context context) {
        AppMethodBeat.i(55417);
        this.context = context;
        this.oPR = View.inflate(context, R.layout.a9s, null);
        this.oPS = (CheckBox) this.oPR.findViewById(R.id.cp8);
        this.oPS.setChecked(false);
        g.Rg().a(148, (f) this);
        AppMethodBeat.o(55417);
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(55418);
        ab.d("MicroMsg.ContactWidgetLBS", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(55418);
            return false;
        } else if (str.equals("contact_info_lbs_go_lbs")) {
            Boolean bool = (Boolean) g.RP().Ry().get(4103, null);
            if (bool == null || !bool.booleanValue()) {
                d.H(this.context, "nearby", ".ui.NearbyFriendsIntroUI");
            } else {
                bp aap = bp.aap();
                if (aap == null) {
                    d.H(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                } else {
                    String nullAsNil = bo.nullAsNil(aap.getProvince());
                    String nullAsNil2 = bo.nullAsNil(aap.getCity());
                    int i = aap.dtS;
                    if (nullAsNil.equals("") || nullAsNil2.equals("") || i == 0) {
                        d.H(this.context, "nearby", ".ui.NearbyPersonalInfoUI");
                    } else {
                        bool = (Boolean) g.RP().Ry().get(4104, null);
                        if (bool == null || !bool.booleanValue()) {
                            com.tencent.mm.bn.a.fy(this.context);
                            ((Activity) this.context).finish();
                        } else if (this.oPU == null) {
                            this.oPU = h.a(this.context, this.context.getString(R.string.tz), this.oPR, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(55412);
                                    g.RP().Ry().set(4104, Boolean.valueOf(!a.this.oPS.isChecked()));
                                    com.tencent.mm.bn.a.fy(a.this.context);
                                    ((Activity) a.this.context).finish();
                                    AppMethodBeat.o(55412);
                                }
                            }, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            this.oPU.show();
                        }
                    }
                }
            }
            AppMethodBeat.o(55418);
            return true;
        } else if (str.equals("contact_info_lbs_install")) {
            u(this.context, true);
            AppMethodBeat.o(55418);
            return true;
        } else if (str.equals("contact_info_lbs_clear_info")) {
            h.a(this.context, (int) R.string.d4j, (int) R.string.d4i, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(55414);
                    a.this.oPQ = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    g.Rg().a(a.this.oPQ, 0);
                    a aVar = a.this;
                    Context a = a.this.context;
                    a.this.context.getString(R.string.tz);
                    aVar.tipDialog = h.b(a, a.this.context.getString(R.string.d4m), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(55413);
                            g.Rg().c(a.this.oPQ);
                            AppMethodBeat.o(55413);
                        }
                    });
                    AppMethodBeat.o(55414);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(55418);
            return true;
        } else if (str.equals("contact_info_lbs_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(55411);
                    a.u(a.this.context, false);
                    AppMethodBeat.o(55411);
                }
            }, null);
            AppMethodBeat.o(55418);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetLBS", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(55418);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.i(55419);
        if ((r.YK() & 512) == 0) {
            AppMethodBeat.o(55419);
            return true;
        }
        AppMethodBeat.o(55419);
        return false;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(55420);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.nm(adVar.field_username));
        g.RP().Ry().a(this);
        ab.v("MicroMsg.ContactWidgetLBS", "listener added");
        this.ehM = adVar;
        this.ehK = fVar;
        oPT = true;
        fVar.addPreferencesFromResource(R.xml.z);
        biW();
        AppMethodBeat.o(55420);
        return true;
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(55421);
        boolean isOpen = isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.ax1));
        helperHeaderPreference.sd(isOpen ? 1 : 0);
        this.ehK.ce("contact_info_lbs_install", isOpen);
        com.tencent.mm.ui.base.preference.f fVar = this.ehK;
        String str = "contact_info_lbs_go_lbs";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_lbs_clear_info";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        com.tencent.mm.ui.base.preference.f fVar2 = this.ehK;
        String str2 = "contact_info_lbs_uninstall";
        if (isOpen) {
            z2 = false;
        }
        fVar2.ce(str2, z2);
        AppMethodBeat.o(55421);
    }

    public static void u(Context context, final boolean z) {
        AppMethodBeat.i(55422);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        oPT = z;
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        final AnonymousClass6 anonymousClass6 = new ak() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.i(55415);
                int YK = r.YK();
                if (z) {
                    i = YK & -513;
                } else {
                    i = YK | 512;
                }
                g.RP().Ry().set(34, Integer.valueOf(i));
                ((j) g.K(j.class)).XL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    g.RN().QU();
                    ((j) g.K(j.class)).bOo().axQ();
                    g.Rg().a(new c(2, 0.0f, 0.0f, 0, 0, "", ""), 0);
                }
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(55415);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(55416);
                if (b != null) {
                    b.dismiss();
                    anonymousClass6.sendEmptyMessage(0);
                }
                AppMethodBeat.o(55416);
            }
        }, 1500);
        AppMethodBeat.o(55422);
    }

    public final boolean biV() {
        AppMethodBeat.i(55423);
        g.RP().Ry().b(this);
        g.Rg().b(148, (f) this);
        com.tencent.mm.plugin.nearby.a.gkF.BS();
        AppMethodBeat.o(55423);
        return true;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(55424);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetLBS", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        if (nVar != g.RP().Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetLBS", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(55424);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.o(55424);
        } else {
            AppMethodBeat.o(55424);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(55425);
        if (this.oPQ == null && ((c) mVar).Ah() == 2) {
            AppMethodBeat.o(55425);
            return;
        }
        ab.i("MicroMsg.ContactWidgetLBS", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (mVar.getType() != 148) {
            AppMethodBeat.o(55425);
            return;
        }
        int i3;
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (i == 0 && i2 == 0) {
            i3 = R.string.d4l;
        } else {
            i3 = R.string.d4k;
        }
        if (((c) mVar).Ah() == 2 && oPT) {
            h.a(this.context, i3, (int) R.string.tz, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            this.oPQ = null;
        }
        AppMethodBeat.o(55425);
    }
}
