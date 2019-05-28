package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public class EmotionBannerSet extends a {
    public EmotionBannerImg BannerImg;
    public String Desc;
    public int ID;
    public String IconUrl;
    public String LocateUrl;
    public String ProductID;
    public String SecondUrl;
    public int SetType;
    public String TagUrl;
    public String Title;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62534);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.BannerImg == null) {
                bVar = new b("Not all required fields were included: BannerImg");
                AppMethodBeat.o(62534);
                throw bVar;
            }
            if (this.BannerImg != null) {
                aVar.iy(1, this.BannerImg.computeSize());
                this.BannerImg.writeFields(aVar);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.LocateUrl != null) {
                aVar.e(3, this.LocateUrl);
            }
            aVar.iz(4, this.ID);
            if (this.SecondUrl != null) {
                aVar.e(5, this.SecondUrl);
            }
            aVar.iz(6, this.SetType);
            if (this.IconUrl != null) {
                aVar.e(7, this.IconUrl);
            }
            if (this.Desc != null) {
                aVar.e(8, this.Desc);
            }
            if (this.ProductID != null) {
                aVar.e(9, this.ProductID);
            }
            if (this.TagUrl != null) {
                aVar.e(10, this.TagUrl);
            }
            AppMethodBeat.o(62534);
            return 0;
        } else if (i == 1) {
            if (this.BannerImg != null) {
                ix = e.a.a.a.ix(1, this.BannerImg.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.Title != null) {
                ix += e.a.a.b.b.a.f(2, this.Title);
            }
            if (this.LocateUrl != null) {
                ix += e.a.a.b.b.a.f(3, this.LocateUrl);
            }
            ix += e.a.a.b.b.a.bs(4, this.ID);
            if (this.SecondUrl != null) {
                ix += e.a.a.b.b.a.f(5, this.SecondUrl);
            }
            ix += e.a.a.b.b.a.bs(6, this.SetType);
            if (this.IconUrl != null) {
                ix += e.a.a.b.b.a.f(7, this.IconUrl);
            }
            if (this.Desc != null) {
                ix += e.a.a.b.b.a.f(8, this.Desc);
            }
            if (this.ProductID != null) {
                ix += e.a.a.b.b.a.f(9, this.ProductID);
            }
            if (this.TagUrl != null) {
                ix += e.a.a.b.b.a.f(10, this.TagUrl);
            }
            AppMethodBeat.o(62534);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BannerImg == null) {
                bVar = new b("Not all required fields were included: BannerImg");
                AppMethodBeat.o(62534);
                throw bVar;
            }
            AppMethodBeat.o(62534);
            return 0;
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionBannerSet emotionBannerSet = (EmotionBannerSet) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList Vh = aVar3.Vh(intValue);
                    int size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) Vh.get(intValue);
                        EmotionBannerImg emotionBannerImg = new EmotionBannerImg();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = emotionBannerImg.populateBuilderWithField(aVar4, emotionBannerImg, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionBannerSet.BannerImg = emotionBannerImg;
                    }
                    AppMethodBeat.o(62534);
                    return 0;
                case 2:
                    emotionBannerSet.Title = aVar3.BTU.readString();
                    AppMethodBeat.o(62534);
                    return 0;
                case 3:
                    emotionBannerSet.LocateUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62534);
                    return 0;
                case 4:
                    emotionBannerSet.ID = aVar3.BTU.vd();
                    AppMethodBeat.o(62534);
                    return 0;
                case 5:
                    emotionBannerSet.SecondUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62534);
                    return 0;
                case 6:
                    emotionBannerSet.SetType = aVar3.BTU.vd();
                    AppMethodBeat.o(62534);
                    return 0;
                case 7:
                    emotionBannerSet.IconUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62534);
                    return 0;
                case 8:
                    emotionBannerSet.Desc = aVar3.BTU.readString();
                    AppMethodBeat.o(62534);
                    return 0;
                case 9:
                    emotionBannerSet.ProductID = aVar3.BTU.readString();
                    AppMethodBeat.o(62534);
                    return 0;
                case 10:
                    emotionBannerSet.TagUrl = aVar3.BTU.readString();
                    AppMethodBeat.o(62534);
                    return 0;
                default:
                    AppMethodBeat.o(62534);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62534);
            return -1;
        }
    }
}
