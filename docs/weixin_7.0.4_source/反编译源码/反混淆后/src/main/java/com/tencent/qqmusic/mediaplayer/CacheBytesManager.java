package com.tencent.qqmusic.mediaplayer;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class CacheBytesManager {
    private static byte[] mCache1024 = null;
    private static byte[] mCache4096 = null;
    private static byte[] mCache8192 = null;

    static class SingletonHolder {
        private static final CacheBytesManager INSTANCE = new CacheBytesManager(262144);

        private SingletonHolder() {
        }

        static {
            AppMethodBeat.m2504i(128393);
            AppMethodBeat.m2505o(128393);
        }
    }

    private CacheBytesManager(int i) {
    }

    public static CacheBytesManager getInstance() {
        AppMethodBeat.m2504i(128439);
        CacheBytesManager access$000 = SingletonHolder.INSTANCE;
        AppMethodBeat.m2505o(128439);
        return access$000;
    }

    public static synchronized byte[] recycle(byte[] bArr) {
        synchronized (CacheBytesManager.class) {
            if (bArr != null) {
                if (bArr.length == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && mCache1024 == null) {
                    mCache1024 = bArr;
                } else if (bArr.length == 4096 && mCache4096 == null) {
                    mCache4096 = bArr;
                } else if (bArr.length == Utility.DEFAULT_STREAM_BUFFER_SIZE && mCache8192 == null) {
                    mCache8192 = bArr;
                }
            }
        }
        return null;
    }

    public static synchronized byte[] getStatic(int i) {
        byte[] bArr;
        synchronized (CacheBytesManager.class) {
            AppMethodBeat.m2504i(128440);
            Logger.m71020d("CBM", "cache get:".concat(String.valueOf(i)));
            if (i != WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || mCache1024 == null) {
                if (i == 4096) {
                    if (mCache4096 != null) {
                        bArr = mCache4096;
                        mCache4096 = null;
                        AppMethodBeat.m2505o(128440);
                    }
                }
                if (i == Utility.DEFAULT_STREAM_BUFFER_SIZE) {
                    if (mCache8192 != null) {
                        bArr = mCache8192;
                        mCache8192 = null;
                        AppMethodBeat.m2505o(128440);
                    }
                }
                bArr = new byte[i];
                AppMethodBeat.m2505o(128440);
            } else {
                bArr = mCache1024;
                mCache1024 = null;
                AppMethodBeat.m2505o(128440);
            }
        }
        return bArr;
    }
}
