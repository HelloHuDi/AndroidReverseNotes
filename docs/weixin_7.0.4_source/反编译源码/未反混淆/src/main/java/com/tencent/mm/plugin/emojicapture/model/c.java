package com.tencent.mm.plugin.emojicapture.model;

import a.f.b.j;
import a.f.b.k;
import a.k.u;
import a.l;
import a.y;
import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.manager.FeatureManager;
import java.util.Arrays;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants;", "", "()V", "Companion", "plugin-emojicapture_release"})
public final class c {
    private static final String TAG = TAG;
    private static boolean lhr = true;
    private static int lhs = 5;
    private static int lht = 640;
    private static float lhu = 42.666668f;
    private static int lhv = 320;
    public static final a lhw = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0004H\u0007J\u000e\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u0004J\u000e\u00108\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u001eJ\b\u0010;\u001a\u00020\u001eH\u0007J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001eH\u0007J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001eH\u0007J\b\u0010?\u001a\u00020\u001eH\u0007J\b\u0010@\u001a\u00020\u001eH\u0007J\b\u0010A\u001a\u00020\u001eH\u0007J\b\u0010B\u001a\u00020\u001eH\u0007J\b\u0010C\u001a\u00020DH\u0007J\b\u0010E\u001a\u00020DH\u0007J\b\u0010F\u001a\u000201H\u0007J\u0006\u0010G\u001a\u000201R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u000e\u0010\u001d\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eXD¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\u000e\u0010/\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006H"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
    public static final class a {

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        public static final class a extends k implements a.f.a.a<y> {
            public static final a lhx = new a();

            static {
                AppMethodBeat.i(2577);
                AppMethodBeat.o(2577);
            }

            a() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                d dVar;
                AppMethodBeat.i(2576);
                try {
                    if (a.bmJ()) {
                        a.bmH();
                        a.bmF();
                        FeatureManager.checkFeaturesReady();
                        FabbyManager.init();
                        a.bmI();
                    }
                } catch (Throwable th) {
                    ab.printErrStackTrace(c.TAG, th, "", new Object[0]);
                    a.bmG();
                    FeatureManager.checkFeaturesReady();
                    if (FabbyManager.sChooseGPU_Segment) {
                        dVar = d.lhz;
                        d.bno();
                    } else {
                        dVar = d.lhz;
                        d.bnp();
                    }
                }
                if (!FeatureManager.isSegmentationReady()) {
                    EmojiCaptureReporter.up(18);
                }
                if (!FabbyManager.getInstance().IsInitSuccess()) {
                    dVar = d.lhz;
                    d.bnr();
                }
                y yVar = y.AUy;
                AppMethodBeat.o(2576);
                return yVar;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static String bmO() {
            AppMethodBeat.i(2578);
            String str = b.Yb() + "capture_emoji/";
            e.tf(str);
            AppMethodBeat.o(2578);
            return str;
        }

        public static String ut(int i) {
            AppMethodBeat.i(2579);
            String str;
            if (i == 0) {
                str = "";
                AppMethodBeat.o(2579);
                return str;
            }
            a.f.b.y yVar = a.f.b.y.AVH;
            str = String.format("%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & i)}, 1));
            j.o(str, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(2579);
            return str;
        }

        public static int Ka(String str) {
            AppMethodBeat.i(2580);
            j.p(str, "stringColor");
            int parseColor;
            if (u.jb(str, "#")) {
                parseColor = Color.parseColor(str);
                AppMethodBeat.o(2580);
                return parseColor;
            }
            try {
                parseColor = Integer.parseInt(str, a.k.b.UW(16)) & -1;
            } catch (Exception e) {
                parseColor = 0;
            }
            AppMethodBeat.o(2580);
            return parseColor;
        }
    }

    static {
        AppMethodBeat.i(2581);
        AppMethodBeat.o(2581);
    }

    public static final float us(int i) {
        return ((float) i) * 0.06666667f;
    }
}
