package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.fav.a.a;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.w;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class d extends j<g> implements x {
    private static final String mhk = ("xml,edittime,ext,favProto,flag,fromUser,id,itemStatus,localId,localSeq,realChatName,sourceCreateTime,sourceId,sourceType,toUser,type" + ",updateSeq,updateTime,tagProto,sessionId,datatotalsize,rowid");
    private e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(5458);
        boolean y = y((g) cVar);
        AppMethodBeat.o(5458);
        return y;
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        AppMethodBeat.i(5457);
        boolean a = a((g) cVar, strArr);
        AppMethodBeat.o(5457);
        return a;
    }

    static {
        AppMethodBeat.i(5459);
        AppMethodBeat.o(5459);
    }

    public d(e eVar) {
        super(eVar, g.ccO, "FavItemInfo", null);
        this.bSd = eVar;
    }

    public final e buR() {
        return this.bSd;
    }

    public final g iE(long j) {
        AppMethodBeat.i(5431);
        if (this.bSd == null) {
            ab.e("MicroMsg.Fav.FavItemInfoStorage", "getBtLocalId, but db is null, return");
            AppMethodBeat.o(5431);
            return null;
        }
        Cursor a = this.bSd.a("FavItemInfo", null, "localId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            try {
                gVar.d(a);
                a.close();
                AppMethodBeat.o(5431);
                return gVar;
            } catch (Exception e) {
                ab.e("MicroMsg.Fav.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                AppMethodBeat.o(5431);
                return null;
            }
        }
        ab.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByLocalId:%d, no data", Long.valueOf(j));
        a.close();
        AppMethodBeat.o(5431);
        return null;
    }

    public final g iF(long j) {
        AppMethodBeat.i(5432);
        Cursor rawQuery = this.bSd.rawQuery("Select * from FavItemInfo where id = ".concat(String.valueOf(j)), null);
        if (rawQuery.getCount() != 0) {
            g gVar = new g();
            rawQuery.moveToFirst();
            try {
                gVar.d(rawQuery);
                rawQuery.close();
                AppMethodBeat.o(5432);
                return gVar;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Fav.FavItemInfoStorage", e, "", new Object[0]);
                ab.e("MicroMsg.Fav.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", Long.valueOf(j));
                rawQuery.close();
                AppMethodBeat.o(5432);
                return null;
            }
        }
        ab.w("MicroMsg.Fav.FavItemInfoStorage", "klem getByFavId:%d, no data", Long.valueOf(j));
        rawQuery.close();
        AppMethodBeat.o(5432);
        return null;
    }

    public final int buS() {
        AppMethodBeat.i(5433);
        Cursor rawQuery = rawQuery("select count(*) from FavItemInfo where type = 2", new String[0]);
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            int i = rawQuery.getInt(0);
            rawQuery.close();
            AppMethodBeat.o(5433);
            return i;
        }
        AppMethodBeat.o(5433);
        return 0;
    }

    public final g LS(String str) {
        AppMethodBeat.i(5434);
        Cursor a = this.bSd.a("FavItemInfo", null, "sourceId=?", new String[]{String.valueOf(str)}, null, null, null, 2);
        if (a.moveToFirst()) {
            g gVar = new g();
            gVar.d(a);
            a.close();
            AppMethodBeat.o(5434);
            return gVar;
        }
        ab.w("MicroMsg.Fav.FavItemInfoStorage", "klem getBySourceId:%s, no data", str);
        a.close();
        AppMethodBeat.o(5434);
        return null;
    }

    public final boolean y(g gVar) {
        AppMethodBeat.i(5435);
        Assert.assertTrue(gVar.field_localId > 0);
        if (gVar.field_favProto.wit != null) {
            abl abl = gVar.field_favProto.wit;
            if (abl.cvp <= 0) {
                ab.w("MicroMsg.Fav.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(abl.cvp));
                abl.LN(1);
            } else {
                abl.LN(abl.cvp);
            }
        }
        b.a(gVar);
        boolean a = a((c) gVar, false);
        if (a) {
            b(gVar.field_localId, 2, Long.valueOf(gVar.field_localId));
        }
        AppMethodBeat.o(5435);
        return a;
    }

    public final boolean a(g gVar, String... strArr) {
        AppMethodBeat.i(5436);
        if (gVar.field_favProto.wit != null) {
            abl abl = gVar.field_favProto.wit;
            if (abl.cvp <= 0) {
                ab.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(abl.cvp));
                abl.LN(1);
            } else {
                abl.LN(abl.cvp);
            }
        }
        b.a(gVar);
        boolean b = super.b(gVar, false, strArr);
        if (b) {
            b(gVar.field_localId, 3, Long.valueOf(gVar.field_localId));
        }
        ab.d("MicroMsg.Fav.FavItemInfoStorage", "update result[%B]", Boolean.valueOf(b));
        AppMethodBeat.o(5436);
        return b;
    }

    public final boolean t(long j, int i) {
        AppMethodBeat.i(5437);
        String concat = "select count(updateTime) from FavItemInfo where updateTime < ".concat(String.valueOf(j));
        if (i != -1) {
            concat = concat + " and type = " + i;
        }
        Cursor a = this.bSd.a(concat, null, 2);
        if (a == null) {
            AppMethodBeat.o(5437);
            return true;
        }
        a.moveToFirst();
        if (a.getInt(0) == 0) {
            a.close();
            AppMethodBeat.o(5437);
            return true;
        }
        a.close();
        AppMethodBeat.o(5437);
        return false;
    }

    public final long u(long j, int i) {
        AppMethodBeat.i(5438);
        String str;
        long j2;
        if (this.bSd == null) {
            ab.e("MicroMsg.Fav.FavItemInfoStorage", "getNextUpdateTime, but db is null, return");
            AppMethodBeat.o(5438);
            return 0;
        } else if (j == 0) {
            str = "select updateTime from FavItemInfo where itemStatus > 0";
            if (i != -1) {
                str = str + " and type = " + i;
            }
            Cursor rawQuery = this.bSd.rawQuery(str + " order by updateTime desc limit 20", null);
            if (rawQuery == null) {
                AppMethodBeat.o(5438);
                return 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.o(5438);
                return 0;
            } else {
                rawQuery.moveToLast();
                j2 = rawQuery.getLong(0);
                rawQuery.close();
                AppMethodBeat.o(5438);
                return j2;
            }
        } else {
            str = "select updateTime from FavItemInfo where updateTime < ".concat(String.valueOf(j));
            if (i != -1) {
                str = str + " and type = " + i;
            }
            Cursor rawQuery2 = this.bSd.rawQuery((str + " and itemStatus > 0") + " order by updateTime desc limit 20", null);
            if (rawQuery2 == null || rawQuery2.getCount() <= 0) {
                j2 = j;
            } else {
                rawQuery2.moveToLast();
                j2 = rawQuery2.getLong(0);
            }
            if (rawQuery2 != null) {
                rawQuery2.close();
            }
            AppMethodBeat.o(5438);
            return j2;
        }
    }

    public final List<g> a(int i, Set<Integer> set, w wVar) {
        AppMethodBeat.i(5439);
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            ArrayList arrayList = new ArrayList();
            String str2 = "select " + mhk + " from FavItemInfo where itemStatus > 0";
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                Iterator it = set.iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str2 = str + " and type != " + ((Integer) it.next()).intValue();
                }
            } else {
                str = str2;
            }
            Cursor a = this.bSd.a(str + " order by updateTime desc limit 20", null, 2);
            if (a == null) {
                AppMethodBeat.o(5439);
                return arrayList;
            }
            while (a.moveToNext()) {
                g gVar = new g();
                gVar.d(a);
                if (wVar == null || !wVar.t(gVar)) {
                    arrayList.add(gVar);
                } else {
                    ab.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", Integer.valueOf(gVar.field_id), Integer.valueOf(gVar.field_type));
                }
            }
            a.close();
            AppMethodBeat.o(5439);
            return arrayList;
        }
        ab.w("MicroMsg.Fav.FavItemInfoStorage", "getFirstPageList::block set contains target type, error, do return null");
        AppMethodBeat.o(5439);
        return null;
    }

    public final LinkedList<Integer> v(long j, int i) {
        AppMethodBeat.i(5440);
        LinkedList<Integer> linkedList = new LinkedList();
        String concat = "select id from FavItemInfo where updateTime >= ".concat(String.valueOf(j));
        if (i != -1) {
            concat = concat + " and type = " + i;
        }
        Cursor a = this.bSd.a((concat + " and updateSeq > localSeq") + " order by updateTime desc", null, 2);
        if (a == null) {
            AppMethodBeat.o(5440);
            return linkedList;
        }
        while (a.moveToNext()) {
            linkedList.add(Integer.valueOf(a.getInt(0)));
        }
        a.close();
        AppMethodBeat.o(5440);
        return linkedList;
    }

    public final long w(long j, int i) {
        AppMethodBeat.i(5441);
        String str;
        Cursor rawQuery;
        long j2;
        if (this.bSd == null) {
            ab.e("MicroMsg.Fav.FavItemInfoStorage", "getMinBatchGetUpdateTime, but db is null, return");
            AppMethodBeat.o(5441);
            return 0;
        } else if (j == 0) {
            str = "select updateTime from (select * from FavItemInfo";
            if (i != -1) {
                str = str + " where type = " + i;
            }
            rawQuery = this.bSd.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                AppMethodBeat.o(5441);
                return 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.o(5441);
                return 0;
            } else {
                rawQuery.moveToLast();
                j2 = rawQuery.getLong(0);
                rawQuery.close();
                AppMethodBeat.o(5441);
                return j2;
            }
        } else {
            str = "select updateTime from (select * from FavItemInfo where updateTime < ".concat(String.valueOf(j));
            if (i != -1) {
                str = str + " and type = " + i;
            }
            rawQuery = this.bSd.rawQuery((str + " order by updateTime desc limit 20") + ") where updateSeq > localSeq", null);
            if (rawQuery == null) {
                AppMethodBeat.o(5441);
                return 0;
            } else if (rawQuery.getCount() == 0) {
                rawQuery.close();
                AppMethodBeat.o(5441);
                return 0;
            } else {
                rawQuery.moveToLast();
                j2 = rawQuery.getLong(0);
                rawQuery.close();
                AppMethodBeat.o(5441);
                return j2;
            }
        }
    }

    public final List<g> b(long j, int i, Set<Integer> set, w wVar) {
        AppMethodBeat.i(5442);
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            ArrayList arrayList = new ArrayList();
            String str2 = "select " + mhk + " from FavItemInfo where updateTime >= " + j;
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                Iterator it = set.iterator();
                while (true) {
                    str = str2;
                    if (!it.hasNext()) {
                        break;
                    }
                    str2 = str + " and type != " + ((Integer) it.next()).intValue();
                }
            } else {
                str = str2;
            }
            Cursor a = this.bSd.a((str + " and itemStatus > 0") + " order by updateTime desc", null, 2);
            if (a == null) {
                AppMethodBeat.o(5442);
                return arrayList;
            }
            while (a.moveToNext()) {
                g gVar = new g();
                try {
                    gVar.d(a);
                    if (wVar == null || !wVar.t(gVar)) {
                        arrayList.add(gVar);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.Fav.FavItemInfoStorage", "fav getlist convertfrom (cu) error,continue");
                }
            }
            a.close();
            AppMethodBeat.o(5442);
            return arrayList;
        }
        ab.w("MicroMsg.Fav.FavItemInfoStorage", "getList::block set contains target type, error, do return null");
        AppMethodBeat.o(5442);
        return null;
    }

    public final List<g> buT() {
        List<g> list = null;
        AppMethodBeat.i(5443);
        Cursor rawQuery = this.bSd.rawQuery("select " + mhk + " from FavItemInfo where itemStatus=3", null);
        if (rawQuery == null) {
            AppMethodBeat.o(5443);
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(5443);
        } else {
            list = new LinkedList();
            while (rawQuery.moveToNext()) {
                g gVar = new g();
                gVar.d(rawQuery);
                list.add(gVar);
            }
            rawQuery.close();
            AppMethodBeat.o(5443);
        }
        return list;
    }

    public final List<g> buU() {
        List<g> list = null;
        AppMethodBeat.i(5444);
        Cursor a = this.bSd.a("select " + mhk + " from FavItemInfo where itemStatus=1", null, 2);
        if (a == null) {
            AppMethodBeat.o(5444);
        } else {
            if (a.moveToFirst()) {
                list = new LinkedList();
                do {
                    g gVar = new g();
                    gVar.d(a);
                    list.add(gVar);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(5444);
        }
        return list;
    }

    public final void J(int i, long j) {
        AppMethodBeat.i(5445);
        ab.d("MicroMsg.Fav.FavItemInfoStorage", "setStatus status:%d,localId:%d", Integer.valueOf(i), Long.valueOf(j));
        this.bSd.hY("FavItemInfo", "update FavItemInfo set itemStatus = " + i + " where localId = " + j);
        anF(String.valueOf(j));
        AppMethodBeat.o(5445);
    }

    public final void z(g gVar) {
        AppMethodBeat.i(5446);
        String str = "delete from FavItemInfo where localId = " + gVar.field_localId;
        ab.i("MicroMsg.Fav.FavItemInfoStorage", "delete sql: ".concat(String.valueOf(str)));
        this.bSd.hY("FavItemInfo", str);
        b(gVar.field_localId, 5, Long.valueOf(gVar.field_localId));
        AppMethodBeat.o(5446);
    }

    public final List<g> buV() {
        List<g> list = null;
        AppMethodBeat.i(5447);
        Cursor a = this.bSd.a("select " + mhk + " from FavItemInfo where (itemStatus=9 or itemStatus=12)", null, 2);
        if (a == null) {
            AppMethodBeat.o(5447);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(a);
                    list.add(gVar);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(5447);
        }
        return list;
    }

    public final List<g> buW() {
        List<g> list = null;
        AppMethodBeat.i(5448);
        Cursor a = this.bSd.a("select " + mhk + " from FavItemInfo where itemStatus=17", null, 2);
        if (a == null) {
            AppMethodBeat.o(5448);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(a);
                    list.add(gVar);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(5448);
        }
        return list;
    }

    public final List<g> buX() {
        List<g> list = null;
        AppMethodBeat.i(5449);
        Cursor a = this.bSd.a("select " + mhk + " from FavItemInfo where itemStatus=3 or itemStatus=6 or itemStatus=11 or itemStatus=14 or itemStatus=16 or itemStatus=18", null, 2);
        if (a == null) {
            AppMethodBeat.o(5449);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(a);
                    list.add(gVar);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(5449);
        }
        return list;
    }

    public final ArrayList<g> a(List<Long> list, List<g> list2, Set<Integer> set, w wVar) {
        AppMethodBeat.i(5450);
        if (list == null || list.size() == 0 || list.size() > 20) {
            AppMethodBeat.o(5450);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ").append(mhk).append(" from FavItemInfo where ");
        if (set != null && set.size() > 0) {
            stringBuffer.append("( 1=1");
            for (Integer append : set) {
                stringBuffer.append(" and type != ").append(append);
            }
            stringBuffer.append(") and ");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                stringBuffer.append("( ");
            }
            if (i == size - 1) {
                stringBuffer.append("localId = ").append(list.get(i)).append(" )");
            } else {
                stringBuffer.append("localId = ").append(list.get(i)).append(" or ");
            }
        }
        stringBuffer.append(" order by updateTime desc");
        ab.d("MicroMsg.Fav.FavItemInfoStorage", "get list by id list sql %s", stringBuffer.toString());
        Cursor a = this.bSd.a(r0, null, 2);
        if (a == null) {
            AppMethodBeat.o(5450);
            return null;
        }
        ArrayList<g> arrayList;
        if (a.moveToFirst()) {
            ArrayList<g> arrayList2 = new ArrayList();
            do {
                g gVar;
                if (list2 == null || list2.isEmpty()) {
                    gVar = new g();
                } else {
                    gVar = (g) list2.remove(0);
                }
                gVar.d(a);
                if (wVar == null || !wVar.t(gVar)) {
                    arrayList2.add(gVar);
                } else {
                    ab.w("MicroMsg.Fav.FavItemInfoStorage", "id[%d] type[%d] match filter", Integer.valueOf(gVar.field_id), Integer.valueOf(gVar.field_type));
                }
            } while (a.moveToNext());
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        a.close();
        AppMethodBeat.o(5450);
        return arrayList;
    }

    public final boolean b(g gVar, String... strArr) {
        AppMethodBeat.i(5451);
        if (gVar.field_favProto.wit != null) {
            abl abl = gVar.field_favProto.wit;
            if (abl.cvp <= 0) {
                ab.w("MicroMsg.Fav.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_type), Integer.valueOf(abl.cvp));
                abl.LN(1);
            } else {
                abl.LN(abl.cvp);
            }
        }
        boolean b = super.b(gVar, false, strArr);
        AppMethodBeat.o(5451);
        return b;
    }

    public final List<g> buY() {
        List<g> list = null;
        AppMethodBeat.i(5452);
        Cursor a = this.bSd.a("select " + mhk + " from FavItemInfo where flag =  -1 and itemStatus = 0 ", null, 2);
        if (a == null) {
            AppMethodBeat.o(5452);
        } else {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.d(a);
                    list.add(gVar);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.o(5452);
        }
        return list;
    }

    public final List<Long> buZ() {
        AppMethodBeat.i(5453);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        String str = "select localId from FavItemInfo where ";
        String str2 = "";
        for (int i : a.meB) {
            str2 = str2 + i + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = (str + " itemStatus in (" + str2 + ")") + " and datatotalsize > 0 ";
        str2 = "";
        for (int i2 : a.meA) {
            str2 = str2 + i2 + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.bSd.rawQuery((str + " and type in (" + str2 + ")") + " order by datatotalsize desc", null);
        if (rawQuery == null) {
            AppMethodBeat.o(5453);
            return arrayList;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.o(5453);
            return arrayList;
        } else {
            while (rawQuery.moveToNext()) {
                arrayList.add(Long.valueOf(rawQuery.getLong(0)));
            }
            rawQuery.close();
            long currentTimeMillis2 = System.currentTimeMillis();
            ab.i("MicroMsg.Fav.FavItemInfoStorage", "getCleanList cu.getCount() = %d,used %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            AppMethodBeat.o(5453);
            return arrayList;
        }
    }

    public final void bva() {
        AppMethodBeat.i(5454);
        ab.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength");
        String str = "select " + mhk + " from FavItemInfo where ";
        String str2 = "";
        for (int i : a.meB) {
            str2 = str2 + i + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        str = str + "itemStatus in (" + str2 + ")";
        str2 = "";
        for (int i2 : a.meA) {
            str2 = str2 + i2 + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        Cursor rawQuery = this.bSd.rawQuery(str + " and type in (" + str2 + ")", null);
        if (rawQuery == null) {
            ab.e("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu = null");
            AppMethodBeat.o(5454);
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            ab.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = 0");
            AppMethodBeat.o(5454);
        } else {
            long iV;
            ab.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength cu.getCount() = " + rawQuery.getCount());
            if (this.bSd instanceof h) {
                iV = ((h) this.bSd).iV(Thread.currentThread().getId());
            } else {
                iV = 0;
            }
            while (rawQuery.moveToNext()) {
                g gVar = new g();
                gVar.d(rawQuery);
                if (vA(gVar.field_itemStatus)) {
                    long j;
                    if (gVar.field_favProto != null) {
                        Iterator it = gVar.field_favProto.wiv.iterator();
                        j = 0;
                        while (it.hasNext()) {
                            j = ((aar) it.next()).wgu + j;
                        }
                    } else {
                        j = 0;
                    }
                    gVar.field_datatotalsize = j;
                    a(gVar, "localId");
                }
            }
            if (this.bSd instanceof h) {
                ((h) this.bSd).mB(iV);
            }
            rawQuery.close();
            ab.i("MicroMsg.Fav.FavItemInfoStorage", "calDataBaseDataTotalLength end");
            AppMethodBeat.o(5454);
        }
    }

    private static boolean vA(int i) {
        for (int i2 : a.meB) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public final List<Long> bvb() {
        AppMethodBeat.i(5455);
        ArrayList arrayList = new ArrayList();
        Cursor a = this.bSd.a("select localId from FavItemInfo" + " order by updateTime desc", null, 2);
        if (a == null) {
            AppMethodBeat.o(5455);
        } else if (a.getCount() == 0) {
            a.close();
            AppMethodBeat.o(5455);
        } else {
            while (a.moveToNext()) {
                arrayList.add(Long.valueOf(a.getLong(0)));
            }
            a.close();
            AppMethodBeat.o(5455);
        }
        return arrayList;
    }

    public final int vz(int i) {
        AppMethodBeat.i(5456);
        try {
            Cursor a = this.bSd.a("select count(*) from FavItemInfo where id>".concat(String.valueOf(i)), null, 2);
            if (a == null) {
                AppMethodBeat.o(5456);
                return -1;
            } else if (a.getCount() == 0) {
                a.close();
                AppMethodBeat.o(5456);
                return -1;
            } else {
                a.moveToNext();
                int i2 = a.getInt(0);
                a.close();
                AppMethodBeat.o(5456);
                return i2;
            }
        } catch (Throwable th) {
            ab.w("MicroMsg.Fav.FavItemInfoStorage", "getFavHomePosition failed with throwable: " + th.getMessage());
            AppMethodBeat.o(5456);
            return -1;
        }
    }
}
