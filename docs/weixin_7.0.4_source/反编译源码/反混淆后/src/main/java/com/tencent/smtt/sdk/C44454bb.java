package com.tencent.smtt.sdk;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.smtt.sdk.p1104a.C24262d;

/* renamed from: com.tencent.smtt.sdk.bb */
class C44454bb implements ReaderCallback {
    /* renamed from: a */
    final /* synthetic */ TbsReaderView f17297a;

    C44454bb(TbsReaderView tbsReaderView) {
        this.f17297a = tbsReaderView;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        Bundle bundle = null;
        int i = 0;
        AppMethodBeat.m2504i(64553);
        String resString;
        String str;
        Bundle bundle2;
        switch (num.intValue()) {
            case ReaderCallback.READER_PDF_LIST /*5008*/:
                if (!C24262d.m37427c(this.f17297a.f1388a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.f17297a.f1388a, ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_PDF_ID);
                    this.f17297a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_DIALOG);
                    break;
                }
                str = "";
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.f17297a.f1388a, str, 4, 0, "pdf", bundle);
                this.f17297a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PDF_INTO_BROWSER);
            case ReaderCallback.READER_PPT_PLAY_MODEL /*5009*/:
                if (!C24262d.m37427c(this.f17297a.f1388a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.f17297a.f1388a, ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_PPT_ID);
                    this.f17297a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_DIALOG);
                    break;
                }
                str = "";
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.f17297a.f1388a, str, 4, 0, "", bundle);
                this.f17297a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_PPT_INTO_BROWSER);
            case ReaderCallback.READER_TXT_READING_MODEL /*5010*/:
                if (!C24262d.m37427c(this.f17297a.f1388a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.f17297a.f1388a, ReaderCallback.READER_PLUGIN_RES_TXT_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_TXT_ID);
                    this.f17297a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_TXT_INTO_DIALOG);
                    break;
                }
                str = "";
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.f17297a.f1388a, str, 4, 0, "txt", bundle);
            case ReaderCallback.READER_SEARCH_IN_DOCUMENT /*5026*/:
                if (!C24262d.m37427c(this.f17297a.f1388a)) {
                    num = Integer.valueOf(ReaderCallback.INSTALL_QB);
                    resString = TbsReaderView.getResString(this.f17297a.f1388a, ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE);
                    obj = new Bundle();
                    obj.putString("tip", resString);
                    obj.putString("statistics", TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DOWNLOAD);
                    obj.putInt("channel_id", TbsReaderView.READER_CHANNEL_DOC_ID);
                    this.f17297a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_DIALOG);
                    break;
                }
                str = "";
                if (obj != null) {
                    bundle2 = (Bundle) obj;
                    str = bundle2.getString("docpath");
                    bundle = bundle2;
                }
                QbSdk.startQBForDoc(this.f17297a.f1388a, str, 4, 0, "doc", bundle);
                this.f17297a.userStatistics(TbsReaderView.READER_STATISTICS_COUNT_DOC_INTO_BROWSER);
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
        if (this.f17297a.f1391d != null && i == 0) {
            this.f17297a.f1391d.onCallBackAction(num, obj, obj2);
        }
        AppMethodBeat.m2505o(64553);
    }
}
