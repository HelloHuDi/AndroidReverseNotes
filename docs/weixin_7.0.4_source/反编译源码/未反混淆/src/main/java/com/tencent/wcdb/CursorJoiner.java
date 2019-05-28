package com.tencent.wcdb;

import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class CursorJoiner implements Iterable<Result>, Iterator<Result> {
    private int[] mColumnsLeft;
    private int[] mColumnsRight;
    private Result mCompareResult;
    private boolean mCompareResultIsValid;
    private Cursor mCursorLeft;
    private Cursor mCursorRight;
    private String[] mValues;

    public enum Result {
        RIGHT,
        LEFT,
        BOTH;

        static {
            AppMethodBeat.o(11993);
        }
    }

    public CursorJoiner(Cursor cursor, String[] strArr, Cursor cursor2, String[] strArr2) {
        AppMethodBeat.i(11994);
        if (strArr.length != strArr2.length) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("you must have the same number of columns on the left and right, " + strArr.length + " != " + strArr2.length);
            AppMethodBeat.o(11994);
            throw illegalArgumentException;
        }
        this.mCursorLeft = cursor;
        this.mCursorRight = cursor2;
        this.mCursorLeft.moveToFirst();
        this.mCursorRight.moveToFirst();
        this.mCompareResultIsValid = false;
        this.mColumnsLeft = buildColumnIndiciesArray(cursor, strArr);
        this.mColumnsRight = buildColumnIndiciesArray(cursor2, strArr2);
        this.mValues = new String[(this.mColumnsLeft.length * 2)];
        AppMethodBeat.o(11994);
    }

    public final Iterator<Result> iterator() {
        return this;
    }

    private int[] buildColumnIndiciesArray(Cursor cursor, String[] strArr) {
        AppMethodBeat.i(11995);
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = cursor.getColumnIndexOrThrow(strArr[i]);
        }
        AppMethodBeat.o(11995);
        return iArr;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(11996);
        if (this.mCompareResultIsValid) {
            switch (this.mCompareResult) {
                case BOTH:
                    if (this.mCursorLeft.isLast() && this.mCursorRight.isLast()) {
                        AppMethodBeat.o(11996);
                        return false;
                    }
                    AppMethodBeat.o(11996);
                    return true;
                case LEFT:
                    if (this.mCursorLeft.isLast() && this.mCursorRight.isAfterLast()) {
                        AppMethodBeat.o(11996);
                        return false;
                    }
                    AppMethodBeat.o(11996);
                    return true;
                case RIGHT:
                    if (this.mCursorLeft.isAfterLast() && this.mCursorRight.isLast()) {
                        AppMethodBeat.o(11996);
                        return false;
                    }
                    AppMethodBeat.o(11996);
                    return true;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("bad value for mCompareResult, " + this.mCompareResult);
                    AppMethodBeat.o(11996);
                    throw illegalStateException;
            }
        } else if (this.mCursorLeft.isAfterLast() && this.mCursorRight.isAfterLast()) {
            AppMethodBeat.o(11996);
            return false;
        } else {
            AppMethodBeat.o(11996);
            return true;
        }
    }

    public final Result next() {
        AppMethodBeat.i(11997);
        if (hasNext()) {
            incrementCursors();
            int i = !this.mCursorLeft.isAfterLast() ? 1 : 0;
            int i2;
            if (this.mCursorRight.isAfterLast()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            if (i != 0 && i2 != 0) {
                populateValues(this.mValues, this.mCursorLeft, this.mColumnsLeft, 0);
                populateValues(this.mValues, this.mCursorRight, this.mColumnsRight, 1);
                switch (compareStrings(this.mValues)) {
                    case -1:
                        this.mCompareResult = Result.LEFT;
                        break;
                    case 0:
                        this.mCompareResult = Result.BOTH;
                        break;
                    case 1:
                        this.mCompareResult = Result.RIGHT;
                        break;
                }
            } else if (i != 0) {
                this.mCompareResult = Result.LEFT;
            } else {
                this.mCompareResult = Result.RIGHT;
            }
            this.mCompareResultIsValid = true;
            Result result = this.mCompareResult;
            AppMethodBeat.o(11997);
            return result;
        }
        IllegalStateException illegalStateException = new IllegalStateException("you must only call next() when hasNext() is true");
        AppMethodBeat.o(11997);
        throw illegalStateException;
    }

    public final void remove() {
        AppMethodBeat.i(11998);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("not implemented");
        AppMethodBeat.o(11998);
        throw unsupportedOperationException;
    }

    private static void populateValues(String[] strArr, Cursor cursor, int[] iArr, int i) {
        AppMethodBeat.i(11999);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            strArr[(i2 * 2) + i] = cursor.getString(iArr[i2]);
        }
        AppMethodBeat.o(11999);
    }

    private void incrementCursors() {
        AppMethodBeat.i(12000);
        if (this.mCompareResultIsValid) {
            switch (this.mCompareResult) {
                case BOTH:
                    this.mCursorLeft.moveToNext();
                    this.mCursorRight.moveToNext();
                    break;
                case LEFT:
                    this.mCursorLeft.moveToNext();
                    break;
                case RIGHT:
                    this.mCursorRight.moveToNext();
                    break;
            }
            this.mCompareResultIsValid = false;
        }
        AppMethodBeat.o(12000);
    }

    private static int compareStrings(String... strArr) {
        AppMethodBeat.i(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
        if (strArr.length % 2 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("you must specify an even number of values");
            AppMethodBeat.o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
            throw illegalArgumentException;
        }
        for (int i = 0; i < strArr.length; i += 2) {
            if (strArr[i] == null) {
                if (strArr[i + 1] != null) {
                    AppMethodBeat.o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
                    return -1;
                }
            } else if (strArr[i + 1] == null) {
                AppMethodBeat.o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
                return 1;
            } else {
                int compareTo = strArr[i].compareTo(strArr[i + 1]);
                if (compareTo != 0) {
                    if (compareTo < 0) {
                        AppMethodBeat.o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
                        return -1;
                    }
                    AppMethodBeat.o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
                    return 1;
                }
            }
        }
        AppMethodBeat.o(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_SUCCESS);
        return 0;
    }
}
