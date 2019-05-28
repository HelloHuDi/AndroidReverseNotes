package com.tencent.wcdb;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public interface Cursor extends android.database.Cursor {
    public static final int FIELD_TYPE_BLOB = 4;
    public static final int FIELD_TYPE_FLOAT = 2;
    public static final int FIELD_TYPE_INTEGER = 1;
    public static final int FIELD_TYPE_NULL = 0;
    public static final int FIELD_TYPE_STRING = 3;

    void close();

    void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer);

    void deactivate();

    byte[] getBlob(int i);

    int getColumnCount();

    int getColumnIndex(String str);

    int getColumnIndexOrThrow(String str);

    String getColumnName(int i);

    String[] getColumnNames();

    int getCount();

    double getDouble(int i);

    Bundle getExtras();

    float getFloat(int i);

    int getInt(int i);

    long getLong(int i);

    int getPosition();

    short getShort(int i);

    String getString(int i);

    int getType(int i);

    boolean getWantsAllOnMoveCalls();

    boolean isAfterLast();

    boolean isBeforeFirst();

    boolean isClosed();

    boolean isFirst();

    boolean isLast();

    boolean isNull(int i);

    boolean move(int i);

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveToNext();

    boolean moveToPosition(int i);

    boolean moveToPrevious();

    void registerContentObserver(ContentObserver contentObserver);

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    @Deprecated
    boolean requery();

    Bundle respond(Bundle bundle);

    void setNotificationUri(ContentResolver contentResolver, Uri uri);

    void unregisterContentObserver(ContentObserver contentObserver);

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
