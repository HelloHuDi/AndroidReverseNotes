package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecentAppBrandView extends RecyclerView implements OnGestureListener {
    private android.support.v7.widget.RecyclerView.a Yq = null;
    List<c> iJL = new ArrayList();
    private int iWJ = 0;
    private com.tencent.mm.plugin.appbrand.widget.recentview.b iXE;
    private boolean iYA = false;
    List<c> iYF = new ArrayList();
    private ArrayList<v> iYG = new ArrayList();
    private GridLayoutManager iYH = null;
    private int iYI = 0;
    private f iYJ;
    int iYK = 10;
    boolean iYL = true;
    private b iYM;
    private boolean iYN = false;
    private GestureDetector iay;

    public interface b {
        void a(c cVar, int i);
    }

    class a extends android.support.v7.widget.RecyclerView.a<e> {
        a() {
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(133932);
            int i2 = RecentAppBrandView.a(RecentAppBrandView.this, i).type;
            AppMethodBeat.o(133932);
            return i2;
        }

        public final int getItemCount() {
            AppMethodBeat.i(133933);
            int size = RecentAppBrandView.this.iYF.size();
            AppMethodBeat.o(133933);
            return size;
        }
    }

    public RecentAppBrandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(133936);
        init(context);
        AppMethodBeat.o(133936);
    }

    public RecentAppBrandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(133937);
        init(context);
        AppMethodBeat.o(133937);
    }

    public void setItemPadding(int i) {
        this.iWJ = i;
    }

    public void setOnItemClickListener(b bVar) {
        this.iYM = bVar;
    }

    public void setDataList(List<c> list) {
        int i = 4;
        AppMethodBeat.i(133938);
        this.iJL = list;
        this.iYF.clear();
        if (this.iJL.size() != 4) {
            i = 3;
        }
        int i2 = 0;
        while (i2 < this.iJL.size() && i2 < i) {
            this.iYF.add(this.iJL.get(i2));
            i2++;
        }
        this.iYL = true;
        ab.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showList: %d", Integer.valueOf(this.iJL.size()), Integer.valueOf(this.iYF.size()));
        AppMethodBeat.o(133938);
    }

    public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b bVar) {
        this.iXE = bVar;
    }

    private void init(Context context) {
        AppMethodBeat.i(133939);
        this.iYH = new GridLayoutManager(4, (byte) 0);
        setLayoutManager(this.iYH);
        this.Yq = new a();
        setAdapter(this.Yq);
        this.iay = new GestureDetector(context, this);
        this.iYJ = new f();
        this.iYJ.Yq = this.Yq;
        setItemAnimator(this.iYJ);
        AppMethodBeat.o(133939);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(133940);
        if (motionEvent.getAction() == 0) {
            this.iYA = false;
            a(motionEvent, true);
        } else if (motionEvent.getAction() != 2) {
            Iterator it = this.iYG.iterator();
            while (it.hasNext()) {
                ((v) it.next()).apJ.setPressed(false);
            }
            this.iYG.clear();
        }
        this.iay.onTouchEvent(motionEvent);
        if (this.iYA) {
            AppMethodBeat.o(133940);
            return false;
        }
        AppMethodBeat.o(133940);
        return true;
    }

    private void a(MotionEvent motionEvent, boolean z) {
        AppMethodBeat.i(133941);
        if (z == this.iYN) {
            AppMethodBeat.o(133941);
            return;
        }
        View x = x(motionEvent.getX(), motionEvent.getY());
        if (x != null) {
            v bm = bm(x);
            if (bm != null) {
                bm.apJ.setPressed(z);
                if (z) {
                    ab.i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
                    this.iYG.add(bm);
                } else {
                    ab.i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
                    this.iYG.remove(bm);
                }
            }
        }
        this.iYN = z;
        AppMethodBeat.o(133941);
    }

    public boolean canScrollHorizontally(int i) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(133942);
        ab.i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
        AppMethodBeat.o(133942);
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(133943);
        View x = x(motionEvent.getX(), motionEvent.getY());
        if (x != null) {
            v bm = bm(x);
            if (bm != null) {
                bm.apJ.performClick();
            }
        }
        AppMethodBeat.o(133943);
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(133944);
        this.iYA = true;
        a(motionEvent, false);
        AppMethodBeat.o(133944);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void aPw() {
        AppMethodBeat.i(133945);
        if (getAdapter() != null) {
            getAdapter().aop.notifyChanged();
        }
        AppMethodBeat.o(133945);
    }

    public List<c> getShowList() {
        return this.iYF;
    }

    public List<c> getDataList() {
        return this.iJL;
    }

    public int getShowCount() {
        AppMethodBeat.i(133946);
        int size = this.iYF.size();
        AppMethodBeat.o(133946);
        return size;
    }

    public int getDataCount() {
        AppMethodBeat.i(133947);
        int size = this.iJL.size();
        AppMethodBeat.o(133947);
        return size;
    }

    public final c qn(int i) {
        AppMethodBeat.i(133948);
        c cVar = (c) this.iJL.get(i);
        AppMethodBeat.o(133948);
        return cVar;
    }
}
