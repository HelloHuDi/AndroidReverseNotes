package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.k;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class EmojiInfo extends ba implements Parcelable, k {
    public static final Creator<EmojiInfo> CREATOR = new Creator<EmojiInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EmojiInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(62758);
            EmojiInfo emojiInfo = new EmojiInfo(parcel);
            AppMethodBeat.o(62758);
            return emojiInfo;
        }
    };
    public static int TYPE_TEXT = 4;
    protected static com.tencent.mm.sdk.e.c.a ccO;
    public static int yaA = 50;
    public static int yaB = 81;
    public static int yaq = -1;
    public static int yau = 65;
    public static String yav = ".gif";
    public static int yax = 17;
    public static int yay = 32;
    public static int yaz = 49;
    public static int zYR = 1;
    public static int zYS = 2;
    public static int zYV = 3;
    public static int zYX = 10;
    public static int zYY = 11;
    public static int zYZ = 0;
    public static int zZa = 1;
    public static int zZb = 3;
    public static int zZc = 4;
    public static int zZd = 8;
    public static int zZe = 0;
    public static int zZf = 1;
    public static int zZg = 0;
    public static int zZh = 1;
    public static int zZi = 1;
    public final String ptQ;
    public String talker;

    public enum b {
        ERR_SUCCESS,
        ERR_NON_NETWORK,
        ERR_WIFI_NETWORK,
        ERR_MOBILE_NETWORK,
        ERR_NOT_COMPLETED,
        ERR_OVER_LIMIT,
        ERR_OTHERS,
        ERR_LOCAL_FILE,
        ERR_OVER_SIZE,
        ERR_SPAM,
        ERR_OVER_UPLOAD_TIME,
        ERR_MIX_VIDEO_ZERO_FRAME,
        ERR_MIX_OUTPUT_EMPTY,
        ERR_MIX_PROCESS_KILL;

        static {
            AppMethodBeat.o(62764);
        }
    }

    public enum a {
        STATUS_SUCCESS,
        STATUS_MIXING,
        STATUS_MIX_FAIL,
        STATUS_UPLOADING,
        STATUS_UPLOAD_FAIL;

        static {
            AppMethodBeat.o(62761);
        }
    }

    static {
        AppMethodBeat.i(62792);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[44];
        aVar.columns = new String[45];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "md5";
        aVar.xDd.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.xDc = "md5";
        aVar.columns[1] = "svrid";
        aVar.xDd.put("svrid", "TEXT");
        stringBuilder.append(" svrid TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "catalog";
        aVar.xDd.put("catalog", "INTEGER");
        stringBuilder.append(" catalog INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "size";
        aVar.xDd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "start";
        aVar.xDd.put("start", "INTEGER");
        stringBuilder.append(" start INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "state";
        aVar.xDd.put("state", "INTEGER");
        stringBuilder.append(" state INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "name";
        aVar.xDd.put("name", "TEXT");
        stringBuilder.append(" name TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT;
        aVar.xDd.put(com.google.firebase.analytics.FirebaseAnalytics.b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "reserved1";
        aVar.xDd.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "reserved2";
        aVar.xDd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "reserved3";
        aVar.xDd.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "reserved4";
        aVar.xDd.put("reserved4", "INTEGER");
        stringBuilder.append(" reserved4 INTEGER");
        stringBuilder.append(", ");
        aVar.columns[13] = "app_id";
        aVar.xDd.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "groupId";
        aVar.xDd.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "lastUseTime";
        aVar.xDd.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        aVar.columns[16] = "framesInfo";
        aVar.xDd.put("framesInfo", "TEXT default '' ");
        stringBuilder.append(" framesInfo TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "idx";
        aVar.xDd.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "temp";
        aVar.xDd.put("temp", "INTEGER default '0' ");
        stringBuilder.append(" temp INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "source";
        aVar.xDd.put("source", "INTEGER default '0' ");
        stringBuilder.append(" source INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "needupload";
        aVar.xDd.put("needupload", "INTEGER default '0' ");
        stringBuilder.append(" needupload INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "designerID";
        aVar.xDd.put("designerID", "TEXT");
        stringBuilder.append(" designerID TEXT");
        stringBuilder.append(", ");
        aVar.columns[22] = "thumbUrl";
        aVar.xDd.put("thumbUrl", "TEXT");
        stringBuilder.append(" thumbUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "cdnUrl";
        aVar.xDd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "encrypturl";
        aVar.xDd.put("encrypturl", "TEXT");
        stringBuilder.append(" encrypturl TEXT");
        stringBuilder.append(", ");
        aVar.columns[25] = "aeskey";
        aVar.xDd.put("aeskey", "TEXT");
        stringBuilder.append(" aeskey TEXT");
        stringBuilder.append(", ");
        aVar.columns[26] = "width";
        aVar.xDd.put("width", "INTEGER default '0' ");
        stringBuilder.append(" width INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[27] = "height";
        aVar.xDd.put("height", "INTEGER default '0' ");
        stringBuilder.append(" height INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[28] = "externUrl";
        aVar.xDd.put("externUrl", "TEXT");
        stringBuilder.append(" externUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[29] = "externMd5";
        aVar.xDd.put("externMd5", "TEXT");
        stringBuilder.append(" externMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[30] = "activityid";
        aVar.xDd.put("activityid", "TEXT");
        stringBuilder.append(" activityid TEXT");
        stringBuilder.append(", ");
        aVar.columns[31] = "tpurl";
        aVar.xDd.put("tpurl", "TEXT");
        stringBuilder.append(" tpurl TEXT");
        stringBuilder.append(", ");
        aVar.columns[32] = "tpauthkey";
        aVar.xDd.put("tpauthkey", "TEXT");
        stringBuilder.append(" tpauthkey TEXT");
        stringBuilder.append(", ");
        aVar.columns[33] = "wxamMd5";
        aVar.xDd.put("wxamMd5", "TEXT");
        stringBuilder.append(" wxamMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[34] = "attachedText";
        aVar.xDd.put("attachedText", "TEXT");
        stringBuilder.append(" attachedText TEXT");
        stringBuilder.append(", ");
        aVar.columns[35] = "captureStatus";
        aVar.xDd.put("captureStatus", "INTEGER default '0' ");
        stringBuilder.append(" captureStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[36] = "attachedEmojiMD5";
        aVar.xDd.put("attachedEmojiMD5", "BLOB default '' ");
        stringBuilder.append(" attachedEmojiMD5 BLOB default '' ");
        stringBuilder.append(", ");
        aVar.columns[37] = "imitateMd5";
        aVar.xDd.put("imitateMd5", "TEXT");
        stringBuilder.append(" imitateMd5 TEXT");
        stringBuilder.append(", ");
        aVar.columns[38] = "captureUploadErrCode";
        aVar.xDd.put("captureUploadErrCode", "INTEGER default '0' ");
        stringBuilder.append(" captureUploadErrCode INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[39] = "captureUploadCounter";
        aVar.xDd.put("captureUploadCounter", "INTEGER default '0' ");
        stringBuilder.append(" captureUploadCounter INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[40] = "captureEnterTime";
        aVar.xDd.put("captureEnterTime", "LONG");
        stringBuilder.append(" captureEnterTime LONG");
        stringBuilder.append(", ");
        aVar.columns[41] = "lensId";
        aVar.xDd.put("lensId", "TEXT");
        stringBuilder.append(" lensId TEXT");
        stringBuilder.append(", ");
        aVar.columns[42] = "attachTextColor";
        aVar.xDd.put("attachTextColor", "TEXT");
        stringBuilder.append(" attachTextColor TEXT");
        stringBuilder.append(", ");
        aVar.columns[43] = "captureScene";
        aVar.xDd.put("captureScene", "INTEGER");
        stringBuilder.append(" captureScene INTEGER");
        aVar.columns[44] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62792);
    }

    public EmojiInfo() {
        AppMethodBeat.i(62765);
        if (((h) g.RM().Rn()).SG()) {
            StringBuilder stringBuilder = new StringBuilder();
            g.RQ();
            this.ptQ = stringBuilder.append(g.RP().eJM).append("emoji/").toString();
        } else {
            this.ptQ = ((d) g.M(d.class)).getProvider().getAccPath() + "emoji/";
        }
        reset();
        AppMethodBeat.o(62765);
    }

    public EmojiInfo(String str) {
        AppMethodBeat.i(62766);
        this.ptQ = str;
        reset();
        AppMethodBeat.o(62766);
    }

    public final void reset() {
        AppMethodBeat.i(62767);
        this.field_md5 = "";
        this.field_svrid = "";
        this.field_catalog = yax;
        this.field_type = zYR;
        this.field_size = 0;
        this.field_start = 0;
        this.field_state = zYZ;
        this.field_name = "";
        this.field_content = "";
        this.field_reserved1 = "";
        this.field_reserved2 = "";
        this.field_reserved3 = 0;
        this.field_reserved4 = 0;
        this.field_app_id = "";
        this.field_temp = 0;
        this.field_captureStatus = a.STATUS_SUCCESS.ordinal();
        this.field_captureUploadErrCode = b.ERR_SUCCESS.ordinal();
        this.field_captureUploadCounter = 0;
        this.field_imitateMd5 = "";
        this.field_attachedEmojiMD5 = new byte[0];
        AppMethodBeat.o(62767);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A:{SYNTHETIC, Splitter:B:26:0x007f} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7 A:{SYNTHETIC, Splitter:B:34:0x00a7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] gZ(int i, int i2) {
        InputStream bJ;
        Throwable e;
        byte[] e2;
        AppMethodBeat.i(62768);
        if (i < 0 || i2 < 0) {
            AppMethodBeat.o(62768);
            return null;
        }
        if (this.field_catalog == yax || this.field_catalog == yaA || this.field_catalog == yaz) {
            try {
                ab.d("MicroMsg.emoji.EmojiInfo", "get name %s", getName());
                bJ = bJ(ah.getContext(), getName());
            } catch (IOException e3) {
                e = e3;
                bJ = null;
                try {
                    ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e));
                    if (bJ != null) {
                    }
                    e2 = e.e(dve(), this.field_start, i2);
                    AppMethodBeat.o(62768);
                    return e2;
                } catch (Throwable th) {
                    e = th;
                    if (bJ != null) {
                        try {
                            bJ.close();
                        } catch (IOException e4) {
                            ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e4));
                        }
                    }
                    AppMethodBeat.o(62768);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                bJ = null;
                if (bJ != null) {
                }
                AppMethodBeat.o(62768);
                throw e;
            }
            try {
                bJ.skip((long) i);
                e2 = new byte[i2];
                bJ.read(e2, 0, i2);
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e5) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e5));
                    }
                }
                AppMethodBeat.o(62768);
                return e2;
            } catch (IOException th3) {
                e = th3;
                ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e));
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e42) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e42));
                    }
                }
                e2 = e.e(dve(), this.field_start, i2);
                AppMethodBeat.o(62768);
                return e2;
            }
        }
        e2 = e.e(dve(), this.field_start, i2);
        AppMethodBeat.o(62768);
        return e2;
    }

    public final boolean duP() {
        AppMethodBeat.i(62769);
        if (this.field_catalog == yax || this.field_catalog == EmojiGroupInfo.yas || this.field_catalog == yaA || this.field_catalog == yaz) {
            AppMethodBeat.o(62769);
            return true;
        }
        String dve = dve();
        if (bo.isNullOrNil(dve)) {
            AppMethodBeat.o(62769);
            return false;
        }
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(dve);
        if (!bVar.exists() || bVar.length() <= 0) {
            AppMethodBeat.o(62769);
            return false;
        }
        AppMethodBeat.o(62769);
        return true;
    }

    public final void duQ() {
        AppMethodBeat.i(62770);
        if (this.field_catalog == yax || this.field_catalog == yaA || this.field_catalog == yaz) {
            AppMethodBeat.o(62770);
            return;
        }
        String dve = dve();
        if (!bo.isNullOrNil(dve)) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(dve);
            if (bVar.exists()) {
                bVar.delete();
            }
        }
        AppMethodBeat.o(62770);
    }

    public final boolean duR() {
        AppMethodBeat.i(62771);
        if (this.field_catalog == yax || this.field_catalog == yaA || this.field_catalog == yaz) {
            AppMethodBeat.o(62771);
            return true;
        }
        String dve = dve();
        if (bo.isNullOrNil(dve)) {
            AppMethodBeat.o(62771);
            return false;
        }
        boolean exists = new com.tencent.mm.vfs.b(dve).exists();
        AppMethodBeat.o(62771);
        return exists;
    }

    public static InputStream bJ(Context context, String str) {
        InputStream inputStream = null;
        AppMethodBeat.i(62772);
        if (context == null || bo.isNullOrNil(str)) {
            AppMethodBeat.o(62772);
        } else {
            try {
                ab.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", str.split("\\.")[0]);
                inputStream = context.getResources().openRawResource(context.getResources().getIdentifier(r1, "drawable", context.getPackageName()));
                AppMethodBeat.o(62772);
            } catch (Exception e) {
                ab.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", e.getMessage());
                AppMethodBeat.o(62772);
            }
        }
        return inputStream;
    }

    public final synchronized Bitmap hk(Context context) {
        Bitmap hl;
        AppMethodBeat.i(62773);
        hl = hl(context);
        AppMethodBeat.o(62773);
        return hl;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:115:0x0291=Splitter:B:115:0x0291, B:82:0x0156=Splitter:B:82:0x0156} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02cf A:{SYNTHETIC, Splitter:B:126:0x02cf} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b0 A:{SYNTHETIC, Splitter:B:118:0x02b0} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a6 A:{SYNTHETIC, Splitter:B:51:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b0 A:{SYNTHETIC, Splitter:B:118:0x02b0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized Bitmap hl(Context context) {
        InputStream bJ;
        Bitmap decodeStream;
        Throwable e;
        InputStream inputStream = null;
        synchronized (this) {
            AppMethodBeat.i(62775);
            com.tencent.mm.bz.a.fromDPToPix(context, 120);
            String name;
            if (this.field_catalog == yax || this.field_catalog == EmojiGroupInfo.yas || this.field_catalog == yaA || this.field_catalog == yaz) {
                try {
                    name = getName();
                    if (this.field_type == zYS) {
                        name = bo.isNullOrNil(getContent()) ? getName() : getContent();
                    }
                    bJ = bJ(context, name);
                    try {
                        decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(bJ);
                        if (bJ != null) {
                            try {
                                bJ.close();
                            } catch (IOException e2) {
                                ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e2));
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    bJ = null;
                } catch (Throwable th) {
                    e = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e5));
                        }
                    }
                    AppMethodBeat.o(62775);
                    throw e;
                }
            }
            try {
                com.tencent.mm.vfs.b bVar;
                if (duU()) {
                    String str;
                    name = dve();
                    if (name == null) {
                        str = this.ptQ + this.field_groupId + "/" + Aq() + "_0";
                    } else {
                        str = name;
                    }
                    bVar = new com.tencent.mm.vfs.b(str);
                } else {
                    bVar = new com.tencent.mm.vfs.b(this.ptQ + Aq() + "_thumb");
                }
                if (bVar.exists()) {
                    bJ = e.p(bVar);
                    try {
                        decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(bJ);
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        decodeStream = null;
                    } catch (Exception e7) {
                        e = e7;
                        decodeStream = null;
                        ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e));
                        ab.e("MicroMsg.emoji.EmojiInfo", e.getMessage());
                        if (bJ != null) {
                        }
                        AppMethodBeat.o(62775);
                        return decodeStream;
                    }
                }
                if (!duU()) {
                    bJ = e.openRead(this.ptQ + Aq());
                    decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(bJ);
                } else if (VERSION.SDK_INT < 19) {
                    bJ = e.openRead(this.ptQ + this.field_groupId + "/" + Aq());
                    decodeStream = com.tencent.mm.sdk.platformtools.d.decodeStream(bJ);
                } else {
                    bJ = null;
                    decodeStream = null;
                }
                try {
                    if (duU()) {
                        ab.d("MicroMsg.emoji.EmojiInfo", "cpan emojiinfo save cover.");
                        if (!new com.tencent.mm.vfs.b(this.ptQ + this.field_groupId + "/" + Aq() + "_cover").exists() && VERSION.SDK_INT < 19) {
                            com.tencent.mm.sdk.platformtools.d.a(decodeStream, 100, CompressFormat.PNG, this.ptQ + this.field_groupId + "/" + Aq() + "_cover", false);
                        }
                    } else {
                        com.tencent.mm.sdk.platformtools.d.a(decodeStream, 100, CompressFormat.PNG, this.ptQ + Aq() + "_thumb", false);
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                } catch (Exception e9) {
                    e = e9;
                    ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e));
                    ab.e("MicroMsg.emoji.EmojiInfo", e.getMessage());
                    if (bJ != null) {
                    }
                    AppMethodBeat.o(62775);
                    return decodeStream;
                }
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e22) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e22));
                    }
                }
            } catch (FileNotFoundException e10) {
                e = e10;
                bJ = null;
                decodeStream = null;
            } catch (Exception e11) {
                e = e11;
                bJ = null;
                decodeStream = null;
                ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e));
                ab.e("MicroMsg.emoji.EmojiInfo", e.getMessage());
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e222) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e222));
                    }
                }
                AppMethodBeat.o(62775);
                return decodeStream;
            } catch (Throwable th2) {
                e = th2;
                bJ = null;
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e52) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e52));
                    }
                }
                AppMethodBeat.o(62775);
                throw e;
            }
            AppMethodBeat.o(62775);
        }
        return decodeStream;
        try {
            ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e));
            if (bJ != null) {
                try {
                    bJ.close();
                    decodeStream = null;
                } catch (IOException e2222) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e2222));
                    decodeStream = null;
                }
            } else {
                decodeStream = null;
            }
            AppMethodBeat.o(62775);
            return decodeStream;
        } catch (Throwable th3) {
            e = th3;
            inputStream = bJ;
            if (inputStream != null) {
            }
            AppMethodBeat.o(62775);
            throw e;
        }
        try {
            ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e));
            ab.e("MicroMsg.emoji.EmojiInfo", e.getMessage());
            if (bJ != null) {
                try {
                    bJ.close();
                } catch (IOException e22222) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "exception:%s", bo.l(e22222));
                }
            }
            AppMethodBeat.o(62775);
            return decodeStream;
        } catch (Throwable th4) {
            e = th4;
            if (bJ != null) {
            }
            AppMethodBeat.o(62775);
            throw e;
        }
    }

    public final boolean xy() {
        return this.field_catalog == yaA || this.field_catalog == yaz;
    }

    public final boolean duS() {
        return this.field_catalog == yax || this.field_catalog == yaA || this.field_catalog == yaz;
    }

    public final boolean duT() {
        AppMethodBeat.i(62776);
        boolean equalsIgnoreCase = this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
        AppMethodBeat.o(62776);
        return equalsIgnoreCase;
    }

    public final boolean isGif() {
        return this.field_type == zYS || this.field_type == zYX;
    }

    public static boolean Mw(int i) {
        return i == yaA || i == yaz;
    }

    public final boolean duV() {
        AppMethodBeat.i(62778);
        if (bo.isNullOrNil(this.field_wxamMd5)) {
            AppMethodBeat.o(62778);
            return false;
        }
        AppMethodBeat.o(62778);
        return true;
    }

    public final void vS(String str) {
        this.field_md5 = str;
    }

    public final String Aq() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    public final boolean cVD() {
        AppMethodBeat.i(62779);
        if (Aq().length() == 32) {
            AppMethodBeat.o(62779);
            return true;
        }
        AppMethodBeat.o(62779);
        return false;
    }

    public final String duW() {
        return this.field_svrid == null ? "" : this.field_svrid;
    }

    public final void Vp(int i) {
        this.field_catalog = i;
    }

    public final int getGroup() {
        return this.field_catalog;
    }

    public final void setType(int i) {
        this.field_type = i;
    }

    public final void setSize(int i) {
        this.field_size = i;
    }

    public final int getSize() {
        return this.field_size;
    }

    public final void setState(int i) {
        this.field_state = i;
    }

    public final int getState() {
        return this.field_state;
    }

    public final String getName() {
        return this.field_name == null ? "" : this.field_name;
    }

    public final String getContent() {
        return this.field_content == null ? "" : this.field_content;
    }

    public final int duX() {
        return this.field_reserved4;
    }

    public final String awa() {
        return this.field_groupId;
    }

    public final void asX(String str) {
        this.field_groupId = str;
    }

    public final void duY() {
        this.field_temp = 1;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(62780);
        this.field_captureStatus = aVar.ordinal();
        AppMethodBeat.o(62780);
    }

    public final a duZ() {
        switch (this.field_captureStatus) {
            case 0:
                return a.STATUS_SUCCESS;
            case 1:
                return a.STATUS_MIXING;
            case 2:
                return a.STATUS_MIX_FAIL;
            case 3:
                return a.STATUS_UPLOADING;
            case 4:
                return a.STATUS_UPLOAD_FAIL;
            default:
                return a.STATUS_SUCCESS;
        }
    }

    public final int dva() {
        return this.field_captureUploadCounter;
    }

    public final void dvb() {
        this.field_captureUploadCounter++;
    }

    public final void a(b bVar) {
        AppMethodBeat.i(62781);
        this.field_captureUploadErrCode = bVar.ordinal();
        AppMethodBeat.o(62781);
    }

    public final b dvc() {
        switch (this.field_captureUploadErrCode) {
            case 0:
                return b.ERR_SUCCESS;
            case 1:
                return b.ERR_NON_NETWORK;
            case 2:
                return b.ERR_WIFI_NETWORK;
            case 3:
                return b.ERR_MOBILE_NETWORK;
            case 4:
                return b.ERR_NOT_COMPLETED;
            case 5:
                return b.ERR_OVER_LIMIT;
            case 6:
                return b.ERR_OTHERS;
            case 7:
                return b.ERR_LOCAL_FILE;
            case 8:
                return b.ERR_OVER_SIZE;
            case 9:
                return b.ERR_SPAM;
            case 10:
                return b.ERR_OVER_UPLOAD_TIME;
            default:
                return b.ERR_OTHERS;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cb A:{SYNTHETIC, Splitter:B:34:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d0 A:{SYNTHETIC, Splitter:B:37:0x00d0} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e A:{SYNTHETIC, Splitter:B:21:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083 A:{SYNTHETIC, Splitter:B:24:0x0083} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cb A:{SYNTHETIC, Splitter:B:34:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d0 A:{SYNTHETIC, Splitter:B:37:0x00d0} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007e A:{SYNTHETIC, Splitter:B:21:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083 A:{SYNTHETIC, Splitter:B:24:0x0083} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void al(ArrayList<String> arrayList) {
        ObjectOutputStream objectOutputStream;
        Exception e;
        Throwable th;
        AppMethodBeat.i(62782);
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Exception e2) {
                e = e2;
                objectOutputStream = null;
                try {
                    ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 failure, msg: " + e.getMessage());
                    if (objectOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.o(62782);
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.o(62782);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                if (objectOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                AppMethodBeat.o(62782);
                throw th;
            }
            try {
                objectOutputStream.writeObject(arrayList);
                this.field_attachedEmojiMD5 = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (Exception e3) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 oos close failure, msg: " + e3.getMessage());
                }
                try {
                    byteArrayOutputStream.close();
                    AppMethodBeat.o(62782);
                } catch (Exception e32) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 bos close failure, msg: " + e32.getMessage());
                    AppMethodBeat.o(62782);
                }
            } catch (Exception e4) {
                e32 = e4;
                ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 failure, msg: " + e32.getMessage());
                if (objectOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                AppMethodBeat.o(62782);
            }
        } catch (Exception e5) {
            e32 = e5;
            objectOutputStream = null;
            byteArrayOutputStream = null;
            ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 failure, msg: " + e32.getMessage());
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e322) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 oos close failure, msg: " + e322.getMessage());
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e3222) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 bos close failure, msg: " + e3222.getMessage());
                    AppMethodBeat.o(62782);
                    return;
                }
            }
            AppMethodBeat.o(62782);
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream = null;
            byteArrayOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e6) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 oos close failure, msg: " + e6.getMessage());
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e62) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 bos close failure, msg: " + e62.getMessage());
                }
            }
            AppMethodBeat.o(62782);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a A:{SYNTHETIC, Splitter:B:22:0x007a} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A:{SYNTHETIC, Splitter:B:25:0x007f} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A:{SYNTHETIC, Splitter:B:35:0x00c3} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c8 A:{SYNTHETIC, Splitter:B:38:0x00c8} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a A:{SYNTHETIC, Splitter:B:22:0x007a} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f A:{SYNTHETIC, Splitter:B:25:0x007f} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A:{SYNTHETIC, Splitter:B:35:0x00c3} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c8 A:{SYNTHETIC, Splitter:B:38:0x00c8} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final ArrayList<String> dvd() {
        ObjectInputStream objectInputStream;
        Exception e;
        ArrayList<String> arrayList;
        Throwable th;
        AppMethodBeat.i(62783);
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(this.field_attachedEmojiMD5);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Exception e2) {
                e = e2;
                objectInputStream = null;
                try {
                    ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 failure, msg: " + e.getMessage());
                    if (byteArrayInputStream != null) {
                    }
                    if (objectInputStream != null) {
                    }
                    arrayList = null;
                    AppMethodBeat.o(62783);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayInputStream != null) {
                    }
                    if (objectInputStream != null) {
                    }
                    AppMethodBeat.o(62783);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e3) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 bis close failure, msg: " + e3.getMessage());
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e32) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 ois close failure, msg: " + e32.getMessage());
                    }
                }
                AppMethodBeat.o(62783);
                throw th;
            }
            try {
                arrayList = (ArrayList) objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception e322) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 bis close failure, msg: " + e322.getMessage());
                }
                try {
                    objectInputStream.close();
                } catch (Exception e3222) {
                    ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 ois close failure, msg: " + e3222.getMessage());
                }
            } catch (Exception e4) {
                e = e4;
                ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 failure, msg: " + e.getMessage());
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e5) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 bis close failure, msg: " + e5.getMessage());
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e52) {
                        ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 ois close failure, msg: " + e52.getMessage());
                        arrayList = null;
                    }
                }
                arrayList = null;
                AppMethodBeat.o(62783);
                return arrayList;
            }
        } catch (Exception e6) {
            e52 = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
            ab.e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 failure, msg: " + e52.getMessage());
            if (byteArrayInputStream != null) {
            }
            if (objectInputStream != null) {
            }
            arrayList = null;
            AppMethodBeat.o(62783);
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
            }
            if (objectInputStream != null) {
            }
            AppMethodBeat.o(62783);
            throw th;
        }
        AppMethodBeat.o(62783);
        return arrayList;
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    public final String dve() {
        String str = null;
        AppMethodBeat.i(62784);
        if (bo.isNullOrNil(this.field_groupId) && bo.isNullOrNil(this.field_md5)) {
            ab.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
            AppMethodBeat.o(62784);
        } else {
            if (!bo.isNullOrNil(this.field_md5)) {
                if (bo.isNullOrNil(this.field_groupId) || bo.isEqual(this.field_groupId, "capture")) {
                    str = this.ptQ + this.field_md5;
                } else {
                    str = this.ptQ + this.field_groupId + "/" + this.field_md5;
                }
            }
            AppMethodBeat.o(62784);
        }
        return str;
    }

    public final String dvf() {
        AppMethodBeat.i(62785);
        String dve = dve();
        if (dve == null) {
            AppMethodBeat.o(62785);
            return null;
        }
        dve = dve + "_cover";
        AppMethodBeat.o(62785);
        return dve;
    }

    public static String dvg() {
        AppMethodBeat.i(62786);
        String str = ((d) g.M(d.class)).getProvider().getAccPath() + "emoji/";
        AppMethodBeat.o(62786);
        return str;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(62787);
        boolean cJ = cJ(obj);
        AppMethodBeat.o(62787);
        return cJ;
    }

    public final boolean cJ(Object obj) {
        AppMethodBeat.i(62788);
        if (obj != null && (obj instanceof EmojiInfo) && ((EmojiInfo) obj).Aq().equalsIgnoreCase(this.field_md5)) {
            AppMethodBeat.o(62788);
            return true;
        }
        AppMethodBeat.o(62788);
        return false;
    }

    public String toString() {
        AppMethodBeat.i(62789);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field_md5:").append(this.field_md5).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_svrid:").append(this.field_svrid).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_catalog:").append(this.field_catalog).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_type:").append(this.field_type).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_size:").append(this.field_size).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_start:").append(this.field_start).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_state:").append(this.field_state).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_name:").append(this.field_name).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_content:").append(this.field_content).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_reserved1:").append(this.field_reserved1).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_reserved2:").append(this.field_reserved2).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_reserved3:").append(this.field_reserved3).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_reserved4:").append(this.field_reserved4).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_app_id:").append(this.field_app_id).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_groupId:").append(this.field_groupId).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_framesInfo:").append(this.field_framesInfo).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_idx:").append(this.field_idx).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_temp:").append(this.field_temp).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_source:").append(this.field_source).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_needupload:").append(this.field_needupload).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_designerID:").append(this.field_designerID).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_thumbUrl:").append(this.field_thumbUrl).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_captureStatus:").append(this.field_captureStatus).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_captureUploadErrCode").append(this.field_captureUploadErrCode).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_captureUploadCounter").append(this.field_captureUploadCounter).append(IOUtils.LINE_SEPARATOR_UNIX);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(62789);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(62790);
        parcel.writeString(this.ptQ);
        parcel.writeString(this.field_md5);
        parcel.writeString(this.field_svrid);
        parcel.writeInt(this.field_catalog);
        parcel.writeInt(this.field_type);
        parcel.writeInt(this.field_size);
        parcel.writeInt(this.field_start);
        parcel.writeInt(this.field_state);
        parcel.writeString(this.field_name);
        parcel.writeString(this.field_content);
        parcel.writeString(this.field_reserved1);
        parcel.writeString(this.field_reserved2);
        parcel.writeInt(this.field_reserved3);
        parcel.writeInt(this.field_reserved4);
        parcel.writeString(this.field_app_id);
        parcel.writeString(this.field_groupId);
        parcel.writeLong(this.field_lastUseTime);
        parcel.writeString(this.field_framesInfo);
        parcel.writeInt(this.field_idx);
        parcel.writeInt(this.field_temp);
        parcel.writeInt(this.field_source);
        parcel.writeInt(this.field_needupload);
        parcel.writeString(this.field_designerID);
        parcel.writeString(this.field_thumbUrl);
        parcel.writeString(this.field_cdnUrl);
        parcel.writeString(this.field_encrypturl);
        parcel.writeString(this.field_aeskey);
        parcel.writeInt(this.field_width);
        parcel.writeInt(this.field_height);
        parcel.writeString(this.field_activityid);
        parcel.writeLong(this.xDa);
        parcel.writeString(this.field_wxamMd5);
        parcel.writeString(this.field_attachedText);
        parcel.writeInt(this.field_captureStatus);
        if (this.field_attachedEmojiMD5 == null || this.field_attachedEmojiMD5.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.field_attachedEmojiMD5.length);
            parcel.writeByteArray(this.field_attachedEmojiMD5);
        }
        parcel.writeString(this.field_imitateMd5);
        parcel.writeInt(this.field_captureUploadErrCode);
        parcel.writeInt(this.field_captureUploadCounter);
        parcel.writeLong(this.field_captureEnterTime);
        parcel.writeString(this.field_lensId);
        parcel.writeString(this.field_attachTextColor);
        parcel.writeInt(this.field_captureScene);
        AppMethodBeat.o(62790);
    }

    protected EmojiInfo(Parcel parcel) {
        AppMethodBeat.i(62791);
        this.ptQ = parcel.readString();
        this.field_md5 = parcel.readString();
        this.field_svrid = parcel.readString();
        this.field_catalog = parcel.readInt();
        this.field_type = parcel.readInt();
        this.field_size = parcel.readInt();
        this.field_start = parcel.readInt();
        this.field_state = parcel.readInt();
        this.field_name = parcel.readString();
        this.field_content = parcel.readString();
        this.field_reserved1 = parcel.readString();
        this.field_reserved2 = parcel.readString();
        this.field_reserved3 = parcel.readInt();
        this.field_reserved4 = parcel.readInt();
        this.field_app_id = parcel.readString();
        this.field_groupId = parcel.readString();
        this.field_lastUseTime = parcel.readLong();
        this.field_framesInfo = parcel.readString();
        this.field_idx = parcel.readInt();
        this.field_temp = parcel.readInt();
        this.field_source = parcel.readInt();
        this.field_needupload = parcel.readInt();
        this.field_designerID = parcel.readString();
        this.field_thumbUrl = parcel.readString();
        this.field_cdnUrl = parcel.readString();
        this.field_encrypturl = parcel.readString();
        this.field_aeskey = parcel.readString();
        this.field_width = parcel.readInt();
        this.field_height = parcel.readInt();
        this.field_activityid = parcel.readString();
        this.xDa = parcel.readLong();
        this.field_wxamMd5 = parcel.readString();
        this.field_attachedText = parcel.readString();
        this.field_captureStatus = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_attachedEmojiMD5 = new byte[readInt];
            parcel.readByteArray(this.field_attachedEmojiMD5);
        }
        this.field_imitateMd5 = parcel.readString();
        this.field_captureUploadErrCode = parcel.readInt();
        this.field_captureUploadCounter = parcel.readInt();
        this.field_captureEnterTime = parcel.readLong();
        this.field_lensId = parcel.readString();
        this.field_attachTextColor = parcel.readString();
        this.field_captureScene = parcel.readInt();
        AppMethodBeat.o(62791);
    }

    public final synchronized Bitmap w(Context context, int i) {
        Bitmap bitmap;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(62774);
            String name;
            if (this.field_catalog == EmojiGroupInfo.yas || this.field_catalog == yaA || this.field_catalog == yaz) {
                name = getName();
                if (bo.isNullOrNil(name)) {
                    ab.i("MicroMsg.emoji.EmojiInfo", "name is null");
                    ab.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", this);
                    bitmap = null;
                    AppMethodBeat.o(62774);
                } else {
                    if (name.startsWith("jsb")) {
                        name = "jsb";
                    } else if (name.startsWith("dice")) {
                        name = "dice";
                    } else {
                        name = name.replaceAll(".png", "");
                    }
                    bitmap = com.tencent.mm.sdk.platformtools.d.v(context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", ah.getPackageName())));
                    ab.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                    AppMethodBeat.o(62774);
                }
            } else if (this.field_catalog == EmojiGroupInfo.yar) {
                name = getName();
                if (bo.isNullOrNil(name)) {
                    ab.i("MicroMsg.emoji.EmojiInfo", "name is null");
                } else {
                    name = (bo.isNullOrNil(getContent()) ? getName() : getContent()).replaceAll(".png", "");
                }
                ab.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", name);
                bitmap = com.tencent.mm.sdk.platformtools.d.v(context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", ah.getPackageName())));
                ab.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                AppMethodBeat.o(62774);
            } else {
                name = dve() + "_cover";
                ab.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", name, Boolean.valueOf(e.ct(name)));
                if (e.ct(name)) {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(name, options);
                    if (options.outHeight >= i || options.outWidth >= i) {
                        bitmap = com.tencent.mm.sdk.platformtools.d.ao(name, i, i);
                    } else {
                        bitmap = com.tencent.mm.sdk.platformtools.d.ao(name, options.outHeight, options.outWidth);
                    }
                    String str = "MicroMsg.emoji.EmojiInfo";
                    String str2 = "id:%s width:%s height:%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = Integer.valueOf(this.field_catalog);
                    objArr[1] = Integer.valueOf(bitmap == null ? 0 : bitmap.getWidth());
                    if (bitmap != null) {
                        i2 = bitmap.getHeight();
                    }
                    objArr[2] = Integer.valueOf(i2);
                    ab.i(str, str2, objArr);
                    AppMethodBeat.o(62774);
                } else {
                    if (e.ct(dve())) {
                        byte[] l = ((d) g.M(d.class)).getProvider().l(this);
                        if (l == null) {
                            ab.e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
                            bitmap = null;
                            AppMethodBeat.o(62774);
                        } else {
                            ab.i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", Integer.valueOf(l.length));
                            if (r.bU(l)) {
                                bitmap = i.aW(l);
                            } else {
                                bitmap = com.tencent.mm.sdk.platformtools.d.decodeByteArray(l, i, i);
                            }
                            if (bitmap != null) {
                                ab.i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", this, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                            }
                            AppMethodBeat.o(62774);
                        }
                    } else {
                        ab.w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", dve(), Boolean.valueOf(e.ct(dve())));
                        ab.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", this);
                        bitmap = null;
                        AppMethodBeat.o(62774);
                    }
                }
            }
        }
        return bitmap;
    }

    public final boolean duU() {
        AppMethodBeat.i(62777);
        if (!bo.isNullOrNil(this.field_app_id) || bo.isNullOrNil(this.field_groupId) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yas)) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yar)) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yat)) || this.field_groupId.equals(String.valueOf(yau)) || this.field_groupId.equals("capture")) {
            AppMethodBeat.o(62777);
            return false;
        }
        AppMethodBeat.o(62777);
        return true;
    }
}
