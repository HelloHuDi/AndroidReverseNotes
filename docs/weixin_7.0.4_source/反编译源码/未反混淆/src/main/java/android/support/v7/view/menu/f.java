package android.support.v7.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
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
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;

public final class f implements o, OnItemClickListener {
    int aan;
    ExpandedMenuView abg;
    int abh;
    int abi;
    a abj;
    public android.support.v7.view.menu.o.a lL;
    h lo;
    Context mContext;
    private int mId;
    LayoutInflater mInflater;

    class a extends BaseAdapter {
        private int abk = -1;

        public a() {
            gt();
        }

        public final int getCount() {
            int size = f.this.lo.gD().size() - f.this.abh;
            return this.abk < 0 ? size : size - 1;
        }

        /* renamed from: br */
        public final j getItem(int i) {
            ArrayList gD = f.this.lo.gD();
            int i2 = f.this.abh + i;
            if (this.abk >= 0 && i2 >= this.abk) {
                i2++;
            }
            return (j) gD.get(i2);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = f.this.mInflater.inflate(f.this.aan, viewGroup, false);
            } else {
                inflate = view;
            }
            ((android.support.v7.view.menu.p.a) inflate).a(getItem(i));
            return inflate;
        }

        private void gt() {
            j jVar = f.this.lo.abJ;
            if (jVar != null) {
                ArrayList gD = f.this.lo.gD();
                int size = gD.size();
                for (int i = 0; i < size; i++) {
                    if (((j) gD.get(i)) == jVar) {
                        this.abk = i;
                        return;
                    }
                }
            }
            this.abk = -1;
        }

        public final void notifyDataSetChanged() {
            gt();
            super.notifyDataSetChanged();
        }
    }

    public f(Context context) {
        this();
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
    }

    private f() {
        this.aan = R.layout.x;
        this.abi = 0;
    }

    public final void a(Context context, h hVar) {
        if (this.abi != 0) {
            this.mContext = new ContextThemeWrapper(context, this.abi);
            this.mInflater = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.mInflater == null) {
                this.mInflater = LayoutInflater.from(this.mContext);
            }
        }
        this.lo = hVar;
        if (this.abj != null) {
            this.abj.notifyDataSetChanged();
        }
    }

    public final p f(ViewGroup viewGroup) {
        if (this.abg == null) {
            this.abg = (ExpandedMenuView) this.mInflater.inflate(R.layout.u, viewGroup, false);
            if (this.abj == null) {
                this.abj = new a();
            }
            this.abg.setAdapter(this.abj);
            this.abg.setOnItemClickListener(this);
        }
        return this.abg;
    }

    public final ListAdapter getAdapter() {
        if (this.abj == null) {
            this.abj = new a();
        }
        return this.abj;
    }

    public final void n(boolean z) {
        if (this.abj != null) {
            this.abj.notifyDataSetChanged();
        }
    }

    public final void a(android.support.v7.view.menu.o.a aVar) {
        this.lL = aVar;
    }

    public final boolean a(u uVar) {
        if (!uVar.hasVisibleItems()) {
            return false;
        }
        i iVar = new i(uVar);
        h hVar = iVar.lo;
        android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(hVar.mContext);
        iVar.abM = new f(aVar.UA.mContext);
        iVar.abM.lL = iVar;
        iVar.lo.a(iVar.abM);
        aVar.UA.Ei = iVar.abM.getAdapter();
        aVar.UA.Ui = iVar;
        View view = hVar.abB;
        if (view != null) {
            aVar.UA.TG = view;
        } else {
            aVar.UA.rP = hVar.abA;
            aVar.UA.IT = hVar.abz;
        }
        aVar.UA.Ug = iVar;
        iVar.abL = aVar.fi();
        iVar.abL.setOnDismissListener(iVar);
        LayoutParams attributes = iVar.abL.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
        iVar.abL.show();
        if (this.lL != null) {
            this.lL.d(uVar);
        }
        return true;
    }

    public final void a(h hVar, boolean z) {
        if (this.lL != null) {
            this.lL.a(hVar, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.lo.a(this.abj.getItem(i), (o) this, 0);
    }

    public final boolean bt() {
        return false;
    }

    public final boolean b(j jVar) {
        return false;
    }

    public final boolean c(j jVar) {
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
