package com.tencent.p177mm.plugin.emojicapture.model;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.manager.FeatureManager;
import java.util.Arrays;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p005f.p007b.C8001y;
import p000a.p051k.C17354b;
import p000a.p051k.C6163u;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants;", "", "()V", "Companion", "plugin-emojicapture_release"})
/* renamed from: com.tencent.mm.plugin.emojicapture.model.c */
public final class C34006c {
    private static final String TAG = TAG;
    private static boolean lhr = true;
    private static int lhs = 5;
    private static int lht = 640;
    private static float lhu = 42.666668f;
    private static int lhv = 320;
    public static final C11617a lhw = new C11617a();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\u0004H\u0007J\u000e\u00108\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u0004J\u000e\u00108\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u001eJ\b\u0010;\u001a\u00020\u001eH\u0007J\u0010\u0010<\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001eH\u0007J\u0010\u0010>\u001a\u00020\u001e2\u0006\u0010=\u001a\u00020\u001eH\u0007J\b\u0010?\u001a\u00020\u001eH\u0007J\b\u0010@\u001a\u00020\u001eH\u0007J\b\u0010A\u001a\u00020\u001eH\u0007J\b\u0010B\u001a\u00020\u001eH\u0007J\b\u0010C\u001a\u00020DH\u0007J\b\u0010E\u001a\u00020DH\u0007J\b\u0010F\u001a\u000201H\u0007J\u0006\u0010G\u001a\u000201R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u000e\u0010\u001d\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u001eXD¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\u000e\u0010/\u001a\u00020\u001eXT¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u000e\u00105\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006H"}, dWq = {"Lcom/tencent/mm/plugin/emojicapture/model/EmojiCaptureConstants$Companion;", "", "()V", "CHIN", "", "DefaultEmojiVideoFrameDuration", "DefaultFilterIndex", "EYE", "EmojiCornerPercent", "", "EmojiMinRecordTime", "EmojiPreviewHeight", "EmojiPreviewSize", "getEmojiPreviewSize", "()I", "setEmojiPreviewSize", "(I)V", "EmojiPreviewWidth", "EmojiPtSegmentInputSize", "EmojiRoundCornerRadius", "getEmojiRoundCornerRadius", "()F", "setEmojiRoundCornerRadius", "(F)V", "EmojiVideoSpeedupRate", "FACEV", "FinalEmojiSize", "getFinalEmojiSize", "setFinalEmojiSize", "FontPath", "", "MaxAttachedEmoji", "NOSE", "NonSpeedUpFrameRate", "RecordFrameDelayMs", "RecordVideoBitRate", "SHAPE", "SKIN", "SpeedUpFrameDropFpsLimit", "SpeedUpFrameRate", "TAG", "TempFileDir", "TempGif", "TempThumb", "captureMaxDuration", "getCaptureMaxDuration", "setCaptureMaxDuration", "debugBeautyParaSpName", "isSupportHevc", "", "()Z", "setSupportHevc", "(Z)V", "segBackgroundStorkeWidth", "calcRoundCornerRadius", "size", "formatColor", "intColor", "stringColor", "getExportPath", "getFontAssetsPath", "fontName", "getFontDataPath", "getTempGifPath", "getTempRoot", "getTempThumbPath", "getTempVideoPath", "removeTempFiles", "", "setup", "useFreetype", "useNewFont", "plugin-emojicapture_release"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.c$a */
    public static final class C11617a {

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.model.c$a$a */
        public static final class C11616a extends C25053k implements C31214a<C37091y> {
            public static final C11616a lhx = new C11616a();

            static {
                AppMethodBeat.m2504i(2577);
                AppMethodBeat.m2505o(2577);
            }

            C11616a() {
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                C34007d c34007d;
                AppMethodBeat.m2504i(2576);
                try {
                    if (C2958a.bmJ()) {
                        C2958a.bmH();
                        C2958a.bmF();
                        FeatureManager.checkFeaturesReady();
                        FabbyManager.init();
                        C2958a.bmI();
                    }
                } catch (Throwable th) {
                    C4990ab.printErrStackTrace(C34006c.TAG, th, "", new Object[0]);
                    C2958a.bmG();
                    FeatureManager.checkFeaturesReady();
                    if (FabbyManager.sChooseGPU_Segment) {
                        c34007d = C34007d.lhz;
                        C34007d.bno();
                    } else {
                        c34007d = C34007d.lhz;
                        C34007d.bnp();
                    }
                }
                if (!FeatureManager.isSegmentationReady()) {
                    EmojiCaptureReporter.m66038up(18);
                }
                if (!FabbyManager.getInstance().IsInitSuccess()) {
                    c34007d = C34007d.lhz;
                    C34007d.bnr();
                }
                C37091y c37091y = C37091y.AUy;
                AppMethodBeat.m2505o(2576);
                return c37091y;
            }
        }

        private C11617a() {
        }

        public /* synthetic */ C11617a(byte b) {
            this();
        }

        public static String bmO() {
            AppMethodBeat.m2504i(2578);
            String str = C2933b.m5221Yb() + "capture_emoji/";
            C5730e.m8643tf(str);
            AppMethodBeat.m2505o(2578);
            return str;
        }

        /* renamed from: ut */
        public static String m19437ut(int i) {
            AppMethodBeat.m2504i(2579);
            String str;
            if (i == 0) {
                str = "";
                AppMethodBeat.m2505o(2579);
                return str;
            }
            C8001y c8001y = C8001y.AVH;
            str = String.format("%06X", Arrays.copyOf(new Object[]{Integer.valueOf(16777215 & i)}, 1));
            C25052j.m39375o(str, "java.lang.String.format(format, *args)");
            AppMethodBeat.m2505o(2579);
            return str;
        }

        /* renamed from: Ka */
        public static int m19436Ka(String str) {
            AppMethodBeat.m2504i(2580);
            C25052j.m39376p(str, "stringColor");
            int parseColor;
            if (C6163u.m9839jb(str, "#")) {
                parseColor = Color.parseColor(str);
                AppMethodBeat.m2505o(2580);
                return parseColor;
            }
            try {
                parseColor = Integer.parseInt(str, C17354b.m26870UW(16)) & -1;
            } catch (Exception e) {
                parseColor = 0;
            }
            AppMethodBeat.m2505o(2580);
            return parseColor;
        }
    }

    static {
        AppMethodBeat.m2504i(2581);
        AppMethodBeat.m2505o(2581);
    }

    /* renamed from: us */
    public static final float m55705us(int i) {
        return ((float) i) * 0.06666667f;
    }
}
