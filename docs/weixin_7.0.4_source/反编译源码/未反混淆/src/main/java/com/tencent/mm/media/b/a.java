package com.tencent.mm.media.b;

import a.f.b.j;
import a.l;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;

@l(dWo = {1, 1, 13}, dWp = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/media/config/BaseCodecConfig;", "", "()V", "MIME_TYPE", "", "getMIME_TYPE", "()Ljava/lang/String;", "setMIME_TYPE", "(Ljava/lang/String;)V", "isRecognizedFormat", "", "colorFormat", "", "isRecognizedProfile", "profile", "selectCodec", "Landroid/media/MediaCodecInfo;", "mimeType", "selectColorFormat", "codecInfo", "trySetBitRateMode", "", "mediaFormat", "Landroid/media/MediaFormat;", "trySetProfile", "Companion", "plugin-mediaeditor_release"})
public class a {
    static final String TAG = TAG;
    public static final a eTg = new a();
    String MIME_TYPE = "video/avc";

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/media/config/BaseCodecConfig$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(12847);
        AppMethodBeat.o(12847);
    }

    public final void a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat) {
        AppMethodBeat.i(12846);
        j.p(mediaCodecInfo, "codecInfo");
        j.p(mediaFormat, "mediaFormat");
        if (d.iW(23)) {
            try {
                CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(this.MIME_TYPE);
                if (capabilitiesForType != null) {
                    CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                    if (codecProfileLevelArr != null) {
                        CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                        codecProfileLevel.level = 0;
                        codecProfileLevel.profile = 0;
                        for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                            Object obj;
                            int i = codecProfileLevel2.profile;
                            int i2 = codecProfileLevel2.level;
                            ab.i(TAG, "profile: %s, level: %s", Integer.valueOf(i), Integer.valueOf(i2));
                            switch (i) {
                                case 1:
                                case 2:
                                case 8:
                                    obj = 1;
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                            if (obj != null && i >= codecProfileLevel.profile && i2 >= codecProfileLevel.level) {
                                codecProfileLevel.profile = i;
                                codecProfileLevel.level = i2;
                            }
                        }
                        ab.i(TAG, "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                            mediaFormat.setInteger(Scopes.PROFILE, codecProfileLevel.profile);
                            mediaFormat.setInteger("level", 256);
                            AppMethodBeat.o(12846);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                ab.e(TAG, "trySetProfile error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(12846);
    }
}
