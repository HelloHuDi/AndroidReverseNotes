package com.tencent.mm.plugin.sns.abtest;

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
import com.tencent.mm.R;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.g.a.rd;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsNotInterestUI;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Arrays;

public final class a {
    private static Context context = null;
    private static boolean qCh = false;
    private static String qCi = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private static OnClickListener qCj = null;
    private static int qCk = -1;
    private static int qCl = -1;
    private static long qCm = 0;
    private static View qCn = null;
    private static b qCo = null;
    private static c qCp = null;
    private static com.tencent.mm.sdk.b.c qCq = new com.tencent.mm.sdk.b.c<rd>() {
        {
            AppMethodBeat.i(35642);
            this.xxI = rd.class.getName().hashCode();
            AppMethodBeat.o(35642);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(35643);
            rd rdVar = (rd) bVar;
            if (rdVar instanceof rd) {
                boolean z = rdVar.cNh.cNi;
                long j = rdVar.cNh.cBh;
                ab.d("MicroMsg.NotInteresetABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", Boolean.valueOf(z), Long.valueOf(j));
                if (!(j == 0 || a.qCm == 0 || a.qCm != j)) {
                    if (z) {
                        a.qCk = 4;
                    } else {
                        a.qCk = 3;
                    }
                    a.BK();
                }
            }
            AppMethodBeat.o(35643);
            return false;
        }
    };
    private static com.tencent.mm.sdk.b.c qCr = new com.tencent.mm.sdk.b.c<gm>() {
        {
            AppMethodBeat.i(35644);
            this.xxI = gm.class.getName().hashCode();
            AppMethodBeat.o(35644);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(35645);
            gm gmVar = (gm) bVar;
            if (gmVar instanceof gm) {
                boolean z = gmVar.cBf.cBg;
                long j = gmVar.cBf.cBh;
                ab.d("MicroMsg.NotInteresetABTestManager", "notInterestFinishEventListener callback, isNotInterest:%b, sndId:%d", Boolean.valueOf(z), Long.valueOf(j));
                if (!(j == 0 || a.qCm == 0 || j != a.qCm)) {
                    if (z) {
                        a.qCk = 2;
                    } else {
                        a.qCk = 1;
                    }
                    a.BK();
                }
            }
            AppMethodBeat.o(35645);
            return false;
        }
    };

    static {
        AppMethodBeat.i(35662);
        AppMethodBeat.o(35662);
    }

    public static void c(Context context, ViewGroup viewGroup) {
        AppMethodBeat.i(35650);
        if (g.aaK().oP("7") != null) {
            qCh = true;
            qCi = g.aaK().oP("7").value;
            ab.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", qCi);
            qCn = viewGroup;
            qCo = new b(viewGroup);
            context = context;
            com.tencent.mm.sdk.b.a.xxA.c(qCq);
            com.tencent.mm.sdk.b.a.xxA.c(qCr);
            qCj = new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(35646);
                    if (view.getTag() instanceof n) {
                        a.a(view, view.getContext(), (n) view.getTag());
                    }
                    AppMethodBeat.o(35646);
                }
            };
            qCp = new c() {
                public final void c(n nVar) {
                    AppMethodBeat.i(35647);
                    a.a(a.context, nVar);
                    AppMethodBeat.o(35647);
                }

                public final void d(n nVar) {
                    AppMethodBeat.i(35648);
                    a.b(a.context, nVar);
                    AppMethodBeat.o(35648);
                }

                public final void e(n nVar) {
                    AppMethodBeat.i(35649);
                    a.c(a.context, nVar);
                    AppMethodBeat.o(35649);
                }
            };
            qCo.qCu = qCp;
        }
        AppMethodBeat.o(35650);
    }

    public static void clW() {
        AppMethodBeat.i(35651);
        if (qCo != null) {
            qCo.cma();
        }
        AppMethodBeat.o(35651);
    }

    private static void a(n nVar) {
        AppMethodBeat.i(35652);
        boolean equals = qCi.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (nVar.field_type == 1) {
            if (equals) {
                qCl = 5;
                AppMethodBeat.o(35652);
                return;
            }
            qCl = 0;
            AppMethodBeat.o(35652);
        } else if (nVar.field_type != 2) {
            if (nVar.field_type == 15) {
                if (!equals) {
                    qCl = 2;
                    AppMethodBeat.o(35652);
                    return;
                }
            } else if (i.i(nVar)) {
                if (equals) {
                    qCl = 6;
                    AppMethodBeat.o(35652);
                    return;
                }
                qCl = 3;
            }
            AppMethodBeat.o(35652);
        } else if (equals) {
            qCl = 4;
            AppMethodBeat.o(35652);
        } else {
            qCl = 1;
            AppMethodBeat.o(35652);
        }
    }

    /* JADX WARNING: Missing block: B:25:0x0071, code skipped:
            if (r8.field_type != 2) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Context context, n nVar) {
        int i = 2;
        AppMethodBeat.i(35653);
        if (!(!qCh || nVar == null || context == null)) {
            qCm = nVar.field_snsId;
            a(nVar);
            Intent intent = new Intent(context, SnsNotInterestUI.class);
            intent.putExtra("sns_info_svr_id", qCm);
            String str = "sns_info_not_interest_scene";
            if (qCh && !bo.isNullOrNil(qCi)) {
                if (qCi.equals("1") || qCi.equals("2")) {
                    i = 1;
                    intent.putExtra(str, i);
                    context.startActivity(intent);
                } else if (qCi.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                    if (i.i(nVar)) {
                        i = 4;
                    } else if (nVar.field_type == 1) {
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
        AppMethodBeat.o(35653);
    }

    public static void a(ContextMenu contextMenu, n nVar) {
        AppMethodBeat.i(35654);
        if (!(!qCh || !qCi.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) || nVar == null || nVar.DI(32) || nVar.field_userName.equals(af.cnk()) || nVar.field_type == 15)) {
            contextMenu.add(0, 13, 0, R.string.el_);
        }
        AppMethodBeat.o(35654);
    }

    public static void a(View view, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(35655);
        if (!(!qCh || bo.isNullOrNil(qCi) || qCi.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO))) {
            baseViewHolder.rIo = (ImageView) view.findViewById(R.id.emz);
            baseViewHolder.rIo.setVisibility(8);
            baseViewHolder.rIp = false;
            if (!qCi.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                baseViewHolder.rIo.setOnClickListener(qCj);
            }
        }
        AppMethodBeat.o(35655);
    }

    public static void b(n nVar) {
        AppMethodBeat.i(35656);
        if (qCh) {
            qCm = nVar.field_snsId;
            a(nVar);
        }
        AppMethodBeat.o(35656);
    }

    public static void clean() {
        AppMethodBeat.i(35657);
        qCl = -1;
        qCk = -1;
        qCm = 0;
        qCj = null;
        qCp = null;
        qCn = null;
        context = null;
        qCh = false;
        qCi = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        f.oU("7");
        com.tencent.mm.sdk.b.a.xxA.d(qCq);
        com.tencent.mm.sdk.b.a.xxA.d(qCr);
        AppMethodBeat.o(35657);
    }

    static /* synthetic */ void BK() {
        AppMethodBeat.i(35658);
        if (qCh && qCm != 0) {
            String str = qCk + "|" + qCl + "|" + qCm;
            g.aaK().oP("7").fob = 4;
            g.aaK().oP("7").result = str;
            f.a(g.aaK().oP("7"));
            ab.d("MicroMsg.NotInteresetABTestManager", "report not interest abtest, scene:%d, result:%s", Integer.valueOf(4), str);
        }
        qCl = -1;
        qCk = -1;
        qCm = 0;
        AppMethodBeat.o(35658);
    }

    static /* synthetic */ void a(View view, Context context, n nVar) {
        AppMethodBeat.i(35659);
        if (context != null) {
            if (nVar != null) {
                qCm = nVar.field_snsId;
            }
            b bVar = qCo;
            if (view == null || bVar.qCN) {
                AppMethodBeat.o(35659);
                return;
            }
            com.tencent.mm.sdk.b.a.xxA.m(new bv());
            if (bVar.qCL) {
                bVar.cma();
                AppMethodBeat.o(35659);
                return;
            }
            int i;
            if (bVar.iJp == 0) {
                bVar.iJp = ae.hA(context);
            }
            if (bVar.acV == 0) {
                bVar.acV = com.tencent.mm.pluginsdk.f.fD(context);
            }
            if (bVar.qCG == 0) {
                bVar.qCG = view.getMeasuredHeight();
                if (bVar.qCG <= 0) {
                    bVar.qCG = com.tencent.mm.bz.a.fromDPToPix(context, 15);
                }
            }
            if (bVar.qCH <= 0) {
                bVar.qCH = com.tencent.mm.bz.a.fromDPToPix(context, 8);
            }
            if (bVar.qCI <= 0) {
                bVar.qCI = com.tencent.mm.bz.a.fromDPToPix(context, 3);
            }
            if (bVar.mScreenHeight == 0) {
                bVar.mScreenHeight = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
                bVar.mScreenHeight -= bVar.acV;
                bVar.mScreenHeight -= bVar.iJp;
            }
            if (bVar.qCJ == 0) {
                bVar.qCJ = com.tencent.mm.bz.a.fromDPToPix(context, 150);
            }
            if (bVar.qCK == 0) {
                bVar.qCK = com.tencent.mm.bz.a.fromDPToPix(context, 13);
            }
            bVar.qCz = new NotInterestMenu(context);
            if (bVar.qCu != null) {
                bVar.qCz.setOnSelectMenuItemListener(bVar.qCu);
            }
            bVar.qCz.setOnClickMenuListener(bVar.qCB);
            bVar.qCz.setSnsInfo(nVar);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            ab.d("MicroMsg.NotInterestMenuHelper", "hateLocation: %s", Arrays.toString(iArr));
            int i2 = (((iArr[1] - bVar.iJp) - bVar.acV) + bVar.qCG) - bVar.qCH;
            ab.d("MicroMsg.NotInterestMenuHelper", "getDownModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickDownPadding:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i2), Integer.valueOf(bVar.iJp), Integer.valueOf(bVar.acV), Integer.valueOf(bVar.qCG), Integer.valueOf(bVar.qCH));
            ab.d("MicroMsg.NotInterestMenuHelper", "isEnoughHeightToDownMenu, y:%d, menuHeight:%d, screenHeight:%d", Integer.valueOf(i2), Integer.valueOf(bVar.qCJ), Integer.valueOf(bVar.mScreenHeight));
            if (bVar.qCJ + i2 > bVar.mScreenHeight) {
                i = 0;
            } else {
                i = 1;
            }
            if (i != 0) {
                bVar.qCz.setBackgroundResource(R.drawable.bdc);
                bVar.qCO = true;
            } else {
                bVar.qCz.setBackgroundResource(R.drawable.bdd);
                i2 = (((iArr[1] - bVar.iJp) - bVar.acV) - bVar.qCJ) + bVar.qCI;
                ab.d("MicroMsg.NotInterestMenuHelper", "getUpModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickUpPadding:%d, mMenuHeight:%d", Integer.valueOf(iArr[1]), Integer.valueOf(i2), Integer.valueOf(bVar.iJp), Integer.valueOf(bVar.acV), Integer.valueOf(bVar.qCG), Integer.valueOf(bVar.qCI), Integer.valueOf(bVar.qCJ));
                bVar.qCO = false;
            }
            if (bVar.qCM == null) {
                bVar.qCM = new AbsoluteLayout(context);
                LayoutParams layoutParams = new LayoutParams(-1, -1);
                bVar.qCM.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.lo));
                bVar.qCM.setPadding(bVar.qCK, 0, bVar.qCK, 0);
                bVar.qCM.setLayoutParams(layoutParams);
            }
            if (bVar.qCA != null) {
                bVar.qCA.addView(bVar.qCM);
            }
            bVar.qCM.addView(bVar.qCz, new AbsoluteLayout.LayoutParams(-1, -2, 0, i2));
            bVar.qCz.setVisibility(4);
            if (bVar.qCO) {
                bVar.qCz.startAnimation(bVar.qCC);
                AppMethodBeat.o(35659);
                return;
            }
            bVar.qCz.startAnimation(bVar.qCD);
        }
        AppMethodBeat.o(35659);
    }

    static /* synthetic */ void b(Context context, n nVar) {
        AppMethodBeat.i(35660);
        if (!(nVar == null || context == null)) {
            a(nVar);
            String str = nVar.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str);
            intent.putExtra("sns_permission_snsinfo_svr_id", nVar.field_snsId);
            intent.putExtra("sns_permission_block_scene", 6);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
        AppMethodBeat.o(35660);
    }
}
