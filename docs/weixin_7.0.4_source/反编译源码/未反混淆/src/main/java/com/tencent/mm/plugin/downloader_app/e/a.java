package com.tencent.mm.plugin.downloader_app.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a implements com.tencent.mm.pluginsdk.b.a {
    Context context;
    private f ehK;
    private ad ehM;
    private boolean enable;
    private CheckBoxPreference kRl;
    private CheckBoxPreference kRm;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        AppMethodBeat.i(136322);
        this.ehK = fVar;
        this.ehM = adVar;
        fVar.addPreferencesFromResource(R.xml.u);
        this.kRl = (CheckBoxPreference) fVar.aqO("contact_info_top_downloader");
        this.kRm = (CheckBoxPreference) fVar.aqO("contact_info_not_disturb");
        biW();
        AppMethodBeat.o(136322);
        return true;
    }

    public final boolean biV() {
        return true;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(136323);
        Intent intent;
        if ("contact_info_go_to_downloader".equals(str)) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.ehM.field_username);
            intent.putExtra("finish_direct", true);
            d.f(this.context, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.o(136323);
            return true;
        } else if ("contact_info_downloader_manager".equals(str)) {
            ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).a(this.context, null, null);
            AppMethodBeat.o(136323);
            return true;
        } else if ("contact_info_common_problem".equals(str)) {
            intent = new Intent();
            intent.putExtra("KPublisherId", "custom_menu");
            intent.putExtra("pre_username", this.ehM.field_username);
            intent.putExtra("prePublishId", "custom_menu");
            intent.putExtra("preUsername", this.ehM.field_username);
            intent.putExtra("preChatName", this.ehM.field_username);
            intent.putExtra("preChatTYPE", u.ad(this.ehM.field_username, this.ehM.field_username));
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            intent.putExtra("geta8key_username", this.ehM.field_username);
            intent.putExtra("from_scence", 1);
            d.b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(136323);
            return true;
        } else if ("contact_info_top_downloader".equals(str)) {
            if (this.kRl.isChecked()) {
                t.w(this.ehM.field_username, true);
            } else {
                t.x(this.ehM.field_username, true);
            }
            AppMethodBeat.o(136323);
            return true;
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.kRm.isChecked()) {
                t.o(this.ehM);
            } else {
                t.p(this.ehM);
            }
            AppMethodBeat.o(136323);
            return true;
        } else if ("contact_info_clear_data".equals(str)) {
            h.d(this.context, this.context.getString(R.string.av9), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(136316);
                    bf.oD("downloaderapp");
                    AppMethodBeat.o(136316);
                }
            }, null);
            AppMethodBeat.o(136323);
            return true;
        } else if ("contact_info_downloader_install".equals(str)) {
            s(this.context, true);
            AppMethodBeat.o(136323);
            return true;
        } else if ("contact_info_downloader_uninstall".equals(str)) {
            if (((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).bix()) {
                h.d(this.context, this.context.getString(R.string.b7t), this.context.getString(R.string.b7u), this.context.getString(R.string.b7s), this.context.getString(R.string.b7e), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(136317);
                        g.K(com.tencent.mm.plugin.downloader_app.a.d.class);
                        a.this.s(a.this.context, false);
                        AppMethodBeat.o(136317);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(136318);
                        ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).a(a.this.context, null, null);
                        AppMethodBeat.o(136318);
                    }
                });
            } else {
                h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(136319);
                        g.K(com.tencent.mm.plugin.downloader_app.a.d.class);
                        a.this.s(a.this.context, false);
                        AppMethodBeat.o(136319);
                    }
                }, null);
            }
            AppMethodBeat.o(136323);
            return true;
        } else {
            AppMethodBeat.o(136323);
            return false;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    /* Access modifiers changed, original: final */
    public final void biW() {
        boolean z;
        AppMethodBeat.i(136324);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.b79));
        this.enable = r.YZ();
        helperHeaderPreference.sd(this.enable ? 1 : 0);
        this.ehK.ce("contact_info_downloader_install", this.enable);
        f fVar = this.ehK;
        String str = "contact_info_downloader_uninstall";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_go_to_downloader";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_downloader_manager";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        this.ehK.ce("contact_info_common_problem", true);
        fVar = this.ehK;
        str = "contact_info_top_downloader";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_not_disturb";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_clear_data";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        if (this.enable) {
            if (((j) g.K(j.class)).XR().aph(this.ehM.field_username)) {
                this.kRl.uOT = true;
            } else {
                this.kRl.uOT = false;
            }
            if (this.ehM.DX()) {
                this.kRm.uOT = true;
                AppMethodBeat.o(136324);
                return;
            }
            this.kRm.uOT = false;
        }
        AppMethodBeat.o(136324);
    }

    /* Access modifiers changed, original: final */
    public final void s(final Context context, final boolean z) {
        AppMethodBeat.i(136325);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(136321);
                boolean z = z;
                int YK = r.YK();
                if (z) {
                    YK &= -134217729;
                } else {
                    YK |= 134217728;
                }
                g.RP().Ry().set(34, Integer.valueOf(YK));
                bko bko = new bko();
                bko.vCi = 134217728;
                bko.wNJ = z ? 0 : 1;
                ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(39, bko));
                if (!z) {
                    bf.oD("downloaderapp");
                    ((j) g.K(j.class)).XR().aoX("downloaderapp");
                }
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(136320);
                        a.this.biW();
                        b.dismiss();
                        if (z) {
                            ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).biy();
                            Bundle bundleExtra = ((Activity) context).getIntent().getBundleExtra("download_params");
                            if (bundleExtra != null) {
                                ((com.tencent.mm.plugin.downloader_app.a.d) g.K(com.tencent.mm.plugin.downloader_app.a.d.class)).a(context, new Intent().putExtras(bundleExtra), null);
                            }
                        }
                        AppMethodBeat.o(136320);
                    }
                }, 1000);
                AppMethodBeat.o(136321);
            }
        });
        AppMethodBeat.o(136325);
    }
}
