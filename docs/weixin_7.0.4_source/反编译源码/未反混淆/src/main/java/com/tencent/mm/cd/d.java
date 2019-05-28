package com.tencent.mm.cd;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a.a;
import com.tencent.mm.cd.a.f;
import java.util.HashMap;

public final class d implements Cursor, com.tencent.mm.cd.a.d {
    private static Cursor ybs;

    public static Cursor dvo() {
        AppMethodBeat.i(59037);
        if (ybs == null) {
            ybs = new d();
        }
        Cursor cursor = ybs;
        AppMethodBeat.o(59037);
        return cursor;
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void setNotificationUri(ContentResolver contentResolver, Uri uri) {
    }

    public final Bundle respond(Bundle bundle) {
        return null;
    }

    public final boolean requery() {
        return false;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final boolean moveToPrevious() {
        return false;
    }

    public final boolean moveToPosition(int i) {
        return false;
    }

    public final boolean moveToNext() {
        return false;
    }

    public final boolean moveToLast() {
        return false;
    }

    public final boolean moveToFirst() {
        return false;
    }

    public final boolean move(int i) {
        return false;
    }

    public final boolean isNull(int i) {
        return false;
    }

    public final boolean isLast() {
        return false;
    }

    public final boolean isFirst() {
        return false;
    }

    public final boolean isClosed() {
        return false;
    }

    public final boolean isBeforeFirst() {
        return false;
    }

    public final boolean isAfterLast() {
        return true;
    }

    public final boolean getWantsAllOnMoveCalls() {
        return false;
    }

    public final String getString(int i) {
        return null;
    }

    public final short getShort(int i) {
        return (short) 0;
    }

    public final int getPosition() {
        return 0;
    }

    public final long getLong(int i) {
        return 0;
    }

    public final int getInt(int i) {
        return 0;
    }

    public final float getFloat(int i) {
        return 0.0f;
    }

    public final Bundle getExtras() {
        return null;
    }

    public final double getDouble(int i) {
        return 0.0d;
    }

    public final int getCount() {
        return 0;
    }

    public final String[] getColumnNames() {
        return null;
    }

    public final String getColumnName(int i) {
        return null;
    }

    public final int getColumnIndexOrThrow(String str) {
        return 0;
    }

    public final int getColumnIndex(String str) {
        return 0;
    }

    public final int getColumnCount() {
        return 0;
    }

    public final byte[] getBlob(int i) {
        return null;
    }

    public final void deactivate() {
    }

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void close() {
    }

    public final int getType(int i) {
        return 0;
    }

    public final boolean MF(int i) {
        return false;
    }

    public final boolean cK(Object obj) {
        return false;
    }

    public final a MG(int i) {
        return null;
    }

    public final a cL(Object obj) {
        return null;
    }

    public final SparseArray[] dvp() {
        return null;
    }

    public final HashMap dvq() {
        return null;
    }

    public final boolean dvr() {
        return false;
    }

    public final boolean a(Object obj, a aVar) {
        return false;
    }

    public final void pt(boolean z) {
    }

    public final void a(f.a aVar) {
    }

    public final void MH(int i) {
    }

    public final Uri getNotificationUri() {
        return null;
    }

    public final void setExtras(Bundle bundle) {
    }
}
