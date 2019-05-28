package com.tencent.p177mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.game.model.k */
public final class C21003k {
    public C20992c mVZ;
    public boolean mWa = false;
    public int mode = 1;
    public int progress = 0;
    public int status = 0;

    public C21003k(C20992c c20992c) {
        this.mVZ = c20992c;
    }

    /* renamed from: ei */
    public final void mo36321ei(Context context) {
        AppMethodBeat.m2504i(111271);
        if (this.mVZ == null) {
            AppMethodBeat.m2505o(111271);
            return;
        }
        int i = this.mVZ.dnj;
        int i2 = this.mVZ.dnj;
        C4990ab.m7417i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", this.mVZ.field_appId, Integer.valueOf(i));
        if (i == 2) {
            i2 = 3;
        }
        if (i2 == 3 && !C46494g.m87757u(context, "wx3909f6add1206543")) {
            i2 = 1;
        }
        if (i2 != 1) {
            FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(this.mVZ.field_appId);
            if (Ir.status == 1 || Ir.status == 2 || Ir.status == 3) {
                i2 = 1;
            }
        }
        this.mode = i2;
        C4990ab.m7417i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", this.mVZ.field_appId, Integer.valueOf(i2));
        AppMethodBeat.m2505o(111271);
    }

    public final void biT() {
        AppMethodBeat.m2504i(111272);
        if (this.mVZ == null) {
            AppMethodBeat.m2505o(111272);
            return;
        }
        switch (this.mode) {
            case 1:
                FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(this.mVZ.field_appId);
                if (Ir.jrb != 0) {
                    this.progress = (int) ((((double) Ir.kNr) / ((double) Ir.jrb)) * 100.0d);
                } else {
                    this.progress = 0;
                }
                this.progress = this.progress == 0 ? 1 : this.progress;
                C4990ab.m7410d("MicroMsg.GameDownloadInfo", "status = " + Ir.status);
                switch (Ir.status) {
                    case 0:
                        this.status = 0;
                        break;
                    case 1:
                        this.status = 1;
                        break;
                    case 2:
                        this.status = 2;
                        break;
                    case 3:
                        if (!C5730e.m8628ct(Ir.path)) {
                            this.status = 0;
                            break;
                        } else {
                            this.status = 3;
                            break;
                        }
                    case 4:
                        if (this.progress != 0 && !C5023at.isConnected(C4996ah.getContext())) {
                            this.status = 2;
                            break;
                        } else {
                            this.status = 0;
                            break;
                        }
                        break;
                    default:
                        this.status = 0;
                        break;
                }
            default:
                this.status = 0;
                break;
        }
        C4990ab.m7417i("MicroMsg.GameDownloadInfo", "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d", this.mVZ.field_appId, Integer.valueOf(this.mode), Integer.valueOf(this.status));
        AppMethodBeat.m2505o(111272);
    }

    public final void bEj() {
        this.mode = 1;
        this.mWa = true;
    }
}
