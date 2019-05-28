package com.tencent.p177mm.p612ui;

import android.os.Bundle;
import android.support.p057v4.app.C31857l;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p230g.p231a.C18221ar;
import com.tencent.p177mm.p230g.p231a.C26112db;
import com.tencent.p177mm.p612ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.p177mm.p612ui.C5301c.C5302a;
import com.tencent.p177mm.p612ui.LauncherUI.C23539d;
import com.tencent.p177mm.p612ui.base.CustomViewPager;
import com.tencent.p177mm.p612ui.contact.AddressUI.AddressUIFragment;
import com.tencent.p177mm.p612ui.conversation.MainUI;
import com.tencent.p177mm.p612ui.mogic.WxViewPager;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10984a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.tencent.mm.ui.MainTabUI */
public class MainTabUI {
    private static HashMap<String, Integer> ynP;
    private final long TIME_INTERVAL = 180000;
    private int bts = -1;
    C10984a iVv;
    public int mbt = -1;
    CustomViewPager yeo;
    MMFragmentActivity yhZ;
    public C44395w ynE = new C44395w();
    C23539d ynF;
    boolean ynG;
    private HashSet<C15912m> ynH = new HashSet();
    TabsAdapter ynI;
    private int ynJ = -1;
    private int ynK = -1;
    C23542a ynL;
    C4884c ynM = new C303401();
    private boolean ynN = true;
    C4884c ynO = new C303382();
    public HashMap<Integer, MMFragment> ynQ = new HashMap();

    /* renamed from: com.tencent.mm.ui.MainTabUI$a */
    public interface C23542a {
        /* renamed from: MU */
        void mo39213MU(int i);

        /* renamed from: MV */
        void mo39214MV(int i);

        /* renamed from: p */
        void mo39215p(int i, float f);
    }

    /* renamed from: com.tencent.mm.ui.MainTabUI$2 */
    class C303382 extends C4884c<C26112db> {
        C303382() {
            AppMethodBeat.m2504i(29617);
            this.xxI = C26112db.class.getName().hashCode();
            AppMethodBeat.m2505o(29617);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29618);
            C4990ab.m7417i("MicroMsg.LauncherUI.MainTabUI", "alvinluo EnableMainBottomTabSwitchEvent enable: %b", Boolean.valueOf(((C26112db) c4883b).cwi.enable));
            MainTabUI.this.ynN = r8.cwi.enable;
            MainTabUI.this.yeo.setCanSlide(MainTabUI.this.ynN);
            AppMethodBeat.m2505o(29618);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.MainTabUI$TabsAdapter */
    public class TabsAdapter extends C31857l implements OnPageChangeListener, C5302a {
        private AddressUIFragment addressFragment;
        private int clickCount = 0;
        private boolean isTabClicked = false;
        boolean[] mFragmentResumedFlags = new boolean[]{true, false, false, false};
        private final WxViewPager mViewPager;

        public TabsAdapter(FragmentActivity fragmentActivity, WxViewPager wxViewPager) {
            super(fragmentActivity.getSupportFragmentManager());
            AppMethodBeat.m2504i(29620);
            this.mViewPager = wxViewPager;
            this.mViewPager.setAdapter(this);
            this.mViewPager.setOnPageChangeListener(this);
            AppMethodBeat.m2505o(29620);
        }

        public int getCount() {
            return 4;
        }

        public Fragment getItem(int i) {
            AppMethodBeat.m2504i(29621);
            MMFragment Nn = MainTabUI.this.mo48632Nn(i);
            AppMethodBeat.m2505o(29621);
            return Nn;
        }

        public void onPageScrolled(final int i, float f, int i2) {
            AppMethodBeat.m2504i(29622);
            C44395w c = MainTabUI.this.ynE;
            if (c.ynT != null) {
                c.ynT.mo10914l(i, f);
            }
            if (MainTabUI.this.ynL != null) {
                MainTabUI.this.ynL.mo39215p(i, f);
            }
            if (0.0f != f) {
                if (this.addressFragment == null) {
                    this.addressFragment = (AddressUIFragment) MainTabUI.this.mo48632Nn(1);
                }
                this.addressFragment.mo27986qA(false);
            } else {
                C4990ab.m7419v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", Integer.valueOf(i), Integer.valueOf(MainTabUI.this.bts));
                if (-1 == MainTabUI.this.bts) {
                    MainTabUI.this.mo48645hc(MainTabUI.this.bts, MainTabUI.this.mbt);
                    MainTabUI.this.mo48630Nk(i);
                } else {
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(29619);
                            MainTabUI.this.mo48645hc(MainTabUI.this.bts, MainTabUI.this.mbt);
                            MainTabUI.this.mo48630Nk(i);
                            AppMethodBeat.m2505o(29619);
                        }
                    });
                }
            }
            fixAndroidOProgressBarOutScreenFlashProblem(i, f, i2);
            AppMethodBeat.m2505o(29622);
        }

        private void fixAndroidOProgressBarOutScreenFlashProblem(int i, float f, int i2) {
            AppMethodBeat.m2504i(29623);
            if (i2 == 0) {
                for (Integer num : MainTabUI.ynP.values()) {
                    if (num.intValue() != i) {
                        setFragmentLoadingIconVisibility(num.intValue(), 8);
                    } else if (!this.mFragmentResumedFlags[num.intValue()]) {
                        setFragmentLoadingIconVisibility(num.intValue(), 0);
                    }
                }
                AppMethodBeat.m2505o(29623);
                return;
            }
            for (Integer num2 : MainTabUI.ynP.values()) {
                if (!(num2.intValue() == i || this.mFragmentResumedFlags[num2.intValue()])) {
                    setFragmentLoadingIconVisibility(num2.intValue(), 0);
                }
            }
            AppMethodBeat.m2505o(29623);
        }

        private void setFragmentLoadingIconVisibility(int i, int i2) {
            AppMethodBeat.m2504i(29624);
            if (!(MainTabUI.this.mo48632Nn(i) == null || MainTabUI.this.mo48632Nn(i).getActivity() == null)) {
                View findViewById = MainTabUI.this.mo48632Nn(i).findViewById(2131823316);
                if (findViewById != null) {
                    findViewById.setVisibility(i2);
                }
            }
            AppMethodBeat.m2505o(29624);
        }

        public void onPageSelected(int i) {
            AppMethodBeat.m2504i(29625);
            C4990ab.m7411d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", Integer.valueOf(i));
            reportSwitch(i);
            MainTabUI.this.bts = MainTabUI.this.mbt;
            MainTabUI.this.mbt = i;
            MainTabUI.this.ynE.mo70265Np(i);
            MainTabUI.this.yhZ.supportInvalidateOptionsMenu();
            if (MainTabUI.this.bts == 1 && MainTabUI.this.mbt != 1) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(340226, Long.valueOf(System.currentTimeMillis()));
            }
            if (MainTabUI.this.mbt == 1) {
                long currentTimeMillis = System.currentTimeMillis();
                C9638aw.m17190ZK();
                if (currentTimeMillis - C42252ah.m74617d((Long) C18628c.m29072Ry().get(340226, null)) >= 180000) {
                    ((AddressUIFragment) MainTabUI.this.mo48632Nn(MainTabUI.this.mbt)).dHB();
                }
            }
            if (MainTabUI.this.mbt == 0) {
                C9638aw.getNotification().mo41575bv(true);
            } else {
                C9638aw.getNotification().mo41575bv(false);
            }
            if (MainTabUI.this.ynL != null) {
                MainTabUI.this.ynL.mo39213MU(MainTabUI.this.mbt);
            }
            AppMethodBeat.m2505o(29625);
        }

        private void reportSwitch(int i) {
            AppMethodBeat.m2504i(29626);
            C4990ab.m7419v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", Integer.valueOf(this.clickCount), Integer.valueOf(i));
            if (this.clickCount <= 0) {
                switch (i) {
                    case 0:
                        C7060h.pYm.mo8374X(10957, "5");
                        break;
                    case 1:
                        C7060h.pYm.mo8374X(10957, "6");
                        break;
                    case 2:
                        C7060h.pYm.mo8374X(10957, "7");
                        break;
                }
            }
            this.clickCount--;
            switch (i) {
                case 0:
                    C7060h.pYm.mo8374X(10957, "1");
                    break;
                case 1:
                    C7060h.pYm.mo8374X(10957, "2");
                    break;
                case 2:
                    C7060h.pYm.mo8374X(10957, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
                    break;
                case 3:
                    C7060h.pYm.mo8374X(10957, "4");
                    break;
            }
            this.isTabClicked = false;
            AppMethodBeat.m2505o(29626);
        }

        public void onPageScrollStateChanged(int i) {
            AppMethodBeat.m2504i(29627);
            C4990ab.m7411d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", Integer.valueOf(i));
            if (i == 0 && this.addressFragment != null) {
                this.addressFragment.mo27986qA(true);
                this.addressFragment = null;
            }
            if (MainTabUI.this.ynL != null) {
                MainTabUI.this.ynL.mo39214MV(i);
            }
            AppMethodBeat.m2505o(29627);
        }

        public void onTabClick(int i) {
            AppMethodBeat.m2504i(29628);
            if (!MainTabUI.this.ynN) {
                C4990ab.m7416i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
                AppMethodBeat.m2505o(29628);
            } else if (i == MainTabUI.this.mbt) {
                C4990ab.m7410d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
                MMFragment Nn = MainTabUI.this.mo48632Nn(i);
                if (Nn instanceof AbStractTabFragment) {
                    ((AbStractTabFragment) Nn).dwe();
                }
                AppMethodBeat.m2505o(29628);
            } else {
                this.isTabClicked = true;
                this.clickCount++;
                C4990ab.m7419v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", Integer.valueOf(this.clickCount));
                this.mViewPager.setCurrentItem(i, false);
                if (i == 3) {
                    int i2;
                    C16112c.m24429PK().mo28553bZ(262145, 266241);
                    C16112c.m24429PK().mo28553bZ(262156, 266241);
                    C16112c.m24429PK().mo28553bZ(262147, 266241);
                    C16112c.m24429PK().mo28553bZ(262149, 266241);
                    C16112c.m24429PK().mo28547b(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266241);
                    C16112c.m24429PK().mo28554c(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, C5127a.USERINFO_NEW_BANDAGE_WATCHER_ME_TAB_STRING_SYNC);
                    boolean bY = C16112c.m24429PK().mo28552bY(262156, 266241);
                    C7060h c7060h = C7060h.pYm;
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
                    c7060h.mo8381e(14872, objArr);
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_MY_ENTRY_TAB_REDDOT_BOOLEAN_SYNC, Boolean.FALSE);
                }
                AppMethodBeat.m2505o(29628);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.MainTabUI$1 */
    class C303401 extends C4884c<C18221ar> {
        C303401() {
            AppMethodBeat.m2504i(29615);
            this.xxI = C18221ar.class.getName().hashCode();
            AppMethodBeat.m2505o(29615);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29616);
            int i = ((C18221ar) c4883b).ctN.index;
            if (i < 0 || i > 3) {
                AppMethodBeat.m2505o(29616);
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
                AppMethodBeat.m2505o(29616);
            }
            return false;
        }
    }

    public MainTabUI() {
        AppMethodBeat.m2504i(29629);
        AppMethodBeat.m2505o(29629);
    }

    public final MMFragment dyx() {
        AppMethodBeat.m2504i(29630);
        MMFragment mMFragment = (MMFragment) this.ynQ.get(Integer.valueOf(this.mbt));
        AppMethodBeat.m2505o(29630);
        return mMFragment;
    }

    /* renamed from: Nj */
    public final void mo48629Nj(int i) {
        AppMethodBeat.m2504i(29631);
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        if (mainUI != null) {
            mainUI.mo39753Nj(i);
        }
        AppMethodBeat.m2505o(29631);
    }

    public final void dyy() {
        AppMethodBeat.m2504i(29632);
        C4879a.xxA.mo10053d(this.ynM);
        C4879a.xxA.mo10053d(this.ynO);
        dyz();
        AppMethodBeat.m2505o(29632);
    }

    private void dyz() {
        AppMethodBeat.m2504i(29633);
        this.ynQ.clear();
        if (this.yeo != null) {
            this.yeo.setCanSlide(false);
            this.yeo.setCanSlideBySide(false);
        }
        AppMethodBeat.m2505o(29633);
    }

    public final void dxr() {
        AppMethodBeat.m2504i(29634);
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        if (mainUI != null) {
            mainUI.dHz();
            mainUI.dIT();
        }
        AppMethodBeat.m2505o(29634);
    }

    public final void dyA() {
        AppMethodBeat.m2504i(29635);
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        if (mainUI != null) {
            mainUI.dIU();
        }
        AppMethodBeat.m2505o(29635);
    }

    /* renamed from: hc */
    public final void mo48645hc(int i, int i2) {
        AppMethodBeat.m2504i(29636);
        if (i == i2) {
            AppMethodBeat.m2505o(29636);
            return;
        }
        MMFragment Nn = mo48632Nn(i);
        if (Nn != null && (Nn instanceof C15912m)) {
            ((C15912m) Nn).dxd();
        }
        Nn = mo48632Nn(i2);
        if (Nn != null && (Nn instanceof C15912m)) {
            ((C15912m) Nn).dxc();
        }
        C15909j.m24224a(this.yhZ, 4, i, "deliverOnTabChange");
        C15909j.m24224a(this.yhZ, 3, i2, "deliverOnTabChange");
        AppMethodBeat.m2505o(29636);
    }

    /* renamed from: Nk */
    public final void mo48630Nk(int i) {
        AppMethodBeat.m2504i(29637);
        MMFragment Nn = mo48632Nn(i);
        if (Nn == null) {
            AppMethodBeat.m2505o(29637);
            return;
        }
        if (Nn instanceof C15912m) {
            ((C15912m) Nn).dwl();
        }
        this.ynI.mFragmentResumedFlags[i] = true;
        AppMethodBeat.m2505o(29637);
    }

    public final void dxn() {
        AppMethodBeat.m2504i(29638);
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        ViewGroup viewGroup = (ViewGroup) this.yhZ.findViewById(2131820633);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(4);
        }
        if (mainUI != null) {
            mainUI.onHiddenChanged(true);
        }
        C15909j.m24224a(this.yhZ, 4, this.mbt, "prepareStartChatting");
        dyA();
        this.ynE.dyC();
        AppMethodBeat.m2505o(29638);
    }

    public final void dyB() {
        AppMethodBeat.m2504i(29639);
        if (this.mbt == 0 && C1720g.m3535RO().eJo.foreground) {
            C9638aw.getNotification().mo41575bv(true);
        } else {
            C9638aw.getNotification().mo41575bv(false);
        }
        ViewGroup viewGroup = (ViewGroup) this.yhZ.findViewById(2131820633);
        if (viewGroup != null) {
            viewGroup.setImportantForAccessibility(1);
        }
        dxr();
        C15909j.m24224a(this.yhZ, 3, this.mbt, "prepareCloseChatting");
        MainUI mainUI = (MainUI) this.ynQ.get(Integer.valueOf(0));
        if (mainUI != null) {
            mainUI.getContentView();
            if (mainUI.mController != null) {
                mainUI.mController.onResume();
            }
            mainUI.onHiddenChanged(false);
        }
        AppMethodBeat.m2505o(29639);
    }

    static {
        AppMethodBeat.m2504i(29649);
        HashMap hashMap = new HashMap();
        ynP = hashMap;
        hashMap.put("tab_main", Integer.valueOf(0));
        ynP.put("tab_address", Integer.valueOf(1));
        ynP.put("tab_find_friend", Integer.valueOf(2));
        ynP.put("tab_settings", Integer.valueOf(3));
        AppMethodBeat.m2505o(29649);
    }

    public final void aqG(String str) {
        AppMethodBeat.m2504i(29640);
        if (str == null || str.equals("")) {
            AppMethodBeat.m2505o(29640);
            return;
        }
        mo48631Nm(((Integer) ynP.get(str)).intValue());
        AppMethodBeat.m2505o(29640);
    }

    /* renamed from: Nl */
    private MMFragment m48313Nl(int i) {
        AppMethodBeat.m2504i(29641);
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
                    C10984a c10984a = this.iVv;
                    mainUI.zve = c10984a;
                    if (mainUI.zuW != null) {
                        mainUI.zuW.setActionBarUpdateCallback(c10984a);
                    }
                }
                C9638aw.getNotification().mo41575bv(true);
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
        C4990ab.m7419v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", Integer.valueOf(i));
        if (mMFragment != null) {
            mMFragment.setParent(this.yhZ);
        }
        AppMethodBeat.m2505o(29641);
        return mMFragment;
    }

    /* renamed from: Nm */
    public final void mo48631Nm(int i) {
        AppMethodBeat.m2504i(29642);
        String str = "MicroMsg.LauncherUI.MainTabUI";
        String str2 = "change tab to %d, cur tab %d, has init tab %B, tab cache size %d";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(this.mbt);
        objArr[2] = Boolean.valueOf(this.yeo != null);
        objArr[3] = Integer.valueOf(this.ynQ.size());
        C4990ab.m7417i(str, str2, objArr);
        if (this.yeo == null || i < 0 || (this.ynI != null && i > this.ynI.getCount() - 1)) {
            AppMethodBeat.m2505o(29642);
        } else if (this.mbt != i || this.ynQ.size() == 0) {
            this.mbt = i;
            this.ynE.mo70265Np(this.mbt);
            if (this.yeo != null) {
                this.yeo.setCurrentItem(this.mbt, false);
                mo48630Nk(this.mbt);
            }
            if (this.mbt == 0 && C1720g.m3535RO().eJo.foreground) {
                C9638aw.getNotification().mo41575bv(true);
                AppMethodBeat.m2505o(29642);
                return;
            }
            C9638aw.getNotification().mo41575bv(false);
            AppMethodBeat.m2505o(29642);
        } else {
            AppMethodBeat.m2505o(29642);
        }
    }

    /* renamed from: Nn */
    public final MMFragment mo48632Nn(int i) {
        AppMethodBeat.m2504i(29643);
        C4990ab.m7411d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", Integer.valueOf(i));
        MMFragment mMFragment;
        if (i < 0) {
            AppMethodBeat.m2505o(29643);
            return null;
        } else if (this.ynQ.containsKey(Integer.valueOf(i))) {
            mMFragment = (MMFragment) this.ynQ.get(Integer.valueOf(i));
            AppMethodBeat.m2505o(29643);
            return mMFragment;
        } else {
            mMFragment = m48313Nl(i);
            this.ynQ.put(Integer.valueOf(i), mMFragment);
            AppMethodBeat.m2505o(29643);
            return mMFragment;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyC() {
        AppMethodBeat.m2504i(29644);
        this.ynE.dyC();
        AppMethodBeat.m2505o(29644);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyD() {
        AppMethodBeat.m2504i(29645);
        this.ynE.dyD();
        AppMethodBeat.m2505o(29645);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dyE() {
        AppMethodBeat.m2504i(29646);
        this.ynE.dyE();
        AppMethodBeat.m2505o(29646);
    }

    public final int dyF() {
        int e;
        AppMethodBeat.m2504i(29647);
        C44395w c44395w = this.ynE;
        long currentTimeMillis = System.currentTimeMillis();
        if (C9638aw.m17179RK()) {
            e = C32798u.m53584e(C1855t.fkP, C36036af.dzi());
            C4990ab.m7411d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", Integer.valueOf(e));
        } else {
            C4990ab.m7420w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
            e = 0;
        }
        c44395w.mo70264No(e);
        C4990ab.m7411d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(e));
        AppMethodBeat.m2505o(29647);
        return e;
    }

    public final void dyG() {
        AppMethodBeat.m2504i(29648);
        this.ynQ.get(Integer.valueOf(0));
        AppMethodBeat.m2505o(29648);
    }
}
