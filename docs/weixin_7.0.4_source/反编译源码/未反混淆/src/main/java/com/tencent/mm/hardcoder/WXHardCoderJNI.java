package com.tencent.mm.hardcoder;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.HardCoderJNI.AnrCallback;
import com.tencent.mm.hardcoder.HardCoderJNI.HCPerfManagerThread;
import com.tencent.mm.hardcoder.HardCoderJNI.SceneReportCallback;
import com.tencent.mm.hardcoder.HardCoderJNI.SystemEventCallback;
import com.tencent.mm.hardcoder.j.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WXHardCoderJNI extends i {
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
    private static a hardCoderReporterInfo = null;
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
    private static SceneReportCallback sceneReportCallback = new SceneReportCallback() {
        public final void sceneReport(int i, long j) {
            AppMethodBeat.i(93123);
            if (WXHardCoderJNI.needMapAPPScene) {
                AppMethodBeat.o(93123);
                return;
            }
            Integer num = (Integer) WXHardCoderJNI.SCENE_ID_MAP.get(Integer.valueOf(i));
            if (num == null) {
                AppMethodBeat.o(93123);
                return;
            }
            WXHardCoderJNI.access$100(new l(num.intValue()));
            AppMethodBeat.o(93123);
        }
    };
    private static c.a wxHardCoderLog = new c.a() {
        public final void i(String str, String str2) {
            AppMethodBeat.i(93118);
            ab.i(str, str2);
            AppMethodBeat.o(93118);
        }

        public final void d(String str, String str2) {
            AppMethodBeat.i(93119);
            ab.d(str, str2);
            AppMethodBeat.o(93119);
        }

        public final void e(String str, String str2) {
            AppMethodBeat.i(93120);
            ab.e(str, str2);
            AppMethodBeat.o(93120);
        }

        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(93121);
            ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.o(93121);
        }
    };

    static /* synthetic */ void access$100(j jVar) {
        AppMethodBeat.i(93145);
        reportInfo(jVar);
        AppMethodBeat.o(93145);
    }

    static {
        AppMethodBeat.i(93146);
        initSceneAndFlagMap();
        reloadSPConfig(RELOAD_SCENE_INIT);
        AppMethodBeat.o(93146);
    }

    public static boolean isCheckEnv() {
        AppMethodBeat.i(93124);
        boolean isCheckEnv = HardCoderJNI.isCheckEnv();
        AppMethodBeat.o(93124);
        return isCheckEnv;
    }

    public static boolean getDebug() {
        AppMethodBeat.i(93125);
        boolean isHcDebug = HardCoderJNI.isHcDebug();
        AppMethodBeat.o(93125);
        return isHcDebug;
    }

    public static boolean getEnable() {
        AppMethodBeat.i(93126);
        boolean isHcEnable = HardCoderJNI.isHcEnable();
        AppMethodBeat.o(93126);
        return isHcEnable;
    }

    public static void setHcEnable(boolean z) {
        AppMethodBeat.i(93127);
        HardCoderJNI.setHcEnable(z);
        AppMethodBeat.o(93127);
    }

    public static void setDebug(boolean z) {
        AppMethodBeat.i(93128);
        HardCoderJNI.setHcDebug(z);
        AppMethodBeat.o(93128);
    }

    public static int terminateApp(int i, long j) {
        AppMethodBeat.i(93129);
        int terminateApp = HardCoderJNI.terminateApp(i, j);
        AppMethodBeat.o(93129);
        return terminateApp;
    }

    public static void setRetryConnectInterval(int i) {
        AppMethodBeat.i(93130);
        HardCoderJNI.setRetryConnectInterval(i);
        AppMethodBeat.o(93130);
    }

    public static int isRunning() {
        AppMethodBeat.i(93131);
        int isRunning = HardCoderJNI.isRunning();
        AppMethodBeat.o(93131);
        return isRunning;
    }

    public static int startPerformance(boolean z, int i, int i2, int i3, int i4, int i5, int i6, long j, String str) {
        AppMethodBeat.i(93132);
        if (!z) {
            AppMethodBeat.o(93132);
            return -3;
        } else if (hcBgEnable || foreground) {
            int intValue;
            int startPerformance;
            if (needMapAPPScene) {
                Integer num = (Integer) APP_SCENE_ID_MAP.get(Integer.valueOf(i6));
                if (num != null) {
                    intValue = num.intValue();
                    startPerformance = HardCoderJNI.startPerformance(i, i2, i3, i4, i5 + hcTimeoutMargin, intValue, j, Process.myTid(), str);
                    AppMethodBeat.o(93132);
                    return startPerformance;
                }
            }
            intValue = i6;
            startPerformance = HardCoderJNI.startPerformance(i, i2, i3, i4, i5 + hcTimeoutMargin, intValue, j, Process.myTid(), str);
            AppMethodBeat.o(93132);
            return startPerformance;
        } else {
            AppMethodBeat.o(93132);
            return -4;
        }
    }

    public static int stopPerformance(boolean z, int i) {
        AppMethodBeat.i(93133);
        if (z) {
            int stopPerformance = HardCoderJNI.stopPerformance(i);
            AppMethodBeat.o(93133);
            return stopPerformance;
        }
        AppMethodBeat.o(93133);
        return -3;
    }

    private WXHardCoderJNI() {
    }

    public static void reloadSPConfig(int i) {
        AppMethodBeat.i(93134);
        boolean checkHardCoderEnv = checkHardCoderEnv();
        HardCoderJNI.setCheckEnv(checkHardCoderEnv);
        if (checkHardCoderEnv) {
            setDebug(false);
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(SETTING_SP_FILE, 0);
            HardCoderJNI.setHcEnable(sharedPreferences.getBoolean(KEY_HC_ENABLE, true));
            hcBgEnable = sharedPreferences.getBoolean(KEY_HC_BG_ENABLE, true);
            hcUinHash = sharedPreferences.getInt(KEY_HC_UIN_HASH, 0);
            HardCoderJNI.setHcDebug(sharedPreferences.getBoolean(KEY_HC_DEBUG, false));
            ab.i(TAG, "reloadSPConfig scene:%d, hcDebug:%b, hcEnable:%b, hcUinHash:%d, checkEnv:%b, stack[%s]", Integer.valueOf(i), Boolean.valueOf(HardCoderJNI.isHcDebug()), Boolean.valueOf(HardCoderJNI.isHcEnable()), Integer.valueOf(hcUinHash), Boolean.valueOf(HardCoderJNI.isCheckEnv()), bo.dpG());
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
            hcBootEnable = sharedPreferences.getBoolean(i.KEY_HC_BOOT_ENABLE, true);
            hcBootDelay = sharedPreferences.getInt(i.KEY_HC_BOOT_DELEY, 0);
            hcBootCPU = sharedPreferences.getInt(i.KEY_HC_BOOT_CPU, 1);
            hcBootIO = sharedPreferences.getInt(i.KEY_HC_BOOT_IO, 0);
            hcBootThr = sharedPreferences.getBoolean(i.KEY_HC_BOOT_THR, false);
            hcBootTimeout = sharedPreferences.getInt(i.KEY_HC_BOOT_TIMEOUT, 5000);
            hcBootAction = sharedPreferences.getLong(i.KEY_HC_BOOT_ACTION, 4);
            hcEnterChattingEnable = sharedPreferences.getBoolean(i.KEY_HC_ENTER_CHATTING_ENABLE, true);
            hcEnterChattingDelay = sharedPreferences.getInt(i.KEY_HC_ENTER_CHATTING_DELEY, 0);
            hcEnterChattingCPU = sharedPreferences.getInt(i.KEY_HC_ENTER_CHATTING_CPU, 1);
            hcEnterChattingIO = sharedPreferences.getInt(i.KEY_HC_ENTER_CHATTING_IO, 1);
            hcEnterChattingThr = sharedPreferences.getBoolean(i.KEY_HC_ENTER_CHATTING_THR, false);
            hcEnterChattingTimeout = sharedPreferences.getInt(i.KEY_HC_ENTER_CHATTING_TIMEOUT, 1000);
            hcEnterChattingAction = sharedPreferences.getLong(i.KEY_HC_ENTER_CHATTING_ACTION, i.sHCENTERCHATTINGACTION);
            hcQuitChattingEnable = sharedPreferences.getBoolean(i.KEY_HC_QUIT_CHATTING_ENABLE, true);
            hcQuitChattingDelay = sharedPreferences.getInt(i.KEY_HC_QUIT_CHATTING_DELEY, 0);
            hcQuitChattingCPU = sharedPreferences.getInt(i.KEY_HC_QUIT_CHATTING_CPU, 2);
            hcQuitChattingIO = sharedPreferences.getInt(i.KEY_HC_QUIT_CHATTING_IO, 2);
            hcQuitChattingThr = sharedPreferences.getBoolean(i.KEY_HC_QUIT_CHATTING_THR, false);
            hcQuitChattingTimeout = sharedPreferences.getInt(i.KEY_HC_QUIT_CHATTING_TIMEOUT, 800);
            hcQuitChattingAction = sharedPreferences.getLong(i.KEY_HC_QUIT_CHATTING_ACTION, i.sHCQUITCHATTINGACTION);
            hcSendMsgEnable = sharedPreferences.getBoolean(i.KEY_HC_SEND_MSG_ENABLE, true);
            hcSendMsgDelay = sharedPreferences.getInt(i.KEY_HC_SEND_MSG_DELEY, 0);
            hcSendMsgCPU = sharedPreferences.getInt(i.KEY_HC_SEND_MSG_CPU, 3);
            hcSendMsgIO = sharedPreferences.getInt(i.KEY_HC_SEND_MSG_IO, 0);
            hcSendMsgThr = sharedPreferences.getBoolean(i.KEY_HC_SEND_MSG_THR, true);
            hcSendMsgTimeout = sharedPreferences.getInt(i.KEY_HC_SEND_MSG_TIMEOUT, 1000);
            hcSendMsgAction = sharedPreferences.getLong(i.KEY_HC_SEND_MSG_ACTION, 12288);
            hcSendPicMsgEnable = sharedPreferences.getBoolean(i.KEY_HC_SEND_PIC_MSG_ENABLE, true);
            hcSendPicMsgDelay = sharedPreferences.getInt(i.KEY_HC_SEND_PIC_MSG_DELEY, 0);
            hcSendPicMsgCPU = sharedPreferences.getInt(i.KEY_HC_SEND_PIC_MSG_CPU, 1);
            hcSendPicMsgIO = sharedPreferences.getInt(i.KEY_HC_SEND_PIC_MSG_IO, 2);
            hcSendPicMsgThr = sharedPreferences.getBoolean(i.KEY_HC_SEND_PIC_MSG_THR, true);
            hcSendPicMsgTimeout = sharedPreferences.getInt(i.KEY_HC_SEND_PIC_MSG_TIMEOUT, 500);
            hcSendPicMsgAction = sharedPreferences.getLong(i.KEY_HC_SEND_PIC_MSG_ACTION, i.sHCSENDPICMSGACTION);
            hcReceiveMsgEnable = sharedPreferences.getBoolean(i.KEY_HC_RECEIVE_MSG_ENABLE, true);
            hcReceiveMsgDelay = sharedPreferences.getInt(i.KEY_HC_RECEIVE_MSG_DELEY, 500);
            hcReceiveMsgCPU = sharedPreferences.getInt(i.KEY_HC_RECEIVE_MSG_CPU, 2);
            hcReceiveMsgIO = sharedPreferences.getInt(i.KEY_HC_RECEIVE_MSG_IO, 2);
            hcReceiveMsgThr = sharedPreferences.getBoolean(i.KEY_HC_RECEIVE_MSG_THR, true);
            hcReceiveMsgTimeout = sharedPreferences.getInt(i.KEY_HC_RECEIVE_MSG_TIMEOUT, 1000);
            hcReceiveMsgAction = sharedPreferences.getLong(i.KEY_HC_RECEIVE_MSG_ACTION, 127040);
            hcUpdateChatroomEnable = sharedPreferences.getBoolean(i.KEY_HC_UPDATE_CHATROOM_ENABLE, true);
            hcUpdateChatroomDelay = sharedPreferences.getInt(i.KEY_HC_UPDATE_CHATROOM_DELEY, 0);
            hcUpdateChatroomCPU = sharedPreferences.getInt(i.KEY_HC_UPDATE_CHATROOM_CPU, 2);
            hcUpdateChatroomIO = sharedPreferences.getInt(i.KEY_HC_UPDATE_CHATROOM_IO, 2);
            hcUpdateChatroomThr = sharedPreferences.getBoolean(i.KEY_HC_UPDATE_CHATROOM_THR, true);
            hcUpdateChatroomTimeout = sharedPreferences.getInt(i.KEY_HC_UPDATE_CHATROOM_TIMEOUT, 1000);
            hcUpdateChatroomAction = sharedPreferences.getLong(i.KEY_HC_UPDATE_CHATROOM_ACTION, 127040);
            hcUpdateChatroomMemberCount = sharedPreferences.getLong(i.KEY_HC_UPDATE_CHATROOM_MEMBER_COUNT, 50);
            hcDBEnable = sharedPreferences.getBoolean(i.KEY_HC_DB_ENABLE, false);
            hcDBDelayQuery = sharedPreferences.getInt(i.KEY_HC_DB_DELEY_QUERY, 100);
            hcDBDelayWrite = sharedPreferences.getInt(i.KEY_HC_DB_DELEY_WRITE, 200);
            hcDBCPU = sharedPreferences.getInt(i.KEY_HC_DB_CPU, 2);
            hcDBIO = sharedPreferences.getInt(i.KEY_HC_DB_IO, 2);
            hcDBThr = sharedPreferences.getBoolean(i.KEY_HC_DB_THR, false);
            hcDBTimeout = sharedPreferences.getInt(i.KEY_HC_DB_TIMEOUT, 500);
            hcDBTimeoutBusy = sharedPreferences.getInt(i.KEY_HC_DB_TIMEOUT_BUSY, 5000);
            hcDBActionQuery = sharedPreferences.getLong(i.KEY_HC_DB_ACTION_QUERY, 4096);
            hcDBActionWrite = sharedPreferences.getLong(i.KEY_HC_DB_ACTION_WRITE, 12288);
            hcEncodeVideoEnable = sharedPreferences.getBoolean(i.KEY_HC_ENCODE_VIDEO_ENABLE, true);
            hcEncodeVideoDelay = sharedPreferences.getInt(i.KEY_HC_ENCODE_VIDEO_DELEY, 0);
            hcEncodeVideoCPU = sharedPreferences.getInt(i.KEY_HC_ENCODE_VIDEO_CPU, 1);
            hcEncodeVideoIO = sharedPreferences.getInt(i.KEY_HC_ENCODE_VIDEO_IO, 1);
            hcEncodeVideoThr = sharedPreferences.getBoolean(i.KEY_HC_ENCODE_VIDEO_THR, false);
            hcEncodeVideoTimeout = sharedPreferences.getInt(i.KEY_HC_ENCODE_VIDEO_TIMEOUT, i.sHCENCODEVIDEOTIMEOUT);
            hcEncodeVideoAction = sharedPreferences.getLong(i.KEY_HC_ENCODE_VIDEO_ACTION, 81984);
            hcDecodePicEnable = sharedPreferences.getBoolean(i.KEY_HC_DECODE_PIC_ENABLE, false);
            hcDecodePicDelay = sharedPreferences.getInt(i.KEY_HC_DECODE_PIC_DELEY, 100);
            hcDecodePicCPU = sharedPreferences.getInt(i.KEY_HC_DECODE_PIC_CPU, 2);
            hcDecodePicIO = sharedPreferences.getInt(i.KEY_HC_DECODE_PIC_IO, 2);
            hcDecodePicThr = sharedPreferences.getBoolean(i.KEY_HC_DECODE_PIC_THR, false);
            hcDecodePicTimeout = sharedPreferences.getInt(i.KEY_HC_DECODE_PIC_TIMEOUT, 500);
            hcDecodePicAction = sharedPreferences.getLong(i.KEY_HC_DECODE_PIC_ACTION, i.sHCDECODEPICACTION);
            hcGifEnable = sharedPreferences.getBoolean(i.KEY_HC_GIF_ENABLE, true);
            hcGifDelay = sharedPreferences.getInt(i.KEY_HC_GIF_DELEY, 0);
            hcGifCPU = sharedPreferences.getInt(i.KEY_HC_GIF_CPU, 3);
            hcGifIO = sharedPreferences.getInt(i.KEY_HC_GIF_IO, 2);
            hcGifThr = sharedPreferences.getBoolean(i.KEY_HC_GIF_THR, false);
            hcGifTimeout = sharedPreferences.getInt(i.KEY_HC_GIF_TIMEOUT, 500);
            hcGifAction = sharedPreferences.getLong(i.KEY_HC_GIF_ACTION, 81984);
            hcGifFrameEnable = sharedPreferences.getBoolean(i.KEY_HC_GIF_FRAME_ENABLE, true);
            hcGifFrameDelay = sharedPreferences.getInt(i.KEY_HC_GIF_FRAME_DELEY, 0);
            hcGifFrameCPU = sharedPreferences.getInt(i.KEY_HC_GIF_FRAME_CPU, 2);
            hcGifFrameIO = sharedPreferences.getInt(i.KEY_HC_GIF_FRAME_IO, 0);
            hcGifFrameThr = sharedPreferences.getBoolean(i.KEY_HC_GIF_FRAME_THR, false);
            hcGifFrameTimeout = sharedPreferences.getInt(i.KEY_HC_GIF_FRAME_TIMEOUT, 1000);
            hcGifFrameAction = sharedPreferences.getLong(i.KEY_HC_GIF_FRAME_ACTION, i.sHCGIFFRAMEACTION);
            hcSNSScrollEnable = sharedPreferences.getBoolean(i.KEY_HC_SNS_SCROLL_ENABLE, true);
            hcSNSScrollDelay = sharedPreferences.getInt(i.KEY_HC_SNS_SCROLL_DELEY, 0);
            hcSNSScrollCPU = sharedPreferences.getInt(i.KEY_HC_SNS_SCROLL_CPU, 2);
            hcSNSScrollIO = sharedPreferences.getInt(i.KEY_HC_SNS_SCROLL_IO, 2);
            hcSNSScrollThr = sharedPreferences.getBoolean(i.KEY_HC_SNS_SCROLL_THR, false);
            hcSNSScrollTimeout = sharedPreferences.getInt(i.KEY_HC_SNS_SCROLL_TIMEOUT, 1500);
            hcSNSScrollAction = sharedPreferences.getLong(i.KEY_HC_SNS_SCROLL_ACTION, 96);
            hcSNSUserScrollEnable = sharedPreferences.getBoolean(i.KEY_HC_SNS_USER_SCROLL_ENABLE, true);
            hcSNSUserScrollDelay = sharedPreferences.getInt(i.KEY_HC_SNS_USER_SCROLL_DELEY, 0);
            hcSNSUserScrollCPU = sharedPreferences.getInt(i.KEY_HC_SNS_USER_SCROLL_CPU, 3);
            hcSNSUserScrollIO = sharedPreferences.getInt(i.KEY_HC_SNS_USER_SCROLL_IO, 2);
            hcSNSUserScrollThr = sharedPreferences.getBoolean(i.KEY_HC_SNS_USER_SCROLL_THR, false);
            hcSNSUserScrollTimeout = sharedPreferences.getInt(i.KEY_HC_SNS_USER_SCROLL_TIMEOUT, 1500);
            hcSNSUserScrollAction = sharedPreferences.getLong(i.KEY_HC_SNS_USER_SCROLL_ACTION, 96);
            hcSNSMsgScrollEnable = sharedPreferences.getBoolean(i.KEY_HC_SNS_MSG_SCROLL_ENABLE, true);
            hcSNSMsgScrollDelay = sharedPreferences.getInt(i.KEY_HC_SNS_MSG_SCROLL_DELEY, 0);
            hcSNSMsgScrollCPU = sharedPreferences.getInt(i.KEY_HC_SNS_MSG_SCROLL_CPU, 3);
            hcSNSMsgScrollIO = sharedPreferences.getInt(i.KEY_HC_SNS_MSG_SCROLL_IO, 2);
            hcSNSMsgScrollThr = sharedPreferences.getBoolean(i.KEY_HC_SNS_MSG_SCROLL_THR, false);
            hcSNSMsgScrollTimeout = sharedPreferences.getInt(i.KEY_HC_SNS_MSG_SCROLL_TIMEOUT, 1500);
            hcSNSMsgScrollAction = sharedPreferences.getLong(i.KEY_HC_SNS_MSG_SCROLL_ACTION, 96);
            hcMediaGalleryScrollEnable = sharedPreferences.getBoolean(i.KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE, true);
            hcMediaGalleryScrollDelay = sharedPreferences.getInt(i.KEY_HC_MEDIA_GALLERY_SCROLL_DELEY, 0);
            hcMediaGalleryScrollCPU = sharedPreferences.getInt(i.KEY_HC_MEDIA_GALLERY_SCROLL_CPU, 3);
            hcMediaGalleryScrollIO = sharedPreferences.getInt(i.KEY_HC_MEDIA_GALLERY_SCROLL_IO, 2);
            hcMediaGalleryScrollThr = sharedPreferences.getBoolean(i.KEY_HC_MEDIA_GALLERY_SCROLL_THR, false);
            hcMediaGalleryScrollTimeout = sharedPreferences.getInt(i.KEY_HC_MEDIA_GALLERY_SCROLL_TIMEOUT, 1500);
            hcMediaGalleryScrollAction = sharedPreferences.getLong(i.KEY_HC_MEDIA_GALLERY_SCROLL_ACTION, 96);
            hcAlbumScrollEnable = sharedPreferences.getBoolean(i.KEY_HC_ALBUM_SCROLL_ENABLE, true);
            hcAlbumScrollDelay = sharedPreferences.getInt(i.KEY_HC_ALBUM_SCROLL_DELEY, 0);
            hcAlbumScrollCPU = sharedPreferences.getInt(i.KEY_HC_ALBUM_SCROLL_CPU, 3);
            hcAlbumScrollIO = sharedPreferences.getInt(i.KEY_HC_ALBUM_SCROLL_IO, 2);
            hcAlbumScrollThr = sharedPreferences.getBoolean(i.KEY_HC_ALBUM_SCROLL_THR, false);
            hcAlbumScrollTimeout = sharedPreferences.getInt(i.KEY_HC_ALBUM_SCROLL_TIMEOUT, 1500);
            hcAlbumScrollAction = sharedPreferences.getLong(i.KEY_HC_ALBUM_SCROLL_ACTION, 96);
            hcMiniProgramLaunchEnable = sharedPreferences.getBoolean(i.KEY_HC_MINI_PROGRAM_LAUNCH_ENABLE, true);
            hcMiniProgramLaunchDelay = sharedPreferences.getInt(i.KEY_HC_MINI_PROGRAM_LAUNCH_DELEY, 500);
            hcMiniProgramLaunchCPU = sharedPreferences.getInt(i.KEY_HC_MINI_PROGRAM_LAUNCH_CPU, 1);
            hcMiniProgramLaunchIO = sharedPreferences.getInt(i.KEY_HC_MINI_PROGRAM_LAUNCH_IO, 1);
            hcMiniProgramLaunchThr = sharedPreferences.getBoolean(i.KEY_HC_MINI_PROGRAM_LAUNCH_THR, false);
            hcMiniProgramLaunchTimeout = sharedPreferences.getInt(i.KEY_HC_MINI_PROGRAM_LAUNCH_TIMEOUT, 5000);
            hcMiniProgramLaunchAction = sharedPreferences.getLong(i.KEY_HC_MINI_PROGRAM_LAUNCH_ACTION, i.sHCMINIPROGRAMLAUNCHACTION);
            ab.i(TAG, "reloadSPConfig Boot[%b] EnterChatting[%b] QuitChatting[%b] SendMsg[%b] SendPicMsg[%b] ReceiveMsg[%b] UpdateChatroom[%b] DB[%b] EncodeVideo[%b] DecodePic[%b] Gif[%b] GifFrame[%b] SNS[%b] MediaGallery[%b] Album[%b] SNSUser[%b] SNSMsg[%b] MiniProgramLaunch[%b]", Boolean.valueOf(hcBootEnable), Boolean.valueOf(hcEnterChattingEnable), Boolean.valueOf(hcQuitChattingEnable), Boolean.valueOf(hcSendMsgEnable), Boolean.valueOf(hcSendPicMsgEnable), Boolean.valueOf(hcReceiveMsgEnable), Boolean.valueOf(hcUpdateChatroomEnable), Boolean.valueOf(hcDBEnable), Boolean.valueOf(hcEncodeVideoEnable), Boolean.valueOf(hcDecodePicEnable), Boolean.valueOf(hcGifEnable), Boolean.valueOf(hcGifFrameEnable), Boolean.valueOf(hcSNSScrollEnable), Boolean.valueOf(hcMediaGalleryScrollEnable), Boolean.valueOf(hcAlbumScrollEnable), Boolean.valueOf(hcSNSUserScrollEnable), Boolean.valueOf(hcSNSMsgScrollEnable), Boolean.valueOf(hcMiniProgramLaunchEnable));
            AppMethodBeat.o(93134);
            return;
        }
        ab.e(TAG, "reloadSPConfig hcEnv is false.");
        AppMethodBeat.o(93134);
    }

    public static synchronized String readServerAddr(boolean z) {
        String str;
        synchronized (WXHardCoderJNI.class) {
            AppMethodBeat.i(93135);
            try {
                if (sSystemPropertiesClazz == null) {
                    Class cls = Class.forName("android.os.SystemProperties");
                    sSystemPropertiesClazz = cls;
                    Method declaredMethod = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
                    sGetStringPropsMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                str = (String) sGetStringPropsMethod.invoke(null, new Object[]{HardCoderJNI.serverPropKey, ""});
                ab.i(TAG, "readServerAddr, serverprop[%s], result[%s], stack[%s]", HardCoderJNI.serverPropKey, str, bo.dpG());
                if (z) {
                    if (bo.isNullOrNil(str)) {
                        reportInfo(new l(true, 1, 1, false));
                    } else {
                        reportInfo(new l(true, 2, 1, false));
                        reportInfo(new m());
                    }
                }
                AppMethodBeat.o(93135);
            } catch (Throwable th) {
                ab.printErrStackTrace(TAG, th, "readServerAddr", new Object[0]);
                if (z) {
                    reportInfo(new l(true, 3, 1, false));
                }
                str = "";
                AppMethodBeat.o(93135);
            }
        }
        return str;
    }

    public static boolean isHCEnable() {
        AppMethodBeat.i(93136);
        int isCheckEnv = isCheckEnv() & getEnable();
        AppMethodBeat.o(93136);
        return isCheckEnv;
    }

    public static int initHardCoder(e.a aVar, a aVar2) {
        AppMethodBeat.i(93137);
        HardCoderJNI.setHcEnable(isHCEnable());
        String readServerAddr = readServerAddr(false);
        if (readServerAddr == null || readServerAddr.isEmpty()) {
            String str = TAG;
            String str2 = "initHardCoder serverSock is null or empty, skip init and reguard as disabled, serverSock:%s.";
            Object[] objArr = new Object[1];
            if (readServerAddr == null) {
                readServerAddr = BuildConfig.COMMAND;
            }
            objArr[0] = readServerAddr;
            ab.w(str, str2, objArr);
            HardCoderJNI.setCheckEnv(false);
            AppMethodBeat.o(93137);
            return -3;
        }
        if (readServerAddr != null && readServerAddr.contains("|")) {
            needMapAPPScene = true;
        }
        e.a(aVar);
        hardCoderReporterInfo = aVar2;
        c.a(wxHardCoderLog);
        HardCoderJNI.setSceneReportCallback(sceneReportCallback);
        ab.i(TAG, "initHardCoder hcDebug[%b] hcEnable[%b] checkEnv[%b] TICK_RATE[%d]", Boolean.valueOf(HardCoderJNI.isHcDebug()), Boolean.valueOf(HardCoderJNI.isHcEnable()), Boolean.valueOf(HardCoderJNI.isCheckEnv()), Integer.valueOf(HardCoderJNI.tickRate));
        int initHardCoder = HardCoderJNI.initHardCoder(readServerAddr, 0, ah.getPackageName() + HardCoderJNI.clientSock, new HCPerfManagerThread() {
            public final Thread newThread(Runnable runnable, String str, int i) {
                AppMethodBeat.i(93122);
                Thread a = d.a(runnable, str, i);
                AppMethodBeat.o(93122);
                return a;
            }
        }, ah.getContext());
        AppMethodBeat.o(93137);
        return initHardCoder;
    }

    private static boolean checkHardCoderEnv() {
        AppMethodBeat.i(93138);
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        ab.i(TAG, "checkHardCoderEnv manufacture[%s], model[%s], remote[%s]", str, str2, readServerAddr(false));
        if (bo.isNullOrNil(readServerAddr(false))) {
            AppMethodBeat.o(93138);
            return false;
        }
        AppMethodBeat.o(93138);
        return true;
    }

    public static int registerANRCallback(AnrCallback anrCallback) {
        AppMethodBeat.i(93139);
        if (HardCoderJNI.isCheckEnv()) {
            int registerANRCallback = HardCoderJNI.registerANRCallback(anrCallback);
            AppMethodBeat.o(93139);
            return registerANRCallback;
        }
        AppMethodBeat.o(93139);
        return -2;
    }

    public static int registerSystemEventCallback(SystemEventCallback systemEventCallback) {
        AppMethodBeat.i(93140);
        if (HardCoderJNI.isCheckEnv()) {
            ab.i(TAG, "registerSystemEventCallback, stack[%s]", bo.dpG());
            int registerSystemEventCallback = HardCoderJNI.registerSystemEventCallback(systemEventCallback);
            AppMethodBeat.o(93140);
            return registerSystemEventCallback;
        }
        AppMethodBeat.o(93140);
        return -2;
    }

    public static void reportIDKey(boolean z, int i, int i2, boolean z2) {
        AppMethodBeat.i(93141);
        reportInfo(new l(z, i, i2, z2));
        AppMethodBeat.o(93141);
    }

    public static void reportFPS(int i, long j, int i2, long j2, long j3) {
        AppMethodBeat.i(93142);
        reportInfo(new k(i, j, i2, j2, j3));
        AppMethodBeat.o(93142);
    }

    private static void reportInfo(j jVar) {
        AppMethodBeat.i(93143);
        if (hardCoderReporterInfo != null) {
            hardCoderReporterInfo.reportInfo(jVar);
        }
        AppMethodBeat.o(93143);
    }

    private static void initSceneAndFlagMap() {
        AppMethodBeat.i(93144);
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
        SCENE_ID_MAP.put(Integer.valueOf(i.SCENE_BIZ_SCROLL), Integer.valueOf(20));
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
        APP_SCENE_ID_MAP.put(Integer.valueOf(i.SCENE_BIZ_SCROLL), Integer.valueOf(3));
        APP_SCENE_ID_MAP.put(Integer.valueOf(706), Integer.valueOf(2));
        APP_SCENE_ID_MAP.put(Integer.valueOf(707), Integer.valueOf(7));
        flagKeyMap.put(Long.valueOf(2), i.KEY_HC_BOOT_ENABLE);
        flagKeyMap.put(Long.valueOf(4), i.KEY_HC_RECEIVE_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(8), i.KEY_HC_SEND_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(16), i.KEY_HC_SEND_PIC_MSG_ENABLE);
        flagKeyMap.put(Long.valueOf(32), i.KEY_HC_ENTER_CHATTING_ENABLE);
        flagKeyMap.put(Long.valueOf(64), i.KEY_HC_QUIT_CHATTING_ENABLE);
        flagKeyMap.put(Long.valueOf(128), i.KEY_HC_UPDATE_CHATROOM_ENABLE);
        flagKeyMap.put(Long.valueOf(256), i.KEY_HC_DB_ENABLE);
        flagKeyMap.put(Long.valueOf(512), i.KEY_HC_DECODE_PIC_ENABLE);
        flagKeyMap.put(Long.valueOf(1024), i.KEY_HC_GIF_ENABLE);
        flagKeyMap.put(Long.valueOf(2048), i.KEY_HC_GIF_FRAME_ENABLE);
        flagKeyMap.put(Long.valueOf(4096), i.KEY_HC_ENCODE_VIDEO_ENABLE);
        flagKeyMap.put(Long.valueOf(8192), i.KEY_HC_SNS_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(16384), i.KEY_HC_ALBUM_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(32768), i.KEY_HC_MEDIA_GALLERY_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(65536), i.KEY_HC_SNS_USER_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(131072), i.KEY_HC_SNS_MSG_SCROLL_ENABLE);
        flagKeyMap.put(Long.valueOf(262144), i.KEY_HC_MINI_PROGRAM_LAUNCH_ENABLE);
        AppMethodBeat.o(93144);
    }
}
