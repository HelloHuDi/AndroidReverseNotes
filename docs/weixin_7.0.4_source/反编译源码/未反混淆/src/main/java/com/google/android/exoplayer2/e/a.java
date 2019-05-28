package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

@TargetApi(16)
public final class a {
    public final boolean aQR;
    public final boolean bdX;
    public final boolean bdY;
    public final CodecCapabilities bdZ;
    public final String mimeType;
    public final String name;

    public static a a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        AppMethodBeat.i(95230);
        a aVar = new a(str, str2, codecCapabilities, z, z2);
        AppMethodBeat.o(95230);
        return aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Missing block: B:27:0x0059, code skipped:
            if (r0 != false) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    a(String str, String str2, CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(95231);
        this.name = (String) com.google.android.exoplayer2.i.a.checkNotNull(str);
        this.mimeType = str2;
        this.bdZ = codecCapabilities;
        if (!(z || codecCapabilities == null)) {
            if (v.SDK_INT < 19 || !codecCapabilities.isFeatureSupported("adaptive-playback")) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                z3 = true;
                this.bdX = z3;
                if (codecCapabilities != null) {
                    if (v.SDK_INT < 21 || !codecCapabilities.isFeatureSupported("tunneled-playback")) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        z3 = true;
                        this.aQR = z3;
                        if (!z2) {
                            if (codecCapabilities != null) {
                                if (v.SDK_INT < 21 || !codecCapabilities.isFeatureSupported("secure-playback")) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                            }
                            this.bdY = z4;
                            AppMethodBeat.o(95231);
                        }
                        z4 = true;
                        this.bdY = z4;
                        AppMethodBeat.o(95231);
                    }
                }
                z3 = false;
                this.aQR = z3;
                if (z2) {
                }
                z4 = true;
                this.bdY = z4;
                AppMethodBeat.o(95231);
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
        AppMethodBeat.o(95231);
    }

    public final CodecProfileLevel[] rD() {
        return (this.bdZ == null || this.bdZ.profileLevels == null) ? new CodecProfileLevel[0] : this.bdZ.profileLevels;
    }

    @TargetApi(21)
    public final boolean a(int i, int i2, double d) {
        AppMethodBeat.i(95232);
        if (this.bdZ == null) {
            ax("sizeAndRate.caps");
            AppMethodBeat.o(95232);
            return false;
        }
        VideoCapabilities videoCapabilities = this.bdZ.getVideoCapabilities();
        if (videoCapabilities == null) {
            ax("sizeAndRate.vCaps");
            AppMethodBeat.o(95232);
            return false;
        }
        if (!a(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !a(videoCapabilities, i2, i, d)) {
                ax("sizeAndRate.support, " + i + VideoMaterialUtil.CRAZYFACE_X + i2 + VideoMaterialUtil.CRAZYFACE_X + d);
                AppMethodBeat.o(95232);
                return false;
            }
            new StringBuilder("AssumedSupport [").append("sizeAndRate.rotated, " + i + VideoMaterialUtil.CRAZYFACE_X + i2 + VideoMaterialUtil.CRAZYFACE_X + d).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(v.brM).append("]");
        }
        AppMethodBeat.o(95232);
        return true;
    }

    public final void ax(String str) {
        AppMethodBeat.i(95233);
        new StringBuilder("NoSupport [").append(str).append("] [").append(this.name).append(", ").append(this.mimeType).append("] [").append(v.brM).append("]");
        AppMethodBeat.o(95233);
    }

    @TargetApi(21)
    private static boolean a(VideoCapabilities videoCapabilities, int i, int i2, double d) {
        AppMethodBeat.i(95234);
        boolean isSizeSupported;
        if (d == -1.0d || d <= 0.0d) {
            isSizeSupported = videoCapabilities.isSizeSupported(i, i2);
            AppMethodBeat.o(95234);
            return isSizeSupported;
        }
        isSizeSupported = videoCapabilities.areSizeAndRateSupported(i, i2, d);
        AppMethodBeat.o(95234);
        return isSizeSupported;
    }
}
