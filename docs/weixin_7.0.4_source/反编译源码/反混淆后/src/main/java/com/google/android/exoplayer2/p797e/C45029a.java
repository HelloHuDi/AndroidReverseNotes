package com.google.android.exoplayer2.p797e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

@TargetApi(16)
/* renamed from: com.google.android.exoplayer2.e.a */
public final class C45029a {
    public final boolean aQR;
    public final boolean bdX;
    public final boolean bdY;
    public final CodecCapabilities bdZ;
    public final String mimeType;
    public final String name;

    /* renamed from: a */
    public static C45029a m82520a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        AppMethodBeat.m2504i(95230);
        C45029a c45029a = new C45029a(str, str2, codecCapabilities, z, z2);
        AppMethodBeat.m2505o(95230);
        return c45029a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Missing block: B:27:0x0059, code skipped:
            if (r0 != false) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    C45029a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.m2504i(95231);
        this.name = (String) C45039a.checkNotNull(str);
        this.mimeType = str2;
        this.bdZ = codecCapabilities;
        if (!(z || codecCapabilities == null)) {
            if (C17675v.SDK_INT < 19 || !codecCapabilities.isFeatureSupported("adaptive-playback")) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                z3 = true;
                this.bdX = z3;
                if (codecCapabilities != null) {
                    if (C17675v.SDK_INT < 21 || !codecCapabilities.isFeatureSupported("tunneled-playback")) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        z3 = true;
                        this.aQR = z3;
                        if (!z2) {
                            if (codecCapabilities != null) {
                                if (C17675v.SDK_INT < 21 || !codecCapabilities.isFeatureSupported("secure-playback")) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                            }
                            this.bdY = z4;
                            AppMethodBeat.m2505o(95231);
                        }
                        z4 = true;
                        this.bdY = z4;
                        AppMethodBeat.m2505o(95231);
                    }
                }
                z3 = false;
                this.aQR = z3;
                if (z2) {
                }
                z4 = true;
                this.bdY = z4;
                AppMethodBeat.m2505o(95231);
            }
        }
        z3 = false;
        this.bdX = z3;
        if (codecCapabilities != null) {
        }
        z3 = false;
        this.aQR = z3;
        if (z2) {
        }
        z4 = true;
        this.bdY = z4;
        AppMethodBeat.m2505o(95231);
    }

    /* renamed from: rD */
    public final CodecProfileLevel[] mo72546rD() {
        return (this.bdZ == null || this.bdZ.profileLevels == null) ? new CodecProfileLevel[0] : this.bdZ.profileLevels;
    }

    @TargetApi(21)
    /* renamed from: a */
    public final boolean mo72544a(int i, int i2, double d) {
        AppMethodBeat.m2504i(95232);
        if (this.bdZ == null) {
            mo72545ax("sizeAndRate.caps");
            AppMethodBeat.m2505o(95232);
            return false;
        }
        VideoCapabilities videoCapabilities = this.bdZ.getVideoCapabilities();
        if (videoCapabilities == null) {
            mo72545ax("sizeAndRate.vCaps");
            AppMethodBeat.m2505o(95232);
            return false;
        }
        if (!C45029a.m82521a(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !C45029a.m82521a(videoCapabilities, i2, i, d)) {
                mo72545ax("sizeAndRate.support, " + i + VideoMaterialUtil.CRAZYFACE_X + i2 + VideoMaterialUtil.CRAZYFACE_X + d);
                AppMethodBeat.m2505o(95232);
                return false;
            }
            new StringBuilder("AssumedSupport [").append("sizeAndRate.rotated, " + i + VideoMaterialUtil.CRAZYFACE_X + i2 + VideoMaterialUtil.CRAZYFACE_X + d).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(C17675v.brM).append("]");
        }
        AppMethodBeat.m2505o(95232);
        return true;
    }

    /* renamed from: ax */
    public final void mo72545ax(String str) {
        AppMethodBeat.m2504i(95233);
        new StringBuilder("NoSupport [").append(str).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(C17675v.brM).append("]");
        AppMethodBeat.m2505o(95233);
    }

    @TargetApi(21)
    /* renamed from: a */
    private static boolean m82521a(VideoCapabilities videoCapabilities, int i, int i2, double d) {
        AppMethodBeat.m2504i(95234);
        boolean isSizeSupported;
        if (d == -1.0d || d <= 0.0d) {
            isSizeSupported = videoCapabilities.isSizeSupported(i, i2);
            AppMethodBeat.m2505o(95234);
            return isSizeSupported;
        }
        isSizeSupported = videoCapabilities.areSizeAndRateSupported(i, i2, d);
        AppMethodBeat.m2505o(95234);
        return isSizeSupported;
    }
}
