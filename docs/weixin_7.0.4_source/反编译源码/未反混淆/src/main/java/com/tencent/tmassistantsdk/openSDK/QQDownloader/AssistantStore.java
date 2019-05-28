package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.net.Uri;
import android.provider.BaseColumns;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AssistantStore {
    public static final String AUTHORITY = "com.tencent.android.qqdownloader.provider";

    public static final class DownloadInfos implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.android.qqdownloader.provider/downloadsinfo?notify=true");

        public interface DownloadInfoColumns {
            public static final String APKID = "apkId";
            public static final String APPURLS = "apkUrl";
            public static final String CHANNELID = "channelId";
            public static final String FILEPATH = "filePath";
            public static final String PACKAGENAME = "packageName";
            public static final String RECEIVEDLENGTH = "received_length";
            public static final String STATE = "state";
            public static final String TOTALLENGTH = "total_length";
            public static final String VERSIONCODE = "versionCode";
        }

        static {
            AppMethodBeat.i(75850);
            AppMethodBeat.o(75850);
        }
    }
}
