package com.tencent.mm.ui.base;

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

public class HeaderGridView extends GridView {
    private ArrayList<a> oiP = new ArrayList();

    static class a {
        public Object data;
        public boolean isSelectable;
        public ViewGroup oiV;
        public View view;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    class b extends FrameLayout {
        public b(Context context) {
            super(context);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onMeasure(int i, int i2) {
            AppMethodBeat.i(106287);
            super.onMeasure(MeasureSpec.makeMeasureSpec((HeaderGridView.this.getMeasuredWidth() - HeaderGridView.this.getPaddingLeft()) - HeaderGridView.this.getPaddingRight(), ErrorDialogData.SUPPRESSED), i2);
            AppMethodBeat.o(106287);
        }
    }

    static class c implements Filterable, WrapperListAdapter {
        private final ListAdapter Ei;
        final DataSetObservable mDataSetObservable = new DataSetObservable();
        int mNumColumns = 1;
        ArrayList<a> oiP;
        boolean oiX;
        private final boolean oiY;

        public c(ArrayList<a> arrayList, ListAdapter listAdapter) {
            AppMethodBeat.i(106288);
            this.Ei = listAdapter;
            this.oiY = listAdapter instanceof Filterable;
            if (arrayList == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("headerViewInfos cannot be null");
                AppMethodBeat.o(106288);
                throw illegalArgumentException;
            }
            this.oiP = arrayList;
            this.oiX = I(this.oiP);
            AppMethodBeat.o(106288);
        }

        public final boolean isEmpty() {
            AppMethodBeat.i(106289);
            if ((this.Ei == null || this.Ei.isEmpty()) && this.oiP.size() == 0) {
                AppMethodBeat.o(106289);
                return true;
            }
            AppMethodBeat.o(106289);
            return false;
        }

        private static boolean I(ArrayList<a> arrayList) {
            AppMethodBeat.i(106290);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (!((a) it.next()).isSelectable) {
                        AppMethodBeat.o(106290);
                        return false;
                    }
                }
            }
            AppMethodBeat.o(106290);
            return true;
        }

        public final int getCount() {
            AppMethodBeat.i(106291);
            int size;
            if (this.Ei != null) {
                size = (this.oiP.size() * this.mNumColumns) + this.Ei.getCount();
                AppMethodBeat.o(106291);
                return size;
            }
            size = this.oiP.size() * this.mNumColumns;
            AppMethodBeat.o(106291);
            return size;
        }

        public final boolean areAllItemsEnabled() {
            AppMethodBeat.i(106292);
            if (this.Ei == null) {
                AppMethodBeat.o(106292);
                return true;
            } else if (this.oiX && this.Ei.areAllItemsEnabled()) {
                AppMethodBeat.o(106292);
                return true;
            } else {
                AppMethodBeat.o(106292);
                return false;
            }
        }

        public final boolean hasStableIds() {
            AppMethodBeat.i(106296);
            if (this.Ei != null) {
                boolean hasStableIds = this.Ei.hasStableIds();
                AppMethodBeat.o(106296);
                return hasStableIds;
            }
            AppMethodBeat.o(106296);
            return false;
        }

        public final int getViewTypeCount() {
            AppMethodBeat.i(106299);
            if (this.Ei != null) {
                int viewTypeCount = this.Ei.getViewTypeCount() + 1;
                AppMethodBeat.o(106299);
                return viewTypeCount;
            }
            AppMethodBeat.o(106299);
            return 2;
        }

        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            AppMethodBeat.i(106300);
            this.mDataSetObservable.registerObserver(dataSetObserver);
            if (this.Ei != null) {
                this.Ei.registerDataSetObserver(dataSetObserver);
            }
            AppMethodBeat.o(106300);
        }

        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            AppMethodBeat.i(106301);
            this.mDataSetObservable.unregisterObserver(dataSetObserver);
            if (this.Ei != null) {
                this.Ei.unregisterDataSetObserver(dataSetObserver);
            }
            AppMethodBeat.o(106301);
        }

        public final Filter getFilter() {
            AppMethodBeat.i(106302);
            if (this.oiY) {
                Filter filter = ((Filterable) this.Ei).getFilter();
                AppMethodBeat.o(106302);
                return filter;
            }
            AppMethodBeat.o(106302);
            return null;
        }

        public final ListAdapter getWrappedAdapter() {
            return this.Ei;
        }

        public final boolean isEnabled(int i) {
            AppMethodBeat.i(106293);
            int size = this.oiP.size() * this.mNumColumns;
            if (i >= size) {
                size = i - size;
                if (this.Ei == null || size >= this.Ei.getCount()) {
                    AppMethodBeat.o(106293);
                    return false;
                }
                boolean isEnabled = this.Ei.isEnabled(size);
                AppMethodBeat.o(106293);
                return isEnabled;
            } else if (i % this.mNumColumns == 0 && ((a) this.oiP.get(i / this.mNumColumns)).isSelectable) {
                AppMethodBeat.o(106293);
                return true;
            } else {
                AppMethodBeat.o(106293);
                return false;
            }
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(106294);
            int size = this.oiP.size() * this.mNumColumns;
            Object item;
            if (i >= size) {
                size = i - size;
                if (this.Ei == null || size >= this.Ei.getCount()) {
                    AppMethodBeat.o(106294);
                    return null;
                }
                item = this.Ei.getItem(size);
                AppMethodBeat.o(106294);
                return item;
            } else if (i % this.mNumColumns == 0) {
                item = ((a) this.oiP.get(i / this.mNumColumns)).data;
                AppMethodBeat.o(106294);
                return item;
            } else {
                AppMethodBeat.o(106294);
                return null;
            }
        }

        public final long getItemId(int i) {
            AppMethodBeat.i(106295);
            int size = this.oiP.size() * this.mNumColumns;
            if (this.Ei != null && i >= size) {
                size = i - size;
                if (size < this.Ei.getCount()) {
                    long itemId = this.Ei.getItemId(size);
                    AppMethodBeat.o(106295);
                    return itemId;
                }
            }
            AppMethodBeat.o(106295);
            return -1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(106297);
            int size = this.oiP.size() * this.mNumColumns;
            if (i < size) {
                View view2 = ((a) this.oiP.get(i / this.mNumColumns)).oiV;
                if (i % this.mNumColumns == 0) {
                    AppMethodBeat.o(106297);
                    return view2;
                }
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                view.setMinimumHeight(view2.getHeight());
                AppMethodBeat.o(106297);
                return view;
            }
            size = i - size;
            if (this.Ei == null || size >= this.Ei.getCount()) {
                if (view == null) {
                    view = new View(viewGroup.getContext());
                }
                view.setVisibility(4);
                AppMethodBeat.o(106297);
                return view;
            }
            view = this.Ei.getView(size, view, viewGroup);
            AppMethodBeat.o(106297);
            return view;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(106298);
            int size = this.oiP.size() * this.mNumColumns;
            if (i >= size || i % this.mNumColumns == 0) {
                if (this.Ei != null && i >= size) {
                    size = i - size;
                    if (size < this.Ei.getCount()) {
                        size = this.Ei.getItemViewType(size);
                        AppMethodBeat.o(106298);
                        return size;
                    }
                }
                AppMethodBeat.o(106298);
                return -2;
            } else if (this.Ei != null) {
                size = this.Ei.getViewTypeCount();
                AppMethodBeat.o(106298);
                return size;
            } else {
                AppMethodBeat.o(106298);
                return 1;
            }
        }
    }

    public HeaderGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(106303);
        super.setClipChildren(false);
        AppMethodBeat.o(106303);
    }

    public HeaderGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106304);
        super.setClipChildren(false);
        AppMethodBeat.o(106304);
    }

    @TargetApi(11)
    public int getNumColumns() {
        int i = 1;
        AppMethodBeat.i(106305);
        if (VERSION.SDK_INT >= 11) {
            i = super.getNumColumns();
            AppMethodBeat.o(106305);
            return i;
        }
        try {
            Field declaredField = getClass().getSuperclass().getDeclaredField("mNumColumns");
            declaredField.setAccessible(true);
            i = declaredField.getInt(this);
            AppMethodBeat.o(106305);
            return i;
        } catch (Exception e) {
            AppMethodBeat.o(106305);
            return i;
        }
    }

    public void setClipChildren(boolean z) {
    }

    public final void eE(View view) {
        AppMethodBeat.i(106306);
        ListAdapter adapter = getAdapter();
        if (adapter == null || (adapter instanceof c)) {
            a aVar = new a();
            b bVar = new b(getContext());
            bVar.addView(view);
            aVar.view = view;
            aVar.oiV = bVar;
            aVar.data = null;
            aVar.isSelectable = false;
            this.oiP.add(aVar);
            if (adapter != null) {
                ((c) adapter).mDataSetObservable.notifyChanged();
            }
            AppMethodBeat.o(106306);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        AppMethodBeat.o(106306);
        throw illegalStateException;
    }

    public int getHeaderViewCount() {
        AppMethodBeat.i(106307);
        int size = this.oiP.size();
        AppMethodBeat.o(106307);
        return size;
    }

    public final void setAdapter$159aa965(ListAdapter listAdapter) {
        AppMethodBeat.i(106308);
        if (this.oiP.size() > 0) {
            c cVar = new c(this.oiP, listAdapter);
            if (cVar.mNumColumns != 5) {
                cVar.mNumColumns = 5;
                cVar.mDataSetObservable.notifyChanged();
            }
            super.setAdapter(cVar);
            AppMethodBeat.o(106308);
            return;
        }
        super.setAdapter(listAdapter);
        AppMethodBeat.o(106308);
    }
}
