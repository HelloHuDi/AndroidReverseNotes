package com.tencent.youtu.ytagreflectlivecheck.controller;

import android.graphics.ColorMatrixColorFilter;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytagreflectlivecheck.jni.JNIUtils;
import com.tencent.youtu.ytagreflectlivecheck.jni.YTAGReflectLiveCheckJNIInterface;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager;
import com.tencent.youtu.ytagreflectlivecheck.manager.ProcessManager.ProcessResult;
import com.tencent.youtu.ytagreflectlivecheck.ui.YTReflectLayout;
import com.tencent.youtu.ytagreflectlivecheck.worker.TimerWorker;
import com.tencent.youtu.ytcommon.tools.YTException;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReflectController {
    private static final String CONFIG_ALPHA = "A";
    private static final String CONFIG_BLUE = "B";
    private static final String CONFIG_CONFIGS = "configs";
    private static final String CONFIG_DURATION = "duration";
    private static final String CONFIG_GREEN = "G";
    private static final String CONFIG_RED = "R";
    private static final String CONFIG_UNIT = "unit";
    public static final ColorMatrixColorFilter DEFAULT_MATRIX_COLOR_FILTER = new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
    private static final int DELAY_TIME = 400;
    private static int ERRCODE_CONFIG_DECODE_FAILED = 0;
    private static int ERRCODE_FINISH_FAILED = 4;
    private static int ERRCODE_GET_PARAMS_FAILED = 2;
    private static int ERRCODE_START_FAILED = 3;
    private static int ERRCODE_USER_CANCEL = 1;
    private static final int STATE_DETECT_DELAY = 1;
    private static final int STATE_END = 2;
    private static final int STATE_RGB_CHANGE = 0;
    private static final String TAG = "YoutuLightLiveCheck";
    private static final long deltaTimeThreshold = 30;
    private static long systemTime = System.currentTimeMillis();
    private ProcessResult mCheckResult;
    private int mConfigBegin = 0;
    private int mConfigEnd = 0;
    private int mConfigPoint = 0;
    private TimerWorker mCountDownTimer;
    private int mFrame = 0;
    private YTReflectLayout mReflectLayout;
    private int mState;
    private long time_finish_begin = 0;
    private long time_finish_end = 0;
    private long time_now = 0;
    private long time_pre = 0;
    private long time_start = 0;

    static /* synthetic */ void access$1000(ReflectController reflectController) {
        AppMethodBeat.i(123166);
        reflectController.stopTimer();
        AppMethodBeat.o(123166);
    }

    static /* synthetic */ void access$1300(ReflectController reflectController, byte[] bArr, Camera camera) {
        AppMethodBeat.i(123167);
        reflectController.onPreviewFrameReceived(bArr, camera);
        AppMethodBeat.o(123167);
    }

    static /* synthetic */ void access$700(ReflectController reflectController, ColorMatrixColorFilter colorMatrixColorFilter) {
        AppMethodBeat.i(123164);
        reflectController.setColorMatrixColorFilter(colorMatrixColorFilter);
        AppMethodBeat.o(123164);
    }

    static /* synthetic */ void access$900(ReflectController reflectController, int i) {
        AppMethodBeat.i(123165);
        reflectController.changeState(i);
        AppMethodBeat.o(123165);
    }

    static {
        AppMethodBeat.i(123168);
        AppMethodBeat.o(123168);
    }

    public void start(YTReflectLayout yTReflectLayout, ProcessResult processResult) {
        Exception e;
        AppMethodBeat.i(123155);
        this.mReflectLayout = yTReflectLayout;
        this.mCheckResult = processResult;
        String str = ProcessManager.dataWorker().mRgbConfigCode;
        try {
            int i;
            int i2;
            JSONArray jSONArray;
            JSONObject jSONObject = new JSONObject(YTAGReflectLiveCheckJNIInterface.getInstance().FRInit(true, str));
            try {
                i = jSONObject.getInt("duration");
                try {
                    i2 = jSONObject.getInt(CONFIG_UNIT);
                    try {
                        jSONArray = jSONObject.getJSONArray(CONFIG_CONFIGS);
                    } catch (JSONException e2) {
                        e = e2;
                    }
                } catch (JSONException e3) {
                    e = e3;
                    i2 = 0;
                }
            } catch (JSONException e4) {
                e = e4;
                i2 = 0;
                i = 0;
            }
            try {
                startTimer(i, i2, jSONArray);
                AppMethodBeat.o(123155);
            } catch (Exception e5) {
                YTException.report(e5);
                innerCancel();
                this.mCheckResult.onFailed(ERRCODE_START_FAILED, "Start check failed. ", "Check error report to get more information.");
                AppMethodBeat.o(123155);
                return;
            }
            YTException.report(e5);
            this.mCheckResult.onFailed(ERRCODE_GET_PARAMS_FAILED, "Can't get params from config. ", "Maybe config is not right. Current rgbConfig is: ".concat(String.valueOf(str)));
            jSONArray = null;
            startTimer(i, i2, jSONArray);
            AppMethodBeat.o(123155);
        } catch (JSONException e6) {
            YTException.report(e6);
            this.mCheckResult.onFailed(ERRCODE_CONFIG_DECODE_FAILED, "Can't decode json config with rgbconfig.", "check whether rgbConfig is right. Current rgbConfig is: ".concat(String.valueOf(str)));
            AppMethodBeat.o(123155);
        }
    }

    public void cancel() {
        AppMethodBeat.i(123156);
        innerCancel();
        this.mCheckResult.onFailed(ERRCODE_USER_CANCEL, "User canceled. ", "User actively closes the proccess.");
        AppMethodBeat.o(123156);
    }

    private void setColorMatrixColorFilter(final ColorMatrixColorFilter colorMatrixColorFilter) {
        AppMethodBeat.i(123157);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.mReflectLayout.setColorMatrixColorFilter(colorMatrixColorFilter);
            AppMethodBeat.o(123157);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(123150);
                ReflectController.this.mReflectLayout.setColorMatrixColorFilter(colorMatrixColorFilter);
                AppMethodBeat.o(123150);
            }
        });
        AppMethodBeat.o(123157);
    }

    private void stopTimer() {
        AppMethodBeat.i(123158);
        if (this.mCountDownTimer != null) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer = null;
        }
        AppMethodBeat.o(123158);
    }

    private void innerCancel() {
        AppMethodBeat.i(123159);
        if (this.mState == 0) {
            setColorMatrixColorFilter(DEFAULT_MATRIX_COLOR_FILTER);
        }
        AppMethodBeat.o(123159);
    }

    private void startTimer(int i, int i2, JSONArray jSONArray) {
        AppMethodBeat.i(123160);
        YTLogger.i(TAG, "start timer.");
        changeState(0);
        this.mFrame = 0;
        YTLogger.i("mCountDownTimer", "duration:" + i + " unit: " + i2);
        this.time_pre = System.currentTimeMillis();
        this.time_start = this.time_pre;
        final int i3 = i2;
        final JSONArray jSONArray2 = jSONArray;
        this.mCountDownTimer = new TimerWorker((long) i, (long) i2) {
            public void onTick(long j) {
                AppMethodBeat.i(123152);
                ReflectController.this.time_now = System.currentTimeMillis();
                YTLogger.i("mCountDownTimer", "unit:" + i3 + " | real unit:" + (ReflectController.this.time_now - ReflectController.this.time_pre));
                ReflectController.this.time_pre = ReflectController.this.time_now;
                try {
                    YTLogger.d(ReflectController.TAG, "startTimer.onTick. mFrame: " + ReflectController.this.mFrame);
                    if (ReflectController.this.mFrame == ReflectController.this.mConfigBegin) {
                        YTLogger.i(ReflectController.TAG, "change color begin. mFrame: " + ReflectController.this.mFrame);
                        YTAGReflectLiveCheckJNIInterface.getInstance().FRSetBegin(JNIUtils.getTimeval());
                    } else if (ReflectController.this.mFrame == ReflectController.this.mConfigEnd) {
                        YTLogger.i(ReflectController.TAG, "change color end. mFrame: " + ReflectController.this.mFrame);
                        YTAGReflectLiveCheckJNIInterface.getInstance().FRSetEnd(JNIUtils.getTimeval());
                    } else if (ReflectController.this.mFrame == ReflectController.this.mConfigPoint) {
                        YTLogger.i(ReflectController.TAG, "change color point. mFrame: " + ReflectController.this.mFrame);
                        YTAGReflectLiveCheckJNIInterface.getInstance().FRSetChangePointTime(JNIUtils.getTimeval());
                    }
                    JSONObject jSONObject = jSONArray2.getJSONObject(ReflectController.this.mFrame);
                    float f = (float) jSONObject.getDouble(ReflectController.CONFIG_RED);
                    float f2 = (float) jSONObject.getDouble(ReflectController.CONFIG_GREEN);
                    float f3 = (float) jSONObject.getDouble(ReflectController.CONFIG_BLUE);
                    float f4 = (float) jSONObject.getDouble(ReflectController.CONFIG_ALPHA);
                    ReflectController.access$700(ReflectController.this, new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, f4, 0.0f}));
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Integer.valueOf((int) f));
                    arrayList.add(Integer.valueOf((int) f2));
                    arrayList.add(Integer.valueOf((int) f3));
                    ReflectController.this.mFrame = ReflectController.this.mFrame + 1;
                    AppMethodBeat.o(123152);
                } catch (JSONException e) {
                    YTException.report(e);
                    AppMethodBeat.o(123152);
                }
            }

            public void onFinish() {
                AppMethodBeat.i(123153);
                try {
                    YTLogger.i(ReflectController.TAG, "finish timer.");
                    ReflectController.this.time_finish_begin = System.currentTimeMillis();
                    ReflectController.access$700(ReflectController.this, ReflectController.DEFAULT_MATRIX_COLOR_FILTER);
                    YTLogger.i("mCountDownTimer", "setColorMatrixColorFilter:" + (System.currentTimeMillis() - ReflectController.this.time_finish_begin));
                    ReflectController.access$900(ReflectController.this, 1);
                    YTLogger.i("mCountDownTimer", "changeState:" + (System.currentTimeMillis() - ReflectController.this.time_finish_begin));
                    YTLogger.i("mCountDownTimer", "current thread1: " + Thread.currentThread());
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            AppMethodBeat.i(123151);
                            YTLogger.i("mCountDownTimer", "current thread2: " + Thread.currentThread());
                            YTLogger.i("mCountDownTimer", "change to main:" + (System.currentTimeMillis() - ReflectController.this.time_finish_begin));
                            ReflectController.access$900(ReflectController.this, 2);
                            AppMethodBeat.o(123151);
                        }
                    }, 400);
                    ReflectController.access$1000(ReflectController.this);
                    AppMethodBeat.o(123153);
                } catch (Exception e) {
                    YTException.report(e);
                    ReflectController.this.mCheckResult.onFailed(ReflectController.ERRCODE_FINISH_FAILED, "Finish check failed. ", "Check error report to get more information.");
                    AppMethodBeat.o(123153);
                }
            }
        };
        this.mCountDownTimer.start();
        AppMethodBeat.o(123160);
    }

    private void changeState(int i) {
        AppMethodBeat.i(123161);
        this.mState = i;
        YTLogger.i(TAG, "changeState. state: ".concat(String.valueOf(i)));
        cameraStateControl(i);
        if (i == 0) {
            this.mConfigBegin = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigBegin();
            this.mConfigEnd = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetConfigEnd();
            this.mConfigPoint = YTAGReflectLiveCheckJNIInterface.getInstance().FRGetChangePoint();
            ProcessManager.cameraWorker().setCameraPreviewCallback(new PreviewCallback() {
                public void onPreviewFrame(byte[] bArr, Camera camera) {
                    AppMethodBeat.i(123154);
                    ReflectController.access$1300(ReflectController.this, bArr, camera);
                    AppMethodBeat.o(123154);
                }
            });
            AppMethodBeat.o(123161);
            return;
        }
        if (i == 2) {
            YTLogger.i("mCountDownTimer", "cameraStateControl:" + (System.currentTimeMillis() - this.time_finish_begin));
            ProcessManager.cameraWorker().setCameraPreviewCallback(null);
            YTLogger.i("mCountDownTimer", "setCameraPreviewCallback:" + (System.currentTimeMillis() - this.time_finish_begin));
            this.time_finish_end = System.currentTimeMillis();
            YTLogger.i("mCountDownTimer", "onFinish. to finish: " + (this.time_finish_begin - this.time_start) + " to finish_end: " + (this.time_finish_end - this.time_finish_begin));
            this.mCheckResult.onSuccess();
        }
        AppMethodBeat.o(123161);
    }

    private boolean cameraStateControl(int i) {
        AppMethodBeat.i(123162);
        Camera camera = ProcessManager.cameraWorker().mCamera;
        Parameters parameters;
        if (i == 0) {
            try {
                parameters = camera.getParameters();
                parameters.setAutoWhiteBalanceLock(true);
                camera.setParameters(parameters);
            } catch (Exception e) {
                YTException.report(e);
                AppMethodBeat.o(123162);
                return false;
            }
        } else if (i == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            parameters = camera.getParameters();
            try {
                int exposureCompensation = parameters.getExposureCompensation();
                long currentTimeMillis2 = System.currentTimeMillis();
                YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISObackup((double) exposureCompensation);
                long currentTimeMillis3 = System.currentTimeMillis();
                int minExposureCompensation = parameters.getMinExposureCompensation();
                long currentTimeMillis4 = System.currentTimeMillis();
                parameters.setExposureCompensation(minExposureCompensation);
                long currentTimeMillis5 = System.currentTimeMillis();
                camera.setParameters(parameters);
                long currentTimeMillis6 = System.currentTimeMillis();
                long nanoTime = System.nanoTime() / 1000;
                Timeval timeval = new Timeval(nanoTime / 1000000, (int) (nanoTime % 1000000));
                nanoTime = System.currentTimeMillis();
                YTAGReflectLiveCheckJNIInterface.getInstance().FRSetISOchangeTime(timeval);
                long currentTimeMillis7 = System.currentTimeMillis();
                YTAGReflectLiveCheckJNIInterface.getInstance().FRSetDoingDelayCalc(true);
                long currentTimeMillis8 = System.currentTimeMillis();
                String str = "mCountDownTimer";
                YTLogger.i(str, "[ReflectController.cameraStateControl] t2: " + (currentTimeMillis2 - currentTimeMillis));
                YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t3: " + (currentTimeMillis3 - currentTimeMillis2));
                YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t4: " + (currentTimeMillis4 - currentTimeMillis3));
                YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t5: " + (currentTimeMillis5 - currentTimeMillis4));
                YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t6: " + (currentTimeMillis6 - currentTimeMillis5));
                YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t7: " + (nanoTime - currentTimeMillis6));
                YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t8: " + (currentTimeMillis7 - nanoTime));
                YTLogger.i("mCountDownTimer", "[ReflectController.cameraStateControl] t9: " + (currentTimeMillis8 - currentTimeMillis7));
            } catch (Exception e2) {
                AppMethodBeat.o(123162);
                return false;
            }
        } else if (i == 2) {
            parameters = camera.getParameters();
            parameters.setExposureCompensation((int) YTAGReflectLiveCheckJNIInterface.getInstance().FRGetISObackup());
            parameters.setAutoWhiteBalanceLock(false);
            camera.setParameters(parameters);
        }
        AppMethodBeat.o(123162);
        return true;
    }

    private void onPreviewFrameReceived(byte[] bArr, Camera camera) {
        AppMethodBeat.i(123163);
        int desiredPreviewWidth = ProcessManager.cameraWorker().getDesiredPreviewWidth();
        int desiredPreviewHeight = ProcessManager.cameraWorker().getDesiredPreviewHeight();
        if (this.mState == 0) {
            int i = this.mConfigBegin - 3;
            int i2 = this.mConfigEnd + 3;
            int i3 = this.mFrame;
            YTLogger.d(TAG, "onPreviewFrameReceived. beginFrame: " + i + " endFrame: " + i2 + " currentFrame: " + i3);
            if (i3 > i && i3 < i2) {
                long currentTimeMillis = System.currentTimeMillis();
                YTLogger.d(TAG, "onPreviewFrameReceived. insertYuv and time");
                systemTime = currentTimeMillis;
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushYuv(bArr, desiredPreviewWidth, desiredPreviewHeight);
                YTAGReflectLiveCheckJNIInterface.getInstance().FRPushCaptureTime(JNIUtils.getTimeval());
            }
            AppMethodBeat.o(123163);
            return;
        }
        if (this.mState == 1) {
            YTLogger.d(TAG, "put IOS timeval ");
            YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOImgYuv(bArr, desiredPreviewWidth, desiredPreviewHeight);
            YTAGReflectLiveCheckJNIInterface.getInstance().FRPushISOCaptureTime(JNIUtils.getTimeval());
        }
        AppMethodBeat.o(123163);
    }
}
