package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class q {
    public static final String[][] a = new String[4][];

    static {
        AppMethodBeat.i(100534);
        String[][] strArr = a;
        String[] strArr2 = new String[2];
        strArr2[0] = "t_event";
        strArr2[1] = String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int , %s int , %s int , %s int , %s blob)", new Object[]{"t_event", "_id", "_time", "_type", "_prority", "_length", "_datas"});
        strArr[0] = strArr2;
        strArr = a;
        strArr2 = new String[2];
        strArr2[0] = "t_strategy";
        strArr2[1] = String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s int unique , %s int , %s blob)", new Object[]{"t_strategy", "_id", "_key", "_ut", "_datas"});
        strArr[1] = strArr2;
        strArr = a;
        strArr2 = new String[2];
        strArr2[0] = "t_req_data";
        strArr2[1] = String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s int , %s int , %s blob)", new Object[]{"t_req_data", "_id", "_rid", "_time", "_cnt", "_datas"});
        strArr[2] = strArr2;
        strArr = a;
        strArr2 = new String[2];
        strArr2[0] = "t_conf";
        strArr2[1] = String.format(Locale.US, "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s text unique , %s text , %s int , %s int)", new Object[]{"t_conf", "_id", "_key", "_value", "_vdate", "_time"});
        strArr[3] = strArr2;
        AppMethodBeat.o(100534);
    }
}
