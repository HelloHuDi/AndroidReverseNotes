package com.tencent.p177mm.plugin.emoji.p384ui.p385v2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.p057v4.app.C31857l;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.app.FragmentActivity;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.mogic.WxViewPager;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiMineUI;
import com.tencent.p177mm.plugin.emoji.p384ui.p385v2.EmojiStoreV2TabView.C33985a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;

@C18524i
/* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI */
public class EmojiStoreV2UI extends MMActivity {
    private int lfO = 0;
    private HashMap<Integer, EmojiStoreV2BaseFragment> lfZ = new HashMap();
    EmojiStoreV2TabView lga;
    private EmojiStoreV2ViewPager lgb;
    private C36762a lgc;
    private boolean lgd = true;
    private boolean lge = false;
    private int lgf = -1;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI$2 */
    class C115992 implements OnMenuItemClickListener {
        C115992() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53817);
            Intent intent = new Intent();
            intent.putExtra("10931", 1);
            intent.setClass(EmojiStoreV2UI.this, EmojiMineUI.class);
            EmojiStoreV2UI.this.startActivity(intent);
            AppMethodBeat.m2505o(53817);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI$4 */
    class C116004 implements IdleHandler {
        C116004() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(53819);
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
            C45287c.aNX();
            AppMethodBeat.m2505o(53819);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI$3 */
    class C277873 implements Runnable {
        C277873() {
        }

        public final void run() {
            int i;
            AppMethodBeat.m2504i(53818);
            Intent cVd = C46400aa.cVd();
            C46400aa.m87325a(cVd, EmojiStoreV2UI.this.lgf == 17 ? 50 : 24);
            cVd.putExtra("ftsneedkeyboard", true);
            cVd.putExtra("key_load_js_without_delay", true);
            cVd.putExtra("ftsInitToSearch", true);
            C25985d.m41467b(EmojiStoreV2UI.this.mController.ylL, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", cVd);
            if (EmojiStoreV2UI.this.lfO == 0) {
                i = 0;
            } else {
                i = 1;
            }
            C7060h.pYm.mo8381e(13054, Integer.valueOf(i), Integer.valueOf(0), "");
            AppMethodBeat.m2505o(53818);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI$a */
    class C36762a extends C31857l implements OnPageChangeListener, C33985a {
        private boolean lgd = false;
        private WxViewPager lgh;

        public final /* synthetic */ Fragment getItem(int i) {
            AppMethodBeat.m2504i(53826);
            EmojiStoreV2BaseFragment un = mo58603un(i);
            AppMethodBeat.m2505o(53826);
            return un;
        }

        public C36762a(FragmentActivity fragmentActivity, WxViewPager wxViewPager, boolean z) {
            super(fragmentActivity.getSupportFragmentManager());
            AppMethodBeat.m2504i(53820);
            this.lgd = z;
            this.lgh = wxViewPager;
            this.lgh.setAdapter(this);
            this.lgh.setOnPageChangeListener(this);
            this.lgh.setCurrentItem(EmojiStoreV2UI.this.lfO);
            C1443d.m3067fP(11);
            if (EmojiStoreV2UI.this.lga != null) {
                EmojiStoreV2UI.this.lga.setOnTabClickListener(this);
            }
            AppMethodBeat.m2505o(53820);
        }

        /* renamed from: un */
        public final EmojiStoreV2BaseFragment mo58603un(int i) {
            AppMethodBeat.m2504i(53821);
            EmojiStoreV2BaseFragment um = EmojiStoreV2UI.this.mo61778um(i);
            AppMethodBeat.m2505o(53821);
            return um;
        }

        public final int getCount() {
            if (this.lgd) {
                return 2;
            }
            return 1;
        }

        public final void onPageScrolled(int i, float f, int i2) {
            AppMethodBeat.m2504i(53822);
            if (EmojiStoreV2UI.this.lga != null) {
                EmojiStoreV2UI.this.lga.mo68497l(i, f);
            }
            AppMethodBeat.m2505o(53822);
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.m2504i(53823);
            C4990ab.m7411d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", Integer.valueOf(i));
            EmojiStoreV2UI.this.lfO = i;
            if (EmojiStoreV2UI.this.lga != null) {
                EmojiStoreV2UI.this.lga.setTo(i);
            }
            if (EmojiStoreV2UI.this.lfO == 1 && !EmojiStoreV2UI.this.lge) {
                C7060h.pYm.mo8381e(12090, new Object[0]);
                EmojiStoreV2UI emojiStoreV2UI = EmojiStoreV2UI.this;
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.FALSE);
                if (emojiStoreV2UI.lga != null) {
                    emojiStoreV2UI.lga.mo68496gz(false);
                }
                EmojiStoreV2UI.this.lge = true;
            }
            AppMethodBeat.m2505o(53823);
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.m2504i(53824);
            C4990ab.m7411d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", Integer.valueOf(i));
            if (i == 0 && EmojiStoreV2UI.this.mo61778um(EmojiStoreV2UI.this.lfO) != null) {
                EmojiStoreV2BaseFragment um = EmojiStoreV2UI.this.mo61778um(EmojiStoreV2UI.this.lfO);
                if (!(um.mListView == null || um.kVA == null || !um.bmd())) {
                    um.kVA.refreshView();
                }
            }
            AppMethodBeat.m2505o(53824);
        }

        public final void onTabClick(int i) {
            AppMethodBeat.m2504i(53825);
            if (i != EmojiStoreV2UI.this.lfO) {
                this.lgh.setCurrentItem(i, false);
            }
            EmojiStoreV2UI.this.lfO = i;
            AppMethodBeat.m2505o(53825);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI$b */
    static final class C38901b implements Runnable {
        private C38901b() {
        }

        /* synthetic */ C38901b(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(53827);
            C16112c.m24429PK().mo28556x(262147, false);
            C16112c.m24429PK().mo28556x(262149, false);
            C16112c.m24429PK().mo28553bZ(262147, 266244);
            C16112c.m24429PK().mo28553bZ(262149, 266244);
            C1720g.m3536RP().mo5239Ry().set(208899, Boolean.FALSE);
            C1720g.m3536RP().mo5239Ry().set(208913, Boolean.FALSE);
            AppMethodBeat.m2505o(53827);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2UI$1 */
    class C389021 implements OnMenuItemClickListener {
        C389021() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(53816);
            EmojiStoreV2UI.m66024a(EmojiStoreV2UI.this);
            AppMethodBeat.m2505o(53816);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public EmojiStoreV2UI() {
        AppMethodBeat.m2504i(53828);
        AppMethodBeat.m2505o(53828);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(53829);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.lgf = getIntent().getIntExtra("download_entrance_scene", -1);
        String value = C26373g.m41964Nu().getValue("ShowPersonalEmotion");
        C4990ab.m7417i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", value);
        if (C5046bo.isNullOrNil(value) || C5046bo.ank(value) != 1) {
            this.lgd = false;
        } else {
            this.lgd = true;
        }
        if (this.lgd) {
            this.lfO = getIntent().getIntExtra("emoji_tab", 0);
        }
        initView();
        C1720g.m3539RS().mo10302aa(new C38901b());
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.FALSE)).booleanValue();
        if (this.lga != null) {
            this.lga.mo68496gz(booleanValue);
        }
        C7060h.pYm.mo8378a(406, 0, 1, false);
        C7060h.pYm.mo8378a(406, 2, System.currentTimeMillis() - currentTimeMillis, false);
        AppMethodBeat.m2505o(53829);
    }

    public void onResume() {
        AppMethodBeat.m2504i(53830);
        super.onResume();
        Looper.myQueue().addIdleHandler(new C116004());
        AppMethodBeat.m2505o(53830);
    }

    public final int getLayoutId() {
        return 2130969385;
    }

    public final void initView() {
        AppMethodBeat.m2504i(53831);
        addIconOptionMenu(0, C1318a.actionbar_icon_dark_search, new C389021());
        addIconOptionMenu(1, C1318a.actionbar_setting_icon, new C115992());
        this.lga = (EmojiStoreV2TabView) findViewById(2131823595);
        this.lgb = (EmojiStoreV2ViewPager) findViewById(2131823596);
        this.lgb.setOffscreenPageLimit(0);
        this.lgc = new C36762a(this, this.lgb, this.lgd);
        if (this.lgd) {
            this.lga.setVisibility(0);
            this.lga.bms();
            AppMethodBeat.m2505o(53831);
            return;
        }
        this.lga.setVisibility(8);
        AppMethodBeat.m2505o(53831);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(53832);
        super.onDestroy();
        if (this.lfZ != null) {
            this.lfZ.clear();
        }
        if (this.lga != null) {
            C4879a.xxA.mo10053d(this.lga.lfW);
        }
        AppMethodBeat.m2505o(53832);
    }

    /* renamed from: um */
    public final EmojiStoreV2BaseFragment mo61778um(int i) {
        EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = null;
        AppMethodBeat.m2504i(53833);
        if (i < 0) {
            AppMethodBeat.m2505o(53833);
            return null;
        } else if (this.lfZ.containsKey(Integer.valueOf(i))) {
            emojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment) this.lfZ.get(Integer.valueOf(i));
            AppMethodBeat.m2505o(53833);
            return emojiStoreV2BaseFragment;
        } else {
            switch (i) {
                case 0:
                    emojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment) Fragment.instantiate(this, EmojiStoreV2MainFragment.class.getName(), null);
                    break;
                case 1:
                    emojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment) Fragment.instantiate(this, EmojiStoreV2PersonFragment.class.getName(), null);
                    break;
                default:
                    C4990ab.m7420w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
                    break;
            }
            C4990ab.m7411d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", Integer.valueOf(i));
            if (emojiStoreV2BaseFragment != null) {
                emojiStoreV2BaseFragment.setParent(this);
            }
            this.lfZ.put(Integer.valueOf(i), emojiStoreV2BaseFragment);
            AppMethodBeat.m2505o(53833);
            return emojiStoreV2BaseFragment;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(53834);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7410d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (!(this.lgc == null || this.lgc.mo58603un(this.lfO) == null)) {
            this.lgc.mo58603un(this.lfO).onActivityResult(i, i2, intent);
        }
        AppMethodBeat.m2505o(53834);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: a */
    static /* synthetic */ void m66024a(EmojiStoreV2UI emojiStoreV2UI) {
        AppMethodBeat.m2504i(53835);
        ((C40193m) C1720g.m3528K(C40193m.class)).mo63531a(C4996ah.getContext(), new C277873());
        AppMethodBeat.m2505o(53835);
    }
}
