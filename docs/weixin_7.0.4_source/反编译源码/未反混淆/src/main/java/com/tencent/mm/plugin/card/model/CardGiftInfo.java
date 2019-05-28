package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.agk;
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.protocal.protobuf.ap;
import com.tencent.mm.protocal.protobuf.aq;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo implements Parcelable {
    public static final Creator<CardGiftInfo> CREATOR = new Creator<CardGiftInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardGiftInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(87775);
            CardGiftInfo cardGiftInfo = new CardGiftInfo(parcel);
            AppMethodBeat.o(87775);
            return cardGiftInfo;
        }
    };
    public String cKE;
    public String color;
    public int kcA;
    public int kcB;
    public String kcC;
    public String kcD;
    public int kcE;
    public String kcF;
    public String kcG;
    public String kcH;
    public String kcI;
    public String kcJ;
    public String kcK;
    public String kcL;
    public String kcM;
    public String kcN;
    public LinkedList<AcceptedCardItem> kcO = new LinkedList();
    public LinkedList<AccepterItem> kcP = new LinkedList();
    public String kcQ;
    public int kcR;
    public String kcS;
    public String kcT;
    public String kcl;
    public String kcm;
    public String kcn;
    public String kco;
    public String kcp;
    public String kcq;
    public String kcr;
    public String kcs;
    public String kct;
    public String kcu;
    public String kcv;
    public String kcw;
    public String kcx;
    public boolean kcy;
    public int kcz;
    public String toUserName;

    public static class AcceptedCardItem implements Parcelable {
        public static final Creator<AcceptedCardItem> CREATOR = new Creator<AcceptedCardItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AcceptedCardItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(87776);
                AcceptedCardItem acceptedCardItem = new AcceptedCardItem(parcel, (byte) 0);
                AppMethodBeat.o(87776);
                return acceptedCardItem;
            }
        };
        public String kcU;
        public String kcV;

        /* synthetic */ AcceptedCardItem(Parcel parcel, byte b) {
            this(parcel);
        }

        static {
            AppMethodBeat.i(87779);
            AppMethodBeat.o(87779);
        }

        private AcceptedCardItem(Parcel parcel) {
            AppMethodBeat.i(87777);
            this.kcU = parcel.readString();
            this.kcV = parcel.readString();
            AppMethodBeat.o(87777);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(87778);
            parcel.writeString(this.kcU);
            parcel.writeString(this.kcV);
            AppMethodBeat.o(87778);
        }

        public int describeContents() {
            return 0;
        }
    }

    public static class AccepterItem implements Parcelable {
        public static final Creator<AccepterItem> CREATOR = new Creator<AccepterItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AccepterItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(87780);
                AccepterItem accepterItem = new AccepterItem(parcel, (byte) 0);
                AppMethodBeat.o(87780);
                return accepterItem;
            }
        };
        public String kcU;
        public String kcV;
        public String kcW;
        public String kcX;

        /* synthetic */ AccepterItem(Parcel parcel, byte b) {
            this(parcel);
        }

        static {
            AppMethodBeat.i(87783);
            AppMethodBeat.o(87783);
        }

        private AccepterItem(Parcel parcel) {
            AppMethodBeat.i(87781);
            this.kcU = parcel.readString();
            this.kcV = parcel.readString();
            this.kcW = parcel.readString();
            this.kcX = parcel.readString();
            AppMethodBeat.o(87781);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.i(87782);
            parcel.writeString(this.kcU);
            parcel.writeString(this.kcV);
            parcel.writeString(this.kcW);
            parcel.writeString(this.kcX);
            AppMethodBeat.o(87782);
        }

        public int describeContents() {
            return 0;
        }
    }

    public CardGiftInfo() {
        AppMethodBeat.i(87784);
        AppMethodBeat.o(87784);
    }

    protected CardGiftInfo(Parcel parcel) {
        AppMethodBeat.i(87785);
        this.toUserName = parcel.readString();
        this.cKE = parcel.readString();
        this.kcl = parcel.readString();
        this.kcm = parcel.readString();
        this.kcn = parcel.readString();
        this.kco = parcel.readString();
        this.kcp = parcel.readString();
        this.kcq = parcel.readString();
        this.kcr = parcel.readString();
        this.kcs = parcel.readString();
        this.kct = parcel.readString();
        this.kcu = parcel.readString();
        this.kcv = parcel.readString();
        this.kcw = parcel.readString();
        this.kcx = parcel.readString();
        this.color = parcel.readString();
        this.kcy = parcel.readByte() != (byte) 0;
        this.kcz = parcel.readInt();
        this.kcA = parcel.readInt();
        this.kcB = parcel.readInt();
        this.kcC = parcel.readString();
        this.kcD = parcel.readString();
        this.kcE = parcel.readInt();
        this.kcF = parcel.readString();
        this.kcG = parcel.readString();
        this.kcH = parcel.readString();
        this.kcI = parcel.readString();
        this.kcJ = parcel.readString();
        this.kcK = parcel.readString();
        this.kcL = parcel.readString();
        this.kcM = parcel.readString();
        this.kcN = parcel.readString();
        parcel.readTypedList(this.kcO, AcceptedCardItem.CREATOR);
        parcel.readTypedList(this.kcP, AccepterItem.CREATOR);
        this.kcQ = parcel.readString();
        this.kcR = parcel.readInt();
        this.kcS = parcel.readString();
        this.kcT = parcel.readString();
        AppMethodBeat.o(87785);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(87786);
        parcel.writeString(this.toUserName);
        parcel.writeString(this.cKE);
        parcel.writeString(this.kcl);
        parcel.writeString(this.kcm);
        parcel.writeString(this.kcn);
        parcel.writeString(this.kco);
        parcel.writeString(this.kcp);
        parcel.writeString(this.kcq);
        parcel.writeString(this.kcr);
        parcel.writeString(this.kcs);
        parcel.writeString(this.kct);
        parcel.writeString(this.kcu);
        parcel.writeString(this.kcv);
        parcel.writeString(this.kcw);
        parcel.writeString(this.kcx);
        parcel.writeString(this.color);
        parcel.writeByte(this.kcy ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.kcz);
        parcel.writeInt(this.kcA);
        parcel.writeInt(this.kcB);
        parcel.writeString(this.kcC);
        parcel.writeString(this.kcD);
        parcel.writeInt(this.kcE);
        parcel.writeString(this.kcF);
        parcel.writeString(this.kcG);
        parcel.writeString(this.kcH);
        parcel.writeString(this.kcI);
        parcel.writeString(this.kcJ);
        parcel.writeString(this.kcK);
        parcel.writeString(this.kcL);
        parcel.writeString(this.kcM);
        parcel.writeString(this.kcN);
        parcel.writeTypedList(this.kcO);
        parcel.writeTypedList(this.kcP);
        parcel.writeString(this.kcQ);
        parcel.writeInt(this.kcR);
        parcel.writeString(this.kcS);
        parcel.writeString(this.kcT);
        AppMethodBeat.o(87786);
    }

    static {
        AppMethodBeat.i(87790);
        AppMethodBeat.o(87790);
    }

    public String toString() {
        AppMethodBeat.i(87787);
        String str = "CardGiftInfo{toUserName='" + this.toUserName + '\'' + ", fromUserName='" + this.cKE + '\'' + ", fromUserImgUrl='" + this.kcl + '\'' + ", fromUserContent='" + this.kcm + '\'' + ", fromUserContentPicUrl='" + this.kcn + '\'' + ", fromUserContentVideoUrl='" + this.kco + '\'' + ", fromUserContentThumbPicUrl='" + this.kcp + '\'' + ", picAESKey='" + this.kcq + '\'' + ", videoAESKey='" + this.kcr + '\'' + ", thumbVideoAESKey='" + this.kcs + '\'' + ", cardBackgroundPicUrl='" + this.kct + '\'' + ", cardLogoLUrl='" + this.kcu + '\'' + ", cardTitle='" + this.kcv + '\'' + ", cardPrice='" + this.kcw + '\'' + ", footerWording='" + this.kcx + '\'' + ", color='" + this.color + '\'' + ", needJump=" + this.kcy + ", picDataLength=" + this.kcz + ", videoDataLength=" + this.kcA + ", thumbDataLength=" + this.kcB + ", descTitle='" + this.kcC + '\'' + ", descIconUrl='" + this.kcD + '\'' + ", descLayoutMode=" + this.kcE + ", giftingMediaTitle='" + this.kcF + '\'' + ", descriptionTitleColor='" + this.kcG + '\'' + ", cardTitleColor='" + this.kcH + '\'' + ", cardPriceTitleColor='" + this.kcI + '\'' + ", userCardId='" + this.kcJ + '\'' + ", operationTitle='" + this.kcK + '\'' + ", operationUrl='" + this.kcL + '\'' + ", cardTpId='" + this.kcM + '\'' + ", cardCode='" + this.kcN + '\'' + ", accepted_card_list_size='" + this.kcO.size() + '\'' + ", accepter_list_size='" + this.kcP.size() + '\'' + ", accepter_list_title='" + this.kcQ + '\'' + ", out_of_card='" + this.kcR + '\'' + ", operation_wxa_username='" + this.kcS + '\'' + ", operation_wxa_path='" + this.kcT + '\'' + '}';
        AppMethodBeat.o(87787);
        return str;
    }

    public static CardGiftInfo a(ao aoVar) {
        LinkedList linkedList;
        AppMethodBeat.i(87788);
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = aoVar.vBE;
        cardGiftInfo.cKE = aoVar.vBF;
        cardGiftInfo.kcl = aoVar.vBG;
        cardGiftInfo.kcm = aoVar.content;
        cardGiftInfo.kcn = aoVar.vBH;
        cardGiftInfo.kco = aoVar.vBI;
        cardGiftInfo.kcp = aoVar.vBJ;
        cardGiftInfo.kcq = aoVar.vBK;
        cardGiftInfo.kcs = aoVar.vBM;
        cardGiftInfo.kcr = aoVar.vBL;
        cardGiftInfo.kct = aoVar.vBN;
        cardGiftInfo.kcu = aoVar.vBO;
        cardGiftInfo.kcv = aoVar.kcU;
        cardGiftInfo.kcw = aoVar.kcV;
        cardGiftInfo.kcx = aoVar.vBP;
        cardGiftInfo.color = aoVar.color;
        cardGiftInfo.kcy = aoVar.vBQ;
        cardGiftInfo.kcz = aoVar.vBR;
        cardGiftInfo.kcA = aoVar.vBS;
        cardGiftInfo.kcB = aoVar.vBT;
        cardGiftInfo.kcC = aoVar.vBU;
        cardGiftInfo.kcD = aoVar.vBV;
        cardGiftInfo.kcE = aoVar.vBW;
        cardGiftInfo.kcF = aoVar.vBX;
        cardGiftInfo.kcG = aoVar.vBY;
        cardGiftInfo.kcH = aoVar.vBZ;
        cardGiftInfo.kcI = aoVar.vCa;
        cardGiftInfo.kcJ = aoVar.vCb;
        cardGiftInfo.kcK = aoVar.vCc;
        cardGiftInfo.kcL = aoVar.vCd;
        cardGiftInfo.kcM = aoVar.kbU;
        cardGiftInfo.kcN = aoVar.vCe;
        Iterator it = aoVar.kcO.iterator();
        while (it.hasNext()) {
            ap apVar = (ap) it.next();
            linkedList = cardGiftInfo.kcO;
            AcceptedCardItem acceptedCardItem = new AcceptedCardItem();
            acceptedCardItem.kcV = apVar.kcV;
            acceptedCardItem.kcU = apVar.kcU;
            linkedList.add(acceptedCardItem);
        }
        it = aoVar.kcP.iterator();
        while (it.hasNext()) {
            aq aqVar = (aq) it.next();
            linkedList = cardGiftInfo.kcP;
            AccepterItem accepterItem = new AccepterItem();
            accepterItem.kcV = aqVar.kcV;
            accepterItem.kcU = aqVar.kcU;
            accepterItem.kcX = aqVar.kcX;
            accepterItem.kcW = aqVar.kcW;
            linkedList.add(accepterItem);
        }
        cardGiftInfo.kcQ = aoVar.kcQ;
        cardGiftInfo.kcR = aoVar.kcR;
        cardGiftInfo.kcS = aoVar.kcS;
        cardGiftInfo.kcT = aoVar.kcT;
        AppMethodBeat.o(87788);
        return cardGiftInfo;
    }

    public static CardGiftInfo a(agk agk) {
        AppMethodBeat.i(87789);
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = agk.vBE;
        cardGiftInfo.cKE = agk.vBF;
        cardGiftInfo.kcl = agk.vBG;
        cardGiftInfo.kcm = agk.content;
        cardGiftInfo.kcn = agk.vBH;
        cardGiftInfo.kco = agk.vBI;
        cardGiftInfo.kcp = agk.vBJ;
        cardGiftInfo.kcq = agk.vBK;
        cardGiftInfo.kcs = agk.vBM;
        cardGiftInfo.kcr = agk.vBL;
        cardGiftInfo.kct = agk.vBN;
        cardGiftInfo.kcu = agk.vBO;
        cardGiftInfo.kcv = agk.kcU;
        cardGiftInfo.kcw = agk.kcV;
        cardGiftInfo.kcx = agk.vBP;
        cardGiftInfo.color = agk.color;
        cardGiftInfo.kcy = agk.vBQ;
        cardGiftInfo.kcz = agk.vBR;
        cardGiftInfo.kcA = agk.vBS;
        cardGiftInfo.kcB = agk.vBT;
        cardGiftInfo.kcC = agk.vBU;
        cardGiftInfo.kcD = agk.vBV;
        cardGiftInfo.kcE = agk.vBW;
        cardGiftInfo.kcF = agk.vBX;
        cardGiftInfo.kcG = agk.vBY;
        cardGiftInfo.kcH = agk.vBZ;
        cardGiftInfo.kcI = agk.vCa;
        cardGiftInfo.kcJ = agk.vCb;
        cardGiftInfo.kcK = agk.vCc;
        cardGiftInfo.kcL = agk.vCd;
        cardGiftInfo.kcM = agk.kbU;
        cardGiftInfo.kcN = agk.vCe;
        AppMethodBeat.o(87789);
        return cardGiftInfo;
    }
}
