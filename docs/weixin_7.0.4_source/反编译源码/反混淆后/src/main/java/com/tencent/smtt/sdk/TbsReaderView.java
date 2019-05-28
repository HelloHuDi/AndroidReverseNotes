package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.p1104a.C24262d;
import com.tencent.smtt.utils.Apn;

public class TbsReaderView extends FrameLayout {
    public static final String IS_BAR_ANIMATING = "is_bar_animating";
    public static final String IS_BAR_SHOWING = "is_bar_show";
    public static final String IS_INTO_DOWNLOADING = "into_downloading";
    public static final String KEY_FILE_PATH = "filePath";
    public static final String KEY_TEMP_PATH = "tempPath";
    public static final int READER_CHANNEL_DOC_ID = 10965;
    public static final int READER_CHANNEL_PDF_ID = 10834;
    public static final int READER_CHANNEL_PPT_ID = 10833;
    public static final int READER_CHANNEL_TXT_ID = 10835;
    public static final String READER_STATISTICS_COUNT_CANCEL_LOADED_BTN = "AHNG802";
    public static final String READER_STATISTICS_COUNT_CLICK_LOADED_BTN = "AHNG801";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_BROWSER = "AHNG829";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DIALOG = "AHNG827";
    public static final String READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD = "AHNG828";
    public static final String READER_STATISTICS_COUNT_DOC_SEARCH_BTN = "AHNG826";
    public static final String READER_STATISTICS_COUNT_PDF_FOLDER_BTN = "AHNG810";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_BROWSER = "AHNG813";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DIALOG = "AHNG811";
    public static final String READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD = "AHNG812";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_BROWSER = "AHNG809";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DIALOG = "AHNG807";
    public static final String READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD = "AHNG808";
    public static final String READER_STATISTICS_COUNT_PPT_PLAY_BTN = "AHNG806";
    public static final String READER_STATISTICS_COUNT_RETRY_BTN = "AHNG803";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_BROWSER = "AHNG817";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DIALOG = "AHNG815";
    public static final String READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD = "AHNG816";
    public static final String READER_STATISTICS_COUNT_TXT_NOVEL_BTN = "AHNG814";
    public static final String TAG = "TbsReaderView";
    /* renamed from: f */
    static boolean f1387f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";
    /* renamed from: a */
    Context f1388a = null;
    /* renamed from: b */
    ReaderWizard f1389b = null;
    /* renamed from: c */
    Object f1390c = null;
    /* renamed from: d */
    ReaderCallback f1391d = null;
    /* renamed from: e */
    ReaderCallback f1392e = null;

    public interface ReaderCallback {
        public static final int COPY_SELECT_TEXT = 5003;
        public static final int GET_BAR_ANIMATING = 5000;
        public static final int GET_BAR_ISSHOWING = 5024;
        public static final int HIDDEN_BAR = 5001;
        public static final int INSTALL_QB = 5011;
        public static final int NOTIFY_CANDISPLAY = 12;
        public static final int NOTIFY_ERRORCODE = 19;
        public static final int READER_OPEN_QQ_FILE_LIST = 5031;
        public static final int READER_PDF_LIST = 5008;
        public static final int READER_PLUGIN_ACTIVITY_PAUSE = 5032;
        public static final int READER_PLUGIN_CANLOAD = 5013;
        public static final int READER_PLUGIN_COMMAND_FIXSCREEN = 5015;
        public static final int READER_PLUGIN_COMMAND_PDF_LIST = 5036;
        public static final int READER_PLUGIN_COMMAND_PPT_PLAYER = 5035;
        public static final int READER_PLUGIN_COMMAND_ROTATESCREEN = 5018;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND = 5038;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_CLEAR = 5041;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_NEXT = 5039;
        public static final int READER_PLUGIN_COMMAND_TEXT_FIND_PREV = 5040;
        public static final int READER_PLUGIN_DOWNLOADING = 5014;
        public static final int READER_PLUGIN_RES_DOC_GUIDE = 5029;
        public static final int READER_PLUGIN_RES_FIXSCREEN_NORMAL = 5016;
        public static final int READER_PLUGIN_RES_FIXSCREEN_PRESS = 5017;
        public static final int READER_PLUGIN_RES_PDF_GUIDE = 5023;
        public static final int READER_PLUGIN_RES_PPT_GUIDE = 5021;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_NORMAL = 5019;
        public static final int READER_PLUGIN_RES_ROTATESCREEN_PRESS = 5020;
        public static final int READER_PLUGIN_RES_TXT_GUIDE = 5022;
        public static final int READER_PLUGIN_SO_ERR = 5025;
        public static final int READER_PLUGIN_SO_INTO_START = 5027;
        public static final int READER_PLUGIN_SO_PROGRESS = 5028;
        public static final int READER_PLUGIN_SO_VERSION = 5030;
        public static final int READER_PLUGIN_STATUS = 5012;
        public static final int READER_PLUGIN_TEXT_FIND_RESULT = 5042;
        public static final int READER_PPT_PLAY_MODEL = 5009;
        public static final int READER_SEARCH_IN_DOCUMENT = 5026;
        public static final int READER_TOAST = 5005;
        public static final int READER_TXT_READING_MODEL = 5010;
        public static final int SEARCH_SELECT_TEXT = 5004;
        public static final int SHOW_BAR = 5002;
        public static final int SHOW_DIALOG = 5006;

        void onCallBackAction(Integer num, Object obj, Object obj2);
    }

    public TbsReaderView(Context context, ReaderCallback readerCallback) {
        super(context.getApplicationContext());
        AppMethodBeat.m2504i(64554);
        if (context instanceof Activity) {
            this.f1391d = readerCallback;
            this.f1388a = context;
            this.f1392e = new C44454bb(this);
            AppMethodBeat.m2505o(64554);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("error: unexpect context(none Activity)");
        AppMethodBeat.m2505o(64554);
        throw runtimeException;
    }

    /* renamed from: a */
    static boolean m8789a(Context context) {
        AppMethodBeat.m2504i(64555);
        if (!f1387f) {
            C5818o.m8863a(true).mo12196a(context.getApplicationContext(), true, false, null);
            f1387f = C5818o.m8863a(false).mo12198b();
        }
        boolean z = f1387f;
        AppMethodBeat.m2505o(64555);
        return z;
    }

    public static Drawable getResDrawable(Context context, int i) {
        AppMethodBeat.m2504i(64559);
        Drawable drawable = null;
        if (m8789a(context)) {
            drawable = ReaderWizard.getResDrawable(i);
        }
        AppMethodBeat.m2505o(64559);
        return drawable;
    }

    public static String getResString(Context context, int i) {
        AppMethodBeat.m2504i(64560);
        String str = "";
        if (m8789a(context)) {
            str = ReaderWizard.getResString(i);
        }
        AppMethodBeat.m2505o(64560);
        return str;
    }

    public static boolean isSupportExt(Context context, String str) {
        boolean z = false;
        AppMethodBeat.m2504i(64556);
        if (m8789a(context) && ReaderWizard.isSupportCurrentPlatform(context) && ReaderWizard.isSupportExt(str)) {
            z = true;
        }
        AppMethodBeat.m2505o(64556);
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public boolean mo12127a() {
        boolean z = false;
        AppMethodBeat.m2504i(64566);
        try {
            if (this.f1389b == null) {
                this.f1389b = new ReaderWizard(this.f1392e);
            }
            if (this.f1390c == null) {
                this.f1390c = this.f1389b.getTbsReader();
            }
            if (this.f1390c != null) {
                z = this.f1389b.initTbsReader(this.f1390c, this.f1388a);
            }
        } catch (NullPointerException e) {
        }
        AppMethodBeat.m2505o(64566);
        return z;
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        AppMethodBeat.m2504i(64562);
        if (!(this.f1389b == null || this.f1390c == null)) {
            this.f1389b.doCommand(this.f1390c, num, obj, obj2);
        }
        AppMethodBeat.m2505o(64562);
    }

    public boolean downloadPlugin(String str) {
        AppMethodBeat.m2504i(64558);
        if (this.f1390c == null) {
            AppMethodBeat.m2505o(64558);
            return false;
        }
        boolean checkPlugin = this.f1389b.checkPlugin(this.f1390c, this.f1388a, str, true);
        AppMethodBeat.m2505o(64558);
        return checkPlugin;
    }

    public void onSizeChanged(int i, int i2) {
        AppMethodBeat.m2504i(64563);
        if (!(this.f1389b == null || this.f1390c == null)) {
            this.f1389b.onSizeChanged(this.f1390c, i, i2);
        }
        AppMethodBeat.m2505o(64563);
    }

    public void onStop() {
        AppMethodBeat.m2504i(64564);
        if (this.f1389b != null) {
            this.f1389b.destroy(this.f1390c);
            this.f1390c = null;
        }
        this.f1388a = null;
        f1387f = false;
        AppMethodBeat.m2505o(64564);
    }

    public void openFile(Bundle bundle) {
        int i = 1;
        AppMethodBeat.m2504i(64561);
        if (this.f1390c == null || bundle == null) {
            AppMethodBeat.m2505o(64561);
            return;
        }
        bundle.putBoolean("browser6.0", (!C24262d.m37426b(this.f1388a) ? 1 : 0) | C24262d.m37427c(this.f1388a));
        boolean a = C24262d.m37422a(this.f1388a, 6101625, 610000);
        if (C24262d.m37426b(this.f1388a)) {
            i = 0;
        }
        bundle.putBoolean("browser6.1", a | i);
        this.f1389b.openFile(this.f1390c, this.f1388a, bundle, this);
        AppMethodBeat.m2505o(64561);
    }

    public boolean preOpen(String str, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(64557);
        if (isSupportExt(this.f1388a, str)) {
            boolean a = m8789a(this.f1388a);
            if (a) {
                a = mo12127a();
                if (z && a) {
                    if (Apn.getApnType(this.f1388a) == 3) {
                        z2 = true;
                    }
                    z2 = this.f1389b.checkPlugin(this.f1390c, this.f1388a, str, z2);
                    AppMethodBeat.m2505o(64557);
                }
            }
            z2 = a;
            AppMethodBeat.m2505o(64557);
        } else {
            AppMethodBeat.m2505o(64557);
        }
        return z2;
    }

    public void userStatistics(String str) {
        AppMethodBeat.m2504i(64565);
        if (this.f1389b != null) {
            this.f1389b.userStatistics(this.f1390c, str);
        }
        AppMethodBeat.m2505o(64565);
    }
}
