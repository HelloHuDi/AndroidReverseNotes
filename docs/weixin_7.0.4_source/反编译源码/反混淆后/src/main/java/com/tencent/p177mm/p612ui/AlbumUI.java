package com.tencent.p177mm.p612ui;

import android.os.Bundle;
import android.support.p057v4.app.C0336i;
import android.support.p057v4.app.C31857l;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.p612ui.DoubleTabView.C23529a;
import com.tencent.p177mm.p612ui.base.CustomViewPager;
import com.tencent.p177mm.plugin.sns.p1024b.C29032b;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;

@C18524i
/* renamed from: com.tencent.mm.ui.AlbumUI */
public class AlbumUI extends MMActivity {
    private DoubleTabView yen = null;
    private CustomViewPager yeo = null;
    private HashMap<Integer, MMFragment> yep = new HashMap();
    private boolean yeq = false;

    /* renamed from: com.tencent.mm.ui.AlbumUI$2 */
    class C154522 implements OnPageChangeListener {
        C154522() {
        }

        public final void onPageScrolled(int i, float f, int i2) {
            AppMethodBeat.m2504i(29106);
            AlbumUI.this.yen.mo74815l(i, f);
            AppMethodBeat.m2505o(29106);
        }

        public final void onPageSelected(int i) {
            C22212h c22212h;
            AppMethodBeat.m2504i(29107);
            AlbumUI.this.yen.setTo(i);
            if (i == 0) {
                c22212h = C22212h.scu;
                C22212h.cAw().cZI = 3;
            } else {
                c22212h = C22212h.scu;
                C22212h.cAw().cZI = 2;
                if (AlbumUI.this.yeq) {
                    AlbumUI.this.yen.mo74817pC(false);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_STORY_NEED_DISPLAY_ALBUM_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
                }
            }
            c22212h = C22212h.scu;
            C22212h.cAx();
            AppMethodBeat.m2505o(29107);
        }

        public final void onPageScrollStateChanged(int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.AlbumUI$a */
    class C15453a extends C31857l {
        public C15453a(C0336i c0336i) {
            super(c0336i);
        }

        public final Fragment getItem(int i) {
            AppMethodBeat.m2504i(29108);
            MMFragment a = AlbumUI.m23765a(AlbumUI.this, i);
            AppMethodBeat.m2505o(29108);
            return a;
        }

        public final int getCount() {
            return 2;
        }
    }

    /* renamed from: com.tencent.mm.ui.AlbumUI$1 */
    class C154541 implements C23529a {
        C154541() {
        }

        public final void onTabClick(int i) {
            AppMethodBeat.m2504i(29105);
            AlbumUI.this.yeo.setCurrentItem(i, true);
            AppMethodBeat.m2505o(29105);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AlbumUI() {
        AppMethodBeat.m2504i(29109);
        AppMethodBeat.m2505o(29109);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dealContentView(View view) {
        AppMethodBeat.m2504i(29110);
        super.dealContentView(view);
        this.yeq = getIntent().getBooleanExtra("story_dot", false);
        this.yen = (DoubleTabView) findViewById(2131825967);
        this.yeo = (CustomViewPager) findViewById(2131825968);
        this.yen.setFirstTabString(getResources().getString(C25738R.string.f8795f8));
        this.yen.setSecondTabString(getResources().getString(C25738R.string.f8796f9));
        if (this.yeq) {
            this.yen.mo74817pC(true);
        }
        this.yen.setOnTabClickListener(new C154541());
        this.yeo.setOnPageChangeListener(new C154522());
        this.yeo.setAdapter(new C15453a(getSupportFragmentManager()));
        C22212h c22212h = C22212h.scu;
        C22212h.cAw().cZI = 3;
        c22212h = C22212h.scu;
        C22212h.cAx();
        AppMethodBeat.m2505o(29110);
    }

    /* Access modifiers changed, original: protected|final */
    public final int getLayoutId() {
        return 2130970089;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(138619);
        this.yll = true;
        super.onCreate(bundle);
        AppMethodBeat.m2505o(138619);
    }

    /* renamed from: a */
    static /* synthetic */ MMFragment m23765a(AlbumUI albumUI, int i) {
        MMFragment mMFragment = null;
        AppMethodBeat.m2504i(29111);
        C4990ab.m7411d("MicroMsg.AlbumUI", "get tab %d", Integer.valueOf(i));
        if (i < 0) {
            AppMethodBeat.m2505o(29111);
            return null;
        } else if (albumUI.yep.containsKey(Integer.valueOf(i))) {
            mMFragment = (MMFragment) albumUI.yep.get(Integer.valueOf(i));
            AppMethodBeat.m2505o(29111);
            return mMFragment;
        } else {
            Bundle bundle = new Bundle();
            switch (i) {
                case 0:
                    mMFragment = ((C29032b) C1720g.m3530M(C29032b.class)).instantiateAlbumFragment(albumUI, bundle);
                    break;
                case 1:
                    mMFragment = ((C35168e) C1720g.m3530M(C35168e.class)).getStoryUIFactory().instantiateAlbumFragment(albumUI, bundle);
                    break;
            }
            C4990ab.m7419v("MicroMsg.AlbumUI", "createFragment index:%d", Integer.valueOf(i));
            if (mMFragment != null) {
                mMFragment.setParent(albumUI);
            }
            albumUI.yep.put(Integer.valueOf(i), mMFragment);
            AppMethodBeat.m2505o(29111);
            return mMFragment;
        }
    }
}
