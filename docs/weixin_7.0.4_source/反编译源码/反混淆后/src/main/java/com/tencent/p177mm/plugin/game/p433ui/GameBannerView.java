package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.p057v4.view.C25365p;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.MMDotView;
import com.tencent.p177mm.plugin.game.p1485e.C34277b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.GameBannerView */
public class GameBannerView extends LinearLayout implements OnPageChangeListener, OnClickListener {
    private MMDotView jiG;
    private Context mContext;
    private int mXC = 0;
    private C21007b neD;
    LinkedList<C12176a> neE;
    C7564ap neF = new C7564ap(new C431931(), true);
    private float neG = 0.0f;
    private float neH = 0.0f;
    /* renamed from: sq */
    private ViewPager f17200sq;

    /* renamed from: com.tencent.mm.plugin.game.ui.GameBannerView$a */
    public static class C12176a {
        public String fqw;
        public int index;
        public String mVm;
        public C40439f neJ;
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameBannerView$b */
    final class C21007b extends C25365p {
        private C21007b() {
        }

        /* synthetic */ C21007b(GameBannerView gameBannerView, byte b) {
            this();
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.m2504i(111719);
            int size = i % GameBannerView.this.neE.size();
            viewGroup.removeView((View) obj);
            C4990ab.m7417i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", Integer.valueOf(size), Integer.valueOf(i));
            AppMethodBeat.m2505o(111719);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(111720);
            int size = i % GameBannerView.this.neE.size();
            View inflate = View.inflate(GameBannerView.this.mContext, 2130969652, null);
            inflate.setTag(GameBannerView.this.neE.get(size));
            inflate.setOnClickListener(GameBannerView.this);
            ImageView imageView = (ImageView) inflate.findViewById(2131824294);
            String str = ((C12176a) GameBannerView.this.neE.get(size)).fqw;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof C21027j)) {
                imageView.setImageDrawable(new C21027j(str, (byte) 0));
            } else {
                ((C21027j) drawable).setUrl(str);
            }
            try {
                viewGroup.addView(inflate, 0);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.GameBannerView", "add view failed, " + e.getMessage());
            }
            C4990ab.m7417i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", Integer.valueOf(size), Integer.valueOf(i));
            AppMethodBeat.m2505o(111720);
            return inflate;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(111721);
            int size;
            if (GameBannerView.this.neE.size() <= 1) {
                size = GameBannerView.this.neE.size();
                AppMethodBeat.m2505o(111721);
                return size;
            }
            size = (GameBannerView.this.neE.size() * 1000) * 2;
            AppMethodBeat.m2505o(111721);
            return size;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.ui.GameBannerView$1 */
    class C431931 implements C5015a {
        C431931() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(111718);
            if (GameBannerView.this.f17200sq == null || GameBannerView.this.neE.size() <= 1) {
                GameBannerView.this.neF.stopTimer();
                AppMethodBeat.m2505o(111718);
                return false;
            }
            GameBannerView.this.f17200sq.setCurrentItem(GameBannerView.this.f17200sq.getCurrentItem() + 1, true);
            AppMethodBeat.m2505o(111718);
            return true;
        }
    }

    public GameBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(111722);
        this.mContext = context;
        GameBannerView.inflate(context, 2130969651, this);
        this.neE = new LinkedList();
        AppMethodBeat.m2505o(111722);
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.m2504i(111723);
        super.onFinishInflate();
        this.jiG = (MMDotView) findViewById(2131824293);
        this.f17200sq = (ViewPager) findViewById(2131824292);
        this.f17200sq.setOnPageChangeListener(this);
        this.neD = new C21007b(this, (byte) 0);
        AppMethodBeat.m2505o(111723);
    }

    public void setBannerList(LinkedList<C12176a> linkedList) {
        AppMethodBeat.m2504i(111724);
        if (linkedList == null || linkedList.size() == 0) {
            C4990ab.m7412e("MicroMsg.GameBannerView", "Empty banner list");
            setVisibility(8);
            AppMethodBeat.m2505o(111724);
            return;
        }
        C4990ab.m7417i("MicroMsg.GameBannerView", "bannerList size", Integer.valueOf(linkedList.size()));
        this.neF.stopTimer();
        this.neE.clear();
        this.neE.addAll(linkedList);
        this.f17200sq.setAdapter(this.neD);
        this.f17200sq.setCurrentItem(linkedList.size() * 1000, false);
        if (this.neE.size() > 1) {
            this.neF.mo16770ae(5000, 5000);
        }
        this.jiG.setVisibility(8);
        setVisibility(0);
        AppMethodBeat.m2505o(111724);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        AppMethodBeat.m2504i(111725);
        int size = i % this.neE.size();
        C4990ab.m7417i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", Integer.valueOf(i), Integer.valueOf(size));
        if (((C12176a) this.neE.get(size)).neJ != null && C1720g.m3531RK()) {
            C34277b.m56209a(this.mContext, 11, 1101, size + 1, 1, this.mXC, null);
        }
        AppMethodBeat.m2505o(111725);
    }

    /* renamed from: hR */
    private void m76780hR(boolean z) {
        AppMethodBeat.m2504i(111727);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.m2505o(111727);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(111728);
        if (view.getTag() instanceof C12176a) {
            C12176a c12176a = (C12176a) view.getTag();
            C40439f c40439f = c12176a.neJ;
            if (C5046bo.isNullOrNil(c12176a.mVm)) {
                C4990ab.m7416i("MicroMsg.GameBannerView", "null or nil url");
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", c40439f.field_appId);
                bundle.putInt("game_report_from_scene", 5);
                C34277b.m56209a(this.mContext, 11, 1101, 1, C46001c.m85457b(this.mContext, c40439f.field_appId, null, bundle), this.mXC, null);
                AppMethodBeat.m2505o(111728);
                return;
            }
            C34277b.m56209a(this.mContext, 11, 1101, 1, C46001c.m85455ax(this.mContext, c12176a.mVm), this.mXC, null);
            AppMethodBeat.m2505o(111728);
            return;
        }
        AppMethodBeat.m2505o(111728);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(111726);
        int action = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action) {
            case 0:
                this.neG = rawX;
                this.neH = rawY;
                break;
            case 1:
            case 3:
                m76780hR(false);
                this.neG = 0.0f;
                this.neH = 0.0f;
                break;
            case 2:
                if (Math.abs((int) (rawX - this.neG)) > Math.abs((int) (rawY - this.neH))) {
                    m76780hR(true);
                    break;
                }
                break;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.neF.stopTimer();
                break;
            case 1:
            case 3:
                this.neF.mo16770ae(5000, 5000);
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(111726);
        return onInterceptTouchEvent;
    }
}
