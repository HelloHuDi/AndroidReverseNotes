package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

final class g extends Filter {
    a PP;

    interface a {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    g(a aVar) {
        this.PP = aVar;
    }

    public final CharSequence convertResultToString(Object obj) {
        return this.PP.convertToString((Cursor) obj);
    }

    /* Access modifiers changed, original: protected|final */
    public final FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.PP.runQueryOnBackgroundThread(charSequence);
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
        Cursor cursor = this.PP.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.PP.changeCursor((Cursor) filterResults.values);
        }
    }
}
