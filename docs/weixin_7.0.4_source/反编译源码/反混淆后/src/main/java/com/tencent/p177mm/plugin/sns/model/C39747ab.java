package com.tencent.p177mm.plugin.sns.model;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.sns.storage.C29097l;
import com.tencent.p177mm.pluginsdk.model.C23251k;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.FileSystem.C5712a;

/* renamed from: com.tencent.mm.plugin.sns.model.ab */
public final class C39747ab {
    public static boolean nLD = false;
    public static char[] qKm = new char[36];
    private C7306ak handler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(36363);
            super.handleMessage(message);
            if (C39747ab.this.qKl >= 5 || System.currentTimeMillis() - C39747ab.this.qKk > 300000) {
                C4990ab.m7410d("MicroMsg.RemoveSnsTask", "cleanCount: " + C39747ab.this.qKl);
                C39747ab.nLD = false;
                AppMethodBeat.m2505o(36363);
            } else if (C39747ab.this.qKj) {
                AppMethodBeat.m2505o(36363);
            } else {
                if (C39747ab.nLD) {
                    new C39748a().mo38881u("");
                }
                AppMethodBeat.m2505o(36363);
            }
        }
    };
    public boolean qKj = false;
    public long qKk = 0;
    private int qKl = 0;

    /* renamed from: com.tencent.mm.plugin.sns.model.ab$a */
    public class C39748a extends C23251k<String, String, Boolean> {
        private SharedPreferences ehZ;
        private String key;
        private String qKo;
        PInt qKp;
        PInt qKq;
        private String qKr;
        private String username;

        /* renamed from: dv */
        public final /* synthetic */ Object mo38879dv() {
            AppMethodBeat.m2504i(36368);
            Boolean cmY = cmY();
            AppMethodBeat.m2505o(36368);
            return cmY;
        }

        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(36367);
            Boolean bool = (Boolean) obj;
            C4990ab.m7410d("MicroMsg.RemoveSnsTask", "onPostExecute ".concat(String.valueOf(bool)));
            C39747ab.this.qKl = C39747ab.this.qKl + 1;
            if (bool.booleanValue()) {
                C39747ab.m67982b(this.qKp, this.qKq);
                if (this.ehZ != null) {
                    this.ehZ.edit().putInt(this.qKo, this.qKp.value).commit();
                    this.ehZ.edit().putInt(this.key, this.qKq.value).commit();
                    C4990ab.m7410d("MicroMsg.RemoveSnsTask", "update dir " + this.qKp.value + " " + this.qKq.value + " cleanCount: " + C39747ab.this.qKl);
                }
                C39747ab.this.handler.sendEmptyMessageDelayed(0, 20000);
            }
            C39747ab.this.qKj = false;
            AppMethodBeat.m2505o(36367);
        }

        public C39748a() {
            AppMethodBeat.m2504i(36364);
            this.ehZ = null;
            this.qKo = "";
            this.key = "";
            this.qKp = new PInt();
            this.qKq = new PInt();
            this.ehZ = C4996ah.getContext().getSharedPreferences("preferences_remove_task", 0);
            C1720g.m3537RQ();
            if (C1720g.m3534RN().mo5161QY()) {
                this.username = C1853r.m3846Yz();
                this.qKo = "remove_key_base" + this.username;
                this.key = "remove_key" + this.username;
                C1720g.m3537RQ();
                if (!C1720g.m3534RN().mo5161QY()) {
                    AppMethodBeat.m2505o(36364);
                    return;
                } else if (C13373af.cnn()) {
                    AppMethodBeat.m2505o(36364);
                    return;
                } else if (C13373af.m21489Ru() == null) {
                    AppMethodBeat.m2505o(36364);
                    return;
                } else if (C13373af.cnJ() == null) {
                    AppMethodBeat.m2505o(36364);
                    return;
                } else {
                    C29097l YX = C13373af.cnJ().mo69179YX(this.username);
                    if (YX != null) {
                        this.qKr = YX.field_bgId;
                    }
                    C4990ab.m7411d("MicroMsg.RemoveSnsTask", "my bgid %s", this.qKr);
                    C39747ab.this.qKj = true;
                    AppMethodBeat.m2505o(36364);
                    return;
                }
            }
            AppMethodBeat.m2505o(36364);
        }

        private Boolean cmY() {
            AppMethodBeat.m2504i(36365);
            C4990ab.m7410d("MicroMsg.RemoveSnsTask", "simpleCleans sns");
            Boolean bool;
            if (!C39747ab.nLD) {
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(36365);
                return bool;
            } else if (!C39747ab.this.qKj) {
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(36365);
                return bool;
            } else if (C13373af.cnn()) {
                C39747ab.nLD = false;
                bool = Boolean.FALSE;
                AppMethodBeat.m2505o(36365);
                return bool;
            } else {
                this.qKp.value = this.ehZ.getInt(this.qKo, 0);
                this.qKq.value = this.ehZ.getInt(this.key, 0);
                String accSnsPath = C13373af.getAccSnsPath();
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (C39747ab.m67980ad(accSnsPath + C39747ab.qKm[this.qKp.value % 36] + "/" + C39747ab.qKm[this.qKq.value % 36], this.qKr, this.username)) {
                        C4990ab.m7410d("MicroMsg.RemoveSnsTask", "clean sns uses time : " + (System.currentTimeMillis() - currentTimeMillis) + " " + this.qKp.value + " " + this.qKq.value);
                        bool = Boolean.TRUE;
                        AppMethodBeat.m2505o(36365);
                        return bool;
                    }
                    bool = Boolean.FALSE;
                    AppMethodBeat.m2505o(36365);
                    return bool;
                } catch (Exception e) {
                }
            }
        }

        public final C4946a cin() {
            AppMethodBeat.m2504i(36366);
            C4946a cnr = C13373af.cnr();
            AppMethodBeat.m2505o(36366);
            return cnr;
        }
    }

    public C39747ab() {
        AppMethodBeat.m2504i(36369);
        AppMethodBeat.m2505o(36369);
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

    /* renamed from: b */
    public static void m67982b(PInt pInt, PInt pInt2) {
        if (pInt2.value + 1 >= 36) {
            pInt2.value = 0;
            pInt.value = (pInt.value + 1) % 36;
            return;
        }
        pInt2.value = (pInt2.value + 1) % 36;
    }

    /* renamed from: ad */
    static /* synthetic */ boolean m67980ad(String str, String str2, String str3) {
        AppMethodBeat.m2504i(36370);
        for (C5712a c5712a : C5730e.m8627cl(str, false)) {
            if (!nLD) {
                C4990ab.m7410d("MicroMsg.RemoveSnsTask", "broken here by ??");
                AppMethodBeat.m2505o(36370);
                return false;
            } else if (c5712a.name != null && !C5046bo.isNullOrNil(str2) && str3 != null && (c5712a.name.contains(str2) || c5712a.name.contains(str3))) {
                C4990ab.m7411d("MicroMsg.RemoveSnsTask", "do not delete my bg %s", str2);
            } else if (C5046bo.m7566gb(c5712a.zYM) > 604800000) {
                c5712a.delete();
            }
        }
        AppMethodBeat.m2505o(36370);
        return true;
    }
}
