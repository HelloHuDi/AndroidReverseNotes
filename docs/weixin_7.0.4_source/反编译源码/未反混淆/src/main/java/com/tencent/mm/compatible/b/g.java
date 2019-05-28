package com.tencent.mm.compatible.b;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Message;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.g.a.jw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class g {
    private static volatile g eoX = null;
    private static boolean epb = false;
    public static boolean epc = false;
    private static boolean epd = false;
    private static boolean epe = false;
    private static int epm = 0;
    private static int epn = 0;
    private static HashMap<Integer, String> epo = new HashMap();
    private static int epp = 0;
    private static int epq = 0;
    private static HashMap<Integer, String> epr = new HashMap();
    private static int eps = 0;
    private static int ept = 0;
    private static HashMap<Integer, String> epu = new HashMap();
    public final AudioManager eoY;
    private int eoZ = -1;
    private String epa;
    private int epf = 0;
    private final Set<a> epg = new HashSet();
    private final int eph = 1000;
    private ak epi = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(92851);
            ab.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            g.this.iI(3);
            AppMethodBeat.o(92851);
        }
    };
    private ak epj = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(92842);
            ab.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_ACTIVE ");
            g.this.iI(5);
            AppMethodBeat.o(92842);
        }
    };
    private ak epk = new ak() {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(92843);
            ab.i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            g.this.setMode(0);
            AppMethodBeat.o(92843);
        }
    };
    private int epl = -1;

    public interface a {
        void gE(int i);
    }

    static {
        AppMethodBeat.i(92892);
        AppMethodBeat.o(92892);
    }

    public static g KK() {
        AppMethodBeat.i(92852);
        if (eoX == null) {
            synchronized (g.class) {
                try {
                    if (eoX == null) {
                        eoX = new g(ah.getContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(92852);
                    }
                }
            }
        }
        g gVar = eoX;
        AppMethodBeat.o(92852);
        return gVar;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(92853);
        if (aVar != null) {
            this.epg.add(aVar);
        }
        AppMethodBeat.o(92853);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(92854);
        if (aVar != null) {
            this.epg.remove(aVar);
        }
        AppMethodBeat.o(92854);
    }

    public final void iI(int i) {
        AppMethodBeat.i(92855);
        ab.i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", Integer.valueOf(i), Integer.valueOf(this.eoZ));
        for (a gE : this.epg) {
            gE.gE(i);
        }
        AppMethodBeat.o(92855);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public g(Context context) {
        AppMethodBeat.i(92856);
        this.eoY = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        ab.i("MicroMsg.MMAudioManager", "init dkbt %s", KT());
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(92841);
                ab.i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
                g.this.iI(7);
                AppMethodBeat.o(92841);
            }
        }, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(92844);
                int intExtra = intent.getIntExtra("state", -1);
                int intExtra2 = intent.getIntExtra("microphone", -1);
                ab.i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                if (intExtra == 0) {
                    g.this.iI(6);
                    AppMethodBeat.o(92844);
                    return;
                }
                if (intExtra == 1) {
                    g.this.KN();
                }
                AppMethodBeat.o(92844);
            }
        }, new IntentFilter("android.intent.action.HEADSET_PLUG"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(92845);
                if (intent == null) {
                    AppMethodBeat.o(92845);
                    return;
                }
                String action = intent.getAction();
                g.epd = intent.getBooleanExtra("existing", false);
                ab.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] existing:" + g.epd);
                AppMethodBeat.o(92845);
            }
        }, new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(92846);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null) {
                    ab.i("MicroMsg.MMAudioManager", "device is unavailable");
                    AppMethodBeat.o(92846);
                } else if (g.this.epa == null) {
                    g.this.epa = bluetoothDevice.getAddress();
                    AppMethodBeat.o(92846);
                } else {
                    if (g.this.epa.equals(bluetoothDevice.getAddress())) {
                        ab.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
                        if (d.fP(11)) {
                            g.epb = true;
                            g.this.epi.sendEmptyMessageDelayed(0, 1000);
                        }
                    }
                    AppMethodBeat.o(92846);
                }
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(92847);
                ab.i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null) {
                    ab.i("MicroMsg.MMAudioManager", "pre address is null");
                    AppMethodBeat.o(92847);
                    return;
                }
                if (bluetoothDevice.getAddress().equals(g.this.epa)) {
                    ab.i("MicroMsg.MMAudioManager", "pre connect device is " + bluetoothDevice.getAddress());
                    g.epb = false;
                    g.this.epa = null;
                    if (q.etn.erJ == 1) {
                        com.tencent.mm.compatible.c.a.b(g.this.eoY);
                    }
                    g.this.iI(4);
                }
                AppMethodBeat.o(92847);
            }
        }, new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        if (d.iW(11)) {
            context.registerReceiver(new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(92848);
                    if (intent == null) {
                        AppMethodBeat.o(92848);
                        return;
                    }
                    String action = intent.getAction();
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice == null) {
                        ab.i("MicroMsg.MMAudioManager", "pre address is null");
                        AppMethodBeat.o(92848);
                    } else if (g.this.epa == null) {
                        g.this.epa = bluetoothDevice.getAddress();
                        AppMethodBeat.o(92848);
                    } else {
                        if (bluetoothDevice.getAddress().equals(g.this.epa)) {
                            ab.i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] state:" + intExtra);
                            if (intExtra == 2) {
                                g.epb = true;
                                g.this.epi.sendEmptyMessageDelayed(0, 1000);
                                AppMethodBeat.o(92848);
                                return;
                            } else if (intExtra == 0) {
                                g.epb = false;
                                if (q.etn.erJ == 1) {
                                    com.tencent.mm.compatible.c.a.b(g.this.eoY);
                                }
                                g.this.iI(4);
                                g.this.epa = null;
                            }
                        }
                        AppMethodBeat.o(92848);
                    }
                }
            }, new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
        context.registerReceiver(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(92849);
                if (intent == null) {
                    AppMethodBeat.o(92849);
                    return;
                }
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice == null) {
                    ab.i("MicroMsg.MMAudioManager", "pre address is null");
                    AppMethodBeat.o(92849);
                    return;
                }
                if (bluetoothDevice.getAddress().equals(g.this.epa)) {
                    ab.i("MicroMsg.MMAudioManager", "onReceive bluetooth state changed: %s, prevState: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                    if (intExtra == 10) {
                        g.epb = false;
                        g.epc = false;
                        if (q.etn.erJ == 1) {
                            com.tencent.mm.compatible.c.a.b(g.this.eoY);
                        }
                        g.this.iI(4);
                    }
                }
                AppMethodBeat.o(92849);
            }
        }, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        if (d.iW(28)) {
            context.registerReceiver(new BroadcastReceiver() {
                public final void onReceive(Context context, Intent intent) {
                    AppMethodBeat.i(92850);
                    if (intent == null) {
                        AppMethodBeat.o(92850);
                        return;
                    }
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice == null) {
                        ab.i("MicroMsg.MMAudioManager", "device is unavailable");
                        AppMethodBeat.o(92850);
                        return;
                    }
                    g.this.epa = bluetoothDevice.getAddress();
                    g.this.epk.removeMessages(0);
                    g.this.epj.sendEmptyMessageDelayed(0, 1000);
                    ab.i("MicroMsg.MMAudioManager", "android pie switch bt device");
                    AppMethodBeat.o(92850);
                }
            }, new IntentFilter("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED"));
        }
        AppMethodBeat.o(92856);
    }

    public final void KL() {
        AppMethodBeat.i(92857);
        ab.i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", KT());
        epc = false;
        iI(2);
        AppMethodBeat.o(92857);
    }

    public final int KM() {
        AppMethodBeat.i(92858);
        this.eoZ = -1;
        if (KS()) {
            ab.c("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", KT());
            ab.i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", KT(), Boolean.valueOf(com.tencent.mm.compatible.c.a.a(this.eoY)));
            ab.d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + KT() + " ret:" + r0);
            ab.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", Boolean.valueOf(KP()));
            if (KP()) {
                AppMethodBeat.o(92858);
                return 1;
            }
            AppMethodBeat.o(92858);
            return 0;
        }
        AppMethodBeat.o(92858);
        return -1;
    }

    public final void KN() {
        AppMethodBeat.i(92859);
        epc = false;
        ab.c("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", KT());
        com.tencent.mm.compatible.c.a.b(this.eoY);
        this.epi.removeCallbacksAndMessages(Integer.valueOf(1));
        ab.i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", KT());
        AppMethodBeat.o(92859);
    }

    public static boolean KO() {
        return false;
    }

    public final boolean KP() {
        AppMethodBeat.i(92860);
        ab.i("MicroMsg.MMAudioManager", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isScoConnected: %s, isBluetoothCanUse: %s, isACLConnected: %s", Boolean.valueOf(this.eoY.isBluetoothScoOn()), Boolean.valueOf(this.eoY.isBluetoothA2dpOn()), Boolean.valueOf(epc), Boolean.valueOf(KS()), Boolean.valueOf(epb));
        if (this.eoY.isBluetoothScoOn() || r3 || epc) {
            AppMethodBeat.o(92860);
            return true;
        }
        AppMethodBeat.o(92860);
        return false;
    }

    @TargetApi(14)
    private static boolean KQ() {
        AppMethodBeat.i(92861);
        try {
            if (VERSION.SDK_INT >= 14) {
                ab.i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", Integer.valueOf(BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1)));
                if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                    AppMethodBeat.o(92861);
                    return true;
                }
                AppMethodBeat.o(92861);
                return false;
            } else if (epb) {
                AppMethodBeat.o(92861);
                return true;
            } else {
                if (q.etn.erU == 1) {
                    boolean isEnabled = BluetoothAdapter.getDefaultAdapter().isEnabled();
                    AppMethodBeat.o(92861);
                    return isEnabled;
                }
                AppMethodBeat.o(92861);
                return false;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
        }
    }

    public final int bE(boolean z) {
        int i;
        int i2 = 0;
        AppMethodBeat.i(92862);
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        if (!KP()) {
            i2 = i;
        }
        AppMethodBeat.o(92862);
        return i2;
    }

    public static int KR() {
        AppMethodBeat.i(92863);
        ((AudioManager) ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isBluetoothScoOn();
        AppMethodBeat.o(92863);
        return 0;
    }

    public static boolean KS() {
        AppMethodBeat.i(92864);
        ab.d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + epd + " , isUseHTCAccessory = " + epe);
        if (!epd || epe) {
            ab.d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + epb);
            boolean KQ = KQ();
            if (KQ) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter == null) {
                    ab.d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
                    AppMethodBeat.o(92864);
                    return false;
                } else if (defaultAdapter.isEnabled()) {
                    Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                    if (bondedDevices == null || bondedDevices.size() == 0) {
                        ab.e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
                        AppMethodBeat.o(92864);
                        return false;
                    }
                    int i;
                    for (BluetoothDevice bondState : bondedDevices) {
                        if (bondState.getBondState() == 12) {
                            i = 1;
                            break;
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        ab.i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
                        AppMethodBeat.o(92864);
                        return false;
                    }
                    ab.i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", Boolean.TRUE);
                    AppMethodBeat.o(92864);
                    return true;
                } else {
                    ab.i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
                    AppMethodBeat.o(92864);
                    return false;
                }
            }
            ab.i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + epb + " , isConnectHeadset() = " + KQ);
            AppMethodBeat.o(92864);
            return false;
        }
        AppMethodBeat.o(92864);
        return false;
    }

    public final String KT() {
        AppMethodBeat.i(92865);
        String str = "mode:" + (this.eoY != null ? this.eoY.getMode() : 0) + " isSpeakerphoneOn:" + this.eoY.isSpeakerphoneOn() + " isBluetoothOn:" + KP() + " btStatus:" + this.eoZ;
        AppMethodBeat.o(92865);
        return str;
    }

    public final boolean KU() {
        AppMethodBeat.i(92866);
        if (this.eoY.getMode() == 0) {
            AppMethodBeat.o(92866);
            return true;
        }
        AppMethodBeat.o(92866);
        return false;
    }

    @TargetApi(11)
    public final boolean f(boolean z, boolean z2, boolean z3) {
        int i = 0;
        AppMethodBeat.i(92867);
        int mode = this.eoY.getMode();
        ab.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(KU()), Boolean.valueOf(z), KT());
        if (ax.Ex()) {
            ab.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", Integer.valueOf(mode), Integer.valueOf(this.eoZ));
            AppMethodBeat.o(92867);
            return false;
        } else if (z3 || !(KP() || epc)) {
            KZ();
            if (z2) {
                if (q.etd.epG) {
                    if (q.etd.Lg()) {
                        if (q.etd.epI >= 0) {
                            setMode(q.etd.epI);
                        } else if (q.etd.epJ >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (q.etd.epK > 0) {
                            setSpeakerphoneOn(z);
                        }
                        AppMethodBeat.o(92867);
                        return z;
                    } else if (q.etd.Lh()) {
                        if (z) {
                            if (q.etd.Lk()) {
                                setSpeakerphoneOn(true);
                            }
                            if (q.etd.Lj() >= 0) {
                                setMode(q.etd.Lj());
                            }
                        } else {
                            if (q.etd.Lm()) {
                                setSpeakerphoneOn(false);
                            }
                            if (q.etd.Ll() >= 0) {
                                setMode(q.etd.Ll());
                            }
                        }
                        AppMethodBeat.o(92867);
                        return z;
                    }
                }
            } else if (q.etd.epG && q.etd.Li()) {
                if (z) {
                    if (q.etd.Lo()) {
                        setSpeakerphoneOn(true);
                    }
                    if (q.etd.Ln() >= 0) {
                        setMode(q.etd.Ln());
                    }
                } else {
                    if (q.etd.Lq()) {
                        setSpeakerphoneOn(false);
                    }
                    if (q.etd.Lp() >= 0) {
                        setMode(q.etd.Lp());
                    }
                }
                AppMethodBeat.o(92867);
                return z;
            }
            if (!z2) {
                setSpeakerphoneOn(z);
                if (KU() != z) {
                    if (z) {
                        setMode(0);
                    } else if (VERSION.SDK_INT >= 11 && l.IN() && 2 != q.etn.erV) {
                        setMode(3);
                    } else if (VERSION.SDK_INT >= 11) {
                        setMode(3);
                    } else {
                        setMode(2);
                    }
                }
            } else if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i = 3;
                }
                if (q.etd.eqg >= 0) {
                    i = q.etd.eqg;
                }
                ab.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
                if (i != this.eoY.getMode()) {
                    setMode(i);
                }
                if (i != this.eoY.getMode()) {
                    if (this.epf == 0) {
                        this.epf = 1;
                    } else if (this.epf == 2) {
                        this.epf = 3;
                    }
                }
                if (!this.eoY.isSpeakerphoneOn()) {
                    setSpeakerphoneOn(true);
                }
            } else {
                if (VERSION.SDK_INT >= 11) {
                    mode = 3;
                } else if (q.etn.erU == 1) {
                    ab.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                    mode = 0;
                } else {
                    mode = 2;
                }
                if (VERSION.SDK_INT >= 11 && l.IN() && 2 == q.etn.erV) {
                    mode = 2;
                }
                if (q.etd.eqh >= 0) {
                    mode = q.etd.eqh;
                }
                ab.d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:".concat(String.valueOf(mode)));
                if (mode != this.eoY.getMode()) {
                    setMode(mode);
                }
                if (mode != this.eoY.getMode()) {
                    if (this.epf == 0) {
                        this.epf = 2;
                    } else if (this.epf == 1) {
                        this.epf = 3;
                    }
                }
                if (this.eoY.isSpeakerphoneOn()) {
                    setSpeakerphoneOn(false);
                }
            }
            AppMethodBeat.o(92867);
            return z;
        } else {
            ab.i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
            if (z2) {
                ab.d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
                setMode(3);
            } else {
                setMode(0);
            }
            AppMethodBeat.o(92867);
            return false;
        }
    }

    @TargetApi(11)
    public final boolean bF(boolean z) {
        int i = 3;
        int i2 = 0;
        AppMethodBeat.i(92868);
        ab.d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(KU()), Boolean.valueOf(z), KT());
        if (ax.Ex()) {
            ab.v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", Integer.valueOf(this.eoZ));
            AppMethodBeat.o(92868);
            return false;
        } else if (epc) {
            setMode(3);
            AppMethodBeat.o(92868);
            return false;
        } else {
            KZ();
            if (q.etd.eqF) {
                if (z) {
                    if (VERSION.SDK_INT >= 11) {
                        i2 = 3;
                    }
                    if (q.etd.eqG >= 0) {
                        i2 = q.etd.eqG;
                    }
                    ab.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i2)));
                    if (i2 != this.eoY.getMode()) {
                        setMode(i2);
                    }
                    if (!this.eoY.isSpeakerphoneOn()) {
                        setSpeakerphoneOn(true);
                    }
                } else {
                    if (VERSION.SDK_INT < 11) {
                        if (q.etn.erU == 1) {
                            ab.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                            i = 0;
                        } else {
                            i = 2;
                        }
                    }
                    if (q.etd.eqH >= 0) {
                        i = q.etd.eqH;
                    }
                    ab.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
                    if (i != this.eoY.getMode()) {
                        setMode(i);
                    }
                    if (this.eoY.isSpeakerphoneOn()) {
                        setSpeakerphoneOn(false);
                    }
                }
                AppMethodBeat.o(92868);
                return z;
            }
            if (q.etd.epG) {
                if (q.etd.Lg()) {
                    if (q.etd.epI >= 0) {
                        setMode(q.etd.epI);
                    } else if (q.etd.epJ >= 0) {
                        if (z) {
                            setMode(0);
                        } else {
                            setMode(2);
                        }
                    }
                    if (q.etd.epK > 0) {
                        setSpeakerphoneOn(z);
                    }
                    AppMethodBeat.o(92868);
                    return z;
                } else if (q.etd.Lh()) {
                    if (z) {
                        if (q.etd.Lk()) {
                            setSpeakerphoneOn(true);
                        }
                        if (q.etd.Lj() >= 0) {
                            setMode(q.etd.Lj());
                        }
                    } else {
                        if (q.etd.Lm()) {
                            setSpeakerphoneOn(false);
                        }
                        if (q.etd.Ll() >= 0) {
                            setMode(q.etd.Ll());
                        }
                    }
                    AppMethodBeat.o(92868);
                    return z;
                }
            }
            if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i2 = 3;
                }
                if (q.etd.eqg >= 0) {
                    i2 = q.etd.eqg;
                }
                ab.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i2)));
                if (i2 != this.eoY.getMode()) {
                    setMode(i2);
                }
                if (!this.eoY.isSpeakerphoneOn()) {
                    setSpeakerphoneOn(true);
                }
            } else {
                if (VERSION.SDK_INT < 11) {
                    if (q.etn.erU == 1) {
                        ab.d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (VERSION.SDK_INT >= 11 && l.IN() && 2 == q.etn.erV) {
                    i = 2;
                }
                if (q.etd.eqh >= 0) {
                    i = q.etd.eqh;
                }
                ab.d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
                if (i != this.eoY.getMode()) {
                    setMode(i);
                }
                if (this.eoY.isSpeakerphoneOn()) {
                    setSpeakerphoneOn(false);
                }
            }
            AppMethodBeat.o(92868);
            return z;
        }
    }

    public final boolean b(boolean z, int i, boolean z2) {
        AppMethodBeat.i(92869);
        int streamMaxVolume = this.eoY.getStreamMaxVolume(i);
        ab.d("MicroMsg.MMAudioManager", "maxVolumn:".concat(String.valueOf(streamMaxVolume)));
        streamMaxVolume /= 3;
        int streamVolume = this.eoY.getStreamVolume(i);
        if (streamVolume < streamMaxVolume) {
            a.b(this.eoY, i, streamMaxVolume);
        }
        ab.i("MicroMsg.MMAudioManager", "StreamType:" + i + "  current:" + streamVolume);
        boolean f = f(z, true, z2);
        AppMethodBeat.o(92869);
        return f;
    }

    public final boolean KV() {
        AppMethodBeat.i(92870);
        if (this.eoY != null) {
            boolean isWiredHeadsetOn = this.eoY.isWiredHeadsetOn();
            if (!isWiredHeadsetOn && d.iW(23)) {
                isWiredHeadsetOn = KW();
            }
            AppMethodBeat.o(92870);
            return isWiredHeadsetOn;
        }
        AppMethodBeat.o(92870);
        return false;
    }

    private boolean KW() {
        AppMethodBeat.i(92871);
        if (this.eoY != null && d.iW(23)) {
            for (AudioDeviceInfo audioDeviceInfo : this.eoY.getDevices(3)) {
                ab.i("MicroMsg.MMAudioManager", "isWireHeadsetPluggedNew, deviceInfo type: %s", Integer.valueOf(audioDeviceInfo.getType()));
                if (audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 11) {
                    AppMethodBeat.o(92871);
                    return true;
                }
            }
        }
        AppMethodBeat.o(92871);
        return false;
    }

    public final void iJ(int i) {
        AppMethodBeat.i(92872);
        if (this.eoY != null) {
            a.a(this.eoY, i, 1);
        }
        AppMethodBeat.o(92872);
    }

    public final void iK(int i) {
        AppMethodBeat.i(92873);
        if (this.eoY != null) {
            a.a(this.eoY, i, -1);
        }
        AppMethodBeat.o(92873);
    }

    public final void KX() {
        AppMethodBeat.i(92874);
        if (this.eoY != null) {
            this.eoY.setStreamMute(3, true);
        }
        AppMethodBeat.o(92874);
    }

    public final void KY() {
        AppMethodBeat.i(92875);
        if (this.eoY != null) {
            this.eoY.setStreamMute(3, false);
        }
        AppMethodBeat.o(92875);
    }

    private void KZ() {
        AppMethodBeat.i(92876);
        if (this.eoY != null) {
            int mode = this.eoY.getMode();
            boolean isSpeakerphoneOn = this.eoY.isSpeakerphoneOn();
            Object aH = com.tencent.mm.compatible.e.l.Lu().aH(98305);
            Object aH2 = com.tencent.mm.compatible.e.l.Lu().aH(94209);
            if (aH == null) {
                com.tencent.mm.compatible.e.l.Lu().set(98305, Boolean.valueOf(isSpeakerphoneOn));
                ab.d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron ".concat(String.valueOf(isSpeakerphoneOn)));
            }
            if (aH2 == null) {
                com.tencent.mm.compatible.e.l.Lu().set(94209, Integer.valueOf(mode));
                ab.d("MicroMsg.MMAudioManager", "storeAudioConfig inmode ".concat(String.valueOf(mode)));
            }
        }
        AppMethodBeat.o(92876);
    }

    @Deprecated
    public final void La() {
        AppMethodBeat.i(92877);
        if (this.eoY != null) {
            Object aH = com.tencent.mm.compatible.e.l.Lu().aH(98305);
            Object aH2 = com.tencent.mm.compatible.e.l.Lu().aH(94209);
            if (aH != null) {
                ab.d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: ".concat(String.valueOf(aH)));
                setSpeakerphoneOn(((Boolean) aH).booleanValue());
                com.tencent.mm.compatible.e.l.Lu().set(98305, null);
            }
            if (aH2 != null) {
                int i;
                try {
                    ab.i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + aH2 + ",inmode:0");
                    i = bo.getInt(String.valueOf(aH2), 0);
                } catch (Exception e) {
                    i = 0;
                }
                if (i < -1 || i >= 4) {
                    setMode(0);
                } else {
                    setMode(i);
                }
                com.tencent.mm.compatible.e.l.Lu().set(94209, null);
            }
        }
        AppMethodBeat.o(92877);
    }

    public final void setMode(int i) {
        AppMethodBeat.i(92878);
        if (this.eoY != null) {
            ab.i("MicroMsg.MMAudioManager", "set mode from %d to %d", Integer.valueOf(this.eoY.getMode()), Integer.valueOf(i));
            this.eoY.setMode(i);
        }
        AppMethodBeat.o(92878);
    }

    public final void setSpeakerphoneOn(boolean z) {
        AppMethodBeat.i(92879);
        ab.c("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: ".concat(String.valueOf(z)), new Object[0]);
        if (this.eoY != null) {
            ab.i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: ".concat(String.valueOf(z)));
            try {
                this.eoY.setSpeakerphoneOn(z);
                AppMethodBeat.o(92879);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(92879);
    }

    public final int Lb() {
        int i = this.epf;
        this.epf = 0;
        return i;
    }

    public final int getStreamMaxVolume(int i) {
        AppMethodBeat.i(92880);
        if (this.eoY != null) {
            int streamMaxVolume = this.eoY.getStreamMaxVolume(i);
            AppMethodBeat.o(92880);
            return streamMaxVolume;
        }
        AppMethodBeat.o(92880);
        return 5;
    }

    public final int getStreamVolume(int i) {
        AppMethodBeat.i(92881);
        if (this.eoY != null) {
            int streamVolume = this.eoY.getStreamVolume(i);
            AppMethodBeat.o(92881);
            return streamVolume;
        }
        AppMethodBeat.o(92881);
        return -1;
    }

    public final void bR(int i, int i2) {
        AppMethodBeat.i(92882);
        if (this.eoY != null) {
            ab.i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            a.b(this.eoY, i, i2);
        }
        AppMethodBeat.o(92882);
    }

    public final int Lc() {
        AppMethodBeat.i(92883);
        if (this.epl == -1) {
            try {
                Field field = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
                if (!(field == null || this.eoY == null)) {
                    this.epl = field.getInt(this.eoY);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + e.getMessage());
                this.epl = 6;
            }
        }
        int i = this.epl;
        AppMethodBeat.o(92883);
        return i;
    }

    public static void iL(int i) {
        AppMethodBeat.i(92884);
        epm++;
        ab.e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(epm), Integer.valueOf(epn));
        epo.put(Integer.valueOf(i), bo.dpG().toString());
        Ld();
        AppMethodBeat.o(92884);
    }

    public static void iM(int i) {
        AppMethodBeat.i(92885);
        epn++;
        ab.e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(epm), Integer.valueOf(epn));
        epo.remove(Integer.valueOf(i));
        AppMethodBeat.o(92885);
    }

    public static void iN(int i) {
        AppMethodBeat.i(92886);
        epp++;
        ab.c("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(epp), Integer.valueOf(epq));
        epr.put(Integer.valueOf(i), bo.dpG().toString());
        Ld();
        AppMethodBeat.o(92886);
    }

    public static void iO(int i) {
        AppMethodBeat.i(92887);
        if (epr.containsKey(Integer.valueOf(i))) {
            epq++;
            ab.c("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(epp), Integer.valueOf(epq));
            epr.remove(Integer.valueOf(i));
        }
        AppMethodBeat.o(92887);
    }

    public static void iP(int i) {
        AppMethodBeat.i(92888);
        eps++;
        ab.e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(eps), Integer.valueOf(ept));
        epu.put(Integer.valueOf(i), bo.dpG().toString());
        Ld();
        AppMethodBeat.o(92888);
    }

    public static void iQ(int i) {
        AppMethodBeat.i(92889);
        ept++;
        ab.e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(eps), Integer.valueOf(ept));
        epu.remove(Integer.valueOf(i));
        AppMethodBeat.o(92889);
    }

    private static void Ld() {
        AppMethodBeat.i(92890);
        jw jwVar = new jw();
        if (epm - epn > 1) {
            jwVar.cFd.cFe = true;
            jwVar.cFd.cFf = epo.size();
        }
        if (eps - ept > 1) {
            jwVar.cFd.cFg = true;
            jwVar.cFd.cFh = epu.size();
        }
        if (epp - epq > 1) {
            jwVar.cFd.cFi = true;
            jwVar.cFd.cFj = epr.size();
        }
        if (jwVar.cFd.cFg || jwVar.cFd.cFe || jwVar.cFd.cFi) {
            ab.e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", Boolean.valueOf(jwVar.cFd.cFe), Integer.valueOf(jwVar.cFd.cFf), Boolean.valueOf(jwVar.cFd.cFg), Integer.valueOf(jwVar.cFd.cFh), Boolean.valueOf(jwVar.cFd.cFi), Integer.valueOf(jwVar.cFd.cFj));
            com.tencent.mm.sdk.b.a.xxA.m(jwVar);
        }
        AppMethodBeat.o(92890);
    }

    public static String Le() {
        AppMethodBeat.i(92891);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AudioTrack: \r\n");
        stringBuffer.append("leak: ").append(epo.size()).append("init: ").append(epm).append("release: ").append(epn).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("--------leak map-----------\r\n");
        if (!epo.isEmpty()) {
            for (String append : epo.values()) {
                stringBuffer.append(append).append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        stringBuffer.append("MediaPlayer: \r\n");
        stringBuffer.append("leak: ").append(epu.size()).append("init: ").append(eps).append("release: ").append(ept).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("--------leak map-----------\r\n");
        if (!epu.isEmpty()) {
            for (String append2 : epu.values()) {
                stringBuffer.append(append2).append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        stringBuffer.append("AudioRecord: \r\n");
        stringBuffer.append("leak: ").append(epr.size()).append("init: ").append(epp).append("release: ").append(epp).append(IOUtils.LINE_SEPARATOR_WINDOWS);
        stringBuffer.append("--------leak map-----------\r\n");
        if (!epr.isEmpty()) {
            for (String append22 : epr.values()) {
                stringBuffer.append(append22).append(IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        ab.e("MicroMsg.MMAudioManager", "leak? %s", stringBuffer.toString());
        AppMethodBeat.o(92891);
        return stringBuffer.toString();
    }
}
