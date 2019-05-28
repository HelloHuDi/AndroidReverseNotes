package com.tencent.rtmp.sharp.jni;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReentrantLock;

@SuppressLint({"NewApi"})
public class TraeAudioManager extends BroadcastReceiver {
    public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
    public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
    public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP = 128;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_HEADPHONES = 256;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_A2DP_SPEAKER = 512;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO = 16;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_CARKIT = 64;
    static final int AUDIO_DEVICE_OUT_BLUETOOTH_SCO_HEADSET = 32;
    static final int AUDIO_DEVICE_OUT_EARPIECE = 1;
    static final int AUDIO_DEVICE_OUT_SPEAKER = 2;
    static final int AUDIO_DEVICE_OUT_WIRED_HEADPHONE = 8;
    static final int AUDIO_DEVICE_OUT_WIRED_HEADSET = 4;
    public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
    public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
    public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
    static final String AUDIO_PARAMETER_STREAM_ROUTING = "routing";
    public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
    public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
    public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
    public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
    public static final String DEVICE_NONE = "DEVICE_NONE";
    public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
    public static final int DEVICE_STATUS_CONNECTED = 2;
    public static final int DEVICE_STATUS_CONNECTING = 1;
    public static final int DEVICE_STATUS_DISCONNECTED = 0;
    public static final int DEVICE_STATUS_DISCONNECTING = 3;
    public static final int DEVICE_STATUS_ERROR = -1;
    public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
    public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
    public static final int EARACTION_AWAY = 0;
    public static final int EARACTION_CLOSE = 1;
    public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
    public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
    public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
    public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
    public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
    public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
    public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
    public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
    public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
    public static final int FORCE_ANALOG_DOCK = 8;
    public static final int FORCE_BT_A2DP = 4;
    public static final int FORCE_BT_CAR_DOCK = 6;
    public static final int FORCE_BT_DESK_DOCK = 7;
    public static final int FORCE_BT_SCO = 3;
    public static final int FORCE_DEFAULT = 0;
    public static final int FORCE_DIGITAL_DOCK = 9;
    public static final int FORCE_HEADPHONES = 2;
    public static final int FORCE_NONE = 0;
    public static final int FORCE_NO_BT_A2DP = 10;
    public static final int FORCE_SPEAKER = 1;
    public static final int FORCE_WIRED_ACCESSORY = 5;
    public static final int FOR_COMMUNICATION = 0;
    public static final int FOR_DOCK = 3;
    public static final int FOR_MEDIA = 1;
    public static final int FOR_RECORD = 2;
    public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
    public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
    public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
    public static boolean IsMusicScene = false;
    public static boolean IsUpdateSceneFlag = false;
    public static final int MODE_MUSIC_PLAYBACK = 2;
    public static final int MODE_MUSIC_PLAY_RECORD = 1;
    public static final int MODE_MUSIC_PLAY_RECORD_HIGH_QUALITY = 3;
    public static final int MODE_VOICE_CHAT = 0;
    public static final String MUSIC_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_WIREDHEADSET;DEVICE_BLUETOOTHHEADSET;";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
    public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
    public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
    public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
    public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
    public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
    public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
    public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
    public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
    private static final int NUM_FORCE_CONFIG = 11;
    private static final int NUM_FORCE_USE = 4;
    public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
    public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
    public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
    public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
    public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
    public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
    public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
    public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
    public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
    public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
    public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
    public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
    public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
    public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
    public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
    public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
    public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
    public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
    public static final String PARAM_DEVICE = "PARAM_DEVICE";
    public static final String PARAM_ERROR = "PARAM_ERROR";
    public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
    public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
    public static final String PARAM_OPERATION = "PARAM_OPERATION";
    public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
    public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
    public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
    public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
    public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
    public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
    public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
    public static final String PARAM_RING_URI = "PARAM_RING_URI";
    public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
    public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
    public static final String PARAM_STATUS = "PARAM_STATUS";
    public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
    public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
    public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
    public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
    public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
    public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
    public static final int RES_ERRCODE_NONE = 0;
    public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
    public static final int RES_ERRCODE_SERVICE_OFF = 1;
    public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
    public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
    public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
    public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
    public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
    static int _gHostProcessId = -1;
    static TraeAudioManager _ginstance = null;
    static ReentrantLock _glock = new ReentrantLock();
    static final String[] forceName = new String[]{"FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK"};
    boolean IsBluetoothA2dpExisted = true;
    int _activeMode = 0;
    AudioManager _am = null;
    TraeAudioSessionHost _audioSessionHost = null;
    d _bluetoothCheck = null;
    Context _context = null;
    e _deviceConfigManager = null;
    ReentrantLock _lock = new ReentrantLock();
    int _modePolicy = -1;
    int _prevMode = 0;
    int _streamType = 0;
    k _switchThread = null;
    f mTraeAudioManagerLooper = null;
    String sessionConnectedDev = DEVICE_NONE;

    abstract class d {
        public abstract void a();

        public abstract void a(Context context, Intent intent);

        public abstract void a(IntentFilter intentFilter);

        public abstract boolean a(Context context, e eVar);

        public abstract boolean b();

        public abstract String c();

        d() {
        }

        public void b(IntentFilter intentFilter) {
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            a(intentFilter);
        }

        public void a(Context context, Intent intent, e eVar) {
            if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + a(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + a(intExtra2));
                }
                if (intExtra == 10) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "    BT off");
                    }
                    eVar.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                } else if (intExtra == 12 && QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT OFF-->ON,Visiable it...");
                }
            } else if ("android.bluetooth.device.action.ACL_CONNECTED".equals(intent.getAction()) && VERSION.SDK_INT < 11) {
            } else {
                if (!"android.bluetooth.device.action.ACL_DISCONNECTED".equals(intent.getAction()) || VERSION.SDK_INT >= 11) {
                    a(context, intent);
                }
            }
        }

        /* Access modifiers changed, original: 0000 */
        public String a(int i) {
            String str;
            switch (i) {
                case 10:
                    str = "STATE_OFF";
                    break;
                case 11:
                    str = "STATE_TURNING_ON";
                    break;
                case 12:
                    str = "STATE_ON";
                    break;
                case 13:
                    str = "STATE_TURNING_OFF";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i;
        }

        /* Access modifiers changed, original: 0000 */
        public String b(int i) {
            String str;
            switch (i) {
                case -1:
                    str = "SCO_AUDIO_STATE_ERROR";
                    break;
                case 0:
                    str = "SCO_AUDIO_STATE_DISCONNECTED";
                    break;
                case 1:
                    str = "SCO_AUDIO_STATE_CONNECTED";
                    break;
                case 2:
                    str = "SCO_AUDIO_STATE_CONNECTING";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i;
        }

        /* Access modifiers changed, original: 0000 */
        public String c(int i) {
            String str;
            switch (i) {
                case 0:
                    str = "STATE_DISCONNECTED";
                    break;
                case 1:
                    str = "STATE_CONNECTING";
                    break;
                case 2:
                    str = "STATE_CONNECTED";
                    break;
                case 3:
                    str = "STATE_DISCONNECTING";
                    break;
                default:
                    str = "unknow";
                    break;
            }
            return str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + i;
        }
    }

    class f extends Thread {
        Handler a = null;
        TraeMediaPlayer b = null;
        long c = -1;
        String d = "";
        String e = "";
        final boolean[] f = new boolean[]{false};
        boolean g = false;
        TraeAudioManager h = null;
        String i = "";
        int j = 0;
        int k = 0;
        long l = -1;
        String m = "";
        OnAudioFocusChangeListener n = null;
        int o = 0;

        public f(TraeAudioManager traeAudioManager) {
            AppMethodBeat.i(65674);
            this.h = traeAudioManager;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "TraeAudioManagerLooper start...");
            }
            start();
            synchronized (this.f) {
                try {
                    if (!this.f[0]) {
                        try {
                            this.f.wait();
                        } catch (InterruptedException e) {
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(65674);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "  start used:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
            }
            AppMethodBeat.o(65674);
        }

        public void a() {
            AppMethodBeat.i(65675);
            AudioDeviceInterface.LogTraceEntry("");
            if (this.a == null) {
                AppMethodBeat.o(65675);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.a.getLooper().quit();
            synchronized (this.f) {
                try {
                    if (this.f[0]) {
                        try {
                            this.f.wait(10000);
                        } catch (InterruptedException e) {
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(65675);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "  quit used:" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
            }
            this.a = null;
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65675);
        }

        public int a(int i, HashMap<String, Object> hashMap) {
            AppMethodBeat.i(65676);
            if (this.a == null) {
                AudioDeviceInterface.LogTraceEntry(" fail mMsgHandler==null _enabled:" + (this.g ? "Y" : "N") + " activeMode:" + TraeAudioManager.this._activeMode + " msg:" + i);
                AppMethodBeat.o(65676);
                return -1;
            }
            if (this.a.sendMessage(Message.obtain(this.a, i, hashMap))) {
                AppMethodBeat.o(65676);
                return 0;
            }
            AppMethodBeat.o(65676);
            return -1;
        }

        /* Access modifiers changed, original: 0000 */
        public void a(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(65677);
            String str = (String) hashMap.get(TraeAudioManager.EXTRA_DATA_DEVICECONFIG);
            TXCLog.w("TRAE", "startService cfg:".concat(String.valueOf(str)));
            AudioDeviceInterface.LogTraceEntry(" _enabled:" + (this.g ? "Y" : "N") + " activeMode:" + TraeAudioManager.this._activeMode + " cfg:" + str);
            if (TraeAudioManager.this._context == null) {
                AppMethodBeat.o(65677);
                return;
            }
            QLog.w("TRAE", 2, "   startService:".concat(String.valueOf(str)));
            if (!(this.g && this.i.equals(str)) && TraeAudioManager.this._activeMode == 0) {
                if (this.g) {
                    b();
                }
                d();
                TraeAudioManager.this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                TraeAudioManager.this._deviceConfigManager.a();
                TraeAudioManager.this._deviceConfigManager.a(str);
                this.i = str;
                if (TraeAudioManager.this._am != null) {
                    this.j = TraeAudioManager.this._am.getMode();
                }
                this.g = true;
                if (this.b == null) {
                    this.b = new TraeMediaPlayer(TraeAudioManager.this._context, new com.tencent.rtmp.sharp.jni.TraeMediaPlayer.a() {
                        public void a() {
                            AppMethodBeat.i(65660);
                            if (QLog.isColorLevel()) {
                                QLog.w("TRAE", 2, "_ringPlayer onCompletion _activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + f.this.k);
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put(TraeAudioManager.PARAM_ISHOSTSIDE, Boolean.TRUE);
                            f.this.a(32783, hashMap);
                            f.this.j();
                            AppMethodBeat.o(65660);
                        }
                    });
                }
                a(this.g);
                TraeAudioManager.this.updateDeviceStatus();
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65677);
                return;
            }
            AppMethodBeat.o(65677);
        }

        /* Access modifiers changed, original: 0000 */
        public void b() {
            AppMethodBeat.i(65678);
            AudioDeviceInterface.LogTraceEntry(" _enabled:" + (this.g ? "Y" : "N") + " activeMode:" + TraeAudioManager.this._activeMode);
            if (this.g) {
                if (TraeAudioManager.this._activeMode == 1) {
                    h();
                } else if (TraeAudioManager.this._activeMode == 2) {
                    i();
                }
                if (TraeAudioManager.this._switchThread != null) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "_switchThread:" + TraeAudioManager.this._switchThread.b());
                    }
                    TraeAudioManager.this._switchThread.f();
                    TraeAudioManager.this._switchThread = null;
                }
                if (this.b != null) {
                    this.b.stopRing();
                }
                this.b = null;
                this.g = false;
                a(this.g);
                if (!(TraeAudioManager.this._am == null || TraeAudioManager.this._context == null)) {
                    try {
                        TraeAudioManager.this.InternalSetMode(0);
                    } catch (Exception e) {
                    }
                }
                e();
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65678);
                return;
            }
            AppMethodBeat.o(65678);
        }

        /* Access modifiers changed, original: 0000 */
        public int a(boolean z) {
            AppMethodBeat.i(65679);
            if (TraeAudioManager.this._context == null) {
                AppMethodBeat.o(65679);
                return -1;
            }
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_SERVICE_STATE);
            intent.putExtra(TraeAudioManager.NOTIFY_SERVICE_STATE_DATE, z);
            if (TraeAudioManager.this._context != null) {
                TraeAudioManager.this._context.sendBroadcast(intent);
            }
            AppMethodBeat.o(65679);
            return 0;
        }

        public void run() {
            AppMethodBeat.i(65680);
            AudioDeviceInterface.LogTraceEntry("");
            Looper.prepare();
            this.a = new Handler() {
                public void handleMessage(Message message) {
                    HashMap hashMap;
                    AppMethodBeat.i(65659);
                    try {
                        hashMap = (HashMap) message.obj;
                    } catch (Exception e) {
                        hashMap = null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "TraeAudioManagerLooper msg:" + message.what + " _enabled:" + (f.this.g ? "Y" : "N"));
                    }
                    if (message.what == 32772) {
                        f.this.a(hashMap);
                        AppMethodBeat.o(65659);
                    } else if (f.this.g) {
                        String f;
                        switch (message.what) {
                            case 32773:
                                f.this.b();
                                AppMethodBeat.o(65659);
                                return;
                            case 32774:
                                f.this.b(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32775:
                                TraeAudioManager.this.InternalSessionConnectDevice(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32776:
                                TraeAudioManager.this.InternalSessionEarAction(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32777:
                                TraeAudioManager.this.InternalSessionIsDeviceChangabled(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32778:
                                TraeAudioManager.this.InternalSessionGetConnectedDevice(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32779:
                                TraeAudioManager.this.InternalSessionGetConnectingDevice(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32780:
                                f.this.c(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32781:
                                f.this.d(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32782:
                                f.this.e(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32783:
                                f.this.f(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32784:
                                f.this.g(hashMap);
                                AppMethodBeat.o(65659);
                                return;
                            case 32785:
                            case 32789:
                                f = TraeAudioManager.this._deviceConfigManager.f();
                                String h = TraeAudioManager.this._deviceConfigManager.h();
                                if (QLog.isColorLevel()) {
                                    QLog.w("TRAE", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE  connectedDev:" + h + " highestDev" + f);
                                }
                                if (TraeAudioManager.IsUpdateSceneFlag) {
                                    if (!TraeAudioManager.IsMusicScene || TraeAudioManager.this.IsBluetoothA2dpExisted) {
                                        TraeAudioManager.this.InternalConnectDevice(f, null, true);
                                        AppMethodBeat.o(65659);
                                        return;
                                    }
                                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.e(TraeAudioManager.DEVICE_BLUETOOTHHEADSET), null, true);
                                    AppMethodBeat.o(65659);
                                    return;
                                } else if (f.equals(h)) {
                                    TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                                    AppMethodBeat.o(65659);
                                    return;
                                } else {
                                    TraeAudioManager.this.InternalConnectDevice(f, null, false);
                                    AppMethodBeat.o(65659);
                                    return;
                                }
                            case 32786:
                                f = (String) hashMap.get(TraeAudioManager.PARAM_DEVICE);
                                if (TraeAudioManager.this.InternalConnectDevice(f, null, false) != 0) {
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, " plugin dev:" + f + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
                                    }
                                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.f(), null, false);
                                    AppMethodBeat.o(65659);
                                    return;
                                }
                                break;
                            case 32787:
                                if (TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this.sessionConnectedDev, null, false) != 0) {
                                    f = (String) hashMap.get(TraeAudioManager.PARAM_DEVICE);
                                    if (QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, " plugout dev:" + f + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
                                    }
                                    TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.f(), null, false);
                                    break;
                                }
                                break;
                            case 32788:
                                Integer num = (Integer) hashMap.get(TraeAudioManager.PARAM_STREAMTYPE);
                                if (num != null) {
                                    TraeAudioManager.this._streamType = num.intValue();
                                    f.this.b(num.intValue());
                                    AppMethodBeat.o(65659);
                                    return;
                                } else if (QLog.isColorLevel()) {
                                    QLog.e("TRAE", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
                                    AppMethodBeat.o(65659);
                                    return;
                                }
                                break;
                            case 32790:
                                f.this.g();
                                AppMethodBeat.o(65659);
                                return;
                            case 32791:
                                f.this.a(TraeAudioManager.this._streamType);
                                AppMethodBeat.o(65659);
                                return;
                        }
                        AppMethodBeat.o(65659);
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "******* disabled ,skip msg******");
                        }
                        TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 1);
                        AppMethodBeat.o(65659);
                    }
                }
            };
            c();
            synchronized (this.f) {
                try {
                    this.f[0] = true;
                    this.f.notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(65680);
                }
            }
            Looper.loop();
            f();
            synchronized (this.f) {
                try {
                    this.f[0] = false;
                    this.f.notify();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(65680);
                    }
                }
            }
            AudioDeviceInterface.LogTraceExit();
        }

        /* Access modifiers changed, original: 0000 */
        public void c() {
            AppMethodBeat.i(65681);
            AudioDeviceInterface.LogTraceEntry("");
            try {
                TraeAudioManager.this._audioSessionHost = new TraeAudioSessionHost();
                TraeAudioManager.this._deviceConfigManager = new e();
                TraeAudioManager._gHostProcessId = Process.myPid();
                TraeAudioManager.this._am = (AudioManager) TraeAudioManager.this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                TraeAudioManager.this._bluetoothCheck.b(intentFilter);
                intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                TraeAudioManager.this._context.registerReceiver(this.h, intentFilter);
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "======7");
                }
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65681);
        }

        /* Access modifiers changed, original: 0000 */
        public void d() {
            AppMethodBeat.i(65682);
            try {
                TraeAudioManager.this._am = (AudioManager) TraeAudioManager.this._context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                if (TraeAudioManager.this._bluetoothCheck == null) {
                    TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
                }
                TraeAudioManager.this._context.unregisterReceiver(this.h);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
                TraeAudioManager.this._bluetoothCheck.b(intentFilter);
                intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                TraeAudioManager.this._context.registerReceiver(this.h, intentFilter);
                AppMethodBeat.o(65682);
            } catch (Exception e) {
                AppMethodBeat.o(65682);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void e() {
            AppMethodBeat.i(65683);
            try {
                if (TraeAudioManager.this._bluetoothCheck != null) {
                    TraeAudioManager.this._bluetoothCheck.a();
                }
                TraeAudioManager.this._bluetoothCheck = null;
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.unregisterReceiver(this.h);
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
                    TraeAudioManager.this._context.registerReceiver(this.h, intentFilter);
                }
                AppMethodBeat.o(65683);
            } catch (Exception e) {
                AppMethodBeat.o(65683);
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void f() {
            AppMethodBeat.i(65684);
            AudioDeviceInterface.LogTraceEntry("");
            try {
                b();
                if (TraeAudioManager.this._bluetoothCheck != null) {
                    TraeAudioManager.this._bluetoothCheck.a();
                }
                TraeAudioManager.this._bluetoothCheck = null;
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.unregisterReceiver(this.h);
                    TraeAudioManager.this._context = null;
                }
                if (TraeAudioManager.this._deviceConfigManager != null) {
                    TraeAudioManager.this._deviceConfigManager.a();
                }
                TraeAudioManager.this._deviceConfigManager = null;
            } catch (Exception e) {
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65684);
        }

        /* Access modifiers changed, original: 0000 */
        public int b(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(65685);
            Intent intent = new Intent();
            HashMap j = TraeAudioManager.this._deviceConfigManager.j();
            ArrayList arrayList = (ArrayList) j.get(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
            String str = (String) j.get(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
            String str2 = (String) j.get(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
            intent.putExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, (String[]) arrayList.toArray(new String[0]));
            intent.putExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, str);
            intent.putExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, str2);
            intent.putExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME, TraeAudioManager.this._deviceConfigManager.d());
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            AppMethodBeat.o(65685);
            return 0;
        }

        /* Access modifiers changed, original: 0000 */
        @TargetApi(8)
        public void a(int i) {
            AppMethodBeat.i(65686);
            if (VERSION.SDK_INT <= 8) {
                AppMethodBeat.o(65686);
                return;
            }
            if (this.n == null) {
                this.n = new OnAudioFocusChangeListener() {
                    @TargetApi(8)
                    public void onAudioFocusChange(int i) {
                        AppMethodBeat.i(65653);
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "focusChange:" + i + " _focusSteamType:" + f.this.o + " currMode:" + TraeAudioManager.this._am.getMode() + " _activeMode:" + TraeAudioManager.this._activeMode);
                        }
                        AppMethodBeat.o(65653);
                    }
                };
                if (TraeAudioManager.this._am != null) {
                    int requestAudioFocus = TraeAudioManager.this._am.requestAudioFocus(this.n, i, 1);
                    if (requestAudioFocus != 1 && QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "request audio focus fail. " + requestAudioFocus + " mode:" + TraeAudioManager.this._am.getMode());
                    }
                    this.o = i;
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "-------requestAudioFocus _focusSteamType:" + this.o);
                    }
                }
            }
            AppMethodBeat.o(65686);
        }

        /* Access modifiers changed, original: 0000 */
        @TargetApi(8)
        public void g() {
            AppMethodBeat.i(65687);
            if (VERSION.SDK_INT <= 8) {
                AppMethodBeat.o(65687);
                return;
            }
            if (!(TraeAudioManager.this._am == null || this.n == null)) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "-------abandonAudioFocus _focusSteamType:" + this.o);
                }
                TraeAudioManager.this._am.abandonAudioFocus(this.n);
                this.n = null;
            }
            AppMethodBeat.o(65687);
        }

        /* Access modifiers changed, original: 0000 */
        public int c(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(65688);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (hashMap == null) {
                AppMethodBeat.o(65688);
                return -1;
            } else if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalVoicecallPreprocess am==null!!");
                }
                AppMethodBeat.o(65688);
                return -1;
            } else if (TraeAudioManager.this._activeMode == 1) {
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 2);
                AppMethodBeat.o(65688);
                return -1;
            } else {
                this.l = ((Long) hashMap.get(TraeAudioManager.PARAM_SESSIONID)).longValue();
                this.m = (String) hashMap.get(TraeAudioManager.PARAM_OPERATION);
                TraeAudioManager.this._activeMode = 1;
                TraeAudioManager.this._prevMode = TraeAudioManager.this._am.getMode();
                Integer.valueOf(-1);
                Integer.valueOf(0);
                Integer num = (Integer) hashMap.get(TraeAudioManager.PARAM_MODEPOLICY);
                if (num == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, " params.get(PARAM_MODEPOLICY)==null!!");
                    }
                    TraeAudioManager.this._modePolicy = -1;
                } else {
                    TraeAudioManager.this._modePolicy = num.intValue();
                }
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "  _modePolicy:" + TraeAudioManager.this._modePolicy);
                }
                num = (Integer) hashMap.get(TraeAudioManager.PARAM_STREAMTYPE);
                if (num == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, " params.get(PARAM_STREAMTYPE)==null!!");
                    }
                    TraeAudioManager.this._streamType = 0;
                } else {
                    TraeAudioManager.this._streamType = num.intValue();
                }
                if (!TraeAudioManager.isCloseSystemAPM(TraeAudioManager.this._modePolicy) || TraeAudioManager.this._activeMode == 2 || TraeAudioManager.this._deviceConfigManager == null) {
                    TraeAudioManager.this.InternalSetMode(TraeAudioManager.getCallAudioMode(TraeAudioManager.this._modePolicy));
                    a(TraeAudioManager.this._streamType);
                } else if (TraeAudioManager.this._deviceConfigManager.h().equals(TraeAudioManager.DEVICE_SPEAKERPHONE)) {
                    TraeAudioManager.this.InternalSetMode(0);
                    a(3);
                } else {
                    TraeAudioManager.this.InternalSetMode(3);
                    a(0);
                }
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 0);
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65688);
                return 0;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public int d(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(65689);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalVoicecallPostprocess am==null!!");
                }
                AppMethodBeat.o(65689);
                return -1;
            } else if (TraeAudioManager.this._activeMode != 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_VOICECALL!!");
                }
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 3);
                AppMethodBeat.o(65689);
                return -1;
            } else {
                TraeAudioManager.this._activeMode = 0;
                g();
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65689);
                return 0;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public int h() {
            AppMethodBeat.i(65690);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " am==null!!");
                }
                AppMethodBeat.o(65690);
                return -1;
            } else if (TraeAudioManager.this._activeMode != 1) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
                }
                AppMethodBeat.o(65690);
                return -1;
            } else {
                TraeAudioManager.this._activeMode = 0;
                if (TraeAudioManager.this._prevMode != -1) {
                    TraeAudioManager.this.InternalSetMode(TraeAudioManager.this._prevMode);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.l));
                hashMap.put(TraeAudioManager.PARAM_OPERATION, this.m);
                TraeAudioManager.this.sendResBroadcast(new Intent(), hashMap, 6);
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65690);
                return 0;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public int e(HashMap<String, Object> hashMap) {
            boolean z = true;
            AppMethodBeat.i(65691);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalStartRing am==null!!");
                }
                AppMethodBeat.o(65691);
                return -1;
            }
            if (TraeAudioManager.this._activeMode == 2) {
                i();
            }
            try {
                this.c = ((Long) hashMap.get(TraeAudioManager.PARAM_SESSIONID)).longValue();
                this.d = (String) hashMap.get(TraeAudioManager.PARAM_OPERATION);
                this.e = (String) hashMap.get(TraeAudioManager.PARAM_RING_USERDATA_STRING);
                int intValue = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_DATASOURCE)).intValue();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "  dataSource:".concat(String.valueOf(intValue)));
                }
                int intValue2 = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_RSID)).intValue();
                Uri uri = (Uri) hashMap.get(TraeAudioManager.PARAM_RING_URI);
                String str = (String) hashMap.get(TraeAudioManager.PARAM_RING_FILEPATH);
                boolean booleanValue = ((Boolean) hashMap.get(TraeAudioManager.PARAM_RING_LOOP)).booleanValue();
                int intValue3 = ((Integer) hashMap.get(TraeAudioManager.PARAM_RING_LOOPCOUNT)).intValue();
                boolean booleanValue2 = ((Boolean) hashMap.get(TraeAudioManager.PARAM_RING_MODE)).booleanValue();
                if (TraeAudioManager.this._activeMode != 1) {
                    TraeAudioManager.this._activeMode = 2;
                }
                Intent intent = new Intent();
                intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.e);
                TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
                this.k = TraeAudioManager.this._am.getMode();
                TraeMediaPlayer traeMediaPlayer = this.b;
                if (TraeAudioManager.this._activeMode != 1) {
                    z = false;
                }
                traeMediaPlayer.playRing(intValue, intValue2, uri, str, booleanValue, intValue3, booleanValue2, z, TraeAudioManager.this._streamType);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " _ringUserdata:" + this.e + " DurationMS:" + this.b.getDuration());
                }
                if (!this.b.hasCall()) {
                    a(this.b.getStreamType());
                }
                b(this.b.getStreamType());
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65691);
                return 0;
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " startRing err params");
                }
                AppMethodBeat.o(65691);
                return -1;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public int f(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(65692);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this.k);
            if (TraeAudioManager.this._am == null || this.b == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalStopRing am==null!!");
                }
                AppMethodBeat.o(65692);
                return -1;
            }
            this.b.stopRing();
            if (!this.b.hasCall() && TraeAudioManager.this._activeMode == 2) {
                g();
                TraeAudioManager.this._activeMode = 0;
            }
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.e);
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65692);
            return 0;
        }

        /* Access modifiers changed, original: 0000 */
        public int g(HashMap<String, Object> hashMap) {
            AppMethodBeat.i(65693);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this.k);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " InternalStopRing am==null!!");
                }
                AppMethodBeat.o(65693);
                return -1;
            }
            int streamType;
            if (TraeAudioManager.this._activeMode == 2) {
                streamType = this.b.getStreamType();
            } else {
                streamType = TraeAudioManager.this._streamType;
            }
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, streamType);
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65693);
            return 0;
        }

        /* Access modifiers changed, original: 0000 */
        public int b(final int i) {
            AppMethodBeat.i(65694);
            if (TraeAudioManager.this._context == null) {
                AppMethodBeat.o(65694);
                return -1;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(65759);
                    Intent intent = new Intent();
                    intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                    intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_STREAMTYPE_UPDATE);
                    intent.putExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, i);
                    if (TraeAudioManager.this._context != null) {
                        TraeAudioManager.this._context.sendBroadcast(intent);
                    }
                    AppMethodBeat.o(65759);
                }
            });
            AppMethodBeat.o(65694);
            return 0;
        }

        /* Access modifiers changed, original: 0000 */
        public int i() {
            AppMethodBeat.i(65695);
            AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this.k);
            if (TraeAudioManager.this._am == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " interruptRing am==null!!");
                }
                AppMethodBeat.o(65695);
                return -1;
            } else if (TraeAudioManager.this._activeMode != 2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " not ACTIVE_RING!!");
                }
                AppMethodBeat.o(65695);
                return -1;
            } else {
                this.b.stopRing();
                g();
                TraeAudioManager.this._activeMode = 0;
                HashMap hashMap = new HashMap();
                hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.c));
                hashMap.put(TraeAudioManager.PARAM_OPERATION, this.d);
                Intent intent = new Intent();
                intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.e);
                TraeAudioManager.this.sendResBroadcast(intent, hashMap, 4);
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65695);
                return 0;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public void j() {
            AppMethodBeat.i(65696);
            HashMap hashMap = new HashMap();
            hashMap.put(TraeAudioManager.PARAM_SESSIONID, Long.valueOf(this.c));
            hashMap.put(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_RING_COMPLETION);
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, this.e);
            TraeAudioManager.this.sendResBroadcast(intent, hashMap, 0);
            AppMethodBeat.o(65696);
        }
    }

    class e {
        HashMap<String, a> a = new HashMap();
        String b = TraeAudioManager.DEVICE_NONE;
        String c = TraeAudioManager.DEVICE_NONE;
        String d = TraeAudioManager.DEVICE_NONE;
        ReentrantLock e = new ReentrantLock();
        boolean f = false;
        String g = "unknow";

        public class a {
            String a = TraeAudioManager.DEVICE_NONE;
            boolean b = false;
            int c = 0;

            public boolean a(String str, int i) {
                AppMethodBeat.i(65824);
                if (str == null || str.length() <= 0) {
                    AppMethodBeat.o(65824);
                    return false;
                } else if (!TraeAudioManager.checkDevName(str)) {
                    AppMethodBeat.o(65824);
                    return false;
                } else {
                    this.a = str;
                    this.c = i;
                    AppMethodBeat.o(65824);
                    return true;
                }
            }

            public String a() {
                return this.a;
            }

            public boolean b() {
                return this.b;
            }

            public int c() {
                return this.c;
            }

            public void a(boolean z) {
                this.b = z;
            }
        }

        public e() {
            AppMethodBeat.i(65625);
            AppMethodBeat.o(65625);
        }

        public boolean a(String str) {
            AppMethodBeat.i(65626);
            AudioDeviceInterface.LogTraceEntry(" strConfigs:".concat(String.valueOf(str)));
            if (str == null || str.length() <= 0) {
                AppMethodBeat.o(65626);
                return false;
            }
            String replace = str.replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\r", "");
            if (replace == null || replace.length() <= 0) {
                AppMethodBeat.o(65626);
                return false;
            }
            if (replace.indexOf(";") < 0) {
                replace = replace + ";";
            }
            String[] split = replace.split(";");
            if (split == null || 1 > split.length) {
                AppMethodBeat.o(65626);
                return false;
            }
            this.e.lock();
            for (int i = 0; i < split.length; i++) {
                a(split[i], i);
            }
            this.e.unlock();
            TraeAudioManager.this.printDevices();
            AppMethodBeat.o(65626);
            return true;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean a(String str, int i) {
            AppMethodBeat.i(65627);
            AudioDeviceInterface.LogTraceEntry(" devName:" + str + " priority:" + i);
            a aVar = new a();
            if (!aVar.a(str, i)) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err dev init!");
                }
                AppMethodBeat.o(65627);
                return false;
            } else if (this.a.containsKey(str)) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "err dev exist!");
                }
                AppMethodBeat.o(65627);
                return false;
            } else {
                this.a.put(str, aVar);
                this.f = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " n" + e() + " 0:" + a(0));
                }
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65627);
                return true;
            }
        }

        public void a() {
            AppMethodBeat.i(65628);
            this.e.lock();
            this.a.clear();
            this.b = TraeAudioManager.DEVICE_NONE;
            this.c = TraeAudioManager.DEVICE_NONE;
            this.d = TraeAudioManager.DEVICE_NONE;
            this.e.unlock();
            AppMethodBeat.o(65628);
        }

        public boolean b() {
            AppMethodBeat.i(65629);
            this.e.lock();
            boolean z = this.f;
            this.e.unlock();
            AppMethodBeat.o(65629);
            return z;
        }

        public void c() {
            AppMethodBeat.i(65630);
            this.e.lock();
            this.f = false;
            this.e.unlock();
            AppMethodBeat.o(65630);
        }

        public boolean a(String str, boolean z) {
            boolean z2;
            AppMethodBeat.i(65631);
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar == null || aVar.b() == z) {
                z2 = false;
            } else {
                aVar.a(z);
                this.f = true;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " ++setVisible:" + str + (z ? " Y" : " N"));
                }
                z2 = true;
            }
            this.e.unlock();
            AppMethodBeat.o(65631);
            return z2;
        }

        public void b(String str) {
            AppMethodBeat.i(65632);
            if (str == null) {
                this.g = "unknow";
                AppMethodBeat.o(65632);
            } else if (str.isEmpty()) {
                this.g = "unknow";
                AppMethodBeat.o(65632);
            } else {
                this.g = str;
                AppMethodBeat.o(65632);
            }
        }

        public String d() {
            return this.g;
        }

        public boolean c(String str) {
            boolean b;
            AppMethodBeat.i(65633);
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar != null) {
                b = aVar.b();
            } else {
                b = false;
            }
            this.e.unlock();
            AppMethodBeat.o(65633);
            return b;
        }

        public int d(String str) {
            int c;
            AppMethodBeat.i(65634);
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar != null) {
                c = aVar.c();
            } else {
                c = -1;
            }
            this.e.unlock();
            AppMethodBeat.o(65634);
            return c;
        }

        public int e() {
            AppMethodBeat.i(65635);
            this.e.lock();
            int size = this.a.size();
            this.e.unlock();
            AppMethodBeat.o(65635);
            return size;
        }

        public String a(int i) {
            a aVar;
            String a;
            AppMethodBeat.i(65636);
            String str = TraeAudioManager.DEVICE_NONE;
            int i2 = 0;
            this.e.lock();
            Iterator it = this.a.entrySet().iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                Entry entry = (Entry) it.next();
                if (i3 == i) {
                    aVar = (a) entry.getValue();
                    break;
                }
                i2 = i3 + 1;
            }
            if (aVar != null) {
                a = aVar.a();
            } else {
                a = str;
            }
            this.e.unlock();
            AppMethodBeat.o(65636);
            return a;
        }

        public String e(String str) {
            AppMethodBeat.i(65637);
            this.e.lock();
            a aVar = null;
            for (Entry entry : this.a.entrySet()) {
                entry.getKey();
                entry.getValue();
                a aVar2 = (a) entry.getValue();
                if (!(aVar2 == null || !aVar2.b() || aVar2.a().equals(str))) {
                    if (aVar == null) {
                        aVar = aVar2;
                    } else {
                        if (aVar2.c() < aVar.c()) {
                            aVar2 = aVar;
                        }
                        aVar = aVar2;
                    }
                }
            }
            this.e.unlock();
            String a;
            if (aVar != null) {
                a = aVar.a();
                AppMethodBeat.o(65637);
                return a;
            }
            a = TraeAudioManager.DEVICE_SPEAKERPHONE;
            AppMethodBeat.o(65637);
            return a;
        }

        public String f() {
            AppMethodBeat.i(65638);
            this.e.lock();
            a aVar = null;
            for (Entry entry : this.a.entrySet()) {
                entry.getKey();
                entry.getValue();
                a aVar2 = (a) entry.getValue();
                if (aVar2 != null && aVar2.b()) {
                    if (aVar == null) {
                        aVar = aVar2;
                    } else {
                        if (aVar2.c() < aVar.c()) {
                            aVar2 = aVar;
                        }
                        aVar = aVar2;
                    }
                }
            }
            this.e.unlock();
            String a;
            if (aVar != null) {
                a = aVar.a();
                AppMethodBeat.o(65638);
                return a;
            }
            a = TraeAudioManager.DEVICE_SPEAKERPHONE;
            AppMethodBeat.o(65638);
            return a;
        }

        public String g() {
            String str;
            AppMethodBeat.i(65639);
            this.e.lock();
            a aVar = (a) this.a.get(this.d);
            if (aVar == null || !aVar.b()) {
                str = null;
            } else {
                str = this.d;
            }
            this.e.unlock();
            AppMethodBeat.o(65639);
            return str;
        }

        public String h() {
            AppMethodBeat.i(65640);
            this.e.lock();
            String m = m();
            this.e.unlock();
            AppMethodBeat.o(65640);
            return m;
        }

        public String i() {
            AppMethodBeat.i(65641);
            this.e.lock();
            String n = n();
            this.e.unlock();
            AppMethodBeat.o(65641);
            return n;
        }

        public boolean f(String str) {
            boolean z;
            AppMethodBeat.i(65642);
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar == null || !aVar.b()) {
                z = false;
            } else {
                this.d = str;
                z = true;
            }
            this.e.unlock();
            AppMethodBeat.o(65642);
            return z;
        }

        public boolean g(String str) {
            boolean z;
            AppMethodBeat.i(65643);
            this.e.lock();
            a aVar = (a) this.a.get(str);
            if (aVar == null || !aVar.b()) {
                z = false;
            } else {
                if (!(this.c == null || this.c.equals(str))) {
                    this.b = this.c;
                }
                this.c = str;
                this.d = "";
                z = true;
            }
            this.e.unlock();
            AppMethodBeat.o(65643);
            return z;
        }

        public HashMap<String, Object> j() {
            AppMethodBeat.i(65644);
            HashMap hashMap = new HashMap();
            this.e.lock();
            hashMap.put(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, l());
            hashMap.put(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, m());
            hashMap.put(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, n());
            this.e.unlock();
            AppMethodBeat.o(65644);
            return hashMap;
        }

        public ArrayList<String> k() {
            AppMethodBeat.i(65645);
            ArrayList arrayList = new ArrayList();
            this.e.lock();
            arrayList = l();
            this.e.unlock();
            AppMethodBeat.o(65645);
            return arrayList;
        }

        /* Access modifiers changed, original: 0000 */
        public ArrayList<String> l() {
            AppMethodBeat.i(65646);
            ArrayList arrayList = new ArrayList();
            for (Entry value : this.a.entrySet()) {
                a aVar = (a) value.getValue();
                if (aVar != null && aVar.b()) {
                    arrayList.add(aVar.a());
                }
            }
            AppMethodBeat.o(65646);
            return arrayList;
        }

        /* Access modifiers changed, original: 0000 */
        public String m() {
            String str;
            AppMethodBeat.i(65647);
            String str2 = TraeAudioManager.DEVICE_NONE;
            a aVar = (a) this.a.get(this.c);
            if (aVar == null || !aVar.b()) {
                str = str2;
            } else {
                str = this.c;
            }
            AppMethodBeat.o(65647);
            return str;
        }

        /* Access modifiers changed, original: 0000 */
        public String n() {
            String str;
            AppMethodBeat.i(65648);
            String str2 = TraeAudioManager.DEVICE_NONE;
            a aVar = (a) this.a.get(this.b);
            if (aVar == null || !aVar.b()) {
                str = str2;
            } else {
                str = this.b;
            }
            AppMethodBeat.o(65648);
            return str;
        }
    }

    class g extends k {
        g() {
            super();
        }

        public void a() {
            AppMethodBeat.i(65650);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "connect bluetoothHeadset: do nothing");
            }
            e();
            AppMethodBeat.o(65650);
        }

        public String b() {
            return TraeAudioManager.DEVICE_BLUETOOTHHEADSET;
        }

        @TargetApi(8)
        public void c() {
            AppMethodBeat.i(65651);
            if (TraeAudioManager.this._am == null) {
                AppMethodBeat.o(65651);
                return;
            }
            d();
            AppMethodBeat.o(65651);
        }

        /* Access modifiers changed, original: 0000 */
        @TargetApi(8)
        public void d() {
            AppMethodBeat.i(65652);
            if (VERSION.SDK_INT > 8) {
                TraeAudioManager.this._am.stopBluetoothSco();
            }
            TraeAudioManager.this._am.setBluetoothScoOn(false);
            AppMethodBeat.o(65652);
        }
    }

    abstract class k extends Thread {
        boolean b = true;
        boolean[] c = new boolean[]{false};
        HashMap<String, Object> d = null;
        long e = 0;

        public abstract void a();

        public abstract String b();

        public abstract void c();

        k() {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " ++switchThread:" + b());
            }
        }

        public void a(HashMap<String, Object> hashMap) {
            this.d = hashMap;
        }

        /* Access modifiers changed, original: 0000 */
        public void e() {
            TraeAudioManager.this._deviceConfigManager.g(b());
            a(0);
        }

        /* Access modifiers changed, original: 0000 */
        public void a(int i) {
            TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
            AudioDeviceInterface.LogTraceEntry(b() + " err:" + i);
            if (this.d == null) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                return;
            }
            TraeAudioManager.this.sessionConnectedDev = TraeAudioManager.this._deviceConfigManager.h();
            Long l = (Long) this.d.get(TraeAudioManager.PARAM_SESSIONID);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " sessonID:".concat(String.valueOf(l)));
            }
            if (l == null || l.longValue() == Long.MIN_VALUE) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "processDeviceConnectRes sid null,don't send res");
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(TraeAudioManager.CONNECTDEVICE_RESULT_DEVICENAME, (String) this.d.get(TraeAudioManager.PARAM_DEVICE));
            if (TraeAudioManager.this.sendResBroadcast(intent, this.d, i) == 0) {
                TraeAudioManager.this.InternalNotifyDeviceListUpdate();
            }
            AudioDeviceInterface.LogTraceExit();
        }

        public void run() {
            AudioDeviceInterface.LogTraceEntry(b());
            TraeAudioManager.this._deviceConfigManager.f(b());
            TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
            a();
            synchronized (this.c) {
                this.c[0] = true;
                this.c.notify();
            }
            AudioDeviceInterface.LogTraceExit();
        }

        public void f() {
            AudioDeviceInterface.LogTraceEntry(b());
            this.b = false;
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " quit:" + b() + " _running:" + this.b);
            }
            interrupt();
            c();
            synchronized (this.c) {
                if (!this.c[0]) {
                    try {
                        this.c.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
            AudioDeviceInterface.LogTraceExit();
        }
    }

    class h extends k {
        h() {
            super();
        }

        public void a() {
            AppMethodBeat.i(65798);
            if (TraeAudioManager.IsUpdateSceneFlag) {
                e();
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "connect earphone: do nothing");
            }
            AppMethodBeat.o(65798);
        }

        public String b() {
            return TraeAudioManager.DEVICE_EARPHONE;
        }

        public void c() {
        }
    }

    class i extends k {
        i() {
            super();
        }

        public void a() {
            AppMethodBeat.i(65658);
            if (!TraeAudioManager.IsMusicScene && TraeAudioManager.IsUpdateSceneFlag) {
                TraeAudioManager.this._am.setWiredHeadsetOn(true);
            }
            e();
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "connect headset: do nothing");
            }
            AppMethodBeat.o(65658);
        }

        public String b() {
            return TraeAudioManager.DEVICE_WIREDHEADSET;
        }

        public void c() {
        }
    }

    class j extends k {
        j() {
            super();
        }

        public void a() {
            AppMethodBeat.i(65649);
            if (!TraeAudioManager.IsMusicScene && TraeAudioManager.IsUpdateSceneFlag) {
                e();
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "connect speakerPhone: do nothing");
            }
            AppMethodBeat.o(65649);
        }

        public String b() {
            return TraeAudioManager.DEVICE_SPEAKERPHONE;
        }

        public void c() {
        }
    }

    @TargetApi(11)
    class a extends d implements ServiceListener {
        Context a = null;
        e b = null;
        BluetoothAdapter c = null;
        BluetoothProfile d = null;
        private final ReentrantLock f = new ReentrantLock();

        a() {
            super();
            AppMethodBeat.i(65611);
            AppMethodBeat.o(65611);
        }

        @TargetApi(11)
        public boolean a(Context context, e eVar) {
            AppMethodBeat.i(65612);
            AudioDeviceInterface.LogTraceEntry("");
            if (context == null || eVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err ctx==null||_devCfg==null");
                }
                AppMethodBeat.o(65612);
                return false;
            }
            this.a = context;
            this.b = eVar;
            this.c = BluetoothAdapter.getDefaultAdapter();
            if (this.c == null) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " err getDefaultAdapter fail!");
                }
                AppMethodBeat.o(65612);
                return false;
            }
            this.f.lock();
            try {
                if (this.c.isEnabled() && this.d == null && !this.c.getProfileProxy(this.a, this, 1)) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TRAE", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
                    }
                    this.f.unlock();
                    AppMethodBeat.o(65612);
                    return false;
                }
                this.f.unlock();
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65612);
                return true;
            } catch (Throwable th) {
                this.f.unlock();
                AppMethodBeat.o(65612);
            }
        }

        public void a() {
            AppMethodBeat.i(65613);
            AudioDeviceInterface.LogTraceEntry("_profile:" + this.d);
            this.f.lock();
            try {
                if (this.c != null) {
                    if (this.d != null) {
                        this.c.closeProfileProxy(1, this.d);
                    }
                    this.d = null;
                }
                this.f.unlock();
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " closeProfileProxy:e:" + e.getMessage());
                }
                this.f.unlock();
            } catch (Throwable th) {
                this.f.unlock();
                AppMethodBeat.o(65613);
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65613);
        }

        public boolean b() {
            boolean z = false;
            AppMethodBeat.i(65614);
            this.f.lock();
            try {
                if (this.d != null) {
                    List connectedDevices = this.d.getConnectedDevices();
                    if (connectedDevices == null) {
                        return z;
                    }
                    if (connectedDevices.size() > 0) {
                        z = true;
                    }
                }
                this.f.unlock();
                AppMethodBeat.o(65614);
                return z;
            } finally {
                this.f.unlock();
                AppMethodBeat.o(65614);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x00d3 A:{SYNTHETIC, Splitter:B:30:0x00d3} */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0113 A:{SYNTHETIC} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x00e2 A:{Catch:{ all -> 0x0146 }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        @TargetApi(11)
        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            AppMethodBeat.i(65615);
            AudioDeviceInterface.LogTraceEntry("_profile:" + this.d + " profile:" + i + " proxy:" + bluetoothProfile);
            if (i == 1) {
                this.f.lock();
                try {
                    List connectedDevices;
                    if (!(this.d == null || this.d == bluetoothProfile)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + bluetoothProfile + " _profile:" + this.d);
                        }
                        this.c.closeProfileProxy(1, this.d);
                        this.d = null;
                    }
                    this.d = bluetoothProfile;
                    if (this.d != null) {
                        connectedDevices = this.d.getConnectedDevices();
                    } else {
                        connectedDevices = null;
                    }
                    if (!(connectedDevices == null || this.d == null)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + connectedDevices.size() + " _profile:" + this.d);
                        }
                        for (int i2 = 0; i2 < connectedDevices.size(); i2++) {
                            int connectionState;
                            BluetoothDevice bluetoothDevice = (BluetoothDevice) connectedDevices.get(i2);
                            try {
                                if (this.d != null) {
                                    connectionState = this.d.getConnectionState(bluetoothDevice);
                                    if (connectionState == 2) {
                                        this.b.b(bluetoothDevice.getName());
                                    }
                                    if (!QLog.isColorLevel()) {
                                        QLog.w("TRAE", 2, "   " + i2 + " " + bluetoothDevice.getName() + " ConnectionState:" + connectionState);
                                    }
                                }
                            } catch (Exception e) {
                            }
                            connectionState = 0;
                            if (connectionState == 2) {
                            }
                            if (!QLog.isColorLevel()) {
                            }
                        }
                    }
                    this.f.unlock();
                    if (this.b != null) {
                        CharSequence d;
                        if (TraeAudioManager.this._deviceConfigManager != null) {
                            d = TraeAudioManager.this._deviceConfigManager.d();
                        } else {
                            d = null;
                        }
                        if (TextUtils.isEmpty(d)) {
                            this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                        } else if (b()) {
                            this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                            TraeAudioManager.this.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                        } else {
                            this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                        }
                    }
                } catch (Throwable th) {
                    this.f.unlock();
                    AppMethodBeat.o(65615);
                }
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65615);
        }

        @TargetApi(11)
        public void onServiceDisconnected(int i) {
            AppMethodBeat.i(65616);
            AudioDeviceInterface.LogTraceEntry("_profile:" + this.d + " profile:" + i);
            if (i == 1) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
                }
                if (b()) {
                    TraeAudioManager.this.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
                this.f.lock();
                try {
                    if (this.d != null) {
                        this.c.closeProfileProxy(1, this.d);
                        this.d = null;
                    }
                    this.f.unlock();
                } catch (Throwable th) {
                    this.f.unlock();
                    AppMethodBeat.o(65616);
                }
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65616);
        }

        /* Access modifiers changed, original: 0000 */
        public void a(IntentFilter intentFilter) {
            AppMethodBeat.i(65617);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " " + c() + " _addAction");
            }
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
            AppMethodBeat.o(65617);
        }

        /* Access modifiers changed, original: 0000 */
        public void a(Context context, Intent intent) {
            AppMethodBeat.i(65618);
            int intExtra;
            int intExtra2;
            BluetoothDevice bluetoothDevice;
            if (!"android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                if (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(intent.getAction())) {
                    if ("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        switch (defaultAdapter.getProfileConnectionState(2)) {
                            case 0:
                                QLog.w("TRAE", 2, "BluetoothA2dp STATE_DISCONNECTED");
                                TraeAudioManager.this.IsBluetoothA2dpExisted = false;
                                AppMethodBeat.o(65618);
                                return;
                            case 2:
                                QLog.w("TRAE", 2, "BluetoothA2dp STATE_CONNECTED");
                                TraeAudioManager.this.IsBluetoothA2dpExisted = true;
                                AppMethodBeat.o(65618);
                                return;
                            default:
                                QLog.w("TRAE", 2, "BluetoothA2dp" + defaultAdapter.getProfileConnectionState(2));
                                break;
                        }
                    }
                }
                intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
                intExtra2 = intent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
                bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:".concat(String.valueOf(bluetoothDevice)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_STATE " + b(intExtra));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + b(intExtra2));
                    AppMethodBeat.o(65618);
                    return;
                }
            }
            intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
            intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
            bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + c(intExtra2));
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + c(intExtra));
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "    EXTRA_DEVICE " + bluetoothDevice + " " + (bluetoothDevice != null ? bluetoothDevice.getName() : " "));
            }
            if (intExtra2 == 2) {
                String name;
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "   dev:" + bluetoothDevice.getName() + " connected,start sco...");
                }
                this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                e eVar = this.b;
                if (bluetoothDevice != null) {
                    name = bluetoothDevice.getName();
                } else {
                    name = "unkown";
                }
                eVar.b(name);
                AppMethodBeat.o(65618);
                return;
            } else if (intExtra2 == 0) {
                this.b.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                AppMethodBeat.o(65618);
                return;
            }
            AppMethodBeat.o(65618);
        }

        public String c() {
            return "BluetoohHeadsetCheck";
        }
    }

    class b extends d {
        b() {
            super();
        }

        public boolean a(Context context, e eVar) {
            return true;
        }

        public void a() {
        }

        public boolean b() {
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        public void a(IntentFilter intentFilter) {
        }

        /* Access modifiers changed, original: 0000 */
        public void a(Context context, Intent intent) {
        }

        public String c() {
            return "BluetoohHeadsetCheckFake";
        }
    }

    class c extends d {
        Class<?> a = null;
        Class<?> b = null;
        Object c = null;
        Method d = null;
        Context e = null;
        e f = null;

        c() {
            super();
        }

        public boolean a(Context context, e eVar) {
            AppMethodBeat.i(65664);
            AudioDeviceInterface.LogTraceEntry("");
            this.e = context;
            this.f = eVar;
            if (this.e == null || this.f == null) {
                AppMethodBeat.o(65664);
                return false;
            }
            try {
                this.a = Class.forName("android.bluetooth.BluetoothHeadset");
            } catch (Exception e) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset class not found");
                }
            }
            if (this.a == null) {
                AppMethodBeat.o(65664);
                return false;
            }
            try {
                this.b = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
            } catch (Exception e2) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:".concat(String.valueOf(e2)));
                }
            }
            try {
                this.d = this.a.getDeclaredMethod("getCurrentHeadset", new Class[0]);
            } catch (NoSuchMethodException e3) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
                }
            }
            if (this.d == null) {
                AppMethodBeat.o(65664);
                return false;
            }
            try {
                this.c = this.a.getConstructor(new Class[]{Context.class, this.b}).newInstance(new Object[]{context, null});
            } catch (IllegalArgumentException e4) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                }
            } catch (InstantiationException e5) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                }
            } catch (IllegalAccessException e6) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                }
            } catch (InvocationTargetException e7) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                }
            } catch (NoSuchMethodException e8) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                }
            }
            if (this.c == null) {
                AppMethodBeat.o(65664);
                return false;
            }
            this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, b());
            if (b()) {
                this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                TraeAudioManager.this.checkDevicePlug(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
            } else {
                this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65664);
            return true;
        }

        public void a() {
            AppMethodBeat.i(65665);
            AudioDeviceInterface.LogTraceEntry("");
            if (this.c == null) {
                AppMethodBeat.o(65665);
                return;
            }
            Method declaredMethod;
            try {
                declaredMethod = this.a.getDeclaredMethod("close", new Class[0]);
            } catch (NoSuchMethodException e) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
                }
                declaredMethod = null;
            }
            if (declaredMethod == null) {
                AppMethodBeat.o(65665);
                return;
            }
            try {
                declaredMethod.invoke(this.c, new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            }
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65665);
        }

        public boolean b() {
            AppMethodBeat.i(65666);
            Object obj = null;
            if (this.d == null || this.d == null) {
                AppMethodBeat.o(65666);
                return false;
            }
            try {
                obj = this.d.invoke(this.c, new Object[0]);
            } catch (IllegalArgumentException e) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
                }
            } catch (IllegalAccessException e2) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
                }
            } catch (InvocationTargetException e3) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset res:" + (obj != null ? " Y" : "N"));
            }
            if (obj != null) {
                AppMethodBeat.o(65666);
                return true;
            }
            AppMethodBeat.o(65666);
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        public void a(IntentFilter intentFilter) {
            AppMethodBeat.i(65667);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " " + c() + " _addAction");
            }
            intentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
            AppMethodBeat.o(65667);
        }

        /* Access modifiers changed, original: 0000 */
        public void a(Context context, Intent intent) {
            AppMethodBeat.i(65668);
            int intExtra;
            int intExtra2;
            int intExtra3;
            if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(intent.getAction())) {
                intExtra = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
                intExtra2 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
                intExtra3 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "++ AUDIO_STATE_CHANGED|  STATE ".concat(String.valueOf(intExtra)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       PREVIOUS_STATE ".concat(String.valueOf(intExtra2)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       AUDIO_STATE ".concat(String.valueOf(intExtra3)));
                }
                if (intExtra3 == 2) {
                    this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                    AppMethodBeat.o(65668);
                    return;
                } else if (intExtra3 == 0) {
                    this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                    AppMethodBeat.o(65668);
                    return;
                }
            } else if ("android.bluetooth.headset.action.STATE_CHANGED".equals(intent.getAction())) {
                intExtra = intent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
                intExtra2 = intent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
                intExtra3 = intent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "++ STATE_CHANGED|  STATE ".concat(String.valueOf(intExtra)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       PREVIOUS_STATE ".concat(String.valueOf(intExtra2)));
                }
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "       AUDIO_STATE ".concat(String.valueOf(intExtra3)));
                }
                if (intExtra3 == 2) {
                    this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, true);
                    AppMethodBeat.o(65668);
                    return;
                } else if (intExtra3 == 0) {
                    this.f.a(TraeAudioManager.DEVICE_BLUETOOTHHEADSET, false);
                }
            }
            AppMethodBeat.o(65668);
        }

        public String c() {
            return "BluetoohHeadsetCheckFor2x";
        }
    }

    static {
        AppMethodBeat.i(65758);
        AppMethodBeat.o(65758);
    }

    public static boolean checkDevName(String str) {
        AppMethodBeat.i(65698);
        if (str == null) {
            AppMethodBeat.o(65698);
            return false;
        } else if (DEVICE_SPEAKERPHONE.equals(str) || DEVICE_EARPHONE.equals(str) || DEVICE_WIREDHEADSET.equals(str) || DEVICE_BLUETOOTHHEADSET.equals(str)) {
            AppMethodBeat.o(65698);
            return true;
        } else {
            AppMethodBeat.o(65698);
            return false;
        }
    }

    public static boolean isHandfree(String str) {
        AppMethodBeat.i(65699);
        if (!checkDevName(str)) {
            AppMethodBeat.o(65699);
            return false;
        } else if (DEVICE_SPEAKERPHONE.equals(str)) {
            AppMethodBeat.o(65699);
            return true;
        } else {
            AppMethodBeat.o(65699);
            return false;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void printDevices() {
        int i = 0;
        AppMethodBeat.i(65700);
        AudioDeviceInterface.LogTraceEntry("");
        int e = this._deviceConfigManager.e();
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   ConnectedDevice:" + this._deviceConfigManager.h());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   ConnectingDevice:" + this._deviceConfigManager.g());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   prevConnectedDevice:" + this._deviceConfigManager.i());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   AHPDevice:" + this._deviceConfigManager.f());
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   deviceNamber:".concat(String.valueOf(e)));
        }
        for (int i2 = 0; i2 < e; i2++) {
            String a = this._deviceConfigManager.a(i2);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "      " + i2 + " devName:" + a + " Visible:" + this._deviceConfigManager.c(a) + " Priority:" + this._deviceConfigManager.d(a));
            }
        }
        String[] strArr = (String[]) this._deviceConfigManager.k().toArray(new String[0]);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "   AvailableNamber:" + strArr.length);
        }
        while (i < strArr.length) {
            String str = strArr[i];
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "      " + i + " devName:" + str + " Visible:" + this._deviceConfigManager.c(str) + " Priority:" + this._deviceConfigManager.d(str));
            }
            i++;
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(65700);
    }

    static boolean isCloseSystemAPM(int i) {
        AppMethodBeat.i(65701);
        if (i != -1) {
            AppMethodBeat.o(65701);
            return false;
        }
        if (Build.MANUFACTURER.equals("Xiaomi")) {
            if (Build.MODEL.equals("MI 2")) {
                AppMethodBeat.o(65701);
                return true;
            } else if (Build.MODEL.equals("MI 2A")) {
                AppMethodBeat.o(65701);
                return true;
            } else if (Build.MODEL.equals("MI 2S")) {
                AppMethodBeat.o(65701);
                return true;
            } else if (Build.MODEL.equals("MI 2SC")) {
                AppMethodBeat.o(65701);
                return true;
            }
        } else if (Build.MANUFACTURER.equals("samsung") && Build.MODEL.equals("SCH-I959")) {
            AppMethodBeat.o(65701);
            return true;
        }
        AppMethodBeat.o(65701);
        return false;
    }

    public static boolean IsEabiLowVersionByAbi(String str) {
        AppMethodBeat.i(65702);
        if (str == null) {
            AppMethodBeat.o(65702);
            return true;
        } else if (str.contains("x86")) {
            AppMethodBeat.o(65702);
            return false;
        } else if (str.contains("mips")) {
            AppMethodBeat.o(65702);
            return false;
        } else if (str.equalsIgnoreCase("armeabi")) {
            AppMethodBeat.o(65702);
            return true;
        } else if (str.equalsIgnoreCase("armeabi-v7a")) {
            AppMethodBeat.o(65702);
            return false;
        } else {
            AppMethodBeat.o(65702);
            return true;
        }
    }

    static boolean IsEabiLowVersion() {
        AppMethodBeat.i(65703);
        String str = Build.CPU_ABI;
        String str2 = "unknown";
        if (VERSION.SDK_INT >= 8) {
            try {
                str2 = (String) Build.class.getDeclaredField("CPU_ABI2").get(null);
            } catch (Exception e) {
                if (IsEabiLowVersionByAbi(str)) {
                    AppMethodBeat.o(65703);
                    return true;
                }
                AppMethodBeat.o(65703);
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "IsEabiVersion CPU_ABI:" + str + " CPU_ABI2:" + str2);
        }
        if (IsEabiLowVersionByAbi(str) && IsEabiLowVersionByAbi(str2)) {
            AppMethodBeat.o(65703);
            return true;
        }
        AppMethodBeat.o(65703);
        return false;
    }

    static int getAudioSource(int i) {
        int i2 = 0;
        AppMethodBeat.i(65704);
        if (IsMusicScene) {
            AppMethodBeat.o(65704);
            return 0;
        } else if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + i + " source:0");
            }
            AppMethodBeat.o(65704);
            return 0;
        } else {
            int i3 = VERSION.SDK_INT;
            if (i >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + i + " source:" + i);
                }
                AppMethodBeat.o(65704);
                return i;
            }
            if (i3 >= 11) {
                i2 = 7;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + i + " source:" + i2);
            }
            AppMethodBeat.o(65704);
            return i2;
        }
    }

    static int getAudioStreamType(int i) {
        int i2 = 3;
        AppMethodBeat.i(65705);
        if (IsMusicScene) {
            AppMethodBeat.o(65705);
        } else if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + i + " streamType:3");
            }
            AppMethodBeat.o(65705);
        } else {
            int i3 = VERSION.SDK_INT;
            if (i >= 0) {
                i2 = i;
            } else if (i3 >= 9) {
                i2 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + i + " streamType:" + i2);
            }
            AppMethodBeat.o(65705);
        }
        return i2;
    }

    static int getCallAudioMode(int i) {
        int i2 = 0;
        AppMethodBeat.i(65706);
        if (IsMusicScene) {
            AppMethodBeat.o(65706);
            return 0;
        } else if (IsEabiLowVersion()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + i + " mode:0");
            }
            AppMethodBeat.o(65706);
            return 0;
        } else {
            int i3 = VERSION.SDK_INT;
            if (i >= 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "[Config] getCallAudioMode modePolicy:" + i + " mode:" + i);
                }
                AppMethodBeat.o(65706);
                return i;
            }
            if (i3 >= 11) {
                i2 = 3;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "[Config] getCallAudioMode _modePolicy:" + i + " mode:" + i2 + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
            }
            AppMethodBeat.o(65706);
            return i2;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void updateDeviceStatus() {
        AppMethodBeat.i(65707);
        int e = this._deviceConfigManager.e();
        for (int i = 0; i < e; i++) {
            boolean a;
            String a2 = this._deviceConfigManager.a(i);
            if (a2 != null) {
                if (a2.equals(DEVICE_BLUETOOTHHEADSET)) {
                    if (this._bluetoothCheck == null) {
                        a = this._deviceConfigManager.a(a2, false);
                    } else {
                        a = this._deviceConfigManager.a(a2, this._bluetoothCheck.b());
                    }
                } else if (a2.equals(DEVICE_WIREDHEADSET)) {
                    a = this._deviceConfigManager.a(a2, this._am.isWiredHeadsetOn());
                } else if (a2.equals(DEVICE_SPEAKERPHONE)) {
                    this._deviceConfigManager.a(a2, true);
                }
                if (a && QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "pollUpdateDevice dev:" + a2 + " Visible:" + this._deviceConfigManager.c(a2));
                }
            }
            a = false;
            QLog.w("TRAE", 2, "pollUpdateDevice dev:" + a2 + " Visible:" + this._deviceConfigManager.c(a2));
        }
        checkAutoDeviceListUpdate();
        AppMethodBeat.o(65707);
    }

    /* Access modifiers changed, original: 0000 */
    public void _updateEarphoneVisable() {
        AppMethodBeat.i(65708);
        if (this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " detected headset plugin,so disable earphone");
            }
            this._deviceConfigManager.a(DEVICE_EARPHONE, false);
            AppMethodBeat.o(65708);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " detected headset plugout,so enable earphone");
        }
        this._deviceConfigManager.a(DEVICE_EARPHONE, true);
        AppMethodBeat.o(65708);
    }

    /* Access modifiers changed, original: 0000 */
    public void checkAutoDeviceListUpdate() {
        AppMethodBeat.i(65709);
        if (this._deviceConfigManager.b()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "checkAutoDeviceListUpdate got update!");
            }
            _updateEarphoneVisable();
            this._deviceConfigManager.c();
            internalSendMessage(32785, new HashMap());
        }
        AppMethodBeat.o(65709);
    }

    /* Access modifiers changed, original: 0000 */
    public void checkDevicePlug(String str, boolean z) {
        AppMethodBeat.i(65710);
        if (this._deviceConfigManager.b()) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "checkDevicePlug got update dev:" + str + (z ? " piugin" : " plugout") + " connectedDev:" + this._deviceConfigManager.h());
            }
            _updateEarphoneVisable();
            this._deviceConfigManager.c();
            HashMap hashMap;
            if (z) {
                hashMap = new HashMap();
                hashMap.put(PARAM_DEVICE, str);
                internalSendMessage(32786, hashMap);
                AppMethodBeat.o(65710);
                return;
            }
            String h = this._deviceConfigManager.h();
            if (h.equals(str) || h.equals(DEVICE_NONE)) {
                hashMap = new HashMap();
                hashMap.put(PARAM_DEVICE, str);
                internalSendMessage(32787, hashMap);
                AppMethodBeat.o(65710);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, " ---No switch,plugout:" + str + " connectedDev:" + h);
            }
            internalSendMessage(32785, new HashMap());
        }
        AppMethodBeat.o(65710);
    }

    public static int SetSpeakerForTest(Context context, boolean z) {
        AppMethodBeat.i(65711);
        int i = -1;
        _glock.lock();
        if (_ginstance != null) {
            i = _ginstance.InternalSetSpeaker(context, z);
        } else if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "TraeAudioManager|static SetSpeakerForTest|null == _ginstance");
        }
        _glock.unlock();
        AppMethodBeat.o(65711);
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalSetSpeaker(Context context, boolean z) {
        AppMethodBeat.i(65712);
        if (context == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no context");
            }
            AppMethodBeat.o(65712);
            return -1;
        }
        AudioManager audioManager = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (audioManager == null) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no audio manager");
            }
            AppMethodBeat.o(65712);
            return -1;
        }
        if (QLog.isColorLevel()) {
            String str;
            String str2 = "TRAE";
            StringBuilder append = new StringBuilder("InternalSetSpeaker entry:speaker:").append(audioManager.isSpeakerphoneOn() ? "Y" : "N").append("-->:");
            if (z) {
                str = "Y";
            } else {
                str = "N";
            }
            QLog.w(str2, 2, append.append(str).toString());
        }
        if (!isCloseSystemAPM(this._modePolicy) || this._activeMode == 2) {
            if (audioManager.isSpeakerphoneOn() != z) {
                audioManager.setSpeakerphoneOn(z);
            }
            int i = audioManager.isSpeakerphoneOn() == z ? 0 : -1;
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InternalSetSpeaker exit:" + z + " res:" + i + " mode:" + audioManager.getMode());
            }
            AppMethodBeat.o(65712);
            return i;
        }
        int InternalSetSpeakerSpe = InternalSetSpeakerSpe(audioManager, z);
        AppMethodBeat.o(65712);
        return InternalSetSpeakerSpe;
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalSetSpeakerSpe(AudioManager audioManager, boolean z) {
        int i = 0;
        AppMethodBeat.i(65713);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
        }
        if (z) {
            InternalSetMode(0);
            audioManager.setSpeakerphoneOn(true);
            setForceUse(1, 1);
        } else {
            InternalSetMode(3);
            audioManager.setSpeakerphoneOn(false);
            setForceUse(1, 0);
        }
        if (audioManager.isSpeakerphoneOn() != z) {
            i = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeakerSpe exit:" + z + " res:" + i + " mode:" + audioManager.getMode());
        }
        AppMethodBeat.o(65713);
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    public void InternalSetMode(int i) {
        AppMethodBeat.i(65714);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "SetMode entry:".concat(String.valueOf(i)));
        }
        if (this._am == null) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "setMode:" + i + " fail am=null");
            }
            AppMethodBeat.o(65714);
            return;
        }
        this._am.setMode(i);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setMode:" + i + (this._am.getMode() != i ? "fail" : "success"));
        }
        AppMethodBeat.o(65714);
    }

    public static int registerAudioSession(boolean z, long j, Context context) {
        AppMethodBeat.i(65715);
        int i = -1;
        _glock.lock();
        if (_ginstance != null) {
            if (z) {
                _ginstance._audioSessionHost.add(j, context);
            } else {
                _ginstance._audioSessionHost.remove(j);
            }
            i = 0;
        }
        _glock.unlock();
        AppMethodBeat.o(65715);
        return i;
    }

    public static int sendMessage(int i, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(65716);
        int i2 = -1;
        _glock.lock();
        if (_ginstance != null) {
            i2 = _ginstance.internalSendMessage(i, hashMap);
        }
        _glock.unlock();
        AppMethodBeat.o(65716);
        return i2;
    }

    public static int init(Context context) {
        AppMethodBeat.i(65717);
        TXCLog.w("TRAE", "TraeAudioManager init _ginstance:" + _ginstance);
        AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
        _glock.lock();
        if (_ginstance == null) {
            _ginstance = new TraeAudioManager(context);
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(65717);
        return 0;
    }

    public static void uninit() {
        AppMethodBeat.i(65718);
        TXCLog.w("TRAE", "TraeAudioManager uninit _ginstance:" + _ginstance);
        AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
        _glock.lock();
        if (_ginstance != null) {
            _ginstance.release();
            _ginstance = null;
        }
        _glock.unlock();
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(65718);
    }

    TraeAudioManager(Context context) {
        AppMethodBeat.i(65719);
        AudioDeviceInterface.LogTraceEntry(" context:".concat(String.valueOf(context)));
        if (context == null) {
            AppMethodBeat.o(65719);
            return;
        }
        this._context = context;
        this.mTraeAudioManagerLooper = new f(this);
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(65719);
    }

    public void release() {
        AppMethodBeat.i(65720);
        AudioDeviceInterface.LogTraceEntry("");
        if (this.mTraeAudioManagerLooper != null) {
            this.mTraeAudioManagerLooper.a();
            this.mTraeAudioManagerLooper = null;
        }
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(65720);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(65721);
        if (intent == null || context == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TRAE", 2, "onReceive intent or context is null!");
            }
            AppMethodBeat.o(65721);
            return;
        }
        try {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra(PARAM_OPERATION);
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "TraeAudioManager|onReceive::Action:" + intent.getAction());
            }
            if (this._deviceConfigManager == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TRAE", 2, "_deviceConfigManager null!");
                }
                AppMethodBeat.o(65721);
                return;
            }
            boolean c = this._deviceConfigManager.c(DEVICE_WIREDHEADSET);
            boolean c2 = this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET);
            if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction())) {
                onHeadsetPlug(context, intent);
                if (!c && this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
                    checkDevicePlug(DEVICE_WIREDHEADSET, true);
                }
                if (c && !this._deviceConfigManager.c(DEVICE_WIREDHEADSET)) {
                    checkDevicePlug(DEVICE_WIREDHEADSET, false);
                    AppMethodBeat.o(65721);
                    return;
                }
            } else if (!"android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                if (ACTION_TRAEAUDIOMANAGER_REQUEST.equals(action)) {
                    if (QLog.isColorLevel()) {
                        QLog.w("TRAE", 2, "   OPERATION:".concat(String.valueOf(stringExtra)));
                    }
                    if (OPERATION_REGISTERAUDIOSESSION.equals(stringExtra)) {
                        registerAudioSession(intent.getBooleanExtra(REGISTERAUDIOSESSION_ISREGISTER, false), intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), context);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_STARTSERVICE.equals(stringExtra)) {
                        startService(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getStringExtra(EXTRA_DATA_DEVICECONFIG));
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_STOPSERVICE.equals(stringExtra)) {
                        stopService(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_GETDEVICELIST.equals(stringExtra)) {
                        getDeviceList(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_GETSTREAMTYPE.equals(stringExtra)) {
                        getStreamType(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_CONNECTDEVICE.equals(stringExtra)) {
                        connectDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getStringExtra(CONNECTDEVICE_DEVICENAME));
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE.equals(stringExtra)) {
                        connectHighestPriorityDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_EARACTION.equals(stringExtra)) {
                        earAction(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(EXTRA_EARACTION, -1));
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_ISDEVICECHANGABLED.equals(stringExtra)) {
                        isDeviceChangabled(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_GETCONNECTEDDEVICE.equals(stringExtra)) {
                        getConnectedDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_GETCONNECTINGDEVICE.equals(stringExtra)) {
                        getConnectingDevice(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                        voicecallPreprocess(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(PARAM_MODEPOLICY, -1), intent.getIntExtra(PARAM_STREAMTYPE, -1));
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_VOICECALL_POSTPROCESS.equals(stringExtra)) {
                        voicecallPostprocess(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_VOICECALL_AUDIOPARAM_CHANGED.equals(stringExtra)) {
                        voiceCallAudioParamChanged(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intent.getIntExtra(PARAM_MODEPOLICY, -1), intent.getIntExtra(PARAM_STREAMTYPE, -1));
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_STARTRING.equals(stringExtra)) {
                        int intExtra = intent.getIntExtra(PARAM_RING_DATASOURCE, -1);
                        int intExtra2 = intent.getIntExtra(PARAM_RING_RSID, -1);
                        Uri uri = (Uri) intent.getParcelableExtra(PARAM_RING_URI);
                        String stringExtra2 = intent.getStringExtra(PARAM_RING_FILEPATH);
                        boolean booleanExtra = intent.getBooleanExtra(PARAM_RING_LOOP, false);
                        String stringExtra3 = intent.getStringExtra(PARAM_RING_USERDATA_STRING);
                        startRing(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false, intExtra, intExtra2, uri, stringExtra2, booleanExtra, intent.getIntExtra(PARAM_RING_LOOPCOUNT, 1), stringExtra3, intent.getBooleanExtra(PARAM_RING_MODE, false));
                        AppMethodBeat.o(65721);
                        return;
                    } else if (OPERATION_STOPRING.equals(stringExtra)) {
                        stopRing(stringExtra, intent.getLongExtra(PARAM_SESSIONID, Long.MIN_VALUE), false);
                        AppMethodBeat.o(65721);
                        return;
                    }
                } else if (this._deviceConfigManager != null) {
                    if (this._bluetoothCheck != null) {
                        this._bluetoothCheck.a(context, intent, this._deviceConfigManager);
                    }
                    if (!c2 && this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET)) {
                        checkDevicePlug(DEVICE_BLUETOOTHHEADSET, true);
                    }
                    if (c2 && !this._deviceConfigManager.c(DEVICE_BLUETOOTHHEADSET)) {
                        checkDevicePlug(DEVICE_BLUETOOTHHEADSET, false);
                    }
                }
            }
            AppMethodBeat.o(65721);
        } catch (Exception e) {
            AppMethodBeat.o(65721);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void onHeadsetPlug(Context context, Intent intent) {
        AppMethodBeat.i(65722);
        String str = "";
        String stringExtra = intent.getStringExtra("name");
        if (stringExtra == null) {
            stringExtra = "unkonw";
        }
        stringExtra = str + " [" + stringExtra + "] ";
        int intExtra = intent.getIntExtra("state", -1);
        if (intExtra != -1) {
            stringExtra = stringExtra + (intExtra == 0 ? "unplugged" : "plugged");
        }
        Object obj = stringExtra + " mic:";
        int intExtra2 = intent.getIntExtra("microphone", -1);
        if (intExtra2 != -1) {
            obj = obj + (intExtra2 == 1 ? "Y" : "unkown");
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "onHeadsetPlug:: ".concat(String.valueOf(obj)));
        }
        this._deviceConfigManager.a(DEVICE_WIREDHEADSET, 1 == intExtra);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "onHeadsetPlug exit");
        }
        AppMethodBeat.o(65722);
    }

    /* Access modifiers changed, original: 0000 */
    public int internalSendMessage(int i, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(65723);
        int i2 = -1;
        if (this.mTraeAudioManagerLooper != null) {
            i2 = this.mTraeAudioManagerLooper.a(i, hashMap);
        }
        AppMethodBeat.o(65723);
        return i2;
    }

    static int getDeviceList(String str, long j, boolean z) {
        AppMethodBeat.i(65724);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32774, hashMap);
        AppMethodBeat.o(65724);
        return sendMessage;
    }

    static int getStreamType(String str, long j, boolean z) {
        AppMethodBeat.i(65725);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32784, hashMap);
        AppMethodBeat.o(65725);
        return sendMessage;
    }

    static int startService(String str, long j, boolean z, String str2) {
        AppMethodBeat.i(65726);
        if (str2.length() <= 0) {
            AppMethodBeat.o(65726);
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(EXTRA_DATA_DEVICECONFIG, str2);
        int sendMessage = sendMessage(32772, hashMap);
        AppMethodBeat.o(65726);
        return sendMessage;
    }

    static int stopService(String str, long j, boolean z) {
        AppMethodBeat.i(65727);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32773, hashMap);
        AppMethodBeat.o(65727);
        return sendMessage;
    }

    static int connectDevice(String str, long j, boolean z, String str2) {
        AppMethodBeat.i(65728);
        if (str2 == null) {
            AppMethodBeat.o(65728);
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(CONNECTDEVICE_DEVICENAME, str2);
        hashMap.put(PARAM_DEVICE, str2);
        int sendMessage = sendMessage(32775, hashMap);
        AppMethodBeat.o(65728);
        return sendMessage;
    }

    static int connectHighestPriorityDevice(String str, long j, boolean z) {
        AppMethodBeat.i(65729);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32789, hashMap);
        AppMethodBeat.o(65729);
        return sendMessage;
    }

    static int earAction(String str, long j, boolean z, int i) {
        AppMethodBeat.i(65730);
        if (i == 0 || i == 1) {
            HashMap hashMap = new HashMap();
            hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
            hashMap.put(PARAM_OPERATION, str);
            hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
            hashMap.put(EXTRA_EARACTION, Integer.valueOf(i));
            int sendMessage = sendMessage(32776, hashMap);
            AppMethodBeat.o(65730);
            return sendMessage;
        }
        AppMethodBeat.o(65730);
        return -1;
    }

    static int isDeviceChangabled(String str, long j, boolean z) {
        AppMethodBeat.i(65731);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32777, hashMap);
        AppMethodBeat.o(65731);
        return sendMessage;
    }

    static int getConnectedDevice(String str, long j, boolean z) {
        AppMethodBeat.i(65732);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32778, hashMap);
        AppMethodBeat.o(65732);
        return sendMessage;
    }

    static int getConnectingDevice(String str, long j, boolean z) {
        AppMethodBeat.i(65733);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32779, hashMap);
        AppMethodBeat.o(65733);
        return sendMessage;
    }

    static int voicecallPreprocess(String str, long j, boolean z, int i, int i2) {
        AppMethodBeat.i(65734);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_MODEPOLICY, Integer.valueOf(i));
        hashMap.put(PARAM_STREAMTYPE, Integer.valueOf(i2));
        int sendMessage = sendMessage(32780, hashMap);
        AppMethodBeat.o(65734);
        return sendMessage;
    }

    static int voicecallPostprocess(String str, long j, boolean z) {
        AppMethodBeat.i(65735);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32781, hashMap);
        AppMethodBeat.o(65735);
        return sendMessage;
    }

    static int voiceCallAudioParamChanged(String str, long j, boolean z, int i, int i2) {
        AppMethodBeat.i(65736);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_MODEPOLICY, Integer.valueOf(i));
        hashMap.put(PARAM_STREAMTYPE, Integer.valueOf(i2));
        int sendMessage = sendMessage(32788, hashMap);
        AppMethodBeat.o(65736);
        return sendMessage;
    }

    static int startRing(String str, long j, boolean z, int i, int i2, Uri uri, String str2, boolean z2, int i3, String str3, boolean z3) {
        AppMethodBeat.i(65737);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        hashMap.put(PARAM_RING_DATASOURCE, Integer.valueOf(i));
        hashMap.put(PARAM_RING_RSID, Integer.valueOf(i2));
        hashMap.put(PARAM_RING_URI, uri);
        hashMap.put(PARAM_RING_FILEPATH, str2);
        hashMap.put(PARAM_RING_LOOP, Boolean.valueOf(z2));
        hashMap.put(PARAM_RING_LOOPCOUNT, Integer.valueOf(i3));
        hashMap.put(PARAM_RING_MODE, Boolean.valueOf(z3));
        hashMap.put(PARAM_RING_USERDATA_STRING, str3);
        int sendMessage = sendMessage(32782, hashMap);
        AppMethodBeat.o(65737);
        return sendMessage;
    }

    static int stopRing(String str, long j, boolean z) {
        AppMethodBeat.i(65738);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32783, hashMap);
        AppMethodBeat.o(65738);
        return sendMessage;
    }

    static int requestReleaseAudioFocus(String str, long j, boolean z) {
        AppMethodBeat.i(65739);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32790, hashMap);
        AppMethodBeat.o(65739);
        return sendMessage;
    }

    static int recoverAudioFocus(String str, long j, boolean z) {
        AppMethodBeat.i(65740);
        HashMap hashMap = new HashMap();
        hashMap.put(PARAM_SESSIONID, Long.valueOf(j));
        hashMap.put(PARAM_OPERATION, str);
        hashMap.put(PARAM_ISHOSTSIDE, Boolean.valueOf(z));
        int sendMessage = sendMessage(32791, hashMap);
        AppMethodBeat.o(65740);
        return sendMessage;
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalSessionConnectDevice(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(65741);
        AudioDeviceInterface.LogTraceEntry("");
        if (hashMap == null || this._context == null) {
            AppMethodBeat.o(65741);
            return -1;
        } else if (IsMusicScene) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "MusicScene: InternalSessionConnectDevice failed");
            }
            AppMethodBeat.o(65741);
            return -1;
        } else {
            int i;
            String str = (String) hashMap.get(PARAM_DEVICE);
            TXCLog.w("TRAE", "ConnectDevice: ".concat(String.valueOf(str)));
            boolean InternalIsDeviceChangeable = InternalIsDeviceChangeable();
            if (!checkDevName(str)) {
                i = 7;
            } else if (!this._deviceConfigManager.c(str)) {
                i = 8;
            } else if (InternalIsDeviceChangeable) {
                i = 0;
            } else {
                i = 9;
            }
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "sessonID:" + ((Long) hashMap.get(PARAM_SESSIONID)) + " devName:" + str + " bChangabled:" + (InternalIsDeviceChangeable ? "Y" : "N") + " err:" + i);
            }
            Intent intent;
            if (i != 0) {
                intent = new Intent();
                intent.putExtra(CONNECTDEVICE_RESULT_DEVICENAME, (String) hashMap.get(PARAM_DEVICE));
                sendResBroadcast(intent, hashMap, i);
                AppMethodBeat.o(65741);
                return -1;
            } else if (str.equals(this._deviceConfigManager.h())) {
                if (QLog.isColorLevel()) {
                    QLog.e("TRAE", 2, " --has connected!");
                }
                intent = new Intent();
                intent.putExtra(CONNECTDEVICE_RESULT_DEVICENAME, (String) hashMap.get(PARAM_DEVICE));
                sendResBroadcast(intent, hashMap, i);
                AppMethodBeat.o(65741);
                return 0;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, " --connecting...");
                }
                InternalConnectDevice(str, hashMap, false);
                AudioDeviceInterface.LogTraceExit();
                AppMethodBeat.o(65741);
                return 0;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalSessionEarAction(HashMap<String, Object> hashMap) {
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalConnectDevice(String str, HashMap<String, Object> hashMap, boolean z) {
        AppMethodBeat.i(65742);
        AudioDeviceInterface.LogTraceEntry(" devName:".concat(String.valueOf(str)));
        if (str == null) {
            AppMethodBeat.o(65742);
            return -1;
        } else if (IsMusicScene && str.equals(DEVICE_EARPHONE)) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "MusicScene, Connect device:" + str + " failed");
            }
            AppMethodBeat.o(65742);
            return -1;
        } else if (!z && !this._deviceConfigManager.h().equals(DEVICE_NONE) && str.equals(this._deviceConfigManager.h())) {
            AppMethodBeat.o(65742);
            return 0;
        } else if (!checkDevName(str) || !this._deviceConfigManager.c(str)) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " checkDevName fail");
            }
            AppMethodBeat.o(65742);
            return -1;
        } else if (!InternalIsDeviceChangeable()) {
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, " InternalIsDeviceChangeable fail");
            }
            AppMethodBeat.o(65742);
            return -1;
        } else {
            if (this._switchThread != null) {
                if (QLog.isColorLevel()) {
                    QLog.w("TRAE", 2, "_switchThread:" + this._switchThread.b());
                }
                this._switchThread.f();
                this._switchThread = null;
            }
            if (str.equals(DEVICE_EARPHONE)) {
                this._switchThread = new h();
            } else if (str.equals(DEVICE_SPEAKERPHONE)) {
                this._switchThread = new j();
            } else if (str.equals(DEVICE_WIREDHEADSET)) {
                this._switchThread = new i();
            } else if (str.equals(DEVICE_BLUETOOTHHEADSET)) {
                this._switchThread = new g();
            }
            if (this._switchThread != null) {
                this._switchThread.a((HashMap) hashMap);
                this._switchThread.start();
            }
            AudioDeviceInterface.LogTraceExit();
            AppMethodBeat.o(65742);
            return 0;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalSessionIsDeviceChangabled(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(65743);
        Intent intent = new Intent();
        intent.putExtra(ISDEVICECHANGABLED_RESULT_ISCHANGABLED, InternalIsDeviceChangeable());
        sendResBroadcast(intent, hashMap, 0);
        AppMethodBeat.o(65743);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean InternalIsDeviceChangeable() {
        AppMethodBeat.i(65744);
        String g = this._deviceConfigManager.g();
        if (g == null || g.equals(DEVICE_NONE) || g.equals("")) {
            AppMethodBeat.o(65744);
            return true;
        }
        AppMethodBeat.o(65744);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalSessionGetConnectedDevice(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(65745);
        Intent intent = new Intent();
        intent.putExtra(GETCONNECTEDDEVICE_RESULT_LIST, this._deviceConfigManager.h());
        sendResBroadcast(intent, hashMap, 0);
        AppMethodBeat.o(65745);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalSessionGetConnectingDevice(HashMap<String, Object> hashMap) {
        AppMethodBeat.i(65746);
        Intent intent = new Intent();
        intent.putExtra(GETCONNECTINGDEVICE_RESULT_LIST, this._deviceConfigManager.g());
        sendResBroadcast(intent, hashMap, 0);
        AppMethodBeat.o(65746);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int sendResBroadcast(Intent intent, HashMap<String, Object> hashMap, int i) {
        AppMethodBeat.i(65747);
        if (this._context == null) {
            AppMethodBeat.o(65747);
            return -1;
        }
        Long l = (Long) hashMap.get(PARAM_SESSIONID);
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, " sessonID:" + l + " " + ((String) hashMap.get(PARAM_OPERATION)));
        }
        if (l == null || l.longValue() == Long.MIN_VALUE) {
            InternalNotifyDeviceListUpdate();
            if (QLog.isColorLevel()) {
                QLog.e("TRAE", 2, "sendResBroadcast sid null,don't send res");
            }
            AppMethodBeat.o(65747);
            return -1;
        }
        final Long l2 = (Long) hashMap.get(PARAM_SESSIONID);
        final String str = (String) hashMap.get(PARAM_OPERATION);
        final Intent intent2 = intent;
        final int i2 = i;
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(65697);
                intent2.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES);
                intent2.putExtra(TraeAudioManager.PARAM_SESSIONID, l2);
                intent2.putExtra(TraeAudioManager.PARAM_OPERATION, str);
                intent2.putExtra(TraeAudioManager.PARAM_RES_ERRCODE, i2);
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.sendBroadcast(intent2);
                }
                AppMethodBeat.o(65697);
            }
        });
        AppMethodBeat.o(65747);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalNotifyDeviceListUpdate() {
        AppMethodBeat.i(65748);
        AudioDeviceInterface.LogTraceEntry("");
        if (this._context == null) {
            AppMethodBeat.o(65748);
            return -1;
        }
        HashMap j = this._deviceConfigManager.j();
        final ArrayList arrayList = (ArrayList) j.get(EXTRA_DATA_AVAILABLEDEVICE_LIST);
        final String str = (String) j.get(EXTRA_DATA_CONNECTEDDEVICE);
        final String str2 = (String) j.get(EXTRA_DATA_PREV_CONNECTEDDEVICE);
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(65663);
                Intent intent = new Intent();
                intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_DEVICELIST_UPDATE);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, (String[]) arrayList.toArray(new String[0]));
                intent.putExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, str);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, str2);
                intent.putExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME, TraeAudioManager.this._deviceConfigManager.d());
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.sendBroadcast(intent);
                }
                AppMethodBeat.o(65663);
            }
        });
        AudioDeviceInterface.LogTraceExit();
        AppMethodBeat.o(65748);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public int InternalNotifyDeviceChangableUpdate() {
        AppMethodBeat.i(65749);
        if (this._context == null) {
            AppMethodBeat.o(65749);
            return -1;
        }
        final boolean InternalIsDeviceChangeable = InternalIsDeviceChangeable();
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(65673);
                Intent intent = new Intent();
                intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
                intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE);
                intent.putExtra(TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE_DATE, InternalIsDeviceChangeable);
                if (TraeAudioManager.this._context != null) {
                    TraeAudioManager.this._context.sendBroadcast(intent);
                }
                AppMethodBeat.o(65673);
            }
        });
        AppMethodBeat.o(65749);
        return 0;
    }

    public d CreateBluetoothCheck(Context context, e eVar) {
        d aVar;
        AppMethodBeat.i(65750);
        if (VERSION.SDK_INT >= 11) {
            aVar = new a();
        } else if (VERSION.SDK_INT != 18) {
            aVar = new c();
        } else {
            aVar = new b();
        }
        if (!aVar.a(context, eVar)) {
            aVar = new b();
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "CreateBluetoothCheck:" + aVar.c() + " skip android4.3:" + (VERSION.SDK_INT == 18 ? "Y" : "N"));
        }
        AppMethodBeat.o(65750);
        return aVar;
    }

    static String getForceConfigName(int i) {
        if (i < 0 || i >= forceName.length) {
            return "unknow";
        }
        return forceName[i];
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class[] clsArr) {
        AppMethodBeat.i(65751);
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
        } catch (Exception e) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "invokeMethod Exception:" + e.getMessage());
            }
        }
        AppMethodBeat.o(65751);
        return obj2;
    }

    public static Object invokeStaticMethod(String str, String str2, Object[] objArr, Class[] clsArr) {
        Object obj = null;
        AppMethodBeat.i(65752);
        try {
            obj = Class.forName(str).getMethod(str2, clsArr).invoke(null, objArr);
        } catch (ClassNotFoundException e) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "ClassNotFound:".concat(String.valueOf(str)));
            }
        } catch (NoSuchMethodException e2) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "NoSuchMethod:".concat(String.valueOf(str2)));
            }
        } catch (IllegalArgumentException e3) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "IllegalArgument:".concat(String.valueOf(str2)));
            }
        } catch (IllegalAccessException e4) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "IllegalAccess:".concat(String.valueOf(str2)));
            }
        } catch (InvocationTargetException e5) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "InvocationTarget:".concat(String.valueOf(str2)));
            }
        } catch (Exception e6) {
            if (QLog.isColorLevel()) {
                QLog.w("TRAE", 2, "invokeStaticMethod Exception:" + e6.getMessage());
            }
        }
        AppMethodBeat.o(65752);
        return obj;
    }

    static void setParameters(String str) {
        AppMethodBeat.i(65753);
        Object[] objArr = new Object[]{str};
        Class[] clsArr = new Class[]{String.class};
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setParameters  :".concat(String.valueOf(str)));
        }
        invokeStaticMethod("android.media.AudioSystem", "setParameters", objArr, clsArr);
        AppMethodBeat.o(65753);
    }

    static void setPhoneState(int i) {
        AppMethodBeat.i(65754);
        invokeStaticMethod("android.media.AudioSystem", "setPhoneState", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
        AppMethodBeat.o(65754);
    }

    static void setForceUse(int i, int i2) {
        AppMethodBeat.i(65755);
        Object invokeStaticMethod = invokeStaticMethod("android.media.AudioSystem", "setForceUse", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, new Class[]{Integer.TYPE, Integer.TYPE});
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "setForceUse  usage:" + i + " config:" + i2 + " ->" + getForceConfigName(i2) + " res:" + invokeStaticMethod);
        }
        AppMethodBeat.o(65755);
    }

    static int getForceUse(int i) {
        AppMethodBeat.i(65756);
        Integer valueOf = Integer.valueOf(0);
        Object invokeStaticMethod = invokeStaticMethod("android.media.AudioSystem", "getForceUse", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
        if (invokeStaticMethod != null) {
            invokeStaticMethod = (Integer) invokeStaticMethod;
        } else {
            Integer num = valueOf;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "getForceUse  usage:" + i + " config:" + invokeStaticMethod + " ->" + getForceConfigName(invokeStaticMethod.intValue()));
        }
        int intValue = invokeStaticMethod.intValue();
        AppMethodBeat.o(65756);
        return intValue;
    }

    static void forceVolumeControlStream(AudioManager audioManager, int i) {
        AppMethodBeat.i(65757);
        Object invokeMethod = invokeMethod(audioManager, "forceVolumeControlStream", new Object[]{Integer.valueOf(i)}, new Class[]{Integer.TYPE});
        if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "forceVolumeControlStream  streamType:" + i + " res:" + invokeMethod);
        }
        AppMethodBeat.o(65757);
    }
}
