package com.tencent.soter.core.p1350b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.C40997a;
import com.tencent.soter.core.p1351c.C44476d;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

/* renamed from: com.tencent.soter.core.b.a */
public abstract class C24316a {

    /* renamed from: com.tencent.soter.core.b.a$c */
    static class C24317c extends C24316a {
        private final String AuN;
        private int AuO;
        private int AuP = -1;
        private AlgorithmParameterSpec AuQ;
        private X500Principal AuR;
        private BigInteger AuS;
        private Date AuT;
        private Date AuU;
        private Date AuV;
        private Date AuW;
        private Date AuX;
        private String[] AuY;
        private String[] AuZ;
        private String[] Ava;
        private String[] Avb;
        private boolean Avc = true;
        private boolean Avd;
        private int Ave = -1;

        public C24317c(String str, int i) {
            AppMethodBeat.m2504i(73011);
            if (str == null) {
                NullPointerException nullPointerException = new NullPointerException("keystoreAlias == null");
                AppMethodBeat.m2505o(73011);
                throw nullPointerException;
            } else if (str.isEmpty()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("keystoreAlias must not be empty");
                AppMethodBeat.m2505o(73011);
                throw illegalArgumentException;
            } else {
                this.AuN = str;
                this.AuO = i;
                AppMethodBeat.m2505o(73011);
            }
        }

        /* renamed from: W */
        public final C24316a mo40403W(String... strArr) {
            AppMethodBeat.m2504i(73012);
            this.AuY = C24316a.m37478Y(strArr);
            AppMethodBeat.m2505o(73012);
            return this;
        }

        /* renamed from: X */
        public final C24316a mo40404X(String... strArr) {
            AppMethodBeat.m2504i(73013);
            this.Ava = C24316a.m37478Y(strArr);
            AppMethodBeat.m2505o(73013);
            return this;
        }

        public final C24316a dQV() {
            this.Avd = true;
            return this;
        }

        public final AlgorithmParameterSpec dQU() {
            AppMethodBeat.m2504i(73014);
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[]{String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, String[].class, String[].class, String[].class, String[].class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE}).newInstance(new Object[]{this.AuN, Integer.valueOf(this.AuP), this.AuQ, this.AuR, this.AuS, this.AuT, this.AuU, this.AuV, this.AuW, this.AuX, Integer.valueOf(this.AuO), this.AuY, this.AuZ, this.Ava, this.Avb, Boolean.valueOf(this.Avc), Boolean.valueOf(this.Avd), Integer.valueOf(this.Ave)});
            AppMethodBeat.m2505o(73014);
            return algorithmParameterSpec;
        }
    }

    /* renamed from: com.tencent.soter.core.b.a$a */
    static class C24318a extends C24316a {
        public final AlgorithmParameterSpec dQU() {
            return null;
        }

        /* renamed from: W */
        public final C24316a mo40403W(String... strArr) {
            return null;
        }

        /* renamed from: X */
        public final C24316a mo40404X(String... strArr) {
            return null;
        }

        public final C24316a dQV() {
            return null;
        }
    }

    @TargetApi(23)
    /* renamed from: com.tencent.soter.core.b.a$b */
    static class C24319b extends C24316a {
        private Builder AuM = null;

        public C24319b(String str, int i) {
            AppMethodBeat.m2504i(73006);
            this.AuM = new Builder(str, i);
            AppMethodBeat.m2505o(73006);
        }

        public final AlgorithmParameterSpec dQU() {
            AppMethodBeat.m2504i(73007);
            KeyGenParameterSpec build = this.AuM.build();
            AppMethodBeat.m2505o(73007);
            return build;
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: W */
        public final C24316a mo40403W(String... strArr) {
            AppMethodBeat.m2504i(73008);
            this.AuM.setDigests(strArr);
            AppMethodBeat.m2505o(73008);
            return this;
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: X */
        public final C24316a mo40404X(String... strArr) {
            AppMethodBeat.m2504i(73009);
            this.AuM.setSignaturePaddings(strArr);
            AppMethodBeat.m2505o(73009);
            return this;
        }

        public final C24316a dQV() {
            AppMethodBeat.m2504i(73010);
            this.AuM.setUserAuthenticationRequired(true);
            AppMethodBeat.m2505o(73010);
            return this;
        }
    }

    /* renamed from: W */
    public abstract C24316a mo40403W(String... strArr);

    /* renamed from: X */
    public abstract C24316a mo40404X(String... strArr);

    public abstract AlgorithmParameterSpec dQU();

    public abstract C24316a dQV();

    /* renamed from: eP */
    public static C24316a m37479eP(String str, int i) {
        if (!C40997a.dQN()) {
            C44476d.m80483e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
            return new C24318a();
        } else if (VERSION.SDK_INT >= 23) {
            return new C24319b(str, i);
        } else {
            return new C24317c(str, i);
        }
    }

    /* renamed from: Y */
    public static String[] m37478Y(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }
}
