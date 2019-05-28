package com.tencent.xweb.c;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import java.util.regex.Pattern;
import org.xwalk.core.XWalkEnvironment;

public final class a {

    public static class a {
        public b AOK = new b();
        public String AOL;
        public String AOM;
        public String AON;

        public a() {
            AppMethodBeat.i(3967);
            AppMethodBeat.o(3967);
        }
    }

    public static class b {
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
            AppMethodBeat.i(3968);
            int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion();
            int tbsSDKVersion = WebView.getTbsSDKVersion(XWalkEnvironment.getApplicationContext());
            int installedTbsCoreVersion = WebView.getInstalledTbsCoreVersion(XWalkEnvironment.getApplicationContext());
            if (!aM(installedNewstVersion, this.AOQ, this.AOR) || !aM(XWalkEnvironment.SDK_VERSION, this.AOO, this.AOP) || !aM(tbsSDKVersion, this.APd, this.APe) || !aM(installedTbsCoreVersion, this.APf, this.APg) || !aM(VERSION.SDK_INT, this.AOS, this.AOT) || !aM(XWalkEnvironment.getGrayValue(), this.AOW, this.AOX) || avi(this.AOU) || iH(this.APb, XWalkEnvironment.getPackageName())) {
                AppMethodBeat.o(3968);
                return false;
            } else if (this.APa > 0 && XWalkEnvironment.getUserType() != this.APa) {
                AppMethodBeat.o(3968);
                return false;
            } else if (this.AOV != null && this.AOV.trim() != null && !this.AOV.trim().isEmpty() && !avi(this.AOV)) {
                AppMethodBeat.o(3968);
                return false;
            } else if (this.APc != null && this.APc.trim() != null && !this.APc.trim().isEmpty() && !iH(this.APc, XWalkEnvironment.getPackageName())) {
                AppMethodBeat.o(3968);
                return false;
            } else if ((this.AOY > 0 || this.AOZ > 0) && !aM(XWalkEnvironment.getChromiunVersion(), this.AOY, this.AOZ)) {
                AppMethodBeat.o(3968);
                return false;
            } else {
                AppMethodBeat.o(3968);
                return true;
            }
        }

        private static boolean avi(String str) {
            AppMethodBeat.i(3969);
            String str2 = "";
            if (Build.BRAND != null) {
                str2 = str2 + Build.BRAND;
            }
            if (Build.MODEL != null) {
                str2 = str2 + " " + Build.MODEL;
            }
            if (str == null || str2 == null || str.isEmpty()) {
                AppMethodBeat.o(3969);
                return false;
            }
            boolean iH = iH(str, str2);
            AppMethodBeat.o(3969);
            return iH;
        }

        private static boolean iH(String str, String str2) {
            boolean z = false;
            AppMethodBeat.i(3970);
            if (str == null || str.isEmpty() || str.trim() == null || str.trim().isEmpty()) {
                AppMethodBeat.o(3970);
            } else if (str2 == null || str2.isEmpty()) {
                AppMethodBeat.o(3970);
            } else {
                try {
                    z = Pattern.compile(str).matcher(str2.toUpperCase()).find();
                } catch (Exception e) {
                    XWalkEnvironment.addXWalkInitializeLog("ConfigDef", " _IsMatchRex compile strRex failed");
                }
                AppMethodBeat.o(3970);
            }
            return z;
        }

        private static boolean aM(int i, int i2, int i3) {
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
