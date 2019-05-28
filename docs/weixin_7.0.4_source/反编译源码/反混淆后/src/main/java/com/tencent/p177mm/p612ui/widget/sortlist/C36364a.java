package com.tencent.p177mm.p612ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.widget.sortlist.a */
public final class C36364a extends C46704d implements OnGestureListener, OnTouchListener {
    /* renamed from: Mh */
    private GestureDetector f15101Mh;
    private int iaN;
    private int iaO;
    private int lcl;
    private int mTouchSlop;
    /* renamed from: yr */
    private int[] f15102yr = new int[2];
    private int zUg = 0;
    boolean zUh = true;
    boolean zUi = false;
    private boolean zUj = false;
    private GestureDetector zUk;
    private int zUl = -1;
    private int zUm = -1;
    private int zUn = -1;
    private int zUo;
    private int zUp;
    private boolean zUq = false;
    private float zUr = 500.0f;
    private int zUs;
    private int zUt;
    private int zUu;
    private boolean zUv;
    private DragSortListView zUw;
    private int zUx;
    private OnGestureListener zUy = new C363631();

    /* renamed from: com.tencent.mm.ui.widget.sortlist.a$1 */
    class C363631 extends SimpleOnGestureListener {
        C363631() {
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AppMethodBeat.m2504i(113009);
            if (C36364a.this.zUi && C36364a.this.zUj) {
                int width = C36364a.this.zUw.getWidth() / 5;
                if (f > C36364a.this.zUr) {
                    if (C36364a.this.zUx > (-width)) {
                        C36364a.this.zUw.mo49277br(f);
                    }
                } else if (f < (-C36364a.this.zUr) && C36364a.this.zUx < width) {
                    C36364a.this.zUw.mo49277br(f);
                }
                C36364a.this.zUj = false;
            }
            AppMethodBeat.m2505o(113009);
            return false;
        }
    }

    public C36364a(DragSortListView dragSortListView, int i, int i2, int i3, int i4, int i5) {
        super(dragSortListView);
        AppMethodBeat.m2504i(113010);
        this.zUw = dragSortListView;
        this.f15101Mh = new GestureDetector(dragSortListView.getContext(), this);
        this.zUk = new GestureDetector(dragSortListView.getContext(), this.zUy);
        this.zUk.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(dragSortListView.getContext()).getScaledTouchSlop();
        this.zUs = i;
        this.zUt = i4;
        this.zUu = i5;
        this.lcl = i3;
        this.zUg = i2;
        AppMethodBeat.m2505o(113010);
    }

    /* renamed from: aF */
    private boolean m59918aF(int i, int i2, int i3) {
        int i4;
        int i5;
        boolean z = false;
        AppMethodBeat.m2504i(113011);
        if (!this.zUh || this.zUj) {
            i4 = 0;
        } else {
            i4 = 12;
        }
        if (this.zUi && this.zUj) {
            i5 = (i4 | 1) | 2;
        } else {
            i5 = i4;
        }
        DragSortListView dragSortListView = this.zUw;
        int headerViewsCount = i - this.zUw.getHeaderViewsCount();
        if (dragSortListView.zVk && dragSortListView.zVl != null) {
            View Qw = dragSortListView.zVl.mo28382Qw(headerViewsCount);
            if (Qw != null) {
                z = dragSortListView.mo49276a(headerViewsCount, Qw, i5, i2, i3);
            }
        }
        this.zUq = z;
        boolean z2 = this.zUq;
        AppMethodBeat.m2505o(113011);
        return z2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(113012);
        if (!this.zUw.zUQ || this.zUw.zVA) {
            AppMethodBeat.m2505o(113012);
        } else {
            this.f15101Mh.onTouchEvent(motionEvent);
            if (this.zUi && this.zUq && this.lcl == 1) {
                this.zUk.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.iaN = (int) motionEvent.getX();
                    this.iaO = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.zUi && this.zUj) {
                        if ((this.zUx >= 0 ? this.zUx : -this.zUx) > this.zUw.getWidth() / 2) {
                            this.zUw.mo49277br(0.0f);
                            break;
                        }
                    }
                    break;
                case 3:
                    this.zUj = false;
                    this.zUq = false;
                    break;
            }
            AppMethodBeat.m2505o(113012);
        }
        return false;
    }

    /* renamed from: h */
    public final void mo28384h(Point point) {
        if (this.zUi && this.zUj) {
            this.zUx = point.x;
        }
    }

    /* renamed from: e */
    private int m59922e(MotionEvent motionEvent, int i) {
        AppMethodBeat.m2504i(113013);
        int pointToPosition = this.zUw.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.zUw.getHeaderViewsCount();
        int footerViewsCount = this.zUw.getFooterViewsCount();
        int count = this.zUw.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            DragSortListView dragSortListView = this.zUw;
            View childAt = dragSortListView.getChildAt(pointToPosition - dragSortListView.getFirstVisiblePosition());
            count = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.f15102yr);
                if (count > this.f15102yr[0] && rawY > this.f15102yr[1] && count < this.f15102yr[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.f15102yr[1]) {
                        this.zUo = childAt.getLeft();
                        this.zUp = childAt.getTop();
                        AppMethodBeat.m2505o(113013);
                        return pointToPosition;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(113013);
        return -1;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        int i = -1;
        AppMethodBeat.m2504i(113014);
        if (this.zUi && this.lcl == 0) {
            this.zUn = m59922e(motionEvent, this.zUt);
        }
        this.zUl = m59922e(motionEvent, this.zUs);
        if (this.zUl != -1 && this.zUg == 0) {
            m59918aF(this.zUl, ((int) motionEvent.getX()) - this.zUo, ((int) motionEvent.getY()) - this.zUp);
        }
        this.zUj = false;
        this.zUv = true;
        this.zUx = 0;
        if (this.lcl == 1) {
            i = m59922e(motionEvent, this.zUu);
        }
        this.zUm = i;
        AppMethodBeat.m2505o(113014);
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.m2504i(113015);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int x2 = (int) motionEvent2.getX();
        int y2 = (int) motionEvent2.getY();
        int i = x2 - this.zUo;
        int i2 = y2 - this.zUp;
        if (!(!this.zUv || this.zUq || (this.zUl == -1 && this.zUm == -1))) {
            if (this.zUl != -1) {
                if (this.zUg == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.zUh) {
                    m59918aF(this.zUl, i, i2);
                } else if (this.zUg != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.zUi) {
                    this.zUj = true;
                    m59918aF(this.zUm, i, i2);
                }
            } else if (this.zUm != -1) {
                if (Math.abs(x2 - x) > this.mTouchSlop && this.zUi) {
                    this.zUj = true;
                    m59918aF(this.zUm, i, i2);
                } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                    this.zUv = false;
                }
            }
        }
        AppMethodBeat.m2505o(113015);
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(113016);
        if (this.zUl != -1 && this.zUg == 2) {
            this.zUw.performHapticFeedback(0);
            m59918aF(this.zUl, this.iaN - this.zUo, this.iaO - this.zUp);
        }
        AppMethodBeat.m2505o(113016);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(113017);
        if (this.zUi && this.lcl == 0 && this.zUn != -1) {
            this.zUw.removeItem(this.zUn - this.zUw.getHeaderViewsCount());
        }
        AppMethodBeat.m2505o(113017);
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }
}
