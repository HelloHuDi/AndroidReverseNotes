package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class h {

    public interface a {
        void A(ArrayList<n> arrayList);
    }

    public static void a(final Context context, final String[] strArr, final a aVar) {
        AppMethodBeat.i(79213);
        if (aVar == null || strArr == null || strArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(79213);
            throw illegalArgumentException;
        }
        new AsyncTask<Void, Void, Cursor>() {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ void onPostExecute(Object obj) {
                AppMethodBeat.i(79211);
                Cursor cursor = (Cursor) obj;
                if (cursor == null || cursor.getCount() <= 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String nVar : strArr) {
                        arrayList.add(new n(-1, nVar, "", "", "", 10237));
                    }
                    aVar.A(arrayList);
                } else {
                    cursor.moveToFirst();
                    ArrayList o = h.o(cursor);
                    cursor.close();
                    aVar.A(o);
                }
                super.onPostExecute(cursor);
                AppMethodBeat.o(79211);
            }

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                AppMethodBeat.i(79212);
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.gwallet.queryprovider"), null, null, strArr, null);
                AppMethodBeat.o(79212);
                return query;
            }
        }.execute(new Void[0]);
        AppMethodBeat.o(79213);
    }

    static /* synthetic */ ArrayList o(Cursor cursor) {
        AppMethodBeat.i(79214);
        if (cursor == null) {
            AppMethodBeat.o(79214);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(new n(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("product_id")), cursor.getString(cursor.getColumnIndex("full_price")), cursor.getString(cursor.getColumnIndex("price_currency")), cursor.getString(cursor.getColumnIndex("price_amount")), cursor.getInt(cursor.getColumnIndex("product_state"))));
            cursor.moveToNext();
        }
        AppMethodBeat.o(79214);
        return arrayList;
    }
}
