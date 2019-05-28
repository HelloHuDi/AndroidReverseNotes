package android.support.p057v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.p057v4.widget.C41520g.C17466a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* renamed from: android.support.v4.widget.f */
public abstract class C41519f extends BaseAdapter implements C17466a, Filterable {
    /* renamed from: PG */
    protected boolean f16836PG = false;
    /* renamed from: PH */
    protected boolean f16837PH = true;
    /* renamed from: PI */
    protected Cursor f16838PI = null;
    /* renamed from: PJ */
    protected int f16839PJ;
    /* renamed from: PK */
    protected C41518a f16840PK;
    /* renamed from: PL */
    protected DataSetObserver f16841PL;
    /* renamed from: PM */
    protected C41520g f16842PM;
    /* renamed from: PN */
    protected FilterQueryProvider f16843PN;
    protected Context mContext;

    /* renamed from: android.support.v4.widget.f$b */
    class C25366b extends DataSetObserver {
        C25366b() {
        }

        public final void onChanged() {
            C41519f.this.f16836PG = true;
            C41519f.this.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            C41519f.this.f16836PG = false;
            C41519f.this.notifyDataSetInvalidated();
        }
    }

    /* renamed from: android.support.v4.widget.f$a */
    class C41518a extends ContentObserver {
        C41518a() {
            super(new Handler());
        }

        public final boolean deliverSelfNotifications() {
            return true;
        }

        public final void onChange(boolean z) {
            C41519f.this.onContentChanged();
        }
    }

    /* renamed from: a */
    public abstract void mo59211a(View view, Cursor cursor);

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public C41519f(Context context) {
        this.mContext = context;
        this.f16839PJ = -1;
        this.f16840PK = new C41518a();
        this.f16841PL = new C25366b();
    }

    public final Cursor getCursor() {
        return this.f16838PI;
    }

    public int getCount() {
        if (!this.f16836PG || this.f16838PI == null) {
            return 0;
        }
        return this.f16838PI.getCount();
    }

    public Object getItem(int i) {
        if (!this.f16836PG || this.f16838PI == null) {
            return null;
        }
        this.f16838PI.moveToPosition(i);
        return this.f16838PI;
    }

    public long getItemId(int i) {
        if (this.f16836PG && this.f16838PI != null && this.f16838PI.moveToPosition(i)) {
            return this.f16838PI.getLong(this.f16839PJ);
        }
        return 0;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f16836PG) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f16838PI.moveToPosition(i)) {
            if (view == null) {
                view = newView(this.mContext, this.f16838PI, viewGroup);
            }
            mo59211a(view, this.f16838PI);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(i)));
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f16836PG) {
            return null;
        }
        this.f16838PI.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.f16838PI, viewGroup);
        }
        mo59211a(view, this.f16838PI);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        if (this.f16843PN != null) {
            return this.f16843PN.runQuery(charSequence);
        }
        return this.f16838PI;
    }

    public Filter getFilter() {
        if (this.f16842PM == null) {
            this.f16842PM = new C41520g(this);
        }
        return this.f16842PM;
    }

    /* Access modifiers changed, original: protected|final */
    public final void onContentChanged() {
        if (this.f16837PH && this.f16838PI != null && !this.f16838PI.isClosed()) {
            this.f16836PG = this.f16838PI.requery();
        }
    }

    public void changeCursor(Cursor cursor) {
        Cursor cursor2;
        if (cursor == this.f16838PI) {
            cursor2 = null;
        } else {
            cursor2 = this.f16838PI;
            if (cursor2 != null) {
                if (this.f16840PK != null) {
                    cursor2.unregisterContentObserver(this.f16840PK);
                }
                if (this.f16841PL != null) {
                    cursor2.unregisterDataSetObserver(this.f16841PL);
                }
            }
            this.f16838PI = cursor;
            if (cursor != null) {
                if (this.f16840PK != null) {
                    cursor.registerContentObserver(this.f16840PK);
                }
                if (this.f16841PL != null) {
                    cursor.registerDataSetObserver(this.f16841PL);
                }
                this.f16839PJ = cursor.getColumnIndexOrThrow("_id");
                this.f16836PG = true;
                notifyDataSetChanged();
            } else {
                this.f16839PJ = -1;
                this.f16836PG = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }
}
