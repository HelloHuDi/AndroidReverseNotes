package com.tencent.smtt.export.external.interfaces;

public interface IX5WebBackForwardListClient {
    void onIndexChanged(IX5WebHistoryItem iX5WebHistoryItem, int i);

    void onNewHistoryItem(IX5WebHistoryItem iX5WebHistoryItem);

    void onRemoveHistoryItem(IX5WebHistoryItem iX5WebHistoryItem);
}
