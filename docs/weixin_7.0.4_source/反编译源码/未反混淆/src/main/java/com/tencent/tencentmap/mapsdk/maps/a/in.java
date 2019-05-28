package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cp;

public class in extends Handler {
    private final iz a;

    public in(iz izVar) {
        this.a = izVar;
    }

    public void handleMessage(Message message) {
        AppMethodBeat.i(99860);
        super.handleMessage(message);
        if (this.a == null) {
            AppMethodBeat.o(99860);
            return;
        }
        cp p = this.a.p();
        if (p == null) {
            AppMethodBeat.o(99860);
            return;
        }
        if (this.a.q == null) {
            if (message.what == 0) {
                this.a.J = false;
                this.a.K = true;
                this.a.onCameraChange(p);
            } else if (message.what == 1) {
                this.a.J = true;
                if (this.a.J && this.a.L == 0) {
                    this.a.K = false;
                    this.a.onCameraChangeFinished(p);
                }
                if (this.a.k != null && this.a.H) {
                    this.a.k.a();
                }
                this.a.b().F();
            }
        }
        if (this.a.o() != null) {
            this.a.o().e();
        }
        if (this.a.K() != null) {
            this.a.K().a(this.a.Q(), this.a.b().e());
        }
        AppMethodBeat.o(99860);
    }
}
