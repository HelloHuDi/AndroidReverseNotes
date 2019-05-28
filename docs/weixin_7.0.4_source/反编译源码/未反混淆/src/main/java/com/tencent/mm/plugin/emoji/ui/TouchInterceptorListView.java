package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;

public class TouchInterceptorListView extends ListView {
    private int aaI;
    private int aaJ;
    private GestureDetector iay;
    private int kSf;
    private ImageView lbZ;
    private WindowManager lca;
    private LayoutParams lcb;
    private int lcc;
    private int lcd;
    private int lce;
    private int lcf;
    private a lcg;
    private b lch;
    private c lci;
    private int lcj;
    private int lck;
    private int lcl = -1;
    private Bitmap lcm;
    private int lcn;
    private int lco;
    private Drawable lcp;
    private int lcq = 0;
    private int mHeight;
    private Rect mTempRect = new Rect();
    private final int mTouchSlop;

    public interface a {
    }

    public interface b {
    }

    public interface c {
    }

    static /* synthetic */ void c(TouchInterceptorListView touchInterceptorListView) {
        AppMethodBeat.i(53533);
        touchInterceptorListView.blU();
        AppMethodBeat.o(53533);
    }

    static /* synthetic */ void f(TouchInterceptorListView touchInterceptorListView) {
        AppMethodBeat.i(53534);
        touchInterceptorListView.gr(true);
        AppMethodBeat.o(53534);
    }

    public TouchInterceptorListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53527);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        Resources resources = getResources();
        this.kSf = resources.getDimensionPixelSize(R.dimen.a0u) + 1;
        this.lco = this.kSf / 2;
        this.lcn = this.kSf * 2;
        this.lcq = resources.getDimensionPixelOffset(R.dimen.a11);
        AppMethodBeat.o(53527);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(53528);
        if (this.lci != null && this.iay == null && this.lcl == 0) {
            this.iay = new GestureDetector(getContext(), new SimpleOnGestureListener() {
                public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    AppMethodBeat.i(53526);
                    if (TouchInterceptorListView.this.lbZ != null) {
                        if (f > 1000.0f) {
                            Rect b = TouchInterceptorListView.this.mTempRect;
                            TouchInterceptorListView.this.lbZ.getDrawingRect(b);
                            if (motionEvent2.getX() > ((float) ((b.right * 2) / 3))) {
                                TouchInterceptorListView.c(TouchInterceptorListView.this);
                                TouchInterceptorListView.this.lci;
                                TouchInterceptorListView.this.lcd;
                                TouchInterceptorListView.f(TouchInterceptorListView.this);
                            }
                        }
                        AppMethodBeat.o(53526);
                        return true;
                    }
                    AppMethodBeat.o(53526);
                    return false;
                }
            });
        }
        if (!(this.lcg == null && this.lch == null)) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        ViewGroup viewGroup = (ViewGroup) getChildAt(pointToPosition - getFirstVisiblePosition());
                        this.lce = x - viewGroup.getLeft();
                        this.lcf = y - viewGroup.getTop();
                        this.aaI = ((int) motionEvent.getRawX()) - x;
                        this.aaJ = ((int) motionEvent.getRawY()) - y;
                        if (x >= this.lcq) {
                            blU();
                            break;
                        }
                        viewGroup.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache());
                        blU();
                        this.lcb = new LayoutParams();
                        this.lcb.gravity = 49;
                        this.lcb.x = (x - this.lce) + this.aaI;
                        this.lcb.y = (y - this.lcf) + this.aaJ;
                        this.lcb.height = -2;
                        this.lcb.width = -2;
                        this.lcb.flags = 920;
                        this.lcb.format = -3;
                        this.lcb.windowAnimations = 0;
                        Context context = getContext();
                        ImageView imageView = new ImageView(context);
                        imageView.setBackgroundColor(context.getResources().getColor(R.color.a69));
                        imageView.setBackgroundResource(R.drawable.adq);
                        imageView.setPadding(0, 0, 0, 0);
                        imageView.setImageBitmap(createBitmap);
                        this.lcm = createBitmap;
                        this.lca = (WindowManager) context.getSystemService("window");
                        this.lca.addView(imageView, this.lcb);
                        this.lbZ = imageView;
                        this.lcc = pointToPosition;
                        this.lcd = this.lcc;
                        this.mHeight = getHeight();
                        int i = this.mTouchSlop;
                        this.lcj = Math.min(y - i, this.mHeight / 3);
                        this.lck = Math.max(i + y, (this.mHeight * 2) / 3);
                        AppMethodBeat.o(53528);
                        return false;
                    }
                    break;
            }
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(53528);
        return onInterceptTouchEvent;
    }

    private int dT(int i, int i2) {
        int dT;
        AppMethodBeat.i(53529);
        if (i2 < 0) {
            dT = dT(i, this.kSf + i2);
            if (dT > 0) {
                dT--;
                AppMethodBeat.o(53529);
                return dT;
            }
        }
        Rect rect = this.mTempRect;
        for (dT = getChildCount() - 1; dT >= 0; dT--) {
            getChildAt(dT).getHitRect(rect);
            if (rect.contains(i, i2)) {
                dT += getFirstVisiblePosition();
                AppMethodBeat.o(53529);
                return dT;
            }
        }
        AppMethodBeat.o(53529);
        return -1;
    }

    private void gr(boolean z) {
        AppMethodBeat.i(53530);
        int i = 0;
        while (true) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                if (z) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    int top = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(firstVisiblePosition, top);
                }
                try {
                    layoutChildren();
                    childAt = getChildAt(i);
                } catch (IllegalStateException e) {
                }
                if (childAt == null) {
                    AppMethodBeat.o(53530);
                    return;
                }
            }
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = this.kSf;
            childAt.setLayoutParams(layoutParams);
            childAt.setVisibility(0);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 4;
        int i2 = 0;
        AppMethodBeat.i(53531);
        if (this.iay != null) {
            this.iay.onTouchEvent(motionEvent);
        }
        if ((this.lcg == null && this.lch == null) || this.lbZ == null) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(53531);
            return onTouchEvent;
        }
        int action = motionEvent.getAction();
        switch (action) {
            case 0:
            case 2:
                int width;
                int width2;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (this.lcl == 1) {
                    float f = 1.0f;
                    width = this.lbZ.getWidth();
                    if (x > width / 2) {
                        f = ((float) (width - x)) / ((float) (width / 2));
                    }
                    this.lcb.alpha = f;
                }
                if (this.lcl == 0 || this.lcl == 2) {
                    this.lcb.x = (x - this.lce) + this.aaI;
                } else {
                    this.lcb.x = 0;
                }
                this.lcb.y = (y - this.lcf) + this.aaJ;
                this.lca.updateViewLayout(this.lbZ, this.lcb);
                if (this.lcp != null) {
                    width2 = this.lbZ.getWidth();
                    if (y > (getHeight() * 3) / 4) {
                        this.lcp.setLevel(2);
                    } else if (width2 <= 0 || x <= width2 / 4) {
                        this.lcp.setLevel(0);
                    } else {
                        this.lcp.setLevel(1);
                    }
                }
                x = (y - this.lcf) - this.lco;
                width2 = dT(0, x);
                if (width2 >= 0) {
                    if (width2 <= this.lcd) {
                        width2++;
                    }
                } else if (x < 0) {
                    width2 = 0;
                }
                if (width2 >= 0) {
                    if (action == 0 || width2 != this.lcc) {
                        this.lcc = width2;
                        ab.d("MicroMsg.emoji.TouchInterceptorListView", "doExpansion mDragPos:%d mSrcDragPos:%d", Integer.valueOf(this.lcc), Integer.valueOf(this.lcd));
                        ab.d("MicroMsg.emoji.TouchInterceptorListView", "getFirstVisiblePosition:%d", Integer.valueOf(getFirstVisiblePosition()));
                        ab.d("MicroMsg.emoji.TouchInterceptorListView", "getHeaderViewsCount:%d", Integer.valueOf(getHeaderViewsCount()));
                        width = this.lcc - getFirstVisiblePosition();
                        int headerViewsCount = getHeaderViewsCount();
                        View childAt = getChildAt(this.lcd - getFirstVisiblePosition());
                        x = 0;
                        while (true) {
                            View childAt2 = getChildAt(x);
                            if (childAt2 != null) {
                                action = this.kSf;
                                if (this.lcc >= headerViewsCount || x != headerViewsCount) {
                                    if (childAt2.equals(childAt)) {
                                        if (this.lcc == this.lcd || getPositionForView(childAt2) == getCount()) {
                                            action = this.kSf;
                                            ab.d("MicroMsg.emoji.TouchInterceptorListView", "2. visibility = View.INVISIBLE");
                                            width2 = 4;
                                        } else {
                                            ab.d("MicroMsg.emoji.TouchInterceptorListView", "2. height = 1");
                                            width2 = 0;
                                            action = 1;
                                        }
                                    } else if (x != width) {
                                        ab.d("MicroMsg.emoji.TouchInterceptorListView", "4");
                                        width2 = 0;
                                    } else if (this.lcc < headerViewsCount || this.lcc >= getCount()) {
                                        ab.d("MicroMsg.emoji.TouchInterceptorListView", "3. ");
                                        width2 = 0;
                                    } else {
                                        action = this.lcn;
                                        ab.d("MicroMsg.emoji.TouchInterceptorListView", "3. height = mItemHeightExpanded;");
                                        width2 = 0;
                                    }
                                } else if (childAt2.equals(childAt)) {
                                    ab.d("MicroMsg.emoji.TouchInterceptorListView", "1. visibility = View.INVISIBLE");
                                    width2 = 4;
                                } else {
                                    action = this.lcn;
                                    ab.d("MicroMsg.emoji.TouchInterceptorListView", "1. height = mItemHeightExpanded");
                                    width2 = 0;
                                }
                                ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
                                layoutParams.height = action;
                                childAt2.setLayoutParams(layoutParams);
                                childAt2.setVisibility(width2);
                                x++;
                            }
                        }
                    }
                    if (y >= this.mHeight / 3) {
                        this.lcj = this.mHeight / 3;
                    }
                    if (y <= (this.mHeight * 2) / 3) {
                        this.lck = (this.mHeight * 2) / 3;
                    }
                    if (y > this.lck) {
                        if (getLastVisiblePosition() < getCount() - 1) {
                            if (y > (this.mHeight + this.lck) / 2) {
                                i = 16;
                            }
                            i2 = i;
                        } else {
                            i2 = 1;
                        }
                    } else if (y < this.lcj) {
                        width2 = y < this.lcj / 2 ? -16 : -4;
                        if (getFirstVisiblePosition() != 0 || getChildAt(0).getTop() < getPaddingTop()) {
                            i2 = width2;
                        }
                    }
                    if (!(i2 == 0 || d.fP(8))) {
                        smoothScrollBy(i2, 30);
                        break;
                    }
                }
                break;
            case 1:
            case 3:
                Rect rect = this.mTempRect;
                this.lbZ.getDrawingRect(rect);
                blU();
                if (this.lcl == 1 && motionEvent.getX() > ((float) ((rect.right * 3) / 4))) {
                    gr(true);
                    break;
                }
                if (this.lch != null && this.lcc >= 0) {
                    getCount();
                }
                gr(false);
                break;
                break;
        }
        AppMethodBeat.o(53531);
        return true;
    }

    private void blU() {
        AppMethodBeat.i(53532);
        if (this.lbZ != null) {
            this.lbZ.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.lbZ);
            this.lbZ.setImageDrawable(null);
            this.lbZ = null;
        }
        if (this.lcm != null) {
            ab.i("MicroMsg.emoji.TouchInterceptorListView", "bitmap recycle %s", this.lcm);
            this.lcm.recycle();
            this.lcm = null;
        }
        if (this.lcp != null) {
            this.lcp.setLevel(0);
        }
        AppMethodBeat.o(53532);
    }

    public void setTrashcan(Drawable drawable) {
        this.lcp = drawable;
        this.lcl = 2;
    }

    public void setDragListener(a aVar) {
        this.lcg = aVar;
    }

    public void setDropListener(b bVar) {
        this.lch = bVar;
    }

    public void setRemoveListener(c cVar) {
        this.lci = cVar;
    }
}
