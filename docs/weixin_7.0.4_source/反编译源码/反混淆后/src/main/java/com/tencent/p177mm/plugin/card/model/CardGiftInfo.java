package com.tencent.p177mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.C15317ao;
import com.tencent.p177mm.protocal.protobuf.C35902aq;
import com.tencent.p177mm.protocal.protobuf.C7250ap;
import com.tencent.p177mm.protocal.protobuf.agk;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.card.model.CardGiftInfo */
public class CardGiftInfo implements Parcelable {
    public static final Creator<CardGiftInfo> CREATOR = new C112811();
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

    /* renamed from: com.tencent.mm.plugin.card.model.CardGiftInfo$1 */
    static class C112811 implements Creator<CardGiftInfo> {
        C112811() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardGiftInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(87775);
            CardGiftInfo cardGiftInfo = new CardGiftInfo(parcel);
            AppMethodBeat.m2505o(87775);
            return cardGiftInfo;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.CardGiftInfo$AcceptedCardItem */
    public static class AcceptedCardItem implements Parcelable {
        public static final Creator<AcceptedCardItem> CREATOR = new C27561();
        public String kcU;
        public String kcV;

        /* renamed from: com.tencent.mm.plugin.card.model.CardGiftInfo$AcceptedCardItem$1 */
        static class C27561 implements Creator<AcceptedCardItem> {
            C27561() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AcceptedCardItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(87776);
                AcceptedCardItem acceptedCardItem = new AcceptedCardItem(parcel, (byte) 0);
                AppMethodBeat.m2505o(87776);
                return acceptedCardItem;
            }
        }

        /* synthetic */ AcceptedCardItem(Parcel parcel, byte b) {
            this(parcel);
        }

        static {
            AppMethodBeat.m2504i(87779);
            AppMethodBeat.m2505o(87779);
        }

        private AcceptedCardItem(Parcel parcel) {
            AppMethodBeat.m2504i(87777);
            this.kcU = parcel.readString();
            this.kcV = parcel.readString();
            AppMethodBeat.m2505o(87777);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(87778);
            parcel.writeString(this.kcU);
            parcel.writeString(this.kcV);
            AppMethodBeat.m2505o(87778);
        }

        public int describeContents() {
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.card.model.CardGiftInfo$AccepterItem */
    public static class AccepterItem implements Parcelable {
        public static final Creator<AccepterItem> CREATOR = new C27571();
        public String kcU;
        public String kcV;
        public String kcW;
        public String kcX;

        /* renamed from: com.tencent.mm.plugin.card.model.CardGiftInfo$AccepterItem$1 */
        static class C27571 implements Creator<AccepterItem> {
            C27571() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AccepterItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(87780);
                AccepterItem accepterItem = new AccepterItem(parcel, (byte) 0);
                AppMethodBeat.m2505o(87780);
                return accepterItem;
            }
        }

        /* synthetic */ AccepterItem(Parcel parcel, byte b) {
            this(parcel);
        }

        static {
            AppMethodBeat.m2504i(87783);
            AppMethodBeat.m2505o(87783);
        }

        private AccepterItem(Parcel parcel) {
            AppMethodBeat.m2504i(87781);
            this.kcU = parcel.readString();
            this.kcV = parcel.readString();
            this.kcW = parcel.readString();
            this.kcX = parcel.readString();
            AppMethodBeat.m2505o(87781);
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(87782);
            parcel.writeString(this.kcU);
            parcel.writeString(this.kcV);
            parcel.writeString(this.kcW);
            parcel.writeString(this.kcX);
            AppMethodBeat.m2505o(87782);
        }

        public int describeContents() {
            return 0;
        }
    }

    public CardGiftInfo() {
        AppMethodBeat.m2504i(87784);
        AppMethodBeat.m2505o(87784);
    }

    protected CardGiftInfo(Parcel parcel) {
        AppMethodBeat.m2504i(87785);
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
        AppMethodBeat.m2505o(87785);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(87786);
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
        AppMethodBeat.m2505o(87786);
    }

    static {
        AppMethodBeat.m2504i(87790);
        AppMethodBeat.m2505o(87790);
    }

    public String toString() {
        AppMethodBeat.m2504i(87787);
        String str = "CardGiftInfo{toUserName='" + this.toUserName + '\'' + ", fromUserName='" + this.cKE + '\'' + ", fromUserImgUrl='" + this.kcl + '\'' + ", fromUserContent='" + this.kcm + '\'' + ", fromUserContentPicUrl='" + this.kcn + '\'' + ", fromUserContentVideoUrl='" + this.kco + '\'' + ", fromUserContentThumbPicUrl='" + this.kcp + '\'' + ", picAESKey='" + this.kcq + '\'' + ", videoAESKey='" + this.kcr + '\'' + ", thumbVideoAESKey='" + this.kcs + '\'' + ", cardBackgroundPicUrl='" + this.kct + '\'' + ", cardLogoLUrl='" + this.kcu + '\'' + ", cardTitle='" + this.kcv + '\'' + ", cardPrice='" + this.kcw + '\'' + ", footerWording='" + this.kcx + '\'' + ", color='" + this.color + '\'' + ", needJump=" + this.kcy + ", picDataLength=" + this.kcz + ", videoDataLength=" + this.kcA + ", thumbDataLength=" + this.kcB + ", descTitle='" + this.kcC + '\'' + ", descIconUrl='" + this.kcD + '\'' + ", descLayoutMode=" + this.kcE + ", giftingMediaTitle='" + this.kcF + '\'' + ", descriptionTitleColor='" + this.kcG + '\'' + ", cardTitleColor='" + this.kcH + '\'' + ", cardPriceTitleColor='" + this.kcI + '\'' + ", userCardId='" + this.kcJ + '\'' + ", operationTitle='" + this.kcK + '\'' + ", operationUrl='" + this.kcL + '\'' + ", cardTpId='" + this.kcM + '\'' + ", cardCode='" + this.kcN + '\'' + ", accepted_card_list_size='" + this.kcO.size() + '\'' + ", accepter_list_size='" + this.kcP.size() + '\'' + ", accepter_list_title='" + this.kcQ + '\'' + ", out_of_card='" + this.kcR + '\'' + ", operation_wxa_username='" + this.kcS + '\'' + ", operation_wxa_path='" + this.kcT + '\'' + '}';
        AppMethodBeat.m2505o(87787);
        return str;
    }

    /* renamed from: a */
    public static CardGiftInfo m84652a(C15317ao c15317ao) {
        LinkedList linkedList;
        AppMethodBeat.m2504i(87788);
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = c15317ao.vBE;
        cardGiftInfo.cKE = c15317ao.vBF;
        cardGiftInfo.kcl = c15317ao.vBG;
        cardGiftInfo.kcm = c15317ao.content;
        cardGiftInfo.kcn = c15317ao.vBH;
        cardGiftInfo.kco = c15317ao.vBI;
        cardGiftInfo.kcp = c15317ao.vBJ;
        cardGiftInfo.kcq = c15317ao.vBK;
        cardGiftInfo.kcs = c15317ao.vBM;
        cardGiftInfo.kcr = c15317ao.vBL;
        cardGiftInfo.kct = c15317ao.vBN;
        cardGiftInfo.kcu = c15317ao.vBO;
        cardGiftInfo.kcv = c15317ao.kcU;
        cardGiftInfo.kcw = c15317ao.kcV;
        cardGiftInfo.kcx = c15317ao.vBP;
        cardGiftInfo.color = c15317ao.color;
        cardGiftInfo.kcy = c15317ao.vBQ;
        cardGiftInfo.kcz = c15317ao.vBR;
        cardGiftInfo.kcA = c15317ao.vBS;
        cardGiftInfo.kcB = c15317ao.vBT;
        cardGiftInfo.kcC = c15317ao.vBU;
        cardGiftInfo.kcD = c15317ao.vBV;
        cardGiftInfo.kcE = c15317ao.vBW;
        cardGiftInfo.kcF = c15317ao.vBX;
        cardGiftInfo.kcG = c15317ao.vBY;
        cardGiftInfo.kcH = c15317ao.vBZ;
        cardGiftInfo.kcI = c15317ao.vCa;
        cardGiftInfo.kcJ = c15317ao.vCb;
        cardGiftInfo.kcK = c15317ao.vCc;
        cardGiftInfo.kcL = c15317ao.vCd;
        cardGiftInfo.kcM = c15317ao.kbU;
        cardGiftInfo.kcN = c15317ao.vCe;
        Iterator it = c15317ao.kcO.iterator();
        while (it.hasNext()) {
            C7250ap c7250ap = (C7250ap) it.next();
            linkedList = cardGiftInfo.kcO;
            AcceptedCardItem acceptedCardItem = new AcceptedCardItem();
            acceptedCardItem.kcV = c7250ap.kcV;
            acceptedCardItem.kcU = c7250ap.kcU;
            linkedList.add(acceptedCardItem);
        }
        it = c15317ao.kcP.iterator();
        while (it.hasNext()) {
            C35902aq c35902aq = (C35902aq) it.next();
            linkedList = cardGiftInfo.kcP;
            AccepterItem accepterItem = new AccepterItem();
            accepterItem.kcV = c35902aq.kcV;
            accepterItem.kcU = c35902aq.kcU;
            accepterItem.kcX = c35902aq.kcX;
            accepterItem.kcW = c35902aq.kcW;
            linkedList.add(accepterItem);
        }
        cardGiftInfo.kcQ = c15317ao.kcQ;
        cardGiftInfo.kcR = c15317ao.kcR;
        cardGiftInfo.kcS = c15317ao.kcS;
        cardGiftInfo.kcT = c15317ao.kcT;
        AppMethodBeat.m2505o(87788);
        return cardGiftInfo;
    }

    /* renamed from: a */
    public static CardGiftInfo m84651a(agk agk) {
        AppMethodBeat.m2504i(87789);
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
        AppMethodBeat.m2505o(87789);
        return cardGiftInfo;
    }
}
