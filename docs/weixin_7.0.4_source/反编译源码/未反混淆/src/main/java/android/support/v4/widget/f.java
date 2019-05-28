package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class f extends BaseAdapter implements a, Filterable {
    protected boolean PG = false;
    protected boolean PH = true;
    protected Cursor PI = null;
    protected int PJ;
    protected a PK;
    protected DataSetObserver PL;
    protected g PM;
    protected FilterQueryProvider PN;
    protected Context mContext;

    class b extends DataSetObserver {
        b() {
        }

        public final void onChanged() {
            f.this.PG = true;
            f.this.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            f.this.PG = false;
            f.this.notifyDataSetInvalidated();
        }
    }

    class a extends ContentObserver {
        a() {
            super(new Handler());
        }

        public final boolean deliverSelfNotifications() {
            return true;
        }

        public final void onChange(boolean z) {
            f.this.onContentChanged();
        }
    }

    public abstract void a(View view, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public f(Context context) {
        this.mContext = context;
        this.PJ = -1;
        this.PK = new a();
        this.PL = new b();
    }

    public final Cursor getCursor() {
        return this.PI;
    }

    public int getCount() {
        if (!this.PG || this.PI == null) {
            return 0;
        }
        return this.PI.getCount();
    }

    public Object getItem(int i) {
        if (!this.PG || this.PI == null) {
            return null;
        }
        this.PI.moveToPosition(i);
        return this.PI;
    }

    public long getItemId(int i) {
        if (this.PG && this.PI != null && this.PI.moveToPosition(i)) {
            return this.PI.getLong(this.PJ);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.PG) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.PI.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.PI, viewGroup);
            }
            a(view, this.PI);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(i)));
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.PG) {
            return null;
        }
        this.PI.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.PI, viewGroup);
        }
        a(view, this.PI);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        if (this.PN != null) {
            return this.PN.runQuery(charSequence);
        }
        return this.PI;
    }

    public Filter getFilter() {
        if (this.PM == null) {
            this.PM = new g(this);
        }
        return this.PM;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onContentChanged() {
        if (this.PH && this.PI != null && !this.PI.isClosed()) {
            this.PG = this.PI.requery();
        }
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.PI) {
            cursor2 = null;
        } else {
            cursor2 = this.PI;
            if (cursor2 != null) {
                if (this.PK != null) {
                    cursor2.unregisterContentObserver(this.PK);
                }
                if (this.PL != null) {
                    cursor2.unregisterDataSetObserver(this.PL);
                }
            }
            this.PI = cursor;
            if (cursor != null) {
                if (this.PK != null) {
                    cursor.registerContentObserver(this.PK);
                }
                if (this.PL != null) {
                    cursor.registerDataSetObserver(this.PL);
                }
                this.PJ = cursor.getColumnIndexOrThrow("_id");
                this.PG = true;
                notifyDataSetChanged();
            } else {
                this.PJ = -1;
                this.PG = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }
}
