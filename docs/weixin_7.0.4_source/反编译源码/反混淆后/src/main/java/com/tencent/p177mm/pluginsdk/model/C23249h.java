package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.pluginsdk.model.h */
public final class C23249h {

    /* renamed from: com.tencent.mm.pluginsdk.model.h$a */
    public interface C14889a {
        /* renamed from: A */
        void mo24138A(ArrayList<C44064n> arrayList);
    }

    /* renamed from: a */
    public static void m35678a(final Context context, final String[] strArr, final C14889a c14889a) {
        AppMethodBeat.m2504i(79213);
        if (c14889a == null || strArr == null || strArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.m2505o(79213);
            throw illegalArgumentException;
        }
        new AsyncTask<Void, Void, Cursor>() {
            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ void onPostExecute(Object obj) {
                AppMethodBeat.m2504i(79211);
                Cursor cursor = (Cursor) obj;
                if (cursor == null || cursor.getCount() <= 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String c44064n : strArr) {
                        arrayList.add(new C44064n(-1, c44064n, "", "", "", 10237));
                    }
                    c14889a.mo24138A(arrayList);
                } else {
                    cursor.moveToFirst();
                    ArrayList o = C23249h.m35679o(cursor);
                    cursor.close();
                    c14889a.mo24138A(o);
                }
                super.onPostExecute(cursor);
                AppMethodBeat.m2505o(79211);
            }

            /* Access modifiers changed, original: protected|final|synthetic */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                AppMethodBeat.m2504i(79212);
                Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.gwallet.queryprovider"), null, null, strArr, null);
                AppMethodBeat.m2505o(79212);
                return query;
            }
        }.execute(new Void[0]);
        AppMethodBeat.m2505o(79213);
    }

    /* renamed from: o */
    static /* synthetic */ ArrayList m35679o(Cursor cursor) {
        AppMethodBeat.m2504i(79214);
        if (cursor == null) {
            AppMethodBeat.m2505o(79214);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(new C44064n(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("product_id")), cursor.getString(cursor.getColumnIndex("full_price")), cursor.getString(cursor.getColumnIndex("price_currency")), cursor.getString(cursor.getColumnIndex("price_amount")), cursor.getInt(cursor.getColumnIndex("product_state"))));
            cursor.moveToNext();
        }
        AppMethodBeat.m2505o(79214);
        return arrayList;
    }
}
