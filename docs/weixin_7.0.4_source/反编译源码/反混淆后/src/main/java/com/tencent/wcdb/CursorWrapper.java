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
        AppMethodBeat.m2504i(12057);
        this.mCursor.close();
        AppMethodBeat.m2505o(12057);
    }

    public boolean isClosed() {
        AppMethodBeat.m2504i(12058);
        boolean isClosed = this.mCursor.isClosed();
        AppMethodBeat.m2505o(12058);
        return isClosed;
    }

    public int getCount() {
        AppMethodBeat.m2504i(12059);
        int count = this.mCursor.getCount();
        AppMethodBeat.m2505o(12059);
        return count;
    }

    public void deactivate() {
        AppMethodBeat.m2504i(12060);
        this.mCursor.deactivate();
        AppMethodBeat.m2505o(12060);
    }

    public boolean moveToFirst() {
        AppMethodBeat.m2504i(12061);
        boolean moveToFirst = this.mCursor.moveToFirst();
        AppMethodBeat.m2505o(12061);
        return moveToFirst;
    }

    public int getColumnCount() {
        AppMethodBeat.m2504i(12062);
        int columnCount = this.mCursor.getColumnCount();
        AppMethodBeat.m2505o(12062);
        return columnCount;
    }

    public int getColumnIndex(String str) {
        AppMethodBeat.m2504i(12063);
        int columnIndex = this.mCursor.getColumnIndex(str);
        AppMethodBeat.m2505o(12063);
        return columnIndex;
    }

    public int getColumnIndexOrThrow(String str) {
        AppMethodBeat.m2504i(12064);
        int columnIndexOrThrow = this.mCursor.getColumnIndexOrThrow(str);
        AppMethodBeat.m2505o(12064);
        return columnIndexOrThrow;
    }

    public String getColumnName(int i) {
        AppMethodBeat.m2504i(12065);
        String columnName = this.mCursor.getColumnName(i);
        AppMethodBeat.m2505o(12065);
        return columnName;
    }

    public String[] getColumnNames() {
        AppMethodBeat.m2504i(12066);
        String[] columnNames = this.mCursor.getColumnNames();
        AppMethodBeat.m2505o(12066);
        return columnNames;
    }

    public double getDouble(int i) {
        AppMethodBeat.m2504i(12067);
        double d = this.mCursor.getDouble(i);
        AppMethodBeat.m2505o(12067);
        return d;
    }

    public Bundle getExtras() {
        AppMethodBeat.m2504i(12068);
        Bundle extras = this.mCursor.getExtras();
        AppMethodBeat.m2505o(12068);
        return extras;
    }

    public float getFloat(int i) {
        AppMethodBeat.m2504i(12069);
        float f = this.mCursor.getFloat(i);
        AppMethodBeat.m2505o(12069);
        return f;
    }

    public int getInt(int i) {
        AppMethodBeat.m2504i(12070);
        int i2 = this.mCursor.getInt(i);
        AppMethodBeat.m2505o(12070);
        return i2;
    }

    public long getLong(int i) {
        AppMethodBeat.m2504i(12071);
        long j = this.mCursor.getLong(i);
        AppMethodBeat.m2505o(12071);
        return j;
    }

    public short getShort(int i) {
        AppMethodBeat.m2504i(12072);
        short s = this.mCursor.getShort(i);
        AppMethodBeat.m2505o(12072);
        return s;
    }

    public String getString(int i) {
        AppMethodBeat.m2504i(12073);
        String string = this.mCursor.getString(i);
        AppMethodBeat.m2505o(12073);
        return string;
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        AppMethodBeat.m2504i(12074);
        this.mCursor.copyStringToBuffer(i, charArrayBuffer);
        AppMethodBeat.m2505o(12074);
    }

    public byte[] getBlob(int i) {
        AppMethodBeat.m2504i(12075);
        byte[] blob = this.mCursor.getBlob(i);
        AppMethodBeat.m2505o(12075);
        return blob;
    }

    public boolean getWantsAllOnMoveCalls() {
        AppMethodBeat.m2504i(12076);
        boolean wantsAllOnMoveCalls = this.mCursor.getWantsAllOnMoveCalls();
        AppMethodBeat.m2505o(12076);
        return wantsAllOnMoveCalls;
    }

    public void setExtras(Bundle bundle) {
    }

    public boolean isAfterLast() {
        AppMethodBeat.m2504i(12077);
        boolean isAfterLast = this.mCursor.isAfterLast();
        AppMethodBeat.m2505o(12077);
        return isAfterLast;
    }

    public boolean isBeforeFirst() {
        AppMethodBeat.m2504i(12078);
        boolean isBeforeFirst = this.mCursor.isBeforeFirst();
        AppMethodBeat.m2505o(12078);
        return isBeforeFirst;
    }

    public boolean isFirst() {
        AppMethodBeat.m2504i(12079);
        boolean isFirst = this.mCursor.isFirst();
        AppMethodBeat.m2505o(12079);
        return isFirst;
    }

    public boolean isLast() {
        AppMethodBeat.m2504i(12080);
        boolean isLast = this.mCursor.isLast();
        AppMethodBeat.m2505o(12080);
        return isLast;
    }

    public int getType(int i) {
        AppMethodBeat.m2504i(12081);
        int type = this.mCursor.getType(i);
        AppMethodBeat.m2505o(12081);
        return type;
    }

    public boolean isNull(int i) {
        AppMethodBeat.m2504i(12082);
        boolean isNull = this.mCursor.isNull(i);
        AppMethodBeat.m2505o(12082);
        return isNull;
    }

    public boolean moveToLast() {
        AppMethodBeat.m2504i(12083);
        boolean moveToLast = this.mCursor.moveToLast();
        AppMethodBeat.m2505o(12083);
        return moveToLast;
    }

    public boolean move(int i) {
        AppMethodBeat.m2504i(12084);
        boolean move = this.mCursor.move(i);
        AppMethodBeat.m2505o(12084);
        return move;
    }

    public boolean moveToPosition(int i) {
        AppMethodBeat.m2504i(12085);
        boolean moveToPosition = this.mCursor.moveToPosition(i);
        AppMethodBeat.m2505o(12085);
        return moveToPosition;
    }

    public boolean moveToNext() {
        AppMethodBeat.m2504i(12086);
        boolean moveToNext = this.mCursor.moveToNext();
        AppMethodBeat.m2505o(12086);
        return moveToNext;
    }

    public int getPosition() {
        AppMethodBeat.m2504i(12087);
        int position = this.mCursor.getPosition();
        AppMethodBeat.m2505o(12087);
        return position;
    }

    public boolean moveToPrevious() {
        AppMethodBeat.m2504i(12088);
        boolean moveToPrevious = this.mCursor.moveToPrevious();
        AppMethodBeat.m2505o(12088);
        return moveToPrevious;
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.m2504i(12089);
        this.mCursor.registerContentObserver(contentObserver);
        AppMethodBeat.m2505o(12089);
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.m2504i(12090);
        this.mCursor.registerDataSetObserver(dataSetObserver);
        AppMethodBeat.m2505o(12090);
    }

    public boolean requery() {
        AppMethodBeat.m2504i(12091);
        boolean requery = this.mCursor.requery();
        AppMethodBeat.m2505o(12091);
        return requery;
    }

    public Bundle respond(Bundle bundle) {
        AppMethodBeat.m2504i(12092);
        Bundle respond = this.mCursor.respond(bundle);
        AppMethodBeat.m2505o(12092);
        return respond;
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        AppMethodBeat.m2504i(12093);
        this.mCursor.setNotificationUri(contentResolver, uri);
        AppMethodBeat.m2505o(12093);
    }

    public Uri getNotificationUri() {
        return null;
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        AppMethodBeat.m2504i(12094);
        this.mCursor.unregisterContentObserver(contentObserver);
        AppMethodBeat.m2505o(12094);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        AppMethodBeat.m2504i(12095);
        this.mCursor.unregisterDataSetObserver(dataSetObserver);
        AppMethodBeat.m2505o(12095);
    }
}
