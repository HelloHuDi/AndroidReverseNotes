package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.l;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.emoji.ui.EmojiMineUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.x.c;
import java.util.HashMap;

@i
public class EmojiStoreV2UI extends MMActivity {
    private int lfO = 0;
    private HashMap<Integer, EmojiStoreV2BaseFragment> lfZ = new HashMap();
    EmojiStoreV2TabView lga;
    private EmojiStoreV2ViewPager lgb;
    private a lgc;
    private boolean lgd = true;
    private boolean lge = false;
    private int lgf = -1;

    class a extends l implements OnPageChangeListener, com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2TabView.a {
        private boolean lgd = false;
        private WxViewPager lgh;

        public final /* synthetic */ Fragment getItem(int i) {
            AppMethodBeat.i(53826);
            EmojiStoreV2BaseFragment un = un(i);
            AppMethodBeat.o(53826);
            return un;
        }

        public a(FragmentActivity fragmentActivity, WxViewPager wxViewPager, boolean z) {
            super(fragmentActivity.getSupportFragmentManager());
            AppMethodBeat.i(53820);
            this.lgd = z;
            this.lgh = wxViewPager;
            this.lgh.setAdapter(this);
            this.lgh.setOnPageChangeListener(this);
            this.lgh.setCurrentItem(EmojiStoreV2UI.this.lfO);
            d.fP(11);
            if (EmojiStoreV2UI.this.lga != null) {
                EmojiStoreV2UI.this.lga.setOnTabClickListener(this);
            }
            AppMethodBeat.o(53820);
        }

        public final EmojiStoreV2BaseFragment un(int i) {
            AppMethodBeat.i(53821);
            EmojiStoreV2BaseFragment um = EmojiStoreV2UI.this.um(i);
            AppMethodBeat.o(53821);
            return um;
        }

        public final int getCount() {
            if (this.lgd) {
                return 2;
            }
            return 1;
        }

        public final void onPageScrolled(int i, float f, int i2) {
            AppMethodBeat.i(53822);
            if (EmojiStoreV2UI.this.lga != null) {
                EmojiStoreV2UI.this.lga.l(i, f);
            }
            AppMethodBeat.o(53822);
        }

        public final void onPageSelected(int i) {
            AppMethodBeat.i(53823);
            ab.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageSelected :%d", Integer.valueOf(i));
            EmojiStoreV2UI.this.lfO = i;
            if (EmojiStoreV2UI.this.lga != null) {
                EmojiStoreV2UI.this.lga.setTo(i);
            }
            if (EmojiStoreV2UI.this.lfO == 1 && !EmojiStoreV2UI.this.lge) {
                h.pYm.e(12090, new Object[0]);
                EmojiStoreV2UI emojiStoreV2UI = EmojiStoreV2UI.this;
                g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.FALSE);
                if (emojiStoreV2UI.lga != null) {
                    emojiStoreV2UI.lga.gz(false);
                }
                EmojiStoreV2UI.this.lge = true;
            }
            AppMethodBeat.o(53823);
        }

        public final void onPageScrollStateChanged(int i) {
            AppMethodBeat.i(53824);
            ab.d("MicroMsg.emoji.EmojiStoreV2UI", "onPageScrollStateChanged state:%d", Integer.valueOf(i));
            if (i == 0 && EmojiStoreV2UI.this.um(EmojiStoreV2UI.this.lfO) != null) {
                EmojiStoreV2BaseFragment um = EmojiStoreV2UI.this.um(EmojiStoreV2UI.this.lfO);
                if (!(um.mListView == null || um.kVA == null || !um.bmd())) {
                    um.kVA.refreshView();
                }
            }
            AppMethodBeat.o(53824);
        }

        public final void onTabClick(int i) {
            AppMethodBeat.i(53825);
            if (i != EmojiStoreV2UI.this.lfO) {
                this.lgh.setCurrentItem(i, false);
            }
            EmojiStoreV2UI.this.lfO = i;
            AppMethodBeat.o(53825);
        }
    }

    static final class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(53827);
            c.PK().x(262147, false);
            c.PK().x(262149, false);
            c.PK().bZ(262147, 266244);
            c.PK().bZ(262149, 266244);
            g.RP().Ry().set(208899, Boolean.FALSE);
            g.RP().Ry().set(208913, Boolean.FALSE);
            AppMethodBeat.o(53827);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public EmojiStoreV2UI() {
        AppMethodBeat.i(53828);
        AppMethodBeat.o(53828);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(53829);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.lgf = getIntent().getIntExtra("download_entrance_scene", -1);
        String value = com.tencent.mm.m.g.Nu().getValue("ShowPersonalEmotion");
        ab.i("MicroMsg.emoji.EmojiStoreV2UI", "get dynamic config value:%s", value);
        if (bo.isNullOrNil(value) || bo.ank(value) != 1) {
            this.lgd = false;
        } else {
            this.lgd = true;
        }
        if (this.lgd) {
            this.lfO = getIntent().getIntExtra("emoji_tab", 0);
        }
        initView();
        g.RS().aa(new b());
        boolean booleanValue = ((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.FALSE)).booleanValue();
        if (this.lga != null) {
            this.lga.gz(booleanValue);
        }
        h.pYm.a(406, 0, 1, false);
        h.pYm.a(406, 2, System.currentTimeMillis() - currentTimeMillis, false);
        AppMethodBeat.o(53829);
    }

    public void onResume() {
        AppMethodBeat.i(53830);
        super.onResume();
        Looper.myQueue().addIdleHandler(new IdleHandler() {
            public final boolean queueIdle() {
                AppMethodBeat.i(53819);
                ab.i("MicroMsg.emoji.EmojiStoreV2UI", "now try to activity the tools process");
                com.tencent.mm.cj.c.aNX();
                AppMethodBeat.o(53819);
                return false;
            }
        });
        AppMethodBeat.o(53830);
    }

    public final int getLayoutId() {
        return R.layout.v4;
    }

    public final void initView() {
        AppMethodBeat.i(53831);
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_search, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53816);
                EmojiStoreV2UI.a(EmojiStoreV2UI.this);
                AppMethodBeat.o(53816);
                return false;
            }
        });
        addIconOptionMenu(1, R.raw.actionbar_setting_icon, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(53817);
                Intent intent = new Intent();
                intent.putExtra("10931", 1);
                intent.setClass(EmojiStoreV2UI.this, EmojiMineUI.class);
                EmojiStoreV2UI.this.startActivity(intent);
                AppMethodBeat.o(53817);
                return false;
            }
        });
        this.lga = (EmojiStoreV2TabView) findViewById(R.id.bhg);
        this.lgb = (EmojiStoreV2ViewPager) findViewById(R.id.bhh);
        this.lgb.setOffscreenPageLimit(0);
        this.lgc = new a(this, this.lgb, this.lgd);
        if (this.lgd) {
            this.lga.setVisibility(0);
            this.lga.bms();
            AppMethodBeat.o(53831);
            return;
        }
        this.lga.setVisibility(8);
        AppMethodBeat.o(53831);
    }

    public void onDestroy() {
        AppMethodBeat.i(53832);
        super.onDestroy();
        if (this.lfZ != null) {
            this.lfZ.clear();
        }
        if (this.lga != null) {
            com.tencent.mm.sdk.b.a.xxA.d(this.lga.lfW);
        }
        AppMethodBeat.o(53832);
    }

    public final EmojiStoreV2BaseFragment um(int i) {
        EmojiStoreV2BaseFragment emojiStoreV2BaseFragment = null;
        AppMethodBeat.i(53833);
        if (i < 0) {
            AppMethodBeat.o(53833);
            return null;
        } else if (this.lfZ.containsKey(Integer.valueOf(i))) {
            emojiStoreV2BaseFragment = (EmojiStoreV2BaseFragment) this.lfZ.get(Integer.valueOf(i));
            AppMethodBeat.o(53833);
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
                    ab.w("MicroMsg.emoji.EmojiStoreV2UI", "create fragment failed.");
                    break;
            }
            ab.d("MicroMsg.emoji.EmojiStoreV2UI", "create fragment index:%d", Integer.valueOf(i));
            if (emojiStoreV2BaseFragment != null) {
                emojiStoreV2BaseFragment.setParent(this);
            }
            this.lfZ.put(Integer.valueOf(i), emojiStoreV2BaseFragment);
            AppMethodBeat.o(53833);
            return emojiStoreV2BaseFragment;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(53834);
        super.onActivityResult(i, i2, intent);
        ab.d("MicroMsg.emoji.EmojiStoreV2UI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        if (!(this.lgc == null || this.lgc.un(this.lfO) == null)) {
            this.lgc.un(this.lfO).onActivityResult(i, i2, intent);
        }
        AppMethodBeat.o(53834);
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(EmojiStoreV2UI emojiStoreV2UI) {
        AppMethodBeat.i(53835);
        ((m) g.K(m.class)).a(ah.getContext(), new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.i(53818);
                Intent cVd = aa.cVd();
                aa.a(cVd, EmojiStoreV2UI.this.lgf == 17 ? 50 : 24);
                cVd.putExtra("ftsneedkeyboard", true);
                cVd.putExtra("key_load_js_without_delay", true);
                cVd.putExtra("ftsInitToSearch", true);
                com.tencent.mm.bp.d.b(EmojiStoreV2UI.this.mController.ylL, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", cVd);
                if (EmojiStoreV2UI.this.lfO == 0) {
                    i = 0;
                } else {
                    i = 1;
                }
                h.pYm.e(13054, Integer.valueOf(i), Integer.valueOf(0), "");
                AppMethodBeat.o(53818);
            }
        });
        AppMethodBeat.o(53835);
    }
}
