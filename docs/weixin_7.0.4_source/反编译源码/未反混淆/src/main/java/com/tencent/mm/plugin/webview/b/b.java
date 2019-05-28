package com.tencent.mm.plugin.webview.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public final class b {
    private static long ueF = 2592000;
    private static b ueG;
    private c ueH;
    private Map<String, Long> ueI = new HashMap();
    private long ueJ = 0;

    public b() {
        AppMethodBeat.i(5625);
        AppMethodBeat.o(5625);
    }

    public static b cWi() {
        AppMethodBeat.i(5626);
        if (ueG == null) {
            ueG = new b();
        }
        b bVar = ueG;
        AppMethodBeat.o(5626);
        return bVar;
    }

    public final c cWj() {
        AppMethodBeat.i(5627);
        if (this.ueH == null) {
            g.RQ();
            this.ueH = new c(g.RP().eJN);
        }
        c cVar = this.ueH;
        AppMethodBeat.o(5627);
        return cVar;
    }

    public final boolean a(String str, String str2, String str3, String str4, String str5, boolean z) {
        AppMethodBeat.i(5628);
        long length = (long) (str2.getBytes().length + str3.getBytes().length);
        final long adZ = adZ(str) + (length - cWj().gW(str, str2));
        final long ax = ax(str, adZ);
        ab.i("MicroMsg.WebViewDataCenter", "prevSize = %d, valueSize = %d, diffSize = %d, newAppSize = %d, expireSize = %d", Long.valueOf(r2), Long.valueOf(length), Long.valueOf(r12), Long.valueOf(adZ), Long.valueOf(ax));
        if (ax <= 0 || z) {
            final String str6 = str;
            final String str7 = str2;
            final String str8 = str3;
            final String str9 = str4;
            final String str10 = str5;
            a.R(new Runnable() {
                public final void run() {
                    long j;
                    AppMethodBeat.i(5624);
                    if (ax > 0) {
                        c cWj = b.this.cWj();
                        String str = str6;
                        long j2 = ax;
                        str = String.format("select * from %s where appId='%s' order by weight,timeStamp", new Object[]{"WebViewData", str});
                        ab.d("MicroMsg.WebViewDataStorage", "deleteSize querySql: ".concat(String.valueOf(str)));
                        Cursor rawQuery = cWj.rawQuery(str, new String[0]);
                        if (rawQuery == null) {
                            j = 0;
                        } else {
                            LinkedList<String> linkedList = new LinkedList();
                            long j3 = j2;
                            while (rawQuery.moveToFirst() && j3 > 0) {
                                str = rawQuery.getString(1);
                                long j4 = rawQuery.getLong(6);
                                linkedList.add(str);
                                j3 -= j4;
                            }
                            rawQuery.close();
                            if (linkedList.size() > 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("(");
                                for (String str2 : linkedList) {
                                    stringBuilder.append("\"" + str2 + "\",");
                                }
                                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                                stringBuilder.append(")");
                                str2 = String.format("delete from %s where %s in %s", new Object[]{"WebViewData", "appIdKey", stringBuilder.toString()});
                                ab.d("MicroMsg.WebViewDataStorage", "deleteSize deleteSql: ".concat(String.valueOf(str2)));
                                ab.d("MicroMsg.WebViewDataStorage", "deleteSize: ".concat(String.valueOf(cWj.hY("WebViewData", str2))));
                            }
                            j = j2 - j3;
                        }
                        b.this.ueI.put(str6, Long.valueOf(adZ - j));
                    } else {
                        b.this.ueI.put(str6, Long.valueOf(adZ));
                    }
                    c cWj2 = b.this.cWj();
                    String str3 = str6;
                    String str4 = str7;
                    String str5 = str8;
                    String bc = bo.bc(str9, "1");
                    long aea = b.aea(str10);
                    a aVar = new a();
                    aVar.field_appId = str3;
                    aVar.field_appIdKey = c.gY(str3, str4);
                    aVar.field_value = str5;
                    aVar.field_weight = bc;
                    aVar.field_expireTime = aea + (System.currentTimeMillis() / 1000);
                    aVar.field_size = (long) (str4.getBytes().length + str5.getBytes().length);
                    aVar.field_timeStamp = System.currentTimeMillis() / 1000;
                    ab.d("MicroMsg.WebViewDataStorage", "setData: ".concat(String.valueOf(cWj2.a(aVar))));
                    c cWj3 = b.this.cWj();
                    str5 = str6;
                    if (b.this.ueI.get(str6) == null) {
                        j = 0;
                    } else {
                        j = ((Long) b.this.ueI.get(str6)).longValue();
                    }
                    a aVar2 = new a();
                    aVar2.field_appId = str5;
                    aVar2.field_appIdKey = c.at(str5, "###@@@@TOTAL@@@###SIZE####", "_");
                    aVar2.field_expireTime = Long.MAX_VALUE;
                    aVar2.field_size = j;
                    boolean a = cWj3.a(aVar2);
                    ab.d("MicroMsg.WebViewDataStorage", "setAppIdSize: %b, size: %d", Boolean.valueOf(a), Long.valueOf(j));
                    b.b(b.this);
                    AppMethodBeat.o(5624);
                }
            });
            AppMethodBeat.o(5628);
            return true;
        }
        AppMethodBeat.o(5628);
        return false;
    }

    public final a gV(String str, String str2) {
        AppMethodBeat.i(5629);
        a gV = cWj().gV(str, str2);
        AppMethodBeat.o(5629);
        return gV;
    }

    public final void b(String str, JSONArray jSONArray) {
        AppMethodBeat.i(5630);
        cWj().b(str, jSONArray);
        AppMethodBeat.o(5630);
    }

    public final void adY(String str) {
        AppMethodBeat.i(5631);
        cWj().adY(str);
        AppMethodBeat.o(5631);
    }

    private long adZ(String str) {
        AppMethodBeat.i(5632);
        long longValue;
        if (this.ueI.containsKey(str)) {
            longValue = ((Long) this.ueI.get(str)).longValue();
            AppMethodBeat.o(5632);
            return longValue;
        }
        longValue = cWj().adZ(str);
        AppMethodBeat.o(5632);
        return longValue;
    }

    private static long ax(String str, long j) {
        AppMethodBeat.i(5633);
        long j2;
        if (str.equals("wx62d9035fd4fd2059")) {
            j2 = j - 52428800;
            AppMethodBeat.o(5633);
            return j2;
        }
        j2 = j - 10485760;
        AppMethodBeat.o(5633);
        return j2;
    }

    static /* synthetic */ long aea(String str) {
        AppMethodBeat.i(5634);
        long j = bo.getLong(str, 604800);
        if (j > ueF) {
            j = ueF;
            AppMethodBeat.o(5634);
            return j;
        }
        AppMethodBeat.o(5634);
        return j;
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(5635);
        c cWj = bVar.cWj();
        String format = String.format("delete from %s where %s<%s", new Object[]{"WebViewData", "expireTime", Long.valueOf(System.currentTimeMillis() / 1000)});
        ab.d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: ".concat(String.valueOf(format)));
        ab.d("MicroMsg.WebViewDataStorage", "clearExpireTimeData: ".concat(String.valueOf(cWj.hY("WebViewData", format))));
        AppMethodBeat.o(5635);
    }
}
