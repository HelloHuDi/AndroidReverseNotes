package android.support.p069v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p069v7.app.C7452b.C0574a;
import android.support.p069v7.view.menu.C0628o.C0627a;
import android.support.p069v7.view.menu.C0630p.C0629a;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.f */
public final class C6235f implements C0628o, OnItemClickListener {
    int aan;
    ExpandedMenuView abg;
    int abh;
    int abi;
    C0621a abj;
    /* renamed from: lL */
    public C0627a f1908lL;
    /* renamed from: lo */
    C6236h f1909lo;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;

    /* renamed from: android.support.v7.view.menu.f$a */
    class C0621a extends BaseAdapter {
        private int abk = -1;

        public C0621a() {
            m1335gt();
        }

        public final int getCount() {
            int size = C6235f.this.f1909lo.mo14140gD().size() - C6235f.this.abh;
            return this.abk < 0 ? size : size - 1;
        }

        /* renamed from: br */
        public final C6239j getItem(int i) {
            ArrayList gD = C6235f.this.f1909lo.mo14140gD();
            int i2 = C6235f.this.abh + i;
            if (this.abk >= 0 && i2 >= this.abk) {
                i2++;
            }
            return (C6239j) gD.get(i2);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = C6235f.this.mInflater.inflate(C6235f.this.aan, viewGroup, false);
            } else {
                inflate = view;
            }
            ((C0629a) inflate).mo1609a(getItem(i));
            return inflate;
        }

        /* renamed from: gt */
        private void m1335gt() {
            C6239j c6239j = C6235f.this.f1909lo.abJ;
            if (c6239j != null) {
                ArrayList gD = C6235f.this.f1909lo.mo14140gD();
                int size = gD.size();
                for (int i = 0; i < size; i++) {
                    if (((C6239j) gD.get(i)) == c6239j) {
                        this.abk = i;
                        return;
                    }
                }
            }
            this.abk = -1;
        }

        public final void notifyDataSetChanged() {
            m1335gt();
            super.notifyDataSetChanged();
        }
    }

    public C6235f(Context context) {
        this();
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    private C6235f() {
        this.aan = 2130968599;
        this.abi = 0;
    }

    /* renamed from: a */
    public final void mo1598a(Context context, C6236h c6236h) {
        if (this.abi != 0) {
            this.mContext = new ContextThemeWrapper(context, this.abi);
            this.mInflater = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(this.mContext);
            }
        }
        this.f1909lo = c6236h;
        if (this.abj != null) {
            this.abj.notifyDataSetChanged();
        }
    }

    /* renamed from: f */
    public final C0630p mo14107f(ViewGroup viewGroup) {
        if (this.abg == null) {
            this.abg = (ExpandedMenuView) this.mInflater.inflate(2130968596, viewGroup, false);
            if (this.abj == null) {
                this.abj = new C0621a();
            }
            this.abg.setAdapter(this.abj);
            this.abg.setOnItemClickListener(this);
        }
        return this.abg;
    }

    public final ListAdapter getAdapter() {
        if (this.abj == null) {
            this.abj = new C0621a();
        }
        return this.abj;
    }

    /* renamed from: n */
    public final void mo1606n(boolean z) {
        if (this.abj != null) {
            this.abj.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    public final void mo1600a(C0627a c0627a) {
        this.f1908lL = c0627a;
    }

    /* renamed from: a */
    public final boolean mo1601a(C7459u c7459u) {
        if (!c7459u.hasVisibleItems()) {
            return false;
        }
        C6237i c6237i = new C6237i(c7459u);
        C6236h c6236h = c6237i.f1910lo;
        C0574a c0574a = new C0574a(c6236h.mContext);
        c6237i.abM = new C6235f(c0574a.f864UA.mContext);
        c6237i.abM.f1908lL = c6237i;
        c6237i.f1910lo.mo14114a(c6237i.abM);
        c0574a.f864UA.f760Ei = c6237i.abM.getAdapter();
        c0574a.f864UA.f787Ui = c6237i;
        View view = c6236h.abB;
        if (view != null) {
            c0574a.f864UA.f764TG = view;
        } else {
            c0574a.f864UA.f796rP = c6236h.abA;
            c0574a.f864UA.f761IT = c6236h.abz;
        }
        c0574a.f864UA.f785Ug = c6237i;
        c6237i.abL = c0574a.mo1393fi();
        c6237i.abL.setOnDismissListener(c6237i);
        LayoutParams attributes = c6237i.abL.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        c6237i.abL.show();
        if (this.f1908lL != null) {
            this.f1908lL.mo1597d(c7459u);
        }
        return true;
    }

    /* renamed from: a */
    public final void mo1599a(C6236h c6236h, boolean z) {
        if (this.f1908lL != null) {
            this.f1908lL.mo1596a(c6236h, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1909lo.mo14116a(this.abj.getItem(i), (C0628o) this, 0);
    }

    /* renamed from: bt */
    public final boolean mo1603bt() {
        return false;
    }

    /* renamed from: b */
    public final boolean mo1602b(C6239j c6239j) {
        return false;
    }

    /* renamed from: c */
    public final boolean mo1604c(C6239j c6239j) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }

    public final Parcelable onSaveInstanceState() {
        if (this.abg == null) {
            return null;
        }
        Parcelable bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        if (this.abg != null) {
            this.abg.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.abg.restoreHierarchyState(sparseParcelableArray);
        }
    }
}
