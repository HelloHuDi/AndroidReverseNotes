package com.tencent.mm.ui.chatting.view;

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
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.MMPullDownView.d;
import com.tencent.mm.ui.base.MMPullDownView.e;
import com.tencent.mm.ui.base.MMPullDownView.g;
import com.tencent.mm.ui.chatting.l.a.a;
import com.tencent.smtt.sdk.WebView;

public class MMChattingListView extends MMPullDownView implements c, d, e, g {
    private ListView mListView;
    private a yNt;
    private Bundle yZU;
    private BaseAdapter zaN;
    private Rect zaO = new Rect();
    private Paint zaP;
    private boolean zaQ = false;
    private int zaR;

    public MMChattingListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(32764);
        init(context);
        AppMethodBeat.o(32764);
    }

    public MMChattingListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(32765);
        init(context);
        AppMethodBeat.o(32765);
    }

    private void init(Context context) {
        AppMethodBeat.i(32766);
        this.zaP = new Paint();
        this.zaP.setColor(WebView.NIGHT_MODE_COLOR);
        this.mListView = new ListView(context) {
            public final void onDrawForeground(Canvas canvas) {
                AppMethodBeat.i(32761);
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
                    ab.d("MicroMsg.MMChattingListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s", rect, MMChattingListView.this.zaO);
                }
                AppMethodBeat.o(32761);
            }
        };
        this.mListView.setBackgroundDrawable(null);
        this.mListView.setSelector(R.drawable.u_);
        this.mListView.setCacheColorHint(0);
        this.mListView.setDivider(null);
        this.mListView.setPadding(0, 0, 0, com.tencent.mm.bz.a.fromDPToPix(context, 6));
        this.mListView.setClipToPadding(false);
        this.mListView.setScrollBarStyle(33554432);
        setOverScrollMode(2);
        addView(this.mListView, new LayoutParams(-1, -1));
        setCanOverScrool(false);
        qc(false);
        qd(false);
        setTopViewVisible(true);
        setOnBottomLoadDataListener(this);
        setOnTopLoadDataListener(this);
        setAtBottomCallBack(this);
        setAtTopCallBack(this);
        setIsBottomShowAll(true);
        setIsTopShowAll(false);
        setBottomViewVisible(true);
        AppMethodBeat.o(32766);
    }

    public void setAdapter(BaseAdapter baseAdapter) {
        AppMethodBeat.i(32767);
        this.zaN = baseAdapter;
        getListView().setAdapter(this.zaN);
        AppMethodBeat.o(32767);
    }

    public void setLoadExecutor(a aVar) {
        this.yNt = aVar;
    }

    public ListView getListView() {
        return this.mListView;
    }

    public BaseAdapter getBaseAdapter() {
        return this.zaN;
    }

    public final boolean bhm() {
        AppMethodBeat.i(32768);
        View childAt = getListView().getChildAt(getListView().getChildCount() - 1);
        if (childAt == null) {
            AppMethodBeat.o(32768);
            return true;
        } else if (childAt.getBottom() > getListView().getHeight() - getListView().getPaddingBottom() || getListView().getLastVisiblePosition() != getListView().getAdapter().getCount() - 1) {
            AppMethodBeat.o(32768);
            return false;
        } else {
            AppMethodBeat.o(32768);
            return true;
        }
    }

    public final void a(boolean z, Bundle bundle) {
        Object obj;
        AppMethodBeat.i(32769);
        String str = "MicroMsg.MMChattingListView";
        StringBuilder append = new StringBuilder("[lockTopLoadDataForPosition] start:").append(z).append(" sourceArgs:");
        if (bundle == null) {
            obj = BuildConfig.COMMAND;
        } else {
            Bundle obj2 = bundle;
        }
        ab.i(str, append.append(obj2).toString());
        this.zaQ = z;
        this.yZU = bundle;
        super.qc(z);
        AppMethodBeat.o(32769);
    }

    public final void qc(boolean z) {
        AppMethodBeat.i(32770);
        ab.i("MicroMsg.MMChattingListView", "[forceTopLoadData] start:" + z + " isForceTopLoadDataForPosition:" + this.zaQ);
        if (this.zaQ) {
            AppMethodBeat.o(32770);
            return;
        }
        super.qc(z);
        AppMethodBeat.o(32770);
    }

    public final void aw(Bundle bundle) {
        AppMethodBeat.i(32771);
        ab.i("MicroMsg.MMChattingListView", "[forceTopLoadData] sourceArgs:" + (bundle == null ? "" : bundle.toString()));
        this.yZU = bundle;
        super.qd(true);
        AppMethodBeat.o(32771);
    }

    public final boolean bhl() {
        AppMethodBeat.i(32772);
        View childAt = getListView().getChildAt(getListView().getFirstVisiblePosition());
        if (childAt == null || childAt.getTop() != 0) {
            AppMethodBeat.o(32772);
            return false;
        }
        AppMethodBeat.o(32772);
        return true;
    }

    public final boolean bhk() {
        AppMethodBeat.i(32773);
        this.zaR = getCurCount();
        ab.i("MicroMsg.MMChattingListView", "[onBottomLoadData] mPreCount:" + this.zaR);
        if (this.yNt != null) {
            this.yNt.a(com.tencent.mm.ui.chatting.f.d.a.ACTION_BOTTOM, false, this.yZU);
            this.yZU = null;
            this.zaQ = false;
        }
        AppMethodBeat.o(32773);
        return false;
    }

    public final boolean bhn() {
        AppMethodBeat.i(32774);
        this.zaR = getCurCount();
        ab.i("MicroMsg.MMChattingListView", "[onTopLoadData] mPreCount:" + this.zaR + " isForceTopLoadDataForPosition:" + this.zaQ);
        if (this.yNt != null) {
            if (this.zaQ && this.yZU != null) {
                this.yZU.putInt("SCENE", 2);
            }
            this.yNt.a(this.zaQ ? com.tencent.mm.ui.chatting.f.d.a.ACTION_POSITION : com.tencent.mm.ui.chatting.f.d.a.ACTION_TOP, false, this.yZU);
        }
        this.yZU = null;
        this.zaQ = false;
        AppMethodBeat.o(32774);
        return false;
    }

    public int getPreCount() {
        return this.zaR;
    }

    public int getCurCount() {
        AppMethodBeat.i(32775);
        if (this.zaN == null) {
            AppMethodBeat.o(32775);
            return 0;
        }
        int count = this.zaN.getCount();
        AppMethodBeat.o(32775);
        return count;
    }

    public void setHighLightChild(int i) {
        AppMethodBeat.i(32776);
        int max = Math.max(0, i);
        if (this.mListView == null) {
            ab.e("MicroMsg.MMChattingListView", "null == listView index:%s", Integer.valueOf(max));
            AppMethodBeat.o(32776);
            return;
        }
        View childAt = this.mListView.getChildAt(max);
        if (childAt == null) {
            ab.e("MicroMsg.MMChattingListView", "null == view index:%s", Integer.valueOf(max));
            AppMethodBeat.o(32776);
            return;
        }
        if (childAt.getBottom() - childAt.getTop() <= 0) {
            ListView listView = this.mListView;
            childAt = listView.getChildAt(listView.getHeaderViewsCount() + max);
        }
        if (childAt == null) {
            ab.e("MicroMsg.MMChattingListView", "null == view index:%s", Integer.valueOf(max + this.mListView.getHeaderViewsCount()));
            AppMethodBeat.o(32776);
            return;
        }
        ab.i("MicroMsg.MMChattingListView", "[setHighLightChild] index:%s view rect:%s headerCount:%s", Integer.valueOf(max), new Rect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom()), Integer.valueOf(this.mListView.getHeaderViewsCount()));
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{0.0f, 0.85f, 0.85f, 0.85f, 0.85f, 0.85f, 0.0f});
        ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat});
        ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(32762);
                childAt.getGlobalVisibleRect(MMChattingListView.this.zaO);
                MMChattingListView.this.zaO.top = childAt.getTop();
                MMChattingListView.this.zaO.bottom = childAt.getBottom();
                MMChattingListView.this.zaP.setAlpha((int) (((Float) valueAnimator.getAnimatedValue("alpha")).floatValue() * 255.0f));
                MMChattingListView.this.mListView.postInvalidate();
                AppMethodBeat.o(32762);
            }
        });
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(32763);
                super.onAnimationEnd(animator);
                MMChattingListView.this.zaO.setEmpty();
                AppMethodBeat.o(32763);
            }
        });
        ofPropertyValuesHolder.setDuration(1600);
        ofPropertyValuesHolder.start();
        AppMethodBeat.o(32776);
    }
}
