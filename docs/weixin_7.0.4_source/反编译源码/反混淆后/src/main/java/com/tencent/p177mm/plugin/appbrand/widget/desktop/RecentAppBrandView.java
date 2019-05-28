package com.tencent.p177mm.plugin.appbrand.widget.desktop;

import android.content.Context;
import android.support.p069v7.widget.GridLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.C19835c;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19916b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView */
public class RecentAppBrandView extends RecyclerView implements OnGestureListener {
    /* renamed from: Yq */
    private C41523a f2883Yq = null;
    List<C19835c> iJL = new ArrayList();
    private int iWJ = 0;
    private C19916b iXE;
    private boolean iYA = false;
    List<C19835c> iYF = new ArrayList();
    private ArrayList<C41531v> iYG = new ArrayList();
    private GridLayoutManager iYH = null;
    private int iYI = 0;
    private C42710f iYJ;
    int iYK = 10;
    boolean iYL = true;
    private C10948b iYM;
    private boolean iYN = false;
    private GestureDetector iay;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView$b */
    public interface C10948b {
        /* renamed from: a */
        void mo22530a(C19835c c19835c, int i);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.RecentAppBrandView$a */
    class C10949a extends C41523a<C46898e> {
        C10949a() {
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(133932);
            int i2 = RecentAppBrandView.m18679a(RecentAppBrandView.this, i).type;
            AppMethodBeat.m2505o(133932);
            return i2;
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(133933);
            int size = RecentAppBrandView.this.iYF.size();
            AppMethodBeat.m2505o(133933);
            return size;
        }
    }

    public RecentAppBrandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(133936);
        init(context);
        AppMethodBeat.m2505o(133936);
    }

    public RecentAppBrandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(133937);
        init(context);
        AppMethodBeat.m2505o(133937);
    }

    public void setItemPadding(int i) {
        this.iWJ = i;
    }

    public void setOnItemClickListener(C10948b c10948b) {
        this.iYM = c10948b;
    }

    public void setDataList(List<C19835c> list) {
        int i = 4;
        AppMethodBeat.m2504i(133938);
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
        C4990ab.m7417i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView mDataList: %d, showList: %d", Integer.valueOf(this.iJL.size()), Integer.valueOf(this.iYF.size()));
        AppMethodBeat.m2505o(133938);
    }

    public void setReporter(C19916b c19916b) {
        this.iXE = c19916b;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(133939);
        this.iYH = new GridLayoutManager(4, (byte) 0);
        setLayoutManager(this.iYH);
        this.f2883Yq = new C10949a();
        setAdapter(this.f2883Yq);
        this.iay = new GestureDetector(context, this);
        this.iYJ = new C42710f();
        this.iYJ.f17188Yq = this.f2883Yq;
        setItemAnimator(this.iYJ);
        AppMethodBeat.m2505o(133939);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133940);
        if (motionEvent.getAction() == 0) {
            this.iYA = false;
            m18680a(motionEvent, true);
        } else if (motionEvent.getAction() != 2) {
            Iterator it = this.iYG.iterator();
            while (it.hasNext()) {
                ((C41531v) it.next()).apJ.setPressed(false);
            }
            this.iYG.clear();
        }
        this.iay.onTouchEvent(motionEvent);
        if (this.iYA) {
            AppMethodBeat.m2505o(133940);
            return false;
        }
        AppMethodBeat.m2505o(133940);
        return true;
    }

    /* renamed from: a */
    private void m18680a(MotionEvent motionEvent, boolean z) {
        AppMethodBeat.m2504i(133941);
        if (z == this.iYN) {
            AppMethodBeat.m2505o(133941);
            return;
        }
        View x = mo66441x(motionEvent.getX(), motionEvent.getY());
        if (x != null) {
            C41531v bm = mo66351bm(x);
            if (bm != null) {
                bm.apJ.setPressed(z);
                if (z) {
                    C4990ab.m7416i("MicroMsg.RecentAppBrandView", "alvinluo add pressed item");
                    this.iYG.add(bm);
                } else {
                    C4990ab.m7416i("MicroMsg.RecentAppBrandView", "alvinluo remove pressed item");
                    this.iYG.remove(bm);
                }
            }
        }
        this.iYN = z;
        AppMethodBeat.m2505o(133941);
    }

    public boolean canScrollHorizontally(int i) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133942);
        C4990ab.m7416i("MicroMsg.RecentAppBrandView", "alvinluo RecentAppBrandView onDown");
        AppMethodBeat.m2505o(133942);
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133943);
        View x = mo66441x(motionEvent.getX(), motionEvent.getY());
        if (x != null) {
            C41531v bm = mo66351bm(x);
            if (bm != null) {
                bm.apJ.performClick();
            }
        }
        AppMethodBeat.m2505o(133943);
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(133944);
        this.iYA = true;
        m18680a(motionEvent, false);
        AppMethodBeat.m2505o(133944);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public final void aPw() {
        AppMethodBeat.m2504i(133945);
        if (getAdapter() != null) {
            getAdapter().aop.notifyChanged();
        }
        AppMethodBeat.m2505o(133945);
    }

    public List<C19835c> getShowList() {
        return this.iYF;
    }

    public List<C19835c> getDataList() {
        return this.iJL;
    }

    public int getShowCount() {
        AppMethodBeat.m2504i(133946);
        int size = this.iYF.size();
        AppMethodBeat.m2505o(133946);
        return size;
    }

    public int getDataCount() {
        AppMethodBeat.m2504i(133947);
        int size = this.iJL.size();
        AppMethodBeat.m2505o(133947);
        return size;
    }

    /* renamed from: qn */
    public final C19835c mo22545qn(int i) {
        AppMethodBeat.m2504i(133948);
        C19835c c19835c = (C19835c) this.iJL.get(i);
        AppMethodBeat.m2505o(133948);
        return c19835c;
    }
}
