package com.tencent.p177mm.p190at.p191a.p827a;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.p191a.p192b.C1280c;
import com.tencent.p177mm.p190at.p191a.p192b.C17928b;
import com.tencent.p177mm.p190at.p191a.p192b.C17929i;
import com.tencent.p177mm.p190at.p191a.p192b.C31264a;
import com.tencent.p177mm.p190at.p191a.p192b.C32277d;
import com.tencent.p177mm.p190at.p191a.p192b.C32278g;
import com.tencent.p177mm.p190at.p191a.p192b.C36693e;
import com.tencent.p177mm.p190at.p191a.p192b.C37473f;
import com.tencent.p177mm.p190at.p191a.p193c.C1281h;
import com.tencent.p177mm.p190at.p191a.p193c.C25816a;
import com.tencent.p177mm.p190at.p191a.p193c.C32279e;
import com.tencent.p177mm.p190at.p191a.p193c.C32280j;
import com.tencent.p177mm.p190at.p191a.p193c.C32281k;
import com.tencent.p177mm.p190at.p191a.p193c.C32283m;
import com.tencent.p177mm.p190at.p191a.p193c.C37474b;
import com.tencent.p177mm.p190at.p191a.p193c.C37476n;
import com.tencent.p177mm.p190at.p191a.p193c.C9013f;
import com.tencent.p177mm.sdk.p604g.p607c.C35984d;
import java.util.concurrent.Executor;

/* renamed from: com.tencent.mm.at.a.a.b */
public final class C17926b {
    public static final int fGP = Runtime.getRuntime().availableProcessors();
    public final Resources aEH;
    public final int fGQ;
    public final int fGR;
    public final C25814c fGS;
    public final C32283m fGT;
    public final C25816a fGU;
    public final C37474b fGV;
    public final C9013f fGW;
    public final C32280j fGX;
    public final C32281k fGY;
    public final C32279e fGZ;
    public final C1281h fHa;
    public final Executor fHb;
    public final C37476n fHc;
    public final String packageName;

    /* renamed from: com.tencent.mm.at.a.a.b$a */
    public static class C17925a {
        Context context;
        int fGQ = C17926b.fGP;
        int fGR = 5;
        C25814c fGS = null;
        public C32283m fGT = null;
        C25816a fGU = null;
        public C37474b fGV = null;
        C9013f fGW = null;
        C32280j fGX = null;
        C32279e fGZ = null;
        public C1281h fHa = null;
        Executor fHb;
        C37476n fHc = null;
        C32281k fHd = null;

        public C17925a(Context context) {
            AppMethodBeat.m2504i(116066);
            this.context = context.getApplicationContext();
            AppMethodBeat.m2505o(116066);
        }

        public final C17926b ahx() {
            AppMethodBeat.m2504i(116067);
            ahy();
            C17926b c17926b = new C17926b(this);
            AppMethodBeat.m2505o(116067);
            return c17926b;
        }

        private void ahy() {
            AppMethodBeat.m2504i(116068);
            if (this.fGS == null) {
                this.fGS = C25814c.ahz();
            }
            if (this.fGT == null) {
                this.fGT = new C37473f();
            }
            if (this.fGU == null) {
                this.fGU = new C31264a();
            }
            if (this.fGV == null) {
                this.fGV = new C17928b();
            }
            if (this.fGW == null) {
                this.fGW = new C32277d();
            }
            if (this.fGX == null) {
                this.fGX = new C17929i();
            }
            if (this.fHa == null) {
                this.fHa = C25813a.m41070cs(this.fGQ, this.fGR);
            }
            if (this.fHb == null) {
                this.fHb = C35984d.anP("image_loader_ImageTempFile");
            }
            if (this.fHd == null) {
                this.fHd = new C36693e();
            }
            if (this.fGZ == null) {
                this.fGZ = new C1280c();
            }
            if (this.fHc == null) {
                this.fHc = new C32278g();
            }
            AppMethodBeat.m2505o(116068);
        }
    }

    static {
        AppMethodBeat.m2504i(116071);
        AppMethodBeat.m2505o(116071);
    }

    public C17926b(C17925a c17925a) {
        AppMethodBeat.m2504i(116069);
        this.packageName = c17925a.context.getPackageName();
        this.aEH = c17925a.context.getResources();
        this.fGQ = c17925a.fGQ;
        this.fGR = c17925a.fGR;
        this.fGS = c17925a.fGS;
        this.fGT = c17925a.fGT;
        this.fGU = c17925a.fGU;
        this.fGV = c17925a.fGV;
        this.fGW = c17925a.fGW;
        this.fGX = c17925a.fGX;
        this.fHa = c17925a.fHa;
        this.fHb = c17925a.fHb;
        this.fGY = c17925a.fHd;
        this.fGZ = c17925a.fGZ;
        this.fHc = c17925a.fHc;
        AppMethodBeat.m2505o(116069);
    }

    /* renamed from: bZ */
    public static C17926b m28169bZ(Context context) {
        AppMethodBeat.m2504i(116070);
        C17926b ahx = new C17925a(context).ahx();
        AppMethodBeat.m2505o(116070);
        return ahx;
    }
}
