package com.tencent.p177mm.wallet_core.p649c;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C26267vw;
import com.tencent.p177mm.p230g.p231a.C37814vr;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.c.k */
public final class C24147k {
    public C24153a Afp;
    C36377e Afq;
    C4884c<C37814vr> Afr = new C241482();
    public String cEh;
    boolean ctn = false;
    public String nZb;
    public String nZc;
    C4884c<C26267vw> ons = new C241451();
    public String title;
    public int ttd;
    public boolean wAV;

    /* renamed from: com.tencent.mm.wallet_core.c.k$1 */
    class C241451 extends C4884c<C26267vw> {
        C241451() {
            AppMethodBeat.m2504i(49038);
            this.xxI = C26267vw.class.getName().hashCode();
            AppMethodBeat.m2505o(49038);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(49039);
            C26267vw c26267vw = (C26267vw) c4883b;
            C4990ab.m7416i("MicroMsg.JumpRemind", "WxPayGdprResultEvent result");
            C24147k.this.ctn = true;
            if (c26267vw.cTd.cBp == "agree_privacy") {
                C24147k.this.Afq.cMX();
            } else {
                C24147k.this.Afq.cMY();
            }
            C24147k.this.ons.dead();
            AppMethodBeat.m2505o(49039);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.c.k$8 */
    class C241468 implements C44427j {
        C241468() {
        }

        public final void onDestroy() {
            AppMethodBeat.m2504i(49050);
            C24147k.this.ons.dead();
            C24147k.this.Afr.dead();
            AppMethodBeat.m2505o(49050);
        }

        public final void dNL() {
            AppMethodBeat.m2504i(49051);
            C24147k.this.ons.dead();
            C24147k.this.Afr.dead();
            AppMethodBeat.m2505o(49051);
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.c.k$2 */
    class C241482 extends C4884c<C37814vr> {

        /* renamed from: com.tencent.mm.wallet_core.c.k$2$1 */
        class C160781 implements Runnable {
            C160781() {
            }

            public final void run() {
                AppMethodBeat.m2504i(49040);
                if (!C24147k.this.ctn) {
                    C24147k.this.ctn = true;
                    C24147k.this.Afq.cMY();
                }
                AppMethodBeat.m2505o(49040);
            }
        }

        C241482() {
            AppMethodBeat.m2504i(49041);
            this.xxI = C37814vr.class.getName().hashCode();
            AppMethodBeat.m2505o(49041);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(49042);
            C4990ab.m7416i("MicroMsg.JumpRemind", "WebViewUIDestroyEvent close");
            C24147k.this.Afr.dead();
            C5004al.m7442n(new C160781(), 200);
            AppMethodBeat.m2505o(49042);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.wallet_core.c.k$a */
    public static class C24153a {
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

    public C24147k() {
        AppMethodBeat.m2504i(49052);
        AppMethodBeat.m2505o(49052);
    }

    /* renamed from: aS */
    public static C24147k m37121aS(JSONObject jSONObject) {
        AppMethodBeat.m2504i(49053);
        try {
            C4990ab.m7417i("MicroMsg.JumpRemind", "feed %s", jSONObject);
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
                C24147k c24147k = new C24147k();
                c24147k.ttd = optJSONObject.optInt("jump_type");
                c24147k.wAV = optJSONObject.optBoolean("is_pop_up_windows");
                c24147k.cEh = optJSONObject.optString("wording");
                c24147k.nZb = optJSONObject.optString("left_button_wording");
                c24147k.nZc = optJSONObject.optString("right_button_wording");
                c24147k.title = optJSONObject.optString("title");
                optJSONObject = optJSONObject.optJSONObject("url");
                c24147k.Afp = new C24153a();
                if (optJSONObject != null) {
                    c24147k.Afp.type = optJSONObject.optInt("type");
                    c24147k.Afp.csB = optJSONObject.optString("appid");
                    c24147k.Afp.wTe = optJSONObject.optString("app_version");
                    c24147k.Afp.path = optJSONObject.optString("path");
                    c24147k.Afp.tff = optJSONObject.optString("button_name");
                }
                AppMethodBeat.m2505o(49053);
                return c24147k;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.JumpRemind", e, "error create", new Object[0]);
        }
        AppMethodBeat.m2505o(49053);
        return null;
    }

    /* renamed from: a */
    public final boolean mo39945a(final Activity activity, C36377e c36377e) {
        AppMethodBeat.m2504i(49054);
        this.Afq = c36377e;
        if (this.wAV) {
            C30379h.m48466d(activity, this.cEh, this.title, this.nZc, this.nZb, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(49043);
                    C4990ab.m7416i("MicroMsg.JumpRemind", "onClick1 ");
                    if (C24147k.this.Afp == null || !C24147k.this.Afp.tff.equals("right_button_wording")) {
                        C24147k.this.Afq.onCancel();
                        AppMethodBeat.m2505o(49043);
                        return;
                    }
                    C24147k.this.mo39949ip(activity);
                    AppMethodBeat.m2505o(49043);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(49044);
                    C4990ab.m7416i("MicroMsg.JumpRemind", "onClick2");
                    if (C24147k.this.Afp == null || !C24147k.this.Afp.tff.equals("left_button_wording")) {
                        C24147k.this.Afq.onCancel();
                        AppMethodBeat.m2505o(49044);
                        return;
                    }
                    C24147k.this.mo39949ip(activity);
                    AppMethodBeat.m2505o(49044);
                }
            });
            AppMethodBeat.m2505o(49054);
        } else {
            mo39949ip(activity);
            AppMethodBeat.m2505o(49054);
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo39946a(final Activity activity, final C16077f c16077f) {
        AppMethodBeat.m2504i(49055);
        boolean a = mo39945a(activity, new C36377e() {
            public final void onCancel() {
                AppMethodBeat.m2504i(49045);
                if (C24147k.this.dNM()) {
                    c16077f.bMI();
                    AppMethodBeat.m2505o(49045);
                    return;
                }
                activity.finish();
                AppMethodBeat.m2505o(49045);
            }

            public final void cMX() {
                AppMethodBeat.m2504i(49046);
                if (C24147k.this.dNM()) {
                    c16077f.bMI();
                }
                AppMethodBeat.m2505o(49046);
            }

            public final void cMY() {
                AppMethodBeat.m2504i(49047);
                if (C24147k.this.dNM()) {
                    c16077f.bMI();
                    AppMethodBeat.m2505o(49047);
                    return;
                }
                activity.finish();
                AppMethodBeat.m2505o(49047);
            }
        });
        AppMethodBeat.m2505o(49055);
        return a;
    }

    /* renamed from: a */
    public final boolean mo39947a(Activity activity, final C44424g c44424g) {
        AppMethodBeat.m2504i(49056);
        C30379h.m48466d(activity, this.cEh, this.title, this.nZc, this.nZb, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(49048);
                C4990ab.m7416i("MicroMsg.JumpRemind", "onClick1 ");
                if (C24147k.this.Afp == null || !C24147k.this.Afp.tff.equals("right_button_wording")) {
                    c44424g.onCancel();
                    AppMethodBeat.m2505o(49048);
                    return;
                }
                c44424g.mo24321aQ(C24147k.this.Afp.type, C24147k.this.Afp.path);
                AppMethodBeat.m2505o(49048);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(49049);
                C4990ab.m7416i("MicroMsg.JumpRemind", "onClick2");
                if (C24147k.this.Afp == null || !C24147k.this.Afp.tff.equals("left_button_wording")) {
                    c44424g.onCancel();
                    AppMethodBeat.m2505o(49049);
                    return;
                }
                c44424g.mo24321aQ(C24147k.this.Afp.type, C24147k.this.Afp.path);
                AppMethodBeat.m2505o(49049);
            }
        });
        AppMethodBeat.m2505o(49056);
        return true;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ip */
    public final void mo39949ip(Context context) {
        AppMethodBeat.m2504i(49057);
        if (context instanceof C44425h) {
            ((C44425h) context).mo24299a(new C241468());
            this.ons.dnU();
            this.Afr.dnU();
            this.ctn = false;
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.Afp.path);
            intent.putExtra("showShare", false);
            C25985d.m41467b(context, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.m2505o(49057);
    }
}
