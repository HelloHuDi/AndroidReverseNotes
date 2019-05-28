package com.tencent.p177mm.p612ui.chatting.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.MMPullDownView;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5257e;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5258c;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5260d;
import com.tencent.p177mm.p612ui.base.MMPullDownView.C5262g;
import com.tencent.p177mm.p612ui.chatting.p617f.C40748d.C40749a;
import com.tencent.p177mm.p612ui.chatting.p622l.p623a.C17017a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.ui.chatting.view.MMChattingListView */
public class MMChattingListView extends MMPullDownView implements C5258c, C5260d, C5257e, C5262g {
    private ListView mListView;
    private C17017a yNt;
    private Bundle yZU;
    private BaseAdapter zaN;
    private Rect zaO = new Rect();
    private Paint zaP;
    private boolean zaQ = false;
    private int zaR;

    /* renamed from: com.tencent.mm.ui.chatting.view.MMChattingListView$3 */
    class C53683 extends AnimatorListenerAdapter {
        C53683() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(32763);
            super.onAnimationEnd(animator);
            MMChattingListView.this.zaO.setEmpty();
            AppMethodBeat.m2505o(32763);
        }
    }

    public MMChattingListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(32764);
        init(context);
        AppMethodBeat.m2505o(32764);
    }

    public MMChattingListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(32765);
        init(context);
        AppMethodBeat.m2505o(32765);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(32766);
        this.zaP = new Paint();
        this.zaP.setColor(WebView.NIGHT_MODE_COLOR);
        this.mListView = new ListView(context) {
            public final void onDrawForeground(Canvas canvas) {
                AppMethodBeat.m2504i(32761);
                super.onDrawForeground(canvas);
                if (!MMChattingListView.this.zaO.isEmpty()) {
                    Rect rect = new Rect();
                    MMChattingListView.this.mListView.getLocalVisibleRect(rect);
                    Rect rect2 = new Rect(rect);
                    Rect rect3 = new Rect(rect);
                    rect2.bottom = MMChattingListView.this.zaO.top;
                    rect3.top = MMChattingListView.this.zaO.bottom;
                    canvas.drawRect(rect2, MMChattingListView.this.zaP);
                    canvas.drawRect(rect3, MMChattingListView.this.zaP);
                    C4990ab.m7411d("MicroMsg.MMChattingListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s", rect, MMChattingListView.this.zaO);
                }
                AppMethodBeat.m2505o(32761);
            }
        };
        this.mListView.setBackgroundDrawable(null);
        this.mListView.setSelector(C25738R.drawable.f6882u_);
        this.mListView.setCacheColorHint(0);
        this.mListView.setDivider(null);
        this.mListView.setPadding(0, 0, 0, C1338a.fromDPToPix(context, 6));
        this.mListView.setClipToPadding(false);
        this.mListView.setScrollBarStyle(33554432);
        setOverScrollMode(2);
        addView(this.mListView, new LayoutParams(-1, -1));
        setCanOverScrool(false);
        mo10809qc(false);
        mo10810qd(false);
        setTopViewVisible(true);
        setOnBottomLoadDataListener(this);
        setOnTopLoadDataListener(this);
        setAtBottomCallBack(this);
        setAtTopCallBack(this);
        setIsBottomShowAll(true);
        setIsTopShowAll(false);
        setBottomViewVisible(true);
        AppMethodBeat.m2505o(32766);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        AppMethodBeat.m2504i(32767);
        this.zaN = baseAdapter;
        getListView().setAdapter(this.zaN);
        AppMethodBeat.m2505o(32767);
    }

    public void setLoadExecutor(C17017a c17017a) {
        this.yNt = c17017a;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public BaseAdapter getBaseAdapter() {
        return this.zaN;
    }

    public final boolean bhm() {
        AppMethodBeat.m2504i(32768);
        View childAt = getListView().getChildAt(getListView().getChildCount() - 1);
        if (childAt == null) {
            AppMethodBeat.m2505o(32768);
            return true;
        } else if (childAt.getBottom() > getListView().getHeight() - getListView().getPaddingBottom() || getListView().getLastVisiblePosition() != getListView().getAdapter().getCount() - 1) {
            AppMethodBeat.m2505o(32768);
            return false;
        } else {
            AppMethodBeat.m2505o(32768);
            return true;
        }
    }

    /* renamed from: a */
    public final void mo64351a(boolean z, Bundle bundle) {
        Object obj;
        AppMethodBeat.m2504i(32769);
        String str = "MicroMsg.MMChattingListView";
        StringBuilder append = new StringBuilder("[lockTopLoadDataForPosition] start:").append(z).append(" sourceArgs:");
        if (bundle == null) {
            obj = BuildConfig.COMMAND;
        } else {
            Bundle obj2 = bundle;
        }
        C4990ab.m7416i(str, append.append(obj2).toString());
        this.zaQ = z;
        this.yZU = bundle;
        super.mo10809qc(z);
        AppMethodBeat.m2505o(32769);
    }

    /* renamed from: qc */
    public final void mo10809qc(boolean z) {
        AppMethodBeat.m2504i(32770);
        C4990ab.m7416i("MicroMsg.MMChattingListView", "[forceTopLoadData] start:" + z + " isForceTopLoadDataForPosition:" + this.zaQ);
        if (this.zaQ) {
            AppMethodBeat.m2505o(32770);
            return;
        }
        super.mo10809qc(z);
        AppMethodBeat.m2505o(32770);
    }

    /* renamed from: aw */
    public final void mo64352aw(Bundle bundle) {
        AppMethodBeat.m2504i(32771);
        C4990ab.m7416i("MicroMsg.MMChattingListView", "[forceTopLoadData] sourceArgs:" + (bundle == null ? "" : bundle.toString()));
        this.yZU = bundle;
        super.mo10810qd(true);
        AppMethodBeat.m2505o(32771);
    }

    public final boolean bhl() {
        AppMethodBeat.m2504i(32772);
        View childAt = getListView().getChildAt(getListView().getFirstVisiblePosition());
        if (childAt == null || childAt.getTop() != 0) {
            AppMethodBeat.m2505o(32772);
            return false;
        }
        AppMethodBeat.m2505o(32772);
        return true;
    }

    public final boolean bhk() {
        AppMethodBeat.m2504i(32773);
        this.zaR = getCurCount();
        C4990ab.m7416i("MicroMsg.MMChattingListView", "[onBottomLoadData] mPreCount:" + this.zaR);
        if (this.yNt != null) {
            this.yNt.mo31088a(C40749a.ACTION_BOTTOM, false, this.yZU);
            this.yZU = null;
            this.zaQ = false;
        }
        AppMethodBeat.m2505o(32773);
        return false;
    }

    public final boolean bhn() {
        AppMethodBeat.m2504i(32774);
        this.zaR = getCurCount();
        C4990ab.m7416i("MicroMsg.MMChattingListView", "[onTopLoadData] mPreCount:" + this.zaR + " isForceTopLoadDataForPosition:" + this.zaQ);
        if (this.yNt != null) {
            if (this.zaQ && this.yZU != null) {
                this.yZU.putInt("SCENE", 2);
            }
            this.yNt.mo31088a(this.zaQ ? C40749a.ACTION_POSITION : C40749a.ACTION_TOP, false, this.yZU);
        }
        this.yZU = null;
        this.zaQ = false;
        AppMethodBeat.m2505o(32774);
        return false;
    }

    public int getPreCount() {
        return this.zaR;
    }

    public int getCurCount() {
        AppMethodBeat.m2504i(32775);
        if (this.zaN == null) {
            AppMethodBeat.m2505o(32775);
            return 0;
        }
        int count = this.zaN.getCount();
        AppMethodBeat.m2505o(32775);
        return count;
    }

    public void setHighLightChild(int i) {
        AppMethodBeat.m2504i(32776);
        int max = Math.max(0, i);
        if (this.mListView == null) {
            C4990ab.m7413e("MicroMsg.MMChattingListView", "null == listView index:%s", Integer.valueOf(max));
            AppMethodBeat.m2505o(32776);
            return;
        }
        View childAt = this.mListView.getChildAt(max);
        if (childAt == null) {
            C4990ab.m7413e("MicroMsg.MMChattingListView", "null == view index:%s", Integer.valueOf(max));
            AppMethodBeat.m2505o(32776);
            return;
        }
        if (childAt.getBottom() - childAt.getTop() <= 0) {
            ListView listView = this.mListView;
            childAt = listView.getChildAt(listView.getHeaderViewsCount() + max);
        }
        if (childAt == null) {
            C4990ab.m7413e("MicroMsg.MMChattingListView", "null == view index:%s", Integer.valueOf(max + this.mListView.getHeaderViewsCount()));
            AppMethodBeat.m2505o(32776);
            return;
        }
        C4990ab.m7417i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", Integer.valueOf(max), new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()));
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 0.85f, 0.85f, 0.85f, 0.85f, 0.85f, 0.0f});
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat});
        ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.m2504i(32762);
                childAt.getGlobalVisibleRect(MMChattingListView.this.zaO);
                MMChattingListView.this.zaO.top = childAt.getTop();
                MMChattingListView.this.zaO.bottom = childAt.getBottom();
                MMChattingListView.this.zaP.setAlpha((int) (((Float) valueAnimator.getAnimatedValue("alpha")).floatValue() * 255.0f));
                MMChattingListView.this.mListView.postInvalidate();
                AppMethodBeat.m2505o(32762);
            }
        });
        ofPropertyValuesHolder.addListener(new C53683());
        ofPropertyValuesHolder.setDuration(1600);
        ofPropertyValuesHolder.start();
        AppMethodBeat.m2505o(32776);
    }
}
