package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.d;
import android.support.v4.view.s;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
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
import com.tencent.mm.R;
import java.util.ArrayList;
import java.util.List;

final class e extends m implements o, OnKeyListener, OnDismissListener {
    private boolean TO;
    private final OnAttachStateChangeListener aaA = new OnAttachStateChangeListener() {
        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            if (e.this.aaM != null) {
                if (!e.this.aaM.isAlive()) {
                    e.this.aaM = view.getViewTreeObserver();
                }
                e.this.aaM.removeGlobalOnLayoutListener(e.this.aaz);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final aj aaB = new aj() {
        public final void b(h hVar, MenuItem menuItem) {
            e.this.aaw.removeCallbacksAndMessages(hVar);
        }

        public final void c(final h hVar, final MenuItem menuItem) {
            int i;
            e.this.aaw.removeCallbacksAndMessages(null);
            int size = e.this.aay.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (hVar == ((a) e.this.aay.get(i2)).VK) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                a aVar;
                i++;
                if (i < e.this.aay.size()) {
                    aVar = (a) e.this.aay.get(i);
                } else {
                    aVar = null;
                }
                e.this.aaw.postAtTime(new Runnable() {
                    public final void run() {
                        if (aVar != null) {
                            e.this.aaO = true;
                            aVar.VK.U(false);
                            e.this.aaO = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            hVar.a(menuItem, null, 4);
                        }
                    }
                }, hVar, SystemClock.uptimeMillis() + 200);
            }
        }
    };
    private int aaC = 0;
    private int aaD = 0;
    View aaE;
    private int aaF;
    private boolean aaG;
    private boolean aaH;
    private int aaI;
    private int aaJ;
    private boolean aaK;
    private android.support.v7.view.menu.o.a aaL;
    private ViewTreeObserver aaM;
    private OnDismissListener aaN;
    boolean aaO;
    private final int aas;
    private final int aat;
    private final int aau;
    private final boolean aav;
    final Handler aaw;
    private final List<h> aax = new ArrayList();
    final List<a> aay = new ArrayList();
    private final OnGlobalLayoutListener aaz = new OnGlobalLayoutListener() {
        public final void onGlobalLayout() {
            if (e.this.isShowing() && e.this.aay.size() > 0 && !((a) e.this.aay.get(0)).aaU.amG) {
                View view = e.this.aaE;
                if (view == null || !view.isShown()) {
                    e.this.dismiss();
                    return;
                }
                for (a aVar : e.this.aay) {
                    aVar.aaU.show();
                }
            }
        }
    };
    private final Context mContext;
    private View pP;

    static class a {
        public final h VK;
        public final ak aaU;
        public final int position;

        public a(ak akVar, h hVar, int i) {
            this.aaU = akVar;
            this.VK = hVar;
            this.position = i;
        }
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.pP = view;
        this.aat = i;
        this.aau = i2;
        this.aav = z;
        this.aaK = false;
        this.aaF = gp();
        Resources resources = context.getResources();
        this.aas = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.a6));
        this.aaw = new Handler();
    }

    public final void setForceShowIcon(boolean z) {
        this.aaK = z;
    }

    private ak go() {
        ak akVar = new ak(this.mContext, this.aat, this.aau);
        akVar.amK = this.aaB;
        akVar.amz = this;
        akVar.setOnDismissListener(this);
        akVar.amx = this.pP;
        akVar.aaD = this.aaD;
        akVar.setModal(true);
        akVar.iZ();
        return akVar;
    }

    public final void show() {
        if (!isShowing()) {
            for (h g : this.aax) {
                g(g);
            }
            this.aax.clear();
            this.aaE = this.pP;
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
            a[] aVarArr = (a[]) this.aay.toArray(new a[size]);
            for (size--; size >= 0; size--) {
                a aVar = aVarArr[size];
                if (aVar.aaU.amH.isShowing()) {
                    aVar.aaU.dismiss();
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

    private int gp() {
        if (s.T(this.pP) == 1) {
            return 0;
        }
        return 1;
    }

    private int bq(int i) {
        ab abVar = ((a) this.aay.get(this.aay.size() - 1)).aaU.amk;
        int[] iArr = new int[2];
        abVar.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.aaE.getWindowVisibleDisplayFrame(rect);
        if (this.aaF == 1) {
            if ((abVar.getWidth() + iArr[0]) + i > rect.right) {
                return 0;
            }
            return 1;
        } else if (iArr[0] - i < 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public final void f(h hVar) {
        hVar.a((o) this, this.mContext);
        if (isShowing()) {
            g(hVar);
        } else {
            this.aax.add(hVar);
        }
    }

    private void g(h hVar) {
        View a;
        a aVar;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        g gVar = new g(hVar, from, this.aav);
        if (!isShowing() && this.aaK) {
            gVar.aaK = true;
        } else if (isShowing()) {
            gVar.aaK = m.h(hVar);
        }
        int a2 = m.a(gVar, null, this.mContext, this.aas);
        ak go = go();
        go.setAdapter(gVar);
        go.setContentWidth(a2);
        go.aaD = this.aaD;
        if (this.aay.size() > 0) {
            a aVar2 = (a) this.aay.get(this.aay.size() - 1);
            a = a(aVar2, hVar);
            aVar = aVar2;
        } else {
            a = null;
            Object aVar3 = null;
        }
        if (a != null) {
            boolean z;
            int i;
            int i2;
            go.jc();
            go.jb();
            int bq = bq(a2);
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
                this.pP.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                a.getLocationOnScreen(iArr2);
                if ((this.aaD & 7) == 5) {
                    iArr[0] = iArr[0] + this.pP.getWidth();
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
            go.ja();
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
        this.aay.add(new a(go, hVar, this.aaF));
        go.show();
        ab abVar = go.amk;
        abVar.setOnKeyListener(this);
        if (aVar3 == null && this.TO && hVar.abz != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.z, abVar, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(hVar.abz);
            abVar.addHeaderView(frameLayout, null, false);
            go.show();
        }
    }

    private static MenuItem a(h hVar, h hVar2) {
        int size = hVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = hVar.getItem(i);
            if (item.hasSubMenu() && hVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private static View a(a aVar, h hVar) {
        int i = 0;
        MenuItem a = a(aVar.VK, hVar);
        if (a == null) {
            return null;
        }
        int headersCount;
        g gVar;
        int i2;
        ab abVar = aVar.aaU.amk;
        ListAdapter adapter = abVar.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            gVar = (g) headerViewListAdapter.getWrappedAdapter();
        } else {
            gVar = (g) adapter;
            headersCount = 0;
        }
        int count = gVar.getCount();
        while (i < count) {
            if (a == gVar.getItem(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - abVar.getFirstVisiblePosition();
        if (i2 < 0 || i2 >= abVar.getChildCount()) {
            return null;
        }
        return abVar.getChildAt(i2);
    }

    public final boolean isShowing() {
        return this.aay.size() > 0 && ((a) this.aay.get(0)).aaU.amH.isShowing();
    }

    public final void onDismiss() {
        a aVar;
        int size = this.aay.size();
        for (int i = 0; i < size; i++) {
            aVar = (a) this.aay.get(i);
            if (!aVar.aaU.amH.isShowing()) {
                break;
            }
        }
        aVar = null;
        if (aVar != null) {
            aVar.VK.U(false);
        }
    }

    public final void n(boolean z) {
        for (a aVar : this.aay) {
            m.a(aVar.aaU.amk.getAdapter()).notifyDataSetChanged();
        }
    }

    public final void a(android.support.v7.view.menu.o.a aVar) {
        this.aaL = aVar;
    }

    public final boolean a(u uVar) {
        for (a aVar : this.aay) {
            if (uVar == aVar.VK) {
                aVar.aaU.amk.requestFocus();
                return true;
            }
        }
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        f(uVar);
        if (this.aaL != null) {
            this.aaL.d(uVar);
        }
        return true;
    }

    public final void a(h hVar, boolean z) {
        int size = this.aay.size();
        int i = 0;
        while (i < size) {
            if (hVar == ((a) this.aay.get(i)).VK) {
                break;
            }
            i++;
        }
        i = -1;
        if (i >= 0) {
            int i2 = i + 1;
            if (i2 < this.aay.size()) {
                ((a) this.aay.get(i2)).VK.U(false);
            }
            a aVar = (a) this.aay.remove(i);
            aVar.VK.b(this);
            if (this.aaO) {
                ak akVar = aVar.aaU;
                if (VERSION.SDK_INT >= 23) {
                    akVar.amH.setExitTransition(null);
                }
                aVar.aaU.setAnimationStyle(0);
            }
            aVar.aaU.dismiss();
            i = this.aay.size();
            if (i > 0) {
                this.aaF = ((a) this.aay.get(i - 1)).position;
            } else {
                this.aaF = gp();
            }
            if (i == 0) {
                dismiss();
                if (this.aaL != null) {
                    this.aaL.a(hVar, true);
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
                ((a) this.aay.get(0)).VK.U(false);
            }
        }
    }

    public final boolean bt() {
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
            this.aaD = d.getAbsoluteGravity(i, s.T(this.pP));
        }
    }

    public final void setAnchorView(View view) {
        if (this.pP != view) {
            this.pP = view;
            this.aaD = d.getAbsoluteGravity(this.aaC, s.T(this.pP));
        }
    }

    public final void setOnDismissListener(OnDismissListener onDismissListener) {
        this.aaN = onDismissListener;
    }

    public final ListView getListView() {
        if (this.aay.isEmpty()) {
            return null;
        }
        return ((a) this.aay.get(this.aay.size() - 1)).aaU.amk;
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
        this.TO = z;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean gq() {
        return false;
    }
}
