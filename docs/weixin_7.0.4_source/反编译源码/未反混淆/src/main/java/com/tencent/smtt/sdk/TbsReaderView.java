package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.a.d;
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
    static boolean f = false;
    public static String gReaderPackName = "";
    public static String gReaderPackVersion = "";
    Context a = null;
    ReaderWizard b = null;
    Object c = null;
    ReaderCallback d = null;
    ReaderCallback e = null;

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
        AppMethodBeat.i(64554);
        if (context instanceof Activity) {
            this.d = readerCallback;
            this.a = context;
            this.e = new bb(this);
            AppMethodBeat.o(64554);
            return;
        }
        RuntimeException runtimeException = new RuntimeException("error: unexpect context(none Activity)");
        AppMethodBeat.o(64554);
        throw runtimeException;
    }

    static boolean a(Context context) {
        AppMethodBeat.i(64555);
        if (!f) {
            o.a(true).a(context.getApplicationContext(), true, false, null);
            f = o.a(false).b();
        }
        boolean z = f;
        AppMethodBeat.o(64555);
        return z;
    }

    public static Drawable getResDrawable(Context context, int i) {
        AppMethodBeat.i(64559);
        Drawable drawable = null;
        if (a(context)) {
            drawable = ReaderWizard.getResDrawable(i);
        }
        AppMethodBeat.o(64559);
        return drawable;
    }

    public static String getResString(Context context, int i) {
        AppMethodBeat.i(64560);
        String str = "";
        if (a(context)) {
            str = ReaderWizard.getResString(i);
        }
        AppMethodBeat.o(64560);
        return str;
    }

    public static boolean isSupportExt(Context context, String str) {
        boolean z = false;
        AppMethodBeat.i(64556);
        if (a(context) && ReaderWizard.isSupportCurrentPlatform(context) && ReaderWizard.isSupportExt(str)) {
            z = true;
        }
        AppMethodBeat.o(64556);
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean a() {
        boolean z = false;
        AppMethodBeat.i(64566);
        try {
            if (this.b == null) {
                this.b = new ReaderWizard(this.e);
            }
            if (this.c == null) {
                this.c = this.b.getTbsReader();
            }
            if (this.c != null) {
                z = this.b.initTbsReader(this.c, this.a);
            }
        } catch (NullPointerException e) {
        }
        AppMethodBeat.o(64566);
        return z;
    }

    public void doCommand(Integer num, Object obj, Object obj2) {
        AppMethodBeat.i(64562);
        if (!(this.b == null || this.c == null)) {
            this.b.doCommand(this.c, num, obj, obj2);
        }
        AppMethodBeat.o(64562);
    }

    public boolean downloadPlugin(String str) {
        AppMethodBeat.i(64558);
        if (this.c == null) {
            AppMethodBeat.o(64558);
            return false;
        }
        boolean checkPlugin = this.b.checkPlugin(this.c, this.a, str, true);
        AppMethodBeat.o(64558);
        return checkPlugin;
    }

    public void onSizeChanged(int i, int i2) {
        AppMethodBeat.i(64563);
        if (!(this.b == null || this.c == null)) {
            this.b.onSizeChanged(this.c, i, i2);
        }
        AppMethodBeat.o(64563);
    }

    public void onStop() {
        AppMethodBeat.i(64564);
        if (this.b != null) {
            this.b.destroy(this.c);
            this.c = null;
        }
        this.a = null;
        f = false;
        AppMethodBeat.o(64564);
    }

    public void openFile(Bundle bundle) {
        int i = 1;
        AppMethodBeat.i(64561);
        if (this.c == null || bundle == null) {
            AppMethodBeat.o(64561);
            return;
        }
        bundle.putBoolean("browser6.0", (!d.b(this.a) ? 1 : 0) | d.c(this.a));
        boolean a = d.a(this.a, 6101625, 610000);
        if (d.b(this.a)) {
            i = 0;
        }
        bundle.putBoolean("browser6.1", a | i);
        this.b.openFile(this.c, this.a, bundle, this);
        AppMethodBeat.o(64561);
    }

    public boolean preOpen(String str, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(64557);
        if (isSupportExt(this.a, str)) {
            boolean a = a(this.a);
            if (a) {
                a = a();
                if (z && a) {
                    if (Apn.getApnType(this.a) == 3) {
                        z2 = true;
                    }
                    z2 = this.b.checkPlugin(this.c, this.a, str, z2);
                    AppMethodBeat.o(64557);
                }
            }
            z2 = a;
            AppMethodBeat.o(64557);
        } else {
            AppMethodBeat.o(64557);
        }
        return z2;
    }

    public void userStatistics(String str) {
        AppMethodBeat.i(64565);
        if (this.b != null) {
            this.b.userStatistics(this.c, str);
        }
        AppMethodBeat.o(64565);
    }
}
