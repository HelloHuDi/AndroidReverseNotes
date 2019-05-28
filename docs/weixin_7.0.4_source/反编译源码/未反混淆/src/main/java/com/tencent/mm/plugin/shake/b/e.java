package com.tencent.mm.plugin.shake.b;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tenpay.android.wechat.PayuSecureEncrypt;

public final class e extends j<d> {
    public static final String[] fnj = new String[]{j.a(d.ccO, "shakeitem1")};
    public com.tencent.mm.sdk.e.e bSd;

    public final /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(24451);
        boolean a = a((d) cVar, false);
        AppMethodBeat.o(24451);
        return a;
    }

    static {
        AppMethodBeat.i(24452);
        AppMethodBeat.o(24452);
    }

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, d.ccO, "shakeitem1", null);
        AppMethodBeat.i(24434);
        this.bSd = eVar;
        ab.d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
        eVar.hY("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
        eVar.hY("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
        AppMethodBeat.o(24434);
    }

    public final Cursor cjy() {
        AppMethodBeat.i(24435);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]);
        AppMethodBeat.o(24435);
        return rawQuery;
    }

    public final Cursor cjz() {
        AppMethodBeat.i(24436);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", AppEventsConstants.EVENT_PARAM_VALUE_NO, "2");
        AppMethodBeat.o(24436);
        return rawQuery;
    }

    public final Cursor cjA() {
        AppMethodBeat.i(24437);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.o(24437);
        return rawQuery;
    }

    public final Cursor cjB() {
        AppMethodBeat.i(24438);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", "4");
        AppMethodBeat.o(24438);
        return rawQuery;
    }

    public final Cursor cjC() {
        AppMethodBeat.i(24439);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", "4", "2");
        AppMethodBeat.o(24439);
        return rawQuery;
    }

    public final Cursor cjD() {
        AppMethodBeat.i(24440);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", "7", "6", "8", "9", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12");
        AppMethodBeat.o(24440);
        return rawQuery;
    }

    public final Cursor cjE() {
        AppMethodBeat.i(24441);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", "8", "2");
        AppMethodBeat.o(24441);
        return rawQuery;
    }

    public final Cursor Cs(int i) {
        AppMethodBeat.i(24442);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", "11", String.valueOf(i));
        AppMethodBeat.o(24442);
        return rawQuery;
    }

    public final Cursor cjF() {
        AppMethodBeat.i(24443);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", "11");
        AppMethodBeat.o(24443);
        return rawQuery;
    }

    public final d cjG() {
        AppMethodBeat.i(24444);
        d dVar = new d();
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            dVar.d(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.o(24444);
        return dVar;
    }

    public final boolean a(d dVar, boolean z) {
        AppMethodBeat.i(24445);
        if (dVar == null) {
            AppMethodBeat.o(24445);
            return false;
        }
        if (!(z || bo.isNullOrNil(dVar.field_username))) {
            WC(dVar.field_username);
        }
        dVar.bJt = -1;
        boolean b = super.b((c) dVar);
        AppMethodBeat.o(24445);
        return b;
    }

    public final int Ct(int i) {
        AppMethodBeat.i(24446);
        int delete = this.bSd.delete("shakeitem1", "shakeItemID=?", new String[]{String.valueOf(i)});
        doNotify();
        ab.i("MicroMsg.NewShakeItemStorage", "delById id:" + i + " result:" + delete);
        AppMethodBeat.o(24446);
        return delete;
    }

    public final int WC(String str) {
        AppMethodBeat.i(24447);
        int delete = this.bSd.delete("shakeitem1", "(username=?)", new String[]{String.valueOf(str)});
        if (delete > 0) {
            doNotify();
        }
        ab.i("MicroMsg.NewShakeItemStorage", "delByusername:" + str + " result:" + delete);
        AppMethodBeat.o(24447);
        return delete;
    }

    public final boolean Cu(int i) {
        boolean hY;
        AppMethodBeat.i(24448);
        if (i == 0) {
            hY = this.bSd.hY("shakeitem1", "delete from shakeitem1 where type = " + i + " or type is null");
        } else {
            hY = this.bSd.hY("shakeitem1", "delete from shakeitem1 where type = ".concat(String.valueOf(i)));
        }
        doNotify();
        AppMethodBeat.o(24448);
        return hY;
    }

    public final boolean cjH() {
        AppMethodBeat.i(24449);
        boolean hY = this.bSd.hY("shakeitem1", "delete from shakeitem1");
        doNotify();
        AppMethodBeat.o(24449);
        return hY;
    }

    public final void cjI() {
        AppMethodBeat.i(24450);
        ab.i("MicroMsg.NewShakeItemStorage", "setAllOld");
        d dVar = new d();
        dVar.field_insertBatch = 0;
        dVar.bJt = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if (-1 != this.bSd.update("shakeitem1", dVar.Hl(), "insertBatch!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO})) {
            doNotify();
        }
        AppMethodBeat.o(24450);
    }
}
