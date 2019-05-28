package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.az;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;

public class EmojiGroupInfo extends az implements Parcelable {
    public static final Creator<EmojiGroupInfo> CREATOR = new Creator<EmojiGroupInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EmojiGroupInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(62720);
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo(parcel);
            AppMethodBeat.o(62720);
            return emojiGroupInfo;
        }
    };
    public static int TYPE_CUSTOM = 3;
    public static int TYPE_SYSTEM = 1;
    protected static a ccO;
    public static int yao = 2;
    public static int yap = 4;
    public static int yaq = 256;
    public static int yar = 17;
    public static int yas = 18;
    public static int yat = 81;
    public static int yau = 65;

    public final a Ag() {
        return ccO;
    }

    public final EmotionSummary duw() {
        AppMethodBeat.i(62721);
        EmotionSummary emotionSummary = new EmotionSummary();
        emotionSummary.ProductID = this.field_productID;
        emotionSummary.IconUrl = this.field_packIconUrl;
        emotionSummary.PackName = this.field_packName;
        emotionSummary.PackDesc = this.field_packDesc;
        emotionSummary.PackAuthInfo = this.field_packAuthInfo;
        emotionSummary.PackPrice = this.field_packPrice;
        emotionSummary.PackType = this.field_packType;
        emotionSummary.PackFlag = this.field_packFlag;
        emotionSummary.CoverUrl = this.field_packCoverUrl;
        emotionSummary.PackExpire = (int) this.field_packExpire;
        emotionSummary.PackCopyright = this.field_packCopyright;
        emotionSummary.Timestamp = (int) this.field_packTimeStamp;
        emotionSummary.PriceNum = this.field_packPrice;
        AppMethodBeat.o(62721);
        return emotionSummary;
    }

    public String toString() {
        AppMethodBeat.i(62722);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field_productID:").append(this.field_productID).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packIconUrl:").append(this.field_packIconUrl).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packGrayIconUrl:").append(this.field_packGrayIconUrl).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packCoverUrl:").append(this.field_packCoverUrl).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packName:").append(this.field_packName).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packDesc:").append(this.field_packDesc).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packAuthInfo:").append(this.field_packAuthInfo).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packPrice:").append(this.field_packPrice).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packType:").append(this.field_packType).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packFlag:").append(this.field_packFlag).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packExpire:").append(this.field_packExpire).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packTimeStamp:").append(this.field_packTimeStamp).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packCopyright:").append(this.field_packCopyright).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_type:").append(this.field_type).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_status:").append(this.field_status).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_sort:").append(this.field_sort).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_packStatus:").append(this.field_packStatus).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_recommand:").append(this.field_recommand).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_sync:").append(this.field_sync).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_idx:").append(this.field_idx).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_BigIconUrl:").append(this.field_BigIconUrl).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_MutiLanName:").append(this.field_MutiLanName).append(IOUtils.LINE_SEPARATOR_UNIX);
        stringBuilder.append("field_count:").append(this.field_count).append(IOUtils.LINE_SEPARATOR_UNIX);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(62722);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(62723);
        parcel.writeString(this.field_productID);
        parcel.writeString(this.field_packIconUrl);
        parcel.writeString(this.field_packGrayIconUrl);
        parcel.writeString(this.field_packCoverUrl);
        parcel.writeString(this.field_packName);
        parcel.writeString(this.field_packDesc);
        parcel.writeString(this.field_packAuthInfo);
        parcel.writeString(this.field_packPrice);
        parcel.writeInt(this.field_packType);
        parcel.writeInt(this.field_packFlag);
        parcel.writeLong(this.field_packExpire);
        parcel.writeLong(this.field_packTimeStamp);
        parcel.writeString(this.field_packCopyright);
        parcel.writeInt(this.field_type);
        parcel.writeInt(this.field_status);
        parcel.writeInt(this.field_sort);
        parcel.writeLong(this.field_lastUseTime);
        parcel.writeInt(this.field_packStatus);
        parcel.writeInt(this.field_flag);
        parcel.writeInt(this.field_recommand);
        parcel.writeInt(this.field_sync);
        parcel.writeInt(this.field_idx);
        parcel.writeString(this.field_BigIconUrl);
        parcel.writeString(this.field_MutiLanName);
        parcel.writeInt(this.field_recommandType);
        parcel.writeString(this.field_lang);
        parcel.writeString(this.field_recommandWord);
        parcel.writeInt(this.field_buttonType);
        parcel.writeInt(this.field_count);
        parcel.writeLong(this.xDa);
        AppMethodBeat.o(62723);
    }

    protected EmojiGroupInfo(Parcel parcel) {
        AppMethodBeat.i(62724);
        this.field_productID = parcel.readString();
        this.field_packIconUrl = parcel.readString();
        this.field_packGrayIconUrl = parcel.readString();
        this.field_packCoverUrl = parcel.readString();
        this.field_packName = parcel.readString();
        this.field_packDesc = parcel.readString();
        this.field_packAuthInfo = parcel.readString();
        this.field_packPrice = parcel.readString();
        this.field_packType = parcel.readInt();
        this.field_packFlag = parcel.readInt();
        this.field_packExpire = parcel.readLong();
        this.field_packTimeStamp = parcel.readLong();
        this.field_packCopyright = parcel.readString();
        this.field_type = parcel.readInt();
        this.field_status = parcel.readInt();
        this.field_sort = parcel.readInt();
        this.field_lastUseTime = parcel.readLong();
        this.field_packStatus = parcel.readInt();
        this.field_flag = parcel.readInt();
        this.field_recommand = parcel.readInt();
        this.field_sync = parcel.readInt();
        this.field_idx = parcel.readInt();
        this.field_BigIconUrl = parcel.readString();
        this.field_MutiLanName = parcel.readString();
        this.field_recommandType = parcel.readInt();
        this.field_lang = parcel.readString();
        this.field_recommandWord = parcel.readString();
        this.field_buttonType = parcel.readInt();
        this.field_count = parcel.readInt();
        this.xDa = parcel.readLong();
        AppMethodBeat.o(62724);
    }

    static {
        AppMethodBeat.i(62725);
        a aVar = new a();
        aVar.xDb = new Field[29];
        aVar.columns = new String[30];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productID";
        aVar.xDd.put("productID", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" productID TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.xDc = "productID";
        aVar.columns[1] = "packIconUrl";
        aVar.xDd.put("packIconUrl", "TEXT");
        stringBuilder.append(" packIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "packGrayIconUrl";
        aVar.xDd.put("packGrayIconUrl", "TEXT");
        stringBuilder.append(" packGrayIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "packCoverUrl";
        aVar.xDd.put("packCoverUrl", "TEXT");
        stringBuilder.append(" packCoverUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "packName";
        aVar.xDd.put("packName", "TEXT");
        stringBuilder.append(" packName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "packDesc";
        aVar.xDd.put("packDesc", "TEXT");
        stringBuilder.append(" packDesc TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "packAuthInfo";
        aVar.xDd.put("packAuthInfo", "TEXT");
        stringBuilder.append(" packAuthInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "packPrice";
        aVar.xDd.put("packPrice", "TEXT");
        stringBuilder.append(" packPrice TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "packType";
        aVar.xDd.put("packType", "INTEGER");
        stringBuilder.append(" packType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "packFlag";
        aVar.xDd.put("packFlag", "INTEGER");
        stringBuilder.append(" packFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "packExpire";
        aVar.xDd.put("packExpire", "LONG");
        stringBuilder.append(" packExpire LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "packTimeStamp";
        aVar.xDd.put("packTimeStamp", "LONG");
        stringBuilder.append(" packTimeStamp LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "packCopyright";
        aVar.xDd.put("packCopyright", "TEXT");
        stringBuilder.append(" packCopyright TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "sort";
        aVar.xDd.put("sort", "INTEGER default '1' ");
        stringBuilder.append(" sort INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "lastUseTime";
        aVar.xDd.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        aVar.columns[17] = "packStatus";
        aVar.xDd.put("packStatus", "INTEGER default '0' ");
        stringBuilder.append(" packStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "flag";
        aVar.xDd.put("flag", "INTEGER default '0' ");
        stringBuilder.append(" flag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "recommand";
        aVar.xDd.put("recommand", "INTEGER default '0' ");
        stringBuilder.append(" recommand INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "sync";
        aVar.xDd.put("sync", "INTEGER default '0' ");
        stringBuilder.append(" sync INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "idx";
        aVar.xDd.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[22] = "BigIconUrl";
        aVar.xDd.put("BigIconUrl", "TEXT");
        stringBuilder.append(" BigIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "MutiLanName";
        aVar.xDd.put("MutiLanName", "TEXT");
        stringBuilder.append(" MutiLanName TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "recommandType";
        aVar.xDd.put("recommandType", "INTEGER default '-1' ");
        stringBuilder.append(" recommandType INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[25] = "lang";
        aVar.xDd.put("lang", "TEXT");
        stringBuilder.append(" lang TEXT");
        stringBuilder.append(", ");
        aVar.columns[26] = "recommandWord";
        aVar.xDd.put("recommandWord", "TEXT");
        stringBuilder.append(" recommandWord TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "buttonType";
        aVar.xDd.put("buttonType", "INTEGER");
        stringBuilder.append(" buttonType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[28] = "count";
        aVar.xDd.put("count", "INTEGER");
        stringBuilder.append(" count INTEGER");
        aVar.columns[29] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(62725);
    }
}
