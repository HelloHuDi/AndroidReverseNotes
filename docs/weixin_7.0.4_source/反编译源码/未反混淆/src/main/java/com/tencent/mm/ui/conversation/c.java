package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k;
import com.tencent.mm.aj.z;
import com.tencent.mm.aq.b;
import com.tencent.mm.az.d;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class c {

    /* renamed from: com.tencent.mm.ui.conversation.c$6 */
    static class AnonymousClass6 implements a {
        final /* synthetic */ ProgressDialog eiD;
        final /* synthetic */ PBool zqU;

        AnonymousClass6(PBool pBool, ProgressDialog progressDialog) {
            this.zqU = pBool;
            this.eiD = progressDialog;
        }

        public final boolean JU() {
            return this.zqU.value;
        }

        public final void JV() {
            AppMethodBeat.i(34160);
            if (this.eiD != null) {
                this.eiD.dismiss();
            }
            AppMethodBeat.o(34160);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.c$5 */
    static class AnonymousClass5 implements OnCancelListener {
        final /* synthetic */ PBool zqU;

        AnonymousClass5(PBool pBool) {
            this.zqU = pBool;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.zqU.value = true;
        }
    }

    public static void a(String str, Context context, ak akVar, Runnable runnable, boolean z, boolean z2) {
        AppMethodBeat.i(34169);
        final PBool pBool = new PBool();
        String str2;
        final String str3;
        final Context context2;
        final boolean z3;
        final String str4;
        final boolean z4;
        final ProgressDialog progressDialog;
        final PBool pBool2;
        if (t.kH(str)) {
            str2 = null;
            aw.ZK();
            bi Ra = com.tencent.mm.model.c.XO().Ra(str);
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new d(str, Ra.field_msgSvrId));
            pBool.value = false;
            context.getString(R.string.tz);
            final ProgressDialog b = h.b(context, context.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            if (!pBool.value) {
                str2 = e.akq(str);
            }
            if (ah.isNullOrNil(str2)) {
                b.dismiss();
                str3 = str;
                final Runnable runnable2 = runnable;
                h.a(context, context.getString(R.string.bx5), "", context.getString(R.string.p4), context.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34163);
                        c.a(str3, pBool, b);
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        AppMethodBeat.o(34163);
                    }
                }, null, (int) R.color.ei);
            } else {
                b.dismiss();
                String string = context.getString(R.string.fd0, new Object[]{str2});
                String string2 = context.getString(R.string.c9y);
                String string3 = context.getString(R.string.b4v);
                context2 = context;
                z3 = z2;
                str4 = str;
                z4 = z;
                AnonymousClass7 anonymousClass7 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34161);
                        pBool.value = true;
                        c.c(context2, z3, str4);
                        if (z4) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(1), Integer.valueOf(4), str4);
                        }
                        AppMethodBeat.o(34161);
                    }
                };
                progressDialog = b;
                pBool2 = pBool;
                final String str5 = str;
                final boolean z5 = z;
                final Runnable runnable3 = runnable;
                h.a(context, false, string, null, string2, string3, anonymousClass7, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34162);
                        progressDialog.show();
                        pBool2.value = false;
                        c.a(str5, pBool2, progressDialog);
                        if (z5) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(1), Integer.valueOf(3), str5);
                        }
                        if (runnable3 != null) {
                            runnable3.run();
                        }
                        AppMethodBeat.o(34162);
                    }
                }, -1, R.color.ei);
            }
        } else if (t.np(str)) {
            aw.ZK();
            com.tencent.mm.model.c.XR().aoY(str);
            ng ngVar = new ng();
            ngVar.cJw.opType = 4;
            ngVar.cJw.cJB = 20;
            com.tencent.mm.sdk.b.a.xxA.m(ngVar);
        } else if (t.nf(str)) {
            aw.ZK();
            com.tencent.mm.model.c.XR().aoY(str);
        } else if (t.ni(str)) {
            aw.ZK();
            com.tencent.mm.model.c.XR().aoX(str);
        } else if (f.kq(str)) {
            pBool.value = false;
            context.getString(R.string.tz);
            final p b2 = h.b(context, context.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            b2.dismiss();
            str3 = str;
            final String str6 = str;
            h.a(context, context.getString(R.string.bx3), "", context.getString(R.string.p4), context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(34166);
                    bf.a(str3, new a() {
                        public final boolean JU() {
                            AppMethodBeat.i(34164);
                            if (pBool.value || b2 == null || !b2.isShowing()) {
                                AppMethodBeat.o(34164);
                                return true;
                            }
                            AppMethodBeat.o(34164);
                            return false;
                        }

                        public final void JV() {
                            AppMethodBeat.i(34165);
                            com.tencent.mm.aj.a.e.G(str6, false);
                            if (b2 != null) {
                                b2.dismiss();
                            }
                            AppMethodBeat.o(34165);
                        }
                    });
                    AppMethodBeat.o(34166);
                }
            }, null, (int) R.color.ei);
        } else {
            aw.ZK();
            bi Ra2 = com.tencent.mm.model.c.XO().Ra(str);
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new d(str, Ra2.field_msgSvrId));
            pBool.value = false;
            context.getString(R.string.tz);
            final ProgressDialog b3 = h.b(context, context.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            str2 = null;
            if (!pBool.value) {
                str2 = e.akq(str);
            }
            final Runnable runnable4;
            if (ah.isNullOrNil(str2)) {
                b3.dismiss();
                final Context context3 = context;
                str4 = str;
                final ak akVar2 = akVar;
                final PBool pBool3 = pBool;
                runnable4 = runnable;
                h.a(context, context.getString(t.ny(str) ? R.string.bx4 : R.string.bx3), "", context.getString(R.string.p4), context.getString(R.string.or), (OnClickListener) new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34155);
                        c.a(str4, akVar2, pBool3, b3);
                        if (runnable4 != null) {
                            runnable4.run();
                        }
                        if (f.qY(str4)) {
                            k afc = z.afc();
                            k.a(str4, 14, 0, 0.0f, 0.0f, 0, null, 0, afc.fwz, null);
                        }
                        AppMethodBeat.o(34155);
                    }
                }, null, (int) R.color.ei);
            } else {
                b3.dismiss();
                String string4 = context.getString(R.string.fd0, new Object[]{str2});
                String string5 = context.getString(R.string.c9y);
                String string6 = context.getString(R.string.b4v);
                context2 = context;
                z3 = z2;
                str4 = str;
                z4 = z;
                AnonymousClass13 anonymousClass13 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34167);
                        pBool.value = true;
                        c.c(context2, z3, str4);
                        if (z4) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(0), Integer.valueOf(4), str4);
                        }
                        AppMethodBeat.o(34167);
                    }
                };
                progressDialog = b3;
                pBool2 = pBool;
                final Context context4 = context;
                final String str7 = str;
                final ak akVar3 = akVar;
                runnable4 = runnable;
                final boolean z6 = z;
                h.a(context, false, string4, null, string5, string6, anonymousClass13, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34168);
                        progressDialog.show();
                        pBool2.value = false;
                        c.a(str7, akVar3, pBool2, progressDialog);
                        if (runnable4 != null) {
                            runnable4.run();
                        }
                        if (z6) {
                            com.tencent.mm.plugin.report.service.h.pYm.e(14553, Integer.valueOf(0), Integer.valueOf(3), str7);
                        }
                        AppMethodBeat.o(34168);
                    }
                }, -1, R.color.ei);
            }
        }
        if (t.ng(str)) {
            ab.i("MicroMsg.ConvDelLogic", "del all qmessage");
            bf.aab();
            aw.ZK();
            com.tencent.mm.model.c.XR().aoY("@qqim");
            AppMethodBeat.o(34169);
            return;
        }
        if (t.ne(str)) {
            ab.i("MicroMsg.ConvDelLogic", "del all tmessage");
            bf.aac();
            aw.ZK();
            com.tencent.mm.model.c.XR().aoY("@t.qq.com");
        }
        AppMethodBeat.o(34169);
    }

    static /* synthetic */ void c(Context context, boolean z, String str) {
        AppMethodBeat.i(34170);
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("chat_from_scene", 4);
            com.tencent.mm.bp.d.f(context, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.o(34170);
            return;
        }
        LauncherUI instance = LauncherUI.getInstance();
        if (instance != null) {
            instance.startChatting(str, null, true);
        }
        AppMethodBeat.o(34170);
    }

    static /* synthetic */ void a(final String str, final PBool pBool, final ProgressDialog progressDialog) {
        AppMethodBeat.i(34171);
        bf.a(str, new a() {
            public final boolean JU() {
                AppMethodBeat.i(34158);
                if (pBool.value || progressDialog == null || !progressDialog.isShowing()) {
                    AppMethodBeat.o(34158);
                    return true;
                }
                AppMethodBeat.o(34158);
                return false;
            }

            public final void JV() {
                AppMethodBeat.i(34159);
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(str);
                aoO.NI();
                if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                    t.x(aoO.field_username, false);
                } else {
                    aw.ZK();
                    com.tencent.mm.model.c.XM().b(str, aoO);
                }
                aw.ZK();
                com.tencent.mm.model.c.XR().aoX(str);
                b.agG();
                b.rX(str);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.o(34159);
            }
        });
        AppMethodBeat.o(34171);
    }

    static /* synthetic */ void a(String str, ak akVar, final PBool pBool, final ProgressDialog progressDialog) {
        AppMethodBeat.i(34172);
        bf.a(str, new a() {
            public final boolean JU() {
                AppMethodBeat.i(34156);
                if (pBool.value || progressDialog == null || !progressDialog.isShowing()) {
                    AppMethodBeat.o(34156);
                    return true;
                }
                AppMethodBeat.o(34156);
                return false;
            }

            public final void JV() {
                AppMethodBeat.i(34157);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.o(34157);
            }
        });
        aw.ZK();
        ad aoO = com.tencent.mm.model.c.XM().aoO(str);
        aoO.NI();
        aoO.NJ();
        if (aoO.dsf() && f.qY(str)) {
            com.tencent.mm.plugin.report.service.h.pYm.e(13773, Integer.valueOf(0), Integer.valueOf(akVar.field_unReadCount), Integer.valueOf(1), akVar.field_username);
        }
        bbv bbv = new bbv();
        ab.i("MicroMsg.ConvDelLogic", "oplog modContact user:%s remark:%s type:%d ", aoO.field_username, aoO.field_conRemark, Integer.valueOf(aoO.field_type));
        bbv.wcB = new bts().alV(ah.nullAsNil(aoO.field_username));
        bbv.wyX = new bts().alV(ah.nullAsNil(aoO.field_nickname));
        bbv.wce = new bts().alV(ah.nullAsNil(aoO.Ht()));
        bbv.wcf = new bts().alV(ah.nullAsNil(aoO.Hu()));
        bbv.guN = aoO.dtS;
        bbv.wbu = 561023;
        bbv.wbv = aoO.field_type;
        bbv.wFK = new bts().alV(ah.nullAsNil(aoO.field_conRemark));
        bbv.wFL = new bts().alV(ah.nullAsNil(aoO.field_conRemarkPYShort));
        bbv.wFM = new bts().alV(ah.nullAsNil(aoO.field_conRemarkPYFull));
        bbv.wbA = aoO.dtX;
        bbv.wGf = new bts().alV(ah.nullAsNil(aoO.field_domainList));
        bbv.wbE = aoO.dua;
        bbv.guR = aoO.dub;
        bbv.guQ = ah.nullAsNil(aoO.signature);
        bbv.guP = ah.nullAsNil(aoO.getCityCode());
        bbv.guO = ah.nullAsNil(aoO.dsj());
        bbv.wBV = ah.nullAsNil(aoO.dug);
        bbv.wBX = aoO.field_weiboFlag;
        bbv.wGb = 0;
        bbv.vEF = new SKBuiltinBuffer_t();
        bbv.guW = ah.nullAsNil(aoO.getCountryCode());
        aw.ZK();
        com.tencent.mm.model.c.XL().c(new j.a(2, bbv));
        aw.ZK();
        com.tencent.mm.model.c.XM().b(str, aoO);
        aw.ZK();
        ak aoZ = com.tencent.mm.model.c.XR().aoZ(str);
        aw.ZK();
        com.tencent.mm.model.c.XR().aoX(str);
        if (aoZ != null && (aoZ.jl(4194304) || (aoO.dsf() && !com.tencent.mm.n.a.jh(aoO.field_type) && aoZ.field_conversationTime < z.aff()))) {
            aw.Rg().a(new com.tencent.mm.modelsimple.e(str), 0);
        }
        AppMethodBeat.o(34172);
    }
}
