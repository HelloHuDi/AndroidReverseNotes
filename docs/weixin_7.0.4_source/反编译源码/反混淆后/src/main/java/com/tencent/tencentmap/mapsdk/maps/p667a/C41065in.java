package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C5841cp;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.in */
public class C41065in extends Handler {
    /* renamed from: a */
    private final C31061iz f16513a;

    public C41065in(C31061iz c31061iz) {
        this.f16513a = c31061iz;
    }

    public void handleMessage(Message message) {
        AppMethodBeat.m2504i(99860);
        super.handleMessage(message);
        if (this.f16513a == null) {
            AppMethodBeat.m2505o(99860);
            return;
        }
        C5841cp p = this.f16513a.mo50479p();
        if (p == null) {
            AppMethodBeat.m2505o(99860);
            return;
        }
        if (this.f16513a.f14282q == null) {
            if (message.what == 0) {
                this.f16513a.f14196J = false;
                this.f16513a.f14197K = true;
                this.f16513a.onCameraChange(p);
            } else if (message.what == 1) {
                this.f16513a.f14196J = true;
                if (this.f16513a.f14196J && this.f16513a.f14198L == 0) {
                    this.f16513a.f14197K = false;
                    this.f16513a.onCameraChangeFinished(p);
                }
                if (this.f16513a.f14276k != null && this.f16513a.f14194H) {
                    this.f16513a.f14276k.mo29184a();
                }
                this.f16513a.mo75386b().mo20143F();
            }
        }
        if (this.f16513a.mo50478o() != null) {
            this.f16513a.mo50478o().mo40745e();
        }
        if (this.f16513a.mo50418K() != null) {
            this.f16513a.mo50418K().mo40702a(this.f16513a.mo50424Q(), this.f16513a.mo75386b().mo20215e());
        }
        AppMethodBeat.m2505o(99860);
    }
}
