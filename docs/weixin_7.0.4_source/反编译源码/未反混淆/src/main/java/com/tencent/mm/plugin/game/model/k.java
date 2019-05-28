package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.vfs.e;

public final class k {
    public c mVZ;
    public boolean mWa = false;
    public int mode = 1;
    public int progress = 0;
    public int status = 0;

    public k(c cVar) {
        this.mVZ = cVar;
    }

    public final void ei(Context context) {
        AppMethodBeat.i(111271);
        if (this.mVZ == null) {
            AppMethodBeat.o(111271);
            return;
        }
        int i = this.mVZ.dnj;
        int i2 = this.mVZ.dnj;
        ab.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", this.mVZ.field_appId, Integer.valueOf(i));
        if (i == 2) {
            i2 = 3;
        }
        if (i2 == 3 && !g.u(context, "wx3909f6add1206543")) {
            i2 = 1;
        }
        if (i2 != 1) {
            FileDownloadTaskInfo Ir = d.bij().Ir(this.mVZ.field_appId);
            if (Ir.status == 1 || Ir.status == 2 || Ir.status == 3) {
                i2 = 1;
            }
        }
        this.mode = i2;
        ab.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", this.mVZ.field_appId, Integer.valueOf(i2));
        AppMethodBeat.o(111271);
    }

    public final void biT() {
        AppMethodBeat.i(111272);
        if (this.mVZ == null) {
            AppMethodBeat.o(111272);
            return;
        }
        switch (this.mode) {
            case 1:
                FileDownloadTaskInfo Ir = d.bij().Ir(this.mVZ.field_appId);
                if (Ir.jrb != 0) {
                    this.progress = (int) ((((double) Ir.kNr) / ((double) Ir.jrb)) * 100.0d);
                } else {
                    this.progress = 0;
                }
                this.progress = this.progress == 0 ? 1 : this.progress;
                ab.d("MicroMsg.GameDownloadInfo", "status = " + Ir.status);
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
                        if (!e.ct(Ir.path)) {
                            this.status = 0;
                            break;
                        } else {
                            this.status = 3;
                            break;
                        }
                    case 4:
                        if (this.progress != 0 && !at.isConnected(ah.getContext())) {
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
        ab.i("MicroMsg.GameDownloadInfo", "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d", this.mVZ.field_appId, Integer.valueOf(this.mode), Integer.valueOf(this.status));
        AppMethodBeat.o(111272);
    }

    public final void bEj() {
        this.mode = 1;
        this.mWa = true;
    }
}
