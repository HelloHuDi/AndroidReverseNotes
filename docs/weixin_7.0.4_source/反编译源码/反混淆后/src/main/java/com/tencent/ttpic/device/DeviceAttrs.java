package com.tencent.ttpic.device;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.model.SizeI;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class DeviceAttrs {
    public static final String ACTION_CHECK_ONLINE_UPDATE_FINISH = "action_check_online_update_finish";
    public static final int CAMERASDK_FAILED_THRESHOLD = 4;
    public static final int DEGREE_0 = 0;
    public static final int DEGREE_180 = 180;
    public static final int DEGREE_270 = 270;
    public static final int DEGREE_90 = 90;
    public static final int DEGREE_INVALIDATE = -1;
    public static final Boolean ENABLE_LOG = Boolean.FALSE;
    public static final int ENABLE_PERFORMANCE_MONITOR_THRESHOLD = 604800000;
    private static final DeviceAttrs INSTANCE = new DeviceAttrs();
    public static final String KEY_CAMERASDK_DISABLE = "pref_camerasdk_disable";
    public static final String KEY_CAMERASDK_FAILED_TIMES = "pref_camerasdk_open_failed_times";
    public static final String KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME = "enable_performance_monitor_begin_time";
    public static final String KEY_NEED_PARSE_XML = "is_need_parse_xml";
    public static final String KEY_URL_VALUE = "black_list_url";
    public static final String KEY_VERSION = "xml_version";
    public static final Boolean PARSE_XML_DEBUG_MODE = Boolean.FALSE;
    private static final String TAG = DeviceAttrs.class.getSimpleName();
    private static final Boolean TEST_URL = Boolean.FALSE;
    private static final String XML_FILE_NAME = "phone_attrs_config.dat";
    private static final String ZIP_FILE_NAME = "phone_attrs_config.zip";
    private static final String backCamCannotRotateKey = "backCamCannotRotate";
    private static final String backExposureStepOneKey = "backExposureStepOne";
    private static final String backFlashModeExceptionKey = "backFlashModeException";
    private static final String backFlashNoAutoKey = "backFlashNoAuto";
    private static final String backFlashNoOnKey = "backFlashNoOn";
    private static final String backFlashNoTorchKey = "backFlashNoTorch";
    private static final String beBlurredPicAfterTakePicKey = "beBlurredPicAfterTakePic";
    private static final String beBlurredPreviewAfterTakePicKey = "beBlurredPreviewAfterTakePic";
    private static final String cannotFlashWhileAutoFocusKey = "cannotFlashWhileAutoFocus";
    private static final String cannotFlashWhileFlashOnKey = "cannotFlashWhileFlashOn";
    private static final String cannotRotatePreviewKey = "cannotRotatePreview";
    private static final String deviceJpegDisableKey = "deviceJpegDisable";
    private static final String disableAutoFocusDoubleKey = "disableAutoFocusDouble";
    private static final String disableBackExposureKey = "disableBackExposure";
    private static final String disableBackFlashModeKey = "disableBackFlashMode";
    private static final String disableCameraSDKKey = "disableCameraSDK";
    private static final String disableCameraVideoKey = "disableCameraVideo";
    private static final String disableFaceDetectionKey = "disableFaceDetection";
    private static final String disableFocusModeContinuousPictureKey = "disableFocusModeContinuousPicture";
    private static final String disableFocusModeKey = "disableFocusMode";
    private static final String disableFrontCameraKey = "disableFrontCamera";
    private static final String disableFrontExposureKey = "disableFrontExposure";
    private static final String disableGridCaptureKey = "disableGridCapture";
    private static final String disableLiteEditorKey = "disableLiteEditor";
    private static final String disableMultiPreviewKey = "disableMultiPreview";
    private static final String disableVideoTransformKey = "disableVideoTransform";
    private static final String enableFastCapture4BackCameraKey = "enableFastCapture4BackCamera";
    private static final String enableFastCapture4FrontCameraKey = "enableFastCapture4FrontCamera";
    private static final String enablePerformanceMonitorKey = "enablePerformanceMonitor";
    private static final String es_GL_EXT_shader_framebuffer_fetch_key = "es_GL_EXT_shader_framebuffer_fetch";
    private static final String frontCamCannotRotateKey = "frontCamCannotRotate";
    private static final String frontCamFlipHKey = "frontCamFlipH";
    private static final String frontExposureStepOneKey = "frontExposureStepOne";
    private static final String frontFlashModeExceptionKey = "frontFlashModeException";
    private static final String frontFlashNoAutoKey = "frontFlashNoAuto";
    private static final String int_backCamRotate0Key = "int_backCamRotate0";
    private static final String int_backCamRotate180Key = "int_backCamRotate180";
    private static final String int_backCamRotate270Key = "int_backCamRotate270";
    private static final String int_backCamRotate90Key = "int_backCamRotate90";
    private static final String int_backExifRotate0Key = "int_backExifRotate0";
    private static final String int_backExifRotate180Key = "int_backExifRotate180";
    private static final String int_backExifRotate270Key = "int_backExifRotate270";
    private static final String int_backExifRotate90Key = "int_backExifRotate90";
    private static final String int_frontCamRotate0Key = "int_frontCamRotate0";
    private static final String int_frontCamRotate180Key = "int_frontCamRotate180";
    private static final String int_frontCamRotate270Key = "int_frontCamRotate270";
    private static final String int_frontCamRotate90Key = "int_frontCamRotate90";
    private static final String int_frontExifRotate0Key = "int_frontExifRotate0";
    private static final String int_frontExifRotate180Key = "int_frontExifRotate180";
    private static final String int_frontExifRotate270Key = "int_frontExifRotate270";
    private static final String int_frontExifRotate90Key = "int_frontExifRotate90";
    private static final String readCamNumExceptionKey = "readCamNumException";
    private static final String readMaxNumFocusAreasAbnormalKey = "readMaxNumFocusAreasAbnormal";
    private static final String readMaxNumMeteringAreasAbnormalKey = "readMaxNumMeteringAreasAbnormal";
    private static final String sReleaseURL = "http://xiangji.qq.com/services/cameraCoreSvr.php";
    private static final String sTestURL = "http://test.xiangji.qq.com/services/cameraCoreSvr.php";
    private static final String str_backPictureSize43Key = "str_backPictureSize43";
    private static final String str_backPreviewSize169Key = "str_backPreviewSize169";
    private static final String str_backPreviewSize43Key = "str_backPreviewSize43";
    private static final String str_deviceSocInfoKey = "str_deviceSocInfo";
    private static final String str_frontPictureSize43Key = "str_frontPictureSize43";
    private static final String str_frontPreviewSize169Key = "str_frontPreviewSize169";
    private static final String str_frontPreviewSize43Key = "str_frontPreviewSize43";
    private static final String str_recordVideoSizeKey = "str_recordVideoSize";
    private static final String str_videoPreviewFpsKey = "str_videoPreview720Fps";
    private static final String useNewPreviewKey = "useNewPreview";
    private boolean backCamCannotRotate = false;
    public boolean backExposureStepOne = false;
    public boolean backFlashModeException = false;
    public boolean backFlashNoAuto = false;
    public boolean backFlashNoOn = false;
    public boolean backFlashNoTorch = true;
    public boolean beBlurredPicAfterTakePic = false;
    public boolean beBlurredPreviewAfterTakePic = false;
    private boolean cannotFlashWhileAutoFocus = false;
    private boolean cannotFlashWhileFlashOn = false;
    private boolean cannotRotatePreview = false;
    public boolean deviceJpegDisable;
    public boolean disableAutoFocusDouble = false;
    public boolean disableBackCamera = false;
    public boolean disableBackExposure = false;
    public boolean disableBackFlashMode = false;
    public boolean disableCameraSDK = false;
    public boolean disableCameraVideo = false;
    public boolean disableFaceDetection = false;
    public boolean disableFocusMode = false;
    public boolean disableFocusModeContinuousPicture = false;
    public boolean disableFrontCamera = false;
    public boolean disableFrontExposure = false;
    public boolean disableLiteEditor = false;
    public boolean enableFastCapture4BackCamera = false;
    public boolean enableFastCapture4FrontCamera = false;
    public boolean enablePerformanceMonitor = false;
    public boolean es_GL_EXT_shader_framebuffer_fetch;
    private boolean frontCamCannotRotate = false;
    public boolean frontCamFlipH = false;
    public boolean frontExposureStepOne = false;
    public boolean frontFlashModeException = false;
    public boolean frontFlashNoAuto = false;
    public int int_backCamRotate0 = -1;
    public int int_backCamRotate180 = -1;
    public int int_backCamRotate270 = -1;
    public int int_backCamRotate90 = -1;
    public int int_backExifRotate0 = -1;
    public int int_backExifRotate180 = -1;
    public int int_backExifRotate270 = -1;
    public int int_backExifRotate90 = -1;
    public int int_frontCamRotate0 = -1;
    public int int_frontCamRotate180 = -1;
    public int int_frontCamRotate270 = -1;
    public int int_frontCamRotate90 = -1;
    public int int_frontExifRotate0 = -1;
    public int int_frontExifRotate180 = -1;
    public int int_frontExifRotate270 = -1;
    public int int_frontExifRotate90 = -1;
    private String mBuildInFileDir;
    private SharedPreferences mCameraMatchPref;
    private Context mContext;
    private List<String> mFastCaptureKeys;
    private List<String> mFastCaptureOnValues;
    private String mPrevUrl = "";
    private String mRequestUrl;
    private String mSignature;
    public boolean readCamNumException = false;
    private boolean readMaxNumFocusAreasAbnormal = false;
    private boolean readMaxNumMeteringAreasAbnormal = false;
    public boolean serverJpegEnable = true;
    public String str_backPictureSize43;
    public String str_backPreviewSize169;
    public String str_backPreviewSize43;
    public String str_deviceSocInfo;
    public String str_frontPictureSize43;
    public String str_frontPreviewSize169;
    public String str_frontPreviewSize43;
    public String str_recordVideoSize;
    public String str_videoPreview720Fps;

    public interface UpdateListener {
        void onFailed(String str);

        void onSuccess(String str);
    }

    static /* synthetic */ void access$600(DeviceAttrs deviceAttrs, String str) {
        AppMethodBeat.m2504i(49829);
        deviceAttrs.parseCurrentAttrsXML(str);
        AppMethodBeat.m2505o(49829);
    }

    static /* synthetic */ void access$700(DeviceAttrs deviceAttrs) {
        AppMethodBeat.m2504i(49830);
        deviceAttrs.loadAttrsFromPref();
        AppMethodBeat.m2505o(49830);
    }

    static /* synthetic */ void access$800(DeviceAttrs deviceAttrs) {
        AppMethodBeat.m2504i(49831);
        deviceAttrs.logAttrsValues();
        AppMethodBeat.m2505o(49831);
    }

    static {
        AppMethodBeat.m2504i(49832);
        AppMethodBeat.m2505o(49832);
    }

    public static DeviceAttrs getInstance() {
        return INSTANCE;
    }

    private DeviceAttrs() {
        AppMethodBeat.m2504i(49804);
        this.mRequestUrl = TEST_URL.booleanValue() ? sTestURL : sReleaseURL;
        this.mFastCaptureKeys = new ArrayList();
        this.mFastCaptureOnValues = new ArrayList();
        AppMethodBeat.m2505o(49804);
    }

    public void init(Context context, String str) {
        AppMethodBeat.m2504i(49805);
        LogUtils.m50207i(TAG, "[init] + BEGIN");
        long currentTimeMillis = System.currentTimeMillis();
        this.mContext = context;
        this.mSignature = str;
        if (context.getFilesDir() != null) {
            this.mBuildInFileDir = context.getFilesDir().toString() + "/";
        }
        this.mCameraMatchPref = this.mContext.getSharedPreferences(getCameraPrefName(this.mContext), 0);
        if (this.mCameraMatchPref != null) {
            boolean z = this.mCameraMatchPref.getBoolean(KEY_NEED_PARSE_XML, true);
            String deviceName = DeviceInstance.getInstance().getDeviceName();
            LogUtils.m50199d(TAG, "[FastCapture][init] deviceName = ".concat(String.valueOf(deviceName)));
            if (z) {
                String parseCameraAttrsFile = DeviceParser.parseCameraAttrsFile(this.mContext, XML_FILE_NAME, deviceName, this.mSignature);
                if (parseCameraAttrsFile != null) {
                    parseCurrentAttrsXML(parseCameraAttrsFile);
                }
            }
            loadAttrsFromPref();
            logAttrsValues();
        }
        LogUtils.m50207i(TAG, "[init] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(49805);
    }

    public void update(String str, UpdateListener updateListener) {
        AppMethodBeat.m2504i(49806);
        String deviceName = DeviceInstance.getInstance().getDeviceName();
        LogUtils.m50199d(TAG, "[update] deviceName = ".concat(String.valueOf(deviceName)));
        deviceName = DeviceParser.parseCameraAttrsFile(this.mContext, str, deviceName, this.mSignature);
        LogUtils.m50199d(TAG, "[update] source: ".concat(String.valueOf(deviceName)));
        if (deviceName != null) {
            parseCurrentAttrsXML(deviceName);
        }
        loadAttrsFromPref();
        logAttrsValues();
        if (updateListener != null) {
            updateListener.onSuccess(str + ", parse and reload success");
        }
        Intent intent = new Intent();
        intent.setAction(ACTION_CHECK_ONLINE_UPDATE_FINISH);
        if (this.mContext != null) {
            this.mContext.sendBroadcast(intent);
        }
        AppMethodBeat.m2505o(49806);
    }

    public void checkOnlineUpdate(String str, UpdateListener updateListener) {
        AppMethodBeat.m2504i(49807);
        LogUtils.m50207i(TAG, "[checkOnlineUpdate] + BEGIN, downloadUrl = ".concat(String.valueOf(str)));
        String str2 = this.mBuildInFileDir + ZIP_FILE_NAME;
        String string = this.mCameraMatchPref.getString(KEY_URL_VALUE, null);
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(string)) {
            if (updateListener != null) {
                updateListener.onFailed(str + ", this url has been downloaded, no need check update!");
            }
        } else if (DeviceUpdate.httpDownloadFile(str, str2)) {
            string = DeviceUpdate.unZip(str2, this.mBuildInFileDir);
            if (TextUtils.isEmpty(string)) {
                updateListener.onFailed(str + ", download success, but unZip failed");
            } else {
                LogUtils.m50199d(TAG, "[checkOnlineUpdate] storageName = " + str2 + ", mBuildInFileDir = " + this.mBuildInFileDir);
                Editor edit = this.mCameraMatchPref.edit();
                edit.putString(KEY_URL_VALUE, str);
                edit.apply();
                str2 = DeviceParser.parseCameraAttrsFile(this.mContext, string, DeviceInstance.getInstance().getDeviceName(), this.mSignature);
                LogUtils.m50199d(TAG, "[checkOnlineUpdate] source = ".concat(String.valueOf(str2)));
                if (str2 != null) {
                    parseCurrentAttrsXML(str2);
                }
                loadAttrsFromPref();
                logAttrsValues();
                if (updateListener != null) {
                    updateListener.onSuccess(str + ", download and parse success");
                }
                Intent intent = new Intent();
                intent.setAction(ACTION_CHECK_ONLINE_UPDATE_FINISH);
                this.mContext.sendBroadcast(intent);
            }
        } else {
            updateListener.onFailed(str + ", download failed!");
        }
        LogUtils.m50207i(TAG, "[checkOnlineUpdate] + END");
        AppMethodBeat.m2505o(49807);
    }

    public void checkVersion(String str, String str2, String str3, UpdateListener updateListener) {
        AppMethodBeat.m2504i(49808);
        LogUtils.m50207i(TAG, "[checkVersion] + BEGIN");
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final UpdateListener updateListener2 = updateListener;
        new Thread(new Runnable() {
            public void run() {
                boolean z = true;
                AppMethodBeat.m2504i(49803);
                String string = DeviceAttrs.this.mCameraMatchPref.getString(DeviceAttrs.KEY_VERSION, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                LogUtils.m50199d(DeviceAttrs.TAG, "[checkVersion] currentVer = ".concat(String.valueOf(string)));
                string = DeviceUpdate.checkConfigVersion(DeviceAttrs.this.mRequestUrl, str4, string, str5, str6);
                LogUtils.m50199d(DeviceAttrs.TAG, "[checkVersion] jsonStr = ".concat(String.valueOf(string)));
                if (TextUtils.isEmpty(string)) {
                    AppMethodBeat.m2505o(49803);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    string = jSONObject.getString("ret");
                    LogUtils.m50199d(DeviceAttrs.TAG, "[checkVersion] retStr = ".concat(String.valueOf(string)));
                    if (string.equals("1")) {
                        string = jSONObject.getString("camCoreConfUrl");
                        LogUtils.m50199d(DeviceAttrs.TAG, "[checkVersion] urlStr = ".concat(String.valueOf(string)));
                        String string2 = jSONObject.getString("curCamCoreVersion");
                        LogUtils.m50199d(DeviceAttrs.TAG, "[checkVersion] verStr = ".concat(String.valueOf(string2)));
                        String str = DeviceAttrs.this.mBuildInFileDir + DeviceAttrs.ZIP_FILE_NAME;
                        if (DeviceUpdate.httpDownloadFile(string, str)) {
                            string = DeviceUpdate.unZip(str, DeviceAttrs.this.mBuildInFileDir);
                            if (!TextUtils.isEmpty(string)) {
                                LogUtils.m50199d(DeviceAttrs.TAG, "[checkVersion] unZipfilePath = ".concat(String.valueOf(string)));
                                Editor edit = DeviceAttrs.this.mCameraMatchPref.edit();
                                edit.putString(DeviceAttrs.KEY_VERSION, string2);
                                edit.apply();
                                string = DeviceParser.parseCameraAttrsFile(DeviceAttrs.this.mContext, string, DeviceInstance.getInstance().getDeviceName(), DeviceAttrs.this.mSignature);
                                if (string != null) {
                                    DeviceAttrs.access$600(DeviceAttrs.this, string);
                                }
                                DeviceAttrs.access$700(DeviceAttrs.this);
                                DeviceAttrs.access$800(DeviceAttrs.this);
                                if (updateListener2 != null) {
                                    updateListener2.onSuccess(DeviceAttrs.this.mRequestUrl + ", download and parse success");
                                }
                                Intent intent = new Intent();
                                intent.setAction(DeviceAttrs.ACTION_CHECK_ONLINE_UPDATE_FINISH);
                                DeviceAttrs.this.mContext.sendBroadcast(intent);
                            }
                        }
                    }
                    DeviceAttrs deviceAttrs = DeviceAttrs.this;
                    if (jSONObject.optInt("nativeJpegEnable", 1) != 1) {
                        z = false;
                    }
                    deviceAttrs.serverJpegEnable = z;
                    AppMethodBeat.m2505o(49803);
                } catch (JSONException e) {
                    LogUtils.m50202e(DeviceAttrs.TAG, "checkVersion JSONException e = ".concat(String.valueOf(e)));
                    AppMethodBeat.m2505o(49803);
                }
            }
        }).start();
        LogUtils.m50207i(TAG, "[checkVersion] + END");
        AppMethodBeat.m2505o(49808);
    }

    public boolean updateCameraParametersFastCapture(Parameters parameters, boolean z, boolean z2) {
        AppMethodBeat.m2504i(49809);
        boolean z3 = false;
        if (isInFastCaptureWhiteList(z, z2)) {
            initFastCaptureKeyValue();
            z3 = openFastCaptureMode(parameters);
            LogUtils.m50199d(TAG, "[updateCameraParametersFastCapture] this camera id in white list YES, OPEN fast mode, isFrontCamera = " + z + ", updated = " + z3);
        } else {
            LogUtils.m50199d(TAG, "[updateCameraParametersFastCapture] this camera id in white list NO, do NOTHING, isFrontCamera = ".concat(String.valueOf(z)));
        }
        AppMethodBeat.m2505o(49809);
        return z3;
    }

    public boolean updateCameraParametersFastCapture(Parameters parameters, boolean z) {
        AppMethodBeat.m2504i(49810);
        boolean updateCameraParametersFastCapture = updateCameraParametersFastCapture(parameters, z, false);
        AppMethodBeat.m2505o(49810);
        return updateCameraParametersFastCapture;
    }

    public boolean isCameraSDKDisable() {
        boolean z = false;
        AppMethodBeat.m2504i(49811);
        if (this.mCameraMatchPref != null) {
            z = this.mCameraMatchPref.getBoolean(KEY_CAMERASDK_DISABLE, false);
        }
        AppMethodBeat.m2505o(49811);
        return z;
    }

    public String getPreviousUrl() {
        AppMethodBeat.m2504i(49812);
        String str = "";
        if (this.mCameraMatchPref != null) {
            str = this.mCameraMatchPref.getString(KEY_URL_VALUE, "");
        }
        AppMethodBeat.m2505o(49812);
        return str;
    }

    public SizeI getRecordVideoSize(int i, int i2) {
        AppMethodBeat.m2504i(49813);
        SizeI sizeI = new SizeI(i, i2);
        String str = getInstance().str_recordVideoSize;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\*");
            if (split.length < 2) {
                AppMethodBeat.m2505o(49813);
                return sizeI;
            }
            try {
                SizeI sizeI2 = new SizeI(Integer.parseInt(split[1]), Integer.parseInt(split[0]));
                AppMethodBeat.m2505o(49813);
                return sizeI2;
            } catch (Exception e) {
                LogUtils.m50202e(TAG, "Parse record size error!");
            }
        }
        AppMethodBeat.m2505o(49813);
        return sizeI;
    }

    public void setRecordVideoSize(int i, int i2) {
        AppMethodBeat.m2504i(49814);
        if (this.mCameraMatchPref != null) {
            this.mCameraMatchPref.edit().putString(str_recordVideoSizeKey, i2 + "*" + i).apply();
        }
        AppMethodBeat.m2505o(49814);
    }

    public long getMonitorEnableTime() {
        long j = 0;
        AppMethodBeat.m2504i(49815);
        if (this.mCameraMatchPref != null) {
            j = this.mCameraMatchPref.getLong(KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME, 0);
        }
        AppMethodBeat.m2505o(49815);
        return j;
    }

    public void setMonitorEnableTime(long j) {
        AppMethodBeat.m2504i(49816);
        if (this.mCameraMatchPref != null) {
            this.mCameraMatchPref.edit().putLong(KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME, j).apply();
        }
        AppMethodBeat.m2505o(49816);
    }

    public void clearAllPreference() {
        AppMethodBeat.m2504i(49817);
        if (this.mCameraMatchPref != null) {
            this.mCameraMatchPref.edit().clear().apply();
        }
        AppMethodBeat.m2505o(49817);
    }

    public boolean isNativeJpegCompressEnable() {
        AppMethodBeat.m2504i(49818);
        if (!getInstance().serverJpegEnable || getInstance().deviceJpegDisable) {
            AppMethodBeat.m2505o(49818);
            return false;
        }
        AppMethodBeat.m2505o(49818);
        return true;
    }

    public boolean isEnableEXTShaderFramebufferFetch() {
        AppMethodBeat.m2504i(49819);
        boolean z = getInstance().es_GL_EXT_shader_framebuffer_fetch;
        AppMethodBeat.m2505o(49819);
        return z;
    }

    private String getCameraPrefName(Context context) {
        AppMethodBeat.m2504i(49820);
        String str = context.getPackageName() + "_preferences_camera_adapter";
        AppMethodBeat.m2505o(49820);
        return str;
    }

    private boolean openFastCaptureMode(Parameters parameters) {
        boolean z = false;
        AppMethodBeat.m2504i(49821);
        if (!(parameters == null || this.mFastCaptureKeys == null || this.mFastCaptureOnValues == null)) {
            int i = 0;
            boolean z2 = false;
            while (i < this.mFastCaptureKeys.size() && i < this.mFastCaptureOnValues.size()) {
                String str = (String) this.mFastCaptureKeys.get(i);
                if (parameters.get(str) != null) {
                    parameters.set(str, (String) this.mFastCaptureOnValues.get(i));
                    z2 = true;
                }
                i++;
            }
            z = z2;
        }
        AppMethodBeat.m2505o(49821);
        return z;
    }

    private void initFastCaptureKeyValue() {
        int i = 0;
        AppMethodBeat.m2504i(49822);
        if (this.mFastCaptureKeys != null && this.mFastCaptureOnValues != null && this.mFastCaptureKeys.isEmpty() && this.mFastCaptureOnValues.isEmpty()) {
            this.mFastCaptureKeys.clear();
            this.mFastCaptureOnValues.clear();
            try {
                JSONObject parseFastCaptureFile = parseFastCaptureFile();
                if (parseFastCaptureFile != null) {
                    JSONArray jSONArray = parseFastCaptureFile.getJSONArray("key");
                    if (jSONArray != null) {
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            this.mFastCaptureKeys.add(jSONArray.getString(i2));
                        }
                    }
                    JSONArray jSONArray2 = parseFastCaptureFile.getJSONArray("value");
                    if (jSONArray2 != null) {
                        while (i < jSONArray2.length()) {
                            this.mFastCaptureOnValues.add(jSONArray2.getString(i));
                            i++;
                        }
                    }
                }
                AppMethodBeat.m2505o(49822);
                return;
            } catch (JSONException e) {
            }
        }
        AppMethodBeat.m2505o(49822);
    }

    private boolean isInFastCaptureWhiteList(boolean z) {
        AppMethodBeat.m2504i(49823);
        boolean isInFastCaptureWhiteList = isInFastCaptureWhiteList(z, false);
        AppMethodBeat.m2505o(49823);
        return isInFastCaptureWhiteList;
    }

    private boolean isInFastCaptureWhiteList(boolean z, boolean z2) {
        AppMethodBeat.m2504i(49824);
        boolean z3;
        if (!z) {
            z3 = getInstance().enableFastCapture4BackCamera;
            AppMethodBeat.m2505o(49824);
            return z3;
        } else if (z2) {
            AppMethodBeat.m2505o(49824);
            return true;
        } else {
            z3 = getInstance().enableFastCapture4FrontCamera;
            AppMethodBeat.m2505o(49824);
            return z3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0029 A:{SYNTHETIC, Splitter:B:10:0x0029} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private JSONObject parseFastCaptureFile() {
        InputStream open;
        Throwable e;
        Throwable th;
        JSONObject jSONObject;
        InputStream inputStream = null;
        AppMethodBeat.m2504i(49825);
        CharSequence charSequence = "";
        try {
            if (PARSE_XML_DEBUG_MODE.booleanValue()) {
                open = this.mContext.getAssets().open("camera_fast_capture.json");
                try {
                    charSequence = IOUtils.toString(open);
                } catch (Exception e2) {
                    e = e2;
                }
            } else {
                charSequence = DeviceParser.parseFastCaptureFile(this.mContext, "camera_fast_capture.dat", this.mSignature);
                open = null;
            }
            if (open != null) {
                IOUtils.closeQuietly(open);
            }
        } catch (Exception e3) {
            e = e3;
            open = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                IOUtils.closeQuietly(inputStream);
            }
            AppMethodBeat.m2505o(49825);
            throw th;
        }
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                jSONObject = new JSONObject(charSequence);
            } catch (JSONException e4) {
            }
            AppMethodBeat.m2505o(49825);
            return jSONObject;
        }
        jSONObject = null;
        AppMethodBeat.m2505o(49825);
        return jSONObject;
        try {
            LogUtils.m50206e(e);
            if (open != null) {
                IOUtils.closeQuietly(open);
            }
            if (TextUtils.isEmpty(charSequence)) {
            }
            jSONObject = null;
            AppMethodBeat.m2505o(49825);
            return jSONObject;
        } catch (Throwable th3) {
            th = th3;
            inputStream = open;
            if (inputStream != null) {
            }
            AppMethodBeat.m2505o(49825);
            throw th;
        }
    }

    private void parseCurrentAttrsXML(String str) {
        AppMethodBeat.m2504i(49826);
        LogUtils.m50207i(TAG, "[parseCurrentAttrsXML] + BEGIN");
        if (TextUtils.isEmpty(str)) {
            LogUtils.m50202e(TAG, "[parseCurrentAttrsXML] sourceString is empty");
            AppMethodBeat.m2505o(49826);
            return;
        }
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            Editor edit = this.mCameraMatchPref.edit();
            Boolean bool = Boolean.FALSE;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        String name = newPullParser.getName();
                        String deviceName = DeviceInstance.getInstance().getDeviceName();
                        String str2 = deviceName + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
                        if (!name.equals(deviceName)) {
                            if (!str2.startsWith(name)) {
                                break;
                            }
                            LogUtils.m50199d(TAG, "parseCurrentAttrsXML myPhoneType = " + deviceName + ", subTagName = " + str2);
                            int attributeCount = newPullParser.getAttributeCount();
                            for (eventType = 0; eventType < attributeCount; eventType++) {
                                str2 = newPullParser.getAttributeName(eventType);
                                String attributeValue = newPullParser.getAttributeValue(eventType);
                                if (str2.startsWith("int_")) {
                                    edit.putInt(str2, Integer.valueOf(Integer.parseInt(attributeValue)).intValue());
                                } else if (str2.startsWith("str_")) {
                                    edit.putString(str2, String.valueOf(attributeValue));
                                } else {
                                    edit.putBoolean(str2, Boolean.valueOf(Boolean.parseBoolean(attributeValue)).booleanValue());
                                }
                                LogUtils.m50207i(TAG, "parseCurrentAttrsXML(subNode) item[" + (eventType + 1) + "] name = " + str2 + ", value = " + attributeValue);
                            }
                            break;
                        }
                        LogUtils.m50199d(TAG, "parseCurrentAttrsXML myPhoneType = " + deviceName + ", subTagName = " + str2);
                        eventType = newPullParser.getAttributeCount();
                        for (int i = 0; i < eventType; i++) {
                            deviceName = newPullParser.getAttributeName(i);
                            str2 = newPullParser.getAttributeValue(i);
                            if (deviceName.startsWith("int_")) {
                                edit.putInt(deviceName, Integer.valueOf(Integer.parseInt(str2)).intValue());
                            } else if (deviceName.startsWith("str_")) {
                                edit.putString(deviceName, String.valueOf(str2));
                            } else {
                                edit.putBoolean(deviceName, Boolean.valueOf(Boolean.parseBoolean(str2)).booleanValue());
                            }
                            LogUtils.m50207i(TAG, "parseCurrentAttrsXML item[" + (i + 1) + "] name = " + deviceName + ", value = " + str2);
                        }
                        bool = Boolean.TRUE;
                        break;
                    default:
                        break;
                }
            }
            if (bool.booleanValue()) {
                edit.putBoolean(KEY_NEED_PARSE_XML, false);
                edit.apply();
            }
        } catch (XmlPullParserException e) {
            LogUtils.m50206e(e);
        } catch (IOException e2) {
            LogUtils.m50206e(e2);
        }
        LogUtils.m50207i(TAG, "[parseCurrentAttrsXML] + END");
        AppMethodBeat.m2505o(49826);
    }

    private void loadAttrsFromPref() {
        AppMethodBeat.m2504i(49827);
        LogUtils.m50207i(TAG, "[loadAttrsFromPref] + BEGIN");
        this.str_deviceSocInfo = this.mCameraMatchPref.getString(str_deviceSocInfoKey, "");
        this.disableCameraSDK = this.mCameraMatchPref.getBoolean(disableCameraSDKKey, false);
        if (this.disableCameraSDK) {
            this.mCameraMatchPref.edit().putBoolean(KEY_CAMERASDK_DISABLE, true).apply();
            LogUtils.m50207i(TAG, "set camerasdk disable flag true");
        }
        this.disableCameraVideo = this.mCameraMatchPref.getBoolean(disableCameraVideoKey, false);
        this.enablePerformanceMonitor = this.mCameraMatchPref.getBoolean(enablePerformanceMonitorKey, false);
        this.disableLiteEditor = this.mCameraMatchPref.getBoolean(disableLiteEditorKey, false);
        this.readCamNumException = this.mCameraMatchPref.getBoolean(readCamNumExceptionKey, false);
        this.disableFrontCamera = this.mCameraMatchPref.getBoolean(disableFrontCameraKey, false);
        this.str_frontPreviewSize43 = this.mCameraMatchPref.getString(str_frontPreviewSize43Key, null);
        this.str_frontPreviewSize169 = this.mCameraMatchPref.getString(str_frontPreviewSize169Key, null);
        this.str_backPreviewSize43 = this.mCameraMatchPref.getString(str_backPreviewSize43Key, null);
        this.str_backPreviewSize169 = this.mCameraMatchPref.getString(str_backPreviewSize169Key, null);
        this.str_videoPreview720Fps = this.mCameraMatchPref.getString(str_videoPreviewFpsKey, null);
        this.str_frontPictureSize43 = this.mCameraMatchPref.getString(str_frontPictureSize43Key, null);
        this.str_backPictureSize43 = this.mCameraMatchPref.getString(str_backPictureSize43Key, null);
        this.str_recordVideoSize = this.mCameraMatchPref.getString(str_recordVideoSizeKey, null);
        this.beBlurredPreviewAfterTakePic = this.mCameraMatchPref.getBoolean(beBlurredPreviewAfterTakePicKey, false);
        this.beBlurredPicAfterTakePic = this.mCameraMatchPref.getBoolean(beBlurredPicAfterTakePicKey, false);
        this.enableFastCapture4FrontCamera = this.mCameraMatchPref.getBoolean(enableFastCapture4FrontCameraKey, false);
        this.enableFastCapture4BackCamera = this.mCameraMatchPref.getBoolean(enableFastCapture4BackCameraKey, false);
        this.disableBackFlashMode = this.mCameraMatchPref.getBoolean(disableBackFlashModeKey, false);
        this.backFlashModeException = this.mCameraMatchPref.getBoolean(backFlashModeExceptionKey, false);
        this.frontFlashModeException = this.mCameraMatchPref.getBoolean(frontFlashModeExceptionKey, false);
        this.backFlashNoOn = this.mCameraMatchPref.getBoolean(backFlashNoOnKey, false);
        this.backFlashNoAuto = this.mCameraMatchPref.getBoolean(backFlashNoAutoKey, false);
        this.backFlashNoTorch = this.mCameraMatchPref.getBoolean(backFlashNoTorchKey, true);
        this.frontFlashNoAuto = this.mCameraMatchPref.getBoolean(frontFlashNoAutoKey, false);
        this.disableFocusMode = this.mCameraMatchPref.getBoolean(disableFocusModeKey, false);
        this.disableFocusModeContinuousPicture = this.mCameraMatchPref.getBoolean(disableFocusModeContinuousPictureKey, false);
        this.disableAutoFocusDouble = this.mCameraMatchPref.getBoolean(disableAutoFocusDoubleKey, false);
        this.disableFaceDetection = this.mCameraMatchPref.getBoolean(disableFaceDetectionKey, false);
        this.int_frontCamRotate0 = this.mCameraMatchPref.getInt(int_frontCamRotate0Key, -1);
        this.int_frontCamRotate90 = this.mCameraMatchPref.getInt(int_frontCamRotate90Key, -1);
        this.int_frontCamRotate180 = this.mCameraMatchPref.getInt(int_frontCamRotate180Key, -1);
        this.int_frontCamRotate270 = this.mCameraMatchPref.getInt(int_frontCamRotate270Key, -1);
        this.int_backCamRotate0 = this.mCameraMatchPref.getInt(int_backCamRotate0Key, -1);
        this.int_backCamRotate90 = this.mCameraMatchPref.getInt(int_backCamRotate90Key, -1);
        this.int_backCamRotate180 = this.mCameraMatchPref.getInt(int_backCamRotate180Key, -1);
        this.int_backCamRotate270 = this.mCameraMatchPref.getInt(int_backCamRotate270Key, -1);
        this.int_frontExifRotate0 = this.mCameraMatchPref.getInt(int_frontExifRotate0Key, -1);
        this.int_frontExifRotate90 = this.mCameraMatchPref.getInt(int_frontExifRotate90Key, -1);
        this.int_frontExifRotate180 = this.mCameraMatchPref.getInt(int_frontExifRotate180Key, -1);
        this.int_frontExifRotate270 = this.mCameraMatchPref.getInt(int_frontExifRotate270Key, -1);
        this.int_backExifRotate0 = this.mCameraMatchPref.getInt(int_backExifRotate0Key, -1);
        this.int_backExifRotate90 = this.mCameraMatchPref.getInt(int_backExifRotate90Key, -1);
        this.int_backExifRotate180 = this.mCameraMatchPref.getInt(int_backExifRotate180Key, -1);
        this.int_backExifRotate270 = this.mCameraMatchPref.getInt(int_backExifRotate270Key, -1);
        this.frontCamFlipH = this.mCameraMatchPref.getBoolean(frontCamFlipHKey, false);
        this.disableFrontExposure = this.mCameraMatchPref.getBoolean(disableFrontExposureKey, false);
        this.disableBackExposure = this.mCameraMatchPref.getBoolean(disableBackExposureKey, false);
        this.frontExposureStepOne = this.mCameraMatchPref.getBoolean(frontExposureStepOneKey, false);
        this.backExposureStepOne = this.mCameraMatchPref.getBoolean(backExposureStepOneKey, false);
        this.deviceJpegDisable = this.mCameraMatchPref.getBoolean(deviceJpegDisableKey, false);
        this.es_GL_EXT_shader_framebuffer_fetch = this.mCameraMatchPref.getBoolean(es_GL_EXT_shader_framebuffer_fetch_key, true);
        this.cannotFlashWhileAutoFocus = this.mCameraMatchPref.getBoolean(cannotFlashWhileAutoFocusKey, false);
        this.frontCamCannotRotate = this.mCameraMatchPref.getBoolean(frontCamCannotRotateKey, false);
        this.readMaxNumMeteringAreasAbnormal = this.mCameraMatchPref.getBoolean(readMaxNumMeteringAreasAbnormalKey, false);
        this.readMaxNumFocusAreasAbnormal = this.mCameraMatchPref.getBoolean(readMaxNumFocusAreasAbnormalKey, false);
        this.cannotRotatePreview = this.mCameraMatchPref.getBoolean(cannotRotatePreviewKey, false);
        this.cannotFlashWhileFlashOn = this.mCameraMatchPref.getBoolean(cannotFlashWhileFlashOnKey, false);
        this.backCamCannotRotate = this.mCameraMatchPref.getBoolean(backCamCannotRotateKey, false);
        LogUtils.m50207i(TAG, "[loadAttrsFromPref] + END");
        AppMethodBeat.m2505o(49827);
    }

    private void logAttrsValues() {
        AppMethodBeat.m2504i(49828);
        LogUtils.m50207i(TAG, "DeviceAttrs start-------------------------------------------------------------");
        LogUtils.m50207i(TAG, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
        LogUtils.m50199d(TAG, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
        LogUtils.m50207i(TAG, "DeviceAttrs disableCameraSDK = " + this.disableCameraSDK);
        LogUtils.m50207i(TAG, "DeviceAttrs disableCameraVideo = " + this.disableCameraVideo);
        LogUtils.m50207i(TAG, "DeviceAttrs enablePerformanceMonitor = " + this.enablePerformanceMonitor);
        LogUtils.m50207i(TAG, "DeviceAttrs disableLiteEditor = " + this.disableLiteEditor);
        LogUtils.m50207i(TAG, "DeviceAttrs readCamNumException = " + this.readCamNumException);
        LogUtils.m50207i(TAG, "DeviceAttrs disableFrontCamera = " + this.disableFrontCamera);
        LogUtils.m50207i(TAG, "DeviceAttrs beBlurredPreviewAfterTakePic = " + this.beBlurredPreviewAfterTakePic);
        LogUtils.m50207i(TAG, "DeviceAttrs beBlurredPicAfterTakePic = " + this.beBlurredPicAfterTakePic);
        LogUtils.m50207i(TAG, "DeviceAttrs enableFastCapture4FrontCamera = " + this.enableFastCapture4FrontCamera);
        LogUtils.m50207i(TAG, "DeviceAttrs enableFastCapture4BackCamera = " + this.enableFastCapture4BackCamera);
        LogUtils.m50207i(TAG, "DeviceAttrs str_videoPreview720Fps = " + this.str_videoPreview720Fps);
        LogUtils.m50207i(TAG, "DeviceAttrs str_frontPreviewSize43 = " + this.str_frontPreviewSize43);
        LogUtils.m50207i(TAG, "DeviceAttrs str_frontPreviewSize169 = " + this.str_frontPreviewSize169);
        LogUtils.m50207i(TAG, "DeviceAttrs str_backPreviewSize43 = " + this.str_backPreviewSize43);
        LogUtils.m50207i(TAG, "DeviceAttrs str_backPreviewSize169 = " + this.str_backPreviewSize169);
        LogUtils.m50207i(TAG, "DeviceAttrs str_frontPictureSize43 = " + this.str_frontPictureSize43);
        LogUtils.m50207i(TAG, "DeviceAttrs str_backPictureSize43 = " + this.str_backPictureSize43);
        LogUtils.m50207i(TAG, "DeviceAttrs str_recordVideoSize = " + this.str_recordVideoSize);
        LogUtils.m50207i(TAG, "DeviceAttrs disableBackFlashMode = " + this.disableBackFlashMode);
        LogUtils.m50207i(TAG, "DeviceAttrs frontFlashModeException = " + this.frontFlashModeException);
        LogUtils.m50207i(TAG, "DeviceAttrs backFlashModeException = " + this.backFlashModeException);
        LogUtils.m50207i(TAG, "DeviceAttrs backFlashNoOn = " + this.backFlashNoOn);
        LogUtils.m50207i(TAG, "DeviceAttrs backFlashNoAuto = " + this.backFlashNoAuto);
        LogUtils.m50207i(TAG, "DeviceAttrs backFlashNoTorch = " + this.backFlashNoTorch);
        LogUtils.m50207i(TAG, "DeviceAttrs frontFlashNoAuto = " + this.frontFlashNoAuto);
        LogUtils.m50207i(TAG, "DeviceAttrs disableFocusMode = " + this.disableFocusMode);
        LogUtils.m50207i(TAG, "DeviceAttrs disableFocusModeContinuousPicture = " + this.disableFocusModeContinuousPicture);
        LogUtils.m50207i(TAG, "DeviceAttrs disableAutoFocusDouble = " + this.disableAutoFocusDouble);
        LogUtils.m50207i(TAG, "DeviceAttrs disableFaceDetection = " + this.disableFaceDetection);
        LogUtils.m50207i(TAG, "DeviceAttrs int_frontCamRotate0 = " + this.int_frontCamRotate0);
        LogUtils.m50207i(TAG, "DeviceAttrs int_frontCamRotate90 = " + this.int_frontCamRotate90);
        LogUtils.m50207i(TAG, "DeviceAttrs int_frontCamRotate180 = " + this.int_frontCamRotate180);
        LogUtils.m50207i(TAG, "DeviceAttrs int_frontCamRotate270 = " + this.int_frontCamRotate270);
        LogUtils.m50207i(TAG, "DeviceAttrs int_backCamRotate0 = " + this.int_backCamRotate0);
        LogUtils.m50207i(TAG, "DeviceAttrs int_backCamRotate90 = " + this.int_backCamRotate90);
        LogUtils.m50207i(TAG, "DeviceAttrs int_backCamRotate180 = " + this.int_backCamRotate180);
        LogUtils.m50207i(TAG, "DeviceAttrs int_backCamRotate270 = " + this.int_backCamRotate270);
        LogUtils.m50207i(TAG, "DeviceAttrs int_frontExifRotate0 = " + this.int_frontExifRotate0);
        LogUtils.m50207i(TAG, "DeviceAttrs int_frontExifRotate90 = " + this.int_frontExifRotate90);
        LogUtils.m50207i(TAG, "DeviceAttrs int_frontExifRotate180 = " + this.int_frontExifRotate180);
        LogUtils.m50207i(TAG, "DeviceAttrs int_frontExifRotate270 = " + this.int_frontExifRotate270);
        LogUtils.m50207i(TAG, "DeviceAttrs int_backExifRotate0 = " + this.int_backExifRotate0);
        LogUtils.m50207i(TAG, "DeviceAttrs int_backExifRotate90 = " + this.int_backExifRotate90);
        LogUtils.m50207i(TAG, "DeviceAttrs int_backExifRotate180 = " + this.int_backExifRotate180);
        LogUtils.m50207i(TAG, "DeviceAttrs int_backExifRotate270 = " + this.int_backExifRotate270);
        LogUtils.m50207i(TAG, "DeviceAttrs frontCamFlipH = " + this.frontCamFlipH);
        LogUtils.m50207i(TAG, "DeviceAttrs disableFrontExposure = " + this.disableFrontExposure);
        LogUtils.m50207i(TAG, "DeviceAttrs disableBackExposure = " + this.disableBackExposure);
        LogUtils.m50207i(TAG, "DeviceAttrs frontExposureStepOne = " + this.frontExposureStepOne);
        LogUtils.m50207i(TAG, "DeviceAttrs backExposureStepOne = " + this.backExposureStepOne);
        LogUtils.m50207i(TAG, "DeviceAttrs serverJpegEnable = " + this.serverJpegEnable);
        LogUtils.m50207i(TAG, "DeviceAttrs deviceJpegDisable = " + this.deviceJpegDisable);
        LogUtils.m50207i(TAG, "DeviceAttrs cannotFlashWhileAutoFocus = " + this.cannotFlashWhileAutoFocus);
        LogUtils.m50207i(TAG, "DeviceAttrs frontCamCannotRotate = " + this.frontCamCannotRotate);
        LogUtils.m50207i(TAG, "DeviceAttrs readMaxNumMeteringAreasAbnormal = " + this.readMaxNumMeteringAreasAbnormal);
        LogUtils.m50207i(TAG, "DeviceAttrs readMaxNumFocusAreasAbnormal = " + this.readMaxNumFocusAreasAbnormal);
        LogUtils.m50207i(TAG, "DeviceAttrs cannotRotatePreview = " + this.cannotRotatePreview);
        LogUtils.m50207i(TAG, "DeviceAttrs cannotFlashWhileFlashOn = " + this.cannotFlashWhileFlashOn);
        LogUtils.m50207i(TAG, "DeviceAttrs backCamCannotRotate = " + this.backCamCannotRotate);
        LogUtils.m50207i(TAG, "DeviceAttrs end-------------------------------------------------------------");
        AppMethodBeat.m2505o(49828);
    }
}
