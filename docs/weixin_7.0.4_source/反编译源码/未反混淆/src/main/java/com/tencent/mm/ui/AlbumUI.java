package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.l;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.sns.b.b;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.CustomViewPager;
import java.util.HashMap;

@i
public class AlbumUI extends MMActivity {
    private DoubleTabView yen = null;
    private CustomViewPager yeo = null;
    private HashMap<Integer, MMFragment> yep = new HashMap();
    private boolean yeq = false;

    class a extends l {
        public a(android.support.v4.app.i iVar) {
            super(iVar);
        }

        public final Fragment getItem(int i) {
            AppMethodBeat.i(29108);
            MMFragment a = AlbumUI.a(AlbumUI.this, i);
            AppMethodBeat.o(29108);
            return a;
        }

        public final int getCount() {
            return 2;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public AlbumUI() {
        AppMethodBeat.i(29109);
        AppMethodBeat.o(29109);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dealContentView(View view) {
        AppMethodBeat.i(29110);
        super.dealContentView(view);
        this.yeq = getIntent().getBooleanExtra("story_dot", false);
        this.yen = (DoubleTabView) findViewById(R.id.d8l);
        this.yeo = (CustomViewPager) findViewById(R.id.d8m);
        this.yen.setFirstTabString(getResources().getString(R.string.f8));
        this.yen.setSecondTabString(getResources().getString(R.string.f9));
        if (this.yeq) {
            this.yen.pC(true);
        }
        this.yen.setOnTabClickListener(new com.tencent.mm.ui.DoubleTabView.a() {
            public final void onTabClick(int i) {
                AppMethodBeat.i(29105);
                AlbumUI.this.yeo.setCurrentItem(i, true);
                AppMethodBeat.o(29105);
            }
        });
        this.yeo.setOnPageChangeListener(new OnPageChangeListener() {
            public final void onPageScrolled(int i, float f, int i2) {
                AppMethodBeat.i(29106);
                AlbumUI.this.yen.l(i, f);
                AppMethodBeat.o(29106);
            }

            public final void onPageSelected(int i) {
                h hVar;
                AppMethodBeat.i(29107);
                AlbumUI.this.yen.setTo(i);
                if (i == 0) {
                    hVar = h.scu;
                    h.cAw().cZI = 3;
                } else {
                    hVar = h.scu;
                    h.cAw().cZI = 2;
                    if (AlbumUI.this.yeq) {
                        AlbumUI.this.yen.pC(false);
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
                    }
                }
                hVar = h.scu;
                h.cAx();
                AppMethodBeat.o(29107);
            }

            public final void onPageScrollStateChanged(int i) {
            }
        });
        this.yeo.setAdapter(new a(getSupportFragmentManager()));
        h hVar = h.scu;
        h.cAw().cZI = 3;
        hVar = h.scu;
        h.cAx();
        AppMethodBeat.o(29110);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return R.layout.ad3;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(138619);
        this.yll = true;
        super.onCreate(bundle);
        AppMethodBeat.o(138619);
    }

    static /* synthetic */ MMFragment a(AlbumUI albumUI, int i) {
        MMFragment mMFragment = null;
        AppMethodBeat.i(29111);
        ab.d("MicroMsg.AlbumUI", "get tab %d", Integer.valueOf(i));
        if (i < 0) {
            AppMethodBeat.o(29111);
            return null;
        } else if (albumUI.yep.containsKey(Integer.valueOf(i))) {
            mMFragment = (MMFragment) albumUI.yep.get(Integer.valueOf(i));
            AppMethodBeat.o(29111);
            return mMFragment;
        } else {
            Bundle bundle = new Bundle();
            switch (i) {
                case 0:
                    mMFragment = ((b) g.M(b.class)).instantiateAlbumFragment(albumUI, bundle);
                    break;
                case 1:
                    mMFragment = ((e) g.M(e.class)).getStoryUIFactory().instantiateAlbumFragment(albumUI, bundle);
                    break;
            }
            ab.v("MicroMsg.AlbumUI", "createFragment index:%d", Integer.valueOf(i));
            if (mMFragment != null) {
                mMFragment.setParent(albumUI);
            }
            albumUI.yep.put(Integer.valueOf(i), mMFragment);
            AppMethodBeat.o(29111);
            return mMFragment;
        }
    }
}
