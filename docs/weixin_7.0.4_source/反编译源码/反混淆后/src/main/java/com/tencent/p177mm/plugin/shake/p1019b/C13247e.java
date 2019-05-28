package com.tencent.p177mm.plugin.shake.p1019b;

import android.database.Cursor;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tenpay.android.wechat.PayuSecureEncrypt;

/* renamed from: com.tencent.mm.plugin.shake.b.e */
public final class C13247e extends C7563j<C34894d> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C34894d.ccO, "shakeitem1")};
    public C4927e bSd;

    /* renamed from: b */
    public final /* synthetic */ boolean mo10101b(C4925c c4925c) {
        AppMethodBeat.m2504i(24451);
        boolean a = mo25304a((C34894d) c4925c, false);
        AppMethodBeat.m2505o(24451);
        return a;
    }

    static {
        AppMethodBeat.m2504i(24452);
        AppMethodBeat.m2505o(24452);
    }

    public C13247e(C4927e c4927e) {
        super(c4927e, C34894d.ccO, "shakeitem1", null);
        AppMethodBeat.m2504i(24434);
        this.bSd = c4927e;
        C4990ab.m7410d("MicroMsg.NewShakeItemStorage", "ShakeItemStorage");
        c4927e.mo10108hY("shakeitem1", "DROP INDEX IF EXISTS shakeItemUsernameIndex ");
        c4927e.mo10108hY("shakeitem1", "CREATE INDEX IF NOT EXISTS shakeItemNewUsernameIndex ON shakeitem1 ( username )");
        AppMethodBeat.m2505o(24434);
    }

    public final Cursor cjy() {
        AppMethodBeat.m2504i(24435);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]);
        AppMethodBeat.m2505o(24435);
        return rawQuery;
    }

    public final Cursor cjz() {
        AppMethodBeat.m2504i(24436);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", AppEventsConstants.EVENT_PARAM_VALUE_NO, "2");
        AppMethodBeat.m2505o(24436);
        return rawQuery;
    }

    public final Cursor cjA() {
        AppMethodBeat.m2504i(24437);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        AppMethodBeat.m2505o(24437);
        return rawQuery;
    }

    public final Cursor cjB() {
        AppMethodBeat.m2504i(24438);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by shakeItemID desc ", "4");
        AppMethodBeat.m2505o(24438);
        return rawQuery;
    }

    public final Cursor cjC() {
        AppMethodBeat.m2504i(24439);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", "4", "2");
        AppMethodBeat.m2505o(24439);
        return rawQuery;
    }

    public final Cursor cjD() {
        AppMethodBeat.m2504i(24440);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", "7", "6", "8", "9", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12");
        AppMethodBeat.m2505o(24440);
        return rawQuery;
    }

    public final Cursor cjE() {
        AppMethodBeat.m2504i(24441);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", "8", "2");
        AppMethodBeat.m2505o(24441);
        return rawQuery;
    }

    /* renamed from: Cs */
    public final Cursor mo25300Cs(int i) {
        AppMethodBeat.m2504i(24442);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", "11", String.valueOf(i));
        AppMethodBeat.m2505o(24442);
        return rawQuery;
    }

    public final Cursor cjF() {
        AppMethodBeat.m2504i(24443);
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", "11");
        AppMethodBeat.m2505o(24443);
        return rawQuery;
    }

    public final C34894d cjG() {
        AppMethodBeat.m2504i(24444);
        C34894d c34894d = new C34894d();
        Cursor rawQuery = rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc limit 1", new String[0]);
        if (rawQuery.getCount() != 0) {
            rawQuery.moveToFirst();
            c34894d.mo8995d(rawQuery);
        }
        rawQuery.close();
        AppMethodBeat.m2505o(24444);
        return c34894d;
    }

    /* renamed from: a */
    public final boolean mo25304a(C34894d c34894d, boolean z) {
        AppMethodBeat.m2504i(24445);
        if (c34894d == null) {
            AppMethodBeat.m2505o(24445);
            return false;
        }
        if (!(z || C5046bo.isNullOrNil(c34894d.field_username))) {
            mo25303WC(c34894d.field_username);
        }
        c34894d.bJt = -1;
        boolean b = super.mo10101b((C4925c) c34894d);
        AppMethodBeat.m2505o(24445);
        return b;
    }

    /* renamed from: Ct */
    public final int mo25301Ct(int i) {
        AppMethodBeat.m2504i(24446);
        int delete = this.bSd.delete("shakeitem1", "shakeItemID=?", new String[]{String.valueOf(i)});
        doNotify();
        C4990ab.m7416i("MicroMsg.NewShakeItemStorage", "delById id:" + i + " result:" + delete);
        AppMethodBeat.m2505o(24446);
        return delete;
    }

    /* renamed from: WC */
    public final int mo25303WC(String str) {
        AppMethodBeat.m2504i(24447);
        int delete = this.bSd.delete("shakeitem1", "(username=?)", new String[]{String.valueOf(str)});
        if (delete > 0) {
            doNotify();
        }
        C4990ab.m7416i("MicroMsg.NewShakeItemStorage", "delByusername:" + str + " result:" + delete);
        AppMethodBeat.m2505o(24447);
        return delete;
    }

    /* renamed from: Cu */
    public final boolean mo25302Cu(int i) {
        boolean hY;
        AppMethodBeat.m2504i(24448);
        if (i == 0) {
            hY = this.bSd.mo10108hY("shakeitem1", "delete from shakeitem1 where type = " + i + " or type is null");
        } else {
            hY = this.bSd.mo10108hY("shakeitem1", "delete from shakeitem1 where type = ".concat(String.valueOf(i)));
        }
        doNotify();
        AppMethodBeat.m2505o(24448);
        return hY;
    }

    public final boolean cjH() {
        AppMethodBeat.m2504i(24449);
        boolean hY = this.bSd.mo10108hY("shakeitem1", "delete from shakeitem1");
        doNotify();
        AppMethodBeat.m2505o(24449);
        return hY;
    }

    public final void cjI() {
        AppMethodBeat.m2504i(24450);
        C4990ab.m7416i("MicroMsg.NewShakeItemStorage", "setAllOld");
        C34894d c34894d = new C34894d();
        c34894d.field_insertBatch = 0;
        c34894d.bJt = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        if (-1 != this.bSd.update("shakeitem1", c34894d.mo10098Hl(), "insertBatch!=?", new String[]{AppEventsConstants.EVENT_PARAM_VALUE_NO})) {
            doNotify();
        }
        AppMethodBeat.m2505o(24450);
    }
}
