package com.tencent.p177mm.p612ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.p057v4.view.C0464g;
import android.support.p069v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
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
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.C25798n;
import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.blink.FirstScreenFrameLayout.C17991a;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.booter.C41900n;
import com.tencent.p177mm.booter.C41906w.C419071;
import com.tencent.p177mm.booter.NotifyReceiver.NotifyService;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p190at.C32290n;
import com.tencent.p177mm.p190at.C32290n.C32286b;
import com.tencent.p177mm.p190at.C32290n.C32287c;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C6471cq;
import com.tencent.p177mm.p230g.p231a.C9298bc;
import com.tencent.p177mm.p612ui.LauncherUI.C23538c;
import com.tencent.p177mm.p612ui.LauncherUI.C23539d;
import com.tencent.p177mm.p612ui.LauncherUI.C36032b;
import com.tencent.p177mm.p612ui.LauncherUI.C36034a;
import com.tencent.p177mm.p612ui.MainTabUI.C23542a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.contact.C5458k;
import com.tencent.p177mm.p612ui.conversation.MainUI;
import com.tencent.p177mm.p612ui.tools.TestTimeForChatting;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.account.p275ui.FacebookAuthUI;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10984a;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C3161d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.report.service.C3745f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C13303b;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.api.C46270n;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@C5271a(3)
@TargetApi(11)
/* renamed from: com.tencent.mm.ui.HomeUI */
public class HomeUI implements C10984a, C36032b, C23538c, C23539d {
    public static Boolean yiE = Boolean.FALSE;
    public static Boolean yiF = Boolean.FALSE;
    private String cIe = null;
    private int clickCount = 0;
    View contentView;
    LayoutInflater ezi;
    private boolean gwZ = true;
    IdleHandler jQs = new C3033115();
    ActionBar mActionBar;
    private long mSj = 0;
    C4884c qjs = new C4424113();
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
    C46630aa yiD;
    private final long yiG = 432000000;
    private final long yiH = 604800000;
    private boolean yiI = true;
    private int yiJ = 0;
    private int yiK = 0;
    private int yiL = 0;
    C5182a yiM = C5182a.ACTIVITY_CREATE;
    C36034a yiN;
    C36298h yiO;
    MainTabUI yiP = new MainTabUI();
    int yiQ = 0;
    int yiR = 0;
    private boolean yiS = false;
    boolean yiT = true;
    OnLayoutChangeListener yiU = new C1546534();
    private boolean yiV = C4988aa.don();
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
    Runnable yjh = new C1546316();
    private int yji = 0;
    private LinkedList<Runnable> yjj = new LinkedList();
    C3473o yjk = new C3602531();
    private float yjl = 0.0f;

    /* renamed from: com.tencent.mm.ui.HomeUI$6 */
    class C51806 implements Runnable {
        C51806() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29346);
            HomeUI.this.yhZ.supportInvalidateOptionsMenu();
            AppMethodBeat.m2505o(29346);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29347);
            String str = super.toString() + "|supportInvalidateOptionsMenu";
            AppMethodBeat.m2505o(29347);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$8 */
    class C51818 implements Runnable {
        C51818() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29349);
            HomeUI.this.yhZ.supportInvalidateOptionsMenu();
            AppMethodBeat.m2505o(29349);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29350);
            String str = super.toString() + "|supportInvalidateOptionsMenu";
            AppMethodBeat.m2505o(29350);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$a */
    enum C5182a {
        ACTIVITY_CREATE,
        ACTIVITY_RESUME,
        ACTIVITY_PAUSE;

        static {
            AppMethodBeat.m2505o(29387);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$14 */
    class C1546214 implements Runnable {
        C1546214() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29360);
            C4879a.xxA.mo10055m(new C9298bc());
            AppMethodBeat.m2505o(29360);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$16 */
    class C1546316 implements Runnable {
        C1546316() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29362);
            if (!C35973a.m59178bI(HomeUI.this.yhZ) || C35973a.m59177bH(HomeUI.this.yhZ)) {
                Intent intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                C7060h.pYm.mo8381e(11409, new Object[0]);
                C25985d.m41467b(HomeUI.this.yhZ, "scanner", ".ui.BaseScanUI", intent);
                AppMethodBeat.m2505o(29362);
                return;
            }
            AppMethodBeat.m2505o(29362);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$17 */
    class C1546417 implements OnClickListener {
        C1546417() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29363);
            if (SystemClock.elapsedRealtime() - HomeUI.this.ryj < 300) {
                Iterator it = HomeUI.this.yjj.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
            }
            HomeUI.this.ryj = SystemClock.elapsedRealtime();
            AppMethodBeat.m2505o(29363);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$34 */
    class C1546534 implements OnLayoutChangeListener {
        C1546534() {
        }

        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$5 */
    class C154665 implements OnClickListener {
        C154665() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29345);
            HomeUI.m79870m(HomeUI.this);
            AppMethodBeat.m2505o(29345);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$7 */
    class C154677 implements OnClickListener {
        C154677() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29348);
            C7060h.pYm.mo8374X(10919, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            HomeUI.m79871n(HomeUI.this);
            if (HomeUI.yiE.booleanValue()) {
                HomeUI homeUI = HomeUI.this;
                Boolean bool = Boolean.TRUE;
                HomeUI.m79850a(homeUI, bool, bool);
            }
            if (HomeUI.yiF.booleanValue()) {
                HomeUI.m79850a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
            }
            if (!C5047bp.dnM()) {
                long anU = C42252ah.anU();
                if (anU - HomeUI.this.mSj > 10000) {
                    HomeUI.this.mSj = anU;
                    HomeUI.this.clickCount = 1;
                    AppMethodBeat.m2505o(29348);
                    return;
                }
                HomeUI.this.clickCount = HomeUI.this.clickCount + 1;
                if (HomeUI.this.clickCount >= 5) {
                    C4990ab.m7420w("MicroMsg.LauncherUI.HomeUI", "Switch to MonkeyEnv now.");
                    C5047bp.m7592pm(true);
                }
            }
            AppMethodBeat.m2505o(29348);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$21 */
    class C2353421 implements Runnable {
        C2353421() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29367);
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                C7580z Ry = C18628c.m29072Ry();
                if (Ry != null) {
                    Ry.dsb();
                }
            }
            AppMethodBeat.m2505o(29367);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$22 */
    class C2353522 implements Runnable {
        C2353522() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29368);
            String string = HomeUI.this.yhZ.getString(C25738R.string.g7l, new Object[]{C4988aa.dor()});
            if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_NEED_CONFIRM_BOOLEAN_SYNC, false)) {
                HomeUI.m79852a(HomeUI.this, string, 22723, HomeUI.this.yhZ.getString(C25738R.string.g7n, new Object[]{C4988aa.dor()}));
            } else {
                C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "needconfirm false");
                Bundle bundle = new Bundle();
                bundle.putString("close_dialog_msg", HomeUI.this.yiA);
                bundle.putString("close_dialog_cancel", HomeUI.this.yiC);
                bundle.putString("close_dialog_ok", HomeUI.this.yiB);
                bundle.putBoolean("close_dialog_ok_close", false);
                HomeUI.m79851a(HomeUI.this, string, 22723, bundle);
            }
            C5274b.m8055hN(HomeUI.this.yhZ);
            AppMethodBeat.m2505o(29368);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$29 */
    class C2353629 implements DialogInterface.OnClickListener {
        C2353629() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29376);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(29376);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$36 */
    class C2353736 implements DialogInterface.OnClickListener {
        C2353736() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29383);
            HomeUI.this.yhZ.startActivity(new Intent(HomeUI.this.yhZ, FacebookAuthUI.class));
            AppMethodBeat.m2505o(29383);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$15 */
    class C3033115 implements IdleHandler {

        /* renamed from: com.tencent.mm.ui.HomeUI$15$1 */
        class C303321 implements C1835a {
            C303321() {
            }

            /* renamed from: a */
            public final void mo4918a(C1902e c1902e) {
            }
        }

        C3033115() {
        }

        public final boolean queueIdle() {
            int i;
            AppMethodBeat.m2504i(29361);
            C9638aw.m17190ZK();
            if (C42252ah.m74624h((Integer) C18628c.m29072Ry().get(15, null)) == 0) {
                i = 1;
            } else {
                boolean i2 = false;
            }
            if (i2 != 0) {
                C4990ab.m7412e("MicroMsg.LauncherUI.HomeUI", "not init finish , do not post sync task");
                AppMethodBeat.m2505o(29361);
            } else {
                String T = C6665av.fly.mo5292T("login_user_name", "");
                if (C9638aw.m17192ZM() || !T.equals("")) {
                    C9638aw.m17182Rg().mo14541a(new C6668bk(new C303321(), "launch normal"), 0);
                }
                C7305d.post(new C419071(), "StartupReport_report");
                C41900n.m74001IE();
                HomeUI.dxw();
                C3745f.cgq();
                C32287c c32287c = C32290n.ahb().fFM;
                if (c32287c.fGb.size() <= 0 && c32287c.fGa.size() <= 0) {
                    T = (String) C1720g.m3536RP().mo5239Ry().get(348177, (Object) "");
                    String str = (String) C1720g.m3536RP().mo5239Ry().get(348176, (Object) "");
                    if (!C5046bo.isNullOrNil(T)) {
                        synchronized (c32287c) {
                            try {
                                for (String su : T.split("-")) {
                                    C32286b su2 = C32287c.m52720su(su);
                                    if (su2 != null) {
                                        c32287c.fGb.add(su2);
                                    }
                                }
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.m2505o(29361);
                                }
                            }
                        }
                    }
                    if (!C5046bo.isNullOrNil(str)) {
                        synchronized (c32287c) {
                            try {
                                for (String st : str.split("-")) {
                                    C32286b st2 = C32287c.m52719st(st);
                                    if (st2 != null) {
                                        c32287c.fGa.add(st2);
                                    }
                                }
                            } catch (Throwable th2) {
                                while (true) {
                                    AppMethodBeat.m2505o(29361);
                                }
                            }
                        }
                    }
                    C4990ab.m7417i("MicroMsg.SendImgSpeeder", "Image pool bigfile pool size %d, thumbfile size %d ", Integer.valueOf(c32287c.fGa.size()), Integer.valueOf(c32287c.fGb.size()));
                }
                c32287c.ahf();
                Looper.myQueue().removeIdleHandler(HomeUI.this.jQs);
                AppMethodBeat.m2505o(29361);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$20 */
    class C3033320 implements DialogInterface.OnClickListener {
        C3033320() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29366);
            HomeUI.m79884x(HomeUI.this);
            AppMethodBeat.m2505o(29366);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$28 */
    class C3033428 implements DialogInterface.OnClickListener {
        C3033428() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29375);
            dialogInterface.dismiss();
            HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(29375);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$33 */
    class C3033533 implements Runnable {
        C3033533() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29381);
            C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "contentView.post, padding: %s", Integer.valueOf(HomeUI.this.contentView.getPaddingTop()));
            AppMethodBeat.m2505o(29381);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$FitSystemWindowLayoutView */
    public static class FitSystemWindowLayoutView extends FrameLayout {
        private Rect mRect = new Rect();
        private int yjv;
        private ViewGroup yjw = null;

        public FitSystemWindowLayoutView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.m2504i(29388);
            AppMethodBeat.m2505o(29388);
        }

        public FitSystemWindowLayoutView(Context context) {
            super(context);
            AppMethodBeat.m2504i(29389);
            AppMethodBeat.m2505o(29389);
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
            AppMethodBeat.m2504i(29390);
            String str = "MicroMsg.LauncherUI";
            String str2 = "fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = rect.toString();
            objArr[1] = Integer.valueOf(this.yjv);
            objArr[2] = Integer.valueOf(hashCode());
            objArr[3] = rect.height() == 0 ? C42252ah.anW() : "pass";
            C4990ab.m7417i(str, str2, objArr);
            if (rect.top > 0) {
                this.yjv = rect.top;
            }
            if (this.yjw != null && (this.yjw.getLayoutParams() instanceof MarginLayoutParams)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.yjw.getLayoutParams();
                int i = marginLayoutParams.bottomMargin;
                int i2 = marginLayoutParams.rightMargin;
                C4990ab.m7417i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", Integer.valueOf(i), Integer.valueOf(i2));
                int i3 = 0;
                while (i3 < getChildCount()) {
                    childAt = getChildAt(i3);
                    if (childAt instanceof TestTimeForChatting) {
                        TestTimeForChatting testTimeForChatting = (TestTimeForChatting) childAt;
                        if (Float.compare((float) i, ((float) C1338a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 1.5f) > 0 || i < 0) {
                            C4990ab.m7421w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", Integer.valueOf(i));
                            testTimeForChatting.zHY = 0;
                        } else {
                            testTimeForChatting.zHY = i;
                        }
                        if (Float.compare((float) i2, ((float) C1338a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 1.5f) > 0 || i2 < 0) {
                            C4990ab.m7421w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", Integer.valueOf(i));
                            testTimeForChatting.zHZ = 0;
                        } else {
                            testTimeForChatting.zHZ = i2;
                        }
                        C4990ab.m7417i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", Integer.valueOf(i), Integer.valueOf(i2));
                        C5222ae.m7931J(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    } else {
                        i3++;
                    }
                }
                C5222ae.m7931J(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            this.mRect.set(rect);
            if (C1443d.m3068iW(14)) {
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
            C4990ab.m7417i("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", Boolean.valueOf(fitSystemWindows), Integer.valueOf(VERSION.SDK_INT));
            C4990ab.m7411d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", Boolean.valueOf(super.fitSystemWindows(this.mRect)));
            AppMethodBeat.m2505o(29390);
            return super.fitSystemWindows(this.mRect);
        }

        /* Access modifiers changed, original: protected */
        public void onMeasure(int i, int i2) {
            int i3;
            View childAt;
            AppMethodBeat.m2504i(29391);
            try {
                super.onMeasure(i, i2);
                AppMethodBeat.m2505o(29391);
            } catch (ClassCastException e) {
                C4990ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
                C4990ab.m7413e("MicroMsg.LauncherUI.HomeUI", "my layout params %s %s", getLayoutParams(), getLayoutParams().getClass());
                int childCount = getChildCount();
                for (i3 = 0; i3 < childCount; i3++) {
                    childAt = getChildAt(i3);
                    C4990ab.m7413e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", Integer.valueOf(i3), childAt, childAt.getLayoutParams(), childAt.getLayoutParams().getClass());
                }
                for (i3 = 0; i3 < childCount; i3++) {
                    childAt = getChildAt(i3);
                    if ((childAt instanceof ImageView) && childAt.getId() == 2131820648 && childAt.getLayoutParams() != null && (childAt.getLayoutParams() instanceof MarginLayoutParams) && !(childAt.getLayoutParams() instanceof LayoutParams)) {
                        childAt.setLayoutParams(new LayoutParams(childAt.getLayoutParams()));
                    }
                    C4990ab.m7413e("MicroMsg.LauncherUI.HomeUI", "my child %s %s layout params %s %s", Integer.valueOf(i3), childAt, childAt.getLayoutParams(), childAt.getLayoutParams().getClass());
                }
                super.onMeasure(i, i2);
                AppMethodBeat.m2505o(29391);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$18 */
    class C3602418 implements DialogInterface.OnClickListener {
        C3602418() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29364);
            HomeUI.m79884x(HomeUI.this);
            AppMethodBeat.m2505o(29364);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$31 */
    class C3602531 implements C3473o {
        C3602531() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(29378);
            if (C42252ah.nullAsNil(str).equals("showprivacypolicy") && map != null) {
                String str2 = (String) map.get(".sysmsg.showprivacypolicy.device_id");
                HomeUI.this.yiA = (String) map.get(".sysmsg.showprivacypolicy.doublecheck_content");
                HomeUI.this.yiB = (String) map.get(".sysmsg.showprivacypolicy.doublecheck_ok");
                HomeUI.this.yiC = (String) map.get(".sysmsg.showprivacypolicy.doublecheck_cancel");
                boolean equals = "yes".equals(map.get(".sysmsg.showprivacypolicy.needbirthday"));
                boolean equals2 = "yes".equals(map.get(".sysmsg.showprivacypolicy.needopenplatform"));
                boolean equals3 = "yes".equals(map.get(".sysmsg.showprivacypolicy.needconfirm"));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEED_BIRTHDAY_BOOLEAN_SYNC, Boolean.valueOf(equals));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.valueOf(equals2));
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NEED_CONFIRM_BOOLEAN_SYNC, Boolean.valueOf(equals3));
                C1332b bI = C1332b.m2847bI(C1427q.m3028LM().getBytes());
                bI.mo4675Lv(16);
                C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "deviceId:%s, localDeviceId:%s, doubleCheckContent:%s, doubleCheckOk:%s, doubleCheckCancel:%s, needBirthday:%s, needOpenPlatform:%s, needConfirm:%s", str2, Base64.encodeToString(bI.toByteArray(), 2), HomeUI.this.yiA, HomeUI.this.yiB, HomeUI.this.yiC, Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(equals3));
                if (C42252ah.isNullOrNil(str2) || str2.equals(r4)) {
                    String obj = C1720g.m3536RP().mo5239Ry().get(274436, (Object) "").toString();
                    MMFragmentActivity b = HomeUI.this.yhZ;
                    Object[] objArr = new Object[5];
                    objArr[0] = C4988aa.dor();
                    objArr[1] = obj;
                    objArr[2] = "login";
                    objArr[3] = Integer.valueOf(1);
                    objArr[4] = Integer.valueOf(equals2 ? 1 : 0);
                    str2 = b.getString(C25738R.string.g7o, objArr);
                    Bundle bundle;
                    if (C17950b.m28216sO(obj)) {
                        C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "eu true, needconfirm: %s", Boolean.valueOf(equals3));
                        if (equals3) {
                            HomeUI.m79852a(HomeUI.this, str2, 22722, HomeUI.this.yhZ.getString(C25738R.string.g7n, new Object[]{C4988aa.dor()}));
                        } else {
                            bundle = new Bundle();
                            bundle.putString("close_dialog_msg", HomeUI.this.yiA);
                            bundle.putString("close_dialog_cancel", HomeUI.this.yiC);
                            bundle.putString("close_dialog_ok", HomeUI.this.yiB);
                            bundle.putBoolean("close_dialog_ok_close", false);
                            HomeUI.m79851a(HomeUI.this, str2, 22722, bundle);
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "eu false");
                        bundle = new Bundle();
                        bundle.putString("close_dialog_msg", HomeUI.this.yhZ.getString(C25738R.string.cmh));
                        bundle.putString("close_dialog_cancel", HomeUI.this.yhZ.getString(C25738R.string.cpf));
                        bundle.putString("close_dialog_ok", HomeUI.this.yhZ.getString(C25738R.string.cmj));
                        bundle.putBoolean("close_dialog_ok_close", false);
                        HomeUI.m79851a(HomeUI.this, str2, 22722, bundle);
                    }
                    C5274b.m8055hN(HomeUI.this.yhZ);
                    AppMethodBeat.m2505o(29378);
                    return;
                }
                C4990ab.m7416i("MicroMsg.LauncherUI.HomeUI", "device id not match");
            }
            AppMethodBeat.m2505o(29378);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$35 */
    class C3602635 implements Runnable {
        C3602635() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29382);
            C13303b.m21377WY();
            AppMethodBeat.m2505o(29382);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$9 */
    class C360279 implements Runnable {
        C360279() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29351);
            HomeUI.m79878s(HomeUI.this);
            AppMethodBeat.m2505o(29351);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$12 */
    class C4064612 implements C17991a {

        /* renamed from: com.tencent.mm.ui.HomeUI$12$1 */
        class C406451 implements C5681a<Void, Void> {
            C406451() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(29354);
                ArrayList HO = C1311a.m2797HO();
                ArrayList arrayList = new ArrayList();
                Iterator it = HO.iterator();
                while (it.hasNext()) {
                    long[] jArr = (long[]) it.next();
                    C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "blink-startup %s, %s, %s", Long.valueOf(jArr[0]), Long.valueOf(jArr[1]), Long.valueOf(jArr[2]));
                    arrayList.add(new IDKey(jArr[0], jArr[1], jArr[2]));
                }
                if (arrayList.size() > 0) {
                    C7060h.pYm.mo8379b(arrayList, false);
                }
                C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "blink-startup report size %s", Integer.valueOf(HO.size()));
                HO.clear();
                Iterator it2 = C1311a.m2798HP().iterator();
                while (it2.hasNext()) {
                    Object[] objArr = (Object[]) it2.next();
                    C7060h.pYm.mo8381e(((Integer) objArr[0]).intValue(), (Object[]) objArr[1]);
                    C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "blink-startup kv %s, %s", objArr[0], ((Object[]) objArr[1])[0]);
                }
                Void voidR = zXH;
                AppMethodBeat.m2505o(29354);
                return voidR;
            }
        }

        C4064612() {
        }

        /* renamed from: Ia */
        public final void mo33533Ia() {
            AppMethodBeat.m2504i(29355);
            if (C1311a.m2795HM()) {
                C1311a.m2806ig(6);
                C1311a.m2796HN();
                C1311a.m2807jD("First Screen");
                C5698f.dMn().mo15897ny(500).mo15893d(new C406451());
            }
            C1314b.m2812HQ().mo4640HU();
            AppMethodBeat.m2505o(29355);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$19 */
    class C4064719 implements DialogInterface.OnClickListener {
        final /* synthetic */ int bVv;

        C4064719(int i) {
            this.bVv = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29365);
            try {
                C5023at.startSettingItent(HomeUI.this.yhZ, this.bVv);
                AppMethodBeat.m2505o(29365);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
                AppMethodBeat.m2505o(29365);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$1 */
    class C406481 implements C23542a {
        C406481() {
        }

        /* renamed from: MU */
        public final void mo39213MU(int i) {
            AppMethodBeat.m2504i(29339);
            HomeUI.m79848a(HomeUI.this);
            if (i != 0) {
                HomeUI.this.mo22614a(1.0f, HomeUI.this.yhZ.getResources().getColor(C25738R.color.f12206vy), HomeUI.this.yhZ.getResources().getColor(C25738R.color.f11704e4), HomeUI.this.yhZ.getResources().getColor(C25738R.color.f11782h4));
            }
            AppMethodBeat.m2505o(29339);
        }

        /* renamed from: p */
        public final void mo39215p(int i, float f) {
            AppMethodBeat.m2504i(29340);
            HomeUI.m79849a(HomeUI.this, i, f);
            AppMethodBeat.m2505o(29340);
        }

        /* renamed from: MV */
        public final void mo39214MV(int i) {
            AppMethodBeat.m2504i(29341);
            if (HomeUI.this.yiL == 0 && i == 1) {
                HomeUI.this.yiJ = HomeUI.this.yiP.mbt;
            } else if (i == 2) {
                HomeUI.this.yiK = HomeUI.this.yiP.mbt;
            } else if (i == 0) {
                HomeUI.this.yiJ = 0;
                HomeUI.this.yiK = 0;
            }
            HomeUI.this.yiL = i;
            C4990ab.m7411d("MicroMsg.LauncherUI.HomeUI", "tabSelectedStateChanged:%s begin:%s end:%s", Integer.valueOf(i), Integer.valueOf(HomeUI.this.yiJ), Integer.valueOf(HomeUI.this.yiK));
            AppMethodBeat.m2505o(29341);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$32 */
    class C4064932 implements Runnable {
        C4064932() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29379);
            C4990ab.m7410d("MicroMsg.LauncherUI.HomeUI", "onMainTabCreate, send refresh broadcast");
            HomeUI.this.yhZ.sendBroadcast(new Intent(ConstantsAPI.ACTION_REFRESH_WXAPP));
            AppMethodBeat.m2505o(29379);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29380);
            String str = super.toString() + "|sendBroadcast";
            AppMethodBeat.m2505o(29380);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$3 */
    class C406503 implements OnLongClickListener {
        C406503() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(29343);
            if (C4872b.dnO() || C5058f.IS_FLAVOR_RED || C5058f.IS_FLAVOR_PURPLE) {
                HomeUI.m79868k(HomeUI.this);
            }
            AppMethodBeat.m2505o(29343);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$10 */
    class C4423410 implements C36073c {
        C4423410() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(29352);
            c44273l.mo70068e(1, "拍摄状态");
            c44273l.mo70068e(2, "属性配置");
            AppMethodBeat.m2505o(29352);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$23 */
    class C4423523 implements Runnable {
        C4423523() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29369);
            HomeUI.m79848a(HomeUI.this);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().setInt(327947, HomeUI.this.mActionBar.getHeight());
            C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "contentView.post then setFullScreenAfterSetContentView, padding: %s", Integer.valueOf(HomeUI.this.contentView.getPaddingTop()));
            C30036f.m47541b(HomeUI.this.yhZ, HomeUI.this.contentView);
            AppMethodBeat.m2505o(29369);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29370);
            String str = super.toString() + "|updateTitle";
            AppMethodBeat.m2505o(29370);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$24 */
    class C4423624 implements DialogInterface.OnClickListener {
        C4423624() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29371);
            dialogInterface.dismiss();
            HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(29371);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$25 */
    class C4423725 implements DialogInterface.OnClickListener {
        C4423725() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29372);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(29372);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$26 */
    class C4423826 implements DialogInterface.OnClickListener {
        C4423826() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29373);
            HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(29373);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$27 */
    class C4423927 implements DialogInterface.OnClickListener {
        C4423927() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29374);
            HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(29374);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$11 */
    class C4424011 implements C5279d {
        C4424011() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(29353);
            switch (menuItem.getItemId()) {
                case 1:
                    HomeUI.m79869l(HomeUI.this);
                    AppMethodBeat.m2505o(29353);
                    return;
                case 2:
                    HomeUI.m79868k(HomeUI.this);
                    break;
            }
            AppMethodBeat.m2505o(29353);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$13 */
    class C4424113 extends C4884c<C6471cq> {

        /* renamed from: com.tencent.mm.ui.HomeUI$13$1 */
        class C154611 implements Runnable {
            C154611() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29356);
                HomeUI.m79880u(HomeUI.this);
                AppMethodBeat.m2505o(29356);
            }

            public final String toString() {
                AppMethodBeat.m2504i(29357);
                String str = super.toString() + "|updatePlusMenuNewTips";
                AppMethodBeat.m2505o(29357);
                return str;
            }
        }

        C4424113() {
            AppMethodBeat.m2504i(29358);
            this.xxI = C6471cq.class.getName().hashCode();
            AppMethodBeat.m2505o(29358);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29359);
            if (HomeUI.this.yiW != null) {
                HomeUI.this.yiW.post(new C154611());
            }
            HomeUI.this.yiP.dyE();
            AppMethodBeat.m2505o(29359);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$30 */
    class C4424330 implements DialogInterface.OnClickListener {
        C4424330() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29377);
            HomeUI.this.yhZ.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            AppMethodBeat.m2505o(29377);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$37 */
    class C4424437 implements Runnable {
        C4424437() {
        }

        public final void run() {
            AppMethodBeat.m2504i(29384);
            HomeUI.dxv();
            AppMethodBeat.m2505o(29384);
        }
    }

    /* renamed from: com.tencent.mm.ui.HomeUI$4 */
    class C442454 implements OnClickListener {
        C442454() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29344);
            C22212h c22212h = C22212h.scu;
            C22212h.cAJ().cZX = System.currentTimeMillis();
            HomeUI.m79869l(HomeUI.this);
            AppMethodBeat.m2505o(29344);
        }
    }

    public HomeUI() {
        AppMethodBeat.m2504i(29392);
        AppMethodBeat.m2505o(29392);
    }

    /* renamed from: a */
    static /* synthetic */ void m79848a(HomeUI homeUI) {
        AppMethodBeat.m2504i(29422);
        homeUI.updateTitle();
        AppMethodBeat.m2505o(29422);
    }

    /* renamed from: l */
    static /* synthetic */ void m79869l(HomeUI homeUI) {
        AppMethodBeat.m2504i(29427);
        homeUI.dxm();
        AppMethodBeat.m2505o(29427);
    }

    /* renamed from: m */
    static /* synthetic */ void m79870m(HomeUI homeUI) {
        AppMethodBeat.m2504i(29428);
        homeUI.dxl();
        AppMethodBeat.m2505o(29428);
    }

    /* renamed from: n */
    static /* synthetic */ void m79871n(HomeUI homeUI) {
        AppMethodBeat.m2504i(29429);
        homeUI.dxj();
        AppMethodBeat.m2505o(29429);
    }

    /* renamed from: u */
    static /* synthetic */ void m79880u(HomeUI homeUI) {
        AppMethodBeat.m2504i(29431);
        homeUI.mo69894pH(true);
        AppMethodBeat.m2505o(29431);
    }

    /* renamed from: x */
    static /* synthetic */ void m79884x(HomeUI homeUI) {
        AppMethodBeat.m2504i(29433);
        homeUI.dwf();
        AppMethodBeat.m2505o(29433);
    }

    public MainTabUI getMainTabUI() {
        return this.yiP;
    }

    @SuppressLint({"RestrictedApi"})
    private void updateTitle() {
        AppMethodBeat.m2504i(29393);
        if (this.yiI) {
            CharSequence charSequence;
            int i = this.yiP.mbt;
            String string = getString(C25738R.string.f9176ru);
            Object charSequence2;
            if (i == 0) {
                if (C7243d.vxr) {
                    if (this.yiV) {
                        string = string + getString(C25738R.string.f8807fk);
                    } else {
                        string = string + " " + getString(C25738R.string.f8807fk);
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
                charSequence2 = getString(C25738R.string.cv_);
            } else if (i == 2) {
                charSequence2 = getString(C25738R.string.cv8);
            } else {
                if (i == 3) {
                    charSequence2 = getString(C25738R.string.cw4);
                }
                charSequence2 = string;
            }
            if (i == 3) {
                boolean z;
                m79843MS(this.yhZ.getResources().getColor(C25738R.color.a3p));
                if (HomeUI.dxt()) {
                    m79875pJ(true);
                } else {
                    m79875pJ(false);
                }
                ((C35168e) C1720g.m3530M(C35168e.class)).checkPost();
                this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(C25738R.color.a3p)));
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
                m79843MS(this.yhZ.getResources().getColor(C25738R.color.f12206vy));
                m79875pJ(this.qlP);
                Drawable background = this.mActionBar.getCustomView().getBackground();
                if (!(background instanceof ColorDrawable)) {
                    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(C25738R.color.f12206vy)));
                } else if (((ColorDrawable) background).getColor() != this.yhZ.getResources().getColor(C25738R.color.f12206vy)) {
                    this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(C25738R.color.f12206vy)));
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
            this.mActionBar.mo1344fh();
            this.yiy = (TextView) this.mActionBar.getCustomView().findViewById(16908308);
            if (this.yiy != null) {
                this.yiy.setText(charSequence2);
                float am = ((float) C1338a.m2857am(C4996ah.getContext(), C25738R.dimen.f9720dk)) * C1338a.m2862fY(C4996ah.getContext());
                if (this.yiy.getTextSize() != am) {
                    this.yiy.setTextSize(0, am);
                }
                int color = this.yhZ.getResources().getColor(C25738R.color.a6a);
                if (this.qlP && this.yiy.getCurrentTextColor() != color) {
                    this.yiy.setTextColor(color);
                }
            }
            AppMethodBeat.m2505o(29393);
            return;
        }
        AppMethodBeat.m2505o(29393);
    }

    private boolean dxh() {
        return this.yiJ == 2 && this.yiK == 2;
    }

    /* Access modifiers changed, original: final */
    public final void dxi() {
        AppMethodBeat.m2504i(29394);
        if (C9638aw.m17179RK()) {
            C9638aw.m17190ZK();
            Boolean valueOf = Boolean.valueOf(C42252ah.m74619e((Boolean) C18628c.m29072Ry().get(340227, null)));
            if (!(valueOf.booleanValue() || C5458k.zmx.booleanValue())) {
                yiE = Boolean.TRUE;
                m79874pG(true);
            }
            long currentTimeMillis = System.currentTimeMillis();
            C9638aw.m17190ZK();
            currentTimeMillis -= C42252ah.m74617d((Long) C18628c.m29072Ry().get(340240, null));
            C9638aw.m17190ZK();
            Boolean valueOf2 = Boolean.valueOf(C42252ah.m74619e((Boolean) C18628c.m29072Ry().get(340230, null)));
            C9638aw.m17190ZK();
            Boolean valueOf3 = Boolean.valueOf(C42252ah.m74619e((Boolean) C18628c.m29072Ry().get(340228, null)));
            C9638aw.m17190ZK();
            Boolean valueOf4 = Boolean.valueOf(C42252ah.m74619e((Boolean) C18628c.m29072Ry().get(340229, null)));
            if (valueOf.booleanValue() && valueOf3.booleanValue() && valueOf4.booleanValue() && !valueOf2.booleanValue() && currentTimeMillis >= 432000000) {
                yiF = Boolean.TRUE;
                m79874pG(false);
            }
            AppMethodBeat.m2505o(29394);
            return;
        }
        C4990ab.m7412e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
        AppMethodBeat.m2505o(29394);
    }

    /* renamed from: pG */
    private void m79874pG(final boolean z) {
        AppMethodBeat.m2504i(29395);
        if (this.rKY != null) {
            C4990ab.m7412e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
            AppMethodBeat.m2505o(29395);
            return;
        }
        this.rKY = View.inflate(C4996ah.getContext(), 2130970305, null);
        TextView textView = (TextView) this.rKY.findViewById(2131826356);
        if (z) {
            textView.setText(C4996ah.getContext().getString(C25738R.string.f8702cj));
        } else {
            textView.setText(C4996ah.getContext().getString(C25738R.string.f8700ch));
        }
        LayoutParams layoutParams = new LayoutParams(-2, -2, 53);
        this.rKY.setBackgroundResource(C25738R.drawable.bdv);
        if (this.contentView != null) {
            ((ViewGroup) this.contentView).addView(this.rKY, layoutParams);
            this.rKY.startAnimation(AnimationUtils.loadAnimation(C4996ah.getContext(), C25738R.anim.f8396d4));
            this.rKY.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(29342);
                    HomeUI.this.yiD.mo49182gP();
                    if (z) {
                        HomeUI homeUI = HomeUI.this;
                        Boolean bool = Boolean.TRUE;
                        HomeUI.m79850a(homeUI, bool, bool);
                        AppMethodBeat.m2505o(29342);
                        return;
                    }
                    HomeUI.m79850a(HomeUI.this, Boolean.TRUE, Boolean.FALSE);
                    AppMethodBeat.m2505o(29342);
                }
            });
        }
        AppMethodBeat.m2505o(29395);
    }

    /* renamed from: c */
    private void m79860c(Boolean bool, Boolean bool2) {
        AppMethodBeat.m2504i(29396);
        if (this.rKY != null) {
            this.rKY.clearAnimation();
            this.rKY.setVisibility(8);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(340227, Boolean.TRUE);
                    C7060h.pYm.mo8378a(232, 0, 1, false);
                    yiE = Boolean.FALSE;
                } else {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(340230, Boolean.TRUE);
                    C7060h.pYm.mo8378a(232, 5, 1, false);
                    yiF = Boolean.FALSE;
                }
            }
            this.rKY = null;
        }
        AppMethodBeat.m2505o(29396);
    }

    /* Access modifiers changed, original: final */
    public final void dxj() {
        AppMethodBeat.m2504i(29397);
        if (this.yiD == null || !C9638aw.m17179RK()) {
            AppMethodBeat.m2505o(29397);
        } else if (this.yiD.isShowing()) {
            this.yiD.dismiss();
            AppMethodBeat.m2505o(29397);
        } else {
            this.yiD.mo49182gP();
            AppMethodBeat.m2505o(29397);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pH */
    public final void mo69894pH(boolean z) {
        AppMethodBeat.m2504i(29398);
        if (this.yiD == null || this.yiW == null) {
            AppMethodBeat.m2505o(29398);
        } else if (C9638aw.m17179RK()) {
            int i;
            this.yiD.ypJ.mo70296pY(z);
            if (this.yiD.ypJ.ypC > 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                this.yiY.setVisibility(0);
                AppMethodBeat.m2505o(29398);
                return;
            }
            this.yiY.setVisibility(8);
            AppMethodBeat.m2505o(29398);
        } else {
            C4990ab.m7420w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
            AppMethodBeat.m2505o(29398);
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void dxk() {
        AppMethodBeat.m2504i(29399);
        if (this.yje != null) {
            C0464g.m806a(this.yje, 2);
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
                C0464g.m806a(this.yjc, 2);
                this.yjc.setVisible(true);
            } else {
                this.yjc.setVisible(false);
                this.yjc.setEnabled(false);
            }
        }
        if (this.yjb != null) {
            if (this.yjg) {
                C0464g.m806a(this.yjb, 2);
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
                C0464g.m806a(this.yjd, 2);
                this.yjd.setVisible(true);
                this.yeR.setVisibility(0);
                AppMethodBeat.m2505o(29399);
                return;
            }
        }
        AppMethodBeat.m2505o(29399);
    }

    /* Access modifiers changed, original: final */
    public final void dxl() {
        AppMethodBeat.m2504i(29400);
        if (((C12029n) C1720g.m3530M(C12029n.class)).isFTSIndexReady()) {
            int i = this.yiP.mbt;
            if (i == 0) {
                getMainTabUI().dyx();
            }
            Intent putExtra = new Intent().putExtra("from_tab_index", i).putExtra(MMFragment.FLAG_OVERRIDE_ENTER_ANIMATION, 0).putExtra(MMFragment.FLAG_OVERRIDE_EXIT_ANIMATION, 0);
            Bundle bundle = null;
            if (VERSION.SDK_INT >= 21) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(this.yhZ, new Pair[0]).toBundle();
            }
            C3161d.m5411b(this.yhZ, ".ui.FTSMainUI", putExtra, bundle);
            AppMethodBeat.m2505o(29400);
            return;
        }
        Toast.makeText(C4996ah.getContext(), C25738R.string.e0p, 0).show();
        AppMethodBeat.m2505o(29400);
    }

    /* Access modifiers changed, original: final */
    public final void dxm() {
        C22212h c22212h;
        AppMethodBeat.m2504i(29402);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
        if (booleanValue) {
            this.yiT = false;
            if (this.yja != null) {
                this.yja.findViewById(2131820972).setVisibility(8);
                c22212h = C22212h.scu;
                C22212h.m33897lo(0);
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.FALSE);
        }
        if (this.yja != null) {
            this.yja.findViewById(2131820972).setVisibility(8);
            c22212h = C22212h.scu;
            C22212h.m33897lo(0);
        }
        if (((C35168e) C1720g.m3530M(C35168e.class)).canPostStory()) {
            Context context = this.yhZ;
            C22212h c22212h2 = C22212h.scu;
            C46270n.m86704a(context, 0, C22212h.cAI(), 10);
            AppMethodBeat.m2505o(29402);
            return;
        }
        C1720g.m3537RQ();
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_STORY_ONE_DAY_POST_COUNT_INT_SYNC, Integer.valueOf(0))).intValue();
        C30379h.m48461b(this.yhZ, "", this.yhZ.getResources().getString(C25738R.string.et6, new Object[]{Integer.valueOf(intValue)}), true);
        AppMethodBeat.m2505o(29402);
    }

    public final void dxn() {
        AppMethodBeat.m2504i(29403);
        if (C1853r.m3852Zf().booleanValue() && (yiE.booleanValue() || yiF.booleanValue())) {
            Boolean bool = Boolean.FALSE;
            m79860c(bool, bool);
        }
        this.yiP.dxn();
        AppMethodBeat.m2505o(29403);
    }

    public final void dxo() {
        AppMethodBeat.m2504i(29404);
        C9638aw.m17180RS().doK();
        this.yiP.dyC();
        C5004al.m7441d(this.yjh);
        AppMethodBeat.m2505o(29404);
    }

    public final boolean dxp() {
        return this.yiM == C5182a.ACTIVITY_RESUME;
    }

    /* renamed from: pI */
    public final void mo69895pI(boolean z) {
        AppMethodBeat.m2504i(29406);
        if (!z) {
            initActionBar();
        }
        this.yhZ.supportInvalidateOptionsMenu();
        if (C1853r.m3852Zf().booleanValue()) {
            dxi();
        }
        this.yiP.dyB();
        AppMethodBeat.m2505o(29406);
    }

    /* Access modifiers changed, original: final */
    public final void initActionBar() {
        AppMethodBeat.m2504i(29407);
        if (this.yiN.dxM()) {
            C4990ab.m7420w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
            AppMethodBeat.m2505o(29407);
            return;
        }
        this.mActionBar.setLogo(new ColorDrawable(this.yhZ.getResources().getColor(17170445)));
        this.mActionBar.mo1339fc();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.mo1338fb();
        this.mActionBar.mo1340fd();
        this.mActionBar.setCustomView(C1742b.m3596SM().mo5274a(this.yhZ, "R.layout.actionbar_title_launcher", 2130968619));
        ImageView imageView = (ImageView) this.mActionBar.getCustomView().findViewById(2131820974);
        if (imageView != null && this.qlP) {
            imageView.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
        }
        if (this.qlP) {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(C25738R.color.f11906l8)));
        } else {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.yhZ.getResources().getColor(C25738R.color.f12206vy)));
        }
        updateTitle();
        this.mActionBar.getCustomView().findViewById(2131820983).setOnClickListener(new C1546417());
        AppMethodBeat.m2505o(29407);
    }

    /* renamed from: MS */
    private void m79843MS(int i) {
        AppMethodBeat.m2504i(29408);
        if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(29408);
            return;
        }
        if ((VERSION.SDK_INT < 23 || C1448h.m3077Mt()) && VERSION.SDK_INT >= 21) {
            i = C5225ah.m7964s(this.yhZ.getResources().getColor(C25738R.color.a1h), i);
        }
        if (Math.abs(this.yji - i) >= SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH) {
            C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "updateStatusBar %s stack: %s", Integer.valueOf(i), C42252ah.anW().toString());
            this.yhZ.getWindow().setStatusBarColor(i);
        }
        this.yji = i;
        AppMethodBeat.m2505o(29408);
    }

    /* renamed from: pJ */
    private void m79875pJ(boolean z) {
        AppMethodBeat.m2504i(29409);
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
        AppMethodBeat.m2505o(29409);
    }

    public final void setTitleBarDoubleClickListener(Runnable runnable) {
        AppMethodBeat.m2504i(29410);
        if (!this.yjj.contains(runnable)) {
            this.yjj.add(runnable);
        }
        AppMethodBeat.m2505o(29410);
    }

    /* renamed from: aw */
    public final void mo69881aw(Runnable runnable) {
        AppMethodBeat.m2504i(29411);
        this.yjj.remove(runnable);
        AppMethodBeat.m2505o(29411);
    }

    public final void dxq() {
        AppMethodBeat.m2504i(29413);
        updateTitle();
        AppMethodBeat.m2505o(29413);
    }

    public final void dxr() {
        AppMethodBeat.m2504i(29414);
        this.yiP.dxr();
        AppMethodBeat.m2505o(29414);
    }

    /* renamed from: MT */
    private void m79844MT(int i) {
        AppMethodBeat.m2504i(29415);
        if (this.mActionBar != null) {
            this.mActionBar.setBackgroundDrawable(new ColorDrawable(i));
        }
        AppMethodBeat.m2505o(29415);
    }

    /* renamed from: a */
    public final void mo22614a(float f, int i, int i2, int i3) {
        AppMethodBeat.m2504i(29416);
        if (getMainTabUI().dyx() != null) {
            MMFragment dyx = getMainTabUI().dyx();
            if (dyx instanceof MoreTabUI) {
                m79844MT(this.yhZ.getResources().getColor(C25738R.color.a3p));
                AppMethodBeat.m2505o(29416);
                return;
            } else if (dyx instanceof MainUI) {
                if (((double) Math.abs(f)) < 0.01d) {
                    m79844MT(this.yhZ.getResources().getColor(C25738R.color.a3p));
                    if (!this.yiS) {
                        this.yiS = true;
                        m79875pJ(true);
                    }
                    HomeUI.m79882v(this.yfm, false);
                    HomeUI.m79882v(this.yiW, false);
                } else if (f >= 1.0f) {
                    if (this.yiS) {
                        this.yiS = false;
                        m79875pJ(false);
                    }
                    m79844MT(this.yhZ.getResources().getColor(C25738R.color.f12206vy));
                    HomeUI.m79882v(this.yfm, true);
                    HomeUI.m79882v(this.yiW, true);
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
                m79844MT(this.yhZ.getResources().getColor(C25738R.color.f12206vy));
                AppMethodBeat.m2505o(29416);
                return;
            }
        }
        AppMethodBeat.m2505o(29416);
    }

    public final void dxs() {
        AppMethodBeat.m2504i(29417);
        this.yiP.mo48629Nj(180);
        AppMethodBeat.m2505o(29417);
    }

    private static boolean dxt() {
        AppMethodBeat.m2504i(29418);
        if (!C46270n.isShowStoryCheck()) {
            AppMethodBeat.m2505o(29418);
            return false;
        } else if (((C35168e) C1720g.m3530M(C35168e.class)).isStoryExist(C1853r.m3846Yz())) {
            AppMethodBeat.m2505o(29418);
            return true;
        } else {
            AppMethodBeat.m2505o(29418);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void dxu() {
        AppMethodBeat.m2504i(29419);
        if (!(this.yje == null || this.yje.getActionView() == null)) {
            ImageView imageView = (ImageView) this.yje.getActionView().findViewById(2131820915);
            imageView.setImageDrawable(this.yhZ.getResources().getDrawable(C1318a.icons_filled_camera));
            if (HomeUI.dxt()) {
                imageView.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
            } else {
                imageView.setColorFilter(new PorterDuffColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP));
            }
            if (this.yiT) {
                this.yiT = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_STORY_POST_FIRST_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
                this.yje.getActionView().findViewById(2131820972).setVisibility(0);
                AppMethodBeat.m2505o(29419);
                return;
            }
            this.yje.getActionView().findViewById(2131820972).setVisibility(8);
        }
        AppMethodBeat.m2505o(29419);
    }

    /* renamed from: pK */
    public final void mo69896pK(boolean z) {
        AppMethodBeat.m2504i(29420);
        if (!(this.yje == null || this.yje.getActionView() == null || this.yhZ == null)) {
            if (this.yhZ.getResources().getConfiguration().orientation == 2) {
                this.yje.setVisible(false);
                this.yje.setEnabled(false);
                AppMethodBeat.m2505o(29420);
                return;
            }
            this.yje.setVisible(true);
            this.yje.setEnabled(true);
            ImageView imageView = (ImageView) this.yje.getActionView().findViewById(2131820915);
            imageView.setImageDrawable(this.yhZ.getResources().getDrawable(C1318a.icons_filled_camera));
            if (z) {
                imageView.setColorFilter(new PorterDuffColorFilter(-1, Mode.SRC_ATOP));
            } else {
                imageView.setColorFilter(new PorterDuffColorFilter(WebView.NIGHT_MODE_COLOR, Mode.SRC_ATOP));
            }
            if (this.yiT) {
                this.yje.getActionView().findViewById(2131820972).setVisibility(0);
                AppMethodBeat.m2505o(29420);
                return;
            }
            this.yje.getActionView().findViewById(2131820972).setVisibility(8);
        }
        AppMethodBeat.m2505o(29420);
    }

    /* renamed from: v */
    private static void m79882v(View view, boolean z) {
        AppMethodBeat.m2504i(29421);
        if (view != null) {
            if (z) {
                view.setClickable(true);
                view.setBackgroundResource(C25738R.drawable.f6332al);
                AppMethodBeat.m2505o(29421);
                return;
            }
            view.setClickable(false);
            view.setBackgroundResource(C25738R.color.a3p);
        }
        AppMethodBeat.m2505o(29421);
    }

    public final String getString(int i) {
        AppMethodBeat.m2504i(29401);
        String string = this.yhZ.getString(i);
        AppMethodBeat.m2505o(29401);
        return string;
    }

    /* renamed from: a */
    public final void mo56794a(FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(29405);
        this.yhZ.getWindow().getDecorView().getBottom();
        this.yhZ.getSupportActionBar().getCustomView().getBottom();
        fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
        fitSystemWindowLayoutView.fitSystemWindows(rect);
        AppMethodBeat.m2505o(29405);
    }

    /* Access modifiers changed, original: final */
    public final void dwf() {
        AppMethodBeat.m2504i(29412);
        if (this.yhZ != null) {
            this.yhZ.moveTaskToBack(true);
        }
        if (C9638aw.m17179RK()) {
            C9638aw.m17180RS().mo10310m(new C2353421(), 500);
        }
        C25798n Bw = C25798n.m41027Bw();
        Bw.ceU = false;
        Bw.ceV.removeMessages(-1999);
        Bw.ceV.removeMessages(-2999);
        Bw.ceV.sendEmptyMessageDelayed(-1999, 3000);
        Bw.ceV.sendEmptyMessageDelayed(-2999, 30000);
        AppMethodBeat.m2505o(29412);
    }

    static /* synthetic */ void dxv() {
        AppMethodBeat.m2504i(29424);
        int fX = C1338a.m2861fX(C4996ah.getContext());
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_font_size_report_time", C1448h.m3078Mu()).getLong("font_size_report_time", 0) > 604800000) {
            C7060h.pYm.mo8381e(14239, Integer.valueOf(fX));
            C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_font_size_report_time", C1448h.m3078Mu()).edit().putLong("font_size_report_time", currentTimeMillis).commit();
            C4990ab.m7417i("MicroMsg.LauncherUI.HomeUI", "using font size kvReport logID:%d , usingFontSize: %d", Integer.valueOf(14239), Integer.valueOf(fX));
        }
        AppMethodBeat.m2505o(29424);
    }

    /* renamed from: k */
    static /* synthetic */ void m79868k(HomeUI homeUI) {
        AppMethodBeat.m2504i(29426);
        MMFragmentActivity mMFragmentActivity = homeUI.yhZ;
        try {
            Intent intent = new Intent(mMFragmentActivity, Class.forName("com.tencent.mm.plugin.story.ui.StorySettingsUI"));
            if (mMFragmentActivity instanceof Activity) {
                mMFragmentActivity.startActivityForResult(intent, 10);
                AppMethodBeat.m2505o(29426);
                return;
            }
            mMFragmentActivity.startActivity(intent);
            AppMethodBeat.m2505o(29426);
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("LaunchStory", e, "startStorySetting failed", new Object[0]);
            AppMethodBeat.m2505o(29426);
        }
    }

    /* renamed from: s */
    static /* synthetic */ void m79878s(HomeUI homeUI) {
        AppMethodBeat.m2504i(29430);
        homeUI.mo69894pH(false);
        AppMethodBeat.m2505o(29430);
    }

    static /* synthetic */ void dxw() {
        AppMethodBeat.m2504i(29432);
        if (VERSION.SDK_INT < 18) {
            C4996ah.getContext().startService(new Intent(C4996ah.getContext(), NotifyService.class));
        }
        AppMethodBeat.m2505o(29432);
    }
}
