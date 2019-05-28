package com.tencent.p177mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.p1207a.C18608f;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C41971bv;
import com.tencent.p177mm.p230g.p231a.C45362rd;
import com.tencent.p177mm.p230g.p231a.C6485gm;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.sns.abtest.NotInterestMenu.C21864c;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p520ui.SnsNotInterestUI;
import com.tencent.p177mm.plugin.sns.p520ui.SnsPermissionUI;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.sns.abtest.a */
public final class C21865a {
    private static Context context = null;
    private static boolean qCh = false;
    private static String qCi = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private static OnClickListener qCj = null;
    private static int qCk = -1;
    private static int qCl = -1;
    private static long qCm = 0;
    private static View qCn = null;
    private static C21870b qCo = null;
    private static C21864c qCp = null;
    private static C4884c qCq = new C218661();
    private static C4884c qCr = new C218672();

    /* renamed from: com.tencent.mm.plugin.sns.abtest.a$1 */
    static class C218661 extends C4884c<C45362rd> {
        C218661() {
            AppMethodBeat.m2504i(35642);
            this.xxI = C45362rd.class.getName().hashCode();
            AppMethodBeat.m2505o(35642);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(35643);
            C45362rd c45362rd = (C45362rd) c4883b;
            if (c45362rd instanceof C45362rd) {
                boolean z = c45362rd.cNh.cNi;
                long j = c45362rd.cNh.cBh;
                C4990ab.m7411d("MicroMsg.NotInteresetABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", Boolean.valueOf(z), Long.valueOf(j));
                if (!(j == 0 || C21865a.qCm == 0 || C21865a.qCm != j)) {
                    if (z) {
                        C21865a.qCk = 4;
                    } else {
                        C21865a.qCk = 3;
                    }
                    C21865a.m33408BK();
                }
            }
            AppMethodBeat.m2505o(35643);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.a$2 */
    static class C218672 extends C4884c<C6485gm> {
        C218672() {
            AppMethodBeat.m2504i(35644);
            this.xxI = C6485gm.class.getName().hashCode();
            AppMethodBeat.m2505o(35644);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(35645);
            C6485gm c6485gm = (C6485gm) c4883b;
            if (c6485gm instanceof C6485gm) {
                boolean z = c6485gm.cBf.cBg;
                long j = c6485gm.cBf.cBh;
                C4990ab.m7411d("MicroMsg.NotInteresetABTestManager", "notInterestFinishEventListener callback, isNotInterest:%b, sndId:%d", Boolean.valueOf(z), Long.valueOf(j));
                if (!(j == 0 || C21865a.qCm == 0 || j != C21865a.qCm)) {
                    if (z) {
                        C21865a.qCk = 2;
                    } else {
                        C21865a.qCk = 1;
                    }
                    C21865a.m33408BK();
                }
            }
            AppMethodBeat.m2505o(35645);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.a$4 */
    static class C218684 implements C21864c {
        C218684() {
        }

        /* renamed from: c */
        public final void mo37347c(C46236n c46236n) {
            AppMethodBeat.m2504i(35647);
            C21865a.m33409a(C21865a.context, c46236n);
            AppMethodBeat.m2505o(35647);
        }

        /* renamed from: d */
        public final void mo37348d(C46236n c46236n) {
            AppMethodBeat.m2504i(35648);
            C21865a.m33414b(C21865a.context, c46236n);
            AppMethodBeat.m2505o(35648);
        }

        /* renamed from: e */
        public final void mo37349e(C46236n c46236n) {
            AppMethodBeat.m2504i(35649);
            C21865a.m33417c(C21865a.context, c46236n);
            AppMethodBeat.m2505o(35649);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.abtest.a$3 */
    static class C218693 implements OnClickListener {
        C218693() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(35646);
            if (view.getTag() instanceof C46236n) {
                C21865a.m33411a(view, view.getContext(), (C46236n) view.getTag());
            }
            AppMethodBeat.m2505o(35646);
        }
    }

    static {
        AppMethodBeat.m2504i(35662);
        AppMethodBeat.m2505o(35662);
    }

    /* renamed from: c */
    public static void m33416c(Context context, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(35650);
        if (C26407g.aaK().mo60654oP("7") != null) {
            qCh = true;
            qCi = C26407g.aaK().mo60654oP("7").value;
            C4990ab.m7411d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", qCi);
            qCn = viewGroup;
            qCo = new C21870b(viewGroup);
            context = context;
            C4879a.xxA.mo10052c(qCq);
            C4879a.xxA.mo10052c(qCr);
            qCj = new C218693();
            qCp = new C218684();
            qCo.qCu = qCp;
        }
        AppMethodBeat.m2505o(35650);
    }

    public static void clW() {
        AppMethodBeat.m2504i(35651);
        if (qCo != null) {
            qCo.cma();
        }
        AppMethodBeat.m2505o(35651);
    }

    /* renamed from: a */
    private static void m33413a(C46236n c46236n) {
        AppMethodBeat.m2504i(35652);
        boolean equals = qCi.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (c46236n.field_type == 1) {
            if (equals) {
                qCl = 5;
                AppMethodBeat.m2505o(35652);
                return;
            }
            qCl = 0;
            AppMethodBeat.m2505o(35652);
        } else if (c46236n.field_type != 2) {
            if (c46236n.field_type == 15) {
                if (!equals) {
                    qCl = 2;
                    AppMethodBeat.m2505o(35652);
                    return;
                }
            } else if (C29036i.m46114i(c46236n)) {
                if (equals) {
                    qCl = 6;
                    AppMethodBeat.m2505o(35652);
                    return;
                }
                qCl = 3;
            }
            AppMethodBeat.m2505o(35652);
        } else if (equals) {
            qCl = 4;
            AppMethodBeat.m2505o(35652);
        } else {
            qCl = 1;
            AppMethodBeat.m2505o(35652);
        }
    }

    /* JADX WARNING: Missing block: B:25:0x0071, code skipped:
            if (r8.field_type != 2) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m33409a(Context context, C46236n c46236n) {
        int i = 2;
        AppMethodBeat.m2504i(35653);
        if (!(!qCh || c46236n == null || context == null)) {
            qCm = c46236n.field_snsId;
            C21865a.m33413a(c46236n);
            Intent intent = new Intent(context, SnsNotInterestUI.class);
            intent.putExtra("sns_info_svr_id", qCm);
            String str = "sns_info_not_interest_scene";
            if (qCh && !C5046bo.isNullOrNil(qCi)) {
                if (qCi.equals("1") || qCi.equals("2")) {
                    i = 1;
                    intent.putExtra(str, i);
                    context.startActivity(intent);
                } else if (qCi.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                    if (C29036i.m46114i(c46236n)) {
                        i = 4;
                    } else if (c46236n.field_type == 1) {
                        i = 3;
                    }
                    intent.putExtra(str, i);
                    context.startActivity(intent);
                }
            }
            i = 0;
            intent.putExtra(str, i);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(35653);
    }

    /* renamed from: a */
    public static void m33410a(ContextMenu contextMenu, C46236n c46236n) {
        AppMethodBeat.m2504i(35654);
        if (!(!qCh || !qCi.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || c46236n == null || c46236n.mo74253DI(32) || c46236n.field_userName.equals(C13373af.cnk()) || c46236n.field_type == 15)) {
            contextMenu.add(0, 13, 0, C25738R.string.el_);
        }
        AppMethodBeat.m2505o(35654);
    }

    /* renamed from: a */
    public static void m33412a(View view, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(35655);
        if (!(!qCh || C5046bo.isNullOrNil(qCi) || qCi.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            baseViewHolder.rIo = (ImageView) view.findViewById(2131827905);
            baseViewHolder.rIo.setVisibility(8);
            baseViewHolder.rIp = false;
            if (!qCi.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                baseViewHolder.rIo.setOnClickListener(qCj);
            }
        }
        AppMethodBeat.m2505o(35655);
    }

    /* renamed from: b */
    public static void m33415b(C46236n c46236n) {
        AppMethodBeat.m2504i(35656);
        if (qCh) {
            qCm = c46236n.field_snsId;
            C21865a.m33413a(c46236n);
        }
        AppMethodBeat.m2505o(35656);
    }

    public static void clean() {
        AppMethodBeat.m2504i(35657);
        qCl = -1;
        qCk = -1;
        qCm = 0;
        qCj = null;
        qCp = null;
        qCn = null;
        context = null;
        qCh = false;
        qCi = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        C18608f.m29045oU("7");
        C4879a.xxA.mo10053d(qCq);
        C4879a.xxA.mo10053d(qCr);
        AppMethodBeat.m2505o(35657);
    }

    /* renamed from: BK */
    static /* synthetic */ void m33408BK() {
        AppMethodBeat.m2504i(35658);
        if (qCh && qCm != 0) {
            String str = qCk + "|" + qCl + "|" + qCm;
            C26407g.aaK().mo60654oP("7").fob = 4;
            C26407g.aaK().mo60654oP("7").result = str;
            C18608f.m29040a(C26407g.aaK().mo60654oP("7"));
            C4990ab.m7411d("MicroMsg.NotInteresetABTestManager", "report not interest abtest, scene:%d, result:%s", Integer.valueOf(4), str);
        }
        qCl = -1;
        qCk = -1;
        qCm = 0;
        AppMethodBeat.m2505o(35658);
    }

    /* renamed from: a */
    static /* synthetic */ void m33411a(View view, Context context, C46236n c46236n) {
        AppMethodBeat.m2504i(35659);
        if (context != null) {
            if (c46236n != null) {
                qCm = c46236n.field_snsId;
            }
            C21870b c21870b = qCo;
            if (view == null || c21870b.qCN) {
                AppMethodBeat.m2505o(35659);
                return;
            }
            C4879a.xxA.mo10055m(new C41971bv());
            if (c21870b.qCL) {
                c21870b.cma();
                AppMethodBeat.m2505o(35659);
                return;
            }
            int i;
            if (c21870b.iJp == 0) {
                c21870b.iJp = C5222ae.m7947hA(context);
            }
            if (c21870b.acV == 0) {
                c21870b.acV = C30036f.m47543fD(context);
            }
            if (c21870b.qCG == 0) {
                c21870b.qCG = view.getMeasuredHeight();
                if (c21870b.qCG <= 0) {
                    c21870b.qCG = C1338a.fromDPToPix(context, 15);
                }
            }
            if (c21870b.qCH <= 0) {
                c21870b.qCH = C1338a.fromDPToPix(context, 8);
            }
            if (c21870b.qCI <= 0) {
                c21870b.qCI = C1338a.fromDPToPix(context, 3);
            }
            if (c21870b.mScreenHeight == 0) {
                c21870b.mScreenHeight = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
                c21870b.mScreenHeight -= c21870b.acV;
                c21870b.mScreenHeight -= c21870b.iJp;
            }
            if (c21870b.qCJ == 0) {
                c21870b.qCJ = C1338a.fromDPToPix(context, 150);
            }
            if (c21870b.qCK == 0) {
                c21870b.qCK = C1338a.fromDPToPix(context, 13);
            }
            c21870b.qCz = new NotInterestMenu(context);
            if (c21870b.qCu != null) {
                c21870b.qCz.setOnSelectMenuItemListener(c21870b.qCu);
            }
            c21870b.qCz.setOnClickMenuListener(c21870b.qCB);
            c21870b.qCz.setSnsInfo(c46236n);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            C4990ab.m7411d("MicroMsg.NotInterestMenuHelper", "hateLocation: %s", Arrays.toString(iArr));
            int i2 = (((iArr[1] - c21870b.iJp) - c21870b.acV) + c21870b.qCG) - c21870b.qCH;
            C4990ab.m7411d("MicroMsg.NotInterestMenuHelper", "getDownModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickDownPadding:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i2), Integer.valueOf(c21870b.iJp), Integer.valueOf(c21870b.acV), Integer.valueOf(c21870b.qCG), Integer.valueOf(c21870b.qCH));
            C4990ab.m7411d("MicroMsg.NotInterestMenuHelper", "isEnoughHeightToDownMenu, y:%d, menuHeight:%d, screenHeight:%d", Integer.valueOf(i2), Integer.valueOf(c21870b.qCJ), Integer.valueOf(c21870b.mScreenHeight));
            if (c21870b.qCJ + i2 > c21870b.mScreenHeight) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                c21870b.qCz.setBackgroundResource(C25738R.drawable.bdc);
                c21870b.qCO = true;
            } else {
                c21870b.qCz.setBackgroundResource(C25738R.drawable.bdd);
                i2 = (((iArr[1] - c21870b.iJp) - c21870b.acV) - c21870b.qCJ) + c21870b.qCI;
                C4990ab.m7411d("MicroMsg.NotInterestMenuHelper", "getUpModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickUpPadding:%d, mMenuHeight:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i2), Integer.valueOf(c21870b.iJp), Integer.valueOf(c21870b.acV), Integer.valueOf(c21870b.qCG), Integer.valueOf(c21870b.qCI), Integer.valueOf(c21870b.qCJ));
                c21870b.qCO = false;
            }
            if (c21870b.qCM == null) {
                c21870b.qCM = new AbsoluteLayout(context);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                c21870b.qCM.setBackgroundDrawable(context.getResources().getDrawable(C25738R.drawable.f6663lo));
                c21870b.qCM.setPadding(c21870b.qCK, 0, c21870b.qCK, 0);
                c21870b.qCM.setLayoutParams(layoutParams);
            }
            if (c21870b.qCA != null) {
                c21870b.qCA.addView(c21870b.qCM);
            }
            c21870b.qCM.addView(c21870b.qCz, new AbsoluteLayout.LayoutParams(-1, -2, 0, i2));
            c21870b.qCz.setVisibility(4);
            if (c21870b.qCO) {
                c21870b.qCz.startAnimation(c21870b.qCC);
                AppMethodBeat.m2505o(35659);
                return;
            }
            c21870b.qCz.startAnimation(c21870b.qCD);
        }
        AppMethodBeat.m2505o(35659);
    }

    /* renamed from: b */
    static /* synthetic */ void m33414b(Context context, C46236n c46236n) {
        AppMethodBeat.m2504i(35660);
        if (!(c46236n == null || context == null)) {
            C21865a.m33413a(c46236n);
            String str = c46236n.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str);
            intent.putExtra("sns_permission_snsinfo_svr_id", c46236n.field_snsId);
            intent.putExtra("sns_permission_block_scene", 6);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.m2505o(35660);
    }
}
