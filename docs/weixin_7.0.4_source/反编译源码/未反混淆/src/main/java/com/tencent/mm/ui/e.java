package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

public final class e {

    public static final class a {
        public static int MQ(int i) {
            switch (i) {
                case 0:
                    return 1;
                case 1:
                    return 2;
                case 2:
                    return 3;
                default:
                    return 0;
            }
        }
    }

    public static final class b {
        public static String yfT = "AntispamTicket";
    }

    public interface c {
        public static final String yfU = ah.getPackageName();
    }

    public static final class d {
        public static final String yfV = (com.tencent.mm.compatible.util.e.eSj + "switchAccountBg");

        static {
            AppMethodBeat.i(105952);
            AppMethodBeat.o(105952);
        }
    }

    public interface e {
        public static final String yfW = "FREE_WIFI_IS_DEFAULT_FOCUS".toLowerCase();
    }

    public static final class f {
        public static String yfX = "key_envelope_source";
        public static String yfY = "key_source_resp";
    }

    public static final class g {
        private g() {
        }
    }

    public static final class h {
        public static int yfZ = 0;
        public static int yga = 1;
        public static int ygb = 2;
    }

    public static final class i {
        public static final String evO = null;
    }

    public static final class j {
        public static String ygc = "trust_friend_show_tips";
    }

    public static final class k {
        public static final String ygd = ("Kdescription" + System.currentTimeMillis());

        static {
            AppMethodBeat.i(105953);
            AppMethodBeat.o(105953);
        }
    }

    public interface l {
        public static final String hmI = (ah.getPackageName() + ":tools");
        public static final String iRj = ah.getPackageName();
    }

    public static final class m {
        public static String yge = "k_tmpl_params";
        public static String ygf = "k_tmpl_next_webview";
        public static String ygg = "k_tmpl_start_load_page";
        public static String ygh = "k_tmpl_page_info";
        public static String ygi = "k_tmpl_data_key";
        public static String ygj = "k_tmpl_session_id";
        public static String ygk = "k_tmpl_scene";
        public static String ygl = "k_tmpl_sub_scene";
        public static String ygm = "k_tmpl_is_webview_prc_created";
        public static String ygn = "k_tmpl_orig_prc_pid";
        public static String ygo = "k_tmpl_item_show_type";
        public static String ygp = "k_tmpl_open_type";
        public static String ygq = "k_tmpl_session";

        private m() {
        }
    }

    public static String aqC(String str) {
        AppMethodBeat.i(105954);
        String str2 = str + "_" + System.currentTimeMillis();
        AppMethodBeat.o(105954);
        return str2;
    }
}
