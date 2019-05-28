package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.a;
import e.a.a.b;
import java.util.LinkedList;

public class EmotionBanner extends a {
    public EmotionBannerImg BannerImg;
    public EmotionSummary BannerSummary;

    public final int op(int i, Object... objArr) {
        AppMethodBeat.i(62532);
        b bVar;
        int ix;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.BannerSummary == null) {
                bVar = new b("Not all required fields were included: BannerSummary");
                AppMethodBeat.o(62532);
                throw bVar;
            } else if (this.BannerImg == null) {
                bVar = new b("Not all required fields were included: BannerImg");
                AppMethodBeat.o(62532);
                throw bVar;
            } else {
                if (this.BannerSummary != null) {
                    aVar.iy(1, this.BannerSummary.computeSize());
                    this.BannerSummary.writeFields(aVar);
                }
                if (this.BannerImg != null) {
                    aVar.iy(2, this.BannerImg.computeSize());
                    this.BannerImg.writeFields(aVar);
                }
                AppMethodBeat.o(62532);
                return 0;
            }
        } else if (i == 1) {
            if (this.BannerSummary != null) {
                ix = e.a.a.a.ix(1, this.BannerSummary.computeSize()) + 0;
            } else {
                ix = 0;
            }
            if (this.BannerImg != null) {
                ix += e.a.a.a.ix(2, this.BannerImg.computeSize());
            }
            AppMethodBeat.o(62532);
            return ix;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (ix = a.getNextFieldNumber(aVar2); ix > 0; ix = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, ix)) {
                    aVar2.ems();
                }
            }
            if (this.BannerSummary == null) {
                bVar = new b("Not all required fields were included: BannerSummary");
                AppMethodBeat.o(62532);
                throw bVar;
            } else if (this.BannerImg == null) {
                bVar = new b("Not all required fields were included: BannerImg");
                AppMethodBeat.o(62532);
                throw bVar;
            } else {
                AppMethodBeat.o(62532);
                return 0;
            }
        } else if (i == 3) {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            EmotionBanner emotionBanner = (EmotionBanner) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList Vh;
            int size;
            byte[] bArr;
            e.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionSummary emotionSummary = new EmotionSummary();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionSummary.populateBuilderWithField(aVar4, emotionSummary, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionBanner.BannerSummary = emotionSummary;
                    }
                    AppMethodBeat.o(62532);
                    return 0;
                case 2:
                    Vh = aVar3.Vh(intValue);
                    size = Vh.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) Vh.get(intValue);
                        EmotionBannerImg emotionBannerImg = new EmotionBannerImg();
                        aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = emotionBannerImg.populateBuilderWithField(aVar4, emotionBannerImg, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionBanner.BannerImg = emotionBannerImg;
                    }
                    AppMethodBeat.o(62532);
                    return 0;
                default:
                    AppMethodBeat.o(62532);
                    return -1;
            }
        } else {
            AppMethodBeat.o(62532);
            return -1;
        }
    }
}
