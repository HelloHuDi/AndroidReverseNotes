package com.tencent.p177mm.hardcoder;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1611c.C1610a;
import com.tencent.p177mm.hardcoder.C1618e.C1617a;
import com.tencent.p177mm.hardcoder.C1627j.C1626a;
import com.tencent.p177mm.hardcoder.HardCoderJNI.AnrCallback;
import com.tencent.p177mm.hardcoder.HardCoderJNI.HCPerfManagerThread;
import com.tencent.p177mm.hardcoder.HardCoderJNI.SceneReportCallback;
import com.tencent.p177mm.hardcoder.HardCoderJNI.SystemEventCallback;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.hardcoder.WXHardCoderJNI */
public class WXHardCoderJNI extends C1625i {
    public static final Map<Integer, Integer> APP_SCENE_ID_MAP = new HashMap();
    public static final boolean HC_ENABLE_FOR_TEST = false;
    public static final String KEY_HC_BEGIN_TIME_HOUR = "KEY_HC_BEGIN_TIME_HOUR";
    public static final String KEY_HC_BEGIN_TIME_MIN = "KEY_HC_BEGIN_TIME_MIN";
    public static final String KEY_HC_BG_ENABLE = "KEY_HC_BG_ENABLE";
    public static final String KEY_HC_DEBUG = "KEY_HC_DEBUG";
    public static final String KEY_HC_ENABLE = "KEY_HC_ENABLE";
    public static final String KEY_HC_END_TIME_HOUR = "KEY_HC_END_TIME_HOUR";
    public static final String KEY_HC_END_TIME_MIN = "KEY_HC_END_TIME_MIN";
    public static final String KEY_HC_KV_FT = "KEY_HC_KV_FT";
    public static final String KEY_HC_KV_PER = "KEY_HC_KV_PER";
    public static final String KEY_HC_RETRY_INTERVAL = "KEY_HC_RETRY_INTERVAL";
    public static final String KEY_HC_TIMEOUT_MARGIN = "KEY_HC_TIMEOUT_MARGIN";
    public static final String KEY_HC_TIME_LIMIT = "KEY_HC_TIME_LIMIT";
    public static final String KEY_HC_UIN_HASH = "KEY_HC_UIN_HASH";
    public static final Map<Integer, Integer> SCENE_ID_MAP = new HashMap();
    public static final String SETTING_SP_FILE = "hardcoder_setting";
    public static final String SETTING_UI_ACTION = "com.tencent.mm.action.HARDCODER_SETTING";
    public static final boolean SETTING_UI_ENABLE = false;
    private static final String TAG = "MicroMsg.WXHardCoderJNI";
    public static HashMap<Long, String> flagKeyMap = new HashMap();
    public static boolean foreground = false;
    private static C1626a hardCoderReporterInfo = null;
    public static int hcBeginTimeHour = 8;
    public static int hcBeginTimeMin = 0;
    public static boolean hcBgEnable = true;
    public static int hcEndTimeHour = 23;
    public static int hcEndTimeMin = 0;
    public static boolean hcKVFtReport = sHCREPORT;
    public static boolean hcKVPerReport = false;
    public static int hcRetryInterval = 30;
    public static boolean hcTimeLimit = false;
    public static int hcTimeoutMargin = 0;
    public static int hcUinHash = 0;
    private static boolean needMapAPPScene = false;
    private static Method sGetStringPropsMethod = null;
    public static final int sHCBEGINHOUR = 8;
    public static final int sHCBEGINMIN = 0;
    public static final boolean sHCBGENABLE = true;
    public static final boolean sHCENABLE = true;
    public static final int sHCENDHOUR = 23;
    public static final int sHCENDMIN = 0;
    public static boolean sHCREPORT = false;
    public static final boolean sHCTIMELIMIT = false;
    public static final int sHCUINHASH = 0;
    public static final int sRETRYINTERVAL = 30;
    private static volatile Class<?> sSystemPropertiesClazz = null;
    public static final int sTIMEOUTMARGIN = 0;
    private static SceneReportCallback sceneReportCallback = new C65863();
    private static C1610a wxHardCoderLog = new C65841();

    /* renamed from: com.tencent.mm.hardcoder.WXHardCoderJNI$1 */
    static class C65841 implements C1610a {
        C65841() {
        }

        /* renamed from: i */
        public final void mo5065i(String str, String str2) {
            AppMethodBeat.m2504i(93118);
            C4990ab.m7416i(str, str2);
            AppMethodBeat.m2505o(93118);
        }

        /* renamed from: d */
        public final void mo5063d(String str, String str2) {
            AppMethodBeat.m2504i(93119);
            C4990ab.m7410d(str, str2);
            AppMethodBeat.m2505o(93119);
        }

        /* renamed from: e */
        public final void mo5064e(String str, String str2) {
            AppMethodBeat.m2504i(93120);
            C4990ab.m7412e(str, str2);
            AppMethodBeat.m2505o(93120);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(93121);
            C4990ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.m2505o(93121);
        }
    }

    /* renamed from: com.tencent.mm.hardcoder.WXHardCoderJNI$2 */
    static class C65852 implements HCPerfManagerThread {
        C65852() {
        }

        public final Thread newThread(Runnable runnable, String str, int i) {
            AppMethodBeat.m2504i(93122);
            Thread a = C7305d.m12285a(runnable, str, i);
            AppMethodBeat.m2505o(93122);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.hardcoder.WXHardCoderJNI$3 */
    static class C65863 implements SceneReportCallback {
        C65863() {
        }

        public final void sceneReport(int i, long j) {
            AppMethodBeat.m2504i(93123);
            if (WXHardCoderJNI.needMapAPPScene) {
                AppMethodBeat.m2505o(93123);
                return;
            }
            Integer num = (Integer) WXHardCoderJNI.SCENE_ID_MAP.get(Integer.valueOf(i));
            if (num == null) {
                AppMethodBeat.m2505o(93123);
                return;
            }
            WXHardCoderJNI.access$100(new C6590l(num.intValue()));
            AppMethodBeat.m2505o(93123);
        }
    }

    static /* synthetic */ void access$100(C1627j c1627j) {
        AppMethodBeat.m2504i(93145);
        WXHardCoderJNI.reportInfo(c1627j);
        AppMethodBeat.m2505o(93145);
    }

    static {
        AppMethodBeat.m2504i(93146);
        WXHardCoderJNI.initSceneAndFlagMap();
        WXHardCoderJNI.reloadSPConfig(RELOAD_SCENE_INIT);
        AppMethodBeat.m2505o(93146);
    }

    public static boolean isCheckEnv() {
        AppMethodBeat.m2504i(93124);
        boolean isCheckEnv = HardCoderJNI.isCheckEnv();
        AppMethodBeat.m2505o(93124);
        return isCheckEnv;
    }

    public static boolean getDebug() {
        AppMethodBeat.m2504i(93125);
        boolean isHcDebug = HardCoderJNI.isHcDebug();
        AppMethodBeat.m2505o(93125);
        return isHcDebug;
    }

    public static boolean getEnable() {
        AppMethodBeat.m2504i(93126);
        boolean isHcEnable = HardCoderJNI.isHcEnable();
        AppMethodBeat.m2505o(93126);
        return isHcEnable;
    }

    public static void setHcEnable(boolean z) {
        AppMethodBeat.m2504i(93127);
        HardCoderJNI.setHcEnable(z);
        AppMethodBeat.m2505o(93127);
    }

    public static void setDebug(boolean z) {
        AppMethodBeat.m2504i(93128);
        HardCoderJNI.setHcDebug(z);
        AppMethodBeat.m2505o(93128);
    }

    public static int terminateApp(int i, long j) {
        AppMethodBeat.m2504i(93129);
        int terminateApp = HardCoderJNI.terminateApp(i, j);
        AppMethodBeat.m2505o(93129);
        return terminateApp;
    }

    public static void setRetryConnectInterval(int i) {
        AppMethodBeat.m2504i(93130);
        HardCoderJNI.setRetryConnectInterval(i);
        AppMethodBeat.m2505o(93130);
    }

    public static int isRunning() {
        AppMethodBeat.m2504i(93131);
        int isRunning = HardCoderJNI.isRunning();
        AppMethodBeat.m2505o(93131);
        return isRunning;
    }

    public static int startPerformance(boolean z, int i, int i2, int i3, int i4, int i5, int i6, long j, String str) {
        AppMethodBeat.m2504i(93132);
        if (!z) {
            AppMethodBeat.m2505o(93132);
            return -3;
        } else if (hcBgEnable || foreground) {
            int intValue;
            int startPerformance;
            if (needMapAPPScene) {
                Integer num = (Integer) APP_SCENE_ID_MAP.get(Integer.valueOf(i6));
                if (num != null) {
                    intValue = num.intValue();
                    startPerformance = HardCoderJNI.startPerformance(i, i2, i3, i4, i5 + hcTimeoutMargin, intValue, j, Process.myTid(), str);
                    AppMethodBeat.m2505o(93132);
                    return startPerformance;
                }
            }
            intValue = i6;
            startPerformance = HardCoderJNI.startPerformance(i, i2, i3, i4, i5 + hcTimeoutMargin, intValue, j, Process.myTid(), str);
            AppMethodBeat.m2505o(93132);
            return startPerformance;
        } else {
            AppMethodBeat.m2505o(93132);
            return -4;
        }
    }

    public static int stopPerformance(boolean z, int i) {
        AppMethodBeat.m2504i(93133);
        if (z) {
            int stopPerformance = HardCoderJNI.stopPerformance(i);
            AppMethodBeat.m2505o(93133);
            return stopPerformance;
        }
        AppMethodBeat.m2505o(93133);
        return -3;
    }

    private WXHardCoderJNI() {
    }

    public static void reloadSPConfig(int i) {
        AppMethodBeat.m2504i(93134);
        boolean checkHardCoderEnv = WXHardCoderJNI.checkHardCoderEnv();
        HardCoderJNI.setCheckEnv(checkHardCoderEnv);
        if (checkHardCoderEnv) {
            WXHardCoderJNI.setDebug(false);
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(SETTING_SP_FILE, 0);
            HardCoderJNI.setHcEnable(sharedPreferences.getBoolean(KEY_HC_ENABLE, true));
            hcBgEnable = sharedPreferences.getBoolean(KEY_HC_BG_ENABLE, true);
            hcUinHash = sharedPreferences.getInt(KEY_HC_UIN_HASH, 0);
            HardCoderJNI.setHcDebug(sharedPreferences.getBoolean(KEY_HC_DEBUG, false));
            C4990ab.m7417i(TAG, "reloadSPConfig scene:%d, hcDebug:%b, hcEnable:%b, hcUinHash:%d, checkEnv:%b, stack[%s]", Integer.valueOf(i), Boolean.valueOf(HardCoderJNI.isHcDebug()), Boolean.valueOf(HardCoderJNI.isHcEnable()), Integer.valueOf(hcUinHash), Boolean.valueOf(HardCoderJNI.isCheckEnv()), C5046bo.dpG());
            hcRetryInterval = sharedPreferences.getInt(KEY_HC_RETRY_INTERVAL, 30);
            hcKVPerReport = sharedPreferences.getInt(KEY_HC_KV_PER, 0) < hcUinHash;
            if (sharedPreferences.getInt(KEY_HC_KV_FT, 0) < hcUinHash) {
                checkHardCoderEnv = true;
            } else {
                checkHardCoderEnv = false;
            }
            hcKVFtReport = checkHardCoderEnv;
            hcTimeoutMargin = sharedPreferences.getInt(KEY_HC_TIMEOUT_MARGIN, 0);
            hcTimeLimit = sharedPreferences.getBoolean(KEY_HC_TIME_LIMIT, false);
            hcBeginTimeHour = sharedPreferences.getInt(KEY_HC_BEGIN_TIME_HOUR, 8);
            hcBeginTimeMin = sharedPreferences.getInt(KEY_HC_BEGIN_TIME_MIN, 0);
            hcEndTimeHour = sharedPreferences.getInt(KEY_HC_END_TIME_HOUR, 23);
            hcEndTimeMin = sharedPreferences.getInt(KEY_HC_END_TIME_MIN, 0);
            hcBootEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_BOOT_ENABLE, true);
            hcBootDelay = sharedPreferences.getInt(C1625i.KEY_HC_BOOT_DELEY, 0);
            hcBootCPU = sharedPreferences.getInt(C1625i.KEY_HC_BOOT_CPU, 1);
            hcBootIO = sharedPreferences.getInt(C1625i.KEY_HC_BOOT_IO, 0);
            hcBootThr = sharedPreferences.getBoolean(C1625i.KEY_HC_BOOT_THR, false);
            hcBootTimeout = sharedPreferences.getInt(C1625i.KEY_HC_BOOT_TIMEOUT, 5000);
            hcBootAction = sharedPreferences.getLong(C1625i.KEY_HC_BOOT_ACTION, 4);
            hcEnterChattingEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_ENTER_CHATTING_ENABLE, true);
            hcEnterChattingDelay = sharedPreferences.getInt(C1625i.KEY_HC_ENTER_CHATTING_DELEY, 0);
            hcEnterChattingCPU = sharedPreferences.getInt(C1625i.KEY_HC_ENTER_CHATTING_CPU, 1);
            hcEnterChattingIO = sharedPreferences.getInt(C1625i.KEY_HC_ENTER_CHATTING_IO, 1);
            hcEnterChattingThr = sharedPreferences.getBoolean(C1625i.KEY_HC_ENTER_CHATTING_THR, false);
            hcEnterChattingTimeout = sharedPreferences.getInt(C1625i.KEY_HC_ENTER_CHATTING_TIMEOUT, 1000);
            hcEnterChattingAction = sharedPreferences.getLong(C1625i.KEY_HC_ENTER_CHATTING_ACTION, C1625i.sHCENTERCHATTINGACTION);
            hcQuitChattingEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_QUIT_CHATTING_ENABLE, true);
            hcQuitChattingDelay = sharedPreferences.getInt(C1625i.KEY_HC_QUIT_CHATTING_DELEY, 0);
            hcQuitChattingCPU = sharedPreferences.getInt(C1625i.KEY_HC_QUIT_CHATTING_CPU, 2);
            hcQuitChattingIO = sharedPreferences.getInt(C1625i.KEY_HC_QUIT_CHATTING_IO, 2);
            hcQuitChattingThr = sharedPreferences.getBoolean(C1625i.KEY_HC_QUIT_CHATTING_THR, false);
            hcQuitChattingTimeout = sharedPreferences.getInt(C1625i.KEY_HC_QUIT_CHATTING_TIMEOUT, 800);
            hcQuitChattingAction = sharedPreferences.getLong(C1625i.KEY_HC_QUIT_CHATTING_ACTION, C1625i.sHCQUITCHATTINGACTION);
            hcSendMsgEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_SEND_MSG_ENABLE, true);
            hcSendMsgDelay = sharedPreferences.getInt(C1625i.KEY_HC_SEND_MSG_DELEY, 0);
            hcSendMsgCPU = sharedPreferences.getInt(C1625i.KEY_HC_SEND_MSG_CPU, 3);
            hcSendMsgIO = sharedPreferences.getInt(C1625i.KEY_HC_SEND_MSG_IO, 0);
            hcSendMsgThr = sharedPreferences.getBoolean(C1625i.KEY_HC_SEND_MSG_THR, true);
            hcSendMsgTimeout = sharedPreferences.getInt(C1625i.KEY_HC_SEND_MSG_TIMEOUT, 1000);
            hcSendMsgAction = sharedPreferences.getLong(C1625i.KEY_HC_SEND_MSG_ACTION, 12288);
            hcSendPicMsgEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_SEND_PIC_MSG_ENABLE, true);
            hcSendPicMsgDelay = sharedPreferences.getInt(C1625i.KEY_HC_SEND_PIC_MSG_DELEY, 0);
            hcSendPicMsgCPU = sharedPreferences.getInt(C1625i.KEY_HC_SEND_PIC_MSG_CPU, 1);
            hcSendPicMsgIO = sharedPreferences.getInt(C1625i.KEY_HC_SEND_PIC_MSG_IO, 2);
            hcSendPicMsgThr = sharedPreferences.getBoolean(C1625i.KEY_HC_SEND_PIC_MSG_THR, true);
            hcSendPicMsgTimeout = sharedPreferences.getInt(C1625i.KEY_HC_SEND_PIC_MSG_TIMEOUT, 500);
            hcSendPicMsgAction = sharedPreferences.getLong(C1625i.KEY_HC_SEND_PIC_MSG_ACTION, C1625i.sHCSENDPICMSGACTION);
            hcReceiveMsgEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_RECEIVE_MSG_ENABLE, true);
            hcReceiveMsgDelay = sharedPreferences.getInt(C1625i.KEY_HC_RECEIVE_MSG_DELEY, 500);
            hcReceiveMsgCPU = sharedPreferences.getInt(C1625i.KEY_HC_RECEIVE_MSG_CPU, 2);
            hcReceiveMsgIO = sharedPreferences.getInt(C1625i.KEY_HC_RECEIVE_MSG_IO, 2);
            hcReceiveMsgThr = sharedPreferences.getBoolean(C1625i.KEY_HC_RECEIVE_MSG_THR, true);
            hcReceiveMsgTimeout = sharedPreferences.getInt(C1625i.KEY_HC_RECEIVE_MSG_TIMEOUT, 1000);
            hcReceiveMsgAction = sharedPreferences.getLong(C1625i.KEY_HC_RECEIVE_MSG_ACTION, 127040);
            hcUpdateChatroomEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_UPDATE_CHATROOM_ENABLE, true);
            hcUpdateChatroomDelay = sharedPreferences.getInt(C1625i.KEY_HC_UPDATE_CHATROOM_DELEY, 0);
            hcUpdateChatroomCPU = sharedPreferences.getInt(C1625i.KEY_HC_UPDATE_CHATROOM_CPU, 2);
            hcUpdateChatroomIO = sharedPreferences.getInt(C1625i.KEY_HC_UPDATE_CHATROOM_IO, 2);
            hcUpdateChatroomThr = sharedPreferences.getBoolean(C1625i.KEY_HC_UPDATE_CHATROOM_THR, true);
            hcUpdateChatroomTimeout = sharedPreferences.getInt(C1625i.KEY_HC_UPDATE_CHATROOM_TIMEOUT, 1000);
            hcUpdateChatroomAction = sharedPreferences.getLong(C1625i.KEY_HC_UPDATE_CHATROOM_ACTION, 127040);
            hcUpdateChatroomMemberCount = sharedPreferences.getLong(C1625i.KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT, 50);
            hcDBEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_DB_ENABLE, false);
            hcDBDelayQuery = sharedPreferences.getInt(C1625i.KEY_HC_DB_DELEY_QUERY, 100);
            hcDBDelayWrite = sharedPreferences.getInt(C1625i.KEY_HC_DB_DELEY_WRITE, 200);
            hcDBCPU = sharedPreferences.getInt(C1625i.KEY_HC_DB_CPU, 2);
            hcDBIO = sharedPreferences.getInt(C1625i.KEY_HC_DB_IO, 2);
            hcDBThr = sharedPreferences.getBoolean(C1625i.KEY_HC_DB_THR, false);
            hcDBTimeout = sharedPreferences.getInt(C1625i.KEY_HC_DB_TIMEOUT, 500);
            hcDBTimeoutBusy = sharedPreferences.getInt(C1625i.KEY_HC_DB_TIMEOUT_BUSY, 5000);
            hcDBActionQuery = sharedPreferences.getLong(C1625i.KEY_HC_DB_ACTION_QUERY, 4096);
            hcDBActionWrite = sharedPreferences.getLong(C1625i.KEY_HC_DB_ACTION_WRITE, 12288);
            hcEncodeVideoEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_ENCODE_VIDEO_ENABLE, true);
            hcEncodeVideoDelay = sharedPreferences.getInt(C1625i.KEY_HC_ENCODE_VIDEO_DELEY, 0);
            hcEncodeVideoCPU = sharedPreferences.getInt(C1625i.KEY_HC_ENCODE_VIDEO_CPU, 1);
            hcEncodeVideoIO = sharedPreferences.getInt(C1625i.KEY_HC_ENCODE_VIDEO_IO, 1);
            hcEncodeVideoThr = sharedPreferences.getBoolean(C1625i.KEY_HC_ENCODE_VIDEO_THR, false);
            hcEncodeVideoTimeout = sharedPreferences.getInt(C1625i.KEY_HC_ENCODE_VIDEO_TIMEOUT, C1625i.sHCENCODEVIDEOTIMEOUT);
            hcEncodeVideoAction = sharedPreferences.getLong(C1625i.KEY_HC_ENCODE_VIDEO_ACTION, 81984);
            hcDecodePicEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_DECODE_PIC_ENABLE, false);
            hcDecodePicDelay = sharedPreferences.getInt(C1625i.KEY_HC_DECODE_PIC_DELEY, 100);
            hcDecodePicCPU = sharedPreferences.getInt(C1625i.KEY_HC_DECODE_PIC_CPU, 2);
            hcDecodePicIO = sharedPreferences.getInt(C1625i.KEY_HC_DECODE_PIC_IO, 2);
            hcDecodePicThr = sharedPreferences.getBoolean(C1625i.KEY_HC_DECODE_PIC_THR, false);
            hcDecodePicTimeout = sharedPreferences.getInt(C1625i.KEY_HC_DECODE_PIC_TIMEOUT, 500);
            hcDecodePicAction = sharedPreferences.getLong(C1625i.KEY_HC_DECODE_PIC_ACTION, C1625i.sHCDECODEPICACTION);
            hcGifEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_GIF_ENABLE, true);
            hcGifDelay = sharedPreferences.getInt(C1625i.KEY_HC_GIF_DELEY, 0);
            hcGifCPU = sharedPreferences.getInt(C1625i.KEY_HC_GIF_CPU, 3);
            hcGifIO = sharedPreferences.getInt(C1625i.KEY_HC_GIF_IO, 2);
            hcGifThr = sharedPreferences.getBoolean(C1625i.KEY_HC_GIF_THR, false);
            hcGifTimeout = sharedPreferences.getInt(C1625i.KEY_HC_GIF_TIMEOUT, 500);
            hcGifAction = sharedPreferences.getLong(C1625i.KEY_HC_GIF_ACTION, 81984);
            hcGifFrameEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_GIF_FRAME_ENABLE, true);
            hcGifFrameDelay = sharedPreferences.getInt(C1625i.KEY_HC_GIF_FRAME_DELEY, 0);
            hcGifFrameCPU = sharedPreferences.getInt(C1625i.KEY_HC_GIF_FRAME_CPU, 2);
            hcGifFrameIO = sharedPreferences.getInt(C1625i.KEY_HC_GIF_FRAME_IO, 0);
            hcGifFrameThr = sharedPreferences.getBoolean(C1625i.KEY_HC_GIF_FRAME_THR, false);
            hcGifFrameTimeout = sharedPreferences.getInt(C1625i.KEY_HC_GIF_FRAME_TIMEOUT, 1000);
            hcGifFrameAction = sharedPreferences.getLong(C1625i.KEY_HC_GIF_FRAME_ACTION, C1625i.sHCGIFFRAMEACTION);
            hcSNSScrollEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_SNS_SCROLL_ENABLE, true);
            hcSNSScrollDelay = sharedPreferences.getInt(C1625i.KEY_HC_SNS_SCROLL_DELEY, 0);
            hcSNSScrollCPU = sharedPreferences.getInt(C1625i.KEY_HC_SNS_SCROLL_CPU, 2);
            hcSNSScrollIO = sharedPreferences.getInt(C1625i.KEY_HC_SNS_SCROLL_IO, 2);
            hcSNSScrollThr = sharedPreferences.getBoolean(C1625i.KEY_HC_SNS_SCROLL_THR, false);
            hcSNSScrollTimeout = sharedPreferences.getInt(C1625i.KEY_HC_SNS_SCROLL_TIMEOUT, 1500);
            hcSNSScrollAction = sharedPreferences.getLong(C1625i.KEY_HC_SNS_SCROLL_ACTION, 96);
            hcSNSUserScrollEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_SNS_USER_SCROLL_ENABLE, true);
            hcSNSUserScrollDelay = sharedPreferences.getInt(C1625i.KEY_HC_SNS_USER_SCROLL_DELEY, 0);
            hcSNSUserScrollCPU = sharedPreferences.getInt(C1625i.KEY_HC_SNS_USER_SCROLL_CPU, 3);
            hcSNSUserScrollIO = sharedPreferences.getInt(C1625i.KEY_HC_SNS_USER_SCROLL_IO, 2);
            hcSNSUserScrollThr = sharedPreferences.getBoolean(C1625i.KEY_HC_SNS_USER_SCROLL_THR, false);
            hcSNSUserScrollTimeout = sharedPreferences.getInt(C1625i.KEY_HC_SNS_USER_SCROLL_TIMEOUT, 1500);
            hcSNSUserScrollAction = sharedPreferences.getLong(C1625i.KEY_HC_SNS_USER_SCROLL_ACTION, 96);
            hcSNSMsgScrollEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_SNS_MSG_SCROLL_ENABLE, true);
            hcSNSMsgScrollDelay = sharedPreferences.getInt(C1625i.KEY_HC_SNS_MSG_SCROLL_DELEY, 0);
            hcSNSMsgScrollCPU = sharedPreferences.getInt(C1625i.KEY_HC_SNS_MSG_SCROLL_CPU, 3);
            hcSNSMsgScrollIO = sharedPreferences.getInt(C1625i.KEY_HC_SNS_MSG_SCROLL_IO, 2);
            hcSNSMsgScrollThr = sharedPreferences.getBoolean(C1625i.KEY_HC_SNS_MSG_SCROLL_THR, false);
            hcSNSMsgScrollTimeout = sharedPreferences.getInt(C1625i.KEY_HC_SNS_MSG_SCROLL_TIMEOUT, 1500);
            hcSNSMsgScrollAction = sharedPreferences.getLong(C1625i.KEY_HC_SNS_MSG_SCROLL_ACTION, 96);
            hcMediaGalleryScrollEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE, true);
            hcMediaGalleryScrollDelay = sharedPreferences.getInt(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_DELEY, 0);
            hcMediaGalleryScrollCPU = sharedPreferences.getInt(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_CPU, 3);
            hcMediaGalleryScrollIO = sharedPreferences.getInt(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_IO, 2);
            hcMediaGalleryScrollThr = sharedPreferences.getBoolean(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_THR, false);
            hcMediaGalleryScrollTimeout = sharedPreferences.getInt(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT, 1500);
            hcMediaGalleryScrollAction = sharedPreferences.getLong(C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_ACTION, 96);
            hcAlbumScrollEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_ALBUM_SCROLL_ENABLE, true);
            hcAlbumScrollDelay = sharedPreferences.getInt(C1625i.KEY_HC_ALBUM_SCROLL_DELEY, 0);
            hcAlbumScrollCPU = sharedPreferences.getInt(C1625i.KEY_HC_ALBUM_SCROLL_CPU, 3);
            hcAlbumScrollIO = sharedPreferences.getInt(C1625i.KEY_HC_ALBUM_SCROLL_IO, 2);
            hcAlbumScrollThr = sharedPreferences.getBoolean(C1625i.KEY_HC_ALBUM_SCROLL_THR, false);
            hcAlbumScrollTimeout = sharedPreferences.getInt(C1625i.KEY_HC_ALBUM_SCROLL_TIMEOUT, 1500);
            hcAlbumScrollAction = sharedPreferences.getLong(C1625i.KEY_HC_ALBUM_SCROLL_ACTION, 96);
            hcMiniProgramLaunchEnable = sharedPreferences.getBoolean(C1625i.KEY_HC_MINI_PROGRAM_LAUNCH_ENABLE, true);
            hcMiniProgramLaunchDelay = sharedPreferences.getInt(C1625i.KEY_HC_MINI_PROGRAM_LAUNCH_DELEY, 500);
            hcMiniProgramLaunchCPU = sharedPreferences.getInt(C1625i.KEY_HC_MINI_PROGRAM_LAUNCH_CPU, 1);
            hcMiniProgramLaunchIO = sharedPreferences.getInt(C1625i.KEY_HC_MINI_PROGRAM_LAUNCH_IO, 1);
            hcMiniProgramLaunchThr = sharedPreferences.getBoolean(C1625i.KEY_HC_MINI_PROGRAM_LAUNCH_THR, false);
            hcMiniProgramLaunchTimeout = sharedPreferences.getInt(C1625i.KEY_HC_MINI_PROGRAM_LAUNCH_TIMEOUT, 5000);
            hcMiniProgramLaunchAction = sharedPreferences.getLong(C1625i.KEY_HC_MINI_PROGRAM_LAUNCH_ACTION, C1625i.sHCMINIPROGRAMLAUNCHACTION);
            C4990ab.m7417i(TAG, "reloadSPConfig Boot[%b] EnterChatting[%b] QuitChatting[%b] SendMsg[%b] SendPicMsg[%b] ReceiveMsg[%b] UpdateChatroom[%b] DB[%b] EncodeVideo[%b] DecodePic[%b] Gif[%b] GifFrame[%b] SNS[%b] MediaGallery[%b] Album[%b] SNSUser[%b] SNSMsg[%b] MiniProgramLaunch[%b]", Boolean.valueOf(hcBootEnable), Boolean.valueOf(hcEnterChattingEnable), Boolean.valueOf(hcQuitChattingEnable), Boolean.valueOf(hcSendMsgEnable), Boolean.valueOf(hcSendPicMsgEnable), Boolean.valueOf(hcReceiveMsgEnable), Boolean.valueOf(hcUpdateChatroomEnable), Boolean.valueOf(hcDBEnable), Boolean.valueOf(hcEncodeVideoEnable), Boolean.valueOf(hcDecodePicEnable), Boolean.valueOf(hcGifEnable), Boolean.valueOf(hcGifFrameEnable), Boolean.valueOf(hcSNSScrollEnable), Boolean.valueOf(hcMediaGalleryScrollEnable), Boolean.valueOf(hcAlbumScrollEnable), Boolean.valueOf(hcSNSUserScrollEnable), Boolean.valueOf(hcSNSMsgScrollEnable), Boolean.valueOf(hcMiniProgramLaunchEnable));
            AppMethodBeat.m2505o(93134);
            return;
        }
        C4990ab.m7412e(TAG, "reloadSPConfig hcEnv is false.");
        AppMethodBeat.m2505o(93134);
    }

    public static synchronized String readServerAddr(boolean z) {
        String str;
        synchronized (WXHardCoderJNI.class) {
            AppMethodBeat.m2504i(93135);
            try {
                if (sSystemPropertiesClazz == null) {
                    Class cls = Class.forName("android.os.SystemProperties");
                    sSystemPropertiesClazz = cls;
                    Method declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
                    sGetStringPropsMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                str = (String) sGetStringPropsMethod.invoke(null, new Object[]{HardCoderJNI.serverPropKey, ""});
                C4990ab.m7417i(TAG, "readServerAddr, serverprop[%s], result[%s], stack[%s]", HardCoderJNI.serverPropKey, str, C5046bo.dpG());
                if (z) {
                    if (C5046bo.isNullOrNil(str)) {
                        WXHardCoderJNI.reportInfo(new C6590l(true, 1, 1, false));
                    } else {
                        WXHardCoderJNI.reportInfo(new C6590l(true, 2, 1, false));
                        WXHardCoderJNI.reportInfo(new C6591m());
                    }
                }
                AppMethodBeat.m2505o(93135);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace(TAG, th, "readServerAddr", new Object[0]);
                if (z) {
                    WXHardCoderJNI.reportInfo(new C6590l(true, 3, 1, false));
                }
                str = "";
                AppMethodBeat.m2505o(93135);
            }
        }
        return str;
    }

    public static boolean isHCEnable() {
        AppMethodBeat.m2504i(93136);
        int isCheckEnv = WXHardCoderJNI.isCheckEnv() & WXHardCoderJNI.getEnable();
        AppMethodBeat.m2505o(93136);
        return isCheckEnv;
    }

    public static int initHardCoder(C1617a c1617a, C1626a c1626a) {
        AppMethodBeat.m2504i(93137);
        HardCoderJNI.setHcEnable(WXHardCoderJNI.isHCEnable());
        String readServerAddr = WXHardCoderJNI.readServerAddr(false);
        if (readServerAddr == null || readServerAddr.isEmpty()) {
            String str = TAG;
            String str2 = "initHardCoder serverSock is null or empty, skip init and reguard as disabled, serverSock:%s.";
            Object[] objArr = new Object[1];
            if (readServerAddr == null) {
                readServerAddr = BuildConfig.COMMAND;
            }
            objArr[0] = readServerAddr;
            C4990ab.m7421w(str, str2, objArr);
            HardCoderJNI.setCheckEnv(false);
            AppMethodBeat.m2505o(93137);
            return -3;
        }
        if (readServerAddr != null && readServerAddr.contains("|")) {
            needMapAPPScene = true;
        }
        C1618e.m3277a(c1617a);
        hardCoderReporterInfo = c1626a;
        C1611c.m3268a(wxHardCoderLog);
        HardCoderJNI.setSceneReportCallback(sceneReportCallback);
        C4990ab.m7417i(TAG, "initHardCoder hcDebug[%b] hcEnable[%b] checkEnv[%b] TICK_RATE[%d]", Boolean.valueOf(HardCoderJNI.isHcDebug()), Boolean.valueOf(HardCoderJNI.isHcEnable()), Boolean.valueOf(HardCoderJNI.isCheckEnv()), Integer.valueOf(HardCoderJNI.tickRate));
        int initHardCoder = HardCoderJNI.initHardCoder(readServerAddr, 0, C4996ah.getPackageName() + HardCoderJNI.clientSock, new C65852(), C4996ah.getContext());
        AppMethodBeat.m2505o(93137);
        return initHardCoder;
    }

    private static boolean checkHardCoderEnv() {
        AppMethodBeat.m2504i(93138);
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        C4990ab.m7417i(TAG, "checkHardCoderEnv manufacture[%s], model[%s], remote[%s]", str, str2, WXHardCoderJNI.readServerAddr(false));
        if (C5046bo.isNullOrNil(WXHardCoderJNI.readServerAddr(false))) {
            AppMethodBeat.m2505o(93138);
            return false;
        }
        AppMethodBeat.m2505o(93138);
        return true;
    }

    public static int registerANRCallback(AnrCallback anrCallback) {
        AppMethodBeat.m2504i(93139);
        if (HardCoderJNI.isCheckEnv()) {
            int registerANRCallback = HardCoderJNI.registerANRCallback(anrCallback);
            AppMethodBeat.m2505o(93139);
            return registerANRCallback;
        }
        AppMethodBeat.m2505o(93139);
        return -2;
    }

    public static int registerSystemEventCallback(SystemEventCallback systemEventCallback) {
        AppMethodBeat.m2504i(93140);
        if (HardCoderJNI.isCheckEnv()) {
            C4990ab.m7417i(TAG, "registerSystemEventCallback, stack[%s]", C5046bo.dpG());
            int registerSystemEventCallback = HardCoderJNI.registerSystemEventCallback(systemEventCallback);
            AppMethodBeat.m2505o(93140);
            return registerSystemEventCallback;
        }
        AppMethodBeat.m2505o(93140);
        return -2;
    }

    public static void reportIDKey(boolean z, int i, int i2, boolean z2) {
        AppMethodBeat.m2504i(93141);
        WXHardCoderJNI.reportInfo(new C6590l(z, i, i2, z2));
        AppMethodBeat.m2505o(93141);
    }

    public static void reportFPS(int i, long j, int i2, long j2, long j3) {
        AppMethodBeat.m2504i(93142);
        WXHardCoderJNI.reportInfo(new C6589k(i, j, i2, j2, j3));
        AppMethodBeat.m2505o(93142);
    }

    private static void reportInfo(C1627j c1627j) {
        AppMethodBeat.m2504i(93143);
        if (hardCoderReporterInfo != null) {
            hardCoderReporterInfo.reportInfo(c1627j);
        }
        AppMethodBeat.m2505o(93143);
    }

    private static void initSceneAndFlagMap() {
        AppMethodBeat.m2504i(93144);
        SCENE_ID_MAP.clear();
        APP_SCENE_ID_MAP.clear();
        SCENE_ID_MAP.put(Integer.valueOf(101), Integer.valueOf(1));
        SCENE_ID_MAP.put(Integer.valueOf(201), Integer.valueOf(2));
        SCENE_ID_MAP.put(Integer.valueOf(202), Integer.valueOf(3));
        SCENE_ID_MAP.put(Integer.valueOf(203), Integer.valueOf(4));
        SCENE_ID_MAP.put(Integer.valueOf(301), Integer.valueOf(5));
        SCENE_ID_MAP.put(Integer.valueOf(302), Integer.valueOf(6));
        SCENE_ID_MAP.put(Integer.valueOf(401), Integer.valueOf(7));
        SCENE_ID_MAP.put(Integer.valueOf(501), Integer.valueOf(8));
        SCENE_ID_MAP.put(Integer.valueOf(601), Integer.valueOf(9));
        SCENE_ID_MAP.put(Integer.valueOf(602), Integer.valueOf(10));
        SCENE_ID_MAP.put(Integer.valueOf(603), Integer.valueOf(11));
        SCENE_ID_MAP.put(Integer.valueOf(701), Integer.valueOf(12));
        SCENE_ID_MAP.put(Integer.valueOf(702), Integer.valueOf(13));
        SCENE_ID_MAP.put(Integer.valueOf(703), Integer.valueOf(14));
        SCENE_ID_MAP.put(Integer.valueOf(704), Integer.valueOf(15));
        SCENE_ID_MAP.put(Integer.valueOf(705), Integer.valueOf(16));
        SCENE_ID_MAP.put(Integer.valueOf(801), Integer.valueOf(17));
        SCENE_ID_MAP.put(Integer.valueOf(901), Integer.valueOf(18));
        SCENE_ID_MAP.put(Integer.valueOf(902), Integer.valueOf(19));
        SCENE_ID_MAP.put(Integer.valueOf(C1625i.SCENE_BIZ_SCROLL), Integer.valueOf(20));
        SCENE_ID_MAP.put(Integer.valueOf(706), Integer.valueOf(21));
        SCENE_ID_MAP.put(Integer.valueOf(707), Integer.valueOf(22));
        APP_SCENE_ID_MAP.put(Integer.valueOf(101), Integer.valueOf(1));
        APP_SCENE_ID_MAP.put(Integer.valueOf(201), Integer.valueOf(6));
        APP_SCENE_ID_MAP.put(Integer.valueOf(202), Integer.valueOf(6));
        APP_SCENE_ID_MAP.put(Integer.valueOf(203), Integer.valueOf(5));
        APP_SCENE_ID_MAP.put(Integer.valueOf(301), Integer.valueOf(2));
        APP_SCENE_ID_MAP.put(Integer.valueOf(302), Integer.valueOf(2));
        APP_SCENE_ID_MAP.put(Integer.valueOf(401), Integer.valueOf(6));
        APP_SCENE_ID_MAP.put(Integer.valueOf(501), Integer.valueOf(4));
        APP_SCENE_ID_MAP.put(Integer.valueOf(601), Integer.valueOf(5));
        APP_SCENE_ID_MAP.put(Integer.valueOf(602), Integer.valueOf(5));
        APP_SCENE_ID_MAP.put(Integer.valueOf(603), Integer.valueOf(5));
        APP_SCENE_ID_MAP.put(Integer.valueOf(701), Integer.valueOf(3));
        APP_SCENE_ID_MAP.put(Integer.valueOf(702), Integer.valueOf(3));
        APP_SCENE_ID_MAP.put(Integer.valueOf(703), Integer.valueOf(3));
        APP_SCENE_ID_MAP.put(Integer.valueOf(704), Integer.valueOf(3));
        APP_SCENE_ID_MAP.put(Integer.valueOf(705), Integer.valueOf(3));
        APP_SCENE_ID_MAP.put(Integer.valueOf(801), Integer.valueOf(1));
        APP_SCENE_ID_MAP.put(Integer.valueOf(901), Integer.valueOf(2));
        APP_SCENE_ID_MAP.put(Integer.valueOf(902), Integer.valueOf(2));
        APP_SCENE_ID_MAP.put(Integer.valueOf(C1625i.SCENE_BIZ_SCROLL), Integer.valueOf(3));
        APP_SCENE_ID_MAP.put(Integer.valueOf(706), Integer.valueOf(2));
        APP_SCENE_ID_MAP.put(Integer.valueOf(707), Integer.valueOf(7));
        flagKeyMap.put(Long.valueOf(2), C1625i.KEY_HC_BOOT_ENABLE);
        flagKeyMap.put(Long.valueOf(4), C1625i.KEY_HC_RECEIVE_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(8), C1625i.KEY_HC_SEND_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(16), C1625i.KEY_HC_SEND_PIC_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(32), C1625i.KEY_HC_ENTER_CHATTING_ENABLE);
        flagKeyMap.put(Long.valueOf(64), C1625i.KEY_HC_QUIT_CHATTING_ENABLE);
        flagKeyMap.put(Long.valueOf(128), C1625i.KEY_HC_UPDATE_CHATROOM_ENABLE);
        flagKeyMap.put(Long.valueOf(256), C1625i.KEY_HC_DB_ENABLE);
        flagKeyMap.put(Long.valueOf(512), C1625i.KEY_HC_DECODE_PIC_ENABLE);
        flagKeyMap.put(Long.valueOf(1024), C1625i.KEY_HC_GIF_ENABLE);
        flagKeyMap.put(Long.valueOf(2048), C1625i.KEY_HC_GIF_FRAME_ENABLE);
        flagKeyMap.put(Long.valueOf(4096), C1625i.KEY_HC_ENCODE_VIDEO_ENABLE);
        flagKeyMap.put(Long.valueOf(8192), C1625i.KEY_HC_SNS_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(16384), C1625i.KEY_HC_ALBUM_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(32768), C1625i.KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(65536), C1625i.KEY_HC_SNS_USER_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(131072), C1625i.KEY_HC_SNS_MSG_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(262144), C1625i.KEY_HC_MINI_PROGRAM_LAUNCH_ENABLE);
        AppMethodBeat.m2505o(93144);
    }
}
