package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.p;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMDotView;
import java.util.LinkedList;

public class GameBannerView extends LinearLayout implements OnPageChangeListener, OnClickListener {
    private MMDotView jiG;
    private Context mContext;
    private int mXC = 0;
    private b neD;
    LinkedList<a> neE;
    ap neF = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            AppMethodBeat.i(111718);
            if (GameBannerView.this.sq == null || GameBannerView.this.neE.size() <= 1) {
                GameBannerView.this.neF.stopTimer();
                AppMethodBeat.o(111718);
                return false;
            }
            GameBannerView.this.sq.setCurrentItem(GameBannerView.this.sq.getCurrentItem() + 1, true);
            AppMethodBeat.o(111718);
            return true;
        }
    }, true);
    private float neG = 0.0f;
    private float neH = 0.0f;
    private ViewPager sq;

    public static class a {
        public String fqw;
        public int index;
        public String mVm;
        public f neJ;
    }

    final class b extends p {
        private b() {
        }

        /* synthetic */ b(GameBannerView gameBannerView, byte b) {
            this();
        }

        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            AppMethodBeat.i(111719);
            int size = i % GameBannerView.this.neE.size();
            viewGroup.removeView((View) obj);
            ab.i("MicroMsg.GameBannerView", "destroyItem : new positon = %d, now position = %d", Integer.valueOf(size), Integer.valueOf(i));
            AppMethodBeat.o(111719);
        }

        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(111720);
            int size = i % GameBannerView.this.neE.size();
            View inflate = View.inflate(GameBannerView.this.mContext, R.layout.a2_, null);
            inflate.setTag(GameBannerView.this.neE.get(size));
            inflate.setOnClickListener(GameBannerView.this);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.c0c);
            String str = ((a) GameBannerView.this.neE.get(size)).fqw;
            Drawable drawable = imageView.getDrawable();
            if (drawable == null || !(drawable instanceof j)) {
                imageView.setImageDrawable(new j(str, (byte) 0));
            } else {
                ((j) drawable).setUrl(str);
            }
            try {
                viewGroup.addView(inflate, 0);
            } catch (Exception e) {
                ab.e("MicroMsg.GameBannerView", "add view failed, " + e.getMessage());
            }
            ab.i("MicroMsg.GameBannerView", "instantiateItem : new positon = %d, now position = %d", Integer.valueOf(size), Integer.valueOf(i));
            AppMethodBeat.o(111720);
            return inflate;
        }

        public final int getCount() {
            AppMethodBeat.i(111721);
            int size;
            if (GameBannerView.this.neE.size() <= 1) {
                size = GameBannerView.this.neE.size();
                AppMethodBeat.o(111721);
                return size;
            }
            size = (GameBannerView.this.neE.size() * 1000) * 2;
            AppMethodBeat.o(111721);
            return size;
        }

        public final boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public GameBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(111722);
        this.mContext = context;
        inflate(context, R.layout.a29, this);
        this.neE = new LinkedList();
        AppMethodBeat.o(111722);
    }

    public void setSourceScene(int i) {
        this.mXC = i;
    }

    /* Access modifiers changed, original: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(111723);
        super.onFinishInflate();
        this.jiG = (MMDotView) findViewById(R.id.c0b);
        this.sq = (ViewPager) findViewById(R.id.c0a);
        this.sq.setOnPageChangeListener(this);
        this.neD = new b(this, (byte) 0);
        AppMethodBeat.o(111723);
    }

    public void setBannerList(LinkedList<a> linkedList) {
        AppMethodBeat.i(111724);
        if (linkedList == null || linkedList.size() == 0) {
            ab.e("MicroMsg.GameBannerView", "Empty banner list");
            setVisibility(8);
            AppMethodBeat.o(111724);
            return;
        }
        ab.i("MicroMsg.GameBannerView", "bannerList size", Integer.valueOf(linkedList.size()));
        this.neF.stopTimer();
        this.neE.clear();
        this.neE.addAll(linkedList);
        this.sq.setAdapter(this.neD);
        this.sq.setCurrentItem(linkedList.size() * 1000, false);
        if (this.neE.size() > 1) {
            this.neF.ae(5000, 5000);
        }
        this.jiG.setVisibility(8);
        setVisibility(0);
        AppMethodBeat.o(111724);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        AppMethodBeat.i(111725);
        int size = i % this.neE.size();
        ab.i("MicroMsg.GameBannerView", "now selected page %d, now exactly positon : %d", Integer.valueOf(i), Integer.valueOf(size));
        if (((a) this.neE.get(size)).neJ != null && g.RK()) {
            com.tencent.mm.plugin.game.e.b.a(this.mContext, 11, 1101, size + 1, 1, this.mXC, null);
        }
        AppMethodBeat.o(111725);
    }

    private void hR(boolean z) {
        AppMethodBeat.i(111727);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(111727);
    }

    public void onClick(View view) {
        AppMethodBeat.i(111728);
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            f fVar = aVar.neJ;
            if (bo.isNullOrNil(aVar.mVm)) {
                ab.i("MicroMsg.GameBannerView", "null or nil url");
                Bundle bundle = new Bundle();
                bundle.putCharSequence("game_app_id", fVar.field_appId);
                bundle.putInt("game_report_from_scene", 5);
                com.tencent.mm.plugin.game.e.b.a(this.mContext, 11, 1101, 1, c.b(this.mContext, fVar.field_appId, null, bundle), this.mXC, null);
                AppMethodBeat.o(111728);
                return;
            }
            com.tencent.mm.plugin.game.e.b.a(this.mContext, 11, 1101, 1, c.ax(this.mContext, aVar.mVm), this.mXC, null);
            AppMethodBeat.o(111728);
            return;
        }
        AppMethodBeat.o(111728);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(111726);
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
                hR(false);
                this.neG = 0.0f;
                this.neH = 0.0f;
                break;
            case 2:
                if (Math.abs((int) (rawX - this.neG)) > Math.abs((int) (rawY - this.neH))) {
                    hR(true);
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
                this.neF.ae(5000, 5000);
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(111726);
        return onInterceptTouchEvent;
    }
}
