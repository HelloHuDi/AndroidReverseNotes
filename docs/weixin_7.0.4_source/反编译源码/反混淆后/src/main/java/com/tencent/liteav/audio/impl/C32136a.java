package com.tencent.liteav.audio.impl;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.liteav.audio.impl.a */
public class C32136a implements C45101e {
    /* renamed from: a */
    private final String f14687a;
    /* renamed from: b */
    private Context f14688b;
    /* renamed from: c */
    private BroadcastReceiver f14689c;
    /* renamed from: d */
    private ServiceListener f14690d;
    /* renamed from: e */
    private BluetoothHeadset f14691e;
    /* renamed from: f */
    private List<C37350d> f14692f;
    /* renamed from: g */
    private Handler f14693g;
    /* renamed from: h */
    private boolean f14694h;
    /* renamed from: i */
    private int f14695i;
    /* renamed from: j */
    private AudioManager f14696j;

    /* renamed from: com.tencent.liteav.audio.impl.a$1 */
    class C177671 extends BroadcastReceiver {
        C177671() {
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(66707);
            String action = intent.getAction();
            TXCLog.m15677i(C32136a.this.f14687a, "onReceive, action = ".concat(String.valueOf(action)));
            if (action.equals("android.intent.action.HEADSET_PLUG")) {
                C32136a.m52266a(C32136a.this, intent);
                AppMethodBeat.m2505o(66707);
            } else if (action.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                C32136a.m52271b(C32136a.this, intent);
                AppMethodBeat.m2505o(66707);
            } else {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (!(bluetoothDevice == null || C32136a.this.f14691e == null)) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    C32136a.m52265a(C32136a.this, bluetoothDevice);
                }
                AppMethodBeat.m2505o(66707);
            }
        }
    }

    /* renamed from: com.tencent.liteav.audio.impl.a$4 */
    class C177684 implements Runnable {
        C177684() {
        }

        public void run() {
            AppMethodBeat.m2504i(66543);
            C32136a.this.f14696j.startBluetoothSco();
            AppMethodBeat.m2505o(66543);
        }
    }

    /* renamed from: com.tencent.liteav.audio.impl.a$2 */
    class C256392 implements ServiceListener {
        C256392() {
        }

        public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
            AppMethodBeat.m2504i(66705);
            TXCLog.m15677i(C32136a.this.f14687a, "onServiceConnected");
            if (i == 1) {
                C32136a.this.f14691e = (BluetoothHeadset) bluetoothProfile;
                List connectedDevices = C32136a.this.f14691e.getConnectedDevices();
                if (connectedDevices != null && connectedDevices.size() > 0) {
                    C32136a.m52265a(C32136a.this, (BluetoothDevice) connectedDevices.get(0));
                }
            }
            AppMethodBeat.m2505o(66705);
        }

        public void onServiceDisconnected(int i) {
            AppMethodBeat.m2504i(66706);
            TXCLog.m15677i(C32136a.this.f14687a, "onServiceDisconnected");
            if (i == 1) {
                C32136a.this.f14691e = null;
                C32136a.this.mo52716a(C32136a.this.f14695i);
            }
            AppMethodBeat.m2505o(66706);
        }
    }

    /* renamed from: com.tencent.liteav.audio.impl.a$3 */
    class C256403 implements Runnable {
        C256403() {
        }

        public void run() {
            AppMethodBeat.m2504i(66567);
            C32136a.this.f14696j.startBluetoothSco();
            AppMethodBeat.m2505o(66567);
        }
    }

    /* renamed from: com.tencent.liteav.audio.impl.a$a */
    static class C32137a {
        /* renamed from: a */
        private static final C32136a f14697a = new C32136a();

        static {
            AppMethodBeat.m2504i(66553);
            AppMethodBeat.m2505o(66553);
        }
    }

    /* synthetic */ C32136a(C177671 c177671) {
        this();
    }

    /* renamed from: b */
    static /* synthetic */ void m52271b(C32136a c32136a, Intent intent) {
        AppMethodBeat.m2504i(66581);
        c32136a.m52264a(intent);
        AppMethodBeat.m2505o(66581);
    }

    /* renamed from: a */
    public static void m52267a(String str) {
        AppMethodBeat.m2504i(66568);
        TXCTraeJNI.nativeSetTraeConfig(str);
        AppMethodBeat.m2505o(66568);
    }

    static {
        AppMethodBeat.m2504i(66583);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66583);
    }

    /* renamed from: a */
    public static C32136a m52261a() {
        AppMethodBeat.m2504i(66569);
        C32136a a = C32137a.f14697a;
        AppMethodBeat.m2505o(66569);
        return a;
    }

    private C32136a() {
        AppMethodBeat.m2504i(66570);
        this.f14687a = "AudioCenter:" + C32136a.class.getSimpleName();
        this.f14695i = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
        this.f14692f = new ArrayList();
        AppMethodBeat.m2505o(66570);
    }

    /* renamed from: a */
    public void mo52717a(Context context) {
        AppMethodBeat.m2504i(66571);
        if (this.f14689c != null) {
            AppMethodBeat.m2505o(66571);
            return;
        }
        TXCLog.m15677i(this.f14687a, "init");
        this.f14688b = context.getApplicationContext();
        C25642c.m40631a().mo43365a(this.f14688b);
        C25642c.m40631a().mo43366a((C45101e) this);
        this.f14696j = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.f14693g = new Handler(Looper.getMainLooper());
        this.f14689c = new C177671();
        this.f14690d = new C256392();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        this.f14688b.registerReceiver(this.f14689c, intentFilter);
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                defaultAdapter.getProfileProxy(this.f14688b, this.f14690d, 1);
            }
            AppMethodBeat.m2505o(66571);
        } catch (Exception e) {
            TXCLog.m15676e(this.f14687a, "BluetoothAdapter getProfileProxy: ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(66571);
        }
    }

    /* renamed from: a */
    private void m52264a(Intent intent) {
        AppMethodBeat.m2504i(66572);
        int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        new StringBuilder("Audio SCO state: ").append(intExtra).append(", thread id = ").append(Thread.currentThread().getId());
        if (intExtra == 1) {
            TXCLog.m15677i(this.f14687a, "SCO connected, yeah!");
            this.f14696j.setBluetoothScoOn(true);
            mo52716a(this.f14695i);
            AppMethodBeat.m2505o(66572);
        } else if (intExtra == 2) {
            TXCLog.m15677i(this.f14687a, "SCO connecting");
            AppMethodBeat.m2505o(66572);
        } else {
            if (intExtra == 0) {
                TXCLog.m15677i(this.f14687a, "SCO disconnect");
                if (this.f14691e == null) {
                    AppMethodBeat.m2505o(66572);
                    return;
                }
                this.f14693g.postDelayed(new C256403(), 1000);
            }
            AppMethodBeat.m2505o(66572);
        }
    }

    /* renamed from: b */
    private void m52270b(Intent intent) {
        AppMethodBeat.m2504i(66573);
        if (intent.hasExtra("state")) {
            int intExtra = intent.getIntExtra("state", 0);
            if (intExtra == 0) {
                this.f14694h = false;
                m52268a(false);
                mo52716a(this.f14695i);
                TXCLog.m15675d(this.f14687a, "pull out wired headset");
                AppMethodBeat.m2505o(66573);
                return;
            } else if (1 == intExtra) {
                this.f14694h = true;
                m52268a(true);
                mo52716a(this.f14695i);
                TXCLog.m15675d(this.f14687a, "insert wired headset");
            }
        }
        AppMethodBeat.m2505o(66573);
    }

    /* renamed from: a */
    private void m52263a(BluetoothDevice bluetoothDevice) {
        AppMethodBeat.m2504i(66574);
        if (bluetoothDevice == null || this.f14691e == null) {
            AppMethodBeat.m2505o(66574);
            return;
        }
        int connectionState;
        try {
            connectionState = this.f14691e.getConnectionState(bluetoothDevice);
        } catch (Exception e) {
            TXCLog.m15676e(this.f14687a, "getConnectionState exception: ".concat(String.valueOf(e)));
            connectionState = 0;
        }
        TXCLog.m15675d(this.f14687a, "BluetoothHeadset state：".concat(String.valueOf(connectionState)));
        switch (connectionState) {
            case 0:
                m52268a(false);
                TXCLog.m15675d(this.f14687a, "BluetoothHeadset disconnect");
                this.f14696j.setBluetoothScoOn(false);
                this.f14696j.stopBluetoothSco();
                mo52716a(this.f14695i);
                break;
            case 2:
                m52268a(true);
                TXCLog.m15675d(this.f14687a, "BluetoothHeadset connect");
                if (this.f14696j.isBluetoothScoAvailableOffCall()) {
                    this.f14696j.startBluetoothSco();
                    AppMethodBeat.m2505o(66574);
                    return;
                }
                TXCLog.m15676e(this.f14687a, "not support BTHeadset sco");
                AppMethodBeat.m2505o(66574);
                return;
        }
        AppMethodBeat.m2505o(66574);
    }

    /* renamed from: a */
    public synchronized void mo52716a(int i) {
        AppMethodBeat.m2504i(66575);
        this.f14695i = i;
        if (this.f14694h) {
            this.f14696j.setMode(0);
            this.f14696j.setSpeakerphoneOn(false);
            TXCLog.m15675d(this.f14687a, "setAudioMode, is wiredHeadsetOn, set MODE_NORMAL and speakerphoneOn false");
            AppMethodBeat.m2505o(66575);
        } else if (this.f14691e != null && this.f14696j.isBluetoothScoOn()) {
            this.f14696j.setMode(3);
            this.f14696j.setSpeakerphoneOn(false);
            TXCLog.m15675d(this.f14687a, "setAudioMode, is bluetoothHeadset connect and isBluetoothScoOn true, set mode MODE_IN_COMMUNICATION and speakerphoneOn false");
            AppMethodBeat.m2505o(66575);
        } else if (this.f14696j == null) {
            AppMethodBeat.m2505o(66575);
        } else if (i == TXEAudioDef.TXE_AUDIO_MODE_RECEIVER) {
            this.f14696j.setMode(3);
            this.f14696j.setSpeakerphoneOn(false);
            TXCLog.m15677i(this.f14687a, "AudioCenter setAudioMode to receiver, MODE_IN_COMMUNICATION, speakerphoneOn false");
            AppMethodBeat.m2505o(66575);
        } else {
            this.f14696j.setMode(0);
            this.f14696j.setSpeakerphoneOn(true);
            TXCLog.m15677i(this.f14687a, "AudioCenter setAudioMode to speaker, MODE_NORMAL, speakerphoneOn true");
            AppMethodBeat.m2505o(66575);
        }
    }

    /* renamed from: a */
    public synchronized void mo52718a(C37350d c37350d) {
        AppMethodBeat.m2504i(66576);
        if (c37350d == null) {
            AppMethodBeat.m2505o(66576);
        } else {
            this.f14692f.add(c37350d);
            if (this.f14694h) {
                c37350d.OnHeadsetState(true);
                AppMethodBeat.m2505o(66576);
            } else if (this.f14691e == null || this.f14696j == null || !this.f14696j.isBluetoothScoOn()) {
                c37350d.OnHeadsetState(false);
                AppMethodBeat.m2505o(66576);
            } else {
                c37350d.OnHeadsetState(true);
                AppMethodBeat.m2505o(66576);
            }
        }
    }

    /* renamed from: b */
    public synchronized void mo52719b(C37350d c37350d) {
        AppMethodBeat.m2504i(66577);
        if (c37350d == null) {
            AppMethodBeat.m2505o(66577);
        } else {
            this.f14692f.remove(c37350d);
            AppMethodBeat.m2505o(66577);
        }
    }

    /* renamed from: a */
    private synchronized void m52268a(boolean z) {
        AppMethodBeat.m2504i(66578);
        for (C37350d OnHeadsetState : this.f14692f) {
            OnHeadsetState.OnHeadsetState(z);
        }
        AppMethodBeat.m2505o(66578);
    }

    /* renamed from: b */
    public void mo3796b(int i) {
        AppMethodBeat.m2504i(66579);
        TXCLog.m15677i(this.f14687a, "onCallStateChanged, state = ".concat(String.valueOf(i)));
        if (this.f14696j.isBluetoothScoAvailableOffCall()) {
            if (!(i != 0 || this.f14691e == null || this.f14696j.isBluetoothScoOn())) {
                TXCLog.m15677i(this.f14687a, "to restartBluetoothSco");
                this.f14693g.postDelayed(new C177684(), 1000);
            }
            AppMethodBeat.m2505o(66579);
            return;
        }
        TXCLog.m15676e(this.f14687a, "not support BTHeadset sco");
        AppMethodBeat.m2505o(66579);
    }
}
