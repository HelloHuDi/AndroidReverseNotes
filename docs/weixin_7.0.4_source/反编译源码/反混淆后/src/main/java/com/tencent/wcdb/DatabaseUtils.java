package com.tencent.wcdb;

import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.view.C31128d;
import com.tencent.wcdb.database.SQLiteAbortException;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteConstraintException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteFullException;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Map.Entry;

public final class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final char[] DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int EX_HAS_REPLY_HEADER = -128;
    public static final int STATEMENT_ABORT = 6;
    public static final int STATEMENT_ATTACH = 3;
    public static final int STATEMENT_BEGIN = 4;
    public static final int STATEMENT_COMMIT = 5;
    public static final int STATEMENT_DDL = 8;
    public static final int STATEMENT_OTHER = 99;
    public static final int STATEMENT_PRAGMA = 7;
    public static final int STATEMENT_SELECT = 1;
    public static final int STATEMENT_UNPREPARED = 9;
    public static final int STATEMENT_UPDATE = 2;
    private static final String TAG = "WCDB.DatabaseUtils";
    private static Collator mColl = null;

    @Deprecated
    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private String mInsertSQL = null;
        private SQLiteStatement mInsertStatement = null;
        private SQLiteStatement mPreparedStatement = null;
        private SQLiteStatement mReplaceStatement = null;
        private final String mTableName;

        public InsertHelper(SQLiteDatabase sQLiteDatabase, String str) {
            this.mDb = sQLiteDatabase;
            this.mTableName = str;
        }

        private void buildSQL() {
            Cursor cursor = null;
            AppMethodBeat.m2504i(12096);
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("INSERT INTO ");
            stringBuilder.append(this.mTableName);
            stringBuilder.append(" (");
            StringBuilder stringBuilder2 = new StringBuilder(128);
            stringBuilder2.append("VALUES (");
            try {
                cursor = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);
                this.mColumns = new HashMap(cursor.getCount());
                int i = 1;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    String string2 = cursor.getString(4);
                    this.mColumns.put(string, Integer.valueOf(i));
                    stringBuilder.append("'");
                    stringBuilder.append(string);
                    stringBuilder.append("'");
                    if (string2 == null) {
                        stringBuilder2.append("?");
                    } else {
                        stringBuilder2.append("COALESCE(?, ");
                        stringBuilder2.append(string2);
                        stringBuilder2.append(")");
                    }
                    stringBuilder.append(i == cursor.getCount() ? ") " : ", ");
                    stringBuilder2.append(i == cursor.getCount() ? ");" : ", ");
                    i++;
                }
                if (cursor != null) {
                    cursor.close();
                }
                stringBuilder.append(stringBuilder2);
                this.mInsertSQL = stringBuilder.toString();
                AppMethodBeat.m2505o(12096);
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(12096);
            }
        }

        private SQLiteStatement getStatement(boolean z) {
            AppMethodBeat.m2504i(12097);
            SQLiteStatement sQLiteStatement;
            if (z) {
                if (this.mReplaceStatement == null) {
                    if (this.mInsertSQL == null) {
                        buildSQL();
                    }
                    this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
                }
                sQLiteStatement = this.mReplaceStatement;
                AppMethodBeat.m2505o(12097);
                return sQLiteStatement;
            }
            if (this.mInsertStatement == null) {
                if (this.mInsertSQL == null) {
                    buildSQL();
                }
                this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
            }
            sQLiteStatement = this.mInsertStatement;
            AppMethodBeat.m2505o(12097);
            return sQLiteStatement;
        }

        private long insertInternal(ContentValues contentValues, boolean z) {
            AppMethodBeat.m2504i(12098);
            this.mDb.beginTransactionNonExclusive();
            try {
                SQLiteStatement statement = getStatement(z);
                statement.clearBindings();
                for (Entry entry : contentValues.valueSet()) {
                    DatabaseUtils.bindObjectToProgram(statement, getColumnIndex((String) entry.getKey()), entry.getValue());
                }
                long executeInsert = statement.executeInsert();
                this.mDb.setTransactionSuccessful();
                this.mDb.endTransaction();
                AppMethodBeat.m2505o(12098);
                return executeInsert;
            } catch (SQLException e) {
                Log.m9445e(DatabaseUtils.TAG, "Error inserting " + contentValues + " into table  " + this.mTableName, e);
                this.mDb.endTransaction();
                AppMethodBeat.m2505o(12098);
                return -1;
            } catch (Throwable th) {
                this.mDb.endTransaction();
                AppMethodBeat.m2505o(12098);
            }
        }

        public int getColumnIndex(String str) {
            AppMethodBeat.m2504i(12099);
            getStatement(false);
            Integer num = (Integer) this.mColumns.get(str);
            if (num == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("column '" + str + "' is invalid");
                AppMethodBeat.m2505o(12099);
                throw illegalArgumentException;
            }
            int intValue = num.intValue();
            AppMethodBeat.m2505o(12099);
            return intValue;
        }

        public void bind(int i, double d) {
            AppMethodBeat.m2504i(12100);
            this.mPreparedStatement.bindDouble(i, d);
            AppMethodBeat.m2505o(12100);
        }

        public void bind(int i, float f) {
            AppMethodBeat.m2504i(12101);
            this.mPreparedStatement.bindDouble(i, (double) f);
            AppMethodBeat.m2505o(12101);
        }

        public void bind(int i, long j) {
            AppMethodBeat.m2504i(12102);
            this.mPreparedStatement.bindLong(i, j);
            AppMethodBeat.m2505o(12102);
        }

        public void bind(int i, int i2) {
            AppMethodBeat.m2504i(12103);
            this.mPreparedStatement.bindLong(i, (long) i2);
            AppMethodBeat.m2505o(12103);
        }

        public void bind(int i, boolean z) {
            AppMethodBeat.m2504i(12104);
            this.mPreparedStatement.bindLong(i, z ? 1 : 0);
            AppMethodBeat.m2505o(12104);
        }

        public void bindNull(int i) {
            AppMethodBeat.m2504i(12105);
            this.mPreparedStatement.bindNull(i);
            AppMethodBeat.m2505o(12105);
        }

        public void bind(int i, byte[] bArr) {
            AppMethodBeat.m2504i(12106);
            if (bArr == null) {
                this.mPreparedStatement.bindNull(i);
                AppMethodBeat.m2505o(12106);
                return;
            }
            this.mPreparedStatement.bindBlob(i, bArr);
            AppMethodBeat.m2505o(12106);
        }

        public void bind(int i, String str) {
            AppMethodBeat.m2504i(12107);
            if (str == null) {
                this.mPreparedStatement.bindNull(i);
                AppMethodBeat.m2505o(12107);
                return;
            }
            this.mPreparedStatement.bindString(i, str);
            AppMethodBeat.m2505o(12107);
        }

        public long insert(ContentValues contentValues) {
            AppMethodBeat.m2504i(12108);
            long insertInternal = insertInternal(contentValues, false);
            AppMethodBeat.m2505o(12108);
            return insertInternal;
        }

        public long execute() {
            AppMethodBeat.m2504i(12109);
            if (this.mPreparedStatement == null) {
                IllegalStateException illegalStateException = new IllegalStateException("you must prepare this inserter before calling execute");
                AppMethodBeat.m2505o(12109);
                throw illegalStateException;
            }
            try {
                long executeInsert = this.mPreparedStatement.executeInsert();
                this.mPreparedStatement = null;
                AppMethodBeat.m2505o(12109);
                return executeInsert;
            } catch (SQLException e) {
                Log.m9445e(DatabaseUtils.TAG, "Error executing InsertHelper with table " + this.mTableName, e);
                this.mPreparedStatement = null;
                AppMethodBeat.m2505o(12109);
                return -1;
            } catch (Throwable th) {
                this.mPreparedStatement = null;
                AppMethodBeat.m2505o(12109);
            }
        }

        public void prepareForInsert() {
            AppMethodBeat.m2504i(12110);
            this.mPreparedStatement = getStatement(false);
            this.mPreparedStatement.clearBindings();
            AppMethodBeat.m2505o(12110);
        }

        public void prepareForReplace() {
            AppMethodBeat.m2504i(12111);
            this.mPreparedStatement = getStatement(true);
            this.mPreparedStatement.clearBindings();
            AppMethodBeat.m2505o(12111);
        }

        public long replace(ContentValues contentValues) {
            AppMethodBeat.m2504i(12112);
            long insertInternal = insertInternal(contentValues, true);
            AppMethodBeat.m2505o(12112);
            return insertInternal;
        }

        public void close() {
            AppMethodBeat.m2504i(12113);
            if (this.mInsertStatement != null) {
                this.mInsertStatement.close();
                this.mInsertStatement = null;
            }
            if (this.mReplaceStatement != null) {
                this.mReplaceStatement.close();
                this.mReplaceStatement = null;
            }
            this.mInsertSQL = null;
            this.mColumns = null;
            AppMethodBeat.m2505o(12113);
        }
    }

    public static boolean objectEquals(Object obj, Object obj2) {
        AppMethodBeat.m2504i(12114);
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            AppMethodBeat.m2505o(12114);
            return true;
        }
        AppMethodBeat.m2505o(12114);
        return false;
    }

    public static final void writeExceptionToParcel(Parcel parcel, Exception exception) {
        int i;
        int i2;
        AppMethodBeat.m2504i(12115);
        if (exception instanceof FileNotFoundException) {
            i = 1;
            i2 = 0;
        } else if (exception instanceof IllegalArgumentException) {
            i = 2;
            i2 = 1;
        } else if (exception instanceof UnsupportedOperationException) {
            i = 3;
            i2 = 1;
        } else if (exception instanceof SQLiteAbortException) {
            i = 4;
            i2 = 1;
        } else if (exception instanceof SQLiteConstraintException) {
            i = 5;
            i2 = 1;
        } else if (exception instanceof SQLiteDatabaseCorruptException) {
            i = 6;
            i2 = 1;
        } else if (exception instanceof SQLiteFullException) {
            i = 7;
            i2 = 1;
        } else if (exception instanceof SQLiteDiskIOException) {
            i = 8;
            i2 = 1;
        } else if (exception instanceof SQLiteException) {
            i = 9;
            i2 = 1;
        } else if (exception instanceof OperationApplicationException) {
            i = 10;
            i2 = 1;
        } else if (exception instanceof OperationCanceledException) {
            i = 11;
            i2 = 0;
        } else {
            parcel.writeException(exception);
            Log.m9445e(TAG, "Writing exception to parcel", exception);
            AppMethodBeat.m2505o(12115);
            return;
        }
        parcel.writeInt(i);
        parcel.writeString(exception.getMessage());
        if (i2 != 0) {
            Log.m9445e(TAG, "Writing exception to parcel", exception);
        }
        AppMethodBeat.m2505o(12115);
    }

    private static final int readExceptionCode(Parcel parcel) {
        AppMethodBeat.m2504i(12116);
        int readInt = parcel.readInt();
        if (readInt == EX_HAS_REPLY_HEADER) {
            if (parcel.readInt() == 0) {
                Log.m9444e(TAG, "Unexpected zero-sized Parcel reply header.");
            }
            AppMethodBeat.m2505o(12116);
            return 0;
        }
        AppMethodBeat.m2505o(12116);
        return readInt;
    }

    public static final void readExceptionFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(12117);
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode == 0) {
            AppMethodBeat.m2505o(12117);
            return;
        }
        readExceptionFromParcel(parcel, parcel.readString(), readExceptionCode);
        AppMethodBeat.m2505o(12117);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(12118);
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode == 0) {
            AppMethodBeat.m2505o(12118);
            return;
        }
        String readString = parcel.readString();
        if (readExceptionCode == 1) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException(readString);
            AppMethodBeat.m2505o(12118);
            throw fileNotFoundException;
        }
        readExceptionFromParcel(parcel, readString, readExceptionCode);
        AppMethodBeat.m2505o(12118);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(12119);
        int readExceptionCode = readExceptionCode(parcel);
        if (readExceptionCode == 0) {
            AppMethodBeat.m2505o(12119);
            return;
        }
        String readString = parcel.readString();
        if (readExceptionCode == 10) {
            OperationApplicationException operationApplicationException = new OperationApplicationException(readString);
            AppMethodBeat.m2505o(12119);
            throw operationApplicationException;
        }
        readExceptionFromParcel(parcel, readString, readExceptionCode);
        AppMethodBeat.m2505o(12119);
    }

    private static final void readExceptionFromParcel(Parcel parcel, String str, int i) {
        AppMethodBeat.m2504i(12120);
        switch (i) {
            case 2:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(str);
                AppMethodBeat.m2505o(12120);
                throw illegalArgumentException;
            case 3:
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(str);
                AppMethodBeat.m2505o(12120);
                throw unsupportedOperationException;
            case 4:
                SQLiteAbortException sQLiteAbortException = new SQLiteAbortException(str);
                AppMethodBeat.m2505o(12120);
                throw sQLiteAbortException;
            case 5:
                SQLiteConstraintException sQLiteConstraintException = new SQLiteConstraintException(str);
                AppMethodBeat.m2505o(12120);
                throw sQLiteConstraintException;
            case 6:
                SQLiteDatabaseCorruptException sQLiteDatabaseCorruptException = new SQLiteDatabaseCorruptException(str);
                AppMethodBeat.m2505o(12120);
                throw sQLiteDatabaseCorruptException;
            case 7:
                SQLiteFullException sQLiteFullException = new SQLiteFullException(str);
                AppMethodBeat.m2505o(12120);
                throw sQLiteFullException;
            case 8:
                SQLiteDiskIOException sQLiteDiskIOException = new SQLiteDiskIOException(str);
                AppMethodBeat.m2505o(12120);
                throw sQLiteDiskIOException;
            case 9:
                SQLiteException sQLiteException = new SQLiteException(str);
                AppMethodBeat.m2505o(12120);
                throw sQLiteException;
            case 11:
                OperationCanceledException operationCanceledException = new OperationCanceledException(str);
                AppMethodBeat.m2505o(12120);
                throw operationCanceledException;
            default:
                parcel.readException(i, str);
                AppMethodBeat.m2505o(12120);
                return;
        }
    }

    public static void bindObjectToProgram(SQLiteProgram sQLiteProgram, int i, Object obj) {
        AppMethodBeat.m2504i(12121);
        if (obj == null) {
            sQLiteProgram.bindNull(i);
            AppMethodBeat.m2505o(12121);
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i, ((Number) obj).doubleValue());
            AppMethodBeat.m2505o(12121);
        } else if (obj instanceof Number) {
            sQLiteProgram.bindLong(i, ((Number) obj).longValue());
            AppMethodBeat.m2505o(12121);
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i, 1);
                AppMethodBeat.m2505o(12121);
                return;
            }
            sQLiteProgram.bindLong(i, 0);
            AppMethodBeat.m2505o(12121);
        } else if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i, (byte[]) obj);
            AppMethodBeat.m2505o(12121);
        } else {
            sQLiteProgram.bindString(i, obj.toString());
            AppMethodBeat.m2505o(12121);
        }
    }

    public static int getTypeOfObject(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (obj instanceof byte[]) {
            return 4;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return 2;
        }
        if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
            return 1;
        }
        return 3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0050 A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void cursorFillWindow(Cursor cursor, int i, CursorWindow cursorWindow) {
        AppMethodBeat.m2504i(12122);
        if (i < 0 || i >= cursor.getCount()) {
            AppMethodBeat.m2505o(12122);
            return;
        }
        int position = cursor.getPosition();
        int columnCount = cursor.getColumnCount();
        cursorWindow.clear();
        cursorWindow.setStartPosition(i);
        cursorWindow.setNumColumns(columnCount);
        if (cursor.moveToPosition(i)) {
            while (cursorWindow.allocRow()) {
                int i2 = 0;
                while (i2 < columnCount) {
                    boolean putNull;
                    switch (cursor.getType(i2)) {
                        case 0:
                            putNull = cursorWindow.putNull(i, i2);
                            break;
                        case 1:
                            putNull = cursorWindow.putLong(cursor.getLong(i2), i, i2);
                            break;
                        case 2:
                            putNull = cursorWindow.putDouble(cursor.getDouble(i2), i, i2);
                            break;
                        case 4:
                            byte[] blob = cursor.getBlob(i2);
                            if (blob == null) {
                                putNull = cursorWindow.putNull(i, i2);
                                break;
                            } else {
                                putNull = cursorWindow.putBlob(blob, i, i2);
                                break;
                            }
                        default:
                            String string = cursor.getString(i2);
                            if (string == null) {
                                putNull = cursorWindow.putNull(i, i2);
                                break;
                            } else {
                                putNull = cursorWindow.putString(string, i, i2);
                                break;
                            }
                    }
                    if (putNull) {
                        i2++;
                    } else {
                        cursorWindow.freeLastRow();
                        i++;
                        if (!cursor.moveToNext()) {
                        }
                    }
                }
                i++;
                if (cursor.moveToNext()) {
                }
            }
        }
        cursor.moveToPosition(position);
        AppMethodBeat.m2505o(12122);
    }

    public static void appendEscapedSQLString(StringBuilder stringBuilder, String str) {
        AppMethodBeat.m2504i(12123);
        stringBuilder.append('\'');
        if (str.indexOf(39) != -1) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt == '\'') {
                    stringBuilder.append('\'');
                }
                stringBuilder.append(charAt);
            }
        } else {
            stringBuilder.append(str);
        }
        stringBuilder.append('\'');
        AppMethodBeat.m2505o(12123);
    }

    public static String sqlEscapeString(String str) {
        AppMethodBeat.m2504i(12124);
        StringBuilder stringBuilder = new StringBuilder();
        appendEscapedSQLString(stringBuilder, str);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(12124);
        return stringBuilder2;
    }

    public static final void appendValueToSql(StringBuilder stringBuilder, Object obj) {
        AppMethodBeat.m2504i(12125);
        if (obj == null) {
            stringBuilder.append("NULL");
            AppMethodBeat.m2505o(12125);
        } else if (!(obj instanceof Boolean)) {
            appendEscapedSQLString(stringBuilder, obj.toString());
            AppMethodBeat.m2505o(12125);
        } else if (((Boolean) obj).booleanValue()) {
            stringBuilder.append('1');
            AppMethodBeat.m2505o(12125);
        } else {
            stringBuilder.append('0');
            AppMethodBeat.m2505o(12125);
        }
    }

    public static String concatenateWhere(String str, String str2) {
        AppMethodBeat.m2504i(12126);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(12126);
            return str2;
        } else if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(12126);
            return str;
        } else {
            str2 = "(" + str + ") AND (" + str2 + ")";
            AppMethodBeat.m2505o(12126);
            return str2;
        }
    }

    public static String getCollationKey(String str) {
        AppMethodBeat.m2504i(12127);
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        String str2;
        try {
            str2 = new String(collationKeyInBytes, 0, getKeyLen(collationKeyInBytes), "ISO8859_1");
            AppMethodBeat.m2505o(12127);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.m2505o(12127);
            return str2;
        }
    }

    private static char[] encodeHex(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr[i] = DIGITS[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr[i3] = DIGITS[bArr[i2] & 15];
        }
        return cArr;
    }

    public static String getHexCollationKey(String str) {
        AppMethodBeat.m2504i(12128);
        byte[] collationKeyInBytes = getCollationKeyInBytes(str);
        String str2 = new String(encodeHex(collationKeyInBytes), 0, getKeyLen(collationKeyInBytes) * 2);
        AppMethodBeat.m2505o(12128);
        return str2;
    }

    private static int getKeyLen(byte[] bArr) {
        if (bArr[bArr.length - 1] != (byte) 0) {
            return bArr.length;
        }
        return bArr.length - 1;
    }

    private static byte[] getCollationKeyInBytes(String str) {
        AppMethodBeat.m2504i(12129);
        if (mColl == null) {
            Collator instance = Collator.getInstance();
            mColl = instance;
            instance.setStrength(0);
        }
        byte[] toByteArray = mColl.getCollationKey(str).toByteArray();
        AppMethodBeat.m2505o(12129);
        return toByteArray;
    }

    public static void dumpCursor(Cursor cursor) {
        AppMethodBeat.m2504i(12130);
        dumpCursor(cursor, System.out);
        AppMethodBeat.m2505o(12130);
    }

    public static void dumpCursor(Cursor cursor, PrintStream printStream) {
        AppMethodBeat.m2504i(12131);
        printStream.println(">>>>> Dumping cursor ".concat(String.valueOf(cursor)));
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, printStream);
            }
            cursor.moveToPosition(position);
        }
        printStream.println("<<<<<");
        AppMethodBeat.m2505o(12131);
    }

    public static void dumpCursor(Cursor cursor, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(12132);
        stringBuilder.append(">>>>> Dumping cursor " + cursor + IOUtils.LINE_SEPARATOR_UNIX);
        if (cursor != null) {
            int position = cursor.getPosition();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                dumpCurrentRow(cursor, stringBuilder);
            }
            cursor.moveToPosition(position);
        }
        stringBuilder.append("<<<<<\n");
        AppMethodBeat.m2505o(12132);
    }

    public static String dumpCursorToString(Cursor cursor) {
        AppMethodBeat.m2504i(12133);
        StringBuilder stringBuilder = new StringBuilder();
        dumpCursor(cursor, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(12133);
        return stringBuilder2;
    }

    public static void dumpCurrentRow(Cursor cursor) {
        AppMethodBeat.m2504i(12134);
        dumpCurrentRow(cursor, System.out);
        AppMethodBeat.m2505o(12134);
    }

    public static void dumpCurrentRow(Cursor cursor, PrintStream printStream) {
        AppMethodBeat.m2504i(12135);
        String[] columnNames = cursor.getColumnNames();
        printStream.println(cursor.getPosition() + " {");
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            String string;
            try {
                string = cursor.getString(i);
            } catch (SQLiteException e) {
                string = "<unprintable>";
            }
            printStream.println("   " + columnNames[i] + '=' + string);
        }
        printStream.println("}");
        AppMethodBeat.m2505o(12135);
    }

    public static void dumpCurrentRow(Cursor cursor, StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(12136);
        String[] columnNames = cursor.getColumnNames();
        stringBuilder.append(cursor.getPosition() + " {\n");
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            String string;
            try {
                string = cursor.getString(i);
            } catch (SQLiteException e) {
                string = "<unprintable>";
            }
            stringBuilder.append("   " + columnNames[i] + '=' + string + IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuilder.append("}\n");
        AppMethodBeat.m2505o(12136);
    }

    public static String dumpCurrentRowToString(Cursor cursor) {
        AppMethodBeat.m2504i(12137);
        StringBuilder stringBuilder = new StringBuilder();
        dumpCurrentRow(cursor, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(12137);
        return stringBuilder2;
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        AppMethodBeat.m2504i(12138);
        cursorStringToContentValues(cursor, str, contentValues, str);
        AppMethodBeat.m2505o(12138);
    }

    public static void cursorStringToInsertHelper(Cursor cursor, String str, InsertHelper insertHelper, int i) {
        AppMethodBeat.m2504i(12139);
        insertHelper.bind(i, cursor.getString(cursor.getColumnIndexOrThrow(str)));
        AppMethodBeat.m2505o(12139);
    }

    public static void cursorStringToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        AppMethodBeat.m2504i(12140);
        contentValues.put(str2, cursor.getString(cursor.getColumnIndexOrThrow(str)));
        AppMethodBeat.m2505o(12140);
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        AppMethodBeat.m2504i(12141);
        cursorIntToContentValues(cursor, str, contentValues, str);
        AppMethodBeat.m2505o(12141);
    }

    public static void cursorIntToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        AppMethodBeat.m2504i(12142);
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, null);
            AppMethodBeat.m2505o(12142);
            return;
        }
        contentValues.put(str2, Integer.valueOf(cursor.getInt(columnIndex)));
        AppMethodBeat.m2505o(12142);
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues) {
        AppMethodBeat.m2504i(12143);
        cursorLongToContentValues(cursor, str, contentValues, str);
        AppMethodBeat.m2505o(12143);
    }

    public static void cursorLongToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        AppMethodBeat.m2504i(12144);
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, null);
            AppMethodBeat.m2505o(12144);
            return;
        }
        contentValues.put(str2, Long.valueOf(cursor.getLong(columnIndex)));
        AppMethodBeat.m2505o(12144);
    }

    public static void cursorDoubleToCursorValues(Cursor cursor, String str, ContentValues contentValues) {
        AppMethodBeat.m2504i(12145);
        cursorDoubleToContentValues(cursor, str, contentValues, str);
        AppMethodBeat.m2505o(12145);
    }

    public static void cursorDoubleToContentValues(Cursor cursor, String str, ContentValues contentValues, String str2) {
        AppMethodBeat.m2504i(12146);
        int columnIndex = cursor.getColumnIndex(str);
        if (cursor.isNull(columnIndex)) {
            contentValues.put(str2, null);
            AppMethodBeat.m2505o(12146);
            return;
        }
        contentValues.put(str2, Double.valueOf(cursor.getDouble(columnIndex)));
        AppMethodBeat.m2505o(12146);
    }

    public static void cursorRowToContentValues(Cursor cursor, ContentValues contentValues) {
        AppMethodBeat.m2504i(12147);
        AbstractWindowedCursor abstractWindowedCursor = cursor instanceof AbstractWindowedCursor ? (AbstractWindowedCursor) cursor : null;
        String[] columnNames = cursor.getColumnNames();
        int length = columnNames.length;
        int i = 0;
        while (i < length) {
            if (abstractWindowedCursor == null || !abstractWindowedCursor.isBlob(i)) {
                contentValues.put(columnNames[i], cursor.getString(i));
            } else {
                contentValues.put(columnNames[i], cursor.getBlob(i));
            }
            i++;
        }
        AppMethodBeat.m2505o(12147);
    }

    public static int cursorPickFillWindowStartPosition(int i, int i2) {
        AppMethodBeat.m2504i(12148);
        int max = Math.max(i - (i2 / 3), 0);
        AppMethodBeat.m2505o(12148);
        return max;
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str) {
        AppMethodBeat.m2504i(12149);
        long queryNumEntries = queryNumEntries(sQLiteDatabase, str, null, null);
        AppMethodBeat.m2505o(12149);
        return queryNumEntries;
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        AppMethodBeat.m2504i(12150);
        long queryNumEntries = queryNumEntries(sQLiteDatabase, str, str2, null);
        AppMethodBeat.m2505o(12150);
        return queryNumEntries;
    }

    public static long queryNumEntries(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        AppMethodBeat.m2504i(12151);
        long longForQuery = longForQuery(sQLiteDatabase, "select count(*) from " + str + (!TextUtils.isEmpty(str2) ? " where ".concat(String.valueOf(str2)) : ""), strArr);
        AppMethodBeat.m2505o(12151);
        return longForQuery;
    }

    public static boolean queryIsEmpty(SQLiteDatabase sQLiteDatabase, String str) {
        AppMethodBeat.m2504i(12152);
        if (longForQuery(sQLiteDatabase, "select exists(select 1 from " + str + ")", null) == 0) {
            AppMethodBeat.m2505o(12152);
            return true;
        }
        AppMethodBeat.m2505o(12152);
        return false;
    }

    public static long longForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        AppMethodBeat.m2504i(12153);
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            long longForQuery = longForQuery(compileStatement, strArr);
            return longForQuery;
        } finally {
            compileStatement.close();
            AppMethodBeat.m2505o(12153);
        }
    }

    public static long longForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        AppMethodBeat.m2504i(12154);
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
        AppMethodBeat.m2505o(12154);
        return simpleQueryForLong;
    }

    public static String stringForQuery(SQLiteDatabase sQLiteDatabase, String str, String[] strArr) {
        AppMethodBeat.m2504i(12155);
        SQLiteStatement compileStatement = sQLiteDatabase.compileStatement(str);
        try {
            String stringForQuery = stringForQuery(compileStatement, strArr);
            return stringForQuery;
        } finally {
            compileStatement.close();
            AppMethodBeat.m2505o(12155);
        }
    }

    public static String stringForQuery(SQLiteStatement sQLiteStatement, String[] strArr) {
        AppMethodBeat.m2504i(12156);
        sQLiteStatement.bindAllArgsAsStrings(strArr);
        String simpleQueryForString = sQLiteStatement.simpleQueryForString();
        AppMethodBeat.m2505o(12156);
        return simpleQueryForString;
    }

    public static void cursorStringToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.m2504i(12157);
        int columnIndex = cursor.getColumnIndex(str);
        if (!(columnIndex == -1 || cursor.isNull(columnIndex))) {
            contentValues.put(str, cursor.getString(columnIndex));
        }
        AppMethodBeat.m2505o(12157);
    }

    public static void cursorLongToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.m2504i(12158);
        int columnIndex = cursor.getColumnIndex(str);
        if (!(columnIndex == -1 || cursor.isNull(columnIndex))) {
            contentValues.put(str, Long.valueOf(cursor.getLong(columnIndex)));
        }
        AppMethodBeat.m2505o(12158);
    }

    public static void cursorShortToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.m2504i(12159);
        int columnIndex = cursor.getColumnIndex(str);
        if (!(columnIndex == -1 || cursor.isNull(columnIndex))) {
            contentValues.put(str, Short.valueOf(cursor.getShort(columnIndex)));
        }
        AppMethodBeat.m2505o(12159);
    }

    public static void cursorIntToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.m2504i(12160);
        int columnIndex = cursor.getColumnIndex(str);
        if (!(columnIndex == -1 || cursor.isNull(columnIndex))) {
            contentValues.put(str, Integer.valueOf(cursor.getInt(columnIndex)));
        }
        AppMethodBeat.m2505o(12160);
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.m2504i(12161);
        int columnIndex = cursor.getColumnIndex(str);
        if (!(columnIndex == -1 || cursor.isNull(columnIndex))) {
            contentValues.put(str, Float.valueOf(cursor.getFloat(columnIndex)));
        }
        AppMethodBeat.m2505o(12161);
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor cursor, ContentValues contentValues, String str) {
        AppMethodBeat.m2504i(12162);
        int columnIndex = cursor.getColumnIndex(str);
        if (!(columnIndex == -1 || cursor.isNull(columnIndex))) {
            contentValues.put(str, Double.valueOf(cursor.getDouble(columnIndex)));
        }
        AppMethodBeat.m2505o(12162);
    }

    public static void createDbFromSqlStatements(Context context, String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i, String str2) {
        int i2 = 0;
        AppMethodBeat.m2504i(12163);
        SQLiteDatabase openOrCreateDatabase = com.tencent.wcdb.support.Context.openOrCreateDatabase(context, str, bArr, sQLiteCipherSpec, 0, null);
        String[] split = TextUtils.split(str2, ";\n");
        int length = split.length;
        while (i2 < length) {
            CharSequence charSequence = split[i2];
            if (!TextUtils.isEmpty(charSequence)) {
                openOrCreateDatabase.execSQL(charSequence);
            }
            i2++;
        }
        openOrCreateDatabase.setVersion(i);
        openOrCreateDatabase.close();
        AppMethodBeat.m2505o(12163);
    }

    public static void createDbFromSqlStatements(Context context, String str, int i, String str2) {
        AppMethodBeat.m2504i(12164);
        createDbFromSqlStatements(context, str, null, null, i, str2);
        AppMethodBeat.m2505o(12164);
    }

    private static int extractSqlCode(String str) {
        AppMethodBeat.m2504i(12165);
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            int charAt = str.charAt(i2);
            if (charAt >= 97 && charAt <= 122) {
                charAt = (charAt - 97) + 65;
            } else if (charAt >= 128) {
                AppMethodBeat.m2505o(12165);
                return 0;
            }
            i |= (charAt & C31128d.MIC_SketchMark) << (i2 * 8);
        }
        AppMethodBeat.m2505o(12165);
        return i;
    }

    public static int getSqlStatementType(String str) {
        AppMethodBeat.m2504i(12166);
        String trim = str.trim();
        if (trim.length() < 3) {
            AppMethodBeat.m2505o(12166);
            return 99;
        }
        switch (extractSqlCode(trim)) {
            case 4279873:
            case 5522756:
                AppMethodBeat.m2505o(12166);
                return 9;
            case 4280912:
                AppMethodBeat.m2505o(12166);
                return 7;
            case 4476485:
            case 5066563:
                AppMethodBeat.m2505o(12166);
                return 5;
            case 4477013:
            case 4998468:
            case 5260626:
            case 5459529:
                AppMethodBeat.m2505o(12166);
                return 2;
            case 4543043:
            case 5198404:
            case 5524545:
                AppMethodBeat.m2505o(12166);
                return 8;
            case 4670786:
                AppMethodBeat.m2505o(12166);
                return 4;
            case 4998483:
                AppMethodBeat.m2505o(12166);
                return 1;
            case 5001042:
                AppMethodBeat.m2505o(12166);
                return 6;
            case 5526593:
                AppMethodBeat.m2505o(12166);
                return 3;
            default:
                AppMethodBeat.m2505o(12166);
                return 99;
        }
    }

    public static String[] appendSelectionArgs(String[] strArr, String[] strArr2) {
        AppMethodBeat.m2504i(12167);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(12167);
            return strArr2;
        }
        String[] strArr3 = new String[(strArr.length + strArr2.length)];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        AppMethodBeat.m2505o(12167);
        return strArr3;
    }

    public static int findRowIdColumnIndex(String[] strArr) {
        AppMethodBeat.m2504i(12168);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (strArr[i].equals("_id")) {
                AppMethodBeat.m2505o(12168);
                return i;
            }
        }
        AppMethodBeat.m2505o(12168);
        return -1;
    }
}
