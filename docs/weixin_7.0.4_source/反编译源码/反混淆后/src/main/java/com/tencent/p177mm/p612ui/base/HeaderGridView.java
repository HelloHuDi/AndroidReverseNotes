package com.tencent.p177mm.p612ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.base.HeaderGridView */
public class HeaderGridView extends GridView {
    private ArrayList<C23580a> oiP = new ArrayList();

    /* renamed from: com.tencent.mm.ui.base.HeaderGridView$a */
    static class C23580a {
        public Object data;
        public boolean isSelectable;
        public ViewGroup oiV;
        public View view;

        private C23580a() {
        }

        /* synthetic */ C23580a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HeaderGridView$b */
    class C23581b extends FrameLayout {
        public C23581b(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            AppMethodBeat.m2504i(106287);
            super.onMeasure(MeasureSpec.makeMeasureSpec((HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft()) - HeaderGridView.this.getPaddingRight(), ErrorDialogData.SUPPRESSED), i2);
            AppMethodBeat.m2505o(106287);
        }
    }

    /* renamed from: com.tencent.mm.ui.base.HeaderGridView$c */
    static class C23582c implements Filterable, WrapperListAdapter {
        /* renamed from: Ei */
        private final ListAdapter f4423Ei;
        final DataSetObservable mDataSetObservable = new DataSetObservable();
        int mNumColumns = 1;
        ArrayList<C23580a> oiP;
        boolean oiX;
        private final boolean oiY;

        public C23582c(ArrayList<C23580a> arrayList, ListAdapter listAdapter) {
            AppMethodBeat.m2504i(106288);
            this.f4423Ei = listAdapter;
            this.oiY = listAdapter instanceof Filterable;
            if (arrayList == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("headerViewInfos cannot be null");
                AppMethodBeat.m2505o(106288);
                throw illegalArgumentException;
            }
            this.oiP = arrayList;
            this.oiX = C23582c.m36407I(this.oiP);
            AppMethodBeat.m2505o(106288);
        }

        public final boolean isEmpty() {
            AppMethodBeat.m2504i(106289);
            if ((this.f4423Ei == null || this.f4423Ei.isEmpty()) && this.oiP.size() == 0) {
                AppMethodBeat.m2505o(106289);
                return true;
            }
            AppMethodBeat.m2505o(106289);
            return false;
        }

        /* renamed from: I */
        private static boolean m36407I(ArrayList<C23580a> arrayList) {
            AppMethodBeat.m2504i(106290);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!((C23580a) it.next()).isSelectable) {
                        AppMethodBeat.m2505o(106290);
                        return false;
                    }
                }
            }
            AppMethodBeat.m2505o(106290);
            return true;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(106291);
            int size;
            if (this.f4423Ei != null) {
                size = (this.oiP.size() * this.mNumColumns) + this.f4423Ei.getCount();
                AppMethodBeat.m2505o(106291);
                return size;
            }
            size = this.oiP.size() * this.mNumColumns;
            AppMethodBeat.m2505o(106291);
            return size;
        }

        public final boolean areAllItemsEnabled() {
            AppMethodBeat.m2504i(106292);
            if (this.f4423Ei == null) {
                AppMethodBeat.m2505o(106292);
                return true;
            } else if (this.oiX && this.f4423Ei.areAllItemsEnabled()) {
                AppMethodBeat.m2505o(106292);
                return true;
            } else {
                AppMethodBeat.m2505o(106292);
                return false;
            }
        }

        public final boolean hasStableIds() {
            AppMethodBeat.m2504i(106296);
            if (this.f4423Ei != null) {
                boolean hasStableIds = this.f4423Ei.hasStableIds();
                AppMethodBeat.m2505o(106296);
                return hasStableIds;
            }
            AppMethodBeat.m2505o(106296);
            return false;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.m2504i(106299);
            if (this.f4423Ei != null) {
                int viewTypeCount = this.f4423Ei.getViewTypeCount() + 1;
                AppMethodBeat.m2505o(106299);
                return viewTypeCount;
            }
            AppMethodBeat.m2505o(106299);
            return 2;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            AppMethodBeat.m2504i(106300);
            this.mDataSetObservable.registerObserver(dataSetObserver);
            if (this.f4423Ei != null) {
                this.f4423Ei.registerDataSetObserver(dataSetObserver);
            }
            AppMethodBeat.m2505o(106300);
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            AppMethodBeat.m2504i(106301);
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            if (this.f4423Ei != null) {
                this.f4423Ei.unregisterDataSetObserver(dataSetObserver);
            }
            AppMethodBeat.m2505o(106301);
        }

        public final Filter getFilter() {
            AppMethodBeat.m2504i(106302);
            if (this.oiY) {
                Filter filter = ((Filterable) this.f4423Ei).getFilter();
                AppMethodBeat.m2505o(106302);
                return filter;
            }
            AppMethodBeat.m2505o(106302);
            return null;
        }

        public final ListAdapter getWrappedAdapter() {
            return this.f4423Ei;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.m2504i(106293);
            int size = this.oiP.size() * this.mNumColumns;
            if (i >= size) {
                size = i - size;
                if (this.f4423Ei == null || size >= this.f4423Ei.getCount()) {
                    AppMethodBeat.m2505o(106293);
                    return false;
                }
                boolean isEnabled = this.f4423Ei.isEnabled(size);
                AppMethodBeat.m2505o(106293);
                return isEnabled;
            } else if (i % this.mNumColumns == 0 && ((C23580a) this.oiP.get(i / this.mNumColumns)).isSelectable) {
                AppMethodBeat.m2505o(106293);
                return true;
            } else {
                AppMethodBeat.m2505o(106293);
                return false;
            }
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(106294);
            int size = this.oiP.size() * this.mNumColumns;
            Object item;
            if (i >= size) {
                size = i - size;
                if (this.f4423Ei == null || size >= this.f4423Ei.getCount()) {
                    AppMethodBeat.m2505o(106294);
                    return null;
                }
                item = this.f4423Ei.getItem(size);
                AppMethodBeat.m2505o(106294);
                return item;
            } else if (i % this.mNumColumns == 0) {
                item = ((C23580a) this.oiP.get(i / this.mNumColumns)).data;
                AppMethodBeat.m2505o(106294);
                return item;
            } else {
                AppMethodBeat.m2505o(106294);
                return null;
            }
        }

        public final long getItemId(int i) {
            AppMethodBeat.m2504i(106295);
            int size = this.oiP.size() * this.mNumColumns;
            if (this.f4423Ei != null && i >= size) {
                size = i - size;
                if (size < this.f4423Ei.getCount()) {
                    long itemId = this.f4423Ei.getItemId(size);
                    AppMethodBeat.m2505o(106295);
                    return itemId;
                }
            }
            AppMethodBeat.m2505o(106295);
            return -1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(106297);
            int size = this.oiP.size() * this.mNumColumns;
            if (i < size) {
                View view2 = ((C23580a) this.oiP.get(i / this.mNumColumns)).oiV;
                if (i % this.mNumColumns == 0) {
                    AppMethodBeat.m2505o(106297);
                    return view2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(view2.getHeight());
                AppMethodBeat.m2505o(106297);
                return view;
            }
            size = i - size;
            if (this.f4423Ei == null || size >= this.f4423Ei.getCount()) {
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                AppMethodBeat.m2505o(106297);
                return view;
            }
            view = this.f4423Ei.getView(size, view, viewGroup);
            AppMethodBeat.m2505o(106297);
            return view;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(106298);
            int size = this.oiP.size() * this.mNumColumns;
            if (i >= size || i % this.mNumColumns == 0) {
                if (this.f4423Ei != null && i >= size) {
                    size = i - size;
                    if (size < this.f4423Ei.getCount()) {
                        size = this.f4423Ei.getItemViewType(size);
                        AppMethodBeat.m2505o(106298);
                        return size;
                    }
                }
                AppMethodBeat.m2505o(106298);
                return -2;
            } else if (this.f4423Ei != null) {
                size = this.f4423Ei.getViewTypeCount();
                AppMethodBeat.m2505o(106298);
                return size;
            } else {
                AppMethodBeat.m2505o(106298);
                return 1;
            }
        }
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(106303);
        super.setClipChildren(false);
        AppMethodBeat.m2505o(106303);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(106304);
        super.setClipChildren(false);
        AppMethodBeat.m2505o(106304);
    }

    @TargetApi(11)
    public int getNumColumns() {
        int i = 1;
        AppMethodBeat.m2504i(106305);
        if (VERSION.SDK_INT >= 11) {
            i = super.getNumColumns();
            AppMethodBeat.m2505o(106305);
            return i;
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            i = declaredField.getInt(this);
            AppMethodBeat.m2505o(106305);
            return i;
        } catch (Exception e) {
            AppMethodBeat.m2505o(106305);
            return i;
        }
    }

    public void setClipChildren(boolean z) {
    }

    /* renamed from: eE */
    public final void mo39275eE(View view) {
        AppMethodBeat.m2504i(106306);
        ListAdapter adapter = getAdapter();
        if (adapter == null || (adapter instanceof C23582c)) {
            C23580a c23580a = new C23580a();
            C23581b c23581b = new C23581b(getContext());
            c23581b.addView(view);
            c23580a.view = view;
            c23580a.oiV = c23581b;
            c23580a.data = null;
            c23580a.isSelectable = false;
            this.oiP.add(c23580a);
            if (adapter != null) {
                ((C23582c) adapter).mDataSetObservable.notifyChanged();
            }
            AppMethodBeat.m2505o(106306);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        AppMethodBeat.m2505o(106306);
        throw illegalStateException;
    }

    public int getHeaderViewCount() {
        AppMethodBeat.m2504i(106307);
        int size = this.oiP.size();
        AppMethodBeat.m2505o(106307);
        return size;
    }

    public final void setAdapter$159aa965(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(106308);
        if (this.oiP.size() > 0) {
            C23582c c23582c = new C23582c(this.oiP, listAdapter);
            if (c23582c.mNumColumns != 5) {
                c23582c.mNumColumns = 5;
                c23582c.mDataSetObservable.notifyChanged();
            }
            super.setAdapter(c23582c);
            AppMethodBeat.m2505o(106308);
            return;
        }
        super.setAdapter(listAdapter);
        AppMethodBeat.m2505o(106308);
    }
}
