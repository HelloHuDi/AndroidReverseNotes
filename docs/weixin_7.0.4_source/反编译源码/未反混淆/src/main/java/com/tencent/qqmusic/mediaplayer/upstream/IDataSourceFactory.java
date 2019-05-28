package com.tencent.qqmusic.mediaplayer.upstream;

public interface IDataSourceFactory {
    IDataSource createDataSource();

    INativeDataSource createNativeDataSource();
}
