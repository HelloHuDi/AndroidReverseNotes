package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ai;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

public class DragSortListView extends ListView {
    private int SG = 0;
    private int iJ;
    private int iK;
    private View iYn;
    private int itQ;
    private int itR;
    private DataSetObserver mObserver;
    private int mOffsetX;
    private int mOffsetY;
    private Point zUA = new Point();
    private Point zUB = new Point();
    private int zUC;
    private boolean zUD = false;
    private float zUE = 1.0f;
    private float zUF = 1.0f;
    private int zUG;
    private int zUH;
    private int zUI;
    private boolean zUJ = false;
    private int zUK;
    private int zUL;
    private int zUM;
    private b zUN;
    private h zUO;
    private l zUP;
    boolean zUQ = true;
    private int zUR = 1;
    private int zUS;
    private int zUT;
    private int zUU = 0;
    private View[] zUV = new View[1];
    private d zUW;
    private float zUX = 0.33333334f;
    private float zUY = 0.33333334f;
    private int zUZ;
    boolean zVA = false;
    private boolean zVB = false;
    private int zVa;
    private float zVb;
    private float zVc;
    private float zVd;
    private float zVe;
    private float zVf = 0.5f;
    private c zVg = new c() {
        public final float bs(float f) {
            AppMethodBeat.i(113024);
            float a = DragSortListView.this.zVf * f;
            AppMethodBeat.o(113024);
            return a;
        }
    };
    private int zVh;
    private int zVi = 0;
    private boolean zVj = false;
    boolean zVk = false;
    i zVl = null;
    private MotionEvent zVm;
    private int zVn = 0;
    private float zVo = 0.25f;
    private float zVp = 0.0f;
    private a zVq;
    private boolean zVr = false;
    private f zVs;
    private boolean zVt = false;
    private boolean zVu = false;
    private j zVv = new j(this, (byte) 0);
    private k zVw;
    private g zVx;
    private boolean zVy;
    private float zVz = 0.0f;

    class a extends BaseAdapter {
        ListAdapter Ei;

        /* synthetic */ a(DragSortListView dragSortListView, ListAdapter listAdapter, byte b) {
            this(listAdapter);
        }

        private a(ListAdapter listAdapter) {
            AppMethodBeat.i(113030);
            this.Ei = listAdapter;
            this.Ei.registerDataSetObserver(new DataSetObserver(DragSortListView.this) {
                public final void onChanged() {
                    AppMethodBeat.i(113028);
                    a.this.notifyDataSetChanged();
                    AppMethodBeat.o(113028);
                }

                public final void onInvalidated() {
                    AppMethodBeat.i(113029);
                    a.this.notifyDataSetInvalidated();
                    AppMethodBeat.o(113029);
                }
            });
            AppMethodBeat.o(113030);
        }

        public final long getItemId(int i) {
            AppMethodBeat.i(113031);
            long itemId = this.Ei.getItemId(i);
            AppMethodBeat.o(113031);
            return itemId;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(113032);
            Object item = this.Ei.getItem(i);
            AppMethodBeat.o(113032);
            return item;
        }

        public final int getCount() {
            AppMethodBeat.i(113033);
            int count = this.Ei.getCount();
            AppMethodBeat.o(113033);
            return count;
        }

        public final boolean areAllItemsEnabled() {
            AppMethodBeat.i(113034);
            boolean areAllItemsEnabled = this.Ei.areAllItemsEnabled();
            AppMethodBeat.o(113034);
            return areAllItemsEnabled;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(113035);
            boolean isEnabled = this.Ei.isEnabled(i);
            AppMethodBeat.o(113035);
            return isEnabled;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(113036);
            int itemViewType = this.Ei.getItemViewType(i);
            AppMethodBeat.o(113036);
            return itemViewType;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.i(113037);
            int viewTypeCount = this.Ei.getViewTypeCount();
            AppMethodBeat.o(113037);
            return viewTypeCount;
        }

        public final boolean hasStableIds() {
            AppMethodBeat.i(113038);
            boolean hasStableIds = this.Ei.hasStableIds();
            AppMethodBeat.o(113038);
            return hasStableIds;
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(113039);
            boolean isEmpty = this.Ei.isEmpty();
            AppMethodBeat.o(113039);
            return isEmpty;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(113040);
            View view2;
            View cVar;
            if (view == null || !(view instanceof b)) {
                view2 = this.Ei.getView(i, null, DragSortListView.this);
                if (view2 instanceof Checkable) {
                    cVar = new c(DragSortListView.this.getContext());
                } else {
                    cVar = new b(DragSortListView.this.getContext());
                }
                cVar.setLayoutParams(new LayoutParams(-1, -2));
                cVar.addView(view2);
                view = cVar;
            } else {
                view = (b) view;
                cVar = view.getChildAt(0);
                view2 = this.Ei.getView(i, cVar, DragSortListView.this);
                if (view2 != cVar) {
                    if (cVar != null) {
                        view.removeViewAt(0);
                    }
                    view.addView(view2);
                }
            }
            DragSortListView dragSortListView = DragSortListView.this;
            DragSortListView.a(dragSortListView, dragSortListView.getHeaderViewsCount() + i, view);
            AppMethodBeat.o(113040);
            return view;
        }
    }

    class g extends m {
        private int zVP;
        private int zVQ;
        private float zVR;
        private float zVS;

        /* synthetic */ g(DragSortListView dragSortListView, int i, byte b) {
            this(i);
        }

        private g(int i) {
            super(DragSortListView.this, i, (byte) 0);
        }

        public final void onStart() {
            AppMethodBeat.i(113047);
            this.zVP = DragSortListView.this.zUG;
            this.zVQ = DragSortListView.this.zUK;
            DragSortListView.this.SG = 2;
            this.zVR = (float) (DragSortListView.this.zUA.y - dLK());
            this.zVS = (float) (DragSortListView.this.zUA.x - DragSortListView.this.getPaddingLeft());
            AppMethodBeat.o(113047);
        }

        private int dLK() {
            AppMethodBeat.i(113048);
            int i = (DragSortListView.this.zUR + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.zVP - DragSortListView.this.getFirstVisiblePosition());
            int i2 = -1;
            if (childAt == null) {
                this.xH = true;
            } else if (this.zVP == this.zVQ) {
                i2 = childAt.getTop();
            } else if (this.zVP < this.zVQ) {
                i2 = childAt.getTop() - i;
            } else {
                i2 = (childAt.getBottom() + i) - DragSortListView.this.zUS;
            }
            AppMethodBeat.o(113048);
            return i2;
        }

        public final void bt(float f) {
            AppMethodBeat.i(113049);
            int dLK = dLK();
            float paddingLeft = (float) (DragSortListView.this.zUA.x - DragSortListView.this.getPaddingLeft());
            float f2 = 1.0f - f;
            if (f2 < Math.abs(((float) (DragSortListView.this.zUA.y - dLK)) / this.zVR) || f2 < Math.abs(paddingLeft / this.zVS)) {
                DragSortListView.this.zUA.y = dLK + ((int) (this.zVR * f2));
                DragSortListView.this.zUA.x = DragSortListView.this.getPaddingLeft() + ((int) (this.zVS * f2));
                DragSortListView.f(DragSortListView.this);
            }
            AppMethodBeat.o(113049);
        }

        public final void onStop() {
            AppMethodBeat.i(113050);
            DragSortListView.k(DragSortListView.this);
            AppMethodBeat.o(113050);
        }
    }

    public interface h {
        void dm(int i, int i2);
    }

    public interface i {
        View Qw(int i);

        void fr(View view);

        void h(Point point);
    }

    class j {
        private int xCD;
        private SparseIntArray zVT;
        private ArrayList<Integer> zVU;

        /* synthetic */ j(DragSortListView dragSortListView, byte b) {
            this();
        }

        private j() {
            AppMethodBeat.i(113051);
            this.zVT = new SparseIntArray(3);
            this.zVU = new ArrayList(3);
            this.xCD = 3;
            AppMethodBeat.o(113051);
        }

        public final void add(int i, int i2) {
            AppMethodBeat.i(113052);
            int i3 = this.zVT.get(i, -1);
            if (i3 != i2) {
                if (i3 != -1) {
                    this.zVU.remove(Integer.valueOf(i));
                } else if (this.zVT.size() == this.xCD) {
                    this.zVT.delete(((Integer) this.zVU.remove(0)).intValue());
                }
                this.zVT.put(i, i2);
                this.zVU.add(Integer.valueOf(i));
            }
            AppMethodBeat.o(113052);
        }

        public final int get(int i) {
            AppMethodBeat.i(113053);
            int i2 = this.zVT.get(i, -1);
            AppMethodBeat.o(113053);
            return i2;
        }

        public final void clear() {
            AppMethodBeat.i(113054);
            this.zVT.clear();
            this.zVU.clear();
            AppMethodBeat.o(113054);
        }
    }

    public interface b {
    }

    public interface c {
        float bs(float f);
    }

    class d implements Runnable {
        private int dy;
        boolean zOp = false;
        private boolean zVF;
        private long zVG;
        private long zVH;
        private float zVI;
        private long zVJ;
        int zVK;
        private float zVL;

        d() {
        }

        public final void Qv(int i) {
            AppMethodBeat.i(113041);
            if (!this.zOp) {
                this.zVF = false;
                this.zOp = true;
                this.zVJ = SystemClock.uptimeMillis();
                this.zVG = this.zVJ;
                this.zVK = i;
                DragSortListView.this.post(this);
            }
            AppMethodBeat.o(113041);
        }

        public final void dLJ() {
            AppMethodBeat.i(113042);
            DragSortListView.this.removeCallbacks(this);
            this.zOp = false;
            AppMethodBeat.o(113042);
        }

        public final void run() {
            AppMethodBeat.i(113043);
            if (this.zVF) {
                this.zOp = false;
                AppMethodBeat.o(113043);
                return;
            }
            View childAt;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int min = Math.min(DragSortListView.this.iK, DragSortListView.this.zUC + DragSortListView.this.zUT);
            int max = Math.max(DragSortListView.this.iK, DragSortListView.this.zUC - DragSortListView.this.zUT);
            if (this.zVK == 0) {
                childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.zOp = false;
                    AppMethodBeat.o(113043);
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.zOp = false;
                    AppMethodBeat.o(113043);
                    return;
                } else {
                    this.zVL = DragSortListView.this.zVg.bs((DragSortListView.this.zVc - ((float) max)) / DragSortListView.this.zVd);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.zOp = false;
                    AppMethodBeat.o(113043);
                    return;
                } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                    this.zVL = -DragSortListView.this.zVg.bs((((float) min) - DragSortListView.this.zVb) / DragSortListView.this.zVe);
                } else {
                    this.zOp = false;
                    AppMethodBeat.o(113043);
                    return;
                }
            }
            this.zVH = SystemClock.uptimeMillis();
            this.zVI = (float) (this.zVH - this.zVG);
            this.dy = Math.round(this.zVL * this.zVI);
            if (this.dy >= 0) {
                this.dy = Math.min(height, this.dy);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.dy = Math.max(-height, this.dy);
            }
            childAt = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            firstVisiblePosition = childAt.getTop() + this.dy;
            if (lastVisiblePosition == 0 && firstVisiblePosition > paddingTop) {
                firstVisiblePosition = paddingTop;
            }
            DragSortListView.this.zVt = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, firstVisiblePosition - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.zVt = false;
            DragSortListView.c(DragSortListView.this, lastVisiblePosition, childAt);
            this.zVG = this.zVH;
            DragSortListView.this.post(this);
            AppMethodBeat.o(113043);
        }
    }

    class f {
        File gUc = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        StringBuilder mBuilder = new StringBuilder();
        int zVM = 0;
        int zVN = 0;
        boolean zVO = false;

        f() {
            AppMethodBeat.i(113044);
            if (!this.gUc.exists()) {
                try {
                    if (!this.gUc.createNewFile()) {
                        ai.e("mobeta", "creat file fail!! file already exist", new Object[0]);
                    }
                    ai.d("mobeta", "file created", new Object[0]);
                    AppMethodBeat.o(113044);
                    return;
                } catch (IOException e) {
                    ai.w("mobeta", "Could not create dslv_state.txt", new Object[0]);
                    ai.d("mobeta", e.getMessage(), new Object[0]);
                }
            }
            AppMethodBeat.o(113044);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A:{SYNTHETIC, Splitter:B:19:0x0063} */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x007f A:{SYNTHETIC, Splitter:B:27:0x007f} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void flush() {
            Throwable th;
            Writer writer;
            AppMethodBeat.i(113045);
            if (this.zVO) {
                Writer bufferedWriter;
                try {
                    boolean z;
                    if (this.zVN == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.gUc, z), "UTF-8"));
                    try {
                        bufferedWriter.write(this.mBuilder.toString());
                        this.mBuilder.delete(0, this.mBuilder.length());
                        bufferedWriter.flush();
                        this.zVN++;
                        try {
                            bufferedWriter.close();
                            AppMethodBeat.o(113045);
                            return;
                        } catch (IOException e) {
                            ai.printErrStackTrace("DragSortListView", e, "IOException", new Object[0]);
                            AppMethodBeat.o(113045);
                            return;
                        }
                    } catch (IOException e2) {
                        if (bufferedWriter != null) {
                        }
                        AppMethodBeat.o(113045);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        writer = bufferedWriter;
                        if (writer != null) {
                        }
                        AppMethodBeat.o(113045);
                        throw th;
                    }
                } catch (IOException e3) {
                    bufferedWriter = null;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            ai.printErrStackTrace("DragSortListView", e4, "IOException", new Object[0]);
                            AppMethodBeat.o(113045);
                            return;
                        }
                    }
                    AppMethodBeat.o(113045);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    writer = null;
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e42) {
                            ai.printErrStackTrace("DragSortListView", e42, "IOException", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(113045);
                    throw th;
                }
            }
            AppMethodBeat.o(113045);
        }

        public final void stopTracking() {
            AppMethodBeat.i(113046);
            if (this.zVO) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.zVO = false;
            }
            AppMethodBeat.o(113046);
        }
    }

    public interface e extends b, h, l {
    }

    public interface l {
        void remove(int i);
    }

    class m implements Runnable {
        private float mAlpha;
        protected long mStartTime;
        boolean xH;
        private float zWb;
        private float zWc;
        private float zWd;
        private float zWe;
        private float zWf;

        /* synthetic */ m(DragSortListView dragSortListView, int i, byte b) {
            this(i);
        }

        private m(int i) {
            AppMethodBeat.i(113058);
            this.mAlpha = 0.5f;
            this.zWb = (float) i;
            float f = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.zWf = f;
            this.zWc = f;
            this.zWd = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.zWe = 1.0f / (1.0f - this.mAlpha);
            AppMethodBeat.o(113058);
        }

        public final void start() {
            AppMethodBeat.i(113059);
            this.mStartTime = SystemClock.uptimeMillis();
            this.xH = false;
            onStart();
            DragSortListView.this.post(this);
            AppMethodBeat.o(113059);
        }

        public void onStart() {
        }

        public void bt(float f) {
        }

        public void onStop() {
        }

        public void run() {
            AppMethodBeat.i(113060);
            if (this.xH) {
                AppMethodBeat.o(113060);
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.zWb;
            if (uptimeMillis >= 1.0f) {
                bt(1.0f);
                onStop();
                AppMethodBeat.o(113060);
                return;
            }
            if (uptimeMillis < this.mAlpha) {
                uptimeMillis *= this.zWc * uptimeMillis;
            } else if (uptimeMillis < 1.0f - this.mAlpha) {
                uptimeMillis = (uptimeMillis * this.zWe) + this.zWd;
            } else {
                uptimeMillis = 1.0f - ((uptimeMillis - 1.0f) * (this.zWf * (uptimeMillis - 1.0f)));
            }
            bt(uptimeMillis);
            DragSortListView.this.post(this);
            AppMethodBeat.o(113060);
        }
    }

    class k extends m {
        private int elV;
        private float zVV;
        private float zVW;
        private float zVX;
        private int zVY;
        private int zVZ;
        private int zWa;

        /* synthetic */ k(DragSortListView dragSortListView, int i, byte b) {
            this(i);
        }

        private k(int i) {
            super(DragSortListView.this, i, (byte) 0);
            this.zVY = -1;
            this.zVZ = -1;
        }

        public final void onStart() {
            int i = -1;
            AppMethodBeat.i(113055);
            this.zVY = -1;
            this.zVZ = -1;
            this.elV = DragSortListView.this.zUH;
            this.zWa = DragSortListView.this.zUI;
            DragSortListView.this.SG = 1;
            this.zVV = (float) DragSortListView.this.zUA.x;
            if (DragSortListView.this.zVy) {
                float width = ((float) DragSortListView.this.getWidth()) * 2.0f;
                if (DragSortListView.this.zVz == 0.0f) {
                    DragSortListView dragSortListView = DragSortListView.this;
                    if (this.zVV >= 0.0f) {
                        i = 1;
                    }
                    dragSortListView.zVz = ((float) i) * width;
                    AppMethodBeat.o(113055);
                    return;
                }
                float f = width * 2.0f;
                if (DragSortListView.this.zVz >= 0.0f || DragSortListView.this.zVz <= (-f)) {
                    if (DragSortListView.this.zVz > 0.0f && DragSortListView.this.zVz < f) {
                        DragSortListView.this.zVz = f;
                    }
                    AppMethodBeat.o(113055);
                    return;
                }
                DragSortListView.this.zVz = -f;
                AppMethodBeat.o(113055);
                return;
            }
            DragSortListView.p(DragSortListView.this);
            AppMethodBeat.o(113055);
        }

        public final void bt(float f) {
            AppMethodBeat.i(113056);
            float f2 = 1.0f - f;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt = DragSortListView.this.getChildAt(this.elV - firstVisiblePosition);
            if (DragSortListView.this.zVy) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis == 0.0f) {
                    AppMethodBeat.o(113056);
                    return;
                }
                float o = DragSortListView.this.zVz * uptimeMillis;
                int width = DragSortListView.this.getWidth();
                DragSortListView.this.zVz = ((((float) (DragSortListView.this.zVz > 0.0f ? 1 : -1)) * uptimeMillis) * ((float) width)) + DragSortListView.this.zVz;
                this.zVV += o;
                DragSortListView.this.zUA.x = (int) this.zVV;
                if (this.zVV < ((float) width) && this.zVV > ((float) (-width))) {
                    this.mStartTime = SystemClock.uptimeMillis();
                    DragSortListView.f(DragSortListView.this);
                    AppMethodBeat.o(113056);
                    return;
                }
            }
            if (childAt != null) {
                if (this.zVY == -1) {
                    this.zVY = DragSortListView.b(DragSortListView.this, this.elV, childAt);
                    this.zVW = (float) (childAt.getHeight() - this.zVY);
                }
                int max = Math.max((int) (this.zVW * f2), 1);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height = max + this.zVY;
                childAt.setLayoutParams(layoutParams);
            }
            if (this.zWa != this.elV) {
                View childAt2 = DragSortListView.this.getChildAt(this.zWa - firstVisiblePosition);
                if (childAt2 != null) {
                    if (this.zVZ == -1) {
                        this.zVZ = DragSortListView.b(DragSortListView.this, this.zWa, childAt2);
                        this.zVX = (float) (childAt2.getHeight() - this.zVZ);
                    }
                    int max2 = Math.max((int) (this.zVX * f2), 1);
                    ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    layoutParams2.height = max2 + this.zVZ;
                    childAt2.setLayoutParams(layoutParams2);
                }
            }
            AppMethodBeat.o(113056);
        }

        public final void onStop() {
            AppMethodBeat.i(113057);
            DragSortListView.q(DragSortListView.this);
            AppMethodBeat.o(113057);
        }
    }

    static /* synthetic */ void f(DragSortListView dragSortListView) {
        AppMethodBeat.i(113103);
        dragSortListView.dLG();
        AppMethodBeat.o(113103);
    }

    static /* synthetic */ void k(DragSortListView dragSortListView) {
        AppMethodBeat.i(113104);
        dragSortListView.dLA();
        AppMethodBeat.o(113104);
    }

    static /* synthetic */ void p(DragSortListView dragSortListView) {
        AppMethodBeat.i(113105);
        dragSortListView.dLI();
        AppMethodBeat.o(113105);
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(113061);
        int i = 150;
        int i2 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tencent.mm.cg.a.a.DragSortListView, 0, 0);
            this.zUR = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(0, 1));
            this.zVr = obtainStyledAttributes.getBoolean(5, false);
            if (this.zVr) {
                this.zVs = new f();
            }
            this.zUE = obtainStyledAttributes.getFloat(6, this.zUE);
            this.zUF = this.zUE;
            this.zUQ = obtainStyledAttributes.getBoolean(10, this.zUQ);
            this.zVo = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(7, 0.75f)));
            this.zUJ = this.zVo > 0.0f;
            setDragScrollStart(obtainStyledAttributes.getFloat(1, this.zUX));
            this.zVf = obtainStyledAttributes.getFloat(2, this.zVf);
            int i3 = obtainStyledAttributes.getInt(8, 150);
            int i4 = obtainStyledAttributes.getInt(9, 150);
            if (obtainStyledAttributes.getBoolean(17, true)) {
                boolean z = obtainStyledAttributes.getBoolean(12, false);
                int i5 = obtainStyledAttributes.getInt(4, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(11, true);
                int i6 = obtainStyledAttributes.getInt(13, 0);
                int resourceId = obtainStyledAttributes.getResourceId(14, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(15, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(16, 0);
                int color = obtainStyledAttributes.getColor(3, WebView.NIGHT_MODE_COLOR);
                a aVar = new a(this, resourceId, i6, i5, resourceId3, resourceId2);
                aVar.zUi = z;
                aVar.zUh = z2;
                aVar.zWh = color;
                this.zVl = aVar;
                setOnTouchListener(aVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i4;
            i = i3;
        }
        this.zUW = new d();
        if (i > 0) {
            this.zVw = new k(this, i, (byte) 0);
        }
        if (i2 > 0) {
            this.zVx = new g(this, i2, (byte) 0);
        }
        this.zVm = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new DataSetObserver() {
            private void cancel() {
                AppMethodBeat.i(113025);
                if (DragSortListView.this.SG == 4) {
                    DragSortListView.this.dLy();
                }
                AppMethodBeat.o(113025);
            }

            public final void onChanged() {
                AppMethodBeat.i(113026);
                cancel();
                AppMethodBeat.o(113026);
            }

            public final void onInvalidated() {
                AppMethodBeat.i(113027);
                cancel();
                AppMethodBeat.o(113027);
            }
        };
        AppMethodBeat.o(113061);
    }

    public float getFloatAlpha() {
        return this.zUF;
    }

    public void setFloatAlpha(float f) {
        this.zUF = f;
    }

    public void setMaxScrollSpeed(float f) {
        this.zVf = f;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(113062);
        if (listAdapter != null) {
            this.zVq = new a(this, listAdapter, (byte) 0);
            listAdapter.registerDataSetObserver(this.mObserver);
            if (listAdapter instanceof h) {
                setDropListener((h) listAdapter);
            }
            if (listAdapter instanceof b) {
                setDragListener((b) listAdapter);
            }
            if (listAdapter instanceof l) {
                setRemoveListener((l) listAdapter);
            }
        } else {
            this.zVq = null;
        }
        super.setAdapter(this.zVq);
        AppMethodBeat.o(113062);
    }

    public ListAdapter getInputAdapter() {
        if (this.zVq == null) {
            return null;
        }
        return this.zVq.Ei;
    }

    private void a(int i, Canvas canvas) {
        AppMethodBeat.i(113063);
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (!(divider == null || dividerHeight == 0)) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i - getFirstVisiblePosition());
            if (viewGroup != null) {
                int i2;
                int paddingLeft = getPaddingLeft();
                int width = getWidth() - getPaddingRight();
                int height = viewGroup.getChildAt(0).getHeight();
                if (i > this.zUK) {
                    height += viewGroup.getTop();
                    i2 = height + dividerHeight;
                } else {
                    i2 = viewGroup.getBottom() - height;
                    height = i2 - dividerHeight;
                }
                canvas.save();
                canvas.clipRect(paddingLeft, height, width, i2);
                divider.setBounds(paddingLeft, height, width, i2);
                divider.draw(canvas);
                canvas.restore();
            }
        }
        AppMethodBeat.o(113063);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(113064);
        super.dispatchDraw(canvas);
        if (this.SG != 0) {
            if (this.zUH != this.zUK) {
                a(this.zUH, canvas);
            }
            if (!(this.zUI == this.zUH || this.zUI == this.zUK)) {
                a(this.zUI, canvas);
            }
        }
        if (this.iYn != null) {
            float f;
            int width = this.iYn.getWidth();
            int height = this.iYn.getHeight();
            int i = this.zUA.x;
            int width2 = getWidth();
            if (i < 0) {
                i = -i;
            }
            if (i < width2) {
                f = ((float) (width2 - i)) / ((float) width2);
                f *= f;
            } else {
                f = 0.0f;
            }
            int i2 = (int) (f * (255.0f * this.zUF));
            canvas.save();
            canvas.translate((float) this.zUA.x, (float) this.zUA.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) width, (float) height, i2, 31);
            this.iYn.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
        AppMethodBeat.o(113064);
    }

    private int Qs(int i) {
        AppMethodBeat.i(113065);
        View childAt = getChildAt(i - getFirstVisiblePosition());
        int height;
        if (childAt != null) {
            height = childAt.getHeight();
            AppMethodBeat.o(113065);
            return height;
        }
        height = hF(i, Qu(i));
        AppMethodBeat.o(113065);
        return height;
    }

    private int hE(int i, int i2) {
        AppMethodBeat.i(113066);
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            AppMethodBeat.o(113066);
            return i2;
        }
        headerViewsCount = getDividerHeight();
        footerViewsCount = this.zUS - this.zUR;
        int Qu = Qu(i);
        int Qs = Qs(i);
        if (this.zUI <= this.zUK) {
            if (i != this.zUI || this.zUH == this.zUI) {
                if (i > this.zUI && i <= this.zUK) {
                    i2 -= footerViewsCount;
                }
            } else if (i == this.zUK) {
                i2 = (i2 + Qs) - this.zUS;
            } else {
                i2 = ((Qs - Qu) + i2) - footerViewsCount;
            }
        } else if (i > this.zUK && i <= this.zUH) {
            i2 += footerViewsCount;
        } else if (i == this.zUI && this.zUH != this.zUI) {
            i2 += Qs - Qu;
        }
        if (i <= this.zUK) {
            headerViewsCount = (((this.zUS - headerViewsCount) - Qu(i - 1)) / 2) + i2;
        } else {
            headerViewsCount = (((Qu - headerViewsCount) - this.zUS) / 2) + i2;
        }
        AppMethodBeat.o(113066);
        return headerViewsCount;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean dLx() {
        int i;
        int i2;
        int count;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(113067);
        int firstVisiblePosition = getFirstVisiblePosition();
        int i3 = this.zUH;
        View childAt = getChildAt(i3 - firstVisiblePosition);
        if (childAt == null) {
            i3 = firstVisiblePosition + (getChildCount() / 2);
            childAt = getChildAt(i3 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int hE = hE(i3, top);
        int dividerHeight = getDividerHeight();
        if (this.zUC < hE) {
            i = hE;
            firstVisiblePosition = hE;
            i2 = i3;
            while (i2 >= 0) {
                i2--;
                i3 = Qs(i2);
                if (i2 != 0) {
                    top -= i3 + dividerHeight;
                    i3 = hE(i2, top);
                    if (this.zUC >= i3) {
                        break;
                    }
                    i = i3;
                    firstVisiblePosition = i3;
                } else {
                    i3 = (top - dividerHeight) - i3;
                    break;
                }
            }
            i3 = firstVisiblePosition;
        } else {
            count = getCount();
            i = hE;
            firstVisiblePosition = hE;
            i2 = i3;
            while (i2 < count) {
                if (i2 != count - 1) {
                    top += dividerHeight + height;
                    hE = Qs(i2 + 1);
                    i3 = hE(i2 + 1, top);
                    if (this.zUC < i3) {
                        break;
                    }
                    i2++;
                    i = i3;
                    firstVisiblePosition = i3;
                    height = hE;
                } else {
                    i3 = (top + dividerHeight) + height;
                    break;
                }
            }
            i3 = firstVisiblePosition;
        }
        height = getHeaderViewsCount();
        dividerHeight = getFooterViewsCount();
        count = this.zUH;
        int i4 = this.zUI;
        float f = this.zVp;
        if (this.zUJ) {
            int abs = Math.abs(i3 - i);
            if (this.zUC < i3) {
                firstVisiblePosition = i3;
                hE = i;
            } else {
                firstVisiblePosition = i;
                hE = i3;
            }
            i = (int) ((this.zVo * 0.5f) * ((float) abs));
            float f2 = (float) i;
            hE += i;
            i = firstVisiblePosition - i;
            if (this.zUC < hE) {
                this.zUH = i2 - 1;
                this.zUI = i2;
                this.zVp = (((float) (hE - this.zUC)) * 0.5f) / f2;
            } else if (this.zUC >= i) {
                this.zUH = i2;
                this.zUI = i2 + 1;
                this.zVp = (1.0f + (((float) (firstVisiblePosition - this.zUC)) / f2)) * 0.5f;
            }
            if (this.zUH >= height) {
                this.zUH = height;
                this.zUI = height;
                i2 = height;
            } else if (this.zUI >= getCount() - dividerHeight) {
                i2 = (getCount() - dividerHeight) - 1;
                this.zUH = i2;
                this.zUI = i2;
            }
            if (this.zUH == count || this.zUI != i4 || Math.abs(this.zVp - f) > 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (i2 == this.zUG) {
                this.zUG = i2;
            } else {
                z2 = z;
            }
            AppMethodBeat.o(113067);
            return z2;
        }
        this.zUH = i2;
        this.zUI = i2;
        if (this.zUH >= height) {
        }
        if (this.zUH == count) {
        }
        z = true;
        if (i2 == this.zUG) {
        }
        AppMethodBeat.o(113067);
        return z2;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(113068);
        super.onDraw(canvas);
        if (this.zVr) {
            f fVar = this.zVs;
            if (fVar.zVO) {
                int i;
                fVar.mBuilder.append("<DSLVState>\n");
                int childCount = DragSortListView.this.getChildCount();
                int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
                fVar.mBuilder.append("    <Positions>");
                for (i = 0; i < childCount; i++) {
                    fVar.mBuilder.append(firstVisiblePosition + i).append(",");
                }
                fVar.mBuilder.append("</Positions>\n");
                fVar.mBuilder.append("    <Tops>");
                for (i = 0; i < childCount; i++) {
                    fVar.mBuilder.append(DragSortListView.this.getChildAt(i).getTop()).append(",");
                }
                fVar.mBuilder.append("</Tops>\n");
                fVar.mBuilder.append("    <Bottoms>");
                for (i = 0; i < childCount; i++) {
                    fVar.mBuilder.append(DragSortListView.this.getChildAt(i).getBottom()).append(",");
                }
                fVar.mBuilder.append("</Bottoms>\n");
                fVar.mBuilder.append("    <FirstExpPos>").append(DragSortListView.this.zUH).append("</FirstExpPos>\n");
                fVar.mBuilder.append("    <FirstExpBlankHeight>").append(DragSortListView.this.Qs(DragSortListView.this.zUH) - DragSortListView.this.Qu(DragSortListView.this.zUH)).append("</FirstExpBlankHeight>\n");
                fVar.mBuilder.append("    <SecondExpPos>").append(DragSortListView.this.zUI).append("</SecondExpPos>\n");
                fVar.mBuilder.append("    <SecondExpBlankHeight>").append(DragSortListView.this.Qs(DragSortListView.this.zUI) - DragSortListView.this.Qu(DragSortListView.this.zUI)).append("</SecondExpBlankHeight>\n");
                fVar.mBuilder.append("    <SrcPos>").append(DragSortListView.this.zUK).append("</SrcPos>\n");
                fVar.mBuilder.append("    <SrcHeight>").append(DragSortListView.this.zUS + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
                fVar.mBuilder.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
                fVar.mBuilder.append("    <LastY>").append(DragSortListView.this.itR).append("</LastY>\n");
                fVar.mBuilder.append("    <FloatY>").append(DragSortListView.this.zUC).append("</FloatY>\n");
                fVar.mBuilder.append("    <ShuffleEdges>");
                for (i = 0; i < childCount; i++) {
                    fVar.mBuilder.append(DragSortListView.this.hE(firstVisiblePosition + i, DragSortListView.this.getChildAt(i).getTop())).append(",");
                }
                fVar.mBuilder.append("</ShuffleEdges>\n");
                fVar.mBuilder.append("</DSLVState>\n");
                fVar.zVM++;
                if (fVar.zVM > 1000) {
                    fVar.flush();
                    fVar.zVM = 0;
                }
            }
        }
        AppMethodBeat.o(113068);
    }

    public final void removeItem(int i) {
        AppMethodBeat.i(113069);
        this.zVy = false;
        q(i, 0.0f);
        AppMethodBeat.o(113069);
    }

    private void q(int i, float f) {
        AppMethodBeat.i(113070);
        if (this.SG == 0 || this.SG == 4) {
            if (this.SG == 0) {
                this.zUK = getHeaderViewsCount() + i;
                this.zUH = this.zUK;
                this.zUI = this.zUK;
                this.zUG = this.zUK;
                View childAt = getChildAt(this.zUK - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.SG = 1;
            this.zVz = f;
            if (this.zVk) {
                switch (this.zVn) {
                    case 1:
                        super.onTouchEvent(this.zVm);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.zVm);
                        break;
                }
            }
            if (this.zVw != null) {
                this.zVw.start();
                AppMethodBeat.o(113070);
                return;
            }
            Qt(i);
        }
        AppMethodBeat.o(113070);
    }

    public final void dLy() {
        AppMethodBeat.i(113071);
        if (this.SG == 4) {
            this.zUW.dLJ();
            dLI();
            dLz();
            dLE();
            if (this.zVk) {
                this.SG = 3;
                AppMethodBeat.o(113071);
                return;
            }
            this.SG = 0;
        }
        AppMethodBeat.o(113071);
    }

    private void dLz() {
        this.zUK = -1;
        this.zUH = -1;
        this.zUI = -1;
        this.zUG = -1;
    }

    private void dLA() {
        AppMethodBeat.i(113072);
        this.SG = 2;
        if (this.zUO != null && this.zUG >= 0 && this.zUG < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.zUO.dm(this.zUK - headerViewsCount, this.zUG - headerViewsCount);
        }
        dLI();
        dLB();
        dLz();
        dLE();
        if (this.zVk) {
            this.SG = 3;
            AppMethodBeat.o(113072);
            return;
        }
        this.SG = 0;
        AppMethodBeat.o(113072);
    }

    private void Qt(int i) {
        AppMethodBeat.i(113073);
        this.SG = 1;
        if (this.zUP != null) {
            this.zUP.remove(i);
        }
        dLI();
        dLB();
        dLz();
        if (this.zVk) {
            this.SG = 3;
            AppMethodBeat.o(113073);
            return;
        }
        this.SG = 0;
        AppMethodBeat.o(113073);
    }

    private void dLB() {
        int i = 0;
        AppMethodBeat.i(113074);
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.zUK < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i - getPaddingTop());
        }
        AppMethodBeat.o(113074);
    }

    public final boolean br(float f) {
        AppMethodBeat.i(113075);
        this.zVy = true;
        boolean b = b(true, f);
        AppMethodBeat.o(113075);
        return b;
    }

    private boolean b(boolean z, float f) {
        AppMethodBeat.i(113076);
        if (this.iYn != null) {
            this.zUW.dLJ();
            if (z) {
                q(this.zUK - getHeaderViewsCount(), f);
            } else if (this.zVx != null) {
                this.zVx.start();
            } else {
                dLA();
            }
            if (this.zVr) {
                this.zVs.stopTracking();
            }
            AppMethodBeat.o(113076);
            return true;
        }
        AppMethodBeat.o(113076);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(113077);
        if (this.zVu) {
            this.zVu = false;
            AppMethodBeat.o(113077);
            return false;
        } else if (this.zUQ) {
            boolean z = this.zVj;
            this.zVj = false;
            if (!z) {
                U(motionEvent);
            }
            if (this.SG != 4) {
                if (this.SG == 0 && super.onTouchEvent(motionEvent)) {
                    z = true;
                } else {
                    z = false;
                }
                switch (motionEvent.getAction() & 255) {
                    case 1:
                    case 3:
                        dLC();
                        break;
                    default:
                        if (z) {
                            this.zVn = 1;
                            break;
                        }
                        break;
                }
            }
            switch (motionEvent.getAction() & 255) {
                case 1:
                    if (this.SG == 4) {
                        this.zVy = false;
                        b(false, 0.0f);
                    }
                    dLC();
                    break;
                case 2:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.zUA.x = x - this.zUL;
                    this.zUA.y = y - this.zUM;
                    dLG();
                    int min = Math.min(y, this.zUC + this.zUT);
                    y = Math.max(y, this.zUC - this.zUT);
                    d dVar = this.zUW;
                    if (dVar.zOp) {
                        x = dVar.zVK;
                    } else {
                        x = -1;
                    }
                    if (min <= this.itR || min <= this.zVa || x == 1) {
                        if (y >= this.itR || y >= this.zUZ || x == 0) {
                            if (y >= this.zUZ && min <= this.zVa && this.zUW.zOp) {
                                this.zUW.dLJ();
                                break;
                            }
                        }
                        if (x != -1) {
                            this.zUW.dLJ();
                        }
                        this.zUW.Qv(0);
                        break;
                    }
                    if (x != -1) {
                        this.zUW.dLJ();
                    }
                    this.zUW.Qv(1);
                    break;
                    break;
                case 3:
                    if (this.SG == 4) {
                        dLy();
                    }
                    dLC();
                    break;
            }
            z = true;
            AppMethodBeat.o(113077);
            return z;
        } else {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(113077);
            return onTouchEvent;
        }
    }

    private void dLC() {
        AppMethodBeat.i(113078);
        this.zVn = 0;
        this.zVk = false;
        if (this.SG == 3) {
            this.SG = 0;
        }
        this.zUF = this.zUE;
        this.zVA = false;
        this.zVv.clear();
        AppMethodBeat.o(113078);
    }

    private void U(MotionEvent motionEvent) {
        AppMethodBeat.i(113079);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.itQ = this.iJ;
            this.itR = this.iK;
        }
        this.iJ = (int) motionEvent.getX();
        this.iK = (int) motionEvent.getY();
        if (action == 0) {
            this.itQ = this.iJ;
            this.itR = this.iK;
        }
        this.mOffsetX = ((int) motionEvent.getRawX()) - this.iJ;
        this.mOffsetY = ((int) motionEvent.getRawY()) - this.iK;
        AppMethodBeat.o(113079);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(113080);
        if (this.zUQ) {
            boolean z;
            U(motionEvent);
            this.zVj = true;
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                if (this.SG != 0) {
                    this.zVu = true;
                    AppMethodBeat.o(113080);
                    return true;
                }
                this.zVk = true;
            }
            if (this.iYn == null) {
                if (super.onInterceptTouchEvent(motionEvent)) {
                    this.zVA = true;
                    z = true;
                } else {
                    z = false;
                }
                switch (action) {
                    case 1:
                    case 3:
                        dLC();
                        break;
                    default:
                        if (!z) {
                            this.zVn = 2;
                            break;
                        }
                        this.zVn = 1;
                        break;
                }
            }
            z = true;
            if (action == 1 || action == 3) {
                this.zVk = false;
            }
            AppMethodBeat.o(113080);
            return z;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(113080);
        return onInterceptTouchEvent;
    }

    private void dLD() {
        AppMethodBeat.i(113082);
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f = (float) height;
        this.zVc = ((float) paddingTop) + (this.zUX * f);
        this.zVb = (f * (1.0f - this.zUY)) + ((float) paddingTop);
        this.zUZ = (int) this.zVc;
        this.zVa = (int) this.zVb;
        this.zVd = this.zVc - ((float) paddingTop);
        this.zVe = ((float) (paddingTop + height)) - this.zVb;
        AppMethodBeat.o(113082);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(113083);
        super.onSizeChanged(i, i2, i3, i4);
        dLD();
        AppMethodBeat.o(113083);
    }

    private void dLE() {
        AppMethodBeat.i(113084);
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        lastVisiblePosition = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= lastVisiblePosition; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
        AppMethodBeat.o(113084);
    }

    private void a(int i, View view, boolean z) {
        int c;
        AppMethodBeat.i(113085);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i == this.zUK || i == this.zUH || i == this.zUI) {
            c = c(i, view, z);
        } else {
            c = -2;
        }
        if (c != layoutParams.height) {
            layoutParams.height = c;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.zUH || i == this.zUI) {
            if (i < this.zUK) {
                ((b) view).setGravity(80);
            } else if (i > this.zUK) {
                ((b) view).setGravity(48);
            }
        }
        int visibility = view.getVisibility();
        c = 0;
        if (i == this.zUK && this.iYn != null) {
            c = 4;
        }
        if (c != visibility) {
            view.setVisibility(c);
        }
        AppMethodBeat.o(113085);
    }

    private int Qu(int i) {
        AppMethodBeat.i(113086);
        if (i == this.zUK) {
            AppMethodBeat.o(113086);
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        int b;
        if (childAt != null) {
            b = b(i, childAt, false);
            AppMethodBeat.o(113086);
            return b;
        }
        b = this.zVv.get(i);
        if (b != -1) {
            AppMethodBeat.o(113086);
            return b;
        }
        View view;
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.zUV.length) {
            this.zUV = new View[viewTypeCount];
        }
        if (itemViewType < 0) {
            view = adapter.getView(i, null, this);
        } else if (this.zUV[itemViewType] == null) {
            view = adapter.getView(i, null, this);
            this.zUV[itemViewType] = view;
        } else {
            view = adapter.getView(i, this.zUV[itemViewType], this);
        }
        b = b(i, view, true);
        this.zVv.add(i, b);
        AppMethodBeat.o(113086);
        return b;
    }

    private int b(int i, View view, boolean z) {
        AppMethodBeat.i(113087);
        if (i == this.zUK) {
            AppMethodBeat.o(113087);
            return 0;
        }
        if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int height;
        if (layoutParams == null || layoutParams.height <= 0) {
            height = view.getHeight();
            if (height == 0 || z) {
                fq(view);
                height = view.getMeasuredHeight();
            }
            AppMethodBeat.o(113087);
            return height;
        }
        height = layoutParams.height;
        AppMethodBeat.o(113087);
        return height;
    }

    private int c(int i, View view, boolean z) {
        AppMethodBeat.i(113088);
        int hF = hF(i, b(i, view, z));
        AppMethodBeat.o(113088);
        return hF;
    }

    private int hF(int i, int i2) {
        Object obj = (!this.zUJ || this.zUH == this.zUI) ? null : 1;
        int i3 = this.zUS - this.zUR;
        int i4 = (int) (this.zVp * ((float) i3));
        if (i == this.zUK) {
            if (this.zUK == this.zUH) {
                if (obj != null) {
                    return i4 + this.zUR;
                }
                return this.zUS;
            } else if (this.zUK == this.zUI) {
                return this.zUS - i4;
            } else {
                return this.zUR;
            }
        } else if (i == this.zUH) {
            if (obj != null) {
                return i2 + i4;
            }
            return i2 + i3;
        } else if (i == this.zUI) {
            return (i2 + i3) - i4;
        } else {
            return i2;
        }
    }

    public void requestLayout() {
        AppMethodBeat.i(113089);
        if (!this.zVt) {
            super.requestLayout();
        }
        AppMethodBeat.o(113089);
    }

    private int a(int i, View view, int i2, int i3) {
        int i4;
        AppMethodBeat.i(113090);
        int Qu = Qu(i);
        int height = view.getHeight();
        int hF = hF(i, Qu);
        if (i != this.zUK) {
            i4 = height - Qu;
            Qu = hF - Qu;
        } else {
            Qu = hF;
            i4 = height;
        }
        int i5 = this.zUS;
        if (!(this.zUK == this.zUH || this.zUK == this.zUI)) {
            i5 -= this.zUR;
        }
        if (i <= i2) {
            if (i > this.zUH) {
                Qu = (i5 - Qu) + 0;
            }
            Qu = 0;
        } else if (i == i3) {
            Qu = i <= this.zUH ? (i4 - i5) + 0 : i == this.zUI ? (height - hF) + 0 : i4 + 0;
        } else if (i <= this.zUH) {
            Qu = 0 - i5;
        } else {
            if (i == this.zUI) {
                Qu = 0 - Qu;
            }
            Qu = 0;
        }
        AppMethodBeat.o(113090);
        return Qu;
    }

    private void fq(View view) {
        int makeMeasureSpec;
        AppMethodBeat.i(113091);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.zUU, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, ErrorDialogData.SUPPRESSED);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
        AppMethodBeat.o(113091);
    }

    private void dLF() {
        AppMethodBeat.i(113092);
        if (this.iYn != null) {
            fq(this.iYn);
            this.zUS = this.iYn.getMeasuredHeight();
            this.zUT = this.zUS / 2;
        }
        AppMethodBeat.o(113092);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(113093);
        super.onMeasure(i, i2);
        if (this.iYn != null) {
            if (this.iYn.isLayoutRequested()) {
                dLF();
            }
            this.zUD = true;
        }
        this.zUU = i;
        AppMethodBeat.o(113093);
    }

    /* Access modifiers changed, original: protected */
    public void layoutChildren() {
        AppMethodBeat.i(113094);
        super.layoutChildren();
        if (this.iYn != null) {
            if (this.iYn.isLayoutRequested() && !this.zUD) {
                dLF();
            }
            this.iYn.layout(0, 0, this.iYn.getMeasuredWidth(), this.iYn.getMeasuredHeight());
            this.zUD = false;
        }
        AppMethodBeat.o(113094);
    }

    public final boolean a(int i, View view, int i2, int i3, int i4) {
        AppMethodBeat.i(113095);
        if (this.SG == 0 && this.zVk && this.iYn == null && view != null && this.zUQ) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = getHeaderViewsCount() + i;
            this.zUH = headerViewsCount;
            this.zUI = headerViewsCount;
            this.zUK = headerViewsCount;
            this.zUG = headerViewsCount;
            this.SG = 4;
            this.zVi = 0;
            this.zVi |= i2;
            this.iYn = view;
            dLF();
            this.zUL = i3;
            this.zUM = i4;
            this.zVh = this.iK;
            this.zUA.x = this.iJ - this.zUL;
            this.zUA.y = this.iK - this.zUM;
            View childAt = getChildAt(this.zUK - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.zVr) {
                f fVar = this.zVs;
                fVar.mBuilder.append("<DSLVStates>\n");
                fVar.zVN = 0;
                fVar.zVO = true;
            }
            switch (this.zVn) {
                case 1:
                    super.onTouchEvent(this.zVm);
                    break;
                case 2:
                    super.onInterceptTouchEvent(this.zVm);
                    break;
            }
            requestLayout();
            AppMethodBeat.o(113095);
            return true;
        }
        AppMethodBeat.o(113095);
        return false;
    }

    private void dLG() {
        AppMethodBeat.i(113096);
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt == null) {
            AppMethodBeat.o(113096);
            return;
        }
        d(firstVisiblePosition, childAt, true);
        AppMethodBeat.o(113096);
    }

    private void d(int i, View view, boolean z) {
        AppMethodBeat.i(113097);
        this.zVt = true;
        dLH();
        int i2 = this.zUH;
        int i3 = this.zUI;
        boolean dLx = dLx();
        if (dLx) {
            dLE();
            setSelectionFromTop(i, (a(i, view, i2, i3) + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (dLx || z) {
            invalidate();
        }
        this.zVt = false;
        AppMethodBeat.o(113097);
    }

    private void dLH() {
        AppMethodBeat.i(113098);
        if (this.zVl != null) {
            this.zUB.set(this.iJ, this.iK);
            this.zVl.h(this.zUA);
        }
        int i = this.zUA.x;
        int i2 = this.zUA.y;
        int paddingLeft = getPaddingLeft();
        if ((this.zVi & 1) == 0 && i > paddingLeft) {
            this.zUA.x = paddingLeft;
        } else if ((this.zVi & 2) == 0 && i < paddingLeft) {
            this.zUA.x = paddingLeft;
        }
        paddingLeft = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        i = getPaddingTop();
        if (firstVisiblePosition < paddingLeft) {
            i = getChildAt((paddingLeft - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.zVi & 8) == 0 && firstVisiblePosition <= this.zUK) {
            i = Math.max(getChildAt(this.zUK - firstVisiblePosition).getTop(), i);
        }
        paddingLeft = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            paddingLeft = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.zVi & 4) == 0 && lastVisiblePosition >= this.zUK) {
            paddingLeft = Math.min(getChildAt(this.zUK - firstVisiblePosition).getBottom(), paddingLeft);
        }
        if (i2 < i) {
            this.zUA.y = i;
        } else if (this.zUS + i2 > paddingLeft) {
            this.zUA.y = paddingLeft - this.zUS;
        }
        this.zUC = this.zUA.y + this.zUT;
        AppMethodBeat.o(113098);
    }

    private void dLI() {
        AppMethodBeat.i(113099);
        if (this.iYn != null) {
            this.iYn.setVisibility(8);
            if (this.zVl != null) {
                this.zVl.fr(this.iYn);
            }
            this.iYn = null;
            invalidate();
        }
        AppMethodBeat.o(113099);
    }

    public void setFloatViewManager(i iVar) {
        this.zVl = iVar;
    }

    public void setDragListener(b bVar) {
        this.zUN = bVar;
    }

    public void setDragEnabled(boolean z) {
        this.zUQ = z;
    }

    public void setDropListener(h hVar) {
        this.zUO = hVar;
    }

    public void setRemoveListener(l lVar) {
        this.zUP = lVar;
    }

    public void setDragSortListener(e eVar) {
        AppMethodBeat.i(113100);
        setDropListener(eVar);
        setDragListener(eVar);
        setRemoveListener(eVar);
        AppMethodBeat.o(113100);
    }

    public void setDragScrollProfile(c cVar) {
        if (cVar != null) {
            this.zVg = cVar;
        }
    }

    public void setDragScrollStart(float f) {
        AppMethodBeat.i(113081);
        if (f > 0.5f) {
            this.zUY = 0.5f;
        } else {
            this.zUY = f;
        }
        if (f > 0.5f) {
            this.zUX = 0.5f;
        } else {
            this.zUX = f;
        }
        if (getHeight() != 0) {
            dLD();
        }
        AppMethodBeat.o(113081);
    }

    static /* synthetic */ void q(DragSortListView dragSortListView) {
        AppMethodBeat.i(113107);
        dragSortListView.Qt(dragSortListView.zUK - dragSortListView.getHeaderViewsCount());
        AppMethodBeat.o(113107);
    }
}
