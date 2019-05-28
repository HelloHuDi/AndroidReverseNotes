package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Arrays;

public class NativeDataSourceFactory {
    private static final String TAG = "NativeDataSourceFactory";
    private static final boolean soLoaded;

    public static native long localFile(String str, int i);

    static {
        AppMethodBeat.m2504i(128369);
        boolean loadAll = NativeLibs.loadAll(Arrays.asList(new NativeLibs[]{NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.FFmpeg}));
        soLoaded = loadAll;
        if (!loadAll) {
            Logger.m71021e(TAG, "[static initializer] failed to load so!");
        }
        AppMethodBeat.m2505o(128369);
    }

    public static INativeDataSource fileDataSource(final String str) {
        AppMethodBeat.m2504i(128367);
        C242491 c242491 = new INativeDataSource() {
            public final long getNativeInstance() {
                long j = 0;
                AppMethodBeat.m2504i(128366);
                if (NativeDataSourceFactory.soLoaded) {
                    try {
                        j = NativeDataSourceFactory.localFile(str, 0);
                        AppMethodBeat.m2505o(128366);
                    } catch (Throwable th) {
                        Logger.m71022e(NativeDataSourceFactory.TAG, "[getNativeInstance] failed to create native data source!", th);
                        AppMethodBeat.m2505o(128366);
                    }
                } else {
                    Logger.m71027w(NativeDataSourceFactory.TAG, "[getNativeInstance] so not loaded properly!");
                    AppMethodBeat.m2505o(128366);
                }
                return j;
            }

            public final AudioType getAudioType() {
                return null;
            }
        };
        AppMethodBeat.m2505o(128367);
        return c242491;
    }

    public static INativeDataSource fileDataSource(final String str, final int i) {
        AppMethodBeat.m2504i(128368);
        C242502 c242502 = new INativeDataSource() {
            public final long getNativeInstance() {
                long j = 0;
                AppMethodBeat.m2504i(128361);
                if (NativeDataSourceFactory.soLoaded) {
                    try {
                        j = NativeDataSourceFactory.localFile(str, i > 0 ? 1 : 0);
                        AppMethodBeat.m2505o(128361);
                    } catch (Throwable th) {
                        Logger.m71022e(NativeDataSourceFactory.TAG, "[getNativeInstance] failed to create native data source!", th);
                        AppMethodBeat.m2505o(128361);
                    }
                } else {
                    Logger.m71027w(NativeDataSourceFactory.TAG, "[getNativeInstance] so not loaded properly!");
                    AppMethodBeat.m2505o(128361);
                }
                return j;
            }

            public final AudioType getAudioType() {
                return null;
            }
        };
        AppMethodBeat.m2505o(128368);
        return c242502;
    }
}
