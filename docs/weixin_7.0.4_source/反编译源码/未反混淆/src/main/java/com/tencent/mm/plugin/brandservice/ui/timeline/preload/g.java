package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.f;
import java.util.regex.Pattern;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen;", "Lcom/tencent/mm/pluginsdk/cmd/ProcessorCommand;", "()V", "processCommand", "", "context", "Landroid/content/Context;", "args", "", "", "username", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)Z", "Companion", "plugin-brandservice_release"})
public final class g implements com.tencent.mm.pluginsdk.cmd.a {
    public static final a jSD = new a();

    @l(dWo = {1, 1, 13}, dWp = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u0006J\b\u0010\u001f\u001a\u00020 H\u0007J\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\u0006J\u0006\u0010*\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u0006J\u0006\u0010,\u001a\u00020\u0006J\u0006\u0010-\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006."}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/MPPageFastOpen$Companion;", "", "()V", "COMMAND_USE_NEW_PROFILE", "", "DATA_DIR", "", "LOCAL", "", "MM", "ONLINE", "PRELOAD_DATA", "PRELOAD_DATA_NO_EXPIRE", "PRELOAD_DATA_NULL", "PRELOAD_PROCESS", "PRELOAD_SAVE_TYPE", "PRELOAD_TMPL_ALWAYS_VERIFY_MD5", "PRELOAD_TMPL_LOWER_BOUND", "PRELOAD_TMPL_TEST_NO_FORCE_URL", "PRELOAD_TMPL_TEST_NO_PRELOAD_NEXT", "PRELOAD_TMPL_TEST_NO_RED", "PRELOAD_TYPE", "PRELOAD_USE", "PRELOAD_WEBVIEW", "SDDATA_DIR", "SERVER", "TAG", "TOOL", "TOOLMP", "UNKNOW", "alwaysVerifiyMD5", "register", "", "saveToSDCard", "targetProcess", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$Process;", "useLocalTmpl", "usePreloadData", "usePreloadLowerBound", "usePreloadNullData", "usePreloadTmpl", "usePreloadWebview", "userPreloadDataNoExpire", "userPreloadTestNoPreloadNext", "userPreloadTestNoReDir", "userPreloadTestNotRed", "plugin-brandservice_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static boolean aXe() {
            AppMethodBeat.i(14847);
            boolean z = h.aXn().getBoolean("preload_webview", true);
            if (!z) {
                ab.i("MicroMsg.UseNewProfile", "//mppagefastopen webview false");
            }
            AppMethodBeat.o(14847);
            return z;
        }

        public static boolean aXf() {
            AppMethodBeat.i(14848);
            boolean z = h.aXn().getBoolean("preload_data", true);
            if (!z) {
                ab.i("MicroMsg.UseNewProfile", "//mppagefastopen data false");
            }
            AppMethodBeat.o(14848);
            return z;
        }

        public static boolean aXg() {
            AppMethodBeat.i(14849);
            boolean z = h.aXn().getBoolean("preload_data_null", false);
            if (!z) {
                ab.i("MicroMsg.UseNewProfile", "//mppagefastopen data null");
            }
            AppMethodBeat.o(14849);
            return z;
        }

        public static boolean aXh() {
            AppMethodBeat.i(14850);
            boolean z = h.aXn().getBoolean("preload_data_noexpire", false);
            AppMethodBeat.o(14850);
            return z;
        }

        public static boolean aXi() {
            AppMethodBeat.i(14851);
            boolean z = h.aXn().getBoolean("preload_save_type", false);
            AppMethodBeat.o(14851);
            return z;
        }

        public static int aXj() {
            AppMethodBeat.i(14852);
            int i = h.aXn().getInt("preload_tmpl_lowerbound", -1);
            AppMethodBeat.o(14852);
            return i;
        }

        public static boolean aXk() {
            AppMethodBeat.i(14853);
            boolean z = h.aXn().getBoolean("preload_tmpl_test_noredir", false);
            AppMethodBeat.o(14853);
            return z;
        }

        public static boolean aXl() {
            AppMethodBeat.i(14854);
            boolean z = h.aXn().getBoolean("preload_tmpl_test_no_preload_next", false);
            AppMethodBeat.o(14854);
            return z;
        }

        public static boolean aXm() {
            AppMethodBeat.i(14855);
            boolean z = h.aXn().getBoolean("preload_tmpl_test_no_red", false);
            AppMethodBeat.o(14855);
            return z;
        }
    }

    static {
        AppMethodBeat.i(14857);
        AppMethodBeat.o(14857);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(14856);
        j.p(context, "context");
        j.p(strArr, "args");
        j.p(str, "username");
        if (!j.j("//mpfast", strArr[0])) {
            AppMethodBeat.o(14856);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(14856);
            return false;
        } else {
            String str2 = strArr[1];
            String str3;
            switch (str2.hashCode()) {
                case -905826493:
                    if (str2.equals("server")) {
                    }
                    break;
                case -309518737:
                    if (str2.equals("process")) {
                        if (strArr.length > 2) {
                            str3 = strArr[2];
                            switch (str3.hashCode()) {
                                case -1012222381:
                                    if (str3.equals("online")) {
                                        h.aXn().putInt("preload_process", 4);
                                        j.FQ("use process mm success");
                                        break;
                                    }
                                    break;
                                case -868060869:
                                    if (str3.equals("toolmp")) {
                                        h.aXn().putInt("preload_process", 2);
                                        j.FQ("use process toolmp success");
                                        break;
                                    }
                                    break;
                                case 3488:
                                    if (str3.equals("mm")) {
                                        h.aXn().putInt("preload_process", 3);
                                        j.FQ("use process mm success");
                                        break;
                                    }
                                    break;
                                case 3565976:
                                    if (str3.equals("tool")) {
                                        h.aXn().putInt("preload_process", 1);
                                        j.FQ("use process tool success");
                                        break;
                                    }
                                    break;
                            }
                        }
                        h.aXn().putInt("preload_process", 1);
                        j.FQ("use process tool success");
                        break;
                    }
                    break;
                case 112785:
                    if (str2.equals("red")) {
                        h.aXn().removeValueForKey("preload_tmpl_test_no_red");
                        j.FQ("disable test not in red");
                        break;
                    }
                    break;
                case 3076010:
                    if (str2.equals("data")) {
                        if (strArr.length > 2) {
                            str2 = strArr[2];
                            switch (str2.hashCode()) {
                                case -1289159393:
                                    if (str2.equals("expire")) {
                                        h.aXn().remove("preload_data_noexpire");
                                        j.FQ("enable data expire");
                                        break;
                                    }
                                    break;
                                case 3392903:
                                    if (str2.equals(BuildConfig.COMMAND)) {
                                        h.aXn().putBoolean("preload_data_null", true);
                                        h.aXn().putBoolean("preload_data", false);
                                        j.FQ("test preload null data");
                                        break;
                                    }
                                    break;
                                case 3569038:
                                    if (str2.equals("true")) {
                                        h.aXn().putBoolean("preload_data_null", false);
                                        h.aXn().putBoolean("preload_data", true);
                                        j.FQ("enable preload data");
                                        break;
                                    }
                                    break;
                                case 94746189:
                                    if (str2.equals("clear")) {
                                        a.aWM();
                                        j.FQ("clear all cached data");
                                        break;
                                    }
                                    break;
                                case 97196323:
                                    if (str2.equals("false")) {
                                        h.aXn().putBoolean("preload_data_null", false);
                                        h.aXn().putBoolean("preload_data", false);
                                        j.FQ("disable preload data");
                                        break;
                                    }
                                    break;
                                case 1170077216:
                                    if (str2.equals("noexpire")) {
                                        h.aXn().putBoolean("preload_data_noexpire", true);
                                        j.FQ("disable data expire");
                                        break;
                                    }
                                    break;
                            }
                        }
                        h.aXn().putBoolean("preload_data_null", false);
                        h.aXn().putBoolean("preload_data", true);
                        j.FQ("enable preload data");
                        break;
                    }
                    break;
                case 3522941:
                    if (str2.equals("save")) {
                        if (strArr.length > 2) {
                            str2 = strArr[2];
                            switch (str2.hashCode()) {
                                case 3665:
                                    if (str2.equals("sd")) {
                                        h.aXn().putBoolean("preload_save_type", true);
                                        j.FQ("save to sdcard dir");
                                        break;
                                    }
                                default:
                                    h.aXn().putBoolean("preload_save_type", false);
                                    j.FQ("save to data dir");
                                    break;
                            }
                        }
                        h.aXn().putBoolean("preload_save_type", false);
                        j.FQ("save to data dir");
                        break;
                    }
                    break;
                case 3564085:
                    if (str2.equals("tmpl") && strArr.length > 2) {
                        str3 = strArr[2];
                        switch (str3.hashCode()) {
                            case -1080348879:
                                if (str3.equals("md5off")) {
                                    h.aXn().remove("preload_tmpl_always_verify_md5");
                                    j.FQ("disable tmpl md5 verify");
                                    break;
                                }
                            case 107902:
                                if (str3.equals("md5")) {
                                    h.aXn().putBoolean("preload_tmpl_always_verify_md5", true);
                                    j.FQ("enable tmpl md5 verify");
                                    break;
                                }
                            case 94746189:
                                if (str3.equals("clear")) {
                                    b.clear();
                                    j.FQ("clear all tmpl info");
                                    break;
                                }
                            default:
                                if (Pattern.compile("[0-9]+").matcher(strArr[2]).matches()) {
                                    if (!j.j(AppEventsConstants.EVENT_PARAM_VALUE_NO, strArr[2])) {
                                        Integer valueOf = Integer.valueOf(strArr[2]);
                                        j.o(valueOf, "Integer.valueOf(args[2])");
                                        h.aXn().putInt("preload_tmpl_lowerbound", valueOf.intValue());
                                        j.FQ("tmpl lowerbound: " + strArr[2]);
                                        break;
                                    }
                                    h.aXn().remove("preload_tmpl_lowerbound");
                                    j.FQ("clear tmpl lowerbound");
                                    break;
                                }
                                break;
                        }
                    }
                    break;
                case 3569038:
                    if (str2.equals("true")) {
                        if (strArr.length > 2) {
                            h.aXn().putBoolean("preload_use", true);
                            str3 = strArr[2];
                            switch (str3.hashCode()) {
                                case -1012222381:
                                    if (str3.equals("online")) {
                                        h.aXn().putInt("preload_type", 1);
                                        j.FQ("online tmpl");
                                        break;
                                    }
                                case -905826493:
                                    if (str3.equals("server")) {
                                        h.aXn().putInt("preload_type", 2);
                                        j.FQ("test server tmpl");
                                        break;
                                    }
                                case 103145323:
                                    if (str3.equals(ImagesContract.LOCAL)) {
                                        if (f.IS_FLAVOR_RED || f.DEBUG) {
                                            h.aXn().putInt("preload_type", 3);
                                            j.FQ("local tmpl");
                                            break;
                                        }
                                    }
                                default:
                                    h.aXn().putInt("preload_type", 1);
                                    j.FQ("release can't use local tmpl, use online tmpl");
                                    break;
                            }
                        }
                        h.aXn().putBoolean("preload_use", true);
                        h.aXn().putInt("preload_type", 1);
                        j.FQ("tmpl webview");
                        break;
                    }
                    break;
                case 94746189:
                    if (str2.equals("clear")) {
                        h.aXn().clear();
                        j.FQ("clear all commands");
                        break;
                    }
                    break;
                case 97196323:
                    if (str2.equals("false")) {
                        h.aXn().putBoolean("preload_use", false);
                        j.FQ("not use tmpl webview");
                        break;
                    }
                    break;
                case 105006896:
                    if (str2.equals("nored")) {
                        h.aXn().putBoolean("preload_tmpl_test_no_red", true);
                        j.FQ("enable test not in red");
                        break;
                    }
                    break;
                case 1224424441:
                    if (str2.equals("webview")) {
                        if (strArr.length > 2) {
                            str2 = strArr[2];
                            switch (str2.hashCode()) {
                                case -1039871948:
                                    if (str2.equals("nonext")) {
                                        h.aXn().putBoolean("preload_tmpl_test_no_preload_next", true);
                                        j.FQ("disable preload next webview");
                                        break;
                                    }
                                    break;
                                case 3377907:
                                    if (str2.equals("next")) {
                                        h.aXn().remove("preload_tmpl_test_no_preload_next");
                                        j.FQ("enable preload next webview");
                                        break;
                                    }
                                    break;
                                case 3569038:
                                    if (str2.equals("true")) {
                                        h.aXn().putBoolean("preload_webview", true);
                                        j.FQ("use preload webview");
                                        break;
                                    }
                                    break;
                                case 97196323:
                                    if (str2.equals("false")) {
                                        h.aXn().putBoolean("preload_webview", false);
                                        j.FQ("not use preload webview");
                                        break;
                                    }
                                    break;
                                case 108389754:
                                    if (str2.equals("redir")) {
                                        h.aXn().remove("preload_tmpl_test_noredir");
                                        j.FQ("enable re-direct");
                                        break;
                                    }
                                    break;
                                case 2127382617:
                                    if (str2.equals("noredir")) {
                                        h.aXn().putBoolean("preload_tmpl_test_noredir", true);
                                        j.FQ("disable re-direct");
                                        break;
                                    }
                                    break;
                            }
                        }
                        h.aXn().putBoolean("preload_webview", true);
                        j.FQ("use preload webview");
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(14856);
            return true;
        }
    }

    public static final void axy() {
        AppMethodBeat.i(14858);
        com.tencent.mm.pluginsdk.cmd.b.a(new g(), "//mpfast");
        AppMethodBeat.o(14858);
    }
}
