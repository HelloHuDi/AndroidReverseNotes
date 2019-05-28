package com.tencent.p177mm.p612ui.widget.sortlist;

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
import com.tencent.p177mm.p1594cg.C41922a.C41921a;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.smtt.sdk.WebView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView */
public class DragSortListView extends ListView {
    /* renamed from: SG */
    private int f13760SG = 0;
    /* renamed from: iJ */
    private int f13761iJ;
    /* renamed from: iK */
    private int f13762iK;
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
    private C30813b zUN;
    private C16018h zUO;
    private C30819l zUP;
    boolean zUQ = true;
    private int zUR = 1;
    private int zUS;
    private int zUT;
    private int zUU = 0;
    private View[] zUV = new View[1];
    private C30815d zUW;
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
    private C30814c zVg = new C308181();
    private int zVh;
    private int zVi = 0;
    private boolean zVj = false;
    boolean zVk = false;
    C16019i zVl = null;
    private MotionEvent zVm;
    private int zVn = 0;
    private float zVo = 0.25f;
    private float zVp = 0.0f;
    private C5671a zVq;
    private boolean zVr = false;
    private C30816f zVs;
    private boolean zVt = false;
    private boolean zVu = false;
    private C24116j zVv = new C24116j(this, (byte) 0);
    private C30822k zVw;
    private C16017g zVx;
    private boolean zVy;
    private float zVz = 0.0f;

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$a */
    class C5671a extends BaseAdapter {
        /* renamed from: Ei */
        ListAdapter f1338Ei;

        /* synthetic */ C5671a(DragSortListView dragSortListView, ListAdapter listAdapter, byte b) {
            this(listAdapter);
        }

        private C5671a(ListAdapter listAdapter) {
            AppMethodBeat.m2504i(113030);
            this.f1338Ei = listAdapter;
            this.f1338Ei.registerDataSetObserver(new DataSetObserver(DragSortListView.this) {
                public final void onChanged() {
                    AppMethodBeat.m2504i(113028);
                    C5671a.this.notifyDataSetChanged();
                    AppMethodBeat.m2505o(113028);
                }

                public final void onInvalidated() {
                    AppMethodBeat.m2504i(113029);
                    C5671a.this.notifyDataSetInvalidated();
                    AppMethodBeat.m2505o(113029);
                }
            });
            AppMethodBeat.m2505o(113030);
        }

        public final long getItemId(int i) {
            AppMethodBeat.m2504i(113031);
            long itemId = this.f1338Ei.getItemId(i);
            AppMethodBeat.m2505o(113031);
            return itemId;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(113032);
            Object item = this.f1338Ei.getItem(i);
            AppMethodBeat.m2505o(113032);
            return item;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(113033);
            int count = this.f1338Ei.getCount();
            AppMethodBeat.m2505o(113033);
            return count;
        }

        public final boolean areAllItemsEnabled() {
            AppMethodBeat.m2504i(113034);
            boolean areAllItemsEnabled = this.f1338Ei.areAllItemsEnabled();
            AppMethodBeat.m2505o(113034);
            return areAllItemsEnabled;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(113035);
            boolean isEnabled = this.f1338Ei.isEnabled(i);
            AppMethodBeat.m2505o(113035);
            return isEnabled;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(113036);
            int itemViewType = this.f1338Ei.getItemViewType(i);
            AppMethodBeat.m2505o(113036);
            return itemViewType;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.m2504i(113037);
            int viewTypeCount = this.f1338Ei.getViewTypeCount();
            AppMethodBeat.m2505o(113037);
            return viewTypeCount;
        }

        public final boolean hasStableIds() {
            AppMethodBeat.m2504i(113038);
            boolean hasStableIds = this.f1338Ei.hasStableIds();
            AppMethodBeat.m2505o(113038);
            return hasStableIds;
        }

        public final boolean isEmpty() {
            AppMethodBeat.m2504i(113039);
            boolean isEmpty = this.f1338Ei.isEmpty();
            AppMethodBeat.m2505o(113039);
            return isEmpty;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(113040);
            View view2;
            View c40912c;
            if (view == null || !(view instanceof C46703b)) {
                view2 = this.f1338Ei.getView(i, null, DragSortListView.this);
                if (view2 instanceof Checkable) {
                    c40912c = new C40912c(DragSortListView.this.getContext());
                } else {
                    c40912c = new C46703b(DragSortListView.this.getContext());
                }
                c40912c.setLayoutParams(new LayoutParams(-1, -2));
                c40912c.addView(view2);
                view = c40912c;
            } else {
                view = (C46703b) view;
                c40912c = view.getChildAt(0);
                view2 = this.f1338Ei.getView(i, c40912c, DragSortListView.this);
                if (view2 != c40912c) {
                    if (c40912c != null) {
                        view.removeViewAt(0);
                    }
                    view.addView(view2);
                }
            }
            DragSortListView dragSortListView = DragSortListView.this;
            DragSortListView.m49187a(dragSortListView, dragSortListView.getHeaderViewsCount() + i, view);
            AppMethodBeat.m2505o(113040);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$g */
    class C16017g extends C30821m {
        private int zVP;
        private int zVQ;
        private float zVR;
        private float zVS;

        /* synthetic */ C16017g(DragSortListView dragSortListView, int i, byte b) {
            this(i);
        }

        private C16017g(int i) {
            super(DragSortListView.this, i, (byte) 0);
        }

        public final void onStart() {
            AppMethodBeat.m2504i(113047);
            this.zVP = DragSortListView.this.zUG;
            this.zVQ = DragSortListView.this.zUK;
            DragSortListView.this.f13760SG = 2;
            this.zVR = (float) (DragSortListView.this.zUA.y - dLK());
            this.zVS = (float) (DragSortListView.this.zUA.x - DragSortListView.this.getPaddingLeft());
            AppMethodBeat.m2505o(113047);
        }

        private int dLK() {
            AppMethodBeat.m2504i(113048);
            int i = (DragSortListView.this.zUR + DragSortListView.this.getDividerHeight()) / 2;
            View childAt = DragSortListView.this.getChildAt(this.zVP - DragSortListView.this.getFirstVisiblePosition());
            int i2 = -1;
            if (childAt == null) {
                this.f13764xH = true;
            } else if (this.zVP == this.zVQ) {
                i2 = childAt.getTop();
            } else if (this.zVP < this.zVQ) {
                i2 = childAt.getTop() - i;
            } else {
                i2 = (childAt.getBottom() + i) - DragSortListView.this.zUS;
            }
            AppMethodBeat.m2505o(113048);
            return i2;
        }

        /* renamed from: bt */
        public final void mo28379bt(float f) {
            AppMethodBeat.m2504i(113049);
            int dLK = dLK();
            float paddingLeft = (float) (DragSortListView.this.zUA.x - DragSortListView.this.getPaddingLeft());
            float f2 = 1.0f - f;
            if (f2 < Math.abs(((float) (DragSortListView.this.zUA.y - dLK)) / this.zVR) || f2 < Math.abs(paddingLeft / this.zVS)) {
                DragSortListView.this.zUA.y = dLK + ((int) (this.zVR * f2));
                DragSortListView.this.zUA.x = DragSortListView.this.getPaddingLeft() + ((int) (this.zVS * f2));
                DragSortListView.m49199f(DragSortListView.this);
            }
            AppMethodBeat.m2505o(113049);
        }

        public final void onStop() {
            AppMethodBeat.m2504i(113050);
            DragSortListView.m49207k(DragSortListView.this);
            AppMethodBeat.m2505o(113050);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$h */
    public interface C16018h {
        /* renamed from: dm */
        void mo17752dm(int i, int i2);
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$i */
    public interface C16019i {
        /* renamed from: Qw */
        View mo28382Qw(int i);

        /* renamed from: fr */
        void mo28383fr(View view);

        /* renamed from: h */
        void mo28384h(Point point);
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$j */
    class C24116j {
        private int xCD;
        private SparseIntArray zVT;
        private ArrayList<Integer> zVU;

        /* synthetic */ C24116j(DragSortListView dragSortListView, byte b) {
            this();
        }

        private C24116j() {
            AppMethodBeat.m2504i(113051);
            this.zVT = new SparseIntArray(3);
            this.zVU = new ArrayList(3);
            this.xCD = 3;
            AppMethodBeat.m2505o(113051);
        }

        public final void add(int i, int i2) {
            AppMethodBeat.m2504i(113052);
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
            AppMethodBeat.m2505o(113052);
        }

        public final int get(int i) {
            AppMethodBeat.m2504i(113053);
            int i2 = this.zVT.get(i, -1);
            AppMethodBeat.m2505o(113053);
            return i2;
        }

        public final void clear() {
            AppMethodBeat.m2504i(113054);
            this.zVT.clear();
            this.zVU.clear();
            AppMethodBeat.m2505o(113054);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$b */
    public interface C30813b {
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$c */
    public interface C30814c {
        /* renamed from: bs */
        float mo49302bs(float f);
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$d */
    class C30815d implements Runnable {
        /* renamed from: dy */
        private int f13763dy;
        boolean zOp = false;
        private boolean zVF;
        private long zVG;
        private long zVH;
        private float zVI;
        private long zVJ;
        int zVK;
        private float zVL;

        C30815d() {
        }

        /* renamed from: Qv */
        public final void mo49303Qv(int i) {
            AppMethodBeat.m2504i(113041);
            if (!this.zOp) {
                this.zVF = false;
                this.zOp = true;
                this.zVJ = SystemClock.uptimeMillis();
                this.zVG = this.zVJ;
                this.zVK = i;
                DragSortListView.this.post(this);
            }
            AppMethodBeat.m2505o(113041);
        }

        public final void dLJ() {
            AppMethodBeat.m2504i(113042);
            DragSortListView.this.removeCallbacks(this);
            this.zOp = false;
            AppMethodBeat.m2505o(113042);
        }

        public final void run() {
            AppMethodBeat.m2504i(113043);
            if (this.zVF) {
                this.zOp = false;
                AppMethodBeat.m2505o(113043);
                return;
            }
            View childAt;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            int lastVisiblePosition = DragSortListView.this.getLastVisiblePosition();
            int count = DragSortListView.this.getCount();
            int paddingTop = DragSortListView.this.getPaddingTop();
            int height = (DragSortListView.this.getHeight() - paddingTop) - DragSortListView.this.getPaddingBottom();
            int min = Math.min(DragSortListView.this.f13762iK, DragSortListView.this.zUC + DragSortListView.this.zUT);
            int max = Math.max(DragSortListView.this.f13762iK, DragSortListView.this.zUC - DragSortListView.this.zUT);
            if (this.zVK == 0) {
                childAt = DragSortListView.this.getChildAt(0);
                if (childAt == null) {
                    this.zOp = false;
                    AppMethodBeat.m2505o(113043);
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.zOp = false;
                    AppMethodBeat.m2505o(113043);
                    return;
                } else {
                    this.zVL = DragSortListView.this.zVg.mo49302bs((DragSortListView.this.zVc - ((float) max)) / DragSortListView.this.zVd);
                }
            } else {
                View childAt2 = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.zOp = false;
                    AppMethodBeat.m2505o(113043);
                    return;
                } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                    this.zVL = -DragSortListView.this.zVg.mo49302bs((((float) min) - DragSortListView.this.zVb) / DragSortListView.this.zVe);
                } else {
                    this.zOp = false;
                    AppMethodBeat.m2505o(113043);
                    return;
                }
            }
            this.zVH = SystemClock.uptimeMillis();
            this.zVI = (float) (this.zVH - this.zVG);
            this.f13763dy = Math.round(this.zVL * this.zVI);
            if (this.f13763dy >= 0) {
                this.f13763dy = Math.min(height, this.f13763dy);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.f13763dy = Math.max(-height, this.f13763dy);
            }
            childAt = DragSortListView.this.getChildAt(lastVisiblePosition - firstVisiblePosition);
            firstVisiblePosition = childAt.getTop() + this.f13763dy;
            if (lastVisiblePosition == 0 && firstVisiblePosition > paddingTop) {
                firstVisiblePosition = paddingTop;
            }
            DragSortListView.this.zVt = true;
            DragSortListView.this.setSelectionFromTop(lastVisiblePosition, firstVisiblePosition - paddingTop);
            DragSortListView.this.layoutChildren();
            DragSortListView.this.invalidate();
            DragSortListView.this.zVt = false;
            DragSortListView.m49195c(DragSortListView.this, lastVisiblePosition, childAt);
            this.zVG = this.zVH;
            DragSortListView.this.post(this);
            AppMethodBeat.m2505o(113043);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$f */
    class C30816f {
        File gUc = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        StringBuilder mBuilder = new StringBuilder();
        int zVM = 0;
        int zVN = 0;
        boolean zVO = false;

        C30816f() {
            AppMethodBeat.m2504i(113044);
            if (!this.gUc.exists()) {
                try {
                    if (!this.gUc.createNewFile()) {
                        C5227ai.m7972e("mobeta", "creat file fail!! file already exist", new Object[0]);
                    }
                    C5227ai.m7971d("mobeta", "file created", new Object[0]);
                    AppMethodBeat.m2505o(113044);
                    return;
                } catch (IOException e) {
                    C5227ai.m7975w("mobeta", "Could not create dslv_state.txt", new Object[0]);
                    C5227ai.m7971d("mobeta", e.getMessage(), new Object[0]);
                }
            }
            AppMethodBeat.m2505o(113044);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A:{SYNTHETIC, Splitter:B:19:0x0063} */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x007f A:{SYNTHETIC, Splitter:B:27:0x007f} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void flush() {
            Throwable th;
            Writer writer;
            AppMethodBeat.m2504i(113045);
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
                            AppMethodBeat.m2505o(113045);
                            return;
                        } catch (IOException e) {
                            C5227ai.printErrStackTrace("DragSortListView", e, "IOException", new Object[0]);
                            AppMethodBeat.m2505o(113045);
                            return;
                        }
                    } catch (IOException e2) {
                        if (bufferedWriter != null) {
                        }
                        AppMethodBeat.m2505o(113045);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        writer = bufferedWriter;
                        if (writer != null) {
                        }
                        AppMethodBeat.m2505o(113045);
                        throw th;
                    }
                } catch (IOException e3) {
                    bufferedWriter = null;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e4) {
                            C5227ai.printErrStackTrace("DragSortListView", e4, "IOException", new Object[0]);
                            AppMethodBeat.m2505o(113045);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(113045);
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    writer = null;
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e42) {
                            C5227ai.printErrStackTrace("DragSortListView", e42, "IOException", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(113045);
                    throw th;
                }
            }
            AppMethodBeat.m2505o(113045);
        }

        public final void stopTracking() {
            AppMethodBeat.m2504i(113046);
            if (this.zVO) {
                this.mBuilder.append("</DSLVStates>\n");
                flush();
                this.zVO = false;
            }
            AppMethodBeat.m2505o(113046);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$e */
    public interface C30817e extends C30813b, C16018h, C30819l {
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$1 */
    class C308181 implements C30814c {
        C308181() {
        }

        /* renamed from: bs */
        public final float mo49302bs(float f) {
            AppMethodBeat.m2504i(113024);
            float a = DragSortListView.this.zVf * f;
            AppMethodBeat.m2505o(113024);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$l */
    public interface C30819l {
        void remove(int i);
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$2 */
    class C308202 extends DataSetObserver {
        C308202() {
        }

        private void cancel() {
            AppMethodBeat.m2504i(113025);
            if (DragSortListView.this.f13760SG == 4) {
                DragSortListView.this.dLy();
            }
            AppMethodBeat.m2505o(113025);
        }

        public final void onChanged() {
            AppMethodBeat.m2504i(113026);
            cancel();
            AppMethodBeat.m2505o(113026);
        }

        public final void onInvalidated() {
            AppMethodBeat.m2504i(113027);
            cancel();
            AppMethodBeat.m2505o(113027);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$m */
    class C30821m implements Runnable {
        private float mAlpha;
        protected long mStartTime;
        /* renamed from: xH */
        boolean f13764xH;
        private float zWb;
        private float zWc;
        private float zWd;
        private float zWe;
        private float zWf;

        /* synthetic */ C30821m(DragSortListView dragSortListView, int i, byte b) {
            this(i);
        }

        private C30821m(int i) {
            AppMethodBeat.m2504i(113058);
            this.mAlpha = 0.5f;
            this.zWb = (float) i;
            float f = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.zWf = f;
            this.zWc = f;
            this.zWd = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.zWe = 1.0f / (1.0f - this.mAlpha);
            AppMethodBeat.m2505o(113058);
        }

        public final void start() {
            AppMethodBeat.m2504i(113059);
            this.mStartTime = SystemClock.uptimeMillis();
            this.f13764xH = false;
            onStart();
            DragSortListView.this.post(this);
            AppMethodBeat.m2505o(113059);
        }

        public void onStart() {
        }

        /* renamed from: bt */
        public void mo28379bt(float f) {
        }

        public void onStop() {
        }

        public void run() {
            AppMethodBeat.m2504i(113060);
            if (this.f13764xH) {
                AppMethodBeat.m2505o(113060);
                return;
            }
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.zWb;
            if (uptimeMillis >= 1.0f) {
                mo28379bt(1.0f);
                onStop();
                AppMethodBeat.m2505o(113060);
                return;
            }
            if (uptimeMillis < this.mAlpha) {
                uptimeMillis *= this.zWc * uptimeMillis;
            } else if (uptimeMillis < 1.0f - this.mAlpha) {
                uptimeMillis = (uptimeMillis * this.zWe) + this.zWd;
            } else {
                uptimeMillis = 1.0f - ((uptimeMillis - 1.0f) * (this.zWf * (uptimeMillis - 1.0f)));
            }
            mo28379bt(uptimeMillis);
            DragSortListView.this.post(this);
            AppMethodBeat.m2505o(113060);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.sortlist.DragSortListView$k */
    class C30822k extends C30821m {
        private int elV;
        private float zVV;
        private float zVW;
        private float zVX;
        private int zVY;
        private int zVZ;
        private int zWa;

        /* synthetic */ C30822k(DragSortListView dragSortListView, int i, byte b) {
            this(i);
        }

        private C30822k(int i) {
            super(DragSortListView.this, i, (byte) 0);
            this.zVY = -1;
            this.zVZ = -1;
        }

        public final void onStart() {
            int i = -1;
            AppMethodBeat.m2504i(113055);
            this.zVY = -1;
            this.zVZ = -1;
            this.elV = DragSortListView.this.zUH;
            this.zWa = DragSortListView.this.zUI;
            DragSortListView.this.f13760SG = 1;
            this.zVV = (float) DragSortListView.this.zUA.x;
            if (DragSortListView.this.zVy) {
                float width = ((float) DragSortListView.this.getWidth()) * 2.0f;
                if (DragSortListView.this.zVz == 0.0f) {
                    DragSortListView dragSortListView = DragSortListView.this;
                    if (this.zVV >= 0.0f) {
                        i = 1;
                    }
                    dragSortListView.zVz = ((float) i) * width;
                    AppMethodBeat.m2505o(113055);
                    return;
                }
                float f = width * 2.0f;
                if (DragSortListView.this.zVz >= 0.0f || DragSortListView.this.zVz <= (-f)) {
                    if (DragSortListView.this.zVz > 0.0f && DragSortListView.this.zVz < f) {
                        DragSortListView.this.zVz = f;
                    }
                    AppMethodBeat.m2505o(113055);
                    return;
                }
                DragSortListView.this.zVz = -f;
                AppMethodBeat.m2505o(113055);
                return;
            }
            DragSortListView.m49212p(DragSortListView.this);
            AppMethodBeat.m2505o(113055);
        }

        /* renamed from: bt */
        public final void mo28379bt(float f) {
            AppMethodBeat.m2504i(113056);
            float f2 = 1.0f - f;
            int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
            View childAt = DragSortListView.this.getChildAt(this.elV - firstVisiblePosition);
            if (DragSortListView.this.zVy) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis == 0.0f) {
                    AppMethodBeat.m2505o(113056);
                    return;
                }
                float o = DragSortListView.this.zVz * uptimeMillis;
                int width = DragSortListView.this.getWidth();
                DragSortListView.this.zVz = ((((float) (DragSortListView.this.zVz > 0.0f ? 1 : -1)) * uptimeMillis) * ((float) width)) + DragSortListView.this.zVz;
                this.zVV += o;
                DragSortListView.this.zUA.x = (int) this.zVV;
                if (this.zVV < ((float) width) && this.zVV > ((float) (-width))) {
                    this.mStartTime = SystemClock.uptimeMillis();
                    DragSortListView.m49199f(DragSortListView.this);
                    AppMethodBeat.m2505o(113056);
                    return;
                }
            }
            if (childAt != null) {
                if (this.zVY == -1) {
                    this.zVY = DragSortListView.m49191b(DragSortListView.this, this.elV, childAt);
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
                        this.zVZ = DragSortListView.m49191b(DragSortListView.this, this.zWa, childAt2);
                        this.zVX = (float) (childAt2.getHeight() - this.zVZ);
                    }
                    int max2 = Math.max((int) (this.zVX * f2), 1);
                    ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    layoutParams2.height = max2 + this.zVZ;
                    childAt2.setLayoutParams(layoutParams2);
                }
            }
            AppMethodBeat.m2505o(113056);
        }

        public final void onStop() {
            AppMethodBeat.m2504i(113057);
            DragSortListView.m49214q(DragSortListView.this);
            AppMethodBeat.m2505o(113057);
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m49199f(DragSortListView dragSortListView) {
        AppMethodBeat.m2504i(113103);
        dragSortListView.dLG();
        AppMethodBeat.m2505o(113103);
    }

    /* renamed from: k */
    static /* synthetic */ void m49207k(DragSortListView dragSortListView) {
        AppMethodBeat.m2504i(113104);
        dragSortListView.dLA();
        AppMethodBeat.m2505o(113104);
    }

    /* renamed from: p */
    static /* synthetic */ void m49212p(DragSortListView dragSortListView) {
        AppMethodBeat.m2504i(113105);
        dragSortListView.dLI();
        AppMethodBeat.m2505o(113105);
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(113061);
        int i = 150;
        int i2 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C41921a.DragSortListView, 0, 0);
            this.zUR = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(0, 1));
            this.zVr = obtainStyledAttributes.getBoolean(5, false);
            if (this.zVr) {
                this.zVs = new C30816f();
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
                C36364a c36364a = new C36364a(this, resourceId, i6, i5, resourceId3, resourceId2);
                c36364a.zUi = z;
                c36364a.zUh = z2;
                c36364a.zWh = color;
                this.zVl = c36364a;
                setOnTouchListener(c36364a);
            }
            obtainStyledAttributes.recycle();
            i2 = i4;
            i = i3;
        }
        this.zUW = new C30815d();
        if (i > 0) {
            this.zVw = new C30822k(this, i, (byte) 0);
        }
        if (i2 > 0) {
            this.zVx = new C16017g(this, i2, (byte) 0);
        }
        this.zVm = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.mObserver = new C308202();
        AppMethodBeat.m2505o(113061);
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
        AppMethodBeat.m2504i(113062);
        if (listAdapter != null) {
            this.zVq = new C5671a(this, listAdapter, (byte) 0);
            listAdapter.registerDataSetObserver(this.mObserver);
            if (listAdapter instanceof C16018h) {
                setDropListener((C16018h) listAdapter);
            }
            if (listAdapter instanceof C30813b) {
                setDragListener((C30813b) listAdapter);
            }
            if (listAdapter instanceof C30819l) {
                setRemoveListener((C30819l) listAdapter);
            }
        } else {
            this.zVq = null;
        }
        super.setAdapter(this.zVq);
        AppMethodBeat.m2505o(113062);
    }

    public ListAdapter getInputAdapter() {
        if (this.zVq == null) {
            return null;
        }
        return this.zVq.f1338Ei;
    }

    /* renamed from: a */
    private void m49185a(int i, Canvas canvas) {
        AppMethodBeat.m2504i(113063);
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
        AppMethodBeat.m2505o(113063);
    }

    /* Access modifiers changed, original: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.m2504i(113064);
        super.dispatchDraw(canvas);
        if (this.f13760SG != 0) {
            if (this.zUH != this.zUK) {
                m49185a(this.zUH, canvas);
            }
            if (!(this.zUI == this.zUH || this.zUI == this.zUK)) {
                m49185a(this.zUI, canvas);
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
        AppMethodBeat.m2505o(113064);
    }

    /* renamed from: Qs */
    private int m49177Qs(int i) {
        AppMethodBeat.m2504i(113065);
        View childAt = getChildAt(i - getFirstVisiblePosition());
        int height;
        if (childAt != null) {
            height = childAt.getHeight();
            AppMethodBeat.m2505o(113065);
            return height;
        }
        height = m49204hF(i, m49179Qu(i));
        AppMethodBeat.m2505o(113065);
        return height;
    }

    /* renamed from: hE */
    private int m49203hE(int i, int i2) {
        AppMethodBeat.m2504i(113066);
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            AppMethodBeat.m2505o(113066);
            return i2;
        }
        headerViewsCount = getDividerHeight();
        footerViewsCount = this.zUS - this.zUR;
        int Qu = m49179Qu(i);
        int Qs = m49177Qs(i);
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
            headerViewsCount = (((this.zUS - headerViewsCount) - m49179Qu(i - 1)) / 2) + i2;
        } else {
            headerViewsCount = (((Qu - headerViewsCount) - this.zUS) / 2) + i2;
        }
        AppMethodBeat.m2505o(113066);
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
        AppMethodBeat.m2504i(113067);
        int firstVisiblePosition = getFirstVisiblePosition();
        int i3 = this.zUH;
        View childAt = getChildAt(i3 - firstVisiblePosition);
        if (childAt == null) {
            i3 = firstVisiblePosition + (getChildCount() / 2);
            childAt = getChildAt(i3 - firstVisiblePosition);
        }
        int top = childAt.getTop();
        int height = childAt.getHeight();
        int hE = m49203hE(i3, top);
        int dividerHeight = getDividerHeight();
        if (this.zUC < hE) {
            i = hE;
            firstVisiblePosition = hE;
            i2 = i3;
            while (i2 >= 0) {
                i2--;
                i3 = m49177Qs(i2);
                if (i2 != 0) {
                    top -= i3 + dividerHeight;
                    i3 = m49203hE(i2, top);
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
                    hE = m49177Qs(i2 + 1);
                    i3 = m49203hE(i2 + 1, top);
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
            AppMethodBeat.m2505o(113067);
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
        AppMethodBeat.m2505o(113067);
        return z2;
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(113068);
        super.onDraw(canvas);
        if (this.zVr) {
            C30816f c30816f = this.zVs;
            if (c30816f.zVO) {
                int i;
                c30816f.mBuilder.append("<DSLVState>\n");
                int childCount = DragSortListView.this.getChildCount();
                int firstVisiblePosition = DragSortListView.this.getFirstVisiblePosition();
                c30816f.mBuilder.append("    <Positions>");
                for (i = 0; i < childCount; i++) {
                    c30816f.mBuilder.append(firstVisiblePosition + i).append(",");
                }
                c30816f.mBuilder.append("</Positions>\n");
                c30816f.mBuilder.append("    <Tops>");
                for (i = 0; i < childCount; i++) {
                    c30816f.mBuilder.append(DragSortListView.this.getChildAt(i).getTop()).append(",");
                }
                c30816f.mBuilder.append("</Tops>\n");
                c30816f.mBuilder.append("    <Bottoms>");
                for (i = 0; i < childCount; i++) {
                    c30816f.mBuilder.append(DragSortListView.this.getChildAt(i).getBottom()).append(",");
                }
                c30816f.mBuilder.append("</Bottoms>\n");
                c30816f.mBuilder.append("    <FirstExpPos>").append(DragSortListView.this.zUH).append("</FirstExpPos>\n");
                c30816f.mBuilder.append("    <FirstExpBlankHeight>").append(DragSortListView.this.m49177Qs(DragSortListView.this.zUH) - DragSortListView.this.m49179Qu(DragSortListView.this.zUH)).append("</FirstExpBlankHeight>\n");
                c30816f.mBuilder.append("    <SecondExpPos>").append(DragSortListView.this.zUI).append("</SecondExpPos>\n");
                c30816f.mBuilder.append("    <SecondExpBlankHeight>").append(DragSortListView.this.m49177Qs(DragSortListView.this.zUI) - DragSortListView.this.m49179Qu(DragSortListView.this.zUI)).append("</SecondExpBlankHeight>\n");
                c30816f.mBuilder.append("    <SrcPos>").append(DragSortListView.this.zUK).append("</SrcPos>\n");
                c30816f.mBuilder.append("    <SrcHeight>").append(DragSortListView.this.zUS + DragSortListView.this.getDividerHeight()).append("</SrcHeight>\n");
                c30816f.mBuilder.append("    <ViewHeight>").append(DragSortListView.this.getHeight()).append("</ViewHeight>\n");
                c30816f.mBuilder.append("    <LastY>").append(DragSortListView.this.itR).append("</LastY>\n");
                c30816f.mBuilder.append("    <FloatY>").append(DragSortListView.this.zUC).append("</FloatY>\n");
                c30816f.mBuilder.append("    <ShuffleEdges>");
                for (i = 0; i < childCount; i++) {
                    c30816f.mBuilder.append(DragSortListView.this.m49203hE(firstVisiblePosition + i, DragSortListView.this.getChildAt(i).getTop())).append(",");
                }
                c30816f.mBuilder.append("</ShuffleEdges>\n");
                c30816f.mBuilder.append("</DSLVState>\n");
                c30816f.zVM++;
                if (c30816f.zVM > 1000) {
                    c30816f.flush();
                    c30816f.zVM = 0;
                }
            }
        }
        AppMethodBeat.m2505o(113068);
    }

    public final void removeItem(int i) {
        AppMethodBeat.m2504i(113069);
        this.zVy = false;
        m49213q(i, 0.0f);
        AppMethodBeat.m2505o(113069);
    }

    /* renamed from: q */
    private void m49213q(int i, float f) {
        AppMethodBeat.m2504i(113070);
        if (this.f13760SG == 0 || this.f13760SG == 4) {
            if (this.f13760SG == 0) {
                this.zUK = getHeaderViewsCount() + i;
                this.zUH = this.zUK;
                this.zUI = this.zUK;
                this.zUG = this.zUK;
                View childAt = getChildAt(this.zUK - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.f13760SG = 1;
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
                AppMethodBeat.m2505o(113070);
                return;
            }
            m49178Qt(i);
        }
        AppMethodBeat.m2505o(113070);
    }

    public final void dLy() {
        AppMethodBeat.m2504i(113071);
        if (this.f13760SG == 4) {
            this.zUW.dLJ();
            dLI();
            dLz();
            dLE();
            if (this.zVk) {
                this.f13760SG = 3;
                AppMethodBeat.m2505o(113071);
                return;
            }
            this.f13760SG = 0;
        }
        AppMethodBeat.m2505o(113071);
    }

    private void dLz() {
        this.zUK = -1;
        this.zUH = -1;
        this.zUI = -1;
        this.zUG = -1;
    }

    private void dLA() {
        AppMethodBeat.m2504i(113072);
        this.f13760SG = 2;
        if (this.zUO != null && this.zUG >= 0 && this.zUG < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.zUO.mo17752dm(this.zUK - headerViewsCount, this.zUG - headerViewsCount);
        }
        dLI();
        dLB();
        dLz();
        dLE();
        if (this.zVk) {
            this.f13760SG = 3;
            AppMethodBeat.m2505o(113072);
            return;
        }
        this.f13760SG = 0;
        AppMethodBeat.m2505o(113072);
    }

    /* renamed from: Qt */
    private void m49178Qt(int i) {
        AppMethodBeat.m2504i(113073);
        this.f13760SG = 1;
        if (this.zUP != null) {
            this.zUP.remove(i);
        }
        dLI();
        dLB();
        dLz();
        if (this.zVk) {
            this.f13760SG = 3;
            AppMethodBeat.m2505o(113073);
            return;
        }
        this.f13760SG = 0;
        AppMethodBeat.m2505o(113073);
    }

    private void dLB() {
        int i = 0;
        AppMethodBeat.m2504i(113074);
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.zUK < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i - getPaddingTop());
        }
        AppMethodBeat.m2505o(113074);
    }

    /* renamed from: br */
    public final boolean mo49277br(float f) {
        AppMethodBeat.m2504i(113075);
        this.zVy = true;
        boolean b = m49192b(true, f);
        AppMethodBeat.m2505o(113075);
        return b;
    }

    /* renamed from: b */
    private boolean m49192b(boolean z, float f) {
        AppMethodBeat.m2504i(113076);
        if (this.iYn != null) {
            this.zUW.dLJ();
            if (z) {
                m49213q(this.zUK - getHeaderViewsCount(), f);
            } else if (this.zVx != null) {
                this.zVx.start();
            } else {
                dLA();
            }
            if (this.zVr) {
                this.zVs.stopTracking();
            }
            AppMethodBeat.m2505o(113076);
            return true;
        }
        AppMethodBeat.m2505o(113076);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(113077);
        if (this.zVu) {
            this.zVu = false;
            AppMethodBeat.m2505o(113077);
            return false;
        } else if (this.zUQ) {
            boolean z = this.zVj;
            this.zVj = false;
            if (!z) {
                m49180U(motionEvent);
            }
            if (this.f13760SG != 4) {
                if (this.f13760SG == 0 && super.onTouchEvent(motionEvent)) {
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
                    if (this.f13760SG == 4) {
                        this.zVy = false;
                        m49192b(false, 0.0f);
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
                    C30815d c30815d = this.zUW;
                    if (c30815d.zOp) {
                        x = c30815d.zVK;
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
                        this.zUW.mo49303Qv(0);
                        break;
                    }
                    if (x != -1) {
                        this.zUW.dLJ();
                    }
                    this.zUW.mo49303Qv(1);
                    break;
                    break;
                case 3:
                    if (this.f13760SG == 4) {
                        dLy();
                    }
                    dLC();
                    break;
            }
            z = true;
            AppMethodBeat.m2505o(113077);
            return z;
        } else {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(113077);
            return onTouchEvent;
        }
    }

    private void dLC() {
        AppMethodBeat.m2504i(113078);
        this.zVn = 0;
        this.zVk = false;
        if (this.f13760SG == 3) {
            this.f13760SG = 0;
        }
        this.zUF = this.zUE;
        this.zVA = false;
        this.zVv.clear();
        AppMethodBeat.m2505o(113078);
    }

    /* renamed from: U */
    private void m49180U(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(113079);
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            this.itQ = this.f13761iJ;
            this.itR = this.f13762iK;
        }
        this.f13761iJ = (int) motionEvent.getX();
        this.f13762iK = (int) motionEvent.getY();
        if (action == 0) {
            this.itQ = this.f13761iJ;
            this.itR = this.f13762iK;
        }
        this.mOffsetX = ((int) motionEvent.getRawX()) - this.f13761iJ;
        this.mOffsetY = ((int) motionEvent.getRawY()) - this.f13762iK;
        AppMethodBeat.m2505o(113079);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(113080);
        if (this.zUQ) {
            boolean z;
            m49180U(motionEvent);
            this.zVj = true;
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                if (this.f13760SG != 0) {
                    this.zVu = true;
                    AppMethodBeat.m2505o(113080);
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
            AppMethodBeat.m2505o(113080);
            return z;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.m2505o(113080);
        return onInterceptTouchEvent;
    }

    private void dLD() {
        AppMethodBeat.m2504i(113082);
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f = (float) height;
        this.zVc = ((float) paddingTop) + (this.zUX * f);
        this.zVb = (f * (1.0f - this.zUY)) + ((float) paddingTop);
        this.zUZ = (int) this.zVc;
        this.zVa = (int) this.zVb;
        this.zVd = this.zVc - ((float) paddingTop);
        this.zVe = ((float) (paddingTop + height)) - this.zVb;
        AppMethodBeat.m2505o(113082);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(113083);
        super.onSizeChanged(i, i2, i3, i4);
        dLD();
        AppMethodBeat.m2505o(113083);
    }

    private void dLE() {
        AppMethodBeat.m2504i(113084);
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        lastVisiblePosition = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= lastVisiblePosition; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                m49186a(firstVisiblePosition + max, childAt, false);
            }
        }
        AppMethodBeat.m2505o(113084);
    }

    /* renamed from: a */
    private void m49186a(int i, View view, boolean z) {
        int c;
        AppMethodBeat.m2504i(113085);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i == this.zUK || i == this.zUH || i == this.zUI) {
            c = m49193c(i, view, z);
        } else {
            c = -2;
        }
        if (c != layoutParams.height) {
            layoutParams.height = c;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.zUH || i == this.zUI) {
            if (i < this.zUK) {
                ((C46703b) view).setGravity(80);
            } else if (i > this.zUK) {
                ((C46703b) view).setGravity(48);
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
        AppMethodBeat.m2505o(113085);
    }

    /* renamed from: Qu */
    private int m49179Qu(int i) {
        AppMethodBeat.m2504i(113086);
        if (i == this.zUK) {
            AppMethodBeat.m2505o(113086);
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        int b;
        if (childAt != null) {
            b = m49189b(i, childAt, false);
            AppMethodBeat.m2505o(113086);
            return b;
        }
        b = this.zVv.get(i);
        if (b != -1) {
            AppMethodBeat.m2505o(113086);
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
        b = m49189b(i, view, true);
        this.zVv.add(i, b);
        AppMethodBeat.m2505o(113086);
        return b;
    }

    /* renamed from: b */
    private int m49189b(int i, View view, boolean z) {
        AppMethodBeat.m2504i(113087);
        if (i == this.zUK) {
            AppMethodBeat.m2505o(113087);
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
                m49200fq(view);
                height = view.getMeasuredHeight();
            }
            AppMethodBeat.m2505o(113087);
            return height;
        }
        height = layoutParams.height;
        AppMethodBeat.m2505o(113087);
        return height;
    }

    /* renamed from: c */
    private int m49193c(int i, View view, boolean z) {
        AppMethodBeat.m2504i(113088);
        int hF = m49204hF(i, m49189b(i, view, z));
        AppMethodBeat.m2505o(113088);
        return hF;
    }

    /* renamed from: hF */
    private int m49204hF(int i, int i2) {
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
        AppMethodBeat.m2504i(113089);
        if (!this.zVt) {
            super.requestLayout();
        }
        AppMethodBeat.m2505o(113089);
    }

    /* renamed from: a */
    private int m49183a(int i, View view, int i2, int i3) {
        int i4;
        AppMethodBeat.m2504i(113090);
        int Qu = m49179Qu(i);
        int height = view.getHeight();
        int hF = m49204hF(i, Qu);
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
        AppMethodBeat.m2505o(113090);
        return Qu;
    }

    /* renamed from: fq */
    private void m49200fq(View view) {
        int makeMeasureSpec;
        AppMethodBeat.m2504i(113091);
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
        AppMethodBeat.m2505o(113091);
    }

    private void dLF() {
        AppMethodBeat.m2504i(113092);
        if (this.iYn != null) {
            m49200fq(this.iYn);
            this.zUS = this.iYn.getMeasuredHeight();
            this.zUT = this.zUS / 2;
        }
        AppMethodBeat.m2505o(113092);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(113093);
        super.onMeasure(i, i2);
        if (this.iYn != null) {
            if (this.iYn.isLayoutRequested()) {
                dLF();
            }
            this.zUD = true;
        }
        this.zUU = i;
        AppMethodBeat.m2505o(113093);
    }

    /* Access modifiers changed, original: protected */
    public void layoutChildren() {
        AppMethodBeat.m2504i(113094);
        super.layoutChildren();
        if (this.iYn != null) {
            if (this.iYn.isLayoutRequested() && !this.zUD) {
                dLF();
            }
            this.iYn.layout(0, 0, this.iYn.getMeasuredWidth(), this.iYn.getMeasuredHeight());
            this.zUD = false;
        }
        AppMethodBeat.m2505o(113094);
    }

    /* renamed from: a */
    public final boolean mo49276a(int i, View view, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(113095);
        if (this.f13760SG == 0 && this.zVk && this.iYn == null && view != null && this.zUQ) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            int headerViewsCount = getHeaderViewsCount() + i;
            this.zUH = headerViewsCount;
            this.zUI = headerViewsCount;
            this.zUK = headerViewsCount;
            this.zUG = headerViewsCount;
            this.f13760SG = 4;
            this.zVi = 0;
            this.zVi |= i2;
            this.iYn = view;
            dLF();
            this.zUL = i3;
            this.zUM = i4;
            this.zVh = this.f13762iK;
            this.zUA.x = this.f13761iJ - this.zUL;
            this.zUA.y = this.f13762iK - this.zUM;
            View childAt = getChildAt(this.zUK - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setVisibility(4);
            }
            if (this.zVr) {
                C30816f c30816f = this.zVs;
                c30816f.mBuilder.append("<DSLVStates>\n");
                c30816f.zVN = 0;
                c30816f.zVO = true;
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
            AppMethodBeat.m2505o(113095);
            return true;
        }
        AppMethodBeat.m2505o(113095);
        return false;
    }

    private void dLG() {
        AppMethodBeat.m2504i(113096);
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt == null) {
            AppMethodBeat.m2505o(113096);
            return;
        }
        m49197d(firstVisiblePosition, childAt, true);
        AppMethodBeat.m2505o(113096);
    }

    /* renamed from: d */
    private void m49197d(int i, View view, boolean z) {
        AppMethodBeat.m2504i(113097);
        this.zVt = true;
        dLH();
        int i2 = this.zUH;
        int i3 = this.zUI;
        boolean dLx = dLx();
        if (dLx) {
            dLE();
            setSelectionFromTop(i, (m49183a(i, view, i2, i3) + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        if (dLx || z) {
            invalidate();
        }
        this.zVt = false;
        AppMethodBeat.m2505o(113097);
    }

    private void dLH() {
        AppMethodBeat.m2504i(113098);
        if (this.zVl != null) {
            this.zUB.set(this.f13761iJ, this.f13762iK);
            this.zVl.mo28384h(this.zUA);
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
        AppMethodBeat.m2505o(113098);
    }

    private void dLI() {
        AppMethodBeat.m2504i(113099);
        if (this.iYn != null) {
            this.iYn.setVisibility(8);
            if (this.zVl != null) {
                this.zVl.mo28383fr(this.iYn);
            }
            this.iYn = null;
            invalidate();
        }
        AppMethodBeat.m2505o(113099);
    }

    public void setFloatViewManager(C16019i c16019i) {
        this.zVl = c16019i;
    }

    public void setDragListener(C30813b c30813b) {
        this.zUN = c30813b;
    }

    public void setDragEnabled(boolean z) {
        this.zUQ = z;
    }

    public void setDropListener(C16018h c16018h) {
        this.zUO = c16018h;
    }

    public void setRemoveListener(C30819l c30819l) {
        this.zUP = c30819l;
    }

    public void setDragSortListener(C30817e c30817e) {
        AppMethodBeat.m2504i(113100);
        setDropListener(c30817e);
        setDragListener(c30817e);
        setRemoveListener(c30817e);
        AppMethodBeat.m2505o(113100);
    }

    public void setDragScrollProfile(C30814c c30814c) {
        if (c30814c != null) {
            this.zVg = c30814c;
        }
    }

    public void setDragScrollStart(float f) {
        AppMethodBeat.m2504i(113081);
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
        AppMethodBeat.m2505o(113081);
    }

    /* renamed from: q */
    static /* synthetic */ void m49214q(DragSortListView dragSortListView) {
        AppMethodBeat.m2504i(113107);
        dragSortListView.m49178Qt(dragSortListView.zUK - dragSortListView.getHeaderViewsCount());
        AppMethodBeat.m2505o(113107);
    }
}
