package com.tencent.soter.core.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyGenParameterSpec.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.c.d;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

public abstract class a {

    static class c extends a {
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

        public c(String str, int i) {
            AppMethodBeat.i(73011);
            if (str == null) {
                NullPointerException nullPointerException = new NullPointerException("keystoreAlias == null");
                AppMethodBeat.o(73011);
                throw nullPointerException;
            } else if (str.isEmpty()) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("keystoreAlias must not be empty");
                AppMethodBeat.o(73011);
                throw illegalArgumentException;
            } else {
                this.AuN = str;
                this.AuO = i;
                AppMethodBeat.o(73011);
            }
        }

        public final a W(String... strArr) {
            AppMethodBeat.i(73012);
            this.AuY = a.Y(strArr);
            AppMethodBeat.o(73012);
            return this;
        }

        public final a X(String... strArr) {
            AppMethodBeat.i(73013);
            this.Ava = a.Y(strArr);
            AppMethodBeat.o(73013);
            return this;
        }

        public final a dQV() {
            this.Avd = true;
            return this;
        }

        public final AlgorithmParameterSpec dQU() {
            AppMethodBeat.i(73014);
            AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[]{String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, String[].class, String[].class, String[].class, String[].class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE}).newInstance(new Object[]{this.AuN, Integer.valueOf(this.AuP), this.AuQ, this.AuR, this.AuS, this.AuT, this.AuU, this.AuV, this.AuW, this.AuX, Integer.valueOf(this.AuO), this.AuY, this.AuZ, this.Ava, this.Avb, Boolean.valueOf(this.Avc), Boolean.valueOf(this.Avd), Integer.valueOf(this.Ave)});
            AppMethodBeat.o(73014);
            return algorithmParameterSpec;
        }
    }

    static class a extends a {
        public final AlgorithmParameterSpec dQU() {
            return null;
        }

        public final a W(String... strArr) {
            return null;
        }

        public final a X(String... strArr) {
            return null;
        }

        public final a dQV() {
            return null;
        }
    }

    @TargetApi(23)
    static class b extends a {
        private Builder AuM = null;

        public b(String str, int i) {
            AppMethodBeat.i(73006);
            this.AuM = new Builder(str, i);
            AppMethodBeat.o(73006);
        }

        public final AlgorithmParameterSpec dQU() {
            AppMethodBeat.i(73007);
            KeyGenParameterSpec build = this.AuM.build();
            AppMethodBeat.o(73007);
            return build;
        }

        @SuppressLint({"WrongConstant"})
        public final a W(String... strArr) {
            AppMethodBeat.i(73008);
            this.AuM.setDigests(strArr);
            AppMethodBeat.o(73008);
            return this;
        }

        @SuppressLint({"WrongConstant"})
        public final a X(String... strArr) {
            AppMethodBeat.i(73009);
            this.AuM.setSignaturePaddings(strArr);
            AppMethodBeat.o(73009);
            return this;
        }

        public final a dQV() {
            AppMethodBeat.i(73010);
            this.AuM.setUserAuthenticationRequired(true);
            AppMethodBeat.o(73010);
            return this;
        }
    }

    public abstract a W(String... strArr);

    public abstract a X(String... strArr);

    public abstract AlgorithmParameterSpec dQU();

    public abstract a dQV();

    public static a eP(String str, int i) {
        if (!com.tencent.soter.core.a.dQN()) {
            d.e("Soter.KeyGenParameterSpecCompatBuilder", "soter: not support soter. return dummy", new Object[0]);
            return new a();
        } else if (VERSION.SDK_INT >= 23) {
            return new b(str, i);
        } else {
            return new c(str, i);
        }
    }

    public static String[] Y(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? strArr : (String[]) strArr.clone();
    }
}
