package android.support.p057v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

/* renamed from: android.support.v4.widget.g */
final class C41520g extends Filter {
    /* renamed from: PP */
    C17466a f16844PP;

    /* renamed from: android.support.v4.widget.g$a */
    interface C17466a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    C41520g(C17466a c17466a) {
        this.f16844PP = c17466a;
    }

    public final CharSequence convertResultToString(Object obj) {
        return this.f16844PP.convertToString((Cursor) obj);
    }

    /* Access modifiers changed, original: protected|final */
    public final FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.f16844PP.runQueryOnBackgroundThread(charSequence);
        FilterResults filterResults = new FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* Access modifiers changed, original: protected|final */
    public final void publishResults(CharSequence charSequence, FilterResults filterResults) {
        Cursor cursor = this.f16844PP.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.f16844PP.changeCursor((Cursor) filterResults.values);
        }
    }
}
