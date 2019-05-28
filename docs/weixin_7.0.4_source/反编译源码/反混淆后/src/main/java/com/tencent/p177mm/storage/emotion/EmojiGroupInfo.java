package com.tencent.p177mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C42105az;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.storage.emotion.EmojiGroupInfo */
public class EmojiGroupInfo extends C42105az implements Parcelable {
    public static final Creator<EmojiGroupInfo> CREATOR = new C154361();
    public static int TYPE_CUSTOM = 3;
    public static int TYPE_SYSTEM = 1;
    protected static C4924a ccO;
    public static int yao = 2;
    public static int yap = 4;
    public static int yaq = 256;
    public static int yar = 17;
    public static int yas = 18;
    public static int yat = 81;
    public static int yau = 65;

    /* renamed from: com.tencent.mm.storage.emotion.EmojiGroupInfo$1 */
    static class C154361 implements Creator<EmojiGroupInfo> {
        C154361() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EmojiGroupInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(62720);
            EmojiGroupInfo emojiGroupInfo = new EmojiGroupInfo(parcel);
            AppMethodBeat.m2505o(62720);
            return emojiGroupInfo;
        }
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final EmotionSummary duw() {
        AppMethodBeat.m2504i(62721);
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
        AppMethodBeat.m2505o(62721);
        return emotionSummary;
    }

    public String toString() {
        AppMethodBeat.m2504i(62722);
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
        AppMethodBeat.m2505o(62722);
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(62723);
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
        AppMethodBeat.m2505o(62723);
    }

    protected EmojiGroupInfo(Parcel parcel) {
        AppMethodBeat.m2504i(62724);
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
        AppMethodBeat.m2505o(62724);
    }

    static {
        AppMethodBeat.m2504i(62725);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[29];
        c4924a.columns = new String[30];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "productID";
        c4924a.xDd.put("productID", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" productID TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        c4924a.xDc = "productID";
        c4924a.columns[1] = "packIconUrl";
        c4924a.xDd.put("packIconUrl", "TEXT");
        stringBuilder.append(" packIconUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "packGrayIconUrl";
        c4924a.xDd.put("packGrayIconUrl", "TEXT");
        stringBuilder.append(" packGrayIconUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "packCoverUrl";
        c4924a.xDd.put("packCoverUrl", "TEXT");
        stringBuilder.append(" packCoverUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "packName";
        c4924a.xDd.put("packName", "TEXT");
        stringBuilder.append(" packName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "packDesc";
        c4924a.xDd.put("packDesc", "TEXT");
        stringBuilder.append(" packDesc TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "packAuthInfo";
        c4924a.xDd.put("packAuthInfo", "TEXT");
        stringBuilder.append(" packAuthInfo TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "packPrice";
        c4924a.xDd.put("packPrice", "TEXT");
        stringBuilder.append(" packPrice TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "packType";
        c4924a.xDd.put("packType", "INTEGER");
        stringBuilder.append(" packType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[9] = "packFlag";
        c4924a.xDd.put("packFlag", "INTEGER");
        stringBuilder.append(" packFlag INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[10] = "packExpire";
        c4924a.xDd.put("packExpire", "LONG");
        stringBuilder.append(" packExpire LONG");
        stringBuilder.append(", ");
        c4924a.columns[11] = "packTimeStamp";
        c4924a.xDd.put("packTimeStamp", "LONG");
        stringBuilder.append(" packTimeStamp LONG");
        stringBuilder.append(", ");
        c4924a.columns[12] = "packCopyright";
        c4924a.xDd.put("packCopyright", "TEXT");
        stringBuilder.append(" packCopyright TEXT");
        stringBuilder.append(", ");
        c4924a.columns[13] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[14] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[15] = "sort";
        c4924a.xDd.put("sort", "INTEGER default '1' ");
        stringBuilder.append(" sort INTEGER default '1' ");
        stringBuilder.append(", ");
        c4924a.columns[16] = "lastUseTime";
        c4924a.xDd.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        c4924a.columns[17] = "packStatus";
        c4924a.xDd.put("packStatus", "INTEGER default '0' ");
        stringBuilder.append(" packStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[18] = "flag";
        c4924a.xDd.put("flag", "INTEGER default '0' ");
        stringBuilder.append(" flag INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[19] = "recommand";
        c4924a.xDd.put("recommand", "INTEGER default '0' ");
        stringBuilder.append(" recommand INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[20] = "sync";
        c4924a.xDd.put("sync", "INTEGER default '0' ");
        stringBuilder.append(" sync INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[21] = "idx";
        c4924a.xDd.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        c4924a.columns[22] = "BigIconUrl";
        c4924a.xDd.put("BigIconUrl", "TEXT");
        stringBuilder.append(" BigIconUrl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[23] = "MutiLanName";
        c4924a.xDd.put("MutiLanName", "TEXT");
        stringBuilder.append(" MutiLanName TEXT");
        stringBuilder.append(", ");
        c4924a.columns[24] = "recommandType";
        c4924a.xDd.put("recommandType", "INTEGER default '-1' ");
        stringBuilder.append(" recommandType INTEGER default '-1' ");
        stringBuilder.append(", ");
        c4924a.columns[25] = "lang";
        c4924a.xDd.put("lang", "TEXT");
        stringBuilder.append(" lang TEXT");
        stringBuilder.append(", ");
        c4924a.columns[26] = "recommandWord";
        c4924a.xDd.put("recommandWord", "TEXT");
        stringBuilder.append(" recommandWord TEXT");
        stringBuilder.append(", ");
        c4924a.columns[27] = "buttonType";
        c4924a.xDd.put("buttonType", "INTEGER");
        stringBuilder.append(" buttonType INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[28] = "count";
        c4924a.xDd.put("count", "INTEGER");
        stringBuilder.append(" count INTEGER");
        c4924a.columns[29] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(62725);
    }
}
