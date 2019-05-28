package com.tencent.ttpic.logic.watermark;

import android.media.ExifInterface;
import android.support.d.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.model.Audio2Text.FIFOList;
import com.tencent.ttpic.model.Audio2Text.LoopRepList;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.model.WMLogic;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicDataManager {
    public static final String ALTITUDE = "[altitude]";
    private static final String DATA_DEFAULT_LOCATION = "中国";
    private static final String DATA_DEFAULT_NO_NETWORK = "无网络";
    private static final String DATA_DEFAULT_TEMPERATURE = "0";
    private static final String DATA_DEFAULT_WEATHER = "晴";
    private static final String DATA_DEFAULT_WEATHER_TYPE = "";
    public static final String DATE = "[date]";
    public static final String DATE_D = "[date:D]";
    public static final String DATE_EEE = "[date:EEE]";
    public static final String DATE_EEEE = "[date:EEEE]";
    public static final String DATE_H = "[date:H]";
    public static final String DATE_H0 = "[date:H0]";
    public static final String DATE_H1 = "[date:H1]";
    public static final String DATE_HH = "[date:HH]";
    public static final String DATE_M = "[date:M]";
    public static final String DATE_M0 = "[date:M0]";
    public static final String DATE_M1 = "[date:M1]";
    public static final String DATE_MM = "[date:MM]";
    public static final String DATE_MMM = "[date:MMM]";
    public static final String DATE_MMMM = "[date:MMMM]";
    public static final String DATE_W = "[date:W]";
    public static final String DATE_Y0 = "[date:Y0]";
    public static final String DATE_Y1 = "[date:Y1]";
    public static final String DATE_Y2 = "[date:Y2]";
    public static final String DATE_Y3 = "[date:Y3]";
    public static final String DATE_YY = "[date:YY]";
    public static final String DATE_YYYY = "[date:YYYY]";
    public static final String DATE_a = "[date:a]";
    public static final String DATE_d = "[date:d]";
    public static final String DATE_d0 = "[date:d0]";
    public static final String DATE_d1 = "[date:d1]";
    public static final String DATE_dd = "[date:dd]";
    public static final String DATE_e = "[date:e]";
    public static final String DATE_h = "[date:h]";
    public static final String DATE_h0 = "[date:h0]";
    public static final String DATE_h1 = "[date:h1]";
    public static final String DATE_hh = "[date:hh]";
    public static final String DATE_m = "[date:m]";
    public static final String DATE_m0 = "[date:m0]";
    public static final String DATE_m1 = "[date:m1]";
    public static final String DATE_mm = "[date:mm]";
    public static final String DATE_s = "[date:s]";
    public static final String DATE_s0 = "[date:s0]";
    public static final String DATE_s1 = "[date:s1]";
    public static final String DATE_ss = "[date:ss]";
    public static final String DATE_w = "[date:w]";
    public static final String DATE_y0 = "[date:y0]";
    public static final String DATE_y1 = "[date:y1]";
    public static final String DATE_y2 = "[date:y2]";
    public static final String DATE_y3 = "[date:y3]";
    public static final String DATE_yy = "[date:yy]";
    public static final String DATE_yyyy = "[date:yyyy]";
    public static final String DB = "[db]";
    private static final int DECIBEL_UPDATE_INTERVAL = 500;
    public static final String LOCATION = "[location]";
    public static final Pattern PATTERN_NUMERICAL = Pattern.compile("-?\\d+");
    public static final Pattern PATTERN_SPEECHS = Pattern.compile("\\[speech:s-?\\d?\\]");
    public static final Pattern PATTERN_SPEECHW = Pattern.compile("\\[speech:w-?\\d?\\]");
    public static final String PIC_DATE_M0 = "[picDate:M0]";
    public static final String PIC_DATE_M1 = "[picDate:M1]";
    public static final String PIC_DATE_d0 = "[picDate:d0]";
    public static final String PIC_DATE_d1 = "[picDate:d1]";
    public static final String PIC_DATE_y0 = "[picDate:y0]";
    public static final String PIC_DATE_y1 = "[picDate:y1]";
    public static final String PIC_DATE_y2 = "[picDate:y2]";
    public static final String PIC_DATE_y3 = "[picDate:y3]";
    public static final String SPEECHS_ALL = "[speech:all]";
    public static final String SPEED = "[speed]";
    private static final String STRING_EMPTY = "";
    public static final String TEMPERATURE = "[temperature]";
    public static final String TEMPERATURE_0 = "[temperature_0]";
    public static final String TEMPERATURE_1 = "[temperature_1]";
    public static final String TEMPERATURE_s = "[temperature_s]";
    public static final String WEATHER = "[weather]";
    public static final String WEATHER_TYPE = "[weatherType]";
    private static LogicDataManager mInstance;
    private final String TAG = LogicDataManager.class.getSimpleName();
    private String mAltitude = DATA_DEFAULT_NO_NETWORK;
    private int mDecibel;
    private long mDecibelUpdateTimestamp = 0;
    private List<WMElement> mEditableWMElements = new ArrayList();
    private String mLocation = DATA_DEFAULT_LOCATION;
    private boolean mNeedDecibel = false;
    private String mPictureDate;
    private Map<String, LogicValueProvider> mProviderMap = new HashMap();
    private OnSilenceEventListener mSilenceEventListener;
    private String mTemperature = "0";
    private boolean mUseDecibelFromCameraRecorder = false;
    private int mVTSegmentCount;
    private int mVTSegmentTime;
    private int mVTSilenceTime;
    private List<String> mVoiceTextDup = new CopyOnWriteArrayList();
    private Queue<String> mVoiceTextQueue = new LinkedList();
    private String mWeather = DATA_DEFAULT_WEATHER;
    private String mWeatherType = "";

    public interface OnSilenceEventListener {
        void onSilenceTimeEvent();
    }

    interface LogicValueProvider {
        String getValue();
    }

    static /* synthetic */ String access$000(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83389);
        String timestamp = logicDataManager.getTimestamp();
        AppMethodBeat.o(83389);
        return timestamp;
    }

    static /* synthetic */ String access$100(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83390);
        String yyVar = logicDataManager.getyy();
        AppMethodBeat.o(83390);
        return yyVar;
    }

    static /* synthetic */ String access$1000(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83399);
        String w = logicDataManager.getW();
        AppMethodBeat.o(83399);
        return w;
    }

    static /* synthetic */ String access$1100(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83400);
        String dVar = logicDataManager.getd();
        AppMethodBeat.o(83400);
        return dVar;
    }

    static /* synthetic */ String access$1200(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83401);
        String ddVar = logicDataManager.getdd();
        AppMethodBeat.o(83401);
        return ddVar;
    }

    static /* synthetic */ String access$1300(LogicDataManager logicDataManager, int i) {
        AppMethodBeat.i(83402);
        String dVar = logicDataManager.getd(i);
        AppMethodBeat.o(83402);
        return dVar;
    }

    static /* synthetic */ String access$1400(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83403);
        String d = logicDataManager.getD();
        AppMethodBeat.o(83403);
        return d;
    }

    static /* synthetic */ String access$1500(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83404);
        String eVar = logicDataManager.gete();
        AppMethodBeat.o(83404);
        return eVar;
    }

    static /* synthetic */ String access$1600(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83405);
        String eee = logicDataManager.getEEE();
        AppMethodBeat.o(83405);
        return eee;
    }

    static /* synthetic */ String access$1700(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83406);
        String eeee = logicDataManager.getEEEE();
        AppMethodBeat.o(83406);
        return eeee;
    }

    static /* synthetic */ String access$1800(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83407);
        String aVar = logicDataManager.geta();
        AppMethodBeat.o(83407);
        return aVar;
    }

    static /* synthetic */ String access$1900(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83408);
        String hVar = logicDataManager.geth();
        AppMethodBeat.o(83408);
        return hVar;
    }

    static /* synthetic */ String access$200(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83391);
        String str = logicDataManager.getyyyy();
        AppMethodBeat.o(83391);
        return str;
    }

    static /* synthetic */ String access$2000(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83409);
        String hhVar = logicDataManager.gethh();
        AppMethodBeat.o(83409);
        return hhVar;
    }

    static /* synthetic */ String access$2100(LogicDataManager logicDataManager, int i) {
        AppMethodBeat.i(83410);
        String hVar = logicDataManager.geth(i);
        AppMethodBeat.o(83410);
        return hVar;
    }

    static /* synthetic */ String access$2200(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83411);
        String h = logicDataManager.getH();
        AppMethodBeat.o(83411);
        return h;
    }

    static /* synthetic */ String access$2300(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83412);
        String hh = logicDataManager.getHH();
        AppMethodBeat.o(83412);
        return hh;
    }

    static /* synthetic */ String access$2400(LogicDataManager logicDataManager, int i) {
        AppMethodBeat.i(83413);
        String h = logicDataManager.getH(i);
        AppMethodBeat.o(83413);
        return h;
    }

    static /* synthetic */ String access$2500(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83414);
        String mVar = logicDataManager.getm();
        AppMethodBeat.o(83414);
        return mVar;
    }

    static /* synthetic */ String access$2600(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83415);
        String mmVar = logicDataManager.getmm();
        AppMethodBeat.o(83415);
        return mmVar;
    }

    static /* synthetic */ String access$2700(LogicDataManager logicDataManager, int i) {
        AppMethodBeat.i(83416);
        String mVar = logicDataManager.getm(i);
        AppMethodBeat.o(83416);
        return mVar;
    }

    static /* synthetic */ String access$2800(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83417);
        String sVar = logicDataManager.gets();
        AppMethodBeat.o(83417);
        return sVar;
    }

    static /* synthetic */ String access$2900(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83418);
        String ssVar = logicDataManager.getss();
        AppMethodBeat.o(83418);
        return ssVar;
    }

    static /* synthetic */ String access$300(LogicDataManager logicDataManager, int i) {
        AppMethodBeat.i(83392);
        String yVar = logicDataManager.gety(i);
        AppMethodBeat.o(83392);
        return yVar;
    }

    static /* synthetic */ String access$3000(LogicDataManager logicDataManager, int i) {
        AppMethodBeat.i(83419);
        String sVar = logicDataManager.gets(i);
        AppMethodBeat.o(83419);
        return sVar;
    }

    static /* synthetic */ String access$3100(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83420);
        String altitude = logicDataManager.getAltitude();
        AppMethodBeat.o(83420);
        return altitude;
    }

    static /* synthetic */ String access$3500(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83421);
        String temperature = logicDataManager.getTemperature();
        AppMethodBeat.o(83421);
        return temperature;
    }

    static /* synthetic */ String access$3600(LogicDataManager logicDataManager, int i) {
        AppMethodBeat.i(83422);
        String temperature = logicDataManager.getTemperature(i);
        AppMethodBeat.o(83422);
        return temperature;
    }

    static /* synthetic */ String access$3700(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83423);
        String temperatureSymbol = logicDataManager.getTemperatureSymbol();
        AppMethodBeat.o(83423);
        return temperatureSymbol;
    }

    static /* synthetic */ String access$400(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83393);
        String m = logicDataManager.getM();
        AppMethodBeat.o(83393);
        return m;
    }

    static /* synthetic */ String access$500(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83394);
        String mm = logicDataManager.getMM();
        AppMethodBeat.o(83394);
        return mm;
    }

    static /* synthetic */ String access$600(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83395);
        String mmm = logicDataManager.getMMM();
        AppMethodBeat.o(83395);
        return mmm;
    }

    static /* synthetic */ String access$700(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83396);
        String mmmm = logicDataManager.getMMMM();
        AppMethodBeat.o(83396);
        return mmmm;
    }

    static /* synthetic */ String access$800(LogicDataManager logicDataManager, int i) {
        AppMethodBeat.i(83397);
        String m = logicDataManager.getM(i);
        AppMethodBeat.o(83397);
        return m;
    }

    static /* synthetic */ String access$900(LogicDataManager logicDataManager) {
        AppMethodBeat.i(83398);
        String wVar = logicDataManager.getw();
        AppMethodBeat.o(83398);
        return wVar;
    }

    static {
        AppMethodBeat.i(83424);
        AppMethodBeat.o(83424);
    }

    public static synchronized LogicDataManager getInstance() {
        LogicDataManager logicDataManager;
        synchronized (LogicDataManager.class) {
            AppMethodBeat.i(83331);
            if (mInstance == null) {
                mInstance = new LogicDataManager();
            }
            logicDataManager = mInstance;
            AppMethodBeat.o(83331);
        }
        return logicDataManager;
    }

    private LogicDataManager() {
        AppMethodBeat.i(83332);
        AppMethodBeat.o(83332);
    }

    public void init(VideoMaterial videoMaterial) {
        AppMethodBeat.i(83333);
        resetParams();
        buildDataProviderMap();
        buildVoice2TextParams(videoMaterial);
        AppMethodBeat.o(83333);
    }

    private void resetParams() {
        this.mNeedDecibel = false;
        this.mUseDecibelFromCameraRecorder = false;
        this.mDecibelUpdateTimestamp = 0;
    }

    private void buildDataProviderMap() {
        AppMethodBeat.i(83334);
        this.mProviderMap.put(DATE, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83272);
                String access$000 = LogicDataManager.access$000(LogicDataManager.this);
                AppMethodBeat.o(83272);
                return access$000;
            }
        });
        this.mProviderMap.put(DATE_yy, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83283);
                String access$100 = LogicDataManager.access$100(LogicDataManager.this);
                AppMethodBeat.o(83283);
                return access$100;
            }
        });
        this.mProviderMap.put(DATE_yyyy, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83294);
                String access$200 = LogicDataManager.access$200(LogicDataManager.this);
                AppMethodBeat.o(83294);
                return access$200;
            }
        });
        this.mProviderMap.put(DATE_y0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83305);
                String access$300 = LogicDataManager.access$300(LogicDataManager.this, 0);
                AppMethodBeat.o(83305);
                return access$300;
            }
        });
        this.mProviderMap.put(DATE_y1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83316);
                String access$300 = LogicDataManager.access$300(LogicDataManager.this, 1);
                AppMethodBeat.o(83316);
                return access$300;
            }
        });
        this.mProviderMap.put(DATE_y2, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83327);
                String access$300 = LogicDataManager.access$300(LogicDataManager.this, 2);
                AppMethodBeat.o(83327);
                return access$300;
            }
        });
        this.mProviderMap.put(DATE_y3, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83328);
                String access$300 = LogicDataManager.access$300(LogicDataManager.this, 3);
                AppMethodBeat.o(83328);
                return access$300;
            }
        });
        this.mProviderMap.put(DATE_M, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83329);
                String access$400 = LogicDataManager.access$400(LogicDataManager.this);
                AppMethodBeat.o(83329);
                return access$400;
            }
        });
        this.mProviderMap.put(DATE_MM, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83330);
                String access$500 = LogicDataManager.access$500(LogicDataManager.this);
                AppMethodBeat.o(83330);
                return access$500;
            }
        });
        this.mProviderMap.put(DATE_MMM, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83273);
                String access$600 = LogicDataManager.access$600(LogicDataManager.this);
                AppMethodBeat.o(83273);
                return access$600;
            }
        });
        this.mProviderMap.put(DATE_MMMM, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83274);
                String access$700 = LogicDataManager.access$700(LogicDataManager.this);
                AppMethodBeat.o(83274);
                return access$700;
            }
        });
        this.mProviderMap.put(DATE_M0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83275);
                String access$800 = LogicDataManager.access$800(LogicDataManager.this, 0);
                AppMethodBeat.o(83275);
                return access$800;
            }
        });
        this.mProviderMap.put(DATE_M1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83276);
                String access$800 = LogicDataManager.access$800(LogicDataManager.this, 1);
                AppMethodBeat.o(83276);
                return access$800;
            }
        });
        this.mProviderMap.put(DATE_w, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83277);
                String access$900 = LogicDataManager.access$900(LogicDataManager.this);
                AppMethodBeat.o(83277);
                return access$900;
            }
        });
        this.mProviderMap.put(DATE_W, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83278);
                String access$1000 = LogicDataManager.access$1000(LogicDataManager.this);
                AppMethodBeat.o(83278);
                return access$1000;
            }
        });
        this.mProviderMap.put(DATE_d, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83279);
                String access$1100 = LogicDataManager.access$1100(LogicDataManager.this);
                AppMethodBeat.o(83279);
                return access$1100;
            }
        });
        this.mProviderMap.put(DATE_dd, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83280);
                String access$1200 = LogicDataManager.access$1200(LogicDataManager.this);
                AppMethodBeat.o(83280);
                return access$1200;
            }
        });
        this.mProviderMap.put(DATE_d0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83281);
                String access$1300 = LogicDataManager.access$1300(LogicDataManager.this, 0);
                AppMethodBeat.o(83281);
                return access$1300;
            }
        });
        this.mProviderMap.put(DATE_d1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83282);
                String access$1300 = LogicDataManager.access$1300(LogicDataManager.this, 1);
                AppMethodBeat.o(83282);
                return access$1300;
            }
        });
        this.mProviderMap.put(DATE_D, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83284);
                String access$1400 = LogicDataManager.access$1400(LogicDataManager.this);
                AppMethodBeat.o(83284);
                return access$1400;
            }
        });
        this.mProviderMap.put(DATE_e, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83285);
                String access$1500 = LogicDataManager.access$1500(LogicDataManager.this);
                AppMethodBeat.o(83285);
                return access$1500;
            }
        });
        this.mProviderMap.put(DATE_EEE, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83286);
                String access$1600 = LogicDataManager.access$1600(LogicDataManager.this);
                AppMethodBeat.o(83286);
                return access$1600;
            }
        });
        this.mProviderMap.put(DATE_EEEE, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83287);
                String access$1700 = LogicDataManager.access$1700(LogicDataManager.this);
                AppMethodBeat.o(83287);
                return access$1700;
            }
        });
        this.mProviderMap.put(DATE_a, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83288);
                String access$1800 = LogicDataManager.access$1800(LogicDataManager.this);
                AppMethodBeat.o(83288);
                return access$1800;
            }
        });
        this.mProviderMap.put(DATE_h, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83289);
                String access$1900 = LogicDataManager.access$1900(LogicDataManager.this);
                AppMethodBeat.o(83289);
                return access$1900;
            }
        });
        this.mProviderMap.put(DATE_hh, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83290);
                String access$2000 = LogicDataManager.access$2000(LogicDataManager.this);
                AppMethodBeat.o(83290);
                return access$2000;
            }
        });
        this.mProviderMap.put(DATE_h0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83291);
                String access$2100 = LogicDataManager.access$2100(LogicDataManager.this, 0);
                AppMethodBeat.o(83291);
                return access$2100;
            }
        });
        this.mProviderMap.put(DATE_h1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83292);
                String access$2100 = LogicDataManager.access$2100(LogicDataManager.this, 1);
                AppMethodBeat.o(83292);
                return access$2100;
            }
        });
        this.mProviderMap.put(DATE_H, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83293);
                String access$2200 = LogicDataManager.access$2200(LogicDataManager.this);
                AppMethodBeat.o(83293);
                return access$2200;
            }
        });
        this.mProviderMap.put(DATE_HH, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83295);
                String access$2300 = LogicDataManager.access$2300(LogicDataManager.this);
                AppMethodBeat.o(83295);
                return access$2300;
            }
        });
        this.mProviderMap.put(DATE_H0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83296);
                String access$2400 = LogicDataManager.access$2400(LogicDataManager.this, 0);
                AppMethodBeat.o(83296);
                return access$2400;
            }
        });
        this.mProviderMap.put(DATE_H1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83297);
                String access$2400 = LogicDataManager.access$2400(LogicDataManager.this, 1);
                AppMethodBeat.o(83297);
                return access$2400;
            }
        });
        this.mProviderMap.put(DATE_m, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83298);
                String access$2500 = LogicDataManager.access$2500(LogicDataManager.this);
                AppMethodBeat.o(83298);
                return access$2500;
            }
        });
        this.mProviderMap.put(DATE_mm, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83299);
                String access$2600 = LogicDataManager.access$2600(LogicDataManager.this);
                AppMethodBeat.o(83299);
                return access$2600;
            }
        });
        this.mProviderMap.put(DATE_m0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83300);
                String access$2700 = LogicDataManager.access$2700(LogicDataManager.this, 0);
                AppMethodBeat.o(83300);
                return access$2700;
            }
        });
        this.mProviderMap.put(DATE_m1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83301);
                String access$2700 = LogicDataManager.access$2700(LogicDataManager.this, 1);
                AppMethodBeat.o(83301);
                return access$2700;
            }
        });
        this.mProviderMap.put(DATE_s, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83302);
                String access$2800 = LogicDataManager.access$2800(LogicDataManager.this);
                AppMethodBeat.o(83302);
                return access$2800;
            }
        });
        this.mProviderMap.put(DATE_ss, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83303);
                String access$2900 = LogicDataManager.access$2900(LogicDataManager.this);
                AppMethodBeat.o(83303);
                return access$2900;
            }
        });
        this.mProviderMap.put(DATE_s0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83304);
                String access$3000 = LogicDataManager.access$3000(LogicDataManager.this, 0);
                AppMethodBeat.o(83304);
                return access$3000;
            }
        });
        this.mProviderMap.put(DATE_s1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83306);
                String access$3000 = LogicDataManager.access$3000(LogicDataManager.this, 1);
                AppMethodBeat.o(83306);
                return access$3000;
            }
        });
        this.mProviderMap.put(DB, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83307);
                String db = LogicDataManager.this.getDB();
                AppMethodBeat.o(83307);
                return db;
            }
        });
        this.mProviderMap.put(ALTITUDE, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83308);
                String valueOf = String.valueOf(LogicDataManager.access$3100(LogicDataManager.this));
                AppMethodBeat.o(83308);
                return valueOf;
            }
        });
        this.mProviderMap.put(LOCATION, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83309);
                String str;
                if (LogicDataManager.this.mLocation == null) {
                    str = "这里";
                    AppMethodBeat.o(83309);
                    return str;
                }
                str = LogicDataManager.this.mLocation;
                AppMethodBeat.o(83309);
                return str;
            }
        });
        this.mProviderMap.put(WEATHER, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83310);
                String access$3300 = LogicDataManager.this.mWeather;
                AppMethodBeat.o(83310);
                return access$3300;
            }
        });
        this.mProviderMap.put(WEATHER_TYPE, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83311);
                String access$3400 = LogicDataManager.this.mWeatherType;
                AppMethodBeat.o(83311);
                return access$3400;
            }
        });
        this.mProviderMap.put(TEMPERATURE, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83312);
                String access$3500 = LogicDataManager.access$3500(LogicDataManager.this);
                AppMethodBeat.o(83312);
                return access$3500;
            }
        });
        this.mProviderMap.put(TEMPERATURE_0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83313);
                String access$3600 = LogicDataManager.access$3600(LogicDataManager.this, 0);
                AppMethodBeat.o(83313);
                return access$3600;
            }
        });
        this.mProviderMap.put(TEMPERATURE_1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83314);
                String access$3600 = LogicDataManager.access$3600(LogicDataManager.this, 1);
                AppMethodBeat.o(83314);
                return access$3600;
            }
        });
        this.mProviderMap.put(TEMPERATURE_s, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83315);
                String access$3700 = LogicDataManager.access$3700(LogicDataManager.this);
                AppMethodBeat.o(83315);
                return access$3700;
            }
        });
        this.mProviderMap.put(SPEECHS_ALL, new LogicValueProvider() {
            public String getValue() {
                String str;
                AppMethodBeat.i(83317);
                synchronized (LogicDataManager.this.mVoiceTextQueue) {
                    try {
                        if (LogicDataManager.this.mVoiceTextQueue.isEmpty()) {
                            str = "";
                            AppMethodBeat.o(83317);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            while (!LogicDataManager.this.mVoiceTextQueue.isEmpty()) {
                                stringBuilder.append((String) LogicDataManager.this.mVoiceTextQueue.poll());
                            }
                            str = stringBuilder.toString();
                        }
                    } finally {
                        AppMethodBeat.o(83317);
                    }
                }
                return str;
            }
        });
        this.mProviderMap.put(PIC_DATE_y0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83318);
                String access$300;
                if (TextUtils.isEmpty(LogicDataManager.this.mPictureDate) || LogicDataManager.this.mPictureDate.length() <= 0) {
                    access$300 = LogicDataManager.access$300(LogicDataManager.this, 0);
                    AppMethodBeat.o(83318);
                    return access$300;
                }
                access$300 = LogicDataManager.this.mPictureDate.substring(0, 1);
                AppMethodBeat.o(83318);
                return access$300;
            }
        });
        this.mProviderMap.put(PIC_DATE_y1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83319);
                String access$300;
                if (TextUtils.isEmpty(LogicDataManager.this.mPictureDate) || LogicDataManager.this.mPictureDate.length() <= 1) {
                    access$300 = LogicDataManager.access$300(LogicDataManager.this, 1);
                    AppMethodBeat.o(83319);
                    return access$300;
                }
                access$300 = LogicDataManager.this.mPictureDate.substring(1, 2);
                AppMethodBeat.o(83319);
                return access$300;
            }
        });
        this.mProviderMap.put(PIC_DATE_y2, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83320);
                String access$300;
                if (TextUtils.isEmpty(LogicDataManager.this.mPictureDate) || LogicDataManager.this.mPictureDate.length() <= 2) {
                    access$300 = LogicDataManager.access$300(LogicDataManager.this, 2);
                    AppMethodBeat.o(83320);
                    return access$300;
                }
                access$300 = LogicDataManager.this.mPictureDate.substring(2, 3);
                AppMethodBeat.o(83320);
                return access$300;
            }
        });
        this.mProviderMap.put(PIC_DATE_y3, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83321);
                String access$300;
                if (TextUtils.isEmpty(LogicDataManager.this.mPictureDate) || LogicDataManager.this.mPictureDate.length() <= 3) {
                    access$300 = LogicDataManager.access$300(LogicDataManager.this, 3);
                    AppMethodBeat.o(83321);
                    return access$300;
                }
                access$300 = LogicDataManager.this.mPictureDate.substring(3, 4);
                AppMethodBeat.o(83321);
                return access$300;
            }
        });
        this.mProviderMap.put(PIC_DATE_M0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83322);
                String access$800;
                if (TextUtils.isEmpty(LogicDataManager.this.mPictureDate) || LogicDataManager.this.mPictureDate.length() <= 5) {
                    access$800 = LogicDataManager.access$800(LogicDataManager.this, 0);
                    AppMethodBeat.o(83322);
                    return access$800;
                }
                access$800 = LogicDataManager.this.mPictureDate.substring(5, 6);
                AppMethodBeat.o(83322);
                return access$800;
            }
        });
        this.mProviderMap.put(PIC_DATE_M1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83323);
                String access$800;
                if (TextUtils.isEmpty(LogicDataManager.this.mPictureDate) || LogicDataManager.this.mPictureDate.length() <= 6) {
                    access$800 = LogicDataManager.access$800(LogicDataManager.this, 1);
                    AppMethodBeat.o(83323);
                    return access$800;
                }
                access$800 = LogicDataManager.this.mPictureDate.substring(6, 7);
                AppMethodBeat.o(83323);
                return access$800;
            }
        });
        this.mProviderMap.put(PIC_DATE_d0, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83324);
                String access$1300;
                if (TextUtils.isEmpty(LogicDataManager.this.mPictureDate) || LogicDataManager.this.mPictureDate.length() <= 8) {
                    access$1300 = LogicDataManager.access$1300(LogicDataManager.this, 0);
                    AppMethodBeat.o(83324);
                    return access$1300;
                }
                access$1300 = LogicDataManager.this.mPictureDate.substring(8, 9);
                AppMethodBeat.o(83324);
                return access$1300;
            }
        });
        this.mProviderMap.put(PIC_DATE_d1, new LogicValueProvider() {
            public String getValue() {
                AppMethodBeat.i(83325);
                String access$1300;
                if (TextUtils.isEmpty(LogicDataManager.this.mPictureDate) || LogicDataManager.this.mPictureDate.length() <= 9) {
                    access$1300 = LogicDataManager.access$1300(LogicDataManager.this, 1);
                    AppMethodBeat.o(83325);
                    return access$1300;
                }
                access$1300 = LogicDataManager.this.mPictureDate.substring(9, 10);
                AppMethodBeat.o(83325);
                return access$1300;
            }
        });
        AppMethodBeat.o(83334);
    }

    public void buildVoice2TextParams(VideoMaterial videoMaterial) {
        AppMethodBeat.i(83335);
        if (videoMaterial == null || videoMaterial.getAudio2Text() == null) {
            AppMethodBeat.o(83335);
            return;
        }
        this.mVTSilenceTime = (int) (videoMaterial.getAudio2Text().silenceTime * 1000.0d);
        this.mVTSegmentCount = videoMaterial.getAudio2Text().segmentCount;
        this.mVTSegmentTime = (int) (videoMaterial.getAudio2Text().segmentTime * 1000.0d);
        clearVoiceTexts();
        if (!VideoMaterialUtil.isAudio2textMaterial(videoMaterial)) {
            AppMethodBeat.o(83335);
        } else if (videoMaterial.getAudio2Text().sentenceMode == 1) {
            this.mVoiceTextDup = new LoopRepList(videoMaterial.getAudio2Text().sentenceCount);
            AppMethodBeat.o(83335);
        } else {
            this.mVoiceTextDup = new FIFOList(videoMaterial.getAudio2Text().sentenceCount);
            AppMethodBeat.o(83335);
        }
    }

    public void setLocation(String str) {
        this.mLocation = str;
    }

    public void setWeather(int i) {
        AppMethodBeat.i(83336);
        this.mWeather = mapWeatherCode(i);
        AppMethodBeat.o(83336);
    }

    public void setWeatherType(int i) {
        AppMethodBeat.i(83337);
        this.mWeatherType = String.valueOf(i);
        AppMethodBeat.o(83337);
    }

    public void setAltitude(String str) {
        this.mAltitude = str;
    }

    public void setTemperature(String str) {
        this.mTemperature = str;
    }

    public String getValue(String str) {
        AppMethodBeat.i(83338);
        if (this.mProviderMap.containsKey(str)) {
            str = ((LogicValueProvider) this.mProviderMap.get(str)).getValue();
        }
        AppMethodBeat.o(83338);
        return str;
    }

    private String getTimestamp() {
        AppMethodBeat.i(83339);
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        AppMethodBeat.o(83339);
        return format;
    }

    private String getyy() {
        AppMethodBeat.i(83340);
        String format = new SimpleDateFormat("yy").format(new Date());
        AppMethodBeat.o(83340);
        return format;
    }

    private String getyyyy() {
        AppMethodBeat.i(83341);
        String format = new SimpleDateFormat("yyyy").format(new Date());
        AppMethodBeat.o(83341);
        return format;
    }

    private String gety(int i) {
        AppMethodBeat.i(83342);
        String substring = new SimpleDateFormat("yyyy").format(new Date()).substring(i, i + 1);
        AppMethodBeat.o(83342);
        return substring;
    }

    private String getM() {
        AppMethodBeat.i(83343);
        String format = new SimpleDateFormat("M").format(new Date());
        AppMethodBeat.o(83343);
        return format;
    }

    private String getMM() {
        AppMethodBeat.i(83344);
        String format = new SimpleDateFormat("MM").format(new Date());
        AppMethodBeat.o(83344);
        return format;
    }

    private String getMMM() {
        AppMethodBeat.i(83345);
        String[] strArr = new String[]{"Jan.", "Feb.", "Mar.", "Apr.", "May.", "Jun.", "Jul.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
        int parseInt = Integer.parseInt(getM(0));
        if (parseInt == 0) {
            parseInt = Integer.parseInt(getM(1));
        } else {
            parseInt = (parseInt * 10) + Integer.parseInt(getM(1));
        }
        String str;
        if (parseInt < 12) {
            str = strArr[parseInt];
            AppMethodBeat.o(83345);
            return str;
        }
        str = "";
        AppMethodBeat.o(83345);
        return str;
    }

    private String getMMMM() {
        AppMethodBeat.i(83346);
        String[] strArr = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int parseInt = Integer.parseInt(getM(0));
        if (parseInt == 0) {
            parseInt = Integer.parseInt(getM(1));
        } else {
            parseInt = (parseInt * 10) + Integer.parseInt(getM(1));
        }
        String str;
        if (parseInt < 12) {
            str = strArr[parseInt];
            AppMethodBeat.o(83346);
            return str;
        }
        str = "";
        AppMethodBeat.o(83346);
        return str;
    }

    private String getM(int i) {
        AppMethodBeat.i(83347);
        String substring = getMM().substring(i, i + 1);
        AppMethodBeat.o(83347);
        return substring;
    }

    private String getw() {
        AppMethodBeat.i(83348);
        String format = new SimpleDateFormat("w").format(new Date());
        AppMethodBeat.o(83348);
        return format;
    }

    private String getW() {
        AppMethodBeat.i(83349);
        String format = new SimpleDateFormat(QLog.TAG_REPORTLEVEL_COLORUSER).format(new Date());
        AppMethodBeat.o(83349);
        return format;
    }

    private String getd() {
        AppMethodBeat.i(83350);
        String format = new SimpleDateFormat("d").format(new Date());
        AppMethodBeat.o(83350);
        return format;
    }

    private String getd(int i) {
        AppMethodBeat.i(83351);
        String substring = getdd().substring(i, i + 1);
        AppMethodBeat.o(83351);
        return substring;
    }

    private String getdd() {
        AppMethodBeat.i(83352);
        String format = new SimpleDateFormat("dd").format(new Date());
        AppMethodBeat.o(83352);
        return format;
    }

    private String getD() {
        AppMethodBeat.i(83353);
        String format = new SimpleDateFormat(QLog.TAG_REPORTLEVEL_DEVELOPER).format(new Date());
        AppMethodBeat.o(83353);
        return format;
    }

    private String gete() {
        int i = 0;
        AppMethodBeat.i(83354);
        String[] strArr = new String[]{"日", "一", "二", "三", "四", "五", "六"};
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int i2 = instance.get(7) - 1;
        if (i2 >= 0) {
            i = i2;
        }
        String str = strArr[i];
        AppMethodBeat.o(83354);
        return str;
    }

    private String getEEE() {
        int i = 0;
        AppMethodBeat.i(83355);
        String[] strArr = new String[]{"Sun.", "Mon.", "Tues.", "Wed.", "Thur.", "Fri.", "Sat."};
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int i2 = instance.get(7) - 1;
        if (i2 >= 0) {
            i = i2;
        }
        String str = strArr[i];
        AppMethodBeat.o(83355);
        return str;
    }

    private String getEEEE() {
        int i = 0;
        AppMethodBeat.i(83356);
        String[] strArr = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        int i2 = instance.get(7) - 1;
        if (i2 >= 0) {
            i = i2;
        }
        String str = strArr[i];
        AppMethodBeat.o(83356);
        return str;
    }

    private String geta() {
        AppMethodBeat.i(83357);
        String format = new SimpleDateFormat("a").format(new Date());
        AppMethodBeat.o(83357);
        return format;
    }

    private String geth() {
        AppMethodBeat.i(83358);
        String format = new SimpleDateFormat("h").format(new Date());
        AppMethodBeat.o(83358);
        return format;
    }

    private String gethh() {
        AppMethodBeat.i(83359);
        String format = new SimpleDateFormat("hh").format(new Date());
        AppMethodBeat.o(83359);
        return format;
    }

    private String geth(int i) {
        AppMethodBeat.i(83360);
        String substring = new SimpleDateFormat("hh").format(new Date()).substring(i, i + 1);
        AppMethodBeat.o(83360);
        return substring;
    }

    private String getH() {
        AppMethodBeat.i(83361);
        String format = new SimpleDateFormat("H").format(new Date());
        AppMethodBeat.o(83361);
        return format;
    }

    private String getHH() {
        AppMethodBeat.i(83362);
        String format = new SimpleDateFormat("HH").format(new Date());
        AppMethodBeat.o(83362);
        return format;
    }

    private String getH(int i) {
        AppMethodBeat.i(83363);
        String substring = getHH().substring(i, i + 1);
        AppMethodBeat.o(83363);
        return substring;
    }

    private String getm() {
        AppMethodBeat.i(83364);
        String format = new SimpleDateFormat("m").format(new Date());
        AppMethodBeat.o(83364);
        return format;
    }

    private String getmm() {
        AppMethodBeat.i(83365);
        String format = new SimpleDateFormat("mm").format(new Date());
        AppMethodBeat.o(83365);
        return format;
    }

    private String getm(int i) {
        AppMethodBeat.i(83366);
        String substring = getmm().substring(i, i + 1);
        AppMethodBeat.o(83366);
        return substring;
    }

    private String gets() {
        AppMethodBeat.i(83367);
        String format = new SimpleDateFormat("s").format(new Date());
        AppMethodBeat.o(83367);
        return format;
    }

    private String getss() {
        AppMethodBeat.i(83368);
        String format = new SimpleDateFormat("ss").format(new Date());
        AppMethodBeat.o(83368);
        return format;
    }

    private String gets(int i) {
        AppMethodBeat.i(83369);
        String substring = getss().substring(i, i + 1);
        AppMethodBeat.o(83369);
        return substring;
    }

    private int adjustDB(int i) {
        return (int) ((0.65d * ((double) i)) + 40.0d);
    }

    public String getDB() {
        AppMethodBeat.i(83370);
        String valueOf = String.valueOf(adjustDB(this.mDecibel));
        AppMethodBeat.o(83370);
        return valueOf;
    }

    private String getAltitude() {
        return this.mAltitude;
    }

    public String getLocation() {
        return this.mLocation;
    }

    private String getTemperature() {
        return this.mTemperature;
    }

    private String getTemperature(int i) {
        String substring;
        AppMethodBeat.i(83371);
        if (!TextUtils.isEmpty(this.mTemperature)) {
            try {
                if (Integer.parseInt(this.mTemperature) >= 0) {
                    if (i + 1 <= this.mTemperature.length()) {
                        substring = this.mTemperature.substring(i, i + 1);
                        AppMethodBeat.o(83371);
                        return substring;
                    }
                } else if (i + 2 <= this.mTemperature.length()) {
                    substring = this.mTemperature.substring(i + 1, i + 2);
                    AppMethodBeat.o(83371);
                    return substring;
                }
            } catch (Exception e) {
            }
        }
        substring = "";
        AppMethodBeat.o(83371);
        return substring;
    }

    private String getTemperatureSymbol() {
        String str;
        AppMethodBeat.i(83372);
        if (!TextUtils.isEmpty(this.mTemperature)) {
            try {
                if (Integer.parseInt(this.mTemperature) >= 0) {
                    str = "+";
                    AppMethodBeat.o(83372);
                    return str;
                }
                str = "-";
                AppMethodBeat.o(83372);
                return str;
            } catch (Exception e) {
            }
        }
        str = "";
        AppMethodBeat.o(83372);
        return str;
    }

    public String replaceWithData(String str, Set<String> set) {
        AppMethodBeat.i(83373);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(83373);
        } else {
            for (String str2 : set) {
                if (PATTERN_SPEECHS.matcher(str).find() && PATTERN_SPEECHS.matcher(str2).find()) {
                    str = str.replace(str2, fetchSpeechSentence(str2));
                }
                if (PATTERN_SPEECHW.matcher(str).find() && PATTERN_SPEECHW.matcher(str2).find()) {
                    str = str.replace(str2, fetchSpeechWord(str2));
                }
                str = str.replace(str2, this.mProviderMap.containsKey(str2) ? ((LogicValueProvider) this.mProviderMap.get(str2)).getValue() : "");
            }
            AppMethodBeat.o(83373);
        }
        return str;
    }

    public void test() {
        AppMethodBeat.i(83374);
        for (Entry entry : this.mProviderMap.entrySet()) {
            new StringBuilder().append((String) entry.getKey()).append(": ").append(((LogicValueProvider) entry.getValue()).getValue());
        }
        AppMethodBeat.o(83374);
    }

    public List<WMElement> getEditableWMElement() {
        return this.mEditableWMElements;
    }

    public void addEditableWMElement(WMElement wMElement) {
        AppMethodBeat.i(83375);
        this.mEditableWMElements.add(wMElement);
        AppMethodBeat.o(83375);
    }

    public void removeEditableWMElement(WMElement wMElement) {
        AppMethodBeat.i(83376);
        this.mEditableWMElements.remove(wMElement);
        AppMethodBeat.o(83376);
    }

    public void recordDate(String str, String str2, String str3) {
        AppMethodBeat.i(83377);
        if (str.equals(WMLogic.TYPE_SINCE)) {
            VideoPrefsUtil.getDefaultPrefs().edit().putString("prefs_key_watermark_since_".concat(String.valueOf(str2)), str3).apply();
            AppMethodBeat.o(83377);
            return;
        }
        if (str.equals(WMLogic.TYPE_COUNTDOWN)) {
            VideoPrefsUtil.getDefaultPrefs().edit().putString("prefs_key_watermark_countdown_".concat(String.valueOf(str2)), str3).apply();
        }
        AppMethodBeat.o(83377);
    }

    public void setNeedDB(boolean z) {
        this.mNeedDecibel = z;
    }

    public boolean needDecibel() {
        return this.mNeedDecibel;
    }

    public void destroy() {
        AppMethodBeat.i(83378);
        destroyDecibelDetector();
        AppMethodBeat.o(83378);
    }

    public void destroyDecibelDetector() {
    }

    public void setDecibel(int i) {
        AppMethodBeat.i(83379);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mDecibelUpdateTimestamp > 500) {
            this.mDecibel = i;
            this.mDecibelUpdateTimestamp = currentTimeMillis;
        }
        AppMethodBeat.o(83379);
    }

    public boolean hasObtainedServerData() {
        AppMethodBeat.i(83380);
        if (DATA_DEFAULT_LOCATION.equals(this.mLocation) || DATA_DEFAULT_WEATHER.equals(this.mWeather) || "0".equals(this.mTemperature) || DATA_DEFAULT_NO_NETWORK.equals(this.mAltitude)) {
            AppMethodBeat.o(83380);
            return false;
        }
        AppMethodBeat.o(83380);
        return true;
    }

    public void setDecibelFromCameraRecorder(boolean z) {
        this.mUseDecibelFromCameraRecorder = z;
    }

    public void addWatermarkDict(Map<String, String> map) {
        AppMethodBeat.i(83381);
        for (final Entry entry : map.entrySet()) {
            this.mProviderMap.put("[" + ((String) entry.getKey()) + "]", new LogicValueProvider() {
                public String getValue() {
                    AppMethodBeat.i(83326);
                    String str = (String) entry.getValue();
                    AppMethodBeat.o(83326);
                    return str;
                }
            });
        }
        AppMethodBeat.o(83381);
    }

    public String mapWeatherCode(int i) {
        switch (i) {
            case 0:
                return DATA_DEFAULT_WEATHER;
            case 1:
                return "多云";
            case 2:
                return "阴";
            case 3:
                return "雨";
            case 4:
                return "雪";
            case 5:
                return "雾";
            case 6:
                return "雨加雪";
            case 7:
                return "雷阵雨";
            case 8:
                return "沙尘暴";
            case 9:
                return "大风";
            default:
                return "";
        }
    }

    private String fetchSpeechSentence(String str) {
        AppMethodBeat.i(83382);
        ArrayList arrayList = new ArrayList(this.mVoiceTextDup);
        String str2;
        if (arrayList.isEmpty()) {
            str2 = "";
            AppMethodBeat.o(83382);
            return str2;
        }
        int fetchNumerical = fetchNumerical(str);
        if (BaseUtils.indexOutOfBounds(arrayList, Math.abs(fetchNumerical - 1))) {
            str2 = "";
            AppMethodBeat.o(83382);
            return str2;
        }
        if (fetchNumerical == 0) {
            fetchNumerical = ((int) (Math.random() * ((double) arrayList.size()))) + 1;
        }
        str2 = (String) arrayList.get(fetchNumerical > 0 ? fetchNumerical - 1 : arrayList.size() - Math.abs(fetchNumerical));
        AppMethodBeat.o(83382);
        return str2;
    }

    private String fetchSpeechWord(String str) {
        String str2;
        AppMethodBeat.i(83383);
        int fetchNumerical = fetchNumerical(str);
        if (fetchNumerical != 0) {
            ArrayList arrayList = new ArrayList(this.mVoiceTextDup);
            if (arrayList.isEmpty()) {
                str2 = "";
                AppMethodBeat.o(83383);
                return str2;
            }
            str2 = (String) arrayList.get(arrayList.size() - 1);
            if (str2.length() < Math.abs(fetchNumerical)) {
                str2 = "";
                AppMethodBeat.o(83383);
                return str2;
            } else if (fetchNumerical > 0) {
                str2 = String.valueOf(str2.charAt(fetchNumerical - 1));
                AppMethodBeat.o(83383);
                return str2;
            } else {
                str2 = String.valueOf(str2.length() - Math.abs(fetchNumerical));
                AppMethodBeat.o(83383);
                return str2;
            }
        }
        synchronized (this.mVoiceTextQueue) {
            try {
                if (this.mVoiceTextQueue.isEmpty()) {
                    str2 = "";
                    AppMethodBeat.o(83383);
                    return str2;
                }
                str2 = String.valueOf(this.mVoiceTextQueue.poll());
            } finally {
                while (true) {
                }
                AppMethodBeat.o(83383);
            }
        }
        return str2;
    }

    private int fetchNumerical(String str) {
        AppMethodBeat.i(83384);
        Matcher matcher = PATTERN_NUMERICAL.matcher(str);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group());
                AppMethodBeat.o(83384);
                return parseInt;
            } catch (NumberFormatException e) {
                LogUtils.e(e);
            }
        }
        AppMethodBeat.o(83384);
        return 0;
    }

    public List<String> getCurTextList() {
        AppMethodBeat.i(83385);
        if (this.mVoiceTextDup.isEmpty()) {
            List<String> arrayList = new ArrayList();
            AppMethodBeat.o(83385);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(this.mVoiceTextDup);
        if (this.mVoiceTextDup instanceof FIFOList) {
            String str = (String) arrayList2.get(arrayList2.size() - 1);
            arrayList2.clear();
            arrayList2.add(str);
        }
        AppMethodBeat.o(83385);
        return arrayList2;
    }

    public void clearVoiceTexts() {
        AppMethodBeat.i(83386);
        this.mVoiceTextDup.clear();
        this.mVoiceTextQueue.clear();
        AppMethodBeat.o(83386);
    }

    public void setOnSilenceEventListener(OnSilenceEventListener onSilenceEventListener) {
        this.mSilenceEventListener = onSilenceEventListener;
    }

    public String getCurrentText() {
        AppMethodBeat.i(83387);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("audio2text : ");
        stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(83387);
        return stringBuffer2;
    }

    public void setPictureDate(String str) {
        AppMethodBeat.i(83388);
        try {
            this.mPictureDate = new ExifInterface(str).getAttribute(a.TAG_DATETIME);
            AppMethodBeat.o(83388);
        } catch (Exception e) {
            AppMethodBeat.o(83388);
        }
    }
}
