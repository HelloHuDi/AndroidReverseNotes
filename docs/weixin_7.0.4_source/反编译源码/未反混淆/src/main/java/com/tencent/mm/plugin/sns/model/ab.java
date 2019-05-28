package com.tencent.mm.plugin.sns.model;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class ab {
    public static boolean nLD = false;
    public static char[] qKm = new char[36];
    private ak handler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(36363);
            super.handleMessage(message);
            if (ab.this.qKl >= 5 || System.currentTimeMillis() - ab.this.qKk > 300000) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ab.this.qKl);
                ab.nLD = false;
                AppMethodBeat.o(36363);
            } else if (ab.this.qKj) {
                AppMethodBeat.o(36363);
            } else {
                if (ab.nLD) {
                    new a().u("");
                }
                AppMethodBeat.o(36363);
            }
        }
    };
    public boolean qKj = false;
    public long qKk = 0;
    private int qKl = 0;

    public class a extends k<String, String, Boolean> {
        private SharedPreferences ehZ;
        private String key;
        private String qKo;
        PInt qKp;
        PInt qKq;
        private String qKr;
        private String username;

        public final /* synthetic */ Object dv() {
            AppMethodBeat.i(36368);
            Boolean cmY = cmY();
            AppMethodBeat.o(36368);
            return cmY;
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.i(36367);
            Boolean bool = (Boolean) obj;
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "onPostExecute ".concat(String.valueOf(bool)));
            ab.this.qKl = ab.this.qKl + 1;
            if (bool.booleanValue()) {
                ab.b(this.qKp, this.qKq);
                if (this.ehZ != null) {
                    this.ehZ.edit().putInt(this.qKo, this.qKp.value).commit();
                    this.ehZ.edit().putInt(this.key, this.qKq.value).commit();
                    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "update dir " + this.qKp.value + " " + this.qKq.value + " cleanCount: " + ab.this.qKl);
                }
                ab.this.handler.sendEmptyMessageDelayed(0, 20000);
            }
            ab.this.qKj = false;
            AppMethodBeat.o(36367);
        }

        public a() {
            AppMethodBeat.i(36364);
            this.ehZ = null;
            this.qKo = "";
            this.key = "";
            this.qKp = new PInt();
            this.qKq = new PInt();
            this.ehZ = ah.getContext().getSharedPreferences("preferences_remove_task", 0);
            g.RQ();
            if (g.RN().QY()) {
                this.username = r.Yz();
                this.qKo = "remove_key_base" + this.username;
                this.key = "remove_key" + this.username;
                g.RQ();
                if (!g.RN().QY()) {
                    AppMethodBeat.o(36364);
                    return;
                } else if (af.cnn()) {
                    AppMethodBeat.o(36364);
                    return;
                } else if (af.Ru() == null) {
                    AppMethodBeat.o(36364);
                    return;
                } else if (af.cnJ() == null) {
                    AppMethodBeat.o(36364);
                    return;
                } else {
                    l YX = af.cnJ().YX(this.username);
                    if (YX != null) {
                        this.qKr = YX.field_bgId;
                    }
                    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "my bgid %s", this.qKr);
                    ab.this.qKj = true;
                    AppMethodBeat.o(36364);
                    return;
                }
            }
            AppMethodBeat.o(36364);
        }

        private Boolean cmY() {
            AppMethodBeat.i(36365);
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
            Boolean bool;
            if (!ab.nLD) {
                bool = Boolean.FALSE;
                AppMethodBeat.o(36365);
                return bool;
            } else if (!ab.this.qKj) {
                bool = Boolean.FALSE;
                AppMethodBeat.o(36365);
                return bool;
            } else if (af.cnn()) {
                ab.nLD = false;
                bool = Boolean.FALSE;
                AppMethodBeat.o(36365);
                return bool;
            } else {
                this.qKp.value = this.ehZ.getInt(this.qKo, 0);
                this.qKq.value = this.ehZ.getInt(this.key, 0);
                String accSnsPath = af.getAccSnsPath();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (ab.ad(accSnsPath + ab.qKm[this.qKp.value % 36] + "/" + ab.qKm[this.qKq.value % 36], this.qKr, this.username)) {
                        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - currentTimeMillis) + " " + this.qKp.value + " " + this.qKq.value);
                        bool = Boolean.TRUE;
                        AppMethodBeat.o(36365);
                        return bool;
                    }
                    bool = Boolean.FALSE;
                    AppMethodBeat.o(36365);
                    return bool;
                } catch (Exception e) {
                }
            }
        }

        public final com.tencent.mm.sdk.g.b.a cin() {
            AppMethodBeat.i(36366);
            com.tencent.mm.sdk.g.b.a cnr = af.cnr();
            AppMethodBeat.o(36366);
            return cnr;
        }
    }

    public ab() {
        AppMethodBeat.i(36369);
        AppMethodBeat.o(36369);
    }

    static {
        int i = 0;
        int i2 = 48;
        while (i2 <= 57) {
            qKm[i] = (char) i2;
            i2++;
            i++;
        }
        i2 = 97;
        while (i2 <= 122) {
            qKm[i] = (char) i2;
            i2++;
            i++;
        }
    }

    public static void b(PInt pInt, PInt pInt2) {
        if (pInt2.value + 1 >= 36) {
            pInt2.value = 0;
            pInt.value = (pInt.value + 1) % 36;
            return;
        }
        pInt2.value = (pInt2.value + 1) % 36;
    }

    static /* synthetic */ boolean ad(String str, String str2, String str3) {
        AppMethodBeat.i(36370);
        for (com.tencent.mm.vfs.FileSystem.a aVar : e.cl(str, false)) {
            if (!nLD) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "broken here by ??");
                AppMethodBeat.o(36370);
                return false;
            } else if (aVar.name != null && !bo.isNullOrNil(str2) && str3 != null && (aVar.name.contains(str2) || aVar.name.contains(str3))) {
                com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.RemoveSnsTask", "do not delete my bg %s", str2);
            } else if (bo.gb(aVar.zYM) > 604800000) {
                aVar.delete();
            }
        }
        AppMethodBeat.o(36370);
        return true;
    }
}
