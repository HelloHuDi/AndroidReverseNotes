package com.tencent.p177mm.storage.emotion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.api.C8955k;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p711c.C37835ba;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.gif.C34325i;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
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

/* renamed from: com.tencent.mm.storage.emotion.EmojiInfo */
public class EmojiInfo extends C37835ba implements Parcelable, C8955k {
    public static final Creator<EmojiInfo> CREATOR = new C235151();
    public static int TYPE_TEXT = 4;
    protected static C4924a ccO;
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

    /* renamed from: com.tencent.mm.storage.emotion.EmojiInfo$1 */
    static class C235151 implements Creator<EmojiInfo> {
        C235151() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EmojiInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(62758);
            EmojiInfo emojiInfo = new EmojiInfo(parcel);
            AppMethodBeat.m2505o(62758);
            return emojiInfo;
        }
    }

    /* renamed from: com.tencent.mm.storage.emotion.EmojiInfo$b */
    public enum C30301b {
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
            AppMethodBeat.m2505o(62764);
        }
    }

    /* renamed from: com.tencent.mm.storage.emotion.EmojiInfo$a */
    public enum C30302a {
        STATUS_SUCCESS,
        STATUS_MIXING,
        STATUS_MIX_FAIL,
        STATUS_UPLOADING,
        STATUS_UPLOAD_FAIL;

        static {
            AppMethodBeat.m2505o(62761);
        }
    }

    static {
        AppMethodBeat.m2504i(62792);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[44];
        c4924a.columns = new String[45];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "md5";
        c4924a.xDd.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        c4924a.xDc = "md5";
        c4924a.columns[1] = "svrid";
        c4924a.xDd.put("svrid", "TEXT");
        stringBuilder.append(" svrid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "catalog";
        c4924a.xDd.put("catalog", "INTEGER");
        stringBuilder.append(" catalog INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[3] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[4] = "size";
        c4924a.xDd.put("size", "INTEGER");
        stringBuilder.append(" size INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[5] = "start";
        c4924a.xDd.put("start", "INTEGER");
        stringBuilder.append(" start INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[6] = "state";
        c4924a.xDd.put("state", "INTEGER");
        stringBuilder.append(" state INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[7] = "name";
        c4924a.xDd.put("name", "TEXT");
        stringBuilder.append(" name TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = C8741b.CONTENT;
        c4924a.xDd.put(C8741b.CONTENT, "TEXT");
        stringBuilder.append(" content TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "reserved1";
        c4924a.xDd.put("reserved1", "TEXT");
        stringBuilder.append(" reserved1 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "reserved2";
        c4924a.xDd.put("reserved2", "TEXT");
        stringBuilder.append(" reserved2 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[11] = "reserved3";
        c4924a.xDd.put("reserved3", "INTEGER");
        stringBuilder.append(" reserved3 INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "reserved4";
        c4924a.xDd.put("reserved4", "INTEGER");
        stringBuilder.append(" reserved4 INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[13] = "app_id";
        c4924a.xDd.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        c4924a.columns[14] = "groupId";
        c4924a.xDd.put("groupId", "TEXT default '' ");
        stringBuilder.append(" groupId TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[15] = "lastUseTime";
        c4924a.xDd.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[16] = "framesInfo";
        c4924a.xDd.put("framesInfo", "TEXT default '' ");
        stringBuilder.append(" framesInfo TEXT default '' ");
        stringBuilder.append(", ");
        c4924a.columns[17] = "idx";
        c4924a.xDd.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "temp";
        c4924a.xDd.put("temp", "INTEGER default '0' ");
        stringBuilder.append(" temp INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[19] = "source";
        c4924a.xDd.put("source", "INTEGER default '0' ");
        stringBuilder.append(" source INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[20] = "needupload";
        c4924a.xDd.put("needupload", "INTEGER default '0' ");
        stringBuilder.append(" needupload INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[21] = "designerID";
        c4924a.xDd.put("designerID", "TEXT");
        stringBuilder.append(" designerID TEXT");
        stringBuilder.append(", ");
        c4924a.columns[22] = "thumbUrl";
        c4924a.xDd.put("thumbUrl", "TEXT");
        stringBuilder.append(" thumbUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[23] = "cdnUrl";
        c4924a.xDd.put("cdnUrl", "TEXT");
        stringBuilder.append(" cdnUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[24] = "encrypturl";
        c4924a.xDd.put("encrypturl", "TEXT");
        stringBuilder.append(" encrypturl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[25] = "aeskey";
        c4924a.xDd.put("aeskey", "TEXT");
        stringBuilder.append(" aeskey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[26] = "width";
        c4924a.xDd.put("width", "INTEGER default '0' ");
        stringBuilder.append(" width INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[27] = "height";
        c4924a.xDd.put("height", "INTEGER default '0' ");
        stringBuilder.append(" height INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[28] = "externUrl";
        c4924a.xDd.put("externUrl", "TEXT");
        stringBuilder.append(" externUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[29] = "externMd5";
        c4924a.xDd.put("externMd5", "TEXT");
        stringBuilder.append(" externMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[30] = "activityid";
        c4924a.xDd.put("activityid", "TEXT");
        stringBuilder.append(" activityid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[31] = "tpurl";
        c4924a.xDd.put("tpurl", "TEXT");
        stringBuilder.append(" tpurl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[32] = "tpauthkey";
        c4924a.xDd.put("tpauthkey", "TEXT");
        stringBuilder.append(" tpauthkey TEXT");
        stringBuilder.append(", ");
        c4924a.columns[33] = "wxamMd5";
        c4924a.xDd.put("wxamMd5", "TEXT");
        stringBuilder.append(" wxamMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[34] = "attachedText";
        c4924a.xDd.put("attachedText", "TEXT");
        stringBuilder.append(" attachedText TEXT");
        stringBuilder.append(", ");
        c4924a.columns[35] = "captureStatus";
        c4924a.xDd.put("captureStatus", "INTEGER default '0' ");
        stringBuilder.append(" captureStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[36] = "attachedEmojiMD5";
        c4924a.xDd.put("attachedEmojiMD5", "BLOB default '' ");
        stringBuilder.append(" attachedEmojiMD5 BLOB default '' ");
        stringBuilder.append(", ");
        c4924a.columns[37] = "imitateMd5";
        c4924a.xDd.put("imitateMd5", "TEXT");
        stringBuilder.append(" imitateMd5 TEXT");
        stringBuilder.append(", ");
        c4924a.columns[38] = "captureUploadErrCode";
        c4924a.xDd.put("captureUploadErrCode", "INTEGER default '0' ");
        stringBuilder.append(" captureUploadErrCode INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[39] = "captureUploadCounter";
        c4924a.xDd.put("captureUploadCounter", "INTEGER default '0' ");
        stringBuilder.append(" captureUploadCounter INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[40] = "captureEnterTime";
        c4924a.xDd.put("captureEnterTime", "LONG");
        stringBuilder.append(" captureEnterTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[41] = "lensId";
        c4924a.xDd.put("lensId", "TEXT");
        stringBuilder.append(" lensId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[42] = "attachTextColor";
        c4924a.xDd.put("attachTextColor", "TEXT");
        stringBuilder.append(" attachTextColor TEXT");
        stringBuilder.append(", ");
        c4924a.columns[43] = "captureScene";
        c4924a.xDd.put("captureScene", "INTEGER");
        stringBuilder.append(" captureScene INTEGER");
        c4924a.columns[44] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62792);
    }

    public EmojiInfo() {
        AppMethodBeat.m2504i(62765);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            StringBuilder stringBuilder = new StringBuilder();
            C1720g.m3537RQ();
            this.ptQ = stringBuilder.append(C1720g.m3536RP().eJM).append("emoji/").toString();
        } else {
            this.ptQ = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().getAccPath() + "emoji/";
        }
        reset();
        AppMethodBeat.m2505o(62765);
    }

    public EmojiInfo(String str) {
        AppMethodBeat.m2504i(62766);
        this.ptQ = str;
        reset();
        AppMethodBeat.m2505o(62766);
    }

    public final void reset() {
        AppMethodBeat.m2504i(62767);
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
        this.field_captureStatus = C30302a.STATUS_SUCCESS.ordinal();
        this.field_captureUploadErrCode = C30301b.ERR_SUCCESS.ordinal();
        this.field_captureUploadCounter = 0;
        this.field_imitateMd5 = "";
        this.field_attachedEmojiMD5 = new byte[0];
        AppMethodBeat.m2505o(62767);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f A:{SYNTHETIC, Splitter:B:26:0x007f} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a7 A:{SYNTHETIC, Splitter:B:34:0x00a7} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: gZ */
    public final byte[] mo48536gZ(int i, int i2) {
        InputStream bJ;
        Throwable e;
        byte[] e2;
        AppMethodBeat.m2504i(62768);
        if (i < 0 || i2 < 0) {
            AppMethodBeat.m2505o(62768);
            return null;
        }
        if (this.field_catalog == yax || this.field_catalog == yaA || this.field_catalog == yaz) {
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiInfo", "get name %s", getName());
                bJ = EmojiInfo.m48210bJ(C4996ah.getContext(), getName());
            } catch (IOException e3) {
                e = e3;
                bJ = null;
                try {
                    C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e));
                    if (bJ != null) {
                    }
                    e2 = C5730e.m8632e(dve(), this.field_start, i2);
                    AppMethodBeat.m2505o(62768);
                    return e2;
                } catch (Throwable th) {
                    e = th;
                    if (bJ != null) {
                        try {
                            bJ.close();
                        } catch (IOException e4) {
                            C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e4));
                        }
                    }
                    AppMethodBeat.m2505o(62768);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                bJ = null;
                if (bJ != null) {
                }
                AppMethodBeat.m2505o(62768);
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
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e5));
                    }
                }
                AppMethodBeat.m2505o(62768);
                return e2;
            } catch (IOException th3) {
                e = th3;
                C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e));
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e42) {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e42));
                    }
                }
                e2 = C5730e.m8632e(dve(), this.field_start, i2);
                AppMethodBeat.m2505o(62768);
                return e2;
            }
        }
        e2 = C5730e.m8632e(dve(), this.field_start, i2);
        AppMethodBeat.m2505o(62768);
        return e2;
    }

    public final boolean duP() {
        AppMethodBeat.m2504i(62769);
        if (this.field_catalog == yax || this.field_catalog == EmojiGroupInfo.yas || this.field_catalog == yaA || this.field_catalog == yaz) {
            AppMethodBeat.m2505o(62769);
            return true;
        }
        String dve = dve();
        if (C5046bo.isNullOrNil(dve)) {
            AppMethodBeat.m2505o(62769);
            return false;
        }
        C5728b c5728b = new C5728b(dve);
        if (!c5728b.exists() || c5728b.length() <= 0) {
            AppMethodBeat.m2505o(62769);
            return false;
        }
        AppMethodBeat.m2505o(62769);
        return true;
    }

    public final void duQ() {
        AppMethodBeat.m2504i(62770);
        if (this.field_catalog == yax || this.field_catalog == yaA || this.field_catalog == yaz) {
            AppMethodBeat.m2505o(62770);
            return;
        }
        String dve = dve();
        if (!C5046bo.isNullOrNil(dve)) {
            C5728b c5728b = new C5728b(dve);
            if (c5728b.exists()) {
                c5728b.delete();
            }
        }
        AppMethodBeat.m2505o(62770);
    }

    public final boolean duR() {
        AppMethodBeat.m2504i(62771);
        if (this.field_catalog == yax || this.field_catalog == yaA || this.field_catalog == yaz) {
            AppMethodBeat.m2505o(62771);
            return true;
        }
        String dve = dve();
        if (C5046bo.isNullOrNil(dve)) {
            AppMethodBeat.m2505o(62771);
            return false;
        }
        boolean exists = new C5728b(dve).exists();
        AppMethodBeat.m2505o(62771);
        return exists;
    }

    /* renamed from: bJ */
    public static InputStream m48210bJ(Context context, String str) {
        InputStream inputStream = null;
        AppMethodBeat.m2504i(62772);
        if (context == null || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(62772);
        } else {
            try {
                C4990ab.m7411d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", str.split("\\.")[0]);
                inputStream = context.getResources().openRawResource(context.getResources().getIdentifier(r1, "drawable", context.getPackageName()));
                AppMethodBeat.m2505o(62772);
            } catch (Exception e) {
                C4990ab.m7421w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", e.getMessage());
                AppMethodBeat.m2505o(62772);
            }
        }
        return inputStream;
    }

    /* renamed from: hk */
    public final synchronized Bitmap mo48542hk(Context context) {
        Bitmap hl;
        AppMethodBeat.m2504i(62773);
        hl = mo48543hl(context);
        AppMethodBeat.m2505o(62773);
        return hl;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:115:0x0291=Splitter:B:115:0x0291, B:82:0x0156=Splitter:B:82:0x0156} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02cf A:{SYNTHETIC, Splitter:B:126:0x02cf} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b0 A:{SYNTHETIC, Splitter:B:118:0x02b0} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a6 A:{SYNTHETIC, Splitter:B:51:0x00a6} */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02b0 A:{SYNTHETIC, Splitter:B:118:0x02b0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hl */
    public final synchronized Bitmap mo48543hl(Context context) {
        InputStream bJ;
        Bitmap decodeStream;
        Throwable e;
        InputStream inputStream = null;
        synchronized (this) {
            AppMethodBeat.m2504i(62775);
            C1338a.fromDPToPix(context, 120);
            String name;
            if (this.field_catalog == yax || this.field_catalog == EmojiGroupInfo.yas || this.field_catalog == yaA || this.field_catalog == yaz) {
                try {
                    name = getName();
                    if (this.field_type == zYS) {
                        name = C5046bo.isNullOrNil(getContent()) ? getName() : getContent();
                    }
                    bJ = EmojiInfo.m48210bJ(context, name);
                    try {
                        decodeStream = C5056d.decodeStream(bJ);
                        if (bJ != null) {
                            try {
                                bJ.close();
                            } catch (IOException e2) {
                                C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e2));
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
                            C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e5));
                        }
                    }
                    AppMethodBeat.m2505o(62775);
                    throw e;
                }
            }
            try {
                C5728b c5728b;
                if (duU()) {
                    String str;
                    name = dve();
                    if (name == null) {
                        str = this.ptQ + this.field_groupId + "/" + mo20410Aq() + "_0";
                    } else {
                        str = name;
                    }
                    c5728b = new C5728b(str);
                } else {
                    c5728b = new C5728b(this.ptQ + mo20410Aq() + "_thumb");
                }
                if (c5728b.exists()) {
                    bJ = C5730e.m8638p(c5728b);
                    try {
                        decodeStream = C5056d.decodeStream(bJ);
                    } catch (FileNotFoundException e6) {
                        e = e6;
                        decodeStream = null;
                    } catch (Exception e7) {
                        e = e7;
                        decodeStream = null;
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e));
                        C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", e.getMessage());
                        if (bJ != null) {
                        }
                        AppMethodBeat.m2505o(62775);
                        return decodeStream;
                    }
                }
                if (!duU()) {
                    bJ = C5730e.openRead(this.ptQ + mo20410Aq());
                    decodeStream = C5056d.decodeStream(bJ);
                } else if (VERSION.SDK_INT < 19) {
                    bJ = C5730e.openRead(this.ptQ + this.field_groupId + "/" + mo20410Aq());
                    decodeStream = C5056d.decodeStream(bJ);
                } else {
                    bJ = null;
                    decodeStream = null;
                }
                try {
                    if (duU()) {
                        C4990ab.m7410d("MicroMsg.emoji.EmojiInfo", "cpan emojiinfo save cover.");
                        if (!new C5728b(this.ptQ + this.field_groupId + "/" + mo20410Aq() + "_cover").exists() && VERSION.SDK_INT < 19) {
                            C5056d.m7625a(decodeStream, 100, CompressFormat.PNG, this.ptQ + this.field_groupId + "/" + mo20410Aq() + "_cover", false);
                        }
                    } else {
                        C5056d.m7625a(decodeStream, 100, CompressFormat.PNG, this.ptQ + mo20410Aq() + "_thumb", false);
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                } catch (Exception e9) {
                    e = e9;
                    C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e));
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", e.getMessage());
                    if (bJ != null) {
                    }
                    AppMethodBeat.m2505o(62775);
                    return decodeStream;
                }
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e22) {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e22));
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
                C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e));
                C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", e.getMessage());
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e222) {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e222));
                    }
                }
                AppMethodBeat.m2505o(62775);
                return decodeStream;
            } catch (Throwable th2) {
                e = th2;
                bJ = null;
                if (bJ != null) {
                    try {
                        bJ.close();
                    } catch (IOException e52) {
                        C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e52));
                    }
                }
                AppMethodBeat.m2505o(62775);
                throw e;
            }
            AppMethodBeat.m2505o(62775);
        }
        return decodeStream;
        try {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e));
            if (bJ != null) {
                try {
                    bJ.close();
                    decodeStream = null;
                } catch (IOException e2222) {
                    C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e2222));
                    decodeStream = null;
                }
            } else {
                decodeStream = null;
            }
            AppMethodBeat.m2505o(62775);
            return decodeStream;
        } catch (Throwable th3) {
            e = th3;
            inputStream = bJ;
            if (inputStream != null) {
            }
            AppMethodBeat.m2505o(62775);
            throw e;
        }
        try {
            C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e));
            C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", e.getMessage());
            if (bJ != null) {
                try {
                    bJ.close();
                } catch (IOException e22222) {
                    C4990ab.m7413e("MicroMsg.emoji.EmojiInfo", "exception:%s", C5046bo.m7574l(e22222));
                }
            }
            AppMethodBeat.m2505o(62775);
            return decodeStream;
        } catch (Throwable th4) {
            e = th4;
            if (bJ != null) {
            }
            AppMethodBeat.m2505o(62775);
            throw e;
        }
    }

    /* renamed from: xy */
    public final boolean mo48552xy() {
        return this.field_catalog == yaA || this.field_catalog == yaz;
    }

    public final boolean duS() {
        return this.field_catalog == yax || this.field_catalog == yaA || this.field_catalog == yaz;
    }

    public final boolean duT() {
        AppMethodBeat.m2504i(62776);
        boolean equalsIgnoreCase = this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
        AppMethodBeat.m2505o(62776);
        return equalsIgnoreCase;
    }

    public final boolean isGif() {
        return this.field_type == zYS || this.field_type == zYX;
    }

    /* renamed from: Mw */
    public static boolean m48209Mw(int i) {
        return i == yaA || i == yaz;
    }

    public final boolean duV() {
        AppMethodBeat.m2504i(62778);
        if (C5046bo.isNullOrNil(this.field_wxamMd5)) {
            AppMethodBeat.m2505o(62778);
            return false;
        }
        AppMethodBeat.m2505o(62778);
        return true;
    }

    /* renamed from: vS */
    public final void mo48550vS(String str) {
        this.field_md5 = str;
    }

    /* renamed from: Aq */
    public final String mo20410Aq() {
        return this.field_md5 == null ? "" : this.field_md5;
    }

    public final boolean cVD() {
        AppMethodBeat.m2504i(62779);
        if (mo20410Aq().length() == 32) {
            AppMethodBeat.m2505o(62779);
            return true;
        }
        AppMethodBeat.m2505o(62779);
        return false;
    }

    public final String duW() {
        return this.field_svrid == null ? "" : this.field_svrid;
    }

    /* renamed from: Vp */
    public final void mo48509Vp(int i) {
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

    /* renamed from: a */
    public final void mo48510a(C30302a c30302a) {
        AppMethodBeat.m2504i(62780);
        this.field_captureStatus = c30302a.ordinal();
        AppMethodBeat.m2505o(62780);
    }

    public final C30302a duZ() {
        switch (this.field_captureStatus) {
            case 0:
                return C30302a.STATUS_SUCCESS;
            case 1:
                return C30302a.STATUS_MIXING;
            case 2:
                return C30302a.STATUS_MIX_FAIL;
            case 3:
                return C30302a.STATUS_UPLOADING;
            case 4:
                return C30302a.STATUS_UPLOAD_FAIL;
            default:
                return C30302a.STATUS_SUCCESS;
        }
    }

    public final int dva() {
        return this.field_captureUploadCounter;
    }

    public final void dvb() {
        this.field_captureUploadCounter++;
    }

    /* renamed from: a */
    public final void mo48511a(C30301b c30301b) {
        AppMethodBeat.m2504i(62781);
        this.field_captureUploadErrCode = c30301b.ordinal();
        AppMethodBeat.m2505o(62781);
    }

    public final C30301b dvc() {
        switch (this.field_captureUploadErrCode) {
            case 0:
                return C30301b.ERR_SUCCESS;
            case 1:
                return C30301b.ERR_NON_NETWORK;
            case 2:
                return C30301b.ERR_WIFI_NETWORK;
            case 3:
                return C30301b.ERR_MOBILE_NETWORK;
            case 4:
                return C30301b.ERR_NOT_COMPLETED;
            case 5:
                return C30301b.ERR_OVER_LIMIT;
            case 6:
                return C30301b.ERR_OTHERS;
            case 7:
                return C30301b.ERR_LOCAL_FILE;
            case 8:
                return C30301b.ERR_OVER_SIZE;
            case 9:
                return C30301b.ERR_SPAM;
            case 10:
                return C30301b.ERR_OVER_UPLOAD_TIME;
            default:
                return C30301b.ERR_OTHERS;
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
    /* renamed from: al */
    public final void mo48512al(ArrayList<String> arrayList) {
        ObjectOutputStream objectOutputStream;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(62782);
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Exception e2) {
                e = e2;
                objectOutputStream = null;
                try {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 failure, msg: " + e.getMessage());
                    if (objectOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(62782);
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(62782);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = null;
                if (objectOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                AppMethodBeat.m2505o(62782);
                throw th;
            }
            try {
                objectOutputStream.writeObject(arrayList);
                this.field_attachedEmojiMD5 = byteArrayOutputStream.toByteArray();
                try {
                    objectOutputStream.close();
                } catch (Exception e3) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 oos close failure, msg: " + e3.getMessage());
                }
                try {
                    byteArrayOutputStream.close();
                    AppMethodBeat.m2505o(62782);
                } catch (Exception e32) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 bos close failure, msg: " + e32.getMessage());
                    AppMethodBeat.m2505o(62782);
                }
            } catch (Exception e4) {
                e32 = e4;
                C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 failure, msg: " + e32.getMessage());
                if (objectOutputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                AppMethodBeat.m2505o(62782);
            }
        } catch (Exception e5) {
            e32 = e5;
            objectOutputStream = null;
            byteArrayOutputStream = null;
            C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 failure, msg: " + e32.getMessage());
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e322) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 oos close failure, msg: " + e322.getMessage());
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e3222) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 bos close failure, msg: " + e3222.getMessage());
                    AppMethodBeat.m2505o(62782);
                    return;
                }
            }
            AppMethodBeat.m2505o(62782);
        } catch (Throwable th4) {
            th = th4;
            objectOutputStream = null;
            byteArrayOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e6) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 oos close failure, msg: " + e6.getMessage());
                }
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (Exception e62) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "setAttachedEmojiMD5 bos close failure, msg: " + e62.getMessage());
                }
            }
            AppMethodBeat.m2505o(62782);
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
        AppMethodBeat.m2504i(62783);
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(this.field_attachedEmojiMD5);
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Exception e2) {
                e = e2;
                objectInputStream = null;
                try {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 failure, msg: " + e.getMessage());
                    if (byteArrayInputStream != null) {
                    }
                    if (objectInputStream != null) {
                    }
                    arrayList = null;
                    AppMethodBeat.m2505o(62783);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayInputStream != null) {
                    }
                    if (objectInputStream != null) {
                    }
                    AppMethodBeat.m2505o(62783);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e3) {
                        C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 bis close failure, msg: " + e3.getMessage());
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e32) {
                        C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 ois close failure, msg: " + e32.getMessage());
                    }
                }
                AppMethodBeat.m2505o(62783);
                throw th;
            }
            try {
                arrayList = (ArrayList) objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (Exception e322) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 bis close failure, msg: " + e322.getMessage());
                }
                try {
                    objectInputStream.close();
                } catch (Exception e3222) {
                    C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 ois close failure, msg: " + e3222.getMessage());
                }
            } catch (Exception e4) {
                e = e4;
                C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 failure, msg: " + e.getMessage());
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception e5) {
                        C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 bis close failure, msg: " + e5.getMessage());
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (Exception e52) {
                        C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 ois close failure, msg: " + e52.getMessage());
                        arrayList = null;
                    }
                }
                arrayList = null;
                AppMethodBeat.m2505o(62783);
                return arrayList;
            }
        } catch (Exception e6) {
            e52 = e6;
            objectInputStream = null;
            byteArrayInputStream = null;
            C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "getAttachedEmojiMD5 failure, msg: " + e52.getMessage());
            if (byteArrayInputStream != null) {
            }
            if (objectInputStream != null) {
            }
            arrayList = null;
            AppMethodBeat.m2505o(62783);
            return arrayList;
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            byteArrayInputStream = null;
            if (byteArrayInputStream != null) {
            }
            if (objectInputStream != null) {
            }
            AppMethodBeat.m2505o(62783);
            throw th;
        }
        AppMethodBeat.m2505o(62783);
        return arrayList;
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final String dve() {
        String str = null;
        AppMethodBeat.m2504i(62784);
        if (C5046bo.isNullOrNil(this.field_groupId) && C5046bo.isNullOrNil(this.field_md5)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
            AppMethodBeat.m2505o(62784);
        } else {
            if (!C5046bo.isNullOrNil(this.field_md5)) {
                if (C5046bo.isNullOrNil(this.field_groupId) || C5046bo.isEqual(this.field_groupId, "capture")) {
                    str = this.ptQ + this.field_md5;
                } else {
                    str = this.ptQ + this.field_groupId + "/" + this.field_md5;
                }
            }
            AppMethodBeat.m2505o(62784);
        }
        return str;
    }

    public final String dvf() {
        AppMethodBeat.m2504i(62785);
        String dve = dve();
        if (dve == null) {
            AppMethodBeat.m2505o(62785);
            return null;
        }
        dve = dve + "_cover";
        AppMethodBeat.m2505o(62785);
        return dve;
    }

    public static String dvg() {
        AppMethodBeat.m2504i(62786);
        String str = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().getAccPath() + "emoji/";
        AppMethodBeat.m2505o(62786);
        return str;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(62787);
        boolean cJ = mo48515cJ(obj);
        AppMethodBeat.m2505o(62787);
        return cJ;
    }

    /* renamed from: cJ */
    public final boolean mo48515cJ(Object obj) {
        AppMethodBeat.m2504i(62788);
        if (obj != null && (obj instanceof EmojiInfo) && ((EmojiInfo) obj).mo20410Aq().equalsIgnoreCase(this.field_md5)) {
            AppMethodBeat.m2505o(62788);
            return true;
        }
        AppMethodBeat.m2505o(62788);
        return false;
    }

    public String toString() {
        AppMethodBeat.m2504i(62789);
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
        AppMethodBeat.m2505o(62789);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(62790);
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
        AppMethodBeat.m2505o(62790);
    }

    protected EmojiInfo(Parcel parcel) {
        AppMethodBeat.m2504i(62791);
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
        AppMethodBeat.m2505o(62791);
    }

    /* renamed from: w */
    public final synchronized Bitmap mo20411w(Context context, int i) {
        Bitmap bitmap;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(62774);
            String name;
            if (this.field_catalog == EmojiGroupInfo.yas || this.field_catalog == yaA || this.field_catalog == yaz) {
                name = getName();
                if (C5046bo.isNullOrNil(name)) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiInfo", "name is null");
                    C4990ab.m7417i("MicroMsg.emoji.EmojiInfo", "emoji:%s", this);
                    bitmap = null;
                    AppMethodBeat.m2505o(62774);
                } else {
                    if (name.startsWith("jsb")) {
                        name = "jsb";
                    } else if (name.startsWith("dice")) {
                        name = "dice";
                    } else {
                        name = name.replaceAll(".png", "");
                    }
                    bitmap = C5056d.m7668v(context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", C4996ah.getPackageName())));
                    C4990ab.m7417i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                    AppMethodBeat.m2505o(62774);
                }
            } else if (this.field_catalog == EmojiGroupInfo.yar) {
                name = getName();
                if (C5046bo.isNullOrNil(name)) {
                    C4990ab.m7416i("MicroMsg.emoji.EmojiInfo", "name is null");
                } else {
                    name = (C5046bo.isNullOrNil(getContent()) ? getName() : getContent()).replaceAll(".png", "");
                }
                C4990ab.m7417i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", name);
                bitmap = C5056d.m7668v(context.getResources().getDrawable(context.getResources().getIdentifier(name, "drawable", C4996ah.getPackageName())));
                C4990ab.m7417i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", Integer.valueOf(this.field_catalog), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                AppMethodBeat.m2505o(62774);
            } else {
                name = dve() + "_cover";
                C4990ab.m7417i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", name, Boolean.valueOf(C5730e.m8628ct(name)));
                if (C5730e.m8628ct(name)) {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(name, options);
                    if (options.outHeight >= i || options.outWidth >= i) {
                        bitmap = C5056d.m7641ao(name, i, i);
                    } else {
                        bitmap = C5056d.m7641ao(name, options.outHeight, options.outWidth);
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
                    C4990ab.m7417i(str, str2, objArr);
                    AppMethodBeat.m2505o(62774);
                } else {
                    if (C5730e.m8628ct(dve())) {
                        byte[] l = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35656l(this);
                        if (l == null) {
                            C4990ab.m7412e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
                            bitmap = null;
                            AppMethodBeat.m2505o(62774);
                        } else {
                            C4990ab.m7417i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", Integer.valueOf(l.length));
                            if (C5063r.m7679bU(l)) {
                                bitmap = C34325i.m56266aW(l);
                            } else {
                                bitmap = C5056d.decodeByteArray(l, i, i);
                            }
                            if (bitmap != null) {
                                C4990ab.m7417i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", this, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                            }
                            AppMethodBeat.m2505o(62774);
                        }
                    } else {
                        C4990ab.m7421w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", dve(), Boolean.valueOf(C5730e.m8628ct(dve())));
                        C4990ab.m7417i("MicroMsg.emoji.EmojiInfo", "emoji:%s", this);
                        bitmap = null;
                        AppMethodBeat.m2505o(62774);
                    }
                }
            }
        }
        return bitmap;
    }

    public final boolean duU() {
        AppMethodBeat.m2504i(62777);
        if (!C5046bo.isNullOrNil(this.field_app_id) || C5046bo.isNullOrNil(this.field_groupId) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yas)) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yar)) || this.field_groupId.equals(String.valueOf(EmojiGroupInfo.yat)) || this.field_groupId.equals(String.valueOf(yau)) || this.field_groupId.equals("capture")) {
            AppMethodBeat.m2505o(62777);
            return false;
        }
        AppMethodBeat.m2505o(62777);
        return true;
    }
}
