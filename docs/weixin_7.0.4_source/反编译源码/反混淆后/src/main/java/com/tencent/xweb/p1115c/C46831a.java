package com.tencent.xweb.p1115c;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import java.util.regex.Pattern;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.xweb.c.a */
public final class C46831a {

    /* renamed from: com.tencent.xweb.c.a$a */
    public static class C16383a {
        public C46830b AOK = new C46830b();
        public String AOL;
        public String AOM;
        public String AON;

        public C16383a() {
            AppMethodBeat.m2504i(3967);
            AppMethodBeat.m2505o(3967);
        }
    }

    /* renamed from: com.tencent.xweb.c.a$b */
    public static class C46830b {
        public int AOO = -1;
        public int AOP = -1;
        public int AOQ = -1;
        public int AOR = -1;
        public int AOS = -1;
        public int AOT = -1;
        public String AOU = "";
        public String AOV = "";
        public int AOW = -1;
        public int AOX = -1;
        public int AOY = -1;
        public int AOZ = -1;
        public int APa = -1;
        public String APb = "";
        public String APc = "";
        public int APd = -1;
        public int APe = -1;
        public int APf = -1;
        public int APg = -1;

        public final boolean dUw() {
            AppMethodBeat.m2504i(3968);
            int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion();
            int tbsSDKVersion = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
            int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            if (!C46830b.m89067aM(installedNewstVersion, this.AOQ, this.AOR) || !C46830b.m89067aM(XWalkEnvironment.SDK_VERSION, this.AOO, this.AOP) || !C46830b.m89067aM(tbsSDKVersion, this.APd, this.APe) || !C46830b.m89067aM(installedTbsCoreVersion, this.APf, this.APg) || !C46830b.m89067aM(VERSION.SDK_INT, this.AOS, this.AOT) || !C46830b.m89067aM(XWalkEnvironment.getGrayValue(), this.AOW, this.AOX) || C46830b.avi(this.AOU) || C46830b.m89068iH(this.APb, XWalkEnvironment.getPackageName())) {
                AppMethodBeat.m2505o(3968);
                return false;
            } else if (this.APa > 0 && XWalkEnvironment.getUserType() != this.APa) {
                AppMethodBeat.m2505o(3968);
                return false;
            } else if (this.AOV != null && this.AOV.trim() != null && !this.AOV.trim().isEmpty() && !C46830b.avi(this.AOV)) {
                AppMethodBeat.m2505o(3968);
                return false;
            } else if (this.APc != null && this.APc.trim() != null && !this.APc.trim().isEmpty() && !C46830b.m89068iH(this.APc, XWalkEnvironment.getPackageName())) {
                AppMethodBeat.m2505o(3968);
                return false;
            } else if ((this.AOY > 0 || this.AOZ > 0) && !C46830b.m89067aM(XWalkEnvironment.getChromiunVersion(), this.AOY, this.AOZ)) {
                AppMethodBeat.m2505o(3968);
                return false;
            } else {
                AppMethodBeat.m2505o(3968);
                return true;
            }
        }

        private static boolean avi(String str) {
            AppMethodBeat.m2504i(3969);
            String str2 = "";
            if (Build.BRAND != null) {
                str2 = str2 + Build.BRAND;
            }
            if (Build.MODEL != null) {
                str2 = str2 + " " + Build.MODEL;
            }
            if (str == null || str2 == null || str.isEmpty()) {
                AppMethodBeat.m2505o(3969);
                return false;
            }
            boolean iH = C46830b.m89068iH(str, str2);
            AppMethodBeat.m2505o(3969);
            return iH;
        }

        /* renamed from: iH */
        private static boolean m89068iH(String str, String str2) {
            boolean z = false;
            AppMethodBeat.m2504i(3970);
            if (str == null || str.isEmpty() || str.trim() == null || str.trim().isEmpty()) {
                AppMethodBeat.m2505o(3970);
            } else if (str2 == null || str2.isEmpty()) {
                AppMethodBeat.m2505o(3970);
            } else {
                try {
                    z = Pattern.compile(str).matcher(str2.toUpperCase()).find();
                } catch (Exception e) {
                    XWalkEnvironment.addXWalkInitializeLog("ConfigDef", " _IsMatchRex compile strRex failed");
                }
                AppMethodBeat.m2505o(3970);
            }
            return z;
        }

        /* renamed from: aM */
        private static boolean m89067aM(int i, int i2, int i3) {
            if (i3 > 0 && i > i3) {
                return false;
            }
            if (i2 <= 0 || i >= i2) {
                return true;
            }
            return false;
        }
    }
}
