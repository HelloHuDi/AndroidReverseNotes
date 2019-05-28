package com.tencent.p177mm.compatible.p219b;

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
import com.p802jg.EType;
import com.p802jg.JgMethodChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p220c.C1411a;
import com.tencent.p177mm.compatible.p221e.C1420l;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1450l;
import com.tencent.p177mm.p230g.p231a.C6502jw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5031ax;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.baseutils.IOUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.compatible.b.g */
public class C1407g {
    private static volatile C1407g eoX = null;
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
    private final Set<C1406a> epg = new HashSet();
    private final int eph = 1000;
    private C7306ak epi = new C140811();
    private C7306ak epj = new C14092();
    private C7306ak epk = new C14103();
    private int epl = -1;

    /* renamed from: com.tencent.mm.compatible.b.g$10 */
    class C139810 extends BroadcastReceiver {
        C139810() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92850);
            if (intent == null) {
                AppMethodBeat.m2505o(92850);
                return;
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                C4990ab.m7416i("MicroMsg.MMAudioManager", "device is unavailable");
                AppMethodBeat.m2505o(92850);
                return;
            }
            C1407g.this.epa = bluetoothDevice.getAddress();
            C1407g.this.epk.removeMessages(0);
            C1407g.this.epj.sendEmptyMessageDelayed(0, 1000);
            C4990ab.m7416i("MicroMsg.MMAudioManager", "android pie switch bt device");
            AppMethodBeat.m2505o(92850);
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$1 */
    class C13991 extends BroadcastReceiver {
        C13991() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92841);
            C4990ab.m7416i("MicroMsg.MMAudioManager", "leonl onReceive action[ ACTION_AUDIO_BECOMING_NOISY ] ");
            C1407g.this.mo4837iI(7);
            AppMethodBeat.m2505o(92841);
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$4 */
    class C14004 extends BroadcastReceiver {
        C14004() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92844);
            int intExtra = intent.getIntExtra("state", -1);
            int intExtra2 = intent.getIntExtra("microphone", -1);
            C4990ab.m7417i("MicroMsg.MMAudioManager", "leonl onReceive action[ HEADSET_PLUG ] state = %s,mic = %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
            if (intExtra == 0) {
                C1407g.this.mo4837iI(6);
                AppMethodBeat.m2505o(92844);
                return;
            }
            if (intExtra == 1) {
                C1407g.this.mo4818KN();
            }
            AppMethodBeat.m2505o(92844);
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$5 */
    class C14015 extends BroadcastReceiver {
        C14015() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92845);
            if (intent == null) {
                AppMethodBeat.m2505o(92845);
                return;
            }
            String action = intent.getAction();
            C1407g.epd = intent.getBooleanExtra("existing", false);
            C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] existing:" + C1407g.epd);
            AppMethodBeat.m2505o(92845);
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$6 */
    class C14026 extends BroadcastReceiver {
        C14026() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92846);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                C4990ab.m7416i("MicroMsg.MMAudioManager", "device is unavailable");
                AppMethodBeat.m2505o(92846);
            } else if (C1407g.this.epa == null) {
                C1407g.this.epa = bluetoothDevice.getAddress();
                AppMethodBeat.m2505o(92846);
            } else {
                if (C1407g.this.epa.equals(bluetoothDevice.getAddress())) {
                    C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_CONNECTED ] ");
                    if (C1443d.m3067fP(11)) {
                        C1407g.epb = true;
                        C1407g.this.epi.sendEmptyMessageDelayed(0, 1000);
                    }
                }
                AppMethodBeat.m2505o(92846);
            }
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$7 */
    class C14037 extends BroadcastReceiver {
        C14037() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92847);
            C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt onReceive action[ BluetoothDevice.ACTION_ACL_DISCONNECTED ] ");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                C4990ab.m7416i("MicroMsg.MMAudioManager", "pre address is null");
                AppMethodBeat.m2505o(92847);
                return;
            }
            if (bluetoothDevice.getAddress().equals(C1407g.this.epa)) {
                C4990ab.m7416i("MicroMsg.MMAudioManager", "pre connect device is " + bluetoothDevice.getAddress());
                C1407g.epb = false;
                C1407g.this.epa = null;
                if (C1427q.etn.erJ == 1) {
                    C1411a.m2991b(C1407g.this.eoY);
                }
                C1407g.this.mo4837iI(4);
            }
            AppMethodBeat.m2505o(92847);
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$8 */
    class C14048 extends BroadcastReceiver {
        C14048() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92848);
            if (intent == null) {
                AppMethodBeat.m2505o(92848);
                return;
            }
            String action = intent.getAction();
            int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                C4990ab.m7416i("MicroMsg.MMAudioManager", "pre address is null");
                AppMethodBeat.m2505o(92848);
            } else if (C1407g.this.epa == null) {
                C1407g.this.epa = bluetoothDevice.getAddress();
                AppMethodBeat.m2505o(92848);
            } else {
                if (bluetoothDevice.getAddress().equals(C1407g.this.epa)) {
                    C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt onReceive action[" + action + "] state:" + intExtra);
                    if (intExtra == 2) {
                        C1407g.epb = true;
                        C1407g.this.epi.sendEmptyMessageDelayed(0, 1000);
                        AppMethodBeat.m2505o(92848);
                        return;
                    } else if (intExtra == 0) {
                        C1407g.epb = false;
                        if (C1427q.etn.erJ == 1) {
                            C1411a.m2991b(C1407g.this.eoY);
                        }
                        C1407g.this.mo4837iI(4);
                        C1407g.this.epa = null;
                    }
                }
                AppMethodBeat.m2505o(92848);
            }
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$9 */
    class C14059 extends BroadcastReceiver {
        C14059() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(92849);
            if (intent == null) {
                AppMethodBeat.m2505o(92849);
                return;
            }
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
            int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null) {
                C4990ab.m7416i("MicroMsg.MMAudioManager", "pre address is null");
                AppMethodBeat.m2505o(92849);
                return;
            }
            if (bluetoothDevice.getAddress().equals(C1407g.this.epa)) {
                C4990ab.m7417i("MicroMsg.MMAudioManager", "onReceive bluetooth state changed: %s, prevState: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                if (intExtra == 10) {
                    C1407g.epb = false;
                    C1407g.epc = false;
                    if (C1427q.etn.erJ == 1) {
                        C1411a.m2991b(C1407g.this.eoY);
                    }
                    C1407g.this.mo4837iI(4);
                }
            }
            AppMethodBeat.m2505o(92849);
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$a */
    public interface C1406a {
        /* renamed from: gE */
        void mo4815gE(int i);
    }

    /* renamed from: com.tencent.mm.compatible.b.g$11 */
    class C140811 extends C7306ak {
        C140811() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(92851);
            C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            C1407g.this.mo4837iI(3);
            AppMethodBeat.m2505o(92851);
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$2 */
    class C14092 extends C7306ak {
        C14092() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(92842);
            C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_ACTIVE ");
            C1407g.this.mo4837iI(5);
            AppMethodBeat.m2505o(92842);
        }
    }

    /* renamed from: com.tencent.mm.compatible.b.g$3 */
    class C14103 extends C7306ak {
        C14103() {
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(92843);
            C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt post delay BLUETOOTH_DEVICE_CONNECTED ");
            C1407g.this.setMode(0);
            AppMethodBeat.m2505o(92843);
        }
    }

    static {
        AppMethodBeat.m2504i(92892);
        AppMethodBeat.m2505o(92892);
    }

    /* renamed from: KK */
    public static C1407g m2946KK() {
        AppMethodBeat.m2504i(92852);
        if (eoX == null) {
            synchronized (C1407g.class) {
                try {
                    if (eoX == null) {
                        eoX = new C1407g(C4996ah.getContext());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(92852);
                    }
                }
            }
        }
        C1407g c1407g = eoX;
        AppMethodBeat.m2505o(92852);
        return c1407g;
    }

    /* renamed from: a */
    public final void mo4828a(C1406a c1406a) {
        AppMethodBeat.m2504i(92853);
        if (c1406a != null) {
            this.epg.add(c1406a);
        }
        AppMethodBeat.m2505o(92853);
    }

    /* renamed from: b */
    public final void mo4829b(C1406a c1406a) {
        AppMethodBeat.m2504i(92854);
        if (c1406a != null) {
            this.epg.remove(c1406a);
        }
        AppMethodBeat.m2505o(92854);
    }

    /* renamed from: iI */
    public final void mo4837iI(int i) {
        AppMethodBeat.m2504i(92855);
        C4990ab.m7417i("MicroMsg.MMAudioManager", "notify, new status: %d, current status: %d", Integer.valueOf(i), Integer.valueOf(this.eoZ));
        for (C1406a gE : this.epg) {
            gE.mo4815gE(i);
        }
        AppMethodBeat.m2505o(92855);
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
    public C1407g(Context context) {
        AppMethodBeat.m2504i(92856);
        this.eoY = (AudioManager) context.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        C4990ab.m7417i("MicroMsg.MMAudioManager", "init dkbt %s", mo4820KT());
        context.registerReceiver(new C13991(), new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
        context.registerReceiver(new C14004(), new IntentFilter("android.intent.action.HEADSET_PLUG"));
        context.registerReceiver(new C14015(), new IntentFilter("com.htc.accessory.action.CONNECTION_EXISTING"));
        context.registerReceiver(new C14026(), new IntentFilter("android.bluetooth.device.action.ACL_CONNECTED"));
        context.registerReceiver(new C14037(), new IntentFilter("android.bluetooth.device.action.ACL_DISCONNECTED"));
        if (C1443d.m3068iW(11)) {
            context.registerReceiver(new C14048(), new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"));
        }
        context.registerReceiver(new C14059(), new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        if (C1443d.m3068iW(28)) {
            context.registerReceiver(new C139810(), new IntentFilter("android.bluetooth.headset.profile.action.ACTIVE_DEVICE_CHANGED"));
        }
        AppMethodBeat.m2505o(92856);
    }

    /* renamed from: KL */
    public final void mo4816KL() {
        AppMethodBeat.m2504i(92857);
        C4990ab.m7417i("MicroMsg.MMAudioManager", "dkbt bluetoothStopped %s", mo4820KT());
        epc = false;
        mo4837iI(2);
        AppMethodBeat.m2505o(92857);
    }

    /* renamed from: KM */
    public final int mo4817KM() {
        AppMethodBeat.m2504i(92858);
        this.eoZ = -1;
        if (C1407g.m2950KS()) {
            C4990ab.m7409c("MicroMsg.MMAudioManager", "dkbt begin tryStartBluetooth %s", mo4820KT());
            C4990ab.m7417i("MicroMsg.MMAudioManager", "dkbt end tryStartBluetooth %s ret:%s", mo4820KT(), Boolean.valueOf(C1411a.m2990a(this.eoY)));
            C4990ab.m7410d("MicroMsg.MMAudioManager", "dkbt  tryStartBluetooth " + mo4820KT() + " ret:" + r0);
            C4990ab.m7417i("MicroMsg.MMAudioManager", "alvinluo isBluetoothOn: %b", Boolean.valueOf(mo4819KP()));
            if (mo4819KP()) {
                AppMethodBeat.m2505o(92858);
                return 1;
            }
            AppMethodBeat.m2505o(92858);
            return 0;
        }
        AppMethodBeat.m2505o(92858);
        return -1;
    }

    /* renamed from: KN */
    public final void mo4818KN() {
        AppMethodBeat.m2504i(92859);
        epc = false;
        C4990ab.m7409c("MicroMsg.MMAudioManager", "dkbt begin stopBluetooth %s", mo4820KT());
        C1411a.m2991b(this.eoY);
        this.epi.removeCallbacksAndMessages(Integer.valueOf(1));
        C4990ab.m7417i("MicroMsg.MMAudioManager", "dkbt end stopBluetooth %s", mo4820KT());
        AppMethodBeat.m2505o(92859);
    }

    /* renamed from: KO */
    public static boolean m2947KO() {
        return false;
    }

    /* renamed from: KP */
    public final boolean mo4819KP() {
        AppMethodBeat.m2504i(92860);
        C4990ab.m7417i("MicroMsg.MMAudioManager", "isBluetoothScoOn: %s isBluetoothA2dpOn: %s, isScoConnected: %s, isBluetoothCanUse: %s, isACLConnected: %s", Boolean.valueOf(this.eoY.isBluetoothScoOn()), Boolean.valueOf(this.eoY.isBluetoothA2dpOn()), Boolean.valueOf(epc), Boolean.valueOf(C1407g.m2950KS()), Boolean.valueOf(epb));
        if (this.eoY.isBluetoothScoOn() || r3 || epc) {
            AppMethodBeat.m2505o(92860);
            return true;
        }
        AppMethodBeat.m2505o(92860);
        return false;
    }

    @TargetApi(14)
    /* renamed from: KQ */
    private static boolean m2948KQ() {
        AppMethodBeat.m2504i(92861);
        try {
            if (VERSION.SDK_INT >= 14) {
                C4990ab.m7417i("MicroMsg.MMAudioManager", "isConnectHeadset getProfileConnectionState: %s", Integer.valueOf(BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1)));
                if (BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                    AppMethodBeat.m2505o(92861);
                    return true;
                }
                AppMethodBeat.m2505o(92861);
                return false;
            } else if (epb) {
                AppMethodBeat.m2505o(92861);
                return true;
            } else {
                if (C1427q.etn.erU == 1) {
                    boolean isEnabled = BluetoothAdapter.getDefaultAdapter().isEnabled();
                    AppMethodBeat.m2505o(92861);
                    return isEnabled;
                }
                AppMethodBeat.m2505o(92861);
                return false;
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.MMAudioManager", "dkbt exception in isConnectDevice()");
        }
    }

    /* renamed from: bE */
    public final int mo4831bE(boolean z) {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(92862);
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        if (!mo4819KP()) {
            i2 = i;
        }
        AppMethodBeat.m2505o(92862);
        return i2;
    }

    /* renamed from: KR */
    public static int m2949KR() {
        AppMethodBeat.m2504i(92863);
        ((AudioManager) C4996ah.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE)).isBluetoothScoOn();
        AppMethodBeat.m2505o(92863);
        return 0;
    }

    /* renamed from: KS */
    public static boolean m2950KS() {
        AppMethodBeat.m2504i(92864);
        C4990ab.m7410d("MicroMsg.MMAudioManager", "dkbt isBluetoothCanUse existing:" + epd + " , isUseHTCAccessory = " + epe);
        if (!epd || epe) {
            C4990ab.m7410d("MicroMsg.MMAudioManager", "dkbt isACLConnected:" + epb);
            boolean KQ = C1407g.m2948KQ();
            if (KQ) {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter == null) {
                    C4990ab.m7410d("MicroMsg.MMAudioManager", "dkbt BluetoothAdapter.getDefaultAdapter() == null");
                    AppMethodBeat.m2505o(92864);
                    return false;
                } else if (defaultAdapter.isEnabled()) {
                    Set<BluetoothDevice> bondedDevices = defaultAdapter.getBondedDevices();
                    if (bondedDevices == null || bondedDevices.size() == 0) {
                        C4990ab.m7412e("MicroMsg.MMAudioManager", "dkbt setDev == null || setDev.size() == 0");
                        AppMethodBeat.m2505o(92864);
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
                        C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt hasBond == false");
                        AppMethodBeat.m2505o(92864);
                        return false;
                    }
                    C4990ab.m7417i("MicroMsg.MMAudioManager", "alvinluo isBluetoothCanUse: %b", Boolean.TRUE);
                    AppMethodBeat.m2505o(92864);
                    return true;
                } else {
                    C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt !adp.isEnabled()");
                    AppMethodBeat.m2505o(92864);
                    return false;
                }
            }
            C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt isACLConnected =  " + epb + " , isConnectHeadset() = " + KQ);
            AppMethodBeat.m2505o(92864);
            return false;
        }
        AppMethodBeat.m2505o(92864);
        return false;
    }

    /* renamed from: KT */
    public final String mo4820KT() {
        AppMethodBeat.m2504i(92865);
        String str = "mode:" + (this.eoY != null ? this.eoY.getMode() : 0) + " isSpeakerphoneOn:" + this.eoY.isSpeakerphoneOn() + " isBluetoothOn:" + mo4819KP() + " btStatus:" + this.eoZ;
        AppMethodBeat.m2505o(92865);
        return str;
    }

    /* renamed from: KU */
    public final boolean mo4821KU() {
        AppMethodBeat.m2504i(92866);
        if (this.eoY.getMode() == 0) {
            AppMethodBeat.m2505o(92866);
            return true;
        }
        AppMethodBeat.m2505o(92866);
        return false;
    }

    @TargetApi(11)
    /* renamed from: f */
    public final boolean mo4834f(boolean z, boolean z2, boolean z3) {
        int i = 0;
        AppMethodBeat.m2504i(92867);
        int mode = this.eoY.getMode();
        C4990ab.m7417i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(mo4821KU()), Boolean.valueOf(z), mo4820KT());
        if (C5031ax.m7487Ex()) {
            C4990ab.m7419v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling Mode:%d blue:%d", Integer.valueOf(mode), Integer.valueOf(this.eoZ));
            AppMethodBeat.m2505o(92867);
            return false;
        } else if (z3 || !(mo4819KP() || epc)) {
            m2952KZ();
            if (z2) {
                if (C1427q.etd.epG) {
                    if (C1427q.etd.mo4849Lg()) {
                        if (C1427q.etd.epI >= 0) {
                            setMode(C1427q.etd.epI);
                        } else if (C1427q.etd.epJ >= 0) {
                            if (z) {
                                setMode(0);
                            } else {
                                setMode(2);
                            }
                        }
                        if (C1427q.etd.epK > 0) {
                            setSpeakerphoneOn(z);
                        }
                        AppMethodBeat.m2505o(92867);
                        return z;
                    } else if (C1427q.etd.mo4850Lh()) {
                        if (z) {
                            if (C1427q.etd.mo4853Lk()) {
                                setSpeakerphoneOn(true);
                            }
                            if (C1427q.etd.mo4852Lj() >= 0) {
                                setMode(C1427q.etd.mo4852Lj());
                            }
                        } else {
                            if (C1427q.etd.mo4855Lm()) {
                                setSpeakerphoneOn(false);
                            }
                            if (C1427q.etd.mo4854Ll() >= 0) {
                                setMode(C1427q.etd.mo4854Ll());
                            }
                        }
                        AppMethodBeat.m2505o(92867);
                        return z;
                    }
                }
            } else if (C1427q.etd.epG && C1427q.etd.mo4851Li()) {
                if (z) {
                    if (C1427q.etd.mo4857Lo()) {
                        setSpeakerphoneOn(true);
                    }
                    if (C1427q.etd.mo4856Ln() >= 0) {
                        setMode(C1427q.etd.mo4856Ln());
                    }
                } else {
                    if (C1427q.etd.mo4859Lq()) {
                        setSpeakerphoneOn(false);
                    }
                    if (C1427q.etd.mo4858Lp() >= 0) {
                        setMode(C1427q.etd.mo4858Lp());
                    }
                }
                AppMethodBeat.m2505o(92867);
                return z;
            }
            if (!z2) {
                setSpeakerphoneOn(z);
                if (mo4821KU() != z) {
                    if (z) {
                        setMode(0);
                    } else if (VERSION.SDK_INT >= 11 && C1450l.m3082IN() && 2 != C1427q.etn.erV) {
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
                if (C1427q.etd.eqg >= 0) {
                    i = C1427q.etd.eqg;
                }
                C4990ab.m7410d("MicroMsg.MMAudioManager", "voip doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i)));
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
                } else if (C1427q.etn.erU == 1) {
                    C4990ab.m7410d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                    mode = 0;
                } else {
                    mode = 2;
                }
                if (VERSION.SDK_INT >= 11 && C1450l.m3082IN() && 2 == C1427q.etn.erV) {
                    mode = 2;
                }
                if (C1427q.etd.eqh >= 0) {
                    mode = C1427q.etd.eqh;
                }
                C4990ab.m7410d("MicroMsg.MMAudioManager", "voip doShiftSpeaker usePhoneMode:".concat(String.valueOf(mode)));
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
            AppMethodBeat.m2505o(92867);
            return z;
        } else {
            C4990ab.m7416i("MicroMsg.MMAudioManager", "dkbt shiftSpeaker isBluetoothOn");
            if (z2) {
                C4990ab.m7410d("MicroMsg.MMAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
                setMode(3);
            } else {
                setMode(0);
            }
            AppMethodBeat.m2505o(92867);
            return false;
        }
    }

    @TargetApi(11)
    /* renamed from: bF */
    public final boolean mo4832bF(boolean z) {
        int i = 3;
        int i2 = 0;
        AppMethodBeat.m2504i(92868);
        C4990ab.m7411d("MicroMsg.MMAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b  %s", Boolean.valueOf(mo4821KU()), Boolean.valueOf(z), mo4820KT());
        if (C5031ax.m7487Ex()) {
            C4990ab.m7419v("MicroMsg.MMAudioManager", "shiftSpeaker return when calling blue:%d", Integer.valueOf(this.eoZ));
            AppMethodBeat.m2505o(92868);
            return false;
        } else if (epc) {
            setMode(3);
            AppMethodBeat.m2505o(92868);
            return false;
        } else {
            m2952KZ();
            if (C1427q.etd.eqF) {
                if (z) {
                    if (VERSION.SDK_INT >= 11) {
                        i2 = 3;
                    }
                    if (C1427q.etd.eqG >= 0) {
                        i2 = C1427q.etd.eqG;
                    }
                    C4990ab.m7410d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i2)));
                    if (i2 != this.eoY.getMode()) {
                        setMode(i2);
                    }
                    if (!this.eoY.isSpeakerphoneOn()) {
                        setSpeakerphoneOn(true);
                    }
                } else {
                    if (VERSION.SDK_INT < 11) {
                        if (C1427q.etn.erU == 1) {
                            C4990ab.m7410d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                            i = 0;
                        } else {
                            i = 2;
                        }
                    }
                    if (C1427q.etd.eqH >= 0) {
                        i = C1427q.etd.eqH;
                    }
                    C4990ab.m7410d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
                    if (i != this.eoY.getMode()) {
                        setMode(i);
                    }
                    if (this.eoY.isSpeakerphoneOn()) {
                        setSpeakerphoneOn(false);
                    }
                }
                AppMethodBeat.m2505o(92868);
                return z;
            }
            if (C1427q.etd.epG) {
                if (C1427q.etd.mo4849Lg()) {
                    if (C1427q.etd.epI >= 0) {
                        setMode(C1427q.etd.epI);
                    } else if (C1427q.etd.epJ >= 0) {
                        if (z) {
                            setMode(0);
                        } else {
                            setMode(2);
                        }
                    }
                    if (C1427q.etd.epK > 0) {
                        setSpeakerphoneOn(z);
                    }
                    AppMethodBeat.m2505o(92868);
                    return z;
                } else if (C1427q.etd.mo4850Lh()) {
                    if (z) {
                        if (C1427q.etd.mo4853Lk()) {
                            setSpeakerphoneOn(true);
                        }
                        if (C1427q.etd.mo4852Lj() >= 0) {
                            setMode(C1427q.etd.mo4852Lj());
                        }
                    } else {
                        if (C1427q.etd.mo4855Lm()) {
                            setSpeakerphoneOn(false);
                        }
                        if (C1427q.etd.mo4854Ll() >= 0) {
                            setMode(C1427q.etd.mo4854Ll());
                        }
                    }
                    AppMethodBeat.m2505o(92868);
                    return z;
                }
            }
            if (z) {
                if (VERSION.SDK_INT >= 11) {
                    i2 = 3;
                }
                if (C1427q.etd.eqg >= 0) {
                    i2 = C1427q.etd.eqg;
                }
                C4990ab.m7410d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i2)));
                if (i2 != this.eoY.getMode()) {
                    setMode(i2);
                }
                if (!this.eoY.isSpeakerphoneOn()) {
                    setSpeakerphoneOn(true);
                }
            } else {
                if (VERSION.SDK_INT < 11) {
                    if (C1427q.etn.erU == 1) {
                        C4990ab.m7410d("MicroMsg.MMAudioManager", "doShiftSpeaker htc usePhoneMode : 0");
                        i = 0;
                    } else {
                        i = 2;
                    }
                }
                if (VERSION.SDK_INT >= 11 && C1450l.m3082IN() && 2 == C1427q.etn.erV) {
                    i = 2;
                }
                if (C1427q.etd.eqh >= 0) {
                    i = C1427q.etd.eqh;
                }
                C4990ab.m7410d("MicroMsg.MMAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i)));
                if (i != this.eoY.getMode()) {
                    setMode(i);
                }
                if (this.eoY.isSpeakerphoneOn()) {
                    setSpeakerphoneOn(false);
                }
            }
            AppMethodBeat.m2505o(92868);
            return z;
        }
    }

    /* renamed from: b */
    public final boolean mo4830b(boolean z, int i, boolean z2) {
        AppMethodBeat.m2504i(92869);
        int streamMaxVolume = this.eoY.getStreamMaxVolume(i);
        C4990ab.m7410d("MicroMsg.MMAudioManager", "maxVolumn:".concat(String.valueOf(streamMaxVolume)));
        streamMaxVolume /= 3;
        int streamVolume = this.eoY.getStreamVolume(i);
        if (streamVolume < streamMaxVolume) {
            C1397a.m2944b(this.eoY, i, streamMaxVolume);
        }
        C4990ab.m7416i("MicroMsg.MMAudioManager", "StreamType:" + i + "  current:" + streamVolume);
        boolean f = mo4834f(z, true, z2);
        AppMethodBeat.m2505o(92869);
        return f;
    }

    /* renamed from: KV */
    public final boolean mo4822KV() {
        AppMethodBeat.m2504i(92870);
        if (this.eoY != null) {
            boolean isWiredHeadsetOn = this.eoY.isWiredHeadsetOn();
            if (!isWiredHeadsetOn && C1443d.m3068iW(23)) {
                isWiredHeadsetOn = m2951KW();
            }
            AppMethodBeat.m2505o(92870);
            return isWiredHeadsetOn;
        }
        AppMethodBeat.m2505o(92870);
        return false;
    }

    /* renamed from: KW */
    private boolean m2951KW() {
        AppMethodBeat.m2504i(92871);
        if (this.eoY != null && C1443d.m3068iW(23)) {
            for (AudioDeviceInfo audioDeviceInfo : this.eoY.getDevices(3)) {
                C4990ab.m7417i("MicroMsg.MMAudioManager", "isWireHeadsetPluggedNew, deviceInfo type: %s", Integer.valueOf(audioDeviceInfo.getType()));
                if (audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 11) {
                    AppMethodBeat.m2505o(92871);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(92871);
        return false;
    }

    /* renamed from: iJ */
    public final void mo4838iJ(int i) {
        AppMethodBeat.m2504i(92872);
        if (this.eoY != null) {
            C1397a.m2943a(this.eoY, i, 1);
        }
        AppMethodBeat.m2505o(92872);
    }

    /* renamed from: iK */
    public final void mo4839iK(int i) {
        AppMethodBeat.m2504i(92873);
        if (this.eoY != null) {
            C1397a.m2943a(this.eoY, i, -1);
        }
        AppMethodBeat.m2505o(92873);
    }

    /* renamed from: KX */
    public final void mo4823KX() {
        AppMethodBeat.m2504i(92874);
        if (this.eoY != null) {
            this.eoY.setStreamMute(3, true);
        }
        AppMethodBeat.m2505o(92874);
    }

    /* renamed from: KY */
    public final void mo4824KY() {
        AppMethodBeat.m2504i(92875);
        if (this.eoY != null) {
            this.eoY.setStreamMute(3, false);
        }
        AppMethodBeat.m2505o(92875);
    }

    /* renamed from: KZ */
    private void m2952KZ() {
        AppMethodBeat.m2504i(92876);
        if (this.eoY != null) {
            int mode = this.eoY.getMode();
            boolean isSpeakerphoneOn = this.eoY.isSpeakerphoneOn();
            Object aH = C1420l.m3008Lu().mo4866aH(98305);
            Object aH2 = C1420l.m3008Lu().mo4866aH(94209);
            if (aH == null) {
                C1420l.m3008Lu().set(98305, Boolean.valueOf(isSpeakerphoneOn));
                C4990ab.m7410d("MicroMsg.MMAudioManager", "storeAudioConfig spearkeron ".concat(String.valueOf(isSpeakerphoneOn)));
            }
            if (aH2 == null) {
                C1420l.m3008Lu().set(94209, Integer.valueOf(mode));
                C4990ab.m7410d("MicroMsg.MMAudioManager", "storeAudioConfig inmode ".concat(String.valueOf(mode)));
            }
        }
        AppMethodBeat.m2505o(92876);
    }

    @Deprecated
    /* renamed from: La */
    public final void mo4825La() {
        AppMethodBeat.m2504i(92877);
        if (this.eoY != null) {
            Object aH = C1420l.m3008Lu().mo4866aH(98305);
            Object aH2 = C1420l.m3008Lu().mo4866aH(94209);
            if (aH != null) {
                C4990ab.m7410d("MicroMsg.MMAudioManager", "resumeAudioConfig spearkeron: ".concat(String.valueOf(aH)));
                setSpeakerphoneOn(((Boolean) aH).booleanValue());
                C1420l.m3008Lu().set(98305, null);
            }
            if (aH2 != null) {
                int i;
                try {
                    C4990ab.m7416i("MicroMsg.MMAudioManager", "resumeAudioConfig oinmode: " + aH2 + ",inmode:0");
                    i = C5046bo.getInt(String.valueOf(aH2), 0);
                } catch (Exception e) {
                    i = 0;
                }
                if (i < -1 || i >= 4) {
                    setMode(0);
                } else {
                    setMode(i);
                }
                C1420l.m3008Lu().set(94209, null);
            }
        }
        AppMethodBeat.m2505o(92877);
    }

    public final void setMode(int i) {
        AppMethodBeat.m2504i(92878);
        if (this.eoY != null) {
            C4990ab.m7417i("MicroMsg.MMAudioManager", "set mode from %d to %d", Integer.valueOf(this.eoY.getMode()), Integer.valueOf(i));
            this.eoY.setMode(i);
        }
        AppMethodBeat.m2505o(92878);
    }

    public final void setSpeakerphoneOn(boolean z) {
        AppMethodBeat.m2504i(92879);
        C4990ab.m7409c("MicroMsg.MMAudioManager", "setSpeakerphoneOn, on: ".concat(String.valueOf(z)), new Object[0]);
        if (this.eoY != null) {
            C4990ab.m7416i("MicroMsg.MMAudioManager", "setSpeakerphoneOn on: ".concat(String.valueOf(z)));
            try {
                this.eoY.setSpeakerphoneOn(z);
                AppMethodBeat.m2505o(92879);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(92879);
    }

    /* renamed from: Lb */
    public final int mo4826Lb() {
        int i = this.epf;
        this.epf = 0;
        return i;
    }

    public final int getStreamMaxVolume(int i) {
        AppMethodBeat.m2504i(92880);
        if (this.eoY != null) {
            int streamMaxVolume = this.eoY.getStreamMaxVolume(i);
            AppMethodBeat.m2505o(92880);
            return streamMaxVolume;
        }
        AppMethodBeat.m2505o(92880);
        return 5;
    }

    public final int getStreamVolume(int i) {
        AppMethodBeat.m2504i(92881);
        if (this.eoY != null) {
            int streamVolume = this.eoY.getStreamVolume(i);
            AppMethodBeat.m2505o(92881);
            return streamVolume;
        }
        AppMethodBeat.m2505o(92881);
        return -1;
    }

    /* renamed from: bR */
    public final void mo4833bR(int i, int i2) {
        AppMethodBeat.m2504i(92882);
        if (this.eoY != null) {
            C4990ab.m7417i("MicroMsg.MMAudioManager", "setStreamVolume streamType:%s,index:%s,flags:%s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            C1397a.m2944b(this.eoY, i, i2);
        }
        AppMethodBeat.m2505o(92882);
    }

    /* renamed from: Lc */
    public final int mo4827Lc() {
        AppMethodBeat.m2504i(92883);
        if (this.epl == -1) {
            try {
                Field field = Class.forName("android.media.AudioManager").getField("STREAM_BLUETOOTH_SCO");
                if (!(field == null || this.eoY == null)) {
                    this.epl = field.getInt(this.eoY);
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.MMAudioManager", "ClassNotFoundException  android.media.AudioManager,exception:" + e.getMessage());
                this.epl = 6;
            }
        }
        int i = this.epl;
        AppMethodBeat.m2505o(92883);
        return i;
    }

    /* renamed from: iL */
    public static void m2962iL(int i) {
        AppMethodBeat.m2504i(92884);
        epm++;
        C4990ab.m7413e("MicroMsg.MMAudioManager", "mm audio track init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(epm), Integer.valueOf(epn));
        epo.put(Integer.valueOf(i), C5046bo.dpG().toString());
        C1407g.m2953Ld();
        AppMethodBeat.m2505o(92884);
    }

    /* renamed from: iM */
    public static void m2963iM(int i) {
        AppMethodBeat.m2504i(92885);
        epn++;
        C4990ab.m7413e("MicroMsg.MMAudioManager", "mm audio track release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(epm), Integer.valueOf(epn));
        epo.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(92885);
    }

    /* renamed from: iN */
    public static void m2964iN(int i) {
        AppMethodBeat.m2504i(92886);
        epp++;
        C4990ab.m7409c("MicroMsg.MMAudioManager", "mm audio record init [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(epp), Integer.valueOf(epq));
        epr.put(Integer.valueOf(i), C5046bo.dpG().toString());
        C1407g.m2953Ld();
        AppMethodBeat.m2505o(92886);
    }

    /* renamed from: iO */
    public static void m2965iO(int i) {
        AppMethodBeat.m2504i(92887);
        if (epr.containsKey(Integer.valueOf(i))) {
            epq++;
            C4990ab.m7409c("MicroMsg.MMAudioManager", "mm audio record release [%d] mmInitCount[%d] mmReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(epp), Integer.valueOf(epq));
            epr.remove(Integer.valueOf(i));
        }
        AppMethodBeat.m2505o(92887);
    }

    /* renamed from: iP */
    public static void m2966iP(int i) {
        AppMethodBeat.m2504i(92888);
        eps++;
        C4990ab.m7413e("MicroMsg.MMAudioManager", "mm media player init [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(eps), Integer.valueOf(ept));
        epu.put(Integer.valueOf(i), C5046bo.dpG().toString());
        C1407g.m2953Ld();
        AppMethodBeat.m2505o(92888);
    }

    /* renamed from: iQ */
    public static void m2967iQ(int i) {
        AppMethodBeat.m2504i(92889);
        ept++;
        C4990ab.m7413e("MicroMsg.MMAudioManager", "mm media player release [%d] mmMpInitCount[%d] mmMpReleaseCount[%d]", Integer.valueOf(i), Integer.valueOf(eps), Integer.valueOf(ept));
        epu.remove(Integer.valueOf(i));
        AppMethodBeat.m2505o(92889);
    }

    /* renamed from: Ld */
    private static void m2953Ld() {
        AppMethodBeat.m2504i(92890);
        C6502jw c6502jw = new C6502jw();
        if (epm - epn > 1) {
            c6502jw.cFd.cFe = true;
            c6502jw.cFd.cFf = epo.size();
        }
        if (eps - ept > 1) {
            c6502jw.cFd.cFg = true;
            c6502jw.cFd.cFh = epu.size();
        }
        if (epp - epq > 1) {
            c6502jw.cFd.cFi = true;
            c6502jw.cFd.cFj = epr.size();
        }
        if (c6502jw.cFd.cFg || c6502jw.cFd.cFe || c6502jw.cFd.cFi) {
            C4990ab.m7413e("MicroMsg.MMAudioManager", "check media leak audio[%b %d] mediaplayer[%b %d] audioRecordLeak [%b %d]", Boolean.valueOf(c6502jw.cFd.cFe), Integer.valueOf(c6502jw.cFd.cFf), Boolean.valueOf(c6502jw.cFd.cFg), Integer.valueOf(c6502jw.cFd.cFh), Boolean.valueOf(c6502jw.cFd.cFi), Integer.valueOf(c6502jw.cFd.cFj));
            C4879a.xxA.mo10055m(c6502jw);
        }
        AppMethodBeat.m2505o(92890);
    }

    /* renamed from: Le */
    public static String m2954Le() {
        AppMethodBeat.m2504i(92891);
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
        C4990ab.m7413e("MicroMsg.MMAudioManager", "leak? %s", stringBuffer.toString());
        AppMethodBeat.m2505o(92891);
        return stringBuffer.toString();
    }
}
