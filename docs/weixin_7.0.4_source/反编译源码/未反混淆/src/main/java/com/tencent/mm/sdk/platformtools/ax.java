package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class ax {
    static boolean cQz;
    private TelephonyManager xAM;
    private PhoneStateListener xAN;
    List<a> xAO = new LinkedList();

    public interface a {
        void ih(int i);
    }

    public ax() {
        AppMethodBeat.i(52215);
        AppMethodBeat.o(52215);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(52216);
        this.xAO.add(aVar);
        AppMethodBeat.o(52216);
    }

    public final void dpf() {
        AppMethodBeat.i(52217);
        this.xAO.clear();
        AppMethodBeat.o(52217);
    }

    public static boolean Ex() {
        AppMethodBeat.i(52218);
        ab.i("MicroMsg.PhoneStatusWatcher", "alvinluo isCalling: %b", Boolean.valueOf(cQz));
        boolean z = cQz;
        AppMethodBeat.o(52218);
        return z;
    }

    public final void gK(Context context) {
        AppMethodBeat.i(52219);
        ab.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher begin");
        if (this.xAM == null) {
            this.xAM = (TelephonyManager) context.getSystemService("phone");
        }
        if (this.xAN == null) {
            this.xAN = new PhoneStateListener() {
                public final void onCallStateChanged(int i, String str) {
                    AppMethodBeat.i(52214);
                    ab.i("MicroMsg.PhoneStatusWatcher", "alvinluo onCallStateChanged state: %d, incomingNumber: %s", Integer.valueOf(i), str);
                    if (ax.this.xAO.size() > 0) {
                        for (a ih : (a[]) ax.this.xAO.toArray(new a[ax.this.xAO.size()])) {
                            ih.ih(i);
                        }
                    }
                    super.onCallStateChanged(i, str);
                    switch (i) {
                        case 0:
                            ax.cQz = false;
                            AppMethodBeat.o(52214);
                            return;
                        case 1:
                        case 2:
                            ax.cQz = true;
                            break;
                    }
                    AppMethodBeat.o(52214);
                }
            };
        }
        this.xAM.listen(this.xAN, 32);
        AppMethodBeat.o(52219);
    }

    public final void end() {
        AppMethodBeat.i(52220);
        ab.i("MicroMsg.PhoneStatusWatcher", "alvinluo PhoneStatusWatcher end");
        if (this.xAM != null) {
            this.xAM.listen(this.xAN, 0);
            this.xAN = null;
        }
        AppMethodBeat.o(52220);
    }
}
