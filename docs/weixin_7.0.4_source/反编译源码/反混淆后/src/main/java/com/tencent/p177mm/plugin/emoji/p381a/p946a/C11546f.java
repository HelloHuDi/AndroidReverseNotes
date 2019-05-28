package com.tencent.p177mm.plugin.emoji.p381a.p946a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44221ar;

/* renamed from: com.tencent.mm.plugin.emoji.a.a.f */
public final class C11546f {
    /* renamed from: EV */
    public int f2905EV;
    public C11547a kTa;
    public EmotionSummary kTb;
    public EmotionBannerSet kTc;
    public int kTd;
    public String kTe;
    public boolean kTf;
    public boolean kTg = true;
    public boolean kTh = false;
    public int mStatus;

    /* renamed from: com.tencent.mm.plugin.emoji.a.a.f$a */
    public enum C11547a {
        summary,
        cellset;

        static {
            AppMethodBeat.m2505o(52805);
        }
    }

    public C11546f(EmotionSummary emotionSummary) {
        this.kTb = emotionSummary;
        this.kTa = C11547a.summary;
    }

    public C11546f(EmotionBannerSet emotionBannerSet) {
        this.kTc = emotionBannerSet;
        this.kTa = C11547a.cellset;
    }

    public final void setStatus(int i) {
        if (i == 7 && this.mStatus == 6 && this.kTg) {
            this.kTf = true;
        }
        this.mStatus = i;
    }

    /* renamed from: a */
    public final void mo23260a(boolean z, C44221ar c44221ar, boolean z2) {
        AppMethodBeat.m2504i(52806);
        EmotionSummary emotionSummary = this.kTb;
        if (emotionSummary == null) {
            AppMethodBeat.m2505o(52806);
        } else if (z2) {
            setStatus(7);
            AppMethodBeat.m2505o(52806);
        } else {
            boolean a = C27727e.m44036a(emotionSummary);
            boolean b = C27727e.m44037b(emotionSummary);
            boolean e = C27727e.m44041e(emotionSummary);
            boolean isEmpty = TextUtils.isEmpty(emotionSummary.PackPrice);
            if (!e || !b) {
                if (!a) {
                    if (!b && (z || !isEmpty)) {
                        this.kTd = 1;
                        if (z && c44221ar != null) {
                            switch (c44221ar.xXX) {
                                case 11:
                                    setStatus(11);
                                    break;
                                case 12:
                                    setStatus(4);
                                    break;
                                default:
                                    if (!(c44221ar.xXV == 7 || c44221ar.xXV == 6 || c44221ar.xXV == 3)) {
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
            if (!(!z || c44221ar == null || C5046bo.isNullOrNil(c44221ar.xYb))) {
                this.kTb.PackPrice = c44221ar.xYb;
                this.kTb.PriceNum = c44221ar.xYa;
                this.kTb.PriceType = c44221ar.xXZ;
            }
            AppMethodBeat.m2505o(52806);
        }
    }
}
