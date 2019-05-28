package com.tencent.p177mm.p612ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.ui.e */
public final class C5510e {

    /* renamed from: com.tencent.mm.ui.e$a */
    public static final class C5494a {
        /* renamed from: MQ */
        public static int m8288MQ(int i) {
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

    /* renamed from: com.tencent.mm.ui.e$b */
    public static final class C5495b {
        public static String yfT = "AntispamTicket";
    }

    /* renamed from: com.tencent.mm.ui.e$c */
    public interface C5496c {
        public static final String yfU = C4996ah.getPackageName();
    }

    /* renamed from: com.tencent.mm.ui.e$d */
    public static final class C5497d {
        public static final String yfV = (C6457e.eSj + "switchAccountBg");

        static {
            AppMethodBeat.m2504i(105952);
            AppMethodBeat.m2505o(105952);
        }
    }

    /* renamed from: com.tencent.mm.ui.e$e */
    public interface C5498e {
        public static final String yfW = "FREE_WIFI_IS_DEFAULT_FOCUS".toLowerCase();
    }

    /* renamed from: com.tencent.mm.ui.e$f */
    public static final class C5499f {
        public static String yfX = "key_envelope_source";
        public static String yfY = "key_source_resp";
    }

    /* renamed from: com.tencent.mm.ui.e$g */
    public static final class C5500g {
        private C5500g() {
        }
    }

    /* renamed from: com.tencent.mm.ui.e$h */
    public static final class C5501h {
        public static int yfZ = 0;
        public static int yga = 1;
        public static int ygb = 2;
    }

    /* renamed from: com.tencent.mm.ui.e$i */
    public static final class C5502i {
        public static final String evO = null;
    }

    /* renamed from: com.tencent.mm.ui.e$j */
    public static final class C5503j {
        public static String ygc = "trust_friend_show_tips";
    }

    /* renamed from: com.tencent.mm.ui.e$k */
    public static final class C5504k {
        public static final String ygd = ("Kdescription" + System.currentTimeMillis());

        static {
            AppMethodBeat.m2504i(105953);
            AppMethodBeat.m2505o(105953);
        }
    }

    /* renamed from: com.tencent.mm.ui.e$l */
    public interface C5505l {
        public static final String hmI = (C4996ah.getPackageName() + ":tools");
        public static final String iRj = C4996ah.getPackageName();
    }

    /* renamed from: com.tencent.mm.ui.e$m */
    public static final class C5506m {
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

        private C5506m() {
        }
    }

    public static String aqC(String str) {
        AppMethodBeat.m2504i(105954);
        String str2 = str + "_" + System.currentTimeMillis();
        AppMethodBeat.m2505o(105954);
        return str2;
    }
}
