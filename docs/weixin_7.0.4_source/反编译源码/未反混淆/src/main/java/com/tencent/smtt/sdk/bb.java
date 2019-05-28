package com.tencent.smtt.sdk;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.smtt.sdk.a.d;

class bb implements ReaderCallback {
    final /* synthetic */ TbsReaderView a;

    bb(TbsReaderView tbsReaderView) {
        this.a = tbsReaderView;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        Bundle bundle = null;
        int i = 0;
        AppMethodBeat.i(64553);
        String resString;
        String str;
        Bundle bundle2;
        switch (num.intValue()) {
            case ReaderCallback.READER_PDF_LIST /*5008*/:
                if (!d.c(this.a.a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.a.a, ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_PDF_ID);
                    this.a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG);
                    break;
                }
                str = "";
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.a.a, str, 4, 0, "pdf", bundle);
                this.a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER);
            case ReaderCallback.READER_PPT_PLAY_MODEL /*5009*/:
                if (!d.c(this.a.a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.a.a, ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_PPT_ID);
                    this.a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG);
                    break;
                }
                str = "";
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.a.a, str, 4, 0, "", bundle);
                this.a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER);
            case ReaderCallback.READER_TXT_READING_MODEL /*5010*/:
                if (!d.c(this.a.a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.a.a, ReaderCallback.READER_PLUGIN_RES_TXT_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_TXT_ID);
                    this.a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG);
                    break;
                }
                str = "";
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.a.a, str, 4, 0, "txt", bundle);
            case ReaderCallback.READER_SEARCH_IN_DOCUMENT /*5026*/:
                if (!d.c(this.a.a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.a.a, ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_DOC_ID);
                    this.a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG);
                    break;
                }
                str = "";
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.a.a, str, 4, 0, "doc", bundle);
                this.a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER);
            case ReaderCallback.READER_PLUGIN_SO_VERSION /*5030*/:
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    TbsReaderView.gReaderPackName = bundle2.getString("name");
                    TbsReaderView.gReaderPackVersion = bundle2.getString("version");
                }
                i = 1;
                break;
        }
        i = 1;
        if (this.a.d != null && i == 0) {
            this.a.d.onCallBackAction(num, obj, obj2);
        }
        AppMethodBeat.o(64553);
    }
}
