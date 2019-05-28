package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.l;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.db;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.contact.AddressUI.AddressUIFragment;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.HashSet;

public class MainTabUI {
    private static HashMap<String, Integer> ynP;
    private final long TIME_INTERVAL = 180000;
    private int bts = -1;
    com.tencent.mm.plugin.appbrand.widget.header.a iVv;
    public int mbt = -1;
    CustomViewPager yeo;
    MMFragmentActivity yhZ;
    public w ynE = new w();
    d ynF;
    boolean ynG;
    private HashSet<m> ynH = new HashSet();
    TabsAdapter ynI;
    private int ynJ = -1;
    private int ynK = -1;
    a ynL;
    c ynM = new c<ar>() {
        {
            AppMethodBeat.i(29615);
            this.xxI = ar.class.getName().hashCode();
            AppMethodBeat.o(29615);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(29616);
            int i = ((ar) bVar).ctN.index;
            if (i < 0 || i > 3) {
                AppMethodBeat.o(29616);
            } else {
                switch (i) {
                    case 0:
                        MainTabUI.this.aqG("tab_main");
                        break;
                    case 1:
                        MainTabUI.this.aqG("tab_address");
                        break;
                    case 2:
                        MainTabUI.this.aqG("tab_find_friend");
                        break;
                    case 3:
                        MainTabUI.this.aqG("tab_settings");
                        break;
                }
                AppMethodBeat.o(29616);
            }
            return false;
        }
    };
    private boolean ynN = true;
    c ynO = new c<db>() {
        {
            AppMethodBeat.i(29617);
            this.xxI = db.class.getName().hashCode();
            AppMethodBeat.o(29617);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(29618);
            ab.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo EnableMainBottomTabSwitchEvent enable: %b", Boolean.valueOf(((db) bVar).cwi.enable));
            MainTabUI.this.ynN = r8.cwi.enable;
            MainTabUI.this.yeo.setCanSlide(MainTabUI.this.ynN);
            AppMethodBeat.o(29618);
            return true;
        }
    };
    public HashMap<Integer, MMFragment> ynQ = new HashMap();

    public interface a {
        void MU(int i);

        void MV(int i);

        void p(int i, float f);
    }

    public class TabsAdapter extends l implements OnPageChangeListener, com.tencent.mm.ui.c.a {
        private AddressUIFragment addressFragment;
        private int clickCount = 0;
        private boolean isTabClicked = false;
        boolean[] mFragmentResumedFlags = new boolean[]{true, false, false, false};
        private final WxViewPager mViewPager;

        public TabsAdapter(FragmentActivity fragmentActivity, WxViewPager wxViewPager) {
            super(fragmentActivity.getSupportFragmentManager());
            AppMethodBeat.i(29620);
            this.mViewPager = wxViewPager;
            this.mViewPager.setAdapter(this);
            this.mViewPager.setOnPageChangeListener(this);
            AppMethodBeat.o(29620);
        }

        public int getCount() {
            return 4;
        }

        public Fragment getItem(int i) {
            AppMethodBeat.i(29621);
            MMFragment Nn = MainTabUI.this.Nn(i);
            AppMethodBeat.o(29621);
            return Nn;
        }

        public void onPageScrolled(final int i, float f, int i2) {
            AppMethodBeat.i(29622);
            w c = MainTabUI.this.ynE;
            if (c.ynT != null) {
                c.ynT.l(i, f);
            }
            if (MainTabUI.this.ynL != null) {
                MainTabUI.this.ynL.p(i, f);
            }
            if (0.0f != f) {
                if (this.addressFragment == null) {
                    this.addressFragment = (AddressUIFragment) MainTabUI.this.Nn(1);
                }
                this.addressFragment.qA(false);
            } else {
                ab.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", Integer.valueOf(i), Integer.valueOf(MainTabUI.this.bts));
                if (-1 == MainTabUI.this.bts) {
                    MainTabUI.this.hc(MainTabUI.this.bts, MainTabUI.this.mbt);
                    MainTabUI.this.Nk(i);
                } else {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(29619);
                            MainTabUI.this.hc(MainTabUI.this.bts, MainTabUI.this.mbt);
                            MainTabUI.this.Nk(i);
                            AppMethodBeat.o(29619);
                        }
                    });
                }
            }
            fixAndroidOProgressBarOutScreenFlashProblem(i, f, i2);
            AppMethodBeat.o(29622);
        }

        private void fixAndroidOProgressBarOutScreenFlashProblem(int i, float f, int i2) {
            AppMethodBeat.i(29623);
            if (i2 == 0) {
                for (Integer num : MainTabUI.ynP.values()) {
                    if (num.intValue() != i) {
                        setFragmentLoadingIconVisibility(num.intValue(), 8);
                    } else if (!this.mFragmentResumedFlags[num.intValue()]) {
                        setFragmentLoadingIconVisibility(num.intValue(), 0);
                    }
                }
                AppMethodBeat.o(29623);
                return;
            }
            for (Integer num2 : MainTabUI.ynP.values()) {
                if (!(num2.intValue() == i || this.mFragmentResumedFlags[num2.intValue()])) {
                    setFragmentLoadingIconVisibility(num2.intValue(), 0);
                }
            }
            AppMethodBeat.o(29623);
        }

        private void setFragmentLoadingIconVisibility(int i, int i2) {
            AppMethodBeat.i(29624);
            if (!(MainTabUI.this.Nn(i) == null || MainTabUI.this.Nn(i).getActivity() == null)) {
                View findViewById = MainTabUI.this.Nn(i).findViewById(R.id.b_x);
                if (findViewById != null) {
                    findViewById.setVisibility(i2);
                }
            }
            AppMethodBeat.o(29624);
        }

        public void onPageSelected(int i) {
            AppMethodBeat.i(29625);
            ab.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", Integer.valueOf(i));
            reportSwitch(i);
            MainTabUI.this.bts = MainTabUI.this.mbt;
            MainTabUI.this.mbt = i;
            MainTabUI.this.ynE.Np(i);
            MainTabUI.this.yhZ.supportInvalidateOptionsMenu();
            if (MainTabUI.this.bts == 1 && MainTabUI.this.mbt != 1) {
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(340226, Long.valueOf(System.currentTimeMillis()));
            }
            if (MainTabUI.this.mbt == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                aw.ZK();
                if (currentTimeMillis - ah.d((Long) com.tencent.mm.model.c.Ry().get(340226, null)) >= 180000) {
                    ((AddressUIFragment) MainTabUI.this.Nn(MainTabUI.this.mbt)).dHB();
                }
            }
            if (MainTabUI.this.mbt == 0) {
                aw.getNotification().bv(true);
            } else {
                aw.getNotification().bv(false);
            }
            if (MainTabUI.this.ynL != null) {
                MainTabUI.this.ynL.MU(MainTabUI.this.mbt);
            }
            AppMethodBeat.o(29625);
        }

        private void reportSwitch(int i) {
            AppMethodBeat.i(29626);
            ab.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", Integer.valueOf(this.clickCount), Integer.valueOf(i));
            if (this.clickCount <= 0) {
                switch (i) {
                    case 0:
                        h.pYm.X(10957, "5");
                        break;
                    case 1:
                        h.pYm.X(10957, "6");
                        break;
                    case 2:
                        h.pYm.X(10957, "7");
                        break;
                }
            }
            this.clickCount--;
            switch (i) {
                case 0:
                    h.pYm.X(10957, "1");
                    break;
                case 1:
                    h.pYm.X(10957, "2");
                    break;
                case 2:
                    h.pYm.X(10957, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                    break;
                case 3:
                    h.pYm.X(10957, "4");
                    break;
            }
            this.isTabClicked = false;
            AppMethodBeat.o(29626);
        }

        public void onPageScrollStateChanged(int i) {
            AppMethodBeat.i(29627);
            ab.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", Integer.valueOf(i));
            if (i == 0 && this.addressFragment != null) {
                this.addressFragment.qA(true);
                this.addressFragment = null;
            }
            if (MainTabUI.this.ynL != null) {
                MainTabUI.this.ynL.MV(i);
            }
            AppMethodBeat.o(29627);
        }

        public void onTabClick(int i) {
            AppMethodBeat.i(29628);
            if (!MainTabUI.this.ynN) {
                ab.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
                AppMethodBeat.o(29628);
            } else if (i == MainTabUI.this.mbt) {
                ab.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
                MMFragment Nn = MainTabUI.this.Nn(i);
                if (Nn instanceof AbStractTabFragment) {
                    ((AbStractTabFragment) Nn).dwe();
                }
                AppMethodBeat.o(29628);
            } else {
                this.isTabClicked = true;
                this.clickCount++;
                ab.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", Integer.valueOf(this.clickCount));
                this.mViewPager.setCurrentItem(i, false);
                if (i == 3) {
                    int i2;
                    com.tencent.mm.x.c.PK().bZ(262145, 266241);
                    com.tencent.mm.x.c.PK().bZ(262156, 266241);
                    com.tencent.mm.x.c.PK().bZ(262147, 266241);
                    com.tencent.mm.x.c.PK().bZ(262149, 266241);
                    com.tencent.mm.x.c.PK().b(com.tencent.mm.storage.ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266241);
                    com.tencent.mm.x.c.PK().c(com.tencent.mm.storage.ac.a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, com.tencent.mm.storage.ac.a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
                    boolean bY = com.tencent.mm.x.c.PK().bY(262156, 266241);
                    h hVar = h.pYm;
                    Object[] objArr = new Object[5];
                    objArr[0] = Integer.valueOf(6);
                    if (bY) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = "";
                    objArr[3] = "";
                    objArr[4] = Integer.valueOf(0);
                    hVar.e(14872, objArr);
                    g.RQ();
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
                }
                AppMethodBeat.o(29628);
            }
        }
    }

    public MainTabUI() {
        AppMethodBeat.i(29629);
        AppMethodBeat.o(29629);
    }

    public final MMFragment dyx() {
        AppMethodBeat.i(29630);
        MMFragment mMFragment = (MMFragment) this.ynQ.get(Integer.valueOf(this.mbt));
        AppMethodBeat.o(29630);
        return mMFragment;
    }

    public final void Nj(int i) {
        AppMethodBeat.i(29631);
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        if (mainUI != null) {
            mainUI.Nj(i);
        }
        AppMethodBeat.o(29631);
    }

    public final void dyy() {
        AppMethodBeat.i(29632);
        com.tencent.mm.sdk.b.a.xxA.d(this.ynM);
        com.tencent.mm.sdk.b.a.xxA.d(this.ynO);
        dyz();
        AppMethodBeat.o(29632);
    }

    private void dyz() {
        AppMethodBeat.i(29633);
        this.ynQ.clear();
        if (this.yeo != null) {
            this.yeo.setCanSlide(false);
            this.yeo.setCanSlideBySide(false);
        }
        AppMethodBeat.o(29633);
    }

    public final void dxr() {
        AppMethodBeat.i(29634);
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        if (mainUI != null) {
            mainUI.dHz();
            mainUI.dIT();
        }
        AppMethodBeat.o(29634);
    }

    public final void dyA() {
        AppMethodBeat.i(29635);
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        if (mainUI != null) {
            mainUI.dIU();
        }
        AppMethodBeat.o(29635);
    }

    public final void hc(int i, int i2) {
        AppMethodBeat.i(29636);
        if (i == i2) {
            AppMethodBeat.o(29636);
            return;
        }
        MMFragment Nn = Nn(i);
        if (Nn != null && (Nn instanceof m)) {
            ((m) Nn).dxd();
        }
        Nn = Nn(i2);
        if (Nn != null && (Nn instanceof m)) {
            ((m) Nn).dxc();
        }
        j.a(this.yhZ, 4, i, "deliverOnTabChange");
        j.a(this.yhZ, 3, i2, "deliverOnTabChange");
        AppMethodBeat.o(29636);
    }

    public final void Nk(int i) {
        AppMethodBeat.i(29637);
        MMFragment Nn = Nn(i);
        if (Nn == null) {
            AppMethodBeat.o(29637);
            return;
        }
        if (Nn instanceof m) {
            ((m) Nn).dwl();
        }
        this.ynI.mFragmentResumedFlags[i] = true;
        AppMethodBeat.o(29637);
    }

    public final void dxn() {
        AppMethodBeat.i(29638);
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) this.yhZ.findViewById(R.id.bp);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(4);
        }
        if (mainUI != null) {
            mainUI.onHiddenChanged(true);
        }
        j.a(this.yhZ, 4, this.mbt, "prepareStartChatting");
        dyA();
        this.ynE.dyC();
        AppMethodBeat.o(29638);
    }

    public final void dyB() {
        AppMethodBeat.i(29639);
        if (this.mbt == 0 && g.RO().eJo.foreground) {
            aw.getNotification().bv(true);
        } else {
            aw.getNotification().bv(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.yhZ.findViewById(R.id.bp);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(1);
        }
        dxr();
        j.a(this.yhZ, 3, this.mbt, "prepareCloseChatting");
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        if (mainUI != null) {
            mainUI.getContentView();
            if (mainUI.mController != null) {
                mainUI.mController.onResume();
            }
            mainUI.onHiddenChanged(false);
        }
        AppMethodBeat.o(29639);
    }

    static {
        AppMethodBeat.i(29649);
        HashMap hashMap = new HashMap();
        ynP = hashMap;
        hashMap.put("tab_main", Integer.valueOf(0));
        ynP.put("tab_address", Integer.valueOf(1));
        ynP.put("tab_find_friend", Integer.valueOf(2));
        ynP.put("tab_settings", Integer.valueOf(3));
        AppMethodBeat.o(29649);
    }

    public final void aqG(String str) {
        AppMethodBeat.i(29640);
        if (str == null || str.equals("")) {
            AppMethodBeat.o(29640);
            return;
        }
        Nm(((Integer) ynP.get(str)).intValue());
        AppMethodBeat.o(29640);
    }

    private MMFragment Nl(int i) {
        AppMethodBeat.i(29641);
        MMFragment mMFragment = null;
        Bundle bundle = new Bundle();
        switch (i) {
            case 0:
                bundle.putInt(MainUI.class.getName(), 0);
                mMFragment = (MMFragment) Fragment.instantiate(this.yhZ, MainUI.class.getName(), bundle);
                if (mMFragment instanceof MainUI) {
                    MainUI mainUI = (MainUI) mMFragment;
                    MMFragmentActivity mMFragmentActivity = this.yhZ;
                    mainUI.iWA = mMFragmentActivity;
                    if (mainUI.zuW != null) {
                        mainUI.zuW.setActivity(mMFragmentActivity);
                    }
                    mainUI = (MainUI) mMFragment;
                    com.tencent.mm.plugin.appbrand.widget.header.a aVar = this.iVv;
                    mainUI.zve = aVar;
                    if (mainUI.zuW != null) {
                        mainUI.zuW.setActionBarUpdateCallback(aVar);
                    }
                }
                aw.getNotification().bv(true);
                break;
            case 1:
                bundle.putInt(AddressUIFragment.class.getName(), 1);
                bundle.putBoolean("Need_Voice_Search", true);
                bundle.putBoolean("favour_include_biz", true);
                mMFragment = (MMFragment) Fragment.instantiate(this.yhZ, AddressUIFragment.class.getName(), bundle);
                break;
            case 2:
                bundle.putInt(FindMoreFriendsUI.class.getName(), 2);
                mMFragment = (MMFragment) Fragment.instantiate(this.yhZ, FindMoreFriendsUI.class.getName(), bundle);
                break;
            case 3:
                bundle.putInt(MoreTabUI.class.getName(), 3);
                mMFragment = (MMFragment) Fragment.instantiate(this.yhZ, MoreTabUI.class.getName(), bundle);
                break;
        }
        ab.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", Integer.valueOf(i));
        if (mMFragment != null) {
            mMFragment.setParent(this.yhZ);
        }
        AppMethodBeat.o(29641);
        return mMFragment;
    }

    public final void Nm(int i) {
        AppMethodBeat.i(29642);
        String str = "MicroMsg.LauncherUI.MainTabUI";
        String str2 = "change tab to %d, cur tab %d, has init tab %B, tab cache size %d";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.mbt);
        objArr[2] = Boolean.valueOf(this.yeo != null);
        objArr[3] = Integer.valueOf(this.ynQ.size());
        ab.i(str, str2, objArr);
        if (this.yeo == null || i < 0 || (this.ynI != null && i > this.ynI.getCount() - 1)) {
            AppMethodBeat.o(29642);
        } else if (this.mbt != i || this.ynQ.size() == 0) {
            this.mbt = i;
            this.ynE.Np(this.mbt);
            if (this.yeo != null) {
                this.yeo.setCurrentItem(this.mbt, false);
                Nk(this.mbt);
            }
            if (this.mbt == 0 && g.RO().eJo.foreground) {
                aw.getNotification().bv(true);
                AppMethodBeat.o(29642);
                return;
            }
            aw.getNotification().bv(false);
            AppMethodBeat.o(29642);
        } else {
            AppMethodBeat.o(29642);
        }
    }

    public final MMFragment Nn(int i) {
        AppMethodBeat.i(29643);
        ab.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", Integer.valueOf(i));
        MMFragment mMFragment;
        if (i < 0) {
            AppMethodBeat.o(29643);
            return null;
        } else if (this.ynQ.containsKey(Integer.valueOf(i))) {
            mMFragment = (MMFragment) this.ynQ.get(Integer.valueOf(i));
            AppMethodBeat.o(29643);
            return mMFragment;
        } else {
            mMFragment = Nl(i);
            this.ynQ.put(Integer.valueOf(i), mMFragment);
            AppMethodBeat.o(29643);
            return mMFragment;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyC() {
        AppMethodBeat.i(29644);
        this.ynE.dyC();
        AppMethodBeat.o(29644);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyD() {
        AppMethodBeat.i(29645);
        this.ynE.dyD();
        AppMethodBeat.o(29645);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyE() {
        AppMethodBeat.i(29646);
        this.ynE.dyE();
        AppMethodBeat.o(29646);
    }

    public final int dyF() {
        int e;
        AppMethodBeat.i(29647);
        w wVar = this.ynE;
        long currentTimeMillis = System.currentTimeMillis();
        if (aw.RK()) {
            e = u.e(t.fkP, af.dzi());
            ab.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", Integer.valueOf(e));
        } else {
            ab.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
            e = 0;
        }
        wVar.No(e);
        ab.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(e));
        AppMethodBeat.o(29647);
        return e;
    }

    public final void dyG() {
        AppMethodBeat.i(29648);
        this.ynQ.get(Integer.valueOf(0));
        AppMethodBeat.o(29648);
    }
}
