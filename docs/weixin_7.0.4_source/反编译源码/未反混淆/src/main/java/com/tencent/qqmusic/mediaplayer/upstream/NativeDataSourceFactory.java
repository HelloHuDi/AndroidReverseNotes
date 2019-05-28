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
        AppMethodBeat.i(128369);
        boolean loadAll = NativeLibs.loadAll(Arrays.asList(new NativeLibs[]{NativeLibs.audioCommon, NativeLibs.formatDetector, NativeLibs.codecFactory, NativeLibs.decoderJni, NativeLibs.cppShared, NativeLibs.stlportShared, NativeLibs.xlog, NativeLibs.FFmpeg}));
        soLoaded = loadAll;
        if (!loadAll) {
            Logger.e(TAG, "[static initializer] failed to load so!");
        }
        AppMethodBeat.o(128369);
    }

    public static INativeDataSource fileDataSource(final String str) {
        AppMethodBeat.i(128367);
        AnonymousClass1 anonymousClass1 = new INativeDataSource() {
            public final long getNativeInstance() {
                long j = 0;
                AppMethodBeat.i(128366);
                if (NativeDataSourceFactory.soLoaded) {
                    try {
                        j = NativeDataSourceFactory.localFile(str, 0);
                        AppMethodBeat.o(128366);
                    } catch (Throwable th) {
                        Logger.e(NativeDataSourceFactory.TAG, "[getNativeInstance] failed to create native data source!", th);
                        AppMethodBeat.o(128366);
                    }
                } else {
                    Logger.w(NativeDataSourceFactory.TAG, "[getNativeInstance] so not loaded properly!");
                    AppMethodBeat.o(128366);
                }
                return j;
            }

            public final AudioType getAudioType() {
                return null;
            }
        };
        AppMethodBeat.o(128367);
        return anonymousClass1;
    }

    public static INativeDataSource fileDataSource(final String str, final int i) {
        AppMethodBeat.i(128368);
        AnonymousClass2 anonymousClass2 = new INativeDataSource() {
            public final long getNativeInstance() {
                long j = 0;
                AppMethodBeat.i(128361);
                if (NativeDataSourceFactory.soLoaded) {
                    try {
                        j = NativeDataSourceFactory.localFile(str, i > 0 ? 1 : 0);
                        AppMethodBeat.o(128361);
                    } catch (Throwable th) {
                        Logger.e(NativeDataSourceFactory.TAG, "[getNativeInstance] failed to create native data source!", th);
                        AppMethodBeat.o(128361);
                    }
                } else {
                    Logger.w(NativeDataSourceFactory.TAG, "[getNativeInstance] so not loaded properly!");
                    AppMethodBeat.o(128361);
                }
                return j;
            }

            public final AudioType getAudioType() {
                return null;
            }
        };
        AppMethodBeat.o(128368);
        return anonymousClass2;
    }
}
