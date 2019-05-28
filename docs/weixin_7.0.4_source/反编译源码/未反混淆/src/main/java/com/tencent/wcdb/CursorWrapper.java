package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CursorWrapper implements Cursor {
    protected final Cursor mCursor;

    public CursorWrapper(Cursor cursor) {
        this.mCursor = cursor;
    }

    public Cursor getWrappedCursor() {
        return this.mCursor;
    }

    public void close() {
        AppMethodBeat.i(12057);
        this.mCursor.close();
        AppMethodBeat.o(12057);
    }

    public boolean isClosed() {
        AppMethodBeat.i(12058);
        boolean isClosed = this.mCursor.isClosed();
        AppMethodBeat.o(12058);
        return isClosed;
    }

    public int getCount() {
        AppMethodBeat.i(12059);
        int count = this.mCursor.getCount();
        AppMethodBeat.o(12059);
        return count;
    }

    public void deactivate() {
        AppMethodBeat.i(12060);
        this.mCursor.deactivate();
        AppMethodBeat.o(12060);
    }

    public boolean moveToFirst() {
        AppMethodBeat.i(12061);
        boolean moveToFirst = this.mCursor.moveToFirst();
        AppMethodBeat.o(12061);
        return moveToFirst;
    }

    public int getColumnCount() {
        AppMethodBeat.i(12062);
        int columnCount = this.mCursor.getColumnCount();
        AppMethodBeat.o(12062);
        return columnCount;
    }

    public int getColumnIndex(String str) {
        AppMethodBeat.i(12063);
        int columnIndex = this.mCursor.getColumnIndex(str);
        AppMethodBeat.o(12063);
        return columnIndex;
    }

    public int getColumnIndexOrThrow(String str) {
        AppMethodBeat.i(12064);
        int columnIndexOrThrow = this.mCursor.getColumnIndexOrThrow(str);
        AppMethodBeat.o(12064);
        return columnIndexOrThrow;
    }

    public String getColumnName(int i) {
        AppMethodBeat.i(12065);
        String columnName = this.mCursor.getColumnName(i);
        AppMethodBeat.o(12065);
        return columnName;
    }

    public String[] getColumnNames() {
        AppMethodBeat.i(12066);
        String[] columnNames = this.mCursor.getColumnNames();
        AppMethodBeat.o(12066);
        return columnNames;
    }

    public double getDouble(int i) {
        AppMethodBeat.i(12067);
        double d = this.mCursor.getDouble(i);
        AppMethodBeat.o(12067);
        return d;
    }

    public Bundle getExtras() {
        AppMethodBeat.i(12068);
        Bundle extras = this.mCursor.getExtras();
        AppMethodBeat.o(12068);
        return extras;
    }

    public float getFloat(int i) {
        AppMethodBeat.i(12069);
        float f = this.mCursor.getFloat(i);
        AppMethodBeat.o(12069);
        return f;
    }

    public int getInt(int i) {
        AppMethodBeat.i(12070);
        int i2 = this.mCursor.getInt(i);
        AppMethodBeat.o(12070);
        return i2;
    }

    public long getLong(int i) {
        AppMethodBeat.i(12071);
        long j = this.mCursor.getLong(i);
        AppMethodBeat.o(12071);
        return j;
    }

    public short getShort(int i) {
        AppMethodBeat.i(12072);
        short s = this.mCursor.getShort(i);
        AppMethodBeat.o(12072);
        return s;
    }

    public String getString(int i) {
        AppMethodBeat.i(12073);
        String string = this.mCursor.getString(i);
        AppMethodBeat.o(12073);
        return string;
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.i(12074);
        this.mCursor.copyStringToBuffer(i, charArrayBuffer);
        AppMethodBeat.o(12074);
    }

    public byte[] getBlob(int i) {
        AppMethodBeat.i(12075);
        byte[] blob = this.mCursor.getBlob(i);
        AppMethodBeat.o(12075);
        return blob;
    }

    public boolean getWantsAllOnMoveCalls() {
        AppMethodBeat.i(12076);
        boolean wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();
        AppMethodBeat.o(12076);
        return wantsAllOnMoveCalls;
    }

    public void setExtras(Bundle bundle) {
    }

    public boolean isAfterLast() {
        AppMethodBeat.i(12077);
        boolean isAfterLast = this.mCursor.isAfterLast();
        AppMethodBeat.o(12077);
        return isAfterLast;
    }

    public boolean isBeforeFirst() {
        AppMethodBeat.i(12078);
        boolean isBeforeFirst = this.mCursor.isBeforeFirst();
        AppMethodBeat.o(12078);
        return isBeforeFirst;
    }

    public boolean isFirst() {
        AppMethodBeat.i(12079);
        boolean isFirst = this.mCursor.isFirst();
        AppMethodBeat.o(12079);
        return isFirst;
    }

    public boolean isLast() {
        AppMethodBeat.i(12080);
        boolean isLast = this.mCursor.isLast();
        AppMethodBeat.o(12080);
        return isLast;
    }

    public int getType(int i) {
        AppMethodBeat.i(12081);
        int type = this.mCursor.getType(i);
        AppMethodBeat.o(12081);
        return type;
    }

    public boolean isNull(int i) {
        AppMethodBeat.i(12082);
        boolean isNull = this.mCursor.isNull(i);
        AppMethodBeat.o(12082);
        return isNull;
    }

    public boolean moveToLast() {
        AppMethodBeat.i(12083);
        boolean moveToLast = this.mCursor.moveToLast();
        AppMethodBeat.o(12083);
        return moveToLast;
    }

    public boolean move(int i) {
        AppMethodBeat.i(12084);
        boolean move = this.mCursor.move(i);
        AppMethodBeat.o(12084);
        return move;
    }

    public boolean moveToPosition(int i) {
        AppMethodBeat.i(12085);
        boolean moveToPosition = this.mCursor.moveToPosition(i);
        AppMethodBeat.o(12085);
        return moveToPosition;
    }

    public boolean moveToNext() {
        AppMethodBeat.i(12086);
        boolean moveToNext = this.mCursor.moveToNext();
        AppMethodBeat.o(12086);
        return moveToNext;
    }

    public int getPosition() {
        AppMethodBeat.i(12087);
        int position = this.mCursor.getPosition();
        AppMethodBeat.o(12087);
        return position;
    }

    public boolean moveToPrevious() {
        AppMethodBeat.i(12088);
        boolean moveToPrevious = this.mCursor.moveToPrevious();
        AppMethodBeat.o(12088);
        return moveToPrevious;
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(12089);
        this.mCursor.registerContentObserver(contentObserver);
        AppMethodBeat.o(12089);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(12090);
        this.mCursor.registerDataSetObserver(dataSetObserver);
        AppMethodBeat.o(12090);
    }

    public boolean requery() {
        AppMethodBeat.i(12091);
        boolean requery = this.mCursor.requery();
        AppMethodBeat.o(12091);
        return requery;
    }

    public Bundle respond(Bundle bundle) {
        AppMethodBeat.i(12092);
        Bundle respond = this.mCursor.respond(bundle);
        AppMethodBeat.o(12092);
        return respond;
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        AppMethodBeat.i(12093);
        this.mCursor.setNotificationUri(contentResolver, uri);
        AppMethodBeat.o(12093);
    }

    public Uri getNotificationUri() {
        return null;
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.i(12094);
        this.mCursor.unregisterContentObserver(contentObserver);
        AppMethodBeat.o(12094);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.i(12095);
        this.mCursor.unregisterDataSetObserver(dataSetObserver);
        AppMethodBeat.o(12095);
    }
}
