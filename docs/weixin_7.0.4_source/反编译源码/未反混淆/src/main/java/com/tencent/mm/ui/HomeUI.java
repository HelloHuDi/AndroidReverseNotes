package com.tencent.mm.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.booter.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.cq;
import com.tencent.mm.model.av;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.network.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.contact.k;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
@TargetApi(11)
public class HomeUI implements com.tencent.mm.plugin.appbrand.widget.header.a, b, c, d {
    public static Boolean yiE = Boolean.FALSE;
    public static Boolean yiF = Boolean.FALSE;
    private String cIe = null;
    private int clickCount = 0;
    View contentView;
    LayoutInflater ezi;
    private boolean gwZ = true;
    IdleHandler jQs = new IdleHandler() {
        public final boolean queueIdle() {
            int i;
            AppMethodBeat.i(29361);
            aw.ZK();
            if (ah.h((Integer) c.Ry().get(15, null)) == 0) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 != 0) {
                ab.e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
                AppMethodBeat.o(29361);
            } else {
                String T = av.fly.T("login_user_name", "");
                if (aw.ZM() || !T.equals("")) {
                    aw.Rg().a(new bk(new com.tencent.mm.model.bk.a() {
                        public final void a(e eVar) {
                        }
                    }, "launch normal"), 0);
                }
                d.post(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:12:0x00cb  */
                    /* JADX WARNING: Removed duplicated region for block: B:7:0x00bf  */
                    /* JADX WARNING: Removed duplicated region for block: B:22:0x0135  */
                    /* JADX WARNING: Removed duplicated region for block: B:22:0x0135  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        String str;
                        Throwable e;
                        AppMethodBeat.i(15873);
                        long anU = ah.anU();
                        Process.setThreadPriority(10);
                        w wVar = w.this;
                        int i = g.cdf;
                        String LM = q.LM();
                        int i2 = com.tencent.mm.protocal.d.vxo;
                        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        String dor = aa.dor();
                        int i3 = wVar.context.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.doA(), 0).getInt("last_reportdevice_channel", 0);
                        int i4 = wVar.context.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.doA(), 0).getInt("last_reportdevice_clientversion", 0);
                        if (i3 == 0 && i4 == 0) {
                            i4 = 0;
                        } else if (i3 == i && i4 == i2) {
                            str = null;
                            ab.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str);
                            if (ah.isNullOrNil(str)) {
                                u a;
                                try {
                                    a = b.a(str, null);
                                    try {
                                        a.setConnectTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                                        a.setReadTimeout(Downloads.MIN_WAIT_FOR_NETWORK);
                                        a.connect();
                                        if (a.getResponseCode() == 200) {
                                            w wVar2 = w.this;
                                            i2 = g.cdf;
                                            int i5 = com.tencent.mm.protocal.d.vxo;
                                            SharedPreferences sharedPreferences = wVar2.context.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.doA(), 0);
                                            sharedPreferences.edit().putInt("last_reportdevice_channel", i2).commit();
                                            sharedPreferences.edit().putInt("last_reportdevice_clientversion", i5).commit();
                                        }
                                        ab.d("MicroMsg.StartupReport", "report FIN time:%d resp:%d url[%s]", Long.valueOf(ah.gb(anU)), Integer.valueOf(r3), str);
                                    } catch (Exception e2) {
                                        e = e2;
                                        ab.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                                        ab.e("MicroMsg.StartupReport", "tryReport error url[%s]", str);
                                        if (a != null) {
                                        }
                                        AppMethodBeat.o(15873);
                                        return;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    a = null;
                                    ab.printErrStackTrace("MicroMsg.StartupReport", e, "", new Object[0]);
                                    ab.e("MicroMsg.StartupReport", "tryReport error url[%s]", str);
                                    if (a != null) {
                                    }
                                    AppMethodBeat.o(15873);
                                    return;
                                }
                                if (a != null) {
                                    a.connection.disconnect();
                                }
                                AppMethodBeat.o(15873);
                                return;
                            }
                            AppMethodBeat.o(15873);
                            return;
                        } else {
                            i4 = 1;
                        }
                        str = "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/reportdevice?channel=" + g.cdf + "&deviceid=" + LM + "&clientversion=" + i2 + "&platform=" + str2 + "&lang=" + dor + "&installtype=" + i4;
                        ab.i("MicroMsg.StartupReport", "tryReport thread:%s pri:%d  Url[%s] ", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())), str);
                        if (ah.isNullOrNil(str)) {
                        }
                    }
                }, "StartupReport_report");
                n.IE();
                HomeUI.dxw();
                f.cgq();
                com.tencent.mm.at.n.c cVar = com.tencent.mm.at.n.ahb().fFM;
                if (cVar.fGb.size() <= 0 && cVar.fGa.size() <= 0) {
                    T = (String) com.tencent.mm.kernel.g.RP().Ry().get(348177, (Object) "");
                    String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(348176, (Object) "");
                    if (!bo.isNullOrNil(T)) {
                        synchronized (cVar) {
                            try {
                                for (String su : T.split("-")) {
                                    b su2 = com.tencent.mm.at.n.c.su(su);
                                    if (su2 != null) {
                                        cVar.fGb.add(su2);
                                    }
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.o(29361);
                                }
                            }
                        }
                    }
                    if (!bo.isNullOrNil(str)) {
                        synchronized (cVar) {
                            try {
                                for (String st : str.split("-")) {
                                    b st2 = com.tencent.mm.at.n.c.st(st);
                                    if (st2 != null) {
                                        cVar.fGa.add(st2);
                                    }
                                }
                            } catch (Throwable th2) {
                                while (true) {
                                    AppMethodBeat.o(29361);
                                }
                            }
                        }
                    }
                    ab.i("MicroMsg.SendImgSpeeder", "Image pool bigfile pool size %d, thumbfile size %d ", Integer.valueOf(cVar.fGa.size()), Integer.valueOf(cVar.fGb.size()));
                }
                cVar.ahf();
                Looper.myQueue().removeIdleHandler(HomeUI.this.jQs);
                AppMethodBeat.o(29361);
            }
            return false;
        }
    };
    ActionBar mActionBar;
    private long mSj = 0;
    com.tencent.mm.sdk.b.c qjs = new com.tencent.mm.sdk.b.c<cq>() {
        {
            AppMethodBeat.i(29358);
            this.xxI = cq.class.getName().hashCode();
            AppMethodBeat.o(29358);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(29359);
            if (HomeUI.this.yiW != null) {
                HomeUI.this.yiW.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(29356);
                        HomeUI.u(HomeUI.this);
                        AppMethodBeat.o(29356);
                    }

                    public final String toString() {
                        AppMethodBeat.i(29357);
                        String str = super.toString() + "|updatePlusMenuNewTips";
                        AppMethodBeat.o(29357);
                        return str;
                    }
                });
            }
            HomeUI.this.yiP.dyE();
            AppMethodBeat.o(29359);
            return false;
        }
    };
    boolean qlP = false;
    private View rKY;
    private final long ryi = 300;
    private long ryj = SystemClock.elapsedRealtime();
    private final HashMap<String, Object> values = new HashMap();
    private TextView yeR;
    View yfm;
    MMFragmentActivity yhZ;
    private String yiA;
    private String yiB;
    private String yiC;
    aa yiD;
    private final long yiG = 432000000;
    private final long yiH = 604800000;
    private boolean yiI = true;
    private int yiJ = 0;
    private int yiK = 0;
    private int yiL = 0;
    a yiM = a.ACTIVITY_CREATE;
    a yiN;
    h yiO;
    MainTabUI yiP = new MainTabUI();
    int yiQ = 0;
    int yiR = 0;
    private boolean yiS = false;
    boolean yiT = true;
    OnLayoutChangeListener yiU = new OnLayoutChangeListener() {
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        }
    };
    private boolean yiV = aa.don();
    View yiW;
    ImageView yiX;
    View yiY;
    ImageView yiZ;
    private final long yiu = 604800000;
    public boolean yiv = false;
    boolean yiw;
    public boolean yix = false;
    private TextView yiy;
    private boolean yiz = false;
    View yja;
    MenuItem yjb;
    MenuItem yjc;
    private MenuItem yjd;
    MenuItem yje;
    Menu yjf;
    private boolean yjg = true;
    Runnable yjh = new Runnable() {
        public final void run() {
            AppMethodBeat.i(29362);
            if (!com.tencent.mm.r.a.bI(HomeUI.this.yhZ) || com.tencent.mm.r.a.bH(HomeUI.this.yhZ)) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                h.pYm.e(11409, new Object[0]);
                com.tencent.mm.bp.d.b(HomeUI.this.yhZ, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.o(29362);
                return;
            }
            AppMethodBeat.o(29362);
        }
    };
    private int yji = 0;
    private LinkedList<Runnable> yjj = new LinkedList();
    o yjk = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(29378);
            if (ah.nullAsNil(str).equals("showprivacypolicy") && map != null) {
                String str2 = (String) map.get(".sysmsg.showprivacypolicy.device_id");
                HomeUI.this.yiA = (String) map.get(".sysmsg.showprivacypolicy.doublecheck_content");
                HomeUI.this.yiB = (String) map.get(".sysmsg.showprivacypolicy.doublecheck_ok");
                HomeUI.this.yiC = (String) map.get(".sysmsg.showprivacypolicy.doublecheck_cancel");
                boolean equals = "yes".equals(map.get(".sysmsg.showprivacypolicy.needbirthday"));
                boolean equals2 = "yes".equals(map.get(".sysmsg.showprivacypolicy.needopenplatform"));
                boolean equals3 = "yes".equals(map.get(".sysmsg.showprivacypolicy.needconfirm"));
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_NEED_BIRTHDAY_BOOLEAN_SYNC, Boolean.valueOf(equals));
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.valueOf(equals2));
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_NEED_CONFIRM_BOOLEAN_SYNC, Boolean.valueOf(equals3));
                com.tencent.mm.bt.b bI = com.tencent.mm.bt.b.bI(q.LM().getBytes());
                bI.Lv(16);
                ab.i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", str2, Base64.encodeToString(bI.toByteArray(), 2), HomeUI.this.yiA, HomeUI.this.yiB, HomeUI.this.yiC, Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(equals3));
                if (ah.isNullOrNil(str2) || str2.equals(r4)) {
                    String obj = com.tencent.mm.kernel.g.RP().Ry().get(274436, (Object) "").toString();
                    MMFragmentActivity b = HomeUI.this.yhZ;
                    Object[] objArr = new Object[5];
                    objArr[0] = aa.dor();
                    objArr[1] = obj;
                    objArr[2] = "login";
                    objArr[3] = Integer.valueOf(1);
                    objArr[4] = Integer.valueOf(equals2 ? 1 : 0);
                    str2 = b.getString(R.string.g7o, objArr);
                    Bundle bundle;
                    if (com.tencent.mm.au.b.sO(obj)) {
                        ab.i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", Boolean.valueOf(equals3));
                        if (equals3) {
                            HomeUI.a(HomeUI.this, str2, 22722, HomeUI.this.yhZ.getString(R.string.g7n, new Object[]{aa.dor()}));
                        } else {
                            bundle = new Bundle();
                            bundle.putString("close_dialog_msg", HomeUI.this.yiA);
                            bundle.putString("close_dialog_cancel", HomeUI.this.yiC);
                            bundle.putString("close_dialog_ok", HomeUI.this.yiB);
                            bundle.putBoolean("close_dialog_ok_close", false);
                            HomeUI.a(HomeUI.this, str2, 22722, bundle);
                        }
                    } else {
                        ab.i("MicroMsg.LauncherUI.HomeUI", "eu false");
                        bundle = new Bundle();
                        bundle.putString("close_dialog_msg", HomeUI.this.yhZ.getString(R.string.cmh));
                        bundle.putString("close_dialog_cancel", HomeUI.this.yhZ.getString(R.string.cpf));
                        bundle.putString("close_dialog_ok", HomeUI.this.yhZ.getString(R.string.cmj));
                        bundle.putBoolean("close_dialog_ok_close", false);
                        HomeUI.a(HomeUI.this, str2, 22722, bundle);
                    }
                    com.tencent.mm.ui.base.b.hN(HomeUI.this.yhZ);
                    AppMethodBeat.o(29378);
                    return;
                }
                ab.i("MicroMsg.LauncherUI.HomeUI", "device id not match");
            }
            AppMethodBeat.o(29378);
        }
    };
    private float yjl = 0.0f;

    enum a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE;

        static {
            AppMethodBeat.o(29387);
        }
    }

    public static class FitSystemWindowLayoutView extends FrameLayout {
        private Rect mRect = new Rect();
        private int yjv;
        private ViewGroup yjw = null;

        public FitSystemWindowLayoutView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(29388);
            AppMethodBeat.o(29388);
        }

        public FitSystemWindowLayoutView(Context context) {
            super(context);
            AppMethodBeat.i(29389);
            AppMethodBeat.o(29389);
        }

        public int getCacheInsetsTop() {
            return this.yjv;
        }

        public void setActionBarContainer(ViewGroup viewGroup) {
            this.yjw = viewGroup;
        }

        @TargetApi(14)
        public boolean fitSystemWindows(Rect rect) {
            View childAt;
            boolean fitSystemWindows;
            AppMethodBeat.i(29390);
            String str = "MicroMsg.LauncherUI";
            String str2 = "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = rect.toString();
            objArr[1] = Integer.valueOf(this.yjv);
            objArr[2] = Integer.valueOf(hashCode());
            objArr[3] = rect.height() == 0 ? ah.anW() : "pass";
            ab.i(str, str2, objArr);
            if (rect.top > 0) {
                this.yjv = rect.top;
            }
            if (this.yjw != null && (this.yjw.getLayoutParams() instanceof MarginLayoutParams)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.yjw.getLayoutParams();
                int i = marginLayoutParams.bottomMargin;
                int i2 = marginLayoutParams.rightMargin;
                ab.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", Integer.valueOf(i), Integer.valueOf(i2));
                int i3 = 0;
                while (i3 < getChildCount()) {
                    childAt = getChildAt(i3);
                    if (childAt instanceof TestTimeForChatting) {
                        TestTimeForChatting testTimeForChatting = (TestTimeForChatting) childAt;
                        if (Float.compare((float) i, ((float) com.tencent.mm.bz.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 1.5f) > 0 || i < 0) {
                            ab.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", Integer.valueOf(i));
                            testTimeForChatting.zHY = 0;
                        } else {
                            testTimeForChatting.zHY = i;
                        }
                        if (Float.compare((float) i2, ((float) com.tencent.mm.bz.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 1.5f) > 0 || i2 < 0) {
                            ab.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", Integer.valueOf(i));
                            testTimeForChatting.zHZ = 0;
                        } else {
                            testTimeForChatting.zHZ = i2;
                        }
                        ab.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", Integer.valueOf(i), Integer.valueOf(i2));
                        ae.J(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    } else {
                        i3++;
                    }
                }
                ae.J(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            this.mRect.set(rect);
            if (com.tencent.mm.compatible.util.d.iW(14)) {
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    childAt = getChildAt(i4);
                    if (childAt instanceof TestTimeForChatting) {
                        childAt.setFitsSystemWindows(true);
                        fitSystemWindows = ((TestTimeForChatting) childAt).fitSystemWindows(rect);
                        childAt.setFitsSystemWindows(false);
                        break;
                    }
                }
            }
            fitSystemWindows = false;
            ab.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", Boolean.valueOf(fitSystemWindows), Integer.valueOf(VERSION.SDK_INT));
            ab.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", Boolean.valueOf(super.fitSystemWindows(this.mRect)));
            AppMethodBeat.o(29390);
            return super.fitSystemWindows(this.mRect);
        }

        /* Access modifiers changed, original: protected */
        public void onMeasure(int i, int i2) {
            int i3;
            View childAt;
            AppMethodBeat.i(29391);
            try {
                super.onMeasure(i, i2);
                AppMethodBeat.o(29391);
            } catch (ClassCastException e) {
                ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
                ab.e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", getLayoutParams(), getLayoutParams().getClass());
                int childCount = getChildCount();
                for (i3 = 0; i3 < childCount; i3++) {
                    childAt = getChildAt(i3);
                    ab.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", Integer.valueOf(i3), childAt, childAt.getLayoutParams(), childAt.getLayoutParams().getClass());
                }
                for (i3 = 0; i3 < childCount; i3++) {
                    childAt = getChildAt(i3);
                    if ((childAt instanceof ImageView) && childAt.getId() == R.id.c4 && childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof MarginLayoutParams) && !(childAt.getLayoutParams() instanceof LayoutParams)) {
                        childAt.setLayoutParams(new LayoutParams(childAt.getLayoutParams()));
                    }
                    ab.e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", Integer.valueOf(i3), childAt, childAt.getLayoutParams(), childAt.getLayoutParams().getClass());
                }
                super.onMeasure(i, i2);
                AppMethodBeat.o(29391);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$19 */
    class AnonymousClass19 implements OnClickListener {
        final /* synthetic */ int bVv;

        AnonymousClass19(int i) {
            this.bVv = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(29365);
            try {
                at.startSettingItent(HomeUI.this.yhZ, this.bVv);
                AppMethodBeat.o(29365);
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
                AppMethodBeat.o(29365);
            }
        }
    }

    public HomeUI() {
        AppMethodBeat.i(29392);
        AppMethodBeat.o(29392);
    }

    static /* synthetic */ void a(HomeUI homeUI) {
        AppMethodBeat.i(29422);
        homeUI.updateTitle();
        AppMethodBeat.o(29422);
    }

    static /* synthetic */ void l(HomeUI homeUI) {
        AppMethodBeat.i(29427);
        homeUI.dxm();
        AppMethodBeat.o(29427);
    }

    static /* synthetic */ void m(HomeUI homeUI) {
        AppMethodBeat.i(29428);
        homeUI.dxl();
        AppMethodBeat.o(29428);
    }

    static /* synthetic */ void n(HomeUI homeUI) {
        AppMethodBeat.i(29429);
        homeUI.dxj();
        AppMethodBeat.o(29429);
    }

    static /* synthetic */ void u(HomeUI homeUI) {
        AppMethodBeat.i(29431);
        homeUI.pH(true);
        AppMethodBeat.o(29431);
    }

    static /* synthetic */ void x(HomeUI homeUI) {
        AppMethodBeat.i(29433);
        homeUI.dwf();
        AppMethodBeat.o(29433);
    }

    public MainTabUI getMainTabUI() {
        return this.yiP;
    }

    @SuppressLint({"RestrictedApi"})
    private void updateTitle() {
        AppMethodBeat.i(29393);
        if (this.yiI) {
            CharSequence charSequence;
            int i = this.yiP.mbt;
            String string = getString(R.string.ru);
            Object charSequence2;
            if (i == 0) {
                if (com.tencent.mm.protocal.d.vxr) {
                    if (this.yiV) {
                        string = string + getString(R.string.fk);
                    } else {
                        string = string + " " + getString(R.string.fk);
                    }
                }
                if (this.yiP.ynE.dyJ() > 0) {
                    if (!this.yiV) {
                        string = string + " ";
                    }
                    charSequence2 = string + "(" + this.yiP.ynE.dyJ() + ")";
                }
                charSequence2 = string;
            } else if (i == 1) {
                charSequence2 = getString(R.string.cv_);
            } else if (i == 2) {
                charSequence2 = getString(R.string.cv8);
            } else {
                if (i == 3) {
                    charSequence2 = getString(R.string.cw4);
                }
                charSequence2 = string;
            }
            if (i == 3) {
                boolean z;
                MS(this.yhZ.getResources().getColor(R.color.a3p));
                if (dxt()) {
                    pJ(true);
                } else {
                    pJ(false);
                }
                ((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class)).checkPost();
                this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(R.color.a3p)));
                this.mActionBar.getCustomView().setVisibility(8);
                this.yjg = false;
                if (this.yiJ == 3 && this.yiK == 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (!(!z || this.yje == null || this.yje.isVisible())) {
                    this.yje.setVisible(true);
                }
            } else {
                MS(this.yhZ.getResources().getColor(R.color.vy));
                pJ(this.qlP);
                Drawable background = this.mActionBar.getCustomView().getBackground();
                if (!(background instanceof ColorDrawable)) {
                    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(R.color.vy)));
                } else if (((ColorDrawable) background).getColor() != this.yhZ.getResources().getColor(R.color.vy)) {
                    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(R.color.vy)));
                }
                if (this.mActionBar.getCustomView().getVisibility() != 0) {
                    this.mActionBar.getCustomView().setVisibility(0);
                }
                this.yjg = true;
                if (!(!dxh() || this.yjb == null || this.yjb.isVisible())) {
                    this.yjb.setVisible(true);
                }
                if (!(!dxh() || this.yjc == null || this.yjc.isVisible())) {
                    this.yjc.setVisible(true);
                }
            }
            this.mActionBar.setElevation(0.0f);
            this.mActionBar.fh();
            this.yiy = (TextView) this.mActionBar.getCustomView().findViewById(16908308);
            if (this.yiy != null) {
                this.yiy.setText(charSequence2);
                float am = ((float) com.tencent.mm.bz.a.am(com.tencent.mm.sdk.platformtools.ah.getContext(), R.dimen.dk)) * com.tencent.mm.bz.a.fY(com.tencent.mm.sdk.platformtools.ah.getContext());
                if (this.yiy.getTextSize() != am) {
                    this.yiy.setTextSize(0, am);
                }
                int color = this.yhZ.getResources().getColor(R.color.a6a);
                if (this.qlP && this.yiy.getCurrentTextColor() != color) {
                    this.yiy.setTextColor(color);
                }
            }
            AppMethodBeat.o(29393);
            return;
        }
        AppMethodBeat.o(29393);
    }

    private boolean dxh() {
        return this.yiJ == 2 && this.yiK == 2;
    }

    /* Access modifiers changed, original: final */
    public final void dxi() {
        AppMethodBeat.i(29394);
        if (aw.RK()) {
            aw.ZK();
            Boolean valueOf = Boolean.valueOf(ah.e((Boolean) c.Ry().get(340227, null)));
            if (!(valueOf.booleanValue() || k.zmx.booleanValue())) {
                yiE = Boolean.TRUE;
                pG(true);
            }
            long currentTimeMillis = System.currentTimeMillis();
            aw.ZK();
            currentTimeMillis -= ah.d((Long) c.Ry().get(340240, null));
            aw.ZK();
            Boolean valueOf2 = Boolean.valueOf(ah.e((Boolean) c.Ry().get(340230, null)));
            aw.ZK();
            Boolean valueOf3 = Boolean.valueOf(ah.e((Boolean) c.Ry().get(340228, null)));
            aw.ZK();
            Boolean valueOf4 = Boolean.valueOf(ah.e((Boolean) c.Ry().get(340229, null)));
            if (valueOf.booleanValue() && valueOf3.booleanValue() && valueOf4.booleanValue() && !valueOf2.booleanValue() && currentTimeMillis >= 432000000) {
                yiF = Boolean.TRUE;
                pG(false);
            }
            AppMethodBeat.o(29394);
            return;
        }
        ab.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
        AppMethodBeat.o(29394);
    }

    private void pG(final boolean z) {
        AppMethodBeat.i(29395);
        if (this.rKY != null) {
            ab.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
            AppMethodBeat.o(29395);
            return;
        }
        this.rKY = View.inflate(com.tencent.mm.sdk.platformtools.ah.getContext(), R.layout.aix, null);
        TextView textView = (TextView) this.rKY.findViewById(R.id.di4);
        if (z) {
            textView.setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.cj));
        } else {
            textView.setText(com.tencent.mm.sdk.platformtools.ah.getContext().getString(R.string.ch));
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2, 53);
        this.rKY.setBackgroundResource(R.drawable.bdv);
        if (this.contentView != null) {
            ((ViewGroup) this.contentView).addView(this.rKY, layoutParams);
            this.rKY.startAnimation(AnimationUtils.loadAnimation(com.tencent.mm.sdk.platformtools.ah.getContext(), R.anim.d4));
            this.rKY.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(29342);
                    HomeUI.this.yiD.gP();
                    if (z) {
                        HomeUI homeUI = HomeUI.this;
                        Boolean bool = Boolean.TRUE;
                        HomeUI.a(homeUI, bool, bool);
                        AppMethodBeat.o(29342);
                        return;
                    }
                    HomeUI.a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
                    AppMethodBeat.o(29342);
                }
            });
        }
        AppMethodBeat.o(29395);
    }

    private void c(Boolean bool, Boolean bool2) {
        AppMethodBeat.i(29396);
        if (this.rKY != null) {
            this.rKY.clearAnimation();
            this.rKY.setVisibility(8);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    aw.ZK();
                    c.Ry().set(340227, Boolean.TRUE);
                    h.pYm.a(232, 0, 1, false);
                    yiE = Boolean.FALSE;
                } else {
                    aw.ZK();
                    c.Ry().set(340230, Boolean.TRUE);
                    h.pYm.a(232, 5, 1, false);
                    yiF = Boolean.FALSE;
                }
            }
            this.rKY = null;
        }
        AppMethodBeat.o(29396);
    }

    /* Access modifiers changed, original: final */
    public final void dxj() {
        AppMethodBeat.i(29397);
        if (this.yiD == null || !aw.RK()) {
            AppMethodBeat.o(29397);
        } else if (this.yiD.isShowing()) {
            this.yiD.dismiss();
            AppMethodBeat.o(29397);
        } else {
            this.yiD.gP();
            AppMethodBeat.o(29397);
        }
    }

    /* Access modifiers changed, original: final */
    public final void pH(boolean z) {
        AppMethodBeat.i(29398);
        if (this.yiD == null || this.yiW == null) {
            AppMethodBeat.o(29398);
        } else if (aw.RK()) {
            int i;
            this.yiD.ypJ.pY(z);
            if (this.yiD.ypJ.ypC > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                this.yiY.setVisibility(0);
                AppMethodBeat.o(29398);
                return;
            }
            this.yiY.setVisibility(8);
            AppMethodBeat.o(29398);
        } else {
            ab.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
            AppMethodBeat.o(29398);
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dxk() {
        AppMethodBeat.i(29399);
        if (this.yje != null) {
            android.support.v4.view.g.a(this.yje, 2);
            if (!this.yjg) {
                boolean z;
                if (this.yiP.dyx() instanceof MoreTabUI) {
                    MoreTabUI moreTabUI = (MoreTabUI) this.yiP.dyx();
                    if (moreTabUI.yoh == null || !moreTabUI.yoh.isVisible) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        z = true;
                        if (z) {
                            this.yje.setVisible(true);
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
            this.yje.setVisible(false);
            this.yje.setEnabled(false);
        }
        if (this.yjc != null) {
            if (this.yjg) {
                android.support.v4.view.g.a(this.yjc, 2);
                this.yjc.setVisible(true);
            } else {
                this.yjc.setVisible(false);
                this.yjc.setEnabled(false);
            }
        }
        if (this.yjb != null) {
            if (this.yjg) {
                android.support.v4.view.g.a(this.yjb, 2);
                this.yjb.setVisible(true);
            } else {
                this.yjb.setVisible(false);
                this.yjb.setEnabled(false);
            }
        }
        if (this.yjd != null) {
            if (this.yjg) {
                this.yjd.setVisible(false);
                this.yjd.setEnabled(false);
                this.yeR.setVisibility(8);
            } else {
                android.support.v4.view.g.a(this.yjd, 2);
                this.yjd.setVisible(true);
                this.yeR.setVisibility(0);
                AppMethodBeat.o(29399);
                return;
            }
        }
        AppMethodBeat.o(29399);
    }

    /* Access modifiers changed, original: final */
    public final void dxl() {
        AppMethodBeat.i(29400);
        if (((com.tencent.mm.plugin.fts.a.n) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.fts.a.n.class)).isFTSIndexReady()) {
            int i = this.yiP.mbt;
            if (i == 0) {
                getMainTabUI().dyx();
            }
            Intent putExtra = new Intent().putExtra("from_tab_index", i).putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
            Bundle bundle = null;
            if (VERSION.SDK_INT >= 21) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(this.yhZ, new Pair[0]).toBundle();
            }
            com.tencent.mm.plugin.fts.a.d.b(this.yhZ, ".ui.FTSMainUI", putExtra, bundle);
            AppMethodBeat.o(29400);
            return;
        }
        Toast.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), R.string.e0p, 0).show();
        AppMethodBeat.o(29400);
    }

    /* Access modifiers changed, original: final */
    public final void dxm() {
        com.tencent.mm.plugin.story.g.h hVar;
        AppMethodBeat.i(29402);
        boolean booleanValue = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
        if (booleanValue) {
            this.yiT = false;
            if (this.yja != null) {
                this.yja.findViewById(R.id.kv).setVisibility(8);
                hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.lo(0);
            }
            com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
        }
        if (this.yja != null) {
            this.yja.findViewById(R.id.kv).setVisibility(8);
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.lo(0);
        }
        if (((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class)).canPostStory()) {
            Context context = this.yhZ;
            com.tencent.mm.plugin.story.g.h hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.api.n.a(context, 0, com.tencent.mm.plugin.story.g.h.cAI(), 10);
            AppMethodBeat.o(29402);
            return;
        }
        com.tencent.mm.kernel.g.RQ();
        int intValue = ((Integer) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0))).intValue();
        com.tencent.mm.ui.base.h.b(this.yhZ, "", this.yhZ.getResources().getString(R.string.et6, new Object[]{Integer.valueOf(intValue)}), true);
        AppMethodBeat.o(29402);
    }

    public final void dxn() {
        AppMethodBeat.i(29403);
        if (r.Zf().booleanValue() && (yiE.booleanValue() || yiF.booleanValue())) {
            Boolean bool = Boolean.FALSE;
            c(bool, bool);
        }
        this.yiP.dxn();
        AppMethodBeat.o(29403);
    }

    public final void dxo() {
        AppMethodBeat.i(29404);
        aw.RS().doK();
        this.yiP.dyC();
        al.d(this.yjh);
        AppMethodBeat.o(29404);
    }

    public final boolean dxp() {
        return this.yiM == a.ACTIVITY_RESUME;
    }

    public final void pI(boolean z) {
        AppMethodBeat.i(29406);
        if (!z) {
            initActionBar();
        }
        this.yhZ.supportInvalidateOptionsMenu();
        if (r.Zf().booleanValue()) {
            dxi();
        }
        this.yiP.dyB();
        AppMethodBeat.o(29406);
    }

    /* Access modifiers changed, original: final */
    public final void initActionBar() {
        AppMethodBeat.i(29407);
        if (this.yiN.dxM()) {
            ab.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
            AppMethodBeat.o(29407);
            return;
        }
        this.mActionBar.setLogo(new ColorDrawable(this.yhZ.getResources().getColor(17170445)));
        this.mActionBar.fc();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.fb();
        this.mActionBar.fd();
        this.mActionBar.setCustomView(com.tencent.mm.kiss.a.b.SM().a(this.yhZ, "R.layout.actionbar_title_launcher", (int) R.layout.ag));
        ImageView imageView = (ImageView) this.mActionBar.getCustomView().findViewById(R.id.kx);
        if (imageView != null && this.qlP) {
            imageView.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
        }
        if (this.qlP) {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(R.color.l8)));
        } else {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(R.color.vy)));
        }
        updateTitle();
        this.mActionBar.getCustomView().findViewById(R.id.l6).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(29363);
                if (SystemClock.elapsedRealtime() - HomeUI.this.ryj < 300) {
                    Iterator it = HomeUI.this.yjj.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                }
                HomeUI.this.ryj = SystemClock.elapsedRealtime();
                AppMethodBeat.o(29363);
            }
        });
        AppMethodBeat.o(29407);
    }

    private void MS(int i) {
        AppMethodBeat.i(29408);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(29408);
            return;
        }
        if ((VERSION.SDK_INT < 23 || com.tencent.mm.compatible.util.h.Mt()) && VERSION.SDK_INT >= 21) {
            i = ah.s(this.yhZ.getResources().getColor(R.color.a1h), i);
        }
        if (Math.abs(this.yji - i) >= SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH) {
            ab.i("MicroMsg.LauncherUI.HomeUI", "updateStatusBar %s stack: %s", Integer.valueOf(i), ah.anW().toString());
            this.yhZ.getWindow().setStatusBarColor(i);
        }
        this.yji = i;
        AppMethodBeat.o(29408);
    }

    private void pJ(boolean z) {
        AppMethodBeat.i(29409);
        if (VERSION.SDK_INT >= 23) {
            int i;
            View decorView = this.yhZ.getWindow().getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (z) {
                i = systemUiVisibility & -8193;
            } else {
                i = systemUiVisibility | Utility.DEFAULT_STREAM_BUFFER_SIZE;
            }
            if (systemUiVisibility != i) {
                decorView.setSystemUiVisibility(i);
            }
        }
        AppMethodBeat.o(29409);
    }

    public final void setTitleBarDoubleClickListener(Runnable runnable) {
        AppMethodBeat.i(29410);
        if (!this.yjj.contains(runnable)) {
            this.yjj.add(runnable);
        }
        AppMethodBeat.o(29410);
    }

    public final void aw(Runnable runnable) {
        AppMethodBeat.i(29411);
        this.yjj.remove(runnable);
        AppMethodBeat.o(29411);
    }

    public final void dxq() {
        AppMethodBeat.i(29413);
        updateTitle();
        AppMethodBeat.o(29413);
    }

    public final void dxr() {
        AppMethodBeat.i(29414);
        this.yiP.dxr();
        AppMethodBeat.o(29414);
    }

    private void MT(int i) {
        AppMethodBeat.i(29415);
        if (this.mActionBar != null) {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(i));
        }
        AppMethodBeat.o(29415);
    }

    public final void a(float f, int i, int i2, int i3) {
        AppMethodBeat.i(29416);
        if (getMainTabUI().dyx() != null) {
            MMFragment dyx = getMainTabUI().dyx();
            if (dyx instanceof MoreTabUI) {
                MT(this.yhZ.getResources().getColor(R.color.a3p));
                AppMethodBeat.o(29416);
                return;
            } else if (dyx instanceof MainUI) {
                if (((double) Math.abs(f)) < 0.01d) {
                    MT(this.yhZ.getResources().getColor(R.color.a3p));
                    if (!this.yiS) {
                        this.yiS = true;
                        pJ(true);
                    }
                    v(this.yfm, false);
                    v(this.yiW, false);
                } else if (f >= 1.0f) {
                    if (this.yiS) {
                        this.yiS = false;
                        pJ(false);
                    }
                    MT(this.yhZ.getResources().getColor(R.color.vy));
                    v(this.yfm, true);
                    v(this.yiW, true);
                }
                if (!(i2 == 0 || this.yiy == null)) {
                    this.yiy.setTextColor(i2);
                }
                if (this.yiZ != null) {
                    this.yiZ.setAlpha(f);
                }
                if (this.yiX != null) {
                    this.yiX.setAlpha(f);
                }
            } else {
                MT(this.yhZ.getResources().getColor(R.color.vy));
                AppMethodBeat.o(29416);
                return;
            }
        }
        AppMethodBeat.o(29416);
    }

    public final void dxs() {
        AppMethodBeat.i(29417);
        this.yiP.Nj(180);
        AppMethodBeat.o(29417);
    }

    private static boolean dxt() {
        AppMethodBeat.i(29418);
        if (!com.tencent.mm.plugin.story.api.n.isShowStoryCheck()) {
            AppMethodBeat.o(29418);
            return false;
        } else if (((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class)).isStoryExist(r.Yz())) {
            AppMethodBeat.o(29418);
            return true;
        } else {
            AppMethodBeat.o(29418);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dxu() {
        AppMethodBeat.i(29419);
        if (!(this.yje == null || this.yje.getActionView() == null)) {
            ImageView imageView = (ImageView) this.yje.getActionView().findViewById(R.id.jb);
            imageView.setImageDrawable(this.yhZ.getResources().getDrawable(R.raw.icons_filled_camera));
            if (dxt()) {
                imageView.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
            } else {
                imageView.setColorFilter(new PorterDuffColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP));
            }
            if (this.yiT) {
                this.yiT = ((Boolean) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
                this.yje.getActionView().findViewById(R.id.kv).setVisibility(0);
                AppMethodBeat.o(29419);
                return;
            }
            this.yje.getActionView().findViewById(R.id.kv).setVisibility(8);
        }
        AppMethodBeat.o(29419);
    }

    public final void pK(boolean z) {
        AppMethodBeat.i(29420);
        if (!(this.yje == null || this.yje.getActionView() == null || this.yhZ == null)) {
            if (this.yhZ.getResources().getConfiguration().orientation == 2) {
                this.yje.setVisible(false);
                this.yje.setEnabled(false);
                AppMethodBeat.o(29420);
                return;
            }
            this.yje.setVisible(true);
            this.yje.setEnabled(true);
            ImageView imageView = (ImageView) this.yje.getActionView().findViewById(R.id.jb);
            imageView.setImageDrawable(this.yhZ.getResources().getDrawable(R.raw.icons_filled_camera));
            if (z) {
                imageView.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
            } else {
                imageView.setColorFilter(new PorterDuffColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP));
            }
            if (this.yiT) {
                this.yje.getActionView().findViewById(R.id.kv).setVisibility(0);
                AppMethodBeat.o(29420);
                return;
            }
            this.yje.getActionView().findViewById(R.id.kv).setVisibility(8);
        }
        AppMethodBeat.o(29420);
    }

    private static void v(View view, boolean z) {
        AppMethodBeat.i(29421);
        if (view != null) {
            if (z) {
                view.setClickable(true);
                view.setBackgroundResource(R.drawable.al);
                AppMethodBeat.o(29421);
                return;
            }
            view.setClickable(false);
            view.setBackgroundResource(R.color.a3p);
        }
        AppMethodBeat.o(29421);
    }

    public final String getString(int i) {
        AppMethodBeat.i(29401);
        String string = this.yhZ.getString(i);
        AppMethodBeat.o(29401);
        return string;
    }

    public final void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup) {
        AppMethodBeat.i(29405);
        this.yhZ.getWindow().getDecorView().getBottom();
        this.yhZ.getSupportActionBar().getCustomView().getBottom();
        fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
        fitSystemWindowLayoutView.fitSystemWindows(rect);
        AppMethodBeat.o(29405);
    }

    /* Access modifiers changed, original: final */
    public final void dwf() {
        AppMethodBeat.i(29412);
        if (this.yhZ != null) {
            this.yhZ.moveTaskToBack(true);
        }
        if (aw.RK()) {
            aw.RS().m(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(29367);
                    if (aw.RK()) {
                        aw.ZK();
                        z Ry = c.Ry();
                        if (Ry != null) {
                            Ry.dsb();
                        }
                    }
                    AppMethodBeat.o(29367);
                }
            }, 500);
        }
        com.tencent.mm.app.n Bw = com.tencent.mm.app.n.Bw();
        Bw.ceU = false;
        Bw.ceV.removeMessages(-1999);
        Bw.ceV.removeMessages(-2999);
        Bw.ceV.sendEmptyMessageDelayed(-1999, 3000);
        Bw.ceV.sendEmptyMessageDelayed(-2999, 30000);
        AppMethodBeat.o(29412);
    }

    static /* synthetic */ void dxv() {
        AppMethodBeat.i(29424);
        int fX = com.tencent.mm.bz.a.fX(com.tencent.mm.sdk.platformtools.ah.getContext());
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.doA() + "_font_size_report_time", com.tencent.mm.compatible.util.h.Mu()).getLong("font_size_report_time", 0) > 604800000) {
            h.pYm.e(14239, Integer.valueOf(fX));
            com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.doA() + "_font_size_report_time", com.tencent.mm.compatible.util.h.Mu()).edit().putLong("font_size_report_time", currentTimeMillis).commit();
            ab.i("MicroMsg.LauncherUI.HomeUI", "using font size kvReport logID:%d , usingFontSize: %d", Integer.valueOf(14239), Integer.valueOf(fX));
        }
        AppMethodBeat.o(29424);
    }

    static /* synthetic */ void k(HomeUI homeUI) {
        AppMethodBeat.i(29426);
        MMFragmentActivity mMFragmentActivity = homeUI.yhZ;
        try {
            Intent intent = new Intent(mMFragmentActivity, Class.forName("com.tencent.mm.plugin.story.ui.StorySettingsUI"));
            if (mMFragmentActivity instanceof Activity) {
                mMFragmentActivity.startActivityForResult(intent, 10);
                AppMethodBeat.o(29426);
                return;
            }
            mMFragmentActivity.startActivity(intent);
            AppMethodBeat.o(29426);
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("LaunchStory", e, "startStorySetting failed", new Object[0]);
            AppMethodBeat.o(29426);
        }
    }

    static /* synthetic */ void s(HomeUI homeUI) {
        AppMethodBeat.i(29430);
        homeUI.pH(false);
        AppMethodBeat.o(29430);
    }

    static /* synthetic */ void dxw() {
        AppMethodBeat.i(29432);
        if (VERSION.SDK_INT < 18) {
            com.tencent.mm.sdk.platformtools.ah.getContext().startService(new Intent(com.tencent.mm.sdk.platformtools.ah.getContext(), NotifyService.class));
        }
        AppMethodBeat.o(29432);
    }
}
