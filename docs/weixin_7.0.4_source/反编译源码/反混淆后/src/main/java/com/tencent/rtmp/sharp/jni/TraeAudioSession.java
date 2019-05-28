package com.tencent.rtmp.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.ttpic.baseutils.IOUtils;

public class TraeAudioSession extends BroadcastReceiver {
    static int s_nSessionIdAllocator = 0;
    final String TRAE_ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
    private boolean _canSwtich2Earphone = true;
    private String _connectedDev = TraeAudioManager.DEVICE_NONE;
    private C24255a mCallback;
    private Context mContext;
    private boolean mIsHostside = false;
    private long mSessionId = Long.MIN_VALUE;

    /* renamed from: com.tencent.rtmp.sharp.jni.TraeAudioSession$a */
    public interface C24255a {
        /* renamed from: a */
        void mo28688a(int i);

        /* renamed from: a */
        void mo28689a(int i, int i2);

        /* renamed from: a */
        void mo28690a(int i, String str);

        /* renamed from: a */
        void mo28691a(int i, String str, boolean z);

        /* renamed from: a */
        void mo28692a(int i, boolean z);

        /* renamed from: a */
        void mo28693a(int i, String[] strArr, String str, String str2, String str3);

        /* renamed from: a */
        void mo28694a(String str, long j);

        /* renamed from: a */
        void mo28695a(String str, String str2);

        /* renamed from: a */
        void mo28696a(boolean z);

        /* renamed from: a */
        void mo28697a(String[] strArr, String str, String str2, String str3);

        /* renamed from: b */
        void mo28698b(int i);

        /* renamed from: b */
        void mo28699b(int i, String str);

        /* renamed from: b */
        void mo28700b(boolean z);

        /* renamed from: c */
        void mo28701c(int i, String str);
    }

    public static long requestSessionId() {
        AppMethodBeat.m2504i(65799);
        long myPid = ((long) Process.myPid()) << 32;
        int i = s_nSessionIdAllocator + 1;
        s_nSessionIdAllocator = i;
        myPid += (long) i;
        AppMethodBeat.m2505o(65799);
        return myPid;
    }

    public static void ExConnectDevice(Context context, String str) {
        AppMethodBeat.m2504i(65800);
        if (context == null || str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(65800);
            return;
        }
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
        intent.putExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECTDEVICE);
        intent.putExtra(TraeAudioManager.CONNECTDEVICE_DEVICENAME, str);
        context.sendBroadcast(intent);
        AppMethodBeat.m2505o(65800);
    }

    public TraeAudioSession(Context context, C24255a c24255a) {
        boolean z = false;
        AppMethodBeat.m2504i(65801);
        TXCLog.m15679w("TRAE", "TraeAudioSession create");
        if (Process.myPid() == TraeAudioManager._gHostProcessId) {
            z = true;
        }
        this.mIsHostside = z;
        this.mSessionId = requestSessionId();
        this.mCallback = c24255a;
        this.mContext = context;
        if (context == null && QLog.isColorLevel()) {
            QLog.m8770w("TRAE", 2, "AudioSession | Invalid parameters: ctx = " + (context == null ? BuildConfig.COMMAND : "{object}") + "; cb = " + (c24255a == null ? BuildConfig.COMMAND : "{object}"));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES);
        intentFilter.addAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
        if (context != null) {
            try {
                context.registerReceiver(this, intentFilter);
            } catch (Exception e) {
            }
        }
        registerAudioSession(true);
        AppMethodBeat.m2505o(65801);
    }

    public void release() {
        AppMethodBeat.m2504i(65802);
        if (this.mContext != null) {
            try {
                this.mContext.unregisterReceiver(this);
            } catch (Exception e) {
            }
        }
        registerAudioSession(false);
        this.mContext = null;
        this.mCallback = null;
        AppMethodBeat.m2505o(65802);
    }

    public void setCallback(C24255a c24255a) {
        this.mCallback = c24255a;
    }

    private int registerAudioSession(boolean z) {
        AppMethodBeat.m2504i(65803);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(65803);
            return -1;
        } else if (this.mIsHostside) {
            int registerAudioSession = TraeAudioManager.registerAudioSession(z, this.mSessionId, this.mContext);
            AppMethodBeat.m2505o(65803);
            return registerAudioSession;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_REGISTERAUDIOSESSION);
            intent.putExtra(TraeAudioManager.REGISTERAUDIOSESSION_ISREGISTER, z);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65803);
            return 0;
        }
    }

    public int startService(String str) {
        AppMethodBeat.m2504i(65804);
        if (str == null || str.length() <= 0) {
            str = "internal_disable_dev_switch";
        }
        if (this.mIsHostside) {
            int startService = TraeAudioManager.startService(TraeAudioManager.OPERATION_STARTSERVICE, this.mSessionId, this.mIsHostside, str);
            AppMethodBeat.m2505o(65804);
            return startService;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65804);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTSERVICE);
            intent.putExtra(TraeAudioManager.EXTRA_DATA_DEVICECONFIG, str);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65804);
            return 0;
        }
    }

    public int stopService() {
        AppMethodBeat.m2504i(65805);
        if (this.mIsHostside) {
            int stopService = TraeAudioManager.stopService(TraeAudioManager.OPERATION_STOPSERVICE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65805);
            return stopService;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65805);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STOPSERVICE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65805);
            return 0;
        }
    }

    public int getDeviceList() {
        AppMethodBeat.m2504i(65806);
        if (this.mIsHostside) {
            int deviceList = TraeAudioManager.getDeviceList(TraeAudioManager.OPERATION_GETDEVICELIST, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65806);
            return deviceList;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65806);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETDEVICELIST);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65806);
            return 0;
        }
    }

    public int getStreamType() {
        AppMethodBeat.m2504i(65807);
        if (this.mIsHostside) {
            int streamType = TraeAudioManager.getStreamType(TraeAudioManager.OPERATION_GETSTREAMTYPE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65807);
            return streamType;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65807);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETSTREAMTYPE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65807);
            return 0;
        }
    }

    public int connectDevice(String str) {
        AppMethodBeat.m2504i(65808);
        if (this.mIsHostside) {
            int connectDevice = TraeAudioManager.connectDevice(TraeAudioManager.OPERATION_CONNECTDEVICE, this.mSessionId, this.mIsHostside, str);
            AppMethodBeat.m2505o(65808);
            return connectDevice;
        } else if (this.mContext == null || str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(65808);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECTDEVICE);
            intent.putExtra(TraeAudioManager.CONNECTDEVICE_DEVICENAME, str);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65808);
            return 0;
        }
    }

    public int connectHighestPriorityDevice() {
        AppMethodBeat.m2504i(65809);
        if (this.mIsHostside) {
            int connectHighestPriorityDevice = TraeAudioManager.connectHighestPriorityDevice(TraeAudioManager.OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65809);
            return connectHighestPriorityDevice;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65809);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65809);
            return 0;
        }
    }

    public int EarAction(int i) {
        AppMethodBeat.m2504i(65810);
        if (this.mIsHostside) {
            int earAction = TraeAudioManager.earAction(TraeAudioManager.OPERATION_EARACTION, this.mSessionId, this.mIsHostside, i);
            AppMethodBeat.m2505o(65810);
            return earAction;
        } else if (this.mContext == null || !(i == 0 || i == 1)) {
            AppMethodBeat.m2505o(65810);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_EARACTION);
            intent.putExtra(TraeAudioManager.EXTRA_EARACTION, i);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65810);
            return 0;
        }
    }

    public int isDeviceChangabled() {
        AppMethodBeat.m2504i(65811);
        if (this.mIsHostside) {
            int isDeviceChangabled = TraeAudioManager.isDeviceChangabled(TraeAudioManager.OPERATION_ISDEVICECHANGABLED, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65811);
            return isDeviceChangabled;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65811);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_ISDEVICECHANGABLED);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65811);
            return 0;
        }
    }

    public int getConnectedDevice() {
        AppMethodBeat.m2504i(65812);
        if (this.mIsHostside) {
            int connectedDevice = TraeAudioManager.getConnectedDevice(TraeAudioManager.OPERATION_GETCONNECTEDDEVICE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65812);
            return connectedDevice;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65812);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETCONNECTEDDEVICE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65812);
            return 0;
        }
    }

    public int getConnectingDevice() {
        AppMethodBeat.m2504i(65813);
        if (this.mIsHostside) {
            int connectingDevice = TraeAudioManager.getConnectingDevice(TraeAudioManager.OPERATION_GETCONNECTINGDEVICE, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65813);
            return connectingDevice;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65813);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_GETCONNECTINGDEVICE);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65813);
            return 0;
        }
    }

    public int voiceCallPreprocess(int i, int i2) {
        AppMethodBeat.m2504i(65814);
        if (this.mIsHostside) {
            int voicecallPreprocess = TraeAudioManager.voicecallPreprocess(TraeAudioManager.OPERATION_VOICECALL_PREPROCESS, this.mSessionId, this.mIsHostside, i, i2);
            AppMethodBeat.m2505o(65814);
            return voicecallPreprocess;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65814);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_MODEPOLICY, i);
            intent.putExtra(TraeAudioManager.PARAM_STREAMTYPE, i2);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_PREPROCESS);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65814);
            return 0;
        }
    }

    public int voiceCallPostprocess() {
        AppMethodBeat.m2504i(65815);
        if (this.mIsHostside) {
            int voicecallPostprocess = TraeAudioManager.voicecallPostprocess(TraeAudioManager.OPERATION_VOICECALL_POSTPROCESS, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65815);
            return voicecallPostprocess;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65815);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_POSTPROCESS);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65815);
            return 0;
        }
    }

    public int voiceCallAudioParamChanged(int i, int i2) {
        AppMethodBeat.m2504i(65816);
        if (this.mIsHostside) {
            int voiceCallAudioParamChanged = TraeAudioManager.voiceCallAudioParamChanged(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST, this.mSessionId, this.mIsHostside, i, i2);
            AppMethodBeat.m2505o(65816);
            return voiceCallAudioParamChanged;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65816);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_MODEPOLICY, i);
            intent.putExtra(TraeAudioManager.PARAM_STREAMTYPE, i2);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_VOICECALL_AUDIOPARAM_CHANGED);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65816);
            return 0;
        }
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z) {
        AppMethodBeat.m2504i(65817);
        if (this.mIsHostside) {
            int startRing = TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i, i2, uri, str, z, 1, "normal-ring", false);
            AppMethodBeat.m2505o(65817);
            return startRing;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65817);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
            intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
            intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
            intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
            intent.putExtra(TraeAudioManager.PARAM_RING_MODE, false);
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, "normal-ring");
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65817);
            return 0;
        }
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z, int i3, String str2) {
        AppMethodBeat.m2504i(65818);
        if (this.mIsHostside) {
            int startRing = TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i, i2, uri, str, z, i3, str2, false);
            AppMethodBeat.m2505o(65818);
            return startRing;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65818);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
            intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
            intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
            intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOPCOUNT, i3);
            intent.putExtra(TraeAudioManager.PARAM_RING_MODE, false);
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, str2);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65818);
            return 0;
        }
    }

    public int startRing(int i, int i2, Uri uri, String str, boolean z, int i3, String str2, boolean z2) {
        AppMethodBeat.m2504i(65819);
        if (this.mIsHostside) {
            int startRing = TraeAudioManager.startRing(TraeAudioManager.OPERATION_STARTRING, this.mSessionId, this.mIsHostside, i, i2, uri, str, z, i3, str2, z2);
            AppMethodBeat.m2505o(65819);
            return startRing;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65819);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_RING_DATASOURCE, i);
            intent.putExtra(TraeAudioManager.PARAM_RING_RSID, i2);
            intent.putExtra(TraeAudioManager.PARAM_RING_URI, uri);
            intent.putExtra(TraeAudioManager.PARAM_RING_FILEPATH, str);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOP, z);
            intent.putExtra(TraeAudioManager.PARAM_RING_LOOPCOUNT, i3);
            intent.putExtra(TraeAudioManager.PARAM_RING_MODE, z2);
            intent.putExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING, str2);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STARTRING);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65819);
            return 0;
        }
    }

    public int stopRing() {
        AppMethodBeat.m2504i(65820);
        if (this.mIsHostside) {
            int stopRing = TraeAudioManager.stopRing(TraeAudioManager.OPERATION_STOPRING, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65820);
            return stopRing;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65820);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_STOPRING);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65820);
            return 0;
        }
    }

    public int requestReleaseAudioFocus() {
        AppMethodBeat.m2504i(65821);
        if (this.mIsHostside) {
            int requestReleaseAudioFocus = TraeAudioManager.requestReleaseAudioFocus(TraeAudioManager.OPERATION_REQUEST_RELEASE_AUDIO_FOCUS, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65821);
            return requestReleaseAudioFocus;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65821);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_REQUEST_RELEASE_AUDIO_FOCUS);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65821);
            return 0;
        }
    }

    public int recoverAudioFocus() {
        AppMethodBeat.m2504i(65822);
        if (this.mIsHostside) {
            int recoverAudioFocus = TraeAudioManager.recoverAudioFocus(TraeAudioManager.OPERATION_RECOVER_AUDIO_FOCUS, this.mSessionId, this.mIsHostside);
            AppMethodBeat.m2505o(65822);
            return recoverAudioFocus;
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(65822);
            return -1;
        } else {
            Intent intent = new Intent();
            intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_REQUEST);
            intent.putExtra(TraeAudioManager.PARAM_SESSIONID, this.mSessionId);
            intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.OPERATION_RECOVER_AUDIO_FOCUS);
            this.mContext.sendBroadcast(intent);
            AppMethodBeat.m2505o(65822);
            return 0;
        }
    }

    public void onReceive(Context context, Intent intent) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(65823);
        if (intent == null) {
            AppMethodBeat.m2505o(65823);
            return;
        }
        try {
            long longExtra = intent.getLongExtra(TraeAudioManager.PARAM_SESSIONID, Long.MIN_VALUE);
            String stringExtra = intent.getStringExtra(TraeAudioManager.PARAM_OPERATION);
            int intExtra = intent.getIntExtra(TraeAudioManager.PARAM_RES_ERRCODE, 0);
            String stringExtra2;
            String str;
            int intExtra2;
            String stringExtra3;
            if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY.equals(intent.getAction())) {
                String str2;
                if (TraeAudioManager.NOTIFY_SERVICE_STATE.equals(stringExtra)) {
                    boolean booleanExtra = intent.getBooleanExtra(TraeAudioManager.NOTIFY_SERVICE_STATE_DATE, false);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onServiceStateUpdate]" + (booleanExtra ? "on" : "off"));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28696a(booleanExtra);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.NOTIFY_DEVICELIST_UPDATE.equals(stringExtra)) {
                    String[] stringArrayExtra = intent.getStringArrayExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
                    stringExtra = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
                    stringExtra2 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
                    String stringExtra4 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME);
                    str = IOUtils.LINE_SEPARATOR_UNIX;
                    intExtra = 0;
                    while (intExtra < stringArrayExtra.length) {
                        str = str + "AudioSession|    " + intExtra + " " + stringArrayExtra[intExtra] + IOUtils.LINE_SEPARATOR_UNIX;
                        if (stringArrayExtra[intExtra].equals(TraeAudioManager.DEVICE_WIREDHEADSET) || stringArrayExtra[intExtra].equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
                            z = false;
                        }
                        intExtra++;
                    }
                    str2 = str + IOUtils.LINE_SEPARATOR_UNIX;
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onDeviceListUpdate]  connected:" + stringExtra + " prevConnected:" + stringExtra2 + " bt:" + stringExtra4 + " Num:" + stringArrayExtra.length + str2);
                    }
                    this._canSwtich2Earphone = z;
                    this._connectedDev = stringExtra;
                    if (this.mCallback != null) {
                        this.mCallback.mo28697a(stringArrayExtra, stringExtra, stringExtra2, stringExtra4);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE.equals(stringExtra)) {
                    z = intent.getBooleanExtra(TraeAudioManager.NOTIFY_DEVICECHANGABLE_UPDATE_DATE, true);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onDeviceChangabledUpdate]".concat(String.valueOf(z)));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28700b(z);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.NOTIFY_STREAMTYPE_UPDATE.equals(stringExtra)) {
                    intExtra2 = intent.getIntExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, -1);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onStreamTypeUpdate] err:" + intExtra + " st:" + intExtra2);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28688a(intExtra2);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.NOTIFY_ROUTESWITCHSTART.equals(stringExtra)) {
                    stringExtra3 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHSTART_FROM);
                    str2 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHSTART_TO);
                    if (!(this.mCallback == null || stringExtra3 == null || str2 == null)) {
                        this.mCallback.mo28695a(stringExtra3, str2);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.NOTIFY_ROUTESWITCHEND.equals(stringExtra)) {
                    stringExtra3 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHEND_DEV);
                    longExtra = intent.getLongExtra(TraeAudioManager.EXTRA_DATA_ROUTESWITCHEND_TIME, -1);
                    if (!(this.mCallback == null || stringExtra3 == null || longExtra == -1)) {
                        this.mCallback.mo28694a(stringExtra3, longExtra);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                }
            } else if (TraeAudioManager.ACTION_TRAEAUDIOMANAGER_RES.equals(intent.getAction())) {
                if (this.mSessionId != longExtra) {
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.OPERATION_GETDEVICELIST.equals(stringExtra)) {
                    String[] stringArrayExtra2 = intent.getStringArrayExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST);
                    String stringExtra5 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE);
                    stringExtra = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE);
                    stringExtra2 = intent.getStringExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME);
                    String str3 = IOUtils.LINE_SEPARATOR_UNIX;
                    int i = 0;
                    while (i < stringArrayExtra2.length) {
                        str3 = str3 + "AudioSession|    " + i + " " + stringArrayExtra2[i] + IOUtils.LINE_SEPARATOR_UNIX;
                        if (stringArrayExtra2[i].equals(TraeAudioManager.DEVICE_WIREDHEADSET) || stringArrayExtra2[i].equals(TraeAudioManager.DEVICE_BLUETOOTHHEADSET)) {
                            z = false;
                        }
                        i++;
                    }
                    String str4 = str3 + IOUtils.LINE_SEPARATOR_UNIX;
                    this._canSwtich2Earphone = z;
                    this._connectedDev = stringExtra5;
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onGetDeviceListRes] err:" + intExtra + " connected:" + stringExtra5 + " prevConnected:" + stringExtra + " bt:" + stringExtra2 + " Num:" + stringArrayExtra2.length + str4);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28693a(intExtra, stringArrayExtra2, stringExtra5, stringExtra, stringExtra2);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.OPERATION_CONNECTDEVICE.equals(stringExtra)) {
                    str = intent.getStringExtra(TraeAudioManager.CONNECTDEVICE_RESULT_DEVICENAME);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + intExtra + " dev:" + str);
                    }
                    if (this.mCallback != null) {
                        C24255a c24255a = this.mCallback;
                        if (intExtra == 0) {
                            z2 = true;
                        }
                        c24255a.mo28691a(intExtra, str, z2);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.OPERATION_EARACTION.equals(stringExtra)) {
                    intExtra2 = intent.getIntExtra(TraeAudioManager.EXTRA_EARACTION, -1);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onConnectDeviceRes] err:" + intExtra + " earAction:" + intExtra2);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.OPERATION_ISDEVICECHANGABLED.equals(stringExtra)) {
                    boolean booleanExtra2 = intent.getBooleanExtra(TraeAudioManager.ISDEVICECHANGABLED_RESULT_ISCHANGABLED, false);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onIsDeviceChangabledRes] err:" + intExtra + " Changabled:" + (booleanExtra2 ? "Y" : "N"));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28692a(intExtra, booleanExtra2);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.OPERATION_GETCONNECTEDDEVICE.equals(stringExtra)) {
                    stringExtra3 = intent.getStringExtra(TraeAudioManager.GETCONNECTEDDEVICE_RESULT_LIST);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onGetConnectedDeviceRes] err:" + intExtra + " dev:" + stringExtra3);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28690a(intExtra, stringExtra3);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.OPERATION_GETCONNECTINGDEVICE.equals(stringExtra)) {
                    stringExtra3 = intent.getStringExtra(TraeAudioManager.GETCONNECTINGDEVICE_RESULT_LIST);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onGetConnectingDeviceRes] err:" + intExtra + " dev:" + stringExtra3);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28699b(intExtra, stringExtra3);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.OPERATION_GETSTREAMTYPE.equals(stringExtra)) {
                    intExtra2 = intent.getIntExtra(TraeAudioManager.EXTRA_DATA_STREAMTYPE, -1);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onGetStreamTypeRes] err:" + intExtra + " st:" + intExtra2);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28689a(intExtra, intExtra2);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.NOTIFY_RING_COMPLETION.equals(stringExtra)) {
                    stringExtra3 = intent.getStringExtra(TraeAudioManager.PARAM_RING_USERDATA_STRING);
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onRingCompletion] err:" + intExtra + " userData:" + stringExtra3);
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28701c(intExtra, stringExtra3);
                    }
                    AppMethodBeat.m2505o(65823);
                    return;
                } else if (TraeAudioManager.OPERATION_VOICECALL_PREPROCESS.equals(stringExtra)) {
                    if (QLog.isColorLevel()) {
                        QLog.m8770w("TRAE", 2, "AudioSession|[onVoicecallPreprocess] err:".concat(String.valueOf(intExtra)));
                    }
                    if (this.mCallback != null) {
                        this.mCallback.mo28698b(intExtra);
                    }
                }
            }
            AppMethodBeat.m2505o(65823);
        } catch (Exception e) {
            if (QLog.isColorLevel()) {
                QLog.m8765e("TRAE", 2, "AudioSession| nSessinId = " + this.mSessionId + " onReceive::intent:" + intent.toString() + " intent.getAction():" + intent.getAction() + " Exception:" + e.getMessage());
            }
            AppMethodBeat.m2505o(65823);
        }
    }
}
