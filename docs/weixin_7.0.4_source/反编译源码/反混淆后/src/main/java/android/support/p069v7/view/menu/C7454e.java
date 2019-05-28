package android.support.p069v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.p057v4.view.C0456d;
import android.support.p057v4.view.C0477s;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.widget.C0681ab;
import android.support.p069v7.widget.C0688aj;
import android.support.p069v7.widget.C7461ak;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.p177mm.C25738R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.view.menu.e */
final class C7454e extends C6244m implements C0628o, OnKeyListener, OnDismissListener {
    /* renamed from: TO */
    private boolean f2098TO;
    private final OnAttachStateChangeListener aaA = new C06182();
    private final C0688aj aaB = new C62343();
    private int aaC = 0;
    private int aaD = 0;
    View aaE;
    private int aaF;
    private boolean aaG;
    private boolean aaH;
    private int aaI;
    private int aaJ;
    private boolean aaK;
    private C0627a aaL;
    private ViewTreeObserver aaM;
    private OnDismissListener aaN;
    boolean aaO;
    private final int aas;
    private final int aat;
    private final int aau;
    private final boolean aav;
    final Handler aaw;
    private final List<C6236h> aax = new ArrayList();
    final List<C0620a> aay = new ArrayList();
    private final OnGlobalLayoutListener aaz = new C06171();
    private final Context mContext;
    /* renamed from: pP */
    private View f2099pP;

    /* renamed from: android.support.v7.view.menu.e$1 */
    class C06171 implements OnGlobalLayoutListener {
        C06171() {
        }

        public final void onGlobalLayout() {
            if (C7454e.this.isShowing() && C7454e.this.aay.size() > 0 && !((C0620a) C7454e.this.aay.get(0)).aaU.amG) {
                View view = C7454e.this.aaE;
                if (view == null || !view.isShown()) {
                    C7454e.this.dismiss();
                    return;
                }
                for (C0620a c0620a : C7454e.this.aay) {
                    c0620a.aaU.show();
                }
            }
        }
    }

    /* renamed from: android.support.v7.view.menu.e$2 */
    class C06182 implements OnAttachStateChangeListener {
        C06182() {
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (C7454e.this.aaM != null) {
                if (!C7454e.this.aaM.isAlive()) {
                    C7454e.this.aaM = view.getViewTreeObserver();
                }
                C7454e.this.aaM.removeGlobalOnLayoutListener(C7454e.this.aaz);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: android.support.v7.view.menu.e$a */
    static class C0620a {
        /* renamed from: VK */
        public final C6236h f995VK;
        public final C7461ak aaU;
        public final int position;

        public C0620a(C7461ak c7461ak, C6236h c6236h, int i) {
            this.aaU = c7461ak;
            this.f995VK = c6236h;
            this.position = i;
        }
    }

    /* renamed from: android.support.v7.view.menu.e$3 */
    class C62343 implements C0688aj {
        C62343() {
        }

        /* renamed from: b */
        public final void mo1955b(C6236h c6236h, MenuItem menuItem) {
            C7454e.this.aaw.removeCallbacksAndMessages(c6236h);
        }

        /* renamed from: c */
        public final void mo1956c(final C6236h c6236h, final MenuItem menuItem) {
            int i;
            C7454e.this.aaw.removeCallbacksAndMessages(null);
            int size = C7454e.this.aay.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c6236h == ((C0620a) C7454e.this.aay.get(i2)).f995VK) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                C0620a c0620a;
                i++;
                if (i < C7454e.this.aay.size()) {
                    c0620a = (C0620a) C7454e.this.aay.get(i);
                } else {
                    c0620a = null;
                }
                C7454e.this.aaw.postAtTime(new Runnable() {
                    public final void run() {
                        if (c0620a != null) {
                            C7454e.this.aaO = true;
                            c0620a.f995VK.mo14110U(false);
                            C7454e.this.aaO = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            c6236h.mo14116a(menuItem, null, 4);
                        }
                    }
                }, c6236h, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    public C7454e(Context context, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.f2099pP = view;
        this.aat = i;
        this.aau = i2;
        this.aav = z;
        this.aaK = false;
        this.aaF = m12780gp();
        Resources resources = context.getResources();
        this.aas = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C25738R.dimen.f9648a6));
        this.aaw = new Handler();
    }

    public final void setForceShowIcon(boolean z) {
        this.aaK = z;
    }

    /* renamed from: go */
    private C7461ak m12779go() {
        C7461ak c7461ak = new C7461ak(this.mContext, this.aat, this.aau);
        c7461ak.amK = this.aaB;
        c7461ak.amz = this;
        c7461ak.setOnDismissListener(this);
        c7461ak.amx = this.f2099pP;
        c7461ak.aaD = this.aaD;
        c7461ak.setModal(true);
        c7461ak.mo14390iZ();
        return c7461ak;
    }

    public final void show() {
        if (!isShowing()) {
            for (C6236h g : this.aax) {
                m12778g(g);
            }
            this.aax.clear();
            this.aaE = this.f2099pP;
            if (this.aaE != null) {
                Object obj = this.aaM == null ? 1 : null;
                this.aaM = this.aaE.getViewTreeObserver();
                if (obj != null) {
                    this.aaM.addOnGlobalLayoutListener(this.aaz);
                }
                this.aaE.addOnAttachStateChangeListener(this.aaA);
            }
        }
    }

    public final void dismiss() {
        int size = this.aay.size();
        if (size > 0) {
            C0620a[] c0620aArr = (C0620a[]) this.aay.toArray(new C0620a[size]);
            for (size--; size >= 0; size--) {
                C0620a c0620a = c0620aArr[size];
                if (c0620a.aaU.amH.isShowing()) {
                    c0620a.aaU.dismiss();
                }
            }
        }
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    /* renamed from: gp */
    private int m12780gp() {
        if (C0477s.m893T(this.f2099pP) == 1) {
            return 0;
        }
        return 1;
    }

    /* renamed from: bq */
    private int m12777bq(int i) {
        C0681ab c0681ab = ((C0620a) this.aay.get(this.aay.size() - 1)).aaU.amk;
        int[] iArr = new int[2];
        c0681ab.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.aaE.getWindowVisibleDisplayFrame(rect);
        if (this.aaF == 1) {
            if ((c0681ab.getWidth() + iArr[0]) + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    /* renamed from: f */
    public final void mo14219f(C6236h c6236h) {
        c6236h.mo14115a((C0628o) this, this.mContext);
        if (isShowing()) {
            m12778g(c6236h);
        } else {
            this.aax.add(c6236h);
        }
    }

    /* renamed from: g */
    private void m12778g(C6236h c6236h) {
        View a;
        C0620a c0620a;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        C0622g c0622g = new C0622g(c6236h, from, this.aav);
        if (!isShowing() && this.aaK) {
            c0622g.aaK = true;
        } else if (isShowing()) {
            c0622g.aaK = C6244m.m10140h(c6236h);
        }
        int a2 = C6244m.m10138a(c0622g, null, this.mContext, this.aas);
        C7461ak go = m12779go();
        go.setAdapter(c0622g);
        go.setContentWidth(a2);
        go.aaD = this.aaD;
        if (this.aay.size() > 0) {
            C0620a c0620a2 = (C0620a) this.aay.get(this.aay.size() - 1);
            a = C7454e.m12773a(c0620a2, c6236h);
            c0620a = c0620a2;
        } else {
            a = null;
            Object c0620a3 = null;
        }
        if (a != null) {
            boolean z;
            int i;
            int i2;
            go.mo16485jc();
            go.mo16484jb();
            int bq = m12777bq(a2);
            if (bq == 1) {
                z = true;
            } else {
                z = false;
            }
            this.aaF = bq;
            if (VERSION.SDK_INT >= 26) {
                go.amx = a;
                i = 0;
                bq = 0;
            } else {
                int[] iArr = new int[2];
                this.f2099pP.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                a.getLocationOnScreen(iArr2);
                if ((this.aaD & 7) == 5) {
                    iArr[0] = iArr[0] + this.f2099pP.getWidth();
                    iArr2[0] = iArr2[0] + a.getWidth();
                }
                bq = iArr2[0] - iArr[0];
                i = iArr2[1] - iArr[1];
            }
            if ((this.aaD & 5) == 5) {
                if (z) {
                    i2 = bq + a2;
                } else {
                    i2 = bq - a.getWidth();
                }
            } else if (z) {
                i2 = a.getWidth() + bq;
            } else {
                i2 = bq - a2;
            }
            go.amm = i2;
            go.mo14392ja();
            go.setVerticalOffset(i);
        } else {
            if (this.aaG) {
                go.amm = this.aaI;
            }
            if (this.aaH) {
                go.setVerticalOffset(this.aaJ);
            }
            go.ach = this.ach;
        }
        this.aay.add(new C0620a(go, c6236h, this.aaF));
        go.show();
        C0681ab c0681ab = go.amk;
        c0681ab.setOnKeyListener(this);
        if (c0620a3 == null && this.f2098TO && c6236h.abz != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(2130968601, c0681ab, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(c6236h.abz);
            c0681ab.addHeaderView(frameLayout, null, false);
            go.show();
        }
    }

    /* renamed from: a */
    private static MenuItem m12772a(C6236h c6236h, C6236h c6236h2) {
        int size = c6236h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c6236h.getItem(i);
            if (item.hasSubMenu() && c6236h2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static View m12773a(C0620a c0620a, C6236h c6236h) {
        int i = 0;
        MenuItem a = C7454e.m12772a(c0620a.f995VK, c6236h);
        if (a == null) {
            return null;
        }
        int headersCount;
        C0622g c0622g;
        int i2;
        C0681ab c0681ab = c0620a.aaU.amk;
        ListAdapter adapter = c0681ab.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0622g = (C0622g) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0622g = (C0622g) adapter;
            headersCount = 0;
        }
        int count = c0622g.getCount();
        while (i < count) {
            if (a == c0622g.getItem(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - c0681ab.getFirstVisiblePosition();
        if (i2 < 0 || i2 >= c0681ab.getChildCount()) {
            return null;
        }
        return c0681ab.getChildAt(i2);
    }

    public final boolean isShowing() {
        return this.aay.size() > 0 && ((C0620a) this.aay.get(0)).aaU.amH.isShowing();
    }

    public final void onDismiss() {
        C0620a c0620a;
        int size = this.aay.size();
        for (int i = 0; i < size; i++) {
            c0620a = (C0620a) this.aay.get(i);
            if (!c0620a.aaU.amH.isShowing()) {
                break;
            }
        }
        c0620a = null;
        if (c0620a != null) {
            c0620a.f995VK.mo14110U(false);
        }
    }

    /* renamed from: n */
    public final void mo1606n(boolean z) {
        for (C0620a c0620a : this.aay) {
            C6244m.m10139a(c0620a.aaU.amk.getAdapter()).notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public final void mo1600a(C0627a c0627a) {
        this.aaL = c0627a;
    }

    /* renamed from: a */
    public final boolean mo1601a(C7459u c7459u) {
        for (C0620a c0620a : this.aay) {
            if (c7459u == c0620a.f995VK) {
                c0620a.aaU.amk.requestFocus();
                return true;
            }
        }
        if (!c7459u.hasVisibleItems()) {
            return false;
        }
        mo14219f(c7459u);
        if (this.aaL != null) {
            this.aaL.mo1597d(c7459u);
        }
        return true;
    }

    /* renamed from: a */
    public final void mo1599a(C6236h c6236h, boolean z) {
        int size = this.aay.size();
        int i = 0;
        while (i < size) {
            if (c6236h == ((C0620a) this.aay.get(i)).f995VK) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            int i2 = i + 1;
            if (i2 < this.aay.size()) {
                ((C0620a) this.aay.get(i2)).f995VK.mo14110U(false);
            }
            C0620a c0620a = (C0620a) this.aay.remove(i);
            c0620a.f995VK.mo14126b(this);
            if (this.aaO) {
                C7461ak c7461ak = c0620a.aaU;
                if (VERSION.SDK_INT >= 23) {
                    c7461ak.amH.setExitTransition(null);
                }
                c0620a.aaU.setAnimationStyle(0);
            }
            c0620a.aaU.dismiss();
            i = this.aay.size();
            if (i > 0) {
                this.aaF = ((C0620a) this.aay.get(i - 1)).position;
            } else {
                this.aaF = m12780gp();
            }
            if (i == 0) {
                dismiss();
                if (this.aaL != null) {
                    this.aaL.mo1596a(c6236h, true);
                }
                if (this.aaM != null) {
                    if (this.aaM.isAlive()) {
                        this.aaM.removeGlobalOnLayoutListener(this.aaz);
                    }
                    this.aaM = null;
                }
                this.aaE.removeOnAttachStateChangeListener(this.aaA);
                this.aaN.onDismiss();
            } else if (z) {
                ((C0620a) this.aay.get(0)).f995VK.mo14110U(false);
            }
        }
    }

    /* renamed from: bt */
    public final boolean mo1603bt() {
        return false;
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }

    public final void setGravity(int i) {
        if (this.aaC != i) {
            this.aaC = i;
            this.aaD = C0456d.getAbsoluteGravity(i, C0477s.m893T(this.f2099pP));
        }
    }

    public final void setAnchorView(View view) {
        if (this.f2099pP != view) {
            this.f2099pP = view;
            this.aaD = C0456d.getAbsoluteGravity(this.aaC, C0477s.m893T(this.f2099pP));
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.aaN = onDismissListener;
    }

    public final ListView getListView() {
        if (this.aay.isEmpty()) {
            return null;
        }
        return ((C0620a) this.aay.get(this.aay.size() - 1)).aaU.amk;
    }

    public final void setHorizontalOffset(int i) {
        this.aaG = true;
        this.aaI = i;
    }

    public final void setVerticalOffset(int i) {
        this.aaH = true;
        this.aaJ = i;
    }

    public final void setShowTitle(boolean z) {
        this.f2098TO = z;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: gq */
    public final boolean mo14220gq() {
        return false;
    }
}
