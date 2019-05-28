package com.tencent.p177mm.plugin.luggage.natives.component.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuGridViewWithHeaderAndFooter */
public class LuGridViewWithHeaderAndFooter extends GridView {
    public static boolean DEBUG = false;
    private OnItemClickListener arw;
    private int enT = -1;
    private int mNumColumns = -1;
    private ArrayList<C12475a> oiP = new ArrayList();
    private OnItemLongClickListener oiQ;
    private View oiR = null;
    private ArrayList<C12475a> oiS = new ArrayList();
    private ListAdapter oiT;
    private C12476c oiU;

    /* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuGridViewWithHeaderAndFooter$a */
    static class C12475a {
        public Object data;
        public boolean isSelectable;
        public ViewGroup oiV;

        private C12475a() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuGridViewWithHeaderAndFooter$c */
    class C12476c implements OnItemClickListener, OnItemLongClickListener {
        private C12476c() {
        }

        /* synthetic */ C12476c(LuGridViewWithHeaderAndFooter luGridViewWithHeaderAndFooter, byte b) {
            this();
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(116869);
            if (LuGridViewWithHeaderAndFooter.this.arw != null) {
                int headerViewCount = i - (LuGridViewWithHeaderAndFooter.this.getHeaderViewCount() * LuGridViewWithHeaderAndFooter.m20386b(LuGridViewWithHeaderAndFooter.this));
                if (headerViewCount >= 0) {
                    LuGridViewWithHeaderAndFooter.this.arw.onItemClick(adapterView, view, headerViewCount, j);
                }
            }
            AppMethodBeat.m2505o(116869);
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(116870);
            if (LuGridViewWithHeaderAndFooter.this.oiQ != null) {
                int headerViewCount = i - (LuGridViewWithHeaderAndFooter.this.getHeaderViewCount() * LuGridViewWithHeaderAndFooter.m20386b(LuGridViewWithHeaderAndFooter.this));
                if (headerViewCount >= 0) {
                    LuGridViewWithHeaderAndFooter.this.oiQ.onItemLongClick(adapterView, view, headerViewCount, j);
                }
            }
            AppMethodBeat.m2505o(116870);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luggage.natives.component.widget.LuGridViewWithHeaderAndFooter$b */
    static class C12477b implements Filterable, WrapperListAdapter {
        static final ArrayList<C12475a> oiW = new ArrayList();
        /* renamed from: Ei */
        private final ListAdapter f2913Ei;
        int enT = -1;
        private final DataSetObservable mDataSetObservable = new DataSetObservable();
        private int mNumColumns = 1;
        ArrayList<C12475a> oiP;
        ArrayList<C12475a> oiS;
        boolean oiX;
        private final boolean oiY;
        private boolean oiZ = true;
        private boolean oja = false;

        static {
            AppMethodBeat.m2504i(116868);
            AppMethodBeat.m2505o(116868);
        }

        public C12477b(ArrayList<C12475a> arrayList, ArrayList<C12475a> arrayList2, ListAdapter listAdapter) {
            boolean z = true;
            AppMethodBeat.m2504i(116851);
            this.f2913Ei = listAdapter;
            this.oiY = listAdapter instanceof Filterable;
            if (arrayList == null) {
                this.oiP = oiW;
            } else {
                this.oiP = arrayList;
            }
            if (arrayList2 == null) {
                this.oiS = oiW;
            } else {
                this.oiS = arrayList2;
            }
            if (!(C12477b.m20388I(this.oiP) && C12477b.m20388I(this.oiS))) {
                z = false;
            }
            this.oiX = z;
            AppMethodBeat.m2505o(116851);
        }

        public final void setNumColumns(int i) {
            AppMethodBeat.m2504i(116852);
            if (i <= 0) {
                AppMethodBeat.m2505o(116852);
                return;
            }
            if (this.mNumColumns != i) {
                this.mNumColumns = i;
                this.mDataSetObservable.notifyChanged();
            }
            AppMethodBeat.m2505o(116852);
        }

        public final boolean isEmpty() {
            AppMethodBeat.m2504i(116853);
            if (this.f2913Ei == null || this.f2913Ei.isEmpty()) {
                AppMethodBeat.m2505o(116853);
                return true;
            }
            AppMethodBeat.m2505o(116853);
            return false;
        }

        /* renamed from: I */
        private static boolean m20388I(ArrayList<C12475a> arrayList) {
            AppMethodBeat.m2504i(116854);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!((C12475a) it.next()).isSelectable) {
                        AppMethodBeat.m2505o(116854);
                        return false;
                    }
                }
            }
            AppMethodBeat.m2505o(116854);
            return true;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(116855);
            int size;
            if (this.f2913Ei != null) {
                size = ((this.oiS.size() + this.oiP.size()) * this.mNumColumns) + bMT();
                AppMethodBeat.m2505o(116855);
                return size;
            }
            size = (this.oiS.size() + this.oiP.size()) * this.mNumColumns;
            AppMethodBeat.m2505o(116855);
            return size;
        }

        public final boolean areAllItemsEnabled() {
            AppMethodBeat.m2504i(116856);
            if (this.f2913Ei == null || (this.oiX && this.f2913Ei.areAllItemsEnabled())) {
                AppMethodBeat.m2505o(116856);
                return true;
            }
            AppMethodBeat.m2505o(116856);
            return false;
        }

        private int bMT() {
            AppMethodBeat.m2504i(116857);
            int ceil = (int) (Math.ceil((double) ((1.0f * ((float) this.f2913Ei.getCount())) / ((float) this.mNumColumns))) * ((double) this.mNumColumns));
            AppMethodBeat.m2505o(116857);
            return ceil;
        }

        public final boolean hasStableIds() {
            AppMethodBeat.m2504i(116861);
            if (this.f2913Ei == null || !this.f2913Ei.hasStableIds()) {
                AppMethodBeat.m2505o(116861);
                return false;
            }
            AppMethodBeat.m2505o(116861);
            return true;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            int i2 = 0;
            AppMethodBeat.m2504i(116862);
            if (LuGridViewWithHeaderAndFooter.DEBUG) {
                boolean z;
                String str = "getView: %s, reused: %s";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                if (view == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[1] = Boolean.valueOf(z);
                String.format(str, objArr);
            }
            int size = this.oiP.size() * this.mNumColumns;
            View view2;
            if (i < size) {
                view2 = ((C12475a) this.oiP.get(i / this.mNumColumns)).oiV;
                if (i % this.mNumColumns == 0) {
                    AppMethodBeat.m2505o(116862);
                    return view2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(view2.getHeight());
                AppMethodBeat.m2505o(116862);
                return view;
            }
            size = i - size;
            if (this.f2913Ei != null) {
                i2 = bMT();
                if (size < i2) {
                    if (size < this.f2913Ei.getCount()) {
                        view = this.f2913Ei.getView(size, view, viewGroup);
                        AppMethodBeat.m2505o(116862);
                        return view;
                    }
                    if (view == null) {
                        view = new View(viewGroup.getContext());
                    }
                    view.setVisibility(4);
                    view.setMinimumHeight(this.enT);
                    AppMethodBeat.m2505o(116862);
                    return view;
                }
            }
            size -= i2;
            if (size < getCount()) {
                view2 = ((C12475a) this.oiS.get(size / this.mNumColumns)).oiV;
                if (i % this.mNumColumns == 0) {
                    AppMethodBeat.m2505o(116862);
                    return view2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(view2.getHeight());
                AppMethodBeat.m2505o(116862);
                return view;
            }
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(i);
            AppMethodBeat.m2505o(116862);
            throw arrayIndexOutOfBoundsException;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.m2504i(116864);
            int viewTypeCount = this.f2913Ei == null ? 1 : this.f2913Ei.getViewTypeCount();
            if (this.oiZ) {
                int size = (this.oiP.size() + 1) + this.oiS.size();
                if (this.oja) {
                    size++;
                }
                viewTypeCount += size;
            }
            if (LuGridViewWithHeaderAndFooter.DEBUG) {
                String.format("getViewTypeCount: %s", new Object[]{Integer.valueOf(viewTypeCount)});
            }
            AppMethodBeat.m2505o(116864);
            return viewTypeCount;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            AppMethodBeat.m2504i(116865);
            this.mDataSetObservable.registerObserver(dataSetObserver);
            if (this.f2913Ei != null) {
                this.f2913Ei.registerDataSetObserver(dataSetObserver);
            }
            AppMethodBeat.m2505o(116865);
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            AppMethodBeat.m2504i(116866);
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            if (this.f2913Ei != null) {
                this.f2913Ei.unregisterDataSetObserver(dataSetObserver);
            }
            AppMethodBeat.m2505o(116866);
        }

        public final Filter getFilter() {
            AppMethodBeat.m2504i(116867);
            if (this.oiY) {
                Filter filter = ((Filterable) this.f2913Ei).getFilter();
                AppMethodBeat.m2505o(116867);
                return filter;
            }
            AppMethodBeat.m2505o(116867);
            return null;
        }

        public final ListAdapter getWrappedAdapter() {
            return this.f2913Ei;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(116858);
            int size = this.oiP.size() * this.mNumColumns;
            if (i >= size) {
                int i2 = i - size;
                if (this.f2913Ei != null) {
                    size = bMT();
                    if (i2 < size) {
                        if (i2 >= this.f2913Ei.getCount() || !this.f2913Ei.isEnabled(i2)) {
                            AppMethodBeat.m2505o(116858);
                            return false;
                        }
                        AppMethodBeat.m2505o(116858);
                        return true;
                    }
                }
                size = 0;
                size = i2 - size;
                if (size % this.mNumColumns == 0 && ((C12475a) this.oiS.get(size / this.mNumColumns)).isSelectable) {
                    AppMethodBeat.m2505o(116858);
                    return true;
                }
                AppMethodBeat.m2505o(116858);
                return false;
            } else if (i % this.mNumColumns == 0 && ((C12475a) this.oiP.get(i / this.mNumColumns)).isSelectable) {
                AppMethodBeat.m2505o(116858);
                return true;
            } else {
                AppMethodBeat.m2505o(116858);
                return false;
            }
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(116859);
            int size = this.oiP.size() * this.mNumColumns;
            Object item;
            if (i >= size) {
                int i2 = i - size;
                size = 0;
                if (this.f2913Ei != null) {
                    size = bMT();
                    if (i2 < size) {
                        if (i2 < this.f2913Ei.getCount()) {
                            item = this.f2913Ei.getItem(i2);
                            AppMethodBeat.m2505o(116859);
                            return item;
                        }
                        AppMethodBeat.m2505o(116859);
                        return null;
                    }
                }
                size = i2 - size;
                if (size % this.mNumColumns == 0) {
                    item = ((C12475a) this.oiS.get(size)).data;
                    AppMethodBeat.m2505o(116859);
                    return item;
                }
                AppMethodBeat.m2505o(116859);
                return null;
            } else if (i % this.mNumColumns == 0) {
                item = ((C12475a) this.oiP.get(i / this.mNumColumns)).data;
                AppMethodBeat.m2505o(116859);
                return item;
            } else {
                AppMethodBeat.m2505o(116859);
                return null;
            }
        }

        public final long getItemId(int i) {
            AppMethodBeat.m2504i(116860);
            int size = this.oiP.size() * this.mNumColumns;
            if (this.f2913Ei != null && i >= size) {
                size = i - size;
                if (size < this.f2913Ei.getCount()) {
                    long itemId = this.f2913Ei.getItemId(size);
                    AppMethodBeat.m2505o(116860);
                    return itemId;
                }
            }
            AppMethodBeat.m2505o(116860);
            return -1;
        }

        public final int getItemViewType(int i) {
            int i2;
            AppMethodBeat.m2504i(116863);
            int size = this.oiP.size() * this.mNumColumns;
            if (this.f2913Ei == null) {
                i2 = 0;
            } else {
                i2 = this.f2913Ei.getViewTypeCount() - 1;
            }
            int i3 = -2;
            if (this.oiZ && i < size) {
                if (i == 0 && this.oja) {
                    i3 = (((this.oiP.size() + i2) + this.oiS.size()) + 1) + 1;
                }
                if (i % this.mNumColumns != 0) {
                    i3 = ((i / this.mNumColumns) + 1) + i2;
                }
            }
            int i4 = i - size;
            if (this.f2913Ei != null) {
                size = bMT();
                if (i4 >= 0 && i4 < size) {
                    if (i4 < this.f2913Ei.getCount()) {
                        i3 = this.f2913Ei.getItemViewType(i4);
                    } else if (this.oiZ) {
                        i3 = (this.oiP.size() + i2) + 1;
                    }
                }
            } else {
                size = 0;
            }
            if (this.oiZ) {
                size = i4 - size;
                if (size >= 0 && size < getCount() && size % this.mNumColumns != 0) {
                    i3 = ((size / this.mNumColumns) + 1) + ((i2 + this.oiP.size()) + 1);
                }
            }
            if (LuGridViewWithHeaderAndFooter.DEBUG) {
                String.format("getItemViewType: pos: %s, result: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(this.oiZ), Boolean.valueOf(this.oja)});
            }
            AppMethodBeat.m2505o(116863);
            return i3;
        }
    }

    /* renamed from: b */
    static /* synthetic */ int m20386b(LuGridViewWithHeaderAndFooter luGridViewWithHeaderAndFooter) {
        AppMethodBeat.m2504i(116890);
        int numColumnsCompatible = luGridViewWithHeaderAndFooter.getNumColumnsCompatible();
        AppMethodBeat.m2505o(116890);
        return numColumnsCompatible;
    }

    public LuGridViewWithHeaderAndFooter(Context context) {
        super(context);
        AppMethodBeat.m2504i(116871);
        AppMethodBeat.m2505o(116871);
    }

    public LuGridViewWithHeaderAndFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(116872);
        AppMethodBeat.m2505o(116872);
    }

    public LuGridViewWithHeaderAndFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(116873);
        AppMethodBeat.m2505o(116873);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(116874);
        super.onMeasure(i, i2);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof C12477b)) {
            ((C12477b) adapter).setNumColumns(getNumColumnsCompatible());
            ((C12477b) adapter).enT = getRowHeight();
        }
        AppMethodBeat.m2505o(116874);
    }

    public void setClipChildren(boolean z) {
    }

    public void setClipChildrenSupper(boolean z) {
        AppMethodBeat.m2504i(116875);
        super.setClipChildren(false);
        AppMethodBeat.m2505o(116875);
    }

    public int getHeaderViewCount() {
        AppMethodBeat.m2504i(116876);
        int size = this.oiP.size();
        AppMethodBeat.m2505o(116876);
        return size;
    }

    public int getFooterViewCount() {
        AppMethodBeat.m2504i(116877);
        int size = this.oiS.size();
        AppMethodBeat.m2505o(116877);
        return size;
    }

    @TargetApi(11)
    private int getNumColumnsCompatible() {
        AppMethodBeat.m2504i(116878);
        int numColumns;
        if (VERSION.SDK_INT >= 11) {
            numColumns = super.getNumColumns();
            AppMethodBeat.m2505o(116878);
            return numColumns;
        }
        try {
            Field declaredField = GridView.class.getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            numColumns = declaredField.getInt(this);
            AppMethodBeat.m2505o(116878);
            return numColumns;
        } catch (Exception e) {
            if (this.mNumColumns != -1) {
                numColumns = this.mNumColumns;
                AppMethodBeat.m2505o(116878);
                return numColumns;
            }
            RuntimeException runtimeException = new RuntimeException("Can not determine the mNumColumns for this API platform, please call setNumColumns to set it.");
            AppMethodBeat.m2505o(116878);
            throw runtimeException;
        }
    }

    @TargetApi(16)
    private int getColumnWidthCompatible() {
        RuntimeException runtimeException;
        AppMethodBeat.m2504i(116879);
        int columnWidth;
        if (VERSION.SDK_INT >= 16) {
            columnWidth = super.getColumnWidth();
            AppMethodBeat.m2505o(116879);
            return columnWidth;
        }
        try {
            Field declaredField = GridView.class.getDeclaredField("mColumnWidth");
            declaredField.setAccessible(true);
            columnWidth = declaredField.getInt(this);
            AppMethodBeat.m2505o(116879);
            return columnWidth;
        } catch (NoSuchFieldException e) {
            runtimeException = new RuntimeException(e);
            AppMethodBeat.m2505o(116879);
            throw runtimeException;
        } catch (IllegalAccessException e2) {
            runtimeException = new RuntimeException(e2);
            AppMethodBeat.m2505o(116879);
            throw runtimeException;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(116880);
        super.onDetachedFromWindow();
        this.oiR = null;
        AppMethodBeat.m2505o(116880);
    }

    @TargetApi(16)
    public int getVerticalSpacing() {
        AppMethodBeat.m2504i(116881);
        int i = 0;
        try {
            if (VERSION.SDK_INT < 16) {
                Field declaredField = GridView.class.getDeclaredField("mVerticalSpacing");
                declaredField.setAccessible(true);
                i = declaredField.getInt(this);
            } else {
                i = super.getVerticalSpacing();
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(116881);
        return i;
    }

    @TargetApi(16)
    public int getHorizontalSpacing() {
        AppMethodBeat.m2504i(116882);
        int i = 0;
        try {
            if (VERSION.SDK_INT < 16) {
                Field declaredField = GridView.class.getDeclaredField("mHorizontalSpacing");
                declaredField.setAccessible(true);
                i = declaredField.getInt(this);
            } else {
                i = super.getHorizontalSpacing();
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(116882);
        return i;
    }

    public int getRowHeight() {
        AppMethodBeat.m2504i(116883);
        int i;
        if (this.enT > 0) {
            i = this.enT;
            AppMethodBeat.m2505o(116883);
            return i;
        }
        ListAdapter adapter = getAdapter();
        int numColumnsCompatible = getNumColumnsCompatible();
        if (adapter == null || adapter.getCount() <= (this.oiP.size() + this.oiS.size()) * numColumnsCompatible) {
            AppMethodBeat.m2505o(116883);
            return -1;
        }
        int columnWidthCompatible = getColumnWidthCompatible();
        View view = getAdapter().getView(numColumnsCompatible * this.oiP.size(), this.oiR, this);
        LayoutParams layoutParams = null;
        if (view.getLayoutParams() instanceof LayoutParams) {
            layoutParams = (LayoutParams) view.getLayoutParams();
        }
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2, 0);
            view.setLayoutParams(layoutParams);
        }
        view.measure(LuGridViewWithHeaderAndFooter.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(columnWidthCompatible, ErrorDialogData.SUPPRESSED), 0, layoutParams.width), LuGridViewWithHeaderAndFooter.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(0, 0), 0, layoutParams.height));
        this.oiR = view;
        this.enT = view.getMeasuredHeight();
        i = this.enT;
        AppMethodBeat.m2505o(116883);
        return i;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(116884);
        this.oiT = listAdapter;
        if (this.oiP.size() > 0 || this.oiS.size() > 0) {
            C12477b c12477b = new C12477b(this.oiP, this.oiS, listAdapter);
            int numColumnsCompatible = getNumColumnsCompatible();
            if (numColumnsCompatible > 1) {
                c12477b.setNumColumns(numColumnsCompatible);
            }
            c12477b.enT = getRowHeight();
            super.setAdapter(c12477b);
            AppMethodBeat.m2505o(116884);
            return;
        }
        super.setAdapter(listAdapter);
        AppMethodBeat.m2505o(116884);
    }

    public ListAdapter getOriginalAdapter() {
        return this.oiT;
    }

    public void setNumColumns(int i) {
        AppMethodBeat.m2504i(116885);
        super.setNumColumns(i);
        this.mNumColumns = i;
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof C12477b)) {
            ((C12477b) adapter).setNumColumns(i);
        }
        AppMethodBeat.m2505o(116885);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        AppMethodBeat.m2504i(116886);
        this.arw = onItemClickListener;
        super.setOnItemClickListener(getItemClickHandler());
        AppMethodBeat.m2505o(116886);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.m2504i(116887);
        this.oiQ = onItemLongClickListener;
        super.setOnItemLongClickListener(getItemClickHandler());
        AppMethodBeat.m2505o(116887);
    }

    private C12476c getItemClickHandler() {
        AppMethodBeat.m2504i(116888);
        if (this.oiU == null) {
            this.oiU = new C12476c(this, (byte) 0);
        }
        C12476c c12476c = this.oiU;
        AppMethodBeat.m2505o(116888);
        return c12476c;
    }
}
