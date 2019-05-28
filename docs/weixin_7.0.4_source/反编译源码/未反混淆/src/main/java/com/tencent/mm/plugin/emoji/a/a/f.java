package com.tencent.mm.plugin.emoji.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ar;

public final class f {
    public int EV;
    public a kTa;
    public EmotionSummary kTb;
    public EmotionBannerSet kTc;
    public int kTd;
    public String kTe;
    public boolean kTf;
    public boolean kTg = true;
    public boolean kTh = false;
    public int mStatus;

    public enum a {
        summary,
        cellset;

        static {
            AppMethodBeat.o(52805);
        }
    }

    public f(EmotionSummary emotionSummary) {
        this.kTb = emotionSummary;
        this.kTa = a.summary;
    }

    public f(EmotionBannerSet emotionBannerSet) {
        this.kTc = emotionBannerSet;
        this.kTa = a.cellset;
    }

    public final void setStatus(int i) {
        if (i == 7 && this.mStatus == 6 && this.kTg) {
            this.kTf = true;
        }
        this.mStatus = i;
    }

    public final void a(boolean z, ar arVar, boolean z2) {
        AppMethodBeat.i(52806);
        EmotionSummary emotionSummary = this.kTb;
        if (emotionSummary == null) {
            AppMethodBeat.o(52806);
        } else if (z2) {
            setStatus(7);
            AppMethodBeat.o(52806);
        } else {
            boolean a = e.a(emotionSummary);
            boolean b = e.b(emotionSummary);
            boolean e = e.e(emotionSummary);
            boolean isEmpty = TextUtils.isEmpty(emotionSummary.PackPrice);
            if (!e || !b) {
                if (!a) {
                    if (!b && (z || !isEmpty)) {
                        this.kTd = 1;
                        if (z && arVar != null) {
                            switch (arVar.xXX) {
                                case 11:
                                    setStatus(11);
                                    break;
                                case 12:
                                    setStatus(4);
                                    break;
                                default:
                                    if (!(arVar.xXV == 7 || arVar.xXV == 6 || arVar.xXV == 3)) {
                                        setStatus(10);
                                        break;
                                    }
                            }
                        } else if (z) {
                            setStatus(11);
                        } else {
                            setStatus(4);
                        }
                    } else {
                        setStatus(3);
                        this.kTd = 0;
                    }
                } else {
                    setStatus(3);
                    if (b || (!z && isEmpty)) {
                        this.kTd = 0;
                    } else {
                        this.kTd = 1;
                    }
                }
            } else {
                setStatus(8);
            }
            if (!(!z || arVar == null || bo.isNullOrNil(arVar.xYb))) {
                this.kTb.PackPrice = arVar.xYb;
                this.kTb.PriceNum = arVar.xYa;
                this.kTb.PriceType = arVar.xXZ;
            }
            AppMethodBeat.o(52806);
        }
    }
}
