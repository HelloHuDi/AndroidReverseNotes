package com.tencent.mm.wallet_core.c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.vr;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class k {
    public a Afp;
    e Afq;
    c<vr> Afr = new c<vr>() {
        {
            AppMethodBeat.i(49041);
            this.xxI = vr.class.getName().hashCode();
            AppMethodBeat.o(49041);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(49042);
            ab.i("MicroMsg.JumpRemind", "WebViewUIDestroyEvent close");
            k.this.Afr.dead();
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(49040);
                    if (!k.this.ctn) {
                        k.this.ctn = true;
                        k.this.Afq.cMY();
                    }
                    AppMethodBeat.o(49040);
                }
            }, 200);
            AppMethodBeat.o(49042);
            return false;
        }
    };
    public String cEh;
    boolean ctn = false;
    public String nZb;
    public String nZc;
    c<vw> ons = new c<vw>() {
        {
            AppMethodBeat.i(49038);
            this.xxI = vw.class.getName().hashCode();
            AppMethodBeat.o(49038);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(49039);
            vw vwVar = (vw) bVar;
            ab.i("MicroMsg.JumpRemind", "WxPayGdprResultEvent result");
            k.this.ctn = true;
            if (vwVar.cTd.cBp == "agree_privacy") {
                k.this.Afq.cMX();
            } else {
                k.this.Afq.cMY();
            }
            k.this.ons.dead();
            AppMethodBeat.o(49039);
            return false;
        }
    };
    public String title;
    public int ttd;
    public boolean wAV;

    public static class a {
        public String csB;
        public String path;
        public String tff;
        public int type;
        public String wTe;
    }

    public final boolean dNM() {
        if (this.ttd == 1) {
            return true;
        }
        return false;
    }

    public k() {
        AppMethodBeat.i(49052);
        AppMethodBeat.o(49052);
    }

    public static k aS(JSONObject jSONObject) {
        AppMethodBeat.i(49053);
        try {
            ab.i("MicroMsg.JumpRemind", "feed %s", jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("bindquerynew_resp");
            if (optJSONObject == null) {
                optJSONObject = jSONObject;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("bindqueryresp");
            if (optJSONObject2 != null) {
                optJSONObject = optJSONObject2;
            }
            optJSONObject2 = optJSONObject.optJSONObject("jumpRemind");
            if (optJSONObject2 == null) {
                optJSONObject2 = optJSONObject.optJSONObject("jump_remind");
            }
            if (optJSONObject2 == null) {
                optJSONObject = optJSONObject.optJSONObject("jump_remind_info");
            } else {
                optJSONObject = optJSONObject2;
            }
            if (optJSONObject != null) {
                k kVar = new k();
                kVar.ttd = optJSONObject.optInt("jump_type");
                kVar.wAV = optJSONObject.optBoolean("is_pop_up_windows");
                kVar.cEh = optJSONObject.optString("wording");
                kVar.nZb = optJSONObject.optString("left_button_wording");
                kVar.nZc = optJSONObject.optString("right_button_wording");
                kVar.title = optJSONObject.optString("title");
                optJSONObject = optJSONObject.optJSONObject("url");
                kVar.Afp = new a();
                if (optJSONObject != null) {
                    kVar.Afp.type = optJSONObject.optInt("type");
                    kVar.Afp.csB = optJSONObject.optString("appid");
                    kVar.Afp.wTe = optJSONObject.optString("app_version");
                    kVar.Afp.path = optJSONObject.optString("path");
                    kVar.Afp.tff = optJSONObject.optString("button_name");
                }
                AppMethodBeat.o(49053);
                return kVar;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.JumpRemind", e, "error create", new Object[0]);
        }
        AppMethodBeat.o(49053);
        return null;
    }

    public final boolean a(final Activity activity, e eVar) {
        AppMethodBeat.i(49054);
        this.Afq = eVar;
        if (this.wAV) {
            h.d(activity, this.cEh, this.title, this.nZc, this.nZb, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(49043);
                    ab.i("MicroMsg.JumpRemind", "onClick1 ");
                    if (k.this.Afp == null || !k.this.Afp.tff.equals("right_button_wording")) {
                        k.this.Afq.onCancel();
                        AppMethodBeat.o(49043);
                        return;
                    }
                    k.this.ip(activity);
                    AppMethodBeat.o(49043);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(49044);
                    ab.i("MicroMsg.JumpRemind", "onClick2");
                    if (k.this.Afp == null || !k.this.Afp.tff.equals("left_button_wording")) {
                        k.this.Afq.onCancel();
                        AppMethodBeat.o(49044);
                        return;
                    }
                    k.this.ip(activity);
                    AppMethodBeat.o(49044);
                }
            });
            AppMethodBeat.o(49054);
        } else {
            ip(activity);
            AppMethodBeat.o(49054);
        }
        return true;
    }

    public final boolean a(final Activity activity, final f fVar) {
        AppMethodBeat.i(49055);
        boolean a = a(activity, new e() {
            public final void onCancel() {
                AppMethodBeat.i(49045);
                if (k.this.dNM()) {
                    fVar.bMI();
                    AppMethodBeat.o(49045);
                    return;
                }
                activity.finish();
                AppMethodBeat.o(49045);
            }

            public final void cMX() {
                AppMethodBeat.i(49046);
                if (k.this.dNM()) {
                    fVar.bMI();
                }
                AppMethodBeat.o(49046);
            }

            public final void cMY() {
                AppMethodBeat.i(49047);
                if (k.this.dNM()) {
                    fVar.bMI();
                    AppMethodBeat.o(49047);
                    return;
                }
                activity.finish();
                AppMethodBeat.o(49047);
            }
        });
        AppMethodBeat.o(49055);
        return a;
    }

    public final boolean a(Activity activity, final g gVar) {
        AppMethodBeat.i(49056);
        h.d(activity, this.cEh, this.title, this.nZc, this.nZb, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(49048);
                ab.i("MicroMsg.JumpRemind", "onClick1 ");
                if (k.this.Afp == null || !k.this.Afp.tff.equals("right_button_wording")) {
                    gVar.onCancel();
                    AppMethodBeat.o(49048);
                    return;
                }
                gVar.aQ(k.this.Afp.type, k.this.Afp.path);
                AppMethodBeat.o(49048);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(49049);
                ab.i("MicroMsg.JumpRemind", "onClick2");
                if (k.this.Afp == null || !k.this.Afp.tff.equals("left_button_wording")) {
                    gVar.onCancel();
                    AppMethodBeat.o(49049);
                    return;
                }
                gVar.aQ(k.this.Afp.type, k.this.Afp.path);
                AppMethodBeat.o(49049);
            }
        });
        AppMethodBeat.o(49056);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void ip(Context context) {
        AppMethodBeat.i(49057);
        if (context instanceof h) {
            ((h) context).a(new j() {
                public final void onDestroy() {
                    AppMethodBeat.i(49050);
                    k.this.ons.dead();
                    k.this.Afr.dead();
                    AppMethodBeat.o(49050);
                }

                public final void dNL() {
                    AppMethodBeat.i(49051);
                    k.this.ons.dead();
                    k.this.Afr.dead();
                    AppMethodBeat.o(49051);
                }
            });
            this.ons.dnU();
            this.Afr.dnU();
            this.ctn = false;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.Afp.path);
            intent.putExtra("showShare", false);
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(49057);
    }
}
