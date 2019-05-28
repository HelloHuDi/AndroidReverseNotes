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
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class a implements e {
    private final String a;
    private Context b;
    private BroadcastReceiver c;
    private ServiceListener d;
    private BluetoothHeadset e;
    private List<d> f;
    private Handler g;
    private boolean h;
    private int i;
    private AudioManager j;

    static class a {
        private static final a a = new a();

        static {
            AppMethodBeat.i(66553);
            AppMethodBeat.o(66553);
        }
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    static /* synthetic */ void b(a aVar, Intent intent) {
        AppMethodBeat.i(66581);
        aVar.a(intent);
        AppMethodBeat.o(66581);
    }

    public static void a(String str) {
        AppMethodBeat.i(66568);
        TXCTraeJNI.nativeSetTraeConfig(str);
        AppMethodBeat.o(66568);
    }

    static {
        AppMethodBeat.i(66583);
        b.e();
        AppMethodBeat.o(66583);
    }

    public static a a() {
        AppMethodBeat.i(66569);
        a a = a.a;
        AppMethodBeat.o(66569);
        return a;
    }

    private a() {
        AppMethodBeat.i(66570);
        this.a = "AudioCenter:" + a.class.getSimpleName();
        this.i = TXEAudioDef.TXE_AUDIO_MODE_SPEAKER;
        this.f = new ArrayList();
        AppMethodBeat.o(66570);
    }

    public void a(Context context) {
        AppMethodBeat.i(66571);
        if (this.c != null) {
            AppMethodBeat.o(66571);
            return;
        }
        TXCLog.i(this.a, "init");
        this.b = context.getApplicationContext();
        c.a().a(this.b);
        c.a().a((e) this);
        this.j = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.g = new Handler(Looper.getMainLooper());
        this.c = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(66707);
                String action = intent.getAction();
                TXCLog.i(a.this.a, "onReceive, action = ".concat(String.valueOf(action)));
                if (action.equals("android.intent.action.HEADSET_PLUG")) {
                    a.a(a.this, intent);
                    AppMethodBeat.o(66707);
                } else if (action.equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                    a.b(a.this, intent);
                    AppMethodBeat.o(66707);
                } else {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (!(bluetoothDevice == null || a.this.e == null)) {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        a.a(a.this, bluetoothDevice);
                    }
                    AppMethodBeat.o(66707);
                }
            }
        };
        this.d = new ServiceListener() {
            public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
                AppMethodBeat.i(66705);
                TXCLog.i(a.this.a, "onServiceConnected");
                if (i == 1) {
                    a.this.e = (BluetoothHeadset) bluetoothProfile;
                    List connectedDevices = a.this.e.getConnectedDevices();
                    if (connectedDevices != null && connectedDevices.size() > 0) {
                        a.a(a.this, (BluetoothDevice) connectedDevices.get(0));
                    }
                }
                AppMethodBeat.o(66705);
            }

            public void onServiceDisconnected(int i) {
                AppMethodBeat.i(66706);
                TXCLog.i(a.this.a, "onServiceDisconnected");
                if (i == 1) {
                    a.this.e = null;
                    a.this.a(a.this.i);
                }
                AppMethodBeat.o(66706);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
        this.b.registerReceiver(this.c, intentFilter);
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null) {
                defaultAdapter.getProfileProxy(this.b, this.d, 1);
            }
            AppMethodBeat.o(66571);
        } catch (Exception e) {
            TXCLog.e(this.a, "BluetoothAdapter getProfileProxy: ".concat(String.valueOf(e)));
            AppMethodBeat.o(66571);
        }
    }

    private void a(Intent intent) {
        AppMethodBeat.i(66572);
        int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
        new StringBuilder("Audio SCO state: ").append(intExtra).append(", thread id = ").append(Thread.currentThread().getId());
        if (intExtra == 1) {
            TXCLog.i(this.a, "SCO connected, yeah!");
            this.j.setBluetoothScoOn(true);
            a(this.i);
            AppMethodBeat.o(66572);
        } else if (intExtra == 2) {
            TXCLog.i(this.a, "SCO connecting");
            AppMethodBeat.o(66572);
        } else {
            if (intExtra == 0) {
                TXCLog.i(this.a, "SCO disconnect");
                if (this.e == null) {
                    AppMethodBeat.o(66572);
                    return;
                }
                this.g.postDelayed(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(66567);
                        a.this.j.startBluetoothSco();
                        AppMethodBeat.o(66567);
                    }
                }, 1000);
            }
            AppMethodBeat.o(66572);
        }
    }

    private void b(Intent intent) {
        AppMethodBeat.i(66573);
        if (intent.hasExtra("state")) {
            int intExtra = intent.getIntExtra("state", 0);
            if (intExtra == 0) {
                this.h = false;
                a(false);
                a(this.i);
                TXCLog.d(this.a, "pull out wired headset");
                AppMethodBeat.o(66573);
                return;
            } else if (1 == intExtra) {
                this.h = true;
                a(true);
                a(this.i);
                TXCLog.d(this.a, "insert wired headset");
            }
        }
        AppMethodBeat.o(66573);
    }

    private void a(BluetoothDevice bluetoothDevice) {
        AppMethodBeat.i(66574);
        if (bluetoothDevice == null || this.e == null) {
            AppMethodBeat.o(66574);
            return;
        }
        int connectionState;
        try {
            connectionState = this.e.getConnectionState(bluetoothDevice);
        } catch (Exception e) {
            TXCLog.e(this.a, "getConnectionState exception: ".concat(String.valueOf(e)));
            connectionState = 0;
        }
        TXCLog.d(this.a, "BluetoothHeadset state：".concat(String.valueOf(connectionState)));
        switch (connectionState) {
            case 0:
                a(false);
                TXCLog.d(this.a, "BluetoothHeadset disconnect");
                this.j.setBluetoothScoOn(false);
                this.j.stopBluetoothSco();
                a(this.i);
                break;
            case 2:
                a(true);
                TXCLog.d(this.a, "BluetoothHeadset connect");
                if (this.j.isBluetoothScoAvailableOffCall()) {
                    this.j.startBluetoothSco();
                    AppMethodBeat.o(66574);
                    return;
                }
                TXCLog.e(this.a, "not support BTHeadset sco");
                AppMethodBeat.o(66574);
                return;
        }
        AppMethodBeat.o(66574);
    }

    public synchronized void a(int i) {
        AppMethodBeat.i(66575);
        this.i = i;
        if (this.h) {
            this.j.setMode(0);
            this.j.setSpeakerphoneOn(false);
            TXCLog.d(this.a, "setAudioMode, is wiredHeadsetOn, set MODE_NORMAL and speakerphoneOn false");
            AppMethodBeat.o(66575);
        } else if (this.e != null && this.j.isBluetoothScoOn()) {
            this.j.setMode(3);
            this.j.setSpeakerphoneOn(false);
            TXCLog.d(this.a, "setAudioMode, is bluetoothHeadset connect and isBluetoothScoOn true, set mode MODE_IN_COMMUNICATION and speakerphoneOn false");
            AppMethodBeat.o(66575);
        } else if (this.j == null) {
            AppMethodBeat.o(66575);
        } else if (i == TXEAudioDef.TXE_AUDIO_MODE_RECEIVER) {
            this.j.setMode(3);
            this.j.setSpeakerphoneOn(false);
            TXCLog.i(this.a, "AudioCenter setAudioMode to receiver, MODE_IN_COMMUNICATION, speakerphoneOn false");
            AppMethodBeat.o(66575);
        } else {
            this.j.setMode(0);
            this.j.setSpeakerphoneOn(true);
            TXCLog.i(this.a, "AudioCenter setAudioMode to speaker, MODE_NORMAL, speakerphoneOn true");
            AppMethodBeat.o(66575);
        }
    }

    public synchronized void a(d dVar) {
        AppMethodBeat.i(66576);
        if (dVar == null) {
            AppMethodBeat.o(66576);
        } else {
            this.f.add(dVar);
            if (this.h) {
                dVar.OnHeadsetState(true);
                AppMethodBeat.o(66576);
            } else if (this.e == null || this.j == null || !this.j.isBluetoothScoOn()) {
                dVar.OnHeadsetState(false);
                AppMethodBeat.o(66576);
            } else {
                dVar.OnHeadsetState(true);
                AppMethodBeat.o(66576);
            }
        }
    }

    public synchronized void b(d dVar) {
        AppMethodBeat.i(66577);
        if (dVar == null) {
            AppMethodBeat.o(66577);
        } else {
            this.f.remove(dVar);
            AppMethodBeat.o(66577);
        }
    }

    private synchronized void a(boolean z) {
        AppMethodBeat.i(66578);
        for (d OnHeadsetState : this.f) {
            OnHeadsetState.OnHeadsetState(z);
        }
        AppMethodBeat.o(66578);
    }

    public void b(int i) {
        AppMethodBeat.i(66579);
        TXCLog.i(this.a, "onCallStateChanged, state = ".concat(String.valueOf(i)));
        if (this.j.isBluetoothScoAvailableOffCall()) {
            if (!(i != 0 || this.e == null || this.j.isBluetoothScoOn())) {
                TXCLog.i(this.a, "to restartBluetoothSco");
                this.g.postDelayed(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(66543);
                        a.this.j.startBluetoothSco();
                        AppMethodBeat.o(66543);
                    }
                }, 1000);
            }
            AppMethodBeat.o(66579);
            return;
        }
        TXCLog.e(this.a, "not support BTHeadset sco");
        AppMethodBeat.o(66579);
    }
}
