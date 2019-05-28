package com.tencent.wcdb.database;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDatabase.CursorFactory;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

public class SQLiteQueryBuilder {
    private static final String TAG = "WCDB.SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private boolean mDistinct = false;
    private CursorFactory mFactory = null;
    private Map<String, String> mProjectionMap = null;
    private boolean mStrict;
    private String mTables = "";
    private StringBuilder mWhereClause = null;

    static {
        AppMethodBeat.m2504i(12600);
        AppMethodBeat.m2505o(12600);
    }

    public void setDistinct(boolean z) {
        this.mDistinct = z;
    }

    public String getTables() {
        return this.mTables;
    }

    public void setTables(String str) {
        this.mTables = str;
    }

    public void appendWhere(CharSequence charSequence) {
        AppMethodBeat.m2504i(12585);
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(charSequence.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        this.mWhereClause.append(charSequence);
        AppMethodBeat.m2505o(12585);
    }

    public void appendWhereEscapeString(String str) {
        AppMethodBeat.m2504i(12586);
        if (this.mWhereClause == null) {
            this.mWhereClause = new StringBuilder(str.length() + 16);
        }
        if (this.mWhereClause.length() == 0) {
            this.mWhereClause.append('(');
        }
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, str);
        AppMethodBeat.m2505o(12586);
    }

    public void setProjectionMap(Map<String, String> map) {
        this.mProjectionMap = map;
    }

    public void setCursorFactory(CursorFactory cursorFactory) {
        this.mFactory = cursorFactory;
    }

    public void setStrict(boolean z) {
        this.mStrict = z;
    }

    public static String buildQueryString(boolean z, String str, String[] strArr, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(12587);
        IllegalArgumentException illegalArgumentException;
        if (TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            illegalArgumentException = new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
            AppMethodBeat.m2505o(12587);
            throw illegalArgumentException;
        } else if (TextUtils.isEmpty(str6) || sLimitPattern.matcher(str6).matches()) {
            StringBuilder stringBuilder = new StringBuilder(120);
            stringBuilder.append("SELECT ");
            if (z) {
                stringBuilder.append("DISTINCT ");
            }
            if (strArr == null || strArr.length == 0) {
                stringBuilder.append("* ");
            } else {
                appendColumns(stringBuilder, strArr);
            }
            stringBuilder.append("FROM ");
            stringBuilder.append(str);
            appendClause(stringBuilder, " WHERE ", str2);
            appendClause(stringBuilder, " GROUP BY ", str3);
            appendClause(stringBuilder, " HAVING ", str4);
            appendClause(stringBuilder, " ORDER BY ", str5);
            appendClause(stringBuilder, " LIMIT ", str6);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(12587);
            return stringBuilder2;
        } else {
            illegalArgumentException = new IllegalArgumentException("invalid LIMIT clauses:".concat(String.valueOf(str6)));
            AppMethodBeat.m2505o(12587);
            throw illegalArgumentException;
        }
    }

    private static void appendClause(StringBuilder stringBuilder, String str, String str2) {
        AppMethodBeat.m2504i(12588);
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str);
            stringBuilder.append(str2);
        }
        AppMethodBeat.m2505o(12588);
    }

    public static void appendColumns(StringBuilder stringBuilder, String[] strArr) {
        AppMethodBeat.m2504i(12589);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String str = strArr[i];
            if (str != null) {
                if (i > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(str);
            }
        }
        stringBuilder.append(' ');
        AppMethodBeat.m2505o(12589);
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(12590);
        Cursor query = query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, null, null);
        AppMethodBeat.m2505o(12590);
        return query;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(12591);
        Cursor query = query(sQLiteDatabase, strArr, str, strArr2, str2, str3, str4, str5, null);
        AppMethodBeat.m2505o(12591);
        return query;
    }

    public Cursor query(SQLiteDatabase sQLiteDatabase, String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12592);
        if (this.mTables == null) {
            AppMethodBeat.m2505o(12592);
            return null;
        }
        if (this.mStrict && str != null && str.length() > 0) {
            validateQuerySql(sQLiteDatabase, buildQuery(strArr, "(" + str + ")", str2, str3, str4, str5), cancellationSignal);
        }
        String buildQuery = buildQuery(strArr, str, str2, str3, str4, str5);
        Log.m9442d(TAG, "Performing query: ".concat(String.valueOf(buildQuery)));
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(this.mFactory, buildQuery, strArr2, SQLiteDatabase.findEditTable(this.mTables), cancellationSignal);
        AppMethodBeat.m2505o(12592);
        return rawQueryWithFactory;
    }

    private void validateQuerySql(SQLiteDatabase sQLiteDatabase, String str, CancellationSignal cancellationSignal) {
        AppMethodBeat.m2504i(12593);
        sQLiteDatabase.getThreadSession().prepare(str, sQLiteDatabase.getThreadDefaultConnectionFlags(true), cancellationSignal, null);
        AppMethodBeat.m2505o(12593);
    }

    public String buildQuery(String[] strArr, String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(12594);
        String[] computeProjection = computeProjection(strArr);
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = (this.mWhereClause == null || this.mWhereClause.length() <= 0) ? null : 1;
        if (obj != null) {
            stringBuilder.append(this.mWhereClause.toString());
            stringBuilder.append(')');
        }
        if (str != null && str.length() > 0) {
            if (obj != null) {
                stringBuilder.append(" AND ");
            }
            stringBuilder.append('(');
            stringBuilder.append(str);
            stringBuilder.append(')');
        }
        String buildQueryString = buildQueryString(this.mDistinct, this.mTables, computeProjection, stringBuilder.toString(), str2, str3, str4, str5);
        AppMethodBeat.m2505o(12594);
        return buildQueryString;
    }

    @Deprecated
    public String buildQuery(String[] strArr, String str, String[] strArr2, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(12595);
        String buildQuery = buildQuery(strArr, str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(12595);
        return buildQuery;
    }

    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(12596);
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str6 = strArr[i2];
            if (str6.equals(str)) {
                strArr2[i2] = "'" + str2 + "' AS " + str;
            } else if (i2 <= i || set.contains(str6)) {
                strArr2[i2] = str6;
            } else {
                strArr2[i2] = "NULL AS ".concat(String.valueOf(str6));
            }
        }
        String buildQuery = buildQuery(strArr2, str3, str4, str5, null, null);
        AppMethodBeat.m2505o(12596);
        return buildQuery;
    }

    @Deprecated
    public String buildUnionSubQuery(String str, String[] strArr, Set<String> set, int i, String str2, String str3, String[] strArr2, String str4, String str5) {
        AppMethodBeat.m2504i(12597);
        String buildUnionSubQuery = buildUnionSubQuery(str, strArr, set, i, str2, str3, str4, str5);
        AppMethodBeat.m2505o(12597);
        return buildUnionSubQuery;
    }

    public String buildUnionQuery(String[] strArr, String str, String str2) {
        AppMethodBeat.m2504i(12598);
        StringBuilder stringBuilder = new StringBuilder(128);
        int length = strArr.length;
        String str3 = this.mDistinct ? " UNION " : " UNION ALL ";
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                stringBuilder.append(str3);
            }
            stringBuilder.append(strArr[i]);
        }
        appendClause(stringBuilder, " ORDER BY ", str);
        appendClause(stringBuilder, " LIMIT ", str2);
        str3 = stringBuilder.toString();
        AppMethodBeat.m2505o(12598);
        return str3;
    }

    private String[] computeProjection(String[] strArr) {
        AppMethodBeat.m2504i(12599);
        int i;
        if (strArr == null || strArr.length <= 0) {
            if (this.mProjectionMap != null) {
                Set<Entry> entrySet = this.mProjectionMap.entrySet();
                strArr = new String[entrySet.size()];
                i = 0;
                for (Entry entry : entrySet) {
                    if (!((String) entry.getKey()).equals("_count")) {
                        int i2 = i + 1;
                        strArr[i] = (String) entry.getValue();
                        i = i2;
                    }
                }
                AppMethodBeat.m2505o(12599);
                return strArr;
            }
            AppMethodBeat.m2505o(12599);
            return null;
        } else if (this.mProjectionMap != null) {
            String[] strArr2 = new String[strArr.length];
            int length = strArr.length;
            for (i = 0; i < length; i++) {
                Object obj = strArr[i];
                String str = (String) this.mProjectionMap.get(obj);
                if (str != null) {
                    strArr2[i] = str;
                } else if (this.mStrict || !(obj.contains(" AS ") || obj.contains(" as "))) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid column " + strArr[i]);
                    AppMethodBeat.m2505o(12599);
                    throw illegalArgumentException;
                } else {
                    strArr2[i] = obj;
                }
            }
            AppMethodBeat.m2505o(12599);
            return strArr2;
        } else {
            AppMethodBeat.m2505o(12599);
            return strArr;
        }
    }
}
