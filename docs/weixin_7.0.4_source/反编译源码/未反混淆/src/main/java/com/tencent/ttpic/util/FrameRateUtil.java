package com.tencent.ttpic.util;

import com.facebook.login.widget.ToolTipPopup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.util.i;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FrameRateUtil {
    private static final int BASE_COUNT = 6;
    private static int FPS_LIST_MAX_COUNT = 500;
    public static final int MAX_FPS = 18;
    private static final String TAG = FrameRateUtil.class.getSimpleName();
    private static final long TIME_INTERVAL = 55;
    private static int count;
    private static List<Long> fpsList = new LinkedList();
    private static List<Long> fpsListForDG = new LinkedList();
    private static DowngradeListener listener;
    private static DOWNGRADE_LEVEL mDowngradeLevel = DOWNGRADE_LEVEL.MEDIUM;
    public static int mFrameCount;
    public static long mRecordStartTime;
    private static long start;

    public interface DowngradeListener {
        void downgrade(int i);
    }

    public enum DOWNGRADE_LEVEL {
        HIGH(0, MediaConfig.INTERMIDIATE_IMAGE_WIDTH_HIGH, MediaConfig.BPS_HIGH),
        MEDIUM(1, MediaConfig.INTERMIDIATE_IMAGE_WIDTH_MEDIUM, MediaConfig.BPS_MEDIUM),
        LOW(2, MediaConfig.INTERMIDIATE_IMAGE_WIDTH_LOW, MediaConfig.BPS_LOW);
        
        public int bps;
        public int value;
        public int width;

        static {
            AppMethodBeat.o(83920);
        }

        private DOWNGRADE_LEVEL(int i, int i2, int i3) {
            this.value = i;
            this.width = i2;
            this.bps = i3;
        }
    }

    static {
        AppMethodBeat.i(83927);
        AppMethodBeat.o(83927);
    }

    public static List<Long> getFpsList() {
        return fpsListForDG;
    }

    public static void setListener(DowngradeListener downgradeListener) {
        listener = downgradeListener;
    }

    public static synchronized void recordFps(boolean z) {
        int i = 0;
        synchronized (FrameRateUtil.class) {
            AppMethodBeat.i(83921);
            count++;
            if (fpsListForDG.size() >= FPS_LIST_MAX_COUNT) {
                fpsListForDG.clear();
            }
            if (count >= 6) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = ToolTipPopup.DEFAULT_POPUP_DISPLAY_TIME / (currentTimeMillis - start);
                if (fpsList.size() >= FPS_LIST_MAX_COUNT) {
                    fpsList.remove(0);
                }
                fpsList.add(Long.valueOf(j));
                fpsListForDG.add(Long.valueOf(j));
                start = currentTimeMillis;
                count = 0;
            }
            if (z) {
                if (mDowngradeLevel.equals(DOWNGRADE_LEVEL.LOW)) {
                    AppMethodBeat.o(83921);
                } else if (fpsListForDG.size() >= 12) {
                    Collections.sort(fpsListForDG);
                    for (int i2 = 4; i2 < fpsListForDG.size() - 4; i2++) {
                        i = (int) (((long) i) + ((Long) fpsListForDG.get(i2)).longValue());
                    }
                    if (i / (fpsListForDG.size() - 8) < 10) {
                        downgrade();
                    }
                    fpsListForDG.clear();
                }
            }
            AppMethodBeat.o(83921);
        }
    }

    public static synchronized void clearFpsList() {
        synchronized (FrameRateUtil.class) {
            AppMethodBeat.i(83922);
            i.k(TAG, "clearFpsList");
            fpsList.clear();
            AppMethodBeat.o(83922);
        }
    }

    public static synchronized void checkFps(long j) {
        synchronized (FrameRateUtil.class) {
            AppMethodBeat.i(83923);
            if (TIME_INTERVAL - j > 0) {
                try {
                    Thread.sleep(100);
                    AppMethodBeat.o(83923);
                } catch (InterruptedException e) {
                }
            }
            AppMethodBeat.o(83923);
        }
    }

    public static void upgrade() {
        AppMethodBeat.i(83924);
        if (mDowngradeLevel == null) {
            mDowngradeLevel = DOWNGRADE_LEVEL.MEDIUM;
        }
        if (mDowngradeLevel.equals(DOWNGRADE_LEVEL.MEDIUM)) {
            mDowngradeLevel = DOWNGRADE_LEVEL.MEDIUM;
        } else if (mDowngradeLevel.equals(DOWNGRADE_LEVEL.LOW)) {
            mDowngradeLevel = DOWNGRADE_LEVEL.MEDIUM;
        }
        VideoPrefsUtil.setDowngradeLevel(mDowngradeLevel.value);
        AppMethodBeat.o(83924);
    }

    private static void downgrade() {
        AppMethodBeat.i(83925);
        if (mDowngradeLevel == null || listener == null) {
            AppMethodBeat.o(83925);
            return;
        }
        if (mDowngradeLevel.equals(DOWNGRADE_LEVEL.HIGH)) {
            mDowngradeLevel = DOWNGRADE_LEVEL.MEDIUM;
            listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_MEDIUM);
        } else if (mDowngradeLevel.equals(DOWNGRADE_LEVEL.MEDIUM)) {
            mDowngradeLevel = DOWNGRADE_LEVEL.LOW;
            listener.downgrade(MediaConfig.INTERMIDIATE_IMAGE_WIDTH_LOW);
        }
        new StringBuilder("[downgrade] ").append(mDowngradeLevel.value);
        VideoPrefsUtil.setDowngradeLevel(mDowngradeLevel.value);
        AppMethodBeat.o(83925);
    }

    public static DOWNGRADE_LEVEL getRenderLevel() {
        return mDowngradeLevel;
    }

    public static void setDowngradeLevel(int i) {
        AppMethodBeat.i(83926);
        for (DOWNGRADE_LEVEL downgrade_level : DOWNGRADE_LEVEL.values()) {
            if (i == downgrade_level.value) {
                mDowngradeLevel = downgrade_level;
                AppMethodBeat.o(83926);
                return;
            }
        }
        AppMethodBeat.o(83926);
    }
}
