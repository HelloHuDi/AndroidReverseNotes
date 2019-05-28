package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IInterface;

public interface IBulkCursor extends IInterface {
    public static final int CLOSE_TRANSACTION = 7;
    public static final int DEACTIVATE_TRANSACTION = 2;
    public static final int GET_CURSOR_WINDOW_TRANSACTION = 1;
    public static final int GET_EXTRAS_TRANSACTION = 5;
    public static final int ON_MOVE_TRANSACTION = 4;
    public static final int REQUERY_TRANSACTION = 3;
    public static final int RESPOND_TRANSACTION = 6;
    public static final String descriptor = "android.content.IBulkCursor";

    void close();

    void deactivate();

    Bundle getExtras();

    CursorWindow getWindow(int i);

    void onMove(int i);

    int requery(IContentObserver iContentObserver);

    Bundle respond(Bundle bundle);
}
