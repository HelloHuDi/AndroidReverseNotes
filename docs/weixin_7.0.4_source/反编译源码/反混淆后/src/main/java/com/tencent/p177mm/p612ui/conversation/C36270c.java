package com.tencent.p177mm.p612ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C45452e;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.C25767k;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p189aq.C6320b;
import com.tencent.p177mm.p201az.C45177d;
import com.tencent.p177mm.p230g.p231a.C45346ng;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.wallet.C40492e;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bbv;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.ui.conversation.c */
public final class C36270c {

    /* renamed from: com.tencent.mm.ui.conversation.c$6 */
    static class C362696 implements C1827a {
        final /* synthetic */ ProgressDialog eiD;
        final /* synthetic */ PBool zqU;

        C362696(PBool pBool, ProgressDialog progressDialog) {
            this.zqU = pBool;
            this.eiD = progressDialog;
        }

        /* renamed from: JU */
        public final boolean mo5405JU() {
            return this.zqU.value;
        }

        /* renamed from: JV */
        public final void mo5406JV() {
            AppMethodBeat.m2504i(34160);
            if (this.eiD != null) {
                this.eiD.dismiss();
            }
            AppMethodBeat.m2505o(34160);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.c$5 */
    static class C362715 implements OnCancelListener {
        final /* synthetic */ PBool zqU;

        C362715(PBool pBool) {
            this.zqU = pBool;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            this.zqU.value = true;
        }
    }

    /* renamed from: a */
    public static void m59699a(String str, Context context, C7617ak c7617ak, Runnable runnable, boolean z, boolean z2) {
        AppMethodBeat.m2504i(34169);
        final PBool pBool = new PBool();
        String str2;
        final String str3;
        final Context context2;
        final boolean z3;
        final String str4;
        final boolean z4;
        final ProgressDialog progressDialog;
        final PBool pBool2;
        if (C1855t.m3896kH(str)) {
            str2 = null;
            C9638aw.m17190ZK();
            C7620bi Ra = C18628c.m29080XO().mo15247Ra(str);
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C45177d(str, Ra.field_msgSvrId));
            pBool.value = false;
            context.getString(C25738R.string.f9238tz);
            final ProgressDialog b = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            if (!pBool.value) {
                str2 = C40492e.akq(str);
            }
            if (C42252ah.isNullOrNil(str2)) {
                b.dismiss();
                str3 = str;
                final Runnable runnable2 = runnable;
                C30379h.m48444a(context, context.getString(C25738R.string.bx5), "", context.getString(C25738R.string.f9088p4), context.getString(C25738R.string.f9076or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(34163);
                        C36270c.m59700a(str3, pBool, b);
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                        AppMethodBeat.m2505o(34163);
                    }
                }, null, (int) C25738R.color.f11717ei);
            } else {
                b.dismiss();
                String string = context.getString(C25738R.string.fd0, new Object[]{str2});
                String string2 = context.getString(C25738R.string.c9y);
                String string3 = context.getString(C25738R.string.b4v);
                context2 = context;
                z3 = z2;
                str4 = str;
                z4 = z;
                C306927 c306927 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(34161);
                        pBool.value = true;
                        C36270c.m59702c(context2, z3, str4);
                        if (z4) {
                            C7060h.pYm.mo8381e(14553, Integer.valueOf(1), Integer.valueOf(4), str4);
                        }
                        AppMethodBeat.m2505o(34161);
                    }
                };
                progressDialog = b;
                pBool2 = pBool;
                final String str5 = str;
                final boolean z5 = z;
                final Runnable runnable3 = runnable;
                C30379h.m48454a(context, false, string, null, string2, string3, c306927, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(34162);
                        progressDialog.show();
                        pBool2.value = false;
                        C36270c.m59700a(str5, pBool2, progressDialog);
                        if (z5) {
                            C7060h.pYm.mo8381e(14553, Integer.valueOf(1), Integer.valueOf(3), str5);
                        }
                        if (runnable3 != null) {
                            runnable3.run();
                        }
                        AppMethodBeat.m2505o(34162);
                    }
                }, -1, C25738R.color.f11717ei);
            }
        } else if (C1855t.m3947np(str)) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoY(str);
            C45346ng c45346ng = new C45346ng();
            c45346ng.cJw.opType = 4;
            c45346ng.cJw.cJB = 20;
            C4879a.xxA.mo10055m(c45346ng);
        } else if (C1855t.m3937nf(str)) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoY(str);
        } else if (C1855t.m3940ni(str)) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoX(str);
        } else if (C17903f.m28103kq(str)) {
            pBool.value = false;
            context.getString(C25738R.string.f9238tz);
            final C44275p b2 = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            b2.dismiss();
            str3 = str;
            final String str6 = str;
            C30379h.m48444a(context, context.getString(C25738R.string.bx3), "", context.getString(C25738R.string.f9088p4), context.getString(C25738R.string.f9076or), new OnClickListener() {

                /* renamed from: com.tencent.mm.ui.conversation.c$11$1 */
                class C54831 implements C1827a {
                    C54831() {
                    }

                    /* renamed from: JU */
                    public final boolean mo5405JU() {
                        AppMethodBeat.m2504i(34164);
                        if (pBool.value || b2 == null || !b2.isShowing()) {
                            AppMethodBeat.m2505o(34164);
                            return true;
                        }
                        AppMethodBeat.m2505o(34164);
                        return false;
                    }

                    /* renamed from: JV */
                    public final void mo5406JV() {
                        AppMethodBeat.m2504i(34165);
                        C25754e.m40889G(str6, false);
                        if (b2 != null) {
                            b2.dismiss();
                        }
                        AppMethodBeat.m2505o(34165);
                    }
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(34166);
                    C1829bf.m3741a(str3, new C54831());
                    AppMethodBeat.m2505o(34166);
                }
            }, null, (int) C25738R.color.f11717ei);
        } else {
            C9638aw.m17190ZK();
            C7620bi Ra2 = C18628c.m29080XO().mo15247Ra(str);
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C45177d(str, Ra2.field_msgSvrId));
            pBool.value = false;
            context.getString(C25738R.string.f9238tz);
            final ProgressDialog b3 = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    pBool.value = true;
                }
            });
            str2 = null;
            if (!pBool.value) {
                str2 = C40492e.akq(str);
            }
            final Runnable runnable4;
            if (C42252ah.isNullOrNil(str2)) {
                b3.dismiss();
                final Context context3 = context;
                str4 = str;
                final C7617ak c7617ak2 = c7617ak;
                final PBool pBool3 = pBool;
                runnable4 = runnable;
                C30379h.m48444a(context, context.getString(C1855t.m3956ny(str) ? C25738R.string.bx4 : C25738R.string.bx3), "", context.getString(C25738R.string.f9088p4), context.getString(C25738R.string.f9076or), (OnClickListener) new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(34155);
                        C36270c.m59701a(str4, c7617ak2, pBool3, b3);
                        if (runnable4 != null) {
                            runnable4.run();
                        }
                        if (C17903f.m28105qY(str4)) {
                            C25767k afc = C41747z.afc();
                            C25767k.m40970a(str4, 14, 0, 0.0f, 0.0f, 0, null, 0, afc.fwz, null);
                        }
                        AppMethodBeat.m2505o(34155);
                    }
                }, null, (int) C25738R.color.f11717ei);
            } else {
                b3.dismiss();
                String string4 = context.getString(C25738R.string.fd0, new Object[]{str2});
                String string5 = context.getString(C25738R.string.c9y);
                String string6 = context.getString(C25738R.string.b4v);
                context2 = context;
                z3 = z2;
                str4 = str;
                z4 = z;
                C3626513 c3626513 = new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(34167);
                        pBool.value = true;
                        C36270c.m59702c(context2, z3, str4);
                        if (z4) {
                            C7060h.pYm.mo8381e(14553, Integer.valueOf(0), Integer.valueOf(4), str4);
                        }
                        AppMethodBeat.m2505o(34167);
                    }
                };
                progressDialog = b3;
                pBool2 = pBool;
                final Context context4 = context;
                final String str7 = str;
                final C7617ak c7617ak3 = c7617ak;
                runnable4 = runnable;
                final boolean z6 = z;
                C30379h.m48454a(context, false, string4, null, string5, string6, c3626513, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(34168);
                        progressDialog.show();
                        pBool2.value = false;
                        C36270c.m59701a(str7, c7617ak3, pBool2, progressDialog);
                        if (runnable4 != null) {
                            runnable4.run();
                        }
                        if (z6) {
                            C7060h.pYm.mo8381e(14553, Integer.valueOf(0), Integer.valueOf(3), str7);
                        }
                        AppMethodBeat.m2505o(34168);
                    }
                }, -1, C25738R.color.f11717ei);
            }
        }
        if (C1855t.m3938ng(str)) {
            C4990ab.m7416i("MicroMsg.ConvDelLogic", "del all qmessage");
            C1829bf.aab();
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoY("@qqim");
            AppMethodBeat.m2505o(34169);
            return;
        }
        if (C1855t.m3936ne(str)) {
            C4990ab.m7416i("MicroMsg.ConvDelLogic", "del all tmessage");
            C1829bf.aac();
            C9638aw.m17190ZK();
            C18628c.m29083XR().aoY("@t.qq.com");
        }
        AppMethodBeat.m2505o(34169);
    }

    /* renamed from: c */
    static /* synthetic */ void m59702c(Context context, boolean z, String str) {
        AppMethodBeat.m2504i(34170);
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("chat_from_scene", 4);
            C25985d.m41473f(context, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.m2505o(34170);
            return;
        }
        LauncherUI instance = LauncherUI.getInstance();
        if (instance != null) {
            instance.startChatting(str, null, true);
        }
        AppMethodBeat.m2505o(34170);
    }

    /* renamed from: a */
    static /* synthetic */ void m59700a(final String str, final PBool pBool, final ProgressDialog progressDialog) {
        AppMethodBeat.m2504i(34171);
        C1829bf.m3741a(str, new C1827a() {
            /* renamed from: JU */
            public final boolean mo5405JU() {
                AppMethodBeat.m2504i(34158);
                if (pBool.value || progressDialog == null || !progressDialog.isShowing()) {
                    AppMethodBeat.m2505o(34158);
                    return true;
                }
                AppMethodBeat.m2505o(34158);
                return false;
            }

            /* renamed from: JV */
            public final void mo5406JV() {
                AppMethodBeat.m2504i(34159);
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(str);
                aoO.mo16683NI();
                if (C7486a.m12942jh(aoO.field_type)) {
                    C1855t.m3969x(aoO.field_username, false);
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29078XM().mo15724b(str, aoO);
                }
                C9638aw.m17190ZK();
                C18628c.m29083XR().aoX(str);
                C6320b.agG();
                C6320b.m10398rX(str);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.m2505o(34159);
            }
        });
        AppMethodBeat.m2505o(34171);
    }

    /* renamed from: a */
    static /* synthetic */ void m59701a(String str, C7617ak c7617ak, final PBool pBool, final ProgressDialog progressDialog) {
        AppMethodBeat.m2504i(34172);
        C1829bf.m3741a(str, new C1827a() {
            /* renamed from: JU */
            public final boolean mo5405JU() {
                AppMethodBeat.m2504i(34156);
                if (pBool.value || progressDialog == null || !progressDialog.isShowing()) {
                    AppMethodBeat.m2505o(34156);
                    return true;
                }
                AppMethodBeat.m2505o(34156);
                return false;
            }

            /* renamed from: JV */
            public final void mo5406JV() {
                AppMethodBeat.m2504i(34157);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                AppMethodBeat.m2505o(34157);
            }
        });
        C9638aw.m17190ZK();
        C7616ad aoO = C18628c.m29078XM().aoO(str);
        aoO.mo16683NI();
        aoO.mo16684NJ();
        if (aoO.dsf() && C17903f.m28105qY(str)) {
            C7060h.pYm.mo8381e(13773, Integer.valueOf(0), Integer.valueOf(c7617ak.field_unReadCount), Integer.valueOf(1), c7617ak.field_username);
        }
        bbv bbv = new bbv();
        C4990ab.m7417i("MicroMsg.ConvDelLogic", "oplog modContact user:%s remark:%s type:%d ", aoO.field_username, aoO.field_conRemark, Integer.valueOf(aoO.field_type));
        bbv.wcB = new bts().alV(C42252ah.nullAsNil(aoO.field_username));
        bbv.wyX = new bts().alV(C42252ah.nullAsNil(aoO.field_nickname));
        bbv.wce = new bts().alV(C42252ah.nullAsNil(aoO.mo14676Ht()));
        bbv.wcf = new bts().alV(C42252ah.nullAsNil(aoO.mo14677Hu()));
        bbv.guN = aoO.dtS;
        bbv.wbu = 561023;
        bbv.wbv = aoO.field_type;
        bbv.wFK = new bts().alV(C42252ah.nullAsNil(aoO.field_conRemark));
        bbv.wFL = new bts().alV(C42252ah.nullAsNil(aoO.field_conRemarkPYShort));
        bbv.wFM = new bts().alV(C42252ah.nullAsNil(aoO.field_conRemarkPYFull));
        bbv.wbA = aoO.dtX;
        bbv.wGf = new bts().alV(C42252ah.nullAsNil(aoO.field_domainList));
        bbv.wbE = aoO.dua;
        bbv.guR = aoO.dub;
        bbv.guQ = C42252ah.nullAsNil(aoO.signature);
        bbv.guP = C42252ah.nullAsNil(aoO.getCityCode());
        bbv.guO = C42252ah.nullAsNil(aoO.dsj());
        bbv.wBV = C42252ah.nullAsNil(aoO.dug);
        bbv.wBX = aoO.field_weiboFlag;
        bbv.wGb = 0;
        bbv.vEF = new SKBuiltinBuffer_t();
        bbv.guW = C42252ah.nullAsNil(aoO.getCountryCode());
        C9638aw.m17190ZK();
        C18628c.m29077XL().mo7920c(new C3465a(2, bbv));
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo15724b(str, aoO);
        C9638aw.m17190ZK();
        C7617ak aoZ = C18628c.m29083XR().aoZ(str);
        C9638aw.m17190ZK();
        C18628c.m29083XR().aoX(str);
        if (aoZ != null && (aoZ.mo16714jl(4194304) || (aoO.dsf() && !C7486a.m12942jh(aoO.field_type) && aoZ.field_conversationTime < C41747z.aff()))) {
            C9638aw.m17182Rg().mo14541a(new C45452e(str), 0);
        }
        AppMethodBeat.m2505o(34172);
    }
}
