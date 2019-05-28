package com.tencent.qqmusic.mediaplayer.upstream;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DefaultFileDataSourceFactory implements IDataSourceFactory {
    private final String filePath;

    public DefaultFileDataSourceFactory(String str) {
        this.filePath = str;
    }

    public IDataSource createDataSource() {
        AppMethodBeat.i(128353);
        if (TextUtils.isEmpty(this.filePath)) {
            DataSourceException dataSourceException = new DataSourceException(-5, "filePath is empty!", null);
            AppMethodBeat.o(128353);
            throw dataSourceException;
        }
        FileDataSource fileDataSource = new FileDataSource(this.filePath);
        AppMethodBeat.o(128353);
        return fileDataSource;
    }

    public INativeDataSource createNativeDataSource() {
        AppMethodBeat.i(128354);
        INativeDataSource fileDataSource = NativeDataSourceFactory.fileDataSource(this.filePath, 0);
        AppMethodBeat.o(128354);
        return fileDataSource;
    }
}
