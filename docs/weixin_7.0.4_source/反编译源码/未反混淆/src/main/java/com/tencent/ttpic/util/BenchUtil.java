package com.tencent.ttpic.util;

import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BenchUtil {
    private static final int COUNT = 10;
    public static boolean ENABLE_LOG = false;
    public static boolean ENABLE_MEMINFO = false;
    public static boolean ENABLE_PERFORMANCE_RECORD = false;
    private static final String PREFIX = "[time]";
    public static String SHOWPREVIEW_BENCH_TAG = "showPreview_";
    private static final String TAG = BenchUtil.class.getSimpleName();
    private static Map<String, Long> lastTimeMap = new HashMap();
    private static LoggerAgent sLogger = new LoggerAgent();
    private static Map<String, Long> startTimeMap = new HashMap();
    private static Map<String, List<Long>> totalTimeMap = new HashMap();

    public static class LoggerAgent {
        public void d(String str, String str2) {
            AppMethodBeat.i(83809);
            if (BenchUtil.ENABLE_LOG) {
                LogUtils.d(str, str2);
            }
            AppMethodBeat.o(83809);
        }
    }

    static {
        AppMethodBeat.i(83822);
        AppMethodBeat.o(83822);
    }

    public static void init() {
        AppMethodBeat.i(83810);
        startTimeMap.clear();
        totalTimeMap.clear();
        lastTimeMap.clear();
        AppMethodBeat.o(83810);
    }

    public static void benchStart(String str) {
        AppMethodBeat.i(83811);
        if (!ENABLE_LOG) {
            AppMethodBeat.o(83811);
        } else if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(83811);
        } else {
            if (ENABLE_PERFORMANCE_RECORD && str.startsWith(SHOWPREVIEW_BENCH_TAG)) {
                GLES20.glFinish();
            }
            startTimeMap.put(str, Long.valueOf(System.currentTimeMillis()));
            AppMethodBeat.o(83811);
        }
    }

    public static long benchEnd(String str) {
        AppMethodBeat.i(83812);
        if (!ENABLE_LOG || TextUtils.isEmpty(str) || startTimeMap == null) {
            AppMethodBeat.o(83812);
            return 0;
        }
        Long l = (Long) startTimeMap.get(str);
        if (l == null) {
            AppMethodBeat.o(83812);
            return 0;
        }
        if (ENABLE_PERFORMANCE_RECORD && str.startsWith(SHOWPREVIEW_BENCH_TAG)) {
            GLES20.glFinish();
        }
        List list = (List) totalTimeMap.get(str);
        if (list == null) {
            list = new ArrayList();
            totalTimeMap.put(str, list);
        }
        long currentTimeMillis = System.currentTimeMillis() - l.longValue();
        list.add(Long.valueOf(currentTimeMillis));
        if (list.size() >= 10) {
            long totalTime = getTotalTime(list) / ((long) list.size());
            LogUtils.d(TAG, new StringBuilder(PREFIX).append(str).append(": ").append(totalTime).append("ms").toString());
            lastTimeMap.put(str, Long.valueOf(totalTime));
            list.clear();
        }
        AppMethodBeat.o(83812);
        return currentTimeMillis;
    }

    public static long benchEndTotal(String str) {
        AppMethodBeat.i(83813);
        if (!ENABLE_LOG) {
            AppMethodBeat.o(83813);
            return 0;
        } else if (TextUtils.isEmpty(str) || startTimeMap.get(str) == null) {
            AppMethodBeat.o(83813);
            return 0;
        } else {
            List list;
            List list2 = (List) totalTimeMap.get(str);
            if (list2 == null) {
                ArrayList arrayList = new ArrayList();
                totalTimeMap.put(str, arrayList);
                list = arrayList;
            } else {
                list = list2;
            }
            long currentTimeMillis = System.currentTimeMillis() - ((Long) startTimeMap.get(str)).longValue();
            list.add(Long.valueOf(currentTimeMillis));
            AppMethodBeat.o(83813);
            return currentTimeMillis;
        }
    }

    public static void flush() {
        AppMethodBeat.i(83814);
        for (Entry entry : totalTimeMap.entrySet()) {
            sLogger.d(TAG, new StringBuilder(PREFIX).append((String) entry.getKey()).append(": ").append(getTotalTime((List) entry.getValue())).append("ms").toString());
        }
        totalTimeMap.clear();
        AppMethodBeat.o(83814);
    }

    public static void benchEnd(String str, int i) {
        AppMethodBeat.i(83815);
        if (!ENABLE_LOG) {
            AppMethodBeat.o(83815);
        } else if (TextUtils.isEmpty(str) || startTimeMap.get(str) == null) {
            AppMethodBeat.o(83815);
        } else {
            List list;
            List list2 = (List) totalTimeMap.get(str);
            if (list2 == null) {
                ArrayList arrayList = new ArrayList();
                totalTimeMap.put(str, arrayList);
                list = arrayList;
            } else {
                list = list2;
            }
            list.add(Long.valueOf(System.currentTimeMillis() - ((Long) startTimeMap.get(str)).longValue()));
            if (list.size() >= 10) {
                sLogger.d(TAG, new StringBuilder(PREFIX).append(str).append(": ").append(getTotalTime(list) / ((long) (list.size() / i))).append("ms").toString());
                list.clear();
            }
            AppMethodBeat.o(83815);
        }
    }

    public static void benchEndReverse(String str, int i) {
        AppMethodBeat.i(83816);
        if (TextUtils.isEmpty(str) || startTimeMap.get(str) == null) {
            AppMethodBeat.o(83816);
            return;
        }
        List list;
        List list2 = (List) totalTimeMap.get(str);
        if (list2 == null) {
            ArrayList arrayList = new ArrayList();
            totalTimeMap.put(str, arrayList);
            list = arrayList;
        } else {
            list = list2;
        }
        list.add(Long.valueOf(System.currentTimeMillis() - ((Long) startTimeMap.get(str)).longValue()));
        if (list.size() >= 10) {
            sLogger.d(TAG, new StringBuilder(PREFIX).append(str).append(": ").append(((long) (list.size() * i)) / getTotalTime(list)).append("fps").toString());
            list.clear();
        }
        AppMethodBeat.o(83816);
    }

    private static long getTotalTime(List<Long> list) {
        long j = 0;
        AppMethodBeat.i(83817);
        if (!ENABLE_LOG) {
            AppMethodBeat.o(83817);
            return 0;
        } else if (BaseUtils.isEmpty(list)) {
            AppMethodBeat.o(83817);
            return 0;
        } else {
            Iterator it = list.iterator();
            while (true) {
                long j2 = j;
                if (it.hasNext()) {
                    j = ((Long) it.next()).longValue() + j2;
                } else {
                    AppMethodBeat.o(83817);
                    return j2;
                }
            }
        }
    }

    public static void calcFps() {
        AppMethodBeat.i(83818);
        benchEnd("bench_fps");
        benchStart("bench_fps");
        AppMethodBeat.o(83818);
    }

    public static long elapsed(String str) {
        AppMethodBeat.i(83819);
        if (lastTimeMap.containsKey(str)) {
            long longValue = ((Long) lastTimeMap.get(str)).longValue();
            AppMethodBeat.o(83819);
            return longValue;
        }
        AppMethodBeat.o(83819);
        return 0;
    }

    public static String getLastBenchAverage() {
        AppMethodBeat.i(83820);
        if (ENABLE_LOG) {
            StringBuffer stringBuffer = new StringBuffer();
            long elapsed = elapsed("bench_fps");
            if (elapsed != 0) {
                stringBuffer.append("fps : " + Math.round((float) (1000 / elapsed)) + IOUtils.LINE_SEPARATOR_UNIX);
            }
            stringBuffer.append("frame elapsed : " + elapsed + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("yuv2rgba : " + elapsed("mPreviewFilter") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("beauty-filter : " + elapsed("mBeautyFilter") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("filter : " + elapsed("mFilter") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("arFilter : " + elapsed("arFilter") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("gpu2cpu : " + elapsed("gpu2cpu") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("doTrack : " + elapsed("doTrack") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("faceDetect : " + elapsed("faceDetect") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("beautyTransform : " + elapsed("mBeautyTransformList") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("sticker : " + elapsed("updateAndRender") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("flip : " + elapsed("mFlipFilter") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("viewFilter : " + elapsed("mViewFilter") + IOUtils.LINE_SEPARATOR_UNIX);
            stringBuffer.append("onDrawFrame : " + elapsed("onDrawFrame") + IOUtils.LINE_SEPARATOR_UNIX);
            String stringBuffer2 = stringBuffer.toString();
            AppMethodBeat.o(83820);
            return stringBuffer2;
        }
        AppMethodBeat.o(83820);
        return null;
    }

    public static String getLastBenchAveragePitu(int i) {
        AppMethodBeat.i(83821);
        StringBuffer stringBuffer = new StringBuffer();
        long elapsed = elapsed("bench_fps");
        if (elapsed != 0) {
            stringBuffer.append("fps : " + Math.round((float) (1000 / elapsed)) + IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuffer.append("frame elapsed : " + elapsed + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("onDrawFrame : " + elapsed("onDrawFrame") + IOUtils.LINE_SEPARATOR_UNIX);
        stringBuffer.append("materialSize : " + VideoMemoryManager.getInstance().getMaterialSizeInMB() + " MB\n");
        stringBuffer.append("ratation : " + i + IOUtils.LINE_SEPARATOR_UNIX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(83821);
        return stringBuffer2;
    }

    public static void setLoggerAgent(LoggerAgent loggerAgent) {
        sLogger = loggerAgent;
    }
}
